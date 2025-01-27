Function directconnect%(arg0%, arg1%)
    initializeserver($00)
    senddebuglog(((("Connecting to server at IP: " + dottedip(arg0)) + ", Port: ") + (Str arg1)))
    ue_connection\Field0 = arg0
    ue_connection\Field1 = arg1
    mp_writebyte($01)
    mp_writeline(opt\Field46)
    mp_writeint($0A)
    mp_writeline(randomseed)
    mp_send(ue_connection\Field0, ue_connection\Field1)
    Return $01
    Return $00
End Function
