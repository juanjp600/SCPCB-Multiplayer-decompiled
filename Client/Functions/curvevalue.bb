Function curvevalue#(arg0#, arg1#, arg2#)
    If (0.0 = fpsfactor) Then
        Return arg1
    EndIf
    If (arg1 > arg0) Then
        Return max((((arg0 - arg1) * ((1.0 / arg2) * fpsfactor)) + arg1), arg0)
    Else
        Return min((((arg0 - arg1) * ((1.0 / arg2) * fpsfactor)) + arg1), arg0)
    EndIf
    Return 0.0
End Function
