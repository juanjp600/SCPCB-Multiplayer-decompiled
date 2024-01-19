Function updatemainmenu%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local6.servers
    Local local7%
    Local local8$
    Local local10#
    Local local11%
    Local local13%[14]
    Local local14%[8]
    Local local17%
    Local local19%
    Local local20#
    Local local21%
    Local local22.players
    Local local23#
    Local local24#
    Local local25#
    Local local26#
    Local local27#
    Local local28%
    Local local29%
    Local local30%
    Local local31#
    Local local32%
    Local local33#
    Local local34#
    Local local35%
    Local local37%
    Local local38%
    Local local40#
    Local local42$
    Local local44#
    Local local45#
    Local local46.errors
    Local local47#
    Local local48#
    Local local49#
    Local local50#
    Local local51%
    Local local52%
    Local local53#
    Local local54#
    Local local55$
    Local local56#
    Local local57.servers
    Local local58#
    Local local59#
    Local local60.tempservers[372]
    Local local61%
    Local local62%
    Local local63.servers
    Local local65%
    Local local66%
    Local local67%
    Local local68$
    Local local69%[65]
    Local local70%
    Local local71$
    Local local72%
    Local local73%
    Local local74%
    Local local75%
    Local local76%
    Local local77$
    Local local78#
    Local local79#
    Local local80#
    Local local81#
    Local local83%
    Local local84#
    Local local85#
    Local local86%
    Local local87.sound
    Local local88%
    Local local89$
    Local local90%
    Local local91%
    Local local93.workshopthread
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
    color($00, $00, $00)
    rect($00, $00, graphicwidth, graphicheight, $01)
    showpointer()
    drawimage(menuback, $00, $00, $00)
    If ((millisecs2() Mod menublinktimer($00)) >= rand(menublinkduration($00), $01)) Then
        drawimage(menu173, (graphicwidth - imagewidth(menu173)), (graphicheight - imageheight(menu173)), $00)
    EndIf
    If (rand($12C, $01) = $01) Then
        menublinktimer($00) = rand($FA0, $1F40)
        menublinkduration($00) = rand($C8, $1F4)
    EndIf
    aasetfont(font1)
    menublinktimer($01) = (Int ((Float menublinktimer($01)) - fpsfactor))
    If (menublinktimer($01) < menublinkduration($01)) Then
        color($32, $32, $32)
        aatext((rand($FFFFFFFB, $05) + menustrx), (rand($FFFFFFFB, $05) + menustry), menustr, $01, $00, 1.0)
        If (menublinktimer($01) < $00) Then
            menublinktimer($01) = rand($2BC, $320)
            menublinkduration($01) = rand($0A, $23)
            menustrx = (Int ((Float rand($2BC, $3E8)) * menuscale))
            menustry = (Int ((Float rand($64, $258)) * menuscale))
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
    aasetfont(font2)
    drawimage(menutext, ((graphicwidth Sar $01) - (imagewidth(menutext) Sar $01)), (Int (((Float graphicheight) - (20.0 * menuscale)) - (Float imageheight(menutext)))), $00)
    If ((Float graphicwidth) > (1240.0 * menuscale)) Then
        drawtiledimagerect(menuwhite, $00, $05, 512.0, (7.0 * menuscale), (Int (985.0 * menuscale)), (Int (407.0 * menuscale)), (Int (((Float graphicwidth) - (1240.0 * menuscale)) + 300.0)), (Int (7.0 * menuscale)))
    EndIf
    If (mousedown1 = $00) Then
        onsliderid = $00
    EndIf
    If (globalserverupdate < millisecs()) Then
        For local6 = Each servers
            If (local6\Field0 = selected_servers) Then
                multiplayer_list_updateserver(local6, $1388, $01)
            EndIf
        Next
        globalserverupdate = (millisecs() + $7530)
    EndIf
    If (mainmenutab = $00) Then
        For local7 = $00 To $04 Step $01
            local4 = $00
            local0 = (Int (159.0 * menuscale))
            local1 = (Int ((Float (($64 * local7) + $11E)) * menuscale))
            local2 = (Int (400.0 * menuscale))
            local3 = (Int (70.0 * menuscale))
            local4 = (mousehit1 And mouseon(local0, local1, local2, local3))
            If (local4 <> 0) Then
                playsound_strict(buttonsfx)
            EndIf
            Select local7
                Case $00
                    local8 = "MULTIPLAYER"
                    randomseed = ""
                    If (local4 <> 0) Then
                        If (udp_getstream() <> 0) Then
                            mainmenutab = $0E
                        Else
                            For local6 = Each servers
                                If (((local6\Field0 = selected_servers) And (local6\Field17 = selected_page)) <> 0) Then
                                    multiplayer_list_updateserver(local6, $1388, $01)
                                EndIf
                            Next
                            mainmenutab = $01
                            local10 = 0.0
                            For local6 = Each servers
                                If (((local6\Field0 = selected_servers) And (((local6\Field4 = $00) And ((local6\Field0 = $01) Or (local6\Field0 = $05))) = $00)) <> 0) Then
                                    local10 = ((35.0 * menuscale) + local10)
                                EndIf
                            Next
                            local3 = (Int (206.0 * menuscale))
                            local11 = $97
                            local3 = (Int (((Float local11) * menuscale) + (Float local3)))
                            chatscroll = ((- local10) + (Float local3))
                        EndIf
                        Exit
                    EndIf
                Case $01
                    local8 = "NEW GAME"
                    randomseed = ""
                    If (local4 <> 0) Then
                        If (udp_getstream() <> 0) Then
                            mainmenutab = $0E
                        Else
                            randomseed = setrandomseed()
                            mainmenutab = $14
                        EndIf
                        Exit
                    EndIf
                Case $02
                    local8 = "LOAD GAME"
                    If (local4 <> 0) Then
                        If (udp_getstream() <> 0) Then
                            mainmenutab = $0E
                        Else
                            loadsavegames()
                            mainmenutab = $02
                        EndIf
                        Exit
                    EndIf
                Case $03
                    local8 = "OPTIONS"
                    If (local4 <> 0) Then
                        mainmenutab = $03
                    EndIf
                Case $04
                    local8 = "QUIT"
                    If (local4 <> 0) Then
                        sendstatisticrequest($08)
                        closegame()
                    EndIf
            End Select
            drawbutton(local0, local1, local2, local3, local8, $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Next
    Else
        local0 = (Int (159.0 * menuscale))
        local1 = (Int (286.0 * menuscale))
        local2 = (Int (400.0 * menuscale))
        local3 = (Int (70.0 * menuscale))
        drawframe(local0, local1, local2, local3, $00, $00)
        If (drawbutton((Int ((20.0 * menuscale) + (Float (local0 + local2)))), local1, (Int (((580.0 * menuscale) - (Float local2)) - (20.0 * menuscale))), (Int ((Float local3) - ((((Float local3) / 2.1) * (Float udp_getstream())) * (Float (mainmenutab = $0E))))), "BACK", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            networkserver\Field26 = $00
            savemultiplayeroptions()
            Select mainmenutab
                Case $0E
                    mainmenutab = $00
                Case $20
                    mainmenutab = prevmainmenutab
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
                Case $08
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
                    mainmenutab = $00
                Case $04
                    mainmenutab = $14
                    currloadgamepage = $00
                    mousehit1 = $00
                Default
                    mainmenutab = $00
            End Select
            mousehit1 = $00
        EndIf
        If ((udp_getstream() * (mainmenutab = $0E)) <> 0) Then
            If (drawbutton((Int ((20.0 * menuscale) + (Float (local0 + local2)))), ((local3 Sar $01) + local1), (Int (((580.0 * menuscale) - (Float local2)) - (20.0 * menuscale))), (Int ((Float local3) - (((Float local3) / 2.1) - (4.0 * menuscale)))), "DISCONNECT", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                disconnectserver("", $01)
            EndIf
        EndIf
        Select mainmenutab
            Case $14
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "NEW GAME", $01, $01, 1.0)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (330.0 * menuscale))
                drawframe(local0, local1, local2, local3, $00, $00)
                aasetfont(font1)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "Name:", $00, $00, 1.0)
                currsave = inputbox((Int ((150.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), currsave, $01, $00, -1.0)
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
                color($FF, $FF, $FF)
                If (selectedmap = "") Then
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), "Map seed:", $00, $00, 1.0)
                    randomseed = left(inputbox((Int ((150.0 * menuscale) + (Float local0))), (Int ((55.0 * menuscale) + (Float local1))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), randomseed, $03, $00, -1.0), $0F)
                Else
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), "Selected map:", $00, $00, 1.0)
                    color($FF, $FF, $FF)
                    rect((Int ((150.0 * menuscale) + (Float local0))), (Int ((55.0 * menuscale) + (Float local1))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), $01)
                    color($00, $00, $00)
                    rect((Int (((150.0 * menuscale) + (Float local0)) + 2.0)), (Int (((55.0 * menuscale) + (Float local1)) + 2.0)), (Int ((200.0 * menuscale) - 4.0)), (Int ((30.0 * menuscale) - 4.0)), $01)
                    color($FF, $00, $00)
                    If (len(selectedmap) > $0F) Then
                        aatext((Int (((150.0 * menuscale) + (Float local0)) + (100.0 * menuscale))), (Int (((55.0 * menuscale) + (Float local1)) + (15.0 * menuscale))), (left(selectedmap, $0E) + "..."), $01, $01, 1.0)
                    Else
                        aatext((Int (((150.0 * menuscale) + (Float local0)) + (100.0 * menuscale))), (Int (((55.0 * menuscale) + (Float local1)) + (15.0 * menuscale))), selectedmap, $01, $01, 1.0)
                    EndIf
                    If (drawbutton((Int ((370.0 * menuscale) + (Float local0))), (Int ((55.0 * menuscale) + (Float local1))), (Int (120.0 * menuscale)), (Int (30.0 * menuscale)), "Deselect", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        selectedmap = ""
                    EndIf
                EndIf
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((110.0 * menuscale) + (Float local1))), "Enable intro sequence:", $00, $00, 1.0)
                introenabled = drawtick((Int ((280.0 * menuscale) + (Float local0))), (Int ((110.0 * menuscale) + (Float local1))), introenabled, $00)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((150.0 * menuscale) + (Float local1))), "Difficulty:", $00, $00, 1.0)
                For local7 = $00 To $03 Step $01
                    If (drawtick((Int ((20.0 * menuscale) + (Float local0))), (Int (((Float (($1E * local7) + $B4)) * menuscale) + (Float local1))), (selecteddifficulty = difficulties(local7)), $00) <> 0) Then
                        selecteddifficulty = difficulties(local7)
                    EndIf
                    color(difficulties(local7)\Field6, difficulties(local7)\Field7, difficulties(local7)\Field8)
                    aatext((Int ((60.0 * menuscale) + (Float local0))), (Int (((Float (($1E * local7) + $B4)) * menuscale) + (Float local1))), difficulties(local7)\Field0, $00, $00, 1.0)
                Next
                color($FF, $FF, $FF)
                drawframe((Int ((150.0 * menuscale) + (Float local0))), (Int ((155.0 * menuscale) + (Float local1))), (Int (410.0 * menuscale)), (Int (150.0 * menuscale)), $00, $00)
                If (selecteddifficulty\Field9 <> 0) Then
                    selecteddifficulty\Field2 = drawtick((Int ((160.0 * menuscale) + (Float local0))), (Int ((165.0 * menuscale) + (Float local1))), selecteddifficulty\Field2, $00)
                    aatext((Int ((200.0 * menuscale) + (Float local0))), (Int ((165.0 * menuscale) + (Float local1))), "Permadeath", $00, $00, 1.0)
                    If (drawtick((Int ((160.0 * menuscale) + (Float local0))), (Int ((195.0 * menuscale) + (Float local1))), ((selecteddifficulty\Field4 = $00) And (selecteddifficulty\Field2 = $00)), selecteddifficulty\Field2) <> 0) Then
                        selecteddifficulty\Field4 = $00
                    Else
                        selecteddifficulty\Field4 = $02
                    EndIf
                    aatext((Int ((200.0 * menuscale) + (Float local0))), (Int ((195.0 * menuscale) + (Float local1))), "Save anywhere", $00, $00, 1.0)
                    selecteddifficulty\Field3 = drawtick((Int ((160.0 * menuscale) + (Float local0))), (Int ((225.0 * menuscale) + (Float local1))), selecteddifficulty\Field3, $00)
                    aatext((Int ((200.0 * menuscale) + (Float local0))), (Int ((225.0 * menuscale) + (Float local1))), "Aggressive NPCs", $00, $00, 1.0)
                    color($FF, $FF, $FF)
                    drawimage(arrowimg($01), (Int ((155.0 * menuscale) + (Float local0))), (Int ((251.0 * menuscale) + (Float local1))), $00)
                    If (mousehit1 <> 0) Then
                        If (imagerectoverlap(arrowimg($01), (Int ((155.0 * menuscale) + (Float local0))), (Int ((251.0 * menuscale) + (Float local1))), scaledmousex(), scaledmousey(), $00, $00) <> 0) Then
                            If (selecteddifficulty\Field5 < $02) Then
                                selecteddifficulty\Field5 = (selecteddifficulty\Field5 + $01)
                            Else
                                selecteddifficulty\Field5 = $00
                            EndIf
                            playsound_strict(buttonsfx)
                        EndIf
                    EndIf
                    color($FF, $FF, $FF)
                    Select selecteddifficulty\Field5
                        Case $00
                            aatext((Int ((200.0 * menuscale) + (Float local0))), (Int ((255.0 * menuscale) + (Float local1))), "Other difficulty factors: Easy", $00, $00, 1.0)
                        Case $01
                            aatext((Int ((200.0 * menuscale) + (Float local0))), (Int ((255.0 * menuscale) + (Float local1))), "Other difficulty factors: Normal", $00, $00, 1.0)
                        Case $02
                            aatext((Int ((200.0 * menuscale) + (Float local0))), (Int ((255.0 * menuscale) + (Float local1))), "Other difficulty factors: Hard", $00, $00, 1.0)
                    End Select
                Else
                    rowtext(selecteddifficulty\Field1, ((160.0 * menuscale) + (Float local0)), ((160.0 * menuscale) + (Float local1)), (390.0 * menuscale), 200.0, $00, 1.0, $00)
                EndIf
                If (drawbutton(local0, (Int ((20.0 * menuscale) + (Float (local1 + local3)))), (Int (160.0 * menuscale)), (Int (70.0 * menuscale)), "Load map", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $04
                    loadsavedmaps()
                EndIf
                aasetfont(font2)
                If (drawbutton((Int ((420.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float (local1 + local3)))), (Int (160.0 * menuscale)), (Int (70.0 * menuscale)), "START", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    If (currsave = "") Then
                        currsave = "untitled"
                    EndIf
                    If (randomseed = "") Then
                        randomseed = (Str (Abs millisecs()))
                    EndIf
                    seedrnd(generateseednumber(randomseed))
                    local17 = $00
                    For local7 = $01 To savegameamount Step $01
                        If ((((local17 = $00) And (savegames((local7 - $01)) = currsave)) Or ((local17 > $00) And (savegames((local7 - $01)) = (((currsave + " (") + (Str (local17 + $01))) + ")")))) <> 0) Then
                            local17 = (local17 + $01)
                            local7 = $00
                        EndIf
                    Next
                    If (local17 > $00) Then
                        currsave = (((currsave + " (") + (Str (local17 + $01))) + ")")
                    EndIf
                    loadentities()
                    loadallsounds()
                    initnewgame()
                    mainmenuopen = $00
                    flushkeys()
                    flushmouse()
                    putinivalue(optionfile, "options", "intro enabled", (Str introenabled))
                EndIf
            Case $20
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "INPUTS", $01, $01, 1.0)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (330.0 * menuscale))
                drawframe(local0, local1, local2, (Int ((60.0 * menuscale) + (Float local3))), $00, $00)
                aasetfont(font1)
                For local7 = $00 To (snd_in_count() - $01) Step $01
                    color($00, $FF, $00)
                    If (voice\Field9 = local7) Then
                        aatext((Int (((Float ((aastringwidth(snd_in_name($00)) Shl $01) + $0A)) * menuscale) + (Float local0))), (Int (((Float ((local7 + $01) * $14)) * menuscale) + (Float local1))), "SELECTED", $00, $00, 1.0)
                    EndIf
                    color($FF, $FF, $FF)
                    If (drawbutton((Int ((10.0 * menuscale) + (Float local0))), (Int (((Float ((local7 + $01) * $14)) * menuscale) + (Float local1))), (Int ((Float (aastringwidth(snd_in_name($00)) Shl $01)) * menuscale)), (Int (((Float aastringheight(snd_in_name($00))) * 1.5) * menuscale)), snd_in_name($00), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        voice\Field9 = local7
                    EndIf
                Next
            Case $0C,$15
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "SETTINGS", $01, $01, 1.0)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (330.0 * menuscale))
                drawframe(local0, local1, local2, (Int ((60.0 * menuscale) + (Float local3))), $00, $00)
                aasetfont(font1)
                If (drawbutton(local0, local1, (local2 Sar $01), (Int (30.0 * menuscale)), "MULTIPLAYER", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selectedsettings = $00
                EndIf
                If (drawbutton(((local2 Sar $01) + local0), local1, (local2 Sar $01), (Int (30.0 * menuscale)), "VOICE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selectedsettings = $01
                EndIf
                Select selectedsettings
                    Case $00
                        local1 = (Int ((20.0 * menuscale) + (Float local1)))
                        aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), "Name:", $00, $00, 1.0)
                        If (udp_getstream() = $00) Then
                            nickname = left(inputbox((Int ((115.0 * menuscale) + (Float local0))), (Int ((35.0 * menuscale) + (Float local1))), (Int (250.0 * menuscale)), (Int (30.0 * menuscale)), nickname, $01, $00, -1.0), $18)
                        Else
                            aasetfont(fontsl)
                            color($FF, $00, $00)
                            aatext((Int ((115.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), "Name change not available", $00, $00, 1.0)
                            color($FF, $FF, $FF)
                            aasetfont(font1)
                            inputbox((Int ((115.0 * menuscale) + (Float local0))), (Int ((35.0 * menuscale) + (Float local1))), (Int (250.0 * menuscale)), (Int (30.0 * menuscale)), nickname, $01, $00, -1.0)
                        EndIf
                        aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), "See players HUD:", $00, $00, 1.0)
                        networkserver\Field25 = (drawtick((Int ((280.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), networkserver\Field25, $00) <> $00)
                        If (mouseon((Int ((280.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstoolimage((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (150.0 * menuscale)), (Int (246.0 * menuscale)), mpimg\Field7[networkserver\Field25])
                        EndIf
                        aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((110.0 * menuscale) + (Float local1))), ("Download speed (bytes/ms): " + (Str (Int networkserver\Field41))), $00, $00, 1.0)
                        networkserver\Field41 = (slidebar((Int ((270.0 * menuscale) + (Float local0))), (Int ((110.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (networkserver\Field41 * 0.012), $00) / 0.012)
                        If (((512.0 > networkserver\Field41) Or (8334.0 < networkserver\Field41)) <> 0) Then
                            networkserver\Field41 = 512.0
                        EndIf
                        local19 = (0.0 <> mainplayersvolume)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), "Voice chat:", $00, $00, 1.0)
                        local20 = mainplayersvolume
                        local21 = drawtick((Int ((280.0 * menuscale) + (Float local0))), (Int ((149.0 * menuscale) + (Float local1))), local19, $00)
                        If (local21 <> local19) Then
                            If (local19 = $01) Then
                                mainplayersvolume = 0.0
                            Else
                                mainplayersvolume = 1.0
                            EndIf
                        EndIf
                        mainplayersvolume = (slidebar((Int ((165.0 * menuscale) + (Float local0))), (Int ((170.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (mainplayersvolume * 100.0), $00) / 100.0)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((170.0 * menuscale) + (Float local1))), ("Players volume: " + (Str (Int (mainplayersvolume * 100.0)))), $00, $00, 1.0)
                        If (mainplayersvolume <> local20) Then
                            For local22 = Each players
                                local22\Field65 = mainplayersvolume
                            Next
                        EndIf
                        aasetfont(fontsl)
                        If (drawbutton((Int ((20.0 * menuscale) + (Float local0))), (Int ((200.0 * menuscale) + (Float local1))), (Int (230.0 * menuscale)), (Int (25.0 * menuscale)), "Reload server list", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            For local6 = Each servers
                                multiplayer_list_deleteserver(local6)
                            Next
                            selectserver = $FFFFFFFF
                            loadmultiplayeroptions($00)
                            initmultiplayer($04, $01)
                            For local7 = $00 To $0A Step $01
                                For local0 = $00 To $04 Step $01
                                    serverpages[local7]\Field0[local0] = $FFFFFFFF
                                Next
                            Next
                        EndIf
                        aasetfont(font1)
                    Case $01
                        If (voice\Field3 <> 0) Then
                            local23 = voice\Field6
                            voice\Field6 = (slidebar((Int ((20.0 * menuscale) + (Float local0))), (Int ((110.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (voice\Field6 * 100.0), $00) / 100.0)
                            aatext((Int ((50.0 * menuscale) + (Float local0))), (Int ((90.0 * menuscale) + (Float local1))), ("Volume: " + (Str (Int (voice\Field6 * 100.0)))), $00, $00, 1.0)
                            color($00, $FF, $00)
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((50.0 * menuscale) + (Float local1))), ("Current input: " + fsound_record_getdrivername($01)), $00, $00, 1.0)
                        Else
                            color($FF, $00, $00)
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((50.0 * menuscale) + (Float local1))), "Microphone not connected", $00, $00, 1.0)
                        EndIf
                        If (drawbutton((Int ((20.0 * menuscale) + (Float local0))), (Int ((150.0 * menuscale) + (Float local1))), (Int (200.0 * menuscale)), (Int (60.0 * menuscale)), "CHECK MICROPHONE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            networkserver\Field26 = (networkserver\Field26 = $00)
                            If (udp_getstream() = $00) Then
                                networkserver\Field30 = $BB80
                            EndIf
                        EndIf
                        local24 = ((20.0 * menuscale) + (Float local0))
                        local25 = ((230.0 * menuscale) + (Float local1))
                        local26 = ((20.0 * menuscale) + (Float local0))
                        local27 = ((230.0 * menuscale) + (Float local1))
                        drawframeblack((Int local26), (Int local27), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), $00, $00)
                        local26 = ((2.0 * menuscale) + local26)
                        local27 = ((50.0 * menuscale) + local27)
                        color($F1, $18, $4F)
                        renderprogressbary((Int local26), (Int local27), (Int ((50.0 * menuscale) - (2.0 * menuscale))), (Int ((50.0 * menuscale) - (2.0 * menuscale))), 0.2, max(voice\Field16, 0.0))
                        If (networkserver\Field26 <> 0) Then
                            voice\Field16 = curvevalue((voice_get_offset() - 0.74), voice\Field16, 7.0)
                            drawimage(mpimg\Field2, (Int local24), (Int local25), $00)
                        Else
                            voice\Field16 = curvevalue(0.0, voice\Field16, 7.0)
                            drawimage(mpimg\Field3, (Int local24), (Int local25), $00)
                        EndIf
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((355.0 * menuscale) + (Float local1))), "Push-to-talk:", $00, $00, 1.0)
                        voice\Field14 = (drawtick((Int ((165.0 * menuscale) + (Float local0))), (Int ((355.0 * menuscale) + (Float local1))), (voice\Field14 = $00), $00) = $00)
                        If (drawbutton((Int ((20.0 * menuscale) + (Float local0))), (Int ((310.0 * menuscale) + (Float local1))), (Int (180.0 * menuscale)), (Int (30.0 * menuscale)), "RESTART VOICE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            voice_remove()
                            voice_init()
                            networkserver\Field30 = $BB80
                            delay($3E8)
                        EndIf
                End Select
            Case $01
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (424.0 * menuscale))
                local2 = (Int (606.0 * menuscale))
                local3 = (Int (206.0 * menuscale))
                local11 = $97
                local3 = (Int (((Float local11) * menuscale) + (Float local3)))
                local10 = (0.0 * menuscale)
                local28 = $00
                For local6 = Each servers
                    If (((local6\Field0 = selected_servers) And (((local6\Field4 = $00) And ((local6\Field0 = $01) Or (local6\Field0 = $05))) = $00)) <> 0) Then
                        local10 = ((35.0 * menuscale) + local10)
                    EndIf
                Next
                If (0.0 <> local10) Then
                    local28 = (Int (((Float local3) / local10) * (Float local3)))
                    If (local28 > local3) Then
                        local28 = local3
                    EndIf
                    If ((Float local3) > local10) Then
                        local10 = (Float local3)
                    EndIf
                    color($C8, $C8, $C8)
                    local29 = mouseon((Int ((Float (local0 + local2)) - (26.0 * menuscale))), (Int ((Float local1) - (2.0 * menuscale))), (Int (26.0 * menuscale)), (Int ((2.0 * menuscale) + (Float local3))))
                    drawframe((Int ((Float (local0 + local2)) - (26.0 * menuscale))), (Int ((Float local1) - (2.0 * menuscale))), (Int (26.0 * menuscale)), (Int ((2.0 * menuscale) + (Float local3))), $00, $00)
                    color($64, $64, $64)
                    local30 = mouseon((Int ((Float (local0 + local2)) - (23.0 * menuscale))), (Int (((chatscroll * (Float local28)) / (Float local3)) + (Float ((local1 + local3) - local28)))), (Int (20.0 * menuscale)), local28)
                    If (local30 <> 0) Then
                        color($78, $78, $78)
                    EndIf
                    If (chatscrolldragging <> 0) Then
                        color($82, $82, $82)
                    EndIf
                    rect((Int ((Float (local0 + local2)) - (23.0 * menuscale))), (Int ((((chatscroll * (Float local28)) / (Float local3)) + (Float ((local1 + local3) - local28))) + (1.0 * menuscale))), (Int (20.0 * menuscale)), (Int ((Float local28) - (4.0 * menuscale))), $01)
                    If (mousedown($01) = $00) Then
                        chatscrolldragging = $00
                    ElseIf (chatscrolldragging <> 0) Then
                        chatscroll = (((((Float scaledmousey()) - chatmousemem) * (Float local3)) / (Float local28)) + chatscroll)
                        chatmousemem = (Float scaledmousey())
                    EndIf
                    If (chatscrolldragging = $00) Then
                        If (mousehit1 <> 0) Then
                            If (local30 <> 0) Then
                                chatscrolldragging = $01
                                chatmousemem = (Float scaledmousey())
                            ElseIf (local29 <> 0) Then
                                chatscroll = (((((Float (scaledmousey() - (local1 + local3))) * local10) / (Float local3)) + (Float (local3 Sar $01))) + chatscroll)
                                chatscroll = (chatscroll / 2.0)
                            EndIf
                        EndIf
                    EndIf
                    local31 = (Float mousezspeed())
                    If (0.0 < local31) Then
                        chatscroll = (chatscroll - (15.0 * menuscale))
                    ElseIf (0.0 > local31) Then
                        chatscroll = ((15.0 * menuscale) + chatscroll)
                    EndIf
                    If (chatscroll < ((- local10) + (Float local3))) Then
                        chatscroll = ((- local10) + (Float local3))
                    EndIf
                    If (0.0 < chatscroll) Then
                        chatscroll = 0.0
                    EndIf
                    local33 = sqrvalue((((- local10) + (Float local3)) - chatscroll))
                    local34 = ((35.0 * menuscale) + (Float local1))
                    For local6 = Each servers
                        local6\Field17 = $01
                        If (((local6\Field0 = selected_servers) And (((local6\Field4 = $00) And ((local6\Field0 = $01) Or (local6\Field0 = $05))) = $00)) <> 0) Then
                            If (local34 >= (((Float local1) + local33) - (35.0 * menuscale))) Then
                                If (local34 <= (((Float (local1 + local3)) + local33) + (70.0 * menuscale))) Then
                                    local6\Field17 = $00
                                EndIf
                            EndIf
                            local34 = ((35.0 * menuscale) + local34)
                        EndIf
                    Next
                EndIf
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "MULTIPLAYER", $01, $01, 1.0)
                aasetfont(font1)
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (306.0 * menuscale))
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (335.0 * menuscale))
                drawframe(local0, local1, local2, (Int (((Float ((((selected_servers <> $01) And (selected_servers <> $05)) * $2A) + local11)) * menuscale) + (Float local3))), $00, $00)
                drawframe((Int ((290.0 * menuscale) + (Float local0))), local1, (Int (2.0 * menuscale)), (Int (25.0 * menuscale)), $00, $00)
                drawframe((Int ((390.0 * menuscale) + (Float local0))), local1, (Int (2.0 * menuscale)), (Int (25.0 * menuscale)), $00, $00)
                drawframe((Int ((490.0 * menuscale) + (Float local0))), local1, (Int (2.0 * menuscale)), (Int (25.0 * menuscale)), $00, $00)
                drawframe(local0, (Int ((25.0 * menuscale) + (Float local1))), local2, (Int (2.0 * menuscale)), $00, $00)
                If (drawbaldbutton((Int ((1.0 * menuscale) + (Float local0))), (Int ((2.0 * menuscale) + (Float local1))), (Int ((290.0 * menuscale) - (1.0 * menuscale))), (Int (24.13793 * menuscale)), " ", $00, $00, $01) <> 0) Then
                    local35 = $01
                EndIf
                If (drawbaldbutton((Int ((290.0 * menuscale) + (Float local0))), (Int ((2.0 * menuscale) + (Float local1))), (Int (99.0 * menuscale)), (Int (24.13793 * menuscale)), " ", $00, $00, $01) <> 0) Then
                    local35 = $02
                EndIf
                If (drawbaldbutton((Int ((391.0 * menuscale) + (Float local0))), (Int ((2.0 * menuscale) + (Float local1))), (Int (99.0 * menuscale)), (Int (24.13793 * menuscale)), " ", $00, $00, $01) <> 0) Then
                    local35 = $03
                EndIf
                If (drawbaldbutton((Int ((491.0 * menuscale) + (Float local0))), (Int ((2.0 * menuscale) + (Float local1))), (Int (86.0 * menuscale)), (Int (24.13793 * menuscale)), " ", $00, $00, $01) <> 0) Then
                    local35 = $04
                EndIf
                If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] >= $00) Then
                    Select serverpages[selected_servers]\Field1
                        Case $01
                            drawimage(mpimg\Field8[serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1]], (Int ((260.0 * menuscale) + (Float local0))), (Int ((8.0 * menuscale) + (Float local1))), $00)
                        Case $02
                            drawimage(mpimg\Field8[serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1]], (Int ((370.0 * menuscale) + (Float local0))), (Int ((8.0 * menuscale) + (Float local1))), $00)
                        Case $03
                            drawimage(mpimg\Field8[serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1]], (Int ((471.0 * menuscale) + (Float local0))), (Int ((8.0 * menuscale) + (Float local1))), $00)
                        Case $04
                            drawimage(mpimg\Field8[serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1]], (Int ((557.0 * menuscale) + (Float local0))), (Int ((8.0 * menuscale) + (Float local1))), $00)
                    End Select
                EndIf
                aasetfont(fontservers)
                aatext((Int ((30.0 * menuscale) + (Float local0))), (Int ((8.0 * menuscale) + (Float local1))), "Servers", $00, $00, 1.0)
                aatext((Int ((305.0 * menuscale) + (Float local0))), (Int ((8.0 * menuscale) + (Float local1))), "Players", $00, $00, 1.0)
                aatext((Int ((410.0 * menuscale) + (Float local0))), (Int ((8.0 * menuscale) + (Float local1))), "Map", $00, $00, 1.0)
                aatext((Int ((510.0 * menuscale) + (Float local0))), (Int ((8.0 * menuscale) + (Float local1))), "Ping", $00, $00, 1.0)
                aasetfont(font1)
                For local7 = $00 To $0D Step $01
                    If (local13[local7] = $01) Then
                        If (selected_page = local7) Then
                            drawbutton((Int (((Float (((local7 + $01) * $23) + $14)) * menuscale) + (Float local0))), (Int (((Float (($104 + local11) - $28)) * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local7 + $01)), $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        ElseIf (drawbutton((Int (((Float (((local7 + $01) * $23) + $14)) * menuscale) + (Float local0))), (Int (((Float (($104 + local11) - $28)) * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local7 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            selected_page = local7
                            mousehit1 = $00
                        EndIf
                        drawframe((Int ((20.0 * menuscale) + (Float local0))), (Int (((Float (($104 + local11) - $0A)) * menuscale) + (Float local1))), (Int ((Float local2) - (40.0 * menuscale))), $02, $00, $00)
                    EndIf
                Next
                local38 = (Int (-5.0 * menuscale))
                local32 = $00
                disableredirectaccess = $01
                For local6 = Each servers
                    If ((((local6\Field0 = selected_servers) And (local6\Field17 = selected_page)) And (local32 < $0C)) <> 0) Then
                        local37 = $00
                        If (local6\Field19 <> 0) Then
                            local37 = (Int ((Float local37) + 12.93104))
                        EndIf
                        If ((local6\Field7 And local6\Field25) <> 0) Then
                            local37 = (Int ((Float local37) + (1.0 / 0.075)))
                        EndIf
                        Select selected_servers
                            Case $01,$05,$04
                                If (local6\Field4 <> $00) Then
                                    local32 = (local32 + $01)
                                    local38 = (Int ((Float local38) + 30.17241))
                                    local40 = sfxvolume
                                    If (((((connectmenu = $00) And (passwordmenu = $00)) And (servermenuopen = $00)) And (addservermenu = $00)) = $00) Then
                                        sfxvolume = 0.0
                                    EndIf
                                    If (drawbutton(local0, (Int (((Float (local38 - $00)) * menuscale) + (Float local1))), local2, (Int (30.17241 * menuscale)), "", $00, $00, $01, (Handle local6), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                        If (((((connectmenu = $00) And (passwordmenu = $00)) And (servermenuopen = $00)) And (addservermenu = $00)) <> 0) Then
                                            selectserver = (Handle local6)
                                            If (doubleclick <> 0) Then
                                                servermenuopen = (servermenuopen = $00)
                                                doubleclick = $00
                                                multiplayer_list_updateserver(local6, $BB8, $02)
                                            Else
                                                multiplayer_list_updateserver(local6, $BB8, $03)
                                            EndIf
                                        EndIf
                                    EndIf
                                    sfxvolume = local40
                                    Select local6\Field9
                                        Case "Started"
                                            color($FF, $FF, $00)
                                        Case "Password"
                                            color($FF, $00, $00)
                                        Case "In lobby"
                                            color($00, $FF, $00)
                                        Case "Offline"
                                            color($FF, $FF, $FF)
                                        Default
                                            color($FF, $FF, $FF)
                                    End Select
                                    oval((Int ((15.0 * menuscale) + (Float local0))), (Int ((((Float local38) + (1.0 / 0.08125)) * menuscale) + (Float local1))), (Int ((1.0 / 0.145) * menuscale)), (Int ((1.0 / 0.145) * menuscale)), $01)
                                    color($FF, $FF, $FF)
                                    For local7 = $01 To $01 Step $01
                                    Next
                                    If ((local6\Field7 And local6\Field25) <> 0) Then
                                        drawimage(mpimg\Field5, (Int ((30.17241 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), $00)
                                        If (mouseon((Int ((30.17241 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), imagewidth(mpimg\Field5), imageheight(mpimg\Field5)) <> 0) Then
                                            aasetfont(fontsl)
                                            drawtextrect((Int ((30.17241 * menuscale) + (Float local0))), (Int ((((Float local38) - 5.384615) * menuscale) + (Float local1))), (Int (85.0 * menuscale)), (Int (20.0 * menuscale)), "Protected")
                                            aasetfont(font1)
                                        EndIf
                                    EndIf
                                    If (local6\Field19 <> 0) Then
                                        drawimage(mpimg\Field6, (Int (((Float ($14 + local37)) * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), $00)
                                        If (mouseon((Int (((Float ($14 + local37)) * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), imagewidth(mpimg\Field6), imageheight(mpimg\Field6)) <> 0) Then
                                            aasetfont(fontsl)
                                            drawtextrect((Int (((Float ($14 + local37)) * menuscale) + (Float local0))), (Int ((((Float local38) - 5.384615) * menuscale) + (Float local1))), (Int (85.0 * menuscale)), (Int (20.0 * menuscale)), "Voice chat")
                                            aasetfont(font1)
                                        EndIf
                                    EndIf
                                    If (mouseon((Int ((15.0 * menuscale) + (Float local0))), (Int ((((Float local38) + (1.0 / 0.08125)) * menuscale) + (Float local1))), (Int (7.758621 * menuscale)), (Int (7.758621 * menuscale))) <> 0) Then
                                        aasetfont(fontsl)
                                        drawtextrect((Int ((Float local0) - (15.0 * menuscale))), (Int ((((Float local38) - 10.4) * menuscale) + (Float local1))), (Int (80.0 * menuscale)), (Int (20.0 * menuscale)), local6\Field9)
                                        aasetfont(font1)
                                    EndIf
                                    color($FF, $FF, $FF)
                                    aasetfont(fontservers)
                                    formattext((((Float ($26 + local37)) * menuscale) + (Float local0)), ((((Float local38) + 11.53846) * menuscale) + (Float local1)), local6\Field10, $00, $00, 1.0, $00)
                                    aasetfont(fontservers)
                                    aatext((Int ((300.0 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), local6\Field6, $00, $00, 1.0)
                                    aatext((Int ((400.0 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), local6\Field5, $00, $00, 1.0)
                                    local42 = (Str local6\Field4)
                                    If (local6\Field4 = $00) Then
                                        local42 = "-"
                                    EndIf
                                    aatext((Int ((500.0 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), local42, $00, $00, 1.0)
                                EndIf
                            Case $03,$06
                                local32 = (local32 + $01)
                                local38 = (Int ((Float local38) + 30.17241))
                                local40 = sfxvolume
                                If (((((connectmenu = $00) And (passwordmenu = $00)) And (servermenuopen = $00)) And (addservermenu = $00)) = $00) Then
                                    sfxvolume = 0.0
                                EndIf
                                If (drawbutton(local0, (Int (((Float (local38 - $00)) * menuscale) + (Float local1))), local2, (Int (30.17241 * menuscale)), "", $00, $00, $01, (Handle local6), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    If (((((connectmenu = $00) And (passwordmenu = $00)) And (servermenuopen = $00)) And (addservermenu = $00)) <> 0) Then
                                        selectserver = (Handle local6)
                                        If (doubleclick <> 0) Then
                                            servermenuopen = (servermenuopen = $00)
                                            doubleclick = $00
                                            multiplayer_list_updateserver(local6, $BB8, $02)
                                        Else
                                            multiplayer_list_updateserver(local6, $BB8, $03)
                                        EndIf
                                    EndIf
                                EndIf
                                sfxvolume = local40
                                Select local6\Field9
                                    Case "Started"
                                        color($FF, $FF, $00)
                                    Case "Password"
                                        color($FF, $00, $00)
                                    Case "In lobby"
                                        color($00, $FF, $00)
                                    Case "Offline"
                                        color($FF, $FF, $FF)
                                    Default
                                        color($FF, $FF, $FF)
                                End Select
                                oval((Int ((15.0 * menuscale) + (Float local0))), (Int ((((Float local38) + (1.0 / 0.08125)) * menuscale) + (Float local1))), (Int ((1.0 / 0.145) * menuscale)), (Int ((1.0 / 0.145) * menuscale)), $01)
                                color($FF, $FF, $FF)
                                For local7 = $01 To $01 Step $01
                                Next
                                If ((local6\Field7 And local6\Field25) <> 0) Then
                                    drawimage(mpimg\Field5, (Int ((30.17241 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), $00)
                                    If (mouseon((Int ((30.17241 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), imagewidth(mpimg\Field5), imageheight(mpimg\Field5)) <> 0) Then
                                        aasetfont(fontsl)
                                        drawtextrect((Int ((30.17241 * menuscale) + (Float local0))), (Int ((((Float local38) - 5.384615) * menuscale) + (Float local1))), (Int (85.0 * menuscale)), (Int (20.0 * menuscale)), "Protected")
                                        aasetfont(font1)
                                    EndIf
                                EndIf
                                If (local6\Field19 <> 0) Then
                                    drawimage(mpimg\Field6, (Int (((Float ($14 + local37)) * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), $00)
                                    If (mouseon((Int (((Float ($14 + local37)) * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), imagewidth(mpimg\Field6), imageheight(mpimg\Field6)) <> 0) Then
                                        aasetfont(fontsl)
                                        drawtextrect((Int (((Float ($14 + local37)) * menuscale) + (Float local0))), (Int ((((Float local38) - 5.384615) * menuscale) + (Float local1))), (Int (85.0 * menuscale)), (Int (20.0 * menuscale)), "Voice chat")
                                        aasetfont(font1)
                                    EndIf
                                EndIf
                                If (mouseon((Int ((15.0 * menuscale) + (Float local0))), (Int ((((Float local38) + (1.0 / 0.08125)) * menuscale) + (Float local1))), (Int (7.758621 * menuscale)), (Int (7.758621 * menuscale))) <> 0) Then
                                    aasetfont(fontsl)
                                    drawtextrect((Int ((Float local0) - (15.0 * menuscale))), (Int ((((Float local38) - 9.28) * menuscale) + (Float local1))), (Int (80.0 * menuscale)), (Int (20.0 * menuscale)), local6\Field9)
                                    aasetfont(font1)
                                EndIf
                                color($FF, $FF, $FF)
                                aasetfont(fontservers)
                                formattext((((Float ($26 + local37)) * menuscale) + (Float local0)), ((((Float local38) + 11.53846) * menuscale) + (Float local1)), local6\Field10, $00, $00, 1.0, $00)
                                aasetfont(fontservers)
                                aatext((Int ((300.0 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), local6\Field6, $00, $00, 1.0)
                                aatext((Int ((400.0 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), local6\Field5, $00, $00, 1.0)
                                local42 = (Str local6\Field4)
                                If (local6\Field4 = $00) Then
                                    local42 = "-"
                                EndIf
                                aatext((Int ((500.0 * menuscale) + (Float local0))), (Int ((((Float local38) + 11.53846) * menuscale) + (Float local1))), local42, $00, $00, 1.0)
                        End Select
                    EndIf
                Next
                disableredirectaccess = $00
                aasetfont(font1)
                If (local32 = $00) Then
                    aatext((local0 + $19), (Int ((35.0 * menuscale) + (Float local1))), "Server list is clear.", $00, $00, 1.0)
                EndIf
                aasetfont(fontsl)
                color($FF, $FF, $FF)
                aasetfont(fontsl)
                local45 = 0.0
                For local46 = Each errors
                    local45 = (((Float (aastringheight(local46\Field0) * getlineamount(local46\Field0, (Int (250.0 * menuscale)), $FFFFFFFF, 1.0))) + local45) + (10.0 * menuscale))
                Next
                For local46 = Each errors
                    If (0.0 = local44) Then
                        selectserver = $FFFFFFFF
                        drawframe((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (250.0 * menuscale)), (Int ((4.0 * menuscale) + local45)), $00, $00)
                    EndIf
                    aasetfont(fontsl)
                    color(local46\Field2, local46\Field3, local46\Field4)
                    rowtext(local46\Field0, ((580.0 * menuscale) + (Float local0)), (((5.0 * menuscale) + (Float local1)) + local44), (250.0 * menuscale), ((4.0 * menuscale) + local45), $01, 0.0, $00)
                    color($FF, $FF, $FF)
                    local44 = (((Float (aastringheight(local46\Field0) * getlineamount(local46\Field0, (Int (250.0 * menuscale)), (Int ((4.0 * menuscale) + local45)), 1.0))) + local44) + (10.0 * menuscale))
                Next
                aasetfont(font1)
                If (0.0 < local44) Then
                    drawbutton((Int (((580.0 * menuscale) + (Float local0)) + (250.0 * menuscale))), local1, (Int (80.0 * menuscale)), (Int (30.0 * menuscale)), "CLOSE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                EndIf
                If (drawbutton((Int ((20.0 * menuscale) + (Float local0))), (Int (((Float ($12C + local11)) * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "DIRECT CONNECT", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    multiplayer_masterserverset("", "")
                    connectmenu = (connectmenu = $00)
                    addservermenu = $00
                    passwordmenu = $00
                EndIf
                If (drawbutton((Int ((20.0 * menuscale) + (Float local0))), (Int (((Float ($104 + local11)) * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "JOIN SERVER", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    If (selectserver <> $FFFFFFFF) Then
                        For local6 = Each servers
                            If ((Handle local6) = selectserver) Then
                                multiplayer_masterserverset(local6\Field1, local6\Field2)
                                multiplayer_connectto(local6\Field1, (Int local6\Field2), "", $00, $1388)
                                Exit
                            EndIf
                        Next
                        selectserver = $FFFFFFFF
                    EndIf
                EndIf
                If (selected_servers = $06) Then
                    If (drawbutton((Int ((20.0 * menuscale) + (Float local0))), (Int (((Float ($154 + local11)) * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "ADD SERVER", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        multiplayer_masterserverset("", "")
                        addservermenu = (addservermenu = $00)
                        connectmenu = $00
                        passwordmenu = $00
                    EndIf
                EndIf
                If (((selected_servers <> $01) And (selected_servers <> $05)) <> 0) Then
                    If (drawbutton((Int ((200.0 * menuscale) + (Float local0))), (Int (((Float ($12C + local11)) * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "DELETE SERVER", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        If (selectserver <> $FFFFFFFF) Then
                            multiplayer_list_deleteserver((Object.servers selectserver))
                            selectserver = $FFFFFFFF
                        EndIf
                    EndIf
                    If (drawbutton((Int ((200.0 * menuscale) + (Float local0))), (Int (((Float ($154 + local11)) * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "SETTINGS", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        mainmenutab = $0C
                    EndIf
                ElseIf (drawbutton((Int ((200.0 * menuscale) + (Float local0))), (Int (((Float ($12C + local11)) * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "SETTINGS", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $0C
                EndIf
                If (drawbutton((Int ((200.0 * menuscale) + (Float local0))), (Int (((Float ($104 + local11)) * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "REFRESH SERVER", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    If (selectserver <> $FFFFFFFF) Then
                        multiplayer_list_updateserver((Object.servers selectserver), $1388, $01)
                    EndIf
                EndIf
                If (drawbutton((Int ((380.0 * menuscale) + (Float local0))), (Int (((Float ($104 + local11)) * menuscale) + (Float local1))), (Int (170.0 * menuscale)), (Int (20.0 * menuscale)), host_server_button_text, fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $09
                EndIf
                If (drawbutton((Int ((380.0 * menuscale) + (Float local0))), (Int (((Float ($12C + local11)) * menuscale) + (Float local1))), (Int (170.0 * menuscale)), (Int (20.0 * menuscale)), "RENT A SERVER", fontservers, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    execfile("https://zap-hosting.com/containmentbreachmp")
                EndIf
                color($FF, $FF, $FF)
                color($FF, $FF, $FF)
                aasetfont(font1)
                If (connectmenu <> 0) Then
                    local47 = (Float (((local2 Sar $01) + local0) - $64))
                    local48 = (Float (((local3 Sar $01) + local1) - $50))
                    drawframe((Int local47), (Int local48), (Int (250.0 * menuscale)), (Int (150.0 * menuscale)), $00, $00)
                    aatext((Int ((20.0 * menuscale) + local47)), (Int ((10.0 * menuscale) + local48)), "IP:", $00, $00, 1.0)
                    aatext((Int ((20.0 * menuscale) + local47)), (Int ((50.0 * menuscale) + local48)), "Port:", $00, $00, 1.0)
                    multiplayer_masterserverset(left(inputbox((Int ((60.0 * menuscale) + local47)), (Int ((10.0 * menuscale) + local48)), (Int (130.0 * menuscale)), (Int (25.0 * menuscale)), multiplayer_masterservergetip(), $36, $00, -1.0), $14), left(inputbox((Int ((70.0 * menuscale) + local47)), (Int ((50.0 * menuscale) + local48)), (Int (80.0 * menuscale)), (Int (25.0 * menuscale)), multiplayer_masterservergetport(), $37, $00, -1.0), $05))
                    If (drawbutton((Int ((20.0 * menuscale) + local47)), (Int ((100.0 * menuscale) + local48)), (Int (80.0 * menuscale)), (Int (30.0 * menuscale)), "CONNECT", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        multiplayer_connectto(multiplayer_masterservergetip(), (Int multiplayer_masterservergetport()), "", $00, $1388)
                    EndIf
                    If (drawbutton((Int ((150.0 * menuscale) + local47)), (Int ((100.0 * menuscale) + local48)), (Int (80.0 * menuscale)), (Int (30.0 * menuscale)), "CLOSE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        connectmenu = $00
                    EndIf
                ElseIf (addservermenu <> 0) Then
                    local47 = (Float (((local2 Sar $01) + local0) - $64))
                    local48 = (Float (((local3 Sar $01) + local1) - $50))
                    drawframe((Int local47), (Int local48), (Int (250.0 * menuscale)), (Int (150.0 * menuscale)), $00, $00)
                    aatext((Int ((20.0 * menuscale) + local47)), (Int ((10.0 * menuscale) + local48)), "IP:", $00, $00, 1.0)
                    aatext((Int ((20.0 * menuscale) + local47)), (Int ((50.0 * menuscale) + local48)), "Port:", $00, $00, 1.0)
                    multiplayer_masterserverset(left(inputbox((Int ((60.0 * menuscale) + local47)), (Int ((10.0 * menuscale) + local48)), (Int (130.0 * menuscale)), (Int (25.0 * menuscale)), multiplayer_masterservergetip(), $36, $00, -1.0), $14), left(inputbox((Int ((70.0 * menuscale) + local47)), (Int ((50.0 * menuscale) + local48)), (Int (80.0 * menuscale)), (Int (25.0 * menuscale)), multiplayer_masterservergetport(), $37, $00, -1.0), $05))
                    If (drawbutton((Int ((20.0 * menuscale) + local47)), (Int ((100.0 * menuscale) + local48)), (Int (80.0 * menuscale)), (Int (30.0 * menuscale)), "ADD", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        multiplayer_list_addserver(multiplayer_masterservergetip(), (Int multiplayer_masterservergetport()), $06, $00, $01)
                    EndIf
                    If (drawbutton((Int ((150.0 * menuscale) + local47)), (Int ((100.0 * menuscale) + local48)), (Int (80.0 * menuscale)), (Int (30.0 * menuscale)), "CLOSE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        addservermenu = $00
                    EndIf
                ElseIf (passwordmenu <> 0) Then
                    local47 = (Float (((local2 Sar $01) + local0) - $64))
                    local48 = (Float (((local3 Sar $01) + local1) - $50))
                    drawframe((Int local47), (Int local48), (Int (250.0 * menuscale)), (Int (100.0 * menuscale)), $00, $00)
                    aatext((Int ((20.0 * menuscale) + local47)), (Int ((10.0 * menuscale) + local48)), "Password", $00, $00, 1.0)
                    password = inputbox((Int ((100.0 * menuscale) + local47)), (Int ((10.0 * menuscale) + local48)), (Int (130.0 * menuscale)), (Int (25.0 * menuscale)), password, $36, $00, -1.0)
                    If (drawbutton((Int ((20.0 * menuscale) + local47)), (Int ((50.0 * menuscale) + local48)), (Int (80.0 * menuscale)), (Int (30.0 * menuscale)), "CONNECT", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        multiplayer_connectto(multiplayer_masterservergetip(), (Int multiplayer_masterservergetport()), password, $00, $1388)
                    EndIf
                    If (drawbutton((Int ((150.0 * menuscale) + local47)), (Int ((50.0 * menuscale) + local48)), (Int (80.0 * menuscale)), (Int (30.0 * menuscale)), "CLOSE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        passwordmenu = $00
                    EndIf
                EndIf
                local49 = (160.0 * menuscale)
                local50 = 115.9
                local51 = selected_servers
                If (drawbutton((Int local49), (Int (370.0 * menuscale)), (Int (local50 * menuscale)), (Int (27.27273 * menuscale)), (("OFFICIAL(" + (Str getserverscount($05, $01))) + ")"), fontservers, $00, $01, $FFFFFFFF, $05, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $05
                    selected_page = $00
                EndIf
                local49 = ((local50 * menuscale) + local49)
                If (drawbutton((Int local49), (Int (370.0 * menuscale)), (Int (local50 * menuscale)), (Int (27.27273 * menuscale)), (("COMMUNITY(" + (Str getserverscount($01, $01))) + ")"), fontservers, $00, $01, $FFFFFFFF, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $01
                    selected_page = $00
                EndIf
                local49 = ((local50 * menuscale) + local49)
                If (drawbutton((Int local49), (Int (370.0 * menuscale)), (Int ((local50 + 2.0) * menuscale)), (Int (27.27273 * menuscale)), (("HISTORY(" + (Str getserverscount($03, $01))) + ")"), fontservers, $00, $01, $FFFFFFFF, $03, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $03
                    selected_page = $00
                EndIf
                local49 = ((local50 * menuscale) + local49)
                If (drawbutton((Int ((1.0 * menuscale) + local49)), (Int (370.0 * menuscale)), (Int (local50 * menuscale)), (Int (27.27273 * menuscale)), (("FAVORITES(" + (Str getserverscount($06, $01))) + ")"), fontservers, $00, $01, $FFFFFFFF, $06, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $06
                    selected_page = $00
                EndIf
                local49 = ((local50 * menuscale) + local49)
                If (drawbutton((Int local49), (Int (370.0 * menuscale)), (Int ((local50 + 1.0) * menuscale)), (Int (27.27273 * menuscale)), (("LOCAL(" + (Str getserverscount($04, $01))) + ")"), fontservers, $00, $01, $FFFFFFFF, $04, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    selected_servers = $04
                    selected_page = $00
                    multiplayer_findlocalservers($C365)
                EndIf
                aasetfont(font1)
                If (local51 <> selected_servers) Then
                    local10 = 0.0
                    For local6 = Each servers
                        If (((local6\Field0 = selected_servers) And (((local6\Field4 = $00) And ((local6\Field0 = $01) Or (local6\Field0 = $05))) = $00)) <> 0) Then
                            local10 = ((35.0 * menuscale) + local10)
                        EndIf
                    Next
                    local3 = (Int (206.0 * menuscale))
                    local11 = $97
                    local3 = (Int (((Float local11) * menuscale) + (Float local3)))
                    chatscroll = ((- local10) + (Float local3))
                EndIf
                If (selected_servers = $04) Then
                    color($FF, $FF, $FF)
                    aasetfont(font1)
                    drawbutton((Int (690.0 * menuscale)), (Int (((Float ($154 + local11)) * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), "?", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    If ((mouseon((Int (690.0 * menuscale)), (Int (((Float ($154 + local11)) * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "srv", 0.0, $00)
                    EndIf
                EndIf
                If (selectserver <> $FFFFFFFF) Then
                    local6 = (Object.servers selectserver)
                    If (millisecs() > local6\Field13) Then
                        multiplayer_list_updateserver(local6, $1388, $01)
                        local6\Field13 = (millisecs() + $7D0)
                    EndIf
                    local52 = $00
                    For local7 = $00 To $13 Step $01
                        If (local6\Field24[local7] <> "") Then
                            local52 = $01
                            Exit
                        EndIf
                    Next
                    If (local52 <> 0) Then
                        local1 = (Int ((27.0 * menuscale) + (Float local1)))
                        disableredirectaccess = $01
                        local53 = 20.0
                        For local7 = $00 To $13 Step $01
                            If (local6\Field24[local7] <> "") Then
                                local55 = formattext(((600.0 * menuscale) + (Float local0)), ((local53 * menuscale) + (Float local1)), local6\Field24[local7], $00, $00, 1.0, $00)
                                local56 = (Float piece(local55, $01, " "))
                                If (((local54 < (Float piece(local55, $02, " "))) And ((Float piece(local55, $02, " ")) > (380.0 * menuscale))) <> 0) Then
                                    local54 = (Float piece(local55, $02, " "))
                                EndIf
                                local53 = ((local53 + local56) + (20.0 * menuscale))
                            EndIf
                        Next
                        If (local53 > (400.0 * menuscale)) Then
                            drawframe((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (max(0.0, (((20.0 * menuscale) + local54) - (380.0 * menuscale))) + (400.0 * menuscale))), (Int (local53 - (20.0 * menuscale))), $00, $00)
                        Else
                            drawframe((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (max(0.0, (((20.0 * menuscale) + local54) - (380.0 * menuscale))) + (400.0 * menuscale))), (Int (400.0 * menuscale)), $00, $00)
                        EndIf
                        local53 = 20.0
                        For local7 = $00 To $13 Step $01
                            If (local6\Field24[local7] <> "") Then
                                local56 = (Float formattext(((600.0 * menuscale) + (Float local0)), ((local53 * menuscale) + (Float local1)), local6\Field24[local7], $00, $00, 1.0, $00))
                                local53 = ((local53 + local56) + (20.0 * menuscale))
                            EndIf
                        Next
                        If (drawbutton((Int (max(0.0, (((20.0 * menuscale) + local54) - (380.0 * menuscale))) + ((980.0 * menuscale) + (Float local0)))), local1, (Int (40.0 * menuscale)), (Int (40.0 * menuscale)), "X", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            For local57 = Each servers
                                If (((((((local57\Field11 <> $00) And (local57\Field18 = local6\Field18)) And (local57\Field18 <> $00)) And (local57\Field2 = local6\Field2)) And (local57 <> local6)) And (local57\Field15 = $00)) <> 0) Then
                                    For local7 = $00 To $13 Step $01
                                        local57\Field24[local7] = ""
                                    Next
                                EndIf
                            Next
                            For local7 = $00 To $13 Step $01
                                local6\Field24[local7] = ""
                            Next
                        EndIf
                        disableredirectaccess = $00
                    EndIf
                    If (servermenuopen <> 0) Then
                        aasetfont(fontsl)
                        local58 = (400.0 * menuscale)
                        local59 = (240.0 * menuscale)
                        local24 = ((Float (graphicwidth Sar $01)) - (400.0 * menuscale))
                        local25 = ((Float (graphicheight Sar $01)) - (20.0 * menuscale))
                        local42 = (Str local6\Field4)
                        If (local6\Field4 = $00) Then
                            local42 = "-"
                        EndIf
                        drawframe((Int local24), (Int local25), (Int local58), (Int local59), $00, $00)
                        color($FF, $FF, $FF)
                        formattext(((20.0 * menuscale) + local24), ((10.0 * menuscale) + local25), ("Server: " + local6\Field10), $00, $00, 1.0, $00)
                        aatext((Int ((20.0 * menuscale) + local24)), (Int ((30.0 * menuscale) + local25)), ("Players: " + local6\Field6), $00, $00, 1.0)
                        aatext((Int ((20.0 * menuscale) + local24)), (Int ((50.0 * menuscale) + local25)), ("Map: " + local6\Field5), $00, $00, 1.0)
                        aatext((Int ((20.0 * menuscale) + local24)), (Int ((70.0 * menuscale) + local25)), ("Ping: " + local42), $00, $00, 1.0)
                        aatext((Int ((20.0 * menuscale) + local24)), (Int ((90.0 * menuscale) + local25)), ("Version: " + local6\Field21), $00, $00, 1.0)
                        If (local6\Field22 = "") Then
                            aasetfont(fontsl)
                            aatext((Int ((20.0 * menuscale) + local24)), (Int ((110.0 * menuscale) + local25)), "Web URL: None", $00, $00, 1.0)
                        Else
                            aatext((Int ((20.0 * menuscale) + local24)), (Int ((110.0 * menuscale) + local25)), "Web URL: ", $00, $00, 1.0)
                            aasetfont(fontsl_1)
                            If (drawclickabletext((Int (((30.0 * menuscale) + (Float aastringwidth("Web URL: "))) + local24)), (Int ((110.0 * menuscale) + local25)), local6\Field22, $34, $E5, $EB) <> 0) Then
                                execfile(local6\Field22)
                            EndIf
                        EndIf
                        aasetfont(fontsl)
                        rect((Int ((20.0 * menuscale) + local24)), (Int ((128.0 * menuscale) + local25)), (Int (360.0 * menuscale)), (Int (1.0 * menuscale)), $01)
                        disableredirectaccess = $01
                        rowformattext(local6\Field20, (Int ((20.0 * menuscale) + local24)), (Int ((130.0 * menuscale) + local25)), (Int local58), (Int local59), $00, 1.0)
                        disableredirectaccess = $00
                        If (drawbutton((Int ((10.0 * menuscale) + local24)), (Int ((200.0 * menuscale) + local25)), (Int (80.0 * menuscale)), (Int (20.0 * menuscale)), "Connect", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            multiplayer_masterserverset(local6\Field1, local6\Field2)
                            multiplayer_connectto(local6\Field1, (Int local6\Field2), "", $00, $1388)
                            servermenuopen = $00
                        EndIf
                        If (drawbutton((Int ((110.0 * menuscale) + local24)), (Int ((200.0 * menuscale) + local25)), (Int (80.0 * menuscale)), (Int (20.0 * menuscale)), "Refresh", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            multiplayer_list_updateserver(local6, $BB8, $02)
                        EndIf
                        If (drawbutton((Int ((210.0 * menuscale) + local24)), (Int ((200.0 * menuscale) + local25)), (Int (80.0 * menuscale)), (Int (20.0 * menuscale)), "Delete", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            If (((local6\Field0 <> $01) And (local6\Field0 <> $05)) <> 0) Then
                                multiplayer_list_deleteserver(local6)
                            EndIf
                        EndIf
                        If (drawbutton((Int ((310.0 * menuscale) + local24)), (Int ((200.0 * menuscale) + local25)), (Int (80.0 * menuscale)), (Int (20.0 * menuscale)), "Close", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            servermenuopen = $00
                        EndIf
                    EndIf
                Else
                    servermenuopen = $00
                EndIf
                If (local35 <> $00) Then
                    serverpages[selected_servers]\Field1 = local35
                    local61 = $00
                    For local6 = Each servers
                        If (local6\Field0 = selected_servers) Then
                            local60[local61] = (New tempservers)
                            multiplayer_list_copytempserverinfo(local60[local61], local6, $01)
                            local61 = (local61 + $01)
                            multiplayer_list_deleteserver(local6)
                        EndIf
                    Next
                    For local7 = $00 To $04 Step $01
                        If (local7 <> serverpages[selected_servers]\Field1) Then
                            serverpages[selected_servers]\Field0[local7] = $FFFFFFFF
                        EndIf
                    Next
                    If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = $FFFFFFFF) Then
                        serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = $00
                    EndIf
                    serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = $00)
                    Select serverpages[selected_servers]\Field1
                        Case $01
                            local0 = (local61 - $01)
                            While (local0 >= $00)
                                If (local60[local0] <> Null) Then
                                    local63 = (New servers)
                                    multiplayer_list_copyservertempinfo(local63, local60[local0], $01)
                                    Delete local60[local0]
                                EndIf
                                local0 = (local0 + $FFFFFFFF)
                            Wend
                        Case $03
                            If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] <> 0) Then
                                For local7 = $00 To (local61 - $01) Step $01
                                    For local0 = $00 To (local61 - $01) Step $01
                                        If (local60[local0] <> Null) Then
                                            local62 = $01
                                            For local1 = $00 To (local61 - $01) Step $01
                                                If (local60[local1] <> Null) Then
                                                    If (asc(left(local60[local0]\Field5, $01)) > asc(left(local60[local1]\Field5, $01))) Then
                                                        local62 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local62 <> 0) Then
                                                local63 = (New servers)
                                                multiplayer_list_copyservertempinfo(local63, local60[local0], $01)
                                                Delete local60[local0]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                For local7 = $00 To (local61 - $01) Step $01
                                    For local0 = $00 To (local61 - $01) Step $01
                                        If (local60[local0] <> Null) Then
                                            local62 = $01
                                            For local1 = $00 To (local61 - $01) Step $01
                                                If (local60[local1] <> Null) Then
                                                    If (asc(left(local60[local0]\Field5, $01)) < asc(left(local60[local1]\Field5, $01))) Then
                                                        local62 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local62 <> 0) Then
                                                local63 = (New servers)
                                                multiplayer_list_copyservertempinfo(local63, local60[local0], $01)
                                                Delete local60[local0]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            EndIf
                        Case $02
                            If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] = $00) Then
                                For local7 = $00 To (local61 - $01) Step $01
                                    For local0 = $00 To (local61 - $01) Step $01
                                        If (local60[local0] <> Null) Then
                                            local62 = $01
                                            For local1 = $00 To (local61 - $01) Step $01
                                                If (local60[local1] <> Null) Then
                                                    If (local60[local0]\Field25 < local60[local1]\Field25) Then
                                                        local62 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local62 <> 0) Then
                                                local63 = (New servers)
                                                multiplayer_list_copyservertempinfo(local63, local60[local0], $01)
                                                Delete local60[local0]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                For local7 = $00 To (local61 - $01) Step $01
                                    For local0 = $00 To (local61 - $01) Step $01
                                        If (local60[local0] <> Null) Then
                                            local62 = $01
                                            For local1 = $00 To (local61 - $01) Step $01
                                                If (local60[local1] <> Null) Then
                                                    If (local60[local0]\Field25 > local60[local1]\Field25) Then
                                                        local62 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local62 <> 0) Then
                                                local63 = (New servers)
                                                multiplayer_list_copyservertempinfo(local63, local60[local0], $01)
                                                Delete local60[local0]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            EndIf
                        Case $04
                            If (serverpages[selected_servers]\Field0[serverpages[selected_servers]\Field1] <> 0) Then
                                For local7 = $00 To (local61 - $01) Step $01
                                    For local0 = $00 To (local61 - $01) Step $01
                                        If (local60[local0] <> Null) Then
                                            local62 = $01
                                            For local1 = $00 To (local61 - $01) Step $01
                                                If (local60[local1] <> Null) Then
                                                    If (((local60[local0]\Field4 > local60[local1]\Field4) And (local60[local1]\Field4 <> $00)) <> 0) Then
                                                        local62 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local62 <> 0) Then
                                                local63 = (New servers)
                                                multiplayer_list_copyservertempinfo(local63, local60[local0], $01)
                                                Delete local60[local0]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                For local7 = $00 To (local61 - $01) Step $01
                                    For local0 = $00 To (local61 - $01) Step $01
                                        If (local60[local0] <> Null) Then
                                            local62 = $01
                                            For local1 = $00 To (local61 - $01) Step $01
                                                If (local60[local1] <> Null) Then
                                                    If (((local60[local0]\Field4 < local60[local1]\Field4) And (local60[local1]\Field4 <> $00)) <> 0) Then
                                                        local62 = $00
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                            If (local62 <> 0) Then
                                                local63 = (New servers)
                                                multiplayer_list_copyservertempinfo(local63, local60[local0], $01)
                                                Delete local60[local0]
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            EndIf
                    End Select
                    For local7 = $00 To (local61 - $01) Step $01
                        If (local60[local7] <> Null) Then
                            Delete local60[local7]
                        EndIf
                    Next
                EndIf
            Case $0E
                For local7 = $01 To networkserver\Field14 Step $01
                    If (player[local7] <> Null) Then
                        If (player[local7]\Field24 <> "") Then
                            For local66 = $00 To $07 Step $01
                                If ((local65 Sar $03) = local66) Then
                                    player[local7]\Field69 = local66
                                    local14[local66] = $01
                                    Exit
                                EndIf
                            Next
                            local65 = (local65 + $01)
                        EndIf
                    EndIf
                Next
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "LOBBY", $01, $01, 1.0)
                aasetfont(font1)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int ((Float ($14A - (((millisecs() < b_br\Field5) = $00) * $1E))) * menuscale))
                local67 = (Int (8.0 * menuscale))
                local2 = (Int (580.0 * menuscale))
                local68 = ""
                If (((($04 - networkserver\Field29) > $00) And networkserver\Field15) <> 0) Then
                    local68 = (("%w%Requires %g%" + (Str ($04 - networkserver\Field29))) + " %w%more players to start the game ")
                EndIf
                If (((networkserver\Field49 And networkserver\Field42) And (networkserver\Field50 <> $00)) <> 0) Then
                    If (drawbutton((Int ((20.0 * menuscale) + (Float (local0 + local2)))), local1, (Int (25.0 * menuscale)), (Int (25.0 * menuscale)), " ", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        networkserver\Field51 = (networkserver\Field51 = $00)
                        bs_steammatchmaking_setlobbytype(bs_steammatchmaking(), networkserver\Field50, networkserver\Field51)
                    EndIf
                    If (networkserver\Field51 <> 0) Then
                        drawimage(mpimg\Field10, (Int ((26.0 * menuscale) + (Float (local0 + local2)))), (Int ((5.0 * menuscale) + (Float local1))), $00)
                    Else
                        drawimage(mpimg\Field11, (Int ((26.0 * menuscale) + (Float (local0 + local2)))), (Int ((5.0 * menuscale) + (Float local1))), $00)
                    EndIf
                    aasetfont(fontsl)
                    If (mouseon((Int ((20.0 * menuscale) + (Float (local0 + local2)))), local1, (Int (25.0 * menuscale)), (Int (25.0 * menuscale))) <> 0) Then
                        If (networkserver\Field51 = $00) Then
                            drawtextrect(scaledmousex(), (Int ((Float scaledmousey()) - (20.0 * menuscale))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "Private room")
                        Else
                            drawtextrect(scaledmousex(), (Int ((Float scaledmousey()) - (20.0 * menuscale))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), "Friends can join")
                        EndIf
                    EndIf
                    aasetfont(font1)
                EndIf
                drawframe(local0, local1, local2, (Int (((Float (((local68 <> "") * $1E) + $78)) * menuscale) + (Float local3))), $00, $00)
                drawframe((Int ((50.0 * menuscale) + (Float local0))), local1, (Int (2.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                drawframe((Int ((300.0 * menuscale) + (Float local0))), local1, (Int (2.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), "ID", $00, $00, 1.0)
                aatext((Int ((65.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), "Nickname", $00, $00, 1.0)
                If (networkserver\Field15 = $00) Then
                    aatext((Int ((320.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), "Ready", $00, $00, 1.0)
                    aatext((Int ((440.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), "Ping", $00, $00, 1.0)
                Else
                    aatext((Int ((320.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), "Ping", $00, $00, 1.0)
                    aatext((Int ((440.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), "", $00, $00, 1.0)
                EndIf
                aasetfont(fontsl)
                myplayer\Field34 = ready
                myplayer\Field24 = nickname
                myplayer\Field48 = serverping
                For local7 = $01 To networkserver\Field14 Step $01
                    If (player[local7] <> Null) Then
                        If (player[local7]\Field69 = selected_p_page) Then
                            If (player[local7]\Field24 <> "") Then
                                local71 = ""
                                If (0.0 = player[local7]\Field65) Then
                                    local71 = "(Muted)"
                                EndIf
                                local72 = ((local70 + $01) * $1E)
                                drawframe(local0, (Int (((Float local72) * menuscale) + (Float local1))), local2, (Int (30.0 * menuscale)), $00, $00)
                                drawframe((Int ((300.0 * menuscale) + (Float local0))), local1, (Int (2.0 * menuscale)), (Int ((Float (($1E * local70) + $3C)) * menuscale)), $00, $00)
                                If (networkserver\Field15 = $00) Then
                                    drawframe((Int ((420.0 * menuscale) + (Float local0))), local1, (Int (2.0 * menuscale)), (Int ((Float (($1E * local70) + $3C)) * menuscale)), $00, $00)
                                EndIf
                                If (local7 = networkserver\Field28) Then
                                    color($1F4, $1F4, $00)
                                EndIf
                                If (player[local7]\Field88 <> "") Then
                                    local71 = player[local7]\Field88
                                EndIf
                                disableredirectaccess = $01
                                aatext((Int ((65.0 * menuscale) + (Float local0))), (Int (((Float (local72 + $0A)) * menuscale) + (Float local1))), player[local7]\Field24, $00, $00, 1.0)
                                disableredirectaccess = $00
                                color($FF, $00, $00)
                                If (player[local7]\Field88 <> "") Then
                                    color(player[local7]\Field89, player[local7]\Field90, player[local7]\Field91)
                                EndIf
                                aatext((Int ((230.0 * menuscale) + (Float local0))), (Int (((Float (local72 + $0A)) * menuscale) + (Float local1))), local71, $00, $00, 1.0)
                                color($FF, $FF, $FF)
                                drawframe((Int ((50.0 * menuscale) + (Float local0))), local1, (Int (2.0 * menuscale)), (Int ((Float (($1E * local70) + $3C)) * menuscale)), $00, $00)
                                If (player[local7]\Field34 = "Ready") Then
                                    color($00, $FF, $00)
                                Else
                                    color($FF, $00, $00)
                                EndIf
                                If (networkserver\Field15 = $00) Then
                                    aatext((Int ((320.0 * menuscale) + (Float local0))), (Int (((Float (local72 + $0A)) * menuscale) + (Float local1))), player[local7]\Field34, $00, $00, 1.0)
                                    color($FF, $FF, $FF)
                                    aatext((Int ((440.0 * menuscale) + (Float local0))), (Int (((Float (local72 + $0A)) * menuscale) + (Float local1))), (Str player[local7]\Field48), $00, $00, 1.0)
                                Else
                                    color($FF, $FF, $FF)
                                    aatext((Int ((320.0 * menuscale) + (Float local0))), (Int (((Float (local72 + $0A)) * menuscale) + (Float local1))), (Str player[local7]\Field48), $00, $00, 1.0)
                                    aatext((Int ((440.0 * menuscale) + (Float local0))), (Int (((Float (local72 + $0A)) * menuscale) + (Float local1))), "", $00, $00, 1.0)
                                EndIf
                                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int (((Float (local72 + $0A)) * menuscale) + (Float local1))), (Str local7), $00, $00, 1.0)
                                local70 = (local70 + $01)
                                If (drawbutton((Int ((550.0 * menuscale) + (Float local0))), (Int (((Float (local72 + $0A)) * menuscale) + (Float (local1 - $02)))), (Int (15.0 * menuscale)), (Int (15.0 * menuscale)), "+", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    mainmenutab = $28
                                    currplayer = player[local7]
                                EndIf
                                aasetfont(fontsl)
                            EndIf
                        EndIf
                    EndIf
                Next
                For local7 = $00 To $07 Step $01
                    If (local14[local7] = $01) Then
                        If (selected_p_page = local7) Then
                            drawbutton((Int (((Float (((local7 + $01) * $23) + $14)) * menuscale) + (Float local0))), (Int ((295.0 * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local7 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, selected_p_page, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        ElseIf (drawbutton((Int (((Float (((local7 + $01) * $23) + $14)) * menuscale) + (Float local0))), (Int ((295.0 * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), (Str (local7 + $01)), $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            selected_p_page = local7
                        EndIf
                        rect((Int ((15.0 * menuscale) + (Float local0))), (Int ((320.0 * menuscale) + (Float local1))), (local2 - $1E), $02, $01)
                    EndIf
                Next
                local73 = (Int (20.0 * menuscale))
                If (drawbutton((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "SETTINGS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $15
                EndIf
                If (networkserver\Field15 = $00) Then
                    local73 = (Int ((120.0 * menuscale) + (Float local73)))
                    If (drawbutton((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "READY", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        If (ready = "Not Ready") Then
                            ready = "Ready"
                        Else
                            ready = "Not Ready"
                        EndIf
                    EndIf
                    local73 = (Int ((120.0 * menuscale) + (Float local73)))
                    If (networkserver\Field29 < $02) Then
                        If (networkserver\Field18 = $00) Then
                            drawbutton((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "LOAD GAME", $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            If ((mouseon((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                                drawoptionstooltip((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "cant2", 0.0, $00)
                            EndIf
                        ElseIf (drawbutton((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "LOAD GAME", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            loadsavegames()
                            mainmenutab = $17
                        EndIf
                    Else
                        drawbutton((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "LOAD GAME", $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        If ((mouseon((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "cant", 0.0, $00)
                        EndIf
                    EndIf
                Else
                    local73 = (Int ((120.0 * menuscale) + (Float local73)))
                    drawbutton((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "LOAD GAME", $00, $00, $01, $FFFFFFFF, selected_servers, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                EndIf
                If (networkserver\Field18 <> 0) Then
                    local73 = (Int ((120.0 * menuscale) + (Float local73)))
                    local74 = $00
                    For local22 = Each players
                        If (local22\Field34 = "Ready") Then
                            local74 = (local74 + $01)
                        EndIf
                    Next
                    If (local74 >= networkserver\Field29) Then
                        If (drawbutton((local0 + local73), (Int ((350.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (50.0 * menuscale)), "START GAME", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            If (currsave = "") Then
                                currsave = "untitled"
                            EndIf
                            selectedmap = ""
                            gameload = $01
                            mainmenuopen = $00
                            loadentities()
                            myplayer\Field43 = $00
                            myplayer\Field13 = collider
                            myplayer\Field19 = myhitbox
                            multiplayer_updateplayers()
                            multiplayer_sendserverinformation()
                            For local22 = Each players
                                local22\Field44 = (millisecs() + $2BF20)
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
                    local75 = ((((b_br\Field5 + $3E7) - millisecs()) / $3E8) Mod $3C)
                    local76 = ((((b_br\Field5 + $3E7) - millisecs()) / $EA60) Mod $3C)
                    local77 = (Str local75)
                    If (local75 < $0A) Then
                        local77 = ("0" + (Str local75))
                    EndIf
                    color($FF, $FF, $FF)
                    aasetfont(font1)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((420.0 * menuscale) + (Float local1))), ((("Remaining before the start - " + (Str local76)) + ":") + local77), $00, $00, 1.0)
                    formattext(((20.0 * menuscale) + (Float local0)), ((450.0 * menuscale) + (Float local1)), local68, $00, $00, 1.0, $00)
                EndIf
            Case $28
                If (currplayer = Null) Then
                    mainmenutab = $0E
                    Return $00
                EndIf
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "PLAYER", $01, $01, 1.0)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (330.0 * menuscale))
                drawframe(local0, local1, local2, (Int ((60.0 * menuscale) + (Float local3))), $00, $00)
                aasetfont(font1)
                currplayer\Field65 = (slidebar((Int ((20.0 * menuscale) + (Float local0))), (Int ((50.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (currplayer\Field65 * 100.0), $00) / 100.0)
                aatext((Int ((30.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), ("Player volume: " + (Str (Int (currplayer\Field65 * 100.0)))), $00, $00, 1.0)
            Case $09
                If (selecteddifficulty = difficulties($03)) Then
                    selecteddifficulty = difficulties($00)
                EndIf
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), host_server_button_text, $01, $01, 1.0)
                aasetfont(fontsl)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (360.0 * menuscale))
                drawframe(local0, local1, local2, (Int (((200.0 - ((80.0 * menuscale) * 1.0)) * menuscale) + (Float local3))), $00, $00)
                If (drawbutton((Int ((410.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), "CREATE", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    steam_api_setachievement("AchvMultiplayer")
                    timemaxplayers = (Int max(min(65.0, (Float timemaxplayers)), 1.0))
                    If (timerandomseed = "") Then
                        timerandomseed = setrandomseed()
                    EndIf
                    timeport = (Int max(min(65535.0, (Float timeport)), 80.0))
                    multiplayer_hostserver(timeservername, timeport, timerandomseed, timeintroenabled, timetickrate, (Float timegravity), timejumpmode, timenocheat, timemaxplayers, timevoice, timepassword)
                EndIf
                If ((mouseon((Int ((410.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                    drawoptionstooltip((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "p2p", 0.0, $00)
                EndIf
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "Server name:", $00, $00, 1.0)
                timeservername = left(inputbox((Int ((145.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (Int (250.0 * menuscale)), (Int (20.0 * menuscale)), timeservername, $01, $00, -1.0), $40)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), "Map seed:", $00, $00, 1.0)
                timerandomseed = left(inputbox((Int ((120.0 * menuscale) + (Float local0))), (Int ((55.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), timerandomseed, $02, $00, -1.0), $12)
                local1 = (Int ((Float local1) - (40.0 * menuscale)))
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), "Enable intro sequence:", $00, $00, 1.0)
                timeintroenabled = drawtick((Int ((240.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), timeintroenabled, $00)
                local1 = (Int ((Float local1) - (40.0 * menuscale)))
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((220.0 * menuscale) + (Float local1))), "Difficulty:", $00, $00, 1.0)
                For local7 = $00 To $02 Step $01
                    If (drawtick((Int ((20.0 * menuscale) + (Float local0))), (Int (((Float (($1E * local7) + $FA)) * menuscale) + (Float local1))), (selecteddifficulty = difficulties(local7)), $00) <> 0) Then
                        selecteddifficulty = difficulties(local7)
                    EndIf
                    color(difficulties(local7)\Field6, difficulties(local7)\Field7, difficulties(local7)\Field8)
                    aatext((Int ((60.0 * menuscale) + (Float local0))), (Int (((Float (($1E * local7) + $FA)) * menuscale) + (Float local1))), difficulties(local7)\Field0, $00, $00, 1.0)
                Next
                aasetfont(font1)
                color($FF, $FF, $FF)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((340.0 * menuscale) + (Float local1))), "No Cheat:", $00, $00, 1.0)
                timenocheat = drawtick((Int ((120.0 * menuscale) + (Float local0))), (Int ((340.0 * menuscale) + (Float local1))), timenocheat, $00)
                If ((mouseon((Int ((120.0 * menuscale) + (Float local0))), (Int ((340.0 * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                    drawoptionstooltip((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "NoCheat", 0.0, $00)
                EndIf
                color($FF, $FF, $FF)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((380.0 * menuscale) + (Float local1))), "Voice chat:", $00, $00, 1.0)
                timevoice = drawtick((Int ((150.0 * menuscale) + (Float local0))), (Int ((380.0 * menuscale) + (Float local1))), timevoice, $00)
                If ((mouseon((Int ((150.0 * menuscale) + (Float local0))), (Int ((380.0 * menuscale) + (Float local1))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                    drawoptionstooltip((Int ((580.0 * menuscale) + (Float local0))), local1, (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), "voice", 0.0, $00)
                EndIf
                color($FF, $FF, $FF)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((420.0 * menuscale) + (Float local1))), "Max players:", $00, $00, 1.0)
                timemaxplayers = (Int left(inputbox((Int ((150.0 * menuscale) + (Float local0))), (Int ((415.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), (Str timemaxplayers), $0D, $00, -1.0), $02))
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((450.0 * menuscale) + (Float local1))), "Jump mode:", $00, $00, 1.0)
                timejumpmode = drawtick((Int ((150.0 * menuscale) + (Float local0))), (Int ((450.0 * menuscale) + (Float local1))), timejumpmode, $00)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((485.0 * menuscale) + (Float local1))), "Gravity:", $00, $00, 1.0)
                timegravity = inputbox((Int ((120.0 * menuscale) + (Float local0))), (Int ((480.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (Int (20.0 * menuscale)), timegravity, $0E, $00, -1.0)
                aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((515.0 * menuscale) + (Float local1))), "Keep inventory:", $00, $00, 1.0)
                timekeepinventory = drawtick((Int ((170.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), timekeepinventory, $00)
            Case $02
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (510.0 * menuscale))
                drawframe(local0, local1, local2, local3, $00, $00)
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "LOAD GAME", $01, $01, 1.0)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (296.0 * menuscale))
                aasetfont(font2)
                If ((((Float currloadgamepage) < (ceil(((Float savegameamount) / 6.0)) - 1.0)) And (savemsg = "")) <> 0) Then
                    If (drawbutton((Int ((530.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), ">", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage + $01)
                    EndIf
                Else
                    drawframe((Int ((530.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((555.0 * menuscale) + (Float local0))), (Int ((537.5 * menuscale) + (Float local1))), ">", $01, $01, 1.0)
                EndIf
                If (((currloadgamepage > $00) And (savemsg = "")) <> 0) Then
                    If (drawbutton(local0, (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), "<", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage - $01)
                    EndIf
                Else
                    drawframe(local0, (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((25.0 * menuscale) + (Float local0))), (Int ((537.5 * menuscale) + (Float local1))), "<", $01, $01, 1.0)
                EndIf
                drawframe((Int ((50.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int ((Float local2) - (100.0 * menuscale))), (Int (55.0 * menuscale)), $00, $00)
                aatext((Int (((Float local2) / 2.0) + (Float local0))), (Int ((536.0 * menuscale) + (Float local1))), ((("Page " + (Str (Int max((Float (currloadgamepage + $01)), 1.0)))) + "/") + (Str (Int max((Float (Int ceil(((Float savegameamount) / 6.0)))), 1.0)))), $01, $01, 1.0)
                aasetfont(font1)
                If ((Float currloadgamepage) > (ceil(((Float savegameamount) / 6.0)) - 1.0)) Then
                    currloadgamepage = (currloadgamepage - $01)
                EndIf
                If (savegameamount = $00) Then
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "No saved games.", $00, $00, 1.0)
                Else
                    local0 = (Int ((20.0 * menuscale) + (Float local0)))
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    For local7 = (($06 * currloadgamepage) + $01) To (($06 * currloadgamepage) + $06) Step $01
                        If (local7 <= savegameamount) Then
                            drawframe(local0, local1, (Int (540.0 * menuscale)), (Int (70.0 * menuscale)), $00, $00)
                            If (1.22 > savegameversion((local7 - $01))) Then
                                color($FF, $00, $00)
                            Else
                                color($FF, $FF, $FF)
                            EndIf
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), savegames((local7 - $01)), $00, $00, 1.0)
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((28.0 * menuscale) + (Float local1))), savegametime((local7 - $01)), $00, $00, 1.0)
                            aatext((Int ((120.0 * menuscale) + (Float local0))), (Int ((28.0 * menuscale) + (Float local1))), savegamedate((local7 - $01)), $00, $00, 1.0)
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((46.0 * menuscale) + (Float local1))), ("v" + (Str savegameversion((local7 - $01)))), $00, $00, 1.0)
                            If (savemsg = "") Then
                                If (1.22 > savegameversion((local7 - $01))) Then
                                    drawframe((Int ((280.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                    color($FF, $00, $00)
                                    aatext((Int ((330.0 * menuscale) + (Float local0))), (Int ((34.0 * menuscale) + (Float local1))), "Load", $01, $01, 1.0)
                                ElseIf (drawbutton((Int ((280.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Load", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    startloadgame(((savepath + savegames((local7 - $01))) + "\"), savegames((local7 - $01)))
                                EndIf
                                If (drawbutton((Int ((400.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Delete", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    savemsg = savegames((local7 - $01))
                                    debuglog(savemsg)
                                    Exit
                                EndIf
                            Else
                                drawframe((Int ((280.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                If (1.22 > savegameversion((local7 - $01))) Then
                                    color($FF, $00, $00)
                                Else
                                    color($64, $64, $64)
                                EndIf
                                aatext((Int ((330.0 * menuscale) + (Float local0))), (Int ((34.0 * menuscale) + (Float local1))), "Load", $01, $01, 1.0)
                                drawframe((Int ((400.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                color($64, $64, $64)
                                aatext((Int ((450.0 * menuscale) + (Float local0))), (Int ((34.0 * menuscale) + (Float local1))), "Delete", $01, $01, 1.0)
                            EndIf
                            local1 = (Int ((80.0 * menuscale) + (Float local1)))
                        Else
                            Exit
                        EndIf
                    Next
                    If (savemsg <> "") Then
                        local0 = (Int (740.0 * menuscale))
                        local1 = (Int (376.0 * menuscale))
                        drawframe(local0, local1, (Int (420.0 * menuscale)), (Int (200.0 * menuscale)), $00, $00)
                        rowtext("Are you sure you want to delete this save? !>!??!?!?!?", ((20.0 * menuscale) + (Float local0)), ((15.0 * menuscale) + (Float local1)), (400.0 * menuscale), (200.0 * menuscale), $00, 1.0, $00)
                        If (drawbutton((Int ((50.0 * menuscale) + (Float local0))), (Int ((150.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Yes", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            deletefile((((currentdir() + savepath) + savemsg) + "\save.txt"))
                            deletedir(((currentdir() + savepath) + savemsg))
                            savemsg = ""
                            loadsavegames()
                        EndIf
                        If (drawbutton((Int ((250.0 * menuscale) + (Float local0))), (Int ((150.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "No", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            savemsg = ""
                        EndIf
                    EndIf
                EndIf
            Case $17
                If (networkserver\Field29 > $01) Then
                    mainmenutab = $0E
                    Return $00
                EndIf
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (510.0 * menuscale))
                drawframe(local0, local1, local2, local3, $00, $00)
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "LOAD GAME", $01, $01, 1.0)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (296.0 * menuscale))
                aasetfont(font2)
                If ((((Float currloadgamepage) < (ceil(((Float savegameamount) / 6.0)) - 1.0)) And (savemsg = "")) <> 0) Then
                    If (drawbutton((Int ((530.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), ">", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage + $01)
                    EndIf
                Else
                    drawframe((Int ((530.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((555.0 * menuscale) + (Float local0))), (Int ((537.5 * menuscale) + (Float local1))), ">", $01, $01, 1.0)
                EndIf
                If (((currloadgamepage > $00) And (savemsg = "")) <> 0) Then
                    If (drawbutton(local0, (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), "<", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage - $01)
                    EndIf
                Else
                    drawframe(local0, (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((25.0 * menuscale) + (Float local0))), (Int ((537.5 * menuscale) + (Float local1))), "<", $01, $01, 1.0)
                EndIf
                drawframe((Int ((50.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int ((Float local2) - (100.0 * menuscale))), (Int (55.0 * menuscale)), $00, $00)
                aatext((Int (((Float local2) / 2.0) + (Float local0))), (Int ((536.0 * menuscale) + (Float local1))), ((("Page " + (Str (Int max((Float (currloadgamepage + $01)), 1.0)))) + "/") + (Str (Int max((Float (Int ceil(((Float savegameamount) / 6.0)))), 1.0)))), $01, $01, 1.0)
                aasetfont(font1)
                If ((Float currloadgamepage) > (ceil(((Float savegameamount) / 6.0)) - 1.0)) Then
                    currloadgamepage = (currloadgamepage - $01)
                EndIf
                If (savegameamount = $00) Then
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "No saved games.", $00, $00, 1.0)
                Else
                    local0 = (Int ((20.0 * menuscale) + (Float local0)))
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    For local7 = (($06 * currloadgamepage) + $01) To (($06 * currloadgamepage) + $06) Step $01
                        If (local7 <= savegameamount) Then
                            drawframe(local0, local1, (Int (540.0 * menuscale)), (Int (70.0 * menuscale)), $00, $00)
                            If (1.22 > savegameversion((local7 - $01))) Then
                                color($FF, $00, $00)
                            Else
                                color($FF, $FF, $FF)
                            EndIf
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), savegames((local7 - $01)), $00, $00, 1.0)
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((28.0 * menuscale) + (Float local1))), savegametime((local7 - $01)), $00, $00, 1.0)
                            aatext((Int ((120.0 * menuscale) + (Float local0))), (Int ((28.0 * menuscale) + (Float local1))), savegamedate((local7 - $01)), $00, $00, 1.0)
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((46.0 * menuscale) + (Float local1))), savegameseed((local7 - $01)), $00, $00, 1.0)
                            If (savemsg = "") Then
                                If (((1.22 > savegameversion((local7 - $01))) Or (savegameseed((local7 - $01)) = "")) <> 0) Then
                                    drawframe((Int ((280.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                    color($FF, $00, $00)
                                    aatext((Int ((330.0 * menuscale) + (Float local0))), (Int ((34.0 * menuscale) + (Float local1))), "Load", $01, $01, 1.0)
                                ElseIf (drawbutton((Int ((280.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Load", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    multiplayer_requestload(((savepath + savegames((local7 - $01))) + "\"), savegameseed((local7 - $01)), savegames((local7 - $01)), savegamedifficulty((local7 - $01)))
                                EndIf
                                If (drawbutton((Int ((400.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Delete", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    savemsg = savegames((local7 - $01))
                                    debuglog(savemsg)
                                    Exit
                                EndIf
                            Else
                                drawframe((Int ((280.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                If (((1.22 > savegameversion((local7 - $01))) Or (savegameseed((local7 - $01)) = "")) <> 0) Then
                                    color($FF, $00, $00)
                                Else
                                    color($64, $64, $64)
                                EndIf
                                aatext((Int ((330.0 * menuscale) + (Float local0))), (Int ((34.0 * menuscale) + (Float local1))), "Load", $01, $01, 1.0)
                                drawframe((Int ((400.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                color($64, $64, $64)
                                aatext((Int ((450.0 * menuscale) + (Float local0))), (Int ((34.0 * menuscale) + (Float local1))), "Delete", $01, $01, 1.0)
                            EndIf
                            local1 = (Int ((80.0 * menuscale) + (Float local1)))
                        Else
                            Exit
                        EndIf
                    Next
                    If (savemsg <> "") Then
                        local0 = (Int (740.0 * menuscale))
                        local1 = (Int (376.0 * menuscale))
                        drawframe(local0, local1, (Int (420.0 * menuscale)), (Int (200.0 * menuscale)), $00, $00)
                        rowtext("Are you sure you want to delete this save? !>!??!?!?!?", ((20.0 * menuscale) + (Float local0)), ((15.0 * menuscale) + (Float local1)), (400.0 * menuscale), (200.0 * menuscale), $00, 1.0, $00)
                        If (drawbutton((Int ((50.0 * menuscale) + (Float local0))), (Int ((150.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Yes", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            deletefile((((currentdir() + savepath) + savemsg) + "\save.txt"))
                            deletedir(((currentdir() + savepath) + savemsg))
                            savemsg = ""
                            loadsavegames()
                        EndIf
                        If (drawbutton((Int ((250.0 * menuscale) + (Float local0))), (Int ((150.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "No", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            savemsg = ""
                        EndIf
                    EndIf
                EndIf
            Case $03,$05,$06,$07
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "OPTIONS", $01, $01, 1.0)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (60.0 * menuscale))
                drawframe(local0, local1, local2, local3, $00, $00)
                color($00, $FF, $00)
                If (mainmenutab = $03) Then
                    rect((Int ((15.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), (Int ((Float (local2 / $05)) + (10.0 * menuscale))), (Int ((10.0 * menuscale) + (Float (local3 Sar $01)))), $01)
                ElseIf (mainmenutab = $05) Then
                    rect((Int ((155.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), (Int ((Float (local2 / $05)) + (10.0 * menuscale))), (Int ((10.0 * menuscale) + (Float (local3 Sar $01)))), $01)
                ElseIf (mainmenutab = $06) Then
                    rect((Int ((295.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), (Int ((Float (local2 / $05)) + (10.0 * menuscale))), (Int ((10.0 * menuscale) + (Float (local3 Sar $01)))), $01)
                ElseIf (mainmenutab = $07) Then
                    rect((Int ((435.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), (Int ((Float (local2 / $05)) + (10.0 * menuscale))), (Int ((10.0 * menuscale) + (Float (local3 Sar $01)))), $01)
                EndIf
                color($FF, $FF, $FF)
                If (drawbutton((Int ((20.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (local2 / $05), (local3 Sar $01), "GRAPHICS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $03
                EndIf
                If (drawbutton((Int ((160.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (local2 / $05), (local3 Sar $01), "AUDIO", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $05
                EndIf
                If (drawbutton((Int ((300.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (local2 / $05), (local3 Sar $01), "CONTROLS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $06
                EndIf
                If (drawbutton((Int ((440.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (local2 / $05), (local3 Sar $01), "ADVANCED", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    mainmenutab = $07
                EndIf
                aasetfont(font1)
                local1 = (Int ((70.0 * menuscale) + (Float local1)))
                If (mainmenutab <> $05) Then
                    usertrackcheck = $00
                    usertrackcheck2 = $00
                EndIf
                local78 = (Float (local0 + local2))
                local79 = (Float local1)
                local80 = (400.0 * menuscale)
                local81 = (150.0 * menuscale)
                If (mainmenutab = $03) Then
                    If (settingsmenu = $00) Then
                        local3 = (Int (380.0 * menuscale))
                        drawframe(local0, local1, local2, local3, $00, $00)
                        local1 = (Int ((10.0 * menuscale) + (Float local1)))
                        If (drawbutton((Int ((Float (local0 + local2)) - (60.0 * menuscale))), local1, (Int (50.0 * menuscale)), (Int (20.0 * menuscale)), ">>>", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            settingsmenu = $01
                        EndIf
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Enable bump mapping:", $00, $00, 1.0)
                        bumpenabled = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), bumpenabled, $00)
                        If ((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "bump", 0.0, $00)
                        EndIf
                        color($FF, $FF, $FF)
                        aatext((Int ((360.0 * menuscale) + (Float local0))), local1, "Particles:", $00, $00, 1.0)
                        removeparticles = (drawtick((Int ((480.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (removeparticles = $00), $00) = $00)
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "VSync:", $00, $00, 1.0)
                        verticalsync = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), verticalsync, $00)
                        If ((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "vsync", 0.0, $00)
                        EndIf
                        color($FF, $FF, $FF)
                        aatext((Int ((360.0 * menuscale) + (Float local0))), local1, "Decals:", $00, $00, 1.0)
                        removedecals = (drawtick((Int ((480.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (removedecals = $00), $00) = $00)
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Anti-aliasing:", $00, $00, 1.0)
                        opt_antialias = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), opt_antialias, $00)
                        If ((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "antialias", 0.0, $00)
                        EndIf
                        color($FF, $FF, $FF)
                        aatext((Int ((360.0 * menuscale) + (Float local0))), local1, "Bullet lines:", $00, $00, 1.0)
                        enablebullets = drawtick((Int ((480.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), enablebullets, $00)
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Enable room lights:", $00, $00, 1.0)
                        enableroomlights = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), enableroomlights, $00)
                        If ((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "roomlights", 0.0, $00)
                        EndIf
                        mainfov = min(max(slidebar((Int ((360.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (90.0 * menuscale)), mainfov, $00), 60.0), 90.0)
                        color($FF, $FF, $FF)
                        aasetfont(fontsl)
                        aatext((Int ((480.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), ("FOV: " + (Str (Int mainfov))), $00, $00, 1.0)
                        aasetfont(font1)
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Disable gamma update:", $00, $00, 1.0)
                        turnongamma = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), turnongamma, $00)
                        If ((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "gu", 0.0, $00)
                        EndIf
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        screengamma = (slidebar((Int ((310.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (screengamma * 50.0), $01) / 50.0)
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Screen gamma", $00, $00, 1.0)
                        If ((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int ((150.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "gamma", screengamma, $00)
                        EndIf
                        local1 = (Int ((50.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Particle amount:", $00, $00, 1.0)
                        particleamount = slider3((Int ((310.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), particleamount, $02, "MINIMAL", "REDUCED", "FULL")
                        If (((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (6.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $02)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "particleamount", (Float particleamount), $00)
                        EndIf
                        local1 = (Int ((50.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Texture LOD Bias:", $00, $00, 1.0)
                        texturedetails = slider5((Int ((310.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), texturedetails, $03, "1.5", "0.4", "0.0", "-0.4", "-0.8")
                        Select texturedetails
                            Case $00
                                texturefloat = 1.5
                            Case $01
                                texturefloat = 0.4
                            Case $02
                                texturefloat = 0.0
                            Case $03
                                texturefloat = -0.4
                            Case $04
                                texturefloat = -0.8
                        End Select
                        texturelodbias(texturefloat)
                        If (((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (6.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $03)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int ((100.0 * menuscale) + local81)), "texquality", 0.0, $00)
                        EndIf
                        local1 = (Int ((50.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Cameras quality:", $00, $00, 1.0)
                        camquality = slider3((Int ((310.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), camquality, $38, "Low", "Medium", "High")
                        If (((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (6.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $38)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int ((100.0 * menuscale) + local81)), "cmqu", 0.0, $00)
                        EndIf
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Save textures in the VRAM:", $00, $00, 1.0)
                        enablevram = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), enablevram, $00)
                        If ((mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "vram", 0.0, $00)
                        EndIf
                    Else
                        aasetfont(fontres)
                        local3 = (Int (380.0 * menuscale))
                        drawframe(local0, local1, local2, local3, $00, $00)
                        If (drawbutton((Int ((Float (local0 + local2)) - (60.0 * menuscale))), (Int ((10.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (20.0 * menuscale)), "<<<", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            settingsmenu = $00
                        EndIf
                        aatext((Int ((10.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), "Select resolution:", $00, $00, 1.0)
                        local1 = (Int ((20.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        local83 = $00
                        local84 = ((20.0 * menuscale) + (Float local0))
                        local85 = ((20.0 * menuscale) + (Float local1))
                        For local7 = $00 To (gfxmodes - $01) Step $01
                            If (((gfxmodeexists(gfxmodewidths(local7), gfxmodeheights(local7), $10) And bit16modesetting) Or (bit16modesetting = $00)) <> 0) Then
                                color($00, $00, $00)
                                If (selectedgfxmode = local7) Then
                                    color($FF, $FF, $FF)
                                    rect((Int (local84 - 1.0)), (Int (local85 - 1.0)), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), $00)
                                EndIf
                                color($FF, $FF, $FF)
                                aatext((Int local84), (Int local85), (((Str gfxmodewidths(local7)) + "x") + (Str gfxmodeheights(local7))), $00, $00, 1.0)
                                If (mouseon((Int (local84 - 1.0)), (Int (local85 - 1.0)), (Int (100.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                                    color($FF, $FF, $FF)
                                    rect((Int (local84 - 1.0)), (Int (local85 - 1.0)), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), $00)
                                    If (mousehit1 <> 0) Then
                                        selectedgfxmode = local7
                                        playsound_strict(buttonsfx)
                                    EndIf
                                EndIf
                                local85 = ((20.0 * menuscale) + local85)
                                If (local85 >= ((160.0 * menuscale) + (Float local1))) Then
                                    local85 = ((20.0 * menuscale) + (Float local1))
                                    local84 = ((100.0 * menuscale) + local84)
                                EndIf
                                local83 = $01
                            EndIf
                        Next
                        color($FF, $FF, $FF)
                        If (local83 = $00) Then
                            aatext((Int (local84 - (10.0 * menuscale))), (Int local85), "No graphics modes found.", $00, $00, 1.0)
                            local85 = ((20.0 * menuscale) + local85)
                            aatext((Int (local84 - (10.0 * menuscale))), (Int local85), "Make sure that the 16-bit mode is turned off.", $00, $00, 1.0)
                            local85 = ((20.0 * menuscale) + local85)
                        Else
                            rect((Int ((10.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (Int ((local84 - (Float local0)) + (100.0 * menuscale))), (Int (150.0 * menuscale)), $00)
                        EndIf
                        local0 = (Int ((18.0 * menuscale) + (Float local0)))
                        local1 = (Int ((160.0 * menuscale) + (Float local1)))
                        aatext((Int ((Float local0) - (8.0 * menuscale))), (Int ((10.0 * menuscale) + (Float local1))), "Select graphics drivers:", $00, $00, 1.0)
                        rect((Int ((Float local0) - (8.0 * menuscale))), (Int ((35.0 * menuscale) + (Float local1))), (Int (305.0 * menuscale)), (Int (((20.0 * (Float (countgfxdrivers() + $01))) * menuscale) + 14.0)), $00)
                        local1 = (Int ((47.0 * menuscale) + (Float local1)))
                        If (((selectedgfxdriversetting < $00) Or (selectedgfxdriversetting > countgfxdrivers())) <> 0) Then
                            selectedgfxdriversetting = $01
                        EndIf
                        aasetfont(fontres)
                        color($FF, $FF, $FF)
                        If (selectedgfxdriversetting = $00) Then
                            rect((local0 - $01), (local1 - $01), (Int (290.0 * menuscale)), (Int (20.0 * menuscale)), $00)
                        EndIf
                        color($FF, $FF, $FF)
                        limittext("Default (Recommended)", local0, local1, (Int (290.0 * menuscale)), $01, $00)
                        If (mouseon((local0 - $01), (local1 - $01), (Int (290.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            color($FF, $FF, $FF)
                            rect((local0 - $01), (local1 - $01), (Int (290.0 * menuscale)), (Int (20.0 * menuscale)), $00)
                            If (mousehit1 <> 0) Then
                                selectedgfxdriversetting = $00
                                playsound_strict(buttonsfx)
                            EndIf
                        EndIf
                        local1 = (Int ((20.0 * menuscale) + (Float local1)))
                        For local7 = $01 To countgfxdrivers() Step $01
                            aasetfont(fontres)
                            color($FF, $FF, $FF)
                            If (selectedgfxdriversetting = local7) Then
                                color($FF, $FF, $FF)
                                rect((local0 - $01), (local1 - $01), (Int (290.0 * menuscale)), (Int (20.0 * menuscale)), $00)
                            EndIf
                            color($FF, $FF, $FF)
                            limittext(gfxdrivername(local7), local0, local1, (Int (290.0 * menuscale)), $01, $00)
                            If (mouseon((local0 - $01), (local1 - $01), (Int (290.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                                color($FF, $FF, $FF)
                                rect((local0 - $01), (local1 - $01), (Int (290.0 * menuscale)), (Int (20.0 * menuscale)), $00)
                                If (mousehit1 <> 0) Then
                                    selectedgfxdriversetting = local7
                                    playsound_strict(buttonsfx)
                                EndIf
                            EndIf
                            local1 = (Int ((20.0 * menuscale) + (Float local1)))
                        Next
                        local1 = (Int ((Float local1) - (120.0 * menuscale)))
                        aasetfont(font1)
                        fullscreensetting = drawtick((Int ((520.0 * menuscale) + (Float local0))), (Int ((55.0 * menuscale) + (Float local1))), fullscreensetting, borderlesswindowedsetting)
                        borderlesswindowedsetting = drawtick((Int ((520.0 * menuscale) + (Float local0))), (Int ((75.0 * menuscale) + (Float local1))), borderlesswindowedsetting, $00)
                        local86 = $00
                        If ((borderlesswindowedsetting Or (fullscreensetting = $00)) <> 0) Then
                            local86 = $01
                        EndIf
                        bit16modesetting = drawtick((Int ((520.0 * menuscale) + (Float local0))), (Int ((95.0 * menuscale) + (Float local1))), bit16modesetting, local86)
                        launcherenabledsetting = drawtick((Int ((520.0 * menuscale) + (Float local0))), (Int ((115.0 * menuscale) + (Float local1))), launcherenabledsetting, $00)
                        color($FF, $FF, $FF)
                        aatext((Int ((310.0 * menuscale) + (Float local0))), (Int ((75.0 * menuscale) + (Float local1))), "Borderless mode", $00, $00, 1.0)
                        If (borderlesswindowedsetting <> 0) Then
                            color($FF, $00, $00)
                            fullscreensetting = $00
                        Else
                            color($FF, $FF, $FF)
                        EndIf
                        aatext((Int ((310.0 * menuscale) + (Float local0))), (Int ((55.0 * menuscale) + (Float local1))), "Fullscreen", $00, $00, 1.0)
                        If ((borderlesswindowedsetting Or (fullscreensetting = $00)) <> 0) Then
                            color($FF, $00, $00)
                            bit16modesetting = $00
                        Else
                            color($FF, $FF, $FF)
                        EndIf
                        aatext((Int ((310.0 * menuscale) + (Float local0))), (Int ((95.0 * menuscale) + (Float local1))), "16 Bit", $00, $00, 1.0)
                        color($FF, $FF, $FF)
                        aatext((Int ((310.0 * menuscale) + (Float local0))), (Int ((115.0 * menuscale) + (Float local1))), "Use launcher", $00, $00, 1.0)
                        color($FF, $FF, $FF)
                        If (local83 <> 0) Then
                            If ((((((((gfxmodewidths(selectedgfxmode) <> graphicwidth) Or (gfxmodeheights(selectedgfxmode) <> graphicheight)) Or (bit16mode <> bit16modesetting)) Or (fullscreensetting <> fullscreen)) Or (launcherenabled <> launcherenabledsetting)) Or (borderlesswindowed <> borderlesswindowedsetting)) Or (selectedgfxdriversetting <> selectedgfxdriver)) <> 0) Then
                                If (drawbutton((Int ((310.0 * menuscale) + (Float local0))), (Int ((155.0 * menuscale) + (Float local1))), (Int (90.0 * menuscale)), (Int (20.0 * menuscale)), "APPLY", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                    changeresolution(gfxmodewidths(selectedgfxmode), gfxmodeheights(selectedgfxmode))
                                EndIf
                                color($FF, $00, $00)
                                aatext(local0, (Int ((155.0 * menuscale) + (Float local1))), "After applying the settings,", $00, $00, 1.0)
                                aatext(local0, (Int ((175.0 * menuscale) + (Float local1))), "the game will be restarted", $00, $00, 1.0)
                            EndIf
                        EndIf
                    EndIf
                ElseIf (mainmenutab = $05) Then
                    local3 = (Int (220.0 * menuscale))
                    drawframe(local0, local1, local2, local3, $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    musicvolume = (slidebar((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (150.0 * menuscale)), (musicvolume * 100.0), $01) / 100.0)
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Music volume:", $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "musicvol", musicvolume, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    prevsfxvolume = (slidebar((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (150.0 * menuscale)), (sfxvolume * 100.0), $01) / 100.0)
                    sfxvolume = prevsfxvolume
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Sound volume:", $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "soundvol", prevsfxvolume, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Sound auto-release:", $00, $00, 1.0)
                    enablesfxrelease = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), enablesfxrelease, $00)
                    If (enablesfxrelease_prev <> enablesfxrelease) Then
                        If (enablesfxrelease <> 0) Then
                            For local87 = Each sound
                                For local7 = $00 To $1F Step $01
                                    If (local87\Field2[local7] <> $00) Then
                                        If (channelplaying(local87\Field2[local7]) <> 0) Then
                                            stopchannel(local87\Field2[local7])
                                        EndIf
                                    EndIf
                                Next
                                If (local87\Field0 <> $00) Then
                                    freesound(local87\Field0)
                                    local87\Field0 = $00
                                EndIf
                                local87\Field3 = $00
                                local87\Field4 = $00
                            Next
                        Else
                            For local87 = Each sound
                                If (local87\Field0 = $00) Then
                                    local87\Field0 = loadsound(local87\Field1)
                                EndIf
                            Next
                        EndIf
                        enablesfxrelease_prev = enablesfxrelease
                    EndIf
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int ((220.0 * menuscale) + local81)), "sfxautorelease", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Enable user tracks:", $00, $00, 1.0)
                    enableusertracks = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), enableusertracks, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "usertrack", 0.0, $00)
                    EndIf
                    If (enableusertracks <> 0) Then
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "User track mode:", $00, $00, 1.0)
                        usertrackmode = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), usertrackmode, $00)
                        If (usertrackmode <> 0) Then
                            aatext((Int ((350.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), "Repeat", $00, $00, 1.0)
                        Else
                            aatext((Int ((350.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), "Random", $00, $00, 1.0)
                        EndIf
                        If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "usertrackmode", 0.0, $00)
                        EndIf
                        If (drawbutton((Int ((20.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), (Int (190.0 * menuscale)), (Int (25.0 * menuscale)), "Scan for User Tracks", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            debuglog("User Tracks Check Started")
                            usertrackcheck = $00
                            usertrackcheck2 = $00
                            local88 = readdir("SFX\Radio\UserTracks\")
                            Repeat
                                local89 = nextfile(local88)
                                If (local89 = "") Then
                                    Exit
                                EndIf
                                If (filetype(("SFX\Radio\UserTracks\" + local89)) = $01) Then
                                    usertrackcheck = (usertrackcheck + $01)
                                    local90 = loadsound(("SFX\Radio\UserTracks\" + local89))
                                    If (local90 <> $00) Then
                                        usertrackcheck2 = (usertrackcheck2 + $01)
                                    EndIf
                                    freesound(local90)
                                EndIf
                            Forever
                            closedir(local88)
                            debuglog("User Tracks Check Ended")
                        EndIf
                        If (mouseon((Int ((20.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), (Int (190.0 * menuscale)), (Int (25.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "usertrackscan", 0.0, $00)
                        EndIf
                        If (usertrackcheck > $00) Then
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), (((("User tracks found (" + (Str usertrackcheck2)) + "/") + (Str usertrackcheck)) + " successfully loaded)"), $00, $00, 1.0)
                        EndIf
                    Else
                        usertrackcheck = $00
                    EndIf
                ElseIf (mainmenutab = $06) Then
                    local3 = (Int (320.0 * menuscale))
                    drawframe(local0, local1, local2, local3, $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    mousesens = ((slidebar((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (150.0 * menuscale)), ((mousesens + 0.5) * 100.0), $01) / 100.0) - 0.5)
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Mouse sensitivity:", $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "mousesensitivity", mousesens, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    mousesmooth = (slidebar((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (150.0 * menuscale)), (mousesmooth * 50.0), $01) / 50.0)
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Mouse smoothing:", $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "mousesmoothing", mousesmooth, $00)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Invert mouse Y-axis:", $00, $00, 1.0)
                    invertmouse = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), invertmouse, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "mouseinvert", 0.0, $00)
                    EndIf
                    color($FF, $FF, $FF)
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Using button (instead of mouse):", $00, $00, 1.0)
                    mouseinteract = (drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (mouseinteract = $00), $00) = $00)
                    local1 = (Int ((10.0 * menuscale) + (Float local1)))
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "Move Forward", $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_up), 210.0))), $05, $00, -1.0)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), "Strafe Left", $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_left), 210.0))), $03, $00, -1.0)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), "Move Backward", $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_down), 210.0))), $06, $00, -1.0)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), "Strafe Right", $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_right), 210.0))), $04, $00, -1.0)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), "Quick Save", $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_save), 210.0))), $0B, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "Manual Blink", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_blink), 210.0))), $07, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), "Sprint", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_sprint), 210.0))), $08, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), "Open/Close Inventory", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_inv), 210.0))), $09, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), "Crouch", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_crouch), 210.0))), $0A, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), "Open/Close Console", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_console), 210.0))), $0C, $00, -1.0)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), "Chat", $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_chat), 210.0))), $0D, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), "Voice", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_voice), 210.0))), $0E, $00, -1.0)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), "Jump", $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_jump), 210.0))), $0F, $00, -1.0)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((160.0 * menuscale) + (Float local1))), "Lean L", $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local0))), (Int ((160.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_leanl), 210.0))), $10, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), "Lean R", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_leanr), 210.0))), $11, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), "Lean R", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_leanr), 210.0))), $11, $00, -1.0)
                    aatext((Int ((280.0 * menuscale) + (Float local0))), (Int ((160.0 * menuscale) + (Float local1))), "Using", $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local0))), (Int ((160.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_using), 210.0))), $12, $00, -1.0)
                    If (mouseon((Int ((20.0 * menuscale) + (Float local0))), local1, (Int ((Float local2) - (40.0 * menuscale))), (Int (120.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "controls", 0.0, $00)
                    EndIf
                    For local7 = $00 To $E3 Step $01
                        If (keyhit(local7) <> 0) Then
                            local91 = local7
                            Exit
                        EndIf
                    Next
                    If (local91 <> $00) Then
                        Select selectedinputbox
                            Case $03
                                key_left = local91
                            Case $04
                                key_right = local91
                            Case $05
                                key_up = local91
                            Case $06
                                key_down = local91
                            Case $07
                                key_blink = local91
                            Case $08
                                key_sprint = local91
                            Case $09
                                key_inv = local91
                            Case $0A
                                key_crouch = local91
                            Case $0B
                                key_save = local91
                            Case $0C
                                key_console = local91
                            Case $0D
                                key_chat = local91
                            Case $0E
                                key_voice = local91
                            Case $0F
                                key_jump = local91
                            Case $10
                                key_leanl = local91
                            Case $11
                                key_leanr = local91
                            Case $12
                                key_using = local91
                        End Select
                        selectedinputbox = $00
                    EndIf
                ElseIf (mainmenutab = $07) Then
                    local3 = (Int (350.0 * menuscale))
                    drawframe(local0, local1, local2, local3, $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Show HUD:", $00, $00, 1.0)
                    hudenabled = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), hudenabled, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "hud", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Enable console:", $00, $00, 1.0)
                    canopenconsole = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), canopenconsole, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "consoleenable", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Open console on error:", $00, $00, 1.0)
                    drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), $00, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "consoleerror", 0.0, $00)
                    EndIf
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Achievement popups:", $00, $00, 1.0)
                    achvmsgenabled = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), achvmsgenabled, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "achpopup", 0.0, $00)
                    EndIf
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Show FPS:", $00, $00, 1.0)
                    showfps = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), showfps, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "showfps", 0.0, $00)
                    EndIf
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Show SCP Viewmodel:", $00, $00, 1.0)
                    showscpviewmodel = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), showscpviewmodel, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "showscpviewmodel", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Framelimit:", $00, $00, 1.0)
                    color($FF, $FF, $FF)
                    If (drawtick((Int ((310.0 * menuscale) + (Float local0))), local1, (0.0 < currframelimit), $00) <> 0) Then
                        currframelimit = (slidebar((Int ((150.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (currframelimit * 99.0), $01) / 99.0)
                        currframelimit = max(currframelimit, 0.01)
                        framelimit = (Int ((currframelimit * 100.0) + 19.0))
                        color($FF, $FF, $00)
                        aatext((Int ((25.0 * menuscale) + (Float local0))), (Int ((25.0 * menuscale) + (Float local1))), ((Str framelimit) + " FPS"), $00, $00, 1.0)
                    Else
                        currframelimit = 0.0
                        framelimit = $00
                    EndIf
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "framelimit", (Float framelimit), $00)
                    EndIf
                    If (mouseon((Int ((150.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "framelimit", (Float framelimit), $00)
                    EndIf
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local0))), local1, "Antialiased text:", $00, $00, 1.0)
                    aatextenable = drawtick((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), aatextenable, $00)
                    If (aatextenable_prev <> aatextenable) Then
                        freeallfonts($00, $00)
                        loadallfonts($01)
                        aatextenable_prev = aatextenable
                    EndIf
                    If (mouseon((Int ((310.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local78), (Int local79), (Int local80), (Int local81), "antialiastext", 0.0, $00)
                    EndIf
                EndIf
            Case $04
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (510.0 * menuscale))
                drawframe(local0, local1, local2, local3, $00, $00)
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "LOAD MAP", $01, $01, 1.0)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (350.0 * menuscale))
                aasetfont(font2)
                local78 = (Float (local0 + local2))
                local79 = (Float local1)
                local80 = (400.0 * menuscale)
                local81 = (150.0 * menuscale)
                If ((Float currloadgamepage) < (ceil(((Float savedmapsamount) / 6.0)) - 1.0)) Then
                    If (drawbutton((Int ((530.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), ">", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage + $01)
                    EndIf
                Else
                    drawframe((Int ((530.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((555.0 * menuscale) + (Float local0))), (Int ((537.5 * menuscale) + (Float local1))), ">", $01, $01, 1.0)
                EndIf
                If (currloadgamepage > $00) Then
                    If (drawbutton(local0, (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), "<", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        currloadgamepage = (currloadgamepage - $01)
                    EndIf
                Else
                    drawframe(local0, (Int ((510.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((25.0 * menuscale) + (Float local0))), (Int ((537.5 * menuscale) + (Float local1))), "<", $01, $01, 1.0)
                EndIf
                drawframe((Int ((50.0 * menuscale) + (Float local0))), (Int ((510.0 * menuscale) + (Float local1))), (Int ((Float local2) - (100.0 * menuscale))), (Int (55.0 * menuscale)), $00, $00)
                aatext((Int (((Float local2) / 2.0) + (Float local0))), (Int ((536.0 * menuscale) + (Float local1))), ((("Page " + (Str (Int max((Float (currloadgamepage + $01)), 1.0)))) + "/") + (Str (Int max((Float (Int ceil(((Float savedmapsamount) / 6.0)))), 1.0)))), $01, $01, 1.0)
                aasetfont(font1)
                If ((Float currloadgamepage) > (ceil(((Float savedmapsamount) / 6.0)) - 1.0)) Then
                    currloadgamepage = (currloadgamepage - $01)
                EndIf
                aasetfont(font1)
                If (savedmaps($00) = "") Then
                    aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "No saved maps. Use the Map Creator to create new maps.", $00, $00, 1.0)
                Else
                    local0 = (Int ((20.0 * menuscale) + (Float local0)))
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    For local7 = (($06 * currloadgamepage) + $01) To (($06 * currloadgamepage) + $06) Step $01
                        If (local7 <= savedmapsamount) Then
                            drawframe(local0, local1, (Int (540.0 * menuscale)), (Int (70.0 * menuscale)), $00, $00)
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), savedmaps((local7 - $01)), $00, $00, 1.0)
                            aatext((Int ((20.0 * menuscale) + (Float local0))), (Int ((37.0 * menuscale) + (Float local1))), savedmapsauthor((local7 - $01)), $00, $00, 1.0)
                            If (drawbutton((Int ((400.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Load", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                selectedmap = savedmaps((local7 - $01))
                                mainmenutab = $14
                            EndIf
                            If (mouseon((Int ((400.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale))) <> 0) Then
                                drawmapcreatortooltip((Int local78), (Int local79), (Int local80), (Int local81), savedmaps((local7 - $01)))
                            EndIf
                            local1 = (Int ((80.0 * menuscale) + (Float local1)))
                        Else
                            Exit
                        EndIf
                    Next
                EndIf
        End Select
    EndIf
    color($FF, $FF, $FF)
    aasetfont(consolefont)
    aatext($14, (graphicheight - $32), ("Multiplayer Mod v" + multiplayer_version), $00, $00, 1.0)
    aatext($14, (graphicheight - $1E), ("v" + versionnumber), $00, $00, 1.0)
    local49 = ((Float graphicwidth) - (34.0 * menuscale))
    For local93 = Each workshopthread
        If (local93\Field3 <> "") Then
            If (local93\Field4 = $00) Then
                local93\Field4 = loadimage_strict(local93\Field3)
                resizeimage(local93\Field4, (24.0 * menuscale), (16.0 * menuscale))
            EndIf
            If (mouseon((Int local49), (Int ((Float graphicheight) - (30.0 * menuscale))), (Int (30.0 * menuscale)), (Int (16.0 * menuscale))) <> 0) Then
                color($FF, $00, $00)
                rect((Int (local49 - (1.0 * menuscale))), (Int ((Float graphicheight) - (31.0 * menuscale))), (Int (24.4 * menuscale)), (Int (16.4 * menuscale)), $01)
                If (mousehit1 <> 0) Then
                    public_inqueue($0F, $00)
                    public_update_current(local93\Field2, $00)
                    public_clear()
                EndIf
            EndIf
            drawimage(local93\Field4, (Int local49), (Int ((Float graphicheight) - (30.0 * menuscale))), $00)
            local49 = (local49 - (34.0 * menuscale))
        EndIf
    Next
    If (fullscreen <> 0) Then
        drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
    EndIf
    aasetfont(font1)
    Return $00
End Function
