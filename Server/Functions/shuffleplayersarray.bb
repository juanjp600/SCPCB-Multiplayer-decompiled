Function shuffleplayersarray%(arg0%[65], arg1%)
    Local local0%
    Local local1%
    Local local2%
    local2 = (arg1 - $01)
    While (local2 >= $00)
        local0 = rand($00, local2)
        local1 = arg0[local0]
        arg0[local0] = arg0[local2]
        arg0[local2] = local1
        local2 = (local2 + $FFFFFFFF)
    Wend
    Return $00
End Function
