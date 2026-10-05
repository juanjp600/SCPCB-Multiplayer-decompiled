Function deletequerys%()
    Local local0.querys
    For local0 = Each querys
        If (local0\Field3 <> $00) Then
            closefile(local0\Field3)
        EndIf
        If (local0\Field10 <> $00) Then
            freebank(local0\Field10)
        EndIf
        Delete local0
    Next
    Return $00
End Function
