Function multiplayer_list_serverlistudpmsgs%()
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4.servers
    Local local5%
    Local local6$
    Local local7%
    Local local8%
    Local local9%
    If (server_list_stream = $00) Then
        Return $FFFFFFFF
    EndIf
    local3 = $00
    While (recvudpmsg(server_list_stream) <> 0)
        local0 = udpmsgip(server_list_stream)
        local1 = udpmsgport(server_list_stream)
        For local4 = Each servers
            If ((((local4\Field18 = local0) And (local4\Field2 = (Str local1))) And (local4\Field11 <> $00)) <> 0) Then
                local4\Field4 = (Int max(5.0, (Float (millisecs() - local4\Field11))))
                local5 = createbank($04)
                readbytes(local5, server_list_stream, $00, $04)
                If (peekint(local5, $00) <> $236357) Then
                    local6 = ""
                    local7 = $00
                    local8 = $00
                    Repeat
                        local8 = peekbyte(local5, local7)
                        If (((local8 = $00) Or (local8 = $0A)) <> 0) Then
                            Exit
                        EndIf
                        If (local8 <> $0D) Then
                            local6 = (local6 + chr(local8))
                        EndIf
                        local7 = (local7 + $01)
                        If (local7 >= $04) Then
                            Exit
                        EndIf
                    Forever
                    If (local7 >= $04) Then
                        Repeat
                            local8 = readbyte(server_list_stream)
                            If (((local8 = $00) Or (local8 = $0A)) <> 0) Then
                                Exit
                            EndIf
                            If (local8 <> $0D) Then
                                local6 = (local6 + chr(local8))
                            EndIf
                        Forever
                    EndIf
                    local4\Field10 = local6
                    local4\Field6 = readline(server_list_stream)
                    local4\Field7 = readbyte(server_list_stream)
                    local4\Field8 = readbyte(server_list_stream)
                    local4\Field3 = readline(server_list_stream)
                    local4\Field16 = readbyte(server_list_stream)
                    local4\Field19 = readbyte(server_list_stream)
                    If (local4\Field3 <> "") Then
                        local4\Field9 = "Password"
                    EndIf
                    local4\Field5 = readline(server_list_stream)
                    local4\Field20 = readline(server_list_stream)
                    local4\Field9 = readline(server_list_stream)
                    local4\Field21 = readline(server_list_stream)
                    local4\Field22 = left(readline(server_list_stream), $80)
                    If (local4\Field5 = "") Then
                        local4\Field5 = "Site 19"
                    EndIf
                    If (local4\Field20 = "") Then
                        local4\Field20 = "No description"
                    EndIf
                    If (local4\Field22 <> "") Then
                        If (instr(local4\Field22, ".", $01) <> 0) Then
                            If (instr(local4\Field22, "http", $01) = $00) Then
                                local4\Field22 = ("http://" + local4\Field22)
                            EndIf
                        Else
                            local4\Field22 = ""
                        EndIf
                    EndIf
                    If (local4\Field9 = "") Then
                        If (local4\Field8 <> 0) Then
                            local4\Field9 = "Started"
                        Else
                            local4\Field9 = "In lobby"
                        EndIf
                    EndIf
                    If (local4\Field21 = "") Then
                        local4\Field21 = "Unknown"
                    EndIf
                    local4\Field23 = (Int left(local4\Field6, $03))
                    If (local4\Field0 = $04) Then
                        local4\Field15 = $00
                    EndIf
                    local3 = $00
                    For local9 = $00 To $13 Step $01
                        local4\Field24[local9] = ""
                    Next
                    Repeat
                        local2 = readline(server_list_stream)
                        If (((local2 = "") Or (local3 >= $14)) <> 0) Then
                            Exit
                        EndIf
                        local4\Field24[local3] = local2
                        local3 = (local3 + $01)
                        If (local3 >= $14) Then
                            Exit
                        EndIf
                    Forever
                    If (readavail(server_list_stream) > $00) Then
                        local4\Field25 = readbyte(server_list_stream)
                    Else
                        local4\Field25 = $01
                    EndIf
                Else
                    Select readbyte(server_list_stream)
                        Case $01
                            local4\Field10 = readline(server_list_stream)
                            local4\Field6 = readline(server_list_stream)
                            local4\Field7 = readbyte(server_list_stream)
                            local4\Field8 = readbyte(server_list_stream)
                            If (readbyte(server_list_stream) <> 0) Then
                                local4\Field9 = "Password"
                            EndIf
                            local4\Field16 = readbyte(server_list_stream)
                            local4\Field19 = readbyte(server_list_stream)
                            local4\Field5 = readline(server_list_stream)
                            local4\Field9 = readline(server_list_stream)
                            local4\Field23 = (Int left(local4\Field6, $03))
                            If (local4\Field9 = "") Then
                                If (local4\Field8 <> 0) Then
                                    local4\Field9 = "Started"
                                Else
                                    local4\Field9 = "In lobby"
                                EndIf
                            EndIf
                            If (local4\Field5 = "") Then
                                local4\Field5 = "Site 19"
                            EndIf
                            If (readavail(server_list_stream) > $00) Then
                                local4\Field25 = readbyte(server_list_stream)
                            Else
                                local4\Field25 = $01
                            EndIf
                        Case $02
                            local4\Field20 = readline(server_list_stream)
                            local4\Field21 = readline(server_list_stream)
                            local4\Field22 = left(readline(server_list_stream), $80)
                            If (local4\Field21 = "") Then
                                local4\Field21 = "Unknown"
                            EndIf
                            If (local4\Field22 <> "") Then
                                If (instr(local4\Field22, ".", $01) <> 0) Then
                                    If (instr(local4\Field22, "http", $01) = $00) Then
                                        local4\Field22 = ("http://" + local4\Field22)
                                    EndIf
                                Else
                                    local4\Field22 = ""
                                EndIf
                            EndIf
                            If (local4\Field20 = "") Then
                                local4\Field20 = "No description"
                            EndIf
                        Case $03
                            local3 = $00
                            For local9 = $00 To $13 Step $01
                                local4\Field24[local9] = ""
                            Next
                            Repeat
                                local2 = readline(server_list_stream)
                                If (((local2 = "") Or (local3 >= $14)) <> 0) Then
                                    Exit
                                EndIf
                                local4\Field24[local3] = local2
                                local3 = (local3 + $01)
                            Forever
                    End Select
                EndIf
                freebank(local5)
                If (local4\Field0 = $04) Then
                    local4\Field15 = $00
                EndIf
                local4\Field11 = $00
                Exit
            EndIf
        Next
    Wend
    For local4 = Each servers
        If (local4\Field11 <> $00) Then
            If (local4\Field12 < millisecs()) Then
                local4\Field10 = ((local4\Field1 + ":") + local4\Field2)
                local4\Field4 = $00
                local4\Field5 = "-"
                local4\Field6 = "0 / 0"
                local4\Field9 = "Offline"
                local4\Field21 = "Unknown"
                local4\Field14 = $00
                local4\Field19 = $00
                local4\Field7 = $00
                local4\Field20 = "No description"
                local4\Field11 = $00
                If (local4\Field0 = $04) Then
                    multiplayer_list_deleteserver(local4)
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
