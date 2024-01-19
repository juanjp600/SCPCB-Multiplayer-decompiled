Function nullgame%(arg0%)
    Local local0.screens
    Local local1%
    Local local2%
    Local local3%
    Local local4.itemtemplates
    Local local5.events
    Local local6.soundtodelete
    Local local7.redirectedsound
    Local local8.redirectedsound
    Local local9.roomtemplates
    If (arg0 <> 0) Then
        playsound_strict(buttonsfx)
    EndIf
    If (menubrowser <> Null) Then
        steambrowser_destroy(menubrowser)
    EndIf
    deleteguns()
    reloaddifficulties()
    freeparticles()
    cleartexturecache()
    killsounds()
    cube = $00
    gameload = $00
    vest_obj = $00
    nvg_obj = $00
    gasmask_obj = $00
    stated = $00
    spectate\Field1 = $FFFFFFFF
    holdinggun = $00
    classdobj = $00
    clerkmp = $00
    using294 = $00
    input294 = ""
    debughud = $00
    unabletomove = $00
    quickloadpercent = $FFFFFFFF
    quickloadpercent_displaytimer = 0.0
    quickload_currevent = Null
    deathmsg = ""
    selectedmap = ""
    usedconsole = $00
    doortempid = $00
    roomtempid = $00
    gamesaved = $00
    hidedistance = 15.0
    dropspeed = 0.0
    shake = 0.0
    currspeed = 0.0
    deathtimer = 0.0
    heartbeatvolume = 0.0
    staminaeffect = 1.0
    staminaeffecttimer = 0.0
    blinkeffect = 1.0
    blinkeffecttimer = 0.0
    bloodloss = 0.0
    injuries = 0.0
    infect = 0.0
    selectedending = ""
    endingtimer = 0.0
    explosiontimer = 0.0
    camerashake = 0.0
    shake = 0.0
    lightflash = 0.0
    godmode = $00
    noclip = $00
    wireframestate = $00
    wireframe($00)
    wearinggasmask = $00
    wearinghazmat = $00
    wearingvest = $00
    wearing714 = $00
    If (wearingnightvision <> 0) Then
        camerafogfar = storedcamerafogfar
        wearingnightvision = $00
    EndIf
    For local0 = Each screens
        If (local0\Field2 <> $00) Then
            freeimage(local0\Field2)
            local0\Field2 = $00
        EndIf
    Next
    For local1 = $00 To $05 Step $01
        scp1025state[local1] = 0.0
    Next
    For local1 = $00 To $24 Step $01
        achievements(local1) = $00
    Next
    For local2 = $00 To (mapwidth + $01) Step $01
        For local3 = $00 To (mapheight + $01) Step $01
            maptemp(local2, local3) = $00
            mapfound(local2, local3) = $00
        Next
    Next
    For local4 = Each itemtemplates
        local4\Field4 = $00
        If (local4\Field8 <> $00) Then
            freeimage(local4\Field8)
        EndIf
        If (local4\Field9 <> $00) Then
            freeimage(local4\Field9)
        EndIf
        If (local4\Field12 <> $00) Then
            freeimage(local4\Field12)
        EndIf
    Next
    i_427\Field0 = $00
    i_427\Field1 = 0.0
    forcemove = 0.0
    forceangle = 0.0
    playable = $01
    coffindistance = 100.0
    contained106 = $00
    mtftimer = 0.0
    refineditems = $00
    consoleinput = ""
    consoleopen = $00
    eyeirritation = 0.0
    eyestuck = 0.0
    shouldplay = $00
    killtimer = 0.0
    falltimer = 0.0
    stamina = 100.0
    blurtimer = 0.0
    superman = $00
    supermantimer = 0.0
    sanity = 0.0
    restoresanity = $01
    crouch = $00
    crouchstate = 0.0
    lightvolume = 0.0
    vomit = $00
    vomittimer = 0.0
    secondarylighton = 1.0
    prevsecondarylighton = 1.0
    remotedooron = $01
    soundtransmission = $00
    closestbutton = $00
    infinitestamina = $00
    msg = ""
    msgtimer = 0.0
    selecteditem = Null
    forestnpc = $00
    forestnpctex = $00
    For local5 = Each events
        If (local5\Field7 <> $00) Then
            freesound_strict(local5\Field7)
        EndIf
        If (local5\Field8 <> $00) Then
            freesound_strict(local5\Field8)
        EndIf
    Next
    Delete Each rockets
    Delete Each bullets
    Delete Each grenades
    Delete Each p_obj
    Delete Each singlelights
    Delete Each doors
    Delete Each lighttemplates
    Delete Each materials
    Delete Each waypoints
    Delete Each tempwaypoints
    Delete Each tempscreens
    Delete Each props
    Delete Each rooms
    Delete Each itemtemplates
    Delete Each items
    Delete Each props
    Delete Each decals
    Delete Each npcs
    Delete Each events
    Delete Each screens
    Delete Each securitycams
    Delete Each emitters
    Delete Each particles
    Delete Each achievementmsg
    Delete Each forest
    For local6 = Each soundtodelete
        If (local6\Field0 <> $00) Then
            freesound(local6\Field0)
        EndIf
    Next
    For local7 = Each redirectedsound
        If (local7\Field3 <> 0) Then
            local8 = redirectsound(local7\Field1, local7\Field0, $01)
            Delete local8
            Delete local7
        EndIf
    Next
    For local9 = Each roomtemplates
        local9\Field0 = $00
    Next
    For local1 = $00 To $05 Step $01
        If (channelplaying(radiochn(local1)) <> 0) Then
            stopchannel(radiochn(local1))
        EndIf
    Next
    currachvmsgid = $00
    notarget = $00
    optionsmenu = $FFFFFFFF
    quitmsg = $FFFFFFFF
    achievementsmenu = $FFFFFFFF
    musicvolume = prevmusicvolume
    sfxvolume = prevsfxvolume
    deafplayer = $00
    deaftimer = 0.0
    iszombie = $00
    ntf_1499prevx = 0.0
    ntf_1499prevy = 0.0
    ntf_1499prevz = 0.0
    ntf_1499prevroom = Null
    ntf_1499x = 0.0
    ntf_1499y = 0.0
    ntf_1499z = 0.0
    wearing1499 = $00
    deletechunks()
    deletedevilemitters()
    aatextcam = $00
    freeallfonts($00, $00)
    clearworld($01, $01, $01)
    camera = $00
    ark_blur_cam = $00
    collider = $00
    sky = $00
    loadallfonts($01)
    initfastresize()
    reloadnecessaryentities()
    Return $00
End Function
