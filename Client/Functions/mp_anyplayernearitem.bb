Function mp_anyplayernearitem%(arg0.items)
    Local local0.mp_player
    If (mp_ishoster() = $00) Then
        Return $00
    EndIf
    For local0 = Each mp_player
        If (local0\Field5 > $01) Then
            If (8.0 > entitydistancesquared(local0\Field18, arg0\Field2)) Then
                Return $01
            EndIf
        EndIf
    Next
    Return $00
    Return $00
End Function
