Function bytestreamwritechar%(arg0.bs, arg1%)
    arg0\Field2 = (arg0\Field2 + $01)
    arg0\Field1 = (arg0\Field1 + $01)
    pokebyte(arg0\Field0, (arg0\Field1 - $01), arg1)
    Return $00
End Function
