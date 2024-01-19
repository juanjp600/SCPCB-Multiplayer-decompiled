Function nullmap%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4.itemtemplates
    Local local5%
    Local local6.lighttemplates
    Local local7.doors
    Local local8.materials
    Local local9.waypoints
    Local local10.tempwaypoints
    Local local11.rooms
    Local local12.items
    Local local13.players
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23.props
    Local local24.decals
    Local local25.npcs
    Local local26.events
    Local local27.securitycams
    Local local28.emitters
    Local local29.particles
    Local local30.roomtemplates
    Local local31%
    Local local32%
    Local local33%
    Local local34%
    sound_onkill()
    For local13 = Each players
        If (local13\Field64 <> $00) Then
            freeentity(local13\Field64)
            local13\Field64 = $00
        EndIf
        If (local13\Field62 <> $00) Then
            freeentity(local13\Field62)
            local13\Field62 = $00
        EndIf
    Next
    Delete Each rockets
    Delete Each bullets
    Delete Each grenades
    For local0 = $01 To $FE Step $01
        If (multiplayer_object[local0] <> Null) Then
            Delete multiplayer_object[local0]
        EndIf
    Next
    local14 = $00
    local15 = $00
    classdobj = $00
    clerkmp = $00
    freeparticles()
    cleartexturecache()
    debughud = $00
    unabletomove = $00
    quickloadpercent = $FFFFFFFF
    quickloadpercent_displaytimer = $00
    quickload_currevent = Null
    deathmsg = ""
    local16 = $00
    usedconsole = $00
    local17 = $00
    roomtempid = $00
    local18 = $00
    hidedistance = 15.0
    For local3 = $00 To $00 Step $01
        For local1 = $00 To (mapwidth + $01) Step $01
            For local2 = $00 To (mapheight + $01) Step $01
                maptemp(local1, local2) = $00
                mapfound(local1, local2) = $00
            Next
        Next
    Next
    forcemove = $00
    forceangle = $00
    playable = $01
    coffindistance = 100.0
    contained106 = $00
    If (curr173 <> Null) Then
        curr173\Field24 = 0.0
    EndIf
    mtftimer = 0.0
    For local0 = $00 To $24 Step $01
        achievements(local0) = $00
    Next
    refineditems = $00
    local19 = $00
    local20 = $00
    eyeirritation = 0.0
    eyestuck = $00
    local21 = $00
    killtimer = 0.0
    falltimer = 0.0
    stamina = 100.0
    blurtimer = 0.0
    superman = $00
    supermantimer = $00
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
    local22 = $00
    For local7 = Each doors
        Delete local7
    Next
    For local6 = Each lighttemplates
        Delete local6
    Next
    For local8 = Each materials
        Delete local8
    Next
    For local9 = Each waypoints
        Delete local9
    Next
    Delete Each tempscreens
    For local10 = Each tempwaypoints
        Delete local10
    Next
    For local11 = Each rooms
        Delete local11
    Next
    For local4 = Each itemtemplates
        Delete local4
    Next
    For local12 = Each items
        Delete local12
    Next
    For local23 = Each props
        Delete local23
    Next
    For local24 = Each decals
        Delete local24
    Next
    For local25 = Each npcs
        Delete local25
    Next
    curr173 = Null
    curr106 = Null
    curr096 = Null
    For local0 = $00 To $06 Step $01
        mtfrooms[local0] = Null
    Next
    forestnpc = $00
    forestnpctex = $00
    For local27 = Each securitycams
        Delete local27
    Next
    For local26 = Each events
        Delete local26
    Next
    For local28 = Each emitters
        Delete local28
    Next
    For local29 = Each particles
        Delete local29
    Next
    For local30 = Each roomtemplates
        local30\Field0 = $00
    Next
    ntf_1499prevx = $00
    ntf_1499prevy = $00
    ntf_1499prevz = $00
    ntf_1499prevroom = $00
    ntf_1499x = $00
    ntf_1499y = $00
    ntf_1499z = $00
    local31 = $00
    deletechunks()
    deletedevilemitters()
    notarget = $00
    optionsmenu = $FFFFFFFF
    quitmsg = $FFFFFFFF
    achievementsmenu = $FFFFFFFF
    local32 = prevmusicvolume
    local33 = prevsfxvolume
    deafplayer = $00
    deaftimer = 0.0
    iszombie = $00
    local34 = $00
    For local26 = Each events
        If (local26\Field7 <> $00) Then
            freesound_strict(local26\Field7)
        EndIf
        If (local26\Field8 <> $00) Then
            freesound_strict(local26\Field8)
        EndIf
    Next
    Delete Each rockets
    Delete Each bullets
    Delete Each grenades
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
    Delete Each forest
    For local30 = Each roomtemplates
        local30\Field0 = $00
    Next
    clearworld($01, $01, $01)
    Return $00
End Function
