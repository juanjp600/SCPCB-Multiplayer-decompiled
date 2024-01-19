Function updatestreamsoundorigin%(arg0%, arg1%, arg2%, arg3#, arg4#)
    Local local0#
    Local local1#
    arg3 = max(arg3, 1.0)
    If (0.0 < arg4) Then
        local0 = (entitydistance(arg1, arg2) / arg3)
        If (((0.0 < (1.0 - local0)) And (1.0 > (1.0 - local0))) <> 0) Then
            local1 = sin((- deltayaw(arg1, arg2)))
            setstreamvolume_strict(arg0, (((1.0 - local0) * arg4) * sfxvolume))
            setstreampan_strict(arg0, local1)
        Else
            setstreamvolume_strict(arg0, 0.0)
        EndIf
    ElseIf (arg0 <> $00) Then
        setstreamvolume_strict(arg0, 0.0)
    EndIf
    Return $00
End Function
