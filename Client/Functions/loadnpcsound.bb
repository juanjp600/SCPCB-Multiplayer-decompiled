Function loadnpcsound%(arg0.npcs, arg1$, arg2%)
    If (arg2 = $00) Then
        If (arg0\Field17 <> $00) Then
            freesound_strict(arg0\Field17)
            arg0\Field17 = $00
        EndIf
        arg0\Field17 = loadsound_strict(arg1)
        Return arg0\Field17
    ElseIf (arg2 = $01) Then
        If (arg0\Field19 <> $00) Then
            freesound_strict(arg0\Field19)
            arg0\Field19 = $00
        EndIf
        arg0\Field19 = loadsound_strict(arg1)
        Return arg0\Field19
    EndIf
    Return $00
End Function
