Function udp_recvudpmsg%()
    If (networkserver\Field36 <> 0) Then
        Return steam_loadpacket()
    Else
        Return recvudpmsg(udp_network\Field0)
    EndIf
    Return $00
End Function
