Function multiplayer_receive%(arg0%)
    Local local0%
    Local local1%
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    If ((networkserver\Field18 And (networkserver\Field42 = $00)) <> 0) Then
        multiplayer_setservertime(((millisecs() + networkserver\Field3) + $7D0))
    EndIf
    While (udp_recvudpmsg($00) <> 0)
        udp_countavail((Float udp_readavail()))
        local0 = udp_readbyte()
        local1 = udp_readbyte()
        If (arg0 <> $00) Then
            If ((local0 <> arg0) = $00) Then
                multiplayer_getpacket(local0, local1)
            EndIf
        Else
            multiplayer_getpacket(local0, local1)
        EndIf
    Wend
    If (networkserver\Field49 <> 0) Then
        While (udp_recvudpmsg($01) <> 0)
            local0 = udp_readbyte()
            local1 = udp_readbyte()
            If (arg0 <> $00) Then
                If ((local0 <> arg0) = $00) Then
                    multiplayer_getpacket(local0, local1)
                EndIf
            Else
                multiplayer_getpacket(local0, local1)
            EndIf
        Wend
    EndIf
    Return $00
End Function
