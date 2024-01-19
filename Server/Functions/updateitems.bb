Function updateitems%()
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4.items
    Local local5.players
    Local local6%
    Local local7.items
    For local4 = Each items
        local4\Field33 = $00
        If (local4\Field15 = $00) Then
            hideentity(local4\Field1)
            For local5 = Each players
                If (7.5 > entitydistance(local5\Field62, local4\Field1)) Then
                    local4\Field33 = $01
                    showentity(local4\Field1)
                    If (local4\Field31 = $00) Then
                        If (entityy(local4\Field1, $01) = local4\Field29) Then
                            local4\Field31 = $01
                            local4\Field4 = 0.0
                        Else
                            local4\Field29 = -21849190.0
                            If (local4\Field32 < millisecs()) Then
                                If (linepick(entityx(local4\Field1, $01), entityy(local4\Field1, $01), entityz(local4\Field1, $01), 0.0, -10.0, 0.0, 0.0) <> $00) Then
                                    local4\Field29 = entityy(local4\Field1, $01)
                                    local4\Field4 = (local4\Field4 - (0.0004 * fpsfactor))
                                    translateentity(local4\Field1, 0.0, (local4\Field4 * fpsfactor), 0.0, $00)
                                    detectitemmoving = (detectitemmoving + $01)
                                Else
                                    local4\Field32 = (millisecs() + $3E8)
                                    local4\Field4 = 0.0
                                EndIf
                            Else
                                local4\Field4 = 0.0
                            EndIf
                        EndIf
                    EndIf
                    Exit
                EndIf
            Next
        Else
            positionentity(local4\Field1, player[local4\Field22]\Field0, (player[local4\Field22]\Field1 + 0.6), player[local4\Field22]\Field2, $01)
            resetentity(local4\Field1)
            hideentity(local4\Field1)
            local4\Field4 = 0.0
            local4\Field23 = local4\Field22
            local4\Field31 = $00
            local4\Field29 = -14934890.0
        EndIf
    Next
    If (server\Field81 <> 0) Then
        local6 = $00
        If (detectitemmoving <> 0) Then
            For local4 = Each items
                If (local4\Field33 <> 0) Then
                    For local7 = Each items
                        If (local7\Field33 <> 0) Then
                            If (local4 <> local7) Then
                                If (local7\Field15 = $00) Then
                                    local1 = (entityx(local7\Field1, $01) - entityx(local4\Field1, $01))
                                    local2 = (entityy(local7\Field1, $01) - entityy(local4\Field1, $01))
                                    local3 = (entityz(local7\Field1, $01) - entityz(local4\Field1, $01))
                                    local0 = ((local1 * local1) + (local3 * local3))
                                    If (0.07 > local0) Then
                                        If (0.25 > (Abs local2)) Then
                                            local1 = ((0.07 - local0) * local1)
                                            local3 = ((0.07 - local0) * local3)
                                            While (0.001 > ((Abs local1) + (Abs local3)))
                                                local1 = (rnd(-0.002, 0.002) + local1)
                                                local3 = (rnd(-0.002, 0.002) + local3)
                                            Wend
                                            local4\Field31 = $00
                                            local4\Field29 = -14934890.0
                                            local7\Field31 = $00
                                            local7\Field29 = -14934890.0
                                            translateentity(local7\Field1, local1, 0.0, local3, $00)
                                            translateentity(local4\Field1, (- local1), 0.0, (- local3), $00)
                                            local6 = $01
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                EndIf
            Next
        EndIf
        If (local6 = $00) Then
            detectitemmoving = $00
        EndIf
    EndIf
    Return $00
End Function
