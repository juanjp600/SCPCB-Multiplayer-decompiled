Function generateseednumber%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    local0 = $00
    local1 = $00
    For local2 = $01 To len(arg0) Step $01
        local0 = (local0 Xor (asc(mid(arg0, local2, $01)) Shl local1))
        local1 = ((local1 + $01) Mod $18)
    Next
    Return local0
    Return $00
End Function
