Function updateevents%()
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    Local local7.particles
    Local local8.npcs
    Local local9.rooms
    Local local10.events
    Local local11.events
    Local local12.items
    Local local13.items
    Local local14.emitters
    Local local15.securitycams
    Local local16%
    Local local17$
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22%
    Local local23%
    Local local27%
    Local local28#
    Local local29.doors
    Local local30.waypoints
    Local local31#
    Local local32.decals
    Local local33#
    Local local34%
    Local local35#
    Local local36#
    Local local37#
    Local local38%
    Local local41%
    Local local42%
    Local local43%
    Local local44%
    Local local45%[7]
    Local local46$
    Local local47%
    Local local48%
    Local local49%
    Local local50%
    Local local51.doors
    Local local52%
    Local local53%
    Local local54%
    Local local55%
    Local local56%
    Local local57%
    Local local58%
    Local local60%
    Local local61%
    Local local62%
    Local local63%
    Local local64%
    Local local65%
    Local local68.waypoints
    Local local71.waypoints
    Local local72.decals
    Local local73%
    Local local74$
    Local local75.itemtemplates
    Local local76%
    Local local77%
    Local local78%
    Local local79%
    Local local80$
    Local local81%
    Local local82%
    Local local84.forest
    Local local85#
    Local local87%
    Local local88$
    Local local91%
    Local local93#
    Local local94#
    Local local97%
    Local local98%
    Local local99%
    Local local100$
    Local local102%
    Local local105%
    Local local106%
    Local local107#
    Local local108#
    Local local109%
    Local local110%
    Local local111%
    Local local113#
    Local local114#
    Local local115%
    Local local117.dummy1499
    Local local118%
    local17 = ""
    currstepsfx = $00
    If (((quickloadpercent = $FFFFFFFF) Or (quickloadpercent = $64)) = $00) Then
        Return $01
    EndIf
    If (networkserver\Field15 <> 0) Then
        Return updatebreachevents()
    EndIf
    myplayer\Field46 = playerroom\Field7\Field11
    myplayer\Field47 = playerroom\Field65
    For local10 = Each events
        local10\Field13 = findeventobject(local10)
        local10\Field20 = calculatedist(local10\Field13, local10\Field1)
        Select local10\Field22
            Case $1869F
            Case $37
                local10\Field24 = $00
                If ((playerinroom(local10) And ((1040.0 * roomscale) < entityy(getobject(local10), $00))) <> 0) Then
                    updateending(local10)
                EndIf
                If (remotedooron = $00) Then
                    local10\Field1\Field29[$04]\Field4 = $01
                ElseIf ((remotedooron And (0.0 = local10\Field4)) <> 0) Then
                    local10\Field1\Field29[$04]\Field4 = $00
                    If (local10\Field1\Field29[$04]\Field5 <> 0) Then
                        If (((50.0 < local10\Field1\Field29[$04]\Field7) Or (0.5 > entitydistance(local10\Field13, local10\Field1\Field29[$04]\Field2))) <> 0) Then
                            local10\Field1\Field29[$04]\Field7 = min(local10\Field1\Field29[$04]\Field7, 50.0)
                            local10\Field1\Field29[$04]\Field5 = $00
                            playsound2(loadtempsound("SFX\Door\DoorError.ogg"), camera, local10\Field1\Field29[$04]\Field2, 10.0, 1.0)
                        EndIf
                    EndIf
                Else
                    local10\Field1\Field29[$04]\Field4 = $00
                    If (curr096 <> Null) Then
                        If (((0.0 = curr096\Field9) Or (5.0 = curr096\Field9)) <> 0) Then
                            local10\Field1\Field29[$00]\Field28 = updateelevators(local10\Field1\Field29[$00]\Field28, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$08], local10\Field1\Field25[$09], $01)
                        Else
                            local10\Field3 = update096elevatorevent(local10, local10\Field3, local10\Field1\Field29[$00], local10\Field1\Field25[$08])
                        EndIf
                    Else
                        local10\Field1\Field29[$00]\Field28 = updateelevators(local10\Field1\Field29[$00]\Field28, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$08], local10\Field1\Field25[$09], $01)
                    EndIf
                    entityalpha(fog, 1.0)
                EndIf
            Case $01
                If (local10\Field1\Field29[$05] = Null) Then
                    For local1 = $00 To $03 Step $01
                        If (local10\Field1\Field35[local1] <> Null) Then
                            local10\Field1\Field29[$05] = local10\Field1\Field35[local1]
                            local10\Field1\Field29[$05]\Field5 = $01
                            Exit
                        EndIf
                    Next
                EndIf
                If (0.0 = local10\Field2) Then
                    If (playerinroom(local10) <> 0) Then
                        local10\Field1\Field29[$02]\Field5 = $01
                        showentity(fog)
                        ambientlight((Float brightness), (Float brightness), (Float brightness))
                        camerafogrange(camera, camerafognear, camerafogfar)
                        camerafogmode(camera, $01)
                        If (selecteddifficulty\Field4 = $00) Then
                            msg = (("Press " + keyname(key_save)) + " to save.")
                            msgtimer = 280.0
                        ElseIf (selecteddifficulty\Field4 = $02) Then
                            msg = "Saving is only permitted on clickable monitors scattered throughout the facility."
                            msgtimer = 560.0
                        EndIf
                        curr173\Field24 = 0.0
                        While (180.0 > local10\Field1\Field29[$01]\Field7)
                            local10\Field1\Field29[$01]\Field7 = min(180.0, (local10\Field1\Field29[$01]\Field7 + 0.8))
                            moveentity(local10\Field1\Field29[$01]\Field0, (sin(local10\Field1\Field29[$01]\Field7) / 180.0), 0.0, 0.0)
                            moveentity(local10\Field1\Field29[$01]\Field1, ((- sin(local10\Field1\Field29[$01]\Field7)) / 180.0), 0.0, 0.0)
                        Wend
                        If (local10\Field1\Field32[$00] <> Null) Then
                            setnpcframe(local10\Field1\Field32[$00], 74.0)
                            local10\Field1\Field32[$00]\Field9 = 8.0
                        EndIf
                        If (local10\Field1\Field32[$01] = Null) Then
                            local10\Field1\Field32[$01] = createnpc($04, 0.0, 0.0, 0.0)
                            changenpctextureid(local10\Field1\Field32[$01], $03)
                            local10\Field1\Field32[$01]\Field23 = "GFX\npcs\scientist2.jpg"
                            changenpctextureid(local10\Field1\Field32[$01], $03)
                        EndIf
                        positionentity(local10\Field1\Field32[$01]\Field4, local10\Field1\Field3, 0.5, (local10\Field1\Field5 - 1.0), $01)
                        resetentity(local10\Field1\Field32[$01]\Field4)
                        setnpcframe(local10\Field1\Field32[$01], 210.0)
                        If (local10\Field1\Field32[$02] = Null) Then
                            local10\Field1\Field32[$02] = createnpc($03, 0.0, 0.0, 0.0)
                        EndIf
                        positionentity(local10\Field1\Field32[$02]\Field4, local10\Field1\Field3, 0.5, (local10\Field1\Field5 + (528.0 * roomscale)), $01)
                        resetentity(local10\Field1\Field32[$02]\Field4)
                        local10\Field1\Field32[$02]\Field9 = 7.0
                        pointentity(local10\Field1\Field32[$02]\Field4, local10\Field1\Field32[$01]\Field4, 0.0)
                        If (local10\Field1\Field32[$00] = Null) Then
                            local10\Field1\Field32[$03] = createnpc($03, entityx(local10\Field1\Field25[$02], $01), entityy(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))
                            rotateentity(local10\Field1\Field32[$03]\Field4, 0.0, 90.0, 0.0, $00)
                            setnpcframe(local10\Field1\Field32[$03], 286.0)
                            local10\Field1\Field32[$03]\Field9 = 8.0
                            moveentity(local10\Field1\Field32[$03]\Field4, 1.0, 0.0, 0.0)
                            local10\Field1\Field32[$04] = createnpc($04, entityx(local10\Field1\Field25[$03], $01), 0.5, entityz(local10\Field1\Field25[$03], $01))
                            setnpcframe(local10\Field1\Field32[$04], 19.0)
                            local10\Field1\Field32[$04]\Field9 = 3.0
                            rotateentity(local10\Field1\Field32[$04]\Field4, 0.0, 270.0, 0.0, $00)
                            moveentity(local10\Field1\Field32[$04]\Field4, 0.0, 0.0, 2.65)
                            local10\Field1\Field32[$05] = createnpc($04, entityx(local10\Field1\Field25[$04], $01), 0.5, entityz(local10\Field1\Field25[$04], $01))
                            changenpctextureid(local10\Field1\Field32[$05], $06)
                            setnpcframe(local10\Field1\Field32[$05], 19.0)
                            local10\Field1\Field32[$05]\Field9 = 3.0
                            rotateentity(local10\Field1\Field32[$05]\Field4, 0.0, 270.0, 0.0, $00)
                            moveentity(local10\Field1\Field32[$05]\Field4, 0.25, 0.0, 3.0)
                            rotateentity(local10\Field1\Field32[$05]\Field4, 0.0, 0.0, 0.0, $00)
                            local18 = (entityx(local10\Field1\Field2, $01) + (3712.0 * roomscale))
                            local19 = (384.0 * roomscale)
                            local20 = (entityz(local10\Field1\Field2, $01) + (1312.0 * roomscale))
                            For local1 = $03 To $05 Step $01
                                positionentity(local10\Field1\Field32[local1]\Field4, ((entityx(local10\Field1\Field32[local1]\Field4, $00) - entityx(local10\Field1\Field2, $00)) + local18), ((entityy(local10\Field1\Field32[local1]\Field4, $00) + local19) + 0.4), ((entityz(local10\Field1\Field32[local1]\Field4, $00) - entityz(local10\Field1\Field2, $00)) + local20), $00)
                                resetentity(local10\Field1\Field32[local1]\Field4)
                            Next
                        EndIf
                        If (networkserver\Field18 <> 0) Then
                            If (rand($1E, $01) = $03) Then
                                For local1 = $02 To rand($02, $03) Step $01
                                    createitem("Uranium Candy", "urancandy", entityx(collider, $00), (entityy(collider, $00) + 0.32), entityz(collider, $00), $00, $00, $00, 1.0, $00, $01)
                                    createitem("Cooked Chicken", "chicken", entityx(collider, $00), (entityy(collider, $00) + 0.32), entityz(collider, $00), $00, $00, $00, 1.0, $00, $01)
                                Next
                            EndIf
                        EndIf
                        local10\Field2 = 1.0
                    EndIf
                Else
                    local10\Field24 = $00
                    If (local10\Field1\Field32[$00] <> Null) Then
                        animatenpc(local10\Field1\Field32[$00], 249.0, 286.0, 0.4, $00)
                    EndIf
                    local17 = checktriggers(local10)
                    If (local17 = "173scene_timer") Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                    ElseIf (local17 = "173scene_activated") Then
                        local10\Field2 = max(local10\Field2, 500.0)
                    EndIf
                    If (850.0 > local10\Field2) Then
                        positionentity(curr173\Field4, (local10\Field1\Field3 + (32.0 * roomscale)), 0.31, (local10\Field1\Field5 + (1072.0 * roomscale)), $01)
                        hideentity(curr173\Field0)
                    EndIf
                    If (500.0 <= local10\Field2) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        If (0.0 = local10\Field3) Then
                            showentity(curr173\Field0)
                            If (((900.0 < local10\Field2) And local10\Field1\Field29[$05]\Field5) <> 0) Then
                                If (900.0 >= (local10\Field2 - fpsfactor)) Then
                                    local10\Field1\Field32[$01]\Field16 = loadsound_strict("SFX\Room\Intro\WhatThe.ogg")
                                    local10\Field1\Field32[$01]\Field17 = playsound2(local10\Field1\Field32[$01]\Field16, camera, local10\Field1\Field32[$01]\Field4, 10.0, 1.0)
                                EndIf
                                local10\Field1\Field32[$01]\Field9 = 3.0
                                local10\Field1\Field32[$01]\Field22 = curvevalue(-0.008, local10\Field1\Field32[$01]\Field22, 5.0)
                                animatenpc(local10\Field1\Field32[$01], 260.0, 236.0, (local10\Field1\Field32[$01]\Field22 * 18.0), $01)
                                rotateentity(local10\Field1\Field32[$01]\Field4, 0.0, 0.0, 0.0, $00)
                                If (1075.0 < local10\Field2) Then
                                    If (1.0 <> local10\Field1\Field32[$02]\Field9) Then
                                        local10\Field1\Field32[$02]\Field22 = curvevalue(-0.012, local10\Field1\Field32[$02]\Field22, 5.0)
                                        animatenpc(local10\Field1\Field32[$02], 39.0, 76.0, (local10\Field1\Field32[$02]\Field22 * 40.0), $01)
                                        moveentity(local10\Field1\Field32[$02]\Field4, 0.0, 0.0, (local10\Field1\Field32[$02]\Field22 * fpsfactor))
                                        local10\Field1\Field32[$02]\Field9 = 8.0
                                        If (local10\Field1\Field5 > entityz(local10\Field1\Field32[$02]\Field4, $00)) Then
                                            pointentity(local10\Field1\Field32[$02]\Field0, local10\Field1\Field32[$01]\Field4, 0.0)
                                            rotateentity(local10\Field1\Field32[$02]\Field4, 0.0, curveangle((entityyaw(local10\Field1\Field32[$02]\Field0, $00) - 180.0), entityyaw(local10\Field1\Field32[$02]\Field4, $00), 15.0), 0.0, $00)
                                        Else
                                            rotateentity(local10\Field1\Field32[$02]\Field4, 0.0, 0.0, 0.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                                If (1180.0 > local10\Field2) Then
                                    positionentity(curr173\Field4, (local10\Field1\Field3 + (32.0 * roomscale)), 0.31, (local10\Field1\Field5 + (1072.0 * roomscale)), $01)
                                    rotateentity(curr173\Field4, 0.0, 190.0, 0.0, $00)
                                    If (((970.0 < local10\Field2) And (1075.0 > local10\Field2)) <> 0) Then
                                        animatenpc(local10\Field1\Field32[$02], 1539.0, 1553.0, 0.2, $00)
                                        pointentity(local10\Field1\Field32[$02]\Field0, curr173\Field4, 0.0)
                                        rotateentity(local10\Field1\Field32[$02]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$02]\Field0, $00), entityyaw(local10\Field1\Field32[$02]\Field4, $00), 15.0), 0.0, $00)
                                    EndIf
                                Else
                                    If (1180.0 > (local10\Field2 - fpsfactor)) Then
                                        playsound_strict(introsfx($0B))
                                        lightblink = 3.0
                                        playsound2(stonedragsfx, camera, curr173\Field4, 10.0, 1.0)
                                        pointentity(curr173\Field4, local10\Field1\Field32[$02]\Field4, 0.0)
                                        If ((320.0 * roomscale) > entityy(local10\Field13, $00)) Then
                                            blinktimer = -10.0
                                        EndIf
                                    EndIf
                                    positionentity(curr173\Field4, (local10\Field1\Field3 - (96.0 * roomscale)), 0.31, (local10\Field1\Field5 + (592.0 * roomscale)), $01)
                                    rotateentity(curr173\Field4, 0.0, 190.0, 0.0, $00)
                                    If (((1.0 <> local10\Field1\Field32[$02]\Field9) And (0.0 <= killtimer)) <> 0) Then
                                        If (entityz(local10\Field1\Field32[$02]\Field4, $00) < (local10\Field1\Field5 - (1150.0 * roomscale))) Then
                                            local10\Field1\Field29[$05]\Field5 = $00
                                            lightblink = 3.0
                                            playsound_strict(introsfx($0B))
                                            blinktimer = -10.0
                                            playsound2(stonedragsfx, camera, curr173\Field4, 10.0, 1.0)
                                            If (((2.5 > entitydistance(curr173\Field4, local10\Field13)) And (1.0 > (Abs (entityy(local10\Field13, $00) - entityy(curr173\Field4, $00))))) <> 0) Then
                                                positionentity(curr173\Field4, entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00)
                                            Else
                                                positionentity(curr173\Field4, 0.0, 0.0, 0.0, $00)
                                            EndIf
                                            resetentity(curr173\Field4)
                                            msg = (("Hold " + keyname(key_sprint)) + " to run.")
                                            msgtimer = 560.0
                                        EndIf
                                    EndIf
                                EndIf
                                If ((((local17 = "173scene_end") And entityvisible(local10\Field1\Field32[$02]\Field4, local10\Field13)) And (notarget = $00)) <> 0) Then
                                    local10\Field1\Field32[$02]\Field9 = 1.0
                                    local10\Field1\Field32[$02]\Field11 = 1.0
                                ElseIf (((1.0 = local10\Field1\Field32[$02]\Field9) And (entityvisible(local10\Field1\Field32[$02]\Field4, local10\Field13) = $00)) <> 0) Then
                                    local10\Field1\Field32[$02]\Field9 = 0.0
                                    local10\Field1\Field32[$02]\Field11 = 0.0
                                EndIf
                                If (1.0 = local10\Field1\Field32[$02]\Field9) Then
                                    local10\Field1\Field29[$05]\Field5 = $01
                                EndIf
                            Else
                                cansave = $01
                                If (1.0 <> local10\Field1\Field32[$02]\Field9) Then
                                    If (entityx(local10\Field13, $00) < (local10\Field1\Field3 + (1384.0 * roomscale))) Then
                                        local10\Field2 = max(local10\Field2, 900.0)
                                    EndIf
                                    If (0.0 = local10\Field1\Field29[$05]\Field7) Then
                                        If (local10\Field1\Field32[$01] <> Null) Then
                                            removenpc(local10\Field1\Field32[$01], $00)
                                        EndIf
                                        If (local10\Field1\Field32[$02] <> Null) Then
                                            removenpc(local10\Field1\Field32[$02], $00)
                                        EndIf
                                        local10\Field3 = 1.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        positionentity(local10\Field1\Field25[$00], entityx(local10\Field1\Field25[$00], $01), ((- max((local10\Field2 - 1300.0), 0.0)) / 4500.0), entityz(local10\Field1\Field25[$00], $01), $01)
                        rotateentity(local10\Field1\Field25[$00], ((- max((local10\Field2 - 1320.0), 0.0)) / 130.0), 0.0, ((- max((local10\Field2 - 1300.0), 0.0)) / 40.0), $01)
                        positionentity(local10\Field1\Field25[$01], entityx(local10\Field1\Field25[$01], $01), ((- max((local10\Field2 - 1800.0), 0.0)) / 5000.0), entityz(local10\Field1\Field25[$01], $01), $01)
                        rotateentity(local10\Field1\Field25[$01], ((- max((local10\Field2 - 2040.0), 0.0)) / 135.0), 0.0, ((- max((local10\Field2 - 2040.0), 0.0)) / 43.0), $01)
                        If (2.5 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                            If (rand($12C, $01) = $02) Then
                                playsound2(decaysfx(rand($01, $03)), camera, local10\Field1\Field25[$00], 3.0, 1.0)
                            EndIf
                        EndIf
                    EndIf
                    If (2000.0 > local10\Field2) Then
                        If (local10\Field5 = $00) Then
                            local10\Field5 = playsound_strict(alarmsfx($00))
                        ElseIf (channelplaying(local10\Field5) = $00) Then
                            local10\Field5 = playsound_strict(alarmsfx($00))
                        EndIf
                    EndIf
                    If (11.0 > local10\Field4) Then
                        If (channelplaying(local10\Field6) = $00) Then
                            local10\Field4 = (local10\Field4 + 1.0)
                            If (local10\Field8 <> $00) Then
                                freesound_strict(local10\Field8)
                                local10\Field8 = $00
                            EndIf
                            local10\Field8 = loadsound_strict((("SFX\Alarm\Alarm2_" + (Str (Int local10\Field4))) + ".ogg"))
                            local10\Field6 = playsound_strict(local10\Field8)
                        ElseIf ((Int local10\Field4) = $08) Then
                            camerashake = 1.0
                        EndIf
                    EndIf
                    If (((300.0 < (local10\Field2 Mod 600.0)) And (300.0 > ((local10\Field2 + fpsfactor) Mod 600.0))) <> 0) Then
                        local1 = (Int (floor(((local10\Field2 - 5000.0) / 600.0)) + 1.0))
                        If (local1 = $00) Then
                            playsound_strict(loadtempsound("SFX\Room\Intro\PA\scripted\scripted6.ogg"))
                        EndIf
                        If (((local1 > $00) And (local1 < $1A)) <> 0) Then
                            If (commotionstate(local1) = $00) Then
                                playsound_strict(loadtempsound((("SFX\Room\Intro\Commotion\Commotion" + (Str local1)) + ".ogg")))
                                commotionstate(local1) = $01
                            EndIf
                        EndIf
                        If (local1 > $1A) Then
                            If (local10\Field1\Field32[$00] <> Null) Then
                                removenpc(local10\Field1\Field32[$00], $00)
                            EndIf
                            showentity(curr173\Field4)
                            showentity(curr173\Field0)
                            removeevent(local10)
                            debuglog("delete alarm")
                        EndIf
                    EndIf
                EndIf
            Case $00
                If (introenabled <> 0) Then
                    If ((((0.0 <= killtimer) And (0.0 = local10\Field3)) And (local10\Field1 <> Null)) <> 0) Then
                        playerzone = $00
                        If (0.0 < local10\Field4) Then
                            If (local10\Field1\Field32[$03] = Null) Then
                                For local9 = Each rooms
                                    If (local9\Field7\Field11 = "start") Then
                                        positionentity(collider, (entityx(local9\Field2, $00) + (3584.0 * roomscale)), (704.0 * roomscale), (entityz(local9\Field2, $00) + (1024.0 * roomscale)), $00)
                                        resetentity(collider)
                                        playerroom = local9
                                        Exit
                                    EndIf
                                Next
                                removeevent(local10)
                                Return $00
                            EndIf
                            shouldplay = $0D
                            currspeed = min((currspeed - (((0.008 / entitydistance(local10\Field1\Field32[$03]\Field4, collider)) * currspeed) * fpsfactor)), currspeed)
                            If (170.0 > local10\Field4) Then
                                If (1.0 = local10\Field4) Then
                                    positionentity(camera, local18, local19, local20, $00)
                                    hideentity(collider)
                                    positionentity(collider, local18, 0.302, local20, $00)
                                    rotateentity(camera, -70.0, 0.0, 0.0, $00)
                                    currmusicvolume = musicvolume
                                    stopstream_strict(musicchn)
                                    musicchn = streamsound_strict((("SFX\Music\" + music($0D)) + ".ogg"), currmusicvolume, $02)
                                    nowplaying = shouldplay
                                    playsound_strict(introsfx($0B))
                                    blurtimer = 500.0
                                    showentity(light)
                                    entityalpha(light, 0.5)
                                EndIf
                                If (3.0 > local10\Field4) Then
                                    local10\Field4 = (local10\Field4 + (fpsfactor / 100.0))
                                ElseIf (((15.0 > local10\Field4) Or (50.0 <= local10\Field4)) <> 0) Then
                                    local10\Field4 = (local10\Field4 + (fpsfactor / 30.0))
                                EndIf
                                If (15.0 > local10\Field4) Then
                                    local18 = (entityx(local10\Field1\Field2, $00) - (4248.0 * roomscale))
                                    local19 = (136.0 * roomscale)
                                    local20 = (entityz(local10\Field1\Field2, $00) + (8.0 * roomscale))
                                    If (14.0 > local10\Field4) Then
                                        mouse_x_speed_1 = 0.0
                                        mouse_y_speed_1 = 0.0
                                        If (((12.0 > (local10\Field4 - (fpsfactor / 30.0))) And (12.0 < local10\Field4)) <> 0) Then
                                            playsound2(stepsfx($00, $00, $00), camera, collider, 8.0, 0.3)
                                        EndIf
                                        showentity(light)
                                        entityalpha(light, (0.9 - (local10\Field4 / 2.0)))
                                        local18 = ((((entityx(local10\Field1\Field2, $00) - (4072.0 * roomscale)) - local18) * max(((local10\Field4 - 10.0) / 4.0), 0.0)) + local18)
                                        If (10.0 > local10\Field4) Then
                                            local19 = ((min(max(((local10\Field4 - 3.0) / 5.0), 0.0), 1.0) * 0.2) + local19)
                                        Else
                                            local19 = (((0.902 - (local19 + 0.2)) * max(((local10\Field4 - 10.0) / 4.0), 0.0)) + (local19 + 0.2))
                                        EndIf
                                        local20 = ((((entityz(local10\Field1\Field2, $00) + (104.0 * roomscale)) - local20) * min(max(((local10\Field4 - 3.0) / 5.0), 0.0), 1.0)) + local20)
                                        rotateentity(camera, (((min(max(((local10\Field4 - 3.0) / 5.0), 0.0), 1.0) * 70.0) + -70.0) + (sin((local10\Field4 * 12.857)) * 5.0)), (max(((local10\Field4 - 10.0) / 4.0), 0.0) * -60.0), (sin((local10\Field4 * 25.7)) * 8.0), $00)
                                        positionentity(camera, local18, local19, local20, $00)
                                        hideentity(collider)
                                        positionentity(collider, local18, 0.302, local20, $00)
                                        dropspeed = 0.0
                                    Else
                                        hideentity(light)
                                        positionentity(collider, entityx(collider, $00), 0.302, entityz(collider, $00), $00)
                                        resetentity(collider)
                                        showentity(collider)
                                        dropspeed = 0.0
                                        local10\Field4 = 15.0
                                        msg = "Pick up the paper on the desk."
                                        msgtimer = 490.0
                                    EndIf
                                    positionentity(collider, entityx(collider, $00), 0.302, entityz(collider, $00), $00)
                                    resetentity(collider)
                                    showentity(collider)
                                    dropspeed = 0.0
                                    user_camera_pitch = 0.0
                                    rotateentity(collider, 0.0, entityyaw(camera, $00), 0.0, $00)
                                ElseIf (40.0 > local10\Field4) Then
                                    If (inventory($00) <> Null) Then
                                        msg = (("Press " + keyname(key_inv)) + " to open the inventory.")
                                        msgtimer = 490.0
                                        local10\Field4 = 40.0
                                        Exit
                                    EndIf
                                EndIf
                                If (selecteditem <> Null) Then
                                    local10\Field4 = (local10\Field4 + (fpsfactor / 5.0))
                                EndIf
                            ElseIf (((150.0 <= local10\Field4) And (700.0 > local10\Field4)) <> 0) Then
                                If (7.0 = local10\Field1\Field32[$03]\Field9) Then
                                    If (local10\Field1\Field32[$03]\Field19 = $00) Then
                                        local10\Field1\Field32[$03]\Field19 = loadsound_strict("SFX\Room\Intro\Guard\Ulgrin\BeforeDoorOpen.ogg")
                                        local10\Field1\Field32[$03]\Field20 = playsound2(local10\Field1\Field32[$03]\Field19, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                        local10\Field24 = $00
                                        debuglog("Playing guard sound before cell opening")
                                        If (udp_network\Field0 <> $00) Then
                                            udp_writebyte($26)
                                            udp_writebyte(networkserver\Field28)
                                            udp_writefloat(local10\Field4)
                                            udp_sendmessage($00)
                                        EndIf
                                    EndIf
                                    updatesoundorigin(local10\Field1\Field32[$03]\Field20, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                    If (channelplaying(local10\Field1\Field32[$03]\Field20) = $00) Then
                                        local10\Field1\Field32[$03]\Field16 = loadsound_strict("SFX\Room\Intro\Guard\Ulgrin\ExitCell.ogg")
                                        local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                        local10\Field1\Field32[$03]\Field9 = 9.0
                                        local10\Field1\Field32[$04]\Field9 = 9.0
                                        local10\Field1\Field32[$05]\Field9 = 9.0
                                        local10\Field1\Field29[$06]\Field4 = $00
                                        usedoor(local10\Field1\Field29[$06], $00, $01, $00, "", $00)
                                        local10\Field1\Field29[$06]\Field4 = $01
                                    EndIf
                                Else
                                    freesound_strict(local10\Field1\Field32[$03]\Field19)
                                    local10\Field4 = min((local10\Field4 + (fpsfactor / 4.0)), 699.0)
                                    If (1.5 < distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), (local10\Field1\Field3 - (4096.0 * roomscale)), (local10\Field1\Field5 + (192.0 * roomscale)))) Then
                                        If (250.0 < local10\Field4) Then
                                            If (local10\Field1\Field32[$03]\Field17 <> $00) Then
                                                If (channelplaying(local10\Field1\Field32[$03]\Field17) <> 0) Then
                                                    stopchannel(local10\Field1\Field32[$03]\Field17)
                                                EndIf
                                            EndIf
                                            freesound_strict(local10\Field1\Field32[$03]\Field16)
                                            local10\Field1\Field32[$03]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Ulgrin\Escort" + (Str rand($01, $02))) + ".ogg"))
                                            local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                            local10\Field1\Field32[$03]\Field37 = findpath(local10\Field1\Field32[$03], (local10\Field1\Field3 - (320.0 * roomscale)), 0.3, (local10\Field1\Field5 - (704.0 * roomscale)))
                                            local10\Field1\Field32[$04]\Field37 = findpath(local10\Field1\Field32[$04], (local10\Field1\Field3 - (320.0 * roomscale)), 0.3, (local10\Field1\Field5 - (704.0 * roomscale)))
                                            local10\Field4 = 710.0
                                        EndIf
                                    Else
                                        local10\Field1\Field32[$03]\Field9 = 9.0
                                        If (((350.0 > (local10\Field4 - (fpsfactor / 4.0))) And (350.0 <= local10\Field4)) <> 0) Then
                                            freesound_strict(local10\Field1\Field32[$03]\Field16)
                                            local10\Field1\Field32[$03]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Ulgrin\ExitCellRefuse" + (Str rand($01, $02))) + ".ogg"))
                                            local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                        ElseIf (((550.0 > (local10\Field4 - (fpsfactor / 4.0))) And (550.0 <= local10\Field4)) <> 0) Then
                                            freesound_strict(local10\Field1\Field32[$03]\Field16)
                                            local10\Field1\Field32[$03]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Ulgrin\CellGas" + (Str rand($01, $02))) + ".ogg"))
                                            local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                        ElseIf (630.0 < local10\Field4) Then
                                            positionentity(collider, entityx(collider, $00), entityy(collider, $00), min(entityz(collider, $00), (entityz(local10\Field1\Field2, $01) + (490.0 * roomscale))), $00)
                                            If (local10\Field1\Field29[$06]\Field5 = $01) Then
                                                local10\Field1\Field29[$06]\Field4 = $00
                                                usedoor(local10\Field1\Field29[$06], $00, $01, $00, "", $00)
                                                local10\Field1\Field29[$06]\Field4 = $01
                                                local14 = createemitter((local10\Field1\Field3 - (4000.0 * roomscale)), (373.0 * roomscale), (local10\Field1\Field5 + (204.0 * roomscale)), $00, 0.0)
                                                turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                                                local14\Field10 = 7.0
                                                local14\Field9 = 0.03
                                                local14\Field11 = 0.003
                                                local14\Field7 = local10\Field1
                                                initroomforemitter(local14)
                                                local14 = createemitter((local10\Field1\Field3 - (4192.0 * roomscale)), (373.0 * roomscale), (local10\Field1\Field5 + (204.0 * roomscale)), $00, 0.0)
                                                turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                                                local14\Field10 = 7.0
                                                local14\Field9 = 0.03
                                                local14\Field11 = 0.003
                                                local14\Field7 = local10\Field1
                                                initroomforemitter(local14)
                                            EndIf
                                            eyeirritation = max(((fpsfactor * 4.0) + eyeirritation), 1.0)
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (800.0 > local10\Field4) Then
                                local10\Field4 = (local10\Field4 + (fpsfactor / 4.0))
                                If (11.0 <> local10\Field1\Field32[$05]\Field9) Then
                                    If (((5.0 < entitydistance(local10\Field1\Field32[$03]\Field4, local10\Field1\Field32[$05]\Field4)) And (Int entitydistance(local10\Field1\Field32[$04]\Field4, local10\Field1\Field32[$05]\Field4))) <> 0) Then
                                        If (3.5 > entitydistance(local10\Field1\Field32[$05]\Field4, player[local10\Field1\Field32[$05]\Field74]\Field13)) Then
                                            local10\Field1\Field32[$05]\Field9 = 11.0
                                            local10\Field1\Field32[$05]\Field11 = 1.0
                                            local10\Field1\Field32[$05]\Field20 = playsound2(local10\Field1\Field32[$05]\Field19, camera, local10\Field1\Field32[$05]\Field4, 10.0, 1.0)
                                            local10\Field1\Field32[$05]\Field25 = 210.0
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (900.0 > local10\Field4) Then
                                local10\Field1\Field32[$04]\Field15 = 0.0
                                If (((entityx(local10\Field13, $00) < (entityx(local10\Field1\Field2, $01) - (5376.0 * roomscale))) And (local10\Field11 = "")) <> 0) Then
                                    If (rand($03, $01) = $01) Then
                                        local10\Field11 = (("scripted\scripted" + (Str rand($01, $05))) + ".ogg|off.ogg|")
                                    Else
                                        local10\Field11 = (("1\attention" + (Str rand($01, $02))) + ".ogg")
                                        Select rand($03, $01)
                                            Case $01
                                                local4 = "crew"
                                                local10\Field11 = (((local10\Field11 + "|2\crew") + (Str rand($00, $05))) + ".ogg")
                                            Case $02
                                                local4 = "scientist"
                                                local10\Field11 = (((local10\Field11 + "|2\scientist") + (Str rand($00, $13))) + ".ogg")
                                            Case $03
                                                local4 = "security"
                                                local10\Field11 = (((local10\Field11 + "|2\security") + (Str rand($00, $05))) + ".ogg")
                                        End Select
                                        If (((rand($02, $01) = $01) And (local4 = "scientist")) <> 0) Then
                                            local10\Field11 = (local10\Field11 + "|3\callonline.ogg")
                                            local10\Field11 = (((local10\Field11 + "|numbers\") + (Str rand($01, $09))) + ".ogg")
                                            If (rand($02, $01) = $01) Then
                                                local10\Field11 = (((local10\Field11 + "|numbers\") + (Str rand($01, $09))) + ".ogg")
                                            EndIf
                                        Else
                                            local10\Field11 = (((local10\Field11 + "|3\report") + (Str rand($00, $01))) + ".ogg")
                                            Select local4
                                                Case "crew"
                                                    local10\Field11 = (((local10\Field11 + "|4\crew") + (Str rand($00, $06))) + ".ogg")
                                                    If (rand($02, $01) = $01) Then
                                                        local10\Field11 = (((local10\Field11 + "|5\crew") + (Str rand($00, $06))) + ".ogg")
                                                    EndIf
                                                Case "scientist"
                                                    local10\Field11 = (((local10\Field11 + "|4\scientist") + (Str rand($00, $07))) + ".ogg")
                                                    If (rand($02, $01) = $01) Then
                                                        local10\Field11 = (local10\Field11 + "|5\scientist0.ogg")
                                                    EndIf
                                                Case "security"
                                                    local10\Field11 = (((local10\Field11 + "|4\security") + (Str rand($00, $05))) + ".ogg")
                                                    If (rand($02, $01) = $01) Then
                                                        local10\Field11 = (((local10\Field11 + "|5\security") + (Str rand($01, $02))) + ".ogg")
                                                    EndIf
                                            End Select
                                        EndIf
                                        local10\Field11 = (local10\Field11 + "|off.ogg|")
                                    EndIf
                                EndIf
                                If (local10\Field1\Field32[$06] <> Null) Then
                                    If (0.0 = local10\Field1\Field32[$06]\Field9) Then
                                        If (local10\Field1\Field29[$07]\Field5 <> 0) Then
                                            If (5.0 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), (entityx(local10\Field1\Field2, $01) - (3328.0 * roomscale)), (entityz(local10\Field1\Field2, $01) - (1232.0 * roomscale)))) Then
                                                local10\Field1\Field32[$06]\Field9 = 1.0
                                                If (local10\Field11 = "done") Then
                                                    playsound_strict(loadtempsound((("SFX\Room\Intro\PA\scripted\announcement" + (Str rand($01, $07))) + ".ogg")))
                                                EndIf
                                            EndIf
                                        EndIf
                                    ElseIf (entityz(local10\Field1\Field32[$06]\Field4, $00) > (entityz(local10\Field1\Field2, $01) - (64.0 * roomscale))) Then
                                        rotateentity(local10\Field1\Field32[$06]\Field4, 0.0, curveangle(90.0, entityyaw(local10\Field1\Field32[$06]\Field4, $00), 15.0), 0.0, $00)
                                        If (local10\Field1\Field29[$07]\Field5 <> 0) Then
                                            usedoor(local10\Field1\Field29[$07], $00, $01, $00, "", $00)
                                        EndIf
                                        If (1.0 > local10\Field1\Field29[$07]\Field7) Then
                                            local10\Field1\Field32[$06]\Field9 = 0.0
                                        EndIf
                                    EndIf
                                EndIf
                                If (local10\Field1\Field32[$08] <> Null) Then
                                    If (7.0 = local10\Field1\Field32[$08]\Field9) Then
                                        If (2.5 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), (entityx(local10\Field1\Field2, $01) - (6688.0 * roomscale)), (entityz(local10\Field1\Field2, $01) - (1252.0 * roomscale)))) Then
                                            local10\Field1\Field32[$08]\Field9 = 10.0
                                            local10\Field1\Field32[$09]\Field9 = 1.0
                                            local10\Field1\Field32[$0A]\Field9 = 10.0
                                        EndIf
                                    ElseIf (entityx(local10\Field1\Field32[$08]\Field4, $00) < (entityx(local10\Field1\Field2, $01) - (7100.0 * roomscale))) Then
                                        For local1 = $08 To $0A Step $01
                                            local10\Field1\Field32[local1]\Field9 = 0.0
                                        Next
                                    EndIf
                                EndIf
                                local10\Field1\Field32[$05]\Field17 = loopsound2(local10\Field1\Field32[$05]\Field16, local10\Field1\Field32[$05]\Field17, camera, local10\Field1\Field32[$05]\Field0, 2.0, 0.5)
                                If (((local10\Field11 <> "") And (local10\Field11 <> "done")) <> 0) Then
                                    If (local10\Field5 = $00) Then
                                        local10\Field5 = playsound_strict(loadtempsound("SFX\Room\Intro\PA\on.ogg"))
                                    EndIf
                                    If (channelplaying(local10\Field5) = $00) Then
                                        local4 = left(local10\Field11, (instr(local10\Field11, "|", $01) - $01))
                                        local10\Field5 = playsound_strict(loadtempsound(("SFX\Room\Intro\PA\" + local4)))
                                        local10\Field11 = right(local10\Field11, ((len(local10\Field11) - len(local4)) - $01))
                                        If (local10\Field11 = "") Then
                                            freesound_strict(local10\Field1\Field32[$03]\Field16)
                                            local2 = rand($01, $05)
                                            local10\Field1\Field32[$03]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Conversation" + (Str local2)) + "a.ogg"))
                                            local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                            local10\Field1\Field32[$04]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Conversation" + (Str local2)) + "b.ogg"))
                                            local10\Field1\Field32[$04]\Field17 = playsound2(local10\Field1\Field32[$04]\Field16, camera, local10\Field1\Field32[$04]\Field4, 10.0, 1.0)
                                            local10\Field11 = "done"
                                        EndIf
                                    EndIf
                                EndIf
                                If (player[local10\Field1\Field32[$03]\Field74] = Null) Then
                                    local10\Field1\Field32[$03]\Field74 = findnearestid(local10\Field1\Field32[$03])
                                EndIf
                                local10\Field1\Field32[$03]\Field73 = player[local10\Field1\Field32[$03]\Field74]\Field13
                                local0 = distance(entityx(local10\Field1\Field32[$03]\Field73, $00), entityz(local10\Field1\Field32[$03]\Field73, $00), entityx(local10\Field1\Field32[$03]\Field4, $00), entityz(local10\Field1\Field32[$03]\Field4, $00))
                                If (3.0 > local0) Then
                                    local10\Field1\Field32[$03]\Field11 = min(max((local10\Field1\Field32[$03]\Field11 - fpsfactor), 0.0), 50.0)
                                Else
                                    local10\Field1\Field32[$03]\Field11 = max((local10\Field1\Field32[$03]\Field11 + fpsfactor), 50.0)
                                    If ((((560.0 <= local10\Field1\Field32[$03]\Field11) And (560.0 > (local10\Field1\Field32[$03]\Field11 - fpsfactor))) And (7.0 = local10\Field1\Field32[$03]\Field9)) <> 0) Then
                                        If (local10\Field1\Field32[$04]\Field17 <> $00) Then
                                            If (channelplaying(local10\Field1\Field32[$04]\Field17) <> 0) Then
                                                stopchannel(local10\Field1\Field32[$04]\Field17)
                                            EndIf
                                        EndIf
                                        If (2.0 > local10\Field1\Field32[$03]\Field10) Then
                                            freesound_strict(local10\Field1\Field32[$03]\Field16)
                                            local10\Field1\Field32[$03]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Ulgrin\EscortRefuse" + (Str rand($01, $02))) + ".ogg"))
                                            local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                            local10\Field1\Field32[$03]\Field11 = 50.0
                                            local10\Field1\Field32[$03]\Field10 = 3.0
                                        ElseIf (3.0 = local10\Field1\Field32[$03]\Field10) Then
                                            freesound_strict(local10\Field1\Field32[$03]\Field16)
                                            local10\Field1\Field32[$03]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Ulgrin\EscortPissedOff" + (Str rand($01, $02))) + ".ogg"))
                                            local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                            local10\Field1\Field32[$03]\Field11 = 50.0
                                            local10\Field1\Field32[$03]\Field10 = 4.0
                                        ElseIf (4.0 = local10\Field1\Field32[$03]\Field10) Then
                                            freesound_strict(local10\Field1\Field32[$03]\Field16)
                                            local10\Field1\Field32[$03]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Ulgrin\EscortKill" + (Str rand($01, $02))) + ".ogg"))
                                            local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                            local10\Field1\Field32[$03]\Field11 = 225.0
                                            local10\Field1\Field32[$03]\Field10 = 5.0
                                        ElseIf (5.0 = local10\Field1\Field32[$03]\Field10) Then
                                            local10\Field1\Field32[$03]\Field9 = 11.0
                                            local10\Field1\Field32[$04]\Field9 = 11.0
                                            local10\Field1\Field32[$05]\Field9 = 11.0
                                            local10\Field1\Field32[$03]\Field11 = 1.0
                                            local10\Field1\Field32[$04]\Field11 = 1.0
                                            local10\Field1\Field32[$05]\Field11 = 1.0
                                        EndIf
                                    EndIf
                                    If (11.0 <> local10\Field1\Field32[$05]\Field9) Then
                                        If (((5.0 < entitydistance(local10\Field1\Field32[$03]\Field4, local10\Field1\Field32[$05]\Field4)) And (Int entitydistance(local10\Field1\Field32[$04]\Field4, local10\Field1\Field32[$05]\Field4))) <> 0) Then
                                            If (3.5 > entitydistance(local10\Field1\Field32[$05]\Field4, player[local10\Field1\Field32[$05]\Field74]\Field13)) Then
                                                local10\Field1\Field32[$05]\Field9 = 11.0
                                                local10\Field1\Field32[$05]\Field11 = 1.0
                                                local10\Field1\Field32[$05]\Field20 = playsound2(local10\Field1\Field32[$05]\Field19, camera, local10\Field1\Field32[$05]\Field4, 10.0, 1.0)
                                                local10\Field1\Field32[$05]\Field25 = 210.0
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                                If (11.0 = local10\Field1\Field32[$05]\Field9) Then
                                    updatesoundorigin(local10\Field1\Field32[$05]\Field20, camera, local10\Field1\Field32[$05]\Field4, 10.0, 1.0)
                                EndIf
                                If (11.0 <> local10\Field1\Field32[$03]\Field9) Then
                                    If (local0 < min(max((4.0 - (local10\Field1\Field32[$03]\Field11 * 0.05)), 1.5), 4.0)) Then
                                        If (local10\Field1\Field32[$03]\Field37 <> $01) Then
                                            local10\Field1\Field32[$03]\Field9 = 7.0
                                            pointentity(local10\Field1\Field32[$03]\Field0, player[local10\Field1\Field32[$03]\Field74]\Field13, 0.0)
                                            rotateentity(local10\Field1\Field32[$03]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field32[$03]\Field0, $00), entityyaw(local10\Field1\Field32[$03]\Field4, $00), 20.0), 0.0, $01)
                                            If (local10\Field1\Field32[$03]\Field37 = $02) Then
                                                local10\Field1\Field32[$03]\Field37 = findpath(local10\Field1\Field32[$03], (local10\Field1\Field3 - (320.0 * roomscale)), 0.3, (local10\Field1\Field5 - (704.0 * roomscale)))
                                                local10\Field1\Field32[$04]\Field37 = findpath(local10\Field1\Field32[$04], (local10\Field1\Field3 - (320.0 * roomscale)), 0.3, (local10\Field1\Field5 - (704.0 * roomscale)))
                                                local10\Field1\Field32[$03]\Field9 = 3.0
                                            EndIf
                                        Else
                                            local10\Field1\Field32[$03]\Field9 = 3.0
                                        EndIf
                                    Else
                                        local10\Field1\Field32[$03]\Field9 = 7.0
                                        pointentity(local10\Field1\Field32[$03]\Field0, player[local10\Field1\Field32[$03]\Field74]\Field13, 0.0)
                                        rotateentity(local10\Field1\Field32[$03]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field32[$03]\Field0, $00), entityyaw(local10\Field1\Field32[$03]\Field4, $00), 20.0), 0.0, $01)
                                        If (5.5 < local0) Then
                                            local10\Field1\Field32[$03]\Field37 = $02
                                            If (0.0 = local10\Field1\Field32[$03]\Field10) Then
                                                freesound_strict(local10\Field1\Field32[$03]\Field16)
                                                local10\Field1\Field32[$03]\Field16 = loadsound_strict("SFX\Room\Intro\Guard\Ulgrin\EscortRun.ogg")
                                                local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                                playsound2(local10\Field7, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                                local10\Field1\Field32[$03]\Field10 = 1.0
                                            EndIf
                                            local10\Field1\Field32[$03]\Field9 = 5.0
                                            local10\Field1\Field32[$03]\Field33 = entityx(player[local10\Field1\Field32[$03]\Field74]\Field13, $00)
                                            local10\Field1\Field32[$03]\Field34 = entityy(player[local10\Field1\Field32[$03]\Field74]\Field13, $00)
                                            local10\Field1\Field32[$03]\Field35 = entityz(player[local10\Field1\Field32[$03]\Field74]\Field13, $00)
                                        EndIf
                                    EndIf
                                    If (player[local10\Field1\Field32[$04]\Field74] = Null) Then
                                        local10\Field1\Field32[$04]\Field74 = findnearestid(local10\Field1\Field32[$04])
                                    EndIf
                                    local10\Field1\Field32[$04]\Field73 = player[local10\Field1\Field32[$04]\Field74]\Field13
                                    local0 = distance(entityx(local10\Field1\Field32[$04]\Field73, $00), entityz(local10\Field1\Field32[$04]\Field73, $00), entityx(local10\Field1\Field32[$04]\Field4, $00), entityz(local10\Field1\Field32[$04]\Field4, $00))
                                    If (((1.5 < local0) And (entitydistance(local10\Field1\Field32[$03]\Field4, local10\Field1\Field32[$04]\Field4) > entitydistance(local10\Field1\Field32[$04]\Field4, local10\Field1\Field32[$04]\Field73))) <> 0) Then
                                        local10\Field1\Field32[$04]\Field9 = 3.0
                                    Else
                                        local10\Field1\Field32[$04]\Field9 = 5.0
                                        local10\Field1\Field32[$04]\Field33 = entityx(player[local10\Field1\Field32[$04]\Field74]\Field13, $00)
                                        local10\Field1\Field32[$04]\Field34 = entityy(player[local10\Field1\Field32[$04]\Field74]\Field13, $00)
                                        local10\Field1\Field32[$04]\Field35 = entityz(player[local10\Field1\Field32[$04]\Field74]\Field13, $00)
                                    EndIf
                                EndIf
                                local27 = $01
                                If (4.5 > distance(entityx(local10\Field1\Field32[$03]\Field4, $00), entityz(local10\Field1\Field32[$03]\Field4, $00), entityx(local10\Field1\Field29[$02]\Field2, $01), entityz(local10\Field1\Field29[$02]\Field2, $01))) Then
                                    local10\Field1\Field32[$03]\Field9 = 7.0
                                    local10\Field1\Field32[$04]\Field9 = 7.0
                                    For local1 = $01 To networkserver\Field14 Step $01
                                        If (player[local1] <> Null) Then
                                            local0 = distance(entityx(player[local1]\Field13, $00), entityz(player[local1]\Field13, $00), entityx(local10\Field1\Field29[$02]\Field2, $01), entityz(local10\Field1\Field29[$02]\Field2, $01))
                                            If (4.0 < local0) Then
                                                local27 = $00
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                Else
                                    local27 = $00
                                EndIf
                                If (local27 <> 0) Then
                                    local10\Field1\Field32[$00] = createnpc($03, entityx(local10\Field1\Field25[$00], $01), entityy(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01))
                                    local10\Field1\Field32[$00]\Field15 = 180.0
                                    local10\Field1\Field32[$01] = createnpc($04, entityx(local10\Field1\Field25[$01], $01), 0.5, entityz(local10\Field1\Field25[$01], $01))
                                    pointentity(local10\Field1\Field32[$01]\Field4, local10\Field1\Field25[$05], 0.0)
                                    local10\Field1\Field32[$02] = createnpc($04, entityx(local10\Field1\Field25[$02], $01), 0.5, entityz(local10\Field1\Field25[$02], $01))
                                    pointentity(local10\Field1\Field32[$02]\Field4, local10\Field1\Field25[$05], 0.0)
                                    changenpctextureid(local10\Field1\Field32[$02], $06)
                                    local10\Field1\Field32[$03]\Field9 = 9.0
                                    If (local10\Field1\Field32[$07]\Field17 <> $00) Then
                                        If (channelplaying(local10\Field1\Field32[$07]\Field17) <> 0) Then
                                            stopchannel(local10\Field1\Field32[$07]\Field17)
                                            freesound_strict(local10\Field1\Field32[$07]\Field16)
                                            local10\Field1\Field32[$07]\Field16 = $00
                                        EndIf
                                    EndIf
                                    freeentity(local10\Field1\Field25[$09])
                                    local10\Field1\Field25[$09] = $00
                                    freeentity(local10\Field1\Field25[$0A])
                                    local10\Field1\Field25[$0A] = $00
                                    If (local10\Field1\Field32[$05] <> Null) Then
                                        removenpc(local10\Field1\Field32[$05], $00)
                                    EndIf
                                    For local1 = $08 To $0A Step $01
                                        If (local10\Field1\Field32[local1] <> Null) Then
                                            removenpc(local10\Field1\Field32[local1], $00)
                                        EndIf
                                    Next
                                    freesound_strict(local10\Field1\Field32[$03]\Field16)
                                    local10\Field1\Field32[$03]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Ulgrin\EscortDone" + (Str rand($01, $05))) + ".ogg"))
                                    local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                    positionentity(local10\Field1\Field32[$06]\Field4, (entityx(local10\Field1\Field2, $01) - (1190.0 * roomscale)), (450.0 * roomscale), (entityz(local10\Field1\Field2, $01) + (456.0 * roomscale)), $01)
                                    resetentity(local10\Field1\Field32[$06]\Field4)
                                    pointentity(local10\Field1\Field32[$06]\Field4, local10\Field1\Field2, 0.0)
                                    local10\Field1\Field32[$06]\Field22 = 0.0
                                    local10\Field1\Field32[$06]\Field9 = 0.0
                                    local10\Field4 = 905.0
                                    local10\Field1\Field29[$03]\Field4 = $00
                                    usedoor(local10\Field1\Field29[$03], $00, $01, $00, "", $00)
                                    local10\Field1\Field29[$03]\Field4 = $01
                                    local10\Field1\Field32[$04]\Field9 = 9.0
                                    local10\Field1\Field29[$02]\Field4 = $00
                                    usedoor(local10\Field1\Field29[$02], $00, $01, $00, "", $00)
                                    local10\Field1\Field29[$02]\Field4 = $01
                                EndIf
                            ElseIf (905.0 >= local10\Field4) Then
                                If (((channelplaying(local10\Field1\Field32[$03]\Field17) = $00) And (358.0 > local10\Field1\Field32[$03]\Field14)) <> 0) Then
                                    local10\Field1\Field32[$03]\Field9 = 8.0
                                    freesound_strict(local10\Field1\Field32[$03]\Field16)
                                    local10\Field1\Field32[$03]\Field16 = loadsound_strict("SFX\Room\Intro\Guard\Ulgrin\OhAndByTheWay.ogg")
                                    local10\Field1\Field32[$03]\Field17 = playsound2(local10\Field1\Field32[$03]\Field16, camera, local10\Field1\Field32[$03]\Field4, 10.0, 1.0)
                                    setnpcframe(local10\Field1\Field32[$03], 358.0)
                                ElseIf (358.0 <= local10\Field1\Field32[$03]\Field14) Then
                                    pointentity(local10\Field1\Field32[$03]\Field4, player[local10\Field1\Field32[$03]\Field74]\Field13, 0.0)
                                    rotateentity(local10\Field1\Field32[$03]\Field4, 0.0, entityyaw(local10\Field1\Field32[$03]\Field4, $00), 0.0, $00)
                                    If (481.5 >= local10\Field1\Field32[$03]\Field14) Then
                                        local28 = local10\Field1\Field32[$03]\Field14
                                        animatenpc(local10\Field1\Field32[$03], 358.0, 482.0, 0.4, $00)
                                    Else
                                        animatenpc(local10\Field1\Field32[$03], 483.0, 607.0, 0.2, $01)
                                        If (1.5 > entitydistance(collider, local10\Field1\Field32[$03]\Field4)) Then
                                            If (entityinview(local10\Field1\Field32[$03]\Field0, camera) <> 0) Then
                                                drawhandicon = $01
                                                If (mousehit1 <> 0) Then
                                                    selecteditem = createitem("Document SCP-173", "paper", 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00, $01)
                                                    entitytype(selecteditem\Field1, $03, $00)
                                                    pickitem(selecteditem)
                                                    local10\Field4 = 910.0
                                                    If (udp_network\Field0 <> $00) Then
                                                        udp_writebyte($26)
                                                        udp_writebyte(networkserver\Field28)
                                                        udp_writefloat(local10\Field4)
                                                        udp_sendmessage($00)
                                                    EndIf
                                                    setnpcframe(local10\Field1\Field32[$03], 608.0)
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (((620.5 >= local10\Field1\Field32[$03]\Field14) And (8.0 = local10\Field1\Field32[$03]\Field9)) <> 0) Then
                                animatenpc(local10\Field1\Field32[$03], 608.0, 621.0, 0.4, $00)
                            Else
                                local10\Field1\Field32[$03]\Field15 = entityyaw(local10\Field1\Field32[$03]\Field4, $00)
                                local10\Field1\Field32[$03]\Field9 = 9.0
                                local10\Field1\Field32[$04]\Field9 = 9.0
                                usedoor(local10\Field1\Field29[$01], $00, $01, $00, "", $00)
                                local10\Field4 = 0.0
                                local10\Field1\Field32[$03]\Field9 = 0.0
                                local10\Field1\Field32[$04]\Field9 = 0.0
                            EndIf
                            If (local10\Field1\Field32[$07] <> Null) Then
                                rotateentity(local10\Field1\Field32[$07]\Field4, 0.0, ((sin((Float (millisecs2() / $14))) * 3.0) + 180.0), 0.0, $01)
                                positionentity(local10\Field1\Field32[$07]\Field4, (entityx(local10\Field1\Field2, $01) - (3361.0 * roomscale)), (-315.0 * roomscale), (entityz(local10\Field1\Field2, $01) - (2165.0 * roomscale)), $00)
                                resetentity(local10\Field1\Field32[$07]\Field4)
                                local10\Field1\Field32[$07]\Field9 = 6.0
                                setnpcframe(local10\Field1\Field32[$07], 182.0)
                                If (((1.0 = local10\Field1\Field32[$06]\Field9) And (local10\Field1\Field32[$07]\Field16 <> $00)) <> 0) Then
                                    If (local10\Field1\Field32[$07]\Field17 <> $00) Then
                                        If (channelplaying(local10\Field1\Field32[$07]\Field17) = $00) Then
                                            freesound_strict(local10\Field1\Field32[$07]\Field16)
                                            local10\Field1\Field32[$07]\Field16 = $00
                                        EndIf
                                    EndIf
                                    If (local10\Field1\Field32[$07]\Field16 <> $00) Then
                                        local10\Field1\Field32[$07]\Field17 = loopsound2(local10\Field1\Field32[$07]\Field16, local10\Field1\Field32[$07]\Field17, camera, local10\Field1\Field32[$07]\Field4, 7.0, 1.0)
                                    EndIf
                                EndIf
                            EndIf
                            For local1 = $03 To $04 Step $01
                                If (local10\Field1\Field32[local1]\Field16 <> $00) Then
                                    If (channelplaying(local10\Field1\Field32[local1]\Field17) = $00) Then
                                        freesound_strict(local10\Field1\Field32[local1]\Field16)
                                        local10\Field1\Field32[local1]\Field16 = $00
                                    Else
                                        local10\Field1\Field32[local1]\Field17 = loopsound2(local10\Field1\Field32[local1]\Field16, local10\Field1\Field32[local1]\Field17, camera, local10\Field1\Field32[local1]\Field4, 10.0, 1.0)
                                    EndIf
                                EndIf
                            Next
                        Else
                            If (introsfx($12) <> $00) Then
                                local10\Field6 = loopsound2(introsfx($12), local10\Field6, camera, local10\Field1\Field25[$04], 6.0, 1.0)
                            EndIf
                            If (0.0 = local10\Field2) Then
                                If (playerinroom(local10) <> 0) Then
                                    introsfx($00) = loadsound_strict("SFX\Room\Intro\Scientist\Franklin\EnterChamber.ogg")
                                    introsfx($01) = loadsound_strict("SFX\Room\Intro\Scientist\Franklin\Approach173.ogg")
                                    introsfx($02) = loadsound_strict("SFX\Room\Intro\Scientist\Franklin\Problem.ogg")
                                    For local1 = $04 To $06 Step $01
                                        introsfx(local1) = loadsound_strict((("SFX\Room\Intro\Scientist\Franklin\Refuse" + (Str (local1 - $03))) + ".ogg"))
                                    Next
                                    introsfx($10) = loadsound_strict("SFX\Room\Intro\Horror.ogg")
                                    introsfx($11) = loadsound_strict("SFX\Room\Intro\See173.ogg")
                                    introsfx($12) = loadsound_strict("SFX\Room\Intro\173Chamber.ogg")
                                    curr173\Field24 = 1.0
                                    local10\Field1\Field32[$03] = createnpc($03, ((local10\Field1\Field3 - (4096.0 * roomscale)) + rnd(-0.3, 0.3)), 0.3, (local10\Field1\Field5 + ((Float rand($35C, $380)) * roomscale)))
                                    rotateentity(local10\Field1\Field32[$03]\Field4, 0.0, (Float (local10\Field1\Field6 + $B4)), 0.0, $00)
                                    local10\Field1\Field32[$03]\Field9 = 7.0
                                    local10\Field1\Field32[$04] = createnpc($03, (local10\Field1\Field3 - (3840.0 * roomscale)), 0.3, (local10\Field1\Field5 + (768.0 * roomscale)))
                                    rotateentity(local10\Field1\Field32[$04]\Field4, 0.0, (Float (local10\Field1\Field6 + $87)), 0.0, $00)
                                    local10\Field1\Field32[$04]\Field9 = 7.0
                                    local10\Field1\Field32[$05] = createnpc($03, (local10\Field1\Field3 - (8288.0 * roomscale)), 0.3, (local10\Field1\Field5 + (1096.0 * roomscale)))
                                    local10\Field1\Field32[$05]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Music" + (Str rand($01, $05))) + ".ogg"))
                                    rotateentity(local10\Field1\Field32[$05]\Field4, 0.0, (Float (local10\Field1\Field6 + $B4)), 0.0, $01)
                                    local10\Field1\Field32[$05]\Field9 = 7.0
                                    local10\Field1\Field32[$05]\Field19 = loadsound_strict("SFX\Room\Intro\Guard\PlayerEscape.ogg")
                                    local10\Field1\Field32[$06] = createnpc($04, (local10\Field1\Field3 - (3712.0 * roomscale)), -0.3, (local10\Field1\Field5 - (2208.0 * roomscale)))
                                    changenpctextureid(local10\Field1\Field32[$06], $03)
                                    local10\Field1\Field32[$07] = createnpc($04, (local10\Field1\Field3 - (3712.0 * roomscale)), -0.3, (local10\Field1\Field5 - (2208.0 * roomscale)))
                                    local10\Field1\Field32[$07]\Field16 = loadsound_strict("SFX\Room\Intro\Scientist\Conversation.ogg")
                                    changenpctextureid(local10\Field1\Field32[$07], $02)
                                    local3 = createpivot($00)
                                    rotateentity(local3, 90.0, 0.0, 0.0, $00)
                                    local10\Field1\Field32[$08] = createnpc($03, (local10\Field1\Field3 - (3800.0 * roomscale)), 1.0, (local10\Field1\Field5 - (3900.0 * roomscale)))
                                    local10\Field1\Field32[$08]\Field9 = 7.0
                                    local10\Field1\Field32[$09] = createnpc($04, (local10\Field1\Field3 - (4000.0 * roomscale)), 1.1, (local10\Field1\Field5 - (3900.0 * roomscale)))
                                    local10\Field1\Field32[$09]\Field10 = 1.0
                                    local10\Field1\Field32[$09]\Field23 = "GFX\npcs\classd3.jpg"
                                    changenpctextureid(local10\Field1\Field32[$09], $09)
                                    local10\Field1\Field32[$0A] = createnpc($03, (local10\Field1\Field3 - (4200.0 * roomscale)), 1.0, (local10\Field1\Field5 - (3900.0 * roomscale)))
                                    local10\Field1\Field32[$0A]\Field9 = 7.0
                                    For local1 = $08 To $0A Step $01
                                        positionentity(local3, entityx(local10\Field1\Field32[local1]\Field4, $00), entityy(local10\Field1\Field32[local1]\Field4, $00), entityz(local10\Field1\Field32[local1]\Field4, $00), $00)
                                        entitypick(local3, 20.0)
                                        If (pickedentity() <> $00) Then
                                            positionentity(local10\Field1\Field32[local1]\Field4, pickedx(), pickedy(), pickedz(), $01)
                                            aligntovector(local10\Field1\Field32[local1]\Field4, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                                            rotateentity(local10\Field1\Field32[local1]\Field4, 0.0, 90.0, 0.0, $00)
                                        EndIf
                                    Next
                                    freeentity(local3)
                                    positionentity(curr173\Field4, entityx(local10\Field1\Field25[$05], $01), 0.5, entityz(local10\Field1\Field25[$05], $01), $00)
                                    resetentity(curr173\Field4)
                                    positionentity(collider, (local10\Field1\Field3 - (4096.0 * roomscale)), 0.3, (local10\Field1\Field5 + (192.0 * roomscale)), $00)
                                    resetentity(collider)
                                    local10\Field2 = 1.0
                                    local10\Field4 = 1.0
                                EndIf
                            ElseIf (10000.0 > local10\Field2) Then
                                If (local10\Field1\Field32[$06]\Field17 <> $00) Then
                                    If (channelplaying(local10\Field1\Field32[$06]\Field17) <> 0) Then
                                        local10\Field1\Field32[$06]\Field9 = 6.0
                                        If (325.0 <= animtime(local10\Field1\Field32[$06]\Field0)) Then
                                            animate2(local10\Field1\Field32[$06]\Field0, animtime(local10\Field1\Field32[$06]\Field0), $146, $148, 0.02, $00)
                                        Else
                                            animate2(local10\Field1\Field32[$06]\Field0, animtime(local10\Field1\Field32[$06]\Field0), $140, $148, 0.05, $00)
                                        EndIf
                                    Else
                                        animate2(local10\Field1\Field32[$06]\Field0, animtime(local10\Field1\Field32[$06]\Field0), $148, $140, -0.02, $00)
                                    EndIf
                                EndIf
                                If (introsfx($11) <> $00) Then
                                    If (entityvisible(curr173\Field4, collider) <> 0) Then
                                        If (entityinview(curr173\Field0, camera) <> 0) Then
                                            msg = (("Press " + keyname(key_blink)) + " to blink.")
                                            msgtimer = 280.0
                                            playsound_strict(introsfx($11))
                                            introsfx($11) = $00
                                        EndIf
                                    EndIf
                                EndIf
                                local10\Field2 = min((local10\Field2 + (fpsfactor / 3.0)), 5000.0)
                                If (((130.0 <= local10\Field2) And (130.0 > (local10\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                    local10\Field1\Field32[$06]\Field17 = playsound_strict(introsfx($00))
                                ElseIf (230.0 < local10\Field2) Then
                                    local2 = $01
                                    For local1 = $01 To $02 Step $01
                                        If (0.3 < distance(entityx(local10\Field1\Field32[local1]\Field4, $00), entityz(local10\Field1\Field32[local1]\Field4, $00), entityx(local10\Field1\Field25[(local1 + $02)], $01), entityz(local10\Field1\Field25[(local1 + $02)], $01))) Then
                                            pointentity(local10\Field1\Field32[local1]\Field0, local10\Field1\Field25[(local1 + $02)], 0.0)
                                            rotateentity(local10\Field1\Field32[local1]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field32[local1]\Field0, $00), entityyaw(local10\Field1\Field32[local1]\Field4, $00), 15.0), 0.0, $00)
                                            If ((Float ((local1 * $1E) + $C8)) < local10\Field2) Then
                                                local10\Field1\Field32[local1]\Field9 = 1.0
                                            EndIf
                                            local2 = $00
                                        Else
                                            local10\Field1\Field32[local1]\Field9 = 0.0
                                            pointentity(local10\Field1\Field32[local1]\Field0, local10\Field1\Field25[$05], 0.0)
                                            rotateentity(local10\Field1\Field32[local1]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field32[local1]\Field0, $00), entityyaw(local10\Field1\Field32[local1]\Field4, $00), 15.0), 0.0, $00)
                                        EndIf
                                    Next
                                    If (entityx(local10\Field13, $00) < (entityx(local10\Field1\Field2, $00) + (408.0 * roomscale))) Then
                                        If (((450.0 <= local10\Field2) And (450.0 > (local10\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                            local10\Field1\Field32[$06]\Field17 = playsound_strict(introsfx($04))
                                        ElseIf (((650.0 <= local10\Field2) And (650.0 > (local10\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                            local10\Field1\Field32[$06]\Field17 = playsound_strict(introsfx($05))
                                        ElseIf (((850.0 <= local10\Field2) And (850.0 > (local10\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                            usedoor(local10\Field1\Field29[$01], $00, $01, $00, "", $00)
                                            local10\Field1\Field32[$06]\Field17 = playsound_strict(introsfx($06))
                                        ElseIf (1000.0 < local10\Field2) Then
                                            local10\Field1\Field32[$00]\Field9 = 1.0
                                            local10\Field1\Field32[$00]\Field10 = 10.0
                                            local10\Field1\Field32[$00]\Field11 = 1.0
                                            local10\Field1\Field32[$03]\Field9 = 11.0
                                            local10\Field1\Field29[$02]\Field4 = $00
                                            usedoor(local10\Field1\Field29[$02], $00, $01, $00, "", $00)
                                            local10\Field1\Field29[$02]\Field4 = $01
                                            local10\Field3 = 1.0
                                            Exit
                                        EndIf
                                        If (850.0 < local10\Field2) Then
                                            positionentity(local10\Field13, min(entityx(local10\Field13, $00), (entityx(local10\Field1\Field2, $00) + (352.0 * roomscale))), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00)
                                        EndIf
                                    ElseIf (local2 = $01) Then
                                        local10\Field2 = 10000.0
                                        usedoor(local10\Field1\Field29[$01], $00, $01, $00, "", $00)
                                    EndIf
                                EndIf
                                local10\Field1\Field32[$06]\Field9 = 7.0
                                pointentity(local10\Field1\Field32[$06]\Field0, local10\Field13, 0.0)
                                rotateentity(local10\Field1\Field32[$06]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field32[$06]\Field0, $00), entityyaw(local10\Field1\Field32[$06]\Field4, $00), 20.0), 0.0, $01)
                                positionentity(curr173\Field4, entityx(local10\Field1\Field25[$05], $01), entityy(curr173\Field4, $00), entityz(local10\Field1\Field25[$05], $01), $00)
                                rotateentity(curr173\Field4, 0.0, 0.0, 0.0, $01)
                                resetentity(curr173\Field4)
                            ElseIf (14000.0 > local10\Field2) Then
                                local10\Field2 = min((local10\Field2 + fpsfactor), 13000.0)
                                If (10300.0 > local10\Field2) Then
                                    positionentity(local10\Field13, max(entityx(local10\Field13, $00), (entityx(local10\Field1\Field2, $00) + (352.0 * roomscale))), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00)
                                EndIf
                                local10\Field1\Field32[$06]\Field9 = 6.0
                                pointentity(local10\Field1\Field32[$06]\Field0, curr173\Field4, 0.0)
                                rotateentity(local10\Field1\Field32[$06]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field32[$06]\Field0, $00), entityyaw(local10\Field1\Field32[$06]\Field4, $00), 50.0), 0.0, $01)
                                If (((10300.0 <= local10\Field2) And (10300.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                    local10\Field5 = playsound_strict(introsfx($01))
                                    positionentity(local10\Field13, max(entityx(local10\Field13, $00), (entityx(local10\Field1\Field2, $00) + (352.0 * roomscale))), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00)
                                ElseIf (((10440.0 <= local10\Field2) And (10440.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                    usedoor(local10\Field1\Field29[$01], $00, $01, $00, "", $00)
                                    local10\Field5 = playsound_strict(introsfx($07))
                                ElseIf (((10740.0 <= local10\Field2) And (10740.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                    local10\Field5 = playsound_strict(introsfx($02))
                                ElseIf (((11145.0 <= local10\Field2) And (11145.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                    local10\Field5 = playsound_strict(introsfx($0A))
                                    local10\Field1\Field32[$01]\Field16 = loadsound_strict("SFX\Room\Intro\ClassD\DontLikeThis.ogg")
                                    playsound2(local10\Field1\Field32[$01]\Field16, camera, local10\Field1\Field32[$02]\Field4, 10.0, 1.0)
                                ElseIf (((11561.0 <= local10\Field2) And (11561.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                    local10\Field2 = 14000.0
                                    playsound_strict(introsfx($10))
                                    local10\Field1\Field32[$02]\Field16 = loadsound_strict("SFX\Room\Intro\ClassD\Breen.ogg")
                                    playsound2(local10\Field1\Field32[$02]\Field16, camera, local10\Field1\Field32[$01]\Field4, 10.0, 1.0)
                                EndIf
                                If (((10440.0 <= local10\Field2) And (11561.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                    If (12.0 <> local10\Field1\Field32[$00]\Field9) Then
                                        If (player[local10\Field1\Field32[$00]\Field74] = Null) Then
                                            local10\Field1\Field32[$00]\Field74 = findnearestid(local10\Field1\Field32[$00])
                                        EndIf
                                        local10\Field1\Field32[$00]\Field73 = player[local10\Field1\Field32[$00]\Field74]\Field13
                                        If (entityx(local10\Field1\Field29[$01]\Field2, $01) > entityx(local10\Field1\Field32[$00]\Field73, $00)) Then
                                            local10\Field1\Field32[$00]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Balcony\Alert" + (Str rand($01, $02))) + ".ogg"))
                                            local10\Field1\Field32[$00]\Field17 = playsound2(local10\Field1\Field32[$00]\Field16, camera, local10\Field1\Field32[$00]\Field4, 20.0, 1.0)
                                            local10\Field1\Field32[$00]\Field9 = 12.0
                                            local10\Field1\Field32[$00]\Field10 = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                                If (10300.0 < local10\Field2) Then
                                    If (10560.0 < local10\Field2) Then
                                        If (10750.0 > local10\Field2) Then
                                            local10\Field1\Field32[$01]\Field9 = 1.0
                                            local10\Field1\Field32[$01]\Field22 = 0.005
                                        Else
                                            local10\Field1\Field32[$01]\Field9 = 0.0
                                            local10\Field1\Field32[$01]\Field22 = curvevalue(0.0, local10\Field1\Field32[$01]\Field22, 10.0)
                                        EndIf
                                    EndIf
                                    If (325.0 <= animtime(local10\Field1\Field32[$06]\Field0)) Then
                                        animate2(local10\Field1\Field32[$06]\Field0, animtime(local10\Field1\Field32[$06]\Field0), $146, $148, 0.02, $00)
                                    Else
                                        animate2(local10\Field1\Field32[$06]\Field0, animtime(local10\Field1\Field32[$06]\Field0), $140, $148, 0.05, $00)
                                    EndIf
                                EndIf
                                positionentity(curr173\Field4, entityx(local10\Field1\Field25[$05], $01), entityy(curr173\Field4, $00), entityz(local10\Field1\Field25[$05], $01), $00)
                                rotateentity(curr173\Field4, 0.0, 0.0, 0.0, $01)
                                resetentity(curr173\Field4)
                            ElseIf (20000.0 > local10\Field2) Then
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), (entityy(curr173\Field4, $01) - 0.05), entityz(camera, $00), $00)
                                pointentity(local3, curr173\Field4, 0.0)
                                rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), 40.0), 0.0, $00)
                                turnentity(local3, 90.0, 0.0, 0.0, $00)
                                user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), 40.0)
                                user_camera_pitch = (user_camera_pitch - 90.0)
                                freeentity(local3)
                                local10\Field1\Field32[$06]\Field9 = 6.0
                                pointentity(local10\Field1\Field32[$06]\Field0, curr173\Field4, 0.0)
                                rotateentity(local10\Field1\Field32[$06]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field32[$06]\Field0, $00), entityyaw(local10\Field1\Field32[$06]\Field4, $00), 20.0), 0.0, $01)
                                animate2(local10\Field1\Field32[$06]\Field0, animtime(local10\Field1\Field32[$06]\Field0), $165, $17D, 0.05, $01)
                                local10\Field2 = min((local10\Field2 + fpsfactor), 19000.0)
                                If (14100.0 > local10\Field2) Then
                                    If (14060.0 > local10\Field2) Then
                                        blinktimer = max((((14000.0 - local10\Field2) / 2.0) - rnd(0.0, 1.0)), -10.0)
                                        If (-10.0 = blinktimer) Then
                                            pointentity(curr173\Field4, local10\Field1\Field32[$01]\Field0, 0.0)
                                            rotateentity(curr173\Field4, 0.0, entityyaw(curr173\Field4, $00), 0.0, $00)
                                            moveentity(curr173\Field4, 0.0, 0.0, ((curr173\Field21 * 0.6) * fpsfactor))
                                            curr173\Field17 = loopsound2(stonedragsfx, curr173\Field17, camera, curr173\Field4, 10.0, curr173\Field9)
                                            curr173\Field9 = curvevalue(1.0, curr173\Field9, 3.0)
                                        Else
                                            curr173\Field9 = max(0.0, (curr173\Field9 - (fpsfactor / 20.0)))
                                        EndIf
                                    ElseIf (14065.0 > local10\Field2) Then
                                        blinktimer = -10.0
                                        If (0.0 = local10\Field1\Field32[$01]\Field9) Then
                                            playsound2(necksnapsfx(rand($00, $02)), camera, curr173\Field4, 10.0, 1.0)
                                        EndIf
                                        setanimtime(local10\Field1\Field32[$01]\Field0, 0.0, $00)
                                        local10\Field1\Field32[$01]\Field9 = 6.0
                                        positionentity(curr173\Field4, entityx(local10\Field1\Field32[$01]\Field0, $00), entityy(curr173\Field4, $00), entityz(local10\Field1\Field32[$01]\Field0, $00), $00)
                                        resetentity(curr173\Field4)
                                        pointentity(curr173\Field4, local10\Field1\Field32[$02]\Field4, 0.0)
                                        local10\Field1\Field32[$02]\Field9 = 3.0
                                        rotateentity(local10\Field1\Field32[$02]\Field4, 0.0, entityyaw(local10\Field1\Field32[$02]\Field4, $00), 0.0, $00)
                                        animate2(local10\Field1\Field32[$02]\Field0, animtime(local10\Field1\Field32[$02]\Field0), $196, $17E, -0.15, $01)
                                        moveentity(local10\Field1\Field32[$02]\Field4, 0.0, 0.0, (-0.01 * fpsfactor))
                                        local10\Field1\Field32[$00]\Field9 = 12.0
                                        If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                            stopchannel(local10\Field1\Field32[$00]\Field17)
                                            freesound_strict(local10\Field1\Field32[$00]\Field16)
                                            local10\Field1\Field32[$00]\Field16 = $00
                                        EndIf
                                        local10\Field1\Field32[$00]\Field15 = 180.0
                                        local10\Field1\Field32[$00]\Field16 = loadsound_strict((("SFX\Room\Intro\Guard\Balcony\WTF" + (Str rand($01, $02))) + ".ogg"))
                                        local10\Field1\Field32[$00]\Field17 = playsound2(local10\Field1\Field32[$00]\Field16, camera, local10\Field1\Field32[$00]\Field4, 20.0, 1.0)
                                        local10\Field1\Field32[$00]\Field10 = 0.0
                                    Else
                                        animate2(local10\Field1\Field32[$01]\Field0, animtime(local10\Field1\Field32[$01]\Field0), $00, $13, 0.2, $00)
                                        If (local10\Field1\Field32[$02]\Field16 = $00) Then
                                            local10\Field1\Field32[$02]\Field16 = loadsound_strict("SFX\Room\Intro\ClassD\Gasp.ogg")
                                            playsound2(local10\Field1\Field32[$02]\Field16, camera, local10\Field1\Field32[$02]\Field4, 8.0, 1.0)
                                        EndIf
                                    EndIf
                                    If (((14080.0 < local10\Field2) And (14080.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                        playsound_strict(introsfx($0C))
                                    EndIf
                                    camerashake = 3.0
                                ElseIf (14200.0 > local10\Field2) Then
                                    animate2(local10\Field1\Field32[$01]\Field0, animtime(local10\Field1\Field32[$01]\Field0), $00, $13, 0.2, $00)
                                    local10\Field1\Field32[$00]\Field9 = 8.0
                                    If (14105.0 < local10\Field2) Then
                                        If (6.0 <> local10\Field1\Field32[$02]\Field9) Then
                                            playsound2(necksnapsfx($01), camera, local10\Field1\Field32[$02]\Field4, 8.0, 1.0)
                                        EndIf
                                        local10\Field1\Field32[$02]\Field9 = 6.0
                                        positionentity(curr173\Field4, entityx(local10\Field1\Field32[$02]\Field0, $00), entityy(curr173\Field4, $00), entityz(local10\Field1\Field32[$02]\Field0, $00), $00)
                                        resetentity(curr173\Field4)
                                        pointentity(curr173\Field4, local10\Field13, 0.0)
                                    EndIf
                                    If (14130.0 > local10\Field2) Then
                                        setanimtime(local10\Field1\Field32[$02]\Field0, 50.0, $00)
                                        blinktimer = -10.0
                                        lightblink = 1.0
                                    Else
                                        animate2(local10\Field1\Field32[$02]\Field0, animtime(local10\Field1\Field32[$02]\Field0), $32, $3C, 0.2, $00)
                                        curr173\Field24 = 0.0
                                    EndIf
                                    If (((14100.0 < local10\Field2) And (14100.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                        playsound_strict(introsfx($08))
                                    EndIf
                                    If (14150.0 > local10\Field2) Then
                                        camerashake = 5.0
                                    EndIf
                                Else
                                    animate2(local10\Field1\Field32[$02]\Field0, animtime(local10\Field1\Field32[$02]\Field0), $2D, $3C, 0.2, $00)
                                    If (14300.0 < local10\Field2) Then
                                        If (((14600.0 < local10\Field2) And (14700.0 > local10\Field2)) <> 0) Then
                                            blinktimer = -10.0
                                            lightblink = 1.0
                                        EndIf
                                        If (entityx(local10\Field13, $00) < (entityx(local10\Field1\Field2, $00) + (448.0 * roomscale))) Then
                                            local10\Field2 = 20000.0
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (30000.0 > local10\Field2) Then
                                local10\Field2 = min((local10\Field2 + fpsfactor), 30000.0)
                                If (20100.0 > local10\Field2) Then
                                    camerashake = 2.0
                                ElseIf (20200.0 > local10\Field2) Then
                                    If (((20105.0 < local10\Field2) And (20105.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                        playsound_strict(introsfx($09))
                                        positionentity(local10\Field1\Field32[$00]\Field4, (entityx(local10\Field1\Field2, $00) - (160.0 * roomscale)), (entityy(local10\Field1\Field32[$00]\Field4, $00) + 0.1), (entityz(local10\Field1\Field2, $00) + (1280.0 * roomscale)), $00)
                                        resetentity(local10\Field1\Field32[$00]\Field4)
                                        If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                            stopchannel(local10\Field1\Field32[$00]\Field17)
                                            freesound_strict(local10\Field1\Field32[$00]\Field16)
                                            local10\Field1\Field32[$00]\Field16 = $00
                                        EndIf
                                        local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\Room\Intro\Guard\Balcony\OhSh.ogg")
                                        local10\Field1\Field32[$00]\Field17 = playsound2(local10\Field1\Field32[$00]\Field16, camera, local10\Field1\Field32[$00]\Field4, 20.0, 1.0)
                                    EndIf
                                    If (20105.0 < local10\Field2) Then
                                        curr173\Field24 = 1.0
                                        pointentity(local10\Field1\Field32[$00]\Field4, curr173\Field0, 0.0)
                                        positionentity(curr173\Field4, (entityx(local10\Field1\Field2, $00) - (608.0 * roomscale)), (entityy(local10\Field1\Field2, $00) + (480.0 * roomscale)), (entityz(local10\Field1\Field2, $00) + (1312.0 * roomscale)), $00)
                                        resetentity(curr173\Field4)
                                        pointentity(curr173\Field4, local10\Field1\Field32[$00]\Field4, 0.0)
                                    EndIf
                                    blinktimer = -10.0
                                    lightblink = 1.0
                                    camerashake = 3.0
                                ElseIf (20300.0 > local10\Field2) Then
                                    pointentity(local10\Field1\Field32[$00]\Field4, curr173\Field4, 0.0)
                                    moveentity(local10\Field1\Field32[$00]\Field4, 0.0, 0.0, -0.002)
                                    local10\Field1\Field32[$00]\Field9 = 2.0
                                    updatesoundorigin(local10\Field1\Field32[$00]\Field17, camera, local10\Field1\Field32[$00]\Field4, 20.0, 1.0)
                                    If (((20260.0 < local10\Field2) And (20260.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                                        playsound_strict(introsfx($0C))
                                    EndIf
                                ElseIf (20300.0 > (local10\Field2 - fpsfactor)) Then
                                    blinktimer = -10.0
                                    lightblink = 1.0
                                    camerashake = 3.0
                                    playsound_strict(introsfx($0B))
                                    playsound2(necksnapsfx($01), camera, local10\Field1\Field32[$00]\Field4, 8.0, 1.0)
                                    curr173\Field24 = 0.0
                                    local10\Field5 = playsound_strict(introsfx($0F))
                                    positionentity(curr173\Field4, (entityx(local10\Field1\Field2, $00) - (400.0 * roomscale)), 100.0, (entityz(local10\Field1\Field2, $00) + (1072.0 * roomscale)), $00)
                                    resetentity(curr173\Field4)
                                    For local9 = Each rooms
                                        If (local9\Field7\Field11 = "start") Then
                                            debuglog("tostart")
                                            playerroom = local9
                                            local18 = (entityx(local9\Field2, $01) + (3712.0 * roomscale))
                                            local19 = (384.0 * roomscale)
                                            local20 = (entityz(local9\Field2, $01) + (1312.0 * roomscale))
                                            positionentity(collider, ((entityx(collider, $00) - entityx(local10\Field1\Field2, $00)) + local18), ((entityy(collider, $00) + local19) + 0.4), ((entityz(collider, $00) - entityz(local10\Field1\Field2, $00)) + local20), $00)
                                            dropspeed = 0.0
                                            resetentity(collider)
                                            For local1 = $00 To $02 Step $01
                                                positionentity(local10\Field1\Field32[local1]\Field4, ((entityx(local10\Field1\Field32[local1]\Field4, $00) - entityx(local10\Field1\Field2, $00)) + local18), ((entityy(local10\Field1\Field32[local1]\Field4, $00) + local19) + 0.4), ((entityz(local10\Field1\Field32[local1]\Field4, $00) - entityz(local10\Field1\Field2, $00)) + local20), $00)
                                                resetentity(local10\Field1\Field32[local1]\Field4)
                                            Next
                                            shouldplay = $00
                                            For local1 = $00 To $09 Step $01
                                                freesound_strict(introsfx(local1))
                                            Next
                                            For local1 = $10 To $12 Step $01
                                                freesound_strict(introsfx(local1))
                                            Next
                                            local9\Field32[$00] = local10\Field1\Field32[$00]
                                            local9\Field32[$00]\Field9 = 8.0
                                            For local29 = Each doors
                                                If (local29\Field13 = local10\Field1) Then
                                                    removedoor(local29)
                                                EndIf
                                            Next
                                            For local30 = Each waypoints
                                                If (local30\Field2 = local10\Field1) Then
                                                    freeentity(local30\Field0)
                                                    Delete local30
                                                EndIf
                                            Next
                                            local9\Field32[$01] = local10\Field1\Field32[$06]
                                            For local15 = Each securitycams
                                                If (local15\Field20 = local10\Field1) Then
                                                    Delete local15
                                                EndIf
                                            Next
                                            showentity(fog)
                                            ambientlight((Float brightness), (Float brightness), (Float brightness))
                                            camerafogrange(camera, camerafognear, camerafogfar)
                                            camerafogmode(camera, $01)
                                            local10\Field3 = 1.0
                                            removeevent(local10)
                                            delay($64)
                                            Return $00
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        EndIf
                    Else
                        If (0.0 > killtimer) Then
                            If (1.0 = local10\Field1\Field32[$03]\Field9) Then
                                loadeventsound(local10, "SFX\Room\Intro\Guard\Ulgrin\EscortTerminated.ogg", $00)
                                playsound_strict(local10\Field7)
                            EndIf
                        EndIf
                        For local1 = $00 To $06 Step $01
                            If (introsfx(local1) <> $00) Then
                                freesound_strict(introsfx(local1))
                                introsfx(local1) = $00
                            EndIf
                        Next
                        freesound_strict(introsfx($10))
                        introsfx($10) = $00
                        local10\Field3 = 1.0
                    EndIf
                EndIf
                If ((playerinroom(local10) And introenabled) <> 0) Then
                    If (10.0 <= local10\Field2) Then
                        camerarange(camera, 0.05, 15.0)
                        If (local10\Field1\Field32[$07] <> Null) Then
                            removenpc(local10\Field1\Field32[$07], $00)
                        EndIf
                    Else
                        camerarange(camera, 0.05, 40.0)
                    EndIf
                    camerafogmode(camera, $00)
                    ambientlight(140.0, 140.0, 140.0)
                    hideentity(fog)
                    lightvolume = 4.0
                    templightvolume = 4.0
                    If (((40.0 <= local10\Field4) And (50.0 > local10\Field4)) <> 0) Then
                        If (invopen <> 0) Then
                            msg = "Double click on the document to view it."
                            msgtimer = 490.0
                            local10\Field4 = 50.0
                        EndIf
                    EndIf
                Else
                    removeevent(local10)
                EndIf
            Case $2E
                If (playerinroom(local10) <> 0) Then
                    If (1.8 > entitydistance(local10\Field13, local10\Field1\Field25[$00])) Then
                        If (0.0 = local10\Field2) Then
                            giveachievement($11, $01)
                            local10\Field5 = playsound2(buttghostsfx, camera, local10\Field1\Field25[$00], 10.0, 1.0)
                            local10\Field2 = 1.0
                        ElseIf (channelplaying(local10\Field5) = $00) Then
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $3B
                If (playerroom = local10\Field1) Then
                    If (((0.0 < local10\Field2) And (7.0 > local10\Field2)) <> 0) Then
                        cansave = $00
                    EndIf
                    If (1.0 = local10\Field2) Then
                        previnjuries = injuries
                        prevbloodloss = bloodloss
                        prevsecondarylighton = secondarylighton
                        secondarylighton = 1.0
                        local10\Field1\Field25[$1B] = loadanimmesh_strict("GFX\npcs\naziofficer.b3d", $00)
                        rotateentity(local10\Field1\Field25[$1B], entitypitch(local10\Field1\Field25[$1B], $00), entityyaw(local10\Field1\Field25[$1B], $00), entityroll(local10\Field1\Field25[$1B], $00), $00)
                        entitytype(local10\Field1\Field25[$1B], $01, $00)
                        local10\Field1\Field25[$1C] = createpivot($00)
                        entityradius(local10\Field1\Field25[$1C], 0.32, 0.0)
                        entitytype(local10\Field1\Field25[$1C], $02, $00)
                        local31 = (0.5 / meshwidth(local10\Field1\Field25[$1B]))
                        scaleentity(local10\Field1\Field25[$1B], local31, local31, local31, $00)
                        positionentity(collider, entityx(local10\Field1\Field25[$04], $01), entityy(local10\Field1\Field25[$04], $01), entityz(local10\Field1\Field25[$04], $01), $01)
                        resetentity(collider)
                        camerashake = 1.0
                        blurtimer = 1200.0
                        injuries = 1.0
                        local10\Field2 = 2.0
                    ElseIf (2.0 = local10\Field2) Then
                        local10\Field3 = (local10\Field3 + fpsfactor)
                        pointentity(local10\Field1\Field25[$1B], collider, 0.0)
                        rotateentity(local10\Field1\Field25[$1B], 0.0, (entityyaw(local10\Field1\Field25[$1B], $00) - 180.0), 0.0, $00)
                        blurtimer = max(blurtimer, 100.0)
                        If (((200.0 < local10\Field3) And (200.0 >= (local10\Field3 - fpsfactor))) <> 0) Then
                            local10\Field7 = loadsound_strict("SFX\Music\1123.ogg")
                            local10\Field5 = playsound_strict(local10\Field7)
                        EndIf
                        If (1000.0 < local10\Field3) Then
                            If (local10\Field8 = $00) Then
                                local10\Field8 = loadsound_strict("SFX\Door\1123DoorOpen.ogg")
                                local10\Field6 = playsound_strict(local10\Field8)
                            EndIf
                            rotateentity(local10\Field1\Field25[$0B], 0.0, curveangle(10.0, entityyaw(local10\Field1\Field25[$0B], $00), 40.0), 0.0, $00)
                            If (((1040.0 <= local10\Field3) And (1040.0 > (local10\Field3 - fpsfactor))) <> 0) Then
                                playsound2(loadtempsound("SFX\SCP\1123\Officer1.ogg"), camera, local10\Field1\Field25[$1B], 10.0, 1.0)
                            ElseIf (((1400.0 <= local10\Field3) And (1400.0 > (local10\Field3 - fpsfactor))) <> 0) Then
                                playsound2(loadtempsound("SFX\SCP\1123\Officer2.ogg"), camera, local10\Field1\Field25[$1B], 10.0, 1.0)
                            EndIf
                            animate2(local10\Field1\Field25[$1B], animtime(local10\Field1\Field25[$1B]), $03, $1A, 0.2, $01)
                            If ((392.0 * roomscale) < entitydistance(collider, local10\Field1\Field25[$04])) Then
                                blinktimer = -10.0
                                blurtimer = 500.0
                                positionentity(collider, entityx(local10\Field1\Field25[$05], $01), entityy(local10\Field1\Field25[$05], $01), entityz(local10\Field1\Field25[$05], $01), $01)
                                rotateentity(collider, 0.0, (entityyaw(local10\Field1\Field2, $01) + 180.0), 0.0, $00)
                                resetentity(collider)
                                local10\Field2 = 3.0
                            EndIf
                        EndIf
                    ElseIf (3.0 = local10\Field2) Then
                        If (160.0 < local10\Field1\Field29[$00]\Field7) Then
                            If (local10\Field7 = $00) Then
                                local10\Field7 = loadsound_strict("SFX\Music\1123.ogg")
                            EndIf
                            local10\Field5 = playsound_strict(local10\Field7)
                            positionentity(local10\Field1\Field25[$1B], entityx(local10\Field1\Field25[$07], $01), (entityy(local10\Field1\Field25[$07], $01) - 0.32), entityz(local10\Field1\Field25[$07], $01), $00)
                            positionentity(local10\Field1\Field25[$1C], entityx(local10\Field1\Field25[$07], $01), entityy(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field25[$07], $01), $00)
                            local10\Field2 = 4.0
                        EndIf
                    ElseIf (4.0 = local10\Field2) Then
                        tformpoint(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00, local10\Field1\Field2)
                        If (((256.0 > tformedx()) And (-480.0 < tformedz())) <> 0) Then
                            local10\Field1\Field29[$00]\Field5 = $00
                        EndIf
                        If (0.0 = entityyaw(local10\Field1\Field25[$0D], $00)) Then
                            debuglog("aaaaaaaa")
                            If (1.0 > entitydistance(collider, local10\Field1\Field25[$0C])) Then
                                drawhandicon = $01
                                If (mousehit1 <> 0) Then
                                    rotateentity(local10\Field1\Field25[$0D], 0.0, 1.0, 0.0, $00)
                                    rotateentity(local10\Field1\Field25[$0B], 0.0, 90.0, 0.0, $00)
                                    playsound_strict(loadtempsound("SFX\SCP\1123\Horror.ogg"))
                                EndIf
                            EndIf
                        Else
                            debuglog("bbbbbbb")
                            rotateentity(local10\Field1\Field25[$0D], 0.0, curveangle(90.0, entityyaw(local10\Field1\Field25[$0D], $00), 40.0), 0.0, $00)
                            If (30.0 < entityyaw(local10\Field1\Field25[$0D], $00)) Then
                                pointentity(local10\Field1\Field25[$1B], collider, 0.0)
                                rotateentity(local10\Field1\Field25[$1B], 0.0, (entityyaw(local10\Field1\Field25[$1B], $00) - 180.0), 0.0, $00)
                                animate2(local10\Field1\Field25[$1B], animtime(local10\Field1\Field25[$1B]), $1B, $36, 0.5, $00)
                                If (54.0 <= animtime(local10\Field1\Field25[$1B])) Then
                                    local10\Field2 = 5.0
                                    local10\Field3 = 0.0
                                    positionentity(collider, entityx(local10\Field1\Field2, $01), 0.3, entityz(local10\Field1\Field2, $01), $01)
                                    resetentity(collider)
                                    blinktimer = -10.0
                                    blurtimer = 500.0
                                    injuries = 1.5
                                    bloodloss = 70.0
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (5.0 = local10\Field2) Then
                        local10\Field3 = (local10\Field3 + fpsfactor)
                        If (500.0 < local10\Field3) Then
                            rotateentity(local10\Field1\Field25[$09], 0.0, 90.0, 0.0, $00)
                            rotateentity(local10\Field1\Field25[$0D], 0.0, 0.0, 0.0, $00)
                            local18 = ((entityx(local10\Field1\Field25[$08], $01) + entityx(local10\Field1\Field25[$0C], $01)) / 2.0)
                            local19 = entityy(local10\Field1\Field25[$05], $01)
                            local20 = ((entityz(local10\Field1\Field25[$08], $01) + entityz(local10\Field1\Field25[$0C], $01)) / 2.0)
                            positionentity(collider, local18, local19, local20, $01)
                            resetentity(collider)
                            local18 = ((entityx(collider, $01) + entityx(local10\Field1\Field25[$0C], $01)) / 2.0)
                            local20 = ((entityz(collider, $01) + entityz(local10\Field1\Field25[$0C], $01)) / 2.0)
                            positionentity(local10\Field1\Field25[$1B], local18, (local19 - 0.32), local20, $00)
                            positionentity(local10\Field1\Field25[$1C], local18, (local19 + 0.2), local20, $00)
                            injuries = 1.5
                            bloodloss = 70.0
                            blinktimer = -10.0
                            local32 = createdecal($03, entityx(collider, $00), ((512.0 * roomscale) + 0.0005), entityz(collider, $00), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.5
                            scalesprite(local32\Field0, local32\Field2, local32\Field2)
                            local10\Field8 = loadsound_strict("SFX\SCP\1123\Officer3.ogg")
                            local10\Field2 = 6.0
                        EndIf
                    ElseIf (6.0 = local10\Field2) Then
                        pointentity(local10\Field1\Field25[$1B], collider, 0.0)
                        rotateentity(local10\Field1\Field25[$1B], 0.0, (entityyaw(local10\Field1\Field25[$1B], $00) - 180.0), 0.0, $00)
                        animate2(local10\Field1\Field25[$1B], animtime(local10\Field1\Field25[$1B]), $4B, $80, 0.04, $01)
                        If (local10\Field8 <> $00) Then
                            If (local10\Field6 <> $00) Then
                                If (channelplaying(local10\Field5) = $00) Then
                                    playsound_strict(loadtempsound("SFX\SCP\1123\Gunshot.ogg"))
                                    local10\Field2 = 7.0
                                    freesound_strict(local10\Field8)
                                    local10\Field8 = $00
                                EndIf
                            EndIf
                            If (local10\Field8 <> $00) Then
                                local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local10\Field1\Field25[$1B], 7.0, 1.0)
                            EndIf
                        EndIf
                    ElseIf (7.0 = local10\Field2) Then
                        positionentity(collider, entityx(local10\Field1\Field2, $01), 0.3, entityz(local10\Field1\Field2, $01), $01)
                        resetentity(collider)
                        showentity(light)
                        lightflash = 6.0
                        blurtimer = 500.0
                        injuries = previnjuries
                        bloodloss = prevbloodloss
                        secondarylighton = prevsecondarylighton
                        rotateentity(local10\Field1\Field25[$09], 0.0, 0.0, 0.0, $00)
                        previnjuries = 0.0
                        prevbloodloss = 0.0
                        prevsecondarylighton = 0.0
                        crouch = $00
                        cansave = $01
                        For local1 = $00 To $09 Step $01
                            If (inventory(local1) <> Null) Then
                                If (inventory(local1)\Field3\Field1 = "Leaflet") Then
                                    removeitem(inventory(local1), $01)
                                    Exit
                                EndIf
                            EndIf
                        Next
                        giveachievement($1A, $01)
                        freeentity(local10\Field1\Field25[$1C])
                        freeentity(local10\Field1\Field25[$1B])
                        removeevent(local10)
                    EndIf
                EndIf
            Case $22
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field3) Then
                        If (local10\Field1\Field5 > entityz(collider, $00)) Then
                            If (playerzone = $01) Then
                                playsound_strict(loadtempsound("SFX\Ambient\ToZone2.ogg"))
                            Else
                                playsound_strict(loadtempsound("SFX\Ambient\ToZone3.ogg"))
                            EndIf
                            local10\Field3 = 1.0
                        EndIf
                    EndIf
                    If (0.0 = local10\Field4) Then
                        If (rand($02, $01) = $01) Then
                            giveachievement($19, $01)
                            local10\Field1\Field25[$01] = loadanimmesh_strict("GFX\npcs\scp-1048.b3d", $00)
                            scaleentity(local10\Field1\Field25[$01], 0.05, 0.05, 0.05, $00)
                            positionentity(local10\Field1\Field25[$01], entityx(local10\Field1\Field25[$00], $01), entityy(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01), $00)
                            setanimtime(local10\Field1\Field25[$01], 267.0, $00)
                        EndIf
                        local10\Field4 = 1.0
                    ElseIf (local10\Field1\Field25[$01] <> $00) Then
                        If (1.0 = local10\Field4) Then
                            pointentity(local10\Field1\Field25[$01], local10\Field13, 0.0)
                            rotateentity(local10\Field1\Field25[$01], -90.0, entityyaw(local10\Field1\Field25[$01], $00), 0.0, $00)
                            local21 = wrapangle(deltayaw(local10\Field13, local10\Field1\Field25[$01]))
                            If (((40.0 > local21) Or (320.0 < local21)) <> 0) Then
                                local10\Field4 = 2.0
                            EndIf
                        ElseIf (2.0 = local10\Field4) Then
                            pointentity(local10\Field1\Field25[$01], local10\Field13, 0.0)
                            rotateentity(local10\Field1\Field25[$01], -90.0, entityyaw(local10\Field1\Field25[$01], $00), 0.0, $00)
                            animate2(local10\Field1\Field25[$01], animtime(local10\Field1\Field25[$01]), $10B, $11B, 0.3, $00)
                            If (283.0 = animtime(local10\Field1\Field25[$01])) Then
                                local10\Field4 = 3.0
                            EndIf
                        ElseIf (3.0 = local10\Field4) Then
                            animate2(local10\Field1\Field25[$01], animtime(local10\Field1\Field25[$01]), $11B, $10B, -0.2, $00)
                            If (267.0 = animtime(local10\Field1\Field25[$01])) Then
                                local10\Field4 = 4.0
                            EndIf
                        ElseIf (4.0 = local10\Field4) Then
                            local21 = wrapangle(deltayaw(local10\Field13, local10\Field1\Field25[$01]))
                            If (((90.0 < local21) And (270.0 > local21)) <> 0) Then
                                freeentity(local10\Field1\Field25[$01])
                                local10\Field1\Field25[$01] = $00
                                local10\Field4 = 5.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (local10\Field1\Field7\Field11 = "checkpoint2") Then
                    For local11 = Each events
                        If (local11\Field22 = $2A) Then
                            If (2.0 = local11\Field2) Then
                                If (local10\Field1\Field29[$00]\Field4 <> 0) Then
                                    turncheckpointmonitorsoff($01)
                                    local10\Field1\Field29[$00]\Field4 = $00
                                    local10\Field1\Field29[$01]\Field4 = $00
                                EndIf
                            Else
                                updatecheckpointmonitors($01)
                                local10\Field1\Field29[$00]\Field4 = $01
                                local10\Field1\Field29[$01]\Field4 = $01
                            EndIf
                            Exit
                        EndIf
                    Next
                Else
                    For local11 = Each events
                        If (local11\Field22 = $41) Then
                            If (0.0 = local11\Field4) Then
                                turncheckpointmonitorsoff($00)
                                local10\Field1\Field29[$00]\Field4 = $00
                                local10\Field1\Field29[$01]\Field4 = $00
                            Else
                                updatecheckpointmonitors($00)
                                local10\Field1\Field29[$00]\Field4 = $01
                                local10\Field1\Field29[$01]\Field4 = $01
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
                If (local10\Field2 <> (Float local10\Field1\Field29[$00]\Field5)) Then
                    If (local10\Field7 = $00) Then
                        loadeventsound(local10, "SFX\Door\DoorCheckpoint.ogg", $00)
                    EndIf
                    If (channelplaying(local10\Field5) = $00) Then
                        local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                    EndIf
                    If (channelplaying(local10\Field6) = $00) Then
                        local10\Field6 = playsound2(local10\Field7, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                    EndIf
                EndIf
                local10\Field2 = (Float local10\Field1\Field29[$00]\Field5)
                If (channelplaying(local10\Field5) <> 0) Then
                    updatesoundorigin(local10\Field5, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                EndIf
                If (channelplaying(local10\Field6) <> 0) Then
                    updatesoundorigin(local10\Field6, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                EndIf
                local10\Field1\Field29[$00]\Field11 = 500.0
                local10\Field1\Field29[$01]\Field11 = 500.0
            Case $21,$20
                local10\Field24 = $00
                If ((Float millisecs2()) > local10\Field2) Then
                    If (playerzone > $00) Then
                        If (0.0 < entitypitch(local10\Field1\Field28[$00], $01)) Then
                            For local15 = Each securitycams
                                If ((((local15\Field22 = $00) And (local15\Field20\Field7\Field11 <> "room106")) And (local15\Field20\Field7\Field11 <> "room205")) <> 0) Then
                                    local15\Field22 = $02
                                EndIf
                                If (local15\Field20 = local10\Field1) Then
                                    local15\Field7 = $01
                                EndIf
                            Next
                        Else
                            For local15 = Each securitycams
                                If (local15\Field22 <> $01) Then
                                    local15\Field22 = $00
                                EndIf
                                If (local15\Field20 = local10\Field1) Then
                                    local15\Field7 = $00
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local10\Field2 = (Float (millisecs2() + $BB8))
                EndIf
                If (playerinroom(local10) <> 0) Then
                    coffindistance = entitydistance(local10\Field13, local10\Field1\Field25[$01])
                    If (1.5 > coffindistance) Then
                        giveachievement($13, $01)
                        If ((((contained106 = $00) And (local10\Field0 = "coffin106")) And (0.0 = local10\Field3)) <> 0) Then
                            local32 = createdecal($00, entityx(local10\Field1\Field25[$01], $01), (-1531.0 * roomscale), entityz(local10\Field1\Field25[$01], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.05
                            local32\Field1 = 0.001
                            entityalpha(local32\Field0, 0.8)
                            updatedecals()
                            If (0.0 < curr106\Field9) Then
                                positionentity(curr106\Field4, entityx(local10\Field1\Field25[$01], $01), (-10240.0 * roomscale), entityz(local10\Field1\Field25[$01], $01), $00)
                                curr106\Field9 = -0.1
                                showentity(curr106\Field0)
                                local10\Field3 = 1.0
                            EndIf
                        EndIf
                    ElseIf (3.0 > coffindistance) Then
                        If (local10\Field1\Field32[$00] = Null) Then
                            local10\Field1\Field32[$00] = createnpc($03, local10\Field1\Field3, local10\Field1\Field4, local10\Field1\Field5)
                            rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $5A)), 0.0, $00)
                            local10\Field1\Field32[$00]\Field9 = 8.0
                            setnpcframe(local10\Field1\Field32[$00], 270.0)
                            local10\Field1\Field32[$00]\Field44 = 0.0
                            local10\Field1\Field32[$00]\Field16 = loadsound_strict((("SFX\Room\895Chamber\GuardIdle" + (Str rand($01, $03))) + ".ogg"))
                            local10\Field1\Field32[$00]\Field17 = playsound2(local10\Field1\Field32[$00]\Field16, camera, local10\Field1\Field32[$00]\Field4, 10.0, 1.0)
                            local10\Field1\Field32[$00]\Field48 = $01
                            local10\Field1\Field32[$00]\Field72 = 0.0
                        EndIf
                    ElseIf (5.0 < coffindistance) Then
                        If (local10\Field1\Field32[$00] <> Null) Then
                            If (local10\Field1\Field32[$00]\Field12 = $00) Then
                                If (channelplaying(local10\Field1\Field32[$00]\Field17) <> 0) Then
                                    stopchannel(local10\Field1\Field32[$00]\Field17)
                                EndIf
                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                local10\Field1\Field32[$00]\Field16 = loadsound_strict((("SFX\Room\895Chamber\GuardScream" + (Str rand($01, $03))) + ".ogg"))
                                local10\Field1\Field32[$00]\Field17 = playsound2(local10\Field1\Field32[$00]\Field16, camera, local10\Field1\Field32[$00]\Field4, 100.0, 1.0)
                                local10\Field1\Field32[$00]\Field12 = $01
                                local10\Field1\Field32[$00]\Field10 = 0.0
                            EndIf
                        EndIf
                    EndIf
                    If (local10\Field1\Field32[$00] <> Null) Then
                        updatesoundorigin(local10\Field1\Field32[$00]\Field17, camera, local10\Field1\Field32[$00]\Field4, 100.0, 1.0)
                        If (local10\Field1\Field32[$00]\Field12 = $00) Then
                            local10\Field1\Field32[$00]\Field44 = 0.0
                        ElseIf (local10\Field1\Field32[$00]\Field12 = $01) Then
                            If (70.0 > local10\Field1\Field32[$00]\Field10) Then
                                local10\Field1\Field32[$00]\Field10 = (local10\Field1\Field32[$00]\Field10 + fpsfactor)
                                local10\Field1\Field32[$00]\Field44 = 0.0
                            Else
                                local10\Field1\Field32[$00]\Field44 = 1.0
                            EndIf
                            If (((-1531.0 * roomscale) + 0.35) < entityy(local10\Field1\Field32[$00]\Field4, $00)) Then
                                local0 = entitydistance(local10\Field13, local10\Field1\Field32[$00]\Field4)
                                If (0.8 > local0) Then
                                    local33 = point_direction(entityx(local10\Field13, $01), entityz(local10\Field13, $01), entityx(local10\Field1\Field32[$00]\Field4, $01), entityz(local10\Field1\Field32[$00]\Field4, $01))
                                    translateentity(local10\Field13, ((cos(((- local33) + 90.0)) * (local0 - 0.8)) * (local0 - 0.8)), 0.0, ((sin(((- local33) + 90.0)) * (local0 - 0.8)) * (local0 - 0.8)), $00)
                                EndIf
                                If (0.6 < entityy(local10\Field1\Field32[$00]\Field4, $00)) Then
                                    entitytype(local10\Field1\Field32[$00]\Field4, $00, $00)
                                EndIf
                            Else
                                local10\Field2 = (local10\Field2 + fpsfactor)
                                animatenpc(local10\Field1\Field32[$00], 270.0, 286.0, 0.4, $00)
                                If (local10\Field7 = $00) Then
                                    loadeventsound(local10, "SFX\General\BodyFall.ogg", $00)
                                    local10\Field5 = playsound_strict(local10\Field7)
                                    local32 = createdecal($03, entityx(local10\Field1\Field2, $00), (-1531.0 * roomscale), entityz(local10\Field1\Field2, $00), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                    local32\Field2 = 0.4
                                    scalesprite(local32\Field0, local32\Field2, local32\Field2)
                                    updatedecals()
                                EndIf
                                If (286.0 = local10\Field1\Field32[$00]\Field14) Then
                                    local10\Field1\Field32[$00]\Field12 = $02
                                EndIf
                            EndIf
                            If (local10\Field1\Field32[$00]\Field20 = $00) Then
                                local10\Field1\Field32[$00]\Field19 = loadsound_strict("SFX\Room\895Chamber\GuardRadio.ogg")
                                local10\Field1\Field32[$00]\Field20 = loopsound2(local10\Field1\Field32[$00]\Field19, local10\Field1\Field32[$00]\Field20, camera, local10\Field1\Field32[$00]\Field4, 5.0, 1.0)
                            EndIf
                        ElseIf (local10\Field1\Field32[$00]\Field12 = $02) Then
                            If (((channelplaying(local10\Field5) = $00) And (local10\Field7 <> $00)) <> 0) Then
                                freesound_strict(local10\Field7)
                                local10\Field7 = $00
                                local10\Field5 = $00
                            EndIf
                            If (((channelplaying(local10\Field1\Field32[$00]\Field17) = $00) And (local10\Field1\Field32[$00]\Field16 <> $00)) <> 0) Then
                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                local10\Field1\Field32[$00]\Field16 = $00
                                local10\Field1\Field32[$00]\Field17 = $00
                            EndIf
                            If (local10\Field1\Field32[$00]\Field19 = $00) Then
                                local10\Field1\Field32[$00]\Field19 = loadsound_strict("SFX\Room\895Chamber\GuardRadio.ogg")
                            EndIf
                            local10\Field1\Field32[$00]\Field20 = loopsound2(local10\Field1\Field32[$00]\Field19, local10\Field1\Field32[$00]\Field20, camera, local10\Field1\Field32[$00]\Field4, 5.0, 1.0)
                        EndIf
                    EndIf
                    If (wearingnightvision > $00) Then
                        local34 = $00
                        For local1 = $00 To $09 Step $01
                            If (inventory(local1) <> Null) Then
                                If (((((wearingnightvision = $01) And (inventory(local1)\Field3\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field3\Field2 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field3\Field2 = "finenvgoggles"))) <> 0) Then
                                    If (((0.0 < inventory(local1)\Field13) Or (wearingnightvision = $03)) <> 0) Then
                                        local34 = $01
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If ((((4.0 > coffindistance) And local34) And (wearing714 = $00)) <> 0) Then
                            local35 = point_direction(entityx(local10\Field13, $01), entityz(local10\Field13, $01), entityx(local10\Field1\Field25[$01], $01), entityz(local10\Field1\Field25[$01], $01))
                            local36 = entityyaw(local10\Field13, $00)
                            local37 = angledist(((local35 + 90.0) + sin(wrapangle((local10\Field4 / 10.0)))), local36)
                            turnentity(local10\Field13, 0.0, (local37 / 4.0), 0.0, $01)
                            local35 = (Abs point_distance(entityx(local10\Field13, $01), entityz(local10\Field13, $01), entityx(local10\Field1\Field25[$01], $01), entityz(local10\Field1\Field25[$01], $01)))
                            local36 = (min(max(((2.0 - local35) / 2.0), 0.0), 1.0) * -60.0)
                            user_camera_pitch = ((user_camera_pitch * 0.8) + (local36 * 0.2))
                            sanity = (sanity - ((fpsfactor * 1.1) / (Float wearingnightvision)))
                            restoresanity = $00
                            blurtimer = (sin((Float (millisecs2() / $0A))) * (Abs sanity))
                            If (0.0 > vomittimer) Then
                                restoresanity = $00
                                sanity = -1010.0
                            EndIf
                            If (-1000.0 > sanity) Then
                                If (wearingnightvision > $01) Then
                                    deathmsg = (chr($22) + "Class D viewed SCP-895 through a pair of digital night vision goggles, presumably enhanced by SCP-914. It might be possible that the subject ")
                                    deathmsg = ((deathmsg + "was able to resist the memetic effects partially through these goggles. The goggles have been stored for further study.") + chr($22))
                                Else
                                    deathmsg = ((chr($22) + "Class D viewed SCP-895 through a pair of digital night vision goggles, killing him.") + chr($22))
                                EndIf
                                entitytexture(nvoverlay, nvtexture, $00, $00)
                                If (-10.0 > vomittimer) Then
                                    kill("was killed by SCP-895", $00)
                                EndIf
                            ElseIf (-800.0 > sanity) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(nvoverlay, nvtexture, $00, $00)
                                EndIf
                                If (rand($06, $01) < $05) Then
                                    entitytexture(nvoverlay, gorepics(rand($00, $05)), $00, $00)
                                    For local1 = $00 To $09 Step $01
                                        If (inventory(local1) <> Null) Then
                                            If (((((wearingnightvision = $01) And (inventory(local1)\Field3\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field3\Field2 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field3\Field2 = "finenvgoggles"))) <> 0) Then
                                                If (1.0 = inventory(local1)\Field14) Then
                                                    playsound_strict(horrorsfx($01))
                                                EndIf
                                                inventory(local1)\Field14 = 2.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                blurtimer = 1000.0
                                If (0.0 = vomittimer) Then
                                    vomittimer = 1.0
                                EndIf
                            ElseIf (-500.0 > sanity) Then
                                If (rand($07, $01) = $01) Then
                                    entitytexture(nvoverlay, nvtexture, $00, $00)
                                EndIf
                                If (rand($32, $01) = $01) Then
                                    entitytexture(nvoverlay, gorepics(rand($00, $05)), $00, $00)
                                    For local1 = $00 To $09 Step $01
                                        If (inventory(local1) <> Null) Then
                                            If (((((wearingnightvision = $01) And (inventory(local1)\Field3\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field3\Field2 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field3\Field2 = "finenvgoggles"))) <> 0) Then
                                                If (0.0 = inventory(local1)\Field14) Then
                                                    playsound_strict(horrorsfx($00))
                                                EndIf
                                                inventory(local1)\Field14 = 1.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            Else
                                entitytexture(nvoverlay, nvtexture, $00, $00)
                                For local1 = $00 To $09 Step $01
                                    If (inventory(local1) <> Null) Then
                                        If (((((wearingnightvision = $01) And (inventory(local1)\Field3\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field3\Field2 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field3\Field2 = "finenvgoggles"))) <> 0) Then
                                            inventory(local1)\Field14 = 0.0
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        EndIf
                    EndIf
                    If (0.0 < local10\Field4) Then
                        local10\Field4 = max((local10\Field4 - fpsfactor), 0.0)
                    EndIf
                    If (0.0 = local10\Field4) Then
                        local10\Field4 = -1.0
                        entitytexture(nvoverlay, nvtexture, $00, $00)
                        If (wearingnightvision = $01) Then
                            entitycolor(nvoverlay, 0.0, 255.0, 0.0)
                        ElseIf (wearingnightvision = $02) Then
                            entitycolor(nvoverlay, 0.0, 100.0, 255.0)
                        EndIf
                    EndIf
                    shouldplay = $42
                    If (updatelever(local10\Field1\Field28[$00], $00) <> 0) Then
                        For local15 = Each securitycams
                            If (((local15\Field22 = $00) And (local15\Field20\Field7\Field11 <> "room106")) <> 0) Then
                                local15\Field22 = $02
                            EndIf
                            If (local15\Field22 = $01) Then
                                entityblend(local15\Field10, $03)
                            EndIf
                            If (local15\Field20 = local10\Field1) Then
                                local15\Field7 = $01
                            EndIf
                        Next
                    Else
                        For local15 = Each securitycams
                            If (local15\Field22 <> $01) Then
                                local15\Field22 = $00
                            EndIf
                            If (local15\Field22 = $01) Then
                                entityblend(local15\Field10, $00)
                            EndIf
                            If (local15\Field20 = local10\Field1) Then
                                local15\Field7 = $00
                            EndIf
                        Next
                    EndIf
                Else
                    coffindistance = local10\Field20
                EndIf
            Case $09
                local10\Field24 = $00
                If (contained106 = $00) Then
                    If (0.0 = local10\Field2) Then
                        If (((8.0 > local10\Field20) And (0.0 < local10\Field20)) <> 0) Then
                            If (0.0 > curr106\Field9) Then
                                removeevent(local10)
                            Else
                                local10\Field1\Field29[$00]\Field5 = $01
                                local10\Field1\Field32[$00] = createnpc($04, entityx(local10\Field1\Field29[$00]\Field0, $01), 0.5, entityz(local10\Field1\Field29[$00]\Field0, $01))
                                changenpctextureid(local10\Field1\Field32[$00], $04)
                                pointentity(local10\Field1\Field32[$00]\Field4, local10\Field1\Field2, 0.0)
                                rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, entityyaw(local10\Field1\Field32[$00]\Field4, $00), 0.0, $01)
                                moveentity(local10\Field1\Field32[$00]\Field4, 0.0, 0.0, 0.5)
                                local10\Field1\Field29[$00]\Field5 = $00
                                playsound2(loadtempsound("SFX\Door\EndroomDoor.ogg"), camera, local10\Field1\Field2, 15.0, 1.0)
                                local10\Field2 = 1.0
                            EndIf
                        EndIf
                    ElseIf (1.0 = local10\Field2) Then
                        If (playerinroom(local10) <> 0) Then
                            local10\Field1\Field32[$00]\Field9 = 1.0
                            local10\Field2 = 2.0
                            local10\Field7 = loadsound_strict("SFX\Character\Janitor\106Abduct.ogg")
                            If (playerroom = local10\Field1) Then
                                playsound_strict(local10\Field7)
                            EndIf
                            If (local10\Field5 <> $00) Then
                                stopchannel(local10\Field5)
                            EndIf
                        ElseIf (8.0 > local10\Field20) Then
                            If (local10\Field7 = $00) Then
                                local10\Field7 = loadsound_strict("SFX\Character\Janitor\Idle.ogg")
                            EndIf
                            local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field32[$00]\Field0, 15.0, 1.0)
                        EndIf
                    ElseIf (2.0 = local10\Field2) Then
                        local0 = entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field1\Field2)
                        If (1.5 > local0) Then
                            local32 = createdecal($00, entityx(local10\Field1\Field2, $00), 0.01, entityz(local10\Field1\Field2, $00), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.05
                            local32\Field1 = 0.008
                            local32\Field9 = 10000.0
                            updatedecals()
                            local10\Field2 = 3.0
                        EndIf
                    Else
                        local0 = distance(entityx(local10\Field1\Field32[$00]\Field4, $00), entityz(local10\Field1\Field32[$00]\Field4, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))
                        positionentity(curr106\Field0, entityx(local10\Field1\Field2, $01), 0.0, entityz(local10\Field1\Field2, $01), $00)
                        pointentity(curr106\Field0, local10\Field1\Field32[$00]\Field4, 0.0)
                        rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field0, $00), 0.0, $01)
                        curr106\Field24 = 1.0
                        If (0.4 > local0) Then
                            If (1.0 = local10\Field1\Field32[$00]\Field9) Then
                                setnpcframe(local10\Field1\Field32[$00], 41.0)
                            EndIf
                            local10\Field2 = (local10\Field2 + (fpsfactor / 2.0))
                            local10\Field1\Field32[$00]\Field9 = 6.0
                            local10\Field1\Field32[$00]\Field22 = curvevalue(0.0, local10\Field1\Field32[$00]\Field22, 25.0)
                            positionentity(local10\Field1\Field32[$00]\Field4, curvevalue(entityx(local10\Field1\Field2, $01), entityx(local10\Field1\Field32[$00]\Field4, $00), 25.0), (0.3 - (local10\Field2 / 70.0)), curvevalue(entityz(local10\Field1\Field2, $01), entityz(local10\Field1\Field32[$00]\Field4, $00), 25.0), $00)
                            resetentity(local10\Field1\Field32[$00]\Field4)
                            animatenpc(local10\Field1\Field32[$00], 41.0, 58.0, 0.1, $00)
                            animatenpc(curr106, 206.0, 112.0, -1.0, $00)
                        Else
                            animatenpc(curr106, 112.0, 206.0, 1.5, $00)
                        EndIf
                        currspeed = min((currspeed - (((0.15 / entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field13)) * currspeed) * fpsfactor)), currspeed)
                        If (100.0 < local10\Field2) Then
                            positionentity(curr106\Field0, entityx(curr106\Field4, $00), -100.0, entityz(curr106\Field4, $00), $01)
                            positionentity(curr106\Field4, entityx(curr106\Field4, $00), -100.0, entityz(curr106\Field4, $00), $01)
                            curr106\Field24 = 0.0
                            If (2.5 > entitydistance(local10\Field13, local10\Field1\Field2)) Then
                                curr106\Field9 = -0.1
                            EndIf
                            removenpc(local10\Field1\Field32[$00], $00)
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $36
                If (playerinroom(local10) <> 0) Then
                    updateending(local10)
                EndIf
            Case $35
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    If (remotedooron = $00) Then
                        local10\Field1\Field29[$01]\Field4 = $01
                    ElseIf ((remotedooron And (0.0 = local10\Field4)) <> 0) Then
                        local10\Field1\Field29[$01]\Field4 = $00
                        If (local10\Field1\Field29[$01]\Field5 <> 0) Then
                            If (((50.0 < local10\Field1\Field29[$01]\Field7) Or (0.5 > entitydistance(local10\Field13, local10\Field1\Field29[$01]\Field2))) <> 0) Then
                                local10\Field1\Field29[$01]\Field7 = min(local10\Field1\Field29[$01]\Field7, 50.0)
                                local10\Field1\Field29[$01]\Field5 = $00
                                playsound2(loadtempsound("SFX\Door\DoorError.ogg"), camera, local10\Field1\Field29[$01]\Field2, 10.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        local10\Field1\Field29[$01]\Field4 = $00
                        If (curr096 <> Null) Then
                            If (((0.0 = curr096\Field9) Or (5.0 = curr096\Field9)) <> 0) Then
                                local10\Field1\Field29[$00]\Field28 = updateelevators(local10\Field1\Field29[$00]\Field28, local10\Field1\Field29[$00], gateaevent\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
                            Else
                                local10\Field2 = update096elevatorevent(local10, local10\Field2, local10\Field1\Field29[$00], local10\Field1\Field25[$00])
                            EndIf
                        Else
                            local10\Field1\Field29[$00]\Field28 = updateelevators(local10\Field1\Field29[$00]\Field28, local10\Field1\Field29[$00], gateaevent\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
                        EndIf
                        If (contained106 = $00) Then
                            If (((-1.5 > local10\Field2) And (-1.5 <= (local10\Field2 + fpsfactor))) <> 0) Then
                                playsound_strict(oldmansfx($03))
                            EndIf
                        EndIf
                        If (4.0 > entitydistance(collider, local10\Field1\Field25[$01])) Then
                            If (networkserver\Field18 <> 0) Then
                                gateaevent\Field1\Field29[$01]\Field4 = $01
                            EndIf
                            playerroom = gateaevent\Field1
                        EndIf
                    EndIf
                EndIf
            Case $04
                If (((6.0 > local10\Field20) And (0.0 < local10\Field20)) <> 0) Then
                    If (1.0 < curr173\Field24) Then
                        removeevent(local10)
                    ElseIf (((entityinview(curr173\Field4, getplayercamera(local10\Field14)) = $00) Or (15.0 < entitydistance(curr173\Field4, local10\Field13))) <> 0) Then
                        positionentity(curr173\Field4, (local10\Field1\Field3 + (cos((Float (local10\Field1\Field6 + $87))) * 2.0)), 0.6, (local10\Field1\Field5 + (sin((Float (local10\Field1\Field6 + $87))) * 2.0)), $00)
                        resetentity(curr173\Field4)
                        removeevent(local10)
                    EndIf
                EndIf
            Case $08
                If (playerinroom(local10) <> 0) Then
                    If (curr096 = Null) Then
                        curr096 = createnpc($09, entityx(local10\Field1\Field2, $01), 0.3, entityz(local10\Field1\Field2, $01))
                        rotateentity(curr096\Field4, 0.0, (Float (local10\Field1\Field6 + $2D)), 0.0, $01)
                    EndIf
                    removeevent(local10)
                EndIf
            Case $2C
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (2.5 > entitydistance(local10\Field13, local10\Field1\Field2)) Then
                            playsound_strict(rustlesfx(rand($00, $02)))
                            createnpc($06, 0.0, 0.0, 0.0)
                            local10\Field2 = 1.0
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $02
                If (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    showentity(local10\Field1\Field2)
                    playerfallingpickdistance = 0.0
                    injuries = ((fpsfactor * 0.00005) + injuries)
                    prevsecondarylighton = secondarylighton
                    secondarylighton = 1.0
                    If ((((2000.0 * roomscale) > entityy(local10\Field13, $00)) Or ((2608.0 * roomscale) < entityy(local10\Field13, $00))) <> 0) Then
                        currstepsfx = $01
                    EndIf
                    If (local10\Field7 = $00) Then
                        loadeventsound(local10, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                    EndIf
                    If (local10\Field8 = $00) Then
                        local10\Field8 = loadeventsound(local10, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                    EndIf
                    If (0.0 = local10\Field2) Then
                        camerafogcolor(camera, 0.0, 0.0, 0.0)
                        cameraclscolor(camera, 0.0, 0.0, 0.0)
                        local10\Field2 = 0.1
                    EndIf
                    If (((((2000.0 * roomscale) > entityy(local10\Field13, $00)) Or (0.0 = local10\Field4)) Or ((2608.0 * roomscale) < entityy(local10\Field13, $00))) <> 0) Then
                        shouldplay = $03
                    Else
                        shouldplay = $00
                    EndIf
                    scaleentity(local10\Field1\Field2, roomscale, (((sin((local10\Field2 / 14.0)) * 0.2) + 1.0) * roomscale), roomscale, $00)
                    For local1 = $00 To $07 Step $01
                        scaleentity(local10\Field1\Field25[local1], (((Abs (sin(((local10\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.0) * roomscale), (((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    Next
                    scaleentity(local10\Field1\Field25[$09], (((Abs (sin(((local10\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    local10\Field2 = (local10\Field2 + fpsfactor)
                    If (0.0 = local10\Field3) Then
                        local10\Field1\Field29[$00]\Field5 = $00
                        local10\Field1\Field29[$01]\Field5 = $00
                        If (0.0 < curr106\Field9) Then
                            local21 = ((local10\Field2 / 10.0) Mod 360.0)
                            positionentity(curr106\Field4, entityx(local10\Field1\Field2, $00), ((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.4) + 0.55), entityx(local10\Field1\Field2, $00), $00)
                            rotateentity(curr106\Field4, 0.0, local21, 0.0, $00)
                            moveentity(curr106\Field4, 0.0, 0.0, (6.0 - sin((local10\Field2 / 10.0))))
                            animatenpc(curr106, 55.0, 104.0, 0.5, $01)
                            rotateentity(curr106\Field4, 0.0, (local21 + 90.0), 0.0, $00)
                            curr106\Field24 = 1.0
                            showentity(curr106\Field0)
                            showentity(curr106\Field4)
                            resetentity(curr106\Field4)
                            curr106\Field44 = 0.0
                            curr106\Field7 = 0.0
                            positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                            rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                            If (4550.0 < local10\Field2) Then
                                If (rand($320, $01) = $01) Then
                                    playsound_strict(horrorsfx($08))
                                    curr106\Field9 = -0.1
                                    curr106\Field24 = 0.0
                                    local10\Field2 = 601.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (0.3 > entitydistance(local10\Field13, curr106\Field4)) Then
                        curr106\Field24 = 0.0
                        curr106\Field9 = -10.0
                    EndIf
                    If (1.0 = local10\Field3) Then
                        positionentity(local10\Field1\Field25[$09], (entityx(local10\Field1\Field25[$08], $01) + (3384.0 * roomscale)), 0.0, entityz(local10\Field1\Field25[$08], $01), $00)
                        translateentity(local10\Field1\Field25[$09], (cos((local10\Field2 * 0.8)) * 5.0), 0.0, (sin((local10\Field2 * 1.6)) * 4.0), $01)
                        rotateentity(local10\Field1\Field25[$09], 0.0, (local10\Field2 * 2.0), 0.0, $00)
                        positionentity(local10\Field1\Field25[$0A], entityx(local10\Field1\Field25[$08], $01), 0.0, (entityz(local10\Field1\Field25[$08], $01) + (3384.0 * roomscale)), $00)
                        translateentity(local10\Field1\Field25[$0A], (sin((local10\Field2 * 1.6)) * 4.0), 0.0, (cos((local10\Field2 * 0.8)) * 5.0), $01)
                        rotateentity(local10\Field1\Field25[$0A], 0.0, (local10\Field2 * 2.0), 0.0, $00)
                        If (((1.0 = local10\Field4) Or (2.0 = local10\Field4)) <> 0) Then
                            If (((1.0 = local10\Field4) And ((150.0 < local10\Field1\Field29[$00]\Field7) Or (150.0 < local10\Field1\Field29[$01]\Field7))) <> 0) Then
                                playsound_strict(loadtempsound("SFX\Horror\Horror16.ogg"))
                                blurtimer = 800.0
                                local10\Field4 = 2.0
                            EndIf
                            If (5.0 > entityy(local10\Field13, $00)) Then
                                local10\Field4 = 0.0
                            EndIf
                        ElseIf (6.0 < entityy(local10\Field13, $00)) Then
                            shouldplay = $0F
                            camerafogcolor(camera, 38.0, 55.0, 47.0)
                            cameraclscolor(camera, 38.0, 55.0, 47.0)
                            If (entityx(local10\Field1\Field25[$14], $01) < (entityx(local10\Field1\Field25[$08], $01) - (4000.0 * roomscale))) Then
                                local10\Field6 = playsound_strict(local10\Field8)
                                positionentity(local10\Field1\Field25[$14], (entityx(local10\Field13, $01) + (4000.0 * roomscale)), 12.0, entityz(local10\Field13, $01), $00)
                            EndIf
                            moveentity(local10\Field13, 0.0, (min((12.0 - entityy(local10\Field13, $00)), 0.0) * fpsfactor), 0.0)
                            local18 = (((- fpsfactor) * roomscale) * 4.0)
                            local19 = ((17.0 - ((Abs (entityx(local10\Field13, $00) - entityx(local10\Field1\Field25[$14], $00))) * 0.5)) - entityy(local10\Field1\Field25[$14], $00))
                            local20 = (entityz(local10\Field13, $01) - entityz(local10\Field1\Field25[$14], $00))
                            translateentity(local10\Field1\Field25[$14], local18, local19, local20, $01)
                            rotateentity(local10\Field1\Field25[$14], (-90.0 - ((entityx(local10\Field13, $00) - entityx(local10\Field1\Field25[$14], $00)) * 1.5)), -90.0, 0.0, $01)
                            local38 = $00
                            For local1 = $00 To $02 Step $01
                                Select local1
                                    Case $00
                                        local18 = (-1452.0 * roomscale)
                                        local20 = (-37.0 * roomscale)
                                    Case $01
                                        local18 = (-121.0 * roomscale)
                                        local20 = (188.0 * roomscale)
                                    Case $02
                                        local18 = (1223.0 * roomscale)
                                        local20 = (-196.0 * roomscale)
                                End Select
                                local18 = (entityx(local10\Field1\Field25[$08], $01) + local18)
                                local20 = (entityz(local10\Field1\Field25[$08], $01) + local20)
                                If ((200.0 * roomscale) > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), local18, local20)) Then
                                    local38 = $01
                                    Exit
                                EndIf
                            Next
                            local0 = entitydistance(local10\Field13, local10\Field1\Field25[$14])
                            If (((local10\Field6 <> $00) And channelplaying(local10\Field6)) <> 0) Then
                                local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, camera, 10.0, (((Float (local38 = $00)) * 0.6) + 0.3))
                            EndIf
                            If (local38 <> 0) Then
                                entitytexture(local10\Field1\Field25[$14], local10\Field1\Field27[$12], $00, $00)
                            ElseIf (8.0 > local0) Then
                                local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field25[$14], 8.0, 1.0)
                                entitytexture(local10\Field1\Field25[$14], local10\Field1\Field27[$13], $00, $00)
                                injuries = ((((8.0 - local0) * fpsfactor) * 0.0003) + injuries)
                                If (7.0 > local0) Then
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local3, local10\Field1\Field25[$14], 0.0)
                                    turnentity(local3, 90.0, 0.0, 0.0, $00)
                                    user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), 10.0)
                                    user_camera_pitch = (user_camera_pitch - 90.0)
                                    rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), 10.0), 0.0, $00)
                                    freeentity(local3)
                                EndIf
                            EndIf
                            camerashake = max(((((Float (local38 = $00)) * 4.0) + 4.0) - local0), 0.0)
                            If (((8.5 > entityy(local10\Field13, $00)) And (multiplayer_isfullsync() = $00)) <> 0) Then
                                loadeventsound(local10, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                                loadeventsound(local10, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                                blurtimer = 1500.0
                                local10\Field3 = 1.0
                                blinktimer = -10.0
                                positionentity(local10\Field13, (entityx(local10\Field1\Field25[$08], $01) - (400.0 * roomscale)), (-304.0 * roomscale), entityz(local10\Field1\Field25[$08], $01), $00)
                                resetentity(local10\Field13)
                                camerafogcolor(camera, 0.0, 0.0, 0.0)
                                cameraclscolor(camera, 0.0, 0.0, 0.0)
                            EndIf
                        Else
                            local10\Field4 = 0.0
                            If (player_isdead() = $00) Then
                                For local1 = $09 To $0A Step $01
                                    local0 = distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))
                                    If (6.0 > local0) Then
                                        If (local0 < (100.0 * roomscale)) Then
                                            local3 = createpivot($00)
                                            positionentity(local3, entityx(local10\Field1\Field25[local1], $01), entityy(local10\Field13, $00), entityz(local10\Field1\Field25[local1], $01), $00)
                                            pointentity(local3, local10\Field13, 0.0)
                                            rotateentity(local3, 0.0, (Float ((Int (entityyaw(local3, $00) / 90.0)) * $5A)), 0.0, $01)
                                            moveentity(local3, 0.0, 0.0, (100.0 * roomscale))
                                            positionentity(local10\Field13, entityx(local3, $00), entityy(local10\Field13, $00), entityz(local3, $00), $00)
                                            freeentity(local3)
                                            If (((0.0 = killtimer) And (player_isdead() = $00)) <> 0) Then
                                                deathmsg = "In addition to the decomposed appearance typical of SCP-106's victims, the body exhibits injuries that have not been observed before: "
                                                deathmsg = (deathmsg + "massive skull fracture, three broken ribs, fractured shoulder and multiple heavy lacerations.")
                                                playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"))
                                                multiplayer_writetempsound("SFX\Room\PocketDimension\Impact.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                                kill("was killed in pocket dimension", $01)
                                            EndIf
                                        EndIf
                                        If (1000.0 > (Float local10\Field11)) Then
                                            local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field25[local1], 6.0, 1.0)
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            local3 = createpivot($00)
                            positionentity(local3, (entityx(local10\Field1\Field25[$08], $01) - (1536.0 * roomscale)), (500.0 * roomscale), (entityz(local10\Field1\Field25[$08], $01) + (608.0 * roomscale)), $00)
                            If (5.0 > entitydistance(local3, local10\Field13)) Then
                                local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local3, 3.0, 1.0)
                            EndIf
                            freeentity(local3)
                            showentity(local10\Field1\Field25[$11])
                            positionentity(local10\Field1\Field25[$11], entityx(local10\Field1\Field25[$08], $01), (1376.0 * roomscale), (entityz(local10\Field1\Field25[$08], $01) - (2848.0 * roomscale)), $00)
                            pointentity(local10\Field1\Field25[$11], local10\Field13, 0.0)
                            turnentity(local10\Field1\Field25[$11], 0.0, 180.0, 0.0, $00)
                            local2 = (Int entitydistance(local10\Field13, local10\Field1\Field25[$11]))
                            If ((Float local2) < (2000.0 * roomscale)) Then
                                injuries = ((fpsfactor / 4000.0) + injuries)
                                local10\Field11 = (Str ((Float local10\Field11) + (fpsfactor / 1000.0)))
                                If (((1.0 < (Float local10\Field11)) And (1000.0 > (Float local10\Field11))) <> 0) Then
                                    playsound_strict(loadtempsound("SFX\Room\PocketDimension\Kneel.ogg"))
                                    loadeventsound(local10, "SFX\Room\PocketDimension\Screech.ogg", $00)
                                    local10\Field11 = "1000.0"
                                    debuglog("Loaded screech sound")
                                EndIf
                                sanity = max((sanity - ((fpsfactor / (Float local2)) / 8.0)), -1000.0)
                                currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 15.0) * max(((6.0 - (Float local2)) / 6.0), 0.0)))
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local3, local10\Field1\Field25[$11], 0.0)
                                turnentity(local3, 90.0, 0.0, 0.0, $00)
                                user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 15.0), 500.0))
                                user_camera_pitch = (user_camera_pitch - 90.0)
                                rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), min(max((15000.0 / (- sanity)), 15.0), 500.0)), 0.0, $00)
                                freeentity(local3)
                                If ((crouch And (multiplayer_isfullsync() = $00)) <> 0) Then
                                    blinktimer = -10.0
                                    positionentity(local10\Field13, (entityx(local10\Field1\Field25[$08], $01) - (1344.0 * roomscale)), (2944.0 * roomscale), (entityz(local10\Field1\Field25[$08], $01) - (1184.0 * roomscale)), $00)
                                    resetentity(local10\Field13)
                                    crouch = $00
                                    loadeventsound(local10, "SFX\Room\PocketDimension\Explosion.ogg", $00)
                                    loadeventsound(local10, "SFX\Room\PocketDimension\TrenchPlane.ogg", $01)
                                    positionentity(local10\Field1\Field25[$14], (entityx(local10\Field1\Field25[$08], $01) - 1000.0), 0.0, 0.0, $01)
                                    local10\Field11 = "0.0"
                                EndIf
                            ElseIf ((-180.0 * roomscale) > entityy(local10\Field13, $00)) Then
                                local2 = (Int distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), (entityx(local10\Field1\Field25[$08], $01) + (1024.0 * roomscale)), entityz(local10\Field1\Field25[$08], $01)))
                                If ((Float local2) < (640.0 * roomscale)) Then
                                    blurtimer = (((640.0 * roomscale) - (Float local2)) * 3000.0)
                                    local10\Field6 = loopsound2(decaysfx(rand($01, $03)), local10\Field6, camera, local10\Field13, 2.0, ((((640.0 * roomscale) - (Float local2)) * (Abs currspeed)) * 100.0))
                                    currspeed = curvevalue(0.0, currspeed, (Float (local2 * $0A)))
                                    If ((Float local2) < (130.0 * roomscale)) Then
                                        For local9 = Each rooms
                                            If (local9\Field7\Field11 = "room2shaft") Then
                                                giveachievement($21, $01)
                                                local10\Field2 = 0.0
                                                local10\Field3 = 0.0
                                                secondarylighton = prevsecondarylighton
                                                prevsecondarylighton = 0.0
                                                blinktimer = -10.0
                                                lightblink = 5.0
                                                blurtimer = 1500.0
                                                playerroom = local9
                                                playsound_strict(loadtempsound("SFX\Room\PocketDimension\Exit.ogg"))
                                                teleportentity(local10\Field13, entityx(local9\Field25[$00], $01), 0.4, entityz(local9\Field25[$00], $01), 0.3, $01, 2.0, $00)
                                                updaterooms()
                                                updatedoors()
                                                curr106\Field9 = 10000.0
                                                curr106\Field24 = 0.0
                                                local32 = createdecal($00, entityx(local9\Field25[$00], $01), entityy(local9\Field25[$00], $01), entityz(local9\Field25[$00], $01), 270.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                                teleportentity(local32\Field0, entityx(local9\Field25[$00], $01), (entityy(local9\Field25[$00], $01) + 0.6), entityz(local9\Field25[$00], $01), 0.0, $01, 4.0, $01)
                                                For local11 = Each events
                                                    If (local11\Field0 = "room2sl") Then
                                                        local11\Field4 = 0.0
                                                        updatelever(local11\Field1\Field28[$00], $00)
                                                        rotateentity(local11\Field1\Field28[$00], 0.0, entityyaw(local11\Field1\Field28[$00], $00), 0.0, $00)
                                                        turncheckpointmonitorsoff($00)
                                                        Exit
                                                    EndIf
                                                Next
                                                Exit
                                                Return $00
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If ((-1600.0 * roomscale) > entityy(local10\Field13, $00)) Then
                            If ((4750.0 * roomscale) < entitydistance(local10\Field13, local10\Field1\Field25[$08])) Then
                                If (multiplayer_isfullsync() = $00) Then
                                    camerafogcolor(camera, 0.0, 0.0, 0.0)
                                    cameraclscolor(camera, 0.0, 0.0, 0.0)
                                    dropspeed = 0.0
                                    blurtimer = 500.0
                                    blurtimer = 1500.0
                                    positionentity(local10\Field13, entityx(local10\Field1\Field2, $01), 0.4, entityx(local10\Field1\Field2, $01), $00)
                                    For local9 = Each rooms
                                        If (local9\Field7\Field11 = "room106") Then
                                            local10\Field2 = 0.0
                                            local10\Field3 = 0.0
                                            teleportentity(local10\Field13, entityx(local9\Field25[$0A], $01), 0.4, entityz(local9\Field25[$0A], $01), 0.3, $01, 2.0, $00)
                                            giveachievement($21, $01)
                                            secondarylighton = prevsecondarylighton
                                            prevsecondarylighton = 0.0
                                            curr106\Field9 = 10000.0
                                            curr106\Field24 = 0.0
                                            For local11 = Each events
                                                If (local11\Field0 = "room2sl") Then
                                                    local11\Field4 = 0.0
                                                    updatelever(local11\Field1\Field28[$00], $00)
                                                    rotateentity(local11\Field1\Field28[$00], 0.0, entityyaw(local11\Field1\Field28[$00], $00), 0.0, $00)
                                                    turncheckpointmonitorsoff($00)
                                                    Exit
                                                EndIf
                                            Next
                                            Exit
                                            Return $00
                                        EndIf
                                    Next
                                    resetentity(local10\Field13)
                                    local10\Field3 = 0.0
                                    updatedoorstimer = 0.0
                                    updatedoors()
                                    updaterooms()
                                EndIf
                            Else
                                If (0.0 <= killtimer) Then
                                    playsound_strict(horrorsfx($08))
                                    deathmsg = "In addition to the decomposed appearance typical of the victims of SCP-106, the subject seems to have suffered multiple heavy fractures to both of his legs."
                                    kill("was killed in pocket dimension", $01)
                                EndIf
                                blurtimer = 3000.0
                            EndIf
                        EndIf
                        updatedoorstimer = 0.0
                        updatedoors()
                        updaterooms()
                    ElseIf (0.0 = local10\Field3) Then
                        local0 = entitydistance(local10\Field13, local10\Field1\Field2)
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($19, $01)
                                Case $01,$02,$03,$04
                                    playsound_strict(oldmansfx($03))
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00)
                                    pointentity(local3, local10\Field1\Field2, 0.0)
                                    moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(local10\Field13, entityx(local3, $00), entityy(local10\Field13, $00), entityz(local3, $00), $00)
                                    resetentity(local10\Field13)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local10\Field1\Field25[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local10\Field1\Field25[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    freeentity(local3)
                                Case $05,$06,$07,$08,$09,$0A
                                    local10\Field3 = 1.0
                                    blinktimer = -10.0
                                    playsound_strict(oldmansfx($03))
                                    If (multiplayer_isfullsync() = $00) Then
                                        positionentity(local10\Field13, entityx(local10\Field1\Field25[$08], $01), 0.5, entityz(local10\Field1\Field25[$08], $01), $00)
                                        resetentity(local10\Field13)
                                    EndIf
                                Case $0B,$0C
                                    blurtimer = 500.0
                                    positionentity(local10\Field13, entityx(local10\Field1\Field2, $00), 0.5, entityz(local10\Field1\Field2, $00), $00)
                                Case $0D,$0E,$0F
                                    blurtimer = 1500.0
                                    local10\Field3 = 1.0
                                    blinktimer = -10.0
                                    If (multiplayer_isfullsync() = $00) Then
                                        positionentity(local10\Field13, (entityx(local10\Field1\Field25[$08], $01) - (400.0 * roomscale)), (-304.0 * roomscale), entityz(local10\Field1\Field25[$08], $01), $00)
                                        resetentity(local10\Field13)
                                    EndIf
                                Case $10,$11,$12,$13
                                    blurtimer = 1500.0
                                    If (multiplayer_isfullsync() = $00) Then
                                        For local9 = Each rooms
                                            If (local9\Field7\Field11 = "tunnel") Then
                                                giveachievement($21, $01)
                                                local10\Field2 = 0.0
                                                local10\Field3 = 0.0
                                                secondarylighton = prevsecondarylighton
                                                prevsecondarylighton = 0.0
                                                teleportentity(local10\Field13, entityx(local9\Field2, $01), 0.4, entityz(local9\Field2, $01), 0.3, $01, 2.0, $00)
                                                curr106\Field9 = 250.0
                                                curr106\Field24 = 0.0
                                                For local11 = Each events
                                                    If (local11\Field0 = "room2sl") Then
                                                        local11\Field4 = 0.0
                                                        updatelever(local11\Field1\Field28[$00], $00)
                                                        rotateentity(local11\Field1\Field28[$00], 0.0, entityyaw(local11\Field1\Field28[$00], $00), 0.0, $00)
                                                        turncheckpointmonitorsoff($00)
                                                        Exit
                                                    EndIf
                                                Next
                                                Exit
                                                Return $00
                                            EndIf
                                        Next
                                    EndIf
                                Case $14,$15,$16
                                    blinktimer = -10.0
                                    If (multiplayer_isfullsync() = $00) Then
                                        positionentity(local10\Field13, entityx(local10\Field1\Field25[$0C], $01), 0.6, entityz(local10\Field1\Field25[$0C], $01), $00)
                                        resetentity(local10\Field13)
                                    EndIf
                                    local10\Field3 = 15.0
                                Case $17,$18,$19
                                    blurtimer = 1500.0
                                    local10\Field3 = 1.0
                                    local10\Field4 = 1.0
                                    blinktimer = -10.0
                                    If (multiplayer_isfullsync() = $00) Then
                                        playsound_strict(oldmansfx($03))
                                        positionentity(local10\Field13, entityx(local10\Field1\Field25[$08], $01), (2288.0 * roomscale), entityz(local10\Field1\Field25[$08], $01), $00)
                                        resetentity(local10\Field13)
                                    EndIf
                            End Select
                            If (multiplayer_isfullsync() = $00) Then
                                updatedoorstimer = 0.0
                                updatedoors()
                                updaterooms()
                            EndIf
                        EndIf
                    Else
                        camerafogcolor(camera, 19.0, 27.5, 23.5)
                        cameraclscolor(camera, 19.0, 27.5, 23.5)
                        If (particleamount > $00) Then
                            If (rand($320, $01) = $01) Then
                                local21 = (entityyaw(camera, $01) + rnd(150.0, 210.0))
                                local7 = createparticle((entityx(local10\Field13, $00) + (cos(local21) * 7.5)), 0.0, (entityz(local10\Field13, $00) + (sin(local21) * 7.5)), $03, 4.0, 0.0, $9C4)
                                entityblend(local7\Field0, $02)
                                local7\Field9 = 0.01
                                local7\Field16 = 0.0
                                pointentity(local7\Field1, camera, 0.0)
                                turnentity(local7\Field1, 0.0, 145.0, 0.0, $01)
                                turnentity(local7\Field1, (Float rand($0A, $14)), 0.0, 0.0, $01)
                            EndIf
                        EndIf
                        If (12.0 < local10\Field3) Then
                            curr106\Field24 = 1.0
                            positionentity(curr106\Field4, entityx(local10\Field1\Field25[(Int local10\Field3)], $01), 0.27, entityz(local10\Field1\Field25[(Int local10\Field3)], $01), $00)
                            pointentity(curr106\Field4, camera, 0.0)
                            turnentity(curr106\Field4, 0.0, (sin((Float (millisecs2() / $14))) * 6.0), 0.0, $01)
                            moveentity(curr106\Field4, 0.0, 0.0, (sin((Float (millisecs2() / $0F))) * 0.06))
                            showentity(curr106\Field0)
                            showentity(curr106\Field4)
                            resetentity(curr106\Field4)
                            curr106\Field44 = 0.0
                            curr106\Field7 = 0.0
                            positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                            rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                            If (((rand($2EE, $01) = $01) And (12.0 < local10\Field3)) <> 0) Then
                                blinktimer = -10.0
                                local10\Field3 = (local10\Field3 - 1.0)
                                playsound_strict(horrorsfx($08))
                            EndIf
                            If (12.0 = local10\Field3) Then
                                camerashake = 1.0
                                positionentity(curr106\Field4, entityx(local10\Field1\Field25[(Int local10\Field3)], $01), -1.0, entityz(local10\Field1\Field25[(Int local10\Field3)], $01), $00)
                                curr106\Field9 = -10.0
                                resetentity(curr106\Field4)
                            EndIf
                        Else
                            curr106\Field9 = -10.0
                            curr106\Field24 = 0.0
                        EndIf
                        If ((-1600.0 * roomscale) > entityy(local10\Field13, $00)) Then
                            If ((144.0 * roomscale) > distance(entityx(local10\Field1\Field25[$10], $01), entityz(local10\Field1\Field25[$10], $01), entityx(local10\Field13, $00), entityz(local10\Field13, $00))) Then
                                If (multiplayer_isfullsync() = $00) Then
                                    camerafogcolor(camera, 0.0, 0.0, 0.0)
                                    cameraclscolor(camera, 0.0, 0.0, 0.0)
                                    dropspeed = 0.0
                                    blurtimer = 500.0
                                    positionentity(local10\Field13, entityx(local10\Field1\Field2, $00), 0.5, entityz(local10\Field1\Field2, $00), $00)
                                    resetentity(local10\Field13)
                                    local10\Field3 = 0.0
                                    updatedoorstimer = 0.0
                                    updatedoors()
                                    updaterooms()
                                EndIf
                            Else
                                If (0.0 <= killtimer) Then
                                    playsound_strict(horrorsfx($08))
                                    kill("was killed in pocket dimension", $01)
                                EndIf
                                blurtimer = 3000.0
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideentity(local10\Field1\Field2)
                    local10\Field2 = 0.0
                    local10\Field3 = 0.0
                    local10\Field4 = 0.0
                    local10\Field11 = "0.0"
                EndIf
            Case $14
                If (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    local10\Field20 = calculatedist(local10\Field13, local10\Field1)
                    If (using294 = $00) Then
                        If (1.5 > entitydistance(local10\Field1\Field25[$00], collider)) Then
                            giveachievement($0A, $01)
                            If (entityinview(local10\Field1\Field25[$00], camera) <> 0) Then
                                drawhandicon = $01
                                If (mousehit1 <> 0) Then
                                    local2 = $01
                                    For local12 = Each items
                                        If (local12\Field15 = $00) Then
                                            If (0.0 = (entityx(local12\Field1, $00) - entityx(local10\Field1\Field25[$01], $01))) Then
                                                If (0.0 = (entityz(local12\Field1, $00) - entityz(local10\Field1\Field25[$01], $01))) Then
                                                    local2 = $00
                                                    Exit
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                    local41 = $00
                                    If (2.0 > local10\Field3) Then
                                        If (selecteditem <> Null) Then
                                            If (((selecteditem\Field3\Field2 = "25ct") Or (selecteditem\Field3\Field2 = "coin")) <> 0) Then
                                                removeitem(selecteditem, $01)
                                                selecteditem = Null
                                                local10\Field3 = (local10\Field3 + 1.0)
                                                playsound_strict(loadtempsound("SFX\SCP\294\coin_drop.ogg"))
                                                local41 = $01
                                            EndIf
                                        EndIf
                                    EndIf
                                    If (2.0 = local10\Field3) Then
                                        using294 = local2
                                        If (using294 <> 0) Then
                                            mousehit1 = $00
                                        EndIf
                                    ElseIf (((1.0 = local10\Field3) And (local41 = $00)) <> 0) Then
                                        using294 = $00
                                        msg = "You need to insert another Quarter in order to use this machine."
                                        msgtimer = 350.0
                                    ElseIf (local41 = $00) Then
                                        using294 = $00
                                        msg = "You need to insert two Quarters in order to use this machine."
                                        msgtimer = 350.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (0.0 = local10\Field2) Then
                    createnpc($10, entityx(local10\Field1\Field2, $00), 0.5, entityz(local10\Field1\Field2, $00))
                    local10\Field2 = 1.0
                EndIf
            Case $34
                If (playerinroom(local10) <> 0) Then
                    If (1.0 > entitydistance(local10\Field1\Field25[$03], collider)) Then
                        If (0.0 = local10\Field2) Then
                            local10\Field2 = max(local10\Field2, 1.0)
                            playsound_strict(horrorsfx($07))
                            playsound_strict(leversfx)
                        EndIf
                    EndIf
                    updatelever(local10\Field1\Field25[$01], $00)
                    local42 = (Int local10\Field3)
                    local10\Field3 = (Float updatelever(local10\Field1\Field25[$03], $00))
                    If ((((Float local42) <> local10\Field3) And (0.0 < local10\Field2)) <> 0) Then
                        playsound2(lightsfx, camera, local10\Field1\Field25[$03], 10.0, 1.0)
                    EndIf
                    If ((Int local10\Field3) <> 0) Then
                        secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                    Else
                        secondarylighton = curvevalue(0.0, secondarylighton, 10.0)
                    EndIf
                    remotedooron = updatelever(local10\Field1\Field25[$05], $00)
                    If (((0.0 < local10\Field2) And (200.0 > local10\Field2)) <> 0) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        rotateentity(local10\Field1\Field25[$03], curvevalue(-85.0, entitypitch(local10\Field1\Field25[$03], $00), 5.0), entityyaw(local10\Field1\Field25[$03], $00), 0.0, $00)
                    EndIf
                EndIf
            Case $13
                If (0.0 = local10\Field2) Then
                    If ((playerinroom(local10) And (2.0 > curr173\Field24)) <> 0) Then
                        If (((local10\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field11 = "load0"
                        EndIf
                    EndIf
                Else
                    local10\Field2 = (local10\Field2 + fpsfactor)
                    If (245.0 > local10\Field2) Then
                        rotateentity(local10\Field1\Field32[$01]\Field4, 0.0, curveangle((Float (local10\Field1\Field6 + $5A)), entityyaw(local10\Field1\Field32[$01]\Field4, $00), 100.0), 0.0, $01)
                        local10\Field1\Field32[$00]\Field9 = 1.0
                        If (((224.0 < local10\Field2) And (224.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                            playsound2(introsfx($0F), camera, local10\Field1\Field2, 15.0, 1.0)
                        EndIf
                    ElseIf (455.0 > local10\Field2) Then
                        If (245.0 > (local10\Field2 - fpsfactor)) Then
                            local10\Field1\Field32[$00]\Field9 = 0.0
                            local10\Field1\Field32[$01]\Field17 = playsound2(local10\Field1\Field32[$01]\Field16, camera, local10\Field1\Field32[$01]\Field4, 12.0, 1.0)
                        EndIf
                        If (315.0 < local10\Field2) Then
                            pointentity(local10\Field1\Field32[$00]\Field0, local10\Field1\Field2, 0.0)
                            rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$00]\Field0, $00), entityyaw(local10\Field1\Field32[$00]\Field4, $00), 30.0), 0.0, $01)
                        EndIf
                        pointentity(local10\Field1\Field32[$01]\Field0, local10\Field1\Field2, 0.0)
                        turnentity(local10\Field1\Field32[$01]\Field0, 0.0, (sin(local10\Field2) * 25.0), 0.0, $00)
                        rotateentity(local10\Field1\Field32[$01]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$01]\Field0, $00), entityyaw(local10\Field1\Field32[$01]\Field4, $00), 30.0), 0.0, $01)
                    Else
                        If (455.0 > (local10\Field2 - fpsfactor)) Then
                            playsound_strict(horrorsfx($00))
                            playsound_strict(lightsfx)
                        EndIf
                        blinktimer = max((((455.0 - local10\Field2) / 5.0) - rnd(0.0, 2.0)), -10.0)
                        If (-10.0 = blinktimer) Then
                            If (((525.0 < local10\Field2) And (525.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                playsound2(necksnapsfx($00), camera, local10\Field1\Field32[$00]\Field4, 8.0, 1.0)
                                local12 = createitem("Wallet", "wallet", entityx(local10\Field1\Field32[$00]\Field4, $01), entityy(local10\Field1\Field32[$00]\Field4, $01), entityz(local10\Field1\Field32[$00]\Field4, $01), $00, $00, $00, 1.0, $00, $01)
                                entitytype(local12\Field1, $03, $00)
                                pointentity(local12\Field1, local10\Field1\Field32[$01]\Field4, 0.0)
                                moveentity(local12\Field1, -0.4, 0.0, -0.2)
                                teleportentity(local12\Field1, entityx(local12\Field1, $00), entityy(local12\Field1, $00), entityz(local12\Field1, $00), -0.02, $01, 10.0, $00)
                                moveentity(local12\Field1, 0.0, 0.5, 0.0)
                                For local1 = $00 To $01 Step $01
                                    local13 = createitem("Quarter", "25ct", entityx(local10\Field1\Field32[$00]\Field4, $01), entityy(local10\Field1\Field32[$00]\Field4, $01), entityz(local10\Field1\Field32[$00]\Field4, $01), $00, $00, $00, 1.0, $00, $01)
                                    local13\Field15 = $00
                                    local13\Field3\Field4 = $01
                                    entitytype(local13\Field1, $03, $00)
                                Next
                            EndIf
                            If (((560.0 < local10\Field2) And (560.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                playsound2(necksnapsfx($01), camera, local10\Field1\Field32[$01]\Field4, 8.0, 1.0)
                            EndIf
                            setnpcframe(local10\Field1\Field32[$00], 60.0)
                            local10\Field1\Field32[$00]\Field9 = 8.0
                            setnpcframe(local10\Field1\Field32[$01], 19.0)
                            local10\Field1\Field32[$01]\Field9 = 6.0
                        EndIf
                        If (595.0 < local10\Field2) Then
                            positionentity(curr173\Field4, ((entityx(local10\Field1\Field25[$00], $01) + entityx(local10\Field1\Field25[$01], $01)) / 2.0), entityy(local10\Field1\Field25[$00], $01), ((entityz(local10\Field1\Field25[$00], $01) + entityz(local10\Field1\Field25[$01], $01)) / 2.0), $00)
                            pointentity(curr173\Field4, local10\Field13, 0.0)
                            resetentity(curr173\Field4)
                            removeevent(local10)
                            debuglog("Flkd")
                        EndIf
                    EndIf
                EndIf
            Case $11
                If (playerinroom(local10) <> 0) Then
                    If (((0.0 = local10\Field2) And (0.0 = curr173\Field24)) <> 0) Then
                        If (entityinview(curr173\Field0, getplayercamera(local10\Field14)) = $00) Then
                            local10\Field2 = 1.0
                            positionentity(curr173\Field4, entityx(local10\Field1\Field25[$00], $01), 0.5, entityz(local10\Field1\Field25[$00], $01), $00)
                            resetentity(curr173\Field4)
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $0D
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    If (((8.0 > local10\Field20) And (0.0 < local10\Field20)) <> 0) Then
                        local10\Field1\Field32[$00] = createnpc($03, entityx(local10\Field1\Field2, $01), 0.5, entityz(local10\Field1\Field2, $01))
                        pointentity(local10\Field1\Field32[$00]\Field4, local10\Field13, 0.0)
                        rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, entityyaw(local10\Field1\Field32[$00]\Field4, $00), 0.0, $01)
                        local10\Field2 = 1.0
                    EndIf
                ElseIf (1.0 = local10\Field2) Then
                    If (((5.0 > local10\Field20) Or (rand($2BC, $01) = $01)) <> 0) Then
                        local10\Field2 = 2.0
                        local10\Field1\Field32[$00]\Field9 = 5.0
                        local10\Field1\Field32[$00]\Field33 = entityx(local10\Field1\Field25[$01], $01)
                        local10\Field1\Field32[$00]\Field34 = entityy(local10\Field1\Field25[$01], $01)
                        local10\Field1\Field32[$00]\Field35 = entityz(local10\Field1\Field25[$01], $01)
                    EndIf
                ElseIf (2.0 = local10\Field2) Then
                    If (2.0 > entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field1\Field25[$01])) Then
                        local10\Field1\Field29[$00]\Field5 = $00
                        playsound2(closedoorsfx($03, $00), camera, local10\Field1\Field29[$00]\Field0, 8.0, 1.0)
                        playsound_strict(loadtempsound("SFX\Room\Room2ElevatorDeath.ogg"))
                        local10\Field2 = 2.05
                    EndIf
                ElseIf (910.0 > local10\Field2) Then
                    local10\Field2 = (local10\Field2 + fpsfactor)
                    If (((469.0 < local10\Field2) And (518.0 > local10\Field2)) <> 0) Then
                        camerashake = (7.4 - (local10\Field2 / 70.0))
                    ElseIf (((602.0 < local10\Field2) And (742.0 > local10\Field2)) <> 0) Then
                        camerashake = (10.6 - (local10\Field2 / 70.0))
                    ElseIf (882.0 < local10\Field2) Then
                        camerashake = 0.0
                        If (((882.0 > (local10\Field2 - fpsfactor)) And (local10\Field1\Field32[$00] <> Null)) <> 0) Then
                            removenpc(local10\Field1\Field32[$00], $00)
                            local10\Field1\Field32[$00] = Null
                            local32 = createdecal($03, entityx(local10\Field1\Field25[$00], $01), 0.0005, entityz(local10\Field1\Field25[$00], $01), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                            local32 = createdecal($11, entityx(local10\Field1\Field25[$00], $01), 0.002, entityz(local10\Field1\Field25[$00], $01), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.5
                            local32 = createdecal($03, entityx(local10\Field1\Field25[$01], $01), entityy(local10\Field1\Field25[$01], $01), entityz(local10\Field1\Field25[$01], $01), 0.0, (Float (local10\Field1\Field6 + $10E)), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.9
                        EndIf
                        local10\Field1\Field29[$00]\Field4 = $00
                    EndIf
                ElseIf (local10\Field1\Field29[$00]\Field5 <> 0) Then
                    local10\Field1\Field29[$00]\Field4 = $01
                    removeevent(local10)
                EndIf
            Case $0C
                local10\Field24 = $00
                If (((8.0 > local10\Field20) And (0.0 < local10\Field20)) <> 0) Then
                    local32 = createdecal($03, entityx(local10\Field1\Field25[$00], $01), 0.0005, entityz(local10\Field1\Field25[$00], $01), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                    local10\Field1\Field32[$00] = createnpc($04, entityx(local10\Field1\Field25[$00], $01), 0.5, entityz(local10\Field1\Field25[$00], $01))
                    changenpctextureid(local10\Field1\Field32[$00], $00)
                    rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, (entityyaw(local10\Field1\Field2, $00) - 80.0), 0.0, $01)
                    setnpcframe(local10\Field1\Field32[$00], 19.0)
                    local10\Field1\Field32[$00]\Field9 = 8.0
                    local10\Field1\Field32[$00] = Null
                    removeevent(local10)
                EndIf
            Case $0B
                If (playerinroom(local10) <> 0) Then
                    turnentity(local10\Field1\Field25[$00], (local10\Field4 * fpsfactor), 0.0, 0.0, $00)
                    If (0.01 < local10\Field4) Then
                        local10\Field1\Field9 = loopsound2(roomambience[$09], local10\Field1\Field9, camera, local10\Field1\Field25[$00], 5.0, (local10\Field4 / 4.0))
                    EndIf
                    local10\Field4 = curvevalue((local10\Field3 * 5.0), local10\Field4, 150.0)
                EndIf
                If (16.0 > local10\Field20) Then
                    If (0.0 > local10\Field2) Then
                        local10\Field2 = (Float (rand($0F, $1E) * $46))
                        local2 = (Int local10\Field3)
                        local10\Field3 = (Float rand($00, $01))
                        If (playerinroom(local10) = $00) Then
                            local10\Field4 = (local10\Field3 * 5.0)
                        ElseIf (((local2 = $00) And (1.0 = local10\Field3)) <> 0) Then
                            playsound2(loadtempsound("SFX\ambient\Room ambience\FanOn.ogg"), camera, local10\Field1\Field25[$00], 8.0, 1.0)
                        ElseIf (((local2 = $01) And (0.0 = local10\Field3)) <> 0) Then
                            playsound2(loadtempsound("SFX\ambient\Room ambience\FanOff.ogg"), camera, local10\Field1\Field25[$00], 8.0, 1.0)
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 - fpsfactor)
                    EndIf
                EndIf
            Case $1F
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    local10\Field1\Field29[$00]\Field28 = updateelevators(local10\Field1\Field29[$00]\Field28, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$04], local10\Field1\Field25[$05], $01)
                    local10\Field2 = (Float updatelever(local10\Field1\Field25[$01], $00))
                    updatelever(local10\Field1\Field25[$03], $00)
                EndIf
                If (0.0 = local10\Field4) Then
                    local8 = createnpc($04, entityx(local10\Field1\Field25[$06], $01), 0.5, entityz(local10\Field1\Field25[$06], $01))
                    rotateentity(local8\Field4, 0.0, (Float (local10\Field1\Field6 + $5A)), 0.0, $00)
                    local8\Field9 = 3.0
                    local8\Field48 = $01
                    local8\Field23 = "GFX\npcs\body2.jpg"
                    changenpctextureid(local8, $08)
                    local10\Field4 = 1.0
                    setnpcframe(local8, 40.0)
                EndIf
            Case $12
                If (playerinroom(local10) <> 0) Then
                    If (((-8.0 > blinktimer) And (-12.0 < blinktimer)) <> 0) Then
                        local2 = rand($01, $04)
                        positionentity(local10\Field1\Field25[$00], entityx(local10\Field1\Field25[local2], $01), entityy(local10\Field1\Field25[local2], $01), entityz(local10\Field1\Field25[local2], $01), $01)
                        rotateentity(local10\Field1\Field25[$00], 0.0, rnd(360.0, 0.0), 0.0, $00)
                    EndIf
                EndIf
            Case $17
                If (playerinroom(local10) <> 0) Then
                    local10\Field2 = (local10\Field2 + fpsfactor)
                    If (700.0 < local10\Field2) Then
                        If (0.5 < entitydistance(local10\Field1\Field29[$00]\Field0, local10\Field13)) Then
                            If (entityinview(local10\Field1\Field29[$00]\Field0, getplayercamera(local10\Field14)) = $00) Then
                                debuglog("%@@= \ {2E6C2=FD gi`h]c")
                                local10\Field1\Field29[$00]\Field5 = $00
                                removeevent(local10)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $1E
                local10\Field24 = $00
                local2 = $01
                If (((245.0 < local10\Field3) And (6300.0 > local10\Field3)) <> 0) Then
                    local2 = $00
                EndIf
                If (((local2 And ((entityy(local10\Field1\Field2, $01) < entityy(local10\Field13, $01)) Or (entityy(local10\Field1\Field2, $01) < entityy(collider, $01)))) And ((4.0 > entityy(local10\Field13, $01)) Or (4.0 > entityy(collider, $01)))) <> 0) Then
                    If (local10\Field7 = $00) Then
                        local10\Field7 = loadsound_strict("SFX\Room\Tesla\Shock.ogg")
                    EndIf
                    If (0.0 = local10\Field2) Then
                        hideentity(local10\Field1\Field25[$03])
                        If ((millisecs2() Mod $5DC) < $320) Then
                            showentity(local10\Field1\Field25[$04])
                        Else
                            hideentity(local10\Field1\Field25[$04])
                        EndIf
                        If (8.0 > local10\Field20) Then
                            If (local10\Field5 = $00) Then
                                local10\Field5 = playsound2(teslaidlesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                            ElseIf (channelplaying(local10\Field5) = $00) Then
                                local10\Field5 = playsound2(teslaidlesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                            EndIf
                            For local1 = $00 To $02 Step $01
                                If ((300.0 * roomscale) > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) Then
                                    If (0.0 <= killtimer) Then
                                        playersoundvolume = max(8.0, playersoundvolume)
                                        stopchannel(local10\Field5)
                                        local10\Field5 = playsound2(teslaactivatesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                                        local10\Field2 = 1.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            local43 = $01
                            For local11 = Each events
                                If (((local11\Field0 = local10\Field0) And (local11 <> local10)) <> 0) Then
                                    If (local11\Field11 <> "") Then
                                        local43 = $00
                                        local10\Field11 = "done"
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            local44 = $00
                            If (local43 <> 0) Then
                                If (((local10\Field11 = "") And playerinroom(local10)) <> 0) Then
                                    If (entitydistance(local10\Field1\Field25[$06], local10\Field13) > entitydistance(local10\Field1\Field25[$05], local10\Field13)) Then
                                        local44 = $06
                                    Else
                                        local44 = $05
                                    EndIf
                                    local10\Field1\Field32[$00] = createnpc($16, entityx(local10\Field1\Field25[local44], $01), 0.5, entityz(local10\Field1\Field25[local44], $01))
                                    pointentity(local10\Field1\Field32[$00]\Field4, local10\Field1\Field25[$02], 0.0)
                                    local10\Field1\Field32[$00]\Field9 = 2.0
                                    local10\Field11 = "step1"
                                    local10\Field2 = 0.0
                                    local10\Field3 = 0.0
                                    local10\Field4 = 0.0
                                EndIf
                            EndIf
                        Else
                            hideentity(local10\Field1\Field25[$04])
                        EndIf
                        If (((-10.0 >= curr106\Field9) And (0.0 = local10\Field2)) <> 0) Then
                            For local1 = $00 To $02 Step $01
                                If ((300.0 * roomscale) > distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) Then
                                    If (0.0 <= killtimer) Then
                                        stopchannel(local10\Field5)
                                        local10\Field5 = playsound2(teslaactivatesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                                        hideentity(local10\Field1\Field25[$04])
                                        local10\Field2 = 1.0
                                        curr106\Field9 = (Float (rand($0A, $0D) * $1068))
                                        giveachievement($20, $01)
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        If (40.0 >= local10\Field2) Then
                            hideentity(local10\Field1\Field25[$03])
                            If ((millisecs2() Mod $64) < $32) Then
                                showentity(local10\Field1\Field25[$04])
                            Else
                                hideentity(local10\Field1\Field25[$04])
                            EndIf
                        Else
                            If (40.0 >= (local10\Field2 - fpsfactor)) Then
                                playsound2(local10\Field7, camera, local10\Field1\Field25[$02], 10.0, 1.0)
                            EndIf
                            If (70.0 > local10\Field2) Then
                                If (0.0 <= killtimer) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((((250.0 * roomscale) > distance3(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field25[local1], $01), entityy(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) And (player_isdead() = $00)) <> 0) Then
                                            showentity(light)
                                            lightflash = 0.4
                                            camerashake = 1.0
                                            kill("was killed by tesla", $00)
                                            deathmsg = "Subject D-9341 killed by the Tesla gate at [REDACTED]."
                                        EndIf
                                    Next
                                EndIf
                                If (local10\Field11 = "step1") Then
                                    local10\Field1\Field32[$00]\Field9 = 3.0
                                EndIf
                                If (-10.0 >= curr106\Field9) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((300.0 * roomscale) > distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) Then
                                            showentity(light)
                                            lightflash = 0.3
                                            If (particleamount > $00) Then
                                                For local1 = $00 To (((particleamount - $01) * $05) + $05) Step $01
                                                    local7 = createparticle(entityx(curr106\Field4, $01), entityy(curr106\Field4, $01), entityz(curr106\Field4, $01), $00, 0.015, -0.2, $FA)
                                                    local7\Field7 = 0.03
                                                    local7\Field11 = -0.2
                                                    local7\Field17 = 200.0
                                                    local7\Field16 = 0.005
                                                    local7\Field9 = 0.001
                                                    rotateentity(local7\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                                Next
                                            EndIf
                                            curr106\Field9 = -20000.0
                                            translateentity(curr106\Field4, 0.0, -50.0, 0.0, $01)
                                        EndIf
                                    Next
                                EndIf
                                hideentity(local10\Field1\Field25[$03])
                                hideentity(local10\Field1\Field25[$04])
                                If (rand($05, $01) < $05) Then
                                    positiontexture(teslatexture, 0.0, rnd(0.0, 1.0))
                                    showentity(local10\Field1\Field25[$03])
                                EndIf
                            Else
                                If (70.0 > (local10\Field2 - fpsfactor)) Then
                                    stopchannel(local10\Field5)
                                    local10\Field5 = playsound2(teslapowerupsfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                                EndIf
                                hideentity(local10\Field1\Field25[$03])
                                If (150.0 < local10\Field2) Then
                                    local10\Field2 = 0.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideentity(local10\Field1\Field25[$04])
                EndIf
                If (local10\Field1\Field32[$00] <> Null) Then
                    If (((local10\Field11 = "step1") And (3.0 <> local10\Field1\Field32[$00]\Field9)) <> 0) Then
                        If (0.0 = local10\Field2) Then
                            For local1 = $00 To $02 Step $01
                                If ((400.0 * roomscale) > distance(entityx(local10\Field1\Field32[$00]\Field4, $00), entityz(local10\Field1\Field32[$00]\Field4, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) Then
                                    stopchannel(local10\Field5)
                                    local10\Field5 = playsound2(teslaactivatesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                                    hideentity(local10\Field1\Field25[$04])
                                    local10\Field2 = 1.0
                                    Exit
                                EndIf
                            Next
                        EndIf
                    ElseIf (((local10\Field11 = "step1") And (3.0 = local10\Field1\Field32[$00]\Field9)) <> 0) Then
                        local10\Field1\Field32[$00]\Field22 = 0.0
                        animatenpc(local10\Field1\Field32[$00], 41.0, 60.0, 0.5, $00)
                        If (60.0 = local10\Field1\Field32[$00]\Field14) Then
                            local10\Field1\Field32[$00]\Field48 = $01
                            local10\Field11 = "step2"
                            setnpcframe(local10\Field1\Field32[$00], 57.0)
                        EndIf
                    ElseIf (local10\Field11 = "step2") Then
                        animatenpc(local10\Field1\Field32[$00], 57.0, 60.0, 0.5, $00)
                        If (60.0 = local10\Field1\Field32[$00]\Field14) Then
                            local10\Field11 = "0"
                        EndIf
                    ElseIf ((((local10\Field11 <> "") And (local10\Field11 <> "step1")) And (local10\Field11 <> "done")) <> 0) Then
                        If (700.0 > (Float local10\Field11)) Then
                            If (particleamount > $00) Then
                                If (rand(($14 - ((particleamount - $01) * $0A)), $01) = $01) Then
                                    local7 = createparticle(entityx(local10\Field1\Field32[$00]\Field4, $00), (entityy(local10\Field1\Field32[$00]\Field0, $00) + 0.05), entityz(local10\Field1\Field32[$00]\Field4, $00), $00, 0.05, 0.0, $3C)
                                    local7\Field9 = 0.002
                                    rotateentity(local7\Field1, 0.0, entityyaw(local10\Field1\Field32[$00]\Field4, $00), 0.0, $00)
                                    moveentity(local7\Field1, rnd(-0.1, 0.1), 0.0, (rnd(0.0, 0.5) + 0.1))
                                    rotateentity(local7\Field1, -90.0, entityyaw(local10\Field1\Field32[$00]\Field4, $00), 0.0, $00)
                                    local7\Field15 = -0.02
                                EndIf
                            EndIf
                            local10\Field11 = (Str ((Float local10\Field11) + fpsfactor))
                        Else
                            local10\Field11 = "done"
                        EndIf
                    EndIf
                EndIf
                If (((playerroom\Field7\Field11 <> "pocketdimension") And (playerroom\Field7\Field11 <> "room860")) <> 0) Then
                    If (0.0 = local10\Field3) Then
                        If (0.0 >= local10\Field4) Then
                            local2 = $00
                            For local8 = Each npcs
                                If (local8\Field5 = $08) Then
                                    If (4.0 > (Abs (entityx(local8\Field4, $00) - entityx(local10\Field1\Field2, $01)))) Then
                                        If (4.0 > (Abs (entityz(local8\Field4, $00) - entityz(local10\Field1\Field2, $01)))) Then
                                            local2 = $01
                                            If (0.0 = local10\Field3) Then
                                                local8\Field16 = loadsound_strict("SFX\Character\MTF\Tesla0.ogg")
                                                playmtfsound(local8\Field16, local8)
                                                local8\Field24 = 700.0
                                                local10\Field3 = 7000.0
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local2 = $00) Then
                                local10\Field3 = 245.0
                            EndIf
                            local10\Field4 = (local10\Field4 + 140.0)
                        Else
                            local10\Field4 = (local10\Field4 - fpsfactor)
                        EndIf
                    Else
                        If (((6440.0 <= local10\Field3) And (6440.0 > (local10\Field3 - fpsfactor))) <> 0) Then
                        EndIf
                        local10\Field3 = max((local10\Field3 - fpsfactor), 0.0)
                    EndIf
                EndIf
            Case $05
                local10\Field13 = collider
                If (playerroom = local10\Field1) Then
                    If (2.0 > entitydistance(local10\Field1\Field2, local10\Field13)) Then
                        If (((6.0 > entitydistance(local10\Field13, curr173\Field0)) Or (6.0 > entitydistance(local10\Field13, curr106\Field0))) <> 0) Then
                            removeevent(local10)
                        Else
                            debuglog("%@@= \ {2E6C2=FD gi`h]c")
                            local3 = createpivot($00)
                            positionentity(local3, entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00)
                            pointentity(local3, local10\Field1\Field2, 0.0)
                            rotateentity(local3, 0.0, entityyaw(local3, $00), 0.0, $01)
                            moveentity(local3, 0.0, 0.0, (entitydistance(local3, local10\Field1\Field2) * 2.0))
                            blinktimer = -10.0
                            playsound_strict(horrorsfx($0B))
                            positionentity(local10\Field13, entityx(local3, $00), (entityy(local3, $00) + 0.05), entityz(local3, $00), $00)
                            updateworld(1.0)
                            turnentity(local10\Field13, 0.0, 180.0, 0.0, $00)
                            freeentity(local3)
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $33
                If (((8.0 <= entityy(collider, $01)) And (12.0 >= entityy(collider, $01))) <> 0) Then
                    If ((((local10\Field1\Field3 - 6.0) <= entityx(collider, $01)) And (((local10\Field1\Field3 + 38.0) + 6.0) >= entityx(collider, $01))) <> 0) Then
                        If ((((local10\Field1\Field5 - 6.0) <= entityz(collider, $01)) And (((local10\Field1\Field5 + 38.0) + 6.0) >= entityz(collider, $01))) <> 0) Then
                            playerroom = local10\Field1
                        EndIf
                    EndIf
                EndIf
                If (((playerinroom(local10) And networkserver\Field18) Or (playerroom = local10\Field1)) <> 0) Then
                    If (i_zone\Field2 <> 0) Then
                        If (local10\Field1\Field33\Field2[$00] = $00) Then
                            placegrid_mapcreator(local10\Field1)
                        EndIf
                    EndIf
                    If (local10\Field1\Field33 = Null) Then
                        local10\Field1\Field33 = (New grids)
                        local56 = rndseed()
                        seedrnd(generateseednumber(randomseed))
                        local57 = (rand($00, $01) Shl $01)
                        local54 = (rand($FFFFFFFE, $02) + $09)
                        local55 = (rand($FFFFFFFE, $02) + $09)
                        local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $01
                        If (local57 = $02) Then
                            local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] = $01
                        Else
                            local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] = $01
                        EndIf
                        local58 = $02
                        While (local58 < $64)
                            local52 = (rand($01, $05) Shl rand($01, $02))
                            For local1 = $01 To local52 Step $01
                                local53 = $01
                                Select local57
                                    Case $00
                                        If (local54 < ($11 - (local1 Mod $02))) Then
                                            local54 = (local54 + $01)
                                        Else
                                            local53 = $00
                                        EndIf
                                    Case $01
                                        If (local55 < ($11 - (local1 Mod $02))) Then
                                            local55 = (local55 + $01)
                                        Else
                                            local53 = $00
                                        EndIf
                                    Case $02
                                        If (local54 > ((local1 Mod $02) + $01)) Then
                                            local54 = (local54 - $01)
                                        Else
                                            local53 = $00
                                        EndIf
                                    Case $03
                                        If (local55 > ((local1 Mod $02) + $01)) Then
                                            local55 = (local55 - $01)
                                        Else
                                            local53 = $00
                                        EndIf
                                End Select
                                If (local53 <> 0) Then
                                    If (local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $00) Then
                                        local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $01
                                        local58 = (local58 + $01)
                                    EndIf
                                Else
                                    Exit
                                EndIf
                            Next
                            local57 = (local57 + ((rand($00, $01) Shl $01) - $01))
                            While (local57 < $00)
                                local57 = (local57 + $04)
                            Wend
                            While (local57 > $03)
                                local57 = (local57 - $04)
                            Wend
                        Wend
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local55 * $13) + local54)] > $00) Then
                                    local10\Field1\Field33\Field0[((local55 * $13) + local54)] = ((((local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] > $00) + (local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)] > $00)) + (local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] > $00)) + (local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] > $00))
                                EndIf
                            Next
                        Next
                        local60 = $12
                        local61 = $00
                        For local54 = $00 To local60 Step $01
                            For local55 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] > $00) Then
                                    local60 = local54
                                    If (((local10\Field1\Field33\Field0[((local54 + $01) + ((local55 + $01) * $13))] < $03) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $03)) <> 0) Then
                                        local61 = $01
                                        If (rand($00, $01) = $01) Then
                                            local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] = (local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] + $01)
                                            local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $07
                                            local61 = $00
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local61 <> 0) Then
                                local54 = (local54 - $01)
                            EndIf
                        Next
                        local62 = $FFFFFFFF
                        local65 = $FFFFFFFF
                        local62 = $FFFFFFFF
                        local65 = $FFFFFFFF
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $02) Then
                                    If (((local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] > $00) And (local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] > $00)) <> 0) Then
                                        If (((local62 = $FFFFFFFF) Or (local64 = $FFFFFFFF)) <> 0) Then
                                            If (((((local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] < $03) And (local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] < $03)) And (local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)] < $03)) And (local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] < $03)) <> 0) Then
                                                If (((((local10\Field1\Field33\Field0[((local54 - $01) + ((local55 - $01) * $13))] < $01) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local54 - $01) + ((local55 + $01) * $13))] < $01)) <> 0) Then
                                                    local62 = local54
                                                    local64 = local55
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (((((local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] < $03) And (local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] < $03)) And (local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)] < $03)) And (local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] < $03)) <> 0) Then
                                            If (((((local10\Field1\Field33\Field0[((local54 - $01) + ((local55 - $01) * $13))] < $01) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local54 - $01) + ((local55 + $01) * $13))] < $01)) <> 0) Then
                                                local63 = local54
                                                local65 = local55
                                            EndIf
                                        EndIf
                                    ElseIf (((local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] > $00) And (local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)] > $00)) <> 0) Then
                                        If (((local62 = $FFFFFFFF) Or (local64 = $FFFFFFFF)) <> 0) Then
                                            If (((((local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] < $03) And (local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] < $03)) And (local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)] < $03)) And (local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] < $03)) <> 0) Then
                                                If (((((local10\Field1\Field33\Field0[((local54 - $01) + ((local55 - $01) * $13))] < $01) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local54 - $01) + ((local55 + $01) * $13))] < $01)) <> 0) Then
                                                    local62 = local54
                                                    local64 = local55
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (((((local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] < $03) And (local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] < $03)) And (local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)] < $03)) And (local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] < $03)) <> 0) Then
                                            If (((((local10\Field1\Field33\Field0[((local54 - $01) + ((local55 - $01) * $13))] < $01) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local54 - $01) + ((local55 + $01) * $13))] < $01)) <> 0) Then
                                                local63 = local54
                                                local65 = local55
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        If (((local63 = local62) And (local65 = local64)) <> 0) Then
                            runtimeerror("The maintenance tunnels could not be generated properly!")
                        EndIf
                        For local1 = $00 To $06 Step $01
                            local45[local1] = copyentity(objtunnel(local1), $00)
                            debuglog((Str local1))
                            hideentity(local45[local1])
                        Next
                        freetexturecache()
                        local52 = $00
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local55 * $13) + local54)] > $00) Then
                                    Select local10\Field1\Field33\Field0[((local55 * $13) + local54)]
                                        Case $01,$07
                                            local52 = copyentity(local45[(local10\Field1\Field33\Field0[((local55 * $13) + local54)] - $01)], $00)
                                            If (local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] > $00) Then
                                                rotateentity(local52, 0.0, 90.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $01
                                            ElseIf (local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] > $00) Then
                                                rotateentity(local52, 0.0, 270.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $03
                                            ElseIf (local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] > $00) Then
                                                rotateentity(local52, 0.0, 180.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $02
                                            Else
                                                rotateentity(local52, 0.0, 0.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $00
                                            EndIf
                                        Case $02
                                            If ((((local54 = local62) And (local55 = local64)) Or ((local54 = local63) And (local55 = local65))) <> 0) Then
                                                local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $06
                                            EndIf
                                            If (((local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] > $00) And (local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] > $00)) <> 0) Then
                                                local52 = copyentity(local45[(local10\Field1\Field33\Field0[((local55 * $13) + local54)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local53 = rand($00, $01)
                                                rotateentity(local52, 0.0, (((Float local53) * 180.0) + 90.0), 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = ((local53 Shl $01) + $01)
                                            ElseIf (((local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] > $00) And (local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)] > $00)) <> 0) Then
                                                local52 = copyentity(local45[(local10\Field1\Field33\Field0[((local55 * $13) + local54)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local53 = rand($00, $01)
                                                rotateentity(local52, 0.0, ((Float local53) * 180.0), 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = (local53 Shl $01)
                                            Else
                                                local52 = copyentity(local45[local10\Field1\Field33\Field0[((local55 * $13) + local54)]], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local47 = local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)]
                                                local48 = local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)]
                                                local49 = local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))]
                                                local50 = local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))]
                                                If (((local47 > $00) And (local49 > $00)) <> 0) Then
                                                    rotateentity(local52, 0.0, 0.0, 0.0, $00)
                                                    local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $00
                                                ElseIf (((local47 > $00) And (local50 > $00)) <> 0) Then
                                                    rotateentity(local52, 0.0, 90.0, 0.0, $00)
                                                    local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $01
                                                ElseIf (((local48 > $00) And (local49 > $00)) <> 0) Then
                                                    rotateentity(local52, 0.0, 270.0, 0.0, $00)
                                                    local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $03
                                                Else
                                                    rotateentity(local52, 0.0, 180.0, 0.0, $00)
                                                    local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $02
                                                EndIf
                                            EndIf
                                            If (((local54 = local62) And (local55 = local64)) <> 0) Then
                                                local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $05
                                            EndIf
                                        Case $03
                                            local52 = copyentity(local45[local10\Field1\Field33\Field0[((local55 * $13) + local54)]], $00)
                                            local47 = local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)]
                                            local48 = local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)]
                                            local49 = local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))]
                                            local50 = local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))]
                                            If ((((local47 > $00) And (local49 > $00)) And (local50 > $00)) <> 0) Then
                                                rotateentity(local52, 0.0, 90.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $01
                                            ElseIf ((((local48 > $00) And (local49 > $00)) And (local50 > $00)) <> 0) Then
                                                rotateentity(local52, 0.0, 270.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $03
                                            ElseIf ((((local49 > $00) And (local47 > $00)) And (local48 > $00)) <> 0) Then
                                                rotateentity(local52, 0.0, 0.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $00
                                            Else
                                                rotateentity(local52, 0.0, 180.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local55 * $13) + local54)] = $02
                                            EndIf
                                        Case $04
                                            local52 = copyentity(local45[local10\Field1\Field33\Field0[((local55 * $13) + local54)]], $00)
                                            local53 = rand($00, $03)
                                            rotateentity(local52, 0.0, ((Float local53) * 90.0), 0.0, $00)
                                            local10\Field1\Field33\Field1[((local55 * $13) + local54)] = local53
                                    End Select
                                    scaleentity(local52, roomscale, roomscale, roomscale, $01)
                                    positionentity(local52, (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                    Select local10\Field1\Field33\Field0[((local55 * $13) + local54)]
                                        Case $01
                                            addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $03,$04
                                            addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $07
                                            addlight(Null, (((local10\Field1\Field3 + ((Float local54) * 2.0)) - ((sin(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local52, $01)) * 16.0) * roomscale)), ((396.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((cos(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local52, $01)) * 16.0) * roomscale)), $02, (500.0 * roomscale), $FF, $C8, $C8)
                                            local12 = createitem("SCP-500-01", "scp500", (((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * -208.0) * roomscale)) - ((sin(entityyaw(local52, $01)) * 1226.0) * roomscale)), ((80.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * -208.0) * roomscale)) + ((cos(entityyaw(local52, $01)) * 1226.0) * roomscale)), $00, $00, $00, 1.0, $00, $01)
                                            entitytype(local12\Field1, $03, $00)
                                            local12 = createitem("Night Vision Goggles", "nvgoggles", (((local10\Field1\Field3 + ((Float local54) * 2.0)) - ((sin(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local52, $01)) * 16.0) * roomscale)), ((80.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((cos(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local52, $01)) * 16.0) * roomscale)), $00, $00, $00, 1.0, $00, $01)
                                            entitytype(local12\Field1, $03, $00)
                                    End Select
                                    If (((local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $06) Or (local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $05)) <> 0) Then
                                        local51 = createdoor(local10\Field1\Field0, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 240.0) * roomscale)), 8.0, ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 240.0) * roomscale)), (entityyaw(local52, $01) + 90.0), Null, $00, $03, $00, "", $00)
                                        positionentity(local51\Field3[$00], (entityx(local51\Field3[$00], $01) + (cos(entityyaw(local52, $01)) * 0.05)), (entityy(local51\Field3[$00], $01) + 0.0), (entityz(local51\Field3[$00], $01) + (sin(entityyaw(local52, $01)) * 0.05)), $01)
                                        addlight(Null, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 555.0) * roomscale)), ((469.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 555.0) * roomscale)), $02, (600.0 * roomscale), $FF, $FF, $FF)
                                        local53 = createpivot($00)
                                        rotateentity(local53, 0.0, (entityyaw(local52, $01) + 180.0), 0.0, $01)
                                        positionentity(local53, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 552.0) * roomscale)), ((240.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 552.0) * roomscale)), $00)
                                        If (local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $06) Then
                                            If (local10\Field1\Field29[$01] = Null) Then
                                                local51\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                                local10\Field1\Field29[$01] = local51
                                                adddoortooptsystem(local10\Field1, local51)
                                            Else
                                                removedoor(local51)
                                            EndIf
                                            If (local10\Field1\Field25[$03] = $00) Then
                                                local10\Field1\Field25[$03] = local53
                                                positionentity(local10\Field1\Field25[$01], (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                            Else
                                                freeentity(local53)
                                            EndIf
                                        Else
                                            If (local10\Field1\Field29[$03] = Null) Then
                                                local51\Field5 = (local10\Field1\Field29[$02]\Field5 = $00)
                                                local10\Field1\Field29[$03] = local51
                                                adddoortooptsystem(local10\Field1, local51)
                                            Else
                                                removedoor(local51)
                                            EndIf
                                            If (local10\Field1\Field25[$05] = $00) Then
                                                local10\Field1\Field25[$05] = local53
                                                positionentity(local10\Field1\Field25[$00], (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                            Else
                                                freeentity(local53)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local10\Field1\Field33\Field3[((local55 * $13) + local54)] = local52
                                    local68 = createwaypoint((local10\Field1\Field3 + ((Float local54) * 2.0)), 8.2, (local10\Field1\Field5 + ((Float local55) * 2.0)), Null, local10\Field1)
                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)] = local68
                                    If (local55 < $12) Then
                                        If (local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local55 > $00) Then
                                        If (local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local54 > $00) Then
                                        If (local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local54 < $12) Then
                                        If (local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        For local1 = $00 To $06 Step $01
                            local10\Field1\Field33\Field2[local1] = local45[local1]
                        Next
                        positionentity(local10\Field1\Field25[$00], (local10\Field1\Field3 + ((Float local62) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local64) * 2.0)), $01)
                        positionentity(local10\Field1\Field25[$01], (local10\Field1\Field3 + ((Float local63) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local65) * 2.0)), $01)
                    ElseIf (local10\Field1\Field33\Field2[$00] = $00) Then
                        For local1 = $00 To $06 Step $01
                            local45[local1] = copyentity(objtunnel(local1), $00)
                            debuglog((Str local1))
                            hideentity(local45[local1])
                        Next
                        freetexturecache()
                        local52 = $00
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local55 * $13) + local54)] > $00) Then
                                    Select local10\Field1\Field33\Field0[((local55 * $13) + local54)]
                                        Case $01,$07
                                            local52 = copyentity(local45[(local10\Field1\Field33\Field0[((local55 * $13) + local54)] - $01)], $00)
                                        Case $02
                                            If (((local10\Field1\Field33\Field0[((local54 + $01) + (local55 * $13))] > $00) And (local10\Field1\Field33\Field0[((local54 - $01) + (local55 * $13))] > $00)) <> 0) Then
                                                local52 = copyentity(local45[(local10\Field1\Field33\Field0[((local55 * $13) + local54)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            ElseIf (((local10\Field1\Field33\Field0[(((local55 + $01) * $13) + local54)] > $00) And (local10\Field1\Field33\Field0[(((local55 - $01) * $13) + local54)] > $00)) <> 0) Then
                                                local52 = copyentity(local45[(local10\Field1\Field33\Field0[((local55 * $13) + local54)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            Else
                                                local52 = copyentity(local45[local10\Field1\Field33\Field0[((local55 * $13) + local54)]], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            EndIf
                                        Case $03,$04
                                            local52 = copyentity(local45[local10\Field1\Field33\Field0[((local55 * $13) + local54)]], $00)
                                        Case $05,$06
                                            local52 = copyentity(local45[$05], $00)
                                    End Select
                                    scaleentity(local52, roomscale, roomscale, roomscale, $01)
                                    rotateentity(local52, 0.0, ((Float local10\Field1\Field33\Field1[((local55 * $13) + local54)]) * 90.0), 0.0, $00)
                                    positionentity(local52, (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                    Select local10\Field1\Field33\Field0[((local55 * $13) + local54)]
                                        Case $01,$05,$06
                                            addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $03,$04
                                            addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $07
                                            addlight(Null, (((local10\Field1\Field3 + ((Float local54) * 2.0)) - ((sin(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local52, $01)) * 16.0) * roomscale)), ((396.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((cos(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local52, $01)) * 16.0) * roomscale)), $02, (500.0 * roomscale), $FF, $C8, $C8)
                                    End Select
                                    If (((local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $06) Or (local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $05)) <> 0) Then
                                        local51 = createdoor(local10\Field1\Field0, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 240.0) * roomscale)), 8.0, ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 240.0) * roomscale)), (entityyaw(local52, $01) + 90.0), Null, $00, $03, $00, "", $00)
                                        addlight(Null, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 555.0) * roomscale)), ((469.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 555.0) * roomscale)), $02, (600.0 * roomscale), $FF, $FF, $FF)
                                        positionentity(local51\Field3[$00], (entityx(local51\Field3[$00], $01) + (cos(entityyaw(local52, $01)) * 0.05)), (entityy(local51\Field3[$00], $01) + 0.0), (entityz(local51\Field3[$00], $01) + (sin(entityyaw(local52, $01)) * 0.05)), $01)
                                        local53 = createpivot($00)
                                        rotateentity(local53, 0.0, (entityyaw(local52, $01) + 180.0), 0.0, $01)
                                        positionentity(local53, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 552.0) * roomscale)), ((240.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 552.0) * roomscale)), $00)
                                        If (local10\Field1\Field33\Field0[((local55 * $13) + local54)] = $06) Then
                                            If (local10\Field1\Field29[$01] = Null) Then
                                                local51\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                                local10\Field1\Field29[$01] = local51
                                                adddoortooptsystem(local10\Field1, local51)
                                            Else
                                                removedoor(local51)
                                            EndIf
                                            If (local10\Field1\Field25[$03] = $00) Then
                                                local10\Field1\Field25[$03] = local53
                                                positionentity(local10\Field1\Field25[$01], (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                            Else
                                                freeentity(local53)
                                            EndIf
                                        Else
                                            If (local10\Field1\Field29[$03] = Null) Then
                                                local51\Field5 = (local10\Field1\Field29[$02]\Field5 = $00)
                                                local10\Field1\Field29[$03] = local51
                                                adddoortooptsystem(local10\Field1, local51)
                                            Else
                                                removedoor(local51)
                                            EndIf
                                            If (local10\Field1\Field25[$05] = $00) Then
                                                local10\Field1\Field25[$05] = local53
                                                positionentity(local10\Field1\Field25[$00], (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                            Else
                                                freeentity(local53)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local10\Field1\Field33\Field3[((local55 * $13) + local54)] = local52
                                    local68 = createwaypoint((local10\Field1\Field3 + ((Float local54) * 2.0)), 8.2, (local10\Field1\Field5 + ((Float local55) * 2.0)), Null, local10\Field1)
                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)] = local68
                                    If (local55 < $12) Then
                                        If (local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field33\Field4[(((local55 + $01) * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local55 > $00) Then
                                        If (local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field33\Field4[(((local55 - $01) * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local54 > $00) Then
                                        If (local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field33\Field4[((local54 - $01) + (local55 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local54 < $12) Then
                                        If (local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]
                                                    local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field33\Field4[((local54 + $01) + (local55 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        For local1 = $00 To $06 Step $01
                            local10\Field1\Field33\Field2[local1] = local45[local1]
                        Next
                        seedrnd(local56)
                        For local12 = Each items
                            If (((8.0 <= entityy(local12\Field1, $01)) And (12.0 >= entityy(local12\Field1, $01))) <> 0) Then
                                debuglog((local12\Field0 + " is within Y limits"))
                                If ((((local10\Field1\Field3 - 6.0) <= entityx(local12\Field1, $01)) And (((local10\Field1\Field3 + 38.0) + 6.0) >= entityx(local12\Field1, $01))) <> 0) Then
                                    debuglog("and within X limits")
                                EndIf
                                If ((((local10\Field1\Field5 - 6.0) <= entityz(local12\Field1, $01)) And (((local10\Field1\Field5 + 38.0) + 6.0) >= entityz(local12\Field1, $01))) <> 0) Then
                                    debuglog("and within Z limits")
                                EndIf
                            EndIf
                            If (((((((8.0 <= entityy(local12\Field1, $01)) And (12.0 >= entityy(local12\Field1, $01))) And ((local10\Field1\Field3 - 6.0) <= entityx(local12\Field1, $01))) And (((local10\Field1\Field3 + 38.0) + 6.0) >= entityx(local12\Field1, $01))) And ((local10\Field1\Field5 - 6.0) <= entityz(local12\Field1, $01))) And (((local10\Field1\Field5 + 38.0) + 6.0) >= entityz(local12\Field1, $01))) <> 0) Then
                                debuglog(local12\Field0)
                                translateentity(local12\Field1, 0.0, 0.3, 0.0, $01)
                                resetentity(local12\Field1)
                            EndIf
                        Next
                    EndIf
                    For local55 = $00 To $12 Step $01
                        For local54 = $00 To $12 Step $01
                            If (local10\Field1\Field33\Field3[((local55 * $13) + local54)] <> $00) Then
                                showentity(local10\Field1\Field33\Field3[((local55 * $13) + local54)])
                            EndIf
                        Next
                    Next
                    If (4.0 < entityy(local10\Field13, $01)) Then
                        If (4.0 < entityy(collider, $01)) Then
                            shouldplay = $07
                        EndIf
                        If (0.0 = local10\Field2) Then
                            If (entitydistance(local10\Field13, local10\Field1\Field25[$01]) > entitydistance(local10\Field13, local10\Field1\Field25[$00])) Then
                                local2 = $00
                            Else
                                local2 = $01
                            EndIf
                            local10\Field2 = 2.0
                            If (contained106 = $00) Then
                                local32 = createdecal($00, entityx(local10\Field1\Field25[local2], $01), (entityy(local10\Field1\Field25[local2], $01) + 0.05), entityz(local10\Field1\Field25[local2], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                local32\Field2 = 0.05
                                local32\Field1 = 0.001
                                entityalpha(local32\Field0, 0.8)
                                updatedecals()
                                debuglog(("updateevents collider: " + (Str entityy(local10\Field13, $01))))
                                positionentity(curr106\Field4, entityx(local10\Field1\Field25[local2], $01), (entityy(local10\Field13, $01) - 3.0), entityz(local10\Field1\Field25[local2], $01), $00)
                                setanimtime(curr106\Field0, 110.0, $00)
                                curr106\Field9 = -0.1
                                curr106\Field29 = entityy(local10\Field13, $00)
                            EndIf
                            For local1 = $00 To $01 Step $01
                                local71 = Null
                                For local18 = ((Float local1) * 72.2) To 360.0 Step 1.0
                                    debuglog(("spawn 966 X: " + (Str local18)))
                                    If (((rand($02, $01) = $01) And (local10\Field1\Field33\Field4[(Int local18)] <> Null)) <> 0) Then
                                        local71 = local10\Field1\Field33\Field4[(Int local18)]
                                        local18 = 361.0
                                    EndIf
                                Next
                                If (local71 <> Null) Then
                                    createnpc($12, entityx(local71\Field0, $01), entityy(local71\Field0, $01), entityz(local71\Field0, $01))
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local10\Field1\Field29[$00]\Field28 = updateelevators(local10\Field1\Field29[$00]\Field28, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $00)
                    local10\Field1\Field29[$02]\Field28 = updateelevators(local10\Field1\Field29[$02]\Field28, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$04], local10\Field1\Field25[$05], $00)
                    showroomdoororiginal(local10\Field1\Field29[$00])
                    showroomdoororiginal(local10\Field1\Field29[$01])
                    showroomdoororiginal(local10\Field1\Field29[$02])
                    showroomdoororiginal(local10\Field1\Field29[$03])
                ElseIf (local10\Field1\Field33 <> Null) Then
                    If (local10\Field1\Field33\Field2[$00] <> $00) Then
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field3[((local55 * $13) + local54)] <> $00) Then
                                    hideentity(local10\Field1\Field33\Field3[((local55 * $13) + local54)])
                                EndIf
                            Next
                        Next
                    EndIf
                EndIf
            Case $30
                If (contained106 = $00) Then
                    If (0.0 = local10\Field2) Then
                        If (playerinroom(local10) <> 0) Then
                            local10\Field2 = 1.0
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 + (fpsfactor * 0.7))
                        If (50.0 > local10\Field2) Then
                            curr106\Field24 = 1.0
                            positionentity(curr106\Field4, entityx(local10\Field1\Field25[$00], $01), (entityy(local10\Field13, $00) - 0.15), entityz(local10\Field1\Field25[$00], $01), $00)
                            pointentity(curr106\Field4, local10\Field1\Field25[$01], 0.0)
                            moveentity(curr106\Field4, 0.0, 0.0, ((entitydistance(local10\Field1\Field25[$00], local10\Field1\Field25[$01]) * 0.5) * (local10\Field2 / 50.0)))
                            animatenpc(curr106, 284.0, 333.0, 0.7, $01)
                        ElseIf (200.0 > local10\Field2) Then
                            curr106\Field24 = 1.0
                            animatenpc(curr106, 334.0, 494.0, 0.2, $01)
                            positionentity(curr106\Field4, ((entityx(local10\Field1\Field25[$00], $01) + entityx(local10\Field1\Field25[$01], $01)) / 2.0), (entityy(local10\Field13, $00) - 0.15), ((entityz(local10\Field1\Field25[$00], $01) + entityz(local10\Field1\Field25[$01], $01)) / 2.0), $00)
                            rotateentity(curr106\Field4, 0.0, curvevalue(local10\Field2, entityyaw(curr106\Field4, $00), 30.0), 0.0, $01)
                            If (4.0 > entitydistance(curr106\Field4, local10\Field13)) Then
                                local3 = createpivot($00)
                                positionentity(local3, entityx(curr106\Field4, $00), entityy(curr106\Field4, $00), entityz(curr106\Field4, $00), $00)
                                pointentity(local3, local10\Field13, 0.0)
                                If (80.0 > wrapangle((entityyaw(local3, $00) - entityyaw(curr106\Field4, $00)))) Then
                                    curr106\Field9 = -11.0
                                    curr106\Field24 = 0.0
                                    playsound_strict(horrorsfx($0A))
                                    local10\Field2 = 260.0
                                EndIf
                                freeentity(local3)
                            EndIf
                        ElseIf (250.0 > local10\Field2) Then
                            curr106\Field24 = 1.0
                            positionentity(curr106\Field4, entityx(local10\Field1\Field25[$00], $01), (entityy(local10\Field13, $00) - 0.15), entityz(local10\Field1\Field25[$00], $01), $00)
                            pointentity(curr106\Field4, local10\Field1\Field25[$01], 0.0)
                            moveentity(curr106\Field4, 0.0, 0.0, (entitydistance(local10\Field1\Field25[$00], local10\Field1\Field25[$01]) * ((local10\Field2 - 150.0) / 100.0)))
                            animatenpc(curr106, 284.0, 333.0, 0.7, $01)
                        EndIf
                        resetentity(curr106\Field4)
                        positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                        rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                        If (((0.3 < (local10\Field2 / 250.0)) And (0.3 >= ((local10\Field2 - (fpsfactor * 0.7)) / 250.0))) <> 0) Then
                            local10\Field5 = playsound_strict(horrorsfx($06))
                            blurtimer = 800.0
                            local72 = createdecal($00, entityx(local10\Field1\Field25[$02], $01), entityy(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01), 0.0, (Float (local10\Field1\Field6 - $5A)), rnd(360.0, 0.0), 1.0, 1.0)
                            local72\Field9 = 90000.0
                            local72\Field5 = 0.01
                            local72\Field4 = 0.005
                            local72\Field2 = 0.1
                            local72\Field1 = 0.003
                        EndIf
                        If (((0.65 < (local10\Field2 / 250.0)) And (0.65 >= ((local10\Field2 - (fpsfactor * 0.7)) / 250.0))) <> 0) Then
                            local72 = createdecal($00, entityx(local10\Field1\Field25[$03], $01), entityy(local10\Field1\Field25[$03], $01), entityz(local10\Field1\Field25[$03], $01), 0.0, (Float (local10\Field1\Field6 + $5A)), rnd(360.0, 0.0), 1.0, 1.0)
                            local72\Field9 = 90000.0
                            local72\Field5 = 0.01
                            local72\Field4 = 0.005
                            local72\Field2 = 0.1
                            local72\Field1 = 0.003
                        EndIf
                        If (250.0 < local10\Field2) Then
                            curr106\Field24 = 0.0
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $48
                If (((contained106 = $00) And (0.0 < curr106\Field9)) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (playerinroom(local10) <> 0) Then
                            local10\Field2 = 1.0
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 + 1.0)
                        positionentity(curr106\Field4, entityx(local10\Field1\Field25[$07], $01), entityy(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field25[$07], $01), $00)
                        resetentity(curr106\Field4)
                        pointentity(curr106\Field4, camera, 0.0)
                        turnentity(curr106\Field4, 0.0, (sin((Float (millisecs2() / $14))) * 6.0), 0.0, $01)
                        moveentity(curr106\Field4, 0.0, 0.0, (sin((Float (millisecs2() / $0F))) * 0.06))
                        positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                        rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                        curr106\Field24 = 1.0
                        animatenpc(curr106, 334.0, 494.0, 0.3, $01)
                        If (800.0 < local10\Field2) Then
                            If (-5.0 > blinktimer) Then
                                curr106\Field24 = 0.0
                                removeevent(local10)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $31
                If (0.0 = curr173\Field24) Then
                    If (((8.0 > local10\Field20) And (0.0 < local10\Field20)) <> 0) Then
                        If (((entityvisible(curr173\Field4, camera) = $00) And (entityvisible(local10\Field1\Field25[$06], camera) = $00)) <> 0) Then
                            positionentity(curr173\Field4, entityx(local10\Field1\Field25[$06], $01), 0.5, entityz(local10\Field1\Field25[$06], $01), $00)
                            resetentity(curr173\Field4)
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $15
                If (playerinroom(local10) <> 0) Then
                    If (local10\Field1\Field25[$02] = $00) Then
                        local10\Field1\Field25[$02] = loadmesh_strict("GFX\npcs\duck_low_res.b3d", $00)
                        scaleentity(local10\Field1\Field25[$02], 0.07, 0.07, 0.07, $00)
                        local73 = loadtexture_strict("GFX\npcs\duck1.png", $01)
                        entitytexture(local10\Field1\Field25[$02], local73, $00, $00)
                        freetexture(local73)
                        positionentity(local10\Field1\Field25[$02], entityx(local10\Field1\Field25[$00], $01), entityy(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01), $00)
                        pointentity(local10\Field1\Field25[$02], local10\Field1\Field2, 0.0)
                        rotateentity(local10\Field1\Field25[$02], 0.0, entityyaw(local10\Field1\Field25[$02], $01), 0.0, $01)
                        loadeventsound(local10, "SFX\SCP\Joke\Saxophone.ogg", $00)
                    ElseIf (entityinview(local10\Field1\Field25[$02], getplayercamera(local10\Field14)) = $00) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        If (((rand($C8, $01) = $01) And (300.0 < local10\Field2)) <> 0) Then
                            local10\Field2 = 0.0
                            local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field25[$02], 6.0, 1.0)
                        EndIf
                    ElseIf (local10\Field5 <> $00) Then
                        If (channelplaying(local10\Field5) <> 0) Then
                            stopchannel(local10\Field5)
                        EndIf
                    EndIf
                EndIf
            Case $16
                If (playerinroom(local10) <> 0) Then
                    If (local10\Field1\Field25[$02] = $00) Then
                        local10\Field1\Field25[$02] = loadanimmesh_strict("GFX\npcs\scp-1048pp.b3d", $00)
                        scaleentity(local10\Field1\Field25[$02], 0.05, 0.05, 0.05, $00)
                        setanimtime(local10\Field1\Field25[$02], 414.0, $00)
                        local74 = (("GFX\items\1048\1048_" + (Str rand($01, $14))) + ".jpg")
                        For local75 = Each itemtemplates
                            If (local75\Field1 = "Drawing") Then
                                If (local75\Field12 <> $00) Then
                                    freeimage(local75\Field12)
                                EndIf
                                local75\Field12 = loadimage_strict(local74)
                                maskimage(local75\Field12, $FF, $00, $FF)
                                local75\Field11 = local74
                                Exit
                            EndIf
                        Next
                        local73 = loadtexture_strict(local74, $01)
                        local76 = loadbrush_strict(local74, $01, 1.0, 1.0)
                        For local1 = $01 To countsurfaces(local10\Field1\Field25[$02]) Step $01
                            local77 = getsurface(local10\Field1\Field25[$02], local1)
                            local78 = getsurfacebrush(local77)
                            local79 = getbrushtexture(local78, $00)
                            local80 = strippath(texturename(local79))
                            debuglog(("texname: " + local80))
                            If (lower(local80) = "1048_1.jpg") Then
                                paintsurface(local77, local76)
                            EndIf
                            freebrush(local78)
                        Next
                        freetexture(local73)
                        freebrush(local76)
                        positionentity(local10\Field1\Field25[$02], entityx(local10\Field1\Field25[$00], $01), entityy(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01), $00)
                    Else
                        pointentity(local10\Field1\Field25[$02], local10\Field13, 0.0)
                        rotateentity(local10\Field1\Field25[$02], -90.0, entityyaw(local10\Field1\Field25[$02], $01), 0.0, $01)
                        If (0.0 = local10\Field2) Then
                            If (3.0 > entitydistance(local10\Field13, local10\Field1\Field25[$02])) Then
                                If (entityinview(local10\Field1\Field25[$02], camera) <> 0) Then
                                    local10\Field2 = 1.0
                                    giveachievement($19, $01)
                                EndIf
                            EndIf
                        ElseIf (1.0 = local10\Field2) Then
                            animate2(local10\Field1\Field25[$02], animtime(local10\Field1\Field25[$02]), $01, $CD, 0.5, $00)
                            If (205.0 = animtime(local10\Field1\Field25[$02])) Then
                                local10\Field2 = 2.0
                            EndIf
                        ElseIf (2.0 = local10\Field2) Then
                            animate2(local10\Field1\Field25[$02], animtime(local10\Field1\Field25[$02]), $CD, $161, 1.0, $01)
                            If (1.5 > entitydistance(collider, local10\Field1\Field25[$02])) Then
                                drawhandicon = $01
                                If (mousehit1 <> 0) Then
                                    If (itemamount >= $0A) Then
                                        msg = "You cannot carry any more items."
                                        msgtimer = 350.0
                                    Else
                                        selecteditem = createitem("Drawing", "paper", 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00, $01)
                                        entitytype(selecteditem\Field1, $03, $00)
                                        pickitem(selecteditem)
                                        freeentity(local10\Field1\Field25[$02])
                                        local10\Field1\Field25[$02] = $00
                                        local10\Field2 = 3.0
                                        removeevent(local10)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $0A
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (local10\Field1\Field29[$00]\Field5 = $01) Then
                            If (180.0 = local10\Field1\Field29[$00]\Field7) Then
                                local10\Field2 = 1.0
                                playsound_strict(horrorsfx($05))
                            EndIf
                        ElseIf (((1.5 > entitydistance(local10\Field13, local10\Field1\Field29[$00]\Field0)) And remotedooron) <> 0) Then
                            local10\Field1\Field29[$00]\Field5 = $01
                        EndIf
                    ElseIf (2.0 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                        heartbeatvolume = curvevalue(0.5, heartbeatvolume, 5.0)
                        heartbeatrate = curvevalue(120.0, heartbeatrate, 150.0)
                        local10\Field5 = loopsound2(oldmansfx($04), local10\Field5, camera, local10\Field1\Field2, 5.0, 0.3)
                        curr106\Field9 = (curr106\Field9 - (fpsfactor * 3.0))
                    EndIf
                EndIf
            Case $18
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    If (curr096 = Null) Then
                        curr096 = createnpc($09, entityx(local10\Field1\Field25[$06], $01), (entityy(local10\Field1\Field25[$06], $01) + 0.1), entityz(local10\Field1\Field25[$06], $01))
                    EndIf
                ElseIf (3150.0 > local10\Field2) Then
                    If (playerroom = local10\Field1) Then
                        lightblink = rnd(1.0, 2.0)
                        If (rand($05, $01) = $01) Then
                            playsound2(introsfx(rand($0A, $0C)), camera, local10\Field1\Field2, 8.0, rnd(0.1, 0.3))
                        EndIf
                    EndIf
                    local10\Field2 = min((local10\Field2 + fpsfactor), 3010.0)
                    If (local10\Field1\Field32[$00] <> Null) Then
                        curr096\Field31 = local10\Field1\Field32[$00]
                        If (560.0 > local10\Field2) Then
                            animatenpc(curr096, 472.0, 520.0, 0.25, $01)
                            pointentity(local10\Field1\Field32[$00]\Field4, curr096\Field4, 0.0)
                        ElseIf (((560.0 <= local10\Field2) And (700.0 > local10\Field2)) <> 0) Then
                            If (entitydistance(local10\Field13, local10\Field1\Field29[$01]\Field2) > entitydistance(local10\Field13, local10\Field1\Field29[$00]\Field2)) Then
                                animatenpc(curr096, 521.0, 555.0, 0.25, $00)
                                If (554.5 <= curr096\Field14) Then
                                    local10\Field2 = 700.0
                                    curr096\Field14 = 677.0
                                    setnpcframe(curr096, curr096\Field14)
                                    curr096\Field9 = 1.0
                                    turnentity(curr096\Field4, 0.0, 180.0, 0.0, $00)
                                    moveentity(curr096\Field4, 0.0, 0.0, 0.3)
                                EndIf
                            Else
                                animatenpc(curr096, 556.0, 590.0, 0.25, $00)
                                If (589.5 <= curr096\Field14) Then
                                    local10\Field2 = 700.0
                                    curr096\Field14 = 677.0
                                    setnpcframe(curr096, curr096\Field14)
                                    curr096\Field9 = 1.0
                                    turnentity(curr096\Field4, 0.0, 180.0, 0.0, $00)
                                    moveentity(curr096\Field4, 0.0, 0.0, 0.3)
                                EndIf
                            EndIf
                            pointentity(local10\Field1\Field32[$00]\Field4, curr096\Field4, 0.0)
                        ElseIf (((700.0 <= local10\Field2) And (1400.0 > local10\Field2)) <> 0) Then
                            curr096\Field9 = min(max(1.0, curr096\Field9), 3.0)
                            curr096\Field10 = max(curr096\Field10, 840.0)
                            If (1050.0 >= (local10\Field2 - fpsfactor)) Then
                                If (1050.0 < local10\Field2) Then
                                    local10\Field1\Field32[$00]\Field9 = 14.0
                                    local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], entityx(curr096\Field4, $01), 0.4, entityz(curr096\Field4, $01))
                                    local10\Field1\Field32[$00]\Field38 = 300.0
                                Else
                                    pointentity(local10\Field1\Field32[$00]\Field4, curr096\Field4, 0.0)
                                EndIf
                            EndIf
                            If (entityvisible(local10\Field1\Field32[$00]\Field4, curr096\Field4) <> 0) Then
                                local10\Field1\Field29[$02]\Field5 = $00
                                local10\Field1\Field32[$00]\Field9 = 13.0
                                pointentity(local10\Field1\Field32[$00]\Field0, curr096\Field4, 0.0)
                                rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$00]\Field0, $00), entityyaw(local10\Field1\Field32[$00]\Field4, $00), 30.0), 0.0, $00)
                            EndIf
                        ElseIf (4.0 = curr096\Field9) Then
                            curr096\Field26 = $01
                            local10\Field1\Field32[$00]\Field9 = 2.0
                            pointentity(local10\Field1\Field32[$00]\Field0, curr096\Field4, 0.0)
                            rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$00]\Field0, $00), entityyaw(local10\Field1\Field32[$00]\Field4, $00), 30.0), 0.0, $00)
                            If (playerroom = local10\Field1) Then
                                lightblink = (local10\Field1\Field32[$00]\Field25 + rnd(0.5, 2.0))
                            EndIf
                            curr096\Field31 = local10\Field1\Field32[$00]
                        Else
                            If (1540.0 < local10\Field2) Then
                                curr096\Field9 = 4.0
                            EndIf
                            If (13.0 = local10\Field1\Field32[$00]\Field9) Then
                                local10\Field1\Field32[$00]\Field9 = 14.0
                                local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], entityx(local10\Field1\Field2, $01), 0.4, entityz(local10\Field1\Field2, $01))
                                local10\Field1\Field32[$00]\Field38 = 300.0
                                local10\Field1\Field32[$00]\Field21 = (local10\Field1\Field32[$00]\Field21 * 1.8)
                            EndIf
                        EndIf
                        If (((25.0 < animtime(curr096\Field0)) And (150.0 > animtime(curr096\Field0))) <> 0) Then
                            freesound_strict(local10\Field7)
                            local10\Field7 = $00
                            local10\Field7 = loadsound_strict("SFX\Character\Guard\096ServerRoom2.ogg")
                            local10\Field5 = playsound_strict(local10\Field7)
                            channelvolume(local10\Field5, ((Float (playerroom = local10\Field1)) * sfxvolume))
                            curr096\Field22 = 0.0
                            For local1 = $00 To $06 Step $01
                                If (((local10\Field1\Field6 = $00) Or (local10\Field1\Field6 = $B4)) <> 0) Then
                                    local32 = createdecal(rand($02, $03), (local10\Field1\Field3 - ((rnd(197.0, 199.0) * cos((Float local10\Field1\Field6))) * roomscale)), 1.0, (local10\Field1\Field5 + ((140.0 * (Float (local1 - $03))) * roomscale)), 0.0, (Float (local10\Field1\Field6 + $5A)), rnd(360.0, 0.0), 1.0, 1.0)
                                    local32\Field2 = rnd(0.8, 0.85)
                                    local32\Field1 = 0.001
                                    local32 = createdecal(rand($02, $03), (local10\Field1\Field3 - ((rnd(197.0, 199.0) * cos((Float local10\Field1\Field6))) * roomscale)), 1.0, (local10\Field1\Field5 + ((140.0 * (Float (local1 - $03))) * roomscale)), 0.0, (Float (local10\Field1\Field6 - $5A)), rnd(360.0, 0.0), 1.0, 1.0)
                                    local32\Field2 = rnd(0.8, 0.85)
                                    local32\Field1 = 0.001
                                Else
                                    local32 = createdecal(rand($02, $03), (local10\Field1\Field3 + ((140.0 * (Float (local1 - $03))) * roomscale)), 1.0, ((local10\Field1\Field5 - ((rnd(197.0, 199.0) * sin((Float local10\Field1\Field6))) * roomscale)) - rnd(0.001, 0.003)), 0.0, (Float (local10\Field1\Field6 + $5A)), rnd(360.0, 0.0), 1.0, 1.0)
                                    local32\Field2 = rnd(0.8, 0.85)
                                    local32\Field1 = 0.001
                                    local32 = createdecal(rand($02, $03), (local10\Field1\Field3 + ((140.0 * (Float (local1 - $03))) * roomscale)), 1.0, ((local10\Field1\Field5 - ((rnd(197.0, 199.0) * sin((Float local10\Field1\Field6))) * roomscale)) - rnd(0.001, 0.003)), 0.0, (Float (local10\Field1\Field6 - $5A)), rnd(360.0, 0.0), 1.0, 1.0)
                                    local32\Field2 = rnd(0.8, 0.85)
                                    local32\Field1 = 0.001
                                EndIf
                                local32 = createdecal(rand($02, $03), (entityx(local10\Field1\Field32[$00]\Field4, $00) + rnd(-2.0, 2.0)), rnd(0.001, 0.003), (entityz(local10\Field1\Field32[$00]\Field4, $00) + rnd(-2.0, 2.0)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                            Next
                            local32\Field2 = rnd(0.5, 0.7)
                            scalesprite(local32\Field0, local32\Field2, local32\Field2)
                            curr096\Field9 = 5.0
                            stopstream_strict(curr096\Field17)
                            curr096\Field17 = $00
                            removenpc(local10\Field1\Field32[$00], $00)
                            local10\Field1\Field32[$00] = Null
                        EndIf
                    Else
                        If (((2800.0 <= local10\Field2) And (2800.0 > (local10\Field2 - fpsfactor))) <> 0) Then
                            local10\Field1\Field29[$00]\Field4 = $00
                            local10\Field1\Field29[$01]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $00, $01, $00, "", $00)
                            usedoor(local10\Field1\Field29[$01], $00, $01, $00, "", $00)
                            freesound_strict(local10\Field7)
                            local10\Field7 = $00
                            local10\Field1\Field29[$00]\Field4 = $01
                            local10\Field1\Field29[$01]\Field4 = $01
                        EndIf
                        If (playerinroom(local10) <> 0) Then
                            If (local10\Field5 <> $00) Then
                                If (channelplaying(local10\Field5) <> 0) Then
                                    If (playerroom = local10\Field1) Then
                                        lightblink = rnd(0.5, 6.0)
                                    EndIf
                                    If (rand($32, $01) = $01) Then
                                        playsound2(introsfx(rand($0A, $0C)), camera, local10\Field1\Field2, 8.0, rnd(0.1, 0.3))
                                    EndIf
                                EndIf
                            EndIf
                            If (((local10\Field1\Field6 = $00) Or (local10\Field1\Field6 = $B4)) <> 0) Then
                                If (1.3 < (Abs (entityx(local10\Field13, $00) - entityx(local10\Field1\Field2, $01)))) Then
                                    local10\Field2 = 3500.0
                                    local10\Field7 = $00
                                EndIf
                            ElseIf (1.3 < (Abs (entityz(local10\Field13, $00) - entityz(local10\Field1\Field2, $01)))) Then
                                local10\Field2 = 3500.0
                                local10\Field7 = $00
                            EndIf
                        EndIf
                    EndIf
                ElseIf (playerinroom(local10) <> 0) Then
                    local2 = updatelever(local10\Field1\Field25[$01], $00)
                    local18 = (Float updatelever(local10\Field1\Field25[$03], $00))
                    local20 = (Float updatelever(local10\Field1\Field25[$05], $00))
                    If ((Int local18) <> 0) Then
                        local10\Field3 = min(1.0, (local10\Field3 + (fpsfactor / 350.0)))
                        If ((Int local20) <> 0) Then
                            If (local10\Field8 = $00) Then
                                loadeventsound(local10, "SFX\General\GeneratorOn.ogg", $01)
                            EndIf
                            local10\Field4 = min(1.0, (local10\Field4 + (fpsfactor / 450.0)))
                        Else
                            local10\Field4 = min(0.0, (local10\Field4 - (fpsfactor / 450.0)))
                        EndIf
                    Else
                        local10\Field3 = max(0.0, (local10\Field3 - (fpsfactor / 350.0)))
                        local10\Field4 = max(0.0, (local10\Field4 - (fpsfactor / 450.0)))
                    EndIf
                    If (0.0 < local10\Field3) Then
                        local10\Field5 = loopsound2(roomambience[$08], local10\Field5, camera, local10\Field1\Field25[$03], 5.0, (local10\Field3 * 0.8))
                    EndIf
                    If (0.0 < local10\Field4) Then
                        local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local10\Field1\Field25[$05], 6.0, local10\Field4)
                    EndIf
                    If ((((local2 = $00) And (Int local18)) And (Int local20)) <> 0) Then
                        local10\Field1\Field29[$00]\Field4 = $00
                        local10\Field1\Field29[$01]\Field4 = $00
                    Else
                        If (rand($C8, $01) < $05) Then
                            lightblink = rnd(0.5, 1.0)
                        EndIf
                        If (local10\Field1\Field29[$00]\Field5 <> 0) Then
                            local10\Field1\Field29[$00]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $00, $01, $00, "", $00)
                        EndIf
                        If (local10\Field1\Field29[$01]\Field5 <> 0) Then
                            local10\Field1\Field29[$01]\Field4 = $00
                            usedoor(local10\Field1\Field29[$01], $00, $01, $00, "", $00)
                        EndIf
                        local10\Field1\Field29[$00]\Field4 = $01
                        local10\Field1\Field29[$01]\Field4 = $01
                    EndIf
                EndIf
                channelvolume(local10\Field5, ((Float (playerroom = local10\Field1)) * sfxvolume))
            Case $07
                If (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    local10\Field20 = calculatedist(local10\Field13, local10\Field1)
                    If (0.0 >= local10\Field3) Then
                        local10\Field1\Field29[$01]\Field4 = $00
                        local10\Field1\Field29[$04]\Field4 = $00
                        If (((8.0 > entitydistance(local10\Field13, curr173\Field0)) Or (8.0 > entitydistance(local10\Field13, curr106\Field0))) <> 0) Then
                            local10\Field1\Field29[$01]\Field4 = $01
                            local10\Field1\Field29[$04]\Field4 = $01
                        Else
                            For local8 = Each npcs
                                If (local8\Field5 = $08) Then
                                    If (8.0 > entitydistance(local10\Field13, curr173\Field0)) Then
                                        local10\Field1\Field29[$01]\Field4 = $01
                                        local10\Field1\Field29[$04]\Field4 = $01
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                        local10\Field3 = 350.0
                    Else
                        local10\Field3 = (local10\Field3 - fpsfactor)
                    EndIf
                    lightvolume = (templightvolume * 0.5)
                    tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field2)
                    local2 = $00
                    If (730.0 < tformedx()) Then
                        giveachievement($17, $01)
                        updateworld(1.0)
                        tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field2)
                        For local1 = $01 To $02 Step $01
                            local10\Field1\Field29[local1]\Field5 = local10\Field1\Field29[(local1 + $02)]\Field5
                            local10\Field1\Field29[local1]\Field7 = local10\Field1\Field29[(local1 + $02)]\Field7
                            positionentity(local10\Field1\Field29[local1]\Field0, entityx(local10\Field1\Field29[(local1 + $02)]\Field0, $00), entityy(local10\Field1\Field29[(local1 + $02)]\Field0, $00), entityz(local10\Field1\Field29[(local1 + $02)]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[local1]\Field1, entityx(local10\Field1\Field29[(local1 + $02)]\Field1, $00), entityy(local10\Field1\Field29[(local1 + $02)]\Field1, $00), entityz(local10\Field1\Field29[(local1 + $02)]\Field1, $00), $00)
                            local10\Field1\Field29[(local1 + $02)]\Field5 = $00
                            local10\Field1\Field29[(local1 + $02)]\Field7 = 0.0
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field0, entityx(local10\Field1\Field29[$00]\Field0, $00), entityy(local10\Field1\Field29[$00]\Field0, $00), entityz(local10\Field1\Field29[$00]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field1, entityx(local10\Field1\Field29[$00]\Field1, $00), entityy(local10\Field1\Field29[$00]\Field1, $00), entityz(local10\Field1\Field29[$00]\Field1, $00), $00)
                        Next
                        tformpoint((tformedx() - 1024.0), tformedy(), tformedz(), local10\Field1\Field2, $00)
                        hideentity(local10\Field13)
                        positionentity(local10\Field13, tformedx(), entityy(local10\Field13, $00), tformedz(), $01)
                        showentity(local10\Field13)
                        debuglog("tformedx()>720")
                        local2 = $01
                    ElseIf (-730.0 > tformedx()) Then
                        giveachievement($17, $01)
                        updateworld(1.0)
                        tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field2)
                        For local1 = $01 To $02 Step $01
                            local10\Field1\Field29[(local1 + $02)]\Field5 = local10\Field1\Field29[local1]\Field5
                            local10\Field1\Field29[(local1 + $02)]\Field7 = local10\Field1\Field29[local1]\Field7
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field0, entityx(local10\Field1\Field29[local1]\Field0, $00), entityy(local10\Field1\Field29[local1]\Field0, $00), entityz(local10\Field1\Field29[local1]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field1, entityx(local10\Field1\Field29[local1]\Field1, $00), entityy(local10\Field1\Field29[local1]\Field1, $00), entityz(local10\Field1\Field29[local1]\Field1, $00), $00)
                            local10\Field1\Field29[local1]\Field5 = $00
                            local10\Field1\Field29[local1]\Field7 = 0.0
                            positionentity(local10\Field1\Field29[local1]\Field0, entityx(local10\Field1\Field29[$00]\Field0, $00), entityy(local10\Field1\Field29[$00]\Field0, $00), entityz(local10\Field1\Field29[$00]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[local1]\Field1, entityx(local10\Field1\Field29[$00]\Field1, $00), entityy(local10\Field1\Field29[$00]\Field1, $00), entityz(local10\Field1\Field29[$00]\Field1, $00), $00)
                        Next
                        tformpoint((tformedx() + 1024.0), tformedy(), tformedz(), local10\Field1\Field2, $00)
                        hideentity(local10\Field13)
                        positionentity(local10\Field13, tformedx(), entityy(local10\Field13, $00), tformedz(), $01)
                        showentity(local10\Field13)
                        debuglog("tformedx()<720")
                        local2 = $01
                    EndIf
                    If (local2 = $01) Then
                        local10\Field2 = (local10\Field2 + 1.0)
                        For local12 = Each items
                            If (5.0 > entitydistance(local12\Field1, local10\Field13)) Then
                                tformpoint(entityx(local12\Field1, $00), entityy(local12\Field1, $00), entityz(local12\Field1, $00), $00, local10\Field1\Field2)
                                local18 = tformedx()
                                local19 = tformedy()
                                local20 = tformedz()
                                If (264.0 < tformedx()) Then
                                    tformpoint((local18 - 1024.0), local19, local20, local10\Field1\Field2, $00)
                                    positionentity(local12\Field1, tformedx(), tformedy(), tformedz(), $00)
                                    resetentity(local12\Field1)
                                ElseIf (-264.0 > tformedx()) Then
                                    tformpoint((local18 + 1024.0), local19, local20, local10\Field1\Field2, $00)
                                    positionentity(local12\Field1, tformedx(), tformedy(), tformedz(), $00)
                                    resetentity(local12\Field1)
                                EndIf
                            EndIf
                        Next
                        If (rand($0A, $01) = $01) Then
                            local2 = rand($00, $02)
                            playsound_strict(ambientsfx(local2, rand($00, (ambientsfxamount(local2) - $01))))
                        EndIf
                    Else
                        If (local10\Field1\Field32[$00] <> Null) Then
                            If (3.0 > entitydistance(local10\Field13, local10\Field1\Field32[$00]\Field4)) Then
                                If (entityinview(local10\Field1\Field32[$00]\Field0, camera) <> 0) Then
                                    currcamerazoom = ((sin(((Float millisecs2()) / 20.0)) + 1.0) * 15.0)
                                    heartbeatvolume = max(curvevalue(0.3, heartbeatvolume, 2.0), heartbeatvolume)
                                    heartbeatrate = max(heartbeatrate, 120.0)
                                EndIf
                            EndIf
                        EndIf
                        If (local10\Field1\Field32[$01] <> Null) Then
                            pointentity(local10\Field1\Field32[$01]\Field0, local10\Field13, 0.0)
                            rotateentity(local10\Field1\Field32[$01]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$01]\Field0, $00), entityyaw(local10\Field1\Field32[$01]\Field4, $00), 35.0), 0.0, $00)
                        EndIf
                    EndIf
                EndIf
            Case $23
                If (playerinroom(local10) <> 0) Then
                    If (2.5 > entitydistance(local10\Field1\Field2, local10\Field13)) Then
                        For local29 = Each doors
                            If (2.0 > (Abs (entityx(local29\Field0, $01) - entityx(local10\Field13, $00)))) Then
                                If (2.0 > (Abs (entityz(local29\Field0, $01) - entityz(local10\Field13, $00)))) Then
                                    If (entityinview(local29\Field0, getplayercamera(local10\Field14)) = $00) Then
                                        If (local29\Field5 <> 0) Then
                                            debuglog("%@@= \ {2E6C2=FD gi`h]c")
                                            local29\Field5 = $00
                                            local29\Field7 = 0.0
                                            blurtimer = 100.0
                                            camerashake = 3.0
                                        EndIf
                                    EndIf
                                    Exit
                                EndIf
                            EndIf
                        Next
                        removeevent(local10)
                    EndIf
                EndIf
            Case $19
                If (playerinroom(local10) <> 0) Then
                    If (((0.0 = local10\Field4) And (0.0 = curr173\Field24)) <> 0) Then
                        If (-10.0 > blinktimer) Then
                            local2 = rand($00, $02)
                            positionentity(curr173\Field4, entityx(local10\Field1\Field25[local2], $01), entityy(local10\Field1\Field25[local2], $01), entityz(local10\Field1\Field25[local2], $01), $00)
                            resetentity(curr173\Field4)
                            local10\Field4 = 1.0
                        EndIf
                    EndIf
                    If (local10\Field1\Field25[$03] > $00) Then
                        If (((-8.0 > blinktimer) And (-12.0 < blinktimer)) <> 0) Then
                            pointentity(local10\Field1\Field25[$03], camera, 0.0)
                            rotateentity(local10\Field1\Field25[$03], 0.0, entityyaw(local10\Field1\Field25[$03], $01), 0.0, $01)
                        EndIf
                        If (0.0 = local10\Field3) Then
                            local10\Field2 = curvevalue(0.0, local10\Field2, 15.0)
                            If (rand($320, $01) = $01) Then
                                local10\Field3 = 1.0
                            EndIf
                        Else
                            local10\Field2 = (local10\Field2 + (fpsfactor * 0.5))
                            If (360.0 < local10\Field2) Then
                                local10\Field2 = 0.0
                            EndIf
                            If (rand($4B0, $01) = $01) Then
                                local10\Field3 = 0.0
                            EndIf
                        EndIf
                        positionentity(local10\Field1\Field25[$03], entityx(local10\Field1\Field25[$03], $01), (((-608.0 * roomscale) + 0.05) + (sin((local10\Field2 + 270.0)) * 0.05)), entityz(local10\Field1\Field25[$03], $01), $01)
                    EndIf
                EndIf
            Case $0E
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    local10\Field1\Field29[$00]\Field28 = updateelevators(local10\Field1\Field29[$00]\Field28, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
                    local10\Field1\Field29[$02]\Field28 = updateelevators(local10\Field1\Field29[$02]\Field28, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $01)
                    If ((-4600.0 * roomscale) > entityy(local10\Field13, $00)) Then
                        giveachievement($15, $01)
                        If (local10\Field1\Field32[$00] = Null) Then
                            local10\Field1\Field32[$00] = createnpc($0F, 0.0, 0.0, 0.0)
                            local10\Field1\Field32[$01] = createnpc($0F, 0.0, 0.0, 0.0)
                            local10\Field1\Field32[$02] = createnpc($0F, 0.0, 0.0, 0.0)
                        Else
                            If (0.0 = local10\Field2) Then
                                positionentity(local10\Field1\Field32[$00]\Field4, entityx(local10\Field1\Field25[$04], $01), (entityy(local10\Field1\Field25[$04], $01) + 0.2), entityz(local10\Field1\Field25[$04], $01), $00)
                                resetentity(local10\Field1\Field32[$00]\Field4)
                                local10\Field1\Field32[$00]\Field9 = 2.0
                                local10\Field1\Field32[$00]\Field10 = 5.0
                                local10\Field1\Field32[$00]\Field12 = $07
                                positionentity(local10\Field1\Field32[$01]\Field4, entityx(local10\Field1\Field25[$09], $01), (entityy(local10\Field1\Field25[$09], $01) + 0.2), entityz(local10\Field1\Field25[$09], $01), $00)
                                resetentity(local10\Field1\Field32[$01]\Field4)
                                local10\Field1\Field32[$01]\Field9 = 2.0
                                local10\Field1\Field32[$01]\Field10 = 10.0
                                local10\Field1\Field32[$01]\Field12 = $0C
                                positionentity(local10\Field1\Field32[$02]\Field4, entityx(local10\Field1\Field25[$0D], $01), (entityy(local10\Field1\Field25[$0D], $01) + 0.2), entityz(local10\Field1\Field25[$0D], $01), $00)
                                resetentity(local10\Field1\Field32[$02]\Field4)
                                local10\Field1\Field32[$02]\Field9 = 2.0
                                local10\Field1\Field32[$02]\Field10 = 14.0
                                local10\Field1\Field32[$02]\Field12 = $10
                                local10\Field2 = 1.0
                            EndIf
                            If (channelplaying(local10\Field6) <> 0) Then
                                updatesoundorigin(local10\Field6, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                            EndIf
                            playerfallingpickdistance = 0.0
                            If (playerroom = local10\Field1) Then
                                If (godmode = $00) Then
                                    If ((((((-6400.0 * roomscale) > entityy(collider, $00)) And (0.0 <= killtimer)) And (0.0 <= falltimer)) And (player_isdead() = $00)) <> 0) Then
                                        deathmsg = ""
                                        playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"))
                                        multiplayer_writetempsound("SFX\Room\PocketDimension\Impact.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                        kill("was killed", $00)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                ElseIf (1.0 = local10\Field2) Then
                    If (local10\Field1\Field32[$00] <> Null) Then
                        local10\Field1\Field32[$00]\Field9 = 66.0
                    EndIf
                    If (local10\Field1\Field32[$01] <> Null) Then
                        local10\Field1\Field32[$01]\Field9 = 66.0
                    EndIf
                    If (local10\Field1\Field32[$02] <> Null) Then
                        local10\Field1\Field32[$02]\Field9 = 66.0
                    EndIf
                    local10\Field2 = 0.0
                EndIf
                If (local10\Field1\Field29[$04]\Field5 = $00) Then
                    If (updatelever(local10\Field1\Field28[$00], $00) <> 0) Then
                        local10\Field1\Field29[$04]\Field5 = $01
                        If (((playerroom = local10\Field1) And ((-4600.0 * roomscale) > entityy(collider, $00))) <> 0) Then
                            If (local10\Field8 <> $00) Then
                                freesound_strict(local10\Field8)
                                local10\Field8 = $00
                            EndIf
                            local10\Field8 = loadsound_strict("SFX\Door\Door2Open1_dist.ogg")
                            local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                        EndIf
                    EndIf
                    If (updatelever(local10\Field1\Field28[$01], $00) <> 0) Then
                        local10\Field1\Field29[$04]\Field5 = $01
                        If (((playerroom = local10\Field1) And ((-4600.0 * roomscale) > entityy(collider, $00))) <> 0) Then
                            If (local10\Field8 <> $00) Then
                                freesound_strict(local10\Field8)
                                local10\Field8 = $00
                            EndIf
                            local10\Field8 = loadsound_strict("SFX\Door\Door2Open1_dist.ogg")
                            local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                        EndIf
                    EndIf
                EndIf
                updatelever(local10\Field1\Field28[$00], local10\Field1\Field29[$04]\Field5)
                updatelever(local10\Field1\Field28[$01], local10\Field1\Field29[$04]\Field5)
            Case $1A
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    local10\Field1\Field32[$00] = createnpc($03, entityx(local10\Field1\Field25[$00], $01), (entityy(local10\Field1\Field25[$00], $01) + 0.5), entityz(local10\Field1\Field25[$00], $01))
                    pointentity(local10\Field1\Field32[$00]\Field4, local10\Field1\Field2, 0.0)
                    rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, (entityyaw(local10\Field1\Field32[$00]\Field4, $00) + rnd(-20.0, 20.0)), 0.0, $01)
                    setnpcframe(local10\Field1\Field32[$00], 288.0)
                    local10\Field1\Field32[$00]\Field9 = 8.0
                    local10\Field2 = 1.0
                    removeevent(local10)
                EndIf
            Case $1B
                If (networkserver\Field18 <> 0) Then
                    If ((Float millisecs2()) > local10\Field2) Then
                        If (playerroom <> local10\Field1) Then
                            If (16.0 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))) Then
                                For local8 = Each npcs
                                    If (local8\Field5 = $0A) Then
                                        If (((2.0 = local8\Field9) And (16.0 < entitydistance(local10\Field13, local8\Field4))) <> 0) Then
                                            tformvector(368.0, 528.0, 176.0, local10\Field1\Field2, $00)
                                            positionentity(local8\Field4, (entityx(local10\Field1\Field2, $00) + tformedx()), tformedy(), (entityz(local10\Field1\Field2, $00) + tformedz()), $00)
                                            debuglog((((((Str tformedx()) + ", ") + (Str tformedy())) + ", ") + (Str tformedz())))
                                            resetentity(local8\Field4)
                                            local8\Field37 = $00
                                            local8\Field9 = 4.0
                                            local8\Field10 = 0.0
                                            local8\Field11 = 0.0
                                            removeevent(local10)
                                        EndIf
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        EndIf
                        If (local10 <> Null) Then
                            local10\Field2 = (Float (millisecs2() + $1388))
                        EndIf
                    EndIf
                EndIf
            Case $28
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (((2.5 > entitydistance(local10\Field13, local10\Field1\Field29[$00]\Field0)) And remotedooron) <> 0) Then
                            giveachievement($01, $01)
                            playsound_strict(horrorsfx($07))
                            playsound2(leversfx, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                            local10\Field2 = 1.0
                            local10\Field1\Field29[$00]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $00, $01, $00, "", $00)
                            local10\Field1\Field29[$00]\Field4 = $01
                        EndIf
                    Else
                        local10\Field13 = collider
                        local10\Field20 = calculatedist(local10\Field13, local10\Field1)
                        If (local10\Field7 = $00) Then
                            loadeventsound(local10, "SFX\Music\012Golgotha.ogg", $00)
                        EndIf
                        local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field25[$03], 5.0, 1.0)
                        If (local10\Field8 = $00) Then
                            loadeventsound(local10, "SFX\Music\012.ogg", $01)
                        EndIf
                        If (90.0 > local10\Field2) Then
                            local10\Field2 = curvevalue(90.0, local10\Field2, 500.0)
                        EndIf
                        positionentity(local10\Field1\Field25[$02], entityx(local10\Field1\Field25[$02], $01), ((-130.0 - (sin(local10\Field2) * 448.0)) * roomscale), entityz(local10\Field1\Field25[$02], $01), $01)
                        If (((0.0 < local10\Field3) And (200.0 > local10\Field3)) <> 0) Then
                            local10\Field3 = (local10\Field3 + fpsfactor)
                            rotateentity(local10\Field1\Field25[$01], curvevalue(85.0, entitypitch(local10\Field1\Field25[$01], $00), 5.0), entityyaw(local10\Field1\Field25[$01], $00), 0.0, $00)
                        Else
                            local10\Field3 = (local10\Field3 + fpsfactor)
                            If (250.0 > local10\Field3) Then
                                showentity(local10\Field1\Field25[$03])
                            Else
                                hideentity(local10\Field1\Field25[$03])
                                If (300.0 < local10\Field3) Then
                                    local10\Field3 = 200.0
                                EndIf
                            EndIf
                        EndIf
                        If ((((wearing714 = $00) And (wearinggasmask < $03)) And (wearinghazmat < $03)) <> 0) Then
                            local10\Field13 = collider
                            local10\Field20 = calculatedist(local10\Field13, local10\Field1)
                            If (entityvisible(local10\Field1\Field25[$02], camera) <> 0) Then
                                local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local10\Field1\Field25[$03], 10.0, (local10\Field4 / 6020.0))
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), (entityy(local10\Field1\Field25[$02], $01) - 0.05), entityz(camera, $00), $00)
                                pointentity(local3, local10\Field1\Field25[$02], 0.0)
                                rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), (80.0 - (local10\Field4 / 200.0))), 0.0, $00)
                                turnentity(local3, 90.0, 0.0, 0.0, $00)
                                user_camera_pitch = curveangle((entitypitch(local3, $00) + 25.0), (user_camera_pitch + 90.0), (80.0 - (local10\Field4 / 200.0)))
                                user_camera_pitch = (user_camera_pitch - 90.0)
                                local0 = distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))
                                heartbeatrate = 150.0
                                heartbeatvolume = (max((3.0 - local0), 0.0) / 3.0)
                                blurvolume = max((((2.0 - local0) * (local10\Field4 / 800.0)) * sin((((Float millisecs2()) / 20.0) + 1.0))), blurvolume)
                                currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 8.0) * max((3.0 - local0), 0.0)))
                                If (breathchn <> $00) Then
                                    If (channelplaying(breathchn) <> 0) Then
                                        stopchannel(breathchn)
                                    EndIf
                                EndIf
                                If (0.6 > local0) Then
                                    local10\Field4 = min((local10\Field4 + fpsfactor), 6020.0)
                                    If (((70.0 < local10\Field4) And (70.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                        playsound_strict(loadtempsound("SFX\SCP\012\Speech1.ogg"))
                                        multiplayer_writetempsound("SFX\SCP\012\Speech1.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                    ElseIf (((910.0 < local10\Field4) And (910.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                        msg = "You start pushing your nails into your wrist, drawing blood."
                                        msgtimer = 490.0
                                        injuries = (injuries + 0.5)
                                        playsound_strict(loadtempsound("SFX\SCP\012\Speech2.ogg"))
                                        multiplayer_writetempsound("SFX\SCP\012\Speech2.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                    ElseIf (((2170.0 < local10\Field4) And (2170.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                        local73 = loadtexture_strict("GFX\map\scp-012_1.jpg", $01)
                                        entitytexture(local10\Field1\Field25[$04], local73, $00, $01)
                                        freetexture(local73)
                                        msg = "You tear open your left wrist and start writing on the composition with your blood."
                                        msgtimer = 490.0
                                        injuries = max(injuries, 1.5)
                                        playsound_strict(loadtempsound((("SFX\SCP\012\Speech" + (Str rand($03, $04))) + ".ogg")))
                                        multiplayer_writetempsound((("SFX\SCP\012\Speech" + (Str rand($03, $04))) + ".ogg"), 0.0, 0.0, 0.0, 10.0, 1.0)
                                    ElseIf (((3430.0 < local10\Field4) And (3430.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                        msg = "You push your fingers deeper into the wound."
                                        msgtimer = 560.0
                                        injuries = (injuries + 0.3)
                                        playsound_strict(loadtempsound("SFX\SCP\012\Speech5.ogg"))
                                        multiplayer_writetempsound("SFX\SCP\012\Speech5.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                    ElseIf (((4410.0 < local10\Field4) And (4410.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                        local73 = loadtexture_strict("GFX\map\scp-012_2.jpg", $01)
                                        entitytexture(local10\Field1\Field25[$04], local73, $00, $01)
                                        freetexture(local73)
                                        injuries = (injuries + 0.5)
                                        playsound_strict(loadtempsound("SFX\SCP\012\Speech6.ogg"))
                                        multiplayer_writetempsound("SFX\SCP\012\Speech6.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                    ElseIf (((5180.0 < local10\Field4) And (5180.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                        local73 = loadtexture_strict("GFX\map\scp-012_3.jpg", $01)
                                        entitytexture(local10\Field1\Field25[$04], local73, $00, $01)
                                        freetexture(local73)
                                        msg = "You rip the wound wide open. Grabbing scoops of blood pouring out."
                                        msgtimer = 490.0
                                        injuries = (injuries + 0.8)
                                        playsound_strict(loadtempsound("SFX\SCP\012\Speech7.ogg"))
                                        crouch = $01
                                        multiplayer_writetempsound("SFX\SCP\012\Speech7.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                        local32 = createdecal($11, entityx(local10\Field13, $00), ((-768.0 * roomscale) + 0.01), entityz(local10\Field13, $00), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                                        local32\Field2 = 0.1
                                        local32\Field3 = 0.45
                                        local32\Field1 = 0.0002
                                        updatedecals()
                                        multiplayer_writedecal(local32, $01, $01)
                                    ElseIf (((5950.0 < local10\Field4) And (5950.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                        deathmsg = "Subject D-9341 found in a pool of blood next to SCP-012. Subject seems to have ripped open his wrists and written three extra "
                                        deathmsg = (deathmsg + "lines to the composition before dying of blood loss.")
                                        kill("was killed by SCP-012", $00)
                                    EndIf
                                    rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(((sin((local10\Field4 * (local10\Field4 / 2000.0))) * (local10\Field4 / 300.0)) + entityyaw(local10\Field13, $00)), entityyaw(local10\Field13, $00), 80.0), 0.0, $00)
                                Else
                                    local21 = wrapangle((entityyaw(local3, $00) - entityyaw(local10\Field13, $00)))
                                    If (40.0 > local21) Then
                                        forcemove = ((40.0 - local21) * 0.02)
                                    ElseIf (310.0 < local21) Then
                                        forcemove = ((40.0 - (Abs (360.0 - local21))) * 0.02)
                                    EndIf
                                EndIf
                                freeentity(local3)
                            ElseIf (((4.5 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field29[$00]\Field2, $00), entityz(local10\Field1\Field29[$00]\Field2, $00))) And (-2.5 > entityy(local10\Field13, $00))) <> 0) Then
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), entityy(local10\Field13, $00), entityz(camera, $00), $00)
                                pointentity(local3, local10\Field1\Field29[$00]\Field2, 0.0)
                                user_camera_pitch = curveangle(90.0, (user_camera_pitch + 90.0), 100.0)
                                user_camera_pitch = (user_camera_pitch - 90.0)
                                rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), 150.0), 0.0, $00)
                                local21 = wrapangle((entityyaw(local3, $00) - entityyaw(local10\Field13, $00)))
                                If (40.0 > local21) Then
                                    forcemove = ((40.0 - local21) * 0.008)
                                ElseIf (310.0 < local21) Then
                                    forcemove = ((40.0 - (Abs (360.0 - local21))) * 0.008)
                                EndIf
                                freeentity(local3)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $29
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (2.0 > entitydistance(local10\Field13, local10\Field1\Field25[$03])) Then
                            local8 = createnpc($04, entityx(local10\Field1\Field25[$04], $01), 0.5, entityz(local10\Field1\Field25[$04], $01))
                            changenpctextureid(local8, $07)
                            local8\Field23 = "GFX\NPCs\035victim.jpg"
                            local8\Field62 = "GFX\NPCs\035.b3d"
                            hideentity(local8\Field0)
                            setanimtime(local8\Field0, 501.0, $00)
                            local8\Field14 = 501.0
                            local8\Field9 = 6.0
                            local10\Field2 = 1.0
                            local10\Field1\Field32[$00] = local8
                            local2 = (Int local10\Field1\Field32[$00]\Field14)
                            freeentity(local10\Field1\Field32[$00]\Field0)
                            local10\Field1\Field32[$00]\Field0 = loadanimmesh_strict("GFX\NPCs\035.b3d", $00)
                            local18 = (0.5 / meshwidth(local10\Field1\Field32[$00]\Field0))
                            local10\Field1\Field32[$00]\Field63 = local18
                            local10\Field1\Field32[$00]\Field64 = local18
                            local10\Field1\Field32[$00]\Field65 = local18
                            scaleentity(local10\Field1\Field32[$00]\Field0, local18, local18, local18, $00)
                            setanimtime(local10\Field1\Field32[$00]\Field0, (Float local2), $00)
                            showentity(local10\Field1\Field32[$00]\Field0)
                            rotateentity(local8\Field4, 0.0, (Float (local10\Field1\Field6 + $10E)), 0.0, $01)
                        EndIf
                    ElseIf (0.0 < local10\Field2) Then
                        If (local10\Field1\Field32[$00]\Field17 <> $00) Then
                            If (channelplaying(local10\Field1\Field32[$00]\Field17) <> 0) Then
                                local10\Field1\Field32[$00]\Field17 = loopsound2(local10\Field1\Field32[$00]\Field16, local10\Field1\Field32[$00]\Field17, camera, local10\Field1\Field2, 6.0, 1.0)
                            EndIf
                        EndIf
                        If (1.0 = local10\Field2) Then
                            If (1.2 > entitydistance(local10\Field13, local10\Field1\Field25[$03])) Then
                                If (entityinview(local10\Field1\Field32[$00]\Field0, getplayercamera(local10\Field14)) <> 0) Then
                                    giveachievement($02, $01)
                                    playsound_strict(loadtempsound("SFX\SCP\035\GetUp.ogg"))
                                    local10\Field2 = 1.5
                                EndIf
                            EndIf
                        Else
                            If (local10\Field1\Field29[$03]\Field5 <> 0) Then
                                local10\Field3 = max(local10\Field3, 1.0)
                            EndIf
                            If (updatelever(local10\Field1\Field28[$00], (20.0 = local10\Field3)) = $00) Then
                                local2 = updatelever(local10\Field1\Field28[$01], $00)
                                If ((local2 Or ((1750.0 < local10\Field4) And (3500.0 > local10\Field4))) <> 0) Then
                                    If (local2 <> 0) Then
                                        positionentity(local10\Field1\Field25[$05], entityx(local10\Field1\Field25[$05], $01), (424.0 * roomscale), entityz(local10\Field1\Field25[$05], $01), $01)
                                        positionentity(local10\Field1\Field25[$06], entityx(local10\Field1\Field25[$06], $01), (424.0 * roomscale), entityz(local10\Field1\Field25[$06], $01), $01)
                                    Else
                                        positionentity(local10\Field1\Field25[$05], entityx(local10\Field1\Field25[$05], $01), 10.0, entityz(local10\Field1\Field25[$05], $01), $01)
                                        positionentity(local10\Field1\Field25[$06], entityx(local10\Field1\Field25[$06], $01), 10.0, entityz(local10\Field1\Field25[$06], $01), $01)
                                    EndIf
                                    If (-2100.0 < local10\Field4) Then
                                        local10\Field4 = ((Abs local10\Field4) + fpsfactor)
                                        If (((1.0 < local10\Field4) And (1.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                            local10\Field1\Field32[$00]\Field9 = 0.0
                                            If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                local10\Field1\Field32[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Gased1.ogg")
                                            local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                        ElseIf (((1050.0 < local10\Field4) And (1750.0 > local10\Field4)) <> 0) Then
                                            If (1050.0 >= (local10\Field4 - fpsfactor)) Then
                                                If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                    local10\Field1\Field32[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Gased2.ogg")
                                                local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                                setnpcframe(local10\Field1\Field32[$00], 553.0)
                                            EndIf
                                            local10\Field1\Field32[$00]\Field9 = 6.0
                                            animatenpc(local10\Field1\Field32[$00], 553.0, 529.0, -0.12, $00)
                                        ElseIf (((1750.0 < local10\Field4) And (2450.0 > local10\Field4)) <> 0) Then
                                            local10\Field1\Field32[$00]\Field9 = 6.0
                                            animatenpc(local10\Field1\Field32[$00], 529.0, 524.0, -0.08, $00)
                                        ElseIf (2450.0 < local10\Field4) Then
                                            If (6.0 = local10\Field1\Field32[$00]\Field9) Then
                                                sanity = ((sin((animtime(local10\Field1\Field32[$00]\Field0) - 524.0)) * -150.0) * 9.0)
                                                animatenpc(local10\Field1\Field32[$00], 524.0, 553.0, 0.08, $00)
                                                If (553.0 = local10\Field1\Field32[$00]\Field14) Then
                                                    local10\Field1\Field32[$00]\Field9 = 0.0
                                                EndIf
                                            EndIf
                                            If (2450.0 >= (local10\Field4 - fpsfactor)) Then
                                                If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                    local10\Field1\Field32[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\GasedKilled1.ogg")
                                                local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                                playsound_strict(loadtempsound("SFX\SCP\035\KilledGetUp.ogg"))
                                                local10\Field2 = 4200.0
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    If (6.0 = local10\Field1\Field32[$00]\Field9) Then
                                        If (((501.0 <= local10\Field1\Field32[$00]\Field14) And (523.0 >= local10\Field1\Field32[$00]\Field14)) <> 0) Then
                                            local10\Field1\Field32[$00]\Field14 = animate2(local10\Field1\Field32[$00]\Field0, animtime(local10\Field1\Field32[$00]\Field0), $1F5, $20B, 0.08, $00)
                                            If (523.0 = local10\Field1\Field32[$00]\Field14) Then
                                                local10\Field1\Field32[$00]\Field9 = 0.0
                                            EndIf
                                        EndIf
                                        If (((524.0 <= local10\Field1\Field32[$00]\Field14) And (553.0 >= local10\Field1\Field32[$00]\Field14)) <> 0) Then
                                            local10\Field1\Field32[$00]\Field14 = animate2(local10\Field1\Field32[$00]\Field0, animtime(local10\Field1\Field32[$00]\Field0), $20C, $229, 0.08, $00)
                                            If (553.0 = local10\Field1\Field32[$00]\Field14) Then
                                                local10\Field1\Field32[$00]\Field9 = 0.0
                                            EndIf
                                        EndIf
                                    EndIf
                                    positionentity(local10\Field1\Field25[$05], entityx(local10\Field1\Field25[$05], $01), 10.0, entityz(local10\Field1\Field25[$05], $01), $01)
                                    positionentity(local10\Field1\Field25[$06], entityx(local10\Field1\Field25[$06], $01), 10.0, entityz(local10\Field1\Field25[$06], $01), $01)
                                    If (0.0 = local10\Field1\Field32[$00]\Field9) Then
                                        pointentity(local10\Field1\Field32[$00]\Field0, local10\Field13, 0.0)
                                        rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$00]\Field0, $00), entityyaw(local10\Field1\Field32[$00]\Field4, $00), 15.0), 0.0, $00)
                                        If (rand($1F4, $01) = $01) Then
                                            If (2.0 < entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field1\Field25[$04])) Then
                                                local10\Field1\Field32[$00]\Field10 = 1.0
                                            Else
                                                local10\Field1\Field32[$00]\Field10 = 0.0
                                            EndIf
                                            local10\Field1\Field32[$00]\Field9 = 1.0
                                        EndIf
                                    ElseIf (1.0 = local10\Field1\Field32[$00]\Field9) Then
                                        If (1.0 = local10\Field1\Field32[$00]\Field10) Then
                                            pointentity(local10\Field1\Field32[$00]\Field0, local10\Field1\Field25[$04], 0.0)
                                            If (0.2 > entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field1\Field25[$04])) Then
                                                local10\Field1\Field32[$00]\Field9 = 0.0
                                            EndIf
                                        Else
                                            rotateentity(local10\Field1\Field32[$00]\Field0, 0.0, (Float (local10\Field1\Field6 - $B4)), 0.0, $01)
                                            If (2.0 < entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field1\Field25[$04])) Then
                                                local10\Field1\Field32[$00]\Field9 = 0.0
                                            EndIf
                                        EndIf
                                        rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$00]\Field0, $00), entityyaw(local10\Field1\Field32[$00]\Field4, $00), 15.0), 0.0, $00)
                                    EndIf
                                    If (0.0 < local10\Field4) Then
                                        local10\Field4 = (- local10\Field4)
                                        If (-2450.0 > local10\Field4) Then
                                            If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                local10\Field1\Field32[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\GasedKilled2.ogg")
                                            local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                            local10\Field2 = 4200.0
                                        Else
                                            If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                local10\Field1\Field32[$00]\Field16 = $00
                                            EndIf
                                            If (-1400.0 > local10\Field4) Then
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\GasedStop2.ogg")
                                            Else
                                                local10\Field4 = -1470.0
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\GasedStop1.ogg")
                                            EndIf
                                            local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                            local10\Field2 = 4270.0
                                        EndIf
                                    Else
                                        local10\Field2 = (local10\Field2 + fpsfactor)
                                        If (((280.0 < local10\Field2) And (280.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                            If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                local10\Field1\Field32[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Help1.ogg")
                                            local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                            local10\Field2 = 700.0
                                        ElseIf (((1400.0 < local10\Field2) And (1400.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                            If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                local10\Field1\Field32[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Help2.ogg")
                                            local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                        ElseIf (((2800.0 < local10\Field2) And (2800.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                            If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                local10\Field1\Field32[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Idle1.ogg")
                                            local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                        ElseIf (((3500.0 < local10\Field2) And (3500.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                            If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                local10\Field1\Field32[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Idle2.ogg")
                                            local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                        ElseIf (((5600.0 < local10\Field2) And (5600.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                            If ((Int local10\Field3) <> 0) Then
                                                local10\Field2 = 9100.0
                                            ElseIf (-2100.0 > local10\Field4) Then
                                                If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                    local10\Field1\Field32[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\GasedCloset.ogg")
                                                local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                            ElseIf (0.0 = local10\Field4) Then
                                                If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                    local10\Field1\Field32[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Closet1.ogg")
                                                local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                            Else
                                                If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                    local10\Field1\Field32[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\GasedCloset.ogg")
                                                local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                            EndIf
                                        ElseIf (5600.0 < local10\Field2) Then
                                            If ((Int local10\Field3) <> 0) Then
                                                local10\Field2 = max(local10\Field2, 7000.0)
                                            EndIf
                                            If (((7700.0 < local10\Field2) And (7700.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                                If ((Int local10\Field3) <> 0) Then
                                                    If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                        freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                        local10\Field1\Field32[$00]\Field16 = $00
                                                    EndIf
                                                    local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Closet2.ogg")
                                                    local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                                    local10\Field2 = 9100.0
                                                Else
                                                    If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                        freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                        local10\Field1\Field32[$00]\Field16 = $00
                                                    EndIf
                                                    local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Idle3.ogg")
                                                    local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                                EndIf
                                            ElseIf (((8750.0 < local10\Field2) And (8750.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                                If ((Int local10\Field3) <> 0) Then
                                                    If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                        freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                        local10\Field1\Field32[$00]\Field16 = $00
                                                    EndIf
                                                    local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Closet2.ogg")
                                                    local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                                Else
                                                    If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                        freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                        local10\Field1\Field32[$00]\Field16 = $00
                                                    EndIf
                                                    local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Idle4.ogg")
                                                    local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                                EndIf
                                            ElseIf (((10500.0 < local10\Field2) And (10500.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                                If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                    local10\Field1\Field32[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Idle5.ogg")
                                                local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                            ElseIf (((14000.0 < local10\Field2) And (14000.0 >= (local10\Field2 - fpsfactor))) <> 0) Then
                                                If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field32[$00]\Field16)
                                                    local10\Field1\Field32[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Idle6.ogg")
                                                local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Else
                                If (10.0 > local10\Field3) Then
                                    local10\Field1\Field29[$02]\Field5 = $00
                                    local10\Field1\Field29[$02]\Field4 = $01
                                    If (local10\Field1\Field29[$01]\Field5 = $00) Then
                                        local10\Field1\Field29[$00]\Field4 = $00
                                        local10\Field1\Field29[$01]\Field4 = $00
                                        usedoor(local10\Field1\Field29[$01], $01, $01, $00, "", $00)
                                        local10\Field1\Field29[$00]\Field4 = $01
                                        local10\Field1\Field29[$01]\Field4 = $01
                                    EndIf
                                    If (0.0 = local10\Field4) Then
                                        If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                            freesound_strict(local10\Field1\Field32[$00]\Field16)
                                            local10\Field1\Field32[$00]\Field16 = $00
                                        EndIf
                                        local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\Escape.ogg")
                                        local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                    ElseIf (2450.0 < (Abs local10\Field4)) Then
                                        If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                            freesound_strict(local10\Field1\Field32[$00]\Field16)
                                            local10\Field1\Field32[$00]\Field16 = $00
                                        EndIf
                                        local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\KilledEscape.ogg")
                                        local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                    Else
                                        If (local10\Field1\Field32[$00]\Field16 <> $00) Then
                                            freesound_strict(local10\Field1\Field32[$00]\Field16)
                                            local10\Field1\Field32[$00]\Field16 = $00
                                        EndIf
                                        local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\035\GasedEscape.ogg")
                                        local10\Field1\Field32[$00]\Field17 = playsound_strict(local10\Field1\Field32[$00]\Field16)
                                    EndIf
                                    local10\Field3 = 20.0
                                EndIf
                                If (20.0 = local10\Field3) Then
                                    local0 = entitydistance(local10\Field1\Field29[$00]\Field2, local10\Field1\Field32[$00]\Field4)
                                    local10\Field1\Field32[$00]\Field9 = 1.0
                                    If (2.5 < local0) Then
                                        pointentity(local10\Field1\Field32[$00]\Field0, local10\Field1\Field29[$01]\Field2, 0.0)
                                        rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$00]\Field0, $00), entityyaw(local10\Field1\Field32[$00]\Field4, $00), 15.0), 0.0, $00)
                                    ElseIf (0.7 < local0) Then
                                        If (channelplaying(local10\Field1\Field32[$00]\Field17) <> 0) Then
                                            local10\Field1\Field32[$00]\Field9 = 0.0
                                            pointentity(local10\Field1\Field32[$00]\Field0, local10\Field13, 0.0)
                                            rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$00]\Field0, $00), entityyaw(local10\Field1\Field32[$00]\Field4, $00), 15.0), 0.0, $00)
                                        Else
                                            pointentity(local10\Field1\Field32[$00]\Field0, local10\Field1\Field29[$00]\Field2, 0.0)
                                            rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field32[$00]\Field0, $00), entityyaw(local10\Field1\Field32[$00]\Field4, $00), 15.0), 0.0, $00)
                                        EndIf
                                    Else
                                        removenpc(local10\Field1\Field32[$00], $00)
                                        local10\Field1\Field32[$00] = Null
                                        local10\Field2 = -1.0
                                        local10\Field3 = 0.0
                                        local10\Field4 = 0.0
                                        local10\Field1\Field29[$00]\Field4 = $00
                                        local10\Field1\Field29[$01]\Field4 = $00
                                        local10\Field1\Field29[$02]\Field4 = $00
                                        usedoor(local10\Field1\Field29[$01], $00, $01, $00, "", $00)
                                        For local29 = Each doors
                                            If (local29\Field9 = $02) Then
                                                If (4.5 > (Abs (entityx(local10\Field1\Field2, $00) - entityx(local29\Field2, $01)))) Then
                                                    If (4.5 > (Abs (entityz(local10\Field1\Field2, $00) - entityz(local29\Field2, $01)))) Then
                                                        usedoor(local29, $00, $01, $00, "", $00)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Else
                        If (updatelever(local10\Field1\Field28[$01], $00) <> 0) Then
                            positionentity(local10\Field1\Field25[$05], entityx(local10\Field1\Field25[$05], $01), (424.0 * roomscale), entityz(local10\Field1\Field25[$05], $01), $01)
                            positionentity(local10\Field1\Field25[$06], entityx(local10\Field1\Field25[$06], $01), (424.0 * roomscale), entityz(local10\Field1\Field25[$06], $01), $01)
                        Else
                            positionentity(local10\Field1\Field25[$05], entityx(local10\Field1\Field25[$05], $01), 10.0, entityz(local10\Field1\Field25[$05], $01), $01)
                            positionentity(local10\Field1\Field25[$06], entityx(local10\Field1\Field25[$06], $01), 10.0, entityz(local10\Field1\Field25[$06], $01), $01)
                        EndIf
                        local2 = $00
                        If (entityx(collider, $00) > min(entityx(local10\Field1\Field25[$07], $01), entityx(local10\Field1\Field25[$08], $01))) Then
                            If (entityx(collider, $00) < max(entityx(local10\Field1\Field25[$07], $01), entityx(local10\Field1\Field25[$08], $01))) Then
                                If (entityz(collider, $00) > min(entityz(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field25[$08], $01))) Then
                                    If (entityz(collider, $00) < max(entityz(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field25[$08], $01))) Then
                                        shouldplay = $00
                                        stamina = curvevalue(min(60.0, stamina), stamina, 20.0)
                                        If ((((wearing714 = $00) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                                            sanity = (sanity - (fpsfactor * 1.1))
                                            blurtimer = (sin((Float (millisecs2() / $0A))) * (Abs sanity))
                                        EndIf
                                        If (wearinghazmat = $00) Then
                                            injuries = ((fpsfactor / 5000.0) + injuries)
                                        Else
                                            injuries = ((fpsfactor / 10000.0) + injuries)
                                        EndIf
                                        If (((0.0 > killtimer) And (100.0 <= bloodloss)) <> 0) Then
                                            deathmsg = "Class D Subject D-9341 found dead inside SCP-035's containment chamber. "
                                            deathmsg = (deathmsg + "The subject exhibits heavy hemorrhaging of blood vessels around the eyes and inside the mouth and nose. ")
                                            deathmsg = (deathmsg + "Sent for autopsy.")
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (entityx(local10\Field13, $00) > min(entityx(local10\Field1\Field25[$07], $01), entityx(local10\Field1\Field25[$08], $01))) Then
                            If (entityx(local10\Field13, $00) < max(entityx(local10\Field1\Field25[$07], $01), entityx(local10\Field1\Field25[$08], $01))) Then
                                If (entityz(local10\Field13, $00) > min(entityz(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field25[$08], $01))) Then
                                    If (entityz(local10\Field13, $00) < max(entityz(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field25[$08], $01))) Then
                                        If (local10\Field1\Field32[$00] = Null) Then
                                            If (local10\Field1\Field32[$00] = Null) Then
                                                local10\Field1\Field32[$00] = createnpc($0D, 0.0, 0.0, 0.0)
                                            EndIf
                                        EndIf
                                        positionentity(local10\Field1\Field32[$00]\Field4, entityx(local10\Field1\Field25[$04], $01), 0.0, entityz(local10\Field1\Field25[$04], $01), $00)
                                        If (0.0 < local10\Field1\Field32[$00]\Field9) Then
                                            If (local10\Field1\Field32[$01] = Null) Then
                                                If (local10\Field1\Field32[$01] = Null) Then
                                                    local10\Field1\Field32[$01] = createnpc($0D, 0.0, 0.0, 0.0)
                                                EndIf
                                            EndIf
                                        EndIf
                                        local2 = $01
                                        If (local10\Field7 = $00) Then
                                            loadeventsound(local10, "SFX\Room\035Chamber\Whispers1.ogg", $00)
                                        EndIf
                                        If (local10\Field8 = $00) Then
                                            loadeventsound(local10, "SFX\Room\035Chamber\Whispers2.ogg", $01)
                                        EndIf
                                        local10\Field3 = min((local10\Field3 + (fpsfactor / 6000.0)), 1.0)
                                        local10\Field4 = curvevalue(local10\Field3, local10\Field4, 50.0)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (local10\Field1\Field32[$01] <> Null) Then
                            positionentity(local10\Field1\Field32[$01]\Field4, entityx(local10\Field1\Field2, $01), 0.0, entityz(local10\Field1\Field2, $01), $00)
                            local21 = wrapangle((entityyaw(local10\Field1\Field32[$01]\Field4, $00) - (Float local10\Field1\Field6)))
                            If (90.0 < local21) Then
                                If (225.0 > local21) Then
                                    rotateentity(local10\Field1\Field32[$01]\Field4, 0.0, (Float ((local10\Field1\Field6 - $59) - $B4)), 0.0, $00)
                                Else
                                    rotateentity(local10\Field1\Field32[$01]\Field4, 0.0, (Float (local10\Field1\Field6 - $01)), 0.0, $00)
                                EndIf
                            EndIf
                        EndIf
                        If (local2 = $00) Then
                            local10\Field3 = max((local10\Field3 - (fpsfactor / 2000.0)), 0.0)
                            local10\Field4 = max((local10\Field4 - (fpsfactor / 100.0)), 0.0)
                        EndIf
                        If (((((0.0 < local10\Field4) And (wearing714 = $00)) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                            local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field2, 10.0, local10\Field4)
                            local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local10\Field1\Field2, 10.0, ((local10\Field4 - 0.5) * 2.0))
                        EndIf
                    EndIf
                ElseIf (0.0 = local10\Field2) Then
                    If (local10\Field7 = $00) Then
                        If (20.0 > entitydistance(local10\Field13, local10\Field1\Field2)) Then
                            loadeventsound(local10, "SFX\Room\035Chamber\InProximity.ogg", $00)
                            playsound_strict(local10\Field7)
                        EndIf
                    EndIf
                ElseIf (0.0 > local10\Field2) Then
                    For local1 = $00 To $01 Step $01
                        If (local10\Field1\Field32[local1] <> Null) Then
                            removenpc(local10\Field1\Field32[local1], $00)
                            local10\Field1\Field32[local1] = Null
                        EndIf
                    Next
                EndIf
            Case $27
                local10\Field24 = $00
                local10\Field1\Field29[$00]\Field28 = updateelevators(local10\Field1\Field29[$00]\Field28, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
                local10\Field1\Field29[$02]\Field28 = updateelevators(local10\Field1\Field29[$02]\Field28, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $01)
                If (playerinroom(local10) <> 0) Then
                    If ((((-2848.0 * roomscale) >= entityy(local10\Field13, $00)) Or ((-2848.0 * roomscale) >= entityy(collider, $00))) <> 0) Then
                        If (playerroom = local10\Field1) Then
                            shouldplay = $19
                        EndIf
                        If (0.0 = local10\Field2) Then
                            If (((local10\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                                quickloadpercent = $00
                                quickload_currevent = local10
                                local10\Field11 = "load0"
                            EndIf
                            playsound_strict(loadtempsound("SFX\Room\Blackout.ogg"))
                            If (entitydistance(local10\Field1\Field25[$0C], local10\Field13) > entitydistance(local10\Field1\Field25[$0B], local10\Field13)) Then
                                local12 = createitem("Research Sector-02 Scheme", "paper", entityx(local10\Field1\Field25[$0B], $01), entityy(local10\Field1\Field25[$0B], $01), entityz(local10\Field1\Field25[$0B], $01), $00, $00, $00, 1.0, $00, $01)
                                entitytype(local12\Field1, $03, $00)
                            Else
                                local12 = createitem("Research Sector-02 Scheme", "paper", entityx(local10\Field1\Field25[$0C], $01), entityy(local10\Field1\Field25[$0C], $01), entityz(local10\Field1\Field25[$0C], $01), $00, $00, $00, 1.0, $00, $01)
                                entitytype(local12\Field1, $03, $00)
                            EndIf
                        ElseIf (0.0 < local10\Field2) Then
                            If (0.0 < entitypitch(local10\Field1\Field25[$09], $01)) Then
                                local81 = $01
                            Else
                                local81 = $00
                            EndIf
                            local2 = (updatelever(local10\Field1\Field25[$07], $00) = $00)
                            local18 = (Float updatelever(local10\Field1\Field25[$09], $00))
                            local10\Field1\Field29[$01]\Field4 = $01
                            local10\Field1\Field29[$03]\Field4 = $01
                            local10\Field1\Field29[$01]\Field23 = $00
                            local10\Field1\Field29[$03]\Field23 = $00
                            If (local18 <> (Float local81)) Then
                                If (0.0 = local18) Then
                                    playsound_strict(lightsfx)
                                Else
                                    playsound_strict(teslapowerupsfx)
                                EndIf
                            EndIf
                            If (70.0 <= local10\Field2) Then
                                If ((Int local18) <> 0) Then
                                    If (playerroom = local10\Field1) Then
                                        shouldplay = $08
                                    EndIf
                                    local10\Field2 = max(local10\Field2, 12600.0)
                                    secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                                    If (local10\Field8 = $00) Then
                                        loadeventsound(local10, "SFX\Ambient\Room ambience\fuelpump.ogg", $01)
                                    EndIf
                                    local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local10\Field1\Field25[$0A], 6.0, 1.0)
                                    For local1 = $04 To $06 Step $01
                                        local10\Field1\Field29[local1]\Field4 = $00
                                    Next
                                Else
                                    secondarylighton = curvevalue(0.0, secondarylighton, 10.0)
                                    If (channelplaying(local10\Field6) <> 0) Then
                                        stopchannel(local10\Field6)
                                    EndIf
                                    For local1 = $04 To $06 Step $01
                                        local10\Field1\Field29[local1]\Field4 = $01
                                    Next
                                EndIf
                            Else
                                local10\Field2 = min((local10\Field2 + fpsfactor), 70.0)
                            EndIf
                            If ((local2 And (Int local18)) <> 0) Then
                                local10\Field1\Field29[$01]\Field4 = $00
                                local10\Field1\Field29[$03]\Field4 = $00
                                If (local10\Field1\Field32[$00] <> Null) Then
                                    If (0.0 < local10\Field1\Field32[$00]\Field24) Then
                                        local1 = $00
                                        If (3.0 > entitydistance(local10\Field13, local10\Field1\Field29[$01]\Field2)) Then
                                            local1 = $01
                                        ElseIf (3.0 > entitydistance(local10\Field13, local10\Field1\Field29[$03]\Field2)) Then
                                            local1 = $03
                                        EndIf
                                        If (local1 > $00) Then
                                            positionentity(local10\Field1\Field32[$00]\Field4, entityx(local10\Field1\Field25[local1], $01), entityy(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01), $00)
                                            resetentity(local10\Field1\Field32[$00]\Field4)
                                            playsound2(elevatorbeepsfx, camera, local10\Field1\Field25[local1], 4.0, 1.0)
                                            local10\Field1\Field29[local1]\Field4 = $00
                                            usedoor(local10\Field1\Field29[local1], $00, $01, $00, "", $00)
                                            local10\Field1\Field29[(local1 - $01)]\Field5 = $00
                                            local10\Field1\Field29[local1]\Field5 = $01
                                            local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00))
                                            If (local10\Field1\Field32[$00]\Field19 <> $00) Then
                                                freesound_strict(local10\Field1\Field32[$00]\Field19)
                                            EndIf
                                            local10\Field1\Field32[$00]\Field19 = loadsound_strict("SFX\SCP\049\DetectedInChamber.ogg")
                                            local10\Field1\Field32[$00]\Field20 = loopsound2(local10\Field1\Field32[$00]\Field19, local10\Field1\Field32[$00]\Field20, camera, local10\Field1\Field32[$00]\Field0, 10.0, 1.0)
                                            local10\Field1\Field32[$00]\Field24 = 0.0
                                            local10\Field1\Field32[$00]\Field66 = $00
                                            local10\Field1\Field32[$00]\Field12 = $02
                                            local10\Field1\Field32[$00]\Field9 = 2.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If (13300.0 > local10\Field2) Then
                                If (12600.0 <= local10\Field2) Then
                                    local10\Field1\Field29[$01]\Field5 = $00
                                    local10\Field1\Field29[$03]\Field5 = $00
                                    local10\Field1\Field29[$00]\Field5 = $01
                                    local10\Field1\Field29[$02]\Field5 = $01
                                    local10\Field2 = 13300.0
                                EndIf
                            ElseIf (16800.0 > local10\Field2) Then
                                For local8 = Each npcs
                                    If (((local8\Field5 = $0B) And (0.0 = local8\Field9)) <> 0) Then
                                        local8\Field9 = 1.0
                                        setnpcframe(local8, 155.0)
                                    EndIf
                                Next
                                local10\Field2 = 16870.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $26
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        local10\Field1\Field32[$00] = createnpc($03, entityx(local10\Field1\Field25[$02], $01), (entityy(local10\Field1\Field25[$02], $01) + 0.5), entityz(local10\Field1\Field25[$02], $01))
                        pointentity(local10\Field1\Field32[$00]\Field4, local10\Field1\Field2, 0.0)
                        rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, entityyaw(local10\Field1\Field32[$00]\Field4, $00), 0.0, $01)
                        setnpcframe(local10\Field1\Field32[$00], 288.0)
                        local10\Field1\Field32[$00]\Field9 = 8.0
                        local10\Field2 = 1.0
                    EndIf
                    If (playerroom = local10\Field1) Then
                        shouldplay = $04
                    EndIf
                    If (remotedooron <> 0) Then
                        If (local10\Field1\Field29[$00]\Field5 <> 0) Then
                            If (((50.0 < local10\Field1\Field29[$00]\Field7) Or (0.5 > entitydistance(local10\Field13, local10\Field1\Field29[$00]\Field2))) <> 0) Then
                                local10\Field1\Field29[$00]\Field7 = min(local10\Field1\Field29[$00]\Field7, 50.0)
                                local10\Field1\Field29[$00]\Field5 = $00
                                playsound_strict(loadtempsound("SFX\Door\DoorError.ogg"))
                            EndIf
                        EndIf
                    ElseIf (10000.0 > local10\Field2) Then
                        If (1.0 = local10\Field2) Then
                            local10\Field2 = 2.0
                        ElseIf (2.0 = local10\Field2) Then
                            If (3.0 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                                giveachievement($05, $01)
                                local10\Field2 = 3.0
                                local10\Field3 = 1.0
                                local10\Field5 = streamsound_strict("SFX\SCP\079\Speech.ogg", sfxvolume, $00)
                                local10\Field9 = $01
                            EndIf
                        ElseIf (2000.0 > local10\Field2) Then
                            If (isstreamplaying_strict(local10\Field5) <> 0) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(local10\Field1\Field25[$01], oldaipics($00), $00, $00)
                                    showentity(local10\Field1\Field25[$01])
                                ElseIf (rand($0A, $01) = $01) Then
                                    hideentity(local10\Field1\Field25[$01])
                                EndIf
                            Else
                                If (local10\Field5 <> $00) Then
                                    stopstream_strict(local10\Field5)
                                    local10\Field5 = $00
                                EndIf
                                entitytexture(local10\Field1\Field25[$01], oldaipics($01), $00, $00)
                                showentity(local10\Field1\Field25[$01])
                                local10\Field2 = (local10\Field2 + fpsfactor)
                            EndIf
                        ElseIf (2.5 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                            local10\Field2 = 10001.0
                            If (local10\Field5 <> $00) Then
                                stopstream_strict(local10\Field5)
                                local10\Field5 = $00
                            EndIf
                            local10\Field5 = streamsound_strict("SFX\SCP\079\Refuse.ogg", sfxvolume, $00)
                        EndIf
                    ElseIf (local10\Field5 <> $00) Then
                        If (isstreamplaying_strict(local10\Field5) = $00) Then
                            local10\Field5 = $00
                            entitytexture(local10\Field1\Field25[$01], oldaipics($01), $00, $00)
                            showentity(local10\Field1\Field25[$01])
                        ElseIf (rand($03, $01) = $01) Then
                            entitytexture(local10\Field1\Field25[$01], oldaipics($00), $00, $00)
                            showentity(local10\Field1\Field25[$01])
                        ElseIf (rand($0A, $01) = $01) Then
                            hideentity(local10\Field1\Field25[$01])
                        EndIf
                    EndIf
                EndIf
                If (1.0 = local10\Field3) Then
                    If (remotedooron <> 0) Then
                        If (local10\Field5 <> $00) Then
                            stopstream_strict(local10\Field5)
                            local10\Field5 = $00
                        EndIf
                        local10\Field5 = streamsound_strict("SFX\SCP\079\GateB.ogg", sfxvolume, $00)
                        local10\Field9 = $01
                        local10\Field3 = 2.0
                        For local11 = Each events
                            If (((local11\Field0 = "exit1") Or (local11\Field0 = "gateaentrance")) <> 0) Then
                                local11\Field4 = 1.0
                            EndIf
                        Next
                    EndIf
                EndIf
            Case $2B
                local10\Field24 = $00
                If (soundtransmission <> 0) Then
                    If (1.0 = local10\Field2) Then
                        local10\Field4 = min((local10\Field4 + fpsfactor), 4000.0)
                    EndIf
                    If (channelplaying(local10\Field5) = $00) Then
                        local10\Field5 = playsound_strict(radiostatic)
                    EndIf
                EndIf
                If (local10\Field1\Field32[$00] = Null) Then
                    tformpoint(1088.0, 1096.0, 1728.0, local10\Field1\Field2, $00)
                    local10\Field1\Field32[$00] = createnpc($04, tformedx(), tformedy(), tformedz())
                    turnentity(local10\Field1\Field32[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $5A)), 0.0, $01)
                    local10\Field1\Field32[$00]\Field66 = $01
                EndIf
                If ((playerinroom(local10) And (local10\Field1\Field32[$00] <> Null)) <> 0) Then
                    shouldplay = $42
                    local10\Field1\Field32[$00]\Field9 = 6.0
                    If (0.0 = local10\Field1\Field32[$00]\Field24) Then
                        animatenpc(local10\Field1\Field32[$00], 17.0, 19.0, 0.01, $00)
                        If (19.0 = local10\Field1\Field32[$00]\Field14) Then
                            local10\Field1\Field32[$00]\Field24 = 1.0
                        EndIf
                    Else
                        animatenpc(local10\Field1\Field32[$00], 19.0, 17.0, -0.01, $00)
                        If (17.0 = local10\Field1\Field32[$00]\Field14) Then
                            local10\Field1\Field32[$00]\Field24 = 0.0
                        EndIf
                    EndIf
                    positionentity(local10\Field1\Field32[$00]\Field4, entityx(local10\Field1\Field25[$05], $01), (entityy(local10\Field1\Field25[$05], $01) + 0.1), entityz(local10\Field1\Field25[$05], $01), $01)
                    rotateentity(local10\Field1\Field32[$00]\Field4, entitypitch(local10\Field1\Field25[$05], $01), entityyaw(local10\Field1\Field25[$05], $01), 0.0, $01)
                    resetentity(local10\Field1\Field32[$00]\Field4)
                    local2 = (Int local10\Field3)
                    local82 = updatelever(local10\Field1\Field25[$01], (((-990.0 * roomscale) > entityy(local10\Field1\Field25[$06], $01)) And ((-1275.0 * roomscale) < entityy(local10\Field1\Field25[$06], $01))))
                    If (((grabbedentity = local10\Field1\Field25[$01]) And (drawhandicon = $01)) <> 0) Then
                        local10\Field3 = (Float local82)
                    EndIf
                    If ((Float local2) <> local10\Field3) Then
                        If (0.0 = local10\Field3) Then
                            playsound_strict(magnetdownsfx)
                        Else
                            playsound_strict(magnetupsfx)
                        EndIf
                    EndIf
                    If ((((3200.0 < local10\Field4) Or (2500.0 > local10\Field4)) Or (1.0 <> local10\Field2)) <> 0) Then
                        soundtransmission = updatelever(local10\Field1\Field25[$03], $00)
                    EndIf
                    If (soundtransmission = $00) Then
                        If (local10\Field6 <> $00) Then
                            If (channelplaying(local10\Field6) <> 0) Then
                                stopchannel(local10\Field6)
                            EndIf
                        EndIf
                        If (local10\Field5 <> $00) Then
                            If (channelplaying(local10\Field5) <> 0) Then
                                stopchannel(local10\Field5)
                            EndIf
                        EndIf
                    EndIf
                    If (0.0 = local10\Field2) Then
                        If ((soundtransmission And (rand($64, $01) = $01)) <> 0) Then
                            If (local10\Field6 = $00) Then
                                loadeventsound(local10, (("SFX\Character\LureSubject\Idle" + (Str rand($01, $06))) + ".ogg"), $01)
                                local10\Field6 = playsound_strict(local10\Field8)
                            EndIf
                            If (channelplaying(local10\Field6) = $00) Then
                                loadeventsound(local10, (("SFX\Character\LureSubject\Idle" + (Str rand($01, $06))) + ".ogg"), $01)
                                local10\Field6 = playsound_strict(local10\Field8)
                            EndIf
                        EndIf
                        If (soundtransmission <> 0) Then
                            updatebutton(local10\Field1\Field25[$04])
                            If (((closestbutton = local10\Field1\Field25[$04]) And mousehit1) <> 0) Then
                                If (multiplayer_send($25, $FFFFFFFF, $FFFFFFFF) = $00) Then
                                    If (0.0 = local10\Field2) Then
                                        local10\Field2 = 1.0
                                        If (soundtransmission = $01) Then
                                            If (local10\Field6 <> $00) Then
                                                If (channelplaying(local10\Field6) <> 0) Then
                                                    stopchannel(local10\Field6)
                                                EndIf
                                            EndIf
                                            femurbreakersfx = loadsound_strict("SFX\Room\106Chamber\FemurBreaker.ogg")
                                            local10\Field6 = playsound_strict(femurbreakersfx)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (1.0 = local10\Field2) Then
                        If ((soundtransmission And (2000.0 > local10\Field4)) <> 0) Then
                            If (local10\Field6 = $00) Then
                                loadeventsound(local10, "SFX\Character\LureSubject\Sniffling.ogg", $01)
                                local10\Field6 = playsound_strict(local10\Field8)
                            EndIf
                            If (channelplaying(local10\Field6) = $00) Then
                                loadeventsound(local10, "SFX\Character\LureSubject\Sniffling.ogg", $01)
                                local10\Field6 = playsound_strict(local10\Field8)
                            EndIf
                        EndIf
                        If (2500.0 <= local10\Field4) Then
                            If (((1.0 = local10\Field3) And (2500.0 > (local10\Field4 - fpsfactor))) <> 0) Then
                                positionentity(curr106\Field4, entityx(local10\Field1\Field25[$06], $01), entityy(local10\Field1\Field25[$06], $01), entityz(local10\Field1\Field25[$06], $01), $00)
                                contained106 = $00
                                showentity(curr106\Field0)
                                curr106\Field24 = 0.0
                                curr106\Field9 = -11.0
                                local10\Field2 = 2.0
                                Exit
                            EndIf
                            If (contained106 = $00) Then
                                shouldplay = $0A
                            EndIf
                            positionentity(curr106\Field4, entityx(local10\Field1\Field25[$05], $01), ((((min((local10\Field4 - 2500.0), 800.0) / 320.0) * 108.0) + 700.0) * roomscale), entityz(local10\Field1\Field25[$05], $01), $00)
                            hideentity(curr106\Field1)
                            rotateentity(curr106\Field4, 0.0, (entityyaw(local10\Field1\Field25[$05], $01) + 180.0), 0.0, $01)
                            curr106\Field9 = -11.0
                            animatenpc(curr106, 206.0, 250.0, 0.1, $01)
                            curr106\Field24 = 1.0
                            If (2500.0 > (local10\Field4 - fpsfactor)) Then
                                local72 = createdecal($00, entityx(local10\Field1\Field25[$05], $01), (936.0 * roomscale), entityz(local10\Field1\Field25[$05], $01), 90.0, 0.0, rnd(360.0, 0.0), 1.0, 1.0)
                                local72\Field9 = 90000.0
                                local72\Field5 = 0.01
                                local72\Field4 = 0.005
                                local72\Field2 = 0.1
                                local72\Field1 = 0.003
                                If (local10\Field6 <> $00) Then
                                    If (channelplaying(local10\Field6) <> 0) Then
                                        stopchannel(local10\Field6)
                                    EndIf
                                EndIf
                                loadeventsound(local10, "SFX\Character\LureSubject\106Bait.ogg", $01)
                                local10\Field6 = playsound_strict(local10\Field8)
                            ElseIf (((2900.0 > (local10\Field4 - fpsfactor)) And (2900.0 <= local10\Field4)) <> 0) Then
                                If (femurbreakersfx <> $00) Then
                                    freesound_strict(femurbreakersfx)
                                    femurbreakersfx = $00
                                EndIf
                                local72 = createdecal($00, entityx(local10\Field1\Field25[$07], $01), entityy(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field25[$07], $01), 0.0, 0.0, 0.0, 1.0, 1.0)
                                rotateentity(local72\Field0, (entitypitch(local10\Field1\Field25[$07], $01) + (Float rand($0A, $14))), (entityyaw(local10\Field1\Field25[$07], $01) + 30.0), entityroll(local72\Field0, $00), $00)
                                moveentity(local72\Field0, 0.0, 0.05, 0.2)
                                rotateentity(local72\Field0, entitypitch(local10\Field1\Field25[$07], $01), entityyaw(local10\Field1\Field25[$07], $01), entityroll(local72\Field0, $00), $00)
                                entityparent(local72\Field0, local10\Field1\Field25[$07], $01)
                                local72\Field9 = 90000.0
                                local72\Field5 = 0.01
                                local72\Field4 = 0.005
                                local72\Field2 = 0.05
                                local72\Field1 = 0.002
                            ElseIf (3200.0 < local10\Field4) Then
                                If (1.0 = local10\Field3) Then
                                    contained106 = $01
                                Else
                                    positionentity(curr106\Field4, entityx(local10\Field1\Field25[$06], $01), entityy(local10\Field1\Field25[$06], $01), entityz(local10\Field1\Field25[$06], $01), $00)
                                    contained106 = $00
                                    showentity(curr106\Field0)
                                    curr106\Field24 = 0.0
                                    curr106\Field9 = -11.0
                                    local10\Field2 = 2.0
                                    Exit
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If ((Int local10\Field3) <> 0) Then
                        positionentity(local10\Field1\Field25[$06], entityx(local10\Field1\Field25[$06], $01), curvevalue(((-980.0 * roomscale) + (sin(((Float millisecs2()) * 0.04)) * 0.07)), entityy(local10\Field1\Field25[$06], $01), 200.0), entityz(local10\Field1\Field25[$06], $01), $01)
                        rotateentity(local10\Field1\Field25[$06], sin(((Float millisecs2()) * 0.03)), entityyaw(local10\Field1\Field25[$06], $01), (- sin(((Float millisecs2()) * 0.025))), $01)
                    Else
                        positionentity(local10\Field1\Field25[$06], entityx(local10\Field1\Field25[$06], $01), curvevalue((-1280.0 * roomscale), entityy(local10\Field1\Field25[$06], $01), 200.0), entityz(local10\Field1\Field25[$06], $01), $01)
                        rotateentity(local10\Field1\Field25[$06], 0.0, entityyaw(local10\Field1\Field25[$06], $01), 0.0, $01)
                    EndIf
                ElseIf (((playerroom\Field7\Field11 = "pocketdimension") Or (playerroom\Field7\Field11 = "dimension1499")) <> 0) Then
                    If (local10\Field6 <> $00) Then
                        If (channelplaying(local10\Field6) <> 0) Then
                            stopchannel(local10\Field6)
                        EndIf
                    EndIf
                    If (local10\Field5 <> $00) Then
                        If (channelplaying(local10\Field5) <> 0) Then
                            stopchannel(local10\Field5)
                        EndIf
                    EndIf
                ElseIf (playerroom\Field7\Field11 = "room860") Then
                    For local11 = Each events
                        If (local11\Field22 = $39) Then
                            If (1.0 = local11\Field2) Then
                                If (local10\Field6 <> $00) Then
                                    If (channelplaying(local10\Field6) <> 0) Then
                                        stopchannel(local10\Field6)
                                    EndIf
                                EndIf
                                If (local10\Field5 <> $00) Then
                                    If (channelplaying(local10\Field5) <> 0) Then
                                        stopchannel(local10\Field5)
                                    EndIf
                                EndIf
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
            Case $38
                If (playerinroom(local10) <> 0) Then
                    If (((0.0 = local10\Field2) Or (local10\Field1\Field25[$00] = $00)) <> 0) Then
                        If (((local10\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field11 = "load0"
                        EndIf
                        If (local10\Field1\Field25[$03] <> $00) Then
                            hideentity(local10\Field1\Field25[$03])
                            hideentity(local10\Field1\Field25[$04])
                            hideentity(local10\Field1\Field25[$05])
                            hideentity(local10\Field1\Field25[$06])
                        EndIf
                        If (local10\Field1\Field29[$01]\Field5 = $01) Then
                            local10\Field2 = 1.0
                            giveachievement($09, $01)
                        EndIf
                    Else
                        If (playerroom = local10\Field1) Then
                            shouldplay = $10
                        EndIf
                        If (65.0 > local10\Field2) Then
                            If (2.0 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01))) Then
                                playsound_strict(loadtempsound("SFX\SCP\205\Enter.ogg"))
                                local10\Field2 = max(local10\Field2, 65.0)
                                showentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$06])
                                setanimtime(local10\Field1\Field25[$03], 492.0, $00)
                                setanimtime(local10\Field1\Field25[$04], 434.0, $00)
                                setanimtime(local10\Field1\Field25[$05], 434.0, $00)
                                local10\Field1\Field29[$00]\Field5 = $00
                            EndIf
                            If (7.0 < local10\Field2) Then
                                If (rand($00, $12C) = $01) Then
                                    local10\Field1\Field29[$00]\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                EndIf
                            EndIf
                            local10\Field3 = (local10\Field3 + fpsfactor)
                        EndIf
                        Select local10\Field2
                            Case 1.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $20E, $212, 0.2, $01)
                                If (1400.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 3.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $179, $20D, 0.2, $01)
                                If (2100.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 5.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $E4, $178, 0.2, $01)
                                If (2800.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound2(loadtempsound("SFX\SCP\205\Horror.ogg"), camera, local10\Field1\Field25[$06], 10.0, 0.3)
                                EndIf
                            Case 7.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$05])
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $1F4, $288, 0.2, $01)
                                If (4200.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound2(loadtempsound("SFX\SCP\205\Horror.ogg"), camera, local10\Field1\Field25[$06], 10.0, 0.5)
                                EndIf
                            Case 9.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$04])
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $02, $C8, 0.2, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $04, $7D, 0.2, $01)
                                If (5600.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound_strict(loadtempsound("SFX\SCP\205\Horror.ogg"))
                                EndIf
                            Case 11.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$03])
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $02, $E2, 0.2, $01)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $02, $C8, 0.2, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $04, $7D, 0.2, $01)
                                If (5950.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 13.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$03])
                                If (227.0 <> animtime(local10\Field1\Field25[$06])) Then
                                    setanimtime(local10\Field1\Field25[$06], 227.0, $00)
                                EndIf
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $02, $1EB, 0.05, $01)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $C5, $1B1, 0.05, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $02, $1B1, 0.05, $01)
                            Case 66.0
                                showentity(local10\Field1\Field25[$01])
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $1EC, $216, 0.1, $00)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $1B2, $1D2, 0.1, $00)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $1B2, $1EE, 0.1, $00)
                                If (515.0 < animtime(local10\Field1\Field25[$03])) Then
                                    If (533.0 < animtime(local10\Field1\Field25[$03])) Then
                                        local10\Field2 = 67.0
                                        local10\Field3 = 0.0
                                        local10\Field4 = 0.0
                                        hideentity(local10\Field1\Field25[$01])
                                    EndIf
                                EndIf
                            Case 67.0
                                If (((rand($96, $01) = $01) And ((2.0 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01))) And (local10\Field13 = collider))) <> 0) Then
                                    deathmsg = "The SCP-205 cycle seems to have resumed its normal course after the anomalies observed during "
                                    deathmsg = (deathmsg + "[REDACTED]. The body of subject D-9341 was discovered inside the chamber. ")
                                    deathmsg = (deathmsg + "The subject exhibits signs of blunt force trauma typical for personnel who have ")
                                    deathmsg = (deathmsg + "entered the chamber when the lights are off.")
                                    injuries = (rnd(0.4, 0.8) + injuries)
                                    playsound_strict(damagesfx(rand($02, $03)))
                                    multiplayer_writesound(damagesfx(rand($02, $03)), 0.0, 0.0, 0.0, 10.0, 1.0)
                                    camerashake = 0.5
                                    local10\Field3 = rnd(-0.1, 0.1)
                                    local10\Field4 = rnd(-0.1, 0.1)
                                    If (5.0 < injuries) Then
                                        kill("was killed by SCP-205", $00)
                                    EndIf
                                EndIf
                                translateentity(local10\Field13, local10\Field3, 0.0, local10\Field4, $00)
                                local10\Field3 = curvevalue(local10\Field3, 0.0, 10.0)
                                local10\Field4 = curvevalue(local10\Field4, 0.0, 10.0)
                            Default
                                If (rand($03, $01) = $01) Then
                                    hideentity(local10\Field1\Field25[$01])
                                Else
                                    showentity(local10\Field1\Field25[$01])
                                EndIf
                                local10\Field4 = (local10\Field4 + fpsfactor)
                                If (50.0 < local10\Field4) Then
                                    showentity(local10\Field1\Field25[$01])
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    local10\Field4 = 0.0
                                EndIf
                        End Select
                    EndIf
                ElseIf (local10\Field1\Field25[$03] <> $00) Then
                    hideentity(local10\Field1\Field25[$03])
                    hideentity(local10\Field1\Field25[$04])
                    hideentity(local10\Field1\Field25[$05])
                    hideentity(local10\Field1\Field25[$06])
                Else
                    local10\Field2 = 0.0
                    local10\Field11 = ""
                EndIf
            Case $39
                local84 = local10\Field1\Field11
                If (local84 <> Null) Then
                    hideentity(local84\Field4)
                    If (networkserver\Field18 <> 0) Then
                        updateforest(local84, local10\Field13, $01)
                    EndIf
                    updateforest(local84, collider, $00)
                EndIf
                If (((playerroom = local10\Field1) And (local84 <> Null)) <> 0) Then
                    If (1.0 = local10\Field2) Then
                        currstepsfx = $02
                        curr106\Field24 = 1.0
                        If (((local10\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field11 = "load0"
                        EndIf
                        If (local10\Field1\Field32[$00] <> Null) Then
                            If ((((1.0 = local10\Field1\Field32[$00]\Field10) And (1.0 < local10\Field1\Field32[$00]\Field9)) Or (2.0 < local10\Field1\Field32[$00]\Field9)) <> 0) Then
                                If (playerroom = local10\Field1) Then
                                    shouldplay = $0C
                                EndIf
                            ElseIf (playerroom = local10\Field1) Then
                                shouldplay = $09
                            EndIf
                        EndIf
                        If (noclip = $00) Then
                            If ((entityy(local84\Field4, $01) + 0.5) < entityy(collider, $00)) Then
                                moveentity(collider, 0.0, (((entityy(local84\Field4, $01) + 0.5) - entityy(collider, $00)) * fpsfactor), 0.0)
                            EndIf
                        EndIf
                        If (local10\Field1\Field32[$00] <> Null) Then
                            If (local10\Field1\Field32[$00]\Field73 <> $00) Then
                                If (((0.0 = local10\Field1\Field32[$00]\Field9) Or (20.0 < entitydistance(local10\Field1\Field32[$00]\Field73, local10\Field1\Field32[$00]\Field4))) <> 0) Then
                                    local10\Field4 = (local10\Field4 + ((1.0 + currspeed) * fpsfactor))
                                    If (((10.0 > (local10\Field4 Mod 500.0)) And (490.0 < ((local10\Field4 - fpsfactor) Mod 500.0))) <> 0) Then
                                        If ((((Float ($BB8 - (selecteddifficulty\Field3 * $1F4))) < local10\Field4) And (local10\Field4 > rnd((Float ((selecteddifficulty\Field3 * $1F4) + $2710)), 0.0))) <> 0) Then
                                            local10\Field1\Field32[$00]\Field9 = 2.0
                                            positionentity(local10\Field1\Field32[$00]\Field4, 0.0, -110.0, 0.0, $00)
                                            local10\Field4 = (local10\Field4 - rnd(1000.0, (Float ($7D0 - (selecteddifficulty\Field3 * $1F4)))))
                                            debuglog("attack")
                                        Else
                                            local10\Field1\Field32[$00]\Field9 = 1.0
                                            positionentity(local10\Field1\Field32[$00]\Field4, 0.0, -110.0, 0.0, $00)
                                            debuglog("spawn")
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        For local1 = $00 To $01 Step $01
                            If (0.5 > entitydistance(local84\Field5[local1], collider)) Then
                                If (entityinview(local84\Field5[local1], camera) <> 0) Then
                                    drawhandicon = $01
                                    If (mousehit1 <> 0) Then
                                        If ((Float local1) = local10\Field3) Then
                                            blinktimer = -10.0
                                            playsound_strict(loadtempsound("SFX\Door\WoodenDoorOpen.ogg"))
                                            rotateentity(local10\Field1\Field25[$03], 0.0, 0.0, 0.0, $00)
                                            rotateentity(local10\Field1\Field25[$04], 0.0, 180.0, 0.0, $00)
                                            positionentity(collider, entityx(local10\Field1\Field25[$02], $01), 0.5, entityz(local10\Field1\Field25[$02], $01), $00)
                                            rotateentity(collider, 0.0, (entityyaw(local10\Field1\Field2, $01) + (local10\Field3 * 180.0)), 0.0, $00)
                                            moveentity(collider, 0.0, 0.0, 1.5)
                                            resetentity(collider)
                                            updatedoorstimer = 0.0
                                            updatedoors()
                                            secondarylighton = prevsecondarylighton
                                            local10\Field2 = 0.0
                                            local10\Field4 = 0.0
                                        Else
                                            playsound_strict(loadtempsound("SFX\Door\WoodenDoorBudge.ogg"))
                                            multiplayer_writetempsound("SFX\Door\WoodenDoorBudge.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                            msg = "The door will not budge."
                                            msgtimer = 350.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        local18 = 2.0
                        If (debughud = $00) Then
                            cameraclscolor(camera, min(98.0, 255.0), min(133.0, 255.0), min(162.0, 255.0))
                            camerarange(camera, roomscale, 8.5)
                            camerafogrange(camera, 0.5, 8.0)
                            camerafogcolor(camera, min(98.0, 255.0), min(133.0, 255.0), min(162.0, 255.0))
                        EndIf
                        If (28.5 >= entityy(collider, $00)) Then
                            rotateentity(local10\Field1\Field25[$03], 0.0, 0.0, 0.0, $00)
                            rotateentity(local10\Field1\Field25[$04], 0.0, 180.0, 0.0, $00)
                            local10\Field2 = 0.0
                            local10\Field4 = 0.0
                        EndIf
                    Else
                        If (contained106 = $00) Then
                            curr106\Field24 = 0.0
                        EndIf
                        If (0.0 = entityyaw(local10\Field1\Field25[$03], $00)) Then
                            hideentity(local84\Field4)
                            If (1.0 > (Abs distance(entityx(local10\Field1\Field25[$03], $01), entityz(local10\Field1\Field25[$03], $01), entityx(collider, $01), entityz(collider, $01)))) Then
                                drawhandicon = $01
                                If (mousehit1 <> 0) Then
                                    playsound_strict(loadtempsound("SFX\Door\WoodenDoorOpen.ogg"))
                                    multiplayer_writetempsound("SFX\Door\WoodenDoorOpen.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                    showentity(local84\Field4)
                                    selecteditem = Null
                                    blinktimer = -10.0
                                    local10\Field2 = 1.0
                                    local10\Field4 = 0.0
                                    If (local10\Field1\Field32[$00] <> Null) Then
                                        local10\Field1\Field32[$00]\Field9 = 0.0
                                    EndIf
                                    prevsecondarylighton = secondarylighton
                                    secondarylighton = 1.0
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local3, local10\Field1\Field2, 0.0)
                                    local85 = wrapangle((entityyaw(local3, $00) - entityyaw(local10\Field1\Field2, $01)))
                                    If (((90.0 < local85) And (270.0 > local85)) <> 0) Then
                                        positionentity(collider, entityx(local84\Field5[$00], $01), ((entityy(local84\Field5[$00], $01) + entityy(collider, $01)) + 0.5), entityz(local84\Field5[$00], $01), $01)
                                        rotateentity(collider, 0.0, (entityyaw(local84\Field5[$00], $01) - 180.0), 0.0, $01)
                                        moveentity(collider, -0.5, 0.0, 0.5)
                                        local10\Field3 = 1.0
                                    Else
                                        positionentity(collider, entityx(local84\Field5[$01], $01), ((entityy(local84\Field5[$01], $01) + entityy(collider, $01)) + 0.5), entityz(local84\Field5[$01], $01), $01)
                                        rotateentity(collider, 0.0, (entityyaw(local84\Field5[$01], $01) - 180.0), 0.0, $01)
                                        moveentity(collider, -0.5, 0.0, 0.5)
                                        local10\Field3 = 0.0
                                    EndIf
                                    freeentity(local3)
                                    resetentity(collider)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                ElseIf (local84 <> Null) Then
                    If (((local84\Field4 <> $00) And (playerinroom(local10) = $00)) <> 0) Then
                        hideentity(local84\Field4)
                    EndIf
                    If (((playerroom\Field7\Field11 <> "dimension1499") And (playerroom\Field7\Field11 <> "pocketdimension")) <> 0) Then
                        If (1.0 = local10\Field2) Then
                            rotateentity(local10\Field1\Field25[$03], 0.0, 0.0, 0.0, $00)
                            rotateentity(local10\Field1\Field25[$04], 0.0, 180.0, 0.0, $00)
                            local10\Field2 = 0.0
                            local10\Field4 = 0.0
                        EndIf
                    EndIf
                EndIf
            Case $3A
                If (playerinroom(local10) <> 0) Then
                    Select local10\Field2
                        Case 0.0
                            If (quickloadpercent = $FFFFFFFF) Then
                                local10\Field2 = 1.0
                                quickloadpercent = $00
                                quickload_currevent = local10
                            EndIf
                        Case 2.0
                            local10\Field2 = 2.0
                            removeevent(local10)
                    End Select
                EndIf
            Case $32
                If (local10 <> Null) Then
                    If (playerinroom(local10) <> 0) Then
                        If (0.0 = local10\Field2) Then
                            local10\Field1\Field25[$07] = loadanimmesh_strict("GFX\npcs\scp-1048.b3d", $00)
                            scaleentity(local10\Field1\Field25[$07], 0.05, 0.05, 0.05, $00)
                            tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field2)
                            If (0.0 = tformedz()) Then
                                local2 = $FFFFFFFF
                            Else
                                local2 = (Int (- (Sgn tformedz())))
                            EndIf
                            tformpoint(-720.0, 0.0, (Float ($330 * local2)), local10\Field1\Field2, $00)
                            positionentity(local10\Field1\Field25[$07], tformedx(), 0.0, tformedz(), $00)
                            rotateentity(local10\Field1\Field25[$07], -90.0, (Float (local10\Field1\Field6 - $5A)), 0.0, $00)
                            setanimtime(local10\Field1\Field25[$07], 297.0, $00)
                            local10\Field2 = 1.0
                        EndIf
                        If (((2.5 > entitydistance(local10\Field13, local10\Field1\Field25[$06])) And (0.0 < local10\Field2)) <> 0) Then
                            playsound_strict(loadtempsound("SFX\SCP\079\TestroomWarning.ogg"))
                            For local1 = $00 To $05 Step $01
                                local14 = createemitter(entityx(local10\Field1\Field25[local1], $01), entityy(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01), $00, 0.0)
                                turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                                local14\Field10 = 5.0
                                local14\Field9 = 0.042
                                local14\Field11 = (1.0 / 400.0)
                                initroomforemitter(local14)
                            Next
                            local10\Field2 = (local10\Field2 * -1.0)
                        EndIf
                        If (local10\Field1\Field25[$07] <> $00) Then
                            animate2(local10\Field1\Field25[$07], animtime(local10\Field1\Field25[$07]), $11C, $127, 0.3, $01)
                            moveentity(local10\Field1\Field25[$07], 0.0, (-0.008 * fpsfactor), 0.0)
                            tformpoint(entityx(local10\Field1\Field25[$07], $00), entityy(local10\Field1\Field25[$07], $00), entityz(local10\Field1\Field25[$07], $00), $00, local10\Field1\Field2)
                            If (725.0 < (Abs tformedx())) Then
                                freeentity(local10\Field1\Field25[$07])
                                local10\Field1\Field25[$07] = $00
                                local10\Field2 = (local10\Field2 * 2.0)
                            EndIf
                        EndIf
                        If (-2.0 = local10\Field2) Then
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $0F
                If (playerinroom(local10) <> 0) Then
                    If (3.5 > local10\Field20) Then
                        playsound2(burstsfx, camera, local10\Field1\Field2, 10.0, 1.0)
                        For local1 = $00 To $01 Step $01
                            local14 = createemitter(entityx(local10\Field1\Field25[local1], $01), entityy(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01), $00, 0.0)
                            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                            entityparent(local14\Field0, local10\Field1\Field2, $01)
                            local14\Field1 = 0.05
                            local14\Field10 = 10.0
                            local14\Field9 = 0.06
                            local14\Field11 = 0.007
                            initroomforemitter(local14)
                            For local20 = 0.0 To ceil((3.3333 * (Float (particleamount + $01)))) Step 1.0
                                local7 = createparticle(entityx(local14\Field0, $01), (448.0 * roomscale), entityz(local14\Field0, $01), rand(local14\Field2, local14\Field3), local14\Field1, local14\Field4, local14\Field5)
                                local7\Field9 = local14\Field9
                                rotateentity(local7\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                local7\Field7 = 0.05
                                local7\Field16 = 0.008
                            Next
                        Next
                        removeevent(local10)
                    EndIf
                EndIf
            Case $10
                If (playerinroom(local10) <> 0) Then
                    If (1.0 < curr173\Field24) Then
                        removeevent(local10)
                        Exit
                    ElseIf (0.0 = local10\Field2) Then
                        If (3.5 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))) Then
                            playsound_strict(lightsfx)
                            lightblink = (rnd(0.0, 1.0) * (local10\Field2 / 200.0))
                            local10\Field2 = 1.0
                        EndIf
                    EndIf
                EndIf
                If (((0.0 < local10\Field2) And (200.0 > local10\Field2)) <> 0) Then
                    blinktimer = -10.0
                    If (30.0 < local10\Field2) Then
                        lightblink = 1.0
                        If (30.0 >= (local10\Field2 - fpsfactor)) Then
                            playsound_strict(loadtempsound("SFX\ambient\general\ambient3.ogg"))
                        EndIf
                    EndIf
                    If (((100.0 >= (local10\Field2 - fpsfactor)) And (100.0 < local10\Field2)) <> 0) Then
                        playsound_strict(loadtempsound("SFX\ambient\general\ambient6.ogg"))
                        positionentity(curr173\Field4, entityx(local10\Field1\Field2, $00), 0.6, entityz(local10\Field1\Field2, $00), $00)
                        resetentity(curr173\Field4)
                        curr173\Field24 = 1.0
                    EndIf
                    lightblink = 1.0
                    local10\Field2 = (local10\Field2 + fpsfactor)
                ElseIf (0.0 <> local10\Field2) Then
                    blinktimer = blinkfreq
                    curr173\Field24 = 0.0
                    removeevent(local10)
                EndIf
            Case $03
                If (0.0 = local10\Field2) Then
                    If (((5.0 > local10\Field20) And (0.0 < local10\Field20)) <> 0) Then
                        If (0.0 <= curr106\Field9) Then
                            local10\Field2 = 1.0
                        ElseIf ((((-10.0 >= curr106\Field9) And (5.0 < entitydistance(curr106\Field4, local10\Field13))) And (entityinview(curr106\Field0, getplayercamera(local10\Field14)) = $00)) <> 0) Then
                            local10\Field2 = 1.0
                            local10\Field3 = 1.0
                        EndIf
                    ElseIf (contained106 <> 0) Then
                        removeevent(local10)
                    EndIf
                ElseIf (1.0 = local10\Field2) Then
                    If (((3.0 > local10\Field20) Or (rand($1B58, $01) = $01)) <> 0) Then
                        local10\Field2 = 2.0
                        local72 = createdecal($00, entityx(local10\Field1\Field2, $00), (445.0 * roomscale), entityz(local10\Field1\Field2, $00), -90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                        local72\Field2 = rnd(0.5, 0.7)
                        entityalpha(local72\Field0, 0.7)
                        local72\Field8 = $01
                        scalesprite(local72\Field0, local72\Field2, local72\Field2)
                        entityalpha(local72\Field0, rnd(0.7, 0.85))
                        playsound_strict(horrorsfx($0A))
                    ElseIf (8.0 < local10\Field20) Then
                        If (rand($05, $01) = $01) Then
                            curr106\Field24 = 0.0
                            removeevent(local10)
                        Else
                            curr106\Field24 = 0.0
                            curr106\Field9 = -10000.0
                            removeevent(local10)
                        EndIf
                    EndIf
                Else
                    If (1.0 = local10\Field3) Then
                        shouldplay = $0A
                    EndIf
                    local10\Field2 = (local10\Field2 + fpsfactor)
                    If (180.0 >= local10\Field2) Then
                        positionentity(curr106\Field4, entityx(local10\Field1\Field2, $01), ((entityy(local10\Field13, $00) + 1.0) - min((sin(local10\Field2) * 1.5), 1.1)), entityz(local10\Field1\Field2, $01), $01)
                        pointentity(curr106\Field4, camera, 0.0)
                        animatenpc(curr106, 55.0, 104.0, 0.1, $01)
                        curr106\Field24 = 1.0
                        curr106\Field9 = 1.0
                        resetentity(curr106\Field4)
                        curr106\Field7 = 0.0
                        positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                        rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                        showentity(curr106\Field0)
                    ElseIf (((180.0 < local10\Field2) And (300.0 > local10\Field2)) <> 0) Then
                        curr106\Field24 = 0.0
                        curr106\Field9 = -10.0
                        positionentity(curr106\Field4, entityx(local10\Field1\Field2, $01), -3.0, entityz(local10\Field1\Field2, $01), $01)
                        curr106\Field38 = 700.0
                        curr106\Field37 = $00
                        curr106\Field39 = $00
                        local32 = createdecal($00, entityx(local10\Field1\Field2, $01), 0.01, entityz(local10\Field1\Field2, $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                        local32\Field2 = 0.05
                        local32\Field1 = 0.01
                        entityalpha(local32\Field0, 0.8)
                        updatedecals()
                        local10\Field2 = 300.0
                    ElseIf (800.0 > local10\Field2) Then
                        If ((entityy(local10\Field13, $00) - 0.05) <= entityy(curr106\Field4, $00)) Then
                            removeevent(local10)
                        Else
                            translateentity(curr106\Field4, 0.0, (((entityy(local10\Field13, $01) - 0.11) - entityy(curr106\Field4, $00)) / 50.0), 0.0, $00)
                            If (-0.1 > entityy(curr106\Field4, $00)) Then
                                curr106\Field22 = 0.0
                            EndIf
                        EndIf
                    Else
                        removeevent(local10)
                    EndIf
                EndIf
            Case $1D
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = curr173\Field24) Then
                        If (0.0 = local10\Field2) Then
                            If (local10\Field1\Field29[$00]\Field5 = $01) Then
                                positionentity(curr173\Field4, entityx(local10\Field1\Field25[$00], $01), 0.5, entityz(local10\Field1\Field25[$00], $01), $00)
                                resetentity(curr173\Field4)
                                local10\Field2 = 1.0
                            EndIf
                        Else
                            If (local10\Field1\Field25[$02] = $00) Then
                                local87 = loadtexture_strict("GFX\map\glass.png", $03)
                                local10\Field1\Field25[$02] = createsprite($00)
                                entitytexture(local10\Field1\Field25[$02], local87, $00, $00)
                                spriteviewmode(local10\Field1\Field25[$02], $02)
                                scalesprite(local10\Field1\Field25[$02], ((182.0 * roomscale) * 0.5), ((192.0 * roomscale) * 0.5))
                                local3 = createpivot(local10\Field1\Field2)
                                positionentity(local3, -632.0, 224.0, -208.0, $00)
                                positionentity(local10\Field1\Field25[$02], entityx(local3, $01), entityy(local3, $01), entityz(local3, $01), $00)
                                freeentity(local3)
                                rotateentity(local10\Field1\Field25[$02], 0.0, (Float local10\Field1\Field6), 0.0, $00)
                                turnentity(local10\Field1\Field25[$02], 0.0, 180.0, 0.0, $00)
                                entityparent(local10\Field1\Field25[$02], local10\Field1\Field2, $01)
                                freetexture(local87)
                            EndIf
                            showentity(local10\Field1\Field25[$02])
                            local10\Field2 = (local10\Field2 + 1.0)
                            local0 = entitydistance(local10\Field13, local10\Field1\Field25[$01])
                            If (1.0 > local0) Then
                                local10\Field2 = max(local10\Field2, 840.0)
                            ElseIf (1.4 < local0) Then
                                If (((840.0 < local10\Field2) And (-10.0 >= blinktimer)) <> 0) Then
                                    If (5.0 < entitydistance(curr173\Field4, local10\Field1\Field25[$00])) Then
                                        removeevent(local10)
                                    Else
                                        playsound2(loadtempsound("SFX\General\GlassBreak.ogg"), camera, curr173\Field0, 10.0, 1.0)
                                        freeentity(local10\Field1\Field25[$02])
                                        local10\Field1\Field25[$02] = $00
                                        positionentity(curr173\Field4, entityx(local10\Field1\Field25[$01], $01), 0.5, entityz(local10\Field1\Field25[$01], $01), $00)
                                        resetentity(curr173\Field4)
                                        removeevent(local10)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $2F
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    If (((8.0 > local10\Field20) And (0.0 < local10\Field20)) <> 0) Then
                        local10\Field2 = 1.0
                    EndIf
                ElseIf (1.0 = local10\Field2) Then
                    local10\Field1\Field32[$00] = createnpc($03, entityx(local10\Field1\Field25[$01], $01), (entityy(local10\Field1\Field25[$01], $01) + 0.5), entityz(local10\Field1\Field25[$01], $01))
                    pointentity(local10\Field1\Field32[$00]\Field4, local10\Field1\Field2, 0.0)
                    rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, (entityyaw(local10\Field1\Field32[$00]\Field4, $00) - 20.0), 0.0, $01)
                    setnpcframe(local10\Field1\Field32[$00], 287.0)
                    local10\Field1\Field32[$00]\Field9 = 8.0
                    local10\Field2 = 2.0
                Else
                    If (local10\Field7 = $00) Then
                        local10\Field7 = loadsound_strict("SFX\Character\Guard\SuicideGuard1.ogg")
                    EndIf
                    If (((15.0 > local10\Field20) And (4.0 <= local10\Field20)) <> 0) Then
                        local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field32[$00]\Field4, 15.0, 1.0)
                    ElseIf (((4.0 > local10\Field20) And (1.0 < playersoundvolume)) <> 0) Then
                        If (0.0 = local10\Field3) Then
                            local32 = createdecal($03, entityx(local10\Field1\Field25[$02], $01), entityy(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01), 0.0, (Float (local10\Field1\Field6 + $10E)), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.3
                            scalesprite(local32\Field0, local32\Field2, local32\Field2)
                            local10\Field3 = 1.0
                        EndIf
                        If (local10\Field6 = $00) Then
                            stopchannel(local10\Field5)
                            freesound_strict(local10\Field7)
                            local10\Field1\Field32[$00]\Field16 = loadsound_strict("SFX\Character\Guard\SuicideGuard2.ogg")
                            local10\Field6 = playsound2(local10\Field1\Field32[$00]\Field16, camera, local10\Field1\Field32[$00]\Field4, 15.0, 1.0)
                        EndIf
                        updatesoundorigin(local10\Field6, camera, local10\Field1\Field32[$00]\Field4, 15.0, 1.0)
                        If (channelplaying(local10\Field6) = $00) Then
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $2A
                If (playerinroom(local10) <> 0) Then
                    giveachievement($00, $01)
                    If (0.0 = local10\Field2) Then
                        If (((2.0 > curr173\Field24) And (hidedistance < entitydistance(curr173\Field4, local10\Field13))) <> 0) Then
                            positionentity(curr173\Field4, entityx(local10\Field1\Field25[$03], $01), 0.5, entityz(local10\Field1\Field25[$03], $01), $01)
                            resetentity(curr173\Field4)
                        EndIf
                        local10\Field2 = 1.0
                    ElseIf (1.0 = local10\Field2) Then
                        local10\Field5 = loopsound2(alarmsfx($00), local10\Field5, camera, local10\Field1\Field25[$00], 5.0, 1.0)
                        If ((millisecs2() Mod $3E8) < $1F4) Then
                            showentity(local10\Field1\Field25[$05])
                        Else
                            hideentity(local10\Field1\Field25[$05])
                        EndIf
                        local0 = entitydistance(local10\Field13, local10\Field1\Field25[$00])
                        If (2.0 > local0) Then
                            local10\Field1\Field29[$00]\Field4 = $01
                            local10\Field1\Field29[$01]\Field4 = $01
                            If (0.0 = local10\Field3) Then
                                showentity(local10\Field1\Field25[$02])
                                If (3.0 > entitydistance(curr173\Field4, local10\Field1\Field25[$04])) Then
                                    If ((((-10.0 > player[local10\Field14]\Field31) Or (entityinview(curr173\Field0, getplayercamera(local10\Field14)) = $00)) And (0.0 = curr173\Field24)) <> 0) Then
                                        positionentity(curr173\Field4, entityx(local10\Field1\Field25[$04], $01), 0.5, entityz(local10\Field1\Field25[$04], $01), $01)
                                        resetentity(curr173\Field4)
                                        hideentity(local10\Field1\Field25[$02])
                                        If (((wearinghazmat = $00) And (2.0 > entitydistance(collider, local10\Field1\Field25[$00]))) <> 0) Then
                                            injuries = (injuries + 0.1)
                                            If (0.0 = infect) Then
                                                infect = 1.0
                                            EndIf
                                            msg = "The window shattered and a piece of glass cut your arm."
                                            msgtimer = 560.0
                                        EndIf
                                        playsound2(loadtempsound("SFX\General\GlassBreak.ogg"), camera, local10\Field1\Field25[$00], 10.0, 1.0)
                                        local10\Field3 = 1.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        local0 = entitydistance(collider, local10\Field1\Field25[$00])
                        If (2.0 > local0) Then
                            If (((wearinghazmat = $00) And (0.0 < bloodloss)) <> 0) Then
                                If (0.0 = infect) Then
                                    infect = 1.0
                                    debuglog("Infected player")
                                EndIf
                            EndIf
                            If (1.0 > local0) Then
                                If (entityinview(local10\Field1\Field25[$00], camera) <> 0) Then
                                    drawhandicon = $01
                                    If (mousedown1 <> 0) Then
                                        grabbedentity = local10\Field1\Field28[$00]
                                        drawarrowicon($02) = $01
                                        rotateentity(local10\Field1\Field28[$00], max(min((entitypitch(local10\Field1\Field28[$00], $00) + max(min((- mouse_y_speed_1), 10.0), -10.0)), 89.0), 35.0), entityyaw(local10\Field1\Field28[$00], $00), 0.0, $00)
                                    Else
                                        grabbedentity = $00
                                    EndIf
                                ElseIf (grabbedentity = local10\Field1\Field28[$00]) Then
                                    grabbedentity = $00
                                EndIf
                            ElseIf (grabbedentity = local10\Field1\Field28[$00]) Then
                                grabbedentity = $00
                            EndIf
                        EndIf
                        If (40.0 > entitypitch(local10\Field1\Field28[$00], $01)) Then
                            local10\Field2 = 2.0
                            playsound_strict(leversfx)
                        Else
                            local7 = createparticle(entityx(local10\Field1\Field25[$00], $01), entityy(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01), $06, 0.02, -0.12, $C8)
                            rotateentity(local7\Field1, -90.0, 0.0, 0.0, $01)
                            turnentity(local7\Field1, rnd(-26.0, 26.0), rnd(-26.0, 26.0), rnd(360.0, 0.0), $00)
                            local7\Field16 = 0.012
                            local7\Field15 = -0.015
                        EndIf
                    Else
                        hideentity(local10\Field1\Field25[$05])
                        local10\Field1\Field29[$00]\Field4 = $00
                        local10\Field1\Field29[$01]\Field4 = $00
                        local10\Field1\Field29[$02]\Field4 = $00
                        rotateentity(local10\Field1\Field28[$00], curveangle(1.0, entitypitch(local10\Field1\Field28[$00], $01), 15.0), entityyaw(local10\Field1\Field28[$00], $01), 0.0, $01)
                        If (1.0 >= entitypitch(local10\Field1\Field28[$00], $01)) Then
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $24
                local10\Field24 = $00
                If (contained106 = $00) Then
                    If (playerinroom(local10) <> 0) Then
                        If (0.0 = local10\Field2) Then
                            local32 = createdecal($00, entityx(local10\Field1\Field2, $00), (799.0 * roomscale), entityz(local10\Field1\Field2, $00), -90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.05
                            local32\Field1 = 0.0015
                            entityalpha(local32\Field0, 0.8)
                            updatedecals()
                            playsound2(decaysfx($03), camera, local32\Field0, 15.0, 1.0)
                            local10\Field2 = 1.0
                        EndIf
                    EndIf
                    If (0.0 < local10\Field2) Then
                        If (local10\Field1\Field32[$00] = Null) Then
                            local10\Field2 = (local10\Field2 + fpsfactor)
                        EndIf
                        If (200.0 < local10\Field2) Then
                            If (local10\Field1\Field32[$00] = Null) Then
                                local10\Field1\Field32[$00] = createnpc($04, entityx(local10\Field1\Field2, $00), (900.0 * roomscale), entityz(local10\Field1\Field2, $00))
                                rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                changenpctextureid(local10\Field1\Field32[$00], $05)
                                local10\Field1\Field32[$00]\Field9 = 6.0
                                playsound_strict(horrorsfx($00))
                                playsound2(decaysfx($02), camera, local10\Field1\Field32[$00]\Field4, 15.0, 1.0)
                            EndIf
                            local10\Field1\Field32[$00]\Field72 = 0.0
                            entitytype(local10\Field1\Field32[$00]\Field4, $02, $00)
                            If (0.35 < entityy(local10\Field1\Field32[$00]\Field4, $00)) Then
                                animatenpc(local10\Field1\Field32[$00], 1.0, 10.0, 0.12, $00)
                                local0 = entitydistance(local10\Field13, local10\Field1\Field32[$00]\Field4)
                                If (0.8 > local0) Then
                                    local33 = point_direction(entityx(local10\Field13, $01), entityz(local10\Field13, $01), entityx(local10\Field1\Field32[$00]\Field4, $01), entityz(local10\Field1\Field32[$00]\Field4, $01))
                                    translateentity(local10\Field13, ((cos(((- local33) + 90.0)) * (local0 - 0.8)) * (local0 - 0.8)), 0.0, ((sin(((- local33) + 90.0)) * (local0 - 0.8)) * (local0 - 0.8)), $00)
                                EndIf
                                If (0.6 < entityy(local10\Field1\Field32[$00]\Field4, $00)) Then
                                    entitytype(local10\Field1\Field32[$00]\Field4, $00, $00)
                                EndIf
                            Else
                                local10\Field2 = (local10\Field2 + fpsfactor)
                                animatenpc(local10\Field1\Field32[$00], 11.0, 19.0, 0.25, $00)
                                If (local10\Field7 = $00) Then
                                    loadeventsound(local10, "SFX\General\BodyFall.ogg", $00)
                                    playsound_strict(local10\Field7)
                                    local32 = createdecal($00, entityx(local10\Field1\Field2, $00), 0.001, entityz(local10\Field1\Field2, $00), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                    local32\Field2 = 0.4
                                    entityalpha(local32\Field0, 0.8)
                                    updatedecals()
                                EndIf
                                If (400.0 < local10\Field2) Then
                                    If (local10\Field7 <> $00) Then
                                        freesound_strict(local10\Field7)
                                        local10\Field7 = $00
                                    EndIf
                                    removeevent(local10)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $25
                If (((0.0 = local10\Field2) Or ((local10\Field25 = Null) And (removedecals = $00))) <> 0) Then
                    local32 = createdecal($00, (entityx(local10\Field1\Field2, $00) + rnd(-0.5, 0.5)), 0.01, (entityz(local10\Field1\Field2, $00) + rnd(-0.5, 0.5)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                    local32\Field2 = 2.5
                    scalesprite(local32\Field0, local32\Field2, local32\Field2)
                    local10\Field25 = local32
                    local10\Field2 = 1.0
                ElseIf (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    local10\Field20 = calculatedist(local10\Field13, local10\Field1)
                    If (local10\Field7 = $00) Then
                        local10\Field7 = loadsound_strict("SFX\Room\Sinkhole.ogg")
                    Else
                        local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field2, 4.5, 1.5)
                    EndIf
                    local0 = distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))
                    If (2.0 > local0) Then
                        currstepsfx = $01
                        currspeed = curvevalue(0.0, currspeed, max((local0 * 50.0), 1.0))
                        crouchstate = ((2.0 - local0) / 2.0)
                        If (0.5 > local0) Then
                            If (0.0 = local10\Field3) Then
                                playsound_strict(loadtempsound("SFX\Room\SinkholeFall.ogg"))
                                multiplayer_writetempsound("SFX\Room\SinkholeFall.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                            EndIf
                            currspeed = curvevalue(0.0, currspeed, max((local0 * 50.0), 1.0))
                            local18 = curvevalue(entityx(local10\Field1\Field2, $00), entityx(local10\Field13, $00), 10.0)
                            local19 = curvevalue((entityy(local10\Field1\Field2, $00) - local10\Field3), entityy(local10\Field13, $00), 25.0)
                            local20 = curvevalue(entityz(local10\Field1\Field2, $00), entityz(local10\Field13, $00), 10.0)
                            positionentity(local10\Field13, local18, local19, local20, $01)
                            dropspeed = 0.0
                            resetentity(local10\Field13)
                            local10\Field3 = min((local10\Field3 + (fpsfactor / 200.0)), 2.0)
                            lightblink = min((local10\Field3 * 5.0), 10.0)
                            blurtimer = (local10\Field3 * 500.0)
                            If (2.0 = local10\Field3) Then
                                movetopocketdimension()
                            EndIf
                        EndIf
                    EndIf
                Else
                    local10\Field3 = 0.0
                EndIf
            Case $1C
                If (0.0 = local10\Field2) Then
                    If (playerinroom(local10) <> 0) Then
                        local10\Field2 = (Float (rand($12C, $3E8) * $46))
                    EndIf
                ElseIf (((((playerroom\Field7\Field11 <> "pocketdimension") And (playerroom\Field7\Field11 <> "room860")) And (playerroom\Field7\Field11 <> "room1123")) And (playerroom\Field7\Field11 <> "dimension1499")) <> 0) Then
                    local10\Field2 = (local10\Field2 - fpsfactor)
                    If (1190.0 > local10\Field2) Then
                        If (1190.0 <= (local10\Field2 + fpsfactor)) Then
                            loadeventsound(local10, "SFX\SCP\682\Roar.ogg", $00)
                            local10\Field5 = playsound_strict(local10\Field7)
                        EndIf
                        If (980.0 < local10\Field2) Then
                            camerashake = 0.5
                        EndIf
                        If (((665.0 > local10\Field2) And (420.0 < local10\Field2)) <> 0) Then
                            camerashake = 2.0
                        EndIf
                        If (70.0 > local10\Field2) Then
                            If (local10\Field7 <> $00) Then
                                freesound_strict(local10\Field7)
                            EndIf
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $2D
                If (playerinroom(local10) <> 0) Then
                    If (local10\Field1\Field29[$02]\Field5 <> 0) Then
                        giveachievement($14, $01)
                        local10\Field3 = 1.0
                    EndIf
                    If (((1.0 = local10\Field3) And (playerroom = local10\Field1)) <> 0) Then
                        shouldplay = $16
                    EndIf
                    entitypick(camera, 1.0)
                    If (pickedentity() = local10\Field1\Field25[$00]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field25[$00]
                        EndIf
                    ElseIf (pickedentity() = local10\Field1\Field25[$01]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field25[$01]
                        EndIf
                    EndIf
                    If (0.0 = local10\Field2) Then
                        If ((mousedown1 Or mousehit1) <> 0) Then
                            If (grabbedentity <> $00) Then
                                If (grabbedentity = local10\Field1\Field25[$00]) Then
                                    If (0.0 = local10\Field2) Then
                                        drawhandicon = $01
                                        turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                        local21 = wrapangle(entityroll(local10\Field1\Field25[$00], $00))
                                        If (181.0 < local21) Then
                                            drawarrowicon($03) = $01
                                        EndIf
                                        drawarrowicon($01) = $01
                                        If (90.0 > local21) Then
                                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 361.0, $00)
                                        ElseIf (180.0 > local21) Then
                                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 180.0, $00)
                                        EndIf
                                    EndIf
                                ElseIf (grabbedentity = local10\Field1\Field25[$01]) Then
                                    If (0.0 = local10\Field2) Then
                                        drawhandicon = $01
                                        turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                        local21 = wrapangle(entityroll(local10\Field1\Field25[$01], $00))
                                        drawarrowicon($03) = $01
                                        drawarrowicon($01) = $01
                                        If (90.0 < local21) Then
                                            If (180.0 > local21) Then
                                                rotateentity(local10\Field1\Field25[$01], 0.0, 0.0, 90.0, $00)
                                            ElseIf (270.0 > local21) Then
                                                rotateentity(local10\Field1\Field25[$01], 0.0, 0.0, 270.0, $00)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Else
                            grabbedentity = $00
                        EndIf
                        local21 = wrapangle(entityroll(local10\Field1\Field25[$00], $00))
                        If (90.0 > local21) Then
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 361.0, $00)
                        ElseIf (180.0 > local21) Then
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 180.0, $00)
                        EndIf
                        If (((181.0 > local21) And (90.0 < local21)) <> 0) Then
                            For local12 = Each items
                                If (((local12\Field1 <> $00) And (local12\Field15 = $00)) <> 0) Then
                                    If (200.0 > (Abs (entityx(local12\Field1, $00) - (local10\Field1\Field3 - (712.0 * roomscale))))) Then
                                        If (104.0 > (Abs (entityy(local12\Field1, $00) - (local10\Field1\Field4 + (648.0 * roomscale))))) Then
                                            multiplayer_updateroomobjects()
                                            local10\Field2 = 1.0
                                            local10\Field5 = playsound2(machinesfx, camera, local10\Field1\Field25[$01], 10.0, 1.0)
                                            local10\Field1\Field29[$01]\Field16 = playsound2(loadtempsound("SFX\SCP\914\DoorClose.ogg"), camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local88 = ""
                    local21 = wrapangle(entityroll(local10\Field1\Field25[$01], $00))
                    If (22.5 > local21) Then
                        local21 = 0.0
                        local88 = "1:1"
                    ElseIf (67.5 > local21) Then
                        local21 = 40.0
                        local88 = "coarse"
                    ElseIf (180.0 > local21) Then
                        local21 = 90.0
                        local88 = "rough"
                    ElseIf (337.5 < local21) Then
                        local21 = -1.0
                        local88 = "1:1"
                    ElseIf (292.5 < local21) Then
                        local21 = -40.0
                        local88 = "fine"
                    Else
                        local21 = -90.0
                        local88 = "very fine"
                    EndIf
                    rotateentity(local10\Field1\Field25[$01], 0.0, 0.0, curvevalue(local21, entityroll(local10\Field1\Field25[$01], $00), 20.0), $00)
                    For local1 = $00 To $01 Step $01
                        If (grabbedentity = local10\Field1\Field25[local1]) Then
                            If (entityinview(local10\Field1\Field25[local1], camera) = $00) Then
                                grabbedentity = $00
                            ElseIf (1.0 < entitydistance(local10\Field1\Field25[local1], camera)) Then
                                grabbedentity = $00
                            EndIf
                        EndIf
                    Next
                    If (0.0 < local10\Field2) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        local10\Field1\Field29[$01]\Field5 = $00
                        If (140.0 < local10\Field2) Then
                            If (local10\Field1\Field29[$00]\Field5 = $01) Then
                                local10\Field1\Field29[$00]\Field16 = playsound2(loadtempsound("SFX\SCP\914\DoorClose.ogg"), camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                            EndIf
                            local10\Field1\Field29[$00]\Field5 = $00
                        EndIf
                        If ((170.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))) Then
                            If (((local88 = "rough") Or (local88 = "coarse")) <> 0) Then
                                If (((182.0 < local10\Field2) And (182.0 > (local10\Field2 - fpsfactor2))) <> 0) Then
                                    playsound_strict(death914sfx)
                                    multiplayer_writesound(death914sfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                                EndIf
                            EndIf
                            If (210.0 < local10\Field2) Then
                                Select local88
                                    Case "rough"
                                        blinktimer = -10.0
                                        If (local10\Field5 <> $00) Then
                                            stopchannel(local10\Field5)
                                        EndIf
                                        deathmsg = (chr($22) + "A heavily mutilated corpse found inside the output booth of SCP-914. DNA testing identified the corpse as Class D Subject D-9341. ")
                                        deathmsg = (((((((((deathmsg + "The subject had obviously been ") + chr($22)) + "refined") + chr($22)) + " by SCP-914 on the ") + chr($22)) + "Rough") + chr($22)) + " setting, but we are still confused as to how he ")
                                        deathmsg = ((deathmsg + "ended up inside the intake booth and who or what wound the key.") + chr($22))
                                    Case "coarse"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - fpsfactor2)) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                    Case "1:1"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - fpsfactor2)) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                    Case "fine","very fine"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - fpsfactor2)) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                End Select
                            EndIf
                        EndIf
                        If (420.0 < local10\Field2) Then
                            rotateentity(local10\Field1\Field25[$00], entitypitch(local10\Field1\Field25[$00], $00), entityyaw(local10\Field1\Field25[$00], $00), curveangle(0.0, entityroll(local10\Field1\Field25[$00], $00), 10.0), $00)
                        Else
                            rotateentity(local10\Field1\Field25[$00], entitypitch(local10\Field1\Field25[$00], $00), entityyaw(local10\Field1\Field25[$00], $00), 180.0, $00)
                        EndIf
                        If (840.0 < local10\Field2) Then
                            For local12 = Each items
                                If (((local12\Field1 <> $00) And (local12\Field15 = $00)) <> 0) Then
                                    If ((180.0 * roomscale) > distance(entityx(local12\Field1, $00), entityz(local12\Field1, $00), entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))) Then
                                        use914(local12, local88, entityx(local10\Field1\Field25[$03], $01), entityy(local10\Field1\Field25[$03], $01), entityz(local10\Field1\Field25[$03], $01))
                                    EndIf
                                EndIf
                            Next
                            If ((170.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))) Then
                                blurtimer = 1000.0
                                positionentity(collider, entityx(local10\Field1\Field25[$03], $01), (entityy(local10\Field1\Field25[$03], $01) + 1.0), entityz(local10\Field1\Field25[$03], $01), $00)
                                resetentity(collider)
                                multiplayer_send($01, $FFFFFFFF, $FFFFFFFF)
                                dropspeed = 0.0
                                Select local88
                                    Case "rough"
                                        kill("was killed in SCP-914", $00)
                                    Case "coarse"
                                        injuries = 4.0
                                        msg = "You notice countless small incisions all around your body. They are bleeding heavily."
                                        msgtimer = 560.0
                                    Case "1:1"
                                        invertmouse = (invertmouse = $00)
                                    Case "fine","very fine"
                                        If (multiplayer_breach_isa035(myplayer\Field51) <> 0) Then
                                            superman = $00
                                            kill("was killed in SCP-914", $00)
                                        Else
                                            superman = $01
                                        EndIf
                                End Select
                            EndIf
                            local10\Field1\Field29[$00]\Field5 = $01
                            local10\Field1\Field29[$01]\Field5 = $01
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 0.0, $00)
                            local10\Field2 = 0.0
                            local91 = loadtempsound("SFX\SCP\914\DoorOpen.ogg")
                            local10\Field1\Field29[$00]\Field16 = playsound2(local91, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                            local10\Field1\Field29[$01]\Field16 = playsound2(local91, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                        EndIf
                    EndIf
                EndIf
                updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$01], 10.0, 1.0)
            Case $06
                If (local10\Field1\Field25[$00] = $00) Then
                    If (playerinroom(local10) = $00) Then
                        local0 = distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))
                        If (16.0 > local0) Then
                            For local11 = Each events
                                If (local11\Field0 = local10\Field0) Then
                                    If (local11\Field1 <> local10\Field1) Then
                                        If (local11\Field1\Field25[$00] <> $00) Then
                                            local10\Field1\Field25[$00] = copyentity(local11\Field1\Field25[$00], $00)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local10\Field1\Field25[$00] = $00) Then
                                local10\Field1\Field25[$00] = loadanimmesh_strict("GFX\npcs\scp-1048a.b3d", $00)
                            EndIf
                            scaleentity(local10\Field1\Field25[$00], 0.05, 0.05, 0.05, $00)
                            setanimtime(local10\Field1\Field25[$00], 2.0, $00)
                            positionentity(local10\Field1\Field25[$00], entityx(local10\Field1\Field2, $00), 0.0, entityz(local10\Field1\Field2, $00), $00)
                            rotateentity(local10\Field1\Field25[$00], -90.0, rnd(0.0, 360.0), 0.0, $00)
                            local10\Field7 = loadsound_strict("SFX\SCP\1048A\Shriek.ogg")
                            local10\Field8 = loadsound_strict("SFX\SCP\1048A\Growth.ogg")
                            local10\Field2 = 1.0
                        EndIf
                    EndIf
                Else
                    local10\Field4 = 1.0
                    Select local10\Field2
                        Case 1.0
                            animate2(local10\Field1\Field25[$00], animtime(local10\Field1\Field25[$00]), $02, $18B, 1.0, $01)
                            If (2.5 > entitydistance(collider, local10\Field1\Field25[$00])) Then
                                local10\Field2 = 2.0
                            EndIf
                        Case 2.0
                            local93 = animtime(local10\Field1\Field25[$00])
                            animate2(local10\Field1\Field25[$00], local93, $02, $287, 1.0, $00)
                            If (((400.0 >= local93) And (400.0 < animtime(local10\Field1\Field25[$00]))) <> 0) Then
                                local10\Field5 = playsound_strict(local10\Field7)
                            EndIf
                            local94 = max((1.0 - ((Abs (local93 - 600.0)) / 100.0)), 0.0)
                            blurtimer = (local94 * 1000.0)
                            camerashake = (local94 * 10.0)
                            pointentity(local10\Field1\Field25[$00], local10\Field13, 0.0)
                            rotateentity(local10\Field1\Field25[$00], -90.0, entityyaw(local10\Field1\Field25[$00], $00), 0.0, $00)
                            If (646.0 < local93) Then
                                If (playerroom = local10\Field1) Then
                                    local10\Field2 = 3.0
                                    playsound_strict(local10\Field8)
                                    msg = "Something is growing all around your body."
                                    msgtimer = 210.0
                                Else
                                    local10\Field4 = 2100.0
                                EndIf
                            EndIf
                        Case 3.0
                            local10\Field3 = (local10\Field3 + fpsfactor)
                            blurtimer = (local10\Field3 * 2.0)
                            If (((250.0 < local10\Field3) And (250.0 >= (local10\Field3 - fpsfactor))) <> 0) Then
                                Select rand($03, $01)
                                    Case $01
                                        msg = "Ears are growing all over your body."
                                    Case $02
                                        msg = "Ear-like organs are growing all over your body."
                                    Case $03
                                        msg = "Ears are growing all over your body. They are crawling on your skin."
                                End Select
                                msgtimer = 210.0
                            ElseIf (((600.0 < local10\Field3) And (600.0 >= (local10\Field3 - fpsfactor))) <> 0) Then
                                Select rand($04, $01)
                                    Case $01
                                        msg = "It is becoming difficult to breathe."
                                    Case $02
                                        msg = "You have excellent hearing now. Also, you are dying."
                                    Case $03
                                        msg = "The ears are growing inside your body."
                                    Case $04
                                        msg = ((chr($22) + "Can't... Breathe...") + chr($22))
                                End Select
                                msgtimer = 350.0
                            EndIf
                            If (1050.0 < local10\Field3) Then
                                deathmsg = "A dead body covered in ears was found in [REDACTED]. Subject was presumably attacked by an instance of SCP-1048-A and suffocated to death by the ears. "
                                deathmsg = (deathmsg + "Body was sent for autopsy.")
                                kill("was killed by SCP-1048-A", $00)
                                local10\Field2 = 4.0
                                freeentity(local10\Field1\Field25[$00])
                                local10\Field1\Field25[$00] = $00
                                removeevent(local10)
                            EndIf
                    End Select
                    If (local10 <> Null) Then
                        If (playerinroom(local10) = $00) Then
                            If (0.0 < local10\Field4) Then
                                local10\Field4 = (local10\Field4 + fpsfactor)
                                If (1750.0 < local10\Field4) Then
                                    freeentity(local10\Field1\Field25[$00])
                                    local10\Field1\Field25[$00] = $00
                                    removeevent(local10)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $3C
                local10\Field1\Field32[$00] = createnpc($04, (entityx(local10\Field1\Field2, $01) + 1.0), 0.5, (entityz(local10\Field1\Field2, $01) + 1.0))
                local10\Field1\Field32[$00]\Field23 = "GFX\npcs\body1.jpg"
                changenpctextureid(local10\Field1\Field32[$00], $0A)
                rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, (entityyaw(local10\Field1\Field2, $00) - (Float rand($14, $3C))), 0.0, $01)
                setnpcframe(local10\Field1\Field32[$00], 19.0)
                local10\Field1\Field32[$00]\Field9 = 8.0
                removeevent(local10)
            Case $45
                local10\Field24 = $00
                If (8.0 > local10\Field20) Then
                    If (0.0 = local10\Field2) Then
                        local10\Field1\Field32[$00] = createnpc($03, entityx(local10\Field1\Field25[$02], $01), (entityy(local10\Field1\Field25[$02], $01) + 0.5), entityz(local10\Field1\Field25[$02], $01))
                        pointentity(local10\Field1\Field32[$00]\Field4, local10\Field1\Field2, 0.0)
                        rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, entityyaw(local10\Field1\Field32[$00]\Field4, $00), 0.0, $01)
                        setnpcframe(local10\Field1\Field32[$00], 288.0)
                        local10\Field1\Field32[$00]\Field9 = 8.0
                        local10\Field2 = 1.0
                    EndIf
                    local7 = createparticle(entityx(local10\Field1\Field25[$00], $01), entityy(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01), $06, 0.2, 0.0, $0A)
                    local7\Field9 = 0.01
                    rotateentity(local7\Field1, -60.0, (Float (local10\Field1\Field6 - $5A)), 0.0, $00)
                    local7\Field15 = -0.02
                    local10\Field5 = loopsound2(alarmsfx($03), local10\Field5, camera, local10\Field1\Field25[$03], 5.0, 1.0)
                EndIf
            Case $40
                If (15.0 > local10\Field20) Then
                    If (contained106 <> 0) Then
                        local10\Field2 = 2.0
                    EndIf
                    If (0.0 > curr106\Field9) Then
                        local10\Field2 = 2.0
                    EndIf
                    If (2.0 > local10\Field2) Then
                        If (0.0 = local10\Field2) Then
                            loadeventsound(local10, "SFX\Character\Scientist\EmilyScream.ogg", $00)
                            local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field25[$00], 100.0, 1.0)
                            local32 = createdecal($00, entityx(local10\Field1\Field25[$00], $01), (local10\Field1\Field4 + (2.0 * roomscale)), entityz(local10\Field1\Field25[$00], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.5
                            entityalpha(local32\Field0, 0.8)
                            entityfx(local32\Field0, $01)
                            local10\Field2 = 1.0
                        ElseIf (1.0 = local10\Field2) Then
                            If (channelplaying(local10\Field5) = $00) Then
                                local10\Field2 = 2.0
                                local10\Field1\Field29[$00]\Field4 = $00
                            Else
                                updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$00], 100.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        debuglog("Removed 'room2scps2' event")
                        local10\Field1\Field29[$00]\Field4 = $00
                        local32 = createdecal($00, entityx(local10\Field1\Field25[$00], $01), (local10\Field1\Field4 + (2.0 * roomscale)), entityz(local10\Field1\Field25[$00], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                        local32\Field2 = 0.5
                        entityalpha(local32\Field0, 0.8)
                        entityfx(local32\Field0, $01)
                        removeevent(local10)
                    EndIf
                EndIf
            Case $3F
                If (playerroom = local10\Field1) Then
                    grabbedentity = $00
                    local10\Field2 = 0.0
                    local97 = $01
                    local98 = createpivot(local10\Field1\Field2)
                    positionentity(local98, 976.0, 128.0, -640.0, $00)
                    For local12 = Each items
                        If (local12\Field15 = $00) Then
                            If (0.75 > entitydistance(local12\Field1, local10\Field1\Field25[$00])) Then
                                local97 = $00
                            EndIf
                        EndIf
                    Next
                    If (((0.75 > entitydistance(local10\Field1\Field25[$00], collider)) And local97) <> 0) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field25[$00]
                        EndIf
                    EndIf
                    If (grabbedentity <> $00) Then
                        local10\Field3 = (Float rand($00, $09))
                        If (inventory((Int local10\Field3)) <> Null) Then
                            local10\Field4 = 1.0
                            debuglog("pick1")
                        Else
                            For local1 = $00 To $09 Step $01
                                local99 = (inventory((Int ((local10\Field3 + (Float local1)) Mod 10.0))) = Null)
                                If (local99 = $00) Then
                                    local10\Field3 = ((local10\Field3 + (Float local1)) Mod 10.0)
                                EndIf
                                If (rand($08, $01) = $01) Then
                                    If (local99 <> 0) Then
                                        local10\Field4 = 3.1
                                    Else
                                        local10\Field4 = 3.0
                                    EndIf
                                    local10\Field2 = (Float rand($01, $05))
                                    local100 = ""
                                    Select local10\Field2
                                        Case 1.0
                                            local100 = "Lost Key"
                                        Case 2.0
                                            local100 = "Disciplinary Hearing DH-S-4137-17092"
                                        Case 3.0
                                            local100 = "Coin"
                                        Case 4.0
                                            local100 = "Movie Ticket"
                                        Case 5.0
                                            local100 = "Old Badge"
                                    End Select
                                    For local12 = Each items
                                        If (local12\Field0 = local100) Then
                                            local10\Field4 = 1.0
                                            local10\Field2 = 0.0
                                            Exit
                                        EndIf
                                    Next
                                    If (local99 = $00) Then
                                        Exit
                                    EndIf
                                ElseIf (local99 <> 0) Then
                                    local10\Field4 = 2.0
                                Else
                                    local10\Field4 = 1.0
                                    Exit
                                EndIf
                            Next
                        EndIf
                        If (1.0 = local10\Field4) Then
                            local102 = $00
                            For local75 = Each itemtemplates
                                If (isitemgoodfor1162(local75) <> 0) Then
                                    Select inventory((Int local10\Field3))\Field3\Field2
                                        Case "key"
                                            If ((((local75\Field2 = "key1") Or (local75\Field2 = "key2")) And (rand($02, $01) = $01)) <> 0) Then
                                                local102 = $01
                                                debuglog("lostkey")
                                            EndIf
                                        Case "paper","oldpaper"
                                            If (((local75\Field2 = "paper") And (rand($0C, $01) = $01)) <> 0) Then
                                                local102 = $01
                                                debuglog("paper")
                                            EndIf
                                        Case "gasmask","gasmask3","supergasmask","hazmatsuit","hazmatsuit2","hazmatsuit3"
                                            If ((((((((local75\Field2 = "gasmask") Or (local75\Field2 = "gasmask3")) Or (local75\Field2 = "supergasmask")) Or (local75\Field2 = "hazmatsuit")) Or (local75\Field2 = "hazmatsuit2")) Or (local75\Field2 = "hazmatsuit3")) And (rand($02, $01) = $01)) <> 0) Then
                                                local102 = $01
                                                debuglog("gasmask hazmat")
                                            EndIf
                                        Case "key1","key2","key3"
                                            If ((((((local75\Field2 = "key1") Or (local75\Field2 = "key2")) Or (local75\Field2 = "key3")) Or (local75\Field2 = "misc")) And (rand($06, $01) = $01)) <> 0) Then
                                                local102 = $01
                                                debuglog("key")
                                            EndIf
                                        Case "vest","finevest"
                                            If ((((local75\Field2 = "vest") Or (local75\Field2 = "finevest")) And (rand($01, $01) = $01)) <> 0) Then
                                                local102 = $01
                                                debuglog("vest")
                                            EndIf
                                        Default
                                            If (((local75\Field2 = "misc") And (rand($06, $01) = $01)) <> 0) Then
                                                local102 = $01
                                                debuglog("default")
                                            EndIf
                                    End Select
                                EndIf
                                If (local102 <> 0) Then
                                    removeitem(inventory((Int local10\Field3)), $01)
                                    local12 = createitem(local75\Field1, local75\Field2, entityx(local98, $01), entityy(local98, $01), entityz(local98, $01), $00, $00, $00, 1.0, $00, $01)
                                    entitytype(local12\Field1, $03, $00)
                                    playsound_strict(loadtempsound((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg")))
                                    local10\Field4 = 0.0
                                    multiplayer_writetempsound((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg"), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                    giveachievement($22, $01)
                                    mousehit1 = $00
                                    synchronizeitem(local12)
                                    Exit
                                EndIf
                            Next
                        ElseIf (2.0 = local10\Field4) Then
                            injuries = (injuries + 5.0)
                            local3 = createpivot($00)
                            positionentity(local3, entityx(local10\Field13, $00), (entityy(local10\Field13, $00) - 0.05), entityz(local10\Field13, $00), $00)
                            turnentity(local3, 90.0, 0.0, 0.0, $00)
                            entitypick(local3, 0.3)
                            local32 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local32\Field2 = 0.75
                            scalesprite(local32\Field0, local32\Field2, local32\Field2)
                            multiplayer_writedecal(local32, $01, $01)
                            freeentity(local3)
                            For local75 = Each itemtemplates
                                If ((isitemgoodfor1162(local75) And (rand($06, $01) = $01)) <> 0) Then
                                    local12 = createitem(local75\Field1, local75\Field2, entityx(local98, $01), entityy(local98, $01), entityz(local98, $01), $00, $00, $00, 1.0, $00, $01)
                                    entitytype(local12\Field1, $03, $00)
                                    synchronizeitem(local12)
                                    giveachievement($22, $01)
                                    mousehit1 = $00
                                    local10\Field4 = 0.0
                                    If (15.0 < injuries) Then
                                        deathmsg = "A dead Class D subject was discovered within the containment chamber of SCP-1162."
                                        deathmsg = (deathmsg + " An autopsy revealed that his right lung was missing, which suggests")
                                        deathmsg = (deathmsg + " interaction with SCP-1162.")
                                        playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                        lightflash = 5.0
                                        kill("was killed by SCP-1162", $00)
                                    Else
                                        playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                        multiplayer_writetempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                        lightflash = 5.0
                                        msg = "You feel a sudden overwhelming pain in your chest."
                                        msgtimer = 350.0
                                    EndIf
                                    Exit
                                EndIf
                            Next
                        ElseIf (3.0 <= local10\Field4) Then
                            If (3.1 > local10\Field4) Then
                                playsound_strict(loadtempsound((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg")))
                                multiplayer_writetempsound((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg"), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                removeitem(inventory((Int local10\Field3)), $01)
                            Else
                                injuries = (injuries + 5.0)
                                local3 = createpivot($00)
                                positionentity(local3, entityx(collider, $00), (entityy(collider, $00) - 0.05), entityz(collider, $00), $00)
                                turnentity(local3, 90.0, 0.0, 0.0, $00)
                                entitypick(local3, 0.3)
                                local32 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                local32\Field2 = 0.75
                                scalesprite(local32\Field0, local32\Field2, local32\Field2)
                                multiplayer_writedecal(local32, $01, $01)
                                freeentity(local3)
                                If (15.0 < injuries) Then
                                    deathmsg = "A dead Class D subject was discovered within the containment chamber of SCP-1162."
                                    deathmsg = (deathmsg + " An autopsy revealed that his right lung was missing, which suggests")
                                    deathmsg = (deathmsg + " interaction with SCP-1162.")
                                    playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                    multiplayer_writetempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 3.0, 1.0)
                                    lightflash = 5.0
                                    kill("was killed by SCP-1162", $00)
                                Else
                                    playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                    multiplayer_writetempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 3.0, 1.0)
                                    lightflash = 5.0
                                    msg = "You notice something moving in your pockets and a sudden pain in your chest."
                                    msgtimer = 350.0
                                EndIf
                                local10\Field3 = 0.0
                            EndIf
                            Select local10\Field2
                                Case 1.0
                                    local12 = createitem("Lost Key", "key", entityx(local98, $01), entityy(local98, $01), entityz(local98, $01), $00, $00, $00, 1.0, $00, $01)
                                Case 2.0
                                    local12 = createitem("Disciplinary Hearing DH-S-4137-17092", "oldpaper", entityx(local98, $01), entityy(local98, $01), entityz(local98, $01), $00, $00, $00, 1.0, $00, $01)
                                Case 3.0
                                    local12 = createitem("Coin", "coin", entityx(local98, $01), entityy(local98, $01), entityz(local98, $01), $00, $00, $00, 1.0, $00, $01)
                                Case 4.0
                                    local12 = createitem("Movie Ticket", "ticket", entityx(local98, $01), entityy(local98, $01), entityz(local98, $01), $00, $00, $00, 1.0, $00, $01)
                                Case 5.0
                                    local12 = createitem("Old Badge", "badge", entityx(local98, $01), entityy(local98, $01), entityz(local98, $01), $00, $00, $00, 1.0, $00, $01)
                            End Select
                            entitytype(local12\Field1, $03, $00)
                            giveachievement($22, $01)
                            mousehit1 = $00
                            local10\Field4 = 0.0
                            synchronizeitem(local12)
                        EndIf
                    EndIf
                    freeentity(local98)
                EndIf
            Case $3D
                local10\Field1\Field29[$00]\Field4 = $01
                local10\Field1\Field29[$01]\Field4 = $01
                local105 = $00
                If (local10\Field1\Field25[$01] <> $00) Then
                    local105 = $01
                EndIf
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (((1.4 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) And (0.0 = local10\Field4)) <> 0) Then
                            local10\Field2 = 1.0
                            If (local105 <> 0) Then
                                If (local10\Field8 <> $00) Then
                                    freesound_strict(local10\Field8)
                                    local10\Field8 = $00
                                EndIf
                                local10\Field8 = loadsound_strict("SFX\Door\DoorSparks.ogg")
                                local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field25[$01], 5.0, 1.0)
                            EndIf
                            stopchannel(local10\Field5)
                            local10\Field5 = $00
                            If (local10\Field7 <> $00) Then
                                freesound_strict(local10\Field7)
                                local10\Field7 = $00
                            EndIf
                            local10\Field7 = loadsound_strict("SFX\Door\Airlock.ogg")
                            local10\Field1\Field29[$00]\Field4 = $00
                            local10\Field1\Field29[$01]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $01, $01, $00, "", $00)
                            usedoor(local10\Field1\Field29[$01], $01, $01, $00, "", $00)
                            If (playerroom = local10\Field1) Then
                                playsound_strict(alarmsfx($04))
                            EndIf
                        ElseIf (2.4 < entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                            local10\Field4 = 0.0
                        EndIf
                    ElseIf (490.0 > local10\Field3) Then
                        local10\Field3 = (local10\Field3 + fpsfactor)
                        local10\Field1\Field29[$00]\Field5 = $00
                        local10\Field1\Field29[$01]\Field5 = $00
                        If (70.0 > local10\Field3) Then
                            If (local105 <> 0) Then
                                local3 = createpivot($00)
                                local106 = local10\Field1\Field25[$01]
                                positionentity(local3, entityx(local106, $01), (entityy(local106, $01) + rnd(0.0, 0.05)), entityz(local106, $01), $00)
                                rotateentity(local3, 0.0, (entityyaw(local106, $01) + 90.0), 0.0, $00)
                                moveentity(local3, 0.0, 0.0, 0.2)
                                If (particleamount > $00) Then
                                    For local1 = $00 To (((particleamount - $01) Shl $01) + $01) Step $01
                                        local7 = createparticle(entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $07, 0.002, 0.0, $19)
                                        local7\Field9 = rnd(0.01, 0.05)
                                        rotateentity(local7\Field1, rnd(-45.0, 0.0), (entityyaw(local3, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                                        local7\Field7 = 0.0075
                                        scalesprite(local7\Field0, local7\Field7, local7\Field7)
                                        local7\Field15 = -0.05
                                    Next
                                EndIf
                                freeentity(local3)
                            EndIf
                        ElseIf (((210.0 < local10\Field3) And (385.0 > local10\Field2)) <> 0) Then
                            local3 = createpivot(local10\Field1\Field2)
                            For local1 = $00 To $01 Step $01
                                If (local10\Field1\Field7\Field11 = "room3gw") Then
                                    If (local1 = $00) Then
                                        positionentity(local3, -288.0, 416.0, 320.0, $00)
                                    Else
                                        positionentity(local3, 192.0, 416.0, 320.0, $00)
                                    EndIf
                                ElseIf (local1 = $00) Then
                                    positionentity(local3, 312.0, 416.0, -128.0, $00)
                                Else
                                    positionentity(local3, 312.0, 416.0, 224.0, $00)
                                EndIf
                                local7 = createparticle(entityx(local3, $01), entityy(local3, $01), entityz(local3, $01), $06, 0.8, 0.0, $32)
                                local7\Field9 = 0.025
                                rotateentity(local7\Field1, 90.0, 0.0, 0.0, $00)
                                local7\Field15 = -0.02
                            Next
                            freeentity(local3)
                            If (local10\Field5 = $00) Then
                                local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field25[$00], 5.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        local10\Field2 = 0.0
                        local10\Field3 = 0.0
                        local10\Field4 = 1.0
                        If (local10\Field1\Field29[$00]\Field5 = $00) Then
                            local10\Field1\Field29[$00]\Field4 = $00
                            local10\Field1\Field29[$01]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $01, $01, $00, "", $00)
                            usedoor(local10\Field1\Field29[$01], $01, $01, $00, "", $00)
                        EndIf
                        removeevent(local10)
                    EndIf
                    If (local10 <> Null) Then
                        If (local105 <> 0) Then
                            If (channelplaying(local10\Field6) <> 0) Then
                                updatesoundorigin(local10\Field6, camera, local10\Field1\Field25[$01], 5.0, 1.0)
                            EndIf
                        EndIf
                        If (channelplaying(local10\Field5) <> 0) Then
                            updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$00], 5.0, 1.0)
                        EndIf
                    EndIf
                Else
                    local10\Field4 = 0.0
                EndIf
            Case $41
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    If (((local10\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                        quickloadpercent = $00
                        quickload_currevent = local10
                        local10\Field11 = "0"
                    EndIf
                EndIf
                If (1.0 = local10\Field2) Then
                    If (0.0 > local10\Field3) Then
                        If (-350.0 = local10\Field3) Then
                            For local15 = Each securitycams
                                If (local15\Field20 = local10\Field1) Then
                                    If (5.0 > entitydistance(local15\Field4, getplayercamera(local10\Field14))) Then
                                        If (entityvisible(local15\Field4, getplayercamera(local10\Field14)) <> 0) Then
                                            local10\Field3 = min((local10\Field3 + fpsfactor), 0.0)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Else
                            local10\Field3 = min((local10\Field3 + fpsfactor), 0.0)
                        EndIf
                    ElseIf (0.0 = local10\Field3) Then
                        If (local10\Field1\Field32[$00] <> Null) Then
                            local107 = 0.0
                            local108 = 0.0
                            local109 = $FFFFFFFF
                            local110 = $FFFFFFFF
                            For local1 = $00 To $03 Step $01
                                If (local10\Field1\Field35[local1] <> Null) Then
                                    If (local109 = $FFFFFFFF) Then
                                        local107 = entitydistance(local10\Field1\Field25[$07], local10\Field1\Field35[local1]\Field2)
                                        local109 = local1
                                    Else
                                        local108 = entitydistance(local10\Field1\Field25[$07], local10\Field1\Field35[local1]\Field2)
                                        local110 = local1
                                    EndIf
                                EndIf
                            Next
                            If (local108 < local107) Then
                                positionentity(local10\Field1\Field32[$00]\Field4, entityx(local10\Field1\Field35[local109]\Field2, $00), entityy(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field35[local109]\Field2, $00), $00)
                            Else
                                positionentity(local10\Field1\Field32[$00]\Field4, entityx(local10\Field1\Field35[local110]\Field2, $00), entityy(local10\Field1\Field25[$07], $01), entityz(local10\Field1\Field35[local110]\Field2, $00), $00)
                            EndIf
                            pointentity(local10\Field1\Field32[$00]\Field4, local10\Field1\Field2, 0.0)
                            moveentity(local10\Field1\Field32[$00]\Field4, 0.0, 0.0, -1.0)
                            resetentity(local10\Field1\Field32[$00]\Field4)
                            local10\Field1\Field32[$00]\Field66 = $00
                            local10\Field1\Field32[$00]\Field60 = entityx(local10\Field1\Field32[$00]\Field4, $00)
                            local10\Field1\Field32[$00]\Field61 = entityz(local10\Field1\Field32[$00]\Field4, $00)
                            local10\Field1\Field32[$00]\Field9 = 5.0
                            debuglog("aaaaaaaaa")
                            local10\Field3 = 1.0
                        EndIf
                    ElseIf (1.0 = local10\Field3) Then
                        If (local10\Field1\Field32[$00]\Field37 <> $01) Then
                            local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], entityx(local10\Field1\Field25[$0F], $01), entityy(local10\Field1\Field25[$0F], $01), entityz(local10\Field1\Field25[$0F], $01))
                        Else
                            debuglog("bbbbbbbbb")
                            local10\Field3 = 2.0
                        EndIf
                    ElseIf (2.0 = local10\Field3) Then
                        If (local10\Field1\Field32[$00]\Field37 <> $01) Then
                            local10\Field1\Field32[$00]\Field11 = 1.0
                            local10\Field3 = 3.0
                            local10\Field1\Field32[$00]\Field38 = 0.0
                            debuglog("ccccccccc")
                        Else
                            If (5.0 > entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field1\Field29[$00]\Field2)) Then
                                local10\Field1\Field29[$00]\Field4 = $01
                                local10\Field1\Field29[$01]\Field4 = $01
                                If (0.0 = local10\Field1\Field32[$00]\Field25) Then
                                    playsound_strict(dooropen079sfx)
                                    debuglog("079 - OPEN DOORS IN ROOM2SL")
                                    local10\Field1\Field32[$00]\Field25 = 1.0
                                EndIf
                                If (local10\Field1\Field29[$00]\Field5 = $00) Then
                                    local10\Field1\Field29[$00]\Field5 = $01
                                    local111 = rand($00, $02)
                                    playsound2(opendoorsfx($00, local111), camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                                EndIf
                                If (local10\Field1\Field29[$01]\Field5 = $00) Then
                                    local10\Field1\Field29[$01]\Field5 = $01
                                    local111 = rand($00, $02)
                                    playsound2(opendoorsfx($00, local111), camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                                EndIf
                            EndIf
                            If (1.0 = local10\Field1\Field32[$00]\Field25) Then
                                local10\Field1\Field32[$00]\Field7 = 0.0
                            EndIf
                        EndIf
                        If (5.0 <> local10\Field1\Field32[$00]\Field9) Then
                            local10\Field3 = 7.0
                            debuglog("fffffffff")
                        EndIf
                    ElseIf (3.0 = local10\Field3) Then
                        If (5.0 <> local10\Field1\Field32[$00]\Field9) Then
                            local10\Field3 = 7.0
                            debuglog("fffffffff")
                        EndIf
                        If (player[local10\Field1\Field32[$00]\Field74] = Null) Then
                            local10\Field1\Field32[$00]\Field74 = findnearestid(local10\Field1\Field32[$00])
                            local10\Field1\Field32[$00]\Field73 = player[local10\Field1\Field32[$00]\Field74]\Field13
                        EndIf
                        If (menpcseesplayer(local10\Field1\Field32[$00], $01) = $02) Then
                            local10\Field3 = 4.0
                            debuglog("ddddddddd")
                        EndIf
                        If (local10\Field1\Field32[$00]\Field37 <> $01) Then
                            If (0.0 = local10\Field1\Field32[$00]\Field38) Then
                                If (local10\Field1\Field32[$00]\Field12 = $01) Then
                                    If (local10\Field1\Field32[$00]\Field20 = $00) Then
                                        local10\Field1\Field32[$00]\Field19 = loadsound_strict("SFX\SCP\049\Room2SL1.ogg")
                                        local10\Field1\Field32[$00]\Field20 = playsound2(local10\Field1\Field32[$00]\Field19, camera, local10\Field1\Field32[$00]\Field4, 10.0, 1.0)
                                    ElseIf (channelplaying(local10\Field1\Field32[$00]\Field20) = $00) Then
                                        local10\Field1\Field32[$00]\Field38 = 1.0
                                        local10\Field1\Field32[$00]\Field20 = $00
                                    EndIf
                                ElseIf (local10\Field1\Field32[$00]\Field12 = $02) Then
                                    If (3.0 = local10\Field1\Field32[$00]\Field11) Then
                                        If (local10\Field1\Field32[$00]\Field20 = $00) Then
                                            local10\Field1\Field32[$00]\Field19 = loadsound_strict("SFX\SCP\049\Room2SL2.ogg")
                                            local10\Field1\Field32[$00]\Field20 = playsound2(local10\Field1\Field32[$00]\Field19, camera, local10\Field1\Field32[$00]\Field4, 10.0, 1.0)
                                        ElseIf (channelplaying(local10\Field1\Field32[$00]\Field20) = $00) Then
                                            local10\Field1\Field32[$00]\Field38 = 1.0
                                            local10\Field1\Field32[$00]\Field20 = $00
                                        EndIf
                                    ElseIf (1118.0 <= local10\Field1\Field32[$00]\Field14) Then
                                        local10\Field1\Field32[$00]\Field38 = 1.0
                                    EndIf
                                EndIf
                            Else
                                Select local10\Field1\Field32[$00]\Field11
                                    Case 1.0
                                        local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], entityx(local10\Field1\Field25[$10], $01), entityy(local10\Field1\Field25[$10], $01), entityz(local10\Field1\Field25[$10], $01))
                                        local10\Field1\Field32[$00]\Field12 = $01
                                        debuglog("Path1")
                                    Case 2.0
                                        local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], entityx(local10\Field1\Field25[$0F], $01), entityy(local10\Field1\Field25[$0F], $01), entityz(local10\Field1\Field25[$0F], $01))
                                        local10\Field1\Field32[$00]\Field12 = $02
                                        debuglog("Path2")
                                    Case 3.0
                                        local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], entityx(local10\Field1\Field25[$11], $01), entityy(local10\Field1\Field25[$11], $01), entityz(local10\Field1\Field25[$11], $01))
                                        local10\Field1\Field32[$00]\Field12 = $02
                                        debuglog("Path3")
                                    Case 4.0
                                        local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], local10\Field1\Field32[$00]\Field60, 0.1, local10\Field1\Field32[$00]\Field61)
                                        local10\Field1\Field32[$00]\Field12 = $02
                                        debuglog("Path4")
                                    Case 5.0
                                        local10\Field3 = 5.0
                                End Select
                                local10\Field1\Field32[$00]\Field38 = 0.0
                                local10\Field1\Field32[$00]\Field11 = (local10\Field1\Field32[$00]\Field11 + 1.0)
                            EndIf
                        EndIf
                    ElseIf (4.0 = local10\Field3) Then
                        If (5.0 <> local10\Field1\Field32[$00]\Field9) Then
                            local10\Field3 = 7.0
                            local10\Field1\Field32[$00]\Field11 = 6.0
                            debuglog("fffffffff")
                        EndIf
                    ElseIf (5.0 = local10\Field3) Then
                        debuglog("ddddddddd")
                        local10\Field1\Field32[$00]\Field9 = 2.0
                        For local9 = Each rooms
                            If (local9 <> playerroom) Then
                                If ((((hidedistance * 2.0) > entitydistance(local9\Field2, local10\Field1\Field32[$00]\Field4)) And (hidedistance < entitydistance(local9\Field2, local10\Field1\Field32[$00]\Field4))) <> 0) Then
                                    local10\Field1\Field32[$00]\Field37 = findpath(local10\Field1\Field32[$00], entityx(local9\Field2, $00), entityy(local9\Field2, $00), entityz(local9\Field2, $00))
                                    local10\Field1\Field32[$00]\Field38 = 0.0
                                    If (local10\Field1\Field32[$00]\Field37 = $01) Then
                                        local10\Field3 = 6.0
                                    EndIf
                                    Exit
                                EndIf
                            EndIf
                        Next
                    ElseIf (6.0 = local10\Field3) Then
                        If (player[local10\Field1\Field32[$00]\Field74] = Null) Then
                            local10\Field1\Field32[$00]\Field74 = findnearestid(local10\Field1\Field32[$00])
                            local10\Field1\Field32[$00]\Field73 = player[local10\Field1\Field32[$00]\Field74]\Field13
                        EndIf
                        If (((menpcseesplayer(local10\Field1\Field32[$00], $01) Or (0.0 < local10\Field1\Field32[$00]\Field10)) Or (local10\Field1\Field32[$00]\Field26 > $00)) <> 0) Then
                            debuglog("fffffffff")
                            local10\Field3 = 7.0
                        Else
                            If (playerinroom(local10) <> 0) Then
                                shouldplay = $14
                            EndIf
                            If (local10\Field1\Field32[$00]\Field37 <> $01) Then
                                local10\Field1\Field32[$00]\Field24 = 4200.0
                                positionentity(local10\Field1\Field32[$00]\Field4, 0.0, 500.0, 0.0, $00)
                                resetentity(local10\Field1\Field32[$00]\Field4)
                                debuglog("eeeeeeeee")
                                local10\Field3 = 7.0
                            EndIf
                        EndIf
                    EndIf
                    If (networkserver\Field18 <> 0) Then
                        If (local10\Field1\Field32[$00] <> Null) Then
                            If (7.0 > local10\Field3) Then
                                If (2.0 < local10\Field3) Then
                                    If (1.0 < (Abs (entityy(local10\Field1\Field29[$00]\Field2, $00) - entityy(local10\Field1\Field32[$00]\Field4, $00)))) Then
                                        If (1.0 > (Abs (entityy(local10\Field1\Field29[$00]\Field2, $00) - entityy(local10\Field13, $00)))) Then
                                            If (local10\Field1\Field29[$00]\Field5 <> 0) Then
                                                local10\Field1\Field29[$00]\Field5 = $00
                                                local10\Field1\Field29[$00]\Field8 = $01
                                                playsound_strict(loadtempsound("SFX\Door\DoorClose079.ogg"))
                                                debuglog("079 - CLOSE DOOR AT HALLWAY IN ROOM2SL")
                                            EndIf
                                        EndIf
                                    ElseIf (local10\Field1\Field29[$00]\Field5 = $00) Then
                                        local10\Field1\Field29[$00]\Field8 = $00
                                        local10\Field1\Field29[$00]\Field5 = $01
                                        local111 = rand($00, $02)
                                        playsound2(opendoorsfx($00, local111), camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                                        playsound_strict(dooropen079sfx)
                                        debuglog("079 - OPEN DOOR AT HALLWAY IN ROOM2SL")
                                    EndIf
                                EndIf
                            ElseIf (local10\Field1\Field29[$00]\Field5 = $00) Then
                                local10\Field1\Field29[$00]\Field8 = $00
                                local10\Field1\Field29[$00]\Field5 = $01
                                local111 = rand($00, $02)
                                playsound2(opendoorsfx($00, local111), camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                                playsound_strict(dooropen079sfx)
                                debuglog("079 - OPEN DOOR AT HALLWAY IN ROOM2SL")
                            EndIf
                        EndIf
                    EndIf
                EndIf
                local10\Field4 = (Float updatelever(local10\Field1\Field28[$00], $00))
                If (1.0 = local10\Field4) Then
                    updatecheckpointmonitors($00)
                    If (50.0 > monitortimer) Then
                        entitytexture(local10\Field1\Field25[$14], local10\Field1\Field37[$00], $01, $00)
                    Else
                        entitytexture(local10\Field1\Field25[$14], local10\Field1\Field37[$00], $02, $00)
                    EndIf
                Else
                    turncheckpointmonitorsoff($00)
                    entitytexture(local10\Field1\Field25[$14], local10\Field1\Field37[$00], $00, $00)
                EndIf
                If (((1.0 < (Abs (entityy(local10\Field1\Field29[$00]\Field2, $00) - entityy(collider, $00)))) And (playerroom = local10\Field1)) <> 0) Then
                    For local1 = $00 To $0E Step $01
                        If (((local10\Field1\Field25[local1] <> $00) And (local1 <> $07)) <> 0) Then
                            showentity(local10\Field1\Field25[local1])
                        EndIf
                    Next
                    For local15 = Each securitycams
                        If (local15\Field20 = local10\Field1) Then
                            If (local15\Field4 <> $00) Then
                                showentity(local15\Field4)
                            EndIf
                            If (local15\Field10 <> $00) Then
                                showentity(local15\Field10)
                            EndIf
                            Exit
                        EndIf
                    Next
                Else
                    For local1 = $00 To $0E Step $01
                        If (((local10\Field1\Field25[local1] <> $00) And (local1 <> $07)) <> 0) Then
                            hideentity(local10\Field1\Field25[local1])
                        EndIf
                    Next
                    For local15 = Each securitycams
                        If (local15\Field20 = local10\Field1) Then
                            If (local15\Field4 <> $00) Then
                                hideentity(local15\Field4)
                            EndIf
                            If (local15\Field10 <> $00) Then
                                hideentity(local15\Field10)
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
                For local11 = Each events
                    If (local11\Field22 = $2A) Then
                        If (2.0 = local11\Field2) Then
                            entitytexture(local10\Field1\Field25[$15], local10\Field1\Field37[$00], $03, $00)
                        Else
                            entitytexture(local10\Field1\Field25[$15], local10\Field1\Field37[$01], $06, $00)
                        EndIf
                        Exit
                    EndIf
                Next
            Case $46
                If (networkserver\Field18 = $00) Then
                    local10\Field2 = 0.0
                    local10\Field20 = 100.0
                EndIf
                If (hidedistance > local10\Field20) Then
                    If (2.0 <> local10\Field2) Then
                        If (curr096 <> Null) Then
                            If (40.0 > entitydistance(curr096\Field4, local10\Field13)) Then
                                local10\Field2 = 2.0
                                debuglog(("Failed to spawn SCP-096 in room " + local10\Field1\Field7\Field11))
                                debuglog("- SCP-096 too close to player")
                            EndIf
                            For local11 = Each events
                                If (local11\Field0 = "room2servers") Then
                                    If (((0.0 < local11\Field2) And (local11\Field1\Field32[$00] <> Null)) <> 0) Then
                                        local10\Field2 = 2.0
                                        debuglog(("Failed to spawn SCP-096 in room " + local10\Field1\Field7\Field11))
                                        debuglog("- room2servers event still in progress")
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            For local9 = Each rooms
                                If (local9\Field7\Field11 = "checkpoint1") Then
                                    If (10.0 > local9\Field8) Then
                                        local10\Field2 = 2.0
                                        debuglog(("Failed to spawn SCP-096 in room " + local10\Field1\Field7\Field11))
                                        debuglog("- too close to checkpoint1")
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (5.0 <> curr096\Field9) Then
                                local10\Field2 = 2.0
                                debuglog(("Failed to spawn SCP-096 in room " + local10\Field1\Field7\Field11))
                                debuglog("- SCP-096 enraged")
                            EndIf
                            If (entitydistance(curr096\Field4, local10\Field13) < entitydistance(curr096\Field4, local10\Field1\Field2)) Then
                                local10\Field2 = 2.0
                                debuglog(("Failed to spawn SCP-096 in room " + local10\Field1\Field7\Field11))
                                debuglog("- Room is too far away")
                            EndIf
                        EndIf
                        For local11 = Each events
                            If (local11\Field0 = "room2servers") Then
                                If (0.0 = local11\Field2) Then
                                    local10\Field2 = 2.0
                                    debuglog(("Failed to spawn SCP-096 in room " + local10\Field1\Field7\Field11))
                                    debuglog("- room2servers event not activated + room is too close to room2servers")
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (playerinroom(local10) <> 0) Then
                            local10\Field2 = 2.0
                        EndIf
                    EndIf
                    If (0.0 = local10\Field2) Then
                        Select local10\Field1\Field7\Field11
                            Case "room4pit","room3pit","room3z2","room4tunnels","room3tunnel"
                                If (((local10\Field1\Field7\Field11 = "room4pit") Or (local10\Field1\Field7\Field11 = "room4tunnels")) <> 0) Then
                                    local115 = rand($00, $03)
                                Else
                                    local115 = rand($00, $02)
                                EndIf
                                If (local115 = $00) Then
                                    local113 = -608.0
                                    local114 = 0.0
                                ElseIf (local115 = $01) Then
                                    local113 = 0.0
                                    local114 = -608.0
                                ElseIf (local115 = $02) Then
                                    local113 = 608.0
                                    local114 = 0.0
                                Else
                                    local113 = 0.0
                                    local114 = 608.0
                                EndIf
                            Default
                                local113 = rnd(-100.0, 100.0)
                                local114 = rnd(-100.0, 100.0)
                        End Select
                        local3 = createpivot(local10\Field1\Field2)
                        positionentity(local3, local113, 0.0, local114, $00)
                        If (curr096 = Null) Then
                            curr096 = createnpc($09, entityx(local3, $01), (local10\Field1\Field4 + 0.5), entityz(local3, $01))
                            debuglog((Str entityy(curr096\Field4, $00)))
                        Else
                            positionentity(curr096\Field4, entityx(local3, $01), (local10\Field1\Field4 + 0.5), entityz(local3, $01), $00)
                            resetentity(curr096\Field4)
                        EndIf
                        pointentity(curr096\Field4, local10\Field13, 0.0)
                        rotateentity(curr096\Field4, 0.0, (entityyaw(curr096\Field4, $00) + 180.0), 0.0, $00)
                        freeentity(local3)
                        curr096\Field9 = 5.0
                        debuglog(((("SCP-096 successfully placed in " + chr($22)) + local10\Field1\Field7\Field11) + chr($22)))
                        local10\Field2 = 1.0
                    ElseIf (1.0 = local10\Field2) Then
                        pointentity(curr096\Field4, local10\Field13, 0.0)
                        rotateentity(curr096\Field4, 0.0, (entityyaw(curr096\Field4, $00) + 180.0), 0.0, $00)
                        If ((hidedistance * 0.5) > entitydistance(curr096\Field4, local10\Field13)) Then
                            If (entityvisible(curr096\Field4, camera) <> 0) Then
                                pointentity(curr096\Field4, local10\Field13, 0.0)
                                rotateentity(curr096\Field4, 0.0, (entityyaw(curr096\Field4, $00) + rnd(170.0, 190.0)), 0.0, $00)
                                local10\Field2 = 2.0
                            EndIf
                        EndIf
                    ElseIf (3.0 = local10\Field2) Then
                        local10\Field2 = 2.0
                    EndIf
                ElseIf (2.0 = local10\Field2) Then
                    If (rand($FFFFFFFF, ((selecteddifficulty\Field3 Shl $01) + $01)) > $00) Then
                        local10\Field2 = 0.0
                    Else
                        local10\Field2 = 3.0
                    EndIf
                EndIf
            Case $42
                local10\Field24 = $00
                If (playerroom <> local10\Field1) Then
                    hideentity(local10\Field1\Field25[$00])
                Else
                    showentity(local10\Field1\Field25[$00])
                    If (0.0 = local10\Field2) Then
                        local10\Field1\Field32[$00] = createnpc($15, entityx(local10\Field1\Field25[$03], $01), 0.5, entityz(local10\Field1\Field25[$03], $01))
                        rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, (Float (local10\Field1\Field6 - $5A)), 0.0, $00)
                        local10\Field2 = 1.0
                    EndIf
                    If (1.2 > entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field13)) Then
                        If (0.0 = local10\Field3) Then
                            lightblink = 12.0
                            playsound_strict(lightsfx)
                            local10\Field3 = fpsfactor
                        EndIf
                    EndIf
                EndIf
                If (((0.0 < local10\Field3) And (280.0 > local10\Field3)) <> 0) Then
                    local10\Field3 = (local10\Field3 + fpsfactor)
                ElseIf (280.0 <= local10\Field3) Then
                    If (0.0 = local10\Field1\Field32[$00]\Field9) Then
                        local10\Field1\Field32[$00]\Field9 = 2.0
                    EndIf
                EndIf
            Case $3E
                If (playerroom <> local10\Field1) Then
                    If (local10\Field1\Field25[$00] <> $00) Then
                        For local1 = $01 To $0F Step $01
                            hideentity(local10\Field1\Field25[local1])
                        Next
                    EndIf
                    If ((entityy(local10\Field1\Field2, $00) - 0.5) < entityy(collider, $00)) Then
                        playerroom = local10\Field1
                    EndIf
                EndIf
                If (2.0 = local10\Field2) Then
                    If (local10\Field5 <> $00) Then
                        stopstream_strict(local10\Field5)
                        stopchannel(local10\Field6)
                        local10\Field5 = $00
                        local10\Field6 = $00
                    EndIf
                    hideentity(ntf_1499sky)
                    hidechunks()
                    For local117 = Each dummy1499
                        freeentity(local117\Field1)
                        Delete local117
                    Next
                    If (2100.0 > local10\Field4) Then
                        local10\Field4 = 0.0
                    EndIf
                    local10\Field2 = 1.0
                    If (local10\Field8 <> $00) Then
                        freesound_strict(local10\Field8)
                        local10\Field8 = $00
                    EndIf
                EndIf
            Case $47
                local10\Field24 = $00
                local118 = $00
                For local11 = Each events
                    If (((local11 <> local10) And (local11\Field22 = $29)) <> 0) Then
                        If (0.0 > local11\Field2) Then
                            local118 = $01
                            Exit
                        EndIf
                    EndIf
                Next
                If (local118 <> 0) Then
                    If (8.0 > local10\Field20) Then
                        If (local10\Field1\Field32[$00] = Null) Then
                            local10\Field1\Field32[$00] = createnpc($04, local10\Field1\Field3, 0.5, local10\Field1\Field5)
                            rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $B4)), 0.0, $00)
                            moveentity(local10\Field1\Field32[$00]\Field4, 0.0, 0.0, -0.5)
                            local10\Field1\Field32[$00]\Field9 = 3.0
                            local10\Field1\Field32[$00]\Field23 = "GFX\npcs\035victim.jpg"
                            changenpctextureid(local10\Field1\Field32[$00], $07)
                            setnpcframe(local10\Field1\Field32[$00], 19.0)
                        EndIf
                        If (local10\Field1\Field32[$01] = Null) Then
                            If (2.5 > entitydistance(local10\Field1\Field32[$00]\Field4, local10\Field13)) Then
                                local10\Field1\Field32[$01] = createnpc($0D, entityx(local10\Field1\Field32[$00]\Field4, $00), 0.0, entityz(local10\Field1\Field32[$00]\Field4, $00))
                                rotateentity(local10\Field1\Field32[$01]\Field4, 0.0, (Float local10\Field1\Field6), 0.0, $00)
                                moveentity(local10\Field1\Field32[$01]\Field4, 0.0, 0.0, 0.6)
                            EndIf
                        EndIf
                    ElseIf (hidedistance < local10\Field20) Then
                        If (local10\Field1\Field32[$01] <> Null) Then
                            removenpc(local10\Field1\Field32[$01], $00)
                            local10\Field1\Field32[$01] = Null
                        EndIf
                    EndIf
                EndIf
            Case $49
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    local10\Field2 = (Float rand($01, $03))
                Else
                    local10\Field1\Field29[$00]\Field12 = (Int local10\Field2)
                EndIf
            Case $43
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    local10\Field1\Field32[$00] = createnpc($03, entityx(local10\Field1\Field25[$01], $01), (entityy(local10\Field1\Field25[$01], $01) + 0.5), entityz(local10\Field1\Field25[$01], $01))
                    rotateentity(local10\Field1\Field32[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $B4)), 0.0, $01)
                    setnpcframe(local10\Field1\Field32[$00], 286.0)
                    local10\Field1\Field32[$00]\Field9 = 8.0
                    local10\Field2 = 1.0
                EndIf
                If (playerinroom(local10) <> 0) Then
                    updatebutton(local10\Field1\Field25[$02])
                    If (((closestbutton = local10\Field1\Field25[$02]) And mousehit1) <> 0) Then
                        msg = "The elevator appears to be broken."
                        playsound2(buttonsfx2, camera, local10\Field1\Field25[$02], 10.0, 1.0)
                        multiplayer_writesound(buttonsfx2, 0.0, 0.0, 0.0, 10.0, 1.0)
                        msgtimer = 350.0
                        mousehit1 = $00
                    EndIf
                    If (playerroom = local10\Field1) Then
                        If ((((((-512.0 * roomscale) > entityy(collider, $00)) And (0.0 <= killtimer)) And (0.0 <= falltimer)) And (player_isdead() = $00)) <> 0) Then
                            deathmsg = ""
                            playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"))
                            multiplayer_writetempsound("SFX\Room\PocketDimension\Impact.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                            kill("was killed", $00)
                        EndIf
                    EndIf
                EndIf
            Case $44
                If (playerinroom(local10) <> 0) Then
                    For local1 = $00 To $01 Step $01
                        updatebutton(local10\Field1\Field25[local1])
                        If (((closestbutton = local10\Field1\Field25[local1]) And mousehit1) <> 0) Then
                            msg = "The elevator appears to be broken."
                            playsound2(buttonsfx2, camera, local10\Field1\Field25[local1], 10.0, 1.0)
                            multiplayer_writesound(buttonsfx2, 0.0, 0.0, 0.0, 10.0, 1.0)
                            msgtimer = 350.0
                            mousehit1 = $00
                        EndIf
                    Next
                EndIf
        End Select
    Next
    If (networkserver\Field18 = $01) Then
        For local10 = Each events
            For local1 = $00 To $0B Step $01
                If (local10\Field1\Field32[local1] <> Null) Then
                    local10\Field1\Field32[local1]\Field80 = local10\Field15
                    local10\Field1\Field32[local1]\Field81 = local1
                EndIf
            Next
        Next
    EndIf
    Return $00
End Function
