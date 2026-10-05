Function generateindex%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    local1 = len(arg0)
    For local2 = $01 To local1 Step $01
        local0 = (local0 + asc(mid(arg0, local2, $01)))
    Next
    Return local0
    Return $00
End Function
