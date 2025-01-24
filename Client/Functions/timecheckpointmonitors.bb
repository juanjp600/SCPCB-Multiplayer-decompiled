Function timecheckpointmonitors%()
    If (mon_i\Field3[$00] <> 0) Then
        If (100.0 > mon_i\Field2[$00]) Then
            mon_i\Field2[$00] = (mon_i\Field2[$00] + fps\Field7[$00])
        Else
            mon_i\Field2[$00] = 0.0
        EndIf
    EndIf
    If (mon_i\Field3[$01] <> 0) Then
        If (100.0 > mon_i\Field2[$01]) Then
            mon_i\Field2[$01] = (mon_i\Field2[$01] + fps\Field7[$00])
        Else
            mon_i\Field2[$01] = 0.0
        EndIf
    EndIf
    Return $00
End Function
