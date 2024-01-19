Function mp_createplayerobject%(arg0%)
    Local local0.breachtypes
    local0 = getbreachtype(classd_model)
    player[arg0]\Field64 = copyentity(local0\Field2, $00)
    scaleentity(player[arg0]\Field64, local0\Field3, local0\Field3, local0\Field3, $00)
    meshcullbox(player[arg0]\Field64, ((- meshwidth(player[arg0]\Field64)) * 2.0), ((- meshheight(player[arg0]\Field64)) * 2.0), ((- meshdepth(player[arg0]\Field64)) * 2.0), (meshwidth(player[arg0]\Field64) * 2.0), (meshheight(player[arg0]\Field64) * 4.0), (meshdepth(player[arg0]\Field64) * 4.0))
    player[arg0]\Field68 = createcamera($00)
    cameraviewport(player[arg0]\Field68, $00, $00, player[arg0]\Field71, player[arg0]\Field72)
    camerarange(player[arg0]\Field68, 0.05, 35.0)
    cameraprojmode(player[arg0]\Field68, $00)
    If (player[arg0]\Field62 = $00) Then
        player[arg0]\Field62 = createpivot($00)
        entityradius(player[arg0]\Field62, 0.15, 0.3)
        entitytype(player[arg0]\Field62, $02, $00)
        player[arg0]\Field69 = createcube($00)
        entityparent(player[arg0]\Field69, player[arg0]\Field62, $01)
        entitypickmode(player[arg0]\Field69, $02, $00)
        moveentity(player[arg0]\Field69, 0.0, -0.2, 0.0)
        entityalpha(player[arg0]\Field69, 0.0)
        player[arg0]\Field63 = createpivot($00)
        entityradius(player[arg0]\Field63, 0.15, 0.3)
        entitytype(player[arg0]\Field63, $03, $00)
    EndIf
    local0 = getbreachtype(player[arg0]\Field36)
    scaleentity(player[arg0]\Field69, local0\Field10, local0\Field11, local0\Field12, $00)
    entityparent(player[arg0]\Field68, player[arg0]\Field62, $01)
    moveentity(player[arg0]\Field68, 0.0, 0.6, 0.0)
    player[arg0]\Field90 = -1.0
    player[arg0]\Field95 = 2.0
    resetplayersize(arg0)
    Return $00
End Function
