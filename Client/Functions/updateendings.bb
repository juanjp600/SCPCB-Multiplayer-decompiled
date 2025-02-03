Function updateendings%()
    Local local0.events
    Local local1.events
    Local local2.npcs
    Local local3.rooms
    Local local4.particles
    Local local5%
    Local local6.dummy1499_1
    Local local7.emitter
    Local local8#
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15#
    Local local16%
    Local local17#
    Local local18#
    Local local20#
    For local0 = Each events
        Select local0\Field0
            Case $2C
                If (playerroom = local0\Field1) Then
                    If (0.0 = local0\Field2) Then
                        renderloading($00, getlocalstring("loading", "ending"))
                        For local2 = Each npcs
                            If (((local2 <> n_i\Field3) And (local2 <> n_i\Field2)) <> 0) Then
                                removenpc(local2)
                            EndIf
                        Next
                        n_i\Field7 = Null
                        n_i\Field6 = Null
                        n_i\Field4 = Null
                        n_i\Field5 = Null
                        For local6 = Each dummy1499_1
                            removedummy1499_1(local6)
                        Next
                        local0\Field1\Field15[$00] = createnpc($11, local0\Field1\Field3, 100.0, local0\Field1\Field5)
                        local0\Field1\Field15[$00]\Field10 = 1.0
                        local0\Field1\Field15[$01] = createnpc($14, entityx(local0\Field1\Field11[$02], $01), entityy(local0\Field1\Field11[$02], $01), entityz(local0\Field1\Field11[$02], $01))
                        local0\Field1\Field15[$01]\Field10 = 0.0
                        local0\Field1\Field15[$01]\Field11 = 10.0
                        local0\Field1\Field11[$00] = loadmesh_strict("GFX\Map\exit1terrain.b3d", local0\Field1\Field2)
                        scaleentity(local0\Field1\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                        rotateentity(local0\Field1\Field11[$00], 0.0, (Float local0\Field1\Field6), 0.0, $01)
                        positionentity(local0\Field1\Field11[$00], (local0\Field1\Field3 + 17.01562), (local0\Field1\Field4 - 3.972656), (local0\Field1\Field5 + 10.10938), $01)
                        renderloading($3C, getlocalstring("loading", "ending"))
                        sky = createsky("GFX\Map\Textures\sky", $00)
                        rotateentity(sky, 0.0, ((Float local0\Field1\Field6) - 90.0), 0.0, $00)
                        resetentity(me\Field60)
                        rotateentity(me\Field60, 0.0, (entityyaw(me\Field60, $00) + ((Float local0\Field1\Field6) + 180.0)), 0.0, $00)
                        renderloading($5A, getlocalstring("loading", "ending"))
                        isblackout = $00
                        hidedistance = 68.0
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg(getlocalstring("misc", "warning2"), $FF, $00, $00, $00)
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        local0\Field2 = 1.0
                        renderloading($64, "")
                    Else
                        updatesky(sky)
                        cansave = $01
                        For local3 = Each rooms
                            hideroomsnocoll(local3)
                        Next
                        showroomsnocoll(local0\Field1)
                        If (((2.0 > local0\Field2) And (me\Field43 = $FFFFFFFF)) <> 0) Then
                            If (2.0 = local0\Field1\Field15[$00]\Field10) Then
                                shouldplay = $06
                            Else
                                local0\Field3 = ((local0\Field3 + fps\Field7[$00]) Mod 3600.0)
                                positionentity(local0\Field1\Field15[$00]\Field3, (entityx(local0\Field1\Field2, $01) + ((cos((local0\Field3 / 10.0)) * 6000.0) * (1.0 / 256.0))), (local0\Field1\Field4 + 12.5625), (entityz(local0\Field1\Field2, $01) + ((sin((local0\Field3 / 10.0)) * 6000.0) * (1.0 / 256.0))), $00)
                                rotateentity(local0\Field1\Field15[$00]\Field3, 7.0, (local0\Field3 / 10.0), 20.0, $00)
                                shouldplay = $05
                            EndIf
                            If ((1.0 / 0.64) > entitydistancesquared(me\Field60, local0\Field1\Field11[$05])) Then
                                For local9 = $02 To $03 Step $01
                                    local0\Field1\Field14[local9]\Field6 = $00
                                    local0\Field1\Field14[local9]\Field4 = $01
                                Next
                                local0\Field1\Field15[$02] = createnpc($11, entityx(local0\Field1\Field11[$0B], $01), (entityy(local0\Field1\Field11[$0B], $01) + 0.5), entityz(local0\Field1\Field11[$0B], $01))
                                local0\Field1\Field15[$02]\Field10 = 3.0
                                local0\Field1\Field15[$03] = createnpc($11, entityx(local0\Field1\Field11[$04], $01), (entityy(local0\Field1\Field11[$04], $01) - 2.0), entityz(local0\Field1\Field11[$04], $01))
                                local0\Field1\Field15[$03]\Field10 = 3.0
                                local0\Field1\Field15[$00]\Field10 = 3.0
                                removenpc(local0\Field1\Field15[$01])
                                local0\Field6 = streamsound_strict("SFX\Ending\GateB\682Battle.ogg", (opt\Field21 * opt\Field16), $00)
                                local0\Field11 = $01
                                local0\Field2 = 2.0
                            EndIf
                        Else
                            shouldplay = $06
                            local0\Field2 = (local0\Field2 + fps\Field7[$00])
                            If (2800.0 > local0\Field2) Then
                                local0\Field1\Field15[$00]\Field36 = (entityx(local0\Field1\Field11[$06], $01) + (sin(((Float millisec) / 25.0)) * 3.0))
                                local0\Field1\Field15[$00]\Field37 = ((entityy(local0\Field1\Field11[$06], $01) + cos(((Float millisec) / 85.0))) + 9.0)
                                local0\Field1\Field15[$00]\Field38 = (entityz(local0\Field1\Field11[$06], $01) + (cos(((Float millisec) / 25.0)) * 3.0))
                                local0\Field1\Field15[$02]\Field36 = (entityx(local0\Field1\Field11[$06], $01) + (sin(((Float millisec) / 23.0)) * 3.0))
                                local0\Field1\Field15[$02]\Field37 = ((entityy(local0\Field1\Field11[$06], $01) + cos(((Float millisec) / 83.0))) + 5.0)
                                local0\Field1\Field15[$02]\Field38 = (entityz(local0\Field1\Field11[$06], $01) + (cos(((Float millisec) / 23.0)) * 3.0))
                                If (3.0 = local0\Field1\Field15[$03]\Field10) Then
                                    local0\Field1\Field15[$03]\Field36 = (entityx(local0\Field1\Field11[$06], $01) + (sin(((Float millisec) / 20.0)) * 3.0))
                                    local0\Field1\Field15[$03]\Field37 = ((entityy(local0\Field1\Field11[$06], $01) + cos(((Float millisec) / 80.0))) + 3.5)
                                    local0\Field1\Field15[$03]\Field38 = (entityz(local0\Field1\Field11[$06], $01) + (cos(((Float millisec) / 20.0)) * 3.0))
                                EndIf
                            EndIf
                        EndIf
                        If (((42.0 < local0\Field2) And (2954.0 > local0\Field2)) <> 0) Then
                            If (49.0 > local0\Field2) Then
                                me\Field23 = 0.5
                            ElseIf (((224.0 < local0\Field2) And (231.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 0.5
                            ElseIf (((427.0 < local0\Field2) And (434.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 0.5
                            ElseIf (((756.0 > local0\Field2) And (763.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 0.5
                            ElseIf (((847.0 < local0\Field2) And (861.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 1.0
                            ElseIf (((931.0 < local0\Field2) And (945.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 1.5
                            ElseIf (((1155.0 < local0\Field2) And (1295.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 3.0
                            ElseIf (((1505.0 < local0\Field2) And (1680.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 2.0
                            ElseIf (((1785.0 < local0\Field2) And (1890.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 2.0
                            ElseIf (((2170.0 < local0\Field2) And (2205.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 0.5
                            ElseIf (((2450.0 < local0\Field2) And (2555.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 1.5
                                If (2450.0 >= (local0\Field2 - fps\Field7[$00])) Then
                                    local0\Field6 = streamsound_strict("SFX\Ending\GateB\DetonatingAlphaWarheads.ogg", (opt\Field21 * opt\Field16), $00)
                                    local0\Field11 = $01
                                EndIf
                            ElseIf (((2765.0 < local0\Field2) And (2786.0 > local0\Field2)) <> 0) Then
                                me\Field23 = 1.0
                            ElseIf (2940.0 < local0\Field2) Then
                                me\Field23 = 0.5
                                local0\Field1\Field15[$00]\Field36 = (entityx(local0\Field1\Field11[$09], $01) + 4.0)
                                local0\Field1\Field15[$00]\Field37 = (entityy(local0\Field1\Field11[$09], $01) + 4.0)
                                local0\Field1\Field15[$00]\Field38 = (entityz(local0\Field1\Field11[$09], $01) + 4.0)
                                local0\Field1\Field15[$02]\Field36 = entityx(local0\Field1\Field11[$09], $01)
                                local0\Field1\Field15[$02]\Field37 = entityy(local0\Field1\Field11[$09], $01)
                                local0\Field1\Field15[$02]\Field38 = entityz(local0\Field1\Field11[$09], $01)
                            EndIf
                        EndIf
                        If (3150.0 <= local0\Field2) Then
                            If (5250.0 > local0\Field2) Then
                                If (local0\Field7 = $00) Then
                                    local0\Field7 = streamsound_strict("SFX\Ending\GateB\Siren.ogg", (opt\Field20 * opt\Field16), $01)
                                    local0\Field12 = $01
                                EndIf
                            ElseIf (me\Field43 = $FFFFFFFF) Then
                                If (local0\Field6 <> $00) Then
                                    stopstream_strict(local0\Field6)
                                    local0\Field6 = $00
                                    local0\Field11 = $00
                                EndIf
                                If (local0\Field7 <> $00) Then
                                    stopstream_strict(local0\Field7)
                                    local0\Field7 = $00
                                    local0\Field12 = $00
                                EndIf
                                local12 = $01
                                For local1 = Each events
                                    If (local1\Field0 = $1F) Then
                                        local12 = (Int local1\Field2)
                                        Exit
                                    EndIf
                                Next
                                If (1.0 = (Float local12)) Then
                                    shouldplay = $42
                                    me\Field58 = max(me\Field58, 0.1)
                                    me\Field43 = $03
                                Else
                                    selecteditem = Null
                                    local0\Field7 = streamsound_strict("SFX\Ending\GateB\AlphaWarheadsFail.ogg", (opt\Field21 * opt\Field16), $00)
                                    local0\Field12 = $01
                                    local2 = createnpc($15, entityx(local0\Field1\Field11[$08], $01), (entityy(local0\Field1\Field11[$08], $01) + 0.29), entityz(local0\Field1\Field11[$08], $01))
                                    local0\Field1\Field15[$04] = local2
                                    local2 = createnpc($15, entityx(local0\Field1\Field14[$02]\Field0, $01), (entityy(local0\Field1\Field14[$02]\Field0, $01) + 0.29), ((entityz(local0\Field1\Field14[$02]\Field0, $01) + entityz(local0\Field1\Field14[$03]\Field0, $01)) / 2.0))
                                    local0\Field1\Field15[$05] = local2
                                    For local9 = $04 To $05 Step $01
                                        local0\Field1\Field15[local9]\Field36 = entityx(me\Field60, $00)
                                        local0\Field1\Field15[local9]\Field37 = entityy(me\Field60, $00)
                                        local0\Field1\Field15[local9]\Field38 = entityz(me\Field60, $00)
                                        local0\Field1\Field15[local9]\Field10 = 3.0
                                    Next
                                    me\Field43 = $02
                                    local0\Field2 = 5950.0
                                EndIf
                            ElseIf (me\Field43 = $02) Then
                                local0\Field1\Field14[$04]\Field6 = $01
                                local0\Field1\Field14[$04]\Field4 = $00
                                local0\Field1\Field15[$00]\Field36 = (entityx(local0\Field1\Field11[$06], $01) + (sin(((Float millisec) / 25.0)) * 3.0))
                                local0\Field1\Field15[$00]\Field37 = ((entityy(local0\Field1\Field11[$06], $01) + cos(((Float millisec) / 85.0))) + 9.0)
                                local0\Field1\Field15[$00]\Field38 = (entityz(local0\Field1\Field11[$06], $01) + (cos(((Float millisec) / 25.0)) * 3.0))
                                local0\Field1\Field15[$02]\Field36 = (entityx(local0\Field1\Field11[$06], $01) + (sin(((Float millisec) / 23.0)) * 3.0))
                                local0\Field1\Field15[$02]\Field37 = ((entityy(local0\Field1\Field11[$06], $01) + cos(((Float millisec) / 83.0))) + 5.0)
                                local0\Field1\Field15[$02]\Field38 = (entityz(local0\Field1\Field11[$06], $01) + (cos(((Float millisec) / 23.0)) * 3.0))
                                For local9 = $04 To $05 Step $01
                                    local0\Field1\Field15[local9]\Field36 = entityx(me\Field60, $00)
                                    local0\Field1\Field15[local9]\Field37 = entityy(me\Field60, $00)
                                    local0\Field1\Field15[local9]\Field38 = entityz(me\Field60, $00)
                                Next
                                If ((((5.0 <> local0\Field1\Field15[$04]\Field10) And (npcseesplayer(local0\Field1\Field15[$04], ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01)) Lor ((5.0 <> local0\Field1\Field15[$05]\Field10) And (npcseesplayer(local0\Field1\Field15[$05], ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01))) <> 0) Then
                                    For local9 = $04 To $05 Step $01
                                        local0\Field1\Field15[local9]\Field10 = 5.0
                                    Next
                                    shouldplay = $00
                                    makemeunplayable()
                                    local0\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateB\THEREHEIS.ogg"), $01, $01)
                                EndIf
                                If (((5.0 = local0\Field1\Field15[$04]\Field10) And (channelplaying(local0\Field6) = $00)) <> 0) Then
                                    clearcheats()
                                    playsound_strict(loadtempsound("SFX\Ending\GateB\Gunshot.ogg"), $00, $01)
                                    me\Field51 = 1.0
                                    me\Field0 = 1.0
                                    msg\Field2 = ""
                                    me\Field10 = -10.0
                                    For local2 = Each npcs
                                        If (local2\Field4 = $15) Then
                                            removenpc(local2)
                                        EndIf
                                    Next
                                    removeevent(local0)
                                    Return $00
                                    Exit
                                EndIf
                            EndIf
                        EndIf
                        If (1855.0 < local0\Field2) Then
                            If (0.0 = local0\Field4) Then
                                local0\Field1\Field11[$07] = loadmesh_strict("GFX\NPCs\scp_682_arm.b3d", $00)
                                scaleentity(local0\Field1\Field11[$07], 0.15, 0.15, 0.15, $00)
                                local12 = (Int ((min((((entitydistance(local0\Field1\Field15[$03]\Field3, me\Field60) / (1.0 / 256.0)) - 3000.0) / 4.0), 1000.0) + 1408.0) * (1.0 / 256.0)))
                                positionentity(local0\Field1\Field11[$07], entityx(local0\Field1\Field15[$03]\Field3, $00), (local0\Field1\Field4 + 5.5), entityz(local0\Field1\Field15[$03]\Field3, $00), $00)
                                rotateentity(local0\Field1\Field11[$07], 0.0, ((Float local0\Field1\Field6) + rnd(-10.0, 10.0)), 0.0, $01)
                                turnentity(local0\Field1\Field11[$07], 0.0, 0.0, 180.0, $00)
                                local0\Field4 = 1.0
                            ElseIf (local0\Field1\Field11[$07] <> $00) Then
                                If (340.0 > wrapangle(entityroll(local0\Field1\Field11[$07], $00), 360.0)) Then
                                    local15 = wrapangle(entityroll(local0\Field1\Field11[$07], $00), 360.0)
                                    turnentity(local0\Field1\Field11[$07], 0.0, 0.0, ((((Abs sin(local15)) * 2.0) + 5.0) * fps\Field7[$00]), $00)
                                    If (((270.0 > local15) And (270.0 <= wrapangle(entityroll(local0\Field1\Field11[$07], $00), 360.0))) <> 0) Then
                                        playsound_strict(loadtempsound("SFX\Character\Apache\Crash0.ogg"), $00, $01)
                                        local0\Field1\Field15[$03]\Field10 = 4.0
                                        local0\Field1\Field15[$03]\Field11 = 1.0
                                        local0\Field1\Field15[$03]\Field36 = entityx(local0\Field1\Field11[$04], $01)
                                        local0\Field1\Field15[$03]\Field37 = (entityy(local0\Field1\Field11[$04], $01) - 2.5)
                                        local0\Field1\Field15[$03]\Field38 = entityz(local0\Field1\Field11[$04], $01)
                                        local7 = setemitter(Null, entityx(local0\Field1\Field15[$03]\Field3, $00), entityy(local0\Field1\Field15[$03]\Field3, $00), entityz(local0\Field1\Field15[$03]\Field3, $00), $08)
                                        entityparent(local7\Field6, local0\Field1\Field15[$03]\Field3, $01)
                                    EndIf
                                Else
                                    freeentity(local0\Field1\Field11[$07])
                                    local0\Field1\Field11[$07] = $00
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    local15 = max(sin(entityyaw(me\Field60, $00)), 0.0)
                    If (local0\Field1\Field15[$01] <> Null) Then
                        If (((225.0 > entitydistancesquared(local0\Field1\Field15[$01]\Field3, me\Field60)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                            local0\Field1\Field15[$01]\Field10 = 1.0
                            local0\Field1\Field15[$01]\Field12 = 1.0
                        Else
                            local0\Field1\Field15[$01]\Field10 = 0.0
                            local0\Field1\Field15[$01]\Field12 = 0.0
                        EndIf
                        If (((((79.21 > entitydistancesquared(local0\Field1\Field15[$01]\Field3, me\Field60)) Lor (285.61 > entitydistancesquared(local0\Field1\Field11[$03], me\Field60))) Lor chs\Field2) Lor i_268\Field2) <> 0) Then
                            local0\Field1\Field15[$01]\Field12 = 0.0
                        Else
                            local0\Field1\Field15[$01]\Field12 = 1.0
                        EndIf
                    EndIf
                Else
                    hideroomsnocoll(local0\Field1)
                EndIf
            Case $2E
                If (playerroom = local0\Field1) Then
                    If (0.0 = local0\Field2) Then
                        renderloading($00, getlocalstring("loading", "ending"))
                        For local2 = Each npcs
                            If (((local2 <> n_i\Field3) And (local2 <> n_i\Field2)) <> 0) Then
                                removenpc(local2)
                            EndIf
                        Next
                        n_i\Field7 = Null
                        n_i\Field6 = Null
                        n_i\Field4 = Null
                        n_i\Field5 = Null
                        For local6 = Each dummy1499_1
                            removedummy1499_1(local6)
                        Next
                        For local9 = $02 To $04 Step $01
                            local0\Field1\Field15[local9] = createnpc($11, local0\Field1\Field3, (local0\Field1\Field4 + 11.0), local0\Field1\Field5)
                            local0\Field1\Field15[local9]\Field10 = (Float (n_i\Field3\Field65 = $00))
                        Next
                        For local9 = $00 To $01 Step $01
                            local0\Field1\Field15[local9] = createnpc($14, entityx(local0\Field1\Field11[(local9 + $05)], $01), entityy(local0\Field1\Field11[(local9 + $05)], $01), entityz(local0\Field1\Field11[(local9 + $05)], $01))
                            local0\Field1\Field15[local9]\Field10 = 0.0
                            pointentity(local0\Field1\Field15[local9]\Field3, local0\Field1\Field11[$03], 0.0)
                        Next
                        For local9 = $05 To $08 Step $01
                            local0\Field1\Field15[local9] = createnpc($15, (entityx(local0\Field1\Field11[(((local9 < $07) Shl $01) + local9)], $01) + ((Float (local9 > $06)) * 0.8)), entityy(local0\Field1\Field11[(((local9 < $07) Shl $01) + local9)], $01), (entityz(local0\Field1\Field11[(((local9 < $07) Shl $01) + local9)], $01) + ((Float (local9 > $06)) * 0.8)))
                            local0\Field1\Field15[local9]\Field36 = entityx(local0\Field1\Field2, $01)
                            local0\Field1\Field15[local9]\Field37 = entityy(local0\Field1\Field2, $01)
                            local0\Field1\Field15[local9]\Field38 = entityz(local0\Field1\Field2, $01)
                            local0\Field1\Field15[local9]\Field10 = 5.0
                        Next
                        If (n_i\Field3\Field65 <> 0) Then
                            local0\Field1\Field14[$00]\Field4 = $01
                            positionentity(local0\Field1\Field15[$05]\Field3, entityx(local0\Field1\Field11[$0F], $01), entityy(local0\Field1\Field11[$0F], $01), entityz(local0\Field1\Field11[$0F], $01), $01)
                            resetentity(local0\Field1\Field15[$05]\Field3)
                        EndIf
                        renderloading($1E, getlocalstring("loading", "ending"))
                        sky = createsky("GFX\Map\Textures\sky", $00)
                        rotateentity(sky, 0.0, (Float local0\Field1\Field6), 0.0, $00)
                        renderloading($3C, getlocalstring("loading", "ending"))
                        local0\Field1\Field11[$00] = loadrmesh("GFX\Map\gate_a_tunnel.rmesh", Null, $01)
                        positionentity(local0\Field1\Field11[$00], entityx(local0\Field1\Field2, $01), entityy(local0\Field1\Field2, $01), entityz(local0\Field1\Field2, $01), $00)
                        scaleentity(local0\Field1\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        entitytype(local0\Field1\Field11[$00], $01, $00)
                        entitypickmode(local0\Field1\Field11[$00], $02, $01)
                        entityparent(local0\Field1\Field11[$00], local0\Field1\Field2, $01)
                        local0\Field1\Field11[$09] = loadmesh_strict("GFX\Map\Props\lightgunbase.b3d", $00)
                        positionentity(local0\Field1\Field11[$09], (local0\Field1\Field3 + 11.13281), (local0\Field1\Field4 + 3.9375), (local0\Field1\Field5 + 24.05078), $00)
                        scaleentity(local0\Field1\Field11[$09], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        local0\Field1\Field11[$0A] = loadmesh_strict("GFX\Map\Props\lightgun.b3d", $00)
                        positionentity(local0\Field1\Field11[$0A], (local0\Field1\Field3 + 11.13281), (local0\Field1\Field4 + 5.0625), (local0\Field1\Field5 + 23.36328), $01)
                        scaleentity(local0\Field1\Field11[$0A], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        entityparent(local0\Field1\Field11[$0A], local0\Field1\Field11[$09], $01)
                        rotateentity(local0\Field1\Field11[$09], 0.0, 48.0, 0.0, $00)
                        rotateentity(local0\Field1\Field11[$0A], 40.0, 0.0, 0.0, $00)
                        renderloading($5A, getlocalstring("loading", "ending"))
                        resetentity(me\Field60)
                        rotateentity(me\Field60, 0.0, (entityyaw(me\Field60, $00) + ((Float local0\Field1\Field6) + 180.0)), 0.0, $00)
                        If (n_i\Field3\Field65 = $00) Then
                            playsound_strict(loadtempsound("SFX\Ending\GateA\106Escape.ogg"), $00, $01)
                        EndIf
                        isblackout = $00
                        hidedistance = 68.0
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg(getlocalstring("misc", "warning2"), $FF, $00, $00, $00)
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        local0\Field2 = 1.0
                        renderloading($64, "")
                    Else
                        updatesky(sky)
                        cansave = $01
                        For local3 = Each rooms
                            hideroomsnocoll(local3)
                        Next
                        showroomsnocoll(local0\Field1)
                        shouldplay = $10
                        local0\Field2 = (local0\Field2 + fps\Field7[$00])
                        local15 = max(sin((entityyaw(me\Field60, $00) + 90.0)), 0.0)
                        For local9 = $02 To $04 Step $01
                            If (local0\Field1\Field15[local9] <> Null) Then
                                If (2.0 > local0\Field1\Field15[local9]\Field10) Then
                                    positionentity(local0\Field1\Field15[local9]\Field3, (((cos(((local0\Field2 / 10.0) + (120.0 * (Float local9)))) * 6000.0) * (1.0 / 256.0)) + entityx(local0\Field1\Field11[$03], $01)), (local0\Field1\Field4 + 11.0), (((sin(((local0\Field2 / 10.0) + (120.0 * (Float local9)))) * 6000.0) * (1.0 / 256.0)) + entityz(local0\Field1\Field11[$03], $01)), $00)
                                    rotateentity(local0\Field1\Field15[local9]\Field3, 7.0, ((local0\Field2 / 10.0) + (120.0 * (Float local9))), 20.0, $00)
                                EndIf
                            EndIf
                        Next
                        If (350.0 <= local0\Field2) Then
                            If (n_i\Field3\Field65 = $00) Then
                                If (350.0 > (local0\Field2 - fps\Field7[$00])) Then
                                    n_i\Field3\Field36 = entityx(local0\Field1\Field11[$03], $01)
                                    n_i\Field3\Field37 = entityy(local0\Field1\Field11[$03], $01)
                                    n_i\Field3\Field38 = entityz(local0\Field1\Field11[$03], $01)
                                    n_i\Field3\Field10 = 2.0
                                    rotateentity(n_i\Field3\Field3, 0.0, ((Float local0\Field1\Field6) + 90.0), 0.0, $00)
                                    playsound_strict(snd_i\Field47[$05], $00, $01)
                                ElseIf (2.0 < n_i\Field3\Field10) Then
                                    If (3.0 = n_i\Field3\Field10) Then
                                        If (entityhidden(n_i\Field3\Field1) = $00) Then
                                            hideentity(n_i\Field3\Field1)
                                        EndIf
                                        n_i\Field3\Field41 = 7000.0
                                        If (n_i\Field3\Field40 <> $01) Then
                                            n_i\Field3\Field40 = findpath(n_i\Field3, entityx(local0\Field1\Field15[$05]\Field3, $01), entityy(local0\Field1\Field15[$05]\Field3, $01), entityz(local0\Field1\Field15[$05]\Field3, $01))
                                            n_i\Field3\Field42 = $01
                                        EndIf
                                        For local9 = $02 To $04 Step $01
                                            local0\Field1\Field15[local9]\Field36 = entityx(n_i\Field3\Field0, $01)
                                            local0\Field1\Field15[local9]\Field37 = (entityy(n_i\Field3\Field0, $01) + 5.0)
                                            local0\Field1\Field15[local9]\Field38 = entityz(n_i\Field3\Field0, $01)
                                            local0\Field1\Field15[local9]\Field10 = 3.0
                                        Next
                                        For local9 = $05 To $08 Step $01
                                            If (npcseesplayer(local0\Field1\Field15[local9], ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                                local0\Field1\Field15[local9]\Field10 = 6.0
                                            Else
                                                local0\Field1\Field15[local9]\Field36 = entityx(n_i\Field3\Field0, $01)
                                                local0\Field1\Field15[local9]\Field37 = (entityy(n_i\Field3\Field0, $01) + 0.4)
                                                local0\Field1\Field15[local9]\Field38 = entityz(n_i\Field3\Field0, $01)
                                                local0\Field1\Field15[local9]\Field10 = 5.0
                                            EndIf
                                        Next
                                        local11 = createpivot($00)
                                        positionentity(local11, entityx(local0\Field1\Field11[$0A], $01), entityy(local0\Field1\Field11[$0A], $01), entityz(local0\Field1\Field11[$0A], $01), $00)
                                        pointentity(local11, n_i\Field3\Field3, 0.0)
                                        rotateentity(local0\Field1\Field11[$09], 0.0, curveangle(entityyaw(local11, $00), entityyaw(local0\Field1\Field11[$09], $01), 150.0), 0.0, $01)
                                        rotateentity(local0\Field1\Field11[$0A], curveangle(entitypitch(local11, $00), entitypitch(local0\Field1\Field11[$0A], $01), 200.0), entityyaw(local0\Field1\Field11[$09], $01), 0.0, $01)
                                        freeentity(local11)
                                        local11 = $00
                                    EndIf
                                    local8 = distancesquared(entityx(n_i\Field3\Field3, $00), entityx(local0\Field1\Field11[$04], $01), entityz(n_i\Field3\Field3, $00), entityz(local0\Field1\Field11[$04], $01), 0.0, 0.0)
                                    n_i\Field3\Field24 = curvevalue(0.0, n_i\Field3\Field24, max((5.0 * sqr(local8)), 2.0))
                                    If (225.0 > local8) Then
                                        If (local0\Field7 = $00) Then
                                            local0\Field7 = playsound_strict(loadtempsound("SFX\Ending\GateA\Franklin.ogg"), $01, $01)
                                        EndIf
                                        If (0.16 > local8) Then
                                            n_i\Field3\Field10 = 4.0
                                            If (151.0 >= n_i\Field3\Field14) Then
                                                local0\Field3 = 0.0
                                                For local9 = $02 To $04 Step $01
                                                    local0\Field1\Field15[local9]\Field10 = 2.0
                                                Next
                                                For local9 = $05 To $08 Step $01
                                                    local0\Field1\Field15[local9]\Field23 = (local0\Field1\Field15[local9]\Field23 * rnd(1.0, 1.3))
                                                    local0\Field1\Field15[local9]\Field10 = 1.0
                                                    local0\Field1\Field15[local9]\Field11 = 252000.0
                                                Next
                                            EndIf
                                        ElseIf (72.25 > local8) Then
                                            If (0.0 = local0\Field3) Then
                                                local0\Field7 = playsound_strict(loadtempsound("SFX\Ending\GateA\HIDTurret.ogg"), $00, $01)
                                                local0\Field3 = 1.0
                                            ElseIf (0.0 < local0\Field3) Then
                                                local0\Field3 = (local0\Field3 + fps\Field7[$00])
                                                If (525.0 <= local0\Field3) Then
                                                    If (525.0 > (local0\Field3 - fps\Field7[$00])) Then
                                                        local4 = createparticle($05, entityx(n_i\Field3\Field0, $01), (entityy(n_i\Field3\Field0, $01) + 0.4), entityz(n_i\Field3\Field0, $01), 7.0, 0.0, 470.0)
                                                        local4\Field4 = 0.0
                                                        local4\Field2 = 1.0
                                                        entityparent(local4\Field1, n_i\Field3\Field3, $01)
                                                        local4 = createparticle($05, entityx(local0\Field1\Field11[$0A], $01), entityy(local0\Field1\Field11[$0A], $01), entityz(local0\Field1\Field11[$0A], $01), 2.0, 0.0, 470.0)
                                                        local4\Field4 = 0.0
                                                        local4\Field2 = 1.0
                                                        rotateentity(local4\Field1, entitypitch(local0\Field1\Field11[$0A], $01), entityyaw(local0\Field1\Field11[$0A], $01), 0.0, $01)
                                                        moveentity(local4\Field1, 0.0, 0.359375, 2.0)
                                                        entityparent(local4\Field1, local0\Field1\Field11[$0A], $01)
                                                    ElseIf (1036.0 > local0\Field3) Then
                                                        me\Field23 = 0.5
                                                        me\Field51 = (((Float entityinview(local0\Field1\Field11[$0A], camera)) * 0.5) + 0.3)
                                                        lightvolume = (rnd(1.0, 2.0) * templightvolume)
                                                        If (((Int me\Field0) Lor chs\Field0) = $00) Then
                                                            If (1.44 > entitydistancesquared(me\Field60, n_i\Field3\Field3)) Then
                                                                playsound_strict(loadtempsound("SFX\SCP\294\Burn.ogg"), $00, $01)
                                                                kill($01, $01, $00, $01)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (opt\Field0 > $00) Then
                                                For local9 = $00 To (rand($02, (((opt\Field0 - $01) * $06) + $02)) - (Int sqr(local8))) Step $01
                                                    local4 = createparticle($00, entityx(n_i\Field3\Field0, $01), (entityy(n_i\Field3\Field0, $01) + rnd(0.4, 0.9)), entityz(n_i\Field3\Field0, $00), 0.006, -0.002, 40.0)
                                                    local4\Field4 = 0.005
                                                    local4\Field2 = 0.8
                                                    local4\Field10 = -0.01
                                                    rotateentity(local4\Field1, (- rnd(70.0, 110.0)), rnd(360.0, 0.0), 0.0, $00)
                                                Next
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.0 = local0\Field4) Then
                                    If (1.0 > (Abs (entityy(me\Field60, $00) - entityy(local0\Field1\Field11[$0B], $01)))) Then
                                        If (144.0 > distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field11[$0B], $01), entityz(me\Field60, $00), entityz(local0\Field1\Field11[$0B], $01), 0.0, 0.0)) Then
                                            n_i\Field3\Field10 = 0.0
                                            n_i\Field3\Field11 = rnd(22000.0, 27000.0)
                                            If (entityhidden(n_i\Field3\Field0) = $00) Then
                                                hideentity(n_i\Field3\Field0)
                                            EndIf
                                            For local9 = $05 To $08 Step $01
                                                positionentity(local0\Field1\Field15[local9]\Field3, (entityx(local0\Field1\Field11[$0F], $01) + ((Float (local9 - $06)) * 0.3)), entityy(local0\Field1\Field11[$0F], $01), (entityz(local0\Field1\Field11[$0F], $01) + ((Float (local9 - $06)) * 0.3)), $01)
                                                resetentity(local0\Field1\Field15[local9]\Field3)
                                                local0\Field1\Field15[local9]\Field36 = entityx(me\Field60, $00)
                                                local0\Field1\Field15[local9]\Field37 = entityy(me\Field60, $00)
                                                local0\Field1\Field15[local9]\Field38 = entityz(me\Field60, $00)
                                                local0\Field1\Field15[local9]\Field41 = 0.0
                                                local0\Field1\Field15[local9]\Field10 = 3.0
                                            Next
                                            local0\Field1\Field15[$05]\Field17 = loadsound_strict("SFX\Character\MTF\ThereHeIs0.ogg")
                                            playsoundex(local0\Field1\Field15[$05]\Field17, camera, local0\Field1\Field15[$05]\Field3, 25.0, 1.0, $01, $00)
                                            local0\Field1\Field14[$00]\Field6 = $01
                                            For local9 = $02 To $04 Step $01
                                                local0\Field1\Field15[local9]\Field10 = 0.0
                                            Next
                                            local0\Field4 = 1.0
                                        EndIf
                                    EndIf
                                ElseIf (1.0 = local0\Field4) Then
                                    For local9 = $05 To $08 Step $01
                                        If (16.0 < entitydistancesquared(local0\Field1\Field15[local9]\Field3, me\Field60)) Then
                                            local0\Field1\Field15[local9]\Field10 = 3.0
                                        Else
                                            local0\Field1\Field15[local9]\Field10 = 6.0
                                        EndIf
                                    Next
                                    If (1.0 > (Abs (entityy(me\Field60, $00) - entityy(local0\Field1\Field11[$0B], $01)))) Then
                                        If (49.0 > distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field11[$0B], $01), entityz(me\Field60, $00), entityz(local0\Field1\Field11[$0B], $01), 0.0, 0.0)) Then
                                            For local9 = $05 To $08 Step $01
                                                local0\Field1\Field15[local9]\Field10 = 5.0
                                            Next
                                            local0\Field1\Field11[$0C] = loadanimmesh_strict("GFX\NPCs\CI.b3d", $00)
                                            local20 = (0.55 / meshwidth(local0\Field1\Field11[$0C]))
                                            scaleentity(local0\Field1\Field11[$0C], local20, local20, local20, $00)
                                            positionentity(local0\Field1\Field11[$0C], entityx(local0\Field1\Field11[$0B], $01), entityy(local0\Field1\Field11[$0B], $01), entityz(local0\Field1\Field11[$0B], $01), $00)
                                            local0\Field1\Field11[$11] = copyentity(local0\Field1\Field11[$0C], $00)
                                            positionentity(local0\Field1\Field11[$11], (entityx(local0\Field1\Field2, $01) - 15.5), entityy(local0\Field1\Field11[$0B], $01), (entityz(local0\Field1\Field2, $01) - 7.5), $00)
                                            local16 = copyentity(local0\Field1\Field11[$0C], $00)
                                            positionentity(local16, (entityx(local0\Field1\Field2, $01) - 16.25), entityy(local0\Field1\Field11[$0B], $01), (entityz(local0\Field1\Field2, $01) - 7.5), $00)
                                            entityparent(local16, local0\Field1\Field11[$11], $01)
                                            local16 = copyentity(local0\Field1\Field11[$0C], $00)
                                            positionentity(local16, (entityx(local0\Field1\Field2, $01) - 15.875), entityy(local0\Field1\Field11[$0B], $01), (entityz(local0\Field1\Field2, $01) - 8.25), $00)
                                            entityparent(local16, local0\Field1\Field11[$11], $01)
                                            local0\Field6 = playsoundex(loadtempsound("SFX\Ending\GateA\Bell0.ogg"), camera, local0\Field1\Field11[$0C], 10.0, 1.0, $00, $00)
                                            local4 = createparticle($05, entityx(local0\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local0\Field1\Field11[$0B], $01), 8.0, 0.0, 50.0)
                                            local4\Field4 = 0.15
                                            local4\Field2 = 0.5
                                            local4 = createparticle($05, entityx(local0\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local0\Field1\Field11[$0B], $01), 8.0, 0.0, 50.0)
                                            local4\Field4 = 0.25
                                            local4\Field2 = 0.5
                                            pointentity(local4\Field1, me\Field60, 0.0)
                                            me\Field23 = 1.0
                                            me\Field51 = 1.0
                                            local0\Field4 = 2.0
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field4 = (local0\Field4 + fps\Field7[$00])
                                    pointentity(local0\Field1\Field11[$0C], me\Field60, 0.0)
                                    rotateentity(local0\Field1\Field11[$0C], 0.0, entityyaw(local0\Field1\Field11[$0C], $00), 0.0, $00)
                                    me\Field17 = -5.0
                                    me\Field49 = (sin((local0\Field4 * 0.7)) * 1000.0)
                                    If (0.0 = me\Field0) Then
                                        camerazoom(camera, ((sin((local0\Field4 * 0.8)) * 0.2) + 1.0))
                                        local8 = entitydistancesquared(me\Field60, local0\Field1\Field11[$0B])
                                        If (42.25 > local8) Then
                                            local18 = (sqr(local8) * 80.0)
                                            positionentity(me\Field60, curvevalue(entityx(local0\Field1\Field11[$0B], $01), entityx(me\Field60, $00), local8), entityy(me\Field60, $00), curvevalue(entityz(local0\Field1\Field11[$00], $01), entityz(me\Field60, $00), local8), $00)
                                        EndIf
                                    EndIf
                                    If (((50.0 < local0\Field4) And (230.0 > local0\Field4)) <> 0) Then
                                        local17 = sin((local0\Field4 - 50.0))
                                        me\Field23 = (local17 * 3.0)
                                        turnentity(local0\Field1\Field11[$0D], 0.0, ((local17 * -0.85) * fps\Field7[$00]), 0.0, $01)
                                        turnentity(local0\Field1\Field11[$0E], 0.0, ((local17 * 0.85) * fps\Field7[$00]), 0.0, $01)
                                    EndIf
                                    If (230.0 <= local0\Field4) Then
                                        If (230.0 > (local0\Field4 - fps\Field7[$00])) Then
                                            local0\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateA\CI.ogg"), $01, $01)
                                            me\Field43 = $00
                                        EndIf
                                        If (480.0 <= local0\Field4) Then
                                            animateex(local0\Field1\Field11[$0C], animtime(local0\Field1\Field11[$0C]), $B0, $D2, 0.2, $01)
                                            moveentity(local0\Field1\Field11[$0C], 0.0, 0.0, (fps\Field7[$00] * 0.01))
                                        EndIf
                                        If (channelplaying(local0\Field6) = $00) Then
                                            clearcheats()
                                            playsound_strict(loadtempsound("SFX\Ending\GateA\Bell1.ogg"), $00, $01)
                                            For local2 = Each npcs
                                                removenpc(local2)
                                            Next
                                            local4 = createparticle($05, entityx(local0\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local0\Field1\Field11[$0B], $01), 8.0, 0.0, 50.0)
                                            local4\Field4 = 0.15
                                            local4\Field2 = 0.5
                                            local4 = createparticle($05, entityx(local0\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local0\Field1\Field11[$0B], $01), 8.0, 0.0, 50.0)
                                            local4\Field4 = 0.25
                                            local4\Field2 = 0.5
                                            me\Field23 = curvevalue(2.0, me\Field23, 10.0)
                                            me\Field51 = curvevalue(2.0, me\Field51, 8.0)
                                            me\Field0 = 1.0
                                            msg\Field2 = ""
                                            removeevent(local0)
                                            Return $00
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (0.0 = local0\Field3) Then
                                For local9 = $02 To $04 Step $01
                                    local0\Field1\Field15[local9]\Field10 = 0.0
                                Next
                                For local9 = $05 To $08 Step $01
                                    local0\Field1\Field15[local9]\Field36 = entityx(me\Field60, $00)
                                    local0\Field1\Field15[local9]\Field37 = entityy(me\Field60, $00)
                                    local0\Field1\Field15[local9]\Field38 = entityz(me\Field60, $00)
                                    local0\Field1\Field15[local9]\Field10 = 3.0
                                Next
                                local0\Field3 = 1.0
                            Else
                                For local9 = $05 To $08 Step $01
                                    local0\Field1\Field15[local9]\Field36 = entityx(me\Field60, $00)
                                    local0\Field1\Field15[local9]\Field37 = entityy(me\Field60, $00)
                                    local0\Field1\Field15[local9]\Field38 = entityz(me\Field60, $00)
                                Next
                                If (1.0 = local0\Field3) Then
                                    For local9 = $05 To $08 Step $01
                                        If (npcseesplayer(local0\Field1\Field15[local9], ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                            local12 = $01
                                            Exit
                                        EndIf
                                    Next
                                    If (local12 <> 0) Then
                                        For local9 = $05 To $08 Step $01
                                            local0\Field1\Field15[local9]\Field10 = 5.0
                                        Next
                                        local0\Field3 = 2.0
                                    EndIf
                                ElseIf (2.0 = local0\Field3) Then
                                    makemeunplayable()
                                    me\Field43 = $01
                                    local0\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateA\STOPRIGHTTHERE.ogg"), $01, $01)
                                    local0\Field3 = 3.0
                                ElseIf (3.0 = local0\Field3) Then
                                    shouldplay = $00
                                    me\Field38 = 0.0
                                    If (channelplaying(local0\Field6) = $00) Then
                                        clearcheats()
                                        playsound_strict(loadtempsound("SFX\Room\Intro\Bang2.ogg"), $00, $01)
                                        For local2 = Each npcs
                                            removenpc(local2)
                                        Next
                                        me\Field51 = 1.0
                                        me\Field0 = 1.0
                                        msg\Field2 = ""
                                        me\Field10 = -10.0
                                        removeevent(local0)
                                        Return $00
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideroomsnocoll(local0\Field1)
                EndIf
        End Select
    Next
    updateexplosion()
    Return $00
End Function
