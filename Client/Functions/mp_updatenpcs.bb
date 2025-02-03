Function mp_updatenpcs%()
    Local local0.npcs
    Local local1.rooms
    Local local2%
    Local local3#
    Local local4%
    Local local6#
    Local local7%
    Local local9%
    Local local10.decals
    Local local11%
    Local local12.rooms
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17#
    Local local18#
    Local local19#
    Local local20#
    catcherrors("MP_UpdateNPCs()")
    If (((mp_ishoster() = $00) And ((mp_isconnected() = $00) Lor (mp_isnpcsreceived() = $00))) <> 0) Then
        Return $00
    EndIf
    local1 = playerroom
    local2 = me\Field60
    local3 = me\Field42
    local4 = chs\Field2
    For local0 = Each npcs
        local0\Field59 = isinfacility(entityy(local0\Field3, $00))
        If ((((local0\Field84 < mp_gettimer()) Lor (local0\Field96 = Null)) Lor ((local0\Field96 <> Null) And entityhidden(local0\Field96\Field18))) <> 0) Then
            local0\Field96 = mp_npc_findnearesttarget(local0)
            If (local0\Field96 = Null) Then
                local0\Field96 = ue_players[mp_getmyindex()]
            EndIf
            local0\Field84 = (mp_gettimer() + $7D0)
        EndIf
        playerroom = local1
        me\Field60 = local2
        me\Field42 = local3
        chs\Field2 = $01
        local0\Field85 = $01
        If ((((local0\Field96 <> Null) And (entityhidden(local0\Field96\Field18) = $00)) And (mp_rooms[local0\Field96\Field22] <> Null)) <> 0) Then
            chs\Field2 = local4
            playerroom = mp_rooms[local0\Field96\Field22]
            me\Field60 = local0\Field96\Field18
            me\Field42 = local0\Field96\Field28
            local0\Field85 = (local0\Field96 = ue_players[mp_getmyindex()])
        EndIf
        currentsyncplayer = local0\Field96
        mp_updatenpc(local0)
        Select local0\Field4
            Case $07
                mp_updatenpctype173(local0)
            Case $06
                mp_updatenpctype106(local0)
            Case $05
                mp_updatenpctype096(local0)
            Case $02
                mp_updatenpctype049(local0)
            Case $03
                mp_updatenpctype049_2(local0)
            Case $14
                mp_updatenpctypeguard(local0)
            Case $00
                mp_updatenpctype008_1(local0)
            Case $01
                mp_updatenpctype035_tentacle(local0)
            Case $04
                mp_updatenpctype066(local0)
            Case $08
                mp_updatenpctype372(local0)
            Case $09
                mp_updatenpctype513_1(local0)
            Case $0A
                mp_updatenpctype860_2(local0)
            Case $0B
                mp_updatenpctype939(local0)
            Case $0C
                mp_updatenpctype966(local0)
            Case $0D
                mp_updatenpctype999(local0)
            Case $0E
                mp_updatenpctype1048(local0)
            Case $0F
                mp_updatenpctype1048_a(local0)
            Case $10
                mp_updatenpctype1499_1(local0)
            Case $11
                mp_updatenpctypeapache(local0)
            Case $13,$12
                mp_updatenpctyped_clerk(local0)
            Case $15
                mp_updatenpctypemtf(local0)
        End Select
        local6 = distancesquared(entityx(me\Field60, $00), entityx(local0\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field3, $00), 0.0, 0.0)
        If (local0\Field50 <> 0) Then
            If (1.0 = local0\Field48) Then
                entitytype(local0\Field3, $05, $00)
                local7 = $00
                Select local0\Field4
                    Case $01
                        If (548.9 < local0\Field14) Then
                            local9 = createpivot($00)
                            positionentity(local9, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00), $00)
                            turnentity(local9, 90.0, 0.0, 0.0, $00)
                            If (entitypick(local9, 0.5) <> 0) Then
                                local10 = createdecal($01, entityx(local0\Field3, $00), (pickedy() + 0.005), entityz(local0\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, 0.5, 1.0, $00, $01, $00, $00, $00)
                                local10\Field4 = 0.0005
                                local10\Field5 = 0.2
                                entityparent(local10\Field0, playerroom\Field2, $01)
                            EndIf
                            freeentity(local9)
                            local9 = $00
                            playsoundex(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"), camera, local0\Field3, 4.0, 0.8, $00, $00)
                            hideentity(local0\Field3)
                            hideentity(local0\Field0)
                            local7 = $01
                            local0\Field48 = 0.0
                        EndIf
                    Case $0F
                        hideentity(local0\Field3)
                        hideentity(local0\Field0)
                        local7 = $01
                        local0\Field43 = $01
                        local0\Field48 = 0.0
                    Case $14
                        local0\Field2 = createpivot(findchild(local0\Field0, "Thumb01.R.001"))
                        entityradius(local0\Field2, 0.35, 0.0)
                        entitypickmode(local0\Field2, $01, $00)
                        local7 = $01
                        local0\Field34 = Null
                        local0\Field51 = -1.0
                        local0\Field48 = 0.0
                    Default
                        local7 = $01
                        local0\Field34 = Null
                        local0\Field51 = -1.0
                        local0\Field48 = 0.0
                End Select
                If (local7 <> 0) Then
                    If (channelplaying(local0\Field18) <> 0) Then
                        stopchannel(local0\Field18)
                        local0\Field18 = $00
                    EndIf
                    If (local0\Field17 <> $00) Then
                        freesound_strict(local0\Field17)
                        local0\Field17 = $00
                    EndIf
                    If (channelplaying(local0\Field20) <> 0) Then
                        stopchannel(local0\Field20)
                        local0\Field20 = $00
                    EndIf
                    If (local0\Field19 <> $00) Then
                        freesound_strict(local0\Field19)
                        local0\Field19 = $00
                    EndIf
                EndIf
            EndIf
            If (local0\Field4 = $14) Then
                If (local0\Field2 <> $00) Then
                    If (1.0 > entitydistancesquared(local0\Field2, getrealcollider())) Then
                        If (entitypick(camera, 1.0) = local0\Field2) Then
                            handentity = local0\Field2
                            If (mo\Field0 <> 0) Then
                                local11 = rand($05, $01)
                                If (playerroom\Field7\Field1 = $52) Then
                                    local11 = $06
                                EndIf
                                createmsg(getlocalstring("msg", ("pickup.wpn_" + (Str local11))), 6.0)
                                handentity = $00
                                freeentity(local0\Field2)
                                local0\Field2 = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        Else
            If (local0\Field4 = $15) Then
                If (n_i\Field8 = Null) Then
                    n_i\Field8 = local0
                EndIf
                If (((n_i\Field9 = Null) And (local0 <> n_i\Field8)) <> 0) Then
                    n_i\Field9 = local0
                EndIf
            EndIf
            If (((((n_i\Field8 = Null) And (n_i\Field9 = Null)) And (20000.0 < mtftimer)) And (31000.0 > mtftimer)) <> 0) Then
                playannouncement("SFX\Character\MTF\AnnouncLost.ogg", $01)
                mtftimer = 31000.0
            EndIf
            If (((local6 < ((hidedistance * 0.6) * (hidedistance * 0.6))) Lor (local0\Field4 = $10)) <> 0) Then
                If (local0\Field59 = isinfacility(entityy(me\Field60, $00))) Then
                    translateentity(local0\Field3, 0.0, local0\Field7, 0.0, $00)
                    local13 = $00
                    local14 = countcollisions(local0\Field3)
                    For local15 = $01 To local14 Step $01
                        If ((entityy(local0\Field3, $00) - 0.01) > collisiony(local0\Field3, local15)) Then
                            local13 = $01
                            Exit
                        EndIf
                    Next
                    If (local13 <> 0) Then
                        local0\Field7 = 0.0
                    ElseIf (shouldentitiesfall <> 0) Then
                        local16 = $00
                        If (local0\Field59 = $00) Then
                            If (playerroom\Field7\Field6 <> $04) Then
                                If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
                                    If (20.0 < entityy(me\Field60, $00)) Then
                                        local16 = $01
                                    EndIf
                                EndIf
                            Else
                                local16 = $01
                            EndIf
                            If (local16 = $00) Then
                                For local12 = Each rooms
                                    If (((((0.0 <> local12\Field26) Lor (0.0 <> local12\Field23)) Lor (0.0 <> local12\Field28)) Lor (0.0 <> local12\Field25)) <> 0) Then
                                        local17 = local12\Field26
                                        local18 = local12\Field23
                                        local19 = local12\Field28
                                        local20 = local12\Field25
                                    Else
                                        local17 = 4.0
                                        local18 = 0.0
                                        local19 = 4.0
                                        local20 = 0.0
                                    EndIf
                                    If ((Abs (local17 - local18)) >= (Abs (entityx(local0\Field3, $00) - entityx(local12\Field2, $00)))) Then
                                        If ((Abs (local19 - local20)) >= (Abs (entityz(local0\Field3, $00) - entityz(local12\Field2, $00)))) Then
                                            If (local12 = playerroom) Then
                                                local16 = $01
                                                Exit
                                            EndIf
                                            If (isroomadjacent(playerroom, local12) <> 0) Then
                                                local16 = $01
                                                Exit
                                            EndIf
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        Else
                            local16 = $01
                        EndIf
                        If (local16 <> 0) Then
                            local0\Field7 = max((local0\Field7 - ((fps\Field7[$00] * 0.005) * local0\Field48)), (- local0\Field49))
                        ElseIf (0.0 < local0\Field9) Then
                            local0\Field7 = 0.0
                        Else
                            local0\Field7 = max((local0\Field7 - ((fps\Field7[$00] * 0.005) * local0\Field48)), (- local0\Field49))
                        EndIf
                    Else
                        local0\Field7 = 0.0
                    EndIf
                Else
                    local0\Field7 = 0.0
                EndIf
            Else
                local0\Field7 = 0.0
            EndIf
        EndIf
        mp_updatenpcobject(local0)
        catcherrors((((((("Uncaught: MP_UpdateNPCs(NPC Name: " + chr($22)) + local0\Field47) + chr($22)) + ", ID: ") + (Str local0\Field4)) + ")"))
    Next
    playerroom = local1
    me\Field60 = local2
    me\Field42 = local3
    chs\Field2 = local4
    currentsyncplayer = Null
    updatecameracheck()
    Return $00
End Function
