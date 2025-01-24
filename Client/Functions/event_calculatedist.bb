Function event_calculatedist#(arg0.events)
    Local local0#
    Local local1.mp_player
    arg0\Field16 = 100000.0
    For local1 = Each mp_player
        If (((local1\Field18 <> $00) And (entityhidden(local1\Field18) = $00)) <> 0) Then
            local0 = getentityroomdist(local1\Field18, arg0\Field1)
            If (((local0 < arg0\Field16) And (0.0 <= local0)) <> 0) Then
                arg0\Field16 = local0
            EndIf
        EndIf
    Next
    Return 0.0
End Function
