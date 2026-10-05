Function render2d%()
    If (0.0 < blurvolume) Then
        updateblur(blurvolume)
    EndIf
    multiplayer_updategui($01)
    drawgui()
    updateconsole()
    rendermessages()
    drawquickloading()
    updateachievementmsg()
    Return $00
End Function
