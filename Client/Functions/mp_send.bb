Function mp_send%(arg0%, arg1%)
    mp_preparesendbuffer(network\Field1)
    sendudpmsg(network\Field4, arg0, arg1)
    mp_flushbuffer(network\Field1)
    Return $00
End Function
