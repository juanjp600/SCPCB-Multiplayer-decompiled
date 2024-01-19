Function analyzeerrorfile%()
    Local local0%
    While (filetype(((errorfile + (Str local0)) + ".txt")) <> $00)
        local0 = (local0 + $01)
    Wend
    errorfile = ((errorfile + (Str local0)) + ".txt")
    Return $00
End Function
