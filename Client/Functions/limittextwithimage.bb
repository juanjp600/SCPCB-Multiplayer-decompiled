Function limittextwithimage%(arg0$, arg1%, arg2%, arg3%, arg4%, arg5%)
    Local local0%
    drawblock(arg4, arg1, ((((stringheight(arg0) Sar $01) + arg2) - (imageheight(arg4) Sar $01)) - $01), arg5)
    local0 = imagewidth(arg4)
    limittext(arg0, ((arg1 + $03) + local0), arg2, ((arg3 - local0) - $03))
    Return $00
End Function
