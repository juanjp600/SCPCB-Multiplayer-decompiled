Function blitz_mp_readbytes0%(arg0.mp_netbuffer, arg1%, arg2%, arg3%)
    copybank(arg0\Field0, arg0\Field1, arg1, arg3, arg2)
    arg0\Field1 = (arg0\Field1 + arg2)
    Return $00
End Function
