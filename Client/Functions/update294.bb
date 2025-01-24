Function update294%()
    Local local0.items
    Local local1#
    Local local2#
    Local local3%
    Local local4%
    Local local5$
    Local local6%
    Local local7%
    Local local8#
    Local local13%
    Local local14$
    Local local15%
    Local local16%
    Local local17%
    Local local18.events
    local1 = (Float (mo\Field9 - (imagewidth(t\Field1[$05]) Sar $01)))
    local2 = (Float (mo\Field10 - (imageheight(t\Field1[$05]) Sar $01)))
    local6 = (playerroom\Field9 = $00)
    If (local6 <> 0) Then
        If (mo\Field0 <> 0) Then
            local3 = (Int floor((((mouseposx - local1) - (228.0 * menuscale)) / (35.5 * menuscale))))
            local4 = (Int floor((((mouseposy - local2) - (342.0 * menuscale)) / (36.5 * menuscale))))
            local6 = $00
            If ((((local4 >= $00) And (local4 < $05)) And ((local3 >= $00) And (local3 < $0A))) <> 0) Then
                playsound_strict(buttonsfx[$00], $00)
                local5 = ""
                Select local4
                    Case $00
                        local5 = (Str ((local3 + $01) Mod $0A))
                    Case $01
                        Select local3
                            Case $00
                                local5 = "Q"
                            Case $01
                                local5 = "W"
                            Case $02
                                local5 = "E"
                            Case $03
                                local5 = "R"
                            Case $04
                                local5 = "T"
                            Case $05
                                local5 = "Y"
                            Case $06
                                local5 = "U"
                            Case $07
                                local5 = "I"
                            Case $08
                                local5 = "O"
                            Case $09
                                local5 = "P"
                        End Select
                    Case $02
                        Select local3
                            Case $00
                                local5 = "A"
                            Case $01
                                local5 = "S"
                            Case $02
                                local5 = "D"
                            Case $03
                                local5 = "F"
                            Case $04
                                local5 = "G"
                            Case $05
                                local5 = "H"
                            Case $06
                                local5 = "J"
                            Case $07
                                local5 = "K"
                            Case $08
                                local5 = "L"
                            Case $09
                                local6 = $01
                        End Select
                    Case $03
                        Select local3
                            Case $00
                                local5 = "Z"
                            Case $01
                                local5 = "X"
                            Case $02
                                local5 = "C"
                            Case $03
                                local5 = "V"
                            Case $04
                                local5 = "B"
                            Case $05
                                local5 = "N"
                            Case $06
                                local5 = "M"
                            Case $07
                                local5 = "-"
                            Case $08
                                local5 = " "
                            Case $09
                                i_294\Field1 = left(i_294\Field1, (Int max((Float (len(i_294\Field1) - $01)), 0.0)))
                        End Select
                    Case $04
                        local5 = " "
                End Select
            EndIf
            i_294\Field1 = (i_294\Field1 + local5)
            If ((local6 And (i_294\Field1 <> "")) <> 0) Then
                mp_client_use294(i_294\Field1)
                i_294\Field1 = trim(i_294\Field1)
                If (left(i_294\Field1, (Int min(7.0, (Float len(i_294\Field1))))) = "cup of ") Then
                    i_294\Field1 = right(i_294\Field1, (len(i_294\Field1) - $07))
                ElseIf (left(i_294\Field1, (Int min(9.0, (Float len(i_294\Field1))))) = "a cup of ") Then
                    i_294\Field1 = right(i_294\Field1, (len(i_294\Field1) - $09))
                EndIf
                If (s2imapcontains(i_294\Field2, i_294\Field1) <> 0) Then
                    local13 = jsongetarrayvalue(i_294\Field3, s2imapget(i_294\Field2, i_294\Field1))
                    If (jsonisnull(jsongetvalue(local13, "dispense_sound")) = $00) Then
                        local14 = jsongetstring(jsongetvalue(local13, "dispense_sound"))
                        playerroom\Field9 = playsound_strict(loadtempsound(local14), $00)
                        mp_synchronize3dsound(Null, local14, playerroom\Field11[$00], 10.0, 1.0)
                    EndIf
                    If (me\Field64 > $00) Then
                        local15 = ((me\Field64 = $02) + $61)
                        playsound_strict(loadtempsound("SFX\SCP\294\PullMasterCard.ogg"), $00)
                        mp_synchronize3dsound(Null, "SFX\SCP\294\PullMasterCard.ogg", playerroom\Field11[$00], 2.0, 1.0)
                        If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
                            If (getitemamount() < maxitemamount) Then
                                local0 = createitem("Mastercard", local15, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                local0\Field12 = (Float me\Field63)
                                entitytype(local0\Field2, $03, $00)
                                pickitem(local0, $00)
                            Else
                                local0 = createitem("Mastercard", local15, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.3), entityz(me\Field60, $00), $00, $00, $00, 1.0, $00)
                                local0\Field4\Field4 = $01
                                local0\Field12 = (Float me\Field63)
                                entitytype(local0\Field2, $03, $00)
                                createmsg(getlocalstring("msg", "cantcarry"), 6.0)
                            EndIf
                        EndIf
                    EndIf
                    local7 = jsongetvalue(local13, "explosion")
                    If (jsonisnull(local7) = $00) Then
                        If (jsongetbool(local7) <> 0) Then
                            me\Field58 = 135.0
                            local7 = jsongetvalue(local13, "death_message")
                            If (jsonisnull(local7) = $00) Then
                                msg\Field2 = jsongetstring(local7)
                            EndIf
                        EndIf
                    EndIf
                    local17 = jsongetarray(jsongetvalue(local13, "color"))
                    local8 = jsongetfloat(jsongetvalue(local13, "alpha"))
                    local7 = jsongetvalue(local13, "glow")
                    If (jsonisnull(local7) = $00) Then
                        If (jsongetbool(local7) <> 0) Then
                            local8 = (- local8)
                        EndIf
                    EndIf
                    If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
                        local0 = createitem("Cup", $2B, entityx(playerroom\Field11[$02], $01), entityy(playerroom\Field11[$02], $01), entityz(playerroom\Field11[$02], $01), jsongetint(jsongetarrayvalue(local17, $00)), jsongetint(jsongetarrayvalue(local17, $01)), jsongetint(jsongetarrayvalue(local17, $02)), local8, $00)
                        local0\Field1 = i_294\Field1
                        local0\Field0 = format(getlocalstring("items", "cupof"), i_294\Field1, "%s")
                        entitytype(local0\Field2, $03, $00)
                    EndIf
                Else
                    i_294\Field1 = getlocalstring("misc", "ofr")
                    playerroom\Field9 = playsound_strict(loadtempsound("SFX\SCP\294\OutOfRange.ogg"), $00)
                    mp_synchronize3dsound(Null, "SFX\SCP\294\OutOfRange.ogg", playerroom\Field11[$00], 10.0, 1.0)
                EndIf
            EndIf
        EndIf
        If ((mo\Field1 Lor (i_294\Field0 = $00)) <> 0) Then
            i_294\Field0 = $00
            i_294\Field1 = ""
            stopmousemovement()
        EndIf
    Else
        If (i_294\Field1 <> getlocalstring("misc", "ofr")) Then
            i_294\Field1 = getlocalstring("misc", "dispensing")
        EndIf
        If (channelplaying(playerroom\Field9) = $00) Then
            If (i_294\Field1 <> getlocalstring("misc", "ofr")) Then
                i_294\Field0 = $00
                me\Field64 = $00
                stopmousemovement()
                For local18 = Each events
                    If (playerroom = local18\Field1) Then
                        local18\Field3 = 0.0
                        Exit
                    EndIf
                Next
            EndIf
            i_294\Field1 = ""
            playerroom\Field9 = $00
        EndIf
    EndIf
    Return $00
End Function
