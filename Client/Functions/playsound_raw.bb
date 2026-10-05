Function playsound_raw%(arg0%, arg1%, arg2#, arg3#, arg4#, arg5#, arg6#)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    If (0.0 < arg6) Then
        arg5 = max(arg5, 1.0)
        local0 = $00
        local1 = (arg2 - entityx(arg1, $00))
        local2 = (arg3 - entityy(arg1, $00))
        local3 = (arg4 - entityz(arg1, $00))
        local4 = (((local1 * local1) + (local2 * local2)) + (local3 * local3))
        local5 = (arg5 * arg5)
        If (local5 > local4) Then
            local6 = atan2(local1, local3)
            local7 = entityyaw(arg1, $00)
            local8 = (local6 - local7)
            local9 = sin((- local8))
            local0 = playsound_strict(arg0)
            local10 = (local4 / local5)
            local11 = (1.0 - ((0.7 * local10) + ((0.3 * local10) * local10)))
            If (0.0 > local11) Then
                local11 = 0.0
            EndIf
            channelvolume(local0, ((arg6 * local11) * sfxvolume))
            channelpan(local0, local9)
        EndIf
    EndIf
    Return local0
    Return $00
End Function
