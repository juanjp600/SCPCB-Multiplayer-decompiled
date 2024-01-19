Function synchronizeitem%(arg0.items)
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    udp_bytestreamwritechar($16)
    udp_bytestreamwriteint(arg0\Field3\Field0)
    Return $00
End Function
