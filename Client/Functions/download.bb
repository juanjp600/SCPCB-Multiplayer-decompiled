Function download%(arg0$, arg1$, arg2$, arg3%)
    Local local0%
    Local local1$
    Local local2%
    Local local3$
    Local local4$
    Local local5%
    Local local6$
    Local local7%
    Local local8%
    Local local9%
    Local local11%
    Local local12%
    Local local13$
    Local local14$
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21$
    local0 = instr(arg0, "://", $01)
    If (local0 <> 0) Then
        arg0 = right(arg0, ((len(arg0) - local0) - $02))
    EndIf
    local0 = instr(arg0, "/", $01)
    If (local0 = $00) Then
        Return $00
    EndIf
    local1 = trim(left(arg0, (local0 - $01)))
    arg0 = trim(right(arg0, ((len(arg0) - local0) + $01)))
    local2 = len(arg0)
    While (local2 >= $01)
        If (mid(arg0, local2, $01) = "/") Then
            local3 = trim(left(arg0, local2))
            local4 = right(arg0, (len(arg0) - local2))
            Exit
        EndIf
        local2 = (local2 + $FFFFFFFF)
    Wend
    If (local4 = "") Then
        Return $00
    EndIf
    If (arg1 = "") Then
        arg1 = local4
    EndIf
    local5 = opentcpstream(local1, arg3, $00)
    If (local5 = $00) Then
        Return $00
    EndIf
    writeline(local5, ((((((((((((((("GET " + local3) + local4) + " HTTP/1.1") + chr($0D)) + chr($0A)) + "Host: ") + local1) + chr($0D)) + chr($0A)) + "User-Agent: SCP-CB Multiplayer Mod") + chr($0D)) + chr($0A)) + "Connection: keep-alive") + chr($0D)) + chr($0A)))
    local6 = readline(local5)
    If (local6 = "") Then
        closetcpstream(local5)
        Return $00
    EndIf
    local7 = instr(local6, " ", $01)
    If (local7 = $00) Then
        closetcpstream(local5)
        Return $00
    EndIf
    local8 = instr(local6, " ", (local7 + $01))
    If (local8 = $00) Then
        closetcpstream(local5)
        Return $00
    EndIf
    local9 = (Int mid(local6, local7, (local8 - local7)))
    Select local9
        Case $C8
            local11 = $FFFFFFFF
            local12 = $00
            Repeat
                local6 = trim(readline(local5))
                If (local6 = "") Then
                    Exit
                EndIf
                local0 = instr(local6, ":", $01)
                local13 = trim(left(local6, (local0 - $01)))
                local14 = trim(right(local6, (len(local6) - local0)))
                Select lower(local13)
                    Case "content-length"
                        local11 = (Int local14)
                    Case "transfer-encoding"
                        If (lower(local14) = "chunked") Then
                            local12 = $01
                        EndIf
                End Select
            Forever
            If (local11 = $00) Then
                local16 = writefile(arg1)
                closefile(local16)
                closetcpstream(local5)
                Return $00
            ElseIf (local11 > $00) Then
                If (filetype(arg1) = $00) Then
                    local16 = writefile(arg1)
                Else
                    local16 = openfile(arg1)
                    seekfile(local16, filesize(arg1))
                EndIf
                local17 = createbank($2000)
                local18 = $00
                Repeat
                    local19 = (local11 - local18)
                    If (local19 > $2000) Then
                        readbytes(local17, local5, $00, $2000)
                        writebytes(local17, local16, $00, $2000)
                        local18 = (local18 + $2000)
                        setbuffer(backbuffer())
                        cls()
                        text($05, $05, ("Downloading " + arg2), $00, $00)
                        color($FF, $FF, $FF)
                        text($05, $A5, ((((Str (floor(((((Float local18) / 1024.0) / 1024.0) * 100.0)) / 100.0)) + "MB out of ") + (Str (floor(((((Float local11) / 1024.0) / 1024.0) * 100.0)) / 100.0))) + "MB downloaded"), $00, $00)
                        rect($0E, $C6, $266, $12, $00)
                        For local2 = $00 To ((Int (((Float local18) / (Float local11)) * 61.0)) - $01) Step $01
                            drawimage(blinkmeterimg, ((local2 * $0A) + $11), $C8, $00)
                        Next
                        text($140, $E6, ((Str (Int (((Float local18) / (Float local11)) * 100.0))) + "%"), $01, $00)
                        If (drawbutton2($10E, $190, $64, $14, "Cancel", $00) <> 0) Then
                            closetcpstream(local5)
                            freebank(local17)
                            closefile(local16)
                            Return $FFFFFFFF
                        EndIf
                        flip($00)
                    Else
                        readbytes(local17, local5, $00, local19)
                        writebytes(local17, local16, $00, local19)
                        Exit
                    EndIf
                Forever
                freebank(local17)
                closefile(local16)
                closetcpstream(local5)
                Return $01
            ElseIf (local12 <> 0) Then
                local16 = writefile(arg1)
                local17 = createbank($2000)
                Repeat
                    local6 = trim(upper(readline(local5)))
                    local20 = $00
                    For local2 = $01 To len(local6) Step $01
                        local20 = ((local20 Shl $04) + instr("123456789ABCDEF", mid(local6, local2, $01), $01))
                    Next
                    If (local20 = $00) Then
                        Exit
                    EndIf
                    If (banksize(local17) < local20) Then
                        resizebank(local17, local20)
                    EndIf
                    readbytes(local17, local5, $00, local20)
                    writebytes(local17, local16, $00, local20)
                    readshort(local5)
                Forever
                freebank(local17)
                closefile(local16)
                closetcpstream(local5)
                Return $01
            Else
                closetcpstream(local5)
                Return $00
            EndIf
        Case $12D,$12E
            Repeat
                local6 = trim(readline(local5))
                If (local6 = "") Then
                    Exit
                EndIf
                local0 = instr(local6, ":", $01)
                local13 = trim(left(local6, (local0 - $01)))
                local14 = trim(right(local6, (len(local6) - local0)))
                local21 = lower(local13)
                If (local21 = "location") Then
                    closetcpstream(local5)
                    Return download(local14, arg1, arg2, $50)
                EndIf
            Forever
        Default
            closetcpstream(local5)
            Return $00
    End Select
    Return $00
End Function
