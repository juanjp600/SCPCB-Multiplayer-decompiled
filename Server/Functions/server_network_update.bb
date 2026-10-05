Function server_network_update%()
    Local local0.players
    Local local1.players
    Local local2%
    bytestreamreset(compactbank[$00])
    bytestreamreset(compactbank[$01])
    For local2 = $01 To server\Field11 Step $01
        local1 = playeroptimize[local2]
        bytestreamwritechar(compactbank[$00], local1\Field30)
        If (server\Field9 > $00) Then
            bytestreamwritechar(compactbank[$00], local1\Field36)
            If (local1\Field36 <> $00) Then
                bytestreamwritefloat(compactbank[$00], entityx(local1\Field64, $00))
                bytestreamwritefloat(compactbank[$00], (entityy(local1\Field64, $00) - 0.32))
                bytestreamwritefloat(compactbank[$00], entityz(local1\Field64, $00))
                bytestreamwriteshort(compactbank[$00], converttoshort(local1\Field3))
                bytestreamwriteshort(compactbank[$00], converttoshort(local1\Field16))
                bytestreamwritechar(compactbank[$00], local1\Field37)
                bytestreamwritefloat(compactbank[$00], local1\Field17)
                bytestreamwritechar(compactbank[$00], local1\Field78)
                bytestreamwritechar(compactbank[$00], (Int local1\Field27))
                bytestreamwriteshort(compactbank[$00], local1\Field33)
                bytestreamwritechar(compactbank[$00], local1\Field38)
                bytestreamwritechar(compactbank[$00], local1\Field35)
                bytestreamwriteshort(compactbank[$00], local1\Field58)
                bytestreamwritechar(compactbank[$00], local1\Field32)
            Else
                bytestreamwriteshort(compactbank[$00], local1\Field33)
                bytestreamwritechar(compactbank[$00], local1\Field38)
            EndIf
        Else
            bytestreamwritechar(compactbank[$00], local1\Field25)
            bytestreamwriteshort(compactbank[$00], local1\Field33)
            bytestreamwritechar(compactbank[$00], local1\Field22)
        EndIf
        bytestreamwritechar(compactbank[$01], local1\Field30)
        bytestreamwritechar(compactbank[$01], local1\Field25)
        bytestreamwriteshort(compactbank[$01], local1\Field33)
        bytestreamwritechar(compactbank[$01], local1\Field22)
    Next
    For local2 = $01 To server\Field11 Step $01
        local0 = playeroptimize[local2]
        udp_writebyte($3C)
        udp_writebyte($01)
        udp_writebyte((server\Field9 * local0\Field76))
        udp_writebyte(local0\Field36)
        udp_writefloat(server\Field20)
        udp_writeint((Int max(-1.0, (Float (gameinfo\Field5\Field2 - millisecs())))))
        udp_writeint((Int max(-1.0, (Float (gameinfo\Field5\Field1 - millisecs())))))
        udp_writeshort(local0\Field33)
        If ((server\Field9 * local0\Field76) > $00) Then
            udp_writebytes(getbytestreamdata(compactbank[$00]), $00, getbytestreamdatasize(compactbank[$00]))
        Else
            udp_writebytes(getbytestreamdata(compactbank[$01]), $00, getbytestreamdatasize(compactbank[$01]))
        EndIf
        udp_writebyte($00)
        udp_writeshort(converttoshort(secondarylighton))
        udp_writebyte(((remotedooron Shl $01) + contained106))
        udp_writeshort((Int mtftimer))
        udp_writeshort(converttoshort((Float itemsrotaterand)))
        udp_writebyte(gameinfo\Field5\Field6)
        If (server\Field56 <> 0) Then
            udp_writebyte(((((((local0\Field61 + (local0\Field96 Shl $01)) + (local0\Field141 Shl $02)) + (server\Field70 Shl $03)) + (server\Field71 Shl $04)) + (local0\Field122 Shl $05)) + (local0\Field41 Shl $06)))
            udp_writefloat(local0\Field63)
            udp_writeshort((Int local0\Field62))
            udp_writeshort((Int (local0\Field28 * 100.0)))
            udp_writefloat(local0\Field120)
            udp_writeint((Int max((Float (local0\Field123 - millisecs())), -1.0)))
            udp_writeint((Int max((Float (local0\Field124 - millisecs())), -1.0)))
            udp_writebyte(local0\Field134)
            If (((local0\Field166 <> $00) And (local0\Field166 <> local0\Field167)) <> 0) Then
                udp_writeshort(local0\Field166)
                udp_writefloat(local0\Field168)
                udp_writefloat(local0\Field169)
                udp_writefloat(local0\Field170)
                udp_writebyte(local0\Field172)
                If (local0\Field172 <> 0) Then
                    udp_writebyte((Int local0\Field171))
                Else
                    udp_writeline(local0\Field171)
                EndIf
            EndIf
        EndIf
        udp_sendmessage(local0\Field30)
    Next
    Return $00
End Function
