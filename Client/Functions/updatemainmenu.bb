Function updatemainmenu%()
    Local local0.save
    Local local1.custommaps
    Local local2.sound
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8%
    Local local9%
    Local local10$
    Local local11%
    Local local12.mp_listserver
    Local local14%
    Local local15%
    Local local16#
    Local local17#
    Local local18%
    Local local19$
    Local local20%
    Local local21.mp_listserver
    Local local22#
    Local local23#
    Local local24#
    Local local25#
    Local local26%
    Local local27#
    Local local28#
    Local local29%
    Local local30#
    Local local31.mp_listserver
    Local local32%
    Local local33%
    Local local35.difficulty
    Local local36%
    Local local37%
    Local local42%
    Local local43$
    Local local44%
    Local local45%
    Local local46%
    Local local47%
    Local local49%
    Local local50%
    Local local51$
    Local local52%
    Local local53%
    catcherrors("UpdateMainMenu()")
    While (0.0 < fps\Field0)
        fps\Field0 = (fps\Field0 - 1.166667)
        updatemouseinput()
        If (shoulddeletegadgets <> 0) Then
            deletemenugadgets()
        EndIf
        shoulddeletegadgets = $00
        onpalette = $00
        updatemusic()
        If (opt\Field22 <> 0) Then
            autoreleasesounds()
        EndIf
        If (shouldplay = $14) Then
            endbreathsfx = loadsound_strict("SFX\Ending\MenuBreath.ogg")
            endbreathchn = playsound_strict(endbreathsfx, $01)
            shouldplay = $42
        ElseIf (shouldplay = $42) Then
            If (channelplaying(endbreathchn) = $00) Then
                freesound_strict(endbreathsfx)
                endbreathsfx = $00
                shouldplay = $0B
            EndIf
        Else
            shouldplay = $0B
        EndIf
        If (rand($12C, $01) = $01) Then
            mm\Field0[$00] = rnd(4000.0, 8000.0)
            mm\Field1[$00] = rnd(200.0, 500.0)
        EndIf
        mm\Field0[$01] = (mm\Field0[$01] - fps\Field7[$00])
        If (mo\Field2 = $00) Then
            onsliderid = $00
        EndIf
        If (mm\Field6 <> mm\Field5) Then
            deletemenugadgets()
            mm\Field7 = $00
        EndIf
        mm\Field6 = mm\Field5
        local3 = (159.0 * menuscale)
        If (mm\Field5 = $00) Then
            local4 = (286.0 * menuscale)
            local5 = (400.0 * menuscale)
            local6 = (70.0 * menuscale)
            randomseed = ""
            If (updatemenubutton((Int local3), (Int local4), (Int local5), (Int local6), getlocalstring("mpmenu", "serverlist"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                mm\Field5 = $01
                serverlist\Field4 = $00
                mp_fillserverlist($00)
                For local12 = Each mp_listserver
                    If (local12\Field10 = $00) Then
                        mp_pingserver(local12\Field0, local12\Field1, $00, $00)
                        local12\Field16 = $00
                    EndIf
                Next
            EndIf
            local4 = ((100.0 * menuscale) + local4)
            If (updatemenubutton((Int local3), (Int local4), (Int local5), (Int local6), getlocalstring("menu", "new"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                If (opt\Field54 <> 0) Then
                    randomseed = "666"
                Else
                    local8 = rand($04, $08)
                    For local9 = $01 To local8 Step $01
                        If (rand($03, $01) = $01) Then
                            randomseed = (randomseed + (Str rand($00, $09)))
                        Else
                            randomseed = (randomseed + chr(rand($61, $7A)))
                        EndIf
                    Next
                EndIf
                loadsavedgames()
                currsave = (New save)
                loadcustommaps()
                currcustommap = (New custommaps)
                mm\Field5 = $03
            EndIf
            local4 = ((100.0 * menuscale) + local4)
            If (updatemenubutton((Int local3), (Int local4), (Int local5), (Int local6), getlocalstring("menu", "load"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                loadsavedgames()
                mm\Field5 = $04
            EndIf
            local4 = ((100.0 * menuscale) + local4)
            If (updatemenubutton((Int local3), (Int local4), (Int local5), (Int local6), getlocalstring("menu", "options"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                mm\Field5 = $06
            EndIf
            local4 = ((100.0 * menuscale) + local4)
            If (updatemenubutton((Int local3), (Int local4), (Int local5), (Int local6), getlocalstring("menu", "quit"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                stopstream_strict(musicchn)
                musicchn = $00
                end()
            EndIf
        Else
            local4 = (376.0 * menuscale)
            local5 = (580.0 * menuscale)
            If (mm\Field5 < $07) Then
                Select mm\Field5
                    Case $01
                        local6 = (415.0 * menuscale)
                        local5 = (1080.0 * menuscale)
                        local4 = (local4 - (4.0 * menuscale))
                        color($FF, $FF, $FF)
                        local14 = $00
                        local15 = $00
                        local16 = local3
                        If (updatemenubutton((Int local16), (Int local4), (Int (local5 / 3.0)), (Int (25.0 * menuscale)), (("INTERNET (" + (Str mp_countlistservers($00, $01))) + ")"), $00, $01, (serverlist\Field4 = $00), $FF, $FF, $FF, $00, 1.0, $00, $00) <> 0) Then
                            serverlist\Field4 = $00
                            mp_fillserverlist($00)
                            local14 = $01
                        EndIf
                        local16 = ((local5 / 3.0) + local16)
                        If (updatemenubutton((Int (local16 - (4.0 * menuscale))), (Int local4), (Int ((local5 / 3.0) + (4.0 * menuscale))), (Int (25.0 * menuscale)), (("HISTORY (" + (Str mp_countlistservers($01, $00))) + ")"), $00, $01, (serverlist\Field4 = $01), $FF, $FF, $FF, $00, 1.0, $00, $00) <> 0) Then
                            serverlist\Field4 = $01
                            mp_fillserverlist($01)
                        EndIf
                        local16 = ((local5 / 3.0) + local16)
                        If (updatemenubutton((Int (local16 - (4.0 * menuscale))), (Int local4), (Int ((local5 / 3.0) + (4.0 * menuscale))), (Int (25.0 * menuscale)), (("FAVOURITES (" + (Str mp_countlistservers($02, $00))) + ")"), $00, $01, (serverlist\Field4 = $02), $FF, $FF, $FF, $00, 1.0, $00, $00) <> 0) Then
                            serverlist\Field4 = $02
                            mp_fillserverlist($02)
                            local14 = $01
                        EndIf
                        local17 = local3
                        local14 = (local14 + mouseon((Int local17), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int (local5 * 0.027)), (Int (25.0 * menuscale))))
                        If (updatemenubutton((Int local17), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int (local5 * 0.027)), (Int (25.0 * menuscale)), "C", $09, $01, $00, $FF, $FF, $FF, $00, 1.0, $01, $01) <> 0) Then
                        EndIf
                        local17 = ((local5 * 0.027) + local17)
                        local14 = (local14 + mouseon((Int (local17 - (4.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int (local5 * 0.5402)), (Int (25.0 * menuscale))))
                        If (updatemenubutton((Int (local17 - (4.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int ((local5 * 0.5402) + (4.0 * menuscale))), (Int (25.0 * menuscale)), ("Servers" + mp_getsortedchar($00)), $00, $01, $00, $FF, $FF, $FF, $00, 0.05, $00, $00) <> 0) Then
                            mp_sortserverlist(serverlist\Field4, $00)
                        EndIf
                        local17 = ((local5 * 0.5402) + local17)
                        local14 = (local14 + mouseon((Int (local17 - (4.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int (local5 * 0.18)), (Int (25.0 * menuscale))))
                        If (updatemenubutton((Int (local17 - (4.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int ((local5 * 0.18) + (4.0 * menuscale))), (Int (25.0 * menuscale)), ("Gamemode" + mp_getsortedchar($01)), $00, $01, $00, $FF, $FF, $FF, $00, 0.15, $00, $00) <> 0) Then
                            mp_sortserverlist(serverlist\Field4, $01)
                        EndIf
                        local17 = ((local5 * 0.18) + local17)
                        local14 = (local14 + mouseon((Int (local17 - (4.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int (local5 * 0.13)), (Int (25.0 * menuscale))))
                        If (updatemenubutton((Int (local17 - (4.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int ((local5 * 0.13) + (4.0 * menuscale))), (Int (25.0 * menuscale)), ("Players" + mp_getsortedchar($02)), $00, $01, $00, $FF, $FF, $FF, $00, 0.15, $00, $00) <> 0) Then
                            mp_sortserverlist(serverlist\Field4, $02)
                        EndIf
                        local17 = ((local5 * 0.13) + local17)
                        local14 = (local14 + mouseon((Int (local17 - (4.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int (local5 * 0.1013)), (Int (25.0 * menuscale))))
                        If (updatemenubutton((Int (local17 - (4.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int ((local5 * 0.1013) + (2.0 * menuscale))), (Int (25.0 * menuscale)), ("Ping" + mp_getsortedchar($03)), $00, $01, $00, $FF, $FF, $FF, $00, 0.15, $00, $00) <> 0) Then
                            mp_sortserverlist(serverlist\Field4, $03)
                        EndIf
                        local17 = ((local5 * 0.1013) + local17)
                        local14 = (local14 + mouseon((Int local3), (Int (((local4 + local6) - (35.0 * menuscale)) + (6.0 * menuscale))), (Int local5), (Int (50.0 * menuscale))))
                        updatemenubutton((Int local3), (Int (((local4 + local6) - (35.0 * menuscale)) + (6.0 * menuscale))), (Int local5), (Int (54.0 * menuscale)), "", $00, $01, $00, $FF, $FF, $FF, $00, 1.0, $01, $01)
                        updatemenubutton((Int (local17 - (8.0 * menuscale))), (Int (((25.0 * menuscale) + local4) - (4.0 * menuscale))), (Int ((local5 * 0.0215) + (8.0 * menuscale))), (Int (25.0 * menuscale)), "E", $09, $01, $00, $FF, $FF, $FF, $00, 1.0, $01, $01)
                        If (updatemenubutton((Int ((15.0 * menuscale) + local3)), (Int ((((local4 + local6) - (17.0 * menuscale)) - (7.5 * menuscale)) + (6.0 * menuscale))), (Int (120.0 * menuscale)), (Int (30.0 * menuscale)), "Refresh", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            For local12 = Each mp_listserver
                                If (local12\Field10 = serverlist\Field4) Then
                                    mp_pingserver(local12\Field0, local12\Field1, $00, $00)
                                    local12\Field16 = $00
                                EndIf
                            Next
                            mp_fillserverlist(serverlist\Field4)
                            local15 = $01
                        EndIf
                        local18 = serverlist\Field4
                        If (local18 <> $02) Then
                            If ((updatemenubutton((Int ((145.0 * menuscale) + local3)), (Int ((((local4 + local6) - (17.0 * menuscale)) - (7.5 * menuscale)) + (6.0 * menuscale))), (Int (120.0 * menuscale)), (Int (30.0 * menuscale)), "Host server", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) And (mp_getdialogindex() = $00)) <> 0) Then
                                If (opt\Field54 <> 0) Then
                                    randomseed = "666"
                                Else
                                    local8 = rand($04, $08)
                                    For local9 = $01 To local8 Step $01
                                        If (rand($03, $01) = $01) Then
                                            randomseed = (randomseed + (Str rand($00, $09)))
                                        Else
                                            randomseed = (randomseed + chr(rand($61, $7A)))
                                        EndIf
                                    Next
                                EndIf
                                loadsavedgames()
                                currsave = (New save)
                                loadcustommaps()
                                currcustommap = (New custommaps)
                                mm\Field5 = $02
                            EndIf
                        Else
                            If ((updatemenubutton((Int ((145.0 * menuscale) + local3)), (Int ((((local4 + local6) - (17.0 * menuscale)) - (7.5 * menuscale)) + (6.0 * menuscale))), (Int (120.0 * menuscale)), (Int (30.0 * menuscale)), "Add server", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) And (mp_getdialogindex() = $00)) <> 0) Then
                                mp_showlocaldialog("Add server", "Enter server IP Address (0.0.0.0:0)", "Add", "Cancel", $02, $02, $01)
                                local15 = $01
                            EndIf
                            If ((updatemenubutton((Int ((275.0 * menuscale) + local3)), (Int ((((local4 + local6) - (17.0 * menuscale)) - (7.5 * menuscale)) + (6.0 * menuscale))), (Int (120.0 * menuscale)), (Int (30.0 * menuscale)), "Host server", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) And (mp_getdialogindex() = $00)) <> 0) Then
                                If (opt\Field54 <> 0) Then
                                    randomseed = "666"
                                Else
                                    local8 = rand($04, $08)
                                    For local9 = $01 To local8 Step $01
                                        If (rand($03, $01) = $01) Then
                                            randomseed = (randomseed + (Str rand($00, $09)))
                                        Else
                                            randomseed = (randomseed + chr(rand($61, $7A)))
                                        EndIf
                                    Next
                                EndIf
                                loadsavedgames()
                                currsave = (New save)
                                loadcustommaps()
                                currcustommap = (New custommaps)
                                mm\Field5 = $02
                            EndIf
                        EndIf
                        If (mp_latestcloseddialog() = $02) Then
                            If (mp_latestdialogresult() = $01) Then
                                local19 = trim(splitstring(mp_latestdialoginput(), ":", $00))
                                local20 = (Int trim(splitstring(mp_latestdialoginput(), ":", $01)))
                                local21 = mp_addlistserver(local19, local20, $02)
                                If (local21 <> Null) Then
                                    local21\Field16 = $01
                                    mp_fillserverlist(serverlist\Field4)
                                EndIf
                            EndIf
                            mp_resetdialogstates()
                        EndIf
                        local4 = ((50.0 * menuscale) + local4)
                        local22 = ((30.0 * menuscale) - (4.0 * menuscale))
                        local23 = 0.0
                        local24 = (local6 - (73.0 * menuscale))
                        local25 = 1.0
                        local26 = $00
                        For local8 = $00 To $3E7 Step $01
                            If (listservers[local8] = Null) Then
                                Exit
                            EndIf
                            local26 = (local26 + $01)
                            local23 = (local23 + local22)
                        Next
                        local25 = min((local24 / local23), 1.0)
                        local27 = local4
                        local28 = (((local24 / local22) * local22) + local4)
                        serverlist\Field8 = (serverlist\Field8 + ((Float (- mousezspeed())) * local22))
                        If (mouseon((Int ((local17 - (8.0 * menuscale)) + (3.0 * menuscale))), (Int (((serverlist\Field8 * local25) + local4) - (6.0 * menuscale))), (Int (((local5 * 0.0215) + (8.0 * menuscale)) - (6.0 * menuscale))), (Int (local24 * local25))) <> 0) Then
                            If ((mo\Field2 And (serverlist\Field9 = $00)) <> 0) Then
                                serverlist\Field9 = $01
                                serverlist\Field10 = (Int mouseposy)
                                local15 = $01
                            EndIf
                        ElseIf (mouseon((Int ((local17 - (4.0 * menuscale)) + (3.0 * menuscale))), (Int (local4 - (4.0 * menuscale))), (Int (((local5 * 0.0215) + (4.0 * menuscale)) - (6.0 * menuscale))), (Int local24)) <> 0) Then
                            If ((mo\Field0 And (serverlist\Field9 = $00)) <> 0) Then
                                serverlist\Field8 = ((mouseposy - local4) / local25)
                                local15 = $01
                            EndIf
                        EndIf
                        If (mo\Field2 = $00) Then
                            serverlist\Field9 = $00
                        ElseIf (serverlist\Field9 <> 0) Then
                            serverlist\Field8 = (serverlist\Field8 + ((mouseposy - (Float serverlist\Field10)) / local25))
                            serverlist\Field10 = (Int mouseposy)
                            local15 = $01
                        EndIf
                        serverlist\Field8 = clamp(serverlist\Field8, 0.0, max((local23 - local24), 0.0))
                        For local8 = $00 To (local26 - $01) Step $01
                            listservers[local8]\Field12 = ((- serverlist\Field8) + local4)
                            local4 = (local4 + local22)
                        Next
                        For local8 = $00 To (local26 - $01) Step $01
                            local12 = listservers[local8]
                            If ((((local27 - local22) <= local12\Field12) And (local28 >= local12\Field12)) <> 0) Then
                                local29 = mouseon((Int local3), (Int (local12\Field12 - (6.0 * menuscale))), (Int (local5 * 0.977)), (Int (30.0 * menuscale)))
                                local15 = (local15 + (local29 And (local14 = $00)))
                                If ((((mo\Field1 And (local14 = $00)) And (mp_getdialogindex() = $00)) And local29) <> 0) Then
                                    serverlist\Field0 = ((Handle local12) + $01)
                                    serverlist\Field5 = serverlist\Field0
                                    serverlist\Field1 = ((Handle local12) + $01)
                                    serverlist\Field2 = (Int mouseposx)
                                    serverlist\Field3 = (Int mouseposy)
                                EndIf
                                If ((((((local29 And mo\Field3) And (local14 = $00)) And (serverlist\Field1 = $00)) And (mp_getdialogindex() = $00)) And (serverlist\Field5 = ((Handle local12) + $01))) <> 0) Then
                                    mp_showlocaldialog("Connect", (("Connecting to " + local12\Field2) + "..."), "Cancel", "", $00, $03, $01)
                                    mp_pingserver(local12\Field0, local12\Field1, $01, $00)
                                    mp_waitingforping($BB8)
                                    mo\Field0 = $00
                                EndIf
                                If ((((updatemenubutton((Int local3), (Int (local12\Field12 - (6.0 * menuscale))), (Int (local5 * 0.977)), (Int (30.0 * menuscale)), "", $00, $00, (serverlist\Field0 = ((Handle local12) + $01)), $FF, $FF, $FF, $00, 1.0, $01, $00) And (local14 = $00)) And (serverlist\Field1 = $00)) And (mp_getdialogindex() = $00)) <> 0) Then
                                    serverlist\Field0 = ((Handle local12) + $01)
                                    serverlist\Field5 = serverlist\Field0
                                EndIf
                                local12\Field13 = findmenubutton((Int local3), (Int (local12\Field12 - (6.0 * menuscale))), (Int (local5 * 0.977)), (Int (30.0 * menuscale)))
                                local30 = local3
                                local30 = ((local5 * 0.0215) + local30)
                                updatemenutextbox((Int (local30 - (4.0 * menuscale))), (Int (local12\Field12 - (6.0 * menuscale))), (Int ((local5 * 0.5457) + (4.0 * menuscale))), (Int (30.0 * menuscale)), local12\Field2, $00, 0.05)
                                local30 = ((local5 * 0.5457) + local30)
                                updatemenutextbox((Int (local30 - (4.0 * menuscale))), (Int (local12\Field12 - (6.0 * menuscale))), (Int ((local5 * 0.18) + (4.0 * menuscale))), (Int (30.0 * menuscale)), local12\Field3, $00, 0.15)
                                local30 = ((local5 * 0.18) + local30)
                                updatemenutextbox((Int (local30 - (4.0 * menuscale))), (Int (local12\Field12 - (6.0 * menuscale))), (Int ((local5 * 0.13) + (4.0 * menuscale))), (Int (30.0 * menuscale)), (((Str local12\Field4) + " / ") + (Str local12\Field5)), $00, 0.15)
                                local30 = ((local5 * 0.13) + local30)
                                updatemenutextbox((Int (local30 - (4.0 * menuscale))), (Int (local12\Field12 - (6.0 * menuscale))), (Int ((local5 * 0.1013) + (4.0 * menuscale))), (Int (30.0 * menuscale)), (Str local12\Field6), $00, 0.15)
                                If (((serverlist\Field0 = ((Handle local12) + $01)) And (mp_gettimer() > local12\Field15)) <> 0) Then
                                    mp_pingserver(local12\Field0, local12\Field1, $00, $00)
                                    local12\Field15 = (mp_gettimer() + $5DC)
                                EndIf
                            EndIf
                        Next
                        If (serverlist\Field1 <> $00) Then
                            local31 = (Object.mp_listserver (serverlist\Field1 - $01))
                            local32 = mouseon(serverlist\Field2, serverlist\Field3, (Int (160.0 * menuscale)), (Int (88.0 * menuscale)))
                            local33 = $00
                            If (updatemenubutton(serverlist\Field2, serverlist\Field3, (Int (160.0 * menuscale)), (Int (25.0 * menuscale)), "Connect", $00, $01, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                mp_showlocaldialog("Connect", (("Connecting to " + local31\Field2) + "..."), "Cancel", "", $00, $03, $01)
                                mp_pingserver(local31\Field0, local31\Field1, $01, $00)
                                local33 = $01
                            EndIf
                            If (updatemenubutton(serverlist\Field2, (Int (((Float serverlist\Field3) + (25.0 * menuscale)) - (3.0 * menuscale))), (Int (160.0 * menuscale)), (Int (25.0 * menuscale)), "Open info", $00, $01, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                mp_showlocaldialog("Information", (((((((((((((((((("Server name: " + local31\Field2) + "\nGamemode: ") + local31\Field3) + "\nPlayers:  ") + (Str local31\Field4)) + " / ") + (Str local31\Field5)) + "\nDifficulty: ") + difficulties[local31\Field7]\Field0) + "\nRandom seed: ") + local31\Field8) + "\nIntro: ") + getbool(local31\Field9)) + "\nVoice bitrate: ") + mp_voicegetbitrate(local31\Field11)) + "\nPing: ") + (Str local31\Field6)) + "\n"), "Close", "", $00, $01, $00)
                                mp_pingserver(local31\Field0, local31\Field1, $00, $01)
                                local33 = $01
                            EndIf
                            If (updatemenubutton(serverlist\Field2, (Int (((Float serverlist\Field3) + (50.0 * menuscale)) - (6.0 * menuscale))), (Int (160.0 * menuscale)), (Int (25.0 * menuscale)), "Update", $00, $01, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                mp_pingserver(local31\Field0, local31\Field1, $00, $00)
                                local33 = $01
                            EndIf
                            Select serverlist\Field4
                                Case $00
                                    If (updatemenubutton(serverlist\Field2, (Int (((Float serverlist\Field3) + (75.0 * menuscale)) - (9.0 * menuscale))), (Int (160.0 * menuscale)), (Int (25.0 * menuscale)), "Add to favourites", $00, $01, (mp_getserverfromcategory(local31\Field0, local31\Field1, $02) <> Null), $FF, $FF, $FF, $00, 1.0, $00, $00) <> 0) Then
                                        mp_addlistserver(local31\Field0, local31\Field1, $02)
                                        local33 = $01
                                    EndIf
                                Case $02,$01
                                    If (updatemenubutton(serverlist\Field2, (Int (((Float serverlist\Field3) + (75.0 * menuscale)) - (9.0 * menuscale))), (Int (160.0 * menuscale)), (Int (25.0 * menuscale)), "Delete", $00, $01, $00, $FF, $FF, $FF, $00, 1.0, $00, $00) <> 0) Then
                                        mp_removelistserver(local31)
                                        local33 = $01
                                        local15 = $01
                                    EndIf
                            End Select
                            If (((mo\Field0 And (local32 = $00)) Lor local33) <> 0) Then
                                serverlist\Field1 = $00
                            EndIf
                            If (local32 <> 0) Then
                                local15 = $01
                            EndIf
                        EndIf
                        If ((mo\Field0 And (local15 = $00)) <> 0) Then
                            serverlist\Field0 = $00
                        EndIf
                        shoulddeletegadgets = $01
                    Case $02
                        local6 = (400.0 * menuscale)
                        selectedcustommap = Null
                        ue_server\Field4 = updatemenuinputbox((Int ((150.0 * menuscale) + local3)), (Int ((15.0 * menuscale) + local4)), (Int (300.0 * menuscale)), (Int (30.0 * menuscale)), ue_server\Field4, $00, $01, $20, 1.0)
                        randomseed = updatemenuinputbox((Int ((150.0 * menuscale) + local3)), (Int ((55.0 * menuscale) + local4)), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), randomseed, $00, $02, $0F, 1.0)
                        menuport = updatemenuinputbox((Int ((150.0 * menuscale) + local3)), (Int ((95.0 * menuscale) + local4)), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), menuport, $00, $04, $291, 1.0)
                        ue_server\Field11 = updatemenutick((Int ((150.0 * menuscale) + local3)), (Int ((135.0 * menuscale) + local4)), ue_server\Field11, $00)
                        For local8 = $00 To $04 Step $01
                            local35 = selecteddifficulty
                            If (updatemenutick((Int ((20.0 * menuscale) + local3)), (Int (((Float (($1E * local8) + $DC)) * menuscale) + local4)), (selecteddifficulty = difficulties[local8]), $00) <> 0) Then
                                selecteddifficulty = difficulties[local8]
                            EndIf
                            If (local35 <> selecteddifficulty) Then
                                shoulddeletegadgets = (local35 = difficulties[$04])
                            EndIf
                        Next
                        If (selecteddifficulty\Field5 <> 0) Then
                            If (updatemenubutton((Int ((160.0 * menuscale) + local3)), (Int ((220.0 * menuscale) + local4)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), ">", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                If (selecteddifficulty\Field3 < $03) Then
                                    selecteddifficulty\Field3 = (selecteddifficulty\Field3 + $01)
                                Else
                                    selecteddifficulty\Field3 = $00
                                EndIf
                            EndIf
                            selecteddifficulty\Field2 = updatemenutick((Int ((160.0 * menuscale) + local3)), (Int ((252.5 * menuscale) + local4)), selecteddifficulty\Field2, $00)
                            If (updatemenubutton((Int ((160.0 * menuscale) + local3)), (Int ((285.0 * menuscale) + local4)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), "<", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                selecteddifficulty\Field9 = (selecteddifficulty\Field9 - $02)
                                If (selecteddifficulty\Field9 <= $00) Then
                                    selecteddifficulty\Field9 = $0A
                                EndIf
                            ElseIf (updatemenubutton((Int ((405.0 * menuscale) + local3)), (Int ((285.0 * menuscale) + local4)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), ">", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                selecteddifficulty\Field9 = (selecteddifficulty\Field9 + $02)
                                If (selecteddifficulty\Field9 > $0A) Then
                                    selecteddifficulty\Field9 = $02
                                EndIf
                            EndIf
                            If (updatemenubutton((Int ((160.0 * menuscale) + local3)), (Int ((332.5 * menuscale) + local4)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), ">", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                If (selecteddifficulty\Field4 < $03) Then
                                    selecteddifficulty\Field4 = (selecteddifficulty\Field4 + $01)
                                Else
                                    selecteddifficulty\Field4 = $00
                                EndIf
                            EndIf
                        EndIf
                        If (updatemenubutton((Int ((420.0 * menuscale) + local3)), (Int ((local4 + local6) + (20.0 * menuscale))), (Int (160.0 * menuscale)), (Int (75.0 * menuscale)), getlocalstring("mpmenu", "host"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            If (initializeserver((Int menuport)) <> 0) Then
                                opt\Field53 = $00
                                currsave\Field0 = ""
                                If (randomseed = "") Then
                                    randomseed = (Str millisecs())
                                EndIf
                                seedrnd(generateseednumber(randomseed))
                                local36 = $00
                                local37 = $02
                                initnewgame()
                                iniwritestring(optionfile, "Global", "Enable Intro", (Str opt\Field53), $01)
                                shoulddeletegadgets = $01
                                mainmenuopen = $00
                                Return $00
                            EndIf
                        EndIf
                    Case $03
                        local6 = (345.0 * menuscale)
                        currsave\Field0 = updatemenuinputbox((Int ((150.0 * menuscale) + local3)), (Int ((15.0 * menuscale) + local4)), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), currsave\Field0, $00, $01, $0F, 1.0)
                        If (selectedinputbox = $01) Then
                            currsave\Field0 = replace(currsave\Field0, ":", "")
                            currsave\Field0 = replace(currsave\Field0, ".", "")
                            currsave\Field0 = replace(currsave\Field0, "/", "")
                            currsave\Field0 = replace(currsave\Field0, "\", "")
                            currsave\Field0 = replace(currsave\Field0, "<", "")
                            currsave\Field0 = replace(currsave\Field0, ">", "")
                            currsave\Field0 = replace(currsave\Field0, "|", "")
                            currsave\Field0 = replace(currsave\Field0, "?", "")
                            currsave\Field0 = replace(currsave\Field0, chr($22), "")
                            currsave\Field0 = replace(currsave\Field0, "*", "")
                            cursorpos = (Int min((Float cursorpos), (Float len(currsave\Field0))))
                        EndIf
                        If (selectedcustommap = Null) Then
                            randomseed = updatemenuinputbox((Int ((150.0 * menuscale) + local3)), (Int ((55.0 * menuscale) + local4)), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), randomseed, $00, $02, $0F, 1.0)
                        ElseIf (updatemenubutton((Int ((370.0 * menuscale) + local3)), (Int ((55.0 * menuscale) + local4)), (Int (120.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "deselect"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            shoulddeletegadgets = $01
                            selectedcustommap = Null
                        EndIf
                        opt\Field53 = updatemenutick((Int ((280.0 * menuscale) + local3)), (Int ((110.0 * menuscale) + local4)), opt\Field53, $00)
                        For local8 = $00 To $04 Step $01
                            local35 = selecteddifficulty
                            If (updatemenutick((Int ((20.0 * menuscale) + local3)), (Int (((Float (($1E * local8) + $B4)) * menuscale) + local4)), (selecteddifficulty = difficulties[local8]), $00) <> 0) Then
                                selecteddifficulty = difficulties[local8]
                            EndIf
                            If (local35 <> selecteddifficulty) Then
                                shoulddeletegadgets = (local35 = difficulties[$04])
                            EndIf
                        Next
                        If (selecteddifficulty\Field5 <> 0) Then
                            If (updatemenubutton((Int ((160.0 * menuscale) + local3)), (Int ((180.0 * menuscale) + local4)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), ">", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                If (selecteddifficulty\Field3 < $03) Then
                                    selecteddifficulty\Field3 = (selecteddifficulty\Field3 + $01)
                                Else
                                    selecteddifficulty\Field3 = $00
                                EndIf
                            EndIf
                            selecteddifficulty\Field2 = updatemenutick((Int ((160.0 * menuscale) + local3)), (Int ((210.0 * menuscale) + local4)), selecteddifficulty\Field2, $00)
                            If (updatemenubutton((Int ((160.0 * menuscale) + local3)), (Int ((240.0 * menuscale) + local4)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), "<", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                selecteddifficulty\Field9 = (selecteddifficulty\Field9 - $02)
                                If (selecteddifficulty\Field9 <= $00) Then
                                    selecteddifficulty\Field9 = $0A
                                EndIf
                            ElseIf (updatemenubutton((Int ((405.0 * menuscale) + local3)), (Int ((240.0 * menuscale) + local4)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), ">", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                selecteddifficulty\Field9 = (selecteddifficulty\Field9 + $02)
                                If (selecteddifficulty\Field9 > $0A) Then
                                    selecteddifficulty\Field9 = $02
                                EndIf
                            EndIf
                            If (updatemenubutton((Int ((160.0 * menuscale) + local3)), (Int ((270.0 * menuscale) + local4)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), ">", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                If (selecteddifficulty\Field4 < $03) Then
                                    selecteddifficulty\Field4 = (selecteddifficulty\Field4 + $01)
                                Else
                                    selecteddifficulty\Field4 = $00
                                EndIf
                            EndIf
                        EndIf
                        If (updatemenubutton((Int local3), (Int ((local4 + local6) + (20.0 * menuscale))), (Int (160.0 * menuscale)), (Int (75.0 * menuscale)), getlocalstring("menu", "loadmap"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            loadcustommaps()
                            mm\Field5 = $05
                        EndIf
                        If (updatemenubutton((Int ((420.0 * menuscale) + local3)), (Int ((local4 + local6) + (20.0 * menuscale))), (Int (160.0 * menuscale)), (Int (75.0 * menuscale)), getlocalstring("menu", "start"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            If (currsave\Field0 = "") Then
                                currsave\Field0 = converttoansi(getlocalstring("save", "untitled"))
                            EndIf
                            currsave\Field0 = trim(currsave\Field0)
                            randomseed = trim(randomseed)
                            If (randomseed = "") Then
                                randomseed = (Str millisecs())
                            EndIf
                            seedrnd(generateseednumber(randomseed))
                            local36 = $00
                            local37 = $02
                            For local0 = Each save
                                If (((currsave <> local0) And (currsave\Field0 = local0\Field0)) <> 0) Then
                                    local36 = $01
                                    Exit
                                EndIf
                            Next
                            While (local36 = $01)
                                local36 = $02
                                For local0 = Each save
                                    If (local0\Field0 = (((currsave\Field0 + " (") + (Str local37)) + ")")) Then
                                        local37 = (local37 + $01)
                                        local36 = $01
                                        Exit
                                    EndIf
                                Next
                            Wend
                            If (local36 = $02) Then
                                currsave\Field0 = (((currsave\Field0 + " (") + (Str local37)) + ")")
                            EndIf
                            initnewgame()
                            iniwritestring(optionfile, "Global", "Enable Intro", (Str opt\Field53), $01)
                            shoulddeletegadgets = $01
                            mainmenuopen = $00
                            Return $00
                        EndIf
                    Case $04
                        local6 = (296.0 * menuscale)
                        If ((((ceil(((Float savedgamesamount) / 5.0)) - 1.0) > (Float mm\Field7)) And (delsave = Null)) <> 0) Then
                            If (updatemenubutton((Int ((local3 + local5) - (50.0 * menuscale))), (Int ((440.0 * menuscale) + local4)), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), ">", $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                changepage((mm\Field7 + $01))
                            EndIf
                        Else
                            updatemenubutton((Int ((local3 + local5) - (50.0 * menuscale))), (Int ((440.0 * menuscale) + local4)), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), ">", $01, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                        EndIf
                        If (((mm\Field7 > $00) And (delsave = Null)) <> 0) Then
                            If (updatemenubutton((Int local3), (Int ((440.0 * menuscale) + local4)), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), "<", $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                changepage((mm\Field7 - $01))
                            EndIf
                        Else
                            updatemenubutton((Int local3), (Int ((440.0 * menuscale) + local4)), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), "<", $01, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                        EndIf
                        If ((ceil(((Float savedgamesamount) / 5.0)) - 1.0) < (Float mm\Field7)) Then
                            changepage((mm\Field7 - $01))
                        EndIf
                        If (savedgamesamount > $00) Then
                            local3 = ((20.0 * menuscale) + local3)
                            local4 = ((20.0 * menuscale) + local4)
                            currsave = (First save)
                            For local8 = $00 To ((mm\Field7 * $05) + $04) Step $01
                                If (local8 > $00) Then
                                    currsave = (After currsave)
                                EndIf
                                If (currsave = Null) Then
                                    Exit
                                EndIf
                                If (local8 >= (mm\Field7 * $05)) Then
                                    If (delsave = Null) Then
                                        If (currsave\Field3 <> "1.5") Then
                                            updatemenubutton((Int ((300.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "btnload"), $00, $00, $01, $FF, $00, $00, $01, 1.0, $00, $00)
                                        ElseIf (updatemenubutton((Int ((300.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "btnload"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                            loadentities()
                                            loadsounds()
                                            loadgame(currsave\Field0)
                                            initloadgame()
                                            shoulddeletegadgets = $01
                                            mainmenuopen = $00
                                            Return $00
                                        EndIf
                                        If (updatemenubutton((Int ((420.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "delete"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                            delsave = currsave
                                            Exit
                                        EndIf
                                    Else
                                        If (currsave\Field3 <> "1.5") Then
                                            updatemenubutton((Int ((300.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "btnload"), $00, $00, $01, $FF, $00, $00, $01, 1.0, $00, $00)
                                        Else
                                            updatemenubutton((Int ((300.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "btnload"), $00, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                                        EndIf
                                        updatemenubutton((Int ((420.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "delete"), $00, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                                    EndIf
                                    If (currsave = (Last save)) Then
                                        Exit
                                    EndIf
                                    local4 = ((80.0 * menuscale) + local4)
                                EndIf
                            Next
                            If (delsave <> Null) Then
                                local3 = (739.0 * menuscale)
                                local4 = (376.0 * menuscale)
                                If (updatemenubutton((Int ((74.0 * menuscale) + local3)), (Int ((150.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "yes"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                    deletegame(delsave)
                                    shoulddeletegadgets = $01
                                EndIf
                                If (updatemenubutton((Int ((246.0 * menuscale) + local3)), (Int ((150.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "no"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                    delsave = Null
                                    shoulddeletegadgets = $01
                                EndIf
                            EndIf
                        EndIf
                    Case $05
                        local6 = (350.0 * menuscale)
                        If ((((ceil(((Float custommapsamount) / 5.0)) - 1.0) > (Float mm\Field7)) And (delcustommap = Null)) <> 0) Then
                            If (updatemenubutton((Int ((local3 + local5) - (50.0 * menuscale))), (Int ((440.0 * menuscale) + local4)), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), ">", $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                changepage((mm\Field7 + $01))
                            EndIf
                        Else
                            updatemenubutton((Int ((local3 + local5) - (50.0 * menuscale))), (Int ((440.0 * menuscale) + local4)), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), ">", $01, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                        EndIf
                        If (((mm\Field7 > $00) And (delcustommap = Null)) <> 0) Then
                            If (updatemenubutton((Int local3), (Int ((440.0 * menuscale) + local4)), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), "<", $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                changepage((mm\Field7 - $01))
                            EndIf
                        Else
                            updatemenubutton((Int local3), (Int ((440.0 * menuscale) + local4)), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), "<", $01, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                        EndIf
                        If ((ceil(((Float custommapsamount) / 5.0)) - 1.0) < (Float mm\Field7)) Then
                            changepage((mm\Field7 - $01))
                        EndIf
                        If (custommapsamount > $00) Then
                            local3 = ((20.0 * menuscale) + local3)
                            local4 = ((20.0 * menuscale) + local4)
                            currcustommap = (First custommaps)
                            For local8 = $00 To ((mm\Field7 * $05) + $04) Step $01
                                If (local8 > $00) Then
                                    currcustommap = (After currcustommap)
                                EndIf
                                If (currcustommap = Null) Then
                                    Exit
                                EndIf
                                If (local8 >= (mm\Field7 * $05)) Then
                                    If (delcustommap = Null) Then
                                        If (updatemenubutton((Int ((300.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "btnload"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                            selectedcustommap = currcustommap
                                            mm\Field5 = $03
                                            shoulddeletegadgets = $01
                                        EndIf
                                        If (updatemenubutton((Int ((420.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "delete"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                            delcustommap = currcustommap
                                            Exit
                                        EndIf
                                    Else
                                        updatemenubutton((Int ((300.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "btnload"), $00, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                                        updatemenubutton((Int ((420.0 * menuscale) + local3)), (Int ((20.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "delete"), $00, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                                    EndIf
                                    If (currcustommap = (Last custommaps)) Then
                                        Exit
                                    EndIf
                                    local4 = ((80.0 * menuscale) + local4)
                                EndIf
                            Next
                            If (delcustommap <> Null) Then
                                local3 = (739.0 * menuscale)
                                local4 = (376.0 * menuscale)
                                If (updatemenubutton((Int ((74.0 * menuscale) + local3)), (Int ((150.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "yes"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                    deletecustommap(delcustommap)
                                    shoulddeletegadgets = $01
                                EndIf
                                If (updatemenubutton((Int ((246.0 * menuscale) + local3)), (Int ((150.0 * menuscale) + local4)), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("menu", "no"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                    delcustommap = Null
                                    shoulddeletegadgets = $01
                                EndIf
                            EndIf
                        EndIf
                    Case $06
                        local6 = (60.0 * menuscale)
                        If (updatemenubutton((Int ((20.0 * menuscale) + local3)), (Int ((15.0 * menuscale) + local4)), (Int ((local5 / 5.0) + (420.0 * menuscale))), (Int local6), getlocalstring("options", "grap"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            changeoptiontab($07, $01)
                        EndIf
                        If (updatemenubutton((Int ((20.0 * menuscale) + local3)), (Int ((85.0 * menuscale) + local4)), (Int ((local5 / 5.0) + (420.0 * menuscale))), (Int local6), getlocalstring("options", "audio"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            changeoptiontab($08, $01)
                        EndIf
                        If (updatemenubutton((Int ((20.0 * menuscale) + local3)), (Int ((155.0 * menuscale) + local4)), (Int ((local5 / 5.0) + (420.0 * menuscale))), (Int local6), getlocalstring("options", "ctrl"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            changeoptiontab($09, $01)
                        EndIf
                        If (updatemenubutton((Int ((20.0 * menuscale) + local3)), (Int ((225.0 * menuscale) + local4)), (Int ((local5 / 5.0) + (420.0 * menuscale))), (Int local6), getlocalstring("options", "avc"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            changeoptiontab($0A, $01)
                        EndIf
                        If (updatemenubutton((Int ((20.0 * menuscale) + local3)), (Int ((295.0 * menuscale) + local4)), (Int ((local5 / 5.0) + (420.0 * menuscale))), (Int local6), getlocalstring("mpmenu", "opt"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            changeoptiontab($0B, $01)
                        EndIf
                End Select
            Else
                local3 = (469.0 * menuscale)
                local6 = (60.0 * menuscale)
                Select mm\Field5
                    Case $07
                        local4 = ((20.0 * menuscale) + local4)
                        opt\Field2 = updatemenutick((Int local3), (Int local4), opt\Field2, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field5 = updatemenutick((Int local3), (Int local4), opt\Field5, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field1 = updatemenutick((Int local3), (Int local4), opt\Field1, (opt\Field51 <> $00))
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field4 = updatemenutick((Int local3), (Int local4), opt\Field4, $00)
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field6 = (updatemenuslidebar((Int local3), (Int local4), (Int (150.0 * menuscale)), (opt\Field6 * 50.0), $01) / 50.0)
                        local4 = ((45.0 * menuscale) + local4)
                        opt\Field0 = updatemenuslider3((Int local3), (Int local4), (Int (150.0 * menuscale)), opt\Field0, $02, getlocalstring("options", "min"), getlocalstring("options", "red"), getlocalstring("options", "full"))
                        local4 = ((45.0 * menuscale) + local4)
                        opt\Field8 = updatemenuslider5((Int local3), (Int local4), (Int (150.0 * menuscale)), opt\Field8, $03, "0.8", "0.4", "0.0", "-0.4", "-0.8")
                        Select opt\Field8
                            Case $00
                                opt\Field9 = 0.8
                            Case $01
                                opt\Field9 = 0.4
                            Case $02
                                opt\Field9 = 0.0
                            Case $03
                                opt\Field9 = -0.4
                            Case $04
                                opt\Field9 = -0.8
                        End Select
                        texturelodbias(opt\Field9)
                        local4 = ((35.0 * menuscale) + local4)
                        opt\Field3 = updatemenutick((Int local3), (Int local4), opt\Field3, $00)
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field11 = (updatemenuslidebar((Int local3), (Int local4), (Int (150.0 * menuscale)), (opt\Field11 * 2.0), $04) / 2.0)
                        opt\Field10 = (opt\Field11 + 40.0)
                        local4 = ((45.0 * menuscale) + local4)
                        opt\Field12 = updatemenuslider5((Int local3), (Int local4), (Int (150.0 * menuscale)), opt\Field12, $05, getlocalstring("options", "tri"), "2x", "4x", "8x", "16x")
                        Select opt\Field12
                            Case $00
                                opt\Field13 = $00
                            Case $01
                                opt\Field13 = $02
                            Case $02
                                opt\Field13 = $04
                            Case $03
                                opt\Field13 = $08
                            Case $04
                                opt\Field13 = $10
                        End Select
                        textureanisotropic(opt\Field13)
                        local4 = ((45.0 * menuscale) + local4)
                        opt\Field14 = updatemenuslider5((Int local3), (Int local4), (Int (150.0 * menuscale)), opt\Field14, $11, "24.0", "18.0", "12.0", "6.0", "0.0")
                        Select opt\Field14
                            Case $00
                                opt\Field15 = 24.0
                            Case $01
                                opt\Field15 = 18.0
                            Case $02
                                opt\Field15 = 12.0
                            Case $03
                                opt\Field15 = 6.0
                            Case $04
                                opt\Field15 = 0.0
                        End Select
                    Case $08
                        local3 = (469.0 * menuscale)
                        local4 = (376.0 * menuscale)
                        local5 = (580.0 * menuscale)
                        local6 = (60.0 * menuscale)
                        local4 = ((20.0 * menuscale) + local4)
                        opt\Field17 = (updatemenuslidebar((Int local3), (Int local4), (Int (150.0 * menuscale)), (opt\Field16 * 100.0), $01) / 100.0)
                        opt\Field16 = opt\Field17
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field18 = (updatemenuslidebar((Int local3), (Int local4), (Int (150.0 * menuscale)), (opt\Field18 * 100.0), $02) / 100.0)
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field20 = (updatemenuslidebar((Int local3), (Int local4), (Int (150.0 * menuscale)), (opt\Field20 * 100.0), $03) / 100.0)
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field21 = (updatemenuslidebar((Int local3), (Int local4), (Int (150.0 * menuscale)), (opt\Field21 * 100.0), $12) / 100.0)
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field22 = updatemenutick((Int local3), (Int local4), opt\Field22, $00)
                        If (opt\Field23 <> opt\Field22) Then
                            If (opt\Field22 <> 0) Then
                                For local2 = Each sound
                                    For local8 = $00 To $0F Step $01
                                        stopchannel(local2\Field2[local8])
                                        local2\Field2[local8] = $00
                                    Next
                                    If (local2\Field0 <> $00) Then
                                        freesound(local2\Field0)
                                        local2\Field0 = $00
                                    EndIf
                                    local2\Field3 = $00
                                Next
                            Else
                                For local2 = Each sound
                                    If (local2\Field0 = $00) Then
                                        local2\Field0 = loadsound(local2\Field1)
                                    EndIf
                                Next
                            EndIf
                            opt\Field23 = opt\Field22
                        EndIf
                        local4 = ((30.0 * menuscale) + local4)
                        local42 = opt\Field24
                        If (updatemenubutton((Int local3), (Int local4), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), ">", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            If (opt\Field24 < $02) Then
                                opt\Field24 = (opt\Field24 + $01)
                            Else
                                opt\Field24 = $00
                            EndIf
                        EndIf
                        If (opt\Field24 > $00) Then
                            If (updatemenubutton((Int (local3 - (290.0 * menuscale))), (Int ((30.0 * menuscale) + local4)), (Int (220.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("options", "scantracks"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                usertrackcheck = $00
                                usertrackcheck2 = $00
                                local43 = "SFX\Radio\UserTracks\"
                                If (filetype(local43) <> $02) Then
                                    createdir(local43)
                                EndIf
                                local44 = readdir(local43)
                                Repeat
                                    local10 = nextfile(local44)
                                    If (local10 = "") Then
                                        Exit
                                    EndIf
                                    If (filetype((local43 + local10)) = $01) Then
                                        usertrackcheck = (usertrackcheck + $01)
                                        local11 = loadsound((local43 + local10))
                                        If (local11 <> $00) Then
                                            usertrackcheck2 = (usertrackcheck2 + $01)
                                        EndIf
                                        freesound(local11)
                                        local11 = $00
                                    EndIf
                                Forever
                                closedir(local44)
                            EndIf
                            local4 = ((40.0 * menuscale) + local4)
                        EndIf
                        local4 = ((30.0 * menuscale) + local4)
                        local45 = opt\Field25
                        local46 = opt\Field26
                        opt\Field25 = updatemenutick((Int local3), (Int local4), opt\Field25, $00)
                        If (opt\Field25 <> 0) Then
                            local4 = ((30.0 * menuscale) + local4)
                            opt\Field26 = updatemenutick((Int local3), (Int local4), opt\Field26, $00)
                        EndIf
                        If ((opt\Field25 And opt\Field26) <> 0) Then
                            local4 = ((35.0 * menuscale) + local4)
                            updatemenupalette((Int (local3 - (63.0 * menuscale))), (Int local4))
                            local4 = ((30.0 * menuscale) + local4)
                            opt\Field27 = (Int min((Float updatemenuinputbox((Int (local3 - (135.0 * menuscale))), (Int local4), (Int (40.0 * menuscale)), (Int (20.0 * menuscale)), (Str opt\Field27), $00, $10, $03, 1.0)), 255.0))
                            local4 = ((30.0 * menuscale) + local4)
                            opt\Field28 = (Int min((Float updatemenuinputbox((Int (local3 - (135.0 * menuscale))), (Int local4), (Int (40.0 * menuscale)), (Int (20.0 * menuscale)), (Str opt\Field28), $00, $11, $03, 1.0)), 255.0))
                            local4 = ((30.0 * menuscale) + local4)
                            opt\Field29 = (Int min((Float updatemenuinputbox((Int (local3 - (135.0 * menuscale))), (Int local4), (Int (40.0 * menuscale)), (Int (20.0 * menuscale)), (Str opt\Field29), $00, $12, $03, 1.0)), 255.0))
                            local4 = ((40.0 * menuscale) + local4)
                        EndIf
                        If (((local45 Lor local46) Lor (local42 <> $01)) <> 0) Then
                            shoulddeletegadgets = (((local45 <> opt\Field25) Lor (local46 <> opt\Field26)) Lor (local42 <> opt\Field24))
                        EndIf
                    Case $09
                        local4 = ((20.0 * menuscale) + local4)
                        opt\Field45 = ((updatemenuslidebar((Int local3), (Int local4), (Int (150.0 * menuscale)), ((opt\Field45 + 0.5) * 100.0), $01) / 100.0) - 0.5)
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field42 = (updatemenuslidebar((Int local3), (Int local4), (Int (150.0 * menuscale)), (opt\Field42 * 50.0), $02) / 50.0)
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field43 = updatemenutick((Int local3), (Int local4), opt\Field43, $00)
                        local4 = ((40.0 * menuscale) + local4)
                        opt\Field44 = updatemenutick((Int local3), (Int local4), opt\Field44, $00)
                        local4 = ((60.0 * menuscale) + local4)
                        updatemenuinputbox((Int (local3 - (150.0 * menuscale))), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field3), 210.0))], $00, $03, $00, 1.0)
                        updatemenuinputbox((Int ((140.0 * menuscale) + local3)), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field10), 210.0))], $00, $08, $00, 1.0)
                        local4 = ((20.0 * menuscale) + local4)
                        updatemenuinputbox((Int (local3 - (150.0 * menuscale))), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field1), 210.0))], $00, $04, $00, 1.0)
                        updatemenuinputbox((Int ((140.0 * menuscale) + local3)), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field8), 210.0))], $00, $09, $00, 1.0)
                        local4 = ((20.0 * menuscale) + local4)
                        updatemenuinputbox((Int (local3 - (150.0 * menuscale))), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field4), 210.0))], $00, $05, $00, 1.0)
                        updatemenuinputbox((Int ((140.0 * menuscale) + local3)), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field6), 210.0))], $00, $0A, $00, 1.0)
                        local4 = ((20.0 * menuscale) + local4)
                        updatemenuinputbox((Int (local3 - (150.0 * menuscale))), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field2), 210.0))], $00, $06, $00, 1.0)
                        updatemenuinputbox((Int ((140.0 * menuscale) + local3)), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field9), 210.0))], $00, $0B, $00, 1.0)
                        local4 = ((20.0 * menuscale) + local4)
                        updatemenuinputbox((Int (local3 - (150.0 * menuscale))), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field7), 210.0))], $00, $07, $00, 1.0)
                        updatemenuinputbox((Int ((140.0 * menuscale) + local3)), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field11), 210.0))], $00, $0D, $00, 1.0)
                        local4 = ((20.0 * menuscale) + local4)
                        updatemenuinputbox((Int (local3 - (150.0 * menuscale))), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field12), 210.0))], $00, $0E, $00, 1.0)
                        updatemenuinputbox((Int ((140.0 * menuscale) + local3)), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field13), 210.0))], $00, $0F, $00, 1.0)
                        If (opt\Field31 <> 0) Then
                            local4 = ((20.0 * menuscale) + local4)
                            updatemenuinputbox((Int (local3 - (150.0 * menuscale))), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field5), 210.0))], $00, $0C, $00, 1.0)
                        EndIf
                        local47 = $00
                        For local8 = $00 To $E3 Step $01
                            If (keyhit(local8) <> 0) Then
                                local47 = local8
                                Exit
                            EndIf
                        Next
                        If (local47 <> $00) Then
                            Select selectedinputbox
                                Case $03
                                    key\Field3 = local47
                                Case $04
                                    key\Field1 = local47
                                Case $05
                                    key\Field4 = local47
                                Case $06
                                    key\Field2 = local47
                                Case $07
                                    key\Field7 = local47
                                Case $08
                                    key\Field10 = local47
                                Case $09
                                    key\Field8 = local47
                                Case $0A
                                    key\Field6 = local47
                                Case $0B
                                    key\Field9 = local47
                                Case $0C
                                    key\Field5 = local47
                                Case $0D
                                    key\Field11 = local47
                                Case $0E
                                    key\Field12 = local47
                                Case $0F
                                    key\Field13 = local47
                            End Select
                            selectedinputbox = $00
                        EndIf
                    Case $0A
                        local4 = ((20.0 * menuscale) + local4)
                        opt\Field32 = updatemenutick((Int local3), (Int local4), opt\Field32, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        local49 = opt\Field31
                        opt\Field31 = updatemenutick((Int local3), (Int local4), opt\Field31, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        If (opt\Field31 <> 0) Then
                            opt\Field34 = updatemenutick((Int local3), (Int local4), opt\Field34, $00)
                        EndIf
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field30 = updatemenutick((Int local3), (Int local4), opt\Field30, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field37 = updatemenutick((Int local3), (Int local4), opt\Field37, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field33 = updatemenutick((Int local3), (Int local4), opt\Field33, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        local50 = (0.0 < opt\Field36)
                        If (updatemenutick((Int local3), (Int local4), (0.0 < opt\Field36), $00) <> 0) Then
                            opt\Field36 = (updatemenuslidebar((Int (local3 - (160.0 * menuscale))), (Int ((40.0 * menuscale) + local4)), (Int (150.0 * menuscale)), (opt\Field36 * 99.0), $01) / 99.0)
                            opt\Field36 = max(opt\Field36, 0.01)
                            opt\Field35 = (Int ((opt\Field36 * 100.0) + 19.0))
                            local4 = ((80.0 * menuscale) + local4)
                        Else
                            opt\Field36 = 0.0
                            opt\Field35 = $00
                            local4 = ((30.0 * menuscale) + local4)
                        EndIf
                        If ((local50 Lor local49) <> 0) Then
                            shoulddeletegadgets = (((Float local50) <> opt\Field36) Lor (local49 <> opt\Field31))
                        EndIf
                        opt\Field38 = updatemenutick((Int local3), (Int local4), opt\Field38, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field39 = updatemenutick((Int local3), (Int local4), opt\Field39, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field40 = updatemenutick((Int local3), (Int local4), opt\Field40, $00)
                        local4 = ((30.0 * menuscale) + local4)
                        opt\Field41 = updatemenutick((Int local3), (Int local4), opt\Field41, $00)
                        local4 = ((40.0 * menuscale) + local4)
                        If (updatemenubutton((Int (local3 - (290.0 * menuscale))), (Int local4), (Int (195.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("options", "reset"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            deletefile(optionfile)
                            resetoptionsini()
                            saveoptionsini($01)
                        EndIf
                    Case $0B
                        local4 = ((20.0 * menuscale) + local4)
                        local3 = (local3 - (170.0 * menuscale))
                        opt\Field46 = left(updatemenuinputbox((Int ((20.0 * menuscale) + local3)), (Int (local4 - (5.0 * menuscale))), (Int (300.0 * menuscale)), (Int (30.0 * menuscale)), opt\Field46, $00, $424, $00, 1.0), $1F)
                        local4 = ((35.0 * menuscale) + local4)
                        opt\Field47 = (updatemenuslidebar((Int ((80.0 * menuscale) + local3)), (Int local4), (Int (150.0 * menuscale)), (opt\Field47 * 100.0), $01) / 100.0)
                        local4 = ((35.0 * menuscale) + local4)
                        If (((opt\Field48 = "") And (bass_getrecorddevicecount() > $00)) <> 0) Then
                            opt\Field48 = bass_getrecorddevicename($00)
                        EndIf
                        If (opt\Field48 = "") Then
                            updatemenubutton((Int ((20.0 * menuscale) + local3)), (Int local4), (Int (400.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("mpoptions", "nullvoice"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00)
                        Else
                            local51 = opt\Field48
                            If (len(local51) > $25) Then
                                local51 = left(opt\Field48, $25)
                                local51 = (local51 + "...")
                            EndIf
                            If (updatemenubutton((Int ((20.0 * menuscale) + local3)), (Int local4), (Int (400.0 * menuscale)), (Int (30.0 * menuscale)), local51, $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                local52 = bass_getrecorddevicecount()
                                If (local52 > $00) Then
                                    local53 = $00
                                    For local8 = $00 To (local52 - $01) Step $01
                                        If (bass_getrecorddevicename(local8) = opt\Field48) Then
                                            local53 = local8
                                            Exit
                                        EndIf
                                    Next
                                    local53 = (local53 + $01)
                                    If (local53 >= local52) Then
                                        local53 = $00
                                    EndIf
                                    opt\Field48 = bass_getrecorddevicename(local53)
                                EndIf
                            EndIf
                        EndIf
                        local4 = ((95.0 * menuscale) + local4)
                        updatemenuinputbox((Int local3), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field14), 210.0))], $00, $425, $00, 1.0)
                        local4 = ((20.0 * menuscale) + local4)
                        updatemenuinputbox((Int local3), (Int local4), (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field15), 210.0))], $00, $426, $00, 1.0)
                        local47 = $00
                        For local8 = $00 To $E3 Step $01
                            If (keyhit(local8) <> 0) Then
                                local47 = local8
                                Exit
                            EndIf
                        Next
                        If (local47 <> $00) Then
                            Select selectedinputbox
                                Case $425
                                    key\Field14 = local47
                                Case $426
                                    key\Field15 = local47
                            End Select
                        EndIf
                End Select
            EndIf
            local3 = (159.0 * menuscale)
            local4 = (286.0 * menuscale)
            local5 = (400.0 * menuscale)
            local6 = (70.0 * menuscale)
            If (mm\Field5 = $01) Then
                local5 = (900.0 * menuscale)
            EndIf
            If (mm\Field5 <> $08) Then
                usertrackcheck = $00
                usertrackcheck2 = $00
            EndIf
            If (((delsave = Null) And (delcustommap = Null)) <> 0) Then
                If ((updatemenubutton((Int ((local3 + local5) + (20.0 * menuscale))), (Int local4), (Int (160.0 * menuscale)), (Int local6), getlocalstring("menu", "back"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) Lor ((ismultiplayerhudenabled = $00) And keyhit($01))) <> 0) Then
                    Select mm\Field5
                        Case $01
                            mm\Field5 = $00
                        Case $02
                            mm\Field5 = $01
                        Case $03
                            iniwritestring(optionfile, "Global", "Enable Intro", (Str opt\Field53), $01)
                            For local0 = Each save
                                Delete local0
                            Next
                            For local1 = Each custommaps
                                Delete local1
                            Next
                            mm\Field5 = $00
                        Case $04
                            mm\Field7 = $00
                            For local0 = Each save
                                Delete local0
                            Next
                            mm\Field5 = $00
                        Case $05
                            mm\Field7 = $00
                            For local1 = Each custommaps
                                Delete local1
                            Next
                            mm\Field5 = $03
                        Case $06
                            saveoptionsini($00)
                            usertrackcheck = $00
                            usertrackcheck2 = $00
                            antialias(opt\Field1)
                            texturelodbias(opt\Field9)
                            textureanisotropic(opt\Field13)
                            mm\Field5 = $00
                        Case $0B
                            mm\Field5 = $06
                        Case $07,$08,$09,$0A
                            mm\Field5 = $06
                        Default
                            mm\Field5 = $00
                    End Select
                    resetinput()
                EndIf
            Else
                updatemenubutton((Int ((local3 + local5) + (20.0 * menuscale))), (Int local4), (Int (160.0 * menuscale)), (Int local6), getlocalstring("menu", "back"), $00, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
            EndIf
        EndIf
        mp_updategui($0A)
    Wend
    If (mainmenuopen = $00) Then
        Return $00
    EndIf
    rendermainmenu()
    catcherrors("Uncaught: UpdateMainMenu()")
    Return $00
End Function
