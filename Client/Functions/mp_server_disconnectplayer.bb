Function mp_server_disconnectplayer%(arg0.mp_player, arg1$)
    mp_broadcastchatmessage(format(arg1, arg0\Field6, "%s"))
    flushplayer(arg0)
    Return $00
End Function
