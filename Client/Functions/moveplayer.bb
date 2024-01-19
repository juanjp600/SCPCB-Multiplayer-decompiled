Function moveplayer%(arg0%)
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    Local local4.breachtypes
    Local local5#
    Local local6%
    Local local7%
    Local local8.decals
    Local local9#
    Local local10#
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    local0 = 1.0
    local1 = 0.018
    If (spectate\Field1 <> $FFFFFFFF) Then
        Return $00
    EndIf
    If (myplayer\Field51 = model_106) Then
        currstepsfx = $01
    EndIf
    local4 = getbreachtype(myplayer\Field51)
    If (superman <> 0) Then
        local1 = ((Float (((myplayer\Field51 = model_173) * $05) + $03)) * local1)
        If (((myplayer\Field51 <> model_173) And (myplayer\Field51 <> model_096)) <> 0) Then
            supermantimer = (supermantimer + fpsfactor)
            camerashake = (sin((supermantimer / 5.0)) * (supermantimer / 1500.0))
            If (3500.0 < supermantimer) Then
                deathmsg = "A Class D jumpsuit found in [DATA REDACTED]. Upon further examination, the jumpsuit was found to be filled with 12.5 kilograms of blue ash-like substance. "
                deathmsg = (deathmsg + "Chemical analysis of the substance remains non-conclusive. Most likely related to SCP-914.")
                kill("was killed by SCP-914", $00)
                showentity(fog)
            Else
                blurtimer = 500.0
                hideentity(fog)
            EndIf
        Else
            If (myplayer\Field51 = model_173) Then
                shake = 0.0
                camerashake = 0.0
            EndIf
            blurtimer = 0.0
        EndIf
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
        stamina = min((((fpsfactor / ((((Float networkserver\Field15) - max((Float (((myplayer\Field51 = model_939) Or (myplayer\Field51 = model_860)) Or (myplayer\Field51 = model_zombie))), 0.0)) / 2.0) + 1.25)) * 0.15) + stamina), 100.0)
    Else
        stamina = min(((((1.25 - (((Float networkserver\Field15) - max((Float (((myplayer\Field51 = model_939) Or (myplayer\Field51 = model_860)) Or (myplayer\Field51 = model_zombie))), 0.0)) / 2.0)) * fpsfactor) * 0.15) + stamina), 100.0)
    EndIf
    If (0.0 < staminaeffecttimer) Then
        staminaeffecttimer = (staminaeffecttimer - (fpsfactor / 70.0))
    ElseIf (1.0 <> staminaeffect) Then
        staminaeffect = 1.0
    EndIf
    If (playerroom\Field7\Field11 <> "pocketdimension") Then
        If (keybuffer(key_sprint) <> 0) Then
            If (stamina < (Float ($05 - (networkserver\Field15 * $03)))) Then
                local5 = 0.0
                If (((wearinggasmask > $00) Or (wearing1499 > $00)) <> 0) Then
                    local5 = 1.0
                EndIf
                If (channelplaying(breathchn) = $00) Then
                    breathchn = playsound_strict(breathsfx((Int local5), $00))
                    multiplayer_writesound(breathsfx((Int local5), $00), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 4.0, 1.0)
                EndIf
            ElseIf (50.0 > stamina) Then
                If (breathchn = $00) Then
                    local5 = 0.0
                    If (((wearinggasmask > $00) Or (wearing1499 > $00)) <> 0) Then
                        local5 = 1.0
                    EndIf
                    breathchn = playsound_strict(breathsfx((Int local5), rand($01, $03)))
                    channelvolume(breathchn, (min(((70.0 - stamina) / 70.0), 1.0) * sfxvolume))
                    multiplayer_writesound(breathsfx((Int local5), rand($01, $03)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 4.0, 1.0)
                ElseIf (channelplaying(breathchn) = $00) Then
                    local5 = 0.0
                    If (((wearinggasmask > $00) Or (wearing1499 > $00)) <> 0) Then
                        local5 = 1.0
                    EndIf
                    breathchn = playsound_strict(breathsfx((Int local5), rand($01, $03)))
                    channelvolume(breathchn, (min(((70.0 - stamina) / 70.0), 1.0) * sfxvolume))
                    multiplayer_writesound(breathsfx((Int local5), rand($01, $03)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 4.0, 1.0)
                EndIf
            EndIf
        EndIf
    EndIf
    For local2 = $00 To $09 Step $01
        If (inventory(local2) <> Null) Then
            If (inventory(local2)\Field3\Field2 = "finevest") Then
                stamina = min(stamina, 60.0)
            EndIf
        EndIf
    Next
    If (wearing714 <> 0) Then
        stamina = min(stamina, 10.0)
        sanity = max(-850.0, sanity)
    EndIf
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
            If (((((keybuffer(key_down) Or keybuffer(key_up)) Or (keybuffer(key_right) Or keybuffer(key_left))) And playable) Or (0.0 < forcemove)) <> 0) Then
                If ((((((crouch = $00) And keybuffer(key_sprint)) And (0.0 < stamina)) And (iszombie = $00)) And (((myplayer\Field51 = model_173) Or (myplayer\Field51 = model_966)) = $00)) <> 0) Then
                    local0 = ((Float (myplayer\Field51 = model_096)) + 2.5)
                    If (myplayer\Field51 = model_096) Then
                        If (scp\Field3 = $00) Then
                            local0 = 1.0
                        EndIf
                    ElseIf (local4\Field36 <> 0) Then
                        local0 = 1.0
                    Else
                        stamina = (stamina - (((0.4 - ((Float (networkserver\Field15 - local4\Field32)) * 0.2)) * fpsfactor) * staminaeffect))
                        If (0.0 >= stamina) Then
                            stamina = -20.0
                        EndIf
                    EndIf
                EndIf
                If (playerroom\Field7\Field11 = "pocketdimension") Then
                    If ((((2000.0 * roomscale) > entityy(collider, $00)) Or ((2608.0 * roomscale) < entityy(collider, $00))) <> 0) Then
                        stamina = 0.0
                        local1 = 0.015
                        local0 = 1.0
                    EndIf
                EndIf
                If (0.0 < forcemove) Then
                    local1 = (local1 * forcemove)
                EndIf
                If (selecteditem <> Null) Then
                    If ((((((selecteditem\Field3\Field2 = "firstaid") Or (selecteditem\Field3\Field2 = "finefirstaid")) Or (selecteditem\Field3\Field2 = "firstaid2")) Or (selecteditem\Field3\Field2 = "chicken")) Or (selecteditem\Field3\Field2 = "boxofammo")) <> 0) Then
                        local0 = 0.0
                    EndIf
                EndIf
                local5 = (shake Mod 360.0)
                If (unabletomove = $00) Then
                    shake = ((((min(local0, 1.5) * fpsfactor) * 7.0) + shake) Mod 720.0)
                EndIf
                If ((((180.0 > local5) And (180.0 <= (shake Mod 360.0))) And (0.0 <= killtimer)) <> 0) Then
                    If (currstepsfx = $00) Then
                        local5 = (Float getstepsound(collider))
                        If (2.5 = local0) Then
                            playersoundvolume = max(4.0, playersoundvolume)
                            local6 = playsound_strict(stepsfx((Int local5), $00, rand($00, $07)))
                            channelvolume(local6, ((1.0 - ((Float crouch) * 0.6)) * sfxvolume))
                        Else
                            playersoundvolume = max((2.5 - ((Float crouch) * 0.6)), playersoundvolume)
                            local6 = playsound_strict(stepsfx((Int local5), $01, rand($00, $07)))
                            channelvolume(local6, ((1.0 - ((Float crouch) * 0.6)) * sfxvolume))
                        EndIf
                        multiplayer_writesound(stepsfx((Int local5), $00, rand($00, $07)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 8.0, (1.0 - (0.5 * (Float crouch))))
                    ElseIf (currstepsfx = $01) Then
                        local6 = playsound_strict(step2sfx(rand($00, $02)))
                        channelvolume(local6, ((1.0 - ((Float crouch) * 0.4)) * sfxvolume))
                        multiplayer_writesound(step2sfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 8.0, (1.0 - (0.5 * (Float crouch))))
                    ElseIf (currstepsfx = $02) Then
                        local6 = playsound_strict(step2sfx(rand($03, $05)))
                        channelvolume(local6, ((1.0 - ((Float crouch) * 0.4)) * sfxvolume))
                        multiplayer_writesound(step2sfx(rand($03, $05)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 8.0, (1.0 - (0.5 * (Float crouch))))
                    ElseIf (currstepsfx = $03) Then
                        If (2.5 = local0) Then
                            playersoundvolume = max(4.0, playersoundvolume)
                            local6 = playsound_strict(stepsfx($00, $00, rand($00, $07)))
                            channelvolume(local6, ((1.0 - ((Float crouch) * 0.6)) * sfxvolume))
                            multiplayer_writesound(stepsfx($00, $00, rand($00, $07)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 8.0, (1.0 - (0.5 * (Float crouch))))
                        Else
                            playersoundvolume = max((2.5 - ((Float crouch) * 0.6)), playersoundvolume)
                            local6 = playsound_strict(stepsfx($00, $01, rand($00, $07)))
                            channelvolume(local6, ((1.0 - ((Float crouch) * 0.6)) * sfxvolume))
                            multiplayer_writesound(stepsfx($00, $01, rand($00, $07)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 8.0, (1.0 - (0.5 * (Float crouch))))
                        EndIf
                    EndIf
                    If (((myplayer\Field51 = model_106) And (rand($01, $3C) = $02)) <> 0) Then
                        local7 = createpivot($00)
                        positionentity(local7, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                        turnentity(local7, 90.0, 0.0, 0.0, $00)
                        If (entitypick(local7, 1.0) <> $00) Then
                            local8 = createdecal($00, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local8\Field2 = 0.05
                            local8\Field1 = 0.001
                            entityalpha(local8\Field0, 0.8)
                            updatedecals()
                            local8\Field10 = 1050.0
                        EndIf
                        freeentity(local7)
                        multiplayer_writedecal(local8, $01, $01)
                    EndIf
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
    local9 = 1.0
    If (0.0 <> myplayer\Field94) Then
        local9 = myplayer\Field94
    EndIf
    local10 = (((local1 * local0) * local9) / (1.0 + (Float crouch)))
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
            local10 = (local10 * noclipspeed)
            If (keybufferfactor > millisecs()) Then
                local10 = 0.0
                currspeed = 0.0
                keybuffercant = $01
            Else
                keybuffercant = $00
            EndIf
            If (keybuffer(key_down) <> 0) Then
                moveentity(collider, 0.0, 0.0, ((- local10) * fpsfactor))
            EndIf
            If (keybuffer(key_up) <> 0) Then
                moveentity(collider, 0.0, 0.0, (local10 * fpsfactor))
            EndIf
            If (keybuffer(key_left) <> 0) Then
                moveentity(collider, ((- local10) * fpsfactor), 0.0, 0.0)
            EndIf
            If (keybuffer(key_right) <> 0) Then
                moveentity(collider, (local10 * fpsfactor), 0.0, 0.0)
            EndIf
            dropspeed = local10
            resetentity(collider)
        EndIf
    ElseIf (-1.0 = jumpstate) Then
        local10 = (local10 / max(((injuries + 3.0) / 3.0), 1.0))
        local5 = 0.0
        If (iszombie = $00) Then
            If ((keybuffer(key_down) And playable) <> 0) Then
                local5 = 1.0
                local3 = 180.0
                If (keybuffer(key_left) <> 0) Then
                    local3 = 135.0
                EndIf
                If (keybuffer(key_right) <> 0) Then
                    local3 = -135.0
                EndIf
            ElseIf ((keybuffer(key_up) And playable) <> 0) Then
                local5 = 1.0
                local3 = 0.0
                If (keybuffer(key_left) <> 0) Then
                    local3 = 45.0
                EndIf
                If (keybuffer(key_right) <> 0) Then
                    local3 = -45.0
                EndIf
            ElseIf (0.0 < forcemove) Then
                local5 = 1.0
                local3 = forceangle
            ElseIf (playable <> 0) Then
                If (keybuffer(key_left) <> 0) Then
                    local3 = 90.0
                    local5 = 1.0
                EndIf
                If (keybuffer(key_right) <> 0) Then
                    local3 = -90.0
                    local5 = 1.0
                EndIf
            EndIf
        Else
            local5 = 1.0
            local3 = forceangle
        EndIf
        local3 = wrapangle(((entityyaw(collider, $01) + local3) + 90.0))
        If ((Int local5) <> 0) Then
            currspeed = curvevalue(local10, currspeed, 20.0)
        Else
            currspeed = max(curvevalue(0.0, (currspeed - 0.1), 1.0), 0.0)
        EndIf
        collidedfloor = $00
        local11 = countcollisions(collider)
        For local2 = $01 To local11 Step $01
            If ((entityy(collider, $00) - 0.25) > collisiony(collider, local2)) Then
                collidedfloor = $01
            EndIf
        Next
        If ((((multiplayer_isfullsync() = $00) Or networkserver\Field60) Or ((networkserver\Field61 = $00) And (networkserver\Field60 = $00))) <> 0) Then
            If (((networkserver\Field13 = $01) And local4\Field31) <> 0) Then
                If (((unabletomove = $00) And (arg0 = $00)) <> 0) Then
                    If (collidedfloor = $01) Then
                        If (((networkserver\Field27 Or consoleopen) Or menuopen) = $00) Then
                            If (keyhit(key_jump) <> 0) Then
                                If (20.0 < stamina) Then
                                    jumpstate = (max((myplayer\Field92 / 1.5), 1.0) * 0.05)
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
                                    networkserver\Field59 = $01
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        ElseIf (((networkserver\Field27 Or consoleopen) Or menuopen) = $00) Then
            If (keyhit(key_jump) <> 0) Then
                If (20.0 < stamina) Then
                    stamina = (stamina - 10.0)
                    networkserver\Field59 = $01
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
                If ((((-0.17 >= dropspeed) And networkserver\Field15) And (multiplayer_isfullsync() = $00)) <> 0) Then
                    takefalldamage(sqr((dropspeed * dropspeed)))
                EndIf
            EndIf
            dropspeed = 0.0
        ElseIf (0.0 <> playerfallingpickdistance) Then
            If (-2147.0 = playerfallingpickdistance) Then
                local12 = createpivot($00)
                positionentity(local12, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00), $00)
                local13 = linepick(entityx(local12, $00), entityy(local12, $00), entityz(local12, $00), 0.0, -0.5, 0.0, 0.0)
                If (local13 <> 0) Then
                    dropspeed = 0.0
                Else
                    dropspeed = min(max((dropspeed - (0.005 * fpsfactor)), -2.0), 0.0)
                EndIf
                freeentity(local12)
            Else
                local13 = linepick(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 0.0, (- playerfallingpickdistance), 0.0, 0.0)
                If (local13 <> 0) Then
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
        If ((((multiplayer_isfullsync() = $00) Or (networkserver\Field57 = $00)) Or networkserver\Field60) <> 0) Then
            If (((unabletomove = $00) And (arg0 = $00)) <> 0) Then
                translateentity(collider, ((cos(local3) * currspeed) * fpsfactor), 0.0, ((sin(local3) * currspeed) * fpsfactor), $01)
            EndIf
            If (((unabletomove = $00) And shouldentitiesfall) <> 0) Then
                translateentity(collider, 0.0, (dropspeed * fpsfactor), 0.0, $00)
            EndIf
        EndIf
    Else
        collidedfloor = $00
        local11 = countcollisions(collider)
        For local2 = $01 To local11 Step $01
            If ((entityy(collider, $00) - 0.25) > collisiony(collider, local2)) Then
                collidedfloor = $01
            EndIf
        Next
        If (collidedfloor = $01) Then
            If ((((-0.14 >= jumpstate) And networkserver\Field15) And (multiplayer_isfullsync() = $00)) <> 0) Then
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
            local13 = linepick(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 0.0, (- playerfallingpickdistance), 0.0, 0.0)
            If (local13 <> 0) Then
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
    jumpstate = (jumpstate - (networkserver\Field12 * fpsfactor))
    If (-1.0 >= jumpstate) Then
        jumpstate = -1.0
    EndIf
    If (networkserver\Field13 = $00) Then
        jumpstate = -1.0
    EndIf
    forcemove = 0.0
    If (1.0 < injuries) Then
        local10 = bloodloss
        blurtimer = max(max(((sin(((Float millisecs2()) / 100.0)) * bloodloss) * 30.0), ((bloodloss * 2.0) * (2.0 - crouchstate))), blurtimer)
        If ((i_427\Field0 And (25200.0 > i_427\Field1)) = $00) Then
            bloodloss = min((((min(injuries, 3.5) / 300.0) * fpsfactor) + bloodloss), 100.0)
        EndIf
        If (((60.0 >= local10) And (60.0 < bloodloss)) <> 0) Then
            msg = "You are feeling faint from the amount of blood you have lost."
            msgtimer = 280.0
        EndIf
    EndIf
    updateinfect()
    If (0.0 < bloodloss) Then
        If (min(injuries, 4.0) > rnd(200.0, 0.0)) Then
            local7 = createpivot($00)
            positionentity(local7, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
            turnentity(local7, 90.0, 0.0, 0.0, $00)
            entitypick(local7, 0.3)
            local8 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            local8\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
            entityalpha(local8\Field0, 1.0)
            scalesprite(local8\Field0, local8\Field2, local8\Field2)
            local6 = playsound_strict(dripsfx(rand($00, $02)))
            channelvolume(local6, (rnd(0.0, 0.8) * sfxvolume))
            channelpitch(local6, rand($4E20, $7530))
            freeentity(local7)
            multiplayer_writedecal(local8, $01, $01)
        EndIf
        currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * bloodloss) * 0.2))
        If (60.0 < bloodloss) Then
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
        debuglog((Str healtimer))
        healtimer = (healtimer - (fpsfactor / 70.0))
        bloodloss = min(((0.005 * fpsfactor) + bloodloss), 100.0)
        injuries = max((injuries - ((fpsfactor / 70.0) / 30.0)), 0.0)
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
            local6 = playsound_strict(heartbeatsfx)
            channelvolume(local6, (heartbeatvolume * sfxvolume))
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
        player_move = local14
    EndIf
    local15 = myplayer\Field51
    If (local15 = model_096) Then
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
