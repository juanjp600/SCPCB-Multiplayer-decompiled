Function multiplayer_initplayer%(arg0%)
    Local local0%
    If (player[arg0]\Field12 <> $00) Then
        freeentity(player[arg0]\Field12)
        player[arg0]\Field12 = $00
    EndIf
    If (entityexist(player[arg0]\Field25[$02]) = $00) Then
        local0 = createsprite($00)
        scalesprite(local0, 0.04, 0.04)
        spriteviewmode(local0, $04)
        entityfx(local0, $0F)
        entitytexture(local0, voicespritetexture, $00, $00)
        player[arg0]\Field25[$02] = local0
    EndIf
    If (entityexist(player[arg0]\Field25[$01]) = $00) Then
        local0 = createsprite($00)
        scalesprite(local0, 0.07, 0.07)
        spriteviewmode(local0, $04)
        entityfx(local0, $0F)
        entitytexture(local0, afkspritetexture, $00, $00)
        player[arg0]\Field25[$01] = local0
    EndIf
    multiplayer_createplayerobject(arg0)
    Return $00
End Function
