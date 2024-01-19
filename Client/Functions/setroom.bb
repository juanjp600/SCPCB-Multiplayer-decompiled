Function setroom%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    Local local1%
    multiplayer_send($01, $00, $00)
    If (arg4 < arg3) Then
        debuglog(("Can't place " + arg0))
        Return $00
    EndIf
    debuglog((("--- SETROOM: " + upper(arg0)) + " ---"))
    local0 = $00
    local1 = $01
    While (maproom(arg1, arg2) <> "")
        debuglog(("found " + maproom(arg1, arg2)))
        arg2 = (arg2 + $01)
        If (arg2 > arg4) Then
            If (local0 = $00) Then
                arg2 = (arg3 + $01)
                local0 = $01
            Else
                local1 = $00
                Exit
            EndIf
        EndIf
    Wend
    debuglog(((arg0 + " ") + (Str arg2)))
    If (local1 = $01) Then
        debuglog("--------------")
        maproom(arg1, arg2) = arg0
        Return $01
    Else
        debuglog(("couldn't place " + arg0))
        Return $00
    EndIf
    Return $00
End Function
