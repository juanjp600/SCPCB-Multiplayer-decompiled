Function settimer%(arg0.se_script, arg1$, arg2%, arg3%, arg4$, arg5.bs, arg6%)
    Local local0.timers
    local0 = (New timers)
    local0\Field3 = arg2
    local0\Field2 = arg4
    local0\Field4 = (millisecs() + arg2)
    local0\Field1 = arg5
    local0\Field5 = arg3
    local0\Field0 = arg0
    If (arg6 = $00) Then
        local0\Field6 = se_findfunc(arg0, lower(arg1))
    Else
        local0\Field7 = arg6
        local0\Field8 = lower(arg1)
    EndIf
    Return (Handle local0)
    Return $00
End Function
