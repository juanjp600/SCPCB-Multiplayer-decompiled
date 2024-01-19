Function se_error%(arg0.se_token, arg1$, arg2%)
    If (se_error_dump_line <> 0) Then
        arg1 = (((arg1 + chr($0D)) + chr($0D)) + arg0\Field2\Field0)
    EndIf
    se_seterror(((((("error at line " + (Str arg0\Field2\Field1)) + ", column ") + (Str arg0\Field3)) + ": ") + arg1), arg2)
    Return $00
End Function
