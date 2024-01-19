Function startnewgame%()
    If (currsave = "") Then
        currsave = "untitled"
    EndIf
    selectedmap = ""
    gameload = $01
    mainmenuopen = $00
    loadentities()
    loadallsounds()
    initnewgame()
    flushkeys()
    flushmouse()
    Return $00
End Function
