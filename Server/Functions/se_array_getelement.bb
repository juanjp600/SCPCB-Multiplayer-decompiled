Function se_array_getelement.se_value(arg0.se_array, arg1%)
    Local local0.se_value
    If (arg0\Field1 = $00) Then
        Return Null
    EndIf
    If (((arg1 >= $00) And (arg1 < arg0\Field1)) <> 0) Then
        local0 = (Object.se_value peekint(arg0\Field2, (arg1 Shl $02)))
        Return local0
    EndIf
    Return Null
End Function
