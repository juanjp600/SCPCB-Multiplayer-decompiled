Function initcredits%()
    Local local0.creditsline
    Local local1%
    Local local2$
    local1 = openfile("Credits.txt")
    creditsfont = loadfont_strict("GFX\font\cour\Courier New.ttf", (Int (((Float graphicheight) / 1024.0) * 21.0)), $00, $00, $00)
    creditsfont2 = loadfont_strict("GFX\font\courbd\Courier New.ttf", (Int (((Float graphicheight) / 1024.0) * 35.0)), $00, $00, $00)
    If (creditsscreen = $00) Then
        creditsscreen = loadimage_strict("GFX\creditsscreen.pt")
    EndIf
    Repeat
        local2 = readline(local1)
        local0 = (New creditsline)
        local0\Field0 = local2
    Until (eof(local1) <> 0)
    Delete (First creditsline)
    creditstimer = 0.0
    Return $00
End Function
