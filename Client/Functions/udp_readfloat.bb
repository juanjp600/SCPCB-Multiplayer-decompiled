Function udp_readfloat#()
    If (networkserver\Field36 <> 0) Then
        Return steam_pullfloat()
    EndIf
    Return readfloat(udp_network\Field0)
    Return 0.0
End Function
