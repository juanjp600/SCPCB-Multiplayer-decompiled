Function se_gccheck%(arg0.se_value)
    If (arg0\Field0 = $07) Then
        arg0\Field5\Field0 = (arg0\Field5\Field0 - $01)
    EndIf
    Return $00
End Function
