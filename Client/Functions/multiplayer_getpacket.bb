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
    Local local14$
    Local local15$
    Local local16$
    Local local17%
    Local local18$
    Local local19%
    Local local20%
    Local local21.rooms
    Local local22$
    Local local23.chatmessage
    Local local24%
    Local local25$
    Local local26%
    Local local27%
    Local local28%
    Local local29.querys
    Local local30$
    Local local31%
    Local local33.npcs
    Local local35.items
    Local local36.itemtemplates
    Local local37%
    Local local38#
    Local local39#
    Local local40#
    Local local41#
    Local local42$
    Local local43.events
    Local local44.p_obj
    Local local45.breachtypes
    Local local46.sound
    Local local47$
    Local local48%
    Local local49$
    Local local50%
    Local local51$
    Local local52.multiplayer_texts
    Local local53.multiplayer_texts
    Local local54.draws
    Local local55.draws
    Local local56%
    Local local57%
    Local local58%
    Local local59.multiplayer_objects
    Local local60.multiplayer_objects
    Local local61.snd3d
    Local local62$
    Local local63$
    Local local64#
    Local local65%
    Local local66%
    Local local67%
    Local local68%
    Local local69%
    Local local70%
    Local local71%
    Local local72%
    Local local73%
    Local local74%
    Local local75%
    Local local76.particles
    Local local77%
    Local local78.decals
    Local local79%
    Local local80#
    Local local81#
    Local local82#
    Local local83#
    Local local84#
    Local local85#
    Local local86#
    Local local87#
    Local local88#
    Local local89#
    Local local90#
    Local local91#
    Local local92.decals
    Local local93%
    Local local94%
    Local local95%
    Local local96%
    If (isvalidplayer(arg1) = $00) Then
        Return $00
    EndIf
    If (arg0 <> $71) Then
        local7 = player[arg1]
    EndIf
    multiplayer_setservertime(((millisecs() + networkserver\Field3) + $7D0))
    If (networkserver\Field15 <> 0) Then
        If (multiplayer_getmicrobytepacket(arg0, arg1, local7) <> 0) Then
            Return $00
        EndIf
    EndIf
    Select arg0
        Case $1F
            shouldkick = udp_readline()
        Case $80
            myplayer\Field68 = (myplayer\Field68 - (Float rand($1E, $28)))
        Case $76
            blinktimer = (Float udp_readbyte())
        Case $4A
            If (networkserver\Field12 <> 0) Then
                local7\Field49 = (Int max(min((Float udp_readbyte()), (Float (last_breach_type - $01))), 0.0))
            EndIf
        Case $79
            myplayer\Field81 = (myplayer\Field81 = $00)
        Case $04
            deaftimer = 3500.0
            deafplayer = $01
            camerashake = 10.0
        Case $01
            If (arg1 <> networkserver\Field20) Then
                If (player[arg1] = Null) Then
                    multiplayer_createplayer(arg1)
                    multiplayer_initplayer(arg1)
                    local7 = player[arg1]
                EndIf
                Select udp_readbyte()
                    Case $00
                        local7\Field42 = (millisecs() + networkserver\Field3)
                        local7\Field32 = (Str udp_readbyte())
                        local7\Field41 = udp_readbyte()
                        If (local7\Field32 = "0") Then
                            local7\Field32 = "Not Ready"
                        Else
                            local7\Field32 = "Ready"
                        EndIf
                        udp_readbyte()
                        udp_readbyte()
                        udp_readbyte()
                        udp_readbyte()
                    Case $01
                        local7\Field42 = (millisecs() + networkserver\Field3)
                        local7\Field4 = convertshorttovalue((Float udp_readshort()))
                        local7\Field5 = convertshorttovalue((Float udp_readshort()))
                        local7\Field29 = udp_readfloat()
                        local7\Field77 = udp_readbyte()
                        local10 = readbool(local7\Field77, $00)
                        local7\Field37 = readbool(local7\Field77, $01)
                        local7\Field36 = readbool(local7\Field77, $02)
                        local7\Field39 = readbool(local7\Field77, $03)
                        local7\Field81 = readbool(local7\Field77, $05)
                        local7\Field80 = readbool(local7\Field77, $06)
                        local7\Field34 = (Float udp_readbyte())
                        local7\Field70 = udp_readbyte()
                        local7\Field35 = udp_readbyte()
                        local7\Field41 = readbool(local7\Field70, $00)
                        local7\Field102 = readbool(local7\Field70, $01)
                        local7\Field66 = udp_readshort()
                        udp_readbyte()
                        udp_readbyte()
                        udp_readbyte()
                        udp_readbyte()
                        udp_readfloat()
                        local7\Field53 = udp_readbyte()
                        udp_readshort()
                        local7\Field1 = udp_readfloat()
                        local7\Field2 = udp_readfloat()
                        local7\Field3 = udp_readfloat()
                        local7\Field45 = udp_readbyte()
                        local7\Field65 = udp_readbyte()
                        multiplayer_setplayerroom(local7)
                        host_updateplayer(arg1, local7\Field48, local10, local7\Field70)
                End Select
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
            networkserver\Field21 = (networkserver\Field21 - $01)
        Case $7E
            For local12 = Each players
                If (local12\Field0 <> networkserver\Field20) Then
                    If (steam_idtostring(steam_getsenderidupper(), steam_getsenderidlower()) = steam_idtostring(local12\Field27, local12\Field28)) Then
                        Exit
                    EndIf
                EndIf
            Next
            If (local13 = $00) Then
                udp_writebyte($7E)
                udp_writebyte($02)
                udp_sendmessageinternal($00, steam_getsenderidupper(), steam_getsenderidlower(), $00)
                udp_network\Field7 = $00
            EndIf
        Case $1A
            local14 = left(udp_readline(), $18)
            local15 = udp_readline()
            local16 = udp_readline()
            local17 = udp_readbyte()
            local18 = ""
            If (local16 <> networkserver\Field52\Field1) Then
                local18 = "Wrong password."
            EndIf
            If (local14 = "") Then
                local18 = "You cant have an empty nickname."
            EndIf
            If (instr(local14, "%", $01) <> 0) Then
                local18 = "Invalid syntax, please change your nickname!"
            EndIf
            For local12 = Each players
                If (lower(local12\Field24) = lower(local14)) Then
                    local18 = "A player with this nickname is already on the server."
                    Exit
                EndIf
            Next
            If (((multiplayer_version <> local15) Or (local17 <> $02)) <> 0) Then
                local18 = (((((((("Version doesn't match" + chr($0D)) + chr($0A)) + "Server version: ") + multiplayer_version) + chr($0D)) + chr($0A)) + "Game version: ") + local15)
            EndIf
            If (networkserver\Field21 = networkserver\Field52\Field14) Then
                local18 = "Server is full."
            EndIf
            If (local18 <> "") Then
                udp_writebyte($71)
                udp_writeline(local18)
                If (networkserver\Field32 = $00) Then
                    udp_writeint(udp_udpmsgip())
                    udp_writeint(udp_udpmsgport())
                    udp_sendmessageinternal(udp_network\Field0, udp_network\Field1, udp_network\Field2, $00)
                Else
                    udp_sendmessageinternal(udp_network\Field0, udp_udpmsgip(), udp_udpmsgport(), $00)
                EndIf
                If (networkserver\Field36 <> 0) Then
                    udp_network\Field7 = $00
                EndIf
                Return $00
            EndIf
            networkserver\Field21 = (networkserver\Field21 + $01)
            arg1 = findfreeplayerid()
            multiplayer_createplayer(arg1)
            local7 = player[arg1]
            local7\Field73 = udp_readshort()
            local7\Field74 = udp_readshort()
            local7\Field75 = udp_readbyte()
            local7\Field93 = steam_idtostring(steam_getsenderidupper(), steam_getsenderidlower())
            local7\Field94 = steam_getsenderidupper()
            local7\Field95 = steam_getsenderidlower()
            local7\Field49 = classd_model
            local7\Field42 = (millisecs() + networkserver\Field3)
            local7\Field27 = udp_udpmsgip()
            local7\Field28 = udp_udpmsgport()
            local7\Field46 = $05
            local7\Field48 = rand($01, $03)
            If (local7\Field75 <> 0) Then
                local7\Field86 = "PATRON"
                local7\Field87 = $D4
                local7\Field88 = $A0
                local7\Field89 = $31
            EndIf
            local19 = $00
            For local20 = $00 To $02 Step $01
                If (selecteddifficulty = difficulties(local20)) Then
                    local19 = local20
                    Exit
                EndIf
            Next
            udp_writebyte($1A)
            udp_writebyte(arg1)
            udp_writeline(randomseed)
            udp_writebyte(introenabled)
            udp_writebyte(nocheat)
            udp_writebyte(networkserver\Field52\Field10)
            udp_writefloat(0.0)
            udp_writeint(networkserver\Field3)
            udp_writefloat(networkserver\Field52\Field15)
            udp_writebyte(networkserver\Field52\Field16)
            udp_writebyte(networkserver\Field52\Field14)
            udp_writebyte(networkserver\Field16)
            udp_writebyte($00)
            udp_writebyte(networkserver\Field52\Field12)
            udp_writebyte(local7\Field49)
            udp_writeint($FFFFFFFF)
            udp_writeint($00)
            udp_writebyte(local7\Field48)
            udp_writeint($FFFFFFFF)
            udp_writebyte(local19)
            udp_writebyte((mainmenuopen = $00))
            udp_writeint(networkserver\Field52\Field13)
            udp_writeline("")
            udp_writebyte($00)
            udp_writebyte(networkserver\Field52\Field6)
            udp_writebyte($00)
            udp_writebyte($00)
            udp_writebyte($00)
            udp_writebyte($00)
            udp_writeline("")
            udp_writeline("")
            udp_writebyte(halloweenindex)
            udp_writebyte(newyearindex)
            udp_sendmessageinternal($00, player[arg1]\Field94, player[arg1]\Field95, $01)
            multiplayer_initplayer(arg1)
            multiplayer_changeplayername(arg1, local14, local7\Field86)
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
                For local21 = Each rooms
                    If (local21\Field8\Field11 = "start") Then
                        player[arg1]\Field1 = (entityx(local21\Field3, $00) + 14.0)
                        player[arg1]\Field2 = 1.85
                        player[arg1]\Field3 = (entityz(local21\Field3, $00) + 4.0)
                        player[arg1]\Field4 = 130.3
                        player[arg1]\Field45 = local21\Field65
                        player[arg1]\Field53 = $0B
                        Exit
                    EndIf
                Next
            Else
                For local21 = Each rooms
                    If (local21\Field8\Field11 = "173") Then
                        player[arg1]\Field1 = entityx(local21\Field3, $00)
                        player[arg1]\Field2 = 1.0
                        player[arg1]\Field3 = entityz(local21\Field3, $00)
                        player[arg1]\Field4 = 130.3
                        player[arg1]\Field45 = local21\Field65
                        player[arg1]\Field53 = $0B
                        Exit
                    EndIf
                Next
            EndIf
        Case $23
            If (networkserver\Field36 <> 0) Then
                Return $00
            EndIf
            udp_writeline(networkserver\Field52\Field0)
            udp_writeline((((Str networkserver\Field21) + " / ") + (Str networkserver\Field52\Field14)))
            udp_writebyte(nocheat)
            udp_writebyte((mainmenuopen = $00))
            If (networkserver\Field52\Field1 <> "") Then
                udp_writeline("PS")
            Else
                udp_writeline("")
            EndIf
            udp_writebyte($00)
            udp_writebyte(networkserver\Field52\Field10)
            udp_writeline(randomseed)
            udp_writeline("")
            udp_writeline("")
            udp_writeline(multiplayer_version)
            If ((networkserver\Field15 And (networkserver\Field32 = $00)) <> 0) Then
                udp_writebyte($FE)
                udp_writeint(udp_network\Field7)
                udp_writeint(udp_network\Field8)
                udp_sendmessageinternal(udp_network\Field0, udp_network\Field1, udp_network\Field2, $00)
            Else
                udp_sendmessageinternal(udp_network\Field0, udp_network\Field7, udp_network\Field8, $00)
            EndIf
        Case $0B
            local22 = udp_readline()
            If (udp_readbyte() <> 0) Then
                If (local7 <> Null) Then
                    local23 = multiplayer_createmessage((local7\Field24 + local22), $FFFFFFFF)
                Else
                    local23 = multiplayer_createmessage(local22, $FFFFFFFF)
                EndIf
            EndIf
        Case $72
            If (getscripts() <> 0) Then
                local24 = createbank(udp_readavail())
                udp_readbytes(local24, $00, banksize(local24))
                public_inqueue($10, $00)
                public_addparam((Str local24), $01)
                callback()
                freebank(local24)
            EndIf
        Case $70
            If (udp_readavail() < $12) Then
                shouldkick = "Invalid server file packet"
                Return $00
            EndIf
            local25 = udp_readline()
            If (((udp_readavail() < $11) Or (udp_readavail() > $FB1)) <> 0) Then
                shouldkick = "Invalid server file packet"
                Return $00
            EndIf
            local26 = udp_readint()
            local27 = $FFFFFFFF
            local28 = $00
            If (isfoldersecured(local25) = $00) Then
                udp_readint()
                udp_writebyte($6F)
                udp_writebyte(networkserver\Field20)
                udp_writeint(local26)
                udp_writeint(udp_readint())
                udp_writeshort((Int networkserver\Field31))
                udp_sendmessage($00)
                Return $00
            EndIf
            For local29 = Each querys
                If (local29\Field4 = local26) Then
                    If (((local29\Field3 = $00) Or (local29\Field0 <> local25)) <> 0) Then
                        shouldkick = "Invalid server file packet"
                        Return $00
                    EndIf
                    local27 = udp_readint()
                    If (udp_readint() <> local29\Field1) Then
                        shouldkick = "Invalid server file packet"
                        Return $00
                    EndIf
                    If ((((local27 < $00) Or (local27 > local29\Field1)) Or ((udp_readavail() - $05) > (local29\Field1 - local27))) <> 0) Then
                        shouldkick = "Invalid server file packet"
                        Return $00
                    EndIf
                    If (local27 = filepos(local29\Field3)) Then
                        resizebank(local29\Field10, (udp_readavail() - $05))
                        udp_readbytes(local29\Field10, $00, banksize(local29\Field10))
                        If (writebytes(local29\Field10, local29\Field3, $00, banksize(local29\Field10)) <> banksize(local29\Field10)) Then
                            shouldkick = "Cannot save server file"
                            Return $00
                        EndIf
                        local29\Field6 = (local29\Field6 + banksize(local29\Field10))
                    ElseIf (local27 > filepos(local29\Field3)) Then
                        udp_writebyte($6F)
                        udp_writebyte(networkserver\Field20)
                        udp_writeint(local29\Field4)
                        udp_writeint(filepos(local29\Field3))
                        udp_writeshort((Int networkserver\Field31))
                        udp_sendmessage($00)
                    EndIf
                    Exit
                EndIf
            Next
            If (local27 = $FFFFFFFF) Then
                If (udp_readint() <> $00) Then
                    shouldkick = "Invalid server file packet"
                    Return $00
                EndIf
                local29 = (New querys)
                local29\Field4 = local26
                local29\Field1 = udp_readint()
                If ((((local29\Field1 < $01) Or (local29\Field1 > $4000000)) Or (serverdownloadbytes > ($10000000 - local29\Field1))) <> 0) Then
                    Delete local29
                    shouldkick = "Server file exceeds download limit"
                    Return $00
                EndIf
                serverdownloadbytes = (serverdownloadbytes + local29\Field1)
                local29\Field0 = local25
                If ((udp_readavail() - $05) > local29\Field1) Then
                    Delete local29
                    shouldkick = "Invalid server file packet"
                    Return $00
                EndIf
                local29\Field10 = createbank((udp_readavail() - $05))
                If (local29\Field10 = $00) Then
                    Delete local29
                    shouldkick = "Cannot allocate server file chunk"
                    Return $00
                EndIf
                udp_readbytes(local29\Field10, $00, banksize(local29\Field10))
                local29\Field8 = udp_readbyte()
                local29\Field9 = udp_readint()
                If ((((((local29\Field9 < $00) Or (local29\Field9 > $4000000)) Or (local29\Field8 > $01)) Or (local29\Field8 And (local29\Field9 <> $00))) Or (local29\Field8 And (local29\Field1 > $200000))) <> 0) Then
                    freebank(local29\Field10)
                    Delete local29
                    shouldkick = "Invalid server file size"
                    Return $00
                EndIf
                If (local29\Field9 > local29\Field1) Then
                    If (serverdownloadbytes > ($10000000 - (local29\Field9 - local29\Field1))) Then
                        freebank(local29\Field10)
                        Delete local29
                        shouldkick = "Server file exceeds download limit"
                        Return $00
                    EndIf
                    serverdownloadbytes = (serverdownloadbytes + (local29\Field9 - local29\Field1))
                EndIf
                If (local29\Field9 <> $00) Then
                    If (filesize((("multiplayer\serversdata\" + local29\Field0) + ".packed")) = local29\Field1) Then
                        If (unpackserverfile(local29) = $00) Then
                            shouldkick = "Invalid compressed server file"
                        EndIf
                        udp_writebyte($6F)
                        udp_writebyte(networkserver\Field20)
                        udp_writeint(local29\Field4)
                        udp_writeint(local29\Field1)
                        udp_writeshort((Int networkserver\Field31))
                        udp_sendmessage($00)
                        If (local29\Field10 <> $00) Then
                            freebank(local29\Field10)
                        EndIf
                        Delete local29
                    ElseIf (filesize(("multiplayer\serversdata\" + local29\Field0)) <> local29\Field9) Then
                        local29\Field3 = writefiledir((("multiplayer\serversdata\" + local29\Field0) + ".packed"))
                        If (local29\Field3 = $00) Then
                            freebank(local29\Field10)
                            Delete local29
                            shouldkick = "Cannot save server file"
                            Return $00
                        EndIf
                        udp_writebyte($6F)
                        udp_writebyte(networkserver\Field20)
                        udp_writeint(local29\Field4)
                        udp_writeint(filepos(local29\Field3))
                        udp_writeshort((Int networkserver\Field31))
                        udp_sendmessage($00)
                    Else
                        udp_writebyte($6F)
                        udp_writebyte(networkserver\Field20)
                        udp_writeint(local29\Field4)
                        udp_writeint(local29\Field1)
                        udp_writeshort((Int networkserver\Field31))
                        udp_sendmessage($00)
                        If (local29\Field10 <> $00) Then
                            freebank(local29\Field10)
                        EndIf
                        Delete local29
                    EndIf
                ElseIf (((filesize(("multiplayer\serversdata\" + local29\Field0)) = local29\Field1) And (local29\Field8 = $00)) <> 0) Then
                    udp_writebyte($6F)
                    udp_writebyte(networkserver\Field20)
                    udp_writeint(local29\Field4)
                    udp_writeint(local29\Field1)
                    udp_writeshort((Int networkserver\Field31))
                    udp_sendmessage($00)
                    If (local29\Field10 <> $00) Then
                        freebank(local29\Field10)
                    EndIf
                    Delete local29
                Else
                    local29\Field3 = writefiledir(("multiplayer\serversdata\" + local29\Field0))
                    If (local29\Field3 = $00) Then
                        freebank(local29\Field10)
                        Delete local29
                        shouldkick = "Cannot save server file"
                        Return $00
                    EndIf
                    udp_writebyte($6F)
                    udp_writebyte(networkserver\Field20)
                    udp_writeint(local29\Field4)
                    udp_writeint(filepos(local29\Field3))
                    udp_writeshort((Int networkserver\Field31))
                    udp_sendmessage($00)
                EndIf
                If (local29 <> Null) Then
                    If (local29\Field3 <> $00) Then
                        If (writebytes(local29\Field10, local29\Field3, $00, banksize(local29\Field10)) <> banksize(local29\Field10)) Then
                            shouldkick = "Cannot save server file"
                            Return $00
                        EndIf
                        local29\Field6 = (local29\Field6 + banksize(local29\Field10))
                    EndIf
                EndIf
            EndIf
        Case $6D
            If (networkserver\Field15 <> 0) Then
                multiplayer_getmicrobytepacket(arg0, arg1, local7)
            ElseIf (player[arg1] <> Null) Then
                local14 = udp_readline()
                local30 = udp_readline()
                player[arg1]\Field87 = udp_readbyte()
                player[arg1]\Field88 = udp_readbyte()
                player[arg1]\Field89 = udp_readbyte()
                multiplayer_changeplayername(arg1, local14, local30)
                player[arg1]\Field90 = ((Float udp_readshort()) / 100.0)
                If (0.0 = player[arg1]\Field90) Then
                    player[arg1]\Field90 = 1.0
                EndIf
                local31 = (Int player[arg1]\Field93)
                player[arg1]\Field93 = udp_readline()
                player[arg1]\Field94 = steam_stringtoidupper(player[arg1]\Field93)
                player[arg1]\Field95 = steam_stringtoidlower(player[arg1]\Field93)
                If ((Str local31) <> player[arg1]\Field93) Then
                    If (player[arg1]\Field96 <> $00) Then
                        freeimage(player[arg1]\Field96)
                        player[arg1]\Field96 = $00
                    EndIf
                EndIf
                multiplayer_initsettingsforplayer(player[arg1], player[arg1]\Field49, udp_readbyte(), player[arg1]\Field38, player[arg1]\Field70)
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
                            local33 = m_npc[otherindex]
                            If (local33 = Null) Then
                                local33 = createnpc(otherindex2, 0.0, 0.0, 0.0)
                                setnpcid(local33, otherindex)
                            EndIf
                            resetnpc(local33, otherindex2)
                            local33\Field78 = 700.0
                            local33\Field24 = (Float udp_readbyte())
                            local33\Field9 = udp_readfloat()
                            local33\Field10 = udp_readfloat()
                            local33\Field11 = udp_readfloat()
                            local33\Field87 = udp_readfloat()
                            local33\Field88 = udp_readfloat()
                            local33\Field89 = udp_readfloat()
                            local33\Field94 = udp_readfloat()
                            local33\Field93 = udp_readfloat()
                            changenpctextureid(local33, (udp_readbyte() - $01))
                            local33\Field82 = udp_readbyte()
                            local33\Field83 = udp_readbyte()
                            local33\Field31 = m_npc[udp_readbyte()]
                            If (m_event[local33\Field82] <> Null) Then
                                m_event[local33\Field82]\Field1\Field32[local33\Field83] = local33
                            EndIf
                            Select local33\Field5
                                Case $01
                                    curr173 = local33
                                Case $09
                                    curr096 = local33
                                Case $02
                                    curr106 = local33
                                Case $0C
                                    curr5131 = local33
                            End Select
                        Forever
                        For local33 = Each npcs
                            If (1.0 > local33\Field78) Then
                                If (m_event[local33\Field82] <> Null) Then
                                    removeevent(m_event[local33\Field82])
                                EndIf
                                removenpc(local33, $00)
                            Else
                                If (700.0 <> local33\Field78) Then
                                    local33\Field87 = 999.0
                                    local33\Field88 = 999.0
                                    local33\Field89 = 999.0
                                EndIf
                                local33\Field78 = (local33\Field78 - fpsfactor)
                            EndIf
                        Next
                    EndIf
                Case $42
                    Repeat
                        otherindex = udp_readshort()
                        If (otherindex = $00) Then
                            Exit
                        EndIf
                        local35 = m_item[otherindex]
                        otherindex2 = udp_readint()
                        local0 = udp_readfloat()
                        local1 = udp_readfloat()
                        local2 = udp_readfloat()
                        otherindex3 = udp_readbyte()
                        If (local35 = Null) Then
                            For local36 = Each itemtemplates
                                If (local36\Field0 = otherindex2) Then
                                    local35 = createitembytemplate(local36, 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00, $01)
                                    entitytype(local35\Field2, $03, $00)
                                    Exit
                                EndIf
                            Next
                        ElseIf (local35\Field1\Field0 <> otherindex2) Then
                            removeitem(local35, $00)
                            For local36 = Each itemtemplates
                                If (local36\Field0 = otherindex2) Then
                                    local35 = createitembytemplate(local36, 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00, $01)
                                    entitytype(local35\Field2, $03, $00)
                                    Exit
                                EndIf
                            Next
                        EndIf
                        If (local35 <> Null) Then
                            setitemid(local35, otherindex)
                            local35\Field21 = 1.0
                            local35\Field25 = local0
                            local35\Field26 = local1
                            local35\Field27 = local2
                            local35\Field22 = otherindex3
                            local35\Field16 = (local35\Field22 <> $00)
                        EndIf
                    Forever
                    For local35 = Each items
                        If (0.0 = local35\Field21) Then
                            removeitem(local35, $00)
                        Else
                            local35\Field21 = 0.0
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
                                local37 = local11\Field12
                                local11\Field12 = udp_readbyte()
                                If (((local37 = $00) And (local11\Field12 > $00)) <> 0) Then
                                    For local20 = $00 To $01 Step $01
                                        If (local11\Field3[local20] <> $00) Then
                                            local38 = entityx(local11\Field3[local20], $00)
                                            local39 = entityy(local11\Field3[local20], $00)
                                            local40 = entityz(local11\Field3[local20], $00)
                                            local41 = entityyaw(local11\Field3[local20], $00)
                                            freeentity(local11\Field3[local20])
                                            local11\Field3[local20] = copyentity(buttonkeyobj, $00)
                                            entityfx(local11\Field3[local20], $01)
                                            scaleentity(local11\Field3[local20], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local20], local38, local39, local40, $00)
                                            rotateentity(local11\Field3[local20], 0.0, local41, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                                If (((local37 > $00) And (local11\Field12 = $00)) <> 0) Then
                                    For local20 = $00 To $01 Step $01
                                        If (local11\Field3[local20] <> $00) Then
                                            local38 = entityx(local11\Field3[local20], $00)
                                            local39 = entityy(local11\Field3[local20], $00)
                                            local40 = entityz(local11\Field3[local20], $00)
                                            local41 = entityyaw(local11\Field3[local20], $00)
                                            freeentity(local11\Field3[local20])
                                            local11\Field3[local20] = copyentity(buttonobj, $00)
                                            entityfx(local11\Field3[local20], $01)
                                            scaleentity(local11\Field3[local20], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local20], local38, local39, local40, $00)
                                            rotateentity(local11\Field3[local20], 0.0, local41, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                            If (readbool(otherindex2, $03) <> 0) Then
                                local42 = local11\Field17
                                local11\Field37 = udp_readbyte()
                                If (((local42 = "") And (local11\Field37 = $01)) <> 0) Then
                                    local11\Field17 = "ABCD"
                                    For local20 = $00 To $01 Step $01
                                        If (local11\Field3[local20] <> $00) Then
                                            local38 = entityx(local11\Field3[local20], $00)
                                            local39 = entityy(local11\Field3[local20], $00)
                                            local40 = entityz(local11\Field3[local20], $00)
                                            local41 = entityyaw(local11\Field3[local20], $00)
                                            freeentity(local11\Field3[local20])
                                            local11\Field3[local20] = copyentity(buttoncodeobj, $00)
                                            entityfx(local11\Field3[local20], $01)
                                            scaleentity(local11\Field3[local20], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local20], local38, local39, local40, $00)
                                            rotateentity(local11\Field3[local20], 0.0, local41, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                                If (((local42 <> "") And (local11\Field37 = $00)) <> 0) Then
                                    local11\Field17 = ""
                                    For local20 = $00 To $01 Step $01
                                        If (local11\Field3[local20] <> $00) Then
                                            local38 = entityx(local11\Field3[local20], $00)
                                            local39 = entityy(local11\Field3[local20], $00)
                                            local40 = entityz(local11\Field3[local20], $00)
                                            local41 = entityyaw(local11\Field3[local20], $00)
                                            freeentity(local11\Field3[local20])
                                            local11\Field3[local20] = copyentity(buttonobj, $00)
                                            entityfx(local11\Field3[local20], $01)
                                            scaleentity(local11\Field3[local20], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local20], local38, local39, local40, $00)
                                            rotateentity(local11\Field3[local20], 0.0, local41, 0.0, $00)
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
                            local11\Field27 = local0
                            If (readbool(otherindex2, $02) <> 0) Then
                                local37 = local11\Field12
                                local11\Field12 = udp_readbyte()
                                If (((local37 = $00) And (local11\Field12 > $00)) <> 0) Then
                                    For local20 = $00 To $01 Step $01
                                        If (local11\Field3[local20] <> $00) Then
                                            local38 = entityx(local11\Field3[local20], $00)
                                            local39 = entityy(local11\Field3[local20], $00)
                                            local40 = entityz(local11\Field3[local20], $00)
                                            local41 = entityyaw(local11\Field3[local20], $00)
                                            freeentity(local11\Field3[local20])
                                            local11\Field3[local20] = copyentity(buttonkeyobj, $00)
                                            entityfx(local11\Field3[local20], $01)
                                            scaleentity(local11\Field3[local20], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local20], local38, local39, local40, $00)
                                            rotateentity(local11\Field3[local20], 0.0, local41, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                                If (((local37 > $00) And (local11\Field12 = $00)) <> 0) Then
                                    For local20 = $00 To $01 Step $01
                                        If (local11\Field3[local20] <> $00) Then
                                            local38 = entityx(local11\Field3[local20], $00)
                                            local39 = entityy(local11\Field3[local20], $00)
                                            local40 = entityz(local11\Field3[local20], $00)
                                            local41 = entityyaw(local11\Field3[local20], $00)
                                            freeentity(local11\Field3[local20])
                                            local11\Field3[local20] = copyentity(buttonobj, $00)
                                            entityfx(local11\Field3[local20], $01)
                                            scaleentity(local11\Field3[local20], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local20], local38, local39, local40, $00)
                                            rotateentity(local11\Field3[local20], 0.0, local41, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                            If (readbool(otherindex2, $03) <> 0) Then
                                local42 = local11\Field17
                                local11\Field37 = udp_readbyte()
                                If (((local42 = "") And (local11\Field37 = $01)) <> 0) Then
                                    local11\Field17 = "ABCD"
                                    For local20 = $00 To $01 Step $01
                                        If (local11\Field3[local20] <> $00) Then
                                            local38 = entityx(local11\Field3[local20], $00)
                                            local39 = entityy(local11\Field3[local20], $00)
                                            local40 = entityz(local11\Field3[local20], $00)
                                            local41 = entityyaw(local11\Field3[local20], $00)
                                            freeentity(local11\Field3[local20])
                                            local11\Field3[local20] = copyentity(buttoncodeobj, $00)
                                            entityfx(local11\Field3[local20], $01)
                                            scaleentity(local11\Field3[local20], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local20], local38, local39, local40, $00)
                                            rotateentity(local11\Field3[local20], 0.0, local41, 0.0, $00)
                                        EndIf
                                    Next
                                EndIf
                                If (((local42 <> "") And (local11\Field37 = $00)) <> 0) Then
                                    local11\Field17 = ""
                                    For local20 = $00 To $01 Step $01
                                        If (local11\Field3[local20] <> $00) Then
                                            local38 = entityx(local11\Field3[local20], $00)
                                            local39 = entityy(local11\Field3[local20], $00)
                                            local40 = entityz(local11\Field3[local20], $00)
                                            local41 = entityyaw(local11\Field3[local20], $00)
                                            freeentity(local11\Field3[local20])
                                            local11\Field3[local20] = copyentity(buttonobj, $00)
                                            entityfx(local11\Field3[local20], $01)
                                            scaleentity(local11\Field3[local20], 0.03, 0.03, 0.03, $00)
                                            positionentity(local11\Field3[local20], local38, local39, local40, $00)
                                            rotateentity(local11\Field3[local20], 0.0, local41, 0.0, $00)
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
                            local43 = m_event[otherindex]
                            otherindex2 = udp_readbyte()
                            otherindex3 = udp_readbyte()
                            local0 = udp_readfloat()
                            local1 = udp_readfloat()
                            local2 = udp_readfloat()
                            If (local43 = Null) Then
                                local43 = (New events)
                                local43\Field22 = otherindex2
                                local43\Field0 = findeventnameconst(otherindex2)
                                local43\Field1 = room[otherindex3]
                                local43\Field2 = local0
                                local43\Field3 = local1
                                local43\Field4 = local2
                                local43\Field23 = $01
                                local43\Field24 = $00
                                seteventid(local43, otherindex)
                                seteventvarex(local43, $01)
                            Else
                                local43\Field23 = $01
                                local43\Field24 = $00
                                If (local0 > local43\Field2) Then
                                    local43\Field2 = local0
                                EndIf
                                If (local1 > local43\Field3) Then
                                    local43\Field3 = local1
                                EndIf
                                If (local2 > local43\Field4) Then
                                    local43\Field4 = local2
                                EndIf
                            EndIf
                        Forever
                        For local43 = Each events
                            If (local43\Field23 = $00) Then
                                If (isanotremovedevent(local43) = $00) Then
                                    If (isablockedevent(local43) = $00) Then
                                        local43\Field24 = $01
                                        removeevent(local43)
                                    EndIf
                                EndIf
                            Else
                                local43\Field23 = $00
                            EndIf
                        Next
                    EndIf
                Case $54
                    Repeat
                        otherindex = udp_readbyte()
                        If (otherindex = $00) Then
                            Exit
                        EndIf
                        local21 = room[otherindex]
                        otherindex2 = udp_readbyte()
                        local0 = udp_readfloat()
                        local1 = udp_readfloat()
                        local2 = udp_readfloat()
                        local3 = udp_readfloat()
                        local4 = udp_readfloat()
                        local5 = udp_readfloat()
                        If (local21 <> Null) Then
                            If (grabbedentity <> local21\Field25[otherindex2]) Then
                                If (local21\Field25[otherindex2] <> $00) Then
                                    positionentity(local21\Field25[otherindex2], local0, local1, local2, $01)
                                    rotateentity(local21\Field25[otherindex2], local3, local4, local5, $01)
                                EndIf
                            EndIf
                            local21\Field26[otherindex2] = $00
                        EndIf
                    Forever
                Case $83
                    Repeat
                        otherindex = udp_readbyte()
                        If (otherindex = $00) Then
                            Exit
                        EndIf
                        local44 = m_corpse[otherindex]
                        otherindex2 = udp_readbyte()
                        local0 = udp_readfloat()
                        local1 = udp_readfloat()
                        local2 = udp_readfloat()
                        local3 = convertshorttovalue((Float udp_readshort()))
                        local6 = ((Float udp_readshort()) / 100.0)
                        otherindex3 = udp_readbyte()
                        local45 = getbreachtype(otherindex2)
                        If (getsecondpackedvalue(local45\Field14) <> $00) Then
                            If (local44 = Null) Then
                                createrolecorpse(otherindex2, local0, local1, local2, local3, local6, $00, readbool(otherindex3, $01), otherindex, $01)
                            Else
                                If (otherindex2 <> local44\Field5) Then
                                    freeentity(local44\Field2)
                                    local44\Field2 = createrolecorpse(otherindex2, local0, local1, local2, local3, local6, $01, readbool(otherindex3, $01), $00, $00)
                                    local44\Field3 = ((millisecs() + $1D4C0) * (readbool(otherindex3, $00) = $00))
                                    local44\Field4 = 350.0
                                    local44\Field5 = otherindex2
                                EndIf
                                positionentity(local44\Field2, local0, ((local1 - 0.32) - local45\Field53), local2, $00)
                                rotateentity(local44\Field2, local45\Field55, (local45\Field54 + local3), 0.0, $00)
                                local44\Field1 = $01
                                local44\Field3 = ((millisecs() + $1D4C0) * (readbool(otherindex3, $00) = $00))
                            EndIf
                        EndIf
                    Forever
                    For local44 = Each p_obj
                        If (local44\Field1 = $00) Then
                            freeentity(local44\Field2)
                            Delete local44
                        Else
                            local44\Field1 = $00
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
                    If (issafeserversound(otherindexstr) = $00) Then
                        Return $00
                    EndIf
                    If (otherindexstr = "SFX\SCP\513\Bell1.ogg") Then
                        If (curr5131 = Null) Then
                            curr5131 = createnpc($0C, 0.0, 0.0, 0.0)
                            curr5131\Field80 = $01
                        EndIf
                    EndIf
                    If (otherindexstr <> "") Then
                        For local46 = Each sound
                            If (local46\Field1 = otherindexstr) Then
                                play3dsound((Handle local46), camera, multiplayer_object[otherindex]\Field1, local4, local3, "")
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
            local47 = udp_readline()
            otherindexstr = local47
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            If (issafeserversound(otherindexstr) = $00) Then
                Return $00
            EndIf
            local48 = createpivot($00)
            positionentity(local48, local0, local1, local2, $00)
            If (otherindexstr = "SFX\SCP\513\Bell1.ogg") Then
                If (curr5131 = Null) Then
                    curr5131 = createnpc($0C, 0.0, 0.0, 0.0)
                    curr5131\Field80 = $01
                EndIf
            EndIf
            If (otherindexstr <> "") Then
                For local46 = Each sound
                    If (local46\Field1 = otherindexstr) Then
                        play3dsoundentity((Handle local46), camera, local48, local4, local3, "")
                        otherindexstr = ""
                        Exit
                    EndIf
                Next
                If (otherindexstr <> "") Then
                    play3dsoundentity($00, camera, local48, local4, local3, otherindexstr)
                EndIf
            EndIf
            If (networkserver\Field15 <> 0) Then
                For local12 = Each players
                    If (((local12\Field0 <> arg1) And (local12\Field0 <> $01)) <> 0) Then
                        udp_writebyte($66)
                        udp_writebyte($01)
                        udp_writeline(local47)
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
            If (networkserver\Field15 <> 0) Then
                local7\Field46 = (Int max(5.0, (Float (millisecs() - local7\Field47))))
            Else
                udp_writebyte($64)
                udp_writebyte(networkserver\Field20)
                udp_sendmessage($00)
            EndIf
        Case $63
            secondarylighton = udp_readfloat()
        Case $62
            msg = udp_readline()
            msgtimer = (Float udp_readint())
        Case $61
            local49 = udp_readline()
            local50 = udp_readbyte()
            executeconsolecommand(local49, $01, local50)
        Case $60
            local51 = udp_readline()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            positionentity(collider, local0, local1, local2, $00)
            resetentity(collider)
            For local21 = Each rooms
                If (local21\Field8\Field11 = local51) Then
                    playerroom = local21
                    updaterooms()
                    updateevents()
                    Exit
                EndIf
            Next
        Case $5F
            networkserver\Field25 = udp_readbyte()
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
                If (issafeserverfont(multiplayer_text[otherindex]\Field0) = $00) Then
                    multiplayer_text[otherindex]\Field0 = ""
                EndIf
                multiplayer_text[otherindex]\Field4 = udp_readline()
                multiplayer_text[otherindex]\Field5 = udp_readint()
                multiplayer_text[otherindex]\Field6 = udp_readint()
                multiplayer_text[otherindex]\Field3 = udp_readint()
                multiplayer_text[otherindex]\Field1 = (Float udp_readbyte())
                multiplayer_text[otherindex]\Field7 = $01
            Forever
            For local52 = Each multiplayer_texts
                If (local52\Field7 = $00) Then
                    If (local52\Field2 <> 0) Then
                        For local53 = Each multiplayer_texts
                            If (((local53\Field2 = local52\Field2) And (local53 <> local52)) <> 0) Then
                                otherindex2 = $01
                                Exit
                            EndIf
                        Next
                        If (otherindex2 = $00) Then
                            freefont(local52\Field2)
                        EndIf
                    EndIf
                    Delete local52
                Else
                    local52\Field7 = $00
                EndIf
            Next
        Case $5E
            networkserver\Field23 = udp_readbyte()
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
                If (issafeserverimage(multiplayer_draw[otherindex]\Field0) = $00) Then
                    multiplayer_draw[otherindex]\Field0 = ""
                EndIf
                multiplayer_draw[otherindex]\Field3 = udp_readint()
                multiplayer_draw[otherindex]\Field4 = udp_readint()
                multiplayer_draw[otherindex]\Field5 = udp_readint()
                multiplayer_draw[otherindex]\Field6 = udp_readint()
                multiplayer_draw[otherindex]\Field8 = udp_readint()
                multiplayer_draw[otherindex]\Field1 = udp_readbyte()
                multiplayer_draw[otherindex]\Field7 = $01
            Forever
            For local54 = Each draws
                If (local54\Field7 = $00) Then
                    If (local54\Field2 <> 0) Then
                        For local55 = Each draws
                            If (((local55\Field2 = local54\Field2) And (local55 <> local54)) <> 0) Then
                                otherindex2 = $01
                                Exit
                            EndIf
                        Next
                        If (otherindex2 = $00) Then
                            freeimage(local54\Field2)
                        EndIf
                    EndIf
                    Delete local54
                Else
                    local54\Field7 = $00
                EndIf
            Next
        Case $5D
            networkserver\Field24 = udp_readbyte()
            Repeat
                otherindex = udp_readbyte()
                If (otherindex = $00) Then
                    Exit
                EndIf
                local56 = udp_readshort()
                If (((local56 < $00) Or (local56 > $FFFF)) <> 0) Then
                    Return $00
                EndIf
                otherindexstr = multiplayer_models[local56]
                local0 = udp_readfloat()
                local1 = udp_readfloat()
                local2 = udp_readfloat()
                local4 = convertshorttovalue((Float udp_readshort()))
                local3 = convertshorttovalue((Float udp_readshort()))
                local5 = convertshorttovalue((Float udp_readshort()))
                local6 = udp_readfloat()
                local57 = udp_readshort()
                local58 = (Int max((Float udp_readbyte()), 1.0))
                If (otherindexstr <> "") Then
                    If (multiplayer_object[otherindex] = Null) Then
                        otherindex2 = $00
                        For local59 = Each multiplayer_objects
                            If (((local59\Field0 = otherindexstr) And (local59\Field1 <> $00)) <> 0) Then
                                otherindex2 = copyentity(local59\Field1, $00)
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
                            For local59 = Each multiplayer_objects
                                If (((local59\Field0 = otherindexstr) And (local59\Field1 <> $00)) <> 0) Then
                                    multiplayer_object[otherindex]\Field1 = copyentity(local59\Field1, $00)
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
                                setanimtime(multiplayer_object[otherindex]\Field1, (Float local57), $00)
                            EndIf
                            multiplayer_object[otherindex]\Field3 = local0
                            multiplayer_object[otherindex]\Field4 = local1
                            multiplayer_object[otherindex]\Field5 = local2
                            multiplayer_object[otherindex]\Field6 = local4
                            multiplayer_object[otherindex]\Field7 = local3
                            multiplayer_object[otherindex]\Field8 = local5
                            multiplayer_object[otherindex]\Field9 = local58
                        EndIf
                        multiplayer_object[otherindex]\Field2 = $01
                    EndIf
                EndIf
            Forever
            For local60 = Each multiplayer_objects
                If (local60\Field2 = $00) Then
                    For local61 = Each snd3d
                        If (local61\Field5 = local60\Field1) Then
                            If (local61\Field0 = $00) Then
                                stopchannel(local61\Field2)
                                If (local61\Field6 <> 0) Then
                                    freeentity(local61\Field5)
                                EndIf
                                Delete local61
                            Else
                                fsound_stopsound(local61\Field2)
                                fsound_stream_stop(local61\Field1)
                                fsound_stream_close(local61\Field1)
                                Delete local61
                            EndIf
                        EndIf
                    Next
                    freeentity(local60\Field1)
                    Delete local60
                Else
                    local60\Field2 = $00
                EndIf
            Next
        Case $55
            If (pendingserverload = $00) Then
                Return $00
            EndIf
            pendingserverload = $00
            local62 = udp_readline()
            local63 = udp_readline()
            If (lower(local62) <> lower(pendingserverloadpath)) Then
                Return $00
            EndIf
            pendingserverloadpath = ""
            If (((lower(left(local62, $06)) <> "saves\") Or (right(local62, $01) <> "\")) <> 0) Then
                Return $00
            EndIf
            If (isfoldersecured(left(local62, (len(local62) - $01))) = $00) Then
                Return $00
            EndIf
            If (filetype((local62 + "save.txt")) <> $01) Then
                Return $00
            EndIf
            multiplayer_send($06, $FFFFFFFF, $FFFFFFFF)
            savepath = local62
            startloadgame(savepath, local63)
        Case $6B
            udp_readshort()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            local64 = (Float udp_readbyte())
            If (arg1 <> networkserver\Field20) Then
                If (player[arg1] <> Null) Then
                    local65 = getgunshootticks(player[arg1]\Field35)
                    For local20 = $01 To local65 Step $01
                        createbullet(arg1, 1.5, local0, local1, local2, local4, local3, $01)
                    Next
                    player[arg1]\Field99 = $01
                Else
                    createbullet($00, 1.5, local0, local1, local2, local4, local3, $01)
                EndIf
                playplayersound(player[arg1], getgunsound(player[arg1]\Field35), 15.0, 1.0, $00)
            EndIf
            If (networkserver\Field15 <> 0) Then
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
                        udp_writebyte((Int local64))
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
            If (arg1 <> networkserver\Field20) Then
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
            local66 = udp_readbyte()
            local67 = udp_readbyte()
            If (arg1 <> networkserver\Field20) Then
                creategrenade(local66, local0, local1, local2, local4, local3, arg1, local67)
            EndIf
        Case $35
            If (local7\Field49 = model_106) Then
                If ((rand($00, $03) And $03) <> 0) Then
                    movetopocketdimension()
                EndIf
                myplayer\Field68 = (myplayer\Field68 - 55.0)
                If (1.0 > myplayer\Field68) Then
                    kill(("was killed by " + local7\Field24), $00)
                EndIf
                stopchannel(local12\Field51)
                local12\Field51 = $00
            Else
                kill(("was killed by " + local7\Field24), $00)
                stopchannel(local12\Field51)
                local12\Field51 = $00
            EndIf
        Case $1E
            removenpc(m_npc[udp_readbyte()], $00)
        Case $40
            local33 = createnpc(udp_readbyte(), local7\Field1, (local7\Field2 + 0.3), local7\Field3)
            local33\Field9 = udp_readfloat()
        Case $3F
            networkserver\Field26 = udp_readbyte()
            local68 = udp_readshort()
            While (local68 > $00)
                multiplayer_createmessage(udp_readline(), local68)
                local68 = udp_readshort()
            Wend
        Case $3C
            udp_updatedelta($01)
            networkserver\Field15 = $00
            networkserver\Field33 = udp_readbyte()
            multiplayer_breach_setplayertype(udp_readbyte())
            networkserver\Field52\Field15 = udp_readfloat()
            b_br\Field5 = (millisecs() + udp_readint())
            b_br\Field7 = (millisecs() + udp_readint())
            serverping = udp_readshort()
            networkserver\Field21 = $01
            Repeat
                local69 = udp_readbyte()
                If (local69 = $00) Then
                    Exit
                Else
                    If (local69 = networkserver\Field20) Then
                        skipdataplayer()
                        local69 = udp_readbyte()
                        If (local69 = $00) Then
                            Exit
                        EndIf
                    EndIf
                    networkserver\Field21 = (networkserver\Field21 + $01)
                    If (player[local69] = Null) Then
                        multiplayer_createplayer(local69)
                        multiplayer_initplayer(local69)
                    EndIf
                    local7 = player[local69]
                    If (networkserver\Field33 = $01) Then
                        otherindex2 = udp_readbyte()
                        If (otherindex2 <> $00) Then
                            local7\Field1 = udp_readfloat()
                            local7\Field2 = udp_readfloat()
                            local7\Field3 = udp_readfloat()
                            local7\Field4 = convertshorttovalue((Float udp_readshort()))
                            local7\Field5 = convertshorttovalue((Float udp_readshort()))
                            local7\Field53 = udp_readbyte()
                            local7\Field29 = udp_readfloat()
                            local7\Field77 = udp_readbyte()
                            otherindex4 = readbool(local7\Field77, $00)
                            local7\Field37 = readbool(local7\Field77, $01)
                            local7\Field36 = readbool(local7\Field77, $02)
                            local7\Field39 = readbool(local7\Field77, $03)
                            local7\Field81 = readbool(local7\Field77, $05)
                            local7\Field80 = readbool(local7\Field77, $06)
                            local7\Field34 = (Float udp_readbyte())
                            local7\Field46 = udp_readshort()
                            otherindex5 = udp_readbyte()
                            local7\Field35 = udp_readbyte()
                            local7\Field66 = udp_readshort()
                            local7\Field45 = udp_readbyte()
                            multiplayer_setplayerroom(local7)
                            multiplayer_initsettingsforplayer(local7, otherindex2, local7\Field48, otherindex4, otherindex5)
                        Else
                            local7\Field1 = 0.0
                            local7\Field2 = 0.0
                            local7\Field3 = 0.0
                            local7\Field46 = udp_readshort()
                            otherindex5 = udp_readbyte()
                            multiplayer_initsettingsforplayer(local7, otherindex2, local7\Field48, $00, otherindex5)
                        EndIf
                    Else
                        If (udp_readbyte() = $00) Then
                            local7\Field32 = "Not Ready"
                        Else
                            local7\Field32 = "Ready"
                        EndIf
                        local7\Field46 = udp_readshort()
                        local7\Field41 = udp_readbyte()
                    EndIf
                    local7\Field79 = $01
                EndIf
            Forever
            myplayer\Field79 = $01
            For local12 = Each players
                If (local12\Field79 = $00) Then
                    multiplayer_disconnectplayer(local12)
                Else
                    local12\Field79 = $00
                EndIf
            Next
            secondarylighton = convertshorttovalue((Float udp_readshort()))
            local69 = udp_readbyte()
            contained106 = readbool(local69, $00)
            remotedooron = readbool(local69, $01)
            mtftimer = (Float udp_readshort())
            itemsrotaterand = (Int convertshorttovalue((Float udp_readshort())))
            local70 = udp_readbyte()
            If (((local70 = $01) And (networkserver\Field49 = $00)) <> 0) Then
                If (networkserver\Field47 = $00) Then
                    networkserver\Field47 = playsound_strict(loadtempsound("SFX\Ending\GateB\DetonatingAlphaWarheads.ogg"))
                EndIf
                If (channelplaying(networkserver\Field48) = $00) Then
                    networkserver\Field48 = playsound_strict(gatebsirensfx)
                EndIf
            Else
                If (channelplaying(networkserver\Field47) <> 0) Then
                    stopchannel(networkserver\Field47)
                EndIf
                If (channelplaying(networkserver\Field48) <> 0) Then
                    stopchannel(networkserver\Field48)
                EndIf
                networkserver\Field47 = $00
            EndIf
            If ((multiplayer_isfullsync() And (networkserver\Field33 = $01)) <> 0) Then
                local71 = udp_readbyte()
                If (readbool(local71, $00) <> 0) Then
                    If (networkserver\Field12 = $00) Then
                        If (0.0 <= killtimer) Then
                            min(-1.0, killtimer)
                        EndIf
                    EndIf
                ElseIf ((((0.0 <= killtimer) = $00) And networkserver\Field12) <> 0) Then
                    multiplayer_requestrole($00)
                EndIf
                noclip = readbool(local71, $01)
                myplayer\Field81 = readbool(local71, $02)
                networkserver\Field52\Field3 = readbool(local71, $04)
                rcon\Field0 = readbool(local71, $06)
                injuries = udp_readfloat()
                myplayer\Field68 = (Float udp_readshort())
                If ((((myplayer\Field68 < myplayer\Field69) And (myplayer\Field49 > $00)) And (readbool(local71, $03) = $00)) <> 0) Then
                    camerashake = ((myplayer\Field69 - myplayer\Field68) / 15.0)
                EndIf
                myplayer\Field69 = myplayer\Field68
                myplayer\Field90 = ((Float udp_readshort()) * 0.01)
                myplayer\Field92 = udp_readfloat()
                local72 = readbool(local71, $05)
                If (((local72 = $01) And (myplayer\Field50 = $00)) <> 0) Then
                    playsound_strict(loadtempsound("GFX\multiplayer\game\sounds\Announcement.ogg"))
                EndIf
                If (((local72 = $00) And (myplayer\Field50 = $01)) <> 0) Then
                    playsound_strict(loadtempsound("GFX\multiplayer\game\sounds\Announcement2.ogg"))
                EndIf
                myplayer\Field50 = local72
                playerintercom\Field1 = (Int ((max((Float udp_readint()), 0.0) + (Float millisecs())) - 1.0))
                playerintercom\Field0 = (Int ((max((Float udp_readint()), 0.0) + (Float millisecs())) - 1.0))
                local73 = udp_readbyte()
                If (pocketdimension106 <> Null) Then
                    pocketdimension106\Field3 = (Float local73)
                EndIf
                local74 = udp_readshort()
                If (local74 <> $00) Then
                    If (local74 <> currentpositionid) Then
                        local75 = $00
                        currentpositionid = local74
                        local0 = udp_readfloat()
                        local1 = udp_readfloat()
                        local2 = udp_readfloat()
                        local75 = udp_readbyte()
                        If (local75 = $00) Then
                            local51 = udp_readline()
                        Else
                            local51 = (Str udp_readbyte())
                        EndIf
                        positionentity(collider, local0, local1, local2, $00)
                        resetentity(collider)
                        If (local75 = $00) Then
                            For local21 = Each rooms
                                If (local21\Field8\Field11 = local51) Then
                                    playerroom = local21
                                    updaterooms()
                                    updateevents()
                                    Exit
                                EndIf
                            Next
                        Else
                            For local21 = Each rooms
                                If (local21\Field65 = (Int local51)) Then
                                    playerroom = local21
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
            If (((networkserver\Field33 = $01) And (mainmenuopen = $01)) <> 0) Then
                startnewgame()
                Return $00
            EndIf
        Case $33
            remotedooron = $01
            For local43 = Each events
                If (local43\Field0 = "gateaentrance") Then
                    local43\Field4 = 1.0
                    local43\Field1\Field29[$01]\Field5 = $01
                ElseIf (local43\Field0 = "exit1") Then
                    local43\Field4 = 1.0
                    local43\Field1\Field29[$04]\Field5 = $01
                EndIf
            Next
            playsound_strict(loadtempsound("SFX\Character\MTF\Announc.ogg"))
            If (networkserver\Field15 <> 0) Then
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
                If (multiplayer_isascp(myplayer\Field49) = $00) Then
                    local76 = createparticle(entityx(collider, $00), (entityy(collider, $00) - 0.1), entityz(collider, $00), $05, 0.06, 0.2, $50, 1.0, $01)
                    local76\Field6 = 0.001
                    local76\Field13 = 0.003
                    local76\Field3 = 0.8
                    local76\Field12 = -0.02
                    local77 = createpivot($00)
                    positionentity(local77, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                    turnentity(local77, 90.0, 0.0, 0.0, $00)
                    entitypick(local77, 0.3)
                    local78 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                    local78\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                    entityalpha(local78\Field0, 1.0)
                    scalesprite(local78\Field0, local78\Field2, local78\Field2)
                    freeentity(local77)
                    multiplayer_writedecal(local78, $01, $01)
                    If (networkserver\Field12 = $00) Then
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
                        myplayer\Field68 = (myplayer\Field68 - (rnd((getgundamage(local7\Field35) - 3.0), (getgundamage(local7\Field35) + 3.0)) - (Float (wearingvest Shl $03))))
                        If (multiplayer_isascp(local7\Field49) <> 0) Then
                            myplayer\Field68 = (myplayer\Field68 - (Float rand($1E, $28)))
                        EndIf
                        If (1.0 > myplayer\Field68) Then
                            kill(("was killed by " + local7\Field24), $00)
                        EndIf
                    EndIf
                Else
                    myplayer\Field68 = ((myplayer\Field68 - getgundamage(local7\Field35)) - (Float rand($01, $02)))
                    injuries = 0.0
                    If (0.0 > myplayer\Field68) Then
                        godmode = $00
                        kill(("was killed by " + local7\Field24), $00)
                    EndIf
                EndIf
            EndIf
        Case $07
            explosiontimer = (Float udp_readint())
            If (networkserver\Field15 <> 0) Then
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
                b_br\Field0 = 140.0
                If (udp_readbyte() = $00) Then
                    networkserver\Field49 = $00
                Else
                    networkserver\Field49 = $01
                EndIf
            Else
                udp_readbyte()
                udp_readbyte()
                udp_readbyte()
                If (udp_readbyte() = $00) Then
                    networkserver\Field49 = $00
                Else
                    networkserver\Field49 = $01
                EndIf
                b_br\Field1 = ""
            EndIf
        Case $09
            playannouncement(udp_readline(), $00, $00)
        Case $26
            For local43 = Each events
                If (local43\Field0 = "173") Then
                    local43\Field4 = udp_readfloat()
                    Exit
                EndIf
            Next
            If (networkserver\Field15 <> 0) Then
                For local12 = Each players
                    If (local12\Field0 <> $01) Then
                        udp_writebyte($26)
                        udp_writebyte($01)
                        If (local43 <> Null) Then
                            udp_writefloat(local43\Field4)
                        EndIf
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $2A
            For local43 = Each events
                If (local43\Field0 = "alarm") Then
                    If (local43\Field1\Field32[$00] <> Null) Then
                        removenpc(local43\Field1\Field32[$00], $00)
                    EndIf
                    If (local43\Field1\Field32[$01] <> Null) Then
                        removenpc(local43\Field1\Field32[$01], $00)
                    EndIf
                    If (local43\Field1\Field32[$02] <> Null) Then
                        removenpc(local43\Field1\Field32[$02], $00)
                    EndIf
                    positionentity(curr173\Field4, 0.0, 0.0, 0.0, $00)
                    resetentity(curr173\Field4)
                    showentity(curr173\Field0)
                    removeevent(local43)
                    Exit
                EndIf
            Next
            createconsolemsg("Stopped all sounds.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            If (networkserver\Field15 <> 0) Then
                For local12 = Each players
                    If (local12\Field0 <> $01) Then
                        udp_writebyte($2A)
                        udp_writebyte($01)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $25
            For local43 = Each events
                If (local43\Field0 = "room106") Then
                    If (0.0 = local43\Field2) Then
                        local43\Field2 = 1.0
                        If (soundtransmission = $01) Then
                            If (local43\Field6 <> $00) Then
                                If (channelplaying(local43\Field6) <> 0) Then
                                    stopchannel(local43\Field6)
                                EndIf
                            EndIf
                            femurbreakersfx = loadsound_strict("SFX\Room\106Chamber\FemurBreaker.ogg")
                            local43\Field6 = playsound_strict(femurbreakersfx)
                        EndIf
                    EndIf
                    Exit
                EndIf
            Next
            If (networkserver\Field15 <> 0) Then
                For local12 = Each players
                    If (local12\Field0 <> $01) Then
                        udp_writebyte($25)
                        udp_writebyte($01)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $12
            For local43 = Each events
                If (local43\Field0 = "gateaentrance") Then
                    local43\Field4 = 1.0
                    local43\Field1\Field29[$01]\Field5 = $01
                ElseIf (local43\Field0 = "exit1") Then
                    local43\Field4 = 1.0
                    local43\Field1\Field29[$04]\Field5 = $01
                EndIf
            Next
            createconsolemsg("Gate A and B are now unlocked.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            remotedooron = $01
            If (networkserver\Field15 <> 0) Then
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
            local79 = udp_readbyte()
            local80 = udp_readfloat()
            local81 = udp_readfloat()
            local82 = udp_readfloat()
            local83 = udp_readfloat()
            local84 = udp_readfloat()
            local85 = udp_readfloat()
            local86 = udp_readfloat()
            local87 = udp_readfloat()
            local88 = udp_readfloat()
            local89 = udp_readfloat()
            local90 = udp_readfloat()
            local91 = udp_readfloat()
            local92 = createdecal(local79, local80, local81, local82, local85, local83, local84, 1.0, 1.0)
            If (local79 = $05) Then
                entitycolor(local92\Field0, 0.0, rnd(200.0, 255.0), 0.0)
            EndIf
            local92\Field1 = local86
            local92\Field2 = local87
            local92\Field3 = local88
            local92\Field4 = local89
            local92\Field5 = local90
            local92\Field9 = local91
            entityalpha(local92\Field0, local92\Field5)
            scalesprite(local92\Field0, local92\Field2, local92\Field2)
        Case $16
            If (((arg1 <> networkserver\Field20) Or (networkserver\Field15 = $00)) <> 0) Then
                local93 = udp_readint()
                For local36 = Each itemtemplates
                    If (local36\Field0 = local93) Then
                        local35 = createitem(local36\Field1, local36\Field2, entityx(local7\Field13, $00), (entityy(getplayercamera(arg1), $00) + 0.1), entityz(local7\Field13, $00), $00, $00, $00, 1.0, $00, $01)
                        entitytype(local35\Field2, $03, $00)
                        local35\Field22 = $00
                        Exit
                    EndIf
                Next
            EndIf
        Case $17
            otherindex = udp_readshort()
            otherindex2 = udp_readbyte()
            otherindex3 = udp_readbyte()
            If (arg1 <> networkserver\Field20) Then
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
            If (((local7 <> Null) And (arg1 <> networkserver\Field20)) <> 0) Then
                local7\Field84 = $01
            EndIf
            If (networkserver\Field15 <> 0) Then
                For local12 = Each players
                    If (((local12\Field0 <> arg1) And (local12\Field0 <> $01)) <> 0) Then
                        udp_writebyte($7B)
                        udp_writebyte(arg1)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
        Case $1D
            If (((udp_readavail() < $02) Or (udp_readavail() > $3C1)) <> 0) Then
                Return $00
            EndIf
            vsrc = createbank((udp_readavail() - $01))
            If (vsrc = $00) Then
                Return $00
            EndIf
            udp_readbytes(vsrc, $00, banksize(vsrc))
            local94 = udp_readbyte()
            If (((local7 <> Null) And (arg1 <> networkserver\Field20)) <> 0) Then
                local95 = millisecs()
                local7\Field83 = (Int min(max((Float (local95 - local7\Field82)), 5.0), 1000.0))
                local7\Field82 = local95
                If (0.0 <> local7\Field63) Then
                    local96 = opus_pcm_decode(local7\Field85, vsrc, $00)
                    If (local96 <> $00) Then
                        voice_player_receive(arg1, local96, (Float local7\Field83), local94)
                        freebank(local96)
                    EndIf
                EndIf
            EndIf
            If (networkserver\Field15 <> 0) Then
                For local12 = Each players
                    If (((local12\Field0 <> arg1) And (local12\Field0 <> $01)) <> 0) Then
                        udp_writebyte($1D)
                        udp_writebyte(arg1)
                        udp_writebytes(vsrc, $00, banksize(vsrc))
                        udp_writebyte(local12\Field65)
                        udp_sendmessage(local12\Field0)
                    EndIf
                Next
            EndIf
            freebank(vsrc)
        Case $03
            otherindexstr = udp_readline()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            If (issafeserversound(otherindexstr) = $00) Then
                Return $00
            EndIf
            If (local7 <> Null) Then
                If (local7\Field13 <> $00) Then
                    If (arg1 <> networkserver\Field20) Then
                        playplayersound(local7, otherindexstr, local0, local1, $00)
                    ElseIf (udp_readbyte() = $00) Then
                        If (networkserver\Field15 = $00) Then
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
