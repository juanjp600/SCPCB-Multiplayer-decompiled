Function playsoundforplayers%(arg0%, arg1$, arg2#, arg3#)
    Local local0%
    If (player[arg0] = Null) Then
        Return $00
    EndIf
    For local0 = $01 To server\Field18 Step $01
        If (player[local0] <> Null) Then
            udp_writebyte($03)
            udp_writebyte(arg0)
            udp_writeline(arg1)
            udp_writefloat(arg2)
            udp_writefloat(arg3)
            udp_sendmessage(local0)
        EndIf
    Next
    Return $00
End Function
