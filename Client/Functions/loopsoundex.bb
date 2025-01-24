Function loopsoundex%(arg0%, arg1%, arg2%, arg3%, arg4#, arg5#, arg6%)
    Local local0#
    Local local1#
    If (0.0 < arg5) Then
        arg4 = max(arg4, 1.0)
        local0 = (entitydistance(arg2, arg3) / arg4)
        local1 = sin((- deltayaw(arg2, arg3)))
        If (channelplaying(arg1) = $00) Then
            arg1 = playsound_strict(arg0, arg6)
        EndIf
        channelvolume(arg1, ((((opt\Field21 * (Float arg6)) + (opt\Field20 * (Float (arg6 = $00)))) * ((1.0 - local0) * arg5)) * opt\Field16))
        channelpan(arg1, local1)
    Else
        channelvolume(arg1, 0.0)
    EndIf
    Return arg1
    Return $00
End Function
