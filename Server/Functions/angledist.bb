Function angledist#(arg0#, arg1#)
    Local local0#
    Local local1#
    local0 = (arg0 - arg1)
    If (-180.0 > local0) Then
        local1 = (local0 + 360.0)
    ElseIf (180.0 < local0) Then
        local1 = (local0 - 360.0)
    Else
        local1 = local0
    EndIf
    Return local1
    Return 0.0
End Function
