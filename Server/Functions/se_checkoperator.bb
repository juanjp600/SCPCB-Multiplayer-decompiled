Function se_checkoperator$(arg0$, arg1%)
    Local local0%
    Local local1%
    Local local2$
    For local0 = $00 To $14 Step $01
        local1 = len(se_operators[local0])
        local2 = mid(arg0, arg1, local1)
        If (local2 = se_operators[local0]) Then
            Return se_operators[local0]
        EndIf
    Next
    Return ""
End Function
