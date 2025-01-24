Function destroyforest%(arg0.forest, arg1%)
    Local local0%
    Local local1%
    Local local2%
    catcherrors((("DestroyForest(" + (Str arg1)) + ")"))
    For local0 = $00 To $09 Step $01
        For local1 = $00 To $09 Step $01
            If (arg0\Field3[((local1 * $0A) + local0)] <> $00) Then
                freeentity(arg0\Field3[((local1 * $0A) + local0)])
                arg0\Field3[((local1 * $0A) + local0)] = $00
                If (arg1 <> 0) Then
                    arg0\Field2[((local1 * $0A) + local0)] = $00
                EndIf
            EndIf
        Next
    Next
    For local2 = $00 To $01 Step $01
        If (arg0\Field5[local2] <> Null) Then
            removedoor(arg0\Field5[local2])
        EndIf
        If (arg0\Field6[local2] <> $00) Then
            freeentity(arg0\Field6[local2])
            arg0\Field6[local2] = $00
        EndIf
    Next
    If (arg0\Field4 <> $00) Then
        freeentity(arg0\Field4)
        arg0\Field4 = $00
    EndIf
    For local2 = $00 To $04 Step $01
        If (arg0\Field0[local2] <> $00) Then
            freeentity(arg0\Field0[local2])
            arg0\Field0[local2] = $00
        EndIf
    Next
    For local2 = $00 To $03 Step $01
        If (arg0\Field1[local2] <> $00) Then
            freeentity(arg0\Field1[local2])
            arg0\Field1[local2] = $00
        EndIf
    Next
    catcherrors((("Uncaught: DestroyForest(" + (Str arg1)) + ")"))
    Return $00
End Function
