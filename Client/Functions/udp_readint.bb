Function udp_readint%()
    If (networkserver\Field36 <> 0) Then
        Return steam_pullint()
    EndIf
    Return readint(udp_network\Field0)
    Return $00
End Function
