Function alinitialise%(arg0%, arg1#, arg2#)
    alinit(arg1, arg2)
    aldeviceinit(arg0, $04, $FFFFFFFF)
    Return $00
End Function
