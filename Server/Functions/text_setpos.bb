Function text_setpos%(arg0%, arg1%, arg2%, arg3%)
    player[arg0]\Field44[arg1]\Field4 = arg2
    player[arg0]\Field44[arg1]\Field5 = arg3
    player[arg0]\Field50 = (player[arg0]\Field50 + $01)
    Return $00
End Function
