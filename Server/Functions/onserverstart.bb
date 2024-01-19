Function onserverstart%()
    Local local0%
    Local local1%
    Local local2.scriptsthread
    cls()
    local0 = readfile("server.cfg")
    While (eof(local0) = $00)
        cfg_findcmd(trim(readline(local0)))
    Wend
    closefile(local0)
    local0 = readfile("ServerConfig\advanceddescription.txt")
    While (eof(local0) = $00)
        If (local1 >= $14) Then
            Exit
        EndIf
        server\Field61[local1] = readline(local0)
        local1 = (local1 + $01)
    Wend
    closefile(local0)
    initvariables()
    createconsole(("SCP CB Dedicated Server | " + getformattedtext(server\Field5)))
    server\Field0 = createudpstream((Int server\Field1))
    If (server\Field0 = $00) Then
        consolelog("Server failed to start. Trying to create a server ...", $07)
        Repeat
            server\Field0 = createudpstream((Int server\Field1))
            If (server\Field0 = $00) Then
                consolelog("Trying to create a server... Please check if the server is already running or if the port is busy, or binded ip does not exist", $07)
                delay($BB8)
            Else
                Exit
            EndIf
        Forever
    EndIf
    setudpstreambuffersize(server\Field0, (server\Field87 Shl $0D))
    addlog(((("Server started on port " + (Str udpstreamport(server\Field0))) + " with tickrate ") + (Str server\Field3)), $00, $01, $00)
    addlog(("Server version: v" + mp_version), $00, $01, $00)
    If (server\Field80 <> "") Then
        addlog(("Server successfully binded on " + server\Field80), $00, $01, $00)
    EndIf
    addlog("-----------------", $00, $01, $00)
    addlog(("Max players: " + (Str server\Field18)), $00, $01, $00)
    addlog(("Map seed: " + server\Field7), $00, $01, $00)
    addlog((("Map size: " + (Str (server\Field52 + $01))) + " chunks"), $00, $01, $00)
    addlog(("Hostname: " + getformattedtext(server\Field5)), $00, $01, $00)
    If (server\Field14 <> "") Then
        addlog(("Password: " + server\Field14), $00, $01, $00)
    EndIf
    If (server\Field21 = $00) Then
        addlog(("Difficulty: " + server\Field26), $00, $01, $00)
    EndIf
    addlog(("Time out time (ms): " + (Str server\Field13)), $00, $01, $00)
    addlog(("Intro enabled: " + bool(server\Field8)), $00, $01, $00)
    addlog(("Voice chat: " + bool(server\Field10)), $00, $01, $00)
    If (server\Field10 <> 0) Then
        addlog((("Voice quality: " + (Str server\Field32)) + " hz"), $00, $01, $00)
    EndIf
    addlog(("No cheat mode: " + bool(server\Field2)), $00, $01, $00)
    addlog(("Jump mode: " + bool(server\Field19)), $00, $01, $00)
    addlog(("Keep inventory: " + bool(server\Field31)), $00, $01, $00)
    If (server\Field19 = $01) Then
        addlog(("Gravity: " + (Str server\Field20)), $00, $01, $00)
    EndIf
    addlog(("Rounds limit per start: " + (Str server\Field55)), $00, $01, $00)
    addlog(("RCON Password: " + server\Field28), $00, $01, $00)
    addlog(("Breach mode: " + bool(server\Field21)), $00, $01, $00)
    If (server\Field21 = $01) Then
        addlog((("Breach time: " + converttime(server\Field22)) + " min"), $00, $01, $00)
        addlog(("Breach chat: " + bool(server\Field47)), $00, $01, $00)
        addlog(("Only deathmatch: " + bool(server\Field29)), $00, $01, $00)
    EndIf
    addlog(("Using central server: " + bool(server\Field69)), $00, $01, $00)
    addlog(("Noclip anticheat: " + bool(server\Field73)), $00, $01, $00)
    If (server\Field73 <> 0) Then
        addlog(("Speedhack rate: " + (Str server\Field74)), $00, $01, $00)
    EndIf
    addlog(("Camera shake on damage: " + bool(server\Field72)), $00, $01, $00)
    If (server\Field46 <> "") Then
        addlog(("Custom map: " + server\Field46), $00, $01, $00)
    EndIf
    For local2 = Each scriptsthread
        If (((local2\Field0 = Null) And (local2\Field3 = $00)) <> 0) Then
            If (local2\Field2 = "") Then
                addlog((("Script " + local2\Field1) + " load failed"), $00, $01, $00)
            Else
                If (instr(local2\Field2, chr($0D), $01) <> 0) Then
                    local2\Field2 = left(local2\Field2, (instr(local2\Field2, chr($0D), $01) - $01))
                EndIf
                addlog((((("Script " + local2\Field1) + " load failed [") + local2\Field2) + "]"), $00, $01, $00)
            EndIf
            Delete local2
        Else
            addlog((("Script " + local2\Field1) + " loaded successfully"), $00, $01, $00)
            If (local2\Field3 = $00) Then
                se_script_access_invoke = (local2\Field0\Field9 = "NULL")
                callbacksingle(local2, $04)
                se_script_access_invoke = $01
            EndIf
            callbacksingle(local2, $41)
        EndIf
    Next
    addlog("-----------------", $00, $01, $00)
    rcon_loadbanlist("banlist")
    rcon_loadsteambanlist("banliststeam")
    Delete Each chatmessage
    Return $00
End Function
