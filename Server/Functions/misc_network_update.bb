Function misc_network_update%(arg0%)
    Local local1.events
    Local local2.rooms
    Local local3%
    If (server\Field9 = $00) Then
        Return $00
    EndIf
    If ((server\Field21 And (network_byte[arg0] = $3D)) <> 0) Then
        server\Field49 = (Int reverseto((Float (server\Field49 + $01)), 1.0, 7.0))
        misc_network_update(server\Field49)
        Return $00
    EndIf
    Select network_byte[arg0]
        Case $53
            bytestreamreset(compactbank[$00])
            For local1 = Each events
                If (isablockedevent(local1) = $00) Then
                    bytestreamwritechar(compactbank[$00], local1\Field15)
                    bytestreamwritechar(compactbank[$00], local1\Field22)
                    bytestreamwritechar(compactbank[$00], local1\Field1\Field69)
                    bytestreamwritefloat(compactbank[$00], local1\Field2)
                    bytestreamwritefloat(compactbank[$00], local1\Field3)
                    bytestreamwritefloat(compactbank[$00], local1\Field4)
                EndIf
            Next
            bytestreamwritechar(compactbank[$00], $00)
        Case $54
            bytestreamreset(compactbank[$00])
            For local2 = Each rooms
                If (isablockedroom(local2) = $00) Then
                    For local3 = $00 To $1D Step $01
                        If (local2\Field25[local3] <> $00) Then
                            If (local2\Field26[local3] = $00) Then
                                bytestreamwritechar(compactbank[$00], local2\Field69)
                                bytestreamwritechar(compactbank[$00], local3)
                                bytestreamwritefloat(compactbank[$00], entityx(local2\Field25[local3], $01))
                                bytestreamwritefloat(compactbank[$00], entityy(local2\Field25[local3], $01))
                                bytestreamwritefloat(compactbank[$00], entityz(local2\Field25[local3], $01))
                                bytestreamwritefloat(compactbank[$00], entitypitch(local2\Field25[local3], $01))
                                bytestreamwritefloat(compactbank[$00], entityyaw(local2\Field25[local3], $01))
                                bytestreamwritefloat(compactbank[$00], entityroll(local2\Field25[local3], $01))
                            EndIf
                        EndIf
                    Next
                EndIf
            Next
            bytestreamwritechar(compactbank[$00], $00)
        Case $7F
            If (istimedout($02, $1F4) = $00) Then
                server\Field49 = (Int reverseto((Float (server\Field49 + $01)), 1.0, 7.0))
                misc_network_update(server\Field49)
                Return $00
            EndIf
        Case $83
            If (((istimedout($0B, $12C) = $00) Or (server\Field21 = $00)) <> 0) Then
                server\Field49 = (Int reverseto((Float (server\Field49 + $01)), 1.0, 7.0))
                misc_network_update(server\Field49)
                Return $00
            EndIf
    End Select
    For local3 = $01 To server\Field11 Step $01
        If (playeroptimize[local3]\Field22 <> 0) Then
            udp_writebyte($68)
            udp_writebyte($01)
            udp_writebyte(arg0)
            Select network_byte[arg0]
                Case $3D
                    writenpcs(playeroptimize[local3]\Field30)
                Case $32
                    writedoors(playeroptimize[local3]\Field30)
                Case $42
                    writeitems(playeroptimize[local3]\Field30)
                Case $53,$54
                    writeasdata(compactbank[$00])
                Case $7F
                    writeelevators()
                Case $83
                    writecorpses(playeroptimize[local3]\Field30)
            End Select
            udp_sendmessage(playeroptimize[local3]\Field30)
        EndIf
    Next
    Return $00
End Function
