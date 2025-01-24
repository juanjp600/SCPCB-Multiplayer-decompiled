Function mp_client_explorecorpse%(arg0.mp_playercorpse)
    If ((mp_ishoster() Lor (mp_getsocket() = $00)) <> 0) Then
        Return $00
    EndIf
    mp_writebyte($0E)
    mp_writebyte(mp_getmyindex())
    mp_writebyte(arg0\Field0)
    mp_sendtoserver()
    Return $00
End Function
