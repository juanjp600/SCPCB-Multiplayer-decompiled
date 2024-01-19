Function initnewgame%()
    Local local0%
    Local local1%
    Local local2.decals
    Local local3.doors
    Local local4.items
    Local local5.securitycams
    Local local6.events
    Local local7.rooms
    Local local8%
    Local local9%
    Local local10%
    Local local11.roomtemplates
    Local local12.tempwaypoints
    Local local13%
    Local local14.players
    Local local15%
    Local local16.waypoints
    Local local17.forest
    Local local18%
    Local local19%
    If (udp_getstream() = $00) Then
        networkserver\Field28 = $01
        networkserver\Field14 = $01
        networkserver\Field29 = $01
        multiplayer_createplayer(networkserver\Field28)
        networkserver\Field18 = $01
        myplayer\Field51 = classd_model
    EndIf
    bs_isteamfriends_setrichpresence(bs_steamfriends(), "steam_display", "#Status_Connecting")
    discord_api_setstate("Loading to game", $00)
    discord_api_setstate("", $02)
    myplayer\Field43 = $00
    myplayer\Field13 = collider
    myplayer\Field19 = myhitbox
    myplayer\Field15 = camera
    spectate\Field1 = $FFFFFFFF
    npccount = $00
    local0 = $00
    gameload = $01
    networkserver\Field26 = $00
    selected_p_page = $00
    chatscrolldragging = $00
    chatscroll = 0.0
    chatmousemem = 0.0
    drawloading(45.0, $00, $00, $00)
    hidedistance = 15.0
    heartbeatrate = 70.0
    seedrnd(generateseednumber(randomseed))
    accesscode = $00
    Repeat
        For local1 = $00 To $03 Step $01
            accesscode = (Int (((Float rand($01, $09)) * (10.0 ^ (Float local1))) + (Float accesscode)))
        Next
        If (accesscode <> $1E88) Then
            Exit
        EndIf
        accesscode = $00
    Forever
    If (networkserver\Field44 <> "") Then
        updatequery()
        loadmap(("multiplayer\serversdata\servermaps\" + networkserver\Field44))
    ElseIf (((selectedmap <> "") And (udp_getstream() = $00)) <> 0) Then
        loadmap(("Map Creator\Maps\" + selectedmap))
    Else
        createmap(($03 - networkserver\Field48))
    EndIf
    initevents()
    initwaypoints($2D)
    For local7 = Each rooms
        For local1 = $00 To local7\Field18 Step $01
            If (local7\Field16[local1] <> $00) Then
                entityparent(local7\Field16[local1], $00, $01)
            EndIf
        Next
        If (local7\Field7\Field14 = $00) Then
            If (rand($04, $01) = $01) Then
                local2 = createdecal(rand($02, $03), (entityx(local7\Field2, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local7\Field2, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                local2\Field2 = rnd(0.1, 0.4)
                scalesprite(local2\Field0, local2\Field2, local2\Field2)
                entityalpha(local2\Field0, rnd(0.85, 0.95))
            EndIf
            If (rand($04, $01) = $01) Then
                local2 = createdecal($00, (entityx(local7\Field2, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local7\Field2, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                local2\Field2 = rnd(0.5, 0.7)
                entityalpha(local2\Field0, 0.7)
                local2\Field8 = $01
                scalesprite(local2\Field0, local2\Field2, local2\Field2)
                entityalpha(local2\Field0, rnd(0.7, 0.85))
            EndIf
        EndIf
        If (((local7\Field7\Field11 = "start") And ((introenabled = $00) Or networkserver\Field15)) <> 0) Then
            positionentity(collider, (entityx(local7\Field2, $00) + (3584.0 * roomscale)), (704.0 * roomscale), (entityz(local7\Field2, $00) + (1024.0 * roomscale)), $00)
            resetentity(collider)
            playerroom = local7
            If (networkserver\Field15 = $00) Then
                If (networkserver\Field18 = $01) Then
                    giveitem("Class D Orientation Leaflet", "paper", $00)
                    giveitem("Document SCP-173", "paper", $00)
                EndIf
            EndIf
        ElseIf (local7\Field7\Field11 = "173") Then
            If (networkserver\Field15 <> 0) Then
                positionentity(collider, entityx(local7\Field25[$05], $01), 0.5, entityz(local7\Field25[$05], $01), $00)
                resetentity(collider)
                playerroom = local7
                remotedooron = $01
                For local6 = Each events
                    If (local6\Field0 = "gateaentrance") Then
                        local6\Field4 = 1.0
                        local6\Field1\Field29[$01]\Field5 = $01
                    ElseIf (local6\Field0 = "exit1") Then
                        local6\Field4 = 1.0
                        local6\Field1\Field29[$04]\Field5 = $01
                    EndIf
                Next
            ElseIf (introenabled <> 0) Then
                local8 = (Int (entityx(local7\Field2, $00) - (4248.0 * roomscale)))
                local9 = (Int (136.0 * roomscale))
                local10 = (Int (entityz(local7\Field2, $00) + (8.0 * roomscale)))
                positionentity(collider, (Float local8), ((Float local9) + 0.1), (Float local10), $00)
                resetentity(collider)
                playerroom = local7
            EndIf
        EndIf
    Next
    curr173 = createnpc($01, 0.0, -30.0, 0.0)
    curr106 = createnpc($02, 0.0, -30.0, 0.0)
    curr106\Field9 = (Float (rand($0C, $11) * $1068))
    drawloading(79.0, $00, $00, $00)
    For local3 = Each doors
        entityparent(local3\Field0, $00, $01)
        If (local3\Field1 <> $00) Then
            entityparent(local3\Field1, $00, $01)
        EndIf
        If (local3\Field2 <> $00) Then
            entityparent(local3\Field2, $00, $01)
        EndIf
        If (local3\Field3[$00] <> $00) Then
            entityparent(local3\Field3[$00], $00, $01)
        EndIf
        If (local3\Field3[$01] <> $00) Then
            entityparent(local3\Field3[$01], $00, $01)
        EndIf
        If (((local3\Field1 <> $00) And (local3\Field9 = $00)) <> 0) Then
            moveentity(local3\Field0, 0.0, 0.0, (8.0 * roomscale))
            moveentity(local3\Field1, 0.0, 0.0, (8.0 * roomscale))
        EndIf
    Next
    For local4 = Each items
        entitytype(local4\Field1, $03, $00)
        entityparent(local4\Field1, $00, $01)
    Next
    drawloading(80.0, $00, $00, $00)
    For local5 = Each securitycams
        local5\Field11 = (entityyaw(local5\Field0, $00) + local5\Field11)
        entityparent(local5\Field0, $00, $01)
    Next
    For local11 = Each roomtemplates
        freeentity(local11\Field0)
    Next
    For local12 = Each tempwaypoints
        Delete local12
    Next
    turnentity(collider, 0.0, (Float rand($A0, $C8)), 0.0, $00)
    resetentity(collider)
    For local6 = Each events
        If (local6\Field0 = "room2nuke") Then
            local6\Field2 = 1.0
            debuglog("room2nuke")
        EndIf
        If (local6\Field0 = "room106") Then
            local6\Field3 = 1.0
            debuglog("room106")
        EndIf
        If (local6\Field0 = "room2sl") Then
            local6\Field4 = 1.0
            debuglog("room2sl")
        EndIf
    Next
    For local7 = Each rooms
        For local1 = $00 To $1D Step $01
            local7\Field26[local1] = $01
        Next
        countroomtriggerbox(local7)
    Next
    movemouse(viewport_center_x, viewport_center_y)
    aasetfont(font1)
    hidepointer()
    blinktimer = -10.0
    blurtimer = 100.0
    stamina = 100.0
    For local1 = $00 To $46 Step $01
        fpsfactor = 1.0
        flushkeys()
        moveplayer($00)
        updatedoors()
        updatenpcs()
        updateworld(1.0)
        If ((Int ((Float local1) * 0.27)) <> (Int ((Float (local1 - $01)) * 0.27))) Then
            drawloading((Float ((Int ((Float local1) * 0.27)) + $50)), $00, $00, $00)
        EndIf
    Next
    freetexturecache()
    flushkeys()
    flushmouse()
    dropspeed = 0.0
    myplayer\Field43 = $01
    If (udp_getstream() <> 0) Then
        networkserver\Field4 = (millisecs() + $3A98)
        multiplayer_update()
        If (networkserver\Field15 = $00) Then
            Repeat
                If (udp_getstream() = $00) Then
                    Exit
                EndIf
                updateframe($00)
                setplayervariables()
                multiplayer_update()
                multiplayer_updateplayers()
                voice_update()
                local13 = $00
                drawloading(99.0, $00, $01, $01)
                myplayer\Field43 = $01
                For local14 = Each players
                    If (local14\Field43 <> 0) Then
                        local13 = (local13 + $01)
                    EndIf
                Next
                If (local13 >= networkserver\Field29) Then
                    Exit
                EndIf
                If (player[$01] <> Null) Then
                    If (player[$01]\Field43 = $01) Then
                        Exit
                    EndIf
                EndIf
            Forever
        EndIf
        If (networkserver\Field66 <> 0) Then
            drawloading(99.3, $00, $01, $01)
            multiplayer_loadobjects($7D, $01)
            local15 = (millisecs() + $1388)
            While (local15 > millisecs())
                updateframe($00)
                setplayervariables()
                multiplayer_update()
                multiplayer_updateplayers()
                voice_update()
                drawloading(99.3, $00, $01, $01)
                If (have_querys() <> 0) Then
                    local15 = (millisecs() + $3E8)
                EndIf
            Wend
        EndIf
        If (networkserver\Field15 <> 0) Then
            camerafognear = 0.0
            camerafogfar = hidedistance
        EndIf
        If ((((0.0 <> networkserver\Field36) Or (0.0 <> networkserver\Field37)) Or (0.0 <> networkserver\Field38)) <> 0) Then
            For local7 = Each rooms
                If (local7\Field7\Field11 = networkserver\Field39) Then
                    positionentity(collider, networkserver\Field36, networkserver\Field37, networkserver\Field38, $00)
                    resetentity(collider)
                    playerroom = local7
                    Exit
                EndIf
            Next
        EndIf
        If (getscripts() <> 0) Then
            public_inqueue($04, $01)
        EndIf
    EndIf
    setplayervariables()
    gameload = $00
    drawloading(100.0, $00, $01, $01)
    prevtime = (Float millisecs())
    For local7 = Each rooms
        If (local7\Field7\Field11 = "start") Then
            setsavingposition(local7\Field7\Field11, (entityx(local7\Field2, $00) + (3584.0 * roomscale)), (704.0 * roomscale), (entityz(local7\Field2, $00) + (1024.0 * roomscale)), 130.3)
            Exit
        EndIf
    Next
    If (networkserver\Field15 <> 0) Then
        For local16 = Each waypoints
            freeentity(local16\Field0)
            Delete local16
        Next
    EndIf
    For local17 = Each forest
        hideentity(local17\Field4)
        For local18 = $00 To $09 Step $01
            For local19 = $00 To $09 Step $01
                If (local17\Field3[((local19 * $0A) + local18)] <> $00) Then
                    hideentity(local17\Field3[((local19 * $0A) + local18)])
                EndIf
            Next
        Next
    Next
    If (menubrowser <> Null) Then
        steambrowser_destroy(menubrowser)
    EndIf
    Return $00
End Function
