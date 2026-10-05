Function mouselook%(arg0%)
    Local local0%
    Local local1.breachtypes
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10%
    Local local11%
    Local local12%
    Local local13#
    Local local14#
    Local local15%
    Local local16#
    Local local17#
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local24%
    Local local25.particles
    local1 = getbreachtype(myplayer\Field49)
    setcamerazoom(currentfov, shouldforcefov)
    If (rawmouseinput <> 0) Then
        mouselook_x_inc = (win\Field12 * 0.3)
        mouselook_y_inc = (win\Field13 * 0.3)
    Else
        mouselook_x_inc = 0.3
        mouselook_y_inc = 0.3
    EndIf
    local2 = entityx(collider, $01)
    local3 = entityy(collider, $01)
    local4 = entityz(collider, $01)
    local5 = entityx(camera, $01)
    local6 = entityy(camera, $01)
    local7 = entityz(camera, $01)
    If (((0.0 <= killtimer) And (0.0 <= falltimer)) <> 0) Then
        headdropspeed = 0.0
        local8 = ((fastsin((Int shake)) / ((crouchstate * 20.0) + 20.0)) * 0.6)
        local9 = max(min(((fastsin((Int (shake * 0.5))) * 2.5) * min((injuries + 0.25), 3.0)), 8.0), -8.0)
        local10 = $00
        If (((networkserver\Field19 Or consoleopen) Or menuopen) = $00) Then
            If (eqquipedgun <> Null) Then
                local11 = keydown(key_leanl)
                local12 = keydown(key_leanr)
                local13 = 0.0
                local14 = 0.0
                local15 = $00
                If (local11 <> 0) Then
                    local13 = 15.0
                    local14 = -0.2
                ElseIf (local12 <> 0) Then
                    local13 = -15.0
                    local14 = 0.2
                EndIf
                If (0.0 <> local13) Then
                    tformvector(2.0, 0.0, 0.0, camera, $00)
                    If (linepick(local2, (local3 + 0.04), local4, (tformedx() * local14), 0.0, (tformedz() * local14), 0.0) = $00) Then
                        local15 = $01
                    EndIf
                EndIf
                If (local15 <> 0) Then
                    gunroll = curvevalue(local13, gunroll, 10.0)
                    side = curvevalue(local14, side, 10.0)
                    local10 = $01
                Else
                    gunroll = curvevalue(0.0, gunroll, 5.0)
                    side = curvevalue(0.0, side, 5.0)
                    If (((-0.01 <= gunroll) And (0.01 >= gunroll)) <> 0) Then
                        gunroll = 0.0
                    EndIf
                EndIf
            Else
                gunroll = curvevalue(0.0, gunroll, 5.0)
                side = curvevalue(0.0, side, 5.0)
                If (((-0.01 <= gunroll) And (0.01 >= gunroll)) <> 0) Then
                    gunroll = 0.0
                EndIf
            EndIf
        EndIf
        local16 = (local1\Field37 + local3)
        local17 = ((local9 * 0.5) + gunroll)
        local18 = ((local8 + 0.6) + ((myplayer\Field90 * crouchstate) * -0.3))
        local19 = (((myplayer\Field90 - 1.0) + local16) + local18)
        positionentity(camera, local2, local19, local4, $00)
        rotateentity(camera, 0.0, entityyaw(collider, $00), local17, $00)
        moveentity(camera, side, 0.0, 0.0)
        If (arg0 <> 0) Then
            local20 = (mousesens + 0.6)
            If ((Int mousesmooth) <> 0) Then
                local21 = ((6.0 / (mousesens + 1.0)) * mousesmooth)
                mouse_x_speed_1 = curvevalue(((Float mousexspeed()) * local20), mouse_x_speed_1, local21)
                mouse_y_speed_1 = curvevalue(((Float mouseyspeed()) * local20), mouse_y_speed_1, local21)
            Else
                mouse_x_speed_1 = ((Float mousexspeed()) * local20)
                mouse_y_speed_1 = ((Float mouseyspeed()) * local20)
            EndIf
            user_camera_pitch = ((mouse_y_speed_1 * mouselook_y_inc) + user_camera_pitch)
            user_camera_pitch = f_clamp(user_camera_pitch, -70.0, 70.0)
            local22 = ((mouse_x_speed_1 * mouselook_x_inc) + mouse_x_recoil)
            turnentity(collider, 0.0, (- local22), 0.0, $00)
            updaterecoil()
        EndIf
        local23 = (user_camera_pitch - recoil)
        rotateentity(camera, (rnd((- camerashake), camerashake) + local23), (entityyaw(collider, $00) + rnd((- camerashake), camerashake)), local17, $00)
        If (menuopen <> $01) Then
            If (playerroom\Field8\Field11 = "pocketdimension") Then
                If ((((1.0 / 0.128) > local3) Or (10.1875 < local3)) <> 0) Then
                    rotateentity(camera, wrapangle(entitypitch(camera, $00)), wrapangle(entityyaw(camera, $00)), (wrapangle((sin(((Float millisecs()) * (1.0 / 150.0))) * 30.0)) + local9), $00)
                EndIf
            EndIf
        EndIf
    Else
        hideentity(collider)
        positionentity(camera, entityx(head, $00), entityy(head, $00), entityz(head, $00), $00)
        collidedfloor = $00
        For local0 = $01 To countcollisions(head) Step $01
            If ((entityy(head, $00) - 0.01) > collisiony(head, local0)) Then
                collidedfloor = $01
            EndIf
        Next
        If (collidedfloor = $01) Then
            headdropspeed = 0.0
        Else
            If (killanim = $00) Then
                moveentity(head, 0.0, 0.0, headdropspeed)
                rotateentity(head, curveangle(-90.0, entitypitch(head, $00), 20.0), entityyaw(head, $00), entityroll(head, $00), $00)
                rotateentity(camera, curveangle((entitypitch(head, $00) - 40.0), entitypitch(camera, $00), 40.0), entityyaw(camera, $00), entityroll(camera, $00), $00)
            Else
                moveentity(head, 0.0, 0.0, (- headdropspeed))
                rotateentity(head, curveangle(90.0, entitypitch(head, $00), 20.0), entityyaw(head, $00), entityroll(head, $00), $00)
                rotateentity(camera, curveangle((entitypitch(head, $00) + 40.0), entitypitch(camera, $00), 40.0), entityyaw(camera, $00), entityroll(camera, $00), $00)
            EndIf
            headdropspeed = (headdropspeed - (0.002 * fpsfactor))
        EndIf
        If (invertmouse <> 0) Then
            turnentity(camera, (((Float (- mouseyspeed())) * 0.05) * fpsfactor), (((Float (- mousexspeed())) * 0.15) * fpsfactor), 0.0, $00)
        Else
            turnentity(camera, (((Float mouseyspeed()) * 0.05) * fpsfactor), (((Float (- mousexspeed())) * 0.15) * fpsfactor), 0.0, $00)
        EndIf
    EndIf
    If (particleamount = $02) Then
        If (rand($23, $01) = $01) Then
            local24 = createpivot($00)
            positionentity(local24, local5, local6, local7, $00)
            rotateentity(local24, 0.0, rnd(360.0, 0.0), 0.0, $00)
            If (rand($02, $01) = $01) Then
                moveentity(local24, 0.0, rnd(-0.5, 0.5), rnd(0.5, 1.0))
            Else
                moveentity(local24, 0.0, rnd(-0.5, 0.5), rnd(0.5, 1.0))
            EndIf
            local25 = createparticle(entityx(local24, $00), entityy(local24, $00), entityz(local24, $00), $02, 0.002, 0.0, $12C, 1.0, $01)
            local25\Field6 = 0.001
            rotateentity(local25\Field1, rnd(-20.0, 20.0), rnd(360.0, 0.0), 0.0, $00)
            local25\Field13 = -0.00001
            freeentity(local24)
        EndIf
    EndIf
    If (arg0 <> 0) Then
        movemouse(viewport_center_x, viewport_center_y)
    Else
        resetmouse()
    EndIf
    If (((wearinggasmask Or wearinghazmat) Or wearing1499) <> 0) Then
        If (wearing714 = $00) Then
            If ((((wearinggasmask = $02) Or (wearing1499 = $02)) Or (wearinghazmat = $02)) <> 0) Then
                stamina = min(100.0, ((((100.0 - stamina) * 0.01) * fpsfactor) + stamina))
            EndIf
        EndIf
        If (wearinghazmat = $01) Then
            stamina = min(80.0, stamina)
        EndIf
        If (overlaysenabled <> 0) Then
            showentity(gasmaskoverlay)
        EndIf
    ElseIf (overlaysenabled <> 0) Then
        hideentity(gasmaskoverlay)
    EndIf
    If ((wearingnightvision = $00) = $00) Then
        showentity(nvoverlay)
        If (wearingnightvision = $02) Then
            entitycolor(nvoverlay, 0.0, 100.0, 255.0)
            ambientlightrooms($0F)
        ElseIf (wearingnightvision = $03) Then
            entitycolor(nvoverlay, 255.0, 0.0, 0.0)
            ambientlightrooms($0F)
        Else
            entitycolor(nvoverlay, 0.0, 255.0, 0.0)
            ambientlightrooms($0F)
        EndIf
        If (overlaysenabled <> 0) Then
            entitytexture(fog, fognvtexture, $00, $00)
            showentity(fog)
        EndIf
    Else
        ambientlightrooms($00)
        hideentity(nvoverlay)
        If (overlaysenabled <> 0) Then
            entitytexture(fog, fogtexture, $00, $00)
            showentity(fog)
        EndIf
    EndIf
    If (iscoopmode() <> 0) Then
        For local0 = $00 To $05 Step $01
            If (0.0 < scp1025state[local0]) Then
                Select local0
                    Case $00
                        If (0.0 < fpsfactor) Then
                            If (rand($3E8, $01) = $01) Then
                                If (coughchn = $00) Then
                                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                                ElseIf (channelplaying(coughchn) = $00) Then
                                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                                EndIf
                                multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                            EndIf
                        EndIf
                        stamina = (stamina - (fpsfactor * 0.3))
                    Case $01
                        If (((rand($2328, $01) = $01) And (msg = "")) <> 0) Then
                            setmsg("Your skin is feeling itchy.")
                        EndIf
                    Case $02
                        If (0.0 < fpsfactor) Then
                            If (rand($320, $01) = $01) Then
                                If (coughchn = $00) Then
                                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                                ElseIf (channelplaying(coughchn) = $00) Then
                                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                                EndIf
                                multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                            EndIf
                        EndIf
                        stamina = (stamina - (fpsfactor * 0.1))
                    Case $03
                        If ((i_427\Field0 And (25200.0 > i_427\Field1)) = $00) Then
                            scp1025state[local0] = ((fpsfactor * 0.0005) + scp1025state[local0])
                        EndIf
                        If (20.0 < scp1025state[local0]) Then
                            If (20.0 >= (scp1025state[local0] - fpsfactor)) Then
                                setmsg("The pain in your stomach is becoming unbearable.")
                            EndIf
                            stamina = (stamina - (fpsfactor * 0.3))
                        ElseIf (10.0 < scp1025state[local0]) Then
                            If (10.0 >= (scp1025state[local0] - fpsfactor)) Then
                                setmsg("Your stomach is aching.")
                            EndIf
                        EndIf
                    Case $04
                        If (35.0 > stamina) Then
                            If (rand((Int ((stamina * 8.0) + 140.0)), $01) = $01) Then
                                If (coughchn = $00) Then
                                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                                ElseIf (channelplaying(coughchn) = $00) Then
                                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                                EndIf
                            EndIf
                            multiplayer_writesound(coughsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                            currspeed = curvevalue(0.0, currspeed, ((stamina * 15.0) + 10.0))
                        EndIf
                    Case $05
                        If ((i_427\Field0 And (25200.0 > i_427\Field1)) = $00) Then
                            scp1025state[local0] = ((fpsfactor * 0.35) + scp1025state[local0])
                        EndIf
                        If (110.0 < scp1025state[local0]) Then
                            heartbeatrate = 0.0
                            blurtimer = max(blurtimer, 500.0)
                            If (140.0 < scp1025state[local0]) Then
                                deathmsg = (chr($22) + "He died of a cardiac arrest after reading SCP-1025, that's for sure. Is there such a thing as psychosomatic cardiac arrest, or does SCP-1025 have some ")
                                deathmsg = ((deathmsg + "anomalous properties we are not yet aware of?") + chr($22))
                                kill("died of a cardiac arrest", $00)
                            EndIf
                        Else
                            heartbeatrate = max(heartbeatrate, (70.0 + scp1025state[local0]))
                            heartbeatvolume = 1.0
                        EndIf
                End Select
            EndIf
        Next
    EndIf
    Return $00
End Function
