Function createsecuritycam.securitycams(arg0#, arg1#, arg2#, arg3.rooms, arg4%)
    Local local0.securitycams
    Local local1#
    local0 = (New securitycams)
    local0\Field0 = copyentity(cambaseobj, $00)
    scaleentity(local0\Field0, 0.0015, 0.0015, 0.0015, $00)
    local0\Field3 = copyentity(camobj, $00)
    scaleentity(local0\Field3, 0.01, 0.01, 0.01, $00)
    local0\Field19 = arg3
    local0\Field7 = arg4
    If (arg4 <> 0) Then
        local0\Field22 = $01
        local0\Field18 = 12.0
        local1 = ((roomscale * 4.5) * 0.4)
        local0\Field4 = createsprite($00)
        entityfx(local0\Field4, $11)
        spriteviewmode(local0\Field4, $02)
        local0\Field9 = $00
        entitytexture(local0\Field4, screentexs[local0\Field9], $00, $00)
        scalesprite(local0\Field4, (((meshwidth(monitor) * local1) * 0.95) * 0.5), (((meshheight(monitor) * local1) * 0.95) * 0.5))
        local0\Field10 = createsprite(local0\Field4)
        scalesprite(local0\Field10, (((meshwidth(monitor) * local1) * 0.95) * 0.5), (((meshheight(monitor) * local1) * 0.95) * 0.5))
        moveentity(local0\Field10, 0.0, 0.0, -0.0005)
        entitytexture(local0\Field10, monitortexture, $00, $00)
        spriteviewmode(local0\Field10, $02)
        entityblend(local0\Field10, $03)
        local0\Field1 = copyentity(monitor, local0\Field4)
        scaleentity(local0\Field1, local1, local1, local1, $00)
        local0\Field8 = createcamera($00)
        cameraviewport(local0\Field8, $00, $00, $200, $200)
        camerarange(local0\Field8, 0.05, 8.0)
        camerazoom(local0\Field8, 0.8)
        hideentity(local0\Field8)
    EndIf
    positionentity(local0\Field0, arg0, arg1, arg2, $00)
    If (arg3 <> Null) Then
        entityparent(local0\Field0, arg3\Field2, $01)
    EndIf
    Return local0
    Return Null
End Function
