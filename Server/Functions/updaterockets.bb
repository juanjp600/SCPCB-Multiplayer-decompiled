Function updaterockets%()
    Local local0%
    Local local1%
    Local local2.rockets
    Local local3%
    Local local4.players
    Local local5#
    Local local6%
    Local local7.npcs
    For local2 = Each rockets
        local2\Field3 = curvevalue(15.0, local2\Field3, 3000.0)
        moveentity(local2\Field1, 0.0, 0.0, (local2\Field3 * fpsfactor))
        rotateentity(local2\Field1, wrapangle((entitypitch(local2\Field1, $00) + (0.05 * fpsfactor))), entityyaw(local2\Field1, $00), entityroll(local2\Field1, $00), $00)
        local2\Field10 = (local2\Field10 + fpsfactor)
        local1 = local2\Field11
        entitypickmode(player[local1]\Field69, $00, $00)
        local3 = $00
        If ((entitypick(local2\Field1, 1.0) Or (400.0 < local2\Field10)) <> 0) Then
            For local4 = Each players
                If ((((3.0 > entitydistance(local2\Field1, local4\Field62)) And (local4\Field36 <> $00)) And (local4\Field59 = $00)) <> 0) Then
                    local3 = $01
                    If ((multiplayer_isafriend(local2\Field12, local4\Field36) And (server\Field85 = $00)) <> 0) Then
                        local3 = $00
                    EndIf
                    If (local3 <> 0) Then
                        local0 = entityvisible(local4\Field62, local2\Field1)
                        If (local0 = $00) Then
                            local0 = entityvisible(local4\Field69, local2\Field1)
                        EndIf
                        If (local0 = $00) Then
                            local0 = entityvisible(local4\Field64, local2\Field1)
                        EndIf
                        If (local0 <> 0) Then
                            local5 = max(0.0, ((7.0 * getgundamage($04)) - (entitydistance(local4\Field62, local2\Field1) * 20.0)))
                            giveplayerhealth(local4\Field30, (- local5), ("was killed by explosion by " + player[local1]\Field15))
                            local6 = public_inqueue($12, $00)
                            public_addparam(local6, (Str local1), $01)
                            public_addparam(local6, (Str local4\Field30), $01)
                            public_addparam(local6, (Str local5), $02)
                            public_addparam(local6, (Str player[local1]\Field35), $01)
                            callback($00)
                        EndIf
                    EndIf
                EndIf
            Next
            For local7 = Each npcs
                If (local7\Field48 = $00) Then
                    If (((local7\Field5 = $0B) Or (local7\Field5 = $15)) <> 0) Then
                        If (5.0 > entitydistance(local7\Field4, local2\Field1)) Then
                            local7\Field59 = (Int ((Float (local7\Field59 - $23)) - (entitydistance(local7\Field4, local2\Field1) * 5.0)))
                            If (local7\Field59 < $01) Then
                                local7\Field48 = $01
                            EndIf
                        EndIf
                    EndIf
                    If (local7\Field5 = $02) Then
                        If (3.0 > entitydistance(local7\Field4, local2\Field1)) Then
                            local7\Field9 = (Float rand($55F0, $6978))
                            positionentity(local7\Field4, 0.0, 500.0, 0.0, $00)
                        EndIf
                    EndIf
                EndIf
            Next
            freeentity(local2\Field1)
            Delete local2
        EndIf
        entitypickmode(player[local1]\Field69, $02, $00)
    Next
    updategrenades()
    Return $00
End Function
