Function receivenetworkpackets%()
    Local local0%
    local0 = recvudpmsg(network\Field4)
    If (((local0 <> $00) And receivetonetworkbuffer(network\Field4, network\Field2)) <> 0) Then
        network\Field0\Field0 = local0
        network\Field0\Field1 = udpmsgport(network\Field4)
        network\Field8 = (network\Field8 + network\Field2\Field2)
        Return $01
    EndIf
    Return $00
    Return $00
End Function
