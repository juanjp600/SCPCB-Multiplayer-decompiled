Function bytestreamwriteint%(arg0.bs, arg1%)
    If (iscoopmode() <> 0) Then
        udp_writeint(arg1)
    Else
        arg0\Field2 = (arg0\Field2 + $04)
        arg0\Field1 = (arg0\Field1 + $04)
        pokeint(arg0\Field0, (arg0\Field1 - $04), arg1)
    EndIf
    Return $00
End Function
