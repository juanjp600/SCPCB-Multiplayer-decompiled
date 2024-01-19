Function playanimimage#(arg0%, arg1%, arg2%, arg3#, arg4#, arg5#)
    drawimage(arg0, arg1, arg2, (Int min(arg4, (arg5 - 1.0))))
    arg4 = (arg4 + arg3)
    If (arg4 >= (arg5 - arg3)) Then
        arg4 = 0.0
    EndIf
    Return arg4
    Return 0.0
End Function
