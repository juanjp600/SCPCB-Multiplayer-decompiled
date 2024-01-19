Function render2d%()
    updateblur(blurvolume)
    multiplayer_updategui($01)
    drawgui()
    updateconsole()
    rendermessages()
    drawquickloading()
    updateachievementmsg()
    Return $00
End Function
