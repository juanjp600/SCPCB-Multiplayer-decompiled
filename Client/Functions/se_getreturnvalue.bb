Function se_getreturnvalue$()
    Select se_return_value\Field0
        Case $00
            Return "-1"
        Case $01
            Return (Str se_return_value\Field1)
        Case $02
            Return (Str se_return_value\Field2)
        Case $03
            Return se_return_value\Field3
    End Select
    Return ""
End Function
