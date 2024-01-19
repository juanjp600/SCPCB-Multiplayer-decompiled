Function udp_writeline%(arg0$)
    Local local0%
    For local0 = $01 To len(arg0) Step $01
        udp_writebyte(asc(mid(arg0, local0, $01)))
    Next
    udp_writebyte($0D)
    udp_writebyte($0A)
    Return $00
End Function
