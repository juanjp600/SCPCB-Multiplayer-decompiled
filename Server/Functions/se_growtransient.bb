Function se_growtransient%()
    Local local0%
    If (se_transient_stack_level > se_transient_stack_size) Then
        adderrorlog((((("Transient stack overflow! (" + (Str se_transient_stack_level)) + ",") + (Str se_transient_stack_size)) + ")"))
        Dim se_aux_transient_stack.se_value(se_transient_stack_size)
        For local0 = $00 To se_transient_stack_size Step $01
            se_aux_transient_stack(local0) = se_transient_stack(local0)
        Next
        Dim se_transient_stack.se_value(se_transient_stack_level)
        For local0 = $00 To se_transient_stack_size Step $01
            se_transient_stack(local0) = se_aux_transient_stack(local0)
        Next
        For local0 = (se_transient_stack_size + $01) To se_transient_stack_level Step $01
            se_transient_stack(local0) = (New se_value)
        Next
        se_transient_stack_size = se_transient_stack_level
    EndIf
    Return $00
End Function
