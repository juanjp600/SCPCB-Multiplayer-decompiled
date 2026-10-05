Function drawbaldbutton%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7%)
    Local local0%
    local0 = $00
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        setcolorex($1E, $1E, $1E)
        If (((mousehit1 And (arg6 = $00)) Or (mouseup1 And arg6)) <> 0) Then
            local0 = $01
            playsound_strict(buttonsfx)
        EndIf
        rect((arg0 + $02), (arg1 + $02), (arg2 - $02), (arg3 - $02), $01)
    Else
        setcolorraw($00)
    EndIf
    setcolorex($FF, $FF, $FF)
    If (arg7 <> 0) Then
        If (arg5 <> 0) Then
            setfontex(fonts[$01]\Field0)
        Else
            setfontex(fonts[$00]\Field0)
        EndIf
        text((Int (((Float arg2) * 0.5) + (Float arg0))), (Int (((Float arg3) * 0.5) + (Float arg1))), arg4, $01, $01)
    Else
        If (arg5 <> 0) Then
            setfontex(fonts[$01]\Field0)
        Else
            setfontex(fonts[$00]\Field0)
        EndIf
        text((Int (((Float arg2) * 0.5) + (Float arg0))), (Int (((Float arg3) * 0.5) + (Float arg1))), arg4, $01, $01)
    EndIf
    Return local0
    Return $00
End Function
