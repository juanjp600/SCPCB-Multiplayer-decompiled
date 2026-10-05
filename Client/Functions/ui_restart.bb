Function ui_restart%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    consoleopen = $00
    consolescroll = $00
    consolefullheight = $00
    consolemsgcount = $00
    consolescrolldragging = $00
    consolemousemem = $00
    consoleinput = ""
    consolereissue = Null
    networkserver\Field19 = $00
    chatscroll = $00
    chatscrolldragging = $00
    chatmousemem = $00
    chatmsgcount = $00
    chatedittype = $00
    typedchatmsg = ""
    selectedinputbox = $00
    local0 = $00
    local1 = (graphicheight - imenuscale[$12C])
    local2 = graphicwidth
    local3 = imenuscale[$10E]
    ui_register($00, local0, local1, local2, local3, $01)
    ui_register($01, chatoffsetx, chatoffsety, chatwidth, chatheight, $01)
    ui_setupdate($00, $01)
    ui_setupdate($01, $01)
    Return $00
End Function
