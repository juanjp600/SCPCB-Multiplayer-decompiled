Function button%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%)
    Local local0%
    local0 = $00
    color($32, $32, $32)
    If (arg5 = $00) Then
        If (((mousex() > arg0) And (mousex() < (arg0 + arg2))) <> 0) Then
            If (((mousey() > arg1) And (mousey() < (arg1 + arg3))) <> 0) Then
                If (mousedown1 <> 0) Then
                    local0 = $01
                    color($1E, $1E, $1E)
                Else
                    color((Int min(60.0, 255.0)), (Int min(60.0, 255.0)), (Int min(60.0, 255.0)))
                EndIf
            EndIf
        EndIf
    EndIf
    If (local0 <> 0) Then
        rect(arg0, arg1, arg2, arg3, $01)
        color($85, $82, $7D)
        rect((Int ((1.0 * menuscale) + (Float arg0))), (Int ((1.0 * menuscale) + (Float arg1))), (Int ((Float arg2) - (1.0 * menuscale))), (Int ((Float arg3) - (1.0 * menuscale))), $00)
        color($0A, $0A, $0A)
        rect(arg0, arg1, arg2, arg3, $00)
        color($FA, $FA, $FA)
        line(arg0, (Int ((Float (arg1 + arg3)) - (1.0 * menuscale))), (Int ((Float (arg0 + arg2)) - (1.0 * menuscale))), (Int ((Float (arg1 + arg3)) - (1.0 * menuscale))))
        line((Int ((Float (arg0 + arg2)) - (1.0 * menuscale))), arg1, (Int ((Float (arg0 + arg2)) - (1.0 * menuscale))), (Int ((Float (arg1 + arg3)) - (1.0 * menuscale))))
    Else
        rect(arg0, arg1, arg2, arg3, $01)
        color($85, $82, $7D)
        rect(arg0, arg1, (Int ((Float arg2) - (1.0 * menuscale))), (Int ((Float arg3) - (1.0 * menuscale))), $00)
        color($FA, $FA, $FA)
        rect(arg0, arg1, arg2, arg3, $00)
        color($0A, $0A, $0A)
        line(arg0, ((arg1 + arg3) - $01), ((arg0 + arg2) - $01), ((arg1 + arg3) - $01))
        line(((arg0 + arg2) - $01), arg1, ((arg0 + arg2) - $01), ((arg1 + arg3) - $01))
    EndIf
    color($FF, $FF, $FF)
    If (arg5 <> 0) Then
        color($46, $46, $46)
    EndIf
    text(((arg2 Sar $01) + arg0), (Int ((Float ((arg3 Sar $01) + arg1)) - (1.0 * menuscale))), arg4, $01, $01)
    color($00, $00, $00)
    If ((local0 And mousehit1) <> 0) Then
        playsound_strict(buttonsfx)
        Return $01
    EndIf
    Return $00
End Function
