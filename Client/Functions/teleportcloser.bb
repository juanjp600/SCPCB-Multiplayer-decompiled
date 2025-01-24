Function teleportcloser%(arg0.npcs)
    Local local0#
    Local local1.waypoints
    Local local2.waypoints
    Local local3#
    Local local4#
    Local local5%
    local0 = 0.0
    If (infacility > $01) Then
        Return $00
    EndIf
    For local2 = Each waypoints
        If (local2\Field1 = Null) Then
            local3 = distancesquared(entityx(local2\Field0, $01), entityx(arg0\Field3, $01), entityz(local2\Field0, $01), entityz(arg0\Field3, $01), 0.0, 0.0)
            If (((1.0 < local3) And (100.0 > local3)) <> 0) Then
                If (((16.0 - ((Float selecteddifficulty\Field2) * 6.0)) * (16.0 - ((Float selecteddifficulty\Field2) * 6.0))) < entitydistancesquared(me\Field60, local2\Field0)) Then
                    local4 = entitydistancesquared(me\Field60, local2\Field0)
                    If (((local0 > local4) Lor (local1 = Null)) <> 0) Then
                        local0 = local4
                        local1 = local2
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    If (local1 <> Null) Then
        local5 = $00
        If (((arg0\Field59 <> $00) Lor selecteddifficulty\Field2) <> 0) Then
            local5 = $01
        ElseIf (((6.5 >= entityy(local1\Field0, $01)) And (-6.5 <= entityy(local1\Field0, $01))) <> 0) Then
            local5 = $01
        EndIf
        If (local5 <> 0) Then
            teleportentity(arg0\Field3, entityx(local1\Field0, $01), (entityy(local1\Field0, $01) + 0.2), entityz(local1\Field0, $01), arg0\Field6, $01, 2.0, $00)
            arg0\Field24 = 0.0
            arg0\Field40 = $00
            arg0\Field41 = 0.0
            arg0\Field42 = $00
        EndIf
    EndIf
    Return $00
End Function
