Function udp_bytestreamwriteshort%(arg0%)
    If (iscoopmode() <> 0) Then
        udp_writeshort(arg0)
    Else
        bytestreamwriteshort(microbyte, arg0)
    EndIf
    Return $00
End Function
