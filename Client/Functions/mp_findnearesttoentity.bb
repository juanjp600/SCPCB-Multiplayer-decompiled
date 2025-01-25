Function mp_findnearesttoentity.mp_player(arg0%)
    Local local0#
    Local local1.mp_player
    Local local2.mp_player
    Local local3#
    local0 = 1000000.0
    local1 = Null
    local3 = 0.0
    For local2 = Each mp_player
        If (((((local2\Field18 <> $00) And (entityhidden(local2\Field18) = $00)) And (local2\Field30 = $00)) And (mp_rooms[local2\Field22] <> Null)) <> 0) Then
            local3 = entitydistancesquared(local2\Field18, arg0)
            If (local0 > local3) Then
                local1 = local2
                local0 = local3
            EndIf
        EndIf
    Next
    Return local1
    Return Null
End Function
