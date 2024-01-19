Function updatemtfunit%(arg0.npcs)
    Local local0#
    Local local1#
    Local local2#
    Local local3.rooms
    Local local4#
    Local local5#
    Local local6.npcs
    Local local7.particles
    Local local8%
    Local local9#
    Local local10#
    Local local11#
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18#
    Local local19%
    Local local20#
    Local local21%
    Local local22.waypoints
    Local local23#
    Local local24#
    If (arg0\Field48 <> 0) Then
        arg0\Field49 = -1.0
        setnpcframe(arg0, 532.0)
        If (channelplaying(arg0\Field20) <> 0) Then
            stopchannel(arg0\Field20)
        EndIf
        Return $00
    EndIf
    arg0\Field45 = 0.03
    arg0\Field49 = (arg0\Field49 - fpsfactor)
    If (-5.0 >= arg0\Field49) Then
        If (2.0 = arg0\Field9) Then
            If (othernpcseesmenpc(curr173, arg0) <> 0) Then
                playmtfsound(loadtempsound("SFX\Character\MTF\173\BLINKING.ogg"), arg0)
            EndIf
        EndIf
        arg0\Field49 = (rnd(10.0, 15.0) * 70.0)
    EndIf
    arg0\Field25 = (arg0\Field25 - fpsfactor)
    local11 = arg0\Field14
    arg0\Field53 = ""
    arg0\Field51 = $00
    arg0\Field52 = $00
    arg0\Field57 = "MTF"
    If ((Int arg0\Field9) <> $01) Then
        arg0\Field12 = $00
    EndIf
    arg0\Field20 = loopsound2(mtfsfx($06), arg0\Field20, camera, arg0\Field4, 10.0, 1.0)
    If (0.0 < arg0\Field24) Then
        finishwalking(arg0, 488.0, 522.0, 0.39)
        arg0\Field24 = (arg0\Field24 - fpsfactor)
        If (0.0 >= arg0\Field24) Then
            arg0\Field24 = 0.0
        EndIf
    Else
        Select (Int arg0\Field9)
            Case $00
                arg0\Field21 = 0.015
                If (0.0 >= arg0\Field38) Then
                    If (arg0\Field47 <> Null) Then
                        arg0\Field37 = findpath(arg0, entityx(arg0\Field47\Field4, $01), (entityy(arg0\Field47\Field4, $01) + 0.1), entityz(arg0\Field47\Field4, $01))
                    Else
                        If (2.0 <> curr173\Field24) Then
                            For local3 = Each rooms
                                If ((((12.0 < (Abs (local3\Field3 - entityx(arg0\Field4, $01)))) Or (12.0 < (Abs (local3\Field5 - entityz(arg0\Field4, $01))))) And (rand($01, (Int max((Float ($04 - (Int (Abs (local3\Field5 - (entityz(arg0\Field4, $01) / 8.0)))))), 2.0))) = $01)) <> 0) Then
                                    local0 = local3\Field3
                                    local1 = 0.1
                                    local2 = local3\Field5
                                    Exit
                                EndIf
                            Next
                        Else
                            local13 = $00
                            If (4.0 < entitydistance(arg0\Field4, curr173\Field4)) Then
                                If (entityvisible(arg0\Field4, curr173\Field4) = $00) Then
                                    local13 = $01
                                EndIf
                            EndIf
                            If (local13 = $00) Then
                                For local3 = Each rooms
                                    If (local3\Field7\Field11 = "start") Then
                                        local14 = $00
                                        local15 = createpivot($00)
                                        positionentity(local15, (entityx(local3\Field2, $01) + (4736.0 * roomscale)), 0.5, (entityz(local3\Field2, $01) + (1692.0 * roomscale)), $00)
                                        If (3.5 > distance(entityx(local15, $00), entityz(local15, $00), entityx(arg0\Field4, $00), entityz(arg0\Field4, $00))) Then
                                            local14 = $01
                                            debuglog((Str distance(entityx(local15, $00), entityz(local15, $00), entityx(arg0\Field4, $00), entityz(arg0\Field4, $00))))
                                        EndIf
                                        If (((3.0 = curr173\Field24) And (4.0 < distance(entityx(local15, $00), entityz(local15, $00), entityx(arg0\Field4, $00), entityz(arg0\Field4, $00)))) <> 0) Then
                                            If (local3\Field29[$01]\Field5 = $01) Then
                                                usedoor(local3\Field29[$01], $00, $01, $00, "", $00)
                                            EndIf
                                        EndIf
                                        freeentity(local15)
                                        If (((1.6 < distance(entityx(arg0\Field4, $00), entityz(arg0\Field4, $00), (entityx(local3\Field2, $01) + (4736.0 * roomscale)), (entityz(local3\Field2, $01) + (1692.0 * roomscale)))) And (local14 = $00)) <> 0) Then
                                            local0 = (entityx(local3\Field2, $01) + (4736.0 * roomscale))
                                            local1 = 0.1
                                            local2 = (entityz(local3\Field2, $01) + (1692.0 * roomscale))
                                            debuglog("Move to 173's chamber")
                                            Exit
                                        ElseIf (((1.6 < distance(entityx(arg0\Field4, $00), entityz(arg0\Field4, $00), (entityx(local3\Field2, $01) + (4736.0 * roomscale)), (entityz(local3\Field2, $01) + (1692.0 * roomscale)))) And local14) <> 0) Then
                                            arg0\Field60 = (entityx(local3\Field2, $01) + (4736.0 * roomscale))
                                            arg0\Field61 = (entityz(local3\Field2, $01) + (1692.0 * roomscale))
                                            debuglog("Move inside 173's chamber")
                                            Exit
                                        Else
                                            curr173\Field24 = 3.0
                                            curr173\Field31 = Null
                                            curr173\Field48 = $01
                                            If (arg0\Field16 <> $00) Then
                                                freesound_strict(arg0\Field16)
                                                arg0\Field16 = $00
                                            EndIf
                                            arg0\Field16 = loadsound_strict((("SFX\Character\MTF\173\Cont" + (Str rand($01, $04))) + ".ogg"))
                                            playmtfsound(arg0\Field16, arg0)
                                            playannouncement("SFX\Character\MTF\Announc173Contain.ogg", $01, $00)
                                            debuglog("173 contained")
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            Else
                                local0 = entityx(curr173\Field4, $00)
                                local1 = 0.1
                                local2 = entityz(curr173\Field4, $00)
                                debuglog("Going back to 173's cage")
                            EndIf
                        EndIf
                        If (0.0 = arg0\Field60) Then
                            arg0\Field37 = findpath(arg0, local0, local1, local2)
                        EndIf
                    EndIf
                    If (arg0\Field37 = $01) Then
                        While (arg0\Field36[arg0\Field39] = Null)
                            If (arg0\Field39 > $13) Then
                                Exit
                            EndIf
                            arg0\Field39 = (arg0\Field39 + $01)
                        Wend
                        If (arg0\Field39 < $13) Then
                            If (((arg0\Field36[arg0\Field39] <> Null) And (arg0\Field36[(arg0\Field39 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field4, arg0\Field36[(arg0\Field39 + $01)]\Field0)) < (Abs deltayaw(arg0\Field4, arg0\Field36[arg0\Field39]\Field0))) Then
                                        arg0\Field39 = (arg0\Field39 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                ElseIf (((175.0 >= arg0\Field38) And (arg0\Field47 = Null)) <> 0) Then
                    arg0\Field38 = (arg0\Field38 - fpsfactor)
                    arg0\Field22 = 0.0
                    If (rand($01, $23) = $01) Then
                        rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                    EndIf
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                ElseIf (arg0\Field37 = $02) Then
                    arg0\Field38 = (arg0\Field38 - (fpsfactor * 2.0))
                    arg0\Field22 = 0.0
                    If (rand($01, $23) = $01) Then
                        rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                    EndIf
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                ElseIf (arg0\Field37 = $01) Then
                    If (arg0\Field36[arg0\Field39] = Null) Then
                        If (arg0\Field39 > $13) Then
                            arg0\Field39 = $00
                            arg0\Field37 = $00
                        Else
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    Else
                        local4 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        local5 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        If (((1.0 > local5) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                            If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                local16 = $00
                                If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                    local16 = $00
                                Else
                                    local16 = rand($00, $02)
                                EndIf
                                playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local16), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                playmtfsound(mtfsfx($05), arg0)
                            EndIf
                            arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                            If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                            EndIf
                        EndIf
                        If (((0.2 > local5) Or ((local5 > local4) And (1.0 > local4))) <> 0) Then
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    EndIf
                    arg0\Field38 = (arg0\Field38 - fpsfactor)
                ElseIf (0.0 <> arg0\Field60) Then
                    local15 = createpivot($00)
                    positionentity(local15, arg0\Field60, 0.5, arg0\Field61, $00)
                    pointentity(arg0\Field4, local15, 0.0)
                    rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                    arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                    translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                    animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                    If (0.2 > distance(entityx(arg0\Field4, $00), entityz(arg0\Field4, $00), arg0\Field60, arg0\Field61)) Then
                        arg0\Field60 = 0.0
                        arg0\Field61 = 0.0
                        arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                    EndIf
                    freeentity(local15)
                Else
                    arg0\Field38 = (arg0\Field38 - (fpsfactor * 2.0))
                    If (arg0\Field47 = Null) Then
                        If (rand($01, $23) = $01) Then
                            rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field22 = 0.0
                    ElseIf (1.0 < entitydistance(arg0\Field4, arg0\Field47\Field4)) Then
                        pointentity(arg0\Field4, arg0\Field47\Field4, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                    Else
                        If (rand($01, $23) = $01) Then
                            rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field22 = 0.0
                    EndIf
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                EndIf
                local17 = menpcseesplayer(arg0, $00)
                If (notarget <> 0) Then
                    local17 = $00
                EndIf
                If (local17 > $00) Then
                    If (((arg0\Field26 > $00) And (arg0\Field26 < $41A)) <> 0) Then
                        If (local17 < $02) Then
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict((("SFX\Character\MTF\ThereHeIs" + (Str rand($01, $06))) + ".ogg"))
                            playmtfsound(arg0\Field16, arg0)
                        EndIf
                    ElseIf (local17 = $01) Then
                        If (arg0\Field16 <> $00) Then
                            freesound_strict(arg0\Field16)
                            arg0\Field16 = $00
                        EndIf
                        arg0\Field16 = loadsound_strict((("SFX\Character\MTF\Stop" + (Str rand($01, $06))) + ".ogg"))
                        playmtfsound(arg0\Field16, arg0)
                    ElseIf (local17 = $02) Then
                        playmtfsound(mtfsfx(rand($00, $03)), arg0)
                    EndIf
                    arg0\Field26 = (Int (rnd(30.0, 40.0) * 70.0))
                    arg0\Field27 = 1.0
                    arg0\Field9 = 1.0
                    arg0\Field33 = entityx(arg0\Field73, $01)
                    arg0\Field34 = entityy(arg0\Field73, $01)
                    arg0\Field35 = entityz(arg0\Field73, $01)
                    arg0\Field10 = ((15.0 * (Float local17)) * 70.0)
                    debuglog(("player spotted :" + (Str arg0\Field10)))
                    arg0\Field38 = 0.0
                    arg0\Field37 = $00
                    arg0\Field25 = (Float ($C8 - (selecteddifficulty\Field3 * $64)))
                EndIf
                If (2.0 > curr173\Field24) Then
                    local18 = max(min((distance(entityx(curr173\Field4, $00), entityz(curr173\Field4, $00), curr173\Field28, curr173\Field30) * 2.5), 1.0), 0.0)
                    If ((othernpcseesmenpc(curr173, arg0) Or ((0.0 < local18) And (6.0 > entitydistance(arg0\Field4, curr173\Field4)))) <> 0) Then
                        If ((entityvisible(arg0\Field4, curr173\Field4) Or (0.0 < local18)) <> 0) Then
                            arg0\Field9 = 2.0
                            arg0\Field33 = entityx(curr173\Field4, $01)
                            arg0\Field34 = entityy(curr173\Field4, $01)
                            arg0\Field35 = entityz(curr173\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            debuglog(("173 spotted :" + (Str arg0\Field10)))
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict((("SFX\Character\MTF\173\Spotted" + (Str rand($01, $02))) + ".ogg"))
                            playmtfsound(arg0\Field16, arg0)
                        EndIf
                    EndIf
                EndIf
                If (0.0 >= curr106\Field9) Then
                    If ((othernpcseesmenpc(curr106, arg0) Or (3.0 > entitydistance(arg0\Field4, curr106\Field4))) <> 0) Then
                        If (entityvisible(arg0\Field4, curr106\Field4) <> 0) Then
                            arg0\Field9 = 4.0
                            arg0\Field33 = entityx(curr106\Field4, $01)
                            arg0\Field34 = entityy(curr106\Field4, $01)
                            arg0\Field35 = entityz(curr106\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            arg0\Field31 = curr106
                            debuglog(("106 spotted :" + (Str arg0\Field10)))
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict((("SFX\Character\MTF\106\Spotted" + (Str rand($01, $03))) + ".ogg"))
                            playmtfsound(arg0\Field16, arg0)
                        EndIf
                    EndIf
                EndIf
                If (curr096 <> Null) Then
                    If (othernpcseesmenpc(curr096, arg0) <> 0) Then
                        If (entityvisible(arg0\Field4, curr096\Field4) <> 0) Then
                            arg0\Field9 = 8.0
                            arg0\Field33 = entityx(curr096\Field4, $01)
                            arg0\Field34 = entityy(curr096\Field4, $01)
                            arg0\Field35 = entityz(curr096\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            debuglog(("096 spotted :" + (Str arg0\Field10)))
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict((("SFX\Character\MTF\096\Spotted" + (Str rand($01, $02))) + ".ogg"))
                            playmtfsound(arg0\Field16, arg0)
                        EndIf
                    EndIf
                EndIf
                For local6 = Each npcs
                    If (local6\Field5 = $0A) Then
                        If (othernpcseesmenpc(local6, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local6\Field4) <> 0) Then
                                arg0\Field9 = 4.0
                                arg0\Field33 = entityx(local6\Field4, $01)
                                arg0\Field34 = entityy(local6\Field4, $01)
                                arg0\Field35 = entityz(local6\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local6
                                debuglog(("049 spotted :" + (Str arg0\Field10)))
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict((("SFX\Character\MTF\049\Spotted" + (Str rand($01, $05))) + ".ogg"))
                                playmtfsound(arg0\Field16, arg0)
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local6\Field5 = $0B) And (local6\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local6, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local6\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local6\Field4, $01)
                                arg0\Field34 = entityy(local6\Field4, $01)
                                arg0\Field35 = entityz(local6\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local6
                                arg0\Field25 = 350.0
                                debuglog(("049-2 spotted :" + (Str arg0\Field10)))
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict("SFX\Character\MTF\049\Player0492_1.ogg")
                                playmtfsound(arg0\Field16, arg0)
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local6\Field5 = $15) And (local6\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local6, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local6\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local6\Field4, $01)
                                arg0\Field34 = entityy(local6\Field4, $01)
                                arg0\Field35 = entityz(local6\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local6
                                arg0\Field25 = 350.0
                                debuglog(("008 spotted :" + (Str arg0\Field10)))
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            Case $01
                arg0\Field21 = 0.015
                arg0\Field10 = (arg0\Field10 - fpsfactor)
                If (menpcseesplayer(arg0, $00) = $01) Then
                    If (4.0 > (Float local19)) Then
                        local20 = vectoryaw((entityx(arg0\Field73, $00) - entityx(arg0\Field4, $00)), 0.0, (entityz(arg0\Field73, $00) - entityz(arg0\Field4, $00)))
                        rotateentity(arg0\Field4, 0.0, curveangle(local20, entityyaw(arg0\Field4, $00), 10.0), 0.0, $01)
                        arg0\Field15 = entityyaw(arg0\Field4, $00)
                        If (((0.0 >= arg0\Field25) And (0.0 = killtimer)) <> 0) Then
                            If (entityvisible(arg0\Field4, camera) <> 0) Then
                                local20 = wrapangle((local20 - entityyaw(arg0\Field4, $00)))
                                If (((5.0 > local20) Or (355.0 < local20)) <> 0) Then
                                    local21 = (Int killtimer)
                                    playsound2(gunshotsfx, camera, arg0\Field4, 15.0, 1.0)
                                    local15 = createpivot($00)
                                    rotateentity(local15, entitypitch(arg0\Field4, $00), entityyaw(arg0\Field4, $00), 0.0, $01)
                                    positionentity(local15, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                                    moveentity(local15, 0.0632, 0.84925, 0.5451)
                                    shoot(arg0, entityx(local15, $00), entityy(local15, $00), entityz(local15, $00), (5.0 / (Float local19)), $00, $00)
                                    arg0\Field25 = 7.0
                                    freeentity(local15)
                                    deathmsg = "Subject D-9341. Died of blood loss after being shot by Nine-Tailed Fox."
                                    If (((local21 >= $00) And (0.0 > killtimer)) <> 0) Then
                                        deathmsg = "Subject D-9341. Terminated by Nine-Tailed Fox."
                                        playmtfsound(loadtempsound((("SFX\Character\MTF\Targetterminated" + (Str rand($01, $04))) + ".ogg")), arg0)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        For local6 = Each npcs
                            If (((local6\Field5 = $08) And (local6 <> arg0)) <> 0) Then
                                If (0.0 = local6\Field9) Then
                                    If (6.0 > entitydistance(arg0\Field4, local6\Field4)) Then
                                        arg0\Field12 = $01
                                        local6\Field26 = (Int (rnd(30.0, 40.0) * 70.0))
                                        local6\Field27 = 1.0
                                        local6\Field9 = 1.0
                                        local6\Field33 = entityx(arg0\Field73, $01)
                                        local6\Field34 = entityy(arg0\Field73, $01)
                                        local6\Field35 = entityz(arg0\Field73, $01)
                                        local6\Field10 = arg0\Field10
                                        local6\Field38 = 0.0
                                        local6\Field37 = $00
                                        local6\Field25 = (Float ($C8 - (selecteddifficulty\Field3 * $64)))
                                        local6\Field12 = $00
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If (arg0\Field12 = $01) Then
                            setnpcframe(arg0, 423.0)
                            arg0\Field12 = $02
                        ElseIf (arg0\Field12 = $02) Then
                            If (200.0 < arg0\Field14) Then
                                arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                                animatenpc(arg0, 423.0, 463.0, 0.4, $00)
                                If (462.9 < arg0\Field14) Then
                                    arg0\Field14 = 78.0
                                EndIf
                            Else
                                animatenpc(arg0, 78.0, 193.0, 0.2, $00)
                                arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                            EndIf
                        ElseIf (958.0 < arg0\Field14) Then
                            animatenpc(arg0, 1374.0, 1383.0, 0.3, $00)
                            arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                            If (1382.9 < arg0\Field14) Then
                                arg0\Field14 = 78.0
                            EndIf
                        Else
                            animatenpc(arg0, 78.0, 193.0, 0.2, $00)
                            arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                        EndIf
                    Else
                        positionentity(arg0\Field0, arg0\Field33, arg0\Field34, arg0\Field35, $01)
                        pointentity(arg0\Field4, arg0\Field0, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                    EndIf
                Else
                    arg0\Field26 = (Int ((Float arg0\Field26) - fpsfactor))
                    If (7.0 >= arg0\Field25) Then
                        arg0\Field25 = 7.0
                    EndIf
                    If (0.0 >= arg0\Field38) Then
                        arg0\Field37 = findpath(arg0, arg0\Field33, (arg0\Field34 + 0.1), arg0\Field35)
                        arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                    ElseIf (175.0 >= arg0\Field38) Then
                        arg0\Field38 = (arg0\Field38 - fpsfactor)
                        arg0\Field22 = 0.0
                        If (rand($01, $23) = $01) Then
                            rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                    ElseIf (arg0\Field37 = $02) Then
                        arg0\Field38 = (arg0\Field38 - (fpsfactor * 2.0))
                        arg0\Field22 = 0.0
                        If (rand($01, $23) = $01) Then
                            rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                    ElseIf (arg0\Field37 = $01) Then
                        If (arg0\Field36[arg0\Field39] = Null) Then
                            If (arg0\Field39 > $13) Then
                                arg0\Field39 = $00
                                arg0\Field37 = $00
                            Else
                                arg0\Field39 = (arg0\Field39 + $01)
                            EndIf
                        Else
                            local4 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                            arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                            translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                            local5 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            If (((1.0 > local5) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                    local16 = $00
                                    If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                        local16 = $00
                                    Else
                                        local16 = rand($00, $02)
                                    EndIf
                                    playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local16), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                    playmtfsound(mtfsfx($05), arg0)
                                EndIf
                                arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                                If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                    arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                                EndIf
                            EndIf
                            If (((0.2 > local5) Or ((local5 > local4) And (1.0 > local4))) <> 0) Then
                                arg0\Field39 = (arg0\Field39 + $01)
                            EndIf
                        EndIf
                        arg0\Field38 = (arg0\Field38 - fpsfactor)
                    Else
                        positionentity(arg0\Field0, arg0\Field33, arg0\Field34, arg0\Field35, $01)
                        If (((0.2 > distance(entityx(arg0\Field4, $01), entityz(arg0\Field4, $01), arg0\Field33, arg0\Field35)) Or (entityvisible(arg0\Field0, arg0\Field4) = $00)) <> 0) Then
                            If (rand($01, $23) = $01) Then
                                rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            If (rand($01, $23) = $01) Then
                                For local22 = Each waypoints
                                    If (rand($01, $03) = $01) Then
                                        If (6.0 > entitydistance(local22\Field0, arg0\Field4)) Then
                                            arg0\Field33 = entityx(local22\Field0, $01)
                                            arg0\Field34 = entityy(local22\Field0, $01)
                                            arg0\Field35 = entityz(local22\Field0, $01)
                                            arg0\Field38 = 0.0
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            arg0\Field38 = (arg0\Field38 - fpsfactor)
                        Else
                            pointentity(arg0\Field4, arg0\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                            arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                            translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        EndIf
                    EndIf
                    If ((((arg0\Field47 = Null) And (arg0\Field26 < $834)) And (2100.0 <= ((Float arg0\Field26) + fpsfactor))) <> 0) Then
                        If (rand($02, $01) = $01) Then
                            playmtfsound(loadtempsound((("SFX\Character\MTF\Searching" + (Str rand($01, $06))) + ".ogg")), arg0)
                        EndIf
                    EndIf
                EndIf
                If (((0.0 >= arg0\Field10) And (0.0 < (arg0\Field10 + fpsfactor))) <> 0) Then
                    If (arg0\Field47 = Null) Then
                        debuglog(("targetlost: " + (Str arg0\Field10)))
                        playmtfsound(loadtempsound((("SFX\Character\MTF\Targetlost" + (Str rand($01, $03))) + ".ogg")), arg0)
                        If (0.0 = mtf_camerachecktimer) Then
                            If (rand(($0F - (selecteddifficulty\Field3 * $07)), $01) = $01) Then
                                playannouncement("SFX\Character\MTF\AnnouncCameraCheck.ogg", $01, $00)
                                mtf_camerachecktimer = fpsfactor
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field9 = 0.0
                EndIf
                If (2.0 > curr173\Field24) Then
                    local18 = max(min((distance(entityx(curr173\Field4, $00), entityz(curr173\Field4, $00), curr173\Field28, curr173\Field30) * 2.5), 1.0), 0.0)
                    If ((othernpcseesmenpc(curr173, arg0) Or ((0.0 < local18) And (6.0 > entitydistance(arg0\Field4, curr173\Field4)))) <> 0) Then
                        If ((entityvisible(arg0\Field4, curr173\Field4) Or (0.0 < local18)) <> 0) Then
                            arg0\Field9 = 2.0
                            arg0\Field33 = entityx(curr173\Field4, $01)
                            arg0\Field34 = entityy(curr173\Field4, $01)
                            arg0\Field35 = entityz(curr173\Field4, $01)
                            arg0\Field10 = 1050.0
                            debuglog(("173 spotted :" + (Str arg0\Field10)))
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict("SFX\Character\MTF\173\Spotted3.ogg")
                            playmtfsound(arg0\Field16, arg0)
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                        EndIf
                    EndIf
                EndIf
                If (0.0 >= curr106\Field9) Then
                    If ((othernpcseesmenpc(curr106, arg0) Or (3.0 > entitydistance(arg0\Field4, curr106\Field4))) <> 0) Then
                        If (entityvisible(arg0\Field4, curr106\Field4) <> 0) Then
                            arg0\Field9 = 4.0
                            arg0\Field33 = entityx(curr106\Field4, $01)
                            arg0\Field34 = entityy(curr106\Field4, $01)
                            arg0\Field35 = entityz(curr106\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            arg0\Field31 = curr106
                            debuglog(("106 spotted :" + (Str arg0\Field10)))
                            If (arg0\Field47 = Null) Then
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict("SFX\Character\MTF\106\Spotted4.ogg")
                                playmtfsound(arg0\Field16, arg0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (curr096 <> Null) Then
                    If (othernpcseesmenpc(curr096, arg0) <> 0) Then
                        If (entityvisible(arg0\Field4, curr096\Field4) <> 0) Then
                            arg0\Field9 = 8.0
                            arg0\Field33 = entityx(curr096\Field4, $01)
                            arg0\Field34 = entityy(curr096\Field4, $01)
                            arg0\Field35 = entityz(curr096\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            debuglog(("096 spotted :" + (Str arg0\Field10)))
                            If (arg0\Field47 = Null) Then
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict((("SFX\Character\MTF\096\Spotted" + (Str rand($01, $02))) + ".ogg"))
                                playmtfsound(arg0\Field16, arg0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                For local6 = Each npcs
                    If (local6\Field5 = $0A) Then
                        If (othernpcseesmenpc(local6, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local6\Field4) <> 0) Then
                                arg0\Field9 = 4.0
                                arg0\Field33 = entityx(local6\Field4, $01)
                                arg0\Field34 = entityy(local6\Field4, $01)
                                arg0\Field35 = entityz(local6\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local6
                                debuglog(("049 spotted :" + (Str arg0\Field10)))
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict((("SFX\Character\MTF\049\Spotted" + (Str rand($01, $05))) + ".ogg"))
                                playmtfsound(arg0\Field16, arg0)
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local6\Field5 = $0B) And (local6\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local6, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local6\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local6\Field4, $01)
                                arg0\Field34 = entityy(local6\Field4, $01)
                                arg0\Field35 = entityz(local6\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local6
                                arg0\Field25 = 350.0
                                debuglog(("049-2 spotted :" + (Str arg0\Field10)))
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict("SFX\Character\MTF\049\Player0492_1.ogg")
                                playmtfsound(arg0\Field16, arg0)
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            Case $02
                If (2.0 = curr173\Field24) Then
                    arg0\Field9 = 0.0
                Else
                    For local6 = Each npcs
                        If (local6 <> arg0) Then
                            If (local6\Field5 = $08) Then
                                local6\Field9 = 2.0
                            EndIf
                        EndIf
                    Next
                    local23 = distance(entityx(arg0\Field4, $01), entityz(arg0\Field4, $01), entityx(curr173\Field4, $01), entityz(curr173\Field4, $01))
                    If (5.0 > local23) Then
                        If (2.0 <> curr173\Field24) Then
                            curr173\Field24 = 1.0
                        EndIf
                        arg0\Field10 = 1050.0
                        arg0\Field38 = 0.0
                        local24 = 1.0
                        If (arg0\Field47 <> Null) Then
                            local24 = 2.0
                        EndIf
                        If (local24 > local23) Then
                            If (arg0\Field47 = Null) Then
                                arg0\Field11 = (arg0\Field11 + fpsfactor)
                                debuglog(("CONTAINING 173: " + (Str arg0\Field11)))
                                If (1050.0 <= arg0\Field11) Then
                                    curr173\Field24 = 2.0
                                    If (arg0\Field47 = Null) Then
                                        curr173\Field31 = arg0
                                    EndIf
                                    If (arg0\Field16 <> $00) Then
                                        freesound_strict(arg0\Field16)
                                        arg0\Field16 = $00
                                    EndIf
                                    arg0\Field16 = loadsound_strict((("SFX\Character\MTF\173\Box" + (Str rand($01, $03))) + ".ogg"))
                                    playmtfsound(arg0\Field16, arg0)
                                EndIf
                            EndIf
                            positionentity(arg0\Field0, entityx(curr173\Field4, $01), entityy(curr173\Field4, $01), entityz(curr173\Field4, $01), $01)
                            pointentity(arg0\Field4, arg0\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        Else
                            positionentity(arg0\Field0, entityx(curr173\Field4, $01), entityy(curr173\Field4, $01), entityz(curr173\Field4, $01), $01)
                            pointentity(arg0\Field4, arg0\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                            arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                            translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        EndIf
                    Else
                        If (2.0 <> curr173\Field24) Then
                            curr173\Field24 = 0.0
                        EndIf
                        If (0.0 >= arg0\Field38) Then
                            arg0\Field37 = findpath(arg0, entityx(curr173\Field4, $01), (entityy(curr173\Field4, $01) + 0.1), entityz(curr173\Field4, $01))
                            arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                        ElseIf (175.0 >= arg0\Field38) Then
                            arg0\Field38 = (arg0\Field38 - fpsfactor)
                            arg0\Field22 = 0.0
                            If (rand($01, $23) = $01) Then
                                rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        ElseIf (arg0\Field37 = $02) Then
                            arg0\Field38 = (arg0\Field38 - (fpsfactor * 2.0))
                            arg0\Field22 = 0.0
                            If (rand($01, $23) = $01) Then
                                rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        ElseIf (arg0\Field37 = $01) Then
                            If (arg0\Field36[arg0\Field39] = Null) Then
                                If (arg0\Field39 > $13) Then
                                    arg0\Field39 = $00
                                    arg0\Field37 = $00
                                Else
                                    arg0\Field39 = (arg0\Field39 + $01)
                                EndIf
                            Else
                                local4 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                                pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                                rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                                arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                                rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                                arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                                translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                                animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                                local5 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                                If (((1.0 > local5) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                                    If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                        local16 = $00
                                        If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                            local16 = $00
                                        Else
                                            local16 = rand($00, $02)
                                        EndIf
                                        playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local16), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                        playmtfsound(mtfsfx($05), arg0)
                                    EndIf
                                    arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                                    If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                        arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                                    EndIf
                                EndIf
                                If (((0.2 > local5) Or ((local5 > local4) And (1.0 > local4))) <> 0) Then
                                    arg0\Field39 = (arg0\Field39 + $01)
                                EndIf
                            EndIf
                            arg0\Field38 = (arg0\Field38 - fpsfactor)
                        Else
                            arg0\Field38 = (arg0\Field38 - (fpsfactor * 2.0))
                            arg0\Field22 = 0.0
                            If (rand($01, $23) = $01) Then
                                rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        EndIf
                    EndIf
                EndIf
            Case $03
                arg0\Field15 = curvevalue(0.0, arg0\Field15, 40.0)
                If (arg0\Field37 = $02) Then
                    arg0\Field9 = 5.0
                    arg0\Field22 = 0.0
                ElseIf (arg0\Field37 = $01) Then
                    If (arg0\Field36[arg0\Field39] = Null) Then
                        If (arg0\Field39 > $13) Then
                            arg0\Field39 = $00
                            arg0\Field37 = $00
                            If (arg0\Field26 > $00) Then
                                arg0\Field9 = 5.0
                            EndIf
                        Else
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    Else
                        If (arg0\Field36[arg0\Field39]\Field1 <> Null) Then
                            If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                                arg0\Field36[arg0\Field39]\Field1\Field11 = 560.0
                                playmtfsound(mtfsfx($05), arg0)
                            EndIf
                        EndIf
                        If (local9 < (hidedistance * 0.7)) Then
                            local10 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            pointentity(arg0\Field0, arg0\Field36[arg0\Field39]\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field4, $00), 10.0), 0.0, $00)
                            If (0.0 = arg0\Field24) Then
                                arg0\Field22 = curvevalue((arg0\Field21 * max(min(local10, 1.0), 0.1)), arg0\Field22, 20.0)
                                moveentity(arg0\Field4, 0.0, 0.0, (arg0\Field22 * fpsfactor))
                                If (0.5 > entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)) Then
                                    arg0\Field39 = (arg0\Field39 + $01)
                                EndIf
                            EndIf
                        ElseIf (rand($14, $01) = $01) Then
                            positionentity(arg0\Field4, entityx(arg0\Field36[arg0\Field39]\Field0, $01), (entityy(arg0\Field36[arg0\Field39]\Field0, $01) + 0.25), entityz(arg0\Field36[arg0\Field39]\Field0, $01), $01)
                            arg0\Field39 = (arg0\Field39 + $01)
                            resetentity(arg0\Field4)
                        EndIf
                    EndIf
                Else
                    arg0\Field22 = 0.0
                    arg0\Field9 = 5.0
                EndIf
                If (((0.0 = arg0\Field24) And (arg0\Field37 = $01)) <> 0) Then
                    If (hidedistance > local9) Then
                        If (959.0 < arg0\Field14) Then
                            animatenpc(arg0, 1376.0, 1383.0, 0.2, $00)
                            If (1382.9 < arg0\Field14) Then
                                arg0\Field14 = 488.0
                            EndIf
                        Else
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 30.0), $01)
                        EndIf
                    EndIf
                Else
                    If (hidedistance > local9) Then
                        If (arg0\Field26 > $00) Then
                            animatenpc(arg0, 78.0, 312.0, 0.2, $01)
                        ElseIf (962.0 > arg0\Field14) Then
                            If (487.0 < arg0\Field14) Then
                                arg0\Field14 = 463.0
                            EndIf
                            animatenpc(arg0, 463.0, 487.0, 0.3, $00)
                            If (486.9 < arg0\Field14) Then
                                arg0\Field14 = 962.0
                            EndIf
                        Else
                            animatenpc(arg0, 962.0, 1259.0, 0.3, $01)
                        EndIf
                    EndIf
                    arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                EndIf
                arg0\Field15 = entityyaw(arg0\Field4, $00)
            Case $04
                arg0\Field21 = 0.03
                arg0\Field10 = (arg0\Field10 - fpsfactor)
                If (0.0 < arg0\Field10) Then
                    If (othernpcseesmenpc(arg0\Field31, arg0) <> 0) Then
                        arg0\Field10 = 1050.0
                    EndIf
                    If (hidedistance < entitydistance(arg0\Field31\Field4, arg0\Field4)) Then
                        If (70.0 < arg0\Field10) Then
                            arg0\Field10 = 70.0
                        EndIf
                    EndIf
                    If (((3.0 > entitydistance(arg0\Field31\Field4, arg0\Field4)) And (0.0 <= arg0\Field11)) <> 0) Then
                        arg0\Field11 = 350.0
                    EndIf
                    If (0.0 < arg0\Field11) Then
                        arg0\Field37 = $00
                        arg0\Field39 = $00
                        arg0\Field21 = 0.02
                        pointentity(arg0\Field4, arg0\Field31\Field4, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue((- arg0\Field21), arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                        animatenpc(arg0, 522.0, 488.0, (arg0\Field22 * 26.0), $01)
                        arg0\Field38 = 1.0
                        arg0\Field11 = max((arg0\Field11 - fpsfactor), 0.0)
                        hideentity(arg0\Field4)
                        turnentity(arg0\Field4, 0.0, 180.0, 0.0, $00)
                        entitypick(arg0\Field4, 1.0)
                        If (pickedentity() <> $00) Then
                            arg0\Field11 = -140.0
                        EndIf
                        showentity(arg0\Field4)
                        turnentity(arg0\Field4, 0.0, 180.0, 0.0, $00)
                    ElseIf (0.0 > arg0\Field11) Then
                        arg0\Field11 = min((arg0\Field11 + fpsfactor), 0.0)
                    EndIf
                    If (0.0 >= arg0\Field38) Then
                        If (arg0\Field47 <> Null) Then
                            arg0\Field37 = findpath(arg0, entityx(arg0\Field47\Field4, $01), (entityy(arg0\Field47\Field4, $01) + 0.1), entityz(arg0\Field47\Field4, $01))
                        Else
                            For local3 = Each rooms
                                If ((((12.0 < (Abs (local3\Field3 - entityx(arg0\Field4, $01)))) Or (12.0 < (Abs (local3\Field5 - entityz(arg0\Field4, $01))))) And (rand($01, (Int max((Float ($04 - (Int (Abs (local3\Field5 - (entityz(arg0\Field4, $01) / 8.0)))))), 2.0))) = $01)) <> 0) Then
                                    If (6.0 < entitydistance(local3\Field2, arg0\Field31\Field4)) Then
                                        local0 = local3\Field3
                                        local1 = 0.1
                                        local2 = local3\Field5
                                        debuglog(local3\Field7\Field11)
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            arg0\Field37 = findpath(arg0, local0, local1, local2)
                        EndIf
                        If (arg0\Field37 = $01) Then
                            While (arg0\Field36[arg0\Field39] = Null)
                                If (arg0\Field39 > $13) Then
                                    Exit
                                EndIf
                                arg0\Field39 = (arg0\Field39 + $01)
                            Wend
                            If (arg0\Field39 < $13) Then
                                If (((arg0\Field36[arg0\Field39] <> Null) And (arg0\Field36[(arg0\Field39 + $01)] <> Null)) <> 0) Then
                                    If (arg0\Field36[arg0\Field39]\Field1 = Null) Then
                                        If ((Abs deltayaw(arg0\Field4, arg0\Field36[(arg0\Field39 + $01)]\Field0)) < (Abs deltayaw(arg0\Field4, arg0\Field36[arg0\Field39]\Field0))) Then
                                            arg0\Field39 = (arg0\Field39 + $01)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        arg0\Field38 = 700.0
                    ElseIf (arg0\Field37 = $01) Then
                        If (arg0\Field36[arg0\Field39] = Null) Then
                            If (arg0\Field39 > $13) Then
                                arg0\Field39 = $00
                                arg0\Field37 = $00
                            Else
                                arg0\Field39 = (arg0\Field39 + $01)
                            EndIf
                        Else
                            local4 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                            arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                            translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                            local5 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            If (((2.0 > local5) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                    local16 = $00
                                    If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                        local16 = $00
                                    Else
                                        local16 = rand($00, $02)
                                    EndIf
                                    playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local16), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                    playmtfsound(mtfsfx($05), arg0)
                                EndIf
                                arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                                If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                    arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                                EndIf
                            EndIf
                            If (((0.2 > local5) Or ((local5 > local4) And (1.0 > local4))) <> 0) Then
                                arg0\Field39 = (arg0\Field39 + $01)
                            EndIf
                        EndIf
                        arg0\Field38 = (arg0\Field38 - fpsfactor)
                    Else
                        arg0\Field38 = 0.0
                    EndIf
                Else
                    arg0\Field9 = 0.0
                EndIf
            Case $05
                local8 = createpivot($00)
                positionentity(local8, arg0\Field33, arg0\Field34, arg0\Field35, $01)
                If (hidedistance > local9) Then
                    animatenpc(arg0, 346.0, 351.0, 0.2, $00)
                EndIf
                If ((((55.0 > (Abs (entityx(local8, $00) - entityx(arg0\Field4, $00)))) And (55.0 > (Abs (entityz(local8, $00) - entityz(arg0\Field4, $00))))) And (20.0 > (Abs (entityy(local8, $00) - entityy(arg0\Field4, $00))))) <> 0) Then
                    pointentity(arg0\Field0, local8, 0.0)
                    rotateentity(arg0\Field4, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field4, $00), 30.0), 0.0, $01)
                    If (0.0 = arg0\Field38) Then
                        arg0\Field37 = entityvisible(arg0\Field4, local8)
                        arg0\Field38 = (Float rand($64, $C8))
                    Else
                        arg0\Field38 = min((arg0\Field38 - fpsfactor), 0.0)
                    EndIf
                    If (((arg0\Field37 = $01) And (0.0 >= arg0\Field25)) <> 0) Then
                        local9 = distance(entityx(local8, $00), entityz(local8, $00), entityx(arg0\Field4, $00), entityz(arg0\Field4, $00))
                    EndIf
                EndIf
                freeentity(local8)
                arg0\Field15 = entityyaw(arg0\Field4, $00)
            Case $06
                pointentity(arg0\Field0, arg0\Field73, 0.0)
                rotateentity(arg0\Field4, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field4, $00), 20.0), 0.0, $00)
                arg0\Field15 = entityyaw(arg0\Field4, $00)
                animatenpc(arg0, 346.0, 351.0, 0.2, $00)
                If (((0.0 >= arg0\Field25) And (0.0 = killtimer)) <> 0) Then
                    If (entityvisible(arg0\Field4, arg0\Field73) <> 0) Then
                        If (50.0 > (Abs deltayaw(arg0\Field4, arg0\Field73))) Then
                            playsound2(gunshotsfx, camera, arg0\Field4, 15.0, 1.0)
                            local15 = createpivot($00)
                            rotateentity(local15, entitypitch(arg0\Field4, $00), entityyaw(arg0\Field4, $00), 0.0, $01)
                            positionentity(local15, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                            moveentity(local15, 0.0632, 0.84925, 0.5451)
                            shoot(arg0, entityx(local15, $00), entityy(local15, $00), entityz(local15, $00), 0.9, $00, $00)
                            arg0\Field25 = 7.0
                            freeentity(local15)
                        EndIf
                    EndIf
                EndIf
            Case $07
                animatenpc(arg0, 346.0, 351.0, 0.2, $00)
                rotateentity(arg0\Field4, 0.0, curveangle(arg0\Field10, entityyaw(arg0\Field4, $00), 20.0), 0.0, $00)
                arg0\Field15 = entityyaw(arg0\Field4, $00)
                If (0.0 >= arg0\Field25) Then
                    lightvolume = (templightvolume * 1.2)
                    playsound2(gunshotsfx, camera, arg0\Field4, 20.0, 1.0)
                    local15 = createpivot($00)
                    rotateentity(local15, entitypitch(arg0\Field4, $00), entityyaw(arg0\Field4, $00), 0.0, $01)
                    positionentity(local15, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                    moveentity(local15, 0.0632, 0.84925, 0.5451)
                    local7 = createparticle(entityx(local15, $00), entityy(local15, $00), entityz(local15, $00), $01, rnd(0.08, 0.1), 0.0, $05)
                    turnentity(local7\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
                    local7\Field15 = -0.15
                    freeentity(local15)
                    arg0\Field25 = 7.0
                EndIf
            Case $08
                arg0\Field21 = 0.015
                arg0\Field53 = "head"
                arg0\Field51 = $01
                arg0\Field52 = $02
                If (0.0 >= arg0\Field38) Then
                    If (arg0\Field47 <> Null) Then
                        arg0\Field37 = findpath(arg0, entityx(arg0\Field47\Field4, $01), (entityy(arg0\Field47\Field4, $01) + 0.1), entityz(arg0\Field47\Field4, $01))
                    Else
                        For local3 = Each rooms
                            If ((((12.0 < (Abs (local3\Field3 - entityx(arg0\Field4, $01)))) Or (12.0 < (Abs (local3\Field5 - entityz(arg0\Field4, $01))))) And (rand($01, (Int max((Float ($04 - (Int (Abs (local3\Field5 - (entityz(arg0\Field4, $01) / 8.0)))))), 2.0))) = $01)) <> 0) Then
                                local0 = local3\Field3
                                local1 = 0.1
                                local2 = local3\Field5
                                debuglog(local3\Field7\Field11)
                                Exit
                            EndIf
                        Next
                        arg0\Field37 = findpath(arg0, local0, local1, local2)
                    EndIf
                    If (arg0\Field37 = $01) Then
                        While (arg0\Field36[arg0\Field39] = Null)
                            If (arg0\Field39 > $13) Then
                                Exit
                            EndIf
                            arg0\Field39 = (arg0\Field39 + $01)
                        Wend
                        If (arg0\Field39 < $13) Then
                            If (((arg0\Field36[arg0\Field39] <> Null) And (arg0\Field36[(arg0\Field39 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field4, arg0\Field36[(arg0\Field39 + $01)]\Field0)) < (Abs deltayaw(arg0\Field4, arg0\Field36[arg0\Field39]\Field0))) Then
                                        arg0\Field39 = (arg0\Field39 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                ElseIf (((175.0 >= arg0\Field38) And (arg0\Field47 = Null)) <> 0) Then
                    arg0\Field38 = (arg0\Field38 - fpsfactor)
                    arg0\Field22 = 0.0
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                ElseIf (arg0\Field37 = $02) Then
                    arg0\Field38 = (arg0\Field38 - (fpsfactor * 2.0))
                    arg0\Field22 = 0.0
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                ElseIf (arg0\Field37 = $01) Then
                    If (arg0\Field36[arg0\Field39] = Null) Then
                        If (arg0\Field39 > $13) Then
                            arg0\Field39 = $00
                            arg0\Field37 = $00
                        Else
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    Else
                        local4 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        local5 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        If (((1.0 > local5) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                            If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                local16 = $00
                                If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                    local16 = $00
                                Else
                                    local16 = rand($00, $02)
                                EndIf
                                playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local16), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                playmtfsound(mtfsfx($05), arg0)
                            EndIf
                            arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                            If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                            EndIf
                        EndIf
                        If (((0.2 > local5) Or ((local5 > local4) And (1.0 > local4))) <> 0) Then
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    EndIf
                    arg0\Field38 = (arg0\Field38 - fpsfactor)
                Else
                    arg0\Field38 = (arg0\Field38 - (fpsfactor * 2.0))
                    If (arg0\Field47 = Null) Then
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field22 = 0.0
                    ElseIf (1.0 < entitydistance(arg0\Field4, arg0\Field47\Field4)) Then
                        pointentity(arg0\Field4, arg0\Field47\Field4, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                    Else
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field22 = 0.0
                    EndIf
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                EndIf
                If (((entityvisible(arg0\Field4, curr096\Field4) = $00) Or (6.0 < entitydistance(arg0\Field4, curr096\Field4))) <> 0) Then
                    arg0\Field9 = 0.0
                EndIf
            Case $09
                If (entityvisible(arg0\Field4, arg0\Field31\Field4) <> 0) Then
                    pointentity(arg0\Field0, arg0\Field31\Field4, 0.0)
                    rotateentity(arg0\Field4, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field4, $00), 20.0), 0.0, $00)
                    arg0\Field15 = entityyaw(arg0\Field4, $00)
                    If (1.3 > entitydistance(arg0\Field31\Field4, arg0\Field4)) Then
                        arg0\Field11 = 140.0
                    EndIf
                    If (0.0 < arg0\Field11) Then
                        arg0\Field37 = $00
                        arg0\Field39 = $00
                        arg0\Field21 = 0.02
                        arg0\Field22 = curvevalue((- arg0\Field21), arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                        animatenpc(arg0, 522.0, 488.0, (arg0\Field22 * 26.0), $01)
                        arg0\Field38 = 1.0
                        arg0\Field11 = max((arg0\Field11 - fpsfactor), 0.0)
                    Else
                        arg0\Field11 = 0.0
                        animatenpc(arg0, 346.0, 351.0, 0.2, $00)
                    EndIf
                    If (((0.0 >= arg0\Field25) And (arg0\Field31\Field48 = $00)) <> 0) Then
                        If (50.0 > (Abs deltayaw(arg0\Field4, arg0\Field31\Field4))) Then
                            playsound2(gunshotsfx, camera, arg0\Field4, 15.0, 1.0)
                            local15 = createpivot($00)
                            rotateentity(local15, entitypitch(arg0\Field4, $00), entityyaw(arg0\Field4, $00), 0.0, $01)
                            positionentity(local15, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                            moveentity(local15, 0.0632, 0.84925, 0.5451)
                            local7 = createparticle(entityx(local15, $00), entityy(local15, $00), entityz(local15, $00), $01, rnd(0.08, 0.1), 0.0, $05)
                            turnentity(local7\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
                            local7\Field15 = -0.15
                            If (arg0\Field31\Field59 > $00) Then
                                arg0\Field31\Field59 = (Int max((Float (arg0\Field31\Field59 - rand($05, $0A))), 0.0))
                            Else
                                If (arg0\Field31\Field48 = $00) Then
                                    If (arg0\Field16 <> $00) Then
                                        freesound_strict(arg0\Field16)
                                        arg0\Field16 = $00
                                    EndIf
                                    If (arg0\Field31\Field5 = $0B) Then
                                        arg0\Field16 = loadsound_strict("SFX\Character\MTF\049\Player0492_2.ogg")
                                        playmtfsound(arg0\Field16, arg0)
                                    EndIf
                                EndIf
                                setnpcframe(arg0\Field31, 133.0)
                                arg0\Field31\Field48 = $01
                                arg0\Field31 = Null
                                arg0\Field9 = 0.0
                                Return $00
                            EndIf
                            arg0\Field25 = 7.0
                            freeentity(local15)
                        EndIf
                    EndIf
                    arg0\Field37 = $00
                ElseIf (0.0 >= arg0\Field38) Then
                    arg0\Field37 = findpath(arg0, entityx(arg0\Field31\Field4, $00), entityy(arg0\Field31\Field4, $00), entityz(arg0\Field31\Field4, $00))
                    If (arg0\Field37 = $01) Then
                        While (arg0\Field36[arg0\Field39] = Null)
                            If (arg0\Field39 > $13) Then
                                Exit
                            EndIf
                            arg0\Field39 = (arg0\Field39 + $01)
                        Wend
                        If (arg0\Field39 < $13) Then
                            If (((arg0\Field36[arg0\Field39] <> Null) And (arg0\Field36[(arg0\Field39 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field4, arg0\Field36[(arg0\Field39 + $01)]\Field0)) < (Abs deltayaw(arg0\Field4, arg0\Field36[arg0\Field39]\Field0))) Then
                                        arg0\Field39 = (arg0\Field39 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field38 = 700.0
                ElseIf (arg0\Field37 = $01) Then
                    If (arg0\Field36[arg0\Field39] = Null) Then
                        If (arg0\Field39 > $13) Then
                            arg0\Field39 = $00
                            arg0\Field37 = $00
                        Else
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    Else
                        local4 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * fpsfactor), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        local5 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        If (((1.0 > local5) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                            If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                local16 = $00
                                If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                    local16 = $00
                                Else
                                    local16 = rand($00, $02)
                                EndIf
                                playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local16), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                playmtfsound(mtfsfx($05), arg0)
                            EndIf
                            arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                            If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                            EndIf
                        EndIf
                        If (((0.2 > local5) Or ((local5 > local4) And (1.0 > local4))) <> 0) Then
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    EndIf
                    arg0\Field38 = (arg0\Field38 - fpsfactor)
                Else
                    arg0\Field38 = 0.0
                EndIf
                If (arg0\Field31\Field48 = $01) Then
                    arg0\Field31 = Null
                    arg0\Field9 = 0.0
                EndIf
        End Select
        If (0.01 < arg0\Field22) Then
            If (((500.0 < local11) And (495.0 > arg0\Field14)) <> 0) Then
                playsound2(stepsfx($02, $00, rand($00, $02)), camera, arg0\Field4, 8.0, rnd(0.5, 0.7))
            ElseIf (((505.0 > local11) And (505.0 <= arg0\Field14)) <> 0) Then
                playsound2(stepsfx($02, $00, rand($00, $02)), camera, arg0\Field4, 8.0, rnd(0.5, 0.7))
            EndIf
        EndIf
        If ((notarget And (1.0 = arg0\Field9)) <> 0) Then
            arg0\Field9 = 0.0
        EndIf
        If (((((3.0 <> arg0\Field9) And (5.0 <> arg0\Field9)) And (6.0 <> arg0\Field9)) And (7.0 <> arg0\Field9)) <> 0) Then
            If (arg0\Field47 <> Null) Then
                If (0.7 > entitydistance(arg0\Field4, arg0\Field47\Field4)) Then
                    pointentity(arg0\Field4, arg0\Field47\Field4, 0.0)
                    rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) - 45.0)) * 0.01) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) - 45.0)) * 0.01) * fpsfactor), $01)
                EndIf
            Else
                For local6 = Each npcs
                    If (((local6 <> arg0) And (local6\Field48 = $00)) <> 0) Then
                        If (80.0 > (Abs deltayaw(arg0\Field4, local6\Field4))) Then
                            If (0.7 > entitydistance(arg0\Field4, local6\Field4)) Then
                                translateentity(local6\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * 0.01) * fpsfactor), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * 0.01) * fpsfactor), $01)
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        EndIf
        If (((6.0 <> arg0\Field9) And (7.0 <> arg0\Field9)) <> 0) Then
            If (-10.0 > entityy(arg0\Field4, $00)) Then
                teleportcloser(arg0)
            EndIf
        EndIf
        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
        positionentity(arg0\Field0, entityx(arg0\Field4, $01), (entityy(arg0\Field4, $01) - 0.15), entityz(arg0\Field4, $01), $01)
    EndIf
    Return $00
End Function
