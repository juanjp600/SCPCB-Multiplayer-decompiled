Function loadtexture_strict%(arg0$, arg1%, arg2%, arg3%)
    Local local0%
    If (local0 = $00) Then
        If (filetype(arg0) <> $01) Then
            runtimeerrorex(format(getlocalstring("runerr", "texture.notfound"), arg0, "%s"))
        EndIf
        local0 = loadtexturecheckingifincache(arg0, arg1, arg2)
        If (((local0 <> $00) And arg3) <> 0) Then
            textureblend(local0, $05)
        EndIf
        If (local0 = $00) Then
            runtimeerrorex(format(getlocalstring("runerr", "texture.failed.load"), arg0, "%s"))
        EndIf
    EndIf
    Return local0
    Return $00
End Function
