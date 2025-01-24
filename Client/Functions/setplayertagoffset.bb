Function setplayertagoffset%(arg0.mp_player, arg1%, arg2#)
    If (arg2 <> arg0\Field34[arg1]\Field5) Then
        arg0\Field34[arg1]\Field5 = arg2
        arg0\Field34[arg1]\Field8 = $01
    EndIf
    Return $00
End Function
