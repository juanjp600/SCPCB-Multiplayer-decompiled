Function initnetwork%()
    network = (New mp_network)
    network\Field0 = (New mp_packet)
    network\Field1 = createnetworkbuffer($4000)
    network\Field2 = createnetworkbuffer($2000)
    network\Field3 = createnetworkbuffer($4000)
    Return $00
End Function
