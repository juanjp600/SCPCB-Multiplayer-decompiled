Function se_compilescript%(arg0$, arg1$, arg2$)
    se_compile(arg0)
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_vf_savebin(arg1, arg2)
    se_clearcompiler()
    Return $00
End Function
