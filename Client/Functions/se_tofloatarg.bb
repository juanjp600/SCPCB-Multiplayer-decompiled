Function se_tofloatarg#(arg0%, arg1#)
    Local local0.se_value
    If (arg0 >= se_arguments_number) Then
        Return arg1
    EndIf
    local0 = se_arguments_stack((se_arguments_stack_offset + arg0))
    Select local0\Field0
        Case $00
            Return 0.0
        Case $01
            Return (Float local0\Field1)
        Case $02
            Return local0\Field2
        Case $03
            Return (Float local0\Field3)
    End Select
    Return 0.0
End Function
