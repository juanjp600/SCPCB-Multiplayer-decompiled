Function udp_recvudpmsg%(arg0%)
    Local local0%
    Local local1%
    Local local2.players
    udp_network\Field6 = $00
    If (udp_network\Field0 = $00) Then
        Return $00
    EndIf
    If (((networkserver\Field49 = $00) Or arg0) <> 0) Then
        udp_network\Field6 = recvudpmsg(udp_network\Field0)
        If (udp_network\Field6 <> 0) Then
            udp_clearreadavail()
            udp_network\Field13 = readavail(udp_network\Field0)
            udp_fillreceivebuffer(udp_readavail())
            If ((networkserver\Field18 And (networkserver\Field42 = $00)) <> 0) Then
                udp_network\Field7 = udp_readint()
                udp_network\Field8 = udp_readint()
            Else
                udp_network\Field7 = udpmsgip(udp_network\Field0)
                udp_network\Field8 = udpmsgport(udp_network\Field0)
            EndIf
        EndIf
    Else
        local0 = createbank($04)
        If (bs_isteamnetworking_isp2ppacketavailable(bs_steamnetworking(), local0, $00) <> 0) Then
            udp_clearreadavail()
            udp_network\Field6 = udp_getsteamreceive()
            udp_network\Field13 = peekint(local0, $00)
            If (bs_isteamnetworking_readp2ppacket(bs_steamnetworking(), udp_network\Field15, udp_network\Field13, local0, udp_network\Field6, $00) = $00) Then
                bs_csteamid_destroy(udp_network\Field7)
                udp_network\Field7 = $00
                udp_network\Field6 = $00
            Else
                If (networkserver\Field42 <> 0) Then
                    local1 = $00
                    For local2 = Each players
                        If (local2\Field0 <> networkserver\Field28) Then
                            If (bs_csteamid_getaccountid(local2\Field29) = bs_csteamid_getaccountid(udp_network\Field6)) Then
                                local1 = $01
                                Exit
                            EndIf
                        EndIf
                    Next
                    If (local1 = $00) Then
                        udp_network\Field7 = udp_putclientsteamid(udp_network\Field6)
                    EndIf
                ElseIf (udp_network\Field7 = $00) Then
                    udp_network\Field7 = udp_putclientsteamid(udp_network\Field6)
                EndIf
                udp_network\Field8 = $00
            EndIf
        EndIf
        freebank(local0)
    EndIf
    Return udp_network\Field6
    Return $00
End Function
