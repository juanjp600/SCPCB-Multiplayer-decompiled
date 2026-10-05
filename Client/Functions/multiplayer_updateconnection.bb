Function multiplayer_updateconnection%()
    Local local0.servers
    Local local1%
    Local local3%
    Local local4%
    Local local5%
    Local local6.servers
    Local local7%
    Local local8%
    Local local9%
    Local local11$
    Local local12.breachtypes
    Local local13%
    If ((udp_getconnection() And (udp_getstream() = $00)) <> 0) Then
        If (((millisecs() > networkserver\Field4) And (networkserver\Field36 = $00)) <> 0) Then
            For local0 = Each servers
                If (local0\Field15 <> 0) Then
                    multiplayer_list_deleteserver(local0)
                EndIf
            Next
            adderrorlog("Server not responding", $FF, $00, $00, $1388)
            udp_setstream(udp_network, $00, $00, $00, $01)
            Return $00
        Else
            If (millisecs() > networkserver\Field6) Then
                udp_writebyte($1A)
                udp_writebyte($00)
                udp_writeline(nickname)
                udp_writeline(multiplayer_version)
                udp_writeline(password)
                udp_writebyte($02)
                udp_writeshort(graphicwidth)
                udp_writeshort(graphicheight)
                udp_writebyte($00)
                If (networkserver\Field36 = $00) Then
                    udp_writeline(steamid64)
                    udp_writebytes(steamauthticket, $00, steamauthticketsize)
                EndIf
                udp_sendmessage($00)
                networkserver\Field6 = (millisecs() + $5DC)
                networkserver\Field7 = $01
            EndIf
            While (udp_recvudpmsg() <> 0)
                local1 = udp_readbyte()
                If (((networkserver\Field36 = $00) And ((udp_udpmsgip() <> udp_network\Field1) Or (udp_udpmsgport() <> udp_network\Field2))) <> 0) Then
                    local1 = $FFFFFFFF
                EndIf
                Select local1
                    Case $7E
                        udp_writebyte($1A)
                        udp_writebyte($00)
                        udp_writeline(nickname)
                        udp_writeline(multiplayer_version)
                        udp_writeline(password)
                        udp_writebyte($02)
                        udp_writeshort(graphicwidth)
                        udp_writeshort(graphicheight)
                        udp_writebyte($00)
                        If (networkserver\Field36 = $00) Then
                            udp_writeline(steamid64)
                            udp_writebytes(steamauthticket, $00, steamauthticketsize)
                        EndIf
                        udp_sendmessage($00)
                    Case $1A
                        networkserver\Field1 = udp_udpmsgip()
                        networkserver\Field2 = udp_udpmsgport()
                        networkserver\Field8 = (Str local3)
                        networkserver\Field9 = (Str local4)
                        networkserver\Field20 = udp_readbyte()
                        If (((networkserver\Field20 < $00) Or (networkserver\Field20 > $40)) <> 0) Then
                            adderrorlog("Unknown error", $FF, $00, $00, $1388)
                            clearserver()
                            Return $00
                        EndIf
                        If (networkserver\Field20 > $00) Then
                            multiplayer_createplayer(networkserver\Field20)
                        EndIf
                        networkserver\Field52\Field0 = ""
                        For local0 = Each servers
                            If ((((local0\Field18 = networkserver\Field1) And ((Int local0\Field2) = networkserver\Field2)) And (local0\Field4 <> $00)) <> 0) Then
                                networkserver\Field52\Field0 = local0\Field10
                                Exit
                            EndIf
                        Next
                        If (networkserver\Field52\Field0 = "") Then
                            networkserver\Field52\Field0 = "Classic server"
                        EndIf
                        If (networkserver\Field20 > $00) Then
                            myplayer\Field24 = nickname
                        EndIf
                        randomseed = udp_readline()
                        introenabled = udp_readbyte()
                        nocheat = udp_readbyte()
                        networkserver\Field52\Field10 = udp_readbyte()
                        networkserver\Field5 = udp_readfloat()
                        networkserver\Field3 = udp_readint()
                        networkserver\Field52\Field15 = udp_readfloat()
                        networkserver\Field52\Field16 = udp_readbyte()
                        networkserver\Field52\Field14 = udp_readbyte()
                        networkserver\Field16 = udp_readbyte()
                        networkserver\Field12 = udp_readbyte()
                        networkserver\Field52\Field12 = udp_readbyte()
                        If (((networkserver\Field12 = $00) And (networkserver\Field20 > $00)) <> 0) Then
                            myplayer\Field49 = udp_readbyte()
                        Else
                            udp_readbyte()
                            If (networkserver\Field20 > $00) Then
                                myplayer\Field49 = $00
                            EndIf
                        EndIf
                        b_br\Field7 = (millisecs() + udp_readint())
                        b_br\Field6 = udp_readint()
                        If (networkserver\Field20 > $00) Then
                            myplayer\Field48 = udp_readbyte()
                        Else
                            udp_readbyte()
                        EndIf
                        b_br\Field5 = (millisecs() + udp_readint())
                        selecteddifficulty = difficulties(udp_readbyte())
                        local5 = udp_readbyte()
                        networkserver\Field52\Field13 = $BB80
                        udp_readint()
                        If (((serverinlist(dottedip(networkserver\Field1), networkserver\Field2, $03) = $00) And (networkserver\Field36 = $00)) <> 0) Then
                            local6 = (New servers)
                            local6\Field0 = $03
                            local6\Field1 = dottedip(networkserver\Field1)
                            local6\Field2 = (Str networkserver\Field2)
                        EndIf
                        networkserver\Field4 = ((millisecs() + networkserver\Field3) + $7D0)
                        udp_writetimeout($00, multiplayer_gettickratedelay())
                        udp_writetimeout($01, multiplayer_gettickratedelay())
                        udp_writetimeout($02, $1F4)
                        networkserver\Field52\Field8 = udp_readline()
                        networkserver\Field15 = $00
                        If (udp_readbyte() = $80) Then
                            networkserver\Field15 = $01
                            networkserver\Field32 = $00
                            udp_writetimeout($00, multiplayer_gettickratedelay())
                            udp_writetimeout($01, multiplayer_gettickratedelay())
                            udp_writetimeout($02, $3E8)
                            udp_writetimeout($03, $5DC)
                        EndIf
                        networkserver\Field52\Field6 = udp_readbyte()
                        networkserver\Field52\Field7 = udp_readbyte()
                        networkserver\Field52\Field4 = udp_readbyte()
                        networkserver\Field52\Field5 = udp_readbyte()
                        networkserver\Field52\Field2 = udp_readbyte()
                        networkserver\Field50 = udp_readline()
                        networkserver\Field51 = udp_readline()
                        halloweenindex = udp_readbyte()
                        newyearindex = udp_readbyte()
                        mainmenutab = $0E
                        If (networkserver\Field20 = $00) Then
                            udp_writebyte($7E)
                            udp_writebyte($00)
                            udp_sendmessage($00)
                            local7 = (millisecs() + $BB8)
                            local8 = (millisecs() + $12C)
                            While (local7 > millisecs())
                                If (udp_recvudpmsg() <> 0) Then
                                    local9 = udp_readbyte()
                                    Select local9
                                        Case $7E
                                            networkserver\Field20 = udp_readbyte()
                                            multiplayer_createplayer(networkserver\Field20)
                                            If (networkserver\Field12 = $00) Then
                                                myplayer\Field49 = udp_readbyte()
                                            Else
                                                udp_readbyte()
                                                myplayer\Field49 = $00
                                            EndIf
                                            myplayer\Field48 = udp_readbyte()
                                            selecteddifficulty = difficulties(udp_readbyte())
                                            Exit
                                        Case $71
                                            local11 = udp_readline()
                                            If (instr(local11, "password", $01) <> 0) Then
                                                passwordmenu = $01
                                                addservermenu = $00
                                                connectmenu = $00
                                            EndIf
                                            While (local11 <> "")
                                                adderrorlog(local11, $FF, $00, $00, $1388)
                                                local11 = udp_readline()
                                                If (instr(local11, "password", $01) <> 0) Then
                                                    passwordmenu = $01
                                                    addservermenu = $00
                                                    connectmenu = $00
                                                EndIf
                                            Wend
                                            local7 = $FFFFFFFF
                                            Exit
                                    End Select
                                EndIf
                                If (local8 < millisecs()) Then
                                    udp_writebyte($7E)
                                    udp_writebyte($00)
                                    udp_sendmessage($00)
                                    local8 = (millisecs() + $12C)
                                EndIf
                            Wend
                            If (((local7 <= millisecs()) And (local7 <> $FFFFFFFF)) <> 0) Then
                                adderrorlog("Unknown error", $FF, $00, $00, $1388)
                                clearserver()
                                Return $00
                            EndIf
                            If (local7 = $FFFFFFFF) Then
                                clearserver()
                                Return $00
                            EndIf
                        EndIf
                        For local12 = Each breachtypes
                            If (local12\Field1 = myplayer\Field49) Then
                                scaleentity(myhitbox, local12\Field10, local12\Field11, local12\Field12, $00)
                                positionentity(myhitbox, 0.0, ((- local12\Field53) + 0.05), 0.0, $00)
                                Exit
                            EndIf
                        Next
                        preparemodels()
                        If (udp_network\Field0 <> $00) Then
                            setudpstreambuffersize(udp_network\Field0, $10000)
                        EndIf
                        If (((local5 = $01) And (networkserver\Field52\Field8 = "")) <> 0) Then
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
                        local11 = udp_readline()
                        If (instr(local11, "password", $01) <> 0) Then
                            passwordmenu = $01
                            addservermenu = $00
                            connectmenu = $00
                        EndIf
                        While (local11 <> "")
                            adderrorlog(local11, $FF, $00, $00, $1388)
                            local11 = udp_readline()
                            If (instr(local11, "password", $01) <> 0) Then
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
        networkserver\Field36 = $01
        If (((networkserver\Field37 = $01) And (millisecs() > networkserver\Field39)) <> 0) Then
            udp_writebyte($7E)
            udp_writebyte($00)
            udp_sendmessageinternal($00, steam_getlobbyowneridupper(), steam_getlobbyowneridlower(), $00)
            networkserver\Field39 = (millisecs() + $5DC)
        EndIf
        local13 = $00
        While (steam_loadpacket() <> 0)
            If (udp_readbyte() = $7E) Then
                multiplayer_connectto((Str udp_udpmsgip()), udp_udpmsgport(), "", $01, $1388)
                local13 = $01
                Exit
            EndIf
        Wend
        networkserver\Field36 = local13
    EndIf
    Return $00
End Function
