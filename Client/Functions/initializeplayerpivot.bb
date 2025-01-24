Function initializeplayerpivot%(arg0.mp_player)
    If (arg0\Field5 = mp_getmyindex()) Then
        arg0\Field18 = me\Field60
        arg0\Field19 = camera
        Return $00
    EndIf
    If (arg0\Field18 = $00) Then
        arg0\Field18 = createpivot($00)
        entityradius(arg0\Field18, 0.15, 0.3)
        entitytype(arg0\Field18, $02, $00)
        hideentity(arg0\Field18)
        arg0\Field19 = createcamera(arg0\Field18)
        positionentity(arg0\Field19, 0.0, 0.6, 0.0, $00)
        cameraviewport(arg0\Field19, $00, $00, opt\Field46, opt\Field47)
        camerarange(arg0\Field19, 0.01, 50.0)
        hideentity(arg0\Field19)
    EndIf
    Return $00
End Function
