Function updatemainmenu%()
    Local local0%
    Local local1%
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
    Local local13.servers
    Local local14%
    Local local15$
    Local local17#
    Local local18%
    Local local20%
    Local local21%[14]
    Local local22%[8]
    Local local24%
    Local local26%
    Local local28%
    Local local29%
    Local local30#
    Local local31.players
    Local local32#
    Local local33%
    Local local34%
    Local local35%
    Local local36%
    Local local37%
    Local local38%
    Local local39%
    Local local40#
    Local local41%
    Local local42#
    Local local43#
    Local local44%
    Local local46%
    Local local47%
    Local local48%
    Local local50#
    Local local52$
    Local local54#
    Local local55#
    Local local56.errors
    Local local57#
    Local local58#
    Local local59%
    Local local60%
    Local local61%
    Local local62#
    Local local63$
    Local local64#
    Local local65.servers
    Local local66#
    Local local67#
    Local local68.tempservers[372]
    Local local69%
    Local local70%
    Local local71.servers
    Local local73%
    Local local74%
    Local local75%
    Local local76$
    Local local77%[65]
    Local local78%
    Local local79$
    Local local80%
    Local local81%
    Local local82%
    Local local83%
    Local local84%
    Local local85$
    Local local86%
    Local local87%
    Local local88#
    Local local89#
    Local local90#
    Local local91#
    Local local92%
    Local local93%
    Local local94#
    Local local95#
    Local local96%
    Local local97%
    Local local98.sound
    Local local99%
    Local local100$
    Local local101%
    Local local102%
    Local local104%
    Local local105%
    Local local106%
    Local local107%
    Local local108.workshopthread
    Local local109%
    Local local110%
    Local local111%
    local8 = imagewidth(menu173)
    local9 = imageheight(menu173)
    local10 = (local8 Shr $01)
    local11 = (local9 Shr $01)
    capfps($50)
    If (shouldplay = $15) Then
        endbreathsfx = loadsound("SFX\Ending\MenuBreath.ogg")
        endbreathchn = playsound(endbreathsfx)
        shouldplay = $42
    ElseIf (shouldplay = $42) Then
        If (channelplaying(endbreathchn) = $00) Then
            freesound(endbreathsfx)
            shouldplay = $0B
        EndIf
    Else
        shouldplay = $0B
    EndIf
    clscolor($00, $00, $00, $FF)
    cls()
    drawimage(menuback, $00, $00, $00)
    If ((millisecs() Mod menublinktimer($00)) >= rand(menublinkduration($00), $01)) Then
        drawimage(menu173, (graphicwidth - local9), (graphicheight - local9), $00)
    EndIf
    If (rand($12C, $01) = $01) Then
        menublinktimer($00) = rand($FA0, $1F40)
        menublinkduration($00) = rand($C8, $1F4)
    EndIf
    menublinktimer($01) = (Int ((Float menublinktimer($01)) - fpsfactor))
    If (menublinktimer($01) < menublinkduration($01)) Then
        setcolorraw($323232)
        setfontex(fonts[$00]\Field0)
        text((rand($FFFFFFFB, $05) + menustrx), (rand($FFFFFFFB, $05) + menustry), menustr, $01, $00)
        If (menublinktimer($01) < $00) Then
            menublinktimer($01) = rand($2BC, $320)
            menublinkduration($01) = rand($0A, $23)
            menustrx = imenuscale[rand($2BC, $3E8)]
            menustry = imenuscale[rand($64, $258)]
            Select rand($00, $16)
                Case $00,$02,$03
                    menustr = "DON'T BLINK"
                Case $04,$05
                    menustr = "Secure. Contain. Protect."
                Case $06,$07,$08
                    menustr = "You want happy endings? Fuck you."
                Case $09,$0A,$0B
                    menustr = "Sometimes we would have had time to scream."
                Case $0C,$13
                    menustr = "NIL"
                Case $0D
                    menustr = "NO"
                Case $0E
                    menustr = "black white black white black white gray"
                Case $0F
                    menustr = "Stone does not care"
                Case $10
                    menustr = "9341"
                Case $11
                    menustr = "It controls the doors"
                Case $12
                    menustr = "e8m106]af173o+079m895w914"
                Case $14
                    menustr = "It has taken over everything"
                Case $15
                    menustr = "The spiral is growing"
                Case $16
                    menustr = ((chr($22) + "Some kind of gestalt effect due to massive reality damage.") + chr($22))
            End Select
        EndIf
    EndIf
    drawimage(menutext, (viewport_center_x - (imagewidth(menutext) Shr $01)), ((graphicheight - imenuscale[$14]) - imageheight(menutext)), $00)
    If (graphicwidth > imenuscale[$4D8]) Then
        drawtiledimagerect(menuwhite, $00, $05, 512.0, (Float imenuscale[$07]), imenuscale[$3D9], imenuscale[$197], ((graphicwidth - imenuscale[$4D8]) + $12C), imenuscale[$07])
    EndIf
    If (mousedown1 = $00) Then
        onsliderid = $00
    EndIf
    If (globalserverupdate < millisecs()) Then
        For local13 = Each servers
            If (local13\Field0 = selected_servers) Then
                multiplayer_list_updateserver(local13, $1388, $01)
            EndIf
        Next
        globalserverupdate = (millisecs() + $7530)
    EndIf
    If (mainmenutab = $00) Then
        setfontex(fonts[$01]\Field0)
        For local14 = $00 To $04 Step $01
            local3 = $00
            local1 = imenuscale[$9F]
            local2 = imenuscale[(($64 * local14) + $11E)]
            local4 = imenuscale[$190]
            local5 = imenuscale[$46]
            local0 = (mousehit1 And mouseon(local1, local2, local4, local5))
            If (local0 <> 0) Then
                playsound_strict(buttonsfx)
            EndIf
            Select local14
                Case $00
                    local15 = "MULTIPLAYER"
                    randomseed = ""
                    If (local0 <> 0) Then
                        If (udp_getstream() <> 0) Then
                            mainmenutab = $0E
                        Else
                            For local13 = Each servers
                                If (((local13\Field0 = selected_servers) And (local13\Field17 = selected_page)) <> 0) Then
                                    multiplayer_list_updateserver(local13, $1388, $01)
                                EndIf
                            Next
                            mainmenutab = $01
                            local17 = 0.0
                            For local13 = Each servers
                                If (((local13\Field0 = selected_servers) And (((local13\Field4 = $00) And ((local13\Field0 = $01) Or (local13\Field0 = $05))) = $00)) <> 0) Then
                                    local17 = (local17 + (Float imenuscale[$23]))
                                EndIf
                            Next
                            local5 = imenuscale[$CE]
                            local18 = $96
                            local5 = (local5 + imenuscale[local18])
                            chatscroll = (Int ((- local17) + (Float local5)))
                        EndIf
                        Exit
                    EndIf
                Case $01
                    local15 = "NEW GAME"
                    randomseed = ""
                    If (local0 <> 0) Then
                        If (udp_getstream() <> 0) Then
                            mainmenutab = $0E
                        Else
                            randomseed = setrandomseed()
                            mainmenutab = $14
                        EndIf
                        Exit
                    EndIf
                Case $02
                    local15 = "LOAD GAME"
                    If (local0 <> 0) Then
                        If (udp_getstream() <> 0) Then
                            mainmenutab = $0E
                        Else
                            loadsavegames()
                            mainmenutab = $02
                        EndIf
                        Exit
                    EndIf
                Case $03
                    local15 = "OPTIONS"
                    If (local0 <> 0) Then
                        mainmenutab = $03
                    EndIf
                Case $04
                    local15 = "QUIT"
                    If (local0 <> 0) Then
                        sendstatisticrequest($08)
                        destroywindow()
                    EndIf
            End Select
            drawbutton(local1, local2, local4, local5, local15, $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Next
    Else
        local1 = imenuscale[$9F]
        local2 = imenuscale[$11E]
        local4 = imenuscale[$190]
        local5 = imenuscale[$46]
        local6 = imenuscale[$C8]
        local7 = imenuscale[$23]
        If (shouldexitpage = $01) Then
            networkserver\Field18 = $00
            savemultiplayeroptions()
            Select mainmenutab
                Case $0E
                    mainmenutab = $00
                Case $28
                    mainmenutab = $0E
                Case $15,$17
                    mainmenutab = $0E
                Case $0E
                    mainmenutab = $01
                Case $0C
                    mainmenutab = $01
                Case $09
                    mainmenutab = $01
                Case $01
                    mainmenutab = $00
                Case $02
                    currloadgamepage = $00
                    mainmenutab = $00
                Case $03,$05,$06,$07
                    saveoptionsini()
                    usertrackcheck = $00
                    usertrackcheck2 = $00
                    antialias(opt_antialias)
                    setfontsmooth(opt_antialias)
                    mainmenutab = $00
                Case $04
                    mainmenutab = $14
                    currloadgamepage = $00
                    mousehit1 = $00
                Default
                    mainmenutab = $00
            End Select
            shouldexitpage = $00
            mousehit1 = $00
        EndIf
        local20 = (udp_getstream() * (mainmenutab = $0E))
        If (local20 <> 0) Then
            If (drawbutton(((local1 + local4) + imenuscale[$14]), (local2 + local7), ((imenuscale[$244] - local4) - imenuscale[$14]), (local5 - local7), "DISCONNECT", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                disconnectserver("", $01)
            EndIf
        EndIf
        Select mainmenutab
            Case $14
                drawmenulabel("NEW GAME", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$14A]
                drawframe(local1, local2, local4, local5, $00, $00)
                setfontex(fonts[$00]\Field0)
                text((Int ((20.0 * menuscale) + (Float local1))), (imenuscale[$14] + local2), "Name:", $00, $00)
                currsave = inputbox((imenuscale[$96] + local1), (imenuscale[$0F] + local2), imenuscale[$C8], imenuscale[$1E], currsave, $01, $00, -1.0)
                currsave = left(currsave, $0F)
                currsave = replace(currsave, ":", "")
                currsave = replace(currsave, ".", "")
                currsave = replace(currsave, "/", "")
                currsave = replace(currsave, "\", "")
                currsave = replace(currsave, "<", "")
                currsave = replace(currsave, ">", "")
                currsave = replace(currsave, "|", "")
                currsave = replace(currsave, "?", "")
                currsave = replace(currsave, chr($22), "")
                currsave = replace(currsave, "*", "")
                setcolorraw($FFFFFF)
                If (selectedmap = "") Then
                    text((imenuscale[$14] + local1), (imenuscale[$3C] + local2), "Map seed:", $00, $00)
                    randomseed = left(inputbox((imenuscale[$96] + local1), (imenuscale[$37] + local2), imenuscale[$C8], imenuscale[$1E], randomseed, $03, $00, -1.0), $0F)
                Else
                    text((imenuscale[$14] + local1), (imenuscale[$3C] + local2), "Selected map:", $00, $00)
                    setcolorraw($FFFFFF)
                    rect((imenuscale[$96] + local1), (imenuscale[$37] + local2), imenuscale[$C8], imenuscale[$1E], $01)
                    setcolorraw($00)
                    rect(((imenuscale[$96] + local1) + $02), ((imenuscale[$37] + local2) + $02), (imenuscale[$C8] - $04), (imenuscale[$1E] - $04), $01)
                    setcolorraw($FF0000)
                    If (len(selectedmap) > $0F) Then
                        text(((imenuscale[$96] + local1) + imenuscale[$64]), ((imenuscale[$37] + local2) + imenuscale[$0F]), (left(selectedmap, $0E) + "..."), $01, $01)
                    Else
                        text(((imenuscale[$96] + local1) + imenuscale[$64]), ((imenuscale[$37] + local2) + imenuscale[$0F]), selectedmap, $01, $01)
                    EndIf
                    If (drawbutton((imenuscale[$172] + local1), (imenuscale[$37] + local2), imenuscale[$78], imenuscale[$1E], "Deselect", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        selectedmap = ""
                    EndIf
                EndIf
                text((imenuscale[$14] + local1), (imenuscale[$6E] + local2), "Enable intro sequence:", $00, $00)
                introenabled = drawtick((imenuscale[$118] + local1), (imenuscale[$6E] + local2), introenabled, $00)
                For local24 = $00 To $03 Step $01
                    If (drawtick((imenuscale[$14] + local1), (imenuscale[(($1E * local24) + $B4)] + local2), (selecteddifficulty = difficulties(local24)), $00) <> 0) Then
                        selecteddifficulty = difficulties(local24)
                    EndIf
                    setcolorex(difficulties(local24)\Field6, difficulties(local24)\Field7, difficulties(local24)\Field8)
                    text((imenuscale[$3C] + local1), (imenuscale[(($1E * local24) + $B4)] + local2), difficulties(local24)\Field0, $00, $00)
                Next
                setcolorraw($FFFFFF)
                text((imenuscale[$14] + local1), (imenuscale[$96] + local2), "Difficulty:", $00, $00)
                drawframe((imenuscale[$96] + local1), (imenuscale[$9B] + local2), imenuscale[$19A], imenuscale[$96], $00, $00)
                If (selecteddifficulty\Field9 <> 0) Then
                    selecteddifficulty\Field2 = drawtick((imenuscale[$A0] + local1), (imenuscale[$A5] + local2), selecteddifficulty\Field2, $00)
                    text((imenuscale[$C8] + local1), (imenuscale[$A5] + local2), "Permadeath", $00, $00)
                    If (drawtick((imenuscale[$A0] + local1), (imenuscale[$C3] + local2), ((selecteddifficulty\Field4 = $00) And (selecteddifficulty\Field2 = $00)), selecteddifficulty\Field2) <> 0) Then
                        selecteddifficulty\Field4 = $00
                    Else
                        selecteddifficulty\Field4 = $02
                    EndIf
                    text((imenuscale[$C8] + local1), (imenuscale[$C3] + local2), "Save anywhere", $00, $00)
                    selecteddifficulty\Field3 = drawtick((imenuscale[$A0] + local1), (imenuscale[$E1] + local2), selecteddifficulty\Field3, $00)
                    text((imenuscale[$C8] + local1), (imenuscale[$E1] + local2), "Aggressive NPCs", $00, $00)
                    setcolorraw($FFFFFF)
                    drawimage(arrowimg($01), (imenuscale[$9B] + local1), (imenuscale[$FB] + local2), $00)
                    If (mousehit1 <> 0) Then
                        If (imagerectoverlap(arrowimg($01), (imenuscale[$9B] + local1), (imenuscale[$FB] + local2), mouseposx, mouseposy, $00, $00) <> 0) Then
                            If (selecteddifficulty\Field5 < $02) Then
                                selecteddifficulty\Field5 = (selecteddifficulty\Field5 + $01)
                            Else
                                selecteddifficulty\Field5 = $00
                            EndIf
                            playsound_strict(buttonsfx)
                        EndIf
                    EndIf
                    setcolorraw($FFFFFF)
                    Select selecteddifficulty\Field5
                        Case $00
                            text((imenuscale[$C8] + local1), (imenuscale[$FF] + local2), "Other difficulty factors: Easy", $00, $00)
                        Case $01
                            text((imenuscale[$C8] + local1), (imenuscale[$FF] + local2), "Other difficulty factors: Normal", $00, $00)
                        Case $02
                            text((imenuscale[$C8] + local1), (imenuscale[$FF] + local2), "Other difficulty factors: Hard", $00, $00)
                    End Select
                Else
                    rowtext(selecteddifficulty\Field1, (Float (imenuscale[$A0] + local1)), (Float (imenuscale[$A0] + local2)), (Float imenuscale[$186]), 200.0, $00, 1.0, $00)
                EndIf
                If (drawbutton(local1, ((local2 + local5) + imenuscale[$14]), imenuscale[$A0], imenuscale[$46], "Load map", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $04
                    loadsavedmaps()
                EndIf
                setfontex(fonts[$01]\Field0)
                If (drawbutton((imenuscale[$1A4] + local1), ((local2 + local5) + imenuscale[$14]), imenuscale[$A0], imenuscale[$46], "START", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    If (currsave = "") Then
                        currsave = "untitled"
                    EndIf
                    If (randomseed = "") Then
                        randomseed = (Str ((millisecs() Xor (- (millisecs() < 0))) - (- (millisecs() < 0))))
                    EndIf
                    seedrnd(generateseednumber(randomseed))
                    local26 = $00
                    For local24 = $01 To savegameamount Step $01
                        If ((((local26 = $00) And (savegames((local24 - $01)) = currsave)) Or ((local26 > $00) And (savegames((local24 - $01)) = (((currsave + " (") + (Str (local26 + $01))) + ")")))) <> 0) Then
                            local26 = (local26 + $01)
                            local24 = $00
                        EndIf
                    Next
                    If (local26 > $00) Then
                        currsave = (((currsave + " (") + (Str (local26 + $01))) + ")")
                    EndIf
                    loadentities()
                    loadallsounds()
                    initnewgame()
                    mainmenuopen = $00
                    flushkeys()
                    flushmouse()
                    putinivalue("options.ini", "options", "intro enabled", (Str introenabled))
                EndIf
            Case $20
                drawmenulabel("MICROPHONE INPUTS", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$18C]
                local4 = imenuscale[$244]
                local5 = imenuscale[$14A]
                drawframe(local1, local2, local4, (imenuscale[$3C] + local5), $00, $00)
                setfontex(fonts[$00]\Field0)
                For local24 = $00 To (snd_in_count() - $01) Step $01
                    setcolorraw($FF00)
                    If (voice\Field9 = local24) Then
                        text((Int (((Float ((stringwidth(snd_in_name($00)) Shl $01) + $0A)) * menuscale) + (Float local1))), (Int (((Float ((local24 + $01) * $14)) * menuscale) + (Float local2))), "SELECTED", $00, $00)
                    EndIf
                    setcolorraw($FFFFFF)
                    If (drawbutton((imenuscale[$0A] + local1), (imenuscale[((local24 + $01) * $14)] + local2), (Int ((Float (stringwidth(snd_in_name($00)) Shl $01)) * menuscale)), (Int (((Float stringheight(snd_in_name($00))) * 1.5) * menuscale)), snd_in_name($00), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        voice\Field9 = local24
                    EndIf
                Next
            Case $0C,$15
                drawmenulabel("SETTINGS", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$14A]
                local6 = imenuscale[$122]
                local7 = imenuscale[$A5]
                drawframe(local1, local2, local4, (imenuscale[$3C] + local5), $00, $00)
                setfontex(fonts[$00]\Field0)
                If (drawbutton(local1, local2, local6, imenuscale[$1E], "MULTIPLAYER", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selectedsettings = $00
                EndIf
                If (drawbutton((local1 + local6), local2, local6, imenuscale[$1E], "VOICE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selectedsettings = $01
                EndIf
                Select selectedsettings
                    Case $00
                        local2 = (local2 + imenuscale[$14])
                        text((imenuscale[$14] + local1), (imenuscale[$28] + local2), "Name:", $00, $00)
                        If (udp_getstream() = $00) Then
                            nickname = left(inputbox((imenuscale[$73] + local1), (imenuscale[$23] + local2), imenuscale[$FA], imenuscale[$1E], nickname, $01, $00, -1.0), $18)
                        Else
                            setcolorraw($FF0000)
                            text((imenuscale[$73] + local1), (imenuscale[$0F] + local2), "Name change not available", $00, $00)
                            setcolorraw($FFFFFF)
                            inputbox((imenuscale[$73] + local1), (imenuscale[$23] + local2), imenuscale[$FA], imenuscale[$1E], nickname, $01, $00, -1.0)
                        EndIf
                        text((imenuscale[$14] + local1), (imenuscale[$50] + local2), "See players HUD:", $00, $00)
                        networkserver\Field52\Field11 = (drawtick((imenuscale[$FA] + local1), (imenuscale[$50] + local2), networkserver\Field52\Field11, $00) <> $00)
                        If (mouseon((imenuscale[$FA] + local1), (imenuscale[$50] + local2), imenuscale[$14], imenuscale[$14]) <> 0) Then
                            drawoptionstoolimage((imenuscale[$244] + local1), local2, imenuscale[$96], imenuscale[$F6], mpimg\Field5[networkserver\Field52\Field11])
                        EndIf
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), (imenuscale[$6E] + local2), ("Bandwith (kbps): " + (Str (Int networkserver\Field31))), $00, $00)
                        networkserver\Field31 = (slidebar((imenuscale[$FA] + local1), (imenuscale[$6E] + local2), imenuscale[$96], (networkserver\Field31 * 0.012), $00, 0.0, 100.0, $00) * (1.0 / 0.012))
                        If (((512.0 > networkserver\Field31) Or (8334.0 < networkserver\Field31)) <> 0) Then
                            networkserver\Field31 = 512.0
                        EndIf
                        text((imenuscale[$14] + local1), (imenuscale[$8C] + local2), "Voice chat:", $00, $00)
                        local28 = (0.0 <> mainplayersvolume)
                        local29 = drawtick((imenuscale[$FA] + local1), (imenuscale[$8C] + local2), local28, $00)
                        If (local29 <> local28) Then
                            If (local28 = $01) Then
                                mainplayersvolume = 0.0
                            Else
                                mainplayersvolume = 1.0
                            EndIf
                        EndIf
                        local30 = mainplayersvolume
                        mainplayersvolume = (slidebar((imenuscale[$FA] + local1), (imenuscale[$AA] + local2), imenuscale[$96], (mainplayersvolume * 100.0), $00, 0.0, 100.0, $00) * 0.01)
                        text((imenuscale[$14] + local1), (imenuscale[$AA] + local2), ("Players volume: " + (Str (Int (mainplayersvolume * 100.0)))), $00, $00)
                        If (mainplayersvolume <> local30) Then
                            For local31 = Each players
                                local31\Field63 = mainplayersvolume
                            Next
                        EndIf
                        setfontex(fonts[$00]\Field0)
                        If (drawbutton((imenuscale[$14] + local1), (imenuscale[$C8] + local2), imenuscale[$E6], imenuscale[$19], "Reload server list", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            For local13 = Each servers
                                multiplayer_list_deleteserver(local13)
                            Next
                            selectserver = $FFFFFFFF
                            loadsavedservers()
                            initmultiplayer($04, $01)
                            For local24 = $00 To $0A Step $01
                                For local1 = $00 To $04 Step $01
                                    serverpages[local24]\Field0[local1] = $FFFFFFFF
                                Next
                            Next
                        EndIf
                    Case $01
                        If (voice\Field3 <> 0) Then
                            local32 = voice\Field6
                            voice\Field6 = (slidebar((imenuscale[$14] + local1), (imenuscale[$6E] + local2), imenuscale[$96], (voice\Field6 * 100.0), $00, 0.0, 100.0, $00) / 100.0)
                            text((imenuscale[$32] + local1), (imenuscale[$5A] + local2), ("Volume: " + (Str (Int (voice\Field6 * 100.0)))), $00, $00)
                            setcolorex($00, $FF, $00)
                            text((imenuscale[$14] + local1), (imenuscale[$32] + local2), ("Current input: " + fsound_record_getdrivername($01)), $00, $00)
                        Else
                            setcolorex($FF, $00, $00)
                            text((imenuscale[$14] + local1), (imenuscale[$32] + local2), "Microphone not connected", $00, $00)
                        EndIf
                        If (drawbutton((imenuscale[$14] + local1), (imenuscale[$96] + local2), imenuscale[$C8], (Int (60.0 * menuscale)), "CHECK MICROPHONE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            networkserver\Field18 = (networkserver\Field18 = $00)
                            If (udp_getstream() = $00) Then
                                networkserver\Field52\Field13 = $BB80
                            EndIf
                        EndIf
                        local33 = (imenuscale[$14] + local1)
                        local34 = (imenuscale[$E6] + local2)
                        local35 = (imenuscale[$14] + local1)
                        local36 = (imenuscale[$E6] + local2)
                        drawframeblack(local35, local36, imenuscale[$32], imenuscale[$32], $00, $00)
                        local36 = (local36 + imenuscale[$32])
                        setcolorex($F1, $18, $4F)
                        renderprogressbary(local35, local36, imenuscale[$32], imenuscale[$32], 0.2, max(voice\Field16, 0.0))
                        If (networkserver\Field18 <> 0) Then
                            voice\Field16 = curvevalue((voice_get_offset() - 0.74), voice\Field16, 7.0)
                            drawimage(mpimg\Field0, local33, local34, $00)
                        Else
                            voice\Field16 = curvevalue(0.0, voice\Field16, 7.0)
                            drawimage(mpimg\Field1, local33, local34, $00)
                        EndIf
                        setcolorex($FF, $FF, $FF)
                        text((imenuscale[$14] + local1), (imenuscale[$163] + local2), "Push-to-talk:", $00, $00)
                        voice\Field14 = drawtick((imenuscale[$A5] + local1), (imenuscale[$163] + local2), voice\Field14, $00)
                        If (drawbutton((Int ((20.0 * menuscale) + (Float local1))), (Int ((310.0 * menuscale) + (Float local2))), (Int (180.0 * menuscale)), (Int (30.0 * menuscale)), "RESTART VOICE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            voice_remove()
                            voice_init()
                            networkserver\Field52\Field13 = $BB80
                        EndIf
                End Select
            Case $01
                drawmenulabel("MULTIPLAYER", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$9F]
                local2 = imenuscale[$1A8]
                local4 = imenuscale[$25E]
                local5 = imenuscale[$CE]
                local6 = imenuscale[$12F]
                local7 = imenuscale[$67]
                local18 = $96
                local5 = (local5 + imenuscale[local18])
                local17 = 0.0
                local37 = $00
                For local13 = Each servers
                    If (((local13\Field0 = selected_servers) And (((local13\Field4 = $00) And ((local13\Field0 = $01) Or (local13\Field0 = $05))) = $00)) <> 0) Then
                        local17 = (local17 + (Float imenuscale[$23]))
                    EndIf
                Next
                If (0.0 <> local17) Then
                    local37 = (Int (((Float local5) / local17) * (Float local5)))
                    If (local37 > local5) Then
                        local37 = local5
                    EndIf
                    If ((Float local5) > local17) Then
                        local17 = (Float local5)
                    EndIf
                    setcolorraw($C8C8C8)
                    local38 = mouseon(((local1 + local4) - imenuscale[$1A]), (local2 - imenuscale[$02]), imenuscale[$1A], (imenuscale[$02] + local5))
                    drawframe(((local1 + local4) - imenuscale[$1A]), (local2 - imenuscale[$02]), imenuscale[$1A], (imenuscale[$02] + local5), $00, $00)
                    setcolorraw($646464)
                    local39 = mouseon(((local1 + local4) - imenuscale[$17]), (((local2 + local5) - local37) + ((chatscroll * local37) / local5)), imenuscale[$14], local37)
                    If (local39 <> 0) Then
                        setcolorraw($787878)
                    EndIf
                    If (chatscrolldragging <> 0) Then
                        setcolorraw($828282)
                    EndIf
                    rect(((local1 + local4) - imenuscale[$17]), ((((local2 + local5) - local37) + ((chatscroll * local37) / local5)) + imenuscale[$01]), imenuscale[$14], (local37 - imenuscale[$04]), $01)
                    If (mousedown($01) = $00) Then
                        chatscrolldragging = $00
                    ElseIf (chatscrolldragging <> 0) Then
                        chatscroll = (chatscroll + (((mouseposy - chatmousemem) * local5) / local37))
                        chatmousemem = mouseposy
                    EndIf
                    If (chatscrolldragging = $00) Then
                        If (mousehit1 <> 0) Then
                            If (local39 <> 0) Then
                                chatscrolldragging = $01
                                chatmousemem = mouseposy
                            ElseIf (local38 <> 0) Then
                                chatscroll = (Int (((((Float (mouseposy - (local2 + local5))) * local17) / (Float local5)) + (Float local7)) + (Float chatscroll)))
                                chatscroll = (Int ((Float chatscroll) * 0.5))
                            EndIf
                        EndIf
                    EndIf
                    local40 = (Float mousezspeed())
                    If (0.0 < local40) Then
                        chatscroll = (chatscroll - imenuscale[$0F])
                    ElseIf (0.0 > local40) Then
                        chatscroll = (chatscroll + imenuscale[$0F])
                    EndIf
                    If ((Float chatscroll) < ((- local17) + (Float local5))) Then
                        chatscroll = (Int ((- local17) + (Float local5)))
                    EndIf
                    If (chatscroll > $00) Then
                        chatscroll = $00
                    EndIf
                    local42 = sqrvalue((((- local17) + (Float local5)) - (Float chatscroll)))
                    local43 = (Float (imenuscale[$23] + local2))
                    For local13 = Each servers
                        local13\Field17 = $01
                        If (((local13\Field0 = selected_servers) And (((local13\Field4 = $00) And ((local13\Field0 = $01) Or (local13\Field0 = $05))) = $00)) <> 0) Then
                            If (local43 >= (((Float local2) + local42) - (Float imenuscale[$23]))) Then
                                If (local43 <= (((Float (local2 + local5)) + local42) + (Float imenuscale[$46]))) Then
                                    local13\Field17 = $00
                                EndIf
                            EndIf
                            local43 = (local43 + (Float imenuscale[$23]))
                        EndIf
                    Next
                EndIf
                setfontex(fonts[$00]\Field0)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$18B]
                local4 = imenuscale[$320]
                local5 = imenuscale[$14F]
                drawframe(local1, local2, local4, (Int (((Float ((((selected_servers <> $01) And (selected_servers <> $05)) * $2A) + local18)) * menuscale) + (Float local5))), $00, $00)
                drawframe((imenuscale[$190] + local1), local2, imenuscale[$02], imenuscale[$32], $00, $00)
                drawframe((imenuscale[$1F4] + local1), local2, imenuscale[$02], imenuscale[$32], $00, $00)
                drawframe((imenuscale[$28A] + local1), local2, imenuscale[$02], imenuscale[$32], $00, $00)
                drawframe(local1, (imenuscale[$19] + local2), local4, imenuscale[$02], $00, $00)
                If (drawbaldbutton((imenuscale[$01] + local1), (imenuscale[$02] + local2), imenuscale[$190], imenuscale[$18], " ", $00, $00, $01) <> 0) Then
                    local44 = $01
                EndIf
                If (drawbaldbutton((imenuscale[$190] + local1), (imenuscale[$02] + local2), imenuscale[$64], imenuscale[$18], " ", $00, $00, $01) <> 0) Then
                    local44 = $02
                EndIf
                If (drawbaldbutton((imenuscale[$1F4] + local1), (imenuscale[$02] + local2), imenuscale[$96], imenuscale[$18], " ", $00, $00, $01) <> 0) Then
                    local44 = $03
                EndIf
                If (drawbaldbutton((imenuscale[$28A] + local1), (imenuscale[$02] + local2), imenuscale[$96], imenuscale[$18], " ", $00, $00, $01) <> 0) Then
                    local44 = $04
                EndIf
                If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] >= $00) Then
                    Select serverpages[selected_servers]\Field1
                        Case $01
                            drawimage(mpimg\Field6[serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1]], (imenuscale[$172] + local1), (imenuscale[$08] + local2), $00)
                        Case $02
                            drawimage(mpimg\Field6[serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1]], (imenuscale[$1DB] + local1), (imenuscale[$08] + local2), $00)
                        Case $03
                            drawimage(mpimg\Field6[serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1]], (imenuscale[$271] + local1), (imenuscale[$08] + local2), $00)
                        Case $04
                            drawimage(mpimg\Field6[serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1]], (imenuscale[$307] + local1), (imenuscale[$08] + local2), $00)
                    End Select
                EndIf
                setcolorraw($FFFFFF)
                setfontex(fonts[$00]\Field0)
                text((imenuscale[$0A] + local1), (imenuscale[$08] + local2), "Servers", $00, $00)
                text((imenuscale[$19A] + local1), (imenuscale[$08] + local2), "Players", $00, $00)
                text((imenuscale[$1FE] + local1), (imenuscale[$08] + local2), "Map", $00, $00)
                text((imenuscale[$294] + local1), (imenuscale[$08] + local2), "Ping", $00, $00)
                For local24 = $00 To $0D Step $01
                    If (local21[local24] = $01) Then
                        If (selected_page = local24) Then
                            drawbutton((Int (((Float (((local24 + $01) * $23) + $14)) * menuscale) + (Float local1))), (Int (((Float (($104 + local18) - $28)) * menuscale) + (Float local2))), imenuscale[$14], imenuscale[$14], (Str (local24 + $01)), $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        ElseIf (drawbutton((Int (((Float (((local24 + $01) * $23) + $14)) * menuscale) + (Float local1))), (Int (((Float (($104 + local18) - $28)) * menuscale) + (Float local2))), imenuscale[$14], imenuscale[$14], (Str (local24 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            selected_page = local24
                            mousehit1 = $00
                        EndIf
                        drawframe((imenuscale[$14] + local1), (imenuscale[($FA + local18)] + local2), (local4 - imenuscale[$28]), $02, $00, $00)
                    EndIf
                Next
                local47 = (- imenuscale[$05])
                local41 = $00
                local48 = $01
                For local13 = Each servers
                    If ((((local13\Field0 = selected_servers) And (local13\Field17 = selected_page)) And (local41 < $0C)) <> 0) Then
                        local46 = $00
                        If (local13\Field19 <> 0) Then
                            local46 = (local46 + $0C)
                        EndIf
                        If ((local13\Field7 And local13\Field25) <> 0) Then
                            local46 = (local46 + $0D)
                        EndIf
                        Select selected_servers
                            Case $01,$05,$04
                                If (local13\Field4 <> $00) Then
                                    local41 = (local41 + $01)
                                    local47 = (local47 + $1E)
                                    local50 = sfxvolume
                                    If (((((connectmenu = $00) And (passwordmenu = $00)) And (servermenuopen = $00)) And (addservermenu = $00)) = $00) Then
                                        sfxvolume = 0.0
                                    EndIf
                                    If (drawbutton(local1, (Int (((Float (local47 - $00)) * menuscale) + (Float local2))), local4, imenuscale[$1E], "", $00, $00, $01, (Handle local13), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                        If (((((connectmenu = $00) And (passwordmenu = $00)) And (servermenuopen = $00)) And (addservermenu = $00)) <> 0) Then
                                            selectserver = (Handle local13)
                                            If (doubleclick <> 0) Then
                                                servermenuopen = (servermenuopen = $00)
                                                doubleclick = $00
                                                multiplayer_list_updateserver(local13, $BB8, $02)
                                            Else
                                                multiplayer_list_updateserver(local13, $BB8, $03)
                                            EndIf
                                        EndIf
                                    EndIf
                                    sfxvolume = local50
                                    Select local13\Field9
                                        Case "Started"
                                            setcolorraw($FFFF00)
                                        Case "Password"
                                            setcolorraw($FF0000)
                                        Case "In lobby"
                                            setcolorraw($FF00)
                                        Case "Offline"
                                            setcolorraw($FFFFFF)
                                        Default
                                            setcolorraw($FFFFFF)
                                    End Select
                                    oval((imenuscale[$0F] + local1), (Int (((Float (local47 + $0C)) * menuscale) + (Float local2))), imenuscale[$06], imenuscale[$06], $01)
                                    setcolorraw($FFFFFF)
                                    For local24 = $01 To $01 Step $01
                                    Next
                                    If ((local13\Field7 And local13\Field25) <> 0) Then
                                        drawimage(mpimg\Field3, (imenuscale[$1E] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), $00)
                                        If (mouseon((imenuscale[$1E] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), imagewidth(mpimg\Field3), imageheight(mpimg\Field3)) <> 0) Then
                                            setfontex(fonts[$00]\Field0)
                                            drawtextrect((imenuscale[$1E] + local1), (Int (((Float (local47 - $05)) * menuscale) + (Float local2))), imenuscale[$55], imenuscale[$14], "Protected")
                                            setfontex(fonts[$00]\Field0)
                                        EndIf
                                    EndIf
                                    If (local13\Field19 <> 0) Then
                                        drawimage(mpimg\Field4, (Int (((Float ($14 + local46)) * menuscale) + (Float local1))), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), $00)
                                        If (mouseon((Int (((Float ($14 + local46)) * menuscale) + (Float local1))), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), imagewidth(mpimg\Field4), imageheight(mpimg\Field4)) <> 0) Then
                                            setfontex(fonts[$00]\Field0)
                                            drawtextrect((Int (((Float ($14 + local46)) * menuscale) + (Float local1))), (Int (((Float (local47 - $05)) * menuscale) + (Float local2))), imenuscale[$55], imenuscale[$14], "Voice chat")
                                            setfontex(fonts[$00]\Field0)
                                        EndIf
                                    EndIf
                                    If (mouseon((imenuscale[$0F] + local1), (Int (((Float (local47 + $0C)) * menuscale) + (Float local2))), imenuscale[$07], imenuscale[$07]) <> 0) Then
                                        setfontex(fonts[$00]\Field0)
                                        drawtextrect((local1 - imenuscale[$0F]), (Int ((((Float local47) - 10.4) * menuscale) + (Float local2))), imenuscale[$50], imenuscale[$14], local13\Field9)
                                        setfontex(fonts[$00]\Field0)
                                    EndIf
                                    setcolorraw($FFFFFF)
                                    setfontex(fonts[$00]\Field0)
                                    formattext((((Float ($26 + local46)) * menuscale) + (Float local1)), (((Float (local47 + $0B)) * menuscale) + (Float local2)), local13\Field10, $00, $00, 1.0, $00)
                                    setfontex(fonts[$00]\Field0)
                                    text((imenuscale[$19A] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), local13\Field6, $00, $00)
                                    text((imenuscale[$1FE] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), local13\Field5, $00, $00)
                                    local52 = (Str local13\Field4)
                                    If (local13\Field4 = $00) Then
                                        local52 = "-"
                                    EndIf
                                    text((imenuscale[$294] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), local52, $00, $00)
                                EndIf
                            Case $03,$06
                                local41 = (local41 + $01)
                                local47 = (local47 + $1E)
                                local50 = sfxvolume
                                If (((((connectmenu = $00) And (passwordmenu = $00)) And (servermenuopen = $00)) And (addservermenu = $00)) = $00) Then
                                    sfxvolume = 0.0
                                EndIf
                                If (drawbutton(local1, (Int (((Float (local47 - $00)) * menuscale) + (Float local2))), local4, imenuscale[$1E], "", $00, $00, $01, (Handle local13), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    If (((((connectmenu = $00) And (passwordmenu = $00)) And (servermenuopen = $00)) And (addservermenu = $00)) <> 0) Then
                                        selectserver = (Handle local13)
                                        If (doubleclick <> 0) Then
                                            servermenuopen = (servermenuopen = $00)
                                            doubleclick = $00
                                            multiplayer_list_updateserver(local13, $BB8, $02)
                                        Else
                                            multiplayer_list_updateserver(local13, $BB8, $03)
                                        EndIf
                                    EndIf
                                EndIf
                                sfxvolume = local50
                                Select local13\Field9
                                    Case "Started"
                                        setcolorraw($FFFF00)
                                    Case "Password"
                                        setcolorraw($FF0000)
                                    Case "In lobby"
                                        setcolorraw($FF00)
                                    Case "Offline"
                                        setcolorraw($FFFFFF)
                                    Default
                                        setcolorraw($FFFFFF)
                                End Select
                                oval((imenuscale[$0F] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), imenuscale[$06], imenuscale[$06], $01)
                                setcolorraw($FFFFFF)
                                For local24 = $01 To $01 Step $01
                                Next
                                If ((local13\Field7 And local13\Field25) <> 0) Then
                                    drawimage(mpimg\Field3, (imenuscale[$1E] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), $00)
                                    If (mouseon((imenuscale[$1E] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), imagewidth(mpimg\Field3), imageheight(mpimg\Field3)) <> 0) Then
                                        setfontex(fonts[$00]\Field0)
                                        drawtextrect((imenuscale[$1E] + local1), (Int (((Float (local47 - $05)) * menuscale) + (Float local2))), imenuscale[$55], imenuscale[$14], "Protected")
                                        setfontex(fonts[$00]\Field0)
                                    EndIf
                                EndIf
                                If (local13\Field19 <> 0) Then
                                    drawimage(mpimg\Field4, (Int (((Float ($14 + local46)) * menuscale) + (Float local1))), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), $00)
                                    If (mouseon((Int (((Float ($14 + local46)) * menuscale) + (Float local1))), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), imagewidth(mpimg\Field4), imageheight(mpimg\Field4)) <> 0) Then
                                        setfontex(fonts[$00]\Field0)
                                        drawtextrect((Int (((Float ($14 + local46)) * menuscale) + (Float local1))), (Int (((Float (local47 - $05)) * menuscale) + (Float local2))), imenuscale[$55], imenuscale[$14], "Voice chat")
                                        setfontex(fonts[$00]\Field0)
                                    EndIf
                                EndIf
                                If (mouseon((imenuscale[$0F] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), imenuscale[$07], imenuscale[$07]) <> 0) Then
                                    setfontex(fonts[$00]\Field0)
                                    drawtextrect((local1 - imenuscale[$0F]), (Int ((((Float local47) - 9.28) * menuscale) + (Float local2))), imenuscale[$50], imenuscale[$14], local13\Field9)
                                    setfontex(fonts[$00]\Field0)
                                EndIf
                                setcolorraw($FFFFFF)
                                setfontex(fonts[$00]\Field0)
                                formattext((((Float ($26 + local46)) * menuscale) + (Float local1)), (((Float (local47 + $0B)) * menuscale) + (Float local2)), local13\Field10, $00, $00, 1.0, $00)
                                setfontex(fonts[$00]\Field0)
                                text((imenuscale[$12C] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), local13\Field6, $00, $00)
                                text((imenuscale[$190] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), local13\Field5, $00, $00)
                                local52 = (Str local13\Field4)
                                If (local13\Field4 = $00) Then
                                    local52 = "-"
                                EndIf
                                text((imenuscale[$1F4] + local1), (Int (((Float (local47 + $0B)) * menuscale) + (Float local2))), local52, $00, $00)
                        End Select
                    EndIf
                Next
                local48 = $00
                setfontex(fonts[$00]\Field0)
                If (local41 = $00) Then
                    text((local1 + $19), (imenuscale[$23] + local2), "Server list is clear.", $00, $00)
                EndIf
                setcolorraw($FFFFFF)
                local55 = 0.0
                For local56 = Each errors
                    local55 = (((Float (stringheight(local56\Field0) * getlineamount(local56\Field0, imenuscale[$FA], $FFFFFFFF, 1.0))) + local55) + (Float imenuscale[$0A]))
                Next
                For local56 = Each errors
                    If (0.0 = local54) Then
                        selectserver = $FFFFFFFF
                        drawframe((imenuscale[$244] + local1), local2, imenuscale[$FA], (Int (local55 + (Float imenuscale[$04]))), $00, $00)
                    EndIf
                    setfontex(fonts[$00]\Field0)
                    setcolorex(local56\Field2, local56\Field3, local56\Field4)
                    rowtext(local56\Field0, (Float (imenuscale[$244] + local1)), ((Float (imenuscale[$05] + local2)) + local54), (Float imenuscale[$FA]), (local55 + (Float imenuscale[$04])), $01, 0.0, $00)
                    setcolorraw($FFFFFF)
                    local54 = (((Float (stringheight(local56\Field0) * getlineamount(local56\Field0, imenuscale[$FA], (Int (local55 + (Float imenuscale[$04]))), 1.0))) + local54) + (Float imenuscale[$0A]))
                Next
                setfontex(fonts[$00]\Field0)
                If (0.0 < local54) Then
                    drawbutton((imenuscale[$33E] + local1), local2, imenuscale[$50], imenuscale[$1E], "CLOSE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                EndIf
                If (drawbutton((imenuscale[$78] + local1), (Int (((Float ($12C + local18)) * menuscale) + (Float local2))), imenuscale[$96], imenuscale[$14], "DIRECT CONNECT", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    multiplayer_masterserverset("", "")
                    connectmenu = (connectmenu = $00)
                    addservermenu = $00
                    passwordmenu = $00
                EndIf
                If (drawbutton((imenuscale[$78] + local1), (Int (((Float ($104 + local18)) * menuscale) + (Float local2))), imenuscale[$96], imenuscale[$14], "JOIN SERVER", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    If (selectserver <> $FFFFFFFF) Then
                        For local13 = Each servers
                            If ((Handle local13) = selectserver) Then
                                multiplayer_masterserverset(local13\Field1, local13\Field2)
                                multiplayer_connectto(local13\Field1, (Int local13\Field2), "", $00, $1388)
                                Exit
                            EndIf
                        Next
                        selectserver = $FFFFFFFF
                    EndIf
                EndIf
                If (selected_servers = $06) Then
                    If (drawbutton((imenuscale[$78] + local1), (Int (((Float ($154 + local18)) * menuscale) + (Float local2))), imenuscale[$96], imenuscale[$14], "ADD SERVER", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        multiplayer_masterserverset("", "")
                        addservermenu = (addservermenu = $00)
                        connectmenu = $00
                        passwordmenu = $00
                    EndIf
                EndIf
                If (((selected_servers <> $01) And (selected_servers <> $05)) <> 0) Then
                    If (drawbutton((imenuscale[$145] + local1), (Int (((Float ($12C + local18)) * menuscale) + (Float local2))), imenuscale[$96], imenuscale[$14], "DELETE SERVER", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        If (selectserver <> $FFFFFFFF) Then
                            multiplayer_list_deleteserver((Object.servers selectserver))
                            selectserver = $FFFFFFFF
                        EndIf
                    EndIf
                    If (drawbutton((imenuscale[$145] + local1), (Int (((Float ($154 + local18)) * menuscale) + (Float local2))), imenuscale[$96], imenuscale[$14], "SETTINGS", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        mainmenutab = $0C
                    EndIf
                ElseIf (drawbutton((imenuscale[$145] + local1), (Int (((Float ($12C + local18)) * menuscale) + (Float local2))), imenuscale[$96], imenuscale[$14], "SETTINGS", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $0C
                EndIf
                If (drawbutton((imenuscale[$145] + local1), (Int (((Float ($104 + local18)) * menuscale) + (Float local2))), imenuscale[$96], imenuscale[$14], "REFRESH SERVER", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    If (selectserver <> $FFFFFFFF) Then
                        multiplayer_list_updateserver((Object.servers selectserver), $1388, $01)
                    EndIf
                EndIf
                If (drawbutton((imenuscale[$1FE] + local1), (Int (((Float ($104 + local18)) * menuscale) + (Float local2))), imenuscale[$AA], imenuscale[$14], host_server_button_text, fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $09
                EndIf
                If (drawbutton((imenuscale[$1FE] + local1), (Int (((Float ($12C + local18)) * menuscale) + (Float local2))), imenuscale[$AA], imenuscale[$14], "RENT A SERVER", fonts[$00]\Field0, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    execfile("https://zap-hosting.com/containmentbreachmp")
                EndIf
                setcolorraw($FFFFFF)
                setfontex(fonts[$00]\Field0)
                If (connectmenu <> 0) Then
                    local57 = (Float ((local1 + local6) - $64))
                    local58 = (Float ((local2 + local7) - $50))
                    drawframe((Int local57), (Int local58), imenuscale[$FA], imenuscale[$96], $00, $00)
                    text((Int (local57 + (Float imenuscale[$14]))), (Int (local58 + (Float imenuscale[$0A]))), "IP:", $00, $00)
                    text((Int (local57 + (Float imenuscale[$14]))), (Int (local58 + (Float imenuscale[$32]))), "Port:", $00, $00)
                    multiplayer_masterserverset(left(inputbox((Int (local57 + (Float imenuscale[$3C]))), (Int (local58 + (Float imenuscale[$0A]))), imenuscale[$82], imenuscale[$19], multiplayer_masterservergetip(), $36, $00, -1.0), $14), left(inputbox((Int (local57 + (Float imenuscale[$46]))), (Int (local58 + (Float imenuscale[$32]))), imenuscale[$50], imenuscale[$19], multiplayer_masterservergetport(), $37, $00, -1.0), $05))
                    If (drawbutton((Int (local57 + (Float imenuscale[$14]))), (Int (local58 + (Float imenuscale[$64]))), imenuscale[$50], imenuscale[$1E], "CONNECT", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        multiplayer_connectto(multiplayer_masterservergetip(), (Int multiplayer_masterservergetport()), "", $00, $1388)
                    EndIf
                    If (drawbutton((Int (local57 + (Float imenuscale[$96]))), (Int (local58 + (Float imenuscale[$64]))), imenuscale[$50], imenuscale[$1E], "CLOSE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        connectmenu = $00
                    EndIf
                ElseIf (addservermenu <> 0) Then
                    local57 = (Float ((local1 + local6) - $64))
                    local58 = (Float ((local2 + local7) - $50))
                    drawframe((Int local57), (Int local58), imenuscale[$FA], imenuscale[$96], $00, $00)
                    text((Int (local57 + (Float imenuscale[$14]))), (Int (local58 + (Float imenuscale[$0A]))), "IP:", $00, $00)
                    text((Int (local57 + (Float imenuscale[$14]))), (Int (local58 + (Float imenuscale[$32]))), "Port:", $00, $00)
                    multiplayer_masterserverset(left(inputbox((Int (local57 + (Float imenuscale[$3C]))), (Int (local58 + (Float imenuscale[$0A]))), imenuscale[$82], imenuscale[$19], multiplayer_masterservergetip(), $36, $00, -1.0), $14), left(inputbox((Int (local57 + (Float imenuscale[$46]))), (Int (local58 + (Float imenuscale[$32]))), imenuscale[$50], imenuscale[$19], multiplayer_masterservergetport(), $37, $00, -1.0), $05))
                    If (drawbutton((Int (local57 + (Float imenuscale[$14]))), (Int (local58 + (Float imenuscale[$64]))), imenuscale[$50], imenuscale[$1E], "ADD", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        multiplayer_list_addserver(multiplayer_masterservergetip(), (Int multiplayer_masterservergetport()), $06, $00, $01)
                    EndIf
                    If (drawbutton((Int (local57 + (Float imenuscale[$96]))), (Int (local58 + (Float imenuscale[$64]))), imenuscale[$50], imenuscale[$1E], "CLOSE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        addservermenu = $00
                    EndIf
                ElseIf (passwordmenu <> 0) Then
                    local57 = (Float ((local1 + local6) - $64))
                    local58 = (Float ((local2 + local7) - $50))
                    drawframe((Int local57), (Int local58), imenuscale[$FA], imenuscale[$64], $00, $00)
                    text((Int (local57 + (Float imenuscale[$14]))), (Int (local58 + (Float imenuscale[$0A]))), "Password", $00, $00)
                    password = inputbox((Int (local57 + (Float imenuscale[$64]))), (Int (local58 + (Float imenuscale[$0A]))), imenuscale[$82], imenuscale[$19], password, $36, $00, -1.0)
                    If (drawbutton((Int (local57 + (Float imenuscale[$14]))), (Int (local58 + (Float imenuscale[$32]))), imenuscale[$50], imenuscale[$1E], "CONNECT", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        multiplayer_connectto(multiplayer_masterservergetip(), (Int multiplayer_masterservergetport()), password, $00, $1388)
                    EndIf
                    If (drawbutton((Int (local57 + (Float imenuscale[$96]))), (Int (local58 + (Float imenuscale[$32]))), imenuscale[$50], imenuscale[$1E], "CLOSE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        passwordmenu = $00
                    EndIf
                EndIf
                local1 = imenuscale[$A0]
                local2 = imenuscale[$172]
                local4 = imenuscale[$A0]
                local5 = imenuscale[$1B]
                local59 = selected_servers
                If (drawbutton(local1, local2, local4, local5, (("OFFICIAL(" + (Str getserverscount($05, $01))) + ")"), fonts[$00]\Field0, $00, $01, $FFFFFFFF, $05, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $05
                    selected_page = $00
                EndIf
                local1 = (local1 + local4)
                If (drawbutton(local1, local2, local4, local5, (("COMMUNITY(" + (Str getserverscount($01, $01))) + ")"), fonts[$00]\Field0, $00, $01, $FFFFFFFF, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $01
                    selected_page = $00
                EndIf
                local1 = (local1 + local4)
                If (drawbutton(local1, local2, local4, local5, (("HISTORY(" + (Str getserverscount($03, $01))) + ")"), fonts[$00]\Field0, $00, $01, $FFFFFFFF, $03, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $03
                    selected_page = $00
                EndIf
                local1 = (local1 + local4)
                If (drawbutton(local1, local2, local4, local5, (("FAVORITES(" + (Str getserverscount($06, $01))) + ")"), fonts[$00]\Field0, $00, $01, $FFFFFFFF, $06, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $06
                    selected_page = $00
                EndIf
                local1 = (local1 + local4)
                If (drawbutton(local1, local2, local4, local5, (("LOCAL(" + (Str getserverscount($04, $01))) + ")"), fonts[$00]\Field0, $00, $01, $FFFFFFFF, $04, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $04
                    selected_page = $00
                    multiplayer_findlocalservers($C365)
                EndIf
                setfontex(fonts[$00]\Field0)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$320]
                local5 = imenuscale[$14F]
                If (local59 <> selected_servers) Then
                    local17 = 0.0
                    For local13 = Each servers
                        If (((local13\Field0 = selected_servers) And (((local13\Field4 = $00) And ((local13\Field0 = $01) Or (local13\Field0 = $05))) = $00)) <> 0) Then
                            local17 = ((35.0 * menuscale) + local17)
                        EndIf
                    Next
                    local5 = imenuscale[$CE]
                    local18 = $96
                    local5 = (local5 + imenuscale[local18])
                    chatscroll = (Int ((- local17) + (Float local5)))
                EndIf
                If (selected_servers = $04) Then
                    setcolorraw($FFFFFF)
                    setfontex(fonts[$00]\Field0)
                    drawbutton(imenuscale[$2B2], (imenuscale[$1EA] + local2), imenuscale[$14], imenuscale[$14], "?", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    If ((mouseon(imenuscale[$2B2], (imenuscale[$1EA] + local2), imenuscale[$14], imenuscale[$14]) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((imenuscale[$244] + local1), local2, imenuscale[$190], imenuscale[$C8], "srv", 0.0, $00)
                    EndIf
                EndIf
                If (selectserver <> $FFFFFFFF) Then
                    local13 = (Object.servers selectserver)
                    If (millisecs() > local13\Field13) Then
                        multiplayer_list_updateserver(local13, $1388, $01)
                        local13\Field13 = (millisecs() + $7D0)
                    EndIf
                    local60 = $00
                    For local24 = $00 To $13 Step $01
                        If (local13\Field24[local24] <> "") Then
                            local60 = $01
                            Exit
                        EndIf
                    Next
                    If (local60 <> 0) Then
                        local2 = (local2 + imenuscale[$1B])
                        local48 = $01
                        local61 = $14
                        For local24 = $00 To $13 Step $01
                            If (local13\Field24[local24] <> "") Then
                                local63 = formattext((Float (imenuscale[$32F] + local1)), (((Float local61) * menuscale) + (Float local2)), local13\Field24[local24], $00, $00, 1.0, $00)
                                local64 = (Float piece(local63, $01, " "))
                                If (((local62 < (Float piece(local63, $02, " "))) And ((Float piece(local63, $02, " ")) > (380.0 * menuscale))) <> 0) Then
                                    local62 = (Float piece(local63, $02, " "))
                                EndIf
                                local61 = (Int (((Float local61) + local64) + (Float imenuscale[$14])))
                            EndIf
                        Next
                        If (local61 > imenuscale[$190]) Then
                            drawframe((imenuscale[$320] + local1), local2, (Int (max(0.0, ((local62 + (Float imenuscale[$14])) - (Float imenuscale[$17C]))) + (Float imenuscale[$190]))), (local61 - imenuscale[$14]), $00, $00)
                        Else
                            drawframe((imenuscale[$320] + local1), local2, (Int (max(0.0, ((local62 + (Float imenuscale[$14])) - (Float imenuscale[$17C]))) + (Float imenuscale[$190]))), imenuscale[$190], $00, $00)
                        EndIf
                        local61 = $14
                        For local24 = $00 To $13 Step $01
                            If (local13\Field24[local24] <> "") Then
                                local64 = (Float formattext((Float (imenuscale[$32F] + local1)), (((Float local61) * menuscale) + (Float local2)), local13\Field24[local24], $00, $00, 1.0, $00))
                                local61 = (Int (((Float local61) + local64) + (Float imenuscale[$14])))
                            EndIf
                        Next
                        If (drawbutton((Int ((max(0.0, ((local62 + (Float imenuscale[$14])) - (Float imenuscale[$17C]))) + (Float (imenuscale[$4B0] + local1))) - (Float imenuscale[$28]))), (local2 - imenuscale[$27]), imenuscale[$28], imenuscale[$28], "X", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            For local65 = Each servers
                                If (((((((local65\Field11 <> $00) And (local65\Field18 = local13\Field18)) And (local65\Field18 <> $00)) And (local65\Field2 = local13\Field2)) And (local65 <> local13)) And (local65\Field15 = $00)) <> 0) Then
                                    For local24 = $00 To $13 Step $01
                                        local65\Field24[local24] = ""
                                    Next
                                EndIf
                            Next
                            For local24 = $00 To $13 Step $01
                                local13\Field24[local24] = ""
                            Next
                        EndIf
                        local48 = $00
                    EndIf
                    If (servermenuopen <> 0) Then
                        setfontex(fonts[$00]\Field0)
                        local66 = (Float imenuscale[$190])
                        local67 = (Float imenuscale[$F0])
                        local33 = (viewport_center_x - imenuscale[$190])
                        local34 = (viewport_center_y - imenuscale[$14])
                        local52 = (Str local13\Field4)
                        If (local13\Field4 = $00) Then
                            local52 = "-"
                        EndIf
                        drawframe(local33, local34, (Int local66), (Int local67), $00, $00)
                        setcolorex($FF, $FF, $FF)
                        formattext((Float (imenuscale[$14] + local33)), (Float (imenuscale[$0A] + local34)), ("Server: " + local13\Field10), $00, $00, 1.0, $00)
                        setfontex(fonts[$00]\Field0)
                        text((imenuscale[$14] + local33), (imenuscale[$1E] + local34), ("Players: " + local13\Field6), $00, $00)
                        text((imenuscale[$14] + local33), (imenuscale[$32] + local34), ("Map: " + local13\Field5), $00, $00)
                        text((imenuscale[$14] + local33), (imenuscale[$46] + local34), ("Ping: " + local52), $00, $00)
                        text((imenuscale[$14] + local33), (imenuscale[$5A] + local34), ("Version: " + local13\Field21), $00, $00)
                        If (local13\Field22 = "") Then
                            setfontex(fonts[$00]\Field0)
                            text((imenuscale[$14] + local33), (imenuscale[$6E] + local34), "Web URL: None", $00, $00)
                        Else
                            text((imenuscale[$14] + local33), (imenuscale[$6E] + local34), "Web URL: ", $00, $00)
                            setfontex(fonts[$00]\Field0)
                            If (drawclickabletext(((imenuscale[$1E] + stringwidth("Web URL: ")) + local33), (imenuscale[$6E] + local34), local13\Field22, $34, $E5, $EB) <> 0) Then
                                execfile(local13\Field22)
                            EndIf
                        EndIf
                        setfontex(fonts[$00]\Field0)
                        rect((imenuscale[$14] + local33), (imenuscale[$80] + local34), imenuscale[$168], imenuscale[$01], $01)
                        local48 = $01
                        rowformattext(local13\Field20, (imenuscale[$14] + local33), (imenuscale[$82] + local34), (Int local66), (Int local67), $00, 1.0)
                        local48 = $00
                        If (drawbutton((imenuscale[$0A] + local33), (imenuscale[$C8] + local34), imenuscale[$50], imenuscale[$14], "Connect", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            multiplayer_masterserverset(local13\Field1, local13\Field2)
                            multiplayer_connectto(local13\Field1, (Int local13\Field2), "", $00, $1388)
                            servermenuopen = $00
                        EndIf
                        If (drawbutton((imenuscale[$6E] + local33), (imenuscale[$C8] + local34), imenuscale[$50], imenuscale[$14], "Refresh", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            multiplayer_list_updateserver(local13, $BB8, $02)
                        EndIf
                        If (drawbutton((imenuscale[$D2] + local33), (imenuscale[$C8] + local34), imenuscale[$50], imenuscale[$14], "Delete", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            If (((local13\Field0 <> $01) And (local13\Field0 <> $05)) <> 0) Then
                                multiplayer_list_deleteserver(local13)
                            EndIf
                        EndIf
                        If (drawbutton((imenuscale[$136] + local33), (imenuscale[$C8] + local34), imenuscale[$50], imenuscale[$14], "Close", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            servermenuopen = $00
                        EndIf
                    EndIf
                Else
                    servermenuopen = $00
                EndIf
                If (local44 <> $00) Then
                    serverpages[selected_servers]\Field1 = local44
                    local69 = $00
                    For local13 = Each servers
                        If (local13\Field0 = selected_servers) Then
                            local68[local69] = (New tempservers)
                            multiplayer_list_copytempserverinfo(local68[local69], local13, $01)
                            local69 = (local69 + $01)
                            multiplayer_list_deleteserver(local13)
                        EndIf
                    Next
                    For local24 = $00 To $04 Step $01
                        If (local24 <> serverpages[selected_servers]\Field1) Then
                            serverpages[selected_servers]\Field0[local24] = $FFFFFFFF
                        EndIf
                    Next
                    If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = $FFFFFFFF) Then
                        serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = $00
                    EndIf
                    serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = $00)
                    Select serverpages[selected_servers]\Field1
                        Case $01
                            local1 = (local69 - $01)
                            While (local1 >= $00)
                                If (local68[local1] <> Null) Then
                                    local71 = (New servers)
                                    multiplayer_list_copyservertempinfo(local71, local68[local1], $01)
                                    Delete local68[local1]
                                EndIf
                                local1 = (local1 + $FFFFFFFF)
                            Wend
                        Case $03
                            If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] <> 0) Then
                                For local24 = $00 To (local69 - $01) Step $01
                                    For local1 = $00 To (local69 - $01) Step $01
                                        If (local68[local1] <> Null) Then
                                            local70 = $01
                                            For local2 = $00 To (local69 - $01) Step $01
                                                If (local68[local2] <> Null) Then
                                                    If (asc(left(local68[local1]\Field5, $01)) > asc(left(local68[local2]\Field5, $01))) Then
                                                        local70 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local70 <> 0) Then
                                                local71 = (New servers)
                                                multiplayer_list_copyservertempinfo(local71, local68[local1], $01)
                                                Delete local68[local1]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                For local24 = $00 To (local69 - $01) Step $01
                                    For local1 = $00 To (local69 - $01) Step $01
                                        If (local68[local1] <> Null) Then
                                            local70 = $01
                                            For local2 = $00 To (local69 - $01) Step $01
                                                If (local68[local2] <> Null) Then
                                                    If (asc(left(local68[local1]\Field5, $01)) < asc(left(local68[local2]\Field5, $01))) Then
                                                        local70 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local70 <> 0) Then
                                                local71 = (New servers)
                                                multiplayer_list_copyservertempinfo(local71, local68[local1], $01)
                                                Delete local68[local1]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            EndIf
                        Case $02
                            If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = $00) Then
                                For local24 = $00 To (local69 - $01) Step $01
                                    For local1 = $00 To (local69 - $01) Step $01
                                        If (local68[local1] <> Null) Then
                                            local70 = $01
                                            For local2 = $00 To (local69 - $01) Step $01
                                                If (local68[local2] <> Null) Then
                                                    If (local68[local1]\Field25 < local68[local2]\Field25) Then
                                                        local70 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local70 <> 0) Then
                                                local71 = (New servers)
                                                multiplayer_list_copyservertempinfo(local71, local68[local1], $01)
                                                Delete local68[local1]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                For local24 = $00 To (local69 - $01) Step $01
                                    For local1 = $00 To (local69 - $01) Step $01
                                        If (local68[local1] <> Null) Then
                                            local70 = $01
                                            For local2 = $00 To (local69 - $01) Step $01
                                                If (local68[local2] <> Null) Then
                                                    If (local68[local1]\Field25 > local68[local2]\Field25) Then
                                                        local70 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local70 <> 0) Then
                                                local71 = (New servers)
                                                multiplayer_list_copyservertempinfo(local71, local68[local1], $01)
                                                Delete local68[local1]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            EndIf
                        Case $04
                            If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] <> 0) Then
                                For local24 = $00 To (local69 - $01) Step $01
                                    For local1 = $00 To (local69 - $01) Step $01
                                        If (local68[local1] <> Null) Then
                                            local70 = $01
                                            For local2 = $00 To (local69 - $01) Step $01
                                                If (local68[local2] <> Null) Then
                                                    If (((local68[local1]\Field4 > local68[local2]\Field4) And (local68[local2]\Field4 <> $00)) <> 0) Then
                                                        local70 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local70 <> 0) Then
                                                local71 = (New servers)
                                                multiplayer_list_copyservertempinfo(local71, local68[local1], $01)
                                                Delete local68[local1]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                For local24 = $00 To (local69 - $01) Step $01
                                    For local1 = $00 To (local69 - $01) Step $01
                                        If (local68[local1] <> Null) Then
                                            local70 = $01
                                            For local2 = $00 To (local69 - $01) Step $01
                                                If (local68[local2] <> Null) Then
                                                    If (((local68[local1]\Field4 < local68[local2]\Field4) And (local68[local2]\Field4 <> $00)) <> 0) Then
                                                        local70 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local70 <> 0) Then
                                                local71 = (New servers)
                                                multiplayer_list_copyservertempinfo(local71, local68[local1], $01)
                                                Delete local68[local1]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            EndIf
                    End Select
                    For local24 = $00 To (local69 - $01) Step $01
                        If (local68[local24] <> Null) Then
                            Delete local68[local24]
                        EndIf
                    Next
                EndIf
            Case $0E
                For local24 = $01 To networkserver\Field52\Field14 Step $01
                    If (player[local24] <> Null) Then
                        If (player[local24]\Field24 <> "") Then
                            For local74 = $00 To $07 Step $01
                                If ((local73 Sar $03) = local74) Then
                                    player[local24]\Field67 = local74
                                    local22[local74] = $01
                                    Exit
                                EndIf
                            Next
                            local73 = (local73 + $01)
                        EndIf
                    EndIf
                Next
                drawmenulabel("LOBBY", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                setfontex(fonts[$00]\Field0)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[($14A - (((millisecs() < b_br\Field5) = $00) * $1E))]
                local75 = imenuscale[$08]
                local4 = imenuscale[$244]
                local76 = ""
                If (((($04 - networkserver\Field21) > $00) And networkserver\Field12) <> 0) Then
                    local76 = (("%w%Requires %g%" + (Str ($04 - networkserver\Field21))) + " %w%more players to start the game ")
                EndIf
                If (((networkserver\Field36 And networkserver\Field32) And (networkserver\Field37 <> $00)) <> 0) Then
                    If (drawbutton(((local1 + local4) + imenuscale[$14]), local2, imenuscale[$19], imenuscale[$19], " ", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        networkserver\Field38 = (networkserver\Field38 = $00)
                        steam_setlobbytype(networkserver\Field38)
                    EndIf
                    If (networkserver\Field38 <> 0) Then
                        drawimage(mpimg\Field8, ((local1 + local4) + imenuscale[$1A]), (imenuscale[$05] + local2), $00)
                    Else
                        drawimage(mpimg\Field9, ((local1 + local4) + imenuscale[$1A]), (imenuscale[$05] + local2), $00)
                    EndIf
                    setfontex(fonts[$00]\Field0)
                    If (mouseon(((local1 + local4) + imenuscale[$14]), local2, imenuscale[$19], imenuscale[$19]) <> 0) Then
                        If (networkserver\Field38 = $00) Then
                            drawtextrect(mouseposx, (mouseposy - imenuscale[$14]), imenuscale[$96], imenuscale[$14], "Private room")
                        Else
                            drawtextrect(mouseposx, (mouseposy - imenuscale[$14]), imenuscale[$96], imenuscale[$14], "Friends can join")
                        EndIf
                    EndIf
                    setfontex(fonts[$00]\Field0)
                EndIf
                drawframe(local1, local2, local4, (imenuscale[(((local76 <> "") * $1E) + $78)] + local5), $00, $00)
                drawframe((imenuscale[$32] + local1), local2, imenuscale[$02], imenuscale[$1E], $00, $00)
                drawframe((imenuscale[$12C] + local1), local2, imenuscale[$02], imenuscale[$1E], $00, $00)
                text((imenuscale[$14] + local1), (imenuscale[$05] + local2), "ID", $00, $00)
                text((imenuscale[$41] + local1), (imenuscale[$05] + local2), "Nickname", $00, $00)
                If (networkserver\Field12 = $00) Then
                    text((imenuscale[$140] + local1), (imenuscale[$05] + local2), "Ready", $00, $00)
                    text((imenuscale[$1B8] + local1), (imenuscale[$05] + local2), "Ping", $00, $00)
                Else
                    text((imenuscale[$140] + local1), (imenuscale[$05] + local2), "Ping", $00, $00)
                    text((imenuscale[$1B8] + local1), (imenuscale[$05] + local2), "", $00, $00)
                EndIf
                setfontex(fonts[$00]\Field0)
                myplayer\Field32 = ready
                myplayer\Field24 = nickname
                myplayer\Field46 = serverping
                For local24 = $01 To networkserver\Field52\Field14 Step $01
                    If (player[local24] <> Null) Then
                        If (player[local24]\Field67 = selected_p_page) Then
                            If (player[local24]\Field24 <> "") Then
                                local79 = ""
                                If (0.0 = player[local24]\Field63) Then
                                    local79 = "(Muted)"
                                EndIf
                                local80 = ((local78 + $01) * $1E)
                                drawframe(local1, (imenuscale[local80] + local2), local4, imenuscale[$1E], $00, $00)
                                drawframe((imenuscale[$12C] + local1), local2, imenuscale[$02], imenuscale[(($1E * local78) + $3C)], $00, $00)
                                If (networkserver\Field12 = $00) Then
                                    drawframe((imenuscale[$1A4] + local1), local2, imenuscale[$02], imenuscale[(($1E * local78) + $3C)], $00, $00)
                                EndIf
                                If (local24 = networkserver\Field20) Then
                                    setcolorex($1F4, $1F4, $00)
                                EndIf
                                If (player[local24]\Field86 <> "") Then
                                    local79 = player[local24]\Field86
                                EndIf
                                local48 = $01
                                text((imenuscale[$41] + local1), (imenuscale[(local80 + $0A)] + local2), player[local24]\Field24, $00, $00)
                                local48 = $00
                                setcolorex($FF, $00, $00)
                                If (player[local24]\Field86 <> "") Then
                                    setcolorex(player[local24]\Field87, player[local24]\Field88, player[local24]\Field89)
                                EndIf
                                text((imenuscale[$E6] + local1), (imenuscale[(local80 + $0A)] + local2), local79, $00, $00)
                                setcolorex($FF, $FF, $FF)
                                drawframe((imenuscale[$32] + local1), local2, imenuscale[$02], imenuscale[(($1E * local78) + $3C)], $00, $00)
                                If (player[local24]\Field32 = "Ready") Then
                                    setcolorex($00, $FF, $00)
                                Else
                                    setcolorex($FF, $00, $00)
                                EndIf
                                If (networkserver\Field12 = $00) Then
                                    text((imenuscale[$140] + local1), (imenuscale[(local80 + $0A)] + local2), player[local24]\Field32, $00, $00)
                                    setcolorex($FF, $FF, $FF)
                                    text((imenuscale[$1B8] + local1), (imenuscale[(local80 + $0A)] + local2), (Str player[local24]\Field46), $00, $00)
                                Else
                                    setcolorex($FF, $FF, $FF)
                                    text((imenuscale[$140] + local1), (imenuscale[(local80 + $0A)] + local2), (Str player[local24]\Field46), $00, $00)
                                    text((imenuscale[$1B8] + local1), (imenuscale[(local80 + $0A)] + local2), "", $00, $00)
                                EndIf
                                text((imenuscale[$14] + local1), (imenuscale[(local80 + $0A)] + local2), (Str local24), $00, $00)
                                local78 = (local78 + $01)
                                If (drawbutton((imenuscale[$226] + local1), ((local2 - $02) + imenuscale[(local80 + $0A)]), imenuscale[$0F], imenuscale[$0F], "+", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    mainmenutab = $28
                                    currplayer = player[local24]
                                EndIf
                                setfontex(fonts[$00]\Field0)
                            EndIf
                        EndIf
                    EndIf
                Next
                For local24 = $00 To $07 Step $01
                    If (local22[local24] = $01) Then
                        If (selected_p_page = local24) Then
                            drawbutton((Int (((Float (((local24 + $01) * $23) + $14)) * menuscale) + (Float local1))), (Int ((295.0 * menuscale) + (Float local2))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local24 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, selected_p_page, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        ElseIf (drawbutton((Int (((Float (((local24 + $01) * $23) + $14)) * menuscale) + (Float local1))), (Int ((295.0 * menuscale) + (Float local2))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local24 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            selected_p_page = local24
                        EndIf
                        rect((Int ((15.0 * menuscale) + (Float local1))), (Int ((320.0 * menuscale) + (Float local2))), (local4 - $1E), $02, $01)
                    EndIf
                Next
                local81 = (Int (20.0 * menuscale))
                If (drawbutton((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "SETTINGS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $15
                EndIf
                If (networkserver\Field12 = $00) Then
                    local81 = (Int ((120.0 * menuscale) + (Float local81)))
                    If (drawbutton((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "READY", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        If (ready = "Not Ready") Then
                            ready = "Ready"
                        Else
                            ready = "Not Ready"
                        EndIf
                    EndIf
                    local81 = (Int ((120.0 * menuscale) + (Float local81)))
                    If (networkserver\Field21 < $02) Then
                        If (networkserver\Field15 = $00) Then
                            drawbutton((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "LOAD GAME", $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            If ((mouseon((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                                drawoptionstooltip((Int ((580.0 * menuscale) + (Float local1))), local2, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "cant2", 0.0, $00)
                            EndIf
                        ElseIf (drawbutton((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "LOAD GAME", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            loadsavegames()
                            mainmenutab = $17
                        EndIf
                    Else
                        drawbutton((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "LOAD GAME", $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        If ((mouseon((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int ((580.0 * menuscale) + (Float local1))), local2, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "cant", 0.0, $00)
                        EndIf
                    EndIf
                Else
                    local81 = (Int ((120.0 * menuscale) + (Float local81)))
                    drawbutton((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "LOAD GAME", $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                EndIf
                If (networkserver\Field15 <> 0) Then
                    local81 = (Int ((120.0 * menuscale) + (Float local81)))
                    local82 = $00
                    For local31 = Each players
                        If (local31\Field32 = "Ready") Then
                            local82 = (local82 + $01)
                        EndIf
                    Next
                    If (local82 >= networkserver\Field21) Then
                        If (drawbutton((local1 + local81), (Int ((350.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "START GAME", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            If (currsave = "") Then
                                currsave = "untitled"
                            EndIf
                            selectedmap = ""
                            gameload = $01
                            mainmenuopen = $00
                            loadentities()
                            myplayer\Field41 = $00
                            myplayer\Field13 = collider
                            myplayer\Field19 = myhitbox
                            multiplayer_updateplayers()
                            multiplayer_sendserverinformation()
                            For local31 = Each players
                                local31\Field42 = (millisecs() + $2BF20)
                            Next
                            loadallsounds()
                            initnewgame()
                            flushkeys()
                            flushmouse()
                            Return $00
                        EndIf
                    EndIf
                EndIf
                If (millisecs() < b_br\Field5) Then
                    local83 = ((((b_br\Field5 + $3E7) - millisecs()) / $3E8) Mod $3C)
                    local84 = ((((b_br\Field5 + $3E7) - millisecs()) / $EA60) Mod $3C)
                    local85 = (Str local83)
                    If (local83 < $0A) Then
                        local85 = ("0" + (Str local83))
                    EndIf
                    setcolorex($FF, $FF, $FF)
                    setfontex(fonts[$00]\Field0)
                    text((Int ((20.0 * menuscale) + (Float local1))), (Int ((420.0 * menuscale) + (Float local2))), ((("Remaining before start - " + (Str local84)) + ":") + local85), $00, $00)
                    formattext(((20.0 * menuscale) + (Float local1)), ((450.0 * menuscale) + (Float local2)), local76, $00, $00, 1.0, $00)
                EndIf
            Case $28
                If (currplayer = Null) Then
                    mainmenutab = $0E
                    Return $00
                EndIf
                drawmenulabel("LOBBY", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$14A]
                drawframe(local1, local2, local4, (imenuscale[$3C] + local5), $00, $00)
                setfontex(fonts[$00]\Field0)
                currplayer\Field63 = (slidebar((imenuscale[$14] + local1), (imenuscale[$32] + local2), imenuscale[$96], (currplayer\Field63 * 100.0), $00, 0.0, 100.0, $00) * 0.01)
                local86 = (Int currplayer\Field63)
                local87 = ((local86 Shl $02) + local86)
                local87 = ((local86 Shl $04) + (local86 Shl $02))
                text((imenuscale[$1E] + local1), (imenuscale[$1E] + local2), ("Player volume: " + (Str local87)), $00, $00)
            Case $09
                If (selecteddifficulty = difficulties($03)) Then
                    selecteddifficulty = difficulties($00)
                EndIf
                drawmenulabel("LOBBY", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                setfontex(fonts[$00]\Field0)
                local1 = (Int (160.0 * menuscale))
                local2 = (Int (376.0 * menuscale))
                local4 = (Int (580.0 * menuscale))
                local5 = (Int (360.0 * menuscale))
                drawframe(local1, local2, local4, (Int (((200.0 - ((80.0 * menuscale) * 1.0)) * menuscale) + (Float local5))), $00, $00)
                If (drawbutton((Int ((410.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), "CREATE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    steam_api_setachievement("AchvMultiplayer")
                    timemaxplayers = (Int max(min(65.0, (Float timemaxplayers)), 1.0))
                    If (timerandomseed = "") Then
                        timerandomseed = setrandomseed()
                    EndIf
                    timeport = (Int max(min(65535.0, (Float timeport)), 80.0))
                    multiplayer_hostserver(timeservername, timeport, timerandomseed, timeintroenabled, timetickrate, (Float timegravity), timejumpmode, timenocheat, timemaxplayers, timevoice, timepassword)
                EndIf
                If ((mouseon((Int ((410.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                    drawoptionstooltip((Int ((580.0 * menuscale) + (Float local1))), local2, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "p2p", 0.0, $00)
                EndIf
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), "Server name:", $00, $00)
                timeservername = left(inputbox((Int ((145.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (Int (250.0 * menuscale)), (Int (20.0 * menuscale)), timeservername, $01, $00, -1.0), $40)
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((60.0 * menuscale) + (Float local2))), "Map seed:", $00, $00)
                timerandomseed = left(inputbox((Int ((120.0 * menuscale) + (Float local1))), (Int ((55.0 * menuscale) + (Float local2))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), timerandomseed, $02, $00, -1.0), $12)
                local2 = (Int ((Float local2) - (40.0 * menuscale)))
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((140.0 * menuscale) + (Float local2))), "Enable intro sequence:", $00, $00)
                timeintroenabled = drawtick((Int ((240.0 * menuscale) + (Float local1))), (Int ((140.0 * menuscale) + (Float local2))), timeintroenabled, $00)
                local2 = (Int ((Float local2) - (40.0 * menuscale)))
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((220.0 * menuscale) + (Float local2))), "Difficulty:", $00, $00)
                For local24 = $00 To $02 Step $01
                    If (drawtick((Int ((20.0 * menuscale) + (Float local1))), (Int (((Float (($1E * local24) + $FA)) * menuscale) + (Float local2))), (selecteddifficulty = difficulties(local24)), $00) <> 0) Then
                        selecteddifficulty = difficulties(local24)
                    EndIf
                    setcolorex(difficulties(local24)\Field6, difficulties(local24)\Field7, difficulties(local24)\Field8)
                    text((Int ((60.0 * menuscale) + (Float local1))), (Int (((Float (($1E * local24) + $FA)) * menuscale) + (Float local2))), difficulties(local24)\Field0, $00, $00)
                Next
                setfontex(fonts[$00]\Field0)
                setcolorex($FF, $FF, $FF)
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((340.0 * menuscale) + (Float local2))), "No Cheat:", $00, $00)
                timenocheat = drawtick((Int ((120.0 * menuscale) + (Float local1))), (Int ((340.0 * menuscale) + (Float local2))), timenocheat, $00)
                If ((mouseon((Int ((120.0 * menuscale) + (Float local1))), (Int ((340.0 * menuscale) + (Float local2))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                    drawoptionstooltip((Int ((580.0 * menuscale) + (Float local1))), local2, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "NoCheat", 0.0, $00)
                EndIf
                setcolorex($FF, $FF, $FF)
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((380.0 * menuscale) + (Float local2))), "Voice chat:", $00, $00)
                timevoice = drawtick((Int ((150.0 * menuscale) + (Float local1))), (Int ((380.0 * menuscale) + (Float local2))), timevoice, $00)
                If ((mouseon((Int ((150.0 * menuscale) + (Float local1))), (Int ((380.0 * menuscale) + (Float local2))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                    drawoptionstooltip((Int ((580.0 * menuscale) + (Float local1))), local2, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "voice", 0.0, $00)
                EndIf
                setcolorex($FF, $FF, $FF)
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((420.0 * menuscale) + (Float local2))), "Max players:", $00, $00)
                timemaxplayers = (Int left(inputbox((Int ((150.0 * menuscale) + (Float local1))), (Int ((415.0 * menuscale) + (Float local2))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), (Str timemaxplayers), $0D, $00, -1.0), $02))
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((450.0 * menuscale) + (Float local2))), "Jump mode:", $00, $00)
                timejumpmode = drawtick((Int ((150.0 * menuscale) + (Float local1))), (Int ((450.0 * menuscale) + (Float local2))), timejumpmode, $00)
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((485.0 * menuscale) + (Float local2))), "Gravity:", $00, $00)
                timegravity = inputbox((Int ((120.0 * menuscale) + (Float local1))), (Int ((480.0 * menuscale) + (Float local2))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), timegravity, $0E, $00, -1.0)
                text((Int ((20.0 * menuscale) + (Float local1))), (Int ((515.0 * menuscale) + (Float local2))), "Keep inventory:", $00, $00)
                timekeepinventory = drawtick((Int ((170.0 * menuscale) + (Float local1))), (Int ((510.0 * menuscale) + (Float local2))), timekeepinventory, $00)
            Case $02
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$1FE]
                drawframe(local1, local2, local4, local5, $00, $00)
                drawmenulabel("LOAD GAME", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$128]
                local6 = imenuscale[$122]
                local7 = imenuscale[$94]
                setfontex(fonts[$01]\Field0)
                If ((((Float currloadgamepage) < (ceil(((Float savegameamount) / 6.0)) - 1.0)) And (savemsg = "")) <> 0) Then
                    If (drawbutton((imenuscale[$212] + local1), (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], ">", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage + $01)
                    EndIf
                Else
                    drawframe((imenuscale[$212] + local1), (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], $00, $00)
                    setcolorraw($646464)
                    text((imenuscale[$22B] + local1), (imenuscale[$219] + local2), ">", $01, $01)
                EndIf
                If (((currloadgamepage > $00) And (savemsg = "")) <> 0) Then
                    If (drawbutton(local1, (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], "<", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage - $01)
                    EndIf
                Else
                    drawframe(local1, (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], $00, $00)
                    setcolorraw($646464)
                    text((imenuscale[$19] + local1), (imenuscale[$219] + local2), "<", $01, $01)
                EndIf
                drawframe((imenuscale[$32] + local1), (imenuscale[$1FE] + local2), (local4 - imenuscale[$64]), imenuscale[$37], $00, $00)
                text((local1 + local6), (imenuscale[$218] + local2), ((("Page " + (Str (Int max((Float (currloadgamepage + $01)), 1.0)))) + "/") + (Str (Int max((Float (Int ceil(((Float savegameamount) / 6.0)))), 1.0)))), $01, $01)
                setfontex(fonts[$00]\Field0)
                If ((Float currloadgamepage) > (ceil(((Float savegameamount) / 6.0)) - 1.0)) Then
                    currloadgamepage = (currloadgamepage - $01)
                EndIf
                If (savegameamount = $00) Then
                    text((imenuscale[$14] + local1), (imenuscale[$14] + local2), "No saved games.", $00, $00)
                Else
                    local1 = (local1 + imenuscale[$14])
                    local2 = (local2 + imenuscale[$14])
                    For local24 = (($06 * currloadgamepage) + $01) To (($06 * currloadgamepage) + $06) Step $01
                        If (local24 <= savegameamount) Then
                            drawframe(local1, local2, imenuscale[$21C], imenuscale[$46], $00, $00)
                            If (1.22 > savegameversion((local24 - $01))) Then
                                setcolorraw($FF0000)
                            Else
                                setcolorraw($FFFFFF)
                            EndIf
                            text((imenuscale[$14] + local1), (imenuscale[$0A] + local2), savegames((local24 - $01)), $00, $00)
                            text((imenuscale[$14] + local1), (imenuscale[$1C] + local2), savegametime((local24 - $01)), $00, $00)
                            text((imenuscale[$78] + local1), (imenuscale[$1C] + local2), savegamedate((local24 - $01)), $00, $00)
                            text((imenuscale[$14] + local1), (imenuscale[$24] + local2), ("v" + (Str savegameversion((local24 - $01)))), $00, $00)
                            If (savemsg = "") Then
                                If (1.22 > savegameversion((local24 - $01))) Then
                                    drawframe((imenuscale[$118] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], $00, $00)
                                    setcolorraw($FF0000)
                                    text((imenuscale[$14A] + local1), (imenuscale[$22] + local2), "Load", $01, $01)
                                ElseIf (drawbutton((imenuscale[$118] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], "Load", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    startloadgame(((savepath + savegames((local24 - $01))) + "\"), savegames((local24 - $01)))
                                EndIf
                                If (drawbutton((imenuscale[$190] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], "Delete", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    savemsg = savegames((local24 - $01))
                                    Exit
                                EndIf
                            Else
                                drawframe((imenuscale[$118] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], $00, $00)
                                If (1.22 > savegameversion((local24 - $01))) Then
                                    setcolorraw($FF0000)
                                Else
                                    setcolorraw($646464)
                                EndIf
                                text((imenuscale[$14A] + local1), (imenuscale[$22] + local2), "Load", $01, $01)
                                drawframe((imenuscale[$190] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], $00, $00)
                                setcolorraw($646464)
                                text((imenuscale[$1C2] + local1), (imenuscale[$22] + local2), "Delete", $01, $01)
                            EndIf
                            local2 = (local2 + imenuscale[$50])
                        Else
                            Exit
                        EndIf
                    Next
                    If (savemsg <> "") Then
                        local1 = imenuscale[$2E4]
                        local2 = imenuscale[$178]
                        drawframe(local1, local2, imenuscale[$1A4], imenuscale[$C8], $00, $00)
                        rowtext("Are you sure you want to delete this save? !>!??!?!?!?", (Float (imenuscale[$14] + local1)), (Float (imenuscale[$0F] + local2)), (Float imenuscale[$190]), (Float imenuscale[$C8]), $00, 1.0, $00)
                        If (drawbutton((imenuscale[$32] + local1), (imenuscale[$96] + local2), imenuscale[$64], imenuscale[$1E], "Yes", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            deletefile((((currentdir() + savepath) + savemsg) + "\save.txt"))
                            deletedir(((currentdir() + savepath) + savemsg))
                            savemsg = ""
                            loadsavegames()
                        EndIf
                        If (drawbutton((imenuscale[$FA] + local1), (imenuscale[$96] + local2), imenuscale[$64], imenuscale[$1E], "No", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            savemsg = ""
                        EndIf
                    EndIf
                EndIf
            Case $17
                If (networkserver\Field21 > $01) Then
                    mainmenutab = $0E
                    Return $00
                EndIf
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$1FE]
                drawframe(local1, local2, local4, local5, $00, $00)
                drawmenulabel("LOAD COOP GAME", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$128]
                local6 = imenuscale[$122]
                local7 = imenuscale[$94]
                setfontex(fonts[$01]\Field0)
                If ((((Float currloadgamepage) < (ceil(((Float savegameamount) / 6.0)) - 1.0)) And (savemsg = "")) <> 0) Then
                    If (drawbutton((imenuscale[$212] + local1), (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], ">", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage + $01)
                    EndIf
                Else
                    drawframe((imenuscale[$212] + local1), (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], $00, $00)
                    setcolorraw($646464)
                    text((imenuscale[$22B] + local1), (imenuscale[$219] + local2), ">", $01, $01)
                EndIf
                If (((currloadgamepage > $00) And (savemsg = "")) <> 0) Then
                    If (drawbutton(local1, (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], "<", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage - $01)
                    EndIf
                Else
                    drawframe(local1, (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], $00, $00)
                    setcolorraw($646464)
                    text((imenuscale[$19] + local1), (imenuscale[$219] + local2), "<", $01, $01)
                EndIf
                drawframe((imenuscale[$32] + local1), (imenuscale[$1FE] + local2), (local4 - imenuscale[$64]), imenuscale[$37], $00, $00)
                text((local1 + local6), (imenuscale[$218] + local2), ((("Page " + (Str (Int max((Float (currloadgamepage + $01)), 1.0)))) + "/") + (Str (Int max((Float (Int ceil(((Float savegameamount) / 6.0)))), 1.0)))), $01, $01)
                setfontex(fonts[$00]\Field0)
                If ((Float currloadgamepage) > (ceil(((Float savegameamount) / 6.0)) - 1.0)) Then
                    currloadgamepage = (currloadgamepage - $01)
                EndIf
                If (savegameamount = $00) Then
                    text((imenuscale[$14] + local1), (imenuscale[$14] + local2), "No saved games.", $00, $00)
                Else
                    local1 = (local1 + imenuscale[$14])
                    local2 = (local2 + imenuscale[$14])
                    For local24 = (($06 * currloadgamepage) + $01) To (($06 * currloadgamepage) + $06) Step $01
                        If (local24 <= savegameamount) Then
                            drawframe(local1, local2, imenuscale[$21C], imenuscale[$46], $00, $00)
                            If (1.22 > savegameversion((local24 - $01))) Then
                                setcolorraw($FF0000)
                            Else
                                setcolorraw($FFFFFF)
                            EndIf
                            text((imenuscale[$14] + local1), (imenuscale[$0A] + local2), savegames((local24 - $01)), $00, $00)
                            text((imenuscale[$14] + local1), (imenuscale[$1C] + local2), savegametime((local24 - $01)), $00, $00)
                            text((imenuscale[$78] + local1), (imenuscale[$1C] + local2), savegamedate((local24 - $01)), $00, $00)
                            text((imenuscale[$14] + local1), (imenuscale[$2E] + local2), savegameseed((local24 - $01)), $00, $00)
                            If (savemsg = "") Then
                                If (((1.22 > savegameversion((local24 - $01))) Or (savegameseed((local24 - $01)) = "")) <> 0) Then
                                    drawframe((imenuscale[$118] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], $00, $00)
                                    setcolorex($FF, $00, $00)
                                    text((imenuscale[$14A] + local1), (imenuscale[$22] + local2), "Load", $01, $01)
                                ElseIf (drawbutton((imenuscale[$118] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], "Load", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    multiplayer_requestload(((savepath + savegames((local24 - $01))) + "\"), savegameseed((local24 - $01)), savegames((local24 - $01)), savegamedifficulty((local24 - $01)))
                                EndIf
                                If (drawbutton((imenuscale[$190] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], "Delete", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    savemsg = savegames((local24 - $01))
                                    Exit
                                EndIf
                            Else
                                drawframe((imenuscale[$118] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], $00, $00)
                                If (((1.22 > savegameversion((local24 - $01))) Or (savegameseed((local24 - $01)) = "")) <> 0) Then
                                    setcolorex($FF, $00, $00)
                                Else
                                    setcolorex($64, $64, $64)
                                EndIf
                                text((imenuscale[$14A] + local1), (imenuscale[$22] + local2), "Load", $01, $01)
                                drawframe((imenuscale[$190] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], $00, $00)
                                setcolorex($64, $64, $64)
                                text((imenuscale[$1C2] + local1), (imenuscale[$22] + local2), "Delete", $01, $01)
                            EndIf
                            local2 = (local2 + imenuscale[$50])
                        Else
                            Exit
                        EndIf
                    Next
                    If (savemsg <> "") Then
                        local1 = imenuscale[$2E4]
                        local2 = imenuscale[$178]
                        drawframe(local1, local2, imenuscale[$1A4], imenuscale[$C8], $00, $00)
                        rowtext("Are you sure you want to delete this save? !>!??!?!?!?", (Float (imenuscale[$14] + local1)), (Float (imenuscale[$0F] + local2)), (Float imenuscale[$190]), (Float imenuscale[$C8]), $00, 1.0, $00)
                        If (drawbutton((imenuscale[$32] + local1), (imenuscale[$96] + local2), imenuscale[$64], imenuscale[$1E], "Yes", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            deletefile((((currentdir() + savepath) + savemsg) + "\save.txt"))
                            deletedir(((currentdir() + savepath) + savemsg))
                            savemsg = ""
                            loadsavegames()
                        EndIf
                        If (drawbutton((imenuscale[$FA] + local1), (imenuscale[$96] + local2), imenuscale[$64], imenuscale[$1E], "No", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            savemsg = ""
                        EndIf
                    EndIf
                EndIf
            Case $03,$05,$06,$07
                drawmenulabel("OPTIONS", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$3C]
                local6 = imenuscale[$122]
                local7 = imenuscale[$1E]
                local86 = (Int ((Float local4) * 0.2))
                drawframe(local1, local2, local4, local5, $00, $00)
                setcolorraw($FF00)
                If (mainmenutab = $03) Then
                    rect((imenuscale[$0F] + local1), (imenuscale[$0A] + local2), (imenuscale[$0A] + local86), (imenuscale[$0A] + local7), $01)
                ElseIf (mainmenutab = $05) Then
                    rect((imenuscale[$9B] + local1), (imenuscale[$0A] + local2), (imenuscale[$0A] + local86), (imenuscale[$0A] + local7), $01)
                ElseIf (mainmenutab = $06) Then
                    rect((imenuscale[$127] + local1), (imenuscale[$0A] + local2), (imenuscale[$0A] + local86), (imenuscale[$0A] + local7), $01)
                ElseIf (mainmenutab = $07) Then
                    rect((imenuscale[$1B3] + local1), (imenuscale[$0A] + local2), (imenuscale[$0A] + local86), (imenuscale[$0A] + local7), $01)
                EndIf
                setcolorraw($FFFFFF)
                If (drawbutton((imenuscale[$14] + local1), (imenuscale[$0F] + local2), local86, local7, "GRAPHICS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $03
                EndIf
                If (drawbutton((imenuscale[$A0] + local1), (imenuscale[$0F] + local2), local86, local7, "AUDIO", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $05
                EndIf
                If (drawbutton((imenuscale[$12C] + local1), (imenuscale[$0F] + local2), local86, local7, "CONTROLS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $06
                EndIf
                If (drawbutton((imenuscale[$1B8] + local1), (imenuscale[$0F] + local2), local86, local7, "ADVANCED", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $07
                EndIf
                setfontex(fonts[$00]\Field0)
                local2 = (Int ((70.0 * menuscale) + (Float local2)))
                If (mainmenutab <> $05) Then
                    usertrackcheck = $00
                    usertrackcheck2 = $00
                EndIf
                local88 = (Float (local1 + local4))
                local89 = (Float local2)
                local90 = (Float imenuscale[$190])
                local91 = (Float imenuscale[$96])
                If (mainmenutab = $03) Then
                    If (settingsmenu = $00) Then
                        local5 = imenuscale[$17C]
                        drawframe(local1, local2, local4, local5, $00, $00)
                        local2 = (local2 + imenuscale[$0A])
                        If (drawbutton(((local1 + local4) - imenuscale[$3C]), local2, imenuscale[$32], imenuscale[$14], ">>>", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            settingsmenu = $01
                        EndIf
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "Enable bump mapping:", $00, $00)
                        bumpenabled = drawtick((imenuscale[$FA] + local1), local2, bumpenabled, $00)
                        If ((mouseon((imenuscale[$FA] + local1), local2, imenuscale[$14], imenuscale[$14]) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "bump", 0.0, $00)
                        EndIf
                        setcolorraw($FFFFFF)
                        text((imenuscale[$168] + local1), local2, "Particles:", $00, $00)
                        removeparticles = (drawtick((imenuscale[$1EA] + local1), local2, (removeparticles = $00), $00) = $00)
                        local2 = (local2 + imenuscale[$1E])
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "VSync:", $00, $00)
                        verticalsync = drawtick((imenuscale[$FA] + local1), local2, verticalsync, $00)
                        If ((mouseon((imenuscale[$FA] + local1), local2, imenuscale[$14], imenuscale[$14]) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "vsync", 0.0, $00)
                        EndIf
                        setcolorraw($FFFFFF)
                        text((imenuscale[$168] + local1), local2, "Decals:", $00, $00)
                        removedecals = (drawtick((imenuscale[$1EA] + local1), local2, (removedecals = $00), $00) = $00)
                        local2 = (local2 + imenuscale[$1E])
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "Anti-aliasing:", $00, $00)
                        local92 = opt_antialias
                        opt_antialias = drawtick((imenuscale[$FA] + local1), local2, opt_antialias, $00)
                        If (local92 <> opt_antialias) Then
                            antialias(opt_antialias)
                            setfontsmooth(opt_antialias)
                        EndIf
                        If ((mouseon((imenuscale[$FA] + local1), local2, imenuscale[$14], imenuscale[$14]) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "antialias", 0.0, $00)
                        EndIf
                        setcolorraw($FFFFFF)
                        text((imenuscale[$168] + local1), local2, "Bullets FX:", $00, $00)
                        enablebullets = drawtick((imenuscale[$1EA] + local1), local2, enablebullets, $00)
                        local2 = (local2 + imenuscale[$1E])
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "Enable roomlights:", $00, $00)
                        enableroomlights = drawtick((imenuscale[$FA] + local1), local2, enableroomlights, $00)
                        If ((mouseon((imenuscale[$FA] + local1), local2, imenuscale[$14], imenuscale[$14]) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "roomlights", 0.0, $00)
                        EndIf
                        local2 = (local2 + imenuscale[$1E])
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "Enable Gamma correction:", $00, $00)
                        turnongamma = (drawtick((imenuscale[$FA] + local1), local2, (turnongamma = $00), $00) = $00)
                        If ((mouseon((imenuscale[$FA] + local1), local2, imenuscale[$14], imenuscale[$14]) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "gu", 0.0, $00)
                        EndIf
                        local2 = (local2 + imenuscale[$28])
                        screengamma = (slidebar((imenuscale[$FA] + local1), local2, imenuscale[$FA], (screengamma * 100.0), $00, 0.0, 100.0, turnongamma) * 0.01)
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "Screen gamma", $00, $00)
                        If ((mouseon((imenuscale[$FA] + local1), local2, imenuscale[$FA], imenuscale[$14]) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "gamma", screengamma, $00)
                        EndIf
                        local2 = (local2 + imenuscale[$28])
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, ("Field of view: " + (Str (Int mainfov))), $00, $00)
                        mainfov = slidebar((imenuscale[$FA] + local1), local2, imenuscale[$FA], mainfov, $00, 75.0, 100.0, $00)
                        local2 = (local2 + imenuscale[$28])
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "Cameras quality:", $00, $00)
                        camquality = slider3((imenuscale[$FA] + local1), local2, imenuscale[$FA], camquality, $38, "Low", "Medium", "High")
                        If (((mouseon((imenuscale[$FA] + local1), local2, imenuscale[$FA], imenuscale[$14]) And (onsliderid = $00)) Or (onsliderid = $38)) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int (local91 + (Float imenuscale[$64]))), "cmqu", 0.0, $00)
                        EndIf
                        local2 = (local2 + imenuscale[$28])
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "Particle amount:", $00, $00)
                        particleamount = slider3((imenuscale[$FA] + local1), local2, imenuscale[$FA], particleamount, $02, "MINIMAL", "REDUCED", "FULL")
                        If (((mouseon((imenuscale[$FA] + local1), local2, imenuscale[$FA], imenuscale[$14]) And (onsliderid = $00)) Or (onsliderid = $02)) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "particleamount", (Float particleamount), $00)
                        EndIf
                    Else
                        local5 = imenuscale[$17C]
                        drawframe(local1, local2, local4, local5, $00, $00)
                        If (drawbutton(((local1 + local4) - imenuscale[$3C]), (imenuscale[$0A] + local2), imenuscale[$32], imenuscale[$14], "<<<", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            settingsmenu = $00
                        EndIf
                        text((imenuscale[$0A] + local1), (imenuscale[$0A] + local2), "Select resolution:", $00, $00)
                        local2 = (local2 + imenuscale[$14])
                        setcolorraw($FFFFFF)
                        local93 = $00
                        local94 = (Float (imenuscale[$14] + local1))
                        local95 = (Float (imenuscale[$14] + local2))
                        For local24 = $00 To (gfxmodes - $01) Step $01
                            If (((gfxmodeexists(gfxmodewidths(local24), gfxmodeheights(local24), $10) And bit16modesetting) Or (bit16modesetting = $00)) <> 0) Then
                                If (selectedgfxmode = local24) Then
                                    rect((Int (local94 - 1.0)), (Int (local95 - 1.0)), imenuscale[$64], imenuscale[$14], $00)
                                EndIf
                                text((Int local94), (Int local95), (((Str gfxmodewidths(local24)) + "x") + (Str gfxmodeheights(local24))), $00, $00)
                                If (mouseon((Int (local94 - 1.0)), (Int (local95 - 1.0)), imenuscale[$64], imenuscale[$14]) <> 0) Then
                                    rect((Int (local94 - 1.0)), (Int (local95 - 1.0)), imenuscale[$64], imenuscale[$14], $00)
                                    If (mousehit1 <> 0) Then
                                        selectedgfxmode = local24
                                        playsound_strict(buttonsfx)
                                    EndIf
                                EndIf
                                local95 = (local95 + (Float imenuscale[$14]))
                                If ((Float (imenuscale[$A0] + local2)) <= local95) Then
                                    local95 = (Float (imenuscale[$14] + local2))
                                    local94 = (local94 + (Float imenuscale[$64]))
                                EndIf
                                local93 = $01
                            EndIf
                        Next
                        If (local93 = $00) Then
                            text((Int (local94 - (Float imenuscale[$0A]))), (Int local95), "No graphics modes found.", $00, $00)
                        Else
                            rect((imenuscale[$0A] + local1), (imenuscale[$0F] + local2), (Int ((local94 - (Float local1)) + (Float imenuscale[$64]))), imenuscale[$96], $00)
                        EndIf
                        local1 = (local1 + imenuscale[$12])
                        local2 = (local2 + imenuscale[$A0])
                        text((local1 - imenuscale[$08]), (imenuscale[$0A] + local2), "Select graphics drivers:", $00, $00)
                        rect((local1 - imenuscale[$08]), (imenuscale[$23] + local2), imenuscale[$206], imenuscale[(((countgfxdrivers() + $01) * $14) + $0E)], $00)
                        local2 = (local2 + imenuscale[$2F])
                        If (((selectedgfxdriversetting < $00) Or (selectedgfxdriversetting > countgfxdrivers())) <> 0) Then
                            selectedgfxdriversetting = $01
                        EndIf
                        If (selectedgfxdriversetting = $00) Then
                            rect((local1 - $01), (local2 - $01), imenuscale[$1F4], imenuscale[$14], $00)
                        EndIf
                        text(local1, local2, "Default (Recommended)", $00, $00)
                        If (mouseon((local1 - $01), (local2 - $01), imenuscale[$1F4], imenuscale[$14]) <> 0) Then
                            rect((local1 - $01), (local2 - $01), imenuscale[$1F4], imenuscale[$14], $00)
                            If (mousehit1 <> 0) Then
                                selectedgfxdriversetting = $00
                                playsound_strict(buttonsfx)
                            EndIf
                        EndIf
                        local2 = (local2 + imenuscale[$14])
                        For local24 = $01 To countgfxdrivers() Step $01
                            If (selectedgfxdriversetting = local24) Then
                                rect((local1 - $01), (local2 - $01), imenuscale[$1F4], imenuscale[$14], $00)
                            EndIf
                            text(local1, local2, gfxdrivername(local24), $00, $00)
                            If (mouseon((local1 - $01), (local2 - $01), imenuscale[$1F4], imenuscale[$14]) <> 0) Then
                                rect((local1 - $01), (local2 - $01), imenuscale[$1F4], imenuscale[$14], $00)
                                If (mousehit1 <> 0) Then
                                    selectedgfxdriversetting = local24
                                    playsound_strict(buttonsfx)
                                EndIf
                            EndIf
                            local2 = (local2 + imenuscale[$14])
                        Next
                        local2 = (local2 - imenuscale[$64])
                        fullscreensetting = drawtick((imenuscale[$208] + local1), (local2 - imenuscale[$37]), fullscreensetting, borderlesswindowedsetting)
                        borderlesswindowedsetting = drawtick((imenuscale[$208] + local1), (local2 - imenuscale[$55]), borderlesswindowedsetting, $00)
                        local96 = $00
                        If ((borderlesswindowedsetting Or (fullscreensetting = $00)) <> 0) Then
                            local96 = $01
                        EndIf
                        launcherenabledsetting = drawtick((imenuscale[$208] + local1), (local2 - imenuscale[$73]), launcherenabledsetting, $00)
                        setcolorraw($FFFFFF)
                        text((imenuscale[$15E] + local1), (local2 - imenuscale[$73]), "Use launcher", $00, $00)
                        text((imenuscale[$15E] + local1), (local2 - imenuscale[$55]), "Borderless mode", $00, $00)
                        If (borderlesswindowedsetting <> 0) Then
                            setcolorraw($FF0000)
                            fullscreensetting = $00
                        EndIf
                        text((imenuscale[$15E] + local1), (local2 - imenuscale[$37]), "Fullscreen", $00, $00)
                        If ((borderlesswindowedsetting Or (fullscreensetting = $00)) <> 0) Then
                            setcolorraw($FF0000)
                            bit16modesetting = $00
                        EndIf
                        If (local93 <> 0) Then
                            If ((((((((gfxmodewidths(selectedgfxmode) <> graphicwidth) Or (gfxmodeheights(selectedgfxmode) <> graphicheight)) Or (local97 <> bit16modesetting)) Or (fullscreensetting <> fullscreen)) Or (launcherenabled <> launcherenabledsetting)) Or (borderlesswindowed <> borderlesswindowedsetting)) Or (selectedgfxdriversetting <> selectedgfxdriver)) <> 0) Then
                                If (drawbutton((imenuscale[$136] + local1), (imenuscale[$9B] + local2), imenuscale[$5A], imenuscale[$14], "APPLY", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    changeresolution(gfxmodewidths(selectedgfxmode), gfxmodeheights(selectedgfxmode))
                                EndIf
                                setcolorraw($FF0000)
                                text(local1, (imenuscale[$9B] + local2), "After applying the settings,", $00, $00)
                                text(local1, (imenuscale[$AF] + local2), "the game will be restarted", $00, $00)
                            EndIf
                        EndIf
                    EndIf
                ElseIf (mainmenutab = $05) Then
                    local5 = imenuscale[$DC]
                    drawframe(local1, local2, local4, local5, $00, $00)
                    local2 = (local2 + imenuscale[$14])
                    musicvolume = (slidebar((imenuscale[$136] + local1), (local2 - imenuscale[$04]), imenuscale[$96], (musicvolume * 100.0), $01, 0.0, 100.0, $00) * 0.01)
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Music volume:", $00, $00)
                    If (mouseon((imenuscale[$136] + local1), (local2 - imenuscale[$04]), (imenuscale[$96] + $0E), $14) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "musicvol", musicvolume, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$1E])
                    prevsfxvolume = (slidebar((imenuscale[$136] + local1), (local2 - imenuscale[$04]), imenuscale[$96], (sfxvolume * 100.0), $01, 0.0, 100.0, $00) / 100.0)
                    sfxvolume = prevsfxvolume
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Sound volume:", $00, $00)
                    If (mouseon((imenuscale[$136] + local1), (local2 - imenuscale[$04]), (imenuscale[$96] + $0E), $14) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "soundvol", prevsfxvolume, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$1E])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Sound auto-release:", $00, $00)
                    enablesfxrelease = drawtick((imenuscale[$136] + local1), local2, enablesfxrelease, $00)
                    If (enablesfxrelease_prev <> enablesfxrelease) Then
                        If (enablesfxrelease <> 0) Then
                            For local98 = Each sound
                                For local24 = $00 To $1F Step $01
                                    If (local98\Field2[local24] <> $00) Then
                                        If (channelplaying(local98\Field2[local24]) <> 0) Then
                                            stopchannel(local98\Field2[local24])
                                        EndIf
                                    EndIf
                                Next
                                If (local98\Field0 <> $00) Then
                                    freesound(local98\Field0)
                                    local98\Field0 = $00
                                EndIf
                                local98\Field3 = $00
                                local98\Field4 = $00
                            Next
                        Else
                            For local98 = Each sound
                                If (local98\Field0 = $00) Then
                                    local98\Field0 = loadsound(local98\Field1)
                                EndIf
                            Next
                        EndIf
                        enablesfxrelease_prev = enablesfxrelease
                    EndIf
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int (local91 + (Float imenuscale[$DC]))), "sfxautorelease", 0.0, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$1E])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Enable user tracks:", $00, $00)
                    enableusertracks = drawtick((imenuscale[$136] + local1), local2, enableusertracks, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "usertrack", 0.0, $00)
                    EndIf
                    If (enableusertracks <> 0) Then
                        local2 = (local2 + imenuscale[$1E])
                        setcolorraw($FFFFFF)
                        text((imenuscale[$14] + local1), local2, "User track mode:", $00, $00)
                        usertrackmode = drawtick((imenuscale[$136] + local1), local2, usertrackmode, $00)
                        If (usertrackmode <> 0) Then
                            text((imenuscale[$15E] + local1), local2, "Repeat", $00, $00)
                        Else
                            text((imenuscale[$15E] + local1), local2, "Random", $00, $00)
                        EndIf
                        If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "usertrackmode", 0.0, $00)
                        EndIf
                        If (drawbutton((imenuscale[$14] + local1), (imenuscale[$1E] + local2), imenuscale[$BE], imenuscale[$19], "Scan for User Tracks", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            usertrackcheck = $00
                            usertrackcheck2 = $00
                            If (filesize("SFX\Radio\UserTracks") = $00) Then
                                createdir("SFX\Radio\UserTracks")
                            EndIf
                            local99 = readdir("SFX\Radio\UserTracks\")
                            Repeat
                                local100 = nextfile(local99)
                                If (local100 = "") Then
                                    Exit
                                EndIf
                                If (filetype(("SFX\Radio\UserTracks\" + local100)) = $01) Then
                                    usertrackcheck = (usertrackcheck + $01)
                                    local101 = loadsound(("SFX\Radio\UserTracks\" + local100))
                                    If (local101 <> $00) Then
                                        usertrackcheck2 = (usertrackcheck2 + $01)
                                    EndIf
                                    freesound(local101)
                                EndIf
                            Forever
                            closedir(local99)
                        EndIf
                        If (mouseon((imenuscale[$14] + local1), (imenuscale[$1E] + local2), imenuscale[$BE], imenuscale[$19]) <> 0) Then
                            drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "usertrackscan", 0.0, $00)
                        EndIf
                        If (usertrackcheck > $00) Then
                            text((imenuscale[$14] + local1), (imenuscale[$64] + local2), (((("User tracks found (" + (Str usertrackcheck2)) + "/") + (Str usertrackcheck)) + " successfully loaded)"), $00, $00)
                        EndIf
                    Else
                        usertrackcheck = $00
                    EndIf
                ElseIf (mainmenutab = $06) Then
                    local5 = imenuscale[$140]
                    drawframe(local1, local2, local4, local5, $00, $00)
                    local2 = (local2 + imenuscale[$14])
                    mousesens = ((slidebar((imenuscale[$136] + local1), (local2 - imenuscale[$04]), imenuscale[$96], ((mousesens + 0.5) * 100.0), $01, 0.0, 100.0, $00) / 100.0) - 0.5)
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Mouse sensitivity:", $00, $00)
                    If (mouseon((imenuscale[$136] + local1), (local2 - imenuscale[$04]), (imenuscale[$96] + $0E), $14) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "mousesensitivity", mousesens, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$1E])
                    mousesmooth = (slidebar((imenuscale[$136] + local1), (local2 - imenuscale[$04]), imenuscale[$96], (mousesmooth * 50.0), $01, 0.0, 100.0, $00) / 50.0)
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Mouse smoothing:", $00, $00)
                    If (mouseon((imenuscale[$136] + local1), (local2 - imenuscale[$04]), (imenuscale[$96] + $0E), $14) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "mousesmoothing", mousesmooth, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$28])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Invert mouse Y-axis:", $00, $00)
                    invertmouse = drawtick((imenuscale[$136] + local1), local2, invertmouse, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "mouseinvert", 0.0, $00)
                    EndIf
                    setcolorraw($FFFFFF)
                    text((imenuscale[$17C] + local1), local2, "Raw mouse input:", $00, $00)
                    rawmouseinput = drawtick((imenuscale[$15E] + local1), local2, rawmouseinput, $00)
                    If (mouseon((imenuscale[$15E] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "mouseraw", 0.0, $00)
                    EndIf
                    setcolorraw($FFFFFF)
                    local2 = (local2 + imenuscale[$1E])
                    text((imenuscale[$14] + local1), local2, "Using button (instead of mouse):", $00, $00)
                    mouseinteract = (drawtick((imenuscale[$136] + local1), (Int ((Float local2) + menuscale)), (mouseinteract = $00), $00) = $00)
                    local2 = (local2 + imenuscale[$0A])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), (imenuscale[$14] + local2), "Move Forward", $00, $00)
                    inputbox((imenuscale[$A0] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_up), 210.0))), $05, $00, -1.0)
                    text((imenuscale[$14] + local1), (imenuscale[$28] + local2), "Strafe Left", $00, $00)
                    inputbox((imenuscale[$A0] + local1), (imenuscale[$28] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_left), 210.0))), $03, $00, -1.0)
                    text((imenuscale[$14] + local1), (imenuscale[$3C] + local2), "Move Backward", $00, $00)
                    inputbox((imenuscale[$A0] + local1), (imenuscale[$3C] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_down), 210.0))), $06, $00, -1.0)
                    text((imenuscale[$14] + local1), (imenuscale[$50] + local2), "Strafe Right", $00, $00)
                    inputbox((imenuscale[$A0] + local1), (imenuscale[$50] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_right), 210.0))), $04, $00, -1.0)
                    text((imenuscale[$14] + local1), (imenuscale[$64] + local2), "Quick Save", $00, $00)
                    inputbox((imenuscale[$A0] + local1), (imenuscale[$64] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_save), 210.0))), $0B, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$14] + local2), "Manual Blink", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$14] + local2), (Int (100.0 * menuscale)), imenuscale[$14], keyname((Int min((Float key_blink), 210.0))), $07, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$28] + local2), "Sprint", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$28] + local2), (Int (100.0 * menuscale)), imenuscale[$14], keyname((Int min((Float key_sprint), 210.0))), $08, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$3C] + local2), "Inventory", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$3C] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_inv), 210.0))), $09, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$50] + local2), "Crouch", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$50] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_crouch), 210.0))), $0A, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$64] + local2), "Console", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$64] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_console), 210.0))), $0C, $00, -1.0)
                    text((imenuscale[$14] + local1), (imenuscale[$78] + local2), "Chat", $00, $00)
                    inputbox((imenuscale[$A0] + local1), (imenuscale[$78] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_chat), 210.0))), $0D, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$78] + local2), "Voice", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$78] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_voice), 210.0))), $0E, $00, -1.0)
                    text((imenuscale[$14] + local1), (imenuscale[$8C] + local2), "Jump", $00, $00)
                    inputbox((imenuscale[$A0] + local1), (imenuscale[$8C] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_jump), 210.0))), $0F, $00, -1.0)
                    text((imenuscale[$14] + local1), (imenuscale[$A0] + local2), "Lean L", $00, $00)
                    inputbox((imenuscale[$A0] + local1), (imenuscale[$A0] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_leanl), 210.0))), $10, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$8C] + local2), "Lean R", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$8C] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_leanr), 210.0))), $11, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$8C] + local2), "Lean R", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$8C] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_leanr), 210.0))), $11, $00, -1.0)
                    text((imenuscale[$118] + local1), (imenuscale[$A0] + local2), "Using", $00, $00)
                    inputbox((imenuscale[$1D6] + local1), (imenuscale[$A0] + local2), imenuscale[$64], imenuscale[$14], keyname((Int min((Float key_using), 210.0))), $12, $00, -1.0)
                    If (mouseon((imenuscale[$14] + local1), local2, (local4 - imenuscale[$28]), imenuscale[$78]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "controls", 0.0, $00)
                    EndIf
                    For local24 = $00 To $E3 Step $01
                        If (keyhit(local24) <> 0) Then
                            local102 = local24
                            Exit
                        EndIf
                    Next
                    If (local102 <> $00) Then
                        Select selectedinputbox
                            Case $03
                                key_left = local102
                            Case $04
                                key_right = local102
                            Case $05
                                key_up = local102
                            Case $06
                                key_down = local102
                            Case $07
                                key_blink = local102
                            Case $08
                                key_sprint = local102
                            Case $09
                                key_inv = local102
                            Case $0A
                                key_crouch = local102
                            Case $0B
                                key_save = local102
                            Case $0C
                                key_console = local102
                            Case $0D
                                key_chat = local102
                            Case $0E
                                key_voice = local102
                            Case $0F
                                key_jump = local102
                            Case $10
                                key_leanl = local102
                            Case $11
                                key_leanr = local102
                            Case $12
                                key_using = local102
                        End Select
                        selectedinputbox = $00
                    EndIf
                ElseIf (mainmenutab = $07) Then
                    local5 = imenuscale[$15E]
                    drawframe(local1, local2, local4, local5, $00, $00)
                    local2 = (local2 + imenuscale[$14])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Show HUD:", $00, $00)
                    hudenabled = drawtick((imenuscale[$136] + local1), local2, hudenabled, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "hud", 0.0, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$1E])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Show Overlays:", $00, $00)
                    local104 = overlaysenabled
                    overlaysenabled = drawtick((imenuscale[$136] + local1), local2, overlaysenabled, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "overlays", 0.0, $00)
                    EndIf
                    If (local104 <> overlaysenabled) Then
                        If (overlaysenabled = $00) Then
                            If (infectoverlay <> $00) Then
                                hideentity(infectoverlay)
                            EndIf
                            If (fog <> $00) Then
                                hideentity(fog)
                            EndIf
                            If (gasmaskoverlay <> $00) Then
                                hideentity(gasmaskoverlay)
                            EndIf
                        EndIf
                    EndIf
                    local2 = (local2 + imenuscale[$1E])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Enable console:", $00, $00)
                    canopenconsole = drawtick((imenuscale[$136] + local1), local2, canopenconsole, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "consoleenable", 0.0, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$1E])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Open console on error:", $00, $00)
                    drawtick((imenuscale[$136] + local1), local2, $00, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "consoleerror", 0.0, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$32])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Achievement popups:", $00, $00)
                    achvmsgenabled = drawtick((imenuscale[$136] + local1), local2, achvmsgenabled, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "achpopup", 0.0, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$32])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Show FPS:", $00, $00)
                    showfps = drawtick((imenuscale[$136] + local1), local2, showfps, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "showfps", 0.0, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$32])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Show SCP Viewmodel:", $00, $00)
                    showscpviewmodel = drawtick((imenuscale[$136] + local1), local2, showscpviewmodel, $00)
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "showscpviewmodel", 0.0, $00)
                    EndIf
                    local2 = (local2 + imenuscale[$1E])
                    setcolorraw($FFFFFF)
                    text((imenuscale[$14] + local1), local2, "Framelimit:", $00, $00)
                    If (drawtick((imenuscale[$136] + local1), local2, (0.0 < currframelimit), $00) <> 0) Then
                        currframelimit = (slidebar((imenuscale[$96] + local1), (imenuscale[$1E] + local2), imenuscale[$64], (currframelimit * 99.0), $01, 0.0, 100.0, $00) / 99.0)
                        currframelimit = max(currframelimit, 0.01)
                        framelimit = (Int ((currframelimit * 100.0) + 19.0))
                        setcolorraw($FFFF00)
                        text((imenuscale[$19] + local1), (imenuscale[$19] + local2), ((Str framelimit) + " FPS"), $00, $00)
                    Else
                        currframelimit = 0.0
                        framelimit = $00
                    EndIf
                    If (mouseon((imenuscale[$136] + local1), local2, imenuscale[$14], imenuscale[$14]) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "framelimit", (Float framelimit), $00)
                    EndIf
                    If (mouseon((imenuscale[$96] + local1), (imenuscale[$1E] + local2), (imenuscale[$64] + $0E), $14) <> 0) Then
                        drawoptionstooltip((Int local88), (Int local89), (Int local90), (Int local91), "framelimit", (Float framelimit), $00)
                    EndIf
                    local2 = (local2 + imenuscale[$32])
                EndIf
            Case $04
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$1FE]
                drawframe(local1, local2, local4, local5, $00, $00)
                drawmenulabel("LOAD CUSTOM MAP", $FFFFFF, $FFFFFFFF, $FFFFFFFF)
                local1 = imenuscale[$A0]
                local2 = imenuscale[$178]
                local4 = imenuscale[$244]
                local5 = imenuscale[$15E]
                local6 = imenuscale[$122]
                local7 = imenuscale[$AF]
                setfontex(fonts[$01]\Field0)
                local88 = (Float (local1 + local4))
                local89 = (Float local2)
                local90 = (Float imenuscale[$190])
                local91 = (Float imenuscale[$96])
                If ((Float currloadgamepage) < (ceil(((Float savedmapsamount) / 6.0)) - 1.0)) Then
                    If (drawbutton((imenuscale[$212] + local1), (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], ">", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage + $01)
                    EndIf
                Else
                    drawframe((imenuscale[$212] + local1), (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], $00, $00)
                    setcolorraw($646464)
                    text((imenuscale[$22B] + local1), (imenuscale[$219] + local2), ">", $01, $01)
                EndIf
                If (currloadgamepage > $00) Then
                    If (drawbutton(local1, (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], "<", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage - $01)
                    EndIf
                Else
                    drawframe(local1, (imenuscale[$1FE] + local2), imenuscale[$32], imenuscale[$37], $00, $00)
                    setcolorraw($646464)
                    text((imenuscale[$19] + local1), (imenuscale[$219] + local2), "<", $01, $01)
                EndIf
                drawframe((imenuscale[$32] + local1), (imenuscale[$1FE] + local2), (local4 - imenuscale[$64]), imenuscale[$37], $00, $00)
                text((local1 + local6), (imenuscale[$218] + local2), ((("Page " + (Str (Int max((Float (currloadgamepage + $01)), 1.0)))) + "/") + (Str (Int max((Float (Int ceil(((Float savedmapsamount) / 6.0)))), 1.0)))), $01, $01)
                setfontex(fonts[$00]\Field0)
                If ((Float currloadgamepage) > (ceil(((Float savedmapsamount) / 6.0)) - 1.0)) Then
                    currloadgamepage = (currloadgamepage - $01)
                EndIf
                setfontex(fonts[$00]\Field0)
                If (savedmaps($00) = "") Then
                    text((imenuscale[$14] + local1), (imenuscale[$14] + local2), "No saved maps. Use the Map Creator to create new maps.", $00, $00)
                Else
                    local1 = (local1 + imenuscale[$14])
                    local2 = (local2 + imenuscale[$14])
                    For local24 = (($06 * currloadgamepage) + $01) To (($06 * currloadgamepage) + $06) Step $01
                        If (local24 <= savedmapsamount) Then
                            drawframe(local1, local2, imenuscale[$21C], imenuscale[$46], $00, $00)
                            text((imenuscale[$14] + local1), (imenuscale[$0A] + local2), savedmaps((local24 - $01)), $00, $00)
                            text((imenuscale[$14] + local1), (imenuscale[$1B] + local2), savedmapsauthor((local24 - $01)), $00, $00)
                            If (drawbutton((imenuscale[$190] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E], "Load", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                selectedmap = savedmaps((local24 - $01))
                                mainmenutab = $14
                            EndIf
                            If (mouseon((imenuscale[$190] + local1), (imenuscale[$14] + local2), imenuscale[$64], imenuscale[$1E]) <> 0) Then
                                drawmapcreatortooltip((Int local88), (Int local89), (Int local90), (Int local91), savedmaps((local24 - $01)))
                            EndIf
                            local2 = (local2 + imenuscale[$50])
                        Else
                            Exit
                        EndIf
                    Next
                EndIf
        End Select
    EndIf
    setcolorraw($FFFFFF)
    setfontex(fonts[$05]\Field0)
    local105 = imenuscale[$14]
    local106 = (graphicheight - imenuscale[$32])
    text(local105, local106, ("Multiplayer Mod v" + multiplayer_version), $00, $00)
    formattext((Float local105), (Float (imenuscale[$14] + local106)), "Powered by %clickable|1,https://github.com/krimbopple/BlitzX3D,52,229,235|%BlitzX3D", $00, $00, 1.0, $00)
    local107 = (graphicwidth - imenuscale[$22])
    For local108 = Each workshopthread
        If (local108\Field3 <> "") Then
            If (local108\Field4 = $00) Then
                local108\Field4 = loadimage_strict(local108\Field3)
                resizeimage(local108\Field4, (Float imenuscale[$18]), (Float imenuscale[$10]))
            EndIf
            local109 = imenuscale[$18]
            local110 = imenuscale[$10]
            local111 = (graphicheight - imenuscale[$1E])
            If (mouseon(local107, local111, local109, local110) <> 0) Then
                setcolorraw($FF0000)
                rect(local107, local111, (imenuscale[$02] + local109), (imenuscale[$02] + local110), $00)
                If (mousehit1 <> 0) Then
                    public_inqueue($0F, $00)
                    public_update_current(local108\Field2, $00)
                    public_clear()
                EndIf
            EndIf
            drawimage(local108\Field4, local107, local111, $00)
            local107 = (local107 - imenuscale[$22])
        EndIf
    Next
    ui_showpointer()
    Return $00
End Function
