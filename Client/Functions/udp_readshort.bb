Function udp_readshort%()
    Local local0%
    If ((udp_network\Field17 + $02) > udp_readfullavail()) Then
        Return $00
    EndIf
    local0 = peekshort(udp_network\Field15, udp_network\Field17)
    udp_network\Field17 = (udp_network\Field17 + $02)
    Return local0
    Return $00
End Function
