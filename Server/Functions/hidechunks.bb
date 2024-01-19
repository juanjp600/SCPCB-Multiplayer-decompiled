Function hidechunks%()
    Local local0.chunk
    Local local1%
    For local0 = Each chunk
        If (local0\Field5 = $00) Then
            For local1 = $00 To local0\Field4 Step $01
                freeentity(local0\Field0[local1])
            Next
            freeentity(local0\Field7)
            freeentity(local0\Field6)
            Delete local0
        EndIf
    Next
    Return $00
End Function
