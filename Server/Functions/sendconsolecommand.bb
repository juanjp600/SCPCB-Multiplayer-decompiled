Function sendconsolecommand%(arg0%, arg1$, arg2%)
    If (player[arg0] = Null) Then
        Return $00
    EndIf
    udp_writebyte($61)
    udp_writebyte(arg0)
    udp_writeline(arg1)
    udp_writebyte(arg2)
    udp_sendmessage(arg0)
    Return $00
End Function
