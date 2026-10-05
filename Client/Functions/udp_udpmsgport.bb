Function udp_udpmsgport%()
    If (networkserver\Field36 <> 0) Then
        Return steam_getsenderidlower()
    EndIf
    Return udpmsgport(udp_network\Field0)
    Return $00
End Function
