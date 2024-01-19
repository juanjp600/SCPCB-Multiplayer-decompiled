Function rcon_reloadbanlist%(arg0$)
    Local local0.banned
    For local0 = Each banned
        Delete local0
    Next
    rcon_loadbanlist(arg0)
    rcon_loadsteambanlist((arg0 + "steam"))
    Return $00
End Function
