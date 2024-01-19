Function point_distance#(arg0#, arg1#, arg2#, arg3#)
    Local local0#
    Local local1#
    local0 = (arg0 - arg2)
    local1 = (arg1 - arg3)
    Return sqr(((local0 * local0) + (local1 * local1)))
    Return 0.0
End Function
