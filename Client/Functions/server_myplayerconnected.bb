Function server_myplayerconnected%(arg0.mp_player)
    arg0\Field6 = mp_getclientname()
    server_playerconnected(arg0)
    mp_setspawnpoint()
    Return $00
End Function
