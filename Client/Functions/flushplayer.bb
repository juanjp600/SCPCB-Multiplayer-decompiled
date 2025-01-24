Function flushplayer%(arg0%)
    If (ue_players[arg0] = Null) Then
        Return $00
    EndIf
    mp_dropplayeritems(ue_players[arg0])
    flushplayertags(ue_players[arg0])
    flushplayermodel(ue_players[arg0])
    flushplayerattaches(ue_players[arg0])
    flushplayerpivot(ue_players[arg0])
    flushplayervoice(ue_players[arg0])
    If (ue_players[arg0]\Field4 <> Null) Then
        Delete ue_players[arg0]\Field4
    EndIf
    Delete ue_players[arg0]\Field35
    Delete ue_players[arg0]
    mp_countplayers($FFFFFFFF)
    Return $01
    Return $00
End Function
