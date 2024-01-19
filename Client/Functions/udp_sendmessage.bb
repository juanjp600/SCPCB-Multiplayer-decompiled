Function udp_sendmessage%(arg0%)
    udp_network\Field5 = (udp_network\Field5 + ((Float udp_network\Field16) * 0.001))
    If (arg0 = $00) Then
        If (networkserver\Field18 <> 0) Then
            If (networkserver\Field42 <> 0) Then
                udp_fillsendbuffer()
                sendudpmsg(udp_network\Field0, udp_network\Field12, udp_network\Field3)
                udp_clearsendbuffer()
                Return $00
            Else
                udp_writeint($00)
                udp_writeint($00)
            EndIf
        EndIf
        udp_sendmessageinternal(udp_network\Field0, udp_network\Field1, udp_network\Field2, $02)
    Else
        If (networkserver\Field42 = $00) Then
            udp_writeint(player[arg0]\Field29)
            udp_writeint(player[arg0]\Field30)
            sendudpmsg(udp_network\Field0, udp_network\Field1, udp_network\Field2)
            udp_clearsendbuffer()
            Return $00
        EndIf
        If (((player[arg0]\Field29 = $00) And (player[arg0]\Field30 = $00)) <> 0) Then
            udp_fillsendbuffer()
            sendudpmsg(udp_network\Field0, udp_network\Field12, udp_network\Field3)
            udp_clearsendbuffer()
            Return $00
        EndIf
        udp_sendmessageinternal(udp_network\Field0, player[arg0]\Field29, player[arg0]\Field30, $02)
    EndIf
    udp_clearsendbuffer()
    Return $00
End Function
