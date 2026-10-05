Function se_getaccessorvalue.se_value(arg0.se_value)
    arg0\Field0 = $00
    If (arg0\Field5 = Null) Then
        arg0\Field0 = $00
    Else
        arg0 = arg0\Field5
    EndIf
    Return arg0
    Return Null
End Function
