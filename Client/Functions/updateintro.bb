Function updateintro%()
    Local local0.events
    Local local1.rooms
    Local local2.doors
    Local local3.props
    Local local4.securitycams
    Local local5.lights
    Local local6.soundemitters
    Local local7.waypoints
    Local local8%
    Local local9%
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16%
    Local local17$
    local17 = ""
    For local0 = Each events
        If (local0\Field0 = $04) Then
            If (playerroom = local0\Field1) Then
                lightrenderdistance = 64.0
                If (0.0 = local0\Field2) Then
                    For local8 = $00 To $01 Step $01
                        snd_i\Field49[local8] = loadsound_strict((("SFX\Room\Intro\Ew" + (Str local8)) + ".ogg"))
                    Next
                    snd_i\Field49[$02] = loadsound_strict("SFX\Room\Intro\Horror.ogg")
                    snd_i\Field49[$03] = loadsound_strict("SFX\Room\Intro\See173.ogg")
                    For local8 = $00 To $02 Step $01
                        snd_i\Field49[(local8 + $04)] = loadsound_strict((("SFX\Room\Intro\Bang" + (Str local8)) + ".ogg"))
                    Next
                    hidedistance = 68.0
                    n_i\Field2\Field15 = 90.0
                    n_i\Field2\Field26 = 1.0
                    positionentity(n_i\Field2\Field3, entityx(local0\Field1\Field11[$02], $01), entityy(local0\Field1\Field11[$02], $01), entityz(local0\Field1\Field11[$02], $01), $00)
                    rotateentity(n_i\Field2\Field3, 0.0, 0.0, 0.0, $01)
                    resetentity(n_i\Field2\Field3)
                    hideentity(n_i\Field2\Field0)
                    hideentity(n_i\Field2\Field1)
                    tformpoint(328.0, 480.0, 1072.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$00] = createnpc($14, tformedx(), tformedy(), tformedz())
                    local0\Field1\Field15[$00]\Field15 = 180.0
                    hideentity(local0\Field1\Field15[$00]\Field0)
                    tformpoint(208.0, 200.0, 480.0, local0\Field1\Field2, $00)
                    local12 = tformedy()
                    local0\Field1\Field15[$01] = createnpc($13, tformedx(), local12, tformedz())
                    local0\Field1\Field15[$01]\Field12 = 3.0
                    pointentity(local0\Field1\Field15[$01]\Field3, local0\Field1\Field11[$02], 0.0)
                    hideentity(local0\Field1\Field15[$01]\Field0)
                    tformpoint(160.0, 0.0, 320.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$02] = createnpc($13, tformedx(), local12, tformedz())
                    local0\Field1\Field15[$02]\Field12 = 5.0
                    pointentity(local0\Field1\Field15[$02]\Field3, local0\Field1\Field11[$02], 0.0)
                    changenpctextureid(local0\Field1\Field15[$02], $05)
                    hideentity(local0\Field1\Field15[$02]\Field0)
                    tformpoint(-4205.0, 0.0, 870.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$03] = createnpc($14, tformedx(), local12, tformedz())
                    local0\Field1\Field15[$03]\Field10 = 7.0
                    local9 = rand($00, $04)
                    local0\Field1\Field15[$03]\Field19 = loadsound_strict((("SFX\Room\Intro\Guard\Conversation" + (Str local9)) + "a.ogg"))
                    rotateentity(local0\Field1\Field15[$03]\Field3, 0.0, ((Float local0\Field1\Field6) + 180.0), 0.0, $00)
                    hideentity(local0\Field1\Field15[$03]\Field0)
                    tformpoint(-3985.0, 0.0, 786.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$04] = createnpc($14, tformedx(), local12, tformedz())
                    local0\Field1\Field15[$04]\Field10 = 7.0
                    local0\Field1\Field15[$04]\Field19 = loadsound_strict((("SFX\Room\Intro\Guard\Conversation" + (Str local9)) + "b.ogg"))
                    rotateentity(local0\Field1\Field15[$04]\Field3, 0.0, ((Float local0\Field1\Field6) + 135.0), 0.0, $00)
                    hideentity(local0\Field1\Field15[$04]\Field0)
                    tformpoint(-8064.0, 0.0, 1096.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$05] = createnpc($14, tformedx(), local12, tformedz())
                    local0\Field1\Field15[$05]\Field10 = 7.0
                    local0\Field1\Field15[$05]\Field19 = loadsound_strict((("SFX\Room\Intro\Guard\Music" + (Str rand($00, $04))) + ".ogg"))
                    rotateentity(local0\Field1\Field15[$05]\Field3, 0.0, ((Float local0\Field1\Field6) + 180.0), 0.0, $01)
                    hideentity(local0\Field1\Field15[$05]\Field0)
                    tformpoint(-3424.0, -100.0, -2208.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$06] = createnpc($13, tformedx(), tformedy(), tformedz())
                    changenpctextureid(local0\Field1\Field15[$06], $03)
                    hideentity(local0\Field1\Field15[$06]\Field0)
                    tformpoint(-3073.0, -315.0, -2165.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$07] = createnpc($13, tformedx(), tformedy(), tformedz())
                    local0\Field1\Field15[$07]\Field10 = -1.0
                    local0\Field1\Field15[$07]\Field17 = loadsound_strict("SFX\Room\Intro\Scientist\Conversation.ogg")
                    setnpcframe(local0\Field1\Field15[$07], 182.0, $01)
                    changenpctextureid(local0\Field1\Field15[$07], $02)
                    hideentity(local0\Field1\Field15[$07]\Field0)
                    tformpoint(-3800.0, 250.0, -4088.0, local0\Field1\Field2, $00)
                    local12 = tformedy()
                    local13 = tformedz()
                    local0\Field1\Field15[$08] = createnpc($14, tformedx(), local12, local13)
                    local0\Field1\Field15[$08]\Field10 = 7.0
                    hideentity(local0\Field1\Field15[$08]\Field0)
                    tformpoint(-4200.0, 0.0, 0.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$09] = createnpc($14, tformedx(), local12, local13)
                    local0\Field1\Field15[$09]\Field10 = 7.0
                    hideentity(local0\Field1\Field15[$09]\Field0)
                    tformpoint(-4000.0, 0.0, 0.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$0A] = createnpc($13, tformedx(), local12, local13)
                    local0\Field1\Field15[$0A]\Field11 = 1.0
                    changenpctextureid(local0\Field1\Field15[$0A], $06)
                    hideentity(local0\Field1\Field15[$0A]\Field0)
                    tformpoint(-7208.0, -600.0, -3104.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$0B] = createnpc($14, tformedx(), tformedy(), tformedz())
                    local0\Field1\Field15[$0B]\Field10 = 15.0
                    createnpcasset(local0\Field1\Field15[$0B])
                    hideentity(local0\Field1\Field15[$0B]\Field0)
                    hideentity(local0\Field1\Field15[$0B]\Field1)
                    tformpoint(-5675.0, -1020.0, -3717.0, local0\Field1\Field2, $00)
                    local0\Field1\Field15[$0C] = createnpc($13, tformedx(), tformedy(), tformedz())
                    local0\Field1\Field15[$0C]\Field10 = -1.0
                    rotateentity(local0\Field1\Field15[$0C]\Field3, 0.0, 154.0, 0.0, $00)
                    setnpcframe(local0\Field1\Field15[$0C], 357.0, $01)
                    changenpctextureid(local0\Field1\Field15[$0C], $09)
                    hideentity(local0\Field1\Field15[$0C]\Field0)
                    For local8 = $08 To $0B Step $01
                        If (local8 < $0B) Then
                            rotateentity(local0\Field1\Field15[local8]\Field3, 0.0, 90.0, 0.0, $00)
                        Else
                            rotateentity(local0\Field1\Field15[local8]\Field3, 0.0, -90.0, 0.0, $00)
                        EndIf
                    Next
                    local11 = (local0\Field1\Field3 - 16.59375)
                    local12 = (local0\Field1\Field4 + 0.53125)
                    local13 = (local0\Field1\Field5 + (1.0 / 32.0))
                    positionentity(camera, local11, local12, local13, $00)
                    hideentity(me\Field60)
                    positionentity(me\Field60, local11, (local0\Field1\Field4 + 0.302), local13, $00)
                    rotateentity(camera, -70.0, 0.0, 0.0, $00)
                    playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                    me\Field49 = 1600.0
                    me\Field51 = 1.0
                    makemeunplayable()
                    createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(getlocalstring("misc", "warning2"), $FF, $00, $00, $00)
                    createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    local0\Field2 = 1.0
                Else
                    For local1 = Each rooms
                        hideroomsnocoll(local1)
                    Next
                    showroomsnocoll(local0\Field1)
                    cansave = $01
                    If (6.0 > local0\Field2) Then
                        shouldplay = $0D
                    Else
                        shouldplay = $00
                    EndIf
                    Select local0\Field2
                        Case 1.0
                            lightrenderdistance = 16.0
                            local10 = (fps\Field7[$00] / 30.0)
                            If (3.0 > local0\Field3) Then
                                local10 = (local10 / 1.8)
                                local0\Field3 = (local0\Field3 + local10)
                            ElseIf (((9.0 < local0\Field3) And (11.0 > local0\Field3)) <> 0) Then
                                local10 = (local10 / 1.8)
                                local0\Field3 = (local0\Field3 + local10)
                            ElseIf (((15.0 > local0\Field3) Lor (50.0 <= local0\Field3)) <> 0) Then
                                local0\Field3 = min((local0\Field3 + local10), 150.0)
                            EndIf
                            If (15.0 > local0\Field3) Then
                                local11 = (local0\Field1\Field3 - 16.59375)
                                local12 = (local0\Field1\Field4 + 0.53125)
                                local13 = (local0\Field1\Field5 - 0.234375)
                                If (14.0 > local0\Field3) Then
                                    stopmousemovement()
                                    If (((1.0 > (local0\Field3 - local10)) And (1.0 <= local0\Field3)) <> 0) Then
                                        me\Field10 = -10.0
                                    ElseIf (((1.3 > (local0\Field3 - local10)) And (1.3 <= local0\Field3)) <> 0) Then
                                        me\Field10 = -10.0
                                    ElseIf (((2.8 > (local0\Field3 - local10)) And (2.8 <= local0\Field3)) <> 0) Then
                                        playsound_strict(snd_i\Field49[$00], $01)
                                    ElseIf (((10.8 > (local0\Field3 - local10)) And (10.8 <= local0\Field3)) <> 0) Then
                                        playsound_strict(snd_i\Field49[$01], $01)
                                    ElseIf (((13.0 > (local0\Field3 - local10)) And (13.0 <= local0\Field3)) <> 0) Then
                                        playsoundex(stepsfx($00, $00, $00), camera, me\Field60, 8.0, 0.5, $00, $00)
                                    EndIf
                                    local14 = clamp((local0\Field3 / 5.0), 0.0, 1.0)
                                    local14 = ((3.0 - (2.0 * local14)) * (local14 * local14))
                                    local15 = max(((local0\Field3 - 10.0) / 4.0), 0.0)
                                    local15 = ((3.0 - (2.0 * local15)) * (local15 * local15))
                                    local11 = ((((local0\Field1\Field3 - 16.13281) - local11) * local15) + local11)
                                    If (10.0 > local0\Field3) Then
                                        local12 = ((0.2 * local14) + local12)
                                    Else
                                        local12 = (((((local0\Field1\Field4 + 0.302) + 0.6) - (local12 + 0.2)) * local15) + (local12 + 0.2))
                                    EndIf
                                    local13 = ((((local0\Field1\Field5 + 0.28125) - local13) * local14) + local13)
                                    rotateentity(camera, (((70.0 * local14) + -70.0) + (sin((local0\Field3 * 12.857)) * 5.0)), (-90.0 * local15), (sin((local0\Field3 * 25.7)) * 8.0), $00)
                                    positionentity(camera, local11, local12, local13, $00)
                                    If (entityhidden(me\Field60) = $00) Then
                                        hideentity(me\Field60)
                                    EndIf
                                    positionentity(me\Field60, local11, (local0\Field1\Field4 + 0.302), local13, $00)
                                    me\Field36 = 0.0
                                Else
                                    positionentity(me\Field60, entityx(me\Field60, $00), (local0\Field1\Field4 + 0.302), entityz(me\Field60, $00), $00)
                                    resetentity(me\Field60)
                                    showentity(me\Field60)
                                    me\Field36 = 0.0
                                    me\Field9 = $01
                                    For local8 = $00 To $01 Step $01
                                        freesound_strict(snd_i\Field49[local8])
                                        snd_i\Field49[local8] = $00
                                    Next
                                    local0\Field3 = 15.0
                                EndIf
                                camerapitch = 0.0
                                rotateentity(me\Field60, 0.0, entityyaw(camera, $00), 0.0, $00)
                            ElseIf (40.0 > local0\Field3) Then
                                If (inventory($00) <> Null) Then
                                    createhintmsg(format(getlocalstring("msg", "openinv"), key\Field0[key\Field6], "%s"), 6.0, $00)
                                    local0\Field3 = 40.0
                                Else
                                    createhintmsg(getlocalstring("msg", "paper"), 6.0, $00)
                                EndIf
                            ElseIf (50.0 > local0\Field3) Then
                                If (invopen <> 0) Then
                                    createhintmsg(getlocalstring("msg", "doc.click"), 6.0, $00)
                                Else
                                    createhintmsg(format(getlocalstring("msg", "openinv"), key\Field0[key\Field6], "%s"), 6.0, $00)
                                EndIf
                                If (((selecteditem <> Null) And (selecteditem\Field4\Field11 <> $00)) <> 0) Then
                                    createhintmsg(getlocalstring("msg", "doc.read"), 8.0, $00)
                                    local0\Field3 = 50.0
                                EndIf
                            Else
                                If (selecteditem <> Null) Then
                                    local0\Field3 = (local0\Field3 + (fps\Field7[$00] / 6.0))
                                EndIf
                                If (150.0 <= local0\Field3) Then
                                    local0\Field1\Field15[$03]\Field17 = loadsound_strict("SFX\Room\Intro\Guard\Ulgrin\BeforeDoorOpen.ogg")
                                    local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                    local0\Field2 = 2.0
                                EndIf
                            EndIf
                        Case 2.0
                            lightrenderdistance = 16.0
                            If (channelplaying(local0\Field1\Field15[$03]\Field18) = $00) Then
                                loadnpcsound(local0\Field1\Field15[$03], "SFX\Room\Intro\Guard\Ulgrin\ExitCell.ogg", $00)
                                local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                For local8 = $03 To $05 Step $01
                                    local0\Field1\Field15[local8]\Field10 = 9.0
                                    showentity(local0\Field1\Field15[local8]\Field0)
                                Next
                                openclosedoor(local0\Field1\Field14[$04], $01, $00)
                                local0\Field2 = 3.0
                            EndIf
                        Case 3.0
                            If (2.4025 < distancesquared(entityx(me\Field60, $00), (local0\Field1\Field3 - 16.0), entityz(me\Field60, $00), (local0\Field1\Field5 + 0.75), 0.0, 0.0)) Then
                                If (local0\Field1\Field14[$04]\Field6 <> 0) Then
                                    stopchannel(local0\Field1\Field15[$03]\Field18)
                                    local0\Field1\Field15[$03]\Field18 = $00
                                    loadnpcsound(local0\Field1\Field15[$03], (("SFX\Room\Intro\Guard\Ulgrin\Escort" + (Str rand($00, $01))) + ".ogg"), $00)
                                    local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                    openclosedoor(local0\Field1\Field14[$04], $01, $00)
                                EndIf
                                If (channelplaying(local0\Field1\Field15[$03]\Field18) = $00) Then
                                    freeentity(local0\Field1\Field11[$03])
                                    local0\Field1\Field11[$03] = $00
                                    For local8 = $06 To $0C Step $01
                                        showentity(local0\Field1\Field15[local8]\Field0)
                                    Next
                                    showentity(local0\Field1\Field15[$0B]\Field1)
                                    showentity(local0\Field1\Field11[$04])
                                    local0\Field2 = 4.0
                                EndIf
                            Else
                                lightrenderdistance = 16.0
                                local10 = (fps\Field7[$00] / 4.0)
                                local0\Field3 = min((local0\Field3 + local10), 630.0)
                                If (((300.0 > (local0\Field3 - local10)) And (300.0 <= local0\Field3)) <> 0) Then
                                    loadnpcsound(local0\Field1\Field15[$03], (("SFX\Room\Intro\Guard\Ulgrin\ExitCellRefuse" + (Str rand($00, $01))) + ".ogg"), $00)
                                    local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                ElseIf (((500.0 > (local0\Field3 - local10)) And (500.0 <= local0\Field3)) <> 0) Then
                                    loadnpcsound(local0\Field1\Field15[$03], (("SFX\Room\Intro\Guard\Ulgrin\CellGas" + (Str rand($00, $01))) + ".ogg"), $00)
                                    local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                ElseIf (630.0 <= local0\Field3) Then
                                    positionentity(me\Field60, entityx(me\Field60, $00), entityy(me\Field60, $00), min(entityz(me\Field60, $00), (local0\Field1\Field5 + 1.914062)), $00)
                                    If (local0\Field1\Field14[$04]\Field6 <> 0) Then
                                        openclosedoor(local0\Field1\Field14[$04], $01, $00)
                                    EndIf
                                    If (local0\Field1\Field17[$00] = Null) Then
                                        local0\Field1\Field17[$00] = setemitter(local0\Field1, (local0\Field1\Field3 - 16.37109), (local0\Field1\Field4 + 1.457031), (local0\Field1\Field5 + (1.0 / 1.610063)), $05)
                                        local0\Field1\Field17[$00]\Field11 = $01
                                    EndIf
                                    If (local0\Field1\Field17[$01] = Null) Then
                                        local0\Field1\Field17[$01] = setemitter(local0\Field1, (local0\Field1\Field3 - 15.625), (local0\Field1\Field4 + 1.457031), (local0\Field1\Field5 + (1.0 / 1.610063)), $05)
                                        local0\Field1\Field17[$01]\Field11 = $01
                                    EndIf
                                    me\Field14 = max((me\Field14 + (fps\Field7[$00] * 4.0)), 1.0)
                                    If (rand($3E8, $01) = $01) Then
                                        kill($00, $01, $00, $01)
                                    EndIf
                                EndIf
                            EndIf
                        Case 4.0
                            me\Field38 = min((me\Field38 - (((0.008 / entitydistance(local0\Field1\Field15[$03]\Field3, me\Field60)) * me\Field38) * fps\Field7[$00])), me\Field38)
                            local14 = distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field15[$03]\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field1\Field15[$03]\Field3, $00), 0.0, 0.0)
                            If (11.0 <> local0\Field1\Field15[$03]\Field10) Then
                                If (9.0 > local14) Then
                                    local0\Field1\Field15[$03]\Field36 = (local0\Field1\Field3 - 6.539062)
                                    local0\Field1\Field15[$03]\Field37 = (local0\Field1\Field4 + 0.3)
                                    local0\Field1\Field15[$03]\Field38 = (local0\Field1\Field5 - 3.824219)
                                    local0\Field1\Field15[$03]\Field10 = 3.0
                                ElseIf (30.25 < local14) Then
                                    If (0.0 = local0\Field1\Field15[$03]\Field11) Then
                                        For local8 = $03 To $04 Step $01
                                            stopchannel(local0\Field1\Field15[local8]\Field18)
                                            local0\Field1\Field15[local8]\Field18 = $00
                                        Next
                                        loadnpcsound(local0\Field1\Field15[$03], "SFX\Room\Intro\Guard\Ulgrin\EscortRun.ogg", $00)
                                        local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                        local0\Field1\Field15[$03]\Field11 = 1.0
                                    EndIf
                                    local0\Field1\Field15[$03]\Field36 = entityx(me\Field60, $00)
                                    local0\Field1\Field15[$03]\Field37 = entityy(me\Field60, $00)
                                    local0\Field1\Field15[$03]\Field38 = entityz(me\Field60, $00)
                                    local0\Field1\Field15[$03]\Field15 = 0.0
                                    local0\Field1\Field15[$03]\Field10 = 5.0
                                Else
                                    local0\Field1\Field15[$03]\Field24 = 0.0
                                    local0\Field1\Field15[$03]\Field10 = 9.0
                                EndIf
                                If (((2.25 < distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field15[$04]\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field1\Field15[$04]\Field3, $00), 0.0, 0.0)) And (local14 < distancesquared(entityx(local0\Field1\Field15[$03]\Field3, $00), entityx(local0\Field1\Field15[$04]\Field3, $00), entityz(local0\Field1\Field15[$03]\Field3, $00), entityz(local0\Field1\Field15[$04]\Field3, $00), 0.0, 0.0))) <> 0) Then
                                    local0\Field1\Field15[$04]\Field36 = (local0\Field1\Field3 + 1.09375)
                                    local0\Field1\Field15[$04]\Field37 = (local0\Field1\Field4 + 0.3)
                                    local0\Field1\Field15[$04]\Field38 = (local0\Field1\Field5 - 2.785156)
                                    local0\Field1\Field15[$04]\Field10 = 3.0
                                Else
                                    local0\Field1\Field15[$04]\Field36 = entityx(me\Field60, $00)
                                    local0\Field1\Field15[$04]\Field37 = entityy(me\Field60, $00)
                                    local0\Field1\Field15[$04]\Field38 = entityz(me\Field60, $00)
                                    local0\Field1\Field15[$04]\Field15 = 0.0
                                    local0\Field1\Field15[$04]\Field10 = 5.0
                                EndIf
                            EndIf
                            local0\Field1\Field15[$05]\Field20 = loopsoundex(local0\Field1\Field15[$05]\Field19, local0\Field1\Field15[$05]\Field20, camera, local0\Field1\Field15[$05]\Field0, 2.0, 0.5, $00)
                            If ((((local0\Field1\Field3 - 21.0) > entityx(me\Field60, $00)) And (local0\Field13 = "")) <> 0) Then
                                If (rand($03, $01) = $01) Then
                                    local0\Field13 = (("Scripted\Scripted" + (Str rand($00, $04))) + ".ogg|Off.ogg|")
                                Else
                                    local0\Field13 = (("1\Attention" + (Str rand($00, $01))) + ".ogg")
                                    Select rand($03, $01)
                                        Case $01
                                            local17 = "Crew"
                                            local0\Field13 = (((local0\Field13 + "|2\Crew") + (Str rand($00, $05))) + ".ogg")
                                        Case $02
                                            local17 = "Scientist"
                                            local0\Field13 = (((local0\Field13 + "|2\Scientist") + (Str rand($00, $11))) + ".ogg")
                                        Case $03
                                            local17 = "Security"
                                            local0\Field13 = (((local0\Field13 + "|2\Security") + (Str rand($00, $05))) + ".ogg")
                                    End Select
                                    If (((rand($02, $01) = $01) And (local17 = "Scientist")) <> 0) Then
                                        local0\Field13 = (local0\Field13 + "|3\CallOnLine.ogg")
                                        local0\Field13 = (((local0\Field13 + "|Numbers\") + (Str rand($09, $01))) + ".ogg")
                                        If (rand($02, $01) = $01) Then
                                            local0\Field13 = (((local0\Field13 + "|Numbers\") + (Str rand($09, $01))) + ".ogg")
                                        EndIf
                                    Else
                                        local0\Field13 = (((local0\Field13 + "|3\Report") + (Str rand($00, $01))) + ".ogg")
                                        Select local17
                                            Case "Crew"
                                                local0\Field13 = (((local0\Field13 + "|4\Crew") + (Str rand($00, $06))) + ".ogg")
                                                If (rand($02, $01) = $01) Then
                                                    local0\Field13 = (((local0\Field13 + "|5\Crew") + (Str rand($00, $06))) + ".ogg")
                                                EndIf
                                            Case "Scientist"
                                                local0\Field13 = (((local0\Field13 + "|4\Scientist") + (Str rand($00, $07))) + ".ogg")
                                                If (rand($02, $01) = $01) Then
                                                    local0\Field13 = (local0\Field13 + "|5\Scientist0.ogg")
                                                EndIf
                                            Case "Security"
                                                local0\Field13 = (((local0\Field13 + "|4\Security") + (Str rand($00, $05))) + ".ogg")
                                                If (rand($02, $01) = $01) Then
                                                    local0\Field13 = (((local0\Field13 + "|5\Security") + (Str rand($00, $02))) + ".ogg")
                                                EndIf
                                        End Select
                                    EndIf
                                    local0\Field13 = (local0\Field13 + "|Off.ogg|")
                                EndIf
                            EndIf
                            If (((local0\Field13 <> "") And (local0\Field13 <> "Done")) <> 0) Then
                                If (local0\Field6 = $00) Then
                                    local0\Field6 = playsound_strict(loadtempsound("SFX\Room\Intro\IA\On.ogg"), $01)
                                EndIf
                                If (channelplaying(local0\Field6) = $00) Then
                                    local17 = left(local0\Field13, (instr(local0\Field13, "|", $01) - $01))
                                    loadeventsound(local0, ("SFX\Room\Intro\IA\" + local17), $00)
                                    local0\Field6 = playsound_strict(local0\Field8, $01)
                                    local0\Field13 = right(local0\Field13, ((len(local0\Field13) - len(local17)) - $01))
                                    If (local0\Field13 = "") Then
                                        If (channelplaying(local0\Field1\Field15[$03]\Field18) = $00) Then
                                            For local8 = $03 To $04 Step $01
                                                local0\Field1\Field15[local8]\Field18 = playsoundex(local0\Field1\Field15[local8]\Field19, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                            Next
                                        Else
                                            For local8 = $03 To $04 Step $01
                                                freesound_strict(local0\Field1\Field15[local8]\Field19)
                                                local0\Field1\Field15[local8]\Field19 = $00
                                            Next
                                        EndIf
                                        local0\Field13 = "Done"
                                    EndIf
                                EndIf
                            EndIf
                            If (0.0 = local0\Field1\Field15[$06]\Field10) Then
                                If (local0\Field1\Field14[$05]\Field6 <> 0) Then
                                    If (25.0 > distancesquared(entityx(me\Field60, $00), (local0\Field1\Field3 - 13.0), entityz(me\Field60, $00), (local0\Field1\Field5 - 4.8125), 0.0, 0.0)) Then
                                        If (local0\Field13 = "Done") Then
                                            loadeventsound(local0, (("SFX\Room\Intro\IA\Scripted\Announcement" + (Str rand($00, $06))) + ".ogg"), $00)
                                            local0\Field6 = playsound_strict(local0\Field8, $00)
                                        EndIf
                                        local0\Field1\Field15[$06]\Field10 = 1.0
                                    EndIf
                                EndIf
                            Else
                                If (channelplaying(local0\Field1\Field15[$07]\Field18) = $00) Then
                                    local0\Field1\Field15[$07]\Field18 = playsoundex(local0\Field1\Field15[$07]\Field17, camera, local0\Field1\Field15[$07]\Field3, 7.0, 1.0, $01, $00)
                                EndIf
                                If ((local0\Field1\Field5 - 0.25) < entityz(local0\Field1\Field15[$06]\Field3, $00)) Then
                                    rotateentity(local0\Field1\Field15[$06]\Field3, 0.0, curveangle(-90.0, entityyaw(local0\Field1\Field15[$06]\Field3, $00), 15.0), 0.0, $00)
                                    If (local0\Field1\Field14[$05]\Field6 <> 0) Then
                                        openclosedoor(local0\Field1\Field14[$05], $01, $00)
                                    EndIf
                                    If (1.0 > local0\Field1\Field14[$05]\Field8) Then
                                        local0\Field1\Field15[$06]\Field10 = -1.0
                                        local0\Field1\Field15[$06]\Field24 = 0.0
                                        hideentity(local0\Field1\Field15[$06]\Field0)
                                    EndIf
                                EndIf
                            EndIf
                            local0\Field1\Field15[$07]\Field48 = 0.0
                            rotateentity(local0\Field1\Field15[$07]\Field3, 0.0, ((sin(((Float millisec) / 20.0)) * 3.0) + 180.0), 0.0, $01)
                            updatesoundorigin(local0\Field1\Field15[$07]\Field18, camera, local0\Field1\Field15[$07]\Field3, 7.0, 1.0, $01, $01)
                            If (local0\Field1\Field15[$08] <> Null) Then
                                If (7.0 = local0\Field1\Field15[$08]\Field10) Then
                                    If (6.25 > distancesquared(entityx(me\Field60, $00), (local0\Field1\Field3 - 26.125), entityz(me\Field60, $00), (local0\Field1\Field5 - 4.890625), 0.0, 0.0)) Then
                                        local0\Field1\Field15[$08]\Field10 = 10.0
                                        local0\Field1\Field15[$09]\Field10 = 10.0
                                        local0\Field1\Field15[$0A]\Field10 = 1.0
                                    EndIf
                                ElseIf ((local0\Field1\Field3 - 27.73438) > entityx(local0\Field1\Field15[$08]\Field3, $00)) Then
                                    For local8 = $08 To $0A Step $01
                                        removenpc(local0\Field1\Field15[local8])
                                    Next
                                EndIf
                            EndIf
                            If (local0\Field1\Field15[$0B] <> Null) Then
                                If (15.0 = local0\Field1\Field15[$0B]\Field10) Then
                                    If (6.25 > distancesquared(entityx(me\Field60, $00), (local0\Field1\Field3 - 26.125), entityz(me\Field60, $00), (local0\Field1\Field5 - 4.890625), 0.0, 0.0)) Then
                                        local0\Field1\Field15[$0B]\Field10 = 16.0
                                    EndIf
                                ElseIf ((local0\Field1\Field3 - (1.0 / 0.128)) < entityx(local0\Field1\Field15[$0B]\Field3, $00)) Then
                                    removenpc(local0\Field1\Field15[$0B])
                                EndIf
                            EndIf
                            animatenpc(local0\Field1\Field15[$0C], 357.0, 381.0, 0.05, $01)
                            If (11.0 <> local0\Field1\Field15[$03]\Field10) Then
                                If (20.25 > distancesquared(entityx(local0\Field1\Field15[$03]\Field3, $00), entityx(local0\Field1\Field14[$02]\Field2, $01), entityz(local0\Field1\Field15[$03]\Field3, $00), entityz(local0\Field1\Field14[$02]\Field2, $01), 0.0, 0.0)) Then
                                    local0\Field1\Field15[$03]\Field10 = 9.0
                                    If (20.25 > distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field14[$02]\Field2, $01), entityz(me\Field60, $00), entityz(local0\Field1\Field14[$02]\Field2, $01), 0.0, 0.0)) Then
                                        removenpc(local0\Field1\Field15[$05])
                                        removenpc(local0\Field1\Field15[$07])
                                        removenpc(local0\Field1\Field15[$0C])
                                        For local8 = $03 To $04 Step $01
                                            If (local0\Field1\Field15[local8]\Field17 <> $00) Then
                                                freesound_strict(local0\Field1\Field15[local8]\Field17)
                                                local0\Field1\Field15[local8]\Field17 = $00
                                            EndIf
                                            If (local0\Field1\Field15[local8]\Field19 <> $00) Then
                                                freesound_strict(local0\Field1\Field15[local8]\Field19)
                                                local0\Field1\Field15[local8]\Field19 = $00
                                            EndIf
                                            stopchannel(local0\Field1\Field15[local8]\Field18)
                                            stopchannel(local0\Field1\Field15[local8]\Field20)
                                        Next
                                        local0\Field1\Field15[$03]\Field12 = 0.0
                                        loadnpcsound(local0\Field1\Field15[$03], (("SFX\Room\Intro\Guard\Ulgrin\EscortDone" + (Str rand($00, $04))) + ".ogg"), $00)
                                        local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                        local0\Field1\Field15[$04]\Field10 = 9.0
                                        createhintmsg(getlocalstring("msg", "enterchmbr"), 6.0, $00)
                                        For local8 = $02 To $03 Step $01
                                            openclosedoor(local0\Field1\Field14[local8], $01, $00)
                                        Next
                                        freeentity(local0\Field1\Field11[$04])
                                        local0\Field1\Field11[$04] = $00
                                        For local8 = $00 To $02 Step $01
                                            showentity(local0\Field1\Field15[local8]\Field0)
                                        Next
                                        showentity(local0\Field1\Field15[$06]\Field0)
                                        pointentity(local0\Field1\Field15[$06]\Field3, local0\Field1\Field2, 0.0)
                                        rotateentity(local0\Field1\Field15[$06]\Field3, 0.0, entityyaw(local0\Field1\Field15[$06]\Field3, $00), 0.0, $00)
                                        tformpoint(-902.0, 500.0, 456.0, local0\Field1\Field2, $00)
                                        positionentity(local0\Field1\Field15[$06]\Field3, tformedx(), tformedy(), tformedz(), $00)
                                        resetentity(local0\Field1\Field15[$06]\Field3)
                                        local0\Field2 = 5.0
                                    EndIf
                                EndIf
                            EndIf
                        Case 5.0
                            If ((local0\Field1\Field14[$02]\Field6 And (11.0 <> local0\Field1\Field15[$03]\Field10)) <> 0) Then
                                If (2.0 > (Abs (entityx(me\Field60, $00) - entityx(local0\Field1\Field2, $01)))) Then
                                    For local8 = $01 To $02 Step $01
                                        openclosedoor(local0\Field1\Field14[local8], $01, $00)
                                    Next
                                    showentity(n_i\Field2\Field0)
                                    showentity(n_i\Field2\Field1)
                                    local0\Field4 = 0.0
                                    local0\Field2 = 6.0
                                EndIf
                            EndIf
                        Case 6.0
                            If (snd_i\Field49[$03] <> $00) Then
                                If ((entityvisible(camera, n_i\Field2\Field0) And entityinview(n_i\Field2\Field0, camera)) <> 0) Then
                                    createhintmsg(format(getlocalstring("msg", "blink"), key\Field0[key\Field8], "%s"), 6.0, $00)
                                    playsound_strict(snd_i\Field49[$03], $00)
                                    freesound_strict(snd_i\Field49[$03])
                                    snd_i\Field49[$03] = $00
                                EndIf
                            EndIf
                            local0\Field1\Field15[$06]\Field48 = 0.0
                            If (14000.0 > local0\Field4) Then
                                If (channelplaying(local0\Field6) <> 0) Then
                                    If (325.0 <= animtime(local0\Field1\Field15[$06]\Field0)) Then
                                        animatenpc(local0\Field1\Field15[$06], 326.0, 328.0, 0.02, $00)
                                    Else
                                        animatenpc(local0\Field1\Field15[$06], 320.0, 328.0, 0.05, $00)
                                    EndIf
                                Else
                                    animatenpc(local0\Field1\Field15[$06], 328.0, 320.0, -0.02, $00)
                                EndIf
                            EndIf
                            For local8 = $00 To $02 Step $01
                                updatesoundorigin(local0\Field1\Field15[local8]\Field18, camera, local0\Field1\Field15[local8]\Field3, (((Float (local8 = $00)) * 5.0) + 10.0), 1.0, $01, $01)
                            Next
                            If (10000.0 > local0\Field4) Then
                                If (local0\Field1\Field15[$03] <> Null) Then
                                    If (1.0 > local0\Field1\Field14[$02]\Field8) Then
                                        For local2 = Each doors
                                            If (local2\Field15 = local0\Field1) Then
                                                If (81.0 < entitydistancesquared(local2\Field2, local0\Field1\Field2)) Then
                                                    removedoor(local2)
                                                EndIf
                                            EndIf
                                        Next
                                        For local3 = Each props
                                            If (local3\Field2 = local0\Field1) Then
                                                If (81.0 < entitydistancesquared(local3\Field1, local0\Field1\Field2)) Then
                                                    removeprop(local3)
                                                EndIf
                                            EndIf
                                        Next
                                        For local4 = Each securitycams
                                            If (local4\Field16 = local0\Field1) Then
                                                removesecuritycam(local4)
                                            EndIf
                                        Next
                                        For local5 = Each lights
                                            If (local5\Field12 = local0\Field1) Then
                                                If (81.0 < entitydistancesquared(local5\Field0, local0\Field1\Field2)) Then
                                                    removelight(local5)
                                                EndIf
                                            EndIf
                                        Next
                                        For local7 = Each waypoints
                                            If (local7\Field2 = local0\Field1) Then
                                                removewaypoint(local7)
                                            EndIf
                                        Next
                                        removenpc(local0\Field1\Field15[$04])
                                        removenpc(local0\Field1\Field15[$03])
                                    EndIf
                                EndIf
                                local10 = (fps\Field7[$00] / 3.0)
                                local0\Field4 = min((local0\Field4 + local10), 5000.0)
                                If (((130.0 <= local0\Field4) And (130.0 > (local0\Field4 - local10))) <> 0) Then
                                    loadeventsound(local0, "SFX\Room\Intro\Scientist\Franklin\EnterChamber.ogg", $00)
                                    local0\Field6 = playsound_strict(local0\Field8, $01)
                                ElseIf (230.0 < local0\Field4) Then
                                    local9 = $01
                                    For local8 = $01 To $02 Step $01
                                        If (0.09 < distancesquared(entityx(local0\Field1\Field15[local8]\Field3, $00), entityx(local0\Field1\Field11[(local8 - $01)], $01), entityz(local0\Field1\Field15[local8]\Field3, $00), entityz(local0\Field1\Field11[(local8 - $01)], $01), 0.0, 0.0)) Then
                                            pointentity(local0\Field1\Field15[local8]\Field0, local0\Field1\Field11[(local8 - $01)], 0.0)
                                            rotateentity(local0\Field1\Field15[local8]\Field3, 0.0, curvevalue(entityyaw(local0\Field1\Field15[local8]\Field0, $00), entityyaw(local0\Field1\Field15[local8]\Field3, $00), 15.0), 0.0, $00)
                                            If ((((Float local8) * 30.0) + 200.0) < local0\Field4) Then
                                                local0\Field1\Field15[local8]\Field10 = 1.0
                                            EndIf
                                            local9 = $00
                                        Else
                                            local0\Field1\Field15[local8]\Field10 = 0.0
                                            pointentity(local0\Field1\Field15[local8]\Field0, local0\Field1\Field11[$02], 0.0)
                                            rotateentity(local0\Field1\Field15[local8]\Field3, 0.0, curvevalue(entityyaw(local0\Field1\Field15[local8]\Field0, $00), entityyaw(local0\Field1\Field15[local8]\Field3, $00), 15.0), 0.0, $00)
                                        EndIf
                                    Next
                                    If ((local0\Field1\Field3 + 2.71875) > entityx(me\Field60, $00)) Then
                                        If (((450.0 <= local0\Field4) And (450.0 > (local0\Field4 - local10))) <> 0) Then
                                            loadeventsound(local0, "SFX\Room\Intro\Scientist\Franklin\Refuse0.ogg", $00)
                                            local0\Field6 = playsound_strict(local0\Field8, $01)
                                        ElseIf (((650.0 <= local0\Field4) And (650.0 > (local0\Field4 - local10))) <> 0) Then
                                            loadeventsound(local0, "SFX\Room\Intro\Scientist\Franklin\Refuse1.ogg", $00)
                                            local0\Field6 = playsound_strict(local0\Field8, $01)
                                        ElseIf (((850.0 <= local0\Field4) And (850.0 > (local0\Field4 - local10))) <> 0) Then
                                            loadeventsound(local0, "SFX\Room\Intro\Scientist\Franklin\Refuse2.ogg", $00)
                                            local0\Field6 = playsound_strict(local0\Field8, $01)
                                            openclosedoor(local0\Field1\Field14[$01], $01, $00)
                                        ElseIf (1000.0 < local0\Field4) Then
                                            local0\Field1\Field15[$00]\Field10 = 1.0
                                            local0\Field1\Field15[$00]\Field11 = 10.0
                                            local0\Field1\Field15[$00]\Field12 = 1.0
                                        EndIf
                                        If (850.0 < local0\Field4) Then
                                            positionentity(me\Field60, min(entityx(me\Field60, $00), (local0\Field1\Field3 + 2.5)), entityy(me\Field60, $00), entityz(me\Field60, $00), $00)
                                        EndIf
                                    ElseIf (local9 = $01) Then
                                        openclosedoor(local0\Field1\Field14[$01], $01, $00)
                                        local0\Field4 = 10000.0
                                    EndIf
                                EndIf
                            ElseIf (14000.0 > local0\Field4) Then
                                local0\Field4 = min((local0\Field4 + fps\Field7[$00]), 13000.0)
                                For local8 = $01 To $02 Step $01
                                    pointentity(local0\Field1\Field15[local8]\Field0, local0\Field1\Field11[$02], 0.0)
                                    rotateentity(local0\Field1\Field15[local8]\Field3, 0.0, curvevalue(entityyaw(local0\Field1\Field15[local8]\Field0, $00), entityyaw(local0\Field1\Field15[local8]\Field3, $00), 15.0), 0.0, $00)
                                Next
                                If (10300.0 > local0\Field4) Then
                                    positionentity(me\Field60, max(entityx(me\Field60, $00), (local0\Field1\Field3 + 2.5)), entityy(me\Field60, $00), entityz(me\Field60, $00), $00)
                                EndIf
                                If (((10300.0 <= local0\Field4) And (10300.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                    loadeventsound(local0, "SFX\Room\Intro\Scientist\Franklin\Approach173.ogg", $00)
                                    local0\Field6 = playsound_strict(local0\Field8, $01)
                                ElseIf (((10440.0 <= local0\Field4) And (10440.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                    openclosedoor(local0\Field1\Field14[$01], $01, $00)
                                ElseIf (((10740.0 <= local0\Field4) And (10740.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                    loadeventsound(local0, "SFX\Room\Intro\Scientist\Franklin\Problem.ogg", $00)
                                    local0\Field6 = playsound_strict(local0\Field8, $01)
                                ElseIf (((11145.0 <= local0\Field4) And (11145.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                    playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                                    local0\Field1\Field15[$01]\Field17 = loadsound_strict("SFX\Room\Intro\ClassD\DontLikeThis.ogg")
                                    local0\Field1\Field15[$01]\Field18 = playsoundex(local0\Field1\Field15[$01]\Field17, camera, local0\Field1\Field15[$01]\Field3, 10.0, 1.0, $01, $00)
                                ElseIf (((11561.0 <= local0\Field4) And (11561.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                    playsound_strict(snd_i\Field49[$02], $00)
                                    local0\Field1\Field15[$02]\Field17 = loadsound_strict("SFX\Room\Intro\ClassD\Breen.ogg")
                                    local0\Field1\Field15[$02]\Field18 = playsoundex(local0\Field1\Field15[$02]\Field17, camera, local0\Field1\Field15[$02]\Field3, 10.0, 1.0, $01, $00)
                                    setnpcframe(local0\Field1\Field15[$06], 357.0, $01)
                                    local0\Field4 = 14000.0
                                EndIf
                                If (((10440.0 <= local0\Field4) And (11561.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                    If (entityx(local0\Field1\Field14[$01]\Field2, $01) > entityx(me\Field60, $00)) Then
                                        If (12.0 <> local0\Field1\Field15[$00]\Field10) Then
                                            local0\Field1\Field15[$00]\Field17 = loadsound_strict((("SFX\Room\Intro\Guard\Balcony\Alert" + (Str rand($00, $01))) + ".ogg"))
                                            local0\Field1\Field15[$00]\Field18 = playsoundex(local0\Field1\Field15[$00]\Field17, camera, local0\Field1\Field15[$00]\Field3, 15.0, 1.0, $01, $00)
                                            local0\Field1\Field15[$00]\Field11 = 1.0
                                            local0\Field1\Field15[$00]\Field10 = 12.0
                                        EndIf
                                    EndIf
                                EndIf
                                If (10300.0 < local0\Field4) Then
                                    If (10560.0 < local0\Field4) Then
                                        If (10750.0 > local0\Field4) Then
                                            local0\Field1\Field15[$01]\Field10 = 1.0
                                            local0\Field1\Field15[$01]\Field24 = 0.005
                                        Else
                                            local0\Field1\Field15[$01]\Field10 = 0.0
                                            local0\Field1\Field15[$01]\Field24 = curvevalue(0.0, local0\Field1\Field15[$01]\Field24, 10.0)
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (20000.0 > local0\Field4) Then
                                local16 = createpivot($00)
                                positionentity(local16, entityx(camera, $00), (entityy(n_i\Field2\Field3, $01) - 0.05), entityz(camera, $00), $00)
                                pointentity(local16, n_i\Field2\Field3, 0.0)
                                rotateentity(me\Field60, entitypitch(me\Field60, $00), curveangle(entityyaw(local16, $00), entityyaw(me\Field60, $00), 40.0), 0.0, $00)
                                turnentity(local16, 90.0, 0.0, 0.0, $00)
                                camerapitch = curveangle(entitypitch(local16, $00), (camerapitch + 90.0), 40.0)
                                camerapitch = (camerapitch - 90.0)
                                freeentity(local16)
                                local16 = $00
                                animatenpc(local0\Field1\Field15[$06], 357.0, 381.0, 0.05, $01)
                                local0\Field4 = min((local0\Field4 + fps\Field7[$00]), 19000.0)
                                If (14100.0 > local0\Field4) Then
                                    If (14060.0 > local0\Field4) Then
                                        me\Field10 = max((((14000.0 - local0\Field4) / 2.0) - rnd(0.0, 1.0)), -10.0)
                                        If (-10.0 = me\Field10) Then
                                            pointentity(n_i\Field2\Field3, local0\Field1\Field15[$01]\Field0, 0.0)
                                            rotateentity(n_i\Field2\Field3, 0.0, entityyaw(n_i\Field2\Field3, $00), 0.0, $00)
                                            moveentity(n_i\Field2\Field3, 0.0, 0.0, ((n_i\Field2\Field23 * 0.6) * fps\Field7[$00]))
                                            n_i\Field2\Field18 = loopsoundex(snd_i\Field12, n_i\Field2\Field18, camera, n_i\Field2\Field3, 10.0, n_i\Field2\Field10, $00)
                                            n_i\Field2\Field10 = curvevalue(1.0, n_i\Field2\Field10, 3.0)
                                        Else
                                            n_i\Field2\Field10 = max(0.0, (n_i\Field2\Field10 - (fps\Field7[$00] / 20.0)))
                                        EndIf
                                    ElseIf (14065.0 > local0\Field4) Then
                                        me\Field10 = -10.0
                                        If (local0\Field1\Field15[$01]\Field50 = $00) Then
                                            playsoundex(snd_i\Field53[rand($00, $02)], camera, n_i\Field2\Field3, 10.0, 1.0, $00, $00)
                                            playsound_strict(snd_i\Field49[$04], $00)
                                            me\Field24 = 3.0
                                            local0\Field1\Field15[$01]\Field50 = $01
                                        EndIf
                                        positionentity(n_i\Field2\Field3, entityx(local0\Field1\Field15[$01]\Field0, $00), entityy(n_i\Field2\Field3, $00), entityz(local0\Field1\Field15[$01]\Field0, $00), $00)
                                        resetentity(n_i\Field2\Field3)
                                        pointentity(n_i\Field2\Field3, local0\Field1\Field15[$02]\Field3, 0.0)
                                        local0\Field1\Field15[$02]\Field10 = -1.0
                                        animatenpc(local0\Field1\Field15[$02], 406.0, 382.0, -0.015, $01)
                                        moveentity(local0\Field1\Field15[$02]\Field3, 0.0, 0.0, (fps\Field7[$00] * -0.01))
                                        stopchannel(local0\Field1\Field15[$00]\Field18)
                                        local0\Field1\Field15[$00]\Field18 = $00
                                        loadnpcsound(local0\Field1\Field15[$00], (("SFX\Room\Intro\Guard\Balcony\WTF" + (Str rand($00, $01))) + ".ogg"), $00)
                                        local0\Field1\Field15[$00]\Field18 = playsoundex(local0\Field1\Field15[$00]\Field17, camera, local0\Field1\Field15[$00]\Field3, 20.0, 1.0, $01, $00)
                                        local0\Field1\Field15[$00]\Field10 = 12.0
                                        local0\Field1\Field15[$00]\Field11 = 0.0
                                        local0\Field1\Field15[$00]\Field15 = 180.0
                                        local0\Field4 = 14065.0
                                    ElseIf (local0\Field1\Field15[$02]\Field17 = $00) Then
                                        loadnpcsound(local0\Field1\Field15[$02], "SFX\Room\Intro\ClassD\Gasp.ogg", $00)
                                        playsoundex(local0\Field1\Field15[$02]\Field17, camera, local0\Field1\Field15[$02]\Field3, 8.0, 1.0, $01, $00)
                                    EndIf
                                    If (((14080.0 < local0\Field4) And (14080.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                        playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                                    EndIf
                                    me\Field24 = 3.0
                                ElseIf (14200.0 > local0\Field4) Then
                                    local0\Field1\Field15[$00]\Field10 = 8.0
                                    If (14115.0 < local0\Field4) Then
                                        If (local0\Field1\Field15[$02]\Field50 = $00) Then
                                            freesound_strict(local0\Field1\Field15[$02]\Field17)
                                            local0\Field1\Field15[$02]\Field17 = $00
                                            playsoundex(snd_i\Field53[$01], camera, local0\Field1\Field15[$02]\Field3, 8.0, 1.0, $00, $00)
                                            local0\Field1\Field15[$02]\Field50 = $01
                                        EndIf
                                        positionentity(n_i\Field2\Field3, entityx(local0\Field1\Field15[$02]\Field0, $00), entityy(n_i\Field2\Field3, $00), entityz(local0\Field1\Field15[$02]\Field0, $00), $00)
                                        resetentity(n_i\Field2\Field3)
                                        pointentity(n_i\Field2\Field3, me\Field60, 0.0)
                                    EndIf
                                    If (14130.0 > local0\Field4) Then
                                        setnpcframe(local0\Field1\Field15[$02], 50.0, $01)
                                        me\Field10 = -10.0
                                        me\Field50 = 1.0
                                    Else
                                        n_i\Field2\Field26 = 0.0
                                    EndIf
                                    If (((14100.0 <= local0\Field4) And (14100.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                        playsound_strict(snd_i\Field49[$05], $00)
                                    EndIf
                                    If (14150.0 > local0\Field4) Then
                                        me\Field24 = 5.0
                                        If ((local0\Field1\Field3 + 2.71875) <= entityx(me\Field60, $00)) Then
                                            createhintmsg(getlocalstring("msg", "leavechmbr"), 1.0, $00)
                                        EndIf
                                    EndIf
                                ElseIf (14300.0 < local0\Field4) Then
                                    If (((14600.0 < local0\Field4) And (14700.0 > local0\Field4)) <> 0) Then
                                        me\Field10 = -10.0
                                        me\Field50 = 1.0
                                    EndIf
                                    If ((local0\Field1\Field3 + 2.71875) <= entityx(me\Field60, $00)) Then
                                        createhintmsg(getlocalstring("msg", "leavechmbr"), 1.0, $00)
                                    Else
                                        local0\Field4 = 20000.0
                                    EndIf
                                EndIf
                            ElseIf (30000.0 > local0\Field4) Then
                                local0\Field4 = min((local0\Field4 + fps\Field7[$00]), 30000.0)
                                If (20100.0 > local0\Field4) Then
                                    me\Field24 = 2.0
                                ElseIf (20200.0 > local0\Field4) Then
                                    If (((20105.0 < local0\Field4) And (20105.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                        playsound_strict(snd_i\Field49[$06], $00)
                                        tformpoint(128.0, 480.0, 1280.0, local0\Field1\Field2, $00)
                                        positionentity(local0\Field1\Field15[$00]\Field3, tformedx(), tformedy(), tformedz(), $00)
                                        resetentity(local0\Field1\Field15[$00]\Field3)
                                        stopchannel(local0\Field1\Field15[$00]\Field18)
                                        local0\Field1\Field15[$00]\Field18 = $00
                                        loadnpcsound(local0\Field1\Field15[$00], "SFX\Room\Intro\Guard\Balcony\OhShit.ogg", $00)
                                        local0\Field1\Field15[$00]\Field18 = playsoundex(local0\Field1\Field15[$00]\Field17, camera, local0\Field1\Field15[$00]\Field3, 20.0, 1.0, $01, $00)
                                        n_i\Field2\Field15 = 0.0
                                        n_i\Field2\Field26 = 1.0
                                        pointentity(local0\Field1\Field15[$00]\Field3, n_i\Field2\Field0, 0.0)
                                        tformpoint(-320.0, 480.0, 1312.0, local0\Field1\Field2, $00)
                                        positionentity(n_i\Field2\Field3, tformedx(), tformedy(), tformedz(), $00)
                                        resetentity(n_i\Field2\Field3)
                                        pointentity(n_i\Field2\Field3, local0\Field1\Field15[$00]\Field3, 0.0)
                                    EndIf
                                    me\Field10 = -10.0
                                    me\Field50 = 1.0
                                    me\Field24 = 3.0
                                ElseIf (20300.0 > local0\Field4) Then
                                    pointentity(local0\Field1\Field15[$00]\Field3, n_i\Field2\Field3, 0.0)
                                    local0\Field1\Field15[$00]\Field10 = 2.0
                                    If (((20260.0 < local0\Field4) And (20260.0 > (local0\Field4 - fps\Field7[$00]))) <> 0) Then
                                        playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                                    EndIf
                                ElseIf (20300.0 > (local0\Field4 - fps\Field7[$00])) Then
                                    me\Field10 = -10.0
                                    me\Field50 = 1.0
                                    me\Field24 = 3.0
                                    me\Field38 = 0.0
                                    me\Field9 = $00
                                    playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                                    If (local0\Field1\Field15[$00]\Field17 <> $00) Then
                                        freesound_strict(local0\Field1\Field15[$00]\Field17)
                                        local0\Field1\Field15[$00]\Field17 = $00
                                    EndIf
                                    local0\Field1\Field15[$00]\Field18 = playsoundex(snd_i\Field53[$01], camera, local0\Field1\Field15[$00]\Field3, 8.0, 1.0, $00, $00)
                                    n_i\Field2\Field26 = 0.0
                                    playsound_strict(loadsound_strict("SFX\Room\Intro\173Vent.ogg"), $00)
                                    positionentity(n_i\Field2\Field3, 0.0, -500.0, 0.0, $00)
                                    resetentity(n_i\Field2\Field3)
                                    For local1 = Each rooms
                                        If (local1\Field7\Field6 = $03) Then
                                            local11 = (local1\Field3 + 14.5)
                                            local12 = (local1\Field4 + 1.5)
                                            local13 = (local1\Field5 + 13.125)
                                            teleportentity(me\Field60, (((entityx(me\Field60, $00) - local0\Field1\Field3) - 1.125) + local11), (((entityy(me\Field60, $00) - local0\Field1\Field4) + 0.4) + local12), (((entityz(me\Field60, $00) - local0\Field1\Field5) + 0.125) + local13), 0.3, $00, 2.0, $00)
                                            teleporttoroom(local1)
                                            fog\Field0 = 6.0
                                            For local8 = $00 To $02 Step $01
                                                positionentity(local0\Field1\Field15[local8]\Field3, (((entityx(local0\Field1\Field15[local8]\Field3, $00) - local0\Field1\Field3) - 1.125) + local11), ((entityy(local0\Field1\Field15[local8]\Field3, $00) + local12) - local0\Field1\Field4), (((entityz(local0\Field1\Field15[local8]\Field3, $00) - local0\Field1\Field5) + 0.125) + local13), $00)
                                                resetentity(local0\Field1\Field15[local8]\Field3)
                                            Next
                                            freesound_strict(snd_i\Field49[$02])
                                            snd_i\Field49[$02] = $00
                                            For local8 = $04 To $06 Step $01
                                                freesound_strict(snd_i\Field49[local8])
                                                snd_i\Field49[local8] = $00
                                            Next
                                            local1\Field15[$00] = local0\Field1\Field15[$00]
                                            local1\Field15[$00]\Field10 = 8.0
                                            local0\Field1\Field15[$06]\Field48 = 1.0
                                            local1\Field15[$01] = local0\Field1\Field15[$06]
                                            For local2 = Each doors
                                                If (local2\Field15 = local0\Field1) Then
                                                    removedoor(local2)
                                                EndIf
                                            Next
                                            For local5 = Each lights
                                                If (local5\Field12 = local0\Field1) Then
                                                    removelight(local5)
                                                EndIf
                                            Next
                                            For local3 = Each props
                                                If (local3\Field2 = local0\Field1) Then
                                                    removeprop(local3)
                                                EndIf
                                            Next
                                            For local6 = Each soundemitters
                                                If (local6\Field4 = local0\Field1) Then
                                                    removesoundemitter(local6)
                                                EndIf
                                            Next
                                            For local4 = Each securitycams
                                                If (local4\Field16 = local0\Field1) Then
                                                    removesecuritycam(local4)
                                                EndIf
                                            Next
                                            For local7 = Each waypoints
                                                If (local7\Field2 = local0\Field1) Then
                                                    removewaypoint(local7)
                                                EndIf
                                            Next
                                            removeroom(local0\Field1)
                                            clearconsole()
                                            clearfogcolor()
                                            initializeintromovie = $00
                                            removeevent(local0)
                                            Return $00
                                            Exit
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                    End Select
                    If (6.0 > local0\Field2) Then
                        If (0.0 = me\Field0) Then
                            local14 = distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field15[$03]\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field1\Field15[$03]\Field3, $00), 0.0, 0.0)
                            If (local0\Field1\Field15[$05] <> Null) Then
                                If (11.0 <> local0\Field1\Field15[$05]\Field10) Then
                                    If ((((25.0 > distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field15[$05]\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field1\Field15[$05]\Field3, $00), 0.0, 0.0)) And (25.0 < local14)) And (25.0 < distancesquared(entityx(me\Field60, $00), entityx(local0\Field1\Field15[$04]\Field3, $00), entityz(me\Field60, $00), entityz(local0\Field1\Field15[$04]\Field3, $00), 0.0, 0.0))) <> 0) Then
                                        If (entityvisible(me\Field60, local0\Field1\Field15[$05]\Field3) <> 0) Then
                                            For local8 = $03 To $05 Step $01
                                                If (local8 < $05) Then
                                                    stopchannel(local0\Field1\Field15[local8]\Field18)
                                                    local0\Field1\Field15[local8]\Field18 = $00
                                                    If (local0\Field1\Field15[local8]\Field17 <> $00) Then
                                                        freesound_strict(local0\Field1\Field15[local8]\Field17)
                                                        local0\Field1\Field15[local8]\Field17 = $00
                                                    EndIf
                                                EndIf
                                                local0\Field1\Field15[local8]\Field10 = 11.0
                                                local0\Field1\Field15[local8]\Field12 = 1.0
                                                local0\Field1\Field15[local8]\Field28 = 210.0
                                            Next
                                            local0\Field1\Field15[$05]\Field18 = playsoundex(loadtempsound("SFX\Room\Intro\Guard\PlayerEscape.ogg"), camera, local0\Field1\Field15[$05]\Field3, 10.0, 1.0, $01, $00)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If (11.0 <> local0\Field1\Field15[$03]\Field10) Then
                                If (((9.0 = local0\Field1\Field15[$03]\Field10) Lor (5.0 = local0\Field1\Field15[$03]\Field10)) <> 0) Then
                                    If (4.0 = local0\Field2) Then
                                        local10 = fps\Field7[$00]
                                    ElseIf (5.0 = local0\Field2) Then
                                        local9 = $02
                                        If (((selecteditem <> Null) And (selecteditem\Field4\Field11 <> $00)) <> 0) Then
                                            local9 = $03
                                        EndIf
                                        local10 = (fps\Field7[$00] / (Float local9))
                                    Else
                                        local10 = 0.0
                                    EndIf
                                    local0\Field1\Field15[$03]\Field12 = max((local0\Field1\Field15[$03]\Field12 + local10), 50.0)
                                    If (((560.0 <= local0\Field1\Field15[$03]\Field12) And (560.0 > (local0\Field1\Field15[$03]\Field12 - local10))) <> 0) Then
                                        If (2.0 > local0\Field1\Field15[$03]\Field11) Then
                                            For local8 = $03 To $04 Step $01
                                                stopchannel(local0\Field1\Field15[local8]\Field18)
                                                local0\Field1\Field15[local8]\Field18 = $00
                                            Next
                                            loadnpcsound(local0\Field1\Field15[$03], (("SFX\Room\Intro\Guard\Ulgrin\EscortRefuse" + (Str rand($00, $01))) + ".ogg"), $00)
                                            local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                            local0\Field1\Field15[$03]\Field11 = 3.0
                                            local0\Field1\Field15[$03]\Field12 = 50.0
                                        ElseIf (3.0 = local0\Field1\Field15[$03]\Field11) Then
                                            For local8 = $03 To $04 Step $01
                                                stopchannel(local0\Field1\Field15[local8]\Field18)
                                                local0\Field1\Field15[local8]\Field18 = $00
                                            Next
                                            loadnpcsound(local0\Field1\Field15[$03], (("SFX\Room\Intro\Guard\Ulgrin\EscortPissedOff" + (Str rand($00, $01))) + ".ogg"), $00)
                                            local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                            local0\Field1\Field15[$03]\Field11 = 4.0
                                            local0\Field1\Field15[$03]\Field12 = 50.0
                                        ElseIf (4.0 = local0\Field1\Field15[$03]\Field11) Then
                                            For local8 = $03 To $04 Step $01
                                                stopchannel(local0\Field1\Field15[local8]\Field18)
                                                local0\Field1\Field15[local8]\Field18 = $00
                                            Next
                                            loadnpcsound(local0\Field1\Field15[$03], (("SFX\Room\Intro\Guard\Ulgrin\EscortKill" + (Str rand($00, $01))) + ".ogg"), $00)
                                            local0\Field1\Field15[$03]\Field18 = playsoundex(local0\Field1\Field15[$03]\Field17, camera, local0\Field1\Field15[$03]\Field3, 10.0, 1.0, $01, $00)
                                            local0\Field1\Field15[$03]\Field11 = 5.0
                                            local0\Field1\Field15[$03]\Field12 = 225.0
                                        ElseIf (5.0 = local0\Field1\Field15[$03]\Field11) Then
                                            For local8 = $03 To ((local0\Field1\Field15[$05] <> Null) + $04) Step $01
                                                local0\Field1\Field15[local8]\Field10 = 11.0
                                                local0\Field1\Field15[local8]\Field12 = 1.0
                                            Next
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field1\Field15[$03]\Field12 = clamp((local0\Field1\Field15[$03]\Field12 - local10), 0.0, 50.0)
                                EndIf
                            ElseIf (5.0 = local0\Field2) Then
                                If (1.0 <> local0\Field1\Field15[$00]\Field10) Then
                                    loadnpcsound(local0\Field1\Field15[$00], (("SFX\Room\Intro\Guard\Balcony\WTF" + (Str rand($00, $01))) + ".ogg"), $00)
                                    local0\Field1\Field15[$00]\Field18 = playsoundex(local0\Field1\Field15[$00]\Field17, camera, local0\Field1\Field15[$00]\Field3, 20.0, 1.0, $01, $00)
                                    local0\Field1\Field15[$00]\Field10 = 1.0
                                    local0\Field1\Field15[$00]\Field11 = 10.0
                                    local0\Field1\Field15[$00]\Field12 = 1.0
                                    local0\Field1\Field15[$00]\Field28 = 210.0
                                EndIf
                                For local8 = $01 To $02 Step $01
                                    pointentity(local0\Field1\Field15[local8]\Field0, me\Field60, 0.0)
                                    rotateentity(local0\Field1\Field15[local8]\Field3, 0.0, entityyaw(local0\Field1\Field15[local8]\Field0, $00), 0.0, $00)
                                Next
                            EndIf
                            For local8 = $03 To ((local0\Field1\Field15[$05] <> Null) + $04) Step $01
                                updatesoundorigin(local0\Field1\Field15[local8]\Field18, camera, local0\Field1\Field15[local8]\Field0, 10.0, 1.0, $01, $01)
                            Next
                        Else
                            shouldplay = $42
                            playsound_strict(loadtempsound("SFX\Room\Intro\Guard\Ulgrin\EscortTerminated.ogg"), $00)
                            removeevent(local0)
                            Return $00
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
