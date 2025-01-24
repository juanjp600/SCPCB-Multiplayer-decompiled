Function renderloadingtext%(arg0%, arg1%, arg2$, arg3%, arg4%)
    If (0.0 = textr) Then
        changecolor = $01
    ElseIf (255.0 = textr) Then
        changecolor = $00
    EndIf
    If (changecolor = $00) Then
        textr = max(0.0, (textr - 3.0))
        textg = max(0.0, (textg - 3.0))
        textb = max(0.0, (textb - 3.0))
    Else
        textr = min((textr + 3.0), 255.0)
        textg = min((textg + 3.0), 255.0)
        textb = min((textb + 3.0), 255.0)
    EndIf
    setfontex(fo\Field0[$00])
    color((Int textr), (Int textg), (Int textb))
    textex(arg0, arg1, arg2, arg3, arg4)
    Return $00
End Function
