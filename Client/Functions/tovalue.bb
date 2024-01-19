Function tovalue#(arg0#, arg1#, arg2#)
    If (0.0 = fpsfactor) Then
        Return arg1
    EndIf
    If (arg1 > arg0) Then
        Return max(arg0, (arg1 - (arg2 * fpsfactor)))
    Else
        Return min(arg0, ((arg2 * fpsfactor) + arg1))
    EndIf
    Return 0.0
End Function
