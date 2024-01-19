Function teleportcloser%(arg0.npcs)
    Local local0#
    Local local1.waypoints
    Local local2.waypoints
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    local0 = 0.0
    For local2 = Each waypoints
        If (local2\Field1 = Null) Then
            local3 = (Abs (entityx(local2\Field0, $01) - entityx(arg0\Field4, $01)))
            If (((10.0 > local3) And (1.0 < local3)) <> 0) Then
                local4 = (Abs (entityz(local2\Field0, $01) - entityz(arg0\Field4, $01)))
                If (((10.0 > local4) And (1.0 < local4)) <> 0) Then
                    If ((Float ($10 - (selecteddifficulty\Field3 Shl $03))) < entitydistance(arg0\Field73, local2\Field0)) Then
                        local5 = entitydistance(arg0\Field73, local2\Field0)
                        If (((local0 > local5) Or (local1 = Null)) <> 0) Then
                            local0 = local5
                            local1 = local2
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    local6 = $00
    If (local1 <> Null) Then
        If (((arg0\Field58 <> $01) Or selecteddifficulty\Field3) <> 0) Then
            local6 = $01
        ElseIf (((7.0 >= entityy(local1\Field0, $01)) And (-10.0 <= entityy(local1\Field0, $01))) <> 0) Then
            local6 = $01
        EndIf
        If (local6 <> 0) Then
            positionentity(arg0\Field4, entityx(local1\Field0, $01), (entityy(local1\Field0, $01) + 0.15), entityz(local1\Field0, $01), $01)
            resetentity(arg0\Field4)
            arg0\Field37 = $00
            arg0\Field38 = 0.0
            arg0\Field39 = $00
        EndIf
    EndIf
    Return $00
End Function
