Function multiplayer_requestrole%(arg0%)
    If (networkserver\Field18 <> 0) Then
        multiplayer_breach_setplayertype(arg0)
    Else
        udp_bytestreamwritechar($4A)
        udp_bytestreamwritechar(arg0)
        udp_setmicrobyte($4A)
        udp_writebyte($4A)
        udp_writebyte(networkserver\Field28)
        udp_writebyte(arg0)
        udp_sendmessage($00)
    EndIf
    Return $00
End Function
