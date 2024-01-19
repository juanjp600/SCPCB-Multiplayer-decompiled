Function draw_setpos%(arg0%, arg1%, arg2%, arg3%)
    player[arg0]\Field43[arg1]\Field3 = arg2
    player[arg0]\Field43[arg1]\Field4 = arg3
    player[arg0]\Field51 = (player[arg0]\Field51 + $01)
    Return $00
End Function
