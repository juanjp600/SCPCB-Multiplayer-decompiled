Function multiplayer_writeroomobject%(arg0.rooms, arg1%)
    If (arg0\Field26[arg1] = $01) Then
        Return $00
    EndIf
    udp_writebyte(arg0\Field65)
    udp_writebyte(arg1)
    udp_writefloat(entityx(arg0\Field25[arg1], $01))
    udp_writefloat(entityy(arg0\Field25[arg1], $01))
    udp_writefloat(entityz(arg0\Field25[arg1], $01))
    udp_writefloat(entitypitch(arg0\Field25[arg1], $01))
    udp_writefloat(entityyaw(arg0\Field25[arg1], $01))
    udp_writefloat(entityroll(arg0\Field25[arg1], $01))
    Return $00
End Function
