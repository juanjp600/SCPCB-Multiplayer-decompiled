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
    Local local18%
    Local local19%
    Local local20#
    Local local21.players
    Local local22%
    Local local23.waypoints
    Local local24%
    Local local26%
    Local local27%
    Local local28%
    Local local29%
    Local local30%
    Local local32#
    Local local33%
    Local local35%
    Local local36%
    Local local37#
    Local local38.rooms
    Local local39#
    Local local43#
    Local local44#
    Local local45%
    Local local46.particles
    Local local47%
    Local local48.waypoints
    Local local49.waypoints
    Local local54.forest
    Local local56%
    Local local57%
    Local local59%
    Local local60%
    Local local62.rooms
    Local local65%
    Local local66%
    Local local67%
    Local local71#
    Local local74%
    Local local75%
    Local local76%
    If (server\Field21 <> 0) Then
        For local0 = Each npcs
            removenpc(local0, $00)
        Next
        Return $00
    EndIf
    For local0 = Each npcs
        local0\Field58 = checkfornpcinfacility(local0)
        local0\Field92 = local0\Field74
        local0\Field74 = findnearestid(local0)
        local0\Field73 = player[local0\Field74]\Field62
        Select local0\Field5
            Case $01
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
                            local18 = $00
                            local19 = $01
                            If (15.0 > local6) Then
                                If (10.0 > local6) Then
                                    If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                        local18 = $01
                                        local0\Field33 = entityx(local0\Field73, $01)
                                        local0\Field34 = entityy(local0\Field73, $01)
                                        local0\Field35 = entityz(local0\Field73, $01)
                                    EndIf
                                EndIf
                                local20 = max(min((distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field28, local0\Field30) * 2.5), 1.0), 0.0)
                                local0\Field17 = loopsound2(stonedragsfx, local0\Field17, camera, local0\Field4, 10.0, local0\Field9)
                                local0\Field28 = entityx(local0\Field4, $00)
                                local0\Field30 = entityz(local0\Field4, $00)
                                For local21 = Each players
                                    If (local21\Field30 <> $00) Then
                                        If (((-16.0 > local21\Field17) Or (-6.0 < local21\Field17)) <> 0) Then
                                            If (entityinview(local0\Field0, getcamera(local21\Field30)) <> 0) Then
                                                local19 = $00
                                            EndIf
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            If (notarget <> 0) Then
                                local19 = $01
                            EndIf
                            If (local19 = $00) Then
                                local0\Field27 = local6
                                local0\Field9 = max(0.0, (local0\Field9 - (fpsfactor / 20.0)))
                            ElseIf (50.0 < local6) Then
                                If (rand($46, $01) = $01) Then
                                    If ((((player[local0\Field74]\Field67 <> "exit1") And (player[local0\Field74]\Field67 <> "gatea")) And (player[local0\Field74]\Field67 <> "pocketdimension")) <> 0) Then
                                        For local23 = Each waypoints
                                            If (((local23\Field1 = Null) And (rand($05, $01) = $01)) <> 0) Then
                                                local9 = (Abs (entityx(local0\Field73, $00) - entityx(local23\Field0, $01)))
                                                If (((25.0 > local9) And (15.0 < local9)) <> 0) Then
                                                    local11 = (Abs (entityz(local0\Field73, $00) - entityz(local23\Field0, $01)))
                                                    If (((25.0 > local11) And (15.0 < local11)) <> 0) Then
                                                        debuglog(("MOVING 173 TO " + local23\Field2\Field7\Field10))
                                                        positionentity(local0\Field4, entityx(local23\Field0, $01), (entityy(local23\Field0, $01) + 0.25), entityz(local23\Field0, $01), $00)
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
                                local0\Field9 = curvevalue(local20, local0\Field9, 3.0)
                                If (rand($14, $01) = $01) Then
                                    For local2 = Each doors
                                        If (((((local2\Field4 = $00) And (local2\Field5 = $00)) And (local2\Field17 = "")) And (local2\Field12 = $00)) <> 0) Then
                                            For local5 = $00 To $01 Step $01
                                                If (local2\Field3[local5] <> $00) Then
                                                    If (0.5 > (Abs (entityx(local0\Field4, $00) - entityx(local2\Field3[local5], $00)))) Then
                                                        If (0.5 > (Abs (entityz(local0\Field4, $00) - entityz(local2\Field3[local5], $00)))) Then
                                                            If (((180.0 <= local2\Field7) Or (0.0 >= local2\Field7)) <> 0) Then
                                                                entitypickmode(local2\Field3[local5], $02, $01)
                                                                local24 = createpivot($00)
                                                                positionentity(local24, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.5), entityz(local0\Field4, $00), $00)
                                                                pointentity(local24, local2\Field3[local5], 0.0)
                                                                moveentity(local24, 0.0, 0.0, (local0\Field21 * 0.6))
                                                                If (entitypick(local24, 0.5) = local2\Field3[local5]) Then
                                                                    playsound_strict(loadtempsound("SFX\Door\DoorOpen173.ogg"))
                                                                    usedoor(local2, $00, $01, $00, $00)
                                                                EndIf
                                                                freeentity(local24)
                                                                entitypickmode(local2\Field3[local5], $00, $01)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    Next
                                EndIf
                                If (notarget <> 0) Then
                                    local18 = $00
                                    local0\Field33 = 0.0
                                    local0\Field34 = 0.0
                                    local0\Field35 = 0.0
                                EndIf
                                If (local18 <> 0) Then
                                    If (0.65 > local6) Then
                                        If (((player[local0\Field74]\Field101 = $00) And (player[local0\Field74]\Field59 = $00)) <> 0) Then
                                            Select playerroom\Field7\Field10
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
                                            If (instr(player[local0\Field74]\Field103, "Neck", $01) = $00) Then
                                                createsound((("SFX\SCP\173\NeckSnap" + (Str rand($01, $03))) + ".ogg"), entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
                                            EndIf
                                            If (rand($02, $01) = $01) Then
                                                turnentity(camera, 0.0, (Float rand($50, $64)), 0.0, $00)
                                            Else
                                                turnentity(camera, 0.0, (Float rand($FFFFFF9C, $FFFFFFB0)), 0.0, $00)
                                            EndIf
                                            giveplayerhealth(local0\Field74, -1000.0, "was killed by SCP-173")
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
                            local26 = $00
                            If (local6 > (hidedistance * 0.7)) Then
                                If (entityvisible(local0\Field0, local0\Field73) = $00) Then
                                    local26 = $01
                                EndIf
                            EndIf
                            If (local26 = $00) Then
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
                    local27 = $01
                    If (player[local0\Field74]\Field67 <> "pocketdimension") Then
                        If (pocketdimension106\Field14 > $00) Then
                            If (playerinroom(pocketdimension106) <> 0) Then
                                local27 = $00
                            EndIf
                        EndIf
                    ElseIf (50.0 < entitydistance(local0\Field73, local0\Field4)) Then
                        local27 = $00
                    EndIf
                    If (player[local0\Field74]\Field67 = "dimension1499") Then
                        local27 = $00
                    EndIf
                    If (room860event <> Null) Then
                        If (1.0 = room860event\Field2) Then
                            local27 = $00
                        EndIf
                    EndIf
                    If (0.0 <> gateaevent\Field2) Then
                        local27 = $01
                        If (player[local0\Field74]\Field67 = "dimension1499") Then
                            local0\Field24 = 1.0
                        Else
                            local0\Field24 = 0.0
                        EndIf
                    EndIf
                    If (((local27 = $00) And (0.0 >= local0\Field9)) <> 0) Then
                        local0\Field9 = (Float rand($55F0, $6978))
                        positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                    EndIf
                    If (((0.0 = local0\Field24) And local27) <> 0) Then
                        If (0.0 >= local0\Field9) Then
                            If (((((entityy(local0\Field73, $00) - 20.0) - 0.55) > entityy(local0\Field4, $00)) And (channelplaying(local0\Field91) = $00)) <> 0) Then
                                If (room[player[local0\Field74]\Field32] <> Null) Then
                                    If (room[player[local0\Field74]\Field32]\Field7\Field13 = $00) Then
                                        local3 = createdecal($00, entityx(local0\Field73, $00), 0.01, entityz(local0\Field73, $00), 90.0, (Float rand($168, $01)), 0.0)
                                        local3\Field2 = 0.05
                                        local3\Field1 = 0.001
                                        entityalpha(local3\Field0, 0.8)
                                        updatedecals()
                                    EndIf
                                EndIf
                                local0\Field29 = entityy(local0\Field73, $00)
                                setanimtime(local0\Field0, 110.0, $00)
                                If (player[local0\Field74]\Field67 <> "coffin") Then
                                    positionentity(local0\Field4, entityx(local0\Field73, $00), (entityy(local0\Field73, $00) - 15.0), entityz(local0\Field73, $00), $00)
                                EndIf
                            EndIf
                            If (rand($1F4, $01) = $01) Then
                                playsound2(oldmansfx(rand($00, $02)), camera, local0\Field4, 10.0, 1.0)
                            EndIf
                            local0\Field17 = loopsound2(oldmansfx($04), local0\Field17, camera, local0\Field4, 8.0, 0.8)
                            If (-10.0 < local0\Field9) Then
                                local28 = $42
                                If (259.0 > local0\Field14) Then
                                    positionentity(local0\Field4, entityx(local0\Field4, $00), (local0\Field29 - 0.15), entityz(local0\Field4, $00), $00)
                                    pointentity(local0\Field0, local0\Field73, 0.0)
                                    rotateentity(local0\Field4, 0.0, curvevalue(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 100.0), 0.0, $01)
                                    animatenpc(local0, 110.0, 259.0, 0.15, $00)
                                Else
                                    local0\Field9 = -10.0
                                EndIf
                            Else
                                If (playerroom\Field7\Field10 <> "gatea") Then
                                    local28 = $0A
                                EndIf
                                local29 = $00
                                If (8.0 > local6) Then
                                    local29 = entityvisible(local0\Field4, local0\Field73)
                                EndIf
                                If (notarget <> 0) Then
                                    local29 = $00
                                EndIf
                                If (local29 <> 0) Then
                                    If (player[local0\Field74]\Field67 <> "gatea") Then
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
                                    If ((((((25.0 < local6) Or (player[local0\Field74]\Field67 = "pocketdimension")) Or local29) Or (local0\Field37 <> $01)) And (player[local0\Field74]\Field67 <> "gatea")) <> 0) Then
                                        If (((40.0 < local6) Or (player[local0\Field74]\Field67 = "pocketdimension")) <> 0) Then
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
                                ElseIf (((player[local0\Field74]\Field67 <> "gatea") And (notarget = $00)) <> 0) Then
                                    If (0.5 < local6) Then
                                        local0\Field22 = curvevalue((local0\Field21 * 2.5), local0\Field22, 10.0)
                                    Else
                                        local0\Field22 = 0.0
                                    EndIf
                                    animatenpc(local0, 105.0, 110.0, 0.15, $00)
                                    pointentity(local0\Field0, local0\Field73, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    If (((0.0 <= killtimer) And (0.0 <= falltimer)) <> 0) Then
                                        If (((110.0 = ceil(local0\Field14)) And (godmode = $00)) <> 0) Then
                                            playsound_strict(damagesfx($01))
                                            playsound_strict(horrorsfx($05))
                                            If (instr(player[local0\Field74]\Field103, "Damage", $01) = $00) Then
                                                createsound("SFX\Character\D9341\Damage1.ogg", entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
                                            EndIf
                                            If (player[local0\Field74]\Field67 = "pocketdimension") Then
                                                deathmsg = (((("Subject D-9341. Body partially decomposed by what is assumed to be SCP-106's " + chr($22)) + "corrosion") + chr($22)) + " effect. Body disposed of via incineration.")
                                                giveplayerhealth(local0\Field74, -1000.0, "was killed by SCP-106")
                                            Else
                                                playsound_strict(oldmansfx($03))
                                                falltimer = min(-1.0, falltimer)
                                                positionentity(head, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
                                                resetentity(head)
                                                rotateentity(head, 0.0, (entityyaw(camera, $00) + (Float rand($FFFFFFD3, $2D))), 0.0, $00)
                                                movetopocketdimension(local0\Field74)
                                            EndIf
                                            local0\Field9 = -20000.0
                                            translateentity(local0\Field4, 0.0, -50.0, 0.0, $01)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                            If ((Float rand($FFFFF254, $FFFFF448)) >= local0\Field9) Then
                                If ((entityinview(local0\Field0, camera) And (5.0 < local6)) = $00) Then
                                    local0\Field9 = (Float rand($55F0, $6978))
                                    positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                                EndIf
                            EndIf
                            If (0.0 = local0\Field25) Then
                                If (((((10.0 < local6) And (player[local0\Field74]\Field67 <> "pocketdimension")) And (player[local0\Field74]\Field67 <> "gatea")) And (-5.0 > local0\Field9)) <> 0) Then
                                    If (entityinview(local0\Field0, getcamera(local0\Field74)) = $00) Then
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
                            If (room[player[local0\Field74]\Field32] <> Null) Then
                                If (room[player[local0\Field74]\Field32]\Field7\Field13 = $00) Then
                                    If (player[local0\Field74]\Field67 <> "gatea") Then
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
                        If (((playerroom\Field7\Field10 = "pocketdimension") Or (playerroom\Field7\Field10 = "gatea")) <> 0) Then
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
                            If (notarget = $00) Then
                                For local5 = $01 To server\Field18 Step $01
                                    If (player[local5] <> Null) Then
                                        If (player[local5]\Field59 = $00) Then
                                            local8 = wrapangle(deltayaw(local0\Field4, player[local5]\Field68))
                                            If (((90.0 > local8) Or (270.0 < local8)) <> 0) Then
                                                cameraproject(player[local5]\Field68, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.25), entityz(local0\Field4, $00))
                                                If (((0.0 < projectedx()) And (projectedx() < (Float player[local5]\Field71))) <> 0) Then
                                                    If (((0.0 < projectedy()) And (projectedy() < (Float player[local5]\Field72))) <> 0) Then
                                                        If (entityvisible(player[local5]\Field62, local0\Field4) <> 0) Then
                                                            If ((((-16.0 > player[local5]\Field17) Or (-6.0 < player[local5]\Field17)) And (player[local5]\Field59 = $00)) <> 0) Then
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
                                setstreamvolume_strict(local0\Field20, (min(max((8.0 - local6), 0.6), 1.0) * local32))
                            EndIf
                        EndIf
                        If ((notarget And (local0\Field31 = Null)) <> 0) Then
                            local0\Field9 = 5.0
                        EndIf
                        If ((Float millisecs2()) > local0\Field90) Then
                            local0\Field26 = $00
                            If (local0\Field31 = Null) Then
                                If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                    local0\Field26 = $01
                                EndIf
                            ElseIf (entityvisible(local0\Field31\Field4, local0\Field4) <> 0) Then
                                local0\Field26 = $01
                            EndIf
                            local0\Field90 = (Float (millisecs2() + $BB8))
                        EndIf
                        If (local0\Field26 = $01) Then
                            local0\Field38 = max(210.0, local0\Field38)
                            local0\Field37 = $00
                            If (local0\Field31 <> Null) Then
                                local6 = entitydistance(local0\Field31\Field4, local0\Field4)
                            EndIf
                            If (local0\Field92 <> $00) Then
                                local6 = entitydistance(player[local0\Field92]\Field62, local0\Field4)
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
                                        If (player[local0\Field92]\Field59 <> 0) Then
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
                                    If ((Float millisecs2()) > local0\Field90) Then
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
                                        local0\Field90 = (Float (millisecs2() + $BB8))
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
                            If (notarget = $00) Then
                                For local5 = $01 To server\Field18 Step $01
                                    If (player[local5] <> Null) Then
                                        If (player[local5]\Field59 = $00) Then
                                            local8 = wrapangle(deltayaw(local0\Field4, player[local5]\Field68))
                                            If (((55.0 > local8) Or (305.0 < local8)) <> 0) Then
                                                cameraproject(player[local5]\Field68, entityx(local0\Field4, $00), ((entityy(player[local5]\Field62, $00) + 1.16) - 0.25), entityz(local0\Field4, $00))
                                                If (((0.0 < projectedx()) And (projectedx() < (Float player[local5]\Field71))) <> 0) Then
                                                    If (((0.0 < projectedy()) And (projectedy() < (Float player[local5]\Field72))) <> 0) Then
                                                        If (entityvisible(player[local5]\Field62, local0\Field4) <> 0) Then
                                                            If (((-16.0 > player[local5]\Field17) Or (-6.0 < player[local5]\Field17)) <> 0) Then
                                                                If (channelplaying(local0\Field84) = $00) Then
                                                                    local0\Field84 = playsound_strict(triggered096sfx)
                                                                EndIf
                                                                currcamerazoom = 10.0
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
                End Select
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.03), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
            Case $0A
                local12 = local0\Field14
                local6 = entitydistance(local0\Field73, local0\Field4)
                local0\Field49 = 1.0
                If (0.1 < local0\Field24) Then
                    If (player[local0\Field74]\Field67 <> "room049") Then
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
                            If (room[player[local0\Field74]\Field32] <> Null) Then
                                For local5 = $00 To $03 Step $01
                                    If (room[player[local0\Field74]\Field32]\Field32[local5] <> Null) Then
                                        For local33 = $00 To $03 Step $01
                                            If (room[player[local0\Field74]\Field32]\Field32[local5]\Field32[local33] <> Null) Then
                                                teleportentity(local0\Field4, room[player[local0\Field74]\Field32]\Field32[local5]\Field32[local33]\Field3, 0.5, room[player[local0\Field74]\Field32]\Field32[local5]\Field32[local33]\Field5, local0\Field68, $01, 2.0, $00)
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
                                        local35 = rand($01, $07)
                                        local0\Field19 = loadsound_strict((("SFX\SCP\049\Spotted" + (Str local35)) + ".ogg"))
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
                                        local36 = $00
                                        If (player[local0\Field74]\Field20 > $00) Then
                                            blurtimer = ((fpsfactor * 2.5) + blurtimer)
                                            If ((((250.0 < blurtimer) And (250.0 >= (blurtimer - (fpsfactor * 2.5)))) And (local0\Field12 <> $03)) <> 0) Then
                                                If (local0\Field20 <> $00) Then
                                                    stopchannel(local0\Field20)
                                                EndIf
                                                local0\Field20 = playsound_strict(loadtempsound("SFX\SCP\049\TakeOffHazmat.ogg"))
                                                local0\Field12 = $03
                                            ElseIf (500.0 <= blurtimer) Then
                                                local36 = $01
                                                blurtimer = 0.0
                                            EndIf
                                        ElseIf (readbool(player[local0\Field74]\Field76, $04) <> 0) Then
                                            blurtimer = ((fpsfactor * 2.5) + blurtimer)
                                            If ((((250.0 < blurtimer) And (250.0 >= (blurtimer - (fpsfactor * 2.5)))) And (local0\Field12 <> $03)) <> 0) Then
                                                If (local0\Field20 <> $00) Then
                                                    stopchannel(local0\Field20)
                                                EndIf
                                                local0\Field20 = playsound_strict(loadtempsound("SFX\SCP\049\714Equipped.ogg"))
                                                local0\Field12 = $03
                                            ElseIf (500.0 <= blurtimer) Then
                                                local36 = $01
                                                blurtimer = 0.0
                                            EndIf
                                        EndIf
                                        If (local36 <> 0) Then
                                            If (player[local0\Field74]\Field101 = $00) Then
                                                deathmsg = "An active instance of SCP-049-2 was discovered in [REDACTED]. Terminated by Nine-Tailed Fox."
                                                kill("was killed by SCP-049", $00)
                                                playsound_strict(horrorsfx($0D))
                                                If (local0\Field19 <> $00) Then
                                                    freesound_strict(local0\Field19)
                                                EndIf
                                                local35 = rand($01, $02)
                                                local0\Field19 = loadsound_strict((("SFX\SCP\049\Kidnap" + (Str local35)) + ".ogg"))
                                                local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                                local0\Field9 = 1.0
                                                If (instr(player[local0\Field74]\Field103, "Horror", $01) = $00) Then
                                                    createsound("SFX\Horror\Horror13.ogg", entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
                                                EndIf
                                            EndIf
                                            local36 = $00
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
                                        If (local0\Field39 > $00) Then
                                            If (local0\Field36[(local0\Field39 - $01)] <> Null) Then
                                                If (local0\Field36[(local0\Field39 - $01)]\Field1 <> Null) Then
                                                    If (local0\Field36[(local0\Field39 - $01)]\Field1\Field23 = $00) Then
                                                        If (0.3 < entitydistance(local0\Field36[(local0\Field39 - $01)]\Field0, local0\Field4)) Then
                                                            If (((local0\Field36[(local0\Field39 - $01)]\Field1\Field24 And local0\Field36[(local0\Field39 - $01)]\Field1\Field5) And ((local0\Field36[(local0\Field39 - $01)]\Field1\Field3[$00] <> $00) Or (local0\Field36[(local0\Field39 - $01)]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                                usedoor(local0\Field36[(local0\Field39 - $01)]\Field1, $00, $01, $00, $00)
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
                                            local18 = $01
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                    If ((((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 <> $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) And (local0\Field36[local0\Field39]\Field1\Field5 = $00)) <> 0) Then
                                                        local18 = $00
                                                    ElseIf (((local0\Field36[local0\Field39]\Field1\Field5 = $00) And ((local0\Field36[local0\Field39]\Field1\Field3[$00] <> $00) Or (local0\Field36[local0\Field39]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                        usedoor(local0\Field36[local0\Field39]\Field1, $00, $01, $00, $00)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (((0.2 > local7) And local18) <> 0) Then
                                                local0\Field39 = (local0\Field39 + $01)
                                            ElseIf (((0.5 > local7) And (local18 = $00)) <> 0) Then
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
                                                local35 = rand($01, $06)
                                                local0\Field19 = loadsound_strict((("SFX\SCP\049\Searching" + (Str local35)) + ".ogg"))
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
                                            local37 = entitydistance(room[player[local0\Field74]\Field32]\Field2, local0\Field4)
                                            local38 = room[player[local0\Field74]\Field32]
                                            local39 = 0.0
                                            For local5 = $00 To $03 Step $01
                                                If (room[player[local0\Field74]\Field32]\Field32[local5] <> Null) Then
                                                    local39 = entitydistance(room[player[local0\Field74]\Field32]\Field32[local5]\Field2, local0\Field4)
                                                    If (local37 > local39) Then
                                                        local37 = local39
                                                        local38 = room[player[local0\Field74]\Field32]\Field32[local5]
                                                    EndIf
                                                EndIf
                                            Next
                                            local0\Field37 = findpath(local0, entityx(local38\Field2, $00), 0.5, entityz(local38\Field2, $00))
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
                                                local37 = 100.0
                                                local38 = room[player[local0\Field74]\Field32]
                                                local39 = 0.0
                                                For local5 = $00 To $03 Step $01
                                                    If (room[player[local0\Field74]\Field32]\Field32[local5] <> Null) Then
                                                        local39 = entitydistance(room[player[local0\Field74]\Field32]\Field32[local5]\Field2, local0\Field4)
                                                        If (local37 > local39) Then
                                                            local37 = local39
                                                            For local33 = $00 To $03 Step $01
                                                                If (room[player[local0\Field74]\Field32]\Field32[local5]\Field32[local33] <> Null) Then
                                                                    If (room[player[local0\Field74]\Field32]\Field32[local5]\Field32[local33] <> room[player[local0\Field74]\Field32]) Then
                                                                        local38 = room[player[local0\Field74]\Field32]\Field32[local5]\Field32[local33]
                                                                        Exit
                                                                    EndIf
                                                                EndIf
                                                            Next
                                                        EndIf
                                                    EndIf
                                                Next
                                                local0\Field37 = findpath(local0, entityx(local38\Field2, $00), 0.5, entityz(local38\Field2, $00))
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
                                                                usedoor(local0\Field36[(local0\Field39 - $01)]\Field1, $00, $01, $00, $00)
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
                                                    usedoor(local0\Field36[local0\Field39]\Field1, $00, $01, $00, $00)
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
                            If (playerroom\Field7\Field10 = "room2sl") Then
                                local28 = $14
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
                                                giveplayerhealth(local0\Field74, -18.0, "was killed by SCP-049-2")
                                                If (instr(player[local0\Field74]\Field103, "Damage", $01) = $00) Then
                                                    createsound((("SFX\Character\D9341\Damage" + (Str rand($06, $08))) + ".ogg"), entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
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
                                                giveplayerhealth(local0\Field74, -18.0, "was killed by SCP-049-2")
                                                If (instr(player[local0\Field74]\Field103, "Damage", $01) = $00) Then
                                                    createsound((("SFX\Character\D9341\Damage" + (Str rand($06, $08))) + ".ogg"), entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
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
                            local43 = (((Float selecteddifficulty\Field3) * 0.5) + 0.4)
                            local44 = 11.0
                            If (playerroom\Field7\Field10 = "exit1") Then
                                local44 = 21.0
                                local43 = 0.0
                                If (rand($01, ($08 - (selecteddifficulty\Field3 Shl $02))) < $02) Then
                                    local43 = 0.03
                                EndIf
                                local43 = ((0.5 - (currspeed * 20.0)) + local43)
                            EndIf
                            If (local44 > local6) Then
                                local24 = createpivot($00)
                                positionentity(local24, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                pointentity(local24, local0\Field73, 0.0)
                                rotateentity(local24, min(entitypitch(local24, $00), 20.0), entityyaw(local24, $00), 0.0, $00)
                                rotateentity(local0\Field4, curveangle(entitypitch(local24, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local24, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                positionentity(local24, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                                pointentity(local24, local0\Field73, 0.0)
                                rotateentity(local24, min(entitypitch(local24, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                                If (0.0 = local0\Field25) Then
                                    debuglog("entitypick")
                                    entitypick(local24, local6)
                                    If (((pickedentity() = local0\Field73) Or (1.0 = local0\Field11)) <> 0) Then
                                        local45 = $00
                                        If (playerroom\Field7\Field10 = "start") Then
                                            deathmsg = "Subject D-9341. Cause of death: Gunshot wound to the head. The surveillance tapes confirm that the subject was terminated by Agent Ulgrin shortly after the site lockdown was initiated."
                                            local45 = $01
                                        ElseIf (playerroom\Field7\Field10 = "exit1") Then
                                            deathmsg = ((chr($22) + "Agent G. to control. Eliminated a Class D escapee in Gate B's courtyard.") + chr($22))
                                        Else
                                            deathmsg = ""
                                        EndIf
                                        playsound2(gunshotsfx, camera, local0\Field4, 35.0, 1.0)
                                        rotateentity(local24, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                                        positionentity(local24, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                        moveentity(local24, 0.0632, 0.84925, 0.5451)
                                        pointentity(local24, local0\Field73, 0.0)
                                        shoot(local0, entityx(local24, $00), entityy(local24, $00), entityz(local24, $00), local43, $00, local45)
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
                                freeentity(local24)
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
                            local46 = createparticle(entityx(local0\Field0, $01), entityy(local0\Field0, $01), entityz(local0\Field0, $01), $01, 0.2, 0.0, $05)
                            positionentity(local46\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            rotateentity(local46\Field1, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                            moveentity(local46\Field1, 0.0632, 0.84925, 0.5451)
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
                            local47 = $00
                            If (11.0 > local6) Then
                                If (entityvisible(local0\Field4, local0\Field73) <> 0) Then
                                    local47 = $01
                                EndIf
                            EndIf
                            If (local47 <> 0) Then
                                local24 = createpivot($00)
                                positionentity(local24, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                pointentity(local24, local0\Field73, 0.0)
                                rotateentity(local24, min(entitypitch(local24, $00), 20.0), entityyaw(local24, $00), 0.0, $00)
                                rotateentity(local0\Field4, curveangle(entitypitch(local24, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local24, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                positionentity(local24, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                                pointentity(local24, local0\Field73, 0.0)
                                rotateentity(local24, min(entitypitch(local24, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                                If (0.0 = local0\Field25) Then
                                    debuglog("entitypick")
                                    entitypick(local24, local6)
                                    If (((pickedentity() = local0\Field73) Or (1.0 = local0\Field11)) <> 0) Then
                                        local45 = $00
                                        deathmsg = ""
                                        playsound2(gunshotsfx, camera, local0\Field4, 35.0, 1.0)
                                        rotateentity(local24, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                                        positionentity(local24, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                        moveentity(local24, 0.0632, 0.84925, 0.5451)
                                        pointentity(local24, local0\Field73, 0.0)
                                        shoot(local0, entityx(local24, $00), entityy(local24, $00), entityz(local24, $00), 1.0, $00, local45)
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
                                freeentity(local24)
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
                                    local48 = Null
                                    For local49 = Each waypoints
                                        If (2.0 > entitydistance(local49\Field0, local0\Field73)) Then
                                            local48 = local49
                                            Exit
                                        EndIf
                                    Next
                                    If (local48 <> Null) Then
                                        local0\Field38 = 1.0
                                        If (entityvisible(local48\Field0, local0\Field4) <> 0) Then
                                            If (0.0 < (Abs deltayaw(local0\Field4, local48\Field0))) Then
                                                pointentity(local0\Field0, local48\Field0, 0.0)
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
                        local24 = createpivot($00)
                        positionentity(local24, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                        If (1.0 = local0\Field10) Then
                            pointentity(local24, local0\Field73, 0.0)
                        Else
                            rotateentity(local24, 0.0, local0\Field15, 0.0, $00)
                        EndIf
                        rotateentity(local24, min(entitypitch(local24, $00), 20.0), entityyaw(local24, $00), 0.0, $00)
                        rotateentity(local0\Field4, curveangle(entitypitch(local24, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local24, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                        positionentity(local24, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                        If (1.0 = local0\Field10) Then
                            pointentity(local24, local0\Field73, 0.0)
                            local0\Field51 = $01
                            local0\Field53 = "Chest"
                            local0\Field52 = $00
                        Else
                            rotateentity(local24, 0.0, local0\Field15, 0.0, $00)
                        EndIf
                        rotateentity(local24, min(entitypitch(local24, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                        freeentity(local24)
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
                If (((286.5 < animtime(local0\Field0)) And (288.5 > animtime(local0\Field0))) <> 0) Then
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
                If (player[local0\Field74]\Field67 <> "pocketdimension") Then
                    If ((Int local0\Field24) <> 0) Then
                        hideentity(local0\Field0)
                        hideentity(local0\Field1)
                        If (rand($C8, $01) = $01) Then
                            For local23 = Each waypoints
                                If (local23\Field2 <> playerroom) Then
                                    local9 = (Abs (entityx(local0\Field73, $00) - entityx(local23\Field0, $01)))
                                    If (((3.0 < local9) And (9.0 > local9)) <> 0) Then
                                        local11 = (Abs (entityz(local0\Field73, $00) - entityz(local23\Field0, $01)))
                                        If (((3.0 < local11) And (9.0 > local11)) <> 0) Then
                                            positionentity(local0\Field4, entityx(local23\Field0, $01), entityy(local23\Field0, $01), entityz(local23\Field0, $01), $00)
                                            positionentity(local0\Field0, entityx(local23\Field0, $01), entityy(local23\Field0, $01), entityz(local23\Field0, $01), $00)
                                            resetentity(local0\Field4)
                                            showentity(local0\Field0)
                                            showentity(local0\Field1)
                                            local0\Field26 = $00
                                            local0\Field36[$00] = local23
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
                        local18 = (Int rnd(-1.0, 1.0))
                        positionentity(local0\Field1, (entityx(local0\Field4, $00) + (local0\Field28 * (Float local18))), ((entityy(local0\Field4, $00) - 0.2) + (sin((Float (((millisecs2() Sar $03) - $2D) Mod $168))) * 0.05)), (entityz(local0\Field4, $00) + (local0\Field30 * (Float local18))), $00)
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
                            For local23 = Each waypoints
                                local9 = (Abs (entityx(local0\Field4, $01) - entityx(local23\Field0, $01)))
                                If (((8.0 > local9) And (1.0 < local9)) <> 0) Then
                                    local11 = (Abs (entityz(local0\Field4, $01) - entityz(local23\Field0, $01)))
                                    If (((8.0 > local11) And (1.0 < local11)) <> 0) Then
                                        If (local6 < entitydistance(local0\Field73, local23\Field0)) Then
                                            local0\Field36[$00] = local23
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
                            If (rand($C8, $01) = $01) Then
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
                local14 = player[local0\Field74]\Field67
                If (((local14 <> "pocketdimension") And (local14 <> "dimension1499")) <> 0) Then
                    If ((Int local0\Field24) <> 0) Then
                        hideentity(local0\Field0)
                        If (((rand($32, $01) = $01) And ((-5.0 > player[local0\Field74]\Field17) And (-15.0 < player[local0\Field74]\Field17))) <> 0) Then
                            showentity(local0\Field0)
                            local8 = (entityyaw(local0\Field73, $00) + rnd(-90.0, 90.0))
                            local6 = rnd(1.5, 2.0)
                            positionentity(local0\Field4, (entityx(local0\Field73, $00) + (sin(local8) * local6)), (entityy(local0\Field73, $00) + 0.2), (entityz(local0\Field73, $00) + (cos(local8) * local6)), $00)
                            local0\Field24 = 0.0
                            local0\Field9 = (Float rand($14, $3C))
                            If (rand($12C, $01) = $01) Then
                                playsound2(rustlesfx(rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.0, 0.2))
                            EndIf
                        EndIf
                    Else
                        positionentity(local0\Field0, (entityx(local0\Field4, $00) + rnd(-0.005, 0.005)), ((entityy(local0\Field4, $00) + 0.3) + (0.1 * sin((Float (millisecs2() Sar $01))))), (entityz(local0\Field4, $00) + rnd(-0.005, 0.005)), $00)
                        rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), (Float ((millisecs2() / $05) Mod $168)), $00)
                        animatenpc(local0, 32.0, 113.0, 0.4, $01)
                        If ((entityinview(local0\Field0, getcamera(local0\Field74)) And ((-16.0 > player[local0\Field74]\Field17) Or (-6.0 < player[local0\Field74]\Field17))) <> 0) Then
                            giveachievement($0B, $01)
                            If (rand($1E, $01) = $01) Then
                                If (channelplaying(local0\Field17) = $00) Then
                                    If (entityvisible(camera, local0\Field0) <> 0) Then
                                        local0\Field17 = playsound2(rustlesfx(rand($00, $02)), camera, local0\Field0, 8.0, 0.3)
                                    EndIf
                                EndIf
                            EndIf
                            local18 = createpivot($00)
                            positionentity(local18, entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), $00)
                            pointentity(local18, local0\Field4, 0.0)
                            local8 = wrapangle((entityyaw(local0\Field73, $00) - entityyaw(local18, $00)))
                            If (180.0 > local8) Then
                                rotateentity(local0\Field4, 0.0, (entityyaw(local0\Field73, $00) - 80.0), 0.0, $00)
                            Else
                                rotateentity(local0\Field4, 0.0, (entityyaw(local0\Field73, $00) + 80.0), 0.0, $00)
                            EndIf
                            freeentity(local18)
                            moveentity(local0\Field4, 0.0, 0.0, (0.03 * fpsfactor))
                            local0\Field9 = (local0\Field9 - fpsfactor)
                        EndIf
                        local0\Field9 = (local0\Field9 - (fpsfactor / 80.0))
                        If (0.0 >= local0\Field9) Then
                            local0\Field24 = 1.0
                            positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                            resetentity(local0\Field4)
                        EndIf
                    EndIf
                EndIf
                local0\Field7 = 0.0
                resetentity(local0\Field4)
            Case $07
                local6 = entitydistance(collider, local0\Field4)
                If (60.0 > local6) Then
                    If (playerroom\Field7\Field10 = "exit1") Then
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
                                                local24 = createpivot($00)
                                                positionentity(local24, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                                rotateentity(local24, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $00)
                                                moveentity(local24, 0.0, (1.0 / 4.831696), 1.675444)
                                                pointentity(local24, local15, 0.0)
                                                If (10.0 > wrapangle((entityyaw(local24, $00) - entityyaw(local0\Field4, $00)))) Then
                                                    playsound2(gunshot2sfx, camera, local0\Field4, 20.0, 1.0)
                                                    If (playerroom\Field7\Field10 = "exit1") Then
                                                        deathmsg = ((chr($22) + "CH-2 to control. Shot down a runaway Class D at Gate B.") + chr($22))
                                                    Else
                                                        deathmsg = ((chr($22) + "CH-2 to control. Shot down a runaway Class D at Gate A.") + chr($22))
                                                    EndIf
                                                    shoot(local0, entityx(local24, $00), entityy(local24, $00), entityz(local24, $00), (((10.0 / local6) * (1.0 / local6)) * (Float (2.0 = local0\Field9))), (2.0 = local0\Field9), $00)
                                                    local0\Field25 = 5.0
                                                EndIf
                                                freeentity(local24)
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
                                    If (1.8 > local6) Then
                                        If (20.0 > (Abs deltayaw(local0\Field4, local0\Field73))) Then
                                            If (player[local0\Field74]\Field20 <> 0) Then
                                                injuries = (rnd(0.5, 0.0) + injuries)
                                                playsound_strict(loadtempsound("SFX\General\BodyFall.ogg"))
                                                If (instr(player[local0\Field74]\Field103, "BodyFall", $01) = $00) Then
                                                    createsound("SFX\General\BodyFall.ogg", entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
                                                EndIf
                                            Else
                                                blurtimer = 100.0
                                                injuries = (rnd(1.0, 1.5) + injuries)
                                                playsound_strict(damagesfx(rand($02, $03)))
                                                If (instr(player[local0\Field74]\Field103, "Damage", $01) = $00) Then
                                                    createsound((("SFX\Character\D9341\Damage" + (Str rand($03, $04))) + ".ogg"), entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
                                                EndIf
                                                If (3.0 < injuries) Then
                                                    If (playerroom\Field7\Field10 = "room2offices") Then
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
                If (player[local0\Field74]\Field67 = "room860") Then
                    local54 = room[player[local0\Field74]\Field32]\Field11
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
                                tformpoint(entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), $00, local54\Field4)
                                local9 = floor(((tformedx() + 6.0) / 12.0))
                                local11 = floor(((tformedz() + 6.0) / 12.0))
                                For local56 = (Int max((local9 - 1.0), 1.0)) To (Int min((local9 + 1.0), 10.0)) Step $02
                                    For local57 = (Int max((local11 - 1.0), 1.0)) To (Int min((local11 + 1.0), 10.0)) Step $02
                                        If (local54\Field2[((local57 * $0A) + local56)] = $00) Then
                                            tformpoint(((((Float local56) + local9) / 2.0) * 12.0), 0.0, ((((Float local57) + local11) / 2.0) * 12.0), local54\Field4, $00)
                                            If (entityinview(local0\Field4, camera) <> 0) Then
                                                positionentity(local0\Field4, 0.0, -110.0, 0.0, $00)
                                                debuglog("spawned monster in view -> hide")
                                            Else
                                                debuglog("spawned monster successfully")
                                                positionentity(local0\Field4, tformedx(), (entityy(local54\Field4, $01) + 2.3), tformedz(), $00)
                                                local56 = $0A
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
                                positionentity(local0\Field4, entityx(local0\Field4, $00), (entityy(local54\Field4, $01) + 2.3), entityz(local0\Field4, $00), $00)
                                If (forestnpc <> $00) Then
                                    If (0.0 = forestnpcdata[$02]) Then
                                        local59 = $00
                                        local60 = $00
                                        If (rand($01, ($35C - local59)) = $01) Then
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
                                tformpoint(entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), $00, local54\Field4)
                                local9 = floor(((tformedx() + 6.0) / 12.0))
                                local11 = floor(((tformedz() + 6.0) / 12.0))
                                For local56 = (Int max((local9 - 1.0), 1.0)) To (Int min((local9 + 1.0), 10.0)) Step $01
                                    For local57 = (Int max((local11 - 1.0), 1.0)) To (Int min((local11 + 1.0), 10.0)) Step $01
                                        If ((((local54\Field2[((local57 * $0A) + local56)] > $00) And ((local9 <> (Float local56)) Or (local11 <> (Float local57)))) And ((local9 = (Float local56)) Or (local11 = (Float local57)))) <> 0) Then
                                            tformpoint(((Float local56) * 12.0), 0.0, ((Float local57) * 12.0), local54\Field4, $00)
                                            positionentity(local0\Field4, tformedx(), (entityy(local54\Field4, $01) + 1.0), tformedz(), $00)
                                            debuglog((((Str tformedx()) + ", ") + (Str tformedz())))
                                            If (entityinview(local0\Field4, camera) <> 0) Then
                                                blinktimer = -10.0
                                            Else
                                                local56 = $0A
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                local8 = curveangle((Float find860angle(local0, local54)), (entityyaw(local0\Field4, $00) + 90.0), 80.0)
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
                                        local18 = $01
                                        If (local0\Field17 <> $00) Then
                                            If (channelplaying(local0\Field17) <> 0) Then
                                                local18 = $00
                                            EndIf
                                        EndIf
                                        If (local18 <> 0) Then
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
                            local8 = curveangle((Float find860angle(local0, local54)), (entityyaw(local0\Field4, $00) + 90.0), 40.0)
                            rotateentity(local0\Field4, 0.0, (local8 - 90.0), 0.0, $01)
                            If (local0\Field16 = $00) Then
                                local0\Field16 = loadsound_strict("SFX\General\Slash1.ogg")
                            EndIf
                            If (local0\Field19 = $00) Then
                                local0\Field19 = loadsound_strict("SFX\General\Slash2.ogg")
                            EndIf
                            If ((((1.1 > local6) Or ((451.0 < local0\Field14) And (493.0 > local0\Field14))) Or (0.0 > killtimer)) = 0) Then
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
                            local24 = createpivot($00)
                            positionentity(local24, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                            pointentity(local24, local0\Field1, 0.0)
                            moveentity(local24, 0.0, 0.0, 8.0)
                            positionentity(local0\Field1, entityx(local24, $00), entityy(local24, $00), entityz(local24, $00), $00)
                            freeentity(local24)
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
                                If (local4\Field7\Field10 = "room3storage") Then
                                    local62 = local4
                                    Exit
                                EndIf
                            Next
                            local0\Field10 = max(local0\Field10, (Float (local0\Field12 - $03)))
                            local6 = entitydistance(local0\Field4, local62\Field25[(Int local0\Field10)])
                            local0\Field22 = curvevalue(((local0\Field21 * 0.3) * min(local6, 1.0)), local0\Field22, 10.0)
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * fpsfactor))
                            local12 = local0\Field14
                            animatenpc(local0, 644.0, 683.0, (local0\Field22 * 28.0), $01)
                            If ((((664.0 > local12) And (664.0 <= local0\Field14)) Or ((673.0 < local12) And (654.0 > local0\Field14))) <> 0) Then
                                playsound2(stepsfx($04, $00, rand($00, $03)), camera, local0\Field4, 12.0, 1.0)
                                If (rand($0A, $01) = $01) Then
                                    local18 = $00
                                    If (local0\Field17 = $00) Then
                                        local18 = $01
                                    ElseIf (channelplaying(local0\Field17) = $00) Then
                                        local18 = $01
                                    EndIf
                                    If (local18 <> 0) Then
                                        If (local0\Field16 <> $00) Then
                                            freesound_strict(local0\Field16)
                                            local0\Field16 = $00
                                        EndIf
                                        local0\Field16 = loadsound_strict((((("SFX\SCP\939\" + (Str (local0\Field6 Mod $03))) + "Lure") + (Str rand($01, $0A))) + ".ogg"))
                                        local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 10.0, 1.0)
                                    EndIf
                                EndIf
                            EndIf
                            pointentity(local0\Field0, local62\Field25[(Int local0\Field10)], 0.0)
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
                                    local18 = $00
                                    If (((24.0 > local12) And (24.0 <= local0\Field14)) <> 0) Then
                                        local18 = $01
                                    ElseIf (((57.0 > local12) And (57.0 <= local0\Field14)) <> 0) Then
                                        local18 = $01
                                    EndIf
                                    If (local18 <> 0) Then
                                        If (1.5 > distance(entityx(local0\Field73, $00), entityz(local0\Field73, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))) Then
                                            giveplayerhealth(local0\Field74, -50.0, "was killed by SCP-939")
                                            If (instr(player[local0\Field74]\Field103, "Slash", $01) = $00) Then
                                                createsound("SFX\General\Slash1.ogg", entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
                                            EndIf
                                        Else
                                            local0\Field14 = 449.0
                                        EndIf
                                    EndIf
                                    If (((4.0 < injuries) And $00) <> 0) Then
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
                        If (((local6 < (player[local0\Field74]\Field27 * 1.2)) Or (1.5 > local6)) <> 0) Then
                            If (0.0 = local0\Field11) Then
                                If (local0\Field16 <> $00) Then
                                    freesound_strict(local0\Field16)
                                    local0\Field16 = $00
                                EndIf
                                local0\Field16 = loadsound_strict((((("SFX\SCP\939\" + (Str (local0\Field6 Mod $03))) + "Attack") + (Str rand($01, $03))) + ".ogg"))
                                local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 10.0, 1.0)
                                local0\Field11 = 1.0
                            EndIf
                            local0\Field9 = 3.0
                        ElseIf (local6 < (player[local0\Field74]\Field27 * 1.6)) Then
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
                                For local23 = Each waypoints
                                    If (local23\Field1 = Null) Then
                                        If (4.0 > (Abs (entityx(local23\Field0, $01) - entityx(local0\Field4, $00)))) Then
                                            If (4.0 > (Abs (entityz(local23\Field0, $01) - entityz(local0\Field4, $00)))) Then
                                                positionentity(local0\Field4, entityx(local23\Field0, $01), (entityy(local23\Field0, $01) + 0.3), entityz(local23\Field0, $01), $00)
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
                                                        usedoor(local2, $00, $01, $00, $00)
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    Case $04
                                        If (((playerroom\Field7\Field13 = $00) And $00) <> 0) Then
                                            camerashake = 5.0
                                            local3 = createdecal($01, entityx(local0\Field4, $00), 0.01, entityz(local0\Field4, $00), 90.0, (Float rand($168, $01)), 0.0)
                                            local3\Field2 = 0.3
                                            updatedecals()
                                            playsound_strict(loadtempsound("SFX\General\BodyFall.ogg"))
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
                        local18 = $00
                        If (0.0 < local0\Field9) Then
                            local18 = $01
                        EndIf
                        local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, camera, 10.0, (Float local18))
                    EndIf
                    local18 = (Int rnd(-1.0, 1.0))
                    positionentity(local0\Field0, entityx(local0\Field4, $01), (entityy(local0\Field4, $01) - 0.2), entityz(local0\Field4, $01), $00)
                    rotateentity(local0\Field0, -90.0, entityyaw(local0\Field4, $00), 0.0, $00)
                    If (wearingnightvision = $00) Then
                        hideentity(local0\Field0)
                        If ((((1.0 > local6) And (0.0 >= local0\Field25)) And (local65 <= $00)) <> 0) Then
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
                            If (((900.0 > local0\Field11) And $00) <> 0) Then
                                blurtimer = (((sin((Float (millisecs2() / $32))) + 1.0) * 200.0) / local6)
                                If (wearingnightvision > $00) Then
                                    giveachievement($16, $01)
                                EndIf
                                If (((((wearing714 = $00) And (wearinggasmask < $03)) And (wearinghazmat < $03)) And (16.0 > local6)) <> 0) Then
                                    blinkeffect = max(blinkeffect, 1.5)
                                    blinkeffecttimer = 1000.0
                                    staminaeffect = 2.0
                                    staminaeffecttimer = 1000.0
                                    If (((local65 <= $00) And (1.5 > staminaeffect)) <> 0) Then
                                        Select rand($04, $01)
                                            Case $01
                                                local67 = $00
                                            Case $02
                                                local67 = (Int ((chr($22) + "Could really go for a nap now...") + chr($22)))
                                            Case $03
                                                local67 = (Int ((chr($22) + "If I wasn't in this situation I would take a nap somewhere.") + chr($22)))
                                            Case $04
                                                local67 = $00
                                        End Select
                                        local65 = $1EA
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
                                                local18 = $01
                                                If (0.8 > local7) Then
                                                    If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                        If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                            If ((((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 <> $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) And (local0\Field36[local0\Field39]\Field1\Field5 = $00)) <> 0) Then
                                                                local18 = $00
                                                            ElseIf (((local0\Field36[local0\Field39]\Field1\Field5 = $00) And ((local0\Field36[local0\Field39]\Field1\Field3[$00] <> $00) Or (local0\Field36[local0\Field39]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                                usedoor(local0\Field36[local0\Field39]\Field1, $00, $01, $00, $00)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                    If (0.3 > local7) Then
                                                        local0\Field39 = (local0\Field39 + $01)
                                                    EndIf
                                                EndIf
                                                If (local18 = $00) Then
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
                                    giveplayerhealth(local0\Field74, -15.0, "was killed by SCP-966")
                                    If (instr(player[local0\Field74]\Field103, "Slash", $01) = $00) Then
                                        createsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"), entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
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
            Case $13
                local71 = local0\Field9
                If (1.0 = local71) Then
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
                                            local18 = rand($00, $02)
                                            If (local18 = $00) Then
                                                setnpcframe(local0, 296.0)
                                            ElseIf (local18 = $01) Then
                                                setnpcframe(local0, 856.0)
                                            Else
                                                setnpcframe(local0, 905.0)
                                            EndIf
                                            local18 = rand($00, $02)
                                            If (local18 = $00) Then
                                                setnpcframe(local0\Field31, 296.0)
                                            ElseIf (local18 = $01) Then
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
                                        local18 = rand($00, $01)
                                        If (local18 = $00) Then
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
                                    local18 = rand($00, $02)
                                    If (local18 = $00) Then
                                        setnpcframe(local0, 296.0)
                                    ElseIf (local18 = $01) Then
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
                            If (((playerroom\Field7\Field10 = "dimension1499") And (local0\Field12 = $00)) <> 0) Then
                                local28 = $13
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
                                        giveplayerhealth(local0\Field74, -20.0, "was killed by SCP-1499")
                                        If (instr(player[local0\Field74]\Field103, "Slash", $01) = $00) Then
                                            createsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"), entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
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
                                        giveplayerhealth(local0\Field74, -20.0, "was killed by SCP-1499")
                                        If (instr(player[local0\Field74]\Field103, "Slash", $01) = $00) Then
                                            createsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"), entityx(local0\Field73, $00), entityy(local0\Field73, $00), entityz(local0\Field73, $00), 10.0, 1.0)
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
                                            local18 = $01
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                    If (((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 > $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) <> 0) Then
                                                        local18 = $00
                                                    ElseIf (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                        usedoor(local0\Field36[local0\Field39]\Field1, $00, $01, $00, $00)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (((0.2 > local7) And local18) <> 0) Then
                                                local0\Field39 = (local0\Field39 + $01)
                                            ElseIf (((0.5 > local7) And (local18 = $00)) <> 0) Then
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
                                    If (((60.0 >= (Abs deltayaw(local0\Field4, local0\Field73))) And $00) <> 0) Then
                                        playsound_strict(damagesfx(rand($05, $08)))
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
                                    For local23 = Each waypoints
                                        If ((((local23\Field1 = Null) And (hidedistance > local23\Field2\Field9)) And (rand($03, $01) = $01)) <> 0) Then
                                            If (entitydistance(local0\Field73, local0\Field4) > entitydistance(local23\Field2\Field2, local0\Field4)) Then
                                                local9 = (Abs (entityx(local0\Field4, $00) - entityx(local23\Field0, $01)))
                                                If (((12.0 > local9) And (4.0 < local9)) <> 0) Then
                                                    local11 = (Abs (entityz(local0\Field4, $00) - entityz(local23\Field0, $01)))
                                                    If (((12.0 > local11) And (4.0 < local11)) <> 0) Then
                                                        If (4.0 < local23\Field2\Field9) Then
                                                            debuglog(("MOVING 008-1 TO " + local23\Field2\Field7\Field10))
                                                            positionentity(local0\Field4, entityx(local23\Field0, $01), (entityy(local23\Field0, $01) + 0.25), entityz(local23\Field0, $01), $00)
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
        If (linepick(entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), 0.0, -10.0, 0.0, 0.0) <> $00) Then
            If (checkformultiplayerinfacility(local0\Field73) = local0\Field58) Then
                translateentity(local0\Field4, 0.0, local0\Field7, 0.0, $00)
                local74 = $00
                For local5 = $01 To countcollisions(local0\Field4) Step $01
                    If ((entityy(local0\Field4, $00) - 0.01) > collisiony(local0\Field4, local5)) Then
                        local74 = $01
                        Exit
                    EndIf
                Next
                If (local74 = $01) Then
                    local0\Field7 = 0.0
                ElseIf (shouldentitiesfall <> 0) Then
                    local75 = $01
                    If (local0\Field5 = $0E) Then
                        If (room860event <> Null) Then
                            local75 = playerinroom(room860event)
                        EndIf
                    EndIf
                    If (local75 <> 0) Then
                        local0\Field7 = max((local0\Field7 - ((0.005 * fpsfactor) * local0\Field44)), (- local0\Field45))
                    EndIf
                Else
                    local0\Field7 = 0.0
                EndIf
            EndIf
        EndIf
        If (local0\Field5 = $0B) Then
            debuglog((Str entityy(local0\Field4, $00)))
        EndIf
    Next
    If (((0.0 < mtf_camerachecktimer) And (6300.0 > mtf_camerachecktimer)) <> 0) Then
        mtf_camerachecktimer = (mtf_camerachecktimer + fpsfactor)
    ElseIf (6300.0 <= mtf_camerachecktimer) Then
        mtf_camerachecktimer = 0.0
        If (local76 = $00) Then
            If (mtf_cameracheckdetected <> 0) Then
                playannouncement((("SFX\Character\MTF\AnnouncCameraFound" + (Str rand($01, $02))) + ".ogg"), $01)
                local76 = $01
                mtf_camerachecktimer = 4200.0
            Else
                playannouncement("SFX\Character\MTF\AnnouncCameraNoFound.ogg", $01)
            EndIf
        EndIf
        mtf_cameracheckdetected = $00
        If (0.0 = mtf_camerachecktimer) Then
            local76 = $00
        EndIf
    EndIf
    Return $00
End Function
