Function breach_update%()
    Local local0%
    Local local1%
    Local local2%
    Local local3.players
    Local local4.players
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9%[65]
    Local local10%
    Local local11%
    Local local12%[255]
    Local local13%
    Local local14%
    Local local15%
    Local local16.breachtypes
    Local local19.items
    Local local20.events
    Local local21.rooms
    Local local22%
    Local local23%
    Local local24.players
    Local local25.events
    Local local26.players
    If (server\Field21 = $01) Then
        notarget = $01
        mtftimer = 24000.0
        local1 = millisecs()
        If (((server\Field11 < $04) And (gameinfo\Field5\Field4 > local1)) <> 0) Then
            local2 = (local1 + $15F90)
            gameinfo\Field5\Field1 = (server\Field22 + local2)
            gameinfo\Field5\Field4 = local2
            gameinfo\Field5\Field2 = local2
        EndIf
        If (server\Field48 < local1) Then
            If (istimedout($05, $0A) <> 0) Then
                For local3 = Each players
                    If (local3\Field36 = model_173) Then
                        For local4 = Each players
                            If (local4\Field36 <> $00) Then
                                If (local3 <> local4) Then
                                    If (mp_isafriend(local3\Field36, local4\Field36) = $00) Then
                                        local5 = (entityx(local3\Field64, $00) - entityx(local4\Field64, $00))
                                        local6 = (entityy(local3\Field64, $00) - entityy(local4\Field64, $00))
                                        local7 = (entityz(local3\Field64, $00) - entityz(local4\Field64, $00))
                                        local8 = (((local5 * local5) + (local6 * local6)) + (local7 * local7))
                                        If (3600.0 > local8) Then
                                            If (entityvisible(local3\Field64, local4\Field64) <> 0) Then
                                                mp_sendblinktimer(local4\Field30, $32)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    EndIf
                Next
            EndIf
            If ((server\Field48 > (local1 - server\Field81)) = $00) Then
                server\Field48 = (server\Field82 + local1)
            EndIf
        EndIf
        If (server\Field45 = $00) Then
            If ((shouldstartround Or (server\Field11 >= server\Field52)) <> 0) Then
                If (server\Field11 >= $04) Then
                    gameinfo\Field5\Field1 = (server\Field22 + local1)
                    gameinfo\Field5\Field4 = (local1 - $01)
                    gameinfo\Field5\Field2 = (local1 - $01)
                EndIf
                shouldstartround = $00
            EndIf
        EndIf
        If (breach_isstarted() <> 0) Then
            If (server\Field45 = $00) Then
                gameinfo\Field5\Field1 = (server\Field22 + local1)
                gameinfo\Field5\Field4 = (local1 - $01)
                gameinfo\Field5\Field2 = (local1 - $01)
                gameinfo\Field5\Field7 = ((server\Field22 Sar $01) + local1)
                local0 = $01
                local10 = server\Field11
                For local11 = $01 To server\Field11 Step $01
                    local9[(local11 - $01)] = playeroptimize[local11]\Field30
                Next
                shuffleplayersarray(local9, server\Field11)
                For local11 = $00 To (local10 - $01) Step $01
                    If (server\Field30 <> 0) Then
                        setplayertype(local9[local11], randombetween(guard_model, haos_model))
                    Else
                        breach_countroles()
                        local13 = $00
                        local14 = $00
                        local15 = $00
                        For local16 = Each breachtypes
                            If (local16\Field59 <> 0) Then
                                local15 = (local16\Field58 > breach_getrolecount(local16\Field1))
                                If (local15 <> 0) Then
                                    local14 = breach_getcategorybytype(local16\Field1, $00)
                                    Select local14
                                        Case $05
                                            If (((((Float breach_getcategorycount(local14)) > ((Float server\Field11) * 0.25)) Or (min((Float (server\Field11 / $05)), 6.0) < (Float breach_getcategorycount(local16\Field1)))) Or ((local16\Field1 = model_860) And (room860event = Null))) <> 0) Then
                                                local15 = $00
                                            EndIf
                                        Case $07
                                            If ((Float breach_getcategorycount(local14)) > ((Float server\Field11) * 0.5)) Then
                                                local15 = $00
                                            EndIf
                                    End Select
                                    If (local15 <> 0) Then
                                        local12[local13] = local16\Field1
                                        local13 = (local13 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If (local13 > $00) Then
                            setplayertype(local9[local11], local12[rand($00, (local13 - $01))])
                        Else
                            Select rand($00, $03)
                                Case $00
                                    setplayertype(local9[local11], classd_model)
                                Case $01
                                    setplayertype(local9[local11], janitor_model)
                                Case $02
                                    setplayertype(local9[local11], model_clerk)
                                Case $03
                                    setplayertype(local9[local11], worker_model)
                            End Select
                        EndIf
                    EndIf
                Next
                local0 = $00
                server\Field45 = $01
                For local19 = Each items
                    If (local19\Field22 <> $00) Then
                        removeitem(local19, $01)
                    EndIf
                Next
                For local20 = Each events
                    If (local20\Field0 = "gateaentrance") Then
                        local20\Field4 = 1.0
                        local20\Field1\Field29[$01]\Field5 = $00
                        local20\Field1\Field29[$01]\Field4 = $00
                    ElseIf (local20\Field0 = "exit1") Then
                        local20\Field4 = 1.0
                        local20\Field1\Field29[$04]\Field5 = $00
                        local20\Field1\Field29[$04]\Field4 = $00
                    EndIf
                Next
                For local20 = Each events
                    If (local20\Field0 = "checkpoint") Then
                        local20\Field1\Field29[$01]\Field5 = $00
                        local20\Field1\Field29[$00]\Field5 = $00
                    EndIf
                Next
                remotedooron = $01
                For local21 = Each rooms
                    If (local21\Field7\Field10 = "exit1") Then
                        local21\Field29[$03]\Field5 = $01
                        Exit
                    EndIf
                Next
                For local21 = Each rooms
                    If (local21\Field7\Field10 = "start") Then
                        local21\Field29[$02]\Field5 = $01
                    EndIf
                Next
                gameinfo\Field5\Field5 = (rand($493E0, $61A80) + local1)
                createevent("alarm", "start", $00, 0.0)
                If (getscripts() <> 0) Then
                    public_inqueue($2A, $00)
                    callback($00)
                EndIf
                breach_givetickets($00, $18)
                breach_givetickets($01, $12)
            EndIf
            updatebreachevents2()
            For local11 = $01 To server\Field11 Step $01
                If (playeroptimize[local11]\Field36 = $00) Then
                    local22 = (local22 + $01)
                EndIf
                If (playeroptimize[local11]\Field36 <> $00) Then
                    local23 = (local23 + $01)
                EndIf
            Next
            If ((server\Field30 And (gameinfo\Field5\Field6 = $00)) <> 0) Then
                For local24 = Each players
                    If ((readbool(local24\Field38, $04) Or (local24\Field36 = $00)) <> 0) Then
                        setplayertype(local24\Field30, randombetween(haos_model, guard_model))
                    EndIf
                Next
            EndIf
            breach_countroles()
            local0 = breach_checkmatchover()
            If (local1 > gameinfo\Field5\Field1) Then
                gameinfo\Field5\Field1 = $00
            EndIf
            If (gameinfo\Field5\Field1 <> $00) Then
                If (gameinfo\Field5\Field5 < local1) Then
                    If (local22 > $00) Then
                        spawnwave()
                    Else
                        gameinfo\Field5\Field5 = (local1 + $1388)
                    EndIf
                EndIf
            EndIf
            If (gameinfo\Field5\Field11 = "Warheads") Then
                If (gameinfo\Field5\Field6 > $00) Then
                    For local25 = Each events
                        If (local25\Field22 = $1F) Then
                            If (0.0 = local25\Field2) Then
                                deactivatewarheads($00)
                                gameinfo\Field5\Field7 = (local1 + $1D4C0)
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
            EndIf
            If (server\Field11 <> $00) Then
                If (gameinfo\Field5\Field6 = $00) Then
                    If (gameinfo\Field5\Field4 < local1) Then
                        If ((local1 + $4E20) > gameinfo\Field5\Field1) Then
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
                    If (((local1 > (gameinfo\Field5\Field1 - $3A98)) And (gameinfo\Field5\Field6 = $01)) <> 0) Then
                        If (getscripts() <> 0) Then
                            public_inqueue($2F, $00)
                            callback($00)
                        EndIf
                        playerzone = $00
                        For local11 = $01 To server\Field11 Step $01
                            playerzone = getplayerzone(playeroptimize[local11]\Field30)
                            If ((((playerzone > $00) And (playerzone < $04)) And (((playeroptimize[local11]\Field69 = "exit1") And (4.0625 < entityy(playeroptimize[local11]\Field64, $00))) = $00)) <> 0) Then
                                udp_writebyte($07)
                                udp_writebyte($01)
                                udp_writeint($01)
                                udp_sendmessage(playeroptimize[local11]\Field30)
                            EndIf
                        Next
                        gameinfo\Field5\Field6 = $02
                    EndIf
                    If (local1 > gameinfo\Field5\Field1) Then
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
        For local26 = Each players
            If (local26\Field30 <> $00) Then
                If (((server\Field8 = $00) And (server\Field21 = $00)) <> 0) Then
                    For local21 = Each rooms
                        If (local21\Field7\Field10 = "start") Then
                            local26\Field0 = (entityx(local21\Field2, $00) + 14.0)
                            local26\Field1 = 2.75
                            local26\Field2 = (entityz(local21\Field2, $00) + 4.0)
                            local26\Field3 = 130.3
                            local26\Field32 = local21\Field69
                            local26\Field37 = $0B
                            mp_updateplayerposition(local26, $00)
                            mp_setroomnametoplayer(local26)
                            local26\Field99 = entityx(local26\Field64, $00)
                            local26\Field100 = entityy(local26\Field64, $00)
                            local26\Field101 = entityz(local26\Field64, $00)
                            local26\Field102 = local26\Field32
                            Exit
                        EndIf
                    Next
                Else
                    For local21 = Each rooms
                        If (local21\Field7\Field10 = "173") Then
                            If (server\Field21 <> 0) Then
                                local26\Field0 = entityx(local21\Field25[$05], $01)
                                local26\Field1 = 2.0
                                local26\Field2 = entityz(local21\Field25[$05], $01)
                            Else
                                local26\Field0 = entityx(local21\Field2, $00)
                                local26\Field1 = 1.0
                                local26\Field2 = entityz(local21\Field2, $00)
                            EndIf
                            local26\Field3 = 130.3
                            local26\Field32 = local21\Field69
                            local26\Field37 = $0B
                            mp_updateplayerposition(local26, $00)
                            mp_setroomnametoplayer(local26)
                            local26\Field99 = entityx(local26\Field64, $00)
                            local26\Field100 = entityy(local26\Field64, $00)
                            local26\Field101 = entityz(local26\Field64, $00)
                            local26\Field102 = local26\Field32
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
