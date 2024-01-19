Function getzone%(arg0%)
    Return (Int min(floor((((Float (mapwidth - arg0)) / (Float mapwidth)) * 3.0)), 2.0))
    Return $00
End Function
