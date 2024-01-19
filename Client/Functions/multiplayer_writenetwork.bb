Function multiplayer_writenetwork%()
    Local local0%
    If (networkserver\Field18 <> 0) Then
        If (networkserver\Field42 <> 0) Then
            multiplayer_setservertime((millisecs() + $186A0))
        EndIf
        If (udp_netout($01) <> 0) Then
            networkserver\Field29 = multiplayer_getplayerscount()
            multiplayer_sendserverinformation()
            networkserver\Field46 = (Int reverseto((Float (networkserver\Field46 + $01)), 1.0, 5.0))
            multiplayer_writemiscellaneous(networkserver\Field46)
        EndIf
        If (udp_netout($03) <> 0) Then
            For local0 = $02 To networkserver\Field14 Step $01
                If (player[local0] <> Null) Then
                    udp_writebyte($64)
                    udp_writebyte($01)
                    udp_sendmessage(local0)
                    player[local0]\Field49 = millisecs()
                EndIf
            Next
        EndIf
        bytestreamreset(microbyte)
    EndIf
    Return $00
End Function
