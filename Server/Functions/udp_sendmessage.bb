Function udp_sendmessage%(arg0%)
    If ((player[arg0]\Field55 Or ((player[arg0]\Field13 = $00) And (player[arg0]\Field14 = $00))) <> 0) Then
        sendudpmsg(server\Field0, fake_stream_ip, $00)
        Return $00
    EndIf
    sendudpmsg(server\Field0, player[arg0]\Field13, player[arg0]\Field14)
    Return $00
End Function
