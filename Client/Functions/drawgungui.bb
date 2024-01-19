Function drawgungui%()
    updateguncrosshair((((recoil - (5.0 * crouchstate)) + (200.0 * currspeed)) - (Float (eqquipedgun\Field29 Shl $01))))
    Return $00
End Function
