Function initcredits%()
    Local local0.creditsline
    Local local1%
    Local local2$
    local1 = openfile_strict("Credits.txt")
    fo\Field0[$06] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Credits", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Credits", "Size", "", $01)), $00, $00)
    fo\Field0[$07] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Credits_Big", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Credits_Big", "Size", "", $01)), $00, $00)
    If (me\Field46 = $00) Then
        me\Field46 = scaleimageex(loadimage_strict("GFX\Menu\credits_screen.png"), menuscale, menuscale, $01)
    EndIf
    Repeat
        local2 = readline(local1)
        local0 = (New creditsline)
        local0\Field0 = local2
    Until (eof(local1) <> 0)
    Delete (First creditsline)
    me\Field47 = 0.0
    Return $00
End Function
