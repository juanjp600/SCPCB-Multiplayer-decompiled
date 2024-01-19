Function multiplayer_createplayer.players(arg0%)
    If (((arg0 < $01) Or (arg0 > $41)) <> 0) Then
        Return Null
    EndIf
    If (player[arg0] <> Null) Then
        Return player[arg0]
    EndIf
    player[arg0] = (New players)
    player[arg0]\Field44 = (millisecs() + $3A98)
    player[arg0]\Field0 = arg0
    player[arg0]\Field60 = createbank($00)
    player[arg0]\Field65 = mainplayersvolume
    player[arg0]\Field51 = (networkserver\Field15 * model_wait)
    player[arg0]\Field75 = graphicwidth
    player[arg0]\Field76 = graphicheight
    player[arg0]\Field87 = opus_get_new_decoder()
    player[arg0]\Field89 = $FF
    player[arg0]\Field90 = $FF
    player[arg0]\Field91 = $FF
    player[arg0]\Field92 = 1.0
    If (arg0 = networkserver\Field28) Then
        player[arg0]\Field75 = graphicwidth
        player[arg0]\Field76 = graphicheight
        player[arg0]\Field95 = currentsteamid
        myplayer = player[arg0]
    EndIf
    Return player[arg0]
    Return Null
End Function
