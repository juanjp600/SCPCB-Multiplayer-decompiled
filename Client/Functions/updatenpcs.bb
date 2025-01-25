Function updatenpcs%()
    Local local0.npcs
    Local local1.npcs
    Local local2.doors
    Local local3.decals
    Local local4.rooms
    Local local5.events
    Local local6.waypoints
    Local local7%
    Local local8.waypoints
    Local local9.waypoints
    Local local10.emitter
    Local local11%
    Local local12%
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    Local local26%
    Local local27%
    Local local28%
    Local local29%
    Local local30%
    Local local31%
    Local local32%
    Local local33%
    Local local34%
    Local local35#
    Local local36#
    Local local37#
    Local local39%
    Local local40%
    Local local41#
    Local local44%
    Local local45%
    Local local47#
    Local local49%
    Local local50%
    Local local53#
    Local local54.rooms
    Local local55#
    Local local59#
    Local local60#
    Local local61%
    Local local62%
    Local local66.items
    Local local67.items
    Local local70#
    Local local74.forest
    Local local77%
    Local local78%
    Local local79$
    Local local89#
    Local local90%
    Local local92%
    Local local93%
    Local local94%
    Local local95%
    Local local96#
    Local local97#
    Local local98#
    Local local99#
    If (mp_getsocket() <> $00) Then
        Return mp_updatenpcs()
    EndIf
    catcherrors("UpdateNPCs()")
    For local0 = Each npcs
        local0\Field59 = isinfacility(entityy(local0\Field3, $00))
        local0\Field83 = $01
        Select local0\Field4
            Case $07
                If (((3.0 <> local0\Field26) And (isplayeroutsidefacility() = $00)) <> 0) Then
                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                    local0\Field12 = 1.0
                    positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.32), entityz(local0\Field3, $00), $00)
                    rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field3, $00) - 180.0), 0.0, $00)
                    positionentity(local0\Field1, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.32), entityz(local0\Field3, $00), $00)
                    rotateentity(local0\Field1, 0.0, ((entityyaw(local0\Field3, $00) - 180.0) + local0\Field15), 0.0, $00)
                    If (2.0 > local0\Field26) Then
                        If (0.1 < local0\Field27) Then
                            local0\Field26 = 1.0
                            local0\Field27 = max((local0\Field27 - fps\Field7[$00]), 0.1)
                        ElseIf (0.1 = local0\Field27) Then
                            local0\Field26 = 0.0
                            local0\Field27 = 0.0
                        EndIf
                        If (0.0 = local0\Field26) Then
                            local39 = $00
                            local40 = $01
                            If (225.0 > local13) Then
                                If (100.0 > local13) Then
                                    If (entityvisible(local0\Field3, me\Field60) <> 0) Then
                                        local39 = $01
                                        local0\Field36 = entityx(me\Field60, $01)
                                        local0\Field37 = entityy(me\Field60, $01)
                                        local0\Field38 = entityz(me\Field60, $01)
                                    EndIf
                                EndIf
                                local41 = clamp((distance(entityx(local0\Field3, $00), local0\Field31, entityz(local0\Field3, $00), local0\Field33, 0.0, 0.0) * 2.5), 0.0, 1.0)
                                local0\Field18 = loopsoundex(snd_i\Field12, local0\Field18, camera, local0\Field3, 10.0, local0\Field10, $00)
                                local0\Field31 = entityx(local0\Field3, $00)
                                local0\Field33 = entityz(local0\Field3, $00)
                                If (playersees173(local0) <> 0) Then
                                    local40 = $00
                                EndIf
                            EndIf
                            If (chs\Field2 <> 0) Then
                                local40 = $01
                            EndIf
                            If (local40 = $00) Then
                                local36 = sqr(local13)
                                me\Field48 = max(clamp(((4.0 - local36) / 6.0), 0.1, 0.9), me\Field48)
                                me\Field52 = max(me\Field52, (((sin(((Float millisec) / 20.0)) + 1.0) * 15.0) * max(((3.5 - local36) / 3.5), 0.0)))
                                If ((((12.25 > local13) And ((millisecs() - local0\Field29) > $EA60)) And local39) <> 0) Then
                                    playsound_strict(snd_i\Field47[rand($03, $04)], $00)
                                    local0\Field29 = millisecs()
                                EndIf
                                If (2.25 > local13) Then
                                    If (rand($2BC, $01) = $01) Then
                                        playsoundex(snd_i\Field46[rand($00, $02)], camera, local0\Field0, 10.0, 1.0, $00, $00)
                                    EndIf
                                    If (((2.0 < local0\Field30) And local39) <> 0) Then
                                        me\Field52 = 40.0
                                        me\Field28 = max(me\Field28, 140.0)
                                        me\Field30 = 0.5
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
                                    EndIf
                                EndIf
                                local0\Field30 = sqr(local13)
                                local0\Field10 = max(0.0, (local0\Field10 - (fps\Field7[$00] / 20.0)))
                            ElseIf (local13 > ((hidedistance * 0.8) * (hidedistance * 0.8))) Then
                                If (rand($46, $01) = $01) Then
                                    teleportcloser(local0)
                                EndIf
                            Else
                                local0\Field10 = curvevalue(local41, local0\Field10, 3.0)
                                If (rand(($14 - (selecteddifficulty\Field2 * $0A)), $01) = $01) Then
                                    For local2 = Each doors
                                        If (((((((local2\Field4 = $00) And (local2\Field6 = $00)) And (local2\Field19 = $00)) And (local2\Field14 = $00)) And (local2\Field10 <> $05)) And (local2\Field10 <> $04)) <> 0) Then
                                            For local11 = $00 To $01 Step $01
                                                If (local2\Field3[local11] <> $00) Then
                                                    If (0.5 > (Abs (entityx(local0\Field3, $00) - entityx(local2\Field3[local11], $00)))) Then
                                                        If (0.5 > (Abs (entityz(local0\Field3, $00) - entityz(local2\Field3[local11], $00)))) Then
                                                            If (((180.0 <= local2\Field8) Lor (0.0 >= local2\Field8)) <> 0) Then
                                                                local26 = createpivot($00)
                                                                positionentity(local26, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.5), entityz(local0\Field3, $00), $00)
                                                                pointentity(local26, local2\Field3[local11], 0.0)
                                                                moveentity(local26, 0.0, 0.0, (local0\Field23 * 0.6))
                                                                If (entitypick(local26, 0.5) = local2\Field3[local11]) Then
                                                                    playsound_strict(loadtempsound("SFX\Door\DoorOpen173.ogg"), $00)
                                                                    openclosedoor(local2, $01, $00)
                                                                    freeentity(local26)
                                                                    local26 = $00
                                                                    Exit
                                                                EndIf
                                                                freeentity(local26)
                                                                local26 = $00
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    Next
                                EndIf
                                If (chs\Field2 <> 0) Then
                                    local39 = $00
                                    local0\Field36 = 0.0
                                    local0\Field37 = 0.0
                                    local0\Field38 = 0.0
                                EndIf
                                If (local39 <> 0) Then
                                    If (i_268\Field2 = $00) Then
                                        local0\Field15 = deltayaw(local0\Field3, camera)
                                    EndIf
                                    If (0.4225 > local13) Then
                                        If (((0.0 = me\Field0) And (chs\Field0 = $00)) <> 0) Then
                                            Select playerroom\Field7\Field6
                                                Case $1C,$0D,$2C
                                                    msg\Field2 = format(getlocalstring("death", "173.gw"), subjectname, "%s")
                                                Case $04
                                                    msg\Field2 = format(getlocalstring("death", "173.intro"), subjectname, "%s")
                                                Case $0C
                                                    msg\Field2 = getlocalstring("death", "173.6")
                                                Default
                                                    msg\Field2 = format(getlocalstring("death", "173.default"), subjectname, "%s")
                                            End Select
                                            If (chs\Field0 = $00) Then
                                                local0\Field26 = 1.0
                                            EndIf
                                            playsound_strict(snd_i\Field53[rand($00, $02)], $00)
                                            If (rand($02, $01) = $01) Then
                                                turnentity(camera, 0.0, rnd(80.0, 100.0), 0.0, $00)
                                            Else
                                                turnentity(camera, 0.0, rnd(-100.0, -80.0), 0.0, $00)
                                            EndIf
                                            kill($00, $01, $00, $01)
                                        EndIf
                                    ElseIf (i_268\Field2 = $00) Then
                                        pointentity(local0\Field3, me\Field60, 0.0)
                                        rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), entityroll(local0\Field3, $00), $00)
                                        translateentity(local0\Field3, ((cos((entityyaw(local0\Field3, $00) + 90.0)) * local0\Field23) * fps\Field7[$00]), 0.0, ((sin((entityyaw(local0\Field3, $00) + 90.0)) * local0\Field23) * fps\Field7[$00]), $00)
                                    EndIf
                                ElseIf (0.0 <> local0\Field36) Then
                                    local0\Field15 = deltayaw(local0\Field3, camera)
                                    If (((0.25 < distancesquared(entityx(local0\Field3, $00), local0\Field36, entityz(local0\Field3, $00), local0\Field38, 0.0, 0.0)) And (i_268\Field2 = $00)) <> 0) Then
                                        aligntovector(local0\Field3, (local0\Field36 - entityx(local0\Field3, $00)), 0.0, (local0\Field38 - entityz(local0\Field3, $00)), $03, 1.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field23 * fps\Field7[$00]))
                                        If (rand($1F4, $01) = $01) Then
                                            local0\Field36 = 0.0
                                            local0\Field37 = 0.0
                                            local0\Field38 = 0.0
                                        EndIf
                                    Else
                                        local0\Field36 = 0.0
                                        local0\Field37 = 0.0
                                        local0\Field38 = 0.0
                                    EndIf
                                Else
                                    If (rand($190, $01) = $01) Then
                                        rotateentity(local0\Field3, 0.0, rnd(360.0, 0.0), 10.0, $00)
                                    EndIf
                                    translateentity(local0\Field3, ((cos((entityyaw(local0\Field3, $00) + 90.0)) * local0\Field23) * fps\Field7[$00]), 0.0, ((sin((entityyaw(local0\Field3, $00) + 90.0)) * local0\Field23) * fps\Field7[$00]), $00)
                                    If (chs\Field2 <> 0) Then
                                        local0\Field15 = 0.0
                                    Else
                                        local0\Field15 = rnd(-120.0, 120.0)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        positionentity(local0\Field3, entityx(local0\Field3, $00), min(entityy(local0\Field3, $00), 0.35), entityz(local0\Field3, $00), $00)
                    Else
                        If (n_i\Field8 <> Null) Then
                            local44 = $00
                            local13 = entitydistancesquared(local0\Field3, n_i\Field8\Field3)
                            If (local13 > ((hidedistance / 2.0) * (hidedistance / 2.0))) Then
                                If (entityinview(local0\Field0, camera) = $00) Then
                                    local44 = $01
                                EndIf
                            EndIf
                            If (local44 = $00) Then
                                pointentity(local0\Field0, n_i\Field8\Field3, 0.0)
                                rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 10.0), 0.0, $01)
                                moveentity(local0\Field3, 0.0, 0.0, (clamp((((sqr(local13) * 2.0) - 1.0) * 0.5), -0.5, 1.0) * (fps\Field7[$00] * 0.016)))
                                local0\Field48 = 1.0
                            Else
                                positionentity(local0\Field3, entityx(n_i\Field8\Field3, $00), (entityy(n_i\Field8\Field3, $00) + 0.3), entityz(n_i\Field8\Field3, $00), $00)
                                resetentity(local0\Field3)
                                local0\Field7 = 0.0
                                local0\Field48 = 0.0
                            EndIf
                        EndIf
                        local35 = ((sin(((Float millisec) * 0.08)) * 0.02) + 0.05)
                        positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + local35), entityz(local0\Field3, $00), $00)
                        rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field3, $00) - 180.0), 0.0, $00)
                        positionentity(local0\Field1, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + local35), entityz(local0\Field3, $00), $00)
                        rotateentity(local0\Field1, 0.0, ((entityyaw(local0\Field3, $00) - 180.0) + local0\Field15), 0.0, $00)
                        If (entityhidden(local0\Field2) <> 0) Then
                            showentity(local0\Field2)
                        EndIf
                        positionentity(local0\Field2, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - local35), entityz(local0\Field3, $00), $00)
                        rotateentity(local0\Field2, 0.0, (entityyaw(local0\Field3, $00) - 180.0), 0.0, $00)
                    EndIf
                EndIf
            Case $06
                If ((local0\Field65 Lor (playerroom\Field7\Field6 = $49)) <> 0) Then
                    If (entityhidden(local0\Field0) = $00) Then
                        local0\Field26 = 1.0
                        positionentity(local0\Field3, 0.0, -500.0, 0.0, $00)
                        resetentity(local0\Field3)
                        hideentity(local0\Field0)
                        hideentity(local0\Field1)
                    EndIf
                Else
                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                    local45 = $01
                    If (((playerroom\Field7\Field6 = $6A) Lor ((playerroom\Field7\Field6 = $3A) And (-11.125 >= entityy(me\Field60, $00)))) <> 0) Then
                        local45 = $00
                    EndIf
                    If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
                        If (20.0 < entityy(me\Field60, $00)) Then
                            local45 = $00
                        EndIf
                    EndIf
                    If (skull_event <> Null) Then
                        If (0.0 < skull_event\Field2) Then
                            local45 = $00
                        EndIf
                    EndIf
                    For local5 = Each events
                        If (local5\Field0 = $2E) Then
                            If (0.0 <> local5\Field2) Then
                                local45 = $01
                                local0\Field26 = (Float (playerroom\Field7\Field6 = $6A))
                            EndIf
                            Exit
                        EndIf
                    Next
                    If (((local45 = $00) And (1.0 < local0\Field10)) <> 0) Then
                        local0\Field11 = rnd(22000.0, 27000.0)
                        local0\Field10 = 0.0
                    EndIf
                    If (((0.0 = local0\Field26) And local45) <> 0) Then
                        Select local0\Field10
                            Case 0.0
                                positionentity(local0\Field3, 0.0, -500.0, 0.0, $00)
                                resetentity(local0\Field3)
                                local0\Field10 = 1.0
                            Case 1.0
                                If (playerroom\Field7\Field8 < $03) Then
                                    local47 = (fps\Field7[$00] * ((Float selecteddifficulty\Field2) + 1.0))
                                    Select playerroom\Field7\Field8
                                        Case $00
                                            local0\Field11 = max(0.0, (local0\Field11 - local47))
                                        Case $01
                                            local0\Field11 = max(0.0, (local0\Field11 - (local47 * 0.5)))
                                        Case $02
                                            If (2000.0 < local0\Field11) Then
                                                local0\Field11 = (local0\Field11 - (local47 * 0.25))
                                            EndIf
                                    End Select
                                EndIf
                                If (0.0 >= local0\Field11) Then
                                    local0\Field36 = entityx(me\Field60, $00)
                                    local0\Field37 = entityy(me\Field60, $00)
                                    local0\Field38 = entityz(me\Field60, $00)
                                    local0\Field10 = 2.0
                                EndIf
                            Case 2.0
                                shouldplay = $42
                                If ((((0.0 <> local0\Field36) Lor (0.0 <> local0\Field37)) Lor (0.0 <> local0\Field38)) <> 0) Then
                                    local26 = createpivot($00)
                                    positionentity(local26, local0\Field36, local0\Field37, local0\Field38, $00)
                                    turnentity(local26, 90.0, 0.0, 0.0, $00)
                                    If (entitypick(local26, 0.5) <> 0) Then
                                        local0\Field37 = pickedy()
                                    EndIf
                                    freeentity(local26)
                                    local26 = $00
                                    positionentity(local0\Field3, local0\Field36, local0\Field37, local0\Field38, $00)
                                    local3 = createdecal($00, local0\Field36, (local0\Field37 + 0.005), local0\Field38, 90.0, rnd(360.0, 0.0), 0.0, 0.05, 0.8, $00, $01, $00, $00, $00)
                                    local3\Field4 = 0.001
                                    entityparent(local3\Field0, playerroom\Field2, $01)
                                    setnpcframe(local0, 110.0, $01)
                                    playsound_strict(snd_i\Field24[$00], $00)
                                    local0\Field11 = 0.0
                                    local0\Field12 = 0.0
                                    local0\Field36 = 0.0
                                    local0\Field37 = 0.0
                                    local0\Field38 = 0.0
                                ElseIf (259.0 > local0\Field14) Then
                                    If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                        pointentity(local0\Field0, me\Field60, 0.0)
                                        rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 100.0), 0.0, $01)
                                    EndIf
                                    animatenpc(local0, 111.0, 259.0, 0.15, $00)
                                Else
                                    giveachievement("106", $01)
                                    local0\Field10 = 3.0
                                    local0\Field12 = rnd(3000.0, 3500.0)
                                EndIf
                            Case 3.0
                                local23 = $00
                                If (64.0 > local13) Then
                                    If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                        local23 = entityvisible(local0\Field3, me\Field60)
                                    EndIf
                                EndIf
                                If (local23 <> 0) Then
                                    If (playerroom\Field7\Field6 <> $47) Then
                                        local0\Field41 = 0.0
                                    EndIf
                                    If (entityinview(local0\Field3, camera) <> 0) Then
                                        local36 = (4.0 - sqr(local13))
                                        me\Field48 = max(clamp((local36 / 6.0), 0.1, 0.9), me\Field48)
                                        me\Field52 = max(me\Field52, (((sin(((Float millisec) / 20.0)) + 1.0) * 20.0) * max((local36 / 4.0), 0.0)))
                                        If ((millisecs() - local0\Field29) > $EA60) Then
                                            me\Field52 = 40.0
                                            playsound_strict(snd_i\Field47[$06], $00)
                                            local0\Field29 = millisecs()
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field12 = max(0.0, (local0\Field12 - fps\Field7[$00]))
                                EndIf
                                If (((playerroom\Field7\Field6 <> $47) And (playerroom\Field7\Field6 <> $69)) <> 0) Then
                                    shouldplay = $0A
                                EndIf
                                If (144.0 > local13) Then
                                    For local2 = Each doors
                                        If (((local2\Field27 = $00) And (local2\Field6 = $00)) <> 0) Then
                                            If (((0.25 > entitydistancesquared(local0\Field3, local2\Field2)) And ((local2\Field15 <> Null) And (local2\Field15\Field7\Field6 <> $69))) <> 0) Then
                                                If (((((local2\Field10 <> $04) And (local2\Field10 <> $05)) And (local2\Field10 <> $03)) And (local2\Field10 <> $07)) <> 0) Then
                                                    affectdecaydoor(local2)
                                                    Exit
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                If (0.64 < local13) Then
                                    local21 = local0\Field14
                                    If (((((((625.0 < local13) Lor (playerroom\Field7\Field6 = $69)) Lor local23) Lor (local0\Field40 <> $01)) And (playerroom\Field7\Field6 <> $47)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                        If (((16.0 < local13) Lor (playerroom\Field7\Field6 = $69)) <> 0) Then
                                            translateentity(local0\Field3, 0.0, (((entityy(me\Field60, $00) - 0.3) - entityy(local0\Field3, $00)) / 50.0), 0.0, $00)
                                        EndIf
                                        local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                                        pointentity(local0\Field0, me\Field60, 0.0)
                                        rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), (10.0 - (Float selecteddifficulty\Field4))), 0.0, $00)
                                        If (0.0 = me\Field0) Then
                                            animatenpc(local0, 284.0, 333.0, (local0\Field24 * 43.0), $01)
                                        Else
                                            local0\Field24 = 0.0
                                        EndIf
                                        local0\Field41 = max((local0\Field41 - fps\Field7[$00]), 0.0)
                                        If (0.0 >= local0\Field41) Then
                                            local0\Field40 = findpath(local0, entityx(me\Field60, $01), entityy(me\Field60, $01), entityz(me\Field60, $01))
                                            local0\Field41 = 700.0
                                        EndIf
                                    ElseIf (0.0 < local0\Field41) Then
                                        local0\Field41 = max((local0\Field41 - fps\Field7[$00]), 0.0)
                                        If (local0\Field40 = $01) Then
                                            While (local0\Field39[local0\Field42] = Null)
                                                If (local0\Field42 > $14) Then
                                                    local0\Field42 = $00
                                                    local0\Field40 = $00
                                                    Exit
                                                Else
                                                    local0\Field42 = (local0\Field42 + $01)
                                                EndIf
                                            Wend
                                            If (local0\Field39[local0\Field42] <> Null) Then
                                                translateentity(local0\Field3, 0.0, ((entityy(local0\Field39[local0\Field42]\Field0, $01) - entityy(local0\Field3, $00)) / 50.0), 0.0, $00)
                                                pointentity(local0\Field0, local0\Field39[local0\Field42]\Field0, 0.0)
                                                local14 = entitydistancesquared(local0\Field3, local0\Field39[local0\Field42]\Field0)
                                                rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), min(20.0, (sqr(local14) * 10.0))), 0.0, $00)
                                                local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                                                animatenpc(local0, 284.0, 333.0, (local0\Field24 * 43.0), $01)
                                                If (0.08 > local14) Then
                                                    local0\Field42 = (local0\Field42 + $01)
                                                EndIf
                                            EndIf
                                        Else
                                            local0\Field24 = curvevalue(0.0, local0\Field24, 10.0)
                                            animatenpc(local0, 334.0, 494.0, 0.3, $01)
                                        EndIf
                                    Else
                                        local0\Field40 = findpath(local0, entityx(me\Field60, $01), entityy(me\Field60, $01), entityz(me\Field60, $01))
                                        local0\Field41 = 700.0
                                        local0\Field24 = 0.0
                                    EndIf
                                    If (100.0 > local13) Then
                                        If (((286.0 >= local21) And (286.0 < local0\Field14)) <> 0) Then
                                            playsoundex(stepsfx($02, $00, rand($00, $02)), camera, local0\Field3, 6.0, rnd(0.8, 1.0), $00, $00)
                                            If (playerroom\Field7\Field6 = $47) Then
                                                local3 = createdecal($00, (entityx(local0\Field3, $01) + (cos(entityyaw(local0\Field3, $00)) * 0.1)), (playerroom\Field4 + 0.005), (entityz(local0\Field3, $01) - (sin(entityyaw(local0\Field3, $00)) * 0.1)), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 0.8, $00, $01, $00, $00, $00)
                                                local3\Field4 = -0.00002
                                                local3\Field13 = 90000.0
                                            Else
                                                local26 = createpivot($00)
                                                positionentity(local26, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.1), entityz(local0\Field3, $00), $00)
                                                turnentity(local26, 90.0, 0.0, 0.0, $00)
                                                If (entitypick(local26, 0.2) <> 0) Then
                                                    local3 = createdecal($00, (entityx(local0\Field3, $01) + (cos(entityyaw(local0\Field3, $00)) * 0.1)), (pickedy() + 0.005), (entityz(local0\Field3, $01) - (sin(entityyaw(local0\Field3, $00)) * 0.1)), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 0.8, $00, $01, $00, $00, $00)
                                                    local3\Field4 = -0.00002
                                                    local3\Field13 = 90000.0
                                                EndIf
                                                freeentity(local26)
                                                local26 = $00
                                            EndIf
                                        ElseIf (((311.0 >= local21) And (311.0 < local0\Field14)) <> 0) Then
                                            playsoundex(stepsfx($02, $00, rand($00, $02)), camera, local0\Field3, 6.0, rnd(0.8, 1.0), $00, $00)
                                            If (playerroom\Field7\Field6 = $47) Then
                                                local3 = createdecal($00, (entityx(local0\Field3, $01) - (cos(entityyaw(local0\Field3, $00)) * 0.1)), (playerroom\Field4 + 0.005), (entityz(local0\Field3, $01) + (sin(entityyaw(local0\Field3, $00)) * 0.1)), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 0.8, $00, $01, $00, $00, $00)
                                                local3\Field4 = -0.00002
                                                local3\Field13 = 90000.0
                                            Else
                                                local26 = createpivot($00)
                                                positionentity(local26, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.1), entityz(local0\Field3, $00), $00)
                                                turnentity(local26, 90.0, 0.0, 0.0, $00)
                                                If (entitypick(local26, 0.2) <> 0) Then
                                                    local3 = createdecal($00, (entityx(local0\Field3, $01) - (cos(entityyaw(local0\Field3, $00)) * 0.1)), (pickedy() + 0.005), (entityz(local0\Field3, $01) + (sin(entityyaw(local0\Field3, $00)) * 0.1)), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 0.8, $00, $01, $00, $00, $00)
                                                    local3\Field4 = -0.00002
                                                    local3\Field13 = 90000.0
                                                EndIf
                                                freeentity(local26)
                                                local26 = $00
                                            EndIf
                                        EndIf
                                    EndIf
                                ElseIf (chs\Field2 = $00) Then
                                    If (0.25 < local13) Then
                                        local0\Field24 = curvevalue((local0\Field23 * 2.5), local0\Field24, 10.0)
                                    Else
                                        local0\Field24 = 0.0
                                    EndIf
                                    animatenpc(local0, 105.0, 110.0, 0.15, $00)
                                    If (((0.0 = me\Field0) And (0.0 <= me\Field3)) <> 0) Then
                                        pointentity(local0\Field0, me\Field60, 0.0)
                                        rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), (10.0 - (Float selecteddifficulty\Field4))), 0.0, $00)
                                        If (((110.0 = ceil(local0\Field14)) And (chs\Field0 = $00)) <> 0) Then
                                            playsound_strict(snd_i\Field51[$01], $00)
                                            playsound_strict(snd_i\Field47[$05], $00)
                                            If (playerroom\Field7\Field6 = $69) Then
                                                msg\Field2 = format(getlocalstring("death", "106.dimension"), subjectname, "%s")
                                                kill($01, $01, $00, $01)
                                            ElseIf (playerroom\Field7\Field6 = $47) Then
                                                msg\Field2 = format(getlocalstring("death", "106.gatea"), subjectname, "%s")
                                                kill($01, $01, $00, $01)
                                            Else
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
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                If (-250.0 > me\Field3) Then
                                    movetopocketdimension()
                                EndIf
                                If (0.0 = local0\Field28) Then
                                    If ((((100.0 < local13) And (isplayeroutsidefacility() = $00)) And (playerroom\Field7\Field6 <> $69)) <> 0) Then
                                        If (entityinview(local0\Field0, camera) = $00) Then
                                            turnentity(me\Field60, 0.0, 180.0, 0.0, $00)
                                            If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                                local27 = entitypick(me\Field60, 5.0)
                                            Else
                                                local27 = $00
                                            EndIf
                                            turnentity(me\Field60, 0.0, 180.0, 0.0, $00)
                                            If (local27 <> $00) Then
                                                teleportentity(local0\Field3, pickedx(), pickedy(), pickedz(), local0\Field6, $00, 2.0, $00)
                                                pointentity(local0\Field3, me\Field60, 0.0)
                                                rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $00)
                                                moveentity(local0\Field3, 0.0, 0.0, -2.0)
                                                playsoundex(snd_i\Field45[$03], camera, local0\Field3, 10.0, 1.0, $01, $00)
                                                local0\Field20 = playsoundex(snd_i\Field45[rand($06, $08)], camera, local0\Field3, 10.0, 1.0, $00, $00)
                                                local0\Field41 = 0.0
                                                local0\Field28 = (700.0 / ((Float selecteddifficulty\Field4) + 1.0))
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                                local0\Field28 = max(0.0, (local0\Field28 - fps\Field7[$00]))
                                updatesoundorigin(local0\Field20, camera, local0\Field3, 10.0, 1.0, $00, $01)
                                If (local13 < (((fog\Field0 * lightvolume) * 0.6) * ((fog\Field0 * lightvolume) * 0.6))) Then
                                    If (entityhidden(local0\Field1) = $00) Then
                                        hideentity(local0\Field1)
                                    EndIf
                                Else
                                    If (entityhidden(local0\Field1) <> 0) Then
                                        showentity(local0\Field1)
                                    EndIf
                                    entityalpha(local0\Field1, min((sqr(local13) - ((fog\Field0 * lightvolume) * 0.6)), 1.0))
                                EndIf
                                positionentity(local0\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field3, $00) - 180.0), 0.0, $00)
                                moveentity(local0\Field1, 0.0, 0.946, -0.165)
                                If (0.0 >= local0\Field12) Then
                                    If (((entityinview(local0\Field0, camera) = $00) And (25.0 < local13)) <> 0) Then
                                        positionentity(local0\Field3, 0.0, -500.0, 0.0, $00)
                                        resetentity(local0\Field3)
                                        hideentity(local0\Field1)
                                        local0\Field11 = rnd(22000.0, 27000.0)
                                        local0\Field10 = 0.0
                                    EndIf
                                EndIf
                            Case 4.0
                                If (((111.0 > local0\Field14) Lor (259.0 < local0\Field14)) <> 0) Then
                                    local26 = createpivot($00)
                                    positionentity(local26, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.1), entityz(local0\Field3, $00), $00)
                                    turnentity(local26, 90.0, 0.0, 0.0, $00)
                                    If (entitypick(local26, 0.2) <> 0) Then
                                        local3 = createdecal($00, entityx(local0\Field3, $00), (pickedy() + 0.005), entityz(local0\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.5, 0.7), rnd(0.8, 1.0), $00, $01, $00, $00, $00)
                                        local3\Field4 = 0.004
                                    EndIf
                                    freeentity(local26)
                                    local26 = $00
                                    local0\Field18 = playsoundex(loadtempsound("SFX\Ending\GateA\106Retreat.ogg"), camera, local0\Field0, 10.0, 1.0, $01, $00)
                                    setnpcframe(local0, 259.0, $01)
                                Else
                                    animatenpc(local0, 259.0, 111.0, -0.15, $00)
                                    If (150.0 >= local0\Field14) Then
                                        local0\Field11 = rnd(38500.0, 47250.0)
                                        local0\Field10 = 0.0
                                    EndIf
                                EndIf
                                If (entityhidden(local0\Field1) = $00) Then
                                    hideentity(local0\Field1)
                                EndIf
                        End Select
                        If (1.0 < local0\Field10) Then
                            If (rand($1F4, $01) = $01) Then
                                playsoundex(snd_i\Field45[rand($00, $02)], camera, local0\Field3, 10.0, 1.0, $00, $00)
                            EndIf
                            local0\Field18 = loopsoundex(snd_i\Field45[$04], local0\Field18, camera, local0\Field3, 8.0, 0.8, $01)
                        EndIf
                        resetentity(local0\Field3)
                        local0\Field7 = 0.0
                        positionentity(local0\Field0, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                        rotateentity(local0\Field0, 0.0, entityyaw(local0\Field3, $00), 0.0, $00)
                    ElseIf (entityhidden(local0\Field1) = $00) Then
                        hideentity(local0\Field1)
                    EndIf
                EndIf
            Case $05
                If (1.0 = local0\Field26) Then
                    If (((local0\Field18 <> $00) And local0\Field21) <> 0) Then
                        stopstream_strict(local0\Field18)
                        local0\Field18 = $00
                        local0\Field21 = $00
                    EndIf
                    local0\Field7 = 0.0
                Else
                    local13 = entitydistancesquared(me\Field60, local0\Field3)
                    local15 = wrapangle(deltayaw(local0\Field3, me\Field60), 360.0)
                    local49 = ((((local13 < ((fog\Field0 * lightvolume) * (fog\Field0 * lightvolume))) And ((135.0 > local15) Lor (225.0 < local15))) And entityvisible(camera, local0\Field1)) And entityinview(local0\Field1, camera))
                    If (((wi\Field9 > $00) And local49) <> 0) Then
                        local50 = $00
                        For local11 = $00 To (maxitemamount - $01) Step $01
                            If (inventory(local11) <> Null) Then
                                If ((((wi\Field9 = $01) And (inventory(local11)\Field4\Field2 = $43)) Lor ((wi\Field9 = $02) And (inventory(local11)\Field4\Field2 = $44))) <> 0) Then
                                    If (0.0 < inventory(local11)\Field12) Then
                                        inventory(local11)\Field12 = max(0.0, (inventory(local11)\Field12 - (fps\Field7[$00] * (0.08 / (Float wi\Field9)))))
                                        local50 = $01
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If (local50 <> 0) Then
                            If (channelplaying(scramblechn) = $00) Then
                                scramblechn = playsound_strict(snd_i\Field39, $00)
                            EndIf
                            If (entityhidden(local0\Field1) <> 0) Then
                                showentity(local0\Field1)
                            EndIf
                            scalesprite(local0\Field1, rnd(0.06, 0.08), rnd(0.07, 0.09))
                            positionentity(local0\Field1, (rnd(0.1, 0.0) - 0.05), (rnd(0.1, 0.0) - 0.05), (rnd(0.1, 0.0) - 0.05), $00)
                        Else
                            If (entityhidden(local0\Field1) = $00) Then
                                hideentity(local0\Field1)
                            EndIf
                            If (channelplaying(scramblechn) <> 0) Then
                                stopchannel(scramblechn)
                                scramblechn = $00
                            EndIf
                        EndIf
                    Else
                        If (entityhidden(local0\Field1) = $00) Then
                            hideentity(local0\Field1)
                        EndIf
                        If (channelplaying(scramblechn) <> 0) Then
                            stopchannel(scramblechn)
                            scramblechn = $00
                        EndIf
                    EndIf
                    Select local0\Field10
                        Case 0.0
                            If (64.0 > local13) Then
                                If (local0\Field18 = $00) Then
                                    local0\Field18 = streamsound_strict("SFX\Music\096.ogg", 0.0, $02)
                                    local0\Field21 = $01
                                EndIf
                                If (-1.0 = local0\Field12) Then
                                    animatenpc(local0, 936.0, 1263.0, 0.1, $00)
                                    If (1262.9 <= local0\Field14) Then
                                        setnpcframe(local0, 312.0, $01)
                                        local0\Field12 = 0.0
                                        local0\Field10 = 1.0
                                    EndIf
                                Else
                                    animatenpc(local0, 936.0, 1263.0, 0.1, $01)
                                    If (420.0 > local0\Field12) Then
                                        local0\Field12 = (local0\Field12 + fps\Field7[$00])
                                    ElseIf (rand($05, $01) = $01) Then
                                        local0\Field12 = -1.0
                                    Else
                                        local0\Field12 = ((Float rand($00, $03)) * 70.0)
                                    EndIf
                                EndIf
                                If (chs\Field2 = $00) Then
                                    If (((wi\Field9 = $00) And local49) <> 0) Then
                                        If (((((-16.0 > me\Field10) Lor (-6.0 < me\Field10)) And (0.0 = i_1025\Field1[$04])) And (wi\Field7 = $00)) <> 0) Then
                                            playsound_strict(loadtempsound("SFX\SCP\096\Triggered.ogg"), $01)
                                            s2imaperase(unlockedachievements, "096")
                                            me\Field52 = 10.0
                                            setnpcframe(local0, 194.0, $01)
                                            stopstream_strict(local0\Field18)
                                            local0\Field18 = $00
                                            local0\Field21 = $00
                                            local0\Field17 = $00
                                            local0\Field12 = 0.0
                                            local0\Field10 = 2.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            updatestreamsoundorigin(local0\Field18, camera, local0\Field3, 8.0, 1.0, $01)
                        Case 1.0
                            If (256.0 > local13) Then
                                If (local0\Field18 = $00) Then
                                    local0\Field18 = streamsound_strict("SFX\Music\096.ogg", 0.0, $02)
                                    local0\Field21 = $01
                                EndIf
                                local21 = local0\Field14
                                If (422.0 <= local0\Field14) Then
                                    local0\Field11 = (local0\Field11 + fps\Field7[$00])
                                    If (1000.0 < local0\Field11) Then
                                        If (1600.0 < local0\Field11) Then
                                            local0\Field11 = rnd(0.0, 500.0)
                                        EndIf
                                        If (1382.0 > local0\Field14) Then
                                            local0\Field24 = curvevalue((local0\Field23 * 0.1), local0\Field24, 5.0)
                                            animatenpc(local0, 1369.0, 1382.0, (local0\Field24 * 45.0), $00)
                                        Else
                                            local0\Field24 = curvevalue((local0\Field23 * 0.1), local0\Field24, 5.0)
                                            animatenpc(local0, 1383.0, 1456.0, (local0\Field24 * 45.0), $01)
                                        EndIf
                                        If ((Float millisecs()) > local0\Field12) Then
                                            local0\Field29 = $00
                                            If (entityvisible(me\Field60, local0\Field3) <> 0) Then
                                                local0\Field29 = $01
                                            Else
                                                hideentity(local0\Field3)
                                                entitypick(local0\Field3, 1.5)
                                                If (pickedentity() <> $00) Then
                                                    local0\Field15 = (entityyaw(local0\Field3, $00) + rnd(80.0, 110.0))
                                                EndIf
                                                showentity(local0\Field3)
                                            EndIf
                                            local0\Field12 = (Float (millisecs() + $7D0))
                                        EndIf
                                        If (local0\Field29 <> 0) Then
                                            pointentity(local0\Field0, me\Field60, 0.0)
                                            rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 130.0), 0.0, $00)
                                            If (2.25 > local13) Then
                                                local0\Field11 = 0.0
                                            EndIf
                                        Else
                                            rotateentity(local0\Field3, 0.0, curveangle(local0\Field15, entityyaw(local0\Field3, $00), 50.0), 0.0, $00)
                                        EndIf
                                    ElseIf (472.0 < local0\Field14) Then
                                        local0\Field24 = curvevalue((local0\Field23 * 0.05), local0\Field24, 8.0)
                                        animatenpc(local0, 1383.0, 1469.0, (local0\Field24 * 45.0), $00)
                                        If (1468.9 <= local0\Field14) Then
                                            setnpcframe(local0, 423.0, $01)
                                        EndIf
                                    Else
                                        local0\Field24 = curvevalue(0.0, local0\Field24, 4.0)
                                        animatenpc(local0, 423.0, 471.0, 0.2, $01)
                                    EndIf
                                    moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                Else
                                    animatenpc(local0, 312.0, 422.0, 0.3, $00)
                                EndIf
                                If (chs\Field2 = $00) Then
                                    If (((wi\Field9 = $00) And local49) <> 0) Then
                                        If (((((-16.0 > me\Field10) Lor (-6.0 < me\Field10)) And (0.0 = i_1025\Field1[$04])) And (wi\Field7 = $00)) <> 0) Then
                                            playsound_strict(loadtempsound("SFX\SCP\096\Triggered.ogg"), $01)
                                            s2imaperase(unlockedachievements, "096")
                                            me\Field52 = 10.0
                                            If (422.0 <= local0\Field14) Then
                                                setnpcframe(local0, 677.0, $01)
                                            EndIf
                                            stopstream_strict(local0\Field18)
                                            local0\Field18 = $00
                                            local0\Field21 = $00
                                            local0\Field17 = $00
                                            local0\Field10 = 3.0
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.001 < local0\Field24) Then
                                    If (((((1383.0 > local21) And (1383.0 <= local0\Field14)) Lor ((1420.0 > local21) And (1420.0 <= local0\Field14))) Lor ((1466.0 > local21) And (1466.0 <= local0\Field14))) <> 0) Then
                                        playsoundex(snd_i\Field56[rand($0A, $0C)], camera, local0\Field3, 8.0, rnd(0.8, 1.0), $00, $00)
                                    EndIf
                                EndIf
                            EndIf
                            updatestreamsoundorigin(local0\Field18, camera, local0\Field3, 14.0, 1.0, $01)
                        Case 2.0,3.0,4.0
                            If (local0\Field18 = $00) Then
                                local0\Field18 = streamsound_strict("SFX\Music\096Angered.ogg", 0.0, $02)
                                local0\Field21 = $01
                            EndIf
                            updatestreamsoundorigin(local0\Field18, camera, local0\Field3, 10.0, 1.0, $01)
                            If (2.0 = local0\Field10) Then
                                If (312.0 > local0\Field14) Then
                                    animatenpc(local0, 193.0, 311.0, 0.3, $00)
                                    If (310.9 < local0\Field14) Then
                                        setnpcframe(local0, 737.0, $01)
                                        local0\Field10 = 3.0
                                    EndIf
                                ElseIf (((312.0 <= local0\Field14) And (422.0 >= local0\Field14)) <> 0) Then
                                    animatenpc(local0, 312.0, 422.0, 0.3, $00)
                                    If (421.9 < local0\Field14) Then
                                        setnpcframe(local0, 677.0, $01)
                                    EndIf
                                Else
                                    animatenpc(local0, 677.0, 736.0, 0.3, $00)
                                    If (735.9 < local0\Field14) Then
                                        setnpcframe(local0, 737.0, $01)
                                        local0\Field10 = 3.0
                                    EndIf
                                EndIf
                            ElseIf (3.0 = local0\Field10) Then
                                animatenpc(local0, 677.0, 737.0, 0.3, $00)
                                If (737.0 <= local0\Field14) Then
                                    local0\Field11 = 0.0
                                    local0\Field10 = 4.0
                                EndIf
                            ElseIf (4.0 = local0\Field10) Then
                                local0\Field11 = (local0\Field11 + fps\Field7[$00])
                                If (1820.0 < local0\Field11) Then
                                    animatenpc(local0, 823.0, 847.0, (local0\Field23 * 8.0), $00)
                                    If (846.9 < local0\Field14) Then
                                        stopstream_strict(local0\Field18)
                                        local0\Field18 = $00
                                        local0\Field21 = $00
                                        local0\Field10 = 5.0
                                    EndIf
                                Else
                                    animatenpc(local0, 1471.0, 1556.0, 0.4, $01)
                                EndIf
                            EndIf
                        Case 5.0
                            me\Field52 = curvevalue(max(me\Field52, ((sin(((Float millisec) / 20.0)) + 1.0) * 10.0)), me\Field52, 8.0)
                            If (local0\Field34 = Null) Then
                                If (local0\Field18 = $00) Then
                                    local0\Field18 = streamsound_strict("SFX\SCP\096\Scream.ogg", 0.0, $02)
                                    local0\Field21 = $01
                                EndIf
                                updatestreamsoundorigin(local0\Field18, camera, local0\Field3, 7.5, 1.0, $01)
                                If (local0\Field20 = $00) Then
                                    local0\Field20 = streamsound_strict("SFX\Music\096Chase.ogg", 0.0, $02)
                                    local0\Field22 = $01
                                Else
                                    setstreamvolume_strict(local0\Field20, ((clamp((8.0 - sqr(local13)), 0.6, 1.0) * opt\Field21) * opt\Field16))
                                EndIf
                            EndIf
                            If (0.0 = me\Field0) Then
                                If (local0\Field34 <> Null) Then
                                    local13 = entitydistancesquared(local0\Field34\Field3, local0\Field3)
                                EndIf
                                If ((Float millisecs()) > local0\Field12) Then
                                    local0\Field29 = $00
                                    If (local0\Field34 = Null) Then
                                        If (((64.0 > local13) And entityvisible(me\Field60, local0\Field3)) <> 0) Then
                                            local0\Field29 = $01
                                        EndIf
                                    ElseIf (((64.0 > local13) And entityvisible(local0\Field34\Field3, local0\Field3)) <> 0) Then
                                        local0\Field29 = $01
                                    EndIf
                                    local0\Field12 = (Float (millisecs() + $7D0))
                                EndIf
                                If ((chs\Field2 And (local0\Field34 = Null)) <> 0) Then
                                    local0\Field29 = $00
                                EndIf
                                If (local0\Field29 = $01) Then
                                    local0\Field41 = max(210.0, local0\Field41)
                                    local0\Field40 = $00
                                    If (((7.84 > local13) Lor (150.0 > local0\Field14)) <> 0) Then
                                        If (193.0 < local0\Field14) Then
                                            setnpcframe(local0, 2.0, $01)
                                        EndIf
                                        animatenpc(local0, 2.0, 193.0, 0.7, $01)
                                        If (1.0 < local13) Then
                                            local0\Field24 = curvevalue((local0\Field23 * 2.0), local0\Field24, 15.0)
                                        Else
                                            local0\Field24 = 0.0
                                            If (local0\Field34 = Null) Then
                                                If (chs\Field0 = $00) Then
                                                    playsound_strict(snd_i\Field51[$04], $00)
                                                    me\Field23 = 30.0
                                                    me\Field49 = 2000.0
                                                    msg\Field2 = format(getlocalstring("death", "096"), subjectname, "%s")
                                                    For local11 = $00 To $09 Step $01
                                                        local26 = createpivot($00)
                                                        positionentity(local26, (entityx(me\Field60, $00) + rnd(-0.8, 0.8)), (entityy(me\Field60, $00) - 0.05), (entityz(me\Field60, $00) + rnd(-0.8, 0.8)), $00)
                                                        turnentity(local26, 90.0, 0.0, 0.0, $00)
                                                        entitypick(local26, 0.3)
                                                        local3 = createdecal(rand($10, $11), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.1, 0.3), 1.0, $00, $01, $00, $00, $00)
                                                        entityparent(local3\Field0, playerroom\Field2, $01)
                                                        freeentity(local26)
                                                        local26 = $00
                                                    Next
                                                    kill($01, $01, $00, $01)
                                                    me\Field1 = $01
                                                    changenpctextureid(local0, $12)
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (local0\Field34 = Null) Then
                                            pointentity(local0\Field3, me\Field60, 0.0)
                                        Else
                                            pointentity(local0\Field3, local0\Field34\Field3, 0.0)
                                        EndIf
                                    Else
                                        If (local0\Field34 = Null) Then
                                            pointentity(local0\Field0, me\Field60, 0.0)
                                        Else
                                            pointentity(local0\Field0, local0\Field34\Field3, 0.0)
                                        EndIf
                                        rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 5.0), 0.0, $00)
                                        If (847.0 < local0\Field14) Then
                                            local0\Field24 = curvevalue(local0\Field23, local0\Field24, 20.0)
                                        EndIf
                                        If (906.0 > local0\Field14) Then
                                            animatenpc(local0, 737.0, 906.0, (local0\Field23 * 8.0), $00)
                                        Else
                                            animatenpc(local0, 907.0, 935.0, (local0\Field24 * 8.0), $01)
                                        EndIf
                                    EndIf
                                    rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $01)
                                    moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                ElseIf (0.0 >= local0\Field41) Then
                                    If (local0\Field34 <> Null) Then
                                        local0\Field40 = findpath(local0, entityx(local0\Field34\Field3, $00), (entityy(local0\Field34\Field3, $00) + 0.2), entityz(local0\Field34\Field3, $00))
                                    Else
                                        local0\Field40 = findpath(local0, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
                                    EndIf
                                    local0\Field41 = 350.0
                                ElseIf (((local0\Field40 = $01) And (chs\Field2 = $00)) <> 0) Then
                                    If (local0\Field39[local0\Field42] = Null) Then
                                        If (local0\Field42 > $14) Then
                                            local0\Field42 = $00
                                            local0\Field40 = $00
                                        Else
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field0, local0\Field39[local0\Field42]\Field0, 0.0)
                                        rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 5.0), 0.0, $00)
                                        If (847.0 < local0\Field14) Then
                                            local0\Field24 = curvevalue((local0\Field23 * 1.5), local0\Field24, 15.0)
                                        EndIf
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                        If (906.0 > local0\Field14) Then
                                            animatenpc(local0, 737.0, 906.0, (local0\Field23 * 8.0), $00)
                                        Else
                                            animatenpc(local0, 907.0, 935.0, (local0\Field24 * 8.0), $01)
                                        EndIf
                                        local14 = entitydistancesquared(local0\Field3, local0\Field39[local0\Field42]\Field0)
                                        If (0.64 > local14) Then
                                            If (local0\Field39[local0\Field42]\Field1 <> Null) Then
                                                If (local0\Field39[local0\Field42]\Field1\Field6 = $00) Then
                                                    local0\Field39[local0\Field42]\Field1\Field6 = $01
                                                    local0\Field39[local0\Field42]\Field1\Field9 = $01
                                                    local0\Field39[local0\Field42]\Field1\Field4 = $01
                                                    If (36.0 > local13) Then
                                                        me\Field24 = 3.0
                                                    EndIf
                                                    local10 = setemitter(Null, entityx(local0\Field39[local0\Field42]\Field1\Field0, $01), entityy(local0\Field39[local0\Field42]\Field1\Field0, $01), entityz(local0\Field39[local0\Field42]\Field1\Field0, $01), $10)
                                                    entityparent(local10\Field6, local0\Field39[local0\Field42]\Field1\Field0, $01)
                                                    playsoundex(snd_i\Field9, camera, local0\Field39[local0\Field42]\Field1\Field2, 10.0, 1.0, $00, $00)
                                                EndIf
                                            EndIf
                                            If (0.04 > local14) Then
                                                local0\Field42 = (local0\Field42 + $01)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local0\Field41 = max(0.0, (local0\Field41 - fps\Field7[$00]))
                                Else
                                    local0\Field24 = 0.0
                                    animatenpc(local0, 1471.0, 1556.0, 0.1, $01)
                                    local0\Field41 = max(0.0, (local0\Field41 - (fps\Field7[$00] * 2.0)))
                                EndIf
                                If (rand($32, $01) = $01) Then
                                    If (400.0 < local13) Then
                                        teleportcloser(local0)
                                    EndIf
                                EndIf
                            Else
                                animatenpc(local0, min(27.0, animtime(local0\Field0)), 193.0, 0.5, $01)
                            EndIf
                    End Select
                    If (1.0 < local0\Field10) Then
                        For local5 = Each events
                            If (local5\Field0 = $20) Then
                                If (0.0 = local5\Field2) Then
                                    For local11 = $00 To $01 Step $01
                                        local5\Field1\Field14[local11]\Field4 = $00
                                    Next
                                    local5\Field2 = 3150.0
                                    removeevent(local5)
                                EndIf
                                Exit
                            EndIf
                        Next
                        If (local0\Field34 = Null) Then
                            cansave = $02
                        EndIf
                    EndIf
                EndIf
                positionentity(local0\Field0, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), 0.0, $00)
            Case $02
                If (0.1 < local0\Field26) Then
                    If (playerroom\Field7\Field6 <> $3A) Then
                        local0\Field26 = max((local0\Field26 - ((Float (selecteddifficulty\Field2 + $01)) * fps\Field7[$00])), 0.1)
                    EndIf
                    local0\Field7 = 0.0
                    If (channelplaying(local0\Field18) <> 0) Then
                        stopchannel(local0\Field18)
                        local0\Field18 = $00
                    EndIf
                    If (channelplaying(local0\Field20) <> 0) Then
                        stopchannel(local0\Field20)
                        local0\Field20 = $00
                    EndIf
                    positionentity(local0\Field3, 0.0, -500.0, 0.0, $00)
                    resetentity(local0\Field3)
                Else
                    local21 = local0\Field14
                    local13 = entitydistancesquared(me\Field60, local0\Field3)
                    updatenpcblinking(local0)
                    If (0.25 <= local13) Then
                        remove714timer = min((fps\Field7[$00] + remove714timer), 500.0)
                        removehazmattimer = min((fps\Field7[$00] + removehazmattimer), 500.0)
                    ElseIf (chs\Field2 = $00) Then
                        If (entityvisible(me\Field60, local0\Field3) <> 0) Then
                            If (((1.0 < local0\Field10) And (3.0 <> local0\Field10)) <> 0) Then
                                If (wi\Field2 > $00) Then
                                    removehazmattimer = (removehazmattimer - (fps\Field7[$00] * 1.5))
                                    If ((((350.0 > removehazmattimer) And (350.0 <= ((fps\Field7[$00] * 1.5) + removehazmattimer))) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                        local0\Field20 = playsoundex(loadtempsound("SFX\SCP\049\TakeOffHazmat.ogg"), camera, local0\Field3, 10.0, 1.0, $01, $00)
                                    ElseIf (0.0 >= removehazmattimer) Then
                                        For local11 = $00 To $02 Step $01
                                            If (((removehazmattimer < (- (((Float (wi\Field2 = $04)) * 250.0) * (Float local11)))) And ((- (((Float (wi\Field2 = $04)) * 250.0) * (Float local11))) <= ((fps\Field7[$00] * 1.5) + removehazmattimer))) <> 0) Then
                                                me\Field23 = 2.0
                                                If (local11 = $02) Then
                                                    For local11 = $00 To (maxitemamount - $01) Step $01
                                                        If (inventory(local11) <> Null) Then
                                                            If (((inventory(local11)\Field4\Field2 >= $3C) And (inventory(local11)\Field4\Field2 <= $3F)) <> 0) Then
                                                                createmsg(getlocalstring("msg", "suit.destroyed"), 6.0)
                                                                wi\Field2 = $00
                                                                removeitem(inventory(local11))
                                                                Exit
                                                            EndIf
                                                        EndIf
                                                    Next
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                ElseIf (i_714\Field0 > $00) Then
                                    me\Field49 = (me\Field49 + (fps\Field7[$00] * 2.5))
                                    If (i_268\Field2 <> 0) Then
                                        remove714timer = min(remove714timer, 499.0)
                                    Else
                                        remove714timer = (remove714timer - (fps\Field7[$00] * (3.0 / (Float i_714\Field0))))
                                        If ((((350.0 > remove714timer) And (350.0 <= ((fps\Field7[$00] * 1.5) + remove714timer))) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                            If (i_714\Field0 = $02) Then
                                                local0\Field20 = playsoundex(loadtempsound("SFX\SCP\049\714Equipped.ogg"), camera, local0\Field3, 10.0, 1.0, $01, $00)
                                            EndIf
                                        ElseIf (0.0 >= remove714timer) Then
                                            For local11 = $00 To (maxitemamount - $01) Step $01
                                                If (inventory(local11) <> Null) Then
                                                    If (((inventory(local11)\Field4\Field2 = $1B) Lor (inventory(local11)\Field4\Field2 = $1A)) <> 0) Then
                                                        createmsg(getlocalstring("msg", "714.forceremoved"), 6.0)
                                                        i_714\Field0 = $00
                                                        dropitem(inventory(local11), $01)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                Else
                                    me\Field52 = 20.0
                                    me\Field49 = 500.0
                                    If (chs\Field0 = $00) Then
                                        If (playerroom\Field7\Field6 = $3A) Then
                                            For local5 = Each events
                                                If (local5\Field0 = $24) Then
                                                    local5\Field2 = -1.0
                                                    Exit
                                                EndIf
                                            Next
                                            If (0.0 <= me\Field3) Then
                                                showentity(me\Field61)
                                                positionentity(me\Field61, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
                                                resetentity(me\Field61)
                                                rotateentity(me\Field61, 0.0, (entityyaw(camera, $00) + rnd(-45.0, 45.0)), 0.0, $00)
                                                me\Field3 = min(-1.0, me\Field3)
                                            EndIf
                                        Else
                                            msg\Field2 = getlocalstring("death", "049")
                                            kill($00, $01, $00, $01)
                                            me\Field1 = $00
                                        EndIf
                                        playsound_strict(loadtempsound("SFX\SCP\049\Horror.ogg"), $00)
                                        loadnpcsound(local0, (("SFX\SCP\049\Kidnap" + (Str rand($00, $01))) + ".ogg"), $01)
                                        local0\Field20 = playsound_strict(local0\Field19, $01)
                                        local0\Field10 = 3.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    local0\Field18 = loopsoundex(npcsound[$05], local0\Field18, camera, local0\Field3, 10.0, 1.0, $01)
                    If (0.1 = local0\Field26) Then
                        If (playerinreachableroom($00, $00) <> 0) Then
                            For local11 = $00 To $03 Step $01
                                If (playerroom\Field19[local11] <> Null) Then
                                    For local12 = $00 To $03 Step $01
                                        If (playerroom\Field19[local11]\Field19[local12] <> Null) Then
                                            If (playerroom\Field19[local11]\Field19[local12] <> playerroom) Then
                                                If (playerroom\Field19[local11]\Field19[local12]\Field30 <> $00) Then
                                                    teleportentity(local0\Field3, entityx(playerroom\Field19[local11]\Field19[local12]\Field30, $01), 0.5, entityz(playerroom\Field19[local11]\Field19[local12]\Field30, $01), local0\Field6, $01, 2.0, $00)
                                                Else
                                                    teleportentity(local0\Field3, playerroom\Field19[local11]\Field19[local12]\Field3, 0.5, playerroom\Field19[local11]\Field19[local12]\Field5, local0\Field6, $01, 2.0, $00)
                                                EndIf
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    Exit
                                EndIf
                            Next
                            local0\Field26 = 0.0
                        EndIf
                    EndIf
                    Select local0\Field10
                        Case 0.0
                        Case 1.0
                            If (538.0 <= local0\Field14) Then
                                animatenpc(local0, 659.0, 538.0, -0.45, $00)
                                If (537.9 < local0\Field14) Then
                                    setnpcframe(local0, 37.0, $01)
                                EndIf
                            Else
                                animatenpc(local0, 37.0, 269.0, 0.7, $00)
                                If (268.9 < local0\Field14) Then
                                    local0\Field10 = 2.0
                                EndIf
                            EndIf
                        Case 2.0
                            If ((((local13 < ((hidedistance * 2.0) * (hidedistance * 2.0))) And (0.0 = local0\Field26)) And playerinreachableroom($01, $00)) <> 0) Then
                                local0\Field11 = max((local0\Field11 - fps\Field7[$00]), 0.0)
                                local22 = npcseesplayer(local0, ((8.0 - me\Field40) + me\Field42), 60.0, $00)
                                If (0.0 < local0\Field11) Then
                                    If (local22 = $01) Then
                                        local0\Field11 = 140.0
                                    EndIf
                                    If (((local0\Field13 <= $01) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                        loadnpcsound(local0, (("SFX\SCP\049\Spotted" + (Str rand($00, $06))) + ".ogg"), $01)
                                        local0\Field20 = playsoundex(local0\Field19, camera, local0\Field0, 10.0, 1.0, $01, $00)
                                        local0\Field13 = $02
                                    EndIf
                                    local0\Field40 = $00
                                    local0\Field41 = 0.0
                                    local0\Field42 = $00
                                    If (entityvisible(local0\Field3, me\Field60) <> 0) Then
                                        pointentity(local0\Field3, me\Field60, 0.0)
                                    EndIf
                                    rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                    If (0.2375 < local13) Then
                                        local0\Field24 = curvevalue(local0\Field23, local0\Field24, 20.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                        If (9.0 > local13) Then
                                            animatenpc(local0, clamp(animtime(local0\Field0), 387.0, 428.0), 463.0, (local0\Field24 * 38.0), $01)
                                        ElseIf (428.0 < local0\Field14) Then
                                            animatenpc(local0, min(animtime(local0\Field0), 463.0), 498.0, (local0\Field24 * 38.0), $00)
                                            If (497.9 < local0\Field14) Then
                                                setnpcframe(local0, 358.0, $01)
                                            EndIf
                                        Else
                                            animatenpc(local0, clamp(animtime(local0\Field0), 346.0, 358.0), 393.0, (local0\Field24 * 38.0), $01)
                                        EndIf
                                    EndIf
                                    local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, (15.0 - ((Float selecteddifficulty\Field4) * 1.5)))
                                Else
                                    If (local22 = $01) Then
                                        local0\Field11 = 140.0
                                    EndIf
                                    If (local0\Field40 = $01) Then
                                        While (local0\Field39[local0\Field42] = Null)
                                            If (local0\Field42 > $14) Then
                                                local0\Field42 = $00
                                                local0\Field40 = $00
                                                Exit
                                            Else
                                                local0\Field42 = (local0\Field42 + $01)
                                            EndIf
                                        Wend
                                        If (local0\Field39[local0\Field42] <> Null) Then
                                            local0\Field24 = curvevalue(local0\Field23, local0\Field24, 20.0)
                                            pointentity(local0\Field3, local0\Field39[local0\Field42]\Field0, 0.0)
                                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                            animatenpc(local0, clamp(animtime(local0\Field0), 346.0, 358.0), 393.0, (local0\Field24 * 38.0), $01)
                                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, (15.0 - ((Float selecteddifficulty\Field4) * 1.5)))
                                            If (((local0\Field13 = $00) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                                If (rand($1E, $01) = $01) Then
                                                    loadnpcsound(local0, "SFX\SCP\049\Searching6.ogg", $01)
                                                Else
                                                    loadnpcsound(local0, (("SFX\SCP\049\Searching" + (Str rand($00, $05))) + ".ogg"), $01)
                                                EndIf
                                                local0\Field20 = playsoundex(local0\Field19, camera, local0\Field3, 10.0, 1.0, $01, $00)
                                                local0\Field13 = $01
                                            EndIf
                                            usedoornpc(local0, $01, $00)
                                            If (((rand($258, $01) = $01) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                                local0\Field13 = $00
                                            EndIf
                                            If (local0\Field13 > $01) Then
                                                local0\Field13 = $01
                                            EndIf
                                        EndIf
                                    Else
                                        local0\Field41 = (local0\Field41 + fps\Field7[$00])
                                        local0\Field24 = 0.0
                                        If (((4.0 - ((Float selecteddifficulty\Field2) * 2.0)) * 70.0) < local0\Field41) Then
                                            local0\Field40 = findpath(local0, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
                                            local0\Field41 = 0.0
                                            local0\Field12 = 0.0
                                            If (local0\Field40 <> $01) Then
                                                local53 = entitydistancesquared(playerroom\Field2, local0\Field3)
                                                local54 = playerroom
                                                local55 = 0.0
                                                For local11 = $00 To $03 Step $01
                                                    If (playerroom\Field19[local11] <> Null) Then
                                                        local55 = entitydistancesquared(playerroom\Field19[local11]\Field2, local0\Field3)
                                                        If (local53 > local55) Then
                                                            local53 = local55
                                                            local54 = playerroom\Field19[local11]
                                                        EndIf
                                                    EndIf
                                                Next
                                                local0\Field40 = findpath(local0, entityx(local54\Field2, $00), 0.5, entityz(local54\Field2, $00))
                                            EndIf
                                            While (3.0 > (Float (Int local0\Field12)))
                                                If (local0\Field40 = $01) Then
                                                    If (local0\Field39[$01] <> Null) Then
                                                        If (((local0\Field39[$02] = Null) And (0.16 > entitydistancesquared(local0\Field39[$01]\Field0, local0\Field3))) <> 0) Then
                                                            local0\Field42 = $00
                                                            local0\Field40 = $00
                                                        EndIf
                                                    EndIf
                                                    If (((local0\Field39[$00] <> Null) And (local0\Field39[$01] = Null)) <> 0) Then
                                                        local0\Field42 = $00
                                                        local0\Field40 = $00
                                                    EndIf
                                                EndIf
                                                If (local0\Field40 <> $01) Then
                                                    local53 = 10000.0
                                                    local54 = playerroom
                                                    local55 = 0.0
                                                    For local11 = $00 To $03 Step $01
                                                        If (playerroom\Field19[local11] <> Null) Then
                                                            local55 = entitydistancesquared(playerroom\Field19[local11]\Field2, local0\Field3)
                                                            If (local53 > local55) Then
                                                                local53 = local55
                                                                For local12 = $00 To $03 Step $01
                                                                    If (playerroom\Field19[local11]\Field19[local12] <> Null) Then
                                                                        If (playerroom\Field19[local11]\Field19[local12] <> playerroom) Then
                                                                            local54 = playerroom\Field19[local11]\Field19[local12]
                                                                            Exit
                                                                        EndIf
                                                                    EndIf
                                                                Next
                                                            EndIf
                                                        EndIf
                                                    Next
                                                    local0\Field40 = findpath(local0, entityx(local54\Field2, $00), 0.5, entityz(local54\Field2, $00))
                                                EndIf
                                                If (local0\Field40 = $01) Then
                                                    If (local0\Field39[$01] <> Null) Then
                                                        If (local0\Field39[$01]\Field1 <> Null) Then
                                                            If (((((local0\Field39[$01]\Field1\Field4 > $00) Lor (local0\Field39[$01]\Field1\Field14 <> $00)) Lor (local0\Field39[$01]\Field1\Field19 <> $00)) And (local0\Field39[$01]\Field1\Field6 = $00)) <> 0) Then
                                                                Repeat
                                                                    If (local0\Field42 > $14) Then
                                                                        local0\Field42 = $00
                                                                        local0\Field40 = $00
                                                                        Exit
                                                                    Else
                                                                        local0\Field42 = (local0\Field42 + $01)
                                                                    EndIf
                                                                    If (local0\Field39[local0\Field42] <> Null) Then
                                                                        If ((45.0 - (Abs deltayaw(local0\Field3, local0\Field39[$01]\Field0))) < (Abs deltayaw(local0\Field3, local0\Field39[local0\Field42]\Field0))) Then
                                                                            local0\Field12 = 3.0
                                                                            Exit
                                                                        EndIf
                                                                    EndIf
                                                                Forever
                                                            Else
                                                                local0\Field12 = 3.0
                                                            EndIf
                                                        Else
                                                            local0\Field12 = 3.0
                                                        EndIf
                                                    EndIf
                                                EndIf
                                                local0\Field12 = (local0\Field12 + 1.0)
                                            Wend
                                        EndIf
                                        animatenpc(local0, 269.0, 345.0, 0.2, $01)
                                    EndIf
                                EndIf
                                If (0.005 < local0\Field24) Then
                                    If ((((((361.0 > local21) And (361.0 <= local0\Field14)) Lor ((377.0 > local21) And (377.0 <= local0\Field14))) Lor ((431.0 > local21) And (431.0 <= local0\Field14))) Lor ((447.0 > local21) And (447.0 <= local0\Field14))) <> 0) Then
                                        playsoundex(snd_i\Field56[rand($07, $09)], camera, local0\Field3, 8.0, rnd(0.8, 1.0), $00, $00)
                                    EndIf
                                EndIf
                                updatesoundorigin(local0\Field20, camera, local0\Field0, 10.0, 1.0, $01, $01)
                            ElseIf (0.0 = local0\Field26) Then
                                If (channelplaying(local0\Field18) <> 0) Then
                                    stopchannel(local0\Field18)
                                    local0\Field18 = $00
                                EndIf
                                If (channelplaying(local0\Field20) <> 0) Then
                                    stopchannel(local0\Field20)
                                    local0\Field20 = $00
                                EndIf
                                If ((playerinreachableroom($01, $00) And (infacility = $00)) <> 0) Then
                                    If (rand(($04 - (selecteddifficulty\Field2 Shl $01)), $01) = $01) Then
                                        teleportcloser(local0)
                                    Else
                                        local0\Field26 = 4200.0
                                    EndIf
                                EndIf
                            EndIf
                        Case 3.0
                            animatenpc(local0, 537.0, 660.0, 0.7, $00)
                            positionentity(local0\Field3, curvevalue(entityx(me\Field60, $00), entityx(local0\Field3, $00), 20.0), entityy(local0\Field3, $00), curvevalue(entityz(me\Field60, $00), entityz(local0\Field3, $00), 20.0), $00)
                            local0\Field15 = curveangle((entityyaw(me\Field60, $00) - 180.0), local0\Field15, 10.0)
                        Case 4.0
                            local22 = npcseesplayer(local0, ((8.0 - me\Field40) + me\Field42), 60.0, $01)
                            If (local22 = $01) Then
                                playsound_strict(loadtempsound("SFX\SCP\049\Room2SLSpawn.ogg"), $00)
                                local0\Field40 = $00
                                local0\Field42 = $00
                                local0\Field41 = 0.0
                                local0\Field13 = $00
                                local0\Field12 = 0.0
                                local0\Field11 = 140.0
                                local0\Field10 = 2.0
                            ElseIf (((local22 = $02) And (0.0 < local0\Field12)) <> 0) Then
                                local0\Field40 = findpath(local0, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
                            Else
                                If (6.0 = local0\Field12) Then
                                    If ((hidedistance * hidedistance) < entitydistancesquared(local0\Field3, me\Field60)) Then
                                        local0\Field40 = $00
                                        local0\Field42 = $00
                                        local0\Field41 = 0.0
                                        local0\Field13 = $00
                                        local0\Field12 = 0.0
                                        local0\Field10 = 2.0
                                    ElseIf (local0\Field40 <> $01) Then
                                        local0\Field40 = findpath(local0, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
                                    EndIf
                                EndIf
                                If (local0\Field40 = $01) Then
                                    If (local0\Field39[local0\Field42] = Null) Then
                                        If (local0\Field42 > $14) Then
                                            local0\Field42 = $00
                                            local0\Field40 = $00
                                        Else
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field0, local0\Field39[local0\Field42]\Field0, 0.0)
                                        rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 10.0), 0.0, $00)
                                        local0\Field24 = curvevalue(local0\Field23, local0\Field24, 20.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                        local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, (10.0 - (Float selecteddifficulty\Field4)))
                                        usedoornpc(local0, $01, $00)
                                        animatenpc(local0, clamp(animtime(local0\Field0), 346.0, 358.0), 393.0, (local0\Field24 * 38.0), $01)
                                    EndIf
                                Else
                                    Select local0\Field13
                                        Case $00
                                            animatenpc(local0, 269.0, 345.0, 0.2, $01)
                                        Case $01
                                            animatenpc(local0, 661.0, 891.0, 0.4, $00)
                                        Case $02
                                            animatenpc(local0, 892.0, 1119.0, 0.4, $00)
                                    End Select
                                EndIf
                            EndIf
                            If (playerroom\Field7\Field6 = $12) Then
                                shouldplay = $13
                            EndIf
                            If (0.005 < local0\Field24) Then
                                If ((((((361.0 > local21) And (361.0 <= local0\Field14)) Lor ((377.0 > local21) And (377.0 <= local0\Field14))) Lor ((431.0 > local21) And (431.0 <= local0\Field14))) Lor ((447.0 > local21) And (447.0 <= local0\Field14))) <> 0) Then
                                    playsoundex(snd_i\Field56[rand($07, $09)], camera, local0\Field3, 8.0, rnd(0.8, 1.0), $00, $00)
                                EndIf
                            EndIf
                            updatesoundorigin(local0\Field20, camera, local0\Field0, 10.0, 1.0, $01, $01)
                    End Select
                    local0\Field29 = (Int max(((Float local0\Field29) - fps\Field7[$00]), 0.0))
                EndIf
                positionentity(local0\Field0, entityx(local0\Field3, $01), (entityy(local0\Field3, $01) - 0.22), entityz(local0\Field3, $01), $01)
                rotateentity(local0\Field0, 0.0, local0\Field15, 0.0, $01)
            Case $03
                If (local0\Field50 = $00) Then
                    local21 = local0\Field14
                    updatenpcblinking(local0)
                    Select local0\Field10
                        Case 0.0
                            local0\Field18 = loopsoundex(npcsound[$07], local0\Field18, camera, local0\Field3, 4.0, 1.0, $01)
                            If (rand($7D0, $01) = $01) Then
                                If ((9.0 - ((Float me\Field39) * 4.5)) > entitydistancesquared(local0\Field3, me\Field60)) Then
                                    local0\Field10 = 1.0
                                EndIf
                            EndIf
                        Case 1.0
                            animatenpc(local0, 1.0, 556.0, 1.0, $00)
                            If ((((288.0 > local21) And (288.0 <= local0\Field14)) Lor ((350.0 > local21) And (350.0 <= local0\Field14))) <> 0) Then
                                playsoundex(snd_i\Field56[rand($00, $02)], camera, local0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                            EndIf
                            If (555.9 <= local0\Field14) Then
                                local0\Field10 = 2.0
                            EndIf
                        Case 2.0
                            local0\Field11 = max((local0\Field11 - fps\Field7[$00]), 0.0)
                            If (0.0 < local0\Field11) Then
                                If (local0\Field34 = Null) Then
                                    If (npcseesplayer(local0, ((8.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                        local0\Field11 = 140.0
                                    EndIf
                                    If (entityvisible(local0\Field3, me\Field60) <> 0) Then
                                        pointentity(local0\Field3, me\Field60, 0.0)
                                    EndIf
                                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                                Else
                                    If (npcseesnpc(local0\Field34, local0, 36.0) <> 0) Then
                                        local0\Field11 = 140.0
                                    EndIf
                                    If (entityvisible(local0\Field3, local0\Field34\Field3) <> 0) Then
                                        pointentity(local0\Field3, local0\Field34\Field3, 0.0)
                                    EndIf
                                    local13 = entitydistancesquared(local0\Field3, local0\Field34\Field3)
                                EndIf
                                rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                local0\Field24 = curvevalue(local0\Field23, local0\Field24, 20.0)
                                animatenpc(local0, clamp(animtime(local0\Field0), 705.0, 714.0), 794.0, (local0\Field24 * 38.0), $01)
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                If (0.49 > local13) Then
                                    setnpcframe(local0, 795.0, $01)
                                    local0\Field10 = 4.0
                                EndIf
                                local0\Field41 = 0.0
                                local0\Field40 = $00
                                local0\Field42 = $00
                                If ((((733.0 > local21) And (733.0 <= local0\Field14)) Lor ((773.0 > local21) And (773.0 <= local0\Field14))) <> 0) Then
                                    playsoundex(snd_i\Field56[rand($00, $02)], camera, local0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                                EndIf
                            Else
                                local0\Field34 = Null
                                local0\Field10 = 3.0
                            EndIf
                        Case 3.0
                            If (0.0 >= local0\Field41) Then
                                local0\Field40 = findpath(local0, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.1), entityz(me\Field60, $00))
                                If (local0\Field40 = $01) Then
                                    While (local0\Field39[local0\Field42] = Null)
                                        If (local0\Field42 > $14) Then
                                            local0\Field42 = $00
                                            local0\Field40 = $01
                                            Exit
                                        Else
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    Wend
                                    If (local0\Field42 < $14) Then
                                        If (((local0\Field39[local0\Field42] <> Null) And (local0\Field39[(local0\Field42 + $01)] <> Null)) <> 0) Then
                                            If (local0\Field39[local0\Field42]\Field1 = Null) Then
                                                If ((Abs deltayaw(local0\Field3, local0\Field39[(local0\Field42 + $01)]\Field0)) < (Abs deltayaw(local0\Field3, local0\Field39[local0\Field42]\Field0))) Then
                                                    local0\Field42 = (local0\Field42 + $01)
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                    usedoornpc(local0, $01, $00)
                                EndIf
                                local0\Field41 = (rnd(6.0, 10.0) * 70.0)
                            Else
                                If (chs\Field2 = $00) Then
                                    If (((0.49 > entitydistancesquared(local0\Field3, me\Field60)) And entityvisible(me\Field60, local0\Field3)) <> 0) Then
                                        local0\Field11 = 70.0
                                        local0\Field10 = 4.0
                                    EndIf
                                EndIf
                                If (local0\Field40 = $01) Then
                                    If (local0\Field39[local0\Field42] = Null) Then
                                        If (local0\Field42 > $14) Then
                                            local0\Field42 = $00
                                            local0\Field40 = $00
                                        Else
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field3, local0\Field39[local0\Field42]\Field0, 0.0)
                                        rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                        local0\Field24 = curvevalue(local0\Field23, local0\Field24, 20.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                        local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                        usedoornpc(local0, $01, $00)
                                    EndIf
                                    local0\Field41 = (local0\Field41 - fps\Field7[$00])
                                Else
                                    local0\Field24 = curvevalue(0.0, local0\Field24, 10.0)
                                    local0\Field41 = (local0\Field41 - (fps\Field7[$00] * 2.0))
                                EndIf
                            EndIf
                            If (0.005 > local0\Field24) Then
                                If (713.0 < local0\Field14) Then
                                    animatenpc(local0, 795.0, 813.0, 0.8, $00)
                                    If (812.9 < local0\Field14) Then
                                        setnpcframe(local0, 557.0, $01)
                                    EndIf
                                Else
                                    animatenpc(local0, 557.0, 704.0, 0.2, $01)
                                EndIf
                            Else
                                animatenpc(local0, clamp(animtime(local0\Field0), 705.0, 714.0), 794.0, (local0\Field24 * 38.0), $01)
                                If ((((733.0 > local21) And (733.0 <= local0\Field14)) Lor ((773.0 > local21) And (773.0 <= local0\Field14))) <> 0) Then
                                    playsoundex(snd_i\Field56[rand($00, $02)], camera, local0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                                EndIf
                            EndIf
                            If (local13 > ((hidedistance * 2.0) * (hidedistance * 2.0))) Then
                                If (1050.0 > local0\Field27) Then
                                    local0\Field27 = (local0\Field27 + fps\Field7[$00])
                                ElseIf (rand(($12C - (selecteddifficulty\Field2 * $78)), $01) = $01) Then
                                    If (playerinreachableroom($00, $00) <> 0) Then
                                        teleportcloser(local0)
                                        local0\Field27 = 0.0
                                    EndIf
                                EndIf
                            Else
                                local0\Field27 = 0.0
                            EndIf
                            If (0.0 >= local0\Field66) Then
                                If (local0\Field34 = Null) Then
                                    If (npcseesplayer(local0, ((8.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                        local0\Field11 = 140.0
                                        local0\Field10 = 2.0
                                    EndIf
                                EndIf
                                For local1 = Each npcs
                                    If (((local1\Field4 = $15) And (local1\Field50 = $00)) <> 0) Then
                                        If (npcseesnpc(local1, local0, 36.0) = $01) Then
                                            local0\Field34 = local1
                                            local0\Field11 = 140.0
                                            local0\Field10 = 2.0
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                                local0\Field66 = (fps\Field7[$00] * 45.0)
                            Else
                                local0\Field66 = (local0\Field66 - fps\Field7[$00])
                            EndIf
                        Case 4.0
                            local0\Field24 = 0.0
                            If (local0\Field34 = Null) Then
                                pointentity(local0\Field3, me\Field60, 0.0)
                            Else
                                pointentity(local0\Field3, local0\Field34\Field3, 0.0)
                            EndIf
                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                            If (813.0 >= local0\Field14) Then
                                animatenpc(local0, 795.0, 813.0, 0.7, $00)
                                If (812.9 < local0\Field14) Then
                                    If (rand($02, $01) = $01) Then
                                        setnpcframe(local0, 814.0, $01)
                                    Else
                                        setnpcframe(local0, 879.0, $01)
                                    EndIf
                                EndIf
                            Else
                                If (879.0 > local0\Field14) Then
                                    animatenpc(local0, 814.0, 878.0, 0.5, $00)
                                    local30 = ((839.0 <= local0\Field14) And (839.0 > local21))
                                    If (877.9 < local0\Field14) Then
                                        setnpcframe(local0, 705.0, $01)
                                        local0\Field10 = (me\Field0 + 2.0)
                                    EndIf
                                Else
                                    animatenpc(local0, 879.0, 943.0, 0.5, $00)
                                    local30 = ((900.0 <= local0\Field14) And (900.0 > local21))
                                    If (942.9 < local0\Field14) Then
                                        setnpcframe(local0, 705.0, $01)
                                        local0\Field10 = (me\Field0 + 2.0)
                                    EndIf
                                EndIf
                                If (local30 <> 0) Then
                                    If (local0\Field34 = Null) Then
                                        If (0.5625 > entitydistancesquared(local0\Field3, me\Field60)) Then
                                            playsound_strict(snd_i\Field51[rand($05, $08)], $00)
                                            injureplayer((rnd(0.55, 0.85) * local37), 0.0, 0.0, (0.3 * local37), (0.125 * local37))
                                            me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.5)
                                            If (3.0 < me\Field31) Then
                                                msg\Field2 = format(getlocalstring("death", "0492killed"), subjectname, "%s")
                                                kill($01, $01, $00, $01)
                                            EndIf
                                        Else
                                            playsoundex(snd_i\Field48, camera, local0\Field3, 2.5, 1.0, $00, $00)
                                        EndIf
                                    ElseIf (0.5625 > entitydistancesquared(local0\Field3, local0\Field34\Field3)) Then
                                        playsoundex(snd_i\Field51[rand($05, $08)], camera, local0\Field34\Field0, 10.0, 1.0, $00, $00)
                                        If (local0\Field34\Field60 > $00) Then
                                            local0\Field34\Field60 = (Int max(((Float local0\Field34\Field60) - rnd(30.0, 50.0)), 0.0))
                                        Else
                                            local0\Field34 = Null
                                            local0\Field10 = 3.0
                                        EndIf
                                    Else
                                        playsoundex(snd_i\Field48, camera, local0\Field3, 2.5, 1.0, $00, $00)
                                    EndIf
                                EndIf
                            EndIf
                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                            If (local0\Field34 <> Null) Then
                                If (local0\Field34\Field50 <> 0) Then
                                    local0\Field10 = 3.0
                                    local0\Field34 = Null
                                EndIf
                            EndIf
                    End Select
                    If (1.0 < local0\Field10) Then
                        local0\Field18 = loopsoundex(npcsound[$06], local0\Field18, camera, local0\Field3, 10.0, 1.0, $01)
                    EndIf
                    If (local0\Field60 <= $00) Then
                        local0\Field50 = $01
                    EndIf
                Else
                    animatenpc(local0, 944.0, 982.0, 0.2, $00)
                EndIf
                positionentity(local0\Field0, entityx(local0\Field3, $01), (entityy(local0\Field3, $01) - 0.2), entityz(local0\Field3, $01), $01)
                rotateentity(local0\Field0, -90.0, local0\Field15, 0.0, $01)
            Case $14
                local21 = local0\Field14
                local0\Field54 = ""
                local0\Field52 = $00
                local0\Field53 = $00
                local0\Field58 = "Guard"
                Select local0\Field10
                    Case 1.0
                        If (((((39.0 > local0\Field14) Lor ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Lor ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Lor (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0, $01)
                            EndIf
                        EndIf
                        If (0.0 = me\Field0) Then
                            local13 = entitydistancesquared(local0\Field3, me\Field60)
                            local59 = (((Float selecteddifficulty\Field2) * 0.5) + 0.4)
                            local60 = 121.0
                            If (playerroom\Field7\Field6 = $49) Then
                                local60 = 484.0
                                local59 = (0.5 - (me\Field38 * 12.0))
                            EndIf
                            If (local60 > local13) Then
                                local26 = createpivot($00)
                                positionentity(local26, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                                pointentity(local26, me\Field60, 0.0)
                                rotateentity(local26, min(entitypitch(local26, $00), 20.0), entityyaw(local26, $00), 0.0, $00)
                                rotateentity(local0\Field3, curveangle(entitypitch(local26, $00), entitypitch(local0\Field3, $00), 10.0), curveangle(entityyaw(local26, $00), entityyaw(local0\Field3, $00), 10.0), 0.0, $01)
                                positionentity(local26, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.8), entityz(local0\Field3, $00), $00)
                                pointentity(local26, me\Field60, 0.0)
                                rotateentity(local26, min(entitypitch(local26, $00), 40.0), entityyaw(local0\Field3, $00), 0.0, $00)
                                If (0.0 = local0\Field28) Then
                                    If (1.0 = local0\Field12) Then
                                        local61 = $00
                                        msg\Field2 = format(getlocalstring("death", "guard.default"), subjectname, "%s")
                                        If (playerroom\Field7\Field6 = $03) Then
                                            msg\Field2 = format(getlocalstring("death", "guard.173"), subjectname, "%s")
                                            local61 = $01
                                        ElseIf (playerroom\Field7\Field6 = $49) Then
                                            msg\Field2 = getlocalstring("death", "guard.gateb")
                                        EndIf
                                        playsoundex(snd_i\Field13[$00], camera, local0\Field3, 35.0, 1.0, $00, $00)
                                        rotateentity(local26, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), 0.0, $01)
                                        positionentity(local26, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                        moveentity(local26, 0.0622, 0.83925, 0.5351)
                                        pointentity(local26, me\Field60, 0.0)
                                        shoot(local0, entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), local0\Field3, local59, $01, local61)
                                        local0\Field28 = 8.0
                                    Else
                                        local0\Field24 = local0\Field23
                                    EndIf
                                EndIf
                                If (((0.0 < local0\Field28) And (8.0 >= local0\Field28)) <> 0) Then
                                    animatenpc(local0, 245.0, 248.0, 0.35, $01)
                                ElseIf (302.0 > local0\Field14) Then
                                    animatenpc(local0, 302.0, 344.0, 0.35, $01)
                                EndIf
                                freeentity(local26)
                                local26 = $00
                            Else
                                animatenpc(local0, 302.0, 344.0, 0.35, $01)
                            EndIf
                            local0\Field52 = $01
                            local0\Field54 = "Chest"
                            If (10.0 = local0\Field11) Then
                                local0\Field53 = $03
                            Else
                                local0\Field53 = $00
                            EndIf
                        Else
                            local0\Field10 = 0.0
                        EndIf
                    Case 2.0
                        animatenpc(local0, 245.0, 248.0, 0.35, $01)
                        If (0.0 = local0\Field28) Then
                            playsoundex(snd_i\Field13[$00], camera, local0\Field3, 15.0, 1.0, $00, $00)
                            local26 = createpivot($00)
                            rotateentity(local26, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), 0.0, $01)
                            positionentity(local26, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            moveentity(local26, 0.0622, 0.83925, 0.5351)
                            setemitter(Null, entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), $0D)
                            local0\Field28 = 8.0
                        EndIf
                    Case 3.0
                        If (local0\Field40 = $01) Then
                            If (local0\Field39[local0\Field42] = Null) Then
                                If (local0\Field42 > $14) Then
                                    local0\Field42 = $00
                                    local0\Field40 = $00
                                Else
                                    local0\Field42 = (local0\Field42 + $01)
                                EndIf
                            Else
                                animatenpc(local0, 1.0, 38.0, (local0\Field24 * 40.0), $01)
                                local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 20.0)
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                pointentity(local0\Field0, local0\Field39[local0\Field42]\Field0, 0.0)
                                rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 20.0), 0.0, $00)
                                If (0.04 > entitydistancesquared(local0\Field3, local0\Field39[local0\Field42]\Field0)) Then
                                    local0\Field42 = (local0\Field42 + $01)
                                EndIf
                            EndIf
                        Else
                            If (0.0 = local0\Field41) Then
                                local0\Field40 = findpath(local0, local0\Field36, (local0\Field37 + 0.5), local0\Field38)
                            EndIf
                            local9 = Null
                            local26 = createpivot($00)
                            positionentity(local26, local0\Field36, local0\Field37, local0\Field38, $00)
                            For local8 = Each waypoints
                                If (4.0 > entitydistancesquared(local8\Field0, local26)) Then
                                    local9 = local8
                                    Exit
                                EndIf
                            Next
                            freeentity(local26)
                            local26 = $00
                            If (local9 <> Null) Then
                                local0\Field41 = 1.0
                                If (entityvisible(local9\Field0, local0\Field3) <> 0) Then
                                    If (0.0 < (Abs deltayaw(local0\Field3, local9\Field0))) Then
                                        pointentity(local0\Field0, local9\Field0, 0.0)
                                        rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 20.0), 0.0, $00)
                                    EndIf
                                EndIf
                            Else
                                local0\Field41 = 0.0
                            EndIf
                            If (1.0 = local0\Field41) Then
                                animatenpc(local0, 1.0, 38.0, (local0\Field24 * 40.0), $01)
                                local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 20.0)
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            EndIf
                        EndIf
                    Case 4.0
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        If (rand($190, $01) = $01) Then
                            local0\Field15 = rnd(-180.0, 180.0)
                        EndIf
                        rotateentity(local0\Field3, 0.0, curveangle((local0\Field15 + (sin((Float (millisec / $32))) * 2.0)), entityyaw(local0\Field3, $00), 150.0), 0.0, $01)
                        If (225.0 > entitydistancesquared(local0\Field3, me\Field60)) Then
                            If (((90.0 > wrapangle((entityyaw(local0\Field3, $00) - deltayaw(local0\Field3, me\Field60)), 360.0)) And entityvisible(me\Field60, local0\Field3)) <> 0) Then
                                local0\Field10 = 1.0
                            EndIf
                        EndIf
                    Case 5.0
                        rotateentity(local0\Field3, 0.0, curveangle((vectoryaw((local0\Field36 - entityx(local0\Field3, $00)), 0.0, (local0\Field38 - entityz(local0\Field3, $00))) + local0\Field15), entityyaw(local0\Field3, $00), 20.0), 0.0, $00)
                        local13 = distancesquared(entityx(local0\Field3, $00), local0\Field36, entityz(local0\Field3, $00), local0\Field38, 0.0, 0.0)
                        animatenpc(local0, 1.0, 38.0, (local0\Field24 * 40.0), $01)
                        If (((4.0 < local13) Lor (1.0 > local13)) <> 0) Then
                            local0\Field24 = curvevalue(((local0\Field23 * (Sgn (sqr(local13) - 1.5))) * 0.75), local0\Field24, 10.0)
                        Else
                            local0\Field24 = curvevalue(0.0, local0\Field24, 10.0)
                        EndIf
                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                    Case 7.0
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                    Case 8.0
                    Case 9.0
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        local0\Field54 = "head"
                        local0\Field52 = $01
                        local0\Field53 = $00
                        local0\Field15 = entityyaw(local0\Field3, $00)
                    Case 10.0
                        animatenpc(local0, 1.0, 38.0, (local0\Field24 * 40.0), $01)
                        local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 20.0)
                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                    Case 11.0
                        If (((((39.0 > local0\Field14) Lor ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Lor ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Lor (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0, $01)
                            EndIf
                        EndIf
                        If (0.0 = me\Field0) Then
                            local13 = entitydistancesquared(local0\Field3, me\Field60)
                            local62 = ((((chs\Field2 Lor i_268\Field2) = $00) And (121.0 > local13)) And entityvisible(local0\Field3, me\Field60))
                            If (local62 <> 0) Then
                                local26 = createpivot($00)
                                positionentity(local26, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                                pointentity(local26, me\Field60, 0.0)
                                rotateentity(local26, min(entitypitch(local26, $00), 20.0), entityyaw(local26, $00), 0.0, $00)
                                rotateentity(local0\Field3, curveangle(entitypitch(local26, $00), entitypitch(local0\Field3, $00), 10.0), curveangle(entityyaw(local26, $00), entityyaw(local0\Field3, $00), 10.0), 0.0, $01)
                                positionentity(local26, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.8), entityz(local0\Field3, $00), $00)
                                pointentity(local26, me\Field60, 0.0)
                                rotateentity(local26, min(entitypitch(local26, $00), 40.0), entityyaw(local0\Field3, $00), 0.0, $00)
                                If (0.0 = local0\Field28) Then
                                    If (1.0 = local0\Field12) Then
                                        local61 = $00
                                        msg\Field2 = ""
                                        playsoundex(snd_i\Field13[$00], camera, local0\Field3, 15.0, 1.0, $00, $00)
                                        rotateentity(local26, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), 0.0, $01)
                                        positionentity(local26, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                        moveentity(local26, 0.0622, 0.83925, 0.5351)
                                        pointentity(local26, me\Field60, 0.0)
                                        local36 = sqr(local13)
                                        shoot(local0, entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), local0\Field3, ((25.0 / local36) * (1.0 / local36)), $01, local61)
                                        local0\Field28 = 8.0
                                    Else
                                        local0\Field24 = local0\Field23
                                    EndIf
                                EndIf
                                If (((0.0 < local0\Field28) And (8.0 >= local0\Field28)) <> 0) Then
                                    animatenpc(local0, 245.0, 248.0, 0.35, $01)
                                ElseIf (302.0 > local0\Field14) Then
                                    animatenpc(local0, 302.0, 344.0, 0.35, $01)
                                EndIf
                                freeentity(local26)
                                local26 = $00
                            Else
                                If (local0\Field40 = $01) Then
                                    If (local0\Field39[local0\Field42] = Null) Then
                                        If (local0\Field42 > $14) Then
                                            local0\Field42 = $00
                                            local0\Field40 = $00
                                        Else
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    Else
                                        animatenpc(local0, 39.0, 76.0, (local0\Field24 * 40.0), $01)
                                        local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 20.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                        pointentity(local0\Field0, local0\Field39[local0\Field42]\Field0, 0.0)
                                        rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 20.0), 0.0, $00)
                                        If (0.04 > entitydistancesquared(local0\Field3, local0\Field39[local0\Field42]\Field0)) Then
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    EndIf
                                Else
                                    If (0.0 = local0\Field41) Then
                                        local0\Field40 = findpath(local0, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.5), entityz(me\Field60, $00))
                                    EndIf
                                    local9 = Null
                                    For local8 = Each waypoints
                                        If (4.0 > entitydistancesquared(local8\Field0, me\Field60)) Then
                                            local9 = local8
                                            Exit
                                        EndIf
                                    Next
                                    If (local9 <> Null) Then
                                        local0\Field41 = 1.0
                                        If (entityvisible(local9\Field0, local0\Field3) <> 0) Then
                                            If (0.0 < (Abs deltayaw(local0\Field3, local9\Field0))) Then
                                                pointentity(local0\Field0, local9\Field0, 0.0)
                                                rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 20.0), 0.0, $00)
                                            EndIf
                                        EndIf
                                    Else
                                        local0\Field41 = 0.0
                                    EndIf
                                    If (1.0 = local0\Field41) Then
                                        animatenpc(local0, 39.0, 76.0, (local0\Field24 * 40.0), $01)
                                        local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 20.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                    EndIf
                                EndIf
                                If ((((43.0 > local21) And (43.0 <= local0\Field14)) Lor ((61.0 > local21) And (61.0 <= local0\Field14))) <> 0) Then
                                    playsoundex(snd_i\Field56[rand($00, $02)], camera, local0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
                                EndIf
                            EndIf
                        Else
                            local0\Field10 = 0.0
                        EndIf
                    Case 12.0
                        If (((((39.0 > local0\Field14) Lor ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Lor ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Lor (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0, $01)
                            EndIf
                        EndIf
                        If (345.0 > local0\Field14) Then
                            animatenpc(local0, 302.0, 344.0, 0.35, $01)
                        EndIf
                        local26 = createpivot($00)
                        positionentity(local26, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                        If (1.0 = local0\Field11) Then
                            pointentity(local26, me\Field60, 0.0)
                        Else
                            rotateentity(local26, 0.0, local0\Field15, 0.0, $00)
                        EndIf
                        rotateentity(local26, min(entitypitch(local26, $00), 20.0), entityyaw(local26, $00), 0.0, $00)
                        rotateentity(local0\Field3, curveangle(entitypitch(local26, $00), entitypitch(local0\Field3, $00), 10.0), curveangle(entityyaw(local26, $00), entityyaw(local0\Field3, $00), 10.0), 0.0, $01)
                        positionentity(local26, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.8), entityz(local0\Field3, $00), $00)
                        If (1.0 = local0\Field11) Then
                            pointentity(local26, me\Field60, 0.0)
                            local0\Field52 = $01
                            local0\Field54 = "Chest"
                            local0\Field53 = $00
                        Else
                            rotateentity(local26, 0.0, local0\Field15, 0.0, $00)
                        EndIf
                        rotateentity(local26, min(entitypitch(local26, $00), 40.0), entityyaw(local0\Field3, $00), 0.0, $00)
                        freeentity(local26)
                        local26 = $00
                    Case 13.0
                        animatenpc(local0, 202.0, 244.0, 0.35, $01)
                    Case 14.0
                        If (local0\Field40 = $02) Then
                            local0\Field10 = 13.0
                            local0\Field24 = 0.0
                        ElseIf (local0\Field40 = $01) Then
                            If (local0\Field39[local0\Field42] = Null) Then
                                If (local0\Field42 > $14) Then
                                    local0\Field42 = $00
                                    local0\Field40 = $00
                                Else
                                    local0\Field42 = (local0\Field42 + $01)
                                EndIf
                            Else
                                pointentity(local0\Field0, local0\Field39[local0\Field42]\Field0, 0.0)
                                rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 10.0), 0.0, $00)
                                animatenpc(local0, 39.0, 76.0, (local0\Field24 * 40.0), $01)
                                local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 20.0)
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                If (0.04 > entitydistancesquared(local0\Field3, local0\Field39[local0\Field42]\Field0)) Then
                                    local0\Field42 = (local0\Field42 + $01)
                                EndIf
                            EndIf
                        Else
                            local0\Field24 = 0.0
                            local0\Field10 = 13.0
                        EndIf
                        If ((((43.0 > local21) And (43.0 <= local0\Field14)) Lor ((61.0 > local21) And (61.0 <= local0\Field14))) <> 0) Then
                            playsoundex(snd_i\Field56[rand($00, $02)], camera, local0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
                        EndIf
                    Case 15.0
                        If (local0\Field1 <> $00) Then
                            If (entityhidden(local0\Field1) <> 0) Then
                                showentity(local0\Field1)
                            EndIf
                            animatenpc(local0, 623.0, 642.0, 0.3, $01)
                            If (channelplaying(local0\Field20) <> 0) Then
                                stopchannel(local0\Field20)
                                local0\Field20 = $00
                            EndIf
                            local0\Field18 = loopsoundex(snd_i\Field57[$00], local0\Field18, camera, local0\Field1, 10.0, 1.0, $00)
                            local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                        Else
                            openconsoleonerror(format(getlocalstring("runerr", "guard.state"), "15.0", "%s"))
                        EndIf
                    Case 16.0
                        If (local0\Field1 <> $00) Then
                            If (entityhidden(local0\Field1) <> 0) Then
                                showentity(local0\Field1)
                            EndIf
                            animatenpc(local0, 623.0, 642.0, 0.3, $01)
                            If (channelplaying(local0\Field18) <> 0) Then
                                stopchannel(local0\Field18)
                                local0\Field18 = $00
                            EndIf
                            local0\Field20 = loopsoundex(snd_i\Field57[$01], local0\Field20, camera, local0\Field1, 12.0, 1.0, $00)
                            local0\Field24 = curvevalue((local0\Field23 * 0.9), local0\Field24, 20.0)
                            animateex(local0\Field1, animtime(local0\Field1), $01, $14, (local0\Field24 * 5.0), $01)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                        Else
                            openconsoleonerror(format(getlocalstring("runerr", "guard.state"), "16.0", "%s"))
                        EndIf
                    Default
                        If (rand($190, $01) = $01) Then
                            local0\Field13 = rand($FFFFFFE2, $1E)
                        EndIf
                        local0\Field40 = $00
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        rotateentity(local0\Field3, 0.0, curveangle(((local0\Field15 + (Float local0\Field13)) + (sin((Float (millisec / $32))) * 2.0)), entityyaw(local0\Field3, $00), 50.0), 0.0, $01)
                End Select
                If (0.01 < local0\Field24) Then
                    If ((((5.0 > local21) And (5.0 <= local0\Field14)) Lor ((23.0 > local21) And (23.0 <= local0\Field14))) <> 0) Then
                        playsoundex(snd_i\Field56[rand($00, $02)], camera, local0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
                    EndIf
                ElseIf (-0.01 > local0\Field24) Then
                    If ((((23.0 <= local21) And (23.0 > local0\Field14)) Lor ((5.0 <= local21) And (5.0 > local0\Field14))) <> 0) Then
                        playsoundex(snd_i\Field56[rand($00, $02)], camera, local0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
                    EndIf
                EndIf
                local0\Field28 = max(0.0, (local0\Field28 - fps\Field7[$00]))
                If (local0\Field1 <> $00) Then
                    positionentity(local0\Field1, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.2), entityz(local0\Field3, $00), $00)
                    rotateentity(local0\Field1, 0.0, entityyaw(local0\Field3, $00), 0.0, $00)
                    positionentity(local0\Field0, (entityx(local0\Field1, $00) + 1.75), (entityy(local0\Field1, $00) + 0.33), (entityz(local0\Field1, $00) + 0.42), $00)
                    rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field1, $00) + 180.0), 0.0, $00)
                Else
                    positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.2), entityz(local0\Field3, $00), $00)
                    rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field3, $00) + 180.0), 0.0, $00)
                EndIf
            Case $15
                updatemtfunit(local0)
            Case $13,$12
                If (local0\Field50 = $00) Then
                    rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), entityroll(local0\Field3, $00), $01)
                    local21 = local0\Field14
                    Select local0\Field10
                        Case -1.0
                        Case 0.0
                            local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                            animatenpc(local0, 210.0, 235.0, 0.1, $01)
                        Case 1.0
                            local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 20.0)
                            animatenpc(local0, 236.0, 260.0, (local0\Field24 * 18.0), $01)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            If (0.005 < local0\Field24) Then
                                If ((((244.0 > local21) And (244.0 <= local0\Field14)) Lor ((254.0 > local21) And (254.0 <= local0\Field14))) <> 0) Then
                                    playsoundex(stepsfx(getstepsound(local0\Field3), $00, rand($00, $02)), camera, local0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                                EndIf
                            ElseIf (-0.005 > local0\Field24) Then
                                If ((((254.0 <= local21) And (254.0 > local0\Field14)) Lor ((244.0 <= local21) And (244.0 > local0\Field14))) <> 0) Then
                                    playsoundex(stepsfx(getstepsound(local0\Field3), $00, rand($00, $02)), camera, local0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                                EndIf
                            EndIf
                        Case 2.0
                            local0\Field24 = curvevalue(local0\Field23, local0\Field24, 5.0)
                            animatenpc(local0, 301.0, 319.0, (local0\Field24 * 18.0), $01)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            If (0.005 < local0\Field24) Then
                                If ((((309.0 > local21) And (309.0 <= local0\Field14)) Lor ((319.0 >= local21) And (301.0 >= local0\Field14))) <> 0) Then
                                    playsoundex(stepsfx(getstepsound(local0\Field3), $01, rand($00, $02)), camera, local0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                                EndIf
                            EndIf
                    End Select
                    If (((local0\Field60 <= $00) And (local0\Field4 = $12)) <> 0) Then
                        setnpcframe(local0, 41.0, $01)
                        local0\Field50 = $01
                    EndIf
                Else
                    Select local0\Field12
                        Case -1.0
                        Case 0.0
                            animatenpc(local0, 1.0, 40.0, 0.5, $00)
                        Case 1.0
                            animatenpc(local0, 41.0, 60.0, 0.5, $00)
                        Case 2.0
                            animatenpc(local0, 555.0, 629.0, 0.5, $00)
                        Case 3.0
                            animatenpc(local0, 630.0, 677.0, 0.5, $00)
                        Case 4.0
                            animatenpc(local0, 678.0, 711.0, 0.5, $00)
                        Case 5.0
                            animatenpc(local0, 712.0, 779.0, 0.5, $00)
                    End Select
                EndIf
                positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.2), entityz(local0\Field3, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field3, $00), (entityyaw(local0\Field3, $00) - 180.0), 0.0, $00)
            Case $0D
                local13 = entitydistancesquared(me\Field60, local0\Field3)
                If ((hidedistance * hidedistance) > local13) Then
                    local0\Field29 = $00
                    If (3.0 > local0\Field10) Then
                        If (((((me\Field59 < $02) Lor (playerroom\Field7\Field6 = $46)) Lor (playerroom\Field7\Field6 = $48)) Lor (1.0 < n_i\Field3\Field10)) <> 0) Then
                            local0\Field10 = 3.0
                        EndIf
                        local0\Field13 = $00
                        local23 = (entityvisible(me\Field60, local0\Field3) And ((chs\Field2 Lor i_268\Field2) = $00))
                    EndIf
                    Select local0\Field10
                        Case 0.0
                            If (local23 <> 0) Then
                                local0\Field10 = 2.0
                            EndIf
                            local0\Field24 = 0.0
                            animatenpc(local0, clamp(animtime(local0\Field0), 1.0, 11.0), 74.0, 0.3, $00)
                            If (73.9 <= local0\Field14) Then
                                setnpcframe(local0, 1.0, $01)
                            EndIf
                            If (rand($32, $01) = $01) Then
                                rotateentity(local0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                            If (rand($64, $01) = $01) Then
                                local0\Field10 = 1.0
                            EndIf
                        Case 1.0
                            If (local23 <> 0) Then
                                local0\Field10 = 2.0
                            EndIf
                            local39 = $00
                            If ((Float millisecs()) > local0\Field12) Then
                                hideentity(local0\Field3)
                                entitypick(local0\Field3, 1.5)
                                If (pickedentity() <> $00) Then
                                    local39 = $01
                                EndIf
                                showentity(local0\Field3)
                                If (rand($05, $01) = $01) Then
                                    local0\Field10 = 0.0
                                EndIf
                                local0\Field12 = (Float (millisecs() + $3E8))
                            EndIf
                            rotateentity(local0\Field3, 0.0, (entityyaw(local0\Field3, $01) + (rnd(80.0, 110.0) * (Float local39))), 0.0, $01)
                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                            local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 10.0)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            If (10.0 > local0\Field14) Then
                                animatenpc(local0, 1.0, 10.0, 0.3, $00)
                            EndIf
                        Case 2.0
                            local67 = Null
                            For local66 = Each items
                                If (((local66\Field4\Field2 = $6C) And (local66\Field15 = $00)) <> 0) Then
                                    If (1.0 > entitydistancesquared(local0\Field3, local66\Field2)) Then
                                        local67 = local66
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (local67 = Null) Then
                                If (local23 <> 0) Then
                                    giveachievement("999", $01)
                                    pointentity(local0\Field3, me\Field60, 0.0)
                                    rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                    local0\Field12 = 105.0
                                    local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 25.0)
                                EndIf
                            Else
                                pointentity(local0\Field3, local67\Field2, 0.0)
                                rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                local0\Field12 = 105.0
                                local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 25.0)
                                If (0.09 > entitydistancesquared(local0\Field3, local67\Field2)) Then
                                    playsoundex(loadtempsound("SFX\SCP\458\Eating.ogg"), camera, local0\Field3, 3.0, 0.5, $00, $00)
                                    removeitem(local67)
                                EndIf
                            EndIf
                            local0\Field12 = max((local0\Field12 - fps\Field7[$00]), 0.0)
                            If (0.0 < local0\Field12) Then
                                local0\Field24 = curvevalue(local0\Field23, local0\Field24, 40.0)
                                If (0.64 > local13) Then
                                    moveentity(local0\Field3, 0.0, 0.0, ((- local0\Field24) * fps\Field7[$00]))
                                ElseIf (1.0 < local13) Then
                                    If (10.0 > local0\Field14) Then
                                        animatenpc(local0, 1.0, 10.0, 0.3, $00)
                                    EndIf
                                    moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                Else
                                    local0\Field24 = 0.0
                                    If (0.5 < me\Field31) Then
                                        me\Field35 = 1.0
                                    EndIf
                                EndIf
                                If (0.001 >= local0\Field24) Then
                                    animatenpc(local0, clamp(animtime(local0\Field0), 1.0, 11.0), 74.0, 0.3, $00)
                                ElseIf (73.9 <= local0\Field14) Then
                                    setnpcframe(local0, 1.0, $01)
                                EndIf
                            Else
                                local0\Field10 = 0.0
                            EndIf
                        Case 3.0
                            If (local0\Field13 = $00) Then
                                createhintmsg(getlocalstring("msg", "999_follow"), 6.0, $00)
                                local0\Field13 = $01
                            EndIf
                            If (0.0 >= local0\Field41) Then
                                local16 = 0.0
                                local18 = 0.0
                                local19 = 0.0
                                For local4 = Each rooms
                                    If (local4\Field7\Field6 = $56) Then
                                        local16 = entityx(local4\Field2, $00)
                                        local18 = 0.2
                                        local19 = entityz(local4\Field2, $00)
                                        Exit
                                    EndIf
                                Next
                                local0\Field40 = findpath(local0, local16, local18, local19)
                                local0\Field41 = 700.0
                            Else
                                If (local0\Field40 = $01) Then
                                    If (local0\Field39[local0\Field42] = Null) Then
                                        If (local0\Field42 > $14) Then
                                            local0\Field42 = $00
                                            local0\Field40 = $00
                                        Else
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field3, local0\Field39[local0\Field42]\Field0, 0.0)
                                        rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                        local0\Field24 = curvevalue((local0\Field23 * 1.5), local0\Field24, 40.0)
                                        translateentity(local0\Field3, ((cos((entityyaw(local0\Field3, $01) + 90.0)) * local0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(local0\Field3, $01) + 90.0)) * local0\Field24) * fps\Field7[$00]), $01)
                                        animatenpc(local0, 488.0, 522.0, (local0\Field24 * 26.0), $01)
                                        usedoornpc(local0, $01, $01)
                                    EndIf
                                    local0\Field41 = (local0\Field41 - fps\Field7[$00])
                                Else
                                    local0\Field24 = 0.0
                                    animatenpc(local0, clamp(animtime(local0\Field0), 1.0, 11.0), 74.0, 0.3, $00)
                                    If (73.9 <= local0\Field14) Then
                                        setnpcframe(local0, 1.0, $01)
                                    EndIf
                                    If (rand($32, $01) = $01) Then
                                        rotateentity(local0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                    EndIf
                                    local0\Field41 = (local0\Field41 - (fps\Field7[$00] * 2.0))
                                EndIf
                                local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                            EndIf
                    End Select
                    If (rand($A0, $01) = $01) Then
                        If (channelplaying(local0\Field18) = $00) Then
                            local0\Field18 = playsoundex(loadtempsound((("SFX\SCP\999\Gurgling" + (Str rand($00, $03))) + ".ogg")), camera, local0\Field3, 5.0, 0.3, $00, $00)
                        EndIf
                    EndIf
                    If (0.0 < local0\Field24) Then
                        If ((Float millisecs()) > local0\Field11) Then
                            local26 = createpivot($00)
                            positionentity(local26, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.3), entityz(local0\Field3, $00), $00)
                            turnentity(local26, 90.0, 0.0, 0.0, $00)
                            If (entitypick(local26, 0.6) <> 0) Then
                                local3 = createdecal($14, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.3, 0.36), 0.4, $00, $01, $00, $00, $00)
                                local3\Field7 = -0.0003
                                entityparent(local3\Field0, playerroom\Field2, $01)
                            EndIf
                            freeentity(local26)
                            local26 = $00
                            local0\Field11 = (Float (millisecs() + $3E8))
                        EndIf
                    EndIf
                ElseIf (local0\Field29 = $00) Then
                    For local4 = Each rooms
                        If (local4\Field7\Field6 = $56) Then
                            tformpoint(820.0, -256.0, 0.0, local4\Field2, $00)
                            Exit
                        EndIf
                    Next
                    teleportentity(local0\Field3, tformedx(), tformedy(), tformedz(), 0.3, $00, 2.0, $00)
                    local0\Field29 = $01
                    local0\Field10 = 0.0
                EndIf
                positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.15), entityz(local0\Field3, $00), $00)
                rotateentity(local0\Field0, 0.0, (local0\Field15 + 90.0), 0.0, $00)
            Case $0E
                local0\Field23 = 0.3
                local23 = ((4.0 > entitydistancesquared(me\Field60, local0\Field3)) And entityinview(local0\Field0, camera))
                If (local23 <> 0) Then
                    giveachievement("1048", $01)
                EndIf
                Select local0\Field10
                    Case 0.0
                        local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                        animatenpc(local0, 2.0, 151.0, local0\Field23, $01)
                    Case 1.0
                        If (262.0 > local0\Field14) Then
                            animatenpc(local0, 249.0, 262.0, local0\Field23, $00)
                        Else
                            local0\Field23 = 0.008
                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $01)
                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                            local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            animatenpc(local0, 263.0, 290.0, (local0\Field24 * 37.5), $01)
                        EndIf
                    Case 2.0
                        local22 = ((chs\Field2 Lor i_268\Field2) = $00)
                        If ((local23 And local22) <> 0) Then
                            pointentity(local0\Field3, me\Field60, 0.0)
                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $01)
                        EndIf
                        local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                        local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                        If (0.0 = local0\Field11) Then
                            If ((local23 And local22) <> 0) Then
                                local0\Field11 = 1.0
                            EndIf
                        ElseIf (1.0 = local0\Field11) Then
                            animatenpc(local0, 305.0, 325.0, local0\Field23, $00)
                            If (324.9 < local0\Field14) Then
                                local0\Field11 = 2.0
                            EndIf
                        ElseIf (2.0 = local0\Field11) Then
                            animatenpc(local0, 325.0, 305.0, ((- local0\Field23) / 1.5), $00)
                            If (((305.1 > local0\Field14) And (entityinview(local0\Field0, camera) = $00)) <> 0) Then
                                local0\Field11 = 3.0
                            EndIf
                        EndIf
                    Case 3.0
                        If ((local23 And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                            pointentity(local0\Field3, me\Field60, 0.0)
                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $01)
                            local0\Field11 = 1.0
                        EndIf
                        local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                        If (1.0 = local0\Field11) Then
                            local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                            If (474.0 > local0\Field14) Then
                                animatenpc(local0, 326.0, 474.0, local0\Field23, $00)
                            Else
                                animatenpc(local0, 475.0, 623.0, local0\Field23, $01)
                            EndIf
                        EndIf
                End Select
                positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.08), entityz(local0\Field3, $00), $00)
                rotateentity(local0\Field0, -90.0, local0\Field15, 0.0, $00)
            Case $0F
                If (local0\Field50 = $00) Then
                    local0\Field23 = 1.0
                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                    local23 = ((6.0 > local13) And entityvisible(local0\Field3, me\Field60))
                    If (local23 <> 0) Then
                        giveachievement("1048", $01)
                    EndIf
                    Select local0\Field10
                        Case 0.0
                            local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                            animatenpc(local0, 2.0, 399.0, local0\Field23, $01)
                            If (rand($12C, $01) = $01) Then
                                If (channelplaying(local0\Field18) = $00) Then
                                    local0\Field18 = playsoundex(loadtempsound((("SFX\SCP\1048A\Random" + (Str rand($00, $04))) + ".ogg")), camera, local0\Field3, 8.0, 1.0, $01, $00)
                                EndIf
                            EndIf
                            If ((local23 And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                local0\Field10 = 2.0
                            EndIf
                        Case 1.0
                            local0\Field23 = 0.008
                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $01)
                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                            local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            animatenpc(local0, 649.0, 677.0, (local0\Field24 * 125.0), $01)
                        Case 2.0
                            local21 = local0\Field14
                            animatenpc(local0, max(local21, 2.0), 647.0, 1.0, $00)
                            If (((400.0 >= local21) And (400.0 < local0\Field14)) <> 0) Then
                                local0\Field18 = playsound_strict(loadtempsound("SFX\SCP\1048A\Shriek.ogg"), $00)
                            EndIf
                            local70 = max((1.0 - ((Abs (local21 - 600.0)) / 100.0)), 0.0)
                            me\Field49 = ((local70 * 1000.0) / max((local13 / 8.0), 1.0))
                            me\Field23 = ((local70 * 10.0) / max((local13 / 4.0), 1.0))
                            If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                pointentity(local0\Field3, me\Field60, 0.0)
                                rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $00)
                            EndIf
                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                            If (646.0 < local21) Then
                                If ((((16.0 > local13) And (0.0 = i_1048a\Field0)) And (me\Field54 = $00)) <> 0) Then
                                    i_1048a\Field2 = playsound_strict(loadtempsound("SFX\SCP\1048A\Growth.ogg"), $01)
                                    me\Field49 = 1000.0
                                    me\Field23 = 2.0
                                    i_1048a\Field0 = 0.01
                                EndIf
                                local0\Field60 = $00
                            EndIf
                    End Select
                    updatesoundorigin(local0\Field18, camera, local0\Field3, 8.0, 1.0, $01, $01)
                    positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.15), entityz(local0\Field3, $00), $00)
                    rotateentity(local0\Field0, -90.0, local0\Field15, 0.0, $00)
                    If (local0\Field60 <= $00) Then
                        playsoundex(loadtempsound("SFX\SCP\1048A\Explode.ogg"), camera, local0\Field3, 8.0, 1.0, $00, $00)
                        local16 = entityx(local0\Field3, $00)
                        local18 = entityy(local0\Field3, $00)
                        local19 = entityz(local0\Field3, $00)
                        For local11 = $00 To $01 Step $01
                            setemitter(Null, local16, local18, local19, $0F)
                            setemitter(Null, local16, local18, local19, $15)
                        Next
                        local26 = createpivot($00)
                        positionentity(local26, (rnd(-0.05, 0.05) + local16), (local18 - 0.05), (rnd(-0.05, 0.05) + local19), $00)
                        turnentity(local26, 90.0, 0.0, 0.0, $00)
                        If (entitypick(local26, 0.3) <> 0) Then
                            local3 = createdecal(rand($10, $11), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.3, 0.5), 1.0, $00, $01, $00, $00, $00)
                            local3\Field4 = rnd(0.001, 0.0015)
                            local3\Field5 = (local3\Field3 + rnd(0.008, 0.009))
                        EndIf
                        local0\Field50 = $01
                    EndIf
                EndIf
            Case $09
                If (playerroom\Field7\Field6 <> $69) Then
                    If (1.0 = local0\Field26) Then
                        If (entityhidden(local0\Field0) = $00) Then
                            hideentity(local0\Field0)
                            hideentity(local0\Field1)
                        EndIf
                        If (rand($C8, $01) = $01) Then
                            For local6 = Each waypoints
                                If (local6\Field2 <> playerroom) Then
                                    local13 = distancesquared(entityx(me\Field60, $00), entityx(local6\Field0, $01), entityz(me\Field60, $00), entityz(local6\Field0, $01), 0.0, 0.0)
                                    If (((9.0 < local13) And (81.0 > local13)) <> 0) Then
                                        positionentity(local0\Field3, entityx(local6\Field0, $01), (entityy(local6\Field0, $01) + (1.0 / 12.8)), entityz(local6\Field0, $01), $00)
                                        resetentity(local0\Field3)
                                        local0\Field29 = $00
                                        local0\Field39[$00] = local6
                                        local0\Field26 = 0.0
                                        local0\Field11 = (rnd(15.0, 20.0) * 70.0)
                                        local0\Field10 = max((Float rand($FFFFFFFF, $02)), 0.0)
                                        local0\Field13 = rand($00, $01)
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                    If (0.0 = local0\Field26) Then
                        If (entityhidden(local0\Field0) <> 0) Then
                            showentity(local0\Field0)
                            showentity(local0\Field1)
                        EndIf
                        local13 = entitydistancesquared(me\Field60, local0\Field3)
                        local0\Field31 = curvevalue(0.0, local0\Field31, 10.0)
                        local0\Field33 = curvevalue(0.0, local0\Field33, 10.0)
                        If (rand($64, $01) = $01) Then
                            If (rand($05, $01) = $01) Then
                                local0\Field31 = ((entityx(me\Field60, $00) - entityx(local0\Field3, $00)) * 0.9)
                                local0\Field33 = ((entityz(me\Field60, $00) - entityz(local0\Field3, $00)) * 0.9)
                            Else
                                local0\Field31 = rnd(0.1, 0.5)
                                local0\Field33 = rnd(0.1, 0.5)
                            EndIf
                        EndIf
                        local39 = (Int rnd(-1.0, 1.0))
                        positionentity(local0\Field1, (entityx(local0\Field3, $00) + (local0\Field31 * (Float local39))), ((entityy(local0\Field3, $00) - 0.2) + (sin((Float (((millisec Sar $03) - $2D) Mod $168))) * 0.05)), (entityz(local0\Field3, $00) + (local0\Field33 * (Float local39))), $00)
                        rotateentity(local0\Field1, 0.0, entityyaw(local0\Field0, $00), 0.0, $00)
                        If (floor(local0\Field14) <> floor(animtime(local0\Field1))) Then
                            setanimtime(local0\Field1, local0\Field14, $00)
                        EndIf
                        If (0.0 = local0\Field10) Then
                            If (local0\Field13 = $00) Then
                                animatenpc(local0, 2.0, 74.0, 0.2, $01)
                            Else
                                animatenpc(local0, 75.0, 124.0, 0.2, $01)
                            EndIf
                            If (local0\Field29 <> 0) Then
                                pointentity(local0\Field1, me\Field60, 0.0)
                                rotateentity(local0\Field0, 0.0, curveangle(entityyaw(local0\Field1, $00), entityyaw(local0\Field0, $00), 40.0), 0.0, $00)
                                If (16.0 > local13) Then
                                    local0\Field10 = (Float rand($01, $02))
                                EndIf
                            ElseIf (((36.0 > local13) And (rand($05, $01) = $01)) <> 0) Then
                                If ((entityinview(local0\Field3, camera) And entityvisible(me\Field60, local0\Field3)) <> 0) Then
                                    local0\Field29 = $01
                                    me\Field5 = min(-450.0, me\Field5)
                                    me\Field23 = 0.7
                                    me\Field30 = 0.7
                                    me\Field28 = 150.0
                                    playsound_strict(loadtempsound((("SFX\SCP\513_1\Bell" + (Str rand($00, $02))) + ".ogg")), $00)
                                EndIf
                            EndIf
                        ElseIf (local0\Field39[$00] = Null) Then
                            For local6 = Each waypoints
                                local14 = distancesquared(entityx(local0\Field3, $00), entityx(local6\Field0, $00), entityz(local0\Field3, $00), entityz(local6\Field0, $00), 0.0, 0.0)
                                If (((64.0 > local14) And (1.0 < local14)) <> 0) Then
                                    If (local13 < entitydistancesquared(me\Field60, local6\Field0)) Then
                                        local0\Field39[$00] = local6
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (local0\Field39[$00] = Null) Then
                                local0\Field26 = 1.0
                                local0\Field11 = 0.0
                            EndIf
                        ElseIf (1.0 < entitydistancesquared(local0\Field3, local0\Field39[$00]\Field0)) Then
                            pointentity(local0\Field0, local0\Field39[$00]\Field0, 0.0)
                            rotateentity(local0\Field3, curveangle(entitypitch(local0\Field0, $00), entitypitch(local0\Field3, $00), 15.0), curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 15.0), 0.0, $01)
                            local0\Field24 = curvevalue((max(((7.0 - sqr(local13)) / 7.0), 0.0) * 0.05), local0\Field24, 15.0)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            If (rand($C8, $01) = $01) Then
                                moveentity(local0\Field3, 0.0, 0.0, 0.5)
                            EndIf
                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $01)
                        Else
                            For local11 = $00 To $04 Step $01
                                If (local0\Field39[$00]\Field4[local11] <> Null) Then
                                    If (local13 < entitydistancesquared(me\Field60, local0\Field39[$00]\Field4[local11]\Field0)) Then
                                        If (local0\Field29 = $00) Then
                                            If ((entityinview(local0\Field3, camera) And entityvisible(me\Field60, local0\Field3)) <> 0) Then
                                                local0\Field29 = $01
                                                me\Field5 = min(-450.0, me\Field5)
                                                me\Field23 = 0.7
                                                me\Field30 = 0.7
                                                me\Field28 = 150.0
                                                playsound_strict(loadtempsound((("SFX\SCP\513_1\Bell" + (Str rand($00, $02))) + ".ogg")), $00)
                                            EndIf
                                        EndIf
                                        local0\Field39[$00] = local0\Field39[$00]\Field4[local11]
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (local0\Field39[$00] = Null) Then
                                local0\Field11 = 0.0
                            EndIf
                        EndIf
                        positionentity(local0\Field0, entityx(local0\Field3, $00), ((entityy(local0\Field3, $00) - 0.2) + (sin((Float ((millisec Sar $03) Mod $168))) * 0.1)), entityz(local0\Field3, $00), $00)
                        Select local0\Field10
                            Case 1.0
                                If (local0\Field13 = $00) Then
                                    animatenpc(local0, 125.0, 194.0, (local0\Field24 * 20.0), $01)
                                Else
                                    animatenpc(local0, 195.0, 264.0, (local0\Field24 * 20.0), $01)
                                EndIf
                                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field3, $00), 0.0, $00)
                            Case 2.0
                                If (local0\Field13 = $00) Then
                                    animatenpc(local0, 2.0, 74.0, 0.2, $01)
                                Else
                                    animatenpc(local0, 75.0, 124.0, 0.2, $01)
                                EndIf
                                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field3, $00), 0.0, $00)
                        End Select
                        If (0.0 < local0\Field11) Then
                            If (16.0 > local13) Then
                                local0\Field11 = (local0\Field11 - (fps\Field7[$00] * 4.0))
                            EndIf
                            local0\Field11 = (local0\Field11 - fps\Field7[$00])
                        Else
                            local0\Field39[$00] = Null
                            local0\Field26 = 1.0
                            local0\Field11 = 0.0
                        EndIf
                    EndIf
                EndIf
                local0\Field7 = 0.0
                resetentity(local0\Field3)
            Case $08
                If (playerinreachableroom($01, $00) <> 0) Then
                    If (1.0 = local0\Field26) Then
                        If (entityhidden(local0\Field0) = $00) Then
                            hideentity(local0\Field0)
                        EndIf
                        If (((rand($32, $01) = $01) And ((-5.0 > me\Field10) And (-15.0 < me\Field10))) <> 0) Then
                            local15 = (entityyaw(me\Field60, $00) + rnd(-90.0, 90.0))
                            local13 = rnd(1.5, 2.0)
                            positionentity(local0\Field3, (entityx(me\Field60, $00) + (sin(local15) * local13)), (entityy(me\Field60, $00) + 0.2), (entityz(me\Field60, $00) + (cos(local15) * local13)), $00)
                            local0\Field26 = 0.0
                            local0\Field10 = rnd(20.0, 60.0)
                            If (rand($12C, $01) = $01) Then
                                playsoundex(snd_i\Field27[rand($00, $05)], camera, local0\Field3, 8.0, rnd(0.0, 0.2), $00, $00)
                            EndIf
                        EndIf
                    EndIf
                    If (0.0 = local0\Field26) Then
                        If (entityhidden(local0\Field0) <> 0) Then
                            showentity(local0\Field0)
                        EndIf
                        positionentity(local0\Field0, (entityx(local0\Field3, $00) + rnd(-0.005, 0.005)), ((entityy(local0\Field3, $00) + 0.3) + (sin(((Float millisec) / 2.0)) * 0.1)), (entityz(local0\Field3, $00) + rnd(-0.005, 0.005)), $00)
                        rotateentity(local0\Field0, 0.0, entityyaw(local0\Field3, $00), (((Float millisec) / 5.0) Mod 360.0), $00)
                        animatenpc(local0, 1.0, 300.0, rnd(0.8, 2.5), $01)
                        If ((entityinview(local0\Field0, camera) And ((-16.0 > me\Field10) Lor (-6.0 < me\Field10))) <> 0) Then
                            giveachievement("372", $01)
                            If (rand($1E, $01) = $01) Then
                                If (entityvisible(camera, local0\Field0) <> 0) Then
                                    If (channelplaying(local0\Field18) = $00) Then
                                        local0\Field18 = playsoundex(snd_i\Field27[rand($00, $05)], camera, local0\Field0, 8.0, 0.3, $00, $00)
                                    EndIf
                                EndIf
                            EndIf
                            local39 = createpivot($00)
                            positionentity(local39, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00)
                            pointentity(local39, local0\Field3, 0.0)
                            local15 = wrapangle((entityyaw(me\Field60, $00) - entityyaw(local39, $00)), 360.0)
                            If (180.0 > local15) Then
                                rotateentity(local0\Field3, 0.0, (entityyaw(me\Field60, $00) - 80.0), 0.0, $00)
                            Else
                                rotateentity(local0\Field3, 0.0, (entityyaw(me\Field60, $00) + 80.0), 0.0, $00)
                            EndIf
                            freeentity(local39)
                            local39 = $00
                            moveentity(local0\Field3, 0.0, 0.0, (fps\Field7[$00] * 0.03))
                        EndIf
                        local0\Field10 = (local0\Field10 - (fps\Field7[$00] * 0.8))
                        If (0.0 >= local0\Field10) Then
                            local0\Field26 = 1.0
                            positionentity(local0\Field3, 0.0, -500.0, 0.0, $00)
                        EndIf
                    EndIf
                    local0\Field7 = 0.0
                    resetentity(local0\Field3)
                EndIf
            Case $11
                If (3600.0 > entitydistancesquared(me\Field60, local0\Field3)) Then
                    If (playerroom\Field7\Field6 = $49) Then
                        local14 = clamp((entitydistance(local0\Field3, playerroom\Field11[$0A]) / 31.25), 0.0, 1.0)
                    Else
                        local14 = 1.0
                    EndIf
                    local0\Field18 = loopsoundex(snd_i\Field60, local0\Field18, camera, local0\Field3, 25.0, local14, $00)
                EndIf
                local0\Field7 = 0.0
                Select local0\Field10
                    Case 0.0,1.0
                        turnentity(local0\Field1, 0.0, (fps\Field7[$00] * 20.0), 0.0, $00)
                        turnentity(local0\Field2, (fps\Field7[$00] * 20.0), 0.0, 0.0, $00)
                        If (((1.0 = local0\Field10) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                            If (rand($14, $01) = $01) Then
                                If (900.0 > distancesquared(entityx(me\Field60, $00), entityx(local0\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field3, $00), 0.0, 0.0)) Then
                                    If (20.0 > (Abs (entityy(me\Field60, $00) - entityy(local0\Field3, $00)))) Then
                                        If (entityvisible(me\Field60, local0\Field3) <> 0) Then
                                            playsoundex(snd_i\Field50[$01], camera, local0\Field3, 50.0, 1.0, $00, $00)
                                            local0\Field10 = 2.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Case 2.0,3.0
                        If (2.0 = local0\Field10) Then
                            local25 = me\Field60
                        ElseIf (3.0 = local0\Field10) Then
                            local25 = createpivot($00)
                            positionentity(local25, local0\Field36, local0\Field37, local0\Field38, $01)
                        EndIf
                        turnentity(local0\Field1, 0.0, (fps\Field7[$00] * 20.0), 0.0, $00)
                        turnentity(local0\Field2, (fps\Field7[$00] * 20.0), 0.0, 0.0, $00)
                        If (3025.0 > distancesquared(entityx(local25, $00), entityx(local0\Field3, $00), entityz(local25, $00), entityz(local0\Field3, $00), 0.0, 0.0)) Then
                            If (20.0 > (Abs (entityy(local25, $00) - entityy(local0\Field3, $00)))) Then
                                pointentity(local0\Field0, local25, 0.0)
                                rotateentity(local0\Field3, curveangle(min(wrapangle(entitypitch(local0\Field0, $00), 360.0), 40.0), entitypitch(local0\Field3, $00), 40.0), curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 90.0), entityroll(local0\Field3, $00), $01)
                                positionentity(local0\Field3, entityx(local0\Field3, $00), curvevalue((entityy(local25, $00) + 8.0), entityy(local0\Field3, $00), 70.0), entityz(local0\Field3, $00), $00)
                                local13 = distancesquared(entityx(local25, $00), entityx(local0\Field3, $00), entityz(local25, $00), entityz(local0\Field3, $00), 0.0, 0.0)
                                local0\Field24 = curvevalue((min((sqr(local13) - 6.5), 6.5) * 0.008), local0\Field24, 50.0)
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                local23 = $00
                                If (0.0 = local0\Field41) Then
                                    local23 = entityvisible(local0\Field3, local25)
                                    local0\Field41 = rnd(100.0, 200.0)
                                Else
                                    local0\Field41 = min((local0\Field41 - fps\Field7[$00]), 0.0)
                                EndIf
                                If (((chs\Field2 Lor i_268\Field2) And (2.0 = local0\Field10)) <> 0) Then
                                    local23 = $00
                                EndIf
                                If (local23 <> 0) Then
                                    rotateentity(local0\Field3, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), curveangle(0.0, entityroll(local0\Field3, $00), 40.0), $01)
                                    If (0.0 >= local0\Field28) Then
                                        If (400.0 > local13) Then
                                            local26 = createpivot($00)
                                            positionentity(local26, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                                            rotateentity(local26, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), entityroll(local0\Field3, $00), $00)
                                            moveentity(local26, 0.0, 0.023, 0.188)
                                            pointentity(local26, local25, 0.0)
                                            If (10.0 > wrapangle((entityyaw(local26, $00) - entityyaw(local0\Field3, $00)), 360.0)) Then
                                                playsoundex(snd_i\Field13[$01], camera, local0\Field3, 20.0, 1.0, $00, $00)
                                                local36 = sqr(local13)
                                                shoot(local0, entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), local0\Field3, (((10.0 / local36) * (1.0 / local36)) * (Float (2.0 = local0\Field10))), (2.0 = local0\Field10), $00)
                                                If (((Int me\Field0) And (3.0 <> local0\Field10)) <> 0) Then
                                                    If (playerroom\Field7\Field6 = $49) Then
                                                        msg\Field2 = getlocalstring("death", "apache.gateb")
                                                    Else
                                                        msg\Field2 = getlocalstring("death", "apache.gatea")
                                                    EndIf
                                                EndIf
                                            EndIf
                                            freeentity(local26)
                                            local26 = $00
                                        EndIf
                                        local0\Field28 = 5.0
                                    EndIf
                                Else
                                    rotateentity(local0\Field3, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), curveangle(-20.0, entityroll(local0\Field3, $00), 40.0), $01)
                                EndIf
                                moveentity(local0\Field3, ((- entityroll(local0\Field3, $00)) * 0.002), 0.0, 0.0)
                                local0\Field28 = (local0\Field28 - fps\Field7[$00])
                            EndIf
                        EndIf
                        If (3.0 = local0\Field10) Then
                            freeentity(local25)
                            local25 = $00
                        EndIf
                    Case 4.0
                        If (300.0 > local0\Field11) Then
                            turnentity(local0\Field1, 0.0, (fps\Field7[$00] * 20.0), 0.0, $00)
                            turnentity(local0\Field2, (fps\Field7[$00] * 20.0), 0.0, 0.0, $00)
                            turnentity(local0\Field3, 0.0, ((- fps\Field7[$00]) * 7.0), 0.0, $00)
                            local0\Field11 = (local0\Field11 + (fps\Field7[$00] * 0.3))
                            local25 = createpivot($00)
                            positionentity(local25, local0\Field36, local0\Field37, local0\Field38, $01)
                            pointentity(local0\Field0, local25, 0.0)
                            moveentity(local0\Field0, 0.0, 0.0, ((fps\Field7[$00] * 0.001) * local0\Field11))
                            positionentity(local0\Field3, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            If (0.09 > entitydistancesquared(local0\Field0, local25)) Then
                                me\Field23 = max(me\Field23, 3.0)
                                playsound_strict(loadtempsound((("SFX\Character\Apache\Crash" + (Str rand($00, $01))) + ".ogg")), $00)
                                local0\Field10 = 5.0
                            EndIf
                            freeentity(local25)
                            local25 = $00
                        EndIf
                End Select
                positionentity(local0\Field0, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), entityroll(local0\Field3, $00), $01)
            Case $01
                If (local0\Field50 = $00) Then
                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                    If ((hidedistance * hidedistance) > local13) Then
                        local21 = local0\Field14
                        Select local0\Field10
                            Case 0.0
                                If (282.0 = local0\Field14) Then
                                    local26 = createpivot($00)
                                    positionentity(local26, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                                    turnentity(local26, 90.0, 0.0, 0.0, $00)
                                    If (entitypick(local26, 0.5) <> 0) Then
                                        local3 = createdecal($01, entityx(local0\Field3, $00), (pickedy() + 0.005), entityz(local0\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 1.0, $00, $01, $00, $00, $00)
                                        local3\Field4 = 0.0005
                                        local3\Field5 = 0.2
                                        entityparent(local3\Field0, playerroom\Field2, $01)
                                    EndIf
                                    freeentity(local26)
                                    local26 = $00
                                    playsoundex(loadtempsound("SFX\SCP\035_Tentacle\TentacleSpawn.ogg"), camera, local0\Field3, 5.0, 1.0, $00, $00)
                                    setnpcframe(local0, 283.0, $01)
                                Else
                                    me\Field30 = max(curvevalue(1.0, me\Field30, 50.0), me\Field30)
                                    me\Field28 = max(curvevalue(130.0, me\Field28, 100.0), me\Field28)
                                    pointentity(local0\Field0, me\Field60, 0.0)
                                    rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 25.0), 0.0, $00)
                                    animatenpc(local0, 283.0, 389.0, 0.3, $00)
                                    If (388.9 < local0\Field14) Then
                                        local0\Field10 = 1.0
                                    EndIf
                                EndIf
                            Case 1.0
                                animatenpc(local0, 33.0, 174.0, 0.3, $01)
                                If (((3.24 > local13) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                    local0\Field10 = 2.0
                                Else
                                    If (rand($190, $01) = $01) Then
                                        local0\Field15 = rnd(360.0, 0.0)
                                    EndIf
                                    rotateentity(local0\Field3, 0.0, curveangle((local0\Field15 + (sin((Float (millisec / $32))) * 2.0)), entityyaw(local0\Field3, $00), 150.0), 0.0, $01)
                                EndIf
                            Case 2.0
                                If (((32.0 < local0\Field14) And (174.0 > local0\Field14)) <> 0) Then
                                    animatenpc(local0, 33.0, 174.0, 2.0, $00)
                                    If (173.9 < local0\Field14) Then
                                        setnpcframe(local0, 2.0, $01)
                                    EndIf
                                Else
                                    pointentity(local0\Field0, me\Field60, 0.0)
                                    rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 10.0), 0.0, $00)
                                    animatenpc(local0, 2.0, 32.0, 0.3, $00)
                                    If (((5.0 < local0\Field14) And (5.0 >= local21)) <> 0) Then
                                        If (3.24 > local13) Then
                                            If (20.0 > (Abs deltayaw(local0\Field3, me\Field60))) Then
                                                If (wi\Field2 > $00) Then
                                                    playsound_strict(loadtempsound("SFX\Character\BodyFall.ogg"), $00)
                                                    me\Field31 = (me\Field31 + rnd(0.5, 0.0))
                                                Else
                                                    playsound_strict(snd_i\Field51[rand($09, $0A)], $00)
                                                    injureplayer((rnd(0.75, 1.15) * local37), 0.0, 100.0, (0.4 * local37), (0.175 * local37))
                                                    If (3.0 < me\Field31) Then
                                                        If (playerroom\Field7\Field6 = $4D) Then
                                                            msg\Field2 = getlocalstring("death", "035.offices")
                                                        Else
                                                            msg\Field2 = getlocalstring("death", "035.default")
                                                        EndIf
                                                        kill($01, $01, $00, $01)
                                                    EndIf
                                                EndIf
                                                me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.0)
                                            Else
                                                playsoundex(snd_i\Field48, camera, local0\Field3, 10.0, 1.0, $00, $00)
                                            EndIf
                                        Else
                                            playsoundex(snd_i\Field48, camera, local0\Field3, 3.0, 1.0, $00, $00)
                                        EndIf
                                    ElseIf (31.9 < local0\Field14) Then
                                        setnpcframe(local0, 173.0, $01)
                                        local0\Field10 = 1.0
                                    EndIf
                                EndIf
                        End Select
                        If (0.0 <> local0\Field10) Then
                            local0\Field18 = loopsoundex(npcsound[$04], local0\Field18, camera, local0\Field3, 10.0, 1.0, $00)
                        EndIf
                    EndIf
                    If (local0\Field60 <= $00) Then
                        local0\Field50 = $01
                    EndIf
                Else
                    animatenpc(local0, 515.0, 551.0, 0.15, $00)
                EndIf
                positionentity(local0\Field0, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                rotateentity(local0\Field0, (entitypitch(local0\Field3, $00) - 90.0), (entityyaw(local0\Field3, $00) - 180.0), entityroll(local0\Field3, $00), $01)
            Case $0A
                If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
                    If (20.0 < entityy(me\Field60, $00)) Then
                        local74 = playerroom\Field10
                        local13 = entitydistancesquared(me\Field60, local0\Field3)
                        If (1.0 = forestnpcdata[$02]) Then
                            If (entityhidden(forestnpc) <> 0) Then
                                showentity(forestnpc)
                            EndIf
                            If (0.0 = forestnpcdata[$01]) Then
                                If (rand($C8, $01) = $01) Then
                                    forestnpcdata[$01] = fps\Field7[$00]
                                    entitytexture(forestnpc, forestnpctex, (Int (forestnpcdata[$00] + 1.0)), $00)
                                EndIf
                            ElseIf (((0.0 < forestnpcdata[$01]) And (5.0 > forestnpcdata[$01])) <> 0) Then
                                forestnpcdata[$01] = min((fps\Field7[$00] + forestnpcdata[$01]), 5.0)
                            Else
                                forestnpcdata[$01] = 0.0
                                entitytexture(forestnpc, forestnpctex, (Int forestnpcdata[$00]), $00)
                            EndIf
                            If (1.0 <> local0\Field10) Then
                                If ((((-8.0 > me\Field10) And (-12.0 < me\Field10)) Lor (entityinview(forestnpc, camera) = $00)) <> 0) Then
                                    forestnpcdata[$02] = 0.0
                                    If (entityhidden(forestnpc) = $00) Then
                                        hideentity(forestnpc)
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf (entityhidden(forestnpc) = $00) Then
                            hideentity(forestnpc)
                        EndIf
                        Select local0\Field10
                            Case 0.0
                                If (entityhidden(local0\Field3) = $00) Then
                                    hideentity(local0\Field3)
                                    hideentity(local0\Field0)
                                    hideentity(local0\Field1)
                                    positionentity(local0\Field3, 0.0, -100.0, 0.0, $00)
                                    local0\Field11 = 0.0
                                EndIf
                            Case 1.0
                                local0\Field7 = 0.0
                                If (-100.0 >= entityy(local0\Field3, $00)) Then
                                    tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local74\Field4)
                                    local16 = floor(((tformedx() + 6.0) / 12.0))
                                    local19 = floor(((tformedz() + 6.0) / 12.0))
                                    local31 = (Int max((local16 - 1.0), 1.0))
                                    local32 = (Int min((local16 + 1.0), 10.0))
                                    local33 = (Int max((local19 - 1.0), 1.0))
                                    local34 = (Int min((local19 + 1.0), 10.0))
                                    For local17 = (Float local31) To (Float local32) Step 2.0
                                        For local20 = (Float local33) To (Float local34) Step 2.0
                                            If (local74\Field2[(Int ((local20 * 10.0) + local17))] = $00) Then
                                                tformpoint((((local17 + local16) / 2.0) * 12.0), 0.0, (((local20 + local19) / 2.0) * 12.0), local74\Field4, $00)
                                                positionentity(local0\Field3, tformedx(), (entityy(local74\Field4, $01) + 2.3), tformedz(), $00)
                                                If (entityinview(local0\Field3, camera) <> 0) Then
                                                    positionentity(local0\Field3, 0.0, -110.0, 0.0, $00)
                                                Else
                                                    local17 = 10.0
                                                    Exit
                                                EndIf
                                            EndIf
                                        Next
                                    Next
                                    If (-100.0 < entityy(local0\Field3, $00)) Then
                                        playsoundex(stepsfx($04, $00, rand($00, $02)), camera, local0\Field3, 15.0, 0.5, $00, $00)
                                        If (1.0 <> forestnpcdata[$02]) Then
                                            forestnpcdata[$02] = 0.0
                                        EndIf
                                        Select rand($03, $01)
                                            Case $01
                                                pointentity(local0\Field3, me\Field60, 0.0)
                                                setnpcframe(local0, 2.0, $01)
                                            Case $02
                                                pointentity(local0\Field3, me\Field60, 0.0)
                                                setnpcframe(local0, 201.0, $01)
                                            Case $03
                                                pointentity(local0\Field3, me\Field60, 0.0)
                                                turnentity(local0\Field3, 0.0, 90.0, 0.0, $00)
                                                setnpcframe(local0, 299.0, $01)
                                        End Select
                                        local0\Field11 = 0.0
                                    EndIf
                                Else
                                    If (entityhidden(local0\Field0) <> 0) Then
                                        showentity(local0\Field0)
                                        showentity(local0\Field3)
                                    EndIf
                                    positionentity(local0\Field3, entityx(local0\Field3, $00), (entityy(local74\Field4, $01) + 2.3), entityz(local0\Field3, $00), $00)
                                    If (0.0 = forestnpcdata[$02]) Then
                                        local77 = $00
                                        local78 = $00
                                        For local11 = $00 To (maxitemamount - $01) Step $01
                                            If (inventory(local11) <> Null) Then
                                                local79 = inventory(local11)\Field4\Field1
                                                If ((((local79 = "Log #1") Lor (local79 = "Log #2")) Lor (local79 = "Log #3")) <> 0) Then
                                                    local78 = (local78 + $01)
                                                    local77 = (local77 + ($0A * local78))
                                                EndIf
                                            EndIf
                                        Next
                                        If (rand(($35C - local77), $01) = $01) Then
                                            If (entityhidden(forestnpc) <> 0) Then
                                                showentity(forestnpc)
                                            EndIf
                                            forestnpcdata[$02] = 1.0
                                            If (rand($02, $01) = $01) Then
                                                forestnpcdata[$00] = 0.0
                                            Else
                                                forestnpcdata[$00] = 2.0
                                            EndIf
                                            forestnpcdata[$01] = 0.0
                                            positionentity(forestnpc, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) + 0.5), entityz(local0\Field3, $00), $00)
                                            rotateentity(forestnpc, 0.0, entityyaw(local0\Field3, $00), 0.0, $00)
                                            moveentity(forestnpc, 0.75, 0.0, 0.0)
                                            rotateentity(forestnpc, 0.0, 0.0, 0.0, $00)
                                            entitytexture(forestnpc, forestnpctex, (Int forestnpcdata[$00]), $00)
                                        Else
                                            forestnpcdata[$02] = 2.0
                                        EndIf
                                    EndIf
                                    If (0.0 = local0\Field11) Then
                                        If (entityinview(local0\Field3, camera) <> 0) Then
                                            If (rand($08, $01) = $01) Then
                                                playsoundex(loadtempsound((("SFX\SCP\860_2\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field3, 20.0, 1.0, $01, $00)
                                            EndIf
                                            local0\Field11 = 1.0
                                        EndIf
                                    ElseIf (199.0 >= local0\Field14) Then
                                        animatenpc(local0, 2.0, 199.0, 0.5, $00)
                                        If (199.0 = local0\Field14) Then
                                            playsoundex(stepsfx($04, $00, rand($00, $02)), camera, local0\Field3, 15.0, 1.0, $00, $00)
                                            setnpcframe(local0, 298.0, $01)
                                        EndIf
                                    ElseIf (297.0 >= local0\Field14) Then
                                        pointentity(local0\Field3, me\Field60, 0.0)
                                        animatenpc(local0, 200.0, 297.0, 0.5, $00)
                                        If (297.0 = local0\Field14) Then
                                            playsoundex(stepsfx($04, $00, rand($00, $02)), camera, local0\Field3, 15.0, 1.0, $00, $00)
                                            setnpcframe(local0, 298.0, $01)
                                        EndIf
                                    Else
                                        local15 = curveangle(pointdirection(entityx(local0\Field3, $00), entityz(local0\Field3, $00), entityx(me\Field60, $00), entityz(me\Field60, $00)), (entityyaw(local0\Field3, $00) + 90.0), 20.0)
                                        rotateentity(local0\Field3, 0.0, (local15 - 90.0), 0.0, $01)
                                        animatenpc(local0, 298.0, 316.0, (local0\Field24 * 10.0), $01)
                                        local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                        If (225.0 < local13) Then
                                            local0\Field10 = 0.0
                                        EndIf
                                    EndIf
                                EndIf
                                resetentity(local0\Field3)
                            Case 2.0
                                If (entityhidden(local0\Field0) <> 0) Then
                                    showentity(local0\Field0)
                                    showentity(local0\Field3)
                                EndIf
                                local21 = local0\Field14
                                If (-100.0 >= entityy(local0\Field3, $00)) Then
                                    tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local74\Field4)
                                    local16 = floor(((tformedx() + 6.0) / 12.0))
                                    local19 = floor(((tformedz() + 6.0) / 12.0))
                                    local31 = (Int max((local16 - 1.0), 1.0))
                                    local32 = (Int min((local16 + 1.0), 10.0))
                                    local33 = (Int max((local19 - 1.0), 1.0))
                                    local34 = (Int min((local19 + 1.0), 10.0))
                                    For local17 = (Float local31) To (Float local32) Step 1.0
                                        For local20 = (Float local33) To (Float local34) Step 1.0
                                            If ((((local74\Field2[(Int ((local20 * 10.0) + local17))] > $00) And ((local16 <> local17) Lor (local19 <> local20))) And ((local16 = local17) Lor (local19 = local20))) <> 0) Then
                                                tformpoint((local17 * 12.0), 0.0, (local20 * 12.0), local74\Field4, $00)
                                                positionentity(local0\Field3, tformedx(), (entityy(local74\Field4, $01) + 1.0), tformedz(), $00)
                                                If (entityinview(local0\Field3, camera) <> 0) Then
                                                    me\Field10 = -10.0
                                                Else
                                                    local17 = 10.0
                                                    Exit
                                                EndIf
                                            EndIf
                                        Next
                                    Next
                                Else
                                    local15 = curveangle(find860angle(local0, local74), (entityyaw(local0\Field3, $00) + 90.0), 80.0)
                                    rotateentity(local0\Field3, 0.0, (local15 - 90.0), 0.0, $01)
                                    local0\Field24 = curvevalue((local0\Field23 * 0.3), local0\Field24, 50.0)
                                    moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                    animatenpc(local0, 494.0, 569.0, (local0\Field24 * 25.0), $01)
                                    If (0.0 = local0\Field11) Then
                                        If (64.0 > local13) Then
                                            If (entityinview(local0\Field3, camera) <> 0) Then
                                                If (rand($08, $01) = $01) Then
                                                    playsound_strict(loadtempsound((("SFX\SCP\860_2\Chase" + (Str rand($00, $02))) + ".ogg")), $00)
                                                    playsoundex(loadtempsound((("SFX\SCP\860_2\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field3, 10.0, 1.0, $01, $00)
                                                EndIf
                                                local0\Field11 = 1.0
                                            EndIf
                                        EndIf
                                    EndIf
                                    If (0.03 < me\Field38) Then
                                        local0\Field12 = (local0\Field12 + fps\Field7[$00])
                                        If (local0\Field12 > rnd(5000.0, 0.0)) Then
                                            local39 = $01
                                            If (channelplaying(local0\Field18) <> 0) Then
                                                local39 = $00
                                            EndIf
                                            If (local39 <> 0) Then
                                                local0\Field18 = playsoundex(loadtempsound((("SFX\SCP\860_2\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field3, 10.0, 1.0, $01, $00)
                                            EndIf
                                        EndIf
                                    Else
                                        local0\Field12 = max((local0\Field12 - fps\Field7[$00]), 0.0)
                                    EndIf
                                    If (((20.25 > local13) Lor (rnd(200.0, 250.0) < local0\Field12)) <> 0) Then
                                        If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                            local0\Field18 = playsoundex(loadtempsound((("SFX\SCP\860_2\Cancer" + (Str rand($03, $05))) + ".ogg")), camera, local0\Field3, 10.0, 1.0, $01, $00)
                                            local0\Field10 = 3.0
                                        ElseIf ((((492.0 > local21) And (492.0 <= local0\Field14)) Lor ((568.0 > local21) And (568.0 <= local0\Field14))) <> 0) Then
                                            setnpcframe(local0, 2.0, $01)
                                            local0\Field10 = 4.0
                                        EndIf
                                    EndIf
                                    If (400.0 < local13) Then
                                        local0\Field10 = 0.0
                                    EndIf
                                EndIf
                                If ((((533.0 > local21) And (533.0 <= local0\Field14)) Lor ((568.0 > local21) And (568.0 <= local0\Field14))) <> 0) Then
                                    playsoundex(stepsfx($04, $00, rand($00, $02)), camera, local0\Field3, 15.0, 0.6, $00, $00)
                                EndIf
                            Case 3.0
                                If (entityhidden(local0\Field0) <> 0) Then
                                    showentity(local0\Field0)
                                    showentity(local0\Field3)
                                EndIf
                                local21 = local0\Field14
                                local15 = curveangle(find860angle(local0, local74), (entityyaw(local0\Field3, $00) + 90.0), 40.0)
                                rotateentity(local0\Field3, 0.0, (local15 - 90.0), 0.0, $01)
                                If ((((1.0 > local13) Lor ((451.0 < local0\Field14) And (493.0 > local0\Field14))) Lor (Int me\Field0)) <> 0) Then
                                    msg\Field2 = format(getlocalstring("death", "860"), subjectname, "%s")
                                    local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                                    animatenpc(local0, 451.0, 493.0, 0.5, $00)
                                    If (((461.0 > local21) And (461.0 <= local0\Field14)) <> 0) Then
                                        playsound_strict(snd_i\Field51[$0B], $00)
                                        me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.0)
                                        kill($01, $01, $00, $01)
                                    EndIf
                                    If ((((476.0 > local21) And (476.0 <= local0\Field14)) Lor ((486.0 > local21) And (486.0 <= local0\Field14))) <> 0) Then
                                        playsound_strict(snd_i\Field51[$0C], $00)
                                    EndIf
                                Else
                                    local0\Field24 = curvevalue((local0\Field23 * 0.8), local0\Field24, 10.0)
                                    animatenpc(local0, 298.0, 316.0, (local0\Field24 * 10.0), $01)
                                    If (((307.0 > local21) And (307.0 <= local0\Field14)) <> 0) Then
                                        playsoundex(stepsfx($04, $00, rand($00, $02)), camera, local0\Field3, 10.0, 1.0, $00, $00)
                                    EndIf
                                EndIf
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                If ((chs\Field2 Lor i_268\Field2) <> 0) Then
                                    If ((((315.0 > local21) And (315.0 <= local0\Field14)) Lor ((492.0 > local21) And (492.0 <= local0\Field14))) <> 0) Then
                                        setnpcframe(local0, 2.0, $01)
                                        local0\Field10 = 4.0
                                    EndIf
                                EndIf
                            Case 4.0
                                local0\Field24 = 0.0
                                animatenpc(local0, 2.0, 199.0, 0.5, $01)
                                If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                    local0\Field10 = 3.0
                                EndIf
                        End Select
                        If (0.0 <> local0\Field10) Then
                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $01)
                            positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.23), entityz(local0\Field3, $00), $00)
                            rotateentity(local0\Field0, (entitypitch(local0\Field3, $00) - 90.0), entityyaw(local0\Field3, $00), entityroll(local0\Field3, $00), $01)
                            If (64.0 < local13) Then
                                If (entityhidden(local0\Field1) <> 0) Then
                                    showentity(local0\Field1)
                                EndIf
                                entityalpha(local0\Field1, min((sqr(local13) - 8.0), 1.0))
                                positionentity(local0\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field3, $00) - 180.0), 0.0, $00)
                                moveentity(local0\Field1, 0.0, 0.75, -0.825)
                                local26 = createpivot($00)
                                positionentity(local26, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local26, local0\Field1, 0.0)
                                moveentity(local26, 0.0, 0.0, 8.0)
                                positionentity(local0\Field1, entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), $00)
                                freeentity(local26)
                                local26 = $00
                            ElseIf (entityhidden(local0\Field1) = $00) Then
                                hideentity(local0\Field1)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $0B
                If (playerroom\Field7\Field6 <> $1F) Then
                    local0\Field10 = 66.0
                EndIf
                If (66.0 > local0\Field10) Then
                    Select local0\Field10
                        Case 0.0
                            animatenpc(local0, 290.0, 405.0, 0.1, $01)
                        Case 1.0
                            If (((644.0 <= local0\Field14) And (683.0 > local0\Field14)) <> 0) Then
                                local0\Field24 = curvevalue((local0\Field23 * 0.05), local0\Field24, 10.0)
                                animatenpc(local0, 644.0, 683.0, ((local0\Field24 * 28.0) * 4.0), $00)
                                If (682.0 <= local0\Field14) Then
                                    setnpcframe(local0, 175.0, $01)
                                EndIf
                            Else
                                local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                                animatenpc(local0, 175.0, 297.0, 0.22, $00)
                                If (296.0 <= local0\Field14) Then
                                    local0\Field10 = 2.0
                                EndIf
                            EndIf
                            local0\Field29 = $00
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                        Case 2.0
                            local0\Field11 = max(local0\Field11, (Float (local0\Field13 - $03)))
                            local13 = entitydistancesquared(local0\Field3, playerroom\Field11[(Int local0\Field11)])
                            local0\Field24 = curvevalue(((local0\Field23 * 0.3) * min(sqr(local13), 1.0)), local0\Field24, 10.0)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            local21 = local0\Field14
                            animatenpc(local0, 644.0, 683.0, (local0\Field24 * 28.0), $01)
                            If ((((664.0 > local21) And (664.0 <= local0\Field14)) Lor ((673.0 < local21) And (654.0 > local0\Field14))) <> 0) Then
                                playsoundex(snd_i\Field56[rand($03, $06)], camera, local0\Field3, 12.0, 1.0, $00, $00)
                                If (rand($0A, $01) = $01) Then
                                    local39 = ((local0\Field18 = $00) Lor (channelplaying(local0\Field18) = $00))
                                    If (local39 <> 0) Then
                                        loadnpcsound(local0, (((("SFX\SCP\939\" + (Str (local0\Field5 Mod $03))) + "Lure") + (Str rand($00, $09))) + ".ogg"), $00)
                                        local0\Field18 = playsoundex(local0\Field17, camera, local0\Field3, 10.0, 1.0, $01, $00)
                                    EndIf
                                EndIf
                            EndIf
                            pointentity(local0\Field0, playerroom\Field11[(Int local0\Field11)], 0.0)
                            rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 20.0), 0.0, $00)
                            If (0.16 > local13) Then
                                local0\Field11 = (local0\Field11 + 1.0)
                                If ((Float local0\Field13) < local0\Field11) Then
                                    local0\Field11 = (Float (local0\Field13 - $03))
                                EndIf
                                local0\Field10 = 1.0
                            EndIf
                        Case 3.0
                            If (entityvisible(me\Field60, local0\Field3) <> 0) Then
                                local0\Field36 = entityx(me\Field60, $00)
                                local0\Field38 = entityz(me\Field60, $00)
                                local0\Field29 = $46
                            EndIf
                            If (((local0\Field29 > $00) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                local21 = local0\Field14
                                If (((18.0 <= local0\Field14) And (68.0 > local0\Field14)) <> 0) Then
                                    local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                                    animatenpc(local0, 18.0, 68.0, 0.5, $01)
                                    local39 = (((24.0 > local21) And (24.0 <= local0\Field14)) Lor ((57.0 > local21) And (57.0 <= local0\Field14)))
                                    If (local39 <> 0) Then
                                        If (2.25 > distancesquared(local0\Field36, entityx(local0\Field3, $00), local0\Field38, entityz(local0\Field3, $00), 0.0, 0.0)) Then
                                            playsound_strict(snd_i\Field51[$0B], $00)
                                            injureplayer(rnd(1.5, 2.5), 0.0, 500.0, rnd(0.2, 0.75), 0.0)
                                            me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.0)
                                        Else
                                            setnpcframe(local0, 449.0, $01)
                                        EndIf
                                    EndIf
                                    If (4.0 < me\Field31) Then
                                        If (chs\Field0 = $00) Then
                                            local0\Field10 = 5.0
                                        EndIf
                                        msg\Field2 = getlocalstring("death", "939")
                                        kill($01, $01, $00, $01)
                                    EndIf
                                ElseIf (0.0 < (Float local0\Field29)) Then
                                    local0\Field24 = curvevalue(local0\Field23, local0\Field24, 15.0)
                                    animatenpc(local0, 449.0, 464.0, (local0\Field24 * 6.0), $01)
                                    If ((((452.0 > local21) And (452.0 <= local0\Field14)) Lor ((459.0 > local21) And (459.0 <= local0\Field14))) <> 0) Then
                                        playsoundex(stepsfx($01, $01, rand($00, $07)), camera, local0\Field3, 12.0, 1.0, $00, $00)
                                    EndIf
                                    If (1.0 > distancesquared(local0\Field36, entityx(local0\Field3, $00), local0\Field38, entityz(local0\Field3, $00), 0.0, 0.0)) Then
                                        If (entityvisible(me\Field60, local0\Field3) <> 0) Then
                                            setnpcframe(local0, 18.0, $01)
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                                    animatenpc(local0, 175.0, 297.0, (local0\Field24 * 5.0), $01)
                                EndIf
                                rotateentity(local0\Field3, 0.0, curveangle(vectoryaw((local0\Field36 - entityx(local0\Field3, $00)), 0.0, (local0\Field38 - entityz(local0\Field3, $00))), entityyaw(local0\Field3, $00), (10.0 - (Float selecteddifficulty\Field4))), 0.0, $00)
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                local0\Field29 = (Int ((Float local0\Field29) - fps\Field7[$00]))
                            Else
                                local0\Field10 = 2.0
                            EndIf
                        Case 5.0
                            If (68.0 > local0\Field14) Then
                                animatenpc(local0, 18.0, 68.0, 0.5, $00)
                            Else
                                animatenpc(local0, 464.0, 473.0, 0.5, $00)
                            EndIf
                    End Select
                    If (49.0 > entitydistancesquared(local0\Field3, me\Field60)) Then
                        If ((entityvisible(me\Field60, local0\Field3) And entityinview(local0\Field3, camera)) <> 0) Then
                            giveachievement("939", $01)
                        EndIf
                    EndIf
                    If (((3.0 > local0\Field10) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                        local13 = (entitydistancesquared(local0\Field3, me\Field60) + ((Float (entityvisible(me\Field60, local0\Field3) = $00)) * 2.5))
                        If (((local13 < ((me\Field42 * 1.6) * (me\Field42 * 1.6))) Lor (2.5 > local13)) <> 0) Then
                            If (0.0 = local0\Field12) Then
                                loadnpcsound(local0, (((("SFX\SCP\939\" + (Str (local0\Field5 Mod $03))) + "Attack") + (Str rand($00, $02))) + ".ogg"), $00)
                                local0\Field18 = playsoundex(local0\Field17, camera, local0\Field3, 10.0, 1.0, $01, $00)
                                giveachievement("939", $01)
                                playsound_strict(loadtempsound("SFX\SCP\939\Horror.ogg"), $00)
                                local0\Field12 = 1.0
                            EndIf
                            local0\Field10 = 3.0
                        ElseIf (local13 < ((me\Field42 * 1.9) * (me\Field42 * 1.9))) Then
                            If (((1.0 <> local0\Field10) And (0.0 >= local0\Field28)) <> 0) Then
                                loadnpcsound(local0, (((("SFX\SCP\939\" + (Str (local0\Field5 Mod $03))) + "Alert") + (Str rand($00, $02))) + ".ogg"), $00)
                                local0\Field18 = playsoundex(local0\Field17, camera, local0\Field3, 10.0, 1.0, $01, $00)
                                giveachievement("939", $01)
                                setnpcframe(local0, 175.0, $01)
                                local0\Field28 = 210.0
                            EndIf
                            local0\Field10 = 1.0
                        EndIf
                        local0\Field28 = (local0\Field28 - fps\Field7[$00])
                    EndIf
                    rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $00), 0.0, $01)
                    positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.28), entityz(local0\Field3, $00), $00)
                    rotateentity(local0\Field0, (entitypitch(local0\Field3, $00) - 90.0), entityyaw(local0\Field3, $00), entityroll(local0\Field3, $00), $01)
                EndIf
            Case $04
                If (1.0 = local0\Field26) Then
                    If (channelplaying(local0\Field18) <> 0) Then
                        stopchannel(local0\Field18)
                        local0\Field18 = $00
                    EndIf
                    If (channelplaying(local0\Field20) <> 0) Then
                        stopchannel(local0\Field20)
                        local0\Field20 = $00
                    EndIf
                    local0\Field7 = 0.0
                Else
                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                    Select local0\Field10
                        Case 0.0
                            If (400.0 < local13) Then
                                animatenpc(local0, 451.0, 612.0, 0.2, $01)
                                If ((Float millisecs()) > local0\Field11) Then
                                    For local6 = Each waypoints
                                        If (local6\Field1 = Null) Then
                                            If (16.0 > distancesquared(entityx(local6\Field0, $01), entityx(local0\Field3, $00), entityz(local6\Field0, $01), entityz(local0\Field3, $00), 0.0, 0.0)) Then
                                                positionentity(local0\Field3, entityx(local6\Field0, $01), (entityy(local6\Field0, $01) + (1.0 / 1.28)), entityz(local6\Field0, $01), $00)
                                                resetentity(local0\Field3)
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    local0\Field11 = (Float (millisecs() + $1388))
                                EndIf
                            ElseIf (64.0 > local13) Then
                                local0\Field30 = rnd(1.0, 2.5)
                                local0\Field10 = 1.0
                            EndIf
                        Case 1.0
                            If (451.0 > local0\Field14) Then
                                local15 = wrapangle(curveangle((deltayaw(local0\Field3, me\Field60) - 180.0), ((animtime(local0\Field0) - 2.0) / 1.2445), 15.0), 360.0)
                                setnpcframe(local0, ((local15 * 1.2445) + 2.0), $01)
                            Else
                                animatenpc(local0, 636.0, 646.0, 0.4, $00)
                                If (646.0 = local0\Field14) Then
                                    setnpcframe(local0, 2.0, $01)
                                EndIf
                            EndIf
                            If (rand($2BC, $01) = $01) Then
                                playsoundex(loadtempsound((("SFX\SCP\066\Eric" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field3, 8.0, 1.0, $01, $00)
                            EndIf
                            If (local13 < ((local0\Field30 * local0\Field30) + 1.0)) Then
                                If (entityvisible(me\Field60, local0\Field3) <> 0) Then
                                    giveachievement("066", $01)
                                    local0\Field10 = (Float rand($02, $03))
                                EndIf
                            EndIf
                        Case 2.0
                            If (647.0 > local0\Field14) Then
                                local15 = curveangle(0.0, ((animtime(local0\Field0) - 2.0) / 1.2445), 5.0)
                                If (((5.0 > local15) Lor (355.0 < local15)) <> 0) Then
                                    setnpcframe(local0, 647.0, $01)
                                Else
                                    setnpcframe(local0, ((local15 * 1.2445) + 2.0), $01)
                                EndIf
                            ElseIf (683.0 = local0\Field14) Then
                                If (0.0 = local0\Field11) Then
                                    If (rand($02, $01) = $01) Then
                                        playsoundex(loadtempsound((("SFX\SCP\066\Eric" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field3, 8.0, 1.0, $01, $00)
                                    Else
                                        playsoundex(loadtempsound((("SFX\SCP\066\Notes" + (Str rand($00, $05))) + ".ogg")), camera, local0\Field3, 8.0, 1.0, $00, $00)
                                    EndIf
                                    If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                        Select rand($06, $01)
                                            Case $01
                                                playsound_strict(loadtempsound("SFX\SCP\066\Beethoven.ogg"), $00)
                                                me\Field55 = ((((Float selecteddifficulty\Field4) * 15.0) + 45.0) * 70.0)
                                                me\Field54 = $01
                                                me\Field24 = 10.0
                                            Case $02
                                                local0\Field12 = (Float rand($2BC, $578))
                                            Case $03
                                                For local2 = Each doors
                                                    If (256.0 > entitydistancesquared(local2\Field2, local0\Field3)) Then
                                                        If ((((((local2\Field4 = $00) And (local2\Field14 = $00)) And (local2\Field19 = $00)) And (local2\Field10 <> $05)) And (local2\Field10 <> $04)) <> 0) Then
                                                            openclosedoor(local2, $01, $00)
                                                        EndIf
                                                    EndIf
                                                Next
                                            Case $04
                                                If (playerroom\Field7\Field8 < $02) Then
                                                    local3 = createdecal($01, entityx(local0\Field3, $00), 0.005, entityz(local0\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, 0.3, 1.0, $00, $01, $00, $00, $00)
                                                    entityparent(local3\Field0, playerroom\Field2, $01)
                                                EndIf
                                                me\Field24 = 5.0
                                                playsound_strict(loadtempsound("SFX\Character\BodyFall.ogg"), $00)
                                                If (0.64 > distancesquared(entityx(me\Field60, $00), entityx(local0\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field3, $00), 0.0, 0.0)) Then
                                                    injureplayer(rnd(0.1, 0.3), 0.0, 200.0, 0.0, 0.0)
                                                EndIf
                                            Case $05,$06
                                        End Select
                                    EndIf
                                EndIf
                                local0\Field11 = (local0\Field11 + fps\Field7[$00])
                                If (70.0 < local0\Field11) Then
                                    local0\Field11 = 0.0
                                    local0\Field10 = 3.0
                                EndIf
                            Else
                                local0\Field24 = curvevalue((local0\Field23 * 1.5), local0\Field24, 10.0)
                                pointentity(local0\Field0, me\Field60, 0.0)
                                rotateentity(local0\Field3, 0.0, curveangle((entityyaw(local0\Field0, $00) - 180.0), entityyaw(local0\Field3, $00), 10.0), 0.0, $00)
                                animatenpc(local0, 647.0, 683.0, (local0\Field24 * 25.0), $00)
                                moveentity(local0\Field3, 0.0, 0.0, ((- local0\Field24) * fps\Field7[$00]))
                            EndIf
                        Case 3.0
                            pointentity(local0\Field0, me\Field60, 0.0)
                            local15 = curveangle(((entityyaw(local0\Field0, $00) + local0\Field15) - 180.0), entityyaw(local0\Field3, $00), 10.0)
                            rotateentity(local0\Field3, 0.0, local15, 0.0, $00)
                            local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                            moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                            If (rand($64, $01) = $01) Then
                                local0\Field15 = rnd(-20.0, 20.0)
                            EndIf
                            local0\Field11 = (local0\Field11 + fps\Field7[$00])
                            If (250.0 < local0\Field11) Then
                                animatenpc(local0, 684.0, 647.0, ((- local0\Field24) * 25.0), $00)
                                If (647.0 = local0\Field14) Then
                                    local0\Field11 = 0.0
                                    local0\Field10 = 0.0
                                EndIf
                            Else
                                animatenpc(local0, 684.0, 647.0, ((- local0\Field24) * 25.0), $01)
                            EndIf
                    End Select
                    If (1.0 < local0\Field10) Then
                        If (local0\Field17 = $00) Then
                            local0\Field17 = loadsound_strict("SFX\SCP\066\Rolling.ogg")
                        EndIf
                        If (channelplaying(local0\Field18) = $00) Then
                            local0\Field18 = playsoundex(local0\Field17, camera, local0\Field3, 20.0, 1.0, $00, $00)
                        EndIf
                    EndIf
                    If (0.0 < local0\Field12) Then
                        local0\Field12 = (local0\Field12 - fps\Field7[$00])
                        lightvolume = (templightvolume - (clamp((local0\Field12 / 500.0), 0.01, 0.6) * templightvolume))
                        me\Field28 = max(me\Field28, 130.0)
                        me\Field30 = max(me\Field30, min((local0\Field12 / 1000.0), 1.0))
                    EndIf
                    updatesoundorigin(local0\Field20, camera, local0\Field3, 20.0, 1.0, $00, $01)
                    If (channelplaying(local0\Field20) <> 0) Then
                        me\Field49 = max((5.0 - (sqr(local13) * 300.0)), 0.0)
                    EndIf
                EndIf
                positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.2), entityz(local0\Field3, $00), $00)
                rotateentity(local0\Field0, (entitypitch(local0\Field3, $00) - 90.0), entityyaw(local0\Field3, $00), 0.0, $00)
            Case $0C
                If (-1.0 < local0\Field10) Then
                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                    If ((hidedistance * hidedistance) > local13) Then
                        updatenpcblinking(local0)
                        local21 = local0\Field14
                        If (wi\Field5 = $00) Then
                            If (entityhidden(local0\Field0) = $00) Then
                                hideentity(local0\Field0)
                            EndIf
                            If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                If (((1.0 > local13) And (0.0 >= local0\Field28)) <> 0) Then
                                    Select rand($06, $01)
                                        Case $01
                                            createmsg(getlocalstring("msg", "966_1"), 6.0)
                                        Case $02
                                            createmsg(getlocalstring("msg", "966_2"), 6.0)
                                        Case $03
                                            createmsg(getlocalstring("msg", "966_3"), 6.0)
                                        Case $04
                                            createmsg(getlocalstring("msg", "966_4"), 6.0)
                                        Case $05
                                            createmsg(getlocalstring("msg", "966_5"), 6.0)
                                        Case $06
                                            createmsg(getlocalstring("msg", "966_6"), 6.0)
                                    End Select
                                    local0\Field28 = 1680.0
                                EndIf
                            EndIf
                        Else
                            If (entityvisible(local0\Field3, me\Field60) <> 0) Then
                                giveachievement("966", $01)
                            EndIf
                            If (entityhidden(local0\Field0) <> 0) Then
                                showentity(local0\Field0)
                            EndIf
                        EndIf
                        local0\Field28 = (local0\Field28 - fps\Field7[$00])
                        If (350.0 <= local0\Field12) Then
                            local0\Field10 = max(local0\Field10, 8.0)
                        EndIf
                        If (10.0 > me\Field17) Then
                            local0\Field12 = (local0\Field12 + fps\Field7[$00])
                        ElseIf (350.0 > local0\Field12) Then
                            local0\Field12 = max((local0\Field12 - (fps\Field7[$00] * 0.2)), 0.0)
                        EndIf
                        Select local0\Field10
                            Case 0.0
                                If (557.0 < local0\Field14) Then
                                    animatenpc(local0, 628.0, 652.0, 0.25, $00)
                                    If (651.9 < local0\Field14) Then
                                        setnpcframe(local0, 2.0, $01)
                                    EndIf
                                Else
                                    animatenpc(local0, 2.0, 214.0, 0.25, $00)
                                    If (213.9 < local0\Field14) Then
                                        If (((rand($03, $01) = $01) And (12.0 > local13)) <> 0) Then
                                            local0\Field10 = (Float rand($01, $04))
                                        Else
                                            local0\Field10 = (Float rand($05, $06))
                                        EndIf
                                    EndIf
                                    If (npcseesplayer(local0, ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                        local0\Field10 = (Float rand($04, $01))
                                    EndIf
                                EndIf
                            Case 1.0,2.0
                                animatenpc(local0, 214.0, 257.0, 0.25, $00)
                                If (256.9 < local0\Field14) Then
                                    local0\Field10 = 0.0
                                EndIf
                                If (npcseesplayer(local0, ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                    pointentity(local0\Field3, me\Field60, 0.0)
                                    rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                    If (350.0 > local0\Field12) Then
                                        me\Field49 = (((sin(((Float millisec) / 50.0)) + 1.0) * 200.0) / sqr(local13))
                                        If ((((i_714\Field0 <> $02) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
                                            If (0.0 = i_966\Field1) Then
                                                Select rand($04, $01)
                                                    Case $01
                                                        createmsg(getlocalstring("msg", "966.sleep_1"), 6.0)
                                                    Case $02
                                                        createmsg(getlocalstring("msg", "966.sleep_2"), 6.0)
                                                    Case $03
                                                        createmsg(getlocalstring("msg", "966.sleep_3"), 6.0)
                                                    Case $04
                                                        createmsg(getlocalstring("msg", "966.sleep_4"), 6.0)
                                                End Select
                                            EndIf
                                            i_966\Field1 = (1.0 - ((Float i_714\Field0) * 0.5))
                                            local39 = (Int ((((Float selecteddifficulty\Field4) * 700.0) + 2100.0) / ((Float i_714\Field0) + 1.0)))
                                            i_966\Field0 = max(i_966\Field0, (Float local39))
                                            i_966\Field0 = min(((fps\Field7[$00] * (6.0 - ((Float i_714\Field0) * 2.5))) + i_966\Field0), ((Float local39) * 2.0))
                                        EndIf
                                    EndIf
                                    local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                EndIf
                                If (((228.0 < local0\Field14) And (228.0 >= local21)) <> 0) Then
                                    If (channelplaying(local0\Field18) = $00) Then
                                        local0\Field18 = playsoundex(loadtempsound((("SFX\SCP\966\Echo" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field3, 10.0, 1.0, $01, $00)
                                    EndIf
                                EndIf
                                updatesoundorigin(local0\Field18, camera, local0\Field3, 10.0, 1.0, $01, $01)
                            Case 3.0,4.0
                                If (3.0 = local0\Field10) Then
                                    animatenpc(local0, 258.0, 332.0, 0.25, $00)
                                    If (331.9 < local0\Field14) Then
                                        local0\Field10 = 0.0
                                    EndIf
                                Else
                                    animatenpc(local0, 333.0, 457.0, 0.25, $00)
                                    If (456.9 < local0\Field14) Then
                                        local0\Field10 = 0.0
                                    EndIf
                                EndIf
                                If (npcseesplayer(local0, ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                    pointentity(local0\Field3, me\Field60, 0.0)
                                    rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                    local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                EndIf
                                If (((((271.0 < local0\Field14) And (271.0 >= local21)) Lor ((301.0 < local0\Field14) And (301.0 >= local21))) Lor ((314.0 < local0\Field14) And (314.0 >= local21))) <> 0) Then
                                    If (channelplaying(local0\Field18) = $00) Then
                                        local0\Field18 = playsoundex(loadtempsound((("SFX\SCP\966\Idle" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field3, 10.0, 1.0, $01, $00)
                                    EndIf
                                EndIf
                                updatesoundorigin(local0\Field18, camera, local0\Field3, 10.0, 1.0, $01, $01)
                            Case 5.0,6.0,8.0
                                If (8.0 = local0\Field10) Then
                                    If (npcseesplayer(local0, ((6.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                        pointentity(local0\Field3, me\Field60, 0.0)
                                        rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                        local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                        local0\Field41 = 0.0
                                        local0\Field40 = $00
                                        local0\Field42 = $00
                                        If (0.7225 > local13) Then
                                            local0\Field10 = 9.0
                                        EndIf
                                    ElseIf (0.0 >= local0\Field41) Then
                                        local0\Field40 = findpath(local0, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.1), entityz(me\Field60, $00))
                                        If (local0\Field40 = $01) Then
                                            While (local0\Field39[local0\Field42] = Null)
                                                If (local0\Field42 > $14) Then
                                                    local0\Field42 = $00
                                                    local0\Field40 = $00
                                                    Exit
                                                Else
                                                    local0\Field42 = (local0\Field42 + $01)
                                                EndIf
                                            Wend
                                            If (local0\Field42 < $14) Then
                                                If (((local0\Field39[local0\Field42] <> Null) And (local0\Field39[(local0\Field42 + $01)] <> Null)) <> 0) Then
                                                    If (local0\Field39[local0\Field42]\Field1 = Null) Then
                                                        If ((Abs deltayaw(local0\Field3, local0\Field39[(local0\Field42 + $01)]\Field0)) < (Abs deltayaw(local0\Field3, local0\Field39[local0\Field42]\Field0))) Then
                                                            local0\Field42 = (local0\Field42 + $01)
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                            usedoornpc(local0, $01, $00)
                                        EndIf
                                        local0\Field41 = 700.0
                                    Else
                                        If (((0.81 > local13) And (chs\Field2 = $00)) <> 0) Then
                                            If (entityvisible(local0\Field3, me\Field60) <> 0) Then
                                                local0\Field10 = 9.0
                                            EndIf
                                        EndIf
                                        If (local0\Field40 = $01) Then
                                            If (local0\Field39[local0\Field42] = Null) Then
                                                If (local0\Field42 > $14) Then
                                                    local0\Field42 = $00
                                                    local0\Field40 = $00
                                                Else
                                                    local0\Field42 = (local0\Field42 + $01)
                                                EndIf
                                            Else
                                                pointentity(local0\Field3, local0\Field39[local0\Field42]\Field0, 0.0)
                                                rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                                local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                                usedoornpc(local0, $01, $00)
                                            EndIf
                                            local0\Field41 = max((local0\Field41 - fps\Field7[$00]), 0.0)
                                        Else
                                            local0\Field24 = curvevalue(0.0, local0\Field24, 10.0)
                                            local0\Field41 = max((local0\Field41 - (fps\Field7[$00] * 2.0)), 0.0)
                                        EndIf
                                    EndIf
                                    local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                Else
                                    local39 = $00
                                    If ((Float millisecs()) > local0\Field11) Then
                                        hideentity(local0\Field3)
                                        entitypick(local0\Field3, 1.5)
                                        If (pickedentity() <> $00) Then
                                            local39 = $01
                                        EndIf
                                        showentity(local0\Field3)
                                        local0\Field11 = (Float (millisecs() + $3E8))
                                        If (rand($05, $01) = $01) Then
                                            local0\Field10 = 0.0
                                        EndIf
                                    EndIf
                                    rotateentity(local0\Field3, 0.0, (entityyaw(local0\Field3, $01) + (rnd(80.0, 110.0) * (Float local39))), 0.0, $01)
                                    local0\Field24 = curvevalue((local0\Field23 * 0.6), local0\Field24, 10.0)
                                    moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                    local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                EndIf
                                If (0.005 > local0\Field24) Then
                                    If (557.0 < local0\Field14) Then
                                        animatenpc(local0, 628.0, 652.0, 0.25, $00)
                                        If (651.9 < local0\Field14) Then
                                            setnpcframe(local0, 2.0, $01)
                                        EndIf
                                    Else
                                        animatenpc(local0, 2.0, 214.0, 0.25, $01)
                                    EndIf
                                    If (((650.0 > local21) And (650.0 <= local0\Field14)) <> 0) Then
                                        playsoundex(snd_i\Field56[rand($03, $06)], camera, local0\Field3, 7.0, rnd(0.5, 0.7), $00, $00)
                                    EndIf
                                Else
                                    animatenpc(local0, clamp(animtime(local0\Field0), 557.0, 580.0), 628.0, (local0\Field24 * 25.0), $01)
                                    If ((((581.0 > local21) And (581.0 <= local0\Field14)) Lor ((607.0 > local21) And (607.0 <= local0\Field14))) <> 0) Then
                                        playsoundex(snd_i\Field56[rand($03, $06)], camera, local0\Field3, 7.0, rnd(0.5, 0.7), $00, $00)
                                    EndIf
                                EndIf
                            Case 9.0
                                If (0.0 = me\Field0) Then
                                    local0\Field24 = 0.0
                                    pointentity(local0\Field3, me\Field60, 0.0)
                                    rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                    local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                    If (local0\Field29 = $00) Then
                                        local0\Field18 = playsoundex(loadtempsound((("SFX\SCP\966\Echo" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field3, 10.0, 1.0, $01, $00)
                                        local0\Field29 = $01
                                    EndIf
                                    If (557.0 < local0\Field14) Then
                                        animatenpc(local0, 629.0, 652.0, 0.25, $00)
                                        If (((650.0 > local21) And (650.0 <= local0\Field14)) <> 0) Then
                                            playsoundex(snd_i\Field56[rand($03, $06)], camera, local0\Field3, 7.0, rnd(0.5, 0.7), $00, $00)
                                        EndIf
                                        If (651.9 < local0\Field14) Then
                                            Select rand($03, $01)
                                                Case $01
                                                    setnpcframe(local0, 458.0, $01)
                                                Case $02
                                                    setnpcframe(local0, 488.0, $01)
                                                Case $03
                                                    setnpcframe(local0, 518.0, $01)
                                            End Select
                                        EndIf
                                    ElseIf (487.0 >= local0\Field14) Then
                                        animatenpc(local0, 458.0, 487.0, 0.3, $00)
                                        If (486.9 < local0\Field14) Then
                                            local0\Field29 = $00
                                            local0\Field10 = 8.0
                                        EndIf
                                    ElseIf (517.0 >= local0\Field14) Then
                                        animatenpc(local0, 488.0, 517.0, 0.3, $00)
                                        If (516.9 < local0\Field14) Then
                                            local0\Field29 = $00
                                            local0\Field10 = 8.0
                                        EndIf
                                    ElseIf (556.0 >= local0\Field14) Then
                                        animatenpc(local0, 518.0, 556.0, 0.3, $00)
                                        If (555.9 < local0\Field14) Then
                                            local0\Field29 = $00
                                            local0\Field10 = 8.0
                                        EndIf
                                    EndIf
                                    If (((((470.0 < local0\Field14) And (470.0 >= local21)) Lor ((500.0 < local0\Field14) And (500.0 >= local21))) Lor ((527.0 < local0\Field14) And (527.0 >= local21))) <> 0) Then
                                        If (0.81 > local13) Then
                                            playsound_strict(snd_i\Field51[rand($0B, $0C)], $00)
                                            injureplayer((rnd(0.45, 0.75) * local37), 0.0, 500.0, (0.25 * local37), (0.1 * local37))
                                            me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 1.8)
                                            If (10.0 < me\Field31) Then
                                                msg\Field2 = format(getlocalstring("death", "966"), subjectname, "%s")
                                                kill($01, $01, $00, $01)
                                            EndIf
                                        Else
                                            playsoundex(snd_i\Field48, camera, local0\Field3, 2.5, 1.0, $00, $00)
                                        EndIf
                                    EndIf
                                EndIf
                        End Select
                        positionentity(local0\Field0, entityx(local0\Field3, $01), (entityy(local0\Field3, $01) - 0.2), entityz(local0\Field3, $01), $01)
                        rotateentity(local0\Field0, -90.0, local0\Field15, 0.0, $01)
                    Else
                        If (entityhidden(local0\Field0) = $00) Then
                            hideentity(local0\Field0)
                        EndIf
                        If (rand(($352 - (selecteddifficulty\Field2 * $FA)), $01) = $01) Then
                            teleportcloser(local0)
                            local0\Field12 = 0.0
                            local0\Field10 = 0.0
                        EndIf
                    EndIf
                    If (playerroom\Field7\Field6 = $69) Then
                        local0\Field12 = 0.0
                        local0\Field10 = 0.0
                    EndIf
                EndIf
            Case $10
                local21 = local0\Field14
                If (((0.0 = local0\Field26) And (((hidedistance * 3.0) * (hidedistance * 3.0)) > entitydistancesquared(local0\Field3, me\Field60))) <> 0) Then
                    If (local0\Field13 = $00) Then
                        If (((0.0 = local0\Field10) Lor (2.0 = local0\Field10)) <> 0) Then
                            For local1 = Each npcs
                                If (((local1\Field4 = local0\Field4) And (local1 <> local0)) <> 0) Then
                                    If (((0.0 <> local1\Field10) And (2.0 <> local1\Field10)) <> 0) Then
                                        If (local1\Field13 = $00) Then
                                            local0\Field10 = 1.0
                                            local0\Field11 = 0.0
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                    Select local0\Field10
                        Case 0.0
                            If (local0\Field13 = $00) Then
                                If (0.0 = local0\Field24) Then
                                    If (0.0 = local0\Field28) Then
                                        If ((rnd(1.0, 3.0) * 500.0) > local0\Field11) Then
                                            local0\Field24 = 0.0
                                            local0\Field11 = (local0\Field11 + fps\Field7[$00])
                                        ElseIf (0.0 = local0\Field24) Then
                                            local0\Field24 = (local0\Field24 + 0.0001)
                                        EndIf
                                    ElseIf (1500.0 > local0\Field11) Then
                                        local0\Field24 = 0.0
                                        local0\Field11 = (local0\Field11 + fps\Field7[$00])
                                    Else
                                        If (local0\Field34 <> Null) Then
                                            If (local0\Field34\Field34 <> Null) Then
                                                local0\Field34\Field34 = Null
                                            EndIf
                                            local0\Field34\Field28 = 0.0
                                            local0\Field34\Field15 = (local0\Field34\Field15 + rnd(-45.0, 45.0))
                                            local0\Field34 = Null
                                            local0\Field28 = 0.0
                                            local0\Field15 = (local0\Field15 + rnd(-45.0, 45.0))
                                        EndIf
                                        If (0.0 = local0\Field24) Then
                                            local0\Field24 = (local0\Field24 + 0.0001)
                                        EndIf
                                    EndIf
                                Else
                                    If (local0\Field34 <> Null) Then
                                        local0\Field11 = 0.0
                                    EndIf
                                    If ((rnd(1.0, 3.0) * 10000.0) > local0\Field11) Then
                                        local0\Field24 = curvevalue(local0\Field23, local0\Field24, 10.0)
                                        local0\Field11 = (local0\Field11 + fps\Field7[$00])
                                    Else
                                        local0\Field24 = curvevalue(0.0, local0\Field24, 50.0)
                                    EndIf
                                    rotateentity(local0\Field3, 0.0, curveangle(local0\Field15, entityyaw(local0\Field3, $00), 10.0), 0.0, $00)
                                    If (local0\Field34 = Null) Then
                                        If (rand($C8, $01) = $01) Then
                                            local0\Field15 = (local0\Field15 + rnd(-45.0, 45.0))
                                        EndIf
                                        If (entityhidden(local0\Field3) = $00) Then
                                            hideentity(local0\Field3)
                                        EndIf
                                        entitypick(local0\Field3, 1.5)
                                        If (pickedentity() <> $00) Then
                                            local0\Field15 = (entityyaw(local0\Field3, $00) + rnd(80.0, 110.0))
                                        EndIf
                                        If (entityhidden(local0\Field3) <> 0) Then
                                            showentity(local0\Field3)
                                        EndIf
                                    Else
                                        local0\Field15 = (deltayaw(local0\Field3, local0\Field34\Field3) + entityyaw(local0\Field3, $00))
                                        If (2.25 > entitydistancesquared(local0\Field3, local0\Field34\Field3)) Then
                                            local0\Field24 = 0.0
                                            local0\Field34\Field24 = 0.0
                                            local0\Field28 = 1.0
                                            local0\Field34\Field28 = 1.0
                                            local39 = rand($00, $02)
                                            If (local39 = $00) Then
                                                setnpcframe(local0, 296.0, $01)
                                            ElseIf (local39 = $01) Then
                                                setnpcframe(local0, 856.0, $01)
                                            Else
                                                setnpcframe(local0, 905.0, $01)
                                            EndIf
                                            local39 = rand($00, $02)
                                            If (local39 = $00) Then
                                                setnpcframe(local0\Field34, 296.0, $01)
                                            ElseIf (local39 = $01) Then
                                                setnpcframe(local0\Field34, 856.0, $01)
                                            Else
                                                setnpcframe(local0\Field34, 905.0, $01)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Else
                                rotateentity(local0\Field3, 0.0, curveangle(local0\Field15, entityyaw(local0\Field3, $00), 10.0), 0.0, $00)
                            EndIf
                            If (0.0 = local0\Field24) Then
                                If (((0.0 = local0\Field28) And (local0\Field13 <> $02)) <> 0) Then
                                    animatenpc(local0, 296.0, 320.0, 0.2, $01)
                                ElseIf (((0.0 = local0\Field28) And (local0\Field13 = $02)) <> 0) Then
                                    If (532.5 >= local0\Field14) Then
                                        animatenpc(local0, 509.0, 533.0, 0.2, $00)
                                    ElseIf (((533.5 < local0\Field14) And (600.5 >= local0\Field14)) <> 0) Then
                                        animatenpc(local0, 534.0, 601.0, 0.2, $00)
                                    Else
                                        local39 = rand($00, $01)
                                        If (local39 = $00) Then
                                            setnpcframe(local0, 509.0, $01)
                                        Else
                                            setnpcframe(local0, 534.0, $01)
                                        EndIf
                                    EndIf
                                ElseIf (local0\Field13 = $02) Then
                                    animatenpc(local0, 713.0, 855.0, 0.2, $00)
                                    If (833.5 < local0\Field14) Then
                                        pointentity(local0\Field0, me\Field60, 0.0)
                                        rotateentity(local0\Field3, 0.0, curveangle(local0\Field15, entityyaw(local0\Field3, $00), 10.0), 0.0, $00)
                                    EndIf
                                ElseIf (local0\Field13 = $01) Then
                                    animatenpc(local0, 602.0, 712.0, 0.2, $00)
                                    If (711.5 < local0\Field14) Then
                                        local0\Field28 = 0.0
                                    EndIf
                                ElseIf (319.5 >= local0\Field14) Then
                                    animatenpc(local0, 296.0, 320.0, 0.2, $00)
                                ElseIf (((320.5 < local0\Field14) And (903.5 > local0\Field14)) <> 0) Then
                                    animatenpc(local0, 856.0, 904.0, 0.2, $00)
                                ElseIf (((904.5 < local0\Field14) And (952.5 > local0\Field14)) <> 0) Then
                                    animatenpc(local0, 905.0, 953.0, 0.2, $00)
                                Else
                                    local39 = rand($00, $02)
                                    If (local39 = $00) Then
                                        setnpcframe(local0, 296.0, $01)
                                    ElseIf (local39 = $01) Then
                                        setnpcframe(local0, 856.0, $01)
                                    Else
                                        setnpcframe(local0, 905.0, $01)
                                    EndIf
                                EndIf
                            Else
                                If ((local0\Field5 Mod $02) = $00) Then
                                    animatenpc(local0, 1.0, 62.0, (local0\Field24 * 28.0), $01)
                                Else
                                    animatenpc(local0, 100.0, 167.0, (local0\Field24 * 28.0), $01)
                                EndIf
                                If (local0\Field13 = $00) Then
                                    If (local0\Field34 = Null) Then
                                        If (rand($4B0, $01) = $01) Then
                                            For local1 = Each npcs
                                                If (local1 <> local0) Then
                                                    If (local1\Field4 = local0\Field4) Then
                                                        If (local1\Field34 = Null) Then
                                                            If (local1\Field13 = $00) Then
                                                                If (400.0 > entitydistancesquared(local0\Field3, local1\Field3)) Then
                                                                    local0\Field34 = local1
                                                                    local1\Field34 = local0
                                                                    local0\Field34\Field24 = (local0\Field34\Field24 + 0.0001)
                                                                    Exit
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If (((local0\Field34 = Null) And (local0\Field13 = $00)) <> 0) Then
                                If (rand($1388, $01) = $01) Then
                                    If (channelplaying(local0\Field18) = $00) Then
                                        local13 = entitydistancesquared(local0\Field3, me\Field60)
                                        If (400.0 > local13) Then
                                            loadnpcsound(local0, (("SFX\SCP\1499\Idle" + (Str rand($00, $03))) + ".ogg"), $00)
                                            local0\Field18 = playsoundex(local0\Field17, camera, local0\Field3, 20.0, 1.0, $01, $00)
                                        EndIf
                                    EndIf
                                    local0\Field11 = 0.0
                                    local0\Field10 = 2.0
                                EndIf
                                If ((((local0\Field5 Mod $02) = $00) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                                    If (100.0 > local13) Then
                                        If (entityvisible(local0\Field3, me\Field60) <> 0) Then
                                            If (25.0 > local13) Then
                                                loadnpcsound(local0, "SFX\SCP\1499\Triggered.ogg", $00)
                                                local0\Field18 = playsoundex(local0\Field17, camera, local0\Field3, 20.0, 1.0, $01, $00)
                                                local0\Field11 = 1.0
                                                For local1 = Each npcs
                                                    If (((local1\Field4 = local0\Field4) And (local1 <> local0)) <> 0) Then
                                                        If (local1\Field13 = $00) Then
                                                            local1\Field10 = 1.0
                                                            local1\Field11 = 0.0
                                                        EndIf
                                                    EndIf
                                                Next
                                            Else
                                                local0\Field11 = 0.0
                                            EndIf
                                            setnpcframe(local0, 203.0, $01)
                                            local0\Field10 = 2.0
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (local0\Field13 = $01) Then
                                local13 = entitydistancesquared(local0\Field3, me\Field60)
                                If ((chs\Field2 Lor i_268\Field2) = $00) Then
                                    If (16.0 > local13) Then
                                        If (entityvisible(local0\Field3, me\Field60) <> 0) Then
                                            loadnpcsound(local0, "SFX\SCP\1499\Triggered.ogg", $00)
                                            local0\Field18 = playsoundex(local0\Field17, camera, local0\Field3, 20.0, 1.0, $01, $00)
                                            setnpcframe(local0, 203.0, $01)
                                            local0\Field10 = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Case 1.0
                            If ((chs\Field2 Lor i_268\Field2) <> 0) Then
                                local0\Field10 = 0.0
                            EndIf
                            If (((playerroom\Field7\Field6 = $6A) And (local0\Field13 = $00)) <> 0) Then
                                shouldplay = $12
                            EndIf
                            pointentity(local0\Field0, me\Field60, 0.0)
                            rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 20.0), 0.0, $00)
                            local13 = entitydistancesquared(local0\Field3, me\Field60)
                            If (0.0 = local0\Field11) Then
                                If (local0\Field13 = $01) Then
                                    local0\Field24 = curvevalue((local0\Field23 * 2.0), local0\Field24, 10.0)
                                    If (local0\Field34 <> Null) Then
                                        local0\Field34\Field10 = 1.0
                                    EndIf
                                Else
                                    local0\Field24 = curvevalue((local0\Field23 * 1.75), local0\Field24, 10.0)
                                EndIf
                                If ((local0\Field5 Mod $02) = $00) Then
                                    animatenpc(local0, 1.0, 62.0, (local0\Field24 * 28.0), $01)
                                Else
                                    animatenpc(local0, 100.0, 167.0, (local0\Field24 * 28.0), $01)
                                EndIf
                            EndIf
                            If (0.5625 > local13) Then
                                If (((((((local0\Field5 Mod $02) = $00) Lor (1.0 = local0\Field12)) Lor (local0\Field13 = $01)) Lor (local0\Field13 = $03)) Lor (local0\Field13 = $04)) <> 0) Then
                                    If (1.0 = local0\Field11) Then
                                        setnpcframe(local0, 63.0, $01)
                                    Else
                                        setnpcframe(local0, 168.0, $01)
                                    EndIf
                                    local0\Field11 = (Float rand($01, $02))
                                    local0\Field10 = 3.0
                                Else
                                    local0\Field10 = 4.0
                                EndIf
                            EndIf
                        Case 2.0
                            local0\Field24 = 0.0
                            animatenpc(local0, 203.0, 295.0, 0.1, $00)
                            If (294.0 < local0\Field14) Then
                                local0\Field10 = local0\Field11
                            EndIf
                        Case 3.0
                            local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                            local13 = entitydistancesquared(local0\Field3, me\Field60)
                            If (1.0 = local0\Field11) Then
                                animatenpc(local0, 63.0, 100.0, 0.6, $00)
                                local30 = ((89.0 > local21) And (89.0 <= local0\Field14))
                                If (99.0 <= local0\Field14) Then
                                    local0\Field11 = 0.0
                                    local0\Field10 = 1.0
                                EndIf
                            Else
                                animatenpc(local0, 168.0, 202.0, 0.6, $00)
                                local30 = ((189.0 > local21) And (189.0 <= local0\Field14))
                                If (201.0 <= local0\Field14) Then
                                    local0\Field11 = 0.0
                                    local0\Field10 = 1.0
                                EndIf
                            EndIf
                            If (local30 <> 0) Then
                                If (((0.64 < local13) Lor (60.0 < (Abs deltayaw(local0\Field3, me\Field60)))) <> 0) Then
                                    playsoundex(snd_i\Field48, camera, local0\Field3, 2.5, 1.0, $00, $00)
                                Else
                                    playsound_strict(snd_i\Field51[rand($0B, $0C)], $00)
                                    injureplayer((rnd(0.65, 1.1) * local37), 0.0, 500.0, (0.35 * local37), (0.15 * local37))
                                    me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.5)
                                    If (10.0 < me\Field31) Then
                                        If (playerroom\Field7\Field6 = $6A) Then
                                            msg\Field2 = getlocalstring("death", "1499.dimension")
                                        Else
                                            msg\Field2 = getlocalstring("death", "1499")
                                        EndIf
                                        kill($01, $01, $00, $01)
                                    EndIf
                                EndIf
                            EndIf
                        Case 4.0
                            local13 = entitydistancesquared(local0\Field3, me\Field60)
                            local0\Field24 = curvevalue(0.0, local0\Field24, 5.0)
                            animatenpc(local0, 296.0, 320.0, 0.2, $01)
                            pointentity(local0\Field0, me\Field60, 0.0)
                            rotateentity(local0\Field3, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field3, $00), 20.0), 0.0, $00)
                            If (0.64 < local13) Then
                                local0\Field10 = 1.0
                            EndIf
                    End Select
                    updatesoundorigin(local0\Field18, camera, local0\Field3, 20.0, 1.0, $01, $01)
                    moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                    rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field3, $00) - 180.0), 0.0, $00)
                    positionentity(local0\Field0, entityx(local0\Field3, $00), (entityy(local0\Field3, $00) - 0.2), entityz(local0\Field3, $00), $00)
                    If (entityhidden(local0\Field0) <> 0) Then
                        showentity(local0\Field0)
                    EndIf
                ElseIf (entityhidden(local0\Field0) = $00) Then
                    hideentity(local0\Field0)
                EndIf
            Case $00
                If (local0\Field50 = $00) Then
                    local21 = local0\Field14
                    updatenpcblinking(local0)
                    Select local0\Field10
                        Case 0.0
                            setnpcframe(local0, 11.0, $01)
                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                        Case 1.0
                            animatenpc(local0, 11.0, 29.0, 0.1, $00)
                            If (28.9 < local0\Field14) Then
                                local0\Field10 = 3.0
                            EndIf
                        Case 2.0
                            local0\Field11 = max((local0\Field11 - fps\Field7[$00]), 0.0)
                            If (0.0 < local0\Field11) Then
                                If (local0\Field34 = Null) Then
                                    If (npcseesplayer(local0, ((8.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                        local0\Field11 = 140.0
                                    EndIf
                                    If (entityvisible(local0\Field3, me\Field60) <> 0) Then
                                        pointentity(local0\Field3, me\Field60, 0.0)
                                    EndIf
                                    local13 = entitydistancesquared(local0\Field3, me\Field60)
                                Else
                                    If (npcseesnpc(local0\Field34, local0, 36.0) = $01) Then
                                        local0\Field11 = 140.0
                                    EndIf
                                    If (entityvisible(local0\Field3, local0\Field34\Field3) <> 0) Then
                                        pointentity(local0\Field3, local0\Field34\Field3, 0.0)
                                    EndIf
                                    local13 = entitydistancesquared(local0\Field3, local0\Field34\Field3)
                                EndIf
                                rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                local0\Field24 = curvevalue(local0\Field23, local0\Field24, 20.0)
                                If (9.0 > local13) Then
                                    animatenpc(local0, min(animtime(local0\Field0), 95.0), 125.0, (local0\Field24 * 30.0), $01)
                                Else
                                    animatenpc(local0, min(animtime(local0\Field0), 64.0), 93.0, (local0\Field24 * 30.0), $01)
                                EndIf
                                moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                If (0.49 > local13) Then
                                    setnpcframe(local0, 126.0, $01)
                                    local0\Field10 = 4.0
                                EndIf
                                local0\Field41 = 0.0
                                local0\Field40 = $00
                                local0\Field42 = $00
                                If ((((((65.0 > local21) And (65.0 <= local0\Field14)) Lor ((80.0 > local21) And (80.0 <= local0\Field14))) Lor ((95.0 > local21) And (95.0 <= local0\Field14))) Lor ((113.0 > local21) And (113.0 <= local0\Field14))) <> 0) Then
                                    playsoundex(stepsfx(getstepsound(local0\Field3), $00, rand($00, $07)), camera, local0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                                EndIf
                            Else
                                local0\Field34 = Null
                                local0\Field10 = 3.0
                            EndIf
                        Case 3.0
                            local13 = entitydistancesquared(local0\Field3, me\Field60)
                            If (0.0 >= local0\Field41) Then
                                local16 = 0.0
                                local18 = 0.0
                                local19 = 0.0
                                For local4 = Each rooms
                                    If (((196.0 > entitydistancesquared(local4\Field2, local0\Field3)) And (36.0 < entitydistancesquared(local4\Field2, local0\Field3))) <> 0) Then
                                        local16 = entityx(local4\Field2, $00)
                                        local18 = 0.1
                                        local19 = entityz(local4\Field2, $00)
                                        Exit
                                    EndIf
                                Next
                                If ((((0.0 <> local16) And (0.0 <> local18)) And (0.0 <> local19)) <> 0) Then
                                    local0\Field40 = findpath(local0, local16, local18, local19)
                                EndIf
                                If (local0\Field40 = $01) Then
                                    While (local0\Field39[local0\Field42] = Null)
                                        If (local0\Field42 > $14) Then
                                            local0\Field42 = $00
                                            local0\Field40 = $00
                                            Exit
                                        Else
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    Wend
                                    If (local0\Field42 < $14) Then
                                        If (((local0\Field39[local0\Field42] <> Null) And (local0\Field39[(local0\Field42 + $01)] <> Null)) <> 0) Then
                                            If (local0\Field39[local0\Field42]\Field1 = Null) Then
                                                If ((Abs deltayaw(local0\Field3, local0\Field39[(local0\Field42 + $01)]\Field0)) < (Abs deltayaw(local0\Field3, local0\Field39[local0\Field42]\Field0))) Then
                                                    local0\Field42 = (local0\Field42 + $01)
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                    usedoornpc(local0, $01, $00)
                                EndIf
                                local0\Field41 = (rnd(6.0, 10.0) * 70.0)
                            Else
                                If (0.49 > local13) Then
                                    If ((entityvisible(me\Field60, local0\Field3) And (chs\Field2 = $00)) <> 0) Then
                                        local0\Field11 = 70.0
                                        local0\Field10 = 4.0
                                    EndIf
                                EndIf
                                If (local0\Field40 = $01) Then
                                    If (local0\Field39[local0\Field42] = Null) Then
                                        If (local0\Field42 > $14) Then
                                            local0\Field42 = $00
                                            local0\Field40 = $00
                                        Else
                                            local0\Field42 = (local0\Field42 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field3, local0\Field39[local0\Field42]\Field0, 0.0)
                                        rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                                        local0\Field24 = curvevalue((local0\Field23 * 0.7), local0\Field24, 20.0)
                                        moveentity(local0\Field3, 0.0, 0.0, (local0\Field24 * fps\Field7[$00]))
                                        local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                                        usedoornpc(local0, $01, $00)
                                    EndIf
                                    local0\Field41 = (local0\Field41 - fps\Field7[$00])
                                Else
                                    local0\Field24 = curvevalue(0.0, local0\Field24, 10.0)
                                    local0\Field41 = (local0\Field41 - (fps\Field7[$00] * 2.0))
                                EndIf
                            EndIf
                            If (0.005 > local0\Field24) Then
                                animatenpc(local0, 323.0, 344.0, 0.2, $01)
                            Else
                                animatenpc(local0, 64.0, 93.0, (local0\Field24 * 30.0), $01)
                                If ((((65.0 > local21) And (65.0 <= local0\Field14)) Lor ((80.0 > local21) And (80.0 <= local0\Field14))) <> 0) Then
                                    playsoundex(stepsfx(getstepsound(local0\Field3), $00, rand($00, $07)), camera, local0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                                EndIf
                            EndIf
                            If (local13 > ((hidedistance * 1.5) * (hidedistance * 1.5))) Then
                                If (1050.0 > local0\Field27) Then
                                    local0\Field27 = (local0\Field27 + fps\Field7[$00])
                                ElseIf (rand(($96 - (selecteddifficulty\Field2 * $3C)), $01) = $01) Then
                                    If (playerinreachableroom($00, $00) <> 0) Then
                                        teleportcloser(local0)
                                        local0\Field27 = 0.0
                                    EndIf
                                EndIf
                            Else
                                local0\Field27 = 0.0
                            EndIf
                            If (0.0 >= local0\Field66) Then
                                If (local0\Field34 = Null) Then
                                    If (npcseesplayer(local0, ((8.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                        local0\Field11 = 140.0
                                        local0\Field10 = 2.0
                                    EndIf
                                EndIf
                                For local1 = Each npcs
                                    If (((local1\Field4 = $15) And (local1\Field50 = $00)) <> 0) Then
                                        If (npcseesnpc(local1, local0, 36.0) = $01) Then
                                            local0\Field34 = local1
                                            local0\Field11 = 140.0
                                            local0\Field10 = 2.0
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                                local0\Field66 = (fps\Field7[$00] * 45.0)
                            Else
                                local0\Field66 = (local0\Field66 - fps\Field7[$00])
                            EndIf
                        Case 4.0
                            local0\Field24 = 0.0
                            If (local0\Field34 = Null) Then
                                pointentity(local0\Field3, me\Field60, 0.0)
                            Else
                                pointentity(local0\Field3, local0\Field34\Field3, 0.0)
                            EndIf
                            rotateentity(local0\Field3, 0.0, entityyaw(local0\Field3, $01), 0.0, $01)
                            animatenpc(local0, 126.0, 165.0, 0.6, $00)
                            local0\Field15 = curveangle(entityyaw(local0\Field3, $01), local0\Field15, 20.0)
                            If (((146.0 <= local0\Field14) And (146.0 > local21)) <> 0) Then
                                If (local0\Field34 = Null) Then
                                    If (0.5625 > entitydistancesquared(local0\Field3, me\Field60)) Then
                                        playsound_strict(snd_i\Field51[rand($05, $08)], $00)
                                        injureplayer((rnd(0.4, 0.7) * local37), 1.0, 0.0, (0.225 * local37), (0.0875 * local37))
                                        me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.5)
                                        If (3.0 < me\Field31) Then
                                            msg\Field2 = format(getlocalstring("death", "008"), subjectname, "%s")
                                            kill($01, $01, $00, $01)
                                        EndIf
                                    Else
                                        playsoundex(snd_i\Field48, camera, local0\Field3, 2.5, 1.0, $00, $00)
                                    EndIf
                                ElseIf (0.5625 > entitydistancesquared(local0\Field3, local0\Field34\Field3)) Then
                                    playsoundex(snd_i\Field51[rand($05, $08)], camera, local0\Field34\Field0, 10.0, 1.0, $00, $00)
                                    If (local0\Field34\Field60 > $00) Then
                                        local0\Field34\Field60 = (Int max(((Float local0\Field34\Field60) - rnd(10.0, 20.0)), 0.0))
                                    Else
                                        local0\Field34 = Null
                                        local0\Field10 = 3.0
                                    EndIf
                                Else
                                    playsoundex(snd_i\Field48, camera, local0\Field3, 2.5, 1.0, $00, $00)
                                EndIf
                            ElseIf (164.0 <= local0\Field14) Then
                                local0\Field10 = (me\Field0 + 2.0)
                            EndIf
                            If (local0\Field34 <> Null) Then
                                If (local0\Field34\Field50 <> 0) Then
                                    local0\Field34 = Null
                                    local0\Field10 = 3.0
                                EndIf
                            EndIf
                    End Select
                    If (((1.0 < local0\Field10) And (5.0 > local0\Field10)) <> 0) Then
                        local0\Field18 = loopsoundex(npcsound[$03], local0\Field18, camera, local0\Field3, 10.0, 1.0, $01)
                    EndIf
                    If (local0\Field60 <= $00) Then
                        local0\Field50 = $01
                    EndIf
                Else
                    animatenpc(local0, 344.0, 363.0, 0.5, $00)
                EndIf
                positionentity(local0\Field0, entityx(local0\Field3, $01), (entityy(local0\Field3, $01) - 0.2), entityz(local0\Field3, $01), $01)
                rotateentity(local0\Field0, 0.0, (local0\Field15 - 180.0), 0.0, $01)
        End Select
        local89 = distancesquared(entityx(me\Field60, $00), entityx(local0\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field3, $00), 0.0, 0.0)
        If (local0\Field50 <> 0) Then
            If (1.0 = local0\Field48) Then
                entitytype(local0\Field3, $05, $00)
                local90 = $00
                Select local0\Field4
                    Case $01
                        If (548.9 < local0\Field14) Then
                            local26 = createpivot($00)
                            positionentity(local26, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                            turnentity(local26, 90.0, 0.0, 0.0, $00)
                            If (entitypick(local26, 0.5) <> 0) Then
                                local3 = createdecal($01, entityx(local0\Field3, $00), (pickedy() + 0.005), entityz(local0\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, 0.5, 1.0, $00, $01, $00, $00, $00)
                                local3\Field4 = 0.0005
                                local3\Field5 = 0.2
                                entityparent(local3\Field0, playerroom\Field2, $01)
                            EndIf
                            freeentity(local26)
                            local26 = $00
                            playsoundex(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"), camera, local0\Field3, 4.0, 0.8, $00, $00)
                            hideentity(local0\Field3)
                            hideentity(local0\Field0)
                            local90 = $01
                            local0\Field48 = 0.0
                        EndIf
                    Case $0F
                        hideentity(local0\Field3)
                        hideentity(local0\Field0)
                        local90 = $01
                        local0\Field43 = $01
                        local0\Field48 = 0.0
                    Case $14
                        local0\Field2 = createpivot(findchild(local0\Field0, "Thumb01.R.001"))
                        entityradius(local0\Field2, 0.35, 0.0)
                        entitypickmode(local0\Field2, $01, $00)
                        local90 = $01
                        local0\Field34 = Null
                        local0\Field51 = -1.0
                        local0\Field48 = 0.0
                    Default
                        local90 = $01
                        local0\Field34 = Null
                        local0\Field51 = -1.0
                        local0\Field48 = 0.0
                End Select
                If (local90 <> 0) Then
                    If (channelplaying(local0\Field18) <> 0) Then
                        stopchannel(local0\Field18)
                        local0\Field18 = $00
                    EndIf
                    If (local0\Field17 <> $00) Then
                        freesound_strict(local0\Field17)
                        local0\Field17 = $00
                    EndIf
                    If (channelplaying(local0\Field20) <> 0) Then
                        stopchannel(local0\Field20)
                        local0\Field20 = $00
                    EndIf
                    If (local0\Field19 <> $00) Then
                        freesound_strict(local0\Field19)
                        local0\Field19 = $00
                    EndIf
                EndIf
            EndIf
            If (local0\Field4 = $14) Then
                If (local0\Field2 <> $00) Then
                    If (1.0 > entitydistancesquared(local0\Field2, me\Field60)) Then
                        If (entitypick(camera, 1.0) = local0\Field2) Then
                            handentity = local0\Field2
                            If (mo\Field0 <> 0) Then
                                local92 = rand($05, $01)
                                If (playerroom\Field7\Field1 = $52) Then
                                    local92 = $06
                                EndIf
                                createmsg(getlocalstring("msg", ("pickup.wpn_" + (Str local92))), 6.0)
                                handentity = $00
                                freeentity(local0\Field2)
                                local0\Field2 = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        Else
            If (local0\Field4 = $15) Then
                If (n_i\Field8 = Null) Then
                    n_i\Field8 = local0
                EndIf
                If (((n_i\Field9 = Null) And (local0 <> n_i\Field8)) <> 0) Then
                    n_i\Field9 = local0
                EndIf
            EndIf
            If (((((n_i\Field8 = Null) And (n_i\Field9 = Null)) And (20000.0 < mtftimer)) And (31000.0 > mtftimer)) <> 0) Then
                playannouncement("SFX\Character\MTF\AnnouncLost.ogg", $01)
                mtftimer = 31000.0
            EndIf
            If (((local89 < ((hidedistance * 0.6) * (hidedistance * 0.6))) Lor (local0\Field4 = $10)) <> 0) Then
                If (local0\Field59 = infacility) Then
                    translateentity(local0\Field3, 0.0, local0\Field7, 0.0, $00)
                    local93 = $00
                    local94 = countcollisions(local0\Field3)
                    For local11 = $01 To local94 Step $01
                        If ((entityy(local0\Field3, $00) - 0.01) > collisiony(local0\Field3, local11)) Then
                            local93 = $01
                            Exit
                        EndIf
                    Next
                    If (local93 <> 0) Then
                        local0\Field7 = 0.0
                    ElseIf (shouldentitiesfall <> 0) Then
                        local95 = $00
                        If (local0\Field59 = $00) Then
                            If (playerroom\Field7\Field6 <> $04) Then
                                If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
                                    If (20.0 < entityy(me\Field60, $00)) Then
                                        local95 = $01
                                    EndIf
                                EndIf
                            Else
                                local95 = $01
                            EndIf
                            If (local95 = $00) Then
                                For local4 = Each rooms
                                    If (((((0.0 <> local4\Field26) Lor (0.0 <> local4\Field23)) Lor (0.0 <> local4\Field28)) Lor (0.0 <> local4\Field25)) <> 0) Then
                                        local96 = local4\Field26
                                        local97 = local4\Field23
                                        local98 = local4\Field28
                                        local99 = local4\Field25
                                    Else
                                        local96 = 4.0
                                        local97 = 0.0
                                        local98 = 4.0
                                        local99 = 0.0
                                    EndIf
                                    If ((Abs (local96 - local97)) >= (Abs (entityx(local0\Field3, $00) - entityx(local4\Field2, $00)))) Then
                                        If ((Abs (local98 - local99)) >= (Abs (entityz(local0\Field3, $00) - entityz(local4\Field2, $00)))) Then
                                            If (local4 = playerroom) Then
                                                local95 = $01
                                                Exit
                                            EndIf
                                            If (isroomadjacent(playerroom, local4) <> 0) Then
                                                local95 = $01
                                                Exit
                                            EndIf
                                            For local11 = $00 To $03 Step $01
                                                If (isroomadjacent(playerroom\Field19[local11], local4) <> 0) Then
                                                    local95 = $01
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        Else
                            local95 = $01
                        EndIf
                        If (local95 <> 0) Then
                            local0\Field7 = max((local0\Field7 - ((fps\Field7[$00] * 0.005) * local0\Field48)), (- local0\Field49))
                        ElseIf (0.0 < local0\Field9) Then
                            local0\Field7 = 0.0
                        Else
                            local0\Field7 = max((local0\Field7 - ((fps\Field7[$00] * 0.005) * local0\Field48)), (- local0\Field49))
                        EndIf
                        translateentity(local0\Field3, 0.0, local0\Field7, 0.0, $00)
                    Else
                        local0\Field7 = 0.0
                    EndIf
                Else
                    local0\Field7 = 0.0
                EndIf
            Else
                local0\Field7 = 0.0
            EndIf
        EndIf
        catcherrors((((((("Uncaught: UpdateNPCs(NPC Name: " + chr($22)) + local0\Field47) + chr($22)) + ", ID: ") + (Str local0\Field4)) + ")"))
    Next
    updatecameracheck()
    Return $00
End Function
