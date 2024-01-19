Function getcluescount%()
    Local local0%
    For local0 = $00 To $1F Step $01
        If (clues[local0] = $FFFFFFFF) Then
            Exit
        EndIf
    Next
    Return local0
    Return $00
End Function
