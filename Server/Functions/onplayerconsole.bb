Function onplayerconsole%(arg0%, arg1$, arg2%)
    Local local0$
    Local local1.players
    Local local2%
    Local local4%
    Local local5.items
    Local local6%
    Local local7.events
    Local local8$
    Local local9$
    Local local12%
    Local local13.itemtemplates
    Local local14$
    Local local16.rooms
    Local local17.players
    If (instr(arg1, " ", $01) > $00) Then
        local0 = lower(left(arg1, (instr(arg1, " ", $01) - $01)))
    Else
        local0 = lower(arg1)
    EndIf
    local1 = player[arg0]
    local2 = arg0
    If (((isplayeradmin(arg0) Or (server\Field2 = $00)) Or arg2) <> 0) Then
        Select lower(local0)
            Case "scp-420-j","420","weed"
                For local4 = $01 To $14 Step $01
                    If (rand($02, $01) = $01) Then
                        local5 = createitem("Some SCP-420-J", "420", ((cos((18.0 * (Float local4))) * rnd(0.3, 0.5)) + entityx(local1\Field62, $01)), entityy(getcamera(arg0), $01), ((sin((18.0 * (Float local4))) * rnd(0.3, 0.5)) + entityz(local1\Field62, $01)), $00, $00, $00, 1.0, $00, $01)
                    Else
                        local5 = createitem("Joint", "420s", ((cos((18.0 * (Float local4))) * rnd(0.3, 0.5)) + entityx(local1\Field62, $01)), entityy(getcamera(arg0), $01), ((sin((18.0 * (Float local4))) * rnd(0.3, 0.5)) + entityz(local1\Field62, $01)), $00, $00, $00, 1.0, $00, $01)
                    EndIf
                    entitytype(local5\Field1, $03, $00)
                Next
            Case "unlockexits"
                If (getscripts() <> 0) Then
                    local6 = public_inqueue($3F, $00)
                    public_addparam(local6, (Str arg0), $01)
                    callback($00)
                EndIf
                For local7 = Each events
                    If (local7\Field0 = "gateaentrance") Then
                        local7\Field4 = 1.0
                        local7\Field1\Field29[$01]\Field5 = $01
                        local7\Field1\Field29[$01]\Field4 = $00
                    ElseIf (local7\Field0 = "exit1") Then
                        local7\Field4 = 1.0
                        local7\Field1\Field29[$04]\Field5 = $01
                        local7\Field1\Field29[$04]\Field4 = $00
                    EndIf
                Next
                remotedooron = $01
            Case "spawn"
                local8 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                local0 = piece(local8, $01, " ")
                local9 = piece(local8, $02, " ")
                If (local0 <> local9) Then
                    console_spawnnpc(player[arg0]\Field62, local0, local9)
                Else
                    console_spawnnpc(player[arg0]\Field62, local0, "")
                EndIf
            Case "stfu","stopsound"
                If (curr173 <> Null) Then
                    For local7 = Each events
                        If (local7\Field0 = "alarm") Then
                            If (local7\Field1\Field30[$00] <> Null) Then
                                removenpc(local7\Field1\Field30[$00], $00)
                            EndIf
                            If (local7\Field1\Field30[$01] <> Null) Then
                                removenpc(local7\Field1\Field30[$01], $00)
                            EndIf
                            If (local7\Field1\Field30[$02] <> Null) Then
                                removenpc(local7\Field1\Field30[$02], $00)
                            EndIf
                            positionentity(curr173\Field4, 0.0, 0.0, 0.0, $00)
                            resetentity(curr173\Field4)
                            showentity(curr173\Field0)
                            removeevent(local7)
                            Exit
                        EndIf
                    Next
                    For local4 = $01 To server\Field18 Step $01
                        If (player[local4] <> Null) Then
                            udp_writebyte($2A)
                            udp_writebyte(arg0)
                            udp_sendmessage(local4)
                        EndIf
                    Next
                EndIf
            Case "notarget"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                Select local0
                    Case "on","1","true"
                        notarget = $01
                    Case "off","0","false"
                        notarget = $00
                    Default
                        notarget = (notarget = $00)
                End Select
                If (getscripts() <> 0) Then
                    public_inqueue($40, $00)
                    public_addparam($00, (Str arg0), $01)
                    callback($00)
                EndIf
            Case "noclip","fly"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                Select local0
                    Case "on","1","true"
                        local1\Field94 = $01
                    Case "off","0","false"
                        local1\Field94 = $00
                    Default
                        local1\Field94 = (local1\Field94 = $00)
                End Select
                player[arg0]\Field86 = 0.0
            Case "noclipspeed"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                local1\Field95 = (Float local0)
            Case "revive","undead","resurrect"
                player[local2]\Field59 = $00
            Case "spawnitem"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                local12 = $00
                For local13 = Each itemtemplates
                    If (lower(local13\Field1) = local0) Then
                        local12 = $01
                        Exit
                    ElseIf (lower(local13\Field2) = local0) Then
                        local12 = $01
                        Exit
                    EndIf
                Next
                If (local12 = $01) Then
                    local5 = createitem(local13\Field1, local13\Field2, entityx(player[local2]\Field62, $00), (entityy(getcamera(local2), $01) - 0.1), entityz(player[local2]\Field62, $00), $00, $00, $00, 1.0, $00, $01)
                    entitytype(local5\Field1, $03, $00)
                EndIf
            Case "role"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If ((((Int local0) >= $00) And ((Int local0) <= (last_breach_type - $01))) <> 0) Then
                    setplayertype(local2, (Int local0))
                EndIf
            Case "tele"
                local8 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                local0 = piece(local8, $01, " ")
                local9 = piece(local8, $02, " ")
                local14 = piece(local8, $03, " ")
                positionentity(local1\Field62, (Float local0), (Float local9), (Float local14), $00)
                resetentity(local1\Field62)
                setplayerposition(local1\Field30, room[local1\Field32]\Field7\Field10, entityx(local1\Field62, $00), entityy(local1\Field62, $00), entityz(local1\Field62, $00))
            Case "tfd"
                If (local1\Field67 = "dimension1499") Then
                    positionentity(local1\Field62, local1\Field133, local1\Field134, local1\Field135, $00)
                    resetentity(local1\Field62)
                    mp_setplayerroomid(local1, local1\Field136)
                    mp_updateplayerposition(local1, $01)
                    setplayerposition(local1\Field30, room[local1\Field32]\Field7\Field10, entityx(local1\Field62, $00), entityy(local1\Field62, $00), entityz(local1\Field62, $00))
                    local1\Field133 = 0.0
                    local1\Field134 = 0.0
                    local1\Field135 = 0.0
                    local1\Field136 = Null
                EndIf
            Case "teleport"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If (local0 = "dimension1499") Then
                    For local5 = Each items
                        If (local5\Field22 = arg0) Then
                            If (local5\Field3\Field1 = "SCP-1499") Then
                                For local7 = Each events
                                    If (local7\Field22 = $3E) Then
                                        If (room[local1\Field32]\Field7\Field10 <> "dimension1499") Then
                                            local1\Field133 = entityx(local1\Field62, $00)
                                            local1\Field134 = entityy(local1\Field62, $00)
                                            local1\Field135 = entityz(local1\Field62, $00)
                                            local1\Field136 = room[local1\Field32]
                                        EndIf
                                        positionentity(local1\Field62, entityx(local7\Field1\Field2, $00), (entityy(local7\Field1\Field2, $00) + 1.0), entityz(local7\Field1\Field2, $00), $00)
                                        resetentity(local1\Field62)
                                        mp_setplayerroomid(local1, local7\Field1)
                                        mp_updateplayerposition(local1, $01)
                                        setplayerposition(local1\Field30, room[local1\Field32]\Field7\Field10, entityx(local1\Field62, $00), entityy(local1\Field62, $00), entityz(local1\Field62, $00))
                                        local1\Field131 = $00
                                        Return $00
                                    EndIf
                                Next
                                Exit
                            EndIf
                        EndIf
                    Next
                EndIf
                Select local0
                    Case "895","scp-895"
                        local0 = "coffin"
                    Case "scp-914"
                        local0 = "914"
                    Case "offices","office"
                        local0 = "room2offices"
                End Select
                For local16 = Each rooms
                    If (local16\Field7\Field10 = local0) Then
                        positionentity(local1\Field62, entityx(local16\Field2, $00), (entityy(local16\Field2, $00) + 1.0), entityz(local16\Field2, $00), $00)
                        resetentity(local1\Field62)
                        mp_setplayerroomid(local1, local16)
                        mp_updateplayerposition(local1, $01)
                        setplayerpositionex(local1\Field30, local16\Field69, entityx(local1\Field62, $00), entityy(local1\Field62, $00), entityz(local1\Field62, $00))
                        local0 = ""
                        local1\Field131 = $00
                        Exit
                    EndIf
                Next
                For local17 = Each players
                    If (local17\Field15 <> "") Then
                        If (lower(local17\Field15) = lower(local0)) Then
                            positionentity(local1\Field62, entityx(local17\Field62, $00), (entityy(local17\Field62, $00) + 0.1), entityz(local17\Field62, $00), $00)
                            resetentity(local1\Field62)
                            For local16 = Each rooms
                                If (local16\Field7\Field10 = local17\Field67) Then
                                    mp_setplayerroomid(local1, local16)
                                    mp_updateplayerposition(local1, $01)
                                    Exit
                                EndIf
                            Next
                            local1\Field131 = $00
                            local0 = ""
                            setplayerpositionex(local1\Field30, local1\Field32, entityx(local1\Field62, $00), entityy(local1\Field62, $00), entityz(local1\Field62, $00))
                            Exit
                        EndIf
                    EndIf
                Next
            Case "godmode","god"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                Select local0
                    Case "on","1","true"
                        local1\Field101 = $01
                    Case "off","0","false"
                        local1\Field101 = $00
                    Default
                        local1\Field101 = (local1\Field101 = $00)
                End Select
            Case "heal"
                local1\Field61 = 0.0
                local1\Field60 = (Float local1\Field96)
            Case "ban"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If (isplayeradmin(arg0) <> 0) Then
                    If (isvalidplayer((Int local0)) <> 0) Then
                        If (player[(Int local0)] <> Null) Then
                            rcon_banip("banlist", player[(Int local0)]\Field40)
                        EndIf
                    EndIf
                EndIf
            Case "bansteam"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If (isplayeradmin(arg0) <> 0) Then
                    If (isvalidplayer((Int local0)) <> 0) Then
                        If (player[(Int local0)] <> Null) Then
                            rcon_bansteamid("banliststeam", player[(Int local0)]\Field129)
                        EndIf
                    EndIf
                EndIf
            Case "kick"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If (isplayeradmin(arg0) <> 0) Then
                    If (isvalidplayer((Int local0)) <> 0) Then
                        If (player[(Int local0)] <> Null) Then
                            rcon_kick(player[(Int local0)]\Field15)
                        EndIf
                    EndIf
                EndIf
            Case "tpto"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If (isplayeradmin(arg0) <> 0) Then
                    If (isvalidplayer((Int local0)) <> 0) Then
                        positionentity(local1\Field62, entityx(player[(Int local0)]\Field62, $00), (entityy(player[(Int local0)]\Field62, $00) + 0.1), entityz(player[(Int local0)]\Field62, $00), $00)
                        resetentity(local1\Field62)
                        mp_setplayerroomid(local1, room[player[(Int local0)]\Field32])
                        mp_updateplayerposition(local1, $01)
                        setplayerposition(local1\Field30, room[local1\Field32]\Field7\Field10, entityx(local1\Field62, $00), (entityy(local1\Field62, $00) + 0.1), entityz(local1\Field62, $00))
                    EndIf
                EndIf
            Case "tpme"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If (isplayeradmin(arg0) <> 0) Then
                    If (isvalidplayer((Int local0)) <> 0) Then
                        positionentity(player[(Int local0)]\Field62, entityx(local1\Field62, $00), (entityy(local1\Field62, $00) + 0.1), entityz(local1\Field62, $00), $00)
                        resetentity(player[(Int local0)]\Field62)
                        mp_setplayerroomid(player[(Int local0)], room[local1\Field32])
                        mp_updateplayerposition(player[(Int local0)], $01)
                        setplayerposition((Int local0), room[local1\Field32]\Field7\Field10, entityx(local1\Field62, $00), (entityy(local1\Field62, $00) + 0.1), entityz(local1\Field62, $00))
                    EndIf
                EndIf
            Case "mute"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If (isplayeradmin(arg0) <> 0) Then
                    If (isvalidplayer((Int local0)) <> 0) Then
                        If (player[(Int local0)] <> Null) Then
                            player[(Int local0)]\Field139 = (player[(Int local0)]\Field139 = $00)
                            If (player[(Int local0)]\Field139 <> 0) Then
                                addtexttochat(("[RCON] You muted the " + player[(Int local0)]\Field15), local1\Field30)
                                addtexttochat("You get muted.", player[(Int local0)]\Field30)
                            Else
                                addtexttochat(("[RCON] You unmuted the " + player[(Int local0)]\Field15), local1\Field30)
                                addtexttochat("You get unmute.", player[(Int local0)]\Field30)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "giverole"
                If (isplayeradmin(arg0) <> 0) Then
                    local8 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                    local0 = piece(local8, $01, " ")
                    local9 = piece(local8, $02, " ")
                    If (isvalidplayer((Int local0)) <> 0) Then
                        If ((((Int local9) >= $00) And ((Int local9) <= (last_breach_type - $01))) <> 0) Then
                            setplayertype((Int local0), (Int local9))
                            addtexttochat(((("[RCON] You successfully give " + mp_breach_getname((Int local9))) + " to: ") + player[(Int local0)]\Field15), local1\Field30)
                        EndIf
                    EndIf
                EndIf
            Case "giveitem"
                If (isplayeradmin(arg0) <> 0) Then
                    local8 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                    local0 = piece(local8, $01, " ")
                    local9 = piece(local8, $02, " ")
                    If (isvalidplayer((Int local0)) <> 0) Then
                        If (player[(Int local0)] <> Null) Then
                            For local13 = Each itemtemplates
                                If (((lower(local13\Field1) = lower(local9)) Or (lower(local13\Field2) = lower(local9))) <> 0) Then
                                    giveitem(local13\Field1, local13\Field2, (Int local0))
                                    addtexttochat(((("[RCON] You successfully give " + local9) + " to: ") + player[(Int local0)]\Field15), local1\Field30)
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                EndIf
            Case "startmatch"
                If (isplayeradmin(arg0) <> 0) Then
                    If (breach_isstarted() = $00) Then
                        shouldstartround = $01
                        addtexttochat("[RCON] The match successfully started", local1\Field30)
                    Else
                        addtexttochat("[RCON] The match already started", local1\Field30)
                    EndIf
                EndIf
            Case "restart"
                If (isplayeradmin(arg0) <> 0) Then
                    shouldrestartserver = $01
                EndIf
            Case "spawnchaos"
                If (isplayeradmin(arg0) <> 0) Then
                    If (breach_isstarted() <> 0) Then
                        If (1.0 <= gameinfo\Field5\Field10) Then
                            gameinfo\Field5\Field8 = $01
                            spawnmtf()
                            addtexttochat("[RCON] Chaos successfully spawned!", local1\Field30)
                        Else
                            addtexttochat("[RCON] Chaos doesn't have tickets!", local1\Field30)
                        EndIf
                    EndIf
                EndIf
            Case "spawnmtf"
                If (isplayeradmin(arg0) <> 0) Then
                    If (breach_isstarted() <> 0) Then
                        If (1.0 <= gameinfo\Field5\Field9) Then
                            gameinfo\Field5\Field8 = $00
                            spawnmtf()
                            addtexttochat("[RCON] MTF successfully spawned!", local1\Field30)
                        Else
                            addtexttochat("[RCON] MTF doesn't have tickets!", local1\Field30)
                        EndIf
                    EndIf
                EndIf
            Case "lob"
                If (isplayeradmin(arg0) <> 0) Then
                    If (breach_isstarted() = $00) Then
                        local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                        gameinfo\Field5\Field2 = (millisecs() + ((Int local0) * $EA60))
                        gameinfo\Field5\Field1 = ((millisecs() + server\Field22) + ((Int local0) * $EA60))
                        gameinfo\Field5\Field4 = (millisecs() + ((Int local0) * $EA60))
                    EndIf
                EndIf
            Case "shouldannounc"
                If (isplayeradmin(arg0) <> 0) Then
                    If (breach_isstarted() <> 0) Then
                        player[arg0]\Field162 = (player[arg0]\Field162 = $00)
                        If (player[arg0]\Field162 <> 0) Then
                            playsoundforplayer(arg0, "GFX\multiplayer\game\sounds\Announcement.ogg")
                        Else
                            playsoundforplayer(arg0, "GFX\multiplayer\game\sounds\Announcement2.ogg")
                        EndIf
                    EndIf
                EndIf
            Case "cancelwarheads"
                If (isplayeradmin(arg0) <> 0) Then
                    If (breach_isstarted() <> 0) Then
                        deactivatewarheads($00)
                    EndIf
                EndIf
            Case "activatewarheads"
                If (isplayeradmin(arg0) <> 0) Then
                    If (breach_isstarted() <> 0) Then
                        activatewarheads("Warheads", $00, $00)
                        gameinfo\Field5\Field7 = (millisecs() + $4E20)
                        addtexttochat("[RCON] Warheads successfully activated!", local1\Field30)
                    EndIf
                EndIf
            Case "forcewarheads"
                If (isplayeradmin(arg0) <> 0) Then
                    If (breach_isstarted() <> 0) Then
                        If (getscripts() <> 0) Then
                            public_inqueue($2F, $00)
                            callback($00)
                        EndIf
                        playerzone = $00
                        For local4 = $01 To server\Field18 Step $01
                            If (player[local4] <> Null) Then
                                playerzone = getplayerzone(local4)
                                If ((((playerzone > $00) And (playerzone < $04)) And (((player[local4]\Field67 = "exit1") And ((1040.0 * roomscale) < entityy(player[local4]\Field62, $00))) = $00)) <> 0) Then
                                    udp_writebyte($07)
                                    udp_writebyte($01)
                                    udp_writeint($01)
                                    udp_sendmessage(local4)
                                EndIf
                            EndIf
                        Next
                        gameinfo\Field5\Field6 = $02
                        gameinfo\Field5\Field1 = (millisecs() + $1388)
                    EndIf
                EndIf
            Case "setmtftickets"
                If (isplayeradmin(arg0) <> 0) Then
                    local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                    gameinfo\Field5\Field9 = (Float local0)
                    addtexttochat((("[RCON] " + (Str gameinfo\Field5\Field9)) + " tickets set to MTF"), local1\Field30)
                EndIf
            Case "setchaostickets"
                If (isplayeradmin(arg0) <> 0) Then
                    local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                    gameinfo\Field5\Field10 = (Float local0)
                    addtexttochat((("[RCON] " + (Str gameinfo\Field5\Field10)) + " tickets set to Chaos"), local1\Field30)
                EndIf
            Case "sanic"
                local1\Field173 = 6.0
        End Select
    Else
        Select lower(local0)
            Case "tfd"
                If (local1\Field67 = "dimension1499") Then
                    positionentity(local1\Field62, local1\Field133, local1\Field134, local1\Field135, $00)
                    resetentity(local1\Field62)
                    mp_setplayerroomid(local1, local1\Field136)
                    mp_updateplayerposition(local1, $01)
                    setplayerposition(local1\Field30, room[local1\Field32]\Field7\Field10, entityx(local1\Field62, $00), entityy(local1\Field62, $00), entityz(local1\Field62, $00))
                    local1\Field133 = 0.0
                    local1\Field134 = 0.0
                    local1\Field135 = 0.0
                    local1\Field136 = Null
                    Return $00
                EndIf
            Case "teleport"
                local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
                If (local0 = "dimension1499") Then
                    For local5 = Each items
                        If (local5\Field22 = arg0) Then
                            If (local5\Field3\Field1 = "SCP-1499") Then
                                For local7 = Each events
                                    If (local7\Field22 = $3E) Then
                                        If (room[local1\Field32]\Field7\Field10 <> "dimension1499") Then
                                            local1\Field133 = entityx(local1\Field62, $00)
                                            local1\Field134 = entityy(local1\Field62, $00)
                                            local1\Field135 = entityz(local1\Field62, $00)
                                            local1\Field136 = room[local1\Field32]
                                        EndIf
                                        positionentity(local1\Field62, entityx(local7\Field1\Field2, $00), (entityy(local7\Field1\Field2, $00) + 0.7), entityz(local7\Field1\Field2, $00), $00)
                                        resetentity(local1\Field62)
                                        mp_setplayerroomid(local1, local7\Field1)
                                        mp_updateplayerposition(local1, $01)
                                        local1\Field131 = $00
                                        setplayerposition(local1\Field30, room[local1\Field32]\Field7\Field10, entityx(local1\Field62, $00), entityy(local1\Field62, $00), entityz(local1\Field62, $00))
                                        Return $00
                                    EndIf
                                Next
                                Return $00
                            EndIf
                        EndIf
                    Next
                EndIf
        End Select
        oncheatdetected(arg0, $04)
    EndIf
    Return $00
End Function
