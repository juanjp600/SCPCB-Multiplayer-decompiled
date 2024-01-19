Function reloadudpstream%(arg0%)
    Local local0%
    local0 = udpstreamport(arg0)
    closeudpstream(arg0)
    Return createudpstream(local0)
    Return $00
End Function
