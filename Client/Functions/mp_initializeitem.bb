Function mp_initializeitem%(arg0.items, arg1%)
    Local local0%
    arg0\Field27 = $00
    If (arg1 <> $FFFFFFFF) Then
        If (arg0\Field19 > $00) Then
            mp_items[arg0\Field19] = Null
        EndIf
        mp_items[arg1] = arg0
        arg0\Field19 = arg1
    Else
        For local0 = $01 To $3E7 Step $01
            If (mp_items[local0] = Null) Then
                mp_items[local0] = arg0
                arg0\Field19 = local0
                Exit
            EndIf
        Next
    EndIf
    Select arg0\Field4\Field2
        Case $2B
            arg0\Field25 = $01
        Case $2E,$2D
            arg0\Field25 = $02
        Case $49,$4B,$4C,$4A,$45,$46,$47,$48,$40,$41,$42,$43,$44,$4D,$4E,$4F
            arg0\Field25 = $03
        Case $3C,$3D,$3E,$3F
            arg0\Field25 = $04
        Case $61,$62
            arg0\Field25 = $05
    End Select
    arg0\Field31 = 70.0
    Return $00
End Function
