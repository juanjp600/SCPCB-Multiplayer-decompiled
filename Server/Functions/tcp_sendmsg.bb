Function tcp_sendmsg%(arg0%)
    writeint(arg0, fasttcp\Field4)
    writeint(arg0, (fasttcp\Field4 - $01))
    Return $00
End Function
