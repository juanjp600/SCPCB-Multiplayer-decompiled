Function deletecharfromstring$(arg0$, arg1$, arg2%)
    Local local0$
    Local local1%
    For local1 = $01 To len(arg0) Step $01
        If (((mid(arg0, local1, $01) <> arg1) Or (local1 < arg2)) <> 0) Then
            local0 = (local0 + mid(arg0, local1, $01))
        EndIf
    Next
    Return local0
    Return ""
End Function
