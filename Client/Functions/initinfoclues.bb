Function initinfoclues%(arg0$)
    Local local0%
    Local local1%
    Delete Each clues
    If (info_image <> $00) Then
        freeimage(info_image)
    EndIf
    For local0 = $00 To $1F Step $01
        clues[local0] = $FFFFFFFF
    Next
    local1 = readfile(arg0)
    If (local1 = $00) Then
        Return $00
    EndIf
    While (eof(local1) = $00)
        createquickclue(readline(local1))
    Wend
    closefile(local1)
    info_image = loadimage_strict("GFX\multiplayer\menu\info.png")
    resizeimage(info_image, (40.0 * menuscale), (40.0 * menuscale))
    maskimage(info_image, $00, $00, $00)
    resetclue((Object.clues clues[rand($00, (getcluescount() - $01))]))
    Return $00
End Function
