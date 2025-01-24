Function mp_receivedplayerinfo%(arg0.mp_player)
    arg0\Field16 = mp_readbyte()
    arg0\Field17 = arg0\Field16
    mp_client_recvplayermodel(arg0)
    arg0\Field6 = mp_readline()
    mp_client_recvplayertags(arg0)
    playerloadedinfo(arg0)
    Return $00
End Function
