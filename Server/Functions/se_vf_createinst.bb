Function se_vf_createinst.se_vf_inst(arg0%, arg1.se_vf_value, arg2.se_vf_value, arg3.se_vf_value)
    Local local0.se_vf_inst
    local0 = (New se_vf_inst)
    local0\Field0 = arg0
    local0\Field1 = arg1
    local0\Field2 = arg2
    local0\Field3 = arg3
    local0\Field4 = se_vf_inst_n
    se_vf_inst_n = (se_vf_inst_n + $01)
    Return local0
    Return Null
End Function
