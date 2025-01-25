Function use914%(arg0.items, arg1%, arg2#, arg3#, arg4#)
    Local local0.items
    Local local1.items
    Local local2.items
    Local local3.decals
    Local local4.npcs
    Local local5.rooms
    Local local6%
    Local local7%
    Local local8%
    Local local29%
    Local local30%
    Local local38%
    Local local48%
    Local local49%
    Local local50%
    Local local64%
    me\Field53 = (me\Field53 + $01)
    If (((mp_getsocket() <> $00) And (mp_ishoster() = $00)) <> 0) Then
        Return $00
    EndIf
    local6 = $01
    local8 = $00
    Select arg0\Field4\Field2
        Case $38,$39,$3A,$3B
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    If (rand($04, $01) = $01) Then
                        local1 = createitem("Hazmat Suit", $3C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Gas Mask", $38, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01
                    If (rand($32, $01) = $01) Then
                        local1 = createitem("SCP-1499", $24, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Fine Gas Mask", $39, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $02
                    If (rand($64, $01) = $01) Then
                        local1 = createitem("SCP-1499", $24, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Very Fine Gas Mask", $3A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $24,$25
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Gas Mask", $38, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    local1 = createitem("Fine SCP-1499", $25, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local4 = createnpc($10, arg2, arg3, arg4)
                    local4\Field10 = 1.0
                    local4\Field12 = 1.0
                    local4\Field17 = loadsound_strict("SFX\SCP\1499\Triggered.ogg")
                    local4\Field18 = playsoundex(local4\Field17, camera, local4\Field3, 20.0, 1.0, $00, $00)
                    local4\Field95 = $00
            End Select
        Case $40,$41,$42
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Electronical Components", $2F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem("SCRAMBLE Gear", $43, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local1\Field12 = rnd(0.0, 1000.0)
                Case $01
                    If (rand($05, $01) = $01) Then
                        local1 = createitem("Fine SCRAMBLE Gear", $44, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local1\Field12 = rnd(0.0, 1000.0)
                    Else
                        local1 = createitem("Fine Night Vision Goggles", $42, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $02
                    local1 = createitem("Very Fine Night Vision Goggles", $41, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local1\Field12 = rnd(0.0, 1000.0)
            End Select
        Case $43,$44
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Electronical Components", $2F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem("Night Vision Goggles", $40, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local1\Field12 = rnd(0.0, 1000.0)
                Case $01,$02
                    local1 = createitem("Fine SCRAMBLE Gear", $44, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local1\Field12 = rnd(0.0, 1000.0)
            End Select
        Case $26
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Ballistic Vest", $27, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01,$02
                    local1 = createitem("Heavy Ballistic Vest", $28, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $0D,$0E,$0F
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Newsboy Cap", $0D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local6 = $00
                Case $01,$02
                    local1 = createitem("Fine SCP-268", $0F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $27,$28
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Corrosive Ballistic Vest", $29, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem("Ballistic Helmet", $26, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    local1 = createitem("Heavy Ballistic Vest", $28, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local1 = createitem("Bulky Ballistic Vest", $2A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $3C,$3D,$3F
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Hazmat Suit", $3C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    local1 = createitem("Fine Hazmat Suit", $3D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local1 = createitem("Very Fine Hazmat Suit", $3E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $3E
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Hazmat Suit", $3C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01,$02
                    local1 = createitem("Infected Syringe", $58, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $2D,$2E
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                    clearsecondinv(arg0, $00)
                Case $FFFFFFFF
                    If (arg0\Field20 > $05) Then
                        arg0\Field20 = (arg0\Field20 - $05)
                        clearsecondinv(arg0, arg0\Field20)
                    ElseIf (arg0\Field20 = $05) Then
                        arg0\Field20 = $01
                        clearsecondinv(arg0, $01)
                    Else
                        local8 = $01
                        clearsecondinv(arg0, $00)
                    EndIf
                    local6 = $00
                Case $00
                    local6 = $00
                Case $01
                    If (arg0\Field20 = $01) Then
                        arg0\Field20 = $05
                    Else
                        arg0\Field20 = (Int min(20.0, (Float (arg0\Field20 + $05))))
                    EndIf
                    local6 = $00
                Case $02
                    If (arg0\Field20 = $01) Then
                        arg0\Field20 = $0A
                    Else
                        arg0\Field20 = (Int min(20.0, (Float (arg0\Field20 + $0A))))
                    EndIf
                    local6 = $00
            End Select
        Case $2F
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local6 = $00
                Case $01
                    For local0 = Each items
                        If ((((local0 <> arg0) And (local0\Field2 <> $00)) And (local0\Field15 = $00)) <> 0) Then
                            If ((1.0 / 2.022716) > distancesquared(entityx(local0\Field2, $01), arg2, entityz(local0\Field2, $01), arg4, 0.0, 0.0)) Then
                                If (local0\Field4\Field2 = $2D) Then
                                    removeitem(local0)
                                    local1 = createitem("E-Reader", $4D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Exit
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (local1 = Null) Then
                        Select rand($03, $01)
                            Case $01
                                local1 = createitem("Radio Transceiver", $45, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local1\Field12 = rnd(0.0, 100.0)
                            Case $02
                                If (rand($03, $01) = $01) Then
                                    local1 = createitem("S-NAV 300 Navigator", $4A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local1 = createitem("S-NAV Navigator", $49, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    local1\Field12 = rnd(0.0, 100.0)
                                EndIf
                            Case $03
                                local1 = createitem("Night Vision Goggles", $40, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local1\Field12 = rnd(0.0, 1000.0)
                        End Select
                    EndIf
                Case $02
                    For local0 = Each items
                        If ((((local0 <> arg0) And (local0\Field2 <> $00)) And (local0\Field15 = $00)) <> 0) Then
                            If ((1.0 / 2.022716) > distancesquared(entityx(local0\Field2, $01), arg2, entityz(local0\Field2, $01), arg4, 0.0, 0.0)) Then
                                If (local0\Field4\Field2 = $2D) Then
                                    removeitem(local0)
                                    local1 = createitem("E-Reader", $4D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Exit
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (local1 = Null) Then
                        Select rand($03, $01)
                            Case $01
                                If (rand($03, $01) = $01) Then
                                    local1 = createitem("Fine Radio Transceiver", $47, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local1 = createitem("Very Fine Radio Transceiver", $48, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                EndIf
                            Case $02
                                If (rand($02, $01) = $01) Then
                                    local1 = createitem("S-NAV 300 Navigator", $4A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local1 = createitem("S-NAV 310 Navigator", $4B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    local1\Field12 = rnd(0.0, 100.0)
                                EndIf
                            Case $03
                                Select rand($04, $01)
                                    Case $01
                                        local1 = createitem("Fine Night Vision Goggles", $42, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Case $02
                                        local1 = createitem("Very Fine Night Vision Goggles", $41, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = rnd(0.0, 1000.0)
                                    Case $03
                                        local1 = createitem("SCRAMBLE Gear", $43, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = rnd(0.0, 1000.0)
                                    Case $04
                                        local1 = createitem("Fine SCRAMBLE Gear", $44, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                End Select
                        End Select
                    EndIf
            End Select
        Case $0C
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("SCP-148 Ingot", $0B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00,$01,$02
                    local6 = $00
            End Select
        Case $0B
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local1 = createitem("SCP-148 Ingot", $0B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00,$01,$02
                    For local0 = Each items
                        If ((((local0 <> arg0) And (local0\Field2 <> $00)) And (local0\Field15 = $00)) <> 0) Then
                            If ((1.0 / 2.022716) > distancesquared(entityx(local0\Field2, $01), arg2, entityz(local0\Field2, $01), arg4, 0.0, 0.0)) Then
                                Select local0\Field4\Field2
                                    Case $38,$39,$3A
                                        removeitem(local0)
                                        local1 = createitem("Heavy Gas Mask", $3B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        Exit
                                    Case $3C,$3D,$3E
                                        removeitem(local0)
                                        local1 = createitem("Heavy Hazmat Suit", $3F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        Exit
                                End Select
                            EndIf
                        EndIf
                    Next
                    If (local1 = Null) Then
                        local1 = createitem("Metal Panel", $0C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $64,$65,$66
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00,$01
                    If (arg0\Field4\Field2 = $64) Then
                        If (rand($02, $01) = $01) Then
                            local1 = createitem("Black Severed Hand", $65, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Else
                            local1 = createitem("Yellow Severed Hand", $66, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        EndIf
                    ElseIf (arg0\Field4\Field2 = $65) Then
                        If (rand($02, $01) = $01) Then
                            local1 = createitem("White Severed Hand", $64, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Else
                            local1 = createitem("Yellow Severed Hand", $66, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        EndIf
                    ElseIf (rand($02, $01) = $01) Then
                        local1 = createitem("White Severed Hand", $64, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Black Severed Hand", $65, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01,$02
                    local4 = createnpc($00, arg2, arg3, arg4)
                    local4\Field10 = 3.0
            End Select
        Case $34,$35,$36,$37
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    If (arg0\Field4\Field2 = $34) Then
                        local1 = createitem("Blue First Aid Kit", $35, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("First Aid Kit", $34, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01
                    local1 = createitem("Compact First Aid Kit", $36, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local1 = createitem("Strange Bottle", $37, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $59,$5A,$5B,$5C,$5D,$5E,$5F
            local29 = arg0\Field4\Field2
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    If (local29 = $59) Then
                        local8 = $01
                    ElseIf (local29 = $5F) Then
                        local1 = createitem("Level 0 Key Card", $59, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        Select local29
                            Case $5A
                                local30 = $01
                            Case $5B
                                local30 = $02
                            Case $5C
                                local30 = $03
                            Case $5D
                                local30 = $04
                            Case $5E
                                local30 = $05
                        End Select
                        local1 = createitem((("Level " + (Str (local30 - $01))) + " Key Card"), (local29 - $01), arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $00
                    local1 = createitem("Playing Card", $63, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    Select local29
                        Case $59
                            Select selecteddifficulty\Field4
                                Case $00
                                    local1 = createitem("Level 1 Key Card", $5A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($06, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 1 Key Card", $5A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($05, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 1 Key Card", $5A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $03
                                    If (rand($04, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 1 Key Card", $5A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case $5A
                            Select selecteddifficulty\Field4
                                Case $00
                                    local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($05, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($04, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $03
                                    If (rand($03, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case $5B
                            Select selecteddifficulty\Field4
                                Case $00
                                    local1 = createitem("Level 3 Key Card", $5C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($04, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 3 Key Card", $5C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($03, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 3 Key Card", $5C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $03
                                    If (rand($02, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 3 Key Card", $5C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case $5C
                            If (rand(((selecteddifficulty\Field4 * $06) + $0C), $01) = $01) Then
                                local1 = createitem("Level 4 Key Card", $5D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            Else
                                local1 = createitem("Playing Card", $63, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            EndIf
                        Case $5D
                            Select selecteddifficulty\Field4
                                Case $00
                                    local1 = createitem("Level 5 Key Card", $5E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($03, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 5 Key Card", $5E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($02, $01) = $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 5 Key Card", $5E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $03
                                    If (rand($03, $01) > $01) Then
                                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        local1\Field12 = (Float rand($00, $06))
                                    Else
                                        local1 = createitem("Level 5 Key Card", $5E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case $5E
                            local38 = (Int max((Float ((((s2imapsize(achievementsindex) - $03) - (s2imapsize(unlockedachievements) - $01)) - s2imapcontains(unlockedachievements, "apollyon")) * (selecteddifficulty\Field4 + $02))), 0.0))
                            If (rand($00, local38) = $00) Then
                                local1 = createitem("Key Card Omni", $60, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            ElseIf (rand(((selecteddifficulty\Field4 * $06) + $0C), $01) = $01) Then
                                local1 = createitem("Level 6 Key Card", $5F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            ElseIf (rand($0F, $01) = $01) Then
                                local1 = createitem("Mastercard", $62, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local1\Field12 = 1000.0
                            Else
                                local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local1\Field12 = (Float rand($00, $06))
                            EndIf
                        Case $5F
                            If (rand(((selecteddifficulty\Field4 * $03) + $06), $01) = $01) Then
                                local1 = createitem("Key Card Omni", $60, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            ElseIf (rand($05, $01) = $01) Then
                                local1 = createitem("Mastercard", $62, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local1\Field12 = 1000.0
                            Else
                                local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local1\Field12 = (Float rand($00, $06))
                            EndIf
                    End Select
                Case $02
                    local38 = (Int max((Float ((((s2imapsize(achievementsindex) - $03) - (s2imapsize(unlockedachievements) - $01)) - s2imapcontains(unlockedachievements, "apollyon")) * (selecteddifficulty\Field4 + $04))), 0.0))
                    If (rand($00, local38) = $00) Then
                        local1 = createitem("Key Card Omni", $60, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    ElseIf (rand(((selecteddifficulty\Field4 * $06) + $18), $01) = $01) Then
                        local1 = createitem("Level 6 Key Card", $5F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Mastercard", $61, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local1\Field12 = (Float rand($00, $06))
                    EndIf
            End Select
        Case $60
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    If (rand($02, $01) = $01) Then
                        local1 = createitem("Mastercard", $62, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local1\Field12 = 1000.0
                    Else
                        local1 = createitem("Playing Card", $63, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01,$02
                    If (rand(((selecteddifficulty\Field4 Shl $01) + $04), $01) = $01) Then
                        local1 = createitem("Level 6 Key Card", $5F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Mastercard", $62, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local1\Field12 = 1000.0
                    EndIf
            End Select
        Case $63,$6B,$6A
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Level 0 Key Card", $59, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    local1 = createitem("Level 1 Key Card", $5A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $61
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Quarter", $6A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    If (rand($02, $01) = $01) Then
                        local2 = createitem("Quarter", $6A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
                    If (rand($03, $01) = $01) Then
                        local2 = createitem("Quarter", $6A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
                    If (rand($04, $01) = $01) Then
                        local2 = createitem("Quarter", $6A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
                Case $00
                    local1 = createitem("Level 0 Key Card", $59, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    If (rand($23, $01) = $01) Then
                        local1 = createitem("Mastercard", $62, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local1\Field12 = 1000.0
                    Else
                        local1 = createitem("Level 1 Key Card", $5A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $02
                    If (rand($32, $01) = $01) Then
                        local1 = createitem("Mastercard", $62, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local1\Field12 = 1000.0
                    Else
                        local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $62
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    For local7 = $00 To $14 Step $01
                        local1 = createitem("Quarter", $6A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Next
                Case $00
                    local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    If (rand($23, $01) = $01) Then
                        local1 = createitem("Level 4 Key Card", $5D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Level 3 Key Card", $5C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $02
                    If (rand($2D, $01) = $01) Then
                        local1 = createitem("Level 5 Key Card", $5E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Level 3 Key Card", $5C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $08,$09,$0A
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Coarse SCP-005", $09, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    If (rand($08, $01) = $01) Then
                        local1 = createitem("Level 5 Key Card", $5E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local2 = createitem("White Severed Hand", $64, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                        local2 = createitem("Black Severed Hand", $65, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                        local2 = createitem("Yellow Severed Hand", $66, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                        local2 = createitem("White Key", $68, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                        local2 = createitem("Yellow Key", $67, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    Else
                        local1 = createitem("SCP-005", $08, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01,$02
                    local1 = createitem("Fine SCP-005", $0A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $1E,$1F
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    If (arg0\Field4\Field2 <> $1E) Then
                        local1 = createitem("SCP-860", $1E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("White Key", $68, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01
                    If (rand(((selecteddifficulty\Field4 Shl $02) + $08), $01) = $01) Then
                        local1 = createitem("Fine SCP-860", $1F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local6 = $00
                    EndIf
                Case $02
                    If (rand(((selecteddifficulty\Field4 * $06) + $0C), $01) = $01) Then
                        local1 = createitem("Fine SCP-860", $1F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local6 = $00
                    EndIf
            End Select
        Case $69,$68,$67
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    If (arg0\Field4\Field2 = $68) Then
                        local1 = createitem("Yellow Key", $67, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("White Key", $68, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01
                    If (rand($03, $01) = $01) Then
                        local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    ElseIf (arg0\Field4\Field2 = $68) Then
                        local1 = createitem("Yellow Key", $67, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("White Key", $68, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $02
                    If (rand($06, $01) = $01) Then
                        local1 = createitem("Level 3 Key Card", $5C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    ElseIf (arg0\Field4\Field2 = $68) Then
                        local1 = createitem("Yellow Key", $67, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("White Key", $68, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $45,$46,$47,$48
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Electronical Components", $2F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem("18V Radio Transceiver", $46, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local1\Field12 = rnd(0.0, 100.0)
                Case $01
                    local1 = createitem("Fine Radio Transceiver", $47, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local1 = createitem("Very Fine Radio Transceiver", $48, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $49,$4A,$4B,$4C
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Electronical Components", $2F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem("S-NAV Navigator", $49, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local1\Field12 = rnd(0.0, 100.0)
                Case $01
                    local1 = createitem("S-NAV 310 Navigator", $4B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local1\Field12 = rnd(0.0, 100.0)
                Case $02
                    local48 = $00
                    local49 = $00
                    For local5 = Each rooms
                        local50 = local5\Field7\Field6
                        If ((((((local50 <> $04) And (local50 <> $47)) And (local50 <> $49)) And (local50 <> $69)) And (local50 <> $6A)) <> 0) Then
                            local48 = (local48 + $01)
                            local49 = (local49 + local5\Field1)
                        EndIf
                    Next
                    If (rand((Int max((Float ((local48 - (local49 Shl $01)) * (selecteddifficulty\Field4 + $01))), 1.0)), $01) = $01) Then
                        local1 = createitem("S-NAV Navigator Ultimate", $4C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("S-NAV 300 Navigator", $4A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $19
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    playsound_strict(loadtempsound("SFX\SCP\513\914Refine.ogg"), $00)
                    For local4 = Each npcs
                        If (local4\Field4 = $09) Then
                            removenpc(local4)
                        EndIf
                    Next
                    local8 = $01
                Case $00,$01,$02
                    local1 = createitem("SCP-513", $19, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $10,$11,$12,$13
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Cigarette", $11, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    local1 = createitem("Joint", $12, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local1 = createitem("Smelly Joint", $13, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $1B,$1A,$1C,$1D
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Coarse SCP-714", $1A, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    If (arg0\Field4\Field2 = $1B) Then
                        local1 = createitem("Green Jade Ring", $1D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("SCP-714", $1B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01,$02
                    local1 = createitem("Fine SCP-714", $1C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $51
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local6 = $00
                Case $01
                    local1 = createitem("9V Battery", $50, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local1 = createitem("18V Battery", $52, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $50
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("4.5V Battery", $51, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local6 = $00
                Case $01
                    local1 = createitem("18V Battery", $52, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    If (rand($05, $01) = $01) Then
                        local1 = createitem("999V Battery", $53, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Strange Battery", $54, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $52
            Select arg1
                Case $FFFFFFFE
                    local1 = createitem("4.5V Battery", $51, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $FFFFFFFF
                    local1 = createitem("9V Battery", $50, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local6 = $00
                Case $01
                    local1 = createitem("18V Battery", $52, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    If (rand($03, $01) = $01) Then
                        local1 = createitem("999V Battery", $53, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Strange Battery", $54, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $53
            Select arg1
                Case $FFFFFFFE
                    local1 = createitem("4.5V Battery", $51, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $FFFFFFFF
                    local1 = createitem("9V Battery", $50, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00,$01,$02
                    local1 = createitem("Strange Battery", $54, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $30,$31,$32,$33
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    If (rand($02, $01) = $01) Then
                        local1 = createitem("ReVision Eyedrops", $30, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("RedVision Eyedrops", $31, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01
                    local1 = createitem("Fine Eyedrops", $32, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    local1 = createitem("Very Fine Eyedrops", $33, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $55
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Compact First Aid Kit", $36, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    local1 = createitem("Fine Syringe", $56, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    If (rand($03, $01) = $01) Then
                        local1 = createitem("Very Fine Syringe", $57, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Infected Syringe", $58, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $56
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("First Aid Kit", $34, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem("Blue First Aid Kit", $35, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01,$02
                    If (rand($03, $01) = $01) Then
                        local1 = createitem("Very Fine Syringe", $57, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Infected Syringe", $58, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $57
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF,$00
                    local1 = createitem("Electronical Components", $2F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    local1 = createitem("Infected Syringe", $58, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    If (rand($02, $01) = $01) Then
                        local4 = createnpc($00, arg2, arg3, arg4)
                        local4\Field10 = 2.0
                    Else
                        local1 = createitem("Infected Syringe", $58, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $58
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local4 = createnpc($00, arg2, arg3, arg4)
                    local4\Field10 = 2.0
                Case $01
                    local1 = createitem("Syringe", $55, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $02
                    If (rand($04, $01) = $01) Then
                        local1 = createitem("Blue First Aid Kit", $35, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Fine Syringe", $56, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $16,$17,$18
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Pill", $18, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    local64 = $00
                    For local2 = Each items
                        If (local2\Field4\Field2 = $14) Then
                            local64 = $01
                            Exit
                        EndIf
                    Next
                    If (local64 <> 0) Then
                        local1 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("SCP-427", $14, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $02
                    If (rand($0A, $01) = $01) Then
                        local1 = createitem("SCP-500", $15, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $15
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("SCP-500-01", $16, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    If (rand($02, $01) = $01) Then
                        local2 = createitem("SCP-500-01", $16, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
                    If (rand($03, $01) = $01) Then
                        local2 = createitem("SCP-500-01", $16, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
                    If (rand($04, $01) = $01) Then
                        local2 = createitem("SCP-500-01", $16, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
                Case $01
                    local64 = $00
                    For local2 = Each items
                        If (local2\Field4\Field2 = $14) Then
                            local64 = $01
                            Exit
                        EndIf
                    Next
                    If (local64 = $00) Then
                        local1 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        If (rand($02, $01) = $01) Then
                            local2 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            entitytype(local2\Field2, $03, $00)
                        EndIf
                        If (rand($03, $01) = $01) Then
                            local2 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            entitytype(local2\Field2, $03, $00)
                        EndIf
                        If (rand($04, $01) = $01) Then
                            local2 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            entitytype(local2\Field2, $03, $00)
                        EndIf
                    Else
                        local1 = createitem("SCP-427", $14, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $02
                    local1 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    If (rand($02, $01) = $01) Then
                        local2 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
                    If (rand($03, $01) = $01) Then
                        local2 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
                    If (rand($04, $01) = $01) Then
                        local2 = createitem("Upgraded Pill", $17, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        entitytype(local2\Field2, $03, $00)
                    EndIf
            End Select
        Case $2B
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00
                    local1 = createitem("Cup", $2B, arg2, arg3, arg4, (Int (255.0 - (Float arg0\Field6))), (Int (255.0 - (Float arg0\Field7))), (Int (255.0 - (Float arg0\Field8))), 1.0, $00)
                    local1\Field1 = arg0\Field1
                    local1\Field0 = arg0\Field0
                    local1\Field12 = arg0\Field12
                Case $01
                    local1 = createitem("Cup", $2B, arg2, arg3, arg4, (Int min(((Float arg0\Field6) * rnd(0.9, 1.1)), 255.0)), (Int min(((Float arg0\Field7) * rnd(0.9, 1.1)), 255.0)), (Int min(((Float arg0\Field8) * rnd(0.9, 1.1)), 255.0)), 1.0, $00)
                    local1\Field1 = arg0\Field1
                    local1\Field0 = arg0\Field0
                    local1\Field12 = 2.0
                Case $02
                    local1 = createitem("Cup", $2B, arg2, arg3, arg4, (Int min(((Float arg0\Field6) * rnd(0.5, 1.5)), 255.0)), (Int min(((Float arg0\Field7) * rnd(0.5, 1.5)), 255.0)), (Int min(((Float arg0\Field8) * rnd(0.5, 1.5)), 255.0)), 1.0, $00)
                    local1\Field1 = arg0\Field1
                    local1\Field0 = arg0\Field0
                    local1\Field12 = 5.0
                    If (rand($05, $01) = $01) Then
                        me\Field58 = 135.0
                    EndIf
            End Select
        Case $02
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Blank Paper", $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem(("Document SCP-" + getranddocument()), $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01,$02
                    If (rand($0A, $01) = $01) Then
                        local1 = createitem("SCP-085", $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem(("Document SCP-" + getranddocument()), $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $00,$01
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Blank Paper", $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem(("Document SCP-" + getranddocument()), $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01,$02
                    local1 = createitem("Origami", $02, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $20,$21,$22
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Blank Paper", $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    If (arg0\Field4\Field2 <> $20) Then
                        local1 = createitem("SCP-1025", $20, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Book", $22, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $01,$02
                    local1 = createitem("Fine SCP-1025", $21, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $23
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    playsound_strict(loadtempsound("SFX\SCP\1123\Horror.ogg"), $00)
                    local3 = createdecal($03, arg2, 0.03625, arg4, 90.0, rnd(360.0, 0.0), 0.0, rnd(0.3, 0.4), rnd(0.8, 1.0), $01, $01, $00, $00, $00)
                    entityparent(local3\Field0, playerroom\Field2, $01)
                Case $00
                    local6 = $00
                Case $01,$02
                    If (rand($02, $01) = $01) Then
                        local1 = createitem("Yellow Severed Hand", $66, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    ElseIf (rand($02, $01) = $01) Then
                        local1 = createitem("Black Severed Hand", $65, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("White Severed Hand", $64, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
            End Select
        Case $03,$04,$06,$05
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Blank Paper", $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local1 = createitem(("Document SCP-" + getranddocument()), $00, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $01
                    If (rand($08, $01) = $01) Then
                        If (arg0\Field4\Field2 = $03) Then
                            local1 = createitem("Level 2 Key Card", $5B, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        ElseIf (arg0\Field4\Field2 = $05) Then
                            local1 = createitem("Level 3 Key Card", $5C, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Else
                            local1 = createitem("Level 4 Key Card", $5D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        EndIf
                    Else
                        local1 = createitem("Wallet", $2E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case $02
                    local1 = createitem("Clipboard", $2D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
        Case $4D,$4E,$4F
            Select arg1
                Case $FFFFFFFE
                    local8 = $01
                Case $FFFFFFFF
                    local1 = createitem("Clipboard", $2D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case $00
                    local6 = $00
                Case $01
                    If (rand($05, $01) = $01) Then
                        local1 = createitem("E-Reader 20", $4E, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Clipboard", $2D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local1\Field20 = $0F
                    EndIf
                Case $02
                    If (rand($0F, $01) = $01) Then
                        local1 = createitem("E-Reader 30", $4F, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local1 = createitem("Clipboard", $2D, arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        local1\Field20 = $14
                    EndIf
            End Select
        Default
            Select arg1
                Case $FFFFFFFE,$FFFFFFFF
                    local8 = $01
                Case $00,$01,$02
                    local6 = $00
            End Select
    End Select
    If (local8 <> 0) Then
        local3 = createdecal($00, arg2, 0.03625, arg4, 90.0, rnd(360.0, 0.0), 0.0, rnd(0.3, 0.8), rnd(0.8, 1.0), $01, $01, $00, $00, $00)
        entityparent(local3\Field0, playerroom\Field2, $01)
    EndIf
    If (local6 <> 0) Then
        removeitem(arg0)
    Else
        positionentity(arg0\Field2, arg2, arg3, arg4, $00)
        resetentity(arg0\Field2)
    EndIf
    If (local1 <> Null) Then
        entitytype(local1\Field2, $03, $00)
    EndIf
    Return $00
End Function
