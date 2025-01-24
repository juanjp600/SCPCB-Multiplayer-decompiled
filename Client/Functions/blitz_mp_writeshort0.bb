Function blitz_mp_writeshort0%(arg0.mp_netbuffer, arg1%)
    pokeshort(arg0\Field0, arg0\Field2, arg1)
    arg0\Field2 = (arg0\Field2 + $02)
    Return $00
End Function
