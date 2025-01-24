Function removeplayerattach%(arg0.mp_playermodel, arg1%, arg2%)
    If (arg0\Field21[arg1]\Field0 = $00) Then
        Return $00
    EndIf
    If (arg2 <> 0) Then
        arg0\Field21[arg1]\Field2 = Null
    EndIf
    If (arg0\Field0 = $00) Then
        Return $00
    EndIf
    freeentity(arg0\Field21[arg1]\Field0)
    arg0\Field21[arg1]\Field0 = $00
    Return $00
End Function
