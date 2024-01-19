Function updatelauncher%()
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
    local0 = aatextenable
    aatextenable = $00
    menuscale = 1.0
    graphics3dext(launcherwidth, launcherheight, $00, $02)
    setbuffer(backbuffer())
    realgraphicwidth = graphicwidth
    realgraphicheight = graphicheight
    font1 = aaloadfont("GFX\font\cour\Courier New Rus.ttf", 16.0, $00, $00, $00, $02)
    aasetfont(font1)
    menuwhite = loadimage_strict("GFX\menu\menuwhite.jpg")
    menublack = loadimage_strict("GFX\menu\menublack.jpg")
    maskimage(menublack, $FF, $FF, $00)
    launcherimg = loadimage_strict("GFX\menu\launcher.jpg")
    maskimage(launcherimg, $D4, $D4, $EA)
    local2 = aaloadfont("GFX\font\cour\Courier New Rus.ttf", 13.0, $00, $00, $00, $02)
    For local1 = $00 To $03 Step $01
        arrowimg(local1) = loadimage_strict("GFX\menu\arrow.png")
        rotateimage(arrowimg(local1), (Float ($5A * local1)))
        handleimage(arrowimg(local1), $00, $00)
    Next
    For local1 = $01 To totalgfxmodes Step $01
        local3 = $00
        For local4 = $00 To (totalgfxmodes - $01) Step $01
            If (((gfxmodewidths(local4) = gfxmodewidth(local1)) And (gfxmodeheights(local4) = gfxmodeheight(local1))) <> 0) Then
                local3 = $01
                Exit
            EndIf
        Next
        If (local3 = $00) Then
            If (((gfxmodewidth(local1) > $2000) Or (gfxmodeheight(local1) > $2000)) = $00) Then
                If (((graphicwidth = gfxmodewidth(local1)) And (graphicheight = gfxmodeheight(local1))) <> 0) Then
                    selectedgfxmode = gfxmodes
                EndIf
                gfxmodewidths(gfxmodes) = gfxmodewidth(local1)
                gfxmodeheights(gfxmodes) = gfxmodeheight(local1)
                gfxmodes = (gfxmodes + $01)
            EndIf
        EndIf
    Next
    blinkmeterimg = loadimage_strict("GFX\blinkmeter.jpg")
    apptitle("SCP - Containment Breach Multiplayer Mod Launcher", "")
    local5 = loadimage_strict("GFX\multiplayer\menu\discord.png")
    local6 = loadimage_strict("GFX\multiplayer\menu\patreon.png")
    local7 = loadimage_strict("GFX\multiplayer\menu\reddit.png")
    local8 = loadimage_strict("GFX\multiplayer\menu\youtube.png")
    local9 = loadimage_strict("GFX\multiplayer\menu\steam.png")
    resizeimage(local5, 25.0, 25.0)
    resizeimage(local6, 25.0, 25.0)
    resizeimage(local7, 25.0, 25.0)
    resizeimage(local8, 25.0, 25.0)
    resizeimage(local9, 25.0, 25.0)
    discord_api_setstate("In main menu", $00)
    local10 = $28
    local11 = $CD
    Repeat
        color($00, $00, $00)
        rect($00, $00, launcherwidth, launcherheight, $01)
        mousehit1 = mousehit($01)
        color($FF, $FF, $FF)
        drawimage(launcherimg, $00, $00, $00)
        aatext($14, $AF, "Resolution:", $00, $00, 1.0)
        local10 = $28
        local11 = $CD
        local14 = $00
        For local1 = $00 To (gfxmodes - $01) Step $01
            If (((gfxmodeexists(gfxmodewidths(local1), gfxmodeheights(local1), $10) And bit16mode) Or (bit16mode = $00)) <> 0) Then
                color($00, $00, $00)
                If (selectedgfxmode = local1) Then
                    rect((local10 - $01), (local11 - $01), $64, $14, $00)
                EndIf
                aatext(local10, local11, (((Str gfxmodewidths(local1)) + "x") + (Str gfxmodeheights(local1))), $00, $00, 1.0)
                If (mouseon((local10 - $01), (local11 - $01), $64, $14) <> 0) Then
                    color($64, $64, $64)
                    rect((local10 - $01), (local11 - $01), $64, $14, $00)
                    If (mousehit1 <> 0) Then
                        selectedgfxmode = local1
                    EndIf
                EndIf
                local11 = (local11 + $14)
                local14 = $01
                If (local11 >= (((launcherheight - $50) - $104) + $B9)) Then
                    local11 = $CD
                    local10 = (local10 + $64)
                EndIf
            EndIf
        Next
        If (local14 = $00) Then
            color($00, $00, $00)
            aatext((local10 - $12), local11, "No graphics modes found.", $00, $00, 1.0)
            local11 = (local11 + $14)
            aatext((local10 - $12), local11, "Install the necessary components for the game to work", $00, $00, 1.0)
            local11 = (local11 + $14)
            aatext((local10 - $12), local11, "or make sure that the 16-bit mode is turned off.", $00, $00, 1.0)
            local11 = (local11 + $14)
        EndIf
        color($FF, $FF, $FF)
        local10 = $1E
        local11 = $171
        local11 = (local11 - $27)
        rect((local10 - $0A), (local11 + $14), $12C, (Int ((14.44444 * (Float (countgfxdrivers() + $01))) + 11.0)), $01)
        local11 = (local11 + $1B)
        If (((selectedgfxdriver < $00) Or (selectedgfxdriver > countgfxdrivers())) <> 0) Then
            selectedgfxdriver = $01
        EndIf
        aasetfont(local2)
        color($00, $00, $00)
        If (selectedgfxdriver = $00) Then
            rect((local10 - $01), (local11 - $01), $D1, $0E, $00)
        EndIf
        limittext("Default (Recommended)", local10, local11, $D1, $01, $00)
        If (mouseon((local10 - $01), (local11 - $01), $D1, $0E) <> 0) Then
            color($64, $64, $64)
            rect((local10 - $01), (local11 - $01), $D1, $0E, $00)
            If (mousehit1 <> 0) Then
                selectedgfxdriver = $00
            EndIf
        EndIf
        local11 = (Int ((Float local11) + 14.44444))
        For local1 = $01 To countgfxdrivers() Step $01
            aasetfont(local2)
            color($00, $00, $00)
            If (selectedgfxdriver = local1) Then
                rect((local10 - $01), (local11 - $01), $D1, $0E, $00)
            EndIf
            limittext(gfxdrivername(local1), local10, local11, $D1, $01, $00)
            If (mouseon((local10 - $01), (local11 - $01), $D1, $0E) <> 0) Then
                color($64, $64, $64)
                rect((local10 - $01), (local11 - $01), $D1, $0E, $00)
                If (mousehit1 <> 0) Then
                    selectedgfxdriver = local1
                EndIf
            EndIf
            local11 = (Int ((Float local11) + 14.44444))
        Next
        local11 = (local11 + $32)
        local12 = (local10 - $0A)
        local13 = (local11 - $1E)
        If (mouseon(local12, local13, $19, $19) <> 0) Then
            If (26.25 <> (Float imagewidth(local5))) Then
                local5 = reloadimage("GFX\multiplayer\menu\discord.png", local5, $1A, $1A)
            EndIf
            If (mousehit1 <> 0) Then
                sendstatisticrequest($0D)
                execfile("https://discord.com/invite/zSDXQTc")
            EndIf
        ElseIf (25.0 <> (Float imagewidth(local5))) Then
            local5 = reloadimage("GFX\multiplayer\menu\discord.png", local5, $19, $19)
        EndIf
        drawimage(local5, local12, local13, $00)
        local12 = (Int ((Float local12) + (1.0 / 0.03)))
        If (mouseon(local12, local13, $19, $19) <> 0) Then
            If (26.25 <> (Float imagewidth(local7))) Then
                local7 = reloadimage("GFX\multiplayer\menu\reddit.png", local7, $1A, $1A)
            EndIf
            If (mousehit1 <> 0) Then
                sendstatisticrequest($0F)
                execfile("https://www.reddit.com/r/scpcbmultiplayer")
            EndIf
        ElseIf (25.0 <> (Float imagewidth(local7))) Then
            local7 = reloadimage("GFX\multiplayer\menu\reddit.png", local7, $19, $19)
        EndIf
        drawimage(local7, local12, local13, $00)
        local12 = (Int ((Float local12) + (1.0 / 0.03)))
        If (mouseon(local12, local13, $19, $19) <> 0) Then
            If (26.25 <> (Float imagewidth(local8))) Then
                local8 = reloadimage("GFX\multiplayer\menu\youtube.png", local8, $1A, $1A)
            EndIf
            If (mousehit1 <> 0) Then
                sendstatisticrequest($0E)
                execfile("https://www.youtube.com/watch?v=1KKxajC2lMw")
            EndIf
        ElseIf (25.0 <> (Float imagewidth(local8))) Then
            local8 = reloadimage("GFX\multiplayer\menu\youtube.png", local8, $19, $19)
        EndIf
        drawimage(local8, local12, local13, $00)
        local12 = (Int ((Float local12) + (1.0 / 0.03)))
        If (mouseon(local12, local13, $19, $19) <> 0) Then
            If (26.25 <> (Float imagewidth(local9))) Then
                local9 = reloadimage("GFX\multiplayer\menu\steam.png", local9, $1A, $1A)
            EndIf
            If (mousehit1 <> 0) Then
                execfile("https://store.steampowered.com/app/1782380")
            EndIf
        ElseIf (25.0 <> (Float imagewidth(local9))) Then
            local9 = reloadimage("GFX\multiplayer\menu\steam.png", local9, $19, $19)
        EndIf
        drawimage(local9, local12, local13, $00)
        aasetfont(font1)
        fullscreen = drawtick($1C7, $CA, fullscreen, borderlesswindowed)
        borderlesswindowed = drawtick($1C7, $F0, borderlesswindowed, $00)
        local15 = $00
        If ((borderlesswindowed Or (fullscreen = $00)) <> 0) Then
            local15 = $01
        EndIf
        bit16mode = drawtick($1C7, $116, bit16mode, local15)
        launcherenabled = drawtick($1C7, $134, launcherenabled, $00)
        If (borderlesswindowed <> 0) Then
            color($FF, $00, $00)
            fullscreen = $00
        Else
            color($FF, $FF, $FF)
        EndIf
        aatext($1E5, $CC, "Fullscreen", $00, $00, 1.0)
        color($FF, $FF, $FF)
        aatext($1E5, $EA, "Borderless", $00, $00, 1.0)
        aatext($1E5, $FE, "windowed mode", $00, $00, 1.0)
        If ((borderlesswindowed Or (fullscreen = $00)) <> 0) Then
            color($FF, $00, $00)
            bit16mode = $00
        Else
            color($FF, $FF, $FF)
        EndIf
        aatext($1E5, $118, "16 Bit", $00, $00, 1.0)
        color($FF, $FF, $FF)
        aatext($1E5, $136, "Use launcher", $00, $00, 1.0)
        If (borderlesswindowed = $00) Then
            If (fullscreen <> 0) Then
                aatext($177, $15B, ("Current Resolution: " + (((((Str gfxmodewidths(selectedgfxmode)) + "x") + (Str gfxmodeheights(selectedgfxmode))) + ",") + (Str (((bit16mode = $00) Shl $04) + $10)))), $00, $00, 1.0)
            Else
                aatext($177, $15B, ("Current Resolution: " + ((((Str gfxmodewidths(selectedgfxmode)) + "x") + (Str gfxmodeheights(selectedgfxmode))) + ",32")), $00, $00, 1.0)
            EndIf
        Else
            aatext($177, $15B, (((("Current Resolution: " + (Str gfxmodewidths(selectedgfxmode))) + "x") + (Str gfxmodeheights(selectedgfxmode))) + ",32"), $00, $00, 1.0)
            If (gfxmodewidths(selectedgfxmode) < g_viewport_width) Then
                aatext($177, $16F, "(upscaled to", $00, $00, 1.0)
                aatext($177, $183, ((((Str g_viewport_width) + "x") + (Str g_viewport_height)) + ",32)"), $00, $00, 1.0)
            ElseIf (gfxmodewidths(selectedgfxmode) > g_viewport_width) Then
                aatext($177, $16F, "(downscaled to", $00, $00, 1.0)
                aatext($177, $183, ((((Str g_viewport_width) + "x") + (Str g_viewport_height)) + ",32)"), $00, $00, 1.0)
            EndIf
        EndIf
        color($FF, $FF, $FF)
        If (local14 <> 0) Then
            If (drawbutton(((launcherwidth - $1E) - $5A), ((launcherheight - $32) - $37), $64, $1E, "LAUNCH", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                sendstatisticrequest($06)
                graphicwidth = gfxmodewidths(selectedgfxmode)
                graphicheight = gfxmodeheights(selectedgfxmode)
                realgraphicwidth = graphicwidth
                realgraphicheight = graphicheight
                Exit
            EndIf
        EndIf
        If (drawbutton(((launcherwidth - $1E) - $5A), (launcherheight - $32), $64, $1E, "EXIT", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            sendstatisticrequest($07)
            closegame()
        EndIf
        flip($01)
        If (api_iswindowvisible(screen_hwnd) = $00) Then
            api_showwindow(screen_hwnd, $01)
        EndIf
        delay($14)
        discord_api_update()
        graphicwidth = $280
        graphicheight = $1E0
        realgraphicwidth = graphicwidth
        realgraphicheight = graphicheight
    Forever
    putinivalue(optionfile, "options", "width", (Str gfxmodewidths(selectedgfxmode)))
    putinivalue(optionfile, "options", "height", (Str gfxmodeheights(selectedgfxmode)))
    If (fullscreen <> 0) Then
        putinivalue(optionfile, "options", "fullscreen", "true")
    Else
        putinivalue(optionfile, "options", "fullscreen", "false")
    EndIf
    If (launcherenabled <> 0) Then
        putinivalue(optionfile, "launcher", "launcher enabled", "true")
    Else
        putinivalue(optionfile, "launcher", "launcher enabled", "false")
    EndIf
    If (borderlesswindowed <> 0) Then
        putinivalue(optionfile, "options", "borderless windowed", "true")
    Else
        putinivalue(optionfile, "options", "borderless windowed", "false")
    EndIf
    If (bit16mode <> 0) Then
        putinivalue(optionfile, "options", "16bit", "true")
    Else
        putinivalue(optionfile, "options", "16bit", "false")
    EndIf
    putinivalue(optionfile, "options", "gfx driver new", (Str selectedgfxdriver))
    If (local16 <> 0) Then
        putinivalue(optionfile, "options", "check for updates", "true")
    Else
        putinivalue(optionfile, "options", "check for updates", "false")
    EndIf
    freeimage(local7)
    freeimage(local5)
    freeimage(local6)
    freeimage(local8)
    freeimage(local9)
    aafreefont(font1)
    aafreefont(local2)
    aatextenable = local0
    Return $00
End Function
