Function drawbutton%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7%, arg8%, arg9%, arg10%, arg11%, arg12%, arg13%, arg14%)
    Local local0%
    local0 = $00
    drawframe(arg0, arg1, arg2, arg3, $00, $00)
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        color($1E, $1E, $1E)
        If (((mousehit1 And (arg6 = $00)) Or (mouseup1 And arg6)) <> 0) Then
            local0 = $01
            If (((((selectserver <> arg8) And (arg8 <> $FFFFFFFF)) Or ((selected_servers <> arg9) And (arg9 <> $FFFFFFFF))) And (((arg8 <> $FFFFFFFF) And (servermenuopen = $01)) = $00)) <> 0) Then
                playsound_strict(buttonsfx)
            EndIf
            If (((arg8 = $FFFFFFFF) And (arg9 = $FFFFFFFF)) <> 0) Then
                playsound_strict(buttonsfx)
            EndIf
        EndIf
        If (((arg8 <> $FFFFFFFF) And (arg8 = selectserver)) <> 0) Then
            rect((arg0 + $04), (arg1 + $04), (arg2 - $08), (arg3 - $08), $01)
        ElseIf (arg8 = $FFFFFFFF) Then
            rect((arg0 + $04), (arg1 + $04), (arg2 - $08), (arg3 - $08), $01)
        EndIf
    ElseIf (arg8 <> $FFFFFFFF) Then
        If (arg8 = selectserver) Then
            color($1E, $1E, $1E)
            rect((arg0 + $04), (arg1 + $04), (arg2 - $08), (arg3 - $08), $01)
        Else
            color($00, $00, $00)
        EndIf
    Else
        color($00, $00, $00)
    EndIf
    If (((arg10 = selected_page) Or (arg10 = selected_p_page)) <> 0) Then
        rect((arg0 + $04), (arg1 + $04), (arg2 - $08), (arg3 - $08), $01)
    EndIf
    If (arg11 <> $FFFFFFFF) Then
        color(arg11, arg12, arg13)
    Else
        color($FF, $FF, $FF)
    EndIf
    If (((arg9 <> $FFFFFFFF) And (arg9 = selected_servers)) <> 0) Then
        color($46, $46, $46)
    EndIf
    If (arg7 <> 0) Then
        If (arg5 = $01) Then
            aasetfont(font2)
        ElseIf (arg5 <> $00) Then
            aasetfont(arg5)
        Else
            aasetfont(font1)
        EndIf
        aatext(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01, 1.0)
    Else
        If (arg5 = $01) Then
            setfont(font2)
        ElseIf (arg5 <> $00) Then
            setfont(arg5)
        Else
            setfont(font1)
        EndIf
        text(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01)
    EndIf
    If (((arg8 <> $FFFFFFFF) And (servermenuopen = $01)) <> 0) Then
        Return $00
    EndIf
    If (local0 <> 0) Then
        Delete Each errors
        If (arg14 = $00) Then
            If (getscripts() <> 0) Then
                public_inqueue($14, $00)
                public_addparam(arg4, $03)
                public_addparam((Str arg0), $01)
                public_addparam((Str arg1), $01)
                public_addparam((Str arg2), $01)
                public_addparam((Str arg3), $01)
                callback()
            EndIf
            If (se_return_value\Field8 <> 0) Then
                local0 = $00
            EndIf
        EndIf
    EndIf
    Return local0
    Return $00
End Function
