Function updatedoors%()
    Local local0%
    Local local1.doors
    Local local2#
    Local local3#
    Local local4#
    Local local5.players
    Local local6#
    Local local7#
    Local local8%
    Local local10%
    Local local12%
    Local local13.particles
    closestbutton = $00
    closestdoor = Null
    If (networkserver\Field18 <> 0) Then
        If (0.0 >= updatedoorstimer) Then
            For local1 = Each doors
                For local5 = Each players
                    local6 = (Abs (entityx(local5\Field13, $00) - entityx(local1\Field0, $01)))
                    local7 = (Abs (entityz(local5\Field13, $00) - entityz(local1\Field0, $01)))
                    local1\Field15 = (local6 + local7)
                    If ((hidedistance * 2.0) > local1\Field15) Then
                        If (local1\Field0 <> $00) Then
                            showentity(local1\Field0)
                        EndIf
                        If (local1\Field2 <> $00) Then
                            showentity(local1\Field2)
                        EndIf
                        If (local1\Field1 <> $00) Then
                            showentity(local1\Field1)
                        EndIf
                        If (local1\Field3[$00] <> $00) Then
                            showentity(local1\Field3[$00])
                        EndIf
                        If (local1\Field3[$01] <> $00) Then
                            showentity(local1\Field3[$01])
                        EndIf
                        Exit
                    Else
                        If (local1\Field0 <> $00) Then
                            hideentity(local1\Field0)
                        EndIf
                        If (local1\Field2 <> $00) Then
                            hideentity(local1\Field2)
                        EndIf
                        If (local1\Field1 <> $00) Then
                            hideentity(local1\Field1)
                        EndIf
                        If (local1\Field3[$00] <> $00) Then
                            hideentity(local1\Field3[$00])
                        EndIf
                        If (local1\Field3[$01] <> $00) Then
                            hideentity(local1\Field3[$01])
                        EndIf
                    EndIf
                Next
            Next
            updatedoorstimer = 30.0
        Else
            updatedoorstimer = max((updatedoorstimer - fpsfactor), 0.0)
        EndIf
    ElseIf (0.0 >= updatedoorstimer) Then
        For local1 = Each doors
            local6 = (Abs (entityx(collider, $00) - entityx(local1\Field0, $01)))
            local7 = (Abs (entityz(collider, $00) - entityz(local1\Field0, $01)))
            local1\Field15 = (local6 + local7)
            If ((hidedistance * 2.0) > local1\Field15) Then
                If (local1\Field0 <> $00) Then
                    showentity(local1\Field0)
                EndIf
                If (local1\Field2 <> $00) Then
                    showentity(local1\Field2)
                EndIf
                If (local1\Field1 <> $00) Then
                    showentity(local1\Field1)
                EndIf
                If (local1\Field3[$00] <> $00) Then
                    showentity(local1\Field3[$00])
                EndIf
                If (local1\Field3[$01] <> $00) Then
                    showentity(local1\Field3[$01])
                EndIf
            Else
                If (local1\Field0 <> $00) Then
                    hideentity(local1\Field0)
                EndIf
                If (local1\Field2 <> $00) Then
                    hideentity(local1\Field2)
                EndIf
                If (local1\Field1 <> $00) Then
                    hideentity(local1\Field1)
                EndIf
                If (local1\Field3[$00] <> $00) Then
                    hideentity(local1\Field3[$00])
                EndIf
                If (local1\Field3[$01] <> $00) Then
                    hideentity(local1\Field3[$01])
                EndIf
            EndIf
        Next
        updatedoorstimer = 30.0
    Else
        updatedoorstimer = max((updatedoorstimer - fpsfactor), 0.0)
    EndIf
    For local1 = Each doors
        If ((((hidedistance * 2.0) > local1\Field15) Or (local1\Field23 > $00)) <> 0) Then
            If (((((180.0 <= local1\Field7) Or (0.0 >= local1\Field7)) And (grabbedentity = $00)) And getmillisecs($00)) <> 0) Then
                For local0 = $00 To $01 Step $01
                    If (local1\Field3[local0] <> $00) Then
                        If (1.0 > (Abs (entityx(collider, $00) - entityx(local1\Field3[local0], $01)))) Then
                            If (1.0 > (Abs (entityz(collider, $00) - entityz(local1\Field3[local0], $01)))) Then
                                local4 = distance(entityx(collider, $01), entityz(collider, $01), entityx(local1\Field3[local0], $01), entityz(local1\Field3[local0], $01))
                                If (0.7 > local4) Then
                                    entitypickmode(local1\Field3[local0], $02, $01)
                                    local8 = createpivot($00)
                                    positionentity(local8, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local8, local1\Field3[local0], 0.0)
                                    If (entitypick(local8, 0.6) = local1\Field3[local0]) Then
                                        If (closestbutton = $00) Then
                                            closestbutton = local1\Field3[local0]
                                            closestdoor = local1
                                        ElseIf (local4 < entitydistance(collider, closestbutton)) Then
                                            closestbutton = local1\Field3[local0]
                                            closestdoor = local1
                                        EndIf
                                    EndIf
                                    entitypickmode(local1\Field3[local0], $00, $01)
                                    freeentity(local8)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
            If (local1\Field5 <> 0) Then
                If (180.0 > local1\Field7) Then
                    Select local1\Field9
                        Case $00
                            local1\Field7 = min(180.0, (((fpsfactor * 2.0) * (Float (local1\Field8 + $01))) + local1\Field7))
                            moveentity(local1\Field0, (((sin(local1\Field7) * (Float ((local1\Field8 Shl $01) + $01))) * fpsfactor) / 80.0), 0.0, 0.0)
                            If (local1\Field1 <> $00) Then
                                moveentity(local1\Field1, (((sin(local1\Field7) * (Float (local1\Field8 + $01))) * fpsfactor) / 80.0), 0.0, 0.0)
                            EndIf
                        Case $01
                            local1\Field7 = min(180.0, (local1\Field7 + (fpsfactor * 0.8)))
                            moveentity(local1\Field0, ((sin(local1\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                            If (local1\Field1 <> $00) Then
                                moveentity(local1\Field1, (((- sin(local1\Field7)) * fpsfactor) / 180.0), 0.0, 0.0)
                            EndIf
                        Case $02
                            local1\Field7 = min(180.0, (((fpsfactor * 2.0) * (Float (local1\Field8 + $01))) + local1\Field7))
                            moveentity(local1\Field0, (((sin(local1\Field7) * (Float (local1\Field8 + $01))) * fpsfactor) / 85.0), 0.0, 0.0)
                            If (local1\Field1 <> $00) Then
                                moveentity(local1\Field1, (((sin(local1\Field7) * (Float ((local1\Field8 Shl $01) + $01))) * fpsfactor) / 120.0), 0.0, 0.0)
                            EndIf
                        Case $03
                            local1\Field7 = min(180.0, (((fpsfactor * 2.0) * (Float (local1\Field8 + $01))) + local1\Field7))
                            moveentity(local1\Field0, (((sin(local1\Field7) * (Float ((local1\Field8 Shl $01) + $01))) * fpsfactor) / 162.0), 0.0, 0.0)
                            If (local1\Field1 <> $00) Then
                                moveentity(local1\Field1, (((sin(local1\Field7) * (Float ((local1\Field8 Shl $01) + $01))) * fpsfactor) / 162.0), 0.0, 0.0)
                            EndIf
                        Case $04
                            local1\Field7 = min(180.0, (local1\Field7 + (fpsfactor * 1.4)))
                            moveentity(local1\Field0, ((sin(local1\Field7) * fpsfactor) / 114.0), 0.0, 0.0)
                    End Select
                Else
                    local1\Field8 = $00
                    resetentity(local1\Field0)
                    If (local1\Field1 <> $00) Then
                        resetentity(local1\Field1)
                    EndIf
                    If (0.0 < local1\Field11) Then
                        local1\Field11 = max(0.0, (local1\Field11 - fpsfactor))
                        If (((110.0 < (local1\Field11 + fpsfactor)) And (110.0 >= local1\Field11)) <> 0) Then
                            local1\Field16 = playsound2(cautionsfx, camera, local1\Field0, 10.0, 1.0)
                        EndIf
                        If (local1\Field9 = $01) Then
                            local10 = rand($00, $01)
                        Else
                            local10 = rand($00, $02)
                        EndIf
                        If (0.0 = local1\Field11) Then
                            local1\Field5 = (local1\Field5 = $00)
                            local1\Field16 = playsound2(closedoorsfx(local1\Field9, local10), camera, local1\Field0, 10.0, 1.0)
                        EndIf
                    EndIf
                    If ((local1\Field21 And (remotedooron = $01)) <> 0) Then
                        If (2.1 > entitydistance(camera, local1\Field0)) Then
                            If (local1\Field5 <> 0) Then
                                If (wearing714 = $00) Then
                                    playsound_strict(horrorsfx($07))
                                    multiplayer_writesound(horrorsfx($07), 0.0, 0.0, 0.0, 10.0, 1.0)
                                EndIf
                                usedoor(local1, $00, $01, $01, "", $00)
                                local1\Field21 = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            ElseIf (0.0 < local1\Field7) Then
                Select local1\Field9
                    Case $00
                        local1\Field7 = max(0.0, (local1\Field7 - ((fpsfactor * 2.0) * (Float (local1\Field8 + $01)))))
                        moveentity(local1\Field0, (((sin(local1\Field7) * (- fpsfactor)) * (Float (local1\Field8 + $01))) / 80.0), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, (((sin(local1\Field7) * (Float (local1\Field8 + $01))) * (- fpsfactor)) / 80.0), 0.0, 0.0)
                        EndIf
                    Case $01
                        local1\Field7 = max(0.0, (local1\Field7 - (fpsfactor * 0.8)))
                        moveentity(local1\Field0, ((sin(local1\Field7) * (- fpsfactor)) / 180.0), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, ((sin(local1\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                        EndIf
                        If (((15.0 > local1\Field7) And (15.0 <= (local1\Field7 + fpsfactor))) <> 0) Then
                            If (particleamount = $02) Then
                                For local0 = $00 To rand($4B, $63) Step $01
                                    local12 = createpivot($00)
                                    positionentity(local12, (entityx(local1\Field2, $01) + rnd(-0.2, 0.2)), (entityy(local1\Field2, $01) + rnd(0.0, 1.2)), (entityz(local1\Field2, $01) + rnd(-0.2, 0.2)), $00)
                                    rotateentity(local12, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                    local13 = createparticle(entityx(local12, $00), entityy(local12, $00), entityz(local12, $00), $02, 0.002, 0.0, $12C)
                                    local13\Field9 = 0.005
                                    rotateentity(local13\Field1, rnd(-20.0, 20.0), rnd(360.0, 0.0), 0.0, $00)
                                    local13\Field16 = -0.00001
                                    local13\Field7 = 0.01
                                    scalesprite(local13\Field0, local13\Field7, local13\Field7)
                                    local13\Field15 = -0.01
                                    entityorder(local13\Field0, $FFFFFFFF)
                                    freeentity(local12)
                                Next
                            EndIf
                        EndIf
                    Case $02
                        local1\Field7 = max(0.0, (local1\Field7 - ((fpsfactor * 2.0) * (Float (local1\Field8 + $01)))))
                        moveentity(local1\Field0, (((sin(local1\Field7) * (- fpsfactor)) * (Float (local1\Field8 + $01))) / 85.0), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, (((sin(local1\Field7) * (Float (local1\Field8 + $01))) * (- fpsfactor)) / 120.0), 0.0, 0.0)
                        EndIf
                    Case $03
                        local1\Field7 = max(0.0, (local1\Field7 - ((fpsfactor * 2.0) * (Float (local1\Field8 + $01)))))
                        moveentity(local1\Field0, (((sin(local1\Field7) * (- fpsfactor)) * (Float (local1\Field8 + $01))) / 162.0), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, (((sin(local1\Field7) * (Float (local1\Field8 + $01))) * (- fpsfactor)) / 162.0), 0.0, 0.0)
                        EndIf
                    Case $04
                        local1\Field7 = min(180.0, (local1\Field7 - (fpsfactor * 1.4)))
                        moveentity(local1\Field0, ((sin(local1\Field7) * (- fpsfactor)) / 114.0), 0.0, 0.0)
                End Select
                If (((local1\Field6 = $00) Or (local1\Field6 = $B4)) <> 0) Then
                    If (0.15 > (Abs (entityz(local1\Field2, $01) - entityz(collider, $00)))) Then
                        If (((Float ((local1\Field9 Shl $01) + $01)) * 0.7) > (Abs (entityx(local1\Field2, $01) - entityx(collider, $00)))) Then
                            local3 = curvevalue((((Sgn (entityz(collider, $00) - entityz(local1\Field2, $01))) * 0.15) + entityz(local1\Field2, $01)), entityz(collider, $00), 5.0)
                            positionentity(collider, entityx(collider, $00), entityy(collider, $00), local3, $00)
                        EndIf
                    EndIf
                ElseIf (0.15 > (Abs (entityx(local1\Field2, $01) - entityx(collider, $00)))) Then
                    If (((Float ((local1\Field9 Shl $01) + $01)) * 0.7) > (Abs (entityz(local1\Field2, $01) - entityz(collider, $00)))) Then
                        local2 = curvevalue((((Sgn (entityx(collider, $00) - entityx(local1\Field2, $01))) * 0.15) + entityx(local1\Field2, $01)), entityx(collider, $00), 5.0)
                        positionentity(collider, local2, entityy(collider, $00), entityz(collider, $00), $00)
                    EndIf
                EndIf
                If (local1\Field26 <> $00) Then
                    showentity(local1\Field26)
                EndIf
            Else
                local1\Field8 = $00
                positionentity(local1\Field0, entityx(local1\Field2, $01), entityy(local1\Field2, $01), entityz(local1\Field2, $01), $00)
                If (local1\Field1 <> $00) Then
                    positionentity(local1\Field1, entityx(local1\Field2, $01), entityy(local1\Field2, $01), entityz(local1\Field2, $01), $00)
                EndIf
                If (((local1\Field1 <> $00) And (local1\Field9 = $00)) <> 0) Then
                    moveentity(local1\Field0, 0.0, 0.0, (8.0 * roomscale))
                    moveentity(local1\Field1, 0.0, 0.0, (8.0 * roomscale))
                EndIf
                If (local1\Field26 <> $00) Then
                    hideentity(local1\Field26)
                EndIf
            EndIf
        EndIf
        updatesoundorigin(local1\Field16, camera, local1\Field2, 10.0, 1.0)
        If (local1\Field26 <> $00) Then
            If (debughud <> 0) Then
                entityalpha(local1\Field26, 0.5)
            Else
                entityalpha(local1\Field26, 0.0)
            EndIf
        EndIf
        If (local1\Field4 <> 0) Then
            If (getentitytype(local1\Field0) = $0B) Then
                If (local1\Field2 <> $00) Then
                    If (getentitytype(local1\Field2) = $0B) Then
                        entitytype(local1\Field2, $01, $00)
                    EndIf
                EndIf
                If (local1\Field26 <> $00) Then
                    If (getentitytype(local1\Field26) = $0B) Then
                        entitytype(local1\Field26, $01, $00)
                    EndIf
                EndIf
                entitytype(local1\Field0, $01, $00)
                If (local1\Field1 <> $00) Then
                    entitytype(local1\Field1, $01, $00)
                EndIf
            EndIf
        ElseIf (getentitytype(local1\Field0) = $01) Then
            If (local1\Field2 <> $00) Then
                If (getentitytype(local1\Field2) = $01) Then
                    entitytype(local1\Field2, $0B, $00)
                EndIf
            EndIf
            If (local1\Field26 <> $00) Then
                If (getentitytype(local1\Field26) = $01) Then
                    entitytype(local1\Field26, $0B, $00)
                EndIf
            EndIf
            entitytype(local1\Field0, $0B, $00)
            If (local1\Field1 <> $00) Then
                entitytype(local1\Field1, $0B, $00)
            EndIf
        EndIf
    Next
    Return $00
End Function
