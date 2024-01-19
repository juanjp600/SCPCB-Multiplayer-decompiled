Function initnewgame%()
    Local local0%
    Local local1.decals
    Local local2.doors
    Local local3.items
    Local local4.rooms
    Local local5.securitycams
    Local local6.events
    Local local7.roomtemplates
    Local local8.tempwaypoints
    Local local9.forest
    Local local10%
    Local local11%
    itemsrotaterand = rand($168, $01)
    loadnecessaryentities()
    loadentities()
    loadallsounds()
    If (player[$00] = Null) Then
        createplayer($00)
        player[$00]\Field36 = model_wait
        player[$00]\Field55 = $01
        mp_createplayerobject($00)
    EndIf
    seedrnd(generateseednumber(server\Field7))
    accesscode = $00
    Repeat
        For local0 = $00 To $03 Step $01
            accesscode = (Int (((Float rand($01, $09)) * (10.0 ^ (Float local0))) + (Float accesscode)))
        Next
        If (accesscode <> $1E88) Then
            Exit
        EndIf
        accesscode = $00
    Forever
    If (server\Field46 <> "") Then
        loadmap(server\Field46)
    Else
        createmap(server\Field7, ($03 - server\Field52))
    EndIf
    initevents()
    initwaypoints($2D)
    For local4 = Each rooms
        If (local4\Field7\Field10 = "start") Then
            positionentity(camera, entityx(local4\Field2, $00), (entityy(local4\Field2, $00) + 0.7), entityz(local4\Field2, $00), $00)
            resetentity(camera)
        EndIf
        For local0 = $00 To $20 Step $01
            If (local4\Field16[local0] <> $00) Then
                entityparent(local4\Field16[local0], $00, $01)
            EndIf
        Next
        If (local4\Field7\Field13 = $00) Then
            If (rand($04, $01) = $01) Then
                local1 = createdecal(rand($02, $03), (entityx(local4\Field2, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local4\Field2, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0)
                local1\Field2 = rnd(0.1, 0.4)
                scalesprite(local1\Field0, local1\Field2, local1\Field2)
                entityalpha(local1\Field0, rnd(0.85, 0.95))
            EndIf
            If (rand($04, $01) = $01) Then
                local1 = createdecal($00, (entityx(local4\Field2, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local4\Field2, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0)
                local1\Field2 = rnd(0.5, 0.7)
                entityalpha(local1\Field0, 0.7)
                local1\Field8 = $01
                scalesprite(local1\Field0, local1\Field2, local1\Field2)
                entityalpha(local1\Field0, rnd(0.7, 0.85))
            EndIf
        EndIf
    Next
    curr173 = createnpc($01, 0.0, -30.0, 0.0)
    curr106 = createnpc($02, 0.0, -30.0, 0.0)
    curr106\Field9 = (Float (rand($0C, $11) * $1068))
    player[$00]\Field0 = 99998.0
    player[$00]\Field1 = 20.0
    player[$00]\Field2 = 99998.0
    For local2 = Each doors
        entityparent(local2\Field0, $00, $01)
        If (local2\Field1 <> $00) Then
            entityparent(local2\Field1, $00, $01)
        EndIf
        If (local2\Field2 <> $00) Then
            entityparent(local2\Field2, $00, $01)
        EndIf
        If (local2\Field3[$00] <> $00) Then
            entityparent(local2\Field3[$00], $00, $01)
        EndIf
        If (local2\Field3[$01] <> $00) Then
            entityparent(local2\Field3[$01], $00, $01)
        EndIf
        If (((local2\Field1 <> $00) And (local2\Field9 = $00)) <> 0) Then
            moveentity(local2\Field0, 0.0, 0.0, (8.0 * roomscale))
            moveentity(local2\Field1, 0.0, 0.0, (8.0 * roomscale))
        EndIf
    Next
    For local3 = Each items
        entityparent(local3\Field1, $00, $01)
    Next
    For local5 = Each securitycams
        local5\Field11 = (entityyaw(local5\Field0, $00) + local5\Field11)
        entityparent(local5\Field0, $00, $01)
    Next
    For local7 = Each roomtemplates
        freeentity(local7\Field0)
    Next
    For local8 = Each tempwaypoints
        Delete local8
    Next
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
    For local4 = Each rooms
        For local0 = $00 To $1D Step $01
            local4\Field26[local0] = $01
        Next
        countroomtriggerbox(local4)
    Next
    blinktimer = -10.0
    blurtimer = 100.0
    stamina = 100.0
    freetexturecache()
    flushkeys()
    flushmouse()
    prevtime = (Float millisecs())
    For local9 = Each forest
        hideentity(local9\Field4)
        For local10 = $00 To $09 Step $01
            For local11 = $00 To $09 Step $01
                If (local9\Field3[((local11 * $0A) + local10)] <> $00) Then
                    hideentity(local9\Field3[((local11 * $0A) + local10)])
                EndIf
            Next
        Next
    Next
    Return $00
End Function
