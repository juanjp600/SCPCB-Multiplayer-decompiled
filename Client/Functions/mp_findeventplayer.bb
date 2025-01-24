Function mp_findeventplayer.mp_player(arg0.events, arg1.mp_player)
    While (((arg1 <> Null) And ((entityhidden(arg1\Field18) Lor arg1\Field30) Lor (mp_rooms[arg1\Field22] <> arg0\Field1))) <> 0)
        arg1 = (After arg1)
    Wend
    Return arg1
    Return Null
End Function
