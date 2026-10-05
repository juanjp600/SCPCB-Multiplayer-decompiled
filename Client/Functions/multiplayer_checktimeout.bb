Function multiplayer_checktimeout%(arg0%)
    Local local0.players
    If (((player[arg0]\Field42 < millisecs()) And (arg0 <> networkserver\Field20)) <> 0) Then
        multiplayer_createmessage((player[arg0]\Field24 + " timed out"), $FFFFFFFF)
        For local0 = Each players
            If (local0\Field0 <> $01) Then
                udp_writebyte($0B)
                udp_writebyte($00)
                udp_writeline((player[arg0]\Field24 + " timed out"))
                udp_writebyte($01)
                udp_sendmessage(local0\Field0)
            EndIf
        Next
        multiplayer_disconnectplayer(player[arg0])
        networkserver\Field21 = (networkserver\Field21 - $01)
        Return $01
    EndIf
    If (((player[arg0]\Field42 < (millisecs() + (networkserver\Field3 - $7D0))) And (arg0 <> networkserver\Field20)) <> 0) Then
        player[arg0]\Field70 = ((((((readbool(player[arg0]\Field70, $00) + (readbool(player[arg0]\Field70, $01) Shl $01)) + (readbool(player[arg0]\Field70, $02) Shl $02)) + $08) + (readbool(player[arg0]\Field70, $04) Shl $04)) + (readbool(player[arg0]\Field70, $05) Shl $05)) + (readbool(player[arg0]\Field70, $06) Shl $06))
    EndIf
    Return $00
    Return $00
End Function
