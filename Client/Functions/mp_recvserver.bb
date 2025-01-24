Function mp_recvserver%()
    While (receivenetworkpackets() <> 0)
        mp_receivepacketfromclient()
    Wend
    Return $00
End Function
