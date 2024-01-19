Function updatesoundorigin%(arg0%, arg1%, arg2%, arg3#, arg4#)
    Local local0#
    Local local1#
    arg3 = max(arg3, 1.0)
    If (0.0 < arg4) Then
        local0 = (entitydistance(arg1, arg2) / arg3)
        If (((0.0 < (1.0 - local0)) And (1.0 > (1.0 - local0))) <> 0) Then
            local1 = sin((- deltayaw(arg1, arg2)))
            channelvolume(arg0, (((1.0 - local0) * arg4) * sfxvolume))
            channelpan(arg0, local1)
        Else
            channelvolume(arg0, 0.0)
        EndIf
    ElseIf (arg0 <> $00) Then
        channelvolume(arg0, 0.0)
    EndIf
    Return $00
End Function
