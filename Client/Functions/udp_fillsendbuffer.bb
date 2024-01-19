Function udp_fillsendbuffer%()
    writebytes(udp_network\Field14, udp_network\Field0, $00, udp_network\Field16)
    Return $00
End Function
