Function drawgungui%()
    If (spectate\Field1 = $FFFFFFFF) Then
        updateguncrosshair((((recoil - (5.0 * crouchstate)) + (currspeed * 1000.0)) - (Float eqquipedgun\Field31)))
    EndIf
    renderammotext()
    Return $00
End Function
