Function udp_writebytes%(arg0%, arg1%, arg2%)
    copybank(arg0, $00, udp_network\Field14, udp_network\Field16, arg2)
    udp_network\Field16 = (udp_network\Field16 + arg2)
    Return $00
End Function
