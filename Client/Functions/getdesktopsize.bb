Function getdesktopsize%()
    Local local0%
    local0 = createbank($10)
    api_getclientrect(api_getdesktopwindow(), local0)
    g_desktop_screen_width = (peekint(local0, $08) - peekint(local0, $00))
    g_desktop_screen_height = (peekint(local0, $0C) - peekint(local0, $04))
    freebank(local0)
    Return $00
End Function
