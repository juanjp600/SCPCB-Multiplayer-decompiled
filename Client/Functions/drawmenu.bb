Function drawmenu%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6%
    Local local7%
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local13.particles
    Local local14.decals
    Local local16#
    Local local18.securitycams
    Local local19%
    Local local20%
    Local local22$
    Local local23.rooms
    Local local24.items
    If (((infocus = $00) And (menuopen = $00)) <> 0) Then
        If (using294 = $00) Then
            menuopen = $01
            If (udp_getstream() = $00) Then
                pausesounds()
            EndIf
        EndIf
    EndIf
    If (menuopen <> 0) Then
        If (((playerroom\Field7\Field11 <> "exit1") And (playerroom\Field7\Field11 <> "gatea")) <> 0) Then
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
                        msg = "STOP HIDING"
                        msgtimer = 420.0
                        menuopen = $00
                        If (udp_getstream() = $00) Then
                            resumesounds()
                        EndIf
                        Return $00
                    EndIf
                EndIf
            EndIf
        EndIf
        invopen = $00
        local2 = imagewidth(pausemenuimg)
        local3 = imageheight(pausemenuimg)
        local0 = ((graphicwidth Sar $01) - (local2 Sar $01))
        local1 = ((graphicheight Sar $01) - (local3 Sar $01))
        drawimage(pausemenuimg, local0, local1, $00)
        color($FF, $FF, $FF)
        local0 = (Int ((132.0 * menuscale) + (Float local0)))
        local1 = (Int ((122.0 * menuscale) + (Float local1)))
        If (mousedown1 = $00) Then
            onsliderid = $00
        EndIf
        If (achievementsmenu > $00) Then
            aasetfont(font2)
            aatext(local0, (Int ((Float local1) - (77.0 * menuscale))), "ACHIEVEMENTS", $00, $01, 1.0)
            aasetfont(font1)
        ElseIf (optionsmenu > $00) Then
            aasetfont(font2)
            aatext(local0, (Int ((Float local1) - (77.0 * menuscale))), "OPTIONS", $00, $01, 1.0)
            aasetfont(font1)
        ElseIf (quitmsg > $00) Then
            aasetfont(font2)
            aatext(local0, (Int ((Float local1) - (77.0 * menuscale))), "QUIT?", $00, $01, 1.0)
            aasetfont(font1)
        ElseIf (suicidemsg > $00) Then
            aasetfont(font2)
            aatext(local0, (Int ((Float local1) - (77.0 * menuscale))), "SUICIDE?", $00, $01, 1.0)
            aasetfont(font1)
        ElseIf (0.0 <= killtimer) Then
            aasetfont(font2)
            aatext(local0, (Int ((Float local1) - (77.0 * menuscale))), "PAUSED", $00, $01, 1.0)
            aasetfont(font1)
        Else
            aasetfont(font2)
            aatext(local0, (Int ((Float local1) - (77.0 * menuscale))), "YOU DIED", $00, $01, 1.0)
            aasetfont(font1)
        EndIf
        local4 = (Int ((22.0 * menuscale) + (Float local0)))
        local5 = ((Float graphicheight) / 768.0)
        local6 = (Int (76.0 * local5))
        local7 = $40
        If (((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg <= $00)) And (suicidemsg <= $00)) <> 0) Then
            aasetfont(font1)
            aatext(local0, local1, ("Difficulty: " + selecteddifficulty\Field0), $00, $00, 1.0)
            aatext(local0, (Int ((20.0 * menuscale) + (Float local1))), ("Map seed: " + randomseed), $00, $00, 1.0)
        ElseIf ((((((achievementsmenu <= $00) And (optionsmenu > $00)) And (quitmsg <= $00)) And (suicidemsg <= $00)) And (0.0 <= killtimer)) <> 0) Then
            If (drawbutton((Int ((101.0 * menuscale) + (Float local0))), (Int ((390.0 * menuscale) + (Float local1))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), "Back", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                suicidemsg = $00
                mousehit1 = $00
                saveoptionsini()
                antialias(opt_antialias)
                texturelodbias(texturefloat)
            EndIf
            color($00, $FF, $00)
            If (optionsmenu = $01) Then
                rect((Int ((Float local0) - (10.0 * menuscale))), (Int ((Float local1) - (5.0 * menuscale))), (Int (110.0 * menuscale)), (Int (40.0 * menuscale)), $01)
            ElseIf (optionsmenu = $02) Then
                rect((Int ((100.0 * menuscale) + (Float local0))), (Int ((Float local1) - (5.0 * menuscale))), (Int (110.0 * menuscale)), (Int (40.0 * menuscale)), $01)
            ElseIf (optionsmenu = $03) Then
                rect((Int ((210.0 * menuscale) + (Float local0))), (Int ((Float local1) - (5.0 * menuscale))), (Int (110.0 * menuscale)), (Int (40.0 * menuscale)), $01)
            ElseIf (optionsmenu = $04) Then
                rect((Int ((320.0 * menuscale) + (Float local0))), (Int ((Float local1) - (5.0 * menuscale))), (Int (110.0 * menuscale)), (Int (40.0 * menuscale)), $01)
            EndIf
            If (drawbutton((Int ((Float local0) - (5.0 * menuscale))), local1, (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "GRAPHICS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                optionsmenu = $01
            EndIf
            If (drawbutton((Int ((105.0 * menuscale) + (Float local0))), local1, (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "AUDIO", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                optionsmenu = $02
            EndIf
            If (drawbutton((Int ((215.0 * menuscale) + (Float local0))), local1, (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "CONTROLS", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                optionsmenu = $03
            EndIf
            If (drawbutton((Int ((325.0 * menuscale) + (Float local0))), local1, (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "ADVANCED", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                optionsmenu = $04
            EndIf
            local8 = (Float ((graphicwidth Sar $01) + (local2 Sar $01)))
            local9 = (Float local1)
            local10 = (400.0 * menuscale)
            local11 = (150.0 * menuscale)
            color($FF, $FF, $FF)
            Select optionsmenu
                Case $01
                    aasetfont(font1)
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "VSync:", $00, $00, 1.0)
                    verticalsync = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), verticalsync, $00)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "vsync", 0.0, $00)
                    EndIf
                    color($FF, $FF, $FF)
                    aatext((Int ((300.0 * menuscale) + (Float local0))), local1, "Particles:", $00, $00, 1.0)
                    removeparticles = (drawtick((Int ((400.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (removeparticles = $00), $00) = $00)
                    For local13 = Each particles
                        local13\Field18 = removeparticles
                    Next
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Anti-aliasing:", $00, $00, 1.0)
                    opt_antialias = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), opt_antialias, $00)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "antialias", 0.0, $00)
                    EndIf
                    color($FF, $FF, $FF)
                    aatext((Int ((300.0 * menuscale) + (Float local0))), local1, "Decals:", $00, $00, 1.0)
                    removedecals = (drawtick((Int ((400.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (removedecals = $00), $00) = $00)
                    For local14 = Each decals
                        local14\Field17 = removedecals
                    Next
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Enable room lights:", $00, $00, 1.0)
                    enableroomlights = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), enableroomlights, $00)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "roomlights", 0.0, $00)
                    EndIf
                    mainfov = min(max(slidebar((Int ((300.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (90.0 * menuscale)), mainfov, $00), 60.0), 90.0)
                    color($FF, $FF, $FF)
                    aasetfont(fontsl)
                    aatext((Int ((340.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), ("FOV: " + (Str (Int mainfov))), $00, $00, 1.0)
                    aasetfont(font1)
                    currentfov = mainfov
                    If (udp_getstream() = $00) Then
                        camerazoom(camera, (min(((currcamerazoom / 400.0) + 1.0), 1.1) / tan(((atan((tan((currentfov / 2.0)) * ((Float realgraphicwidth) / (Float realgraphicheight)))) * 2.0) / 2.0))))
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Disable gamma update:", $00, $00, 1.0)
                    turnongamma = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), turnongamma, $00)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "gu", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    screengamma = (slidebar((Int ((270.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (screengamma * 50.0), $01) / 50.0)
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Screen gamma", $00, $00, 1.0)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int ((100.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "gamma", screengamma, $00)
                    EndIf
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Particle amount:", $00, $00, 1.0)
                    particleamount = slider3((Int ((270.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), particleamount, $02, "MINIMAL", "REDUCED", "FULL")
                    If (((mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) - (6.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $02)) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "particleamount", (Float particleamount), $00)
                    EndIf
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Texture LOD Bias:", $00, $00, 1.0)
                    texturedetails = slider5((Int ((270.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), texturedetails, $03, "1.5", "0.4", "0.0", "-0.4", "-0.8")
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
                    If (((mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) - (6.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $03)) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int ((100.0 * menuscale) + local11)), "texquality", 0.0, $00)
                    EndIf
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Cameras update interval:", $00, $00, 1.0)
                    camupdate = slider5((Int ((270.0 * menuscale) + (Float local0))), (Int ((6.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), camupdate, $37, "Very slow speed", "Slow speed", "Medium speed", "High speed", "Very high speed")
                    Select camupdate
                        Case $00
                            local16 = 70.0
                        Case $01
                            local16 = 35.0
                        Case $02
                            local16 = 12.0
                        Case $03
                            local16 = 6.0
                        Case $04
                            local16 = 1.0
                    End Select
                    If (((mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) - (6.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $37)) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int ((100.0 * menuscale) + local11)), "cam", 0.0, $00)
                    EndIf
                    For local18 = Each securitycams
                        local18\Field19 = local16
                    Next
                Case $02
                    aasetfont(font1)
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    musicvolume = (slidebar((Int ((250.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (100.0 * menuscale)), (musicvolume * 100.0), $01) / 100.0)
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Music volume:", $00, $00, 1.0)
                    If (mouseon((Int ((250.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "musicvol", musicvolume, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    If (deafplayer = $00) Then
                        prevsfxvolume = (slidebar((Int ((250.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (100.0 * menuscale)), (sfxvolume * 100.0), $01) / 100.0)
                        sfxvolume = prevsfxvolume
                    Else
                        slidebar((Int ((250.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (100.0 * menuscale)), (sfxvolume * 100.0), $01)
                    EndIf
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Sound volume:", $00, $00, 1.0)
                    If (mouseon((Int ((250.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "soundvol", prevsfxvolume, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($64, $64, $64)
                    aatext(local0, local1, "Sound auto-release:", $00, $00, 1.0)
                    enablesfxrelease = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), enablesfxrelease, $01)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int ((220.0 * menuscale) + local11)), "sfxautorelease", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($64, $64, $64)
                    aatext(local0, local1, "Enable user tracks:", $00, $00, 1.0)
                    enableusertracks = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), enableusertracks, $01)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "usertrack", 0.0, $00)
                    EndIf
                    If (enableusertracks <> 0) Then
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        color($FF, $FF, $FF)
                        aatext(local0, local1, "User track mode:", $00, $00, 1.0)
                        usertrackmode = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), usertrackmode, $00)
                        If (usertrackmode <> 0) Then
                            aatext(local0, (Int ((20.0 * menuscale) + (Float local1))), "Repeat", $00, $00, 1.0)
                        Else
                            aatext(local0, (Int ((20.0 * menuscale) + (Float local1))), "Random", $00, $00, 1.0)
                        EndIf
                        If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "usertrackmode", 0.0, $00)
                        EndIf
                    EndIf
                Case $03
                    aasetfont(font1)
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    mousesens = ((slidebar((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (100.0 * menuscale)), ((mousesens + 0.5) * 100.0), $01) / 100.0) - 0.5)
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Mouse sensitivity:", $00, $00, 1.0)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "mousesensitivity", mousesens, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    mousesmooth = (slidebar((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int (100.0 * menuscale)), (mousesmooth * 50.0), $01) / 50.0)
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Mouse smoothing:", $00, $00, 1.0)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) - (4.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "mousesmoothing", mousesmooth, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Invert mouse Y-axis:", $00, $00, 1.0)
                    invertmouse = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), invertmouse, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "mouseinvert", 0.0, $00)
                    EndIf
                    color($FF, $FF, $FF)
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    aatext(local0, local1, "Using button (instead of mouse):", $00, $00, 1.0)
                    mouseinteract = (drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (mouseinteract = $00), $00) = $00)
                    local1 = (Int ((10.0 * menuscale) + (Float local1)))
                    aatext(local0, (Int ((20.0 * menuscale) + (Float local1))), "Move Forward", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_up), 210.0))), $05, $00, -1.0)
                    aatext(local0, (Int ((40.0 * menuscale) + (Float local1))), "Strafe Left", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_left), 210.0))), $03, $00, -1.0)
                    aatext(local0, (Int ((60.0 * menuscale) + (Float local1))), "Move Backward", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_down), 210.0))), $06, $00, -1.0)
                    aatext(local0, (Int ((80.0 * menuscale) + (Float local1))), "Strafe Right", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_right), 210.0))), $04, $00, -1.0)
                    aatext(local0, (Int ((100.0 * menuscale) + (Float local1))), "Manual Blink", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_blink), 210.0))), $07, $00, -1.0)
                    aatext(local0, (Int ((120.0 * menuscale) + (Float local1))), "Sprint", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_sprint), 210.0))), $08, $00, -1.0)
                    aatext(local0, (Int ((140.0 * menuscale) + (Float local1))), "Open/Close Inventory", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_inv), 210.0))), $09, $00, -1.0)
                    aatext(local0, (Int ((160.0 * menuscale) + (Float local1))), "Crouch", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((160.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_crouch), 210.0))), $0A, $00, -1.0)
                    aatext(local0, (Int ((180.0 * menuscale) + (Float local1))), "Quick Save", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((180.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_save), 210.0))), $0B, $00, -1.0)
                    aatext(local0, (Int ((200.0 * menuscale) + (Float local1))), "Open/Close Console", $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local0))), (Int ((200.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_console), 210.0))), $0C, $00, -1.0)
                    aatext((Int ((300.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "Chat", $00, $00, 1.0)
                    inputbox((Int ((350.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_chat), 210.0))), $0D, $00, -1.0)
                    aatext((Int ((300.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), "Voice", $00, $00, 1.0)
                    inputbox((Int ((350.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_voice), 210.0))), $0E, $00, -1.0)
                    aatext((Int ((300.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), "Jump", $00, $00, 1.0)
                    inputbox((Int ((350.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_jump), 210.0))), $0F, $00, -1.0)
                    aatext((Int ((300.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), "Lean L", $00, $00, 1.0)
                    inputbox((Int ((350.0 * menuscale) + (Float local0))), (Int ((80.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_leanl), 210.0))), $10, $00, -1.0)
                    aatext((Int ((300.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), "Lean R", $00, $00, 1.0)
                    inputbox((Int ((350.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_leanr), 210.0))), $11, $00, -1.0)
                    aatext((Int ((300.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), "Using", $00, $00, 1.0)
                    inputbox((Int ((350.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_using), 210.0))), $12, $00, -1.0)
                    If (mouseon(local0, local1, (Int (300.0 * menuscale)), (Int (220.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "controls", 0.0, $00)
                    EndIf
                    For local19 = $00 To $E3 Step $01
                        If (keyhit(local19) <> 0) Then
                            local20 = local19
                            Exit
                        EndIf
                    Next
                    If (local20 <> $00) Then
                        Select selectedinputbox
                            Case $03
                                key_left = local20
                            Case $04
                                key_right = local20
                            Case $05
                                key_up = local20
                            Case $06
                                key_down = local20
                            Case $07
                                key_blink = local20
                            Case $08
                                key_sprint = local20
                            Case $09
                                key_inv = local20
                            Case $0A
                                key_crouch = local20
                            Case $0B
                                key_save = local20
                            Case $0C
                                key_console = local20
                            Case $0D
                                key_chat = local20
                            Case $0E
                                key_voice = local20
                            Case $0F
                                key_jump = local20
                            Case $10
                                key_leanl = local20
                            Case $11
                                key_leanr = local20
                            Case $12
                                key_using = local20
                        End Select
                        selectedinputbox = $00
                    EndIf
                Case $04
                    aasetfont(font1)
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Show HUD:", $00, $00, 1.0)
                    hudenabled = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), hudenabled, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "hud", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Enable console:", $00, $00, 1.0)
                    canopenconsole = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), canopenconsole, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "consoleenable", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Open console on error:", $00, $00, 1.0)
                    drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), $00, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "consoleerror", 0.0, $00)
                    EndIf
                    local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Achievement popups:", $00, $00, 1.0)
                    achvmsgenabled = drawtick((Int ((270.0 * menuscale) + (Float local0))), local1, achvmsgenabled, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "achpopup", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Show FPS:", $00, $00, 1.0)
                    showfps = drawtick((Int ((270.0 * menuscale) + (Float local0))), local1, showfps, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "showfps", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Show SCP Viewmodel:", $00, $00, 1.0)
                    showscpviewmodel = drawtick((Int ((270.0 * menuscale) + (Float local0))), local1, showscpviewmodel, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "showscpviewmodel", 0.0, $00)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Framelimit:", $00, $00, 1.0)
                    color($FF, $FF, $FF)
                    If (drawtick((Int ((270.0 * menuscale) + (Float local0))), local1, (0.0 < currframelimit), $00) <> 0) Then
                        currframelimit = (slidebar((Int ((150.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (currframelimit * 99.0), $01) / 99.0)
                        currframelimit = max(currframelimit, 0.01)
                        framelimit = (Int ((currframelimit * 100.0) + 19.0))
                        color($FF, $FF, $00)
                        aatext((Int ((5.0 * menuscale) + (Float local0))), (Int ((25.0 * menuscale) + (Float local1))), ((Str framelimit) + " FPS"), $00, $00, 1.0)
                    Else
                        currframelimit = 0.0
                        framelimit = $00
                    EndIf
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "framelimit", (Float framelimit), $00)
                    EndIf
                    If (mouseon((Int ((150.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "framelimit", (Float framelimit), $00)
                    EndIf
                    local1 = (Int ((80.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    aatext(local0, local1, "Antialiased text:", $00, $00, 1.0)
                    aatextenable = drawtick((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), aatextenable, $00)
                    If (aatextenable_prev <> aatextenable) Then
                        freeallfonts($00, $00)
                        loadallfonts($01)
                        aatextenable_prev = aatextenable
                    EndIf
                    If (mouseon((Int ((270.0 * menuscale) + (Float local0))), (Int ((Float local1) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local8), (Int local9), (Int local10), (Int local11), "antialiastext", 0.0, $00)
                    EndIf
            End Select
        ElseIf (((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg > $00)) And (0.0 <= killtimer)) <> 0) Then
            If (drawbutton(local0, (Int ((60.0 * menuscale) + (Float local1))), (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Quit", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                disconnectserver("", $01)
            EndIf
            If (drawbutton((Int ((101.0 * menuscale) + (Float local0))), (Int ((344.0 * menuscale) + (Float local1))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), "Back", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                mousehit1 = $00
            EndIf
        ElseIf ((((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg <= $00)) And (0.0 <= killtimer)) And (suicidemsg > $00)) <> 0) Then
            If (drawbutton(local0, (Int ((60.0 * menuscale) + (Float local1))), (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Suicide", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                If (myplayer\Field51 <> model_wait) Then
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
            If (drawbutton((Int ((101.0 * menuscale) + (Float local0))), (Int ((344.0 * menuscale) + (Float local1))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), "Back", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                suicidemsg = $00
                mousehit1 = $00
            EndIf
        Else
            If (drawbutton((Int ((101.0 * menuscale) + (Float local0))), (Int ((344.0 * menuscale) + (Float local1))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), "Back", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                suicidemsg = $00
                mousehit1 = $00
            EndIf
            If (achievementsmenu > $00) Then
                If (floor(3.0) >= (Float achievementsmenu)) Then
                    If (drawbutton((Int ((341.0 * menuscale) + (Float local0))), (Int ((344.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (60.0 * menuscale)), ">", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        achievementsmenu = (achievementsmenu + $01)
                    EndIf
                EndIf
                If (achievementsmenu > $01) Then
                    If (drawbutton((Int ((41.0 * menuscale) + (Float local0))), (Int ((344.0 * menuscale) + (Float local1))), (Int (50.0 * menuscale)), (Int (60.0 * menuscale)), "<", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        achievementsmenu = (achievementsmenu - $01)
                    EndIf
                EndIf
                For local19 = $00 To $0B Step $01
                    If ((((achievementsmenu - $01) * $0C) + local19) < $25) Then
                        drawachvimg(local4, (Int (((Float ((local19 Sar $02) * $78)) * menuscale) + (Float local1))), (((achievementsmenu - $01) * $0C) + local19))
                    Else
                        Exit
                    EndIf
                Next
                For local19 = $00 To $0B Step $01
                    If ((((achievementsmenu - $01) * $0C) + local19) < $25) Then
                        If (mouseon((((local19 Mod $04) * local6) + local4), (Int (((Float ((local19 Sar $02) * $78)) * menuscale) + (Float local1))), (Int (64.0 * local5)), (Int (64.0 * local5))) <> 0) Then
                            achievementtooltip((((achievementsmenu - $01) * $0C) + local19))
                            Exit
                        EndIf
                    Else
                        Exit
                    EndIf
                Next
            EndIf
        EndIf
        local1 = (local1 + $0A)
        If (((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg <= $00)) And (suicidemsg <= $00)) <> 0) Then
            If (0.0 <= killtimer) Then
                local1 = (Int ((72.0 * menuscale) + (Float local1)))
                If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Resume", $01, $01, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    menuopen = $00
                    If (udp_getstream() = $00) Then
                        resumesounds()
                    EndIf
                    resetmouse()
                EndIf
                local1 = (Int ((75.0 * menuscale) + (Float local1)))
                If (udp_getstream() = $00) Then
                    If (selecteddifficulty\Field2 = $00) Then
                        If (gamesaved <> 0) Then
                            If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Load Game", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                clearserver()
                                startloadgame(((savepath + currsave) + "\"), currsave)
                            EndIf
                        Else
                            drawframe(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), $00, $00)
                            color($64, $64, $64)
                            aasetfont(font2)
                            aatext((Int (((390.0 * menuscale) / 2.0) + (Float local0))), (Int (((60.0 * menuscale) / 2.0) + (Float local1))), "Load Game", $01, $01, 1.0)
                        EndIf
                        local1 = (Int ((75.0 * menuscale) + (Float local1)))
                    EndIf
                EndIf
                If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Achievements", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    achievementsmenu = $01
                EndIf
                local1 = (Int ((75.0 * menuscale) + (Float local1)))
                If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Options", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    optionsmenu = $01
                EndIf
                local1 = (Int ((75.0 * menuscale) + (Float local1)))
                If (udp_getstream() <> 0) Then
                    If (spectate\Field1 = $FFFFFFFF) Then
                        If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Suicide", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            suicidemsg = $01
                        EndIf
                        local1 = (Int ((75.0 * menuscale) + (Float local1)))
                    EndIf
                EndIf
                If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Quit", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                    quitmsg = $01
                EndIf
                local1 = (Int ((75.0 * menuscale) + (Float local1)))
            Else
                local1 = (Int ((80.0 * menuscale) + (Float local1)))
                If (udp_getstream() <> 0) Then
                    If (networkserver\Field15 = $00) Then
                        If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Spawn", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            local22 = playerroom\Field7\Field11
                            If (local22 = "173") Then
                                msg = "You cannot respawn in this location"
                                msgtimer = 280.0
                                Return $00
                            EndIf
                            eyeirritation = 0.0
                            stamina = 60.0
                            staminaeffect = 1.0
                            staminaeffecttimer = 0.0
                            For local19 = $00 To $05 Step $01
                                scp1025state[local19] = 0.0
                            Next
                            superman = $00
                            myplayer\Field33 = $00
                            supermantimer = 0.0
                            drawloading(0.0, $00, $00, $00)
                            menuopen = $00
                            dropspeed = 0.0
                            shake = 0.0
                            currspeed = 0.0
                            infect = 0.0
                            heartbeatvolume = 0.0
                            bloodloss = 0.0
                            camerashake = 0.0
                            shake = 0.0
                            lightflash = 0.0
                            blurtimer = 0.0
                            crouch = $00
                            killtimer = 0.0
                            falltimer = 0.0
                            menuopen = $00
                            godmode = $00
                            noclip = $00
                            hideentity(head)
                            movemouse(viewport_center_x, viewport_center_y)
                            aasetfont(font1)
                            hidepointer()
                            flushkeys()
                            flushmouse()
                            playable = $01
                            drawloading(100.0, $00, $00, $00)
                            dropspeed = 0.0
                            updateworld(0.0)
                            prevtime = (Float millisecs())
                            fpsfactor = 0.0
                            resetinput()
                            updatedoors()
                            dropspeed = -0.1
                            headdropspeed = 0.0
                            shake = 0.0
                            currspeed = 0.0
                            heartbeatvolume = 0.0
                            camerashake = 0.0
                            shake = 0.0
                            lightflash = 0.0
                            blurtimer = 0.0
                            falltimer = 0.0
                            menuopen = $00
                            godmode = $00
                            noclip = $00
                            showentity(collider)
                            killtimer = 0.0
                            killanim = $00
                            positionentity(collider, saveposx, (saveposy + 0.7), saveposz, $00)
                            rotateentity(collider, 0.0, saveposa, 0.0, $00)
                            resetentity(collider)
                            injuries = 0.0
                            If (getscripts() <> 0) Then
                                public_inqueue($04, $01)
                            EndIf
                            If (udp_getstream() <> 0) Then
                                udp_bytestreamwritechar($10)
                                udp_setmicrobyte($10)
                            EndIf
                            For local23 = Each rooms
                                If (local23\Field7\Field11 = saveroom) Then
                                    updatedoors()
                                    updaterooms()
                                    For local24 = Each items
                                        local24\Field12 = 0.0
                                    Next
                                    playerroom = local23
                                    Exit
                                EndIf
                            Next
                        EndIf
                        local1 = (Int ((80.0 * menuscale) + (Float local1)))
                        If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Quit", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                            disconnectserver("", $01)
                        EndIf
                    ElseIf (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Quit", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        disconnectserver("", $01)
                    EndIf
                Else
                    If (selecteddifficulty\Field2 = $00) Then
                        If (gamesaved <> 0) Then
                            If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Load Game", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                                clearserver()
                                startloadgame(((savepath + currsave) + "\"), currsave)
                            EndIf
                        Else
                            drawframe(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), $00, $00)
                            color($64, $64, $64)
                            aasetfont(font2)
                            aatext((Int (((390.0 * menuscale) / 2.0) + (Float local0))), (Int (((60.0 * menuscale) / 2.0) + (Float local1))), "Load Game", $01, $01, 1.0)
                        EndIf
                        local1 = (Int ((75.0 * menuscale) + (Float local1)))
                    EndIf
                    If (drawbutton(local0, local1, (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "Quit to Menu", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        clearserver()
                        currsave = ""
                        flushkeys()
                    EndIf
                    local1 = (Int ((80.0 * menuscale) + (Float local1)))
                EndIf
            EndIf
            aasetfont(font1)
            If (0.0 > killtimer) Then
                rowtext(deathmsg, (Float local0), ((80.0 * menuscale) + (Float local1)), (390.0 * menuscale), (600.0 * menuscale), $00, 1.0, $00)
            EndIf
        EndIf
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
    EndIf
    aasetfont(font1)
    Return $00
End Function
