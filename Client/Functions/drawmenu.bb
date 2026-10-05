Function drawmenu%()
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
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18$
    Local local19%
    Local local20$
    Local local21%
    Local local22#
    Local local23%
    Local local24%
    Local local25%
    Local local26%
    Local local27%
    Local local28%
    Local local30%
    Local local31.particles
    Local local32%
    Local local33%
    Local local34.decals
    Local local35%
    Local local36#
    Local local38.securitycams
    Local local39%
    Local local40%
    Local local42%
    Local local43%
    Local local44%
    Local local45%
    Local local46%
    Local local47%
    Local local48%
    Local local49%
    Local local50%
    Local local51%
    Local local52.rooms
    Local local53.items
    local4 = udp_getstream()
    local5 = imenuscale[$0A]
    local6 = imenuscale[$14]
    local7 = imenuscale[$1E]
    local8 = imenuscale[$32]
    local9 = imenuscale[$5A]
    local10 = imenuscale[$64]
    local11 = imenuscale[$96]
    local12 = imenuscale[$C8]
    local13 = imenuscale[$FA]
    local14 = imenuscale[$12C]
    local15 = imenuscale[$15E]
    local16 = imenuscale[$154]
    local17 = imenuscale[$190]
    If (menuopen <> 0) Then
        If (networkserver\Field12 = $00) Then
            local18 = playerroom\Field8\Field11
            If (local18 <> "exit1") Then
                If (local18 <> "gatea") Then
                    If (0.0 = stophidingtimer) Then
                        If (curr173 <> Null) Then
                            If (((4.0 > entitydistance(curr173\Field4, collider)) Or (4.0 > entitydistance(curr106\Field4, collider))) <> 0) Then
                                stophidingtimer = 1.0
                            EndIf
                        EndIf
                    ElseIf (40.0 > stophidingtimer) Then
                        If (0.0 <= killtimer) Then
                            stophidingtimer = (stophidingtimer + fpsfactor)
                            If (40.0 <= stophidingtimer) Then
                                playsound_strict(horrorsfx($0F))
                                setmsg("STOP HIDING")
                                menuopen = $00
                                If (local4 = $00) Then
                                    resumesounds()
                                EndIf
                                Return $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        invopen = $00
        local2 = imagewidth(pausemenuimg)
        local3 = imageheight(pausemenuimg)
        local0 = (viewport_center_x - (local2 Shr $01))
        local1 = (viewport_center_y - (local3 Shr $01))
        drawimage(pausemenuimg, local0, local1, $00)
        local0 = (local0 + imenuscale[$84])
        local1 = (local1 + imenuscale[$7A])
        If (mousedown1 = $00) Then
            onsliderid = $00
        EndIf
        setfontex(fonts[$01]\Field0)
        local19 = (local1 - imenuscale[$4D])
        If (achievementsmenu > $00) Then
            local20 = "ACHIEVEMENTS"
        ElseIf (optionsmenu > $00) Then
            local20 = "OPTIONS"
        ElseIf (quitmsg > $00) Then
            local20 = "QUIT?"
        ElseIf (suicidemsg > $00) Then
            local20 = "SUICIDE?"
        ElseIf (0.0 <= killtimer) Then
            local20 = "PAUSED"
        Else
            local20 = "YOU DIED"
        EndIf
        setcolorraw($FFFFFF)
        text(local0, local19, local20, $00, $01)
        local21 = (imenuscale[$16] + local0)
        local22 = ((Float graphicheight) * (1.0 / 768.0001))
        local23 = (Int (76.0 * local22))
        local24 = $40
        If (((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg <= $00)) And (suicidemsg <= $00)) <> 0) Then
            setfontex(fonts[$00]\Field0)
            text(local0, local1, ("Difficulty: " + selecteddifficulty\Field0), $00, $00)
            text(local0, (local1 + local6), ("Map seed: " + randomseed), $00, $00)
        ElseIf ((((((achievementsmenu <= $00) And (optionsmenu > $00)) And (quitmsg <= $00)) And (suicidemsg <= $00)) And (0.0 <= killtimer)) <> 0) Then
            If (drawbutton((imenuscale[$65] + local0), (imenuscale[$186] + local1), imenuscale[$E6], imenuscale[$3C], "Back", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                suicidemsg = $00
                mousehit1 = $00
                saveoptionsini()
                antialias(opt_antialias)
                setfontsmooth(opt_antialias)
            EndIf
            setcolorex($00, $FF, $00)
            If (optionsmenu = $01) Then
                rect((local0 - local5), (local1 - imenuscale[$05]), imenuscale[$6E], imenuscale[$28], $01)
            ElseIf (optionsmenu = $02) Then
                rect((local0 + local10), (local1 - imenuscale[$05]), imenuscale[$6E], imenuscale[$28], $01)
            ElseIf (optionsmenu = $03) Then
                rect((imenuscale[$D2] + local0), (local1 - imenuscale[$05]), imenuscale[$6E], imenuscale[$28], $01)
            ElseIf (optionsmenu = $04) Then
                rect((imenuscale[$140] + local0), (local1 - imenuscale[$05]), imenuscale[$6E], imenuscale[$28], $01)
            EndIf
            If (drawbutton((local0 - imenuscale[$05]), local1, local10, imenuscale[$1E], "GRAPHICS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                optionsmenu = $01
            EndIf
            If (drawbutton((imenuscale[$69] + local0), local1, local10, imenuscale[$1E], "AUDIO", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                optionsmenu = $02
            EndIf
            If (drawbutton((imenuscale[$D7] + local0), local1, local10, imenuscale[$1E], "CONTROLS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                optionsmenu = $03
            EndIf
            If (drawbutton((imenuscale[$145] + local0), local1, local10, imenuscale[$1E], "ADVANCED", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                optionsmenu = $04
            EndIf
            local25 = ((local2 Shr $01) + viewport_center_x)
            local26 = local1
            local27 = imenuscale[$190]
            local28 = imenuscale[$96]
            setcolorex($FF, $FF, $FF)
            Select optionsmenu
                Case $01
                    setfontex(fonts[$00]\Field0)
                    local1 = (local1 + local8)
                    setcolorraw($FFFFFF)
                    text(local0, local1, "Enable Gamma correction:", $00, $00)
                    turnongamma = (drawtick((local0 + local13), local1, (turnongamma = $00), $00) = $00)
                    If ((mouseon((local0 + local13), local1, local6, local6) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "gu", 0.0, $00)
                    EndIf
                    setcolorraw($FFFFFF)
                    text((local0 + local14), local1, "Particles:", $00, $00)
                    local30 = removeparticles
                    removeparticles = (drawtick((local0 + local17), local1, (removeparticles = $00), $00) = $00)
                    If (local30 <> removeparticles) Then
                        For local31 = Each particles
                            local31\Field15 = removeparticles
                        Next
                    EndIf
                    local1 = (local1 + local7)
                    setcolorraw($FFFFFF)
                    text(local0, local1, "Anti-aliasing:", $00, $00)
                    local32 = opt_antialias
                    opt_antialias = drawtick((local0 + local13), local1, opt_antialias, $00)
                    If (local32 <> opt_antialias) Then
                        antialias(opt_antialias)
                        setfontsmooth(opt_antialias)
                    EndIf
                    If ((mouseon((local0 + local13), local1, local6, local6) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "antialias", 0.0, $00)
                    EndIf
                    setcolorraw($FFFFFF)
                    text((local0 + local14), local1, "Decals:", $00, $00)
                    local33 = removedecals
                    removedecals = (drawtick((local0 + local17), local1, (removedecals = $00), $00) = $00)
                    If (local33 <> removedecals) Then
                        For local34 = Each decals
                            local34\Field17 = removedecals
                        Next
                    EndIf
                    local1 = (local1 + local7)
                    setcolorraw($FFFFFF)
                    text((local0 + local14), local1, "VSync:", $00, $00)
                    verticalsync = drawtick((local0 + local17), local1, verticalsync, $00)
                    If ((mouseon((local0 + local17), local1, local6, local6) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "vsync", 0.0, $00)
                        setcolorraw($FFFFFF)
                    EndIf
                    setcolorraw($FFFFFF)
                    text(local0, local1, "Enable roomlights:", $00, $00)
                    enableroomlights = drawtick((local0 + local13), local1, enableroomlights, $00)
                    If ((mouseon((local0 + local13), local1, local6, local6) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "roomlights", 0.0, $00)
                    EndIf
                    local1 = (local1 + local8)
                    screengamma = (slidebar((local0 + local13), local1, local11, (screengamma * 100.0), $00, 0.0, 100.0, turnongamma) * 0.01)
                    setcolorraw($FFFFFF)
                    text(local0, local1, "Screen gamma", $00, $00)
                    If ((mouseon((local0 + local13), local1, local11, local6) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "gamma", screengamma, $00)
                    EndIf
                    local1 = (local1 + local8)
                    text(local0, local1, "FOV:", $00, $00)
                    text((local0 + local8), local1, (Str (Int mainfov)), $00, $00)
                    mainfov = slidebar((local0 + local13), local1, local11, mainfov, $00, 75.0, 100.0, $00)
                    setcamerazoom(currentfov, $00)
                    local1 = (local1 + local8)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Camera interval:", $00, $00)
                    local35 = camupdate
                    camupdate = slider5((local0 + local13), local1, local11, camupdate, $37, "Very Slow", "Slow", "Medium", "High", "Very high")
                    If (((mouseon((local0 + local13), (local1 - local5), local11, local6) And (onsliderid = $00)) Or (onsliderid = $37)) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "cam", 0.0, $00)
                        setcolorraw($FFFFFF)
                    EndIf
                    If (local35 <> camupdate) Then
                        Select camupdate
                            Case $00
                                local36 = 70.0
                            Case $01
                                local36 = 35.0
                            Case $02
                                local36 = 12.0
                            Case $03
                                local36 = 6.0
                            Case $04
                                local36 = 1.0
                        End Select
                        For local38 = Each securitycams
                            local38\Field19 = local36
                        Next
                    EndIf
                    local1 = (local1 + local8)
                    setcolorraw($FFFFFF)
                    text(local0, local1, "Particle amount:", $00, $00)
                    particleamount = slider3((local0 + local13), local1, local11, particleamount, $02, "MINIMAL", "REDUCED", "FULL")
                    If (((mouseon((local0 + local13), (local1 - local5), local11, local6) And (onsliderid = $00)) Or (onsliderid = $02)) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "particleamount", (Float particleamount), $00)
                    EndIf
                Case $02
                    setfontex(fonts[$00]\Field0)
                    local1 = (local1 + local8)
                    musicvolume = (slidebar((local0 + local13), local1, local10, (musicvolume * 100.0), $01, 0.0, 100.0, $00) * 0.01)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Music volume:", $00, $00)
                    If (mouseon((local0 + local13), local1, local10, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "musicvol", musicvolume, $00)
                    EndIf
                    local1 = (local1 + local7)
                    If (deafplayer = $00) Then
                        prevsfxvolume = (slidebar((local0 + local13), local1, local10, (sfxvolume * 100.0), $01, 0.0, 100.0, $00) * 0.01)
                        sfxvolume = prevsfxvolume
                    Else
                        slidebar((local0 + local13), local1, local10, (sfxvolume * 100.0), $01, 0.0, 100.0, $00)
                    EndIf
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Sound volume:", $00, $00)
                    If (mouseon((local0 + local13), local1, local10, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "soundvol", prevsfxvolume, $00)
                    EndIf
                    local1 = (local1 + local7)
                    setcolorex($64, $64, $64)
                    text(local0, local1, "Sound auto-release:", $00, $00)
                    enablesfxrelease = drawtick((local0 + local13), local1, enablesfxrelease, $01)
                    If (mouseon((local0 + local13), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, (imenuscale[$DC] + local28), "sfxautorelease", 0.0, $00)
                    EndIf
                    local1 = (local1 + local7)
                    setcolorex($64, $64, $64)
                    text(local0, local1, "Enable user tracks:", $00, $00)
                    enableusertracks = drawtick((local0 + local13), local1, enableusertracks, $01)
                    If (mouseon((local0 + local13), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "usertrack", 0.0, $00)
                    EndIf
                    If (enableusertracks <> 0) Then
                        local1 = (local1 + local7)
                        setcolorex($FF, $FF, $FF)
                        text(local0, local1, "User track mode:", $00, $00)
                        usertrackmode = drawtick((local0 + local13), local1, usertrackmode, $00)
                        If (usertrackmode <> 0) Then
                            text(local0, (local1 + local6), "Repeat", $00, $00)
                        Else
                            text(local0, (local1 + local6), "Random", $00, $00)
                        EndIf
                        If (mouseon((local0 + local13), local1, local6, local6) <> 0) Then
                            drawoptionstooltip(local25, local26, local27, local28, "usertrackmode", 0.0, $00)
                        EndIf
                    EndIf
                Case $03
                    setfontex(fonts[$00]\Field0)
                    local1 = (local1 + local8)
                    mousesens = ((slidebar((local0 + local13), local1, local10, ((mousesens + 0.5) * 100.0), $01, 0.0, 100.0, $00) * 0.01) - 0.5)
                    setcolorraw($FFFFFF)
                    text(local0, local1, "Mouse sensitivity:", $00, $00)
                    If (mouseon((local0 + local13), local1, local10, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "mousesensitivity", mousesens, $00)
                    EndIf
                    local1 = (local1 + local7)
                    mousesmooth = (slidebar((local0 + local13), local1, local10, (mousesmooth * 50.0), $01, 0.0, 100.0, $00) * 0.02)
                    setcolorraw($FFFFFF)
                    text(local0, local1, "Mouse smoothing:", $00, $00)
                    If (mouseon((local0 + local13), local1, local10, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "mousesmoothing", mousesmooth, $00)
                    EndIf
                    local1 = (local1 + local7)
                    setcolorraw($FFFFFF)
                    text(local0, local1, "Invert mouse Y-axis:", $00, $00)
                    invertmouse = drawtick((local0 + local13), local1, invertmouse, $00)
                    If (mouseon((local0 + local13), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "mouseinvert", 0.0, $00)
                    EndIf
                    setcolorraw($FFFFFF)
                    text((imenuscale[$154] + local0), local1, "Raw input:", $00, $00)
                    rawmouseinput = drawtick((local0 + local14), local1, rawmouseinput, $00)
                    If (mouseon((local0 + local14), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "mouseraw", 0.0, $00)
                    EndIf
                    setcolorraw($FFFFFF)
                    local1 = (local1 + local7)
                    text(local0, local1, "interact button:", $00, $00)
                    mouseinteract = (drawtick((local0 + local13), local1, (mouseinteract = $00), $00) = $00)
                    local1 = (local1 + imenuscale[$0A])
                    setcolorraw($FFFFFF)
                    text(local0, (local1 + local6), "Move Forward", $00, $00)
                    inputbox((local0 + local12), (local1 + local6), local10, local6, keyname((Int min((Float key_up), 210.0))), $05, $00, -1.0)
                    text(local0, (imenuscale[$28] + local1), "Strafe Left", $00, $00)
                    inputbox((local0 + local12), (imenuscale[$28] + local1), local10, local6, keyname((Int min((Float key_left), 210.0))), $03, $00, -1.0)
                    text(local0, (imenuscale[$3C] + local1), "Move Backward", $00, $00)
                    inputbox((local0 + local12), (imenuscale[$3C] + local1), local10, local6, keyname((Int min((Float key_down), 210.0))), $06, $00, -1.0)
                    text(local0, (imenuscale[$50] + local1), "Strafe Right", $00, $00)
                    inputbox((local0 + local12), (imenuscale[$50] + local1), local10, local6, keyname((Int min((Float key_right), 210.0))), $04, $00, -1.0)
                    text(local0, (local1 + local10), "Manual Blink", $00, $00)
                    inputbox((local0 + local12), (local1 + local10), local10, local6, keyname((Int min((Float key_blink), 210.0))), $07, $00, -1.0)
                    text(local0, (imenuscale[$78] + local1), "Sprint", $00, $00)
                    inputbox((local0 + local12), (imenuscale[$78] + local1), local10, local6, keyname((Int min((Float key_sprint), 210.0))), $08, $00, -1.0)
                    text(local0, (imenuscale[$8C] + local1), "Inventory", $00, $00)
                    inputbox((local0 + local12), (imenuscale[$8C] + local1), local10, local6, keyname((Int min((Float key_inv), 210.0))), $09, $00, -1.0)
                    text(local0, (imenuscale[$A0] + local1), "Crouch", $00, $00)
                    inputbox((local0 + local12), (imenuscale[$A0] + local1), local10, local6, keyname((Int min((Float key_crouch), 210.0))), $0A, $00, -1.0)
                    text(local0, (imenuscale[$B4] + local1), "Quick Save", $00, $00)
                    inputbox((local0 + local12), (imenuscale[$B4] + local1), local10, local6, keyname((Int min((Float key_save), 210.0))), $0B, $00, -1.0)
                    text(local0, (local1 + local12), "Console", $00, $00)
                    inputbox((local0 + local12), (local1 + local12), local10, local6, keyname((Int min((Float key_console), 210.0))), $0C, $00, -1.0)
                    text((local0 + local14), (local1 + local6), "Chat", $00, $00)
                    inputbox((local0 + local15), (local1 + local6), local10, local6, keyname((Int min((Float key_chat), 210.0))), $0D, $00, -1.0)
                    text((local0 + local14), (imenuscale[$28] + local1), "Voice", $00, $00)
                    inputbox((local0 + local15), (imenuscale[$28] + local1), local10, local6, keyname((Int min((Float key_voice), 210.0))), $0E, $00, -1.0)
                    text((local0 + local14), (imenuscale[$3C] + local1), "Jump", $00, $00)
                    inputbox((local0 + local15), (imenuscale[$3C] + local1), local10, local6, keyname((Int min((Float key_jump), 210.0))), $0F, $00, -1.0)
                    text((local0 + local14), (imenuscale[$50] + local1), "Lean L", $00, $00)
                    inputbox((local0 + local15), (imenuscale[$50] + local1), local10, local6, keyname((Int min((Float key_leanl), 210.0))), $10, $00, -1.0)
                    text((local0 + local14), (local1 + local10), "Lean R", $00, $00)
                    inputbox((local0 + local15), (local1 + local10), local10, local6, keyname((Int min((Float key_leanr), 210.0))), $11, $00, -1.0)
                    text((local0 + local14), (imenuscale[$78] + local1), "Using", $00, $00)
                    inputbox((local0 + local15), (imenuscale[$78] + local1), local10, local6, keyname((Int min((Float key_using), 210.0))), $12, $00, -1.0)
                    If (mouseon(local0, local1, local14, imenuscale[$DC]) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "controls", 0.0, $00)
                    EndIf
                    For local39 = $00 To $E3 Step $01
                        If (keyhit(local39) <> 0) Then
                            local40 = local39
                            Exit
                        EndIf
                    Next
                    If (local40 <> $00) Then
                        Select selectedinputbox
                            Case $03
                                key_left = local40
                            Case $04
                                key_right = local40
                            Case $05
                                key_up = local40
                            Case $06
                                key_down = local40
                            Case $07
                                key_blink = local40
                            Case $08
                                key_sprint = local40
                            Case $09
                                key_inv = local40
                            Case $0A
                                key_crouch = local40
                            Case $0B
                                key_save = local40
                            Case $0C
                                key_console = local40
                            Case $0D
                                key_chat = local40
                            Case $0E
                                key_voice = local40
                            Case $0F
                                key_jump = local40
                            Case $10
                                key_leanl = local40
                            Case $11
                                key_leanr = local40
                            Case $12
                                key_using = local40
                        End Select
                        selectedinputbox = $00
                    EndIf
                Case $04
                    setfontex(fonts[$00]\Field0)
                    local42 = imenuscale[$10E]
                    local1 = (local1 + local8)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Show HUD:", $00, $00)
                    hudenabled = drawtick((local0 + local42), local1, hudenabled, $00)
                    If (mouseon((local0 + local42), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "hud", 0.0, $00)
                    EndIf
                    local1 = (local1 + local7)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Show Overlays:", $00, $00)
                    local43 = overlaysenabled
                    overlaysenabled = drawtick((local0 + local42), local1, overlaysenabled, $00)
                    If (mouseon((local0 + local42), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "overlays", 0.0, $00)
                    EndIf
                    If (local43 <> overlaysenabled) Then
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
                    local1 = (local1 + local7)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Enable console:", $00, $00)
                    canopenconsole = drawtick((local0 + local42), local1, canopenconsole, $00)
                    If (mouseon((local0 + local42), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "consoleenable", 0.0, $00)
                    EndIf
                    local1 = (local1 + local7)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Console on error:", $00, $00)
                    drawtick((local0 + local42), local1, $00, $00)
                    If (mouseon((local0 + local42), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "consoleerror", 0.0, $00)
                    EndIf
                    local1 = (local1 + local8)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Achievement popups:", $00, $00)
                    achvmsgenabled = drawtick((local0 + local42), local1, achvmsgenabled, $00)
                    If (mouseon((local0 + local42), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "achpopup", 0.0, $00)
                    EndIf
                    local1 = (local1 + local7)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Show FPS:", $00, $00)
                    showfps = drawtick((local0 + local42), local1, showfps, $00)
                    If (mouseon((imenuscale[$10E] + local0), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "showfps", 0.0, $00)
                    EndIf
                    local1 = (local1 + local7)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Show SCP Viewmodel:", $00, $00)
                    showscpviewmodel = drawtick((local0 + local42), local1, showscpviewmodel, $00)
                    If (mouseon((local0 + local42), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "showscpviewmodel", 0.0, $00)
                    EndIf
                    local1 = (local1 + local7)
                    setcolorex($FF, $FF, $FF)
                    text(local0, local1, "Framelimit:", $00, $00)
                    setcolorex($FF, $FF, $FF)
                    If (drawtick((local0 + local42), local1, (0.0 < currframelimit), $00) <> 0) Then
                        currframelimit = (slidebar((local0 + local11), (imenuscale[$1E] + local1), local10, (currframelimit * 99.0), $01, 0.0, 100.0, $00) / 99.0)
                        currframelimit = max(currframelimit, 0.01)
                        framelimit = (Int ((currframelimit * 100.0) + 19.0))
                        setcolorex($FF, $FF, $00)
                        text((imenuscale[$05] + local0), (imenuscale[$19] + local1), ((Str framelimit) + " FPS"), $00, $00)
                    Else
                        currframelimit = 0.0
                        framelimit = $00
                    EndIf
                    If (mouseon((local0 + local42), local1, local6, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "framelimit", (Float framelimit), $00)
                    EndIf
                    If (mouseon((local0 + local11), local1, local10, local6) <> 0) Then
                        drawoptionstooltip(local25, local26, local27, local28, "framelimit", (Float framelimit), $00)
                    EndIf
            End Select
        ElseIf (((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg > $00)) And (0.0 <= killtimer)) <> 0) Then
            If (drawbutton(local0, (imenuscale[$3C] + local1), imenuscale[$186], imenuscale[$3C], "Quit", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                disconnectserver("", $01)
            EndIf
            If (drawbutton((imenuscale[$65] + local0), (imenuscale[$158] + local1), imenuscale[$E6], imenuscale[$3C], "Back", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                mousehit1 = $00
            EndIf
        ElseIf ((((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg <= $00)) And (0.0 <= killtimer)) And (suicidemsg > $00)) <> 0) Then
            If (drawbutton(local0, (imenuscale[$3C] + local1), imenuscale[$186], imenuscale[$3C], "Suicide", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                If (myplayer\Field49 <> model_wait) Then
                    kill("decided to gnaw their veins", $01)
                    menuopen = $00
                    menu_open_type = menuopen
                    achievementsmenu = $00
                    optionsmenu = $00
                    quitmsg = $00
                    suicidemsg = $00
                    mousehit1 = $00
                EndIf
            EndIf
            If (drawbutton((imenuscale[$65] + local0), (imenuscale[$158] + local1), imenuscale[$E6], imenuscale[$3C], "Back", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                suicidemsg = $00
                mousehit1 = $00
            EndIf
        Else
            If (drawbutton((imenuscale[$65] + local0), (imenuscale[$158] + local1), imenuscale[$E6], imenuscale[$3C], "Back", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                suicidemsg = $00
                mousehit1 = $00
            EndIf
            If (achievementsmenu > $00) Then
                If (floor(3.0) >= (Float achievementsmenu)) Then
                    If (drawbutton((imenuscale[$155] + local0), (imenuscale[$158] + local1), imenuscale[$32], imenuscale[$3C], ">", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        achievementsmenu = (achievementsmenu + $01)
                    EndIf
                EndIf
                If (achievementsmenu > $01) Then
                    If (drawbutton((imenuscale[$29] + local0), (imenuscale[$158] + local1), imenuscale[$32], imenuscale[$3C], "<", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        achievementsmenu = (achievementsmenu - $01)
                    EndIf
                EndIf
                For local39 = $00 To $0B Step $01
                    If ((((achievementsmenu - $01) * $0C) + local39) < $25) Then
                        drawachvimg(local21, (((local39 Sar $02) * imenuscale[$78]) + local1), (((achievementsmenu - $01) * $0C) + local39))
                    Else
                        Exit
                    EndIf
                Next
                For local39 = $00 To $0B Step $01
                    If ((((achievementsmenu - $01) * $0C) + local39) < $25) Then
                        If (mouseon((((local39 Mod $04) * local23) + local21), (((local39 Sar $02) * imenuscale[$78]) + local1), (Int (64.0 * local22)), (Int (64.0 * local22))) <> 0) Then
                            achievementtooltip((((achievementsmenu - $01) * $0C) + local39))
                            Exit
                        EndIf
                    Else
                        Exit
                    EndIf
                Next
            EndIf
        EndIf
        local1 = (local1 + $0A)
        If ((((achievementsmenu Or optionsmenu) Or quitmsg) Or suicidemsg) <= $00) Then
            local44 = imenuscale[$186]
            local45 = imenuscale[$3C]
            local46 = imenuscale[$4B]
            local47 = imenuscale[$50]
            local48 = ((local44 Shr $01) + local0)
            local49 = (local45 Shr $01)
            If (0.0 <= killtimer) Then
                local1 = (local1 + imenuscale[$48])
                If (drawbutton(local0, local1, local44, local45, "Resume", $01, $01, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    menuopen = $00
                    If (local4 = $00) Then
                        resumesounds()
                    EndIf
                    resetmouse()
                EndIf
                local1 = (local1 + local46)
                If (local4 = $00) Then
                    If (selecteddifficulty\Field2 = $00) Then
                        If (gamesaved <> 0) Then
                            If (drawbutton(local0, local1, local44, local45, "Load Game", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                clearserver()
                                startloadgame(((savepath + currsave) + "\"), currsave)
                            EndIf
                        Else
                            drawframe(local0, local1, local44, local45, $00, $00)
                            setcolorex($64, $64, $64)
                            setfontex(fonts[$01]\Field0)
                            text(local48, (local1 + local49), "Load Game", $01, $01)
                        EndIf
                        local1 = (local1 + local46)
                    EndIf
                EndIf
                If (drawbutton(local0, local1, local44, local45, "Achievements", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    achievementsmenu = $01
                EndIf
                local1 = (local1 + local46)
                If (drawbutton(local0, local1, local44, local45, "Options", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    optionsmenu = $01
                EndIf
                local1 = (local1 + local46)
                If (local4 <> 0) Then
                    If (spectate\Field1 = $FFFFFFFF) Then
                        If (drawbutton(local0, local1, local44, local45, "Suicide", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            suicidemsg = $01
                        EndIf
                        local1 = (local1 + local46)
                    EndIf
                EndIf
                If (drawbutton(local0, local1, local44, local45, "Quit", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    quitmsg = $01
                EndIf
                local1 = (local1 + local46)
            Else
                local1 = (local1 + local47)
                If (local4 <> 0) Then
                    If (networkserver\Field12 = $00) Then
                        If (drawbutton(local0, local1, local44, local45, "Spawn", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            eyeirritation = 0.0
                            stamina = 80.0
                            staminaeffect = 0.5
                            staminaeffecttimer = 200.0
                            superman = $00
                            myplayer\Field31 = $00
                            supermantimer = 0.0
                            menuopen = $00
                            infect = 0.0
                            heartbeatvolume = 0.0
                            bloodloss = 0.0
                            camerashake = 0.0
                            lightflash = 0.0
                            blurtimer = 0.0
                            crouch = $00
                            killtimer = 0.0
                            falltimer = 0.0
                            godmode = $00
                            noclip = $00
                            playable = $01
                            killanim = $00
                            injuries = 0.0
                            dropspeed = -0.1
                            headdropspeed = 0.0
                            shake = 0.0
                            currspeed = 0.0
                            hideentity(head)
                            showentity(collider)
                            movemouse(local50, local51)
                            hidepointer()
                            flushkeys()
                            flushmouse()
                            drawloading(100.0, $00, $00, $00)
                            updateworld(0.0)
                            prevtime = millisecs()
                            fpsfactor = 0.0
                            resetinput()
                            updatedoors()
                            positionentity(collider, saveposx, (saveposy + 0.2), saveposz, $00)
                            rotateentity(collider, 0.0, saveposa, 0.0, $00)
                            resetentity(collider)
                            If (getscripts() <> 0) Then
                                public_inqueue($04, $01)
                            EndIf
                            udp_bytestreamwritechar($10)
                            If (iscoopmode() <> 0) Then
                                udp_writebyte(networkserver\Field20)
                            EndIf
                            udp_setmicrobyte($10)
                            For local52 = Each rooms
                                If (local52\Field8\Field11 = saveroom) Then
                                    updatedoors()
                                    updaterooms()
                                    For local53 = Each items
                                        local53\Field12 = 0.0
                                    Next
                                    playerroom = local52
                                    Exit
                                EndIf
                            Next
                        EndIf
                        local1 = (local1 + local47)
                        If (drawbutton(local0, local1, local44, local45, "Quit", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            disconnectserver("", $01)
                        EndIf
                    ElseIf (drawbutton(local0, local1, local44, local45, "Quit", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        disconnectserver("", $01)
                    EndIf
                Else
                    If (selecteddifficulty\Field2 = $00) Then
                        If (gamesaved <> 0) Then
                            If (drawbutton(local0, local1, local44, local45, "Load Game", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                clearserver()
                                startloadgame(((savepath + currsave) + "\"), currsave)
                            EndIf
                        Else
                            drawframe(local0, local1, local44, local45, $00, $00)
                            setcolorex($64, $64, $64)
                            setfontex(fonts[$01]\Field0)
                            text(local48, (local1 + local49), "Load Game", $01, $01)
                        EndIf
                        local1 = (local1 + local46)
                    EndIf
                    If (drawbutton(local0, local1, local44, local45, "Quit to Menu", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        clearserver()
                        currsave = ""
                        flushkeys()
                    EndIf
                    local1 = (local1 + local47)
                EndIf
            EndIf
            If (0.0 > killtimer) Then
                setfontex(fonts[$00]\Field0)
                rowtext(deathmsg, (Float local0), (Float (local1 + local47)), (Float local44), (Float imenuscale[$258]), $00, 1.0, $00)
            EndIf
        EndIf
        ui_showpointer()
    Else
        If (infocus = $00) Then
            If (using294 = $00) Then
                menuopen = $01
                If (udp_getstream() = $00) Then
                    pausesounds()
                EndIf
            EndIf
        EndIf
        setfontex(fonts[$00]\Field0)
    EndIf
    Return $00
End Function
