Function se_getparamint%()
    If (flipped = $00) Then
        currentparam = $00
        flipped = $01
    EndIf
    currentparam = (currentparam + $01)
    Return (Int se_tostringarg((currentparam - $01), ""))
    Return $00
End Function
