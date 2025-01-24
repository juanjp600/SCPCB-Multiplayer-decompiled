Function setplayervoiceinactive%(arg0.mp_player, arg1%)
    arg0\Field36\Field3 = (mp_gettimer() + arg1)
    Return $00
End Function
