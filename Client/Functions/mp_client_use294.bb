Function mp_client_use294%(arg0$)
    If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
        Return $00
    EndIf
    mp_writebyte($10)
    mp_writebyte(mp_getmyindex())
    mp_writeline(arg0)
    mp_sendtoserver()
    Return $00
End Function
