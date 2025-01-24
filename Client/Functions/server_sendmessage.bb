Function server_sendmessage%(arg0.mp_player, arg1$, arg2#, arg3%)
    If (arg0\Field5 = mp_getmyindex()) Then
        Return $00
    EndIf
    mp_writebyte($0C)
    mp_writeline(arg1)
    mp_writebyte(arg3)
    mp_writefloat(arg2)
    mp_send(arg0\Field0, arg0\Field1)
    Return $00
End Function
