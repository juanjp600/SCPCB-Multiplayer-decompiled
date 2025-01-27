Function rendercursor%()
    If (((opt\Field51 <> $00) Lor onpalette) <> 0) Then
        Return $00
    EndIf
    drawimage(cursorimg, (Int mouseposx), (Int mouseposy), $00)
    Return $00
End Function
