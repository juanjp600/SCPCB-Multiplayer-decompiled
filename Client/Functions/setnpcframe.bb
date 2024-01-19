Function setnpcframe%(arg0.npcs, arg1#)
    If (0.001 > (Abs (arg0\Field14 - arg1))) Then
        Return $00
    EndIf
    setanimtime(arg0\Field0, arg1, $00)
    arg0\Field14 = arg1
    Return $00
End Function
