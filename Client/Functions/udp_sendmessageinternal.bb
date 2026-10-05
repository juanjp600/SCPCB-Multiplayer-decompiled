Function udp_sendmessageinternal%(arg0%, arg1%, arg2%, arg3%)
    If (networkserver\Field36 <> 0) Then
        steam_sendpackettouser(arg1, arg2, arg3)
    Else
        udp_fillsendbuffer()
        sendudpmsg(arg0, arg1, arg2)
    EndIf
    udp_clearsendbuffer()
    Return $00
End Function
