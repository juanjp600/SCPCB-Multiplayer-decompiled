Function se_bl_array_push%()
    Local local0.se_array
    Local local1%
    Local local2%
    Local local3.se_value
    Local local4.se_value
    If (se_argtype($00) <> $07) Then
        Return $00
    EndIf
    local0 = se_arrayarg($00)
    local1 = (se_arguments_number - $01)
    For local2 = $01 To local1 Step $01
        local3 = se_arguments_stack((se_arguments_stack_offset + local2))
        local4 = se_array_addelement(local0)
        local4\Field0 = local3\Field0
        Select local3\Field0
            Case $01
                local4\Field1 = local3\Field1
            Case $02
                local4\Field2 = local3\Field2
            Case $03
                local4\Field3 = local3\Field3
            Case $05
                local4\Field4 = local3\Field4
            Case $07
                local4\Field5 = local3\Field5
        End Select
    Next
    Return $00
End Function
