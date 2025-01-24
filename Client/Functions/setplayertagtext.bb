Function setplayertagtext%(arg0.mp_player, arg1%, arg2$)
    If (arg0\Field34[arg1]\Field2 <> arg2) Then
        arg0\Field34[arg1]\Field2 = arg2
        arg0\Field34[arg1]\Field8 = $01
    EndIf
    Return $00
End Function
