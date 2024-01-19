Function renderprogressbary#(arg0%, arg1%, arg2%, arg3%, arg4#, arg5#)
    Local local0#
    local0 = max(min((((Float arg3) / arg4) * arg5), (Float arg3)), 0.0)
    rect(arg0, (Int ((Float arg1) - local0)), arg2, (Int local0), $01)
    Return local0
    Return 0.0
End Function
