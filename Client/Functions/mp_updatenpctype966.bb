Function mp_updatenpctype966%(arg0.npcs)
    Local local0#
    Local local1#
    Local local5#
    Local local6%
    If (-1.0 < arg0\Field10) Then
        local0 = entitydistancesquared(arg0\Field3, me\Field60)
        If ((hidedistance * hidedistance) > local0) Then
            updatenpcblinking(arg0)
            local1 = arg0\Field14
            If (wi\Field5 = $00) Then
                If (entityhidden(arg0\Field0) = $00) Then
                    hideentity(arg0\Field0)
                EndIf
                If ((chs\Field2 Lor i_268\Field2) = $00) Then
                    If (((arg0\Field85 And (1.0 > local0)) And (0.0 >= arg0\Field28)) <> 0) Then
                        Select rand($06, $01)
                            Case $01
                                createmsg(getlocalstring("msg", "966_1"), 6.0)
                            Case $02
                                createmsg(getlocalstring("msg", "966_2"), 6.0)
                            Case $03
                                createmsg(getlocalstring("msg", "966_3"), 6.0)
                            Case $04
                                createmsg(getlocalstring("msg", "966_4"), 6.0)
                            Case $05
                                createmsg(getlocalstring("msg", "966_5"), 6.0)
                            Case $06
                                createmsg(getlocalstring("msg", "966_6"), 6.0)
                        End Select
                        arg0\Field28 = 1680.0
                    EndIf
                EndIf
            Else
                If (entityvisible(arg0\Field3, me\Field60) <> 0) Then
                    giveachievement("966", $01)
                EndIf
                If (entityhidden(arg0\Field0) <> 0) Then
                    showentity(arg0\Field0)
                EndIf
            EndIf
            arg0\Field28 = (arg0\Field28 - fps\Field7[$00])
            If (350.0 <= arg0\Field12) Then
                arg0\Field10 = max(arg0\Field10, 8.0)
            EndIf
            If (10.0 > me\Field17) Then
                arg0\Field12 = (arg0\Field12 + fps\Field7[$00])
            ElseIf (350.0 > arg0\Field12) Then
                arg0\Field12 = max((arg0\Field12 - (fps\Field7[$00] * 0.2)), 0.0)
            EndIf
            Select arg0\Field10
                Case 0.0
                    If (557.0 < arg0\Field14) Then
                        animatenpc(arg0, 628.0, 652.0, 0.25, $00)
                        If (651.9 < arg0\Field14) Then
                            setnpcframe(arg0, 2.0, $01)
                        EndIf
                    Else
                        animatenpc(arg0, 2.0, 214.0, 0.25, $00)
                        If (213.9 < arg0\Field14) Then
                            If (((rand($03, $01) = $01) And (12.0 > local0)) <> 0) Then
                                arg0\Field10 = (Float rand($01, $04))
                            Else
                                arg0\Field10 = (Float rand($05, $06))
                            EndIf
                        EndIf
                        If (npcseesplayer(arg0, ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                            arg0\Field10 = (Float rand($04, $01))
                        EndIf
                    EndIf
                Case 1.0,2.0
                    animatenpc(arg0, 214.0, 257.0, 0.25, $00)
                    If (256.9 < arg0\Field14) Then
                        arg0\Field10 = 0.0
                    EndIf
                    If (npcseesplayer(arg0, ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                        pointentity(arg0\Field3, me\Field60, 0.0)
                        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                        If (350.0 > arg0\Field12) Then
                            If (arg0\Field85 <> 0) Then
                                me\Field49 = (((sin(((Float millisec) / 50.0)) + 1.0) * 200.0) / sqr(local0))
                                If ((((i_714\Field0 <> $02) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
                                    If (0.0 = i_966\Field1) Then
                                        Select rand($04, $01)
                                            Case $01
                                                createmsg(getlocalstring("msg", "966.sleep_1"), 6.0)
                                            Case $02
                                                createmsg(getlocalstring("msg", "966.sleep_2"), 6.0)
                                            Case $03
                                                createmsg(getlocalstring("msg", "966.sleep_3"), 6.0)
                                            Case $04
                                                createmsg(getlocalstring("msg", "966.sleep_4"), 6.0)
                                        End Select
                                    EndIf
                                    i_966\Field1 = (1.0 - ((Float i_714\Field0) * 0.5))
                                    local5 = ((((Float selecteddifficulty\Field4) * 700.0) + 2100.0) / ((Float i_714\Field0) + 1.0))
                                    i_966\Field0 = clamp(((fps\Field7[$00] * (6.0 - ((Float i_714\Field0) * 2.5))) + i_966\Field0), local5, (local5 * 2.0))
                                EndIf
                            EndIf
                        EndIf
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    EndIf
                    If (((228.0 < arg0\Field14) And (228.0 >= local1)) <> 0) Then
                        If (channelplaying(arg0\Field18) = $00) Then
                            arg0\Field18 = playsoundex(loadtempsound((("SFX\SCP\966\Echo" + (Str rand($00, $02))) + ".ogg")), camera, arg0\Field3, 10.0, 1.0, $01, $00)
                        EndIf
                    EndIf
                    updatesoundorigin(arg0\Field18, camera, arg0\Field3, 10.0, 1.0, $01, $01)
                Case 3.0,4.0
                    If (3.0 = arg0\Field10) Then
                        animatenpc(arg0, 258.0, 332.0, 0.25, $00)
                        If (331.9 < arg0\Field14) Then
                            arg0\Field10 = 0.0
                        EndIf
                    Else
                        animatenpc(arg0, 333.0, 457.0, 0.25, $00)
                        If (456.9 < arg0\Field14) Then
                            arg0\Field10 = 0.0
                        EndIf
                    EndIf
                    If (npcseesplayer(arg0, ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                        pointentity(arg0\Field3, me\Field60, 0.0)
                        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    EndIf
                    If (((((271.0 < arg0\Field14) And (271.0 >= local1)) Lor ((301.0 < arg0\Field14) And (301.0 >= local1))) Lor ((314.0 < arg0\Field14) And (314.0 >= local1))) <> 0) Then
                        If (channelplaying(arg0\Field18) = $00) Then
                            arg0\Field18 = playsoundex(loadtempsound((("SFX\SCP\966\Idle" + (Str rand($00, $02))) + ".ogg")), camera, arg0\Field3, 10.0, 1.0, $01, $00)
                        EndIf
                    EndIf
                    updatesoundorigin(arg0\Field18, camera, arg0\Field3, 10.0, 1.0, $01, $01)
                Case 5.0,6.0,8.0
                    If (8.0 = arg0\Field10) Then
                        If (npcseesplayer(arg0, ((6.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                            pointentity(arg0\Field3, me\Field60, 0.0)
                            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field42 = $00
                            If (0.7225 > local0) Then
                                arg0\Field10 = 9.0
                            EndIf
                        ElseIf (0.0 >= arg0\Field41) Then
                            arg0\Field40 = findpath(arg0, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.1), entityz(me\Field60, $00))
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
                            arg0\Field41 = 700.0
                        Else
                            If (((0.81 > local0) And (chs\Field2 = $00)) <> 0) Then
                                If (entityvisible(arg0\Field3, me\Field60) <> 0) Then
                                    arg0\Field10 = 9.0
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
                                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                                    usedoornpc(arg0, $01, $00)
                                EndIf
                                arg0\Field41 = max((arg0\Field41 - fps\Field7[$00]), 0.0)
                            Else
                                arg0\Field24 = curvevalue(0.0, arg0\Field24, 10.0)
                                arg0\Field41 = max((arg0\Field41 - (fps\Field7[$00] * 2.0)), 0.0)
                            EndIf
                        EndIf
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    Else
                        local6 = $00
                        If ((Float millisecs()) > arg0\Field11) Then
                            hideentity(arg0\Field3)
                            entitypick(arg0\Field3, 1.5)
                            If (pickedentity() <> $00) Then
                                local6 = $01
                            EndIf
                            showentity(arg0\Field3)
                            arg0\Field11 = (Float (millisecs() + $3E8))
                            If (rand($05, $01) = $01) Then
                                arg0\Field10 = 0.0
                            EndIf
                        EndIf
                        rotateentity(arg0\Field3, 0.0, (entityyaw(arg0\Field3, $01) + (rnd(80.0, 110.0) * (Float local6))), 0.0, $01)
                        arg0\Field24 = curvevalue((arg0\Field23 * 0.6), arg0\Field24, 10.0)
                        moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    EndIf
                    If (0.005 > arg0\Field24) Then
                        If (557.0 < arg0\Field14) Then
                            animatenpc(arg0, 628.0, 652.0, 0.25, $00)
                            If (651.9 < arg0\Field14) Then
                                setnpcframe(arg0, 2.0, $01)
                            EndIf
                        Else
                            animatenpc(arg0, 2.0, 214.0, 0.25, $01)
                        EndIf
                        If (((650.0 > local1) And (650.0 <= arg0\Field14)) <> 0) Then
                            playsoundex(snd_i\Field56[rand($03, $06)], camera, arg0\Field3, 7.0, rnd(0.5, 0.7), $00, $00)
                        EndIf
                    Else
                        animatenpc(arg0, clamp(animtime(arg0\Field0), 557.0, 580.0), 628.0, (arg0\Field24 * 25.0), $01)
                        If ((((581.0 > local1) And (581.0 <= arg0\Field14)) Lor ((607.0 > local1) And (607.0 <= arg0\Field14))) <> 0) Then
                            playsoundex(snd_i\Field56[rand($03, $06)], camera, arg0\Field3, 7.0, rnd(0.5, 0.7), $00, $00)
                        EndIf
                    EndIf
                Case 9.0
                    arg0\Field24 = 0.0
                    pointentity(arg0\Field3, me\Field60, 0.0)
                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    If (arg0\Field29 = $00) Then
                        arg0\Field18 = playsoundex(loadtempsound((("SFX\SCP\966\Echo" + (Str rand($00, $02))) + ".ogg")), camera, arg0\Field3, 10.0, 1.0, $01, $00)
                        arg0\Field29 = $01
                    EndIf
                    If (557.0 < arg0\Field14) Then
                        animatenpc(arg0, 629.0, 652.0, 0.25, $00)
                        If (((650.0 > local1) And (650.0 <= arg0\Field14)) <> 0) Then
                            playsoundex(snd_i\Field56[rand($03, $06)], camera, arg0\Field3, 7.0, rnd(0.5, 0.7), $00, $00)
                        EndIf
                        If (651.9 < arg0\Field14) Then
                            Select rand($03, $01)
                                Case $01
                                    setnpcframe(arg0, 458.0, $01)
                                Case $02
                                    setnpcframe(arg0, 488.0, $01)
                                Case $03
                                    setnpcframe(arg0, 518.0, $01)
                            End Select
                        EndIf
                    ElseIf (487.0 >= arg0\Field14) Then
                        animatenpc(arg0, 458.0, 487.0, 0.3, $00)
                        If (486.9 < arg0\Field14) Then
                            arg0\Field29 = $00
                            arg0\Field10 = 8.0
                        EndIf
                    ElseIf (517.0 >= arg0\Field14) Then
                        animatenpc(arg0, 488.0, 517.0, 0.3, $00)
                        If (516.9 < arg0\Field14) Then
                            arg0\Field29 = $00
                            arg0\Field10 = 8.0
                        EndIf
                    ElseIf (556.0 >= arg0\Field14) Then
                        animatenpc(arg0, 518.0, 556.0, 0.3, $00)
                        If (555.9 < arg0\Field14) Then
                            arg0\Field29 = $00
                            arg0\Field10 = 8.0
                        EndIf
                    EndIf
                    If (((((470.0 < arg0\Field14) And (470.0 >= local1)) Lor ((500.0 < arg0\Field14) And (500.0 >= local1))) Lor ((527.0 < arg0\Field14) And (527.0 >= local1))) <> 0) Then
                        If (0.81 > local0) Then
                            If (arg0\Field85 <> 0) Then
                                playsound_strict(snd_i\Field51[rand($0B, $0C)], $00)
                                injureplayer((rnd(0.45, 0.75) * difficultydmgmult), 0.0, 500.0, (0.25 * difficultydmgmult), (0.1 * difficultydmgmult))
                                me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 1.8)
                                If (10.0 < mp_getnpctargetinjuries(arg0)) Then
                                    msg\Field2 = format(getlocalstring("death", "966"), subjectname, "%s")
                                    kill($01, $01, $00, $01)
                                EndIf
                            Else
                                playsoundex(snd_i\Field51[rand($0B, $0C)], camera, arg0\Field3, 10.0, 1.0, $00, $00)
                            EndIf
                        Else
                            playsoundex(snd_i\Field48, camera, arg0\Field3, 2.5, 1.0, $00, $00)
                        EndIf
                    EndIf
            End Select
            positionentity(arg0\Field0, entityx(arg0\Field3, $01), (entityy(arg0\Field3, $01) - 0.2), entityz(arg0\Field3, $01), $01)
            rotateentity(arg0\Field0, -89.9, arg0\Field15, 0.0, $01)
        Else
            If (entityhidden(arg0\Field0) = $00) Then
                hideentity(arg0\Field0)
            EndIf
            If (rand(($352 - (selecteddifficulty\Field2 * $FA)), $01) = $01) Then
                teleportcloser(arg0)
                arg0\Field12 = 0.0
                arg0\Field10 = 0.0
            EndIf
        EndIf
        If (playerroom\Field7\Field6 = $69) Then
            arg0\Field12 = 0.0
            arg0\Field10 = 0.0
        EndIf
    EndIf
    Return $00
End Function
