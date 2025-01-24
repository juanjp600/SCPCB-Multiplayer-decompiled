Function hidechunks%()
    Local local0.chunk
    Local local1%
    For local0 = Each chunk
        If (local0\Field5 = $00) Then
            removechunk(local0)
        EndIf
    Next
    Return $00
End Function
