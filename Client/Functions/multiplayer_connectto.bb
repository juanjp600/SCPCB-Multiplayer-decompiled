Function multiplayer_connectto%(arg0$, arg1%, arg2$, arg3%, arg4%)
    Local local0.blacklistedservers
    Local local1.servers
    For local0 = Each blacklistedservers
        If (local0\Field0 = arg0) Then
            adderrorlog("This server is blacklisted", $FF, $00, $00, $1388)
            Return $00
        EndIf
    Next
    If (arg3 = $00) Then
        For local1 = Each servers
            If (local1\Field15 <> 0) Then
                multiplayer_list_deleteserver(local1)
            EndIf
        Next
        local1 = multiplayer_list_addserver(arg0, arg1, $00, $01, $00)
        local1\Field15 = $01
    EndIf
    mousehit1 = $00
    adderrorlog("Joining...", $FF, $FF, $FF, $1388)
    If (arg3 = $00) Then
        If (counthostips(arg0) = $00) Then
            adderrorlog("Failed to establish connection", $FF, $00, $00, $1388)
            Return $00
        EndIf
        arg1 = (Int max(min(65535.0, (Float arg1)), 80.0))
        udp_setstream(udp_network, $00, $00, $00, $00)
        udp_setstream(udp_network, createudpstream($00), hostip($01), arg1, $01)
    Else
        udp_setstream(udp_network, $00, $00, $00, $00)
        udp_setstream(udp_network, createudpstream($00), (Int arg0), $00, $01)
        debuglog(("Set stream: " + (Str (Int arg0))))
        networkserver\Field49 = $01
    EndIf
    If (udp_getconnection() = $00) Then
        adderrorlog("Couldn't connect", $FF, $00, $00, $1388)
        mainmenutab = $01
        Return $00
    Else
        nickname = left(nickname, $18)
        multiplayer_setservertime((millisecs() + arg4))
        If (arg3 = $00) Then
            requeststeamticket()
            networkserver\Field6 = (millisecs() + $5DC)
            networkserver\Field7 = $00
        Else
            udp_writebyte($1A)
            udp_writebyte($00)
            udp_writeline(nickname)
            udp_writeline(multiplayer_version)
            udp_writeline(arg2)
            udp_writebyte($02)
            udp_writeshort(graphicwidth)
            udp_writeshort(graphicheight)
            udp_writebyte($00)
            udp_writeint(currentsteamid)
            udp_sendmessage($00)
            networkserver\Field6 = $00
            networkserver\Field7 = $00
        EndIf
    EndIf
    Return $00
    Return $00
End Function
