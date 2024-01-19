Function generateindex%(arg0$)
    Local local0%
    Local local1%
    For local1 = $01 To len(arg0) Step $01
        local0 = (local0 + asc(mid(arg0, local1, $01)))
    Next
    Return local0
    Return $00
End Function
