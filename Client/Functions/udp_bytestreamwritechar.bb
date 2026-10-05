Function udp_bytestreamwritechar%(arg0%)
    If (iscoopmode() <> 0) Then
        udp_writebyte(arg0)
    Else
        bytestreamwritechar(microbyte, arg0)
    EndIf
    Return $00
End Function
