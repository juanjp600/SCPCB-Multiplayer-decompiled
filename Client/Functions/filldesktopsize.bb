Function filldesktopsize%()
    Local local0%
    local0 = createbank($10)
    api_getclientrect(api_getdesktopwindow(), local0)
    win\Field4 = (peekint(local0, $08) - peekint(local0, $00))
    win\Field5 = (peekint(local0, $0C) - peekint(local0, $04))
    freebank(local0)
    Return $00
End Function
