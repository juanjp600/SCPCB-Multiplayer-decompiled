Function startloadgame%(arg0$, arg1$)
    gameload = $01
    mainmenuopen = $00
    menuopen = $00
    loadentities()
    loadallsounds()
    loadgame(arg0)
    currsave = arg1
    initloadgame()
    Return $00
End Function
