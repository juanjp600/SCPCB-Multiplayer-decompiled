Function mp_loadeventsound%(arg0.events, arg1$, arg2%)
    If (arg2 = $00) Then
        If (((arg0\Field8 = $00) Lor (arg0\Field16 <> arg1)) <> 0) Then
            If (arg0\Field8 <> $00) Then
                freesound_strict(arg0\Field8)
            EndIf
            arg0\Field8 = loadsound_strict(arg1)
            arg0\Field16 = arg1
        EndIf
        Return arg0\Field8
    EndIf
    If (((arg0\Field9 = $00) Lor (arg0\Field17 <> arg1)) <> 0) Then
        If (arg0\Field9 <> $00) Then
            freesound_strict(arg0\Field9)
        EndIf
        arg0\Field9 = loadsound_strict(arg1)
        arg0\Field17 = arg1
    EndIf
    Return arg0\Field9
    Return $00
End Function
