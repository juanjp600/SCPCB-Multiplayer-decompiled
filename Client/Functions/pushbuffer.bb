Function pushbuffer%(arg0%, arg1%, arg2%, arg3%)
    resizebank(arg2, (banksize(arg2) + arg3))
    copybank(arg0, arg1, arg2, (banksize(arg2) - arg3), arg3)
    Return arg0
    Return $00
End Function
