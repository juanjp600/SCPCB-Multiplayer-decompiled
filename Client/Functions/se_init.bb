Function se_init%()
    Local local0%
    Dim se_transient_stack.se_value(se_transient_stack_size)
    Dim se_aux_transient_stack.se_value(se_transient_stack_size)
    For local0 = $00 To se_transient_stack_size Step $01
        se_transient_stack(local0) = (New se_value)
    Next
    Dim se_arguments_stack.se_value(se_arguments_stack_size)
    Dim se_aux_arguments_stack.se_value(se_arguments_stack_size)
    For local0 = $00 To se_arguments_stack_size Step $01
        se_arguments_stack(local0) = (New se_value)
    Next
    Return $00
End Function
