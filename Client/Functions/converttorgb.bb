Function converttorgb%(arg0%, arg1%, arg2%)
    Return ((arg2 Or (arg1 Shl $08)) Or (arg0 Shl $10))
    Return $00
End Function
