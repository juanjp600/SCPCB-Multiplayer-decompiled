Function settimer%(arg0.se_script, arg1$, arg2%, arg3%, arg4$, arg5.bs)
    Local local0.se_funcptr
    Local local1%
    Local local2.timers
    Local local3.timers
    If (arg5 = Null) Then
        Return $00
    EndIf
    If (arg0 = Null) Then
        removebytestream(arg5)
        Return $00
    EndIf
    local0 = se_findfunc(arg0, lower(arg1))
    If (local0 = Null) Then
        removebytestream(arg5)
        Return $00
    EndIf
    local1 = $00
    For local2 = Each timers
        local1 = (local1 + $01)
        If (local1 >= $400) Then
            removebytestream(arg5)
            Return $00
        EndIf
    Next
    local3 = (New timers)
    local3\Field3 = (Int min(max((Float arg2), 1.0), 3600000.0))
    local3\Field2 = arg4
    local3\Field4 = (millisecs() + local3\Field3)
    local3\Field1 = arg5
    local3\Field5 = (arg3 <> $00)
    local3\Field0 = arg0
    local3\Field6 = local0
    Return (Handle local3)
    Return $00
End Function
