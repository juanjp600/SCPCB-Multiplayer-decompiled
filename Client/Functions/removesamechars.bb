Function removesamechars$(arg0$, arg1$)
    While (instr(arg0, (arg1 + arg1), $01) <> 0)
        arg0 = replace(arg0, (arg1 + arg1), arg1)
    Wend
    Return arg0
    Return ""
End Function
