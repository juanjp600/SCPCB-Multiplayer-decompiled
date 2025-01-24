Function createhintmsg%(arg0$, arg1#, arg2%)
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field32 = $00)) <> 0) Then
        Return $00
    EndIf
    If ((arg2 And (opt\Field50 = $00)) <> 0) Then
        Return $00
    EndIf
    msg\Field6 = arg0
    msg\Field7 = (70.0 * arg1)
    Return $00
End Function
