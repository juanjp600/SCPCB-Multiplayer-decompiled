Function multiplayer_breach_setplayertype%(arg0%)
    Local local0.breachtypes
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local6.rooms
    Local local7.items
    Local local8.events
    Local local9.forest
    Local local10%
    Local local11.guns
    If (((arg0 = $00) And (spectate\Field1 = $FFFFFFFF)) = $00) Then
        If (((myplayer\Field51 = arg0) Or mainmenuopen) <> 0) Then
            Return $00
        EndIf
    EndIf
    local0 = getbreachtype(arg0)
    local1 = $01
    If (((arg0 = model_zombie) And (myplayer\Field51 <> model_zombie)) <> 0) Then
        local1 = $00
    EndIf
    If (((arg0 = model_035) And (myplayer\Field51 <> model_035)) <> 0) Then
        local1 = $00
    EndIf
    If (local1 <> 0) Then
        createrolecorpse(myplayer\Field51, entityx(myplayer\Field13, $00), (entityy(myplayer\Field13, $00) + 0.32), entityz(myplayer\Field13, $00), entityyaw(myplayer\Field13, $00), myplayer\Field92, $00, $00, $00, $00)
    EndIf
    local2 = myplayer\Field51
    local3 = $00
    resetplayer()
    myplayer\Field51 = (Int max(min((Float arg0), (Float (last_breach_type - $01))), 0.0))
    myplayer\Field71 = -9999.0
    myplayer\Field70 = 100.0
    myplayer\Field83 = $00
    wearinghazmat = $00
    wearinggasmask = $00
    wearingnightvision = $00
    wearing714 = $00
    wearing1499 = $00
    using294 = $00
    entitytype(collider, $02, $00)
    For local4 = $00 To $09 Step $01
        inventory(local4) = Null
    Next
    If (channelplaying(bellchannel) = $00) Then
        bellchannel = playsound_strict(loadtempsound("SFX\Ending\GateA\Bell1.ogg"))
    EndIf
    myplayer = myplayer
    b_br\Field10 = ("You are " + local0\Field0)
    myplayer\Field70 = (Float local0\Field8)
    Select local0\Field42
        Case model_096
            For local6 = Each rooms
                If (local6\Field7\Field11 = "room2servers") Then
                    positionentity(collider, entityx(local6\Field2, $00), (entityy(local6\Field2, $00) + 0.7), entityz(local6\Field2, $00), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        Case model_860
            For local8 = Each events
                If (local8\Field22 = $39) Then
                    local9 = local8\Field1\Field11
                    If (local9 <> Null) Then
                        local10 = rand($00, $01)
                        positionentity(collider, entityx(local9\Field5[local10], $01), (entityy(local9\Field5[local10], $01) + 1.5), entityz(local9\Field5[local10], $01), $01)
                        rotateentity(collider, 0.0, (entityyaw(local9\Field5[local10], $01) - 180.0), 0.0, $01)
                        moveentity(collider, -0.5, 0.0, 0.5)
                        playerroom = local8\Field1
                        local3 = $01
                        local8\Field3 = (Float (local10 = $00))
                    EndIf
                    Exit
                EndIf
            Next
        Case model_939
            For local6 = Each rooms
                If (local6\Field7\Field11 = "room3storage") Then
                    positionentity(collider, entityx(local6\Field25[$04], $01), (entityy(local6\Field25[$04], $01) + 0.4), entityz(local6\Field25[$04], $01), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        Case ntf_model
            For local6 = Each rooms
                If (local6\Field7\Field11 = "exit1") Then
                    positionentity(collider, entityx(local6\Field25[$1A], $01), (entityy(local6\Field25[$1A], $01) + 1.0), entityz(local6\Field25[$1A], $01), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
            If ((((((local2 = classd_model) Or (local2 = scientist_model)) Or (local2 = model_clerk)) Or (local2 = janitor_model)) Or (local2 = worker_model)) <> 0) Then
                steam_api_setachievement("AchvEscape")
            EndIf
            steam_api_setachievement("AchvMTF")
        Case model_049
            For local6 = Each rooms
                If (local6\Field7\Field11 = "room049") Then
                    positionentity(collider, entityx(local6\Field2, $00), (entityy(local6\Field2, $00) + 0.7), entityz(local6\Field2, $00), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        Case model_173
            For local6 = Each rooms
                If (local6\Field7\Field11 = "room2closets") Then
                    positionentity(collider, entityx(local6\Field2, $00), (entityy(local6\Field2, $00) + 0.8), entityz(local6\Field2, $00), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        Case guard_model
            For local6 = Each rooms
                If (local6\Field7\Field11 = "gateaentrance") Then
                    positionentity(collider, entityx(local6\Field2, $00), (entityy(local6\Field2, $00) + 0.7), entityz(local6\Field2, $00), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        Case haos_model
            For local6 = Each rooms
                If (local6\Field7\Field11 = "gatea") Then
                    positionentity(collider, entityx(local6\Field25[$1B], $01), (entityy(local6\Field25[$1B], $01) + 1.0), entityz(local6\Field25[$1B], $01), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
            If ((((((local2 = classd_model) Or (local2 = scientist_model)) Or (local2 = model_clerk)) Or (local2 = janitor_model)) Or (local2 = worker_model)) <> 0) Then
                steam_api_setachievement("AchvEscape")
            EndIf
        Case classd_model
            For local6 = Each rooms
                If (local6\Field7\Field11 = "start") Then
                    positionentity(collider, (entityx(local6\Field2, $00) + (3584.0 * roomscale)), (704.0 * roomscale), (entityz(local6\Field2, $00) + (1024.0 * roomscale)), $00)
                    resetentity(collider)
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        Case worker_model,janitor_model,scientist_model,model_clerk
            For local6 = Each rooms
                If (local6\Field7\Field11 = "room3storage") Then
                    positionentity(collider, entityx(local6\Field2, $00), (entityy(local6\Field2, $00) + 0.7), entityz(local6\Field2, $00), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
            If (myplayer\Field51 = scientist_model) Then
                steam_api_setachievement("AchvScientist")
            EndIf
        Case model_966
            For local6 = Each rooms
                If (local6\Field7\Field11 = "room966") Then
                    positionentity(collider, entityx(local6\Field25[$02], $01), entityy(local6\Field25[$02], $01), entityz(local6\Field25[$02], $01), $00)
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        Case model_106
            local3 = $00
            For local6 = Each rooms
                If (local6\Field7\Field11 = "room106") Then
                    positionentity(collider, entityx(local6\Field25[$0A], $01), 0.4, entityz(local6\Field25[$0A], $01), $00)
                    playerroom = local6
                    local3 = $01
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    Exit
                EndIf
            Next
            entitytype(collider, $0C, $00)
        Case $00
            spectate\Field1 = $00
            spectate\Field1 = findspectateplayer($01)
            kill("", $00)
            mousehit2 = $01
            multiplayer_updatespectate()
        Default
            local3 = $02
    End Select
    If (local3 = $00) Then
        If (((((local0\Field42 = scientist_model) Or (local0\Field42 = model_clerk)) Or (local0\Field42 = worker_model)) Or (local0\Field42 = janitor_model)) <> 0) Then
            For local6 = Each rooms
                If (local6\Field7\Field11 = "start") Then
                    positionentity(collider, (entityx(local6\Field2, $00) + (3584.0 * roomscale)), (704.0 * roomscale), (entityz(local6\Field2, $00) + (1024.0 * roomscale)), $00)
                    resetentity(collider)
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        ElseIf ((((multiplayer_isascp(local0\Field42) Or (local0\Field42 = haos_model)) Or (local0\Field42 = ntf_model)) Or (local0\Field42 = guard_model)) <> 0) Then
            For local6 = Each rooms
                If (local6\Field7\Field11 = "room2nuke") Then
                    positionentity(collider, entityx(local6\Field2, $00), (entityy(local6\Field2, $00) + 0.7), entityz(local6\Field2, $00), $00)
                    playerroom = local6
                    updatedoors()
                    updaterooms()
                    For local7 = Each items
                        local7\Field12 = 0.0
                    Next
                    local3 = $01
                    Exit
                EndIf
            Next
        EndIf
    EndIf
    b_br\Field9 = $41A
    eqquipedgun = Null
    For local11 = Each guns
        local11\Field18 = local11\Field32
        local11\Field1 = local11\Field2
    Next
    If (local0\Field42 = model_wait) Then
        If ((networkserver\Field15 And (((b_br\Field7 - millisecs()) - b_br\Field6) > $00)) <> 0) Then
            For local6 = Each rooms
                If (local6\Field7\Field11 = "173") Then
                    b_br\Field10 = ""
                    positionentity(collider, entityx(local6\Field25[$05], $01), 0.5, entityz(local6\Field25[$05], $01), $00)
                    playerroom = local6
                    local3 = $01
                    Exit
                EndIf
            Next
        EndIf
    EndIf
    scaleentity(myhitbox, local0\Field10, local0\Field11, local0\Field12, $00)
    positionentity(myhitbox, 0.0, ((- local0\Field52) + 0.05), 0.0, $00)
    If (local3 <> $02) Then
        resetentity(collider)
    EndIf
    dropspeed = 0.0
    Return $00
End Function
