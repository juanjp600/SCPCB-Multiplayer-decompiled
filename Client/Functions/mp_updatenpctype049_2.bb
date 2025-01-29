Function mp_updatenpctype049_2%(arg0.npcs)
    Local local0#
    Local local1#
    Local local3.npcs
    Local local4%
    If (arg0\Field50 = $00) Then
        local0 = arg0\Field14
        updatenpcblinking(arg0)
        Select arg0\Field10
            Case 0.0
                arg0\Field18 = loopsoundex(npcsound[$07], arg0\Field18, camera, arg0\Field3, 4.0, 1.0, $01)
                If (rand($7D0, $01) = $01) Then
                    If ((9.0 - ((Float me\Field39) * 4.5)) > entitydistancesquared(arg0\Field3, me\Field60)) Then
                        arg0\Field10 = 1.0
                    EndIf
                EndIf
            Case 1.0
                animatenpc(arg0, 1.0, 556.0, 1.0, $00)
                If ((((288.0 > local0) And (288.0 <= arg0\Field14)) Lor ((350.0 > local0) And (350.0 <= arg0\Field14))) <> 0) Then
                    playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                EndIf
                If (555.9 <= arg0\Field14) Then
                    arg0\Field10 = 2.0
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
                        If (npcseesnpc(arg0\Field34, arg0, 36.0) <> 0) Then
                            arg0\Field11 = 140.0
                        EndIf
                        If (entityvisible(arg0\Field3, arg0\Field34\Field3) <> 0) Then
                            pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                        EndIf
                        local1 = entitydistancesquared(arg0\Field3, arg0\Field34\Field3)
                    EndIf
                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                    animatenpc(arg0, clamp(animtime(arg0\Field0), 705.0, 714.0), 794.0, (arg0\Field24 * 38.0), $01)
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    If (0.49 > local1) Then
                        setnpcframe(arg0, 795.0, $01)
                        arg0\Field10 = 4.0
                    EndIf
                    arg0\Field41 = 0.0
                    arg0\Field40 = $00
                    arg0\Field42 = $00
                    If ((((733.0 > local0) And (733.0 <= arg0\Field14)) Lor ((773.0 > local0) And (773.0 <= arg0\Field14))) <> 0) Then
                        playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                    EndIf
                Else
                    arg0\Field34 = Null
                    arg0\Field10 = 3.0
                EndIf
            Case 3.0
                If (0.0 >= arg0\Field41) Then
                    arg0\Field40 = findpath(arg0, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.1), entityz(me\Field60, $00))
                    If (arg0\Field40 = $01) Then
                        While (arg0\Field39[arg0\Field42] = Null)
                            If (arg0\Field42 > $14) Then
                                arg0\Field42 = $00
                                arg0\Field40 = $01
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
                    If (chs\Field2 = $00) Then
                        If (((0.49 > entitydistancesquared(arg0\Field3, me\Field60)) And entityvisible(me\Field60, arg0\Field3)) <> 0) Then
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
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
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
                    If (713.0 < arg0\Field14) Then
                        animatenpc(arg0, 795.0, 813.0, 0.7, $00)
                        If (812.9 < arg0\Field14) Then
                            setnpcframe(arg0, 557.0, $01)
                        EndIf
                    Else
                        animatenpc(arg0, 557.0, 704.0, 0.2, $01)
                    EndIf
                Else
                    animatenpc(arg0, clamp(animtime(arg0\Field0), 705.0, 714.0), 794.0, (arg0\Field24 * 38.0), $01)
                    If ((((733.0 > local0) And (733.0 <= arg0\Field14)) Lor ((773.0 > local0) And (773.0 <= arg0\Field14))) <> 0) Then
                        playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.3, 0.5), $00, $00)
                    EndIf
                EndIf
                If (local1 > ((hidedistance * 2.0) * (hidedistance * 2.0))) Then
                    If (1050.0 > arg0\Field27) Then
                        arg0\Field27 = (arg0\Field27 + fps\Field7[$00])
                    ElseIf (rand(($12C - (selecteddifficulty\Field2 * $78)), $01) = $01) Then
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
                    For local3 = Each npcs
                        If (((local3\Field4 = $15) And (local3\Field50 = $00)) <> 0) Then
                            If (npcseesnpc(local3, arg0, 36.0) = $01) Then
                                arg0\Field34 = local3
                                arg0\Field11 = 140.0
                                arg0\Field10 = 2.0
                                arg0\Field66 = 0.0
                                Return $00
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
                If (813.0 >= arg0\Field14) Then
                    animatenpc(arg0, 795.0, 813.0, 0.8, $00)
                    If (812.9 < arg0\Field14) Then
                        If (rand($02, $01) = $01) Then
                            setnpcframe(arg0, 814.0, $01)
                        Else
                            setnpcframe(arg0, 879.0, $01)
                        EndIf
                    EndIf
                Else
                    local4 = $00
                    If (879.0 > arg0\Field14) Then
                        animatenpc(arg0, 814.0, 878.0, 0.5, $00)
                        local4 = ((839.0 <= arg0\Field14) And (839.0 > local0))
                        If (877.9 < arg0\Field14) Then
                            setnpcframe(arg0, 705.0, $01)
                            arg0\Field10 = 2.0
                        EndIf
                    Else
                        animatenpc(arg0, 879.0, 943.0, 0.5, $00)
                        local4 = ((900.0 <= arg0\Field14) And (900.0 > local0))
                        If (942.9 < arg0\Field14) Then
                            setnpcframe(arg0, 705.0, $01)
                            arg0\Field10 = 2.0
                        EndIf
                    EndIf
                    If (local4 <> 0) Then
                        If (arg0\Field34 = Null) Then
                            If (0.5625 > entitydistancesquared(arg0\Field3, me\Field60)) Then
                                playsoundex(snd_i\Field51[rand($05, $08)], camera, arg0\Field3, 8.0, 1.0, $00, $00)
                                injureplayer((rnd(0.55, 0.85) * difficultydmgmult), 0.0, 0.0, (0.3 * difficultydmgmult), (0.125 * difficultydmgmult))
                                If (arg0\Field85 <> 0) Then
                                    me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.5)
                                EndIf
                                If (3.0 < mp_getnpctargetinjuries(arg0)) Then
                                    msg\Field2 = format(getlocalstring("death", "0492killed"), subjectname, "%s")
                                    kill($01, $01, $00, $01)
                                EndIf
                            Else
                                playsoundex(snd_i\Field48, camera, arg0\Field3, 2.5, 1.0, $00, $00)
                            EndIf
                        ElseIf (0.5625 > entitydistancesquared(arg0\Field3, arg0\Field34\Field3)) Then
                            playsoundex(snd_i\Field51[rand($05, $08)], camera, arg0\Field34\Field0, 10.0, 1.0, $00, $00)
                            If (arg0\Field34\Field60 > $00) Then
                                arg0\Field34\Field60 = (Int max(((Float arg0\Field34\Field60) - rnd(30.0, 50.0)), 0.0))
                            Else
                                arg0\Field34 = Null
                                arg0\Field10 = 3.0
                                Return $00
                            EndIf
                        Else
                            playsoundex(snd_i\Field48, camera, arg0\Field3, 2.5, 1.0, $00, $00)
                        EndIf
                    EndIf
                EndIf
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                If (arg0\Field34 <> Null) Then
                    If (arg0\Field34\Field50 <> 0) Then
                        arg0\Field10 = 3.0
                        arg0\Field34 = Null
                    EndIf
                EndIf
        End Select
        If (1.0 < arg0\Field10) Then
            arg0\Field18 = loopsoundex(npcsound[$06], arg0\Field18, camera, arg0\Field3, 10.0, 1.0, $01)
        EndIf
        If (arg0\Field60 <= $00) Then
            arg0\Field50 = $01
        EndIf
    Else
        animatenpc(arg0, 944.0, 982.0, 0.2, $00)
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $01), (entityy(arg0\Field3, $01) - 0.2), entityz(arg0\Field3, $01), $01)
    rotateentity(arg0\Field0, -89.9, arg0\Field15, 0.0, $01)
    Return $00
End Function
