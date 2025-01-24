Function isiteminfocus%()
    Select selecteditem\Field4\Field2
        Case $49,$4A,$4B,$4C,$00,$01,$03,$06,$04,$05,$20,$21,$4D,$4E,$4F
            Return $01
    End Select
    Return $00
    Return $00
End Function
