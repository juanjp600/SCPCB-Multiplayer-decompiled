Function mp_sendtosender%()
    mp_preparesendbuffer(network\Field1)
    sendudpmsg(network\Field4, network\Field0\Field0, network\Field0\Field1)
    mp_flushbuffer(network\Field1)
    Return $00
End Function
