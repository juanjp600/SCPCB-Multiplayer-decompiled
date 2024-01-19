Function setplayerfogrange%(arg0%, arg1#)
    If (player[arg0] = Null) Then
        Return $00
    EndIf
    udp_writebyte($69)
    udp_writebyte($01)
    udp_writefloat(arg1)
    udp_sendmessage(arg0)
    Return $00
End Function
