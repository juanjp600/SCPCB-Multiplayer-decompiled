Function object_sound_create%(arg0%, arg1$, arg2#, arg3#, arg4%)
    Local local0%
    If (arg4 > $00) Then
        udp_writebyte($81)
        udp_writebyte(arg4)
        udp_writebyte(arg0)
        udp_writeline(arg1)
        udp_writefloat(arg2)
        udp_writefloat(arg3)
        udp_sendmessage(arg4)
    Else
        For local0 = $01 To server\Field11 Step $01
            udp_writebyte($81)
            udp_writebyte(playeroptimize[local0]\Field30)
            udp_writebyte(arg0)
            udp_writeline(arg1)
            udp_writefloat(arg2)
            udp_writefloat(arg3)
            udp_sendmessage(playeroptimize[local0]\Field30)
        Next
    EndIf
    Return $00
End Function
