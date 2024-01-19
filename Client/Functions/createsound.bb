Function createsound%(arg0$, arg1#, arg2#, arg3#, arg4#, arg5#)
    Local local0%
    For local0 = $01 To networkserver\Field14 Step $01
        If (player[local0] <> Null) Then
            udp_writebyte($66)
            udp_writebyte($00)
            udp_writeline(arg0)
            udp_writefloat(arg1)
            udp_writefloat(arg2)
            udp_writefloat(arg3)
            udp_writefloat(arg4)
            udp_writefloat(arg5)
            udp_sendmessage(local0)
        EndIf
    Next
    Return $00
End Function
