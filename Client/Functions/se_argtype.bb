Function se_argtype%(arg0%)
    If (((arg0 < $00) Or (arg0 >= se_arguments_number)) <> 0) Then
        Return $00
    EndIf
    Return se_arguments_stack((se_arguments_stack_offset + arg0))\Field0
    Return $00
End Function
