Function player_var_setvalue%(arg0%, arg1$, arg2$)
    Local local0%
    For local0 = $01 To $FF Step $01
        If (player[arg0]\Field45[local0] <> Null) Then
            If (player[arg0]\Field45[local0]\Field0 = arg1) Then
                player[arg0]\Field45[local0]\Field1 = arg2
                Return $00
            EndIf
        EndIf
    Next
    local0 = player_var_getid(arg0)
    If (local0 = $00) Then
        Return $00
    EndIf
    player[arg0]\Field45[local0] = (New playervariables)
    player[arg0]\Field45[local0]\Field0 = arg1
    player[arg0]\Field45[local0]\Field1 = arg2
    Return $00
End Function
