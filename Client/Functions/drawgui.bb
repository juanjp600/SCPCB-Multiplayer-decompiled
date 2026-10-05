Function drawgui%()
    Local local0%
    Local local1%
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6$
    Local local7%
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local18#
    Local local19#
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    Local local26%
    Local local27%
    Local local28#
    Local local29%
    Local local30#
    Local local31%
    Local local32%
    Local local33%
    Local local34$
    Local local35.intercomsystem
    Local local36%
    Local local37%
    Local local38$
    Local local39%
    Local local40%
    Local local41%
    Local local42$
    Local local43#
    Local local44#
    Local local45.events
    Local local46%
    Local local47.events
    Local local48%
    Local local49.chunk
    Local local50%
    Local local51%
    Local local52%
    Local local53%
    Local local54#
    Local local55#
    Local local56#
    Local local57#
    Local local58#
    Local local59#
    Local local60#
    Local local61#
    Local local62#
    Local local63#
    Local local65%
    Local local66.items
    Local local67%
    Local local68%
    Local local69%
    Local local70%
    Local local71%
    Local local72%
    Local local73%
    Local local74%
    Local local75%
    Local local76%
    Local local77%
    Local local78%
    Local local79%
    Local local80%
    Local local81%
    Local local82%
    Local local83%
    Local local84$
    Local local86$
    Local local87%
    Local local88%
    Local local90.items
    Local local93.items
    Local local94$
    Local local95$
    Local local96%
    Local local97%
    Local local100$
    Local local103%
    Local local104%
    Local local106.guns
    Local local108%
    Local local109.decals
    Local local112$
    Local local113.rooms
    Local local116$
    Local local117%
    Local local123%
    Local local124%
    Local local125%
    Local local126%
    Local local127%
    Local local128%
    Local local129%
    Local local130%
    Local local131%
    Local local132%
    Local local133%
    Local local134%
    Local local135%
    Local local136%
    Local local137%
    Local local138%
    Local local139%
    Local local140%
    Local local141%
    Local local142#
    Local local143.npcs
    Local local144.players
    Local local146.rooms
    Local local147.rooms
    Local local148$
    Local local149$
    Local local150%
    Local local151%
    Local local152#
    Local local153%
    Local local154$
    Local local155.items
    Local local156$
    local0 = viewport_center_x
    local1 = viewport_center_y
    local2 = menuscale
    local3 = entityx(collider, $01)
    local4 = entityy(collider, $01)
    local5 = entityz(collider, $01)
    local6 = playerroom\Field8\Field11
    local7 = playerroom\Field3
    local8 = playerroom\Field4
    local9 = playerroom\Field5
    local10 = playerroom\Field6
    local11 = entityx(camera, $01)
    local12 = entityy(camera, $01)
    local13 = entityz(camera, $01)
    local14 = entitypitch(camera, $00)
    local15 = entityyaw(camera, $00)
    local16 = entityroll(camera, $00)
    local17 = entitypitch(collider, $00)
    local18 = entityyaw(collider, $00)
    local19 = entityroll(collider, $00)
    local20 = millisecs()
    If (lockmouse = $00) Then
        If (shoulddrawpointer() <> 0) Then
            ui_showpointer()
        Else
            ui_hidepointer()
        EndIf
    EndIf
    local35 = playerintercom
    If (local35\Field3 <> 0) Then
        setfontex(fonts[$00]\Field0)
        local36 = local20
        local37 = $00
        local38 = ""
        If (myplayer\Field50 <> 0) Then
            local37 = (local35\Field0 - local36)
            local38 = "SPEAKING (left: "
        ElseIf (local35\Field1 > local36) Then
            local37 = (local35\Field1 - local36)
            local38 = "YOU CAN SPEAK IN "
        EndIf
        If (local37 > $00) Then
            local39 = (Int ((Float local37) * 0.001))
            local40 = (local39 Mod $3C)
            local41 = (Int ((Float local39) * (1.0 / 60.00024)))
            local42 = (Str local40)
            If (local40 < $0A) Then
                local42 = ("0" + (Str local40))
            EndIf
            text((local0 - $32), (local1 + $64), (((local38 + (Str local41)) + ":") + local42), $00, $00)
        Else
            text((local0 - $32), (local1 + $64), "PRESS LMB TO ENABLE", $00, $00)
        EndIf
    ElseIf (playerroom <> Null) Then
        If (myplayer\Field50 <> 0) Then
            If (local6 <> "room2ccont") Then
                useintercom()
            Else
                local43 = (local8 - 1.035156)
                local44 = (local10 + (1.0 / 2.438095))
                If (9.0 < distance2d(local43, local44, local3, local5)) Then
                    useintercom()
                EndIf
            EndIf
        EndIf
    EndIf
    If (local6 = "pocketdimension") Then
        For local45 = Each events
            If (local45\Field1 = playerroom) Then
                If (1000.0 > (Float local45\Field11)) Then
                    If (600.0 < local45\Field2) Then
                        If (((-3.0 > blinktimer) And (-10.0 < blinktimer)) <> 0) Then
                            If (local45\Field12 = $00) Then
                                If (((-5.0 < blinktimer) And (rand($1E, $01) = $01)) <> 0) Then
                                    playsound_strict(dripsfx($00))
                                    If (local45\Field12 = $00) Then
                                        local45\Field12 = loadimage_strict("GFX\npcs\106face.jpg")
                                    EndIf
                                EndIf
                            Else
                                drawimage(local45\Field12, (local0 - rand($186, $136)), (local1 - rand($122, $136)), $00)
                            EndIf
                        ElseIf (local45\Field12 <> $00) Then
                            freeimage(local45\Field12)
                            local45\Field12 = $00
                        EndIf
                        Exit
                    EndIf
                Else
                    If (((-3.0 > blinktimer) And (-10.0 < blinktimer)) <> 0) Then
                        If (local45\Field12 = $00) Then
                            If (-5.0 < blinktimer) Then
                                If (local45\Field12 = $00) Then
                                    local45\Field12 = loadimage_strict("GFX\kneelmortal.pd")
                                    If (channelplaying(local45\Field5) <> 0) Then
                                        stopchannel(local45\Field5)
                                    EndIf
                                    local45\Field5 = playsound_strict(local45\Field7)
                                EndIf
                            EndIf
                        Else
                            drawimage(local45\Field12, (local0 - rand($186, $136)), (local1 - rand($122, $136)), $00)
                        EndIf
                    Else
                        If (local45\Field12 <> $00) Then
                            freeimage(local45\Field12)
                            local45\Field12 = $00
                        EndIf
                        If (-3.0 > blinktimer) Then
                            If (channelplaying(local45\Field5) = $00) Then
                                local45\Field5 = playsound_strict(local45\Field7)
                            EndIf
                        ElseIf (channelplaying(local45\Field5) <> 0) Then
                            stopchannel(local45\Field5)
                        EndIf
                    EndIf
                    Exit
                EndIf
            EndIf
        Next
    EndIf
    If (spectate\Field1 = $FFFFFFFF) Then
        If ((((((closestbutton <> $00) And (selecteddoor = Null)) And (invopen = $00)) And (menuopen = $00)) And (otheropen = Null)) <> 0) Then
            If (hudenabled <> 0) Then
                drawhand(closestbutton, "", handicon)
            EndIf
            If (ismouseup() <> 0) Then
                If (closestdoor <> Null) Then
                    If (closestdoor\Field17 <> "") Then
                        selecteddoor = closestdoor
                    ElseIf (playable <> 0) Then
                        playsound2(buttonsfx, camera, closestbutton, 10.0, 1.0)
                        multiplayer_writesound(buttonsfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                        mouseup1 = $00
                        If ((usedoor(closestdoor, $01, $01, $01, "", $00) And (closestdoor\Field22 = $00)) <> 0) Then
                            startmillisecs($00, $3E8)
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (using294 <> 0) Then
            use294()
        EndIf
        If (hudenabled <> 0) Then
            drawhud()
            If (debughud <> 0) Then
                local46 = $0A
                setfontex(fonts[$00]\Field0)
                updatedebug3d()
                text(local46, $32, ((((("Player Pos: " + f2s(local3, $02)) + ", ") + f2s(local4, $02)) + ", ") + f2s(local5, $02)), $00, $00)
                text(local46, $46, ((((("Camera Pos: " + f2s(local11, $02)) + ", ") + f2s(local15, $02)) + ", ") + f2s(local13, $02)), $00, $00)
                text(local46, $64, ((((("Player Rot: " + f2s(local17, $02)) + ", ") + f2s(local18, $02)) + ", ") + f2s(local19, $02)), $00, $00)
                text(local46, $78, (((((("Camera Rot: (" + f2s(local14, $03)) + ", ") + f2s(local15, $03)) + ", ") + f2s(local16, $03)) + ")"), $00, $00)
                text(local46, $96, ("Room: " + local6), $00, $00)
                For local47 = Each events
                    If (local47\Field1 = playerroom) Then
                        text(local46, $AA, ("Room event: " + local47\Field0), $00, $00)
                        text(local46, $BE, ("state: " + (Str local47\Field2)), $00, $00)
                        text(local46, $D2, ("state2: " + (Str local47\Field3)), $00, $00)
                        text(local46, $E6, ("state3: " + (Str local47\Field4)), $00, $00)
                        text(local46, $FA, ("str: " + local47\Field11), $00, $00)
                        Exit
                    EndIf
                Next
                text(local46, $118, (((((("Room coordinates: (" + (Str floor(((entityx(playerroom\Field3, $00) / 8.0) + 0.5)))) + ", ") + (Str floor(((entityz(playerroom\Field3, $00) / 8.0) + 0.5)))) + ", angle: ") + (Str playerroom\Field7)) + ")"), $00, $00)
                text(local46, $12C, ("Stamina: " + f2s(stamina, $03)), $00, $00)
                text(local46, $140, ("Death timer: " + f2s(killtimer, $03)), $00, $00)
                text(local46, $154, ("Blink timer: " + f2s(blinktimer, $03)), $00, $00)
                text(local46, $168, ("Injuries: " + (Str injuries)), $00, $00)
                text(local46, $17C, ((((("PREV_PLAYER_MOVE: " + (Str prev_player_move)) + " | PLAYER_MOVE : ") + (Str player_move)) + " | PLAYER_MOVE_TIMED: ") + (Str player_move_timed)), $00, $00)
                If (local6 = "dimension1499") Then
                    text((local22 + $15E), $32, (((("Current Chunk X/Z: (" + (Str (((Int (local3 + 20.0)) * $667) Shr $10))) + ", ") + (Str (((Int (local5 + 20.0)) * $667) Shr $10))) + ")"), $00, $00)
                    local48 = $00
                    For local49 = Each chunk
                        local48 = (local48 + $01)
                    Next
                    text((local22 + $15E), $46, ("Current Chunk Amount: " + (Str local48)), $00, $00)
                Else
                    text((local22 + $15E), $32, (((((("Current Room Position: (" + (Str local8)) + ", ") + (Str local9)) + ", ") + (Str local10)) + ")"), $00, $00)
                EndIf
                globalmemorystatus(m)
                text((local22 + $15E), $5A, ((((((((Str (m\Field3 Shr $14)) + " MB/") + (Str (m\Field2 Shr $14))) + " MB (") + (Str (m\Field3 Shr $0A))) + " KB/") + (Str (m\Field2 Shr $0A))) + " KB)"), $00, $00)
                text((local22 + $15E), $6E, ("Triangles rendered: " + (Str currtrisamount)), $00, $00)
                text((local22 + $15E), $82, ("Active textures: " + (Str activetextures())), $00, $00)
                text((local22 + $15E), $AA, ("SCP-008 infection: " + (Str infect)), $00, $00)
                For local25 = $00 To $05 Step $01
                    text((local22 + $15E), (($14 * local25) + $BE), ((("SCP-1025 State " + (Str local25)) + ": ") + (Str scp1025state[local25])), $00, $00)
                Next
                If (selectedmonitor <> Null) Then
                    text((local22 + $15E), $136, ("Current monitor: " + (Str selectedmonitor\Field4)), $00, $00)
                Else
                    text((local22 + $15E), $136, "Current monitor: NULL", $00, $00)
                EndIf
                text((local22 + $15E), $14A, ("Received (KB): " + (Str udp_network\Field4)), $00, $00)
                text((local22 + $15E), $15E, ("Writed (KB): " + (Str udp_network\Field5)), $00, $00)
            EndIf
        EndIf
        If (selectedscreen <> Null) Then
            drawimage(selectedscreen\Field2, (local0 - (imagewidth(selectedscreen\Field2) Shr $01)), (local1 - (imageheight(selectedscreen\Field2) Shr $01)), $00)
            If ((ismouseup() Or mousehit2) <> 0) Then
                selectedscreen = Null
                mouseup1 = $00
            EndIf
        EndIf
        local50 = invopen
        local51 = $42
        local52 = $01
        If (selecteddoor <> Null) Then
            selecteditem = Null
            If (local52 <> 0) Then
                local53 = closestbutton
                local54 = entityx(local53, $01)
                local55 = entityy(local53, $01)
                local56 = entityz(local53, $01)
                positionentity(camera, local54, local55, local56, $00)
                rotateentity(camera, 0.0, entityyaw(local53, $01), 0.0, $00)
                holdinggun = $00
                eqquipedgun = Null
                moveentity(camera, 0.0, 0.0, -0.25)
                cameraproject(camera, local54, ((meshheight(buttonobj) * 0.015) + local55), local56)
                local57 = projectedy()
                cameraproject(camera, local54, (local55 - (meshheight(buttonobj) * 0.015)), local56)
                local58 = ((projectedy() - local57) * (1.0 / 462.0005))
                local22 = (Int ((Float local0) - (((Float imagewidth(keypadhud)) * local58) * 0.5)))
                local23 = (Int ((Float local1) - (((Float imageheight(keypadhud)) * local58) * 0.5)))
                If (keypadmsg <> "") Then
                    setfontex(fonts[$02]\Field0)
                    keypadtimer = (keypadtimer - fpsfactor2)
                    If (35.0 > (keypadtimer Mod 70.0)) Then
                        text(local0, (Int ((124.0 * local58) + (Float local23))), keypadmsg, $01, $01)
                    EndIf
                    If (0.0 >= keypadtimer) Then
                        keypadmsg = ""
                        selecteddoor = Null
                        resetmouse()
                    EndIf
                Else
                    text(local0, (Int ((70.0 * local58) + (Float local23))), "ACCESS CODE: ", $01, $01)
                    If (keypadinput <> "") Then
                        setfontex(fonts[$03]\Field0)
                        text(local0, (Int ((124.0 * local58) + (Float local23))), keypadinput, $01, $01)
                    EndIf
                EndIf
                local22 = (Int ((44.0 * local58) + (Float local22)))
                local23 = (Int ((249.0 * local58) + (Float local23)))
                local59 = (58.5 * local58)
                local60 = (67.0 * local58)
                local61 = (54.0 * local58)
                local62 = (65.0 * local58)
                For local31 = $00 To $03 Step $01
                    local63 = (((Float local31) * local59) + (Float local22))
                    For local25 = $00 To $02 Step $01
                        local33 = (Int (((Float local25) * local60) + (Float local23)))
                        local32 = (Int local63)
                        local21 = $00
                        If ((mouseon(local32, local33, (Int local61), (Int local62)) And (keypadmsg = "")) <> 0) Then
                            If (mouseup1 <> 0) Then
                                playsound_strict(buttonsfx)
                                multiplayer_writesound(buttonsfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                                Select ((local31 + $01) + (local25 Shl $02))
                                    Case $01,$02,$03
                                        keypadinput = (keypadinput + (Str ((local31 + $01) + (local25 Shl $02))))
                                    Case $04
                                        keypadinput = (keypadinput + "0")
                                    Case $05,$06,$07
                                        keypadinput = (keypadinput + (Str (((local31 + $01) + (local25 Shl $02)) - $01)))
                                    Case $08
                                        If (selecteddoor\Field37 <> 0) Then
                                            multiplayer_senddoor(selecteddoor, Null, keypadinput)
                                        ElseIf (keypadinput = selecteddoor\Field17) Then
                                            playsound_strict(scannersfx1)
                                            If (selecteddoor\Field17 = (Str accesscode)) Then
                                                giveachievement($1B, $01)
                                            ElseIf (selecteddoor\Field17 = "7816") Then
                                                giveachievement($1C, $01)
                                            EndIf
                                            selecteddoor\Field4 = $00
                                            usedoor(selecteddoor, $01, $01, $01, selecteddoor\Field17, $00)
                                            selecteddoor = Null
                                            resetmouse()
                                        Else
                                            If (udp_getstream() <> 0) Then
                                                multiplayer_senddoor(selecteddoor, Null, keypadinput)
                                            EndIf
                                            playsound_strict(scannersfx2)
                                            keypadmsg = "ACCESS DENIED"
                                            keypadtimer = 210.0
                                            keypadinput = ""
                                        EndIf
                                    Case $09,$0A,$0B
                                        keypadinput = (keypadinput + (Str (((local31 + $01) + (local25 Shl $02)) - $02)))
                                    Case $0C
                                        keypadinput = ""
                                End Select
                                If (selecteddoor <> Null) Then
                                    If (len(selecteddoor\Field17) <> $08) Then
                                        If (len(keypadinput) > $04) Then
                                            keypadinput = left(keypadinput, $04)
                                        EndIf
                                    ElseIf (len(keypadinput) > $08) Then
                                        keypadinput = left(keypadinput, $04)
                                    EndIf
                                ElseIf (len(keypadinput) > $08) Then
                                    keypadinput = left(keypadinput, $04)
                                EndIf
                            EndIf
                        Else
                            local21 = $00
                        EndIf
                    Next
                Next
                ui_showpointer()
                If (mousehit2 <> 0) Then
                    selecteddoor = Null
                    resetmouse()
                EndIf
            Else
                selecteddoor = Null
            EndIf
        Else
            keypadinput = ""
            keypadtimer = 0.0
            keypadmsg = ""
        EndIf
    EndIf
    If (((keyhit($01) And (0.0 = endingtimer)) And (using294 = $00)) <> 0) Then
        If (optionsmenu > $00) Then
            saveoptionsini()
        EndIf
        menuopen = (menuopen = $00)
        menu_open_type = menuopen
        achievementsmenu = $00
        optionsmenu = $00
        quitmsg = $00
        suicidemsg = $00
        selecteddoor = Null
        selectedscreen = Null
        selectedmonitor = Null
        If (selecteditem <> Null) Then
            If ((instr(selecteditem\Field1\Field2, "vest", $01) Or instr(selecteditem\Field1\Field2, "hazmatsuit", $01)) <> 0) Then
                If (((wearingvest = $00) And (wearinghazmat = $00)) <> 0) Then
                    dropitem(selecteditem, $01)
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        If (udp_getstream() = $00) Then
            If (menuopen = $00) Then
                resumesounds()
                resetmouse()
            Else
                pausesounds()
            EndIf
        EndIf
    EndIf
    If (otheropen <> Null) Then
        stated = $00
        local66 = otheropen
        local67 = otheropen\Field20
        For local25 = $00 To (local67 - $01) Step $01
            If (otheropen\Field18[local25] <> Null) Then
                local68 = (local68 + $01)
            EndIf
        Next
        invopen = $00
        selecteddoor = Null
        local81 = $00
        local82 = imenuscale[$46]
        local83 = local82
        local65 = imenuscale[$23]
        local72 = (Int ((Float local82) * 0.5))
        local73 = (Int ((Float local83) * 0.5))
        local74 = imenuscale[$20]
        local22 = (Int ((Float local0) - ((((Float (local82 * $0A)) * 0.5) + ((Float local65) * 4.0)) * 0.5)))
        local23 = (Int ((Float local1) - ((((Float (local83 * local67)) * 0.2) + ((((Float local67) * 0.2) - 1.0) * (Float local83))) * 0.5)))
        itemamount = $00
        For local31 = $00 To (local67 - $01) Step $01
            local70 = $00
            If (((mouseposx > local22) And (mouseposx < (local22 + local82))) <> 0) Then
                If (((mouseposy > local23) And (mouseposy < (local23 + local83))) <> 0) Then
                    local70 = $01
                EndIf
            EndIf
            If (local70 <> 0) Then
                local51 = local31
                setcolorex($FF, $00, $00)
                rect((local22 - $01), (local23 - $01), (local82 + $02), (local83 + $02), $01)
            EndIf
            drawframe(local22, local23, local82, local83, (local22 Mod $40), (local22 Mod $40))
            If (otheropen = Null) Then
                Exit
            EndIf
            If (otheropen\Field18[local31] <> Null) Then
                If (((selecteditem <> otheropen\Field18[local31]) Or local70) <> 0) Then
                    drawblock(otheropen\Field18[local31]\Field17, ((local22 + local72) - local74), ((local23 + local73) - local74), $00)
                EndIf
            EndIf
            If (((otheropen\Field18[local31] <> Null) And (selecteditem <> otheropen\Field18[local31])) <> 0) Then
                If (local70 <> 0) Then
                    local38 = otheropen\Field18[local31]\Field1\Field1
                    local75 = (local22 + local72)
                    local76 = (((local23 + local83) + local65) - imenuscale[$0F])
                    local77 = stringwidth(local38)
                    local78 = fonts[$00]\Field2
                    local79 = imenuscale[$05]
                    local80 = imenuscale[$0A]
                    drawframe((Int (((Float local75) - ((Float local77) * 0.5)) - (Float local79))), (local76 - local79), (local77 + local80), (local78 + local80), $00, $00)
                    setcolorex($BE, $BE, $BE)
                    setfontex(fonts[$00]\Field0)
                    text(local75, local76, local38, $01, $00)
                    If (selecteditem = Null) Then
                        If (mousehit1 <> 0) Then
                            selecteditem = otheropen\Field18[local31]
                            mousehit1 = $00
                            If (doubleclick <> 0) Then
                                If (otheropen\Field18[local31]\Field1\Field3 <> $42) Then
                                    playsound_strict(picksfx(otheropen\Field18[local31]\Field1\Field3))
                                EndIf
                                otheropen = Null
                                local71 = $01
                                invopen = $00
                                doubleclick = $00
                                blockguns = $01
                            EndIf
                        EndIf
                    EndIf
                EndIf
                itemamount = (itemamount + $01)
            ElseIf ((local70 And mousehit1) <> 0) Then
                For local24 = $00 To (local67 - $01) Step $01
                    If (otheropen\Field18[local24] = selecteditem) Then
                        otheropen\Field18[local24] = Null
                    EndIf
                Next
                otheropen\Field18[local31] = selecteditem
            EndIf
            local22 = ((local22 + local82) + local65)
            local81 = (local81 + $01)
            If (local81 = $05) Then
                local81 = $00
                local23 = (local23 + (local83 Shl $01))
                local22 = (local0 - ((((local82 * $0A) Shr $01) + (local65 Shl $02)) Shr $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mousedown1 <> 0) Then
                If (local51 = $42) Then
                    drawblock(selecteditem\Field17, (mouseposx - local74), (mouseposy - local74), $00)
                ElseIf (selecteditem <> local66\Field18[local51]) Then
                    drawblock(selecteditem\Field17, (mouseposx - local74), (mouseposy - local74), $00)
                EndIf
            Else
                If (local51 = $42) Then
                    dropitem(selecteditem, $01)
                    local67 = otheropen\Field20
                    For local24 = $00 To (local67 - $01) Step $01
                        If (otheropen\Field18[local24] = selecteditem) Then
                            otheropen\Field18[local24] = Null
                        EndIf
                    Next
                    local69 = $01
                    If (otheropen\Field1\Field2 = "wallet") Then
                        If (local69 = $00) Then
                            For local24 = $00 To (local67 - $01) Step $01
                                If (otheropen\Field18[local24] <> Null) Then
                                    local84 = otheropen\Field18[local24]\Field1\Field2
                                    If ((((((local84 <> "25ct") And (local84 <> "coin")) And (local84 <> "key")) And (local84 <> "scp860")) And (local84 <> "scp714")) <> 0) Then
                                        local69 = $00
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    Else
                        For local24 = $00 To (local67 - $01) Step $01
                            If (otheropen\Field18[local24] <> Null) Then
                                local69 = $00
                                Exit
                            EndIf
                        Next
                    EndIf
                    If (local69 <> 0) Then
                        Select otheropen\Field1\Field2
                            Case "clipboard"
                                otheropen\Field17 = otheropen\Field1\Field9
                                setanimtime(otheropen\Field3, 17.0, $00)
                            Case "wallet"
                                setanimtime(otheropen\Field3, 0.0, $00)
                        End Select
                    EndIf
                    selecteditem = Null
                    otheropen = Null
                    local71 = $01
                    movemouse(local0, local1)
                ElseIf (local66\Field18[local51] = Null) Then
                    For local24 = $00 To (local67 - $01) Step $01
                        If (local66\Field18[local24] = selecteditem) Then
                            local66\Field18[local24] = Null
                        EndIf
                    Next
                    local66\Field18[local51] = selecteditem
                    selecteditem = Null
                ElseIf (local66\Field18[local51] <> selecteditem) Then
                    local86 = selecteditem\Field1\Field2
                    setmsg("You cannot combine these two items.")
                    msgtimer = 350.0
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        ui_showpointer()
        If ((local71 And (invopen = $00)) <> 0) Then
            otheropen = Null
            resetmouse()
        EndIf
    ElseIf (invopen <> 0) Then
        stated = $00
        selecteddoor = Null
        local82 = imenuscale[$46]
        local83 = local82
        local65 = imenuscale[$23]
        local72 = (Int ((Float local82) * 0.5))
        local73 = (Int ((Float local83) * 0.5))
        local74 = imenuscale[$20]
        local22 = (Int ((Float local0) - ((((Float (local82 * $0A)) * 0.5) + ((Float local65) * 4.0)) * 0.5)))
        local23 = (Int ((Float local1) - ((((Float (local83 * $0A)) * 0.2) + ((Float local83) * 1.0)) * 0.5)))
        itemamount = $00
        For local31 = $00 To $09 Step $01
            local70 = $00
            If (((mouseposx > local22) And (mouseposx < (local22 + local82))) <> 0) Then
                If (((mouseposy > local23) And (mouseposy < (local23 + local83))) <> 0) Then
                    local70 = $01
                EndIf
            EndIf
            If (inventory(local31) <> Null) Then
                local87 = $00
                If (inventory(local31)\Field16 = $00) Then
                    inventory(local31) = Null
                Else
                    For local88 = (local31 + $01) To $09 Step $01
                        If (((inventory(local88) <> Null) And (inventory(local88) = inventory(local31))) <> 0) Then
                            inventory(local88) = Null
                        EndIf
                    Next
                EndIf
                setcolorex($C8, $C8, $C8)
                If (inventory(local31) <> Null) Then
                    Select inventory(local31)\Field1\Field2
                        Case "gasmask"
                            If (wearinggasmask = $01) Then
                                local87 = $01
                            EndIf
                        Case "supergasmask"
                            If (wearinggasmask = $02) Then
                                local87 = $01
                            EndIf
                        Case "gasmask3"
                            If (wearinggasmask = $03) Then
                                local87 = $01
                            EndIf
                        Case "hazmatsuit"
                            If (wearinghazmat = $01) Then
                                local87 = $01
                            EndIf
                        Case "hazmatsuit2"
                            If (wearinghazmat = $02) Then
                                local87 = $01
                            EndIf
                        Case "hazmatsuit3"
                            If (wearinghazmat = $03) Then
                                local87 = $01
                            EndIf
                        Case "vest"
                            If (wearingvest = $01) Then
                                local87 = $01
                            EndIf
                        Case "finevest"
                            If (wearingvest = $02) Then
                                local87 = $01
                            EndIf
                        Case "scp714"
                            If (wearing714 = $01) Then
                                local87 = $01
                            EndIf
                        Case "nvgoggles"
                            If (wearingnightvision = $01) Then
                                local87 = $01
                            EndIf
                        Case "supernv"
                            If (wearingnightvision = $02) Then
                                local87 = $01
                            EndIf
                        Case "scp1499"
                            If (wearing1499 = $01) Then
                                local87 = $01
                            EndIf
                        Case "super1499"
                            If (wearing1499 = $02) Then
                                local87 = $01
                            EndIf
                        Case "finenvgoggles"
                            If (wearingnightvision = $03) Then
                                local87 = $01
                            EndIf
                        Case "scp427"
                            If (i_427\Field0 = $01) Then
                                local87 = $01
                            EndIf
                    End Select
                EndIf
            EndIf
            If (local70 <> 0) Then
                local51 = local31
                setcolorex($FF, $00, $00)
            EndIf
            If (local87 <> 0) Then
                rect((local22 - $03), (local23 - $03), (local82 + $06), (local83 + $06), $01)
                local87 = $00
            EndIf
            setcolorex($FF, $FF, $FF)
            drawframe(local22, local23, local82, local83, (local22 Mod $40), (local22 Mod $40))
            If (inventory(local31) <> Null) Then
                If (((selecteditem <> inventory(local31)) Or local70) <> 0) Then
                    drawblock(inventory(local31)\Field17, ((local22 + local72) - local74), ((local23 + local73) - local74), $00)
                EndIf
            EndIf
            If (((inventory(local31) <> Null) And (selecteditem <> inventory(local31))) <> 0) Then
                If (local70 <> 0) Then
                    If (selecteditem = Null) Then
                        If (mousehit1 <> 0) Then
                            selecteditem = inventory(local31)
                            mousehit1 = $00
                            If (doubleclick <> 0) Then
                                If (inventory(local31)\Field1\Field3 <> $42) Then
                                    playsound_strict(picksfx(inventory(local31)\Field1\Field3))
                                EndIf
                                If (myplayer\Field80 = $00) Then
                                    pickupgun(selecteditem)
                                EndIf
                                invopen = $00
                                doubleclick = $00
                                blockguns = $01
                            EndIf
                        EndIf
                        local38 = inventory(local31)\Field0
                        local75 = (local22 + local72)
                        local76 = (((local23 + local83) + local65) - imenuscale[$0F])
                        local77 = stringwidth(local38)
                        local78 = fonts[$00]\Field2
                        local79 = imenuscale[$05]
                        local80 = imenuscale[$0A]
                        drawframe((Int (((Float local75) - ((Float local77) * 0.5)) - (Float local79))), (local76 - local79), (local77 + local80), (local78 + local80), $00, $00)
                        setcolorex($BE, $BE, $BE)
                        setfontex(fonts[$00]\Field0)
                        text(local75, local76, local38, $01, $00)
                    EndIf
                EndIf
                itemamount = (itemamount + $01)
            ElseIf ((local70 And mousehit1) <> 0) Then
                For local24 = $00 To $09 Step $01
                    If (inventory(local24) = selecteditem) Then
                        inventory(local24) = Null
                    EndIf
                Next
                inventory(local31) = selecteditem
            EndIf
            local22 = ((local22 + local82) + local65)
            If (local31 = $04) Then
                local23 = (local23 + (local83 Shl $01))
                local22 = ((graphicwidth Shr $01) - ((((local82 * $0A) Shr $01) + (local65 Shl $02)) Shr $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mousedown1 <> 0) Then
                If (local51 = $42) Then
                    drawblock(selecteditem\Field17, (mouseposx - (imagewidth(selecteditem\Field1\Field8) Shr $01)), (mouseposy - (imageheight(selecteditem\Field1\Field8) Shr $01)), $00)
                ElseIf (selecteditem <> inventory(local51)) Then
                    drawblock(selecteditem\Field17, (mouseposx - (imagewidth(selecteditem\Field1\Field8) Shr $01)), (mouseposy - (imageheight(selecteditem\Field1\Field8) Shr $01)), $00)
                EndIf
            Else
                If (local51 = $42) Then
                    Select selecteditem\Field1\Field2
                        Case "vest","finevest","hazmatsuit","hazmatsuit2","hazmatsuit3"
                            setmsg("Double click on this item to take it off.")
                        Case "scp1499","super1499"
                            If (wearing1499 > $00) Then
                                setmsg("Double click on this item to take it off.")
                            Else
                                dropitem(selecteditem, $01)
                                selecteditem = Null
                                invopen = $00
                            EndIf
                        Default
                            dropitem(selecteditem, $01)
                            selecteditem = Null
                            invopen = $00
                    End Select
                    movemouse(local0, local1)
                ElseIf (inventory(local51) = Null) Then
                    For local24 = $00 To $09 Step $01
                        If (inventory(local24) = selecteditem) Then
                            inventory(local24) = Null
                        EndIf
                    Next
                    inventory(local51) = selecteditem
                    selecteditem = Null
                ElseIf (inventory(local51) <> selecteditem) Then
                    Select selecteditem\Field1\Field2
                        Case "paper","key1","key2","key3","key4","key5","key6","misc","oldpaper","badge","ticket","25ct","coin","key","scp860"
                            If (inventory(local51)\Field1\Field2 = "clipboard") Then
                                local93 = Null
                                local94 = selecteditem\Field1\Field2
                                local95 = selecteditem\Field1\Field1
                                If ((((((((local94 <> "misc") And (local94 <> "25ct")) And (local94 <> "coin")) And (local94 <> "key")) And (local94 <> "scp860")) And (local94 <> "scp714")) Or ((local95 = "Playing Card") Or (local95 = "Mastercard"))) <> 0) Then
                                    For local96 = $00 To (inventory(local51)\Field20 - $01) Step $01
                                        If (inventory(local51)\Field18[local96] = Null) Then
                                            If (selecteditem <> Null) Then
                                                inventory(local51)\Field18[local96] = selecteditem
                                                inventory(local51)\Field13 = 1.0
                                                setanimtime(inventory(local51)\Field3, 0.0, $00)
                                                inventory(local51)\Field17 = inventory(local51)\Field1\Field8
                                                For local97 = $00 To $09 Step $01
                                                    If (inventory(local97) = selecteditem) Then
                                                        inventory(local97) = Null
                                                        playsound_strict(picksfx(selecteditem\Field1\Field3))
                                                    EndIf
                                                Next
                                                local93 = selecteditem
                                                selecteditem = Null
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    If (selecteditem <> Null) Then
                                        setmsg("The paperclip is not strong enough to hold any more items.")
                                    ElseIf (((local93\Field1\Field2 = "paper") Or (local93\Field1\Field2 = "oldpaper")) <> 0) Then
                                        setmsg("This document was added to the clipboard.")
                                    ElseIf (local93\Field1\Field2 = "badge") Then
                                        setmsg((local93\Field1\Field1 + " was added to the clipboard."))
                                    Else
                                        setmsg((("The " + local93\Field1\Field1) + " was added to the clipboard."))
                                    EndIf
                                Else
                                    setmsg("You cannot combine these two items.")
                                EndIf
                            ElseIf (inventory(local51)\Field1\Field2 = "wallet") Then
                                local93 = Null
                                local94 = selecteditem\Field1\Field2
                                local95 = selecteditem\Field1\Field1
                                If (((((local94 <> "misc") And (local94 <> "paper")) And (local94 <> "oldpaper")) Or ((local95 = "Playing Card") Or (local95 = "Mastercard"))) <> 0) Then
                                    For local96 = $00 To (inventory(local51)\Field20 - $01) Step $01
                                        If (inventory(local51)\Field18[local96] = Null) Then
                                            If (selecteditem <> Null) Then
                                                inventory(local51)\Field18[local96] = selecteditem
                                                inventory(local51)\Field13 = 1.0
                                                If (((((local94 <> "25ct") And (local94 <> "coin")) And (local94 <> "key")) And (local94 <> "scp860")) <> 0) Then
                                                    setanimtime(inventory(local51)\Field3, 3.0, $00)
                                                EndIf
                                                inventory(local51)\Field17 = inventory(local51)\Field1\Field8
                                                For local97 = $00 To $09 Step $01
                                                    If (inventory(local97) = selecteditem) Then
                                                        inventory(local97) = Null
                                                        playsound_strict(picksfx(selecteditem\Field1\Field3))
                                                    EndIf
                                                Next
                                                local93 = selecteditem
                                                selecteditem = Null
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    If (selecteditem <> Null) Then
                                        setmsg("The wallet is full.")
                                    Else
                                        setmsg((("You put " + local93\Field1\Field1) + " into the wallet."))
                                    EndIf
                                Else
                                    setmsg("You cannot combine these two items.")
                                EndIf
                            Else
                                setmsg("You cannot combine these two items.")
                            EndIf
                            selecteditem = Null
                        Case "battery","bat"
                            Select inventory(local51)\Field1\Field1
                                Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                    If (selecteditem\Field1\Field3 <> $42) Then
                                        playsound_strict(picksfx(selecteditem\Field1\Field3))
                                    EndIf
                                    removeitem(selecteditem, $01)
                                    selecteditem = Null
                                    inventory(local51)\Field13 = 100.0
                                    setmsg("You replaced the navigator's battery.")
                                Case "S-NAV Navigator Ultimate"
                                    setmsg("There seems to be no place for batteries in this navigator.")
                                Case "Radio Transceiver"
                                    Select inventory(local51)\Field1\Field2
                                        Case "fineradio","veryfineradio"
                                            setmsg("There seems to be no place for batteries in this radio.")
                                        Case "18vradio"
                                            setmsg("The battery does not fit inside this radio.")
                                        Case "radio"
                                            If (selecteditem\Field1\Field3 <> $42) Then
                                                playsound_strict(picksfx(selecteditem\Field1\Field3))
                                            EndIf
                                            removeitem(selecteditem, $01)
                                            selecteditem = Null
                                            inventory(local51)\Field13 = 100.0
                                            setmsg("You replaced the radio's battery.")
                                    End Select
                                Case "Night Vision Goggles"
                                    local100 = inventory(local51)\Field1\Field2
                                    If (((local100 = "nvgoggles") Or (local100 = "supernv")) <> 0) Then
                                        If (selecteditem\Field1\Field3 <> $42) Then
                                            playsound_strict(picksfx(selecteditem\Field1\Field3))
                                        EndIf
                                        removeitem(selecteditem, $01)
                                        selecteditem = Null
                                        inventory(local51)\Field13 = 1000.0
                                        setmsg("You replaced the goggles' battery.")
                                    Else
                                        setmsg("There seems to be no place for batteries in these night vision goggles.")
                                    EndIf
                                Default
                                    setmsg("You cannot combine these two items.")
                            End Select
                        Case "18vbat"
                            Select inventory(local51)\Field1\Field1
                                Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                    setmsg("The battery does not fit inside this navigator.")
                                Case "S-NAV Navigator Ultimate"
                                    setmsg("There seems to be no place for batteries in this navigator.")
                                Case "Radio Transceiver"
                                    Select inventory(local51)\Field1\Field2
                                        Case "fineradio","veryfineradio"
                                            setmsg("There seems to be no place for batteries in this radio.")
                                        Case "18vradio"
                                            If (selecteditem\Field1\Field3 <> $42) Then
                                                playsound_strict(picksfx(selecteditem\Field1\Field3))
                                            EndIf
                                            removeitem(selecteditem, $01)
                                            selecteditem = Null
                                            inventory(local51)\Field13 = 100.0
                                            setmsg("You replaced the radio's battery.")
                                    End Select
                                Default
                                    setmsg("You cannot combine these two items.")
                            End Select
                        Default
                            setmsg("You cannot combine these two items.")
                    End Select
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        ui_showpointer()
        If (invopen = $00) Then
            resetmouse()
        EndIf
    ElseIf (selecteditem <> Null) Then
        local103 = $00
        local104 = $00
        If (selecteditem\Field16 = $00) Then
            selecteditem = Null
        Else
            Select selecteditem\Field1\Field2
                Case "nvgoggles"
                    local103 = $01
                    local104 = $01
                    selecteditem\Field15 = min((selecteditem\Field15 + (fpsfactor * 2.0)), 100.0)
                    If (100.0 = selecteditem\Field15) Then
                        selecteditem\Field15 = 0.0
                        If (((wearing1499 = $00) And (wearinghazmat = $00)) <> 0) Then
                            If (wearingnightvision = $01) Then
                                setmsg("You removed the goggles.")
                                camerafogfar = storedcamerafogfar
                            Else
                                setmsg("You put on the goggles.")
                                wearinggasmask = $00
                                wearingnightvision = $00
                                storedcamerafogfar = camerafogfar
                                camerafogfar = 30.0
                            EndIf
                            wearingnightvision = (wearingnightvision = $00)
                        ElseIf (wearing1499 > $00) Then
                            setmsg("You need to take off SCP-1499 in order to put on the goggles.")
                        Else
                            setmsg("You need to take off the hazmat suit in order to put on the goggles.")
                        EndIf
                        selecteditem = Null
                    EndIf
                Case "supernv"
                    local103 = $01
                    local104 = $01
                    selecteditem\Field15 = min((selecteditem\Field15 + (fpsfactor * 2.0)), 100.0)
                    If (100.0 = selecteditem\Field15) Then
                        selecteditem\Field15 = 0.0
                        If (((wearing1499 = $00) And (wearinghazmat = $00)) <> 0) Then
                            If (wearingnightvision = $02) Then
                                setmsg("You removed the goggles.")
                                camerafogfar = storedcamerafogfar
                            Else
                                setmsg("You put on the goggles.")
                                wearinggasmask = $00
                                wearingnightvision = $00
                                storedcamerafogfar = camerafogfar
                                camerafogfar = 30.0
                            EndIf
                            wearingnightvision = ((wearingnightvision = $00) Shl $01)
                        ElseIf (wearing1499 > $00) Then
                            setmsg("You need to take off SCP-1499 in order to put on the goggles.")
                        Else
                            setmsg("You need to take off the hazmat suit in order to put on the goggles.")
                        EndIf
                        selecteditem = Null
                    EndIf
                Case "finenvgoggles"
                    local103 = $01
                    local104 = $01
                    selecteditem\Field15 = min((selecteditem\Field15 + (fpsfactor * 2.0)), 100.0)
                    If (100.0 = selecteditem\Field15) Then
                        selecteditem\Field15 = 0.0
                        If (((wearing1499 = $00) And (wearinghazmat = $00)) <> 0) Then
                            If (wearingnightvision = $03) Then
                                setmsg("You removed the goggles.")
                                camerafogfar = storedcamerafogfar
                            Else
                                setmsg("You put on the goggles.")
                                wearinggasmask = $00
                                wearingnightvision = $00
                                storedcamerafogfar = camerafogfar
                                camerafogfar = 30.0
                            EndIf
                            wearingnightvision = ((wearingnightvision = $00) * $03)
                        ElseIf (wearing1499 > $00) Then
                            setmsg("You need to take off SCP-1499 in order to put on the goggles.")
                        Else
                            setmsg("You need to take off the hazmat suit in order to put on the goggles.")
                        EndIf
                        selecteditem = Null
                    EndIf
                Case "ring"
                    If (wearing714 = $02) Then
                        setmsg("You removed the ring.")
                        wearing714 = $00
                    Else
                        setmsg("You put on the ring.")
                        wearing714 = $02
                    EndIf
                    selecteditem = Null
                Case "1123"
                    If ((wearing714 = $01) = $00) Then
                        If (playerroom\Field8\Field11 <> "room1123") Then
                            showentity(light)
                            lightflash = 7.0
                            playsound_strict(loadtempsound("SFX\SCP\1123\Touch.ogg"))
                            multiplayer_writetempsound("SFX\SCP\1123\Touch.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                            deathmsg = "Subject D-9341 was shot dead after attempting to attack a member of Nine-Tailed Fox. Surveillance tapes show that the subject had been "
                            deathmsg = ((((deathmsg + "wandering around the site approximately 9 minutes prior, shouting the phrase ") + chr($22)) + "get rid of the four pests") + chr($22))
                            deathmsg = (deathmsg + " in chinese. SCP-1123 was found in [REDACTED] nearby, suggesting the subject had come into physical contact with it. How ")
                            deathmsg = (deathmsg + "exactly SCP-1123 was removed from its containment chamber is still unknown.")
                            kill("was killed by SCP-1123", $00)
                            Return $00
                        EndIf
                        For local45 = Each events
                            If (local45\Field0 = "room1123") Then
                                If (0.0 = local45\Field2) Then
                                    showentity(light)
                                    lightflash = 3.0
                                    playsound_strict(loadtempsound("SFX\SCP\1123\Touch.ogg"))
                                EndIf
                                local45\Field2 = max(1.0, local45\Field2)
                                Exit
                            EndIf
                        Next
                    EndIf
                Case "battery"
                Case "key1","key2","key3","key4","key5","key6","keyomni","scp860","hand","hand2","25ct"
                    local103 = $01
                Case "scp513"
                    playsound_strict(loadtempsound("SFX\SCP\513\Bell1.ogg"))
                    multiplayer_writetempsound("SFX\SCP\513\Bell1.ogg", local3, local4, local5, 20.0, 0.8)
                    selecteditem = Null
                Case "scp500"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        giveachievement($0E, $01)
                        If (0.0 < infect) Then
                            setmsg("You swallowed the pill. Your nausea is fading.")
                        Else
                            setmsg("You swallowed the pill.")
                        EndIf
                        deathtimer = 0.0
                        infect = 0.0
                        stamina = 100.0
                        If (iscoopmode() <> 0) Then
                            For local25 = $00 To $05 Step $01
                                scp1025state[local25] = 0.0
                            Next
                        EndIf
                        If (1.0 < staminaeffect) Then
                            staminaeffect = 1.0
                            staminaeffecttimer = 0.0
                        EndIf
                        myplayer\Field68 = (myplayer\Field68 + 75.0)
                        removeitem(selecteditem, $01)
                        selecteditem = Null
                    EndIf
                Case "boxofammo"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        local103 = $01
                        local104 = $01
                        selecteditem\Field15 = min((selecteditem\Field15 + (fpsfactor * 0.5)), 100.0)
                        If (100.0 = selecteditem\Field15) Then
                            selecteditem\Field15 = 0.0
                            removeitem(selecteditem, $01)
                            selecteditem = Null
                            setmsg("Ammo reserve fully replenished.")
                            For local106 = Each guns
                                local106\Field18 = local106\Field34
                            Next
                        EndIf
                    EndIf
                Case "chicken"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        currspeed = curvevalue(0.0, currspeed, 5.0)
                        local103 = $01
                        local104 = $01
                        selecteditem\Field13 = min((selecteditem\Field13 + (fpsfactor / 7.0)), 100.0)
                        If (100.0 = selecteditem\Field13) Then
                            Select rand($07, $01)
                                Case $00
                                    setmsg("You feel bad because you have gastritis")
                                    vomittimer = 30.0
                                Case $01
                                    setmsg("You feel very good!")
                                    injuries = max((injuries - 0.5), 0.0)
                                    blurtimer = 100.0
                                Case $02
                                    setmsg("You choked on a chicken and smother")
                                    playsound_strict(coughsfx(rand($00, $02)))
                                    multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                    kill("was killed by chicken", $00)
                                    blurtimer = 2000.0
                                Case $03
                                    setmsg("You choked on a chicken")
                                    playsound_strict(coughsfx(rand($00, $02)))
                                    multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                    blurtimer = 2000.0
                                Case $04
                                    setmsg("There were nails in the chicken")
                                    playsound_strict(coughsfx(rand($00, $02)))
                                    multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                    injuries = 30.0
                                    bloodloss = 10.0
                                    local108 = createpivot($00)
                                    positionentity(local108, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                                    turnentity(local108, 90.0, 0.0, 0.0, $00)
                                    entitypick(local108, 0.3)
                                    local109 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                    local109\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                                    entityalpha(local109\Field0, 1.0)
                                    scalesprite(local109\Field0, local109\Field2, local109\Field2)
                                    freeentity(local108)
                                    multiplayer_writedecal(local109, $01, $01)
                                    blurtimer = 800.0
                                Case $05
                                    setmsg("The chicken was not tasty")
                                Case $06
                                    local108 = createpivot($00)
                                    positionentity(local108, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                                    turnentity(local108, 90.0, 0.0, 0.0, $00)
                                    entitypick(local108, 0.3)
                                    local109 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                    local109\Field2 = rnd(0.03, 0.08)
                                    entityalpha(local109\Field0, 1.0)
                                    scalesprite(local109\Field0, local109\Field2, local109\Field2)
                                    freeentity(local108)
                                    multiplayer_writedecal(local109, $01, $01)
                                    setmsg("You bit your tongue")
                                    blurtimer = 200.0
                                Case $07
                                    setmsg("The chicken turned out to be rotten")
                                    vomittimer = 30.0
                            End Select
                            removeitem(selecteditem, $01)
                            selecteditem = Null
                        ElseIf (50.0 < selecteditem\Field13) Then
                            If (rand($190, $01) = $32) Then
                                Select rand($07, $01)
                                    Case $00
                                        setmsg("You feel bad because you have gastritis")
                                        vomittimer = 30.0
                                    Case $02
                                        setmsg("You choked on a chicken and smother")
                                        playsound_strict(coughsfx(rand($00, $02)))
                                        multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                        kill("was killed by chicken", $00)
                                        blurtimer = 2000.0
                                    Case $03
                                        setmsg("You choked on a chicken")
                                        playsound_strict(coughsfx(rand($00, $02)))
                                        multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                        blurtimer = 2000.0
                                    Case $04
                                        setmsg("There were nails in the chicken")
                                        playsound_strict(coughsfx(rand($00, $02)))
                                        multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                        injuries = 30.0
                                        bloodloss = 10.0
                                        local108 = createpivot($00)
                                        positionentity(local108, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                                        turnentity(local108, 90.0, 0.0, 0.0, $00)
                                        entitypick(local108, 0.3)
                                        local109 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                        local109\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                                        entityalpha(local109\Field0, 1.0)
                                        scalesprite(local109\Field0, local109\Field2, local109\Field2)
                                        freeentity(local108)
                                        multiplayer_writedecal(local109, $01, $01)
                                        blurtimer = 800.0
                                    Case $05
                                        setmsg("The chicken was not tasty")
                                    Case $06
                                        local108 = createpivot($00)
                                        positionentity(local108, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                                        turnentity(local108, 90.0, 0.0, 0.0, $00)
                                        entitypick(local108, 0.3)
                                        local109 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                        local109\Field2 = rnd(0.03, 0.08)
                                        entityalpha(local109\Field0, 1.0)
                                        scalesprite(local109\Field0, local109\Field2, local109\Field2)
                                        freeentity(local108)
                                        multiplayer_writedecal(local109, $01, $01)
                                        setmsg("You bit your tongue")
                                        blurtimer = 200.0
                                    Case $07
                                        setmsg("The chicken turned out to be rotten")
                                        vomittimer = 30.0
                                End Select
                                removeitem(selecteditem, $01)
                                selecteditem = Null
                            EndIf
                        EndIf
                    EndIf
                Case "veryfinefirstaid"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        Select rand($05, $01)
                            Case $01
                                injuries = 3.5
                                setmsg("You started bleeding heavily.")
                            Case $02
                                injuries = 0.0
                                bloodloss = 0.0
                                setmsg("Your wounds are healing up rapidly.")
                            Case $03
                                injuries = max(0.0, (injuries - rnd(0.5, 3.5)))
                                bloodloss = max(0.0, (bloodloss - rnd(10.0, 100.0)))
                                setmsg("You feel much better.")
                            Case $04
                                blurtimer = 10000.0
                                bloodloss = 0.0
                                setmsg("You feel nauseated.")
                            Case $05
                                blinktimer = -10.0
                                local112 = playerroom\Field8\Field11
                                If ((((local112 = "dimension1499") Or (local112 = "gatea")) Or ((local112 = "exit1") And (4.0625 < entityy(collider, $00)))) <> 0) Then
                                    injuries = 2.5
                                    setmsg("You started bleeding heavily.")
                                Else
                                    For local113 = Each rooms
                                        If (local113\Field8\Field11 = "pocketdimension") Then
                                            positionentity(collider, entityx(local113\Field3, $00), 0.8, entityz(local113\Field3, $00), $00)
                                            resetentity(collider)
                                            updatedoors()
                                            updaterooms()
                                            playsound_strict(use914sfx)
                                            dropspeed = 0.0
                                            curr106\Field9 = -2500.0
                                            Exit
                                        EndIf
                                    Next
                                    setmsg("For some inexplicable reason, you find yourself inside the pocket dimension.")
                                EndIf
                        End Select
                        myplayer\Field68 = 100.0
                        removeitem(selecteditem, $01)
                    EndIf
                Case "firstaid","finefirstaid","firstaid2"
                    If (((0.0 = bloodloss) And (0.0 = injuries)) <> 0) Then
                        setmsg("You do not need to use a first aid kit right now.")
                        selecteditem = Null
                    ElseIf (canuseitem($00, $01, $01) <> 0) Then
                        currspeed = curvevalue(0.0, currspeed, 5.0)
                        local103 = $01
                        local104 = $01
                        selecteditem\Field15 = min((selecteditem\Field15 + (fpsfactor / 5.0)), 100.0)
                        If (100.0 = selecteditem\Field15) Then
                            selecteditem\Field15 = 0.0
                            If (selecteditem\Field1\Field2 = "finefirstaid") Then
                                bloodloss = 0.0
                                injuries = max(0.0, (injuries - 2.0))
                                If (0.0 = injuries) Then
                                    setmsg("You bandaged the wounds and took a painkiller. You feel fine.")
                                ElseIf (1.0 < injuries) Then
                                    setmsg("You bandaged the wounds and took a painkiller, but you were not able to stop the bleeding.")
                                Else
                                    setmsg("You bandaged the wounds and took a painkiller, but you still feel sore.")
                                EndIf
                                myplayer\Field68 = 100.0
                                removeitem(selecteditem, $01)
                            Else
                                bloodloss = max(0.0, (bloodloss - (Float rand($0A, $14))))
                                If (2.5 <= injuries) Then
                                    setmsg("The wounds were way too severe to staunch the bleeding completely.")
                                    injuries = max(2.5, (injuries - rnd(0.3, 0.7)))
                                ElseIf (1.0 < injuries) Then
                                    injuries = max(0.5, (injuries - rnd(0.5, 1.0)))
                                    If (1.0 < injuries) Then
                                        setmsg("You bandaged the wounds but were unable to staunch the bleeding completely.")
                                    Else
                                        setmsg("You managed to stop the bleeding.")
                                    EndIf
                                ElseIf (0.5 < injuries) Then
                                    injuries = 0.5
                                    setmsg("You took a painkiller, easing the pain slightly.")
                                Else
                                    injuries = 0.5
                                    setmsg("You took a painkiller, but it still hurts to walk.")
                                EndIf
                                If (selecteditem\Field1\Field2 = "firstaid2") Then
                                    Select rand($06, $01)
                                        Case $01
                                            superman = $01
                                            setmsg("You have becomed overwhelmedwithadrenalineholyshitWOOOOOO~!")
                                        Case $02
                                            invertmouse = (invertmouse = $00)
                                            setmsg("You suddenly find it very difficult to turn your head.")
                                        Case $03
                                            blurtimer = 5000.0
                                            setmsg("You feel nauseated.")
                                        Case $04
                                            blinkeffect = 0.6
                                            blinkeffecttimer = (Float rand($14, $1E))
                                        Case $05
                                            bloodloss = 0.0
                                            injuries = 0.0
                                            setmsg("You bandaged the wounds. The bleeding stopped completely and you feel fine.")
                                        Case $06
                                            setmsg("You bandaged the wounds and blood started pouring heavily through the bandages.")
                                            injuries = 3.5
                                    End Select
                                EndIf
                                myplayer\Field68 = 100.0
                                removeitem(selecteditem, $01)
                            EndIf
                        EndIf
                    EndIf
                Case "eyedrops"
                    If (canuseitem($00, $00, $00) <> 0) Then
                        If ((wearing714 = $01) = $00) Then
                            blinkeffect = 0.6
                            blinkeffecttimer = (Float rand($14, $1E))
                            blurtimer = 200.0
                        EndIf
                        removeitem(selecteditem, $01)
                    EndIf
                Case "fineeyedrops"
                    If (canuseitem($00, $00, $00) <> 0) Then
                        If ((wearing714 = $01) = $00) Then
                            blinkeffect = 0.4
                            blinkeffecttimer = (Float rand($1E, $28))
                            bloodloss = max((bloodloss - 1.0), 0.0)
                            blurtimer = 200.0
                        EndIf
                        removeitem(selecteditem, $01)
                    EndIf
                Case "supereyedrops"
                    If (canuseitem($00, $00, $00) <> 0) Then
                        If ((wearing714 = $01) = $00) Then
                            blinkeffect = 0.0
                            blinkeffecttimer = 60.0
                            eyestuck = 10000.0
                        EndIf
                        blurtimer = 1000.0
                        removeitem(selecteditem, $01)
                    EndIf
                Case "paper","ticket"
                    If (selecteditem\Field1\Field12 = $00) Then
                        Select selecteditem\Field1\Field1
                            Case "Burnt Note"
                                selecteditem\Field1\Field12 = loadimage_strict("GFX\items\bn.it")
                                setbuffer(imagebuffer(selecteditem\Field1\Field12, $00))
                                setcolorex($00, $00, $00)
                                setfontex(fonts[$00]\Field0)
                                text($115, $1D5, (Str accesscode), $01, $01)
                                setcolorex($FF, $FF, $FF)
                                setbuffer(backbuffer())
                            Case "Document SCP-372"
                                selecteditem\Field1\Field12 = loadimage_strict(selecteditem\Field1\Field11)
                                selecteditem\Field1\Field12 = resizeimage2(selecteditem\Field1\Field12, (Int ((Float imagewidth(selecteditem\Field1\Field12)) * menuscale)), (Int ((Float imageheight(selecteditem\Field1\Field12)) * menuscale)))
                                setbuffer(imagebuffer(selecteditem\Field1\Field12, $00))
                                setcolorex($25, $2D, $89)
                                setfontex(fonts[$04]\Field0)
                                local21 = ((accesscode * $03) Mod $2710)
                                If (local21 < $3E8) Then
                                    local21 = (local21 + $3E8)
                                EndIf
                                text((Int (383.0 * menuscale)), (Int (734.0 * menuscale)), (Str local21), $01, $01)
                                setcolorex($FF, $FF, $FF)
                                setbuffer(backbuffer())
                            Case "Movie Ticket"
                                selecteditem\Field1\Field12 = loadimage_strict(selecteditem\Field1\Field11)
                                If (0.0 = selecteditem\Field13) Then
                                    setmsg(((chr($22) + "Hey, I remember this movie!") + chr($22)))
                                    playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($01, $05))) + ".ogg")))
                                    selecteditem\Field13 = 1.0
                                EndIf
                            Default
                                selecteditem\Field1\Field12 = loadimage_strict(selecteditem\Field1\Field11)
                                selecteditem\Field1\Field12 = resizeimage2(selecteditem\Field1\Field12, (Int ((Float imagewidth(selecteditem\Field1\Field12)) * menuscale)), (Int ((Float imageheight(selecteditem\Field1\Field12)) * menuscale)))
                        End Select
                        maskimage(selecteditem\Field1\Field12, $FF, $00, $FF)
                    EndIf
                    drawimage(selecteditem\Field1\Field12, (local0 - (imagewidth(selecteditem\Field1\Field12) Shr $01)), (local1 - (imageheight(selecteditem\Field1\Field12) Shr $01)), $00)
                Case "scp1025"
                    giveachievement($18, $01)
                    If (selecteditem\Field1\Field12 = $00) Then
                        selecteditem\Field13 = (Float rand($00, $05))
                        selecteditem\Field1\Field12 = loadimage_strict((("GFX\items\1025\1025_" + (Str (Int selecteditem\Field13))) + ".jpg"))
                        selecteditem\Field1\Field12 = resizeimage2(selecteditem\Field1\Field12, (Int ((Float imagewidth(selecteditem\Field1\Field12)) * menuscale)), (Int ((Float imageheight(selecteditem\Field1\Field12)) * menuscale)))
                        maskimage(selecteditem\Field1\Field12, $FF, $00, $FF)
                    EndIf
                    If (wearing714 = $00) Then
                        scp1025state[(Int selecteditem\Field13)] = max(1.0, scp1025state[(Int selecteditem\Field13)])
                    EndIf
                    drawimage(selecteditem\Field1\Field12, (local0 - (imagewidth(selecteditem\Field1\Field12) Shr $01)), (local1 - (imageheight(selecteditem\Field1\Field12) Shr $01)), $00)
                Case "cup"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        selecteditem\Field0 = trim(lower(selecteditem\Field0))
                        If (left(selecteditem\Field0, (Int min(6.0, (Float len(selecteditem\Field0))))) = "cup of") Then
                            selecteditem\Field0 = right(selecteditem\Field0, (len(selecteditem\Field0) - $07))
                        ElseIf (left(selecteditem\Field0, (Int min(8.0, (Float len(selecteditem\Field0))))) = "a cup of") Then
                            selecteditem\Field0 = right(selecteditem\Field0, (len(selecteditem\Field0) - $09))
                        EndIf
                        local28 = (selecteditem\Field13 + 1.0)
                        local116 = "DATA\SCP-294.ini"
                        local117 = getinisectionlocation(local116, selecteditem\Field0)
                        local34 = getinistring2(local116, local117, "message", "")
                        If (local34 <> "") Then
                            setmsg(local34)
                        EndIf
                        If ((getiniint2(local116, local117, "lethal", "") Or getiniint2(local116, local117, "deathtimer", "")) <> 0) Then
                            deathmsg = getinistring2(local116, local117, "deathmessage", "")
                            If (getiniint2(local116, local117, "lethal", "") <> 0) Then
                                kill("was killed", $00)
                            EndIf
                        EndIf
                        blurtimer = (Float (getiniint2(local116, local117, "blur", "") * $46))
                        If (0.0 = vomittimer) Then
                            vomittimer = (Float getiniint2(local116, local117, "vomit", ""))
                        EndIf
                        camerashaketimer = (Float getinistring2(local116, local117, "camerashake", ""))
                        injuries = max(((Float getiniint2(local116, local117, "damage", "")) + injuries), 0.0)
                        bloodloss = max(((Float getiniint2(local116, local117, "blood loss", "")) + bloodloss), 0.0)
                        local34 = getinistring2(local116, local117, "sound", "")
                        If (local34 <> "") Then
                            playsound_strict(loadtempsound(local34))
                        EndIf
                        If (getiniint2(local116, local117, "stomachache", "") <> 0) Then
                            scp1025state[$03] = 1.0
                        EndIf
                        deathtimer = (Float (getiniint2(local116, local117, "deathtimer", "") * $46))
                        blinkeffect = ((Float getinistring2(local116, local117, "blink effect", "1.0")) * local28)
                        blinkeffecttimer = ((Float getinistring2(local116, local117, "blink effect timer", "1.0")) * local28)
                        staminaeffect = ((Float getinistring2(local116, local117, "stamina effect", "1.0")) * local28)
                        staminaeffecttimer = ((Float getinistring2(local116, local117, "stamina effect timer", "1.0")) * local28)
                        local34 = getinistring2(local116, local117, "refusemessage", "")
                        If (local34 <> "") Then
                            setmsg(local34)
                            msgtimer = 420.0
                        Else
                            local90 = createitem("Empty Cup", "emptycup", 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00, $01)
                            local90\Field16 = $01
                            For local25 = $00 To $09 Step $01
                                If (inventory(local25) = selecteditem) Then
                                    inventory(local25) = local90
                                    Exit
                                EndIf
                            Next
                            entitytype(local90\Field2, $03, $00)
                            removeitem(selecteditem, $01)
                        EndIf
                        selecteditem = Null
                    EndIf
                Case "syringe"
                    If (canuseitem($00, $01, $01) <> 0) Then
                        healtimer = 30.0
                        staminaeffect = 0.5
                        staminaeffecttimer = 20.0
                        setmsg("You injected yourself with the syringe and feel a slight adrenaline rush.")
                        removeitem(selecteditem, $01)
                    EndIf
                Case "finesyringe"
                    If (canuseitem($00, $01, $01) <> 0) Then
                        healtimer = rnd(20.0, 40.0)
                        staminaeffect = rnd(0.5, 0.8)
                        staminaeffecttimer = rnd(20.0, 30.0)
                        setmsg("You injected yourself with the syringe and feel an adrenaline rush.")
                        msgtimer = 560.0
                        removeitem(selecteditem, $01)
                    EndIf
                Case "veryfinesyringe"
                    If (canuseitem($00, $01, $01) <> 0) Then
                        Select rand($03, $01)
                            Case $01
                                healtimer = rnd(40.0, 60.0)
                                staminaeffect = 0.1
                                staminaeffecttimer = 30.0
                                setmsg("You injected yourself with the syringe and feel a huge adrenaline rush.")
                            Case $02
                                superman = $01
                                setmsg("You injected yourself with the syringe and feel a humongous adrenaline rush.")
                            Case $03
                                vomittimer = 30.0
                                setmsg("You injected yourself with the syringe and feel a pain in your stomach.")
                        End Select
                        removeitem(selecteditem, $01)
                    EndIf
                Case "radio","18vradio","fineradio","veryfineradio"
                    If (100.0 >= selecteditem\Field13) Then
                        selecteditem\Field13 = max(0.0, (selecteditem\Field13 - (fpsfactor * 0.004)))
                    EndIf
                    If (selecteditem\Field1\Field12 = $00) Then
                        selecteditem\Field1\Field12 = loadimage_strict(selecteditem\Field1\Field11)
                        maskimage(selecteditem\Field1\Field12, $FF, $00, $FF)
                    EndIf
                    If (0.0 = radiostate($05)) Then
                        setmsg("Use the numbered keys 1 through 9 to cycle between various channels.")
                        msgtimer = 350.0
                        radiostate($05) = 1.0
                        radiostate($00) = -1.0
                    EndIf
                    local34 = ""
                    local22 = (graphicwidth - imagewidth(selecteditem\Field1\Field12))
                    local23 = (graphicheight - imageheight(selecteditem\Field1\Field12))
                    drawimage(selecteditem\Field1\Field12, local22, local23, $00)
                    radiouse = $01
                    If (((local6 = "pocketdimension") Or (4.0 > coffindistance)) <> 0) Then
                        resumechannel(radiochn($05))
                        If (channelplaying(radiochn($05)) = $00) Then
                            radiochn($05) = playsound_strict(radiostatic)
                        EndIf
                    Else
                        myplayer\Field65 = (Int selecteditem\Field14)
                        Select (Int selecteditem\Field14)
                            Case $00
                                resumechannel(radiochn($00))
                                local34 = "        USER TRACK PLAYER - "
                                If (enableusertracks = $00) Then
                                    If (channelplaying(radiochn($00)) = $00) Then
                                        radiochn($00) = playsound_strict(radiostatic)
                                    EndIf
                                    local34 = (local34 + "NOT ENABLED     ")
                                ElseIf (usertrackmusicamount < $01) Then
                                    If (channelplaying(radiochn($00)) = $00) Then
                                        radiochn($00) = playsound_strict(radiostatic)
                                    EndIf
                                    local34 = (local34 + "NO TRACKS FOUND     ")
                                Else
                                    If (channelplaying(radiochn($00)) = $00) Then
                                        If (usertrackflag = $00) Then
                                            If (usertrackmode <> 0) Then
                                                If ((Float (usertrackmusicamount - $01)) > radiostate($00)) Then
                                                    radiostate($00) = (radiostate($00) + 1.0)
                                                Else
                                                    radiostate($00) = 0.0
                                                EndIf
                                                usertrackflag = $01
                                            Else
                                                radiostate($00) = (Float rand($00, (usertrackmusicamount - $01)))
                                            EndIf
                                        EndIf
                                        If (currusertrack <> $00) Then
                                            freesound_strict(currusertrack)
                                            currusertrack = $00
                                        EndIf
                                        currusertrack = loadsound_strict(("SFX\Radio\UserTracks\" + usertrackname((Int radiostate($00)))))
                                        radiochn($00) = playsound_strict(currusertrack)
                                    Else
                                        local34 = ((local34 + upper(usertrackname((Int radiostate($00))))) + "          ")
                                        usertrackflag = $00
                                    EndIf
                                    If (keyhit($02) <> 0) Then
                                        playsound_strict(radiosquelch)
                                        If (usertrackflag = $00) Then
                                            If (usertrackmode <> 0) Then
                                                If ((Float (usertrackmusicamount - $01)) > radiostate($00)) Then
                                                    radiostate($00) = (radiostate($00) + 1.0)
                                                Else
                                                    radiostate($00) = 0.0
                                                EndIf
                                                usertrackflag = $01
                                            Else
                                                radiostate($00) = (Float rand($00, (usertrackmusicamount - $01)))
                                            EndIf
                                        EndIf
                                        If (currusertrack <> $00) Then
                                            freesound_strict(currusertrack)
                                            currusertrack = $00
                                        EndIf
                                        currusertrack = loadsound_strict(("SFX\Radio\UserTracks\" + usertrackname((Int radiostate($00)))))
                                        radiochn($00) = playsound_strict(currusertrack)
                                    EndIf
                                EndIf
                            Case $01
                                resumechannel(radiochn($01))
                                local34 = "        WARNING - CONTAINMENT BREACH          "
                                If (channelplaying(radiochn($01)) = $00) Then
                                    If (5.0 <= radiostate($01)) Then
                                        radiochn($01) = playsound_strict(radiosfx($01, $01))
                                        radiostate($01) = 0.0
                                    Else
                                        radiostate($01) = (radiostate($01) + 1.0)
                                        radiochn($01) = playsound_strict(radiosfx($01, $00))
                                    EndIf
                                EndIf
                            Case $02
                                resumechannel(radiochn($02))
                                local34 = "        SCP Foundation On-Site Radio          "
                                If (channelplaying(radiochn($02)) = $00) Then
                                    radiostate($02) = (radiostate($02) + 1.0)
                                    If (17.0 = radiostate($02)) Then
                                        radiostate($02) = 1.0
                                    EndIf
                                    If (ceil((radiostate($02) / 2.0)) = floor((radiostate($02) / 2.0))) Then
                                        radiochn($02) = playsound_strict(radiosfx($02, (Int (radiostate($02) / 2.0))))
                                    Else
                                        radiochn($02) = playsound_strict(radiosfx($02, $00))
                                    EndIf
                                EndIf
                            Case $03
                                resumechannel(radiochn($03))
                                local34 = "             EMERGENCY CHANNEL - RESERVED FOR COMMUNICATION IN THE EVENT OF A CONTAINMENT BREACH         "
                                If (channelplaying(radiochn($03)) = $00) Then
                                    radiochn($03) = playsound_strict(radiostatic)
                                EndIf
                                If (0.0 < mtftimer) Then
                                    radiostate($03) = (max((Float rand($FFFFFFF6, $01)), 0.0) + radiostate($03))
                                    Select radiostate($03)
                                        Case 40.0
                                            If (radiostate3($00) = $00) Then
                                                radiochn($03) = playsound_strict(loadtempsound("SFX\Character\MTF\Random1.ogg"))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($00) = $01
                                            EndIf
                                        Case 400.0
                                            If (radiostate3($01) = $00) Then
                                                radiochn($03) = playsound_strict(loadtempsound("SFX\Character\MTF\Random2.ogg"))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($01) = $01
                                            EndIf
                                        Case 800.0
                                            If (radiostate3($02) = $00) Then
                                                radiochn($03) = playsound_strict(loadtempsound("SFX\Character\MTF\Random3.ogg"))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($02) = $01
                                            EndIf
                                        Case 1200.0
                                            If (radiostate3($03) = $00) Then
                                                radiochn($03) = playsound_strict(loadtempsound("SFX\Character\MTF\Random4.ogg"))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($03) = $01
                                            EndIf
                                        Case 1600.0
                                            If (radiostate3($04) = $00) Then
                                                radiochn($03) = playsound_strict(loadtempsound("SFX\Character\MTF\Random5.ogg"))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($04) = $01
                                            EndIf
                                        Case 2000.0
                                            If (radiostate3($05) = $00) Then
                                                radiochn($03) = playsound_strict(loadtempsound("SFX\Character\MTF\Random6.ogg"))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($05) = $01
                                            EndIf
                                        Case 2400.0
                                            If (radiostate3($06) = $00) Then
                                                radiochn($03) = playsound_strict(loadtempsound("SFX\Character\MTF\Random7.ogg"))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($06) = $01
                                            EndIf
                                    End Select
                                EndIf
                            Case $04
                                resumechannel(radiochn($06))
                                If (channelplaying(radiochn($06)) = $00) Then
                                    radiochn($06) = playsound_strict(radiostatic)
                                EndIf
                                resumechannel(radiochn($04))
                                If (channelplaying(radiochn($04)) = $00) Then
                                    If (((remotedooron = $00) And (0.0 = radiostate($08))) <> 0) Then
                                        radiochn($04) = playsound_strict(loadtempsound("SFX\radio\Chatter3.ogg"))
                                        radiostate($08) = 1.0
                                    Else
                                        radiostate($04) = (max((Float rand($FFFFFFF6, $01)), 0.0) + radiostate($04))
                                        Select radiostate($04)
                                            Case 10.0
                                                If (contained106 = $00) Then
                                                    If (radiostate4($00) = $00) Then
                                                        radiochn($04) = playsound_strict(loadtempsound("SFX\radio\OhGod.ogg"))
                                                        radiostate($04) = (radiostate($04) + 1.0)
                                                        radiostate4($00) = $01
                                                    EndIf
                                                EndIf
                                            Case 100.0
                                                If (radiostate4($01) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\radio\Chatter2.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($01) = $01
                                                EndIf
                                            Case 158.0
                                                If (((0.0 = mtftimer) And (radiostate4($02) = $00)) <> 0) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\radio\franklin1.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate($02) = 1.0
                                                EndIf
                                            Case 200.0
                                                If (radiostate4($03) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\radio\Chatter4.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($03) = $01
                                                EndIf
                                            Case 260.0
                                                If (radiostate4($04) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\SCP\035\RadioHelp1.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($04) = $01
                                                EndIf
                                            Case 300.0
                                                If (radiostate4($05) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\radio\Chatter1.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($05) = $01
                                                EndIf
                                            Case 350.0
                                                If (radiostate4($06) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\radio\franklin2.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($06) = $01
                                                EndIf
                                            Case 400.0
                                                If (radiostate4($07) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\SCP\035\RadioHelp2.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($07) = $01
                                                EndIf
                                            Case 450.0
                                                If (radiostate4($08) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\radio\franklin3.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($08) = $01
                                                EndIf
                                            Case 600.0
                                                If (radiostate4($09) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound("SFX\radio\franklin4.ogg"))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($09) = $01
                                                EndIf
                                        End Select
                                    EndIf
                                EndIf
                        End Select
                        local22 = (local22 + $42)
                        local23 = (local23 + $1A3)
                        setcolorex($1E, $1E, $1E)
                        If (100.0 >= selecteditem\Field13) Then
                            For local25 = $00 To $04 Step $01
                                rect(local22, ((local25 Shl $03) + local23), ($2B - (local25 * $06)), $04, ((Float ($04 - local25)) < ceil((selecteditem\Field13 * 0.2))))
                            Next
                        EndIf
                        setfontex(fonts[$02]\Field0)
                        text((local22 + $3C), local23, "CHN", $00, $00)
                        If (selecteditem\Field1\Field2 = "veryfineradio") Then
                            resumechannel(radiochn($00))
                            If (channelplaying(radiochn($00)) = $00) Then
                                radiochn($00) = playsound_strict(radiostatic)
                            EndIf
                            radiostate($06) = (radiostate($06) + fpsfactor)
                            local21 = (Int mid((Str accesscode), (Int (radiostate($08) + 1.0)), $01))
                            If ((((radiostate($07) * 50.0) >= (radiostate($06) - fpsfactor)) And (radiostate($06) > (radiostate($07) * 50.0))) <> 0) Then
                                playsound_strict(radiobuzz)
                                radiostate($07) = (radiostate($07) + 1.0)
                                If ((Float local21) <= radiostate($07)) Then
                                    radiostate($07) = 0.0
                                    radiostate($06) = -100.0
                                    radiostate($08) = (radiostate($08) + 1.0)
                                    If (4.0 = radiostate($08)) Then
                                        radiostate($08) = 0.0
                                        radiostate($06) = -200.0
                                    EndIf
                                EndIf
                            EndIf
                            local34 = ""
                            For local25 = $00 To rand($05, $1E) Step $01
                                local34 = (local34 + chr(rand($01, $64)))
                            Next
                            setfontex(fonts[$03]\Field0)
                            text((local22 + $61), (local23 + $10), (Str rand($00, $09)), $01, $01)
                        Else
                            For local25 = $02 To $0A Step $01
                                If (keyhit(local25) <> 0) Then
                                    If ((Float (local25 - $02)) <> selecteditem\Field14) Then
                                        playsound_strict(radiosquelch)
                                        If (radiochn((Int selecteditem\Field14)) <> $00) Then
                                            pausechannel(radiochn((Int selecteditem\Field14)))
                                        EndIf
                                    EndIf
                                    selecteditem\Field14 = (Float (local25 - $02))
                                    If (radiochn((Int selecteditem\Field14)) <> $00) Then
                                        resumechannel(radiochn((Int selecteditem\Field14)))
                                    EndIf
                                EndIf
                            Next
                            setfontex(fonts[$03]\Field0)
                            text((local22 + $61), (local23 + $10), (Str (Int (selecteditem\Field14 + 1.0))), $01, $01)
                        EndIf
                        If (local34 <> "") Then
                            setfontex(fonts[$02]\Field0)
                            local34 = right(left(local34, ((millisecs() / $12C) Mod len(local34))), $0A)
                            text((local22 + $20), (local23 + $21), local34, $00, $00)
                        EndIf
                        setfontex(fonts[$00]\Field0)
                    EndIf
                Case "cigarette"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        If (0.0 = selecteditem\Field13) Then
                            Select rand($06, $01)
                                Case $01
                                    setmsg(((chr($22) + "I don't have anything to light it with. Umm, what about that... Nevermind.") + chr($22)))
                                Case $02
                                    setmsg("You are unable to get lit.")
                                Case $03
                                    setmsg(((chr($22) + "I quit that a long time ago.") + chr($22)))
                                    removeitem(selecteditem, $01)
                                Case $04
                                    setmsg(((chr($22) + "Even if I wanted one, I have nothing to light it with.") + chr($22)))
                                Case $05
                                    setmsg(((chr($22) + "Could really go for one now... Wish I had a lighter.") + chr($22)))
                                Case $06
                                    setmsg(((chr($22) + "Don't plan on starting, even at a time like this.") + chr($22)))
                                    removeitem(selecteditem, $01)
                            End Select
                            selecteditem\Field13 = 1.0
                        Else
                            local103 = $01
                            setmsg("You are unable to get lit.")
                        EndIf
                    EndIf
                Case "420"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        If (wearing714 = $01) Then
                            setmsg(((chr($22) + "DUDE WTF THIS SHIT DOESN'T EVEN WORK") + chr($22)))
                        Else
                            setmsg(((chr($22) + "MAN DATS SUM GOOD ASS SHIT") + chr($22)))
                            injuries = max((injuries - 0.5), 0.0)
                            blurtimer = 500.0
                            giveachievement($0C, $01)
                            playsound_strict(loadtempsound("SFX\Music\420J.ogg"))
                            multiplayer_writetempsound("SFX\Music\420J.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 20.0, 1.0)
                        EndIf
                        removeitem(selecteditem, $01)
                    EndIf
                Case "urancandy"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        setmsg("There's something wrong with your stomach.")
                        vomittimer = 70.0
                        removeitem(selecteditem, $01)
                    EndIf
                Case "420s"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        If (wearing714 = $01) Then
                            setmsg(((chr($22) + "DUDE WTF THIS SHIT DOESN'T EVEN WORK") + chr($22)))
                        Else
                            deathmsg = "Subject D-9341 found in a comatose state in [DATA REDACTED]. The subject was holding what appears to be a cigarette while smiling widely. "
                            deathmsg = (deathmsg + "Chemical analysis of the cigarette has been inconclusive, although it seems to contain a high concentration of an unidentified chemical ")
                            deathmsg = (deathmsg + "whose molecular structure is remarkably similar to that of tetrahydrocannabinol.")
                            setmsg(((chr($22) + "UH WHERE... WHAT WAS I DOING AGAIN... MAN I NEED TO TAKE A NAP...") + chr($22)))
                            kill("was killed by SCP-420", $01)
                        EndIf
                        removeitem(selecteditem, $01)
                    EndIf
                Case "scp714"
                    local103 = $01
                    local104 = $01
                    selecteditem\Field15 = min((selecteditem\Field15 + (fpsfactor * 4.0)), 100.0)
                    If (100.0 = selecteditem\Field15) Then
                        selecteditem\Field15 = 0.0
                        If (wearing714 = $01) Then
                            setmsg("You removed the ring.")
                            wearing714 = $00
                        Else
                            giveachievement($10, $01)
                            setmsg("You put on the ring.")
                            wearing714 = $01
                        EndIf
                        selecteditem = Null
                    EndIf
                Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
                    If (wearingvest = $00) Then
                        currspeed = curvevalue(0.0, currspeed, 7.0)
                        local103 = $01
                        local104 = $01
                        selecteditem\Field15 = min((selecteditem\Field15 + fpsfactor), 100.0)
                        If (100.0 = selecteditem\Field15) Then
                            selecteditem\Field15 = 0.0
                            If (wearinghazmat > $00) Then
                                setmsg("You removed the hazmat suit.")
                                wearinghazmat = $00
                                dropitem(selecteditem, $01)
                            Else
                                If (selecteditem\Field1\Field2 = "hazmatsuit") Then
                                    wearinghazmat = $01
                                ElseIf (selecteditem\Field1\Field2 = "hazmatsuit2") Then
                                    wearinghazmat = $02
                                Else
                                    wearinghazmat = $03
                                EndIf
                                If (selecteditem\Field1\Field3 <> $42) Then
                                    playsound_strict(picksfx(selecteditem\Field1\Field3))
                                EndIf
                                setmsg("You put on the hazmat suit.")
                                If (wearingnightvision <> 0) Then
                                    camerafogfar = storedcamerafogfar
                                EndIf
                                wearinggasmask = $00
                                wearingnightvision = $00
                            EndIf
                            selecteditem = Null
                        EndIf
                    EndIf
                Case "vest","finevest"
                    currspeed = curvevalue(0.0, currspeed, 7.0)
                    local103 = $01
                    local104 = $01
                    selecteditem\Field15 = min((selecteditem\Field15 + (fpsfactor / (((Float (selecteditem\Field1\Field2 = "finevest")) * 0.5) + 2.0))), 100.0)
                    If (100.0 = selecteditem\Field15) Then
                        selecteditem\Field15 = 0.0
                        If (wearingvest > $00) Then
                            setmsg("You removed the vest.")
                            wearingvest = $00
                            dropitem(selecteditem, $01)
                        Else
                            If (selecteditem\Field1\Field2 = "vest") Then
                                setmsg("You put on the vest and feel slightly encumbered.")
                                wearingvest = $01
                            Else
                                setmsg("You put on the vest and feel heavily encumbered.")
                                wearingvest = $02
                            EndIf
                            If (selecteditem\Field1\Field3 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field1\Field3))
                            EndIf
                        EndIf
                        selecteditem = Null
                    EndIf
                Case "gasmask","supergasmask","gasmask3"
                    local103 = $01
                    local104 = $01
                    selecteditem\Field15 = min((selecteditem\Field15 + (fpsfactor * 2.0)), 100.0)
                    If (100.0 = selecteditem\Field15) Then
                        selecteditem\Field15 = 0.0
                        If (((wearing1499 = $00) And (wearinghazmat = $00)) <> 0) Then
                            If (wearinggasmask <> 0) Then
                                setmsg("You removed the gas mask.")
                            Else
                                If (selecteditem\Field1\Field2 = "supergasmask") Then
                                    setmsg("You put on the gas mask and you can breathe easier.")
                                Else
                                    setmsg("You put on the gas mask.")
                                EndIf
                                If (wearingnightvision <> 0) Then
                                    camerafogfar = storedcamerafogfar
                                EndIf
                                wearingnightvision = $00
                                wearinggasmask = $00
                            EndIf
                            If (selecteditem\Field1\Field2 = "gasmask3") Then
                                If (wearinggasmask = $00) Then
                                    wearinggasmask = $03
                                Else
                                    wearinggasmask = $00
                                EndIf
                            ElseIf (selecteditem\Field1\Field2 = "supergasmask") Then
                                If (wearinggasmask = $00) Then
                                    wearinggasmask = $02
                                Else
                                    wearinggasmask = $00
                                EndIf
                            Else
                                wearinggasmask = (wearinggasmask = $00)
                            EndIf
                        ElseIf (wearing1499 > $00) Then
                            setmsg("You need to take off SCP-1499 in order to put on the gas mask.")
                        Else
                            setmsg("You need to take off the hazmat suit in order to put on the gas mask.")
                        EndIf
                        selecteditem = Null
                    EndIf
                Case "navigator","nav"
                    If (selecteditem\Field1\Field1 = "S-NAV Navigator Ultimate") Then
                        selecteditem\Field13 = 101.0
                    EndIf
                    If (selecteditem\Field1\Field12 = $00) Then
                        selecteditem\Field1\Field12 = loadimage_strict(selecteditem\Field1\Field11)
                        maskimage(selecteditem\Field1\Field12, $FF, $00, $FF)
                    EndIf
                    If (100.0 >= selecteditem\Field13) Then
                        selecteditem\Field13 = max(0.0, (selecteditem\Field13 - (fpsfactor * 0.005)))
                    EndIf
                    local22 = (Int (((Float graphicwidth) - ((Float imagewidth(selecteditem\Field1\Field12)) * 0.5)) + 20.0))
                    local23 = (Int (((Float graphicheight) - ((Float imageheight(selecteditem\Field1\Field12)) * 0.4)) - 85.0))
                    local82 = $11F
                    local83 = $100
                    local72 = $8F
                    local73 = $80
                    drawimage(selecteditem\Field1\Field12, (local22 - (imagewidth(selecteditem\Field1\Field12) Shr $01)), ((local23 - (imageheight(selecteditem\Field1\Field12) Shr $01)) + $55), $00)
                    setfontex(fonts[$02]\Field0)
                    local123 = $01
                    If (((playerroom\Field8\Field11 = "pocketdimension") Or (playerroom\Field8\Field11 = "dimension1499")) <> 0) Then
                        local123 = $00
                    ElseIf (playerroom\Field8\Field11 = "room860") Then
                        If (1.0 = room860event\Field2) Then
                            local123 = $00
                        EndIf
                    EndIf
                    If (local123 = $00) Then
                        If ((millisecs() Mod $3E8) > $12C) Then
                            setcolorraw($C80000)
                            text(local22, ((local23 + local73) - $50), "ERROR 06", $01, $00)
                            text(local22, ((local23 + local73) - $3C), "LOCATION UNKNOWN", $01, $00)
                        EndIf
                    ElseIf (((1.0 < rnd((coffindistance + 15.0), 0.0)) Or (playerroom\Field8\Field11 <> "coffin")) <> 0) Then
                        local124 = (Int floor((((entityx(playerroom\Field3, $00) + 8.0) * 0.125) + 0.5)))
                        local125 = (Int floor((((entityz(playerroom\Field3, $00) + 8.0) * 0.125) + 0.5)))
                        local126 = (local22 - (imagewidth(selecteditem\Field1\Field12) Shr $01))
                        local127 = ((local23 - (imageheight(selecteditem\Field1\Field12) Shr $01)) + $55)
                        drawimage(selecteditem\Field1\Field12, local126, local127, $00)
                        local22 = (Int (((((entityx(collider, $00) - 4.0) + 8.0) Mod 8.0) * 3.0) + (Float (local22 - $0C))))
                        local23 = (Int ((Float (local23 + $0C)) - ((((entityz(collider, $00) - 4.0) + 8.0) Mod 8.0) * 3.0)))
                        local128 = (local126 + $50)
                        local129 = (local127 + $46)
                        local130 = $10E
                        local131 = $E6
                        For local28 = max(0.0, (Float (local124 - $06))) To min((Float mapwidth), (Float (local124 + $06))) Step 1.0
                            For local30 = max(0.0, (Float (local125 - $06))) To min((Float mapheight), (Float (local125 + $06))) Step 1.0
                                If (((16.0 < coffindistance) Or (coffindistance > rnd(16.0, 0.0))) <> 0) Then
                                    If (((maptemp((Int local28), (Int local30)) > $00) And (((mapfound((Int local28), (Int local30)) > $00) Or (selecteditem\Field1\Field1 = "S-NAV 310 Navigator")) Or (selecteditem\Field1\Field1 = "S-NAV Navigator Ultimate"))) <> 0) Then
                                        local132 = (Int ((((Float (local124 - $01)) - local28) * 24.0) + (Float local22)))
                                        local133 = (Int ((Float local23) - (((Float (local125 - $01)) - local30) * 24.0)))
                                        local134 = $FFFFFFFF
                                        If ((Float mapwidth) >= (local28 + 1.0)) Then
                                            If (maptemp((Int (local28 + 1.0)), (Int local30)) = $00) Then
                                                local134 = navimages($03)
                                            EndIf
                                        Else
                                            local134 = navimages($03)
                                        EndIf
                                        If (local134 > $FFFFFFFF) Then
                                            local135 = (local132 - $0C)
                                            local136 = (local133 - $0C)
                                            local137 = $00
                                            local138 = $00
                                            local139 = imagewidth(local134)
                                            local140 = imageheight(local134)
                                            If (local135 < local128) Then
                                                local137 = (local128 - local135)
                                                local139 = (local139 - local137)
                                                local135 = local128
                                            EndIf
                                            If (local136 < local129) Then
                                                local138 = (local129 - local136)
                                                local140 = (local140 - local138)
                                                local136 = local129
                                            EndIf
                                            If ((local135 + local139) > (local128 + local130)) Then
                                                local139 = ((local128 + local130) - local135)
                                            EndIf
                                            If ((local136 + local140) > (local129 + local131)) Then
                                                local140 = ((local129 + local131) - local136)
                                            EndIf
                                            If (((local139 > $00) And (local140 > $00)) <> 0) Then
                                                drawimagerect(local134, local135, local136, local137, local138, local139, local140, $00)
                                            EndIf
                                        EndIf
                                        local134 = $FFFFFFFF
                                        If (0.0 <= (local28 - 1.0)) Then
                                            If (maptemp((Int (local28 - 1.0)), (Int local30)) = $00) Then
                                                local134 = navimages($01)
                                            EndIf
                                        Else
                                            local134 = navimages($01)
                                        EndIf
                                        If (local134 > $FFFFFFFF) Then
                                            local135 = (local132 - $0C)
                                            local136 = (local133 - $0C)
                                            local137 = $00
                                            local138 = $00
                                            local139 = imagewidth(local134)
                                            local140 = imageheight(local134)
                                            If (local135 < local128) Then
                                                local137 = (local128 - local135)
                                                local139 = (local139 - local137)
                                                local135 = local128
                                            EndIf
                                            If (local136 < local129) Then
                                                local138 = (local129 - local136)
                                                local140 = (local140 - local138)
                                                local136 = local129
                                            EndIf
                                            If ((local135 + local139) > (local128 + local130)) Then
                                                local139 = ((local128 + local130) - local135)
                                            EndIf
                                            If ((local136 + local140) > (local129 + local131)) Then
                                                local140 = ((local129 + local131) - local136)
                                            EndIf
                                            If (((local139 > $00) And (local140 > $00)) <> 0) Then
                                                drawimagerect(local134, local135, local136, local137, local138, local139, local140, $00)
                                            EndIf
                                        EndIf
                                        local134 = $FFFFFFFF
                                        If (0.0 <= (local30 - 1.0)) Then
                                            If (maptemp((Int local28), (Int (local30 - 1.0))) = $00) Then
                                                local134 = navimages($00)
                                            EndIf
                                        Else
                                            local134 = navimages($00)
                                        EndIf
                                        If (local134 > $FFFFFFFF) Then
                                            local135 = (local132 - $0C)
                                            local136 = (local133 - $0C)
                                            local137 = $00
                                            local138 = $00
                                            local139 = imagewidth(local134)
                                            local140 = imageheight(local134)
                                            If (local135 < local128) Then
                                                local137 = (local128 - local135)
                                                local139 = (local139 - local137)
                                                local135 = local128
                                            EndIf
                                            If (local136 < local129) Then
                                                local138 = (local129 - local136)
                                                local140 = (local140 - local138)
                                                local136 = local129
                                            EndIf
                                            If ((local135 + local139) > (local128 + local130)) Then
                                                local139 = ((local128 + local130) - local135)
                                            EndIf
                                            If ((local136 + local140) > (local129 + local131)) Then
                                                local140 = ((local129 + local131) - local136)
                                            EndIf
                                            If (((local139 > $00) And (local140 > $00)) <> 0) Then
                                                drawimagerect(local134, local135, local136, local137, local138, local139, local140, $00)
                                            EndIf
                                        EndIf
                                        local134 = $FFFFFFFF
                                        If ((Float mapheight) >= (local30 + 1.0)) Then
                                            If (maptemp((Int local28), (Int (local30 + 1.0))) = $00) Then
                                                local134 = navimages($02)
                                            EndIf
                                        Else
                                            local134 = navimages($02)
                                        EndIf
                                        If (local134 > $FFFFFFFF) Then
                                            local135 = (local132 - $0C)
                                            local136 = (local133 - $0C)
                                            local137 = $00
                                            local138 = $00
                                            local139 = imagewidth(local134)
                                            local140 = imageheight(local134)
                                            If (local135 < local128) Then
                                                local137 = (local128 - local135)
                                                local139 = (local139 - local137)
                                                local135 = local128
                                            EndIf
                                            If (local136 < local129) Then
                                                local138 = (local129 - local136)
                                                local140 = (local140 - local138)
                                                local136 = local129
                                            EndIf
                                            If ((local135 + local139) > (local128 + local130)) Then
                                                local139 = ((local128 + local130) - local135)
                                            EndIf
                                            If ((local136 + local140) > (local129 + local131)) Then
                                                local140 = ((local129 + local131) - local136)
                                            EndIf
                                            If (((local139 > $00) And (local140 > $00)) <> 0) Then
                                                drawimagerect(local134, local135, local136, local137, local138, local139, local140, $00)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        setcolorraw($1E1E1E)
                        If (selecteditem\Field1\Field1 = "S-NAV Navigator") Then
                            setcolorraw($640000)
                        EndIf
                        rect((local126 + $50), (local127 + $46), $10E, $E6, $00)
                        local22 = (Int (((Float graphicwidth) - ((Float imagewidth(selecteditem\Field1\Field12)) * 0.5)) + 20.0))
                        local23 = (Int (((Float graphicheight) - ((Float imageheight(selecteditem\Field1\Field12)) * 0.4)) - 85.0))
                        If (selecteditem\Field1\Field1 = "S-NAV Navigator") Then
                            setcolorraw($640000)
                        Else
                            setcolorraw($1E1E1E)
                        EndIf
                        If ((millisecs() Mod $3E8) > $12C) Then
                            If (((selecteditem\Field1\Field1 <> "S-NAV 310 Navigator") And (selecteditem\Field1\Field1 <> "S-NAV Navigator Ultimate")) <> 0) Then
                                text(((local22 - local72) + $0A), ((local23 - local73) + $0A), "MAP DATABASE OFFLINE", $00, $00)
                            EndIf
                            If (((((local22 >= local128) And (local22 <= (local128 + local130))) And (local23 >= local129)) And (local23 <= (local129 + local131))) <> 0) Then
                                rect((local22 - $06), (local23 - $06), $0C, $0C, $01)
                            EndIf
                        EndIf
                        local141 = $00
                        If (((selecteditem\Field1\Field1 = "S-NAV Navigator Ultimate") And ((millisecs() Mod $258) < $190)) <> 0) Then
                            If (networkserver\Field12 = $00) Then
                                If (curr173 <> Null) Then
                                    local142 = entitydistancesquared(camera, curr173\Field0)
                                    If (64.0 >= local142) Then
                                        local142 = 8.0
                                    ElseIf (256.0 >= local142) Then
                                        local142 = 16.0
                                    ElseIf (576.0 >= local142) Then
                                        local142 = 24.0
                                    Else
                                        local142 = 32.0
                                    EndIf
                                    If (1024.0 > local142) Then
                                        setcolorraw($640000)
                                        oval((Int ((Float local22) - (local142 * 3.0))), (Int ((Float (local23 - $07)) - (local142 * 3.0))), (Int ((local142 * 3.0) * 2.0)), (Int ((local142 * 3.0) * 2.0)), $00)
                                        text(((local22 - local72) + $0A), ((local23 - local73) + $1E), "SCP-173", $00, $00)
                                        local141 = (local141 + $01)
                                    EndIf
                                EndIf
                                If (curr106 <> Null) Then
                                    local142 = entitydistancesquared(camera, curr106\Field0)
                                    If (64.0 >= local142) Then
                                        local142 = 8.0
                                    ElseIf (256.0 >= local142) Then
                                        local142 = 16.0
                                    ElseIf (576.0 >= local142) Then
                                        local142 = 24.0
                                    Else
                                        local142 = 32.0
                                    EndIf
                                    If (1024.0 > local142) Then
                                        setcolorraw($640000)
                                        oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                        text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-106", $00, $00)
                                        local141 = (local141 + $01)
                                    EndIf
                                EndIf
                                If (curr096 <> Null) Then
                                    local142 = entitydistancesquared(camera, curr096\Field0)
                                    If (64.0 >= local142) Then
                                        local142 = 8.0
                                    ElseIf (256.0 >= local142) Then
                                        local142 = 16.0
                                    ElseIf (576.0 >= local142) Then
                                        local142 = 24.0
                                    Else
                                        local142 = 32.0
                                    EndIf
                                    If (1024.0 > local142) Then
                                        setcolorraw($640000)
                                        oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                        text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-096", $00, $00)
                                        local141 = (local141 + $01)
                                    EndIf
                                EndIf
                                For local143 = Each npcs
                                    If (local143\Field5 = $0A) Then
                                        If (local143\Field68 = $00) Then
                                            local142 = entitydistancesquared(camera, local143\Field0)
                                            If (64.0 >= local142) Then
                                                local142 = 8.0
                                            ElseIf (256.0 >= local142) Then
                                                local142 = 16.0
                                            ElseIf (576.0 >= local142) Then
                                                local142 = 24.0
                                            Else
                                                local142 = 32.0
                                            EndIf
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-049", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            ElseIf (networkserver\Field12 <> 0) Then
                                For local144 = Each players
                                    Select local144\Field49
                                        Case model_049
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-049", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                        Case model_939
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-939", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                        Case model_173
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            local142 = (ceil((local142 * 0.125)) * 8.0)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 3.0))), (Int ((Float (local23 - $07)) - (local142 * 3.0))), (Int ((local142 * 3.0) * 2.0)), (Int ((local142 * 3.0) * 2.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-173", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                        Case model_106
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-106", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                        Case model_966
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-966", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                        Case model_zombie
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-049-A", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                        Case model_096
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-096", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                        Case model_860
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-860", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                        Case model_035
                                            local142 = entitydistancesquared(camera, local144\Field12)
                                            If (1024.0 > local142) Then
                                                setcolorraw($640000)
                                                oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                                text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-035", $00, $00)
                                                local141 = (local141 + $01)
                                            EndIf
                                    End Select
                                Next
                            EndIf
                            If (playerroom\Field8\Field11 = "coffin") Then
                                If (8.0 > coffindistance) Then
                                    local142 = rnd(4.0, 8.0)
                                    setcolorraw($640000)
                                    oval((Int ((Float local22) - (local142 * 1.5))), (Int ((Float (local23 - $07)) - (local142 * 1.5))), (Int (local142 * 3.0)), (Int (local142 * 3.0)), $00)
                                    text(((local22 - local72) + $0A), (((local23 - local73) + $1E) + ($14 * local141)), "SCP-895", $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        setcolorraw($1E1E1E)
                        If (selecteditem\Field1\Field1 = "S-NAV Navigator") Then
                            setcolorraw($640000)
                        EndIf
                        If (100.0 >= selecteditem\Field13) Then
                            local32 = ((local22 - local72) + $C4)
                            local33 = ((local23 - local73) + $0A)
                            rect(local32, local33, $50, $14, $00)
                            For local25 = $01 To (Int ceil((selecteditem\Field13 * 0.1))) Step $01
                                drawblock(navimages($04), (((local25 Shl $03) + local32) - $06), (local33 + $04), $00)
                            Next
                            setfontex(fonts[$02]\Field0)
                        EndIf
                    EndIf
                Case "scp1499","super1499"
                    If (wearinghazmat > $00) Then
                        setmsg("You are not able to wear SCP-1499 and a hazmat suit at the same time.")
                        selecteditem = Null
                        Return $00
                    EndIf
                    currspeed = curvevalue(0.0, currspeed, 7.0)
                    local103 = $01
                    local104 = $01
                    selecteditem\Field15 = min((selecteditem\Field15 + fpsfactor), 100.0)
                    If (100.0 = selecteditem\Field15) Then
                        selecteditem\Field15 = 0.0
                        If (wearing1499 > $00) Then
                            wearing1499 = $00
                            If (selecteditem\Field1\Field3 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field1\Field3))
                            EndIf
                            For local113 = Each rooms
                                If (local113 = ntf_1499prevroom) Then
                                    blinktimer = -1.0
                                    ntf_1499x = local3
                                    ntf_1499y = local4
                                    ntf_1499z = local5
                                    positionentity(collider, ntf_1499prevx, (ntf_1499prevy + 0.01), ntf_1499prevz, $00)
                                    resetentity(collider)
                                    playerroom = local113
                                    updatedoors()
                                    updaterooms()
                                    If (playerroom\Field8\Field11 = "room3storage") Then
                                        If (-17.96875 > entityy(collider, $00)) Then
                                            For local25 = $00 To $02 Step $01
                                                playerroom\Field32[local25]\Field9 = 2.0
                                                positionentity(playerroom\Field32[local25]\Field4, entityx(playerroom\Field25[(Int playerroom\Field32[local25]\Field10)], $01), (entityy(playerroom\Field25[(Int playerroom\Field32[local25]\Field10)], $01) + 0.2), entityz(playerroom\Field25[(Int playerroom\Field32[local25]\Field10)], $01), $00)
                                                resetentity(playerroom\Field32[local25]\Field4)
                                                playerroom\Field32[local25]\Field10 = (playerroom\Field32[local25]\Field10 + 1.0)
                                                If ((Float playerroom\Field32[local25]\Field12) < playerroom\Field32[local25]\Field10) Then
                                                    playerroom\Field32[local25]\Field10 = (Float (playerroom\Field32[local25]\Field12 - $03))
                                                EndIf
                                            Next
                                        EndIf
                                    ElseIf (playerroom\Field8\Field11 = "pocketdimension") Then
                                        camerafogcolor(camera, 0.0, 0.0, 0.0)
                                        cameraclscolor(camera, 0.0, 0.0, 0.0, 1.0)
                                    EndIf
                                    For local147 = Each rooms
                                        If (local147\Field8\Field11 = "dimension1499") Then
                                            local146 = local147
                                            Exit
                                        EndIf
                                    Next
                                    For local90 = Each items
                                        local90\Field12 = 0.0
                                        If (((local90\Field1\Field2 = "scp1499") Or (local90\Field1\Field2 = "super1499")) <> 0) Then
                                            If ((entityy(local146\Field3, $00) - 5.0) <= entityy(local90\Field2, $00)) Then
                                                positionentity(local90\Field2, ntf_1499prevx, ((entityy(local90\Field2, $00) - entityy(local146\Field3, $00)) + ntf_1499prevy), ntf_1499prevz, $00)
                                                resetentity(local90\Field2)
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    local146 = Null
                                    shouldentitiesfall = $00
                                    playsound_strict(ntf_1499leavesfx)
                                    ntf_1499prevx = 0.0
                                    ntf_1499prevy = 0.0
                                    ntf_1499prevz = 0.0
                                    ntf_1499prevroom = Null
                                    executeconsolecommand("tfd", $01, $01)
                                    Exit
                                EndIf
                            Next
                        Else
                            If (selecteditem\Field1\Field2 = "scp1499") Then
                                wearing1499 = $01
                            Else
                                wearing1499 = $02
                            EndIf
                            If (selecteditem\Field1\Field3 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field1\Field3))
                            EndIf
                            giveachievement($23, $01)
                            If (wearingnightvision <> 0) Then
                                camerafogfar = storedcamerafogfar
                            EndIf
                            wearinggasmask = $00
                            wearingnightvision = $00
                            If (multiplayer_isfullsync() <> 0) Then
                                executeconsolecommand("teleport dimension1499", $01, $01)
                            EndIf
                            For local113 = Each rooms
                                If (local113\Field8\Field11 = "dimension1499") Then
                                    blinktimer = -1.0
                                    ntf_1499prevroom = playerroom
                                    ntf_1499prevx = entityx(collider, $00)
                                    ntf_1499prevy = entityy(collider, $00)
                                    ntf_1499prevz = entityz(collider, $00)
                                    If ((((0.0 = ntf_1499x) And (0.0 = ntf_1499y)) And (0.0 = ntf_1499z)) <> 0) Then
                                        positionentity(collider, (local113\Field4 + 23.77344), (local113\Field5 + 1.1875), (local113\Field6 + 8.955078), $00)
                                        rotateentity(collider, 0.0, 90.0, 0.0, $01)
                                    Else
                                        positionentity(collider, ntf_1499x, (ntf_1499y + 0.05), ntf_1499z, $00)
                                    EndIf
                                    resetentity(collider)
                                    updatedoors()
                                    updaterooms()
                                    For local90 = Each items
                                        local90\Field12 = 0.0
                                    Next
                                    playerroom = local113
                                    playsound_strict(ntf_1499entersfx)
                                    ntf_1499x = 0.0
                                    ntf_1499y = 0.0
                                    ntf_1499z = 0.0
                                    If (curr096 <> Null) Then
                                        If (curr096\Field17 <> $00) Then
                                            setstreamvolume_strict(curr096\Field17, 0.0)
                                        EndIf
                                    EndIf
                                    For local45 = Each events
                                        If (local45\Field0 = "dimension1499") Then
                                            If (32.42188 < entitydistance(local45\Field1\Field3, collider)) Then
                                                If (5.0 > local45\Field3) Then
                                                    local45\Field3 = (local45\Field3 + 1.0)
                                                EndIf
                                            EndIf
                                            Exit
                                        EndIf
                                    Next
                                    Exit
                                EndIf
                            Next
                        EndIf
                        selecteditem = Null
                    EndIf
                Case "badge"
                    If (selecteditem\Field1\Field12 = $00) Then
                        selecteditem\Field1\Field12 = loadimage_strict(selecteditem\Field1\Field11)
                        maskimage(selecteditem\Field1\Field12, $FF, $00, $FF)
                    EndIf
                    drawimage(selecteditem\Field1\Field12, (local0 - (imagewidth(selecteditem\Field1\Field12) Shr $01)), (local1 - (imageheight(selecteditem\Field1\Field12) Shr $01)), $00)
                    If (0.0 = selecteditem\Field13) Then
                        playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg")))
                        local148 = selecteditem\Field1\Field1
                        If (local148 = "Old Badge") Then
                            setmsg(((chr($22) + "Huh? This guy looks just like me!") + chr($22)))
                        EndIf
                        selecteditem\Field13 = 1.0
                    EndIf
                Case "key"
                    If (0.0 = selecteditem\Field13) Then
                        playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg")))
                        setmsg(((chr($22) + "Isn't this the key to that old shack? The one where I...") + chr($22)))
                    EndIf
                    selecteditem\Field13 = 1.0
                    selecteditem = Null
                Case "oldpaper"
                    If (selecteditem\Field1\Field12 = $00) Then
                        selecteditem\Field1\Field12 = loadimage_strict(selecteditem\Field1\Field11)
                        selecteditem\Field1\Field12 = resizeimage2(selecteditem\Field1\Field12, (Int ((Float imagewidth(selecteditem\Field1\Field12)) * menuscale)), (Int ((Float imageheight(selecteditem\Field1\Field12)) * menuscale)))
                        maskimage(selecteditem\Field1\Field12, $FF, $00, $FF)
                    EndIf
                    drawimage(selecteditem\Field1\Field12, (local0 - (imagewidth(selecteditem\Field1\Field12) Shr $01)), (local1 - (imageheight(selecteditem\Field1\Field12) Shr $01)), $00)
                    If (0.0 = selecteditem\Field13) Then
                        local149 = selecteditem\Field1\Field1
                        If (local149 = "Disciplinary Hearing DH-S-4137-17092") Then
                            blurtimer = 1000.0
                            setmsg(((chr($22) + "Why does this seem so familiar?") + chr($22)))
                            playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg")))
                            selecteditem\Field13 = 1.0
                        EndIf
                    EndIf
                Case "coin"
                    If (0.0 = selecteditem\Field13) Then
                        playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($01, $05))) + ".ogg")))
                    EndIf
                    setmsg("")
                    selecteditem\Field13 = 1.0
                    local103 = $01
                Case "scp427"
                    If (i_427\Field0 = $01) Then
                        setmsg("You closed the locket.")
                        i_427\Field0 = $00
                    Else
                        giveachievement($0D, $01)
                        setmsg("You opened the locket.")
                        i_427\Field0 = $01
                    EndIf
                    selecteditem = Null
                Case "pill"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        setmsg("You swallowed the pill.")
                        removeitem(selecteditem, $01)
                        selecteditem = Null
                    EndIf
                Case "scp500death"
                    If (canuseitem($00, $00, $01) <> 0) Then
                        setmsg("You swallowed the pill.")
                        If (25200.0 > i_427\Field1) Then
                            i_427\Field1 = 25200.0
                        EndIf
                        removeitem(selecteditem, $01)
                        selecteditem = Null
                    EndIf
                Default
                    If (getscripts() <> 0) Then
                        public_inqueue($16, $00)
                        public_addparam((Str selecteditem\Field19), $01)
                        callback()
                    EndIf
                    doubleclick = $00
                    mousehit1 = $00
                    mousedown1 = $00
                    lastmousehit1 = $00
                    If (selecteditem\Field20 > $00) Then
                        otheropen = selecteditem
                    EndIf
                    selecteditem = Null
            End Select
        EndIf
        If (selecteditem <> Null) Then
            If (local103 <> 0) Then
                local150 = (local0 - imenuscale[$20])
                local151 = (local1 - (imenuscale[$20] - imenuscale[$FA]))
                drawblock(selecteditem\Field1\Field8, local150, local151, $00)
            EndIf
            If (local104 <> 0) Then
                local82 = imenuscale[$12C]
                local83 = imenuscale[$0E]
                local152 = f_clamp(selecteditem\Field15, 0.0, 100.0)
                local153 = (Int ((local152 * 0.01) * (Float local82)))
                local22 = (local0 - (local82 Shr $01))
                local23 = (imenuscale[$12C] + local1)
                rect((local22 - imenuscale[$02]), (local23 - imenuscale[$02]), (imenuscale[$04] + local82), (imenuscale[$04] + local83), $00)
                If (local153 > $00) Then
                    If (blinkbar <> $00) Then
                        drawblockrect(blinkbar, local22, local23, $00, $00, local153, imenuscale[$0E], $00)
                    EndIf
                EndIf
            EndIf
            If (selecteditem\Field1\Field12 <> $00) Then
                local154 = selecteditem\Field1\Field2
                If (((((local154 = "paper") Or (local154 = "badge")) Or (local154 = "oldpaper")) Or (local154 = "ticket")) <> 0) Then
                    For local155 = Each items
                        If (local155 <> selecteditem) Then
                            local156 = local155\Field1\Field2
                            If (((((local156 = "paper") Or (local156 = "badge")) Or (local156 = "oldpaper")) Or (local156 = "ticket")) <> 0) Then
                                If (local155\Field1\Field12 <> $00) Then
                                    If (local155\Field1\Field12 <> selecteditem\Field1\Field12) Then
                                        freeimage(local155\Field1\Field12)
                                        local155\Field1\Field12 = $00
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                EndIf
            EndIf
        EndIf
        If (mousehit2 <> 0) Then
            If (selecteditem <> Null) Then
                entityalpha(dark, 0.0)
                local154 = selecteditem\Field1\Field2
                If (local154 = "scp1025") Then
                    If (selecteditem\Field1\Field12 <> $00) Then
                        freeimage(selecteditem\Field1\Field12)
                    EndIf
                    selecteditem\Field1\Field12 = $00
                ElseIf ((((((local154 = "firstaid") Or (local154 = "finefirstaid")) Or (local154 = "firstaid2")) Or (local154 = "chicken")) Or (local154 = "boxofammo")) <> 0) Then
                    selecteditem\Field13 = 0.0
                ElseIf (((local154 = "vest") Or (local154 = "finevest")) <> 0) Then
                    selecteditem\Field13 = 0.0
                    If (wearingvest = $00) Then
                        dropitem(selecteditem, $00)
                    EndIf
                ElseIf ((((local154 = "hazmatsuit") Or (local154 = "hazmatsuit2")) Or (local154 = "hazmatsuit3")) <> 0) Then
                    selecteditem\Field13 = 0.0
                    If (wearinghazmat = $00) Then
                        dropitem(selecteditem, $00)
                    EndIf
                ElseIf (((local154 = "scp1499") Or (local154 = "super1499")) <> 0) Then
                    selecteditem\Field13 = 0.0
                EndIf
                If (selecteditem\Field1\Field3 <> $42) Then
                    playsound_strict(picksfx(selecteditem\Field1\Field3))
                EndIf
                selecteditem\Field15 = 0.0
                selecteditem = Null
            EndIf
        EndIf
    EndIf
    If (selecteditem = Null) Then
        For local25 = $00 To $06 Step $01
            If (radiochn(local25) <> $00) Then
                If (channelplaying(radiochn(local25)) <> 0) Then
                    pausechannel(radiochn(local25))
                EndIf
            EndIf
        Next
    EndIf
    If (stated = $00) Then
        For local90 = Each items
            If (local90 <> selecteditem) Then
                Select local90\Field1\Field2
                    Case "firstaid","finefirstaid","firstaid2","vest","finevest","hazmatsuit","hazmatsuit2","hazmatsuit3","scp1499","super1499","chicken","boxofammo"
                        local90\Field13 = 0.0
                End Select
            EndIf
        Next
        stated = $01
    EndIf
    If ((local50 And (invopen = $00)) <> 0) Then
        movemouse(local0, local1)
    EndIf
    Return $00
End Function
