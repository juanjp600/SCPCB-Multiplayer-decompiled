Function se_vf_createtransient.se_vf_value(arg0.se_vf_funcptr, arg1%)
    Local local0.se_vf_value
    local0 = (New se_vf_value)
    local0\Field0 = $04
    local0\Field2 = arg0\Field4
    arg0\Field4 = (arg0\Field4 + $01)
    If (arg1 <> 0) Then
        arg0\Field5 = (arg0\Field5 + $01)
    EndIf
    Return local0
    Return Null
End Function
