Function mp_sendtoserver%()
    mp_preparesendbuffer(network\Field1)
    sendudpmsg(network\Field4, network\Field5, network\Field6)
    mp_flushbuffer(network\Field1)
    Return $00
End Function
