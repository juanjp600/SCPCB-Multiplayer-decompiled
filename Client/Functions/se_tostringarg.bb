Function se_tostringarg$(arg0%, arg1$)
    Local local0.se_value
    If (arg0 >= se_arguments_number) Then
        Return arg1
    EndIf
    local0 = se_arguments_stack((se_arguments_stack_offset + arg0))
    Select local0\Field0
        Case $00
            Return ""
        Case $01
            Return (Str local0\Field1)
        Case $02
            Return (Str local0\Field2)
        Case $03
            Return local0\Field3
    End Select
    Return ""
End Function
