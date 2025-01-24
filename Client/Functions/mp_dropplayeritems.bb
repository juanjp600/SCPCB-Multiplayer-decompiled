Function mp_dropplayeritems%(arg0.mp_player)
    Local local0.items
    For local0 = Each items
        mp_dropplayeritem(arg0, local0)
    Next
    Return $00
End Function
