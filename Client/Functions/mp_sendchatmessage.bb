Function mp_sendchatmessage%(arg0$)
    If (mp_ishoster() <> 0) Then
        mp_server_sendchatmessage(ue_players[mp_getmyindex()], ((mp_getclientname() + ": ") + arg0))
        Return $00
    EndIf
    mp_client_sendchatmessage(arg0)
    Return $00
End Function
