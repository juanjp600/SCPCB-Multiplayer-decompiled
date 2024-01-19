Function writecorpses%(arg0%)
    Local local0.corpses
    For local0 = Each corpses
        If (70.0 > distance3(local0\Field2, local0\Field3, local0\Field4, entityx(player[arg0]\Field62, $00), entityy(player[arg0]\Field62, $00), entityz(player[arg0]\Field62, $00))) Then
            udp_writebyte(local0\Field0)
            udp_writebyte(local0\Field1)
            udp_writefloat(local0\Field2)
            udp_writefloat(local0\Field3)
            udp_writefloat(local0\Field4)
            udp_writeshort(local0\Field5)
            udp_writeshort(local0\Field7)
            udp_writebyte((local0\Field9 + (local0\Field10 Shl $01)))
        EndIf
    Next
    Return $00
End Function
