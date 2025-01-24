Function getlocalstring$(arg0$, arg1$)
    Return getfilelocalstring("Data\local.ini", arg0, arg1, ((arg0 + ",") + arg1), $01)
    Return ""
End Function
