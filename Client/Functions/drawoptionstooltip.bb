Function drawoptionstooltip%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5#, arg6%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6$
    Local local7$
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    local0 = ((6.0 * menuscale) + (Float arg0))
    local1 = ((6.0 * menuscale) + (Float arg1))
    local2 = ((Float arg2) - (12.0 * menuscale))
    local3 = ((Float arg3) - (12.0 * menuscale))
    local4 = $00
    local5 = $00
    local6 = ""
    local7 = ""
    local8 = $00
    local9 = $00
    local10 = $00
    local11 = $00
    local12 = $00
    aasetfont(font1)
    color($FF, $FF, $FF)
    Select lower(arg4)
        Case "cmqu"
            local6 = "Affects the quality of the picture in surveillance cameras. Strongly affects performance. It is recommended to set a low value"
        Case "cam"
            local6 = "The time after which the surveillance camera will be updated. Increases productivity if speed is slow."
        Case "gu"
            local6 = "Disable gamma update. Gives good performance, but gets darker in the game."
        Case "cant"
            local6 = "You will not be able to load the save when players count 1>"
        Case "cant2"
            local6 = "You will not be able to load the save in non-redirect server"
        Case "srv"
            local6 = "Local servers are searched only on port 50021"
        Case "p2p"
            local6 = "If you have Memory Access Violation after 100% or infinite load (99%) then use the server.exe"
        Case "nocheat"
            local6 = "No cheat disable opening the console, as a result, no one can use cheats"
            local7 = "This option cannot be changed in-game."
            local8 = $FF
        Case "hostserver"
            local6 = "Better use server.exe in the dedicated server folder"
        Case "voice"
            local6 = "This button enables voice chat on the server."
            local7 = "This option cannot be changed in-game."
            local8 = $FF
        Case "bugs"
            local6 = "If you turn the intro, then you will expect some glitchs and crash"
            local7 = "Please don't turn the intro!"
            local8 = $FF
        Case "bump"
            local6 = (((chr($22) + "Bump mapping") + chr($22)) + " is used to simulate bumps and dents by distorting the lightmaps.")
            local7 = "This option cannot be changed in-game."
            local8 = $FF
        Case "vsync"
            local6 = (((chr($22) + "Vertical sync") + chr($22)) + " waits for the display to finish its current refresh cycle before calculating the next frame, preventing issues such as ")
            local6 = (local6 + "screen tearing. This ties the game's frame rate to your display's refresh rate and may cause some input lag.")
        Case "antialias"
            local6 = (((chr($22) + "Anti-Aliasing") + chr($22)) + " is used to smooth the rendered image before displaying in order to reduce aliasing around the edges of models.")
            local7 = "This option only takes effect in fullscreen."
            local8 = $FF
        Case "roomlights"
            local6 = "Toggles the artificial lens flare effect generated over specific light sources."
        Case "gamma"
            local6 = (((chr($22) + "Gamma correction") + chr($22)) + " is used to achieve a good brightness factor to balance out your display's gamma if the game appears either too dark or bright. ")
            local6 = (local6 + "Setting it too high or low can cause the graphics to look less detailed.")
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (("Current value: " + (Str (Int (arg5 * 100.0)))) + "% (default is 100%)")
        Case "texquality"
            local6 = (((chr($22) + "Texture LOD Bias") + chr($22)) + " affects the distance at which texture detail will change to prevent aliasing. Change this option if textures flicker or look too blurry.")
        Case "particleamount"
            local6 = "Determines the amount of particles that can be rendered per tick."
            Select arg5
                Case 0.0
                    local8 = $FF
                    local7 = "Only smoke emitters will produce particles."
                Case 1.0
                    local8 = $FF
                    local9 = $FF
                    local7 = "Only a few particles will be rendered per tick."
                Case 2.0
                    local9 = $FF
                    local7 = "All particles are rendered."
            End Select
        Case "vram"
            local6 = "Textures that are stored in the Video-RAM will load faster, but this also has negative effects on the texture quality as well."
            local7 = "This option cannot be changed in-game."
            local8 = $FF
        Case "musicvol"
            local6 = "Adjusts the volume of background music. Sliding the bar fully to the left will mute all music."
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (("Current value: " + (Str (Int (arg5 * 100.0)))) + "% (default is 50%)")
        Case "soundvol"
            local6 = "Adjusts the volume of sound effects. Sliding the bar fully to the left will mute all sounds."
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (("Current value: " + (Str (Int (arg5 * 100.0)))) + "% (default is 100%)")
        Case "sfxautorelease"
            local6 = (((chr($22) + "Sound auto-release") + chr($22)) + " will free a sound from memory if it not used after 5 seconds. Prevents memory allocation issues.")
            local8 = $FF
            local7 = "This option cannot be changed in-game."
        Case "usertrack"
            local6 = ((("Toggles the ability to play custom tracks over channel 1 of the radio. These tracks are loaded from the " + chr($22)) + "SFX\Radio\UserTracks\") + chr($22))
            local6 = (((((local6 + " directory. Press ") + chr($22)) + "1") + chr($22)) + " when the radio is selected to change track.")
            local8 = $FF
            local7 = "This option cannot be changed in-game."
        Case "usertrackmode"
            local6 = (((((((("Sets the playing mode for the custom tracks. " + chr($22)) + "Repeat") + chr($22)) + " plays every file in alphabetical order. ") + chr($22)) + "Random") + chr($22)) + " chooses the ")
            local6 = (local6 + "next track at random.")
            local8 = $FF
            local9 = $FF
            local7 = "Note that the random mode does not prevent previously played tracks from repeating."
        Case "usertrackscan"
            local6 = "Re-checks the user tracks directory for any new or removed sound files."
        Case "mousesensitivity"
            local6 = "Adjusts the speed of the mouse pointer."
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (("Current value: " + (Str (Int ((0.5 + arg5) * 100.0)))) + "% (default is 50%)")
        Case "mouseinvert"
            local6 = (((chr($22) + "Invert mouse Y-axis") + chr($22)) + " is self-explanatory.")
        Case "mousesmoothing"
            local6 = "Adjusts the amount of smoothing of the mouse pointer."
            local8 = $FF
            local9 = $FF
            local10 = $FF
            local7 = (("Current value: " + (Str (Int (arg5 * 100.0)))) + "% (default is 100%)")
        Case "controls"
            local6 = "Configure the in-game control scheme."
        Case "hud"
            local6 = "Display the blink and stamina meters."
        Case "consoleenable"
            local6 = (("Toggles the use of the developer console. Can be used in-game by pressing " + keyname(key_console)) + ".")
        Case "consoleerror"
            local6 = (((chr($22) + "Open console on error") + chr($22)) + " is self-explanatory.")
        Case "achpopup"
            local6 = "Displays a pop-up notification when an achievement is unlocked."
        Case "showfps"
            local6 = "Displays the frames per second counter at the top left-hand corner."
        Case "showscpviewmodel"
            local6 = "Shows the SCP Viewmodels when enabled."
        Case "framelimit"
            local6 = "Limits the frame rate that the game can run at to a desired value."
            If (((0.0 < arg5) And (60.0 > arg5)) <> 0) Then
                local8 = $FF
                local9 = $FF
                local7 = "Usually, 60 FPS or higher is preferred. If you are noticing excessive stuttering at this setting, try lowering it to make your framerate more consistent."
            EndIf
        Case "antialiastext"
            local6 = (((chr($22) + "Antialiased text") + chr($22)) + " smooths out the text before displaying. Makes text easier to read at high resolutions.")
    End Select
    local4 = getlineamount(local6, (Int local2), (Int local3), 1.0)
    If (local11 <> 0) Then
        local12 = (Int (210.0 * menuscale))
    EndIf
    If (local7 = "") Then
        drawframe(arg0, arg1, arg2, (Int ((((Float ($0A + local4)) * menuscale) + (Float (aastringheight(local6) * local4))) + (Float local12))), $00, $00)
    Else
        local5 = getlineamount(local7, (Int local2), (Int local3), 1.0)
        drawframe(arg0, arg1, arg2, (Int ((((((Float ($0A + local4)) * menuscale) + (Float (aastringheight(local6) * local4))) + (Float (aastringheight(local7) * local5))) + ((Float ($0A + local5)) * menuscale)) + (Float local12))), $00, $00)
    EndIf
    rowtext(local6, local0, local1, local2, local3, $00, 1.0, $00)
    If (local7 <> "") Then
        color(local8, local9, local10)
        rowtext(local7, local0, ((local1 + (Float (aastringheight(local6) * local4))) + ((Float ($05 + local4)) * menuscale)), local2, local3, $00, 1.0, $00)
    EndIf
    If (local11 <> 0) Then
        midhandle(menu_testimg)
        If (local7 = "") Then
            drawimage(menu_testimg, ((arg2 Sar $01) + arg0), (Int (((100.0 * menuscale) + (Float arg1)) + (((Float ($0A + local4)) * menuscale) + (Float (aastringheight(local6) * local4))))), $00)
        Else
            drawimage(menu_testimg, ((arg2 Sar $01) + arg0), (Int ((((((Float ($0A + local4)) * menuscale) + (Float (aastringheight(local6) * local4))) + (Float (aastringheight(local7) * local5))) + ((Float ($0A + local5)) * menuscale)) + ((100.0 * menuscale) + (Float arg1)))), $00)
        EndIf
    EndIf
    Return $00
End Function
