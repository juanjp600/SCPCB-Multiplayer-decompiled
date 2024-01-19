Function instrlatest%(arg0$, arg1$, arg2%)
    Local local0%
    Local local1%
    For local1 = arg2 To len(arg0) Step $01
        If (mid(arg0, local1, $01) = arg1) Then
            local0 = local1
        EndIf
    Next
    Return local0
    Return $00
End Function
