Function se_definelocal%(arg0$, arg1%, arg2.se_token)
    Local local0.se_localdef
    If (se_checklocalscope(arg0) <> 0) Then
        Return $00
    EndIf
    local0 = (New se_localdef)
    local0\Field1 = arg0
    local0\Field0 = se_vf_createtransient(se_function_def\Field0, arg1)
    local0\Field3 = arg2
    If (se_function_def\Field1 = Null) Then
        se_function_def\Field1 = local0
        se_function_def\Field2 = local0
    Else
        se_function_def\Field2\Field2 = local0
        se_function_def\Field2 = local0
    EndIf
    Return $01
    Return $00
End Function
