Function distance3#(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#)
    Local local0%
    Local local1%
    Local local2%
    local0 = (Int (arg3 - arg0))
    local0 = (local0 * local0)
    local1 = (Int (arg4 - arg1))
    local1 = (local1 * local1)
    local2 = (Int (arg5 - arg2))
    local2 = (local2 * local2)
    Return sqr((Float ((local0 + local1) + local2)))
    Return 0.0
End Function
