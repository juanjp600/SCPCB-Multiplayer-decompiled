Function reloadimage%(arg0$, arg1%, arg2%, arg3%)
    freeimage(arg1)
    arg1 = loadimage_strict(arg0)
    resizeimage(arg1, (Float arg2), (Float arg3))
    Return arg1
    Return $00
End Function
