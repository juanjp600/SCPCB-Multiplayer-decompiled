Function multiplayer_receive%(arg0%)
    Local local0%
    Local local1%
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    If ((networkserver\Field15 And (networkserver\Field32 = $00)) <> 0) Then
        multiplayer_setservertime(((millisecs() + networkserver\Field3) + $7D0))
    EndIf
    While (udp_recvudpmsg() <> 0)
        If (((networkserver\Field15 Or networkserver\Field36) Or ((udp_udpmsgip() = udp_network\Field1) And (udp_udpmsgport() = udp_network\Field2))) <> 0) Then
            If (udp_readavail() >= $02) Then
                local0 = udp_readbyte()
                local1 = udp_readbyte()
                If (arg0 <> $00) Then
                    If (local0 = arg0) Then
                        multiplayer_getpacket(local0, local1)
                    EndIf
                Else
                    multiplayer_getpacket(local0, local1)
                EndIf
            EndIf
        EndIf
    Wend
    Return $00
End Function
