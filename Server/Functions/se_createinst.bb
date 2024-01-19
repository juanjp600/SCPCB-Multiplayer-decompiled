Function se_createinst.se_inst(arg0.se_script, arg1%, arg2.se_value, arg3.se_value, arg4.se_value)
    Local local0.se_inst
    local0 = (New se_inst)
    local0\Field0 = arg1
    local0\Field1 = arg2
    local0\Field2 = arg3
    local0\Field3 = arg4
    If (arg0\Field1 <> Null) Then
        local0\Field4 = arg0\Field1
        arg0\Field1\Field5 = local0
        arg0\Field1 = local0
    Else
        arg0\Field0 = local0
        arg0\Field1 = local0
    EndIf
    Return local0
    Return Null
End Function
