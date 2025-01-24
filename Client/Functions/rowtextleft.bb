Function rowtextleft%(arg0$, arg1%, arg2%, arg3%, arg4%, arg5%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    local0 = len(arg0)
    If (local5 < $01) Then
        local5 = $800
    EndIf
    For local6 = $01 To local0 Step $01
        local4 = mid(arg0, local6, $01)
        textex((arg1 + local1), arg2, local4, $00, $00)
        local1 = (local1 + stringwidth(local4))
        If (local1 > arg3) Then
            arg2 = (arg2 + arg5)
            local2 = (local2 + arg5)
            local1 = $00
            If ((arg2 + local2) > (arg2 + arg4)) Then
                Exit
            EndIf
        EndIf
    Next
    Return $00
End Function
