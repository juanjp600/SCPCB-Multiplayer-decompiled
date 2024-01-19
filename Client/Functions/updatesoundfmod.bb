Function updatesoundfmod%(arg0%, arg1%, arg2%, arg3#, arg4#)
    Local local0#
    Local local1#
    arg3 = max(arg3, 1.0)
    If (0.0 < arg4) Then
        local0 = (entitydistance(arg1, arg2) / arg3)
        If (((0.0 < (1.0 - local0)) And (1.0 > (1.0 - local0))) <> 0) Then
            local1 = sin((- deltayaw(arg1, arg2)))
            fsound_setvolume(arg0, (Int ((((1.0 - local0) * arg4) * sfxvolume) * 255.0)))
            fsound_setpan(arg0, (Int ((127.5 * local1) + 127.5)))
        Else
            fsound_setvolume(arg0, $00)
        EndIf
    ElseIf (arg0 <> $00) Then
        fsound_setvolume(arg0, $00)
    EndIf
    Return $00
End Function
