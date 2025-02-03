Function mp_client_usedoor%(arg0.doors, arg1.items, arg2%, arg3%)
    If ((mp_ishoster() Lor (mp_getsocket() = $00)) <> 0) Then
        Return $00
    EndIf
    mp_writebyte($07)
    mp_writebyte(mp_getmyindex())
    mp_writeshort(arg0\Field39)
    mp_writebyte(arg2)
    mp_writeint(arg3)
    If (arg1 <> Null) Then
        mp_writeshort(arg1\Field19)
    Else
        mp_writeshort($00)
    EndIf
    mp_sendtoserver()
    arg0\Field40 = 35.0
    If (arg0\Field21 <> Null) Then
        arg0\Field21\Field40 = 35.0
    EndIf
    Return $00
End Function
