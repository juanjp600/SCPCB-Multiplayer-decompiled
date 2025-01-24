Function mp_initializenpc%(arg0.npcs, arg1%)
    Local local0%
    If (arg1 <> $FFFFFFFF) Then
        If (arg0\Field5 > $00) Then
            mp_npcs[arg0\Field5] = Null
        EndIf
        mp_npcs[arg1] = arg0
        arg0\Field5 = arg1
    Else
        For local0 = $01 To $FF Step $01
            If (mp_npcs[local0] = Null) Then
                mp_npcs[local0] = arg0
                arg0\Field5 = local0
                Exit
            EndIf
        Next
    EndIf
    Select arg0\Field4
        Case $07
            n_i\Field2 = arg0
        Case $06
            n_i\Field3 = arg0
        Case $05
            n_i\Field4 = arg0
        Case $09
            n_i\Field5 = arg0
        Case $02
            n_i\Field6 = arg0
        Case $04
            n_i\Field7 = arg0
        Case $08,$10
            arg0\Field87 = $01
    End Select
    Return $00
End Function
