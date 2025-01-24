Function isitemgoodfor1162arc%(arg0.itemtemplates)
    Select arg0\Field2
        Case $59,$5A,$5B,$5C
            Return $01
        Case $61,$63,$02,$2F
            Return $01
        Case $27,$28,$38
            Return $01
        Case $45,$46
            Return $01
        Case $30,$55,$10,$11,$12
            Return $01
        Default
            If (arg0\Field2 <> $00) Then
                Return $00
            ElseIf (instr(arg0\Field1, "Leaflet", $01) <> 0) Then
                Return $00
            Else
                Return ((instr(arg0\Field1, "Note", $01) = $00) And (instr(arg0\Field1, "Log", $01) = $00))
            EndIf
    End Select
    Return $00
End Function
