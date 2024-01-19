Function updatenpcs%()
    Local local0.npcs
    Local local1.npcs
    Local local2.doors
    Local local3.decals
    Local local4.rooms
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10%
    Local local11#
    Local local12#
    Local local13%
    Local local14$
    Local local15%
    Local local16%
    Local local17%
    Local local19%
    Local local20%
    Local local21#
    Local local22.players
    Local local24.waypoints
    Local local25%
    Local local27%
    Local local28%
    Local local29%
    Local local30%
    Local local32%
    Local local34%
    Local local35#
    Local local36.rooms
    Local local37#
    Local local41#
    Local local42#
    Local local43%
    Local local44.particles
    Local local45%
    Local local46.waypoints
    Local local47.waypoints
    Local local52.forest
    Local local54%
    Local local55%
    Local local57%
    Local local58%
    Local local59$
    Local local61.rooms
    Local local68#
    Local local71#
    Local local72%
    If (networkserver\Field15 = $01) Then
        For local0 = Each npcs
            local0\Field85 = 999.0
            local0\Field86 = 999.0
            local0\Field87 = 999.0
            hideentity(local0\Field0)
            hideentity(local0\Field4)
        Next
        Return $00
    EndIf
    For local0 = Each npcs
        local0\Field58 = checkfornpcinfacility(local0)
        local0\Field97 = local0\Field74
        local0\Field74 = findnearestid(local0)
        local0\Field73 = player[local0\Field74]\Field13
        Select local0\Field5
            Case $01
                setanimtime(local0\Field0, 0.0, $00)
                If (3.0 <> local0\Field24) Then
                    local6 = entitydistance(local0\Field4, local0\Field73)
                    local0\Field11 = 1.0
                    If (2.0 > local0\Field24) Then
                        showentity(local0\Field0)
                        If (0.1 < local0\Field69) Then
                            local0\Field24 = 1.0
                            local0\Field69 = max((local0\Field69 - fpsfactor), 0.1)
                        ElseIf (0.1 = local0\Field69) Then
                            local0\Field24 = 0.0
                            local0\Field69 = 0.0
                        EndIf
                        positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.32), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                        If (0.0 = local0\Field24) Then
                            local19 = $00
                            local20 = $01
                            If (15.0 > local6) Then
                                If (10.0 > local6) Then
                                    If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                        local19 = $01
                                        local0\Field33 = entityx(local0\Field73, $01)
                                        local0\Field34 = entityy(local0\Field73, $01)
                                        local0\Field35 = entityz(local0\Field73, $01)
                                    EndIf
                                EndIf
                                local21 = max(min((distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field28, local0\Field30) * 2.5), 1.0), 0.0)
                                local0\Field17 = loopsound2(stonedragsfx, local0\Field17, camera, local0\Field4, 10.0, local0\Field9)
                                local0\Field28 = entityx(local0\Field4, $00)
                                local0\Field30 = entityz(local0\Field4, $00)
                                For local22 = Each players
                                    If (((-16.0 > local22\Field31) Or (-6.0 < local22\Field31)) <> 0) Then
                                        If (entityinview(local0\Field0, getplayercamera(local22\Field0)) <> 0) Then
                                            local20 = $00
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            If (notarget <> 0) Then
                                local20 = $01
                            EndIf
                            If (local20 = $00) Then
                                If (local0\Field74 = networkserver\Field28) Then
                                    blurvolume = max(max(min(((4.0 - local6) / 6.0), 0.9), 0.1), blurvolume)
                                    currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 15.0) * max(((3.5 - local6) / 3.5), 0.0)))
                                    If ((((3.5 > local6) And ((millisecs2() - local0\Field26) > $EA60)) And local19) <> 0) Then
                                        playsound_strict(horrorsfx(rand($03, $04)))
                                        local0\Field26 = millisecs2()
                                    EndIf
                                    If (((1.5 > local6) And (rand($2BC, $01) = $01)) <> 0) Then
                                        playsound2(scp173sfx(rand($00, $02)), camera, local0\Field0, 10.0, 1.0)
                                    EndIf
                                    If ((((1.5 > local6) And (2.0 < local0\Field27)) And local19) <> 0) Then
                                        currcamerazoom = 40.0
                                        heartbeatrate = max(heartbeatrate, 140.0)
                                        heartbeatvolume = 0.5
                                        Select rand($05, $01)
                                            Case $01
                                                playsound_strict(horrorsfx($01))
                                            Case $02
                                                playsound_strict(horrorsfx($02))
                                            Case $03
                                                playsound_strict(horrorsfx($09))
                                            Case $04
                                                playsound_strict(horrorsfx($0A))
                                            Case $05
                                                playsound_strict(horrorsfx($0E))
                                        End Select
                                    EndIf
                                EndIf
                                local0\Field27 = local6
                                local0\Field9 = max(0.0, (local0\Field9 - (fpsfactor / 20.0)))
                            ElseIf (50.0 < local6) Then
                                If (rand($46, $01) = $01) Then
                                    If ((((player[local0\Field74]\Field46 <> "exit1") And (player[local0\Field74]\Field46 <> "gatea")) And (player[local0\Field74]\Field46 <> "pocketdimension")) <> 0) Then
                                        For local24 = Each waypoints
                                            If (((local24\Field1 = Null) And (rand($05, $01) = $01)) <> 0) Then
                                                local9 = (Abs (entityx(local0\Field73, $00) - entityx(local24\Field0, $01)))
                                                If (((25.0 > local9) And (15.0 < local9)) <> 0) Then
                                                    local11 = (Abs (entityz(local0\Field73, $00) - entityz(local24\Field0, $01)))
                                                    If (((25.0 > local11) And (15.0 < local11)) <> 0) Then
                                                        debuglog(("MOVING 173 TO " + local24\Field2\Field7\Field11))
                                                        positionentity(local0\Field4, entityx(local24\Field0, $01), (entityy(local24\Field0, $01) + 0.25), entityz(local24\Field0, $01), $00)
                                                        resetentity(local0\Field4)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            ElseIf (local6 > (hidedistance * 0.8)) Then
                                If (rand($46, $01) = $01) Then
                                    teleportcloser(local0)
                                EndIf
                            Else
                                local0\Field9 = curvevalue(local21, local0\Field9, 3.0)
                                If (rand($14, $01) = $01) Then
                                    For local2 = Each doors
                                        If (((((local2\Field4 = $00) And (local2\Field5 = $00)) And (local2\Field17 = "")) And (local2\Field12 = $00)) <> 0) Then
                                            For local5 = $00 To $01 Step $01
                                                If (local2\Field3[local5] <> $00) Then
                                                    If (0.5 > (Abs (entityx(local0\Field4, $00) - entityx(local2\Field3[local5], $00)))) Then
                                                        If (0.5 > (Abs (entityz(local0\Field4, $00) - entityz(local2\Field3[local5], $00)))) Then
                                                            If (((180.0 <= local2\Field7) Or (0.0 >= local2\Field7)) <> 0) Then
                                                                entitypickmode(local2\Field3[local5], $02, $01)
                                                                local25 = createpivot($00)
                                                                positionentity(local25, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.5), entityz(local0\Field4, $00), $00)
                                                                pointentity(local25, local2\Field3[local5], 0.0)
                                                                moveentity(local25, 0.0, 0.0, (local0\Field21 * 0.6))
                                                                If (entitypick(local25, 0.5) = local2\Field3[local5]) Then
                                                                    playsound_strict(loadtempsound("SFX\Door\DoorOpen173.ogg"))
                                                                    usedoor(local2, $00, $01, $00, "", $00)
                                                                EndIf
                                                                entitypickmode(local2\Field3[local5], $00, $01)
                                                                freeentity(local25)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    Next
                                EndIf
                                If (notarget <> 0) Then
                                    local19 = $00
                                    local0\Field33 = 0.0
                                    local0\Field34 = 0.0
                                    local0\Field35 = 0.0
                                EndIf
                                If (local19 <> 0) Then
                                    If (0.65 > local6) Then
                                        If ((((0.0 <= killtimer) And (godmode = $00)) And (local0\Field74 = networkserver\Field28)) <> 0) Then
                                            Select playerroom\Field7\Field11
                                                Case "lockroom","room2closets","coffin"
                                                    deathmsg = "Subject D-9341. Cause of death: Fatal cervical fracture. The surveillance tapes confirm that the subject was killed by SCP-173."
                                                Case "173"
                                                    deathmsg = "Subject D-9341. Cause of death: Fatal cervical fracture. According to Security Chief Franklin who was present at SCP-173's containment "
                                                    deathmsg = (deathmsg + "chamber during the breach, the subject was killed by SCP-173 as soon as the disruptions in the electrical network started.")
                                                Case "room2doors"
                                                    deathmsg = (chr($22) + "If I'm not mistaken, one of the main purposes of these rooms was to stop SCP-173 from moving further in the event of a containment breach. ")
                                                    deathmsg = ((deathmsg + "So, who's brilliant idea was it to put A GODDAMN MAN-SIZED VENTILATION DUCT in there?") + chr($22))
                                                Default
                                                    deathmsg = "Subject D-9341. Cause of death: Fatal cervical fracture. Assumed to be attacked by SCP-173."
                                            End Select
                                            playsound_strict(necksnapsfx(rand($00, $02)))
                                            multiplayer_writesound(necksnapsfx(rand($00, $02)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                            If (rand($02, $01) = $01) Then
                                                turnentity(camera, 0.0, (Float rand($50, $64)), 0.0, $00)
                                            Else
                                                turnentity(camera, 0.0, (Float rand($FFFFFF9C, $FFFFFFB0)), 0.0, $00)
                                            EndIf
                                            kill("was killed by SCP-173", $00)
                                        Else
                                            givedamage(local0\Field74, -1.0)
                                        EndIf
                                    Else
                                        pointentity(local0\Field4, local0\Field73, 0.0)
                                        rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $00)
                                        translateentity(local0\Field4, ((cos((entityyaw(local0\Field4, $00) + 90.0)) * local0\Field21) * fpsfactor), 0.0, ((sin((entityyaw(local0\Field4, $00) + 90.0)) * local0\Field21) * fpsfactor), $00)
                                    EndIf
                                ElseIf (0.0 <> local0\Field33) Then
                                    If (0.5 < distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field33, local0\Field35)) Then
                                        aligntovector(local0\Field4, (local0\Field33 - entityx(local0\Field4, $00)), 0.0, (local0\Field35 - entityz(local0\Field4, $00)), $03, 1.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field21 * fpsfactor))
                                        If (rand($1F4, $01) = $01) Then
                                            local0\Field33 = 0.0
                                            local0\Field34 = 0.0
                                            local0\Field35 = 0.0
                                        EndIf
                                    Else
                                        local0\Field33 = 0.0
                                        local0\Field34 = 0.0
                                        local0\Field35 = 0.0
                                    EndIf
                                Else
                                    If (rand($190, $01) = $01) Then
                                        rotateentity(local0\Field4, 0.0, rnd(360.0, 0.0), 10.0, $00)
                                    EndIf
                                    translateentity(local0\Field4, ((cos((entityyaw(local0\Field4, $00) + 90.0)) * local0\Field21) * fpsfactor), 0.0, ((sin((entityyaw(local0\Field4, $00) + 90.0)) * local0\Field21) * fpsfactor), $00)
                                EndIf
                            EndIf
                        EndIf
                        positionentity(local0\Field4, entityx(local0\Field4, $00), min(entityy(local0\Field4, $00), 0.35), entityz(local0\Field4, $00), $00)
                    Else
                        If (local0\Field31 <> Null) Then
                            local27 = $00
                            If (local6 > (hidedistance * 0.7)) Then
                                If (entityvisible(local0\Field0, local0\Field73) = $00) Then
                                    local27 = $01
                                EndIf
                            EndIf
                            If (local27 = $00) Then
                                pointentity(local0\Field0, local0\Field31\Field4, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                local6 = entitydistance(local0\Field4, local0\Field31\Field4)
                                moveentity(local0\Field4, 0.0, 0.0, ((0.016 * fpsfactor) * max(min((((local6 * 2.0) - 1.0) * 0.5), 1.0), -0.5)))
                                local0\Field44 = 1.0
                            Else
                                positionentity(local0\Field4, entityx(local0\Field31\Field4, $00), (entityy(local0\Field31\Field4, $00) + 0.3), entityz(local0\Field31\Field4, $00), $00)
                                resetentity(local0\Field4)
                                local0\Field7 = 0.0
                                local0\Field44 = 0.0
                            EndIf
                        EndIf
                        positionentity(local0\Field0, entityx(local0\Field4, $00), ((entityy(local0\Field4, $00) + 0.05) + (sin(((Float millisecs2()) * 0.08)) * 0.02)), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                        showentity(local0\Field1)
                        positionentity(local0\Field1, entityx(local0\Field4, $00), ((entityy(local0\Field4, $00) - 0.05) + (sin(((Float millisecs2()) * 0.08)) * 0.02)), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                    EndIf
                EndIf
            Case $02
                If (contained106 <> 0) Then
                    local0\Field24 = 1.0
                    hideentity(local0\Field0)
                    hideentity(local0\Field1)
                    positionentity(local0\Field0, 0.0, 500.0, 0.0, $01)
                Else
                    local6 = entitydistance(local0\Field4, local0\Field73)
                    local28 = $01
                    If (player[local0\Field74]\Field46 <> "pocketdimension") Then
                        If (pocketdimension106\Field14 > $00) Then
                            If (playerinroom(pocketdimension106) <> 0) Then
                                local28 = $00
                            EndIf
                        EndIf
                    ElseIf (50.0 < entitydistance(local0\Field73, local0\Field4)) Then
                        local28 = $00
                    EndIf
                    If (player[local0\Field74]\Field46 = "dimension1499") Then
                        local28 = $00
                    EndIf
                    If (room860event <> Null) Then
                        If (1.0 = room860event\Field2) Then
                            local28 = $00
                        EndIf
                    EndIf
                    If (gateaevent <> Null) Then
                        If (0.0 <> gateaevent\Field2) Then
                            local28 = $01
                            If (player[local0\Field74]\Field46 = "dimension1499") Then
                                local0\Field24 = 1.0
                            Else
                                local0\Field24 = 0.0
                            EndIf
                        EndIf
                    EndIf
                    If (((local28 = $00) And (0.0 >= local0\Field9)) <> 0) Then
                        local0\Field9 = (Float rand($55F0, $6978))
                        positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                        resetentity(local0\Field4)
                    EndIf
                    If (-300.0 > falltimer) Then
                        movetopocketdimension()
                    EndIf
                    If (((0.0 = local0\Field24) And local28) <> 0) Then
                        If (0.0 >= local0\Field9) Then
                            If (((((entityy(local0\Field73, $00) - 20.0) - 0.55) > entityy(local0\Field4, $00)) And (channelplaying(local0\Field96) = $00)) <> 0) Then
                                If (room[player[local0\Field74]\Field47] <> Null) Then
                                    If (room[player[local0\Field74]\Field47]\Field7\Field14 = $00) Then
                                        local3 = createdecal($00, entityx(local0\Field73, $00), 0.01, entityz(local0\Field73, $00), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                        local3\Field2 = 0.05
                                        local3\Field1 = 0.001
                                        entityalpha(local3\Field0, 0.8)
                                        updatedecals()
                                    EndIf
                                EndIf
                                local0\Field29 = entityy(local0\Field73, $00)
                                setanimtime(local0\Field0, 110.0, $00)
                                If (player[local0\Field74]\Field46 <> "coffin") Then
                                    positionentity(local0\Field4, entityx(local0\Field73, $00), (entityy(local0\Field73, $00) - 15.0), entityz(local0\Field73, $00), $00)
                                EndIf
                                If (8.0 > entitydistance(local0\Field4, collider)) Then
                                    local0\Field96 = playsound_strict(decaysfx($00))
                                EndIf
                            EndIf
                            If (rand($1F4, $01) = $01) Then
                                playsound2(oldmansfx(rand($00, $02)), camera, local0\Field4, 10.0, 1.0)
                            EndIf
                            local0\Field17 = loopsound2(oldmansfx($04), local0\Field17, camera, local0\Field4, 8.0, 0.8)
                            If (-10.0 < local0\Field9) Then
                                If (8.0 > entitydistance(local0\Field4, collider)) Then
                                    shouldplay = $42
                                EndIf
                                If (259.0 > local0\Field14) Then
                                    positionentity(local0\Field4, entityx(local0\Field4, $00), (local0\Field29 - 0.15), entityz(local0\Field4, $00), $00)
                                    pointentity(local0\Field0, local0\Field73, 0.0)
                                    rotateentity(local0\Field4, 0.0, curvevalue(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 100.0), 0.0, $01)
                                    animatenpc(local0, 110.0, 259.0, 0.15, $00)
                                Else
                                    local0\Field9 = -10.0
                                EndIf
                            Else
                                If (((playerroom\Field7\Field11 <> "gatea") And (8.0 > entitydistance(local0\Field4, collider))) <> 0) Then
                                    shouldplay = $0A
                                EndIf
                                local29 = $00
                                If (8.0 > local6) Then
                                    local29 = entityvisible(local0\Field4, local0\Field73)
                                EndIf
                                If (notarget <> 0) Then
                                    local29 = $00
                                EndIf
                                If (local29 <> 0) Then
                                    If (player[local0\Field74]\Field46 <> "gatea") Then
                                        local0\Field38 = 0.0
                                    EndIf
                                    If (entityinview(local0\Field4, camera) <> 0) Then
                                        giveachievement($07, $01)
                                        blurvolume = max(max(min(((4.0 - local6) / 6.0), 0.9), 0.1), blurvolume)
                                        currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 20.0) * max(((4.0 - local6) / 4.0), 0.0)))
                                        If ((millisecs2() - local0\Field26) > $EA60) Then
                                            currcamerazoom = 40.0
                                            playsound_strict(horrorsfx($06))
                                            local0\Field26 = millisecs2()
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field9 = (local0\Field9 - fpsfactor)
                                EndIf
                                If (0.8 < local6) Then
                                    If ((((((25.0 < local6) Or (player[local0\Field74]\Field46 = "pocketdimension")) Or local29) Or (local0\Field37 <> $01)) And (player[local0\Field74]\Field46 <> "gatea")) <> 0) Then
                                        If (((40.0 < local6) Or (player[local0\Field74]\Field46 = "pocketdimension")) <> 0) Then
                                            translateentity(local0\Field4, 0.0, (((entityy(local0\Field73, $00) - 0.14) - entityy(local0\Field4, $00)) / 50.0), 0.0, $00)
                                        EndIf
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                        pointentity(local0\Field0, local0\Field73, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        If (0.0 <= killtimer) Then
                                            local12 = local0\Field14
                                            animatenpc(local0, 284.0, 333.0, (local0\Field22 * 43.0), $01)
                                            If (((286.0 >= local12) And (286.0 < local0\Field14)) <> 0) Then
                                                playsound2(step2sfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                                            ElseIf (((311.0 >= local12) And (311.0 < local0\Field14)) <> 0) Then
                                                playsound2(step2sfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                                            EndIf
                                        Else
                                            local0\Field22 = 0.0
                                        EndIf
                                        local0\Field38 = max((local0\Field38 - fpsfactor), 0.0)
                                        If (0.0 >= local0\Field38) Then
                                            local0\Field37 = findpath(local0, entityx(local0\Field73, $01), entityy(local0\Field73, $01), entityz(local0\Field73, $01))
                                            local0\Field38 = 700.0
                                        EndIf
                                    ElseIf (0.0 >= local0\Field38) Then
                                        local0\Field37 = findpath(local0, entityx(local0\Field73, $01), entityy(local0\Field73, $01), entityz(local0\Field73, $01))
                                        local0\Field38 = 700.0
                                        local0\Field22 = 0.0
                                    Else
                                        local0\Field38 = max((local0\Field38 - fpsfactor), 0.0)
                                        If (local0\Field37 = $02) Then
                                            local0\Field22 = 0.0
                                        ElseIf (local0\Field37 = $01) Then
                                            While (local0\Field36[local0\Field39] = Null)
                                                If (local0\Field39 > $13) Then
                                                    local0\Field39 = $00
                                                    local0\Field37 = $00
                                                    Exit
                                                Else
                                                    local0\Field39 = (local0\Field39 + $01)
                                                EndIf
                                            Wend
                                            If (local0\Field36[local0\Field39] <> Null) Then
                                                translateentity(local0\Field4, 0.0, (((entityy(local0\Field36[local0\Field39]\Field0, $01) - 0.11) - entityy(local0\Field4, $00)) / 50.0), 0.0, $00)
                                                pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                                local7 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), min(20.0, (local7 * 10.0))), 0.0, $00)
                                                local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                                local12 = animtime(local0\Field0)
                                                animatenpc(local0, 284.0, 333.0, (local0\Field22 * 43.0), $01)
                                                If (((286.0 >= local12) And (286.0 < local0\Field14)) <> 0) Then
                                                    playsound2(step2sfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                                                ElseIf (((311.0 >= local12) And (311.0 < local0\Field14)) <> 0) Then
                                                    playsound2(step2sfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                                                EndIf
                                                If (0.2 > local7) Then
                                                    local0\Field39 = (local0\Field39 + $01)
                                                EndIf
                                            EndIf
                                        ElseIf (local0\Field37 = $00) Then
                                            If (0.0 = local0\Field11) Then
                                                animatenpc(local0, 334.0, 494.0, 0.3, $01)
                                            EndIf
                                            local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                                        EndIf
                                    EndIf
                                ElseIf (((player[local0\Field74]\Field46 <> "gatea") And (notarget = $00)) <> 0) Then
                                    If (0.5 < local6) Then
                                        local0\Field22 = curvevalue((local0\Field21 * 2.5), local0\Field22, 10.0)
                                    Else
                                        local0\Field22 = 0.0
                                    EndIf
                                    animatenpc(local0, 105.0, 110.0, 0.15, $00)
                                    If (local0\Field74 = networkserver\Field28) Then
                                        pointentity(local0\Field0, local0\Field73, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        If (((0.0 <= killtimer) And (0.0 <= falltimer)) <> 0) Then
                                            If (((110.0 = ceil(local0\Field14)) And (godmode = $00)) <> 0) Then
                                                playsound_strict(damagesfx($01))
                                                playsound_strict(horrorsfx($05))
                                                multiplayer_writesound(damagesfx($01), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                                If (player[local0\Field74]\Field46 = "pocketdimension") Then
                                                    deathmsg = (((("Subject D-9341. Body partially decomposed by what is assumed to be SCP-106's " + chr($22)) + "corrosion") + chr($22)) + " effect. Body disposed of via incineration.")
                                                    kill("was killed by SCP-106", $00)
                                                Else
                                                    playsound_strict(oldmansfx($03))
                                                    falltimer = min(-1.0, falltimer)
                                                    positionentity(head, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
                                                    resetentity(head)
                                                    rotateentity(head, 0.0, (entityyaw(camera, $00) + (Float rand($FFFFFFD3, $2D))), 0.0, $00)
                                                EndIf
                                            EndIf
                                        EndIf
                                    Else
                                        givedamage(local0\Field74, -1.0)
                                    EndIf
                                EndIf
                            EndIf
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                            If ((Float rand($FFFFF254, $FFFFF448)) >= local0\Field9) Then
                                If ((entityinview(local0\Field0, getplayercamera(local0\Field74)) And (5.0 < local6)) = $00) Then
                                    local0\Field9 = (Float rand($55F0, $6978))
                                    positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                                EndIf
                            EndIf
                            If (0.0 = local0\Field25) Then
                                If (((((10.0 < local6) And (player[local0\Field74]\Field46 <> "pocketdimension")) And (player[local0\Field74]\Field46 <> "gatea")) And (-5.0 > local0\Field9)) <> 0) Then
                                    If (entityinview(local0\Field0, getplayercamera(local0\Field74)) = $00) Then
                                        turnentity(local0\Field73, 0.0, 180.0, 0.0, $00)
                                        local30 = entitypick(local0\Field73, 5.0)
                                        turnentity(local0\Field73, 0.0, 180.0, 0.0, $00)
                                        If (local30 <> $00) Then
                                            teleportentity(local0\Field4, pickedx(), pickedy(), pickedz(), local0\Field68, $00, 2.0, $00)
                                            pointentity(local0\Field4, local0\Field73, 0.0)
                                            rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                                            moveentity(local0\Field4, 0.0, 0.0, -2.0)
                                            playsound2(oldmansfx($03), camera, local0\Field4, 10.0, 1.0)
                                            local0\Field20 = playsound2(oldmansfx((rand($00, $02) + $06)), camera, local0\Field4, 10.0, 1.0)
                                            local0\Field38 = 0.0
                                            local0\Field25 = (700.0 / (Float (selecteddifficulty\Field5 + $01)))
                                            debuglog((("Teleported 106 (Distance: " + (Str entitydistance(local0\Field4, local0\Field73))) + ")"))
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            local0\Field25 = max(0.0, (local0\Field25 - fpsfactor))
                            updatesoundorigin(local0\Field20, camera, local0\Field4, 10.0, 1.0)
                        Else
                            local0\Field22 = 0.0
                            moveentity(local0\Field4, 0.0, (((entityy(local0\Field73, $00) - 30.0) - entityy(local0\Field4, $00)) / 200.0), 0.0)
                            local0\Field7 = 0.0
                            local0\Field14 = 110.0
                            If (room[player[local0\Field74]\Field47] <> Null) Then
                                If (room[player[local0\Field74]\Field47]\Field7\Field14 = $00) Then
                                    If (player[local0\Field74]\Field46 <> "gatea") Then
                                        If (selecteddifficulty\Field3 <> 0) Then
                                            local0\Field9 = (local0\Field9 - (fpsfactor * 2.0))
                                        Else
                                            local0\Field9 = (local0\Field9 - fpsfactor)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        resetentity(local0\Field4)
                        local0\Field7 = 0.0
                        positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.15), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                        positionentity(local0\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                        rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                        moveentity(local0\Field1, 0.0, 0.946, -0.165)
                        If (((playerroom\Field7\Field11 = "pocketdimension") Or (playerroom\Field7\Field11 = "gatea")) <> 0) Then
                            hideentity(local0\Field1)
                        ElseIf (((camerafogfar * lightvolume) * 0.6) > entitydistance(camera, local0\Field4)) Then
                            hideentity(local0\Field1)
                        Else
                            showentity(local0\Field1)
                            entityalpha(local0\Field1, min((local6 - ((camerafogfar * lightvolume) * 0.6)), 1.0))
                        EndIf
                    Else
                        hideentity(local0\Field1)
                    EndIf
                EndIf
            Case $09
                local6 = entitydistance(local0\Field73, local0\Field4)
                Select local0\Field9
                    Case 0.0
                        If (8.0 > local6) Then
                            giveachievement($06, $01)
                            If (local0\Field17 = $00) Then
                                local0\Field17 = streamsound_strict("SFX\Music\096.ogg", 0.0, $02)
                                local0\Field70 = $01
                            Else
                                updatestreamsoundorigin(local0\Field17, camera, local0\Field4, 8.0, 1.0)
                            EndIf
                            If (-1.0 = local0\Field11) Then
                                animatenpc(local0, 936.0, 1263.0, 0.1, $00)
                                If (1262.9 <= local0\Field14) Then
                                    local0\Field9 = 5.0
                                    local0\Field11 = 0.0
                                    local0\Field14 = 312.0
                                EndIf
                            Else
                                animatenpc(local0, 936.0, 1263.0, 0.1, $01)
                                If (420.0 > local0\Field11) Then
                                    local0\Field11 = (local0\Field11 + fpsfactor)
                                ElseIf (rand($01, $05) = $01) Then
                                    local0\Field11 = -1.0
                                Else
                                    local0\Field11 = (Float (rand($00, $03) * $46))
                                EndIf
                            EndIf
                            If (networkserver\Field18 <> 0) Then
                                If (notarget = $00) Then
                                    For local5 = $01 To networkserver\Field14 Step $01
                                        If (player[local5] <> Null) Then
                                            If (player[local5]\Field33 = $00) Then
                                                local8 = wrapangle(deltayaw(local0\Field4, getplayercamera(local5)))
                                                If (((90.0 > local8) Or (270.0 < local8)) <> 0) Then
                                                    cameraproject(getplayercamera(local5), entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.25), entityz(local0\Field4, $00))
                                                    If (((0.0 < projectedx()) And (projectedx() < (Float player[local5]\Field75))) <> 0) Then
                                                        If (((0.0 < projectedy()) And (projectedy() < (Float player[local5]\Field76))) <> 0) Then
                                                            If (entityvisible(player[local5]\Field13, local0\Field4) <> 0) Then
                                                                If (((-16.0 > player[local5]\Field31) Or (-6.0 < player[local5]\Field31)) <> 0) Then
                                                                    If (channelplaying(local0\Field84) = $00) Then
                                                                        local0\Field84 = playsound_strict(triggered096sfx)
                                                                    EndIf
                                                                    currcamerazoom = 10.0
                                                                    local0\Field14 = 194.0
                                                                    stopstream_strict(local0\Field17)
                                                                    local0\Field17 = $00
                                                                    local0\Field16 = $00
                                                                    local0\Field9 = 1.0
                                                                    local0\Field11 = 0.0
                                                                    Exit
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        Else
                            If (local0\Field17 <> $00) Then
                                stopstream_strict(local0\Field17)
                                local0\Field70 = $00
                                local0\Field17 = $00
                            EndIf
                            If (local0\Field20 <> $00) Then
                                stopstream_strict(local0\Field20)
                                local0\Field71 = $00
                                local0\Field20 = $00
                            EndIf
                        EndIf
                    Case 4.0
                        currcamerazoom = curvevalue(max(currcamerazoom, ((sin(((Float millisecs2()) / 20.0)) + 1.0) * 10.0)), currcamerazoom, 8.0)
                        If (local0\Field31 = Null) Then
                            If (local0\Field17 = $00) Then
                                local0\Field17 = streamsound_strict("SFX\SCP\096\Scream.ogg", 0.0, $02)
                                local0\Field70 = $01
                            Else
                                updatestreamsoundorigin(local0\Field17, camera, local0\Field4, 7.5, 1.0)
                            EndIf
                            If (local0\Field20 = $00) Then
                                local0\Field20 = streamsound_strict("SFX\Music\096Chase.ogg", 0.0, $02)
                                local0\Field71 = $02
                            Else
                                setstreamvolume_strict(local0\Field20, (min(max((8.0 - local6), 0.6), 1.0) * sfxvolume))
                            EndIf
                        EndIf
                        If ((notarget And (local0\Field31 = Null)) <> 0) Then
                            local0\Field9 = 5.0
                        EndIf
                        If ((Float millisecs2()) > local0\Field95) Then
                            local0\Field26 = $00
                            If (local0\Field31 = Null) Then
                                If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                    local0\Field26 = $01
                                EndIf
                            ElseIf (entityvisible(local0\Field31\Field4, local0\Field4) <> 0) Then
                                local0\Field26 = $01
                            EndIf
                            local0\Field95 = (Float (millisecs2() + $BB8))
                        EndIf
                        If (local0\Field26 = $01) Then
                            local0\Field38 = max(210.0, local0\Field38)
                            local0\Field37 = $00
                            If (local0\Field31 <> Null) Then
                                local6 = entitydistance(local0\Field31\Field4, local0\Field4)
                            EndIf
                            If (local0\Field97 <> $00) Then
                                local6 = entitydistance(player[local0\Field97]\Field13, local0\Field4)
                            EndIf
                            If (((2.8 > local6) Or (150.0 > local0\Field14)) <> 0) Then
                                If (193.0 < local0\Field14) Then
                                    local0\Field14 = 2.0
                                EndIf
                                animatenpc(local0, 2.0, 193.0, 0.7, $01)
                                If (1.0 < local6) Then
                                    local0\Field22 = curvevalue((local0\Field21 * 2.0), local0\Field22, 15.0)
                                Else
                                    local0\Field22 = 0.0
                                    If (local0\Field31 = Null) Then
                                        If (godmode = $00) Then
                                            If (local0\Field74 = networkserver\Field28) Then
                                                If (player_isdead() = $00) Then
                                                    playsound_strict(damagesfx($04))
                                                    multiplayer_writesound(damagesfx($04), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                                    local25 = createpivot($00)
                                                    camerashake = 30.0
                                                    blurtimer = 2000.0
                                                    deathmsg = "A large amount of blood found in [DATA REDACTED]. DNA indentified as Subject D-9341. Most likely [DATA REDACTED] by SCP-096."
                                                    kill("was killed by SCP-096", $00)
                                                    killanim = $01
                                                    For local5 = $00 To $06 Step $01
                                                        positionentity(local25, (entityx(local0\Field73, $00) + rnd(-0.1, 0.1)), (entityy(local0\Field73, $00) - 0.05), (entityz(local0\Field73, $00) + rnd(-0.1, 0.1)), $00)
                                                        turnentity(local25, 90.0, 0.0, 0.0, $00)
                                                        entitypick(local25, 0.3)
                                                        local3 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                                        local3\Field2 = rnd(0.2, 0.6)
                                                        entityalpha(local3\Field0, 1.0)
                                                        scalesprite(local3\Field0, local3\Field2, local3\Field2)
                                                        multiplayer_writedecal(local3, $01, $01)
                                                    Next
                                                    freeentity(local25)
                                                    myplayer\Field33 = $01
                                                EndIf
                                            Else
                                                givedamage(local0\Field74, -1.0)
                                            EndIf
                                        EndIf
                                        If (player[local0\Field97]\Field33 <> 0) Then
                                            local0\Field9 = 0.0
                                            If (local0\Field17 <> $00) Then
                                                stopstream_strict(local0\Field17)
                                                local0\Field70 = $00
                                                local0\Field17 = $00
                                            EndIf
                                            If (local0\Field20 <> $00) Then
                                                stopstream_strict(local0\Field20)
                                                local0\Field71 = $00
                                                local0\Field20 = $00
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                                If (local0\Field31 = Null) Then
                                    pointentity(local0\Field4, local0\Field73, 0.0)
                                Else
                                    pointentity(local0\Field4, local0\Field31\Field4, 0.0)
                                EndIf
                            Else
                                If (local0\Field31 = Null) Then
                                    pointentity(local0\Field0, local0\Field73, 0.0)
                                Else
                                    pointentity(local0\Field0, local0\Field31\Field4, 0.0)
                                EndIf
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 5.0), 0.0, $00)
                                If (847.0 < local0\Field14) Then
                                    local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                EndIf
                                If (906.0 > local0\Field14) Then
                                    animatenpc(local0, 737.0, 906.0, (local0\Field21 * 8.0), $00)
                                Else
                                    animatenpc(local0, 907.0, 935.0, (local0\Field22 * 8.0), $01)
                                EndIf
                            EndIf
                            rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                        ElseIf (local0\Field37 = $01) Then
                            If (local0\Field36[local0\Field39] = Null) Then
                                If (local0\Field39 > $13) Then
                                    local0\Field39 = $00
                                    local0\Field37 = $00
                                Else
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            Else
                                pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 5.0), 0.0, $00)
                                If (847.0 < local0\Field14) Then
                                    local0\Field22 = curvevalue((local0\Field21 * 1.5), local0\Field22, 15.0)
                                EndIf
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                If (906.0 > local0\Field14) Then
                                    animatenpc(local0, 737.0, 906.0, (local0\Field21 * 8.0), $00)
                                Else
                                    animatenpc(local0, 907.0, 935.0, (local0\Field22 * 8.0), $01)
                                EndIf
                                local7 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                If (0.8 > local7) Then
                                    If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                        If (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                            local0\Field36[local0\Field39]\Field1\Field5 = $01
                                            local0\Field36[local0\Field39]\Field1\Field8 = $01
                                            playsound2(opendoorfastsfx, camera, local0\Field36[local0\Field39]\Field1\Field0, 10.0, 1.0)
                                        EndIf
                                    EndIf
                                    If (0.7 > local7) Then
                                        local0\Field39 = (local0\Field39 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        Else
                            animatenpc(local0, 737.0, 822.0, 0.2, $01)
                            local0\Field38 = max(0.0, (local0\Field38 - fpsfactor))
                            If (0.0 >= local0\Field38) Then
                                If (local0\Field31 <> Null) Then
                                    local0\Field37 = findpath(local0, entityx(local0\Field31\Field4, $00), (entityy(local0\Field31\Field4, $00) + 0.2), entityz(local0\Field31\Field4, $00))
                                Else
                                    local0\Field37 = findpath(local0, entityx(local0\Field73, $00), (entityy(local0\Field73, $00) + 0.2), entityz(local0\Field73, $00))
                                EndIf
                                local0\Field38 = 350.0
                            EndIf
                        EndIf
                        If (((32.0 < local6) Or (-50.0 > entityy(local0\Field4, $00))) <> 0) Then
                            If (rand($32, $01) = $01) Then
                                teleportcloser(local0)
                            EndIf
                        EndIf
                    Case 1.0,2.0,3.0
                        If (local0\Field17 = $00) Then
                            local0\Field17 = streamsound_strict("SFX\Music\096Angered.ogg", 0.0, $02)
                            local0\Field70 = $01
                        Else
                            updatestreamsoundorigin(local0\Field17, camera, local0\Field4, 10.0, 1.0)
                        EndIf
                        If (1.0 = local0\Field9) Then
                            If (312.0 > local0\Field14) Then
                                animatenpc(local0, 193.0, 311.0, 0.3, $00)
                                If (310.9 < local0\Field14) Then
                                    local0\Field9 = 2.0
                                    local0\Field14 = 737.0
                                EndIf
                            ElseIf (((312.0 <= local0\Field14) And (422.0 >= local0\Field14)) <> 0) Then
                                animatenpc(local0, 312.0, 422.0, 0.3, $00)
                                If (421.9 < local0\Field14) Then
                                    local0\Field14 = 677.0
                                EndIf
                            Else
                                animatenpc(local0, 677.0, 736.0, 0.3, $00)
                                If (735.9 < local0\Field14) Then
                                    local0\Field9 = 2.0
                                    local0\Field14 = 737.0
                                EndIf
                            EndIf
                        ElseIf (2.0 = local0\Field9) Then
                            animatenpc(local0, 737.0, 822.0, 0.3, $00)
                            If (822.0 <= local0\Field14) Then
                                local0\Field9 = 3.0
                                local0\Field10 = 0.0
                            EndIf
                        ElseIf (3.0 = local0\Field9) Then
                            local0\Field10 = (local0\Field10 + fpsfactor)
                            If (1260.0 < local0\Field10) Then
                                animatenpc(local0, 823.0, 847.0, (local0\Field21 * 8.0), $00)
                                If (846.9 < local0\Field14) Then
                                    local0\Field9 = 4.0
                                    stopstream_strict(local0\Field17)
                                    local0\Field17 = $00
                                EndIf
                            Else
                                animatenpc(local0, 737.0, 822.0, 0.3, $01)
                            EndIf
                        EndIf
                    Case 5.0
                        If (16.0 > local6) Then
                            If (4.0 > local6) Then
                                giveachievement($06, $01)
                            EndIf
                            If (local0\Field17 = $00) Then
                                local0\Field17 = streamsound_strict("SFX\Music\096.ogg", 0.0, $02)
                                local0\Field70 = $01
                            Else
                                updatestreamsoundorigin(local0\Field17, camera, local0\Field4, 14.0, 1.0)
                            EndIf
                            If (422.0 <= local0\Field14) Then
                                local0\Field10 = (local0\Field10 + fpsfactor)
                                If (1000.0 < local0\Field10) Then
                                    If (1600.0 < local0\Field10) Then
                                        local0\Field10 = (Float rand($00, $1F4))
                                    EndIf
                                    If (1382.0 > local0\Field14) Then
                                        local0\Field22 = curvevalue((local0\Field21 * 0.1), local0\Field22, 5.0)
                                        animatenpc(local0, 1369.0, 1382.0, (local0\Field22 * 45.0), $00)
                                    Else
                                        local0\Field22 = curvevalue((local0\Field21 * 0.1), local0\Field22, 5.0)
                                        animatenpc(local0, 1383.0, 1456.0, (local0\Field22 * 45.0), $01)
                                    EndIf
                                    If ((Float millisecs2()) > local0\Field95) Then
                                        local0\Field26 = $00
                                        If (entityvisible(local0\Field73, local0\Field4) <> 0) Then
                                            local0\Field26 = $01
                                        Else
                                            hideentity(local0\Field4)
                                            entitypick(local0\Field4, 1.5)
                                            If (pickedentity() <> $00) Then
                                                local0\Field15 = (entityyaw(local0\Field4, $00) + rnd(80.0, 110.0))
                                            EndIf
                                            showentity(local0\Field4)
                                        EndIf
                                        local0\Field95 = (Float (millisecs2() + $BB8))
                                    EndIf
                                    If (local0\Field26 <> 0) Then
                                        pointentity(local0\Field0, local0\Field73, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 130.0), 0.0, $00)
                                        If (1.5 > local6) Then
                                            local0\Field10 = 0.0
                                        EndIf
                                    Else
                                        rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 50.0), 0.0, $00)
                                    EndIf
                                ElseIf (472.0 < local0\Field14) Then
                                    local0\Field22 = curvevalue((local0\Field21 * 0.05), local0\Field22, 8.0)
                                    animatenpc(local0, 1383.0, 1469.0, (local0\Field22 * 45.0), $00)
                                    If (1468.9 <= local0\Field14) Then
                                        local0\Field14 = 423.0
                                    EndIf
                                Else
                                    local0\Field22 = curvevalue(0.0, local0\Field22, 4.0)
                                    animatenpc(local0, 423.0, 471.0, 0.2, $01)
                                EndIf
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                            Else
                                animatenpc(local0, 312.0, 422.0, 0.3, $00)
                            EndIf
                            If (networkserver\Field18 <> 0) Then
                                If (notarget = $00) Then
                                    For local5 = $01 To networkserver\Field14 Step $01
                                        If (player[local5] <> Null) Then
                                            If (player[local5]\Field33 = $00) Then
                                                local8 = wrapangle(deltayaw(local0\Field4, getplayercamera(local5)))
                                                If (((55.0 > local8) Or (305.0 < local8)) <> 0) Then
                                                    cameraproject(getplayercamera(local5), entityx(local0\Field4, $00), ((entityy(player[local5]\Field13, $00) + 1.16) - 0.25), entityz(local0\Field4, $00))
                                                    If (((0.0 < projectedx()) And (projectedx() < (Float player[local5]\Field75))) <> 0) Then
                                                        If (((0.0 < projectedy()) And (projectedy() < (Float player[local5]\Field76))) <> 0) Then
                                                            If (entityvisible(player[local5]\Field13, local0\Field4) <> 0) Then
                                                                If (((-16.0 > player[local5]\Field31) Or (-6.0 < player[local5]\Field31)) <> 0) Then
                                                                    If (channelplaying(local0\Field84) = $00) Then
                                                                        local0\Field84 = playsound_strict(triggered096sfx)
                                                                    EndIf
                                                                    If (422.0 <= local0\Field14) Then
                                                                        local0\Field14 = 677.0
                                                                    EndIf
                                                                    stopstream_strict(local0\Field17)
                                                                    local0\Field17 = $00
                                                                    local0\Field16 = $00
                                                                    local0\Field9 = 2.0
                                                                    Exit
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        EndIf
                End Select
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.03), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
            Case $0A
                local12 = local0\Field14
                local6 = entitydistance(local0\Field73, local0\Field4)
                local0\Field49 = 1.0
                If (0.1 < local0\Field24) Then
                    If (player[local0\Field74]\Field46 <> "room049") Then
                        local0\Field24 = max((local0\Field24 - ((Float (selecteddifficulty\Field3 + $01)) * fpsfactor)), 0.1)
                    EndIf
                    local0\Field7 = 0.0
                    If (channelplaying(local0\Field17) <> 0) Then
                        stopchannel(local0\Field17)
                    EndIf
                    If (channelplaying(local0\Field20) <> 0) Then
                        stopchannel(local0\Field20)
                    EndIf
                    positionentity(local0\Field4, 0.0, -500.0, 0.0, $00)
                    positionentity(local0\Field0, 0.0, -500.0, 0.0, $00)
                Else
                    If (0.1 = local0\Field24) Then
                        If (otherplayerinreachableroom(local0\Field74, $00) <> 0) Then
                            If (room[player[local0\Field74]\Field47] <> Null) Then
                                For local5 = $00 To $03 Step $01
                                    If (room[player[local0\Field74]\Field47]\Field34[local5] <> Null) Then
                                        For local32 = $00 To $03 Step $01
                                            If (room[player[local0\Field74]\Field47]\Field34[local5]\Field34[local32] <> Null) Then
                                                teleportentity(local0\Field4, room[player[local0\Field74]\Field47]\Field34[local5]\Field34[local32]\Field3, 0.5, room[player[local0\Field74]\Field47]\Field34[local5]\Field34[local32]\Field5, local0\Field68, $01, 2.0, $00)
                                                Exit
                                            EndIf
                                        Next
                                        Exit
                                    EndIf
                                Next
                                local0\Field24 = 0.0
                                debuglog("SCP-049 not idle")
                            EndIf
                        EndIf
                    EndIf
                    Select local0\Field9
                        Case 0.0
                        Case 1.0
                            If (538.0 <= local0\Field14) Then
                                animatenpc(local0, 659.0, 538.0, -0.45, $00)
                                If (537.9 < local0\Field14) Then
                                    local0\Field14 = 37.0
                                EndIf
                            Else
                                animatenpc(local0, 37.0, 269.0, 0.7, $00)
                                If (268.9 < local0\Field14) Then
                                    local0\Field9 = 2.0
                                EndIf
                            EndIf
                        Case 2.0
                            If (((local6 < (hidedistance * 2.0)) And (0.0 = local0\Field24)) <> 0) Then
                                local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 10.0, 1.0)
                                local13 = menpcseesplayer(local0, $00)
                                If (((local13 = $01) Or (0.0 < local0\Field10)) <> 0) Then
                                    giveachievement($03, $01)
                                    If (((local0\Field12 <= $01) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                        If (local0\Field19 <> $00) Then
                                            freesound_strict(local0\Field19)
                                        EndIf
                                        local34 = rand($01, $07)
                                        local0\Field19 = loadsound_strict((("SFX\SCP\049\Spotted" + (Str local34)) + ".ogg"))
                                        local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                        local0\Field12 = $02
                                    EndIf
                                    local0\Field37 = $00
                                    local0\Field38 = 0.0
                                    local0\Field39 = $00
                                    If (local13 = $01) Then
                                        local0\Field10 = 140.0
                                    EndIf
                                    pointentity(local0\Field0, local0\Field73, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    If (0.6 > local6) Then
                                        If (local0\Field74 = networkserver\Field28) Then
                                            If (wearinghazmat > $00) Then
                                                blurtimer = ((fpsfactor * 2.5) + blurtimer)
                                                If ((((250.0 < blurtimer) And (250.0 >= (blurtimer - (fpsfactor * 2.5)))) And (local0\Field12 <> $03)) <> 0) Then
                                                    If (local0\Field20 <> $00) Then
                                                        stopchannel(local0\Field20)
                                                    EndIf
                                                    local0\Field20 = playsound_strict(loadtempsound("SFX\SCP\049\TakeOffHazmat.ogg"))
                                                    local0\Field12 = $03
                                                ElseIf (500.0 <= blurtimer) Then
                                                    For local5 = $00 To $09 Step $01
                                                        If (inventory(local5) <> Null) Then
                                                            If ((instr(inventory(local5)\Field3\Field2, "hazmatsuit", $01) And (wearinghazmat < $03)) <> 0) Then
                                                                If (3.0 > inventory(local5)\Field14) Then
                                                                    inventory(local5)\Field14 = (inventory(local5)\Field14 + 1.0)
                                                                    blurtimer = 260.0
                                                                    camerashake = 2.0
                                                                Else
                                                                    removeitem(inventory(local5), $01)
                                                                    wearinghazmat = $00
                                                                EndIf
                                                                Exit
                                                            EndIf
                                                        EndIf
                                                    Next
                                                EndIf
                                            ElseIf (wearing714 <> 0) Then
                                                blurtimer = ((fpsfactor * 2.5) + blurtimer)
                                                If ((((250.0 < blurtimer) And (250.0 >= (blurtimer - (fpsfactor * 2.5)))) And (local0\Field12 <> $03)) <> 0) Then
                                                    If (local0\Field20 <> $00) Then
                                                        stopchannel(local0\Field20)
                                                    EndIf
                                                    local0\Field20 = playsound_strict(loadtempsound("SFX\SCP\049\714Equipped.ogg"))
                                                    local0\Field12 = $03
                                                ElseIf (500.0 <= blurtimer) Then
                                                    wearing714 = $00
                                                EndIf
                                            Else
                                                currcamerazoom = 20.0
                                                blurtimer = 500.0
                                                If ((((godmode = $00) And (0.0 <= killtimer)) And (0.0 <= falltimer)) <> 0) Then
                                                    deathmsg = "An active instance of SCP-049-2 was discovered in [REDACTED]. Terminated by Nine-Tailed Fox."
                                                    kill("was killed by SCP-049", $00)
                                                    playsound_strict(horrorsfx($0D))
                                                    If (local0\Field19 <> $00) Then
                                                        freesound_strict(local0\Field19)
                                                    EndIf
                                                    local34 = rand($01, $02)
                                                    local0\Field19 = loadsound_strict((("SFX\SCP\049\Kidnap" + (Str local34)) + ".ogg"))
                                                    local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                                    local0\Field9 = 1.0
                                                EndIf
                                            EndIf
                                        Else
                                            givedamage(local0\Field74, -1.0)
                                        EndIf
                                    Else
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                        If (local0\Field12 = $03) Then
                                            local0\Field12 = $02
                                        EndIf
                                        If (3.0 > local6) Then
                                            animatenpc(local0, max(min(animtime(local0\Field0), 428.0), 387.0), 463.0, (local0\Field22 * 38.0), $01)
                                        ElseIf (428.0 < local0\Field14) Then
                                            animatenpc(local0, min(animtime(local0\Field0), 463.0), 498.0, (local0\Field22 * 38.0), $00)
                                            If (497.9 < local0\Field14) Then
                                                local0\Field14 = 358.0
                                            EndIf
                                        Else
                                            animatenpc(local0, max(min(animtime(local0\Field0), 358.0), 346.0), 393.0, (local0\Field22 * 38.0), $01)
                                        EndIf
                                    EndIf
                                ElseIf (local0\Field37 = $01) Then
                                    While (local0\Field36[local0\Field39] = Null)
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                            Exit
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Wend
                                    If (local0\Field36[local0\Field39] <> Null) Then
                                        If (networkserver\Field18 <> 0) Then
                                            If (local0\Field39 > $00) Then
                                                If (local0\Field36[(local0\Field39 - $01)] <> Null) Then
                                                    If (local0\Field36[(local0\Field39 - $01)]\Field1 <> Null) Then
                                                        If (local0\Field36[(local0\Field39 - $01)]\Field1\Field23 = $00) Then
                                                            If (0.3 < entitydistance(local0\Field36[(local0\Field39 - $01)]\Field0, local0\Field4)) Then
                                                                If (((local0\Field36[(local0\Field39 - $01)]\Field1\Field24 And local0\Field36[(local0\Field39 - $01)]\Field1\Field5) And ((local0\Field36[(local0\Field39 - $01)]\Field1\Field3[$00] <> $00) Or (local0\Field36[(local0\Field39 - $01)]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                                    usedoor(local0\Field36[(local0\Field39 - $01)]\Field1, $00, $01, $00, "", $00)
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                        local7 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                        If (0.6 > local7) Then
                                            local19 = $01
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                    If ((((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 <> $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) And (local0\Field36[local0\Field39]\Field1\Field5 = $00)) <> 0) Then
                                                        local19 = $00
                                                    ElseIf (((local0\Field36[local0\Field39]\Field1\Field5 = $00) And ((local0\Field36[local0\Field39]\Field1\Field3[$00] <> $00) Or (local0\Field36[local0\Field39]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                        If (networkserver\Field18 <> 0) Then
                                                            usedoor(local0\Field36[local0\Field39]\Field1, $00, $01, $00, "", $00)
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (((0.2 > local7) And local19) <> 0) Then
                                                local0\Field39 = (local0\Field39 + $01)
                                            ElseIf (((0.5 > local7) And (local19 = $00)) <> 0) Then
                                                local0\Field37 = $00
                                                local0\Field38 = 0.0
                                            EndIf
                                        EndIf
                                        animatenpc(local0, max(min(animtime(local0\Field0), 358.0), 346.0), 393.0, (local0\Field22 * 38.0), $01)
                                        If (((local0\Field12 = $00) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                            If (local0\Field19 <> $00) Then
                                                freesound_strict(local0\Field19)
                                            EndIf
                                            If (rand($1E, $01) = $01) Then
                                                local0\Field19 = loadsound_strict("SFX\SCP\049\Searching7.ogg")
                                            Else
                                                local34 = rand($01, $06)
                                                local0\Field19 = loadsound_strict((("SFX\SCP\049\Searching" + (Str local34)) + ".ogg"))
                                            EndIf
                                            local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                            local0\Field12 = $01
                                        EndIf
                                        If (((rand($258, $01) = $01) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                            local0\Field12 = $00
                                        EndIf
                                        If (local0\Field12 > $01) Then
                                            local0\Field12 = $01
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field38 = (local0\Field38 + fpsfactor)
                                    If ((Float (($05 - (selecteddifficulty\Field3 Shl $01)) * $46)) < local0\Field38) Then
                                        local0\Field37 = findpath(local0, entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00))
                                        local0\Field38 = 0.0
                                        local0\Field11 = 0.0
                                        If (local0\Field37 <> $01) Then
                                            local35 = entitydistance(room[player[local0\Field74]\Field47]\Field2, local0\Field4)
                                            local36 = room[player[local0\Field74]\Field47]
                                            local37 = 0.0
                                            For local5 = $00 To $03 Step $01
                                                If (room[player[local0\Field74]\Field47]\Field34[local5] <> Null) Then
                                                    local37 = entitydistance(room[player[local0\Field74]\Field47]\Field34[local5]\Field2, local0\Field4)
                                                    If (local35 > local37) Then
                                                        local35 = local37
                                                        local36 = room[player[local0\Field74]\Field47]\Field34[local5]
                                                    EndIf
                                                EndIf
                                            Next
                                            local0\Field37 = findpath(local0, entityx(local36\Field2, $00), 0.5, entityz(local36\Field2, $00))
                                            debuglog((("Find path for 049 in another room (pathstatus: " + (Str local0\Field37)) + ")"))
                                        EndIf
                                        While ((Int local0\Field11) < $03)
                                            If (local0\Field37 = $01) Then
                                                If (local0\Field36[$01] <> Null) Then
                                                    If (((local0\Field36[$02] = Null) And (0.4 > entitydistance(local0\Field36[$01]\Field0, local0\Field4))) <> 0) Then
                                                        local0\Field39 = $00
                                                        local0\Field37 = $00
                                                        debuglog("Breaking up path for 049 because no waypoint number 2 has been found and waypoint number 1 is too close.")
                                                    EndIf
                                                EndIf
                                                If (((local0\Field36[$00] <> Null) And (local0\Field36[$01] = Null)) <> 0) Then
                                                    local0\Field39 = $00
                                                    local0\Field37 = $00
                                                    debuglog("Breaking up path for 049 because no waypoint number 1 has been found.")
                                                EndIf
                                            EndIf
                                            If (local0\Field37 <> $01) Then
                                                local35 = 100.0
                                                local36 = playerroom
                                                local37 = 0.0
                                                For local5 = $00 To $03 Step $01
                                                    If (room[player[local0\Field74]\Field47]\Field34[local5] <> Null) Then
                                                        local37 = entitydistance(room[player[local0\Field74]\Field47]\Field34[local5]\Field2, local0\Field4)
                                                        If (local35 > local37) Then
                                                            local35 = local37
                                                            For local32 = $00 To $03 Step $01
                                                                If (room[player[local0\Field74]\Field47]\Field34[local5]\Field34[local32] <> Null) Then
                                                                    If (room[player[local0\Field74]\Field47]\Field34[local5]\Field34[local32] <> room[player[local0\Field74]\Field47]) Then
                                                                        local36 = room[player[local0\Field74]\Field47]\Field34[local5]\Field34[local32]
                                                                        Exit
                                                                    EndIf
                                                                EndIf
                                                            Next
                                                        EndIf
                                                    EndIf
                                                Next
                                                local0\Field37 = findpath(local0, entityx(local36\Field2, $00), 0.5, entityz(local36\Field2, $00))
                                                debuglog((("Find path for 049 in another further away room (pathstatus: " + (Str local0\Field37)) + ")"))
                                            EndIf
                                            If (local0\Field37 = $01) Then
                                                If (local0\Field36[$01] <> Null) Then
                                                    If (local0\Field36[$01]\Field1 <> Null) Then
                                                        If ((((local0\Field36[$01]\Field1\Field4 Or (local0\Field36[$01]\Field1\Field12 <> $00)) Or (local0\Field36[$01]\Field1\Field17 <> "")) And (local0\Field36[$01]\Field1\Field5 = $00)) <> 0) Then
                                                            Repeat
                                                                If (local0\Field39 > $13) Then
                                                                    local0\Field39 = $00
                                                                    local0\Field37 = $00
                                                                    Exit
                                                                Else
                                                                    local0\Field39 = (local0\Field39 + $01)
                                                                EndIf
                                                                If (local0\Field36[local0\Field39] <> Null) Then
                                                                    If ((45.0 - (Abs deltayaw(local0\Field4, local0\Field36[$01]\Field0))) < (Abs deltayaw(local0\Field4, local0\Field36[local0\Field39]\Field0))) Then
                                                                        debuglog(("Skip until waypoint number " + (Str local0\Field39)))
                                                                        local0\Field11 = 3.0
                                                                        Exit
                                                                    EndIf
                                                                EndIf
                                                            Forever
                                                        Else
                                                            local0\Field11 = 3.0
                                                        EndIf
                                                    Else
                                                        local0\Field11 = 3.0
                                                    EndIf
                                                EndIf
                                            EndIf
                                            local0\Field11 = (local0\Field11 + 1.0)
                                        Wend
                                    EndIf
                                    animatenpc(local0, 269.0, 345.0, 0.2, $01)
                                EndIf
                                If (0.005 < local0\Field22) Then
                                    If ((((361.0 > local12) And (361.0 <= local0\Field14)) Or ((377.0 > local12) And (377.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($03, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0))
                                    ElseIf ((((431.0 > local12) And (431.0 <= local0\Field14)) Or ((447.0 > local12) And (447.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($03, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0))
                                    EndIf
                                EndIf
                                If (channelplaying(local0\Field20) <> 0) Then
                                    updatesoundorigin(local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                EndIf
                            ElseIf (0.0 = local0\Field24) Then
                                If (channelplaying(local0\Field17) <> 0) Then
                                    stopchannel(local0\Field17)
                                EndIf
                                If ((otherplayerinreachableroom(local0\Field74, $01) And (infacility = $01)) <> 0) Then
                                    If (rand($01, ($03 - selecteddifficulty\Field5)) = $01) Then
                                        teleportcloser(local0)
                                        debuglog("SCP-049 teleported closer due to distance")
                                    Else
                                        local0\Field24 = 4200.0
                                        debuglog("SCP-049 is now idle")
                                    EndIf
                                EndIf
                            EndIf
                        Case 3.0
                            animatenpc(local0, 537.0, 660.0, 0.7, $00)
                            positionentity(local0\Field4, curvevalue(entityx(local0\Field73, $00), entityx(local0\Field4, $00), 20.0), entityy(local0\Field4, $00), curvevalue(entityz(local0\Field73, $00), entityz(local0\Field4, $00), 20.0), $00)
                            rotateentity(local0\Field4, 0.0, curveangle((entityyaw(local0\Field73, $00) - 180.0), entityyaw(local0\Field4, $00), 40.0), 0.0, $00)
                        Case 4.0
                            If (8.0 > local6) Then
                                animatenpc(local0, 18.0, 19.0, 0.05, $01)
                                pointentity(local0\Field0, local0\Field73, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 45.0), 0.0, $00)
                                local0\Field11 = 1.0
                            ElseIf (((local6 > (hidedistance * 0.8)) And (0.0 < local0\Field11)) <> 0) Then
                                local0\Field9 = 2.0
                                local0\Field11 = 0.0
                                For local4 = Each rooms
                                    If (4.0 > entitydistance(local4\Field2, local0\Field4)) Then
                                        teleportentity(local0\Field4, entityx(local4\Field2, $00), 0.1, entityz(local4\Field2, $00), local0\Field68, $01, 2.0, $00)
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Case 5.0
                            local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 10.0, 1.0)
                            local13 = menpcseesplayer(local0, $01)
                            If (local13 = $01) Then
                                local0\Field9 = 2.0
                                local0\Field37 = $00
                                local0\Field39 = $00
                                local0\Field38 = 0.0
                                local0\Field11 = 0.0
                                local0\Field10 = 140.0
                                local0\Field12 = $00
                                playsound_strict(loadtempsound("SFX\Room\Room2SL049Spawn.ogg"))
                            ElseIf (((local13 = $02) And (0.0 < local0\Field11)) <> 0) Then
                                local0\Field37 = findpath(local0, entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00))
                            Else
                                If (6.0 = local0\Field11) Then
                                    If (hidedistance < entitydistance(local0\Field4, local0\Field73)) Then
                                        local0\Field9 = 2.0
                                        local0\Field37 = $00
                                        local0\Field39 = $00
                                        local0\Field38 = 0.0
                                        local0\Field11 = 0.0
                                        local0\Field12 = $00
                                    ElseIf (local0\Field37 <> $01) Then
                                        local0\Field37 = findpath(local0, entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00))
                                    EndIf
                                EndIf
                                If (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                        If (local0\Field39 > $00) Then
                                            If (local0\Field36[(local0\Field39 - $01)] <> Null) Then
                                                If (local0\Field36[(local0\Field39 - $01)]\Field1 <> Null) Then
                                                    If (local0\Field36[(local0\Field39 - $01)]\Field1\Field12 = $00) Then
                                                        If (0.3 < entitydistance(local0\Field36[(local0\Field39 - $01)]\Field0, local0\Field4)) Then
                                                            If (local0\Field36[(local0\Field39 - $01)]\Field1\Field5 <> 0) Then
                                                                If (networkserver\Field18 <> 0) Then
                                                                    usedoor(local0\Field36[(local0\Field39 - $01)]\Field1, $00, $01, $00, "", $00)
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                        local7 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                        If (0.6 > local7) Then
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                    If (networkserver\Field18 <> 0) Then
                                                        usedoor(local0\Field36[local0\Field39]\Field1, $00, $01, $00, "", $00)
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (0.2 > local7) Then
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                        animatenpc(local0, max(min(animtime(local0\Field0), 358.0), 346.0), 393.0, (local0\Field22 * 38.0), $01)
                                    EndIf
                                Else
                                    Select local0\Field12
                                        Case $00
                                            animatenpc(local0, 269.0, 345.0, 0.2, $01)
                                        Case $01
                                            animatenpc(local0, 661.0, 891.0, 0.4, $00)
                                        Case $02
                                            animatenpc(local0, 892.0, 1119.0, 0.4, $00)
                                    End Select
                                EndIf
                            EndIf
                            If (playerroom\Field7\Field11 = "room2sl") Then
                                shouldplay = $14
                            EndIf
                            If (0.005 < local0\Field22) Then
                                If ((((361.0 > local12) And (361.0 <= local0\Field14)) Or ((377.0 > local12) And (377.0 <= local0\Field14))) <> 0) Then
                                    playsound2(stepsfx($03, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0))
                                ElseIf ((((431.0 > local12) And (431.0 <= local0\Field14)) Or ((447.0 > local12) And (447.0 <= local0\Field14))) <> 0) Then
                                    playsound2(stepsfx($03, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0))
                                EndIf
                            EndIf
                            If (channelplaying(local0\Field20) <> 0) Then
                                updatesoundorigin(local0\Field20, camera, local0\Field0, 10.0, 1.0)
                            EndIf
                    End Select
                EndIf
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.22), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                local0\Field26 = (Int max(((Float local0\Field26) - fpsfactor), 0.0))
                local0\Field10 = max((local0\Field10 - fpsfactor), 0.0)
            Case $0B
                If (4.0 > (Abs (entityy(local0\Field73, $00) - entityy(local0\Field4, $00)))) Then
                    local12 = local0\Field14
                    local0\Field48 = ((133.0 <= local0\Field91) And (157.0 >= local0\Field91))
                    If (local0\Field48 = $00) Then
                        Select local0\Field9
                            Case 0.0
                                animatenpc(local0, 719.0, 777.0, 0.2, $00)
                                If (777.0 = local0\Field14) Then
                                    If (rand($2BC, $01) = $01) Then
                                        If (5.0 > entitydistance(local0\Field73, local0\Field4)) Then
                                            local0\Field14 = 719.0
                                        EndIf
                                    EndIf
                                EndIf
                            Case 1.0
                                If (682.0 <= local0\Field14) Then
                                    animatenpc(local0, 926.0, 935.0, 0.3, $00)
                                    If (935.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                Else
                                    animatenpc(local0, 155.0, 682.0, 1.5, $00)
                                EndIf
                            Case 2.0
                                If (0.0 > local0\Field11) Then
                                    If (5.0 > entitydistance(local0\Field73, local0\Field4)) Then
                                        If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                            local0\Field10 = 350.0
                                        EndIf
                                    EndIf
                                    local0\Field11 = 210.0
                                Else
                                    local0\Field11 = (local0\Field11 - fpsfactor)
                                EndIf
                                If (((0.0 < local0\Field10) And (notarget = $00)) <> 0) Then
                                    local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 6.0, 0.6)
                                    local0\Field37 = $00
                                    local6 = entitydistance(local0\Field73, local0\Field4)
                                    pointentity(local0\Field0, local0\Field73, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                                    If (0.7 > local6) Then
                                        local0\Field9 = 3.0
                                        If (rand($02, $01) = $01) Then
                                            local0\Field14 = 2.0
                                        Else
                                            local0\Field14 = 66.0
                                        EndIf
                                    Else
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                        animatenpc(local0, 936.0, 1017.0, (local0\Field22 * 60.0), $01)
                                    EndIf
                                    local0\Field10 = (local0\Field10 - fpsfactor)
                                ElseIf (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                        animatenpc(local0, 936.0, 1017.0, (local0\Field22 * 60.0), $01)
                                        If (0.2 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field22 = 0.0
                                    animatenpc(local0, 778.0, 926.0, 0.1, $01)
                                    local0\Field38 = (local0\Field38 - fpsfactor)
                                    If (0.0 >= local0\Field38) Then
                                        local0\Field37 = findpath(local0, entityx(local0\Field73, $00), (entityy(local0\Field73, $00) + 0.1), entityz(local0\Field73, $00))
                                        local0\Field38 = (local0\Field38 + 350.0)
                                    EndIf
                                EndIf
                                If (0.005 < local0\Field22) Then
                                    If ((((977.0 > local12) And (977.0 <= local0\Field14)) Or ((1010.0 < local12) And (940.0 > local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                                    EndIf
                                EndIf
                            Case 3.0
                                If (notarget <> 0) Then
                                    local0\Field9 = 2.0
                                EndIf
                                If (66.0 > local0\Field14) Then
                                    animatenpc(local0, 2.0, 65.0, 0.7, $00)
                                    If (((23.0 > local12) And (23.0 <= local0\Field14)) <> 0) Then
                                        If (1.1 > entitydistance(local0\Field4, local0\Field73)) Then
                                            If (60.0 >= (Abs deltayaw(local0\Field4, local0\Field73))) Then
                                                If (local0\Field74 = networkserver\Field28) Then
                                                    playsound_strict(damagesfx(rand($05, $08)))
                                                    multiplayer_writesound(damagesfx(rand($05, $08)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
                                                    injuries = (rnd(0.4, 1.0) + injuries)
                                                    deathmsg = "Subject D-9341. Cause of death: multiple lacerations and severe blunt force trauma caused by an instance of SCP-049-2."
                                                Else
                                                    givedamage(local0\Field74, rnd(0.4, 1.0))
                                                EndIf
                                            EndIf
                                        EndIf
                                    ElseIf (65.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                Else
                                    animatenpc(local0, 66.0, 132.0, 0.7, $00)
                                    If (((90.0 > local12) And (90.0 <= local0\Field14)) <> 0) Then
                                        If (1.1 > entitydistance(local0\Field4, local0\Field73)) Then
                                            If (60.0 >= (Abs deltayaw(local0\Field4, local0\Field73))) Then
                                                If (local0\Field74 = networkserver\Field28) Then
                                                    playsound_strict(damagesfx(rand($05, $08)))
                                                    multiplayer_writesound(damagesfx(rand($05, $08)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
                                                    injuries = (rnd(0.4, 1.0) + injuries)
                                                    deathmsg = "Subject D-9341. Cause of death: multiple lacerations and severe blunt force trauma caused by an instance of SCP-049-2."
                                                Else
                                                    givedamage(local0\Field74, rnd(0.4, 1.0))
                                                EndIf
                                            EndIf
                                        EndIf
                                    ElseIf (132.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                EndIf
                        End Select
                    Else
                        animatenpc(local0, 133.0, 157.0, 0.5, $00)
                    EndIf
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                    rotateentity(local0\Field0, -90.0, entityyaw(local0\Field4, $00), 0.0, $00)
                EndIf
            Case $03
                local12 = local0\Field14
                local0\Field53 = ""
                local0\Field51 = $00
                local0\Field52 = $00
                local0\Field57 = "Guard"
                Select local0\Field9
                    Case 1.0
                        If (((((39.0 > local0\Field14) Or ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Or ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Or (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0)
                            EndIf
                        EndIf
                        If (0.0 <= killtimer) Then
                            local6 = entitydistance(local0\Field4, local0\Field73)
                            local41 = (((Float selecteddifficulty\Field3) * 0.5) + 0.4)
                            local42 = 11.0
                            If (playerroom\Field7\Field11 = "exit1") Then
                                local42 = 21.0
                                local41 = 0.0
                                If (rand($01, ($08 - (selecteddifficulty\Field3 Shl $02))) < $02) Then
                                    local41 = 0.03
                                EndIf
                                local41 = ((0.5 - (currspeed * 20.0)) + local41)
                            EndIf
                            If (local42 > local6) Then
                                local25 = createpivot($00)
                                positionentity(local25, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                pointentity(local25, local0\Field73, 0.0)
                                rotateentity(local25, min(entitypitch(local25, $00), 20.0), entityyaw(local25, $00), 0.0, $00)
                                rotateentity(local0\Field4, curveangle(entitypitch(local25, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local25, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                positionentity(local25, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                                pointentity(local25, local0\Field73, 0.0)
                                rotateentity(local25, min(entitypitch(local25, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                                If (0.0 = local0\Field25) Then
                                    debuglog("entitypick")
                                    entitypick(local25, local6)
                                    If (((pickedentity() = local0\Field73) Or (1.0 = local0\Field11)) <> 0) Then
                                        local43 = $00
                                        If (playerroom\Field7\Field11 = "start") Then
                                            deathmsg = "Subject D-9341. Cause of death: Gunshot wound to the head. The surveillance tapes confirm that the subject was terminated by Agent Ulgrin shortly after the site lockdown was initiated."
                                            local43 = $01
                                        ElseIf (playerroom\Field7\Field11 = "exit1") Then
                                            deathmsg = ((chr($22) + "Agent G. to control. Eliminated a Class D escapee in Gate B's courtyard.") + chr($22))
                                        Else
                                            deathmsg = ""
                                        EndIf
                                        playsound2(gunshotsfx, camera, local0\Field4, 35.0, 1.0)
                                        rotateentity(local25, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                                        positionentity(local25, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                        moveentity(local25, 0.0632, 0.84925, 0.5451)
                                        pointentity(local25, local0\Field73, 0.0)
                                        shoot(local0, entityx(local25, $00), entityy(local25, $00), entityz(local25, $00), local41, $00, local43)
                                        local0\Field25 = 7.0
                                    Else
                                        local0\Field22 = local0\Field21
                                    EndIf
                                EndIf
                                If (((0.0 < local0\Field25) And (7.0 >= local0\Field25)) <> 0) Then
                                    animatenpc(local0, 245.0, 248.0, 0.35, $01)
                                ElseIf (302.0 > local0\Field14) Then
                                    animatenpc(local0, 302.0, 344.0, 0.35, $01)
                                EndIf
                                freeentity(local25)
                            Else
                                animatenpc(local0, 302.0, 344.0, 0.35, $01)
                            EndIf
                            local0\Field51 = $01
                            If (10.0 = local0\Field10) Then
                                local0\Field53 = "Chest"
                                local0\Field52 = $03
                            Else
                                local0\Field53 = "Chest"
                                local0\Field52 = $00
                            EndIf
                        Else
                            local0\Field9 = 0.0
                        EndIf
                    Case 2.0
                        animatenpc(local0, 245.0, 248.0, 0.35, $01)
                        If (0.0 = local0\Field25) Then
                            playsound2(gunshotsfx, camera, local0\Field4, 20.0, 1.0)
                            local44 = createparticle(entityx(local0\Field0, $01), entityy(local0\Field0, $01), entityz(local0\Field0, $01), $01, 0.2, 0.0, $05)
                            positionentity(local44\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            rotateentity(local44\Field1, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                            moveentity(local44\Field1, 0.0632, 0.84925, 0.5451)
                            local0\Field25 = 7.0
                        EndIf
                    Case 3.0
                        If (local0\Field37 = $02) Then
                            local0\Field9 = 0.0
                            local0\Field22 = 0.0
                        ElseIf (local0\Field37 = $01) Then
                            If (local0\Field36[local0\Field39] = Null) Then
                                If (local0\Field39 > $13) Then
                                    local0\Field39 = $00
                                    local0\Field37 = $00
                                Else
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            Else
                                debuglog(("EntityX = " + (Str entityx(local0\Field36[local0\Field39]\Field0, $00))))
                                debuglog(("EntityY = " + (Str entityy(local0\Field36[local0\Field39]\Field0, $00))))
                                debuglog(("EntityZ = " + (Str entityz(local0\Field36[local0\Field39]\Field0, $00))))
                                debuglog(("EntityX = " + (Str entityx(local0\Field36[local0\Field39]\Field0, $01))))
                                debuglog(("EntityY = " + (Str entityy(local0\Field36[local0\Field39]\Field0, $01))))
                                debuglog(("EntityZ = " + (Str entityz(local0\Field36[local0\Field39]\Field0, $01))))
                                pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                animatenpc(local0, 1.0, 38.0, (local0\Field22 * 40.0), $01)
                                local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                If (0.2 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            EndIf
                        Else
                            local0\Field22 = 0.0
                            local0\Field9 = 4.0
                        EndIf
                    Case 4.0
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        If (rand($190, $01) = $01) Then
                            local0\Field15 = rnd(-180.0, 180.0)
                        EndIf
                        rotateentity(local0\Field4, 0.0, curveangle((local0\Field15 + (sin((Float (millisecs2() / $32))) * 2.0)), entityyaw(local0\Field4, $00), 150.0), 0.0, $01)
                        local6 = entitydistance(local0\Field4, local0\Field73)
                        If (15.0 > local6) Then
                            If (90.0 > wrapangle((entityyaw(local0\Field4, $00) - deltayaw(local0\Field4, local0\Field73)))) Then
                                If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                    local0\Field9 = 1.0
                                EndIf
                            EndIf
                        EndIf
                    Case 5.0
                        rotateentity(local0\Field4, 0.0, curveangle((vectoryaw((local0\Field33 - entityx(local0\Field4, $00)), 0.0, (local0\Field35 - entityz(local0\Field4, $00))) + local0\Field15), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                        local6 = distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field33, local0\Field35)
                        animatenpc(local0, 1.0, 38.0, (local0\Field22 * 40.0), $01)
                        If (((2.0 < local6) Or (1.0 > local6)) <> 0) Then
                            local0\Field22 = curvevalue(((local0\Field21 * (Sgn (local6 - 1.5))) * 0.75), local0\Field22, 10.0)
                        Else
                            local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                        EndIf
                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                    Case 7.0
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                    Case 8.0
                    Case 9.0
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        local0\Field53 = "head"
                        local0\Field51 = $01
                        local0\Field52 = $00
                        local0\Field15 = entityyaw(local0\Field4, $00)
                    Case 10.0
                        animatenpc(local0, 1.0, 38.0, (local0\Field22 * 40.0), $01)
                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                    Case 11.0
                        If (((((39.0 > local0\Field14) Or ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Or ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Or (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0)
                            EndIf
                        EndIf
                        If (0.0 <= killtimer) Then
                            local6 = entitydistance(local0\Field4, local0\Field73)
                            local45 = $00
                            If (11.0 > local6) Then
                                If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                    local45 = $01
                                EndIf
                            EndIf
                            If (local45 <> 0) Then
                                local25 = createpivot($00)
                                positionentity(local25, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                pointentity(local25, local0\Field73, 0.0)
                                rotateentity(local25, min(entitypitch(local25, $00), 20.0), entityyaw(local25, $00), 0.0, $00)
                                rotateentity(local0\Field4, curveangle(entitypitch(local25, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local25, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                positionentity(local25, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                                pointentity(local25, local0\Field73, 0.0)
                                rotateentity(local25, min(entitypitch(local25, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                                If (0.0 = local0\Field25) Then
                                    debuglog("entitypick")
                                    entitypick(local25, local6)
                                    If (((pickedentity() = local0\Field73) Or (1.0 = local0\Field11)) <> 0) Then
                                        local43 = $00
                                        deathmsg = ""
                                        playsound2(gunshotsfx, camera, local0\Field4, 35.0, 1.0)
                                        rotateentity(local25, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                                        positionentity(local25, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                        moveentity(local25, 0.0632, 0.84925, 0.5451)
                                        pointentity(local25, local0\Field73, 0.0)
                                        shoot(local0, entityx(local25, $00), entityy(local25, $00), entityz(local25, $00), 1.0, $00, local43)
                                        local0\Field25 = 7.0
                                    Else
                                        local0\Field22 = local0\Field21
                                    EndIf
                                EndIf
                                If (((0.0 < local0\Field25) And (7.0 >= local0\Field25)) <> 0) Then
                                    animatenpc(local0, 245.0, 248.0, 0.35, $01)
                                ElseIf (302.0 > local0\Field14) Then
                                    animatenpc(local0, 302.0, 344.0, 0.35, $01)
                                EndIf
                                freeentity(local25)
                            Else
                                If (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        animatenpc(local0, 39.0, 76.0, (local0\Field22 * 40.0), $01)
                                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                        If (0.2 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    EndIf
                                Else
                                    If (0.0 = local0\Field38) Then
                                        local0\Field37 = findpath(local0, entityx(local0\Field73, $00), (entityy(local0\Field73, $00) + 0.5), entityz(local0\Field73, $00))
                                    EndIf
                                    local46 = Null
                                    For local47 = Each waypoints
                                        If (2.0 > entitydistance(local47\Field0, local0\Field73)) Then
                                            local46 = local47
                                            Exit
                                        EndIf
                                    Next
                                    If (local46 <> Null) Then
                                        local0\Field38 = 1.0
                                        If (entityvisible(local46\Field0, local0\Field4) <> 0) Then
                                            If (0.0 < (Abs deltayaw(local0\Field4, local46\Field0))) Then
                                                pointentity(local0\Field0, local46\Field0, 0.0)
                                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                            EndIf
                                        EndIf
                                    Else
                                        local0\Field38 = 0.0
                                    EndIf
                                    If (1.0 = local0\Field38) Then
                                        animatenpc(local0, 39.0, 76.0, (local0\Field22 * 40.0), $01)
                                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                    EndIf
                                EndIf
                                If (((43.0 > local12) And (43.0 <= local0\Field14)) <> 0) Then
                                    playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                                ElseIf (((61.0 > local12) And (61.0 <= local0\Field14)) <> 0) Then
                                    playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                                EndIf
                            EndIf
                        Else
                            local0\Field9 = 0.0
                        EndIf
                    Case 12.0
                        If (((((39.0 > local0\Field14) Or ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Or ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Or (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0)
                            EndIf
                        EndIf
                        If (345.0 > local0\Field14) Then
                            animatenpc(local0, 302.0, 344.0, 0.35, $01)
                        EndIf
                        local25 = createpivot($00)
                        positionentity(local25, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                        If (1.0 = local0\Field10) Then
                            pointentity(local25, local0\Field73, 0.0)
                        Else
                            rotateentity(local25, 0.0, local0\Field15, 0.0, $00)
                        EndIf
                        rotateentity(local25, min(entitypitch(local25, $00), 20.0), entityyaw(local25, $00), 0.0, $00)
                        rotateentity(local0\Field4, curveangle(entitypitch(local25, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local25, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                        positionentity(local25, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                        If (1.0 = local0\Field10) Then
                            pointentity(local25, local0\Field73, 0.0)
                            local0\Field51 = $01
                            local0\Field53 = "Chest"
                            local0\Field52 = $00
                        Else
                            rotateentity(local25, 0.0, local0\Field15, 0.0, $00)
                        EndIf
                        rotateentity(local25, min(entitypitch(local25, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                        freeentity(local25)
                        updatesoundorigin(local0\Field17, camera, local0\Field4, 20.0, 1.0)
                    Case 13.0
                        animatenpc(local0, 202.0, 244.0, 0.35, $01)
                    Case 14.0
                        If (local0\Field37 = $02) Then
                            local0\Field9 = 13.0
                            local0\Field22 = 0.0
                        ElseIf (local0\Field37 = $01) Then
                            If (local0\Field36[local0\Field39] = Null) Then
                                If (local0\Field39 > $13) Then
                                    local0\Field39 = $00
                                    local0\Field37 = $00
                                Else
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            Else
                                pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                animatenpc(local0, 39.0, 76.0, (local0\Field22 * 40.0), $01)
                                local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                If (0.2 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            EndIf
                        Else
                            local0\Field22 = 0.0
                            local0\Field9 = 13.0
                        EndIf
                        If (((43.0 > local12) And (43.0 <= local0\Field14)) <> 0) Then
                            playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                        ElseIf (((61.0 > local12) And (61.0 <= local0\Field14)) <> 0) Then
                            playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                        EndIf
                    Default
                        If (rand($190, $01) = $01) Then
                            local0\Field12 = (Int rnd(-30.0, 30.0))
                        EndIf
                        local0\Field37 = $00
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        rotateentity(local0\Field4, 0.0, curveangle(((local0\Field15 + (Float local0\Field12)) + (sin((Float (millisecs2() / $32))) * 2.0)), entityyaw(local0\Field4, $00), 50.0), 0.0, $01)
                End Select
                If (0.01 < local0\Field22) Then
                    If (((5.0 > local12) And (5.0 <= local0\Field14)) <> 0) Then
                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                    ElseIf (((23.0 > local12) And (23.0 <= local0\Field14)) <> 0) Then
                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                    EndIf
                EndIf
                If (((286.5 < local0\Field14) And (288.5 > local0\Field14)) <> 0) Then
                    local0\Field48 = $01
                EndIf
                local0\Field25 = max(0.0, (local0\Field25 - fpsfactor))
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) + 180.0), 0.0, $00)
            Case $08
                updatemtfunit(local0)
            Case $04,$16
                rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
                local12 = animtime(local0\Field0)
                Select local0\Field9
                    Case 0.0
                        local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                        animate2(local0\Field0, animtime(local0\Field0), $D2, $EB, 0.1, $01)
                    Case 1.0
                        If (1.0 = local0\Field10) Then
                            local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                        Else
                            local0\Field22 = curvevalue(0.015, local0\Field22, 5.0)
                        EndIf
                        animate2(local0\Field0, animtime(local0\Field0), $EC, $104, (local0\Field22 * 18.0), $01)
                    Case 2.0
                        local0\Field22 = curvevalue(0.03, local0\Field22, 5.0)
                        animate2(local0\Field0, animtime(local0\Field0), $12D, $13F, (local0\Field22 * 18.0), $01)
                End Select
                If (2.0 <> local0\Field10) Then
                    If (1.0 = local0\Field9) Then
                        If (0.01 < local0\Field22) Then
                            If (((244.0 > local12) And (244.0 <= animtime(local0\Field0))) <> 0) Then
                                playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                            ElseIf (((256.0 > local12) And (256.0 <= animtime(local0\Field0))) <> 0) Then
                                playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                            EndIf
                        EndIf
                    ElseIf (2.0 = local0\Field9) Then
                        If (0.01 < local0\Field22) Then
                            If (((309.0 > local12) And (309.0 <= animtime(local0\Field0))) <> 0) Then
                                playsound2(stepsfx(getstepsound(local0\Field4), $01, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                            ElseIf (((319.0 >= local12) And (301.0 >= animtime(local0\Field0))) <> 0) Then
                                playsound2(stepsfx(getstepsound(local0\Field4), $01, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (((19.0 = local0\Field14) Or (60.0 = local0\Field14)) <> 0) Then
                    local0\Field48 = $01
                EndIf
                If (((19.0 = animtime(local0\Field0)) Or (60.0 = animtime(local0\Field0))) <> 0) Then
                    local0\Field48 = $01
                EndIf
                If (local0\Field48 <> 0) Then
                    local0\Field22 = 0.0
                EndIf
                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.32), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
            Case $0C
                If (player[local0\Field74]\Field46 <> "pocketdimension") Then
                    If ((Int local0\Field24) <> 0) Then
                        hideentity(local0\Field0)
                        hideentity(local0\Field1)
                        If (rand($C8, $01) = $01) Then
                            For local24 = Each waypoints
                                If (local24\Field2 <> playerroom) Then
                                    local9 = (Abs (entityx(local0\Field73, $00) - entityx(local24\Field0, $01)))
                                    If (((3.0 < local9) And (9.0 > local9)) <> 0) Then
                                        local11 = (Abs (entityz(local0\Field73, $00) - entityz(local24\Field0, $01)))
                                        If (((3.0 < local11) And (9.0 > local11)) <> 0) Then
                                            positionentity(local0\Field4, entityx(local24\Field0, $01), entityy(local24\Field0, $01), entityz(local24\Field0, $01), $00)
                                            positionentity(local0\Field0, entityx(local24\Field0, $01), entityy(local24\Field0, $01), entityz(local24\Field0, $01), $00)
                                            resetentity(local0\Field4)
                                            showentity(local0\Field0)
                                            showentity(local0\Field1)
                                            local0\Field26 = $00
                                            local0\Field36[$00] = local24
                                            local0\Field24 = 0.0
                                            local0\Field10 = (Float (rand($0F, $14) * $46))
                                            local0\Field9 = max((Float rand($FFFFFFFF, $02)), 0.0)
                                            local0\Field12 = rand($00, $01)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    Else
                        local6 = entitydistance(local0\Field73, local0\Field4)
                        local0\Field28 = curvevalue(0.0, local0\Field28, 10.0)
                        local0\Field30 = curvevalue(0.0, local0\Field30, 10.0)
                        If (rand($64, $01) = $01) Then
                            If (rand($05, $01) = $01) Then
                                local0\Field28 = ((entityx(local0\Field73, $00) - entityx(local0\Field4, $00)) * 0.9)
                                local0\Field30 = ((entityz(local0\Field73, $00) - entityz(local0\Field4, $00)) * 0.9)
                            Else
                                local0\Field28 = rnd(0.1, 0.5)
                                local0\Field30 = rnd(0.1, 0.5)
                            EndIf
                        EndIf
                        local19 = (Int rnd(-1.0, 1.0))
                        positionentity(local0\Field1, (entityx(local0\Field4, $00) + (local0\Field28 * (Float local19))), ((entityy(local0\Field4, $00) - 0.2) + (sin((Float (((millisecs2() Sar $03) - $2D) Mod $168))) * 0.05)), (entityz(local0\Field4, $00) + (local0\Field30 * (Float local19))), $00)
                        rotateentity(local0\Field1, 0.0, entityyaw(local0\Field0, $00), 0.0, $00)
                        If (floor(local0\Field14) <> floor(animtime(local0\Field1))) Then
                            setanimtime(local0\Field1, local0\Field14, $00)
                        EndIf
                        If (0.0 = local0\Field9) Then
                            If (local0\Field12 = $00) Then
                                animatenpc(local0, 2.0, 74.0, 0.2, $01)
                            Else
                                animatenpc(local0, 75.0, 124.0, 0.2, $01)
                            EndIf
                            If (local0\Field26 <> 0) Then
                                pointentity(local0\Field1, local0\Field73, 0.0)
                                rotateentity(local0\Field0, 0.0, curveangle(entityyaw(local0\Field1, $00), entityyaw(local0\Field0, $00), 40.0), 0.0, $00)
                                If (4.0 > local6) Then
                                    local0\Field9 = (Float rand($01, $02))
                                EndIf
                            ElseIf (((6.0 > local6) And (rand($05, $01) = $01)) <> 0) Then
                                If (entityinview(local0\Field4, camera) <> 0) Then
                                    If (entityvisible(local0\Field73, local0\Field4) <> 0) Then
                                        local0\Field26 = $01
                                        playsound_strict(loadtempsound((("SFX\SCP\513\Bell" + (Str rand($02, $03))) + ".ogg")))
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf (local0\Field36[$00] = Null) Then
                            For local24 = Each waypoints
                                local9 = (Abs (entityx(local0\Field4, $01) - entityx(local24\Field0, $01)))
                                If (((8.0 > local9) And (1.0 < local9)) <> 0) Then
                                    local11 = (Abs (entityz(local0\Field4, $01) - entityz(local24\Field0, $01)))
                                    If (((8.0 > local11) And (1.0 < local11)) <> 0) Then
                                        If (local6 < entitydistance(local0\Field73, local24\Field0)) Then
                                            local0\Field36[$00] = local24
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local0\Field36[$00] = Null) Then
                                local0\Field24 = 1.0
                                local0\Field10 = 0.0
                            EndIf
                        ElseIf (1.0 < entitydistance(local0\Field4, local0\Field36[$00]\Field0)) Then
                            pointentity(local0\Field0, local0\Field36[$00]\Field0, 0.0)
                            rotateentity(local0\Field4, curveangle(entitypitch(local0\Field0, $00), entitypitch(local0\Field4, $00), 15.0), curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 15.0), 0.0, $01)
                            local0\Field22 = curvevalue((max(((7.0 - local6) / 7.0), 0.0) * 0.05), local0\Field22, 15.0)
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                            If (((rand($C8, $01) = $01) And networkserver\Field18) <> 0) Then
                                moveentity(local0\Field4, 0.0, 0.0, 0.5)
                            EndIf
                            rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                        Else
                            For local5 = $00 To $04 Step $01
                                If (local0\Field36[$00]\Field4[local5] <> Null) Then
                                    If (local6 < entitydistance(local0\Field73, local0\Field36[$00]\Field4[local5]\Field0)) Then
                                        If (local0\Field26 = $00) Then
                                            If (entityinview(local0\Field4, camera) <> 0) Then
                                                If (entityvisible(local0\Field73, local0\Field4) <> 0) Then
                                                    local0\Field26 = $01
                                                    playsound_strict(loadtempsound((("SFX\SCP\513\Bell" + (Str rand($02, $03))) + ".ogg")))
                                                EndIf
                                            EndIf
                                        EndIf
                                        local0\Field36[$00] = local0\Field36[$00]\Field4[local5]
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (local0\Field36[$00] = Null) Then
                                local0\Field10 = 0.0
                            EndIf
                        EndIf
                        positionentity(local0\Field0, entityx(local0\Field4, $00), ((entityy(local0\Field4, $00) - 0.2) + (sin((Float ((millisecs2() Sar $03) Mod $168))) * 0.1)), entityz(local0\Field4, $00), $00)
                        Select local0\Field9
                            Case 1.0
                                If (local0\Field12 = $00) Then
                                    animatenpc(local0, 125.0, 194.0, (local0\Field22 * 20.0), $01)
                                Else
                                    animatenpc(local0, 195.0, 264.0, (local0\Field22 * 20.0), $01)
                                EndIf
                                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                            Case 2.0
                                If (local0\Field12 = $00) Then
                                    animatenpc(local0, 2.0, 74.0, 0.2, $01)
                                Else
                                    animatenpc(local0, 75.0, 124.0, 0.2, $01)
                                EndIf
                                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                        End Select
                        If (0.0 < local0\Field10) Then
                            If (4.0 > local6) Then
                                local0\Field10 = (local0\Field10 - (fpsfactor * 4.0))
                            EndIf
                            local0\Field10 = (local0\Field10 - fpsfactor)
                        Else
                            local0\Field36[$00] = Null
                            local0\Field24 = 1.0
                            local0\Field10 = 0.0
                        EndIf
                    EndIf
                EndIf
                local0\Field7 = 0.0
                resetentity(local0\Field4)
            Case $06
                local14 = player[local0\Field74]\Field46
                If (((local14 <> "pocketdimension") And (local14 <> "dimension1499")) <> 0) Then
                    If ((Int local0\Field24) <> 0) Then
                        hideentity(local0\Field0)
                        If (((rand($32, $01) = $01) And ((-5.0 > blinktimer) And (-15.0 < blinktimer))) <> 0) Then
                            showentity(local0\Field0)
                            local8 = (entityyaw(local0\Field73, $00) + rnd(-90.0, 90.0))
                            local6 = rnd(1.5, 2.0)
                            positionentity(local0\Field4, (entityx(local0\Field73, $00) + (sin(local8) * local6)), (entityy(local0\Field73, $00) + 0.2), (entityz(local0\Field73, $00) + (cos(local8) * local6)), $00)
                            local0\Field24 = 0.0
                            local0\Field9 = (Float rand($14, $3C))
                            If (rand($12C, $01) = $01) Then
                                playsound2(rustlesfx(rand($00, $02)), camera, local0\Field0, 8.0, rnd(0.0, 0.2))
                            EndIf
                        EndIf
                    Else
                        positionentity(local0\Field0, (entityx(local0\Field4, $00) + rnd(-0.005, 0.005)), ((entityy(local0\Field4, $00) + 0.3) + (0.1 * sin((Float (millisecs2() Sar $01))))), (entityz(local0\Field4, $00) + rnd(-0.005, 0.005)), $00)
                        rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), (Float ((millisecs2() / $05) Mod $168)), $00)
                        animatenpc(local0, 32.0, 113.0, 0.4, $01)
                        If (entityinview(local0\Field0, camera) <> 0) Then
                            giveachievement($0B, $01)
                            If (rand($1E, $01) = $01) Then
                                If (channelplaying(local0\Field17) = $00) Then
                                    If (entityvisible(camera, local0\Field0) <> 0) Then
                                        local0\Field17 = playsound2(rustlesfx(rand($00, $02)), camera, local0\Field0, 8.0, 0.3)
                                    EndIf
                                EndIf
                            EndIf
                            local19 = createpivot($00)
                            positionentity(local19, entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), $00)
                            pointentity(local19, local0\Field4, 0.0)
                            local8 = wrapangle((entityyaw(local0\Field73, $00) - entityyaw(local19, $00)))
                            If (180.0 > local8) Then
                                rotateentity(local0\Field4, 0.0, (entityyaw(local0\Field73, $00) - 80.0), 0.0, $00)
                            Else
                                rotateentity(local0\Field4, 0.0, (entityyaw(local0\Field73, $00) + 80.0), 0.0, $00)
                            EndIf
                            freeentity(local19)
                            moveentity(local0\Field4, 0.0, 0.0, (0.03 * fpsfactor))
                            local0\Field9 = (local0\Field9 - fpsfactor)
                        EndIf
                        local0\Field9 = (local0\Field9 - (fpsfactor / 80.0))
                        If (0.0 >= local0\Field9) Then
                            local0\Field24 = 1.0
                        EndIf
                    EndIf
                EndIf
                local0\Field7 = 0.0
                resetentity(local0\Field4)
            Case $07
                local6 = entitydistance(collider, local0\Field4)
                If (60.0 > local6) Then
                    If (playerroom\Field7\Field11 = "exit1") Then
                        local7 = max(min((entitydistance(local0\Field4, playerroom\Field25[$03]) / (8000.0 * roomscale)), 1.0), 0.0)
                    Else
                        local7 = 1.0
                    EndIf
                    local0\Field17 = loopsound2(apachesfx, local0\Field17, camera, local0\Field4, 25.0, local7)
                EndIf
                local0\Field7 = 0.0
                Select local0\Field9
                    Case 0.0,1.0
                        turnentity(local0\Field1, 0.0, (20.0 * fpsfactor), 0.0, $00)
                        turnentity(local0\Field2, (20.0 * fpsfactor), 0.0, 0.0, $00)
                        If (((1.0 = local0\Field9) And (notarget = $00)) <> 0) Then
                            If (30.0 > (Abs (entityx(local0\Field73, $00) - entityx(local0\Field4, $00)))) Then
                                If (30.0 > (Abs (entityz(local0\Field73, $00) - entityz(local0\Field4, $00)))) Then
                                    If (20.0 > (Abs (entityy(local0\Field73, $00) - entityy(local0\Field4, $00)))) Then
                                        If (rand($14, $01) = $01) Then
                                            If (entityvisible(local0\Field73, local0\Field4) <> 0) Then
                                                local0\Field9 = 2.0
                                                playsound2(alarmsfx($02), camera, local0\Field4, 50.0, 1.0)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Case 2.0,3.0
                        If (2.0 = local0\Field9) Then
                            local15 = local0\Field73
                        ElseIf (3.0 = local0\Field9) Then
                            local15 = createpivot($00)
                            positionentity(local15, local0\Field33, local0\Field34, local0\Field35, $01)
                        EndIf
                        If ((notarget And (2.0 = local0\Field9)) <> 0) Then
                            local0\Field9 = 1.0
                        EndIf
                        turnentity(local0\Field1, 0.0, (20.0 * fpsfactor), 0.0, $00)
                        turnentity(local0\Field2, (20.0 * fpsfactor), 0.0, 0.0, $00)
                        If (55.0 > (Abs (entityx(local15, $00) - entityx(local0\Field4, $00)))) Then
                            If (55.0 > (Abs (entityz(local15, $00) - entityz(local0\Field4, $00)))) Then
                                If (20.0 > (Abs (entityy(local15, $00) - entityy(local0\Field4, $00)))) Then
                                    pointentity(local0\Field0, local15, 0.0)
                                    rotateentity(local0\Field4, curveangle(min(wrapangle(entitypitch(local0\Field0, $00)), 40.0), entitypitch(local0\Field4, $00), 40.0), curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 90.0), entityroll(local0\Field4, $00), $01)
                                    positionentity(local0\Field4, entityx(local0\Field4, $00), curvevalue((entityy(local15, $00) + 8.0), entityy(local0\Field4, $00), 70.0), entityz(local0\Field4, $00), $00)
                                    local6 = distance(entityx(local15, $00), entityz(local15, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))
                                    local0\Field22 = curvevalue((min((local6 - 6.5), 6.5) * 0.008), local0\Field22, 50.0)
                                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                    If (0.0 = local0\Field38) Then
                                        local0\Field37 = entityvisible(local0\Field4, local15)
                                        local0\Field38 = (Float rand($64, $C8))
                                    Else
                                        local0\Field38 = min((local0\Field38 - fpsfactor), 0.0)
                                    EndIf
                                    If (local0\Field37 = $01) Then
                                        rotateentity(local0\Field4, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), curveangle(0.0, entityroll(local0\Field4, $00), 40.0), $01)
                                        If (0.0 >= local0\Field25) Then
                                            If (20.0 > local6) Then
                                                local25 = createpivot($00)
                                                positionentity(local25, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                                rotateentity(local25, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $00)
                                                moveentity(local25, 0.0, (1.0 / 4.831696), 1.675444)
                                                pointentity(local25, local15, 0.0)
                                                If (10.0 > wrapangle((entityyaw(local25, $00) - entityyaw(local0\Field4, $00)))) Then
                                                    playsound2(gunshot2sfx, camera, local0\Field4, 20.0, 1.0)
                                                    If (playerroom\Field7\Field11 = "exit1") Then
                                                        deathmsg = ((chr($22) + "CH-2 to control. Shot down a runaway Class D at Gate B.") + chr($22))
                                                    Else
                                                        deathmsg = ((chr($22) + "CH-2 to control. Shot down a runaway Class D at Gate A.") + chr($22))
                                                    EndIf
                                                    shoot(local0, entityx(local25, $00), entityy(local25, $00), entityz(local25, $00), (((10.0 / local6) * (1.0 / local6)) * (Float (2.0 = local0\Field9))), (2.0 = local0\Field9), $00)
                                                    local0\Field25 = 5.0
                                                EndIf
                                                freeentity(local25)
                                            EndIf
                                        EndIf
                                    Else
                                        rotateentity(local0\Field4, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), curveangle(-20.0, entityroll(local0\Field4, $00), 40.0), $01)
                                    EndIf
                                    moveentity(local0\Field4, ((- entityroll(local0\Field4, $00)) * 0.002), 0.0, 0.0)
                                    local0\Field25 = (local0\Field25 - fpsfactor)
                                EndIf
                            EndIf
                        EndIf
                        If (3.0 = local0\Field9) Then
                            freeentity(local15)
                        EndIf
                    Case 4.0
                        If (300.0 > local0\Field10) Then
                            turnentity(local0\Field1, 0.0, (20.0 * fpsfactor), 0.0, $00)
                            turnentity(local0\Field2, (20.0 * fpsfactor), 0.0, 0.0, $00)
                            turnentity(local0\Field4, 0.0, ((- fpsfactor) * 7.0), 0.0, $00)
                            local0\Field10 = (local0\Field10 + (fpsfactor * 0.3))
                            local15 = createpivot($00)
                            positionentity(local15, local0\Field33, local0\Field34, local0\Field35, $01)
                            pointentity(local0\Field0, local15, 0.0)
                            moveentity(local0\Field0, 0.0, 0.0, ((fpsfactor * 0.001) * local0\Field10))
                            positionentity(local0\Field4, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            If (0.3 > entitydistance(local0\Field0, local15)) Then
                                camerashake = max(camerashake, 3.0)
                                playsound_strict(loadtempsound((("SFX\Character\Apache\Crash" + (Str rand($01, $02))) + ".ogg")))
                                local0\Field9 = 5.0
                            EndIf
                            freeentity(local15)
                        EndIf
                End Select
                positionentity(local0\Field0, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
            Case $0D
                local6 = entitydistance(local0\Field4, local0\Field73)
                If (hidedistance > local6) Then
                    Select local0\Field9
                        Case 0.0
                            If (283.0 < local0\Field14) Then
                                heartbeatvolume = max(curvevalue(1.0, heartbeatvolume, 50.0), heartbeatvolume)
                                heartbeatrate = max(curvevalue(130.0, heartbeatrate, 100.0), heartbeatrate)
                                pointentity(local0\Field0, local0\Field73, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 25.0), 0.0, $00)
                                animatenpc(local0, 283.0, 389.0, 0.3, $00)
                                If (388.0 < local0\Field14) Then
                                    local0\Field9 = 1.0
                                    freesound_strict(local0\Field19)
                                    local0\Field19 = $00
                                EndIf
                            ElseIf (2.5 > local6) Then
                                setnpcframe(local0, 284.0)
                                local0\Field19 = loadsound_strict("SFX\Room\035Chamber\TentacleSpawn.ogg")
                                playsound_strict(local0\Field19)
                            EndIf
                        Case 1.0
                            If (local0\Field19 = $00) Then
                                freesound_strict(local0\Field19)
                                local0\Field19 = $00
                                local0\Field19 = loadsound_strict("SFX\Room\035Chamber\TentacleIdle.ogg")
                            EndIf
                            local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field4, 10.0, 1.0)
                            If (1.8 > local6) Then
                                If (20.0 > (Abs deltayaw(local0\Field4, local0\Field73))) Then
                                    local0\Field9 = 2.0
                                    If (local0\Field16 <> $00) Then
                                        freesound_strict(local0\Field16)
                                        local0\Field16 = $00
                                    EndIf
                                EndIf
                            EndIf
                            pointentity(local0\Field0, local0\Field73, 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 25.0), 0.0, $00)
                            animatenpc(local0, 33.0, 174.0, 0.3, $01)
                        Case 2.0
                            If (((33.0 < local0\Field14) And (174.0 > local0\Field14)) <> 0) Then
                                animatenpc(local0, 33.0, 174.0, 2.0, $00)
                            Else
                                pointentity(local0\Field0, local0\Field73, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                If (33.0 < local0\Field14) Then
                                    If (local0\Field19 <> $00) Then
                                        freesound_strict(local0\Field19)
                                        local0\Field19 = $00
                                    EndIf
                                    local0\Field14 = 2.0
                                    local0\Field16 = loadsound_strict((("SFX\Room\035Chamber\TentacleAttack" + (Str rand($01, $02))) + ".ogg"))
                                    playsound_strict(local0\Field16)
                                EndIf
                                animatenpc(local0, 2.0, 32.0, 0.3, $00)
                                If (((5.0 <= local0\Field14) And (6.0 > local0\Field14)) <> 0) Then
                                    If (local0\Field74 = networkserver\Field28) Then
                                        If (1.8 > local6) Then
                                            If (20.0 > (Abs deltayaw(local0\Field4, local0\Field73))) Then
                                                If (wearinghazmat <> 0) Then
                                                    injuries = (rnd(0.5, 0.0) + injuries)
                                                    playsound_strict(loadtempsound("SFX\General\BodyFall.ogg"))
                                                    multiplayer_writetempsound("SFX\General\BodyFall.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
                                                Else
                                                    blurtimer = 100.0
                                                    injuries = (rnd(1.0, 1.5) + injuries)
                                                    playsound_strict(damagesfx(rand($02, $03)))
                                                    multiplayer_writesound(damagesfx(rand($02, $03)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
                                                    If (3.0 < injuries) Then
                                                        If (playerroom\Field7\Field11 = "room2offices") Then
                                                            deathmsg = (chr($22) + "One large and highly active tentacle-like appendage seems ")
                                                            deathmsg = (deathmsg + "to have grown outside the dead body of a scientist within office area [REDACTED]. Its level of aggression is ")
                                                            deathmsg = (deathmsg + "unlike anything we've seen before - it looks like it has ")
                                                            deathmsg = ((deathmsg + "beaten some unfortunate Class D to death at some point during the breach.") + chr($22))
                                                        Else
                                                            deathmsg = (chr($22) + "We will need more than the regular cleaning team to take care of this. ")
                                                            deathmsg = (deathmsg + "Two large and highly active tentacle-like appendages seem ")
                                                            deathmsg = (deathmsg + "to have formed inside the chamber. Their level of aggression is ")
                                                            deathmsg = (deathmsg + "unlike anything we've seen before - it looks like they have ")
                                                            deathmsg = ((deathmsg + "beaten some unfortunate Class D to death at some point during the breach.") + chr($22))
                                                        EndIf
                                                        kill("was killed by tentacle", $00)
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    Else
                                        givedamage(local0\Field74, rnd(0.5, 0.0))
                                    EndIf
                                    local0\Field14 = 6.0
                                ElseIf (32.0 = local0\Field14) Then
                                    local0\Field9 = 1.0
                                    local0\Field14 = 173.0
                                EndIf
                            EndIf
                    End Select
                EndIf
                positionentity(local0\Field0, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, (entitypitch(local0\Field4, $00) - 90.0), (entityyaw(local0\Field4, $00) - 180.0), entityroll(local0\Field4, $00), $01)
                local0\Field7 = 0.0
                resetentity(local0\Field4)
            Case $0E
                If (player[local0\Field74]\Field46 = "room860") Then
                    local52 = room[player[local0\Field74]\Field47]\Field11
                    local6 = entitydistance(local0\Field73, local0\Field4)
                    If (forestnpc <> $00) Then
                        If (1.0 = forestnpcdata[$02]) Then
                            showentity(forestnpc)
                            If (1.0 <> local0\Field9) Then
                                If ((((-8.0 > blinktimer) And (-12.0 < blinktimer)) Or (entityinview(forestnpc, camera) = $00)) <> 0) Then
                                    forestnpcdata[$02] = 0.0
                                    hideentity(forestnpc)
                                EndIf
                            EndIf
                        Else
                            hideentity(forestnpc)
                        EndIf
                    EndIf
                    Select local0\Field9
                        Case 0.0
                            hideentity(local0\Field4)
                            hideentity(local0\Field0)
                            hideentity(local0\Field1)
                            local0\Field10 = 0.0
                            positionentity(local0\Field4, 0.0, -100.0, 0.0, $00)
                        Case 1.0
                            local0\Field7 = 0.0
                            If (-100.0 >= entityy(local0\Field4, $00)) Then
                                tformpoint(entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), $00, local52\Field4)
                                local9 = floor(((tformedx() + 6.0) / 12.0))
                                local11 = floor(((tformedz() + 6.0) / 12.0))
                                For local54 = (Int max((local9 - 1.0), 1.0)) To (Int min((local9 + 1.0), 10.0)) Step $02
                                    For local55 = (Int max((local11 - 1.0), 1.0)) To (Int min((local11 + 1.0), 10.0)) Step $02
                                        If (local52\Field2[((local55 * $0A) + local54)] = $00) Then
                                            tformpoint(((((Float local54) + local9) / 2.0) * 12.0), 0.0, ((((Float local55) + local11) / 2.0) * 12.0), local52\Field4, $00)
                                            If (entityinview(local0\Field4, camera) <> 0) Then
                                                positionentity(local0\Field4, 0.0, -110.0, 0.0, $00)
                                                debuglog("spawned monster in view -> hide")
                                            Else
                                                debuglog("spawned monster successfully")
                                                positionentity(local0\Field4, tformedx(), (entityy(local52\Field4, $01) + 2.3), tformedz(), $00)
                                                local54 = $0A
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                Next
                                If (-100.0 < entityy(local0\Field4, $00)) Then
                                    playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 15.0, 0.5)
                                    If (1.0 <> forestnpcdata[$02]) Then
                                        forestnpcdata[$02] = 0.0
                                    EndIf
                                    Select rand($03, $01)
                                        Case $01
                                            pointentity(local0\Field4, local0\Field73, 0.0)
                                            local0\Field14 = 2.0
                                        Case $02
                                            pointentity(local0\Field4, local0\Field73, 0.0)
                                            local0\Field14 = 201.0
                                        Case $03
                                            pointentity(local0\Field4, local0\Field73, 0.0)
                                            turnentity(local0\Field4, 0.0, 90.0, 0.0, $00)
                                            local0\Field14 = 299.0
                                    End Select
                                    local0\Field10 = 0.0
                                EndIf
                            Else
                                showentity(local0\Field0)
                                showentity(local0\Field4)
                                positionentity(local0\Field4, entityx(local0\Field4, $00), (entityy(local52\Field4, $01) + 2.3), entityz(local0\Field4, $00), $00)
                                If (forestnpc <> $00) Then
                                    If (0.0 = forestnpcdata[$02]) Then
                                        local57 = $00
                                        local58 = $00
                                        For local5 = $00 To $09 Step $01
                                            If (inventory(local5) <> Null) Then
                                                local59 = inventory(local5)\Field3\Field1
                                                If ((((local59 = "Log #1") Or (local59 = "Log #2")) Or (local59 = "Log #3")) <> 0) Then
                                                    local58 = (local58 + $01)
                                                    local57 = (local57 + ($0A * local58))
                                                EndIf
                                            EndIf
                                        Next
                                        If (rand($01, ($35C - local57)) = $01) Then
                                            showentity(forestnpc)
                                            forestnpcdata[$02] = 1.0
                                            If (rand($02, $01) = $01) Then
                                                forestnpcdata[$00] = 0.0
                                            Else
                                                forestnpcdata[$00] = 2.0
                                            EndIf
                                            forestnpcdata[$01] = 0.0
                                            positionentity(forestnpc, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.5), entityz(local0\Field4, $00), $00)
                                            rotateentity(forestnpc, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                                            moveentity(forestnpc, 0.75, 0.0, 0.0)
                                            rotateentity(forestnpc, 0.0, 0.0, 0.0, $00)
                                            entitytexture(forestnpc, forestnpctex, (Int forestnpcdata[$00]), $00)
                                        Else
                                            forestnpcdata[$02] = 2.0
                                        EndIf
                                    ElseIf (1.0 = forestnpcdata[$02]) Then
                                        If (0.0 = forestnpcdata[$01]) Then
                                            If (rand($C8, $01) = $01) Then
                                                forestnpcdata[$01] = fpsfactor
                                                entitytexture(forestnpc, forestnpctex, (Int (forestnpcdata[$00] + 1.0)), $00)
                                            EndIf
                                        ElseIf (((0.0 < forestnpcdata[$01]) And (5.0 > forestnpcdata[$01])) <> 0) Then
                                            forestnpcdata[$01] = min((forestnpcdata[$01] + fpsfactor), 5.0)
                                        Else
                                            forestnpcdata[$01] = 0.0
                                            entitytexture(forestnpc, forestnpctex, (Int forestnpcdata[$00]), $00)
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.0 = local0\Field10) Then
                                    If (entityinview(local0\Field4, camera) <> 0) Then
                                        local0\Field10 = 1.0
                                        If (rand($08, $01) = $01) Then
                                            playsound2(loadtempsound((("SFX\SCP\860\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field4, 20.0, 1.0)
                                        EndIf
                                    EndIf
                                ElseIf (199.0 >= local0\Field14) Then
                                    animatenpc(local0, 2.0, 199.0, 0.5, $00)
                                    If (199.0 = local0\Field14) Then
                                        local0\Field14 = 298.0
                                        playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 15.0, 1.0)
                                    EndIf
                                ElseIf (297.0 >= local0\Field14) Then
                                    pointentity(local0\Field4, local0\Field73, 0.0)
                                    animatenpc(local0, 200.0, 297.0, 0.5, $00)
                                    If (297.0 = local0\Field14) Then
                                        local0\Field14 = 298.0
                                        playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 15.0, 1.0)
                                    EndIf
                                Else
                                    local8 = curveangle(point_direction(entityx(local0\Field4, $00), entityz(local0\Field4, $00), entityx(local0\Field73, $00), entityz(local0\Field73, $00)), (entityyaw(local0\Field4, $00) + 90.0), 20.0)
                                    rotateentity(local0\Field4, 0.0, (local8 - 90.0), 0.0, $01)
                                    animatenpc(local0, 298.0, 316.0, (local0\Field22 * 10.0), $01)
                                    local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                    If (15.0 < local6) Then
                                        positionentity(local0\Field4, 0.0, -110.0, 0.0, $00)
                                        local0\Field9 = 0.0
                                        local0\Field10 = 0.0
                                    EndIf
                                EndIf
                            EndIf
                            resetentity(local0\Field4)
                        Case 2.0
                            showentity(local0\Field0)
                            showentity(local0\Field4)
                            local12 = local0\Field14
                            If (-100.0 >= entityy(local0\Field4, $00)) Then
                                tformpoint(entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), $00, local52\Field4)
                                local9 = floor(((tformedx() + 6.0) / 12.0))
                                local11 = floor(((tformedz() + 6.0) / 12.0))
                                For local54 = (Int max((local9 - 1.0), 1.0)) To (Int min((local9 + 1.0), 10.0)) Step $01
                                    For local55 = (Int max((local11 - 1.0), 1.0)) To (Int min((local11 + 1.0), 10.0)) Step $01
                                        If ((((local52\Field2[((local55 * $0A) + local54)] > $00) And ((local9 <> (Float local54)) Or (local11 <> (Float local55)))) And ((local9 = (Float local54)) Or (local11 = (Float local55)))) <> 0) Then
                                            tformpoint(((Float local54) * 12.0), 0.0, ((Float local55) * 12.0), local52\Field4, $00)
                                            positionentity(local0\Field4, tformedx(), (entityy(local52\Field4, $01) + 1.0), tformedz(), $00)
                                            debuglog((((Str tformedx()) + ", ") + (Str tformedz())))
                                            If (entityinview(local0\Field4, camera) <> 0) Then
                                                blinktimer = -10.0
                                            Else
                                                local54 = $0A
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                local8 = curveangle((Float find860angle(local0, local52)), (entityyaw(local0\Field4, $00) + 90.0), 80.0)
                                rotateentity(local0\Field4, 0.0, (local8 - 90.0), 0.0, $01)
                                local0\Field22 = curvevalue((local0\Field21 * 0.3), local0\Field22, 50.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                animatenpc(local0, 494.0, 569.0, (local0\Field22 * 25.0), $01)
                                If (0.0 = local0\Field10) Then
                                    If (8.0 > local6) Then
                                        If (entityinview(local0\Field4, camera) <> 0) Then
                                            playsound_strict(loadtempsound((("SFX\SCP\860\Chase" + (Str rand($01, $02))) + ".ogg")))
                                            playsound2(loadtempsound((("SFX\SCP\860\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                                            local0\Field10 = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.03 < currspeed) Then
                                    local0\Field11 = (local0\Field11 + fpsfactor)
                                    If (local0\Field11 > rnd(5000.0, 0.0)) Then
                                        local19 = $01
                                        If (local0\Field17 <> $00) Then
                                            If (channelplaying(local0\Field17) <> 0) Then
                                                local19 = $00
                                            EndIf
                                        EndIf
                                        If (local19 <> 0) Then
                                            local0\Field17 = playsound2(loadtempsound((("SFX\SCP\860\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field11 = max((local0\Field11 - fpsfactor), 0.0)
                                EndIf
                                If (((4.5 > local6) Or (rnd(200.0, 250.0) < local0\Field11)) <> 0) Then
                                    local0\Field17 = playsound2(loadtempsound((("SFX\SCP\860\Cancer" + (Str rand($03, $05))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                                    local0\Field9 = 3.0
                                EndIf
                                If (20.0 < local6) Then
                                    local0\Field9 = 0.0
                                    local0\Field10 = 0.0
                                    positionentity(local0\Field4, 0.0, -110.0, 0.0, $00)
                                EndIf
                            EndIf
                            If ((((533.0 > local12) And (533.0 <= local0\Field14)) Or ((568.0 < local12) And (2.0 > local0\Field14))) <> 0) Then
                                playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 15.0, 0.6)
                            EndIf
                        Case 3.0
                            showentity(local0\Field0)
                            showentity(local0\Field4)
                            local12 = local0\Field14
                            local8 = curveangle((Float find860angle(local0, local52)), (entityyaw(local0\Field4, $00) + 90.0), 40.0)
                            rotateentity(local0\Field4, 0.0, (local8 - 90.0), 0.0, $01)
                            If (local0\Field16 = $00) Then
                                local0\Field16 = loadsound_strict("SFX\General\Slash1.ogg")
                            EndIf
                            If (local0\Field19 = $00) Then
                                local0\Field19 = loadsound_strict("SFX\General\Slash2.ogg")
                            EndIf
                            If ((((1.1 > local6) Or ((451.0 < local0\Field14) And (493.0 > local0\Field14))) Or (0.0 > killtimer)) <> 0) Then
                                If (local0\Field74 = networkserver\Field28) Then
                                    deathmsg = ""
                                    local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                                    animatenpc(local0, 451.0, 493.0, 0.5, $00)
                                    If (((461.0 > local12) And (461.0 <= local0\Field14)) <> 0) Then
                                        If (0.0 <= killtimer) Then
                                            kill("was killed by SCP-860", $00)
                                            killanim = $00
                                        EndIf
                                        playsound_strict(local0\Field16)
                                    EndIf
                                    If (((476.0 > local12) And (476.0 <= local0\Field14)) <> 0) Then
                                        playsound_strict(local0\Field19)
                                    EndIf
                                    If (((486.0 > local12) And (486.0 <= local0\Field14)) <> 0) Then
                                        playsound_strict(local0\Field19)
                                    EndIf
                                EndIf
                            Else
                                local0\Field22 = curvevalue((local0\Field21 * 0.8), local0\Field22, 10.0)
                                animatenpc(local0, 298.0, 316.0, (local0\Field22 * 10.0), $01)
                                If (((307.0 > local12) And (307.0 <= local0\Field14)) <> 0) Then
                                    playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 10.0, 1.0)
                                EndIf
                            EndIf
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                    End Select
                    If (0.0 <> local0\Field9) Then
                        rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                        positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.1), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field0, (entitypitch(local0\Field4, $00) - 90.0), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
                        If (8.0 < local6) Then
                            showentity(local0\Field1)
                            entityalpha(local0\Field1, min((local6 - 8.0), 1.0))
                            positionentity(local0\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                            moveentity(local0\Field1, 0.0, 0.75, -0.825)
                            local25 = createpivot($00)
                            positionentity(local25, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                            pointentity(local25, local0\Field1, 0.0)
                            moveentity(local25, 0.0, 0.0, 8.0)
                            positionentity(local0\Field1, entityx(local25, $00), entityy(local25, $00), entityz(local25, $00), $00)
                            freeentity(local25)
                        Else
                            hideentity(local0\Field1)
                        EndIf
                    EndIf
                EndIf
            Case $0F
                If (66.0 > local0\Field9) Then
                    Select local0\Field9
                        Case 0.0
                            animatenpc(local0, 290.0, 405.0, 0.1, $01)
                        Case 1.0
                            If (((644.0 <= local0\Field14) And (683.0 > local0\Field14)) <> 0) Then
                                local0\Field22 = curvevalue((local0\Field21 * 0.05), local0\Field22, 10.0)
                                animatenpc(local0, 644.0, 683.0, ((local0\Field22 * 28.0) * 4.0), $00)
                                If (682.0 <= local0\Field14) Then
                                    local0\Field14 = 175.0
                                EndIf
                            Else
                                local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                                animatenpc(local0, 175.0, 297.0, 0.22, $00)
                                If (296.0 <= local0\Field14) Then
                                    local0\Field9 = 2.0
                                EndIf
                            EndIf
                            local0\Field26 = $00
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                        Case 2.0
                            For local4 = Each rooms
                                If (local4\Field7\Field11 = "room3storage") Then
                                    local61 = local4
                                    Exit
                                EndIf
                            Next
                            local0\Field10 = max(local0\Field10, (Float (local0\Field12 - $03)))
                            local6 = entitydistance(local0\Field4, local61\Field25[(Int local0\Field10)])
                            local0\Field22 = curvevalue(((local0\Field21 * 0.3) * min(local6, 1.0)), local0\Field22, 10.0)
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                            local12 = local0\Field14
                            animatenpc(local0, 644.0, 683.0, (local0\Field22 * 28.0), $01)
                            If ((((664.0 > local12) And (664.0 <= local0\Field14)) Or ((673.0 < local12) And (654.0 > local0\Field14))) <> 0) Then
                                playsound2(stepsfx($04, $00, rand($00, $03)), camera, local0\Field4, 12.0, 1.0)
                                If (rand($0A, $01) = $01) Then
                                    local19 = $00
                                    If (local0\Field17 = $00) Then
                                        local19 = $01
                                    ElseIf (channelplaying(local0\Field17) = $00) Then
                                        local19 = $01
                                    EndIf
                                    If (local19 <> 0) Then
                                        If (local0\Field16 <> $00) Then
                                            freesound_strict(local0\Field16)
                                            local0\Field16 = $00
                                        EndIf
                                        local0\Field16 = loadsound_strict((((("SFX\SCP\939\" + (Str (local0\Field6 Mod $03))) + "Lure") + (Str rand($01, $0A))) + ".ogg"))
                                        local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 10.0, 1.0)
                                    EndIf
                                EndIf
                            EndIf
                            pointentity(local0\Field0, local61\Field25[(Int local0\Field10)], 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                            If (0.4 > local6) Then
                                local0\Field10 = (local0\Field10 + 1.0)
                                If ((Float local0\Field12) < local0\Field10) Then
                                    local0\Field10 = (Float (local0\Field12 - $03))
                                EndIf
                                local0\Field9 = 1.0
                            EndIf
                        Case 3.0
                            If (entityvisible(local0\Field73, local0\Field4) <> 0) Then
                                If (local0\Field19 = $00) Then
                                    local0\Field19 = loadsound_strict("SFX\General\Slash1.ogg")
                                EndIf
                                local0\Field33 = entityx(local0\Field73, $00)
                                local0\Field35 = entityz(local0\Field73, $00)
                                local0\Field26 = $46
                            EndIf
                            If (((local0\Field26 > $00) And (notarget = $00)) <> 0) Then
                                local12 = local0\Field14
                                If (((18.0 <= local0\Field14) And (68.0 > local0\Field14)) <> 0) Then
                                    local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                                    animatenpc(local0, 18.0, 68.0, 0.5, $01)
                                    local19 = $00
                                    If (((24.0 > local12) And (24.0 <= local0\Field14)) <> 0) Then
                                        local19 = $01
                                    ElseIf (((57.0 > local12) And (57.0 <= local0\Field14)) <> 0) Then
                                        local19 = $01
                                    EndIf
                                    If (local19 <> 0) Then
                                        If (1.5 > distance(entityx(local0\Field73, $00), entityz(local0\Field73, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))) Then
                                            If (local0\Field74 = networkserver\Field28) Then
                                                playsound_strict(local0\Field19)
                                                multiplayer_writetempsound("SFX\General\Slash1.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
                                                injuries = ((rnd(1.5, 2.5) + injuries) - ((Float wearingvest) * 0.5))
                                                blurtimer = 500.0
                                            Else
                                                givedamage(local0\Field74, rnd(1.5, 2.5))
                                            EndIf
                                        Else
                                            local0\Field14 = 449.0
                                        EndIf
                                    EndIf
                                    If (((4.0 < injuries) And (local0\Field74 = networkserver\Field28)) <> 0) Then
                                        deathmsg = (chr($22) + "All four (4) escaped SCP-939 specimens have been captured and recontained successfully. ")
                                        deathmsg = ((deathmsg + "Three (3) of them made quite a mess at Storage Area 6. A cleaning team has been dispatched.") + chr($22))
                                        kill("was killed by SCP-939", $00)
                                    EndIf
                                ElseIf (local0\Field26 = $46) Then
                                    local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                    animatenpc(local0, 449.0, 464.0, (local0\Field22 * 6.0), $01)
                                    If ((((452.0 > local12) And (452.0 <= local0\Field14)) Or ((459.0 > local12) And (459.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($01, $01, rand($00, $07)), camera, local0\Field4, 12.0, 1.0)
                                    EndIf
                                    If (1.1 > distance(entityx(local0\Field73, $00), entityz(local0\Field73, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))) Then
                                        local0\Field14 = 18.0
                                    EndIf
                                Else
                                    local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                                    animatenpc(local0, 175.0, 297.0, (local0\Field22 * 5.0), $01)
                                EndIf
                                local8 = vectoryaw((entityx(local0\Field73, $00) - entityx(local0\Field4, $00)), 0.0, (local0\Field35 - entityz(local0\Field4, $00)))
                                rotateentity(local0\Field4, 0.0, curveangle(local8, entityyaw(local0\Field4, $00), 15.0), 0.0, $00)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                local0\Field26 = (Int ((Float local0\Field26) - fpsfactor))
                            Else
                                local0\Field9 = 2.0
                            EndIf
                        Case 5.0
                            If (68.0 > local0\Field14) Then
                                animatenpc(local0, 18.0, 68.0, 0.5, $00)
                            Else
                                animatenpc(local0, 464.0, 473.0, 0.5, $00)
                            EndIf
                    End Select
                    If ((((3.0 > local0\Field9) And (notarget = $00)) And (local0\Field50 = $00)) <> 0) Then
                        local6 = entitydistance(local0\Field4, local0\Field73)
                        If (4.0 > local6) Then
                            local6 = (local6 - (Float entityvisible(local0\Field73, local0\Field4)))
                        EndIf
                        If (((local6 < (player[local0\Field74]\Field36 * 1.2)) Or (1.5 > local6)) <> 0) Then
                            If (0.0 = local0\Field11) Then
                                If (local0\Field16 <> $00) Then
                                    freesound_strict(local0\Field16)
                                    local0\Field16 = $00
                                EndIf
                                local0\Field16 = loadsound_strict((((("SFX\SCP\939\" + (Str (local0\Field6 Mod $03))) + "Attack") + (Str rand($01, $03))) + ".ogg"))
                                local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 10.0, 1.0)
                                If (local0\Field74 = networkserver\Field28) Then
                                    playsound_strict(loadtempsound("SFX\SCP\939\attack.ogg"))
                                EndIf
                                local0\Field11 = 1.0
                            EndIf
                            local0\Field9 = 3.0
                        ElseIf (local6 < (player[local0\Field74]\Field36 * 1.6)) Then
                            If (((1.0 <> local0\Field9) And (0.0 >= local0\Field25)) <> 0) Then
                                If (local0\Field16 <> $00) Then
                                    freesound_strict(local0\Field16)
                                    local0\Field16 = $00
                                EndIf
                                local0\Field16 = loadsound_strict((((("SFX\SCP\939\" + (Str (local0\Field6 Mod $03))) + "Alert") + (Str rand($01, $03))) + ".ogg"))
                                local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 10.0, 1.0)
                                local0\Field14 = 175.0
                                local0\Field25 = 210.0
                            EndIf
                            local0\Field9 = 1.0
                        EndIf
                        local0\Field25 = (local0\Field25 - fpsfactor)
                    EndIf
                    rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.28), entityz(local0\Field4, $00), $00)
                    rotateentity(local0\Field0, (entitypitch(local0\Field4, $00) - 90.0), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
                EndIf
            Case $10
                local6 = distance(entityx(local0\Field73, $00), entityz(local0\Field73, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))
                Select local0\Field9
                    Case 0.0
                        If (20.0 < local6) Then
                            animatenpc(local0, 451.0, 612.0, 0.2, $01)
                            If ((Float millisecs2()) > local0\Field10) Then
                                For local24 = Each waypoints
                                    If (local24\Field1 = Null) Then
                                        If (4.0 > (Abs (entityx(local24\Field0, $01) - entityx(local0\Field4, $00)))) Then
                                            If (4.0 > (Abs (entityz(local24\Field0, $01) - entityz(local0\Field4, $00)))) Then
                                                positionentity(local0\Field4, entityx(local24\Field0, $01), (entityy(local24\Field0, $01) + 0.3), entityz(local24\Field0, $01), $00)
                                                resetentity(local0\Field4)
                                                Exit
                                            EndIf
                                        EndIf
                                    EndIf
                                Next
                                local0\Field10 = (Float (millisecs2() + $1388))
                            EndIf
                        ElseIf (8.0 > local6) Then
                            local0\Field27 = rnd(1.0, 2.5)
                            local0\Field9 = 1.0
                        EndIf
                    Case 1.0
                        If (451.0 > local0\Field14) Then
                            local8 = wrapangle(curveangle((deltayaw(local0\Field4, local0\Field73) - 180.0), ((animtime(local0\Field0) - 2.0) / 1.2445), 15.0))
                            setnpcframe(local0, ((local8 * 1.2445) + 2.0))
                        Else
                            animatenpc(local0, 636.0, 646.0, 0.4, $00)
                            If (646.0 = local0\Field14) Then
                                setnpcframe(local0, 2.0)
                            EndIf
                        EndIf
                        local6 = distance(entityx(local0\Field73, $00), entityz(local0\Field73, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))
                        If (rand($2BC, $01) = $01) Then
                            playsound2(loadtempsound((("SFX\SCP\066\Eric" + (Str rand($01, $03))) + ".ogg")), camera, local0\Field4, 8.0, 1.0)
                        EndIf
                        If (local6 < (local0\Field27 + 1.0)) Then
                            local0\Field9 = (Float rand($02, $03))
                        EndIf
                    Case 2.0
                        If (647.0 > local0\Field14) Then
                            local8 = curveangle(0.0, ((animtime(local0\Field0) - 2.0) / 1.2445), 5.0)
                            If (((5.0 > local8) Or (355.0 < local8)) <> 0) Then
                                setnpcframe(local0, 647.0)
                            Else
                                setnpcframe(local0, ((local8 * 1.2445) + 2.0))
                            EndIf
                        ElseIf (683.0 = local0\Field14) Then
                            If (0.0 = local0\Field10) Then
                                If (rand($02, $01) = $01) Then
                                    playsound2(loadtempsound((("SFX\SCP\066\Eric" + (Str rand($01, $03))) + ".ogg")), camera, local0\Field4, 8.0, 1.0)
                                Else
                                    playsound2(loadtempsound((("SFX\SCP\066\Notes" + (Str rand($01, $06))) + ".ogg")), camera, local0\Field4, 8.0, 1.0)
                                EndIf
                                Select rand($01, $06)
                                    Case $01
                                        If (local0\Field19 = $00) Then
                                            local0\Field19 = loadsound_strict("SFX\SCP\066\Beethoven.ogg")
                                        EndIf
                                        local0\Field20 = playsound2(local0\Field19, camera, local0\Field4, 10.0, 1.0)
                                        deaftimer = (Float (((selecteddifficulty\Field3 * $0F) + $2D) * $46))
                                        deafplayer = $01
                                        camerashake = 10.0
                                    Case $02
                                        local0\Field11 = (Float rand($2BC, $578))
                                    Case $03
                                        For local2 = Each doors
                                            If ((((local2\Field4 = $00) And (local2\Field12 = $00)) And (local2\Field17 = "")) <> 0) Then
                                                If (16.0 > (Abs (entityx(local2\Field2, $00) - entityx(local0\Field4, $00)))) Then
                                                    If (16.0 > (Abs (entityz(local2\Field2, $00) - entityz(local0\Field4, $00)))) Then
                                                        usedoor(local2, $00, $01, $00, "", $00)
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    Case $04
                                        If (((playerroom\Field7\Field14 = $00) And (local0\Field74 = networkserver\Field28)) <> 0) Then
                                            camerashake = 5.0
                                            local3 = createdecal($01, entityx(local0\Field4, $00), 0.01, entityz(local0\Field4, $00), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                            local3\Field2 = 0.3
                                            updatedecals()
                                            playsound_strict(loadtempsound("SFX\General\BodyFall.ogg"))
                                            multiplayer_writetempsound("SFX\General\BodyFall.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
                                            If (0.8 > distance(entityx(local0\Field73, $00), entityz(local0\Field73, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))) Then
                                                injuries = (rnd(0.3, 0.5) + injuries)
                                            EndIf
                                        EndIf
                                End Select
                            EndIf
                            local0\Field10 = (local0\Field10 + fpsfactor)
                            If (70.0 < local0\Field10) Then
                                local0\Field9 = 3.0
                                local0\Field10 = 0.0
                            EndIf
                        Else
                            local0\Field22 = curvevalue((local0\Field21 * 1.5), local0\Field22, 10.0)
                            pointentity(local0\Field0, local0\Field73, 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle((entityyaw(local0\Field0, $00) - 180.0), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                            animatenpc(local0, 647.0, 683.0, (local0\Field22 * 25.0), $00)
                            moveentity(local0\Field4, 0.0, 0.0, ((- local0\Field22) * fpsfactor))
                        EndIf
                    Case 3.0
                        pointentity(local0\Field0, local0\Field73, 0.0)
                        local8 = curveangle(((entityyaw(local0\Field0, $00) + local0\Field15) - 180.0), entityyaw(local0\Field4, $00), 10.0)
                        rotateentity(local0\Field4, 0.0, local8, 0.0, $00)
                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                        If (rand($64, $01) = $01) Then
                            local0\Field15 = rnd(-20.0, 20.0)
                        EndIf
                        local0\Field10 = (local0\Field10 + fpsfactor)
                        If (250.0 < local0\Field10) Then
                            animatenpc(local0, 684.0, 647.0, ((- local0\Field22) * 25.0), $00)
                            If (647.0 = local0\Field14) Then
                                local0\Field9 = 0.0
                                local0\Field10 = 0.0
                            EndIf
                        Else
                            animatenpc(local0, 684.0, 647.0, ((- local0\Field22) * 25.0), $01)
                        EndIf
                End Select
                If (1.0 < local0\Field9) Then
                    If (local0\Field16 = $00) Then
                        local0\Field16 = loadsound_strict("SFX\SCP\066\Rolling.ogg")
                    EndIf
                    If (local0\Field17 <> $00) Then
                        If (channelplaying(local0\Field17) <> 0) Then
                            local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 20.0, 1.0)
                        EndIf
                    Else
                        local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 20.0, 1.0)
                    EndIf
                EndIf
                If (0.0 < local0\Field11) Then
                    local0\Field11 = (local0\Field11 - fpsfactor)
                    lightvolume = (templightvolume - (min(max((local0\Field11 / 500.0), 0.01), 0.6) * templightvolume))
                    heartbeatrate = max(heartbeatrate, 130.0)
                    heartbeatvolume = max(heartbeatvolume, min((local0\Field11 / 1000.0), 1.0))
                EndIf
                If (channelplaying(local0\Field20) <> 0) Then
                    updatesoundorigin2(local0\Field20, camera, local0\Field4, 20.0, 1.0)
                    blurtimer = max(((5.0 - local6) * 300.0), 0.0)
                EndIf
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, (entitypitch(local0\Field4, $00) - 90.0), entityyaw(local0\Field4, $00), 0.0, $00)
            Case $12
                local6 = entitydistance(local0\Field4, local0\Field73)
                If (hidedistance > local6) Then
                    local12 = local0\Field14
                    If (local0\Field16 > $00) Then
                        local19 = $00
                        If (0.0 < local0\Field9) Then
                            local19 = $01
                        EndIf
                        local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, camera, 10.0, (Float local19))
                    EndIf
                    local19 = (Int rnd(-1.0, 1.0))
                    positionentity(local0\Field0, entityx(local0\Field4, $01), (entityy(local0\Field4, $01) - 0.2), entityz(local0\Field4, $01), $00)
                    rotateentity(local0\Field0, -90.0, entityyaw(local0\Field4, $00), 0.0, $00)
                    If (wearingnightvision = $00) Then
                        hideentity(local0\Field0)
                        If ((((1.0 > local6) And (0.0 >= local0\Field25)) And (0.0 >= msgtimer)) <> 0) Then
                            If (local0\Field74 = networkserver\Field28) Then
                                Select rand($06, $01)
                                    Case $01
                                        msg = "You feel something breathing right next to you."
                                    Case $02
                                        msg = ((chr($22) + "It feels like something's in this room with me.") + chr($22))
                                    Case $03
                                        msg = "You feel like something is here with you, but you do not see anything."
                                    Case $04
                                        msg = ((chr($22) + "Is my mind playing tricks on me or is there someone else here?") + chr($22))
                                    Case $05
                                        msg = "You feel like something is following you."
                                    Case $06
                                        msg = "You can feel something near you, but you are unable to see it. Perhaps its time is now."
                                End Select
                                msgtimer = 560.0
                            EndIf
                            local0\Field25 = 1400.0
                        EndIf
                        local0\Field25 = (local0\Field25 - fpsfactor)
                    Else
                        showentity(local0\Field0)
                    EndIf
                    If (350.0 < local0\Field11) Then
                        If (1000.0 > local0\Field11) Then
                            For local1 = Each npcs
                                If (local1\Field5 = local0\Field5) Then
                                    local1\Field11 = 1000.0
                                EndIf
                            Next
                        EndIf
                        local0\Field9 = max(local0\Field9, 8.0)
                        local0\Field11 = 1000.0
                    EndIf
                    If (10.0 > stamina) Then
                        local0\Field11 = (local0\Field11 + fpsfactor)
                    ElseIf (900.0 > local0\Field11) Then
                        local0\Field11 = max((local0\Field11 - (fpsfactor * 0.2)), 0.0)
                    EndIf
                    If (10.0 <> local0\Field9) Then
                        local0\Field26 = $00
                    EndIf
                    Select local0\Field9
                        Case 0.0
                            If (556.0 < local0\Field14) Then
                                animatenpc(local0, 628.0, 652.0, 0.25, $00)
                                If (651.0 < local0\Field14) Then
                                    setnpcframe(local0, 2.0)
                                EndIf
                            Else
                                animatenpc(local0, 2.0, 214.0, 0.25, $00)
                                If (213.0 < local0\Field14) Then
                                    If (((rand($03, $01) = $01) And (4.0 > local6)) <> 0) Then
                                        local0\Field9 = (Float rand($01, $04))
                                    Else
                                        local0\Field9 = (Float rand($05, $06))
                                    EndIf
                                EndIf
                                If (2.0 > local6) Then
                                    local0\Field9 = (Float rand($01, $04))
                                EndIf
                            EndIf
                            local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                            moveentity(local0\Field4, 0.0, 0.0, local0\Field22)
                        Case 1.0,2.0
                            animatenpc(local0, 214.0, 257.0, 0.25, $00)
                            If (256.0 < local0\Field14) Then
                                local0\Field9 = 0.0
                            EndIf
                            If (((228.0 < local0\Field14) And (228.0 >= local12)) <> 0) Then
                                playsound2(loadtempsound((("SFX\SCP\966\Echo" + (Str rand($01, $03))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                            EndIf
                            local8 = vectoryaw((entityx(local0\Field73, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(local0\Field73, $00) - entityz(local0\Field4, $00)))
                            rotateentity(local0\Field4, 0.0, curveangle(local8, entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                            If (((900.0 > local0\Field11) And (local0\Field74 = networkserver\Field28)) <> 0) Then
                                blurtimer = (((sin((Float (millisecs2() / $32))) + 1.0) * 200.0) / local6)
                                If (wearingnightvision > $00) Then
                                    giveachievement($16, $01)
                                EndIf
                                If (((((wearing714 = $00) And (wearinggasmask < $03)) And (wearinghazmat < $03)) And (16.0 > local6)) <> 0) Then
                                    blinkeffect = max(blinkeffect, 1.5)
                                    blinkeffecttimer = 1000.0
                                    staminaeffect = 2.0
                                    staminaeffecttimer = 1000.0
                                    If (((0.0 >= msgtimer) And (1.5 > staminaeffect)) <> 0) Then
                                        Select rand($04, $01)
                                            Case $01
                                                msg = "You feel exhausted."
                                            Case $02
                                                msg = ((chr($22) + "Could really go for a nap now...") + chr($22))
                                            Case $03
                                                msg = ((chr($22) + "If I wasn't in this situation I would take a nap somewhere.") + chr($22))
                                            Case $04
                                                msg = "You feel restless."
                                        End Select
                                        msgtimer = 490.0
                                    EndIf
                                EndIf
                            EndIf
                        Case 3.0,4.0
                            If (3.0 = local0\Field9) Then
                                animatenpc(local0, 257.0, 332.0, 0.25, $00)
                                If (331.0 < local0\Field14) Then
                                    local0\Field9 = 0.0
                                EndIf
                            Else
                                animatenpc(local0, 332.0, 457.0, 0.25, $00)
                                If (456.0 < local0\Field14) Then
                                    local0\Field9 = 0.0
                                EndIf
                            EndIf
                            If (((((271.0 < local0\Field14) And (271.0 >= local12)) Or ((301.0 < local0\Field14) And (301.0 >= local12))) Or ((314.0 < local0\Field14) And (314.0 >= local12))) <> 0) Then
                                If (channelplaying(local0\Field96) = $00) Then
                                    local0\Field96 = playsound2(loadtempsound((("SFX\SCP\966\Idle" + (Str rand($01, $03))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                                EndIf
                            EndIf
                            local8 = vectoryaw((entityx(local0\Field73, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(local0\Field73, $00) - entityz(local0\Field4, $00)))
                            rotateentity(local0\Field4, 0.0, curveangle(local8, entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                        Case 5.0,6.0,8.0
                            If (((580.0 > local0\Field14) And (214.0 < local0\Field14)) <> 0) Then
                                animatenpc(local0, 556.0, 580.0, 0.25, $00)
                            Else
                                If (0.005 <= local0\Field22) Then
                                    animatenpc(local0, 580.0, 628.0, (local0\Field22 * 25.0), $01)
                                Else
                                    animatenpc(local0, 2.0, 214.0, 0.25, $01)
                                EndIf
                                If (((8.0 = local0\Field9) And (32.0 > local6)) <> 0) Then
                                    If (0.0 >= local0\Field38) Then
                                        local0\Field37 = findpath(local0, entityx(local0\Field73, $01), entityy(local0\Field73, $01), entityz(local0\Field73, $01))
                                        local0\Field38 = 400.0
                                        local0\Field22 = 0.0
                                    EndIf
                                    local0\Field38 = max((local0\Field38 - fpsfactor), 0.0)
                                    If (entityvisible(local0\Field4, local0\Field73) = $00) Then
                                        If (local0\Field37 = $02) Then
                                            local0\Field22 = 0.0
                                            setnpcframe(local0, 2.0)
                                        ElseIf (local0\Field37 = $01) Then
                                            If (local0\Field36[local0\Field39] = Null) Then
                                                If (local0\Field39 > $13) Then
                                                    local0\Field39 = $00
                                                    local0\Field37 = $00
                                                Else
                                                    local0\Field39 = (local0\Field39 + $01)
                                                EndIf
                                            Else
                                                local0\Field15 = vectoryaw((entityx(local0\Field36[local0\Field39]\Field0, $01) - entityx(local0\Field4, $00)), 0.0, (entityz(local0\Field36[local0\Field39]\Field0, $01) - entityz(local0\Field4, $00)))
                                                local7 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                                local19 = $01
                                                If (0.8 > local7) Then
                                                    If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                        If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                            If ((((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 <> $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) And (local0\Field36[local0\Field39]\Field1\Field5 = $00)) <> 0) Then
                                                                local19 = $00
                                                            ElseIf (((local0\Field36[local0\Field39]\Field1\Field5 = $00) And ((local0\Field36[local0\Field39]\Field1\Field3[$00] <> $00) Or (local0\Field36[local0\Field39]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                                usedoor(local0\Field36[local0\Field39]\Field1, $00, $01, $00, "", $00)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                    If (0.3 > local7) Then
                                                        local0\Field39 = (local0\Field39 + $01)
                                                    EndIf
                                                EndIf
                                                If (local19 = $00) Then
                                                    local0\Field37 = $00
                                                    local0\Field39 = $00
                                                    local0\Field38 = 400.0
                                                EndIf
                                            EndIf
                                            local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                        ElseIf (local0\Field37 = $00) Then
                                            local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                                        EndIf
                                    Else
                                        local0\Field15 = vectoryaw((entityx(local0\Field73, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(local0\Field73, $00) - entityz(local0\Field4, $00)))
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                        If (1.0 > local6) Then
                                            local0\Field9 = 10.0
                                        EndIf
                                    EndIf
                                Else
                                    If ((((Float millisecs2()) > local0\Field10) And (16.0 > local6)) <> 0) Then
                                        hideentity(local0\Field4)
                                        entitypick(local0\Field4, 1.5)
                                        If (pickedentity() <> $00) Then
                                            local0\Field15 = (entityyaw(local0\Field4, $00) + rnd(80.0, 110.0))
                                        EndIf
                                        showentity(local0\Field4)
                                        local0\Field10 = (Float (millisecs2() + $3E8))
                                        If (rand($05, $01) = $01) Then
                                            local0\Field9 = 0.0
                                        EndIf
                                    EndIf
                                    local0\Field22 = curvevalue((local0\Field21 * 0.5), local0\Field22, 20.0)
                                EndIf
                                If ((((604.0 > local12) And (604.0 <= local0\Field14)) Or ((627.0 > local12) And (627.0 <= local0\Field14))) <> 0) Then
                                    playsound2(stepsfx($04, $00, rand($00, $03)), camera, local0\Field4, 7.0, rnd(0.5, 0.7))
                                EndIf
                                rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                            EndIf
                        Case 10.0
                            If (local0\Field26 = $00) Then
                                playsound2(loadtempsound((("SFX\SCP\966\Echo" + (Str rand($01, $03))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                                local0\Field26 = $01
                            EndIf
                            If (557.0 < local0\Field14) Then
                                animatenpc(local0, 628.0, 652.0, 0.25, $00)
                                If (651.0 < local0\Field14) Then
                                    Select rand($03, $01)
                                        Case $01
                                            setnpcframe(local0, 458.0)
                                        Case $02
                                            setnpcframe(local0, 488.0)
                                        Case $03
                                            setnpcframe(local0, 518.0)
                                    End Select
                                EndIf
                            ElseIf (487.0 >= local0\Field14) Then
                                animatenpc(local0, 458.0, 487.0, 0.3, $00)
                                If (486.0 < local0\Field14) Then
                                    local0\Field9 = 8.0
                                EndIf
                            ElseIf (517.0 >= local0\Field14) Then
                                animatenpc(local0, 488.0, 517.0, 0.3, $00)
                                If (516.0 < local0\Field14) Then
                                    local0\Field9 = 8.0
                                EndIf
                            ElseIf (557.0 >= local0\Field14) Then
                                animatenpc(local0, 518.0, 557.0, 0.3, $00)
                                If (556.0 < local0\Field14) Then
                                    local0\Field9 = 8.0
                                EndIf
                            EndIf
                            If (1.0 > local6) Then
                                If (((((((470.0 < local0\Field14) And (470.0 >= local12)) Or (500.0 < local0\Field14)) And (500.0 >= local12)) Or (527.0 < local0\Field14)) And (527.0 >= local12)) <> 0) Then
                                    If (local0\Field74 = networkserver\Field28) Then
                                        playsound2(loadtempsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                                        multiplayer_writetempsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"), entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), 10.0, 1.0)
                                        injuries = (rnd(0.5, 1.0) + injuries)
                                    Else
                                        givedamage(local0\Field74, rnd(0.5, 1.0))
                                    EndIf
                                EndIf
                            EndIf
                            local0\Field15 = vectoryaw((entityx(local0\Field73, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(local0\Field73, $00) - entityz(local0\Field4, $00)))
                            rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                    End Select
                Else
                    hideentity(local0\Field0)
                    If (rand($258, $01) = $01) Then
                        teleportcloser(local0)
                    EndIf
                EndIf
                If (wearingnightvision = $00) Then
                    hideentity(local0\Field0)
                EndIf
            Case $13
                local68 = local0\Field9
                If (1.0 = local68) Then
                    local0\Field37 = findpath(local0, local0\Field33, (local0\Field34 + 0.1), local0\Field35)
                EndIf
            Case $14
                local12 = local0\Field14
                If (((0.0 = local0\Field24) And ((hidedistance * 3.0) > entitydistance(local0\Field4, local0\Field73))) <> 0) Then
                    If (local0\Field12 = $00) Then
                        If (((0.0 = local0\Field9) Or (2.0 = local0\Field9)) <> 0) Then
                            For local1 = Each npcs
                                If (((local1\Field5 = local0\Field5) And (local1 <> local0)) <> 0) Then
                                    If (((0.0 <> local1\Field9) And (2.0 <> local1\Field9)) <> 0) Then
                                        If (local1\Field12 = $00) Then
                                            local0\Field9 = 1.0
                                            local0\Field10 = 0.0
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                    Select local0\Field9
                        Case 0.0
                            If (local0\Field12 = $00) Then
                                If (0.0 = local0\Field22) Then
                                    If (0.0 = local0\Field25) Then
                                        If ((rnd(1.0, 3.0) * 500.0) > local0\Field10) Then
                                            local0\Field22 = 0.0
                                            local0\Field10 = (local0\Field10 + fpsfactor)
                                        ElseIf (0.0 = local0\Field22) Then
                                            local0\Field22 = (local0\Field22 + 0.0001)
                                        EndIf
                                    ElseIf (1500.0 > local0\Field10) Then
                                        local0\Field22 = 0.0
                                        local0\Field10 = (local0\Field10 + fpsfactor)
                                    Else
                                        If (local0\Field31 <> Null) Then
                                            If (local0\Field31\Field31 <> Null) Then
                                                local0\Field31\Field31 = Null
                                            EndIf
                                            local0\Field31\Field25 = 0.0
                                            local0\Field31\Field15 = (local0\Field31\Field15 + rnd(-45.0, 45.0))
                                            local0\Field31 = Null
                                            local0\Field25 = 0.0
                                            local0\Field15 = (local0\Field15 + rnd(-45.0, 45.0))
                                        EndIf
                                        If (0.0 = local0\Field22) Then
                                            local0\Field22 = (local0\Field22 + 0.0001)
                                        EndIf
                                    EndIf
                                Else
                                    If (local0\Field31 <> Null) Then
                                        local0\Field10 = 0.0
                                    EndIf
                                    If ((rnd(1.0, 3.0) * 10000.0) > local0\Field10) Then
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                        local0\Field10 = (local0\Field10 + fpsfactor)
                                    Else
                                        local0\Field22 = curvevalue(0.0, local0\Field22, 50.0)
                                    EndIf
                                    rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    If (local0\Field31 = Null) Then
                                        If (rand($C8, $01) = $01) Then
                                            local0\Field15 = (local0\Field15 + rnd(-45.0, 45.0))
                                        EndIf
                                        hideentity(local0\Field4)
                                        entitypick(local0\Field4, 1.5)
                                        If (pickedentity() <> $00) Then
                                            local0\Field15 = (entityyaw(local0\Field4, $00) + rnd(80.0, 110.0))
                                        EndIf
                                        showentity(local0\Field4)
                                    Else
                                        local0\Field15 = (deltayaw(local0\Field4, local0\Field31\Field4) + entityyaw(local0\Field4, $00))
                                        If (1.5 > entitydistance(local0\Field4, local0\Field31\Field4)) Then
                                            local0\Field22 = 0.0
                                            local0\Field31\Field22 = 0.0
                                            local0\Field25 = 1.0
                                            local0\Field31\Field25 = 1.0
                                            local19 = rand($00, $02)
                                            If (local19 = $00) Then
                                                setnpcframe(local0, 296.0)
                                            ElseIf (local19 = $01) Then
                                                setnpcframe(local0, 856.0)
                                            Else
                                                setnpcframe(local0, 905.0)
                                            EndIf
                                            local19 = rand($00, $02)
                                            If (local19 = $00) Then
                                                setnpcframe(local0\Field31, 296.0)
                                            ElseIf (local19 = $01) Then
                                                setnpcframe(local0\Field31, 856.0)
                                            Else
                                                setnpcframe(local0\Field31, 905.0)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Else
                                rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                            EndIf
                            If (0.0 = local0\Field22) Then
                                If (((0.0 = local0\Field25) And (local0\Field12 <> $02)) <> 0) Then
                                    animatenpc(local0, 296.0, 320.0, 0.2, $01)
                                ElseIf (((0.0 = local0\Field25) And (local0\Field12 = $02)) <> 0) Then
                                    If (532.5 >= local0\Field14) Then
                                        animatenpc(local0, 509.0, 533.0, 0.2, $00)
                                    ElseIf (((533.5 < local0\Field14) And (600.5 >= local0\Field14)) <> 0) Then
                                        animatenpc(local0, 534.0, 601.0, 0.2, $00)
                                    Else
                                        local19 = rand($00, $01)
                                        If (local19 = $00) Then
                                            setnpcframe(local0, 509.0)
                                        Else
                                            setnpcframe(local0, 534.0)
                                        EndIf
                                    EndIf
                                ElseIf (local0\Field12 = $02) Then
                                    animatenpc(local0, 713.0, 855.0, 0.2, $00)
                                    If (833.5 < local0\Field14) Then
                                        pointentity(local0\Field0, local0\Field73, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    EndIf
                                ElseIf (local0\Field12 = $01) Then
                                    animatenpc(local0, 602.0, 712.0, 0.2, $00)
                                    If (711.5 < local0\Field14) Then
                                        local0\Field25 = 0.0
                                    EndIf
                                ElseIf (319.5 >= local0\Field14) Then
                                    animatenpc(local0, 296.0, 320.0, 0.2, $00)
                                ElseIf (((320.5 < local0\Field14) And (903.5 > local0\Field14)) <> 0) Then
                                    animatenpc(local0, 856.0, 904.0, 0.2, $00)
                                ElseIf (((904.5 < local0\Field14) And (952.5 > local0\Field14)) <> 0) Then
                                    animatenpc(local0, 905.0, 953.0, 0.2, $00)
                                Else
                                    local19 = rand($00, $02)
                                    If (local19 = $00) Then
                                        setnpcframe(local0, 296.0)
                                    ElseIf (local19 = $01) Then
                                        setnpcframe(local0, 856.0)
                                    Else
                                        setnpcframe(local0, 905.0)
                                    EndIf
                                EndIf
                            Else
                                If ((local0\Field6 Mod $02) = $00) Then
                                    animatenpc(local0, 1.0, 62.0, (local0\Field22 * 28.0), $01)
                                Else
                                    animatenpc(local0, 100.0, 167.0, (local0\Field22 * 28.0), $01)
                                EndIf
                                If (local0\Field12 = $00) Then
                                    If (local0\Field31 = Null) Then
                                        If (rand($01, $4B0) = $01) Then
                                            For local1 = Each npcs
                                                If (local1 <> local0) Then
                                                    If (local1\Field5 = local0\Field5) Then
                                                        If (local1\Field31 = Null) Then
                                                            If (local1\Field12 = $00) Then
                                                                If (20.0 > entitydistance(local0\Field4, local1\Field4)) Then
                                                                    local0\Field31 = local1
                                                                    local1\Field31 = local0
                                                                    local0\Field31\Field22 = (local0\Field31\Field22 + 0.0001)
                                                                    Exit
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If (((local0\Field31 = Null) And (local0\Field12 = $00)) <> 0) Then
                                If (rand($1388, $01) = $01) Then
                                    local0\Field9 = 2.0
                                    local0\Field10 = 0.0
                                    If (channelplaying(local0\Field17) = $00) Then
                                        local6 = entitydistance(local0\Field4, local0\Field73)
                                        If (20.0 > local6) Then
                                            If (local0\Field16 <> $00) Then
                                                freesound_strict(local0\Field16)
                                                local0\Field16 = $00
                                            EndIf
                                            local0\Field16 = loadsound_strict((("SFX\SCP\1499\Idle" + (Str rand($01, $04))) + ".ogg"))
                                            local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 20.0, 1.0)
                                        EndIf
                                    EndIf
                                EndIf
                                If ((((local0\Field6 Mod $02) = $00) And (notarget = $00)) <> 0) Then
                                    local6 = entitydistance(local0\Field4, local0\Field73)
                                    If (10.0 > local6) Then
                                        If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                            local0\Field9 = 2.0
                                            If (5.0 > local6) Then
                                                If (local0\Field16 <> $00) Then
                                                    freesound_strict(local0\Field16)
                                                    local0\Field16 = $00
                                                EndIf
                                                local0\Field16 = loadsound_strict("SFX\SCP\1499\Triggered.ogg")
                                                local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 20.0, 1.0)
                                                local0\Field10 = 1.0
                                                For local1 = Each npcs
                                                    If (((local1\Field5 = local0\Field5) And (local1 <> local0)) <> 0) Then
                                                        If (local1\Field12 = $00) Then
                                                            local1\Field9 = 1.0
                                                            local1\Field10 = 0.0
                                                        EndIf
                                                    EndIf
                                                Next
                                            Else
                                                local0\Field10 = 0.0
                                            EndIf
                                            local0\Field14 = 203.0
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (local0\Field12 = $01) Then
                                local6 = entitydistance(local0\Field4, local0\Field73)
                                If (notarget = $00) Then
                                    If (4.0 > local6) Then
                                        If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                            If (local0\Field16 <> $00) Then
                                                freesound_strict(local0\Field16)
                                                local0\Field16 = $00
                                            EndIf
                                            local0\Field16 = loadsound_strict("SFX\SCP\1499\Triggered.ogg")
                                            local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 20.0, 1.0)
                                            local0\Field9 = 1.0
                                            local0\Field14 = 203.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Case 1.0
                            If (notarget <> 0) Then
                                local0\Field9 = 0.0
                            EndIf
                            If (((playerroom\Field7\Field11 = "dimension1499") And (local0\Field12 = $00)) <> 0) Then
                                shouldplay = $13
                            EndIf
                            pointentity(local0\Field0, local0\Field73, 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                            local6 = entitydistance(local0\Field4, local0\Field73)
                            If (0.0 = local0\Field10) Then
                                If (local0\Field12 = $01) Then
                                    local0\Field22 = curvevalue((local0\Field21 * 2.0), local0\Field22, 10.0)
                                    If (local0\Field31 <> Null) Then
                                        local0\Field31\Field9 = 1.0
                                    EndIf
                                Else
                                    local0\Field22 = curvevalue((local0\Field21 * 1.75), local0\Field22, 10.0)
                                EndIf
                                If ((local0\Field6 Mod $02) = $00) Then
                                    animatenpc(local0, 1.0, 62.0, (local0\Field22 * 28.0), $01)
                                Else
                                    animatenpc(local0, 100.0, 167.0, (local0\Field22 * 28.0), $01)
                                EndIf
                            EndIf
                            If (0.75 > local6) Then
                                If (((((((local0\Field6 Mod $02) = $00) Or (1.0 = local0\Field11)) Or (local0\Field12 = $01)) Or (local0\Field12 = $03)) Or (local0\Field12 = $04)) <> 0) Then
                                    local0\Field10 = (Float rand($01, $02))
                                    local0\Field9 = 3.0
                                    If (1.0 = local0\Field10) Then
                                        setnpcframe(local0, 63.0)
                                    Else
                                        setnpcframe(local0, 168.0)
                                    EndIf
                                Else
                                    local0\Field9 = 4.0
                                EndIf
                            EndIf
                        Case 2.0
                            local0\Field22 = 0.0
                            animatenpc(local0, 203.0, 295.0, 0.1, $00)
                            If (294.0 < local0\Field14) Then
                                local0\Field9 = local0\Field10
                            EndIf
                        Case 3.0
                            local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                            local6 = entitydistance(local0\Field4, local0\Field73)
                            If (1.0 = local0\Field10) Then
                                animatenpc(local0, 63.0, 100.0, 0.6, $00)
                                If (((89.0 > local12) And (89.0 <= local0\Field14)) <> 0) Then
                                    If (((0.85 < local6) Or (60.0 < (Abs deltayaw(local0\Field4, local0\Field73)))) = 0) Then
                                        If (local0\Field74 = networkserver\Field28) Then
                                            injuries = (rnd(0.75, 1.5) + injuries)
                                            playsound2(loadtempsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                                            multiplayer_writetempsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"), 0.0, 0.0, 0.0, 10.0, 1.0)
                                            If (10.0 < injuries) Then
                                                kill("was killed by SCP-1499-2", $00)
                                                If (playerroom\Field7\Field11 = "dimension1499") Then
                                                    deathmsg = "All personnel situated within Evacuation Shelter LC-2 during the breach have been administered "
                                                    deathmsg = (deathmsg + "Class-B amnestics due to Incident 1499-E. The Class D subject involved in the event ")
                                                    deathmsg = (deathmsg + "died shortly after being shot by Agent [REDACTED].")
                                                Else
                                                    deathmsg = "An unidentified male and a deceased Class D subject were discovered in [REDACTED] by the Nine-Tailed Fox. "
                                                    deathmsg = (deathmsg + "The man was described as highly agitated and seemed to only speak Russian. ")
                                                    deathmsg = (deathmsg + "He's been taken into a temporary holding area at [REDACTED] while waiting for a translator to arrive.")
                                                EndIf
                                            EndIf
                                        Else
                                            givedamage(local0\Field74, rnd(0.75, 1.5))
                                        EndIf
                                    EndIf
                                ElseIf (99.0 <= local0\Field14) Then
                                    local0\Field10 = 0.0
                                    local0\Field9 = 1.0
                                EndIf
                            Else
                                animatenpc(local0, 168.0, 202.0, 0.6, $00)
                                If (((189.0 > local12) And (189.0 <= local0\Field14)) <> 0) Then
                                    If (((0.85 < local6) Or (60.0 < (Abs deltayaw(local0\Field4, local0\Field73)))) = 0) Then
                                        If (local0\Field74 = networkserver\Field28) Then
                                            injuries = (rnd(0.75, 1.5) + injuries)
                                            playsound2(loadtempsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg")), camera, local0\Field4, 10.0, 1.0)
                                            multiplayer_writesound((Int (("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg")), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                                            If (10.0 < injuries) Then
                                                kill("was killed by SCP-1499-2", $00)
                                                If (playerroom\Field7\Field11 = "dimension1499") Then
                                                    deathmsg = "All personnel situated within Evacuation Shelter LC-2 during the breach have been administered "
                                                    deathmsg = (deathmsg + "Class-B amnestics due to Incident 1499-E. The Class D subject involved in the event ")
                                                    deathmsg = (deathmsg + "died shortly after being shot by Agent [REDACTED].")
                                                Else
                                                    deathmsg = "An unidentified male and a deceased Class D subject were discovered in [REDACTED] by the Nine-Tailed Fox. "
                                                    deathmsg = (deathmsg + "The man was described as highly agitated and seemed to only speak Russian. ")
                                                    deathmsg = (deathmsg + "He's been taken into a temporary holding area at [REDACTED] while waiting for a translator to arrive.")
                                                EndIf
                                            EndIf
                                        Else
                                            givedamage(local0\Field74, rnd(0.75, 1.5))
                                        EndIf
                                    EndIf
                                ElseIf (201.0 <= local0\Field14) Then
                                    local0\Field10 = 0.0
                                    local0\Field9 = 1.0
                                EndIf
                            EndIf
                        Case 4.0
                            local6 = entitydistance(local0\Field4, local0\Field73)
                            local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                            animatenpc(local0, 296.0, 320.0, 0.2, $01)
                            pointentity(local0\Field0, local0\Field73, 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                            If (0.85 < local6) Then
                                local0\Field9 = 1.0
                            EndIf
                    End Select
                    If (((local0\Field17 <> $00) And channelplaying(local0\Field17)) <> 0) Then
                        updatesoundorigin(local0\Field17, camera, local0\Field4, 20.0, 1.0)
                    EndIf
                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                    rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                    showentity(local0\Field0)
                Else
                    hideentity(local0\Field0)
                EndIf
            Case $15
                If (local0\Field48 = $00) Then
                    If (((344.0 <= local0\Field91) And (363.0 >= local0\Field91)) <> 0) Then
                        local0\Field48 = $01
                    EndIf
                    If (0.0 = local0\Field9) Then
                        entitytype(local0\Field4, $06, $00)
                    Else
                        entitytype(local0\Field4, $02, $00)
                    EndIf
                    local12 = local0\Field14
                    local0\Field49 = 1.0
                    Select local0\Field9
                        Case 0.0
                            setnpcframe(local0, 11.0)
                        Case 1.0
                            animatenpc(local0, 11.0, 32.0, 0.1, $00)
                            If (29.0 <= local0\Field14) Then
                                local0\Field9 = 2.0
                            EndIf
                        Case 2.0
                            local13 = menpcseesplayer(local0, $00)
                            If (((local13 = $01) Or (0.0 < local0\Field10)) <> 0) Then
                                If (local13 = $01) Then
                                    local0\Field10 = 140.0
                                Else
                                    local0\Field10 = max((local0\Field10 - fpsfactor), 0.0)
                                EndIf
                                pointentity(local0\Field0, local0\Field73, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                animatenpc(local0, 64.0, 93.0, (local0\Field22 * 30.0), $01)
                                local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                If (1.0 > entitydistance(local0\Field4, local0\Field73)) Then
                                    If (60.0 >= (Abs deltayaw(local0\Field4, local0\Field73))) Then
                                        local0\Field9 = 3.0
                                    EndIf
                                EndIf
                                local0\Field38 = 0.0
                                local0\Field37 = $00
                                local0\Field39 = $00
                                local0\Field11 = 0.0
                            Else
                                If (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                        animatenpc(local0, 64.0, 93.0, (local0\Field22 * 30.0), $01)
                                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                                        local7 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                        If (0.6 > local7) Then
                                            local19 = $01
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                    If (((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 > $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) <> 0) Then
                                                        local19 = $00
                                                    ElseIf (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                        usedoor(local0\Field36[local0\Field39]\Field1, $00, $01, $00, "", $00)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (((0.2 > local7) And local19) <> 0) Then
                                                local0\Field39 = (local0\Field39 + $01)
                                            ElseIf (((0.5 > local7) And (local19 = $00)) <> 0) Then
                                                local0\Field37 = $00
                                                local0\Field38 = 0.0
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    animatenpc(local0, 323.0, 344.0, 0.2, $01)
                                    local0\Field22 = 0.0
                                    If (350.0 > local0\Field38) Then
                                        local0\Field38 = (local0\Field38 + (rnd(1.0, (Float ((selecteddifficulty\Field3 Shl $01) + $02))) * fpsfactor))
                                    Else
                                        local0\Field37 = findpath(local0, entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00))
                                        local0\Field38 = 0.0
                                    EndIf
                                EndIf
                                If (hidedistance < entitydistance(local0\Field4, local0\Field73)) Then
                                    If ((Float (((selecteddifficulty\Field3 * $0A) + $0F) * $46)) > local0\Field11) Then
                                        local0\Field11 = (local0\Field11 + fpsfactor)
                                    Else
                                        debuglog("SCP-008-1 IDLE")
                                        local0\Field11 = 25200.0
                                        local0\Field9 = 4.0
                                    EndIf
                                EndIf
                            EndIf
                            If (0.005 < local0\Field22) Then
                                If ((((80.0 > local12) And (80.0 <= local0\Field14)) Or ((92.0 < local12) And (65.0 > local0\Field14))) <> 0) Then
                                    playsound2(stepsfx($00, $00, rand($00, $07)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                                EndIf
                            EndIf
                            local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 10.0, 1.0)
                        Case 3.0
                            animatenpc(local0, 126.0, 165.0, 0.4, $00)
                            If (((146.0 <= local0\Field14) And (146.0 > local12)) <> 0) Then
                                If (1.1 > entitydistance(local0\Field4, local0\Field73)) Then
                                    If (((60.0 >= (Abs deltayaw(local0\Field4, local0\Field73))) And (local0\Field74 = networkserver\Field28)) <> 0) Then
                                        playsound_strict(damagesfx(rand($05, $08)))
                                        multiplayer_writesound(damagesfx(rand($05, $08)), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
                                        injuries = (rnd(0.4, 1.0) + injuries)
                                        infect = ((Float ((selecteddifficulty\Field3 Shl $00) + $01)) + infect)
                                        deathmsg = "Subject D-9341. Cause of death: multiple lacerations and severe blunt force trauma caused by [DATA EXPUNGED], who was infected with SCP-008. Said subject was located by Nine-Tailed Fox and terminated."
                                    EndIf
                                EndIf
                            ElseIf (164.0 <= local0\Field14) Then
                                If (1.1 > entitydistance(local0\Field4, local0\Field73)) Then
                                    If (60.0 >= (Abs deltayaw(local0\Field4, local0\Field73))) Then
                                        setnpcframe(local0, 126.0)
                                    Else
                                        local0\Field9 = 2.0
                                    EndIf
                                Else
                                    local0\Field9 = 2.0
                                EndIf
                            EndIf
                        Case 4.0
                            hideentity(local0\Field0)
                            hideentity(local0\Field4)
                            local0\Field7 = 0.0
                            positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                            resetentity(local0\Field4)
                            If (0.0 < local0\Field24) Then
                                local0\Field24 = max((local0\Field24 - ((Float ((selecteddifficulty\Field3 Shl $00) + $01)) * fpsfactor)), 0.0)
                            ElseIf (otherplayerinreachableroom(local0\Field74, $00) <> 0) Then
                                If (rand(($32 - (selecteddifficulty\Field3 * $14)), $01) = $01) Then
                                    showentity(local0\Field4)
                                    showentity(local0\Field0)
                                    For local24 = Each waypoints
                                        If ((((local24\Field1 = Null) And (hidedistance > local24\Field2\Field8)) And (rand($03, $01) = $01)) <> 0) Then
                                            If (entitydistance(local0\Field73, local0\Field4) > entitydistance(local24\Field2\Field2, local0\Field4)) Then
                                                local9 = (Abs (entityx(local0\Field4, $00) - entityx(local24\Field0, $01)))
                                                If (((12.0 > local9) And (4.0 < local9)) <> 0) Then
                                                    local11 = (Abs (entityz(local0\Field4, $00) - entityz(local24\Field0, $01)))
                                                    If (((12.0 > local11) And (4.0 < local11)) <> 0) Then
                                                        If (4.0 < local24\Field2\Field8) Then
                                                            debuglog(("MOVING 008-1 TO " + local24\Field2\Field7\Field11))
                                                            positionentity(local0\Field4, entityx(local24\Field0, $01), (entityy(local24\Field0, $01) + 0.25), entityz(local24\Field0, $01), $00)
                                                            resetentity(local0\Field4)
                                                            local0\Field37 = $00
                                                            local0\Field38 = 0.0
                                                            local0\Field39 = $00
                                                            Exit
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                    local0\Field9 = 2.0
                                    local0\Field11 = 0.0
                                EndIf
                            EndIf
                    End Select
                Else
                    If (local0\Field17 <> $00) Then
                        stopchannel(local0\Field17)
                        local0\Field17 = $00
                        freesound_strict(local0\Field16)
                        local0\Field16 = $00
                    EndIf
                    animatenpc(local0, 344.0, 363.0, 0.5, $00)
                EndIf
                rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
        End Select
        If (local0\Field48 <> 0) Then
            entitytype(local0\Field4, $06, $00)
            entitypickmode(local0\Field4, $00, $01)
        EndIf
        If (networkserver\Field18 = $00) Then
            local0\Field7 = 0.0
        EndIf
        local71 = distance(entityx(local0\Field73, $00), entityz(local0\Field73, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))
        If (((local71 < (hidedistance * 0.7)) Or (local0\Field5 = $14)) <> 0) Then
            If (checkformultiplayerinfacility(local0\Field73) = local0\Field58) Then
                translateentity(local0\Field4, 0.0, local0\Field7, 0.0, $00)
                local72 = $00
                For local5 = $01 To countcollisions(local0\Field4) Step $01
                    If ((entityy(local0\Field4, $00) - 0.01) > collisiony(local0\Field4, local5)) Then
                        local72 = $01
                        Exit
                    EndIf
                Next
                If (local72 = $01) Then
                    local0\Field7 = 0.0
                ElseIf (shouldentitiesfall <> 0) Then
                    local17 = $01
                    If (local0\Field5 = $0E) Then
                        If (room860event <> Null) Then
                            local17 = playerinroom(room860event)
                        EndIf
                    EndIf
                    If (local17 <> 0) Then
                        local0\Field7 = max((local0\Field7 - ((0.005 * fpsfactor) * local0\Field44)), (- local0\Field45))
                    EndIf
                Else
                    local0\Field7 = 0.0
                EndIf
            EndIf
        EndIf
        If (networkserver\Field18 = $00) Then
            If (4.0 < distance3(local0\Field85, local0\Field86, local0\Field87, local0\Field88, local0\Field89, local0\Field90)) Then
                local0\Field88 = local0\Field85
                local0\Field89 = local0\Field86
                local0\Field90 = local0\Field87
            EndIf
            local0\Field88 = curvevalue(local0\Field85, local0\Field88, 5.0)
            local0\Field89 = curvevalue(local0\Field86, local0\Field89, 5.0)
            local0\Field90 = curvevalue(local0\Field87, local0\Field90, 5.0)
            local0\Field93 = curveangle(local0\Field92, local0\Field93, 5.0)
            setanimtime(local0\Field0, local0\Field91, $00)
            positionentity(local0\Field4, local0\Field88, local0\Field89, local0\Field90, $01)
            rotateentity(local0\Field4, entitypitch(local0\Field4, $01), local0\Field93, entityroll(local0\Field4, $01), $01)
            resetentity(local0\Field4)
        EndIf
        If ((((local0\Field5 <> $12) And (local0\Field5 <> $0C)) And (local0\Field5 <> $06)) <> 0) Then
            If (local71 < (hidedistance * 4.0)) Then
                showentity(local0\Field0)
                manipulatenpcbones(local0)
            Else
                hideentity(local0\Field0)
            EndIf
        EndIf
    Next
    If (((0.0 < mtf_camerachecktimer) And (6300.0 > mtf_camerachecktimer)) <> 0) Then
        mtf_camerachecktimer = (mtf_camerachecktimer + fpsfactor)
    ElseIf (6300.0 <= mtf_camerachecktimer) Then
        mtf_camerachecktimer = 0.0
        If (playerdetected = $00) Then
            If (mtf_cameracheckdetected <> 0) Then
                playannouncement((("SFX\Character\MTF\AnnouncCameraFound" + (Str rand($01, $02))) + ".ogg"), $01, $00)
                playerdetected = $01
                mtf_camerachecktimer = 4200.0
            Else
                playannouncement("SFX\Character\MTF\AnnouncCameraNoFound.ogg", $01, $00)
            EndIf
        EndIf
        mtf_cameracheckdetected = $00
        If (0.0 = mtf_camerachecktimer) Then
            playerdetected = $00
        EndIf
    EndIf
    Return $00
End Function
