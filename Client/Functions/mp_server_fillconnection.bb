Function mp_server_fillconnection%()
    mp_writebyte($01)
    mp_server_fillplayersglobaldata()
    Return $00
End Function
