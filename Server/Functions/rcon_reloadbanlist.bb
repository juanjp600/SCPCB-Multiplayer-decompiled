Function rcon_reloadbanlist%()
    Local local0.banned
    For local0 = Each banned
        Delete local0
    Next
    rcon_loadbanlist("player_cache\local\ipbanlist.dat")
    rcon_loadsteambanlist("player_cache\local\steambanlist.dat")
    Return $00
End Function
