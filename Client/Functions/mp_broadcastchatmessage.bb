Function mp_broadcastchatmessage%(arg0$)
    If (mp_ishoster() = $00) Then
        Return $00
    EndIf
    mp_createchatmessage(arg0)
    mp_server_sendchatmessage(Null, arg0)
    Return $00
End Function
