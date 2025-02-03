Function loadfont_strict%(arg0$, arg1%, arg2%, arg3%)
    Local local0%
    If (filetype((lang\Field1 + arg0)) = $01) Then
        arg0 = (lang\Field1 + arg0)
    EndIf
    If (local0 = $00) Then
        If (filetype(arg0) <> $01) Then
            runtimeerrorex(format(getlocalstring("runerr", "font.notfound"), arg0, "%s"))
        EndIf
        local0 = loadfont(arg0, arg3)
        If (local0 = $00) Then
            runtimeerrorex(format(getlocalstring("runerr", "font.failed.load"), arg0, "%s"))
        EndIf
    EndIf
    Return local0
    Return $00
End Function
