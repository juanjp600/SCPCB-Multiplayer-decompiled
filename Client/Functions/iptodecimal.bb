Function iptodecimal%(arg0$)
    Return (((((Int splitstring(arg0, ".", $00)) Shl $18) + ((Int splitstring(arg0, ".", $01)) Shl $10)) + ((Int splitstring(arg0, ".", $02)) Shl $08)) + (Int splitstring(arg0, ".", $03)))
    Return $00
End Function
