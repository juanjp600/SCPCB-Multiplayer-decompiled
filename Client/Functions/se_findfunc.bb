Function se_findfunc.se_funcptr(arg0.se_script, arg1$)
    Local local0.se_funcptr
    local0 = arg0\Field2
    While (local0 <> Null)
        If (local0\Field0 = arg1) Then
            Return local0
        EndIf
        local0 = local0\Field7
    Wend
    Return Null
End Function
