Function achievementtooltip%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    local0 = (Int (20.0 * menuscale))
    setfontex(fo\Field0[$02])
    local2 = jsongetvalue(localachievementsarray, "translations")
    local3 = jsongetvalue(achievementsarray, "translations")
    local4 = jsongetvalue(jsongetvalue(local2, arg0), "name")
    If (jsonisnull(local4) <> 0) Then
        local4 = jsongetvalue(jsongetvalue(local3, arg0), "name")
    EndIf
    local1 = stringwidth(jsongetstring(local4))
    local5 = (Int (50.0 * menuscale))
    setfontex(fo\Field0[$00])
    local7 = jsongetvalue(jsongetvalue(local2, arg0), "description")
    If (jsonisnull(local7) <> 0) Then
        local7 = jsongetvalue(jsongetvalue(local3, arg0), "description")
    EndIf
    local6 = stringwidth(jsongetstring(local7))
    If (local6 > local1) Then
        local1 = local6
    EndIf
    local1 = (local1 + local0)
    local8 = (Int (mouseposx + (Float local0)))
    local9 = (Int (mouseposy + (Float local0)))
    local10 = ((local1 Sar $01) + local8)
    color($19, $19, $19)
    rect(local8, local9, local1, local5, $01)
    color($96, $96, $96)
    rect(local8, local9, local1, local5, $00)
    setfontex(fo\Field0[$02])
    textex(local10, (Int ((35.0 * menuscale) + mouseposy)), jsongetstring(local4), $01, $01)
    setfontex(fo\Field0[$00])
    textex(local10, (Int ((55.0 * menuscale) + mouseposy)), jsongetstring(local7), $01, $01)
    Return $00
End Function
