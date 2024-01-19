Function have_querys%()
    Local local0.querys
    For local0 = Each querys
        If (local0\Field3 <> $00) Then
            If (((filepos(local0\Field3) <> $00) And (previousdownloadpos[$02] < millisecs())) <> 0) Then
                Return $01
            EndIf
        EndIf
    Next
    Return $00
    Return $00
End Function
