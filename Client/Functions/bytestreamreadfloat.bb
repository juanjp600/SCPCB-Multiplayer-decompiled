Function bytestreamreadfloat#(arg0.bs)
    arg0\Field3 = (arg0\Field3 + $04)
    Return peekfloat(arg0\Field0, (arg0\Field3 - $04))
    Return 0.0
End Function
