Function loopsound2%(arg0%, arg1%, arg2%, arg3%, arg4#, arg5#)
    Local local0#
    Local local1#
    Local local2#
    arg4 = max(arg4, 1.0)
    If (0.0 < arg5) Then
        local0 = (entitydistance(arg2, arg3) / arg4)
        local1 = sin((- deltayaw(arg2, arg3)))
        If (arg1 = $00) Then
            arg1 = playsound_strict(arg0)
        ElseIf (channelplaying(arg1) = $00) Then
            arg1 = playsound_strict(arg0)
        EndIf
        channelvolume(arg1, (((1.0 - local0) * arg5) * local2))
        channelpan(arg1, local1)
    ElseIf (arg1 <> $00) Then
        channelvolume(arg1, 0.0)
    EndIf
    Return arg1
    Return $00
End Function
