Function chat_network_update%()
    Local local0%
    Local local1.chatmessage
    For local0 = $01 To server\Field11 Step $01
        If (playeroptimize[local0]\Field53 <> ticks\Field0) Then
            udp_writebyte($3F)
            udp_writebyte($01)
            udp_writebyte(ticks\Field0)
            For local1 = Each chatmessage
                If (local1\Field3[playeroptimize[local0]\Field30] <> 0) Then
                    udp_writeshort(local1\Field0)
                    udp_writeline(local1\Field1)
                EndIf
            Next
            udp_writebyte($00)
            udp_sendmessage(playeroptimize[local0]\Field30)
        EndIf
    Next
    Return $00
End Function
