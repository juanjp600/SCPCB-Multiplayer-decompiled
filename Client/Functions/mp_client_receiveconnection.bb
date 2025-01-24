Function mp_client_receiveconnection%()
    ue_server\Field11 = mp_readbyte()
    mp_client_recvplayersglobaldata()
    Return $00
End Function
