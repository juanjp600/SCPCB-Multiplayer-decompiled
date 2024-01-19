Function se_checkidentifier%(arg0.se_token)
    Select arg0\Field1
        Case "end","const","local","static","global","public","def","if","then","else","select","case","for","while","do","repeat","return","continue","break"
            arg0\Field0 = $0C
            arg0\Field4 = (("keyword '" + arg0\Field1) + "'")
            Return $01
        Case "not","and","or","typeof","len","args"
            arg0\Field0 = $07
            arg0\Field4 = (("operator '" + arg0\Field1) + "'")
            Return $01
    End Select
    Return $00
End Function
