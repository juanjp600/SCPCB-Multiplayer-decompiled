Function bytestreamreadstring$(arg0.bs)
    Local local0$
    Local local1%
    Local local2%
    local1 = bytestreamreadchar(arg0)
    For local2 = $01 To local1 Step $01
        local0 = (local0 + chr(bytestreamreadchar(arg0)))
    Next
    Return local0
    Return ""
End Function
