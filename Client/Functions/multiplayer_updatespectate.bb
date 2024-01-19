Function multiplayer_updatespectate%()
    Local local0%
    Local local1.rooms
    Local local2%
    Local local3%
    Local local4#
    Local local5#
    Local local6#
    Local local8#
    Local local9#
    Local local10.breachtypes
    If (spectate\Field1 <> $FFFFFFFF) Then
        If (menuopen = $00) Then
            local0 = spectate\Field1
            If (((((((((((((menuopen = $00) And (invopen = $00)) And (otheropen = Null)) And (selecteddoor = Null)) And (consoleopen = $00)) And (lockmouse = $00)) And (using294 = $00)) And (selectedscreen = Null)) And (0.0 <= endingtimer)) And (networkserver\Field27 = $00)) And ((tab_menu_state > $01) = $00)) Or mainmenuopen) <> 0) Then
                If (mousehit1 <> 0) Then
                    spectate\Field1 = findspectateplayer($00)
                EndIf
                If (mousehit2 <> 0) Then
                    spectate\Field1 = findspectateplayer($01)
                EndIf
            EndIf
            If (local0 <> spectate\Field1) Then
                If (player[spectate\Field1] <> Null) Then
                    positionentity(collider, entityx(player[spectate\Field1]\Field12, $00), (entityy(player[spectate\Field1]\Field12, $00) + 1.0), entityz(player[spectate\Field1]\Field12, $00), $00)
                    For local1 = Each rooms
                        If (local1\Field65 = player[spectate\Field1]\Field47) Then
                            playerroom = local1
                            Exit
                        EndIf
                    Next
                    resetentity(collider)
                EndIf
            EndIf
        EndIf
        If (wearingnightvision <> 0) Then
            camerafogfar = storedcamerafogfar
            wearingnightvision = $00
        EndIf
        myplayer\Field33 = $01
        For local2 = $00 To $05 Step $01
            scp1025state[local2] = 0.0
        Next
        superman = $00
        supermantimer = 0.0
        dropspeed = -0.1
        headdropspeed = 0.0
        shake = 0.0
        currspeed = 0.0
        heartbeatvolume = 0.0
        shake = 0.0
        lightflash = 0.0
        blurtimer = 0.0
        falltimer = 0.0
        godmode = $01
        noclip = $00
        hideentity(collider)
        killtimer = 0.0
        killanim = $00
        injuries = 0.0
        bloodloss = 0.0
        invopen = $00
        wearinghazmat = $00
        wearinggasmask = $00
        wearingnightvision = $00
        wearing714 = $00
        wearing1499 = $00
        using294 = $00
        hideentity(gasmaskoverlay)
        hideentity(nvoverlay)
        hideentity(infectoverlay)
        hideentity(dark)
        myplayer\Field51 = $00
        hideentity(head)
        If (keyhit($13) <> 0) Then
            spectate\Field0 = ((spectate\Field0 + $01) Mod $03)
            If (player[spectate\Field1] <> Null) Then
                If (player[spectate\Field1]\Field12 <> $00) Then
                    If (spectate\Field0 = $00) Then
                        showentity(player[spectate\Field1]\Field12)
                    ElseIf (spectate\Field0 = $01) Then
                        hideentity(player[spectate\Field1]\Field12)
                    Else
                        showentity(player[spectate\Field1]\Field12)
                    EndIf
                EndIf
            EndIf
            mp_instructionsdone = $01
            putinivalue(optionfile, "options", "mp instructions", "1")
        EndIf
        If (spectate\Field0 < $02) Then
            If (player[spectate\Field1] <> Null) Then
                For local1 = Each rooms
                    If (local1\Field65 = player[spectate\Field1]\Field47) Then
                        playerroom = local1
                        Exit
                    EndIf
                Next
                If (player[spectate\Field1]\Field51 = $00) Then
                    spectate\Field1 = findspectateplayer($00)
                    spectate\Field1 = findspectateplayer($01)
                EndIf
            Else
                spectate\Field1 = findspectateplayer($00)
                spectate\Field1 = findspectateplayer($01)
                Return $00
            EndIf
        EndIf
        camerazoom(camera, (1.0 / tan(((atan((tan((currentfov / 2.0)) * ((Float realgraphicwidth) / (Float realgraphicheight)))) * 2.0) / 2.0))))
        Select spectate\Field0
            Case $00
                If (player[spectate\Field1] <> Null) Then
                    If (player[spectate\Field1]\Field12 <> $00) Then
                        local4 = entityx(player[spectate\Field1]\Field12, $00)
                        local5 = entityy(player[spectate\Field1]\Field12, $00)
                        local6 = entityz(player[spectate\Field1]\Field12, $00)
                        If (((((((((((((menuopen = $00) And (invopen = $00)) And (otheropen = Null)) And (selecteddoor = Null)) And (consoleopen = $00)) And (lockmouse = $00)) And (using294 = $00)) And (selectedscreen = Null)) And (0.0 <= endingtimer)) And (networkserver\Field27 = $00)) And ((tab_menu_state > $01) = $00)) Or mainmenuopen) <> 0) Then
                            local8 = (((Float mousexspeed()) * 0.2) * (mousesens + 0.6))
                            local9 = (((Float mouseyspeed()) * 0.2) * (mousesens + 0.6))
                            movemouse((graphicwidth Sar $01), (graphicheight Sar $01))
                            local3 = $01
                        EndIf
                        spectate\Field4 = (spectate\Field4 + local9)
                        spectate\Field4 = (Float clampvalue(spectate\Field4, -40.0, 40.0))
                        spectate\Field5 = (spectate\Field5 - local8)
                        spectate\Field2 = ((spectate\Field4 - spectate\Field2) + spectate\Field2)
                        spectate\Field3 = ((spectate\Field5 - spectate\Field3) + spectate\Field3)
                        rotateentity(camera, spectate\Field2, spectate\Field3, 0.0, $00)
                        rotateentity(collider, 0.0, spectate\Field3, 0.0, $00)
                        local4 = ((sin((- entityyaw(camera, $00))) * -1.0) + local4)
                        local6 = ((cos((- entityyaw(camera, $00))) * -1.0) + local6)
                        local5 = ((tan((- entitypitch(camera, $00))) * -1.0) + local5)
                        positionentity(camera, local4, (local5 + 1.0), local6, $00)
                        positionentity(collider, local4, (local5 + 1.0), local6, $00)
                        resetentity(collider)
                    EndIf
                EndIf
            Case $01
                If (player[spectate\Field1] <> Null) Then
                    If (player[spectate\Field1]\Field12 <> $00) Then
                        local4 = entityx(player[spectate\Field1]\Field12, $00)
                        local5 = entityy(player[spectate\Field1]\Field12, $00)
                        local6 = entityz(player[spectate\Field1]\Field12, $00)
                        local10 = getbreachtype(player[spectate\Field1]\Field51)
                        If (player[spectate\Field1]\Field51 <> model_173) Then
                            positionentity(camera, entityx(getplayerhead(spectate\Field1), $01), entityy(getplayerhead(spectate\Field1), $01), entityz(getplayerhead(spectate\Field1), $01), $00)
                            If (0.0 <> local10\Field53) Then
                                rotateentity(camera, player[spectate\Field1]\Field10, entityyaw(player[spectate\Field1]\Field13, $00), player[spectate\Field1]\Field98, $00)
                            Else
                                rotateentity(camera, player[spectate\Field1]\Field10, entityyaw(player[spectate\Field1]\Field13, $00), flipvalue(player[spectate\Field1]\Field98), $00)
                            EndIf
                        Else
                            positionentity(camera, entityx(player[spectate\Field1]\Field12, $00), (entityy(player[spectate\Field1]\Field12, $00) + (player[spectate\Field1]\Field92 * 1.0)), entityz(player[spectate\Field1]\Field12, $00), $00)
                            rotateentity(camera, player[spectate\Field1]\Field5, entityyaw(player[spectate\Field1]\Field13, $00), 0.0, $00)
                        EndIf
                        positionentity(collider, local4, (local5 + 1.0), local6, $00)
                        resetentity(collider)
                        hideentity(player[spectate\Field1]\Field12)
                        If (player[spectate\Field1]\Field42\Field8 <> $00) Then
                            hideentity(player[spectate\Field1]\Field42\Field8)
                        EndIf
                        hideentity(player[spectate\Field1]\Field42\Field6)
                        hideentity(player[spectate\Field1]\Field42\Field5)
                        hideentity(player[spectate\Field1]\Field42\Field4)
                        For local2 = $01 To $0F Step $01
                            hideentity(player[spectate\Field1]\Field42\Field7[local2])
                        Next
                    EndIf
                EndIf
            Case $02
                If (((((((((((((menuopen = $00) And (invopen = $00)) And (otheropen = Null)) And (selecteddoor = Null)) And (consoleopen = $00)) And (lockmouse = $00)) And (using294 = $00)) And (selectedscreen = Null)) And (0.0 <= endingtimer)) And (networkserver\Field27 = $00)) And ((tab_menu_state > $01) = $00)) Or mainmenuopen) <> 0) Then
                    local8 = (((Float mousexspeed()) * 0.2) * (mousesens + 0.6))
                    local9 = (((Float mouseyspeed()) * 0.2) * (mousesens + 0.6))
                    movemouse((graphicwidth Sar $01), (graphicheight Sar $01))
                    If (keybuffer(key_down) <> 0) Then
                        moveentity(collider, 0.0, 0.0, ((- (max(((Float keybuffer(key_sprint)) * 2.5), 1.0) * 0.036)) * fpsfactor))
                    EndIf
                    If (keybuffer(key_up) <> 0) Then
                        moveentity(collider, 0.0, 0.0, ((max(((Float keybuffer(key_sprint)) * 2.5), 1.0) * 0.036) * fpsfactor))
                    EndIf
                    If (keybuffer(key_left) <> 0) Then
                        moveentity(collider, ((- (max(((Float keybuffer(key_sprint)) * 2.5), 1.0) * 0.036)) * fpsfactor), 0.0, 0.0)
                    EndIf
                    If (keybuffer(key_right) <> 0) Then
                        moveentity(collider, ((max(((Float keybuffer(key_sprint)) * 2.5), 1.0) * 0.036) * fpsfactor), 0.0, 0.0)
                    EndIf
                    local3 = $01
                EndIf
                spectate\Field4 = (spectate\Field4 + local9)
                spectate\Field4 = (Float clampvalue(spectate\Field4, -80.0, 80.0))
                spectate\Field5 = (spectate\Field5 - local8)
                spectate\Field2 = ((spectate\Field4 - spectate\Field2) + spectate\Field2)
                spectate\Field3 = ((spectate\Field5 - spectate\Field3) + spectate\Field3)
                rotateentity(camera, spectate\Field2, spectate\Field3, 0.0, $00)
                rotateentity(collider, spectate\Field2, spectate\Field3, 0.0, $00)
                positionentity(camera, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                resetentity(collider)
        End Select
        If (local3 = $00) Then
            mousexspeed()
            mouseyspeed()
            mousezspeed()
        EndIf
    EndIf
    Return $00
End Function
