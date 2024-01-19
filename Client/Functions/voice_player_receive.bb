Function voice_player_receive%(arg0%, arg1%, arg2#, arg3%)
    player[arg0]\Field67 = arg3
    player[arg0]\Field61 = (((arg2 / 1000.0) * 70.0) * 32.0)
    resizebank(player[arg0]\Field60, (banksize(player[arg0]\Field60) + banksize(arg1)))
    copybank(arg1, $00, player[arg0]\Field60, (banksize(player[arg0]\Field60) - banksize(arg1)), banksize(arg1))
    Return $00
End Function
