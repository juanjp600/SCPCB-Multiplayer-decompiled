Function createplayersound%(arg0%, arg1$, arg2#, arg3#, arg4#, arg5#, arg6#)
    If (player[arg0] = Null) Then
        Return $00
    EndIf
    udp_writebyte($66)
    udp_writebyte(arg0)
    udp_writeline(arg1)
    udp_writefloat(arg2)
    udp_writefloat(arg3)
    udp_writefloat(arg4)
    udp_writefloat(arg5)
    udp_writefloat(arg6)
    udp_sendmessage(arg0)
    Return $00
End Function
