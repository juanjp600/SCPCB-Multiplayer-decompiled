Function loadeventsound%(arg0.events, arg1$, arg2%)
    If (arg2 = $00) Then
        If (arg0\Field8 <> $00) Then
            freesound_strict(arg0\Field8)
            arg0\Field8 = $00
        EndIf
        arg0\Field8 = loadsound_strict(arg1)
        Return arg0\Field8
    ElseIf (arg2 = $01) Then
        If (arg0\Field9 <> $00) Then
            freesound_strict(arg0\Field9)
            arg0\Field9 = $00
        EndIf
        arg0\Field9 = loadsound_strict(arg1)
        Return arg0\Field9
    EndIf
    Return $00
End Function
