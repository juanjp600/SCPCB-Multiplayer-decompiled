Function resetinput%()
    flushkeys()
    flushmouse()
    mousehit1 = $00
    mousehit2 = $00
    mousedown1 = $00
    mouseup1 = $00
    mousehit($01)
    mousehit($02)
    mousedown($01)
    grabbedentity = $00
    input_resettime = 10.0
    Return $00
End Function
