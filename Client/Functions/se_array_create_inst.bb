Function se_array_create_inst%(arg0%, arg1.se_value)
    Local local0.se_array
    Local local1%
    Local local2%
    local0 = se_array_create()
    If (se_arguments_number <> 0) Then
        local2 = (se_arguments_number - $01)
        If (local2 <> $FFFFFFFF) Then
            If (local2 = $00) Then
                se_array_addelements(local0, se_arguments_stack(se_arguments_stack_offset)\Field1, $01)
            ElseIf (local2 = $01) Then
                se_array_addelements(local0, se_arguments_stack(se_arguments_stack_offset)\Field1, se_arguments_stack((se_arguments_stack_offset + $01))\Field1)
            EndIf
        EndIf
    EndIf
    arg1\Field0 = $07
    arg1\Field5 = local0
    Return $00
End Function
