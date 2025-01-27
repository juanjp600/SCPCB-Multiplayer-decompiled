Function loadanimimage_strict%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    If (filetype((lang\Field1 + arg0)) = $01) Then
        arg0 = (lang\Field1 + arg0)
    EndIf
    If (local0 = $00) Then
        If (filetype(arg0) <> $01) Then
            runtimeerrorex(format(getlocalstring("runerr", "animimage.notfound"), arg0, "%s"))
        EndIf
        local0 = loadanimimage(arg0, arg1, arg2, arg3, arg4)
        If (local0 = $00) Then
            runtimeerrorex(format(getlocalstring("runerr", "animimage.failed.load"), arg0, "%s"))
        EndIf
        If (opt\Field51 = $00) Then
            bufferdirty(imagebuffer(local0, $00))
        EndIf
    EndIf
    Return local0
    Return $00
End Function
