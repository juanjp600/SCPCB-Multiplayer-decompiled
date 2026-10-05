Function ui_showpointer%()
    If (fullscreen = $01) Then
        drawimage(cursorimg, mouseposx, mouseposy, $00)
    Else
        showpointer()
    EndIf
    Return $00
End Function
