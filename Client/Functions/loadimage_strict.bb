Function loadimage_strict%(arg0$)
    Local local0%
    If (filetype((lang\Field1 + arg0)) = $01) Then
        arg0 = (lang\Field1 + arg0)
    EndIf
    If (local0 = $00) Then
        If (filetype(arg0) <> $01) Then
            runtimeerrorex(format(getlocalstring("runerr", "image.notfound"), arg0, "%s"))
        EndIf
        local0 = loadimage(arg0)
        If (local0 = $00) Then
            runtimeerrorex(format(getlocalstring("runerr", "image.failed.load"), arg0, "%s"))
        EndIf
        If (opt\Field51 = $00) Then
            bufferdirty(imagebuffer(local0, $00))
        EndIf
    EndIf
    Return local0
    Return $00
End Function
