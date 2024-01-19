Function multiplayer_getpacket%(arg0%, arg1%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7.players
    Local local10%
    Local local11.doors
    Local local12.players
    Local local13%
    Local local14%
    Local local15$
    Local local16$
    Local local17$
    Local local18$
    Local local19%
    Local local20$
    Local local21%
    Local local22%
    Local local23.rooms
    Local local24$
    Local local25.chatmessage
    Local local26%
    Local local27$
    Local local28%
    Local local29%
    Local local30%
    Local local31.querys
    Local local32%
    Local local33%
    Local local34.scriptsthread
    Local local35.scriptsthread
    Local local36$
    Local local37%
    Local local39.npcs
    Local local41.items
    Local local42.itemtemplates
    Local local43%
    Local local44#
    Local local45#
    Local local46#
    Local local47#
    Local local48$
    Local local49.events
    Local local50.p_obj
    Local local51.breachtypes
    Local local52.sound
    Local local53$
    Local local54%
    Local local55$
    Local local56%
    Local local57$
    Local local58.multiplayer_texts
    Local local59.multiplayer_texts
    Local local60.draws
    Local local61.draws
    Local local62%
    Local local63%
    Local local64.multiplayer_objects
    Local local65.multiplayer_objects
    Local local66.snd3d
    Local local67$
    Local local68#
    Local local69%
    Local local70%
    Local local71%
    Local local72%
    Local local73%
    Local local74%
    Local local75%
    Local local76%
    Local local77%
    Local local78%
    Local local79%
    Local local80.particles
    Local local81%
    Local local82.decals
    Local local83%
    Local local84#
    Local local85#
    Local local86#
    Local local87#
    Local local88#
    Local local89#
    Local local90#
    Local local91#
    Local local92#
    Local local93#
    Local local94#
    Local local95#
    Local local96.decals
    Local local97%
    Local local98%
    Local local99%
    Local local100%
    If (isvalidplayer(arg1) = $00) Then
        Return $00
    EndIf
    If (arg0 <> $71) Then
        local7 = player[arg1]
    EndIf
    multiplayer_setservertime(((millisecs() + networkserver\Field3) + $7D0))
    Select arg0
        Case $80
            myplayer\Field70 = (myplayer\Field70 - (Float rand($1E, $28)))
        Case $76
            blinktimer = udp_readfloat()
        Case $4A
            If (networkserver\Field15 <> 0) Then
                local7\Field51 = (Int max(min((Float udp_readbyte()), (Float (last_breach_type - $01))), 0.0))
            EndIf
        Case $79
            myplayer\Field83 = (myplayer\Field83 = $00)
        Case $01
            If (arg1 <> networkserver\Field28) Then
                Select udp_readbyte()
                    Case $00
                        local7\Field44 = (millisecs() + networkserver\Field3)
                        local7\Field34 = (Str udp_readbyte())
                        local7\Field43 = udp_readbyte()
                        If (local7\Field34 = "0") Then
                            local7\Field34 = "Not Ready"
                        Else
                            local7\Field34 = "Ready"
                        EndIf
                        udp_readbyte()
                        udp_readbyte()
                        udp_readbyte()
                        udp_readbyte()
                    Case $01
                        local7\Field44 = (millisecs() + networkserver\Field3)
                        local7\Field4 = convertshorttovalue((Float udp_readshort()))
                        local7\Field5 = convertshorttovalue((Float udp_readshort()))
                        local7\Field31 = udp_readfloat()
                        local7\Field79 = udp_readbyte()
                        local10 = readbool(local7\Field79, $00)
                        local7\Field39 = readbool(local7\Field79, $01)
                        local7\Field38 = readbool(local7\Field79, $02)
                        local7\Field41 = readbool(local7\Field79, $03)
                        local7\Field83 = readbool(local7\Field79, $05)
                        local7\Field82 = readbool(local7\Field79, $06)
                        local7\Field36 = (Float udp_readbyte())
                        local7\Field72 = udp_readbyte()
                        local7\Field37 = udp_readbyte()
                        local7\Field43 = readbool(local7\Field72, $00)
                        local7\Field102 = readbool(local7\Field72, $01)
                        local7\Field68 = udp_readshort()
                        udp_readbyte()
                        udp_readbyte()
                        udp_readbyte()
                        udp_readbyte()
                        udp_readfloat()
                        local7\Field55 = udp_readbyte()
                        udp_readshort()
                        local7\Field1 = udp_readfloat()
                        local7\Field2 = udp_readfloat()
                        local7\Field3 = udp_readfloat()
                        local7\Field47 = udp_readbyte()
                        local7\Field67 = udp_readbyte()
                        multiplayer_setplayerroom(local7)
                        host_updateplayer(arg1, local7\Field50, local10, local7\Field72)
                End Select
                If (udp_readavail() <= $280) Then
                    While (udp_readavail() > $00)
                        multiplayer_getmicrobytepacket(udp_readbyte(), arg1, local7)
                    Wend
                EndIf
            EndIf
        Case $58
            udp_writebyte($32)
            udp_writebyte($01)
            For local11 = Each doors
                udp_writeshort(local11\Field18)
                udp_writebyte((local11\Field5 + (local11\Field4 Shl $01)))
            Next
            udp_writeshort($00)
            udp_sendmessage(arg1)
        Case $6C
            udp_writebyte($6C)
            udp_writebyte($01)
            udp_writeline("")
            udp_writefloat(0.0)
            udp_writefloat(0.0)
            udp_writefloat(0.0)
            udp_sendmessage(arg1)
        Case $0D
            multiplayer_createmessage((local7\Field24 + " has left the server"), $FFFFFFFF)
            For local12 = Each players
                If (local12\Field0 <> $01) Then
                    udp_writebyte($0B)
                    udp_writebyte($00)
                    udp_writeline((local7\Field24 + " has left the server"))
                    udp_writebyte($01)
                    udp_sendmessage(local12\Field0)
                EndIf
            Next
            multiplayer_disconnectplayer(player[arg1])
            networkserver\Field29 = (networkserver\Field29 - $01)
        Case $7E
            For local12 = Each players
                If (local12\Field0 <> networkserver\Field28) Then
                    If (bs_csteamid_getaccountid(udp_udpmsgip()) = bs_csteamid_getaccountid(local12\Field29)) Then
                        local13 = $01
                        Exit
                    EndIf
                EndIf
            Next
            If (local13 = $00) Then
                udp_writebyte($7D)
                udp_writebyte($02)
                udp_sendmessageinternal($00, udp_network\Field7, $00, $02)
                udp_network\Field7 = $00
            EndIf
        Case $1A
            local15 = dottedip(local14)
            local16 = left(udp_readline(), $18)
            local17 = udp_readline()
            local18 = udp_readline()
            local19 = udp_readbyte()
            local20 = ""
            If (local18 <> networkserver\Field20) Then
                local20 = "Wrong password"
            EndIf
            If (local16 = "") Then
                local20 = "Set nickname."
            EndIf
            If (instr(local16, "%", $01) <> 0) Then
                local20 = "Invalid syntax, please change your nickname!"
            EndIf
            For local12 = Each players
                If (lower(local12\Field24) = lower(local16)) Then
                    local20 = (((((("Change your nickname" + chr($0D)) + chr($0A)) + "A player with this name") + chr($0D)) + chr($0A)) + "is already on the server")
                    Exit
                EndIf
            Next
            If (((multiplayer_version <> local17) Or (local19 <> $02)) <> 0) Then
                local20 = (((((((("Version doesn't match" + chr($0D)) + chr($0A)) + "Server version: ") + multiplayer_version) + chr($0D)) + chr($0A)) + "Game version: ") + local17)
            EndIf
            If (networkserver\Field29 = networkserver\Field14) Then
                local20 = "Server lobby is full!"
            EndIf
            If (local20 <> "") Then
                udp_writebyte($71)
                udp_writeline(local20)
                If (networkserver\Field42 = $00) Then
                    udp_writeint(udp_udpmsgip())
                    udp_writeint(udp_udpmsgport())
                    udp_sendmessageinternal(udp_network\Field0, udp_network\Field1, udp_network\Field2, $02)
                Else
                    udp_sendmessageinternal(udp_network\Field0, udp_udpmsgip(), udp_udpmsgport(), $02)
                EndIf
                If (networkserver\Field49 <> 0) Then
                    bs_isteamnetworking_closep2psessionwithuser(bs_steamnetworking(), udp_fillsteam(bs_csteamid_getaccountid(udp_udpmsgip())))
                    bs_csteamid_destroy(udp_udpmsgip())
                    udp_network\Field7 = $00
                EndIf
                Return $00
            EndIf
            networkserver\Field29 = (networkserver\Field29 + $01)
            arg1 = findfreeplayerid()
            multiplayer_createplayer(arg1)
            local7 = player[arg1]
            local7\Field75 = udp_readshort()
            local7\Field76 = udp_readshort()
            local7\Field77 = udp_readbyte()
            local7\Field95 = udp_readint()
            local7\Field51 = classd_model
            local7\Field44 = (millisecs() + networkserver\Field3)
            local7\Field29 = udp_udpmsgip()
            local7\Field30 = udp_udpmsgport()
            local7\Field48 = $05
            local7\Field50 = rand($01, $03)
            If (local7\Field77 <> 0) Then
                local7\Field88 = "PATRON"
                local7\Field89 = $D4
                local7\Field90 = $A0
                local7\Field91 = $31
            EndIf
            local21 = $00
            For local22 = $00 To $02 Step $01
                If (selecteddifficulty = difficulties(local22)) Then
                    local21 = local22
                    Exit
                EndIf
            Next
            udp_writebyte($1A)
            udp_writebyte(arg1)
            udp_writeline(randomseed)
            udp_writebyte(introenabled)
            udp_writebyte(nocheat)
            udp_writebyte(networkserver\Field24)
            udp_writefloat(0.0)
            udp_writeint(networkserver\Field3)
            udp_writefloat(networkserver\Field12)
            udp_writebyte(networkserver\Field13)
            udp_writebyte(networkserver\Field14)
            udp_writebyte(networkserver\Field19)
            udp_writebyte($00)
            udp_writebyte(networkserver\Field23)
            udp_writebyte(local7\Field51)
            udp_writeint($FFFFFFFF)
            udp_writeint($00)
            udp_writebyte(local7\Field50)
            udp_writeint($FFFFFFFF)
            udp_writebyte(local21)
            udp_writebyte((mainmenuopen = $00))
            udp_writeint(networkserver\Field30)
            udp_writeline("")
            udp_writebyte($00)
            udp_writebyte(networkserver\Field47)
            udp_writebyte(networkserver\Field48)
            udp_writebyte($00)
            udp_writebyte($00)
            udp_writebyte($00)
            udp_writebyte($00)
            udp_writeline("")
            udp_writeline("")
            udp_writebyte(halloweenindex)
            udp_writebyte(newyearindex)
            udp_sendmessage(arg1)
            multiplayer_initplayer(arg1)
            multiplayer_changeplayername(arg1, local16, local7\Field88)
            multiplayer_createmessage((local7\Field24 + " has joined to server"), $FFFFFFFF)
            For local12 = Each players
                If (local12\Field0 <> $01) Then
                    udp_writebyte($0B)
                    udp_writebyte($00)
                    udp_writeline((local7\Field24 + " has joined to server"))
                    udp_writebyte($01)
                    udp_sendmessage(local12\Field0)
                EndIf
            Next
            If (introenabled = $00) Then
                For local23 = Each rooms
                    If (local23\Field7\Field11 = "start") Then
                        player[arg1]\Field1 = (entityx(local23\Field2, $00) + (3584.0 * roomscale))
                        player[arg1]\Field2 = ((704.0 * roomscale) - 0.9)
                        player[arg1]\Field3 = (entityz(local23\Field2, $00) + (1024.0 * roomscale))
                        player[arg1]\Field4 = 130.3
                        player[arg1]\Field47 = local23\Field65
                        player[arg1]\Field55 = $0B
                        Exit
                    EndIf
                Next
            Else
                For local23 = Each rooms
                    If (local23\Field7\Field11 = "173") Then
                        player[arg1]\Field1 = entityx(local23\Field2, $00)
                        player[arg1]\Field2 = 1.0
                        player[arg1]\Field3 = entityz(local23\Field2, $00)
                        player[arg1]\Field4 = 130.3
                        player[arg1]\Field47 = local23\Field65
                        player[arg1]\Field55 = $0B
                        Exit
                    EndIf
                Next
            EndIf
        Case $23
            If (networkserver\Field49 <> 0) Then
                Return $00
            EndIf
            udp_writeline(networkserver\Field21)
            udp_writeline((((Str networkserver\Field29) + " / ") + (Str networkserver\Field14)))
            udp_writebyte(nocheat)
            udp_writebyte((mainmenuopen = $00))
            If (networkserver\Field20 <> "") Then
                udp_writeline("PS")
            Else
                udp_writeline("")
            EndIf
            udp_writebyte($00)
            udp_writebyte(networkserver\Field24)
            udp_writeline(randomseed)
            udp_writeline("")
            udp_writeline("")
            udp_writeline(multiplayer_version)
            If ((networkserver\Field18 And (networkserver\Field42 = $00)) <> 0) Then
                udp_writebyte($FE)
                udp_writeint(udp_network\Field7)
                udp_writeint(udp_network\Field8)
                udp_sendmessageinternal(udp_network\Field0, udp_network\Field1, udp_network\Field2, $02)
            Else
                udp_sendmessageinternal(udp_network\Field0, udp_network\Field7, udp_network\Field8, $02)
            EndIf
        Case $0B
            local24 = udp_readline()
            If (udp_readbyte() <> 0) Then
                If (local7 <> Null) Then
                    local25 = multiplayer_createmessage((local7\Field24 + local24), $FFFFFFFF)
                Else
                    local25 = multiplayer_createmessage(local24, $FFFFFFFF)
                EndIf
            EndIf
        Case $72
            If (getscripts() <> 0) Then
                local26 = createbank(udp_readavail())
                udp_readbytes(local26, $00, banksize(local26))
                public_inqueue($10, $00)
                public_addparam((Str local26), $01)
                callback()
                freebank(local26)
            EndIf
        Case $70
            local27 = udp_readline()
            local28 = udp_readint()
            local29 = $FFFFFFFF
            local30 = $00
            If (isfoldersecured(local27) = $00) Then
                udp_readint()
                udp_writebyte($6F)
                udp_writebyte(networkserver\Field28)
                udp_writeint(local28)
                udp_writeint(udp_readint())
                udp_writeshort((Int networkserver\Field41))
                udp_sendmessage($00)
                Return $00
            EndIf
            For local31 = Each querys
                If (local31\Field4 = local28) Then
                    local29 = udp_readint()
                    udp_readint()
                    If (local29 = filepos(local31\Field3)) Then
                        resizebank(local31\Field10, (udp_readavail() - $05))
                        udp_readbytes(local31\Field10, $00, banksize(local31\Field10))
                        writebytes(local31\Field10, local31\Field3, $00, banksize(local31\Field10))
                        local31\Field6 = (local31\Field6 + banksize(local31\Field10))
                    ElseIf (local29 > filepos(local31\Field3)) Then
                        udp_writebyte($6F)
                        udp_writebyte(networkserver\Field28)
                        udp_writeint(local31\Field4)
                        udp_writeint(filepos(local31\Field3))
                        udp_writeshort((Int networkserver\Field41))
                        udp_sendmessage($00)
                    EndIf
                    Exit
                EndIf
            Next
            If (local29 = $FFFFFFFF) Then
                udp_readint()
                local31 = (New querys)
                local31\Field4 = local28
                local31\Field1 = udp_readint()
                local31\Field0 = local27
                local31\Field10 = createbank((udp_readavail() - $05))
                udp_readbytes(local31\Field10, $00, banksize(local31\Field10))
                local31\Field8 = udp_readbyte()
                local31\Field9 = udp_readint()
                If (local31\Field9 <> $00) Then
                    If (filesize((("multiplayer\serversdata\" + local31\Field0) + ".packed")) = local31\Field1) Then
                        udp_writebyte($6F)
                        udp_writebyte(networkserver\Field28)
                        udp_writeint(local31\Field4)
                        udp_writeint(local31\Field1)
                        udp_writeshort((Int networkserver\Field41))
                        udp_sendmessage($00)
                        local32 = readfile((("multiplayer\serversdata\" + local31\Field0) + ".packed"))
                        If (local32 <> $00) Then
                            local26 = createbank(local31\Field1)
                            readbytes(local26, local32, $00, local31\Field1)
                            closefile(local32)
                        EndIf
                        If (local26 <> $00) Then
                            local33 = zipapi_uncompress(local26, local31\Field9)
                            debuglog(("UNCOMPRESSED: " + (Str local33)))
                            If (local33 <> $00) Then
                                local32 = writefiledir(("multiplayer\serversdata\" + local31\Field0))
                                writebytes(local33, local32, $00, local31\Field9)
                                closefile(local32)
                                deletefile((("multiplayer\serversdata\" + local31\Field0) + ".packed"))
                            EndIf
                        EndIf
                        If (local31\Field10 <> $00) Then
                            freebank(local31\Field10)
                        EndIf
                        Delete local31
                    ElseIf (filesize(("multiplayer\serversdata\" + local31\Field0)) <> local31\Field9) Then
                        local31\Field3 = writefiledir((("multiplayer\serversdata\" + local31\Field0) + ".packed"))
                        udp_writebyte($6F)
                        udp_writebyte(networkserver\Field28)
                        udp_writeint(local31\Field4)
                        udp_writeint(filepos(local31\Field3))
                        udp_writeshort((Int networkserver\Field41))
                        udp_sendmessage($00)
                    Else
                        udp_writebyte($6F)
                        udp_writebyte(networkserver\Field28)
                        udp_writeint(local31\Field4)
                        udp_writeint(local31\Field1)
                        udp_writeshort((Int networkserver\Field41))
                        udp_sendmessage($00)
                        If (local31\Field10 <> $00) Then
                            freebank(local31\Field10)
                        EndIf
                        Delete local31
                    EndIf
                ElseIf (((filesize(("multiplayer\serversdata\" + local31\Field0)) = local31\Field1) And (local31\Field8 = $00)) <> 0) Then
                    udp_writebyte($6F)
                    udp_writebyte(networkserver\Field28)
                    udp_writeint(local31\Field4)
                    udp_writeint(local31\Field1)
                    udp_writeshort((Int networkserver\Field41))
                    udp_sendmessage($00)
                    If (local31\Field8 <> 0) Then
                        For local34 = Each scriptsthread
                            If (local34\Field1 = ("multiplayer\serversdata\" + local31\Field0)) Then
                                Return $00
                            EndIf
                        Next
                        local35 = (New scriptsthread)
                        local35\Field0 = se_loadscriptexec(("multiplayer\serversdata\" + local31\Field0))
                        local35\Field1 = ("multiplayer\serversdata\" + local31\Field0)
                        skynet_onload($00)
                        init_publics_for_script(local35\Field0)
                        public_inqueue($13, $00)
                        public_update_current(local35\Field0, $00)
                        public_clear()
                        deletefile(("multiplayer\serversdata\" + local31\Field0))
                    EndIf
                    If (local31\Field10 <> $00) Then
                        freebank(local31\Field10)
                    EndIf
                    Delete local31
                Else
                    local31\Field3 = writefiledir(("multiplayer\serversdata\" + local31\Field0))
                    udp_writebyte($6F)
                    udp_writebyte(networkserver\Field28)
                    udp_writeint(local31\Field4)
                    udp_writeint(filepos(local31\Field3))
                    udp_writeshort((Int networkserver\Field41))
                    udp_sendmessage($00)
                EndIf
                If (local31 <> Null) Then
                    If (local31\Field3 <> $00) Then
                        writebytes(local31\Field10, local31\Field3, $00, banksize(local31\Field10))
                        local31\Field6 = (local31\Field6 + banksize(local31\Field10))
                    EndIf
                EndIf
            EndIf
        Case $6D
            If (player[arg1] <> Null) Then
                local16 = udp_readline()
                local36 = udp_readline()
                player[arg1]\Field89 = udp_readbyte()
                player[arg1]\Field90 = udp_readbyte()
                player[arg1]\Field91 = udp_readbyte()
                multiplayer_changeplayername(arg1, local16, local36)
                player[arg1]\Field92 = ((Float udp_readshort()) / 100.0)
                If (0.0 = player[arg1]\Field92) Then
                    player[arg1]\Field92 = 1.0
                EndIf
                local37 = player[arg1]\Field95
                player[arg1]\Field95 = udp_readint()
                If (local37 <> player[arg1]\Field95) Then
                    If (player[arg1]\Field96 <> $00) Then
                        freeimage(player[arg1]\Field96)
                        player[arg1]\Field96 = $00
                    EndIf
                EndIf
                multiplayer_initsettingsforplayer(player[arg1], player[arg1]\Field51, udp_readbyte(), player[arg1]\Field40, player[arg1]\Field72)
            EndIf
        Case $69
            camerafognear = 0.5
            camerafogfar = udp_readfloat()
        Case $68
            otherindex = udp_readbyte()
            Select network_byte[otherindex]
                Case $3D
                    If (((quickloadpercent = $FFFFFFFF) Or (quickloadpercent = $64)) <> 0) Then
                        notarget = udp_readbyte()
                        Repeat
                            otherindex = udp_readbyte()
                            If (otherindex = $00) Then
                                Exit
                            EndIf
                            otherindex2 = udp_readbyte()
                            local39 = m_npc[otherindex]
                            If (local39 = Null) Then
                                local39 = createnpc(otherindex2, 0.0, 0.0, 0.0)
                                setnpcid(local39, otherindex)
                            EndIf
                            resetnpc(local39, otherindex2)
                            local39\Field76 = 700.0
                            local39\Field24 = (Float udp_readbyte())
                            local39\Field9 = udp_readfloat()
                            local39\Field10 = udp_readfloat()
                            local39\Field11 = udp_readfloat()
                            local39\Field85 = udp_readfloat()
                            local39\Field86 = udp_readfloat()
                            local39\Field87 = udp_readfloat()
                            local39\Field92 = udp_readfloat()
                            local39\Field91 = udp_readfloat()
                            changenpctextureid(local39, (udp_readbyte() - $01))
                            local39\Field80 = udp_readbyte()
                            local39\Field81 = udp_readbyte()
                            local39\Field31 = m_npc[udp_readbyte()]
                            If (m_event[local39\Field80] <> Null) Then
                                m_event[local39\Field80]\Field1\Field32[local39\Field81] = local39
                            EndIf
                            Select local39\Field5
                                Case $01
                                    curr173 = local39
                                Case $09
                                    curr096 = local39
                                Case $02
                                    curr106 = local39
                                Case $0C
                                    curr5131 = local39
                            End Select
                        Forever
                        For local39 = Each npcs
                            If (1.0 > local39\Field76) Then
                                If (m_event[local39\Field80] <> Null) Then
                                    removeevent(m_event[local39\Field80])
                                EndIf
                                removenpc(local39, $00)
                            Else
                                If (700.0 <> local39\Field76) Then
                                    local39\Field85 = 999.0
                                    local39\Field86 = 999.0
                                    local39\Field87 = 999.0
                                EndIf
                                local39\Field76 = (local39\Field76 - fpsfactor)
                            EndIf
                        Next
                    EndIf
                Case $42
                    Repeat
                        otherindex = udp_readshort()
                        If (otherindex = $00) Then
                            Exit
                        EndIf
                        local41 = m_item[otherindex]
                        otherindex2 = udp_readint()
                        local0 = udp_readfloat()
                        local1 = udp_readfloat()
                        local2 = udp_readfloat()
                        otherindex3 = udp_readbyte()
                        If (local41 = Null) Then
                            For local42 = Each itemtemplates
                                If (local42\Field0 = otherindex2) Then
                                    local41 = createitembytemplate(local42, 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00, $01)
                                    entitytype(local41\Field1, $03, $00)
                                    Exit
                                EndIf
                            Next
                        ElseIf (local41\Field3\Field0 <> otherindex2) Then
                            removeitem(local41, $00)
                            For local42 = Each itemtemplates
                                If (local42\Field0 = otherindex2) Then
                                    local41 = createitembytemplate(local42, 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00, $01)
                                    entitytype(local41\Field1, $03, $00)
                                    Exit
                                EndIf
                            Next
                        EndIf
                        If (local41 <> Null) Then
                            setitemid(local41, otherindex)
                            local41\Field20 = 1.0
                            local41\Field24 = local0
                            local41\Field25 = local1
                            local41\Field26 = local2
                            local41\Field22 = otherindex3
                            local41\Field15 = (local41\Field22 <> $00)
                        EndIf
                    Forever
                    For local41 = Each items
                        If (0.0 = local41\Field20) Then
                            removeitem(local41, $00)
                        Else
                            local41\Field20 = 0.0
                        EndIf
                    Next
                Case $32
                    Repeat
                        otherindex = udp_readshort()
                        If (otherindex = $00) Then
                            Exit
                        EndIf
                        local11 = multiplayer_door[otherindex]
                        otherindex2 = udp_readbyte()
                        If (local11 <> Null) Then
                            local11\Field5 = readbool(otherindex2, $00)
                            local11\Field4 = readbool(otherindex2, $01)
                            If (readbool(otherindex2, $02) <> 0) Then
                                local43 = local11\Field12
                                local11\Field12 = udp_readbyte()
                                If (((local43 = $00) And (local11\Field12 > $00)) <> 0) Then
                                    For local22 = $00 To $01 Step $01
                                        If (local11\Field3[local22] <> $00) Then
                                            local44 = entityx(local11\Field3[local22], $00)
                                            local45 = entityy(local11\Field3[local22], $00)
                                            local46 = entityz(local11\Field3[local22], $00)
                                            local47 = entityyaw(local11\Field3[local22], $00)
                                            freeentity(local11\Field3[local22])
                                            local11\Field3[local22] = copyentity(buttonkeyobj, $00)
                                            entityfx(local11\Field3[local22], $01)
                                            scaleentity(local11\Field3[local22], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local22], local44, local45, local46, $00)
                                            rotateentity(local11\Field3[local22], 0.0, local47, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                                If (((local43 > $00) And (local11\Field12 = $00)) <> 0) Then
                                    For local22 = $00 To $01 Step $01
                                        If (local11\Field3[local22] <> $00) Then
                                            local44 = entityx(local11\Field3[local22], $00)
                                            local45 = entityy(local11\Field3[local22], $00)
                                            local46 = entityz(local11\Field3[local22], $00)
                                            local47 = entityyaw(local11\Field3[local22], $00)
                                            freeentity(local11\Field3[local22])
                                            local11\Field3[local22] = copyentity(buttonobj, $00)
                                            entityfx(local11\Field3[local22], $01)
                                            scaleentity(local11\Field3[local22], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local22], local44, local45, local46, $00)
                                            rotateentity(local11\Field3[local22], 0.0, local47, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                            If (readbool(otherindex2, $03) <> 0) Then
                                local48 = local11\Field17
                                local11\Field38 = udp_readbyte()
                                If (((local48 = "") And (local11\Field38 = $01)) <> 0) Then
                                    local11\Field17 = "ABCD"
                                    For local22 = $00 To $01 Step $01
                                        If (local11\Field3[local22] <> $00) Then
                                            local44 = entityx(local11\Field3[local22], $00)
                                            local45 = entityy(local11\Field3[local22], $00)
                                            local46 = entityz(local11\Field3[local22], $00)
                                            local47 = entityyaw(local11\Field3[local22], $00)
                                            freeentity(local11\Field3[local22])
                                            local11\Field3[local22] = copyentity(buttoncodeobj, $00)
                                            entityfx(local11\Field3[local22], $01)
                                            scaleentity(local11\Field3[local22], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local22], local44, local45, local46, $00)
                                            rotateentity(local11\Field3[local22], 0.0, local47, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                                If (((local48 <> "") And (local11\Field38 = $00)) <> 0) Then
                                    local11\Field17 = ""
                                    For local22 = $00 To $01 Step $01
                                        If (local11\Field3[local22] <> $00) Then
                                            local44 = entityx(local11\Field3[local22], $00)
                                            local45 = entityy(local11\Field3[local22], $00)
                                            local46 = entityz(local11\Field3[local22], $00)
                                            local47 = entityyaw(local11\Field3[local22], $00)
                                            freeentity(local11\Field3[local22])
                                            local11\Field3[local22] = copyentity(buttonobj, $00)
                                            entityfx(local11\Field3[local22], $01)
                                            scaleentity(local11\Field3[local22], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local22], local44, local45, local46, $00)
                                            rotateentity(local11\Field3[local22], 0.0, local47, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        Else
                            If (readbool(otherindex2, $02) <> 0) Then
                                udp_readbyte()
                            EndIf
                            If (readbool(otherindex2, $03) <> 0) Then
                                udp_readbyte()
                            EndIf
                        EndIf
                    Forever
                Case $7F
                    Repeat
                        otherindex = udp_readshort()
                        If (otherindex = $00) Then
                            Exit
                        EndIf
                        local11 = multiplayer_door[otherindex]
                        otherindex2 = udp_readbyte()
                        local0 = udp_readfloat()
                        If (local11 <> Null) Then
                            local11\Field5 = readbool(otherindex2, $00)
                            local11\Field4 = readbool(otherindex2, $01)
                            local11\Field28 = local0
                            If (readbool(otherindex2, $02) <> 0) Then
                                local43 = local11\Field12
                                local11\Field12 = udp_readbyte()
                                If (((local43 = $00) And (local11\Field12 > $00)) <> 0) Then
                                    For local22 = $00 To $01 Step $01
                                        If (local11\Field3[local22] <> $00) Then
                                            local44 = entityx(local11\Field3[local22], $00)
                                            local45 = entityy(local11\Field3[local22], $00)
                                            local46 = entityz(local11\Field3[local22], $00)
                                            local47 = entityyaw(local11\Field3[local22], $00)
                                            freeentity(local11\Field3[local22])
                                            local11\Field3[local22] = copyentity(buttonkeyobj, $00)
                                            entityfx(local11\Field3[local22], $01)
                                            scaleentity(local11\Field3[local22], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local22], local44, local45, local46, $00)
                                            rotateentity(local11\Field3[local22], 0.0, local47, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                                If (((local43 > $00) And (local11\Field12 = $00)) <> 0) Then
                                    For local22 = $00 To $01 Step $01
                                        If (local11\Field3[local22] <> $00) Then
                                            local44 = entityx(local11\Field3[local22], $00)
                                            local45 = entityy(local11\Field3[local22], $00)
                                            local46 = entityz(local11\Field3[local22], $00)
                                            local47 = entityyaw(local11\Field3[local22], $00)
                                            freeentity(local11\Field3[local22])
                                            local11\Field3[local22] = copyentity(buttonobj, $00)
                                            entityfx(local11\Field3[local22], $01)
                                            scaleentity(local11\Field3[local22], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local22], local44, local45, local46, $00)
                                            rotateentity(local11\Field3[local22], 0.0, local47, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                            If (readbool(otherindex2, $03) <> 0) Then
                                local48 = local11\Field17
                                local11\Field38 = udp_readbyte()
                                If (((local48 = "") And (local11\Field38 = $01)) <> 0) Then
                                    local11\Field17 = "ABCD"
                                    For local22 = $00 To $01 Step $01
                                        If (local11\Field3[local22] <> $00) Then
                                            local44 = entityx(local11\Field3[local22], $00)
                                            local45 = entityy(local11\Field3[local22], $00)
                                            local46 = entityz(local11\Field3[local22], $00)
                                            local47 = entityyaw(local11\Field3[local22], $00)
                                            freeentity(local11\Field3[local22])
                                            local11\Field3[local22] = copyentity(buttoncodeobj, $00)
                                            entityfx(local11\Field3[local22], $01)
                                            scaleentity(local11\Field3[local22], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local22], local44, local45, local46, $00)
                                            rotateentity(local11\Field3[local22], 0.0, local47, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                                If (((local48 <> "") And (local11\Field38 = $00)) <> 0) Then
                                    local11\Field17 = ""
                                    For local22 = $00 To $01 Step $01
                                        If (local11\Field3[local22] <> $00) Then
                                            local44 = entityx(local11\Field3[local22], $00)
                                            local45 = entityy(local11\Field3[local22], $00)
                                            local46 = entityz(local11\Field3[local22], $00)
                                            local47 = entityyaw(local11\Field3[local22], $00)
                                            freeentity(local11\Field3[local22])
                                            local11\Field3[local22] = copyentity(buttonobj, $00)
                                            entityfx(local11\Field3[local22], $01)
                                            scaleentity(local11\Field3[local22], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local22], local44, local45, local46, $00)
                                            rotateentity(local11\Field3[local22], 0.0, local47, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        Else
                            If (readbool(otherindex2, $02) <> 0) Then
                                udp_readbyte()
                            EndIf
                            If (readbool(otherindex2, $03) <> 0) Then
                                udp_readbyte()
                            EndIf
                        EndIf
                    Forever
                Case $53
                    If (((quickloadpercent = $FFFFFFFF) Or (quickloadpercent = $64)) <> 0) Then
                        Repeat
                            otherindex = udp_readbyte()
                            If (otherindex = $00) Then
                                Exit
                            EndIf
                            local49 = m_event[otherindex]
                            otherindex2 = udp_readbyte()
                            otherindex3 = udp_readbyte()
                            local0 = udp_readfloat()
                            local1 = udp_readfloat()
                            local2 = udp_readfloat()
                            If (local49 = Null) Then
                                local49 = (New events)
                                local49\Field22 = otherindex2
                                local49\Field0 = findeventnameconst(otherindex2)
                                local49\Field1 = room[otherindex3]
                                local49\Field2 = local0
                                local49\Field3 = local1
                                local49\Field4 = local2
                                local49\Field23 = $01
                                local49\Field24 = $00
                                seteventid(local49, otherindex)
                                seteventvarex(local49, $01)
                            Else
                                local49\Field23 = $01
                                local49\Field24 = $00
                                If (local0 > local49\Field2) Then
                                    local49\Field2 = local0
                                EndIf
                                If (local1 > local49\Field3) Then
                                    local49\Field3 = local1
                                EndIf
                                If (local2 > local49\Field4) Then
                                    local49\Field4 = local2
                                EndIf
                            EndIf
                        Forever
                        For local49 = Each events
                            If (local49\Field23 = $00) Then
                                If (isanotremovedevent(local49) = $00) Then
                                    If (isablockedevent(local49) = $00) Then
                                        local49\Field24 = $01
                                        removeevent(local49)
                                    EndIf
                                EndIf
                            Else
                                local49\Field23 = $00
                            EndIf
                        Next
                    EndIf
                Case $54
                    Repeat
                        otherindex = udp_readbyte()
                        If (otherindex = $00) Then
                            Exit
                        EndIf
                        local23 = room[otherindex]
                        otherindex2 = udp_readbyte()
                        local0 = udp_readfloat()
                        local1 = udp_readfloat()
                        local2 = udp_readfloat()
                        local3 = udp_readfloat()
                        local4 = udp_readfloat()
                        local5 = udp_readfloat()
                        If (local23 <> Null) Then
                            If (grabbedentity <> local23\Field25[otherindex2]) Then
                                If (local23\Field25[otherindex2] <> $00) Then
                                    positionentity(local23\Field25[otherindex2], local0, local1, local2, $01)
                                    rotateentity(local23\Field25[otherindex2], local3, local4, local5, $01)
                                EndIf
                            EndIf
                            local23\Field26[otherindex2] = $00
                        EndIf
                    Forever
                Case $83
                    Repeat
                        otherindex = udp_readbyte()
                        If (otherindex = $00) Then
                            Exit
                        EndIf
                        local50 = m_corpse[otherindex]
                        otherindex2 = udp_readbyte()
                        local0 = udp_readfloat()
                        local1 = udp_readfloat()
                        local2 = udp_readfloat()
                        local3 = convertshorttovalue((Float udp_readshort()))
                        local6 = ((Float udp_readshort()) / 100.0)
                        otherindex3 = udp_readbyte()
                        local51 = getbreachtype(otherindex2)
                        If (getsecondpackedvalue(local51\Field14) <> $00) Then
                            If (local50 = Null) Then
                                createrolecorpse(otherindex2, local0, local1, local2, local3, local6, $00, readbool(otherindex3, $01), otherindex, $01)
                            Else
                                If (otherindex2 <> local50\Field5) Then
                                    freeentity(local50\Field2)
                                    local50\Field2 = createrolecorpse(otherindex2, local0, local1, local2, local3, local6, $01, readbool(otherindex3, $01), $00, $00)
                                    local50\Field3 = ((millisecs() + $1D4C0) * (readbool(otherindex3, $00) = $00))
                                    local50\Field4 = 350.0
                                    local50\Field5 = otherindex2
                                EndIf
                                positionentity(local50\Field2, local0, ((local1 - 0.32) - local51\Field52), local2, $00)
                                rotateentity(local50\Field2, local51\Field54, (local51\Field53 + local3), 0.0, $00)
                                local50\Field1 = $01
                                local50\Field3 = ((millisecs() + $1D4C0) * (readbool(otherindex3, $00) = $00))
                            EndIf
                        EndIf
                    Forever
                    For local50 = Each p_obj
                        If (local50\Field1 = $00) Then
                            freeentity(local50\Field2)
                            Delete local50
                        Else
                            local50\Field1 = $00
                        EndIf
                    Next
            End Select
        Case $81
            otherindex = udp_readbyte()
            If (multiplayer_object[otherindex] <> Null) Then
                If (multiplayer_object[otherindex]\Field1 <> $00) Then
                    otherindexstr = udp_readline()
                    local4 = udp_readfloat()
                    local3 = udp_readfloat()
                    If (otherindexstr = "SFX\SCP\513\Bell1.ogg") Then
                        If (curr5131 = Null) Then
                            curr5131 = createnpc($0C, 0.0, 0.0, 0.0)
                            curr5131\Field78 = $01
                        EndIf
                    EndIf
                    If (otherindexstr <> "") Then
                        For local52 = Each sound
                            If (local52\Field1 = otherindexstr) Then
                                play3dsound((Handle local52), camera, multiplayer_object[otherindex]\Field1, local4, local3, "")
                                otherindexstr = ""
                                Exit
                            EndIf
                        Next
                        If (otherindexstr <> "") Then
                            play3dsound($00, camera, multiplayer_object[otherindex]\Field1, local4, local3, otherindexstr)
                        EndIf
                    EndIf
                EndIf
            EndIf
        Case $66
            local53 = udp_readline()
            otherindexstr = local53
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            local54 = createpivot($00)
            positionentity(local54, local0, local1, local2, $00)
            If (otherindexstr = "SFX\SCP\513\Bell1.ogg") Then
                If (curr5131 = Null) Then
                    curr5131 = createnpc($0C, 0.0, 0.0, 0.0)
                    curr5131\Field78 = $01
                EndIf
            EndIf
            If (otherindexstr <> "") Then
                For local52 = Each sound
                    If (local52\Field1 = otherindexstr) Then
                        play3dsoundentity((Handle local52), camera, local54, local4, local3, "")
                        otherindexstr = ""
                        Exit
                    EndIf
                Next
                If (otherindexstr <> "") Then
                    play3dsoundentity($00, camera, local54, local4, local3, otherindexstr)
                EndIf
            EndIf
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (((local12\Field0 <> arg1) And (local12\Field0 <> $01)) <> 0) Then
                        udp_writebyte($66)
                        udp_writebyte($01)
                        udp_writeline(local53)
                        udp_writefloat(local0)
                        udp_writefloat(local1)
                        udp_writefloat(local2)
                        udp_writefloat(local4)
                        udp_writefloat(local3)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $64
            If (networkserver\Field18 <> 0) Then
                local7\Field48 = (Int max(5.0, (Float (millisecs() - local7\Field49))))
            Else
                udp_writebyte($64)
                udp_writebyte(networkserver\Field28)
                udp_sendmessage($00)
            EndIf
        Case $63
            secondarylighton = udp_readfloat()
        Case $62
            msg = udp_readline()
            msgtimer = (Float udp_readint())
        Case $61
            local55 = udp_readline()
            local56 = udp_readbyte()
            executeconsolecommand(local55, $01, local56)
        Case $60
            local57 = udp_readline()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            positionentity(collider, local0, local1, local2, $00)
            resetentity(collider)
            For local23 = Each rooms
                If (local23\Field7\Field11 = local57) Then
                    playerroom = local23
                    updaterooms()
                    updateevents()
                    Exit
                EndIf
            Next
        Case $5F
            networkserver\Field34 = udp_readbyte()
            otherindex2 = $00
            Repeat
                otherindex = udp_readbyte()
                If (otherindex = $00) Then
                    Exit
                EndIf
                If (multiplayer_text[otherindex] = Null) Then
                    multiplayer_text[otherindex] = (New multiplayer_texts)
                EndIf
                multiplayer_text[otherindex]\Field0 = udp_readline()
                multiplayer_text[otherindex]\Field4 = udp_readline()
                multiplayer_text[otherindex]\Field5 = udp_readint()
                multiplayer_text[otherindex]\Field6 = udp_readint()
                multiplayer_text[otherindex]\Field3 = udp_readint()
                multiplayer_text[otherindex]\Field1 = (Float udp_readbyte())
                multiplayer_text[otherindex]\Field7 = $01
            Forever
            For local58 = Each multiplayer_texts
                If (local58\Field7 = $00) Then
                    If (local58\Field2 <> 0) Then
                        For local59 = Each multiplayer_texts
                            If (((local59\Field2 = local58\Field2) And (local59 <> local58)) <> 0) Then
                                otherindex2 = $01
                                Exit
                            EndIf
                        Next
                        If (otherindex2 = $00) Then
                            freefont(local58\Field2)
                        EndIf
                    EndIf
                    Delete local58
                Else
                    local58\Field7 = $00
                EndIf
            Next
        Case $5E
            networkserver\Field32 = udp_readbyte()
            otherindex2 = $00
            Repeat
                otherindex = udp_readbyte()
                If (otherindex = $00) Then
                    Exit
                EndIf
                If (multiplayer_draw[otherindex] = Null) Then
                    multiplayer_draw[otherindex] = (New draws)
                EndIf
                multiplayer_draw[otherindex]\Field0 = udp_readline()
                multiplayer_draw[otherindex]\Field3 = udp_readint()
                multiplayer_draw[otherindex]\Field4 = udp_readint()
                multiplayer_draw[otherindex]\Field5 = udp_readint()
                multiplayer_draw[otherindex]\Field6 = udp_readint()
                multiplayer_draw[otherindex]\Field8 = udp_readint()
                multiplayer_draw[otherindex]\Field1 = udp_readbyte()
                multiplayer_draw[otherindex]\Field7 = $01
            Forever
            For local60 = Each draws
                If (local60\Field7 = $00) Then
                    If (local60\Field2 <> 0) Then
                        For local61 = Each draws
                            If (((local61\Field2 = local60\Field2) And (local61 <> local60)) <> 0) Then
                                otherindex2 = $01
                                Exit
                            EndIf
                        Next
                        If (otherindex2 = $00) Then
                            freeimage(local60\Field2)
                        EndIf
                    EndIf
                    Delete local60
                Else
                    local60\Field7 = $00
                EndIf
            Next
        Case $5D
            networkserver\Field33 = udp_readbyte()
            Repeat
                otherindex = udp_readbyte()
                If (otherindex = $00) Then
                    Exit
                EndIf
                otherindexstr = multiplayer_models[udp_readshort()]
                local0 = udp_readfloat()
                local1 = udp_readfloat()
                local2 = udp_readfloat()
                local4 = convertshorttovalue((Float udp_readshort()))
                local3 = convertshorttovalue((Float udp_readshort()))
                local5 = convertshorttovalue((Float udp_readshort()))
                local6 = udp_readfloat()
                local62 = udp_readshort()
                local63 = (Int max((Float udp_readbyte()), 1.0))
                If (otherindexstr <> "") Then
                    If (multiplayer_object[otherindex] = Null) Then
                        otherindex2 = $00
                        For local64 = Each multiplayer_objects
                            If (((local64\Field0 = otherindexstr) And (local64\Field1 <> $00)) <> 0) Then
                                otherindex2 = copyentity(local64\Field1, $00)
                                Exit
                            EndIf
                        Next
                        If (otherindex2 = $00) Then
                            otherindex2 = loadanimmesh(otherindexstr, $00)
                        EndIf
                        If (otherindex2 <> 0) Then
                            multiplayer_object[otherindex] = (New multiplayer_objects)
                            multiplayer_object[otherindex]\Field1 = otherindex2
                            multiplayer_object[otherindex]\Field0 = otherindexstr
                            entitytype(multiplayer_object[otherindex]\Field1, $01, $00)
                            checkobjectanimation(otherindex)
                        EndIf
                    EndIf
                    If (multiplayer_object[otherindex] <> Null) Then
                        If (multiplayer_object[otherindex]\Field0 <> otherindexstr) Then
                            For local64 = Each multiplayer_objects
                                If (((local64\Field0 = otherindexstr) And (local64\Field1 <> $00)) <> 0) Then
                                    multiplayer_object[otherindex]\Field1 = copyentity(local64\Field1, $00)
                                    Exit
                                EndIf
                            Next
                            If (multiplayer_object[otherindex]\Field1 = $00) Then
                                multiplayer_object[otherindex]\Field1 = loadanimmesh(otherindexstr, $00)
                            EndIf
                            multiplayer_object[otherindex]\Field0 = otherindexstr
                            If (multiplayer_object[otherindex]\Field1 <> 0) Then
                                entitytype(multiplayer_object[otherindex]\Field1, $01, $00)
                                checkobjectanimation(otherindex)
                            EndIf
                        EndIf
                        If (multiplayer_object[otherindex]\Field1 <> $00) Then
                            scaleentity(multiplayer_object[otherindex]\Field1, local6, local6, local6, $00)
                            If (multiplayer_object[otherindex]\Field10 <> 0) Then
                                setanimtime(multiplayer_object[otherindex]\Field1, (Float local62), $00)
                            EndIf
                            multiplayer_object[otherindex]\Field3 = local0
                            multiplayer_object[otherindex]\Field4 = local1
                            multiplayer_object[otherindex]\Field5 = local2
                            multiplayer_object[otherindex]\Field6 = local4
                            multiplayer_object[otherindex]\Field7 = local3
                            multiplayer_object[otherindex]\Field8 = local5
                            multiplayer_object[otherindex]\Field9 = local63
                        EndIf
                        multiplayer_object[otherindex]\Field2 = $01
                    EndIf
                EndIf
            Forever
            For local65 = Each multiplayer_objects
                If (local65\Field2 = $00) Then
                    For local66 = Each snd3d
                        If (local66\Field5 = local65\Field1) Then
                            If (local66\Field0 = $00) Then
                                stopchannel(local66\Field2)
                                If (local66\Field6 <> 0) Then
                                    freeentity(local66\Field5)
                                EndIf
                                Delete local66
                            Else
                                fsound_stopsound(local66\Field2)
                                fsound_stream_stop(local66\Field1)
                                fsound_stream_close(local66\Field1)
                                Delete local66
                            EndIf
                        EndIf
                    Next
                    freeentity(local65\Field1)
                    Delete local65
                Else
                    local65\Field2 = $00
                EndIf
            Next
        Case $55
            multiplayer_send($06, $FFFFFFFF, $FFFFFFFF)
            savepath = udp_readline()
            local67 = udp_readline()
            startloadgame(savepath, local67)
        Case $6B
            While (udp_readavail() > $00)
                udp_readshort()
                local0 = udp_readfloat()
                local1 = udp_readfloat()
                local2 = udp_readfloat()
                local4 = udp_readfloat()
                local3 = udp_readfloat()
                local68 = ((Float udp_readbyte()) / 10.0)
                If (arg1 <> networkserver\Field28) Then
                    If (player[arg1] <> Null) Then
                        local69 = getgunshootticks(player[arg1]\Field37)
                        For local22 = $01 To local69 Step $01
                            createbullet(arg1, 1.0, local0, local1, local2, (rnd((getgunspreadrate(player[arg1]\Field37) * (- local68)), (getgunspreadrate(player[arg1]\Field37) * local68)) + local4), (rnd((getgunspreadrate(player[arg1]\Field37) * (- local68)), (getgunspreadrate(player[arg1]\Field37) * local68)) + local3))
                        Next
                        player[arg1]\Field99 = $01
                    Else
                        createbullet($00, 1.0, local0, local1, local2, local4, local3)
                    EndIf
                    playplayersound(player[arg1], getgunsound(player[arg1]\Field37), 15.0, 1.0, $00)
                EndIf
            Wend
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (((local12\Field0 <> arg1) And (local12\Field0 <> $01)) <> 0) Then
                        udp_writebyte($6B)
                        udp_writebyte(arg1)
                        udp_writeshort($00)
                        udp_writefloat(local0)
                        udp_writefloat(local1)
                        udp_writefloat(local2)
                        udp_writefloat(local4)
                        udp_writefloat(local3)
                        udp_writebyte((Int (local68 * 10.0)))
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $51
            udp_readshort()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            If (arg1 <> networkserver\Field28) Then
                createrocket(15.0, local0, local1, local2, local4, local3, arg1)
                player[arg1]\Field99 = $01
            EndIf
        Case $74
            udp_readshort()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            local70 = udp_readbyte()
            local71 = udp_readbyte()
            If (arg1 <> networkserver\Field28) Then
                creategrenade(local70, local0, local1, local2, local4, local3, arg1, local71)
            EndIf
        Case $35
            If (local7\Field51 = model_106) Then
                movetopocketdimension()
                myplayer\Field70 = (myplayer\Field70 - 55.0)
                If (1.0 > myplayer\Field70) Then
                    kill(("was killed by " + local7\Field24), $00)
                EndIf
            Else
                kill(("was killed by " + local7\Field24), $00)
            EndIf
        Case $1E
            removenpc(m_npc[udp_readbyte()], $00)
        Case $40
            local39 = createnpc(udp_readbyte(), local7\Field1, (local7\Field2 + 0.3), local7\Field3)
            local39\Field9 = udp_readfloat()
        Case $3F
            networkserver\Field35 = udp_readbyte()
            local72 = udp_readshort()
            While (local72 > $00)
                multiplayer_createmessage(udp_readline(), local72)
                local72 = udp_readshort()
            Wend
        Case $3C
            udp_updatedelta($01)
            networkserver\Field18 = $00
            networkserver\Field43 = udp_readbyte()
            multiplayer_breach_setplayertype(udp_readbyte())
            networkserver\Field12 = udp_readfloat()
            b_br\Field5 = (millisecs() + udp_readint())
            b_br\Field7 = (millisecs() + udp_readint())
            serverping = udp_readshort()
            networkserver\Field29 = $01
            Repeat
                local73 = udp_readbyte()
                If (local73 = $00) Then
                    Exit
                Else
                    If (local73 = networkserver\Field28) Then
                        skipdataplayer()
                        local73 = udp_readbyte()
                        If (local73 = $00) Then
                            Exit
                        EndIf
                    EndIf
                    networkserver\Field29 = (networkserver\Field29 + $01)
                    If (player[local73] = Null) Then
                        multiplayer_createplayer(local73)
                        multiplayer_initplayer(local73)
                    EndIf
                    local7 = player[local73]
                    If (networkserver\Field43 = $01) Then
                        otherindex2 = udp_readbyte()
                        If (otherindex2 <> $00) Then
                            local7\Field1 = udp_readfloat()
                            local7\Field2 = udp_readfloat()
                            local7\Field3 = udp_readfloat()
                            local7\Field4 = convertshorttovalue((Float udp_readshort()))
                            local7\Field5 = convertshorttovalue((Float udp_readshort()))
                            local7\Field55 = udp_readbyte()
                            local7\Field31 = udp_readfloat()
                            local7\Field79 = udp_readbyte()
                            otherindex4 = readbool(local7\Field79, $00)
                            local7\Field39 = readbool(local7\Field79, $01)
                            local7\Field38 = readbool(local7\Field79, $02)
                            local7\Field41 = readbool(local7\Field79, $03)
                            local7\Field83 = readbool(local7\Field79, $05)
                            local7\Field82 = readbool(local7\Field79, $06)
                            local7\Field36 = (Float udp_readbyte())
                            local7\Field48 = udp_readshort()
                            otherindex5 = udp_readbyte()
                            local7\Field37 = udp_readbyte()
                            local7\Field68 = udp_readshort()
                            local7\Field47 = udp_readbyte()
                            multiplayer_setplayerroom(local7)
                            multiplayer_initsettingsforplayer(local7, otherindex2, local7\Field50, otherindex4, otherindex5)
                        Else
                            local7\Field1 = 0.0
                            local7\Field2 = 0.0
                            local7\Field3 = 0.0
                            local7\Field48 = udp_readshort()
                            otherindex5 = udp_readbyte()
                            multiplayer_initsettingsforplayer(local7, otherindex2, local7\Field50, $00, otherindex5)
                        EndIf
                    Else
                        If (udp_readbyte() = $00) Then
                            local7\Field34 = "Not Ready"
                        Else
                            local7\Field34 = "Ready"
                        EndIf
                        local7\Field48 = udp_readshort()
                        local7\Field43 = udp_readbyte()
                    EndIf
                    local7\Field81 = $01
                EndIf
            Forever
            myplayer\Field81 = $01
            For local12 = Each players
                If (local12\Field81 = $00) Then
                    multiplayer_disconnectplayer(local12)
                Else
                    local12\Field81 = $00
                EndIf
            Next
            secondarylighton = convertshorttovalue((Float udp_readshort()))
            local73 = udp_readbyte()
            contained106 = readbool(local73, $00)
            remotedooron = readbool(local73, $01)
            mtftimer = (Float udp_readshort())
            itemsrotaterand = (Int convertshorttovalue((Float udp_readshort())))
            local74 = udp_readbyte()
            If (((local74 = $01) And (networkserver\Field64 = $00)) <> 0) Then
                If (networkserver\Field62 = $00) Then
                    networkserver\Field62 = playsound_strict(loadtempsound("SFX\Ending\GateB\DetonatingAlphaWarheads.ogg"))
                EndIf
                If (channelplaying(networkserver\Field63) = $00) Then
                    networkserver\Field63 = playsound_strict(gatebsirensfx)
                EndIf
            Else
                If (channelplaying(networkserver\Field62) <> 0) Then
                    stopchannel(networkserver\Field62)
                EndIf
                If (channelplaying(networkserver\Field63) <> 0) Then
                    stopchannel(networkserver\Field63)
                EndIf
                networkserver\Field62 = $00
            EndIf
            If ((multiplayer_isfullsync() And (networkserver\Field43 = $01)) <> 0) Then
                local75 = udp_readbyte()
                If (readbool(local75, $00) <> 0) Then
                    If (networkserver\Field15 = $00) Then
                        If (0.0 <= killtimer) Then
                            min(-1.0, killtimer)
                        EndIf
                    EndIf
                ElseIf ((((0.0 <= killtimer) = $00) And networkserver\Field15) <> 0) Then
                    multiplayer_requestrole($00)
                EndIf
                noclip = readbool(local75, $01)
                myplayer\Field83 = readbool(local75, $02)
                networkserver\Field65 = readbool(local75, $04)
                rcon\Field0 = readbool(local75, $06)
                injuries = udp_readfloat()
                myplayer\Field70 = (Float udp_readshort())
                If ((((myplayer\Field70 < myplayer\Field71) And (myplayer\Field51 > $00)) And (readbool(local75, $03) = $00)) <> 0) Then
                    camerashake = ((myplayer\Field71 - myplayer\Field70) / 15.0)
                EndIf
                myplayer\Field71 = myplayer\Field70
                myplayer\Field92 = ((Float udp_readshort()) / 100.0)
                myplayer\Field94 = udp_readfloat()
                local76 = readbool(local75, $05)
                If (((local76 = $01) And (myplayer\Field52 = $00)) <> 0) Then
                    playsound_strict(loadtempsound("GFX\multiplayer\game\sounds\Announcement.ogg"))
                EndIf
                If (((local76 = $00) And (myplayer\Field52 = $01)) <> 0) Then
                    playsound_strict(loadtempsound("GFX\multiplayer\game\sounds\Announcement2.ogg"))
                EndIf
                myplayer\Field52 = local76
                playerintercom\Field1 = (Int ((max((Float udp_readint()), 0.0) + (Float millisecs())) - 1.0))
                playerintercom\Field0 = (Int ((max((Float udp_readint()), 0.0) + (Float millisecs())) - 1.0))
                local77 = udp_readbyte()
                If (pocketdimension106 <> Null) Then
                    pocketdimension106\Field3 = (Float local77)
                EndIf
                local78 = udp_readshort()
                If (local78 <> $00) Then
                    If (local78 <> currentpositionid) Then
                        local79 = $00
                        currentpositionid = local78
                        local0 = udp_readfloat()
                        local1 = udp_readfloat()
                        local2 = udp_readfloat()
                        local79 = udp_readbyte()
                        If (local79 = $00) Then
                            local57 = udp_readline()
                        Else
                            local57 = (Str udp_readbyte())
                        EndIf
                        positionentity(collider, local0, local1, local2, $00)
                        resetentity(collider)
                        If (local79 = $00) Then
                            For local23 = Each rooms
                                If (local23\Field7\Field11 = local57) Then
                                    playerroom = local23
                                    updaterooms()
                                    updateevents()
                                    Exit
                                EndIf
                            Next
                        Else
                            For local23 = Each rooms
                                If (local23\Field65 = (Int local57)) Then
                                    playerroom = local23
                                    updaterooms()
                                    updateevents()
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                EndIf
                If (0.1 > injuries) Then
                    bloodloss = 0.0
                EndIf
            EndIf
            If (((networkserver\Field43 = $01) And (mainmenuopen = $01)) <> 0) Then
                startnewgame()
                Return $00
            EndIf
        Case $33
            remotedooron = $01
            For local49 = Each events
                If (local49\Field0 = "gateaentrance") Then
                    local49\Field4 = 1.0
                    local49\Field1\Field29[$01]\Field5 = $01
                ElseIf (local49\Field0 = "exit1") Then
                    local49\Field4 = 1.0
                    local49\Field1\Field29[$04]\Field5 = $01
                EndIf
            Next
            playsound_strict(loadtempsound("SFX\Character\MTF\Announc.ogg"))
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (local12\Field0 <> $01) Then
                        udp_writebyte($33)
                        udp_writebyte($01)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $2E
            If (player_isdead() = $00) Then
                If (multiplayer_isascp(myplayer\Field51) = $00) Then
                    local80 = createparticle(entityx(collider, $00), (entityy(collider, $00) - 0.1), entityz(collider, $00), $05, 0.06, 0.2, $50)
                    local80\Field9 = 0.001
                    local80\Field16 = 0.003
                    local80\Field6 = 0.8
                    local80\Field15 = -0.02
                    local81 = createpivot($00)
                    positionentity(local81, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                    turnentity(local81, 90.0, 0.0, 0.0, $00)
                    entitypick(local81, 0.3)
                    local82 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                    local82\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                    entityalpha(local82\Field0, 1.0)
                    scalesprite(local82\Field0, local82\Field2, local82\Field2)
                    freeentity(local81)
                    multiplayer_writedecal(local82, $01, $01)
                    If (networkserver\Field15 = $00) Then
                        injuries = (rnd(2.0, 3.0) + injuries)
                        If (10.0 <= injuries) Then
                            kill(("was killed by " + local7\Field24), $00)
                        EndIf
                    Else
                        If (1.0 >= injuries) Then
                            injuries = 1.01
                        Else
                            injuries = (injuries + 0.01)
                        EndIf
                        myplayer\Field70 = (myplayer\Field70 - (rnd((getgundamage(local7\Field37) - 3.0), (getgundamage(local7\Field37) + 3.0)) - (Float (wearingvest Shl $03))))
                        If (multiplayer_isascp(local7\Field51) <> 0) Then
                            myplayer\Field70 = (myplayer\Field70 - (Float rand($1E, $28)))
                        EndIf
                        If (1.0 > myplayer\Field70) Then
                            kill(("was killed by " + local7\Field24), $00)
                        EndIf
                    EndIf
                Else
                    myplayer\Field70 = ((myplayer\Field70 - getgundamage(local7\Field37)) - (Float rand($01, $02)))
                    injuries = 0.0
                    If (0.0 > myplayer\Field70) Then
                        godmode = $00
                        kill(("was killed by " + local7\Field24), $00)
                    EndIf
                EndIf
            EndIf
        Case $07
            explosiontimer = (Float udp_readint())
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (local12\Field0 <> $01) Then
                        udp_writebyte($07)
                        udp_writebyte($01)
                        udp_writeint((Int explosiontimer))
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $75
            b_br\Field1 = udp_readline()
            If (b_br\Field1 <> "Warheads") Then
                b_br\Field2 = udp_readbyte()
                b_br\Field3 = udp_readbyte()
                b_br\Field4 = udp_readbyte()
                b_br\Field0 = 1400.0
                If (udp_readbyte() = $00) Then
                    networkserver\Field64 = $00
                Else
                    networkserver\Field64 = $01
                EndIf
            Else
                udp_readbyte()
                udp_readbyte()
                udp_readbyte()
                If (udp_readbyte() = $00) Then
                    networkserver\Field64 = $00
                Else
                    networkserver\Field64 = $01
                EndIf
                b_br\Field1 = ""
            EndIf
        Case $09
            playannouncement(udp_readline(), $00, $00)
        Case $26
            For local49 = Each events
                If (local49\Field0 = "173") Then
                    local49\Field4 = udp_readfloat()
                    Exit
                EndIf
            Next
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (local12\Field0 <> $01) Then
                        udp_writebyte($26)
                        udp_writebyte($01)
                        If (local49 <> Null) Then
                            udp_writefloat(local49\Field4)
                        EndIf
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $2A
            For local49 = Each events
                If (local49\Field0 = "alarm") Then
                    If (local49\Field1\Field32[$00] <> Null) Then
                        removenpc(local49\Field1\Field32[$00], $00)
                    EndIf
                    If (local49\Field1\Field32[$01] <> Null) Then
                        removenpc(local49\Field1\Field32[$01], $00)
                    EndIf
                    If (local49\Field1\Field32[$02] <> Null) Then
                        removenpc(local49\Field1\Field32[$02], $00)
                    EndIf
                    positionentity(curr173\Field4, 0.0, 0.0, 0.0, $00)
                    resetentity(curr173\Field4)
                    showentity(curr173\Field0)
                    removeevent(local49)
                    Exit
                EndIf
            Next
            createconsolemsg("Stopped all sounds.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (local12\Field0 <> $01) Then
                        udp_writebyte($2A)
                        udp_writebyte($01)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $25
            For local49 = Each events
                If (local49\Field0 = "room106") Then
                    If (0.0 = local49\Field2) Then
                        local49\Field2 = 1.0
                        If (soundtransmission = $01) Then
                            If (local49\Field6 <> $00) Then
                                If (channelplaying(local49\Field6) <> 0) Then
                                    stopchannel(local49\Field6)
                                EndIf
                            EndIf
                            femurbreakersfx = loadsound_strict("SFX\Room\106Chamber\FemurBreaker.ogg")
                            local49\Field6 = playsound_strict(femurbreakersfx)
                        EndIf
                    EndIf
                    Exit
                EndIf
            Next
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (local12\Field0 <> $01) Then
                        udp_writebyte($25)
                        udp_writebyte($01)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $12
            For local49 = Each events
                If (local49\Field0 = "gateaentrance") Then
                    local49\Field4 = 1.0
                    local49\Field1\Field29[$01]\Field5 = $01
                ElseIf (local49\Field0 = "exit1") Then
                    local49\Field4 = 1.0
                    local49\Field1\Field29[$04]\Field5 = $01
                EndIf
            Next
            createconsolemsg("Gate A and B are now unlocked.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            remotedooron = $01
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (((local12\Field0 <> arg1) And (local12\Field0 <> $01)) <> 0) Then
                        udp_writebyte($12)
                        udp_writebyte($01)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $0F
        Case $05
            local83 = udp_readbyte()
            local84 = udp_readfloat()
            local85 = udp_readfloat()
            local86 = udp_readfloat()
            local87 = udp_readfloat()
            local88 = udp_readfloat()
            local89 = udp_readfloat()
            local90 = udp_readfloat()
            local91 = udp_readfloat()
            local92 = udp_readfloat()
            local93 = udp_readfloat()
            local94 = udp_readfloat()
            local95 = udp_readfloat()
            local96 = createdecal(local83, local84, local85, local86, local89, local87, local88, 1.0, 1.0)
            If (local83 = $05) Then
                entitycolor(local96\Field0, 0.0, rnd(200.0, 255.0), 0.0)
            EndIf
            local96\Field1 = local90
            local96\Field2 = local91
            local96\Field3 = local92
            local96\Field4 = local93
            local96\Field5 = local94
            local96\Field9 = local95
            entityalpha(local96\Field0, local96\Field5)
            scalesprite(local96\Field0, local96\Field2, local96\Field2)
        Case $16
            If (((arg1 <> networkserver\Field28) Or (networkserver\Field18 = $00)) <> 0) Then
                local97 = udp_readint()
                For local42 = Each itemtemplates
                    If (local42\Field0 = local97) Then
                        local41 = createitem(local42\Field1, local42\Field2, entityx(local7\Field13, $00), (entityy(getplayercamera(arg1), $00) + 0.1), entityz(local7\Field13, $00), $00, $00, $00, 1.0, $00, $01)
                        entitytype(local41\Field1, $03, $00)
                        local41\Field22 = $00
                        Exit
                    EndIf
                Next
            EndIf
        Case $17
            otherindex = udp_readshort()
            otherindex2 = udp_readbyte()
            otherindex3 = udp_readbyte()
            If (arg1 <> networkserver\Field28) Then
                For local11 = Each doors
                    If (local11\Field18 = otherindex) Then
                        local11\Field4 = otherindex3
                        If (local11\Field5 <> otherindex2) Then
                            usedoor(local11, $00, $01, $00, "", $01)
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
        Case $28
            shouldrestartserver = $01
            Return $00
        Case $4B
            shouldrestartserver = $01
            Return $00
        Case $7B
            If (((local7 <> Null) And (arg1 <> networkserver\Field28)) <> 0) Then
                local7\Field86 = $01
            EndIf
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (((local12\Field0 <> arg1) And (local12\Field0 <> $01)) <> 0) Then
                        udp_writebyte($7B)
                        udp_writebyte(arg1)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $1D
            vsrc = createbank((udp_readavail() - $01))
            udp_readbytes(vsrc, $00, banksize(vsrc))
            local98 = udp_readbyte()
            If (((local7 <> Null) And (arg1 <> networkserver\Field28)) <> 0) Then
                local99 = millisecs()
                local7\Field85 = (Int min(max((Float (local99 - local7\Field84)), 5.0), 1000.0))
                local7\Field84 = local99
                If (0.0 <> local7\Field65) Then
                    local100 = opus_pcm_decode(local7\Field87, vsrc, $00)
                    If (local100 <> $00) Then
                        voice_player_receive(arg1, local100, (Float local7\Field85), local98)
                        freebank(local100)
                    EndIf
                EndIf
            EndIf
            If (networkserver\Field18 <> 0) Then
                For local12 = Each players
                    If (((local12\Field0 <> arg1) And (local12\Field0 <> $01)) <> 0) Then
                        udp_writebyte($1D)
                        udp_writebyte(arg1)
                        udp_writebytes(vsrc, $00, banksize(vsrc))
                        udp_writebyte(local12\Field67)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
            freebank(vsrc)
        Case $03
            otherindexstr = udp_readline()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            If (local7 <> Null) Then
                If (local7\Field13 <> $00) Then
                    If (arg1 <> networkserver\Field28) Then
                        playplayersound(local7, otherindexstr, local0, local1, $00)
                    ElseIf (udp_readbyte() = $00) Then
                        If (networkserver\Field18 = $00) Then
                            If (selecteddoor <> Null) Then
                                Select lower(otherindexstr)
                                    Case "sfx\interact\scanneruse1.ogg"
                                        If (selecteddoor\Field17 = (Str accesscode)) Then
                                            giveachievement($1B, $01)
                                        ElseIf (selecteddoor\Field17 = "7816") Then
                                            giveachievement($1C, $01)
                                        EndIf
                                        selecteddoor\Field4 = $00
                                        usedoor(selecteddoor, $01, $01, $00, "", $00)
                                        selecteddoor = Null
                                        resetmouse()
                                    Case "sfx\interact\scanneruse2.ogg"
                                        keypadmsg = "ACCESS DENIED"
                                        keypadtimer = 210.0
                                        keypadinput = ""
                                End Select
                            EndIf
                            playsound_strict(loadtempsound(otherindexstr))
                        EndIf
                    EndIf
                EndIf
            EndIf
    End Select
    Return $00
End Function
