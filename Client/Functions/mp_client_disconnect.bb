Function mp_client_disconnect%()
    If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
        Return $00
    EndIf
    mp_writebyte($14)
    mp_writebyte(mp_getmyindex())
    mp_sendtoserver()
    Return $00
End Function
