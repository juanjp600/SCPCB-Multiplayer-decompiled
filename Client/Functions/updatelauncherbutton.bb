Function updatelauncherbutton%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7%, arg8%, arg9%, arg10%)
    Local local0%
    local0 = $00
    renderframe(arg0, arg1, arg2, arg3, $00, $00, arg7)
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        color($1E, $1E, $1E)
        If (((mo\Field0 And (arg6 = $00)) Lor (mo\Field6 And arg6)) <> 0) Then
            If (arg7 <> 0) Then
                playsound_strict(buttonsfx[$01], $00)
            Else
                local0 = $01
                playsound_strict(buttonsfx[$00], $00)
            EndIf
        EndIf
        rect((arg0 + $03), (arg1 + $03), (arg2 - $06), (arg3 - $06), $01)
    Else
        color($00, $00, $00)
    EndIf
    If (arg7 <> 0) Then
        If ((((arg8 <> $FF) Lor (arg9 <> $FF)) Lor (arg10 <> $FF)) <> 0) Then
            color(arg8, arg9, arg10)
        Else
            color($64, $64, $64)
        EndIf
    Else
        color(arg8, arg9, arg10)
    EndIf
    setfontex(fo\Field0[arg5])
    textex(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01)
    Return local0
    Return $00
End Function
