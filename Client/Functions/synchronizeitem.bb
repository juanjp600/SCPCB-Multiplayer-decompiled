Function synchronizeitem%(arg0.items)
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    udp_bytestreamwritechar($16)
    If (iscoopmode() <> 0) Then
        udp_bytestreamwritechar(networkserver\Field20)
    EndIf
    udp_bytestreamwriteint(arg0\Field1\Field0)
    If (iscoopmode() <> 0) Then
        udp_sendmessage($00)
    EndIf
    Return $00
End Function
