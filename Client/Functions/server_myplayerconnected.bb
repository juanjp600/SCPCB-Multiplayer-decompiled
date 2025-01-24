Function server_myplayerconnected%(arg0.mp_player)
    arg0\Field6 = mp_getclientname()
    server_playerconnected(arg0)
    Return $00
End Function
