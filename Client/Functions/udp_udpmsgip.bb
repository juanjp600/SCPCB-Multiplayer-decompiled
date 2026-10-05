Function udp_udpmsgip%()
    If (networkserver\Field36 <> 0) Then
        Return steam_getsenderidupper()
    EndIf
    Return udpmsgip(udp_network\Field0)
    Return $00
End Function
