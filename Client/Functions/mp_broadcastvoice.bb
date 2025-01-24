Function mp_broadcastvoice%(arg0%, arg1%, arg2%, arg3%, arg4%)
    mp_writebyte($0A)
    mp_writebyte(arg2)
    If (mp_ishoster() <> 0) Then
        mp_writebyte(arg4)
    EndIf
    mp_writebytes(arg3, banksize(arg3), $00)
    mp_send(arg0, arg1)
    Return $00
End Function
