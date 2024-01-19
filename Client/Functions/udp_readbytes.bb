Function udp_readbytes%(arg0%, arg1%, arg2%)
    Local local0%
    local0 = (Int min((Float arg2), (Float udp_readavail())))
    copybank(udp_network\Field15, udp_network\Field17, arg0, arg1, local0)
    udp_network\Field17 = (udp_network\Field17 + local0)
    Return local0
    Return $00
End Function
