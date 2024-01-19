Function udp_readint%()
    Local local0%
    If ((udp_network\Field17 + $04) > udp_readfullavail()) Then
        Return $00
    EndIf
    local0 = peekint(udp_network\Field15, udp_network\Field17)
    udp_network\Field17 = (udp_network\Field17 + $04)
    Return local0
    Return $00
End Function
