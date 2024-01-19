Function rcon_executecmd$(arg0$, arg1$)
    Select lower(arg0)
        Case "kick"
            rcon_kick(arg1)
        Case "banip"
            rcon_banip("banlist", arg1)
        Case "banid"
            rcon_bansteamid("banliststeam", (Int arg1))
        Case "reloadbanlist"
            rcon_reloadbanlist("banlist")
        Case "hostname"
            rcon_hostname(arg1)
        Case "restart"
            rcon_restart()
        Case "gravity"
            rcon_gravity((Float arg1))
        Case "password"
            rcon_password(arg1)
        Case "seed"
            rcon_mapseed(arg1)
        Case "difficulty"
            rcon_difficulty((Int arg1))
        Case "startmatch"
            shouldstartround = $01
    End Select
    Return arg0
    Return ""
End Function
