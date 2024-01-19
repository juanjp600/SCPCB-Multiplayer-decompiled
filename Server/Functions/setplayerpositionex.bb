Function setplayerpositionex%(arg0%, arg1%, arg2#, arg3#, arg4#)
    If (player[arg0] = Null) Then
        Return $00
    EndIf
    player[arg0]\Field163 = (player[arg0]\Field163 Mod $FFFF)
    player[arg0]\Field163 = (player[arg0]\Field163 + $01)
    player[arg0]\Field165 = arg2
    player[arg0]\Field166 = arg3
    player[arg0]\Field167 = arg4
    player[arg0]\Field168 = (Str arg1)
    player[arg0]\Field169 = $01
    player[arg0]\Field170 = arg1
    player[arg0]\Field32 = arg1
    player[arg0]\Field0 = arg2
    player[arg0]\Field1 = arg3
    player[arg0]\Field2 = arg4
    mp_updateplayerposition(player[arg0], $00)
    Return $00
End Function
