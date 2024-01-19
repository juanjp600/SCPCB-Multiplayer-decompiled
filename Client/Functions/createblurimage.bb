Function createblurimage%()
    Local local0%
    Local local1%
    Local local2%
    local0 = createcamera($00)
    cameraprojmode(local0, $02)
    camerazoom(local0, 0.1)
    cameraclsmode(local0, $00, $00)
    camerarange(local0, 0.1, 1.5)
    moveentity(local0, 0.0, 0.0, 10000.0)
    ark_blur_cam = local0
    ark_sw = graphicwidth
    ark_sh = graphicheight
    cameraviewport(local0, $00, $00, ark_sw, ark_sh)
    local1 = createmesh(local0)
    local2 = createsurface(local1, $00)
    addvertex(local2, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0)
    addvertex(local2, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0)
    addvertex(local2, -1.0, -1.0, 0.0, 0.0, 1.0, 1.0)
    addvertex(local2, 1.0, -1.0, 0.0, 1.0, 1.0, 1.0)
    addtriangle(local2, $00, $01, $02)
    addtriangle(local2, $03, $02, $01)
    entityfx(local1, $11)
    scaleentity(local1, (smallest_power_two / (Float ark_sw)), (smallest_power_two / (Float ark_sw)), 1.0, $00)
    positionentity(local1, 0.0, 0.0, 1.0001, $00)
    entityorder(local1, $FFFE7960)
    entityblend(local1, $01)
    ark_blur_image = local1
    ark_blur_texture = createtexture((Int smallest_power_two), (Int smallest_power_two), $100, $01)
    entitytexture(local1, ark_blur_texture, $00, $00)
    Return $00
End Function
