Function makedeaf%(arg0#)
    If (me\Field54 = $00) Then
        opt\Field17 = opt\Field16
        me\Field55 = arg0
        me\Field54 = $01
    EndIf
    Return $00
End Function
