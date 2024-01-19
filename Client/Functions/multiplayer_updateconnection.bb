Function multiplayer_updateconnection%()
    Local local0.servers
    Local local2%
    Local local3%
    Local local4%
    Local local5.servers
    Local local6%
    Local local7%
    Local local8%
    Local local10$
    Local local11.breachtypes
    Local local12%
    If ((udp_getconnection() And (udp_getstream() = $00)) <> 0) Then
        If (millisecs() > networkserver\Field4) Then
            For local0 = Each servers
                If (local0\Field15 <> 0) Then
                    multiplayer_list_deleteserver(local0)
                EndIf
            Next
            adderrorlog("Server not responding", $FF, $00, $00, $1388)
            udp_setstream(udp_network, $00, $00, $00, $01)
            Return $00
        Else
            If (((millisecs() > networkserver\Field6) And (networkserver\Field6 <> $00)) <> 0) Then
                udp_writebyte($1A)
                udp_writebyte($00)
                udp_writeline(nickname)
                udp_writeline(multiplayer_version)
                udp_writeline(password)
                udp_writebyte($02)
                udp_writeshort(graphicwidth)
                udp_writeshort(graphicheight)
                udp_writebyte($00)
                udp_writeint(currentsteamid)
                udp_writebytes(currentsessionticketdata, $00, banksize(currentsessionticketdata))
                udp_sendmessage($00)
                networkserver\Field6 = (millisecs() + $5DC)
                If (((bs_isteamuser_isloggedon(bs_steamuser()) = $00) And networkserver\Field7) <> 0) Then
                    adderrorlog("No connection to the Steam was detected.", $FF, $00, $00, $1388)
                    udp_setstream(udp_network, $00, $00, $00, $01)
                    networkserver\Field7 = $00
                    Return $00
                EndIf
                networkserver\Field7 = $01
            EndIf
            While (udp_recvudpmsg($00) <> 0)
                udp_countavail((Float udp_readavail()))
                Select udp_readbyte()
                    Case $1A
                        networkserver\Field1 = udp_udpmsgip()
                        networkserver\Field2 = udp_udpmsgport()
                        networkserver\Field8 = (Str local2)
                        networkserver\Field9 = (Str local3)
                        networkserver\Field28 = udp_readbyte()
                        If (((networkserver\Field28 < $00) Or (networkserver\Field28 > $40)) <> 0) Then
                            adderrorlog("Unknown error", $FF, $00, $00, $1388)
                            clearserver()
                            Return $00
                        EndIf
                        If (networkserver\Field28 > $00) Then
                            multiplayer_createplayer(networkserver\Field28)
                        EndIf
                        networkserver\Field21 = ""
                        For local0 = Each servers
                            If ((((local0\Field18 = networkserver\Field1) And ((Int local0\Field2) = networkserver\Field2)) And (local0\Field4 <> $00)) <> 0) Then
                                networkserver\Field21 = local0\Field10
                                Exit
                            EndIf
                        Next
                        If (networkserver\Field21 = "") Then
                            networkserver\Field21 = "Classic server"
                        EndIf
                        If (networkserver\Field28 > $00) Then
                            myplayer\Field24 = nickname
                        EndIf
                        randomseed = udp_readline()
                        introenabled = udp_readbyte()
                        nocheat = udp_readbyte()
                        networkserver\Field24 = udp_readbyte()
                        networkserver\Field5 = udp_readfloat()
                        networkserver\Field3 = udp_readint()
                        networkserver\Field12 = udp_readfloat()
                        networkserver\Field13 = udp_readbyte()
                        networkserver\Field14 = udp_readbyte()
                        networkserver\Field19 = udp_readbyte()
                        networkserver\Field15 = udp_readbyte()
                        networkserver\Field23 = udp_readbyte()
                        If (((networkserver\Field15 = $00) And (networkserver\Field28 > $00)) <> 0) Then
                            myplayer\Field51 = udp_readbyte()
                        Else
                            udp_readbyte()
                            If (networkserver\Field28 > $00) Then
                                myplayer\Field51 = $00
                            EndIf
                        EndIf
                        b_br\Field7 = (millisecs() + udp_readint())
                        b_br\Field6 = udp_readint()
                        If (networkserver\Field28 > $00) Then
                            myplayer\Field50 = udp_readbyte()
                        Else
                            udp_readbyte()
                        EndIf
                        b_br\Field5 = (millisecs() + udp_readint())
                        selecteddifficulty = difficulties(udp_readbyte())
                        local4 = udp_readbyte()
                        networkserver\Field30 = $BB80
                        udp_readint()
                        If (((serverinlist(dottedip(networkserver\Field1), networkserver\Field2, $03) = $00) And (networkserver\Field49 = $00)) <> 0) Then
                            local5 = (New servers)
                            local5\Field0 = $03
                            local5\Field1 = dottedip(networkserver\Field1)
                            local5\Field2 = (Str networkserver\Field2)
                        EndIf
                        networkserver\Field4 = ((millisecs() + networkserver\Field3) + $7D0)
                        udp_writetimeout($00, multiplayer_gettickratedelay())
                        udp_writetimeout($01, multiplayer_gettickratedelay())
                        udp_writetimeout($02, $1F4)
                        networkserver\Field44 = udp_readline()
                        networkserver\Field18 = $00
                        If (udp_readbyte() = $80) Then
                            networkserver\Field18 = $01
                            networkserver\Field42 = $00
                            udp_writetimeout($00, multiplayer_gettickratedelay())
                            udp_writetimeout($01, multiplayer_gettickratedelay())
                            udp_writetimeout($02, $3E8)
                            udp_writetimeout($03, $5DC)
                        EndIf
                        networkserver\Field47 = udp_readbyte()
                        networkserver\Field48 = udp_readbyte()
                        networkserver\Field52 = udp_readbyte()
                        networkserver\Field60 = udp_readbyte()
                        networkserver\Field61 = udp_readbyte()
                        networkserver\Field66 = udp_readbyte()
                        networkserver\Field67 = udp_readline()
                        networkserver\Field68 = udp_readline()
                        halloweenindex = udp_readbyte()
                        newyearindex = udp_readbyte()
                        mainmenutab = $0E
                        If (networkserver\Field28 = $00) Then
                            udp_writebyte($7E)
                            udp_writebyte($00)
                            udp_sendmessage($00)
                            local6 = (millisecs() + $BB8)
                            local7 = (millisecs() + $12C)
                            While (local6 > millisecs())
                                If (udp_recvudpmsg($00) <> 0) Then
                                    local8 = udp_readbyte()
                                    Select local8
                                        Case $7E
                                            networkserver\Field28 = udp_readbyte()
                                            multiplayer_createplayer(networkserver\Field28)
                                            If (networkserver\Field15 = $00) Then
                                                myplayer\Field51 = udp_readbyte()
                                            Else
                                                udp_readbyte()
                                                myplayer\Field51 = $00
                                            EndIf
                                            myplayer\Field50 = udp_readbyte()
                                            selecteddifficulty = difficulties(udp_readbyte())
                                            Exit
                                        Case $71
                                            local10 = udp_readline()
                                            If (instr(local10, "password", $01) <> 0) Then
                                                passwordmenu = $01
                                                addservermenu = $00
                                                connectmenu = $00
                                            EndIf
                                            While (local10 <> "")
                                                adderrorlog(local10, $FF, $00, $00, $1388)
                                                local10 = udp_readline()
                                                If (instr(local10, "password", $01) <> 0) Then
                                                    passwordmenu = $01
                                                    addservermenu = $00
                                                    connectmenu = $00
                                                EndIf
                                            Wend
                                            local6 = $FFFFFFFF
                                            Exit
                                    End Select
                                EndIf
                                If (local7 < millisecs()) Then
                                    udp_writebyte($7E)
                                    udp_writebyte($00)
                                    udp_sendmessage($00)
                                    local7 = (millisecs() + $12C)
                                EndIf
                                delay($0A)
                            Wend
                            If (((local6 <= millisecs()) And (local6 <> $FFFFFFFF)) <> 0) Then
                                adderrorlog("Unknown error", $FF, $00, $00, $1388)
                                clearserver()
                                Return $00
                            EndIf
                            If (local6 = $FFFFFFFF) Then
                                clearserver()
                                Return $00
                            EndIf
                        EndIf
                        For local11 = Each breachtypes
                            If (local11\Field1 = myplayer\Field51) Then
                                scaleentity(myhitbox, local11\Field10, local11\Field11, local11\Field12, $00)
                                positionentity(myhitbox, 0.0, ((- local11\Field52) + 0.05), 0.0, $00)
                                Exit
                            EndIf
                        Next
                        preparemodels()
                        cancelsteamticket()
                        debuglog(((Str newyearindex) + " WTF?"))
                        debuglog("Joined!")
                        If (udp_network\Field0 <> $00) Then
                            setudpstreambuffersize(udp_network\Field0, $10000)
                        EndIf
                        If (((local4 = $01) And (networkserver\Field44 = "")) <> 0) Then
                            startnewgame()
                        Else
                            steam_api_setachievement("AchvMultiplayer")
                        EndIf
                        Return $01
                    Case $49
                        adderrorlog("Version doesn't match", $FF, $00, $00, $1388)
                        adderrorlog(("Your version: v" + multiplayer_version), $FF, $00, $00, $1388)
                        adderrorlog(("Server version: v" + udp_readline()), $FF, $00, $00, $1388)
                        udp_setstream(udp_network, $00, $00, $00, $01)
                        Return $00
                    Case $4E
                        adderrorlog("You are banned", $FF, $00, $00, $1388)
                        udp_setstream(udp_network, $00, $00, $00, $01)
                        Return $00
                    Case $4D
                        adderrorlog("Change your name", $FF, $00, $00, $1388)
                        udp_setstream(udp_network, $00, $00, $00, $01)
                        Return $00
                    Case $56
                        adderrorlog("Wrong password", $FF, $00, $00, $1388)
                        udp_setstream(udp_network, $00, $00, $00, $01)
                        Return $00
                    Case $71
                        local10 = udp_readline()
                        If (instr(local10, "password", $01) <> 0) Then
                            passwordmenu = $01
                            addservermenu = $00
                            connectmenu = $00
                        EndIf
                        While (local10 <> "")
                            adderrorlog(local10, $FF, $00, $00, $1388)
                            local10 = udp_readline()
                            If (instr(local10, "password", $01) <> 0) Then
                                passwordmenu = $01
                                addservermenu = $00
                                connectmenu = $00
                            EndIf
                        Wend
                        udp_setstream(udp_network, $00, $00, $00, $01)
                        Return $00
                End Select
            Wend
        EndIf
    ElseIf (udp_getstream() = $00) Then
        local12 = createbank($04)
        While (bs_isteamnetworking_isp2ppacketavailable(bs_steamnetworking(), local12, $00) <> 0)
            udp_clearreadavail()
            udp_network\Field6 = udp_getsteamreceive()
            udp_network\Field13 = peekint(local12, $00)
            udp_network\Field7 = udp_network\Field6
            udp_network\Field8 = $00
            bs_isteamnetworking_readp2ppacket(bs_steamnetworking(), udp_network\Field15, udp_network\Field13, local12, udp_network\Field6, $00)
            If (udp_readbyte() = $7D) Then
                multiplayer_connectto((Str udp_udpmsgip()), $00, "", $01, $1388)
                Exit
            EndIf
        Wend
        freebank(local12)
    EndIf
    Return $00
End Function
