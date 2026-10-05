Function createplayer.players(arg0%)
    If (player[arg0] <> Null) Then
        Return player[arg0]
    EndIf
    player[arg0] = (New players)
    player[arg0]\Field30 = arg0
    player[arg0]\Field76 = (server\Field46 = "")
    player[arg0]\Field120 = 1.0
    player[arg0]\Field160 = ""
    player[arg0]\Field161 = $FF
    player[arg0]\Field162 = $FF
    player[arg0]\Field163 = $FF
    player[arg0]\Field92 = -1.0
    player[arg0]\Field28 = 1.0
    If (arg0 > $00) Then
        server\Field11 = (server\Field11 + $01)
        playeroptimize[server\Field11] = player[arg0]
    EndIf
    Return player[arg0]
    Return Null
End Function
