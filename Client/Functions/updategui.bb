Function updategui%()
    Local local0.events
    Local local1.items
    Local local2.rooms
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9#
    Local local10#
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15$
    Local local17%
    Local local18%
    Local local19%
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local25.items
    Local local26.items
    Local local27%
    Local local28%
    Local local29%
    Local local30%
    Local local31%
    Local local32%
    Local local33%
    Local local34%
    Local local35#
    Local local36%
    Local local37%
    Local local38%
    Local local41.items
    Local local42%
    Local local43%
    Local local67%
    Local local68%
    Local local76%
    Local local77%
    Local local79.itemtemplates
    catcherrors("UpdateGUI()")
    If (((pd_event <> Null) And (pd_event\Field1 = playerroom)) <> 0) Then
        If ((((wi\Field5 > $00) Lor (wi\Field9 > $00)) And (5.0 <> pd_event\Field3)) <> 0) Then
            If (pd_event\Field15 <> $00) Then
                stopchannel(pd_event\Field6)
                freeimage(pd_event\Field15)
                pd_event\Field15 = $00
            EndIf
            If (pd_event\Field14 = $00) Then
                stopchannel(pd_event\Field6)
                pd_event\Field6 = $00
                Select rand($05, $01)
                    Case $01
                        playsound_strict(snd_i\Field47[$01], $00)
                    Case $02
                        playsound_strict(snd_i\Field47[$02], $00)
                    Case $03
                        playsound_strict(snd_i\Field47[$09], $00)
                    Case $04
                        playsound_strict(snd_i\Field47[$0A], $00)
                    Case $05
                        playsound_strict(snd_i\Field47[$0C], $00)
                End Select
                pd_event\Field14 = scaleimageex(loadimage_strict("GFX\Overlays\scp_106_face_overlay.png"), menuscale, menuscale, $01)
            Else
                wi\Field7 = $01
                If (rand($1E, $01) = $01) Then
                    If (channelplaying(pd_event\Field6) = $00) Then
                        pd_event\Field6 = playsound_strict(snd_i\Field30[rand($00, $03)], $00)
                    EndIf
                EndIf
            EndIf
        Else
            If (pd_event\Field14 <> $00) Then
                stopchannel(pd_event\Field6)
                freeimage(pd_event\Field14)
                pd_event\Field14 = $00
            EndIf
            If (2.0 = pd_event\Field3) Then
                If (((-16.0 < me\Field10) And (-6.0 > me\Field10)) <> 0) Then
                    If (pd_event\Field15 = $00) Then
                        stopchannel(pd_event\Field6)
                        pd_event\Field6 = $00
                        playsound_strict(pd_event\Field9, $01)
                        pd_event\Field15 = scaleimageex(loadimage_strict("GFX\Overlays\kneel_mortal_overlay.png"), menuscale, menuscale, $01)
                    ElseIf (channelplaying(pd_event\Field6) = $00) Then
                        pd_event\Field6 = playsound_strict(pd_event\Field8, $00)
                        channelvolume(pd_event\Field6, (opt\Field21 * opt\Field16))
                    EndIf
                ElseIf (channelplaying(pd_event\Field6) <> 0) Then
                    stopchannel(pd_event\Field6)
                    pd_event\Field6 = $00
                EndIf
            ElseIf (pd_event\Field15 <> $00) Then
                freeimage(pd_event\Field15)
                pd_event\Field15 = $00
                stopchannel(pd_event\Field6)
                pd_event\Field6 = $00
            EndIf
        EndIf
    EndIf
    If ((((menuopen Lor (Int me\Field0)) Lor consoleopen) Lor ismultiplayerhudenabled) = $00) Then
        If (i_294\Field0 <> 0) Then
            update294()
        EndIf
        If (((((invopen Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) = $00) Then
            If (d_i\Field9 <> $00) Then
                If (mo\Field6 <> 0) Then
                    mo\Field6 = $00
                    If (d_i\Field7 <> Null) Then
                        If (d_i\Field7\Field19 <> $00) Then
                            d_i\Field6 = d_i\Field7
                        ElseIf (me\Field9 <> 0) Then
                            usedoor($01)
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (selectedscreen <> Null) Then
            If ((mo\Field6 Lor mo\Field1) <> 0) Then
                freeimage(selectedscreen\Field2)
                selectedscreen\Field2 = $00
                mo\Field6 = $00
                selectedscreen = Null
            EndIf
        EndIf
    EndIf
    local17 = invopen
    local18 = $42
    local19 = $01
    If (d_i\Field6 <> Null) Then
        If (selecteditem <> Null) Then
            If ((((selecteditem\Field4\Field2 = $08) Lor (selecteditem\Field4\Field2 = $09)) Lor (selecteditem\Field4\Field2 = $0A)) <> 0) Then
                usedoor($01)
                local19 = $00
            Else
                selecteditem = Null
            EndIf
        EndIf
        If (local19 <> 0) Then
            local20 = entityx(d_i\Field9, $01)
            local21 = entityy(d_i\Field9, $01)
            local22 = entityz(d_i\Field9, $01)
            camerazoom(camera, (min(((me\Field52 / 400.0) + 1.0), 1.1) / camerazoomvalue))
            local11 = createpivot($00)
            positionentity(local11, local20, local21, local22, $00)
            rotateentity(local11, 0.0, (entityyaw(d_i\Field9, $01) - 180.0), 0.0, $00)
            moveentity(local11, 0.0, 0.0, 0.22)
            positionentity(camera, entityx(local11, $00), entityy(local11, $00), entityz(local11, $00), $00)
            pointentity(camera, d_i\Field9, 0.0)
            freeentity(local11)
            local11 = $00
            local10 = (meshheight(d_i\Field2[$00]) * 0.015)
            cameraproject(camera, local20, (local21 + local10), local22)
            local9 = projectedy()
            cameraproject(camera, local20, (local21 - local10), local22)
            local10 = ((projectedy() - local9) / (462.0 * menuscale))
            local23 = (local10 / 2.0)
            local4 = (Int ((Float mo\Field9) - ((Float imagewidth(t\Field1[$04])) * local23)))
            local5 = (Int ((Float mo\Field10) - ((Float imageheight(t\Field1[$04])) * local23)))
            If (msg\Field3 <> "") Then
                msg\Field4 = (msg\Field4 - fps\Field7[$00])
                If (0.0 >= msg\Field4) Then
                    msg\Field3 = ""
                    d_i\Field6 = Null
                    stopmousemovement()
                EndIf
            EndIf
            If (menuopen = $00) Then
                local4 = (Int (((44.0 * menuscale) * local10) + (Float local4)))
                local5 = (Int (((249.0 * menuscale) * local10) + (Float local5)))
                For local12 = $00 To $03 Step $01
                    For local7 = $00 To $02 Step $01
                        local13 = ((Int (((58.5 * menuscale) * local10) * (Float local12))) + local4)
                        local14 = (Int ((((67.0 * menuscale) * local10) * (Float local7)) + (Float local5)))
                        local3 = $00
                        If ((mouseon(local13, local14, (Int ((54.0 * menuscale) * local10)), (Int ((65.0 * menuscale) * local10))) And (msg\Field3 = "")) <> 0) Then
                            If (mo\Field6 <> 0) Then
                                playsound_strict(buttonsfx[$00], $00)
                                Select ((local12 + $01) + (local7 Shl $02))
                                    Case $01,$02,$03
                                        msg\Field5 = (msg\Field5 + (Str ((local12 + $01) + (local7 Shl $02))))
                                    Case $04
                                        msg\Field5 = (msg\Field5 + "0")
                                    Case $05,$06,$07
                                        msg\Field5 = (msg\Field5 + (Str (((local12 + $01) + (local7 Shl $02)) - $01)))
                                    Case $08
                                        usedoor($01)
                                        If ((Int msg\Field5) = d_i\Field6\Field19) Then
                                            d_i\Field6 = Null
                                            stopmousemovement()
                                        Else
                                            msg\Field3 = getlocalstring("msg", "denied")
                                            msg\Field4 = 210.0
                                            msg\Field5 = ""
                                        EndIf
                                    Case $09,$0A,$0B
                                        msg\Field5 = (msg\Field5 + (Str (((local12 + $01) + (local7 Shl $02)) - $02)))
                                    Case $0C
                                        msg\Field5 = ""
                                End Select
                                If (len(msg\Field5) > $04) Then
                                    msg\Field5 = left(msg\Field5, $04)
                                EndIf
                            EndIf
                        Else
                            local3 = $00
                        EndIf
                    Next
                Next
                If (mo\Field1 <> 0) Then
                    d_i\Field6 = Null
                    stopmousemovement()
                EndIf
            EndIf
        Else
            d_i\Field6 = Null
        EndIf
    Else
        msg\Field5 = ""
        msg\Field4 = 0.0
        msg\Field3 = ""
    EndIf
    If ((((((0.0 <= me\Field45) And (me\Field43 = $FFFFFFFF)) And ((400.0 >= me\Field2) Lor (mp_terminated\Field0 And (0.0 >= mp_terminated\Field6)))) And (ismultiplayerhudenabled = $00)) And keyhit($01)) <> 0) Then
        If (menuopen <> 0) Then
            If (mp_getsocket() = $00) Then
                resumesounds()
            EndIf
            If (igm\Field2 <> $00) Then
                saveoptionsini($00)
            EndIf
            stopmousemovement()
            shoulddeletegadgets = $01
            flushkeys()
        ElseIf (mp_getsocket() = $00) Then
            pausesounds()
        EndIf
        menuopen = (menuopen = $00)
        igm\Field0 = $00
        igm\Field2 = $00
        igm\Field1 = $00
    EndIf
    updatebatterytimer()
    local29 = (Int (70.0 * menuscale))
    local30 = (Int (35.0 * menuscale))
    local31 = (maxitemamount Sar $01)
    If (otheropen <> Null) Then
        local25 = otheropen
        local32 = otheropen\Field20
        For local7 = $00 To (local32 - $01) Step $01
            If (otheropen\Field18[local7] <> Null) Then
                local33 = (local33 + $01)
            EndIf
        Next
        invopen = $00
        d_i\Field6 = Null
        local34 = $00
        local4 = (mo\Field9 - ((((local29 * $0A) Sar $01) + (local30 Shl $02)) Sar $01))
        local5 = ((mo\Field10 - ((((local32 / $0A) Shl $01) - $01) * local29)) - local30)
        local27 = $FFFFFFFF
        For local12 = $00 To (local32 - $01) Step $01
            If (mouseon(local4, local5, local29, local29) <> 0) Then
                local27 = local12
            EndIf
            If (local27 = local12) Then
                local18 = local12
            EndIf
            If (otheropen = Null) Then
                Exit
            EndIf
            If (((otheropen\Field18[local12] <> Null) And (selecteditem <> otheropen\Field18[local12])) <> 0) Then
                If (local27 = local12) Then
                    If (selecteditem = Null) Then
                        If (mo\Field0 <> 0) Then
                            selecteditem = otheropen\Field18[local12]
                            If ((mo\Field3 And (mo\Field4 = local12)) <> 0) Then
                                If (((((selecteditem\Field4\Field2 = $1B) Lor (selecteditem\Field4\Field2 = $1A)) Lor (selecteditem\Field4\Field2 = $1C)) Lor (selecteditem\Field4\Field2 = $1D)) <> 0) Then
                                    createmsg(getlocalstring("msg", "wallet.714"), 6.0)
                                    selecteditem = Null
                                    Return $00
                                EndIf
                                If (otheropen\Field18[local12]\Field4\Field3 <> $42) Then
                                    playsound_strict(snd_i\Field44[otheropen\Field18[local12]\Field4\Field3], $00)
                                EndIf
                                otheropen = Null
                                local28 = $01
                                invopen = $00
                                mo\Field3 = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            ElseIf (((local27 = local12) And mo\Field0) <> 0) Then
                For local6 = $00 To (local32 - $01) Step $01
                    If (otheropen\Field18[local6] = selecteditem) Then
                        otheropen\Field18[local6] = Null
                        Exit
                    EndIf
                Next
                otheropen\Field18[local12] = selecteditem
                selecteditem = Null
            EndIf
            local4 = ((local4 + local29) + local30)
            local34 = (local34 + $01)
            If (local34 = $05) Then
                local34 = $00
                local5 = (local5 + (local29 Shl $01))
                local4 = (mo\Field9 - ((((local29 * $0A) Sar $01) + (local30 Shl $02)) Sar $01))
            EndIf
        Next
        If (mo\Field0 <> 0) Then
            mo\Field4 = local27
        EndIf
        If (selecteditem <> Null) Then
            If (((mo\Field2 = $00) Lor mo\Field1) <> 0) Then
                If (local18 = $42) Then
                    local35 = entityyaw(camera, $00)
                    If (selecteditem\Field4\Field3 <> $42) Then
                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                    EndIf
                    showentity(selecteditem\Field2)
                    positionentity(selecteditem\Field2, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                    rotateentity(selecteditem\Field2, entitypitch(camera, $00), (rnd(-20.0, 20.0) + local35), 0.0, $00)
                    moveentity(selecteditem\Field2, 0.0, -0.1, 0.1)
                    rotateentity(selecteditem\Field2, 0.0, (rnd(-110.0, 110.0) + local35), 0.0, $00)
                    resetentity(selecteditem\Field2)
                    selecteditem\Field16 = $01
                    selecteditem\Field15 = $00
                    mp_dropitem(selecteditem)
                    For local6 = $00 To (local32 - $01) Step $01
                        If (otheropen\Field18[local6] = selecteditem) Then
                            otheropen\Field18[local6] = Null
                            Exit
                        EndIf
                    Next
                    local36 = $01
                    For local6 = $00 To (local32 - $01) Step $01
                        If (otheropen\Field18[local6] <> Null) Then
                            local36 = $00
                            Exit
                        EndIf
                    Next
                    If (local36 <> 0) Then
                        If (otheropen\Field4\Field2 = $2D) Then
                            otheropen\Field17 = otheropen\Field4\Field8
                            setanimtime(otheropen\Field3, 17.0, $00)
                        ElseIf (otheropen\Field4\Field2 = $2E) Then
                            otheropen\Field17 = otheropen\Field4\Field8
                            setanimtime(otheropen\Field3, 0.0, $00)
                        EndIf
                    EndIf
                    selecteditem = Null
                    If (mo\Field1 = $00) Then
                        otheropen = Null
                        local28 = $01
                        movemouse(mo\Field9, mo\Field10)
                    EndIf
                ElseIf (local25\Field18[local18] = Null) Then
                    For local6 = $00 To (local32 - $01) Step $01
                        If (local25\Field18[local6] = selecteditem) Then
                            local25\Field18[local6] = Null
                            Exit
                        EndIf
                    Next
                    local25\Field18[local18] = selecteditem
                    selecteditem = Null
                ElseIf (local25\Field18[local18] <> selecteditem) Then
                    local26 = local25\Field18[local18]
                    local37 = selecteditem\Field4\Field2
                    For local6 = $00 To (local32 - $01) Step $01
                        If (local25\Field18[local6] = selecteditem) Then
                            local25\Field18[local6] = local26
                            Exit
                        EndIf
                    Next
                    local25\Field18[local18] = selecteditem
                    selecteditem = Null
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        If ((local28 And (invopen = $00)) <> 0) Then
            otheropen = Null
            stopmousemovement()
        EndIf
    ElseIf (invopen <> 0) Then
        d_i\Field6 = Null
        local4 = (mo\Field9 - (((local29 * local31) + ((local31 - $01) * local30)) Sar $01))
        local5 = ((mo\Field10 - local29) - local30)
        If (maxitemamount = $02) Then
            local5 = (local5 + local29)
            local4 = (local4 - (((local29 * local31) + local30) Sar $01))
        EndIf
        local27 = $FFFFFFFF
        For local12 = $00 To (maxitemamount - $01) Step $01
            If (mouseon(local4, local5, local29, local29) <> 0) Then
                local27 = local12
            EndIf
            If (local27 = local12) Then
                local18 = local12
            EndIf
            If (((inventory(local12) <> Null) And (selecteditem <> inventory(local12))) <> 0) Then
                If (local27 = local12) Then
                    If (selecteditem = Null) Then
                        If (mo\Field0 <> 0) Then
                            selecteditem = inventory(local12)
                            If ((mo\Field3 And (mo\Field4 = local12)) <> 0) Then
                                If (inventory(local12)\Field4\Field3 <> $42) Then
                                    playsound_strict(snd_i\Field44[inventory(local12)\Field4\Field3], $00)
                                EndIf
                                invopen = $00
                                mo\Field3 = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            ElseIf (((local27 = local12) And mo\Field0) <> 0) Then
                For local6 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local6) = selecteditem) Then
                        inventory(local6) = Null
                        Exit
                    EndIf
                Next
                inventory(local12) = selecteditem
                selecteditem = Null
            EndIf
            local4 = ((local4 + local29) + local30)
            If (((maxitemamount >= $04) And (local12 = (local31 - $01))) <> 0) Then
                local5 = (local5 + (local29 Shl $01))
                local4 = (mo\Field9 - (((local29 * local31) + ((local31 - $01) * local30)) Sar $01))
            EndIf
        Next
        If (mo\Field0 <> 0) Then
            mo\Field4 = local27
        EndIf
        If (selecteditem <> Null) Then
            If (((mo\Field2 = $00) Lor mo\Field1) <> 0) Then
                If (local18 = $42) Then
                    Select selecteditem\Field4\Field2
                        Case $27,$28,$3C,$3D,$3E,$3F
                            local38 = $01
                        Case $38
                            local38 = (wi\Field0 = $01)
                        Case $39
                            local38 = (wi\Field0 = $02)
                        Case $3A
                            local38 = (wi\Field0 = $03)
                        Case $3B
                            local38 = (wi\Field0 = $04)
                        Case $24
                            local38 = (i_1499\Field0 = $01)
                        Case $25
                            local38 = (i_1499\Field0 = $02)
                        Case $40
                            local38 = (wi\Field5 = $01)
                        Case $41
                            local38 = (wi\Field5 = $02)
                        Case $42
                            local38 = (wi\Field5 = $03)
                        Case $43
                            local38 = (wi\Field9 = $01)
                        Case $44
                            local38 = (wi\Field9 = $02)
                        Case $26
                            local38 = wi\Field4
                        Case $0D
                            local38 = (i_268\Field0 = $01)
                        Case $0E
                            local38 = (i_268\Field0 = $02)
                        Case $0F
                            local38 = (i_268\Field0 = $03)
                        Case $1B
                            local38 = (i_714\Field0 = $02)
                        Case $1A
                            local38 = (i_714\Field0 = $01)
                        Case $14
                            local38 = i_427\Field0
                        Default
                            local38 = $00
                    End Select
                    If (local38 <> 0) Then
                        createhintmsg(getlocalstring("msg", "takeoff"), 6.0, $00)
                    Else
                        dropitem(selecteditem, $01)
                        invopen = mo\Field1
                    EndIf
                    If (mo\Field1 = $00) Then
                        movemouse(mo\Field9, mo\Field10)
                        stopmousemovement()
                    EndIf
                ElseIf (inventory(local18) = Null) Then
                    For local6 = $00 To (maxitemamount - $01) Step $01
                        If (inventory(local6) = selecteditem) Then
                            inventory(local6) = Null
                            Exit
                        EndIf
                    Next
                    inventory(local18) = selecteditem
                    selecteditem = Null
                ElseIf (inventory(local18) <> selecteditem) Then
                    local26 = inventory(local18)
                    currentsyncitem = local26
                    Select selecteditem\Field4\Field2
                        Case $00,$01,$02,$59,$5A,$5B,$5C,$5D,$5E,$5F,$60,$63,$61,$62,$03,$06,$04,$05,$07,$10,$13,$12,$11,$6A,$6B,$68,$67,$69,$1E,$1F,$1B,$1A,$1C,$1D,$16,$17,$18,$0A
                            If (inventory(local18)\Field4\Field2 = $2D) Then
                                local41 = Null
                                Select selecteditem\Field4\Field2
                                    Case $00,$01,$02,$59,$5A,$5B,$5C,$5D,$5E,$5F,$60,$63,$61,$62,$03,$06,$04,$05,$07
                                        For local42 = $00 To (inventory(local18)\Field20 - $01) Step $01
                                            If (inventory(local18)\Field18[local42] = Null) Then
                                                If (selecteditem <> Null) Then
                                                    mp_assignitem(selecteditem, inventory(local18))
                                                    inventory(local18)\Field18[local42] = selecteditem
                                                    inventory(local18)\Field12 = 1.0
                                                    setanimtime(inventory(local18)\Field3, 0.0, $00)
                                                    inventory(local18)\Field17 = inventory(local18)\Field4\Field7
                                                    For local43 = $00 To (maxitemamount - $01) Step $01
                                                        If (inventory(local43) = selecteditem) Then
                                                            inventory(local43) = Null
                                                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                                            Exit
                                                        EndIf
                                                    Next
                                                    local41 = selecteditem
                                                    selecteditem = Null
                                                    Exit
                                                EndIf
                                            EndIf
                                        Next
                                        If (selecteditem <> Null) Then
                                            createmsg(getlocalstring("msg", "clipboard.full"), 6.0)
                                        ElseIf (((local41\Field4\Field2 = $00) Lor (local41\Field4\Field2 = $01)) <> 0) Then
                                            createmsg(getlocalstring("msg", "clipboard.paper"), 6.0)
                                        ElseIf ((((((local41\Field4\Field2 = $03) Lor (local41\Field4\Field2 = $06)) Lor (local41\Field4\Field2 = $04)) Lor (local41\Field4\Field2 = $06)) Lor (local41\Field4\Field2 = $05)) <> 0) Then
                                            createmsg(format(getlocalstring("msg", "clipboard.badge"), local41\Field4\Field0, "%s"), 6.0)
                                        Else
                                            createmsg(format(getlocalstring("msg", "clipboard.add"), local41\Field4\Field0, "%s"), 6.0)
                                        EndIf
                                    Default
                                        For local6 = $00 To (maxitemamount - $01) Step $01
                                            If (inventory(local6) = selecteditem) Then
                                                inventory(local6) = local26
                                                Exit
                                            EndIf
                                        Next
                                        inventory(local18) = selecteditem
                                End Select
                            ElseIf (inventory(local18)\Field4\Field2 = $2E) Then
                                local41 = Null
                                Select selecteditem\Field4\Field2
                                    Case $00,$01,$02
                                        For local6 = $00 To (maxitemamount - $01) Step $01
                                            If (inventory(local6) = selecteditem) Then
                                                inventory(local6) = local26
                                                Exit
                                            EndIf
                                        Next
                                        inventory(local18) = selecteditem
                                    Default
                                        If ((((selecteditem\Field4\Field2 = $1B) And (i_714\Field0 = $02)) Lor ((selecteditem\Field4\Field2 = $1A) And (i_714\Field0 = $01))) <> 0) Then
                                            createmsg(getlocalstring("msg", "takeoff"), 6.0)
                                            selecteditem = Null
                                        Else
                                            For local42 = $00 To (inventory(local18)\Field20 - $01) Step $01
                                                If (inventory(local18)\Field18[local42] = Null) Then
                                                    If (selecteditem <> Null) Then
                                                        mp_assignitem(selecteditem, inventory(local18))
                                                        inventory(local18)\Field18[local42] = selecteditem
                                                        inventory(local18)\Field12 = 1.0
                                                        Select selecteditem\Field4\Field2
                                                            Case $59,$5A,$5B,$5C,$5D,$5E,$5F,$60,$63,$61,$62,$03,$06,$04,$05
                                                                setanimtime(inventory(local18)\Field3, 4.0, $00)
                                                                inventory(local18)\Field17 = inventory(local18)\Field4\Field7
                                                        End Select
                                                        For local43 = $00 To (maxitemamount - $01) Step $01
                                                            If (inventory(local43) = selecteditem) Then
                                                                inventory(local43) = Null
                                                                playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                                                Exit
                                                            EndIf
                                                        Next
                                                        local41 = selecteditem
                                                        selecteditem = Null
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (selecteditem <> Null) Then
                                                createmsg(getlocalstring("msg", "wallet.full"), 6.0)
                                            Else
                                                createmsg(format(getlocalstring("msg", "wallet.add"), local41\Field4\Field0, "%s"), 6.0)
                                            EndIf
                                        EndIf
                                End Select
                            Else
                                For local6 = $00 To (maxitemamount - $01) Step $01
                                    If (inventory(local6) = selecteditem) Then
                                        inventory(local6) = local26
                                        Exit
                                    EndIf
                                Next
                                inventory(local18) = selecteditem
                            EndIf
                            selecteditem = Null
                        Case $51
                            Select inventory(local18)\Field4\Field2
                                Case $49
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(50.0, 0.0)
                                    createmsg(getlocalstring("msg", "nav.bat"), 6.0)
                                Case $4B
                                    createmsg(getlocalstring("msg", "nav.bat.notfit"), 6.0)
                                Case $4C,$4A
                                    createmsg(getlocalstring("msg", "nav.bat.no"), 6.0)
                                Case $45
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(50.0, 0.0)
                                    createmsg(getlocalstring("msg", "radio.bat"), 6.0)
                                Case $46
                                    createmsg(getlocalstring("msg", "radio.bat.notfit"), 6.0)
                                Case $47,$48
                                    createmsg(getlocalstring("msg", "radio.bat.no"), 6.0)
                                Case $40
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(500.0, 0.0)
                                    createmsg(getlocalstring("msg", "nvg.bat"), 6.0)
                                Case $41
                                    createmsg(getlocalstring("msg", "nvg.bat.notfit"), 6.0)
                                Case $42
                                    createmsg(getlocalstring("msg", "nvg.bat.notfit"), 6.0)
                                Case $43
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(500.0, 0.0)
                                    createmsg(getlocalstring("msg", "gear.bat"), 6.0)
                                Case $44
                                    createmsg(getlocalstring("msg", "gear.bat.notfit"), 6.0)
                                Case $4D
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(50.0, 0.0)
                                    createmsg(getlocalstring("msg", "e.reader.bat"), 6.0)
                                Case $4E
                                    createmsg(getlocalstring("msg", "e.reader.bat.notfit"), 6.0)
                                Case $4F
                                    createmsg(getlocalstring("msg", "e.reader.bat.no"), 6.0)
                                Default
                                    For local6 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local6) = selecteditem) Then
                                            inventory(local6) = local26
                                            Exit
                                        EndIf
                                    Next
                                    inventory(local18) = selecteditem
                                    selecteditem = Null
                            End Select
                        Case $50
                            Select inventory(local18)\Field4\Field2
                                Case $49
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(50.0, 100.0)
                                    createmsg(getlocalstring("msg", "nav.bat"), 6.0)
                                Case $4B
                                    createmsg(getlocalstring("msg", "nav.bat.notfit"), 6.0)
                                Case $4C,$4A
                                    createmsg(getlocalstring("msg", "nav.bat.no"), 6.0)
                                Case $45
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(50.0, 100.0)
                                    createmsg(getlocalstring("msg", "radio.bat"), 6.0)
                                Case $46
                                    createmsg(getlocalstring("msg", "radio.bat.notfit"), 6.0)
                                Case $47,$48
                                    createmsg(getlocalstring("msg", "radio.bat.no"), 6.0)
                                Case $40
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(500.0, 1000.0)
                                    createmsg(getlocalstring("msg", "nvg.bat"), 6.0)
                                Case $41
                                    createmsg(getlocalstring("msg", "nvg.bat.notfit"), 6.0)
                                Case $42
                                    createmsg(getlocalstring("msg", "nvg.bat.notfit"), 6.0)
                                Case $43
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(500.0, 1000.0)
                                    createmsg(getlocalstring("msg", "gear.bat"), 6.0)
                                Case $44
                                    createmsg(getlocalstring("msg", "gear.bat.notfit"), 6.0)
                                Case $4D
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(50.0, 100.0)
                                    createmsg(getlocalstring("msg", "e.reader.bat"), 6.0)
                                Case $4E
                                    createmsg(getlocalstring("msg", "e.reader.bat.notfit"), 6.0)
                                Case $4F
                                    createmsg(getlocalstring("msg", "e.reader.bat.no"), 6.0)
                                Default
                                    For local6 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local6) = selecteditem) Then
                                            inventory(local6) = local26
                                            Exit
                                        EndIf
                                    Next
                                    inventory(local18) = selecteditem
                                    selecteditem = Null
                            End Select
                        Case $52
                            Select inventory(local18)\Field4\Field2
                                Case $49
                                    createmsg(getlocalstring("msg", "nav.bat.notfit"), 6.0)
                                Case $4B
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(50.0, 100.0)
                                    createmsg(getlocalstring("msg", "nav.bat"), 6.0)
                                Case $4C,$4A
                                    createmsg(getlocalstring("msg", "nav.bat.no"), 6.0)
                                Case $45
                                    createmsg(getlocalstring("msg", "radio.bat.notfit"), 6.0)
                                Case $46
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(50.0, 100.0)
                                    createmsg(getlocalstring("msg", "radio.bat"), 6.0)
                                Case $47,$48
                                    createmsg(getlocalstring("msg", "radio.bat.no"), 6.0)
                                Case $40
                                    createmsg(getlocalstring("msg", "nvg.bat.notfit"), 6.0)
                                Case $41
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(500.0, 1000.0)
                                    createmsg(getlocalstring("msg", "nvg.bat"), 6.0)
                                Case $42
                                    createmsg(getlocalstring("msg", "nvg.bat.notfit"), 6.0)
                                Case $43
                                    createmsg(getlocalstring("msg", "gear.bat.notfit"), 6.0)
                                Case $44
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(500.0, 1000.0)
                                    createmsg(getlocalstring("msg", "gear.bat"), 6.0)
                                Case $4D
                                    createmsg(getlocalstring("msg", "e.reader.bat.notfit"), 6.0)
                                Case $4E
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = rnd(500.0, 1000.0)
                                    createmsg(getlocalstring("msg", "e.reader.bat"), 6.0)
                                Case $4F
                                    createmsg(getlocalstring("msg", "e.reader.bat.no"), 6.0)
                                Default
                                    For local6 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local6) = selecteditem) Then
                                            inventory(local6) = local26
                                            Exit
                                        EndIf
                                    Next
                                    inventory(local18) = selecteditem
                                    selecteditem = Null
                            End Select
                        Case $53,$54
                            Select inventory(local18)\Field4\Field2
                                Case $49
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = 1000.0
                                    createmsg(getlocalstring("msg", "nav.bat"), 6.0)
                                Case $4B
                                    createmsg(getlocalstring("msg", "nav.bat.notfit"), 6.0)
                                Case $4C,$4A
                                    createmsg(getlocalstring("msg", "nav.bat.no"), 6.0)
                                Case $45
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = 1000.0
                                    createmsg(getlocalstring("msg", "radio.bat"), 6.0)
                                Case $46
                                    createmsg(getlocalstring("msg", "radio.bat.notfit"), 6.0)
                                Case $47,$48
                                    createmsg(getlocalstring("msg", "radio.bat.no"), 6.0)
                                Case $40
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = 10000.0
                                    createmsg(getlocalstring("msg", "nvg.bat"), 6.0)
                                Case $41
                                    createmsg(getlocalstring("msg", "nvg.bat.notfit"), 6.0)
                                Case $42
                                    createmsg(getlocalstring("msg", "nvg.bat.notfit"), 6.0)
                                Case $43
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = 10000.0
                                    createmsg(getlocalstring("msg", "gear.bat"), 6.0)
                                Case $44
                                    createmsg(getlocalstring("msg", "gear.bat.notfit"), 6.0)
                                Case $4D
                                    If (selecteditem\Field4\Field3 <> $42) Then
                                        playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                                    EndIf
                                    removeitem(selecteditem)
                                    inventory(local18)\Field12 = 1000.0
                                    createmsg(getlocalstring("msg", "e.reader.bat"), 6.0)
                                Case $4E
                                    createmsg(getlocalstring("msg", "e.reader.bat.notfit"), 6.0)
                                Case $4F
                                    createmsg(getlocalstring("msg", "e.reader.bat.no"), 6.0)
                                Default
                                    For local6 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local6) = selecteditem) Then
                                            inventory(local6) = local26
                                            Exit
                                        EndIf
                                    Next
                                    inventory(local18) = selecteditem
                                    selecteditem = Null
                            End Select
                        Default
                            For local6 = $00 To (maxitemamount - $01) Step $01
                                If (inventory(local6) = selecteditem) Then
                                    inventory(local6) = local26
                                    Exit
                                EndIf
                            Next
                            inventory(local18) = selecteditem
                            selecteditem = Null
                    End Select
                    currentsyncitem = Null
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        If (invopen = $00) Then
            stopmousemovement()
        EndIf
    ElseIf (selecteditem <> Null) Then
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
                    me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                    If (selecteditem\Field4\Field2 <> $3B) Then
                        selecteditem\Field12 = min((selecteditem\Field12 + fps\Field7[$00]), 100.0)
                    Else
                        selecteditem\Field12 = min((selecteditem\Field12 + (fps\Field7[$00] / 1.6)), 100.0)
                    EndIf
                    If (100.0 = selecteditem\Field12) Then
                        If (selecteditem\Field4\Field3 <> $42) Then
                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                        EndIf
                        If (wi\Field0 > $00) Then
                            createmsg(getlocalstring("msg", "mask.off"), 6.0)
                            wi\Field0 = $00
                        Else
                            Select selecteditem\Field4\Field2
                                Case $38
                                    createmsg(getlocalstring("msg", "mask.on"), 6.0)
                                    wi\Field0 = $01
                                Case $39
                                    createmsg(getlocalstring("msg", "mask.on.dry"), 6.0)
                                    wi\Field0 = $02
                                Case $3A
                                    createmsg(getlocalstring("msg", "mask.on.easy"), 6.0)
                                    wi\Field0 = $03
                                Case $3B
                                    createmsg(getlocalstring("msg", "mask.on.easy"), 6.0)
                                    wi\Field0 = $04
                            End Select
                        EndIf
                        selecteditem\Field12 = 0.0
                        selecteditem = Null
                    EndIf
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
                    me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                    selecteditem\Field12 = min((selecteditem\Field12 + (fps\Field7[$00] / 1.5)), 100.0)
                    If (100.0 = selecteditem\Field12) Then
                        If (selecteditem\Field4\Field3 <> $42) Then
                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                        EndIf
                        If (i_1499\Field0 > $00) Then
                            createmsg(getlocalstring("msg", "mask.off"), 6.0)
                            i_1499\Field0 = $00
                        Else
                            giveachievement("1499", $01)
                            For local2 = Each rooms
                                If (local2\Field7\Field6 = $6A) Then
                                    me\Field10 = -10.0
                                    i_1499\Field4 = playerroom
                                    i_1499\Field1 = entityx(me\Field60, $00)
                                    i_1499\Field2 = entityy(me\Field60, $00)
                                    i_1499\Field3 = entityz(me\Field60, $00)
                                    If ((((0.0 = i_1499\Field5) And (0.0 = i_1499\Field6)) And (0.0 = i_1499\Field7)) <> 0) Then
                                        positionentity(me\Field60, (local2\Field3 + 23.77344), (local2\Field4 + 1.1875), (local2\Field5 + 8.955078), $00)
                                        rotateentity(me\Field60, 0.0, 90.0, 0.0, $01)
                                    Else
                                        positionentity(me\Field60, i_1499\Field5, (i_1499\Field6 + 0.05), i_1499\Field7, $00)
                                    EndIf
                                    resetentity(me\Field60)
                                    teleporttoroom(local2)
                                    playsound_strict(loadtempsound("SFX\SCP\1499\Enter.ogg"), $00)
                                    i_1499\Field5 = 0.0
                                    i_1499\Field6 = 0.0
                                    i_1499\Field7 = 0.0
                                    If (n_i\Field4 <> Null) Then
                                        If (n_i\Field4\Field18 <> $00) Then
                                            setstreamvolume_strict(n_i\Field4\Field18, 0.0)
                                        EndIf
                                    EndIf
                                    For local0 = Each events
                                        If (local0\Field0 = $49) Then
                                            If (1051.178 < entitydistancesquared(local0\Field1\Field2, me\Field60)) Then
                                                If (5.0 > local0\Field3) Then
                                                    local0\Field3 = (local0\Field3 + 1.0)
                                                EndIf
                                            EndIf
                                            Exit
                                        EndIf
                                    Next
                                    Exit
                                EndIf
                            Next
                            Select selecteditem\Field4\Field2
                                Case $24
                                    createmsg(getlocalstring("msg", "mask.on"), 6.0)
                                    i_1499\Field0 = $01
                                Case $25
                                    createmsg(getlocalstring("msg", "mask.on.easy"), 6.0)
                                    i_1499\Field0 = $02
                            End Select
                        EndIf
                        selecteditem\Field12 = 0.0
                        selecteditem = Null
                    EndIf
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
                    me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                    selecteditem\Field14 = min((selecteditem\Field14 + fps\Field7[$00]), 100.0)
                    If (100.0 = selecteditem\Field14) Then
                        If (selecteditem\Field4\Field3 <> $42) Then
                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                        EndIf
                        If (wi\Field5 > $00) Then
                            createmsg(getlocalstring("msg", "nvg.off"), 6.0)
                            fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                            wi\Field5 = $00
                            If (0.0 < selecteditem\Field12) Then
                                playsound_strict(snd_i\Field40[$01], $00)
                            EndIf
                        Else
                            createmsg(getlocalstring("msg", "nvg.on"), 6.0)
                            fog\Field0 = 15.0
                            Select selecteditem\Field4\Field2
                                Case $40
                                    wi\Field5 = $01
                                Case $41
                                    wi\Field5 = $02
                                Case $42
                                    wi\Field5 = $03
                            End Select
                            If (0.0 < selecteditem\Field12) Then
                                playsound_strict(snd_i\Field40[$00], $00)
                            EndIf
                        EndIf
                        selecteditem\Field14 = 0.0
                        selecteditem = Null
                    EndIf
                EndIf
            Case $43,$44
                If (preventitemoverlapping($00, $00, $00, $01, $01, $00, $01) = $00) Then
                    Select selecteditem\Field4\Field2
                        Case $43
                            If (isdoubleitem(wi\Field9, $01) <> 0) Then
                                Return $00
                            EndIf
                        Case $44
                            If (isdoubleitem(wi\Field9, $02) <> 0) Then
                                Return $00
                            EndIf
                    End Select
                    me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                    selecteditem\Field14 = min((selecteditem\Field14 + fps\Field7[$00]), 100.0)
                    If (100.0 = selecteditem\Field14) Then
                        If (selecteditem\Field4\Field3 <> $42) Then
                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                        EndIf
                        If (wi\Field9 > $00) Then
                            createmsg(getlocalstring("msg", "gear.off"), 6.0)
                            fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                            wi\Field9 = $00
                        Else
                            createmsg(getlocalstring("msg", "gear.on"), 6.0)
                            fog\Field0 = 9.0
                            Select selecteditem\Field4\Field2
                                Case $43
                                    wi\Field9 = $01
                                Case $44
                                    wi\Field9 = $02
                            End Select
                        EndIf
                        selecteditem\Field14 = 0.0
                        selecteditem = Null
                    EndIf
                EndIf
            Case $26
                If (preventitemoverlapping($01, $01, $01, $01, $01, $00, $00) = $00) Then
                    me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                    selecteditem\Field12 = min((selecteditem\Field12 + (fps\Field7[$00] / 0.7)), 100.0)
                    If (100.0 = selecteditem\Field12) Then
                        If (selecteditem\Field4\Field3 <> $42) Then
                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                        EndIf
                        If (wi\Field4 <> 0) Then
                            createmsg(getlocalstring("msg", "helmet.off"), 6.0)
                            wi\Field4 = $00
                        Else
                            createmsg(getlocalstring("msg", "helmet.on"), 6.0)
                            wi\Field4 = $01
                        EndIf
                        selecteditem\Field12 = 0.0
                        selecteditem = Null
                    EndIf
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
                    me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                    selecteditem\Field12 = min((selecteditem\Field12 + (fps\Field7[$00] / 0.7)), 100.0)
                    If (100.0 = selecteditem\Field12) Then
                        If (selecteditem\Field4\Field3 <> $42) Then
                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                        EndIf
                        If (i_268\Field0 > $00) Then
                            If (((i_268\Field0 > $01) And (0.0 < i_268\Field1)) <> 0) Then
                                playsound_strict(loadtempsound("SFX\SCP\268\InvisibilityOff.ogg"), $00)
                            EndIf
                            createmsg(getlocalstring("msg", "cap.off"), 6.0)
                            i_268\Field0 = $00
                        Else
                            giveachievement("268", $01)
                            createmsg(getlocalstring("msg", "cap.on"), 6.0)
                            Select selecteditem\Field4\Field2
                                Case $0D
                                    i_268\Field0 = $01
                                Case $0E
                                    i_268\Field0 = $02
                                Case $0F
                                    i_268\Field0 = $03
                            End Select
                            If (i_268\Field0 > $01) Then
                                playsound_strict(loadtempsound("SFX\SCP\268\InvisibilityOn.ogg"), $00)
                            EndIf
                        EndIf
                        selecteditem\Field12 = 0.0
                        selecteditem = Null
                    EndIf
                EndIf
            Case $27,$28
                me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                selecteditem\Field12 = min(((fps\Field7[$00] / (((Float (selecteditem\Field4\Field2 = $28)) * 0.5) + 2.0)) + selecteditem\Field12), 100.0)
                If (100.0 = selecteditem\Field12) Then
                    If (wi\Field3 > $00) Then
                        createmsg(getlocalstring("msg", "vest.off"), 6.0)
                        wi\Field3 = $00
                        dropitem(selecteditem, $01)
                    Else
                        If (selecteditem\Field4\Field3 <> $42) Then
                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                        EndIf
                        Select selecteditem\Field4\Field2
                            Case $27
                                createmsg(getlocalstring("msg", "vest.on.slight"), 6.0)
                                wi\Field3 = $01
                            Case $28
                                createmsg(getlocalstring("msg", "vest.on.heavy"), 6.0)
                                wi\Field3 = $02
                        End Select
                    EndIf
                    selecteditem\Field12 = 0.0
                    selecteditem = Null
                EndIf
            Case $3C,$3D,$3E,$3F
                me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                selecteditem\Field12 = min(((fps\Field7[$00] / ((Float (selecteditem\Field4\Field2 = $3F)) + 3.0)) + selecteditem\Field12), 100.0)
                If (100.0 = selecteditem\Field12) Then
                    If (wi\Field2 > $00) Then
                        createmsg(getlocalstring("msg", "suit.off"), 6.0)
                        wi\Field2 = $00
                        dropitem(selecteditem, $01)
                    Else
                        If (selecteditem\Field4\Field3 <> $42) Then
                            playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
                        EndIf
                        If (wi\Field5 > $00) Then
                            fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                            wi\Field5 = $00
                        EndIf
                        If (wi\Field9 > $00) Then
                            fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                            wi\Field9 = $00
                        EndIf
                        wi\Field0 = $00
                        wi\Field4 = $00
                        i_427\Field0 = $00
                        i_1499\Field0 = $00
                        i_268\Field0 = $00
                        Select selecteditem\Field4\Field2
                            Case $3C
                                createmsg(getlocalstring("msg", "suit.on"), 6.0)
                                wi\Field2 = $01
                            Case $3D
                                createmsg(getlocalstring("msg", "suit.dry"), 6.0)
                                wi\Field2 = $02
                            Case $3E
                                createmsg(getlocalstring("msg", "suit.on.easy"), 6.0)
                                wi\Field2 = $03
                            Case $3F
                                createmsg(getlocalstring("msg", "suit.on.easy"), 6.0)
                                wi\Field2 = $04
                        End Select
                    EndIf
                    selecteditem\Field12 = 0.0
                    selecteditem = Null
                EndIf
            Case $19
                playsound_strict(loadtempsound("SFX\SCP\513\Bell.ogg"), $00)
                giveachievement("513", $01)
                If (((n_i\Field5 = Null) And (me\Field54 = $00)) <> 0) Then
                    n_i\Field5 = createnpc($09, 0.0, 0.0, 0.0)
                EndIf
                selecteditem = Null
            Case $16
                If (canuseitem($01, $00, $00) <> 0) Then
                    giveachievement("500", $01)
                    If (0.0 < i_008\Field0) Then
                        createmsg(getlocalstring("msg", "pill.nausea"), 6.0)
                        i_008\Field1 = $01
                    ElseIf (0.0 < i_409\Field0) Then
                        createmsg(getlocalstring("msg", "pill.crystals"), 6.0)
                        i_409\Field1 = $01
                    ElseIf (0.0 < i_1048a\Field0) Then
                        i_1048a\Field1 = $01
                        stopchannel(i_1048a\Field2)
                        i_1048a\Field2 = $00
                        createmsg(getlocalstring("msg", "pill.ears"), 6.0)
                    Else
                        createmsg(getlocalstring("msg", "pill"), 6.0)
                    EndIf
                    i_966\Field1 = 0.0
                    i_966\Field0 = 0.0
                    me\Field4 = 0.0
                    me\Field17 = 100.0
                    For local7 = $00 To $06 Step $01
                        i_1025\Field0[local7] = 0.0
                    Next
                    If (0.0 < i_1025\Field1[$00]) Then
                        For local7 = (maxitemamount - $02) To (maxitemamount - $01) Step $01
                            If (inventory(local7) <> Null) Then
                                dropitem(inventory(local7), $01)
                            EndIf
                        Next
                        maxitemamount = (maxitemamount - $02)
                        i_1025\Field1[$00] = 0.0
                    EndIf
                    For local7 = $01 To $04 Step $01
                        i_1025\Field1[local7] = 0.0
                    Next
                    If (1.0 < me\Field18) Then
                        me\Field18 = 1.0
                        me\Field19 = 0.0
                    EndIf
                    If (1.0 < me\Field12) Then
                        me\Field12 = 1.0
                        me\Field13 = 0.0
                    EndIf
                    removeitem(selecteditem)
                EndIf
            Case $37
                If (canuseitem($01, $00, $00) <> 0) Then
                    Select rand($05, $01)
                        Case $01
                            me\Field31 = 3.5
                            createmsg(getlocalstring("msg", "bleed"), 6.0)
                        Case $02
                            me\Field31 = 0.0
                            me\Field32 = 0.0
                            createmsg(getlocalstring("msg", "rapidly"), 6.0)
                        Case $03
                            me\Field31 = max(0.0, (me\Field31 - rnd(0.5, 3.5)))
                            me\Field32 = max(0.0, (me\Field32 - rnd(10.0, 100.0)))
                            createmsg(getlocalstring("msg", "better_1"), 6.0)
                        Case $04
                            me\Field49 = 10000.0
                            me\Field32 = 0.0
                            createmsg(getlocalstring("msg", "nausea"), 6.0)
                        Case $05
                            me\Field10 = -10.0
                            If (((playerroom\Field7\Field6 = $6A) Lor isplayeroutsidefacility()) <> 0) Then
                                me\Field31 = 2.5
                                createmsg(getlocalstring("msg", "bleed"), 6.0)
                            Else
                                movetopocketdimension()
                                createmsg(getlocalstring("msg", "aid.106"), 6.0)
                            EndIf
                    End Select
                    removeitem(selecteditem)
                EndIf
            Case $34,$36,$35
                If (canuseitem($01, $01, $00) <> 0) Then
                    If (((0.0 = me\Field32) And (0.0 = me\Field31)) <> 0) Then
                        createmsg(getlocalstring("msg", "aid.no"), 6.0)
                        selecteditem = Null
                        Return $00
                    Else
                        me\Field38 = curvevalue(0.0, me\Field38, 5.0)
                        If (me\Field39 = $00) Then
                            setcrouch($01)
                        EndIf
                        selecteditem\Field12 = min(((fps\Field7[$00] / ((Float (selecteditem\Field4\Field2 = $34)) + 4.0)) + selecteditem\Field12), 100.0)
                        If (100.0 = selecteditem\Field12) Then
                            If (selecteditem\Field4\Field2 = $36) Then
                                me\Field32 = 0.0
                                me\Field31 = max(0.0, (me\Field31 - 2.0))
                                If (0.0 = me\Field31) Then
                                    createmsg(getlocalstring("msg", "aid.fine"), 6.0)
                                ElseIf (1.0 < me\Field31) Then
                                    createmsg(getlocalstring("msg", "aid.bleed"), 6.0)
                                Else
                                    createmsg(getlocalstring("msg", "aid.sore"), 6.0)
                                EndIf
                            Else
                                me\Field32 = max(0.0, (me\Field32 - rnd(10.0, 20.0)))
                                If (2.5 <= me\Field31) Then
                                    createmsg(getlocalstring("msg", "aid.toobad_1"), 6.0)
                                    me\Field31 = max(2.5, (me\Field31 - rnd(0.3, 0.7)))
                                ElseIf (1.0 < me\Field31) Then
                                    me\Field31 = max(0.5, (me\Field31 - rnd(0.5, 1.0)))
                                    If (1.0 < me\Field31) Then
                                        createmsg(getlocalstring("msg", "aid.toobad_2"), 6.0)
                                    Else
                                        createmsg(getlocalstring("msg", "aid.stop"), 6.0)
                                    EndIf
                                ElseIf (0.5 < me\Field31) Then
                                    me\Field31 = 0.5
                                    createmsg(getlocalstring("msg", "aid.slight"), 6.0)
                                Else
                                    me\Field31 = (me\Field31 / 2.0)
                                    createmsg(getlocalstring("msg", "aid.nowalk"), 6.0)
                                EndIf
                                If (selecteditem\Field4\Field2 = $35) Then
                                    Select rand($06, $01)
                                        Case $01
                                            chs\Field6 = $01
                                            createmsg(getlocalstring("msg", "aid.super"), 6.0)
                                        Case $02
                                            opt\Field43 = (opt\Field43 = $00)
                                            opt\Field44 = (opt\Field44 = $00)
                                            createmsg(getlocalstring("msg", "aid.invert"), 6.0)
                                        Case $03
                                            me\Field49 = 5000.0
                                            createmsg(getlocalstring("msg", "nausea"), 6.0)
                                        Case $04
                                            me\Field12 = 0.6
                                            me\Field13 = rnd(20.0, 30.0)
                                        Case $05
                                            me\Field32 = 0.0
                                            me\Field31 = 0.0
                                            createmsg(getlocalstring("msg", "aid.stopall"), 6.0)
                                        Case $06
                                            createmsg(getlocalstring("msg", "aid.through"), 6.0)
                                            me\Field31 = 3.5
                                    End Select
                                EndIf
                            EndIf
                            removeitem(selecteditem)
                        EndIf
                    EndIf
                EndIf
            Case $30,$31
                If (canuseitem($00, $00, $00) <> 0) Then
                    me\Field12 = 0.6
                    me\Field13 = rnd(25.0, 35.0)
                    me\Field49 = 200.0
                    me\Field10 = min((me\Field10 + (me\Field11 / 2.0)), me\Field11)
                    If (selecteditem\Field4\Field2 = $31) Then
                        me\Field32 = max((me\Field32 - rnd(5.0, 10.0)), 0.0)
                    EndIf
                    createmsg(getlocalstring("msg", "eyedrop.moisturized"), 6.0)
                    removeitem(selecteditem)
                EndIf
            Case $32
                If (canuseitem($00, $00, $00) <> 0) Then
                    me\Field12 = 0.4
                    me\Field13 = rnd(35.0, 45.0)
                    me\Field49 = 200.0
                    me\Field10 = me\Field11
                    createmsg(getlocalstring("msg", "eyedrop.moisturized.very"), 6.0)
                    removeitem(selecteditem)
                EndIf
            Case $33
                If (canuseitem($00, $00, $00) <> 0) Then
                    me\Field12 = 0.0
                    me\Field13 = 60.0
                    me\Field15 = 8400.0
                    me\Field49 = 1000.0
                    createmsg(getlocalstring("msg", "eyedrop.moisturized.veryvery"), 6.0)
                    removeitem(selecteditem)
                EndIf
            Case $20
                giveachievement("1025", $01)
                If (0.0 = selecteditem\Field14) Then
                    selecteditem\Field12 = (Float rand($00, $06))
                    If ((((i_714\Field0 = $00) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
                        i_1025\Field0[(Int selecteditem\Field12)] = max(1.0, i_1025\Field0[(Int selecteditem\Field12)])
                    EndIf
                    selecteditem\Field14 = 1.0
                EndIf
                If (selecteditem\Field4\Field11 = $00) Then
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict((("GFX\Items\HUD Textures\page_1025(" + (Str ((Int selecteditem\Field12) + $01))) + ").png")), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                    adaptscreengamma()
                EndIf
            Case $21
                giveachievement("1025", $01)
                If (0.0 = selecteditem\Field14) Then
                    selecteditem\Field12 = (Float rand($00, $05))
                    If ((((i_714\Field0 = $00) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
                        Select selecteditem\Field12
                            Case 0.0
                                If (0.0 = i_1025\Field1[$00]) Then
                                    maxitemamount = (maxitemamount + $02)
                                    injureplayer(1.5, 0.0, 1000.0, 0.0, 0.0)
                                    playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\BodyHorrorExchange" + (Str rand($00, $03))) + ".ogg")), $00)
                                    createmsg(getlocalstring("msg", "extraparts"), 6.0)
                                    i_1025\Field1[$00] = 1.0
                                EndIf
                            Case 5.0
                                If (0.0 = i_008\Field0) Then
                                    i_008\Field0 = (i_008\Field0 + 0.001)
                                EndIf
                            Default
                                i_1025\Field1[(Int selecteditem\Field12)] = max(1.0, i_1025\Field1[(Int selecteditem\Field12)])
                        End Select
                    EndIf
                    selecteditem\Field14 = 1.0
                EndIf
                If (selecteditem\Field4\Field11 = $00) Then
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict((("GFX\Items\HUD Textures\page_fine_1025(" + (Str ((Int selecteditem\Field12) + $01))) + ").png")), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                    adaptscreengamma()
                EndIf
            Case $22
                createmsg(getlocalstring("msg", "redbook"), 6.0)
                selecteditem = Null
            Case $2B
                If (canuseitem($01, $00, $00) <> 0) Then
                    If (s2imapcontains(i_294\Field2, selecteditem\Field1) <> 0) Then
                        local67 = jsongetarrayvalue(i_294\Field3, s2imapget(i_294\Field2, selecteditem\Field1))
                        If (jsonisnull(jsongetvalue(local67, "refuse_message")) <> 0) Then
                            me\Field38 = curvevalue(0.0, me\Field38, 10.0)
                            selecteditem\Field14 = min((selecteditem\Field14 + (fps\Field7[$00] / 0.6)), 100.0)
                            If (100.0 = selecteditem\Field14) Then
                                local3 = jsongetvalue(local67, "drink_message")
                                If (jsonisnull(local3) = $00) Then
                                    createmsg(jsongetstring(local3), 6.0)
                                EndIf
                                local3 = jsongetvalue(local67, "vomit")
                                If (jsonisnull(local3) = $00) Then
                                    If (0.0 = me\Field26) Then
                                        me\Field26 = jsongetfloat(local3)
                                    Else
                                        me\Field26 = min(me\Field26, jsongetfloat(local3))
                                    EndIf
                                EndIf
                                local3 = jsongetvalue(local67, "blur")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field49 = max((me\Field49 + (jsongetfloat(local3) * 70.0)), 0.0)
                                EndIf
                                local3 = jsongetvalue(local67, "camera_shake")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field21 = max((me\Field21 + jsongetfloat(local3)), 0.0)
                                EndIf
                                local3 = jsongetvalue(local67, "deaf_timer")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field55 = max((me\Field55 + jsongetfloat(local3)), 0.0)
                                EndIf
                                local3 = jsongetvalue(local67, "damage")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field31 = max((me\Field31 + jsongetfloat(local3)), 0.0)
                                EndIf
                                local3 = jsongetvalue(local67, "bloodloss")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field32 = max((me\Field32 + jsongetfloat(local3)), 0.0)
                                EndIf
                                local3 = jsongetvalue(local67, "energy")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field17 = min((((Float rand((Int (jsongetfloat(local3) / 2.0)), (Int jsongetfloat(local3)))) * selecteditem\Field12) + me\Field17), 100.0)
                                EndIf
                                local3 = jsongetvalue(local67, "drink_sound")
                                If (jsonisnull(local3) = $00) Then
                                    local15 = jsongetstring(local3)
                                    If (((local15 = "SFX\SCP\294\Burn.ogg") And (0.0 < i_1025\Field1[$03])) = $00) Then
                                        playsound_strict(loadtempsound(local15), $01)
                                        mp_synchronizesound(local15, $01, ue_players[mp_getmyindex()], 10.0, 1.0, 0.0, 0.0, 0.0)
                                    Else
                                        me\Field31 = (me\Field31 + 0.5)
                                        playsound_strict(loadtempsound("SFX\SCP\294\Slurp.ogg"), $01)
                                        mp_synchronizesound("SFX\SCP\294\Slurp.ogg", $01, ue_players[mp_getmyindex()], 10.0, 1.0, 0.0, 0.0, 0.0)
                                    EndIf
                                EndIf
                                local3 = jsongetvalue(local67, "stomachache")
                                If (jsonisnull(local3) = $00) Then
                                    If (jsongetbool(local3) <> 0) Then
                                        i_1025\Field0[$03] = 1.0
                                    EndIf
                                EndIf
                                local3 = jsongetvalue(local67, "infection")
                                If (jsonisnull(local3) = $00) Then
                                    If (jsongetbool(local3) <> 0) Then
                                        i_008\Field0 = (i_008\Field0 + 0.001)
                                    EndIf
                                EndIf
                                local3 = jsongetvalue(local67, "crystallization")
                                If (jsonisnull(local3) = $00) Then
                                    If (jsongetbool(local3) <> 0) Then
                                        i_409\Field0 = (i_409\Field0 + 0.001)
                                    EndIf
                                EndIf
                                local3 = jsongetvalue(local67, "mutation")
                                If (jsonisnull(local3) = $00) Then
                                    If (jsongetbool(local3) <> 0) Then
                                        If (25200.0 > i_427\Field1) Then
                                            i_427\Field1 = 25200.0
                                        EndIf
                                    EndIf
                                EndIf
                                local3 = jsongetvalue(local67, "revitalize")
                                If (jsonisnull(local3) = $00) Then
                                    If (jsongetbool(local3) <> 0) Then
                                        For local7 = $00 To $06 Step $01
                                            i_1025\Field0[local7] = 0.0
                                        Next
                                    EndIf
                                EndIf
                                local3 = jsongetvalue(local67, "death_timer")
                                If (jsonisnull(local3) = $00) Then
                                    local68 = (Int jsongetfloat(local3))
                                    local3 = jsongetvalue(local67, "death_message")
                                    If (jsonisnull(local3) = $00) Then
                                        msg\Field2 = jsongetstring(local3)
                                    EndIf
                                    If (0.0 = (Float local68)) Then
                                        kill($00, $01, $00, $01)
                                    ElseIf (0.0 = me\Field4) Then
                                        me\Field4 = ((Float local68) * 70.0)
                                    EndIf
                                EndIf
                                local3 = jsongetvalue(local67, "blink_effect")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field12 = (jsongetfloat(local3) ^ selecteditem\Field12)
                                EndIf
                                local3 = jsongetvalue(local67, "blink_timer")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field13 = (jsongetfloat(local3) * selecteditem\Field12)
                                EndIf
                                local3 = jsongetvalue(local67, "stamina_effect")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field18 = (jsongetfloat(local3) ^ selecteditem\Field12)
                                EndIf
                                local3 = jsongetvalue(local67, "stamina_timer")
                                If (jsonisnull(local3) = $00) Then
                                    me\Field19 = (jsongetfloat(local3) * selecteditem\Field12)
                                EndIf
                                local1 = createitem("Empty Cup", $2C, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                local1\Field15 = $01
                                For local7 = $00 To (maxitemamount - $01) Step $01
                                    If (inventory(local7) = selecteditem) Then
                                        inventory(local7) = local1
                                        Exit
                                    EndIf
                                Next
                                entitytype(local1\Field2, $03, $00)
                                removeitem(selecteditem)
                            EndIf
                        Else
                            createmsg(jsongetstring(jsongetvalue(local67, "refuse_message")), 6.0)
                            selecteditem = Null
                        EndIf
                    Else
                        createmsg(getlocalstring("msg", "cup.unknown"), 6.0)
                        removeitem(selecteditem)
                    EndIf
                EndIf
            Case $6C
                If (canuseitem($01, $00, $00) <> 0) Then
                    createmsg(getlocalstring("msg", "pizza"), 6.0)
                    playsound_strict(loadtempsound("SFX\SCP\458\Eating.ogg"), $00)
                    removeitem(selecteditem)
                EndIf
            Case $55
                If (canuseitem($01, $01, $00) <> 0) Then
                    me\Field35 = rnd(20.0, 30.0)
                    me\Field18 = 0.7
                    me\Field19 = (Float rand($14, $1E))
                    me\Field17 = min((me\Field17 + 25.0), 100.0)
                    createmsg(getlocalstring("msg", "syringe_1"), 6.0)
                    removeitem(selecteditem)
                EndIf
            Case $56
                If (canuseitem($01, $01, $00) <> 0) Then
                    me\Field35 = rnd(30.0, 40.0)
                    me\Field18 = 0.5
                    me\Field19 = rnd(30.0, 40.0)
                    me\Field17 = min((me\Field17 + 50.0), 100.0)
                    createmsg(getlocalstring("msg", "syringe_2"), 6.0)
                    removeitem(selecteditem)
                EndIf
            Case $57
                If (canuseitem($01, $01, $00) <> 0) Then
                    Select rand($03, $01)
                        Case $01
                            me\Field35 = 60.0
                            me\Field18 = 0.1
                            me\Field19 = 60.0
                            me\Field17 = 100.0
                            createmsg(getlocalstring("msg", "syringe_3"), 6.0)
                        Case $02
                            chs\Field6 = $01
                            createmsg(getlocalstring("msg", "syringe_4"), 6.0)
                        Case $03
                            me\Field26 = 30.0
                            createmsg(getlocalstring("msg", "syringe_5"), 6.0)
                    End Select
                    removeitem(selecteditem)
                EndIf
            Case $58
                If (canuseitem($01, $01, $00) <> 0) Then
                    me\Field35 = rnd(10.0, 20.0)
                    me\Field18 = 0.8
                    me\Field19 = (Float rand($0A, $14))
                    me\Field17 = min((me\Field17 + 10.0), 100.0)
                    createmsg(getlocalstring("msg", "syringe_6"), 6.0)
                    me\Field26 = 70.0
                    i_008\Field0 = (i_008\Field0 + 1.0)
                    removeitem(selecteditem)
                EndIf
            Case $45,$46,$47,$48
                local3 = ((selecteditem\Field4\Field2 = $47) Lor (selecteditem\Field4\Field2 = $48))
                If (selecteditem\Field4\Field11 = $00) Then
                    local15 = "_off"
                    If (((0.0 < selecteditem\Field12) Lor local3) <> 0) Then
                        local15 = "_on"
                    EndIf
                    selecteditem\Field4\Field10 = (("GFX\Items\HUD Textures\radio" + local15) + ".png")
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = imagewidth(selecteditem\Field4\Field11)
                    selecteditem\Field4\Field14 = imageheight(selecteditem\Field4\Field11)
                    maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                    createhintmsg(getlocalstring("msg", "radio"), 6.0, $01)
                EndIf
                selecteditem\Field12 = max(0.0, (selecteditem\Field12 - (fps\Field7[$00] * (((Float (selecteditem\Field4\Field2 = $45)) * 0.002) + 0.002))))
                If (((0.0 < selecteditem\Field12) Lor local3) <> 0) Then
                    selecteditem\Field14 = 0.0
                    isusingradio = $01
                    If (0.0 = radiostate[$05]) Then
                        radiostate[$05] = 1.0
                        radiostate[$00] = -1.0
                    EndIf
                    If (((playerroom\Field7\Field6 = $69) Lor (playerroom\Field7\Field6 = $6A)) <> 0) Then
                        For local7 = $00 To $05 Step $01
                            If (channelplaying(radiochn[local7]) <> 0) Then
                                pausechannel(radiochn[local7])
                            EndIf
                        Next
                        If (channelplaying(radiochn[$06]) = $00) Then
                            radiochn[$06] = playsound_strict(snd_i\Field36, $00)
                        EndIf
                    ElseIf (8.0 > coffindistance) Then
                        For local7 = $00 To $05 Step $01
                            If (channelplaying(radiochn[local7]) <> 0) Then
                                pausechannel(radiochn[local7])
                            EndIf
                        Next
                        If (channelplaying(radiochn[$06]) = $00) Then
                            radiochn[$06] = playsound_strict(snd_i\Field37, $00)
                        EndIf
                    Else
                        If (mp_getsocket() <> $00) Then
                            myplayerlogic\Field2 = (Int (selecteditem\Field13 + 1.0))
                            myplayerlogic\Field3 = selecteditem\Field19
                        EndIf
                        If (selecteditem\Field4\Field2 = $48) Then
                            selecteditem\Field13 = -1.0
                            If (channelplaying(radiochn[$06]) = $00) Then
                                radiochn[$06] = playsound_strict(snd_i\Field36, $00)
                            EndIf
                            radiostate[$06] = (fps\Field7[$00] + radiostate[$06])
                            local4 = (Int mid((Str code_dr_gears), (Int (radiostate[$08] + 1.0)), $01))
                            If ((((radiostate[$07] * 50.0) >= (radiostate[$06] - fps\Field7[$00])) And (radiostate[$06] > (radiostate[$07] * 50.0))) <> 0) Then
                                playsound_strict(snd_i\Field38, $00)
                                radiostate[$07] = (radiostate[$07] + 1.0)
                                If ((Float local4) <= radiostate[$07]) Then
                                    radiostate[$07] = 0.0
                                    radiostate[$06] = -100.0
                                    radiostate[$08] = (radiostate[$08] + 1.0)
                                    If (4.0 = radiostate[$08]) Then
                                        radiostate[$08] = 0.0
                                        radiostate[$06] = -200.0
                                    EndIf
                                EndIf
                            EndIf
                        Else
                            Select (Int selecteditem\Field13)
                                Case $00
                                    If (opt\Field24 = $00) Then
                                        If (channelplaying(radiochn[$06]) = $00) Then
                                            radiochn[$06] = playsound_strict(snd_i\Field36, $00)
                                        EndIf
                                    ElseIf (usertrackmusicamount < $01) Then
                                        If (channelplaying(radiochn[$06]) = $00) Then
                                            radiochn[$06] = playsound_strict(snd_i\Field36, $00)
                                        EndIf
                                    Else
                                        If (channelplaying(radiochn[$06]) <> 0) Then
                                            stopchannel(radiochn[$06])
                                            radiochn[$06] = $00
                                        EndIf
                                        If (channelplaying(radiochn[$00]) = $00) Then
                                            If (usertrackflag = $00) Then
                                                If (opt\Field24 = $01) Then
                                                    If ((Float (usertrackmusicamount - $01)) > radiostate[$00]) Then
                                                        radiostate[$00] = (radiostate[$00] + 1.0)
                                                    Else
                                                        radiostate[$00] = 0.0
                                                    EndIf
                                                    usertrackflag = $01
                                                ElseIf (opt\Field24 = $02) Then
                                                    radiostate[$00] = (Float rand($00, (usertrackmusicamount - $01)))
                                                EndIf
                                            EndIf
                                            If (currusertrack <> $00) Then
                                                freesound_strict(currusertrack)
                                                currusertrack = $00
                                            EndIf
                                            currusertrack = loadsound_strict(("SFX\Radio\UserTracks\" + usertrackname[(Int radiostate[$00])]))
                                            radiochn[$00] = playsound_strict(currusertrack, $00)
                                        Else
                                            usertrackflag = $00
                                        EndIf
                                        If (keyhit($02) <> 0) Then
                                            playsound_strict(snd_i\Field35, $00)
                                            If (usertrackflag = $00) Then
                                                If (opt\Field24 = $01) Then
                                                    If ((Float (usertrackmusicamount - $01)) > radiostate[$00]) Then
                                                        radiostate[$00] = (radiostate[$00] + 1.0)
                                                    Else
                                                        radiostate[$00] = 0.0
                                                    EndIf
                                                    usertrackflag = $01
                                                ElseIf (opt\Field24 = $02) Then
                                                    radiostate[$00] = (Float rand($00, (usertrackmusicamount - $01)))
                                                EndIf
                                            EndIf
                                            If (currusertrack <> $00) Then
                                                freesound_strict(currusertrack)
                                                currusertrack = $00
                                            EndIf
                                            currusertrack = loadsound_strict(("SFX\Radio\UserTracks\" + usertrackname[(Int radiostate[$00])]))
                                            radiochn[$00] = playsound_strict(currusertrack, $00)
                                        EndIf
                                    EndIf
                                Case $01
                                    If (channelplaying(radiochn[$06]) <> 0) Then
                                        stopchannel(radiochn[$06])
                                        radiochn[$06] = $00
                                    EndIf
                                    If (channelplaying(radiochn[$01]) = $00) Then
                                        If (5.0 <= radiostate[$01]) Then
                                            radiochn[$01] = playsound_strict(radiosfx($00, $01), $00)
                                            radiostate[$01] = 0.0
                                        Else
                                            radiostate[$01] = (radiostate[$01] + 1.0)
                                            radiochn[$01] = playsound_strict(radiosfx($00, $00), $00)
                                        EndIf
                                    EndIf
                                Case $02
                                    If (channelplaying(radiochn[$06]) <> 0) Then
                                        stopchannel(radiochn[$06])
                                        radiochn[$06] = $00
                                    EndIf
                                    If (channelplaying(radiochn[$02]) = $00) Then
                                        radiostate[$02] = (radiostate[$02] + 1.0)
                                        If (17.0 = radiostate[$02]) Then
                                            radiostate[$02] = 1.0
                                        EndIf
                                        If (ceil((radiostate[$02] / 2.0)) = floor((radiostate[$02] / 2.0))) Then
                                            radiochn[$02] = playsound_strict(radiosfx($01, (Int (radiostate[$02] / 2.0))), $00)
                                        Else
                                            radiochn[$02] = playsound_strict(radiosfx($01, $00), $00)
                                        EndIf
                                    EndIf
                                Case $03
                                    If (((channelplaying(radiochn[$06]) = $00) And (channelplaying(radiochn[$03]) = $00)) <> 0) Then
                                        radiochn[$06] = playsound_strict(snd_i\Field36, $00)
                                    EndIf
                                    If (0.0 < mtftimer) Then
                                        If (radiostate2[$06] = $00) Then
                                            radiostate[$03] = (max((Float rand($FFFFFFF6, $01)), 0.0) + radiostate[$03])
                                        EndIf
                                        Select radiostate[$03]
                                            Case 40.0
                                                If (radiostate2[$00] = $00) Then
                                                    radiochn[$03] = playsound_strict(loadtempsound("SFX\Character\MTF\Random0.ogg"), $01)
                                                    radiostate[$03] = (radiostate[$03] + 1.0)
                                                    radiostate2[$00] = $01
                                                EndIf
                                            Case 400.0
                                                If (radiostate2[$01] = $00) Then
                                                    radiochn[$03] = playsound_strict(loadtempsound("SFX\Character\MTF\Random1.ogg"), $01)
                                                    radiostate[$03] = (radiostate[$03] + 1.0)
                                                    radiostate2[$01] = $01
                                                EndIf
                                            Case 800.0
                                                If (radiostate2[$02] = $00) Then
                                                    radiochn[$03] = playsound_strict(loadtempsound("SFX\Character\MTF\Random2.ogg"), $01)
                                                    radiostate[$03] = (radiostate[$03] + 1.0)
                                                    radiostate2[$02] = $01
                                                EndIf
                                            Case 1200.0
                                                If (radiostate2[$03] = $00) Then
                                                    radiochn[$03] = playsound_strict(loadtempsound("SFX\Character\MTF\Random3.ogg"), $01)
                                                    radiostate[$03] = (radiostate[$03] + 1.0)
                                                    radiostate2[$03] = $01
                                                EndIf
                                            Case 1600.0
                                                If (radiostate2[$04] = $00) Then
                                                    radiochn[$03] = playsound_strict(loadtempsound("SFX\Character\MTF\Random4.ogg"), $01)
                                                    radiostate[$03] = (radiostate[$03] + 1.0)
                                                    radiostate2[$04] = $01
                                                EndIf
                                            Case 2000.0
                                                If (radiostate2[$05] = $00) Then
                                                    radiochn[$03] = playsound_strict(loadtempsound("SFX\Character\MTF\Random5.ogg"), $01)
                                                    radiostate[$03] = (radiostate[$03] + 1.0)
                                                    radiostate2[$05] = $01
                                                EndIf
                                            Case 2400.0
                                                If (radiostate2[$06] = $00) Then
                                                    radiochn[$03] = playsound_strict(loadtempsound("SFX\Character\MTF\Random6.ogg"), $01)
                                                    radiostate[$03] = (radiostate[$03] + 1.0)
                                                    radiostate2[$06] = $01
                                                EndIf
                                        End Select
                                    EndIf
                                Case $04
                                    If (channelplaying(radiochn[$06]) = $00) Then
                                        radiochn[$06] = playsound_strict(snd_i\Field36, $00)
                                    EndIf
                                    If (channelplaying(radiochn[$04]) = $00) Then
                                        If (((remotedooron = $00) And (0.0 = radiostate[$08])) <> 0) Then
                                            radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\Chatter2.ogg"), $01)
                                            radiostate[$08] = 1.0
                                        Else
                                            radiostate[$04] = (max((Float rand($FFFFFFF6, $01)), 0.0) + radiostate[$04])
                                            Select radiostate[$04]
                                                Case 10.0
                                                    If (n_i\Field3\Field65 = $00) Then
                                                        If (radiostate3[$00] = $00) Then
                                                            radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\OhGod.ogg"), $01)
                                                            radiostate[$04] = (radiostate[$04] + 1.0)
                                                            radiostate3[$00] = $01
                                                        EndIf
                                                    EndIf
                                                Case 100.0
                                                    If (radiostate3[$01] = $00) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\Chatter1.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate3[$01] = $01
                                                    EndIf
                                                Case 158.0
                                                    If (((0.0 = mtftimer) And (radiostate3[$02] = $00)) <> 0) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\Franklin0.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate[$02] = 1.0
                                                    EndIf
                                                Case 200.0
                                                    If (radiostate3[$03] = $00) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\Chatter3.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate3[$03] = $01
                                                    EndIf
                                                Case 260.0
                                                    If (radiostate3[$04] = $00) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\035Help0.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate3[$04] = $01
                                                    EndIf
                                                Case 300.0
                                                    If (radiostate3[$05] = $00) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\Chatter0.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate3[$05] = $01
                                                    EndIf
                                                Case 350.0
                                                    If (radiostate3[$06] = $00) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\Franklin1.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate3[$06] = $01
                                                    EndIf
                                                Case 400.0
                                                    If (radiostate3[$07] = $00) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\035Help1.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate3[$07] = $01
                                                    EndIf
                                                Case 450.0
                                                    If (radiostate3[$08] = $00) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\Franklin2.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate3[$08] = $01
                                                    EndIf
                                                Case 600.0
                                                    If (radiostate3[$09] = $00) Then
                                                        radiochn[$04] = playsound_strict(loadtempsound("SFX\Radio\Franklin3.ogg"), $01)
                                                        radiostate[$04] = (radiostate[$04] + 1.0)
                                                        radiostate3[$09] = $01
                                                    EndIf
                                            End Select
                                        EndIf
                                    EndIf
                                Default
                                    If (channelplaying(radiochn[$06]) <> 0) Then
                                        stopchannel(radiochn[$06])
                                        radiochn[$06] = $00
                                    EndIf
                                    If (channelplaying(radiochn[$05]) = $00) Then
                                        radiochn[$05] = playsound_strict(snd_i\Field36, $00)
                                    EndIf
                            End Select
                            For local7 = $02 To $0A Step $01
                                If (keyhit(local7) <> 0) Then
                                    If ((Float (local7 - $02)) <> selecteditem\Field13) Then
                                        playsound_strict(snd_i\Field35, $00)
                                        pausechannel(radiochn[(Int min(selecteditem\Field13, 5.0))])
                                    EndIf
                                    selecteditem\Field13 = (Float (local7 - $02))
                                    stopchannel(radiochn[$06])
                                    radiochn[$06] = $00
                                EndIf
                            Next
                            If (channelplaying(radiochn[(Int min(selecteditem\Field13, 5.0))]) = $00) Then
                                resumechannel(radiochn[(Int min(selecteditem\Field13, 5.0))])
                            EndIf
                        EndIf
                    EndIf
                    If (local3 = $00) Then
                        If (40.0 > selecteditem\Field12) Then
                            If (70.0 <= batmsgtimer) Then
                                If (channelplaying(lowbatterychn[$00]) = $00) Then
                                    me\Field42 = max(3.0, me\Field42)
                                    lowbatterychn[$00] = playsound_strict(snd_i\Field41[$00], $00)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    If (0.0 = selecteditem\Field14) Then
                        freeimage(selecteditem\Field4\Field11)
                        selecteditem\Field4\Field11 = $00
                        selecteditem\Field4\Field10 = "GFX\Items\HUD Textures\radio_off.png"
                        selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                        maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                        For local7 = $00 To $06 Step $01
                            If (channelplaying(radiochn[local7]) <> 0) Then
                                stopchannel(radiochn[local7])
                                radiochn[local7] = $00
                            EndIf
                        Next
                        selecteditem\Field14 = 1.0
                    EndIf
                    createhintmsg(getlocalstring("msg", "bat.combine"), 1.0, $01)
                EndIf
            Case $49,$4B,$4C,$4A
                local3 = ((selecteditem\Field4\Field2 = $4B) Lor (selecteditem\Field4\Field2 = $49))
                If (selecteditem\Field4\Field11 = $00) Then
                    local15 = "_off"
                    If (((0.0 < selecteditem\Field12) Lor (local3 = $00)) <> 0) Then
                        local15 = "_on"
                    EndIf
                    selecteditem\Field4\Field10 = (("GFX\Items\HUD Textures\navigator" + local15) + ".png")
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                EndIf
                If (local3 <> 0) Then
                    selecteditem\Field12 = max(0.0, (selecteditem\Field12 - (fps\Field7[$00] * (((Float (selecteditem\Field4\Field2 = $49)) * 0.0035) + 0.0035))))
                    If (0.0 < selecteditem\Field12) Then
                        selecteditem\Field14 = 0.0
                        If (20.0 > selecteditem\Field12) Then
                            If (70.0 <= batmsgtimer) Then
                                If (channelplaying(lowbatterychn[$00]) = $00) Then
                                    me\Field42 = max(3.0, me\Field42)
                                    lowbatterychn[$00] = playsound_strict(snd_i\Field41[$00], $00)
                                EndIf
                            EndIf
                        EndIf
                    Else
                        If (0.0 = selecteditem\Field14) Then
                            freeimage(selecteditem\Field4\Field11)
                            selecteditem\Field4\Field11 = $00
                            selecteditem\Field4\Field10 = "GFX\Items\HUD Textures\navigator_off.png"
                            selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                            maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                            selecteditem\Field14 = 1.0
                        EndIf
                        createhintmsg(getlocalstring("msg", "bat.combine"), 1.0, $01)
                    EndIf
                EndIf
            Case $11
                If (canuseitem($01, $00, $00) <> 0) Then
                    Select rand($06, $01)
                        Case $01
                            createmsg(getlocalstring("msg", "cigarette_1"), 6.0)
                        Case $02
                            createmsg(getlocalstring("msg", "cigarette_2"), 6.0)
                        Case $03
                            createmsg(getlocalstring("msg", "cigarette_3"), 6.0)
                        Case $04
                            createmsg(getlocalstring("msg", "cigarette_4"), 6.0)
                        Case $05
                            createmsg(getlocalstring("msg", "cigarette_5"), 6.0)
                        Case $06
                            createmsg(getlocalstring("msg", "cigarette_6"), 6.0)
                    End Select
                    removeitem(selecteditem)
                EndIf
            Case $10
                If (canuseitem($01, $00, $00) <> 0) Then
                    If (i_714\Field0 > $00) Then
                        createmsg(getlocalstring("msg", "420j.no"), 6.0)
                    Else
                        createmsg(getlocalstring("msg", "420j.yeah"), 6.0)
                        me\Field31 = max((me\Field31 - 0.5), 0.0)
                        me\Field49 = 500.0
                        giveachievement("420j", $01)
                        playsound_strict(loadtempsound("SFX\Music\Using420J.ogg"), $00)
                        mp_synchronize3dsound(Null, "SFX\Music\Using420J.ogg", me\Field60, 20.0, 1.0)
                    EndIf
                    removeitem(selecteditem)
                EndIf
            Case $12,$13
                If (canuseitem($01, $00, $00) <> 0) Then
                    If (i_714\Field0 > $00) Then
                        createmsg(getlocalstring("msg", "420j.no"), 6.0)
                    Else
                        createmsg(getlocalstring("msg", "420j.dead"), 6.0)
                        msg\Field2 = format(getlocalstring("death", "joint"), subjectname, "%s")
                        kill($00, $01, $00, $01)
                    EndIf
                    removeitem(selecteditem)
                EndIf
            Case $1B,$1A
                If (canuseitem($01, $01, $00) <> 0) Then
                    Select selecteditem\Field4\Field2
                        Case $1A
                            If (isdoubleitem(i_714\Field0, $01) <> 0) Then
                                Return $00
                            EndIf
                        Case $1B
                            If (isdoubleitem(i_714\Field0, $02) <> 0) Then
                                Return $00
                            EndIf
                    End Select
                    If (i_714\Field0 > $00) Then
                        createmsg(getlocalstring("msg", "714.off"), 6.0)
                        i_714\Field0 = $00
                    Else
                        giveachievement("714", $01)
                        createmsg(getlocalstring("msg", "714.on"), 6.0)
                        Select selecteditem\Field4\Field2
                            Case $1A
                                i_714\Field0 = $01
                            Case $1B
                                i_714\Field0 = $02
                        End Select
                    EndIf
                    selecteditem = Null
                EndIf
            Case $1C,$1D
                If (canuseitem($01, $01, $00) <> 0) Then
                    If (selecteditem\Field4\Field2 = $1C) Then
                        createmsg(getlocalstring("msg", "714.sleep"), 6.0)
                        msg\Field2 = format(getlocalstring("death", "ringsleep"), subjectname, "%s")
                        kill($00, $01, $00, $01)
                    Else
                        createmsg(getlocalstring("msg", "714.small"), 6.0)
                    EndIf
                    selecteditem = Null
                EndIf
            Case $07
                If (selecteditem\Field4\Field11 = $00) Then
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                    adaptscreengamma()
                EndIf
                If (0.0 = selecteditem\Field12) Then
                    createmsg(getlocalstring("msg", "ticket"), 6.0)
                    playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\NostalgiaCancer" + (Str rand($00, $04))) + ".ogg")), $00)
                    selecteditem\Field12 = 1.0
                EndIf
            Case $03,$04,$05
                If (selecteditem\Field4\Field11 = $00) Then
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    adaptscreengamma()
                EndIf
                If (0.0 = selecteditem\Field12) Then
                    playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\NostalgiaCancer" + (Str rand($05, $09))) + ".ogg")), $00)
                    selecteditem\Field12 = 1.0
                EndIf
            Case $06
                If (selecteditem\Field4\Field11 = $00) Then
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                    adaptscreengamma()
                EndIf
                If (0.0 = selecteditem\Field12) Then
                    createmsg(getlocalstring("msg", "oldbadge"), 6.0)
                    playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\NostalgiaCancer" + (Str rand($05, $09))) + ".ogg")), $00)
                    selecteditem\Field12 = 1.0
                EndIf
            Case $01
                If (selecteditem\Field4\Field11 = $00) Then
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    adaptscreengamma()
                EndIf
                If (0.0 = selecteditem\Field12) Then
                    me\Field49 = 1000.0
                    createmsg(getlocalstring("msg", "oldpaper"), 6.0)
                    playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\NostalgiaCancer" + (Str rand($05, $09))) + ".ogg")), $00)
                    selecteditem\Field12 = 1.0
                EndIf
            Case $69
                If (0.0 = selecteditem\Field12) Then
                    playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\NostalgiaCancer" + (Str rand($05, $09))) + ".ogg")), $00)
                    createmsg(getlocalstring("msg", "lostkey"), 6.0)
                    selecteditem\Field12 = 1.0
                EndIf
            Case $6B
                If (0.0 = selecteditem\Field12) Then
                    playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\NostalgiaCancer" + (Str rand($00, $04))) + ".ogg")), $00)
                    selecteditem\Field12 = 1.0
                EndIf
            Case $14
                If (canuseitem($01, $01, $00) <> 0) Then
                    If (i_427\Field0 <> 0) Then
                        createmsg(getlocalstring("msg", "427.off"), 6.0)
                        selecteditem\Field17 = selecteditem\Field4\Field7
                        i_427\Field0 = $00
                    Else
                        createmsg(getlocalstring("msg", "427.on"), 6.0)
                        selecteditem\Field17 = selecteditem\Field4\Field8
                        giveachievement("427", $01)
                        i_427\Field0 = $01
                    EndIf
                    selecteditem = Null
                EndIf
            Case $18
                If (canuseitem($01, $00, $00) <> 0) Then
                    createmsg(getlocalstring("msg", "pill"), 6.0)
                    i_1025\Field0[$00] = 0.0
                    removeitem(selecteditem)
                EndIf
            Case $17
                If (canuseitem($01, $00, $00) <> 0) Then
                    createmsg(getlocalstring("msg", "pill"), 6.0)
                    If (25200.0 > i_427\Field1) Then
                        i_427\Field1 = 25200.0
                    EndIf
                    removeitem(selecteditem)
                EndIf
            Case $15
                If (mp_getsocket() <> $00) Then
                    If (mp_ishoster() <> 0) Then
                        local76 = rand($04, $01)
                        For local77 = $00 To local76 Step $01
                            local1 = createitem("SCP-500-01", $16, entityx(me\Field60, $00), (entityy(camera, $00) - 0.2), entityz(me\Field60, $00), $00, $00, $00, 1.0, $00)
                            entitytype(local1\Field2, $03, $00)
                        Next
                    EndIf
                    createmsg(getlocalstring("msg", "500mp"), 6.0)
                    removeitem(selecteditem)
                ElseIf (i_500\Field0 < rand($14, $01)) Then
                    If (getitemamount() < maxitemamount) Then
                        local1 = createitem("SCP-500-01", $16, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                        entitytype(local1\Field2, $03, $00)
                        pickitem(local1, $00)
                        createmsg(getlocalstring("msg", "500"), 6.0)
                        playsound_strict(loadtempsound("SFX\SCP\500\OpenBottle.ogg"), $00)
                        i_500\Field0 = (i_500\Field0 + $01)
                    Else
                        createmsg(getlocalstring("msg", "cantcarry"), 6.0)
                    EndIf
                    selecteditem = Null
                Else
                    i_500\Field0 = $00
                    removeitem(selecteditem)
                EndIf
            Case $23
                use1123()
                selecteditem = Null
            Case $59,$5A,$5B,$5C,$5D,$5E,$5F,$60,$1E,$1F,$64,$65,$66,$6A,$08,$09,$0A,$68,$67,$6B,$61,$62,$00
            Case $4D,$4E,$4F
                local3 = ((0.0 < selecteditem\Field12) Lor (selecteditem\Field4\Field2 = $4F))
                If (selecteditem\Field4\Field11 = $00) Then
                    local15 = "_off"
                    If (((0.0 < selecteditem\Field12) Lor local3) <> 0) Then
                        local15 = "_on"
                    EndIf
                    selecteditem\Field4\Field10 = (("GFX\Items\HUD Textures\e_reader" + local15) + ".png")
                    selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                    selecteditem\Field4\Field13 = (imagewidth(selecteditem\Field4\Field11) Sar $01)
                    selecteditem\Field4\Field14 = (imageheight(selecteditem\Field4\Field11) Sar $01)
                    maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                    createhintmsg(getlocalstring("msg", "e.reader"), 6.0, $00)
                EndIf
                selecteditem\Field12 = max(0.0, (selecteditem\Field12 - (fps\Field7[$00] * 0.005)))
                local7 = getkey()
                Select local7
                    Case $31
                        selecteditem\Field13 = max(1.0, (selecteditem\Field13 - (Float local3)))
                        playsound_strict(buttonsfx[$00], $00)
                        If (selecteditem\Field4\Field12 <> $00) Then
                            freeimage(selecteditem\Field4\Field12)
                            selecteditem\Field4\Field12 = $00
                        EndIf
                    Case $32
                        selecteditem\Field13 = min((selecteditem\Field13 + (Float local3)), 41.0)
                        playsound_strict(buttonsfx[$00], $00)
                        If (selecteditem\Field4\Field12 <> $00) Then
                            freeimage(selecteditem\Field4\Field12)
                            selecteditem\Field4\Field12 = $00
                        EndIf
                    Case $33
                        selecteditem\Field13 = 0.0
                        playsound_strict(buttonsfx[$00], $00)
                        If (selecteditem\Field4\Field12 <> $00) Then
                            freeimage(selecteditem\Field4\Field12)
                            selecteditem\Field4\Field12 = $00
                        EndIf
                End Select
                If (local3 <> 0) Then
                    selecteditem\Field14 = 0.0
                    local15 = getereaderdocument((Int selecteditem\Field13))
                    If (((selecteditem\Field4\Field12 = $00) And (local15 <> "")) <> 0) Then
                        For local79 = Each itemtemplates
                            If (strippath(local79\Field10) = (local15 + ".png")) Then
                                local79\Field4 = $01
                                Exit
                            EndIf
                        Next
                        local10 = (menuscale * 0.745)
                        selecteditem\Field4\Field12 = resizeimageex(loadimage_strict((("GFX\Items\HUD Textures\" + local15) + ".png")), local10, local10)
                        selecteditem\Field4\Field15 = (imagewidth(selecteditem\Field4\Field12) Sar $01)
                        selecteditem\Field4\Field16 = (imageheight(selecteditem\Field4\Field12) Sar $01)
                        adaptscreengamma()
                    EndIf
                    If (((20.0 > selecteditem\Field12) And (selecteditem\Field4\Field2 <> $4F)) <> 0) Then
                        If (70.0 <= batmsgtimer) Then
                            If (channelplaying(lowbatterychn[$00]) = $00) Then
                                me\Field42 = max(3.0, me\Field42)
                                lowbatterychn[$00] = playsound_strict(snd_i\Field41[$00], $00)
                            EndIf
                        EndIf
                    EndIf
                Else
                    If (0.0 = selecteditem\Field14) Then
                        freeimage(selecteditem\Field4\Field11)
                        selecteditem\Field4\Field11 = $00
                        selecteditem\Field4\Field10 = "GFX\Items\HUD Textures\e_reader_off.png"
                        selecteditem\Field4\Field11 = scaleimageex(loadimage_strict(selecteditem\Field4\Field10), menuscale, menuscale, $01)
                        maskimage(selecteditem\Field4\Field11, $FF, $00, $FF)
                        selecteditem\Field14 = 1.0
                    EndIf
                    createhintmsg(getlocalstring("msg", "bat.combine"), 1.0, $01)
                EndIf
            Default
                If (selecteditem\Field20 > $00) Then
                    otheropen = selecteditem
                EndIf
                selecteditem = Null
        End Select
        If (((((((((menuopen Lor consoleopen) Lor ismultiplayerhudenabled) = $00) And (mo\Field1 Lor keyhit(key\Field6))) Lor (Int me\Field0)) Lor (0.0 > me\Field3)) Lor (me\Field9 = $00)) Lor me\Field56) <> 0) Then
            Select selecteditem\Field4\Field2
                Case $34,$36,$35,$0D,$0E,$0F,$24,$25,$38,$39,$3A,$3B,$26
                    selecteditem\Field12 = 0.0
                Case $27,$28
                    selecteditem\Field12 = 0.0
                    If (wi\Field3 = $00) Then
                        dropitem(selecteditem, $00)
                    EndIf
                Case $3C,$3D,$3E,$3F
                    selecteditem\Field12 = 0.0
                    If (wi\Field2 = $00) Then
                        dropitem(selecteditem, $00)
                    EndIf
                Case $40,$41,$42,$43,$44,$20,$21,$2B
                    selecteditem\Field14 = 0.0
                Case $4D,$4E,$4F
                    selecteditem\Field13 = 0.0
            End Select
            If (selecteditem\Field4\Field3 <> $42) Then
                playsound_strict(snd_i\Field44[selecteditem\Field4\Field3], $00)
            EndIf
            If (selecteditem\Field4\Field11 <> $00) Then
                If (1.0 <> opt\Field7) Then
                    opt\Field6 = opt\Field7
                    opt\Field7 = 1.0
                EndIf
                selecteditem\Field4\Field13 = $00
                selecteditem\Field4\Field14 = $00
                freeimage(selecteditem\Field4\Field11)
                selecteditem\Field4\Field11 = $00
            EndIf
            If (selecteditem\Field4\Field12 <> $00) Then
                If (1.0 <> opt\Field7) Then
                    opt\Field6 = opt\Field7
                    opt\Field7 = 1.0
                EndIf
                selecteditem\Field4\Field15 = $00
                selecteditem\Field4\Field16 = $00
                freeimage(selecteditem\Field4\Field12)
                selecteditem\Field4\Field12 = $00
            EndIf
            For local7 = $00 To $06 Step $01
                If (channelplaying(radiochn[local7]) <> 0) Then
                    stopchannel(radiochn[local7])
                    radiochn[local7] = $00
                EndIf
            Next
            isusingradio = $00
            selecteditem = Null
        EndIf
    ElseIf (channelplaying(lowbatterychn[$00]) <> 0) Then
        stopchannel(lowbatterychn[$00])
        lowbatterychn[$00] = $00
    EndIf
    If ((local17 And (invopen = $00)) <> 0) Then
        movemouse(mo\Field9, mo\Field10)
    EndIf
    catcherrors("Uncaught: UpdateGUI()")
    Return $00
End Function
