Function mp_serverbroadcastvoice%(arg0.mp_player, arg1#, arg2%, arg3%)
    Local local0.mp_player
    For local0 = Each mp_player
        If (((local0\Field5 > $01) And (local0 <> arg0)) <> 0) Then
            If (((arg1 > entitydistancesquared(arg0\Field18, local0\Field18)) Lor ((arg3 > $00) And (arg3 = local0\Field4\Field26))) <> 0) Then
                mp_broadcastvoice(local0\Field0, local0\Field1, arg0\Field5, arg2, arg3)
            EndIf
        EndIf
    Next
    Return $00
End Function
