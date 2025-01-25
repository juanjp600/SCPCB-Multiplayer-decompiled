Function mp_anyplayernearentity%(arg0%, arg1#)
    Local local0.mp_player
    For local0 = Each mp_player
        If (arg1 > entitydistancesquared(local0\Field18, arg0)) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
