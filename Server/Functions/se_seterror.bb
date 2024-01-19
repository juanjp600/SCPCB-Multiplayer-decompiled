Function se_seterror%(arg0$, arg1%)
    se_error = arg1
    se_error_message = arg0
    If (arg1 <> 0) Then
        se_clearcompiler()
    EndIf
    Return $00
End Function
