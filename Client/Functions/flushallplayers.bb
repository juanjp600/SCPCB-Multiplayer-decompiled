Function flushallplayers%()
    Local local0.mp_player
    For local0 = Each mp_player
        flushplayer(local0\Field5)
    Next
    Return $00
End Function
