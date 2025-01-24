Function mp_writebytes%(arg0%, arg1%, arg2%)
    copybank(arg0, arg2, network\Field1\Field0, network\Field1\Field2, arg1)
    network\Field1\Field2 = (network\Field1\Field2 + arg1)
    Return $00
End Function
