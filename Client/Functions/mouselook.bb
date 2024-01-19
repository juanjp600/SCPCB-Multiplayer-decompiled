Function mouselook%(arg0%)
    Local local0%
    Local local1.breachtypes
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    Local local7%
    Local local8#
    Local local9#
    Local local10%
    Local local11.particles
    local1 = getbreachtype(myplayer\Field51)
    camerazoom(camera, (min(((currcamerazoom / 400.0) + 1.0), 1.1) / tan(((atan((tan((currentfov / 2.0)) * ((Float realgraphicwidth) / (Float realgraphicheight)))) * 2.0) / 2.0))))
    currcamerazoom = max((currcamerazoom - fpsfactor), 0.0)
    If (((0.0 <= killtimer) And (0.0 <= falltimer)) <> 0) Then
        headdropspeed = 0.0
        local2 = 0.0
        local3 = (0.0 / local2)
        If ((Int entityx(collider, $00)) = (Int local3)) Then
            positionentity(collider, entityx(camera, $01), (entityy(camera, $01) - 0.5), entityz(camera, $01), $01)
            msg = ("EntityX(Collider) = NaN, RESETTING COORDINATES    -    New coordinates: " + (Str entityx(collider, $00)))
            msgtimer = 300.0
        EndIf
        local4 = ((sin(shake) / ((crouchstate * 20.0) + 20.0)) * 0.6)
        local5 = max(min(((sin((shake / 2.0)) * 2.5) * min((injuries + 0.25), 3.0)), 8.0), -8.0)
        local6 = $00
        If (getmillisecs($00) <> 0) Then
            If (eqquipedgun <> Null) Then
                If (eqquipedgun\Field0 <= $0A) Then
                    If (keydown(key_leanl) <> 0) Then
                        local7 = createpivot($00)
                        positionentity(local7, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                        rotateentity(local7, entitypitch(camera, $00), (entityyaw(camera, $00) + 90.0), 0.0, $00)
                        If (entitypick(local7, 0.3) = $00) Then
                            gunroll = curvevalue(15.0, gunroll, 7.0)
                            local6 = $01
                        EndIf
                        freeentity(local7)
                    EndIf
                    If (keydown(key_leanr) <> 0) Then
                        local7 = createpivot($00)
                        positionentity(local7, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                        rotateentity(local7, entitypitch(camera, $00), (entityyaw(camera, $00) - 90.0), 0.0, $00)
                        If (entitypick(local7, 0.3) = $00) Then
                            gunroll = curvevalue(-15.0, gunroll, 7.0)
                            local6 = $01
                        EndIf
                        freeentity(local7)
                    EndIf
                EndIf
            EndIf
        EndIf
        If (local6 = $00) Then
            gunroll = curvevalue(0.0, gunroll, 7.0)
            If (((-0.01 <= gunroll) And (0.01 >= gunroll)) <> 0) Then
                gunroll = 0.0
            EndIf
        EndIf
        positionentity(camera, entityx(collider, $00), (entityy(collider, $00) + local1\Field37), entityz(collider, $00), $00)
        rotateentity(camera, 0.0, entityyaw(collider, $00), ((local5 * 0.5) + (gunroll / 1.0)), $00)
        moveentity(camera, side, ((local4 + 0.6) + ((myplayer\Field92 * crouchstate) * -0.3)), 0.0)
        If (1.0 <> myplayer\Field92) Then
            If (1.0 <= myplayer\Field92) Then
                moveentity(camera, 0.0, (myplayer\Field92 - 1.0), 0.0)
            Else
                moveentity(camera, 0.0, (- (1.0 - myplayer\Field92)), 0.0)
            EndIf
        EndIf
        If (arg0 <> 0) Then
            mouse_x_speed_1 = curvevalue(((mousesens + 0.6) * (Float mousexspeed())), mouse_x_speed_1, ((6.0 / (mousesens + 1.0)) * mousesmooth))
            mouse_x_recoil = curvevalue(getrecoilpattern(0.0), mouse_x_recoil, 10.0)
            If ((Int mouse_x_speed_1) = (Int local3)) Then
                mouse_x_speed_1 = 0.0
            EndIf
            If (invertmouse <> 0) Then
                If (isgunshooting() <> 0) Then
                    mouse_y_recoil = curvevalue(getrecoilforce(), mouse_y_recoil, 10.0)
                Else
                    mouse_y_recoil = 0.0
                EndIf
                mouse_y_speed_1 = curvevalue(((mousesens + 0.6) * (Float (- mouseyspeed()))), mouse_y_speed_1, ((6.0 / (mousesens + 1.0)) * mousesmooth))
            Else
                If (isgunshooting() <> 0) Then
                    mouse_y_recoil = curvevalue((- getrecoilforce()), mouse_y_recoil, 10.0)
                Else
                    mouse_y_recoil = 0.0
                EndIf
                mouse_y_speed_1 = curvevalue(((mousesens + 0.6) * (Float mouseyspeed())), mouse_y_speed_1, ((6.0 / (mousesens + 1.0)) * mousesmooth))
            EndIf
            If ((Int mouse_y_speed_1) = (Int local3)) Then
                mouse_y_speed_1 = 0.0
            EndIf
            local8 = (((mouse_x_speed_1 * mouselook_x_inc) / ((Float (wearingvest / (networkserver\Field15 + $01))) + 1.0)) + mouse_x_recoil)
            local9 = (((mouse_y_speed_1 * mouselook_y_inc) / ((Float (wearingvest / (networkserver\Field15 + $01))) + 1.0)) + mouse_y_recoil)
            turnentity(collider, 0.0, (- local8), 0.0, $00)
            user_camera_pitch = (user_camera_pitch + local9)
            updaterecoil()
        EndIf
        If (70.0 < user_camera_pitch) Then
            user_camera_pitch = 70.0
        EndIf
        If (-70.0 > user_camera_pitch) Then
            user_camera_pitch = -70.0
        EndIf
        rotateentity(camera, wrapangle((rnd((- camerashake), camerashake) + user_camera_pitch)), wrapangle((entityyaw(collider, $00) + rnd((- camerashake), camerashake))), (local5 + gunroll), $00)
        If (playerroom\Field7\Field11 = "pocketdimension") Then
            If ((((2000.0 * roomscale) > entityy(collider, $00)) Or ((2608.0 * roomscale) < entityy(collider, $00))) <> 0) Then
                rotateentity(camera, wrapangle(entitypitch(camera, $00)), wrapangle(entityyaw(camera, $00)), (wrapangle((sin(((Float millisecs2()) / 150.0)) * 30.0)) + local5), $00)
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
            local10 = createpivot($00)
            positionentity(local10, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $00)
            rotateentity(local10, 0.0, rnd(360.0, 0.0), 0.0, $00)
            If (rand($02, $01) = $01) Then
                moveentity(local10, 0.0, rnd(-0.5, 0.5), rnd(0.5, 1.0))
            Else
                moveentity(local10, 0.0, rnd(-0.5, 0.5), rnd(0.5, 1.0))
            EndIf
            local11 = createparticle(entityx(local10, $00), entityy(local10, $00), entityz(local10, $00), $02, 0.002, 0.0, $12C)
            local11\Field9 = 0.001
            rotateentity(local11\Field1, rnd(-20.0, 20.0), rnd(360.0, 0.0), 0.0, $00)
            local11\Field16 = -0.00001
            freeentity(local10)
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
            stamina = min(60.0, stamina)
        EndIf
        showentity(gasmaskoverlay)
    Else
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
        entitytexture(fog, fognvtexture, $00, $00)
    Else
        ambientlightrooms($00)
        hideentity(nvoverlay)
        entitytexture(fog, fogtexture, $00, $00)
    EndIf
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
                        msg = "Your skin is feeling itchy."
                        msgtimer = 280.0
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
                            msg = "The pain in your stomach is becoming unbearable."
                            msgtimer = 280.0
                        EndIf
                        stamina = (stamina - (fpsfactor * 0.3))
                    ElseIf (10.0 < scp1025state[local0]) Then
                        If (10.0 >= (scp1025state[local0] - fpsfactor)) Then
                            msg = "Your stomach is aching."
                            msgtimer = 280.0
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
    Return $00
End Function
