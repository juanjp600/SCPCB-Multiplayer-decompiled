Function drawbaldbutton%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7%)
    Local local0%
    local0 = $00
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        color($1E, $1E, $1E)
        If (((mousehit1 And (arg6 = $00)) Or (mouseup1 And arg6)) <> 0) Then
            local0 = $01
            playsound_strict(buttonsfx)
        EndIf
        rect((arg0 + $02), (arg1 + $02), (arg2 - $02), (arg3 - $02), $01)
    Else
        color($00, $00, $00)
    EndIf
    color($FF, $FF, $FF)
    If (arg7 <> 0) Then
        If (arg5 <> 0) Then
            aasetfont(font2)
        Else
            aasetfont(font1)
        EndIf
        aatext(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01, 1.0)
    Else
        If (arg5 <> 0) Then
            setfont(font2)
        Else
            setfont(font1)
        EndIf
        text(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01)
    EndIf
    Return local0
    Return $00
End Function
