Function se_vf_createlabel.se_vf_label()
    Local local0.se_vf_label
    local0 = (New se_vf_label)
    local0\Field0 = se_vf_label_n
    se_vf_label_n = (se_vf_label_n + $01)
    Return local0
    Return Null
End Function
