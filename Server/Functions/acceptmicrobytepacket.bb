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
    Local local23$
    Local local24%
    Local local25%
    Local local26%
    Local local27#
    Local local28#
    Local local29#
    Local local30%
    Local local31$
    Local local32%
    Local local33%
    Local local34%
    Local local35.events
    Local local36%
    Local local37%
    Local local38#
    Local local39#
    Local local40#
    Local local41#
    Local local42#
    Local local43%
    Local local44%
    Local local46%
    Local local47%
    Local local48.itemtemplates
    arg4\Field22 = $01
    Select arg0
        Case $2C
            If (((arg4\Field61 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
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
                                arg4\Field140 = local2\Field3\Field2
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
                            If (1.5 > entitydistance(arg4\Field64, local2\Field1)) Then
                                If (getscripts() <> 0) Then
                                    local3 = public_inqueue($1D, $00)
                                    public_addparam(local3, (Str arg3), $01)
                                    public_addparam(local3, (Str local1), $01)
                                    public_addparam(local3, (Str local2\Field3\Field0), $01)
                                    callback($00)
                                EndIf
                                If (se_return_value\Field8 = $00) Then
                                    If (arg4\Field141 <> 0) Then
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
                                local2\Field22 = $00
                                selecteditem = $00
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
                If (arg4\Field61 <> 0) Then
                    positionentity(arg4\Field64, arg4\Field99, arg4\Field100, arg4\Field101, $00)
                    resetentity(arg4\Field64)
                    For local6 = Each rooms
                        If (local6\Field69 = arg4\Field102) Then
                            mp_setplayerroomid(arg4, local6)
                            Exit
                        EndIf
                    Next
                    mp_updateplayerposition(arg4, $01)
                    setplayertype(arg4\Field30, classd_model)
                    arg4\Field62 = 100.0
                    arg4\Field63 = 0.0
                EndIf
            EndIf
        Case $82
            If (((server\Field77 = $00) And (arg4\Field36 > $00)) <> 0) Then
                If (((arg4\Field69 = "room2ccont") And ((mp_isascp(arg4\Field36) = $00) Or multiplayer_breach_isa049(arg4\Field36))) <> 0) Then
                    local6 = room[arg4\Field32]
                    If (3.0 > distance3((local6\Field3 - 1.035156), (local6\Field4 + 5.0), (local6\Field5 + (1.0 / 2.438095)), entityx(arg4\Field64, $00), entityy(arg4\Field64, $00), entityz(arg4\Field64, $00))) Then
                        If (((arg4\Field123 < millisecs()) Or (arg4\Field124 > millisecs())) <> 0) Then
                            arg4\Field122 = (arg4\Field122 = $00)
                            If (arg4\Field122 = $00) Then
                                arg4\Field123 = (millisecs() + server\Field75)
                                arg4\Field124 = $00
                            Else
                                arg4\Field124 = (millisecs() + server\Field76)
                                arg4\Field123 = ((millisecs() + server\Field75) + server\Field76)
                            EndIf
                        Else
                            arg4\Field124 = $00
                            arg4\Field123 = (millisecs() + server\Field75)
                            arg4\Field122 = $00
                        EndIf
                    Else
                        arg4\Field124 = $00
                        arg4\Field123 = (millisecs() + server\Field75)
                        arg4\Field122 = $00
                    EndIf
                Else
                    arg4\Field124 = $00
                    arg4\Field123 = (millisecs() + server\Field75)
                    arg4\Field122 = $00
                EndIf
            EndIf
        Case $17
            If (((arg4\Field61 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
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
                                If (4.0 > entitydistance(local12\Field3[local14], arg4\Field64)) Then
                                    local13 = $01
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (local13 = $00) Then
                            If (local12\Field30 <> Null) Then
                                For local14 = $00 To $01 Step $01
                                    If (local12\Field30\Field3[local14] <> $00) Then
                                        If (4.0 > entitydistance(local12\Field30\Field3[local14], arg4\Field64)) Then
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
                                                If (1.0945 > (Abs (entityx(arg4\Field64, $00) - entityx(local12\Field32, $01)))) Then
                                                    If (1.0945 > (Abs (entityz(arg4\Field64, $00) - entityz(local12\Field32, $01)))) Then
                                                        If (1.0945 > (Abs ((entityy(arg4\Field64, $00) - 0.32) - entityy(local12\Field32, $01)))) Then
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
                                        If (((20.0 > entitydistance(local12\Field0, playeroptimize[local14]\Field64)) Or (local12\Field23 <> $00)) <> 0) Then
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
            If ((((arg4\Field36 <> $00) And (arg4\Field61 = $00)) And (arg4\Field125 < millisecs())) <> 0) Then
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
                    arg4\Field125 = (millisecs() + server\Field4)
                    If (local15 = "SFX\SCP\513\Bell1.ogg") Then
                        If (curr5131 = Null) Then
                            curr5131 = createnpc($0C, 0.0, 0.0, 0.0)
                            curr5131\Field78 = $01
                        EndIf
                    EndIf
                    arg4\Field105 = local15
                    For local14 = $01 To server\Field11 Step $01
                        If (20.0 > entitydistance(playeroptimize[local14]\Field64, arg4\Field64)) Then
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
            If ((((arg4\Field36 <> $00) And (arg4\Field61 = $00)) And (arg4\Field126 < millisecs())) <> 0) Then
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
                arg4\Field126 = (millisecs() + $1F4)
                Return $00
            EndIf
            readignorebytes($31)
        Case $35
            If (arg4\Field121 < millisecs()) Then
                local21 = readbyte(server\Field0)
                If (isvalidplayer(local21) <> 0) Then
                    If (((2.0 > entitydistance(arg4\Field64, player[local21]\Field64)) And (player[local21]\Field61 = $00)) <> 0) Then
                        local22 = getbreachtype(arg4\Field36)
                        If (local22\Field45 = $02) Then
                            player[local21]\Field50 = arg4\Field30
                            local23 = ("was killed by " + arg4\Field15)
                            If (getscripts() <> 0) Then
                                local3 = public_inqueue($19, $00)
                                public_addparam(local3, (Str arg3), $01)
                                public_addparam(local3, (Str local21), $01)
                                public_addparam(local3, (Str player[arg3]\Field35), $01)
                                callback($00)
                                If (se_getreturnvalue() <> "-1") Then
                                    local23 = se_getreturnvalue()
                                EndIf
                            EndIf
                            If (se_return_value\Field8 = $00) Then
                                If (arg4\Field36 = model_049) Then
                                    setplayertype(local21, model_zombie)
                                    For local2 = Each items
                                        If (local2\Field22 = local21) Then
                                            playerdropitem(local2)
                                        EndIf
                                    Next
                                ElseIf (server\Field56 = $00) Then
                                    udp_writebyte(arg0)
                                    udp_writebyte(arg3)
                                    udp_sendmessage(local21)
                                ElseIf ((arg4\Field36 = model_106) = $00) Then
                                    giveplayerhealth(local21, -1000.0, local23)
                                Else
                                    giveplayerhealth(local21, -55.0, local23)
                                    movetopocketdimension(local21)
                                EndIf
                                arg4\Field121 = (millisecs() + local22\Field39)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                Return $00
            EndIf
            readignorebytes($01)
        Case $2E
            If (arg4\Field121 < millisecs()) Then
                local21 = readbyte(server\Field0)
                If (isvalidplayer(local21) <> 0) Then
                    If (((2.0 > entitydistance(arg4\Field64, player[local21]\Field64)) And (player[local21]\Field61 = $00)) <> 0) Then
                        local22 = getbreachtype(arg4\Field36)
                        If (local22\Field45 = $01) Then
                            player[local21]\Field50 = arg4\Field30
                            local24 = getscpdamage(arg4\Field36)
                            local23 = ("was killed by " + arg4\Field15)
                            If (getscripts() <> 0) Then
                                local3 = public_inqueue($12, $00)
                                public_addparam(local3, (Str arg3), $01)
                                public_addparam(local3, (Str local21), $01)
                                public_addparam(local3, (Str local24), $02)
                                public_addparam(local3, (Str player[arg3]\Field35), $01)
                                callback($00)
                                If (se_getreturnvalue() <> "-1") Then
                                    local23 = se_getreturnvalue()
                                EndIf
                            EndIf
                            If (se_return_value\Field8 = $00) Then
                                giveplayerhealth(local21, (Float (- local24)), local23)
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
                                    giveplayerhealth(arg3, (Float local24), " ")
                                EndIf
                            EndIf
                            arg4\Field121 = (millisecs() + local22\Field39)
                        Else
                            oncheatdetected(arg3, $02)
                        EndIf
                    EndIf
                EndIf
                Return $00
            EndIf
            readignorebytes($01)
        Case $6D
            local25 = readbyte(server\Field0)
            If (((local25 > $00) And (local25 < $41)) <> 0) Then
                If (player[local25] <> Null) Then
                    udp_writebyte($6D)
                    udp_writebyte(local25)
                    udp_writeline(player[local25]\Field15)
                    udp_writeline(player[local25]\Field160)
                    udp_writebyte(player[local25]\Field161)
                    udp_writebyte(player[local25]\Field162)
                    udp_writebyte(player[local25]\Field163)
                    udp_writeshort((Int (player[local25]\Field28 * 100.0)))
                    udp_writeline(player[local25]\Field132)
                    udp_writebyte(player[local25]\Field39)
                    udp_sendmessage(arg3)
                EndIf
            EndIf
        Case $0E
            If (((arg4\Field36 <> $00) And (arg4\Field61 = $00)) <> 0) Then
                local26 = readbyte(server\Field0)
                local27 = readfloat(server\Field0)
                local28 = readfloat(server\Field0)
                local29 = readfloat(server\Field0)
                If (arg4\Field32 < $C8) Then
                    local6 = room[arg4\Field32]
                    If (local6 <> Null) Then
                        If (local26 <= $1E) Then
                            If (local6\Field25[local26] <> $00) Then
                                If (2.0 > entitydistance(arg4\Field64, local6\Field25[local26])) Then
                                    If (getscripts() <> 0) Then
                                        local3 = public_inqueue($24, $00)
                                        public_addparam(local3, (Str arg3), $01)
                                        public_addparam(local3, (Str local26), $01)
                                        public_addparam(local3, (Str local27), $02)
                                        public_addparam(local3, (Str local28), $02)
                                        public_addparam(local3, (Str local29), $02)
                                        callback($00)
                                    EndIf
                                    If (se_return_value\Field8 = $00) Then
                                        rotateentity(local6\Field25[local26], local27, local28, local29, $01)
                                        local6\Field26[local26] = $00
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
            local30 = readbyte(server\Field0)
            If (server\Field56 = $00) Then
                If (getscripts() <> 0) Then
                    local3 = public_inqueue($10, $00)
                    public_addparam(local3, (Str arg3), $01)
                    public_addparam(local3, (Str max(min((Float local30), (Float (last_breach_type - $01))), 0.0)), $01)
                    callback($00)
                EndIf
                If (se_return_value\Field8 = $00) Then
                    setplayertype(arg4\Field30, (Int max(min((Float local30), (Float (last_breach_type - $01))), 0.0)))
                EndIf
            ElseIf (local30 = $00) Then
                If (getscripts() <> 0) Then
                    local3 = public_inqueue($10, $00)
                    public_addparam(local3, (Str arg3), $01)
                    public_addparam(local3, (Str max(min((Float local30), (Float (last_breach_type - $01))), 0.0)), $01)
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
            If (((arg4\Field61 = $00) And (arg4\Field36 <> $00)) <> 0) Then
                local31 = readline(server\Field0)
                local32 = readshort(server\Field0)
                giveplayerhealth(arg3, (Float (- local32)), local31)
                Return $00
            EndIf
            readignoreline()
            readignorebytes($02)
        Case $79
            local21 = readbyte(server\Field0)
            If (isvalidplayer(local21) <> 0) Then
                If (player[local21] <> Null) Then
                    If ((((((arg4\Field141 = $00) And (player[local21]\Field36 <> $00)) And (arg4\Field36 <> $00)) And (1.5 > entitydistance(arg4\Field64, player[local21]\Field64))) And (arg4\Field35 = $0B)) <> 0) Then
                        If (arg4\Field143 < millisecs()) Then
                            If (((mp_isafriend(arg4\Field36, player[local21]\Field36) = $00) Or (player[local21]\Field141 <> $00)) <> 0) Then
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
                                                    player[local21]\Field141 = (player[local21]\Field141 = $00)
                                                    If (player[local21]\Field141 <> 0) Then
                                                        For local2 = Each items
                                                            If (local2\Field22 = local21) Then
                                                                playerdropitem(local2)
                                                            EndIf
                                                        Next
                                                    EndIf
                                                    If (server\Field56 = $00) Then
                                                        udp_writebyte($79)
                                                        udp_writebyte(arg3)
                                                        udp_sendmessage(local21)
                                                    EndIf
                                                    If (player[local21]\Field141 <> 0) Then
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
                                        arg4\Field143 = (millisecs() + $EA60)
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
                If (arg4\Field61 = $00) Then
                    arg4\Field99 = entityx(arg4\Field64, $00)
                    arg4\Field100 = entityy(arg4\Field64, $00)
                    arg4\Field101 = entityz(arg4\Field64, $00)
                    arg4\Field102 = arg4\Field32
                EndIf
            EndIf
        Case local33
            If (((arg4\Field61 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                If (room[arg4\Field32] <> Null) Then
                    If (room[arg4\Field32]\Field7\Field10 = "exit1") Then
                        If (1.0 > entitydistance(room[arg4\Field32]\Field25[$16], arg4\Field64)) Then
                            If (breach_isstarted() <> 0) Then
                                If (((mp_isascp(arg4\Field36) = $00) Or multiplayer_breach_isa049(arg4\Field36)) <> 0) Then
                                    If (gameinfo\Field5\Field7 < millisecs()) Then
                                        If (gameinfo\Field5\Field6 = $00) Then
                                            local34 = $01
                                            For local35 = Each events
                                                If (local35\Field22 = $1F) Then
                                                    local34 = (Int local35\Field2)
                                                    Exit
                                                EndIf
                                            Next
                                            If (local34 = $01) Then
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
            arg4\Field95 = (millisecs() + $1F4)
        Case $80
            If (arg4\Field121 < millisecs()) Then
                If (((arg4\Field61 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                    If (arg4\Field141 = $00) Then
                        local36 = readshort(server\Field0)
                        local21 = readbyte(server\Field0)
                        If (local36 < $3E8) Then
                            local2 = m_item[local36]
                            If (local2 <> Null) Then
                                If (local2\Field22 = arg3) Then
                                    If (isagun(local2\Field3\Field2) = player[arg3]\Field35) Then
                                        If (mp_isascp(arg4\Field36) = $00) Then
                                            If (isvalidplayer(local21) <> 0) Then
                                                If (player[local21] <> Null) Then
                                                    If (player[local21]\Field36 > $00) Then
                                                        If (1.5 > entitydistance(arg4\Field64, player[local21]\Field64)) Then
                                                            If (((local21 <> arg3) And (((mp_isafriend(arg4\Field36, player[local21]\Field36) Or (server\Field21 = $00)) = $00) Or server\Field69)) <> 0) Then
                                                                local24 = (Int ((Float rand($0A, $01)) + getgundamage($0C)))
                                                                player[local21]\Field50 = arg4\Field30
                                                                local23 = ("was killed by " + arg4\Field15)
                                                                If (getscripts() <> 0) Then
                                                                    local3 = public_inqueue($0D, $00)
                                                                    public_addparam(local3, "0", $02)
                                                                    public_addparam(local3, "0", $02)
                                                                    public_addparam(local3, "0", $02)
                                                                    public_addparam(local3, "0", $02)
                                                                    public_addparam(local3, "0", $02)
                                                                    callback($00)
                                                                    If (se_getreturnvalue() <> "-1") Then
                                                                        local23 = se_getreturnvalue()
                                                                    EndIf
                                                                EndIf
                                                                If (se_return_value\Field8 = $00) Then
                                                                    giveplayerhealth(local21, (Float (- local24)), local23)
                                                                    arg4\Field121 = (millisecs() + $1F4)
                                                                    If (player[local21]\Field61 <> 0) Then
                                                                        If (getscripts() <> 0) Then
                                                                            local3 = public_inqueue($19, $00)
                                                                            public_addparam(local3, (Str arg3), $01)
                                                                            public_addparam(local3, (Str local21), $01)
                                                                            public_addparam(local3, (Str arg4\Field35), $01)
                                                                            callback($00)
                                                                        EndIf
                                                                        local37 = breach_getcategorybytype(arg4\Field36, $01)
                                                                        If (((player[local21]\Field75 = scientist_model) And (local37 = $06)) <> 0) Then
                                                                            breach_givetickets($01, $02)
                                                                        EndIf
                                                                        If (((player[local21]\Field75 = classd_model) And (local37 = $07)) <> 0) Then
                                                                            breach_givetickets($00, $02)
                                                                        EndIf
                                                                    ElseIf (getscripts() <> 0) Then
                                                                        local3 = public_inqueue($12, $00)
                                                                        public_addparam(local3, (Str arg3), $01)
                                                                        public_addparam(local3, (Str player[local21]\Field30), $01)
                                                                        public_addparam(local3, (Str local24), $02)
                                                                        public_addparam(local3, (Str arg4\Field35), $01)
                                                                        callback($00)
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
            If (((arg4\Field61 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                If (arg4\Field141 = $00) Then
                    local36 = readshort(server\Field0)
                    local38 = readfloat(server\Field0)
                    local39 = readfloat(server\Field0)
                    local40 = readfloat(server\Field0)
                    local41 = readfloat(server\Field0)
                    local42 = readfloat(server\Field0)
                    If (local36 < $3E8) Then
                        local2 = m_item[local36]
                        If (local2 <> Null) Then
                            If (local2\Field22 = arg3) Then
                                If (instr(local2\Field3\Field2, "rpg", $01) <> 0) Then
                                    If (4.0 > distance3(local38, local39, local40, entityx(arg4\Field64, $00), entityy(arg4\Field64, $00), entityz(arg4\Field64, $00))) Then
                                        If (mp_isascp(arg4\Field36) = $00) Then
                                            If (getscripts() <> 0) Then
                                                local3 = public_inqueue($0E, $00)
                                                public_addparam(local3, (Str arg3), $01)
                                                public_addparam(local3, (Str local38), $02)
                                                public_addparam(local3, (Str local39), $02)
                                                public_addparam(local3, (Str local40), $02)
                                                public_addparam(local3, (Str local42), $02)
                                                public_addparam(local3, (Str local41), $02)
                                                callback($00)
                                            EndIf
                                            If (se_return_value\Field8 = $00) Then
                                                createrocket(15.0, local38, local39, local40, local41, local42, arg3)
                                                For local14 = $01 To server\Field11 Step $01
                                                    If (50.0 > distance3(local38, local39, local40, entityx(playeroptimize[local14]\Field64, $00), entityy(playeroptimize[local14]\Field64, $00), entityz(playeroptimize[local14]\Field64, $00))) Then
                                                        udp_writebyte($51)
                                                        udp_writebyte(arg3)
                                                        udp_writeshort($00)
                                                        udp_writefloat(local38)
                                                        udp_writefloat(local39)
                                                        udp_writefloat(local40)
                                                        udp_writefloat(local41)
                                                        udp_writefloat(local42)
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
            If (arg4\Field121 < millisecs()) Then
                If (((arg4\Field61 = $00) And ((arg4\Field36 = $00) = $00)) <> 0) Then
                    If (arg4\Field141 = $00) Then
                        local36 = readshort(server\Field0)
                        local38 = readfloat(server\Field0)
                        local39 = readfloat(server\Field0)
                        local40 = readfloat(server\Field0)
                        local41 = readfloat(server\Field0)
                        local42 = readfloat(server\Field0)
                        local43 = readbyte(server\Field0)
                        local44 = (Int min((Float readbyte(server\Field0)), 1.0))
                        If (local36 < $3E8) Then
                            local2 = m_item[local36]
                            If (local2 <> Null) Then
                                If (local2\Field22 = arg3) Then
                                    Select local43
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
                                    If (4.0 > distance3(local38, local39, local40, entityx(arg4\Field64, $00), entityy(arg4\Field64, $00), entityz(arg4\Field64, $00))) Then
                                        If (((mp_isascp(arg4\Field36) = $00) And (arg4\Field36 <> $00)) <> 0) Then
                                            If (getscripts() <> 0) Then
                                                local3 = public_inqueue($0F, $00)
                                                public_addparam(local3, (Str arg3), $01)
                                                public_addparam(local3, (Str local38), $02)
                                                public_addparam(local3, (Str local39), $02)
                                                public_addparam(local3, (Str local40), $02)
                                                public_addparam(local3, (Str local42), $02)
                                                public_addparam(local3, (Str local41), $02)
                                                public_addparam(local3, (Str local43), $01)
                                                public_addparam(local3, (Str local44), $01)
                                                callback($00)
                                            EndIf
                                            If (se_return_value\Field8 = $00) Then
                                                If (local43 = $0D) Then
                                                    creategrenade(local38, local39, local40, local41, local42, arg3, local44)
                                                EndIf
                                                For local14 = $01 To server\Field11 Step $01
                                                    udp_writebyte($74)
                                                    udp_writebyte(arg3)
                                                    udp_writeshort($00)
                                                    udp_writefloat(local38)
                                                    udp_writefloat(local39)
                                                    udp_writefloat(local40)
                                                    udp_writefloat(local41)
                                                    udp_writefloat(local42)
                                                    udp_writebyte(local43)
                                                    udp_writebyte(local44)
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
                        arg4\Field121 = (millisecs() + $1F4)
                        Return $00
                    Else
                        oncheatdetected(arg3, $01)
                    EndIf
                EndIf
            EndIf
            readignorebytes($18)
        Case $16
            local46 = readint(server\Field0)
            If (server\Field56 <> 0) Then
                If (arg4\Field69 = "room1162") Then
                    local6 = room[arg4\Field32]
                    If (2.0 > entitydistance(local6\Field25[$00], arg4\Field64)) Then
                        If (arg4\Field61 = $00) Then
                            local47 = $00
                            For local48 = Each itemtemplates
                                If (isitemgoodfor1162(local48) <> 0) Then
                                    local47 = $00
                                    If (arg4\Field140 <> "") Then
                                        Select arg4\Field140
                                            Case "key"
                                                If (((local48\Field2 = "key1") Or ((local48\Field2 = "key2") And (rand($02, $01) = $01))) <> 0) Then
                                                    local47 = $01
                                                EndIf
                                            Case "paper","oldpaper"
                                                If (((local48\Field2 = "paper") And (rand($0C, $01) = $01)) <> 0) Then
                                                    local47 = $01
                                                EndIf
                                            Case "gasmask","gasmask3","supergasmask","hazmatsuit","hazmatsuit2","hazmatsuit3"
                                                If (((((((local48\Field2 = "gasmask") Or (local48\Field2 = "gasmask3")) Or (local48\Field2 = "supergasmask")) Or (local48\Field2 = "hazmatsuit")) Or (local48\Field2 = "hazmatsuit2")) Or ((local48\Field2 = "hazmatsuit3") And (rand($02, $01) = $01))) <> 0) Then
                                                    local47 = $01
                                                EndIf
                                            Case "key1","key2","key3"
                                                If (((((local48\Field2 = "key1") Or (local48\Field2 = "key2")) Or (local48\Field2 = "key3")) Or ((local48\Field2 = "misc") And (rand($06, $01) = $01))) <> 0) Then
                                                    local47 = $01
                                                EndIf
                                            Case "vest","finevest"
                                                If (((local48\Field2 = "vest") Or ((local48\Field2 = "finevest") And (rand($01, $01) = $01))) <> 0) Then
                                                    local47 = $01
                                                EndIf
                                            Default
                                                If (((local48\Field2 = "misc") And (rand($06, $01) = $01)) <> 0) Then
                                                    local47 = $01
                                                EndIf
                                        End Select
                                        If (local47 <> 0) Then
                                            local2 = createitem(local48\Field1, local48\Field2, arg4\Field0, (arg4\Field1 + 0.1), arg4\Field2, $00, $00, $00, 1.0, $00, $01)
                                            If (getscripts() <> 0) Then
                                                local3 = public_inqueue($1C, $00)
                                                public_addparam(local3, (Str arg3), $01)
                                                public_addparam(local3, (Str local2\Field18), $01)
                                                public_addparam(local3, (Str local46), $01)
                                                callback($00)
                                            EndIf
                                            arg4\Field140 = ""
                                            Exit
                                        EndIf
                                    Else
                                        If (player[arg3]\Field61 = $00) Then
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
