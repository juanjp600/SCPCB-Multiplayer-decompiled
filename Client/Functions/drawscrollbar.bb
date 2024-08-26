Function drawscrollbar#(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%, arg6%, arg7%, arg8#, arg9%)
    Local local0%
    Local local1%
    local0 = mousexspeed()
    local1 = mouseyspeed()
    color($00, $00, $00)
    button(arg4, arg5, arg6, arg7, "", $00)
    If (arg9 = $00) Then
        If (arg3 > $0A) Then
            color($FA, $FA, $FA)
            rect(((arg6 Sar $01) + arg4), (Int ((5.0 * menuscale) + (Float arg5))), (Int (2.0 * menuscale)), (arg7 - $0A), $01)
            rect((Int ((Float ((arg6 Sar $01) + arg4)) - (3.0 * menuscale))), (Int ((5.0 * menuscale) + (Float arg5))), (Int (2.0 * menuscale)), (arg7 - $0A), $01)
            rect((Int ((3.0 * menuscale) + (Float ((arg6 Sar $01) + arg4)))), (Int ((5.0 * menuscale) + (Float arg5))), (Int (2.0 * menuscale)), (arg7 - $0A), $01)
        EndIf
    ElseIf (arg2 > $0A) Then
        color($FA, $FA, $FA)
        rect((Int ((4.0 * menuscale) + (Float arg4))), ((arg7 Sar $01) + arg5), (Int ((Float arg6) - (10.0 * menuscale))), (Int (2.0 * menuscale)), $01)
        rect((Int ((4.0 * menuscale) + (Float arg4))), (Int ((Float ((arg7 Sar $01) + arg5)) - (3.0 * menuscale))), (Int ((Float arg6) - (10.0 * menuscale))), (Int (2.0 * menuscale)), $01)
        rect((Int ((4.0 * menuscale) + (Float arg4))), (Int ((3.0 * menuscale) + (Float ((arg7 Sar $01) + arg5)))), (Int ((Float arg6) - (10.0 * menuscale))), (Int (2.0 * menuscale)), $01)
    EndIf
    If (((mousex() > arg4) And (mousex() < (arg4 + arg6))) <> 0) Then
        If (((mousey() > arg5) And (mousey() < (arg5 + arg7))) <> 0) Then
            onbar = $01
        ElseIf (mousedown1 = $00) Then
            onbar = $00
        EndIf
    ElseIf (mousedown1 = $00) Then
        onbar = $00
    EndIf
    If (mousedown1 <> 0) Then
        If (onbar <> 0) Then
            If (arg9 = $00) Then
                Return min(max((((Float local0) / (Float (arg2 - arg6))) + arg8), 0.0), 1.0)
            Else
                Return min(max((((Float local1) / (Float (arg3 - arg7))) + arg8), 0.0), 1.0)
            EndIf
        EndIf
    EndIf
    Return arg8
    Return 0.0
End Function
