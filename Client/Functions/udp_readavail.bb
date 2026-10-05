Function udp_readavail%()
    If (networkserver\Field36 <> 0) Then
        Return steam_readavail()
    Else
        Return readavail(udp_network\Field0)
    EndIf
    Return $00
End Function
