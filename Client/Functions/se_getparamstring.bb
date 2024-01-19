Function se_getparamstring$()
    If (flipped = $00) Then
        currentparam = $00
        flipped = $01
    EndIf
    currentparam = (currentparam + $01)
    Return se_tostringarg((currentparam - $01), "")
    Return ""
End Function
