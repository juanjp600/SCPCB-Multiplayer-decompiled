Function curveangle#(arg0#, arg1#, arg2#)
    Local local0#
    If (0.0 = fpsfactor) Then
        Return arg1
    EndIf
    local0 = (wrapangle(arg0) - wrapangle(arg1))
    If (180.0 < local0) Then
        local0 = (local0 - 360.0)
    EndIf
    If (-180.0 > local0) Then
        local0 = (local0 + 360.0)
    EndIf
    Return wrapangle(((((1.0 / arg2) * fpsfactor) * local0) + arg1))
    Return 0.0
End Function
