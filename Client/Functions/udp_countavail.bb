Function udp_countavail%(arg0#)
    udp_network\Field4 = (udp_network\Field4 + (arg0 / 1000.0))
    Return $00
End Function
