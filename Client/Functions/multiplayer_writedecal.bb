Function multiplayer_writedecal%(arg0.decals, arg1%, arg2%)
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    udp_bytestreamwritechar($05)
    udp_bytestreamwritechar(arg0\Field8)
    udp_bytestreamwritefloat(arg0\Field11)
    udp_bytestreamwritefloat(arg0\Field12)
    udp_bytestreamwritefloat(arg0\Field13)
    udp_bytestreamwritefloat(arg0\Field15)
    udp_bytestreamwritefloat(arg0\Field16)
    udp_bytestreamwritefloat(arg0\Field14)
    udp_bytestreamwritefloat(arg0\Field1)
    udp_bytestreamwritefloat(arg0\Field2)
    udp_bytestreamwritefloat(arg0\Field3)
    udp_bytestreamwritefloat(arg0\Field4)
    udp_bytestreamwritefloat(arg0\Field5)
    udp_bytestreamwritefloat(arg0\Field9)
    udp_setmicrobyte($05)
    Return $00
End Function
