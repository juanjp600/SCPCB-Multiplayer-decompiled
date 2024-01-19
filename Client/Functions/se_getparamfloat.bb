Function se_getparamfloat#()
    If (flipped = $00) Then
        currentparam = $00
        flipped = $01
    EndIf
    currentparam = (currentparam + $01)
    Return (Float se_tostringarg((currentparam - $01), ""))
    Return 0.0
End Function
