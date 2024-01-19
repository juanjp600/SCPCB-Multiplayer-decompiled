Function skipdataplayer%()
    If (networkserver\Field43 = $01) Then
        otherindex2 = udp_readbyte()
        If (otherindex2 <> $00) Then
            udp_readfloat()
            udp_readfloat()
            udp_readfloat()
            udp_readshort()
            udp_readshort()
            udp_readbyte()
            udp_readfloat()
            udp_readbyte()
            udp_readbyte()
            udp_readshort()
            udp_readbyte()
            udp_readbyte()
            udp_readshort()
            udp_readbyte()
        Else
            udp_readshort()
            udp_readbyte()
        EndIf
    Else
        udp_readbyte()
        udp_readshort()
        udp_readbyte()
    EndIf
    Return $00
End Function
