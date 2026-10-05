Function achievementtooltip%(arg0%)
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    Local local4#
    setfontex(fonts[$02]\Field0)
    local0 = (Float stringwidth(achievementstrings(arg0)))
    setfontex(fonts[$00]\Field0)
    If (local0 < (Float stringwidth(achievementdescs(arg0)))) Then
        local0 = (Float stringwidth(achievementdescs(arg0)))
    EndIf
    local0 = ((20.0 * menuscale) + local0)
    local1 = (local0 * 0.5)
    local2 = (Int (38.0 * achvscale))
    local3 = ((20.0 * menuscale) + (Float mouseposx))
    local4 = ((20.0 * menuscale) + (Float mouseposy))
    setcolorex($19, $19, $19)
    rect((Int local3), (Int local4), (Int local0), local2, $01)
    setcolorex($96, $96, $96)
    rect((Int local3), (Int local4), (Int local0), local2, $00)
    setfontex(fonts[$02]\Field0)
    text((Int (local3 + local1)), (Int ((35.0 * menuscale) + (Float mouseposy))), achievementstrings(arg0), $01, $01)
    setfontex(fonts[$00]\Field0)
    text((Int (local3 + local1)), (Int ((55.0 * menuscale) + (Float mouseposy))), achievementdescs(arg0), $01, $01)
    Return $00
End Function
