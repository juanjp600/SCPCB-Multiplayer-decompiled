Function se_tostringarg$(arg0%, arg1$)
    Local local0.se_value
    If (((arg0 < $00) Or (arg0 >= se_arguments_number)) <> 0) Then
        Return arg1
    EndIf
    local0 = se_arguments_stack((se_arguments_stack_offset + arg0))
    Select local0\Field0
        Case $00
            Return ""
        Case $01
            Return (Str local0\Field2)
        Case $02
            Return (Str local0\Field3)
        Case $03
            Return local0\Field4
    End Select
    Return ""
End Function
