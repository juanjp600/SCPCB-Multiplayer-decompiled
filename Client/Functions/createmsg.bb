Function createmsg%(arg0$, arg1#)
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field32 = $00)) <> 0) Then
        Return $00
    EndIf
    msg\Field0 = arg0
    msg\Field1 = (70.0 * arg1)
    Return $00
End Function
