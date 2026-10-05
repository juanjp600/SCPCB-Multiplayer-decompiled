Function udp_readshort%()
    If (networkserver\Field36 <> 0) Then
        Return steam_pullshort()
    EndIf
    Return readshort(udp_network\Field0)
    Return $00
End Function
