Function removewearableitems%(arg0.items)
    Select arg0\Field4\Field2
        Case $38,$39,$3A,$3B
            wi\Field0 = $00
        Case $24,$25
            i_1499\Field0 = $00
        Case $40,$42,$41
            If (wi\Field5 > $00) Then
                fog\Field0 = 6.0
                wi\Field5 = $00
            EndIf
        Case $43,$44
            If (wi\Field9 > $00) Then
                fog\Field0 = 6.0
                wi\Field9 = $00
            EndIf
        Case $26
            wi\Field4 = $00
        Case $27,$28
            wi\Field3 = $00
        Case $3C,$3D,$3E,$3F
            wi\Field2 = $00
        Case $0D,$0E,$0F
            i_268\Field0 = $00
        Case $14
            i_427\Field0 = $00
        Case $1B,$1A
            i_714\Field0 = $00
    End Select
    Return $00
End Function
