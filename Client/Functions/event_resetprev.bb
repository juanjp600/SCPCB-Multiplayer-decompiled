Function event_resetprev%()
    playerroom = event_prevplayerroom
    me\Field60 = event_prevplayercollider
    Return $00
End Function
