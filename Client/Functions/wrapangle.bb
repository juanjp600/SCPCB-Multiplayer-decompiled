Function wrapangle#(arg0#, arg1#)
    If (INFINITY = arg0) Then
        Return 0.0
    EndIf
    arg0 = (arg0 Mod arg1)
    If (0.0 > arg0) Then
        Return (arg0 + arg1)
    EndIf
    Return arg0
    Return 0.0
End Function
