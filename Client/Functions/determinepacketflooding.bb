Function determinepacketflooding%(arg0.mp_player, arg1%, arg2%, arg3%)
    If (mp_gettimer() >= arg0\Field33[arg1]) Then
        arg0\Field32[arg1] = $00
        arg0\Field33[arg1] = (mp_gettimer() + arg3)
        Return $00
    EndIf
    arg0\Field32[arg1] = (arg0\Field32[arg1] + $01)
    Return (arg0\Field32[arg1] >= arg2)
    Return $00
End Function
