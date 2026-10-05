Function voice_player_receive%(arg0%, arg1%, arg2#, arg3%)
    player[arg0]\Field65 = arg3
    player[arg0]\Field59 = (((arg2 / 1000.0) * 70.0) * 32.0)
    resizebank(player[arg0]\Field58, (banksize(player[arg0]\Field58) + banksize(arg1)))
    copybank(arg1, $00, player[arg0]\Field58, (banksize(player[arg0]\Field58) - banksize(arg1)), banksize(arg1))
    Return $00
End Function
