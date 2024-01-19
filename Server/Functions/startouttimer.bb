Function startouttimer%(arg0%, arg1%)
    millisecs_sys[arg0] = (millisecs() + arg1)
    Return $00
End Function
