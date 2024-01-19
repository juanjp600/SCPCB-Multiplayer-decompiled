Function mp_writedecal%(arg0.decals, arg1%, arg2%)
    Local local0%
    For local0 = $01 To server\Field18 Step $01
        If (player[local0] <> Null) Then
            udp_writebyte($05)
            udp_writebyte($01)
            udp_writebyte(arg0\Field8)
            udp_writefloat(arg0\Field11)
            udp_writefloat(arg0\Field12)
            udp_writefloat(arg0\Field13)
            udp_writefloat(arg0\Field15)
            udp_writefloat(arg0\Field16)
            udp_writefloat(arg0\Field14)
            udp_writefloat(arg0\Field1)
            udp_writefloat(arg0\Field2)
            udp_writefloat(arg0\Field3)
            udp_writefloat(arg0\Field4)
            udp_writefloat(arg0\Field5)
            udp_writefloat(arg0\Field9)
            udp_sendmessage(local0)
        EndIf
    Next
    Return $00
End Function
