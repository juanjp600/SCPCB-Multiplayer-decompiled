Function udp_getstream%()
    Return (((udp_network\Field0 <> $00) Or networkserver\Field36) And (networkserver\Field20 <> $00))
    Return $00
End Function
