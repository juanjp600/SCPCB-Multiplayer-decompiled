Function mp_createplayerobject%(arg0%)
    Local local0.breachtypes
    local0 = getbreachtype(classd_model)
    player[arg0]\Field66 = copyentity(local0\Field2, $00)
    scaleentity(player[arg0]\Field66, local0\Field3, local0\Field3, local0\Field3, $00)
    meshcullbox(player[arg0]\Field66, ((- meshwidth(player[arg0]\Field66)) * 2.0), ((- meshheight(player[arg0]\Field66)) * 2.0), ((- meshdepth(player[arg0]\Field66)) * 2.0), (meshwidth(player[arg0]\Field66) * 2.0), (meshheight(player[arg0]\Field66) * 4.0), (meshdepth(player[arg0]\Field66) * 4.0))
    player[arg0]\Field70 = createcamera($00)
    cameraviewport(player[arg0]\Field70, $00, $00, player[arg0]\Field73, player[arg0]\Field74)
    camerarange(player[arg0]\Field70, 0.05, 35.0)
    cameraprojmode(player[arg0]\Field70, $00)
    If (player[arg0]\Field64 = $00) Then
        player[arg0]\Field64 = createpivot($00)
        entityradius(player[arg0]\Field64, 0.15, 0.3)
        entitytype(player[arg0]\Field64, $02, $00)
        player[arg0]\Field71 = createcube($00)
        entityparent(player[arg0]\Field71, player[arg0]\Field64, $01)
        entitypickmode(player[arg0]\Field71, $02, $00)
        moveentity(player[arg0]\Field71, 0.0, -0.2, 0.0)
        entityalpha(player[arg0]\Field71, 0.0)
        player[arg0]\Field65 = createpivot($00)
        entityradius(player[arg0]\Field65, 0.15, 0.3)
        entitytype(player[arg0]\Field65, $03, $00)
    EndIf
    local0 = getbreachtype(player[arg0]\Field36)
    scaleentity(player[arg0]\Field71, local0\Field10, local0\Field11, local0\Field12, $00)
    entityparent(player[arg0]\Field70, player[arg0]\Field64, $01)
    moveentity(player[arg0]\Field70, 0.0, 0.6, 0.0)
    player[arg0]\Field92 = -1.0
    player[arg0]\Field97 = 2.0
    resetplayersize(arg0)
    Return $00
End Function
