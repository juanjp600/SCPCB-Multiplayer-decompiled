Function angledist#(arg0#, arg1#)
    Local local0#
    local0 = (arg0 - arg1)
    If (-180.0 > local0) Then
        Return (local0 + 360.0)
    EndIf
    If (180.0 < local0) Then
        Return (local0 - 360.0)
    EndIf
    Return local0
    Return 0.0
End Function
