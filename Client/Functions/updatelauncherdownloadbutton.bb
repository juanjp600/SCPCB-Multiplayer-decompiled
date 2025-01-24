Function updatelauncherdownloadbutton%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%)
    Local local0%
    local0 = $00
    color($32, $32, $32)
    If (arg5 = $00) Then
        If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
            If (mo\Field2 <> 0) Then
                local0 = $01
                color($1E, $1E, $1E)
            Else
                color($64, $64, $64)
            EndIf
        EndIf
    EndIf
    If (local0 <> 0) Then
        rect(arg0, arg1, arg2, arg3, $01)
        color($82, $82, $82)
        rect((arg0 + $01), (arg1 + $01), (arg2 - $01), (arg3 - $01), $00)
        color($0A, $0A, $0A)
        rect(arg0, arg1, arg2, arg3, $00)
        color($FF, $FF, $FF)
        line(arg0, ((arg1 + arg3) - $01), ((arg0 + arg2) - $01), ((arg1 + arg3) - $01))
        line(((arg0 + arg2) - $01), arg1, ((arg0 + arg2) - $01), ((arg1 + arg3) - $01))
    Else
        rect(arg0, arg1, arg2, arg3, $01)
        color($82, $82, $82)
        rect(arg0, arg1, (arg2 - $01), (arg3 - $01), $00)
        color($FF, $FF, $FF)
        rect(arg0, arg1, arg2, arg3, $00)
        color($0A, $0A, $0A)
        line(arg0, ((arg1 + arg3) - $01), ((arg0 + arg2) - $01), ((arg1 + arg3) - $01))
        line(((arg0 + arg2) - $01), arg1, ((arg0 + arg2) - $01), ((arg1 + arg3) - $01))
    EndIf
    color($FF, $FF, $FF)
    If (arg5 <> 0) Then
        color($64, $64, $64)
    EndIf
    textex(((arg2 Sar $01) + arg0), (((arg3 Sar $01) + arg1) - $01), arg4, $01, $01)
    color($00, $00, $00)
    If ((local0 And mo\Field0) <> 0) Then
        playsound_strict(buttonsfx[$00], $00)
        Return $01
    EndIf
    Return $00
End Function
