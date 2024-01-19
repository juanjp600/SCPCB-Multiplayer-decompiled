Function executeframelimit%(arg0%, arg1%, arg2%)
    delay((Int ((1000.0 / (Float arg0)) - (Float (arg1 - arg2)))))
    Return $00
End Function
