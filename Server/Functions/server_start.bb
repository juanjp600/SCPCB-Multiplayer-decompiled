Function server_start%()
    If (getscripts() <> 0) Then
        public_inqueue($01, $01)
        public_inqueue($02, $01)
        If (se_getreturnvalue() <> "-1") Then
            server\Field7 = se_getreturnvalue()
        EndIf
        nullmap($01)
        initnewgame()
        public_inqueue($03, $00)
        public_addparam($00, server\Field1, $01)
        callback($00)
    Else
        nullmap($01)
        initnewgame()
    EndIf
    addlog("Server successfully started.", $00, $01, $00)
    requestdatafromglobal()
    server\Field0 = reloadudpstream(server\Field0)
    setudpstreambuffersize(server\Field0, (server\Field87 Shl $0D))
    Repeat
        udpreceive()
        updatemap($00)
        updateserver()
        fpse = (fpse + $01)
        If (shouldrestartserver <> 0) Then
            restartserver("")
            shouldrestartserver = $00
        EndIf
    Forever
    Return $00
End Function
