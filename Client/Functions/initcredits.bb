Function initcredits%()
    Local local0.creditsline
    Local local1%
    Local local2$
    local1 = openfile("Credits.txt")
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
