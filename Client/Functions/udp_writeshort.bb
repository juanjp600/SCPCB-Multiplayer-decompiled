Function udp_writeshort%(arg0%)
    pokeshort(udp_network\Field14, udp_network\Field16, arg0)
    udp_network\Field16 = (udp_network\Field16 + $02)
    Return $00
End Function
