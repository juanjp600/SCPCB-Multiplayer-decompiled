Function mp_updateplayerrole%(arg0%)
    Local local0%
    Local local1.items
    Local local2.breachtypes
    Local local3%
    Local local4$
    Local local5%
    Local local6$
    Local local7$
    Local local8%
    Local local9.breachtypes
    Local local10$
    Local local12.players
    Local local13$
    Local local14%
    Local local15%
    Local local16$
    Local local17%
    Local local19%
    Local local20%
    Local local22%
    Local local24.rooms
    Local local25%
    Local local26.spawnpoint
    If (arg0 < $01) Then
        Return $00
    EndIf
    player[arg0]\Field38 = ((((((readbool(player[arg0]\Field38, $00) + (readbool(player[arg0]\Field38, $01) Shl $01)) + (readbool(player[arg0]\Field38, $02) Shl $02)) + (readbool(player[arg0]\Field38, $03) Shl $03)) + (readbool(player[arg0]\Field38, $04) Shl $04)) + (readbool(player[arg0]\Field38, $05) Shl $05)) + (player[arg0]\Field122 Shl $06))
    player[arg0]\Field78 = (((((((readbool(player[arg0]\Field78, $00) + (readbool(player[arg0]\Field78, $01) Shl $01)) + (readbool(player[arg0]\Field78, $02) Shl $02)) + (readbool(player[arg0]\Field78, $03) Shl $03)) + (readbool(player[arg0]\Field78, $04) Shl $04)) + (player[arg0]\Field141 Shl $05)) + (player[arg0]\Field128 Shl $06)) + (readbool(player[arg0]\Field78, $07) Shl $07))
    If (player[arg0]\Field75 <> player[arg0]\Field36) Then
        local0 = $01
        If (((player[arg0]\Field36 = model_zombie) And (player[arg0]\Field75 <> model_zombie)) <> 0) Then
            local0 = $00
        EndIf
        If (((player[arg0]\Field36 = model_035) And (player[arg0]\Field75 <> model_035)) <> 0) Then
            local0 = $00
        EndIf
        If (local0 <> 0) Then
            createrolecorpse(player[arg0], player[arg0]\Field75)
        EndIf
        player[arg0]\Field121 = $00
        entitytype(player[arg0]\Field64, $02, $00)
        entitytype(player[arg0]\Field65, $02, $00)
        player[arg0]\Field141 = $00
        For local1 = Each items
            If (((local1\Field22 = arg0) And (local1\Field22 <> $00)) <> 0) Then
                If (mp_isascp(player[arg0]\Field75) <> 0) Then
                    removeitem(local1, $01)
                Else
                    playerdropitem(local1)
                EndIf
            EndIf
        Next
        For local2 = Each breachtypes
            If (local2\Field1 = player[arg0]\Field36) Then
                local3 = $01
                For local5 = $00 To $09 Step $01
                    If (((local2\Field56[local5] <> "null") And (local2\Field56[local5] <> "")) <> 0) Then
                        local4 = piece(local2\Field56[local5], $01, ",")
                        local4 = ((piece(local4, $01, "/") + "/") + piece(local4, $02, "/"))
                        local3 = $01
                        If (instr(piece(local2\Field56[local5], $02, ","), "if", $01) <> 0) Then
                            local6 = lower(piece(local2\Field56[local5], $02, ","))
                            If (piece(local6, $01, " ") = "if") Then
                                local7 = piece(local6, $02, " ")
                                local8 = $00
                                For local9 = Each breachtypes
                                    If (lower(local9\Field0) = local7) Then
                                        local8 = local9\Field1
                                        Exit
                                    EndIf
                                Next
                                If (local8 <> $00) Then
                                    local10 = piece(local6, $03, " ")
                                    Select local10
                                        Case "exists"
                                            local3 = $00
                                            For local12 = Each players
                                                If (local12\Field36 = local8) Then
                                                    local3 = $01
                                                    Exit
                                                EndIf
                                            Next
                                        Case "notexists"
                                            local3 = $01
                                            For local12 = Each players
                                                If (local12\Field36 = local8) Then
                                                    local3 = $00
                                                    Exit
                                                EndIf
                                            Next
                                    End Select
                                Else
                                    local13 = local7
                                    If (local13 = "random") Then
                                        If (rand($00, $02) = $01) Then
                                            local4 = right(local6, (len(local6) - $0A))
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (local3 = $01) Then
                            giveitem(piece(local4, $01, "/"), piece(local4, $02, "/"), arg0)
                        EndIf
                    EndIf
                Next
                Exit
            EndIf
        Next
        If (getscripts() <> 0) Then
            public_inqueue($30, $00)
            public_addparam($00, (Str arg0), $01)
            public_addparam($00, (Str player[arg0]\Field75), $01)
            public_addparam($00, (Str player[arg0]\Field36), $01)
            callback($00)
        EndIf
        If (server\Field21 <> 0) Then
            If (((player[arg0]\Field36 = $00) And (50.0 > player[arg0]\Field62)) <> 0) Then
                If ((mp_isascp(player[arg0]\Field75) Or multiplayer_breach_isa035(player[arg0]\Field75)) <> 0) Then
                    breach_countroles()
                    If (breach_getrolecount(ntf_model) > $00) Then
                        local14 = $00
                        For local15 = $01 To server\Field11 Step $01
                            local14 = (local14 + (mp_isascp(playeroptimize[local15]\Field36) Or multiplayer_breach_isa035(playeroptimize[local15]\Field36)))
                        Next
                        If (getscripts() <> 0) Then
                            public_inqueue($43, $00)
                            public_addparam($00, (Str arg0), $01)
                            public_addparam($00, (Str player[arg0]\Field75), $01)
                            public_addparam($00, (Str player[arg0]\Field36), $01)
                            callback($00)
                        EndIf
                        If (se_getreturnvalue() <> "-1") Then
                            local16 = se_getreturnvalue()
                        EndIf
                        If (local16 = "") Then
                            local17 = $00
                            If (local14 > $00) Then
                                Select player[arg0]\Field75
                                    Case model_035
                                        local17 = $01
                                    Case model_860
                                        local17 = $01
                                    Case model_049
                                        playsoundforall("SFX\Character\MTF\Announc049Contain.ogg")
                                        local17 = $01
                                    Case model_096
                                        playsoundforall("SFX\Character\MTF\Announc096Contain.ogg")
                                        local17 = $01
                                    Case model_173
                                        playsoundforall("SFX\Character\MTF\Announc173Contain.ogg")
                                        local17 = $01
                                    Case model_106
                                        playsoundforall("SFX\Character\MTF\Announc106Contain.ogg")
                                        local17 = $01
                                    Case model_939
                                        playsoundforall("SFX\Character\MTF\Announc939Contain.ogg")
                                        local17 = $01
                                    Case model_966
                                        playsoundforall("SFX\Character\MTF\Announc966Contain.ogg")
                                        local17 = $01
                                End Select
                            Else
                                playsoundforall("SFX\Character\MTF\AnnouncAllContain.ogg")
                            EndIf
                            If (local17 = $01) Then
                                local19 = player[arg0]\Field50
                                If (isvalidplayer(local19) <> 0) Then
                                    local20 = breach_getcategorybytype(player[local19]\Field36, $00)
                                    Select local20
                                        Case $07,$03,$04,$02
                                            breach_givetickets($00, $14)
                                        Case $06,$01
                                            breach_givetickets($01, $14)
                                    End Select
                                EndIf
                            EndIf
                        ElseIf (local16 <> "0") Then
                            playsoundforall(local16)
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        player[arg0]\Field98 = $00
        player[arg0]\Field75 = player[arg0]\Field36
        entityradius(player[arg0]\Field64, 0.15, 0.3)
        For local2 = Each breachtypes
            If (local2\Field1 = player[arg0]\Field36) Then
                scaleentity(player[arg0]\Field71, local2\Field10, local2\Field11, local2\Field12, $00)
                player[arg0]\Field62 = 0.0
                giveplayerhealth(arg0, (Float local2\Field8), "")
                player[arg0]\Field120 = local2\Field57
                Exit
            EndIf
        Next
        resetplayersize(arg0)
        player[arg0]\Field176 = 1.0
        local22 = $00
        local2 = getbreachtype(player[arg0]\Field36)
        Select local2\Field40
            Case model_096
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room2servers") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.7), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case model_860
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room860") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field29[$00]\Field0, $01), (entityy(local24\Field29[$00]\Field0, $01) + 0.2), entityz(local24\Field29[$00]\Field0, $01), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case model_zombie,model_035
                local22 = $01
            Case model_939
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room3storage") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field25[$04], $01), (entityy(local24\Field25[$04], $01) + 0.2), entityz(local24\Field25[$04], $01), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case ntf_model
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "exit1") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field25[$1A], $01), (entityy(local24\Field25[$1A], $01) + 1.0), entityz(local24\Field25[$1A], $01), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case model_049
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room049") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.7), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case model_173
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room2closets") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.8), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case guard_model
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "gateaentrance") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.7), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case haos_model
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "gatea") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field25[$1B], $01), (entityy(local24\Field25[$1B], $01) + 1.0), entityz(local24\Field25[$1B], $01), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case classd_model
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "start") Then
                        positionentity(player[arg0]\Field64, (entityx(local24\Field2, $00) + 14.0), 2.75, (entityz(local24\Field2, $00) + 4.0), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case janitor_model
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room2scps") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.7), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case model_clerk
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room2scps2") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.7), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case scientist_model
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room3storage") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.7), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case worker_model
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room2sl") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.7), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case model_966
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room966") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field25[$02], $01), entityy(local24\Field25[$02], $01), entityz(local24\Field25[$02], $01), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            Case model_106
                local22 = $00
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room106") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field25[$0A], $01), 0.4, entityz(local24\Field25[$0A], $01), $00)
                        resetentity(player[arg0]\Field64)
                        local22 = $01
                        mp_setplayerroomid(player[local25], local24)
                        Exit
                    EndIf
                Next
                entitytype(player[arg0]\Field64, $0C, $00)
                entitytype(player[arg0]\Field65, $0C, $00)
        End Select
        If (local22 = $00) Then
            If (((((local2\Field40 = scientist_model) Or (local2\Field40 = worker_model)) Or (local2\Field40 = janitor_model)) Or (local2\Field40 = model_clerk)) <> 0) Then
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "start") Then
                        positionentity(player[arg0]\Field64, (entityx(local24\Field2, $00) + 14.0), 2.75, (entityz(local24\Field2, $00) + 4.0), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            ElseIf ((((mp_isascp(local2\Field40) Or (local2\Field40 = haos_model)) Or (local2\Field40 = ntf_model)) Or (local2\Field40 = guard_model)) <> 0) Then
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "room2nuke") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field2, $00), (entityy(local24\Field2, $00) + 0.7), entityz(local24\Field2, $00), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        local22 = $01
                        Exit
                    EndIf
                Next
            EndIf
        EndIf
        If (local2\Field40 = model_wait) Then
            If ((server\Field21 And (gameinfo\Field5\Field2 > millisecs())) <> 0) Then
                For local24 = Each rooms
                    If (local24\Field7\Field10 = "173") Then
                        positionentity(player[arg0]\Field64, entityx(local24\Field25[$05], $01), 1.0, entityz(local24\Field25[$05], $01), $00)
                        resetentity(player[arg0]\Field64)
                        mp_setplayerroomid(player[arg0], local24)
                        Exit
                    EndIf
                Next
            EndIf
        EndIf
        setplayerposition(arg0, room[player[arg0]\Field32]\Field7\Field10, entityx(player[arg0]\Field64, $00), (entityy(player[arg0]\Field64, $00) + 0.3), entityz(player[arg0]\Field64, $00))
        For local26 = Each spawnpoint
            If (local26\Field1 > $00) Then
                If (player[arg0]\Field36 = local26\Field1) Then
                    setplayerposition(arg0, local26\Field2, local26\Field3, local26\Field4, local26\Field5)
                    Exit
                EndIf
            EndIf
        Next
        For local26 = Each spawnpoint
            If (local26\Field0 = arg0) Then
                setplayerposition(arg0, local26\Field2, local26\Field3, local26\Field4, local26\Field5)
                Exit
            EndIf
        Next
    EndIf
    Return $00
End Function
