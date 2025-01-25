Function mp_updatenpctype106%(arg0.npcs)
    Local local0.decals
    Local local1#
    Local local2%
    Local local3%
    Local local4.events
    Local local6#
    Local local8%
    Local local9#
    Local local10.doors
    Local local11#
    Local local12#
    Local local13%
    If ((arg0\Field65 Lor (playerroom\Field7\Field6 = $49)) <> 0) Then
        If (entityhidden(arg0\Field0) = $00) Then
            arg0\Field26 = 1.0
            positionentity(arg0\Field3, 0.0, -500.0, 0.0, $00)
            resetentity(arg0\Field3)
            hideentity(arg0\Field0)
            hideentity(arg0\Field1)
        EndIf
    Else
        local1 = entitydistancesquared(arg0\Field3, me\Field60)
        local2 = $01
        If (((playerroom\Field7\Field6 = $6A) Lor ((playerroom\Field7\Field6 = $3A) And (infacility = $FFFFFFFF))) <> 0) Then
            local2 = $00
        EndIf
        If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
            If (20.0 < entityy(me\Field60, $00)) Then
                local2 = $00
            EndIf
        EndIf
        If (skull_event <> Null) Then
            If (0.0 < skull_event\Field2) Then
                local2 = $00
            EndIf
        EndIf
        For local4 = Each events
            If (local4\Field0 = $2E) Then
                If (0.0 <> local4\Field2) Then
                    local2 = $01
                    arg0\Field26 = (Float (playerroom\Field7\Field6 = $6A))
                EndIf
                Exit
            EndIf
        Next
        If (((local2 = $00) And (1.0 < arg0\Field10)) <> 0) Then
            arg0\Field11 = rnd(22000.0, 27000.0)
            arg0\Field10 = 0.0
        EndIf
        If (((0.0 = arg0\Field26) And local2) <> 0) Then
            Select arg0\Field10
                Case 0.0
                    positionentity(arg0\Field3, 0.0, -500.0, 0.0, $00)
                    resetentity(arg0\Field3)
                    arg0\Field10 = 1.0
                Case 1.0
                    If (playerroom\Field7\Field8 < $03) Then
                        local6 = (fps\Field7[$00] * ((Float selecteddifficulty\Field2) + 1.0))
                        Select playerroom\Field7\Field8
                            Case $00
                                arg0\Field11 = max(0.0, (arg0\Field11 - local6))
                            Case $01
                                arg0\Field11 = max(0.0, (arg0\Field11 - (local6 * 0.5)))
                            Case $02
                                If (2000.0 < arg0\Field11) Then
                                    arg0\Field11 = (arg0\Field11 - (local6 * 0.25))
                                EndIf
                        End Select
                    EndIf
                    If (0.0 >= arg0\Field11) Then
                        arg0\Field36 = entityx(me\Field60, $00)
                        arg0\Field37 = entityy(me\Field60, $00)
                        arg0\Field38 = entityz(me\Field60, $00)
                        arg0\Field10 = 2.0
                    EndIf
                Case 2.0
                    shouldplay = $42
                    If ((((0.0 <> arg0\Field36) Lor (0.0 <> arg0\Field37)) Lor (0.0 <> arg0\Field38)) <> 0) Then
                        local3 = createpivot($00)
                        positionentity(local3, arg0\Field36, arg0\Field37, arg0\Field38, $00)
                        turnentity(local3, 90.0, 0.0, 0.0, $00)
                        If (entitypick(local3, 0.5) <> 0) Then
                            arg0\Field37 = pickedy()
                        EndIf
                        freeentity(local3)
                        local3 = $00
                        positionentity(arg0\Field3, arg0\Field36, arg0\Field37, arg0\Field38, $00)
                        local0 = createdecal($00, arg0\Field36, (arg0\Field37 + 0.005), arg0\Field38, 90.0, rnd(360.0, 0.0), 0.0, 0.05, 0.8, $00, $01, $00, $00, $00)
                        local0\Field4 = 0.001
                        entityparent(local0\Field0, playerroom\Field2, $01)
                        setnpcframe(arg0, 110.0, $01)
                        playsound_strict(snd_i\Field24[$00], $00)
                        arg0\Field11 = 0.0
                        arg0\Field12 = 0.0
                        arg0\Field36 = 0.0
                        arg0\Field37 = 0.0
                        arg0\Field38 = 0.0
                    ElseIf (259.0 > arg0\Field14) Then
                        If ((chs\Field2 Lor i_268\Field2) = $00) Then
                            pointentity(arg0\Field0, me\Field60, 0.0)
                            rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 100.0), 0.0, $01)
                        EndIf
                        animatenpc(arg0, 111.0, 259.0, 0.15, $00)
                    Else
                        giveachievement("106", $01)
                        arg0\Field10 = 3.0
                        arg0\Field12 = rnd(3000.0, 3500.0)
                    EndIf
                Case 3.0
                    local8 = $00
                    If (64.0 > local1) Then
                        If ((chs\Field2 Lor i_268\Field2) = $00) Then
                            local8 = entityvisible(arg0\Field3, me\Field60)
                        EndIf
                    EndIf
                    If (local8 <> 0) Then
                        If (playerroom\Field7\Field6 <> $47) Then
                            arg0\Field41 = 0.0
                        EndIf
                        If (entityinview(arg0\Field3, mp_getnpctargetcamera(arg0)) <> 0) Then
                            local9 = (4.0 - sqr(local1))
                            If (arg0\Field83 <> 0) Then
                                me\Field48 = max(clamp((local9 / 6.0), 0.1, 0.9), me\Field48)
                                me\Field52 = max(me\Field52, (((sin(((Float millisec) / 20.0)) + 1.0) * 20.0) * max((local9 / 4.0), 0.0)))
                            EndIf
                            If ((millisecs() - arg0\Field29) > $EA60) Then
                                If (arg0\Field83 <> 0) Then
                                    me\Field52 = 40.0
                                EndIf
                                playsound_strict(snd_i\Field47[$06], $00)
                                arg0\Field29 = millisecs()
                            EndIf
                        EndIf
                    Else
                        arg0\Field12 = max(0.0, (arg0\Field12 - fps\Field7[$00]))
                    EndIf
                    If (((playerroom\Field7\Field6 <> $47) And (playerroom\Field7\Field6 <> $69)) <> 0) Then
                        shouldplay = $0A
                    EndIf
                    If (144.0 > local1) Then
                        For local10 = Each doors
                            If (((local10\Field27 = $00) And (local10\Field6 = $00)) <> 0) Then
                                If (((0.25 > entitydistancesquared(arg0\Field3, local10\Field2)) And ((local10\Field15 <> Null) And (local10\Field15\Field7\Field6 <> $69))) <> 0) Then
                                    If (((((local10\Field10 <> $04) And (local10\Field10 <> $05)) And (local10\Field10 <> $03)) And (local10\Field10 <> $07)) <> 0) Then
                                        affectdecaydoor(local10)
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    EndIf
                    If (0.64 < local1) Then
                        local11 = arg0\Field14
                        If (((((((625.0 < local1) Lor (playerroom\Field7\Field6 = $69)) Lor local8) Lor (arg0\Field40 <> $01)) And (playerroom\Field7\Field6 <> $47)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                            If (((16.0 < local1) Lor (playerroom\Field7\Field6 = $69)) <> 0) Then
                                translateentity(arg0\Field3, 0.0, (((entityy(me\Field60, $00) - 0.3) - entityy(arg0\Field3, $00)) / 50.0), 0.0, $00)
                            EndIf
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                            pointentity(arg0\Field0, me\Field60, 0.0)
                            rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), (10.0 - (Float selecteddifficulty\Field4))), 0.0, $00)
                            animatenpc(arg0, 284.0, 333.0, (arg0\Field24 * 43.0), $01)
                            arg0\Field41 = max((arg0\Field41 - fps\Field7[$00]), 0.0)
                            If (0.0 >= arg0\Field41) Then
                                arg0\Field40 = findpath(arg0, entityx(me\Field60, $01), entityy(me\Field60, $01), entityz(me\Field60, $01))
                                arg0\Field41 = 700.0
                            EndIf
                        ElseIf (0.0 < arg0\Field41) Then
                            arg0\Field41 = max((arg0\Field41 - fps\Field7[$00]), 0.0)
                            If (arg0\Field40 = $01) Then
                                While (arg0\Field39[arg0\Field42] = Null)
                                    If (arg0\Field42 > $14) Then
                                        arg0\Field42 = $00
                                        arg0\Field40 = $00
                                        Exit
                                    Else
                                        arg0\Field42 = (arg0\Field42 + $01)
                                    EndIf
                                Wend
                                If (arg0\Field39[arg0\Field42] <> Null) Then
                                    translateentity(arg0\Field3, 0.0, ((entityy(arg0\Field39[arg0\Field42]\Field0, $01) - entityy(arg0\Field3, $00)) / 50.0), 0.0, $00)
                                    pointentity(arg0\Field0, arg0\Field39[arg0\Field42]\Field0, 0.0)
                                    local12 = entitydistancesquared(arg0\Field3, arg0\Field39[arg0\Field42]\Field0)
                                    rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), min(20.0, (sqr(local12) * 10.0))), 0.0, $00)
                                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                                    animatenpc(arg0, 284.0, 333.0, (arg0\Field24 * 43.0), $01)
                                    If (0.08 > local12) Then
                                        arg0\Field42 = (arg0\Field42 + $01)
                                    EndIf
                                EndIf
                            Else
                                arg0\Field24 = curvevalue(0.0, arg0\Field24, 10.0)
                                animatenpc(arg0, 334.0, 494.0, 0.3, $01)
                            EndIf
                        Else
                            arg0\Field40 = findpath(arg0, entityx(me\Field60, $01), entityy(me\Field60, $01), entityz(me\Field60, $01))
                            arg0\Field41 = 700.0
                            arg0\Field24 = 0.0
                        EndIf
                        If (100.0 > local1) Then
                            If (((286.0 >= local11) And (286.0 < arg0\Field14)) <> 0) Then
                                playsoundex(stepsfx($02, $00, rand($00, $02)), camera, arg0\Field3, 6.0, rnd(0.8, 1.0), $00, $00)
                                If (playerroom\Field7\Field6 = $47) Then
                                    local0 = createdecal($00, (entityx(arg0\Field3, $01) + (cos(entityyaw(arg0\Field3, $00)) * 0.1)), (playerroom\Field4 + 0.005), (entityz(arg0\Field3, $01) - (sin(entityyaw(arg0\Field3, $00)) * 0.1)), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 0.8, $00, $01, $00, $00, $00)
                                    local0\Field4 = -0.00002
                                    local0\Field13 = 90000.0
                                Else
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.1), entityz(arg0\Field3, $00), $00)
                                    turnentity(local3, 90.0, 0.0, 0.0, $00)
                                    If (entitypick(local3, 0.2) <> 0) Then
                                        local0 = createdecal($00, (entityx(arg0\Field3, $01) + (cos(entityyaw(arg0\Field3, $00)) * 0.1)), (pickedy() + 0.005), (entityz(arg0\Field3, $01) - (sin(entityyaw(arg0\Field3, $00)) * 0.1)), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 0.8, $00, $01, $00, $00, $00)
                                        local0\Field4 = -0.00002
                                        local0\Field13 = 90000.0
                                    EndIf
                                    freeentity(local3)
                                    local3 = $00
                                EndIf
                            ElseIf (((311.0 >= local11) And (311.0 < arg0\Field14)) <> 0) Then
                                playsoundex(stepsfx($02, $00, rand($00, $02)), camera, arg0\Field3, 6.0, rnd(0.8, 1.0), $00, $00)
                                If (playerroom\Field7\Field6 = $47) Then
                                    local0 = createdecal($00, (entityx(arg0\Field3, $01) - (cos(entityyaw(arg0\Field3, $00)) * 0.1)), (playerroom\Field4 + 0.005), (entityz(arg0\Field3, $01) + (sin(entityyaw(arg0\Field3, $00)) * 0.1)), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 0.8, $00, $01, $00, $00, $00)
                                    local0\Field4 = -0.00002
                                    local0\Field13 = 90000.0
                                Else
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.1), entityz(arg0\Field3, $00), $00)
                                    turnentity(local3, 90.0, 0.0, 0.0, $00)
                                    If (entitypick(local3, 0.2) <> 0) Then
                                        local0 = createdecal($00, (entityx(arg0\Field3, $01) - (cos(entityyaw(arg0\Field3, $00)) * 0.1)), (pickedy() + 0.005), (entityz(arg0\Field3, $01) + (sin(entityyaw(arg0\Field3, $00)) * 0.1)), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 0.8, $00, $01, $00, $00, $00)
                                        local0\Field4 = -0.00002
                                        local0\Field13 = 90000.0
                                    EndIf
                                    freeentity(local3)
                                    local3 = $00
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (chs\Field2 = $00) Then
                        If (0.25 < local1) Then
                            arg0\Field24 = curvevalue((arg0\Field23 * 2.5), arg0\Field24, 10.0)
                        Else
                            arg0\Field24 = 0.0
                        EndIf
                        animatenpc(arg0, 105.0, 110.0, 0.15, $00)
                        pointentity(arg0\Field0, me\Field60, 0.0)
                        rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), (10.0 - (Float selecteddifficulty\Field4))), 0.0, $00)
                        If (110.0 = ceil(arg0\Field14)) Then
                            If (((arg0\Field83 And (0.0 = me\Field0)) And (chs\Field0 = $00)) <> 0) Then
                                playsound_strict(snd_i\Field51[$01], $00)
                                playsound_strict(snd_i\Field47[$05], $00)
                            EndIf
                            If ((arg0\Field83 And chs\Field0) = $00) Then
                                If (playerroom\Field7\Field6 = $69) Then
                                    msg\Field2 = format(getlocalstring("death", "106.dimension"), subjectname, "%s")
                                    kill($01, $01, $00, $01)
                                    arg0\Field10 = 0.0
                                ElseIf (playerroom\Field7\Field6 = $47) Then
                                    msg\Field2 = format(getlocalstring("death", "106.gatea"), subjectname, "%s")
                                    kill($01, $01, $00, $01)
                                ElseIf ((arg0\Field83 And (0.0 = me\Field0)) <> 0) Then
                                    playsound_strict(snd_i\Field45[$03], $01)
                                    showentity(me\Field61)
                                    positionentity(me\Field61, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
                                    resetentity(me\Field61)
                                    rotateentity(me\Field61, 0.0, (entityyaw(camera, $00) + rnd(-45.0, 45.0)), 0.0, $00)
                                    me\Field3 = min(-1.0, me\Field3)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    If (-250.0 > me\Field3) Then
                        mp_movetopocketdimension()
                    EndIf
                    If (0.0 = arg0\Field28) Then
                        If ((((100.0 < local1) And (isplayeroutsidefacility() = $00)) And (playerroom\Field7\Field6 <> $69)) <> 0) Then
                            If (entityinview(arg0\Field0, mp_getnpctargetcamera(arg0)) = $00) Then
                                turnentity(me\Field60, 0.0, 180.0, 0.0, $00)
                                local13 = $00
                                If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                    local13 = entitypick(me\Field60, 5.0)
                                EndIf
                                turnentity(me\Field60, 0.0, 180.0, 0.0, $00)
                                If (local13 <> $00) Then
                                    teleportentity(arg0\Field3, pickedx(), pickedy(), pickedz(), arg0\Field6, $00, 2.0, $00)
                                    pointentity(arg0\Field3, me\Field60, 0.0)
                                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $00)
                                    moveentity(arg0\Field3, 0.0, 0.0, -2.0)
                                    playsoundex(snd_i\Field45[$03], camera, arg0\Field3, 10.0, 1.0, $01, $00)
                                    arg0\Field20 = playsoundex(snd_i\Field45[rand($06, $08)], camera, arg0\Field3, 10.0, 1.0, $00, $00)
                                    arg0\Field41 = 0.0
                                    arg0\Field28 = (700.0 / ((Float selecteddifficulty\Field4) + 1.0))
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field28 = max(0.0, (arg0\Field28 - fps\Field7[$00]))
                    updatesoundorigin(arg0\Field20, camera, arg0\Field3, 10.0, 1.0, $00, $01)
                    If (local1 < (((fog\Field0 * lightvolume) * 0.6) * ((fog\Field0 * lightvolume) * 0.6))) Then
                        If (entityhidden(arg0\Field1) = $00) Then
                            hideentity(arg0\Field1)
                        EndIf
                    Else
                        If (entityhidden(arg0\Field1) <> 0) Then
                            showentity(arg0\Field1)
                        EndIf
                        entityalpha(arg0\Field1, min((sqr(local1) - ((fog\Field0 * lightvolume) * 0.6)), 1.0))
                    EndIf
                    positionentity(arg0\Field1, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                    rotateentity(arg0\Field1, 0.0, (entityyaw(arg0\Field3, $00) - 180.0), 0.0, $00)
                    moveentity(arg0\Field1, 0.0, 0.946, -0.165)
                    If (0.0 >= arg0\Field12) Then
                        If (((entityinview(arg0\Field0, mp_getnpctargetcamera(arg0)) = $00) And (25.0 < local1)) <> 0) Then
                            positionentity(arg0\Field3, 0.0, -500.0, 0.0, $00)
                            resetentity(arg0\Field3)
                            hideentity(arg0\Field1)
                            arg0\Field11 = rnd(22000.0, 27000.0)
                            arg0\Field10 = 0.0
                        EndIf
                    EndIf
                Case 4.0
                    If (((111.0 > arg0\Field14) Lor (259.0 < arg0\Field14)) <> 0) Then
                        local3 = createpivot($00)
                        positionentity(local3, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.1), entityz(arg0\Field3, $00), $00)
                        turnentity(local3, 90.0, 0.0, 0.0, $00)
                        If (entitypick(local3, 0.2) <> 0) Then
                            local0 = createdecal($00, entityx(arg0\Field3, $00), (pickedy() + 0.005), entityz(arg0\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.5, 0.7), rnd(0.8, 1.0), $00, $01, $00, $00, $00)
                            local0\Field4 = 0.004
                        EndIf
                        freeentity(local3)
                        local3 = $00
                        arg0\Field18 = playsoundex(loadtempsound("SFX\Ending\GateA\106Retreat.ogg"), camera, arg0\Field0, 10.0, 1.0, $01, $00)
                        setnpcframe(arg0, 259.0, $01)
                    Else
                        animatenpc(arg0, 259.0, 111.0, -0.15, $00)
                        If (150.0 >= arg0\Field14) Then
                            arg0\Field11 = rnd(38500.0, 47250.0)
                            arg0\Field10 = 0.0
                        EndIf
                    EndIf
                    If (entityhidden(arg0\Field1) = $00) Then
                        hideentity(arg0\Field1)
                    EndIf
            End Select
            If (1.0 < arg0\Field10) Then
                If (rand($1F4, $01) = $01) Then
                    playsoundex(snd_i\Field45[rand($00, $02)], camera, arg0\Field3, 10.0, 1.0, $00, $00)
                EndIf
                arg0\Field18 = loopsoundex(snd_i\Field45[$04], arg0\Field18, camera, arg0\Field3, 8.0, 0.8, $01)
            EndIf
            resetentity(arg0\Field3)
            arg0\Field7 = 0.0
            positionentity(arg0\Field0, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
            rotateentity(arg0\Field0, 0.0, entityyaw(arg0\Field3, $00), 0.0, $00)
        ElseIf (entityhidden(arg0\Field1) = $00) Then
            hideentity(arg0\Field1)
        EndIf
    EndIf
    Return $00
End Function
