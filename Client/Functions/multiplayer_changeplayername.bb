Function multiplayer_changeplayername%(arg0%, arg1$, arg2$)
    If (player[arg0]\Field25 <> Null) Then
        gg_delete_text_block(player[arg0]\Field25\Field11)
    EndIf
    If (player[arg0]\Field28 <> Null) Then
        gg_delete_text_block(player[arg0]\Field28\Field11)
    EndIf
    gg_set_current_font(text3dfont)
    player[arg0]\Field25 = gg_create_text_block(arg1, $20, $00, 1.0, 1.0, $00)
    scaleentity(player[arg0]\Field25\Field11, 0.02, 0.02, 0.02, $00)
    player[arg0]\Field24 = arg1
    player[arg0]\Field88 = arg2
    If (arg2 <> "") Then
        gg_set_current_font(text3dfont)
        player[arg0]\Field28 = gg_create_text_block(arg2, $20, $00, 1.0, 1.0, $00)
        scaleentity(player[arg0]\Field28\Field11, 0.02, 0.02, 0.02, $00)
    EndIf
    Return $00
End Function
