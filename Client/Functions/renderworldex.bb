Function renderworldex%(arg0#)
    cameraprojmode(arkblurcam, $00)
    cameraprojmode(camera, $01)
    cameraviewport(camera, $00, $00, opt\Field46, opt\Field47)
    If (wi\Field7 = $00) Then
        renderworld(arg0)
    EndIf
    currtrisamount = trisrendered()
    cameraprojmode(arkblurcam, $02)
    cameraprojmode(camera, $00)
    If (wi\Field7 = $00) Then
        renderworld(arg0)
    EndIf
    cameraprojmode(arkblurcam, $00)
    Return $00
End Function
