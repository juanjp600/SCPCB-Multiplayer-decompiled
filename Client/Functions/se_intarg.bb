Function se_intarg%(arg0%, arg1%)
    Local local0.se_value
    If (((arg0 < $00) Or (arg0 >= se_arguments_number)) <> 0) Then
        Return arg1
    EndIf
    local0 = se_arguments_stack((se_arguments_stack_offset + arg0))
    If (local0\Field0 = $01) Then
        Return local0\Field2
    EndIf
    Return $00
End Function
