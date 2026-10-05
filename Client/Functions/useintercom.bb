Function useintercom%()
    If ((player_isdead() Or (playerintercom\Field1 > millisecs())) <> 0) Then
        Return $00
    EndIf
    If (getmillisecs($0A) <> 0) Then
        udp_bytestreamwritechar($82)
        If (iscoopmode() <> 0) Then
            udp_writebyte(networkserver\Field20)
            udp_sendmessage($00)
        EndIf
        startmillisecs($0A, $32)
    EndIf
    Return $00
End Function
