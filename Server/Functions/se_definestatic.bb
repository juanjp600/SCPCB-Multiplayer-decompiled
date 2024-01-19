Function se_definestatic%(arg0$, arg1.se_token)
    Local local0.se_staticdef
    If (se_checklocalscope(arg0) <> 0) Then
        Return $00
    EndIf
    local0 = (New se_staticdef)
    local0\Field1 = arg0
    local0\Field0 = se_vf_createstatic()
    local0\Field3 = arg1
    If (se_function_def\Field3 = Null) Then
        se_function_def\Field3 = local0
        se_function_def\Field4 = local0
    Else
        se_function_def\Field4\Field2 = local0
        se_function_def\Field4 = local0
    EndIf
    Return $01
    Return $00
End Function
