Function mp_loadnpcsound%(arg0.npcs, arg1$, arg2%)
    If (arg2 = $00) Then
        If (((arg0\Field17 = $00) Lor (arg0\Field67 <> arg1)) <> 0) Then
            If (arg0\Field17 <> $00) Then
                freesound_strict(arg0\Field17)
            EndIf
            arg0\Field17 = loadsound_strict(arg1)
            arg0\Field67 = arg1
        EndIf
        Return arg0\Field17
    EndIf
    If (((arg0\Field19 = $00) Lor (arg0\Field68 <> arg1)) <> 0) Then
        If (arg0\Field19 <> $00) Then
            freesound_strict(arg0\Field19)
        EndIf
        arg0\Field19 = loadsound_strict(arg1)
        arg0\Field68 = arg1
    EndIf
    Return arg0\Field19
    Return $00
End Function
