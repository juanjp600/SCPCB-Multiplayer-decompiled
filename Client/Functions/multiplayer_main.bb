Function multiplayer_main%()
    Local local0.players
    multiplayer_receive($00)
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    If (mousehit1 <> 0) Then
        udp_bytestreamwritechar($6A)
        udp_bytestreamwriteshort(mousex())
        udp_bytestreamwriteshort(mousey())
    EndIf
    If (udp_netout($00) <> 0) Then
        If (mainmenuopen = $00) Then
            If (caninteract() <> 0) Then
                multiplayer_updateroomobjects()
            EndIf
            multiplayer_send($01, $FFFFFFFF, $01)
        Else
            multiplayer_send($01, $FFFFFFFF, $00)
        EndIf
    EndIf
    If (udp_netout($02) <> 0) Then
        If (networkserver\Field18 = $00) Then
            For local0 = Each players
                If (local0\Field24 = "") Then
                    udp_bytestreamwritechar($6D)
                    udp_bytestreamwritechar(local0\Field0)
                    udp_setmicrobyte($6D)
                EndIf
            Next
        ElseIf (networkserver\Field42 = $00) Then
            udp_writebyte($FFFFFFFF)
            udp_sendmessageinternal(udp_network\Field0, udp_network\Field1, udp_network\Field2, $02)
        EndIf
    EndIf
    multiplayer_writenetwork()
    myplayer\Field67 = $00
    If (networkserver\Field4 < millisecs()) Then
        shouldrestartserver = $01
        Return $C3B
    EndIf
    Return $00
End Function
