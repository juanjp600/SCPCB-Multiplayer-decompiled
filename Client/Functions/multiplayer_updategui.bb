Function multiplayer_updategui%(arg0%)
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9.players
    Local local10%
    Local local11$
    Local local12%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local25%[8]
    Local local26%
    Local local27%
    Local local28%
    Local local29$
    If (udp_getstream() <> 0) Then
        updatequery()
        If (mainmenuopen = $00) Then
            If (hudenabled <> 0) Then
                If (arg0 <> 0) Then
                    If (networkserver\Field15 <> 0) Then
                        local0 = ((((b_br\Field7 + $3E7) - millisecs()) / $3E8) Mod $3C)
                        local1 = ((((b_br\Field7 + $3E7) - millisecs()) / $EA60) Mod $3C)
                        If (((b_br\Field7 - millisecs()) - b_br\Field6) < $00) Then
                            local2 = (Str local0)
                            If (local0 < $0A) Then
                                local2 = ("0" + (Str local0))
                            EndIf
                            aasetfont(font3)
                            color($FF, $FF, $FF)
                            If (millisecs() < b_br\Field7) Then
                                aatext((graphicwidth - $3C), $14, (((Str local1) + ":") + local2), $00, $00, 1.0)
                            Else
                                aatext((graphicwidth - $3C), $14, "0:00", $00, $00, 1.0)
                            EndIf
                        EndIf
                        If (consoleopen = $00) Then
                            local3 = $136
                            local4 = (graphicheight - $5F)
                            local5 = (Int (252.0 * menuscale))
                            local6 = (Int (20.0 * menuscale))
                            If (myplayer\Field51 <> $00) Then
                                color($FF, $FF, $FF)
                                rect(local3, local4, local5, local6, $00)
                                color($B4, $00, $00)
                                renderprogressbar((Int ((2.0 * menuscale) + (Float local3))), (Int ((2.0 * menuscale) + (Float local4))), (Int ((Float local5) - (4.0 * menuscale))), (Int ((Float local6) - (4.0 * menuscale))), (Float multiplayer_breach_getmaxhp(myplayer\Field51)), (Float (Int myplayer\Field70)))
                                color($FF, $FF, $FF)
                                aasetfont(fontsl)
                                aatext((Int ((1.0 * menuscale) + (Float local3))), (Int ((1.0 * menuscale) + (Float local4))), (Str (Int myplayer\Field70)), $00, $00, 1.0)
                                If ((multiplayer_isascp(myplayer\Field51) Or multiplayer_breach_isa035(myplayer\Field51)) <> 0) Then
                                    local4 = (local4 + $28)
                                    local6 = (Int (10.0 * menuscale))
                                    color($FF, $FF, $FF)
                                    rect(local3, local4, local5, local6, $00)
                                    color($00, $00, $B4)
                                    renderprogressbar((Int ((2.0 * menuscale) + (Float local3))), (Int ((2.0 * menuscale) + (Float local4))), (Int ((Float local5) - (4.0 * menuscale))), (Int ((Float local6) - (4.0 * menuscale))), (Float scp\Field8), (Float (scp\Field1 - millisecs())))
                                    color($FF, $FF, $FF)
                                EndIf
                                settypecolor(myplayer\Field51)
                                aasetfont(font1)
                                aatext((Int ((20.0 * menuscale) + (Float (local3 + local5)))), local4, gettypename(myplayer\Field51), $00, $00, 1.0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (networkserver\Field24 = $01) Then
            For local8 = $01 To networkserver\Field14 Step $01
                If (player[local8] <> Null) Then
                    If (player[local8]\Field45 = $01) Then
                        If ((((mainmenuopen And (networkserver\Field15 = $00)) Or ((player[local8]\Field51 = $00) And (myplayer\Field51 = $00))) Or player[local8]\Field52) <> 0) Then
                            color($FF, $FF, $FF)
                            aasetfont(fontsl)
                            color(player[local8]\Field89, player[local8]\Field90, player[local8]\Field91)
                            disableredirectaccess = $01
                            aatext((Int (40.0 * menuscale)), (Int ((Float ($C8 + local7)) * menuscale)), (((player[local8]\Field24 + "[") + (Str local8)) + "]"), $00, $00, 1.0)
                            disableredirectaccess = $00
                            color($FF, $FF, $FF)
                            aasetfont(font1)
                            drawimage(mpimg\Field1, (Int (25.0 * menuscale)), (Int ((Float ($C8 + local7)) * menuscale)), $00)
                            local7 = (local7 + $1E)
                        EndIf
                    EndIf
                EndIf
            Next
        EndIf
        If (arg0 <> 0) Then
            For local9 = Each players
                If (local9\Field0 <> networkserver\Field28) Then
                    multiplayer_renderplayer2d(local9)
                EndIf
            Next
        EndIf
        If ((((keyhit(key_chat) And (consoleopen = $00)) And (networkserver\Field27 = $00)) And (tab_menu_state < $02)) <> 0) Then
            flushkeys()
            networkserver\Field27 = (networkserver\Field27 = $00)
        EndIf
        draws_render()
        texts_render()
        multiplayer_rendervoice()
        multiplayer_renderchat()
        If (hudenabled <> 0) Then
            If (arg0 <> 0) Then
                If ((((b_br\Field9 > $00) And (1.0 > b_br\Field0)) And (((b_br\Field7 - millisecs()) - b_br\Field6) < $01)) <> 0) Then
                    aasetfont(font1)
                    color($FF, $FF, $FF)
                    aatext(((graphicwidth Sar $01) + $01), (Int (((Float graphicheight) * 0.1) + 1.0)), "You are", $01, $00, (min((Float (b_br\Field9 Sar $01)), 255.0) / 255.0))
                    aatext((graphicwidth Sar $01), (Int ((Float graphicheight) * 0.1)), "You are", $01, $00, (min((Float (b_br\Field9 Sar $01)), 255.0) / 255.0))
                    aasetfont(font2)
                    settypecolor(myplayer\Field51)
                    aatext(((graphicwidth Sar $01) + $01), (Int (((Float graphicheight) * 0.13) + 1.0)), gettypename(myplayer\Field51), $01, $00, (min((Float (b_br\Field9 Sar $01)), 255.0) / 255.0))
                    aatext((graphicwidth Sar $01), (Int ((Float graphicheight) * 0.13)), gettypename(myplayer\Field51), $01, $00, (min((Float (b_br\Field9 Sar $01)), 255.0) / 255.0))
                    color($FF, $FF, $FF)
                    settypetext(((graphicwidth Sar $01) + $0A), (Int ((Float graphicheight) * 0.2)))
                EndIf
                If (((0.0 < b_br\Field0) And (b_br\Field1 <> "NULL")) <> 0) Then
                    color($FF, $FF, $FF)
                    aasetfont(font2)
                    aatext((graphicwidth Sar $01), (Int ((Float graphicheight) * 0.08)), "THE ROUND HAS FINISHED", $01, $00, (min((b_br\Field0 / 2.0), 255.0) / 255.0))
                    aatext(((graphicwidth Sar $01) + $01), (Int (((Float graphicheight) * 0.08) + 1.0)), "THE ROUND HAS FINISHED", $01, $00, (min((b_br\Field0 / 2.0), 255.0) / 255.0))
                    aasetfont(font2)
                    color(b_br\Field2, b_br\Field3, b_br\Field4)
                    If (b_br\Field1 <> "") Then
                        aatext(((graphicwidth Sar $01) + $01), (Int (((Float graphicheight) * 0.17) + 1.0)), (b_br\Field1 + " WON"), $01, $00, (min((b_br\Field0 / 2.0), 255.0) / 255.0))
                        aatext((graphicwidth Sar $01), (Int ((Float graphicheight) * 0.17)), (b_br\Field1 + " WON"), $01, $00, (min((b_br\Field0 / 2.0), 255.0) / 255.0))
                    EndIf
                EndIf
                If (((networkserver\Field15 And (((b_br\Field7 - millisecs()) - b_br\Field6) > $00)) And (myplayer\Field51 = model_wait)) <> 0) Then
                    local10 = ((b_br\Field7 - millisecs()) - b_br\Field6)
                    local0 = (((local10 + $3E7) / $3E8) Mod $3C)
                    local1 = (((local10 + $3E7) / $EA60) Mod $3C)
                    local2 = (Str local0)
                    If (local0 < $0A) Then
                        local2 = ("0" + (Str local0))
                    EndIf
                    color($C8, $C8, $C8)
                    aasetfont(consolefont)
                    formattext((Float (graphicwidth Sar $01)), ((Float graphicheight) * 0.08), (("%w%CONNECTED %g%" + (Str networkserver\Field29)) + " %w%PLAYERS"), $01, $00, 1.0, $00)
                    aatext((graphicwidth Sar $01), (Int ((Float graphicheight) * 0.12)), ((("Remaining before the start of the game - " + (Str local1)) + ":") + local2), $01, $00, 1.0)
                    local11 = ""
                    If (networkserver\Field29 < $04) Then
                        local11 = (("%w%Requires %r%" + (Str ($04 - networkserver\Field29))) + " %w%more players to start the game")
                    EndIf
                    If (local11 <> "") Then
                        formattext((Float (graphicwidth Sar $01)), ((Float graphicheight) * 0.15), local11, $01, $00, 1.0, $00)
                    EndIf
                EndIf
            EndIf
        EndIf
        If (udp_respond() = $00) Then
            aasetfont(font1)
            color($FF, $00, $00)
            aatext((Int (20.0 * menuscale)), (Int ((Float graphicheight) - (20.0 * menuscale))), "Server not responding...", $00, $00, 1.0)
            color($FF, $FF, $FF)
        EndIf
        If (tab_menu_state <> $00) Then
            local12 = $00
            menuopen = $00
            invopen = $00
            aasetfont(font1)
            Select tab_menu_state
                Case $03
                    local14 = (Int ((Float (graphicwidth Sar $01)) - (175.0 * menuscale)))
                    local15 = (Int ((Float (graphicheight Sar $01)) - (200.0 * menuscale)))
                    drawframe(local14, local15, (Int (350.0 * menuscale)), (Int (360.0 * menuscale)), $00, $00)
                    drawframe(local14, (Int ((Float local15) - (30.0 * menuscale))), (Int (350.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                    If (drawbutton((Int ((300.0 * menuscale) + (Float local14))), (Int ((Float local15) - (23.0 * menuscale))), (Int (30.0 * menuscale)), (Int (20.0 * menuscale)), "<<", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currplayer = Null
                        blockguns = $01
                        mousehit1 = $00
                    EndIf
                    If (currplayer = Null) Then
                        tab_menu_state = $01
                    Else
                        bs_csteamid_set(bs_steamid_dynamic, currplayer\Field95, $01, $01)
                        disableredirectaccess = $01
                        color(currplayer\Field89, currplayer\Field90, currplayer\Field91)
                        aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((Float local15) - (23.0 * menuscale))), currplayer\Field24, $00, $00, 1.0)
                        color($FF, $FF, $FF)
                        disableredirectaccess = $00
                        currplayer\Field65 = (slidebar((Int ((10.0 * menuscale) + (Float local14))), (Int ((30.0 * menuscale) + (Float local15))), (Int (135.0 * menuscale)), (currplayer\Field65 * 100.0), $00) / 100.0)
                        aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((5.0 * menuscale) + (Float local15))), ("Player volume: " + (Str (Int (currplayer\Field65 * 100.0)))), $00, $00, 1.0)
                        If (bs_isteamfriends_getfriendrelationship(bs_steamfriends(), bs_steamid_dynamic) = $03) Then
                            drawimage(mpimg\Field14, (Int ((Float (aastringwidth(currplayer\Field24) + local14)) + (15.0 * menuscale))), (Int ((Float local15) - (19.0 * menuscale))), $00)
                        EndIf
                        If (currplayer\Field95 <> $00) Then
                            color($FF, $FF, $FF)
                            rect((Int ((170.0 * menuscale) + (Float local14))), (Int ((30.0 * menuscale) + (Float local15))), (Int (170.0 * menuscale)), (Int (170.0 * menuscale)), $00)
                            If (drawbutton((Int ((180.0 * menuscale) + (Float local14))), (Int ((40.0 * menuscale) + (Float local15))), (Int (150.0 * menuscale)), (Int (25.0 * menuscale)), "Open profile", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                bs_isteamfriends_activategameoverlaytouser(bs_steamfriends(), "steamid", bs_steamid_dynamic)
                            EndIf
                            If (bs_isteamfriends_getfriendrelationship(bs_steamfriends(), bs_steamid_dynamic) > $00) Then
                                drawbutton((Int ((180.0 * menuscale) + (Float local14))), (Int ((70.0 * menuscale) + (Float local15))), (Int (150.0 * menuscale)), (Int (25.0 * menuscale)), "Add to friends", $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            ElseIf (drawbutton((Int ((180.0 * menuscale) + (Float local14))), (Int ((70.0 * menuscale) + (Float local15))), (Int (150.0 * menuscale)), (Int (25.0 * menuscale)), "Add to friends", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                bs_isteamfriends_activategameoverlaytouser(bs_steamfriends(), "friendadd", bs_steamid_dynamic)
                            EndIf
                            If (bs_isteamfriends_requestuserinformation(bs_steamfriends(), bs_steamid_dynamic, $00) = $00) Then
                                If (currplayer\Field96 = $00) Then
                                    local16 = bs_isteamfriends_getlargefriendavatar(bs_steamfriends(), bs_steamid_dynamic)
                                    If (((local16 = $FFFFFFFF) Or (local16 = $00)) = $00) Then
                                        local17 = createbank($04)
                                        local18 = createbank($04)
                                        bs_steamutils_getimagesize(bs_steamutils(), local16, local17, local18)
                                        local19 = peekint(local17, $00)
                                        local20 = peekint(local18, $00)
                                        freebank(local17)
                                        freebank(local18)
                                        If (((local19 > $00) And (local20 > $00)) <> 0) Then
                                            local21 = createbank(((local19 * local20) Shl $02))
                                            local22 = createbank(((local19 * local20) * $03))
                                            local23 = $00
                                            bs_steamutils_getimagergba(bs_steamutils(), local16, local21, banksize(local21))
                                            For local8 = $00 To (banksize(local21) - $01) Step $04
                                                pokebyte(local22, local23, peekbyte(local21, (local8 + $02)))
                                                local23 = (local23 + $01)
                                                pokebyte(local22, local23, peekbyte(local21, (local8 + $01)))
                                                local23 = (local23 + $01)
                                                pokebyte(local22, local23, peekbyte(local21, local8))
                                                local23 = (local23 + $01)
                                            Next
                                            local24 = fi_convertfromrawbits(local22, local19, local20, (local19 * $03), $18, $FF0000, $FF00, $FF, $01)
                                            fi_save($0D, local24, (("Temp\avatar" + (Str currplayer\Field95)) + ".png"), $00)
                                            fi_unload(local24)
                                            freebank(local21)
                                            freebank(local22)
                                            currplayer\Field96 = loadimage((("Temp\avatar" + (Str currplayer\Field95)) + ".png"))
                                            resizeimage(currplayer\Field96, (((Float imagewidth(currplayer\Field96)) * 0.3) * menuscale), (((Float imageheight(currplayer\Field96)) * 0.3) * menuscale))
                                        EndIf
                                    EndIf
                                Else
                                    color($FF, $FF, $FF)
                                    rect((Int ((178.0 * menuscale) + (Float local14))), (Int ((108.0 * menuscale) + (Float local15))), (Int ((Float imagewidth(currplayer\Field96)) + (4.0 * menuscale))), (Int ((Float imageheight(currplayer\Field96)) + (4.0 * menuscale))), $01)
                                    drawblock(currplayer\Field96, (Int ((180.0 * menuscale) + (Float local14))), (Int ((110.0 * menuscale) + (Float local15))), $00)
                                    aasetfont(font1)
                                    aatext((Int ((178.0 * menuscale) + (Float local14))), (Int (((118.0 * menuscale) + (Float local15)) + (Float imageheight(currplayer\Field96)))), (("[U:1:" + (Str currplayer\Field95)) + "]"), $00, $00, 1.0)
                                EndIf
                            EndIf
                        EndIf
                        If ((multiplayer_isfullsync() And isplayeradmin()) <> 0) Then
                            aasetfont(font1)
                            color($FF, $FF, $FF)
                            If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int ((60.0 * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Ban IP", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $01) Then
                                    executeconsolecommand(("ban " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $01
                                EndIf
                            EndIf
                            If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int ((78.94737 * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Ban steam", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $02) Then
                                    executeconsolecommand(("bansteam " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $02
                                EndIf
                            EndIf
                            If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int (((1.0 / 0.0095) * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Kick", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $03) Then
                                    executeconsolecommand(("kick " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $03
                                EndIf
                            EndIf
                            If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int (((1.0 / 0.0076) * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Mute\Unmute", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $04) Then
                                    executeconsolecommand(("mute " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $04
                                EndIf
                            EndIf
                            If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int ((157.8947 * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Teleport to", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $05) Then
                                    executeconsolecommand(("tpto " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $05
                                EndIf
                            EndIf
                            If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int ((184.2105 * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Teleport to me", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $06) Then
                                    executeconsolecommand(("tpme " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $06
                                EndIf
                            EndIf
                            aasetfont(font1)
                            If (previousclickedbutton <> $00) Then
                                aatext((Int ((135.0 * menuscale) + (Float local14))), (Int ((((((1.0 / 0.038) * (Float (previousclickedbutton - $01))) + 60.0) * menuscale) + (Float local15)) - (5.0 * menuscale))), "Sure?", $00, $00, 1.0)
                            EndIf
                            aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((260.0 * menuscale) + (Float local15))), "Give role:", $00, $00, 1.0)
                            tab_menu_role_input = inputbox((Int ((110.0 * menuscale) + (Float local14))), (Int ((260.0 * menuscale) + (Float local15))), (Int (180.0 * menuscale)), (Int (20.0 * menuscale)), tab_menu_role_input, $08, $00, -1.0)
                            If (drawbutton((Int ((290.0 * menuscale) + (Float local14))), (Int ((260.0 * menuscale) + (Float local15))), (Int (50.0 * menuscale)), (Int (20.0 * menuscale)), "Give", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                executeconsolecommand(((("giverole " + (Str currplayer\Field0)) + " ") + tab_menu_role_input), $00, $01)
                            EndIf
                            aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((300.0 * menuscale) + (Float local15))), "Give item:", $00, $00, 1.0)
                            tab_menu_item_input = inputbox((Int ((110.0 * menuscale) + (Float local14))), (Int ((300.0 * menuscale) + (Float local15))), (Int (180.0 * menuscale)), (Int (20.0 * menuscale)), tab_menu_item_input, $09, $00, -1.0)
                            If (drawbutton((Int ((290.0 * menuscale) + (Float local14))), (Int ((300.0 * menuscale) + (Float local15))), (Int (50.0 * menuscale)), (Int (20.0 * menuscale)), "Give", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                executeconsolecommand(((("giveitem " + (Str currplayer\Field0)) + " ") + tab_menu_item_input), $00, $01)
                            EndIf
                            If (drawbutton((Int ((85.0 * menuscale) + (Float local14))), (Int ((340.0 * menuscale) + (Float local15))), (Int (200.0 * menuscale)), (Int (20.0 * menuscale)), "ADMIN PANEL", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                tab_menu_state = $04
                            EndIf
                        EndIf
                    EndIf
                Case $04
                    local14 = (Int ((Float (graphicwidth Sar $01)) - (175.0 * menuscale)))
                    local15 = (Int ((Float (graphicheight Sar $01)) - (200.0 * menuscale)))
                    drawframe(local14, local15, (Int (350.0 * menuscale)), (Int (360.0 * menuscale)), $00, $00)
                    drawframe(local14, (Int ((Float local15) - (30.0 * menuscale))), (Int (350.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                    If (drawbutton((Int ((250.0 * menuscale) + (Float local14))), (Int ((4.0 * menuscale) + (Float local15))), (Int (30.0 * menuscale)), (Int (20.0 * menuscale)), "<<", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        tab_menu_state = $03
                    EndIf
                    aasetfont(fontservers)
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int (((1.0 / 0.057) * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Start match", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("startmatch", $00, $01)
                    EndIf
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int (((1.0 / 0.0228) * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Restart server", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("restart", $00, $01)
                    EndIf
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int (((1.0 / 0.01425) * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Spawn Chaos", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("spawnchaos", $00, $01)
                    EndIf
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int ((96.49123 * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Spawn MTF", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("spawnmtf", $00, $01)
                    EndIf
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int ((122.807 * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Use warheads", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("activatewarheads", $00, $01)
                    EndIf
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int ((149.1228 * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Explode warheads", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("forcewarheads", $00, $01)
                    EndIf
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int (((1.0 / 0.0057) * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Cancel warheads", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("cancelwarheads", $00, $01)
                    EndIf
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local14))), (Int ((201.7544 * menuscale) + (Float local15))), (Int (116.6667 * menuscale)), (Int ((1.0 / 0.0456) * menuscale)), "Intercom", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("shouldannounc", $00, $01)
                    EndIf
                    aasetfont(font1)
                    aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((230.0 * menuscale) + (Float local15))), "Lobby time (min):", $00, $00, 1.0)
                    tab_menu_lobby_input = inputbox((Int ((160.0 * menuscale) + (Float local14))), (Int ((230.0 * menuscale) + (Float local15))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), tab_menu_lobby_input, $0A, $00, -1.0)
                    If (drawbutton((Int ((290.0 * menuscale) + (Float local14))), (Int ((230.0 * menuscale) + (Float local15))), (Int (50.0 * menuscale)), (Int (20.0 * menuscale)), "Set", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand(("lob " + tab_menu_lobby_input), $00, $01)
                    EndIf
                    aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((260.0 * menuscale) + (Float local15))), "MTF Tickets:", $00, $00, 1.0)
                    tab_menu_role_input = inputbox((Int ((160.0 * menuscale) + (Float local14))), (Int ((260.0 * menuscale) + (Float local15))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), tab_menu_role_input, $08, $00, -1.0)
                    If (drawbutton((Int ((290.0 * menuscale) + (Float local14))), (Int ((260.0 * menuscale) + (Float local15))), (Int (50.0 * menuscale)), (Int (20.0 * menuscale)), "Set", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand(("setmtftickets " + tab_menu_role_input), $00, $01)
                    EndIf
                    aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((290.0 * menuscale) + (Float local15))), "Chaos Tickets:", $00, $00, 1.0)
                    tab_menu_item_input = inputbox((Int ((160.0 * menuscale) + (Float local14))), (Int ((290.0 * menuscale) + (Float local15))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), tab_menu_item_input, $09, $00, -1.0)
                    If (drawbutton((Int ((290.0 * menuscale) + (Float local14))), (Int ((290.0 * menuscale) + (Float local15))), (Int (50.0 * menuscale)), (Int (20.0 * menuscale)), "Set", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand(("setchaostickets " + tab_menu_item_input), $00, $01)
                    EndIf
                Default
                    previousclickedbutton = $00
                    local14 = (Int ((Float (graphicwidth Sar $01)) - (175.0 * menuscale)))
                    local15 = (Int ((Float (graphicheight Sar $01)) - (200.0 * menuscale)))
                    drawframe(local14, local15, (Int (350.0 * menuscale)), (Int (330.0 * menuscale)), $00, $00)
                    drawframe(local14, (Int ((Float local15) - (30.0 * menuscale))), (Int (350.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                    drawframe(local14, (Int ((30.0 * menuscale) + (Float local15))), (Int (330.0 * menuscale)), (Int (2.0 * menuscale)), $00, $00)
                    drawframe((Int ((260.0 * menuscale) + (Float local14))), local15, (Int (2.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                    formattext(((11.0 * menuscale) + (Float local14)), ((Float local15) - (23.0 * menuscale)), networkserver\Field21, $00, $00, 1.0, $00)
                    aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((5.0 * menuscale) + (Float local15))), "Nickname", $00, $00, 1.0)
                    aatext((Int ((270.0 * menuscale) + (Float local14))), (Int ((5.0 * menuscale) + (Float local15))), "Ping", $00, $00, 1.0)
                    local26 = $00
                    For local9 = Each players
                        If (local9\Field24 <> "") Then
                            For local27 = $00 To $07 Step $01
                                If ((local12 Sar $03) = local27) Then
                                    local9\Field69 = local27
                                    local25[local27] = $01
                                    Exit
                                EndIf
                            Next
                            local12 = (local12 + $01)
                        EndIf
                    Next
                    For local9 = Each players
                        If (local9\Field24 <> "") Then
                            If (selected_p_page = local9\Field69) Then
                                drawframe(local14, (Int (((Float ($1E + local28)) * menuscale) + (Float local15))), (Int (350.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                If (local9\Field0 = networkserver\Field28) Then
                                    local9\Field48 = serverping
                                    local9\Field24 = nickname
                                ElseIf (bs_isteamfriends_getfriendrelationship(bs_steamfriends(), udp_fillsteam(local9\Field95)) = $03) Then
                                    drawimage(mpimg\Field14, (Int ((250.0 * menuscale) + (Float local14))), (Int (((Float ($1E + local28)) * menuscale) + (Float (local15 + $07)))), $00)
                                EndIf
                                color($FF, $FF, $FF)
                                disableredirectaccess = $01
                                color(local9\Field89, local9\Field90, local9\Field91)
                                aatext((Int ((10.0 * menuscale) + (Float local14))), (Int (((Float ($1E + local28)) * menuscale) + (Float (local15 + $05)))), ((("[" + (Str local9\Field0)) + "] ") + local9\Field24), $00, $00, 1.0)
                                disableredirectaccess = $00
                                color($FF, $FF, $FF)
                                aatext((Int ((270.0 * menuscale) + (Float local14))), (Int (((Float ($1E + local28)) * menuscale) + (Float (local15 + $05)))), (Str local9\Field48), $00, $00, 1.0)
                                If (drawbutton((Int ((305.0 * menuscale) + (Float local14))), (Int (((Float ($1E + local28)) * menuscale) + (Float (local15 + $04)))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), "+", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    tab_menu_state = $03
                                    currplayer = local9
                                EndIf
                                local28 = (local28 + $1E)
                            EndIf
                        EndIf
                    Next
                    For local8 = $00 To $07 Step $01
                        If (local25[local8] = $01) Then
                            If (selected_p_page = local8) Then
                                drawbutton((Int (((Float (($1E * local8) + $0A)) * menuscale) + (Float local14))), (Int ((280.0 * menuscale) + (Float local15))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local8 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, selected_p_page, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            ElseIf (drawbutton((Int (((Float (($1E * local8) + $0A)) * menuscale) + (Float local14))), (Int ((280.0 * menuscale) + (Float local15))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local8 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                selected_p_page = local8
                            EndIf
                        EndIf
                    Next
                    color($FF, $FF, $FF)
                    aatext((Int ((10.0 * menuscale) + (Float local14))), (Int ((310.0 * menuscale) + (Float local15))), (((Str networkserver\Field29) + " / ") + (Str networkserver\Field14)), $00, $00, 1.0)
            End Select
            If ((fullscreen And (tab_menu_state > $01)) <> 0) Then
                drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
            EndIf
        EndIf
    EndIf
    If ((((currentworkshopdownloaditems <> $00) Or (currentworkshopuploadingitems <> $00)) And (have_querys() = $00)) <> 0) Then
        local29 = (("Downloading workshop items... (" + (Str (currentworkshopdownloaditems + currentworkshopuploadingitems))) + " item left)")
        color($FF, $FF, $FF)
        aasetfont(font1)
        aatext((Int ((Float (graphicwidth - aastringwidth(local29))) - (30.0 * menuscale))), (graphicheight - $2D), local29, $00, $00, 1.0)
        loading_frame = playanimimage(mpimg\Field9, (Int ((Float (graphicwidth - aastringwidth(local29))) - (70.0 * menuscale))), (graphicheight - $32), (0.05 * fpsfactor), loading_frame, 11.0)
    EndIf
    Return $00
End Function
