Function mp_client_sendchatmessage%(arg0$)
    Local local0%
    If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
        Return $00
    EndIf
    mp_chat\Field4 = (mp_chat\Field4 + $01)
    For local0 = $00 To $01 Step $01
        mp_writebyte($13)
        mp_writebyte(mp_getmyindex())
        mp_writeline(arg0)
        mp_writeint(mp_chat\Field4)
        mp_sendtoserver()
    Next
    Return $00
End Function
