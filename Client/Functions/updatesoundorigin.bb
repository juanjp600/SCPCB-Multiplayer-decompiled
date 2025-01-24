Function updatesoundorigin%(arg0%, arg1%, arg2%, arg3#, arg4#, arg5%, arg6%)
    Local local0#
    Local local1#
    If (((channelplaying(arg0) = $00) Lor (arg2 = $00)) <> 0) Then
        Return $00
    EndIf
    If (0.0 < arg4) Then
        arg3 = max(arg3, 1.0)
        local0 = (entitydistance(arg1, arg2) / arg3)
        If (((0.0 < (1.0 - local0)) And (1.0 > (1.0 - local0))) <> 0) Then
            local1 = sin((- deltayaw(arg1, arg2)))
            channelvolume(arg0, ((((((opt\Field21 * (Float arg5)) + (opt\Field20 * (Float (arg5 = $00)))) * (Float arg6)) * opt\Field16) + (Float (arg6 = $00))) * ((1.0 - local0) * arg4)))
            channelpan(arg0, local1)
        Else
            channelvolume(arg0, 0.0)
        EndIf
    Else
        channelvolume(arg0, 0.0)
    EndIf
    Return $00
End Function
