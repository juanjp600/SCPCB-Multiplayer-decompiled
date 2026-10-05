Function createfont.fontdata(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0.fontdata
    local0 = (New fontdata)
    local0\Field0 = loadfont_strict(arg0, arg1, arg2, arg3, arg4)
    local0\Field1 = arg1
    setfontex(local0\Field0)
    local0\Field2 = fontheight()
    local0\Field3 = stringwidth(" ")
    Return local0
    Return Null
End Function
