Function createitemtemplate.itemtemplates(arg0$, arg1$, arg2$, arg3$, arg4$, arg5#, arg6$, arg7$, arg8%, arg9%, arg10%)
    Local local0.itemtemplates
    Local local1%
    Local local2.itemtemplates
    local0 = (New itemtemplates)
    For local2 = Each itemtemplates
        If (local2\Field6 = arg2) Then
            local0\Field7 = local2\Field6
            Exit
        EndIf
    Next
    local0\Field6 = arg2
    local0\Field14 = arg5
    For local2 = Each itemtemplates
        If (((local2\Field10 = arg3) And (local2\Field8 <> $00)) <> 0) Then
            local0\Field8 = local2\Field8
            If (local2\Field9 <> $00) Then
                local0\Field9 = local2\Field9
            EndIf
            Exit
        EndIf
    Next
    local0\Field11 = arg4
    local0\Field2 = arg1
    local0\Field1 = arg0
    local0\Field3 = $01
    local0\Field0 = (((((((((((generateseednumber(arg0) + generateseednumber(arg1)) + generateseednumber(arg2)) + generateseednumber(arg3)) + generateseednumber(arg4)) + generateseednumber((Str arg5))) + generateindex(arg0)) + generateindex(arg1)) + generateindex(arg2)) + generateindex(arg3)) + generateindex(arg4)) + generateindex((Str arg5)))
    Return local0
    Return Null
End Function
