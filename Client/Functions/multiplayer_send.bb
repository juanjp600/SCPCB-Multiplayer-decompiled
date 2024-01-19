Function multiplayer_send%(arg0%, arg1%, arg2%)
    Local local0%
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    If (arg1 <> $FFFFFFFF) Then
        If (udp_netout(arg1) = $00) Then
            Return $00
        EndIf
    EndIf
    udp_writebyte(arg0)
    udp_writebyte(networkserver\Field28)
    local0 = arg0
    If (local0 = $01) Then
        udp_writebyte(arg2)
        Select arg2
            Case $00
                udp_writebyte((ready = "Ready"))
                udp_writebyte(myplayer\Field43)
                udp_writebyte(networkserver\Field34)
                udp_writebyte(networkserver\Field32)
                udp_writebyte(networkserver\Field33)
                udp_writebyte(networkserver\Field35)
            Case $01
                udp_writeshort(converttoshort(myplayer\Field4))
                udp_writeshort(converttoshort(myplayer\Field5))
                udp_writefloat(myplayer\Field31)
                udp_writebyte(myplayer\Field79)
                udp_writebyte((Int myplayer\Field36))
                udp_writebyte((myplayer\Field72 + ((myplayer\Field103 <> Null) Shl $07)))
                udp_writebyte(myplayer\Field37)
                udp_writeshort(myplayer\Field68)
                udp_writebyte(networkserver\Field34)
                udp_writebyte(networkserver\Field32)
                udp_writebyte(networkserver\Field33)
                udp_writebyte(networkserver\Field35)
                udp_writefloat(stamina)
                udp_writebyte(myplayer\Field55)
                udp_writeshort(currentpositionid)
                udp_writefloat(entityx(collider, $00))
                udp_writefloat(entityy(collider, $00))
                udp_writefloat(entityz(collider, $00))
                udp_writebyte(myplayer\Field47)
                If (myplayer\Field103 <> Null) Then
                    udp_writebytes(getbytestreamdata(myplayer\Field103), $00, $17)
                    removebytestream(myplayer\Field103)
                EndIf
                udp_writebyte(myplayer\Field67)
            Case $03
                udp_writebyte(myplayer\Field72)
        End Select
        udp_writebytes(getbytestreamdata(microbyte), $00, getbytestreamdatasize(microbyte))
        bytestreamreset(microbyte)
    EndIf
    udp_sendmessage($00)
    Return $01
    Return $00
End Function
