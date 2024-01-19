Function playsoundforplayer%(arg0%, arg1$)
    If (player[arg0] = Null) Then
        Return $00
    EndIf
    udp_writebyte($03)
    udp_writebyte(arg0)
    udp_writeline(arg1)
    udp_sendmessage(arg0)
    Return $00
End Function
