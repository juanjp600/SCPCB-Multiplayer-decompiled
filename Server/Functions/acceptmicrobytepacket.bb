Function acceptmicrobytepacket%(arg0%, arg1%, arg2%, arg3%, arg4.players)
    Local local1%
    Local local2.items
    Local local3%
    Local local4.items
    Local local5$
    Local local6.rooms
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11$
    Local local12.doors
    Local local13%
    Local local14%
    Local local15$
    Local local16#
    Local local17#
    Local local18#[12]
    Local local19%
    Local local20%
    Local local21%
    Local local22.breachtypes
    Local local23%
    Local local24$
    Local local25%
    Local local26$
    Local local27$
    Local local29.players
    Local local30.rcon
    Local local31%
    Local local32%
    Local local33%
    Local local34#
    Local local35#
    Local local36#
    Local local37%
    Local local38$
    Local local39%
    Local local40%
    Local local41%
    Local local42.events
    Local local43%
    Local local44%
    Local local45#
    Local local46#
    Local local47#
    Local local48#
    Local local49#
    Local local50%
    Local local51%
    Local local53%
    Local local54%
    Local local55.itemtemplates
    arg4\Field22 = $01
    Select arg0
        Case $2C
            If (((arg4\Field59 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                local1 = readshort(server\Field0)
                If (local1 < $3E8) Then
                    local2 = m_item[local1]
                    If (local2 <> Null) Then
                        If (local2\Field22 = arg3) Then
                            If (getscripts() <> 0) Then
                                local3 = public_inqueue($13, $00)
                                public_addparam(local3, (Str arg3), $01)
                                public_addparam(local3, (Str local1), $01)
                                callback($00)
                            EndIf
                            If (se_return_value\Field8 = $00) Then
                                arg4\Field137 = local2\Field3\Field2
                                onplayeruseitem(arg3, local2\Field3\Field2)
                                removeitem(local2, $00)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                Return $00
            EndIf
            readignorebytes($02)
        Case $15
            If ((((mp_isascp(arg4\Field36) = $00) And (arg4\Field36 <> $00)) Or (server\Field21 = $00)) <> 0) Then
                local1 = readshort(server\Field0)
                For local2 = Each items
                    If (local2\Field18 = local1) Then
                        If (local2\Field22 = $00) Then
                            If (1.5 > entitydistance(arg4\Field62, local2\Field1)) Then
                                If (getscripts() <> 0) Then
                                    local3 = public_inqueue($1D, $00)
                                    public_addparam(local3, (Str arg3), $01)
                                    public_addparam(local3, (Str local1), $01)
                                    public_addparam(local3, (Str local2\Field3\Field0), $01)
                                    callback($00)
                                EndIf
                                If (se_return_value\Field8 = $00) Then
                                    If (arg4\Field138 <> 0) Then
                                        sendplayermsg(arg3, "You cannot pick up any items because you handcuffed", $15E)
                                    Else
                                        If (server\Field21 <> 0) Then
                                            For local4 = Each items
                                                If (local4\Field22 = arg3) Then
                                                    If (local4\Field3\Field0 = local2\Field3\Field0) Then
                                                        Return $00
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                        local2\Field15 = $01
                                        local2\Field22 = arg3
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
                Return $00
            EndIf
            readignorebytes($02)
        Case $18
            If (((mp_isascp(arg4\Field36) = $00) Or (server\Field21 = $00)) <> 0) Then
                local1 = readshort(server\Field0)
                For local2 = Each items
                    If (local2\Field18 = local1) Then
                        If (local2\Field22 = arg3) Then
                            If (getscripts() <> 0) Then
                                local3 = public_inqueue($1E, $00)
                                public_addparam(local3, (Str arg3), $01)
                                public_addparam(local3, (Str local1), $01)
                                public_addparam(local3, (Str local2\Field3\Field0), $01)
                                callback($00)
                            EndIf
                            If (se_return_value\Field8 = $00) Then
                                playerdropitem(local2)
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
                Return $00
            EndIf
            readignorebytes($02)
        Case $77
            local5 = readline(server\Field0)
            If (getscripts() <> 0) Then
                public_inqueue($0A, $00)
                public_addparam($00, (Str arg3), $01)
                public_addparam($00, local5, $03)
                callback($00)
            EndIf
            If (se_return_value\Field8 = $00) Then
                onplayerconsole(arg3, local5, $00)
            EndIf
        Case $10
            If (server\Field21 = $00) Then
                If (arg4\Field59 <> 0) Then
                    positionentity(arg4\Field62, arg4\Field97, arg4\Field98, arg4\Field99, $00)
                    resetentity(arg4\Field62)
                    For local6 = Each rooms
                        If (local6\Field69 = arg4\Field100) Then
                            mp_setplayerroomid(arg4, local6)
                            Exit
                        EndIf
                    Next
                    mp_updateplayerposition(arg4, $01)
                    setplayertype(arg4\Field30, classd_model)
                    arg4\Field60 = 100.0
                    arg4\Field61 = 0.0
                EndIf
            EndIf
        Case $82
            If (((server\Field79 = $00) And (arg4\Field36 > $00)) <> 0) Then
                If (((arg4\Field67 = "room2ccont") And ((mp_isascp(arg4\Field36) = $00) Or multiplayer_breach_isa049(arg4\Field36))) <> 0) Then
                    local6 = room[arg4\Field32]
                    If (3.0 > distance3((local6\Field3 - (265.0 * roomscale)), (local6\Field4 + (1280.0 * roomscale)), (local6\Field5 + (105.0 * roomscale)), entityx(arg4\Field62, $00), entityy(arg4\Field62, $00), entityz(arg4\Field62, $00))) Then
                        If (((arg4\Field121 < millisecs()) Or (arg4\Field122 > millisecs())) <> 0) Then
                            arg4\Field120 = (arg4\Field120 = $00)
                            If (arg4\Field120 = $00) Then
                                arg4\Field121 = (millisecs() + server\Field77)
                                arg4\Field122 = $00
                            Else
                                arg4\Field122 = (millisecs() + server\Field78)
                                arg4\Field121 = ((millisecs() + server\Field77) + server\Field78)
                            EndIf
                        Else
                            arg4\Field122 = $00
                            arg4\Field121 = (millisecs() + server\Field77)
                            arg4\Field120 = $00
                        EndIf
                    Else
                        arg4\Field122 = $00
                        arg4\Field121 = (millisecs() + server\Field77)
                        arg4\Field120 = $00
                    EndIf
                Else
                    arg4\Field122 = $00
                    arg4\Field121 = (millisecs() + server\Field77)
                    arg4\Field120 = $00
                EndIf
            EndIf
        Case $17
            If (((arg4\Field59 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                local7 = readshort(server\Field0)
                local8 = readbyte(server\Field0)
                local9 = readbyte(server\Field0)
                local10 = readshort(server\Field0)
                local11 = readline(server\Field0)
                For local12 = Each doors
                    If (local12\Field18 = local7) Then
                        local13 = $00
                        For local14 = $00 To $01 Step $01
                            If (local12\Field3[local14] <> $00) Then
                                If (4.0 > entitydistance(local12\Field3[local14], arg4\Field62)) Then
                                    local13 = $01
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (local13 = $00) Then
                            If (local12\Field30 <> Null) Then
                                For local14 = $00 To $01 Step $01
                                    If (local12\Field30\Field3[local14] <> $00) Then
                                        If (4.0 > entitydistance(local12\Field30\Field3[local14], arg4\Field62)) Then
                                            local13 = $01
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        EndIf
                        If (local13 <> 0) Then
                            If (getscripts() <> 0) Then
                                local3 = public_inqueue($1F, $00)
                                public_addparam(local3, (Str arg3), $01)
                                public_addparam(local3, (Str local7), $01)
                                public_addparam(local3, (Str local8), $01)
                                public_addparam(local3, (Str local9), $01)
                                public_addparam(local3, (Str local10), $01)
                                public_addparam(local3, local11, $03)
                                callback($00)
                            EndIf
                            If (se_return_value\Field8 = $00) Then
                                If (((local12\Field17 = local11) Or (local12\Field17 = "")) <> 0) Then
                                    If (local12\Field23 <> $00) Then
                                        If (local12\Field5 <> 0) Then
                                            If (180.0 = local12\Field7) Then
                                                If (((280.0 * roomscale) + 0.00075) > (Abs (entityx(arg4\Field62, $00) - entityx(local12\Field32, $01)))) Then
                                                    If (((280.0 * roomscale) + 0.00075) > (Abs (entityz(arg4\Field62, $00) - entityz(local12\Field32, $01)))) Then
                                                        If (((280.0 * roomscale) + 0.00075) > (Abs ((entityy(arg4\Field62, $00) - 0.32) - entityy(local12\Field32, $01)))) Then
                                                            local12\Field5 = $00
                                                            local12\Field30\Field5 = $00
                                                            If (local12\Field31 = $01) Then
                                                                local12\Field33\Field29 = -1.0
                                                            EndIf
                                                            If (local12\Field31 = $02) Then
                                                                local12\Field33\Field29 = 1.0
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        ElseIf (0.0 = local12\Field7) Then
                                            If (0.0 = local12\Field33\Field29) Then
                                                If (180.0 = local12\Field30\Field7) Then
                                                    local12\Field30\Field5 = $00
                                                    If (local12\Field30\Field31 = $01) Then
                                                        local12\Field33\Field29 = -1.0
                                                    EndIf
                                                    If (local12\Field30\Field31 = $02) Then
                                                        local12\Field33\Field29 = 1.0
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    Else
                                        usedoor(local12, $01, $01, arg3, local10)
                                    EndIf
                                    For local14 = $01 To server\Field11 Step $01
                                        If (((20.0 > entitydistance(local12\Field0, playeroptimize[local14]\Field62)) Or (local12\Field23 <> $00)) <> 0) Then
                                            udp_writebyte($17)
                                            udp_writebyte(arg3)
                                            udp_writeshort(local12\Field18)
                                            udp_writebyte(local12\Field5)
                                            udp_writebyte(local12\Field4)
                                            udp_sendmessage(playeroptimize[local14]\Field30)
                                        EndIf
                                    Next
                                EndIf
                                If (((local12\Field17 <> "") And local12\Field36) <> 0) Then
                                    If (local11 = local12\Field17) Then
                                        playsoundforplayer(arg4\Field30, "sfx\interact\scanneruse1.ogg")
                                    Else
                                        playsoundforplayer(arg4\Field30, "sfx\interact\scanneruse2.ogg")
                                    EndIf
                                EndIf
                            EndIf
                        Else
                            oncheatdetected(arg3, $03)
                        EndIf
                        Exit
                    EndIf
                Next
                Return $00
            EndIf
            readignorebytes($06)
            readignoreline()
        Case $03
            If ((((arg4\Field36 <> $00) And (arg4\Field59 = $00)) And (arg4\Field123 < millisecs())) <> 0) Then
                local15 = readline(server\Field0)
                local16 = readfloat(server\Field0)
                local17 = readfloat(server\Field0)
                If (getscripts() <> 0) Then
                    local3 = public_inqueue($27, $00)
                    public_addparam(local3, (Str arg3), $01)
                    public_addparam(local3, local15, $03)
                    public_addparam(local3, (Str local17), $02)
                    public_addparam(local3, (Str local16), $02)
                    callback($00)
                EndIf
                If (se_return_value\Field8 = $00) Then
                    arg4\Field123 = (millisecs() + server\Field4)
                    If (local15 = "SFX\SCP\513\Bell1.ogg") Then
                        If (curr5131 = Null) Then
                            curr5131 = createnpc($0C, 0.0, 0.0, 0.0)
                            curr5131\Field78 = $01
                        EndIf
                    EndIf
                    arg4\Field103 = local15
                    For local14 = $01 To server\Field11 Step $01
                        If (20.0 > entitydistance(playeroptimize[local14]\Field62, arg4\Field62)) Then
                            udp_writebyte(arg0)
                            udp_writebyte(arg3)
                            udp_writeline(local15)
                            udp_writefloat(local16)
                            udp_writefloat(local17)
                            udp_writebyte($01)
                            udp_sendmessage(playeroptimize[local14]\Field30)
                        EndIf
                    Next
                EndIf
                Return $00
            EndIf
            readignoreline()
            readignorebytes($08)
        Case $05
            If ((((arg4\Field36 <> $00) And (arg4\Field59 = $00)) And (arg4\Field124 < millisecs())) <> 0) Then
                If (getscripts() <> 0) Then
                    local3 = public_inqueue($1A, $00)
                    public_addparam(local3, (Str arg3), $01)
                    callback($00)
                EndIf
                If (se_return_value\Field8 = $00) Then
                    local19 = readbyte(server\Field0)
                    For local20 = $00 To $0B Step $01
                        local18[local20] = readfloat(server\Field0)
                    Next
                    For local14 = $01 To server\Field18 Step $01
                        If (((player[local14] <> Null) And (local14 <> arg3)) <> 0) Then
                            udp_writebyte(arg0)
                            udp_writebyte(arg3)
                            udp_writebyte(local19)
                            For local20 = $00 To $0B Step $01
                                udp_writefloat(local18[local20])
                            Next
                            udp_sendmessage(local14)
                        EndIf
                    Next
                EndIf
                arg4\Field124 = (millisecs() + $1F4)
                Return $00
            EndIf
            readignorebytes($31)
        Case $35
            If (arg4\Field119 < millisecs()) Then
                local21 = readbyte(server\Field0)
                If (isvalidplayer(local21) <> 0) Then
                    If (((2.0 > entitydistance(arg4\Field62, player[local21]\Field62)) And (player[local21]\Field59 = $00)) <> 0) Then
                        local22 = getbreachtype(arg4\Field36)
                        If (local22\Field45 = $02) Then
                            If (getscripts() <> 0) Then
                                local3 = public_inqueue($19, $00)
                                public_addparam(local3, (Str arg3), $01)
                                public_addparam(local3, (Str local21), $01)
                                public_addparam(local3, (Str player[arg3]\Field35), $01)
                                callback($00)
                            EndIf
                            If (se_return_value\Field8 = $00) Then
                                If (arg4\Field36 = model_049) Then
                                    setplayertype(local21, model_zombie)
                                    For local2 = Each items
                                        If (local2\Field22 = local21) Then
                                            playerdropitem(local2)
                                        EndIf
                                    Next
                                ElseIf (server\Field57 = $00) Then
                                    udp_writebyte(arg0)
                                    udp_writebyte(arg3)
                                    udp_sendmessage(local21)
                                ElseIf ((arg4\Field36 = model_106) = $00) Then
                                    giveplayerhealth(local21, -1000.0, ("was killed by " + arg4\Field15))
                                Else
                                    giveplayerhealth(local21, -55.0, ("was killed by " + arg4\Field15))
                                    movetopocketdimension(local21)
                                EndIf
                                arg4\Field119 = (millisecs() + local22\Field39)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                Return $00
            EndIf
            readignorebytes($01)
        Case $2E
            If (arg4\Field119 < millisecs()) Then
                local21 = readbyte(server\Field0)
                If (isvalidplayer(local21) <> 0) Then
                    If (((2.0 > entitydistance(arg4\Field62, player[local21]\Field62)) And (player[local21]\Field59 = $00)) <> 0) Then
                        local22 = getbreachtype(arg4\Field36)
                        If (local22\Field45 = $01) Then
                            local23 = rand($1E, $28)
                            If (getscripts() <> 0) Then
                                local3 = public_inqueue($12, $00)
                                public_addparam(local3, (Str arg3), $01)
                                public_addparam(local3, (Str local21), $01)
                                public_addparam(local3, (Str local23), $02)
                                public_addparam(local3, (Str player[arg3]\Field35), $01)
                                callback($00)
                            EndIf
                            If (se_return_value\Field8 = $00) Then
                                giveplayerhealth(local21, (Float (- local23)), ("was killed by " + arg4\Field15))
                                If (player[local21]\Field36 = $00) Then
                                    If (getscripts() <> 0) Then
                                        local3 = public_inqueue($19, $00)
                                        public_addparam(local3, (Str arg3), $01)
                                        public_addparam(local3, (Str local21), $01)
                                        public_addparam(local3, (Str arg4\Field35), $01)
                                        callback($00)
                                    EndIf
                                EndIf
                                If (arg4\Field36 = model_035) Then
                                    giveplayerhealth(arg3, (Float local23), " ")
                                EndIf
                            EndIf
                            arg4\Field119 = (millisecs() + local22\Field39)
                        Else
                            oncheatdetected(arg3, $02)
                        EndIf
                    EndIf
                EndIf
                Return $00
            EndIf
            readignorebytes($01)
        Case $0B
            If (arg4\Field125 < millisecs()) Then
                local24 = left(readline(server\Field0), $50)
                local25 = readbyte(server\Field0)
                If (instr(local24, "/rcon", $01) <> 0) Then
                    local24 = right(local24, (len(local24) - $02))
                    local26 = rcon_findcmd(local24)
                    If (local26 = "Not found") Then
                        Return addtexttochat("[RCON] Command not found", arg3)
                    EndIf
                    local27 = rcon_getattribute(local24)
                    If (arg4\Field41 = $00) Then
                        If (local26 = "login") Then
                            If (server\Field28 = "") Then
                                Return addtexttochat("[RCON] RCON switched off", arg3)
                            EndIf
                            If (server\Field28 <> local27) Then
                                addtexttochat("[RCON] Wrong password", arg3)
                                If (getscripts() <> 0) Then
                                    public_addparam(public_inqueue($16, $00), (Str arg3), $01)
                                    callback($00)
                                EndIf
                            Else
                                If (getscripts() <> 0) Then
                                    public_addparam(public_inqueue($17, $00), (Str arg3), $01)
                                    callback($00)
                                EndIf
                                If (se_return_value\Field8 = $00) Then
                                    addtexttochat("[RCON] You got the admin role.", arg3)
                                    arg4\Field41 = $01
                                EndIf
                            EndIf
                        Else
                            addtexttochat("[RCON] You are not an admin", arg3)
                        EndIf
                        Return $00
                    Else
                        Select rcon_executecmd(local26, local27)
                            Case "login"
                                addtexttochat("[RCON] You already have the admin role", arg3)
                            Case "status"
                                For local29 = Each players
                                    addtexttochat((((local29\Field15 + " (Ping ") + (Str local29\Field33)) + ")"), arg3)
                                Next
                            Case "commands"
                                For local30 = Each rcon
                                    addtexttochat(("[RCON] " + local30\Field0), arg3)
                                Next
                            Case "gravity"
                                addlog(("Gravity changed to " + local27), $00, $01, $00)
                            Case "hostname"
                                addlog(("Hostname changed to " + local27), $00, $01, $00)
                            Case "hostname"
                                addlog(("Hostname changed to " + local27), $00, $01, $00)
                            Case "size"
                                changeplayersize(arg3, (Int local27))
                                addtexttochat(("[RCON] Your size changed to " + (Str player[arg3]\Field28)), arg3)
                            Case "getip"
                                For local29 = Each players
                                    If (instr(lower(local29\Field15), lower(local27), $01) <> 0) Then
                                        addtexttochat(("Player IP: " + local29\Field40), arg3)
                                        Exit
                                    EndIf
                                Next
                            Case "getipid"
                                For local29 = Each players
                                    If (local29\Field30 = (Int local27)) Then
                                        addtexttochat(("Player IP: " + local29\Field40), arg3)
                                        Exit
                                    EndIf
                                Next
                            Case "getid"
                                For local29 = Each players
                                    If (instr(lower(local29\Field15), lower(local27), $01) <> 0) Then
                                        addtexttochat(("Player ID: " + (Str local29\Field30)), arg3)
                                        Exit
                                    EndIf
                                Next
                        End Select
                    EndIf
                ElseIf (local25 = $01) Then
                    If (getscripts() <> 0) Then
                        local24 = getformattedtext(local24)
                        local31 = public_inqueue($18, $00)
                        public_addparam(local31, (Str arg3), $01)
                        public_addparam(local31, local24, $03)
                        callback($00)
                        If (se_return_value\Field8 = $00) Then
                            If ((server\Field21 And (server\Field47 = $00)) <> 0) Then
                                Return $00
                            EndIf
                            If (((server\Field57 And instr(local24, "killed", $01)) And (instr(local24, ":", $01) = $00)) <> 0) Then
                                Return $00
                            EndIf
                            If (arg4\Field139 = $00) Then
                                addlog((arg4\Field15 + local24), $00, $01, $00)
                            EndIf
                        EndIf
                    Else
                        If (((server\Field57 And instr(local24, "killed", $01)) And (instr(local24, ":", $01) = $00)) <> 0) Then
                            Return $00
                        EndIf
                        If ((server\Field21 And (server\Field47 = $00)) <> 0) Then
                            Return $00
                        EndIf
                        If (arg4\Field139 = $00) Then
                            local24 = getformattedtext(local24)
                            addlog((arg4\Field15 + local24), $00, $01, $00)
                        EndIf
                    EndIf
                Else
                    local24 = getformattedtext(local24)
                    addtexttochat(local24, arg3)
                EndIf
                arg4\Field125 = (millisecs() + $FA)
                Return $00
            EndIf
            readignoreline()
            readignorebytes($01)
        Case $6D
            local32 = readbyte(server\Field0)
            If (((local32 > $00) And (local32 < $41)) <> 0) Then
                If (player[local32] <> Null) Then
                    udp_writebyte($6D)
                    udp_writebyte(local32)
                    udp_writeline(player[local32]\Field15)
                    udp_writeline(player[local32]\Field157)
                    udp_writebyte(player[local32]\Field158)
                    udp_writebyte(player[local32]\Field159)
                    udp_writebyte(player[local32]\Field160)
                    udp_writeshort((Int (player[local32]\Field28 * 100.0)))
                    udp_writeint(player[local32]\Field129)
                    udp_writebyte(player[local32]\Field39)
                    udp_sendmessage(arg3)
                EndIf
            EndIf
        Case $0E
            If (((arg4\Field36 <> $00) And (arg4\Field59 = $00)) <> 0) Then
                local33 = readbyte(server\Field0)
                local34 = readfloat(server\Field0)
                local35 = readfloat(server\Field0)
                local36 = readfloat(server\Field0)
                If (arg4\Field32 < $C8) Then
                    local6 = room[arg4\Field32]
                    If (local6 <> Null) Then
                        If (local33 <= $1E) Then
                            If (local6\Field25[local33] <> $00) Then
                                If (2.0 > entitydistance(arg4\Field62, local6\Field25[local33])) Then
                                    If (getscripts() <> 0) Then
                                        local3 = public_inqueue($24, $00)
                                        public_addparam(local3, (Str arg3), $01)
                                        public_addparam(local3, (Str local33), $01)
                                        public_addparam(local3, (Str local34), $02)
                                        public_addparam(local3, (Str local35), $02)
                                        public_addparam(local3, (Str local36), $02)
                                        callback($00)
                                    EndIf
                                    If (se_return_value\Field8 = $00) Then
                                        rotateentity(local6\Field25[local33], local34, local35, local36, $01)
                                        local6\Field26[local33] = $00
                                    EndIf
                                Else
                                    oncheatdetected(arg3, $03)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
                Return $00
            EndIf
            readignorebytes($0D)
        Case $4A
            local37 = readbyte(server\Field0)
            If (server\Field57 = $00) Then
                If (getscripts() <> 0) Then
                    local3 = public_inqueue($10, $00)
                    public_addparam(local3, (Str arg3), $01)
                    public_addparam(local3, (Str max(min((Float local37), (Float (last_breach_type - $01))), 0.0)), $01)
                    callback($00)
                EndIf
                If (se_return_value\Field8 = $00) Then
                    setplayertype(arg4\Field30, (Int max(min((Float local37), (Float (last_breach_type - $01))), 0.0)))
                EndIf
            ElseIf (local37 = $00) Then
                If (getscripts() <> 0) Then
                    local3 = public_inqueue($10, $00)
                    public_addparam(local3, (Str arg3), $01)
                    public_addparam(local3, (Str max(min((Float local37), (Float (last_breach_type - $01))), 0.0)), $01)
                    callback($00)
                EndIf
                If (se_return_value\Field8 = $00) Then
                    If (server\Field21 = $00) Then
                        giveplayerhealth(arg3, -1000.0, "")
                    Else
                        setplayertype(arg4\Field30, $00)
                    EndIf
                EndIf
            EndIf
        Case $7C
            If (((arg4\Field59 = $00) And (arg4\Field36 <> $00)) <> 0) Then
                local38 = readline(server\Field0)
                local39 = readshort(server\Field0)
                giveplayerhealth(arg3, (Float (- local39)), local38)
                Return $00
            EndIf
            readignoreline()
            readignorebytes($02)
        Case $79
            local21 = readbyte(server\Field0)
            If (isvalidplayer(local21) <> 0) Then
                If (player[local21] <> Null) Then
                    If ((((((arg4\Field138 = $00) And (player[local21]\Field36 <> $00)) And (arg4\Field36 <> $00)) And (1.5 > entitydistance(arg4\Field62, player[local21]\Field62))) And (arg4\Field35 = $0B)) <> 0) Then
                        If (arg4\Field140 < millisecs()) Then
                            If (((mp_isafriend(arg4\Field36, player[local21]\Field36) = $00) Or (player[local21]\Field138 <> $00)) <> 0) Then
                                If (getscripts() <> 0) Then
                                    public_inqueue($07, $00)
                                    public_addparam($00, (Str arg3), $01)
                                    public_addparam($00, (Str local21), $01)
                                    callback($00)
                                EndIf
                                If (se_return_value\Field8 = $00) Then
                                    local22 = getbreachtype(player[local21]\Field36)
                                    If (local22\Field27 <> 0) Then
                                        For local2 = Each items
                                            If (local2\Field22 = arg3) Then
                                                If (local2\Field3\Field2 = "handcuffs") Then
                                                    player[local21]\Field138 = (player[local21]\Field138 = $00)
                                                    If (player[local21]\Field138 <> 0) Then
                                                        For local2 = Each items
                                                            If (local2\Field22 = local21) Then
                                                                playerdropitem(local2)
                                                            EndIf
                                                        Next
                                                    EndIf
                                                    If (server\Field57 = $00) Then
                                                        udp_writebyte($79)
                                                        udp_writebyte(arg3)
                                                        udp_sendmessage(local21)
                                                    EndIf
                                                    If (player[local21]\Field138 <> 0) Then
                                                        sendplayermsg(local21, "You are handcuffed.", $15E)
                                                        sendplayermsg(arg3, "You handcuffed the player.", $15E)
                                                    Else
                                                        sendplayermsg(local21, "You are uncuffed.", $15E)
                                                        sendplayermsg(arg3, "You uncuffed the player.", $15E)
                                                    EndIf
                                                    Exit
                                                EndIf
                                            EndIf
                                        Next
                                        arg4\Field140 = (millisecs() + $EA60)
                                    Else
                                        sendplayermsg(arg3, "You can't cuff this player.", $15E)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Else
                        sendplayermsg(arg3, "Wait a bit for the next use of the handcuffs.", $15E)
                    EndIf
                EndIf
            EndIf
        Case $78
            If (server\Field21 = $00) Then
                If (arg4\Field59 = $00) Then
                    arg4\Field97 = entityx(arg4\Field62, $00)
                    arg4\Field98 = entityy(arg4\Field62, $00)
                    arg4\Field99 = entityz(arg4\Field62, $00)
                    arg4\Field100 = arg4\Field32
                EndIf
            EndIf
        Case local40
            If (((arg4\Field59 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                If (room[arg4\Field32] <> Null) Then
                    If (room[arg4\Field32]\Field7\Field10 = "exit1") Then
                        If (1.0 > entitydistance(room[arg4\Field32]\Field25[$16], arg4\Field62)) Then
                            If (breach_isstarted() <> 0) Then
                                If (((mp_isascp(arg4\Field36) = $00) Or multiplayer_breach_isa049(arg4\Field36)) <> 0) Then
                                    If (gameinfo\Field5\Field7 < millisecs()) Then
                                        If (gameinfo\Field5\Field6 = $00) Then
                                            local41 = $01
                                            For local42 = Each events
                                                If (local42\Field22 = $1F) Then
                                                    local41 = (Int local42\Field2)
                                                    Exit
                                                EndIf
                                            Next
                                            If (local41 = $01) Then
                                                If (getscripts() <> 0) Then
                                                    public_inqueue($08, $00)
                                                    public_addparam($00, (Str arg3), $01)
                                                    callback($00)
                                                EndIf
                                                If (se_return_value\Field8 = $00) Then
                                                    activatewarheads("Warheads", $00, arg3)
                                                    gameinfo\Field5\Field7 = (millisecs() + $4E20)
                                                    sendplayermsg(arg3, "The warheads is activated!", $1A4)
                                                EndIf
                                            Else
                                                sendplayermsg(arg3, "Remote warhead control is disabled.", $1A4)
                                            EndIf
                                        ElseIf (gameinfo\Field5\Field6 <> $02) Then
                                            If (getscripts() <> 0) Then
                                                public_inqueue($09, $00)
                                                public_addparam($00, (Str arg3), $01)
                                                callback($00)
                                            EndIf
                                            If (se_return_value\Field8 = $00) Then
                                                gameinfo\Field5\Field7 = (millisecs() + $1D4C0)
                                                deactivatewarheads(arg3)
                                                sendplayermsg(arg3, "You turned off the warheads.", $1A4)
                                            EndIf
                                        EndIf
                                    Else
                                        sendplayermsg(arg3, "You pushed the button but nothing happened.", $1A4)
                                    EndIf
                                EndIf
                            Else
                                sendplayermsg(arg3, "You pushed the button but nothing happened.", $1A4)
                            EndIf
                        EndIf
                    Else
                        oncheatdetected(arg3, $03)
                    EndIf
                EndIf
            EndIf
        Case $6A
            If (getscripts() <> 0) Then
                public_inqueue($0C, $00)
                public_addparam($00, (Str arg3), $01)
                public_addparam($00, (Str readshort(server\Field0)), $01)
                public_addparam($00, (Str readshort(server\Field0)), $01)
                callback($00)
            Else
                readignorebytes($04)
            EndIf
            arg4\Field93 = (millisecs() + $1F4)
        Case $80
            If (arg4\Field119 < millisecs()) Then
                If (((arg4\Field59 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                    If (arg4\Field138 = $00) Then
                        local43 = readshort(server\Field0)
                        local21 = readbyte(server\Field0)
                        If (local43 < $3E8) Then
                            local2 = m_item[local43]
                            If (local2 <> Null) Then
                                If (local2\Field22 = arg3) Then
                                    If (isagun(local2\Field3\Field2) = player[arg3]\Field35) Then
                                        If (mp_isascp(arg4\Field36) = $00) Then
                                            If (isvalidplayer(local21) <> 0) Then
                                                If (player[local21] <> Null) Then
                                                    If (player[local21]\Field36 > $00) Then
                                                        If (1.5 > entitydistance(arg4\Field62, player[local21]\Field62)) Then
                                                            If (((local21 <> arg3) And (((mp_isafriend(arg4\Field36, player[local21]\Field36) Or (server\Field21 = $00)) = $00) Or server\Field71)) <> 0) Then
                                                                local23 = (Int ((Float rand($0A, $01)) + getgundamage($0C)))
                                                                If (getscripts() <> 0) Then
                                                                    local3 = public_inqueue($0D, $00)
                                                                    public_addparam(local3, "0", $02)
                                                                    public_addparam(local3, "0", $02)
                                                                    public_addparam(local3, "0", $02)
                                                                    public_addparam(local3, "0", $02)
                                                                    public_addparam(local3, "0", $02)
                                                                    callback($00)
                                                                EndIf
                                                                If (se_return_value\Field8 = $00) Then
                                                                    giveplayerhealth(local21, (Float (- local23)), ("was killed by " + arg4\Field15))
                                                                    arg4\Field119 = (millisecs() + $1F4)
                                                                    If (player[local21]\Field59 <> 0) Then
                                                                        If (getscripts() <> 0) Then
                                                                            local3 = public_inqueue($19, $00)
                                                                            public_addparam(local3, (Str arg3), $01)
                                                                            public_addparam(local3, (Str local21), $01)
                                                                            public_addparam(local3, (Str arg4\Field35), $01)
                                                                            callback($00)
                                                                        EndIf
                                                                        local44 = breach_getcategorybytype(arg4\Field36, $01)
                                                                        If (((player[local21]\Field73 = scientist_model) And (local44 = $06)) <> 0) Then
                                                                            breach_givetickets($01, 1.0)
                                                                        EndIf
                                                                        If (((player[local21]\Field73 = classd_model) And (local44 = $07)) <> 0) Then
                                                                            breach_givetickets($00, 1.0)
                                                                        EndIf
                                                                    Else
                                                                        If (getscripts() <> 0) Then
                                                                            local3 = public_inqueue($12, $00)
                                                                            public_addparam(local3, (Str arg3), $01)
                                                                            public_addparam(local3, (Str player[local21]\Field30), $01)
                                                                            public_addparam(local3, (Str local23), $02)
                                                                            public_addparam(local3, (Str arg4\Field35), $01)
                                                                            callback($00)
                                                                        EndIf
                                                                        If (mp_isascp(player[local21]\Field36) <> 0) Then
                                                                            local44 = breach_getcategorybytype(arg4\Field36, $01)
                                                                            If (local44 = $07) Then
                                                                                breach_givetickets($00, 0.01)
                                                                            EndIf
                                                                            If (local44 = $06) Then
                                                                                breach_givetickets($01, 0.01)
                                                                            EndIf
                                                                        EndIf
                                                                    EndIf
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    Else
                                        oncheatdetected(arg3, $01)
                                    EndIf
                                EndIf
                            Else
                                oncheatdetected(arg3, $01)
                            EndIf
                        EndIf
                        Return $00
                    Else
                        oncheatdetected(arg3, $01)
                    EndIf
                EndIf
            EndIf
            readignorebytes($03)
        Case $51
            If (((arg4\Field59 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                If (arg4\Field138 = $00) Then
                    local43 = readshort(server\Field0)
                    local45 = readfloat(server\Field0)
                    local46 = readfloat(server\Field0)
                    local47 = readfloat(server\Field0)
                    local48 = readfloat(server\Field0)
                    local49 = readfloat(server\Field0)
                    If (local43 < $3E8) Then
                        local2 = m_item[local43]
                        If (local2 <> Null) Then
                            If (local2\Field22 = arg3) Then
                                If (instr(local2\Field3\Field2, "rpg", $01) <> 0) Then
                                    If (4.0 > distance3(local45, local46, local47, entityx(arg4\Field62, $00), entityy(arg4\Field62, $00), entityz(arg4\Field62, $00))) Then
                                        If (mp_isascp(arg4\Field36) = $00) Then
                                            If (getscripts() <> 0) Then
                                                local3 = public_inqueue($0E, $00)
                                                public_addparam(local3, (Str arg3), $01)
                                                public_addparam(local3, (Str local45), $02)
                                                public_addparam(local3, (Str local46), $02)
                                                public_addparam(local3, (Str local47), $02)
                                                public_addparam(local3, (Str local49), $02)
                                                public_addparam(local3, (Str local48), $02)
                                                callback($00)
                                            EndIf
                                            If (se_return_value\Field8 = $00) Then
                                                createrocket(15.0, local45, local46, local47, local48, local49, arg3)
                                                For local14 = $01 To server\Field11 Step $01
                                                    If (50.0 > distance3(local45, local46, local47, entityx(playeroptimize[local14]\Field62, $00), entityy(playeroptimize[local14]\Field62, $00), entityz(playeroptimize[local14]\Field62, $00))) Then
                                                        udp_writebyte($51)
                                                        udp_writebyte(arg3)
                                                        udp_writeshort($00)
                                                        udp_writefloat(local45)
                                                        udp_writefloat(local46)
                                                        udp_writefloat(local47)
                                                        udp_writefloat(local48)
                                                        udp_writefloat(local49)
                                                        udp_sendmessage(playeroptimize[local14]\Field30)
                                                    EndIf
                                                Next
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    oncheatdetected(arg3, $01)
                                EndIf
                            Else
                                oncheatdetected(arg3, $01)
                            EndIf
                        EndIf
                    EndIf
                    Return $00
                Else
                    oncheatdetected(arg3, $01)
                EndIf
            EndIf
            readignorebytes($16)
        Case $74
            If (arg4\Field119 < millisecs()) Then
                If (((arg4\Field59 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                    If (arg4\Field138 = $00) Then
                        local43 = readshort(server\Field0)
                        local45 = readfloat(server\Field0)
                        local46 = readfloat(server\Field0)
                        local47 = readfloat(server\Field0)
                        local48 = readfloat(server\Field0)
                        local49 = readfloat(server\Field0)
                        local50 = readbyte(server\Field0)
                        local51 = (Int min((Float readbyte(server\Field0)), 1.0))
                        If (local43 < $3E8) Then
                            local2 = m_item[local43]
                            If (local2 <> Null) Then
                                If (local2\Field22 = arg3) Then
                                    Select local50
                                        Case $0D
                                            If (local2\Field3\Field2 <> "grenade") Then
                                                oncheatdetected(arg3, $01)
                                                Return $00
                                            EndIf
                                        Case $0E
                                            If (local2\Field3\Field2 <> "grenadeflashbang") Then
                                                oncheatdetected(arg3, $01)
                                                Return $00
                                            EndIf
                                        Case $0F
                                            If (local2\Field3\Field2 <> "grenadesmoke") Then
                                                oncheatdetected(arg3, $01)
                                                Return $00
                                            EndIf
                                        Default
                                            oncheatdetected(arg3, $01)
                                            Return $00
                                    End Select
                                    If (4.0 > distance3(local45, local46, local47, entityx(arg4\Field62, $00), entityy(arg4\Field62, $00), entityz(arg4\Field62, $00))) Then
                                        If (((mp_isascp(arg4\Field36) = $00) And (arg4\Field36 <> $00)) <> 0) Then
                                            If (getscripts() <> 0) Then
                                                local3 = public_inqueue($0F, $00)
                                                public_addparam(local3, (Str arg3), $01)
                                                public_addparam(local3, (Str local45), $02)
                                                public_addparam(local3, (Str local46), $02)
                                                public_addparam(local3, (Str local47), $02)
                                                public_addparam(local3, (Str local49), $02)
                                                public_addparam(local3, (Str local48), $02)
                                                public_addparam(local3, (Str local50), $01)
                                                public_addparam(local3, (Str local51), $01)
                                                callback($00)
                                            EndIf
                                            If (se_return_value\Field8 = $00) Then
                                                If (local50 = $0D) Then
                                                    creategrenade(local45, local46, local47, local48, local49, arg3, local51)
                                                EndIf
                                                For local14 = $01 To server\Field11 Step $01
                                                    udp_writebyte($74)
                                                    udp_writebyte(arg3)
                                                    udp_writeshort($00)
                                                    udp_writefloat(local45)
                                                    udp_writefloat(local46)
                                                    udp_writefloat(local47)
                                                    udp_writefloat(local48)
                                                    udp_writefloat(local49)
                                                    udp_writebyte(local50)
                                                    udp_writebyte(local51)
                                                    udp_sendmessage(playeroptimize[local14]\Field30)
                                                Next
                                            EndIf
                                        EndIf
                                        removeitem(local2, $00)
                                    EndIf
                                Else
                                    oncheatdetected(arg3, $01)
                                EndIf
                            EndIf
                        EndIf
                        arg4\Field119 = (millisecs() + $1F4)
                        Return $00
                    Else
                        oncheatdetected(arg3, $01)
                    EndIf
                EndIf
            EndIf
            readignorebytes($18)
        Case $16
            local53 = readint(server\Field0)
            If (server\Field57 <> 0) Then
                If (arg4\Field67 = "room1162") Then
                    local6 = room[arg4\Field32]
                    If (2.0 > entitydistance(local6\Field25[$00], arg4\Field62)) Then
                        If (arg4\Field59 = $00) Then
                            local54 = $00
                            For local55 = Each itemtemplates
                                If (isitemgoodfor1162(local55) <> 0) Then
                                    local54 = $00
                                    If (arg4\Field137 <> "") Then
                                        Select arg4\Field137
                                            Case "key"
                                                If ((((local55\Field2 = "key1") Or (local55\Field2 = "key2")) And (rand($02, $01) = $01)) <> 0) Then
                                                    local54 = $01
                                                EndIf
                                            Case "paper","oldpaper"
                                                If (((local55\Field2 = "paper") And (rand($0C, $01) = $01)) <> 0) Then
                                                    local54 = $01
                                                EndIf
                                            Case "gasmask","gasmask3","supergasmask","hazmatsuit","hazmatsuit2","hazmatsuit3"
                                                If ((((((((local55\Field2 = "gasmask") Or (local55\Field2 = "gasmask3")) Or (local55\Field2 = "supergasmask")) Or (local55\Field2 = "hazmatsuit")) Or (local55\Field2 = "hazmatsuit2")) Or (local55\Field2 = "hazmatsuit3")) And (rand($02, $01) = $01)) <> 0) Then
                                                    local54 = $01
                                                EndIf
                                            Case "key1","key2","key3"
                                                If ((((((local55\Field2 = "key1") Or (local55\Field2 = "key2")) Or (local55\Field2 = "key3")) Or (local55\Field2 = "misc")) And (rand($06, $01) = $01)) <> 0) Then
                                                    local54 = $01
                                                EndIf
                                            Case "vest","finevest"
                                                If ((((local55\Field2 = "vest") Or (local55\Field2 = "finevest")) And (rand($01, $01) = $01)) <> 0) Then
                                                    local54 = $01
                                                EndIf
                                            Default
                                                If (((local55\Field2 = "misc") And (rand($06, $01) = $01)) <> 0) Then
                                                    local54 = $01
                                                EndIf
                                        End Select
                                        If (local54 <> 0) Then
                                            local2 = createitem(local55\Field1, local55\Field2, arg4\Field0, (arg4\Field1 + 0.1), arg4\Field2, $00, $00, $00, 1.0, $00, $01)
                                            If (getscripts() <> 0) Then
                                                local3 = public_inqueue($1C, $00)
                                                public_addparam(local3, (Str arg3), $01)
                                                public_addparam(local3, (Str local2\Field18), $01)
                                                public_addparam(local3, (Str local53), $01)
                                                callback($00)
                                            EndIf
                                            arg4\Field137 = ""
                                            Exit
                                        EndIf
                                    Else
                                        If (player[arg3]\Field59 = $00) Then
                                            giveplayerhealth(arg3, (Float (- rand($33, $37))), "was killed by SCP-1162")
                                        EndIf
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                Else
                    oncheatdetected(arg4\Field30, $05)
                EndIf
            EndIf
    End Select
    Return $00
End Function
