Function findnearestid%(arg0.npcs)
    Local local0%
    Local local1#
    Local local2.players
    Local local3.players
    For local2 = Each players
        If ((((local2\Field59 = $00) And (local2\Field30 <> $00)) And (mp_isascp(local2\Field36) = $00)) <> 0) Then
            local0 = local2\Field30
            local1 = entitydistance(arg0\Field4, local2\Field62)
            For local3 = Each players
                If (((((local2 <> local3) And (local3\Field59 = $00)) And (local3\Field30 <> $00)) And (mp_isascp(local3\Field36) = $00)) <> 0) Then
                    If (local1 > entitydistance(arg0\Field4, local3\Field62)) Then
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
    Return findplayer()
    Return $00
End Function
