Function settypecolor%(arg0%)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    color(local0\Field5, local0\Field6, local0\Field7)
    Return $01
    Return $00
End Function
