Function drawquickclues%()
    setfontex(fonts[$00]\Field0)
    setcolorex($C8, $C8, $C8)
    drawimage(info_image, (Int ((Float viewport_center_x) - (20.0 * menuscale))), (Int (60.0 * menuscale)), $00)
    rowtext(currentclue\Field0, ((Float viewport_center_x) - (165.0 * menuscale)), (120.0 * menuscale), (350.0 * menuscale), (120.0 * menuscale), $01, 1.0, $01)
    If (currentclue\Field1 < millisecs()) Then
        resetclue((Object.clues clues[rand($00, (getcluescount() - $01))]))
    EndIf
    Return $00
End Function
