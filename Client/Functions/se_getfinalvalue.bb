Function se_getfinalvalue.se_value(arg0.se_value)
    If (((arg0\Field0 = $05) Or (arg0\Field0 = $06)) <> 0) Then
        arg0\Field0 = $00
        If (arg0\Field5 = Null) Then
            arg0\Field0 = $00
        Else
            arg0 = arg0\Field5
        EndIf
    EndIf
    Return arg0
    Return Null
End Function
