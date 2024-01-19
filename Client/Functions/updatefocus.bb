Function updatefocus%()
    infocus = (api_getforegroundwindow() = screen_hwnd)
    If (infocus = $00) Then
        menu_open_type = $02
        flushkeys()
        flushmouse()
    Else
        menu_open_type = menuopen
    EndIf
    Return infocus
    Return $00
End Function
