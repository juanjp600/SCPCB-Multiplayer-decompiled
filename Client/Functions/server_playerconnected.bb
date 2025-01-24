Function server_playerconnected%(arg0.mp_player)
    setplayermodel(arg0, $01, $00)
    playerloadedinfo(arg0)
    Return $00
End Function
