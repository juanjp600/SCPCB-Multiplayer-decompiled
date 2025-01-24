Function mp_npc_findnearesttarget.mp_player(arg0.npcs)
    Local local0#
    Local local1.mp_player
    Local local2.mp_player
    If (arg0\Field87 <> 0) Then
        Return Null
    EndIf
    local0 = 100000.0
    local1 = Null
    For local2 = Each mp_player
        If (((((local2\Field18 <> $00) And (entityhidden(local2\Field18) = $00)) And (local2\Field30 = $00)) And (mp_rooms[local2\Field22] <> Null)) <> 0) Then
            If (local0 > entitydistancesquared(local2\Field18, arg0\Field3)) Then
                local1 = local2
                local0 = entitydistancesquared(local2\Field18, arg0\Field3)
            EndIf
        EndIf
    Next
    Return local1
    Return Null
End Function
