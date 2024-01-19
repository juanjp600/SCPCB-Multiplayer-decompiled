Function wrapangle#(arg0#)
    If (INFINITY = arg0) Then
        Return 0.0
    EndIf
    While (0.0 > arg0)
        arg0 = (arg0 + 360.0)
    Wend
    While (360.0 <= arg0)
        arg0 = (arg0 - 360.0)
    Wend
    Return arg0
    Return 0.0
End Function
