Function bytestreamreadint%(arg0.bs)
    arg0\Field3 = (arg0\Field3 + $04)
    Return peekint(arg0\Field0, (arg0\Field3 - $04))
    Return $00
End Function
