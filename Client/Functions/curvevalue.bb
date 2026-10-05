Function curvevalue#(arg0#, arg1#, arg2#)
    Local local0#
    If (((0.0 >= fpsfactor) Or (0.0 >= arg2)) <> 0) Then
        Return arg0
    EndIf
    local0 = (fpsfactor / arg2)
    If (1.0 <= local0) Then
        Return arg0
    EndIf
    Return (((arg0 - arg1) * local0) + arg1)
    Return 0.0
End Function
