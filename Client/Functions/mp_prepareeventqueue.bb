Function mp_prepareeventqueue%(arg0.events)
    Local local0.mp_player
    If (arg0\Field22 <> Null) Then
        local0 = (After arg0\Field22)
    EndIf
    local0 = mp_findeventplayer(arg0, local0)
    If (local0 = Null) Then
        local0 = mp_findeventplayer(arg0, (First mp_player))
    EndIf
    arg0\Field22 = local0
    If (arg0\Field22 = Null) Then
        arg0\Field22 = ue_players[mp_getmyindex()]
    EndIf
    Return $00
End Function
