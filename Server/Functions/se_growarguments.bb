Function se_growarguments%()
    Local local0%
    If (se_arguments_stack_level > se_arguments_stack_size) Then
        adderrorlog((((("Arguments stack overflow! (" + (Str se_arguments_stack_level)) + ",") + (Str se_arguments_stack_size)) + ")"))
        Dim se_aux_arguments_stack.se_value(se_arguments_stack_size)
        For local0 = $00 To se_arguments_stack_size Step $01
            se_aux_arguments_stack(local0) = se_arguments_stack(local0)
        Next
        Dim se_arguments_stack.se_value(se_arguments_stack_level)
        For local0 = $00 To se_arguments_stack_size Step $01
            se_arguments_stack(local0) = se_aux_arguments_stack(local0)
        Next
        For local0 = (se_arguments_stack_size + $01) To se_arguments_stack_level Step $01
            se_arguments_stack(local0) = (New se_value)
        Next
        se_arguments_stack_size = se_arguments_stack_level
    EndIf
    Return $00
End Function
