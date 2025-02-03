Function updatedimension1499%()
    Local local0.events
    Local local1.npcs
    Local local2%
    Local local3.items
    Local local4.dummy1499_1
    Local local5%
    Local local6%
    Local local7#
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    For local0 = Each events
        If (local0\Field0 = $49) Then
            If (playerroom = local0\Field1) Then
                previsblackout = isblackout
                isblackout = $00
                If (2.0 > local0\Field2) Then
                    If (0.0 = local0\Field2) Then
                        If (((local0\Field13 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local0
                            local0\Field13 = "Load0"
                        EndIf
                    Else
                        local0\Field2 = 2.0
                    EndIf
                    local12 = rand($02, $03)
                    If ((((Float local12) = local0\Field3) Lor (4.0 = local0\Field3)) <> 0) Then
                        For local10 = $FFFFFFFF To $01 Step $01
                            For local11 = $FFFFFFFF To $01 Step $01
                                If (((local10 <> $00) And (local11 <> $00)) <> 0) Then
                                    local1 = createnpc($10, (entityx(me\Field60, $00) + (0.75 * (Float local10))), (entityy(me\Field60, $00) + 0.05), (entityz(me\Field60, $00) + (0.75 * (Float local11))))
                                    local1\Field10 = 2.0
                                    pointentity(local1\Field3, me\Field60, 0.0)
                                    rotateentity(local1\Field3, 0.0, entityyaw(local1\Field3, $00), 0.0, $00)
                                ElseIf (((local10 <> $00) Lor (local11 <> $00)) <> 0) Then
                                    local1 = createnpc($10, (entityx(me\Field60, $00) + (Float local10)), (entityy(me\Field60, $00) + 0.05), (entityz(me\Field60, $00) + (Float local11)))
                                    local1\Field10 = 2.0
                                    pointentity(local1\Field3, me\Field60, 0.0)
                                    rotateentity(local1\Field3, 0.0, entityyaw(local1\Field3, $00), 0.0, $00)
                                EndIf
                            Next
                        Next
                        local0\Field3 = 5.0
                    EndIf
                    If (2100.0 > local0\Field4) Then
                        local0\Field1\Field15[$00] = createnpc($10, (local0\Field1\Field3 - 7.488281), (local0\Field1\Field4 + 7.4375), (local0\Field1\Field5 + 9.015625))
                        local0\Field1\Field15[$00]\Field13 = $02
                        local0\Field1\Field15[$00]\Field15 = 270.0
                        changenpctextureid(local0\Field1\Field15[$00], $15)
                        rotateentity(local0\Field1\Field15[$00]\Field3, 0.0, local0\Field1\Field15[$00]\Field15, 0.0, $00)
                        local0\Field1\Field15[$01] = createnpc($10, (local0\Field1\Field3 - 7.488281), (local0\Field1\Field4 + 7.4375), (local0\Field1\Field5 + 8.015625))
                        local0\Field1\Field15[$01]\Field13 = $01
                        local0\Field1\Field15[$01]\Field15 = 270.0
                        rotateentity(local0\Field1\Field15[$01]\Field3, 0.0, local0\Field1\Field15[$01]\Field15, 0.0, $00)
                        local0\Field1\Field15[$02] = createnpc($10, (local0\Field1\Field3 + 15.83984), (local0\Field1\Field4 + 0.5), (local0\Field1\Field5 + 7.359375))
                        local0\Field1\Field15[$02]\Field13 = $03
                        local0\Field1\Field15[$02]\Field15 = 270.0
                        rotateentity(local0\Field1\Field15[$02]\Field3, 0.0, local0\Field1\Field15[$02]\Field15, 0.0, $00)
                        local0\Field1\Field15[$03] = createnpc($10, (local0\Field1\Field3 + 15.83984), (local0\Field1\Field4 + 0.5), (local0\Field1\Field5 + 11.23438))
                        local0\Field1\Field15[$03]\Field13 = $03
                        local0\Field1\Field15[$03]\Field15 = 270.0
                        rotateentity(local0\Field1\Field15[$03]\Field3, 0.0, local0\Field1\Field15[$03]\Field15, 0.0, $00)
                        local0\Field1\Field15[$02]\Field34 = local0\Field1\Field15[$03]
                        local0\Field1\Field15[$03]\Field34 = local0\Field1\Field15[$02]
                        local0\Field1\Field15[$04] = createnpc($10, (local0\Field1\Field3 - 7.332031), (local0\Field1\Field4 + 0.75), (local0\Field1\Field5 + 4.183594))
                        local0\Field1\Field15[$04]\Field13 = $03
                        local0\Field1\Field15[$04]\Field15 = 270.0
                        rotateentity(local0\Field1\Field15[$04]\Field3, 0.0, local0\Field1\Field15[$04]\Field15, 0.0, $00)
                        local0\Field1\Field15[$05] = createnpc($10, (local0\Field1\Field3 - 7.332031), (local0\Field1\Field4 + 0.75), (local0\Field1\Field5 + 13.68359))
                        local0\Field1\Field15[$05]\Field13 = $03
                        local0\Field1\Field15[$05]\Field15 = 270.0
                        rotateentity(local0\Field1\Field15[$05]\Field3, 0.0, local0\Field1\Field15[$05]\Field15, 0.0, $00)
                        local0\Field1\Field15[$04]\Field34 = local0\Field1\Field15[$05]
                        local0\Field1\Field15[$05]\Field34 = local0\Field1\Field15[$04]
                        local1 = createnpc($10, (local0\Field1\Field3 - 10.78516), (local0\Field1\Field4 + 0.5), (local0\Field1\Field5 + 12.51562))
                        local1\Field13 = $01
                        local1\Field15 = 180.0
                        local1\Field23 = 0.0
                        rotateentity(local1\Field3, 0.0, local1\Field15, 0.0, $00)
                        For local8 = $00 To $07 Step $01
                            For local9 = $00 To $02 Step $01
                                local4 = (New dummy1499_1)
                                For local1 = Each npcs
                                    If (((local1\Field4 = $10) And (local1\Field13 <> $02)) <> 0) Then
                                        local4\Field1 = copyentity(local1\Field0, $00)
                                        Exit
                                    EndIf
                                Next
                                local7 = ((inigetfloat("Data\NPCs.ini", "SCP-1499-1", "Scale", 0.0, $01) / 4.0) * rnd(0.8, 1.0))
                                scaleentity(local4\Field1, local7, local7, local7, $00)
                                entityfx(local4\Field1, $01)
                                local4\Field0 = rand($00, $01)
                                positionentity(local4\Field1, clamp(((local0\Field1\Field3 + ((1887.0 - (365.7143 * (Float local8))) * (1.0 / 256.0))) + rnd(-0.5, 0.5)), (local0\Field1\Field3 - 3.410156), (local0\Field1\Field3 + 7.371094)), local0\Field1\Field4, clamp(((local0\Field1\Field5 + ((1796.0 - (384.0 * (Float local9))) * (1.0 / 256.0))) + rnd(-0.5, 0.5)), (local0\Field1\Field5 + 4.015625), (local0\Field1\Field5 + 7.015625)), $00)
                                rotateentity(local4\Field1, 0.0, 270.0, 0.0, $00)
                                entityautofade(local4\Field1, 25.0, 39.0)
                            Next
                        Next
                        For local8 = $00 To $06 Step $01
                            For local9 = $00 To $02 Step $01
                                local4 = (New dummy1499_1)
                                For local1 = Each npcs
                                    If (((local1\Field4 = $10) And (local1\Field13 <> $02)) <> 0) Then
                                        local4\Field1 = copyentity(local1\Field0, $00)
                                        Exit
                                    EndIf
                                Next
                                local7 = ((inigetfloat("Data\NPCs.ini", "SCP-1499-1", "Scale", 0.0, $01) / 4.0) * rnd(0.8, 1.0))
                                scaleentity(local4\Field1, local7, local7, local7, $00)
                                entityfx(local4\Field1, $01)
                                local4\Field0 = rand($00, $01)
                                positionentity(local4\Field1, clamp(((local0\Field1\Field3 + ((1375.0 - (341.3333 * (Float local8))) * (1.0 / 256.0))) + rnd(-0.5, 0.5)), (local0\Field1\Field3 - 3.410156), (local0\Field1\Field3 + 5.371094)), local0\Field1\Field4, clamp(((local0\Field1\Field5 + ((3588.0 - (384.0 * (Float local9))) * (1.0 / 256.0))) + rnd(-0.5, 0.5)), (local0\Field1\Field5 + 11.01562), (local0\Field1\Field5 + 14.01562)), $00)
                                rotateentity(local4\Field1, 0.0, 270.0, 0.0, $00)
                                entityautofade(local4\Field1, 25.0, 39.0)
                            Next
                        Next
                    ElseIf (entityhidden(local0\Field1\Field11[$11]) = $00) Then
                        hideentity(local0\Field1\Field11[$11])
                    EndIf
                    For local10 = $00 To $0E Step $01
                        local1 = createnpc($10, (entityx(me\Field60, $00) + rnd(-20.0, 20.0)), (entityy(me\Field60, $00) + 0.1), (entityz(me\Field60, $00) + rnd(-20.0, 20.0)))
                        local1\Field15 = rnd(360.0, 0.0)
                        local1\Field11 = 0.0
                        If (100.0 > entitydistancesquared(local1\Field3, me\Field60)) Then
                            local1\Field10 = 2.0
                        EndIf
                    Next
                EndIf
                showroomsnocoll(local0\Field1)
                If (((quickloadpercent = $64) Lor (quickloadpercent = $FFFFFFFF)) <> 0) Then
                    updatechunks($0F, $01)
                    If (entityhidden(i_1499\Field8) <> 0) Then
                        showentity(i_1499\Field8)
                    EndIf
                    updatesky(i_1499\Field8)
                    shouldplay = $11
                    If (800.0 > entityy(me\Field60, $00)) Then
                        positionentity(me\Field60, entityx(me\Field60, $00), 800.5, entityz(me\Field60, $00), $01)
                        resetentity(me\Field60)
                    EndIf
                    For local3 = Each items
                        If (750.0 < entityy(local3\Field2, $00)) Then
                            If (800.0 > entityy(local3\Field2, $00)) Then
                                positionentity(local3\Field2, entityx(local3\Field2, $00), 800.5, entityz(local3\Field2, $00), $00)
                                resetentity(local3\Field2)
                            EndIf
                        EndIf
                    Next
                    For local4 = Each dummy1499_1
                        If (2100.0 > local0\Field4) Then
                            If (local4\Field0 <> 0) Then
                                If (360.5 >= animtime(local4\Field1)) Then
                                    animateex(local4\Field1, animtime(local4\Field1), $141, $169, 0.2, $00)
                                ElseIf (((361.5 < animtime(local4\Field1)) And (401.5 >= animtime(local4\Field1))) <> 0) Then
                                    animateex(local4\Field1, animtime(local4\Field1), $16A, $192, 0.2, $00)
                                Else
                                    local6 = rand($00, $01)
                                    setanimtime(local4\Field1, ((41.0 * (Float local6)) + 321.0), $00)
                                EndIf
                            ElseIf (452.5 >= animtime(local4\Field1)) Then
                                animateex(local4\Field1, animtime(local4\Field1), $19D, $1C5, 0.2, $00)
                            ElseIf (((453.5 < animtime(local4\Field1)) And (497.5 >= animtime(local4\Field1))) <> 0) Then
                                animateex(local4\Field1, animtime(local4\Field1), $1C6, $1F2, 0.2, $00)
                            Else
                                local6 = rand($00, $01)
                                setanimtime(local4\Field1, ((41.0 * (Float local6)) + 413.0), $00)
                            EndIf
                        Else
                            If (local4\Field0 <> 0) Then
                                If (((411.5 >= animtime(local4\Field1)) And (320.5 < animtime(local4\Field1))) <> 0) Then
                                    animateex(local4\Field1, animtime(local4\Field1), $193, $19C, 0.2, $00)
                                Else
                                    animateex(local4\Field1, animtime(local4\Field1), $128, $140, 0.2, $01)
                                EndIf
                            ElseIf (((507.5 >= animtime(local4\Field1)) And (320.5 < animtime(local4\Field1))) <> 0) Then
                                animateex(local4\Field1, animtime(local4\Field1), $1F3, $1FC, 0.2, $00)
                            Else
                                animateex(local4\Field1, animtime(local4\Field1), $128, $140, 0.2, $01)
                            EndIf
                            local13 = createpivot($00)
                            positionentity(local13, entityx(local4\Field1, $00), entityy(local4\Field1, $00), entityz(local4\Field1, $00), $01)
                            pointentity(local13, me\Field60, 0.0)
                            rotateentity(local4\Field1, 0.0, (curveangle(entityyaw(local13, $00), (entityyaw(local4\Field1, $00) - 180.0), 10.0) + 180.0), 0.0, $00)
                            freeentity(local13)
                            local13 = $00
                        EndIf
                    Next
                    If (700.0 > local0\Field4) Then
                        If (8.4375 > (Abs (entityx(me\Field60, $00) - (local0\Field1\Field3 - 0.21875)))) Then
                            If (5.5 > (Abs (entityz(me\Field60, $00) - (local0\Field1\Field5 + 8.933594)))) Then
                                local0\Field4 = (local0\Field4 + fps\Field7[$00])
                            EndIf
                        EndIf
                    ElseIf (((700.0 <= local0\Field4) And (1400.0 > local0\Field4)) <> 0) Then
                        For local10 = $00 To $01 Step $01
                            local0\Field1\Field15[local10]\Field28 = 1.0
                        Next
                        local0\Field4 = 1400.0
                    ElseIf (1400.0 = local0\Field4) Then
                        If (854.5 < local0\Field1\Field15[$00]\Field14) Then
                            For local10 = $02 To $05 Step $01
                                If (local10 = $02) Then
                                    loadnpcsound(local0\Field1\Field15[local10], "SFX\SCP\1499\Triggered.ogg", $00)
                                    local0\Field1\Field15[local10]\Field18 = playsoundex(local0\Field1\Field15[local10]\Field17, camera, local0\Field1\Field15[local10]\Field3, 50.0, 1.0, $00, $00)
                                EndIf
                                local0\Field1\Field15[local10]\Field10 = 1.0
                                setnpcframe(local0\Field1\Field15[local10], 203.0, $01)
                            Next
                            local0\Field4 = 2100.0
                        EndIf
                    EndIf
                    If (local0\Field1\Field15[$00] <> Null) Then
                        If (entityhidden(local0\Field1\Field11[$11]) <> 0) Then
                            showentity(local0\Field1\Field11[$11])
                        EndIf
                        If (2100.0 > local0\Field4) Then
                            shouldplay = $42
                            If (nowplaying = $42) Then
                                If (local0\Field6 = $00) Then
                                    local0\Field9 = loadsound_strict("SFX\Music\HaveMercyOnMe(Choir).ogg")
                                    local0\Field6 = streamsound_strict("SFX\Music\HaveMercyOnMe(NoChoir).ogg", (opt\Field18 * opt\Field16), (1.0 / ∞))
                                    local0\Field11 = $01
                                EndIf
                            EndIf
                            If (local0\Field9 <> $00) Then
                                local0\Field7 = loopsoundex(local0\Field9, local0\Field7, camera, local0\Field1\Field11[$10], 10.0, (opt\Field18 * opt\Field16), $00)
                            EndIf
                        Else
                            shouldplay = $12
                            If (local0\Field6 <> $00) Then
                                stopstream_strict(local0\Field6)
                                local0\Field6 = $00
                                local0\Field11 = $00
                            EndIf
                            If (channelplaying(local0\Field7) <> 0) Then
                                stopchannel(local0\Field7)
                                local0\Field7 = $00
                            EndIf
                            If (local0\Field9 <> $00) Then
                                freesound_strict(local0\Field9)
                                local0\Field9 = $00
                            EndIf
                        EndIf
                    EndIf
                    If (1600.0 < entitydistancesquared(me\Field60, local0\Field1\Field2)) Then
                        For local4 = Each dummy1499_1
                            If (entityhidden(local4\Field1) = $00) Then
                                hideentity(local4\Field1)
                            EndIf
                        Next
                    Else
                        For local4 = Each dummy1499_1
                            If (entityhidden(local4\Field1) <> 0) Then
                                showentity(local4\Field1)
                            EndIf
                        Next
                    EndIf
                Else
                    me\Field36 = 0.0
                EndIf
                playerfallingpickdistance = 0.0
            EndIf
            Exit
        EndIf
    Next
    Return $00
End Function
