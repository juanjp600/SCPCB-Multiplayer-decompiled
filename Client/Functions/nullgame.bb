Function nullgame%(arg0%)
    Local local0.achievementmsg
    Local local1.consolemsg
    Local local2.events
    Local local3.itemtemplates
    Local local4.items
    Local local5.decals
    Local local6.particles
    Local local7.doors
    Local local8.levers
    Local local9.securitycams
    Local local10.dummy1499_1
    Local local11.npcs
    Local local12.screens
    Local local13.waypoints
    Local local14.props
    Local local15.lights
    Local local16.roomtemplates
    Local local17.rooms
    Local local18.materials
    Local local19.sound
    Local local20.forest
    Local local21.mtgrid
    Local local22.chunk
    Local local23.chunkpart
    Local local24.save
    Local local25.custommaps
    Local local26.soundemitters
    Local local27.template
    Local local28.emitter
    Local local29%
    catcherrors("NullGame()")
    If (mp_getsocket() <> $00) Then
        mp_flushserver()
    EndIf
    mp_destructrenderer()
    deletetextureentriesfromcache($01)
    stopmousemovement()
    killsounds($00)
    If (arg0 <> 0) Then
        playsound_strict(buttonsfx[$00], $00, $01)
    EndIf
    randomseed = ""
    usedconsole = $00
    Delete chs
    chs = Null
    wireframestate = $00
    wireframe($00)
    consoleopen = $00
    consoleinput = ""
    consolescroll = 0.0
    consolescrolldragging = $00
    consolemousemem = $00
    consoler = $00
    consoleg = $00
    consoleb = $00
    consoleinbox = $00
    consoleinbar = $00
    For local1 = Each consolemsg
        Delete local1
    Next
    subjectname = ""
    infacility = $00
    playerfallingpickdistance = 0.0
    toelevatorfloor = $00
    shouldentitiesfall = $00
    hidedistance = 0.0
    coffindistance = 0.0
    camerazoomvalue = 0.0
    secondarylighton = 0.0
    isblackout = $00
    previsblackout = $00
    updatelightstimer = 0.0
    lightrenderdistance = 0.0
    remotedooron = $00
    gamesaved = $00
    cansave = $00
    mtftimer = 0.0
    mtfcamerachecktimer = 0.0
    mtfcameracheckdetected = $00
    snavunlocked = $00
    ereaderunlocked = $00
    code_dr_maynard = $00
    code_dr_gears = $00
    code_maintenance_tunnels = $00
    code_o5_council = $00
    shouldplay = $42
    freeentity(soundemitter)
    soundemitter = $00
    soundtransmission = $00
    templightvolume = 0.0
    lightvolume = 0.0
    grabbedentity = $00
    camerapitch = 0.0
    handentity = $00
    For local29 = $00 To $03 Step $01
        drawarrowicon[local29] = $00
    Next
    batmsgtimer = 0.0
    escapesecondstimer = 0.0
    escapetimer = $00
    If (camera <> $00) Then
        freeentity(camera)
        camera = $00
    EndIf
    If (sky <> $00) Then
        freeentity(sky)
        sky = $00
    EndIf
    currtrisamount = $00
    currachvmsgid = $00
    For local0 = Each achievementmsg
        Delete local0
    Next
    subfile = $00
    localsubfile = $00
    subcolors = $00
    localsubcolors = $00
    subtitlesinit = $00
    clearsubtitles()
    deinitsubtitlesassets()
    Delete msg
    msg = Null
    Delete as
    as = Null
    Delete me
    me = Null
    Delete wi
    wi = Null
    Delete fog
    fog = Null
    Delete i_005
    i_005 = Null
    Delete i_008
    i_008 = Null
    Delete i_035
    i_035 = Null
    Delete i_268
    i_268 = Null
    destroys2imap(i_294\Field2)
    i_294\Field2 = $00
    Delete i_294
    i_294 = Null
    Delete i_409
    i_409 = Null
    For local29 = $00 To $01 Step $01
        i_427\Field2[local29] = $00
    Next
    Delete i_427
    i_427 = Null
    Delete i_500
    i_500 = Null
    Delete i_714
    i_714 = Null
    Delete i_1025
    i_1025 = Null
    If (i_1499\Field8 <> $00) Then
        freeentity(i_1499\Field8)
        i_1499\Field8 = $00
    EndIf
    Delete i_1499
    i_1499 = Null
    scp1499chunks = $00
    Delete i_1048a
    i_1048a = Null
    Delete i_966
    i_966 = Null
    quickloadpercent = $00
    quickloadpercent_displaytimer = 0.0
    For local2 = Each events
        removeevent(local2)
    Next
    isusingradio = $00
    invopen = $00
    For local29 = $00 To $09 Step $01
        If (local29 < $09) Then
            radiostate[local29] = 0.0
            radiostate2[local29] = $00
        EndIf
        radiostate3[local29] = $00
    Next
    maxitemamount = $00
    lastitemid = $00
    For local4 = Each items
        removeitem(local4)
    Next
    Dim inventory.items($00)
    For local3 = Each itemtemplates
        removeitemtemplate(local3)
    Next
    For local5 = Each decals
        removedecal(local5)
    Next
    removedecalinstances()
    particlecam = $00
    freeentity(particlepiv)
    particlepiv = $00
    dustparticlechance = $00
    For local28 = Each emitter
        freeemitter(local28, $01)
    Next
    For local27 = Each template
        freetemplate((Handle local27))
    Next
    Delete Each template
    For local6 = Each particles
        removeparticle(local6)
    Next
    removeparticleinstances()
    Delete bk
    bk = Null
    For local7 = Each doors
        removedoor(local7)
    Next
    d_i\Field10 = $00
    buttondirection = $00
    removedoorinstances()
    For local8 = Each levers
        removelever(local8)
    Next
    removeleverinstances()
    For local9 = Each securitycams
        removesecuritycam(local9)
    Next
    removesecuritycaminstances()
    removemonitorinstances()
    For local12 = Each screens
        removescreen(local12)
    Next
    For local13 = Each waypoints
        removewaypoint(local13)
    Next
    For local14 = Each props
        removeprop(local14)
    Next
    For local15 = Each lights
        removelight(local15)
    Next
    For local26 = Each soundemitters
        removesoundemitter(local26)
    Next
    For local20 = Each forest
        If (local20 <> Null) Then
            destroyforest(local20, $01)
        EndIf
        Delete local20
    Next
    For local21 = Each mtgrid
        If (local21 <> Null) Then
            destroymt(local21, $00)
        EndIf
        Delete local21
    Next
    For local29 = $00 To $FFF Step $01
        chunkdata[local29] = $00
    Next
    For local22 = Each chunk
        removechunk(local22)
    Next
    For local23 = Each chunkpart
        removechunkpart(local23)
    Next
    Dim maproom$($00, $00)
    Dim roomamount%($00, $00)
    Delete currmapgrid
    currmapgrid = Null
    Delete i_zone
    i_zone = Null
    roomtempid = $00
    key2_spawnrate = $00
    For local17 = Each rooms
        removeroom(local17)
    Next
    For local16 = Each roomtemplates
        removeroomtemplate(local16)
    Next
    removehazmattimer = 0.0
    remove714timer = 0.0
    forestnpc = $00
    forestnpctex = $00
    For local29 = $00 To $02 Step $01
        forestnpcdata[local29] = 0.0
    Next
    For local10 = Each dummy1499_1
        removedummy1499_1(local10)
    Next
    For local11 = Each npcs
        removenpc(local11)
    Next
    removenpcinstances()
    removemiscinstances()
    For local18 = Each materials
        Delete local18
    Next
    removetextureinstances()
    Delete Each textureincache
    ambientlightroomtex = $00
    freetexture(missingtexture)
    missingtexture = $00
    mesh_minx = 0.0
    mesh_miny = 0.0
    mesh_minz = 0.0
    mesh_maxx = 0.0
    mesh_maxy = 0.0
    mesh_maxz = 0.0
    mesh_magx = 0.0
    mesh_magy = 0.0
    mesh_magz = 0.0
    For local29 = $00 To $18 Step $01
        commotionstate[local29] = $00
    Next
    currambientsfx = $00
    tempsoundindex = $00
    For local19 = Each sound
        If (local19\Field0 <> $00) Then
            freesound(local19\Field0)
            local19\Field0 = $00
        EndIf
        Delete local19
    Next
    removesoundinstances()
    For local24 = Each save
        Delete local24
    Next
    For local25 = Each custommaps
        Delete local25
    Next
    freeblur()
    If (fresizetexture <> $00) Then
        freetexture(fresizetexture)
        fresizetexture = $00
    EndIf
    If (fresizetexture2 <> $00) Then
        freetexture(fresizetexture2)
        fresizetexture2 = $00
    EndIf
    If (fresizeimage <> $00) Then
        freeentity(fresizeimage)
        fresizeimage = $00
    EndIf
    If (fresizecam <> $00) Then
        freeentity(fresizecam)
        fresizecam = $00
    EndIf
    rendertween = 0.0
    clearcollisions()
    clearworld($01, $01, $01)
    resettimingaccumulator()
    initfastresize()
    selectedinputbox = $00
    shoulddeletegadgets = $01
    deletemenugadgets()
    initmainmenuassets()
    menuopen = $00
    Delete igm
    igm = Null
    mainmenuopen = $01
    mm\Field5 = $00
    catcherrors("Uncaught: NullGame()")
    Return $00
End Function
