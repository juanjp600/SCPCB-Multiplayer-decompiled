Function event_resetprev%()
    playerroom = event_prevplayerroom
    me\Field60 = getrealcollider()
    Return $00
End Function
