Function bytestreamwritestring%(arg0.bs, arg1$)
    Local local0%
    bytestreamwritechar(arg0, len(arg1))
    For local0 = $01 To len(arg1) Step $01
        bytestreamwritechar(arg0, asc(mid(arg1, local0, $01)))
    Next
    Return $00
End Function
