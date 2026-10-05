Function f_clamp#(arg0#, arg1#, arg2#)
    If (arg2 < arg0) Then
        arg0 = arg2
    ElseIf (arg1 > arg0) Then
        arg0 = arg1
    EndIf
    Return arg0
    Return 0.0
End Function
