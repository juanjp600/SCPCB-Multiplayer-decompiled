Function udp_readfloat#()
    Local local0#
    If ((udp_network\Field17 + $04) > udp_readfullavail()) Then
        Return 0.0
    EndIf
    local0 = peekfloat(udp_network\Field15, udp_network\Field17)
    udp_network\Field17 = (udp_network\Field17 + $04)
    Return local0
    Return 0.0
End Function
