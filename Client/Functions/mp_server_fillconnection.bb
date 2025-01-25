Function mp_server_fillconnection%()
    mp_writebyte(ue_server\Field11)
    mp_server_fillplayersglobaldata()
    Return $00
End Function
