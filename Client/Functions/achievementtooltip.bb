Function achievementtooltip%(arg0%)
    Local local0#
    Local local1%
    Local local2%
    local0 = ((Float graphicheight) / 768.0)
    aasetfont(font3)
    local1 = aastringwidth(achievementstrings(arg0))
    aasetfont(font1)
    If (aastringwidth(achievementdescs(arg0)) > local1) Then
        local1 = aastringwidth(achievementdescs(arg0))
    EndIf
    local1 = (Int ((20.0 * menuscale) + (Float local1)))
    local2 = (Int (38.0 * local0))
    color($19, $19, $19)
    rect((Int ((20.0 * menuscale) + (Float scaledmousex()))), (Int ((20.0 * menuscale) + (Float scaledmousey()))), local1, local2, $01)
    color($96, $96, $96)
    rect((Int ((20.0 * menuscale) + (Float scaledmousex()))), (Int ((20.0 * menuscale) + (Float scaledmousey()))), local1, local2, $00)
    aasetfont(font3)
    aatext((Int (((20.0 * menuscale) + (Float scaledmousex())) + (Float (local1 Sar $01)))), (Int ((35.0 * menuscale) + (Float scaledmousey()))), achievementstrings(arg0), $01, $01, 1.0)
    aasetfont(font1)
    aatext((Int (((20.0 * menuscale) + (Float scaledmousex())) + (Float (local1 Sar $01)))), (Int ((55.0 * menuscale) + (Float scaledmousey()))), achievementdescs(arg0), $01, $01, 1.0)
    Return $00
End Function
