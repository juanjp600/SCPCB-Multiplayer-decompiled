Function multiplayer_writeitems%(arg0%)
    Local local0%
    Local local1.items
    local0 = $00
    For local1 = Each items
        If (local1\Field22 <> $00) Then
            If (player[local1\Field22]\Field68 = local1\Field18) Then
                local0 = $01
            EndIf
        EndIf
        If (((((hidedistance * 0.5) > entitydistance(local1\Field1, player[arg0]\Field13)) Or (local1\Field22 = arg0)) Or local0) <> 0) Then
            udp_writeshort(local1\Field18)
            udp_writeint(local1\Field3\Field0)
            udp_writefloat(entityx(local1\Field1, $01))
            udp_writefloat(entityy(local1\Field1, $01))
            udp_writefloat(entityz(local1\Field1, $01))
            udp_writebyte(local1\Field22)
        EndIf
        local0 = $00
    Next
    udp_writeshort($00)
    Return $00
End Function
