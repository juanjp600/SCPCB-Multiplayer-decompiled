Function udp_updatedelta%(arg0%)
    If (arg0 = $00) Then
        udp_network\Field19 = millisecs2()
        udp_network\Field20 = ((Float (udp_network\Field19 - udp_network\Field21)) / 1000.0)
        udp_network\Field21 = udp_network\Field19
        udp_network\Field23 = udp_network\Field22
        udp_network\Field22 = (udp_network\Field20 * 70.0)
    Else
        udp_network\Field23 = udp_network\Field22
        udp_network\Field22 = (Float (millisecs2() - udp_network\Field19))
        udp_network\Field19 = millisecs2()
    EndIf
    Return $00
End Function
