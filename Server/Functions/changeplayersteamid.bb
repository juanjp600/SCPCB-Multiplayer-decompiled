Function changeplayersteamid%(arg0%, arg1%)
    Local local0%
    For local0 = $01 To server\Field18 Step $01
        If (player[local0] <> Null) Then
            udp_writebyte($6D)
            udp_writebyte(arg0)
            udp_writeline(player[arg0]\Field15)
            udp_writeline(player[arg0]\Field157)
            udp_writebyte(player[arg0]\Field158)
            udp_writebyte(player[arg0]\Field159)
            udp_writebyte(player[arg0]\Field160)
            udp_writeshort((Int (player[arg0]\Field28 * 100.0)))
            udp_writeint(arg1)
            udp_writebyte(player[arg0]\Field39)
            udp_sendmessage(local0)
        EndIf
    Next
    player[arg0]\Field129 = arg1
    Return $00
End Function
