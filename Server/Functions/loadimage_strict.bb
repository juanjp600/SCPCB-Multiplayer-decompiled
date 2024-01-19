Function loadimage_strict%(arg0$)
    Local local0%
    arg0 = strippath(arg0)
    copyfile("GFX\bump.bmp", arg0)
    local0 = loadimage(arg0)
    deletefile(arg0)
    Return local0
    Return $00
End Function
