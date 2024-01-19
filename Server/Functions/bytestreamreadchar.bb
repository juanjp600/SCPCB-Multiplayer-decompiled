Function bytestreamreadchar%(arg0.bs)
    arg0\Field3 = (arg0\Field3 + $01)
    Return peekbyte(arg0\Field0, (arg0\Field3 - $01))
    Return $00
End Function
