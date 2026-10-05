Function draw_setpos%(arg0%, arg1%, arg2%, arg3%)
    player[arg0]\Field43[arg1]\Field3 = arg2
    player[arg0]\Field43[arg1]\Field4 = arg3
    player[arg0]\Field53 = (player[arg0]\Field53 + $01)
    Return $00
End Function
