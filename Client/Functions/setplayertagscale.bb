Function setplayertagscale%(arg0.mp_player, arg1%, arg2#, arg3#)
    If (((arg2 <> arg0\Field34[arg1]\Field3) Lor (arg3 <> arg0\Field34[arg1]\Field4)) <> 0) Then
        arg0\Field34[arg1]\Field3 = arg2
        arg0\Field34[arg1]\Field4 = arg3
        arg0\Field34[arg1]\Field8 = $01
    EndIf
    Return $00
End Function
