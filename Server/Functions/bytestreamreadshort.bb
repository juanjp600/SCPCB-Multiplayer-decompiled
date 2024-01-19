Function bytestreamreadshort%(arg0.bs)
    arg0\Field3 = (arg0\Field3 + $02)
    Return peekshort(arg0\Field0, (arg0\Field3 - $02))
    Return $00
End Function
