Function reloadudpstream%(arg0%)
    Local local0%
    Local local1%
    local0 = udpstreamport(arg0)
    local1 = udpstreamip(arg0)
    closeudpstream(arg0)
    Return createudpstream((Str local1), local0)
    Return $00
End Function
