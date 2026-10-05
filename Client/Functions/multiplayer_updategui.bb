Function multiplayer_updategui%(arg0%)
    Local local0%
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16$
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24.players
    Local local25%
    Local local26%
    Local local27%
    Local local28%
    Local local30%
    Local local31%
    Local local32%
    Local local33%
    Local local34%
    Local local35%
    Local local36%
    Local local37%
    Local local38%
    Local local39%
    Local local40%
    Local local41%
    Local local42%
    Local local43%
    Local local44%
    Local local45%
    Local local46%
    Local local47%
    Local local48%
    Local local49%[8]
    Local local50%
    Local local51%
    Local local52%
    Local local53%
    Local local54$
    If (udp_getstream() <> 0) Then
        updatequery()
        local0 = millisecs()
        local1 = menuscale
        local2 = myplayer\Field49
        local3 = (hudenabled And arg0)
        If (mainmenuopen = $00) Then
            If (local3 <> 0) Then
                If (networkserver\Field12 <> 0) Then
                    If ((consoleopen Or menuopen) = $00) Then
                        local4 = (b_br\Field7 - local0)
                        If (local4 < b_br\Field6) Then
                            setfontex(fonts[$02]\Field0)
                            setcolorraw($FFFFFF)
                            If (local4 > $00) Then
                                local5 = (Int ((Float (local4 + $3E7)) * 0.001))
                                local6 = (Int ((Float local5) * (1.0 / 60.0)))
                                local7 = (local5 Mod $3C)
                                If (local7 < $0A) Then
                                    text((graphicwidth - $3C), $14, (((Str local6) + ":0") + (Str local7)), $00, $00)
                                Else
                                    text((graphicwidth - $3C), $14, (((Str local6) + ":") + (Str local7)), $00, $00)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (((local2 > $00) And (local2 <> $12)) <> 0) Then
                        setfontex(fonts[$00]\Field0)
                        local8 = imenuscale[$CC]
                        local9 = imenuscale[$14]
                        local10 = (local8 Shr $01)
                        local11 = imenuscale[$50]
                        local12 = (graphicheight - imenuscale[$87])
                        local13 = imenuscale[$04]
                        local14 = imenuscale[$08]
                        local15 = (Int myplayer\Field68)
                        local16 = gettypename(local2)
                        setcolorraw($B40000)
                        renderprogressbar((imenuscale[$01] + local11), (imenuscale[$01] + local12), (local8 - imenuscale[$02]), (local9 - imenuscale[$02]), (Float multiplayer_breach_getmaxhp(local2)), (Float local15))
                        setcolorraw($FFFFFF)
                        rect(local11, local12, local8, local9, $00)
                        local11 = (local11 + local10)
                        local9 = imenuscale[$0A]
                        text(local11, (local12 + local9), (Str local15), $01, $01)
                        If (local16 <> "") Then
                            local17 = (len(local16) * fonts[$00]\Field3)
                            local18 = fonts[$00]\Field2
                            local19 = (local17 Shr $01)
                            local20 = (local18 Shr $01)
                            drawframe(((local11 - local19) - local13), (((local12 - local9) - local20) - local13), (local17 + local14), (local18 + local14), $00, $00)
                            settypecolor(local2)
                            text(local11, (local12 - local9), local16, $01, $01)
                        EndIf
                        If ((multiplayer_isascp(local2) Or multiplayer_breach_isa035(local2)) <> 0) Then
                            local8 = imenuscale[$C8]
                            local9 = imenuscale[$14]
                            local11 = (viewport_center_x - (local8 Shr $01))
                            local12 = ((local9 Shl $02) + viewport_center_y)
                            setcolorraw($B4)
                            If ((Int renderprogressbar((local11 + local13), (local12 - local13), (local8 + local14), (local9 - local14), (Float scp\Field8), (Float (scp\Field1 - local0)))) <> 0) Then
                                setcolorraw($FFFFFF)
                                rect((local11 + local13), (local12 - local13), (local8 + local14), (local9 - local14), $00)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (networkserver\Field52\Field10 = $01) Then
            For local22 = $01 To networkserver\Field52\Field14 Step $01
                If (player[local22] <> Null) Then
                    If (player[local22]\Field43 = $01) Then
                        If ((((mainmenuopen And (networkserver\Field12 = $00)) Or ((player[local22]\Field49 = $00) And (myplayer\Field49 = $00))) Or player[local22]\Field50) <> 0) Then
                            setcolorraw($FFFFFF)
                            setfontex(fonts[$00]\Field0)
                            setcolorex(player[local22]\Field87, player[local22]\Field88, player[local22]\Field89)
                            local23 = $01
                            text((Int (40.0 * menuscale)), (Int ((Float ($C8 + local21)) * menuscale)), (((player[local22]\Field24 + "[") + (Str local22)) + "]"), $00, $00)
                            local23 = $00
                            drawimage(mpimg\Field2[player[local22]\Field50], (Int (25.0 * menuscale)), (Int ((Float ($C8 + local21)) * menuscale)), $00)
                            local21 = (local21 + $1E)
                        EndIf
                    EndIf
                EndIf
            Next
        EndIf
        If (arg0 <> 0) Then
            For local24 = Each players
                If (local24\Field0 <> networkserver\Field20) Then
                    multiplayer_renderplayer2d(local24)
                EndIf
            Next
        EndIf
        If ((((keyhit(key_chat) And (consoleopen = $00)) And (networkserver\Field19 = $00)) And (tab_menu_state < $02)) <> 0) Then
            flushkeys()
            networkserver\Field19 = (networkserver\Field19 = $00)
        EndIf
        draws_render()
        texts_render()
        multiplayer_rendervoice()
        multiplayer_renderchat()
        If (local3 <> 0) Then
            If ((((b_br\Field9 > $00) And (1.0 > b_br\Field0)) And (((b_br\Field7 - local0) - b_br\Field6) < $01)) <> 0) Then
            EndIf
            If (((0.0 < b_br\Field0) And (b_br\Field1 <> "NULL")) <> 0) Then
                setcolorex($FF, $FF, $FF)
                setfontex(fonts[$01]\Field0)
                text(viewport_center_x, (Int ((Float graphicheight) * 0.08)), "THE ROUND HAS FINISHED", $01, $00)
                setcolorex(b_br\Field2, b_br\Field3, b_br\Field4)
                If (b_br\Field1 <> "") Then
                    text(viewport_center_x, (Int ((Float graphicheight) * 0.17)), (b_br\Field1 + " WON"), $01, $00)
                EndIf
            EndIf
            If ((networkserver\Field12 And (local2 = model_wait)) <> 0) Then
                local25 = ((b_br\Field7 - local0) - b_br\Field6)
                If (local25 > $00) Then
                    local5 = (Int ((Float (local25 + $3E7)) * 0.001))
                    local26 = (Int ((Float local5) * (1.0 / 60.00024)))
                    local27 = (local5 Mod $3C)
                    setcolorex($C8, $C8, $C8)
                    formattext((Float viewport_center_x), ((Float graphicheight) * 0.08), (("%w%CONNECTED %g%" + (Str networkserver\Field21)) + " %w%PLAYERS"), $01, $00, 1.0, $00)
                    If (local27 < $0A) Then
                        text(viewport_center_x, (Int ((Float graphicheight) * 0.12)), ((("Remaining before the start of the game - " + (Str local26)) + ":0") + (Str local27)), $01, $00)
                    Else
                        text(viewport_center_x, (Int ((Float graphicheight) * 0.12)), ((("Remaining before the start of the game - " + (Str local26)) + ":") + (Str local27)), $01, $00)
                    EndIf
                    If (networkserver\Field21 < $04) Then
                        formattext((Float viewport_center_x), ((Float graphicheight) * 0.15), (("%w%Requires %r%" + (Str ($04 - networkserver\Field21))) + " %w%more players to start the game"), $01, $00, 1.0, $00)
                    EndIf
                EndIf
            EndIf
        EndIf
        If (udp_respond() = $00) Then
            setfontex(fonts[$00]\Field0)
            setcolorex($FF, $00, $00)
            text(imenuscale[$14], (graphicheight - imenuscale[$14]), "Server not responding...", $00, $00)
            setcolorex($FF, $FF, $FF)
        EndIf
        If (tab_menu_state <> $00) Then
            local28 = $00
            menuopen = $00
            invopen = $00
            setfontex(fonts[$00]\Field0)
            Select tab_menu_state
                Case $03
                    local30 = (viewport_center_x - imenuscale[$AF])
                    local31 = (viewport_center_y - imenuscale[$C8])
                    drawframe(local30, local31, imenuscale[$15E], imenuscale[$168], $00, $00)
                    drawframe(local30, (local31 - imenuscale[$1E]), imenuscale[$15E], imenuscale[$1E], $00, $00)
                    If (drawbutton((imenuscale[$12C] + local30), (local31 - imenuscale[$17]), imenuscale[$1E], imenuscale[$14], "<<", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currplayer = Null
                        blockguns = $01
                        mousehit1 = $00
                    EndIf
                    If (currplayer = Null) Then
                        tab_menu_state = $01
                    Else
                        local23 = $01
                        setcolorex(currplayer\Field87, currplayer\Field88, currplayer\Field89)
                        text((imenuscale[$0A] + local30), (local31 - imenuscale[$14]), currplayer\Field24, $00, $00)
                        setcolorex($FF, $FF, $FF)
                        local23 = $00
                        local32 = (Int currplayer\Field63)
                        local33 = ((local32 Shl $02) + local32)
                        local33 = ((local33 Shl $04) + (local33 Shl $02))
                        currplayer\Field63 = (slidebar((imenuscale[$0A] + local30), (imenuscale[$1E] + local31), imenuscale[$87], (Float local33), $00, 0.0, 100.0, $00) * 0.01)
                        text((imenuscale[$0A] + local30), (imenuscale[$05] + local31), ("Player volume: " + (Str local33)), $00, $00)
                        If (issteamfriend(steamid64) <> 0) Then
                            drawimage(mpimg\Field12, ((stringwidth(currplayer\Field24) + local30) + imenuscale[$0F]), (local31 - imenuscale[$13]), $00)
                        EndIf
                        If (currplayer\Field93 <> "") Then
                            rect((imenuscale[$AA] + local30), (imenuscale[$1E] + local31), imenuscale[$AA], imenuscale[$AA], $00)
                            If (drawbutton((imenuscale[$B4] + local30), (imenuscale[$28] + local31), imenuscale[$96], imenuscale[$19], "Open profile", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                steam_activateoverlaytouser("steamid", currplayer\Field94, currplayer\Field95)
                            EndIf
                            If (issteamfriend(steamid64) <> 0) Then
                                If (drawbutton((imenuscale[$B4] + local30), (imenuscale[$46] + local31), imenuscale[$96], imenuscale[$19], "Add to friends", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    steam_activateoverlaytouser("friendadd", currplayer\Field94, currplayer\Field95)
                                EndIf
                            EndIf
                            setcolorex($FF, $FF, $FF)
                            If (steam_requestuserinformation(currplayer\Field94, currplayer\Field95, $00) = $00) Then
                                If (currplayer\Field96 = $00) Then
                                    local34 = steam_getlargeuseravatar(currplayer\Field94, currplayer\Field95)
                                    If (local34 > $00) Then
                                        local35 = steam_getuserimageheight(local34)
                                        local36 = steam_getuserimagewidth(local34)
                                        local37 = createbank(((local36 * local35) Shl $02))
                                        local38 = steam_getuserimagergba(local34, local37, banksize(local37))
                                        If (local38 <> 0) Then
                                            currplayer\Field96 = createimage(local36, local35, $01)
                                            lockbuffer(imagebuffer(currplayer\Field96, $00))
                                            local21 = $00
                                            For local12 = $00 To (local35 - $01) Step $01
                                                For local11 = $00 To (local36 - $01) Step $01
                                                    local39 = peekbyte(local37, local21)
                                                    local40 = peekbyte(local37, (local21 + $01))
                                                    local41 = peekbyte(local37, (local21 + $02))
                                                    local42 = peekbyte(local37, (local21 + $03))
                                                    local43 = ((((local42 Shl $18) Or (local39 Shl $10)) Or (local40 Shl $08)) Or local41)
                                                    writepixelfast(local11, local12, local43, imagebuffer(currplayer\Field96, $00))
                                                    local21 = (local21 + $04)
                                                Next
                                            Next
                                            unlockbuffer(imagebuffer(currplayer\Field96, $00))
                                        EndIf
                                        freebank(local37)
                                    EndIf
                                Else
                                    local44 = imagewidth(currplayer\Field96)
                                    local45 = imageheight(currplayer\Field96)
                                    rect((imenuscale[$B2] + local30), (imenuscale[$6C] + local31), (Int ((4.0 * local1) + (Float local44))), (Int ((4.0 * local1) + (Float local45))), $01)
                                    drawimage(currplayer\Field96, (imenuscale[$B4] + local30), (imenuscale[$6E] + local31), $00)
                                    text((imenuscale[$B2] + local30), ((imenuscale[$76] + local31) + local45), (("[" + currplayer\Field93) + "]"), $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        If ((multiplayer_isfullsync() And isplayeradmin()) <> 0) Then
                            setfontex(fonts[$00]\Field0)
                            setcolorex($FF, $FF, $FF)
                            If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$3C] + local31), imenuscale[$74], imenuscale[$16], "Ban IP", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $01) Then
                                    executeconsolecommand(("ban " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $01
                                EndIf
                            EndIf
                            If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$4F] + local31), imenuscale[$74], imenuscale[$16], "Ban steam", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $02) Then
                                    executeconsolecommand(("bansteam " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $02
                                EndIf
                            EndIf
                            If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$69] + local31), imenuscale[$75], imenuscale[$16], "Kick", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $03) Then
                                    executeconsolecommand(("kick " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $03
                                EndIf
                            EndIf
                            If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$84] + local31), imenuscale[$75], imenuscale[$16], "Mute\Unmute", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $04) Then
                                    executeconsolecommand(("mute " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $04
                                EndIf
                            EndIf
                            If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$9E] + local31), imenuscale[$75], imenuscale[$16], "Teleport to", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $05) Then
                                    executeconsolecommand(("tpto " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $05
                                EndIf
                            EndIf
                            If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$B8] + local31), imenuscale[$75], imenuscale[$16], "Teleport to me", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                If (previousclickedbutton = $06) Then
                                    executeconsolecommand(("tpme " + (Str currplayer\Field0)), $00, $01)
                                    previousclickedbutton = $00
                                Else
                                    previousclickedbutton = $06
                                EndIf
                            EndIf
                            setfontex(fonts[$00]\Field0)
                            If (previousclickedbutton <> $00) Then
                                text((imenuscale[$87] + local30), (Int ((((Float ((imenuscale[$1A] * (previousclickedbutton - $01)) + $3C)) * menuscale) + (Float local31)) - (Float imenuscale[$05]))), "Sure?", $00, $00)
                            EndIf
                            text((imenuscale[$0A] + local30), (imenuscale[$104] + local31), "Give role:", $00, $00)
                            tab_menu_role_input = inputbox((imenuscale[$6E] + local30), (imenuscale[$104] + local31), imenuscale[$B4], imenuscale[$14], tab_menu_role_input, $08, $00, -1.0)
                            If (drawbutton((imenuscale[$122] + local30), (imenuscale[$104] + local31), imenuscale[$32], imenuscale[$14], "Give", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                executeconsolecommand(((("giverole " + (Str currplayer\Field0)) + " ") + tab_menu_role_input), $00, $01)
                            EndIf
                            text((imenuscale[$0A] + local30), (imenuscale[$12C] + local31), "Give item:", $00, $00)
                            tab_menu_item_input = inputbox((imenuscale[$6E] + local30), (imenuscale[$12C] + local31), imenuscale[$B4], imenuscale[$14], tab_menu_item_input, $09, $00, -1.0)
                            If (drawbutton((imenuscale[$122] + local30), (imenuscale[$12C] + local31), imenuscale[$32], imenuscale[$14], "Give", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                executeconsolecommand(((("giveitem " + (Str currplayer\Field0)) + " ") + tab_menu_item_input), $00, $01)
                            EndIf
                            If (drawbutton((imenuscale[$55] + local30), (imenuscale[$154] + local31), imenuscale[$C8], imenuscale[$14], "ADMIN PANEL", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                tab_menu_state = $04
                            EndIf
                        EndIf
                    EndIf
                Case $04
                    local30 = (viewport_center_x - imenuscale[$AF])
                    local31 = (viewport_center_y - imenuscale[$C8])
                    local46 = imenuscale[$75]
                    local47 = imenuscale[$16]
                    drawframe(local30, local31, imenuscale[$15E], imenuscale[$168], $00, $00)
                    drawframe(local30, (local31 - imenuscale[$1E]), imenuscale[$15E], imenuscale[$1E], $00, $00)
                    If (drawbutton((imenuscale[$FA] + local30), (imenuscale[$04] + local31), imenuscale[$1E], imenuscale[$14], "<<", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        tab_menu_state = $03
                    EndIf
                    setfontex(fonts[$00]\Field0)
                    If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$12] + local31), local46, local47, "Start match", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("startmatch", $00, $01)
                    EndIf
                    If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$2C] + local31), local46, local47, "Restart server", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("restart", $00, $01)
                    EndIf
                    If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$46] + local31), local46, local47, "Spawn Chaos", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("spawnchaos", $00, $01)
                    EndIf
                    If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$60] + local31), local46, local47, "Spawn MTF", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("spawnmtf", $00, $01)
                    EndIf
                    If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$7B] + local31), local46, local47, "Use warheads", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("activatewarheads", $00, $01)
                    EndIf
                    If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$95] + local31), local46, local47, "Explode warheads", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("forcewarheads", $00, $01)
                    EndIf
                    If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$AF] + local31), local46, local47, "Cancel warheads", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("cancelwarheads", $00, $01)
                    EndIf
                    If (drawbutton((imenuscale[$0A] + local30), (imenuscale[$CA] + local31), local46, local47, "Intercom", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand("shouldannounc", $00, $01)
                    EndIf
                    setfontex(fonts[$00]\Field0)
                    local48 = (imenuscale[$E6] + local31)
                    text((imenuscale[$0A] + local30), local48, "Lobby time (min):", $00, $00)
                    tab_menu_lobby_input = inputbox((imenuscale[$A0] + local30), local48, imenuscale[$64], imenuscale[$14], tab_menu_lobby_input, $0A, $00, -1.0)
                    If (drawbutton((imenuscale[$122] + local30), local48, imenuscale[$32], imenuscale[$14], "Set", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand(("lob " + tab_menu_lobby_input), $00, $01)
                    EndIf
                    local48 = (imenuscale[$104] + local31)
                    text((imenuscale[$0A] + local30), local48, "MTF Tickets:", $00, $00)
                    tab_menu_role_input = inputbox((imenuscale[$A0] + local30), local48, imenuscale[$64], imenuscale[$14], tab_menu_role_input, $08, $00, -1.0)
                    If (drawbutton((imenuscale[$122] + local30), local48, imenuscale[$32], imenuscale[$14], "Set", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand(("setmtftickets " + tab_menu_role_input), $00, $01)
                    EndIf
                    local48 = (imenuscale[$122] + local31)
                    text((imenuscale[$0A] + local30), local48, "Chaos Tickets:", $00, $00)
                    tab_menu_item_input = inputbox((imenuscale[$A0] + local30), local48, imenuscale[$64], imenuscale[$14], tab_menu_item_input, $09, $00, -1.0)
                    If (drawbutton((imenuscale[$122] + local30), local48, imenuscale[$32], imenuscale[$14], "Set", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        executeconsolecommand(("setchaostickets " + tab_menu_item_input), $00, $01)
                    EndIf
                Default
                    previousclickedbutton = $00
                    local30 = (viewport_center_x - imenuscale[$AF])
                    local31 = (viewport_center_y - imenuscale[$C8])
                    drawframe(local30, local31, imenuscale[$15E], imenuscale[$14A], $00, $00)
                    drawframe(local30, (local31 - imenuscale[$1E]), imenuscale[$15E], imenuscale[$1E], $00, $00)
                    drawframe(local30, (imenuscale[$1E] + local31), imenuscale[$14A], imenuscale[$02], $00, $00)
                    drawframe((imenuscale[$104] + local30), local31, imenuscale[$02], imenuscale[$1E], $00, $00)
                    formattext((Float (imenuscale[$0B] + local30)), (Float (local31 - imenuscale[$17])), networkserver\Field52\Field0, $00, $00, 1.0, $00)
                    text((imenuscale[$0A] + local30), (imenuscale[$05] + local31), "Nickname", $00, $00)
                    text((imenuscale[$10E] + local30), (imenuscale[$05] + local31), "Ping", $00, $00)
                    local50 = $00
                    For local24 = Each players
                        If (local24\Field24 <> "") Then
                            For local42 = $00 To $07 Step $01
                                If ((local28 Sar $03) = local42) Then
                                    local24\Field67 = local42
                                    local49[local42] = $01
                                    Exit
                                EndIf
                            Next
                            local28 = (local28 + $01)
                        EndIf
                    Next
                    For local24 = Each players
                        If (local24\Field24 <> "") Then
                            If (selected_p_page = local24\Field67) Then
                                drawframe(local30, (imenuscale[($1E + local51)] + local31), imenuscale[$15E], imenuscale[$1E], $00, $00)
                                If (local24\Field0 = networkserver\Field20) Then
                                    local24\Field46 = serverping
                                    local24\Field24 = nickname
                                ElseIf (issteamfriend(local24\Field93) <> 0) Then
                                    drawimage(mpimg\Field12, (imenuscale[$FA] + local30), (imenuscale[($25 + local51)] + local31), $00)
                                EndIf
                                setcolorex($FF, $FF, $FF)
                                local23 = $01
                                setcolorex(local24\Field87, local24\Field88, local24\Field89)
                                text((imenuscale[$0A] + local30), (imenuscale[($23 + local51)] + local31), ((("[" + (Str local24\Field0)) + "] ") + local24\Field24), $00, $00)
                                local23 = $00
                                setcolorex($FF, $FF, $FF)
                                text((imenuscale[$10E] + local30), (imenuscale[($23 + local51)] + local31), (Str local24\Field46), $00, $00)
                                If (drawbutton((imenuscale[$131] + local30), ((imenuscale[$04] + local31) + imenuscale[($1E + local51)]), imenuscale[$14], imenuscale[$14], "+", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    tab_menu_state = $03
                                    currplayer = local24
                                EndIf
                                local51 = (local51 + $1E)
                            EndIf
                        EndIf
                    Next
                    For local22 = $00 To $07 Step $01
                        If (local49[local22] = $01) Then
                            If (selected_p_page = local22) Then
                                drawbutton((Int (((Float (($1E * local22) + $0A)) * menuscale) + (Float local30))), (Int ((280.0 * menuscale) + (Float local31))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local22 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, selected_p_page, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            ElseIf (drawbutton((Int (((Float (($1E * local22) + $0A)) * menuscale) + (Float local30))), (Int ((280.0 * menuscale) + (Float local31))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local22 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                selected_p_page = local22
                            EndIf
                        EndIf
                    Next
                    setcolorex($FF, $FF, $FF)
                    text((Int ((10.0 * menuscale) + (Float local30))), (Int ((310.0 * menuscale) + (Float local31))), (((Str networkserver\Field21) + " / ") + (Str networkserver\Field52\Field14)), $00, $00)
            End Select
            If ((fullscreen And (tab_menu_state > $01)) <> 0) Then
                drawimage(cursorimg, mouseposx, mouseposy, $00)
            EndIf
        EndIf
    EndIf
    If ((((local52 <> $00) Or (local53 <> $00)) And (have_querys() = $00)) <> 0) Then
        local54 = ((("Downloading workshop items... (" + (Str local52)) + (Str local53)) + " item left)")
        setcolorex($FF, $FF, $FF)
        setfontex(fonts[$00]\Field0)
        text((Int ((Float (graphicwidth - stringwidth(local54))) - (30.0 * menuscale))), (graphicheight - $2D), local54, $00, $00)
        loading_frame = playanimimage(mpimg\Field7, (Int ((Float (graphicwidth - stringwidth(local54))) - (70.0 * menuscale))), (graphicheight - $32), (0.05 * fpsfactor), loading_frame, 11.0)
    EndIf
    Return $00
End Function
