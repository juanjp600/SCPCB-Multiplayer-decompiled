Function initgamma%()
    Local local0%
    Local local1%
    local0 = createmesh(camera)
    local1 = createsurface(local0, $00)
    addvertex(local1, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0)
    addvertex(local1, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0)
    addvertex(local1, -1.0, -1.0, 0.0, 0.0, 1.0, 1.0)
    addvertex(local1, 1.0, -1.0, 0.0, 1.0, 1.0, 1.0)
    addtriangle(local1, $00, $01, $02)
    addtriangle(local1, $03, $02, $01)
    entityfx(local0, $09)
    scaleentity(local0, 1.0, 1.0, 1.0, $01)
    moveentity(local0, 0.0, 0.0, 0.1)
    entityorder(local0, $FFFFD8F1)
    entityblend(local0, $03)
    entitycolor(local0, 40.0, 40.0, 40.0)
    fresize_image = local0
    Return $00
End Function
