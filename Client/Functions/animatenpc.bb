Function animatenpc%(arg0.npcs, arg1#, arg2#, arg3#, arg4%)
    Local local0#
    Local local1#
    If (mp_ishoster() <> 0) Then
        arg0\Field84 = arg1
        arg0\Field85 = arg2
        arg0\Field86 = arg3
        arg0\Field87 = arg4
    EndIf
    If (0.0 < arg3) Then
        local0 = clamp((arg0\Field14 + (fps\Field7[$00] * arg3)), arg1, arg2)
        If ((arg4 And (arg2 <= local0)) <> 0) Then
            local0 = arg1
        EndIf
    Else
        If (arg2 > arg1) Then
            local1 = arg1
            arg1 = arg2
            arg2 = local1
        EndIf
        If (arg4 <> 0) Then
            local0 = (arg0\Field14 + (fps\Field7[$00] * arg3))
            If (arg2 > local0) Then
                local0 = arg1
            ElseIf (arg1 < local0) Then
                local0 = arg2
            EndIf
        Else
            local0 = clamp((arg0\Field14 + (fps\Field7[$00] * arg3)), arg2, arg1)
        EndIf
    EndIf
    setnpcframe(arg0, local0, $00)
    Return $00
End Function
