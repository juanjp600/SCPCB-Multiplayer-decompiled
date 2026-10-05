Function se_arrayarg.se_array(arg0%)
    Local local0.se_value
    If (((arg0 < $00) Or (arg0 >= se_arguments_number)) <> 0) Then
        Return Null
    EndIf
    local0 = se_arguments_stack((se_arguments_stack_offset + arg0))
    If (local0\Field0 = $07) Then
        Return local0\Field6
    EndIf
    Return Null
End Function
