Function texts_network_update%()
    Local local0%
    Local local1%
    For local0 = $01 To server\Field11 Step $01
        If (playeroptimize[local0]\Field50 > $FF) Then
            playeroptimize[local0]\Field50 = $01
        EndIf
        If (playeroptimize[local0]\Field47 <> playeroptimize[local0]\Field50) Then
            udp_writebyte($5F)
            udp_writebyte($01)
            udp_writebyte(playeroptimize[local0]\Field50)
            For local1 = $01 To $1F Step $01
                If (playeroptimize[local0]\Field44[local1] <> Null) Then
                    udp_writebyte(local1)
                    udp_writeline(playeroptimize[local0]\Field44[local1]\Field1)
                    udp_writeline(playeroptimize[local0]\Field44[local1]\Field3)
                    udp_writeint(playeroptimize[local0]\Field44[local1]\Field4)
                    udp_writeint(playeroptimize[local0]\Field44[local1]\Field5)
                    udp_writeint(playeroptimize[local0]\Field44[local1]\Field6)
                    udp_writebyte((Int playeroptimize[local0]\Field44[local1]\Field2))
                EndIf
            Next
            udp_writebyte($00)
            udp_sendmessage(playeroptimize[local0]\Field30)
        EndIf
    Next
    Return $00
End Function
