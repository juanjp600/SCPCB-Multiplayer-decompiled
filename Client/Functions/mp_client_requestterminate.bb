Function mp_client_requestterminate%()
    If ((mp_ishoster() Lor (mp_getsocket() = $00)) <> 0) Then
        Return $00
    EndIf
    mp_writebyte($0D)
    mp_writebyte(mp_getmyindex())
    mp_sendtoserver()
    Return $00
End Function
