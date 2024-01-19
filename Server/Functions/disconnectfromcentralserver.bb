Function disconnectfromcentralserver%()
    writebyte(centralserver\Field1, $05)
    writeshort(centralserver\Field1, udpstreamport(centralserver\Field1))
    sendudpmsg(centralserver\Field1, centralserver\Field7, centralserver\Field8)
    closeudpstream(centralserver\Field1)
    centralserver\Field1 = createudpstream($00)
    centralserver\Field4 = millisecs()
    Return $00
End Function
