Function updatelauncher%()
    Local local0%
    Local local1%
    Local local2%
    Local local3$[4]
    Local local4%[4]
    Local local5%
    Local local6%[24]
    Local local7%[24]
    Local local8%[24]
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%[4]
    Local local17%[4]
    Local local18%[4]
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    Local local26$
    Local local27%
    Local local28%
    Local local29$
    menuscale = 1.0
    createwindow($280, $1E0, $00, $02, "SCP - Containment Breach Multiplayer Mod ")
    fonts[$00] = createfont("GFX\font\cour\Courier New.ttf", $12, $00, $00, $00)
    initstaticassets($01)
    local0 = win\Field4
    local1 = win\Field5
    local2 = loadimage_strict("GFX\menu\launcher.jpg")
    local3[$00] = "https://discord.com/invite/ge92ND7J5s"
    local3[$01] = "https://www.patreon.com/scpcbmultiplayermod"
    local3[$02] = "https://www.reddit.com/r/scpcbmultiplayer"
    local3[$03] = "https://www.youtube.com/watch?v=1KKxajC2lMw"
    local3[$04] = "https://store.steampowered.com/app/1782380"
    local4[$00] = $0D
    local4[$01] = $0C
    local4[$02] = $0F
    local4[$03] = $0E
    local5 = $00
    local9 = countgfxdrivers()
    gfxmodes = $00
    local10 = $28
    local11 = $CD
    local12 = $00
    For local13 = $01 To totalgfxmodes Step $01
        local14 = $00
        For local15 = $00 To (gfxmodes - $01) Step $01
            If (((gfxmodewidths(local15) = gfxmodewidth(local13)) And (gfxmodeheights(local15) = gfxmodeheight(local13))) <> 0) Then
                local14 = $01
                Exit
            EndIf
        Next
        If (local14 = $00) Then
            If (((gfxmodewidth(local13) > $2000) Or (gfxmodeheight(local13) > $2000)) = $00) Then
                gfxmodewidths(gfxmodes) = gfxmodewidth(local13)
                gfxmodeheights(gfxmodes) = gfxmodeheight(local13)
                If (((graphicwidth = gfxmodewidth(local13)) And (graphicheight = gfxmodeheight(local13))) <> 0) Then
                    selectedgfxmode = gfxmodes
                EndIf
                If (gfxmodeexists(gfxmodewidths(gfxmodes), gfxmodeheights(gfxmodes), $20) <> 0) Then
                    local7[local5] = local10
                    local8[local5] = local11
                    local6[local5] = gfxmodes
                    local5 = (local5 + $01)
                    local12 = $01
                    local11 = (local11 + $14)
                    If (local11 >= $145) Then
                        local11 = $CD
                        local10 = (local10 + $64)
                    EndIf
                EndIf
                gfxmodes = (gfxmodes + $01)
            EndIf
        EndIf
    Next
    local16[$00] = loadimage_strict("GFX\multiplayer\menu\discord.png")
    local16[$01] = loadimage_strict("GFX\multiplayer\menu\patreon.png")
    local16[$02] = loadimage_strict("GFX\multiplayer\menu\reddit.png")
    local16[$03] = loadimage_strict("GFX\multiplayer\menu\youtube.png")
    local16[$04] = loadimage_strict("GFX\multiplayer\menu\steam.png")
    For local13 = $00 To $04 Step $01
        local17[local13] = copyimage(local16[local13])
        resizeimage(local16[local13], 25.0, 25.0)
        resizeimage(local17[local13], 28.0, 28.0)
    Next
    local19 = $28
    local20 = $CD
    discord_api_update()
    Repeat
        mouseposx = mousex()
        mouseposy = mousey()
        mousehit1 = mousehit($01)
        drawimage(local2, $00, $00, $00)
        text($14, $AF, "Resolution:", $00, $00)
        local19 = $28
        local20 = $CD
        local12 = $00
        For local13 = $00 To (local5 - $01) Step $01
            local12 = $01
            local23 = local7[local13]
            local24 = local8[local13]
            local25 = local6[local13]
            setcolorex($00, $00, $00)
            If (selectedgfxmode = local25) Then
                rect((local23 - $01), (local24 - $01), $64, $14, $00)
            EndIf
            local26 = (((Str gfxmodewidths(local25)) + "x") + (Str gfxmodeheights(local25)))
            text(local23, (local24 + $0A), local26, $00, $01)
            If (mouseon((local23 - $01), (local24 - $01), $64, $14) <> 0) Then
                setcolorex($64, $64, $64)
                rect((local23 - $01), (local24 - $01), $64, $14, $00)
                If (mousehit1 <> 0) Then
                    selectedgfxmode = local25
                EndIf
            EndIf
        Next
        If (local12 = $00) Then
            setcolorex($00, $00, $00)
            text((local19 - $12), local20, "No graphics modes found.", $00, $00)
            local20 = (local20 + $14)
            text((local19 - $12), local20, "Install the necessary components for the game to work", $00, $00)
            local20 = (local20 + $14)
            text((local19 - $12), local20, "or make sure that the 16-bit mode is turned off.", $00, $00)
            local20 = (local20 + $14)
        EndIf
        setcolorex($FF, $FF, $FF)
        local19 = $1E
        local20 = $171
        local20 = (local20 - $27)
        rect((local19 - $0A), (local20 + $14), $12C, (((local9 + $01) * $0E) + $0B), $01)
        local20 = (local20 + $1B)
        If (((selectedgfxdriver < $00) Or (selectedgfxdriver > local9)) <> 0) Then
            selectedgfxdriver = $01
        EndIf
        setcolorex($00, $00, $00)
        If (selectedgfxdriver = $00) Then
            rect((local19 - $01), (local20 - $01), $11A, $0E, $00)
        EndIf
        text(local19, local20, "Default (Recommended)", $00, $00)
        If (mouseon((local19 - $01), (local20 - $01), $11A, $0E) <> 0) Then
            setcolorex($64, $64, $64)
            rect((local19 - $01), (local20 - $01), $11A, $0E, $00)
            If (mousehit1 <> 0) Then
                selectedgfxdriver = $00
            EndIf
        EndIf
        local20 = (local20 + $0E)
        For local13 = $01 To local9 Step $01
            setcolorex($00, $00, $00)
            If (selectedgfxdriver = local13) Then
                rect((local19 - $01), (local20 - $01), $11A, $0E, $00)
            EndIf
            text(local19, local20, gfxdrivername(local13), $00, $00)
            If (mouseon((local19 - $01), (local20 - $01), $11A, $0E) <> 0) Then
                setcolorex($64, $64, $64)
                rect((local19 - $01), (local20 - $01), $11A, $0E, $00)
                If (mousehit1 <> 0) Then
                    selectedgfxdriver = local13
                EndIf
            EndIf
            local20 = (local20 + $0E)
        Next
        local20 = (local20 + $32)
        local21 = (local19 - $0A)
        local22 = (local20 - $1E)
        For local13 = $00 To $04 Step $01
            local21 = (local21 + $21)
            If (mouseon(local21, local22, $1C, $1C) <> 0) Then
                local18[local13] = $01
                If (mousehit1 <> 0) Then
                    If (local4[local13] <> $00) Then
                        sendstatisticrequest(local4[local13])
                    EndIf
                    execfile(local3[local13])
                EndIf
            Else
                local18[local13] = $00
            EndIf
            local27 = local16[local13]
            If (local18[local13] <> 0) Then
                local27 = local17[local13]
            EndIf
            drawimage(local27, local21, local22, $00)
        Next
        shouldplaystartupvids = drawtick($1C7, $C8, shouldplaystartupvids, $00)
        fullscreen = drawtick($1C7, $E6, fullscreen, borderlesswindowed)
        borderlesswindowed = drawtick($1C7, $104, borderlesswindowed, $00)
        If ((borderlesswindowed Or (fullscreen = $00)) <> 0) Then
            local28 = $01
        EndIf
        launcherenabled = drawtick($1C7, $122, launcherenabled, $00)
        If (borderlesswindowed <> 0) Then
            setcolorex($FF, $00, $00)
            fullscreen = $00
        Else
            setcolorex($FF, $FF, $FF)
        EndIf
        text($1E5, $EB, "Fullscreen", $00, $00)
        setcolorex($FF, $FF, $FF)
        text($1E5, $C8, "Play startup", $00, $00)
        text($1E5, $D7, "videos", $00, $00)
        text($1E5, $104, "Borderless", $00, $00)
        text($1E5, $113, "windowed mode", $00, $00)
        text($1E5, $127, "Use launcher", $00, $00)
        text($145, $15B, "Current Resolution:", $00, $00)
        text($145, $16F, (((Str gfxmodewidths(selectedgfxmode)) + "x") + (Str gfxmodeheights(selectedgfxmode))), $00, $00)
        local29 = ""
        If (gfxmodewidths(selectedgfxmode) < local0) Then
            local29 = "(Upscaled to)"
        ElseIf (gfxmodewidths(selectedgfxmode) > local0) Then
            local29 = "(Downscaled to)"
        EndIf
        If (local29 <> "") Then
            text($145, $181, local29, $00, $00)
            text($145, $190, ((((Str local0) + "x") + (Str local1)) + ")"), $00, $00)
        EndIf
        If (local12 <> 0) Then
            If (drawbutton($208, $177, $64, $1E, "LAUNCH", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                sendstatisticrequest($06)
                graphicwidth = gfxmodewidths(selectedgfxmode)
                graphicheight = gfxmodeheights(selectedgfxmode)
                win\Field2 = graphicwidth
                win\Field3 = graphicheight
                Exit
            EndIf
        EndIf
        If (drawbutton($208, $1AE, $64, $1E, "EXIT", $00, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
            sendstatisticrequest($07)
            destroywindow()
        EndIf
        flip($01)
        delay($64)
    Forever
    putinivalue("options.ini", "options", "width", (Str gfxmodewidths(selectedgfxmode)))
    putinivalue("options.ini", "options", "height", (Str gfxmodeheights(selectedgfxmode)))
    putinivalue("options.ini", "options", "fullscreen", (Str fullscreen))
    putinivalue("options.ini", "options", "play startup video", (Str shouldplaystartupvids))
    putinivalue("options.ini", "launcher", "launcher enabled", (Str launcherenabled))
    putinivalue("options.ini", "options", "borderless windowed", (Str borderlesswindowed))
    putinivalue("options.ini", "options", "gfx driver new", (Str selectedgfxdriver))
    For local13 = $00 To $04 Step $01
        If (local16[local13] <> $00) Then
            freeimage(local16[local13])
        EndIf
        If (local17[local13] <> $00) Then
            freeimage(local17[local13])
        EndIf
    Next
    freefontex(fonts[$00])
    freeimage(local2)
    Return $00
End Function
