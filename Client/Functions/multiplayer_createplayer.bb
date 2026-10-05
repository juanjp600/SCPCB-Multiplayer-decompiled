Function multiplayer_createplayer.players(arg0%)
    If (((arg0 < $01) Or (arg0 > $41)) <> 0) Then
        Return Null
    EndIf
    If (player[arg0] <> Null) Then
        Return player[arg0]
    EndIf
    player[arg0] = (New players)
    player[arg0]\Field42 = (millisecs() + $3A98)
    player[arg0]\Field0 = arg0
    player[arg0]\Field58 = createbank($00)
    player[arg0]\Field63 = mainplayersvolume
    player[arg0]\Field49 = (networkserver\Field12 * model_wait)
    player[arg0]\Field73 = graphicwidth
    player[arg0]\Field74 = graphicheight
    player[arg0]\Field85 = opus_get_new_decoder()
    player[arg0]\Field87 = $FF
    player[arg0]\Field88 = $FF
    player[arg0]\Field89 = $FF
    player[arg0]\Field90 = 1.0
    If (arg0 = networkserver\Field20) Then
        player[arg0]\Field73 = graphicwidth
        player[arg0]\Field74 = graphicheight
        player[arg0]\Field93 = steamid64
        myplayer = player[arg0]
    EndIf
    Return player[arg0]
    Return Null
End Function
