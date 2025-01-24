Function mp_receiveconnpacketfromserver%()
    Local local0%
    Local local1%
    Local local2%
    If (((ue_connection\Field0 <> getpacketip()) Lor (ue_connection\Field1 <> getpacketport())) <> 0) Then
        Return $00
    EndIf
    local0 = mp_readbyte()
    local1 = local0
    If (local1 = $02) Then
        local2 = mp_readbyte()
        mp_menuconnectionresult(local2)
        If (local2 <> $00) Then
            senddebuglog(("The server didn't accept your connection. Error code: " + (Str local2)))
            shutdownserver(local2)
            Return $00
        EndIf
        senddebuglog("Successfully connected!")
        setnetworkserver(ue_connection\Field0, ue_connection\Field1)
        mp_client_receiveconnection()
        mp_writebyte($02)
        mp_sendtoserver()
        ue_connection\Field0 = $00
        ue_connection\Field1 = $00
        ue_connection\Field2 = 0.0
        ue_connection\Field3 = 0.0
    EndIf
    Return $00
End Function
