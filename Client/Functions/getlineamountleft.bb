Function getlineamountleft%(arg0$, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    local0 = len(arg0)
    local5 = $01
    If (local6 < $01) Then
        local6 = $800
    EndIf
    For local7 = $01 To local0 Step $01
        local4 = mid(arg0, local7, $01)
        local1 = (local1 + stringwidth(local4))
        If (local1 > arg1) Then
            local8 = (local8 + arg3)
            local2 = (local2 + arg3)
            local1 = $00
            If ((local8 + local2) > (local8 + arg2)) Then
                Exit
            EndIf
            If (local7 < local0) Then
                local5 = (local5 + $01)
            EndIf
        EndIf
    Next
    Return local5
    Return $00
End Function
