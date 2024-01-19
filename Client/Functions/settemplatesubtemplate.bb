Function settemplatesubtemplate%(arg0%, arg1%, arg2%)
    Local local0.template
    Local local1%
    local0 = (Object.template arg0)
    For local1 = $00 To $07 Step $01
        If (local0\Field0[local1] = Null) Then
            local0\Field0[local1] = (Object.template arg1)
            Exit
        EndIf
    Next
    Return $00
End Function
