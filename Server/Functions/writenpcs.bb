Function writenpcs%(arg0%)
    Local local0.npcs
    udp_writebyte(notarget)
    For local0 = Each npcs
        If (((((((local0\Field80 <> $00) Or (hidedistance > entitydistance(local0\Field4, player[arg0]\Field62))) Or (curr106 = local0)) Or (curr5131 = local0)) Or (curr096 = local0)) Or (curr173 = local0)) <> 0) Then
            udp_writebyte(local0\Field6)
            udp_writebyte(local0\Field5)
            udp_writebyte((Int local0\Field24))
            udp_writefloat(local0\Field9)
            udp_writefloat(local0\Field10)
            udp_writefloat(local0\Field11)
            udp_writefloat(entityx(local0\Field4, $01))
            udp_writefloat(entityy(local0\Field4, $01))
            udp_writefloat(entityz(local0\Field4, $01))
            udp_writefloat(entityyaw(local0\Field4, $01))
            udp_writefloat(animtime(local0\Field0))
            udp_writebyte(local0\Field67)
            udp_writebyte(local0\Field80)
            udp_writebyte(local0\Field81)
            If (local0\Field31 <> Null) Then
                udp_writebyte(local0\Field31\Field6)
            Else
                udp_writebyte($00)
            EndIf
        EndIf
    Next
    udp_writebyte($00)
    Return $00
End Function
