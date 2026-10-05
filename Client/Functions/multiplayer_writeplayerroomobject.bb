Function multiplayer_writeplayerroomobject%(arg0%, arg1%)
    udp_bytestreamwritechar($0E)
    If (iscoopmode() <> 0) Then
        udp_writebyte(networkserver\Field20)
    EndIf
    udp_bytestreamwritechar(arg1)
    udp_bytestreamwritefloat(entitypitch(arg0, $01))
    udp_bytestreamwritefloat(entityyaw(arg0, $01))
    udp_bytestreamwritefloat(entityroll(arg0, $01))
    udp_setmicrobyte($0E)
    Return $00
End Function
