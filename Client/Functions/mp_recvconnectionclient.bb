Function mp_recvconnectionclient%()
    While (receivenetworkpackets() <> 0)
        mp_receiveconnpacketfromserver()
    Wend
    Return $00
End Function
