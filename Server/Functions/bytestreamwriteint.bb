Function bytestreamwriteint%(arg0.bs, arg1%)
    If ((arg0\Field1 + $03) >= banksize(arg0\Field0)) Then
        Return $00
    EndIf
    arg0\Field2 = (arg0\Field2 + $04)
    arg0\Field1 = (arg0\Field1 + $04)
    pokeint(arg0\Field0, (arg0\Field1 - $04), arg1)
    Return $00
End Function
