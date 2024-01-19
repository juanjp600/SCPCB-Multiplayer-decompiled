Function drawtextrect%(arg0%, arg1%, arg2%, arg3%, arg4$)
    color($00, $00, $00)
    rect(arg0, arg1, arg2, arg3, $01)
    color($FF, $FF, $FF)
    formattext((Float ((arg2 Sar $01) + arg0)), (Float ((arg3 Sar $01) + arg1)), arg4, $01, $01, 1.0, $00)
    Return $00
End Function
