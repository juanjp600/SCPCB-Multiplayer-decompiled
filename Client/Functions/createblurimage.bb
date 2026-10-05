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
    cameraviewport(local0, $00, $00, graphicwidth, graphicheight)
    local1 = createmesh(local0)
    local2 = createsurface(local1, $00)
    addvertex(local2, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0)
    addvertex(local2, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0)
    addvertex(local2, -1.0, -1.0, 0.0, 0.0, 1.0, 1.0)
    addvertex(local2, 1.0, -1.0, 0.0, 1.0, 1.0, 1.0)
    addtriangle(local2, $00, $01, $02)
    addtriangle(local2, $03, $02, $01)
    entityfx(local1, $11)
    scaleentity(local1, ((Float smallest_power_two) / (Float graphicwidth)), ((Float smallest_power_two) / (Float graphicwidth)), 1.0, $00)
    positionentity(local1, 0.0, 0.0, 1.0001, $00)
    entityorder(local1, $FFFE7960)
    entityblend(local1, $01)
    ark_blur_image = local1
    ark_blur_texture = createtexture(smallest_power_two, smallest_power_two, $100, $01)
    entitytexture(local1, ark_blur_texture, $00, $00)
    entityalpha(ark_blur_image, 0.0)
    Return $00
End Function
