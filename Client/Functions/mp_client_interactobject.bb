Function mp_client_interactobject%(arg0%, arg1%)
    If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
        Return $00
    EndIf
    mp_writebyte($12)
    mp_writebyte(mp_getmyindex())
    mp_writebyte(arg1)
    mp_writebyte(arg0)
    mp_sendtoserver()
    Return $00
End Function
