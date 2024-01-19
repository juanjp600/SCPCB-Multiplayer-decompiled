Function se_tointarg%(arg0%, arg1%)
    Local local0.se_value
    If (arg0 >= se_arguments_number) Then
        Return arg1
    EndIf
    local0 = se_arguments_stack((se_arguments_stack_offset + arg0))
    Select local0\Field0
        Case $00
            Return $00
        Case $01
            Return local0\Field1
        Case $02
            Return (Int local0\Field2)
        Case $03
            Return (Int local0\Field3)
    End Select
    Return $00
End Function
