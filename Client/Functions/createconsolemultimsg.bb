Function createconsolemultimsg%(arg0$, arg1%, arg2%, arg3%, arg4%)
    While (instr(arg0, "\n", $01) <> $00)
        createconsolemsg(left(arg0, (instr(arg0, "\n", $01) - $01)), arg1, arg2, arg3, arg4)
        arg0 = right(arg0, ((len(arg0) - instr(arg0, "\n", $01)) - $01))
    Wend
    createconsolemsg(arg0, arg1, arg2, arg3, arg4)
    Return $00
End Function
