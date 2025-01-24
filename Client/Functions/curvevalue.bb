Function curvevalue#(arg0#, arg1#, arg2#)
    Local local0#
    local0 = ((((1.0 / arg2) * fps\Field7[$00]) * (arg0 - arg1)) + arg1)
    If (arg1 > arg0) Then
        Return max(local0, arg0)
    Else
        Return min(local0, arg0)
    EndIf
    Return 0.0
End Function
