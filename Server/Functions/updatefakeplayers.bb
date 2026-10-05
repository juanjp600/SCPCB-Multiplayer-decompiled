Function updatefakeplayers%()
    Local local0.players
    For local0 = Each players
        If (local0\Field57 <> 0) Then
            local0\Field49 = local0\Field54
            local0\Field55 = ticks\Field0
            local0\Field47 = local0\Field52
            local0\Field48 = local0\Field53
        EndIf
    Next
    Return $00
End Function
