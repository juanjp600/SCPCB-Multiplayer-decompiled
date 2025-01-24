Function blitz_mp_writefloat0%(arg0.mp_netbuffer, arg1#)
    pokefloat(arg0\Field0, arg0\Field2, arg1)
    arg0\Field2 = (arg0\Field2 + $04)
    Return $00
End Function
