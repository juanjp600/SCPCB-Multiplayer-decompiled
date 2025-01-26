Function mp_nearestdisttoentity#(arg0%)
    Local local0#
    Local local1.mp_player
    Local local2#
    local0 = 1000000.0
    local2 = 0.0
    For local1 = Each mp_player
        If (((((local1\Field18 <> $00) And (entityhidden(local1\Field18) = $00)) And (local1\Field30 = $00)) And (mp_rooms[local1\Field22] <> Null)) <> 0) Then
            local2 = entitydistancesquared(local1\Field18, arg0)
            If (local0 > local2) Then
                local0 = local2
            EndIf
        EndIf
    Next
    Return local0
    Return 0.0
End Function
