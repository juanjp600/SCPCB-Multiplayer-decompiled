Function ongetauthsessionticket%(arg0%, arg1%, arg2%)
    If (authsession = $00) Then
        authsession = bp_getfunctionpointer()
        Return $00
    EndIf
    debuglog((Str bs_memory_peekint(arg0, $04)))
    If (bs_memory_peekint(arg0, $04) <> $01) Then
        requeststeamticket()
    Else
        currentsessionticket = bs_memory_peekint(arg0, $00)
        resizebank(currentsessionticketdata, peekint(sessionticketsize, $00))
        If ((udp_getconnection() And (udp_getstream() = $00)) <> 0) Then
            udp_writebyte($1A)
            udp_writebyte($00)
            udp_writeline(nickname)
            udp_writeline(multiplayer_version)
            udp_writeline(password)
            udp_writebyte($02)
            udp_writeshort(graphicwidth)
            udp_writeshort(graphicheight)
            udp_writebyte($00)
            udp_writeint(currentsteamid)
            udp_writebytes(currentsessionticketdata, $00, banksize(currentsessionticketdata))
            udp_sendmessage($00)
        Else
            cancelsteamticket()
        EndIf
        networkserver\Field6 = $00
    EndIf
    Return $00
End Function
