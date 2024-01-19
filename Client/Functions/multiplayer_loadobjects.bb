Function multiplayer_loadobjects%(arg0%, arg1%)
    Local local0%
    Local local1%
    Local local2%
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    udp_writebyte(arg0)
    udp_writebyte(networkserver\Field28)
    udp_sendmessage($00)
    local0 = (millisecs() + $3E8)
    Repeat
        If (udp_netout($00) <> 0) Then
            multiplayer_send($01, $FFFFFFFF, $00)
        EndIf
        While (udp_recvudpmsg($00) <> 0)
            local2 = udp_readbyte()
            If (local2 = convertpacket(arg0)) Then
                udp_readbyte()
                Select convertpacket(arg0)
                    Case $7D
                        local0 = $FFFFFFFF
                        Exit
                    Case $6C
                        networkserver\Field39 = udp_readline()
                        networkserver\Field36 = udp_readfloat()
                        networkserver\Field37 = udp_readfloat()
                        networkserver\Field38 = udp_readfloat()
                        local0 = $FFFFFFFF
                        Exit
                    Case $32
                        local0 = $FFFFFFFF
                        Exit
                End Select
            ElseIf (local2 = $28) Then
                debuglog("Close")
                disconnectserver("The server is restarted", $01)
                adderrorlog("or closed", $FF, $FF, $FF, $3A98)
                Return $00
            EndIf
        Wend
        If (local0 = $FFFFFFFF) Then
            Exit
        EndIf
        If (millisecs() > local0) Then
            local1 = (local1 + $01)
            If (local1 > $0A) Then
                debuglog("Close")
                disconnectserver("The server not responding", $01)
                adderrorlog("or closed", $FF, $FF, $FF, $3A98)
                Return $00
            EndIf
            udp_writebyte(arg0)
            udp_writebyte(networkserver\Field28)
            udp_sendmessage($00)
            local0 = (millisecs() + $3E8)
        EndIf
        If (arg1 <> 0) Then
            drawloading(currentpercent, $00, $01, $01)
        EndIf
    Forever
    Return $00
End Function
