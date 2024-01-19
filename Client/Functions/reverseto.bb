Function reverseto#(arg0#, arg1#, arg2#)
    If (((arg2 < arg0) Or (arg1 > arg0)) <> 0) Then
        arg0 = arg1
    EndIf
    Return arg0
    Return 0.0
End Function
