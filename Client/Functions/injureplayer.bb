Function injureplayer%(arg0#, arg1#, arg2#, arg3#, arg4#)
    If (((currentsyncplayer <> Null) And (currentsyncplayer <> ue_players[mp_getmyindex()])) <> 0) Then
        If (currentsyncplayer\Field4 <> Null) Then
            currentsyncplayer\Field4\Field6 = ((((currentsyncplayer\Field4\Field6 + arg0) - ((Float (getplayerattachmodel(currentsyncplayer, $01) = $05)) * arg3)) - (((Float (getplayerattachmodel(currentsyncplayer, $01) = $06)) * arg3) * 1.4)) - ((Float (getplayerattachmodel(currentsyncplayer, $02) = $07)) * arg4))
        EndIf
        Return $00
    EndIf
    me\Field31 = ((((me\Field31 + arg0) - ((Float (wi\Field3 = $01)) * arg3)) - (((Float (wi\Field3 = $02)) * arg3) * 1.4)) - ((Float wi\Field4) * arg4))
    me\Field49 = (me\Field49 + ((Float (0.0 = i_1025\Field1[$03])) * arg2))
    i_008\Field0 = (i_008\Field0 + ((Float (wi\Field2 = $00)) * arg1))
    Return $00
End Function
