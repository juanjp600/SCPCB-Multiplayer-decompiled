Function drawframe%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%)
    If ((arg0 + arg2) > graphicwidth) Then
        arg2 = ((graphicwidth - arg0) - $01)
    EndIf
    If ((arg1 + arg3) > graphicheight) Then
        arg3 = ((graphicheight - arg1) - $01)
    EndIf
    drawtiledimagerect(menublack, arg5, (arg1 Mod $100), 512.0, 512.0, arg0, arg1, arg2, arg3)
    setcolorraw($FFFFFF)
    rect(arg0, arg1, arg2, arg3, $00)
    Return $00
End Function
