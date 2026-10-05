Function bytestreamwritechar%(arg0.bs, arg1%)
    If (iscoopmode() <> 0) Then
        udp_writebyte(arg1)
    Else
        arg0\Field2 = (arg0\Field2 + $01)
        arg0\Field1 = (arg0\Field1 + $01)
        pokebyte(arg0\Field0, (arg0\Field1 - $01), arg1)
    EndIf
    Return $00
End Function
