Function breach_getcategoryname$(arg0%)
    Select arg0
        Case $05
            Return "SCPs"
        Case $03,$07
            Return "Security"
        Case $01,$06
            Return "Class D"
        Case $04
            Return "Staff"
        Case $08
            Return "Stalemate"
    End Select
    Return ""
    Return ""
End Function
