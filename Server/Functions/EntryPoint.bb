Function EntryPoint%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6$
    se_script_access_invoke = $01
    se_transient_stack_size = $100
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
    mainfunction = $00
    mainfunctionerror = $00
    mainfunctionerrorblock = $00
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
    currentdatabasehandle = $00
    currentstatementhandle = $00
    invokefunctionaddress = $00
    se_defineconst("null", $00, "", $01, Null)
    se_defineconst("true", $01, "1", $01, Null)
    se_defineconst("false", $01, "0", $01, Null)
    se_defineconst("pi", $02, "3.14159", $01, Null)
    se_defineconst("se_null", $01, "0", $01, Null)
    se_defineconst("se_int", $01, "1", $01, Null)
    se_defineconst("se_float", $01, "2", $01, Null)
    se_defineconst("se_string", $01, "3", $01, Null)
    se_defineconst("se_pointer", $01, "5", $01, Null)
    se_defineconst("se_array", $01, "7", $01, Null)
    lastpluginid = $00
    publics = (New pb)
    steam_release = $00
    mp_version = (version($10209) + ".4")
    addversion(mp_version)
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
    last_breach_type = $00
    network_byte[$01] = $3D
    network_byte[$02] = $32
    network_byte[$03] = $54
    network_byte[$04] = $42
    network_byte[$05] = $53
    network_byte[$06] = $7F
    network_byte[$07] = $83
    dynamic_shoot_ticks = $01
    seedrnd(millisecs())
    gameinfo = (New g_i)
    server = (New multiplayerserver)
    ticks = (New types_ticks)
    newyearindex = isanewyear()
    halloweenindex = isahalloween()
    ignorebank = createbank($80)
    Dim difficulties.difficulty($04)
    framelimit = $12C
    fake_stream_ip = hostip(counthostips("localhost"))
    query_global_data = createbank($01)
    tcptimeouts($00, $00)
    fasttcp = (New fasttcps)
    tcp_init()
    centralserver = (New centralserverdata)
    centralserver\Field1 = createudpstream($00)
    initsteaminstances()
    server_init()
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
    difficulties($03)\Field0 = "Custom"
    difficulties($03)\Field2 = $00
    difficulties($03)\Field3 = $01
    difficulties($03)\Field4 = $00
    difficulties($03)\Field9 = $01
    difficulties($03)\Field5 = $00
    difficulties($03)\Field6 = $FF
    difficulties($03)\Field7 = $FF
    difficulties($03)\Field8 = $FF
    selecteddifficulty = difficulties($00)
    itemsrotaterand = rand($168, $01)
    tempsoundindex = $00
    menuscale = 1.0
    monitortimer = 0.0
    monitortimer2 = 0.0
    Dim lightspritetex%($05)
    Dim decaltextures%($14)
    unabletomove = $00
    shouldentitiesfall = $01
    playerfallingpickdistance = 10.0
    save_msg = ""
    save_msg_timer = $00
    save_msg_y = $00
    mtf_camerachecktimer = 0.0
    mtf_cameracheckdetected = $00
    playable = $01
    blinkeffect = 1.0
    staminaeffect = 1.0
    invertmouse = $00
    noclipspeed = 2.0
    coffindistance = 100.0
    lightson = $01
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
    bumpenabled = $00
    hudenabled = $00
    brightness = $00
    camerafognear = 0.5
    camerafogfar = 6.0
    storedcamerafogfar = camerafogfar
    mousesens = $00
    enablevram = $00
    Dim lightspritetex%($0A)
    Dim opendoorsfx%($03, $03)
    Dim closedoorsfx%($03, $03)
    Dim decaysfx%($05)
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
    optionsmenu = $00
    quitmsg = $00
    infacility = $01
    prevmusicvolume = local0
    prevsfxvolume = local1
    deafplayer = $00
    deaftimer = 0.0
    iszombie = $00
    room2gw_brokendoor = $00
    room2gw_x = 0.0
    room2gw_z = 0.0
    menuroomscale = (1.0 / 256.0)
    navbg = createimage(local2, local3, $01)
    currmenu_testimg = ""
    particleamount = $00
    Dim bigdoorobj%($02)
    Dim heavydoorobj%($02)
    Dim objtunnel%($07)
    i_zone = (New mapzones)
    Dim particletextures%($0A)
    hisssfx = loadsound_strict("SFX\General\Hiss.ogg")
    smokedelay = $00
    loadroomtemplates("Data\rooms.ini")
    roomscale = (1.0 / 256.0)
    mapwidth = $12
    mapheight = mapwidth
    Dim maptemp%((mapwidth + $01), (mapheight + $01))
    Dim mapfound%((mapwidth + $01), (mapheight + $01))
    hidedistance = 15.0
    secondarylighton = 1.0
    prevsecondarylighton = 1.0
    remotedooron = $01
    contained106 = $00
    Dim mapf%((mapwidth + $01), (mapheight + $01))
    Dim mapg%((mapwidth + $01), (mapheight + $01))
    Dim maph%((mapwidth + $01), (mapheight + $01))
    Dim mapstate%((mapwidth + $01), (mapheight + $01))
    Dim mapparent%((mapwidth + $01), (mapheight + $01), $02)
    Dim mapname$(mapwidth, mapheight)
    Dim maproomid%($06)
    Dim maproom$($06, $00)
    Dim gorepics%($0A)
    updateroomlightstimer = 0.0
    Dim chunkdata%($40, $40)
    quickloadpercent = $FFFFFFFF
    quickloadpercent_displaytimer = $00
    Dim achievements%($25)
    achvmsgenabled = $00
    Dim achievementstrings$($25)
    Dim achievementdescs$($25)
    Dim achvimg%($25)
    For local4 = $00 To $24 Step $01
        local5 = $00
        achievementstrings(local4) = "0"
        achievementdescs(local4) = "0"
        local6 = "0"
        achvimg(local4) = loadimage_strict((("GFX\menu\achievements\" + local6) + ".jpg"))
    Next
    achvlocked = loadimage_strict("GFX\menu\achievements\achvlocked.jpg")
    ft = (New fixedtimesteps)
    settickrate($3C)
    server_start()
End Function
