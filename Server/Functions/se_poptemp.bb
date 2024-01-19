Function se_poptemp.se_vf_value()
    Local local0.se_vf_value
    If (se_function_def\Field7 = Null) Then
        se_error = $01
    EndIf
    local0 = se_function_def\Field7\Field0
    se_function_def\Field7 = se_function_def\Field7\Field2
    Return local0
    Return Null
End Function
