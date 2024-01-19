Function udp_fillreceivebuffer%(arg0%)
    readbytes(udp_network\Field15, udp_network\Field0, $00, arg0)
    Return $00
End Function
