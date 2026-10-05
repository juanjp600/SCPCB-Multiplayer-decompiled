Function loopsound2%(arg0%, arg1%, arg2%, arg3%, arg4#, arg5#)
    Local local0#
    Local local1#
    Local local2#
    If (0.0 >= arg5) Then
        If (arg1 <> $00) Then
            stopchannel(arg1)
            Return $00
        EndIf
        Return $00
    EndIf
    local0 = entitydistance(arg2, arg3)
    If (arg4 > local0) Then
        If (arg1 = $00) Then
            arg1 = playsound_strict(arg0)
        ElseIf (channelplaying(arg1) = $00) Then
            arg1 = playsound_strict(arg0)
        EndIf
        If (arg1 <> $00) Then
            local1 = sin((- deltayaw(arg2, arg3)))
            local2 = (1.0 - (local0 / arg4))
            channelvolume(arg1, ((arg5 * local2) * sfxvolume))
            channelpan(arg1, local1)
        EndIf
    ElseIf (arg1 <> $00) Then
        stopchannel(arg1)
        arg1 = $00
    EndIf
    Return arg1
    Return $00
End Function
