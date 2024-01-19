Function animate2#(arg0%, arg1#, arg2%, arg3%, arg4#, arg5%)
    Local local0#
    Local local1%
    If (0.0 < arg4) Then
        local0 = max(min(((arg4 * fpsfactor) + arg1), (Float arg3)), (Float arg2))
        If (arg5 <> 0) Then
            If ((Float arg3) <= local0) Then
                local0 = (Float arg2)
            EndIf
        EndIf
    Else
        If (arg2 < arg3) Then
            local1 = arg2
            arg2 = arg3
            arg3 = local1
        EndIf
        If (arg5 <> 0) Then
            local0 = ((arg4 * fpsfactor) + arg1)
            If ((Float arg3) > local0) Then
                local0 = (Float arg2)
            EndIf
            If ((Float arg2) < local0) Then
                local0 = (Float arg3)
            EndIf
        Else
            local0 = max(min(((arg4 * fpsfactor) + arg1), (Float arg2)), (Float arg3))
        EndIf
    EndIf
    setanimtime(arg0, local0, $00)
    Return local0
    Return 0.0
End Function
