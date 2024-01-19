Function se_vf_createfuncptr.se_vf_funcptr(arg0$)
    Local local0.se_vf_funcptr
    local0 = (New se_vf_funcptr)
    local0\Field0 = arg0
    local0\Field1 = se_vf_func_ptr_n
    se_vf_func_ptr_n = (se_vf_func_ptr_n + $01)
    Return local0
    Return Null
End Function
