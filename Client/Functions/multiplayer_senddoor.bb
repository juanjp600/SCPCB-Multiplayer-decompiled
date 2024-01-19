Function multiplayer_senddoor%(arg0.doors, arg1.items, arg2$)
    udp_bytestreamwritechar($17)
    udp_bytestreamwriteshort(arg0\Field18)
    udp_bytestreamwritechar(arg0\Field5)
    udp_bytestreamwritechar(arg0\Field4)
    If (arg1 <> Null) Then
        udp_bytestreamwriteshort(arg1\Field18)
    Else
        udp_bytestreamwriteshort($00)
    EndIf
    udp_bytestreamwriteline(arg2)
    udp_setmicrobyte($17)
    Return $00
End Function
