Function se_intarg%(arg0%, arg1%)
    Local local0.se_value
    If (arg0 >= se_arguments_number) Then
        Return arg1
    EndIf
    local0 = se_arguments_stack((se_arguments_stack_offset + arg0))
    If (local0\Field0 = $01) Then
        Return local0\Field1
    EndIf
    Return $00
End Function
