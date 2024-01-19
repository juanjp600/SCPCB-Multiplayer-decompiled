Function iptodecimal%(arg0$)
    Return (((((Int piece(arg0, $01, ".")) Shl $18) + ((Int piece(arg0, $02, ".")) Shl $10)) + ((Int piece(arg0, $03, ".")) Shl $08)) + (Int piece(arg0, $04, ".")))
    Return $00
End Function
