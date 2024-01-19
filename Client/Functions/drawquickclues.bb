Function drawquickclues%()
    aasetfont(font1)
    color($C8, $C8, $C8)
    drawimage(info_image, (Int ((Float (graphicwidth Sar $01)) - (20.0 * menuscale))), (Int (60.0 * menuscale)), $00)
    rowtext(currentclue\Field0, ((Float (graphicwidth Sar $01)) - (165.0 * menuscale)), (120.0 * menuscale), (350.0 * menuscale), (120.0 * menuscale), $01, 1.0, $01)
    If (currentclue\Field1 < millisecs()) Then
        resetclue((Object.clues clues[rand($00, (getcluescount() - $01))]))
    EndIf
    Return $00
End Function
