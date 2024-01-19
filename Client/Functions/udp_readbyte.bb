Function udp_readbyte%()
    Local local0%
    If ((udp_network\Field17 + $01) > udp_readfullavail()) Then
        Return $00
    EndIf
    local0 = peekbyte(udp_network\Field15, udp_network\Field17)
    udp_network\Field17 = (udp_network\Field17 + $01)
    Return local0
    Return $00
End Function
