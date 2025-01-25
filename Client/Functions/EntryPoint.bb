Function EntryPoint%()
    Local local0$
    Local local1.launcher
    Local local2%
    Local local3%
    Local local4%
    local0 = ""
    errormessageinitialized = $00
    If (filesize("BlitzToolbox.dll") = $00) Then
        local0 = (((local0 + "BlitzToolbox.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("FMod.dll") = $00) Then
        local0 = (((local0 + "FMod.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("dplayx.dll") = $00) Then
        local0 = (((local0 + "dplayx.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("d3dim700.dll") = $00) Then
        local0 = (((local0 + "d3dim700.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("FreeImage.dll") = $00) Then
        local0 = (((local0 + "FreeImage.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("IniController.dll") = $00) Then
        local0 = (((local0 + "IniController.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("RapidBson.dll") = $00) Then
        local0 = (((local0 + "RapidBson.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("opus.dll") = $00) Then
        local0 = (((local0 + "opus.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("zlibwapi.dll") = $00) Then
        local0 = (((local0 + "zlibwapi.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("uemp.dll") = $00) Then
        local0 = (((local0 + "uemp.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("bassopus.dll") = $00) Then
        local0 = (((local0 + "bassopus.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("bass.dll") = $00) Then
        local0 = (((local0 + "bass.dll") + chr($0D)) + chr($0A))
    EndIf
    If (len(local0) > $00) Then
        runtimeerror((((((("The following DLLs were not found in the game directory:" + chr($0D)) + chr($0A)) + chr($0D)) + chr($0A)) + local0) + "."))
    EndIf
    If (filetype((getenv("AppData") + "\scpcb-ue\")) <> $02) Then
        createdir((getenv("AppData") + "\scpcb-ue"))
    EndIf
    If (filetype((getenv("AppData") + "\scpcb-ue\Data\")) <> $02) Then
        createdir((getenv("AppData") + "\scpcb-ue\Data"))
    EndIf
    key = (New keys)
    optionfile = (getenv("AppData") + "\scpcb-ue\Data\options.ini")
    opt = (New options)
    opt\Field53 = countgfxdrivers()
    opt\Field54 = (totalvidmem() Sar $0A)
    opt\Field55 = (totalphys() Sar $0A)
    loadoptionsini()
    iniwritebuffer("Data\local.ini", "", $01)
    iniwritebuffer("Data\MP_local.ini", "Data\local.ini", $00)
    iniwritebuffer("Data\achievements.jsonc", "", $01)
    iniwritebuffer("Data\fonts.ini", "", $01)
    mo = (New mouse)
    fo = (New fonts)
    lang = (New language)
    setlanguage(opt\Field52, $01)
    fps = (New framesperseconds)
    If (opt\Field41 <> 0) Then
        local1 = (New launcher)
        local1\Field0 = countgfxmodes3d()
        updatelauncher(local1)
        Delete local1
    EndIf
    graphicwidthfloat = (Float opt\Field46)
    graphicheightfloat = (Float opt\Field47)
    graphics3dex(opt\Field46, opt\Field47, $00, (((opt\Field48 = $02) + $01) + ((opt\Field48 = $01) * $03)))
    apptitle(format(getlocalstring("misc", "title"), "1.5", "%s"), "")
    menuscale = ((Float opt\Field47) / 1024.0)
    input_resettime = 0.0
    mo\Field9 = (opt\Field46 Sar $01)
    mo\Field10 = (opt\Field47 Sar $01)
    setbuffer(backbuffer())
    seedrnd(millisecs())
    playstartupvideos()
    fps\Field6 = millisecs()
    If (opt\Field48 = $00) Then
        cursorimg = scaleimageex(loadimage_strict("GFX\Menu\cursor.png"), menuscale, menuscale, $01)
    EndIf
    initloadingscreens("Data\loading_screens.jsonc")
    loadfonts()
    setfontex(fo\Field0[$01])
    blinkmeterimg = scaleimageex(loadimage_strict("GFX\HUD\blink_meter(1).png"), menuscale, menuscale, $01)
    renderloading($00, getlocalstring("loading", "core.main"))
    renderloading($05, getlocalstring("loading", "core.achv"))
    snavunlocked = $00
    ereaderunlocked = $00
    currachvmsgid = $00
    renderloading($0A, getlocalstring("loading", "core.diff"))
    difficulties[$00] = (New difficulty)
    difficulties[$00]\Field0 = getlocalstring("menu", "new.safe")
    difficulties[$00]\Field1 = getlocalstring("msg", "diff.safe")
    difficulties[$00]\Field2 = $00
    difficulties[$00]\Field9 = $0A
    difficulties[$00]\Field3 = $00
    difficulties[$00]\Field4 = $00
    difficulties[$00]\Field10 = $00
    setdifficultycolor($00, $78, $96, $32)
    difficulties[$01] = (New difficulty)
    difficulties[$01]\Field0 = getlocalstring("menu", "new.euclid")
    difficulties[$01]\Field1 = getlocalstring("msg", "diff.euclid")
    difficulties[$01]\Field2 = $00
    difficulties[$01]\Field9 = $08
    difficulties[$01]\Field3 = $01
    difficulties[$01]\Field4 = $01
    difficulties[$01]\Field10 = $01
    setdifficultycolor($01, $C8, $C8, $32)
    difficulties[$02] = (New difficulty)
    difficulties[$02]\Field0 = getlocalstring("menu", "new.keter")
    difficulties[$02]\Field1 = getlocalstring("msg", "diff.keter")
    difficulties[$02]\Field2 = $01
    difficulties[$02]\Field9 = $06
    difficulties[$02]\Field3 = $02
    difficulties[$02]\Field4 = $02
    difficulties[$02]\Field10 = $02
    setdifficultycolor($02, $C8, $32, $32)
    difficulties[$03] = (New difficulty)
    difficulties[$03]\Field0 = getlocalstring("menu", "new.apollyon")
    difficulties[$03]\Field1 = getlocalstring("msg", "diff.apollyon")
    difficulties[$03]\Field2 = $01
    difficulties[$03]\Field9 = $02
    difficulties[$03]\Field3 = $03
    difficulties[$03]\Field4 = $03
    difficulties[$03]\Field10 = $03
    setdifficultycolor($03, $96, $96, $96)
    difficulties[$04] = (New difficulty)
    difficulties[$04]\Field0 = getlocalstring("menu", "new.esoteric")
    difficulties[$04]\Field2 = $00
    difficulties[$04]\Field9 = $0A
    difficulties[$04]\Field5 = $01
    difficulties[$04]\Field3 = $00
    difficulties[$04]\Field4 = $00
    difficulties[$04]\Field10 = $04
    setdifficultycolor($04, $C8, $32, $C8)
    selecteddifficulty = difficulties[(opt\Field51 = $00)]
    renderloading($0F, getlocalstring("loading", "core.loading"))
    tempsoundindex = $00
    music[$00] = "LightContainmentZone"
    music[$01] = "HeavyContainmentZone"
    music[$02] = "EntranceZone"
    music[$03] = "PD"
    music[$04] = "079Chamber"
    music[$05] = "Gate_B1"
    music[$06] = "Gate_B2"
    music[$07] = "Room3_storage"
    music[$08] = "049Chamber"
    music[$09] = "860_1_Blue"
    music[$0A] = "106Chase"
    music[$0B] = "Menu"
    music[$0C] = "860_2Chase"
    music[$0D] = "173IntroChamber"
    music[$0E] = "PDTrench"
    music[$0F] = "205Chamber"
    music[$10] = "Gate_A"
    music[$11] = "1499Dimension"
    music[$12] = "1499_1Chase"
    music[$13] = "049Chase"
    music[$14] = "..\Ending\MenuBreath"
    music[$15] = "914Chamber"
    music[$16] = "Ending"
    music[$17] = "Credits"
    music[$18] = "SaveMeFrom"
    music[$19] = "106Chamber"
    music[$1A] = "035Chamber"
    music[$1B] = "409Chamber"
    music[$1C] = "MaintenanceTunnels"
    music[$1D] = "1123Chamber"
    music[$1E] = "008Chamber"
    music[$1F] = "008Cutscene"
    music[$20] = "012Chamber"
    music[$21] = "860_1_Red"
    musicchn = streamsound_strict((("SFX\Music\" + music[$02]) + ".ogg"), opt\Field18, $02)
    nowplaying = $02
    shouldplay = $0B
    currmusic = $01
    Dim opendoorsfx%($06, $03)
    Dim closedoorsfx%($06, $03)
    Dim radiosfx%($02, $09)
    Dim ambientsfx%($06, $10)
    Dim breathsfx%($02, $05)
    Dim coughsfx%($02, $03)
    Dim stepsfx%($06, $02, $08)
    usertrackcheck = $00
    usertrackcheck2 = $00
    usertrackmusicamount = $00
    usertrackflag = $00
    renderloading($14, getlocalstring("loading", "core.subtitle"))
    renderloading($19, getlocalstring("loading", "core.sound"))
    renderloading($1E, getlocalstring("loading", "core.item"))
    Dim inventory.items($00)
    otheropen = Null
    renderloading($23, getlocalstring("loading", "core.particle"))
    updatedevilparticlestimer = 0.0
    renderloading($28, getlocalstring("loading", "core.grap"))
    screenshotcount = $01
    While (filetype((("Screenshots\Screenshot" + (Str screenshotcount)) + ".png")) = $01)
        screenshotcount = (screenshotcount + $01)
    Wend
    textoffset = $00
    renderloading($2D, getlocalstring("loading", "core.map"))
    renderloading($32, getlocalstring("loading", "core.mat"))
    renderloading($37, getlocalstring("loading", "core.texcache"))
    Dim maproom$($00, $00)
    Dim roomamount%($00, $00)
    renderloading($3C, getlocalstring("loading", "core.sky"))
    renderloading($41, getlocalstring("loading", "core.npc"))
    renderloading($46, getlocalstring("loading", "core.event"))
    renderloading($4B, getlocalstring("loading", "core.save"))
    renderloading($50, getlocalstring("loading", "core.menu"))
    menuwhite = loadimage_strict("GFX\Menu\menu_white.png")
    menugray = loadimage_strict("GFX\Menu\menu_gray.png")
    menublack = loadimage_strict("GFX\Menu\menu_black.png")
    cursorpos = $FFFFFFFF
    If (opt\Field48 <> $00) Then
        opt\Field1 = $00
        iniwritestring(optionfile, "Graphics", "Anti-Aliasing", (Str opt\Field1), $01)
    EndIf
    textr = 0.0
    textg = 0.0
    textb = 0.0
    initializeintromovie = $00
    onbuttonid = $00
    insertmode = $00
    scrollbary = 0.0
    scrollmenuheight = 0.0
    renderloading($55, getlocalstring("loading", "core.multiplayer"))
    mp_inittimer()
    initnetwork()
    myplayerlogic = (New mp_myplayerlogic)
    mp_settings = (New mp_settingssystem)
    mp_setclientname(loadnicknamefromini())
    menuport = "39100"
    menuip = "127.0.0.1"
    multiplayer_version = versiondots($08)
    senddebuglog(multiplayer_version)
    createserverinfo()
    mp_menuinit()
    initpinging()
    setpingingtimeout($BB8)
    pcm_encoder_channels = $01
    pcm_encoder_sample_rate = $BB80
    pcm_encoder_opus_type = $800
    default_frame_size = $3C0
    bass_init($FFFFFFFF, $BB80, $04, api_getactivewindow(), local2)
    bass_pluginload("bassopus.dll", $00)
    npcs_hasreceive = $00
    event_hasreceive = $00
    serverlist = (New mp_serverlist)
    loadservers()
    mp_terminated = (New mp_terminatesystem)
    mp_terminated\Field5 = $7530
    mp_terminated\Field0 = $01
    mp_chat = (New mp_chatsystem)
    mp_dialog = (New mp_dialogwindow)
    mp_playerslist = (New mp_playerslistsystem)
    ismultiplayerhudenabled = $00
    initmainmenuassets()
    mainmenuopen = $01
    resetinput()
    renderloading($64, "")
    initerrormsgs($0D, $01)
    seterrormsg($00, format(getlocalstring("error", "title"), "1.5", "%s"))
    seterrormsg($01, getlocalstring("error", "shot"))
    seterrormsg($02, "---------------------------------------------------")
    seterrormsg($03, ((("Date and time: " + currentdate()) + ", ") + currenttime()))
    seterrormsg($04, (((((("OS: " + systemproperty("os")) + " ") + (Str (((getenv("ProgramFiles(X86)") <> "0") Shl $05) + $20))) + " Bit (Build: ") + systemproperty("osbuild")) + ")"))
    seterrormsg($05, (((((("CPU: " + trim(systemproperty("cpuname"))) + " (Arch: ") + systemproperty("cpuarch")) + ", ") + getenv("NUMBER_OF_PROCESSORS")) + " Threads)"))
    seterrormsg($0C, "Caught exception: _CaughtError_")
    errormessageinitialized = $01
    gpuname = converttoutf8(gfxdrivername(opt\Field49))
    Repeat
        seterrormsg($06, (((((("GPU: " + gpuname) + " (") + (Str (opt\Field54 - (availvidmem() Sar $0A)))) + "MB/") + (Str opt\Field54)) + " MB)"))
        seterrormsg($07, (((("Global memory status: (" + (Str (opt\Field55 - (availphys() Sar $0A)))) + "MB/") + (Str opt\Field55)) + " MB)"))
        cls()
        millisec = millisecs()
        fps\Field2 = millisec
        local3 = (fps\Field2 - fps\Field1)
        If (((local3 > $00) And (local3 < $1F4)) <> 0) Then
            fps\Field0 = (fps\Field0 + max(0.0, (((Float local3) * 70.0) / 1000.0)))
        EndIf
        fps\Field1 = fps\Field2
        If (0.0 < (Float opt\Field35)) Then
            local4 = (Int ((1000.0 / (Float opt\Field35)) - (Float (millisecs() - fps\Field6))))
            delay(local4)
            fps\Field6 = millisecs()
        EndIf
        fps\Field7[$00] = 1.166667
        fps\Field7[$01] = fps\Field7[$00]
        If (mainmenuopen <> 0) Then
            updatemainmenu()
        Else
            updategame()
        EndIf
        rendergamma()
        If (keyhit(key\Field11) <> 0) Then
            getscreenshot()
        EndIf
        If (opt\Field33 <> 0) Then
            If (fps\Field5 < millisecs()) Then
                fps\Field3 = fps\Field4
                fps\Field4 = $00
                fps\Field5 = (millisecs() + $3E8)
            Else
                fps\Field4 = (fps\Field4 + $01)
            EndIf
        EndIf
        flip(opt\Field5)
        mp_update()
    Forever
    consolereissue = Null
    consoleinbox = $00
    consoleinbar = $00
End Function
