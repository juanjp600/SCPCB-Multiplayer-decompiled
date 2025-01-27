Function server_playersnetworklogic%()
    Local local0.mp_player
    For local0 = Each mp_player
        updateplayernetworklogic(local0)
    Next
    Return $00
End Function
