Function loadbrush_strict%(arg0$, arg1%, arg2#, arg3#)
    Local local0%
    If (filetype(arg0) <> $01) Then
        runtimeerror((("Brush Texture " + arg0) + "not found."))
    EndIf
    local0 = loadbrush(arg0, arg1, arg2, arg3)
    If (local0 = $00) Then
        runtimeerror(("Failed to load Brush: " + arg0))
    EndIf
    Return local0
    Return $00
End Function
