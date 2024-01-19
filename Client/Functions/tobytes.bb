Function tobytes%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    For local2 = $01 To len(arg0) Step $01
        local0 = (local0 + (asc(mid(arg0, local2, $01)) Shl local1))
        local1 = (local1 + $08)
    Next
    Return local0
    Return $00
End Function
