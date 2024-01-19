Function settypetext%(arg0%, arg1%)
    Local local0.breachtypes
    local0 = getbreachtype(myplayer\Field51)
    aasetfont(font1)
    aatext((arg0 + $01), (arg1 + $01), local0\Field13, $01, $00, (min((Float (b_br\Field9 Sar $01)), 255.0) / 255.0))
    aatext(arg0, arg1, local0\Field13, $01, $00, (min((Float (b_br\Field9 Sar $01)), 255.0) / 255.0))
    Return $00
End Function
