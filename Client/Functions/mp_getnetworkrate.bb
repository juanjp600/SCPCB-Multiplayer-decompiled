Function mp_getnetworkrate%()
    If (network\Field9 < millisecs()) Then
        network\Field7 = network\Field8
        network\Field8 = $00
        network\Field9 = (millisecs() + $3E8)
    EndIf
    Return network\Field7
    Return $00
End Function
