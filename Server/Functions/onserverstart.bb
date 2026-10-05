Function onserverstart%()
    Local local0%
    Local local1%
    Local local2.scriptsthread
    cls()
    local0 = readfile("server.cfg")
    While (eof(local0) = $00)
        cfg_findcmd(trim(readline(local0)))
    Wend
    console_init(("SCP CB Dedicated Server | " + server\Field5))
    console_setinputenabled($00)
    closefile(local0)
    local0 = readfile("ServerConfig\advanceddescription.txt")
    While (eof(local0) = $00)
        If (local1 >= $14) Then
            Exit
        EndIf
        server\Field60[local1] = readline(local0)
        local1 = (local1 + $01)
    Wend
    closefile(local0)
    initvariables()
    Repeat
        If (isvalidip(server\Field78) = $00) Then
            addlog((("The server could not bind to IP " + server\Field78) + "."), $00, $01, $00, $C0, $C0, $C0)
            delay($BB8)
        Else
            Exit
        EndIf
    Forever
    Repeat
        server\Field0 = createudpstream(server\Field78, (Int server\Field1))
        If (server\Field0 = $00) Then
            addlog((("The server could not bind to port " + server\Field1) + "."), $00, $01, $00, $C0, $C0, $C0)
            delay($BB8)
        Else
            Exit
        EndIf
    Forever
    setudpstreambuffersize(server\Field0, (server\Field85 Shl $0D))
    addlog(((((("Server started on " + server\Field78) + ":") + (Str udpstreamport(server\Field0))) + " with tickrate ") + (Str server\Field3)), $00, $01, $00, $C0, $C0, $C0)
    addlog(("Server version: v" + mp_version), $00, $01, $00, $C0, $C0, $C0)
    addlog("----------------------------", $00, $01, $00, $C0, $C0, $C0)
    addlog(("Max players: " + (Str server\Field18)), $00, $01, $00, $C0, $C0, $C0)
    addlog(("Map seed: " + server\Field7), $00, $01, $00, $C0, $C0, $C0)
    addlog(("Steam Authentication: " + bool(server\Field87\Field7)), $00, $01, $00, $C0, $C0, $C0)
    addlog("Configuration loaded successfully.", $00, $01, $00, $C0, $C0, $C0)
    If (server\Field87\Field7 <> 0) Then
        connecttosteam()
    EndIf
    addlog("----------Scripts----------", $00, $01, $00, $C0, $C0, $C0)
    For local2 = Each scriptsthread
        If (((local2\Field0 = Null) And (local2\Field3 = $00)) <> 0) Then
            If (local2\Field2 = "") Then
                addlog((("Script " + local2\Field1) + " load failed"), $00, $01, $00, $FF, $00, $00)
            Else
                If (instr(local2\Field2, chr($0D), $01) <> 0) Then
                    local2\Field2 = left(local2\Field2, (instr(local2\Field2, chr($0D), $01) - $01))
                EndIf
                addlog((((("Script " + local2\Field1) + " load failed [") + local2\Field2) + "]"), $00, $01, $00, $FF, $00, $00)
            EndIf
            Delete local2
        Else
            addlog((("Script " + local2\Field1) + " loaded successfully"), $00, $01, $00, $00, $FF, $00)
            If (local2\Field3 = $00) Then
                se_script_access_invoke = (local2\Field0\Field9 = "NULL")
                callbacksingle(local2, $04)
                se_script_access_invoke = $01
            EndIf
            callbacksingle(local2, $41)
        EndIf
    Next
    addlog("----------Banlist----------", $00, $01, $00, $C0, $C0, $C0)
    getglobalbanlists()
    banlist_updateversion("banlist", "player_cache\local\ipbanlist.dat")
    banlist_updateversion("banliststeam", "player_cache\local\steambanlist.dat")
    rcon_loadbanlist("player_cache\local\ipbanlist.dat")
    rcon_loadsteambanlist("player_cache\local\steambanlist.dat")
    addlog("--------------------", $00, $01, $00, $C0, $C0, $C0)
    Delete Each chatmessage
    Return $00
End Function
