Function se_pushtemp.se_vf_value()
    Local local0.se_tempvalue
    local0 = se_function_def\Field7
    If (local0 <> Null) Then
        local0 = local0\Field1
    Else
        local0 = se_function_def\Field5
    EndIf
    If (local0 = Null) Then
        local0 = (New se_tempvalue)
        If (se_function_def\Field5 = Null) Then
            se_function_def\Field5 = local0
            se_function_def\Field6 = local0
        Else
            local0\Field2 = se_function_def\Field6
            se_function_def\Field6\Field1 = local0
            se_function_def\Field6 = local0
        EndIf
        local0\Field0 = (New se_vf_value)
    EndIf
    se_function_def\Field7 = local0
    Return local0\Field0
    Return Null
End Function
