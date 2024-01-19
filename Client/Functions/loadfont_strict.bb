Function loadfont_strict%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    If (filetype(arg0) <> $01) Then
        runtimeerror((("Font " + arg0) + " not found."))
    EndIf
    local0 = loadfont(arg0, arg1, arg2, arg3, arg4)
    If (local0 = $00) Then
        runtimeerror(("Failed to load Font: " + arg0))
    EndIf
    Return local0
    Return $00
End Function
