Function restartserver%(arg0$)
    Local local0.players
    Local local1%
    Local local2.rooms
    Local local3%
    Local local4.authconnection
    disconnectfromcentralserver()
    addlog("Restarting...", $00, $01, $00)
    Delete Each antiddos
    Delete gameinfo\Field5
    Delete gameinfo
    gameinfo = (New g_i)
    gameinfo\Field5 = (New breach)
    If (arg0 = "") Then
        arg0 = setrandomseed()
    EndIf
    server\Field7 = arg0
    server\Field9 = $00
    server\Field30 = $00
    server\Field45 = $00
    ticks\Field0 = $00
    For local0 = Each players
        If (local0\Field55 = $00) Then
            For local1 = $00 To $0A Step $01
                udp_writebyte($4B)
                udp_writebyte($01)
                udp_sendmessage(local0\Field30)
            Next
            kick(local0\Field30, "")
        EndIf
    Next
    server\Field56 = (server\Field56 + $01)
    If (server\Field56 >= server\Field55) Then
        addlog("The rounds have exceeded the number of allowed rounds, restart the application.", $00, $01, $00)
        If (reloadapplication() = $00) Then
            addlog("The application couldn't be restarted, because you maybe don't have server.exe in current directory", $00, $01, $00)
        EndIf
    EndIf
    public_inqueue($02, $01)
    If (se_getreturnvalue() <> "-1") Then
        server\Field7 = se_getreturnvalue()
    EndIf
    nullmap($01)
    initnewgame()
    For local0 = Each players
        If (local0\Field55 <> 0) Then
            mp_createplayerobject(local0\Field30)
            For local2 = Each rooms
                If (local2\Field7\Field10 = "173") Then
                    local0\Field32 = local2\Field69
                    mp_updateplayerposition(local0, $00)
                    mp_setroomnametoplayer(local0)
                    Exit
                EndIf
            Next
        EndIf
    Next
    If (getscripts() <> 0) Then
        local3 = public_inqueue($29, $00)
        public_addparam(local3, server\Field7, $03)
        callback((arg0 <> ""))
    EndIf
    addlog("Server successfully restarted.", $00, $01, $00)
    For local4 = Each authconnection
        removeauthconnection(local4)
    Next
    requestdatafromglobal()
    server\Field0 = reloadudpstream(server\Field0)
    setudpstreambuffersize(server\Field0, (server\Field87 Shl $0D))
    Return $00
End Function
