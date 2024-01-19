Function createsound%(arg0$, arg1#, arg2#, arg3#, arg4#, arg5#)
    Local local0%
    For local0 = $01 To server\Field11 Step $01
        udp_writebyte($66)
        udp_writebyte(playeroptimize[local0]\Field30)
        udp_writeline(arg0)
        udp_writefloat(arg1)
        udp_writefloat(arg2)
        udp_writefloat(arg3)
        udp_writefloat(arg4)
        udp_writefloat(arg5)
        udp_sendmessage(playeroptimize[local0]\Field30)
    Next
    Return $00
End Function
