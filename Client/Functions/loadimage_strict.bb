Function loadimage_strict%(arg0$)
    Local local0%
    Local local1%
    If (filetype(arg0) <> $01) Then
        runtimeerror((((("Image " + chr($22)) + arg0) + chr($22)) + " missing. "))
    EndIf
    local0 = loadimage(arg0)
    Return local0
    If (local0 = $00) Then
        local1 = loadimage(arg0)
    EndIf
    debuglog(("Attempting to load again: " + arg0))
    Return local1
    Return $00
End Function
