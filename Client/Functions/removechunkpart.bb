Function removechunkpart%(arg0.chunkpart)
    Local local0%
    For local0 = $00 To $7F Step $01
        If (arg0\Field1[local0] <> $00) Then
            freeentity(arg0\Field1[local0])
            arg0\Field1[local0] = $00
        EndIf
    Next
    Delete arg0
    Return $00
End Function
