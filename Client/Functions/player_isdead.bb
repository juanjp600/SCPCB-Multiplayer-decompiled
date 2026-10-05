Function player_isdead%()
    Return (((0.0 <= killtimer) = $00) Or (myplayer\Field49 = $00))
    Return $00
End Function
