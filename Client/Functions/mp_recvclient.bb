Function mp_recvclient%()
    While (receivenetworkpackets() <> 0)
        mp_receivepacketfromserver()
    Wend
    Return $00
End Function
