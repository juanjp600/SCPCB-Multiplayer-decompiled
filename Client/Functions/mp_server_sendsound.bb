Function mp_server_sendsound%(arg0.mp_player, arg1$, arg2%, arg3%, arg4#, arg5#, arg6#, arg7#, arg8#)
    mp_writebyte($0F)
    mp_writebyte(arg2)
    mp_writeline(arg1)
    If (arg2 = $01) Then
        mp_writebyte(arg3)
        mp_writefloat(arg4)
        mp_writefloat(arg5)
        If (arg3 = $00) Then
            mp_writefloat(arg6)
            mp_writefloat(arg7)
            mp_writefloat(arg8)
        EndIf
    EndIf
    mp_send(arg0\Field0, arg0\Field1)
    Return $00
End Function
