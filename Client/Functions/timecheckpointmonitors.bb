Function timecheckpointmonitors%()
    If (updatecheckpoint1 <> 0) Then
        If (100.0 > monitortimer) Then
            monitortimer = min((monitortimer + fpsfactor), 100.0)
        Else
            monitortimer = 0.0
        EndIf
    EndIf
    If (updatecheckpoint2 <> 0) Then
        If (100.0 > monitortimer2) Then
            monitortimer2 = min((monitortimer2 + fpsfactor), 100.0)
        Else
            monitortimer2 = 0.0
        EndIf
    EndIf
    Return $00
End Function
