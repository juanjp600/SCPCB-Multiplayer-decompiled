Function text_settext%(arg0%, arg1%, arg2$)
    player[arg0]\Field44[arg1]\Field3 = arg2
    player[arg0]\Field52 = (player[arg0]\Field52 + $01)
    Return $00
End Function
