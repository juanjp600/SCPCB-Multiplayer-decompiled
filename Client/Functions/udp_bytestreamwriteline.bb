Function udp_bytestreamwriteline%(arg0$)
    If (iscoopmode() <> 0) Then
        udp_writeline(arg0)
    Else
        bytestreamwriteline(microbyte, arg0)
    EndIf
    Return $00
End Function
