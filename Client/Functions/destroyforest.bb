Function destroyforest%(arg0.forest)
    Local local0%
    Local local1%
    Local local2%
    For local0 = $00 To $09 Step $01
        For local1 = $00 To $09 Step $01
            If (arg0\Field3[((local1 * $0A) + local0)] <> $00) Then
                freeentity(arg0\Field3[((local1 * $0A) + local0)])
                arg0\Field3[((local1 * $0A) + local0)] = $00
                arg0\Field2[((local1 * $0A) + local0)] = $00
            EndIf
        Next
    Next
    If (arg0\Field5[$00] <> $00) Then
        freeentity(arg0\Field5[$00])
        arg0\Field5[$00] = $00
    EndIf
    If (arg0\Field5[$01] <> $00) Then
        freeentity(arg0\Field5[$01])
        arg0\Field5[$00] = $01
    EndIf
    If (arg0\Field6[$00] <> $00) Then
        freeentity(arg0\Field6[$00])
        arg0\Field6[$00] = $00
    EndIf
    If (arg0\Field6[$01] <> $00) Then
        freeentity(arg0\Field6[$01])
        arg0\Field6[$01] = $00
    EndIf
    If (arg0\Field4 <> $00) Then
        freeentity(arg0\Field4)
        arg0\Field4 = $00
    EndIf
    For local2 = $01 To $05 Step $01
        If (arg0\Field0[local2] <> $00) Then
            freeentity(arg0\Field0[local2])
            arg0\Field0[local2] = $00
        EndIf
    Next
    For local2 = $00 To $04 Step $01
        If (arg0\Field1[local2] <> $00) Then
            freeentity(arg0\Field1[local2])
            arg0\Field1[local2] = $00
        EndIf
    Next
    Return $00
End Function
