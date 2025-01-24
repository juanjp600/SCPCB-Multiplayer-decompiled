Function initnewgame%()
    Local local0.decals
    Local local1.doors
    Local local2.items
    Local local3.rooms
    Local local4.securitycams
    Local local5.events
    Local local6.roomtemplates
    Local local7.props
    Local local8%
    Local local9%
    Local local11.tempscreens
    Local local12.tempwaypoints
    Local local13.templights
    Local local14.tempprops
    Local local15.tempsoundemitters
    catcherrors("InitNewGame()")
    loadentities()
    loadsounds()
    fog\Field0 = 6.0
    isblackout = $00
    previsblackout = $00
    remotedooron = $01
    initotherstuff()
    maxitemamount = selecteddifficulty\Field9
    Dim inventory.items((maxitemamount + $02))
    renderloading($32, getlocalstring("loading", "stuff"))
    seedrnd((generateseednumber(randomseed) + $40))
    me\Field10 = -10.0
    me\Field12 = 1.0
    me\Field17 = 100.0
    me\Field18 = 1.0
    me\Field28 = 70.0
    i_005\Field0 = rand($03, $01)
    key2_spawnrate = rand($06, $01)
    remove714timer = 500.0
    removehazmattimer = 500.0
    code_dr_maynard = $00
    For local8 = $00 To $03 Step $01
        code_dr_maynard = (Int (((Float rand($09, $01)) * (10.0 ^ (Float local8))) + (Float code_dr_maynard)))
    Next
    If ((((code_dr_maynard = $1E88) Lor (code_dr_maynard = $1663)) Lor (code_dr_maynard = $96B)) <> 0) Then
        code_dr_maynard = (code_dr_maynard + $01)
    EndIf
    code_o5_council = ((code_dr_maynard Shl $01) Mod $2710)
    If (code_o5_council < $3E8) Then
        code_o5_council = (code_o5_council + $3E8)
    EndIf
    code_maintenance_tunnels = ((code_dr_maynard * $03) Mod $2710)
    If (code_maintenance_tunnels < $3E8) Then
        code_maintenance_tunnels = (code_maintenance_tunnels + $3E8)
    EndIf
    code_dr_gears = ((code_dr_maynard Shl $02) Mod $2710)
    If (code_dr_gears < $3E8) Then
        code_dr_gears = (code_dr_gears + $3E8)
    EndIf
    renderloading($37, getlocalstring("loading", "rooms"))
    If (selectedcustommap = Null) Then
        createmap()
    Else
        loadmap(("Map Creator\Maps\" + selectedcustommap\Field0))
    EndIf
    loadwaypoints($37)
    n_i\Field2 = createnpc($07, 0.0, -500.0, 0.0)
    n_i\Field3 = createnpc($06, 0.0, -500.0, 0.0)
    n_i\Field3\Field11 = (rnd(12.0, 16.0) * 4200.0)
    For local1 = Each doors
        entityparent(local1\Field0, $00, $01)
        If (local1\Field1 <> $00) Then
            entityparent(local1\Field1, $00, $01)
        EndIf
        Select local1\Field10
            Case $00,$06,$07
                moveentity(local1\Field0, 0.0, 0.0, (1.0 / 32.0))
                If (local1\Field1 <> $00) Then
                    moveentity(local1\Field1, 0.0, 0.0, (1.0 / 32.0))
                EndIf
            Case $04
                moveentity(local1\Field0, 0.359375, 0.0, 0.0)
            Case $05
                moveentity(local1\Field0, 0.265625, 0.0, 0.0)
        End Select
        If (local1\Field2 <> $00) Then
            entityparent(local1\Field2, $00, $01)
        EndIf
        For local8 = $00 To $01 Step $01
            If (local1\Field3[local8] <> $00) Then
                entityparent(local1\Field3[local8], $00, $01)
            EndIf
            If (local1\Field24[local8] <> $00) Then
                entityparent(local1\Field24[local8], $00, $01)
            EndIf
        Next
    Next
    For local2 = Each items
        entitytype(local2\Field2, $03, $00)
        entityparent(local2\Field2, $00, $01)
    Next
    For local4 = Each securitycams
        entityparent(local4\Field0, $00, $01)
        If (local4\Field2 <> $00) Then
            entityparent(local4\Field2, $00, $01)
        EndIf
    Next
    For local7 = Each props
        If (local7\Field3 <> "") Then
            local9 = loadtexture_strict(local7\Field3, $01, $00, $01)
            entitytexture(local7\Field1, local9, $00, $00)
            deletesingletextureentryfromcache(local9, $00)
            local9 = $00
            local7\Field3 = ""
        EndIf
    Next
    seedrnd((generateseednumber(randomseed) + $02))
    For local3 = Each rooms
        If (local3\Field7\Field8 < $02) Then
            If (rand($04, $01) = $01) Then
                local0 = createdecal(rand($02, $03), (local3\Field3 + rnd(-2.0, 2.0)), (local3\Field4 + 0.005), (local3\Field5 + rnd(-2.0, 2.0)), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.1, 0.4), rnd(0.85, 0.95), $00, $01, $00, $00, $00)
                entityparent(local0\Field0, local3\Field2, $01)
            EndIf
            If (rand($04, $01) = $01) Then
                local0 = createdecal($00, (local3\Field3 + rnd(-2.0, 2.0)), (local3\Field4 + 0.005), (local3\Field5 + rnd(-2.0, 2.0)), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.5, 0.7), rnd(0.7, 0.85), $00, $01, $00, $00, $00)
                entityparent(local0\Field0, local3\Field2, $01)
            EndIf
        EndIf
        If (((local3\Field7\Field6 = $03) And (opt\Field50 = $00)) <> 0) Then
            tformpoint(3584.0, 580.0, 3096.0, local3\Field2, $00)
            positionentity(me\Field60, tformedx(), tformedy(), tformedz(), $00)
            playerroom = local3
            local2 = createitem("Class D Orientation Leaflet", $00, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
            entitytype(local2\Field2, $03, $00)
            pickitem(local2, $00)
            local2\Field27 = $01
        ElseIf (((local3\Field7\Field6 = $04) And opt\Field50) <> 0) Then
            initializeintromovie = $01
            tformpoint(-4096.0, 0.0, 0.0, local3\Field2, $00)
            positionentity(me\Field60, tformedx(), 0.0, tformedz(), $00)
            playerroom = local3
        EndIf
    Next
    For local6 = Each roomtemplates
        freeentity(local6\Field0)
        local6\Field0 = $00
    Next
    For local11 = Each tempscreens
        Delete local11
    Next
    For local12 = Each tempwaypoints
        Delete local12
    Next
    For local13 = Each templights
        Delete local13
    Next
    For local14 = Each tempprops
        Delete local14
    Next
    For local15 = Each tempsoundemitters
        Delete local15
    Next
    renderloading($55, getlocalstring("loading", "events"))
    If (selectedcustommap = Null) Then
        loadevents()
    EndIf
    For local5 = Each events
        Select local5\Field0
            Case $1F
                local5\Field2 = 1.0
            Case $17
                local5\Field3 = 1.0
            Case $0C
                local5\Field4 = 1.0
        End Select
    Next
    renderloading($5A, getlocalstring("loading", "pos"))
    turnentity(me\Field60, 0.0, 180.0, 0.0, $00)
    resetentity(me\Field60)
    movemouse(mo\Field9, mo\Field10)
    setfontex(fo\Field0[$00])
    hidepointer()
    me\Field36 = 0.0
    resetrender()
    updatenpcs()
    updateworld(1.0)
    deletetextureentriesfromcache($00)
    If (mp_menugetip() <> $00) Then
        renderloading($63, "ESTABLISHING CONNECTION")
        mp_connect(mp_menugetip(), mp_menugetport())
    Else
        If (mp_ishoster() <> 0) Then
            myplayerlogic\Field0 = $01
            initializeplayer(mp_getmyindex(), mp_getserveraddress("localhost"), udpstreamport(mp_getsocket()))
            server_myplayerconnected(ue_players[mp_getmyindex()])
        Else
            ue_server\Field11 = $01
        EndIf
        renderloading($64, "")
    EndIf
    fps\Field7[$00] = 0.0
    fps\Field1 = millisecs()
    resetinput()
    catcherrors("Uncaught: InitNewGame()")
    Return $00
End Function
