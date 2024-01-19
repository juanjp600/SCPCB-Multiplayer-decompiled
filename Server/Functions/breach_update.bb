Function breach_update%()
    Local local0%
    Local local1.players
    Local local2.players
    Local local3%[65]
    Local local4%
    Local local5%
    Local local6%[255]
    Local local7%
    Local local8%
    Local local9%
    Local local10.breachtypes
    Local local12.events
    Local local13.rooms
    Local local14.items
    Local local15%
    Local local16%
    Local local18%
    Local local19.events
    Local local20.players
    If (server\Field21 = $01) Then
        notarget = $01
        mtftimer = 24000.0
        If (((server\Field11 < $04) And (gameinfo\Field5\Field4 > millisecs())) <> 0) Then
            gameinfo\Field5\Field1 = ((millisecs() + server\Field22) + $15F90)
            gameinfo\Field5\Field4 = (millisecs() + $15F90)
            gameinfo\Field5\Field2 = (millisecs() + $15F90)
        EndIf
        If (server\Field48 < millisecs()) Then
            If (istimedout($05, $0A) <> 0) Then
                For local1 = Each players
                    If (local1\Field36 = model_173) Then
                        For local2 = Each players
                            If ((((mp_isafriend(local1\Field36, local2\Field36) = $00) And (15.0 > entitydistance(local1\Field62, local2\Field62))) And (local2\Field36 <> $00)) <> 0) Then
                                mp_sendblinktimer(local2\Field30, -6.0)
                            EndIf
                        Next
                    EndIf
                Next
            EndIf
            If ((server\Field48 > (millisecs() - server\Field83)) = $00) Then
                server\Field48 = (millisecs() + server\Field84)
            EndIf
        EndIf
        If (server\Field45 = $00) Then
            If ((shouldstartround Or (server\Field11 >= server\Field53)) <> 0) Then
                If (server\Field11 >= $04) Then
                    gameinfo\Field5\Field1 = (millisecs() + server\Field22)
                    gameinfo\Field5\Field4 = (millisecs() - $01)
                    gameinfo\Field5\Field2 = (millisecs() - $01)
                EndIf
                shouldstartround = $00
            EndIf
        EndIf
        If (breach_isstarted() <> 0) Then
            If (server\Field45 = $00) Then
                gameinfo\Field5\Field1 = (millisecs() + server\Field22)
                gameinfo\Field5\Field4 = (millisecs() - $01)
                gameinfo\Field5\Field2 = (millisecs() - $01)
                gameinfo\Field5\Field7 = (millisecs() + (server\Field22 Sar $01))
                local0 = $01
                local4 = server\Field11
                For local5 = $01 To server\Field11 Step $01
                    local3[(local5 - $01)] = playeroptimize[local5]\Field30
                Next
                shuffleplayersarray(local3, server\Field11)
                For local5 = $00 To (local4 - $01) Step $01
                    If (server\Field30 <> 0) Then
                        setplayertype(local3[local5], randombetween(guard_model, haos_model))
                    Else
                        breach_countroles()
                        local7 = $00
                        local8 = $00
                        local9 = $00
                        For local10 = Each breachtypes
                            If (local10\Field59 <> 0) Then
                                local9 = (local10\Field58 > breach_getrolecount(local10\Field1))
                                If (local9 <> 0) Then
                                    local8 = breach_getcategorybytype(local10\Field1, $00)
                                    Select local8
                                        Case $05
                                            If ((((breach_getcategorycount(local8) > (server\Field11 Sar $02)) Or (min((Float (server\Field11 / $05)), 6.0) < (Float breach_getcategorycount(local10\Field1)))) Or ((local10\Field1 = model_860) And (room860event = Null))) <> 0) Then
                                                local9 = $00
                                            EndIf
                                        Case $07
                                            If (breach_getcategorycount(local8) > (server\Field11 Sar $01)) Then
                                                local9 = $00
                                            EndIf
                                    End Select
                                    If (local9 <> 0) Then
                                        local6[local7] = local10\Field1
                                        local7 = (local7 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If (local7 > $00) Then
                            setplayertype(local3[local5], local6[rand($00, (local7 - $01))])
                        Else
                            setplayertype(local3[local5], classd_model)
                        EndIf
                    EndIf
                Next
                local0 = $00
                server\Field45 = $01
                For local12 = Each events
                    If (local12\Field0 = "gateaentrance") Then
                        local12\Field4 = 1.0
                        local12\Field1\Field29[$01]\Field5 = $00
                        local12\Field1\Field29[$01]\Field4 = $00
                    ElseIf (local12\Field0 = "exit1") Then
                        local12\Field4 = 1.0
                        local12\Field1\Field29[$04]\Field5 = $00
                        local12\Field1\Field29[$04]\Field4 = $00
                    EndIf
                Next
                For local12 = Each events
                    If (local12\Field0 = "checkpoint") Then
                        local12\Field1\Field29[$01]\Field5 = $00
                        local12\Field1\Field29[$00]\Field5 = $00
                    EndIf
                Next
                remotedooron = $01
                For local13 = Each rooms
                    If (local13\Field7\Field10 = "exit1") Then
                        local13\Field29[$03]\Field5 = $01
                        Exit
                    EndIf
                Next
                For local14 = Each items
                    If (local14\Field22 <> $00) Then
                        removeitem(local14, $01)
                    EndIf
                Next
                gameinfo\Field5\Field5 = (millisecs() + rand($493E0, $61A80))
                createevent("alarm", "start", $00, 0.0)
                If (getscripts() <> 0) Then
                    public_inqueue($2A, $00)
                    callback($00)
                EndIf
                breach_givetickets($00, 24.0)
                breach_givetickets($01, 18.0)
                For local13 = Each rooms
                    If (local13\Field7\Field10 = "start") Then
                        local13\Field29[$02]\Field5 = $01
                        While (180.0 > local13\Field29[$01]\Field7)
                            local13\Field29[$01]\Field7 = min(180.0, (local13\Field29[$01]\Field7 + 0.8))
                            moveentity(local13\Field29[$01]\Field0, (sin(local13\Field29[$01]\Field7) / 180.0), 0.0, 0.0)
                            moveentity(local13\Field29[$01]\Field1, ((- sin(local13\Field29[$01]\Field7)) / 180.0), 0.0, 0.0)
                        Wend
                        Exit
                    EndIf
                Next
            EndIf
            For local5 = $01 To server\Field11 Step $01
                If (playeroptimize[local5]\Field36 = $00) Then
                    local15 = (local15 + $01)
                EndIf
                If (playeroptimize[local5]\Field36 <> $00) Then
                    local16 = (local16 + $01)
                EndIf
            Next
            If ((server\Field30 And (gameinfo\Field5\Field6 = $00)) <> 0) Then
                For local1 = Each players
                    If ((readbool(local1\Field38, $04) Or (local1\Field36 = $00)) <> 0) Then
                        setplayertype(local1\Field30, randombetween(haos_model, guard_model))
                    EndIf
                Next
            EndIf
            For local12 = Each events
                Select local12\Field22
                    Case $36
                        For local1 = Each players
                            If (local1\Field36 <> $00) Then
                                If (1.0 > (Abs ((local1\Field1 + 0.32) - entityy(local12\Field1\Field25[$0B], $01)))) Then
                                    If (((((((10.0 > distance(local1\Field0, local1\Field2, entityx(local12\Field1\Field25[$0B], $01), entityz(local12\Field1\Field25[$0B], $01))) And (local1\Field36 <> ntf_model)) And (local1\Field36 <> guard_model)) And (local1\Field36 <> haos_model)) And (mp_isascp(local1\Field36) = $00)) And (multiplayer_breach_isa035(local1\Field36) = $00)) <> 0) Then
                                        local18 = $00
                                        If (local1\Field36 = classd_model) Then
                                            breach_givetickets($01, 1.0)
                                            local18 = $01
                                            gameinfo\Field5\Field14 = (gameinfo\Field5\Field14 + $01)
                                        EndIf
                                        If ((((((local1\Field36 = scientist_model) Or (local1\Field36 = model_clerk)) Or (local1\Field36 = janitor_model)) Or (local1\Field36 = worker_model)) And local1\Field138) <> 0) Then
                                            breach_givetickets($01, 2.0)
                                            local18 = $01
                                            gameinfo\Field5\Field12 = (gameinfo\Field5\Field12 + $01)
                                        EndIf
                                        If (local18 <> 0) Then
                                            setplayertype(local1\Field30, haos_model)
                                            If (getscripts() <> 0) Then
                                                public_inqueue($2B, $00)
                                                public_addparam($00, (Str local1\Field30), $01)
                                                public_addparam($00, (Str local1\Field36), $01)
                                                public_addparam($00, (Str local1\Field73), $01)
                                                callback($00)
                                            EndIf
                                        Else
                                            setplayertype(local1\Field30, $00)
                                            If (getscripts() <> 0) Then
                                                public_inqueue($2C, $00)
                                                public_addparam($00, (Str local1\Field30), $01)
                                                public_addparam($00, (Str local1\Field36), $01)
                                                public_addparam($00, (Str local1\Field73), $01)
                                                callback($00)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    Case $37
                        For local1 = Each players
                            If (local1\Field36 <> $00) Then
                                If (4.0 > entitydistance(local12\Field1\Field25[$1B], local1\Field62)) Then
                                    If ((((((local1\Field36 <> ntf_model) And (local1\Field36 <> guard_model)) And (local1\Field36 <> haos_model)) And (mp_isascp(local1\Field36) = $00)) And (multiplayer_breach_isa035(local1\Field36) = $00)) <> 0) Then
                                        local18 = $00
                                        If (((((local1\Field36 = scientist_model) Or (local1\Field36 = model_clerk)) Or (local1\Field36 = janitor_model)) Or (local1\Field36 = worker_model)) <> 0) Then
                                            breach_givetickets($00, 1.0)
                                            local18 = $01
                                            gameinfo\Field5\Field15 = (gameinfo\Field5\Field15 + $01)
                                        EndIf
                                        If (((local1\Field36 = classd_model) And local1\Field138) <> 0) Then
                                            breach_givetickets($00, 1.0)
                                            local18 = $01
                                            gameinfo\Field5\Field13 = (gameinfo\Field5\Field13 + $01)
                                        EndIf
                                        If (local18 <> 0) Then
                                            setplayertype(local1\Field30, ntf_model)
                                            If (getscripts() <> 0) Then
                                                public_inqueue($2B, $00)
                                                public_addparam($00, (Str local1\Field30), $01)
                                                public_addparam($00, (Str local1\Field36), $01)
                                                public_addparam($00, (Str local1\Field73), $01)
                                                callback($00)
                                            EndIf
                                        Else
                                            setplayertype(local1\Field30, $00)
                                            If (getscripts() <> 0) Then
                                                public_inqueue($2C, $00)
                                                public_addparam($00, (Str local1\Field30), $01)
                                                public_addparam($00, (Str local1\Field36), $01)
                                                public_addparam($00, (Str local1\Field73), $01)
                                                callback($00)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                End Select
            Next
            breach_countroles()
            local0 = breach_checkmatchover()
            If (millisecs() > gameinfo\Field5\Field1) Then
                gameinfo\Field5\Field1 = $00
            EndIf
            If (gameinfo\Field5\Field1 <> $00) Then
                If (gameinfo\Field5\Field5 < millisecs()) Then
                    If (local15 > $00) Then
                        spawnmtf()
                    Else
                        gameinfo\Field5\Field5 = (millisecs() + $1388)
                    EndIf
                EndIf
            EndIf
            If (gameinfo\Field5\Field11 = "Warheads") Then
                If (gameinfo\Field5\Field6 > $00) Then
                    For local19 = Each events
                        If (local19\Field22 = $1F) Then
                            If (0.0 = local19\Field2) Then
                                deactivatewarheads($00)
                                gameinfo\Field5\Field7 = (millisecs() + $1D4C0)
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
            EndIf
            If (server\Field11 <> $00) Then
                If (gameinfo\Field5\Field6 = $00) Then
                    If (gameinfo\Field5\Field4 < millisecs()) Then
                        If ((millisecs() + $4E20) > gameinfo\Field5\Field1) Then
                            gameinfo\Field5\Field6 = $01
                        EndIf
                        If (local0 <> $00) Then
                            gameinfo\Field5\Field6 = $01
                        EndIf
                        If (gameinfo\Field5\Field6 = $01) Then
                            activatewarheads("", local0, $00)
                        EndIf
                    EndIf
                Else
                    If (((millisecs() > (gameinfo\Field5\Field1 - $3A98)) And (gameinfo\Field5\Field6 = $01)) <> 0) Then
                        If (getscripts() <> 0) Then
                            public_inqueue($2F, $00)
                            callback($00)
                        EndIf
                        playerzone = $00
                        For local5 = $01 To server\Field11 Step $01
                            playerzone = getplayerzone(playeroptimize[local5]\Field30)
                            If ((((playerzone > $00) And (playerzone < $04)) And (((playeroptimize[local5]\Field67 = "exit1") And ((1040.0 * roomscale) < entityy(playeroptimize[local5]\Field62, $00))) = $00)) <> 0) Then
                                udp_writebyte($07)
                                udp_writebyte($01)
                                udp_writeint($01)
                                udp_sendmessage(playeroptimize[local5]\Field30)
                            EndIf
                        Next
                        gameinfo\Field5\Field6 = $02
                    EndIf
                    If (millisecs() > gameinfo\Field5\Field1) Then
                        server\Field30 = $00
                        restartserver("")
                        If (server\Field39 <> 0) Then
                            server\Field9 = $01
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    ElseIf (((server\Field45 = $00) And server\Field9) <> 0) Then
        For local20 = Each players
            If (local20\Field30 <> $00) Then
                If (((server\Field8 = $00) And (server\Field21 = $00)) <> 0) Then
                    For local13 = Each rooms
                        If (local13\Field7\Field10 = "start") Then
                            local20\Field0 = (entityx(local13\Field2, $00) + (3584.0 * roomscale))
                            local20\Field1 = (704.0 * roomscale)
                            local20\Field2 = (entityz(local13\Field2, $00) + (1024.0 * roomscale))
                            local20\Field3 = 130.3
                            local20\Field32 = local13\Field69
                            local20\Field37 = $0B
                            mp_updateplayerposition(local20, $00)
                            mp_setroomnametoplayer(local20)
                            local20\Field97 = entityx(local20\Field62, $00)
                            local20\Field98 = entityy(local20\Field62, $00)
                            local20\Field99 = entityz(local20\Field62, $00)
                            local20\Field100 = local20\Field32
                            Exit
                        EndIf
                    Next
                Else
                    For local13 = Each rooms
                        If (local13\Field7\Field10 = "173") Then
                            If (server\Field21 <> 0) Then
                                local20\Field0 = entityx(local13\Field25[$05], $01)
                                local20\Field1 = 2.0
                                local20\Field2 = entityz(local13\Field25[$05], $01)
                            Else
                                local20\Field0 = entityx(local13\Field2, $00)
                                local20\Field1 = 1.0
                                local20\Field2 = entityz(local13\Field2, $00)
                            EndIf
                            local20\Field3 = 130.3
                            local20\Field32 = local13\Field69
                            local20\Field37 = $0B
                            mp_updateplayerposition(local20, $00)
                            mp_setroomnametoplayer(local20)
                            local20\Field97 = entityx(local20\Field62, $00)
                            local20\Field98 = entityy(local20\Field62, $00)
                            local20\Field99 = entityz(local20\Field62, $00)
                            local20\Field100 = local20\Field32
                            Exit
                        EndIf
                    Next
                EndIf
            EndIf
        Next
        server\Field45 = $01
    EndIf
    Return $00
End Function
