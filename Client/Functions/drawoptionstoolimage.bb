Function drawoptionstoolimage%(arg0%, arg1%, arg2%, arg3%, arg4%)
    drawframe(arg0, arg1, arg2, arg3, $00, $00)
    drawimage(arg4, (Int ((20.0 * menuscale) + (Float arg0))), (Int ((20.0 * menuscale) + (Float arg1))), $00)
    Return $00
End Function
