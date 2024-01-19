Function se_vf_closefile%()
    se_vf_inst_n = $00
    se_vf_func_ptr_n = $00
    se_vf_static_n = $00
    se_vf_label_n = $00
    se_vf_public_n = $00
    Delete Each se_vf_inst
    Delete Each se_vf_value
    Delete Each se_vf_label
    Delete Each se_vf_funcptr
    Delete Each se_vf_public
    Dim se_vf_a_inst.se_inst($00)
    Dim se_vf_a_func_ptr.se_funcptr($00)
    Dim se_vf_a_static.se_value($00)
    Dim se_vf_a_label.se_value($00)
    Return $00
End Function
