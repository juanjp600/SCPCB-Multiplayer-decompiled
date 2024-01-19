Function udp_netin%(arg0%)
    udp_network\Field10[arg0] = (millisecs() + udp_readtimeout(arg0))
    Return $00
End Function
