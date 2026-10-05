Function udp_bytestreamwriteint%(arg0%)
    If (iscoopmode() <> 0) Then
        udp_writeint(arg0)
    Else
        bytestreamwriteint(microbyte, arg0)
    EndIf
    Return $00
End Function
