Function mp_server_disconnectplayer%(arg0.mp_player, arg1$)
    mp_broadcastchatmessage(((arg0\Field6 + " ") + arg1))
    flushplayer(arg0)
    Return $00
End Function
