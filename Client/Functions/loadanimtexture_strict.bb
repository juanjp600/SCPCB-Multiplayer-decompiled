Function loadanimtexture_strict%(arg0$, arg1%, arg2%, arg3%, arg4%, arg5%)
    Local local0%
    If (filetype(arg0) <> $01) Then
        runtimeerror((("Animated Texture " + arg0) + " not found."))
    EndIf
    local0 = loadanimtexture(arg0, (((enablevram = $01) * $00) + arg1), arg2, arg3, arg4, arg5)
    If (local0 = $00) Then
        runtimeerror(("Failed to load Animated Texture: " + arg0))
    EndIf
    Return local0
    Return $00
End Function
