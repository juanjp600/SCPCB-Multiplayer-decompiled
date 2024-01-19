Function scalerender%(arg0#, arg1#, arg2#, arg3#)
    If (camera <> $00) Then
        hideentity(camera)
    EndIf
    wireframe($00)
    showentity(fresize_image)
    scaleentity(fresize_image, arg2, arg3, 1.0, $00)
    positionentity(fresize_image, arg0, arg1, 1.0001, $00)
    showentity(fresize_cam)
    renderworld(1.0)
    hideentity(fresize_cam)
    hideentity(fresize_image)
    wireframe(wireframestate)
    If (camera <> $00) Then
        showentity(camera)
    EndIf
    Return $00
End Function
