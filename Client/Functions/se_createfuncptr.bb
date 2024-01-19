Function se_createfuncptr.se_funcptr(arg0.se_script, arg1$, arg2.se_inst, arg3.se_inst, arg4%, arg5%)
    Local local0.se_funcptr
    local0 = (New se_funcptr)
    local0\Field0 = arg1
    local0\Field1 = arg0
    local0\Field2 = arg2
    local0\Field3 = arg3
    local0\Field4 = arg4
    local0\Field5 = arg5
    If (arg0\Field3 <> Null) Then
        local0\Field6 = arg0\Field3
        arg0\Field3\Field7 = local0
        arg0\Field3 = local0
    Else
        arg0\Field2 = local0
        arg0\Field3 = local0
    EndIf
    Return local0
    Return Null
End Function
