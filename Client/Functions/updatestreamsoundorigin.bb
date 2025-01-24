Function updatestreamsoundorigin%(arg0%, arg1%, arg2%, arg3#, arg4#, arg5%)
    Local local0#
    Local local1#
    If (arg0 <> $00) Then
        If (isstreamplaying_strict(arg0) <> 0) Then
            arg3 = max(arg3, 1.0)
            If (0.0 < arg4) Then
                local0 = (entitydistance(arg1, arg2) / arg3)
                If (((0.0 < (1.0 - local0)) And (1.0 > (1.0 - local0))) <> 0) Then
                    local1 = sin((- deltayaw(arg1, arg2)))
                    setstreamvolume_strict(arg0, ((((opt\Field21 * (Float arg5)) + (opt\Field20 * (Float (arg5 = $00)))) * ((1.0 - local0) * arg4)) * opt\Field16))
                    setstreampan_strict(arg0, local1)
                Else
                    setstreamvolume_strict(arg0, 0.0)
                EndIf
            Else
                setstreamvolume_strict(arg0, 0.0)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
