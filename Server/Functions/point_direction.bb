Function point_direction#(arg0#, arg1#, arg2#, arg3#)
    Local local0#
    Local local1#
    local0 = (arg0 - arg2)
    local1 = (arg1 - arg3)
    Return atan2(local1, local0)
    Return 0.0
End Function
