Function addtotimingaccumulator%(arg0%)
    If (((arg0 < $01) Or (arg0 > $1F4)) <> 0) Then
        Return $00
    EndIf
    ft\Field1 = (ft\Field1 + max(0.0, (((Float arg0) * 70.0) / 1000.0)))
    Return $00
End Function
