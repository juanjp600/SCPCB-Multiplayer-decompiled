Function udpreceive%()
    Local local0%
    Local local1%
    While (recvudpmsg(server\Field0) <> 0)
        If (readavail(server\Field0) <= $200) Then
            local0 = udpmsgip(server\Field0)
            local1 = udpmsgport(server\Field0)
            acceptpacket(readbyte(server\Field0), local0, local1)
        EndIf
    Wend
    Return $00
End Function
