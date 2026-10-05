Function setplayerposition%(arg0%, arg1$, arg2#, arg3#, arg4#)
    Local local0.rooms
    If (player[arg0] = Null) Then
        Return $00
    EndIf
    player[arg0]\Field166 = (player[arg0]\Field166 Mod $FFFF)
    player[arg0]\Field166 = (player[arg0]\Field166 + $01)
    player[arg0]\Field168 = arg2
    player[arg0]\Field169 = arg3
    player[arg0]\Field170 = arg4
    player[arg0]\Field171 = arg1
    player[arg0]\Field172 = $00
    For local0 = Each rooms
        If (local0\Field7\Field10 = arg1) Then
            player[arg0]\Field32 = local0\Field69
            player[arg0]\Field173 = player[arg0]\Field32
            Exit
        EndIf
    Next
    player[arg0]\Field0 = arg2
    player[arg0]\Field1 = arg3
    player[arg0]\Field2 = arg4
    mp_updateplayerposition(player[arg0], $00)
    Return $00
End Function
