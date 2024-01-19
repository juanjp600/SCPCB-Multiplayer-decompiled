Function deleteguns%()
    Local local0.guns
    For local0 = Each guns
        If (local0\Field21 <> $00) Then
            freesound_strict(local0\Field21)
        EndIf
        If (local0\Field19 <> $00) Then
            freesound_strict(local0\Field19)
        EndIf
        If (local0\Field9 <> $00) Then
            freesound_strict(local0\Field9)
        EndIf
        Delete local0
    Next
    freesound_strict(shootemptysfx)
    shootemptysfx = $00
    Return $00
End Function
