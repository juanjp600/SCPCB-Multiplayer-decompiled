Function updategrenades%()
    Local local0%
    Local local1.grenades
    Local local2%
    Local local3.players
    Local local4#
    Local local5%
    Local local6.npcs
    Local local7#
    For local1 = Each grenades
        local1\Field11 = (local1\Field11 + fpsfactor)
        If (259.0 < local1\Field11) Then
            For local3 = Each players
                If ((((3.0 > entitydistance(local1\Field2, local3\Field62)) And (local3\Field36 <> $00)) And (local3\Field59 = $00)) <> 0) Then
                    local2 = $01
                    If ((multiplayer_isafriend(local1\Field16, local3\Field36) And (server\Field85 = $00)) <> 0) Then
                        local2 = $00
                    EndIf
                    If (local2 <> 0) Then
                        local0 = entityvisible(local3\Field62, local1\Field2)
                        If (local0 = $00) Then
                            local0 = entityvisible(local3\Field69, local1\Field2)
                        EndIf
                        If (local0 = $00) Then
                            local0 = entityvisible(local3\Field64, local1\Field2)
                        EndIf
                        If (local0 <> 0) Then
                            local4 = max(0.0, ((7.0 * getgundamage($0D)) - (entitydistance(local3\Field62, local1\Field2) * 20.0)))
                            giveplayerhealth(local3\Field30, (- local4), ("was killed by explosion by " + player[local1\Field14]\Field15))
                            local5 = public_inqueue($12, $00)
                            public_addparam(local5, (Str local1\Field14), $01)
                            public_addparam(local5, (Str local3\Field30), $01)
                            public_addparam(local5, (Str local4), $02)
                            public_addparam(local5, (Str player[local1\Field14]\Field35), $01)
                            callback($00)
                        EndIf
                    EndIf
                EndIf
            Next
            For local6 = Each npcs
                If (local6\Field48 = $00) Then
                    If (((local6\Field5 = $0B) Or (local6\Field5 = $15)) <> 0) Then
                        If (5.0 > entitydistance(local6\Field4, local1\Field2)) Then
                            local6\Field59 = (Int ((Float (local6\Field59 - $23)) - (entitydistance(local6\Field4, local1\Field2) * 5.0)))
                            If (local6\Field59 < $01) Then
                                local6\Field48 = $01
                            EndIf
                        EndIf
                    EndIf
                    If (local6\Field5 = $02) Then
                        If (3.0 > entitydistance(local6\Field4, local1\Field2)) Then
                            local6\Field9 = (Float rand($55F0, $6978))
                            positionentity(local6\Field4, 0.0, 500.0, 0.0, $00)
                        EndIf
                    EndIf
                EndIf
            Next
            freeentity(local1\Field2)
            Delete local1
        ElseIf (0.01 < local1\Field3) Then
            If (countcollisions(local1\Field2) <> $00) Then
                If (1.0 = (Abs collisionny(local1\Field2, $01))) Then
                    rotateentity(local1\Field2, flipangle(entitypitch(local1\Field2, $00)), entityyaw(local1\Field2, $00), entityroll(local1\Field2, $00), $00)
                    local1\Field15 = 0.0
                Else
                    rotateentity(local1\Field2, entitypitch(local1\Field2, $00), bouncewall(vectoryaw(collisionnx(local1\Field2, $01), 0.0, (- collisionnz(local1\Field2, $01))), entityyaw(local1\Field2, $00)), entityroll(local1\Field2, $00), $00)
                EndIf
                local1\Field3 = (local1\Field3 * 0.65)
            Else
                moveentity(local1\Field2, 0.0, 0.0, (local1\Field3 * fpsfactor))
                translateentity(local1\Field2, 0.0, (local1\Field15 * fpsfactor), 0.0, $00)
                local1\Field15 = max((local1\Field15 - (0.001 * fpsfactor)), -0.2)
                If (90.0 > entitypitch(local1\Field2, $00)) Then
                    rotateentity(local1\Field2, wrapangle((entitypitch(local1\Field2, $00) + (0.8 * fpsfactor))), entityyaw(local1\Field2, $00), wrapangle((entityroll(local1\Field2, $00) + ((local1\Field3 * 24.0) * fpsfactor))), $00)
                Else
                    rotateentity(local1\Field2, entitypitch(local1\Field2, $00), entityyaw(local1\Field2, $00), wrapangle((entityroll(local1\Field2, $00) + ((local1\Field3 * 24.0) * fpsfactor))), $00)
                EndIf
            EndIf
        Else
            local1\Field3 = max((local1\Field3 - (0.0001 * fpsfactor)), 0.0)
            local7 = entitypitch(local1\Field2, $00)
            rotateentity(local1\Field2, 0.0, entityyaw(local1\Field2, $00), curvevalue(90.0, entityroll(local1\Field2, $00), 15.0), $00)
            moveentity(local1\Field2, 0.0, 0.0, (local1\Field3 * fpsfactor))
            rotateentity(local1\Field2, wrapangle((((local1\Field3 * 24.0) * fpsfactor) + local7)), entityyaw(local1\Field2, $00), curvevalue(90.0, entityroll(local1\Field2, $00), 15.0), $00)
            translateentity(local1\Field2, 0.0, (local1\Field15 * fpsfactor), 0.0, $00)
            local1\Field15 = max((local1\Field15 - (0.001 * fpsfactor)), -0.2)
        EndIf
    Next
    Return $00
End Function
