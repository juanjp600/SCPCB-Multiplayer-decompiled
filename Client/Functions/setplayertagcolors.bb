Function setplayertagcolors%(arg0.mp_player, arg1%, arg2%, arg3%)
    If (((arg0\Field34[arg1]\Field6 <> arg2) Lor (arg0\Field34[arg1]\Field7 <> arg3)) <> 0) Then
        arg0\Field34[arg1]\Field6 = arg2
        arg0\Field34[arg1]\Field7 = arg3
        arg0\Field34[arg1]\Field8 = $01
    EndIf
    Return $00
End Function
