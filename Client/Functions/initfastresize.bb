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
    fresizecam = local0
    local1 = createmesh(local0)
    local2 = createsurface(local1, $00)
    addvertex(local2, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0)
    addvertex(local2, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0)
    addvertex(local2, -1.0, -1.0, 0.0, 0.0, 1.0, 1.0)
    addvertex(local2, 1.0, -1.0, 0.0, 1.0, 1.0, 1.0)
    addtriangle(local2, $00, $01, $02)
    addtriangle(local2, $03, $02, $01)
    entityfx(local1, $11)
    scaleentity(local1, (smallest_power_two / graphicwidthfloat), (smallest_power_two / graphicheightfloat), 1.0, $00)
    positionentity(local1, 0.0, 0.0, 1.0001, $00)
    entityorder(local1, $FFFE795F)
    entityblend(local1, $01)
    fresizeimage = local1
    fresizetexture = createtexture((Int smallest_power_two), (Int smallest_power_two), $101, $01)
    fresizetexture2 = createtexture((Int smallest_power_two), (Int smallest_power_two), $101, $01)
    textureblend(fresizetexture2, $03)
    setbuffer(texturebuffer(fresizetexture2, $00))
    clscolor($00, $00, $00)
    cls()
    setbuffer(backbuffer())
    entitytexture(local1, fresizetexture, $00, $00)
    entitytexture(local1, fresizetexture2, $00, $01)
    hideentity(fresizecam)
    Return $00
End Function
