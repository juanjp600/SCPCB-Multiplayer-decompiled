Function playsoundex%(arg0%, arg1%, arg2%, arg3#, arg4#, arg5%, arg6%)
    Local local0%
    Local local1#
    Local local2#
    local0 = $00
    If (((arg2 <> $00) And (0.0 < arg4)) <> 0) Then
        arg3 = max(arg3, 1.0)
        local1 = (entitydistance(arg1, arg2) / arg3)
        If ((((0.0 < (1.0 - local1)) And (1.0 > (1.0 - local1))) Lor arg6) <> 0) Then
            local2 = sin((- deltayaw(arg1, arg2)))
            local0 = playsound_strict(arg0, arg5, $00)
            channelpan(local0, local2)
            channelvolume(local0, clamp(((((opt\Field21 * (Float arg5)) + (opt\Field20 * (Float (arg5 = $00)))) * ((1.0 - local1) * arg4)) * opt\Field16), 0.0, 1.0))
        EndIf
    EndIf
    Return local0
    Return $00
End Function
