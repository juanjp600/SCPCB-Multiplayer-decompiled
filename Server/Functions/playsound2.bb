Function playsound2%(arg0%, arg1%, arg2%, arg3#, arg4#)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    If (arg2 = $00) Then
        Return $00
    EndIf
    arg3 = max(arg3, 1.0)
    local0 = $00
    If (0.0 < arg4) Then
        local1 = (entitydistance(arg1, arg2) / arg3)
        If (((0.0 < (1.0 - local1)) And (1.0 > (1.0 - local1))) <> 0) Then
            local2 = sin((- deltayaw(arg1, arg2)))
            local0 = playsound_strict(arg0)
            channelvolume(local0, (((1.0 - local1) * arg4) * local3))
            channelpan(local0, local2)
        EndIf
    EndIf
    Return local0
    Return $00
End Function
