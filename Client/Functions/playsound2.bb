Function playsound2%(arg0%, arg1%, arg2%, arg3#, arg4#)
    Local local0#
    Local local1%
    Local local2#
    If (arg2 = $00) Then
        Return $00
    EndIf
    If (0.0 >= arg4) Then
        Return $00
    EndIf
    local0 = entitydistance(arg1, arg2)
    If (arg3 > local0) Then
        local1 = playsound_strict(arg0)
        If (local1 <> 0) Then
            local2 = sin((- deltayaw(arg1, arg2)))
            channelvolume(local1, (((1.0 - (local0 / arg3)) * arg4) * sfxvolume))
            channelpan(local1, local2)
            Return local1
        EndIf
    EndIf
    Return $00
    Return $00
End Function
