Function draw_setcolor%(arg0%, arg1%, arg2%)
    player[arg0]\Field43[arg1]\Field7 = arg2
    player[arg0]\Field51 = (player[arg0]\Field51 + $01)
    Return $00
End Function
