Function getconnectiontocentralserver%(arg0$, arg1%)
    Local local0%
    If (centralserver\Field1 <> $00) Then
        closeudpstream(centralserver\Field1)
    EndIf
    centralserver\Field1 = createudpstream($00)
    local0 = opentcpstream(arg0, arg1, $00)
    If (local0 <> $00) Then
        writebyte(local0, $04)
        writeshort(local0, udpstreamport(centralserver\Field1))
        tcp_sendmsg(local0)
        centralserver\Field3 = $7530
        centralserver\Field4 = (millisecs() + centralserver\Field3)
        centralserver\Field5 = ((millisecs() + centralserver\Field3) + $2EE0)
    EndIf
    Return local0
    Return $00
End Function
