Function initloadgame%()
    Local local0.doors
    Local local1.securitycams
    Local local2.roomtemplates
    Local local3.events
    Local local4%
    Local local5%
    Local local6%
    Local local7#
    Local local8#
    Local local9.chunk
    Local local10.rooms
    If (udp_getstream() = $00) Then
        networkserver\Field14 = $01
        networkserver\Field28 = $01
        multiplayer_createplayer(networkserver\Field28)
        networkserver\Field29 = $01
        networkserver\Field18 = $01
        myplayer\Field51 = classd_model
    EndIf
    discord_api_setstate("Loading to game", $00)
    discord_api_setstate("", $02)
    networkserver\Field26 = $00
    myplayer\Field43 = $00
    myplayer\Field13 = collider
    myplayer\Field19 = myhitbox
    spectate\Field1 = $FFFFFFFF
    npccount = $00
    local4 = $00
    gameload = $01
    drawloading(80.0, $00, $00, $00)
    For local0 = Each doors
        entityparent(local0\Field0, $00, $01)
        If (local0\Field1 <> $00) Then
            entityparent(local0\Field1, $00, $01)
        EndIf
        If (local0\Field2 <> $00) Then
            entityparent(local0\Field2, $00, $01)
        EndIf
        If (local0\Field3[$00] <> $00) Then
            entityparent(local0\Field3[$00], $00, $01)
        EndIf
        If (local0\Field3[$01] <> $00) Then
            entityparent(local0\Field3[$01], $00, $01)
        EndIf
    Next
    For local1 = Each securitycams
        local1\Field11 = (entityyaw(local1\Field0, $00) + local1\Field11)
        entityparent(local1\Field0, $00, $01)
    Next
    resetentity(collider)
    drawloading(90.0, $00, $00, $00)
    movemouse(viewport_center_x, viewport_center_y)
    aasetfont(font1)
    hidepointer()
    blinktimer = blinkfreq
    stamina = 100.0
    For local2 = Each roomtemplates
        If (local2\Field0 <> $00) Then
            freeentity(local2\Field0)
            local2\Field0 = $00
        EndIf
    Next
    dropspeed = 0.0
    For local3 = Each events
        If (local3\Field0 = "dimension1499") Then
            If (2.0 = local3\Field2) Then
                drawloading(91.0, $00, $00, $00)
                local3\Field1\Field25[$00] = createplane($01, $00)
                local5 = loadtexture_strict("GFX\map\dimension1499\grit3.jpg", $01)
                entitytexture(local3\Field1\Field25[$00], local5, $00, $00)
                freetexture(local5)
                positionentity(local3\Field1\Field25[$00], 0.0, entityy(local3\Field1\Field2, $00), 0.0, $00)
                entitytype(local3\Field1\Field25[$00], $01, $00)
                drawloading(92.0, $00, $00, $00)
                ntf_1499sky = sky_createsky("GFX\map\sky\1499sky", $00)
                drawloading(93.0, $00, $00, $00)
                For local6 = $01 To $0F Step $01
                    local3\Field1\Field25[local6] = loadmesh_strict((("GFX\map\dimension1499\1499object" + (Str local6)) + ".b3d"), $00)
                    hideentity(local3\Field1\Field25[local6])
                Next
                drawloading(96.0, $00, $00, $00)
                createchunkparts(local3\Field1)
                drawloading(97.0, $00, $00, $00)
                local7 = entityx(local3\Field1\Field2, $00)
                local8 = entityz(local3\Field1\Field2, $00)
                For local6 = $FFFFFFFE To $02 Step $02
                    local9 = createchunk($FFFFFFFF, (((Float local6) * 2.5) * local7), entityy(local3\Field1\Field2, $00), local8, $00)
                Next
                drawloading(98.0, $00, $00, $00)
                updatechunks(local3\Field1, $0F, $00)
                debuglog("Loaded dimension1499 successful")
                Exit
            EndIf
        EndIf
    Next
    freetexturecache()
    myplayer\Field43 = $01
    gameload = $00
    drawloading(100.0, $00, $00, $00)
    prevtime = (Float millisecs())
    fpsfactor = 0.0
    resetinput()
    camerafognear = 0.5
    camerafogfar = 6.0
    For local10 = Each rooms
        If (local10\Field7\Field11 = "start") Then
            setsavingposition(local10\Field7\Field11, (entityx(local10\Field2, $00) + (3584.0 * roomscale)), (704.0 * roomscale), (entityz(local10\Field2, $00) + (1024.0 * roomscale)), 130.3)
            Exit
        EndIf
    Next
    flushkeys()
    Return $00
End Function
