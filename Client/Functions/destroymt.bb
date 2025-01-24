Function destroymt%(arg0.mtgrid, arg1%)
    Local local0%
    Local local1%
    For local0 = $00 To $12 Step $01
        For local1 = $00 To $12 Step $01
            If (arg0\Field3[((local1 * $13) + local0)] <> $00) Then
                freeentity(arg0\Field3[((local1 * $13) + local0)])
                arg0\Field3[((local1 * $13) + local0)] = $00
            EndIf
            If ((arg1 And (arg0\Field4[((local1 * $13) + local0)] <> Null)) <> 0) Then
                removewaypoint(arg0\Field4[((local1 * $13) + local0)])
                arg0\Field4[((local1 * $13) + local0)] = Null
            EndIf
        Next
    Next
    For local0 = $00 To $06 Step $01
        If (arg0\Field2[local0] <> $00) Then
            freeentity(arg0\Field2[local0])
            arg0\Field2[local0] = $00
        EndIf
    Next
    Return $00
End Function
