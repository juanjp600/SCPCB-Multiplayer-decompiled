Function updatenpcblinking%(arg0.npcs)
    If (0.0 >= arg0\Field51) Then
        arg0\Field51 = (rnd(5.0, 10.0) * 70.0)
    EndIf
    arg0\Field51 = (arg0\Field51 - fps\Field7[$00])
    Return $00
End Function
