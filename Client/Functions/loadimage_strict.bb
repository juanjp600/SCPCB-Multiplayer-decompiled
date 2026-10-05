Function loadimage_strict%(arg0$)
    Local local0%
    If (filetype(arg0) <> $01) Then
        runtimeerror((((("Image " + chr($22)) + arg0) + chr($22)) + " missing. "))
    EndIf
    local0 = loadimage(arg0)
    Return local0
    Return $00
End Function
