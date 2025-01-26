Function rendergui%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8#
    Local local9%
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local18#
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23$
    Local local24#
    Local local25%
    Local local26%
    Local local27%
    Local local28#
    Local local29#
    Local local30#
    Local local31#
    Local local32.items
    Local local33%
    Local local34%
    Local local35%
    Local local36%
    Local local37%
    Local local38%
    Local local39%
    Local local40%
    Local local41%
    Local local42%
    Local local44%
    Local local45%
    Local local53%
    Local local54%
    Local local55%
    Local local56%
    Local local57%
    Local local58%
    Local local59%
    Local local60%
    Local local61%
    Local local62#
    Local local63#
    Local local64%
    Local local65%
    Local local66%
    Local local67%
    Local local68%
    Local local69%
    Local local70%
    Local local71%
    Local local72%
    Local local73#
    Local local74.npcs
    Local local75.rooms
    Local local76%
    Local local77%
    Local local78%
    catcherrors("RenderGUI()")
    If (((((((menuopen Lor invopen) Lor consoleopen) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (0.0 > me\Field45)) Lor ismultiplayerhudenabled) <> 0) Then
        showpointer()
    Else
        hidepointer()
    EndIf
    If (((pd_event <> Null) And (pd_event\Field1 = playerroom)) <> 0) Then
        If ((((wi\Field5 > $00) Lor (wi\Field9 > $00)) And (5.0 <> pd_event\Field3)) <> 0) Then
            If (pd_event\Field14 = $00) Then
                pd_event\Field14 = scaleimageex(loadimage_strict("GFX\Overlays\scp_106_face_overlay.png"), menuscale, menuscale, $01)
            Else
                drawblock(pd_event\Field14, (Int ((Float mo\Field9) - ((Float rand($136, $186)) * menuscale))), (Int ((Float mo\Field10) - ((Float rand($122, $136)) * menuscale))), $00)
            EndIf
        ElseIf (2.0 = pd_event\Field3) Then
            If (((-16.0 < me\Field10) And (-6.0 > me\Field10)) <> 0) Then
                If (pd_event\Field15 = $00) Then
                    pd_event\Field15 = scaleimageex(loadimage_strict("GFX\Overlays\kneel_mortal_overlay.png"), menuscale, menuscale, $01)
                Else
                    drawblock(pd_event\Field15, (Int ((Float mo\Field9) - ((Float rand($136, $186)) * menuscale))), (Int ((Float mo\Field10) - ((Float rand($122, $136)) * menuscale))), $00)
                EndIf
            EndIf
        EndIf
    ElseIf (((scribe_event <> Null) And (scribe_event\Field1 = playerroom)) <> 0) Then
        If (0.36 > distancesquared(entityx(me\Field60, $00), entityx(scribe_event\Field1\Field11[$00], $01), entityz(me\Field60, $00), entityz(scribe_event\Field1\Field11[$00], $01), 0.0, 0.0)) Then
            If (((70.0 > scribe_event\Field3) And (1.0 = scribe_event\Field4)) <> 0) Then
                me\Field10 = -10.0
                If (scribe_event\Field14 = $00) Then
                    playsound_strict(snd_i\Field47[$0B], $00)
                    scribe_event\Field14 = scaleimageex(loadimage_strict("GFX\Overlays\scp_012_overlay.png"), menuscale, menuscale, $01)
                Else
                    drawblock(scribe_event\Field14, (Int ((Float mo\Field9) - ((Float rand($136, $186)) * menuscale))), (Int ((Float mo\Field10) - ((Float rand($122, $136)) * menuscale))), $00)
                EndIf
            EndIf
        EndIf
    EndIf
    If (i_294\Field0 <> 0) Then
        render294()
    EndIf
    If (((selecteddifficulty\Field0 <> difficulties[$03]\Field0) And opt\Field32) <> 0) Then
        If (((((((((menuopen Lor invopen) Lor consoleopen) Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor (Int me\Field0)) Lor ismultiplayerhudenabled) = $00) Then
            If (d_i\Field9 <> $00) Then
                render3dhandicon($05, d_i\Field9, $FFFFFFFF)
            EndIf
            If (closestitem <> Null) Then
                render3dhandicon($06, closestitem\Field2, $FFFFFFFF)
            EndIf
            If (handentity <> $00) Then
                render3dhandicon($05, handentity, $FFFFFFFF)
                For local7 = $00 To $03 Step $01
                    If (drawarrowicon[local7] <> 0) Then
                        render3dhandicon((local7 + $0A), handentity, local7)
                    EndIf
                Next
            EndIf
        EndIf
        renderhud()
    EndIf
    If (chs\Field8 <> $00) Then
        renderdebughud()
    EndIf
    If (((selectedscreen <> Null) And (-6.0 < me\Field10)) <> 0) Then
        drawblock(selectedscreen\Field2, (Int ((Float mo\Field9) - (512.0 * menuscale))), (Int ((Float mo\Field10) - (384.0 * menuscale))), $00)
    EndIf
    local25 = invopen
    local26 = $42
    local27 = $01
    If (d_i\Field6 <> Null) Then
        If (selecteditem <> Null) Then
            If ((((selecteditem\Field4\Field2 = $08) Lor (selecteditem\Field4\Field2 = $09)) Lor (selecteditem\Field4\Field2 = $0A)) <> 0) Then
                local27 = $00
            EndIf
        EndIf
        If (local27 <> 0) Then
            local28 = entityx(d_i\Field9, $01)
            local29 = entityy(d_i\Field9, $01)
            local30 = entityz(d_i\Field9, $01)
            camerazoom(camera, (min(((me\Field52 / 400.0) + 1.0), 1.1) / camerazoomvalue))
            local19 = createpivot($00)
            positionentity(local19, local28, local29, local30, $00)
            rotateentity(local19, 0.0, (entityyaw(d_i\Field9, $01) - 180.0), 0.0, $00)
            moveentity(local19, 0.0, 0.0, 0.22)
            positionentity(camera, entityx(local19, $00), entityy(local19, $00), entityz(local19, $00), $00)
            pointentity(camera, d_i\Field9, 0.0)
            freeentity(local19)
            local19 = $00
            local18 = (meshheight(d_i\Field2[$00]) * 0.015)
            cameraproject(camera, local28, (local29 + local18), local30)
            local17 = projectedy()
            cameraproject(camera, local28, (local29 - local18), local30)
            local18 = ((projectedy() - local17) / (462.0 * menuscale))
            local31 = (local18 / 2.0)
            local4 = (Int ((Float mo\Field9) - ((Float imagewidth(t\Field1[$04])) * local31)))
            local5 = (Int ((Float mo\Field10) - ((Float imageheight(t\Field1[$04])) * local31)))
            setfontex(fo\Field0[$02])
            color($FF, $FF, $FF)
            If (msg\Field3 <> "") Then
                If (35.0 > (msg\Field4 Mod 70.0)) Then
                    textex(mo\Field9, (Int (((124.0 * menuscale) * local18) + (Float local5))), msg\Field3, $01, $01)
                EndIf
            Else
                textex(mo\Field9, (Int (((70.0 * menuscale) * local18) + (Float local5))), getlocalstring("msg", "accesscode"), $01, $01)
                setfontex(fo\Field0[$03])
                textex(mo\Field9, (Int (((124.0 * menuscale) * local18) + (Float local5))), msg\Field5, $01, $01)
            EndIf
            rendercursor()
        EndIf
    EndIf
    local35 = (Int (70.0 * menuscale))
    local36 = (Int (35.0 * menuscale))
    local37 = (Int ((64.0 * menuscale) / 2.0))
    local38 = (maxitemamount Sar $01)
    If (otheropen <> Null) Then
        local32 = otheropen
        local39 = otheropen\Field20
        For local7 = $00 To (local39 - $01) Step $01
            If (otheropen\Field18[local7] <> Null) Then
                local40 = (local40 + $01)
            EndIf
        Next
        local41 = $00
        local4 = (mo\Field9 - ((((local35 * $0A) Sar $01) + (local36 Shl $02)) Sar $01))
        local5 = ((mo\Field10 - ((((local39 / $0A) Shl $01) - $01) * local35)) - local36)
        local33 = $FFFFFFFF
        For local20 = $00 To (local39 - $01) Step $01
            If (mouseon(local4, local5, local35, local35) <> 0) Then
                local33 = local20
            EndIf
            If (local33 = local20) Then
                local26 = local20
                color($FF, $00, $00)
                rect((local4 - $01), (local5 - $01), (Int ((2.0 * menuscale) + (Float local35))), (Int ((2.0 * menuscale) + (Float local35))), $01)
            EndIf
            renderframe(local4, local5, local35, local35, (local4 Mod $40), (local4 Mod $40), $00)
            If (otheropen = Null) Then
                Exit
            EndIf
            If (otheropen\Field18[local20] <> Null) Then
                If (((local33 = local20) Lor (selecteditem <> otheropen\Field18[local20])) <> 0) Then
                    drawblock(otheropen\Field18[local20]\Field17, (Int ((Float ((local35 Sar $01) + local4)) - (32.0 * menuscale))), (Int ((Float ((local35 Sar $01) + local5)) - (32.0 * menuscale))), $00)
                EndIf
            EndIf
            If (((otheropen\Field18[local20] <> Null) And (selecteditem <> otheropen\Field18[local20])) <> 0) Then
                If (local33 = local20) Then
                    setfontex(fo\Field0[$00])
                    color($FF, $FF, $FF)
                    textex(((local35 Sar $01) + local4), (Int ((Float ((local5 + local35) + local36)) - (15.0 * menuscale))), otheropen\Field18[local20]\Field4\Field0, $01, $00)
                EndIf
            EndIf
            local4 = ((local4 + local35) + local36)
            local41 = (local41 + $01)
            If (local41 = $05) Then
                local41 = $00
                local5 = (local5 + (local35 Shl $01))
                local4 = (mo\Field9 - ((((local35 * $0A) Sar $01) + (local36 Shl $02)) Sar $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mo\Field2 <> 0) Then
                If (((local26 = $42) Lor (selecteditem <> local32\Field18[local26])) <> 0) Then
                    drawblock(selecteditem\Field17, (Int (mouseposx - (Float local37))), (Int (mouseposy - (Float local37))), $00)
                EndIf
            EndIf
        EndIf
        rendercursor()
    ElseIf (invopen <> 0) Then
        local4 = (mo\Field9 - (((local35 * local38) + ((local38 - $01) * local36)) Sar $01))
        local5 = ((mo\Field10 - local35) - local36)
        If (maxitemamount = $02) Then
            local5 = (local5 + local35)
            local4 = (local4 - (((local35 * local38) + local36) Sar $01))
        EndIf
        local33 = $FFFFFFFF
        For local20 = $00 To (maxitemamount - $01) Step $01
            If (mouseon(local4, local5, local35, local35) <> 0) Then
                local33 = local20
            EndIf
            If (inventory(local20) <> Null) Then
                color($C8, $C8, $C8)
                Select inventory(local20)\Field4\Field2
                    Case $38
                        local42 = (wi\Field0 = $01)
                    Case $39
                        local42 = (wi\Field0 = $02)
                    Case $3A
                        local42 = (wi\Field0 = $03)
                    Case $3B
                        local42 = (wi\Field0 = $04)
                    Case $24
                        local42 = (i_1499\Field0 = $01)
                    Case $25
                        local42 = (i_1499\Field0 = $02)
                    Case $40
                        local42 = (wi\Field5 = $01)
                    Case $41
                        local42 = (wi\Field5 = $02)
                    Case $42
                        local42 = (wi\Field5 = $03)
                    Case $43
                        local42 = (wi\Field9 = $01)
                    Case $44
                        local42 = (wi\Field9 = $02)
                    Case $26
                        local42 = wi\Field4
                    Case $0D
                        local42 = (i_268\Field0 = $01)
                    Case $0E
                        local42 = (i_268\Field0 = $02)
                    Case $0F
                        local42 = (i_268\Field0 = $03)
                    Case $27
                        local42 = (wi\Field3 = $01)
                    Case $28
                        local42 = (wi\Field3 = $02)
                    Case $3C
                        local42 = (wi\Field2 = $01)
                    Case $3D
                        local42 = (wi\Field2 = $02)
                    Case $3E
                        local42 = (wi\Field2 = $03)
                    Case $3F
                        local42 = (wi\Field2 = $04)
                    Case $14
                        local42 = i_427\Field0
                    Case $1B
                        local42 = (i_714\Field0 = $02)
                    Case $1A
                        local42 = (i_714\Field0 = $01)
                    Default
                        local42 = $00
                End Select
                If (local42 <> 0) Then
                    rect((Int ((Float local4) - (3.0 * menuscale))), (Int ((Float local5) - (3.0 * menuscale))), (Int ((6.0 * menuscale) + (Float local35))), (Int ((6.0 * menuscale) + (Float local35))), $01)
                EndIf
            EndIf
            If (0.0 < i_1025\Field1[$00]) Then
                If (((local20 = (maxitemamount - $01)) Lor (local20 = (local38 - $01))) <> 0) Then
                    color($00, $FF, $00)
                    rect((local4 - $01), (local5 - $01), (Int ((2.0 * menuscale) + (Float local35))), (Int ((2.0 * menuscale) + (Float local35))), $01)
                EndIf
            EndIf
            If (local33 = local20) Then
                local26 = local20
                color($FF, $00, $00)
                rect((local4 - $01), (local5 - $01), (Int ((2.0 * menuscale) + (Float local35))), (Int ((2.0 * menuscale) + (Float local35))), $01)
            EndIf
            color($FF, $FF, $FF)
            renderframe(local4, local5, local35, local35, (local4 Mod $40), (local4 Mod $40), $00)
            If (inventory(local20) <> Null) Then
                If (((local33 = local20) Lor (selecteditem <> inventory(local20))) <> 0) Then
                    drawblock(inventory(local20)\Field17, (Int ((Float ((local35 Sar $01) + local4)) - (32.0 * menuscale))), (Int ((Float ((local35 Sar $01) + local5)) - (32.0 * menuscale))), $00)
                EndIf
            EndIf
            If (((inventory(local20) <> Null) And (selecteditem <> inventory(local20))) <> 0) Then
                If (local33 = local20) Then
                    If (selecteditem = Null) Then
                        setfontex(fo\Field0[$00])
                        color($FF, $FF, $FF)
                        textex(((local35 Sar $01) + local4), (Int ((Float ((local5 + local35) + local36)) - (15.0 * menuscale))), inventory(local20)\Field0, $01, $00)
                    EndIf
                EndIf
            EndIf
            local4 = ((local4 + local35) + local36)
            If (((maxitemamount >= $04) And (local20 = (local38 - $01))) <> 0) Then
                local5 = (local5 + (local35 Shl $01))
                local4 = (mo\Field9 - (((local35 * local38) + ((local38 - $01) * local36)) Sar $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mo\Field2 <> 0) Then
                If (((local26 = $42) Lor (selecteditem <> inventory(local26))) <> 0) Then
                    drawblock(selecteditem\Field17, (Int (mouseposx - (Float local37))), (Int (mouseposy - (Float local37))), $00)
                EndIf
            EndIf
        EndIf
        rendercursor()
    ElseIf (selecteditem <> Null) Then
        local44 = (Int (300.0 * menuscale))
        local45 = (Int (20.0 * menuscale))
        Select selecteditem\Field4\Field2
            Case $38,$39,$3A,$3B
                If (preventitemoverlapping($01, $00, $00, $01, $00, $00, $01) = $00) Then
                    Select selecteditem\Field4\Field2
                        Case $38
                            If (isdoubleitem(wi\Field0, $01) <> 0) Then
                                Return $00
                            EndIf
                        Case $39
                            If (isdoubleitem(wi\Field0, $02) <> 0) Then
                                Return $00
                            EndIf
                        Case $3A
                            If (isdoubleitem(wi\Field0, $03) <> 0) Then
                                Return $00
                            EndIf
                        Case $3B
                            If (isdoubleitem(wi\Field0, $04) <> 0) Then
                                Return $00
                            EndIf
                    End Select
                    drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                    local4 = (mo\Field9 - (local44 Sar $01))
                    local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                    renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field12, 100.0, $64, $64, $64)
                EndIf
            Case $24,$25
                If (preventitemoverlapping($00, $00, $01, $01, $00, $00, $01) = $00) Then
                    Select selecteditem\Field4\Field2
                        Case $24
                            If (isdoubleitem(i_1499\Field0, $01) <> 0) Then
                                Return $00
                            EndIf
                        Case $25
                            If (isdoubleitem(i_1499\Field0, $02) <> 0) Then
                                Return $00
                            EndIf
                    End Select
                    drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                    local4 = (mo\Field9 - (local44 Sar $01))
                    local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                    renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field12, 100.0, $64, $64, $64)
                EndIf
            Case $40,$41,$42
                If (preventitemoverlapping($00, $01, $00, $01, $00, $00, $01) = $00) Then
                    Select selecteditem\Field4\Field2
                        Case $40
                            If (isdoubleitem(wi\Field5, $01) <> 0) Then
                                Return $00
                            EndIf
                        Case $41
                            If (isdoubleitem(wi\Field5, $02) <> 0) Then
                                Return $00
                            EndIf
                        Case $42
                            If (isdoubleitem(wi\Field5, $03) <> 0) Then
                                Return $00
                            EndIf
                    End Select
                    drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                    local4 = (mo\Field9 - (local44 Sar $01))
                    local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                    renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field14, 100.0, $64, $64, $64)
                EndIf
            Case $43,$44
                If (preventitemoverlapping($00, $00, $00, $01, $01, $00, $01) = $00) Then
                    drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                    local4 = (mo\Field9 - (local44 Sar $01))
                    local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                    renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field14, 100.0, $64, $64, $64)
                EndIf
            Case $26
                If (preventitemoverlapping($01, $01, $01, $01, $01, $00, $00) = $00) Then
                    drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                    local4 = (mo\Field9 - (local44 Sar $01))
                    local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                    renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field12, 100.0, $64, $64, $64)
                EndIf
            Case $0D,$0E,$0F
                If (preventitemoverlapping($01, $01, $01, $00, $01, $00, $01) = $00) Then
                    Select selecteditem\Field4\Field2
                        Case $0D
                            If (isdoubleitem(i_268\Field0, $01) <> 0) Then
                                Return $00
                            EndIf
                        Case $0E
                            If (isdoubleitem(i_268\Field0, $02) <> 0) Then
                                Return $00
                            EndIf
                        Case $0F
                            If (isdoubleitem(i_268\Field0, $03) <> 0) Then
                                Return $00
                            EndIf
                    End Select
                    drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                    local4 = (mo\Field9 - (local44 Sar $01))
                    local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                    renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field12, 100.0, $64, $64, $64)
                EndIf
            Case $27,$28
                drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                local4 = (mo\Field9 - (local44 Sar $01))
                local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field12, 100.0, $64, $64, $64)
            Case $3C,$3D,$3E,$3F
                drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                local4 = (mo\Field9 - (local44 Sar $01))
                local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field12, 100.0, $64, $64, $64)
            Case $59,$5A,$5B,$5C,$5D,$5E,$5F,$60,$1E,$1F,$64,$65,$66,$6A,$08,$09,$0A,$68,$67,$69,$6B,$61,$62
                drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
            Case $34,$36,$35
                If ((((0.0 <> me\Field32) Lor (0.0 <> me\Field31)) And (wi\Field2 = $00)) <> 0) Then
                    drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                    local4 = (mo\Field9 - (local44 Sar $01))
                    local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                    renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field12, 100.0, $64, $64, $64)
                EndIf
            Case $2B
                If (canuseitem($01, $00, $00) <> 0) Then
                    drawblock(selecteditem\Field4\Field7, (mo\Field9 - local37), (mo\Field10 - local37), $00)
                    local4 = (mo\Field9 - (local44 Sar $01))
                    local5 = (Int ((Float mo\Field10) + (80.0 * menuscale)))
                    renderbar(blinkmeterimg, local4, local5, local44, local45, selecteditem\Field14, 100.0, $64, $64, $64)
                EndIf
            Case $00,$01
                If (selecteditem\Field4\Field11 = $00) Then
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                    Select selecteditem\Field4\Field1
                        Case "Burnt Note"
                            setbuffer(imagebuffer(selecteditem\Field4\Field11, $00))
                            color($00, $00, $00)
                            setfontex(fo\Field0[$00])
                            textex((Int (277.0 * menuscale)), (Int (469.0 * menuscale)), (Str code_dr_maynard), $01, $01)
                            setbuffer(backbuffer())
                        Case "Unknown Note"
                            setbuffer(imagebuffer(selecteditem\Field4\Field11, $00))
                            color($55, $55, $8C)
                            setfontex(fo\Field0[$04])
                            textex((Int (300.0 * menuscale)), (Int (275.0 * menuscale)), (Str code_o5_council), $01, $01)
                            setbuffer(backbuffer())
                        Case "Document SCP-372"
                            setbuffer(imagebuffer(selecteditem\Field4\Field11, $00))
                            color($25, $2D, $89)
                            setfontex(fo\Field0[$04])
                            textex((Int (383.0 * menuscale)), (Int (734.0 * menuscale)), (Str code_maintenance_tunnels), $01, $01)
                            setbuffer(backbuffer())
                    End Select
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    adaptscreengamma()
                EndIf
                If (-6.0 < me\Field10) Then
                    drawblock(selecteditem\Field4\Field11, (mo\Field9 - selecteditem\Field4\Field13), (mo\Field10 - selecteditem\Field4\Field14), $00)
                EndIf
            Case $20
                If (((selecteditem\Field4\Field11 <> $00) And (-6.0 < me\Field10)) <> 0) Then
                    drawblock(selecteditem\Field4\Field11, (mo\Field9 - selecteditem\Field4\Field13), (mo\Field10 - selecteditem\Field4\Field14), $00)
                EndIf
            Case $21
                If (((selecteditem\Field4\Field11 <> $00) And (-6.0 < me\Field10)) <> 0) Then
                    drawblock(selecteditem\Field4\Field11, (mo\Field9 - selecteditem\Field4\Field13), (mo\Field10 - selecteditem\Field4\Field14), $00)
                EndIf
            Case $45,$46,$47,$48
                If (((selecteditem\Field4\Field11 <> $00) And (-6.0 < me\Field10)) <> 0) Then
                    local23 = ""
                    local4 = (opt\Field46 - selecteditem\Field4\Field13)
                    local5 = (opt\Field47 - selecteditem\Field4\Field14)
                    drawimage(selecteditem\Field4\Field11, local4, local5, $00)
                    If (((((0.0 < selecteditem\Field12) Lor (selecteditem\Field4\Field2 = $47)) Lor (selecteditem\Field4\Field2 = $48)) And ((16.0 < coffindistance) Lor (coffindistance > rnd(16.0, 0.0)))) <> 0) Then
                        If (((playerroom\Field7\Field6 <> $69) And (8.0 <= coffindistance)) <> 0) Then
                            Select (Int selecteditem\Field13)
                                Case $00
                                    If (opt\Field24 = $00) Then
                                        local23 = format(getlocalstring("radio", "usertrack"), getlocalstring("radio", "notenable"), "%s")
                                    ElseIf (usertrackmusicamount < $01) Then
                                        local23 = format(getlocalstring("radio", "usertrack"), getlocalstring("radio", "nofound"), "%s")
                                    ElseIf (channelplaying(radiochn[$00]) <> 0) Then
                                        local23 = format(getlocalstring("radio", "usertrack"), upper(usertrackname[(Int radiostate[$00])]), "%s")
                                    EndIf
                                Case $01
                                    local23 = getlocalstring("radio", "warn")
                                Case $02
                                    local23 = getlocalstring("radio", "onsite")
                                Case $03
                                    local23 = getlocalstring("radio", "emergency")
                            End Select
                            local4 = (Int ((66.0 * menuscale) + (Float local4)))
                            local5 = (Int ((419.0 * menuscale) + (Float local5)))
                            If (((selecteditem\Field4\Field2 = $45) Lor (selecteditem\Field4\Field2 = $46)) <> 0) Then
                                local20 = (Int ceil((selecteditem\Field12 / 20.0)))
                                color((((local20 < $03) * $AA) + $1E), ((local20 < $03) * $1E), ((local20 < $03) * $1E))
                                For local7 = $00 To $04 Step $01
                                    rect(local4, (Int (((Float (local7 Shl $03)) * menuscale) + (Float local5))), (Int ((43.0 * menuscale) - ((Float (local7 * $06)) * menuscale))), (Int (4.0 * menuscale)), (local20 > ($04 - local7)))
                                Next
                            EndIf
                            setfontex(fo\Field0[$02])
                            color($1E, $1E, $1E)
                            textex((Int ((50.0 * menuscale) + (Float local4))), local5, getlocalstring("radio", "chn"), $00, $00)
                            If (selecteditem\Field4\Field2 = $48) Then
                                local23 = ""
                                For local7 = $00 To rand($05, $1E) Step $01
                                    local23 = (local23 + chr(rand($64, $01)))
                                Next
                                setfontex(fo\Field0[$03])
                                textex((Int ((97.0 * menuscale) + (Float local4))), (Int ((16.0 * menuscale) + (Float local5))), (Str rand($00, $09)), $01, $01)
                            Else
                                setfontex(fo\Field0[$03])
                                textex((Int ((97.0 * menuscale) + (Float local4))), (Int ((16.0 * menuscale) + (Float local5))), (Str (Int (selecteditem\Field13 + 1.0))), $01, $01)
                            EndIf
                            setfontex(fo\Field0[$02])
                            If (local23 <> "") Then
                                local23 = right(left(local23, ((millisec / $12C) Mod len(local23))), $0A)
                                textex((Int ((Float local4) - (28.0 * menuscale))), (Int ((33.0 * menuscale) + (Float local5))), (("          " + local23) + "          "), $00, $00)
                            EndIf
                            setfontex(fo\Field0[$00])
                        EndIf
                    EndIf
                EndIf
            Case $49,$4A,$4B,$4C
                If (((selecteditem\Field4\Field11 <> $00) And (-6.0 < me\Field10)) <> 0) Then
                    local4 = (Int ((Float (opt\Field46 - selecteditem\Field4\Field13)) + (20.0 * menuscale)))
                    local5 = (Int ((Float (opt\Field47 - selecteditem\Field4\Field14)) - (85.0 * menuscale)))
                    drawimage(selecteditem\Field4\Field11, (local4 - selecteditem\Field4\Field13), (Int ((Float (local5 - selecteditem\Field4\Field14)) + (85.0 * menuscale))), $00)
                    setfontex(fo\Field0[$02])
                    local53 = ((selecteditem\Field4\Field2 = $4A) Lor (selecteditem\Field4\Field2 = $49))
                    local54 = (Int (287.0 * menuscale))
                    local55 = (Int (256.0 * menuscale))
                    local56 = (Int (24.0 * menuscale))
                    local57 = (local56 Sar $01)
                    local58 = (local54 Sar $01)
                    local59 = (local55 Sar $01)
                    If (((playerinreachableroom($01, $00) = $00) Lor (infacility <> $00)) <> 0) Then
                        If ((millisec Mod $320) < $C8) Then
                            color($C8, $00, $00)
                            textex(local4, (Int ((Float (local5 + local59)) - (80.0 * menuscale))), getlocalstring("msg", "nav.error"), $01, $00)
                            textex(local4, (Int ((Float (local5 + local59)) - (60.0 * menuscale))), getlocalstring("msg", "nav.locunknown"), $01, $00)
                        EndIf
                    ElseIf (((((0.0 < selecteditem\Field12) Lor (selecteditem\Field4\Field2 = $4A)) Lor (selecteditem\Field4\Field2 = $4C)) And ((16.0 < coffindistance) Lor (coffindistance > rnd(16.0, 0.0)))) <> 0) Then
                        local60 = (local4 - selecteditem\Field4\Field13)
                        local61 = (Int ((Float (local5 - selecteditem\Field4\Field14)) + (85.0 * menuscale)))
                        If (0.0 = selecteditem\Field13) Then
                            local62 = entityx(me\Field60, $00)
                            local63 = entityz(me\Field60, $00)
                            local64 = (Int floor(((local62 / 8.0) + 0.5)))
                            local65 = (Int floor(((local63 / 8.0) + 0.5)))
                            setbuffer(imagebuffer(t\Field1[$07], $00))
                            drawimage(selecteditem\Field4\Field11, local60, local61, $00)
                            local4 = (Int ((((local62 - 4.0) Mod 8.0) * (3.0 * menuscale)) + ((Float local4) - (12.0 * menuscale))))
                            local5 = (Int (((12.0 * menuscale) + (Float local5)) - (((local63 - 4.0) Mod 8.0) * (3.0 * menuscale))))
                            local66 = (Int max(1.0, (Float (local64 - $06))))
                            local67 = (Int min(20.0, (Float (local64 + $06))))
                            local68 = (Int max(1.0, (Float (local65 - $06))))
                            local69 = (Int min(20.0, (Float (local65 + $06))))
                            For local11 = (Float local66) To (Float local67) Step 1.0
                                For local16 = (Float local68) To (Float local69) Step 1.0
                                    If (((currmapgrid\Field0[(Int ((local16 * 21.0) + local11))] > $00) And ((currmapgrid\Field2[(Int ((local16 * 21.0) + local11))] > $00) Lor (local53 = $00))) <> 0) Then
                                        local70 = (Int ((((Float local64) - local11) * (Float local56)) + (Float local4)))
                                        local71 = (Int ((Float local5) - (((Float local65) - local16) * (Float local56))))
                                        color(((((selecteditem\Field4\Field2 = $4C) And ((currmapgrid\Field0[(Int ((local16 * 21.0) + local11))] <= $00) Lor (currmapgrid\Field2[(Int ((local16 * 21.0) + local11))] <= $00))) * $46) + $82), $1E, $1E)
                                        If (currmapgrid\Field0[(Int ((local11 + 1.0) + (local16 * 21.0)))] = $00) Then
                                            rect((local70 - local57), (local71 - local57), $01, local56, $01)
                                        EndIf
                                        If (currmapgrid\Field0[(Int ((local11 - 1.0) + (local16 * 21.0)))] = $00) Then
                                            rect((local70 + local57), (local71 - local57), $01, local56, $01)
                                        EndIf
                                        If (currmapgrid\Field0[(Int (((local16 - 1.0) * 21.0) + local11))] = $00) Then
                                            rect((local70 - local57), (local71 - local57), local56, $01, $01)
                                        EndIf
                                        If (currmapgrid\Field0[(Int (((local16 + 1.0) * 21.0) + local11))] = $00) Then
                                            rect((local70 - local57), (local71 + local57), local56, $01, $01)
                                        EndIf
                                    EndIf
                                Next
                            Next
                            setbuffer(backbuffer())
                            selecteditem\Field13 = 2.0
                        Else
                            selecteditem\Field13 = max(0.0, (selecteditem\Field13 - fps\Field7[$00]))
                        EndIf
                        drawblockrect(t\Field1[$07], (Int ((80.0 * menuscale) + (Float local60))), (Int ((70.0 * menuscale) + (Float local61))), (Int ((80.0 * menuscale) + (Float local60))), (Int ((70.0 * menuscale) + (Float local61))), (Int (270.0 * menuscale)), (Int (230.0 * menuscale)), $00)
                        color((($AA * local53) + $1E), ($1E * local53), ($1E * local53))
                        rect((Int ((80.0 * menuscale) + (Float local60))), (Int ((70.0 * menuscale) + (Float local61))), (Int (270.0 * menuscale)), (Int (230.0 * menuscale)), $00)
                        local4 = (Int ((Float (opt\Field46 - selecteditem\Field4\Field13)) + (20.0 * menuscale)))
                        local5 = (Int ((Float (opt\Field47 - selecteditem\Field4\Field14)) - (85.0 * menuscale)))
                        color((($AA * local53) + $1E), ($1E * local53), ($1E * local53))
                        If ((millisec Mod $320) < $C8) Then
                            If (local53 <> 0) Then
                                textex((Int ((10.0 * menuscale) + (Float (local4 - local58)))), (Int ((10.0 * menuscale) + (Float (local5 - local59)))), getlocalstring("msg", "nav.data"), $00, $00)
                            EndIf
                            local8 = (entityyaw(me\Field60, $00) - 90.0)
                            local10 = (((6.0 * menuscale) * cos(local8)) + (Float local4))
                            local13 = ((Float local5) - ((6.0 * menuscale) * sin(local8)))
                            local11 = ((cos((local8 - 140.0)) * (5.0 * menuscale)) + (Float local4))
                            local14 = ((Float local5) - (sin((local8 - 140.0)) * (5.0 * menuscale)))
                            local12 = ((cos((local8 + 140.0)) * (5.0 * menuscale)) + (Float local4))
                            local15 = ((Float local5) - (sin((local8 + 140.0)) * (5.0 * menuscale)))
                            line((Int local10), (Int local13), (Int local11), (Int local14))
                            line((Int local10), (Int local13), (Int local12), (Int local15))
                            line((Int local11), (Int local14), (Int local12), (Int local15))
                        EndIf
                        local72 = $00
                        If (selecteditem\Field4\Field2 = $4C) Then
                            local76 = $00
                            local77 = $00
                            For local75 = Each rooms
                                local78 = local75\Field7\Field6
                                If ((((((local78 <> $04) And (local78 <> $47)) And (local78 <> $49)) And (local78 <> $69)) And (local78 <> $6A)) <> 0) Then
                                    local76 = (local76 + $01)
                                    local77 = (local77 + local75\Field1)
                                EndIf
                            Next
                            textex((Int ((10.0 * menuscale) + (Float (local4 - local58)))), (Int ((10.0 * menuscale) + (Float (local5 - local59)))), (((Str local77) + "/") + (Str local76)), $00, $00)
                            If ((millisec Mod $258) < $190) Then
                                color($C8, $00, $00)
                                For local74 = Each npcs
                                    If ((((((local74\Field4 = $07) Lor (local74\Field4 = $06)) Lor (local74\Field4 = $05)) Lor (local74\Field4 = $02)) Lor (local74\Field4 = $04)) <> 0) Then
                                        If (local74\Field43 = $00) Then
                                            local73 = entitydistancesquared(camera, local74\Field3)
                                            If (900.0 > local73) Then
                                                local24 = sqr(local73)
                                                oval((Int ((Float local4) - ((1.5 * menuscale) * local24))), (Int ((Float local5) - ((1.5 * menuscale) * local24))), (Int ((3.0 * menuscale) * local24)), (Int ((3.0 * menuscale) * local24)), $00)
                                                textex((Int ((10.0 * menuscale) + (Float (local4 - local58)))), (Int (((30.0 * menuscale) + (Float (local5 - local59))) + ((Float ($14 * local72)) * menuscale))), local74\Field47, $00, $00)
                                                local72 = (local72 + $01)
                                            EndIf
                                        EndIf
                                    EndIf
                                Next
                                If (playerroom\Field7\Field6 = $2C) Then
                                    If (8.0 > coffindistance) Then
                                        local73 = rnd(4.0, 8.0)
                                        oval((Int ((Float local4) - ((1.5 * menuscale) * local73))), (Int ((Float local5) - ((1.5 * menuscale) * local73))), (Int ((3.0 * menuscale) * local73)), (Int ((3.0 * menuscale) * local73)), $00)
                                        textex((Int ((10.0 * menuscale) + (Float (local4 - local58)))), (Int (((30.0 * menuscale) + (Float (local5 - local59))) + ((Float ($14 * local72)) * menuscale))), "SCP-895", $00, $00)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (((0.0 < selecteditem\Field12) And ((selecteditem\Field4\Field2 = $49) Lor (selecteditem\Field4\Field2 = $4B))) <> 0) Then
                            local21 = (Int ((196.0 * menuscale) + (Float (local4 - local58))))
                            local22 = (Int ((10.0 * menuscale) + (Float (local5 - local59))))
                            local20 = (Int min(ceil((selecteditem\Field12 / 10.0)), 10.0))
                            color((((local20 < $03) * $AA) + $1E), ((local20 < $03) * $1E), ((local20 < $03) * $1E))
                            rect(local21, local22, (Int (80.0 * menuscale)), (Int (20.0 * menuscale)), $00)
                            For local7 = $01 To local20 Step $01
                                rect((Int ((((Float (local7 Shl $03)) * menuscale) + (Float local21)) - (6.0 * menuscale))), (Int ((4.0 * menuscale) + (Float local22))), (Int (4.0 * menuscale)), (Int (12.0 * menuscale)), $01)
                            Next
                        EndIf
                    EndIf
                    setfontex(fo\Field0[$00])
                EndIf
            Case $06,$07
                If (((selecteditem\Field4\Field11 <> $00) And (-6.0 < me\Field10)) <> 0) Then
                    drawimage(selecteditem\Field4\Field11, (mo\Field9 - selecteditem\Field4\Field13), (mo\Field10 - selecteditem\Field4\Field14), $00)
                EndIf
            Case $03,$04,$05
                If (((selecteditem\Field4\Field11 <> $00) And (-6.0 < me\Field10)) <> 0) Then
                    drawblock(selecteditem\Field4\Field11, (mo\Field9 - selecteditem\Field4\Field13), (mo\Field10 - selecteditem\Field4\Field14), $00)
                EndIf
            Case $4D,$4E,$4F
                If (((selecteditem\Field4\Field11 <> $00) And (-6.0 < me\Field10)) <> 0) Then
                    local4 = (mo\Field9 - selecteditem\Field4\Field13)
                    local5 = (mo\Field10 - selecteditem\Field4\Field14)
                    drawimage(selecteditem\Field4\Field11, local4, local5, $00)
                    local3 = (0.0 < selecteditem\Field12)
                    If (((local3 Lor (selecteditem\Field4\Field2 = $4F)) And ((16.0 < coffindistance) Lor (coffindistance > rnd(16.0, 0.0)))) <> 0) Then
                        If (local3 <> 0) Then
                            local20 = (Int min(ceil((selecteditem\Field12 / 10.0)), 10.0))
                            color((((local20 < $03) * $AA) + $1E), ((local20 < $03) * $1E), ((local20 < $03) * $1E))
                            rect((Int ((406.0 * menuscale) + (Float local4))), (Int ((90.0 * menuscale) + (Float local5))), (Int (80.0 * menuscale)), (Int (20.0 * menuscale)), $00)
                            For local7 = $01 To local20 Step $01
                                rect((Int ((((Float (local7 Shl $03)) * menuscale) + (Float local4)) + (400.0 * menuscale))), (Int ((94.0 * menuscale) + (Float local5))), (Int (4.0 * menuscale)), (Int (12.0 * menuscale)), $01)
                            Next
                        EndIf
                        color($1E, $1E, $1E)
                        If (0.0 = selecteditem\Field13) Then
                            If ((millisec Mod $320) < $C8) Then
                                setfont(fo\Field0[$02])
                                textex(mo\Field9, (Int ((Float mo\Field10) - (100.0 * menuscale))), getlocalstring("msg", "e.reader.welcome"), $01, $01)
                                setfont(fo\Field0[$00])
                            EndIf
                        Else
                            textex((Int ((70.0 * menuscale) + (Float local4))), (Int ((94.0 * menuscale) + (Float local5))), (((Str (Int selecteditem\Field13)) + "/") + "41"), $00, $00)
                            If (selecteditem\Field4\Field12 <> $00) Then
                                drawblock(selecteditem\Field4\Field12, (mo\Field9 - selecteditem\Field4\Field15), (Int ((Float (mo\Field10 - selecteditem\Field4\Field16)) - (12.0 * menuscale))), $00)
                            EndIf
                        EndIf
                    EndIf
                EndIf
        End Select
    EndIf
    catcherrors("Uncaught: RenderGUI()")
    Return $00
End Function
