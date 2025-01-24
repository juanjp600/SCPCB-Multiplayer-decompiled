Function resetinput%()
    stopmousemovement()
    flushkeys()
    flushmouse()
    mo\Field0 = $00
    mo\Field1 = $00
    mo\Field2 = $00
    mo\Field6 = $00
    mousehit($01)
    mousehit($02)
    mousedown($01)
    grabbedentity = $00
    input_resettime = 10.0
    Return $00
End Function
