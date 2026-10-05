Function multiplayer_requestload%(arg0$, arg1$, arg2$, arg3%)
    If (networkserver\Field15 = $00) Then
        pendingserverload = $01
        pendingserverloadpath = arg0
        udp_writebyte($55)
        udp_writebyte(networkserver\Field20)
        udp_writeline(arg0)
        udp_writeline(arg2)
        udp_writeline(arg1)
        udp_writebyte(arg3)
        udp_sendmessage($00)
    Else
        startloadgame(arg0, arg2)
    EndIf
    Return $00
End Function
