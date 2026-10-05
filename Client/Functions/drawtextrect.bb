Function drawtextrect%(arg0%, arg1%, arg2%, arg3%, arg4$)
    setcolorraw($00)
    rect(arg0, arg1, arg2, arg3, $01)
    setcolorraw($FFFFFF)
    formattext((((Float arg2) * 0.5) + (Float arg0)), (((Float arg3) * 0.5) + (Float arg1)), arg4, $01, $01, 1.0, $00)
    Return $00
End Function
