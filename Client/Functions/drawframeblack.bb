Function drawframeblack%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%)
    color($FF, $FF, $FF)
    drawtiledimagerect(menublack, arg4, (arg1 Mod $100), 512.0, 512.0, arg0, arg1, arg2, arg3)
    Return $00
End Function
