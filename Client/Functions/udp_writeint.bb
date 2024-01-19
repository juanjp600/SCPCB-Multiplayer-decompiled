Function udp_writeint%(arg0%)
    pokeint(udp_network\Field14, udp_network\Field16, arg0)
    udp_network\Field16 = (udp_network\Field16 + $04)
    Return $00
End Function
