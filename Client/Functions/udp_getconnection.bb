Function udp_getconnection%()
    Return ((udp_network\Field0 <> $00) Or (networkserver\Field36 = $01))
    Return $00
End Function
