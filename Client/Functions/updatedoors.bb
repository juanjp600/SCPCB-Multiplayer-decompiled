Function updatedoors%()
    Local local0%
    Local local1.doors
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15.players
    Local local16#
    Local local17#
    Local local19%
    Local local21#
    Local local22%
    Local local23.particles
    local5 = (hidedistance * 2.0)
    local6 = entityx(camera, $00)
    local7 = entityy(camera, $00)
    local8 = entityz(camera, $00)
    closestbutton = $00
    closestdoor = Null
    If (networkserver\Field15 <> 0) Then
        If (0.0 >= updatedoorstimer) Then
            For local1 = Each doors
                For local15 = Each players
                    local16 = (Abs (entityx(local15\Field13, $00) - entityx(local1\Field0, $01)))
                    local17 = (Abs (entityz(local15\Field13, $00) - entityz(local1\Field0, $01)))
                    local1\Field15 = (local16 + local17)
                    If (local5 > local1\Field15) Then
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
            local16 = (Abs (local6 - entityx(local1\Field0, $01)))
            local17 = (Abs (local8 - entityz(local1\Field0, $01)))
            local1\Field15 = (local16 + local17)
            If (local5 > local1\Field15) Then
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
        If (((local5 > local1\Field15) Or (local1\Field22 > $00)) <> 0) Then
            If (((((180.0 <= local1\Field7) Or (0.0 >= local1\Field7)) And (grabbedentity = $00)) And getmillisecs($00)) <> 0) Then
                For local0 = $00 To $01 Step $01
                    If (local1\Field3[local0] <> $00) Then
                        local9 = entityx(local1\Field3[local0], $01)
                        local10 = entityy(local1\Field3[local0], $01)
                        local11 = entityz(local1\Field3[local0], $01)
                        local12 = (local9 - local6)
                        local14 = (local11 - local8)
                        local13 = (local10 - local7)
                        local4 = (((local12 * local12) + (local13 * local13)) + (local14 * local14))
                        If (0.49 > local4) Then
                            entitypickmode(local1\Field3[local0], $02, $01)
                            If (linepick(local6, local7, local8, local12, local13, local14, 0.0) = local1\Field3[local0]) Then
                                If (closestbutton = $00) Then
                                    closestbutton = local1\Field3[local0]
                                    closestdoor = local1
                                    closestbuttondist = local4
                                ElseIf (closestbuttondist > local4) Then
                                    closestbutton = local1\Field3[local0]
                                    closestdoor = local1
                                    closestbuttondist = local4
                                EndIf
                            EndIf
                            entitypickmode(local1\Field3[local0], $00, $01)
                        EndIf
                    EndIf
                Next
            EndIf
            If (local1\Field5 <> 0) Then
                If (180.0 > local1\Field7) Then
                    Select local1\Field9
                        Case $00
                            local1\Field7 = (((fpsfactor * 2.0) * ((Float local1\Field8) + 1.0)) + local1\Field7)
                            If (180.0 < local1\Field7) Then
                                local1\Field7 = 180.0
                            EndIf
                            moveentity(local1\Field0, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (((Float local1\Field8) * 2.0) + 1.0)) * fpsfactor) * (1.0 / 80.0)), 0.0, 0.0)
                            If (local1\Field1 <> $00) Then
                                moveentity(local1\Field1, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * ((Float local1\Field8) + 1.0)) * fpsfactor) * (1.0 / 80.0)), 0.0, 0.0)
                            EndIf
                        Case $01
                            local1\Field7 = (local1\Field7 + (fpsfactor * 0.8))
                            If (180.0 < local1\Field7) Then
                                local1\Field7 = 180.0
                            EndIf
                            moveentity(local1\Field0, ((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * fpsfactor) * (1.0 / 180.018)), 0.0, 0.0)
                            If (local1\Field1 <> $00) Then
                                moveentity(local1\Field1, (((- ((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728))) * fpsfactor) * (1.0 / 180.018)), 0.0, 0.0)
                            EndIf
                        Case $02
                            local1\Field7 = (((fpsfactor * 2.0) * ((Float local1\Field8) + 1.0)) + local1\Field7)
                            If (180.0 < local1\Field7) Then
                                local1\Field7 = 180.0
                            EndIf
                            moveentity(local1\Field0, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * ((Float local1\Field8) + 1.0)) * fpsfactor) * (1.0 / 85.0051)), 0.0, 0.0)
                            If (local1\Field1 <> $00) Then
                                moveentity(local1\Field1, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (((Float local1\Field8) * 2.0) + 1.0)) * fpsfactor) * 0.008333), 0.0, 0.0)
                            EndIf
                        Case $03
                            local1\Field7 = (((fpsfactor * 2.0) * ((Float local1\Field8) + 1.0)) + local1\Field7)
                            If (180.0 < local1\Field7) Then
                                local1\Field7 = 180.0
                            EndIf
                            moveentity(local1\Field0, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (((Float local1\Field8) * 2.0) + 1.0)) * fpsfactor) * (1.0 / 162.022)), 0.0, 0.0)
                            If (local1\Field1 <> $00) Then
                                moveentity(local1\Field1, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (((Float local1\Field8) * 2.0) + 1.0)) * fpsfactor) * (1.0 / 162.022)), 0.0, 0.0)
                            EndIf
                        Case $04
                            local1\Field7 = (local1\Field7 + (fpsfactor * 1.4))
                            If (180.0 < local1\Field7) Then
                                local1\Field7 = 180.0
                            EndIf
                            moveentity(local1\Field0, ((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * fpsfactor) * 0.008771), 0.0, 0.0)
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
                            local19 = rand($00, $01)
                        Else
                            local19 = rand($00, $02)
                        EndIf
                        If (0.0 = local1\Field11) Then
                            local1\Field5 = (local1\Field5 = $00)
                            local1\Field16 = playsound2(closedoorsfx(local1\Field9, local19), camera, local1\Field0, 10.0, 1.0)
                        EndIf
                    EndIf
                    If ((local1\Field20 And (remotedooron = $01)) <> 0) Then
                        If (2.1 > entitydistance(camera, local1\Field0)) Then
                            If (local1\Field5 <> 0) Then
                                If (wearing714 = $00) Then
                                    playsound_strict(horrorsfx($07))
                                    multiplayer_writesound(horrorsfx($07), 0.0, 0.0, 0.0, 10.0, 1.0)
                                EndIf
                                usedoor(local1, $00, $01, $01, "", $00)
                                local1\Field20 = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            ElseIf (0.0 < local1\Field7) Then
                Select local1\Field9
                    Case $00
                        local1\Field7 = (local1\Field7 - ((fpsfactor * 2.0) * ((Float local1\Field8) + 1.0)))
                        If (0.0 > local1\Field7) Then
                            local1\Field7 = 0.0
                        EndIf
                        moveentity(local1\Field0, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (- fpsfactor)) * ((Float local1\Field8) + 1.0)) * (1.0 / 80.0)), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * ((Float local1\Field8) + 1.0)) * (- fpsfactor)) * (1.0 / 80.0)), 0.0, 0.0)
                        EndIf
                    Case $01
                        local21 = local1\Field7
                        local1\Field7 = (local1\Field7 - (fpsfactor * 0.8))
                        If (0.0 > local1\Field7) Then
                            local1\Field7 = 0.0
                        EndIf
                        moveentity(local1\Field0, ((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (- fpsfactor)) * (1.0 / 180.018)), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, ((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * fpsfactor) * (1.0 / 180.018)), 0.0, 0.0)
                        EndIf
                        If (((15.0 > local1\Field7) And (15.0 <= local21)) <> 0) Then
                            If (particleamount = $02) Then
                                For local0 = $00 To rand($4B, $63) Step $01
                                    local22 = createpivot($00)
                                    positionentity(local22, (entityx(local1\Field2, $01) + rnd(-0.2, 0.2)), (entityy(local1\Field2, $01) + rnd(0.0, 1.2)), (entityz(local1\Field2, $01) + rnd(-0.2, 0.2)), $00)
                                    rotateentity(local22, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                    local23 = createparticle(entityx(local22, $00), entityy(local22, $00), entityz(local22, $00), $02, 0.002, 0.0, $12C, 1.0, $01)
                                    local23\Field6 = 0.005
                                    rotateentity(local23\Field1, rnd(-20.0, 20.0), rnd(360.0, 0.0), 0.0, $00)
                                    local23\Field13 = -0.00001
                                    local23\Field4 = 0.01
                                    scalesprite(local23\Field0, local23\Field4, local23\Field4)
                                    local23\Field12 = -0.01
                                    entityorder(local23\Field0, $FFFFFFFF)
                                    freeentity(local22)
                                Next
                            EndIf
                        EndIf
                    Case $02
                        local1\Field7 = (local1\Field7 - ((fpsfactor * 2.0) * ((Float local1\Field8) + 1.0)))
                        If (0.0 > local1\Field7) Then
                            local1\Field7 = 0.0
                        EndIf
                        moveentity(local1\Field0, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (- fpsfactor)) * ((Float local1\Field8) + 1.0)) * (1.0 / 85.0051)), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * ((Float local1\Field8) + 1.0)) * (- fpsfactor)) * 0.008333), 0.0, 0.0)
                        EndIf
                    Case $03
                        local1\Field7 = (local1\Field7 - ((fpsfactor * 2.0) * ((Float local1\Field8) + 1.0)))
                        If (0.0 > local1\Field7) Then
                            local1\Field7 = 0.0
                        EndIf
                        moveentity(local1\Field0, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (- fpsfactor)) * ((Float local1\Field8) + 1.0)) * (1.0 / 162.022)), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, (((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * ((Float local1\Field8) + 1.0)) * (- fpsfactor)) * (1.0 / 162.022)), 0.0, 0.0)
                        EndIf
                    Case $04
                        local1\Field7 = (local1\Field7 - (fpsfactor * 1.4))
                        If (0.0 > local1\Field7) Then
                            local1\Field7 = 0.0
                        EndIf
                        moveentity(local1\Field0, ((((local1\Field7 * (180.0 - local1\Field7)) * (1.0 / 8103.728)) * (- fpsfactor)) * 0.008771), 0.0, 0.0)
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
                If (local1\Field25 <> $00) Then
                    showentity(local1\Field25)
                EndIf
            Else
                local1\Field8 = $00
                positionentity(local1\Field0, entityx(local1\Field2, $01), entityy(local1\Field2, $01), entityz(local1\Field2, $01), $00)
                If (local1\Field1 <> $00) Then
                    positionentity(local1\Field1, entityx(local1\Field2, $01), entityy(local1\Field2, $01), entityz(local1\Field2, $01), $00)
                EndIf
                If (((local1\Field1 <> $00) And (local1\Field9 = $00)) <> 0) Then
                    moveentity(local1\Field0, 0.0, 0.0, (1.0 / 32.0))
                    moveentity(local1\Field1, 0.0, 0.0, (1.0 / 32.0))
                EndIf
                If (local1\Field25 <> $00) Then
                    hideentity(local1\Field25)
                EndIf
            EndIf
        EndIf
        updatesoundorigin(local1\Field16, camera, local1\Field2, 10.0, 1.0)
        If (local1\Field4 <> 0) Then
            If (getentitytype(local1\Field0) = $0B) Then
                If (local1\Field2 <> $00) Then
                    If (getentitytype(local1\Field2) = $0B) Then
                        entitytype(local1\Field2, $01, $00)
                    EndIf
                EndIf
                If (local1\Field25 <> $00) Then
                    If (getentitytype(local1\Field25) = $0B) Then
                        entitytype(local1\Field25, $01, $00)
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
            If (local1\Field25 <> $00) Then
                If (getentitytype(local1\Field25) = $01) Then
                    entitytype(local1\Field25, $0B, $00)
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
