Function blitz_mp_writebyte0%(arg0.mp_netbuffer, arg1%)
    pokebyte(arg0\Field0, arg0\Field2, arg1)
    arg0\Field2 = (arg0\Field2 + $01)
    Return $00
End Function
