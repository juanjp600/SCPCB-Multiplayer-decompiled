Function mp_server_fillplayerrequesting%(arg0.mp_player)
    mp_writebyte(arg0\Field5)
    mp_writebyte(arg0\Field17)
    mp_server_pushplayermodel(arg0)
    mp_writeline(arg0\Field6)
    mp_server_pushplayertags(arg0)
    Return $00
End Function
