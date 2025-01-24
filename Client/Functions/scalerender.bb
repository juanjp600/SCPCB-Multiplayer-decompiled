Function scalerender%(arg0#, arg1#, arg2#, arg3#)
    If (camera <> $00) Then
        hideentity(camera)
    EndIf
    wireframe($00)
    showentity(fresizeimage)
    scaleentity(fresizeimage, arg2, arg3, 1.0, $00)
    positionentity(fresizeimage, arg0, arg1, 1.0001, $00)
    showentity(fresizecam)
    renderworld(1.0)
    hideentity(fresizecam)
    hideentity(fresizeimage)
    wireframe(wireframestate)
    If (camera <> $00) Then
        showentity(camera)
    EndIf
    Return $00
End Function
