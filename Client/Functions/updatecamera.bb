Function updatecamera%()
    lightvolume = curvevalue(templightvolume, lightvolume, 50.0)
    camerafogrange(camera, (camerafognear * lightvolume), (camerafogfar * lightvolume))
    camerafogmode(camera, $01)
    camerafogcolor(camera, 0.0, 0.0, 0.0)
    cameraclscolor(camera, 0.0, 0.0, 0.0, 1.0)
    camerarange(camera, 0.02, min(((camerafogfar * lightvolume) * 1.5), 28.0))
    ambientlight(120.0, 120.0, 120.0)
    camerashake = max((camerashake - (fpsfactor * 0.1)), 0.0)
    Return $00
End Function
