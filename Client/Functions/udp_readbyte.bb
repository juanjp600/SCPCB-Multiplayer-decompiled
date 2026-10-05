Function udp_readbyte%()
    If (networkserver\Field36 <> 0) Then
        Return steam_pullbyte()
    EndIf
    Return readbyte(udp_network\Field0)
    Return $00
End Function
