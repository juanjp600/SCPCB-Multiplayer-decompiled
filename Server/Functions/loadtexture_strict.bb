Function loadtexture_strict%(arg0$, arg1%)
    Local local0%
    arg0 = strippath(arg0)
    copyfile("GFX\bump.bmp", arg0)
    local0 = loadtexture(arg0, arg1)
    deletefile(arg0)
    Return local0
    Return $00
End Function
