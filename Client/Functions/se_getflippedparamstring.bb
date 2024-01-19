Function se_getflippedparamstring$()
    currentparam = (currentparam - $01)
    If (currentparam = $FFFFFFFE) Then
        Return ""
    EndIf
    Return se_tostringarg((currentparam + $01), "")
    Return ""
End Function
