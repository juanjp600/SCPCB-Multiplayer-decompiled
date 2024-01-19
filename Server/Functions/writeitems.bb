Function writeitems%(arg0%)
    Local local0.items
    For local0 = Each items
        If ((((7.5 > entitydistance(local0\Field1, player[arg0]\Field62)) Or (local0\Field22 = arg0)) And (((local0\Field22 < $01) Or (player[local0\Field22]\Field56 = local0\Field18)) Or (local0\Field22 = arg0))) <> 0) Then
            udp_writeshort(local0\Field18)
            udp_writeint(local0\Field3\Field0)
            udp_writefloat(entityx(local0\Field1, $01))
            udp_writefloat(entityy(local0\Field1, $01))
            udp_writefloat(entityz(local0\Field1, $01))
            udp_writebyte(local0\Field22)
        EndIf
    Next
    Return $00
End Function
