Function generateseednumber%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    local0 = $00
    local1 = $00
    local2 = len(arg0)
    For local3 = $01 To local2 Step $01
        local0 = (local0 Xor (asc(mid(arg0, local3, $01)) Shl local1))
        local1 = ((local1 + $01) Mod $18)
    Next
    Return local0
    Return $00
End Function
