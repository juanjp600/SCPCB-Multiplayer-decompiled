Function disconnectserver%(arg0$, arg1%)
    Local local0%
    If (getscripts() <> 0) Then
        public_inqueue($11, $01)
    EndIf
    If (udp_getstream() <> 0) Then
        udp_writebyte($0D)
        udp_writebyte(networkserver\Field28)
        If ((networkserver\Field18 And (networkserver\Field42 = $00)) <> 0) Then
            udp_writebyte($FD)
            udp_writeint($00)
            udp_writeint($00)
            udp_sendmessageinternal(udp_network\Field0, udp_network\Field1, udp_network\Field2, $02)
        Else
            udp_sendmessage($00)
            If (networkserver\Field49 <> 0) Then
                local0 = (millisecs2() + $3E8)
                Repeat
                    steam_update()
                    If (local0 < millisecs2()) Then
                        Exit
                    EndIf
                Forever
            EndIf
        EndIf
        If (arg0 = "exit") Then
            Return $00
        EndIf
    EndIf
    If (arg1 <> 0) Then
        clearserver()
    EndIf
    adderrorlog(arg0, $FF, $FF, $FF, $3A98)
    debuglog("DISCONNECT SUCCESSFUL")
    Return $00
End Function
