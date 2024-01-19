Function initfastresize%()
    Local local0%
    Local local1%
    Local local2%
    local0 = createcamera($00)
    cameraprojmode(local0, $02)
    camerazoom(local0, 0.1)
    cameraclsmode(local0, $00, $00)
    camerarange(local0, 0.1, 1.5)
    moveentity(local0, 0.0, 0.0, -10000.0)
    fresize_cam = local0
    local1 = createmesh(local0)
    local2 = createsurface(local1, $00)
    addvertex(local2, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0)
    addvertex(local2, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0)
    addvertex(local2, -1.0, -1.0, 0.0, 0.0, 1.0, 1.0)
    addvertex(local2, 1.0, -1.0, 0.0, 1.0, 1.0, 1.0)
    addtriangle(local2, $00, $01, $02)
    addtriangle(local2, $03, $02, $01)
    entityfx(local1, $11)
    scaleentity(local1, (smallest_power_two / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicheight)), 1.0, $00)
    positionentity(local1, 0.0, 0.0, 1.0001, $00)
    entityorder(local1, $FFFE795F)
    entityblend(local1, $01)
    fresize_image = local1
    fresize_texture = createtexture((Int smallest_power_two), (Int smallest_power_two), $101, $01)
    fresize_texture2 = createtexture((Int smallest_power_two), (Int smallest_power_two), $101, $01)
    textureblend(fresize_texture2, $03)
    setbuffer(texturebuffer(fresize_texture2, $00))
    clscolor($00, $00, $00)
    cls()
    setbuffer(backbuffer())
    entitytexture(local1, fresize_texture, $00, $00)
    entitytexture(local1, fresize_texture2, $00, $01)
    hideentity(fresize_cam)
    Return $00
End Function
