Function loadanimtexture_strict%(arg0$, arg1%, arg2%, arg3%, arg4%, arg5%, arg6%)
    Local local0%
    If (local0 = $00) Then
        If (filetype(arg0) <> $01) Then
            runtimeerrorex(format(getlocalstring("runerr", "animtexture.notfound"), arg0, "%s"))
        EndIf
        local0 = loadanimtexturecheckingifincache(arg0, arg1, arg2, arg3, arg4, arg5, arg6)
        If (local0 = $00) Then
            runtimeerrorex(format(getlocalstring("runerr", "animtexture.failed.load"), arg0, "%s"))
        EndIf
    EndIf
    Return local0
    Return $00
End Function
