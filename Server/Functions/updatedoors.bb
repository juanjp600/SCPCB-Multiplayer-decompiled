Function updatedoors%()
    Local local0.doors
    Local local2%
    Local local4#
    Local local5#
    For local0 = Each doors
        If (((local0\Field13\Field73 = $00) And (local0\Field23 = $00)) <> 0) Then
            If (local0\Field0 <> $00) Then
                hideentity(local0\Field0)
            EndIf
            If (local0\Field2 <> $00) Then
                hideentity(local0\Field2)
            EndIf
            If (local0\Field1 <> $00) Then
                hideentity(local0\Field1)
            EndIf
            If (local0\Field3[$00] <> $00) Then
                hideentity(local0\Field3[$00])
            EndIf
            If (local0\Field3[$01] <> $00) Then
                hideentity(local0\Field3[$01])
            EndIf
        Else
            If (local0\Field13\Field73 <> 0) Then
                If (local0\Field0 <> $00) Then
                    showentity(local0\Field0)
                EndIf
                If (local0\Field2 <> $00) Then
                    showentity(local0\Field2)
                EndIf
                If (local0\Field1 <> $00) Then
                    showentity(local0\Field1)
                EndIf
                If (local0\Field3[$00] <> $00) Then
                    showentity(local0\Field3[$00])
                EndIf
                If (local0\Field3[$01] <> $00) Then
                    showentity(local0\Field3[$01])
                EndIf
            Else
                If (local0\Field0 <> $00) Then
                    hideentity(local0\Field0)
                EndIf
                If (local0\Field2 <> $00) Then
                    hideentity(local0\Field2)
                EndIf
                If (local0\Field1 <> $00) Then
                    hideentity(local0\Field1)
                EndIf
                If (local0\Field3[$00] <> $00) Then
                    hideentity(local0\Field3[$00])
                EndIf
                If (local0\Field3[$01] <> $00) Then
                    hideentity(local0\Field3[$01])
                EndIf
            EndIf
            If (local0\Field5 <> 0) Then
                If (180.0 > local0\Field7) Then
                    Select local0\Field9
                        Case $00
                            local0\Field7 = min(180.0, (((fpsfactor * 2.0) * (Float (local0\Field8 + $01))) + local0\Field7))
                            moveentity(local0\Field0, (((sin(local0\Field7) * (Float ((local0\Field8 Shl $01) + $01))) * fpsfactor) / 80.0), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (((sin(local0\Field7) * (Float (local0\Field8 + $01))) * fpsfactor) / 80.0), 0.0, 0.0)
                            EndIf
                        Case $01
                            local0\Field7 = min(180.0, (local0\Field7 + (fpsfactor * 0.8)))
                            moveentity(local0\Field0, ((sin(local0\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (((- sin(local0\Field7)) * fpsfactor) / 180.0), 0.0, 0.0)
                            EndIf
                        Case $02
                            local0\Field7 = min(180.0, (((fpsfactor * 2.0) * (Float (local0\Field8 + $01))) + local0\Field7))
                            moveentity(local0\Field0, (((sin(local0\Field7) * (Float (local0\Field8 + $01))) * fpsfactor) / 85.0), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (((sin(local0\Field7) * (Float ((local0\Field8 Shl $01) + $01))) * fpsfactor) / 120.0), 0.0, 0.0)
                            EndIf
                        Case $03
                            local0\Field7 = min(180.0, (((fpsfactor * 2.0) * (Float (local0\Field8 + $01))) + local0\Field7))
                            moveentity(local0\Field0, (((sin(local0\Field7) * (Float ((local0\Field8 Shl $01) + $01))) * fpsfactor) / 162.0), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (((sin(local0\Field7) * (Float ((local0\Field8 Shl $01) + $01))) * fpsfactor) / 162.0), 0.0, 0.0)
                            EndIf
                        Case $04
                            local0\Field7 = min(180.0, (local0\Field7 + (fpsfactor * 1.4)))
                            moveentity(local0\Field0, ((sin(local0\Field7) * fpsfactor) / 114.0), 0.0, 0.0)
                    End Select
                Else
                    local0\Field8 = $00
                    resetentity(local0\Field0)
                    If (local0\Field1 <> $00) Then
                        resetentity(local0\Field1)
                    EndIf
                    If (0.0 < local0\Field11) Then
                        local0\Field11 = max(0.0, (local0\Field11 - fpsfactor))
                        If (((110.0 < (local0\Field11 + fpsfactor)) And (110.0 >= local0\Field11)) <> 0) Then
                            local0\Field16 = playsound2(cautionsfx, camera, local0\Field0, 10.0, 1.0)
                        EndIf
                        If (local0\Field9 = $01) Then
                            local2 = rand($00, $01)
                        Else
                            local2 = rand($00, $02)
                        EndIf
                        If (0.0 = local0\Field11) Then
                            local0\Field5 = (local0\Field5 = $00)
                            local0\Field16 = playsound2(closedoorsfx(local0\Field9, local2), camera, local0\Field0, 10.0, 1.0)
                        EndIf
                    EndIf
                    If ((local0\Field21 And (remotedooron = $01)) <> 0) Then
                        If (2.1 > entitydistance(camera, local0\Field0)) Then
                            If (wearing714 = $00) Then
                                playsound_strict(horrorsfx($07))
                            EndIf
                            local0\Field5 = $00
                            local0\Field16 = playsound2(closedoorsfx((Int min((Float local0\Field9), 1.0)), rand($00, $02)), camera, local0\Field0, 10.0, 1.0)
                            local0\Field21 = $00
                        EndIf
                    EndIf
                EndIf
            ElseIf (0.0 < local0\Field7) Then
                Select local0\Field9
                    Case $00
                        local0\Field7 = max(0.0, (local0\Field7 - ((fpsfactor * 2.0) * (Float (local0\Field8 + $01)))))
                        moveentity(local0\Field0, (((sin(local0\Field7) * (- fpsfactor)) * (Float (local0\Field8 + $01))) / 80.0), 0.0, 0.0)
                        If (local0\Field1 <> $00) Then
                            moveentity(local0\Field1, (((sin(local0\Field7) * (Float (local0\Field8 + $01))) * (- fpsfactor)) / 80.0), 0.0, 0.0)
                        EndIf
                    Case $01
                        local0\Field7 = max(0.0, (local0\Field7 - (fpsfactor * 0.8)))
                        moveentity(local0\Field0, ((sin(local0\Field7) * (- fpsfactor)) / 180.0), 0.0, 0.0)
                        If (local0\Field1 <> $00) Then
                            moveentity(local0\Field1, ((sin(local0\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                        EndIf
                        If (((15.0 > local0\Field7) And (15.0 <= (local0\Field7 + fpsfactor))) <> 0) Then
                        EndIf
                    Case $02
                        local0\Field7 = max(0.0, (local0\Field7 - ((fpsfactor * 2.0) * (Float (local0\Field8 + $01)))))
                        moveentity(local0\Field0, (((sin(local0\Field7) * (- fpsfactor)) * (Float (local0\Field8 + $01))) / 85.0), 0.0, 0.0)
                        If (local0\Field1 <> $00) Then
                            moveentity(local0\Field1, (((sin(local0\Field7) * (Float (local0\Field8 + $01))) * (- fpsfactor)) / 120.0), 0.0, 0.0)
                        EndIf
                    Case $03
                        local0\Field7 = max(0.0, (local0\Field7 - ((fpsfactor * 2.0) * (Float (local0\Field8 + $01)))))
                        moveentity(local0\Field0, (((sin(local0\Field7) * (- fpsfactor)) * (Float (local0\Field8 + $01))) / 162.0), 0.0, 0.0)
                        If (local0\Field1 <> $00) Then
                            moveentity(local0\Field1, (((sin(local0\Field7) * (Float (local0\Field8 + $01))) * (- fpsfactor)) / 162.0), 0.0, 0.0)
                        EndIf
                    Case $04
                        local0\Field7 = min(180.0, (local0\Field7 - (fpsfactor * 1.4)))
                        moveentity(local0\Field0, ((sin(local0\Field7) * (- fpsfactor)) / 114.0), 0.0, 0.0)
                End Select
                If (((local0\Field6 = $00) Or (local0\Field6 = $B4)) <> 0) Then
                    If (0.15 > (Abs (entityz(local0\Field2, $01) - entityz(collider, $00)))) Then
                        If (((Float ((local0\Field9 Shl $01) + $01)) * 0.7) > (Abs (entityx(local0\Field2, $01) - entityx(collider, $00)))) Then
                            local4 = curvevalue((((Sgn (entityz(collider, $00) - entityz(local0\Field2, $01))) * 0.15) + entityz(local0\Field2, $01)), entityz(collider, $00), 5.0)
                            positionentity(collider, entityx(collider, $00), entityy(collider, $00), local4, $00)
                        EndIf
                    EndIf
                ElseIf (0.15 > (Abs (entityx(local0\Field2, $01) - entityx(collider, $00)))) Then
                    If (((Float ((local0\Field9 Shl $01) + $01)) * 0.7) > (Abs (entityz(local0\Field2, $01) - entityz(collider, $00)))) Then
                        local5 = curvevalue((((Sgn (entityx(collider, $00) - entityx(local0\Field2, $01))) * 0.15) + entityx(local0\Field2, $01)), entityx(collider, $00), 5.0)
                        positionentity(collider, local5, entityy(collider, $00), entityz(collider, $00), $00)
                    EndIf
                EndIf
                If (local0\Field26 <> $00) Then
                    showentity(local0\Field26)
                EndIf
            Else
                local0\Field8 = $00
                positionentity(local0\Field0, entityx(local0\Field2, $01), entityy(local0\Field2, $01), entityz(local0\Field2, $01), $00)
                If (local0\Field1 <> $00) Then
                    positionentity(local0\Field1, entityx(local0\Field2, $01), entityy(local0\Field2, $01), entityz(local0\Field2, $01), $00)
                EndIf
                If (((local0\Field1 <> $00) And (local0\Field9 = $00)) <> 0) Then
                    moveentity(local0\Field0, 0.0, 0.0, (8.0 * roomscale))
                    moveentity(local0\Field1, 0.0, 0.0, (8.0 * roomscale))
                EndIf
                If (local0\Field26 <> $00) Then
                    hideentity(local0\Field26)
                EndIf
            EndIf
            If (local0\Field4 <> 0) Then
                If (getentitytype(local0\Field0) = $0B) Then
                    If (local0\Field2 <> $00) Then
                        If (getentitytype(local0\Field2) = $0B) Then
                            entitytype(local0\Field2, $01, $00)
                        EndIf
                    EndIf
                    If (local0\Field26 <> $00) Then
                        If (getentitytype(local0\Field26) = $0B) Then
                            entitytype(local0\Field26, $01, $00)
                        EndIf
                    EndIf
                    entitytype(local0\Field0, $01, $00)
                    If (local0\Field1 <> $00) Then
                        entitytype(local0\Field1, $01, $00)
                    EndIf
                EndIf
            ElseIf (getentitytype(local0\Field0) = $01) Then
                If (local0\Field2 <> $00) Then
                    If (getentitytype(local0\Field2) = $01) Then
                        entitytype(local0\Field2, $0B, $00)
                    EndIf
                EndIf
                If (local0\Field26 <> $00) Then
                    If (getentitytype(local0\Field26) = $01) Then
                        entitytype(local0\Field26, $0B, $00)
                    EndIf
                EndIf
                entitytype(local0\Field0, $0B, $00)
                If (local0\Field1 <> $00) Then
                    entitytype(local0\Field1, $0B, $00)
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
