Function use294%()
    Local local0#
    Local local1#
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16#
    Local local17%
    Local local18.items
    Local local19.events
    showpointer()
    local0 = (Float ((graphicwidth Sar $01) - (imagewidth(panel294) Sar $01)))
    local1 = (Float ((graphicheight Sar $01) - (imageheight(panel294) Sar $01)))
    drawimage(panel294, (Int local0), (Int local1), $00)
    If (fullscreen <> 0) Then
        drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
    EndIf
    local5 = $01
    If (playerroom\Field9 <> $00) Then
        local5 = $00
    EndIf
    aatext((Int (local0 + 907.0)), (Int (local1 + 185.0)), input294, $01, $01, 1.0)
    If (local5 <> 0) Then
        If (mousehit1 <> 0) Then
            local2 = (Int floor(((((Float scaledmousex()) - local0) - 228.0) / 35.5)))
            local3 = (Int floor(((((Float scaledmousey()) - local1) - 342.0) / 36.5)))
            If (((local3 >= $00) And (local3 < $05)) <> 0) Then
                If (((local2 >= $00) And (local2 < $0A)) <> 0) Then
                    playsound_strict(buttonsfx)
                    local4 = ""
                    local5 = $00
                    Select local3
                        Case $00
                            local4 = (Str ((local2 + $01) Mod $0A))
                        Case $01
                            Select local2
                                Case $00
                                    local4 = "Q"
                                Case $01
                                    local4 = "W"
                                Case $02
                                    local4 = "E"
                                Case $03
                                    local4 = "R"
                                Case $04
                                    local4 = "T"
                                Case $05
                                    local4 = "Y"
                                Case $06
                                    local4 = "U"
                                Case $07
                                    local4 = "I"
                                Case $08
                                    local4 = "O"
                                Case $09
                                    local4 = "P"
                            End Select
                        Case $02
                            Select local2
                                Case $00
                                    local4 = "A"
                                Case $01
                                    local4 = "S"
                                Case $02
                                    local4 = "D"
                                Case $03
                                    local4 = "F"
                                Case $04
                                    local4 = "G"
                                Case $05
                                    local4 = "H"
                                Case $06
                                    local4 = "J"
                                Case $07
                                    local4 = "K"
                                Case $08
                                    local4 = "L"
                                Case $09
                                    local5 = $01
                            End Select
                        Case $03
                            Select local2
                                Case $00
                                    local4 = "Z"
                                Case $01
                                    local4 = "X"
                                Case $02
                                    local4 = "C"
                                Case $03
                                    local4 = "V"
                                Case $04
                                    local4 = "B"
                                Case $05
                                    local4 = "N"
                                Case $06
                                    local4 = "M"
                                Case $07
                                    local4 = "-"
                                Case $08
                                    local4 = " "
                                Case $09
                                    input294 = left(input294, (Int max((Float (len(input294) - $01)), 0.0)))
                            End Select
                        Case $04
                            local4 = " "
                    End Select
                EndIf
            EndIf
            input294 = (input294 + local4)
            input294 = left(input294, (Int min((Float len(input294)), 15.0)))
            If ((local5 And (input294 <> "")) <> 0) Then
                input294 = trim(lower(input294))
                If (left(input294, (Int min(7.0, (Float len(input294))))) = "cup of ") Then
                    input294 = right(input294, (len(input294) - $07))
                ElseIf (left(input294, (Int min(9.0, (Float len(input294))))) = "a cup of ") Then
                    input294 = right(input294, (len(input294) - $09))
                EndIf
                If (input294 <> "") Then
                    local10 = getinisectionlocation("DATA\SCP-294.ini", input294)
                EndIf
                If (local10 > $00) Then
                    local4 = getinistring2("DATA\SCP-294.ini", local10, "dispensesound", "")
                    If (local4 = "") Then
                        playerroom\Field9 = playsound_strict(loadtempsound("SFX\SCP\294\dispense1.ogg"))
                        multiplayer_writetempsound("SFX\SCP\294\dispense1.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                    Else
                        playerroom\Field9 = playsound_strict(loadtempsound(local4))
                        multiplayer_writetempsound(local4, 0.0, 0.0, 0.0, 10.0, 1.0)
                    EndIf
                    If (getiniint2("DATA\SCP-294.ini", local10, "explosion", "") = $01) Then
                        explosiontimer = 135.0
                        If (udp_getstream() <> 0) Then
                            udp_writebyte($07)
                            udp_writebyte(networkserver\Field28)
                            udp_writeint((Int explosiontimer))
                            udp_sendmessage($00)
                        EndIf
                        deathmsg = getinistring2("DATA\SCP-294.ini", local10, "deathmessage", "")
                    EndIf
                    local4 = getinistring2("DATA\SCP-294.ini", local10, "color", "")
                    local11 = instr(local4, ",", $01)
                    local12 = instr(local4, ",", (local11 + $01))
                    local13 = (Int trim(left(local4, (local11 - $01))))
                    local14 = (Int trim(mid(local4, (local11 + $01), ((local12 - local11) - $01))))
                    local15 = (Int trim(right(local4, (len(local4) - local12))))
                    local16 = (Float getinistring2("DATA\SCP-294.ini", local10, "alpha", "1.0"))
                    local17 = getiniint2("DATA\SCP-294.ini", local10, "glow", "")
                    If (local17 <> 0) Then
                        local16 = (- local16)
                    EndIf
                    local18 = createitem("Cup", "cup", entityx(playerroom\Field25[$01], $01), entityy(playerroom\Field25[$01], $01), entityz(playerroom\Field25[$01], $01), local13, local14, local15, local16, $00, $01)
                    local18\Field0 = ("Cup of " + input294)
                    entitytype(local18\Field1, $03, $00)
                Else
                    input294 = "OUT OF RANGE"
                    playerroom\Field9 = playsound_strict(loadtempsound("SFX\SCP\294\outofrange.ogg"))
                    multiplayer_writetempsound("SFX\SCP\294\outofrange.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                EndIf
            EndIf
        EndIf
        If ((mousehit2 Or (using294 = $00)) <> 0) Then
            hidepointer()
            using294 = $00
            input294 = ""
            resetmouse()
        EndIf
    Else
        If (input294 <> "OUT OF RANGE") Then
            input294 = "DISPENSING..."
        EndIf
        If (channelplaying(playerroom\Field9) = $00) Then
            If (input294 <> "OUT OF RANGE") Then
                hidepointer()
                using294 = $00
                resetmouse()
                For local19 = Each events
                    If (local19\Field1 = playerroom) Then
                        local19\Field3 = 0.0
                        Exit
                    EndIf
                Next
            EndIf
            input294 = ""
            playerroom\Field9 = $00
        EndIf
    EndIf
    Return $00
End Function
