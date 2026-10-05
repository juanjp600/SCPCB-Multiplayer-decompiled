Function updateending%(arg0.events)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    Local local7%
    Local local8#
    Local local10%
    Local local11%
    Local local12.events
    Local local13.npcs
    Local local14.npcs
    Local local15%
    Local local16#
    Local local17.emitters
    Local local18.particles
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local24#
    Local local25#
    Local local26#
    Local local27#
    Local local28#
    Local local29#
    Local local30#
    Local local31#
    Local local32#
    Local local33#
    Local local34%
    Local local35.decals
    Local local36#
    Local local37%
    local0 = entityx(collider, $01)
    local1 = entityy(collider, $01)
    local2 = entityz(collider, $01)
    local3 = entityx(camera, $01)
    local4 = entityy(camera, $01)
    local5 = entityz(camera, $01)
    If (arg0 = exit1event) Then
        If (arg0\Field1\Field25[$19] = $00) Then
            showentity(arg0\Field1\Field3)
            For local6 = $00 To $1F Step $01
                If (arg0\Field1\Field24[local6] <> $00) Then
                    entityfx(arg0\Field1\Field24[local6], $09)
                EndIf
            Next
            secondarylighton = 1.0
            local7 = createpivot($00)
            positionentity(local7, entityx(arg0\Field1\Field25[$00], $01), entityy(arg0\Field1\Field25[$00], $01), entityz(arg0\Field1\Field25[$00], $01), $00)
            arg0\Field1\Field25[$19] = loadmesh_strict("GFX\map\exit1terrain.b3d", arg0\Field1\Field3)
            scaleentity(arg0\Field1\Field25[$19], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
            rotateentity(arg0\Field1\Field25[$19], 0.0, (Float arg0\Field1\Field7), 0.0, $01)
            positionentity(arg0\Field1\Field25[$19], entityx(local7, $00), entityy(local7, $00), entityz(local7, $00), $01)
            freeentity(local7)
            arg0\Field1\Field32[$00] = createnpc($07, arg0\Field1\Field4, 100.0, arg0\Field1\Field6)
            arg0\Field1\Field32[$00]\Field9 = 1.0
            arg0\Field1\Field32[$01] = createnpc($03, entityx(arg0\Field1\Field25[$04], $01), (entityy(arg0\Field1\Field25[$04], $01) + 0.2), entityz(arg0\Field1\Field25[$04], $01))
            arg0\Field1\Field32[$01]\Field9 = 0.0
            arg0\Field1\Field32[$01]\Field10 = 10.0
            arg0\Field2 = 1.0
        Else
            If (((arg0\Field1\Field32[$02] = Null) And (selectedending = "")) <> 0) Then
                If (2.0 = arg0\Field1\Field32[$00]\Field9) Then
                    If (playerroom = arg0\Field1) Then
                        shouldplay = $06
                    EndIf
                Else
                    arg0\Field3 = ((arg0\Field3 + fpsfactor) Mod 3600.0)
                    positionentity(arg0\Field1\Field32[$00]\Field4, (entityx(arg0\Field1\Field3, $01) + ((cos((arg0\Field3 / 10.0)) * 6000.0) * (1.0 / 256.0))), 54.6875, (entityz(arg0\Field1\Field3, $01) + ((sin((arg0\Field3 / 10.0)) * 6000.0) * (1.0 / 256.0))), $00)
                    rotateentity(arg0\Field1\Field32[$00]\Field4, 7.0, (arg0\Field3 / 10.0), 20.0, $00)
                    If (playerroom = arg0\Field1) Then
                        shouldplay = $05
                    EndIf
                EndIf
                If ((1.0 / 0.64) > entitydistancesquared(arg0\Field13, arg0\Field1\Field25[$0A])) Then
                    arg0\Field2 = 2.0
                    arg0\Field1\Field29[$02]\Field5 = $00
                    arg0\Field1\Field29[$02]\Field4 = $06
                    arg0\Field1\Field29[$03]\Field5 = $00
                    arg0\Field1\Field29[$03]\Field4 = $06
                    arg0\Field1\Field32[$02] = createnpc($07, entityx(arg0\Field1\Field25[$09], $01), (entityy(arg0\Field1\Field25[$09], $01) + 0.5), entityz(arg0\Field1\Field25[$09], $01))
                    arg0\Field1\Field32[$02]\Field59 = $00
                    arg0\Field1\Field32[$02]\Field9 = 3.0
                    arg0\Field1\Field32[$03] = createnpc($07, entityx(arg0\Field1\Field25[$07], $01), (entityy(arg0\Field1\Field25[$07], $01) - 2.0), entityz(arg0\Field1\Field25[$07], $01))
                    arg0\Field1\Field32[$03]\Field59 = $00
                    arg0\Field1\Field32[$03]\Field9 = 3.0
                    arg0\Field1\Field32[$00]\Field9 = 3.0
                    playannouncement("SFX\Ending\GateB\682Battle.ogg", $00, $01)
                EndIf
            Else
                If (playerroom = arg0\Field1) Then
                    shouldplay = $06
                EndIf
                arg0\Field2 = (arg0\Field2 + fpsfactor)
                If (2800.0 > arg0\Field2) Then
                    arg0\Field1\Field32[$00]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs()) / 25.0)) * 3.0))
                    arg0\Field1\Field32[$00]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 85.0))) + 9.0)
                    arg0\Field1\Field32[$00]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 25.0)) * 3.0))
                    arg0\Field1\Field32[$02]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs()) / 23.0)) * 3.0))
                    arg0\Field1\Field32[$02]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 83.0))) + 5.0)
                    arg0\Field1\Field32[$02]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 23.0)) * 3.0))
                    If (3.0 = arg0\Field1\Field32[$03]\Field9) Then
                        arg0\Field1\Field32[$03]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs()) / 20.0)) * 3.0))
                        arg0\Field1\Field32[$03]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 80.0))) + 3.5)
                        arg0\Field1\Field32[$03]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 20.0)) * 3.0))
                    EndIf
                EndIf
            EndIf
            local8 = (arg0\Field2 * (1.0 / 70.00007))
            If (((0.6 < local8) And (42.2 > local8)) <> 0) Then
                Select $01
                    Case (0.7 > local8),((3.2 < local8) And (3.3 > local8)),((6.1 < local8) And (6.2 > local8)),((10.8 < local8) And (10.9 > local8)),(42.0 < local8)
                        camerashake = 0.5
                    Case (((12.1 < local8) And (12.3 > local8)) Or ((39.5 < local8) And (39.8 > local8)))
                        camerashake = 1.0
                    Case ((13.3 < local8) And (13.5 > local8))
                        camerashake = 1.5
                    Case ((16.5 < local8) And (18.5 > local8))
                        camerashake = 3.0
                    Case (((21.5 < local8) And (24.0 > local8)) Or ((25.5 < local8) And (27.0 > local8)))
                        camerashake = 2.0
                    Case ((31.0 < local8) And (31.5 > local8))
                        camerashake = 0.5
                    Case ((35.0 < local8) And (36.5 > local8))
                        camerashake = 1.5
                        If (2450.0 >= (arg0\Field2 - fpsfactor)) Then
                            arg0\Field5 = streamsound_strict("SFX\Ending\GateB\DetonatingAlphaWarheads.ogg", sfxvolume, $00)
                            arg0\Field9 = $01
                        EndIf
                End Select
                If (42.0 < local8) Then
                    local10 = arg0\Field1\Field25[$13]
                    arg0\Field1\Field32[$00]\Field33 = (entityx(local10, $01) + 4.0)
                    arg0\Field1\Field32[$00]\Field34 = (entityy(local10, $01) + 4.0)
                    arg0\Field1\Field32[$00]\Field35 = (entityz(local10, $01) + 4.0)
                    arg0\Field1\Field32[$02]\Field33 = entityx(local10, $01)
                    arg0\Field1\Field32[$02]\Field34 = entityy(local10, $01)
                    arg0\Field1\Field32[$02]\Field35 = entityz(local10, $01)
                EndIf
            EndIf
            If (45.0 <= local8) Then
                If (75.0 > local8) Then
                    If (arg0\Field6 = $00) Then
                        arg0\Field6 = streamsound_strict("SFX\Ending\GateB\Siren.ogg", sfxvolume, $02)
                        arg0\Field10 = $01
                    EndIf
                ElseIf (selectedending = "") Then
                    shouldplay = $42
                    stopstream_strict(arg0\Field5)
                    stopstream_strict(arg0\Field6)
                    local11 = $01
                    For local12 = Each events
                        If (local12\Field0 = "room2nuke") Then
                            local11 = (Int local12\Field2)
                            Exit
                        EndIf
                    Next
                    If (local11 = $01) Then
                        explosiontimer = max(explosiontimer, 0.1)
                        selectedending = "B2"
                    Else
                        playannouncement("SFX\Ending\GateB\AlphaWarheadsFail.ogg", $00, $01)
                        For local6 = $00 To $01 Step $01
                            local13 = createnpc($08, (entityx(arg0\Field1\Field25[$12], $01) + ((Float local6) * 0.4)), (entityy(arg0\Field1\Field25[$12], $01) + 0.29), (entityz(arg0\Field1\Field25[$12], $01) + ((Float local6) * 0.4)))
                        Next
                        local13 = createnpc($08, entityx(arg0\Field1\Field29[$02]\Field0, $01), (entityy(arg0\Field1\Field29[$02]\Field0, $01) + 0.29), ((entityz(arg0\Field1\Field29[$02]\Field0, $01) + entityz(arg0\Field1\Field29[$03]\Field0, $01)) / 2.0))
                        For local13 = Each npcs
                            If (local13\Field5 = $08) Then
                                local13\Field26 = (Int (rnd(30.0, 35.0) * 70.0))
                                local13\Field9 = 3.0
                                local13\Field10 = 10.0
                                local13\Field33 = entityx(arg0\Field13, $00)
                                local13\Field34 = entityy(arg0\Field13, $00)
                                local13\Field35 = entityz(arg0\Field13, $00)
                            EndIf
                        Next
                        arg0\Field2 = 5950.0
                        selectedending = "B3"
                    EndIf
                ElseIf (selectedending = "B3") Then
                    arg0\Field1\Field32[$00]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs()) / 25.0)) * 3.0))
                    arg0\Field1\Field32[$00]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 85.0))) + 9.0)
                    arg0\Field1\Field32[$00]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 25.0)) * 3.0))
                    arg0\Field1\Field32[$02]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs()) / 23.0)) * 3.0))
                    arg0\Field1\Field32[$02]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 83.0))) + 5.0)
                    arg0\Field1\Field32[$02]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 23.0)) * 3.0))
                    arg0\Field1\Field29[$05]\Field5 = $01
                    If (0.0 = arg0\Field4) Then
                        For local13 = Each npcs
                            If (local13\Field5 = $08) Then
                                If (5.0 = local13\Field9) Then
                                    local13\Field9 = 3.0
                                    local13\Field37 = findpath(local13, entityx(arg0\Field13, $00), entityy(arg0\Field13, $00), entityz(arg0\Field13, $00))
                                    local13\Field38 = (Float (rand($0F, $14) * $46))
                                    local13\Field26 = $5208
                                EndIf
                                If (9.0 > entitydistancesquared(local13\Field4, arg0\Field13)) Then
                                    local13\Field9 = 5.0
                                    local13\Field37 = $00
                                    local13\Field38 = 0.0
                                    local13\Field22 = 0.0
                                EndIf
                            EndIf
                        Next
                    EndIf
                    For local13 = Each npcs
                        If (local13\Field5 = $08) Then
                            If (((5.0 = local13\Field9) And (9.0 > entitydistancesquared(local13\Field4, arg0\Field13))) <> 0) Then
                                If (0.0 = arg0\Field4) Then
                                    playsound_strict(loadtempsound("SFX\Ending\GateB\PlayerDetect.ogg"))
                                    arg0\Field4 = (arg0\Field4 + fpsfactor)
                                    For local14 = Each npcs
                                        If (local14\Field5 = local13\Field5) Then
                                            local14\Field9 = 5.0
                                            local14\Field37 = $00
                                            local14\Field38 = 0.0
                                            local14\Field22 = 0.0
                                        EndIf
                                    Next
                                    Exit
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (((0.0 < arg0\Field4) And (500.0 >= arg0\Field4)) <> 0) Then
                        arg0\Field4 = (arg0\Field4 + fpsfactor)
                        unabletomove = $01
                        For local13 = Each npcs
                            If (local13\Field5 = $08) Then
                                local13\Field33 = entityx(arg0\Field13, $00)
                                local13\Field34 = entityy(arg0\Field13, $00)
                                local13\Field35 = entityz(arg0\Field13, $00)
                                local13\Field54 = "spine"
                                local13\Field52 = $01
                                local13\Field53 = $01
                                local13\Field8 = $00
                                local13\Field44 = 0.0
                            EndIf
                        Next
                    ElseIf (500.0 < arg0\Field4) Then
                        local15 = loadsprite("GFX\blooddrop1.png", $03, $00)
                        entityfx(local15, $0B)
                        scalesprite(local15, 1.5, 1.5)
                        shouldplay = $00
                        currspeed = 0.0
                        playsound_strict(loadtempsound("SFX\Ending\GateB\Gunshot.ogg"))
                        godmode = $00
                        noclip = $00
                        killtimer = -0.1
                        deathmsg = ""
                        kill("was killed", $00)
                        blinktimer = -10.0
                        For local13 = Each npcs
                            If (local13\Field5 = $08) Then
                                removenpc(local13, $00)
                            EndIf
                        Next
                        removeevent(arg0)
                        Return $00
                    EndIf
                EndIf
            EndIf
            If (1855.0 < arg0\Field2) Then
                If (arg0\Field1\Field25[$0C] = $00) Then
                    arg0\Field1\Field25[$0C] = loadmesh_strict("GFX\NPCs\682arm.b3d", $00)
                    scaleentity(arg0\Field1\Field25[$0C], 0.15, 0.15, 0.15, $00)
                    local11 = (Int ((min((((entitydistance(arg0\Field1\Field32[$03]\Field4, arg0\Field13) / (1.0 / 256.0)) - 3000.0) / 4.0), 1000.0) + 12192.0) * (1.0 / 256.0)))
                    positionentity(arg0\Field1\Field25[$0C], entityx(arg0\Field1\Field32[$03]\Field4, $00), 47.625, entityz(arg0\Field1\Field32[$03]\Field4, $00), $00)
                    rotateentity(arg0\Field1\Field25[$0C], 0.0, ((Float arg0\Field1\Field7) + rnd(-10.0, 10.0)), 0.0, $01)
                    turnentity(arg0\Field1\Field25[$0C], 0.0, 0.0, 180.0, $00)
                ElseIf (340.0 > wrapangle(entityroll(arg0\Field1\Field25[$0C], $00))) Then
                    local16 = wrapangle(entityroll(arg0\Field1\Field25[$0C], $00))
                    turnentity(arg0\Field1\Field25[$0C], 0.0, 0.0, ((((Abs sin(local16)) * 2.0) + 5.0) * fpsfactor), $00)
                    If (((270.0 > local16) And (270.0 <= wrapangle(entityroll(arg0\Field1\Field25[$0C], $00)))) <> 0) Then
                        playsound_strict(loadtempsound("SFX\Character\Apache\Crash1.ogg"))
                        arg0\Field1\Field32[$03]\Field9 = 4.0
                        arg0\Field1\Field32[$03]\Field10 = 1.0
                        arg0\Field1\Field32[$03]\Field33 = entityx(arg0\Field1\Field25[$07], $01)
                        arg0\Field1\Field32[$03]\Field34 = (entityy(arg0\Field1\Field25[$07], $01) - 2.5)
                        arg0\Field1\Field32[$03]\Field35 = entityz(arg0\Field1\Field25[$07], $01)
                        local17 = createemitter(entityx(arg0\Field1\Field32[$03]\Field4, $00), entityy(arg0\Field1\Field32[$03]\Field4, $00), entityz(arg0\Field1\Field32[$03]\Field4, $00), $00, 0.0, 0.0, 0.0, 0.0)
                        local17\Field8 = arg0\Field1
                        local17\Field14 = 25.0
                        local17\Field4 = -0.18
                        local17\Field5 = $12C
                        local17\Field15 = rnd(0.007, 0.012)
                        local17\Field16 = -0.001
                        local17\Field6 = $00
                        turnentity(local17\Field0, (Float (($14 * local6) + $FFFFFFB0)), 0.0, 0.0, $00)
                        entityparent(local17\Field0, arg0\Field1\Field32[$03]\Field4, $01)
                        initroomforemitter(local17)
                        If (particleamount > $00) Then
                            For local6 = $00 To (((particleamount - $01) Shl $02) + $03) Step $01
                                local18 = createparticle(entityx(arg0\Field1\Field32[$03]\Field4, $00), entityy(arg0\Field1\Field32[$03]\Field4, $00), entityz(arg0\Field1\Field32[$03]\Field4, $00), $00, rnd(0.5, 1.0), -0.1, $C8, 1.0, $00)
                                local18\Field6 = 0.01
                                local18\Field13 = 0.01
                                local18\Field3 = 1.0
                                local18\Field12 = -0.005
                                rotateentity(local18\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                                moveentity(local18\Field1, 0.0, 0.0, 0.3)
                            Next
                            For local6 = $00 To (((particleamount - $01) * $06) + $06) Step $01
                                local18 = createparticle(entityx(arg0\Field1\Field32[$03]\Field4, $00), entityy(arg0\Field1\Field32[$03]\Field4, $00), entityz(arg0\Field1\Field32[$03]\Field4, $00), $00, 0.02, 0.003, $C8, 1.0, $00)
                                local18\Field6 = 0.04
                                local18\Field3 = 1.0
                                local18\Field12 = -0.005
                                rotateentity(local18\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                            Next
                        EndIf
                    EndIf
                Else
                    hideentity(arg0\Field1\Field25[$0C])
                EndIf
            EndIf
        EndIf
        If (playerroom = arg0\Field1) Then
            If (4.0625 < local1) Then
                hideentity(fog)
                camerarange(camera, 0.02, 60.0)
                camerafogrange(camera, 1.0, sky_fogdist[$00])
                camerafogmode(camera, $01)
                tformvector(0.0, 0.0, 1.0, collider, $00)
                local19 = ((tformedz() + 1.0) * 0.5)
                local20 = ((local19 * 70.0) + 175.0)
                local21 = ((local19 * 55.0) + 195.0)
                local22 = ((local19 * 35.0) + 220.0)
                camerafogcolor(landscapecamera, local20, local21, local22)
                camerafogcolor(camera, local20, local21, local22)
                ambientlight(160.0, 160.0, 160.0)
                If (550.0 >= entitydistancesquared(collider, arg0\Field1\Field29[$01]\Field0)) Then
                    local23 = entityx(arg0\Field1\Field25[$1C], $01)
                    local24 = entityy(arg0\Field1\Field25[$1C], $01)
                    local25 = entityz(arg0\Field1\Field25[$1C], $01)
                ElseIf (21.0 >= entitydistancesquared(collider, arg0\Field1\Field29[$05]\Field0)) Then
                    local23 = entityx(arg0\Field1\Field25[$1D], $01)
                    local24 = entityy(arg0\Field1\Field25[$1D], $01)
                    local25 = entityz(arg0\Field1\Field25[$1D], $01)
                Else
                    local23 = entityx(camera, $01)
                    local24 = entityy(camera, $01)
                    local25 = entityz(camera, $01)
                EndIf
                If (particleamount > $00) Then
                    local26 = ((Float arg0\Field1\Field7) + 90.0)
                    For local6 = $01 To $03 Step $01
                        local18 = createparticle((rnd(-8.0, 8.0) + local23), (rnd(-0.5, 2.5) + local24), (rnd(-8.0, 8.0) + local25), $09, rnd(0.004, 0.012), 0.0, $78, 1.0, $01)
                        local18\Field6 = rnd(0.04, 0.08)
                        local18\Field13 = -0.00005
                        local27 = rnd(-25.0, 25.0)
                        If (rand($00, $0A) = $0A) Then
                            local27 = ((Float rand($FFFFFFFF, $01)) * local27)
                        Else
                            local27 = 0.0
                        EndIf
                        rotateentity(local18\Field1, rnd(5.0, 15.0), (local26 + local27), 0.0, $00)
                    Next
                EndIf
                hidedistance = 60.0
                secondarylighton = 1.0
                showentity(sky[$00])
            ElseIf (playerroom\Field8\Field11 <> "gatea") Then
                If (overlaysenabled <> 0) Then
                    showentity(fog)
                EndIf
                ambientlight(120.0, 120.0, 120.0)
                camerafogmode(camera, $01)
                camerafogrange(camera, camerafognear, camerafogfar)
                If (sky[$00] <> $00) Then
                    hideentity(sky[$00])
                EndIf
            EndIf
        EndIf
        If (1.0 <> arg0\Field1\Field32[$01]\Field9) Then
            If (((225.0 > entitydistancesquared(arg0\Field1\Field32[$01]\Field4, arg0\Field13)) Or entityvisible(arg0\Field1\Field32[$00]\Field4, arg0\Field13)) <> 0) Then
                arg0\Field1\Field32[$01]\Field9 = 1.0
                arg0\Field1\Field32[$01]\Field11 = 1.0
            EndIf
        EndIf
        If (((79.2 > entitydistancesquared(arg0\Field1\Field32[$01]\Field4, arg0\Field13)) Or (285.6 > entitydistancesquared(arg0\Field1\Field25[$05], arg0\Field13))) <> 0) Then
            arg0\Field1\Field32[$01]\Field11 = 0.0
        Else
            arg0\Field1\Field32[$01]\Field11 = 1.0
        EndIf
        showentity(arg0\Field1\Field3)
    ElseIf (arg0 = gateaevent) Then
        arg0\Field24 = $00
        showentity(arg0\Field1\Field3)
        If (arg0\Field1\Field25[$00] = $00) Then
            rotateentity(sky[$00], 0.0, (Float arg0\Field1\Field7), 0.0, $00)
            arg0\Field1\Field25[$00] = loadmesh_strict("GFX\MAP\gateatunnel.b3d", $00)
            positionentity(arg0\Field1\Field25[$00], entityx(arg0\Field1\Field3, $01), entityy(arg0\Field1\Field3, $01), entityz(arg0\Field1\Field3, $01), $00)
            scaleentity(arg0\Field1\Field25[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitytype(arg0\Field1\Field25[$00], $01, $00)
            entitypickmode(arg0\Field1\Field25[$00], $02, $01)
            entityparent(arg0\Field1\Field25[$00], arg0\Field1\Field3, $01)
            For local6 = $00 To arg0\Field1\Field18 Step $01
                If (arg0\Field1\Field24[local6] <> $00) Then
                    entityfx(arg0\Field1\Field24[local6], $09)
                EndIf
            Next
            secondarylighton = 1.0
            For local6 = $02 To $04 Step $01
                arg0\Field1\Field32[local6] = createnpc($07, arg0\Field1\Field4, (arg0\Field1\Field5 + 11.0), arg0\Field1\Field6)
                arg0\Field1\Field32[local6]\Field9 = (Float (contained106 = $00))
                arg0\Field1\Field32[local6]\Field59 = $00
            Next
            For local6 = $00 To $01 Step $01
                arg0\Field1\Field32[local6] = createnpc($03, entityx(arg0\Field1\Field25[(local6 + $05)], $01), entityy(arg0\Field1\Field25[(local6 + $05)], $01), entityz(arg0\Field1\Field25[(local6 + $05)], $01))
                arg0\Field1\Field32[local6]\Field9 = 0.0
                arg0\Field1\Field32[local6]\Field59 = $00
                pointentity(arg0\Field1\Field32[local6]\Field4, arg0\Field1\Field25[$03], 0.0)
            Next
            For local6 = $07 To $08 Step $01
                arg0\Field1\Field32[local6] = createnpc($08, (entityx(arg0\Field1\Field25[local6], $01) + 0.8), entityy(arg0\Field1\Field25[local6], $01), (entityz(arg0\Field1\Field25[local6], $01) + 0.8))
                arg0\Field1\Field32[local6]\Field9 = 5.0
                arg0\Field1\Field32[local6]\Field12 = $01
                arg0\Field1\Field32[local6]\Field59 = $00
                pointentity(arg0\Field1\Field32[local6]\Field4, arg0\Field1\Field25[$03], 0.0)
            Next
            For local6 = $05 To $06 Step $01
                arg0\Field1\Field32[local6] = createnpc($08, entityx(arg0\Field1\Field25[(local6 + $02)], $01), entityy(arg0\Field1\Field25[(local6 + $02)], $01), entityz(arg0\Field1\Field25[(local6 + $02)], $01))
                arg0\Field1\Field32[local6]\Field9 = 5.0
                arg0\Field1\Field32[local6]\Field12 = $01
                arg0\Field1\Field32[local6]\Field59 = $00
                pointentity(arg0\Field1\Field32[local6]\Field4, arg0\Field1\Field25[$03], 0.0)
            Next
            If (contained106 <> 0) Then
                arg0\Field1\Field29[$02]\Field4 = $01
                positionentity(arg0\Field1\Field32[$05]\Field4, (entityx(arg0\Field1\Field25[$0F], $01) + ((Float (local6 - $06)) * 0.2)), entityy(arg0\Field1\Field25[$0F], $01), (entityz(arg0\Field1\Field25[$0F], $01) + ((Float (local6 - $06)) * 0.2)), $01)
                resetentity(arg0\Field1\Field32[$05]\Field4)
            EndIf
            local28 = entityx(arg0\Field1\Field25[$09], $01)
            local29 = entityz(arg0\Field1\Field25[$09], $01)
            freeentity(arg0\Field1\Field25[$09])
            arg0\Field1\Field25[$09] = loadmesh_strict("GFX\map\lightgunbase.b3d", $00)
            scaleentity(arg0\Field1\Field25[$09], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entityfx(arg0\Field1\Field25[$09], $00)
            positionentity(arg0\Field1\Field25[$09], local28, (arg0\Field1\Field5 + 3.875), local29, $00)
            arg0\Field1\Field25[$0A] = loadmesh_strict("GFX\map\lightgun.b3d", $00)
            entityfx(arg0\Field1\Field25[$0A], $00)
            scaleentity(arg0\Field1\Field25[$0A], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field1\Field25[$0A], local28, (arg0\Field1\Field5 + 5.0), (local29 - 0.6875), $01)
            entityparent(arg0\Field1\Field25[$0A], arg0\Field1\Field25[$09], $01)
            rotateentity(arg0\Field1\Field25[$09], 0.0, 48.0, 0.0, $00)
            rotateentity(arg0\Field1\Field25[$0A], 40.0, 0.0, 0.0, $00)
            For local11 = $00 To $14 Step $01
                For local6 = $00 To $01 Step $01
                    translateentity(arg0\Field1\Field32[local6]\Field4, 0.0, -0.04, 0.0, $00)
                Next
                For local6 = $05 To $08 Step $01
                    translateentity(arg0\Field1\Field32[local6]\Field4, 0.0, -0.04, 0.0, $00)
                Next
            Next
            resetentity(arg0\Field13)
            arg0\Field2 = 1.0
            rotateentity(arg0\Field13, 0.0, (entityyaw(arg0\Field13, $00) + (Float (arg0\Field1\Field7 + $B4))), 0.0, $00)
            If (contained106 = $00) Then
                playsound_strict(loadtempsound("SFX\Ending\GateA\106Escape.ogg"))
            EndIf
        Else
            arg0\Field2 = (arg0\Field2 + fpsfactor)
            If (playerroom = arg0\Field1) Then
                shouldplay = $11
                hideentity(fog)
                camerafogmode(camera, $01)
                camerafogrange(camera, 1.0, sky_fogdist[$00])
                camerarange(camera, 0.02, 60.0)
                tformvector(0.0, 0.0, 1.0, collider, $00)
                local30 = ((tformedz() + 1.0) * 0.5)
                local31 = ((local30 * 70.0) + 175.0)
                local32 = ((local30 * 55.0) + 195.0)
                local33 = ((local30 * 35.0) + 220.0)
                camerafogcolor(landscapecamera, local31, local32, local33)
                camerafogcolor(camera, local31, local32, local33)
                ambientlight(160.0, 160.0, 160.0)
                tformpoint(entityx(collider, $01), entityy(collider, $01), entityz(collider, $01), $00, arg0\Field1\Field3)
                local34 = $00
                If (3877.0 > tformedz()) Then
                    If (600.0 > entitydistancesquared(collider, arg0\Field1\Field25[$04])) Then
                        local23 = entityx(arg0\Field1\Field25[$04], $01)
                        local24 = entityy(arg0\Field1\Field25[$04], $01)
                        local25 = entityz(arg0\Field1\Field25[$04], $01)
                        local34 = $01
                    EndIf
                    If (130.0 > entitydistancesquared(collider, arg0\Field1\Field25[$1B])) Then
                        local23 = entityx(arg0\Field1\Field25[$1B], $01)
                        local24 = entityy(arg0\Field1\Field25[$1B], $01)
                        local25 = entityz(arg0\Field1\Field25[$1B], $01)
                        local34 = $01
                    EndIf
                Else
                    local34 = $01
                    local23 = entityx(camera, $01)
                    local24 = entityy(camera, $01)
                    local25 = entityz(camera, $01)
                EndIf
                If (local34 <> 0) Then
                    If (particleamount > $00) Then
                        local26 = ((Float arg0\Field1\Field7) + 90.0)
                        For local6 = $01 To $03 Step $01
                            local18 = createparticle((rnd(-8.0, 8.0) + local23), (rnd(-0.5, 2.5) + local24), (rnd(-8.0, 8.0) + local25), $09, rnd(0.004, 0.012), 0.0, $78, 1.0, $01)
                            local18\Field6 = rnd(0.04, 0.08)
                            local18\Field13 = -0.00005
                            local27 = rnd(-25.0, 25.0)
                            If (rand($00, $0A) = $0A) Then
                                local27 = ((Float rand($FFFFFFFF, $01)) * local27)
                            Else
                                local27 = 0.0
                            EndIf
                            rotateentity(local18\Field1, rnd(5.0, 15.0), (local26 + local27), 0.0, $00)
                        Next
                    EndIf
                EndIf
                hidedistance = 55.0
                secondarylighton = 1.0
                showentity(sky[$00])
            ElseIf (playerroom\Field8\Field11 <> "exit1") Then
                If (overlaysenabled <> 0) Then
                    showentity(fog)
                EndIf
                ambientlight(120.0, 120.0, 120.0)
                camerafogmode(camera, $01)
                camerafogrange(camera, camerafognear, camerafogfar)
                hidedistance = 15.0
                If (sky[$00] <> $00) Then
                    hideentity(sky[$00])
                EndIf
            EndIf
            For local6 = $02 To $04 Step $01
                If (arg0\Field1\Field32[local6] <> Null) Then
                    If (2.0 > arg0\Field1\Field32[local6]\Field9) Then
                        positionentity(arg0\Field1\Field32[local6]\Field4, (entityx(arg0\Field1\Field25[$03], $01) + ((cos(((arg0\Field2 / 10.0) + (Float ($78 * local6)))) * 6000.0) * (1.0 / 256.0))), (arg0\Field1\Field5 + 11.0), (entityz(arg0\Field1\Field25[$03], $01) + ((sin(((arg0\Field2 / 10.0) + (Float ($78 * local6)))) * 6000.0) * (1.0 / 256.0))), $00)
                        rotateentity(arg0\Field1\Field32[local6]\Field4, 7.0, ((arg0\Field2 / 10.0) + (Float ($78 * local6))), 20.0, $00)
                    EndIf
                EndIf
            Next
            If (350.0 <= arg0\Field2) Then
                If (contained106 = $00) Then
                    If (350.0 > (arg0\Field2 - fpsfactor)) Then
                        curr106\Field9 = -0.1
                        setnpcframe(curr106, 110.0)
                        positionentity(curr106\Field4, entityx(arg0\Field1\Field25[$03], $01), (entityy(arg0\Field13, $00) - 50.0), entityz(arg0\Field1\Field25[$03], $01), $01)
                        positionentity(curr106\Field0, entityx(arg0\Field1\Field25[$03], $01), (entityy(arg0\Field13, $00) - 50.0), entityz(arg0\Field1\Field25[$03], $01), $01)
                        local35 = createdecal($00, entityx(arg0\Field1\Field25[$03], $01), (entityy(arg0\Field1\Field25[$03], $01) + 0.01), entityz(arg0\Field1\Field25[$03], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                        local35\Field2 = 0.05
                        local35\Field1 = 0.001
                        entityalpha(local35\Field0, 0.8)
                        updatedecals()
                        playsound_strict(horrorsfx($05))
                        playsound_strict(decaysfx($00))
                    ElseIf (0.0 > curr106\Field9) Then
                        curr106\Field38 = 7000.0
                        If (0.0 = curr106\Field11) Then
                            If (curr106\Field37 <> $01) Then
                                positionentity(curr106\Field4, entityx(arg0\Field1\Field25[$03], $01), entityy(curr106\Field4, $00), entityz(arg0\Field1\Field25[$03], $01), $01)
                                If (-10.0 >= curr106\Field9) Then
                                    local36 = entityy(curr106\Field4, $00)
                                    positionentity(curr106\Field4, entityx(curr106\Field4, $00), entityy(arg0\Field1\Field25[$03], $01), entityz(curr106\Field4, $00), $01)
                                    curr106\Field37 = findpath(curr106, entityx(arg0\Field1\Field32[$05]\Field4, $01), entityy(arg0\Field1\Field32[$05]\Field4, $01), entityz(arg0\Field1\Field32[$05]\Field4, $01))
                                    curr106\Field38 = 14000.0
                                    positionentity(curr106\Field4, entityx(curr106\Field4, $00), local36, entityz(curr106\Field4, $00), $01)
                                    resetentity(curr106\Field4)
                                    curr106\Field39 = $01
                                EndIf
                            Else
                                curr106\Field38 = 14000.0
                                For local6 = $02 To $04 Step $01
                                    arg0\Field1\Field32[local6]\Field9 = 3.0
                                    arg0\Field1\Field32[local6]\Field33 = entityx(curr106\Field0, $01)
                                    arg0\Field1\Field32[local6]\Field34 = (entityy(curr106\Field0, $01) + 5.0)
                                    arg0\Field1\Field32[local6]\Field35 = entityz(curr106\Field0, $01)
                                Next
                                For local6 = $05 To $08 Step $01
                                    arg0\Field1\Field32[local6]\Field9 = 5.0
                                    arg0\Field1\Field32[local6]\Field33 = entityx(curr106\Field0, $01)
                                    arg0\Field1\Field32[local6]\Field34 = (entityy(curr106\Field0, $01) + 0.4)
                                    arg0\Field1\Field32[local6]\Field35 = entityz(curr106\Field0, $01)
                                Next
                                local7 = createpivot($00)
                                positionentity(local7, entityx(arg0\Field1\Field25[$0A], $01), entityy(arg0\Field1\Field25[$0A], $01), entityz(arg0\Field1\Field25[$0A], $01), $00)
                                pointentity(local7, curr106\Field4, 0.0)
                                rotateentity(arg0\Field1\Field25[$09], 0.0, curveangle(entityyaw(local7, $00), entityyaw(arg0\Field1\Field25[$09], $01), 150.0), 0.0, $01)
                                rotateentity(arg0\Field1\Field25[$0A], curveangle(entitypitch(local7, $00), entitypitch(arg0\Field1\Field25[$0A], $01), 200.0), entityyaw(arg0\Field1\Field25[$09], $01), 0.0, $01)
                                freeentity(local7)
                                If (0.0 < fpsfactor) Then
                                    If (((50.0 >= ((arg0\Field2 - fpsfactor) Mod 100.0)) And (50.0 < (arg0\Field2 Mod 100.0))) <> 0) Then
                                        local35 = createdecal($00, entityx(curr106\Field0, $01), (entityy(arg0\Field1\Field25[$03], $01) + 0.01), entityz(curr106\Field0, $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                        local35\Field2 = 0.2
                                        local35\Field1 = 0.004
                                        local35\Field9 = 900.0
                                        entityalpha(local35\Field0, 0.8)
                                        updatedecals()
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        local36 = distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(arg0\Field1\Field25[$04], $01), entityz(arg0\Field1\Field25[$04], $01))
                        curr106\Field22 = curvevalue(0.0, curr106\Field22, max((5.0 * local36), 2.0))
                        If (15.0 > local36) Then
                            If (arg0\Field6 = $00) Then
                                arg0\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateA\Franklin.ogg"))
                            EndIf
                            If (0.4 > local36) Then
                                curr106\Field37 = $00
                                curr106\Field38 = 14000.0
                                If (0.0 = curr106\Field11) Then
                                    setnpcframe(curr106, 259.0)
                                    If (arg0\Field7 <> $00) Then
                                        freesound_strict(arg0\Field7)
                                        arg0\Field7 = $00
                                    EndIf
                                    loadeventsound(arg0, "SFX\Ending\GateA\106Retreat.ogg", $00)
                                    arg0\Field5 = playsound2(arg0\Field7, camera, curr106\Field4, 35.0, 1.0)
                                EndIf
                                If (0.0 < fpsfactor) Then
                                    If (((50.0 >= ((arg0\Field2 - fpsfactor) Mod 160.0)) And (50.0 < (arg0\Field2 Mod 160.0))) <> 0) Then
                                        local35 = createdecal($00, entityx(curr106\Field0, $01), (entityy(arg0\Field1\Field25[$03], $01) + 0.01), entityz(curr106\Field0, $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                        local35\Field2 = 0.05
                                        local35\Field1 = 0.004
                                        local35\Field9 = 90000.0
                                        entityalpha(local35\Field0, 0.8)
                                        updatedecals()
                                    EndIf
                                EndIf
                                animatenpc(curr106, 259.0, 110.0, -0.1, $00)
                                curr106\Field11 = (curr106\Field11 + fpsfactor)
                                positionentity(curr106\Field4, entityx(curr106\Field4, $01), curvevalue((entityy(arg0\Field1\Field25[$03], $01) - (curr106\Field11 / 4500.0)), entityy(curr106\Field4, $01), 100.0), entityz(curr106\Field4, $01), $00)
                                If (700.0 < curr106\Field11) Then
                                    curr106\Field9 = 100000.0
                                    arg0\Field3 = 0.0
                                    For local6 = $05 To $08 Step $01
                                        arg0\Field1\Field32[local6]\Field9 = 1.0
                                    Next
                                    For local6 = $02 To $04 Step $01
                                        arg0\Field1\Field32[local6]\Field9 = 2.0
                                    Next
                                    hideentity(curr106\Field0)
                                EndIf
                            ElseIf (8.5 > local36) Then
                                If (0.0 = arg0\Field3) Then
                                    arg0\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateA\HIDTurret.ogg"))
                                    arg0\Field3 = 1.0
                                ElseIf (0.0 < arg0\Field3) Then
                                    arg0\Field3 = (arg0\Field3 + fpsfactor)
                                    If (525.0 <= arg0\Field3) Then
                                        If (525.0 > (arg0\Field3 - fpsfactor)) Then
                                            local18 = createparticle(entityx(curr106\Field0, $01), (entityy(curr106\Field0, $01) + 0.4), entityz(curr106\Field0, $01), $04, 7.0, 0.0, $1D5, 1.0, $01)
                                            local18\Field6 = 0.0
                                            local18\Field3 = 1.0
                                            entityparent(local18\Field1, curr106\Field4, $01)
                                            local18 = createparticle(entityx(arg0\Field1\Field25[$0A], $01), entityy(arg0\Field1\Field25[$0A], $01), entityz(arg0\Field1\Field25[$0A], $01), $04, 2.0, 0.0, $1D5, 1.0, $01)
                                            rotateentity(local18\Field1, entitypitch(arg0\Field1\Field25[$0A], $01), entityyaw(arg0\Field1\Field25[$0A], $01), 0.0, $01)
                                            moveentity(local18\Field1, 0.0, 0.359375, 2.0)
                                            local18\Field3 = 1.0
                                            local18\Field6 = 0.0
                                            entityparent(local18\Field1, arg0\Field1\Field25[$0A], $01)
                                        ElseIf (1001.0 > arg0\Field3) Then
                                            If (entityvisible(camera, arg0\Field1\Field25[$0A]) <> 0) Then
                                                lightflash = ((Float entityinview(arg0\Field1\Field25[$0A], camera)) + 0.3)
                                                camerashake = 0.6
                                            Else
                                                camerashake = 0.2
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                                If (particleamount > $00) Then
                                    For local6 = $00 To (rand($02, (((particleamount - $01) * $06) + $02)) - (Int local36)) Step $01
                                        local18 = createparticle(entityx(curr106\Field0, $01), (entityy(curr106\Field0, $01) + rnd(0.4, 0.9)), entityz(curr106\Field0, $00), $04, 0.006, -0.002, $28, 1.0, $01)
                                        local18\Field6 = 0.005
                                        local18\Field3 = 0.8
                                        local18\Field12 = -0.01
                                        rotateentity(local18\Field1, (- rnd(70.0, 110.0)), rnd(360.0, 0.0), 0.0, $00)
                                    Next
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (0.0 = arg0\Field4) Then
                        If (1.0 > (Abs (entityy(arg0\Field13, $00) - entityy(arg0\Field1\Field25[$0B], $01)))) Then
                            If (12.0 > distance(entityx(arg0\Field13, $00), entityz(arg0\Field13, $00), entityx(arg0\Field1\Field25[$0B], $01), entityz(arg0\Field1\Field25[$0B], $01))) Then
                                curr106\Field9 = 100000.0
                                hideentity(curr106\Field0)
                                For local6 = $05 To $08 Step $01
                                    arg0\Field1\Field32[local6]\Field9 = 3.0
                                    positionentity(arg0\Field1\Field32[local6]\Field4, (entityx(arg0\Field1\Field25[$0F], $01) + ((Float (local6 - $06)) * 0.3)), entityy(arg0\Field1\Field25[$0F], $01), (entityz(arg0\Field1\Field25[$0F], $01) + ((Float (local6 - $06)) * 0.3)), $01)
                                    resetentity(arg0\Field1\Field32[local6]\Field4)
                                    arg0\Field1\Field32[local6]\Field37 = findpath(arg0\Field1\Field32[local6], entityx(arg0\Field13, $00), (entityy(arg0\Field13, $00) + 0.2), entityz(arg0\Field13, $00))
                                    arg0\Field1\Field32[local6]\Field38 = 140.0
                                    arg0\Field1\Field32[local6]\Field26 = $1B58
                                Next
                                arg0\Field1\Field32[$05]\Field16 = loadsound_strict("SFX\Character\MTF\ThereHeIs1.ogg")
                                playsound2(arg0\Field1\Field32[$05]\Field16, camera, arg0\Field1\Field32[$05]\Field4, 25.0, 1.0)
                                arg0\Field1\Field29[$02]\Field5 = $01
                                For local6 = $02 To $04 Step $01
                                    removenpc(arg0\Field1\Field32[local6], $00)
                                    arg0\Field1\Field32[local6] = Null
                                Next
                                arg0\Field4 = 1.0
                            EndIf
                        EndIf
                    ElseIf (1.0 = arg0\Field4) Then
                        For local6 = $05 To $08 Step $01
                            If (16.0 < entitydistancesquared(arg0\Field1\Field32[local6]\Field4, arg0\Field13)) Then
                                arg0\Field1\Field32[local6]\Field9 = 3.0
                            Else
                                arg0\Field1\Field32[local6]\Field9 = 1.0
                            EndIf
                        Next
                        If (1.0 > (Abs (entityy(arg0\Field13, $00) - entityy(arg0\Field1\Field25[$0B], $01)))) Then
                            If (7.0 > distance(entityx(arg0\Field13, $00), entityz(arg0\Field13, $00), entityx(arg0\Field1\Field25[$0B], $01), entityz(arg0\Field1\Field25[$0B], $01))) Then
                                arg0\Field1\Field25[$0C] = loadmesh_strict("GFX\npcs\s2.b3d", $00)
                                entitycolor(arg0\Field1\Field25[$0C], 0.0, 0.0, 0.0)
                                scalemesh(arg0\Field1\Field25[$0C], (1.0 / 66.5625), (1.0 / 66.5625), (1.0 / 66.5625))
                                positionentity(arg0\Field1\Field25[$0C], entityx(arg0\Field1\Field25[$0B], $01), entityy(arg0\Field1\Field25[$0B], $01), entityz(arg0\Field1\Field25[$0B], $01), $00)
                                arg0\Field1\Field25[$11] = copyentity(arg0\Field1\Field25[$0C], $00)
                                positionentity(arg0\Field1\Field25[$11], (entityx(arg0\Field1\Field3, $01) - 15.5), entityy(arg0\Field1\Field25[$0B], $01), (entityz(arg0\Field1\Field3, $01) - 7.5), $00)
                                local37 = copyentity(arg0\Field1\Field25[$0C], $00)
                                positionentity(local37, (entityx(arg0\Field1\Field3, $01) - 16.25), entityy(arg0\Field1\Field25[$0B], $01), (entityz(arg0\Field1\Field3, $01) - 7.5), $00)
                                entityparent(local37, arg0\Field1\Field25[$11], $01)
                                local37 = copyentity(arg0\Field1\Field25[$0C], $00)
                                positionentity(local37, (entityx(arg0\Field1\Field3, $01) - 15.875), entityy(arg0\Field1\Field25[$0B], $01), (entityz(arg0\Field1\Field3, $01) - 8.25), $00)
                                entityparent(local37, arg0\Field1\Field25[$11], $01)
                                arg0\Field5 = playsound2(loadtempsound("SFX\Ending\GateA\Bell1.ogg"), camera, arg0\Field1\Field25[$0C], 10.0, 1.0)
                                local18 = createparticle(entityx(arg0\Field1\Field25[$0B], $01), entityy(camera, $01), entityz(arg0\Field1\Field25[$0B], $01), $04, 8.0, 0.0, $32, 1.0, $01)
                                local18\Field6 = 0.15
                                local18\Field3 = 0.5
                                local18 = createparticle(entityx(arg0\Field1\Field25[$0B], $01), entityy(camera, $01), entityz(arg0\Field1\Field25[$0B], $01), $04, 8.0, 0.0, $32, 1.0, $01)
                                local18\Field6 = 0.25
                                local18\Field3 = 0.5
                                pointentity(local18\Field1, arg0\Field13, 0.0)
                                camerashake = 1.0
                                lightflash = 1.0
                                arg0\Field4 = 2.0
                            EndIf
                        EndIf
                    Else
                        arg0\Field4 = (arg0\Field4 + fpsfactor)
                        pointentity(arg0\Field1\Field25[$0C], arg0\Field13, 0.0)
                        rotateentity(arg0\Field1\Field25[$0C], 0.0, entityyaw(arg0\Field1\Field25[$0C], $00), 0.0, $00)
                        stamina = -5.0
                        blurtimer = (sin((arg0\Field4 * 0.7)) * 1000.0)
                        If (0.0 = killtimer) Then
                            camerazoom(camera, ((sin((arg0\Field4 * 0.8)) * 0.2) + 1.0))
                            local36 = entitydistance(arg0\Field13, arg0\Field1\Field25[$0B])
                            If (6.5 > local36) Then
                                positionentity(arg0\Field13, curvevalue(entityx(arg0\Field1\Field25[$0B], $01), entityx(arg0\Field13, $00), (local36 * 80.0)), entityy(arg0\Field13, $00), curvevalue(entityz(arg0\Field1\Field25[$00], $01), entityz(arg0\Field13, $00), (local36 * 80.0)), $00)
                            EndIf
                        EndIf
                        If (((50.0 < arg0\Field4) And (230.0 > arg0\Field4)) <> 0) Then
                            camerashake = (sin((arg0\Field4 - 50.0)) * 3.0)
                            turnentity(arg0\Field1\Field25[$0D], 0.0, ((sin((arg0\Field4 - 50.0)) * -0.85) * fpsfactor), 0.0, $01)
                            turnentity(arg0\Field1\Field25[$0E], 0.0, ((sin((arg0\Field4 - 50.0)) * 0.85) * fpsfactor), 0.0, $01)
                            For local6 = $05 To $08 Step $01
                                positionentity(arg0\Field1\Field32[local6]\Field4, curvevalue(entityx(arg0\Field1\Field29[$02]\Field2, $01), entityx(arg0\Field1\Field32[local6]\Field4, $01), 50.0), entityy(arg0\Field1\Field32[local6]\Field4, $01), curvevalue(entityz(arg0\Field1\Field29[$02]\Field2, $01), entityz(arg0\Field1\Field32[local6]\Field4, $01), 50.0), $01)
                                resetentity(arg0\Field1\Field32[local6]\Field4)
                            Next
                        EndIf
                        If (230.0 <= arg0\Field4) Then
                            If (230.0 > (arg0\Field4 - fpsfactor)) Then
                                arg0\Field5 = playsound_strict(loadtempsound("SFX\Ending\GateA\CI.ogg"))
                            EndIf
                            If (((channelplaying(arg0\Field5) = $00) And (selectedending = "")) <> 0) Then
                                playsound_strict(loadtempsound("SFX\Ending\GateA\Bell2.ogg"))
                                local18 = createparticle(entityx(arg0\Field1\Field25[$0B], $01), entityy(camera, $01), entityz(arg0\Field1\Field25[$0B], $01), $04, 8.0, 0.0, $32, 1.0, $01)
                                local18\Field6 = 0.15
                                local18\Field3 = 0.5
                                local18 = createparticle(entityx(arg0\Field1\Field25[$0B], $01), entityy(camera, $01), entityz(arg0\Field1\Field25[$0B], $01), $04, 8.0, 0.0, $32, 1.0, $01)
                                local18\Field6 = 0.25
                                local18\Field3 = 0.5
                                selectedending = "A1"
                                godmode = $00
                                noclip = $00
                                killtimer = -0.1
                                deathmsg = ""
                                kill("was killed", $00)
                            EndIf
                            If (selectedending <> "") Then
                                camerashake = curvevalue(2.0, camerashake, 10.0)
                                lightflash = curvevalue(2.0, lightflash, 8.0)
                            EndIf
                        EndIf
                    EndIf
                ElseIf (0.0 = arg0\Field3) Then
                    arg0\Field3 = 1.0
                    For local6 = $05 To $08 Step $01
                        arg0\Field1\Field32[local6]\Field9 = 3.0
                        arg0\Field1\Field32[local6]\Field37 = findpath(arg0\Field1\Field32[local6], ((entityx(arg0\Field1\Field3, $00) - 1.0) + ((Float (local6 Mod $02)) * 2.0)), (entityy(arg0\Field13, $00) + 0.2), (entityz(arg0\Field1\Field3, $00) - ((Float (local6 Mod $02)) * 2.0)))
                        arg0\Field1\Field32[local6]\Field38 = (Float (rand($0F, $14) * $46))
                        arg0\Field1\Field32[local6]\Field26 = $5208
                    Next
                Else
                    For local6 = $05 To $08 Step $01
                        If (5.0 = arg0\Field1\Field32[local6]\Field9) Then
                            arg0\Field1\Field32[local6]\Field33 = entityx(arg0\Field13, $00)
                            arg0\Field1\Field32[local6]\Field34 = entityy(arg0\Field13, $00)
                            arg0\Field1\Field32[local6]\Field35 = entityz(arg0\Field13, $00)
                        ElseIf (36.0 > entitydistancesquared(arg0\Field1\Field32[local6]\Field4, arg0\Field13)) Then
                            arg0\Field1\Field32[local6]\Field9 = 5.0
                            arg0\Field1\Field32[local6]\Field22 = 0.0
                        EndIf
                    Next
                    If (1.0 >= arg0\Field3) Then
                        For local6 = $05 To $08 Step $01
                            If (5.0 = arg0\Field1\Field32[local6]\Field9) Then
                                For local11 = $05 To $08 Step $01
                                    arg0\Field1\Field32[local11]\Field9 = 5.0
                                    arg0\Field1\Field32[local11]\Field33 = entityx(arg0\Field13, $00)
                                    arg0\Field1\Field32[local11]\Field34 = entityy(arg0\Field13, $00)
                                    arg0\Field1\Field32[local11]\Field35 = entityz(arg0\Field13, $00)
                                    arg0\Field1\Field32[local11]\Field38 = (Float (rand($07, $0A) * $46))
                                    arg0\Field1\Field32[local11]\Field25 = 2000.0
                                    unabletomove = $01
                                Next
                                If (1.0 = arg0\Field3) Then
                                    arg0\Field5 = playsound_strict(loadtempsound("SFX\Ending\GateA\STOPRIGHTTHERE.ogg"))
                                    arg0\Field3 = 2.0
                                EndIf
                            Else
                                arg0\Field1\Field32[local6]\Field26 = $5208
                                arg0\Field1\Field32[local6]\Field25 = 2000.0
                                arg0\Field1\Field32[local6]\Field11 = 10150.0
                            EndIf
                        Next
                    Else
                        shouldplay = $00
                        currspeed = 0.0
                        If (channelplaying(arg0\Field5) = $00) Then
                            playsound_strict(introsfx($09))
                            selectedending = "A2"
                            godmode = $00
                            noclip = $00
                            killtimer = -0.1
                            deathmsg = ""
                            kill("was killed", $00)
                            blinktimer = -10.0
                            removeevent(arg0)
                            Return $01
                        EndIf
                    EndIf
                EndIf
            EndIf
            showentity(arg0\Field1\Field3)
        EndIf
    EndIf
    Return $00
End Function
