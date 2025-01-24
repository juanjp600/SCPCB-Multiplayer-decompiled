Function initializeplayerattaches%(arg0.mp_player)
    Local local0%
    For local0 = $00 To $09 Step $01
        arg0\Field35\Field21[local0] = (New mp_playerattach)
    Next
    Return $00
End Function
