Function updateending%(arg0.events)
    Local local0%
    Local local1%
    Local local2%
    Local local3.events
    Local local4.npcs
    Local local5.npcs
    Local local6%
    Local local7#
    Local local8.emitters
    Local local9.particles
    Local local10#
    Local local11#
    Local local12.decals
    Local local13#
    Local local14%
    If (arg0 = exit1event) Then
        If (arg0\Field1\Field25[$19] = $00) Then
            drawloading(0.0, $01, $00, $00)
            showentity(arg0\Field1\Field2)
            For local0 = $00 To $1F Step $01
                If (arg0\Field1\Field24[local0] <> $00) Then
                    entityfx(arg0\Field1\Field24[local0], $09)
                EndIf
            Next
            secondarylighton = 1.0
            drawloading(60.0, $01, $00, $00)
            drawloading(90.0, $01, $00, $00)
            arg0\Field1\Field32[$00] = createnpc($07, arg0\Field1\Field3, 100.0, arg0\Field1\Field5)
            arg0\Field1\Field32[$00]\Field9 = 1.0
            arg0\Field1\Field32[$01] = createnpc($03, entityx(arg0\Field1\Field25[$04], $01), (entityy(arg0\Field1\Field25[$04], $01) + 0.2), entityz(arg0\Field1\Field25[$04], $01))
            arg0\Field1\Field32[$01]\Field9 = 0.0
            arg0\Field1\Field32[$01]\Field10 = 10.0
            local1 = createpivot($00)
            positionentity(local1, entityx(arg0\Field1\Field25[$00], $01), entityy(arg0\Field1\Field25[$00], $01), entityz(arg0\Field1\Field25[$00], $01), $00)
            arg0\Field1\Field25[$19] = loadmesh_strict("GFX\map\exit1terrain.b3d", arg0\Field1\Field2)
            scaleentity(arg0\Field1\Field25[$19], roomscale, roomscale, roomscale, $01)
            rotateentity(arg0\Field1\Field25[$19], 0.0, (Float arg0\Field1\Field6), 0.0, $01)
            positionentity(arg0\Field1\Field25[$19], entityx(local1, $00), entityy(local1, $00), entityz(local1, $00), $01)
            freeentity(local1)
            delay($64)
            sky = sky_createsky("GFX\map\sky\sky", $00)
            rotateentity(sky, 0.0, (Float (arg0\Field1\Field6 - $5A)), 0.0, $00)
            arg0\Field2 = 1.0
            drawloading(100.0, $01, $00, $00)
        Else
            updatesky()
            If (((2.0 > arg0\Field2) And (selectedending = "")) <> 0) Then
                If (2.0 = arg0\Field1\Field32[$00]\Field9) Then
                    If (playerroom = arg0\Field1) Then
                        shouldplay = $06
                    EndIf
                Else
                    arg0\Field3 = ((arg0\Field3 + fpsfactor) Mod 3600.0)
                    positionentity(arg0\Field1\Field32[$00]\Field4, (entityx(arg0\Field1\Field2, $01) + ((cos((arg0\Field3 / 10.0)) * 6000.0) * roomscale)), (14000.0 * roomscale), (entityz(arg0\Field1\Field2, $01) + ((sin((arg0\Field3 / 10.0)) * 6000.0) * roomscale)), $00)
                    rotateentity(arg0\Field1\Field32[$00]\Field4, 7.0, (arg0\Field3 / 10.0), 20.0, $00)
                    If (playerroom = arg0\Field1) Then
                        shouldplay = $05
                    EndIf
                EndIf
                If ((320.0 * roomscale) > entitydistance(arg0\Field13, arg0\Field1\Field25[$0A])) Then
                    arg0\Field2 = 2.0
                    arg0\Field1\Field29[$02]\Field5 = $00
                    arg0\Field1\Field29[$02]\Field4 = $06
                    arg0\Field1\Field29[$03]\Field5 = $00
                    arg0\Field1\Field29[$03]\Field4 = $06
                    arg0\Field1\Field32[$02] = createnpc($07, entityx(arg0\Field1\Field25[$09], $01), (entityy(arg0\Field1\Field25[$09], $01) + 0.5), entityz(arg0\Field1\Field25[$09], $01))
                    arg0\Field1\Field32[$02]\Field9 = 3.0
                    arg0\Field1\Field32[$03] = createnpc($07, entityx(arg0\Field1\Field25[$07], $01), (entityy(arg0\Field1\Field25[$07], $01) - 2.0), entityz(arg0\Field1\Field25[$07], $01))
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
                    arg0\Field1\Field32[$00]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs2()) / 25.0)) * 3.0))
                    arg0\Field1\Field32[$00]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 85.0))) + 9.0)
                    arg0\Field1\Field32[$00]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 25.0)) * 3.0))
                    arg0\Field1\Field32[$02]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs2()) / 23.0)) * 3.0))
                    arg0\Field1\Field32[$02]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 83.0))) + 5.0)
                    arg0\Field1\Field32[$02]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 23.0)) * 3.0))
                    If (3.0 = arg0\Field1\Field32[$03]\Field9) Then
                        arg0\Field1\Field32[$03]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs2()) / 20.0)) * 3.0))
                        arg0\Field1\Field32[$03]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 80.0))) + 3.5)
                        arg0\Field1\Field32[$03]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 20.0)) * 3.0))
                    EndIf
                EndIf
            EndIf
            If (((42.0 < arg0\Field2) And (2954.0 > arg0\Field2)) <> 0) Then
                If (49.0 > arg0\Field2) Then
                    camerashake = 0.5
                ElseIf (((224.0 < arg0\Field2) And (231.0 > arg0\Field2)) <> 0) Then
                    camerashake = 0.5
                ElseIf (((427.0 < arg0\Field2) And (434.0 > arg0\Field2)) <> 0) Then
                    camerashake = 0.5
                ElseIf (((756.0 > arg0\Field2) And (763.0 > arg0\Field2)) <> 0) Then
                    camerashake = 0.5
                ElseIf (((847.0 < arg0\Field2) And (861.0 > arg0\Field2)) <> 0) Then
                    camerashake = 1.0
                ElseIf (((931.0 < arg0\Field2) And (945.0 > arg0\Field2)) <> 0) Then
                    camerashake = 1.5
                ElseIf (((1155.0 < arg0\Field2) And (1295.0 > arg0\Field2)) <> 0) Then
                    camerashake = 3.0
                ElseIf (((1505.0 < arg0\Field2) And (1680.0 > arg0\Field2)) <> 0) Then
                    camerashake = 2.0
                ElseIf (((1785.0 < arg0\Field2) And (1890.0 > arg0\Field2)) <> 0) Then
                    camerashake = 2.0
                ElseIf (((2170.0 < arg0\Field2) And (2205.0 > arg0\Field2)) <> 0) Then
                    camerashake = 0.5
                ElseIf (((2450.0 < arg0\Field2) And (2555.0 > arg0\Field2)) <> 0) Then
                    camerashake = 1.5
                    If (2450.0 >= (arg0\Field2 - fpsfactor)) Then
                        arg0\Field5 = streamsound_strict("SFX\Ending\GateB\DetonatingAlphaWarheads.ogg", sfxvolume, $00)
                        arg0\Field9 = $01
                    EndIf
                ElseIf (((2765.0 < arg0\Field2) And (2786.0 > arg0\Field2)) <> 0) Then
                    camerashake = 1.0
                ElseIf (2940.0 < arg0\Field2) Then
                    camerashake = 0.5
                    arg0\Field1\Field32[$00]\Field33 = (entityx(arg0\Field1\Field25[$13], $01) + 4.0)
                    arg0\Field1\Field32[$00]\Field34 = (entityy(arg0\Field1\Field25[$13], $01) + 4.0)
                    arg0\Field1\Field32[$00]\Field35 = (entityz(arg0\Field1\Field25[$13], $01) + 4.0)
                    arg0\Field1\Field32[$02]\Field33 = entityx(arg0\Field1\Field25[$13], $01)
                    arg0\Field1\Field32[$02]\Field34 = entityy(arg0\Field1\Field25[$13], $01)
                    arg0\Field1\Field32[$02]\Field35 = entityz(arg0\Field1\Field25[$13], $01)
                EndIf
            EndIf
            If (3150.0 <= arg0\Field2) Then
                If (5250.0 > arg0\Field2) Then
                    If (arg0\Field6 = $00) Then
                        arg0\Field6 = streamsound_strict("SFX\Ending\GateB\Siren.ogg", sfxvolume, $02)
                        arg0\Field10 = $01
                    EndIf
                ElseIf (selectedending = "") Then
                    shouldplay = $42
                    stopstream_strict(arg0\Field5)
                    stopstream_strict(arg0\Field6)
                    local2 = $01
                    For local3 = Each events
                        If (local3\Field0 = "room2nuke") Then
                            local2 = (Int local3\Field2)
                            Exit
                        EndIf
                    Next
                    If (local2 = $01) Then
                        explosiontimer = max(explosiontimer, 0.1)
                        selectedending = "B2"
                    Else
                        playannouncement("SFX\Ending\GateB\AlphaWarheadsFail.ogg", $00, $01)
                        For local0 = $00 To $01 Step $01
                            local4 = createnpc($08, (entityx(arg0\Field1\Field25[$12], $01) + ((Float local0) * 0.4)), (entityy(arg0\Field1\Field25[$12], $01) + 0.29), (entityz(arg0\Field1\Field25[$12], $01) + ((Float local0) * 0.4)))
                        Next
                        local4 = createnpc($08, entityx(arg0\Field1\Field29[$02]\Field0, $01), (entityy(arg0\Field1\Field29[$02]\Field0, $01) + 0.29), ((entityz(arg0\Field1\Field29[$02]\Field0, $01) + entityz(arg0\Field1\Field29[$03]\Field0, $01)) / 2.0))
                        For local4 = Each npcs
                            If (local4\Field5 = $08) Then
                                local4\Field26 = (Int (rnd(30.0, 35.0) * 70.0))
                                local4\Field9 = 3.0
                                local4\Field10 = 10.0
                                local4\Field33 = entityx(arg0\Field13, $00)
                                local4\Field34 = entityy(arg0\Field13, $00)
                                local4\Field35 = entityz(arg0\Field13, $00)
                            EndIf
                        Next
                        debuglog("MTF Units spawned!")
                        arg0\Field2 = 5950.0
                        selectedending = "B3"
                    EndIf
                ElseIf (selectedending = "B3") Then
                    arg0\Field1\Field32[$00]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs2()) / 25.0)) * 3.0))
                    arg0\Field1\Field32[$00]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 85.0))) + 9.0)
                    arg0\Field1\Field32[$00]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 25.0)) * 3.0))
                    arg0\Field1\Field32[$02]\Field33 = (entityx(arg0\Field1\Field25[$0B], $01) + (sin(((Float millisecs2()) / 23.0)) * 3.0))
                    arg0\Field1\Field32[$02]\Field34 = ((entityy(arg0\Field1\Field25[$0B], $01) + cos(((Float millisecs()) / 83.0))) + 5.0)
                    arg0\Field1\Field32[$02]\Field35 = (entityz(arg0\Field1\Field25[$0B], $01) + (cos(((Float millisecs()) / 23.0)) * 3.0))
                    arg0\Field1\Field29[$05]\Field5 = $01
                    If (0.0 = arg0\Field4) Then
                        For local4 = Each npcs
                            If (local4\Field5 = $08) Then
                                If (5.0 = local4\Field9) Then
                                    local4\Field9 = 3.0
                                    local4\Field37 = findpath(local4, entityx(arg0\Field13, $00), entityy(arg0\Field13, $00), entityz(arg0\Field13, $00))
                                    local4\Field38 = (Float (rand($0F, $14) * $46))
                                    local4\Field26 = $5208
                                EndIf
                                If (3.0 > entitydistance(local4\Field4, arg0\Field13)) Then
                                    local4\Field9 = 5.0
                                    local4\Field37 = $00
                                    local4\Field38 = 0.0
                                    local4\Field22 = 0.0
                                EndIf
                            EndIf
                        Next
                    EndIf
                    For local4 = Each npcs
                        If (local4\Field5 = $08) Then
                            If (((5.0 = local4\Field9) And (3.0 > entitydistance(local4\Field4, arg0\Field13))) <> 0) Then
                                If (0.0 = arg0\Field4) Then
                                    playsound_strict(loadtempsound("SFX\Ending\GateB\PlayerDetect.ogg"))
                                    arg0\Field4 = (arg0\Field4 + fpsfactor)
                                    For local5 = Each npcs
                                        If (local5\Field5 = local4\Field5) Then
                                            local5\Field9 = 5.0
                                            local5\Field37 = $00
                                            local5\Field38 = 0.0
                                            local5\Field22 = 0.0
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
                        For local4 = Each npcs
                            If (local4\Field5 = $08) Then
                                local4\Field33 = entityx(arg0\Field13, $00)
                                local4\Field34 = entityy(arg0\Field13, $00)
                                local4\Field35 = entityz(arg0\Field13, $00)
                                local4\Field53 = "spine"
                                local4\Field51 = $01
                                local4\Field52 = $01
                                local4\Field8 = $00
                                local4\Field44 = 0.0
                            EndIf
                        Next
                    ElseIf (500.0 < arg0\Field4) Then
                        local6 = loadsprite("GFX\blooddrop1.png", $03, $00)
                        entityfx(local6, $0B)
                        scalesprite(local6, 1.5, 1.5)
                        shouldplay = $00
                        currspeed = 0.0
                        playsound_strict(loadtempsound("SFX\Ending\GateB\Gunshot.ogg"))
                        godmode = $00
                        noclip = $00
                        killtimer = -0.1
                        deathmsg = ""
                        kill("was killed", $00)
                        blinktimer = -10.0
                        For local4 = Each npcs
                            If (local4\Field5 = $08) Then
                                removenpc(local4, $00)
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
                    local2 = (Int ((min((((entitydistance(arg0\Field1\Field32[$03]\Field4, arg0\Field13) / roomscale) - 3000.0) / 4.0), 1000.0) + 12192.0) * roomscale))
                    positionentity(arg0\Field1\Field25[$0C], entityx(arg0\Field1\Field32[$03]\Field4, $00), (12192.0 * roomscale), entityz(arg0\Field1\Field32[$03]\Field4, $00), $00)
                    rotateentity(arg0\Field1\Field25[$0C], 0.0, ((Float arg0\Field1\Field6) + rnd(-10.0, 10.0)), 0.0, $01)
                    turnentity(arg0\Field1\Field25[$0C], 0.0, 0.0, 180.0, $00)
                ElseIf (340.0 > wrapangle(entityroll(arg0\Field1\Field25[$0C], $00))) Then
                    local7 = wrapangle(entityroll(arg0\Field1\Field25[$0C], $00))
                    turnentity(arg0\Field1\Field25[$0C], 0.0, 0.0, ((((Abs sin(local7)) * 2.0) + 5.0) * fpsfactor), $00)
                    If (((270.0 > local7) And (270.0 <= wrapangle(entityroll(arg0\Field1\Field25[$0C], $00)))) <> 0) Then
                        playsound_strict(loadtempsound("SFX\Character\Apache\Crash1.ogg"))
                        arg0\Field1\Field32[$03]\Field9 = 4.0
                        arg0\Field1\Field32[$03]\Field10 = 1.0
                        arg0\Field1\Field32[$03]\Field33 = entityx(arg0\Field1\Field25[$07], $01)
                        arg0\Field1\Field32[$03]\Field34 = (entityy(arg0\Field1\Field25[$07], $01) - 2.5)
                        arg0\Field1\Field32[$03]\Field35 = entityz(arg0\Field1\Field25[$07], $01)
                        local8 = createemitter(entityx(arg0\Field1\Field32[$03]\Field4, $00), entityy(arg0\Field1\Field32[$03]\Field4, $00), entityz(arg0\Field1\Field32[$03]\Field4, $00), $00, 0.0)
                        local8\Field7 = arg0\Field1
                        local8\Field10 = 45.0
                        local8\Field4 = -0.18
                        local8\Field5 = $190
                        local8\Field11 = rnd(0.005, 0.007)
                        local8\Field12 = -0.004
                        turnentity(local8\Field0, (Float (($14 * local0) + $FFFFFFB0)), 0.0, 0.0, $00)
                        entityparent(local8\Field0, arg0\Field1\Field32[$03]\Field4, $01)
                        initroomforemitter(local8)
                        If (particleamount > $00) Then
                            For local0 = $00 To (((particleamount - $01) Shl $02) + $03) Step $01
                                local9 = createparticle(entityx(arg0\Field1\Field32[$03]\Field4, $00), entityy(arg0\Field1\Field32[$03]\Field4, $00), entityz(arg0\Field1\Field32[$03]\Field4, $00), $00, rnd(0.5, 1.0), -0.1, $C8)
                                local9\Field9 = 0.01
                                local9\Field16 = 0.01
                                local9\Field6 = 1.0
                                local9\Field15 = -0.005
                                rotateentity(local9\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                                moveentity(local9\Field1, 0.0, 0.0, 0.3)
                            Next
                            For local0 = $00 To (((particleamount - $01) * $06) + $06) Step $01
                                local9 = createparticle(entityx(arg0\Field1\Field32[$03]\Field4, $00), entityy(arg0\Field1\Field32[$03]\Field4, $00), entityz(arg0\Field1\Field32[$03]\Field4, $00), $00, 0.02, 0.003, $C8)
                                local9\Field9 = 0.04
                                local9\Field6 = 1.0
                                local9\Field15 = -0.005
                                rotateentity(local9\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                            Next
                        EndIf
                    EndIf
                Else
                    hideentity(arg0\Field1\Field25[$0C])
                EndIf
            EndIf
        EndIf
        If (((playerroom = arg0\Field1) And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
            hideentity(fog)
            camerafogrange(camera, 5.0, 45.0)
            camerafogmode(camera, $01)
            local7 = max(sin(entityyaw(collider, $00)), 0.0)
            camerafogcolor(camera, ((local7 * 50.0) + 200.0), ((local7 * 30.0) + 200.0), 200.0)
            cameraclscolor(camera, ((local7 * 50.0) + 200.0), ((local7 * 30.0) + 200.0), 200.0)
            camerarange(camera, 0.05, 60.0)
            hidedistance = 35.0
            ambientlight(140.0, 140.0, 140.0)
            If (particleamount > $00) Then
                If (rand($03, $01) = $01) Then
                    local9 = createparticle((entityx(camera, $00) + rnd(-2.0, 2.0)), (entityy(camera, $00) + rnd(0.9, 2.0)), (entityz(camera, $00) + rnd(-2.0, 2.0)), $02, 0.006, 0.0, $12C)
                    local9\Field9 = rnd(0.002, 0.003)
                    rotateentity(local9\Field1, rnd(-20.0, 20.0), ((Float (arg0\Field1\Field6 - $5A)) + rnd(-15.0, 15.0)), 0.0, $00)
                    local9\Field16 = -0.00001
                EndIf
            EndIf
            secondarylighton = 1.0
            showentity(sky)
        ElseIf (playerroom\Field7\Field11 <> "gatea") Then
            showentity(fog)
            ambientlight((Float brightness), (Float brightness), (Float brightness))
            camerafogrange(camera, camerafognear, camerafogfar)
            camerafogmode(camera, $01)
            If (sky <> $00) Then
                hideentity(sky)
            EndIf
        EndIf
        If (1.0 <> arg0\Field1\Field32[$01]\Field9) Then
            If (((15.0 > entitydistance(arg0\Field1\Field32[$01]\Field4, arg0\Field13)) Or entityvisible(arg0\Field1\Field32[$00]\Field4, arg0\Field13)) <> 0) Then
                arg0\Field1\Field32[$01]\Field9 = 1.0
                arg0\Field1\Field32[$01]\Field11 = 1.0
            EndIf
        EndIf
        If (((8.9 > entitydistance(arg0\Field1\Field32[$01]\Field4, arg0\Field13)) Or (16.9 > entitydistance(arg0\Field1\Field25[$05], arg0\Field13))) <> 0) Then
            arg0\Field1\Field32[$01]\Field11 = 0.0
        Else
            arg0\Field1\Field32[$01]\Field11 = 1.0
        EndIf
        showentity(arg0\Field1\Field2)
    ElseIf (arg0 = gateaevent) Then
        arg0\Field24 = $00
        showentity(arg0\Field1\Field2)
        If (arg0\Field1\Field25[$00] = $00) Then
            drawloading(0.0, $00, $00, $00)
            arg0\Field1\Field25[$00] = loadmesh_strict("GFX\MAP\gateatunnel.b3d", $00)
            positionentity(arg0\Field1\Field25[$00], entityx(arg0\Field1\Field2, $01), entityy(arg0\Field1\Field2, $01), entityz(arg0\Field1\Field2, $01), $00)
            scaleentity(arg0\Field1\Field25[$00], roomscale, roomscale, roomscale, $00)
            entitytype(arg0\Field1\Field25[$00], $01, $00)
            entitypickmode(arg0\Field1\Field25[$00], $02, $01)
            entityparent(arg0\Field1\Field25[$00], arg0\Field1\Field2, $01)
            drawloading(30.0, $00, $00, $00)
            For local0 = $00 To arg0\Field1\Field18 Step $01
                If (arg0\Field1\Field24[local0] <> $00) Then
                    entityfx(arg0\Field1\Field24[local0], $09)
                EndIf
            Next
            secondarylighton = 1.0
            For local0 = $02 To $04 Step $01
                arg0\Field1\Field32[local0] = createnpc($07, arg0\Field1\Field3, (arg0\Field1\Field4 + 11.0), arg0\Field1\Field5)
                arg0\Field1\Field32[local0]\Field9 = (Float (contained106 = $00))
            Next
            sky = sky_createsky("GFX\map\sky\sky", $00)
            rotateentity(sky, 0.0, (Float arg0\Field1\Field6), 0.0, $00)
            drawloading(60.0, $00, $00, $00)
            For local0 = $00 To $01 Step $01
                arg0\Field1\Field32[local0] = createnpc($03, entityx(arg0\Field1\Field25[(local0 + $05)], $01), entityy(arg0\Field1\Field25[(local0 + $05)], $01), entityz(arg0\Field1\Field25[(local0 + $05)], $01))
                arg0\Field1\Field32[local0]\Field9 = 0.0
                pointentity(arg0\Field1\Field32[local0]\Field4, arg0\Field1\Field25[$03], 0.0)
            Next
            For local0 = $07 To $08 Step $01
                arg0\Field1\Field32[local0] = createnpc($08, (entityx(arg0\Field1\Field25[local0], $01) + 0.8), entityy(arg0\Field1\Field25[local0], $01), (entityz(arg0\Field1\Field25[local0], $01) + 0.8))
                arg0\Field1\Field32[local0]\Field9 = 5.0
                arg0\Field1\Field32[local0]\Field12 = $01
                pointentity(arg0\Field1\Field32[local0]\Field4, arg0\Field1\Field25[$03], 0.0)
            Next
            For local0 = $05 To $06 Step $01
                arg0\Field1\Field32[local0] = createnpc($08, entityx(arg0\Field1\Field25[(local0 + $02)], $01), entityy(arg0\Field1\Field25[(local0 + $02)], $01), entityz(arg0\Field1\Field25[(local0 + $02)], $01))
                arg0\Field1\Field32[local0]\Field9 = 5.0
                arg0\Field1\Field32[local0]\Field12 = $01
                pointentity(arg0\Field1\Field32[local0]\Field4, arg0\Field1\Field25[$03], 0.0)
            Next
            If (contained106 <> 0) Then
                arg0\Field1\Field29[$02]\Field4 = $01
                positionentity(arg0\Field1\Field32[$05]\Field4, (entityx(arg0\Field1\Field25[$0F], $01) + ((Float (local0 - $06)) * 0.2)), entityy(arg0\Field1\Field25[$0F], $01), (entityz(arg0\Field1\Field25[$0F], $01) + ((Float (local0 - $06)) * 0.2)), $01)
                resetentity(arg0\Field1\Field32[$05]\Field4)
            EndIf
            local10 = entityx(arg0\Field1\Field25[$09], $01)
            local11 = entityz(arg0\Field1\Field25[$09], $01)
            freeentity(arg0\Field1\Field25[$09])
            arg0\Field1\Field25[$09] = loadmesh_strict("GFX\map\lightgunbase.b3d", $00)
            scaleentity(arg0\Field1\Field25[$09], roomscale, roomscale, roomscale, $00)
            entityfx(arg0\Field1\Field25[$09], $00)
            positionentity(arg0\Field1\Field25[$09], local10, (arg0\Field1\Field4 + (992.0 * roomscale)), local11, $00)
            arg0\Field1\Field25[$0A] = loadmesh_strict("GFX\map\lightgun.b3d", $00)
            entityfx(arg0\Field1\Field25[$0A], $00)
            scaleentity(arg0\Field1\Field25[$0A], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field1\Field25[$0A], local10, (arg0\Field1\Field4 + (1280.0 * roomscale)), (local11 - (176.0 * roomscale)), $01)
            entityparent(arg0\Field1\Field25[$0A], arg0\Field1\Field25[$09], $01)
            rotateentity(arg0\Field1\Field25[$09], 0.0, 48.0, 0.0, $00)
            rotateentity(arg0\Field1\Field25[$0A], 40.0, 0.0, 0.0, $00)
            For local2 = $00 To $14 Step $01
                For local0 = $00 To $01 Step $01
                    translateentity(arg0\Field1\Field32[local0]\Field4, 0.0, -0.04, 0.0, $00)
                Next
                For local0 = $05 To $08 Step $01
                    translateentity(arg0\Field1\Field32[local0]\Field4, 0.0, -0.04, 0.0, $00)
                Next
            Next
            resetentity(arg0\Field13)
            arg0\Field2 = 1.0
            rotateentity(arg0\Field13, 0.0, (entityyaw(arg0\Field13, $00) + (Float (arg0\Field1\Field6 + $B4))), 0.0, $00)
            If (contained106 = $00) Then
                playsound_strict(loadtempsound("SFX\Ending\GateA\106Escape.ogg"))
            EndIf
            drawloading(100.0, $00, $00, $00)
        Else
            arg0\Field2 = (arg0\Field2 + fpsfactor)
            If (playerroom = arg0\Field1) Then
                camerafogmode(camera, $01)
                shouldplay = $11
                hideentity(fog)
                camerafogrange(camera, 5.0, 30.0)
                local7 = max(sin((entityyaw(collider, $00) + 90.0)), 0.0)
                camerafogcolor(camera, ((local7 * 40.0) + 200.0), ((local7 * 20.0) + 200.0), 200.0)
                cameraclscolor(camera, ((local7 * 40.0) + 200.0), ((local7 * 20.0) + 200.0), 200.0)
                camerarange(camera, 0.05, 50.0)
                ambientlight(140.0, 140.0, 140.0)
                hidedistance = 35.0
                secondarylighton = 1.0
                showentity(sky)
            ElseIf (playerroom\Field7\Field11 <> "exit1") Then
                showentity(fog)
                ambientlight((Float brightness), (Float brightness), (Float brightness))
                camerafogrange(camera, camerafognear, camerafogfar)
                camerafogmode(camera, $01)
                hidedistance = 15.0
                If (sky <> $00) Then
                    hideentity(sky)
                EndIf
            EndIf
            For local0 = $02 To $04 Step $01
                If (arg0\Field1\Field32[local0] <> Null) Then
                    If (2.0 > arg0\Field1\Field32[local0]\Field9) Then
                        positionentity(arg0\Field1\Field32[local0]\Field4, (entityx(arg0\Field1\Field25[$03], $01) + ((cos(((arg0\Field2 / 10.0) + (Float ($78 * local0)))) * 6000.0) * roomscale)), (arg0\Field1\Field4 + 11.0), (entityz(arg0\Field1\Field25[$03], $01) + ((sin(((arg0\Field2 / 10.0) + (Float ($78 * local0)))) * 6000.0) * roomscale)), $00)
                        rotateentity(arg0\Field1\Field32[local0]\Field4, 7.0, ((arg0\Field2 / 10.0) + (Float ($78 * local0))), 20.0, $00)
                    EndIf
                EndIf
            Next
            updatesky()
            If (350.0 <= arg0\Field2) Then
                If (contained106 = $00) Then
                    If (350.0 > (arg0\Field2 - fpsfactor)) Then
                        curr106\Field9 = -0.1
                        setnpcframe(curr106, 110.0)
                        positionentity(curr106\Field4, entityx(arg0\Field1\Field25[$03], $01), (entityy(arg0\Field13, $00) - 50.0), entityz(arg0\Field1\Field25[$03], $01), $01)
                        positionentity(curr106\Field0, entityx(arg0\Field1\Field25[$03], $01), (entityy(arg0\Field13, $00) - 50.0), entityz(arg0\Field1\Field25[$03], $01), $01)
                        local12 = createdecal($00, entityx(arg0\Field1\Field25[$03], $01), (entityy(arg0\Field1\Field25[$03], $01) + 0.01), entityz(arg0\Field1\Field25[$03], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                        local12\Field2 = 0.05
                        local12\Field1 = 0.001
                        entityalpha(local12\Field0, 0.8)
                        updatedecals()
                        playsound_strict(horrorsfx($05))
                        playsound_strict(decaysfx($00))
                    ElseIf (0.0 > curr106\Field9) Then
                        hideentity(curr106\Field1)
                        curr106\Field38 = 7000.0
                        If (0.0 = curr106\Field11) Then
                            If (curr106\Field37 <> $01) Then
                                positionentity(curr106\Field4, entityx(arg0\Field1\Field25[$03], $01), entityy(curr106\Field4, $00), entityz(arg0\Field1\Field25[$03], $01), $01)
                                If (-10.0 >= curr106\Field9) Then
                                    local13 = entityy(curr106\Field4, $00)
                                    positionentity(curr106\Field4, entityx(curr106\Field4, $00), entityy(arg0\Field1\Field25[$03], $01), entityz(curr106\Field4, $00), $01)
                                    curr106\Field37 = findpath(curr106, entityx(arg0\Field1\Field32[$05]\Field4, $01), entityy(arg0\Field1\Field32[$05]\Field4, $01), entityz(arg0\Field1\Field32[$05]\Field4, $01))
                                    curr106\Field38 = 14000.0
                                    positionentity(curr106\Field4, entityx(curr106\Field4, $00), local13, entityz(curr106\Field4, $00), $01)
                                    resetentity(curr106\Field4)
                                    curr106\Field39 = $01
                                EndIf
                            Else
                                curr106\Field38 = 14000.0
                                For local0 = $02 To $04 Step $01
                                    arg0\Field1\Field32[local0]\Field9 = 3.0
                                    arg0\Field1\Field32[local0]\Field33 = entityx(curr106\Field0, $01)
                                    arg0\Field1\Field32[local0]\Field34 = (entityy(curr106\Field0, $01) + 5.0)
                                    arg0\Field1\Field32[local0]\Field35 = entityz(curr106\Field0, $01)
                                Next
                                For local0 = $05 To $08 Step $01
                                    arg0\Field1\Field32[local0]\Field9 = 5.0
                                    arg0\Field1\Field32[local0]\Field33 = entityx(curr106\Field0, $01)
                                    arg0\Field1\Field32[local0]\Field34 = (entityy(curr106\Field0, $01) + 0.4)
                                    arg0\Field1\Field32[local0]\Field35 = entityz(curr106\Field0, $01)
                                Next
                                local1 = createpivot($00)
                                positionentity(local1, entityx(arg0\Field1\Field25[$0A], $01), entityy(arg0\Field1\Field25[$0A], $01), entityz(arg0\Field1\Field25[$0A], $01), $00)
                                pointentity(local1, curr106\Field4, 0.0)
                                rotateentity(arg0\Field1\Field25[$09], 0.0, curveangle(entityyaw(local1, $00), entityyaw(arg0\Field1\Field25[$09], $01), 150.0), 0.0, $01)
                                rotateentity(arg0\Field1\Field25[$0A], curveangle(entitypitch(local1, $00), entitypitch(arg0\Field1\Field25[$0A], $01), 200.0), entityyaw(arg0\Field1\Field25[$09], $01), 0.0, $01)
                                freeentity(local1)
                                If (0.0 < fpsfactor) Then
                                    If (((50.0 >= ((arg0\Field2 - fpsfactor) Mod 100.0)) And (50.0 < (arg0\Field2 Mod 100.0))) <> 0) Then
                                        local12 = createdecal($00, entityx(curr106\Field4, $01), (entityy(arg0\Field1\Field25[$03], $01) + 0.01), entityz(curr106\Field4, $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                        local12\Field2 = 0.2
                                        local12\Field1 = 0.004
                                        local12\Field9 = 90000.0
                                        entityalpha(local12\Field0, 0.8)
                                        updatedecals()
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        local13 = distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(arg0\Field1\Field25[$04], $01), entityz(arg0\Field1\Field25[$04], $01))
                        curr106\Field22 = curvevalue(0.0, curr106\Field22, max((5.0 * local13), 2.0))
                        If (15.0 > local13) Then
                            If (arg0\Field6 = $00) Then
                                arg0\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateA\Franklin.ogg"))
                            EndIf
                            If (0.4 > local13) Then
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
                                        local12 = createdecal($00, entityx(curr106\Field4, $01), (entityy(arg0\Field1\Field25[$03], $01) + 0.01), entityz(curr106\Field4, $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                        local12\Field2 = 0.05
                                        local12\Field1 = 0.004
                                        local12\Field9 = 90000.0
                                        entityalpha(local12\Field0, 0.8)
                                        updatedecals()
                                    EndIf
                                EndIf
                                animatenpc(curr106, 259.0, 110.0, -0.1, $00)
                                curr106\Field11 = (curr106\Field11 + fpsfactor)
                                positionentity(curr106\Field4, entityx(curr106\Field4, $01), curvevalue((entityy(arg0\Field1\Field25[$03], $01) - (curr106\Field11 / 4500.0)), entityy(curr106\Field4, $01), 100.0), entityz(curr106\Field4, $01), $00)
                                If (700.0 < curr106\Field11) Then
                                    curr106\Field9 = 100000.0
                                    arg0\Field3 = 0.0
                                    For local0 = $05 To $08 Step $01
                                        arg0\Field1\Field32[local0]\Field9 = 1.0
                                    Next
                                    For local0 = $02 To $04 Step $01
                                        arg0\Field1\Field32[local0]\Field9 = 2.0
                                    Next
                                    hideentity(curr106\Field0)
                                EndIf
                            ElseIf (8.5 > local13) Then
                                If (0.0 = arg0\Field3) Then
                                    arg0\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateA\HIDTurret.ogg"))
                                    arg0\Field3 = 1.0
                                ElseIf (0.0 < arg0\Field3) Then
                                    arg0\Field3 = (arg0\Field3 + fpsfactor)
                                    If (525.0 <= arg0\Field3) Then
                                        If (525.0 > (arg0\Field3 - fpsfactor)) Then
                                            local9 = createparticle(entityx(curr106\Field0, $01), (entityy(curr106\Field0, $01) + 0.4), entityz(curr106\Field0, $01), $04, 7.0, 0.0, $1D5)
                                            local9\Field9 = 0.0
                                            local9\Field6 = 1.0
                                            entityparent(local9\Field1, curr106\Field4, $01)
                                            local9 = createparticle(entityx(arg0\Field1\Field25[$0A], $01), entityy(arg0\Field1\Field25[$0A], $01), entityz(arg0\Field1\Field25[$0A], $01), $04, 2.0, 0.0, $1D5)
                                            rotateentity(local9\Field1, entitypitch(arg0\Field1\Field25[$0A], $01), entityyaw(arg0\Field1\Field25[$0A], $01), 0.0, $01)
                                            moveentity(local9\Field1, 0.0, (92.0 * roomscale), (512.0 * roomscale))
                                            local9\Field9 = 0.0
                                            local9\Field6 = 1.0
                                            entityparent(local9\Field1, arg0\Field1\Field25[$0A], $01)
                                        ElseIf (1001.0 > arg0\Field3) Then
                                            camerashake = 0.5
                                            lightflash = (((Float entityinview(arg0\Field1\Field25[$0A], camera)) * 0.5) + 0.3)
                                        EndIf
                                    EndIf
                                EndIf
                                If (particleamount > $00) Then
                                    For local0 = $00 To (rand($02, (((particleamount - $01) * $06) + $02)) - (Int local13)) Step $01
                                        local9 = createparticle(entityx(curr106\Field0, $01), (entityy(curr106\Field0, $01) + rnd(0.4, 0.9)), entityz(curr106\Field0, $00), $00, 0.006, -0.002, $28)
                                        local9\Field9 = 0.005
                                        local9\Field6 = 0.8
                                        local9\Field15 = -0.01
                                        rotateentity(local9\Field1, (- rnd(70.0, 110.0)), rnd(360.0, 0.0), 0.0, $00)
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
                                For local0 = $05 To $08 Step $01
                                    arg0\Field1\Field32[local0]\Field9 = 3.0
                                    positionentity(arg0\Field1\Field32[local0]\Field4, (entityx(arg0\Field1\Field25[$0F], $01) + ((Float (local0 - $06)) * 0.3)), entityy(arg0\Field1\Field25[$0F], $01), (entityz(arg0\Field1\Field25[$0F], $01) + ((Float (local0 - $06)) * 0.3)), $01)
                                    resetentity(arg0\Field1\Field32[local0]\Field4)
                                    arg0\Field1\Field32[local0]\Field37 = findpath(arg0\Field1\Field32[local0], entityx(arg0\Field13, $00), (entityy(arg0\Field13, $00) + 0.2), entityz(arg0\Field13, $00))
                                    arg0\Field1\Field32[local0]\Field38 = 140.0
                                    arg0\Field1\Field32[local0]\Field26 = $1B58
                                Next
                                arg0\Field1\Field32[$05]\Field16 = loadsound_strict("SFX\Character\MTF\ThereHeIs1.ogg")
                                playsound2(arg0\Field1\Field32[$05]\Field16, camera, arg0\Field1\Field32[$05]\Field4, 25.0, 1.0)
                                arg0\Field1\Field29[$02]\Field5 = $01
                                For local0 = $02 To $04 Step $01
                                    removenpc(arg0\Field1\Field32[local0], $00)
                                    arg0\Field1\Field32[local0] = Null
                                Next
                                arg0\Field4 = 1.0
                            EndIf
                        EndIf
                    ElseIf (1.0 = arg0\Field4) Then
                        For local0 = $05 To $08 Step $01
                            If (4.0 < entitydistance(arg0\Field1\Field32[local0]\Field4, arg0\Field13)) Then
                                arg0\Field1\Field32[local0]\Field9 = 3.0
                            Else
                                arg0\Field1\Field32[local0]\Field9 = 1.0
                            EndIf
                        Next
                        If (1.0 > (Abs (entityy(arg0\Field13, $00) - entityy(arg0\Field1\Field25[$0B], $01)))) Then
                            If (7.0 > distance(entityx(arg0\Field13, $00), entityz(arg0\Field13, $00), entityx(arg0\Field1\Field25[$0B], $01), entityz(arg0\Field1\Field25[$0B], $01))) Then
                                arg0\Field1\Field25[$0C] = loadmesh_strict("GFX\npcs\s2.b3d", $00)
                                entitycolor(arg0\Field1\Field25[$0C], 0.0, 0.0, 0.0)
                                scalemesh(arg0\Field1\Field25[$0C], (1.0 / 66.5625), (1.0 / 66.5625), (1.0 / 66.5625))
                                positionentity(arg0\Field1\Field25[$0C], entityx(arg0\Field1\Field25[$0B], $01), entityy(arg0\Field1\Field25[$0B], $01), entityz(arg0\Field1\Field25[$0B], $01), $00)
                                arg0\Field1\Field25[$11] = copyentity(arg0\Field1\Field25[$0C], $00)
                                positionentity(arg0\Field1\Field25[$11], (entityx(arg0\Field1\Field2, $01) - (3968.0 * roomscale)), entityy(arg0\Field1\Field25[$0B], $01), (entityz(arg0\Field1\Field2, $01) - (1920.0 * roomscale)), $00)
                                local14 = copyentity(arg0\Field1\Field25[$0C], $00)
                                positionentity(local14, (entityx(arg0\Field1\Field2, $01) - (4160.0 * roomscale)), entityy(arg0\Field1\Field25[$0B], $01), (entityz(arg0\Field1\Field2, $01) - (1920.0 * roomscale)), $00)
                                entityparent(local14, arg0\Field1\Field25[$11], $01)
                                local14 = copyentity(arg0\Field1\Field25[$0C], $00)
                                positionentity(local14, (entityx(arg0\Field1\Field2, $01) - (4064.0 * roomscale)), entityy(arg0\Field1\Field25[$0B], $01), (entityz(arg0\Field1\Field2, $01) - (2112.0 * roomscale)), $00)
                                entityparent(local14, arg0\Field1\Field25[$11], $01)
                                arg0\Field5 = playsound2(loadtempsound("SFX\Ending\GateA\Bell1.ogg"), camera, arg0\Field1\Field25[$0C], 10.0, 1.0)
                                local9 = createparticle(entityx(arg0\Field1\Field25[$0B], $01), entityy(camera, $01), entityz(arg0\Field1\Field25[$0B], $01), $04, 8.0, 0.0, $32)
                                local9\Field9 = 0.15
                                local9\Field6 = 0.5
                                local9 = createparticle(entityx(arg0\Field1\Field25[$0B], $01), entityy(camera, $01), entityz(arg0\Field1\Field25[$0B], $01), $04, 8.0, 0.0, $32)
                                local9\Field9 = 0.25
                                local9\Field6 = 0.5
                                pointentity(local9\Field1, arg0\Field13, 0.0)
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
                            local13 = entitydistance(arg0\Field13, arg0\Field1\Field25[$0B])
                            If (6.5 > local13) Then
                                positionentity(arg0\Field13, curvevalue(entityx(arg0\Field1\Field25[$0B], $01), entityx(arg0\Field13, $00), (local13 * 80.0)), entityy(arg0\Field13, $00), curvevalue(entityz(arg0\Field1\Field25[$00], $01), entityz(arg0\Field13, $00), (local13 * 80.0)), $00)
                            EndIf
                        EndIf
                        If (((50.0 < arg0\Field4) And (230.0 > arg0\Field4)) <> 0) Then
                            camerashake = (sin((arg0\Field4 - 50.0)) * 3.0)
                            turnentity(arg0\Field1\Field25[$0D], 0.0, ((sin((arg0\Field4 - 50.0)) * -0.85) * fpsfactor), 0.0, $01)
                            turnentity(arg0\Field1\Field25[$0E], 0.0, ((sin((arg0\Field4 - 50.0)) * 0.85) * fpsfactor), 0.0, $01)
                            For local0 = $05 To $08 Step $01
                                positionentity(arg0\Field1\Field32[local0]\Field4, curvevalue(entityx(arg0\Field1\Field29[$02]\Field2, $01), entityx(arg0\Field1\Field32[local0]\Field4, $01), 50.0), entityy(arg0\Field1\Field32[local0]\Field4, $01), curvevalue(entityz(arg0\Field1\Field29[$02]\Field2, $01), entityz(arg0\Field1\Field32[local0]\Field4, $01), 50.0), $01)
                                resetentity(arg0\Field1\Field32[local0]\Field4)
                            Next
                        EndIf
                        If (230.0 <= arg0\Field4) Then
                            If (230.0 > (arg0\Field4 - fpsfactor)) Then
                                arg0\Field5 = playsound_strict(loadtempsound("SFX\Ending\GateA\CI.ogg"))
                            EndIf
                            If (((channelplaying(arg0\Field5) = $00) And (selectedending = "")) <> 0) Then
                                playsound_strict(loadtempsound("SFX\Ending\GateA\Bell2.ogg"))
                                local9 = createparticle(entityx(arg0\Field1\Field25[$0B], $01), entityy(camera, $01), entityz(arg0\Field1\Field25[$0B], $01), $04, 8.0, 0.0, $32)
                                local9\Field9 = 0.15
                                local9\Field6 = 0.5
                                local9 = createparticle(entityx(arg0\Field1\Field25[$0B], $01), entityy(camera, $01), entityz(arg0\Field1\Field25[$0B], $01), $04, 8.0, 0.0, $32)
                                local9\Field9 = 0.25
                                local9\Field6 = 0.5
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
                    For local0 = $05 To $08 Step $01
                        arg0\Field1\Field32[local0]\Field9 = 3.0
                        arg0\Field1\Field32[local0]\Field37 = findpath(arg0\Field1\Field32[local0], ((entityx(arg0\Field1\Field2, $00) - 1.0) + ((Float (local0 Mod $02)) * 2.0)), (entityy(arg0\Field13, $00) + 0.2), (entityz(arg0\Field1\Field2, $00) - ((Float (local0 Mod $02)) * 2.0)))
                        arg0\Field1\Field32[local0]\Field38 = (Float (rand($0F, $14) * $46))
                        arg0\Field1\Field32[local0]\Field26 = $5208
                    Next
                Else
                    For local0 = $05 To $08 Step $01
                        If (5.0 = arg0\Field1\Field32[local0]\Field9) Then
                            arg0\Field1\Field32[local0]\Field33 = entityx(arg0\Field13, $00)
                            arg0\Field1\Field32[local0]\Field34 = entityy(arg0\Field13, $00)
                            arg0\Field1\Field32[local0]\Field35 = entityz(arg0\Field13, $00)
                        ElseIf (6.0 > entitydistance(arg0\Field1\Field32[local0]\Field4, arg0\Field13)) Then
                            arg0\Field1\Field32[local0]\Field9 = 5.0
                            arg0\Field1\Field32[local0]\Field22 = 0.0
                        EndIf
                    Next
                    If (1.0 >= arg0\Field3) Then
                        For local0 = $05 To $08 Step $01
                            If (5.0 = arg0\Field1\Field32[local0]\Field9) Then
                                For local2 = $05 To $08 Step $01
                                    arg0\Field1\Field32[local2]\Field9 = 5.0
                                    arg0\Field1\Field32[local2]\Field33 = entityx(arg0\Field13, $00)
                                    arg0\Field1\Field32[local2]\Field34 = entityy(arg0\Field13, $00)
                                    arg0\Field1\Field32[local2]\Field35 = entityz(arg0\Field13, $00)
                                    arg0\Field1\Field32[local2]\Field38 = (Float (rand($07, $0A) * $46))
                                    arg0\Field1\Field32[local2]\Field25 = 2000.0
                                    unabletomove = $01
                                Next
                                If (1.0 = arg0\Field3) Then
                                    arg0\Field5 = playsound_strict(loadtempsound("SFX\Ending\GateA\STOPRIGHTTHERE.ogg"))
                                    arg0\Field3 = 2.0
                                EndIf
                            Else
                                arg0\Field1\Field32[local0]\Field26 = $5208
                                arg0\Field1\Field32[local0]\Field25 = 2000.0
                                arg0\Field1\Field32[local0]\Field11 = 10150.0
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
            showentity(arg0\Field1\Field2)
        EndIf
    EndIf
    Return $00
End Function
