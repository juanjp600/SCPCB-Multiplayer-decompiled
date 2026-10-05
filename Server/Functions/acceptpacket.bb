Function acceptpacket%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1.players
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10.querys
    Local local11#
    Local local12.events
    Local local13%
    Local local14%
    Local local16.bs
    Local local17%
    Local local18.items
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local24#
    Local local25%
    Local local26$
    Local local27%
    Local local28$
    Local local29$
    Local local31.players
    Local local32.rcon
    Local local33%
    Local local34%
    Local local35%
    Local local36$
    Local local37$
    Local local38$
    Local local39%
    Local local40%
    Local local41%
    Local local42%
    Local local43$
    Local local44%
    Local local45.authconnection
    Local local46.steaminstances
    Local local47$
    Local local48$
    Local local49.banned
    Local local50%
    Local local52%
    Local local53.antiddos
    Local local54%
    Local local55.rooms
    Local local56%
    Local local57$
    Local local59%
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
            If (server\Field56 = $00) Then
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
                local5 = readavail(server\Field0)
                If (local5 > $10000) Then
                    local5 = $10000
                EndIf
                local6 = createbank(local5)
                readbytes(local6, server\Field0, $00, local5)
                public_inqueue($0B, $00)
                public_addparam($00, (Str local0), $01)
                public_addparam($00, (Str local6), $01)
                callback($00)
                freebank(local6)
            EndIf
        Case $6F
            local7 = readint(server\Field0)
            local8 = readint(server\Field0)
            local9 = readshort(server\Field0)
            local9 = (Int min(max(1.0, (Float local9)), 4000.0))
            For local10 = Each querys
                If (local10\Field3 = local0) Then
                    If ((Handle local10) = local7) Then
                        local10\Field4 = local9
                        local10\Field1 = (Int min(max((Float local8), 0.0), (Float local10\Field2)))
                        If (local10\Field1 < local10\Field2) Then
                            resizebank(query_global_data, local10\Field4)
                            seekfile(local10\Field5, local10\Field1)
                            resizebank(query_global_data, (Int min((Float local10\Field4), (Float (local10\Field2 - filepos(local10\Field5))))))
                            readbytes(query_global_data, local10\Field5, $00, banksize(query_global_data))
                            udp_writebyte($70)
                            udp_writebyte($01)
                            udp_writeline(local10\Field0)
                            udp_writeint((Handle local10))
                            udp_writeint(local10\Field1)
                            udp_writeint(local10\Field2)
                            udp_writebytes(query_global_data, $00, banksize(query_global_data))
                            udp_writebyte(local10\Field6)
                            udp_writeint(local10\Field8)
                            udp_sendmessage(local10\Field3)
                            local10\Field7 = (millisecs() + $14)
                        Else
                            local10\Field1 = (local10\Field2 + $01)
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
                local11 = readfloat(server\Field0)
                For local12 = Each events
                    If (local12\Field0 = "173") Then
                        local12\Field4 = local11
                        For local13 = $01 To server\Field18 Step $01
                            If (((player[local13] <> Null) And (local13 <> local0)) <> 0) Then
                                udp_writebyte(arg0)
                                udp_writebyte(local0)
                                udp_writefloat(local11)
                                udp_sendmessage(local13)
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
                    For local12 = Each events
                        If (local12\Field0 = "room106") Then
                            If (0.0 = local12\Field2) Then
                                local12\Field2 = 1.0
                                If (soundtransmission = $01) Then
                                    If (local12\Field6 <> $00) Then
                                        If (channelplaying(local12\Field6) <> 0) Then
                                            stopchannel(local12\Field6)
                                        EndIf
                                    EndIf
                                    femurbreakersfx = loadsound_strict("SFX\Room\106Chamber\FemurBreaker.ogg")
                                    local12\Field6 = playsound_strict(femurbreakersfx)
                                EndIf
                                For local13 = $01 To server\Field18 Step $01
                                    If (player[local13] <> Null) Then
                                        udp_writebyte(arg0)
                                        udp_writebyte(local0)
                                        udp_sendmessage(local13)
                                    EndIf
                                Next
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
            EndIf
        Case $07
            local14 = readint(server\Field0)
            If (getscripts() <> 0) Then
                local4 = public_inqueue($15, $00)
                public_addparam(local4, (Str local0), $01)
                public_addparam(local4, (Str local14), $01)
                callback($00)
            EndIf
            If (((se_getreturnvalue() = "0") Or (se_getreturnvalue() = "-1")) <> 0) Then
                For local13 = $01 To server\Field18 Step $01
                    If (((player[local13] <> Null) And (local13 <> local0)) <> 0) Then
                        udp_writebyte(arg0)
                        udp_writebyte(local0)
                        udp_writeint(local14)
                        udp_sendmessage(local13)
                    EndIf
                Next
            EndIf
        Case $0D
            kick(local0, (local1\Field15 + " has left the server"), "")
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
                If (((readavail(server\Field0) < $01) Or server\Field64) <> 0) Then
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
                    If (server\Field64 <> 0) Then
                        For local13 = $00 To $13 Step $01
                            If (server\Field60[local13] <> "") Then
                                udp_writeline(server\Field60[local13])
                            EndIf
                        Next
                        udp_writeline("")
                        udp_writebyte(server\Field87\Field7)
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
                            udp_writebyte(server\Field87\Field7)
                        Case $02
                            udp_writeint($236357)
                            udp_writebyte($02)
                            udp_writeline(server\Field42)
                            udp_writeline(mp_version)
                            udp_writeline(server\Field44)
                        Case $03
                            udp_writeint($236357)
                            udp_writebyte($03)
                            For local13 = $00 To $13 Step $01
                                If (server\Field60[local13] <> "") Then
                                    udp_writeline(server\Field60[local13])
                                EndIf
                            Next
                    End Select
                EndIf
                sendudpmsg(server\Field0, arg1, arg2)
            EndIf
        Case $6B
            If ((((player[local0]\Field36 > $00) And (player[local0]\Field61 = $00)) And (player[local0]\Field141 = $00)) <> 0) Then
                local16 = createbytestream($17)
                local17 = readshort(server\Field0)
                If (local17 < $3E8) Then
                    local18 = m_item[local17]
                    If (local18 <> Null) Then
                        If (((local18\Field22 = player[local0]\Field30) And (isagun(local18\Field3\Field2) = player[local0]\Field35)) <> 0) Then
                            local19 = readfloat(server\Field0)
                            local20 = readfloat(server\Field0)
                            local21 = readfloat(server\Field0)
                            local22 = readfloat(server\Field0)
                            local23 = readfloat(server\Field0)
                            local24 = max(((Float readbyte(server\Field0)) / 10.0), 0.7)
                            If (((mp_isascp(player[local0]\Field36) = $00) And (4.0 > distance3(local19, local20, local21, entityx(player[local0]\Field64, $00), entityy(player[local0]\Field64, $00), entityz(player[local0]\Field64, $00)))) <> 0) Then
                                If (getscripts() <> 0) Then
                                    local4 = public_inqueue($0D, $00)
                                    public_addparam(local4, (Str player[local0]\Field30), $01)
                                    public_addparam(local4, (Str local19), $02)
                                    public_addparam(local4, (Str local20), $02)
                                    public_addparam(local4, (Str local21), $02)
                                    public_addparam(local4, (Str local23), $02)
                                    public_addparam(local4, (Str local22), $02)
                                    callback($00)
                                EndIf
                                If (se_return_value\Field8 = $00) Then
                                    If (((local23 = player[local0]\Field4) Or (local22 = player[local0]\Field5)) <> 0) Then
                                        oncheatdetected(player[local0]\Field30, $07)
                                    EndIf
                                    player[local0]\Field4 = local23
                                    player[local0]\Field5 = local22
                                    local25 = getgunshootticks(player[local0]\Field35)
                                    For local13 = $01 To local25 Step $01
                                        createbullet(player[local0]\Field30, 0.6, local19, local20, local21, (rnd((getgunspreadrate(player[local0]\Field35) * (- local24)), (getgunspreadrate(player[local0]\Field35) * local24)) + local22), (rnd((getgunspreadrate(player[local0]\Field35) * (- local24)), (getgunspreadrate(player[local0]\Field35) * local24)) + local23), player[local0]\Field35)
                                    Next
                                    bytestreamwriteshort(local16, $00)
                                    bytestreamwritefloat(local16, local19)
                                    bytestreamwritefloat(local16, local20)
                                    bytestreamwritefloat(local16, local21)
                                    bytestreamwritefloat(local16, local22)
                                    bytestreamwritefloat(local16, local23)
                                    bytestreamwritechar(local16, (Int (local24 * 10.0)))
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
                For local13 = $01 To server\Field11 Step $01
                    If (50.0 > distance3(local19, local20, local21, entityx(playeroptimize[local13]\Field64, $00), entityy(playeroptimize[local13]\Field64, $00), entityz(playeroptimize[local13]\Field64, $00))) Then
                        udp_writebyte($6B)
                        udp_writebyte(player[local0]\Field30)
                        udp_writebytes(getbytestreamdata(local16), $00, getbytestreamdatasize(local16))
                        udp_sendmessage(playeroptimize[local13]\Field30)
                    EndIf
                Next
                removebytestream(local16)
            EndIf
        Case $0B
            If (local1\Field127 < millisecs()) Then
                local26 = left(readline(server\Field0), $50)
                local27 = readbyte(server\Field0)
                If (instr(local26, "/rcon", $01) <> 0) Then
                    local26 = right(local26, (len(local26) - $02))
                    local28 = rcon_findcmd(local26)
                    If (local28 = "Not found") Then
                        Return addtexttochat("[RCON] Command not found", local0)
                    EndIf
                    local29 = rcon_getattribute(local26)
                    If (local1\Field41 = $00) Then
                        If (local28 = "login") Then
                            If (server\Field28 = "") Then
                                Return addtexttochat("[RCON] RCON switched off", local0)
                            EndIf
                            If (server\Field28 <> local29) Then
                                addtexttochat("[RCON] Wrong password", local0)
                                If (getscripts() <> 0) Then
                                    public_addparam(public_inqueue($16, $00), (Str local0), $01)
                                    callback($00)
                                EndIf
                            Else
                                If (getscripts() <> 0) Then
                                    public_addparam(public_inqueue($17, $00), (Str local0), $01)
                                    callback($00)
                                EndIf
                                If (se_return_value\Field8 = $00) Then
                                    addtexttochat("[RCON] You got the admin role.", local0)
                                    local1\Field41 = $01
                                EndIf
                            EndIf
                        Else
                            addtexttochat("[RCON] You are not an admin", local0)
                        EndIf
                        Return $00
                    Else
                        Select rcon_executecmd(local28, local29)
                            Case "login"
                                addtexttochat("[RCON] You already have the admin permission", local0)
                            Case "status"
                                For local31 = Each players
                                    addtexttochat((((local31\Field15 + " (Ping ") + (Str local31\Field33)) + ")"), local0)
                                Next
                            Case "commands"
                                For local32 = Each rcon
                                    addtexttochat(("[RCON] " + local32\Field0), local0)
                                Next
                            Case "gravity"
                                addlog(("Gravity changed to " + local29), $00, $01, $00, $C0, $C0, $C0)
                            Case "hostname"
                                addlog(("Hostname changed to " + local29), $00, $01, $00, $C0, $C0, $C0)
                            Case "hostname"
                                addlog(("Hostname changed to " + local29), $00, $01, $00, $C0, $C0, $C0)
                            Case "size"
                                changeplayersize(local0, (Int local29))
                                addtexttochat(("[RCON] Your size changed to " + (Str player[local0]\Field28)), local0)
                            Case "getip"
                                For local31 = Each players
                                    If (instr(lower(local31\Field15), lower(local29), $01) <> 0) Then
                                        addtexttochat(("Player IP: " + local31\Field40), local0)
                                        Exit
                                    EndIf
                                Next
                            Case "getipid"
                                For local31 = Each players
                                    If (local31\Field30 = (Int local29)) Then
                                        addtexttochat(("Player IP: " + local31\Field40), local0)
                                        Exit
                                    EndIf
                                Next
                            Case "getid"
                                For local31 = Each players
                                    If (instr(lower(local31\Field15), lower(local29), $01) <> 0) Then
                                        addtexttochat(("Player ID: " + (Str local31\Field30)), local0)
                                        Exit
                                    EndIf
                                Next
                        End Select
                    EndIf
                ElseIf (local27 = $01) Then
                    If (getscripts() <> 0) Then
                        local26 = getformattedtext(local26)
                        local33 = public_inqueue($18, $00)
                        public_addparam(local33, (Str local0), $01)
                        public_addparam(local33, local26, $03)
                        callback($00)
                        If (se_return_value\Field8 = $00) Then
                            If ((server\Field21 And (server\Field47 = $00)) <> 0) Then
                                Return $00
                            EndIf
                            If (((server\Field56 And instr(local26, "killed", $01)) And (instr(local26, ":", $01) = $00)) <> 0) Then
                                Return $00
                            EndIf
                            If (local1\Field142 = $00) Then
                                addlog((local1\Field15 + local26), $00, $01, $00, $C0, $C0, $C0)
                            EndIf
                        EndIf
                    Else
                        If (((server\Field56 And instr(local26, "killed", $01)) And (instr(local26, ":", $01) = $00)) <> 0) Then
                            Return $00
                        EndIf
                        If ((server\Field21 And (server\Field47 = $00)) <> 0) Then
                            Return $00
                        EndIf
                        If (local1\Field142 = $00) Then
                            local26 = getformattedtext(local26)
                            addlog((local1\Field15 + local26), $00, $01, $00, $C0, $C0, $C0)
                        EndIf
                    EndIf
                Else
                    local26 = getformattedtext(local26)
                    addtexttochat(local26, local0)
                EndIf
                local1\Field127 = (millisecs() + $FA)
                Return $00
            EndIf
            readignoreline()
            readignorebytes($01)
        Case $7B
            If (server\Field10 <> 0) Then
                If (local1\Field142 = $00) Then
                    For local13 = $01 To server\Field11 Step $01
                        If ((playeroptimize[local13]\Field22 Or (server\Field9 = $00)) <> 0) Then
                            If ((((((server\Field9 = $00) Or (15.0 >= entitydistance(playeroptimize[local13]\Field64, local1\Field64))) Or ((playeroptimize[local13]\Field59 = local1\Field59) And (local1\Field59 <> $00))) Or (local1\Field122 = $01)) Or ((local1\Field36 <> $00) Or (playeroptimize[local13]\Field36 = local1\Field36))) <> 0) Then
                                udp_writebyte($7B)
                                udp_writebyte(local0)
                                udp_sendmessage(playeroptimize[local13]\Field30)
                            EndIf
                        EndIf
                    Next
                EndIf
            EndIf
        Case $1D
            If (server\Field10 <> 0) Then
                If (local1\Field142 = $00) Then
                    local34 = readavail(server\Field0)
                    If (local34 > $4000) Then
                        local34 = $4000
                    EndIf
                    local35 = createbank(local34)
                    readbytes(local35, server\Field0, $00, local34)
                    If (getscripts() <> 0) Then
                        local4 = public_inqueue($21, $00)
                        public_addparam(local4, (Str local0), $01)
                        public_addparam(local4, (Str local35), $01)
                        public_addparam(local4, (Str local1\Field59), $01)
                        public_addparam(local4, (Str local1\Field122), $01)
                        callback($00)
                        If (se_return_value\Field8 <> 0) Then
                            freebank(local35)
                            Return $00
                        EndIf
                    EndIf
                    For local13 = $01 To server\Field11 Step $01
                        If ((playeroptimize[local13]\Field22 Or (server\Field9 = $00)) <> 0) Then
                            If ((((((server\Field9 = $00) Or (15.0 >= entitydistance(playeroptimize[local13]\Field64, local1\Field64))) Or ((playeroptimize[local13]\Field59 = local1\Field59) And (local1\Field59 <> $00))) Or (local1\Field122 = $01)) Or ((local1\Field36 <> $00) Or (playeroptimize[local13]\Field36 = local1\Field36))) <> 0) Then
                                udp_writebyte($1D)
                                udp_writebyte(local0)
                                udp_writebytes(local35, $00, banksize(local35))
                                udp_writebyte(local1\Field59)
                                udp_sendmessage(playeroptimize[local13]\Field30)
                            EndIf
                        EndIf
                    Next
                    freebank(local35)
                EndIf
            EndIf
        Case $1A
            If (isconnectionspam(arg1, $10, $3E8, $00) <> 0) Then
                Return $00
            EndIf
            local36 = readlinesafe(server\Field0)
            local37 = readline(server\Field0)
            local38 = readline(server\Field0)
            local39 = readbyte(server\Field0)
            local40 = readshort(server\Field0)
            local41 = readshort(server\Field0)
            local42 = readbyte(server\Field0)
            local43 = readline(server\Field0)
            If ((((((((local43 = "") Or (local41 = $00)) Or (local40 = $00)) Or (local39 = $00)) Or (local37 = "")) Or (len(local36) > $18)) Or (len(local37) > $08)) <> 0) Then
                Return $00
            EndIf
            local42 = $00
            local44 = $00
            For local45 = Each authconnection
                local44 = (local44 + $01)
                If (local45\Field7 = local43) Then
                    Return $00
                ElseIf (local45\Field0 = arg1) Then
                    Return $00
                EndIf
            Next
            If (local44 >= $C8) Then
                For local45 = Each authconnection
                    removeauthconnection(local45)
                Next
            EndIf
            For local13 = $01 To server\Field11 Step $01
                If (playeroptimize[local13]\Field13 = arg1) Then
                    If (playeroptimize[local13]\Field14 = arg2) Then
                        Return $00
                    EndIf
                EndIf
            Next
            addlog((((((local36 + " incoming connection: ") + dottedip(arg1)) + " [") + local43) + "]"), $00, $00, $00, $C0, $C0, $C0)
            incomingversion = local37
            incomingpatron = local42
            For local46 = Each steaminstances
                If ((Str local46\Field0) = local43) Then
                    incomingpatron = (local46\Field1 = "PATRON")
                    Exit
                EndIf
            Next
            local47 = dottedip(arg1)
            local48 = ""
            If (getscripts() <> 0) Then
                public_inqueue($22, $00)
                public_addparam($00, local36, $03)
                public_addparam($00, local47, $03)
                public_addparam($00, (Str steam_id64to32(local43)), $01)
                public_addparam($00, local37, $03)
                public_addparam($00, (Str local42), $01)
                callback($00)
            EndIf
            If (instr(local36, "%", $01) <> 0) Then
                local48 = "Invalid syntax , please change your nickname!"
            EndIf
            If (local38 <> server\Field14) Then
                local48 = "Wrong password."
            EndIf
            If (local36 = "") Then
                local48 = "You cant have an empty nickname."
            ElseIf (server\Field87\Field8 = $00) Then
                For local31 = Each players
                    If (lower(local31\Field15) = lower(local36)) Then
                        local48 = "A player with this nickname is already on the server."
                        Exit
                    EndIf
                Next
            EndIf
            For local49 = Each banned
                If (((local49\Field1 = local47) Or (local49\Field2 = steam_id64to32(local43))) <> 0) Then
                    local48 = "You've been banned from the server."
                    Exit
                EndIf
            Next
            If (playeriscidrbanned(local47) <> 0) Then
                local48 = "You've been banned from the server."
            EndIf
            If (((isaccessversion(local37) = $00) Or (local39 <> $02)) <> 0) Then
                local48 = (((("Version doesn't match" + chr($0D)) + chr($0A)) + "Server version: ") + mp_version)
            EndIf
            If (server\Field11 = server\Field18) Then
                local48 = "Server is full"
            EndIf
            If (getscripts() <> 0) Then
                If (se_getreturnvalue() <> "-1") Then
                    local48 = se_getreturnvalue()
                EndIf
            EndIf
            If (local48 <> "") Then
                udp_writebyte($71)
                udp_writeline(local48)
                sendudpmsg(server\Field0, arg1, arg2)
                addlog(((local36 + " could not connect due to: ") + local48), $00, $00, $00, $C0, $C0, $C0)
                Return $00
            EndIf
            If (server\Field21 = $01) Then
                server\Field9 = $01
            EndIf
            local45 = (New authconnection)
            local45\Field8 = (millisecs() + $1388)
            local45\Field0 = arg1
            local45\Field1 = arg2
            local45\Field2 = local36
            local45\Field4 = local40
            local45\Field5 = local41
            local45\Field6 = local42
            local45\Field7 = local43
            local45\Field3 = local37
            If (server\Field87\Field7 <> 0) Then
                local50 = readavail(server\Field0)
                If (local50 > $400) Then
                    local50 = $400
                EndIf
                local45\Field9 = createbank(local50)
                readbytes(local45\Field9, server\Field0, $00, local50)
                local45\Field10 = validateauthticket(local45)
                Select local45\Field10
                    Case $00
                    Case $01
                        local48 = "The auth ticket is invalid."
                    Case $02
                        local48 = "This SteamID already has an active auth ticket."
                    Case $03
                        local48 = "The Steam version is invalid."
                    Case $04
                        local48 = "You've been globally banned."
                    Case $05
                        local48 = "The auth ticket has expired. Please try again later."
                    Case $FFFFFFFF
                        local48 = "The server is currently unable to connect to Steam. Please try again later."
                    Default
                        local48 = (("Authentication failed (Error " + (Str local45\Field10)) + ")")
                End Select
                If (local48 <> "") Then
                    udp_writebyte($71)
                    udp_writeline(local48)
                    sendudpmsg(server\Field0, arg1, arg2)
                    addlog(((local36 + " could not connect due to: ") + local48), $00, $00, $00, $C0, $C0, $C0)
                    removeauthconnection(local45)
                    Return $00
                EndIf
            Else
                sendserverdatatoplayer(arg1, arg2)
            EndIf
        Case $7E
            For local45 = Each authconnection
                If (local45\Field0 = arg1) Then
                    If (local45\Field1 = arg2) Then
                        local52 = local45\Field10
                        If (((local52 = $00) And ((server\Field18 = server\Field11) = $00)) <> 0) Then
                            For local53 = Each antiddos
                                If (local53\Field0 = arg1) Then
                                    Delete local53
                                EndIf
                            Next
                            local0 = findfreeplayerid()
                            createplayer(local0)
                            local1 = player[local0]
                            local1\Field73 = local45\Field4
                            local1\Field74 = local45\Field5
                            local1\Field77 = local45\Field6
                            local1\Field56 = local45\Field3
                            setplayertype(local1\Field30, model_wait)
                            local1\Field23 = (millisecs() + server\Field13)
                            local1\Field13 = arg1
                            local1\Field33 = $05
                            local1\Field40 = dottedip(arg1)
                            local1\Field131 = steam_id64to32(local45\Field7)
                            local1\Field132 = local45\Field7
                            local1\Field15 = local45\Field2
                            local1\Field14 = arg2
                            local1\Field39 = rand($01, $03)
                            local1\Field72 = (millisecs() + $EA60)
                            For local46 = Each steaminstances
                                If (local46\Field0 = local1\Field131) Then
                                    local1\Field160 = local46\Field1
                                    local1\Field161 = local46\Field2
                                    local1\Field162 = local46\Field3
                                    local1\Field163 = local46\Field4
                                    Exit
                                EndIf
                            Next
                            local54 = $00
                            For local13 = $00 To $02 Step $01
                                If (lower(server\Field26) = getnamedifficulty(local13)) Then
                                    local54 = local13
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
                                ElseIf (server\Field53 <> 0) Then
                                    gameinfo\Field5\Field1 = ((millisecs() + server\Field22) + $15F90)
                                    gameinfo\Field5\Field4 = (millisecs() + $15F90)
                                    gameinfo\Field5\Field2 = (millisecs() + $15F90)
                                EndIf
                            Else
                                setplayertype(local1\Field30, classd_model)
                                local1\Field75 = classd_model
                            EndIf
                            giveplayerhealth(local1\Field30, 100.0, "")
                            If (mainplayer = $00) Then
                                mainplayer = local0
                            ElseIf (player[mainplayer]\Field57 <> 0) Then
                                mainplayer = local0
                            EndIf
                            clearchatforplayer(local0)
                            mp_createplayerobject(local0)
                            If (server\Field9 <> 0) Then
                                If (((server\Field8 = $00) And (server\Field21 = $00)) <> 0) Then
                                    For local55 = Each rooms
                                        If (local55\Field7\Field10 = "start") Then
                                            local1\Field0 = (entityx(local55\Field2, $00) + 14.0)
                                            local1\Field1 = 2.75
                                            local1\Field2 = (entityz(local55\Field2, $00) + 4.0)
                                            local1\Field3 = 130.3
                                            local1\Field32 = local55\Field69
                                            local1\Field37 = $0B
                                            mp_updateplayerposition(local1, $00)
                                            mp_setroomnametoplayer(local1)
                                            local1\Field99 = entityx(local1\Field64, $00)
                                            local1\Field100 = entityy(local1\Field64, $00)
                                            local1\Field101 = entityz(local1\Field64, $00)
                                            local1\Field102 = local1\Field32
                                            Exit
                                        EndIf
                                    Next
                                Else
                                    local56 = $00
                                    For local12 = Each events
                                        If (local12\Field22 = $00) Then
                                            local56 = $01
                                            Exit
                                        EndIf
                                    Next
                                    If ((local56 Or server\Field21) <> 0) Then
                                        For local55 = Each rooms
                                            If (local55\Field7\Field10 = "173") Then
                                                If (server\Field21 <> 0) Then
                                                    local1\Field0 = entityx(local55\Field25[$05], $01)
                                                    local1\Field1 = 2.0
                                                    local1\Field2 = entityz(local55\Field25[$05], $01)
                                                Else
                                                    local1\Field0 = entityx(local55\Field2, $00)
                                                    local1\Field1 = 1.0
                                                    local1\Field2 = entityz(local55\Field2, $00)
                                                EndIf
                                                local1\Field3 = 130.3
                                                local1\Field32 = local55\Field69
                                                local1\Field37 = $0B
                                                mp_updateplayerposition(local1, $00)
                                                mp_setroomnametoplayer(local1)
                                                local1\Field99 = entityx(local1\Field64, $00)
                                                local1\Field100 = entityy(local1\Field64, $00)
                                                local1\Field101 = entityz(local1\Field64, $00)
                                                local1\Field102 = local1\Field32
                                                Exit
                                            EndIf
                                        Next
                                    Else
                                        For local55 = Each rooms
                                            If (local55\Field7\Field10 = "start") Then
                                                local1\Field0 = (entityx(local55\Field2, $00) + 14.0)
                                                local1\Field1 = 2.75
                                                local1\Field2 = (entityz(local55\Field2, $00) + 4.0)
                                                local1\Field3 = 130.3
                                                local1\Field32 = local55\Field69
                                                local1\Field37 = $0B
                                                mp_updateplayerposition(local1, $00)
                                                mp_setroomnametoplayer(local1)
                                                local1\Field99 = entityx(local1\Field64, $00)
                                                local1\Field100 = entityy(local1\Field64, $00)
                                                local1\Field101 = entityz(local1\Field64, $00)
                                                local1\Field102 = local1\Field32
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
                            udp_writebyte(local54)
                            udp_sendmessage(local0)
                            local57 = (local1\Field15 + " has joined the server")
                            If (getscripts() <> 0) Then
                                public_addparam(public_inqueue($23, $00), (Str local0), $01)
                                callback($00)
                            EndIf
                            If (se_getreturnvalue() <> "-1") Then
                                local57 = se_getreturnvalue()
                            EndIf
                            addlog(local57, $00, $01, $00, $C0, $C0, $C0)
                            removeauthconnection(local45)
                            If (server\Field46 <> "") Then
                                sendfile(local0, server\Field46, ("servermaps\" + strippath(server\Field46)), $00, $00, $00)
                            EndIf
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
                    local1\Field55 = readbyte(server\Field0)
                Case $01
                    local1\Field3 = convertshorttovalue((Float readshort(server\Field0)))
                    local1\Field16 = convertshorttovalue((Float readshort(server\Field0)))
                    local1\Field145 = local1\Field3
                    local1\Field146 = local1\Field16
                    If (server\Field48 < millisecs()) Then
                        readfloat(server\Field0)
                    Else
                        local1\Field17 = readfloat(server\Field0)
                    EndIf
                    local1\Field78 = readbyte(server\Field0)
                    local1\Field20 = readbool(local1\Field78, $00)
                    local1\Field19 = readbool(local1\Field78, $01)
                    local1\Field18 = readbool(local1\Field78, $02)
                    local1\Field21 = readbool(local1\Field78, $03)
                    local1\Field128 = readbool(local1\Field78, $06)
                    local1\Field27 = (Float readbyte(server\Field0))
                    local1\Field38 = readbyte(server\Field0)
                    local1\Field35 = (readbyte(server\Field0) * (mp_isascp(local1\Field36) = $00))
                    If (readbool(local1\Field38, $00) <> $00) Then
                        local1\Field22 = $01
                    EndIf
                    local1\Field60 = (readbool(local1\Field38, $05) = $00)
                    local1\Field58 = readshort(server\Field0)
                    If (local1\Field58 < $3E8) Then
                        If (m_item[local1\Field58] <> Null) Then
                            If (m_item[local1\Field58]\Field22 <> local1\Field30) Then
                                local1\Field58 = $00
                            EndIf
                        EndIf
                    EndIf
                    local1\Field47 = readbyte(server\Field0)
                    local1\Field48 = readbyte(server\Field0)
                    local1\Field49 = readbyte(server\Field0)
                    local1\Field55 = readbyte(server\Field0)
                    local1\Field87 = readfloat(server\Field0)
                    local1\Field37 = readbyte(server\Field0)
                    local1\Field167 = readshort(server\Field0)
                    local1\Field26 = (Float ((local1\Field37 >= $05) And (local1\Field37 <= $0A)))
                    If (local1\Field166 = local1\Field167) Then
                        local1\Field0 = readfloat(server\Field0)
                        local1\Field1 = readfloat(server\Field0)
                        local1\Field2 = readfloat(server\Field0)
                        local59 = readbyte(server\Field0)
                        If (local59 < $C8) Then
                            If (room[local59] <> Null) Then
                                local1\Field32 = local59
                                mp_setroomnametoplayer(local1)
                            EndIf
                        EndIf
                    Else
                        readignorebytes($0D)
                    EndIf
                    If (readbool(local1\Field38, $07) <> 0) Then
                        local1\Field179 = ((local1\Field179 Mod $01) + $01)
                        local1\Field178[local1\Field179] = createbytestream($17)
                        readbytes(getbytestreamdata(local1\Field178[local1\Field179]), server\Field0, $00, $17)
                    EndIf
                    local1\Field59 = readbyte(server\Field0)
            End Select
            If (readavail(server\Field0) <= server\Field80) Then
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
