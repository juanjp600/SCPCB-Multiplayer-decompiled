Function udp_bytestreamwritefloat%(arg0#)
    If (iscoopmode() <> 0) Then
        udp_writefloat(arg0)
    Else
        bytestreamwritefloat(microbyte, arg0)
    EndIf
    Return $00
End Function
