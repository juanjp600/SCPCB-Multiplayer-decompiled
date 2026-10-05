Function moveplayer%(arg0%)
    Local local0#
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local9.breachtypes
    Local local10%
    Local local11$
    Local local12#
    Local local13%
    Local local14#
    Local local15#
    Local local16#
    Local local17%
    Local local18%
    Local local19%
    Local local20#
    Local local22%
    Local local23%
    Local local24#
    Local local25#
    Local local26#
    Local local27%
    Local local28%
    Local local29%
    Local local30.decals
    Local local31#
    Local local32%
    Local local33%
    local0 = 1.0
    local1 = 0.018
    local3 = wearingvest
    local4 = wearing714
    local5 = entityx(collider, $00)
    local6 = entityy(collider, $00)
    local7 = entityz(collider, $00)
    local8 = (Int playerroom\Field8\Field11)
    If (spectate\Field1 <> $FFFFFFFF) Then
        Return $00
    EndIf
    If (myplayer\Field49 = model_106) Then
        currstepsfx = $01
    EndIf
    local9 = getbreachtype(myplayer\Field49)
    local10 = myplayer\Field49
    If (superman <> 0) Then
        local1 = ((Float (((myplayer\Field49 = model_173) * $05) + $03)) * local1)
        If (((local10 <> model_173) And (local10 <> model_096)) <> 0) Then
            supermantimer = (supermantimer + fpsfactor)
            camerashake = fastsin((Int (supermantimer * 0.2)))
            blurtimer = 500.0
            If (3500.0 < supermantimer) Then
                deathmsg = "A Class D jumpsuit found in [DATA REDACTED]. Upon further examination, the jumpsuit was found to be filled with 12.5 kilograms of blue ash-like substance. "
                deathmsg = (deathmsg + "Chemical analysis of the substance remains non-conclusive.")
                kill("was killed by SCP-914", $00)
                blurtimer = 5000.0
                camerashake = 1000.0
                superman = $00
                local11 = (("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")
                playsound_strict(loadtempsound(local11))
                multiplayer_writetempsound(local11, 0.0, 0.0, 0.0, 10.0, 1.0)
                If (overlaysenabled <> 0) Then
                    showentity(fog)
                EndIf
            Else
                hideentity(fog)
            EndIf
        Else
            blurtimer = 0.0
        EndIf
    EndIf
    If (local10 = model_173) Then
        shake = 0.0
        camerashake = 0.0
    EndIf
    If (0.0 < deathtimer) Then
        deathtimer = (deathtimer - fpsfactor)
        If (1.0 > deathtimer) Then
            deathtimer = -1.0
        EndIf
    ElseIf (0.0 > deathtimer) Then
        kill("was killed", $00)
    EndIf
    If (0.0 < currspeed) Then
        stamina = min((((fpsfactor / ((((Float networkserver\Field12) - max((Float ((myplayer\Field49 = model_939) Or (myplayer\Field49 = model_zombie))), 0.0)) * 0.5) + 1.25)) * 0.15) + stamina), 100.0)
    Else
        stamina = min(((((1.25 - (((Float networkserver\Field12) - max((Float ((myplayer\Field49 = model_939) Or (myplayer\Field49 = model_zombie))), 0.0)) * 0.5)) * fpsfactor) * 0.15) + stamina), 100.0)
    EndIf
    If (0.0 < staminaeffecttimer) Then
        staminaeffecttimer = (staminaeffecttimer - (fpsfactor / 70.0))
    ElseIf (1.0 <> staminaeffect) Then
        staminaeffect = 1.0
    EndIf
    If (keybuffer(key_sprint) <> 0) Then
        If (stamina < (Float ($05 - (networkserver\Field12 * $03)))) Then
            local12 = 0.0
            If (((wearinggasmask > $00) Or (wearing1499 > $00)) <> 0) Then
                local12 = 1.0
            EndIf
            If (channelplaying(breathchn) = $00) Then
                breathchn = playsound_strict(breathsfx((Int local12), $00))
                multiplayer_writesound(breathsfx((Int local12), $00), local5, local6, local7, 4.0, 1.0)
            EndIf
        ElseIf (50.0 > stamina) Then
            If (breathchn = $00) Then
                local12 = 0.0
                If (((wearinggasmask > $00) Or (wearing1499 > $00)) <> 0) Then
                    local12 = 1.0
                EndIf
                breathchn = playsound_strict(breathsfx((Int local12), rand($01, $03)))
                channelvolume(breathchn, (min(((70.0 - stamina) / 70.0), 1.0) * sfxvolume))
                multiplayer_writesound(breathsfx((Int local12), rand($01, $03)), local5, local6, local7, 4.0, 1.0)
            ElseIf (channelplaying(breathchn) = $00) Then
                local12 = 0.0
                If (((wearinggasmask > $00) Or (wearing1499 > $00)) <> 0) Then
                    local12 = 1.0
                EndIf
                breathchn = playsound_strict(breathsfx((Int local12), rand($01, $03)))
                channelvolume(breathchn, (min(((70.0 - stamina) / 70.0), 1.0) * sfxvolume))
                multiplayer_writesound(breathsfx((Int local12), rand($01, $03)), local5, local6, local7, 4.0, 1.0)
            EndIf
        EndIf
    EndIf
    If (local4 <> 0) Then
        sanity = max(-850.0, sanity)
    EndIf
    stamina = min(stamina, (Float ($64 - (((local4 Shl $01) + local3) * $0A))))
    If (iszombie <> 0) Then
        crouch = $00
    EndIf
    If (0.001 > (Abs (crouchstate - (Float crouch)))) Then
        crouchstate = (Float crouch)
    Else
        crouchstate = curvevalue((Float crouch), crouchstate, 10.0)
    EndIf
    If (arg0 = $00) Then
        If (noclip = $00) Then
            If ((((keybuffer(key_down) Or keybuffer(key_up)) Or ((keybuffer(key_right) Or keybuffer(key_left)) And playable)) Or (0.0 < forcemove)) <> 0) Then
                If ((((((crouch = $00) And keybuffer(key_sprint)) And (0.0 < stamina)) And (iszombie = $00)) And (((myplayer\Field49 = model_173) Or (myplayer\Field49 = model_966)) = $00)) <> 0) Then
                    local0 = ((Float (myplayer\Field49 = model_096)) + 2.5)
                    If (myplayer\Field49 = model_096) Then
                        If (scp\Field3 = $00) Then
                            local0 = 1.0
                        EndIf
                    ElseIf (local9\Field36 <> 0) Then
                        local0 = 1.0
                    Else
                        stamina = (stamina - (((0.4 - ((Float (networkserver\Field12 - local9\Field32)) * 0.2)) * fpsfactor) * staminaeffect))
                        If (0.0 >= stamina) Then
                            stamina = -20.0
                        EndIf
                    EndIf
                EndIf
                If ((Str local8) = "pocketdimension") Then
                    If ((((1.0 / 0.128) > local5) Or (10.1875 < local6)) <> 0) Then
                        stamina = 0.0
                        local1 = 0.015
                        local0 = 1.0
                    EndIf
                EndIf
                If (0.0 < forcemove) Then
                    local1 = (local1 * forcemove)
                EndIf
                local12 = (shake Mod 360.0)
                If (unabletomove = $00) Then
                    shake = ((((min(local0, 1.5) * fpsfactor) * 7.0) + shake) Mod 720.0)
                EndIf
                If ((((180.0 > local12) And (180.0 <= (shake Mod 360.0))) And (0.0 <= killtimer)) <> 0) Then
                    local14 = (1.0 - ((Float crouch) * 0.6))
                    local15 = (1.0 - ((Float crouch) * 0.4))
                    local16 = (1.0 - ((Float crouch) * 0.5))
                    Select currstepsfx
                        Case $00,$03
                            local12 = 0.0
                            If (currstepsfx = $00) Then
                                local12 = (Float getstepsound(collider))
                            EndIf
                            If (2.5 = local0) Then
                                playersoundvolume = max(4.0, playersoundvolume)
                                local18 = $01
                            Else
                                playersoundvolume = max((2.5 - ((Float crouch) * 0.3)), playersoundvolume)
                                local18 = $00
                            EndIf
                            local20 = (Float rand($00, $07))
                            local19 = stepsfx((Int local12), local18, (Int local20))
                            local13 = playsound_strict(local19)
                            channelvolume(local13, (local14 * sfxvolume))
                            multiplayer_writesound(stepsfx((Int local12), $00, (Int local20)), local5, local6, local7, 8.0, local16)
                        Case $01,$02
                            local22 = $00
                            local23 = $02
                            If (currstepsfx = $02) Then
                                local22 = $03
                                local23 = $05
                            EndIf
                            local19 = step2sfx(rand(local22, local23))
                            local13 = playsound_strict(local19)
                            channelvolume(local13, (local15 * sfxvolume))
                            multiplayer_writesound(step2sfx(rand(local22, local23)), local5, local6, local7, 8.0, local16)
                    End Select
                EndIf
            EndIf
        ElseIf (keybuffer(key_sprint) <> 0) Then
            local0 = 2.5
        ElseIf (keydown(key_crouch) <> 0) Then
            local0 = 0.5
        EndIf
        If ((keyhit(key_crouch) And playable) <> 0) Then
            crouch = (crouch = $00)
        EndIf
    EndIf
    local24 = 1.0
    If (0.0 <> myplayer\Field92) Then
        local24 = myplayer\Field92
    EndIf
    local25 = (((local1 * local0) * local24) / (1.0 + (Float crouch)))
    collidedfloor = $00
    prev_player_move = player_move
    player_move = $0B
    If (noclip <> 0) Then
        If (arg0 = $00) Then
            shake = 0.0
            currspeed = 0.0
            crouchstate = 0.0
            crouch = $00
            rotateentity(collider, wrapangle(entitypitch(camera, $00)), wrapangle(entityyaw(camera, $00)), 0.0, $00)
            local25 = (local25 * noclipspeed)
            If (keybufferfactor > millisecs()) Then
                local25 = 0.0
                currspeed = 0.0
                keybuffercant = $01
            Else
                keybuffercant = $00
            EndIf
            If (keybuffer(key_down) <> 0) Then
                moveentity(collider, 0.0, 0.0, ((- local25) * fpsfactor))
            EndIf
            If (keybuffer(key_up) <> 0) Then
                moveentity(collider, 0.0, 0.0, (local25 * fpsfactor))
            EndIf
            If (keybuffer(key_left) <> 0) Then
                moveentity(collider, ((- local25) * fpsfactor), 0.0, 0.0)
            EndIf
            If (keybuffer(key_right) <> 0) Then
                moveentity(collider, (local25 * fpsfactor), 0.0, 0.0)
            EndIf
            dropspeed = local25
            resetentity(collider)
        EndIf
    ElseIf (-1.0 = jumpstate) Then
        If (iscoopmode() <> 0) Then
            local25 = (local25 / max(((injuries + 3.0) / 3.0), 1.0))
        Else
            local25 = (local25 / max((injuries / 6.0), 1.0))
        EndIf
        local12 = 0.0
        If (iszombie = $00) Then
            If ((keybuffer(key_down) And playable) <> 0) Then
                local12 = 1.0
                mov_desiredangle = 180.0
                If (keybuffer(key_left) <> 0) Then
                    mov_desiredangle = 135.0
                EndIf
                If (keybuffer(key_right) <> 0) Then
                    mov_desiredangle = -135.0
                EndIf
            ElseIf ((keybuffer(key_up) And playable) <> 0) Then
                local12 = 1.0
                mov_desiredangle = 0.0
                If (keybuffer(key_left) <> 0) Then
                    mov_desiredangle = 45.0
                EndIf
                If (keybuffer(key_right) <> 0) Then
                    mov_desiredangle = -45.0
                EndIf
            ElseIf (0.0 < forcemove) Then
                local12 = 1.0
                mov_desiredangle = forceangle
            ElseIf (playable <> 0) Then
                If (keybuffer(key_left) <> 0) Then
                    mov_desiredangle = 90.0
                    local12 = 1.0
                EndIf
                If (keybuffer(key_right) <> 0) Then
                    mov_desiredangle = -90.0
                    local12 = 1.0
                EndIf
            EndIf
        Else
            local12 = 1.0
            mov_desiredangle = forceangle
        EndIf
        local26 = ((entityyaw(collider, $01) + mov_desiredangle) + 90.0)
        mov_smoothanglex = cos(local26)
        mov_smoothanglez = sin(local26)
        If ((Int local12) <> 0) Then
            currspeed = curvevalue(local25, currspeed, 15.0)
        Else
            currspeed = max(curvevalue(0.0, currspeed, 4.0), 0.0)
        EndIf
        collidedfloor = $00
        local27 = countcollisions(collider)
        For local2 = $01 To local27 Step $01
            If ((entityy(collider, $00) - 0.25) > collisiony(collider, local2)) Then
                collidedfloor = $01
            EndIf
        Next
        If ((((multiplayer_isfullsync() = $00) Or networkserver\Field52\Field4) Or ((networkserver\Field52\Field5 = $00) And (networkserver\Field52\Field4 = $00))) <> 0) Then
            If (((networkserver\Field52\Field16 = $01) And local9\Field31) <> 0) Then
                If (((unabletomove = $00) And (arg0 = $00)) <> 0) Then
                    If (collidedfloor = $01) Then
                        If (((networkserver\Field19 Or consoleopen) Or menuopen) = $00) Then
                            If (keyhit(key_jump) <> 0) Then
                                If (20.0 < stamina) Then
                                    jumpstate = (max((myplayer\Field90 / 1.5), 1.0) * 0.05)
                                    If (keybuffer(key_up) <> 0) Then
                                        lastzspeed = currspeed
                                    EndIf
                                    If (keybuffer(key_down) <> 0) Then
                                        lastzspeed = (- currspeed)
                                    EndIf
                                    If (keybuffer(key_left) <> 0) Then
                                        lastxspeed = (- currspeed)
                                    EndIf
                                    If (keybuffer(key_right) <> 0) Then
                                        lastxspeed = currspeed
                                    EndIf
                                    stamina = (stamina - 10.0)
                                    networkserver\Field46 = $01
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        ElseIf (((networkserver\Field19 Or consoleopen) Or menuopen) = $00) Then
            If (keyhit(key_jump) <> 0) Then
                If (20.0 < stamina) Then
                    stamina = (stamina - 5.0)
                    networkserver\Field46 = $01
                EndIf
            EndIf
        EndIf
        If (collidedfloor = $01) Then
            If (-0.07 > dropspeed) Then
                If (currstepsfx = $00) Then
                    playsound_strict(stepsfx(getstepsound(collider), $00, rand($00, $07)))
                ElseIf (currstepsfx = $01) Then
                    playsound_strict(step2sfx(rand($00, $02)))
                ElseIf (currstepsfx = $02) Then
                    playsound_strict(step2sfx(rand($03, $05)))
                ElseIf (currstepsfx = $03) Then
                    playsound_strict(stepsfx($00, $00, rand($00, $07)))
                EndIf
                playersoundvolume = max(3.0, playersoundvolume)
                multiplayer_writesound(stepsfx(getstepsound(collider), $00, rand($00, $07)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 8.0, 1.0)
                If ((((-0.17 >= dropspeed) And networkserver\Field12) And (multiplayer_isfullsync() = $00)) <> 0) Then
                    takefalldamage(sqr((dropspeed * dropspeed)))
                EndIf
            EndIf
            dropspeed = 0.0
        ElseIf (0.0 <> playerfallingpickdistance) Then
            If (-2147.0 = playerfallingpickdistance) Then
                local28 = createpivot($00)
                positionentity(local28, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00), $00)
                local29 = linepick(entityx(local28, $00), entityy(local28, $00), entityz(local28, $00), 0.0, -0.5, 0.0, 0.0)
                If (local29 <> 0) Then
                    dropspeed = 0.0
                Else
                    dropspeed = min(max((dropspeed - (0.005 * fpsfactor)), -2.0), 0.0)
                EndIf
                freeentity(local28)
            Else
                local29 = linepick(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 0.0, (- playerfallingpickdistance), 0.0, 0.0)
                If (local29 <> 0) Then
                    dropspeed = min(max((dropspeed - (0.005 * fpsfactor)), -2.0), 0.0)
                Else
                    dropspeed = 0.0
                    collidedfloor = $00
                EndIf
            EndIf
        Else
            dropspeed = min(max((dropspeed - (0.005 * fpsfactor)), -2.0), 0.0)
        EndIf
        playerfallingpickdistance = 10.0
        If ((((multiplayer_isfullsync() = $00) Or (networkserver\Field44 = $00)) Or networkserver\Field52\Field4) <> 0) Then
            If (((unabletomove = $00) And (arg0 = $00)) <> 0) Then
                translateentity(collider, ((mov_smoothanglex * currspeed) * fpsfactor), 0.0, ((mov_smoothanglez * currspeed) * fpsfactor), $01)
            EndIf
            If (((unabletomove = $00) And shouldentitiesfall) <> 0) Then
                translateentity(collider, 0.0, (dropspeed * fpsfactor), 0.0, $00)
            EndIf
        EndIf
    Else
        collidedfloor = $00
        local27 = countcollisions(collider)
        For local2 = $01 To local27 Step $01
            If ((entityy(collider, $00) - 0.25) > collisiony(collider, local2)) Then
                collidedfloor = $01
            EndIf
        Next
        If (collidedfloor = $01) Then
            If ((((-0.14 >= jumpstate) And networkserver\Field12) And (multiplayer_isfullsync() = $00)) <> 0) Then
                takefalldamage(sqr((jumpstate * jumpstate)))
            EndIf
            jumpstate = -1.0
            If (currstepsfx = $00) Then
                playsound_strict(stepsfx(getstepsound(collider), $00, rand($00, $07)))
            ElseIf (currstepsfx = $01) Then
                playsound_strict(step2sfx(rand($00, $02)))
            ElseIf (currstepsfx = $02) Then
                playsound_strict(step2sfx(rand($03, $05)))
            ElseIf (currstepsfx = $03) Then
                playsound_strict(stepsfx($00, $00, rand($00, $07)))
            EndIf
            lastxspeed = 0.0
            lastzspeed = 0.0
            multiplayer_writesound(stepsfx(getstepsound(collider), $00, rand($00, $07)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 8.0, 1.0)
            playersoundvolume = max(3.0, playersoundvolume)
        ElseIf (0.0 <> playerfallingpickdistance) Then
            local29 = linepick(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 0.0, (- playerfallingpickdistance), 0.0, 0.0)
            If (local29 <> 0) Then
                moveentity(collider, (lastxspeed * fpsfactor), (jumpstate * fpsfactor), (lastzspeed * fpsfactor))
            Else
                jumpstate = -1.0
                lastxspeed = 0.0
                lastzspeed = 0.0
            EndIf
        Else
            moveentity(collider, (lastxspeed * fpsfactor), (jumpstate * fpsfactor), (lastzspeed * fpsfactor))
        EndIf
        playerfallingpickdistance = 10.0
    EndIf
    jumpstate = (jumpstate - (networkserver\Field52\Field15 * fpsfactor))
    If (-1.0 >= jumpstate) Then
        jumpstate = -1.0
    EndIf
    If (networkserver\Field52\Field16 = $00) Then
        jumpstate = -1.0
    EndIf
    forcemove = 0.0
    If (1.0 < injuries) Then
        local25 = bloodloss
        blurtimer = max(max(((sin(((Float millisecs()) / 100.0)) * bloodloss) * 30.0), ((bloodloss * 2.0) * (2.0 - crouchstate))), blurtimer)
        If ((i_427\Field0 And (25200.0 > i_427\Field1)) = $00) Then
            bloodloss = min((((min(injuries, 3.5) / 300.0) * fpsfactor) + bloodloss), 100.0)
        EndIf
        If (((60.0 >= local25) And (60.0 < bloodloss)) <> 0) Then
            setmsg("You are feeling faint from the amount of blood you have lost.")
        EndIf
    EndIf
    If (local10 <> model_zombie) Then
        updateinfect()
    EndIf
    If (networkserver\Field12 = $00) Then
        If (0.0 < bloodloss) Then
            If (min(injuries, 4.0) > rnd(400.0, 0.0)) Then
                linepick(local5, local6, local7, 0.0, -10.0, 0.0, 0.0)
                If (pickedentity() <> $00) Then
                    local30 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                    aligntovector(local30\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                    local30\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                    entityalpha(local30\Field0, 1.0)
                    scalesprite(local30\Field0, local30\Field2, local30\Field2)
                    local13 = playsound_strict(dripsfx(rand($00, $02)))
                    channelvolume(local13, (rnd(0.0, 0.8) * sfxvolume))
                    channelpitch(local13, rand($4E20, $7530))
                    multiplayer_writedecal(local30, $01, $01)
                EndIf
            EndIf
            If (90.0 < bloodloss) Then
                crouch = $01
            EndIf
            If (100.0 <= bloodloss) Then
                kill("died of blood loss", $00)
                heartbeatvolume = 0.0
            ElseIf (80.0 < bloodloss) Then
                heartbeatrate = max((150.0 - ((bloodloss - 80.0) * 5.0)), heartbeatrate)
                heartbeatvolume = max(heartbeatvolume, (((bloodloss - 80.0) * (1.0 / 80.0)) + 0.75))
            ElseIf (35.0 < bloodloss) Then
                heartbeatrate = max((70.0 + bloodloss), heartbeatrate)
                heartbeatvolume = max(heartbeatvolume, ((bloodloss - 35.0) / 60.0))
            EndIf
        EndIf
        If (0.0 < healtimer) Then
            local31 = (fpsfactor * (1.0 / 70.0035))
            healtimer = (healtimer - local31)
            bloodloss = ((0.005 * fpsfactor) + bloodloss)
            If (100.0 < bloodloss) Then
                bloodloss = 100.0
            EndIf
            injuries = (injuries - (local31 * (1.0 / 30.0003)))
            If (0.0 > injuries) Then
                injuries = 0.0
            EndIf
        EndIf
    EndIf
    If (playable <> 0) Then
        If (keyhit(key_blink) <> 0) Then
            blinktimer = 0.0
        EndIf
        If ((keydown(key_blink) And (-10.0 > blinktimer)) <> 0) Then
            blinktimer = -10.0
        EndIf
    EndIf
    If (0.0 < heartbeatvolume) Then
        If (0.0 >= heartbeattimer) Then
            local13 = playsound_strict(heartbeatsfx)
            channelvolume(local13, (heartbeatvolume * sfxvolume))
            heartbeattimer = ((60.0 / max(heartbeatrate, 1.0)) * 70.0)
        Else
            heartbeattimer = (heartbeattimer - fpsfactor)
        EndIf
        heartbeatvolume = max((heartbeatvolume - (fpsfactor * 0.05)), 0.0)
    EndIf
    If (((((keybuffer(key_up) = $00) And (keybuffer(key_down) = $00)) And (keybuffer(key_left) = $00)) And (keybuffer(key_right) = $00)) <> 0) Then
        If (crouch = $01) Then
            player_move = $05
        Else
            player_move = $0B
        EndIf
    ElseIf (keybuffer(key_sprint) = $00) Then
        If (crouch = $01) Then
            If (keybuffer(key_left) <> 0) Then
                player_move = $07
            ElseIf (keybuffer(key_right) <> 0) Then
                player_move = $08
            ElseIf (keybuffer(key_up) <> 0) Then
                player_move = $0A
            ElseIf (keybuffer(key_down) <> 0) Then
                player_move = $09
            EndIf
        ElseIf ((((keybuffer(key_down) Or keybuffer(key_up)) Or keybuffer(key_left)) Or keybuffer(key_right)) <> 0) Then
            player_move = $0C
        EndIf
    ElseIf (crouch = $00) Then
        If ((((keybuffer(key_down) Or keybuffer(key_up)) Or keybuffer(key_left)) Or keybuffer(key_right)) <> 0) Then
            player_move = $0D
        EndIf
    EndIf
    If (-1.0 <> jumpstate) Then
        player_move = local32
    EndIf
    local33 = myplayer\Field49
    If (local33 = model_096) Then
        If (0.0 <> scp\Field7) Then
            player_move = $0E
        EndIf
        If (scp\Field3 <> 0) Then
            If ((((player_move = $05) Or (player_move = $0B)) Or (player_move = $0C)) <> 0) Then
                player_move = $0E
            EndIf
        ElseIf ((0.0 <> scp\Field7) = $00) Then
            If (player_move = $0D) Then
                player_move = $0C
            EndIf
        EndIf
    EndIf
    Return $00
End Function
