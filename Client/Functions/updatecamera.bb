Function updatecamera%()
    lightvolume = curvevalue(templightvolume, lightvolume, 50.0)
    camerafogrange(camera, (camerafognear * lightvolume), (camerafogfar * lightvolume))
    camerafogcolor(camera, 0.0, 0.0, 0.0)
    camerafogmode(camera, $01)
    camerarange(camera, 0.05, min(((camerafogfar * lightvolume) * 1.5), 28.0))
    If (playerroom\Field7\Field11 <> "pocketdimension") Then
        cameraclscolor(camera, 0.0, 0.0, 0.0)
    EndIf
    ambientlight((Float brightness), (Float brightness), (Float brightness))
    camerashake = max((camerashake - (fpsfactor / 10.0)), 0.0)
    Return $00
End Function
