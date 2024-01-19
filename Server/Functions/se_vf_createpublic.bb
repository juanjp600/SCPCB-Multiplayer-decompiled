Function se_vf_createpublic.se_vf_value(arg0$)
    Local local0.se_vf_value
    Local local1.se_vf_public
    local0 = (New se_vf_value)
    local0\Field0 = $0A
    local0\Field2 = se_vf_static_n
    local1 = (New se_vf_public)
    local1\Field0 = arg0
    local1\Field1 = se_vf_static_n
    se_vf_public_n = (se_vf_public_n + $01)
    se_vf_static_n = (se_vf_static_n + $01)
    Return local0
    Return Null
End Function
