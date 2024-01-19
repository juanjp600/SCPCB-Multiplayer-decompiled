Function othernpcseesmenpc%(arg0.npcs, arg1.npcs)
    If (0.0 >= arg1\Field49) Then
        Return $00
    EndIf
    If (6.0 > entitydistance(arg1\Field4, arg0\Field4)) Then
        If (60.0 > (Abs deltayaw(arg1\Field4, arg0\Field4))) Then
            Return $01
        EndIf
    EndIf
    Return $00
    Return $00
End Function
