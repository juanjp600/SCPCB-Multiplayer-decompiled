Function udp_sendmessageinternal%(arg0%, arg1%, arg2%, arg3%)
    If (networkserver\Field49 <> 0) Then
        bs_isteamnetworking_sendp2ppacket(bs_steamnetworking(), arg1, udp_network\Field14, udp_network\Field16, arg3, $00)
    Else
        udp_fillsendbuffer()
        sendudpmsg(arg0, arg1, arg2)
    EndIf
    udp_clearsendbuffer()
    Return $00
End Function
