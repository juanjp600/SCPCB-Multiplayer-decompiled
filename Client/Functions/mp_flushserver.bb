Function mp_flushserver%()
    mp_removevoice()
    mp_flushsoundchannels()
    mp_flushsounds()
    mp_menuflush()
    mp_flushchat()
    mp_refreshtimeout()
    mp_flushcorpses()
    mp_destructrooms()
    flushallplayers()
    closeudpstream(mp_getsocket())
    setnetworkstream($00)
    ue_server\Field3 = $00
    ue_connection\Field0 = $00
    ue_connection\Field1 = $00
    ue_connection\Field2 = 0.0
    ue_connection\Field3 = 0.0
    ue_server\Field10 = $00
    ue_server\Field0 = $00
    myplayerlogic\Field0 = $00
    mp_menuconnectionresult($00)
    Return $00
End Function
