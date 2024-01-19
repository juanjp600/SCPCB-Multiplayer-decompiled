Function se_setvalue%(arg0.se_value, arg1$, arg2%)
    se_gccheck(arg0)
    Select arg2
        Case $00
            arg0\Field0 = $00
        Case $01
            arg0\Field0 = $01
            arg0\Field1 = (Int arg1)
        Case $02
            arg0\Field0 = $02
            arg0\Field2 = (Float arg1)
        Case $03
            arg0\Field0 = $03
            arg0\Field3 = arg1
    End Select
    Return $00
End Function
