Function mp_updatenpctype008_1%(arg0.npcs)
    Local local0#
    Local local1#
    Local local3.rooms
    Local local4#
    Local local5#
    Local local6#
    Local local7.npcs
    If (arg0\Field50 = $00) Then
        local0 = arg0\Field14
        updatenpcblinking(arg0)
        Select arg0\Field10
            Case 0.0
                setnpcframe(arg0, 11.0, $01)
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
            Case 1.0
                animatenpc(arg0, 11.0, 29.0, 0.1, $00)
                If (28.9 < arg0\Field14) Then
                    arg0\Field10 = 3.0
                EndIf
            Case 2.0
                arg0\Field11 = max((arg0\Field11 - fps\Field7[$00]), 0.0)
                If (0.0 < arg0\Field11) Then
                    If (arg0\Field34 = Null) Then
                        If (npcseesplayer(arg0, ((8.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                            arg0\Field11 = 140.0
                        EndIf
                        If (entityvisible(arg0\Field3, me\Field60) <> 0) Then
                            pointentity(arg0\Field3, me\Field60, 0.0)
                        EndIf
                        local1 = entitydistancesquared(arg0\Field3, me\Field60)
                    Else
                        If (npcseesnpc(arg0\Field34, arg0, 36.0) = $01) Then
                            arg0\Field11 = 140.0
                        EndIf
                        If (entityvisible(arg0\Field3, arg0\Field34\Field3) <> 0) Then
                            pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                        EndIf
                        local1 = entitydistancesquared(arg0\Field3, arg0\Field34\Field3)
                    EndIf
                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                    If (9.0 > local1) Then
                        animatenpc(arg0, min(animtime(arg0\Field0), 95.0), 125.0, (arg0\Field24 * 30.0), $01)
                    Else
                        animatenpc(arg0, min(animtime(arg0\Field0), 64.0), 93.0, (arg0\Field24 * 30.0), $01)
                    EndIf
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    If (0.49 > local1) Then
                        setnpcframe(arg0, 126.0, $01)
                        arg0\Field10 = 4.0
                    EndIf
                    arg0\Field41 = 0.0
                    arg0\Field40 = $00
                    arg0\Field42 = $00
                    If ((((((65.0 > local0) And (65.0 <= arg0\Field14)) Lor ((80.0 > local0) And (80.0 <= arg0\Field14))) Lor ((95.0 > local0) And (95.0 <= arg0\Field14))) Lor ((113.0 > local0) And (113.0 <= arg0\Field14))) <> 0) Then
                        playsoundex(stepsfx(getstepsound(arg0\Field3), $00, rand($00, $07)), camera, arg0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                    EndIf
                Else
                    arg0\Field34 = Null
                    arg0\Field10 = 3.0
                EndIf
            Case 3.0
                local1 = entitydistancesquared(arg0\Field3, me\Field60)
                If (0.0 >= arg0\Field41) Then
                    local4 = 0.0
                    local5 = 0.0
                    local6 = 0.0
                    For local3 = Each rooms
                        If (((196.0 > entitydistancesquared(local3\Field2, arg0\Field3)) And (36.0 < entitydistancesquared(local3\Field2, arg0\Field3))) <> 0) Then
                            local4 = entityx(local3\Field2, $00)
                            local5 = 0.1
                            local6 = entityz(local3\Field2, $00)
                            Exit
                        EndIf
                    Next
                    If ((((0.0 <> local4) And (0.0 <> local5)) And (0.0 <> local6)) <> 0) Then
                        arg0\Field40 = findpath(arg0, local4, local5, local6)
                    EndIf
                    If (arg0\Field40 = $01) Then
                        While (arg0\Field39[arg0\Field42] = Null)
                            If (arg0\Field42 > $14) Then
                                arg0\Field42 = $00
                                arg0\Field40 = $00
                                Exit
                            Else
                                arg0\Field42 = (arg0\Field42 + $01)
                            EndIf
                        Wend
                        If (arg0\Field42 < $14) Then
                            If (((arg0\Field39[arg0\Field42] <> Null) And (arg0\Field39[(arg0\Field42 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field39[arg0\Field42]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field3, arg0\Field39[(arg0\Field42 + $01)]\Field0)) < (Abs deltayaw(arg0\Field3, arg0\Field39[arg0\Field42]\Field0))) Then
                                        arg0\Field42 = (arg0\Field42 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        usedoornpc(arg0, $01, $00)
                    EndIf
                    arg0\Field41 = (rnd(6.0, 10.0) * 70.0)
                Else
                    If (0.49 > local1) Then
                        If ((entityvisible(me\Field60, arg0\Field3) And (chs\Field2 = $00)) <> 0) Then
                            arg0\Field11 = 70.0
                            arg0\Field10 = 4.0
                        EndIf
                    EndIf
                    If (arg0\Field40 = $01) Then
                        If (arg0\Field39[arg0\Field42] = Null) Then
                            If (arg0\Field42 > $14) Then
                                arg0\Field42 = $00
                                arg0\Field40 = $00
                            Else
                                arg0\Field42 = (arg0\Field42 + $01)
                            EndIf
                        Else
                            pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                            arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 20.0)
                            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                            arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                            usedoornpc(arg0, $01, $00)
                        EndIf
                        arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                    Else
                        arg0\Field24 = curvevalue(0.0, arg0\Field24, 10.0)
                        arg0\Field41 = (arg0\Field41 - (fps\Field7[$00] * 2.0))
                    EndIf
                EndIf
                If (0.005 > arg0\Field24) Then
                    animatenpc(arg0, 323.0, 344.0, 0.2, $01)
                Else
                    animatenpc(arg0, 64.0, 93.0, (arg0\Field24 * 30.0), $01)
                    If ((((65.0 > local0) And (65.0 <= arg0\Field14)) Lor ((80.0 > local0) And (80.0 <= arg0\Field14))) <> 0) Then
                        playsoundex(stepsfx(getstepsound(arg0\Field3), $00, rand($00, $07)), camera, arg0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                    EndIf
                EndIf
                If (local1 > ((hidedistance * 1.5) * (hidedistance * 1.5))) Then
                    If (1050.0 > arg0\Field27) Then
                        arg0\Field27 = (arg0\Field27 + fps\Field7[$00])
                    ElseIf (rand(($96 - (selecteddifficulty\Field2 * $3C)), $01) = $01) Then
                        If (playerinreachableroom($00, $00) <> 0) Then
                            teleportcloser(arg0)
                            arg0\Field27 = 0.0
                        EndIf
                    EndIf
                Else
                    arg0\Field27 = 0.0
                EndIf
                If (0.0 >= arg0\Field66) Then
                    If (arg0\Field34 = Null) Then
                        If (npcseesplayer(arg0, ((8.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                            arg0\Field11 = 140.0
                            arg0\Field10 = 2.0
                            arg0\Field66 = 0.0
                            Return $00
                        EndIf
                    EndIf
                    For local7 = Each npcs
                        If (((local7\Field4 = $15) And (local7\Field50 = $00)) <> 0) Then
                            If (npcseesnpc(local7, arg0, 36.0) = $01) Then
                                arg0\Field34 = local7
                                arg0\Field11 = 140.0
                                arg0\Field10 = 2.0
                                arg0\Field66 = 0.0
                                Return $00
                                Exit
                            EndIf
                        EndIf
                    Next
                    arg0\Field66 = (fps\Field7[$00] * 45.0)
                Else
                    arg0\Field66 = (arg0\Field66 - fps\Field7[$00])
                EndIf
            Case 4.0
                arg0\Field24 = 0.0
                If (arg0\Field34 = Null) Then
                    pointentity(arg0\Field3, me\Field60, 0.0)
                Else
                    pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                EndIf
                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                animatenpc(arg0, 126.0, 165.0, 0.6, $00)
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                If (((146.0 <= arg0\Field14) And (146.0 > local0)) <> 0) Then
                    If (arg0\Field34 = Null) Then
                        If (0.5625 > entitydistancesquared(arg0\Field3, me\Field60)) Then
                            playsoundex(snd_i\Field51[rand($05, $08)], camera, arg0\Field3, 10.0, 1.0, $00, $00)
                            injureplayer((rnd(0.4, 0.7) * difficultydmgmult), 1.0, 0.0, (0.225 * difficultydmgmult), (0.0875 * difficultydmgmult))
                            If (arg0\Field85 <> 0) Then
                                me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.5)
                            EndIf
                            If (3.0 < mp_getnpctargetinjuries(arg0)) Then
                                msg\Field2 = format(getlocalstring("death", "008"), subjectname, "%s")
                                kill($01, $01, $00, $01)
                            EndIf
                        Else
                            playsoundex(snd_i\Field48, camera, arg0\Field3, 2.5, 1.0, $00, $00)
                        EndIf
                    ElseIf (0.5625 > entitydistancesquared(arg0\Field3, arg0\Field34\Field3)) Then
                        playsoundex(snd_i\Field51[rand($05, $08)], camera, arg0\Field34\Field0, 10.0, 1.0, $00, $00)
                        If (arg0\Field34\Field60 > $00) Then
                            arg0\Field34\Field60 = (Int max(((Float arg0\Field34\Field60) - rnd(10.0, 20.0)), 0.0))
                        Else
                            arg0\Field34 = Null
                            arg0\Field10 = 3.0
                            Return $00
                        EndIf
                    Else
                        playsoundex(snd_i\Field48, camera, arg0\Field3, 2.5, 1.0, $00, $00)
                    EndIf
                ElseIf (164.0 <= arg0\Field14) Then
                    arg0\Field10 = 2.0
                EndIf
                If (arg0\Field34 <> Null) Then
                    If (arg0\Field34\Field50 <> 0) Then
                        arg0\Field34 = Null
                        arg0\Field10 = 3.0
                    EndIf
                EndIf
        End Select
        If (((1.0 < arg0\Field10) And (5.0 > arg0\Field10)) <> 0) Then
            arg0\Field18 = loopsoundex(npcsound[$03], arg0\Field18, camera, arg0\Field3, 10.0, 1.0, $01)
        EndIf
        If (arg0\Field60 <= $00) Then
            arg0\Field50 = $01
        EndIf
    Else
        animatenpc(arg0, 344.0, 363.0, 0.5, $00)
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $01), (entityy(arg0\Field3, $01) - 0.2), entityz(arg0\Field3, $01), $01)
    rotateentity(arg0\Field0, 0.0, (arg0\Field15 - 180.0), 0.0, $01)
    Return $00
End Function
