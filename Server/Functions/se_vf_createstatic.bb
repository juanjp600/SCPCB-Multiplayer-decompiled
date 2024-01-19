Function se_vf_createstatic.se_vf_value()
    Local local0.se_vf_value
    local0 = (New se_vf_value)
    local0\Field0 = $0A
    local0\Field2 = se_vf_static_n
    se_vf_static_n = (se_vf_static_n + $01)
    Return local0
    Return Null
End Function
