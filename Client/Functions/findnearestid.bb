Function findnearestid%(arg0.npcs)
    Local local0%
    Local local1#
    Local local2.players
    Local local3.players
    For local2 = Each players
        If (((local2\Field33 = $00) And (multiplayer_isascp(local2\Field51) = $00)) <> 0) Then
            local0 = local2\Field0
            local1 = entitydistance(arg0\Field4, local2\Field13)
            For local3 = Each players
                If ((((local2 <> local3) And (local3\Field33 = $00)) And (multiplayer_isascp(local3\Field51) = $00)) <> 0) Then
                    If (local1 > entitydistance(arg0\Field4, local3\Field13)) Then
                        local0 = $00
                        Exit
                    EndIf
                EndIf
            Next
        EndIf
        If (local0 > $00) Then
            Return local0
        EndIf
    Next
    Return networkserver\Field28
    Return $00
End Function
