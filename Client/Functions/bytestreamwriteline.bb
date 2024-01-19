Function bytestreamwriteline%(arg0.bs, arg1$)
    Local local0%
    For local0 = $01 To len(arg1) Step $01
        bytestreamwritechar(arg0, asc(mid(arg1, local0, $01)))
    Next
    bytestreamwritechar(arg0, $0D)
    bytestreamwritechar(arg0, $0A)
    Return $00
End Function
