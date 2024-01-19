Function multiplayer_initplayer%(arg0%)
    If (player[arg0]\Field12 <> $00) Then
        freeentity(player[arg0]\Field12)
        player[arg0]\Field12 = $00
    EndIf
    If (player[arg0]\Field27 = Null) Then
        gg_set_current_font(sound3dfont)
        player[arg0]\Field27 = gg_create_text_block("a", $40, $00, 1.0, 1.0, $00)
        scaleentity(player[arg0]\Field27\Field11, 0.02, 0.02, 0.02, $00)
    EndIf
    If (player[arg0]\Field26 = Null) Then
        gg_set_current_font(afk3dfont)
        player[arg0]\Field26 = gg_create_text_block("a", $40, $00, 1.0, 1.0, $00)
        scaleentity(player[arg0]\Field26\Field11, 0.02, 0.02, 0.02, $00)
    EndIf
    multiplayer_createplayerobject(arg0)
    Return $00
End Function
