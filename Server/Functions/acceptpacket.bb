Function acceptpacket%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1.players
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9.querys
    Local local10#
    Local local11.events
    Local local12%
    Local local13%
    Local local15%
    Local local16$
    Local local17$
    Local local18$
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local25.authconnection
    Local local26.steaminstances
    Local local27$
    Local local28$
    Local local29.players
    Local local30.banned
    Local local31%
    Local local32.centralserversegments
    Local local33%
    Local local34.antiddos
    Local local35%
    Local local36.rooms
    Local local37%
    Local local38$
    Local local41%
    local0 = readbyte(server\Field0)
    If (isvalidplayer(local0) = $00) Then
        Return $00
    EndIf
    If (((player[local0] <> Null) And (local0 <> $00)) <> 0) Then
        If (((player[local0]\Field13 <> arg1) Or (player[local0]\Field14 <> arg2)) <> 0) Then
            Return $00
        EndIf
    ElseIf ((((arg0 <> $1A) And (arg0 <> $23)) And (arg0 <> $7E)) <> 0) Then
        Return $00
    EndIf
    local1 = player[local0]
    local1\Field23 = (millisecs() + server\Field13)
    Select arg0
        Case $4A
            local3 = readbyte(server\Field0)
            If (server\Field57 = $00) Then
                If (getscripts() <> 0) Then
                    local4 = public_inqueue($10, $00)
                    public_addparam(local4, (Str local0), $01)
                    public_addparam(local4, (Str max(min((Float local3), (Float (last_breach_type - $01))), 0.0)), $01)
                    callback($00)
                EndIf
                If (se_return_value\Field8 = $00) Then
                    setplayertype(local1\Field30, (Int max(min((Float local3), (Float (last_breach_type - $01))), 0.0)))
                EndIf
            ElseIf (local3 = $00) Then
                If (getscripts() <> 0) Then
                    local4 = public_inqueue($10, $00)
                    public_addparam(local4, (Str local0), $01)
                    public_addparam(local4, (Str max(min((Float local3), (Float (last_breach_type - $01))), 0.0)), $01)
                    callback($00)
                EndIf
                If (se_return_value\Field8 = $00) Then
                    If (server\Field21 = $00) Then
                        giveplayerhealth(local0, -1000.0, "")
                    Else
                        setplayertype(local1\Field30, $00)
                    EndIf
                EndIf
            EndIf
        Case $7D
            udp_writebyte($7D)
            udp_writebyte($01)
            udp_sendmessage(local0)
            local1\Field22 = $01
            If (getscripts() <> 0) Then
                public_inqueue($06, $00)
                public_addparam($00, (Str local0), $01)
                callback($00)
            EndIf
        Case $72
            If (getscripts() <> 0) Then
                local5 = createbank(readavail(server\Field0))
                readbytes(local5, server\Field0, $00, banksize(local5))
                public_inqueue($0B, $00)
                public_addparam($00, (Str local0), $01)
                public_addparam($00, (Str local5), $01)
                callback($00)
                freebank(local5)
            EndIf
        Case $6F
            local6 = readint(server\Field0)
            local7 = readint(server\Field0)
            local8 = readshort(server\Field0)
            local8 = (Int min(max(1.0, (Float local8)), 4000.0))
            For local9 = Each querys
                If (local9\Field3 = local0) Then
                    If ((Handle local9) = local6) Then
                        local9\Field4 = local8
                        local9\Field1 = (Int min(max((Float local7), 0.0), (Float local9\Field2)))
                        If (local9\Field1 < local9\Field2) Then
                            resizebank(query_global_data, local9\Field4)
                            seekfile(local9\Field5, local9\Field1)
                            resizebank(query_global_data, (Int min((Float local9\Field4), (Float (local9\Field2 - filepos(local9\Field5))))))
                            readbytes(query_global_data, local9\Field5, $00, banksize(query_global_data))
                            udp_writebyte($70)
                            udp_writebyte($01)
                            udp_writeline(local9\Field0)
                            udp_writeint((Handle local9))
                            udp_writeint(local9\Field1)
                            udp_writeint(local9\Field2)
                            udp_writebytes(query_global_data, $00, banksize(query_global_data))
                            udp_writebyte(local9\Field6)
                            udp_writeint(local9\Field8)
                            udp_sendmessage(local9\Field3)
                            local9\Field7 = (millisecs() + $14)
                        Else
                            local9\Field1 = (local9\Field2 + $01)
                        EndIf
                        Exit
                    EndIf
                EndIf
            Next
        Case $64
            If (local1\Field42 <> $00) Then
                local1\Field33 = (Int max(5.0, (Float (millisecs() - local1\Field42))))
                local1\Field42 = $00
            EndIf
            local1\Field22 = $01
        Case $26
            If (server\Field21 = $00) Then
                local10 = readfloat(server\Field0)
                For local11 = Each events
                    If (local11\Field0 = "173") Then
                        local11\Field4 = local10
                        For local12 = $01 To server\Field18 Step $01
                            If (((player[local12] <> Null) And (local12 <> local0)) <> 0) Then
                                udp_writebyte(arg0)
                                udp_writebyte(local0)
                                udp_writefloat(local10)
                                udp_sendmessage(local12)
                            EndIf
                        Next
                        Exit
                    EndIf
                Next
            EndIf
        Case $25
            If (server\Field21 = $00) Then
                If (getscripts() <> 0) Then
                    local4 = public_inqueue($14, $00)
                    public_addparam(local4, (Str local0), $01)
                    callback($00)
                EndIf
                If (se_return_value\Field8 = $00) Then
                    For local11 = Each events
                        If (local11\Field0 = "room106") Then
                            If (0.0 = local11\Field2) Then
                                local11\Field2 = 1.0
                                If (soundtransmission = $01) Then
                                    If (local11\Field6 <> $00) Then
                                        If (channelplaying(local11\Field6) <> 0) Then
                                            stopchannel(local11\Field6)
                                        EndIf
                                    EndIf
                                    femurbreakersfx = loadsound_strict("SFX\Room\106Chamber\FemurBreaker.ogg")
                                    local11\Field6 = playsound_strict(femurbreakersfx)
                                EndIf
                                For local12 = $01 To server\Field18 Step $01
                                    If (player[local12] <> Null) Then
                                        udp_writebyte(arg0)
                                        udp_writebyte(local0)
                                        udp_sendmessage(local12)
                                    EndIf
                                Next
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
            EndIf
        Case $07
            local13 = readint(server\Field0)
            If (getscripts() <> 0) Then
                local4 = public_inqueue($15, $00)
                public_addparam(local4, (Str local0), $01)
                public_addparam(local4, (Str local13), $01)
                callback($00)
            EndIf
            If (((se_getreturnvalue() = "0") Or (se_getreturnvalue() = "-1")) <> 0) Then
                For local12 = $01 To server\Field18 Step $01
                    If (((player[local12] <> Null) And (local12 <> local0)) <> 0) Then
                        udp_writebyte(arg0)
                        udp_writebyte(local0)
                        udp_writeint(local13)
                        udp_sendmessage(local12)
                    EndIf
                Next
            EndIf
        Case $0D
            kick(local0, (local1\Field15 + " has left the server"))
        Case $23
            If (isconnectionspam(arg1, $10, $3E8, (readavail(server\Field0) >= $04)) <> 0) Then
                Return $00
            EndIf
            If (getscripts() <> 0) Then
                local4 = public_inqueue($20, $00)
                public_addparam(local4, dottedip(arg1), $03)
                public_addparam(local4, (Str arg2), $01)
                callback($00)
            EndIf
            If (se_return_value\Field8 = $00) Then
                If (((readavail(server\Field0) < $01) Or server\Field66) <> 0) Then
                    udp_writeline(server\Field5)
                    udp_writeline((((Str server\Field11) + " / ") + (Str server\Field18)))
                    udp_writebyte(server\Field2)
                    If (server\Field21 <> 0) Then
                        udp_writebyte(breach_isstarted())
                    Else
                        udp_writebyte(server\Field9)
                    EndIf
                    If (server\Field14 <> "") Then
                        udp_writeline("PS")
                    Else
                        udp_writeline("")
                    EndIf
                    udp_writebyte(server\Field21)
                    udp_writebyte(server\Field10)
                    udp_writeline(server\Field7)
                    udp_writeline(server\Field42)
                    udp_writeline(server\Field43)
                    udp_writeline(mp_version)
                    udp_writeline(server\Field44)
                    If (server\Field66 <> 0) Then
                        For local12 = $00 To $13 Step $01
                            If (server\Field61[local12] <> "") Then
                                udp_writeline(server\Field61[local12])
                            EndIf
                        Next
                        udp_writeline("")
                        udp_writebyte(((server\Field69 And server\Field65) And server\Field73))
                    EndIf
                Else
                    Select readbyte(server\Field0)
                        Case $01
                            udp_writeint($236357)
                            udp_writebyte($01)
                            udp_writeline(server\Field5)
                            udp_writeline((((Str server\Field11) + " / ") + (Str server\Field18)))
                            udp_writebyte(server\Field2)
                            If (server\Field21 <> 0) Then
                                udp_writebyte(breach_isstarted())
                            Else
                                udp_writebyte(server\Field9)
                            EndIf
                            udp_writebyte((server\Field14 <> ""))
                            udp_writebyte(server\Field21)
                            udp_writebyte(server\Field10)
                            udp_writeline(server\Field7)
                            udp_writeline(server\Field43)
                            udp_writebyte(((server\Field69 And server\Field65) And server\Field73))
                        Case $02
                            udp_writeint($236357)
                            udp_writebyte($02)
                            udp_writeline(server\Field42)
                            udp_writeline(mp_version)
                            udp_writeline(server\Field44)
                        Case $03
                            udp_writeint($236357)
                            udp_writebyte($03)
                            For local12 = $00 To $13 Step $01
                                If (server\Field61[local12] <> "") Then
                                    udp_writeline(server\Field61[local12])
                                EndIf
                            Next
                    End Select
                EndIf
                sendudpmsg(server\Field0, arg1, arg2)
            EndIf
        Case $7B
            If (server\Field10 <> 0) Then
                If (local1\Field139 = $00) Then
                    For local12 = $01 To server\Field11 Step $01
                        If ((playeroptimize[local12]\Field22 Or (server\Field9 = $00)) <> 0) Then
                            If ((((((server\Field9 = $00) Or (15.0 >= entitydistance(playeroptimize[local12]\Field62, local1\Field62))) Or ((playeroptimize[local12]\Field57 = local1\Field57) And (local1\Field57 <> $00))) Or (local1\Field120 = $01)) Or ((local1\Field36 <> $00) Or (playeroptimize[local12]\Field36 = local1\Field36))) <> 0) Then
                                udp_writebyte($7B)
                                udp_writebyte(local0)
                                udp_sendmessage(playeroptimize[local12]\Field30)
                            EndIf
                        EndIf
                    Next
                EndIf
            EndIf
        Case $1D
            If (server\Field10 <> 0) Then
                If (local1\Field139 = $00) Then
                    local15 = createbank(readavail(server\Field0))
                    readbytes(local15, server\Field0, $00, readavail(server\Field0))
                    If (getscripts() <> 0) Then
                        local4 = public_inqueue($21, $00)
                        public_addparam(local4, (Str local0), $01)
                        public_addparam(local4, (Str local15), $01)
                        public_addparam(local4, (Str local1\Field57), $01)
                        public_addparam(local4, (Str local1\Field120), $01)
                        callback($00)
                        If (se_return_value\Field8 <> 0) Then
                            freebank(local15)
                            Return $00
                        EndIf
                    EndIf
                    For local12 = $01 To server\Field11 Step $01
                        If ((playeroptimize[local12]\Field22 Or (server\Field9 = $00)) <> 0) Then
                            If ((((((server\Field9 = $00) Or (15.0 >= entitydistance(playeroptimize[local12]\Field62, local1\Field62))) Or ((playeroptimize[local12]\Field57 = local1\Field57) And (local1\Field57 <> $00))) Or (local1\Field120 = $01)) Or ((local1\Field36 <> $00) Or (playeroptimize[local12]\Field36 = local1\Field36))) <> 0) Then
                                udp_writebyte($1D)
                                udp_writebyte(local0)
                                udp_writebytes(local15, $00, banksize(local15))
                                udp_writebyte(local1\Field57)
                                udp_sendmessage(playeroptimize[local12]\Field30)
                            EndIf
                        EndIf
                    Next
                    freebank(local15)
                EndIf
            EndIf
        Case $1A
            If (isconnectionspam(arg1, $10, $3E8, $00) <> 0) Then
                Return $00
            EndIf
            local16 = readlinesafe(server\Field0)
            local17 = readline(server\Field0)
            local18 = readline(server\Field0)
            local19 = readbyte(server\Field0)
            local20 = readshort(server\Field0)
            local21 = readshort(server\Field0)
            local22 = readbyte(server\Field0)
            local23 = readint(server\Field0)
            If ((((((((local23 = $00) Or (local21 = $00)) Or (local20 = $00)) Or (local19 = $00)) Or (local17 = "")) Or (len(local16) > $18)) Or (len(local17) > $08)) <> 0) Then
                Return $00
            EndIf
            local22 = $00
            local24 = $00
            For local25 = Each authconnection
                local24 = (local24 + $01)
                If (local25\Field7 = local23) Then
                    Return $00
                ElseIf (local25\Field0 = arg1) Then
                    Return $00
                EndIf
            Next
            If (local24 >= $C8) Then
                For local25 = Each authconnection
                    removeauthconnection(local25)
                Next
            EndIf
            For local12 = $01 To server\Field11 Step $01
                If (playeroptimize[local12]\Field13 = arg1) Then
                    If (playeroptimize[local12]\Field14 = arg2) Then
                        Return $00
                    EndIf
                EndIf
            Next
            addlog((((((local16 + " incoming connection: ") + dottedip(arg1)) + " [U:1:") + (Str local23)) + "]"), $00, $00, $00)
            incomingversion = local17
            incomingpatron = local22
            For local26 = Each steaminstances
                If (local26\Field0 = local23) Then
                    incomingpatron = (local26\Field1 = "PATRON")
                    Exit
                EndIf
            Next
            local27 = dottedip(arg1)
            local28 = ""
            If (getscripts() <> 0) Then
                public_inqueue($22, $00)
                public_addparam($00, local16, $03)
                public_addparam($00, local27, $03)
                public_addparam($00, (Str local23), $01)
                public_addparam($00, local17, $03)
                public_addparam($00, (Str local22), $01)
                callback($00)
            EndIf
            If (instr(local16, "%", $01) <> 0) Then
                local28 = "Invalid syntax , please change your nickname!"
            EndIf
            If (local18 <> server\Field14) Then
                local28 = "Wrong password"
            EndIf
            If (local16 = "") Then
                local28 = "Invalid input, please set your nickname!"
            Else
                For local29 = Each players
                    If (lower(local29\Field15) = lower(local16)) Then
                        local28 = (((((("Change your nickname" + chr($0D)) + chr($0A)) + "A player with this name") + chr($0D)) + chr($0A)) + "is already on the server")
                        Exit
                    EndIf
                Next
            EndIf
            For local30 = Each banned
                If (((local30\Field1 = local27) Or (local30\Field2 = local23)) <> 0) Then
                    local28 = "You've got banned from the server."
                    Exit
                EndIf
            Next
            If (((isaccessversion(local17) = $00) Or (local19 <> $02)) <> 0) Then
                local28 = (((("Version doesn't match" + chr($0D)) + chr($0A)) + "Server version: ") + mp_version)
            EndIf
            If (server\Field11 = server\Field18) Then
                local28 = "Server is full"
            EndIf
            If (getscripts() <> 0) Then
                If (se_getreturnvalue() <> "-1") Then
                    local28 = se_getreturnvalue()
                EndIf
            EndIf
            If (local28 <> "") Then
                udp_writebyte($71)
                udp_writeline(local28)
                sendudpmsg(server\Field0, arg1, arg2)
                addlog(((local16 + " could not connect due to: ") + local28), $00, $00, $00)
                Return $00
            EndIf
            If (server\Field21 = $01) Then
                server\Field9 = $01
            EndIf
            local25 = (New authconnection)
            local25\Field8 = (millisecs() + $1388)
            local25\Field0 = arg1
            local25\Field1 = arg2
            local25\Field2 = local16
            local25\Field4 = local20
            local25\Field5 = local21
            local25\Field6 = local22
            local25\Field7 = local23
            local25\Field3 = local17
            If (server\Field69 <> 0) Then
                If (server\Field65 <> 0) Then
                    local25\Field9 = createbank(readavail(server\Field0))
                    readbytes(local25\Field9, server\Field0, $00, banksize(local25\Field9))
                    local31 = $00
                    For local32 = Each centralserversegments
                        local31 = $01
                        Exit
                    Next
                    If (local31 = $00) Then
                        addlog("No central servers for player authorization were found. Receiving data...", $00, $00, $00)
                        requestdatafromglobal()
                    EndIf
                    For local32 = Each centralserversegments
                        local31 = rand($01, $7FFE76D8)
                        writebyte(centralserver\Field1, $34)
                        writeint(centralserver\Field1, local31)
                        writeint(centralserver\Field1, ((((local31 Sar $01) Shl $02) Shl $01) - $14))
                        writeint(centralserver\Field1, (Handle local25))
                        writeint(centralserver\Field1, local25\Field7)
                        writebytes(local25\Field9, centralserver\Field1, $00, banksize(local25\Field9))
                        sendudpmsg(centralserver\Field1, local32\Field2, local32\Field1)
                    Next
                    freebank(local25\Field9)
                    local25\Field9 = $00
                Else
                    local25\Field11 = $01
                    sendserverdatatoplayer(arg1, arg2)
                EndIf
            Else
                If (steam_release = $00) Then
                    server\Field65 = $00
                EndIf
                If (server\Field65 <> 0) Then
                    local25\Field9 = createbank(readavail(server\Field0))
                    readbytes(local25\Field9, server\Field0, $00, banksize(local25\Field9))
                EndIf
                local25\Field11 = $01
                sendserverdatatoplayer(arg1, arg2)
            EndIf
        Case $7E
            For local25 = Each authconnection
                If (local25\Field0 = arg1) Then
                    If (local25\Field1 = arg2) Then
                        If (local25\Field11 = $01) Then
                            local33 = local25\Field10
                            If (((local33 = $00) And ((server\Field18 = server\Field11) = $00)) <> 0) Then
                                For local34 = Each antiddos
                                    If (local34\Field0 = arg1) Then
                                        Delete local34
                                    EndIf
                                Next
                                local0 = findfreeplayerid()
                                createplayer(local0)
                                local1 = player[local0]
                                local1\Field71 = local25\Field4
                                local1\Field72 = local25\Field5
                                local1\Field75 = local25\Field6
                                local1\Field54 = local25\Field3
                                setplayertype(local1\Field30, model_wait)
                                local1\Field23 = (millisecs() + server\Field13)
                                local1\Field13 = arg1
                                local1\Field33 = $05
                                local1\Field40 = dottedip(arg1)
                                local1\Field129 = local25\Field7
                                local1\Field15 = local25\Field2
                                local1\Field14 = arg2
                                local1\Field39 = rand($01, $03)
                                local1\Field70 = (millisecs() + $EA60)
                                For local26 = Each steaminstances
                                    If (local26\Field0 = local1\Field129) Then
                                        local1\Field157 = local26\Field1
                                        local1\Field158 = local26\Field2
                                        local1\Field159 = local26\Field3
                                        local1\Field160 = local26\Field4
                                        Exit
                                    EndIf
                                Next
                                local35 = $00
                                For local12 = $00 To $02 Step $01
                                    If (lower(server\Field26) = getnamedifficulty(local12)) Then
                                        local35 = local12
                                        Exit
                                    EndIf
                                Next
                                If (server\Field21 = $01) Then
                                    server\Field9 = $01
                                    If (gameinfo\Field5\Field1 = $00) Then
                                        If (server\Field29 <> 0) Then
                                            server\Field30 = $01
                                        EndIf
                                        gameinfo\Field5\Field1 = ((millisecs() + server\Field22) + $15F90)
                                        gameinfo\Field5\Field4 = (millisecs() + $15F90)
                                        gameinfo\Field5\Field2 = (millisecs() + $15F90)
                                    EndIf
                                    If (gameinfo\Field5\Field4 < millisecs()) Then
                                        setplayertype(local1\Field30, $00)
                                    ElseIf (server\Field54 <> 0) Then
                                        gameinfo\Field5\Field1 = ((millisecs() + server\Field22) + $15F90)
                                        gameinfo\Field5\Field4 = (millisecs() + $15F90)
                                        gameinfo\Field5\Field2 = (millisecs() + $15F90)
                                    EndIf
                                Else
                                    setplayertype(local1\Field30, classd_model)
                                    local1\Field73 = classd_model
                                EndIf
                                giveplayerhealth(local1\Field30, 100.0, "")
                                If (mainplayer = $00) Then
                                    mainplayer = local0
                                ElseIf (player[mainplayer]\Field55 <> 0) Then
                                    mainplayer = local0
                                EndIf
                                addlog((local1\Field15 + " has joined the server"), $00, $01, $00)
                                clearchatforplayer(local0)
                                mp_createplayerobject(local0)
                                If (server\Field9 <> 0) Then
                                    If (((server\Field8 = $00) And (server\Field21 = $00)) <> 0) Then
                                        For local36 = Each rooms
                                            If (local36\Field7\Field10 = "start") Then
                                                local1\Field0 = (entityx(local36\Field2, $00) + (3584.0 * roomscale))
                                                local1\Field1 = (704.0 * roomscale)
                                                local1\Field2 = (entityz(local36\Field2, $00) + (1024.0 * roomscale))
                                                local1\Field3 = 130.3
                                                local1\Field32 = local36\Field69
                                                local1\Field37 = $0B
                                                mp_updateplayerposition(local1, $00)
                                                mp_setroomnametoplayer(local1)
                                                local1\Field97 = entityx(local1\Field62, $00)
                                                local1\Field98 = entityy(local1\Field62, $00)
                                                local1\Field99 = entityz(local1\Field62, $00)
                                                local1\Field100 = local1\Field32
                                                Exit
                                            EndIf
                                        Next
                                    Else
                                        local37 = $00
                                        For local11 = Each events
                                            If (local11\Field22 = $00) Then
                                                local37 = $01
                                                Exit
                                            EndIf
                                        Next
                                        If ((local37 Or server\Field21) <> 0) Then
                                            For local36 = Each rooms
                                                If (local36\Field7\Field10 = "173") Then
                                                    If (server\Field21 <> 0) Then
                                                        local1\Field0 = entityx(local36\Field25[$05], $01)
                                                        local1\Field1 = 2.0
                                                        local1\Field2 = entityz(local36\Field25[$05], $01)
                                                    Else
                                                        local1\Field0 = entityx(local36\Field2, $00)
                                                        local1\Field1 = 1.0
                                                        local1\Field2 = entityz(local36\Field2, $00)
                                                    EndIf
                                                    local1\Field3 = 130.3
                                                    local1\Field32 = local36\Field69
                                                    local1\Field37 = $0B
                                                    mp_updateplayerposition(local1, $00)
                                                    mp_setroomnametoplayer(local1)
                                                    local1\Field97 = entityx(local1\Field62, $00)
                                                    local1\Field98 = entityy(local1\Field62, $00)
                                                    local1\Field99 = entityz(local1\Field62, $00)
                                                    local1\Field100 = local1\Field32
                                                    Exit
                                                EndIf
                                            Next
                                        Else
                                            For local36 = Each rooms
                                                If (local36\Field7\Field10 = "start") Then
                                                    local1\Field0 = (entityx(local36\Field2, $00) + (3584.0 * roomscale))
                                                    local1\Field1 = (704.0 * roomscale)
                                                    local1\Field2 = (entityz(local36\Field2, $00) + (1024.0 * roomscale))
                                                    local1\Field3 = 130.3
                                                    local1\Field32 = local36\Field69
                                                    local1\Field37 = $0B
                                                    mp_updateplayerposition(local1, $00)
                                                    mp_setroomnametoplayer(local1)
                                                    local1\Field97 = entityx(local1\Field62, $00)
                                                    local1\Field98 = entityy(local1\Field62, $00)
                                                    local1\Field99 = entityz(local1\Field62, $00)
                                                    local1\Field100 = local1\Field32
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                Else
                                    local1\Field1 = -100000.0
                                    mp_updateplayerposition(local1, $00)
                                EndIf
                                udp_writebyte($7E)
                                udp_writebyte(local0)
                                udp_writebyte(local1\Field36)
                                udp_writebyte(local1\Field39)
                                udp_writebyte(local35)
                                udp_sendmessage(local0)
                                If (getscripts() <> 0) Then
                                    public_addparam(public_inqueue($23, $00), (Str local0), $01)
                                    callback($00)
                                EndIf
                                If (server\Field46 <> "") Then
                                    sendfile(local0, server\Field46, ("servermaps\" + strippath(server\Field46)), $00, $00, $00)
                                EndIf
                            Else
                                If (getscripts() <> 0) Then
                                    public_inqueue($42, $00)
                                    public_addparam($00, local25\Field2, $03)
                                    public_addparam($00, dottedip(arg1), $03)
                                    public_addparam($00, (Str local25\Field7), $01)
                                    public_addparam($00, local25\Field3, $03)
                                    public_addparam($00, (Str local25\Field6), $01)
                                    public_addparam($00, (Str local33), $01)
                                    callback($00)
                                EndIf
                                If (se_return_value\Field8 = $00) Then
                                    addlog(((((local25\Field2 + " bad authorization ticket [") + (Str local33)) + "]: ") + dottedip(arg1)), $00, $00, $00)
                                EndIf
                                local38 = "Unknown"
                                Select local33
                                    Case $01
                                        local38 = "UserNotConnectedToSteam"
                                    Case $02
                                        local38 = "NoLicenseOrExpired"
                                    Case $03
                                        local38 = "VACBanned"
                                    Case $04
                                        local38 = "LoggedInElseWhere"
                                    Case $05
                                        local38 = "VACCheckTimedOut"
                                    Case $06
                                        local38 = "AuthTicketCanceled"
                                    Case $07
                                        local38 = "AuthTicketInvalidAlreadyUsed"
                                    Case $08
                                        local38 = "AuthTicketInvalid"
                                    Case $09
                                        local38 = "PublisherIssuedBan"
                                    Case $0A
                                        local38 = "Central Server Banned"
                                End Select
                                udp_writebyte($71)
                                udp_writeline(("SteamError: " + local38))
                                sendudpmsg(server\Field0, arg1, arg2)
                            EndIf
                            local25\Field11 = $02
                            Return $00
                        EndIf
                    EndIf
                EndIf
            Next
        Case $01
            Select readbyte(server\Field0)
                Case $00
                    local1\Field25 = readbyte(server\Field0)
                    If (readbyte(server\Field0) <> $00) Then
                        local1\Field22 = $01
                    EndIf
                    local1\Field47 = readbyte(server\Field0)
                    local1\Field48 = readbyte(server\Field0)
                    local1\Field49 = readbyte(server\Field0)
                    local1\Field53 = readbyte(server\Field0)
                Case $01
                    local1\Field3 = convertshorttovalue((Float readshort(server\Field0)))
                    local1\Field16 = convertshorttovalue((Float readshort(server\Field0)))
                    local1\Field142 = local1\Field3
                    local1\Field143 = local1\Field16
                    If (server\Field48 < millisecs()) Then
                        readfloat(server\Field0)
                    Else
                        local1\Field17 = readfloat(server\Field0)
                    EndIf
                    local1\Field76 = readbyte(server\Field0)
                    local1\Field20 = readbool(local1\Field76, $00)
                    local1\Field19 = readbool(local1\Field76, $01)
                    local1\Field18 = readbool(local1\Field76, $02)
                    local1\Field21 = readbool(local1\Field76, $03)
                    local1\Field126 = readbool(local1\Field76, $06)
                    local1\Field27 = (Float readbyte(server\Field0))
                    local1\Field38 = readbyte(server\Field0)
                    local1\Field35 = (readbyte(server\Field0) * (mp_isascp(local1\Field36) = $00))
                    If (readbool(local1\Field38, $00) <> $00) Then
                        local1\Field22 = $01
                    EndIf
                    local1\Field58 = (readbool(local1\Field38, $05) = $00)
                    local1\Field56 = readshort(server\Field0)
                    If (local1\Field56 < $3E8) Then
                        If (m_item[local1\Field56] <> Null) Then
                            If (m_item[local1\Field56]\Field22 <> local1\Field30) Then
                                local1\Field56 = $00
                            EndIf
                        EndIf
                    EndIf
                    local1\Field47 = readbyte(server\Field0)
                    local1\Field48 = readbyte(server\Field0)
                    local1\Field49 = readbyte(server\Field0)
                    local1\Field53 = readbyte(server\Field0)
                    local1\Field85 = readfloat(server\Field0)
                    local1\Field37 = readbyte(server\Field0)
                    local1\Field164 = readshort(server\Field0)
                    local1\Field26 = (Float ((local1\Field37 >= $05) And (local1\Field37 <= $0A)))
                    If (local1\Field163 = local1\Field164) Then
                        local1\Field0 = readfloat(server\Field0)
                        local1\Field1 = readfloat(server\Field0)
                        local1\Field2 = readfloat(server\Field0)
                        local41 = readbyte(server\Field0)
                        If (local41 < $C8) Then
                            If (room[local41] <> Null) Then
                                local1\Field32 = local41
                                mp_setroomnametoplayer(local1)
                            EndIf
                        EndIf
                    Else
                        readignorebytes($0D)
                    EndIf
                    If (readbool(local1\Field38, $07) <> 0) Then
                        local1\Field176 = ((local1\Field176 Mod $01) + $01)
                        local1\Field175[local1\Field176] = createbytestream($17)
                        readbytes(getbytestreamdata(local1\Field175[local1\Field176]), server\Field0, $00, $17)
                    EndIf
                    local1\Field57 = readbyte(server\Field0)
            End Select
            If (readavail(server\Field0) <= server\Field82) Then
                While (readavail(server\Field0) > $00)
                    acceptmicrobytepacket(readbyte(server\Field0), arg1, arg2, local0, local1)
                Wend
            EndIf
            If (getscripts() <> 0) Then
                public_addparam(public_inqueue($25, $00), (Str local0), $01)
                callback($00)
            EndIf
    End Select
    Return $00
End Function
