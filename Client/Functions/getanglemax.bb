Function getanglemax#(arg0#, arg1#)
    Local local0#
    local0 = (wrapangle(arg0) - wrapangle(arg1))
    If (180.0 < local0) Then
        local0 = (local0 - 360.0)
    EndIf
    If (-180.0 > local0) Then
        local0 = (local0 + 360.0)
    EndIf
    Return local0
    Return 0.0
End Function
