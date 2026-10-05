Function loadcustomprogressbars%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    local0 = (Int (50.0 * invmenuscale))
    local1 = imenuscale[$08]
    local2 = imenuscale[$0E]
    local3 = (local1 * local0)
    If (sprintbar <> $00) Then
        freeimage(sprintbar)
        sprintbar = $00
    EndIf
    If (blinkbar <> $00) Then
        freeimage(blinkbar)
        blinkbar = $00
    EndIf
    resizeimage(staminameterimg, (Float local1), (Float local2))
    resizeimage(blinkmeterimg, (Float local1), (Float local2))
    sprintbar = createimage(local3, local2, $01)
    blinkbar = createimage(local3, local2, $01)
    setbuffer(imagebuffer(sprintbar, $00))
    For local4 = $00 To (local0 - $01) Step $01
        drawimage(staminameterimg, (local4 * local1), $00, $00)
    Next
    setbuffer(imagebuffer(blinkbar, $00))
    For local4 = $00 To (local0 - $01) Step $01
        drawimage(blinkmeterimg, (local4 * local1), $00, $00)
    Next
    setbuffer(backbuffer())
    Return $00
End Function
