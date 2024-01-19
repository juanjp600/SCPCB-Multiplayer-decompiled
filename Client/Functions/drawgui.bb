Function drawgui%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10%
    Local local11%
    Local local12%
    Local local13$
    Local local14.events
    Local local15.items
    Local local16%
    Local local17%
    Local local18$
    Local local20%
    Local local21%
    Local local22%
    Local local23.events
    Local local24%
    Local local25.npcs
    Local local26%
    Local local27.chunk
    Local local28%
    Local local29%
    Local local30%
    Local local31%
    Local local32#
    Local local33#
    Local local35%
    Local local36.items
    Local local37%
    Local local38%
    Local local39%
    Local local40%
    Local local41%
    Local local42%
    Local local43$
    Local local45$
    Local local46%
    Local local50.items
    Local local51$
    Local local52$
    Local local53%
    Local local54%
    Local local57$
    Local local61.guns
    Local local63.decals
    Local local66$
    Local local67.rooms
    Local local70$
    Local local71%
    Local local77%
    Local local78%
    Local local79%
    Local local80%
    Local local81%
    Local local82%
    Local local83%
    Local local84%
    Local local85%
    Local local86%
    Local local87%
    Local local88%
    Local local89#
    Local local90.npcs
    Local local91.rooms
    Local local92.rooms
    Local local93$
    Local local94$
    Local local95$
    Local local96.items
    Local local97$
    If (lockmouse = $00) Then
        If ((((((((menuopen Or consoleopen) Or (selecteddoor <> Null)) Or invopen) Or (otheropen <> Null)) Or (0.0 > endingtimer)) Or (tab_menu_state > $01)) Or networkserver\Field27) <> 0) Then
            showpointer()
        Else
            hidepointer()
        EndIf
    EndIf
    If (playerintercom\Field3 <> 0) Then
        aasetfont(font1)
        local16 = (((playerintercom\Field1 - millisecs()) / $3E8) Mod $3C)
        local17 = (((playerintercom\Field1 - millisecs()) / $EA60) Mod $3C)
        If (myplayer\Field52 <> 0) Then
            local16 = (((playerintercom\Field0 - millisecs()) / $3E8) Mod $3C)
            local17 = (((playerintercom\Field0 - millisecs()) / $EA60) Mod $3C)
            local18 = (Str local16)
            If (local16 < $0A) Then
                local18 = ("0" + (Str local16))
            EndIf
            aatext(((graphicwidth Sar $01) - $32), ((graphicheight Sar $01) + $64), (((("YOU CAN SPEAKING (left: " + (Str local17)) + ":") + local18) + ")"), $00, $00, 1.0)
        ElseIf (((playerintercom\Field1 > millisecs()) And ((local16 + local17) <> $00)) <> 0) Then
            local16 = (((playerintercom\Field1 - millisecs()) / $3E8) Mod $3C)
            local17 = (((playerintercom\Field1 - millisecs()) / $EA60) Mod $3C)
            local18 = (Str local16)
            If (local16 < $0A) Then
                local18 = ("0" + (Str local16))
            EndIf
            aatext(((graphicwidth Sar $01) - $32), ((graphicheight Sar $01) + $64), ((("YOU CAN SPEAK IN " + (Str local17)) + ":") + local18), $00, $00, 1.0)
        Else
            aatext(((graphicwidth Sar $01) - $32), ((graphicheight Sar $01) + $64), "PRESS LMB TO ENABLE", $00, $00, 1.0)
        EndIf
    ElseIf (playerroom <> Null) Then
        If (myplayer\Field52 <> 0) Then
            If ((((3.0 > distance3((playerroom\Field3 - (265.0 * roomscale)), (playerroom\Field4 + (1280.0 * roomscale)), (playerroom\Field5 + (105.0 * roomscale)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))) = $00) Or ((playerroom\Field7\Field11 = "room2ccont") = $00)) <> 0) Then
                useintercom()
            EndIf
        EndIf
    EndIf
    If (playerroom\Field7\Field11 = "pocketdimension") Then
        For local14 = Each events
            If (local14\Field1 = playerroom) Then
                If (1000.0 > (Float local14\Field11)) Then
                    If (600.0 < local14\Field2) Then
                        If (((-3.0 > blinktimer) And (-10.0 < blinktimer)) <> 0) Then
                            If (local14\Field12 = $00) Then
                                If (((-5.0 < blinktimer) And (rand($1E, $01) = $01)) <> 0) Then
                                    playsound_strict(dripsfx($00))
                                    If (local14\Field12 = $00) Then
                                        local14\Field12 = loadimage_strict("GFX\npcs\106face.jpg")
                                    EndIf
                                EndIf
                            Else
                                drawimage(local14\Field12, ((graphicwidth Sar $01) - rand($186, $136)), ((graphicheight Sar $01) - rand($122, $136)), $00)
                            EndIf
                        ElseIf (local14\Field12 <> $00) Then
                            freeimage(local14\Field12)
                            local14\Field12 = $00
                        EndIf
                        Exit
                    EndIf
                Else
                    If (((-3.0 > blinktimer) And (-10.0 < blinktimer)) <> 0) Then
                        If (local14\Field12 = $00) Then
                            If (-5.0 < blinktimer) Then
                                If (local14\Field12 = $00) Then
                                    local14\Field12 = loadimage_strict("GFX\kneelmortal.pd")
                                    If (channelplaying(local14\Field5) <> 0) Then
                                        stopchannel(local14\Field5)
                                    EndIf
                                    local14\Field5 = playsound_strict(local14\Field7)
                                EndIf
                            EndIf
                        Else
                            drawimage(local14\Field12, ((graphicwidth Sar $01) - rand($186, $136)), ((graphicheight Sar $01) - rand($122, $136)), $00)
                        EndIf
                    Else
                        If (local14\Field12 <> $00) Then
                            freeimage(local14\Field12)
                            local14\Field12 = $00
                        EndIf
                        If (-3.0 > blinktimer) Then
                            If (channelplaying(local14\Field5) = $00) Then
                                local14\Field5 = playsound_strict(local14\Field7)
                            EndIf
                        ElseIf (channelplaying(local14\Field5) <> 0) Then
                            stopchannel(local14\Field5)
                        EndIf
                    EndIf
                    Exit
                EndIf
            EndIf
        Next
    EndIf
    If (eqquipedgun <> Null) Then
        drawgungui()
    EndIf
    If (spectate\Field1 = $FFFFFFFF) Then
        If ((((((closestbutton <> $00) And (selecteddoor = Null)) And (invopen = $00)) And (menuopen = $00)) And (otheropen = Null)) <> 0) Then
            local0 = createpivot($00)
            positionentity(local0, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
            pointentity(local0, closestbutton, 0.0)
            local5 = wrapangle((entityyaw(camera, $00) - entityyaw(local0, $00)))
            If (((90.0 < local5) And (180.0 >= local5)) <> 0) Then
                local5 = 90.0
            EndIf
            If (((180.0 < local5) And (270.0 > local5)) <> 0) Then
                local5 = 270.0
            EndIf
            local6 = wrapangle((entitypitch(camera, $00) - entitypitch(local0, $00)))
            If (((90.0 < local6) And (180.0 >= local6)) <> 0) Then
                local6 = 90.0
            EndIf
            If (((180.0 < local6) And (270.0 > local6)) <> 0) Then
                local6 = 270.0
            EndIf
            freeentity(local0)
            drawimage(handicon, (Int ((((Float (graphicwidth / $03)) * sin(local5)) + (Float (graphicwidth Sar $01))) - 32.0)), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local6))) - 32.0)), $00)
            If (ismouseup() <> 0) Then
                If (closestdoor <> Null) Then
                    If (closestdoor\Field17 <> "") Then
                        selecteddoor = closestdoor
                    ElseIf (playable <> 0) Then
                        playsound2(buttonsfx, camera, closestbutton, 10.0, 1.0)
                        multiplayer_writesound(buttonsfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                        mouseup1 = $00
                        If ((usedoor(closestdoor, $01, $01, $01, "", $00) And (closestdoor\Field23 = $00)) <> 0) Then
                            startmillisecs($00, $3E8)
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (closestitem <> Null) Then
            local5 = (- deltayaw(camera, closestitem\Field1))
            If (((90.0 < local5) And (180.0 >= local5)) <> 0) Then
                local5 = 90.0
            EndIf
            If (((180.0 < local5) And (270.0 > local5)) <> 0) Then
                local5 = 270.0
            EndIf
            local6 = (- deltapitch(camera, closestitem\Field1))
            If (((90.0 < local6) And (180.0 >= local6)) <> 0) Then
                local6 = 90.0
            EndIf
            If (((180.0 < local6) And (270.0 > local6)) <> 0) Then
                local6 = 270.0
            EndIf
            color($FF, $FF, $FF)
            aasetfont(font1)
            aatext((Int (((Float (graphicwidth / $03)) * sin(local5)) + (Float (graphicwidth Sar $01)))), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local6))) - 70.0)), closestitem\Field0, $01, $00, 1.0)
            drawimage(handicon2, (Int ((((Float (graphicwidth / $03)) * sin(local5)) + (Float (graphicwidth Sar $01))) - 32.0)), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local6))) - 32.0)), $00)
        EndIf
        If (drawhandicon <> 0) Then
            drawimage(handicon, ((graphicwidth Sar $01) - $20), ((graphicheight Sar $01) - $20), $00)
        EndIf
        For local4 = $00 To $03 Step $01
            If (drawarrowicon(local4) <> 0) Then
                local1 = ((graphicwidth Sar $01) - $20)
                local2 = ((graphicheight Sar $01) - $20)
                Select local4
                    Case $00
                        local2 = ((local2 - $40) - $05)
                    Case $01
                        local1 = ((local1 + $40) + $05)
                    Case $02
                        local2 = ((local2 + $40) + $05)
                    Case $03
                        local1 = ((local1 - $05) - $40)
                End Select
                drawimage(handicon, local1, local2, $00)
                color($00, $00, $00)
                rect((local1 + $04), (local2 + $04), $38, $38, $01)
                drawimage(arrowimg(local4), (local1 + $15), (local2 + $15), $00)
                drawarrowicon(local4) = $00
            EndIf
        Next
        If (using294 <> 0) Then
            use294()
        EndIf
        If (hudenabled <> 0) Then
            local20 = $CC
            local21 = $14
            local1 = $50
            local2 = (graphicheight - $5F)
            color($FF, $FF, $FF)
            rect(local1, local2, local20, local21, $00)
            local22 = (Int (((blinktimer / blinkfreq) * (Float (local20 - $02))) / 10.0))
            For local4 = $01 To local22 Step $01
                drawimage(blinkmeterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
            Next
            color($00, $00, $00)
            rect((local1 - $32), local2, $1E, $1E, $01)
            If (0.0 < eyeirritation) Then
                color($C8, $00, $00)
                rect(((local1 - $32) - $03), (local2 - $03), $24, $24, $01)
            EndIf
            color($FF, $FF, $FF)
            rect(((local1 - $32) - $01), (local2 - $01), $20, $20, $00)
            drawimage(blinkicon, (local1 - $32), local2, $00)
            local2 = (graphicheight - $37)
            color($FF, $FF, $FF)
            rect(local1, local2, local20, local21, $00)
            local22 = (Int (((stamina / 100.0) * (Float (local20 - $02))) / 10.0))
            For local4 = $01 To local22 Step $01
                drawimage(staminameterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
            Next
            color($00, $00, $00)
            rect((local1 - $32), local2, $1E, $1E, $01)
            color($FF, $FF, $FF)
            rect(((local1 - $32) - $01), (local2 - $01), $20, $20, $00)
            If (crouch <> 0) Then
                drawimage(crouchicon, (local1 - $32), local2, $00)
            Else
                drawimage(sprinticon, (local1 - $32), local2, $00)
            EndIf
            If (debughud <> 0) Then
                color($FF, $FF, $FF)
                aasetfont(consolefont)
                aatext((local1 - $32), $32, (((((("Player Position: (" + f2s(entityx(collider, $00), $03)) + ", ") + f2s(entityy(collider, $00), $03)) + ", ") + f2s(entityz(collider, $00), $03)) + ")"), $00, $00, 1.0)
                aatext((local1 - $32), $46, (((((("Camera Position: (" + f2s(entityx(camera, $00), $03)) + ", ") + f2s(entityy(camera, $00), $03)) + ", ") + f2s(entityz(camera, $00), $03)) + ")"), $00, $00, 1.0)
                aatext((local1 - $32), $64, (((((("Player Rotation: (" + f2s(entitypitch(collider, $00), $03)) + ", ") + f2s(entityyaw(collider, $00), $03)) + ", ") + f2s(entityroll(collider, $00), $03)) + ")"), $00, $00, 1.0)
                aatext((local1 - $32), $78, (((((("Camera Rotation: (" + f2s(entitypitch(camera, $00), $03)) + ", ") + f2s(entityyaw(camera, $00), $03)) + ", ") + f2s(entityroll(camera, $00), $03)) + ")"), $00, $00, 1.0)
                aatext((local1 - $32), $96, ("Room: " + playerroom\Field7\Field11), $00, $00, 1.0)
                For local23 = Each events
                    If (local23\Field1 = playerroom) Then
                        aatext((local1 - $32), $AA, ("Room event: " + local23\Field0), $00, $00, 1.0)
                        aatext((local1 - $32), $BE, ("state: " + (Str local23\Field2)), $00, $00, 1.0)
                        aatext((local1 - $32), $D2, ("state2: " + (Str local23\Field3)), $00, $00, 1.0)
                        aatext((local1 - $32), $E6, ("state3: " + (Str local23\Field4)), $00, $00, 1.0)
                        aatext((local1 - $32), $FA, ("str: " + local23\Field11), $00, $00, 1.0)
                        Exit
                    EndIf
                Next
                aatext((local1 - $32), $118, (((((("Room coordinates: (" + (Str floor(((entityx(playerroom\Field2, $00) / 8.0) + 0.5)))) + ", ") + (Str floor(((entityz(playerroom\Field2, $00) / 8.0) + 0.5)))) + ", angle: ") + (Str playerroom\Field6)) + ")"), $00, $00, 1.0)
                aatext((local1 - $32), $12C, ("Stamina: " + f2s(stamina, $03)), $00, $00, 1.0)
                aatext((local1 - $32), $140, ("Death timer: " + f2s(killtimer, $03)), $00, $00, 1.0)
                aatext((local1 - $32), $154, ("Blink timer: " + f2s(blinktimer, $03)), $00, $00, 1.0)
                aatext((local1 - $32), $168, ("Injuries: " + (Str injuries)), $00, $00, 1.0)
                aatext((local1 - $32), $17C, ((((("PREV_PLAYER_MOVE: " + (Str prev_player_move)) + " | PLAYER_MOVE : ") + (Str player_move)) + " | PLAYER_MOVE_TIMED: ") + (Str player_move_timed)), $00, $00, 1.0)
                If (curr173 <> Null) Then
                    aatext((local1 - $32), $19A, (((((("SCP - 173 Position (collider): (" + f2s(entityx(curr173\Field4, $00), $03)) + ", ") + f2s(entityy(curr173\Field4, $00), $03)) + ", ") + f2s(entityz(curr173\Field4, $00), $03)) + ")"), $00, $00, 1.0)
                    aatext((local1 - $32), $1AE, (((((("SCP - 173 Position (obj): (" + f2s(entityx(curr173\Field0, $00), $03)) + ", ") + f2s(entityy(curr173\Field0, $00), $03)) + ", ") + f2s(entityz(curr173\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                    aatext((local1 - $32), $1C2, ("SCP - 173 State: " + (Str curr173\Field9)), $00, $00, 1.0)
                EndIf
                If (curr106 <> Null) Then
                    aatext((local1 - $32), $1D6, (((((("SCP - 106 Position: (" + f2s(entityx(curr106\Field0, $00), $03)) + ", ") + f2s(entityy(curr106\Field0, $00), $03)) + ", ") + f2s(entityz(curr106\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                    aatext((local1 - $32), $1EA, ("SCP - 106 Idle: " + (Str curr106\Field24)), $00, $00, 1.0)
                    aatext((local1 - $32), $1FE, ("SCP - 106 State: " + (Str curr106\Field9)), $00, $00, 1.0)
                EndIf
                local24 = $00
                For local25 = Each npcs
                    If (local25\Field5 = $09) Then
                        aatext((local1 - $32), $212, (((((("SCP - 096 Position: (" + f2s(entityx(local25\Field0, $00), $03)) + ", ") + f2s(entityy(local25\Field0, $00), $03)) + ", ") + f2s(entityz(local25\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                        aatext((local1 - $32), $226, ("SCP - 096 Idle: " + (Str local25\Field24)), $00, $00, 1.0)
                        aatext((local1 - $32), $23A, ("SCP - 096 State: " + (Str local25\Field9)), $00, $00, 1.0)
                        aatext((local1 - $32), $24E, ("SCP - 096 Speed: " + f2s(local25\Field22, $05)), $00, $00, 1.0)
                    EndIf
                    If (local25\Field5 = $08) Then
                        aatext((local1 - $32), (($3C * local24) + $26C), (((((((("MTF " + (Str local24)) + " Position: (") + f2s(entityx(local25\Field0, $00), $03)) + ", ") + f2s(entityy(local25\Field0, $00), $03)) + ", ") + f2s(entityz(local25\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                        aatext((local1 - $32), (($3C * local24) + $280), ((("MTF " + (Str local24)) + " State: ") + (Str local25\Field9)), $00, $00, 1.0)
                        aatext((local1 - $32), (($3C * local24) + $294), ((("MTF " + (Str local24)) + " LastSeen: ") + (Str local25\Field26)), $00, $00, 1.0)
                        local24 = (local24 + $01)
                    EndIf
                Next
                If (playerroom\Field7\Field11 = "dimension1499") Then
                    aatext((local1 + $15E), $32, (((("Current Chunk X/Z: (" + (Str (Int ((entityx(collider, $00) + 20.0) / 40.0)))) + ", ") + (Str (Int ((entityz(collider, $00) + 20.0) / 40.0)))) + ")"), $00, $00, 1.0)
                    local26 = $00
                    For local27 = Each chunk
                        local26 = (local26 + $01)
                    Next
                    aatext((local1 + $15E), $46, ("Current Chunk Amount: " + (Str local26)), $00, $00, 1.0)
                Else
                    aatext((local1 + $15E), $32, (((((("Current Room Position: (" + (Str playerroom\Field3)) + ", ") + (Str playerroom\Field4)) + ", ") + (Str playerroom\Field5)) + ")"), $00, $00, 1.0)
                EndIf
                globalmemorystatus(m)
                aatext((local1 + $15E), $5A, ((((((((Str ((m\Field3 Sar $0A) Sar $0A)) + " MB/") + (Str ((m\Field2 Sar $0A) Sar $0A))) + " MB (") + (Str (m\Field3 Sar $0A))) + " KB/") + (Str (m\Field2 Sar $0A))) + " KB)"), $00, $00, 1.0)
                aatext((local1 + $15E), $6E, ("Triangles rendered: " + (Str currtrisamount)), $00, $00, 1.0)
                aatext((local1 + $15E), $82, ("Active textures: " + (Str activetextures())), $00, $00, 1.0)
                aatext((local1 + $15E), $96, ("SCP-427 state (secs): " + (Str (Int (i_427\Field1 / 70.0)))), $00, $00, 1.0)
                aatext((local1 + $15E), $AA, ("SCP-008 infection: " + (Str infect)), $00, $00, 1.0)
                For local4 = $00 To $05 Step $01
                    aatext((local1 + $15E), (($14 * local4) + $BE), ((("SCP-1025 State " + (Str local4)) + ": ") + (Str scp1025state[local4])), $00, $00, 1.0)
                Next
                If (selectedmonitor <> Null) Then
                    aatext((local1 + $15E), $136, ("Current monitor: " + (Str selectedmonitor\Field4)), $00, $00, 1.0)
                Else
                    aatext((local1 + $15E), $136, "Current monitor: NULL", $00, $00, 1.0)
                EndIf
                aatext((local1 + $15E), $14A, ("Received (KB): " + (Str udp_network\Field4)), $00, $00, 1.0)
                aatext((local1 + $15E), $15E, ("Writed (KB): " + (Str udp_network\Field5)), $00, $00, 1.0)
                aasetfont(font1)
            EndIf
        EndIf
        If (selectedscreen <> Null) Then
            drawimage(selectedscreen\Field2, ((graphicwidth Sar $01) - (imagewidth(selectedscreen\Field2) Sar $01)), ((graphicheight Sar $01) - (imageheight(selectedscreen\Field2) Sar $01)), $00)
            If ((ismouseup() Or mousehit2) <> 0) Then
                selectedscreen = Null
                mouseup1 = $00
            EndIf
        EndIf
        local28 = invopen
        local29 = $42
        local30 = $01
        If (selecteddoor <> Null) Then
            selecteditem = Null
            If (local30 <> 0) Then
                local31 = createpivot($00)
                positionentity(local31, entityx(closestbutton, $01), entityy(closestbutton, $01), entityz(closestbutton, $01), $00)
                rotateentity(local31, 0.0, (entityyaw(closestbutton, $01) - 180.0), 0.0, $00)
                moveentity(local31, 0.0, 0.0, 0.22)
                positionentity(camera, entityx(local31, $00), entityy(local31, $00), entityz(local31, $00), $00)
                pointentity(camera, closestbutton, 0.0)
                freeentity(local31)
                cameraproject(camera, entityx(closestbutton, $01), (entityy(closestbutton, $01) + (meshheight(buttonobj) * 0.015)), entityz(closestbutton, $01))
                local32 = projectedy()
                cameraproject(camera, entityx(closestbutton, $01), (entityy(closestbutton, $01) - (meshheight(buttonobj) * 0.015)), entityz(closestbutton, $01))
                local33 = ((projectedy() - local32) / 462.0)
                local1 = (Int ((Float (graphicwidth Sar $01)) - (((Float imagewidth(keypadhud)) * local33) / 2.0)))
                local2 = (Int ((Float (graphicheight Sar $01)) - (((Float imageheight(keypadhud)) * local33) / 2.0)))
                aasetfont(font3)
                If (keypadmsg <> "") Then
                    keypadtimer = (keypadtimer - fpsfactor2)
                    If (35.0 > (keypadtimer Mod 70.0)) Then
                        aatext((graphicwidth Sar $01), (Int ((124.0 * local33) + (Float local2))), keypadmsg, $01, $01, 1.0)
                    EndIf
                    If (0.0 >= keypadtimer) Then
                        keypadmsg = ""
                        selecteddoor = Null
                        resetmouse()
                    EndIf
                Else
                    aatext((graphicwidth Sar $01), (Int ((70.0 * local33) + (Float local2))), "ACCESS CODE: ", $01, $01, 1.0)
                    aasetfont(font4)
                    aatext((graphicwidth Sar $01), (Int ((124.0 * local33) + (Float local2))), keypadinput, $01, $01, 1.0)
                EndIf
                local1 = (Int ((44.0 * local33) + (Float local1)))
                local2 = (Int ((249.0 * local33) + (Float local2)))
                For local10 = $00 To $03 Step $01
                    For local4 = $00 To $02 Step $01
                        local11 = ((Int ((58.5 * local33) * (Float local10))) + local1)
                        local12 = (Int (((67.0 * local33) * (Float local4)) + (Float local2)))
                        local0 = $00
                        If ((mouseon(local11, local12, (Int (54.0 * local33)), (Int (65.0 * local33))) And (keypadmsg = "")) <> 0) Then
                            If (mouseup1 <> 0) Then
                                playsound_strict(buttonsfx)
                                multiplayer_writesound(buttonsfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                                Select ((local10 + $01) + (local4 Shl $02))
                                    Case $01,$02,$03
                                        keypadinput = (keypadinput + (Str ((local10 + $01) + (local4 Shl $02))))
                                    Case $04
                                        keypadinput = (keypadinput + "0")
                                    Case $05,$06,$07
                                        keypadinput = (keypadinput + (Str (((local10 + $01) + (local4 Shl $02)) - $01)))
                                    Case $08
                                        If (selecteddoor\Field38 <> 0) Then
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
                                        keypadinput = (keypadinput + (Str (((local10 + $01) + (local4 Shl $02)) - $02)))
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
                            local0 = $00
                        EndIf
                    Next
                Next
                If (fullscreen <> 0) Then
                    drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
                EndIf
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
            If ((instr(selecteditem\Field3\Field2, "vest", $01) Or instr(selecteditem\Field3\Field2, "hazmatsuit", $01)) <> 0) Then
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
        If (playerroom\Field7\Field11 = "gatea") Then
            If (iscoopmode() <> 0) Then
                hideentity(fog)
                camerafogrange(camera, 5.0, 30.0)
                camerafogcolor(camera, 200.0, 200.0, 200.0)
                cameraclscolor(camera, 200.0, 200.0, 200.0)
                camerarange(camera, 0.05, 50.0)
            Else
                camerafogcolor(camera, 0.0, 0.0, 0.0)
                cameraclscolor(camera, 0.0, 0.0, 0.0)
            EndIf
        ElseIf (((playerroom\Field7\Field11 = "exit1") And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
            If (iscoopmode() <> 0) Then
                hideentity(fog)
                camerafogrange(camera, 5.0, 45.0)
                camerafogcolor(camera, 200.0, 200.0, 200.0)
                cameraclscolor(camera, 200.0, 200.0, 200.0)
                camerarange(camera, 0.05, 60.0)
            Else
                camerafogcolor(camera, 0.0, 0.0, 0.0)
                cameraclscolor(camera, 0.0, 0.0, 0.0)
            EndIf
        EndIf
        local36 = otheropen
        local37 = otheropen\Field19
        For local4 = $00 To (local37 - $01) Step $01
            If (otheropen\Field17[local4] <> Null) Then
                local38 = (local38 + $01)
            EndIf
        Next
        invopen = $00
        selecteddoor = Null
        local42 = $00
        local20 = $46
        local21 = $46
        local35 = $23
        local1 = ((graphicwidth Sar $01) - ((((local20 * $0A) Sar $01) + (local35 Shl $02)) Sar $01))
        local2 = ((graphicheight Sar $01) - ((((local21 * local37) / $05) + (((local37 / $05) - $01) * local21)) Sar $01))
        itemamount = $00
        For local10 = $00 To (local37 - $01) Step $01
            local40 = $00
            If (((scaledmousex() > local1) And (scaledmousex() < (local1 + local20))) <> 0) Then
                If (((scaledmousey() > local2) And (scaledmousey() < (local2 + local21))) <> 0) Then
                    local40 = $01
                EndIf
            EndIf
            If (local40 <> 0) Then
                local29 = local10
                color($FF, $00, $00)
                rect((local1 - $01), (local2 - $01), (local20 + $02), (local21 + $02), $01)
            EndIf
            drawframe(local1, local2, local20, local21, (local1 Mod $40), (local1 Mod $40))
            If (otheropen = Null) Then
                Exit
            EndIf
            If (otheropen\Field17[local10] <> Null) Then
                If (((selecteditem <> otheropen\Field17[local10]) Or local40) <> 0) Then
                    drawimage(otheropen\Field17[local10]\Field16, (((local20 Sar $01) + local1) - $20), (((local21 Sar $01) + local2) - $20), $00)
                EndIf
            EndIf
            debuglog(("otheropen: " + (Str (otheropen <> Null))))
            If (((otheropen\Field17[local10] <> Null) And (selecteditem <> otheropen\Field17[local10])) <> 0) Then
                If (local40 <> 0) Then
                    aasetfont(font1)
                    color($00, $00, $00)
                    aatext((((local20 Sar $01) + local1) + $01), ((((local2 + local21) + local35) - $0F) + $01), otheropen\Field17[local10]\Field3\Field1, $01, $00, 1.0)
                    color($FF, $FF, $FF)
                    aatext(((local20 Sar $01) + local1), (((local2 + local21) + local35) - $0F), otheropen\Field17[local10]\Field3\Field1, $01, $00, 1.0)
                    If (selecteditem = Null) Then
                        If (mousehit1 <> 0) Then
                            selecteditem = otheropen\Field17[local10]
                            mousehit1 = $00
                            If (doubleclick <> 0) Then
                                If (otheropen\Field17[local10]\Field3\Field3 <> $42) Then
                                    playsound_strict(picksfx(otheropen\Field17[local10]\Field3\Field3))
                                EndIf
                                otheropen = Null
                                local41 = $01
                                invopen = $00
                                doubleclick = $00
                                blockguns = $01
                            EndIf
                        EndIf
                    EndIf
                EndIf
                itemamount = (itemamount + $01)
            ElseIf ((local40 And mousehit1) <> 0) Then
                For local3 = $00 To (local37 - $01) Step $01
                    If (otheropen\Field17[local3] = selecteditem) Then
                        otheropen\Field17[local3] = Null
                    EndIf
                Next
                otheropen\Field17[local10] = selecteditem
            EndIf
            local1 = ((local1 + local20) + local35)
            local42 = (local42 + $01)
            If (local42 = $05) Then
                local42 = $00
                local2 = (local2 + (local21 Shl $01))
                local1 = ((graphicwidth Sar $01) - ((((local20 * $0A) Sar $01) + (local35 Shl $02)) Sar $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mousedown1 <> 0) Then
                If (local29 = $42) Then
                    drawimage(selecteditem\Field16, (scaledmousex() - (imagewidth(selecteditem\Field3\Field8) Sar $01)), (scaledmousey() - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                ElseIf (selecteditem <> local36\Field17[local29]) Then
                    drawimage(selecteditem\Field16, (scaledmousex() - (imagewidth(selecteditem\Field3\Field8) Sar $01)), (scaledmousey() - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                EndIf
            Else
                If (local29 = $42) Then
                    dropitem(selecteditem, $01)
                    local37 = otheropen\Field19
                    For local3 = $00 To (local37 - $01) Step $01
                        If (otheropen\Field17[local3] = selecteditem) Then
                            otheropen\Field17[local3] = Null
                        EndIf
                    Next
                    local39 = $01
                    If (otheropen\Field3\Field2 = "wallet") Then
                        If (local39 = $00) Then
                            For local3 = $00 To (local37 - $01) Step $01
                                If (otheropen\Field17[local3] <> Null) Then
                                    local43 = otheropen\Field17[local3]\Field3\Field2
                                    If ((((((local43 <> "25ct") And (local43 <> "coin")) And (local43 <> "key")) And (local43 <> "scp860")) And (local43 <> "scp714")) <> 0) Then
                                        local39 = $00
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    Else
                        For local3 = $00 To (local37 - $01) Step $01
                            If (otheropen\Field17[local3] <> Null) Then
                                local39 = $00
                                Exit
                            EndIf
                        Next
                    EndIf
                    If (local39 <> 0) Then
                        Select otheropen\Field3\Field2
                            Case "clipboard"
                                otheropen\Field16 = otheropen\Field3\Field9
                                setanimtime(otheropen\Field2, 17.0, $00)
                            Case "wallet"
                                setanimtime(otheropen\Field2, 0.0, $00)
                        End Select
                    EndIf
                    selecteditem = Null
                    otheropen = Null
                    local41 = $01
                    movemouse(viewport_center_x, viewport_center_y)
                ElseIf (local36\Field17[local29] = Null) Then
                    For local3 = $00 To (local37 - $01) Step $01
                        If (local36\Field17[local3] = selecteditem) Then
                            local36\Field17[local3] = Null
                        EndIf
                    Next
                    local36\Field17[local29] = selecteditem
                    selecteditem = Null
                ElseIf (local36\Field17[local29] <> selecteditem) Then
                    local45 = selecteditem\Field3\Field2
                    msg = "You cannot combine these two items."
                    msgtimer = 350.0
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
        If ((local41 And (invopen = $00)) <> 0) Then
            otheropen = Null
            resetmouse()
        EndIf
    ElseIf (invopen <> 0) Then
        stated = $00
        If (playerroom\Field7\Field11 = "gatea") Then
            If (iscoopmode() <> 0) Then
                hideentity(fog)
                camerafogrange(camera, 5.0, 30.0)
                camerafogcolor(camera, 200.0, 200.0, 200.0)
                cameraclscolor(camera, 200.0, 200.0, 200.0)
                camerarange(camera, 0.05, 50.0)
            Else
                camerafogcolor(camera, 0.0, 0.0, 0.0)
                cameraclscolor(camera, 0.0, 0.0, 0.0)
            EndIf
        ElseIf (((playerroom\Field7\Field11 = "exit1") And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
            If (iscoopmode() <> 0) Then
                hideentity(fog)
                camerafogrange(camera, 5.0, 45.0)
                camerafogcolor(camera, 200.0, 200.0, 200.0)
                cameraclscolor(camera, 200.0, 200.0, 200.0)
                camerarange(camera, 0.05, 60.0)
            Else
                camerafogcolor(camera, 0.0, 0.0, 0.0)
                cameraclscolor(camera, 0.0, 0.0, 0.0)
            EndIf
        EndIf
        selecteddoor = Null
        local20 = $46
        local21 = $46
        local35 = $23
        local1 = ((graphicwidth Sar $01) - ((((local20 * $0A) Sar $01) + (local35 Shl $02)) Sar $01))
        local2 = ((graphicheight Sar $01) - ((((local21 * $0A) / $05) + (local21 Shl $00)) Sar $01))
        itemamount = $00
        For local10 = $00 To $09 Step $01
            If (inventory(local10) <> Null) Then
                If (inventory(local10)\Field15 = $00) Then
                    inventory(local10) = Null
                EndIf
            EndIf
            For local46 = $00 To $09 Step $01
                If (((inventory(local46) <> Null) And (local46 <> local10)) <> 0) Then
                    If (inventory(local46) = inventory(local10)) Then
                        inventory(local46) = Null
                    EndIf
                EndIf
            Next
            local40 = $00
            If (((scaledmousex() > local1) And (scaledmousex() < (local1 + local20))) <> 0) Then
                If (((scaledmousey() > local2) And (scaledmousey() < (local2 + local21))) <> 0) Then
                    local40 = $01
                EndIf
            EndIf
            If (inventory(local10) <> Null) Then
                color($C8, $C8, $C8)
                Select inventory(local10)\Field3\Field2
                    Case "gasmask"
                        If (wearinggasmask = $01) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "supergasmask"
                        If (wearinggasmask = $02) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "gasmask3"
                        If (wearinggasmask = $03) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "hazmatsuit"
                        If (wearinghazmat = $01) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "hazmatsuit2"
                        If (wearinghazmat = $02) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "hazmatsuit3"
                        If (wearinghazmat = $03) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "vest"
                        If (wearingvest = $01) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "finevest"
                        If (wearingvest = $02) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp714"
                        If (wearing714 = $01) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "nvgoggles"
                        If (wearingnightvision = $01) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "supernv"
                        If (wearingnightvision = $02) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp1499"
                        If (wearing1499 = $01) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "super1499"
                        If (wearing1499 = $02) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "finenvgoggles"
                        If (wearingnightvision = $03) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp427"
                        If (i_427\Field0 = $01) Then
                            rect((local1 - $03), (local2 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                End Select
            EndIf
            If (local40 <> 0) Then
                local29 = local10
                color($FF, $00, $00)
                rect((local1 - $01), (local2 - $01), (local20 + $02), (local21 + $02), $01)
            EndIf
            color($FF, $FF, $FF)
            drawframe(local1, local2, local20, local21, (local1 Mod $40), (local1 Mod $40))
            If (inventory(local10) <> Null) Then
                If (((selecteditem <> inventory(local10)) Or local40) <> 0) Then
                    drawimage(inventory(local10)\Field16, (((local20 Sar $01) + local1) - $20), (((local21 Sar $01) + local2) - $20), $00)
                EndIf
            EndIf
            If (((inventory(local10) <> Null) And (selecteditem <> inventory(local10))) <> 0) Then
                If (local40 <> 0) Then
                    If (selecteditem = Null) Then
                        If (mousehit1 <> 0) Then
                            selecteditem = inventory(local10)
                            mousehit1 = $00
                            If (doubleclick <> 0) Then
                                If (((wearinghazmat > $00) And (instr(selecteditem\Field3\Field2, "hazmatsuit", $01) = $00)) <> 0) Then
                                    msg = "You cannot use any items while wearing a hazmat suit."
                                    msgtimer = 350.0
                                    selecteditem = Null
                                    Return $00
                                EndIf
                                If (inventory(local10)\Field3\Field3 <> $42) Then
                                    playsound_strict(picksfx(inventory(local10)\Field3\Field3))
                                EndIf
                                If (myplayer\Field82 = $00) Then
                                    pickupgun(selecteditem)
                                EndIf
                                invopen = $00
                                doubleclick = $00
                                blockguns = $01
                            EndIf
                        EndIf
                        aasetfont(font1)
                        color($00, $00, $00)
                        aatext((((local20 Sar $01) + local1) + $01), ((((local2 + local21) + local35) - $0F) + $01), inventory(local10)\Field0, $01, $00, 1.0)
                        color($FF, $FF, $FF)
                        aatext(((local20 Sar $01) + local1), (((local2 + local21) + local35) - $0F), inventory(local10)\Field0, $01, $00, 1.0)
                    EndIf
                EndIf
                itemamount = (itemamount + $01)
            ElseIf ((local40 And mousehit1) <> 0) Then
                For local3 = $00 To $09 Step $01
                    If (inventory(local3) = selecteditem) Then
                        inventory(local3) = Null
                    EndIf
                Next
                inventory(local10) = selecteditem
            EndIf
            local1 = ((local1 + local20) + local35)
            If (local10 = $04) Then
                local2 = (local2 + (local21 Shl $01))
                local1 = ((graphicwidth Sar $01) - ((((local20 * $0A) Sar $01) + (local35 Shl $02)) Sar $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mousedown1 <> 0) Then
                If (local29 = $42) Then
                    drawimage(selecteditem\Field16, (scaledmousex() - (imagewidth(selecteditem\Field3\Field8) Sar $01)), (scaledmousey() - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                ElseIf (selecteditem <> inventory(local29)) Then
                    drawimage(selecteditem\Field16, (scaledmousex() - (imagewidth(selecteditem\Field3\Field8) Sar $01)), (scaledmousey() - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                EndIf
            Else
                If (local29 = $42) Then
                    Select selecteditem\Field3\Field2
                        Case "vest","finevest","hazmatsuit","hazmatsuit2","hazmatsuit3"
                            msg = "Double click on this item to take it off."
                            msgtimer = 350.0
                        Case "scp1499","super1499"
                            If (wearing1499 > $00) Then
                                msg = "Double click on this item to take it off."
                                msgtimer = 350.0
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
                    movemouse(viewport_center_x, viewport_center_y)
                ElseIf (inventory(local29) = Null) Then
                    For local3 = $00 To $09 Step $01
                        If (inventory(local3) = selecteditem) Then
                            inventory(local3) = Null
                        EndIf
                    Next
                    inventory(local29) = selecteditem
                    selecteditem = Null
                ElseIf (inventory(local29) <> selecteditem) Then
                    Select selecteditem\Field3\Field2
                        Case "paper","key1","key2","key3","key4","key5","key6","misc","oldpaper","badge","ticket","25ct","coin","key","scp860"
                            If (inventory(local29)\Field3\Field2 = "clipboard") Then
                                local50 = Null
                                local51 = selecteditem\Field3\Field2
                                local52 = selecteditem\Field3\Field1
                                If ((((((((local51 <> "misc") And (local51 <> "25ct")) And (local51 <> "coin")) And (local51 <> "key")) And (local51 <> "scp860")) And (local51 <> "scp714")) Or ((local52 = "Playing Card") Or (local52 = "Mastercard"))) <> 0) Then
                                    debuglog((Str inventory(local29)\Field19))
                                    For local53 = $00 To (inventory(local29)\Field19 - $01) Step $01
                                        If (inventory(local29)\Field17[local53] = Null) Then
                                            If (selecteditem <> Null) Then
                                                inventory(local29)\Field17[local53] = selecteditem
                                                inventory(local29)\Field13 = 1.0
                                                setanimtime(inventory(local29)\Field2, 0.0, $00)
                                                inventory(local29)\Field16 = inventory(local29)\Field3\Field8
                                                For local54 = $00 To $09 Step $01
                                                    If (inventory(local54) = selecteditem) Then
                                                        inventory(local54) = Null
                                                        playsound_strict(picksfx(selecteditem\Field3\Field3))
                                                    EndIf
                                                Next
                                                local50 = selecteditem
                                                selecteditem = Null
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    If (selecteditem <> Null) Then
                                        msg = "The paperclip is not strong enough to hold any more items."
                                    ElseIf (((local50\Field3\Field2 = "paper") Or (local50\Field3\Field2 = "oldpaper")) <> 0) Then
                                        msg = "This document was added to the clipboard."
                                    ElseIf (local50\Field3\Field2 = "badge") Then
                                        msg = (local50\Field3\Field1 + " was added to the clipboard.")
                                    Else
                                        msg = (("The " + local50\Field3\Field1) + " was added to the clipboard.")
                                    EndIf
                                    msgtimer = 350.0
                                Else
                                    msg = "You cannot combine these two items."
                                    msgtimer = 350.0
                                EndIf
                            ElseIf (inventory(local29)\Field3\Field2 = "wallet") Then
                                local50 = Null
                                local51 = selecteditem\Field3\Field2
                                local52 = selecteditem\Field3\Field1
                                If (((((local51 <> "misc") And (local51 <> "paper")) And (local51 <> "oldpaper")) Or ((local52 = "Playing Card") Or (local52 = "Mastercard"))) <> 0) Then
                                    For local53 = $00 To (inventory(local29)\Field19 - $01) Step $01
                                        If (inventory(local29)\Field17[local53] = Null) Then
                                            If (selecteditem <> Null) Then
                                                inventory(local29)\Field17[local53] = selecteditem
                                                inventory(local29)\Field13 = 1.0
                                                If (((((local51 <> "25ct") And (local51 <> "coin")) And (local51 <> "key")) And (local51 <> "scp860")) <> 0) Then
                                                    setanimtime(inventory(local29)\Field2, 3.0, $00)
                                                EndIf
                                                inventory(local29)\Field16 = inventory(local29)\Field3\Field8
                                                For local54 = $00 To $09 Step $01
                                                    If (inventory(local54) = selecteditem) Then
                                                        inventory(local54) = Null
                                                        playsound_strict(picksfx(selecteditem\Field3\Field3))
                                                    EndIf
                                                Next
                                                local50 = selecteditem
                                                selecteditem = Null
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    If (selecteditem <> Null) Then
                                        msg = "The wallet is full."
                                    Else
                                        msg = (("You put " + local50\Field3\Field1) + " into the wallet.")
                                    EndIf
                                    msgtimer = 350.0
                                Else
                                    msg = "You cannot combine these two items."
                                    msgtimer = 350.0
                                EndIf
                            Else
                                msg = "You cannot combine these two items."
                                msgtimer = 350.0
                            EndIf
                            selecteditem = Null
                        Case "battery","bat"
                            Select inventory(local29)\Field3\Field1
                                Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                    If (selecteditem\Field3\Field3 <> $42) Then
                                        playsound_strict(picksfx(selecteditem\Field3\Field3))
                                    EndIf
                                    removeitem(selecteditem, $01)
                                    selecteditem = Null
                                    inventory(local29)\Field13 = 100.0
                                    msg = "You replaced the navigator's battery."
                                    msgtimer = 350.0
                                Case "S-NAV Navigator Ultimate"
                                    msg = "There seems to be no place for batteries in this navigator."
                                    msgtimer = 350.0
                                Case "Radio Transceiver"
                                    Select inventory(local29)\Field3\Field2
                                        Case "fineradio","veryfineradio"
                                            msg = "There seems to be no place for batteries in this radio."
                                            msgtimer = 350.0
                                        Case "18vradio"
                                            msg = "The battery does not fit inside this radio."
                                            msgtimer = 350.0
                                        Case "radio"
                                            If (selecteditem\Field3\Field3 <> $42) Then
                                                playsound_strict(picksfx(selecteditem\Field3\Field3))
                                            EndIf
                                            removeitem(selecteditem, $01)
                                            selecteditem = Null
                                            inventory(local29)\Field13 = 100.0
                                            msg = "You replaced the radio's battery."
                                            msgtimer = 350.0
                                    End Select
                                Case "Night Vision Goggles"
                                    local57 = inventory(local29)\Field3\Field2
                                    If (((local57 = "nvgoggles") Or (local57 = "supernv")) <> 0) Then
                                        If (selecteditem\Field3\Field3 <> $42) Then
                                            playsound_strict(picksfx(selecteditem\Field3\Field3))
                                        EndIf
                                        removeitem(selecteditem, $01)
                                        selecteditem = Null
                                        inventory(local29)\Field13 = 1000.0
                                        msg = "You replaced the goggles' battery."
                                        msgtimer = 350.0
                                    Else
                                        msg = "There seems to be no place for batteries in these night vision goggles."
                                        msgtimer = 350.0
                                    EndIf
                                Default
                                    msg = "You cannot combine these two items."
                                    msgtimer = 350.0
                            End Select
                        Case "18vbat"
                            Select inventory(local29)\Field3\Field1
                                Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                    msg = "The battery does not fit inside this navigator."
                                    msgtimer = 350.0
                                Case "S-NAV Navigator Ultimate"
                                    msg = "There seems to be no place for batteries in this navigator."
                                    msgtimer = 350.0
                                Case "Radio Transceiver"
                                    Select inventory(local29)\Field3\Field2
                                        Case "fineradio","veryfineradio"
                                            msg = "There seems to be no place for batteries in this radio."
                                            msgtimer = 350.0
                                        Case "18vradio"
                                            If (selecteditem\Field3\Field3 <> $42) Then
                                                playsound_strict(picksfx(selecteditem\Field3\Field3))
                                            EndIf
                                            removeitem(selecteditem, $01)
                                            selecteditem = Null
                                            inventory(local29)\Field13 = 100.0
                                            msg = "You replaced the radio's battery."
                                            msgtimer = 350.0
                                    End Select
                                Default
                                    msg = "You cannot combine these two items."
                                    msgtimer = 350.0
                            End Select
                        Default
                            msg = "You cannot combine these two items."
                            msgtimer = 350.0
                    End Select
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
        If (invopen = $00) Then
            resetmouse()
        EndIf
    ElseIf (selecteditem <> Null) Then
        Select selecteditem\Field3\Field2
            Case "nvgoggles"
                If (((wearing1499 = $00) And (wearinghazmat = $00)) <> 0) Then
                    If (wearingnightvision = $01) Then
                        msg = "You removed the goggles."
                        camerafogfar = storedcamerafogfar
                    Else
                        msg = "You put on the goggles."
                        wearinggasmask = $00
                        wearingnightvision = $00
                        storedcamerafogfar = camerafogfar
                        camerafogfar = 30.0
                    EndIf
                    wearingnightvision = (wearingnightvision = $00)
                ElseIf (wearing1499 > $00) Then
                    msg = "You need to take off SCP-1499 in order to put on the goggles."
                Else
                    msg = "You need to take off the hazmat suit in order to put on the goggles."
                EndIf
                selecteditem = Null
                msgtimer = 350.0
            Case "supernv"
                If (((wearing1499 = $00) And (wearinghazmat = $00)) <> 0) Then
                    If (wearingnightvision = $02) Then
                        msg = "You removed the goggles."
                        camerafogfar = storedcamerafogfar
                    Else
                        msg = "You put on the goggles."
                        wearinggasmask = $00
                        wearingnightvision = $00
                        storedcamerafogfar = camerafogfar
                        camerafogfar = 30.0
                    EndIf
                    wearingnightvision = ((wearingnightvision = $00) Shl $01)
                ElseIf (wearing1499 > $00) Then
                    msg = "You need to take off SCP-1499 in order to put on the goggles."
                Else
                    msg = "You need to take off the hazmat suit in order to put on the goggles."
                EndIf
                selecteditem = Null
                msgtimer = 350.0
            Case "finenvgoggles"
                If (((wearing1499 = $00) And (wearinghazmat = $00)) <> 0) Then
                    If (wearingnightvision = $03) Then
                        msg = "You removed the goggles."
                        camerafogfar = storedcamerafogfar
                    Else
                        msg = "You put on the goggles."
                        wearinggasmask = $00
                        wearingnightvision = $00
                        storedcamerafogfar = camerafogfar
                        camerafogfar = 30.0
                    EndIf
                    wearingnightvision = ((wearingnightvision = $00) * $03)
                ElseIf (wearing1499 > $00) Then
                    msg = "You need to take off SCP-1499 in order to put on the goggles."
                Else
                    msg = "You need to take off the hazmat suit in order to put on the goggles."
                EndIf
                selecteditem = Null
                msgtimer = 350.0
            Case "ring"
                If (wearing714 = $02) Then
                    msg = "You removed the ring."
                    wearing714 = $00
                Else
                    msg = "You put on the ring."
                    wearing714 = $02
                EndIf
                msgtimer = 350.0
                selecteditem = Null
            Case "1123"
                If ((wearing714 = $01) = $00) Then
                    If (playerroom\Field7\Field11 <> "room1123") Then
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
                    For local14 = Each events
                        If (local14\Field0 = "room1123") Then
                            If (0.0 = local14\Field2) Then
                                showentity(light)
                                lightflash = 3.0
                                playsound_strict(loadtempsound("SFX\SCP\1123\Touch.ogg"))
                            EndIf
                            local14\Field2 = max(1.0, local14\Field2)
                            Exit
                        EndIf
                    Next
                EndIf
            Case "battery"
            Case "key1","key2","key3","key4","key5","key6","keyomni","scp860","hand","hand2","25ct"
                drawimage(selecteditem\Field3\Field8, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field8) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
            Case "scp513"
                playsound_strict(loadtempsound("SFX\SCP\513\Bell1.ogg"))
                multiplayer_writetempsound("SFX\SCP\513\Bell1.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 20.0, 0.8)
                selecteditem = Null
            Case "scp500"
                If (canuseitem($00, $00, $01) <> 0) Then
                    giveachievement($0E, $01)
                    If (0.0 < infect) Then
                        msg = "You swallowed the pill. Your nausea is fading."
                    Else
                        msg = "You swallowed the pill."
                    EndIf
                    msgtimer = 490.0
                    deathtimer = 0.0
                    infect = 0.0
                    stamina = 100.0
                    For local4 = $00 To $05 Step $01
                        scp1025state[local4] = 0.0
                    Next
                    If (1.0 < staminaeffect) Then
                        staminaeffect = 1.0
                        staminaeffecttimer = 0.0
                    EndIf
                    myplayer\Field70 = (myplayer\Field70 + 200.0)
                    removeitem(selecteditem, $01)
                    selecteditem = Null
                EndIf
            Case "boxofammo"
                If (canuseitem($00, $00, $01) <> 0) Then
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field8, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field8) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local1 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local2 = ((graphicheight Sar $01) + $50)
                    rect(local1, local2, (local20 + $04), local21, $00)
                    For local4 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + (fpsfactor * 0.5)), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        removeitem(selecteditem, $01)
                        selecteditem = Null
                        msgtimer = 560.0
                        msg = "Ammo reserve fully replenished."
                        For local61 = Each guns
                            local61\Field18 = local61\Field32
                        Next
                    EndIf
                EndIf
            Case "chicken"
                If (canuseitem($00, $00, $01) <> 0) Then
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    crouch = $01
                    drawimage(selecteditem\Field3\Field8, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field8) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local1 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local2 = ((graphicheight Sar $01) + $50)
                    rect(local1, local2, (local20 + $04), local21, $00)
                    For local4 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + (fpsfactor / 7.0)), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        Select rand($07, $01)
                            Case $00
                                msg = "You feel bad because you have gastritis"
                                vomittimer = 30.0
                            Case $01
                                msg = "You feel very good!"
                                injuries = max((injuries - 0.5), 0.0)
                                blurtimer = 100.0
                            Case $02
                                msg = "You choked on a chicken and smother"
                                playsound_strict(coughsfx(rand($00, $02)))
                                multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                kill("was killed by chicken", $00)
                                blurtimer = 2000.0
                            Case $03
                                msg = "You choked on a chicken"
                                playsound_strict(coughsfx(rand($00, $02)))
                                multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                blurtimer = 2000.0
                            Case $04
                                msg = "There were nails in the chicken"
                                playsound_strict(coughsfx(rand($00, $02)))
                                multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                injuries = 30.0
                                bloodloss = 10.0
                                local31 = createpivot($00)
                                positionentity(local31, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                                turnentity(local31, 90.0, 0.0, 0.0, $00)
                                entitypick(local31, 0.3)
                                local63 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                local63\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                                entityalpha(local63\Field0, 1.0)
                                scalesprite(local63\Field0, local63\Field2, local63\Field2)
                                freeentity(local31)
                                multiplayer_writedecal(local63, $01, $01)
                                blurtimer = 800.0
                            Case $05
                                msg = "The chicken was not tasty"
                            Case $06
                                local31 = createpivot($00)
                                positionentity(local31, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                                turnentity(local31, 90.0, 0.0, 0.0, $00)
                                entitypick(local31, 0.3)
                                local63 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                local63\Field2 = rnd(0.03, 0.08)
                                entityalpha(local63\Field0, 1.0)
                                scalesprite(local63\Field0, local63\Field2, local63\Field2)
                                freeentity(local31)
                                multiplayer_writedecal(local63, $01, $01)
                                msg = "You bit your tongue"
                                blurtimer = 200.0
                            Case $07
                                msg = "The chicken turned out to be rotten"
                                vomittimer = 30.0
                        End Select
                        removeitem(selecteditem, $01)
                        selecteditem = Null
                        msgtimer = 560.0
                    ElseIf (50.0 < selecteditem\Field13) Then
                        If (rand($190, $01) = $32) Then
                            Select rand($07, $01)
                                Case $00
                                    msg = "You feel bad because you have gastritis"
                                    vomittimer = 30.0
                                Case $02
                                    msg = "You choked on a chicken and smother"
                                    playsound_strict(coughsfx(rand($00, $02)))
                                    multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                    kill("was killed by chicken", $00)
                                    blurtimer = 2000.0
                                Case $03
                                    msg = "You choked on a chicken"
                                    playsound_strict(coughsfx(rand($00, $02)))
                                    multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                    blurtimer = 2000.0
                                Case $04
                                    msg = "There were nails in the chicken"
                                    playsound_strict(coughsfx(rand($00, $02)))
                                    multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                    injuries = 30.0
                                    bloodloss = 10.0
                                    local31 = createpivot($00)
                                    positionentity(local31, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                                    turnentity(local31, 90.0, 0.0, 0.0, $00)
                                    entitypick(local31, 0.3)
                                    local63 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                    local63\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                                    entityalpha(local63\Field0, 1.0)
                                    scalesprite(local63\Field0, local63\Field2, local63\Field2)
                                    freeentity(local31)
                                    multiplayer_writedecal(local63, $01, $01)
                                    blurtimer = 800.0
                                Case $05
                                    msg = "The chicken was not tasty"
                                Case $06
                                    local31 = createpivot($00)
                                    positionentity(local31, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                                    turnentity(local31, 90.0, 0.0, 0.0, $00)
                                    entitypick(local31, 0.3)
                                    local63 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                    local63\Field2 = rnd(0.03, 0.08)
                                    entityalpha(local63\Field0, 1.0)
                                    scalesprite(local63\Field0, local63\Field2, local63\Field2)
                                    freeentity(local31)
                                    multiplayer_writedecal(local63, $01, $01)
                                    msg = "You bit your tongue"
                                    blurtimer = 200.0
                                Case $07
                                    msg = "The chicken turned out to be rotten"
                                    vomittimer = 30.0
                            End Select
                            removeitem(selecteditem, $01)
                            selecteditem = Null
                            msgtimer = 560.0
                        EndIf
                    EndIf
                EndIf
            Case "veryfinefirstaid"
                If (canuseitem($00, $00, $01) <> 0) Then
                    Select rand($05, $01)
                        Case $01
                            injuries = 3.5
                            msg = "You started bleeding heavily."
                            msgtimer = 490.0
                        Case $02
                            injuries = 0.0
                            bloodloss = 0.0
                            msg = "Your wounds are healing up rapidly."
                            msgtimer = 490.0
                        Case $03
                            injuries = max(0.0, (injuries - rnd(0.5, 3.5)))
                            bloodloss = max(0.0, (bloodloss - rnd(10.0, 100.0)))
                            msg = "You feel much better."
                            msgtimer = 490.0
                        Case $04
                            blurtimer = 10000.0
                            bloodloss = 0.0
                            msg = "You feel nauseated."
                            msgtimer = 490.0
                        Case $05
                            blinktimer = -10.0
                            local66 = playerroom\Field7\Field11
                            If ((((local66 = "dimension1499") Or (local66 = "gatea")) Or ((local66 = "exit1") And ((1040.0 * roomscale) < entityy(collider, $00)))) <> 0) Then
                                injuries = 2.5
                                msg = "You started bleeding heavily."
                                msgtimer = 490.0
                            Else
                                For local67 = Each rooms
                                    If (local67\Field7\Field11 = "pocketdimension") Then
                                        positionentity(collider, entityx(local67\Field2, $00), 0.8, entityz(local67\Field2, $00), $00)
                                        resetentity(collider)
                                        updatedoors()
                                        updaterooms()
                                        playsound_strict(use914sfx)
                                        dropspeed = 0.0
                                        curr106\Field9 = -2500.0
                                        Exit
                                    EndIf
                                Next
                                msg = "For some inexplicable reason, you find yourself inside the pocket dimension."
                                msgtimer = 560.0
                            EndIf
                    End Select
                    myplayer\Field70 = 100.0
                    removeitem(selecteditem, $01)
                EndIf
            Case "firstaid","finefirstaid","firstaid2"
                If (((0.0 = bloodloss) And (0.0 = injuries)) <> 0) Then
                    msg = "You do not need to use a first aid kit right now."
                    msgtimer = 350.0
                    selecteditem = Null
                ElseIf (canuseitem($00, $01, $01) <> 0) Then
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    crouch = $01
                    drawimage(selecteditem\Field3\Field8, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field8) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local1 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local2 = ((graphicheight Sar $01) + $50)
                    rect(local1, local2, (local20 + $04), local21, $00)
                    For local4 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + (fpsfactor / 5.0)), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        If (selecteditem\Field3\Field2 = "finefirstaid") Then
                            bloodloss = 0.0
                            injuries = max(0.0, (injuries - 2.0))
                            If (0.0 = injuries) Then
                                msg = "You bandaged the wounds and took a painkiller. You feel fine."
                            ElseIf (1.0 < injuries) Then
                                msg = "You bandaged the wounds and took a painkiller, but you were not able to stop the bleeding."
                            Else
                                msg = "You bandaged the wounds and took a painkiller, but you still feel sore."
                            EndIf
                            myplayer\Field70 = 100.0
                            msgtimer = 350.0
                            removeitem(selecteditem, $01)
                        Else
                            bloodloss = max(0.0, (bloodloss - (Float rand($0A, $14))))
                            If (2.5 <= injuries) Then
                                msg = "The wounds were way too severe to staunch the bleeding completely."
                                injuries = max(2.5, (injuries - rnd(0.3, 0.7)))
                            ElseIf (1.0 < injuries) Then
                                injuries = max(0.5, (injuries - rnd(0.5, 1.0)))
                                If (1.0 < injuries) Then
                                    msg = "You bandaged the wounds but were unable to staunch the bleeding completely."
                                Else
                                    msg = "You managed to stop the bleeding."
                                EndIf
                            ElseIf (0.5 < injuries) Then
                                injuries = 0.5
                                msg = "You took a painkiller, easing the pain slightly."
                            Else
                                injuries = 0.5
                                msg = "You took a painkiller, but it still hurts to walk."
                            EndIf
                            If (selecteditem\Field3\Field2 = "firstaid2") Then
                                Select rand($06, $01)
                                    Case $01
                                        superman = $01
                                        msg = "You have becomed overwhelmedwithadrenalineholyshitWOOOOOO~!"
                                    Case $02
                                        invertmouse = (invertmouse = $00)
                                        msg = "You suddenly find it very difficult to turn your head."
                                    Case $03
                                        blurtimer = 5000.0
                                        msg = "You feel nauseated."
                                    Case $04
                                        blinkeffect = 0.6
                                        blinkeffecttimer = (Float rand($14, $1E))
                                    Case $05
                                        bloodloss = 0.0
                                        injuries = 0.0
                                        msg = "You bandaged the wounds. The bleeding stopped completely and you feel fine."
                                    Case $06
                                        msg = "You bandaged the wounds and blood started pouring heavily through the bandages."
                                        injuries = 3.5
                                End Select
                            EndIf
                            myplayer\Field70 = 100.0
                            msgtimer = 350.0
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
                If (selecteditem\Field3\Field12 = $00) Then
                    Select selecteditem\Field3\Field1
                        Case "Burnt Note"
                            selecteditem\Field3\Field12 = loadimage_strict("GFX\items\bn.it")
                            setbuffer(imagebuffer(selecteditem\Field3\Field12, $00))
                            color($00, $00, $00)
                            aasetfont(font1)
                            aatext($115, $1D5, (Str accesscode), $01, $01, 1.0)
                            color($FF, $FF, $FF)
                            setbuffer(backbuffer())
                        Case "Document SCP-372"
                            selecteditem\Field3\Field12 = loadimage_strict(selecteditem\Field3\Field11)
                            selecteditem\Field3\Field12 = resizeimage2(selecteditem\Field3\Field12, (Int ((Float imagewidth(selecteditem\Field3\Field12)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field12)) * menuscale)))
                            setbuffer(imagebuffer(selecteditem\Field3\Field12, $00))
                            color($25, $2D, $89)
                            aasetfont(font5)
                            local0 = ((accesscode * $03) Mod $2710)
                            If (local0 < $3E8) Then
                                local0 = (local0 + $3E8)
                            EndIf
                            aatext((Int (383.0 * menuscale)), (Int (734.0 * menuscale)), (Str local0), $01, $01, 1.0)
                            color($FF, $FF, $FF)
                            setbuffer(backbuffer())
                        Case "Movie Ticket"
                            selecteditem\Field3\Field12 = loadimage_strict(selecteditem\Field3\Field11)
                            If (0.0 = selecteditem\Field13) Then
                                msg = ((chr($22) + "Hey, I remember this movie!") + chr($22))
                                msgtimer = 700.0
                                playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($01, $05))) + ".ogg")))
                                selecteditem\Field13 = 1.0
                            EndIf
                        Default
                            selecteditem\Field3\Field12 = loadimage_strict(selecteditem\Field3\Field11)
                            selecteditem\Field3\Field12 = resizeimage2(selecteditem\Field3\Field12, (Int ((Float imagewidth(selecteditem\Field3\Field12)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field12)) * menuscale)))
                    End Select
                    maskimage(selecteditem\Field3\Field12, $FF, $00, $FF)
                EndIf
                drawimage(selecteditem\Field3\Field12, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field12) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field12) Sar $01)), $00)
            Case "scp1025"
                giveachievement($18, $01)
                If (selecteditem\Field3\Field12 = $00) Then
                    selecteditem\Field13 = (Float rand($00, $05))
                    selecteditem\Field3\Field12 = loadimage_strict((("GFX\items\1025\1025_" + (Str (Int selecteditem\Field13))) + ".jpg"))
                    selecteditem\Field3\Field12 = resizeimage2(selecteditem\Field3\Field12, (Int ((Float imagewidth(selecteditem\Field3\Field12)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field12)) * menuscale)))
                    maskimage(selecteditem\Field3\Field12, $FF, $00, $FF)
                EndIf
                If (wearing714 = $00) Then
                    scp1025state[(Int selecteditem\Field13)] = max(1.0, scp1025state[(Int selecteditem\Field13)])
                EndIf
                drawimage(selecteditem\Field3\Field12, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field12) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field12) Sar $01)), $00)
            Case "cup"
                If (canuseitem($00, $00, $01) <> 0) Then
                    selecteditem\Field0 = trim(lower(selecteditem\Field0))
                    If (left(selecteditem\Field0, (Int min(6.0, (Float len(selecteditem\Field0))))) = "cup of") Then
                        selecteditem\Field0 = right(selecteditem\Field0, (len(selecteditem\Field0) - $07))
                    ElseIf (left(selecteditem\Field0, (Int min(8.0, (Float len(selecteditem\Field0))))) = "a cup of") Then
                        selecteditem\Field0 = right(selecteditem\Field0, (len(selecteditem\Field0) - $09))
                    EndIf
                    local7 = (selecteditem\Field13 + 1.0)
                    local70 = "DATA\SCP-294.ini"
                    local71 = getinisectionlocation(local70, selecteditem\Field0)
                    local13 = getinistring2(local70, local71, "message", "")
                    If (local13 <> "") Then
                        msg = local13
                        msgtimer = 420.0
                    EndIf
                    If ((getiniint2(local70, local71, "lethal", "") Or getiniint2(local70, local71, "deathtimer", "")) <> 0) Then
                        deathmsg = getinistring2(local70, local71, "deathmessage", "")
                        If (getiniint2(local70, local71, "lethal", "") <> 0) Then
                            kill("was killed", $00)
                        EndIf
                    EndIf
                    blurtimer = (Float (getiniint2(local70, local71, "blur", "") * $46))
                    If (0.0 = vomittimer) Then
                        vomittimer = (Float getiniint2(local70, local71, "vomit", ""))
                    EndIf
                    camerashaketimer = (Float getinistring2(local70, local71, "camerashake", ""))
                    injuries = max(((Float getiniint2(local70, local71, "damage", "")) + injuries), 0.0)
                    bloodloss = max(((Float getiniint2(local70, local71, "blood loss", "")) + bloodloss), 0.0)
                    local13 = getinistring2(local70, local71, "sound", "")
                    If (local13 <> "") Then
                        playsound_strict(loadtempsound(local13))
                    EndIf
                    If (getiniint2(local70, local71, "stomachache", "") <> 0) Then
                        scp1025state[$03] = 1.0
                    EndIf
                    deathtimer = (Float (getiniint2(local70, local71, "deathtimer", "") * $46))
                    blinkeffect = ((Float getinistring2(local70, local71, "blink effect", "1.0")) * local7)
                    blinkeffecttimer = ((Float getinistring2(local70, local71, "blink effect timer", "1.0")) * local7)
                    staminaeffect = ((Float getinistring2(local70, local71, "stamina effect", "1.0")) * local7)
                    staminaeffecttimer = ((Float getinistring2(local70, local71, "stamina effect timer", "1.0")) * local7)
                    local13 = getinistring2(local70, local71, "refusemessage", "")
                    If (local13 <> "") Then
                        msg = local13
                        msgtimer = 420.0
                    Else
                        local15 = createitem("Empty Cup", "emptycup", 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00, $01)
                        local15\Field15 = $01
                        For local4 = $00 To $09 Step $01
                            If (inventory(local4) = selecteditem) Then
                                inventory(local4) = local15
                                Exit
                            EndIf
                        Next
                        entitytype(local15\Field1, $03, $00)
                        removeitem(selecteditem, $01)
                    EndIf
                    selecteditem = Null
                EndIf
            Case "syringe"
                If (canuseitem($00, $01, $01) <> 0) Then
                    healtimer = 30.0
                    staminaeffect = 0.5
                    staminaeffecttimer = 20.0
                    msg = "You injected yourself with the syringe and feel a slight adrenaline rush."
                    msgtimer = 560.0
                    removeitem(selecteditem, $01)
                EndIf
            Case "finesyringe"
                If (canuseitem($00, $01, $01) <> 0) Then
                    healtimer = rnd(20.0, 40.0)
                    staminaeffect = rnd(0.5, 0.8)
                    staminaeffecttimer = rnd(20.0, 30.0)
                    msg = "You injected yourself with the syringe and feel an adrenaline rush."
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
                            msg = "You injected yourself with the syringe and feel a huge adrenaline rush."
                        Case $02
                            superman = $01
                            msg = "You injected yourself with the syringe and feel a humongous adrenaline rush."
                        Case $03
                            vomittimer = 30.0
                            msg = "You injected yourself with the syringe and feel a pain in your stomach."
                    End Select
                    msgtimer = 560.0
                    removeitem(selecteditem, $01)
                EndIf
            Case "radio","18vradio","fineradio","veryfineradio"
                If (100.0 >= selecteditem\Field13) Then
                    selecteditem\Field13 = max(0.0, (selecteditem\Field13 - (fpsfactor * 0.004)))
                EndIf
                If (selecteditem\Field3\Field12 = $00) Then
                    selecteditem\Field3\Field12 = loadimage_strict(selecteditem\Field3\Field11)
                    maskimage(selecteditem\Field3\Field12, $FF, $00, $FF)
                EndIf
                If (0.0 = radiostate($05)) Then
                    msg = "Use the numbered keys 1 through 9 to cycle between various channels."
                    msgtimer = 350.0
                    radiostate($05) = 1.0
                    radiostate($00) = -1.0
                EndIf
                local13 = ""
                local1 = (graphicwidth - imagewidth(selecteditem\Field3\Field12))
                local2 = (graphicheight - imageheight(selecteditem\Field3\Field12))
                drawimage(selecteditem\Field3\Field12, local1, local2, $00)
                radiouse = $01
                If (((playerroom\Field7\Field11 = "pocketdimension") Or (4.0 > coffindistance)) <> 0) Then
                    resumechannel(radiochn($05))
                    If (channelplaying(radiochn($05)) = $00) Then
                        radiochn($05) = playsound_strict(radiostatic)
                    EndIf
                Else
                    myplayer\Field67 = (Int selecteditem\Field14)
                    Select (Int selecteditem\Field14)
                        Case $00
                            resumechannel(radiochn($00))
                            local13 = "        USER TRACK PLAYER - "
                            If (enableusertracks = $00) Then
                                If (channelplaying(radiochn($00)) = $00) Then
                                    radiochn($00) = playsound_strict(radiostatic)
                                EndIf
                                local13 = (local13 + "NOT ENABLED     ")
                            ElseIf (usertrackmusicamount < $01) Then
                                If (channelplaying(radiochn($00)) = $00) Then
                                    radiochn($00) = playsound_strict(radiostatic)
                                EndIf
                                local13 = (local13 + "NO TRACKS FOUND     ")
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
                                    debuglog(("CurrTrack: " + (Str radiostate($00))))
                                    debuglog(usertrackname((Int radiostate($00))))
                                Else
                                    local13 = ((local13 + upper(usertrackname((Int radiostate($00))))) + "          ")
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
                                    debuglog(("CurrTrack: " + (Str radiostate($00))))
                                    debuglog(usertrackname((Int radiostate($00))))
                                EndIf
                            EndIf
                        Case $01
                            debuglog((Str radiostate($01)))
                            resumechannel(radiochn($01))
                            local13 = "        WARNING - CONTAINMENT BREACH          "
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
                            local13 = "        SCP Foundation On-Site Radio          "
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
                            local13 = "             EMERGENCY CHANNEL - RESERVED FOR COMMUNICATION IN THE EVENT OF A CONTAINMENT BREACH         "
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
                    local1 = (local1 + $42)
                    local2 = (local2 + $1A3)
                    color($1E, $1E, $1E)
                    If (100.0 >= selecteditem\Field13) Then
                        For local4 = $00 To $04 Step $01
                            rect(local1, ((local4 Shl $03) + local2), ($2B - (local4 * $06)), $04, ((Float ($04 - local4)) < ceil((selecteditem\Field13 / 20.0))))
                        Next
                    EndIf
                    aasetfont(font3)
                    aatext((local1 + $3C), local2, "CHN", $00, $00, 1.0)
                    If (selecteditem\Field3\Field2 = "veryfineradio") Then
                        resumechannel(radiochn($00))
                        If (channelplaying(radiochn($00)) = $00) Then
                            radiochn($00) = playsound_strict(radiostatic)
                        EndIf
                        radiostate($06) = (radiostate($06) + fpsfactor)
                        local0 = (Int mid((Str accesscode), (Int (radiostate($08) + 1.0)), $01))
                        If ((((radiostate($07) * 50.0) >= (radiostate($06) - fpsfactor)) And (radiostate($06) > (radiostate($07) * 50.0))) <> 0) Then
                            playsound_strict(radiobuzz)
                            radiostate($07) = (radiostate($07) + 1.0)
                            If ((Float local0) <= radiostate($07)) Then
                                radiostate($07) = 0.0
                                radiostate($06) = -100.0
                                radiostate($08) = (radiostate($08) + 1.0)
                                If (4.0 = radiostate($08)) Then
                                    radiostate($08) = 0.0
                                    radiostate($06) = -200.0
                                EndIf
                            EndIf
                        EndIf
                        local13 = ""
                        For local4 = $00 To rand($05, $1E) Step $01
                            local13 = (local13 + chr(rand($01, $64)))
                        Next
                        aasetfont(font4)
                        aatext((local1 + $61), (local2 + $10), (Str rand($00, $09)), $01, $01, 1.0)
                    Else
                        For local4 = $02 To $0A Step $01
                            If (keyhit(local4) <> 0) Then
                                If ((Float (local4 - $02)) <> selecteditem\Field14) Then
                                    playsound_strict(radiosquelch)
                                    If (radiochn((Int selecteditem\Field14)) <> $00) Then
                                        pausechannel(radiochn((Int selecteditem\Field14)))
                                    EndIf
                                EndIf
                                selecteditem\Field14 = (Float (local4 - $02))
                                If (radiochn((Int selecteditem\Field14)) <> $00) Then
                                    resumechannel(radiochn((Int selecteditem\Field14)))
                                EndIf
                            EndIf
                        Next
                        aasetfont(font4)
                        aatext((local1 + $61), (local2 + $10), (Str (Int (selecteditem\Field14 + 1.0))), $01, $01, 1.0)
                    EndIf
                    aasetfont(font3)
                    If (local13 <> "") Then
                        local13 = right(left(local13, ((millisecs2() / $12C) Mod len(local13))), $0A)
                        aatext((local1 + $20), (local2 + $21), local13, $00, $00, 1.0)
                    EndIf
                    aasetfont(font1)
                EndIf
            Case "cigarette"
                If (canuseitem($00, $00, $01) <> 0) Then
                    If (0.0 = selecteditem\Field13) Then
                        Select rand($06, $01)
                            Case $01
                                msg = ((chr($22) + "I don't have anything to light it with. Umm, what about that... Nevermind.") + chr($22))
                            Case $02
                                msg = "You are unable to get lit."
                            Case $03
                                msg = ((chr($22) + "I quit that a long time ago.") + chr($22))
                                removeitem(selecteditem, $01)
                            Case $04
                                msg = ((chr($22) + "Even if I wanted one, I have nothing to light it with.") + chr($22))
                            Case $05
                                msg = ((chr($22) + "Could really go for one now... Wish I had a lighter.") + chr($22))
                            Case $06
                                msg = ((chr($22) + "Don't plan on starting, even at a time like this.") + chr($22))
                                removeitem(selecteditem, $01)
                        End Select
                        selecteditem\Field13 = 1.0
                    Else
                        msg = "You are unable to get lit."
                    EndIf
                    msgtimer = 350.0
                EndIf
            Case "420"
                If (canuseitem($00, $00, $01) <> 0) Then
                    If (wearing714 = $01) Then
                        msg = ((chr($22) + "DUDE WTF THIS SHIT DOESN'T EVEN WORK") + chr($22))
                    Else
                        msg = ((chr($22) + "MAN DATS SUM GOOD ASS SHIT") + chr($22))
                        injuries = max((injuries - 0.5), 0.0)
                        blurtimer = 500.0
                        giveachievement($0C, $01)
                        playsound_strict(loadtempsound("SFX\Music\420J.ogg"))
                        multiplayer_writetempsound("SFX\Music\420J.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 20.0, 1.0)
                    EndIf
                    msgtimer = 350.0
                    removeitem(selecteditem, $01)
                EndIf
            Case "urancandy"
                If (canuseitem($00, $00, $01) <> 0) Then
                    msg = "There's something wrong with your stomach."
                    msgtimer = 420.0
                    vomittimer = 70.0
                    removeitem(selecteditem, $01)
                EndIf
            Case "420s"
                If (canuseitem($00, $00, $01) <> 0) Then
                    If (wearing714 = $01) Then
                        msg = ((chr($22) + "DUDE WTF THIS SHIT DOESN'T EVEN WORK") + chr($22))
                    Else
                        deathmsg = "Subject D-9341 found in a comatose state in [DATA REDACTED]. The subject was holding what appears to be a cigarette while smiling widely. "
                        deathmsg = (deathmsg + "Chemical analysis of the cigarette has been inconclusive, although it seems to contain a high concentration of an unidentified chemical ")
                        deathmsg = (deathmsg + "whose molecular structure is remarkably similar to that of tetrahydrocannabinol.")
                        msg = ((chr($22) + "UH WHERE... WHAT WAS I DOING AGAIN... MAN I NEED TO TAKE A NAP...") + chr($22))
                        kill("was killed by SCP-420", $01)
                    EndIf
                    msgtimer = 420.0
                    removeitem(selecteditem, $01)
                EndIf
            Case "scp714"
                If (wearing714 = $01) Then
                    msg = "You removed the ring."
                    wearing714 = $00
                Else
                    giveachievement($10, $01)
                    msg = "You put on the ring."
                    wearing714 = $01
                EndIf
                msgtimer = 350.0
                selecteditem = Null
            Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
                If (wearingvest = $00) Then
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field8, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field8) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local1 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local2 = ((graphicheight Sar $01) + $50)
                    rect(local1, local2, (local20 + $04), local21, $00)
                    For local4 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + (fpsfactor / 4.0)), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        If (wearinghazmat > $00) Then
                            msg = "You removed the hazmat suit."
                            wearinghazmat = $00
                            dropitem(selecteditem, $01)
                        Else
                            If (selecteditem\Field3\Field2 = "hazmatsuit") Then
                                wearinghazmat = $01
                            ElseIf (selecteditem\Field3\Field2 = "hazmatsuit2") Then
                                wearinghazmat = $02
                            Else
                                wearinghazmat = $03
                            EndIf
                            If (selecteditem\Field3\Field3 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field3\Field3))
                            EndIf
                            msg = "You put on the hazmat suit."
                            If (wearingnightvision <> 0) Then
                                camerafogfar = storedcamerafogfar
                            EndIf
                            wearinggasmask = $00
                            wearingnightvision = $00
                        EndIf
                        selecteditem\Field13 = 0.0
                        msgtimer = 350.0
                        selecteditem = Null
                    EndIf
                EndIf
            Case "vest","finevest"
                currspeed = curvevalue(0.0, currspeed, 5.0)
                drawimage(selecteditem\Field3\Field8, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field8) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                local20 = $12C
                local21 = $14
                local1 = ((graphicwidth Sar $01) - (local20 Sar $01))
                local2 = ((graphicheight Sar $01) + $50)
                rect(local1, local2, (local20 + $04), local21, $00)
                For local4 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                    drawimage(blinkmeterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
                Next
                selecteditem\Field13 = min((selecteditem\Field13 + (fpsfactor / (((Float (selecteditem\Field3\Field2 = "finevest")) * 0.5) + 2.0))), 100.0)
                If (100.0 = selecteditem\Field13) Then
                    If (wearingvest > $00) Then
                        msg = "You removed the vest."
                        wearingvest = $00
                        dropitem(selecteditem, $01)
                    Else
                        If (selecteditem\Field3\Field2 = "vest") Then
                            msg = "You put on the vest and feel slightly encumbered."
                            wearingvest = $01
                        Else
                            msg = "You put on the vest and feel heavily encumbered."
                            wearingvest = $02
                        EndIf
                        If (selecteditem\Field3\Field3 <> $42) Then
                            playsound_strict(picksfx(selecteditem\Field3\Field3))
                        EndIf
                    EndIf
                    selecteditem\Field13 = 0.0
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "gasmask","supergasmask","gasmask3"
                If (((wearing1499 = $00) And (wearinghazmat = $00)) <> 0) Then
                    If (wearinggasmask <> 0) Then
                        msg = "You removed the gas mask."
                    Else
                        If (selecteditem\Field3\Field2 = "supergasmask") Then
                            msg = "You put on the gas mask and you can breathe easier."
                        Else
                            msg = "You put on the gas mask."
                        EndIf
                        If (wearingnightvision <> 0) Then
                            camerafogfar = storedcamerafogfar
                        EndIf
                        wearingnightvision = $00
                        wearinggasmask = $00
                    EndIf
                    If (selecteditem\Field3\Field2 = "gasmask3") Then
                        If (wearinggasmask = $00) Then
                            wearinggasmask = $03
                        Else
                            wearinggasmask = $00
                        EndIf
                    ElseIf (selecteditem\Field3\Field2 = "supergasmask") Then
                        If (wearinggasmask = $00) Then
                            wearinggasmask = $02
                        Else
                            wearinggasmask = $00
                        EndIf
                    Else
                        wearinggasmask = (wearinggasmask = $00)
                    EndIf
                ElseIf (wearing1499 > $00) Then
                    msg = "You need to take off SCP-1499 in order to put on the gas mask."
                Else
                    msg = "You need to take off the hazmat suit in order to put on the gas mask."
                EndIf
                selecteditem = Null
                msgtimer = 350.0
            Case "navigator","nav"
                If (selecteditem\Field3\Field1 = "S-NAV Navigator Ultimate") Then
                    selecteditem\Field13 = 101.0
                EndIf
                If (selecteditem\Field3\Field12 = $00) Then
                    selecteditem\Field3\Field12 = loadimage_strict(selecteditem\Field3\Field11)
                    maskimage(selecteditem\Field3\Field12, $FF, $00, $FF)
                EndIf
                If (100.0 >= selecteditem\Field13) Then
                    selecteditem\Field13 = max(0.0, (selecteditem\Field13 - (fpsfactor * 0.005)))
                EndIf
                local1 = (Int (((Float graphicwidth) - ((Float imagewidth(selecteditem\Field3\Field12)) * 0.5)) + 20.0))
                local2 = (Int (((Float graphicheight) - ((Float imageheight(selecteditem\Field3\Field12)) * 0.4)) - 85.0))
                local20 = $11F
                local21 = $100
                drawimage(selecteditem\Field3\Field12, (local1 - (imagewidth(selecteditem\Field3\Field12) Sar $01)), ((local2 - (imageheight(selecteditem\Field3\Field12) Sar $01)) + $55), $00)
                aasetfont(font3)
                local79 = $01
                If (((playerroom\Field7\Field11 = "pocketdimension") Or (playerroom\Field7\Field11 = "dimension1499")) <> 0) Then
                    local79 = $00
                ElseIf (playerroom\Field7\Field11 = "room860") Then
                    If (1.0 = room860event\Field2) Then
                        local79 = $00
                    EndIf
                EndIf
                If (local79 = $00) Then
                    If ((millisecs2() Mod $3E8) > $12C) Then
                        color($C8, $00, $00)
                        aatext(local1, (((local21 Sar $01) + local2) - $50), "ERROR 06", $01, $00, 1.0)
                        aatext(local1, (((local21 Sar $01) + local2) - $3C), "LOCATION UNKNOWN", $01, $00, 1.0)
                    EndIf
                ElseIf (((1.0 < rnd((coffindistance + 15.0), 0.0)) Or (playerroom\Field7\Field11 <> "coffin")) <> 0) Then
                    local77 = (Int floor((((entityx(playerroom\Field2, $00) + 8.0) / 8.0) + 0.5)))
                    local78 = (Int floor((((entityz(playerroom\Field2, $00) + 8.0) / 8.0) + 0.5)))
                    setbuffer(imagebuffer(navbg, $00))
                    local80 = (local1 - (imagewidth(selecteditem\Field3\Field12) Sar $01))
                    local81 = ((local2 - (imageheight(selecteditem\Field3\Field12) Sar $01)) + $55)
                    drawimage(selecteditem\Field3\Field12, local80, local81, $00)
                    local1 = (Int (((((entityx(collider, $00) - 4.0) + 8.0) Mod 8.0) * 3.0) + (Float (local1 - $0C))))
                    local2 = (Int ((Float (local2 + $0C)) - ((((entityz(collider, $00) - 4.0) + 8.0) Mod 8.0) * 3.0)))
                    For local7 = max(0.0, (Float (local77 - $06))) To min((Float mapwidth), (Float (local77 + $06))) Step 1.0
                        For local9 = max(0.0, (Float (local78 - $06))) To min((Float mapheight), (Float (local78 + $06))) Step 1.0
                            If (((16.0 < coffindistance) Or (coffindistance > rnd(16.0, 0.0))) <> 0) Then
                                If (((maptemp((Int local7), (Int local9)) > $00) And (((mapfound((Int local7), (Int local9)) > $00) Or (selecteditem\Field3\Field1 = "S-NAV 310 Navigator")) Or (selecteditem\Field3\Field1 = "S-NAV Navigator Ultimate"))) <> 0) Then
                                    local82 = (Int ((((Float (local77 - $01)) - local7) * 24.0) + (Float local1)))
                                    local83 = (Int ((Float local2) - (((Float (local78 - $01)) - local9) * 24.0)))
                                    If ((Float mapwidth) >= (local7 + 1.0)) Then
                                        If (maptemp((Int (local7 + 1.0)), (Int local9)) = $00) Then
                                            drawimage(navimages($03), (local82 - $0C), (local83 - $0C), $00)
                                        EndIf
                                    Else
                                        drawimage(navimages($03), (local82 - $0C), (local83 - $0C), $00)
                                    EndIf
                                    If (0.0 <= (local7 - 1.0)) Then
                                        If (maptemp((Int (local7 - 1.0)), (Int local9)) = $00) Then
                                            drawimage(navimages($01), (local82 - $0C), (local83 - $0C), $00)
                                        EndIf
                                    Else
                                        drawimage(navimages($01), (local82 - $0C), (local83 - $0C), $00)
                                    EndIf
                                    If (0.0 <= (local9 - 1.0)) Then
                                        If (maptemp((Int local7), (Int (local9 - 1.0))) = $00) Then
                                            drawimage(navimages($00), (local82 - $0C), (local83 - $0C), $00)
                                        EndIf
                                    Else
                                        drawimage(navimages($00), (local82 - $0C), (local83 - $0C), $00)
                                    EndIf
                                    If ((Float mapheight) >= (local9 + 1.0)) Then
                                        If (maptemp((Int local7), (Int (local9 + 1.0))) = $00) Then
                                            drawimage(navimages($02), (local82 - $0C), (local83 - $0C), $00)
                                        EndIf
                                    Else
                                        drawimage(navimages($02), (local82 - $0C), (local83 - $0C), $00)
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    Next
                    setbuffer(backbuffer())
                    drawimagerect(navbg, (local80 + $50), (local81 + $46), (local80 + $50), (local81 + $46), $10E, $E6, $00)
                    color($1E, $1E, $1E)
                    If (selecteditem\Field3\Field1 = "S-NAV Navigator") Then
                        color($64, $00, $00)
                    EndIf
                    rect((local80 + $50), (local81 + $46), $10E, $E6, $00)
                    local1 = (Int (((Float graphicwidth) - ((Float imagewidth(selecteditem\Field3\Field12)) * 0.5)) + 20.0))
                    local2 = (Int (((Float graphicheight) - ((Float imageheight(selecteditem\Field3\Field12)) * 0.4)) - 85.0))
                    If (selecteditem\Field3\Field1 = "S-NAV Navigator") Then
                        color($64, $00, $00)
                    Else
                        color($1E, $1E, $1E)
                    EndIf
                    If ((millisecs2() Mod $3E8) > $12C) Then
                        If (((selecteditem\Field3\Field1 <> "S-NAV 310 Navigator") And (selecteditem\Field3\Field1 <> "S-NAV Navigator Ultimate")) <> 0) Then
                            aatext(((local1 - (local20 Sar $01)) + $0A), ((local2 - (local21 Sar $01)) + $0A), "MAP DATABASE OFFLINE", $00, $00, 1.0)
                        EndIf
                        local5 = (entityyaw(collider, $00) - 90.0)
                        local84 = (Int ((cos(local5) * 6.0) + (Float local1)))
                        local85 = (Int ((Float local2) - (sin(local5) * 6.0)))
                        local7 = ((cos((local5 - 140.0)) * 5.0) + (Float local1))
                        local8 = ((Float local2) - (sin((local5 - 140.0)) * 5.0))
                        local86 = (Int ((cos((local5 + 140.0)) * 5.0) + (Float local1)))
                        local87 = (Int ((Float local2) - (sin((local5 + 140.0)) * 5.0)))
                        line(local84, local85, (Int local7), (Int local8))
                        line(local84, local85, local86, local87)
                        line((Int local7), (Int local8), local86, local87)
                    EndIf
                    local88 = $00
                    If (((selecteditem\Field3\Field1 = "S-NAV Navigator Ultimate") And ((millisecs2() Mod $258) < $190)) <> 0) Then
                        If (curr173 <> Null) Then
                            local89 = entitydistance(camera, curr173\Field0)
                            local89 = (ceil((local89 / 8.0)) * 8.0)
                            If (32.0 > local89) Then
                                color($64, $00, $00)
                                oval((Int ((Float local1) - (local89 * 3.0))), (Int ((Float (local2 - $07)) - (local89 * 3.0))), (Int ((local89 * 3.0) * 2.0)), (Int ((local89 * 3.0) * 2.0)), $00)
                                aatext(((local1 - (local20 Sar $01)) + $0A), ((local2 - (local21 Sar $01)) + $1E), "SCP-173", $00, $00, 1.0)
                                local88 = (local88 + $01)
                            EndIf
                        EndIf
                        If (curr106 <> Null) Then
                            local89 = entitydistance(camera, curr106\Field0)
                            If (32.0 > local89) Then
                                color($64, $00, $00)
                                oval((Int ((Float local1) - (local89 * 1.5))), (Int ((Float (local2 - $07)) - (local89 * 1.5))), (Int (local89 * 3.0)), (Int (local89 * 3.0)), $00)
                                aatext(((local1 - (local20 Sar $01)) + $0A), (((local2 - (local21 Sar $01)) + $1E) + ($14 * local88)), "SCP-106", $00, $00, 1.0)
                                local88 = (local88 + $01)
                            EndIf
                        EndIf
                        If (curr096 <> Null) Then
                            local89 = entitydistance(camera, curr096\Field0)
                            If (32.0 > local89) Then
                                color($64, $00, $00)
                                oval((Int ((Float local1) - (local89 * 1.5))), (Int ((Float (local2 - $07)) - (local89 * 1.5))), (Int (local89 * 3.0)), (Int (local89 * 3.0)), $00)
                                aatext(((local1 - (local20 Sar $01)) + $0A), (((local2 - (local21 Sar $01)) + $1E) + ($14 * local88)), "SCP-096", $00, $00, 1.0)
                                local88 = (local88 + $01)
                            EndIf
                        EndIf
                        For local90 = Each npcs
                            If (local90\Field5 = $0A) Then
                                local89 = entitydistance(camera, local90\Field0)
                                If (32.0 > local89) Then
                                    If (local90\Field66 = $00) Then
                                        color($64, $00, $00)
                                        oval((Int ((Float local1) - (local89 * 1.5))), (Int ((Float (local2 - $07)) - (local89 * 1.5))), (Int (local89 * 3.0)), (Int (local89 * 3.0)), $00)
                                        aatext(((local1 - (local20 Sar $01)) + $0A), (((local2 - (local21 Sar $01)) + $1E) + ($14 * local88)), "SCP-049", $00, $00, 1.0)
                                        local88 = (local88 + $01)
                                    EndIf
                                EndIf
                                Exit
                            EndIf
                        Next
                        If (playerroom\Field7\Field11 = "coffin") Then
                            If (8.0 > coffindistance) Then
                                local89 = rnd(4.0, 8.0)
                                color($64, $00, $00)
                                oval((Int ((Float local1) - (local89 * 1.5))), (Int ((Float (local2 - $07)) - (local89 * 1.5))), (Int (local89 * 3.0)), (Int (local89 * 3.0)), $00)
                                aatext(((local1 - (local20 Sar $01)) + $0A), (((local2 - (local21 Sar $01)) + $1E) + ($14 * local88)), "SCP-895", $00, $00, 1.0)
                            EndIf
                        EndIf
                    EndIf
                    color($1E, $1E, $1E)
                    If (selecteditem\Field3\Field1 = "S-NAV Navigator") Then
                        color($64, $00, $00)
                    EndIf
                    If (100.0 >= selecteditem\Field13) Then
                        local11 = ((local1 - (local20 Sar $01)) + $C4)
                        local12 = ((local2 - (local21 Sar $01)) + $0A)
                        rect(local11, local12, $50, $14, $00)
                        For local4 = $01 To (Int ceil((selecteditem\Field13 / 10.0))) Step $01
                            drawimage(navimages($04), (((local4 Shl $03) + local11) - $06), (local12 + $04), $00)
                        Next
                        aasetfont(font3)
                    EndIf
                EndIf
            Case "scp1499","super1499"
                If (wearinghazmat > $00) Then
                    msg = "You are not able to wear SCP-1499 and a hazmat suit at the same time."
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
                currspeed = curvevalue(0.0, currspeed, 5.0)
                drawimage(selecteditem\Field3\Field8, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field8) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
                local20 = $12C
                local21 = $14
                local1 = ((graphicwidth Sar $01) - (local20 Sar $01))
                local2 = ((graphicheight Sar $01) + $50)
                rect(local1, local2, (local20 + $04), local21, $00)
                For local4 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                    drawimage(blinkmeterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
                Next
                selecteditem\Field13 = min((selecteditem\Field13 + fpsfactor), 100.0)
                If (100.0 = selecteditem\Field13) Then
                    If (wearing1499 > $00) Then
                        wearing1499 = $00
                        If (selecteditem\Field3\Field3 <> $42) Then
                            playsound_strict(picksfx(selecteditem\Field3\Field3))
                        EndIf
                        For local67 = Each rooms
                            If (local67 = ntf_1499prevroom) Then
                                blinktimer = -1.0
                                ntf_1499x = entityx(collider, $00)
                                ntf_1499y = entityy(collider, $00)
                                ntf_1499z = entityz(collider, $00)
                                positionentity(collider, ntf_1499prevx, (ntf_1499prevy + 0.05), ntf_1499prevz, $00)
                                resetentity(collider)
                                playerroom = local67
                                updatedoors()
                                updaterooms()
                                If (playerroom\Field7\Field11 = "room3storage") Then
                                    If ((-4600.0 * roomscale) > entityy(collider, $00)) Then
                                        For local4 = $00 To $02 Step $01
                                            playerroom\Field32[local4]\Field9 = 2.0
                                            positionentity(playerroom\Field32[local4]\Field4, entityx(playerroom\Field25[(Int playerroom\Field32[local4]\Field10)], $01), (entityy(playerroom\Field25[(Int playerroom\Field32[local4]\Field10)], $01) + 0.2), entityz(playerroom\Field25[(Int playerroom\Field32[local4]\Field10)], $01), $00)
                                            resetentity(playerroom\Field32[local4]\Field4)
                                            playerroom\Field32[local4]\Field10 = (playerroom\Field32[local4]\Field10 + 1.0)
                                            If ((Float playerroom\Field32[local4]\Field12) < playerroom\Field32[local4]\Field10) Then
                                                playerroom\Field32[local4]\Field10 = (Float (playerroom\Field32[local4]\Field12 - $03))
                                            EndIf
                                        Next
                                    EndIf
                                ElseIf (playerroom\Field7\Field11 = "pocketdimension") Then
                                    camerafogcolor(camera, 0.0, 0.0, 0.0)
                                    cameraclscolor(camera, 0.0, 0.0, 0.0)
                                EndIf
                                For local92 = Each rooms
                                    If (local92\Field7\Field11 = "dimension1499") Then
                                        local91 = local92
                                        Exit
                                    EndIf
                                Next
                                For local15 = Each items
                                    local15\Field12 = 0.0
                                    If (((local15\Field3\Field2 = "scp1499") Or (local15\Field3\Field2 = "super1499")) <> 0) Then
                                        If ((entityy(local91\Field2, $00) - 5.0) <= entityy(local15\Field1, $00)) Then
                                            positionentity(local15\Field1, ntf_1499prevx, ((entityy(local15\Field1, $00) - entityy(local91\Field2, $00)) + ntf_1499prevy), ntf_1499prevz, $00)
                                            resetentity(local15\Field1)
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                                local91 = Null
                                shouldentitiesfall = $00
                                playsound_strict(loadtempsound("SFX\SCP\1499\Exit.ogg"))
                                ntf_1499prevx = 0.0
                                ntf_1499prevy = 0.0
                                ntf_1499prevz = 0.0
                                ntf_1499prevroom = Null
                                executeconsolecommand("tfd", $01, $01)
                                Exit
                            EndIf
                        Next
                    Else
                        If (selecteditem\Field3\Field2 = "scp1499") Then
                            wearing1499 = $01
                        Else
                            wearing1499 = $02
                        EndIf
                        If (selecteditem\Field3\Field3 <> $42) Then
                            playsound_strict(picksfx(selecteditem\Field3\Field3))
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
                        For local67 = Each rooms
                            If (local67\Field7\Field11 = "dimension1499") Then
                                blinktimer = -1.0
                                ntf_1499prevroom = playerroom
                                ntf_1499prevx = entityx(collider, $00)
                                ntf_1499prevy = entityy(collider, $00)
                                ntf_1499prevz = entityz(collider, $00)
                                If ((((0.0 = ntf_1499x) And (0.0 = ntf_1499y)) And (0.0 = ntf_1499z)) <> 0) Then
                                    positionentity(collider, (local67\Field3 + (6086.0 * roomscale)), (local67\Field4 + (304.0 * roomscale)), (local67\Field5 + (2292.5 * roomscale)), $00)
                                    rotateentity(collider, 0.0, 90.0, 0.0, $01)
                                Else
                                    positionentity(collider, ntf_1499x, (ntf_1499y + 0.05), ntf_1499z, $00)
                                EndIf
                                resetentity(collider)
                                updatedoors()
                                updaterooms()
                                For local15 = Each items
                                    local15\Field12 = 0.0
                                Next
                                playerroom = local67
                                playsound_strict(loadtempsound("SFX\SCP\1499\Enter.ogg"))
                                ntf_1499x = 0.0
                                ntf_1499y = 0.0
                                ntf_1499z = 0.0
                                If (curr096 <> Null) Then
                                    If (curr096\Field17 <> $00) Then
                                        setstreamvolume_strict(curr096\Field17, 0.0)
                                    EndIf
                                EndIf
                                For local14 = Each events
                                    If (local14\Field0 = "dimension1499") Then
                                        If ((8300.0 * roomscale) < entitydistance(local14\Field1\Field2, collider)) Then
                                            If (5.0 > local14\Field3) Then
                                                local14\Field3 = (local14\Field3 + 1.0)
                                            EndIf
                                        EndIf
                                        Exit
                                    EndIf
                                Next
                                debuglog("In dimension")
                                Exit
                            EndIf
                        Next
                    EndIf
                    selecteditem\Field13 = 0.0
                    selecteditem = Null
                EndIf
            Case "badge"
                If (selecteditem\Field3\Field12 = $00) Then
                    selecteditem\Field3\Field12 = loadimage_strict(selecteditem\Field3\Field11)
                    maskimage(selecteditem\Field3\Field12, $FF, $00, $FF)
                EndIf
                drawimage(selecteditem\Field3\Field12, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field12) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field12) Sar $01)), $00)
                If (0.0 = selecteditem\Field13) Then
                    playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg")))
                    local93 = selecteditem\Field3\Field1
                    If (local93 = "Old Badge") Then
                        msg = ((chr($22) + "Huh? This guy looks just like me!") + chr($22))
                        msgtimer = 700.0
                    EndIf
                    selecteditem\Field13 = 1.0
                EndIf
            Case "key"
                If (0.0 = selecteditem\Field13) Then
                    playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg")))
                    msg = ((chr($22) + "Isn't this the key to that old shack? The one where I... No, it can't be.") + chr($22))
                    msgtimer = 700.0
                EndIf
                selecteditem\Field13 = 1.0
                selecteditem = Null
            Case "oldpaper"
                If (selecteditem\Field3\Field12 = $00) Then
                    selecteditem\Field3\Field12 = loadimage_strict(selecteditem\Field3\Field11)
                    selecteditem\Field3\Field12 = resizeimage2(selecteditem\Field3\Field12, (Int ((Float imagewidth(selecteditem\Field3\Field12)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field12)) * menuscale)))
                    maskimage(selecteditem\Field3\Field12, $FF, $00, $FF)
                EndIf
                drawimage(selecteditem\Field3\Field12, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field12) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field12) Sar $01)), $00)
                If (0.0 = selecteditem\Field13) Then
                    local94 = selecteditem\Field3\Field1
                    If (local94 = "Disciplinary Hearing DH-S-4137-17092") Then
                        blurtimer = 1000.0
                        msg = ((chr($22) + "Why does this seem so familiar?") + chr($22))
                        msgtimer = 700.0
                        playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg")))
                        selecteditem\Field13 = 1.0
                    EndIf
                EndIf
            Case "coin"
                If (0.0 = selecteditem\Field13) Then
                    playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($01, $05))) + ".ogg")))
                EndIf
                msg = ""
                selecteditem\Field13 = 1.0
                drawimage(selecteditem\Field3\Field8, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field8) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field8) Sar $01)), $00)
            Case "scp427"
                If (i_427\Field0 = $01) Then
                    msg = "You closed the locket."
                    i_427\Field0 = $00
                Else
                    giveachievement($0D, $01)
                    msg = "You opened the locket."
                    i_427\Field0 = $01
                EndIf
                msgtimer = 350.0
                selecteditem = Null
            Case "pill"
                If (canuseitem($00, $00, $01) <> 0) Then
                    msg = "You swallowed the pill."
                    msgtimer = 490.0
                    removeitem(selecteditem, $01)
                    selecteditem = Null
                EndIf
            Case "scp500death"
                If (canuseitem($00, $00, $01) <> 0) Then
                    msg = "You swallowed the pill."
                    msgtimer = 490.0
                    If (25200.0 > i_427\Field1) Then
                        i_427\Field1 = 25200.0
                    EndIf
                    removeitem(selecteditem, $01)
                    selecteditem = Null
                EndIf
            Default
                If (getscripts() <> 0) Then
                    public_inqueue($16, $00)
                    public_addparam((Str selecteditem\Field18), $01)
                    callback()
                EndIf
                doubleclick = $00
                mousehit1 = $00
                mousedown1 = $00
                lastmousehit1 = $00
                If (selecteditem\Field19 > $00) Then
                    otheropen = selecteditem
                EndIf
                selecteditem = Null
        End Select
        If (selecteditem <> Null) Then
            If (selecteditem\Field3\Field12 <> $00) Then
                local95 = selecteditem\Field3\Field2
                If (((((local95 = "paper") Or (local95 = "badge")) Or (local95 = "oldpaper")) Or (local95 = "ticket")) <> 0) Then
                    For local96 = Each items
                        If (local96 <> selecteditem) Then
                            local97 = local96\Field3\Field2
                            If (((((local97 = "paper") Or (local97 = "badge")) Or (local97 = "oldpaper")) Or (local97 = "ticket")) <> 0) Then
                                If (local96\Field3\Field12 <> $00) Then
                                    If (local96\Field3\Field12 <> selecteditem\Field3\Field12) Then
                                        freeimage(local96\Field3\Field12)
                                        local96\Field3\Field12 = $00
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
                local95 = selecteditem\Field3\Field2
                If (local95 = "scp1025") Then
                    If (selecteditem\Field3\Field12 <> $00) Then
                        freeimage(selecteditem\Field3\Field12)
                    EndIf
                    selecteditem\Field3\Field12 = $00
                ElseIf ((((((local95 = "firstaid") Or (local95 = "finefirstaid")) Or (local95 = "firstaid2")) Or (local95 = "chicken")) Or (local95 = "boxofammo")) <> 0) Then
                    selecteditem\Field13 = 0.0
                ElseIf (((local95 = "vest") Or (local95 = "finevest")) <> 0) Then
                    selecteditem\Field13 = 0.0
                    If (wearingvest = $00) Then
                        dropitem(selecteditem, $00)
                    EndIf
                ElseIf ((((local95 = "hazmatsuit") Or (local95 = "hazmatsuit2")) Or (local95 = "hazmatsuit3")) <> 0) Then
                    selecteditem\Field13 = 0.0
                    If (wearinghazmat = $00) Then
                        dropitem(selecteditem, $00)
                    EndIf
                ElseIf (((local95 = "scp1499") Or (local95 = "super1499")) <> 0) Then
                    selecteditem\Field13 = 0.0
                EndIf
                If (selecteditem\Field3\Field3 <> $42) Then
                    playsound_strict(picksfx(selecteditem\Field3\Field3))
                EndIf
                selecteditem = Null
            EndIf
        EndIf
    EndIf
    If (selecteditem = Null) Then
        For local4 = $00 To $06 Step $01
            If (radiochn(local4) <> $00) Then
                If (channelplaying(radiochn(local4)) <> 0) Then
                    pausechannel(radiochn(local4))
                EndIf
            EndIf
        Next
    EndIf
    If (stated = $00) Then
        For local15 = Each items
            If (local15 <> selecteditem) Then
                Select local15\Field3\Field2
                    Case "firstaid","finefirstaid","firstaid2","vest","finevest","hazmatsuit","hazmatsuit2","hazmatsuit3","scp1499","super1499","chicken","boxofammo"
                        local15\Field13 = 0.0
                End Select
            EndIf
        Next
        stated = $01
    EndIf
    If ((local28 And (invopen = $00)) <> 0) Then
        movemouse(viewport_center_x, viewport_center_y)
    EndIf
    Return $00
End Function
