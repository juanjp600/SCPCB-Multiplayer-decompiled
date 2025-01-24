Function updatedimension106%()
    Local local0.events
    Local local1.events
    Local local2.rooms
    Local local3.doors
    Local local4%
    Local local5.particles
    Local local6.decals
    Local local7%
    Local local8#
    Local local9#
    Local local10%
    Local local11%
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local19%
    Local local20%
    Local local21%
    Local local23%
    Local local26%
    Local local27%
    For local0 = Each events
        If (local0\Field0 = $48) Then
            If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
                local12 = (sin((local0\Field2 * 1.6)) * 4.0)
                local13 = (cos((local0\Field2 * 0.8)) * 5.0)
                positionentity(local0\Field1\Field11[$09], (entityx(local0\Field1\Field11[$08], $01) + 13.21875), 0.0, entityz(local0\Field1\Field11[$08], $01), $00)
                translateentity(local0\Field1\Field11[$09], local13, 0.0, local12, $01)
                rotateentity(local0\Field1\Field11[$09], 0.0, (local0\Field2 * 2.0), 0.0, $00)
                positionentity(local0\Field1\Field11[$0A], entityx(local0\Field1\Field11[$08], $01), 0.0, (entityz(local0\Field1\Field11[$08], $01) + 13.21875), $00)
                translateentity(local0\Field1\Field11[$0A], local12, 0.0, local13, $01)
                rotateentity(local0\Field1\Field11[$0A], 0.0, (local0\Field2 * 2.0), 0.0, $00)
            EndIf
            If (playerroom = local0\Field1) Then
                showroomsnocoll(local0\Field1)
                playerfallingpickdistance = 0.0
                previsblackout = isblackout
                isblackout = $00
                If (((0.09 > entitydistancesquared(me\Field60, n_i\Field3\Field3)) And (3.0 <> n_i\Field3\Field10)) <> 0) Then
                    n_i\Field3\Field26 = 0.0
                    n_i\Field3\Field10 = 3.0
                    n_i\Field3\Field11 = 0.0
                    n_i\Field3\Field12 = 100000.0
                EndIf
                cansave = $01
                If (5.0 <> local0\Field3) Then
                    shouldplay = $03
                    me\Field31 = ((((Float ((wi\Field5 > $00) Lor (wi\Field9 > $00))) + 1.0) * (fps\Field7[$00] * 0.00005)) + me\Field31)
                    fog\Field0 = 6.0
                    local0\Field2 = (local0\Field2 + fps\Field7[$00])
                    scaleentity(local0\Field1\Field2, (1.0 / 256.0), (((sin((local0\Field2 / 14.0)) * 0.2) + 1.0) * (1.0 / 256.0)), (1.0 / 256.0), $00)
                    For local7 = $09 To $0A Step $01
                        scaleentity(local0\Field1\Field11[local7], (((Abs (sin(((local0\Field2 / 21.0) + ((Float local7) * 45.0))) * 0.1)) + 1.5) * (1.0 / 256.0)), (((sin(((local0\Field2 / 14.0) + ((Float local7) * 20.0))) * 0.1) + 1.0) * (1.0 / 256.0)), (1.0 / 256.0), $01)
                    Next
                ElseIf (selecteddifficulty\Field3 < $02) Then
                    If (keyhit(key\Field9) <> 0) Then
                        Select selecteddifficulty\Field3
                            Case $00
                                playsound_strict(loadtempsound("SFX\General\Save0.ogg"), $00)
                                createhintmsg(getlocalstring("save", "saved"), 6.0, $00)
                            Case $01
                                createhintmsg(getlocalstring("save", "failed.screen"), 6.0, $00)
                        End Select
                    EndIf
                EndIf
                local20 = $00
                local21 = rand($1E, $01)
                Select local0\Field3
                    Case 0.0
                        For local7 = $00 To $07 Step $01
                            scaleentity(local0\Field1\Field11[local7], (((Abs (sin(((local0\Field2 / 21.0) + ((Float local7) * 45.0))) * 0.1)) + 1.0) * (1.0 / 256.0)), (((sin(((local0\Field2 / 14.0) + ((Float local7) * 20.0))) * 0.1) + 1.0) * (1.0 / 256.0)), (1.0 / 256.0), $01)
                        Next
                        If (3.0 > n_i\Field3\Field10) Then
                            local8 = ((local0\Field2 / 10.0) Mod 360.0)
                            positionentity(n_i\Field3\Field3, entityx(local0\Field1\Field2, $00), ((sin(((local0\Field2 / 14.0) + ((Float local7) * 20.0))) * 0.4) + 0.55), entityz(local0\Field1\Field2, $00), $00)
                            rotateentity(n_i\Field3\Field3, 0.0, local8, 0.0, $00)
                            moveentity(n_i\Field3\Field3, 0.0, 0.0, (6.0 - sin((local0\Field2 / 10.0))))
                            animatenpc(n_i\Field3, 55.0, 104.0, 0.5, $01)
                            rotateentity(n_i\Field3\Field3, 0.0, (local8 + 90.0), 0.0, $00)
                            If ((entityhidden(n_i\Field3\Field0) Lor entityhidden(n_i\Field3\Field3)) <> 0) Then
                                showentity(n_i\Field3\Field0)
                                showentity(n_i\Field3\Field3)
                            EndIf
                            resetentity(n_i\Field3\Field3)
                            n_i\Field3\Field26 = 1.0
                            n_i\Field3\Field48 = 0.0
                            n_i\Field3\Field7 = 0.0
                            positionentity(n_i\Field3\Field0, entityx(n_i\Field3\Field3, $00), entityy(n_i\Field3\Field3, $00), entityz(n_i\Field3\Field3, $00), $00)
                            rotateentity(n_i\Field3\Field0, 0.0, entityyaw(n_i\Field3\Field3, $00), 0.0, $00)
                        EndIf
                        If (4550.0 < local0\Field2) Then
                            If (rand($320, $01) = $01) Then
                                playsound_strict(snd_i\Field47[$08], $00)
                                n_i\Field3\Field26 = 0.0
                                n_i\Field3\Field10 = 3.0
                                n_i\Field3\Field11 = 0.0
                                n_i\Field3\Field12 = 100000.0
                                local0\Field2 = 601.0
                            EndIf
                        EndIf
                        If (21.97266 < entitydistancesquared(me\Field60, local0\Field1\Field2)) Then
                            For local1 = Each events
                                If (local1\Field0 = $02) Then
                                    If (1.0 = local1\Field2) Then
                                        local21 = $1F
                                    EndIf
                                    Exit
                                EndIf
                            Next
                            local20 = $01
                        EndIf
                    Case 1.0
                        If (chs\Field0 = $00) Then
                            For local7 = $09 To $0A Step $01
                                local9 = distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field11[local7], $01), entityz(me\Field60, $00), entityz(local0\Field1\Field11[local7], $01), 0.0, 0.0)
                                If (36.0 > local9) Then
                                    If ((1.0 / 6.5536) > local9) Then
                                        local10 = createpivot($00)
                                        positionentity(local10, entityx(local0\Field1\Field11[local7], $01), entityy(me\Field60, $00), entityz(local0\Field1\Field11[local7], $01), $00)
                                        pointentity(local10, me\Field60, 0.0)
                                        rotateentity(local10, 0.0, ((Float (Int (entityyaw(local10, $00) / 90.0))) * 90.0), 0.0, $01)
                                        moveentity(local10, 0.0, 0.0, (1.0 / 2.56))
                                        positionentity(me\Field60, entityx(local10, $00), entityy(me\Field60, $00), entityz(local10, $00), $00)
                                        freeentity(local10)
                                        local10 = $00
                                        If (((chs\Field0 = $00) And (0.0 = me\Field0)) <> 0) Then
                                            msg\Field2 = getlocalstring("death", "106_1")
                                            playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"), $00)
                                            me\Field49 = 3000.0
                                            kill($00, $01, $00, $00)
                                        EndIf
                                    EndIf
                                    local0\Field6 = loopsoundex(local0\Field8, local0\Field6, camera, local0\Field1\Field11[local7], 6.0, 1.0, $00)
                                EndIf
                            Next
                        EndIf
                        local10 = createpivot($00)
                        positionentity(local10, (entityx(local0\Field1\Field11[$08], $01) - 6.0), (local0\Field1\Field4 + (1.0 / 0.512)), (entityz(local0\Field1\Field11[$08], $01) + 2.375), $00)
                        If (25.0 > entitydistancesquared(local10, me\Field60)) Then
                            local0\Field7 = loopsoundex(local0\Field9, local0\Field7, camera, local10, 3.0, 1.0, $00)
                        EndIf
                        freeentity(local10)
                        local10 = $00
                        If (-6.25 > entityy(me\Field60, $00)) Then
                            If (((344.2764 < entitydistancesquared(me\Field60, local0\Field1\Field11[$08])) And (0.0 = me\Field0)) <> 0) Then
                                local21 = rand($0E, $1E)
                                local20 = $01
                            ElseIf (((chs\Field0 = $00) And (0.0 = me\Field0)) <> 0) Then
                                playsound_strict(snd_i\Field47[$08], $00)
                                msg\Field2 = getlocalstring("death", "106_2")
                                me\Field49 = 3000.0
                                kill($00, $01, $00, $00)
                            EndIf
                        EndIf
                        If (61.03516 > entitydistancesquared(me\Field60, local0\Field1\Field11[$11])) Then
                            loadeventsound(local0, "SFX\Room\PocketDimension\Screech.ogg", $00)
                            loadeventsound(local0, "SFX\Room\PocketDimension\Kneel.ogg", $01)
                            local0\Field3 = 2.0
                        EndIf
                    Case 2.0
                        local9 = entitydistancesquared(me\Field60, local0\Field1\Field11[$11])
                        local14 = sqr(local9)
                        If (61.03516 <= local9) Then
                            loadeventsound(local0, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                            loadeventsound(local0, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                            local0\Field3 = 1.0
                        EndIf
                        For local7 = $11 To $12 Step $01
                            If (entityhidden(local0\Field1\Field11[local7]) <> 0) Then
                                showentity(local0\Field1\Field11[local7])
                            EndIf
                        Next
                        me\Field31 = (me\Field31 + (fps\Field7[$00] / 4000.0))
                        me\Field5 = max((me\Field5 - ((fps\Field7[$00] / local14) / 8.0)), -1000.0)
                        me\Field52 = max(me\Field52, (((sin(((Float millisec) / 20.0)) + 1.0) * 15.0) * max(((6.0 - local14) / 6.0), 0.0)))
                        local10 = createpivot($00)
                        positionentity(local10, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                        pointentity(local10, local0\Field1\Field11[$11], 0.0)
                        turnentity(local10, 90.0, 0.0, 0.0, $00)
                        local9 = clamp((15000.0 / (- me\Field5)), 15.0, 500.0)
                        camerapitch = curveangle(entitypitch(local10, $00), (camerapitch + 90.0), local9)
                        camerapitch = (camerapitch - 90.0)
                        rotateentity(me\Field60, entitypitch(me\Field60, $00), curveangle(entityyaw(local10, $00), entityyaw(me\Field60, $00), local9), 0.0, $00)
                        freeentity(local10)
                        local10 = $00
                        If (me\Field39 <> 0) Then
                            me\Field10 = -10.0
                            me\Field39 = $00
                            positionentity(me\Field60, (entityx(local0\Field1\Field11[$08], $01) - 5.25), ((local0\Field1\Field4 + 16.0) + 11.5), (entityz(local0\Field1\Field11[$08], $01) - 4.625), $00)
                            resetentity(me\Field60)
                            loadeventsound(local0, "SFX\Room\PocketDimension\Explosion.ogg", $00)
                            loadeventsound(local0, "SFX\Room\PocketDimension\TrenchPlane.ogg", $01)
                            local0\Field3 = 3.0
                        EndIf
                    Case 3.0
                        shouldplay = $0E
                        decalstep = $01
                        fog\Field0 = 8.0
                        camerafogrange(camera, 0.1, 8.0)
                        For local7 = $11 To $14 Step $01
                            If (local7 > $12) Then
                                If (entityhidden(local0\Field1\Field11[local7]) <> 0) Then
                                    showentity(local0\Field1\Field11[local7])
                                EndIf
                            ElseIf (entityhidden(local0\Field1\Field11[local7]) = $00) Then
                                hideentity(local0\Field1\Field11[local7])
                            EndIf
                        Next
                        If ((entityx(local0\Field1\Field11[$08], $01) - 15.625) > entityx(local0\Field1\Field11[$13], $01)) Then
                            local0\Field7 = playsound_strict(local0\Field9, $00)
                            positionentity(local0\Field1\Field11[$13], (entityx(me\Field60, $01) + 15.625), 28.0, entityz(me\Field60, $01), $00)
                        EndIf
                        moveentity(me\Field60, 0.0, (min((28.0 - entityy(me\Field60, $00)), 0.0) * fps\Field7[$00]), 0.0)
                        local15 = (((- fps\Field7[$00]) * (1.0 / 256.0)) * 4.0)
                        local16 = ((33.0 - ((Abs (entityx(me\Field60, $00) - entityx(local0\Field1\Field11[$13], $00))) * 0.5)) - entityy(local0\Field1\Field11[$13], $00))
                        local17 = (entityz(me\Field60, $01) - entityz(local0\Field1\Field11[$13], $00))
                        translateentity(local0\Field1\Field11[$13], local15, local16, local17, $01)
                        rotateentity(local0\Field1\Field11[$13], (-90.0 - ((entityx(me\Field60, $00) - entityx(local0\Field1\Field11[$13], $00)) * 1.5)), -90.0, 0.0, $01)
                        local23 = $00
                        For local7 = $00 To $02 Step $01
                            Select local7
                                Case $00
                                    local15 = -5.671875
                                    local17 = (1.0 / -6.918919)
                                Case $01
                                    local15 = (1.0 / -2.115702)
                                    local17 = 0.734375
                                Case $02
                                    local15 = 4.777344
                                    local17 = -0.765625
                            End Select
                            local15 = (entityx(local0\Field1\Field11[$08], $01) + local15)
                            local17 = (entityz(local0\Field1\Field11[$08], $01) + local17)
                            If ((1.0 / 1.6384) > distancesquared(entityx(me\Field60, $00), local15, entityz(me\Field60, $00), local17, 0.0, 0.0)) Then
                                local23 = $01
                                Exit
                            EndIf
                        Next
                        local9 = entitydistancesquared(me\Field60, local0\Field1\Field11[$13])
                        local14 = sqr(local9)
                        local0\Field7 = loopsoundex(local0\Field9, local0\Field7, camera, camera, 10.0, (((Float (local23 = $00)) * 0.7) + 0.3), $00)
                        If (((local23 Lor chs\Field2) Lor i_268\Field2) <> 0) Then
                            entitytexture(local0\Field1\Field11[$13], local0\Field1\Field21[$00], $00, $00)
                        ElseIf (((((64.0 > local9) And (i_714\Field0 <> $02)) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
                            local0\Field6 = loopsoundex(local0\Field8, local0\Field6, camera, local0\Field1\Field11[$13], 8.0, 1.0, $00)
                            entitytexture(local0\Field1\Field11[$13], local0\Field1\Field21[$01], $00, $00)
                            If (i_714\Field0 = $01) Then
                                me\Field31 = (((8.0 - local14) * (fps\Field7[$00] * 0.0002)) + me\Field31)
                            Else
                                me\Field31 = (((8.0 - local14) * (fps\Field7[$00] * 0.0004)) + me\Field31)
                            EndIf
                            If (49.0 > local9) Then
                                local10 = createpivot($00)
                                positionentity(local10, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local10, local0\Field1\Field11[$13], 0.0)
                                turnentity(local10, 90.0, 0.0, 0.0, $00)
                                camerapitch = curveangle(entitypitch(local10, $00), (camerapitch + 90.0), 10.0)
                                camerapitch = (camerapitch - 90.0)
                                rotateentity(me\Field60, entitypitch(me\Field60, $00), curveangle(entityyaw(local10, $00), entityyaw(me\Field60, $00), 10.0), 0.0, $00)
                                freeentity(local10)
                                local10 = $00
                            EndIf
                        ElseIf (64.0 > local9) Then
                            entitytexture(local0\Field1\Field11[$13], local0\Field1\Field21[$00], $00, $00)
                            me\Field31 = (((8.0 - local14) * (fps\Field7[$00] * 0.0001)) + me\Field31)
                        EndIf
                        If ((((i_714\Field0 = $02) Lor chs\Field2) Lor i_268\Field2) <> 0) Then
                            me\Field23 = max(((((Float (local23 = $00)) * 3.0) + 3.0) - local14), 0.0)
                        Else
                            me\Field24 = max(((((Float (local23 = $00)) * 4.0) + 4.0) - local14), 0.0)
                        EndIf
                        If (24.5 > entityy(me\Field60, $00)) Then
                            stopchannel(local0\Field6)
                            local0\Field6 = $00
                            stopchannel(local0\Field7)
                            local0\Field7 = $00
                            local21 = $12
                            local20 = $01
                        EndIf
                    Case 4.0
                        local9 = distancesquared(entityx(me\Field60, $00), (entityx(local0\Field1\Field11[$08], $01) + 4.0), entityz(me\Field60, $00), entityz(local0\Field1\Field11[$08], $01), 0.0, 0.0)
                        If (6.25 > local9) Then
                            local14 = sqr(local9)
                            me\Field49 = ((2.5 - local14) * 3000.0)
                            local0\Field7 = loopsoundex(snd_i\Field24[rand($03, $01)], local0\Field7, camera, me\Field60, 2.0, (((2.5 - local14) * (Abs me\Field38)) * 100.0), $00)
                            me\Field38 = curvevalue(0.0, me\Field38, (local14 * 10.0))
                            If ((1.0 / 3.87787) > local9) Then
                                local19 = $00
                                For local2 = Each rooms
                                    If (local2\Field7\Field6 = $36) Then
                                        local19 = $01
                                        giveachievement("pocketdimension", $01)
                                        isblackout = previsblackout
                                        previsblackout = $01
                                        me\Field10 = -10.0
                                        me\Field49 = 1500.0
                                        If (me\Field9 <> 0) Then
                                            local0\Field6 = playsound_strict(loadtempsound("SFX\Room\PocketDimension\Exit.ogg"), $00)
                                            makemeunplayable()
                                        EndIf
                                        If (channelplaying(local0\Field6) = $00) Then
                                            teleportentity(me\Field60, entityx(local2\Field11[$00], $01), 0.6, entityz(local2\Field11[$00], $01), 0.3, $01, 2.0, $00)
                                            teleporttoroom(local2)
                                            n_i\Field3\Field26 = 0.0
                                            n_i\Field3\Field10 = 0.0
                                            n_i\Field3\Field11 = rnd(10000.0, 12000.0)
                                            local6 = createdecal($00, entityx(local2\Field11[$00], $01), entityy(local2\Field11[$00], $01), entityz(local2\Field11[$00], $01), 270.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
                                            entityparent(local6\Field0, local0\Field1\Field2, $01)
                                            teleportentity(local6\Field0, entityx(local2\Field11[$00], $01), (entityy(local2\Field11[$00], $01) + 0.6), entityz(local2\Field11[$00], $01), 0.0, $01, 4.0, $01)
                                            For local1 = Each events
                                                If (local1\Field0 = $0C) Then
                                                    local1\Field4 = 0.0
                                                    updatelever(local1\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                                                    rotateentity(local1\Field1\Field13[$00]\Field0, 80.0, entityyaw(local1\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                                                    Exit
                                                EndIf
                                            Next
                                            If (wi\Field5 > $00) Then
                                                fog\Field0 = 15.0
                                            ElseIf (wi\Field9 > $00) Then
                                                fog\Field0 = 9.0
                                            Else
                                                fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                                            EndIf
                                            me\Field9 = $01
                                            If (local0\Field8 <> $00) Then
                                                freesound_strict(local0\Field8)
                                                local0\Field8 = $00
                                            EndIf
                                            If (local0\Field9 <> $00) Then
                                                freesound_strict(local0\Field9)
                                                local0\Field9 = $00
                                            EndIf
                                            local0\Field2 = 0.0
                                            local0\Field4 = 0.0
                                            local0\Field3 = 0.0
                                        EndIf
                                        Exit
                                    EndIf
                                Next
                                If (local19 = $00) Then
                                    local21 = $13
                                    local20 = $01
                                EndIf
                            EndIf
                        EndIf
                    Case 5.0
                        shouldplay = $01
                        giveachievement("pocketdimension", $01)
                        lightrenderdistance = 64.0
                        updatelightvolume()
                        updatelights(camera)
                        updatedoors()
                        scaleentity(local0\Field1\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        If (((0.0 = local0\Field4) And ((150.0 < local0\Field1\Field14[$00]\Field8) Lor (150.0 < local0\Field1\Field14[$01]\Field8))) <> 0) Then
                            playsound_strict(snd_i\Field47[$0D], $00)
                            me\Field49 = 800.0
                            local0\Field4 = 1.0
                        EndIf
                        If (5.0 > entityy(me\Field60, $00)) Then
                            positionentity(me\Field60, entityx(me\Field60, $01), (entityy(me\Field60, $01) - (1.0 / 0.512)), entityz(me\Field60, $01), $00)
                            resetentity(me\Field60)
                            For local7 = $00 To $01 Step $01
                                local0\Field1\Field14[local7]\Field6 = $00
                                local0\Field1\Field14[local7]\Field8 = 0.0
                            Next
                            s2imaperase(unlockedachievements, "pocketdimension")
                            loadeventsound(local0, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                            loadeventsound(local0, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                            local0\Field2 = 0.0
                            local0\Field4 = 0.0
                            local0\Field3 = 1.0
                        EndIf
                    Case 6.0
                        If (opt\Field0 > $00) Then
                            If (rand($320, $01) = $01) Then
                                local8 = (entityyaw(camera, $01) + rnd(150.0, 210.0))
                                local5 = createparticle($04, (entityx(me\Field60, $00) + (cos(local8) * 7.5)), 0.0, (entityz(me\Field60, $00) + (sin(local8) * 7.5)), 4.0, 0.0, 2500.0)
                                local5\Field4 = 0.01
                                local5\Field11 = 0.0
                                entityblend(local5\Field0, $02)
                                pointentity(local5\Field1, camera, 0.0)
                                turnentity(local5\Field1, 0.0, 145.0, 0.0, $01)
                                turnentity(local5\Field1, rnd(10.0, 20.0), 0.0, 0.0, $01)
                            EndIf
                        EndIf
                        If (12.0 < local0\Field4) Then
                            n_i\Field3\Field26 = 1.0
                            positionentity(n_i\Field3\Field3, entityx(local0\Field1\Field11[(Int local0\Field4)], $01), 0.27, entityz(local0\Field1\Field11[(Int local0\Field4)], $01), $00)
                            pointentity(n_i\Field3\Field3, camera, 0.0)
                            turnentity(n_i\Field3\Field3, 0.0, (sin(((Float millisec) / 20.0)) * 6.0), 0.0, $01)
                            moveentity(n_i\Field3\Field3, 0.0, 0.0, (sin(((Float millisec) / 15.0)) * 0.06))
                            n_i\Field3\Field48 = 0.0
                            n_i\Field3\Field7 = 0.0
                            positionentity(n_i\Field3\Field0, entityx(n_i\Field3\Field3, $00), entityy(n_i\Field3\Field3, $00), entityz(n_i\Field3\Field3, $00), $00)
                            resetentity(n_i\Field3\Field3)
                            rotateentity(n_i\Field3\Field0, 0.0, entityyaw(n_i\Field3\Field3, $00), 0.0, $00)
                            If (((rand($2EE, $01) = $01) And (12.0 < local0\Field4)) <> 0) Then
                                me\Field10 = -10.0
                                playsound_strict(snd_i\Field47[$08], $00)
                                local0\Field4 = (local0\Field4 - 1.0)
                            EndIf
                            If (12.0 = local0\Field4) Then
                                me\Field23 = 1.0
                                n_i\Field3\Field26 = 0.0
                                n_i\Field3\Field10 = 3.0
                                n_i\Field3\Field11 = 0.0
                                n_i\Field3\Field12 = 100000.0
                                positionentity(n_i\Field3\Field3, entityx(local0\Field1\Field11[(Int local0\Field4)], $01), -1.0, entityz(local0\Field1\Field11[(Int local0\Field4)], $01), $00)
                                resetentity(n_i\Field3\Field3)
                            EndIf
                        Else
                            n_i\Field3\Field26 = 0.0
                            n_i\Field3\Field10 = 3.0
                            n_i\Field3\Field11 = 0.0
                            n_i\Field3\Field12 = 100000.0
                        EndIf
                        If (-6.25 > entityy(me\Field60, $00)) Then
                            If ((1.0 / 3.160494) > distancesquared(entityx(local0\Field1\Field11[$10], $01), entityx(me\Field60, $00), entityz(local0\Field1\Field11[$10], $01), entityz(me\Field60, $00), 0.0, 0.0)) Then
                                n_i\Field3\Field10 = 0.0
                                n_i\Field3\Field11 = rnd(22000.0, 27000.0)
                                local21 = rand($0E, $1E)
                                local20 = $01
                            ElseIf (((chs\Field0 = $00) And (0.0 = me\Field0)) <> 0) Then
                                playsound_strict(snd_i\Field47[$08], $00)
                                msg\Field2 = getlocalstring("death", "106_2")
                                me\Field49 = 3000.0
                                kill($00, $01, $00, $00)
                            EndIf
                        EndIf
                    Case 7.0
                        fog\Field0 = 4.0
                        updatedoors()
                        me\Field31 = (me\Field31 + (fps\Field7[$00] * 0.0001))
                        If (206.4161 < distancesquared(entityx(me\Field60, $00), (entityx(local0\Field1\Field11[$08], $01) + 28.13281), entityz(me\Field60, $00), (entityz(local0\Field1\Field11[$08], $01) + 5.867188), 0.0, 0.0)) Then
                            n_i\Field3\Field23 = (n_i\Field3\Field23 * 3.0)
                            For local3 = Each doors
                                If (local3\Field15 = local0\Field1) Then
                                    local3\Field6 = $00
                                    local3\Field8 = 0.0
                                EndIf
                            Next
                            local21 = $20
                            local20 = $01
                        EndIf
                End Select
                If (local20 <> 0) Then
                    me\Field10 = -10.0
                    me\Field49 = 1150.0
                    n_i\Field3\Field26 = 1.0
                    Select local21
                        Case $01,$02,$03,$04,$05
                            playsound_strict(snd_i\Field45[$03], $01)
                            local10 = createpivot($00)
                            positionentity(local10, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00)
                            pointentity(local10, local0\Field1\Field2, 0.0)
                            moveentity(local10, 0.0, 0.0, (entitydistance(me\Field60, local0\Field1\Field2) * 1.9))
                            positionentity(me\Field60, entityx(local10, $00), (entityy(me\Field60, $00) + 0.1), entityz(local10, $00), $00)
                            resetentity(me\Field60)
                            moveentity(local10, 0.0, 0.0, 0.8)
                            positionentity(local0\Field1\Field11[$0A], entityx(local10, $00), 0.1, entityz(local10, $00), $00)
                            rotateentity(local0\Field1\Field11[$0A], 0.0, entityyaw(local10, $00), 0.0, $01)
                            freeentity(local10)
                            local10 = $00
                            local0\Field3 = 0.0
                        Case $06,$07,$08,$09,$0A,$0B,$0C,$0D
                            playsound_strict(snd_i\Field45[$03], $01)
                            positionentity(me\Field60, entityx(local0\Field1\Field11[$08], $01), 0.6, entityz(local0\Field1\Field11[$08], $01), $00)
                            resetentity(me\Field60)
                            loadeventsound(local0, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                            loadeventsound(local0, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                            local0\Field4 = 0.0
                            local0\Field3 = 1.0
                        Case $0E,$0F,$10,$11
                            positionentity(me\Field60, entityx(local0\Field1\Field2, $00), 0.6, entityz(local0\Field1\Field2, $00), $00)
                            resetentity(me\Field60)
                            local0\Field4 = 0.0
                            local0\Field3 = 0.0
                        Case $12
                            positionentity(me\Field60, (entityx(local0\Field1\Field11[$08], $01) - (1.0 / 0.64)), ((local0\Field1\Field4 + 16.0) - 1.1875), entityz(local0\Field1\Field11[$08], $01), $00)
                            resetentity(me\Field60)
                            me\Field50 = 5.0
                            stopchannel(local0\Field6)
                            local0\Field6 = $00
                            stopchannel(local0\Field7)
                            local0\Field7 = $00
                            local0\Field4 = 0.0
                            local0\Field3 = 4.0
                        Case $13,$14,$15,$16,$17
                            local26 = $FFFFFFFF
                            local27 = $00
                            Select rand($07, $01)
                                Case $01
                                    local26 = $26
                                    local27 = $01
                                Case $02
                                    local26 = $08
                                    local27 = $01
                                Case $03
                                    local26 = $0B
                                    local27 = $01
                                Case $04
                                    local26 = $2F
                                Case $05
                                    local26 = $31
                                Case $06
                                    local26 = $3F
                                Case $07
                                    local26 = $43
                            End Select
                            local19 = $00
                            For local2 = Each rooms
                                If (local2\Field7\Field6 = local26) Then
                                    local19 = $01
                                    giveachievement("pocketdimension", $01)
                                    isblackout = previsblackout
                                    previsblackout = $01
                                    me\Field10 = -10.0
                                    If (local2\Field30 <> $00) Then
                                        teleportentity(me\Field60, entityx(local2\Field30, $01), (entityy(local2\Field2, $00) + 0.4), entityz(local2\Field30, $01), 0.3, $01, 2.0, $00)
                                    Else
                                        teleportentity(me\Field60, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) + 0.4), entityz(local2\Field2, $00), 0.3, $01, 2.0, $00)
                                    EndIf
                                    teleporttoroom(local2)
                                    n_i\Field3\Field26 = 0.0
                                    n_i\Field3\Field10 = 0.0
                                    n_i\Field3\Field11 = rnd(10000.0, 12000.0)
                                    If (local27 = $00) Then
                                        For local1 = Each events
                                            If (local1\Field0 = $0C) Then
                                                local1\Field4 = 0.0
                                                updatelever(local1\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                                                rotateentity(local1\Field1\Field13[$00]\Field0, 80.0, entityyaw(local1\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                    If (wi\Field5 > $00) Then
                                        fog\Field0 = 15.0
                                    ElseIf (wi\Field9 > $00) Then
                                        fog\Field0 = 9.0
                                    Else
                                        fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                                    EndIf
                                    If (local0\Field8 <> $00) Then
                                        freesound_strict(local0\Field8)
                                        local0\Field8 = $00
                                    EndIf
                                    If (local0\Field9 <> $00) Then
                                        freesound_strict(local0\Field9)
                                        local0\Field9 = $00
                                    EndIf
                                    local0\Field2 = 0.0
                                    local0\Field4 = 0.0
                                    Exit
                                EndIf
                            Next
                            If (local19 = $00) Then
                                positionentity(me\Field60, entityx(local0\Field1\Field2, $00), 0.6, entityz(local0\Field1\Field2, $00), $00)
                                resetentity(me\Field60)
                            EndIf
                            local0\Field3 = 0.0
                        Case $18,$19,$1A,$1B
                            positionentity(me\Field60, entityx(local0\Field1\Field11[$0C], $01), 0.6, entityz(local0\Field1\Field11[$0C], $01), $00)
                            resetentity(me\Field60)
                            local0\Field4 = 15.0
                            local0\Field3 = 6.0
                        Case $1C,$1D,$1E
                            playsound_strict(snd_i\Field45[$03], $01)
                            positionentity(me\Field60, entityx(local0\Field1\Field11[$08], $01), (local0\Field1\Field4 + 8.9375), entityz(local0\Field1\Field11[$08], $01), $00)
                            resetentity(me\Field60)
                            local0\Field4 = 0.0
                            local0\Field3 = 5.0
                        Case $1F
                            playsound_strict(snd_i\Field45[$03], $01)
                            local11 = rand($15, $18)
                            positionentity(me\Field60, entityx(local0\Field1\Field11[local11], $01), entityy(local0\Field1\Field11[local11], $01), entityz(local0\Field1\Field11[local11], $01), $00)
                            resetentity(me\Field60)
                            n_i\Field3\Field23 = (n_i\Field3\Field23 / 3.0)
                            n_i\Field3\Field26 = 0.0
                            n_i\Field3\Field10 = 3.0
                            n_i\Field3\Field11 = 0.0
                            n_i\Field3\Field12 = 100000.0
                            positionentity(n_i\Field3\Field3, entityx(local0\Field1\Field11[$19], $01), entityy(local0\Field1\Field11[$19], $01), entityz(local0\Field1\Field11[$19], $01), $00)
                            resetentity(n_i\Field3\Field3)
                            local0\Field4 = 0.0
                            local0\Field3 = 7.0
                        Case $20
                            local19 = $00
                            For local2 = Each rooms
                                If (local2\Field7\Field6 = $02) Then
                                    local19 = $01
                                    giveachievement("pocketdimension", $01)
                                    isblackout = previsblackout
                                    previsblackout = $01
                                    me\Field10 = -10.0
                                    me\Field49 = 1500.0
                                    If (me\Field9 <> 0) Then
                                        local0\Field6 = playsound_strict(loadtempsound("SFX\Room\PocketDimension\Exit.ogg"), $00)
                                        makemeunplayable()
                                    EndIf
                                    If (channelplaying(local0\Field6) = $00) Then
                                        teleportentity(me\Field60, entityx(local2\Field30, $01), 0.5, entityz(local2\Field30, $01), 0.3, $01, 2.0, $00)
                                        teleporttoroom(local2)
                                        n_i\Field3\Field26 = 0.0
                                        n_i\Field3\Field10 = 0.0
                                        n_i\Field3\Field11 = 15000.0
                                        For local1 = Each events
                                            If (local1\Field0 = $0C) Then
                                                local1\Field4 = 0.0
                                                updatelever(local1\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                                                rotateentity(local1\Field1\Field13[$00]\Field0, 80.0, entityyaw(local1\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                                                Exit
                                            EndIf
                                        Next
                                        For local1 = Each events
                                            If (local1\Field0 = $02) Then
                                                removeevent(local1)
                                                Exit
                                            EndIf
                                        Next
                                        If (wi\Field5 > $00) Then
                                            fog\Field0 = 15.0
                                        ElseIf (wi\Field9 > $00) Then
                                            fog\Field0 = 9.0
                                        Else
                                            fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                                        EndIf
                                        me\Field9 = $01
                                        If (local0\Field8 <> $00) Then
                                            freesound_strict(local0\Field8)
                                            local0\Field8 = $00
                                        EndIf
                                        If (local0\Field9 <> $00) Then
                                            freesound_strict(local0\Field9)
                                            local0\Field9 = $00
                                        EndIf
                                        local0\Field2 = 0.0
                                        local0\Field4 = 0.0
                                        local0\Field3 = 0.0
                                    EndIf
                                    Exit
                                EndIf
                            Next
                    End Select
                    resetrender()
                EndIf
            Else
                hideroomsnocoll(local0\Field1)
                local0\Field2 = 0.0
                local0\Field4 = 0.0
                local0\Field3 = 0.0
            EndIf
            Exit
        EndIf
    Next
    Return $00
End Function
