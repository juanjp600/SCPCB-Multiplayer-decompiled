Function EntryPoint%()
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7$
    Local local8%
    Local local9%
    Local local10.servers
    totalgfxmodes = countgfxmodes3d()
    Dim gfxmodewidths%(totalgfxmodes)
    Dim gfxmodeheights%(totalgfxmodes)
    win = (New windowcontext)
    checkdefaultdirectories()
    setupwindow()
    checkoptionsini()
    Dim keyname$($D3)
    keyname($01) = "Esc"
    For local0 = $02 To $0B Step $01
        keyname(local0) = (Str (local0 - $01))
    Next
    keyname($0C) = "-"
    keyname($0D) = "="
    keyname($0E) = "Backspace"
    keyname($0F) = "TAB"
    keyname($10) = "Q"
    keyname($11) = "W"
    keyname($12) = "E"
    keyname($13) = "R"
    keyname($14) = "T"
    keyname($15) = "Y"
    keyname($16) = "U"
    keyname($17) = "I"
    keyname($18) = "O"
    keyname($19) = "P"
    keyname($1A) = "["
    keyname($1B) = "]"
    keyname($1C) = "Enter"
    keyname($1D) = "Left Ctrl"
    keyname($1E) = "A"
    keyname($1F) = "S"
    keyname($20) = "D"
    keyname($21) = "F"
    keyname($22) = "G"
    keyname($23) = "H"
    keyname($24) = "J"
    keyname($25) = "K"
    keyname($26) = "L"
    keyname($27) = ";"
    keyname($28) = "'"
    keyname($2A) = "Left Shift"
    keyname($2B) = "\"
    keyname($2C) = "Z"
    keyname($2D) = "X"
    keyname($2E) = "C"
    keyname($2F) = "V"
    keyname($30) = "B"
    keyname($31) = "N"
    keyname($32) = "M"
    keyname($33) = ","
    keyname($34) = "."
    keyname($36) = "Right Shift"
    keyname($38) = "Left Alt"
    keyname($39) = "Space"
    keyname($3A) = "Caps Lock"
    keyname($3B) = "F1"
    keyname($3C) = "F2"
    keyname($3D) = "F3"
    keyname($3E) = "F4"
    keyname($3F) = "F5"
    keyname($40) = "F6"
    keyname($41) = "F7"
    keyname($42) = "F8"
    keyname($43) = "F9"
    keyname($44) = "F10"
    keyname($9D) = "Right Control"
    keyname($B8) = "Right Alt"
    keyname($C8) = "Up"
    keyname($CB) = "Left"
    keyname($CD) = "Right"
    keyname($D0) = "Down"
    Dim difficulties.difficulty($04)
    difficulties($00) = (New difficulty)
    difficulties($00)\Field0 = "Safe"
    difficulties($00)\Field1 = "The game can be saved any time. However, as in the case of SCP Objects, a Safe classification does not mean that handling it does not pose a threat."
    difficulties($00)\Field2 = $00
    difficulties($00)\Field3 = $00
    difficulties($00)\Field4 = $00
    difficulties($00)\Field5 = $00
    difficulties($00)\Field6 = $78
    difficulties($00)\Field7 = $96
    difficulties($00)\Field8 = $32
    difficulties($01) = (New difficulty)
    difficulties($01)\Field0 = "Euclid"
    difficulties($01)\Field1 = "In Euclid difficulty, saving is only allowed at specific locations marked by lit up computer screens. "
    difficulties($01)\Field1 = (difficulties($01)\Field1 + "Euclid-class objects are inherently unpredictable, so that reliable containment is not always possible.")
    difficulties($01)\Field2 = $00
    difficulties($01)\Field3 = $00
    difficulties($01)\Field4 = $02
    difficulties($01)\Field5 = $01
    difficulties($01)\Field6 = $C8
    difficulties($01)\Field7 = $C8
    difficulties($01)\Field8 = $00
    difficulties($02) = (New difficulty)
    difficulties($02)\Field0 = "Keter"
    difficulties($02)\Field1 = "Keter-class objects are considered the most dangerous ones in Foundation containment. "
    difficulties($02)\Field1 = (difficulties($02)\Field1 + "The same can be said for this difficulty level: the SCPs are more aggressive, and you have only one life - when you die, the game is over. ")
    difficulties($02)\Field2 = $01
    difficulties($02)\Field3 = $01
    difficulties($02)\Field4 = $01
    difficulties($02)\Field5 = $02
    difficulties($02)\Field6 = $C8
    difficulties($02)\Field7 = $00
    difficulties($02)\Field8 = $00
    difficulties($03) = (New difficulty)
    difficulties($03)\Field0 = "Esoteric"
    difficulties($03)\Field2 = $00
    difficulties($03)\Field3 = $01
    difficulties($03)\Field4 = $00
    difficulties($03)\Field9 = $01
    difficulties($03)\Field5 = $00
    difficulties($03)\Field6 = $FF
    difficulties($03)\Field7 = $FF
    difficulties($03)\Field8 = $FF
    selecteddifficulty = difficulties($00)
    local1 = ""
    If (filesize("fmod.dll") = $00) Then
        local1 = (((local1 + "fmod.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("zlibwapi.dll") = $00) Then
        local1 = (((local1 + "zlibwapi.dll") + chr($0D)) + chr($0A))
    EndIf
    If (($01 And (filesize("steam_api.dll") = $00)) <> 0) Then
        local1 = (((local1 + "steam_api.dll") + chr($0D)) + chr($0A))
    EndIf
    If (($01 And (filesize("BlitzSteamworks.dll") = $00)) <> 0) Then
        local1 = (((local1 + "BlitzSteamworks.dll") + chr($0D)) + chr($0A))
    EndIf
    If (len(local1) > $00) Then
        runtimeerror((((((((("The following DLLs were not found in the game directory or corrupted:" + chr($0D)) + chr($0A)) + chr($0D)) + chr($0A)) + local1) + chr($0D)) + chr($0A)) + "Please reinstall the game."))
    EndIf
    steam_api_init()
    multiplayer_version = (version($10300) + "R")
    statistic_stream = $00
    sendstatisticrequest($05)
    last_breach_type = $00
    ntf_model = $01
    guard_model = $02
    classd_model = $03
    scientist_model = $04
    model_173 = $05
    model_049 = $06
    haos_model = $07
    janitor_model = $08
    worker_model = $09
    model_939 = $0A
    model_106 = $0B
    model_966 = $0C
    model_zombie = $0D
    model_096 = $0E
    model_860 = $0F
    model_035 = $10
    model_clerk = $11
    model_wait = $12
    network_byte[$01] = $3D
    network_byte[$02] = $32
    network_byte[$03] = $54
    network_byte[$04] = $42
    network_byte[$05] = $53
    network_byte[$06] = $7F
    network_byte[$07] = $83
    menu_open_type = $00
    tab_menu_state = $00
    tab_menu_role_input = ""
    mp_instructionsdone = getiniint("options.ini", "audio", "mp instructions", $00)
    Dim keybuffer%($D3)
    Dim inventory.items($0B)
    holdinggun = $00
    key_reload = $13
    gunpivot_yside = $00
    gunpivot_xside = $00
    calibers = $00
    eqquipedgun = Null
    preveqquipedgun = Null
    lastpluginid = $00
    publics = (New pb)
    se_transient_stack_size = $200
    Dim se_transient_stack.se_value($00)
    Dim se_aux_transient_stack.se_value($00)
    se_arguments_stack_size = $20
    Dim se_arguments_stack.se_value($00)
    Dim se_aux_arguments_stack.se_value($00)
    se_return_value = (New se_value)
    Dim se_vf_a_inst.se_inst($00)
    Dim se_vf_a_func_ptr.se_funcptr($00)
    Dim se_vf_a_static.se_value($00)
    Dim se_vf_a_label.se_value($00)
    Dim se_loadtransientlimit%($00)
    Dim se_loadowner%($00)
    se_error_dump_line = $01
    se_operators[$00] = "++"
    se_operators[$01] = "--"
    se_operators[$02] = "**"
    se_operators[$03] = "<<"
    se_operators[$04] = ">>"
    se_operators[$05] = "<="
    se_operators[$06] = ">="
    se_operators[$07] = "=="
    se_operators[$08] = "!="
    se_operators[$09] = "~"
    se_operators[$0A] = "+"
    se_operators[$0B] = "-"
    se_operators[$0C] = "*"
    se_operators[$0D] = "/"
    se_operators[$0E] = "%"
    se_operators[$0F] = "<"
    se_operators[$10] = ">"
    se_operators[$11] = "&"
    se_operators[$12] = "^"
    se_operators[$13] = "|"
    se_operators[$14] = "="
    se_defineconst("null", $00, "", $01, Null)
    se_defineconst("true", $01, "1", $01, Null)
    se_defineconst("false", $01, "0", $01, Null)
    se_defineconst("pi", $02, "32807.0", $01, Null)
    se_defineconst("se_null", $01, "0", $01, Null)
    se_defineconst("se_int", $01, "1", $01, Null)
    se_defineconst("se_float", $01, "2", $01, Null)
    se_defineconst("se_string", $01, "3", $01, Null)
    se_defineconst("se_pointer", $01, "5", $01, Null)
    se_defineconst("se_array", $01, "7", $01, Null)
    bulletsbank = createbank($F4240)
    activebullets = $00
    server_list_stream = createudpstream("0", $00)
    networkserver = (New serverudp)
    networkserver\Field52 = (New serverudpoptions)
    playerintercom = (New intercomsystem)
    scp = (New scps)
    b_br = (New breach)
    rcon = (New rcn)
    spectate = (New spec)
    mpimg = (New multiplayerimages)
    g_model = (New models)
    m = (New memorystatus)
    host_server_button_text = "CREATE LOBBY"
    outscp = $01
    newyearindex = isanewyear()
    halloweenindex = isahalloween()
    selected_servers = $05
    microbyte = createbytestream($2000)
    pcm_encoder_channels = $01
    pcm_encoder_sample_rate = $BB80
    pcm_encoder_opus_type = $800
    default_frame_size = $3C0
    voice = (New v_m)
    voice_init()
    For local0 = $00 To $03 Step $01
        local2 = snd_format_create($01, $AC44, $10, $01)
        snd_out_open(local2)
    Next
    spectate\Field1 = $FFFFFFFF
    selectserver = $FFFFFFFF
    selectedword = $FFFFFFFF
    ready = ""
    jumpstate = -1.0
    spectate\Field2 = -25.0
    spectate\Field3 = 180.0
    spectate\Field4 = -25.0
    spectate\Field5 = 180.0
    playerintercom\Field2 = $4E20
    networkserver\Field38 = $01
    udp_network = udp_init()
    For local0 = $00 To $0A Step $01
        serverpages[local0] = (New serverpage)
        For local3 = $00 To $04 Step $01
            serverpages[local0]\Field0[local3] = $FFFFFFFF
        Next
    Next
    alinitialise($FFFFFFFF, 0.02, 1.0)
    fsound_init($AC44, $80, $00)
    echo_effect = alcreateeffect()
    If (echo_effect <> $00) Then
        aleffectseteaxreverbparam(echo_effect, 0.316, 0.25, 1.0, 0.017, 0.54, 0.653, 0.01, 0.01, 3.273, 0.1, 0.01, 0.1, 0.1, 1.0, 0.9, $01, 0.1, 0.1, 0.04, 1000.0, 20.0)
        aleffectsetpreset(echo_effect, "Dizzy")
    EndIf
    replacedatafile($01, "Data\1499chunks.ini", $01)
    replacedatafile($02, "Data\rooms.ini", $01)
    replacedatafile($03, "Data\NPCs.ini", $01)
    versionnumber = "1.3.11"
    compatiblenumber = "1.3.11"
    buttonsfx = loadsound_strict("SFX\Interact\Button.ogg")
    enablesfxrelease = getiniint("options.ini", "audio", "sfx release", $00)
    enablesfxrelease_prev = enablesfxrelease
    canopenconsole = getiniint("options.ini", "console", "enabled", $00)
    discordrichpresence = getiniint("options.ini", "options", "discord rich presence", $00)
    Dim arrowimg%($04)
    launcherenabled = (getiniint("options.ini", "launcher", "launcher enabled", $00) * (getiniint("options.ini", "launcher", "changeres", $00) = $00))
    graphicwidth = getiniint("options.ini", "options", "width", $00)
    graphicheight = getiniint("options.ini", "options", "height", $00)
    fullscreen = getiniint("options.ini", "options", "fullscreen", $00)
    selectedgfxdriver = (Int max((Float getiniint("options.ini", "options", "gfx driver new", $00)), 0.0))
    turnongamma = getiniint("options.ini", "options", "gammaoff", $00)
    camupdate = getiniint("options.ini", "options", "cameraupd", $02)
    camquality = getiniint("options.ini", "options", "cameraquality", $02)
    removedecals = getiniint("options.ini", "options", "removedecals", $00)
    removeparticles = getiniint("options.ini", "options", "removeparticles", $00)
    mainfov = min(max(getinifloat("options.ini", "options", "fov", 75.0), 75.0), 100.0)
    enablebullets = getiniint("options.ini", "options", "enablebullets", $01)
    shouldplaystartupvids = getiniint("options.ini", "options", "play startup video", $00)
    currentfov = mainfov
    If (((graphicwidth = $00) Or (graphicheight = $00)) <> 0) Then
        graphicwidth = $320
        graphicheight = $258
    EndIf
    lastfont = $FFFFFFFF
    showfps = getiniint("options.ini", "options", "show FPS", $00)
    showscpviewmodel = getiniint("options.ini", "options", "showscpviewmodel", $00)
    borderlesswindowed = getiniint("options.ini", "options", "borderless windowed", $00)
    consoleopening = $00
    enableroomlights = getiniint("options.ini", "options", "room lights enabled", $00)
    sfxvolume = getinifloat("options.ini", "audio", "sound volume", 0.0)
    se_init()
    getcameraquality($04)
    ws_backuporiginal()
    ws_checksubscribeditems($01)
    ws_loadscripts("workshop")
    If (getscripts() <> 0) Then
        public_inqueue($01, $01)
    EndIf
    buttonsfx = loadsound_strict("SFX\Interact\Button.ogg")
    discord_api_init()
    If (launcherenabled <> 0) Then
        aspectratioratio = 1.0
        updatelauncher()
        If (borderlesswindowed <> 0) Then
            createwindow(graphicwidth, graphicheight, $00, $05, "SCP - Containment Breach Multiplayer Mod ")
            aspectratioratio = (((Float graphicwidth) / (Float graphicheight)) / ((Float win\Field2) / (Float win\Field3)))
            fullscreen = $00
        Else
            aspectratioratio = 1.0
            If (fullscreen <> 0) Then
                createwindow(graphicwidth, graphicheight, $00, $01, "SCP - Containment Breach Multiplayer Mod ")
            Else
                createwindow(graphicwidth, graphicheight, $00, $02, "SCP - Containment Breach Multiplayer Mod ")
            EndIf
        EndIf
        Delete fonts[$00]
    Else
        For local0 = $01 To totalgfxmodes Step $01
            local4 = $00
            For local5 = $00 To (totalgfxmodes - $01) Step $01
                If (((gfxmodewidths(local5) = gfxmodewidth(local0)) And (gfxmodeheights(local5) = gfxmodeheight(local0))) <> 0) Then
                    local4 = $01
                    Exit
                EndIf
            Next
            If (local4 = $00) Then
                If (((graphicwidth = gfxmodewidth(local0)) And (graphicheight = gfxmodeheight(local0))) <> 0) Then
                    selectedgfxmode = gfxmodes
                EndIf
                gfxmodewidths(gfxmodes) = gfxmodewidth(local0)
                gfxmodeheights(gfxmodes) = gfxmodeheight(local0)
                gfxmodes = (gfxmodes + $01)
            EndIf
        Next
        graphicwidth = gfxmodewidths(selectedgfxmode)
        graphicheight = gfxmodeheights(selectedgfxmode)
        If (borderlesswindowed <> 0) Then
            createwindow(graphicwidth, graphicheight, $00, $05, "SCP - Containment Breach Multiplayer Mod ")
            aspectratioratio = (((Float graphicwidth) / (Float graphicheight)) / ((Float win\Field2) / (Float win\Field3)))
            fullscreen = $00
        Else
            aspectratioratio = 1.0
            If (fullscreen <> 0) Then
                createwindow(graphicwidth, graphicheight, $00, $01, "SCP - Containment Breach Multiplayer Mod ")
            Else
                createwindow(graphicwidth, graphicheight, $00, $02, "SCP - Containment Breach Multiplayer Mod ")
            EndIf
        EndIf
    EndIf
    win\Field2 = graphicwidth
    win\Field3 = graphicheight
    consolereissue = Null
    consoler = $FFFFFFFF
    consoleg = $FFFFFFFF
    consoleb = $FFFFFFFF
    consolemsgcount = $00
    menuscale = ((Float win\Field3) / 1024.0)
    invmenuscale = (1024.0 / (Float win\Field3))
    achvscale = ((Float win\Field3) / 768.0)
    For local0 = $00 To $800 Step $01
        imenuscale[local0] = (Int ((Float local0) * menuscale))
    Next
    loadallfonts()
    initstaticassets($00)
    ui_restart()
    If (selectedgfxdriver > $00) Then
        setgfxdriver(selectedgfxdriver)
    EndIf
    putinivalue("options.ini", "launcher", "isstarted", "1")
    lastcolor = $FFFFFFFF
    If (getiniint("options.ini", "launcher", "changeres", $00) = $00) Then
        playstartupvideos()
    Else
        flip($01)
    EndIf
    putinivalue("options.ini", "launcher", "changeres", "0")
    framelimit = getiniint("options.ini", "options", "framelimit", $00)
    verticalsync = getiniint("options.ini", "options", "vsync", $00)
    opt_antialias = getiniint("options.ini", "options", "antialias", $00)
    setfontsmooth(opt_antialias)
    currframelimit = ((Float (framelimit - $13)) * 0.01)
    screengamma = getinifloat("options.ini", "options", "screengamma", 0.0)
    seedrnd(millisecs())
    cansave = $01
    cursorimg = loadimage_strict("GFX\cursor.png")
    resizeimage(cursorimg, (Float imenuscale[$0C]), (Float imenuscale[$12]))
    loadingback = loadimage_strict("Loadingscreens\loadingback.jpg")
    maskimage(loadingback, $D4, $D4, $F3)
    initloadingscreens("Loadingscreens\loadingscreens.ini")
    If (getscripts() <> 0) Then
        public_inqueue($02, $01)
    EndIf
    setfontex(fonts[$01]\Field0)
    blinkmeterimg = loadimage_strict("GFX\blinkmeter.jpg")
    staminameterimg = loadimage_strict("GFX\staminameter.jpg")
    resizeimage(blinkmeterimg, (8.0 * menuscale), (14.0 * menuscale))
    resizeimage(staminameterimg, (8.0 * menuscale), (14.0 * menuscale))
    loadcustomprogressbars()
    gameload = $01
    drawloading(0.0, $01, $00, $00)
    drawloading(5.0, $01, $00, $01)
    viewport_center_x = (graphicwidth Shr $01)
    viewport_center_y = (graphicheight Shr $01)
    mousescalex = ((Float graphicwidth) / ((Float win\Field2) * aspectratioratio))
    mouseoffsetx = (((Float win\Field2) * 0.5) * (1.0 - aspectratioratio))
    mousescaley = ((Float graphicheight) / (Float win\Field3))
    mouselook_x_inc = 0.3
    mouselook_y_inc = 0.3
    mouse_left_limit = (Int (250.0 * menuscale))
    mouse_right_limit = (graphicwidth - mouse_left_limit)
    mouse_top_limit = mouse_left_limit
    mouse_bottom_limit = (graphicheight - mouse_top_limit)
    key_right = getiniint("options.ini", "binds", "Right key", $00)
    key_left = getiniint("options.ini", "binds", "Left key", $00)
    key_up = getiniint("options.ini", "binds", "Up key", $00)
    key_down = getiniint("options.ini", "binds", "Down key", $00)
    key_blink = getiniint("options.ini", "binds", "Blink key", $00)
    key_sprint = getiniint("options.ini", "binds", "Sprint key", $00)
    key_inv = getiniint("options.ini", "binds", "Inventory key", $00)
    key_crouch = getiniint("options.ini", "binds", "Crouch key", $00)
    key_save = getiniint("options.ini", "binds", "Save key", $00)
    key_console = getiniint("options.ini", "binds", "Console key", $00)
    key_chat = getiniint("options.ini", "binds", "Chat key", $40)
    key_voice = getiniint("options.ini", "binds", "Voice key", $2F)
    key_jump = getiniint("options.ini", "binds", "Jump key", $38)
    key_leanl = getiniint("options.ini", "binds", "LeanL key", $10)
    key_leanr = getiniint("options.ini", "binds", "LeanR key", $12)
    key_using = getiniint("options.ini", "binds", "Using key", $12)
    mouseinteract = getiniint("options.ini", "binds", "mouseinteract", $01)
    mousesmooth = getinifloat("options.ini", "options", "mouse smoothing", 1.0)
    rawmouseinput = (Int getinifloat("options.ini", "options", "raw mouse input", 0.0))
    otheropen = Null
    Dim drawarrowicon%($04)
    playable = $01
    blinkeffect = 1.0
    staminaeffect = 1.0
    Dim achievements%($25)
    achvmsgenabled = getiniint("options.ini", "options", "achievement popup enabled", $00)
    Dim achievementstrings$($25)
    Dim achievementdescs$($25)
    Dim achvimg%($25)
    For local0 = $00 To $24 Step $01
        local6 = getinisectionlocation("Data\achievementstrings.ini", ("s" + (Str local0)))
        achievementstrings(local0) = getinistring2("Data\achievementstrings.ini", local6, "string1", "")
        achievementdescs(local0) = getinistring2("Data\achievementstrings.ini", local6, "AchvDesc", "")
        local7 = getinistring2("Data\achievementstrings.ini", local6, "image", "")
        achvimg(local0) = loadimage_strict((("GFX\menu\achievements\" + local7) + ".jpg"))
        achvimg(local0) = resizeimage2(achvimg(local0), (Int ((Float imagewidth(achvimg(local0))) * achvscale)), (Int ((Float imageheight(achvimg(local0))) * achvscale)))
    Next
    achvlocked = loadimage_strict("GFX\menu\achievements\achvlocked.jpg")
    achvlocked = resizeimage2(achvlocked, (Int ((Float imagewidth(achvlocked)) * achvscale)), (Int ((Float imageheight(achvlocked)) * achvscale)))
    currachvmsgid = $00
    shouldnullgame = $00
    Dim radiostate#($0A)
    Dim radiostate3%($0A)
    Dim radiostate4%($09)
    Dim radiochn%($08)
    Dim oldaipics%($05)
    consoleflushsnd = $00
    consolemusflush = $00
    consolemusplay = $00
    infinitestamina = $00
    isnvgblinking = $00
    lightson = $01
    noclipspeed = 2.0
    invertmouse = getiniint("options.ini", "options", "invert mouse y", $00)
    coffindistance = 100.0
    bumpenabled = getiniint("options.ini", "options", "bump mapping enabled", $00)
    hudenabled = getiniint("options.ini", "options", "HUD enabled", $00)
    overlaysenabled = getiniint("options.ini", "options", "Overlays enabled", $00)
    camerafognear = 0.5
    camerar = $00
    camerag = $00
    camerab = $00
    camerafogfar = 6.0
    storedcamerafogfar = camerafogfar
    mousesens = getinifloat("options.ini", "options", "mouse sensitivity", 0.0)
    enablevram = getiniint("options.ini", "options", "enable vram", $00)
    ark_blur_x = (smallest_power_two_half - viewport_center_x)
    ark_blur_y = (smallest_power_two_half - viewport_center_y)
    Dim lightspritetex%($0A)
    setglobalconsolecolor($00, $FF, $FF)
    createconsolemsg("Console commands: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - teleport [room name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - godmode [on/off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - noclip [on/off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - noclipspeed [x] (default = 2.0)", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - wireframe [on/off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - debughud [on/off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - camerafog [near] [far]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - status", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - heal", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - spawnitem [item name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - 173speed [x] (default = 35)", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - disable173/enable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - disable106/enable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - 173state/106state/096state", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("  - spawn [npc type]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    setglobalconsolecolor($FFFFFFFF, $FFFFFFFF, $FFFFFFFF)
    tempsoundindex = $00
    Dim music$($28)
    music($00) = "The Dread"
    music($01) = "HeavyContainment"
    music($02) = "EntranceZone"
    music($03) = "PD"
    music($04) = "079"
    music($05) = "GateB1"
    music($06) = "GateB2"
    music($07) = "Room3Storage"
    music($08) = "Room049"
    music($09) = "8601"
    music($0A) = "106"
    music($0B) = "Menu"
    music($0C) = "8601Cancer"
    music($0D) = "Intro"
    music($0E) = "178"
    music($0F) = "PDTrench"
    music($10) = "205"
    music($11) = "GateA"
    music($12) = "1499"
    music($13) = "1499Danger"
    music($14) = "049Chase"
    music($15) = "..\Ending\MenuBreath"
    music($16) = "914"
    music($17) = "Ending"
    music($18) = "Credits"
    music($19) = "SaveMeFrom"
    music($1A) = "EarRing"
    music($1B) = "1123"
    musicvolume = getinifloat("options.ini", "audio", "music volume", 0.0)
    musicchn = streamsound_strict((("SFX\Music\" + music($02)) + ".ogg"), musicvolume, $02)
    currmusicvolume = 1.0
    nowplaying = $02
    shouldplay = $0B
    currmusic = $01
    drawloading(20.0, $01, $00, $01)
    initmultiplayer($FFFFFFFF, $00)
    Dim opendoorsfx%($03, $03)
    Dim closedoorsfx%($03, $03)
    Dim decaysfx%($05)
    drawloading(40.0, $01, $00, $01)
    Dim rustlesfx%($03)
    Dim dripsfx%($04)
    Dim radiosfx%($05, $0A)
    Dim picksfx%($0A)
    Dim ambientsfxamount%($06)
    ambientsfxamount($00) = $08
    ambientsfxamount($01) = $0B
    ambientsfxamount($02) = $0C
    ambientsfxamount($03) = $0F
    ambientsfxamount($04) = $05
    ambientsfxamount($05) = $0A
    Dim ambientsfx%($06, $0F)
    Dim oldmansfx%($08)
    Dim scp173sfx%($03)
    Dim horrorsfx%($14)
    Dim introsfx%($14)
    Dim alarmsfx%($05)
    Dim commotionstate%($19)
    Dim breathsfx%($02, $05)
    Dim necksnapsfx%($03)
    Dim damagesfx%($09)
    Dim mtfsfx%($08)
    Dim coughsfx%($03)
    Dim stepsfx%($05, $02, $08)
    Dim step2sfx%($06)
    drawloading(50.0, $01, $00, $01)
    ntf_1499entersfx = loadsound_strict("SFX\SCP\1499\Enter.ogg")
    ntf_1499leavesfx = loadsound_strict("SFX\SCP\1499\Exit.ogg")
    playcustommusic = $00
    custommusic = $00
    monitortimer = 0.0
    monitortimer2 = 0.0
    notarget = $00
    nvgimages = loadanimimage("GFX\battery.png", $40, $40, $00, $02)
    maskimage(nvgimages, $FF, $00, $FF)
    wearing1499 = $00
    enableusertracks = getiniint("options.ini", "audio", "enable user tracks", $00)
    usertrackmode = getiniint("options.ini", "audio", "user track setting", $00)
    usertrackcheck = $00
    usertrackcheck2 = $00
    usertrackmusicamount = $00
    usertrackflag = $00
    Dim usertrackname$($100)
    optionsmenu = $00
    quitmsg = $00
    infacility = $01
    prevmusicvolume = musicvolume
    prevsfxvolume = sfxvolume
    deafplayer = $00
    deaftimer = 0.0
    iszombie = $00
    room2gw_brokendoor = $00
    room2gw_x = 0.0
    room2gw_z = 0.0
    menuroomscale = (1.0 / 256.0)
    currmenu_testimg = ""
    particleamount = getiniint("options.ini", "options", "particle amount", $00)
    Dim navimages%($05)
    For local0 = $00 To $03 Step $01
        navimages(local0) = loadimage_strict((("GFX\navigator\roomborder" + (Str local0)) + ".png"))
        maskimage(navimages(local0), $FF, $00, $FF)
    Next
    navimages($04) = loadimage_strict("GFX\navigator\batterymeter.png")
    navbg = createimage(graphicwidth, graphicheight, $01)
    drawloading(65.0, $01, $00, $01)
    itemsrotaterand = rand($168, $01)
    hisssfx = loadsound_strict("SFX\General\Hiss.ogg")
    emittertimer = 0.0
    Dim bigdoorobj%($02)
    Dim heavydoorobj%($02)
    Dim objtunnel%($07)
    drawloading(80.0, $01, $00, $01)
    loadroomtemplates("Data\rooms.ini")
    mapwidth = $12
    mapheight = mapwidth
    Dim maptemp%((mapwidth + $01), (mapheight + $01))
    Dim mapfound%((mapwidth + $01), (mapheight + $01))
    hidedistance = 20.0
    secondarylighton = 1.0
    prevsecondarylighton = 1.0
    remotedooron = $01
    contained106 = $00
    allowroomsdoorsinit = $00
    updateroomlightstimer = 0.0
    Dim mapf%((mapwidth + $01), (mapheight + $01))
    Dim mapg%((mapwidth + $01), (mapheight + $01))
    Dim maph%((mapwidth + $01), (mapheight + $01))
    Dim mapstate%((mapwidth + $01), (mapheight + $01))
    Dim mapparent%((mapwidth + $01), (mapheight + $01), $02)
    Dim mapname$(mapwidth, mapheight)
    Dim maproomid%($06)
    Dim maproom$($06, $00)
    Dim gorepics%($0A)
    Dim chunkdata%($40, $40)
    collisions($02, $01, $02, $02)
    collisions($02, $0B, $02, $02)
    collisions($02, $02, $01, $03)
    collisions($02, $09, $02, $02)
    collisions($02, $05, $02, $03)
    collisions($03, $01, $02, $02)
    collisions($03, $0B, $02, $02)
    collisions($04, $04, $01, $02)
    collisions($05, $01, $02, $03)
    collisions($06, $01, $02, $02)
    collisions($06, $0B, $02, $02)
    collisions($08, $01, $02, $02)
    collisions($08, $0B, $02, $02)
    collisions($08, $02, $01, $02)
    collisions($0C, $01, $02, $02)
    collisions($0C, $02, $01, $03)
    collisions($08, $0C, $01, $02)
    collisions($0C, $09, $02, $02)
    drawloading(98.0, $01, $00, $01)
    Dim lightspritetex%($05)
    unabletomove = $00
    shouldentitiesfall = $01
    playerfallingpickdistance = 10.0
    save_msg = ""
    save_msg_timer = $00
    save_msg_y = $00
    mtf_camerachecktimer = 0.0
    mtf_cameracheckdetected = $00
    Dim menublinktimer%($02)
    Dim menublinkduration%($02)
    menublinktimer($00) = $01
    menublinktimer($01) = $01
    introenabled = getiniint("options.ini", "options", "intro enabled", $00)
    savepath = "Saves\"
    Dim savegames$((savegameamount + $01))
    Dim savegametime$((savegameamount + $01))
    Dim savegamedate$((savegameamount + $01))
    Dim savegameversion#((savegameamount + $01))
    Dim savegameseed$((savegameamount + $01))
    Dim savegamedifficulty%((savegameamount + $01))
    savedmapsamount = $00
    Dim savedmaps$((savedmapsamount + $01))
    Dim savedmapsauthor$((savedmapsamount + $01))
    loadsavegames()
    local8 = createudpstream("0", $00)
    local9 = udpstreamport(local8)
    closeudpstream(local8)
    currloadgamepage = $00
    timegravity = "0.0023"
    timetickrate = $80
    timejumpmode = $01
    timemaxplayers = $10
    timevoice = $01
    timeport = local9
    timerandomseed = setrandomseed()
    timeservername = ("SCP Server v" + multiplayer_version)
    shouldexitpage = $00
    keyssave = $00
    keyssavenumpad = $00
    quickloadpercent = $FFFFFFFF
    quickloadpercent_displaytimer = 0.0
    onsliderid = $00
    scrollbary = $00
    scrollmenuheight = $00
    mainmenuopen = $01
    flushkeys()
    flushmouse()
    drawloading(100.0, $01, $00, $01)
    loopdelay = millisecs()
    updateparticles_time = 0.0
    input_resettime = 0.0
    i_427 = (New scp427)
    stated = $00
    i_zone = (New mapzones)
    For local10 = Each servers
        If (((local10\Field0 = selected_servers) And (local10\Field17 = selected_page)) <> 0) Then
            multiplayer_list_updateserver(local10, $1388, $01)
        EndIf
    Next
    fullscreensetting = fullscreen
    borderlesswindowedsetting = borderlesswindowed
    launcherenabledsetting = launcherenabled
    selectedgfxdriversetting = selectedgfxdriver
    Repeat
        mouseposx = scaledmousex()
        mouseposy = scaledmousey()
        If (ready = "") Then
            ready = "Not Ready"
            ws_checksubscribeditems($01)
            If (nickname = "") Then
                nickname = steam_getplayername()
            EndIf
        EndIf
        updatefocus()
        If (keyhit($3E) <> 0) Then
            takescreenshot()
        EndIf
        updatemusic()
        autoreleasesounds()
        updateinput()
        If (mainmenuopen <> 0) Then
            updateframe()
            updatemainmenu()
            multiplayer_updategui($01)
            multiplayer_update()
            voice_update()
        Else
            updateframe()
            If (((menuopen = $00) Or udp_getstream()) <> 0) Then
                updatestreamsounds()
                updateambient()
                updateemitters()
                updatedeafplayer()
                updatemisc()
                updatecamera()
                voice_update()
                updatesecuritycams($00)
                setplayervariables()
                outscp = multiplayer_updatescps()
                If (selecteddoor = Null) Then
                    If (spectate\Field1 = $FFFFFFFF) Then
                        If (caninteract() <> 0) Then
                            mouselook($01)
                            moveplayer((outscp = $00))
                        Else
                            mouselook($00)
                            moveplayer($01)
                            updateexistanimation()
                        EndIf
                    EndIf
                Else
                    updateexistanimation()
                EndIf
                setplayervariables()
                multiplayer_breach_update()
                multiplayer_updateplayers()
                multiplayer_updatespectate()
                multiplayer_updateobjects()
                multiplayer_animateviewmodel()
                updateguns()
                animateguns()
                updatedeadbodies()
                updateexplosion()
                updatedoors()
                updaterooms()
                updateevents()
                If (playerroom\Field8\Field11 = "dimension1499") Then
                    updatedimension1499()
                    updateleave1499()
                Else
                    updatescreens()
                    timecheckpointmonitors()
                    update294()
                EndIf
                updatedecals()
                updatemtf()
                updatenpcs()
                updaterockets()
                updateitems()
                updateparticles()
                use427()
                updatemonitorsaving()
                updategame()
                multiplayer_update()
                updatebuttons()
                update3dsounds()
                updateresolution($01)
            EndIf
            render3d()
            render2d()
            updatehotkeys()
            multiplayer_doineedtoleave()
        EndIf
        If (getscripts() <> 0) Then
            public_inqueue($05, $01)
        EndIf
        updatetimers()
        If (workshopdisablepending <> 0) Then
            workshopdisablepending = $00
            ws_disableall()
        EndIf
        updatevsync($FFFFFFFF)
    Forever
    If (udp_getstream() <> 0) Then
        disconnectserver("exit", $01)
    EndIf
    destroywindow()
    creditstimer = 0.0
    shouldforcefov = $01
End Function
