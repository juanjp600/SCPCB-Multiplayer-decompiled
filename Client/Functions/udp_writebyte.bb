Function udp_writebyte%(arg0%)
    pokebyte(udp_network\Field14, udp_network\Field16, arg0)
    udp_network\Field16 = (udp_network\Field16 + $01)
    Return $00
End Function
