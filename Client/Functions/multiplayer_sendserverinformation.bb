Function multiplayer_sendserverinformation%()
    Local local0%
    Local local1%
    myplayer\Field48 = $05
    myplayer\Field34 = ready
    serverping = $05
    For local0 = $02 To networkserver\Field14 Step $01
        If (player[local0] <> Null) Then
            udp_writebyte($3C)
            udp_writebyte($01)
            udp_writebyte((mainmenuopen = $00))
            udp_writebyte(player[local0]\Field51)
            udp_writefloat(networkserver\Field12)
            udp_writeint((Int max(-1.0, (Float (b_br\Field5 - millisecs())))))
            udp_writeint((Int max(-1.0, (Float (b_br\Field7 - millisecs())))))
            udp_writeshort(player[local0]\Field48)
            For local1 = $01 To networkserver\Field14 Step $01
                If (((player[local1] <> Null) And (local1 <> local0)) <> 0) Then
                    udp_writebyte(local1)
                    If ((mainmenuopen = $01) = $00) Then
                        udp_writebyte(player[local1]\Field51)
                        If (player[local1]\Field51 <> $00) Then
                            udp_writefloat(entityx(player[local1]\Field13, $00))
                            udp_writefloat((entityy(player[local1]\Field13, $00) - ((Float (local1 <> myplayer\Field0)) * 0.32)))
                            udp_writefloat(entityz(player[local1]\Field13, $00))
                            udp_writeshort(converttoshort(player[local1]\Field4))
                            udp_writeshort(converttoshort(player[local1]\Field5))
                            udp_writebyte(player[local1]\Field55)
                            udp_writefloat(player[local1]\Field31)
                            udp_writebyte(player[local1]\Field79)
                            udp_writebyte((Int player[local1]\Field36))
                            udp_writeshort(player[local1]\Field48)
                            udp_writebyte(player[local1]\Field72)
                            udp_writebyte(player[local1]\Field37)
                            udp_writeshort(player[local1]\Field68)
                            udp_writebyte(player[local1]\Field47)
                        Else
                            udp_writeshort(player[local1]\Field48)
                            udp_writebyte(player[local1]\Field72)
                        EndIf
                    Else
                        udp_writebyte((player[local1]\Field34 = "Ready"))
                        udp_writeshort(player[local1]\Field48)
                        udp_writebyte(player[local1]\Field43)
                    EndIf
                EndIf
            Next
            udp_writebyte($00)
            udp_writeshort(converttoshort(secondarylighton))
            udp_writebyte(((remotedooron Shl $01) + contained106))
            udp_writeshort((Int mtftimer))
            udp_writeshort(converttoshort((Float itemsrotaterand)))
            udp_sendmessage(local0)
        EndIf
    Next
    Return $00
End Function
