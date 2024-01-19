Function renderprogressbar#(arg0%, arg1%, arg2%, arg3%, arg4#, arg5#)
    Local local0#
    local0 = max(min((((Float arg2) / arg4) * arg5), (Float arg2)), 0.0)
    rect(arg0, arg1, (Int local0), arg3, $01)
    Return local0
    Return 0.0
End Function
