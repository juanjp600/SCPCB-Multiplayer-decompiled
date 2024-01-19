Function clampvalue%(arg0#, arg1#, arg2#)
    If (arg1 > arg0) Then
        Return (Int arg1)
    EndIf
    If (arg2 < arg0) Then
        Return (Int arg2)
    EndIf
    Return (Int arg0)
    Return $00
End Function
