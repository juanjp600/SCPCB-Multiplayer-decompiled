Function useintercom%()
    If ((player_isdead() Or (playerintercom\Field1 > millisecs())) <> 0) Then
        Return $00
    EndIf
    If (getmillisecs($0A) <> 0) Then
        udp_bytestreamwritechar($82)
        startmillisecs($0A, $32)
    EndIf
    Return $00
End Function
