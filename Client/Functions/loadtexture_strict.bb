Function loadtexture_strict%(arg0$, arg1%)
    Local local0%
    If (filetype(arg0) <> $01) Then
        runtimeerror((("Texture " + arg0) + " not found."))
    EndIf
    local0 = loadtexture(arg0, (((enablevram = $01) Shl $08) + arg1))
    If (local0 = $00) Then
        runtimeerror(("Failed to load Texture: " + arg0))
    EndIf
    Return local0
    Return $00
End Function
