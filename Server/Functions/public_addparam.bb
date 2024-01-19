Function public_addparam%(arg0%, arg1$, arg2%)
    publics\Field1 = (publics\Field1 + $01)
    publics\Field2[publics\Field1] = arg1
    publics\Field3[publics\Field1] = arg2
    Return $00
End Function
