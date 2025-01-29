Function mp_updateevents%()
    Local local0.particles
    Local local1.npcs
    Local local2.rooms
    Local local3.events
    Local local4.events
    Local local5.decals
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11.items
    Local local12.items
    Local local13.securitycams
    Local local14%
    Local local15.waypoints
    Local local16.doors
    Local local17%
    Local local18.emitter
    Local local19.itemtemplates
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24$
    Local local25%
    Local local26#
    Local local27#
    Local local28%
    Local local29%
    Local local30$
    Local local31#
    Local local32#
    Local local33#
    Local local34#
    Local local35#
    Local local36#
    Local local37#
    Local local38#
    Local local39%
    Local local40%
    Local local41%
    Local local42$
    Local local43%
    Local local44%
    Local local45#
    Local local46#
    Local local47#
    Local local48#
    Local local49%
    Local local52#
    Local local54%
    Local local55#
    Local local56%
    Local local57#
    Local local58#
    Local local59#
    Local local60%
    Local local63%
    Local local64%
    Local local65.forest
    Local local66%
    Local local67%
    Local local68%
    Local local69$
    Local local71%
    Local local76%
    Local local77.rooms
    Local local78.rooms
    Local local79#
    Local local84%
    Local local85%
    Local local87.mp_player
    Local local90%[7]
    Local local91%
    Local local92%
    Local local93%
    Local local94%
    Local local95%
    Local local96%
    Local local97%
    Local local98%
    Local local99%
    Local local100%
    Local local101%
    Local local103%
    Local local104%
    Local local105%
    Local local106%
    Local local107%
    Local local108%
    Local local111.waypoints
    Local local112$
    Local local113%
    Local local114.doors
    Local local115.doors
    Local local117%
    Local local118#
    Local local119#
    Local local120#
    Local local121%
    Local local122%
    Local local124%
    Local local125%
    Local local128#
    Local local129%
    catcherrors("MP_UpdateEvents()")
    If (((mp_ishoster() = $00) And (((mp_iseventsreceived() = $00) Lor (mp_isnpcsreceived() = $00)) Lor (mp_isconnected() = $00))) <> 0) Then
        Return $00
    EndIf
    event_prevplayerroom = playerroom
    local49 = i_268\Field2
    For local3 = Each events
        mp_prepareeventqueue(local3)
        playerroom = event_prevplayerroom
        me\Field60 = getrealcollider()
        local3\Field23 = $01
        If (((local3\Field24 <> Null) And (local3\Field22 = $00)) <> 0) Then
            playerroom = mp_rooms[local3\Field24\Field22]
            me\Field60 = local3\Field24\Field18
            local3\Field23 = (local3\Field24 = ue_players[mp_getmyindex()])
        EndIf
        i_268\Field2 = (local3\Field23 * local49)
        local3\Field19 = (local3\Field19 - fps\Field7[$00])
        If (0.0 >= local3\Field19) Then
            event_calculatedist(local3)
            local3\Field19 = 35.0
        EndIf
        Select local3\Field0
            Case $03
                If (local3\Field1\Field15[$03] = Null) Then
                    If (event_isplayerinroom(local3) <> 0) Then
                        local3\Field1\Field14[$01]\Field6 = $01
                        If (selecteddifficulty\Field3 = $00) Then
                            createhintmsg(format(getlocalstring("save", "save"), key\Field0[key\Field9], "%s"), 6.0, $01)
                        ElseIf (selecteddifficulty\Field3 = $01) Then
                            createhintmsg(getlocalstring("save", "failed.screen"), 6.0, $01)
                        EndIf
                        n_i\Field2\Field26 = 1.0
                        While (180.0 > local3\Field1\Field14[$00]\Field8)
                            local3\Field1\Field14[$00]\Field8 = min(180.0, (local3\Field1\Field14[$00]\Field8 + 0.8))
                            local45 = (sin(local3\Field1\Field14[$00]\Field8) / 180.0)
                            moveentity(local3\Field1\Field14[$00]\Field0, local45, 0.0, 0.0)
                            moveentity(local3\Field1\Field14[$00]\Field1, (- local45), 0.0, 0.0)
                        Wend
                        If (local3\Field1\Field15[$00] <> Null) Then
                            local3\Field1\Field15[$00]\Field10 = 8.0
                            setnpcframe(local3\Field1\Field15[$00], 74.0, $01)
                        EndIf
                        If (local3\Field1\Field15[$01] <> Null) Then
                            positionentity(local3\Field1\Field15[$01]\Field3, local3\Field1\Field3, (local3\Field1\Field4 + 0.5), ((local3\Field1\Field5 - 1.0) + 8.0), $01)
                            resetentity(local3\Field1\Field15[$01]\Field3)
                        Else
                            local3\Field1\Field15[$01] = createnpc($13, local3\Field1\Field3, (local3\Field1\Field4 + 0.5), ((local3\Field1\Field5 - 1.0) + 8.0))
                            changenpctextureid(local3\Field1\Field15[$01], $03)
                        EndIf
                        setnpcframe(local3\Field1\Field15[$01], 210.0, $01)
                        If (local3\Field1\Field15[$02] <> Null) Then
                            positionentity(local3\Field1\Field15[$02]\Field3, local3\Field1\Field3, (local3\Field1\Field4 + 0.5), (local3\Field1\Field5 + 10.0625), $01)
                            resetentity(local3\Field1\Field15[$02]\Field3)
                        Else
                            local3\Field1\Field15[$02] = createnpc($14, local3\Field1\Field3, (local3\Field1\Field4 + 0.5), (local3\Field1\Field5 + 10.0625))
                        EndIf
                        local3\Field1\Field15[$02]\Field10 = 7.0
                        pointentity(local3\Field1\Field15[$02]\Field3, local3\Field1\Field15[$01]\Field3, 0.0)
                        pointentity(local3\Field1\Field15[$01]\Field3, local3\Field1\Field15[$02]\Field3, 0.0)
                        tformpoint(3512.0, 827.0, 4682.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$03] = createnpc($14, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$03]\Field10 = 8.0
                        local3\Field1\Field15[$03]\Field50 = $01
                        setnpcframe(local3\Field1\Field15[$03], 286.0, $01)
                        rotateentity(local3\Field1\Field15[$03]\Field3, 0.0, ((Float local3\Field1\Field6) + 90.0), 0.0, $01)
                        tformpoint(4712.0, 435.8, 4026.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$04] = createnpc($13, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$04]\Field12 = -1.0
                        local3\Field1\Field15[$04]\Field50 = $01
                        setnpcframe(local3\Field1\Field15[$04], 677.0, $01)
                        rotateentity(local3\Field1\Field15[$04]\Field3, 0.0, ((Float local3\Field1\Field6) + 270.0), 0.0, $01)
                        tformpoint(4340.0, 435.8, 3680.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$05] = createnpc($13, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$05]\Field12 = -1.0
                        local3\Field1\Field15[$05]\Field50 = $01
                        changenpctextureid(local3\Field1\Field15[$05], $05)
                        setnpcframe(local3\Field1\Field15[$05], 779.0, $01)
                        rotateentity(local3\Field1\Field15[$05]\Field3, 0.0, ((Float local3\Field1\Field6) + 270.0), 0.0, $01)
                        playsound_strict(loadtempsound("SFX\Room\Intro\173Vent.ogg"), $00)
                        me\Field10 = -10.0
                        me\Field50 = 1.0
                        me\Field24 = 3.0
                        playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                        me\Field38 = 0.0
                        me\Field9 = $01
                        local3\Field2 = 1.0
                    EndIf
                Else
                    If ((local3\Field1\Field4 + 1.5) < entityy(local3\Field1\Field11[$02], $01)) Then
                        local3\Field5 = curvevalue((local3\Field5 + (fps\Field7[$00] * 2.0)), local3\Field5, 40.0)
                        positionentity(local3\Field1\Field11[$02], entityx(local3\Field1\Field11[$02], $01), max((local3\Field1\Field4 + 1.5), ((local3\Field1\Field4 + 4.5) - local3\Field5)), entityz(local3\Field1\Field11[$02], $01), $01)
                        rotateentity(local3\Field1\Field11[$02], entitypitch(local3\Field1\Field11[$02], $01), curvevalue(30.0, entityyaw(local3\Field1\Field11[$02], $01), 200.0), entityroll(local3\Field1\Field11[$02], $01), $01)
                    EndIf
                    If (local3\Field1\Field15[$00] <> Null) Then
                        animatenpc(local3\Field1\Field15[$00], 249.0, 286.0, 0.4, $00)
                    EndIf
                    If (1.21 > entitydistancesquared(me\Field60, local3\Field1\Field14[$04]\Field2)) Then
                        local3\Field2 = max(local3\Field2, 500.0)
                    EndIf
                    If (500.0 <= local3\Field2) Then
                        local3\Field2 = (local3\Field2 + fps\Field7[$00])
                    ElseIf (5.0 > entitydistancesquared(me\Field60, local3\Field1\Field14[$04]\Field2)) Then
                        local3\Field2 = (local3\Field2 + (fps\Field7[$00] * 2.0))
                    EndIf
                    If (500.0 <= local3\Field2) Then
                        If (0.0 = local3\Field3) Then
                            If (((900.0 < local3\Field2) And local3\Field1\Field14[$03]\Field6) <> 0) Then
                                If (900.0 >= (local3\Field2 - fps\Field7[$00])) Then
                                    positionentity(n_i\Field2\Field3, (local3\Field1\Field3 + 0.125), (local3\Field1\Field4 + 0.32), (local3\Field1\Field5 + 12.1875), $01)
                                    resetentity(n_i\Field2\Field3)
                                    local3\Field1\Field15[$01]\Field17 = loadsound_strict("SFX\Room\Intro\WhatThe0a.ogg")
                                    local3\Field1\Field15[$01]\Field18 = playsoundex(local3\Field1\Field15[$01]\Field17, camera, local3\Field1\Field15[$01]\Field3, 10.0, 1.0, $01, $00)
                                    local3\Field1\Field15[$01]\Field10 = 1.0
                                    local3\Field1\Field15[$01]\Field23 = -0.008
                                    local3\Field1\Field15[$02]\Field17 = loadsound_strict("SFX\Room\Intro\WhatThe0b.ogg")
                                    local3\Field1\Field15[$02]\Field18 = playsoundex(local3\Field1\Field15[$02]\Field17, camera, local3\Field1\Field15[$02]\Field3, 10.0, 1.0, $01, $00)
                                EndIf
                                local3\Field1\Field15[$01]\Field24 = curvevalue(local3\Field1\Field15[$01]\Field23, local3\Field1\Field15[$01]\Field24, 5.0)
                                rotateentity(local3\Field1\Field15[$01]\Field3, 0.0, 0.0, 0.0, $00)
                                If (1075.0 < local3\Field2) Then
                                    If (1.0 <> local3\Field1\Field15[$02]\Field10) Then
                                        local3\Field1\Field15[$02]\Field24 = curvevalue(-0.012, local3\Field1\Field15[$02]\Field24, 5.0)
                                        animatenpc(local3\Field1\Field15[$02], 39.0, 76.0, (local3\Field1\Field15[$02]\Field24 * 40.0), $01)
                                        moveentity(local3\Field1\Field15[$02]\Field3, 0.0, 0.0, (local3\Field1\Field15[$02]\Field24 * fps\Field7[$00]))
                                        local3\Field1\Field15[$02]\Field10 = 8.0
                                        If ((local3\Field1\Field5 + 8.0) > entityz(local3\Field1\Field15[$02]\Field3, $00)) Then
                                            pointentity(local3\Field1\Field15[$02]\Field0, local3\Field1\Field15[$01]\Field3, 0.0)
                                            rotateentity(local3\Field1\Field15[$02]\Field3, 0.0, curveangle((entityyaw(local3\Field1\Field15[$02]\Field0, $00) - 180.0), entityyaw(local3\Field1\Field15[$02]\Field3, $00), 15.0), 0.0, $00)
                                        Else
                                            rotateentity(local3\Field1\Field15[$02]\Field3, 0.0, 0.0, 0.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                                If (1180.0 > local3\Field2) Then
                                    positionentity(n_i\Field2\Field3, (local3\Field1\Field3 + 0.125), (local3\Field1\Field4 + 0.32), (local3\Field1\Field5 + 12.1875), $01)
                                    resetentity(n_i\Field2\Field3)
                                    rotateentity(n_i\Field2\Field3, 0.0, 190.0, 0.0, $00)
                                    If (((970.0 < local3\Field2) And (1075.0 > local3\Field2)) <> 0) Then
                                        animatenpc(local3\Field1\Field15[$02], 1539.0, 1553.0, 0.2, $00)
                                        pointentity(local3\Field1\Field15[$02]\Field0, n_i\Field2\Field3, 0.0)
                                        rotateentity(local3\Field1\Field15[$02]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$02]\Field0, $00), entityyaw(local3\Field1\Field15[$02]\Field3, $00), 15.0), 0.0, $00)
                                    EndIf
                                Else
                                    If (1180.0 > (local3\Field2 - fps\Field7[$00])) Then
                                        playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                                        me\Field50 = 3.0
                                        me\Field10 = -10.0
                                        playsoundex(snd_i\Field12, camera, n_i\Field2\Field3, 10.0, 1.0, $00, $00)
                                        pointentity(n_i\Field2\Field3, local3\Field1\Field15[$02]\Field3, 0.0)
                                    EndIf
                                    positionentity(n_i\Field2\Field3, (local3\Field1\Field3 - 0.375), (local3\Field1\Field4 + 0.32), (local3\Field1\Field5 + 10.3125), $01)
                                    resetentity(n_i\Field2\Field3)
                                    rotateentity(n_i\Field2\Field3, 0.0, 190.0, 0.0, $00)
                                    n_i\Field2\Field26 = (Float ($01 - (0.25 <= me\Field50)))
                                    If ((((0.0 = me\Field0) And (chs\Field2 = $00)) And (chs\Field0 = $00)) <> 0) Then
                                        If (((6.25 > entitydistancesquared(n_i\Field2\Field3, me\Field60)) And (1.0 > (Abs (entityy(me\Field60, $00) - entityy(n_i\Field2\Field3, $00))))) <> 0) Then
                                            me\Field50 = 3.0
                                            me\Field10 = -10.0
                                            playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                                            playsoundex(snd_i\Field12, camera, n_i\Field2\Field3, 10.0, 1.0, $00, $00)
                                            positionentity(n_i\Field2\Field3, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00)
                                            resetentity(n_i\Field2\Field3)
                                            n_i\Field2\Field26 = 0.0
                                        EndIf
                                    EndIf
                                    If (((1.0 <> local3\Field1\Field15[$02]\Field10) And (0.0 = me\Field0)) <> 0) Then
                                        If ((local3\Field1\Field5 + 3.507812) > entityz(local3\Field1\Field15[$02]\Field3, $00)) Then
                                            local3\Field1\Field14[$03]\Field6 = $00
                                            me\Field50 = 3.0
                                            me\Field10 = -10.0
                                            playsound_strict(snd_i\Field33[rand($00, $02)], $00)
                                            playsoundex(snd_i\Field12, camera, n_i\Field2\Field3, 10.0, 1.0, $00, $00)
                                            positionentity(n_i\Field2\Field3, 0.0, -500.0, 0.0, $00)
                                            resetentity(n_i\Field2\Field3)
                                            n_i\Field2\Field26 = 0.0
                                            createhintmsg(format(getlocalstring("msg", "run"), key\Field0[key\Field7], "%s"), 6.0, $01)
                                        EndIf
                                    EndIf
                                EndIf
                                If (((((chs\Field2 Lor i_268\Field2) = $00) And (9.0 > entitydistancesquared(me\Field60, local3\Field1\Field15[$02]\Field3))) And entityvisible(local3\Field1\Field15[$02]\Field3, me\Field60)) <> 0) Then
                                    local3\Field1\Field15[$02]\Field10 = 1.0
                                    local3\Field1\Field15[$02]\Field12 = 1.0
                                ElseIf (((1.0 = local3\Field1\Field15[$02]\Field10) And (entityvisible(local3\Field1\Field15[$02]\Field3, me\Field60) = $00)) <> 0) Then
                                    local3\Field1\Field15[$02]\Field10 = 0.0
                                    local3\Field1\Field15[$02]\Field12 = 0.0
                                EndIf
                                If (1.0 = local3\Field1\Field15[$02]\Field10) Then
                                    local3\Field1\Field14[$03]\Field6 = $01
                                EndIf
                            ElseIf (1.0 <> local3\Field1\Field15[$02]\Field10) Then
                                If ((local3\Field1\Field3 + 5.40625) > entityx(me\Field60, $00)) Then
                                    local3\Field2 = max(local3\Field2, 900.0)
                                EndIf
                                If (0.0 = local3\Field1\Field14[$03]\Field8) Then
                                    For local20 = $01 To $02 Step $01
                                        removenpc(local3\Field1\Field15[local20])
                                    Next
                                    local3\Field3 = 1.0
                                EndIf
                            EndIf
                        EndIf
                        If (local3\Field1\Field11[$01] <> $00) Then
                            If ((local3\Field1\Field4 - (1.0 / 2.56)) < entityy(local3\Field1\Field11[$01], $01)) Then
                                positionentity(local3\Field1\Field11[$00], entityx(local3\Field1\Field11[$00], $01), ((- max((local3\Field2 - 1300.0), 0.0)) / 4500.0), entityz(local3\Field1\Field11[$00], $01), $01)
                                rotateentity(local3\Field1\Field11[$00], (90.0 - (max((local3\Field2 - 1320.0), 0.0) / 130.0)), 45.0, ((- max((local3\Field2 - 1300.0), 0.0)) / 40.0), $01)
                                positionentity(local3\Field1\Field11[$01], entityx(local3\Field1\Field11[$01], $01), ((- max((local3\Field2 - 1800.0), 0.0)) / 5000.0), entityz(local3\Field1\Field11[$01], $01), $01)
                                rotateentity(local3\Field1\Field11[$01], ((- max((local3\Field2 - 2040.0), 0.0)) / 135.0), 225.0, (90.0 - (max((local3\Field2 - 2040.0), 0.0) / 43.0)), $01)
                            EndIf
                            If (rand($12C, $01) = $02) Then
                                If (6.25 > entitydistancesquared(local3\Field1\Field11[$00], me\Field60)) Then
                                    playsoundex(snd_i\Field24[rand($03, $01)], camera, local3\Field1\Field11[$00], 3.0, 1.0, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (2000.0 > local3\Field2) Then
                        If (channelplaying(local3\Field6) = $00) Then
                            local3\Field6 = playsound_strict(snd_i\Field50[$00], $00)
                        EndIf
                    EndIf
                    If (11.0 > local3\Field4) Then
                        If (channelplaying(local3\Field7) = $00) Then
                            local3\Field4 = (local3\Field4 + 1.0)
                            mp_loadeventsound(local3, (("SFX\Alarm\Alarm1_" + (Str (Int local3\Field4))) + ".ogg"), $01)
                            local3\Field7 = playsound_strict(local3\Field9, (1.0 = local3\Field4))
                        ElseIf (8.0 = (Float (Int local3\Field4))) Then
                            me\Field24 = 1.0
                        EndIf
                    EndIf
                    If (((300.0 < (local3\Field2 Mod 600.0)) And (300.0 > ((local3\Field2 + fps\Field7[$00]) Mod 600.0))) <> 0) Then
                        local20 = (Int (floor(((local3\Field2 - 5000.0) / 600.0)) + 1.0))
                        Select local20
                            Case $00
                                playannouncement("SFX\Room\Intro\IA\Scripted\Scripted5.ogg", $00)
                                createhintmsg(format(getlocalstring("msg", "crouch"), key\Field0[key\Field10], "%s"), 6.0, $01)
                            Case $01
                                createhintmsg(format(getlocalstring("msg", "lean.left"), key\Field0[key\Field12], "%s"), 6.0, $01)
                            Case $02
                                createhintmsg(format(getlocalstring("msg", "lean.right"), key\Field0[key\Field13], "%s"), 6.0, $01)
                        End Select
                        If (((local20 > $00) And (local20 < $1A)) <> 0) Then
                            If (commotionstate[local20] = $00) Then
                                playsound_strict(loadtempsound((("SFX\Room\Intro\Commotion\Commotion" + (Str (local20 - $01))) + ".ogg")), $00)
                                commotionstate[local20] = $01
                            EndIf
                        EndIf
                        If (local20 > $1A) Then
                            removeevent(local3)
                        EndIf
                    EndIf
                EndIf
            Case $02
                If (i_005\Field0 = $01) Then
                    If (n_i\Field3\Field65 = $00) Then
                        If (event_isplayerinroom(local3) <> 0) Then
                            If (0.0 = local3\Field2) Then
                                If (local3\Field1\Field11[$00] = $00) Then
                                    tformpoint(0.0, 0.0, 238.0, local3\Field1\Field2, $00)
                                    local3\Field1\Field11[$00] = createpivot($00)
                                    positionentity(local3\Field1\Field11[$00], tformedx(), tformedy(), tformedz(), $00)
                                    entityparent(local3\Field1\Field11[$00], local3\Field1\Field2, $01)
                                ElseIf ((chs\Field2 Lor i_268\Field2) = $00) Then
                                    If (1.69 > distancesquared(entityx(me\Field60, $01), entityx(local3\Field1\Field11[$00], $01), entityz(me\Field60, $01), entityz(local3\Field1\Field11[$00], $01), 0.0, 0.0)) Then
                                        playsound_strict(snd_i\Field47[$0A], $00)
                                        tformpoint(0.0, 188.0, 459.0, local3\Field1\Field2, $00)
                                        local5 = createdecal($00, tformedx(), tformedy(), tformedz(), 0.0, ((Float local3\Field1\Field6) + 360.0), rnd(360.0, 0.0), 0.1, 0.01, $00, $01, $00, $00, $00)
                                        local5\Field4 = 0.003
                                        local5\Field7 = 0.005
                                        local5\Field13 = 90000.0
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                        local5 = createdecal($00, entityx(local3\Field1\Field14[$00]\Field2, $01), (entityy(local3\Field1\Field14[$00]\Field2, $01) + 0.005), entityz(local3\Field1\Field14[$00]\Field2, $01), 90.0, ((Float local3\Field1\Field6) + 360.0), rnd(360.0, 0.0), 0.1, 0.01, $00, $01, $00, $00, $00)
                                        local5\Field4 = 0.003
                                        local5\Field7 = 0.005
                                        local5\Field13 = 90000.0
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                        tformpoint(0.0, 0.0, 585.0, local3\Field1\Field2, $00)
                                        positionentity(n_i\Field3\Field3, tformedx(), 0.0, tformedz(), $01)
                                        resetentity(n_i\Field3\Field3)
                                        n_i\Field3\Field10 = 3.0
                                        n_i\Field3\Field11 = 0.0
                                        n_i\Field3\Field12 = rnd(3000.0, 3500.0)
                                        freeentity(local3\Field1\Field11[$00])
                                        local3\Field1\Field11[$00] = $00
                                        local3\Field2 = 1.0
                                    EndIf
                                EndIf
                            Else
                                event_resetprev()
                                local38 = distancesquared(entityx(me\Field60, $00), entityx(local3\Field1\Field14[$00]\Field2, $00), entityz(me\Field60, $00), entityz(local3\Field1\Field14[$00]\Field2, $00), 0.0, 0.0)
                                If ((((0.16 > local38) And (0.0 < local3\Field1\Field14[$00]\Field8)) And (chs\Field2 = $00)) <> 0) Then
                                    If (0.0 = local3\Field3) Then
                                        playsound_strict(loadtempsound("SFX\Room\SinkholeFall.ogg"), $00)
                                    EndIf
                                    local3\Field3 = min((local3\Field3 + (fps\Field7[$00] / 200.0)), 2.0)
                                    me\Field50 = min((local3\Field3 * 5.0), 10.0)
                                    If (0.2 <= local3\Field3) Then
                                        me\Field10 = -10.0
                                        If (3.0 = n_i\Field3\Field10) Then
                                            n_i\Field3\Field24 = 0.0
                                        EndIf
                                    EndIf
                                    me\Field49 = (local3\Field3 * 500.0)
                                    If (2.0 = local3\Field3) Then
                                        mp_movetopocketdimension()
                                    EndIf
                                EndIf
                            EndIf
                        Else
                            local3\Field3 = 0.0
                        EndIf
                    Else
                        removeevent(local3)
                    EndIf
                ElseIf (7.0 > local3\Field18) Then
                    If (i_005\Field0 = $03) Then
                        tformpoint(375.0, 52.0, -875.0, local3\Field1\Field2, $00)
                        local1 = createnpc($14, tformedx(), tformedy(), tformedz())
                        local1\Field10 = 8.0
                        local1\Field50 = $01
                        setnpcframe(local1, 287.0, $01)
                        rotateentity(local1\Field3, 0.0, ((Float local3\Field1\Field6) + 90.0), 0.0, $01)
                        tformpoint(382.0, 150.0, -875.0, local3\Field1\Field2, $00)
                        local5 = createdecal($03, tformedx(), tformedy(), tformedz(), 0.0, ((Float local3\Field1\Field6) + 270.0), 0.0, 0.3, 1.0, $00, $01, $00, $00, $00)
                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                    Else
                        tformpoint(-296.0, 52.0, -240.0, local3\Field1\Field2, $00)
                        local1 = createnpc($14, tformedx(), tformedy(), tformedz())
                        local1\Field10 = 8.0
                        local1\Field50 = $01
                        setnpcframe(local1, 288.0, $01)
                        rotateentity(local1\Field3, 0.0, ((Float local3\Field1\Field6) + 125.0), 0.0, $01)
                    EndIf
                    removeevent(local3)
                EndIf
            Case $16
                If (event_isplayerinroom(local3) <> 0) Then
                    If (-37.10938 > entityy(me\Field60, $00)) Then
                        If (0.0 = local3\Field2) Then
                            tformpoint(-2260.0, -10632.0, 1000.0, local3\Field1\Field2, $00)
                            local1 = createnpc($14, tformedx(), tformedy(), tformedz())
                            local1\Field10 = 8.0
                            local1\Field50 = $01
                            setnpcframe(local1, 288.0, $01)
                            rotateentity(local1\Field3, 0.0, ((Float local3\Field1\Field6) + 180.0), 0.0, $01)
                            tformpoint(-2220.0, -10688.0, 1000.0, local3\Field1\Field2, $00)
                            local5 = createdecal($03, tformedx(), (tformedy() + 0.005), tformedz(), 90.0, rnd(360.0, 0.0), 0.0, 0.5, 1.0, $00, $01, $00, $00, $00)
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                            tformpoint(-897.0, -10534.0, 783.0, local3\Field1\Field2, $00)
                            local11 = createitem("Document SCP-079", $00, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                            entitytype(local11\Field2, $03, $00)
                            local3\Field2 = 1.0
                        EndIf
                        If (entityhidden(local3\Field1\Field11[$00]) <> 0) Then
                            showentity(local3\Field1\Field11[$00])
                        EndIf
                        shouldplay = $04
                        If (remotedooron <> 0) Then
                            local3\Field1\Field14[$00]\Field4 = $02
                        Else
                            local3\Field1\Field14[$00]\Field4 = $00
                            If (1.0 = local3\Field2) Then
                                If (9.0 > entitydistancesquared(local3\Field1\Field11[$00], me\Field60)) Then
                                    giveachievement("079", $01)
                                    If (local3\Field6 <> $00) Then
                                        stopstream_strict(local3\Field6)
                                        local3\Field6 = $00
                                        local3\Field11 = $00
                                    EndIf
                                    local3\Field6 = streamsound_strict("SFX\SCP\079\Speech.ogg", (opt\Field21 * opt\Field16), $00)
                                    local3\Field11 = $01
                                    local3\Field2 = 2.0
                                    local3\Field3 = 1.0
                                EndIf
                            ElseIf (2.0 <= local3\Field2) Then
                                local3\Field2 = (local3\Field2 + fps\Field7[$00])
                                If (5000.0 < local3\Field2) Then
                                    If (6.25 > entitydistancesquared(local3\Field1\Field11[$00], me\Field60)) Then
                                        If (local3\Field6 <> $00) Then
                                            stopstream_strict(local3\Field6)
                                            local3\Field6 = $00
                                            local3\Field11 = $00
                                        EndIf
                                        local3\Field6 = streamsound_strict("SFX\SCP\079\Refuse.ogg", (opt\Field21 * opt\Field16), $00)
                                        local3\Field11 = $01
                                        local3\Field2 = 1.5
                                    EndIf
                                EndIf
                            EndIf
                            If (local3\Field6 <> $00) Then
                                If (isstreamplaying_strict(local3\Field6) <> 0) Then
                                    If (rand($04, $01) = $01) Then
                                        entitytexture(local3\Field1\Field11[$01], mon_i\Field1[rand($06, $0B)], $00, $00)
                                        If (entityhidden(local3\Field1\Field11[$01]) <> 0) Then
                                            showentity(local3\Field1\Field11[$01])
                                        EndIf
                                    ElseIf (rand($0A, $01) = $01) Then
                                        If (entityhidden(local3\Field1\Field11[$01]) = $00) Then
                                            hideentity(local3\Field1\Field11[$01])
                                        EndIf
                                    EndIf
                                Else
                                    stopstream_strict(local3\Field6)
                                    local3\Field6 = $00
                                    local3\Field11 = $00
                                EndIf
                            ElseIf (1.0 < local3\Field2) Then
                                If (entityhidden(local3\Field1\Field11[$01]) <> 0) Then
                                    showentity(local3\Field1\Field11[$01])
                                EndIf
                                entitytexture(local3\Field1\Field11[$01], mon_i\Field1[$05], $00, $00)
                            EndIf
                        EndIf
                    ElseIf (entityhidden(local3\Field1\Field11[$00]) = $00) Then
                        hideentity(local3\Field1\Field11[$00])
                    EndIf
                    local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$01], local3\Field1\Field14[$02], local3\Field1\Field11[$02], local3\Field1\Field11[$03], local3, $01, $00, $00)
                EndIf
                If (1.0 = local3\Field3) Then
                    If (remotedooron <> 0) Then
                        If (local3\Field6 <> $00) Then
                            stopstream_strict(local3\Field6)
                            local3\Field6 = $00
                            local3\Field11 = $00
                        EndIf
                        local3\Field6 = streamsound_strict("SFX\SCP\079\GateB.ogg", (opt\Field21 * opt\Field16), $00)
                        local3\Field11 = $01
                        For local4 = Each events
                            If (((local4\Field0 = $2B) Lor (local4\Field0 = $2D)) <> 0) Then
                                local4\Field4 = 1.0
                            EndIf
                        Next
                        local3\Field3 = 2.0
                    EndIf
                EndIf
            Case $17
                If (((soundtransmission Lor (2500.0 <= (local3\Field4 + fps\Field7[$00]))) And (1.0 = local3\Field2)) <> 0) Then
                    local3\Field4 = min((local3\Field4 + fps\Field7[$00]), 4000.0)
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    If (local3\Field1\Field15[$00] <> Null) Then
                        local3\Field23 = (event_ismeinroom(local3) And (-26.95312 > entityy(event_getmypivot(), $00)))
                        If (local3\Field23 <> 0) Then
                            shouldplay = $19
                            me\Field59 = $01
                        EndIf
                        If (-26.95312 > mp_findlowestplayery(local3\Field1)) Then
                            If ((soundtransmission And (channelplaying(local3\Field7) = $00)) <> 0) Then
                                local3\Field7 = playsound_strict(snd_i\Field36, $00)
                            EndIf
                            local23 = (Int local3\Field3)
                            local52 = (Float updatelever(local3\Field1\Field13[$00]\Field0, ((-32.49219 > entityy(local3\Field1\Field11[$01], $01)) And (-33.60547 < entityy(local3\Field1\Field11[$01], $01))), $50, -80.0))
                            local3\Field3 = local52
                            If ((Float local23) <> local3\Field3) Then
                                If (0.0 = local3\Field3) Then
                                    playsound_strict(snd_i\Field21, $00)
                                Else
                                    playsound_strict(snd_i\Field20, $00)
                                EndIf
                            EndIf
                            local23 = updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0)
                            If (soundtransmission <> local23) Then
                                If (soundtransmission <> 0) Then
                                    If (channelplaying(local3\Field6) <> 0) Then
                                        channelvolume(local3\Field6, 0.0)
                                    Else
                                        local3\Field6 = $00
                                    EndIf
                                    If (channelplaying(local3\Field7) <> 0) Then
                                        channelvolume(local3\Field7, 0.0)
                                    Else
                                        local3\Field7 = $00
                                    EndIf
                                Else
                                    channelvolume(local3\Field6, (opt\Field21 * opt\Field16))
                                    channelvolume(local3\Field7, (opt\Field21 * opt\Field16))
                                EndIf
                                soundtransmission = local23
                            EndIf
                            If (0.0 = local3\Field2) Then
                                If ((soundtransmission And (rand($64, $01) = $01)) <> 0) Then
                                    If (channelplaying(local3\Field6) = $00) Then
                                        mp_loadeventsound(local3, (("SFX\Character\LureSubject\Idle" + (Str rand($00, $05))) + ".ogg"), $01)
                                        local3\Field6 = playsound_strict(local3\Field9, $01)
                                    EndIf
                                EndIf
                                If (soundtransmission <> 0) Then
                                    updatebutton(local3\Field1\Field11[$00])
                                    If (((d_i\Field9 = local3\Field1\Field11[$00]) And mo\Field0) <> 0) Then
                                        mp_interactobject(local3\Field1, $00, 1000.0, $00, $00)
                                    EndIf
                                EndIf
                            ElseIf (1.0 = local3\Field2) Then
                                If ((soundtransmission And (2000.0 > local3\Field4)) <> 0) Then
                                    If (channelplaying(local3\Field6) = $00) Then
                                        mp_loadeventsound(local3, "SFX\Character\LureSubject\Sniffling.ogg", $01)
                                        local3\Field6 = playsound_strict(local3\Field9, $01)
                                    EndIf
                                EndIf
                                If (((0.0 < local3\Field4) And (400.0 > local3\Field4)) <> 0) Then
                                    animateex(local3\Field1\Field11[$05], animtime(local3\Field1\Field11[$05]), $01, $78, 0.35, $00)
                                ElseIf (2500.0 <= local3\Field4) Then
                                    If (((1.0 = local3\Field3) And (2500.0 > (local3\Field4 - fps\Field7[$00]))) <> 0) Then
                                        positionentity(n_i\Field3\Field3, entityx(local3\Field1\Field11[$01], $01), entityy(local3\Field1\Field11[$01], $01), entityz(local3\Field1\Field11[$01], $01), $00)
                                        resetentity(n_i\Field3\Field3)
                                        showentity(n_i\Field3\Field0)
                                        n_i\Field3\Field65 = $00
                                        n_i\Field3\Field26 = 0.0
                                        n_i\Field3\Field10 = 3.0
                                        n_i\Field3\Field11 = 0.0
                                        n_i\Field3\Field12 = rnd(3000.0, 3500.0)
                                        local3\Field2 = 2.0
                                        Exit
                                    EndIf
                                    shouldplay = $0A
                                    positionentity(n_i\Field3\Field3, entityx(local3\Field1\Field15[$00]\Field0, $01), ((((min((local3\Field4 - 2500.0), 800.0) / 320.0) * 108.0) + -6628.0) * (1.0 / 256.0)), entityz(local3\Field1\Field15[$00]\Field0, $01), $00)
                                    resetentity(n_i\Field3\Field3)
                                    rotateentity(n_i\Field3\Field3, 0.0, (entityyaw(local3\Field1\Field15[$00]\Field0, $01) + 180.0), 0.0, $01)
                                    n_i\Field3\Field36 = entityx(local3\Field1\Field15[$00]\Field0, $01)
                                    n_i\Field3\Field37 = ((((min((local3\Field4 - 2500.0), 800.0) / 320.0) * 108.0) + -6628.0) * (1.0 / 256.0))
                                    n_i\Field3\Field38 = entityz(local3\Field1\Field15[$00]\Field0, $01)
                                    n_i\Field3\Field10 = 2.0
                                    n_i\Field3\Field26 = 1.0
                                    animatenpc(n_i\Field3, 206.0, 250.0, 0.1, $01)
                                    If (2500.0 > (local3\Field4 - fps\Field7[$00])) Then
                                        local5 = createdecal($00, entityx(local3\Field1\Field15[$00]\Field0, $01), (local3\Field1\Field4 - 24.96875), entityz(local3\Field1\Field15[$00]\Field0, $01), 90.0, 0.0, rnd(360.0, 0.0), 0.1, 0.01, $00, $01, $00, $00, $00)
                                        local5\Field13 = 90000.0
                                        local5\Field7 = 0.005
                                        local5\Field4 = 0.003
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                        If (channelplaying(local3\Field6) <> 0) Then
                                            stopchannel(local3\Field6)
                                            local3\Field6 = $00
                                        EndIf
                                        mp_loadeventsound(local3, "SFX\Character\LureSubject\106Bait.ogg", $01)
                                        local3\Field6 = playsound_strict(local3\Field9, $01)
                                    ElseIf (((2900.0 > (local3\Field4 - fps\Field7[$00])) And (2900.0 <= local3\Field4)) <> 0) Then
                                        If (snd_i\Field22 <> $00) Then
                                            freesound_strict(snd_i\Field22)
                                            snd_i\Field22 = $00
                                        EndIf
                                        local5 = createdecal($00, entityx(local3\Field1\Field16[$00]\Field1, $01), entityy(local3\Field1\Field16[$00]\Field1, $01), entityz(local3\Field1\Field16[$00]\Field1, $01), 0.0, 0.0, 0.0, 0.05, 0.01, $00, $01, $00, $00, $00)
                                        local5\Field13 = 90000.0
                                        local5\Field7 = 0.005
                                        local5\Field4 = 0.002
                                        rotateentity(local5\Field0, entitypitch(local3\Field1\Field16[$00]\Field1, $01), (entityyaw(local3\Field1\Field16[$00]\Field1, $01) + 30.0), entityroll(local5\Field0, $00), $00)
                                        moveentity(local5\Field0, 0.0, 0.05, 0.2)
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                    ElseIf (3200.0 < local3\Field4) Then
                                        If (1.0 = local3\Field3) Then
                                            n_i\Field3\Field10 = 0.0
                                            n_i\Field3\Field11 = rnd(22000.0, 27000.0)
                                            n_i\Field3\Field65 = $01
                                        Else
                                            positionentity(n_i\Field3\Field3, entityx(local3\Field1\Field11[$01], $01), entityy(local3\Field1\Field11[$01], $01), entityz(local3\Field1\Field11[$01], $01), $00)
                                            resetentity(n_i\Field3\Field3)
                                            showentity(n_i\Field3\Field0)
                                            n_i\Field3\Field65 = $00
                                            n_i\Field3\Field26 = 0.0
                                            n_i\Field3\Field10 = 3.0
                                            n_i\Field3\Field11 = 0.0
                                            n_i\Field3\Field12 = rnd(3000.0, 3500.0)
                                            local3\Field2 = 2.0
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If ((Int local3\Field3) <> 0) Then
                                positionentity(local3\Field1\Field11[$01], entityx(local3\Field1\Field11[$01], $01), curvevalue(((sin(((Float millisec) * 0.04)) * 0.07) + -32.45312), entityy(local3\Field1\Field11[$01], $01), 200.0), entityz(local3\Field1\Field11[$01], $01), $01)
                                rotateentity(local3\Field1\Field11[$01], sin(((Float millisec) * 0.03)), entityyaw(local3\Field1\Field11[$01], $01), (- sin(((Float millisec) * 0.025))), $01)
                            Else
                                positionentity(local3\Field1\Field11[$01], entityx(local3\Field1\Field11[$01], $01), curvevalue(-33.625, entityy(local3\Field1\Field11[$01], $01), 200.0), entityz(local3\Field1\Field11[$01], $01), $01)
                                rotateentity(local3\Field1\Field11[$01], 0.0, entityyaw(local3\Field1\Field11[$01], $01), 0.0, $01)
                            EndIf
                        EndIf
                    Else
                        tformpoint(1088.0, -6222.0, 1824.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($13, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$00]\Field12 = -1.0
                        local3\Field1\Field15[$00]\Field50 = $01
                        local3\Field1\Field15[$00]\Field43 = $01
                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 180.0), 0.0, $01)
                        setnpcframe(local3\Field1\Field15[$00], 17.0, $01)
                    EndIf
                    local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$00], local3\Field1\Field14[$01], local3\Field1\Field11[$02], local3\Field1\Field11[$03], local3, $01, $00, $00)
                Else
                    event_resetprev()
                    If (playerinreachableroom($01, $00) = $00) Then
                        If (channelplaying(local3\Field6) <> 0) Then
                            stopchannel(local3\Field6)
                            local3\Field6 = $00
                        EndIf
                        If (channelplaying(local3\Field7) <> 0) Then
                            stopchannel(local3\Field7)
                            local3\Field7 = $00
                        EndIf
                    EndIf
                EndIf
            Case $05
                If (event_isplayerinroom(local3) <> 0) Then
                    If (((0.0 = local3\Field2) Lor (local3\Field13 <> "LoadDone")) <> 0) Then
                        If (((local3\Field13 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local3
                            local3\Field13 = "Load0"
                        EndIf
                        If ((local3\Field1\Field14[$01]\Field6 Lor local3\Field1\Field14[$02]\Field6) <> 0) Then
                            giveachievement("205", $01)
                            tformpoint(-1055.0, -74.8, 650.0, local3\Field1\Field2, $00)
                            local1 = createnpc($12, tformedx(), tformedy(), tformedz())
                            local1\Field12 = -1.0
                            local1\Field50 = $01
                            changenpctextureid(local1, $10)
                            setnpcframe(local1, 40.0, $01)
                            rotateentity(local1\Field3, 0.0, ((Float local3\Field1\Field6) - 180.0), 0.0, $01)
                            local3\Field2 = 1.0
                        EndIf
                    Else
                        If (event_ismeinroom(local3) <> 0) Then
                            shouldplay = $0F
                        EndIf
                        local23 = updatelever(local3\Field1\Field13[$00]\Field0, ((7.0 < local3\Field2) Lor ((0.0 < local3\Field1\Field14[$00]\Field8) And (180.0 > local3\Field1\Field14[$00]\Field8))), $50, -80.0)
                        If (65.0 > local3\Field2) Then
                            If (((7.0 < local3\Field2) And remotedooron) <> 0) Then
                                rotateentity(local3\Field1\Field13[$00]\Field0, curveangle((80.0 - ((Float local3\Field1\Field14[$00]\Field6) * 160.0)), entitypitch(local3\Field1\Field13[$00]\Field0, $00), 10.0), entityyaw(local3\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                                If (rand(((local3\Field1\Field14[$00]\Field6 * $96) + $96), $01) = $01) Then
                                    If (local3\Field1\Field14[$00]\Field6 <> 0) Then
                                        playsoundex(snd_i\Field3, camera, local3\Field1\Field14[$00]\Field2, 7.0, 1.0, $00, $00)
                                    Else
                                        playsoundex(snd_i\Field4, camera, local3\Field1\Field14[$00]\Field2, 7.0, 1.0, $00, $00)
                                    EndIf
                                    openclosedoor(local3\Field1\Field14[$00], $01, $00)
                                EndIf
                            ElseIf (local23 <> 0) Then
                                If (local3\Field1\Field14[$00]\Field6 = $00) Then
                                    openclosedoor(local3\Field1\Field14[$00], $01, $00)
                                EndIf
                            ElseIf (local3\Field1\Field14[$00]\Field6 <> 0) Then
                                openclosedoor(local3\Field1\Field14[$00], $01, $00)
                            EndIf
                            If (((4.0 > distancesquared(entityx(me\Field60, $00), entityx(local3\Field1\Field11[$01], $01), entityz(me\Field60, $00), entityz(local3\Field1\Field11[$01], $01), 0.0, 0.0)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                playsound_strict(loadtempsound("SFX\SCP\205\Enter.ogg"), $00)
                                local3\Field2 = max(local3\Field2, 65.0)
                                For local20 = $02 To $04 Step $01
                                    If (entityhidden(local3\Field1\Field11[local20]) <> 0) Then
                                        showentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                                If (entityhidden(local3\Field1\Field11[$05]) = $00) Then
                                    hideentity(local3\Field1\Field11[$05])
                                EndIf
                                setanimtime(local3\Field1\Field11[$02], 492.0, $00)
                                setanimtime(local3\Field1\Field11[$03], 434.0, $00)
                                setanimtime(local3\Field1\Field11[$04], 434.0, $00)
                                If (remotedooron <> 0) Then
                                    If (local3\Field1\Field14[$00]\Field6 = $00) Then
                                        openclosedoor(local3\Field1\Field14[$00], $01, $00)
                                    EndIf
                                EndIf
                            EndIf
                            local3\Field3 = (local3\Field3 + fps\Field7[$00])
                        EndIf
                        Select local3\Field2
                            Case 1.0
                                If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                For local20 = $02 To $04 Step $01
                                    If (entityhidden(local3\Field1\Field11[local20]) = $00) Then
                                        hideentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                                If (entityhidden(local3\Field1\Field11[$05]) <> 0) Then
                                    showentity(local3\Field1\Field11[$05])
                                EndIf
                                animateex(local3\Field1\Field11[$05], animtime(local3\Field1\Field11[$05]), $20E, $212, 0.2, $01)
                                If (1400.0 < local3\Field3) Then
                                    local3\Field2 = (local3\Field2 + 1.0)
                                EndIf
                            Case 3.0
                                If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                For local20 = $02 To $04 Step $01
                                    If (entityhidden(local3\Field1\Field11[local20]) = $00) Then
                                        hideentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                                If (entityhidden(local3\Field1\Field11[$05]) <> 0) Then
                                    showentity(local3\Field1\Field11[$05])
                                EndIf
                                animateex(local3\Field1\Field11[$05], animtime(local3\Field1\Field11[$05]), $179, $20D, 0.2, $01)
                                If (2100.0 < local3\Field3) Then
                                    local3\Field2 = (local3\Field2 + 1.0)
                                EndIf
                            Case 5.0
                                If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                For local20 = $02 To $04 Step $01
                                    If (entityhidden(local3\Field1\Field11[local20]) = $00) Then
                                        hideentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                                If (entityhidden(local3\Field1\Field11[$05]) <> 0) Then
                                    showentity(local3\Field1\Field11[$05])
                                EndIf
                                animateex(local3\Field1\Field11[$05], animtime(local3\Field1\Field11[$05]), $E4, $178, 0.2, $01)
                                If (2800.0 < local3\Field3) Then
                                    playsoundex(loadtempsound("SFX\SCP\205\Horror.ogg"), camera, local3\Field1\Field11[$05], 10.0, 0.3, $00, $00)
                                    local3\Field2 = (local3\Field2 + 1.0)
                                EndIf
                            Case 7.0
                                If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                For local20 = $02 To $05 Step $01
                                    If (local20 < $04) Then
                                        If (entityhidden(local3\Field1\Field11[local20]) = $00) Then
                                            hideentity(local3\Field1\Field11[local20])
                                        EndIf
                                    ElseIf (entityhidden(local3\Field1\Field11[local20]) <> 0) Then
                                        showentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                                animateex(local3\Field1\Field11[$04], animtime(local3\Field1\Field11[$04]), $1F4, $288, 0.2, $01)
                                If (4200.0 < local3\Field3) Then
                                    playsoundex(loadtempsound("SFX\SCP\205\Horror.ogg"), camera, local3\Field1\Field11[$05], 10.0, 0.5, $00, $00)
                                    local3\Field2 = (local3\Field2 + 1.0)
                                EndIf
                            Case 9.0
                                If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                If (entityhidden(local3\Field1\Field11[$02]) = $00) Then
                                    hideentity(local3\Field1\Field11[$02])
                                EndIf
                                For local20 = $03 To $05 Step $01
                                    If (entityhidden(local3\Field1\Field11[local20]) <> 0) Then
                                        showentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                                animateex(local3\Field1\Field11[$03], animtime(local3\Field1\Field11[$03]), $02, $C8, 0.2, $01)
                                animateex(local3\Field1\Field11[$04], animtime(local3\Field1\Field11[$04]), $04, $7D, 0.2, $01)
                                If (5600.0 < local3\Field3) Then
                                    playsound_strict(loadtempsound("SFX\SCP\205\Horror.ogg"), $00)
                                    local3\Field2 = (local3\Field2 + 1.0)
                                EndIf
                            Case 11.0
                                If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                For local20 = $02 To $04 Step $01
                                    If (entityhidden(local3\Field1\Field11[local20]) <> 0) Then
                                        showentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                                animateex(local3\Field1\Field11[$02], animtime(local3\Field1\Field11[$02]), $02, $E2, 0.2, $01)
                                animateex(local3\Field1\Field11[$03], animtime(local3\Field1\Field11[$03]), $02, $C8, 0.2, $01)
                                animateex(local3\Field1\Field11[$04], animtime(local3\Field1\Field11[$04]), $04, $7D, 0.2, $01)
                                If (5950.0 < local3\Field3) Then
                                    local3\Field2 = (local3\Field2 + 1.0)
                                EndIf
                            Case 13.0
                                If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                For local20 = $02 To $04 Step $01
                                    If (entityhidden(local3\Field1\Field11[local20]) <> 0) Then
                                        showentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                                If (227.0 <> animtime(local3\Field1\Field11[$05])) Then
                                    setanimtime(local3\Field1\Field11[$05], 227.0, $00)
                                EndIf
                                animateex(local3\Field1\Field11[$02], animtime(local3\Field1\Field11[$02]), $02, $1EB, 0.05, $01)
                                animateex(local3\Field1\Field11[$03], animtime(local3\Field1\Field11[$03]), $C5, $1B1, 0.05, $01)
                                animateex(local3\Field1\Field11[$04], animtime(local3\Field1\Field11[$04]), $02, $1B1, 0.05, $01)
                            Case 66.0
                                If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                animateex(local3\Field1\Field11[$02], animtime(local3\Field1\Field11[$02]), $1EC, $216, 0.1, $00)
                                animateex(local3\Field1\Field11[$03], animtime(local3\Field1\Field11[$03]), $1B2, $1D2, 0.1, $00)
                                animateex(local3\Field1\Field11[$04], animtime(local3\Field1\Field11[$04]), $1B2, $1EE, 0.1, $00)
                                If (515.0 < animtime(local3\Field1\Field11[$02])) Then
                                    If (entityhidden(local3\Field1\Field16[$00]\Field4) = $00) Then
                                        hideentity(local3\Field1\Field16[$00]\Field4)
                                    EndIf
                                    local3\Field2 = 67.0
                                    local3\Field3 = 0.0
                                    local3\Field4 = 0.0
                                EndIf
                            Case 67.0
                                event_resetprev()
                                If (((7.0 > distancesquared(entityx(me\Field60, $00), entityx(local3\Field1\Field11[$01], $01), entityz(me\Field60, $00), entityz(local3\Field1\Field11[$01], $01), 0.0, 0.0)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                    If (rand($64, $01) = $01) Then
                                        injureplayer(rnd(0.3, 0.6), 0.0, 300.0, 0.12, 0.06)
                                        playsound_strict(snd_i\Field51[rand($02, $03)], $00)
                                        me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 0.5)
                                        local3\Field3 = rnd(-0.1, 0.1)
                                        local3\Field4 = rnd(-0.1, 0.1)
                                        If (5.0 < me\Field31) Then
                                            msg\Field2 = format(getlocalstring("death", "205"), subjectname, "%s")
                                            kill($01, $01, $00, $01)
                                        EndIf
                                    EndIf
                                EndIf
                                translateentity(me\Field60, local3\Field3, 0.0, local3\Field4, $00)
                                local3\Field3 = curvevalue(local3\Field3, 0.0, 10.0)
                                local3\Field4 = curvevalue(local3\Field4, 0.0, 10.0)
                            Default
                                If (rand($03, $01) = $01) Then
                                    If (entityhidden(local3\Field1\Field16[$00]\Field4) = $00) Then
                                        hideentity(local3\Field1\Field16[$00]\Field4)
                                    EndIf
                                ElseIf (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                    showentity(local3\Field1\Field16[$00]\Field4)
                                EndIf
                                local3\Field4 = (local3\Field4 + fps\Field7[$00])
                                If (50.0 < local3\Field4) Then
                                    If (entityhidden(local3\Field1\Field16[$00]\Field4) <> 0) Then
                                        showentity(local3\Field1\Field16[$00]\Field4)
                                    EndIf
                                    local3\Field2 = (local3\Field2 + 1.0)
                                    local3\Field4 = 0.0
                                EndIf
                        End Select
                    EndIf
                ElseIf (local3\Field1\Field11[$02] <> $00) Then
                    For local20 = $02 To $04 Step $01
                        If (entityhidden(local3\Field1\Field11[local20]) = $00) Then
                            hideentity(local3\Field1\Field11[local20])
                        EndIf
                    Next
                EndIf
            Case $13
                If (event_isplayerinroom(local3) <> 0) Then
                    If (local3\Field1\Field14[$00]\Field6 <> 0) Then
                        playsound_strict(snd_i\Field27[rand($00, $05)], $00)
                        createnpc($08, 0.0, 0.0, 0.0)
                        removeevent(local3)
                    EndIf
                EndIf
            Case $18
                If ((Float millisecs()) > local3\Field2) Then
                    If (((playerroom\Field7\Field6 <> $04) And (playerroom\Field7\Field6 <> $03)) <> 0) Then
                        If (0.0 > entitypitch(local3\Field1\Field13[$00]\Field0, $01)) Then
                            For local13 = Each securitycams
                                If (local13\Field18 = $00) Then
                                    local13\Field18 = $02
                                EndIf
                            Next
                        Else
                            For local13 = Each securitycams
                                If (local13\Field18 <> $01) Then
                                    local13\Field18 = $00
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local3\Field2 = (Float (millisecs() + $BB8))
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    If (event_ismeinroom(local3) <> 0) Then
                        me\Field59 = $01
                    EndIf
                    coffindistance = entitydistance(me\Field60, local3\Field1\Field11[$00])
                    If (2.0 > coffindistance) Then
                        giveachievement("895", $01)
                        If (local3\Field1\Field15[$00] = Null) Then
                            local3\Field1\Field15[$00] = createnpc($14, local3\Field1\Field3, local3\Field1\Field4, local3\Field1\Field5)
                            local3\Field1\Field15[$00]\Field10 = 8.0
                            local3\Field1\Field15[$00]\Field48 = 0.0
                            local3\Field1\Field15[$00]\Field9 = 0.0
                            local3\Field1\Field15[$00]\Field17 = loadsound_strict((("SFX\Room\895Chamber\GuardIdle" + (Str rand($00, $02))) + ".ogg"))
                            local3\Field1\Field15[$00]\Field18 = playsoundex(local3\Field1\Field15[$00]\Field17, camera, local3\Field1\Field15[$00]\Field3, 10.0, 1.0, $01, $00)
                            rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 90.0), 0.0, $00)
                            setnpcframe(local3\Field1\Field15[$00], 270.0, $01)
                            local3\Field1\Field14[$00]\Field6 = $01
                        EndIf
                        If ((((n_i\Field3\Field65 = $00) And (2.0 > n_i\Field3\Field10)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                            If (0.0 = local3\Field3) Then
                                tformpoint(0.0, -1531.0, 2356.0, local3\Field1\Field2, $00)
                                n_i\Field3\Field36 = tformedx()
                                n_i\Field3\Field37 = tformedy()
                                n_i\Field3\Field38 = tformedz()
                                n_i\Field3\Field10 = 2.0
                                local3\Field3 = 1.0
                            EndIf
                        EndIf
                    ElseIf (6.0 < coffindistance) Then
                        If (local3\Field1\Field15[$00] <> Null) Then
                            If (local3\Field1\Field15[$00]\Field13 = $00) Then
                                stopchannel(local3\Field1\Field15[$00]\Field18)
                                local3\Field1\Field15[$00]\Field18 = $00
                                mp_loadnpcsound(local3\Field1\Field15[$00], (("SFX\Room\895Chamber\GuardScream" + (Str rand($00, $02))) + ".ogg"), $00)
                                local3\Field1\Field15[$00]\Field18 = playsoundex(local3\Field1\Field15[$00]\Field17, camera, local3\Field1\Field15[$00]\Field3, 100.0, 1.0, $01, $00)
                                local3\Field1\Field15[$00]\Field11 = 0.0
                                local3\Field1\Field15[$00]\Field13 = $01
                            EndIf
                        EndIf
                    EndIf
                    If (local3\Field1\Field15[$00] <> Null) Then
                        If (((local3\Field1\Field15[$00]\Field13 <> $02) And (local3\Field1\Field15[$00]\Field13 <> $01)) <> 0) Then
                            updatesoundorigin(local3\Field1\Field15[$00]\Field18, camera, local3\Field1\Field15[$00]\Field3, 100.0, 1.0, $01, $01)
                        EndIf
                        If (local3\Field1\Field15[$00]\Field13 = $00) Then
                            local3\Field1\Field15[$00]\Field48 = 0.0
                        ElseIf (local3\Field1\Field15[$00]\Field13 = $01) Then
                            If (70.0 > local3\Field1\Field15[$00]\Field11) Then
                                local3\Field1\Field15[$00]\Field11 = (local3\Field1\Field15[$00]\Field11 + fps\Field7[$00])
                                local3\Field1\Field15[$00]\Field48 = 0.0
                            Else
                                local3\Field1\Field15[$00]\Field48 = 1.0
                            EndIf
                            If (-5.630469 < entityy(local3\Field1\Field15[$00]\Field3, $00)) Then
                                local38 = entitydistancesquared(me\Field60, local3\Field1\Field15[$00]\Field3)
                                If (0.64 > local38) Then
                                    local47 = ((sqr(local38) - 0.8) * (sqr(local38) - 0.8))
                                    local26 = pointdirection(entityx(me\Field60, $01), entityz(me\Field60, $01), entityx(local3\Field1\Field15[$00]\Field3, $01), entityz(local3\Field1\Field15[$00]\Field3, $01))
                                    translateentity(me\Field60, (cos(((- local26) + 90.0)) * local47), 0.0, (sin(((- local26) + 90.0)) * local47), $00)
                                EndIf
                                If (0.6 < entityy(local3\Field1\Field15[$00]\Field3, $00)) Then
                                    entitytype(local3\Field1\Field15[$00]\Field3, $00, $00)
                                EndIf
                            Else
                                local3\Field2 = (local3\Field2 + fps\Field7[$00])
                                animatenpc(local3\Field1\Field15[$00], 270.0, 286.0, 0.4, $00)
                                If ((event_ismeinroom(local3) And (local3\Field6 = $00)) <> 0) Then
                                    local3\Field6 = playsound_strict(loadtempsound("SFX\Character\BodyFall.ogg"), $00)
                                    local5 = createdecal($03, local3\Field1\Field3, (local3\Field1\Field4 - 5.980469), local3\Field1\Field5, 90.0, rnd(360.0, 0.0), 0.0, 0.4, 1.0, $00, $01, $00, $00, $00)
                                    entityparent(local5\Field0, local3\Field1\Field2, $01)
                                EndIf
                                If (286.0 = local3\Field1\Field15[$00]\Field14) Then
                                    local11 = createitem("Unknown Note", $00, local3\Field1\Field3, (local3\Field1\Field4 - 5.921875), local3\Field1\Field5, $00, $00, $00, 1.0, $00)
                                    entitytype(local11\Field2, $03, $00)
                                    local11 = createitem("Bloody Level 3 Key Card", $5C, local3\Field1\Field3, (local3\Field1\Field4 - 5.875), local3\Field1\Field5, $00, $00, $00, 1.0, $00)
                                    entitytype(local11\Field2, $03, $00)
                                    local3\Field1\Field15[$00]\Field50 = $01
                                    local3\Field1\Field15[$00]\Field13 = $02
                                EndIf
                            EndIf
                            If (local3\Field1\Field15[$00]\Field20 = $00) Then
                                local3\Field1\Field15[$00]\Field19 = loadsound_strict("SFX\Room\895Chamber\GuardRadio.ogg")
                                local3\Field1\Field15[$00]\Field20 = loopsoundex(local3\Field1\Field15[$00]\Field19, local3\Field1\Field15[$00]\Field20, camera, local3\Field1\Field15[$00]\Field3, 5.0, 1.0, $00)
                            EndIf
                        ElseIf (local3\Field1\Field15[$00]\Field13 = $02) Then
                            If (channelplaying(local3\Field1\Field15[$00]\Field18) = $00) Then
                                If (local3\Field1\Field15[$00]\Field17 <> $00) Then
                                    freesound_strict(local3\Field1\Field15[$00]\Field17)
                                    local3\Field1\Field15[$00]\Field17 = $00
                                EndIf
                                stopchannel(local3\Field1\Field15[$00]\Field18)
                                local3\Field1\Field15[$00]\Field18 = $00
                            EndIf
                            If (local3\Field1\Field15[$00]\Field19 = $00) Then
                                local3\Field1\Field15[$00]\Field19 = loadsound_strict("SFX\Room\895Chamber\GuardRadio.ogg")
                            EndIf
                            local3\Field1\Field15[$00]\Field20 = loopsoundex(local3\Field1\Field15[$00]\Field19, local3\Field1\Field15[$00]\Field20, camera, local3\Field1\Field15[$00]\Field3, 5.0, 1.0, $00)
                        EndIf
                    EndIf
                    If (((event_ismeinroom(local3) And (wi\Field5 > $00)) Lor (wi\Field9 > $00)) <> 0) Then
                        event_resetprev()
                        local54 = $00
                        For local20 = $00 To (maxitemamount - $01) Step $01
                            If (inventory(local20) <> Null) Then
                                If ((((wi\Field5 > $00) And (((inventory(local20)\Field4\Field2 = $40) Lor (inventory(local20)\Field4\Field2 = $41)) Lor (inventory(local20)\Field4\Field2 = $42))) Lor (((wi\Field9 = $01) And (inventory(local20)\Field4\Field2 = $43)) Lor ((wi\Field9 = $02) And (inventory(local20)\Field4\Field2 = $44)))) <> 0) Then
                                    If (((0.0 < inventory(local20)\Field12) Lor ((wi\Field5 = $03) And (inventory(local20)\Field4\Field2 = $42))) <> 0) Then
                                        local54 = $01
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If ((((4.0 > entitydistance(me\Field60, local3\Field1\Field11[$00])) And local54) And (i_714\Field0 <> $02)) <> 0) Then
                            turnentity(me\Field60, 0.0, (angledist(((pointdirection(entityx(me\Field60, $01), entityz(me\Field60, $01), entityx(local3\Field1\Field11[$00], $01), entityz(local3\Field1\Field11[$00], $01)) + 90.0) + sin(wrapangle((local3\Field4 / 10.0), 360.0))), entityyaw(me\Field60, $00)) / 4.0), 0.0, $01)
                            camerapitch = (((clamp(((2.0 - distance(entityx(me\Field60, $01), entityx(local3\Field1\Field11[$00], $01), entityz(me\Field60, $01), entityz(local3\Field1\Field11[$00], $01), 0.0, 0.0)) / 2.0), 0.0, 1.0) * -60.0) * 0.2) + (camerapitch * 0.8))
                            me\Field5 = (me\Field5 - (((fps\Field7[$00] * (((Float selecteddifficulty\Field4) * 0.24) + 1.2)) / (Float (wi\Field5 + wi\Field9))) / ((Float i_714\Field0) + 1.0)))
                            me\Field6 = $00
                            me\Field49 = (sin((Float (millisec / $0A))) * (Abs me\Field5))
                            If (-1000.0 > me\Field5) Then
                                If (wi\Field5 > $01) Then
                                    local24 = "895.nvg.914"
                                ElseIf (wi\Field9 > $00) Then
                                    local24 = "895.nvg.096"
                                Else
                                    local24 = "895.nvg"
                                EndIf
                                msg\Field2 = getlocalstring("death", local24)
                                entitytexture(t\Field3[$04], t\Field2[$01], $00, $00)
                                If (-10.0 > me\Field26) Then
                                    kill($00, $01, $00, $01)
                                EndIf
                            ElseIf (-800.0 > me\Field5) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(t\Field3[$04], t\Field2[$01], $00, $00)
                                EndIf
                                If (rand($06, $01) < $05) Then
                                    entitytexture(t\Field3[$04], mon_i\Field1[rand($0C, $10)], $00, $00)
                                    For local20 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local20) <> Null) Then
                                            If ((((wi\Field5 > $00) And (((inventory(local20)\Field4\Field2 = $40) Lor (inventory(local20)\Field4\Field2 = $41)) Lor (inventory(local20)\Field4\Field2 = $42))) Lor (((wi\Field9 = $01) And (inventory(local20)\Field4\Field2 = $43)) Lor ((wi\Field9 = $02) And (inventory(local20)\Field4\Field2 = $44)))) <> 0) Then
                                                If (1.0 = inventory(local20)\Field13) Then
                                                    playsound_strict(snd_i\Field47[$01], $00)
                                                EndIf
                                                inventory(local20)\Field13 = 2.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                me\Field49 = 1000.0
                                If (0.0 = me\Field26) Then
                                    me\Field26 = 1.0
                                EndIf
                            ElseIf (-500.0 > me\Field5) Then
                                If (rand($07, $01) = $01) Then
                                    entitytexture(t\Field3[$04], t\Field2[$01], $00, $00)
                                EndIf
                                If (rand($32, $01) = $01) Then
                                    entitytexture(t\Field3[$04], mon_i\Field1[rand($0C, $10)], $00, $00)
                                    For local20 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local20) <> Null) Then
                                            If ((((wi\Field5 > $00) And (((inventory(local20)\Field4\Field2 = $40) Lor (inventory(local20)\Field4\Field2 = $41)) Lor (inventory(local20)\Field4\Field2 = $42))) Lor (((wi\Field9 = $01) And (inventory(local20)\Field4\Field2 = $43)) Lor ((wi\Field9 = $02) And (inventory(local20)\Field4\Field2 = $44)))) <> 0) Then
                                                If (0.0 = inventory(local20)\Field13) Then
                                                    playsound_strict(snd_i\Field47[$00], $00)
                                                EndIf
                                                inventory(local20)\Field13 = 1.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            Else
                                entitytexture(t\Field3[$04], t\Field2[$01], $00, $00)
                                For local20 = $00 To (maxitemamount - $01) Step $01
                                    If (inventory(local20) <> Null) Then
                                        If ((((wi\Field5 > $00) And (((inventory(local20)\Field4\Field2 = $40) Lor (inventory(local20)\Field4\Field2 = $41)) Lor (inventory(local20)\Field4\Field2 = $42))) Lor (((wi\Field9 = $01) And (inventory(local20)\Field4\Field2 = $43)) Lor ((wi\Field9 = $02) And (inventory(local20)\Field4\Field2 = $44)))) <> 0) Then
                                            inventory(local20)\Field13 = 0.0
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            If (-800.0 > me\Field5) Then
                                me\Field5 = -1010.0
                            EndIf
                        EndIf
                    EndIf
                    If (0.0 < local3\Field4) Then
                        local3\Field4 = max((local3\Field4 - fps\Field7[$00]), 0.0)
                    EndIf
                    If (0.0 = local3\Field4) Then
                        entitytexture(t\Field3[$04], t\Field2[$01], $00, $00)
                        local3\Field4 = -1.0
                    EndIf
                    If (event_ismeinroom(local3) <> 0) Then
                        shouldplay = $42
                    EndIf
                    turnoffsecuritycam(local3\Field1, (updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0) = $00))
                EndIf
            Case $06
                If ((event_isplayerinroom(local3) Lor (local3\Field6 <> $00)) <> 0) Then
                    event_resetprev()
                    updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                    If ((local3\Field1\Field14[$02]\Field6 Lor (0.0 > entitypitch(local3\Field1\Field13[$00]\Field0, $00))) <> 0) Then
                        giveachievement("914", $01)
                        local3\Field3 = 1.0
                    EndIf
                    If (local3\Field1\Field14[$02]\Field4 = $01) Then
                        local3\Field1\Field14[$02]\Field4 = (updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0) = $00)
                    Else
                        updatelever(local3\Field1\Field13[$01]\Field0, $01, $50, -80.0)
                    EndIf
                    If ((event_ismeinroom(local3) And (1.0 = local3\Field3)) <> 0) Then
                        shouldplay = $15
                    EndIf
                    If (local3\Field6 = $00) Then
                        If (0.64 > entitydistancesquared(me\Field60, local3\Field1\Field11[$00])) Then
                            entitypick(camera, 0.8)
                            For local20 = $00 To $01 Step $01
                                If (pickedentity() = local3\Field1\Field11[local20]) Then
                                    handentity = local3\Field1\Field11[local20]
                                    If ((mo\Field0 Lor mo\Field2) <> 0) Then
                                        grabbedentity = local3\Field1\Field11[local20]
                                    EndIf
                                    Exit
                                EndIf
                            Next
                            For local20 = $00 To $01 Step $01
                                If (grabbedentity = local3\Field1\Field11[local20]) Then
                                    If (entityinview(local3\Field1\Field11[local20], camera) = $00) Then
                                        grabbedentity = $00
                                    EndIf
                                    Exit
                                EndIf
                            Next
                        Else
                            For local20 = $00 To $01 Step $01
                                If (grabbedentity = local3\Field1\Field11[local20]) Then
                                    grabbedentity = $00
                                    Exit
                                EndIf
                            Next
                        EndIf
                        If (grabbedentity = local3\Field1\Field11[$00]) Then
                            handentity = local3\Field1\Field11[$00]
                            turnentity(grabbedentity, 0.0, 0.0, ((- mo\Field7) * 2.5), $00)
                        EndIf
                        local37 = wrapangle(entityroll(local3\Field1\Field11[$00], $00), 360.0)
                        If (grabbedentity = local3\Field1\Field11[$00]) Then
                            drawarrowicon[$03] = (181.0 < local37)
                            drawarrowicon[$01] = $01
                        EndIf
                        If (90.0 > local37) Then
                            rotateentity(local3\Field1\Field11[$00], 0.0, 0.0, 361.0, $00)
                        ElseIf (180.0 > local37) Then
                            rotateentity(local3\Field1\Field11[$00], 0.0, 0.0, 180.0, $00)
                        EndIf
                        If (((181.0 > local37) And (90.0 < local37)) <> 0) Then
                            local3\Field6 = playsoundex(snd_i\Field59, camera, local3\Field1\Field11[$01], 10.0, 1.0, $00, $01)
                            local3\Field1\Field14[$01]\Field17 = playsoundex(loadtempsound("SFX\SCP\914\DoorClose.ogg"), camera, local3\Field1\Field14[$01]\Field0, 10.0, 1.0, $00, $00)
                            setanimtime(local3\Field1\Field11[$07], 1.0, $00)
                            local3\Field2 = 1.0
                        EndIf
                        If (grabbedentity = local3\Field1\Field11[$01]) Then
                            handentity = local3\Field1\Field11[$01]
                            turnentity(grabbedentity, 0.0, 0.0, ((- mo\Field7) * 2.5), $00)
                            drawarrowicon[$03] = $01
                            drawarrowicon[$01] = $01
                        EndIf
                        local37 = wrapangle(entityroll(local3\Field1\Field11[$01], $00), 360.0)
                        If (90.0 < local37) Then
                            If (180.0 > local37) Then
                                rotateentity(local3\Field1\Field11[$01], 0.0, 0.0, 90.0, $00)
                            ElseIf (270.0 > local37) Then
                                rotateentity(local3\Field1\Field11[$01], 0.0, 0.0, 270.0, $00)
                            EndIf
                        EndIf
                        If (grabbedentity = local3\Field1\Field11[$01]) Then
                            local55 = floor(entityroll(local3\Field1\Field11[$01], $00))
                            If (((((((-94.0 < local55) And (-86.0 > local55)) Lor ((-44.0 < local55) And (-36.0 > local55))) Lor ((-4.0 < local55) And (4.0 > local55))) Lor ((36.0 < local55) And (44.0 > local55))) Lor ((86.0 < local55) And (94.0 > local55))) <> 0) Then
                                If (local3\Field7 = $00) Then
                                    local3\Field7 = playsoundex(snd_i\Field31[rand($00, $01)], camera, local3\Field1\Field11[$01], 2.0, 0.5, $00, $00)
                                EndIf
                            Else
                                local3\Field7 = $00
                            EndIf
                        EndIf
                    EndIf
                    If (grabbedentity <> local3\Field1\Field11[$01]) Then
                        local37 = wrapangle(entityroll(local3\Field1\Field11[$01], $00), 360.0)
                        If (22.5 > local37) Then
                            local37 = 0.0
                            local56 = $00
                        ElseIf (67.5 > local37) Then
                            local37 = 40.0
                            local56 = $FFFFFFFF
                        ElseIf (180.0 > local37) Then
                            local37 = 90.0
                            local56 = $FFFFFFFE
                        ElseIf (337.5 < local37) Then
                            local37 = -1.0
                            local56 = $00
                        ElseIf (292.5 < local37) Then
                            local37 = -40.0
                            local56 = $01
                        Else
                            local37 = -90.0
                            local56 = $02
                        EndIf
                        rotateentity(local3\Field1\Field11[$01], 0.0, 0.0, curvevalue(local37, entityroll(local3\Field1\Field11[$01], $00), 20.0), $00)
                    EndIf
                    If (local3\Field6 <> $00) Then
                        If (0.0 < local3\Field2) Then
                            local57 = 318.7
                            local58 = 300.0
                            local59 = 126.9
                            local3\Field2 = (local3\Field2 + fps\Field7[$00])
                            If (n_i\Field3\Field65 = $00) Then
                                If (0.0 < n_i\Field3\Field11) Then
                                    n_i\Field3\Field11 = (n_i\Field3\Field11 - (fps\Field7[$00] * ((Float selecteddifficulty\Field2) + 1.0)))
                                EndIf
                            EndIf
                            local3\Field1\Field14[$01]\Field6 = $00
                            If (140.0 < local3\Field2) Then
                                If (local3\Field1\Field14[$00]\Field6 <> 0) Then
                                    local3\Field1\Field14[$00]\Field17 = playsoundex(loadtempsound("SFX\SCP\914\DoorClose.ogg"), camera, local3\Field1\Field14[$00]\Field0, 10.0, 1.0, $00, $00)
                                EndIf
                                local3\Field1\Field14[$00]\Field6 = $00
                            EndIf
                            tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local3\Field1\Field2)
                            local60 = ((isequal(tformedx(), entityx(local3\Field1\Field11[$02], $00), local57) And isequal(tformedy(), entityy(local3\Field1\Field11[$02], $00), local58)) And isequal(tformedz(), entityz(local3\Field1\Field11[$02], $00), local59))
                            If (local60 <> 0) Then
                                If (((local56 = $FFFFFFFE) Lor (local56 = $FFFFFFFF)) <> 0) Then
                                    If (((182.0 < local3\Field2) And (182.0 > (local3\Field2 - fps\Field7[$01]))) <> 0) Then
                                        playsound_strict(snd_i\Field29, $00)
                                    EndIf
                                EndIf
                                If (210.0 < local3\Field2) Then
                                    Select local56
                                        Case $FFFFFFFE
                                            kill($01, $01, $00, $01)
                                            msg\Field2 = format(getlocalstring("death", "914"), subjectname, "%s")
                                        Case $FFFFFFFF,$00,$01,$02
                                            If (210.0 > (local3\Field2 - fps\Field7[$01])) Then
                                                playsound_strict(snd_i\Field28, $00)
                                            EndIf
                                    End Select
                                    me\Field10 = -10.0
                                EndIf
                            EndIf
                            If (420.0 < local3\Field2) Then
                                rotateentity(local3\Field1\Field11[$00], entitypitch(local3\Field1\Field11[$00], $00), entityyaw(local3\Field1\Field11[$00], $00), curveangle(0.0, entityroll(local3\Field1\Field11[$00], $00), 10.0), $00)
                            Else
                                rotateentity(local3\Field1\Field11[$00], entitypitch(local3\Field1\Field11[$00], $00), entityyaw(local3\Field1\Field11[$00], $00), 180.0, $00)
                            EndIf
                            If (((((12.0 - (Float (mp_ishoster() = $00))) * 70.0) < local3\Field2) And (channelplaying(local3\Field1\Field14[$00]\Field17) = $00)) <> 0) Then
                                If (local60 <> 0) Then
                                    Select local56
                                        Case $FFFFFFFF
                                            me\Field31 = 4.0
                                            createmsg(getlocalstring("msg", "914"), 6.0)
                                        Case $00
                                            opt\Field43 = (opt\Field43 = $00)
                                            opt\Field44 = (opt\Field44 = $00)
                                        Case $01,$02
                                            chs\Field6 = $01
                                    End Select
                                    me\Field49 = 1000.0
                                    positionentity(me\Field60, entityx(local3\Field1\Field11[$03], $01), (entityy(local3\Field1\Field11[$03], $01) + 1.0), entityz(local3\Field1\Field11[$03], $01), $00)
                                    resetentity(me\Field60)
                                    me\Field36 = 0.0
                                EndIf
                                For local11 = Each items
                                    If (((local11\Field2 <> $00) And (local11\Field15 = $00)) <> 0) Then
                                        tformpoint(entityx(local11\Field2, $00), entityy(local11\Field2, $00), entityz(local11\Field2, $00), $00, local3\Field1\Field2)
                                        If (((isequal(tformedx(), entityx(local3\Field1\Field11[$02], $00), local57) And isequal(tformedy(), entityy(local3\Field1\Field11[$02], $00), local58)) And isequal(tformedz(), entityz(local3\Field1\Field11[$02], $00), local59)) <> 0) Then
                                            use914(local11, local56, entityx(local3\Field1\Field11[$03], $01), entityy(local3\Field1\Field11[$03], $01), entityz(local3\Field1\Field11[$03], $01))
                                        EndIf
                                    EndIf
                                Next
                                If (mp_ishoster() <> 0) Then
                                    local3\Field1\Field14[$00]\Field6 = $01
                                    local3\Field1\Field14[$01]\Field6 = $01
                                    rotateentity(local3\Field1\Field11[$00], 0.0, 0.0, 0.0, $00)
                                EndIf
                                local63 = loadtempsound("SFX\SCP\914\DoorOpen.ogg")
                                local3\Field1\Field14[$00]\Field17 = playsoundex(local63, camera, local3\Field1\Field14[$00]\Field0, 10.0, 1.0, $00, $00)
                                local3\Field1\Field14[$01]\Field17 = playsoundex(local63, camera, local3\Field1\Field14[$01]\Field0, 10.0, 1.0, $00, $00)
                                local3\Field2 = 0.0
                            EndIf
                        EndIf
                        If (channelplaying(local3\Field6) <> 0) Then
                            updatesoundorigin(local3\Field6, camera, local3\Field1\Field11[$01], 10.0, 1.0, $00, $01)
                            animateex(local3\Field1\Field11[$07], animtime(local3\Field1\Field11[$07]), $01, $4A, 0.3, (0.0 <> local3\Field2))
                        Else
                            local3\Field6 = $00
                        EndIf
                    ElseIf (local3\Field1\Field14[$00]\Field6 = $00) Then
                        local3\Field1\Field14[$00]\Field6 = $01
                        local3\Field1\Field14[$01]\Field6 = $01
                        rotateentity(local3\Field1\Field11[$00], 0.0, 0.0, 0.0, $00)
                    EndIf
                EndIf
                If (12.0 > local3\Field18) Then
                    If (0.0 > entitypitch(local3\Field1\Field13[$00]\Field0, $00)) Then
                        local3\Field4 = min((local3\Field4 + fps\Field7[$00]), 212.0)
                    Else
                        local3\Field4 = max((local3\Field4 - fps\Field7[$00]), 0.0)
                    EndIf
                    If (12.0 > local3\Field1\Field8) Then
                        If (((0.0 < local3\Field4) And (212.0 > local3\Field4)) <> 0) Then
                            If (channelplaying(local3\Field10) = $00) Then
                                local3\Field10 = loopsoundex(snd_i\Field61, local3\Field10, camera, local3\Field1\Field11[$06], 10.0, 1.0, $00)
                            EndIf
                        Else
                            stopchannel(local3\Field10)
                            local3\Field10 = $00
                        EndIf
                        positionentity(local3\Field1\Field11[$05], 0.0, local3\Field4, 0.0, $00)
                    EndIf
                EndIf
            Case $23
                If (event_isplayerinroom(local3) <> 0) Then
                    If (92.7 <= i_008\Field0) Then
                        If (entityhidden(local3\Field1\Field11[$0A]) <> 0) Then
                            showentity(local3\Field1\Field11[$0A])
                        EndIf
                        shouldplay = $1F
                    ElseIf (entityhidden(local3\Field1\Field11[$0A]) = $00) Then
                        hideentity(local3\Field1\Field11[$0A])
                    EndIf
                    local3\Field23 = (event_ismeinroom(local3) And (-17.5625 > entityy(event_getmypivot(), $00)))
                    If (((-17.5625 > entityy(me\Field60, $00)) Lor local3\Field23) <> 0) Then
                        If (local3\Field23 <> 0) Then
                            giveachievement("008", $01)
                            shouldplay = $1E
                            me\Field59 = $01
                        EndIf
                        If (0.0 = local3\Field2) Then
                            If (((0.0 = n_i\Field2\Field26) And (36.0 < entitydistancesquared(n_i\Field2\Field3, me\Field60))) <> 0) Then
                                positionentity(n_i\Field2\Field3, entityx(local3\Field1\Field11[$04], $01), entityy(local3\Field1\Field11[$04], $01), entityz(local3\Field1\Field11[$04], $01), $01)
                                resetentity(n_i\Field2\Field3)
                            EndIf
                            local3\Field2 = 1.0
                        ElseIf (1.0 = local3\Field2) Then
                            If (0.0 = local3\Field3) Then
                                For local20 = $02 To $03 Step $01
                                    If (entityhidden(local3\Field1\Field11[local20]) <> 0) Then
                                        showentity(local3\Field1\Field11[local20])
                                    EndIf
                                Next
                            EndIf
                            local3\Field6 = loopsoundex(snd_i\Field50[$00], local3\Field6, camera, local3\Field1\Field11[$00], 5.0, 1.0, $00)
                            updateredlight(local3\Field1\Field11[$05], 1500.0, 800.0)
                            If (4.5 > entitydistancesquared(me\Field60, local3\Field1\Field11[$00])) Then
                                For local20 = $00 To $01 Step $01
                                    local3\Field1\Field14[local20]\Field4 = $01
                                Next
                                If (0.0 = local3\Field3) Then
                                    If (9.0 > entitydistancesquared(n_i\Field2\Field3, local3\Field1\Field11[$04])) Then
                                        If (mp_somebodysees173(n_i\Field2) = $00) Then
                                            tformpoint(-448.0, -4985.0, 752.0, local3\Field1\Field2, $00)
                                            positionentity(n_i\Field2\Field3, tformedx(), tformedy(), tformedz(), $01)
                                            resetentity(n_i\Field2\Field3)
                                            For local20 = $02 To $03 Step $01
                                                translateentity(local3\Field1\Field11[local20], 0.0, -1000.0, 0.0, $00)
                                            Next
                                            If (wi\Field2 = $00) Then
                                                playsound_strict(loadtempsound("SFX\SCP\008\IamInfected.ogg"), $00)
                                                injureplayer(0.3, 0.001, 500.0, 0.0, 0.0)
                                                createmsg(getlocalstring("msg", "008.173"), 6.0)
                                            EndIf
                                            local3\Field7 = playsoundex(loadtempsound("SFX\Room\GlassBreak.ogg"), camera, local3\Field1\Field11[$00], 10.0, 1.0, $00, $00)
                                            local3\Field3 = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If (4.5 > entitydistancesquared(event_getmypivot(), local3\Field1\Field11[$00])) Then
                                event_resetprev()
                                If (mp_interactobject(local3\Field1, $01, 0.8, $01, $00) <> 0) Then
                                    drawarrowicon[$02] = $01
                                    rotateentity(local3\Field1\Field11[$01], clamp((clamp((- mo\Field8), -10.0, 10.0) + entitypitch(local3\Field1\Field11[$01], $00)), 35.0, 89.0), entityyaw(local3\Field1\Field11[$01], $00), 0.0, $00)
                                    grabbedentity = local3\Field1\Field11[$01]
                                EndIf
                                If (0.0 = i_008\Field0) Then
                                    If (((0.0 < me\Field32) Lor (wi\Field0 = $00)) <> 0) Then
                                        injureplayer(0.0, 0.001, 0.0, 0.0, 0.0)
                                    EndIf
                                EndIf
                                If (((wi\Field0 = $00) And (wi\Field2 = $00)) <> 0) Then
                                    me\Field14 = max(70.0, me\Field14)
                                EndIf
                            EndIf
                            If (40.0 > entitypitch(local3\Field1\Field11[$01], $01)) Then
                                playsound_strict(snd_i\Field32, $00)
                                freeemitter(local3\Field1\Field17[$00], $00)
                                local3\Field2 = 2.0
                            ElseIf (local3\Field1\Field17[$00] = Null) Then
                                local3\Field1\Field17[$00] = setemitter(local3\Field1, entityx(local3\Field1\Field11[$00], $01), entityy(local3\Field1\Field11[$00], $01), entityz(local3\Field1\Field11[$00], $01), $09)
                                local3\Field1\Field17[$00]\Field11 = $02
                            EndIf
                        Else
                            If (entityhidden(local3\Field1\Field11[$05]) = $00) Then
                                hideentity(local3\Field1\Field11[$05])
                            EndIf
                            If (2.0 > local3\Field3) Then
                                For local20 = $00 To $03 Step $01
                                    local3\Field1\Field14[local20]\Field4 = $00
                                Next
                                openclosedoor(local3\Field1\Field14[$02], $01, $00)
                                tformpoint(-456.0, -5052.8, -688.0, local3\Field1\Field2, $00)
                                local1 = createnpc($00, tformedx(), tformedy(), tformedz())
                                local1\Field10 = 3.0
                                local3\Field3 = 2.0
                            ElseIf (local3\Field1\Field17[$00] <> Null) Then
                                freeemitter(local3\Field1\Field17[$00], $00)
                            EndIf
                            rotateentity(local3\Field1\Field11[$01], curveangle(0.0, entitypitch(local3\Field1\Field11[$01], $01), 15.0), entityyaw(local3\Field1\Field11[$01], $01), 0.0, $01)
                        EndIf
                    ElseIf (1.0 = local3\Field2) Then
                        local3\Field2 = 0.0
                    EndIf
                    local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$04], local3\Field1\Field14[$05], local3\Field1\Field11[$08], local3\Field1\Field11[$09], local3, $01, $00, $00)
                ElseIf (entityhidden(local3\Field1\Field11[$0A]) = $00) Then
                    hideentity(local3\Field1\Field11[$0A])
                EndIf
            Case $0E
                If ((event_ismeinroom(local3) Lor event_issomebodyinroom(local3)) <> 0) Then
                    local3\Field1\Field14[$00]\Field4 = remotedooron
                    If (local3\Field8 = $00) Then
                        If (6.25 > entitydistancesquared(me\Field60, local3\Field1\Field14[$00]\Field0)) Then
                            If (((0.0 <= me\Field3) And remotedooron) <> 0) Then
                                giveachievement("012", $01)
                                If (event_ismeinroom(local3) <> 0) Then
                                    playsound_strict(snd_i\Field47[$07], $00)
                                EndIf
                                playsoundex(snd_i\Field32, camera, local3\Field1\Field14[$00]\Field0, 10.0, 1.0, $00, $00)
                                If (local3\Field1\Field14[$00]\Field6 = $00) Then
                                    openclosedoor(local3\Field1\Field14[$00], $01, $00)
                                EndIf
                                local3\Field2 = 1.0
                                local3\Field8 = loadsound_strict("SFX\Music\012Golgotha.ogg")
                            EndIf
                        EndIf
                    Else
                        local3\Field2 = curvevalue(90.0, local3\Field2, 500.0)
                        positionentity(local3\Field1\Field11[$00], entityx(local3\Field1\Field11[$00], $01), ((-130.0 - (sin(local3\Field2) * 448.0)) * (1.0 / 256.0)), entityz(local3\Field1\Field11[$00], $01), $01)
                        rotateentity(local3\Field1\Field13[$00]\Field0, curveangle(-80.0, entitypitch(local3\Field1\Field13[$00]\Field0, $00), 10.0), entityyaw(local3\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                        updateredlight(local3\Field1\Field11[$01], 1500.0, 800.0)
                        If (0.0 > entityy(me\Field60, $00)) Then
                            local3\Field6 = loopsoundex(local3\Field8, local3\Field6, camera, local3\Field1\Field11[$00], 10.0, 1.0, $00)
                        Else
                            stopchannel(local3\Field6)
                            local3\Field6 = $00
                        EndIf
                        If (((((i_714\Field0 <> $02) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) And (0.0 = me\Field0)) <> 0) Then
                            If (((-800.0 > me\Field5) And (0.0 = local3\Field4)) <> 0) Then
                                tformpoint(-360.0, -700.0, 330.0, local3\Field1\Field2, $00)
                                positionentity(me\Field60, tformedx(), tformedy(), tformedz(), $01)
                                rotateentity(me\Field60, 0.0, (Float local3\Field1\Field6), 0.0, $01)
                                resetentity(me\Field60)
                                me\Field50 = 5.0
                                me\Field10 = -10.0
                                local3\Field4 = 1.0
                            EndIf
                            If (entityvisible(local3\Field1\Field11[$00], camera) <> 0) Then
                                me\Field6 = $00
                                shouldplay = $20
                                local25 = createpivot($00)
                                positionentity(local25, entityx(camera, $00), (entityy(local3\Field1\Field11[$00], $01) - 0.05), entityz(camera, $00), $00)
                                pointentity(local25, local3\Field1\Field11[$00], 0.0)
                                rotateentity(me\Field60, entitypitch(me\Field60, $00), curveangle(entityyaw(local25, $00), entityyaw(me\Field60, $00), (80.0 - (local3\Field3 / 200.0))), 0.0, $00)
                                turnentity(local25, 90.0, 0.0, 0.0, $00)
                                camerapitch = curveangle((entitypitch(local25, $00) + 25.0), (camerapitch + 90.0), (80.0 - (local3\Field3 / 200.0)))
                                camerapitch = (camerapitch - 90.0)
                                local38 = distancesquared(entityx(me\Field60, $00), entityx(local3\Field1\Field11[$00], $01), entityz(me\Field60, $00), entityz(local3\Field1\Field11[$00], $01), 0.0, 0.0)
                                local47 = sqr(local38)
                                me\Field28 = 150.0
                                me\Field30 = (max((3.0 - local47), 0.0) / 3.0)
                                local45 = (sin(((Float millisec) / 20.0)) + 1.0)
                                me\Field48 = max((((2.0 - local47) * (local3\Field3 / 800.0)) * local45), me\Field48)
                                me\Field52 = max(me\Field52, ((local45 * 8.0) * max((3.0 - local47), 0.0)))
                                stopbreathsound()
                                If (0.36 > local38) Then
                                    If (-800.0 > me\Field5) Then
                                        makemeunplayable()
                                    EndIf
                                    me\Field5 = max((me\Field5 - ((fps\Field7[$00] * (((Float selecteddifficulty\Field4) * 0.2) + 1.0)) / ((Float i_714\Field0) + 1.0))), -1000.0)
                                    If (1.0 = local3\Field4) Then
                                        local3\Field3 = min((local3\Field3 + fps\Field7[$00]), 6020.0)
                                    EndIf
                                    If (((70.0 < local3\Field3) And (70.0 >= (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                        local3\Field7 = playsound_strict(loadtempsound("SFX\SCP\012\Speech0.ogg"), $01)
                                    ElseIf (((910.0 < local3\Field3) And (910.0 >= (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                        createmsg(getlocalstring("msg", "012_1"), 8.0)
                                        me\Field31 = (me\Field31 + 0.5)
                                        local3\Field7 = playsound_strict(loadtempsound("SFX\SCP\012\Speech1.ogg"), $01)
                                    ElseIf (((2170.0 < local3\Field3) And (2170.0 >= (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                        local28 = loadtexture_strict("GFX\Map\Textures\scp_012(2).png", $01, $00, $01)
                                        entitytexture(local3\Field1\Field11[$03], local28, $00, $00)
                                        deletesingletextureentryfromcache(local28, $00)
                                        local28 = $00
                                        createmsg(getlocalstring("msg", "012_2"), 8.0)
                                        me\Field31 = max(me\Field31, 1.5)
                                        local3\Field7 = playsound_strict(loadtempsound((("SFX\SCP\012\Speech" + (Str rand($02, $03))) + ".ogg")), $01)
                                    ElseIf (((3430.0 < local3\Field3) And (3430.0 >= (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                        createmsg(getlocalstring("msg", "012_3"), 8.0)
                                        me\Field31 = (me\Field31 + 0.3)
                                        local3\Field7 = playsound_strict(loadtempsound("SFX\SCP\012\Speech4.ogg"), $01)
                                    ElseIf (((4410.0 < local3\Field3) And (4410.0 >= (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                        local28 = loadtexture_strict("GFX\Map\Textures\scp_012(3).png", $01, $00, $01)
                                        entitytexture(local3\Field1\Field11[$03], local28, $00, $00)
                                        deletesingletextureentryfromcache(local28, $00)
                                        local28 = $00
                                        me\Field31 = (me\Field31 + 0.5)
                                        local3\Field7 = playsound_strict(loadtempsound("SFX\SCP\012\Speech5.ogg"), $01)
                                    ElseIf (((5180.0 < local3\Field3) And (5180.0 >= (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                        local28 = loadtexture_strict("GFX\Map\Textures\scp_012(4).png", $01, $00, $01)
                                        entitytexture(local3\Field1\Field11[$03], local28, $00, $00)
                                        deletesingletextureentryfromcache(local28, $00)
                                        local28 = $00
                                        createmsg(getlocalstring("msg", "012_4"), 8.0)
                                        me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.0)
                                        me\Field31 = (me\Field31 + 0.8)
                                        local3\Field7 = playsound_strict(loadtempsound("SFX\SCP\012\Speech6.ogg"), $01)
                                        playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\BodyHorrorExchange" + (Str rand($00, $03))) + ".ogg")), $00)
                                        If (me\Field39 = $00) Then
                                            setcrouch($01)
                                        EndIf
                                        local5 = createdecal($07, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 1.0, $00, $01, $00, $00, $00)
                                        local5\Field5 = 0.45
                                        local5\Field4 = 0.0002
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                    ElseIf (((5950.0 < local3\Field3) And (5950.0 >= (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                        msg\Field2 = format(getlocalstring("death", "012"), subjectname, "%s")
                                        kill($01, $01, $00, $01)
                                        local3\Field3 = 0.0
                                    EndIf
                                    rotateentity(me\Field60, entitypitch(me\Field60, $00), curveangle(((sin((local3\Field3 * (local3\Field3 / 2000.0))) * (local3\Field3 / 300.0)) + entityyaw(me\Field60, $00)), entityyaw(me\Field60, $00), 80.0), 0.0, $00)
                                Else
                                    me\Field5 = max((me\Field5 - ((fps\Field7[$00] * (((Float selecteddifficulty\Field4) * 0.12) + 0.6)) / ((Float i_714\Field0) + 1.0))), -1000.0)
                                    local37 = wrapangle((entityyaw(local25, $00) - entityyaw(me\Field60, $00)), 360.0)
                                    If (40.0 > local37) Then
                                        me\Field7 = ((40.0 - local37) * 0.02)
                                    ElseIf (310.0 < local37) Then
                                        me\Field7 = ((40.0 - (Abs (360.0 - local37))) * 0.02)
                                    EndIf
                                EndIf
                                freeentity(local25)
                                local25 = $00
                            ElseIf (((21.25 > distancesquared(entityx(me\Field60, $00), entityx(local3\Field1\Field14[$00]\Field2, $00), entityz(me\Field60, $00), entityz(local3\Field1\Field14[$00]\Field2, $00), 0.0, 0.0)) And (-2.5 > entityy(me\Field60, $00))) <> 0) Then
                                cansave = $00
                                me\Field5 = max((me\Field5 - ((fps\Field7[$00] * (((Float selecteddifficulty\Field4) * 0.08) + 0.4)) / ((Float i_714\Field0) + 1.0))), -1000.0)
                                me\Field6 = $00
                                local25 = createpivot($00)
                                positionentity(local25, entityx(camera, $00), entityy(me\Field60, $00), entityz(camera, $00), $00)
                                pointentity(local25, local3\Field1\Field14[$00]\Field2, 0.0)
                                camerapitch = curveangle(90.0, (camerapitch + 90.0), 100.0)
                                camerapitch = (camerapitch - 90.0)
                                rotateentity(me\Field60, entitypitch(me\Field60, $00), curveangle(entityyaw(local25, $00), entityyaw(me\Field60, $00), 150.0), 0.0, $00)
                                local37 = wrapangle((entityyaw(local25, $00) - entityyaw(me\Field60, $00)), 360.0)
                                If (40.0 > local37) Then
                                    me\Field7 = ((40.0 - local37) * 0.008)
                                ElseIf (310.0 < local37) Then
                                    me\Field7 = ((40.0 - (Abs (360.0 - local37))) * 0.008)
                                EndIf
                                freeentity(local25)
                                local25 = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $24
                If (event_isplayerinroom(local3) <> 0) Then
                    local3\Field23 = (event_ismeinroom(local3) And (-11.125 >= entityy(event_getmypivot(), $00)))
                    local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$00], local3\Field1\Field14[$01], local3\Field1\Field11[$00], local3\Field1\Field11[$01], local3, $01, $00, $00)
                    local3\Field26 = mp_updateelevators(local3\Field26, local3\Field1\Field14[$02], local3\Field1\Field14[$03], local3\Field1\Field11[$02], local3\Field1\Field11[$03], local3, $01, $00, $00)
                    local64 = (0.0 > entitypitch(local3\Field1\Field13[$01]\Field0, $01))
                    local23 = updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                    local34 = (Float updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0))
                    If (((local3\Field1\Field15[$00] <> Null) And ((local23 And (Int local34)) = $00)) <> 0) Then
                        local3\Field1\Field14[$01]\Field4 = $01
                        local3\Field1\Field14[$03]\Field4 = $01
                    EndIf
                    If (((-11.125 >= entityy(me\Field60, $00)) Lor local3\Field23) <> 0) Then
                        If (local3\Field23 <> 0) Then
                            shouldplay = $18
                            me\Field59 = $01
                        EndIf
                        If (local3\Field1\Field15[$00] = Null) Then
                            tformpoint(528.0, -3440.0, 96.0, local3\Field1\Field2, $00)
                            local1 = createnpc($03, tformedx(), tformedy(), tformedz())
                            pointentity(local1\Field3, local3\Field1\Field2, 0.0)
                            turnentity(local1\Field3, 0.0, (Float local3\Field1\Field6), 0.0, $00)
                            tformpoint(64.0, -3440.0, -1000.0, local3\Field1\Field2, $00)
                            local1 = createnpc($03, tformedx(), tformedy(), tformedz())
                            pointentity(local1\Field3, local3\Field1\Field2, 0.0)
                            turnentity(local1\Field3, 0.0, ((Float local3\Field1\Field6) + 60.0), 0.0, $00)
                            tformpoint(528.0, -2672.0, 96.0, local3\Field1\Field2, $00)
                            If (n_i\Field6 <> Null) Then
                                local3\Field1\Field15[$00] = n_i\Field6
                                local3\Field1\Field15[$00]\Field10 = 2.0
                                local3\Field1\Field15[$00]\Field26 = 1.0
                                local3\Field1\Field15[$00]\Field43 = $01
                                positionentity(local3\Field1\Field15[$00]\Field3, tformedx(), tformedy(), tformedz(), $00)
                                resetentity(local3\Field1\Field15[$00]\Field3)
                                pointentity(local3\Field1\Field15[$00]\Field3, local3\Field1\Field2, 0.0)
                            Else
                                n_i\Field6 = createnpc($02, tformedx(), tformedy(), tformedz())
                                n_i\Field6\Field10 = 2.0
                                n_i\Field6\Field26 = 1.0
                                n_i\Field6\Field43 = $01
                                pointentity(n_i\Field6\Field3, local3\Field1\Field2, 0.0)
                                local3\Field1\Field15[$00] = n_i\Field6
                            EndIf
                            local3\Field6 = playsound_strict(loadtempsound("SFX\Room\Blackout.ogg"), $00)
                            If (entitydistancesquared(local3\Field1\Field11[$03], me\Field60) > entitydistancesquared(local3\Field1\Field11[$01], me\Field60)) Then
                                tformpoint(2720.0, -3516.0, 1824.0, local3\Field1\Field2, $00)
                                local11 = createitem("Research Sector-02 Scheme", $00, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                            Else
                                tformpoint(-2720.0, -3516.0, -1824.0, local3\Field1\Field2, $00)
                                local11 = createitem("Research Sector-02 Scheme", $00, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                            EndIf
                            entitytype(local11\Field2, $03, $00)
                        EndIf
                        If (((local34 <> (Float local64)) And event_ismeinroom(local3)) <> 0) Then
                            If ((Int local34) <> 0) Then
                                playsound_strict(snd_i\Field18, $00)
                            Else
                                playsound_strict(snd_i\Field34, $00)
                            EndIf
                        EndIf
                        If (70.0 <= local3\Field2) Then
                            If ((((wi\Field5 = $00) And (wi\Field9 = $00)) And local3\Field23) <> 0) Then
                                fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                            EndIf
                            If ((Int local34) <> 0) Then
                                If (local3\Field23 <> 0) Then
                                    shouldplay = $08
                                EndIf
                                isblackout = $00
                                mp_loadeventsound(local3, "SFX\Ambient\Room Ambience\FuelPump.ogg", $01)
                                local3\Field7 = loopsoundex(local3\Field9, local3\Field7, camera, local3\Field1\Field11[$04], 6.0, 1.0, $00)
                                For local20 = $04 To $07 Step $01
                                    local3\Field1\Field14[local20]\Field4 = $00
                                Next
                                local3\Field2 = max(local3\Field2, 12600.0)
                            Else
                                isblackout = $01
                                If (channelplaying(local3\Field7) <> 0) Then
                                    stopchannel(local3\Field7)
                                    local3\Field7 = $00
                                EndIf
                                For local20 = $04 To $07 Step $01
                                    local3\Field1\Field14[local20]\Field4 = $01
                                Next
                            EndIf
                        Else
                            local3\Field2 = min((local3\Field2 + fps\Field7[$00]), 70.0)
                        EndIf
                        If ((local23 And (Int local34)) <> 0) Then
                            If (0.0 < local3\Field1\Field15[$00]\Field26) Then
                                local20 = $00
                                If (9.0 > entitydistancesquared(me\Field60, local3\Field1\Field14[$01]\Field2)) Then
                                    local20 = $01
                                ElseIf (9.0 > entitydistancesquared(me\Field60, local3\Field1\Field14[$03]\Field2)) Then
                                    local20 = $03
                                EndIf
                                If (local20 > $00) Then
                                    positionentity(local3\Field1\Field15[$00]\Field3, entityx(local3\Field1\Field11[local20], $01), entityy(local3\Field1\Field11[local20], $01), entityz(local3\Field1\Field11[local20], $01), $00)
                                    resetentity(local3\Field1\Field15[$00]\Field3)
                                    giveachievement("049", $01)
                                    playsoundex(snd_i\Field42, camera, local3\Field1\Field11[local20], 4.0, 1.0, $00, $00)
                                    local3\Field1\Field14[local20]\Field4 = $00
                                    openclosedoor(local3\Field1\Field14[local20], $01, $00)
                                    local3\Field1\Field14[(local20 - $01)]\Field6 = $00
                                    local3\Field1\Field14[local20]\Field6 = $01
                                    local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
                                    mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\049\DetectedInChamber.ogg", $01)
                                    local3\Field1\Field15[$00]\Field20 = loopsoundex(local3\Field1\Field15[$00]\Field19, local3\Field1\Field15[$00]\Field20, camera, local3\Field1\Field15[$00]\Field0, 10.0, 1.0, $01)
                                    local3\Field1\Field15[$00]\Field26 = 0.0
                                    local3\Field1\Field15[$00]\Field43 = $00
                                    local3\Field1\Field15[$00]\Field13 = $02
                                    local3\Field1\Field15[$00]\Field10 = 2.0
                                EndIf
                            EndIf
                        EndIf
                        If (13300.0 > local3\Field2) Then
                            If (12600.0 <= local3\Field2) Then
                                For local20 = $00 To $02 Step $02
                                    local3\Field1\Field14[local20]\Field6 = $01
                                    local3\Field1\Field14[(local20 + $01)]\Field6 = $00
                                Next
                                local3\Field2 = 13300.0
                            EndIf
                        ElseIf (16800.0 > local3\Field2) Then
                            For local1 = Each npcs
                                If (((local1\Field4 = $03) And (0.0 = local1\Field10)) <> 0) Then
                                    setnpcframe(local1, 155.0, $01)
                                    local1\Field10 = 1.0
                                EndIf
                            Next
                            local3\Field2 = 16870.0
                        EndIf
                    EndIf
                EndIf
            Case $25
                If (event_isplayerinroom(local3) <> 0) Then
                    local3\Field23 = (event_ismeinroom(local3) And (-14.5625 > entityy(event_getmypivot(), $00)))
                    If (((-14.5625 > entityy(me\Field60, $00)) Lor local3\Field23) <> 0) Then
                        If (local3\Field23 <> 0) Then
                            shouldplay = $1B
                            me\Field59 = $01
                        EndIf
                        If (local3\Field1\Field15[$00] = Null) Then
                            tformpoint(-4843.8, -4440.8, 1729.0, local3\Field1\Field2, $00)
                            local34 = tformedx()
                            local35 = tformedy()
                            local36 = tformedz()
                            local3\Field1\Field15[$00] = createnpc($13, local34, local35, local36)
                            local3\Field1\Field15[$00]\Field12 = -1.0
                            local3\Field1\Field15[$00]\Field50 = $01
                            changenpctextureid(local3\Field1\Field15[$00], $0D)
                            setnpcframe(local3\Field1\Field15[$00], 19.0, $01)
                            rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, (Float local3\Field1\Field6), 0.0, $01)
                            local5 = createdecal($13, local34, ((local35 - (1.0 / 4.55516)) + 0.005), local36, 90.0, rnd(360.0, 0.0), 0.0, 0.85, 0.8, $00, $01, $00, $00, $00)
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                            tformpoint(-5000.0, -4409.0, 1520.0, local3\Field1\Field2, $00)
                            If (i_005\Field0 = $02) Then
                                local11 = createitem("SCP-005", $08, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                            Else
                                local11 = createitem("Level 5 Key Card", $5E, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                            EndIf
                            entitytype(local11\Field2, $03, $00)
                            tformpoint(-4105.0, -4336.0, 2207.0, local3\Field1\Field2, $00)
                            local11 = createitem("Document SCP-409", $00, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                            rotateentity(local11\Field2, 0.0, 0.0, 0.0, $00)
                            entitytype(local11\Field2, $03, $00)
                        Else
                            event_resetprev()
                            If (0.0 = i_409\Field0) Then
                                If (0.81 > entitydistancesquared(me\Field60, local3\Field1\Field15[$00]\Field3)) Then
                                    giveachievement("409", $01)
                                    If (((i_427\Field0 = $00) And (25200.0 > i_427\Field1)) <> 0) Then
                                        me\Field49 = 1000.0
                                        i_409\Field0 = 0.001
                                    EndIf
                                EndIf
                                If (mp_interactobject(local3\Field1, $02, 0.8, $00, $00) <> 0) Then
                                    giveachievement("409", $01)
                                    If (((i_427\Field0 = $00) And (25200.0 > i_427\Field1)) <> 0) Then
                                        createmsg(getlocalstring("msg", "409"), 6.0)
                                        me\Field49 = 1000.0
                                        i_409\Field0 = 0.001
                                    Else
                                        createmsg(getlocalstring("msg", "409.nothappened"), 6.0)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (25.0 > entitydistancesquared(me\Field60, local3\Field1\Field11[$03])) Then
                            If (rand($32, $01) = $01) Then
                                settemplatevelocity(particleeffect[$13], -0.007, 0.008, -0.001, 0.0012, 0.007, 0.008)
                                setemitter(local3\Field1, entityx(local3\Field1\Field11[$03], $01), entityy(local3\Field1\Field11[$03], $01), entityz(local3\Field1\Field11[$03], $01), $13)
                                playsoundex(snd_i\Field62, camera, local3\Field1\Field11[$03], 3.0, 0.4, $00, $00)
                            EndIf
                        EndIf
                    EndIf
                    local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$00], local3\Field1\Field14[$01], local3\Field1\Field11[$00], local3\Field1\Field11[$01], local3, $01, $00, $00)
                EndIf
            Case $0F
                If (local3\Field6 = $00) Then
                    If (300.0 > entitydistancesquared(me\Field60, local3\Field1\Field11[$00])) Then
                        If (n_i\Field3\Field65 = $00) Then
                            If (2.0 > n_i\Field3\Field10) Then
                                local3\Field6 = playsound_strict(loadtempsound("SFX\Character\Scientist\EmilyScream.ogg"), $01)
                                local5 = createdecal($00, entityx(local3\Field1\Field11[$00], $01), (local3\Field1\Field4 + 0.005), entityz(local3\Field1\Field11[$00], $01), 90.0, rnd(360.0, 0.0), 0.0, 0.8, 0.8, $00, $01, $00, $00, $00)
                                entityparent(local5\Field0, local3\Field1\Field2, $01)
                                local28 = loadtexture_strict("GFX\Map\Textures\Door01_Corrosive.png", $01, $00, $01)
                                entitytexture(local3\Field1\Field14[$00]\Field0, local28, $00, $00)
                                entitytexture(local3\Field1\Field14[$00]\Field1, local28, $00, $00)
                                entitytexture(local3\Field1\Field14[$00]\Field2, local28, $00, $00)
                                deletesingletextureentryfromcache(local28, $00)
                                local28 = $00
                                local3\Field1\Field14[$00]\Field27 = $01
                            EndIf
                        Else
                            local3\Field1\Field14[$00]\Field4 = $00
                            removeevent(local3)
                        EndIf
                    EndIf
                ElseIf (channelplaying(local3\Field6) = $00) Then
                    local3\Field1\Field14[$00]\Field4 = $00
                    removeevent(local3)
                Else
                    updatesoundorigin(local3\Field6, camera, local3\Field1\Field11[$00], 30.0, 1.0, $01, $01)
                EndIf
            Case $39
                local65 = local3\Field1\Field10
                If ((event_isplayerinroom(local3) And (local65 <> Null)) <> 0) Then
                    If (((20.0 < entityy(me\Field60, $00)) And (local3\Field1\Field15[$00] <> Null)) <> 0) Then
                        If (((0.0 = local3\Field1\Field15[$00]\Field10) Lor (400.0 < entitydistancesquared(me\Field60, local3\Field1\Field15[$00]\Field3))) <> 0) Then
                            local3\Field4 = (local3\Field4 + (fps\Field7[$00] * 1.0))
                            If (((10.0 > (local3\Field4 Mod 500.0)) And (490.0 < ((local3\Field4 - (fps\Field7[$00] * 1.0)) Mod 500.0))) <> 0) Then
                                If ((((3000.0 - ((Float selecteddifficulty\Field2) * 500.0)) < local3\Field4) And (local3\Field4 > rnd((((Float selecteddifficulty\Field2) * 500.0) + 10000.0), 0.0))) <> 0) Then
                                    local3\Field1\Field15[$00]\Field10 = 2.0
                                    positionentity(local3\Field1\Field15[$00]\Field3, 0.0, -110.0, 0.0, $00)
                                    local3\Field4 = (local3\Field4 - rnd(1000.0, (2000.0 - ((Float selecteddifficulty\Field2) * 500.0))))
                                Else
                                    local3\Field1\Field15[$00]\Field10 = 1.0
                                    positionentity(local3\Field1\Field15[$00]\Field3, 0.0, -110.0, 0.0, $00)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    event_resetprev()
                    If (mp_ishoster() <> 0) Then
                        mp_updateforest(local65)
                    EndIf
                    If (event_ismeinroom(local3) <> 0) Then
                        If (20.0 < entityy(me\Field60, $00)) Then
                            If (mp_ishoster() = $00) Then
                                updateforest(local65)
                            EndIf
                            shouldplay = $09
                            If (local3\Field1\Field15[$00] = Null) Then
                                shouldplay = $21
                                If (rand($64, $01) = $01) Then
                                    me\Field23 = 0.7
                                    me\Field30 = 0.7
                                    me\Field28 = rnd(60.0, 70.0)
                                EndIf
                            EndIf
                            If (local3\Field1\Field15[$00] <> Null) Then
                                If (((((1.0 = local3\Field1\Field15[$00]\Field11) And (1.0 < local3\Field1\Field15[$00]\Field10)) And (local3\Field1\Field15[$00]\Field96 = ue_players[mp_getmyindex()])) Lor (2.0 < local3\Field1\Field15[$00]\Field10)) <> 0) Then
                                    shouldplay = $0C
                                EndIf
                            EndIf
                            If (chs\Field3 = $00) Then
                                If (28.5 >= entityy(me\Field60, $00)) Then
                                    me\Field10 = -10.0
                                    kill($00, $01, $00, $01)
                                ElseIf ((entityy(local65\Field4, $01) + 0.5) < entityy(me\Field60, $00)) Then
                                    moveentity(me\Field60, 0.0, (((entityy(local65\Field4, $01) + 0.5) - entityy(me\Field60, $00)) * fps\Field7[$00]), 0.0)
                                EndIf
                            EndIf
                            If ((local65\Field5[$00]\Field6 Lor local65\Field5[$01]\Field6) <> 0) Then
                                me\Field10 = -10.0
                                positionentity(me\Field60, entityx(local3\Field1\Field14[$00]\Field2, $01), 0.5, entityz(local3\Field1\Field14[$00]\Field2, $01), $00)
                                rotateentity(me\Field60, 0.0, (entityyaw(local3\Field1\Field2, $01) + (local3\Field3 * 180.0)), 0.0, $00)
                                moveentity(me\Field60, 0.0, 0.0, 1.5)
                                resetentity(me\Field60)
                                resetrender()
                                isblackout = previsblackout
                                If (wi\Field5 > $00) Then
                                    fog\Field0 = 15.0
                                ElseIf (wi\Field9 > $00) Then
                                    fog\Field0 = 9.0
                                Else
                                    fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                                EndIf
                                clearfogcolor()
                                local3\Field2 = 0.0
                                local3\Field4 = 0.0
                            EndIf
                        Else
                            If (entityhidden(local65\Field4) = $00) Then
                                hideentity(local65\Field4)
                            EndIf
                            For local20 = $00 To $01 Step $01
                                local65\Field5[local20]\Field6 = $00
                                local65\Field5[local20]\Field4 = $02
                            Next
                            If (local3\Field1\Field14[$00]\Field6 <> 0) Then
                                If (entityhidden(local65\Field4) <> 0) Then
                                    showentity(local65\Field4)
                                EndIf
                                me\Field10 = -10.0
                                local3\Field1\Field14[$00]\Field6 = $00
                                local3\Field1\Field14[$00]\Field4 = $01
                                previsblackout = isblackout
                                isblackout = $00
                                local25 = createpivot($00)
                                positionentity(local25, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local25, local3\Field1\Field2, 0.0)
                                local37 = wrapangle((entityyaw(local25, $00) - entityyaw(local3\Field1\Field2, $01)), 360.0)
                                local20 = ((90.0 >= local37) Lor (270.0 <= local37))
                                positionentity(me\Field60, entityx(local65\Field5[local20]\Field2, $01), ((entityy(local65\Field5[local20]\Field2, $01) + entityy(me\Field60, $01)) + 0.5), entityz(local65\Field5[local20]\Field2, $01), $01)
                                rotateentity(me\Field60, 0.0, (entityyaw(local65\Field5[local20]\Field2, $01) - 180.0), 0.0, $01)
                                moveentity(me\Field60, -0.5, 0.0, 0.5)
                                local65\Field5[$00]\Field4 = ($02 - local20)
                                local65\Field5[$01]\Field4 = ($01 + local20)
                                local3\Field3 = (1.0 - (Float local20))
                                freeentity(local25)
                                local25 = $00
                                resetentity(me\Field60)
                                local3\Field4 = 0.0
                            EndIf
                        EndIf
                    EndIf
                ElseIf (local65 <> Null) Then
                    If (entityhidden(local65\Field4) = $00) Then
                        hideentity(local65\Field4)
                    EndIf
                Else
                    removeevent(local3)
                EndIf
            Case $10
                If (event_isplayerinroom(local3) <> 0) Then
                    If ((((i_714\Field0 <> $02) And (wi\Field2 <> $04)) And (wi\Field0 <> $04)) <> 0) Then
                        If (((0.81 > entitydistancesquared(me\Field60, local3\Field1\Field11[$00])) Lor (0.0 < local3\Field2)) <> 0) Then
                            If (0.0 = local3\Field2) Then
                                me\Field49 = (1000.0 - ((Float (i_714\Field0 = $01)) * 200.0))
                            EndIf
                            me\Field23 = (1.0 - ((Float (i_714\Field0 = $01)) * 0.5))
                            If (local3\Field9 = $00) Then
                                local3\Field9 = loadsound_strict("SFX\SCP\1123\Ambient.ogg")
                            EndIf
                            local3\Field7 = loopsoundex(local3\Field9, local3\Field7, camera, me\Field60, 4.0, 4.0, $00)
                        EndIf
                    EndIf
                    If (0.0 < local3\Field2) Then
                        cansave = $00
                        If (entityhidden(local3\Field1\Field11[$07]) <> 0) Then
                            showentity(local3\Field1\Field11[$07])
                        EndIf
                    ElseIf (entityhidden(local3\Field1\Field11[$07]) = $00) Then
                        hideentity(local3\Field1\Field11[$07])
                    EndIf
                    If (1.0 = local3\Field2) Then
                        me\Field33 = me\Field31
                        me\Field34 = me\Field32
                        previsblackout = isblackout
                        isblackout = $00
                        local3\Field1\Field15[$00] = createnpc($13, entityx(local3\Field1\Field11[$01], $01), entityy(local3\Field1\Field11[$01], $01), entityz(local3\Field1\Field11[$01], $01))
                        freeentity(local3\Field1\Field15[$00]\Field0)
                        local3\Field1\Field15[$00]\Field0 = $00
                        local3\Field1\Field15[$00]\Field0 = copyentity(n_i\Field0[$1F], $00)
                        local27 = (inigetfloat("Data\NPCs.ini", "Class D", "Scale", 0.0, $01) / meshwidth(local3\Field1\Field15[$00]\Field0))
                        scaleentity(local3\Field1\Field15[$00]\Field0, local27, local27, local27, $00)
                        local3\Field1\Field15[$00]\Field97 = $01
                        positionentity(me\Field60, entityx(local3\Field1\Field11[$02], $01), entityy(local3\Field1\Field11[$02], $01), entityz(local3\Field1\Field11[$02], $01), $01)
                        resetentity(me\Field60)
                        me\Field23 = 1.0
                        me\Field49 = 1200.0
                        me\Field31 = 1.0
                        local3\Field2 = 2.0
                    ElseIf (2.0 = local3\Field2) Then
                        local3\Field3 = (local3\Field3 + fps\Field7[$00])
                        pointentity(local3\Field1\Field15[$00]\Field3, me\Field60, 0.0)
                        me\Field49 = max(me\Field49, 100.0)
                        shouldplay = $1D
                        If (1000.0 < local3\Field3) Then
                            If (local3\Field1\Field14[$01]\Field6 = $00) Then
                                openclosedoor(local3\Field1\Field14[$01], $01, $00)
                            EndIf
                            If (((1040.0 <= local3\Field3) And (1040.0 > (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                local3\Field1\Field15[$00]\Field18 = playsoundex(loadtempsound("SFX\SCP\1123\Officer0.ogg"), camera, local3\Field1\Field15[$00]\Field0, 10.0, 1.0, $01, $00)
                            ElseIf (((1400.0 <= local3\Field3) And (1400.0 > (local3\Field3 - fps\Field7[$00]))) <> 0) Then
                                local3\Field1\Field15[$00]\Field18 = playsoundex(loadtempsound("SFX\SCP\1123\Officer1.ogg"), camera, local3\Field1\Field15[$00]\Field0, 10.0, 1.0, $01, $00)
                            EndIf
                            local3\Field1\Field15[$00]\Field10 = 3.0
                            animatenpc(local3\Field1\Field15[$00], 3.0, 26.0, 0.2, $01)
                            If (2.344727 < entitydistancesquared(me\Field60, local3\Field1\Field11[$02])) Then
                                me\Field10 = -10.0
                                me\Field49 = 500.0
                                positionentity(me\Field60, entityx(local3\Field1\Field11[$03], $01), entityy(local3\Field1\Field11[$03], $01), entityz(local3\Field1\Field11[$03], $01), $01)
                                rotateentity(me\Field60, 0.0, entityyaw(local3\Field1\Field2, $01), 0.0, $00)
                                resetentity(me\Field60)
                                local3\Field2 = 3.0
                            EndIf
                        EndIf
                    ElseIf (3.0 = local3\Field2) Then
                        If (160.0 < local3\Field1\Field14[$00]\Field8) Then
                            positionentity(local3\Field1\Field15[$00]\Field3, entityx(local3\Field1\Field11[$04], $01), entityy(local3\Field1\Field11[$04], $01), entityz(local3\Field1\Field11[$04], $01), $00)
                            resetentity(local3\Field1\Field15[$00]\Field3)
                            local3\Field2 = 4.0
                        EndIf
                    ElseIf (4.0 = local3\Field2) Then
                        tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local3\Field1\Field2)
                        If (((256.0 > tformedx()) And (-480.0 < tformedz())) <> 0) Then
                            local3\Field1\Field14[$00]\Field6 = $00
                        EndIf
                        If (local3\Field1\Field14[$03]\Field6 <> 0) Then
                            local3\Field1\Field15[$00]\Field10 = 3.0
                            pointentity(local3\Field1\Field15[$00]\Field3, me\Field60, 0.0)
                            animatenpc(local3\Field1\Field15[$00], 27.0, 54.0, 0.5, $00)
                            If (54.0 <= local3\Field1\Field15[$00]\Field14) Then
                                local3\Field6 = playsound_strict(loadtempsound("SFX\SCP\1123\Horror.ogg"), $00)
                                me\Field10 = -10.0
                                me\Field49 = 500.0
                                me\Field31 = 1.5
                                me\Field32 = 70.0
                                positionentity(me\Field60, entityx(local3\Field1\Field2, $01), 0.3, entityz(local3\Field1\Field2, $01), $01)
                                resetentity(me\Field60)
                                local3\Field3 = 0.0
                                local3\Field2 = 5.0
                            EndIf
                        EndIf
                    ElseIf (5.0 = local3\Field2) Then
                        local3\Field3 = (local3\Field3 + fps\Field7[$00])
                        If (500.0 < local3\Field3) Then
                            For local20 = $02 To $03 Step $01
                                local3\Field1\Field14[local20]\Field6 = $00
                                local3\Field1\Field14[local20]\Field4 = $02
                            Next
                            positionentity(local3\Field1\Field15[$00]\Field3, entityx(local3\Field1\Field11[$05], $01), entityy(local3\Field1\Field11[$05], $01), entityz(local3\Field1\Field11[$05], $01), $00)
                            resetentity(local3\Field1\Field15[$00]\Field3)
                            me\Field31 = 1.5
                            me\Field32 = 70.0
                            me\Field10 = -10.0
                            me\Field49 = 500.0
                            positionentity(me\Field60, entityx(local3\Field1\Field11[$06], $01), entityy(local3\Field1\Field11[$06], $01), entityz(local3\Field1\Field11[$06], $01), $01)
                            resetentity(me\Field60)
                            local5 = createdecal($03, entityx(me\Field60, $01), ((local3\Field1\Field4 + 3.003906) + 0.005), entityz(me\Field60, $01), 90.0, rnd(360.0, 0.0), 0.0, 0.5, 1.0, $00, $01, $00, $00, $00)
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                            local3\Field1\Field15[$00]\Field18 = playsoundex(loadtempsound("SFX\SCP\1123\Officer2.ogg"), camera, local3\Field1\Field15[$00]\Field3, 7.0, 1.0, $01, $00)
                            local3\Field2 = 6.0
                        EndIf
                    ElseIf (6.0 = local3\Field2) Then
                        pointentity(local3\Field1\Field15[$00]\Field3, me\Field60, 0.0)
                        animatenpc(local3\Field1\Field15[$00], 75.0, 128.0, 0.04, $01)
                        If (channelplaying(local3\Field1\Field15[$00]\Field18) = $00) Then
                            playsound_strict(loadtempsound("SFX\SCP\1123\Gunshot.ogg"), $00)
                            local3\Field2 = 7.0
                        EndIf
                    ElseIf (7.0 = local3\Field2) Then
                        positionentity(me\Field60, entityx(local3\Field1\Field2, $01), 0.3, entityz(local3\Field1\Field2, $01), $01)
                        resetentity(me\Field60)
                        me\Field51 = 6.0
                        me\Field49 = 500.0
                        me\Field31 = me\Field33
                        me\Field33 = 0.0
                        me\Field32 = me\Field34
                        me\Field34 = 0.0
                        isblackout = previsblackout
                        previsblackout = $01
                        If (me\Field39 = $00) Then
                            setcrouch($01)
                        EndIf
                        For local20 = $00 To (maxitemamount - $01) Step $01
                            If (inventory(local20) <> Null) Then
                                If (inventory(local20)\Field4\Field1 = "Leaflet") Then
                                    removeitem(inventory(local20))
                                    Exit
                                EndIf
                                If (inventory(local20)\Field4\Field2 = $2D) Then
                                    local23 = $00
                                    For local22 = $00 To (inventory(local20)\Field20 - $01) Step $01
                                        If (inventory(local20)\Field18[local22] <> Null) Then
                                            If (inventory(local20)\Field18[local22]\Field4\Field1 = "Leaflet") Then
                                                removeitem(inventory(local20)\Field18[local22])
                                                local23 = $01
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    If (local23 <> 0) Then
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        giveachievement("1123", $01)
                        removenpc(local3\Field1\Field15[$00])
                        freeentity(local3\Field1\Field11[$07])
                        local3\Field1\Field11[$07] = $00
                        removeevent(local3)
                    EndIf
                ElseIf (entityhidden(local3\Field1\Field11[$07]) = $00) Then
                    hideentity(local3\Field1\Field11[$07])
                EndIf
            Case $11
                If ((((0.0 = local3\Field5) And (8.0 > local3\Field18)) And (0.0 < local3\Field18)) <> 0) Then
                    If (n_i\Field7 = Null) Then
                        n_i\Field7 = createnpc($04, entityx(local3\Field1\Field2, $00), 0.4, entityz(local3\Field1\Field2, $00))
                    Else
                        positionentity(n_i\Field7\Field3, entityx(local3\Field1\Field2, $00), 0.4, entityz(local3\Field1\Field2, $00), $00)
                        resetentity(n_i\Field7\Field3)
                    EndIf
                    local3\Field5 = 1.0
                EndIf
                If (event_ismeinroom(local3) <> 0) Then
                    local3\Field2 = 0.0
                    local66 = $01
                    local67 = createpivot(local3\Field1\Field2)
                    positionentity(local67, 976.0, 128.0, -640.0, $00)
                    For local11 = Each items
                        If (local11\Field15 = $00) Then
                            If (0.5625 > entitydistancesquared(local11\Field2, local3\Field1\Field11[$00])) Then
                                local66 = $00
                            EndIf
                        EndIf
                    Next
                    local3\Field5 = max((local3\Field5 - fps\Field7[$00]), 1.0)
                    If (((local66 And interactobject(local3\Field1\Field11[$00], 0.75, $00)) And (1.0 = local3\Field5)) <> 0) Then
                        local3\Field3 = (Float rand($00, (maxitemamount - $01)))
                        If (inventory((Int local3\Field3)) <> Null) Then
                            local3\Field4 = 1.0
                        Else
                            For local20 = $00 To (maxitemamount - $01) Step $01
                                local68 = (inventory((Int ((local3\Field3 + (Float local20)) Mod (Float maxitemamount)))) = Null)
                                If (local68 = $00) Then
                                    local3\Field3 = ((local3\Field3 + (Float local20)) Mod (Float maxitemamount))
                                EndIf
                                If (rand($08, $01) = $01) Then
                                    local3\Field4 = ((0.1 * (Float local68)) + 3.0)
                                    local3\Field2 = (Float rand($05, $01))
                                    local69 = ""
                                    Select local3\Field2
                                        Case 1.0
                                            local69 = "Lost Key"
                                        Case 2.0
                                            local69 = "Disciplinary Hearing DH-S-4137-17092"
                                        Case 3.0
                                            local69 = "Coin"
                                        Case 4.0
                                            local69 = "Movie Ticket"
                                        Case 5.0
                                            local69 = "Old Badge"
                                    End Select
                                    For local11 = Each items
                                        If (local11\Field1 = local69) Then
                                            local3\Field4 = 1.0
                                            local3\Field2 = 0.0
                                            Exit
                                        EndIf
                                    Next
                                    If (local68 = $00) Then
                                        Exit
                                    EndIf
                                ElseIf (local68 <> 0) Then
                                    local3\Field4 = 2.0
                                Else
                                    local3\Field4 = 1.0
                                    Exit
                                EndIf
                            Next
                        EndIf
                        local3\Field5 = 90.0
                        is1162touch = $01
                    EndIf
                    If (1.0 = local3\Field4) Then
                        local71 = $00
                        For local19 = Each itemtemplates
                            If (isitemgoodfor1162arc(local19) <> 0) Then
                                Select inventory((Int local3\Field3))\Field4\Field2
                                    Case $69
                                        If ((((local19\Field2 = $59) Lor (local19\Field2 = $5A)) And (rand($02, $01) = $01)) <> 0) Then
                                            local71 = $01
                                        EndIf
                                    Case $00,$01
                                        If (((local19\Field2 = $00) And (rand($0C, $01) = $01)) <> 0) Then
                                            local71 = $01
                                        EndIf
                                    Case $38,$39,$3A,$3B,$3C,$3D,$3E,$3F
                                        If ((((((((((local19\Field2 = $38) Lor (local19\Field2 = $39)) Lor (local19\Field2 = $3A)) Lor (local19\Field2 = $3B)) Lor (local19\Field2 = $3C)) Lor (local19\Field2 = $3D)) Lor (local19\Field2 = $3E)) Lor (local19\Field2 = $3F)) And (rand($02, $01) = $01)) <> 0) Then
                                            local71 = $01
                                        EndIf
                                    Case $59,$5A,$5B,$5C
                                        If ((((((local19\Field2 = $59) Lor (local19\Field2 = $5A)) Lor (local19\Field2 = $5B)) Lor (local19\Field2 = $5C)) And (rand($0C, $01) = $01)) <> 0) Then
                                            local71 = $01
                                        EndIf
                                    Case $61,$63,$02,$2F
                                        If ((((((local19\Field2 = $61) Lor (local19\Field2 = $63)) Lor (local19\Field2 = $02)) Lor (local19\Field2 = $2F)) And (rand($05, $01) = $01)) <> 0) Then
                                            local71 = $01
                                        EndIf
                                    Case $27,$28
                                        If ((((local19\Field2 = $27) Lor (local19\Field2 = $28)) And (rand($02, $01) = $01)) <> 0) Then
                                            local71 = $01
                                        EndIf
                                    Case $30,$32,$33,$55,$56,$57,$10,$12,$11
                                        If (((((((((((local19\Field2 = $30) Lor (local19\Field2 = $32)) Lor (local19\Field2 = $33)) Lor (local19\Field2 = $55)) Lor (local19\Field2 = $56)) Lor (local19\Field2 = $57)) Lor (local19\Field2 = $11)) Lor (local19\Field2 = $12)) Lor (local19\Field2 = $10)) And (rand($04, $01) = $01)) <> 0) Then
                                            local71 = $01
                                        EndIf
                                    Default
                                        If ((((local19\Field2 = $61) Lor (local19\Field2 = $63)) And (rand($06, $01) = $01)) <> 0) Then
                                            local71 = $01
                                        EndIf
                                End Select
                            EndIf
                            If (local71 <> 0) Then
                                removewearableitems(inventory((Int local3\Field3)))
                                removeitem(inventory((Int local3\Field3)))
                                If (mp_ishoster() <> 0) Then
                                    local11 = createitem(local19\Field1, local19\Field2, entityx(local67, $01), entityy(local67, $01), entityz(local67, $01), $00, $00, $00, 1.0, $00)
                                    entitytype(local11\Field2, $03, $00)
                                EndIf
                                playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\Exchange" + (Str rand($00, $04))) + ".ogg")), $00)
                                mp_synchronize3dsound(ue_players[mp_getmyindex()], (("SFX\SCP\1162_ARC\Exchange" + (Str rand($00, $04))) + ".ogg"), me\Field60, 10.0, 1.0)
                                local3\Field4 = 0.0
                                giveachievement("1162arc", $01)
                                mo\Field0 = $00
                                Exit
                            EndIf
                        Next
                    ElseIf (2.0 = local3\Field4) Then
                        mp_client_interactobject($00, $02)
                        For local19 = Each itemtemplates
                            If ((isitemgoodfor1162arc(local19) And (rand($06, $01) = $01)) <> 0) Then
                                If (mp_ishoster() <> 0) Then
                                    local11 = createitem(local19\Field1, local19\Field2, entityx(local67, $01), entityy(local67, $01), entityz(local67, $01), $00, $00, $00, 1.0, $00)
                                    entitytype(local11\Field2, $03, $00)
                                    local25 = createpivot($00)
                                    positionentity(local25, entityx(me\Field60, $00), (entityy(me\Field60, $00) - 0.05), entityz(me\Field60, $00), $00)
                                    turnentity(local25, 90.0, 0.0, 0.0, $00)
                                    entitypick(local25, 0.3)
                                    local5 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, 0.75, 1.0, $00, $01, $00, $00, $00)
                                    entityparent(local5\Field0, local3\Field1\Field2, $01)
                                    freeentity(local25)
                                    local25 = $00
                                    mp_server_synchronizedecal(local5, local3\Field1\Field31)
                                    me\Field31 = (me\Field31 + 5.0)
                                    If (7.0 < me\Field31) Then
                                        msg\Field2 = getlocalstring("death", "1162")
                                        kill($01, $01, $00, $01)
                                    Else
                                        createmsg(getlocalstring("msg", "1162_1"), 6.0)
                                    EndIf
                                EndIf
                                giveachievement("1162arc", $01)
                                mo\Field0 = $00
                                playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\BodyHorrorExchange" + (Str rand($00, $03))) + ".ogg")), $00)
                                mp_synchronize3dsound(ue_players[mp_getmyindex()], (("SFX\SCP\1162_ARC\BodyHorrorExchange" + (Str rand($00, $03))) + ".ogg"), me\Field60, 10.0, 1.0)
                                me\Field51 = 5.0
                                local3\Field4 = 0.0
                                Exit
                            EndIf
                        Next
                    ElseIf (3.0 <= local3\Field4) Then
                        If (3.1 > local3\Field4) Then
                            playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\Exchange" + (Str rand($00, $04))) + ".ogg")), $00)
                            mp_synchronize3dsound(ue_players[mp_getmyindex()], (("SFX\SCP\1162_ARC\Exchange" + (Str rand($00, $04))) + ".ogg"), me\Field60, 10.0, 1.0)
                            removewearableitems(inventory((Int local3\Field3)))
                            removeitem(inventory((Int local3\Field3)))
                        Else
                            mp_client_interactobject($00, $02)
                            If (mp_ishoster() <> 0) Then
                                me\Field31 = (me\Field31 + 5.0)
                                local25 = createpivot($00)
                                positionentity(local25, entityx(me\Field60, $00), (entityy(me\Field60, $00) - 0.05), entityz(me\Field60, $00), $00)
                                turnentity(local25, 90.0, 0.0, 0.0, $00)
                                entitypick(local25, 0.3)
                                local5 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, 0.75, 1.0, $00, $01, $00, $00, $00)
                                entityparent(local5\Field0, local3\Field1\Field2, $01)
                                freeentity(local25)
                                local25 = $00
                                mp_server_synchronizedecal(local5, local3\Field1\Field31)
                                If (7.0 < me\Field31) Then
                                    msg\Field2 = getlocalstring("death", "1162")
                                    kill($01, $01, $00, $01)
                                Else
                                    createmsg(getlocalstring("msg", "1162_2"), 6.0)
                                EndIf
                            EndIf
                            playsound_strict(loadtempsound((("SFX\SCP\1162_ARC\BodyHorrorExchange" + (Str rand($00, $03))) + ".ogg")), $00)
                            mp_synchronize3dsound(ue_players[mp_getmyindex()], (("SFX\SCP\1162_ARC\BodyHorrorExchange" + (Str rand($00, $03))) + ".ogg"), me\Field60, 10.0, 1.0)
                            me\Field51 = 5.0
                            local3\Field3 = 0.0
                        EndIf
                        If (mp_ishoster() <> 0) Then
                            Select local3\Field2
                                Case 1.0
                                    local11 = createitem("Lost Key", $69, entityx(local67, $01), entityy(local67, $01), entityz(local67, $01), $00, $00, $00, 1.0, $00)
                                Case 2.0
                                    local11 = createitem("Disciplinary Hearing DH-S-4137-17092", $01, entityx(local67, $01), entityy(local67, $01), entityz(local67, $01), $00, $00, $00, 1.0, $00)
                                Case 3.0
                                    local11 = createitem("Coin", $6B, entityx(local67, $01), entityy(local67, $01), entityz(local67, $01), $00, $00, $00, 1.0, $00)
                                Case 4.0
                                    local11 = createitem("Movie Ticket", $07, entityx(local67, $01), entityy(local67, $01), entityz(local67, $01), $00, $00, $00, 1.0, $00)
                                Case 5.0
                                    local11 = createitem("Old Badge", $06, entityx(local67, $01), entityy(local67, $01), entityz(local67, $01), $00, $00, $00, 1.0, $00)
                            End Select
                            entitytype(local11\Field2, $03, $00)
                        EndIf
                        giveachievement("1162arc", $01)
                        mo\Field0 = $00
                        local3\Field4 = 0.0
                    EndIf
                    freeentity(local67)
                    local67 = $00
                    is1162touch = $00
                EndIf
            Case $29
                If (event_isplayerinroom(local3) <> 0) Then
                    If (rand($32, $01) = $01) Then
                        If (remotedooron <> 0) Then
                            If (event_ismeinroom(local3) <> 0) Then
                                playsound_strict(snd_i\Field34, $00)
                                me\Field50 = 4.0
                            EndIf
                            For local20 = $00 To $01 Step $01
                                If (local3\Field1\Field14[local20]\Field6 = $00) Then
                                    local3\Field1\Field14[local20]\Field17 = playsoundex(snd_i\Field4, camera, local3\Field1\Field14[local20]\Field2, 5.0, 1.0, $00, $00)
                                    openclosedoor(local3\Field1\Field14[local20], $01, $00)
                                EndIf
                            Next
                        EndIf
                        If ((local3\Field1\Field14[$00]\Field6 Lor local3\Field1\Field14[$01]\Field6) <> 0) Then
                            For local20 = $00 To $01 Step $01
                                createnpc($0C, entityx(local3\Field1\Field11[local20], $01), entityy(local3\Field1\Field11[local20], $01), entityz(local3\Field1\Field11[local20], $01))
                            Next
                            removeevent(local3)
                        EndIf
                    EndIf
                EndIf
            Case $32
                Select local3\Field2
                    Case 0.0
                        tformpoint(502.0, 128.0, 83.0, local3\Field1\Field2, $00)
                        local11 = createitem("Document SCP-789-J", $00, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                        entitytype(local11\Field2, $03, $00)
                        local3\Field2 = 1.0
                    Case 1.0
                        If ((event_isplayerinroom(local3) And (2.25 > entitydistancesquared(me\Field60, local3\Field1\Field11[$00]))) <> 0) Then
                            giveachievement("789j", $01)
                            local3\Field6 = playsoundex(loadtempsound("SFX\SCP\Joke\789J.ogg"), camera, local3\Field1\Field11[$00], 10.0, 1.0, $01, $00)
                            local3\Field2 = 2.0
                        EndIf
                    Case 2.0
                        local3\Field3 = (local3\Field3 + fps\Field7[$00])
                        If (30.0 > animtime(local3\Field1\Field11[$00])) Then
                            animateex(local3\Field1\Field11[$00], animtime(local3\Field1\Field11[$00]), $01, $1E, 1.0, $00)
                        Else
                            animateex(local3\Field1\Field11[$00], animtime(local3\Field1\Field11[$00]), $1F, $F0, 0.52, $00)
                        EndIf
                        updatesoundorigin(local3\Field6, camera, local3\Field1\Field11[$00], 10.0, 1.5, $00, $01)
                        If (700.0 < local3\Field3) Then
                            removeevent(local3)
                        EndIf
                End Select
            Case $33
                Select local3\Field2
                    Case 0.0
                        If (((6.0 > local3\Field18) And (0.0 < local3\Field18)) <> 0) Then
                            tformpoint(1322.0, 54.0, 491.0, local3\Field1\Field2, $00)
                            local3\Field1\Field15[$00] = createnpc($14, tformedx(), tformedy(), tformedz())
                            local3\Field1\Field15[$00]\Field10 = 8.0
                            local3\Field1\Field15[$00]\Field50 = $01
                            setnpcframe(local3\Field1\Field15[$00], 287.0, $01)
                            rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 90.0), 0.0, $01)
                            tformpoint(1328.0, 150.0, 491.0, local3\Field1\Field2, $00)
                            local5 = createdecal($03, tformedx(), tformedy(), tformedz(), 0.0, ((Float local3\Field1\Field6) + 270.0), 0.0, 0.3, 1.0, $00, $01, $00, $00, $00)
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                            local3\Field2 = 1.0
                        EndIf
                    Case 1.0
                        If (local3\Field1\Field15[$00]\Field17 = $00) Then
                            local3\Field1\Field15[$00]\Field17 = loadsound_strict("SFX\Character\Guard\SuicideGuard0.ogg")
                        EndIf
                        If (6.0 > local3\Field18) Then
                            local3\Field1\Field15[$00]\Field18 = loopsoundex(local3\Field1\Field15[$00]\Field17, local3\Field1\Field15[$00]\Field18, camera, local3\Field1\Field15[$00]\Field3, 12.0, 1.0, $01)
                            If (((4.0 > local3\Field18) And (1.0 < me\Field42)) <> 0) Then
                                local3\Field2 = 2.0
                            EndIf
                        EndIf
                    Case 2.0
                        stopchannel(local3\Field1\Field15[$00]\Field18)
                        local3\Field1\Field15[$00]\Field18 = $00
                        freesound_strict(local3\Field1\Field15[$00]\Field17)
                        local3\Field1\Field15[$00]\Field17 = $00
                        local3\Field1\Field15[$00]\Field18 = playsoundex(loadtempsound("SFX\Character\Guard\SuicideGuard1.ogg"), camera, local3\Field1\Field15[$00]\Field3, 12.0, 1.0, $01, $00)
                        local3\Field2 = 3.0
                    Case 3.0
                        updatesoundorigin(local3\Field1\Field15[$00]\Field18, camera, local3\Field1\Field15[$00]\Field3, 15.0, 1.0, $00, $01)
                        If (channelplaying(local3\Field1\Field15[$00]\Field18) = $00) Then
                            removeevent(local3)
                        EndIf
                End Select
            Case $42
                If (event_ismeinroom(local3) <> 0) Then
                    If (0.0 = local3\Field3) Then
                        If (local3\Field1\Field5 > entityz(me\Field60, $00)) Then
                            If (me\Field59 = $01) Then
                                playsound_strict(loadtempsound("SFX\Ambient\ToZone2.ogg"), $00)
                            Else
                                playsound_strict(loadtempsound("SFX\Ambient\ToZone3.ogg"), $00)
                            EndIf
                            local3\Field3 = 1.0
                        EndIf
                    EndIf
                    If (0.0 = local3\Field4) Then
                        If (rand($02, $01) = $01) Then
                            tformpoint(877.0, 121.0, 333.0, local3\Field1\Field2, $00)
                            local3\Field1\Field15[$00] = createnpc($0E, tformedx(), tformedy(), tformedz())
                            local3\Field1\Field15[$00]\Field10 = 2.0
                        EndIf
                        local3\Field4 = 1.0
                    EndIf
                EndIf
                If (((12.0 > local3\Field1\Field8) Lor (mp_ishoster() And (12.0 > local3\Field18))) <> 0) Then
                    If (local3\Field1\Field15[$00] <> Null) Then
                        If (3.0 = local3\Field1\Field15[$00]\Field11) Then
                            removenpc(local3\Field1\Field15[$00])
                        EndIf
                    EndIf
                    For local4 = Each events
                        If (local3\Field1\Field7\Field6 = $45) Then
                            If (local4\Field0 = $23) Then
                                If (2.0 = local4\Field2) Then
                                    turncheckpointmonitorsoff($00)
                                    For local20 = $00 To $01 Step $01
                                        local3\Field1\Field14[local20]\Field4 = $00
                                    Next
                                Else
                                    updatecheckpointmonitors($00)
                                    For local20 = $00 To $01 Step $01
                                        local3\Field1\Field14[local20]\Field4 = $01
                                    Next
                                EndIf
                                Exit
                            EndIf
                        ElseIf (local4\Field0 = $0C) Then
                            If (0.0 = local4\Field4) Then
                                turncheckpointmonitorsoff($01)
                                For local20 = $00 To $01 Step $01
                                    local3\Field1\Field14[local20]\Field4 = $00
                                Next
                            Else
                                updatecheckpointmonitors($01)
                                For local20 = $00 To $01 Step $01
                                    local3\Field1\Field14[local20]\Field4 = $01
                                Next
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
                If (local3\Field2 <> (Float local3\Field1\Field14[$00]\Field6)) Then
                    mp_loadeventsound(local3, "SFX\Door\DoorCheckpoint.ogg", $00)
                    local3\Field6 = playsoundex(local3\Field8, camera, local3\Field1\Field14[$00]\Field0, 10.0, 1.0, $00, $00)
                    local3\Field7 = playsoundex(local3\Field8, camera, local3\Field1\Field14[$01]\Field0, 10.0, 1.0, $00, $00)
                EndIf
                local3\Field2 = (Float local3\Field1\Field14[$00]\Field6)
                updatesoundorigin(local3\Field6, camera, local3\Field1\Field14[$00]\Field0, 10.0, 1.0, $00, $01)
                updatesoundorigin(local3\Field7, camera, local3\Field1\Field14[$01]\Field0, 10.0, 1.0, $00, $01)
            Case $00
                If (n_i\Field3\Field65 = $00) Then
                    If (0.0 = local3\Field2) Then
                        If (((8.0 > local3\Field18) And (0.0 < local3\Field18)) <> 0) Then
                            If (1.0 < n_i\Field3\Field10) Then
                                removeevent(local3)
                            Else
                                local3\Field1\Field15[$00] = createnpc($13, entityx(local3\Field1\Field14[$00]\Field2, $01), 0.5, entityz(local3\Field1\Field14[$00]\Field2, $01))
                                changenpctextureid(local3\Field1\Field15[$00], $09)
                                pointentity(local3\Field1\Field15[$00]\Field3, local3\Field1\Field2, 0.0)
                                rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, entityyaw(local3\Field1\Field15[$00]\Field3, $00), 0.0, $01)
                                moveentity(local3\Field1\Field15[$00]\Field3, 0.0, 0.0, 0.5)
                                playsoundex(loadtempsound("SFX\Door\EndroomDoor.ogg"), camera, local3\Field1\Field2, 15.0, 1.0, $00, $00)
                                local3\Field2 = 1.0
                            EndIf
                        EndIf
                    ElseIf (1.0 = local3\Field2) Then
                        If (event_isplayerinroom(local3) <> 0) Then
                            stopchannel(local3\Field6)
                            local3\Field6 = $00
                            local3\Field6 = playsound_strict(loadtempsound("SFX\Character\Janitor\106Abduct.ogg"), $01)
                            local3\Field2 = 2.0
                        ElseIf (8.0 > local3\Field1\Field8) Then
                            If (local3\Field8 = $00) Then
                                local3\Field8 = loadsound_strict("SFX\Character\Janitor\Idle.ogg")
                            EndIf
                            local3\Field6 = loopsoundex(local3\Field8, local3\Field6, camera, local3\Field1\Field15[$00]\Field0, 15.0, 1.0, $01)
                        EndIf
                    ElseIf (2.0 = local3\Field2) Then
                        local3\Field3 = (local3\Field3 + fps\Field7[$00])
                        If (85.0 < local3\Field3) Then
                            local3\Field1\Field15[$00]\Field10 = 1.0
                        EndIf
                        If (3.49 < entitydistancesquared(local3\Field1\Field15[$00]\Field3, local3\Field1\Field14[$00]\Field2)) Then
                            local5 = createdecal($00, local3\Field1\Field3, (local3\Field1\Field4 + 0.005), local3\Field1\Field5, 90.0, rnd(360.0, 0.0), 0.0, 0.05, 1.0, $00, $01, $00, $00, $00)
                            local5\Field4 = 0.008
                            local5\Field13 = 10000.0
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                            local3\Field2 = 3.0
                        EndIf
                    Else
                        positionentity(n_i\Field3\Field0, entityx(local3\Field1\Field2, $01), 0.0, entityz(local3\Field1\Field2, $01), $00)
                        pointentity(n_i\Field3\Field0, local3\Field1\Field15[$00]\Field3, 0.0)
                        rotateentity(n_i\Field3\Field0, 0.0, entityyaw(n_i\Field3\Field0, $00), 0.0, $01)
                        n_i\Field3\Field26 = 1.0
                        If (7.74 < entitydistancesquared(local3\Field1\Field15[$00]\Field3, local3\Field1\Field14[$00]\Field2)) Then
                            If (1.0 = local3\Field1\Field15[$00]\Field10) Then
                                setnpcframe(local3\Field1\Field15[$00], 41.0, $01)
                            EndIf
                            local3\Field1\Field15[$00]\Field10 = 6.0
                            local3\Field1\Field15[$00]\Field24 = curvevalue(0.0, local3\Field1\Field15[$00]\Field24, 25.0)
                            positionentity(local3\Field1\Field15[$00]\Field3, curvevalue(entityx(local3\Field1\Field2, $01), entityx(local3\Field1\Field15[$00]\Field3, $00), 25.0), (0.3 - (local3\Field2 / 70.0)), curvevalue(entityz(local3\Field1\Field2, $01), entityz(local3\Field1\Field15[$00]\Field3, $00), 25.0), $00)
                            resetentity(local3\Field1\Field15[$00]\Field3)
                            animatenpc(local3\Field1\Field15[$00], 41.0, 58.0, 0.1, $00)
                            local3\Field2 = (local3\Field2 + (fps\Field7[$00] / 2.0))
                        EndIf
                        animatenpc(n_i\Field3, 495.0, 604.0, 0.7, $00)
                        me\Field38 = min((me\Field38 - (((0.15 / entitydistance(local3\Field1\Field15[$00]\Field3, me\Field60)) * me\Field38) * fps\Field7[$00])), me\Field38)
                        If (100.0 < local3\Field2) Then
                            n_i\Field3\Field10 = 0.0
                            n_i\Field3\Field11 = rnd(22000.0, 27000.0)
                            n_i\Field3\Field26 = 0.0
                            If (((6.25 > entitydistancesquared(me\Field60, local3\Field1\Field2)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                n_i\Field3\Field36 = entityx(me\Field60, $00)
                                n_i\Field3\Field37 = entityy(me\Field60, $00)
                                n_i\Field3\Field38 = entityz(me\Field60, $00)
                                n_i\Field3\Field10 = 2.0
                            EndIf
                            removenpc(local3\Field1\Field15[$00])
                            removeevent(local3)
                        EndIf
                    EndIf
                Else
                    removenpc(local3\Field1\Field15[$00])
                    removeevent(local3)
                EndIf
            Case $2F
                If (0.0 = local3\Field2) Then
                    If (event_isplayerinroom(local3) <> 0) Then
                        tformpoint(-944.0, 448.0, 20.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($14, tformedx(), tformedy(), tformedz())
                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, (Float local3\Field1\Field6), 0.0, $01)
                        local3\Field1\Field14[$00]\Field6 = $01
                        local3\Field2 = 1.0
                    EndIf
                ElseIf (1.0 = local3\Field2) Then
                    If (2.5 > local3\Field18) Then
                        local25 = createpivot($00)
                        tformpoint(-944.0, 320.0, 1460.0, local3\Field1\Field2, $00)
                        positionentity(local25, tformedx(), tformedy(), tformedz(), $00)
                        local3\Field1\Field15[$00]\Field10 = 5.0
                        local3\Field1\Field15[$00]\Field12 = 0.0
                        local3\Field1\Field15[$00]\Field36 = entityx(local25, $01)
                        local3\Field1\Field15[$00]\Field37 = entityy(local25, $01)
                        local3\Field1\Field15[$00]\Field38 = entityz(local25, $01)
                        freeentity(local25)
                        local25 = $00
                        local3\Field2 = 2.0
                    EndIf
                Else
                    local3\Field2 = (local3\Field2 + fps\Field7[$00])
                    If (((252.0 < local3\Field2) And local3\Field1\Field14[$00]\Field6) <> 0) Then
                        openclosedoor(local3\Field1\Field14[$00], $01, $00)
                    EndIf
                    If (0.0 = local3\Field1\Field14[$00]\Field8) Then
                        freeentity(local3\Field1\Field14[$00]\Field1)
                        local3\Field1\Field14[$00]\Field1 = $00
                        removenpc(local3\Field1\Field15[$00])
                        local3\Field1\Field15[$00] = Null
                        removeevent(local3)
                    EndIf
                EndIf
            Case $08
                If (local3\Field1\Field15[$00] = Null) Then
                    If ((event_isplayerinroom(local3) And (2.0 > n_i\Field2\Field26)) <> 0) Then
                        tformpoint(-1180.0, -256.0, 896.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($13, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$00]\Field12 = 2.0
                        changenpctextureid(local3\Field1\Field15[$00], $0A)
                        local3\Field1\Field15[$00]\Field18 = playsoundex(loadtempsound("SFX\Character\Maintenance\EscapeFromClosets.ogg"), camera, local3\Field1\Field15[$00]\Field3, 12.0, 1.0, $01, $00)
                        tformpoint(-1292.0, -256.0, -160.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$01] = createnpc($13, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$01]\Field12 = 3.0
                        changenpctextureid(local3\Field1\Field15[$01], $02)
                        pointentity(local3\Field1\Field15[$00]\Field3, local3\Field1\Field15[$01]\Field3, 0.0)
                        pointentity(local3\Field1\Field15[$01]\Field3, local3\Field1\Field15[$00]\Field3, 0.0)
                    EndIf
                Else
                    local3\Field2 = (local3\Field2 + fps\Field7[$00])
                    If (210.0 > local3\Field2) Then
                        rotateentity(local3\Field1\Field15[$01]\Field3, 0.0, curveangle(((Float local3\Field1\Field6) + 90.0), entityyaw(local3\Field1\Field15[$01]\Field3, $00), 100.0), 0.0, $01)
                        local3\Field1\Field15[$00]\Field10 = 1.0
                        If (((203.0 < local3\Field2) And (203.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                            playsoundex(loadtempsound("SFX\Room\Intro\173Vent.ogg"), camera, local3\Field1\Field2, 15.0, 1.0, $00, $00)
                        EndIf
                    ElseIf (455.0 > local3\Field2) Then
                        If (210.0 > (local3\Field2 - fps\Field7[$00])) Then
                            local3\Field1\Field15[$00]\Field10 = 0.0
                            local3\Field1\Field15[$01]\Field18 = playsoundex(loadtempsound("SFX\Character\Scientist\EscapeFromClosets.ogg"), camera, local3\Field1\Field15[$01]\Field3, 12.0, 1.0, $01, $00)
                        EndIf
                        If (315.0 < local3\Field2) Then
                            pointentity(local3\Field1\Field15[$00]\Field0, local3\Field1\Field2, 0.0)
                            rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 30.0), 0.0, $01)
                        EndIf
                        pointentity(local3\Field1\Field15[$01]\Field0, local3\Field1\Field2, 0.0)
                        turnentity(local3\Field1\Field15[$01]\Field0, 0.0, (sin(local3\Field2) * 25.0), 0.0, $00)
                        rotateentity(local3\Field1\Field15[$01]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$01]\Field0, $00), entityyaw(local3\Field1\Field15[$01]\Field3, $00), 30.0), 0.0, $01)
                    Else
                        If (455.0 > (local3\Field2 - fps\Field7[$00])) Then
                            playsound_strict(snd_i\Field47[$00], $00)
                            playsound_strict(snd_i\Field34, $00)
                            me\Field50 = 10.0
                        EndIf
                        If (((525.0 < local3\Field2) And (525.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                            local3\Field1\Field15[$00]\Field50 = $01
                            If (wi\Field5 > $00) Then
                                me\Field10 = -10.0
                            EndIf
                            playsoundex(snd_i\Field53[$00], camera, local3\Field1\Field15[$00]\Field3, 8.0, 1.0, $00, $00)
                            positionentity(n_i\Field2\Field3, (entityx(local3\Field1\Field15[$00]\Field3, $01) + 0.35), (entityy(local3\Field1\Field15[$00]\Field3, $01) + 0.15), entityz(local3\Field1\Field15[$00]\Field3, $01), $00)
                            pointentity(n_i\Field2\Field3, local3\Field1\Field15[$00]\Field3, 0.0)
                            resetentity(n_i\Field2\Field3)
                            n_i\Field2\Field26 = 1.0
                        ElseIf (((560.0 < local3\Field2) And (560.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                            local3\Field1\Field15[$01]\Field50 = $01
                            If (wi\Field5 > $00) Then
                                me\Field10 = -10.0
                            EndIf
                            playsoundex(snd_i\Field53[$01], camera, local3\Field1\Field15[$01]\Field3, 8.0, 1.0, $00, $00)
                            positionentity(n_i\Field2\Field3, (entityx(local3\Field1\Field15[$01]\Field3, $01) + 0.35), (entityy(local3\Field1\Field15[$01]\Field3, $01) + 0.15), entityz(local3\Field1\Field15[$01]\Field3, $01), $00)
                            pointentity(n_i\Field2\Field3, local3\Field1\Field15[$01]\Field3, 0.0)
                            resetentity(n_i\Field2\Field3)
                            n_i\Field2\Field26 = 0.0
                        ElseIf (((630.0 < local3\Field2) And (630.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                            tformpoint(-1065.0, -380.0, 50.0, local3\Field1\Field2, $00)
                            local11 = createitem("Wallet", $2E, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                            entitytype(local11\Field2, $03, $00)
                            For local20 = $00 To $01 Step $01
                                local12 = createitem("Quarter", $6A, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                local12\Field26 = local11\Field19
                                local12\Field15 = $01
                                local12\Field16 = $FFFFFFFF
                                local11\Field18[local20] = local12
                                hideentity(local12\Field2)
                                entitytype(local12\Field2, $03, $00)
                            Next
                            removeevent(local3)
                        EndIf
                    EndIf
                EndIf
            Case $35
                If (event_isplayerinroom(local3) <> 0) Then
                    If (mp_interactobject(local3\Field1, $00, 1.0, $00, $00) <> 0) Then
                        local23 = $01
                        For local11 = Each items
                            If (local11\Field15 = $00) Then
                                If (0.0 = distancesquared(entityx(local11\Field2, $00), entityx(local3\Field1\Field11[$02], $01), entityz(local11\Field2, $00), entityz(local3\Field1\Field11[$02], $01), 0.0, 0.0)) Then
                                    local23 = $00
                                    Exit
                                EndIf
                            EndIf
                        Next
                        local76 = $00
                        If (2.0 > local3\Field3) Then
                            If (selecteditem <> Null) Then
                                If (((selecteditem\Field4\Field2 = $6A) Lor (selecteditem\Field4\Field2 = $6B)) <> 0) Then
                                    removeitem(selecteditem)
                                    playsound_strict(loadtempsound("SFX\SCP\294\CoinDrop.ogg"), $00)
                                    mp_synchronize3dsound(Null, "SFX\SCP\294\CoinDrop.ogg", playerroom\Field11[$00], 5.0, 1.0)
                                    local76 = $01
                                    local3\Field3 = (local3\Field3 + 1.0)
                                ElseIf (((selecteditem\Field4\Field2 = $61) Lor (selecteditem\Field4\Field2 = $62)) <> 0) Then
                                    me\Field65 = ((selecteditem\Field4\Field2 = $62) + $01)
                                    If (0.0 < selecteditem\Field12) Then
                                        selecteditem\Field12 = (selecteditem\Field12 - 1.0)
                                        me\Field64 = (Int selecteditem\Field12)
                                        playsound_strict(loadtempsound("SFX\SCP\294\InsertMasterCard.ogg"), $00)
                                        mp_synchronize3dsound(Null, "SFX\SCP\294\InsertMasterCard.ogg", playerroom\Field11[$00], 5.0, 1.0)
                                        local76 = $01
                                        removeitem(selecteditem)
                                        local3\Field3 = 2.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (2.0 = local3\Field3) Then
                            giveachievement("294", $01)
                            i_294\Field0 = local23
                            If (i_294\Field0 <> 0) Then
                                createhintmsg(getlocalstring("msg", "294.keys"), 6.0, $01)
                                flushkeys()
                                selecteditem = Null
                                mo\Field0 = $00
                            EndIf
                        ElseIf ((((1.0 = local3\Field3) And (local76 = $00)) And (me\Field65 = $00)) <> 0) Then
                            i_294\Field0 = $00
                            createmsg(getlocalstring("msg", "294.another"), 6.0)
                        ElseIf (((local76 = $00) And (me\Field65 = $00)) <> 0) Then
                            i_294\Field0 = $00
                            createmsg(getlocalstring("msg", "294.two"), 6.0)
                        ElseIf (me\Field65 > $00) Then
                            createmsg(getlocalstring("msg", "294.funds"), 6.0)
                            me\Field65 = $00
                        EndIf
                    EndIf
                    If (((0.0 = local3\Field4) And mp_interactobject(local3\Field1, $01, 0.8, $00, $00)) <> 0) Then
                        If (getitemamount() < maxitemamount) Then
                            giveachievement("458", $01)
                            createmsg(getlocalstring("msg", "458"), 6.0)
                            local11 = createitem("Pizza Slice", $6C, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                            entitytype(local11\Field2, $03, $00)
                            pickitem(local11, $01)
                            local3\Field4 = (local3\Field4 + 1.0)
                        Else
                            createmsg(getlocalstring("msg", "cantcarry"), 6.0)
                        EndIf
                    EndIf
                EndIf
                If (8.0 > local3\Field18) Then
                    If (0.0 = local3\Field2) Then
                        If (n_i\Field7 = Null) Then
                            n_i\Field7 = createnpc($04, entityx(local3\Field1\Field2, $00), 0.4, entityz(local3\Field1\Field2, $00))
                        Else
                            positionentity(n_i\Field7\Field3, entityx(local3\Field1\Field2, $00), 0.4, entityz(local3\Field1\Field2, $00), $00)
                            resetentity(n_i\Field7\Field3)
                        EndIf
                        local3\Field2 = 1.0
                    EndIf
                EndIf
            Case $2B
                If (event_isplayerinroom(local3) <> 0) Then
                    local44 = $00
                    For local2 = Each rooms
                        If (local2\Field7\Field6 = $60) Then
                            local44 = $01
                            Exit
                        EndIf
                    Next
                    If (local44 = $00) Then
                        local3\Field4 = 1.0
                    EndIf
                    If (remotedooron = $00) Then
                        local3\Field1\Field14[$01]\Field4 = $01
                    ElseIf ((remotedooron And (0.0 = local3\Field4)) <> 0) Then
                        local3\Field1\Field14[$01]\Field4 = $02
                    Else
                        local3\Field1\Field14[$01]\Field4 = $00
                        local77 = Null
                        For local2 = Each rooms
                            If (local2\Field7\Field6 = $49) Then
                                local77 = local2
                                Exit
                            EndIf
                        Next
                        local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$00], local77\Field14[$01], local3\Field1\Field11[$00], local3\Field1\Field11[$01], local3, $01, $01, $00)
                        event_resetprev()
                        If (16.0 > entitydistancesquared(me\Field60, local3\Field1\Field11[$01])) Then
                            event_prevplayerroom = local77
                            removeevent(local3)
                        EndIf
                    EndIf
                EndIf
            Case $2D
                If (event_isplayerinroom(local3) <> 0) Then
                    local44 = $00
                    For local2 = Each rooms
                        If (local2\Field7\Field6 = $60) Then
                            local44 = $01
                            Exit
                        EndIf
                    Next
                    If (local44 = $00) Then
                        local3\Field4 = 1.0
                    EndIf
                    If (remotedooron = $00) Then
                        local3\Field1\Field14[$01]\Field4 = $01
                    ElseIf ((remotedooron And (0.0 = local3\Field4)) <> 0) Then
                        local3\Field1\Field14[$01]\Field4 = $02
                    Else
                        local3\Field1\Field14[$01]\Field4 = $00
                        local78 = Null
                        For local2 = Each rooms
                            If (local2\Field7\Field6 = $47) Then
                                local78 = local2
                                Exit
                            EndIf
                        Next
                        local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$00], local78\Field14[$01], local3\Field1\Field11[$00], local3\Field1\Field11[$01], local3, $01, $00, $00)
                        If (n_i\Field3\Field65 = $00) Then
                            If (((-1.5 > local3\Field25) And (-1.5 <= (local3\Field25 + fps\Field7[$00]))) <> 0) Then
                                playsound_strict(snd_i\Field45[$03], $01)
                            EndIf
                        EndIf
                        event_resetprev()
                        If (16.0 > entitydistancesquared(me\Field60, local3\Field1\Field11[$01])) Then
                            event_prevplayerroom = local78
                        EndIf
                    EndIf
                EndIf
            Case $3A
                If (event_isplayerinroom(local3) <> 0) Then
                    event_resetprev()
                    updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                    local79 = local3\Field3
                    local3\Field3 = (Float updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0))
                    If (((local79 <> local3\Field3) And (0.0 < local3\Field2)) <> 0) Then
                        playsoundex(snd_i\Field34, camera, local3\Field1\Field13[$01]\Field0, 10.0, 1.0, $00, $00)
                    EndIf
                    isblackout = (0.0 = local3\Field3)
                    If (((wi\Field5 = $00) And (wi\Field9 = $00)) <> 0) Then
                        fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                    EndIf
                    If (0.0 = local3\Field2) Then
                        If (((rand($C8, $01) = $01) Lor (2.0 < entityy(me\Field60, $01))) <> 0) Then
                            playsound_strict(snd_i\Field47[$07], $00)
                            local3\Field2 = 1.0
                        EndIf
                    EndIf
                    If (1.0 = local3\Field2) Then
                        rotateentity(local3\Field1\Field13[$01]\Field0, curvevalue(80.0, entitypitch(local3\Field1\Field13[$01]\Field0, $00), 10.0), entityyaw(local3\Field1\Field13[$01]\Field0, $00), 0.0, $00)
                        If (79.0 < entitypitch(local3\Field1\Field13[$01]\Field0, $00)) Then
                            local3\Field2 = 2.0
                        EndIf
                    EndIf
                    remotedooron = updatelever(local3\Field1\Field13[$02]\Field0, $00, $50, -80.0)
                EndIf
            Case $3F
                If (6.0 > local3\Field18) Then
                    If (1.0 < n_i\Field2\Field26) Then
                        removeevent(local3)
                    ElseIf (0.0 = n_i\Field2\Field26) Then
                        If (((36.0 < entitydistancesquared(event_getsomebodypivot(local3), n_i\Field2\Field3)) And (mp_somebodysees173(n_i\Field2) = $00)) <> 0) Then
                            Select local3\Field1\Field7\Field6
                                Case $0A,$30
                                    tformpoint(640.0, 100.0, -896.0, local3\Field1\Field2, $00)
                                Case $0C
                                    tformpoint(-832.0, 100.0, 0.0, local3\Field1\Field2, $00)
                                Case $1C
                                    tformpoint(-410.0, 100.0, 410.0, local3\Field1\Field2, $00)
                                Case $64,$65
                                    Select rand($03, $01)
                                        Case $01
                                            tformpoint(576.0, -512.0, 256.0, local3\Field1\Field2, $00)
                                        Case $02
                                            tformpoint(-512.0, -512.0, 256.0, local3\Field1\Field2, $00)
                                        Case $03
                                            tformpoint(-920.0, -512.0, 480.0, local3\Field1\Field2, $00)
                                    End Select
                            End Select
                            positionentity(n_i\Field2\Field3, tformedx(), tformedy(), tformedz(), $01)
                            resetentity(n_i\Field2\Field3)
                            removeevent(local3)
                        EndIf
                    EndIf
                EndIf
            Case $09
                If (local3\Field1\Field15[$00] = Null) Then
                    If (((8.0 > local3\Field18) And (0.0 < local3\Field18)) <> 0) Then
                        local3\Field1\Field15[$00] = createnpc($14, local3\Field1\Field3, 0.5, local3\Field1\Field5)
                        pointentity(local3\Field1\Field15[$00]\Field3, me\Field60, 0.0)
                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 270.0), 0.0, $01)
                        local3\Field1\Field14[$00]\Field4 = $01
                        local3\Field2 = 1.0
                    EndIf
                ElseIf (local3\Field1\Field11[$00] = $00) Then
                    tformpoint(1024.0, 0.0, 0.0, local3\Field1\Field2, $00)
                    local3\Field1\Field11[$00] = createpivot($00)
                    positionentity(local3\Field1\Field11[$00], tformedx(), tformedy(), tformedz(), $00)
                    entityparent(local3\Field1\Field11[$00], local3\Field1\Field2, $01)
                ElseIf (1.0 = local3\Field2) Then
                    If (5.0 > local3\Field18) Then
                        local3\Field1\Field15[$00]\Field36 = entityx(local3\Field1\Field11[$00], $01)
                        local3\Field1\Field15[$00]\Field37 = entityy(local3\Field1\Field11[$00], $01)
                        local3\Field1\Field15[$00]\Field38 = entityz(local3\Field1\Field11[$00], $01)
                        local3\Field2 = 2.0
                    EndIf
                ElseIf (2.0 = local3\Field2) Then
                    If (((6.0 > entitydistancesquared(local3\Field1\Field15[$00]\Field3, me\Field60)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                        local3\Field1\Field15[$00]\Field10 = 1.0
                        local3\Field1\Field15[$00]\Field12 = 1.0
                    Else
                        local3\Field1\Field15[$00]\Field10 = 5.0
                        local3\Field1\Field15[$00]\Field12 = 0.0
                    EndIf
                    If (4.0 > entitydistancesquared(local3\Field1\Field15[$00]\Field3, local3\Field1\Field11[$00])) Then
                        openclosedoor(local3\Field1\Field14[$00], $01, $00)
                        local3\Field1\Field14[$00]\Field22 = $00
                        entitytexture(local3\Field1\Field14[$00]\Field24[$01], d_i\Field5[$01], $00, $00)
                        entitytexture(local3\Field1\Field14[$00]\Field3[$00], d_i\Field3[$01], $00, $00)
                        local3\Field6 = playsound_strict(loadtempsound("SFX\Room\ElevatorDeath.ogg"), $00)
                        local3\Field2 = 3.0
                    EndIf
                Else
                    local3\Field2 = (local3\Field2 + fps\Field7[$00])
                    If (((469.0 < local3\Field2) And (518.0 > local3\Field2)) <> 0) Then
                        me\Field24 = (7.4 - (local3\Field2 / 70.0))
                        templightvolume = 0.6
                        local3\Field1\Field15[$00]\Field50 = $01
                    ElseIf (((602.0 < local3\Field2) And (742.0 > local3\Field2)) <> 0) Then
                        me\Field24 = (10.6 - (local3\Field2 / 70.0))
                        templightvolume = 0.6
                    ElseIf (((910.0 <= local3\Field2) And (channelplaying(local3\Field6) = $00)) <> 0) Then
                        entitytexture(local3\Field1\Field14[$00]\Field24[$01], d_i\Field5[$02], $00, $00)
                        freeentity(local3\Field1\Field14[$00]\Field24[$00])
                        local3\Field1\Field14[$00]\Field24[$00] = $00
                        freeentity(local3\Field1\Field11[$00])
                        local3\Field1\Field11[$00] = $00
                        removeevent(local3)
                    EndIf
                EndIf
            Case $36
                If (event_isplayerinroom(local3) <> 0) Then
                    tformpoint(-1200.0, 51.2, 0.0, local3\Field1\Field2, $00)
                    local31 = tformedx()
                    local32 = tformedy()
                    local33 = tformedz()
                    local5 = createdecal($03, local31, ((local32 - 0.2) + 0.005), local33, 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
                    entityparent(local5\Field0, local3\Field1\Field2, $01)
                    local1 = createnpc($13, local31, local32, local33)
                    local1\Field12 = -1.0
                    local1\Field50 = $01
                    changenpctextureid(local1, $00)
                    setnpcframe(local1, 19.0, $01)
                    rotateentity(local1\Field3, 0.0, (entityyaw(local3\Field1\Field2, $00) - 80.0), 0.0, $01)
                    removeevent(local3)
                EndIf
            Case $07
                If (event_isplayerinroom(local3) <> 0) Then
                    local3\Field5 = wrapangle(((local3\Field4 * fps\Field7[$00]) + local3\Field5), 360.0)
                    rotateentity(local3\Field1\Field11[$00], local3\Field5, 0.0, 0.0, $00)
                    If (0.01 < local3\Field4) Then
                        local3\Field6 = loopsoundex(roomambience[$08], local3\Field6, camera, local3\Field1\Field11[$00], 5.0, (local3\Field4 / 4.0), $00)
                    EndIf
                    local3\Field4 = curvevalue((local3\Field3 * 5.0), local3\Field4, 150.0)
                EndIf
                If (16.0 > local3\Field18) Then
                    If (0.0 > local3\Field2) Then
                        local23 = (Int local3\Field3)
                        local3\Field3 = (Float rand($00, $01))
                        If (event_isplayerinroom(local3) = $00) Then
                            local3\Field4 = (local3\Field3 * 5.0)
                        ElseIf (((0.0 = (Float local23)) And (1.0 = local3\Field3)) <> 0) Then
                            local3\Field7 = playsoundex(loadtempsound("SFX\Ambient\Room Ambience\FanOn.ogg"), camera, local3\Field1\Field11[$00], 8.0, 1.0, $00, $00)
                        ElseIf (((1.0 = (Float local23)) And (0.0 = local3\Field3)) <> 0) Then
                            local3\Field7 = playsoundex(loadtempsound("SFX\Ambient\Room Ambience\FanOff.ogg"), camera, local3\Field1\Field11[$00], 8.0, 1.0, $00, $00)
                        EndIf
                        local3\Field2 = (rnd(15.0, 30.0) * 70.0)
                    Else
                        local3\Field2 = (local3\Field2 - fps\Field7[$00])
                    EndIf
                EndIf
            Case $1F
                If (6.0 > local3\Field18) Then
                    If (local3\Field1\Field15[$00] = Null) Then
                        tformpoint(1110.0, 51.2, -208.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($13, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$00]\Field12 = -1.0
                        local3\Field1\Field15[$00]\Field50 = $01
                        changenpctextureid(local3\Field1\Field15[$00], $07)
                        setnpcframe(local3\Field1\Field15[$00], 40.0, $01)
                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 90.0), 0.0, $01)
                    EndIf
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    If ((event_ismeinroom(local3) And (6.0 < entityy(event_getmypivot(), $01))) <> 0) Then
                        infacility = $FFFFFFFF
                    EndIf
                    local3\Field2 = (Float updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0))
                    updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0)
                    If (1.0 = local3\Field2) Then
                        If (local3\Field1\Field17[$07] = Null) Then
                            For local20 = $00 To $07 Step $01
                                Select local20
                                    Case $00
                                        local31 = 813.0
                                        local33 = -152.0
                                    Case $01
                                        local31 = 818.0
                                        local33 = 147.0
                                    Case $02
                                        local31 = 621.0
                                        local33 = 341.0
                                    Case $03
                                        local31 = 327.0
                                        local33 = 349.0
                                    Case $04
                                        local31 = 137.0
                                        local33 = 143.0
                                    Case $05
                                        local31 = 137.0
                                        local33 = -155.0
                                    Case $06
                                        local31 = 330.0
                                        local33 = -346.0
                                    Case $07
                                        local31 = 635.0
                                        local33 = -346.0
                                End Select
                                local32 = 3010.0
                                tformpoint(local31, local32, local33, local3\Field1\Field2, $00)
                                local3\Field1\Field17[local20] = setemitter(local3\Field1, tformedx(), tformedy(), tformedz(), $0A)
                            Next
                        EndIf
                    ElseIf (local3\Field1\Field17[$07] <> Null) Then
                        For local20 = $00 To $07 Step $01
                            freeemitter(local3\Field1\Field17[local20], $00)
                        Next
                    EndIf
                    local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$00], local3\Field1\Field14[$01], local3\Field1\Field11[$00], local3\Field1\Field11[$01], local3, $01, $00, $01)
                EndIf
            Case $31
                If (event_isplayerinroom(local3) <> 0) Then
                    If (local3\Field1\Field11[$00] = $00) Then
                        local3\Field1\Field11[$00] = copyentity(n_i\Field0[$1C], $00)
                        scaleentity(local3\Field1\Field11[$00], 0.07, 0.07, 0.07, $00)
                        positionentity(local3\Field1\Field11[$00], 0.0, -500.0, 0.0, $00)
                        entityparent(local3\Field1\Field11[$00], local3\Field1\Field2, $01)
                    EndIf
                    Select rand($04, $01)
                        Case $01
                            tformpoint(-808.0, -72.0, -40.0, local3\Field1\Field2, $00)
                        Case $02
                            tformpoint(-488.0, 160.0, 700.0, local3\Field1\Field2, $00)
                        Case $03
                            tformpoint(-488.0, 160.0, -700.0, local3\Field1\Field2, $00)
                        Case $04
                            tformpoint(-600.0, 340.0, 0.0, local3\Field1\Field2, $00)
                    End Select
                    If ((((-8.0 > me\Field10) And (-12.0 < me\Field10)) Lor wi\Field7) <> 0) Then
                        positionentity(local3\Field1\Field11[$00], tformedx(), tformedy(), tformedz(), $01)
                        rotateentity(local3\Field1\Field11[$00], 0.0, rnd(360.0, 0.0), 0.0, $00)
                    EndIf
                EndIf
            Case $30
                local84 = $00
                For local4 = Each events
                    If (((local4 <> local3) And (local4\Field0 = $15)) <> 0) Then
                        If (0.0 > local4\Field2) Then
                            local84 = $01
                            Exit
                        EndIf
                    EndIf
                Next
                If (local84 <> 0) Then
                    If (8.0 > local3\Field18) Then
                        If (local3\Field1\Field15[$00] = Null) Then
                            local3\Field1\Field15[$00] = createnpc($13, local3\Field1\Field3, (local3\Field1\Field4 + 0.203125), local3\Field1\Field5)
                            local3\Field1\Field15[$00]\Field12 = -1.0
                            local3\Field1\Field15[$00]\Field50 = $01
                            setnpcframe(local3\Field1\Field15[$00], 19.0, $01)
                            rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 180.0), 0.0, $00)
                            moveentity(local3\Field1\Field15[$00]\Field3, 0.0, 0.0, -0.5)
                            changenpctextureid(local3\Field1\Field15[$00], $0C)
                        EndIf
                        If (6.25 > entitydistancesquared(local3\Field1\Field15[$00]\Field3, me\Field60)) Then
                            If ((Int entitydistancesquared(local3\Field1\Field15[$00]\Field3, event_getmypivot())) <> 0) Then
                                me\Field31 = ((fps\Field7[$00] / (((Float (wi\Field2 > $00)) + 1.0) * 5000.0)) + me\Field31)
                            EndIf
                            If (local3\Field1\Field15[$01] = Null) Then
                                local3\Field1\Field15[$01] = createnpc($01, entityx(local3\Field1\Field15[$00]\Field3, $00), 0.13, entityz(local3\Field1\Field15[$00]\Field3, $00))
                                rotateentity(local3\Field1\Field15[$01]\Field3, 0.0, (Float local3\Field1\Field6), 0.0, $00)
                                moveentity(local3\Field1\Field15[$01]\Field3, 0.0, 0.0, 0.6)
                            EndIf
                        EndIf
                    ElseIf (hidedistance < local3\Field18) Then
                        removenpc(local3\Field1\Field15[$01])
                    EndIf
                EndIf
                If (local3\Field1\Field15[$01] <> Null) Then
                    If (local3\Field1\Field15[$01]\Field50 <> 0) Then
                        removeevent(local3)
                    EndIf
                EndIf
            Case $45
                If (0.0 = local3\Field4) Then
                    If (rand($08, $01) = $01) Then
                        rotateentity(local3\Field1\Field13[$00]\Field0, 80.0, entityyaw(local3\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                        rotateentity(local3\Field1\Field13[$01]\Field0, 80.0, entityyaw(local3\Field1\Field13[$01]\Field0, $00), 0.0, $00)
                        local3\Field4 = 1.0
                        local3\Field5 = -196.0
                    Else
                        local3\Field4 = 2.0
                    EndIf
                EndIf
                If (16.0 > local3\Field18) Then
                    local85 = (0.0 > entitypitch(local3\Field1\Field13[$00]\Field0, $01))
                    local23 = updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                    If (local23 <> 0) Then
                        If (local85 <> local23) Then
                            If (local23 <> 0) Then
                                If (event_ismeinroom(local3) <> 0) Then
                                    playsound_strict(snd_i\Field18, $00)
                                EndIf
                            EndIf
                        EndIf
                        If (-140.0 > local3\Field3) Then
                            local3\Field3 = 0.0
                            local3\Field2 = 0.0
                        EndIf
                    Else
                        stopchannel(local3\Field6)
                        local3\Field6 = $00
                        local3\Field2 = 3.0
                        local3\Field3 = -6300.0
                    EndIf
                    If ((event_ismeinroom(local3) Lor event_issomebodyinroom(local3)) <> 0) Then
                        updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0)
                        If (mp_ishoster() <> 0) Then
                            local23 = $01
                            For local4 = Each events
                                If (((local4\Field0 = local3\Field0) And (local4 <> local3)) <> 0) Then
                                    If (((local4\Field1\Field15[$00] <> Null) Lor (1.0 = local3\Field4)) <> 0) Then
                                        local23 = $00
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (((local3\Field1\Field15[$00] = Null) And local23) <> 0) Then
                                local3\Field1\Field14[$00]\Field4 = $01
                                If (90.0 = (Float (local3\Field1\Field6 Mod $B4))) Then
                                    local20 = (((entityx(local3\Field1\Field2, $01) > entityx(me\Field60, $01)) Xor (- ((entityx(local3\Field1\Field2, $01) > entityx(me\Field60, $01)) < 0))) - (- ((entityx(local3\Field1\Field2, $01) > entityx(me\Field60, $01)) < 0)))
                                    local31 = (((Float local20) * 800.0) + ((Float (local20 = $00)) * -800.0))
                                    local33 = 0.0
                                Else
                                    local20 = (entityz(local3\Field1\Field2, $01) > (Abs entityz(me\Field60, $01)))
                                    local31 = 0.0
                                    local33 = (((Float local20) * 800.0) + ((Float (local20 = $00)) * -800.0))
                                EndIf
                                local3\Field1\Field15[$00] = createnpc($12, (entityx(local3\Field1\Field2, $01) + (local31 * (1.0 / 256.0))), 0.4, (entityz(local3\Field1\Field2, $01) + (local33 * (1.0 / 256.0))))
                                local3\Field1\Field15[$00]\Field10 = 2.0
                                local3\Field1\Field15[$00]\Field60 = $64
                                pointentity(local3\Field1\Field15[$00]\Field3, local3\Field1\Field2, 0.0)
                                local3\Field2 = 0.0
                            EndIf
                        EndIf
                    EndIf
                    local3\Field20 = (local3\Field20 - fps\Field7[$00])
                    Select local3\Field2
                        Case 0.0
                            updateredlight(local3\Field1\Field11[$01], 1500.0, 800.0)
                            hideentity(local3\Field1\Field11[$00])
                            local3\Field6 = loopsoundex(snd_i\Field16, local3\Field6, camera, local3\Field1\Field11[$00], 4.0, 0.5, $00)
                            local3\Field3 = 0.0
                            local34 = entityx(local3\Field1\Field2, $01)
                            local36 = entityz(local3\Field1\Field2, $01)
                            local35 = entityy(local3\Field1\Field2, $01)
                            If (((chs\Field2 = $00) And (((local3\Field1\Field15[$00] = Null) Lor local3\Field1\Field15[$00]\Field50) Lor (1.0 = local3\Field1\Field15[$00]\Field26))) <> 0) Then
                                For local87 = Each mp_player
                                    If (((mp_rooms[local87\Field22] = local3\Field1) And (entityhidden(local87\Field18) = $00)) <> 0) Then
                                        If ((((1.0 > (Abs (entityx(local87\Field18, $01) - local34))) And (1.0 > (Abs (entityz(local87\Field18, $01) - local36)))) And (1.3 > (Abs (entityy(local87\Field18, $01) - local35)))) <> 0) Then
                                            If (channelplaying(local3\Field6) <> 0) Then
                                                stopchannel(local3\Field6)
                                                local3\Field6 = $00
                                            EndIf
                                            local3\Field6 = playsoundex(snd_i\Field17, camera, local3\Field1\Field11[$00], 4.0, 0.5, $00, $00)
                                            local3\Field2 = 1.0
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            For local1 = Each npcs
                                If ((((local1\Field4 <> $0C) And (local1\Field4 <> $09)) And (local1\Field50 = $00)) <> 0) Then
                                    local31 = entityx(local1\Field3, $01)
                                    local33 = entityz(local1\Field3, $01)
                                    local32 = entityy(local1\Field3, $01)
                                    If (((local1\Field4 = $15) And (local3\Field1\Field15[$01] = Null)) <> 0) Then
                                        If ((((2.0 > (Abs (local31 - local34))) And (2.0 > (Abs (local33 - local36)))) And (1.3 > (Abs (local32 - local35)))) <> 0) Then
                                            local1\Field13 = $01
                                            local1\Field41 = 0.0
                                            local1\Field40 = $00
                                            local1\Field12 = 700.0
                                            local1\Field10 = 11.0
                                            local3\Field1\Field15[$01] = local1
                                        EndIf
                                    ElseIf ((((0.81 > (Abs (local31 - local34))) And (0.81 > (Abs (local33 - local36)))) And (1.3 > (Abs (local32 - local35)))) <> 0) Then
                                        If (channelplaying(local3\Field6) <> 0) Then
                                            stopchannel(local3\Field6)
                                            local3\Field6 = $00
                                        EndIf
                                        local3\Field6 = playsoundex(snd_i\Field17, camera, local3\Field1\Field11[$00], 4.0, 0.5, $00, $00)
                                        local3\Field2 = 1.0
                                    EndIf
                                EndIf
                            Next
                            If (((local3\Field1\Field15[$01] <> Null) And (144.0 > entitydistancesquared(local3\Field1\Field15[$01]\Field3, local3\Field1\Field2))) <> 0) Then
                                If (0.0 >= local3\Field1\Field15[$01]\Field12) Then
                                    stopchannel(local3\Field6)
                                    local3\Field6 = $00
                                    If (0.0 >= local3\Field20) Then
                                        playannouncement((("SFX\Character\MTF\AnnouncTeslaDisabled" + (Str rand($00, $02))) + ".ogg"), $01)
                                        local3\Field20 = 210.0
                                    EndIf
                                    rotateentity(local3\Field1\Field13[$00]\Field0, 80.0, entityyaw(local3\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                                    local3\Field1\Field15[$01] = Null
                                EndIf
                            EndIf
                        Case 1.0
                            updateredlight(local3\Field1\Field11[$01], 100.0, 50.0)
                            local3\Field3 = (local3\Field3 + fps\Field7[$00])
                            If (35.0 <= local3\Field3) Then
                                stopchannel(local3\Field7)
                                local3\Field7 = $00
                                local3\Field7 = playsoundex(snd_i\Field19, camera, local3\Field1\Field11[$00], 10.0, 1.0, $00, $00)
                                local3\Field2 = 2.0
                            EndIf
                        Case 2.0
                            local34 = entityx(local3\Field1\Field2, $01)
                            local36 = entityz(local3\Field1\Field2, $01)
                            local35 = entityy(local3\Field1\Field2, $01)
                            If ((((0.75 > (Abs (entityx(me\Field60, $01) - local34))) And (0.75 > (Abs (entityz(me\Field60, $01) - local36)))) And (1.3 > (Abs (entityy(me\Field60, $01) - local35)))) <> 0) Then
                                If (((0.0 = me\Field0) And (chs\Field0 = $00)) <> 0) Then
                                    If (opt\Field0 > $00) Then
                                        local18 = setemitter(Null, entityx(me\Field60, $01), entityy(me\Field60, $01), entityz(me\Field60, $01), $0E)
                                        entityparent(local18\Field6, me\Field60, $01)
                                    EndIf
                                    me\Field51 = 0.4
                                    me\Field23 = 1.0
                                    msg\Field2 = format(getlocalstring("death", "tesla"), subjectname, "%s")
                                    kill($00, $01, $00, $01)
                                EndIf
                            EndIf
                            For local1 = Each npcs
                                If (local1\Field4 <> $09) Then
                                    If (((local1\Field4 = $12) And (local1\Field50 = $00)) <> 0) Then
                                        local3\Field1\Field14[$00]\Field4 = $00
                                        local1\Field12 = 1.0
                                    EndIf
                                    If ((((0.6 > (Abs (entityx(local1\Field3, $01) - local34))) And (0.6 > (Abs (entityz(local1\Field3, $01) - local36)))) And (1.3 > (Abs (entityy(local1\Field3, $01) - local35)))) <> 0) Then
                                        If (opt\Field0 > $00) Then
                                            local18 = setemitter(Null, entityx(local1\Field0, $01), entityy(local1\Field0, $01), entityz(local1\Field0, $01), $0E)
                                            entityparent(local18\Field6, local1\Field0, $01)
                                        EndIf
                                        If (local1\Field50 = $00) Then
                                            local1\Field24 = 0.0
                                            local1\Field60 = $00
                                            Select local1\Field4
                                                Case $06
                                                    giveachievement("tesla", $01)
                                                    local1\Field10 = 4.0
                                                Case $07
                                                    If (((n_i\Field12 Lor n_i\Field10) Lor n_i\Field11) = $00) Then
                                                        changenpctextureid(local1, $13)
                                                    EndIf
                                                Case $02
                                                    local1\Field10 = 5.0
                                                Case $0C
                                                    showentity(local1\Field0)
                                                Case $0D
                                                    changenpctextureid(local1, $14)
                                                    local1\Field10 = 3.0
                                                Case $12
                                                    changenpctextureid(local1, $11)
                                            End Select
                                            If (((6.0 > local3\Field1\Field8) And (entityinview(local1\Field3, camera) And entityvisible(me\Field60, local1\Field3))) <> 0) Then
                                                me\Field51 = 0.3
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (rand($05, $01) < $05) Then
                                positiontexture(t\Field2[$03], 0.0, rnd(0.0, 1.0))
                                If (entityhidden(local3\Field1\Field11[$00]) <> 0) Then
                                    showentity(local3\Field1\Field11[$00])
                                EndIf
                                If (6.0 > local3\Field1\Field8) Then
                                    lightvolume = (rnd(1.0, 2.0) * templightvolume)
                                EndIf
                            EndIf
                            local3\Field3 = (local3\Field3 - (fps\Field7[$00] * 1.5))
                            If (0.0 >= local3\Field3) Then
                                stopchannel(local3\Field6)
                                local3\Field6 = $00
                                local3\Field6 = playsoundex(snd_i\Field18, camera, local3\Field1\Field11[$00], 4.0, 0.5, $00, $00)
                                local3\Field2 = 3.0
                                local3\Field3 = -70.0
                            EndIf
                        Case 3.0
                            local3\Field3 = (local3\Field3 + fps\Field7[$00])
                            For local20 = $00 To $01 Step $01
                                If (entityhidden(local3\Field1\Field11[local20]) = $00) Then
                                    hideentity(local3\Field1\Field11[local20])
                                EndIf
                            Next
                            If (0.0 <= local3\Field3) Then
                                local3\Field2 = 0.0
                            EndIf
                    End Select
                    If (0.0 > entitypitch(local3\Field1\Field13[$01]\Field0, $00)) Then
                        local3\Field5 = min((local3\Field5 + fps\Field7[$00]), 0.0)
                    Else
                        local3\Field5 = max((local3\Field5 - fps\Field7[$00]), -196.0)
                    EndIf
                    If (((0.0 > local3\Field5) And (-196.0 < local3\Field5)) <> 0) Then
                        If (channelplaying(local3\Field10) = $00) Then
                            local3\Field10 = loopsoundex(snd_i\Field61, local3\Field10, camera, local3\Field1\Field11[$03], 10.0, 1.0, $00)
                        EndIf
                    Else
                        stopchannel(local3\Field10)
                        local3\Field10 = $00
                    EndIf
                    positionentity(local3\Field1\Field11[$02], 0.0, local3\Field5, 0.0, $00)
                    updatesoundorigin(local3\Field10, camera, local3\Field1\Field11[$03], 10.0, 1.0, $00, $01)
                EndIf
            Case $46
                If (event_isplayerinroom(local3) <> 0) Then
                    If (2.0 > local3\Field1\Field8) Then
                        If (((36.0 > entitydistancesquared(me\Field60, n_i\Field2\Field3)) Lor (36.0 > entitydistancesquared(me\Field60, n_i\Field3\Field3))) <> 0) Then
                            removeevent(local3)
                        Else
                            local25 = createpivot($00)
                            positionentity(local25, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00)
                            pointentity(local25, local3\Field1\Field2, 0.0)
                            rotateentity(local25, 0.0, entityyaw(local25, $00), 0.0, $01)
                            moveentity(local25, 0.0, 0.0, (entitydistance(local25, local3\Field1\Field2) * 2.0))
                            me\Field10 = -10.0
                            playsound_strict(snd_i\Field47[$0B], $00)
                            updateworld(1.0)
                            positionentity(me\Field60, entityx(local25, $00), (entityy(local25, $00) + 0.05), entityz(local25, $00), $00)
                            turnentity(me\Field60, 0.0, 180.0, 0.0, $00)
                            resetrender()
                            freeentity(local25)
                            local25 = $00
                            removeevent(local3)
                        EndIf
                    EndIf
                EndIf
            Case $47
                If (8.0 > local3\Field1\Field8) Then
                    If (16.0 > entitydistancesquared(me\Field60, n_i\Field2\Field3)) Then
                        If (local3\Field1\Field11[$1D] <> $00) Then
                            local5 = createdecal($01, entityx(local3\Field1\Field11[$1D], $01), (local3\Field1\Field4 + 0.005), entityz(local3\Field1\Field11[$1D], $01), 90.0, rnd(360.0, 0.0), 0.0, 0.2, rnd(0.7, 0.8), $00, $01, $00, $00, $00)
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                            freeentity(local3\Field1\Field11[$1D])
                            local3\Field1\Field11[$1D] = $00
                        EndIf
                        removeevent(local3)
                    ElseIf (local3\Field1\Field11[$1D] = $00) Then
                        Select rand($03, $01)
                            Case $01
                                local23 = $16
                            Case $02
                                local23 = $5D
                            Case $03
                                local23 = $41
                        End Select
                        For local19 = Each itemtemplates
                            If (local19\Field2 = local23) Then
                                local3\Field1\Field11[$1D] = copyentity(local19\Field5, $00)
                                If (local3\Field1\Field30 <> $00) Then
                                    positionentity(local3\Field1\Field11[$1D], entityx(local3\Field1\Field30, $00), (local3\Field1\Field4 + 0.1), entityz(local3\Field1\Field30, $00), $00)
                                Else
                                    positionentity(local3\Field1\Field11[$1D], local3\Field1\Field3, local3\Field1\Field4, local3\Field1\Field5, $00)
                                EndIf
                                rotateentity(local3\Field1\Field11[$1D], 0.0, rnd(360.0, 0.0), 0.0, $00)
                                entityparent(local3\Field1\Field11[$1D], local3\Field1\Field2, $01)
                                Exit
                            EndIf
                        Next
                    ElseIf (4.0 > entitydistancesquared(me\Field60, local3\Field1\Field11[$1D])) Then
                        me\Field49 = 500.0
                        me\Field10 = -10.0
                        playsound_strict(snd_i\Field47[$0B], $00)
                        local5 = createdecal($01, entityx(local3\Field1\Field11[$1D], $01), (local3\Field1\Field4 + 0.005), entityz(local3\Field1\Field11[$1D], $01), 90.0, rnd(360.0, 0.0), 0.0, 0.2, rnd(0.7, 0.8), $00, $01, $00, $00, $00)
                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                        freeentity(local3\Field1\Field11[$1D])
                        local3\Field1\Field11[$1D] = $00
                        removeevent(local3)
                    EndIf
                EndIf
            Case $1E
                If (local3\Field1\Field18 = Null) Then
                    local3\Field1\Field18 = (New mtgrid)
                    local99 = rndseed()
                    seedrnd(generateseednumber(randomseed))
                    local100 = (rand($00, $01) Shl $01)
                    local97 = (rand($FFFFFFFE, $02) + $09)
                    local98 = (rand($FFFFFFFE, $02) + $09)
                    local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $01
                    local3\Field1\Field18\Field0[((((local100 = $02) + local97) - (local100 <> $02)) + (local98 * $13))] = $01
                    local101 = $02
                    While (local101 < $64)
                        local95 = (rand($05, $01) Shl rand($02, $01))
                        For local20 = $01 To local95 Step $01
                            local96 = $01
                            local23 = (local20 Mod $02)
                            Select local100
                                Case $00
                                    If (local97 < ($11 - local23)) Then
                                        local97 = (local97 + $01)
                                    Else
                                        local96 = $00
                                    EndIf
                                Case $01
                                    If (local98 < ($11 - local23)) Then
                                        local98 = (local98 + $01)
                                    Else
                                        local96 = $00
                                    EndIf
                                Case $02
                                    If (local97 > ($01 + local23)) Then
                                        local97 = (local97 - $01)
                                    Else
                                        local96 = $00
                                    EndIf
                                Case $03
                                    If (local98 > ($01 + local23)) Then
                                        local98 = (local98 - $01)
                                    Else
                                        local96 = $00
                                    EndIf
                            End Select
                            If (local96 <> 0) Then
                                If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $00) Then
                                    local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $01
                                    local101 = (local101 + $01)
                                EndIf
                            Else
                                Exit
                            EndIf
                        Next
                        local100 = (local100 + ((rand($00, $01) Shl $01) - $01))
                        While (local100 < $00)
                            local100 = (local100 + $04)
                        Wend
                        While (local100 > $03)
                            local100 = (local100 - $04)
                        Wend
                    Wend
                    For local98 = $00 To $12 Step $01
                        For local97 = $00 To $12 Step $01
                            If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] > $00) Then
                                local3\Field1\Field18\Field0[((local98 * $13) + local97)] = ((((local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] > $00) + (local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)] > $00)) + (local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] > $00)) + (local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] > $00))
                            EndIf
                        Next
                    Next
                    local103 = $12
                    local104 = $00
                    For local97 = $00 To local103 Step $01
                        For local98 = $00 To $12 Step $01
                            If (local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] > $00) Then
                                local103 = local97
                                If (((local3\Field1\Field18\Field0[((local97 + $01) + ((local98 + $01) * $13))] < $03) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $03)) <> 0) Then
                                    local104 = $01
                                    If (rand($00, $01) = $01) Then
                                        local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] = (local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] + $01)
                                        local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $07
                                        local104 = $00
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If (local104 <> 0) Then
                            local97 = (local97 - $01)
                        EndIf
                    Next
                    local105 = $FFFFFFFF
                    local108 = $FFFFFFFF
                    local105 = $FFFFFFFF
                    local108 = $FFFFFFFF
                    For local98 = $00 To $12 Step $01
                        For local97 = $00 To $12 Step $01
                            If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $02) Then
                                If (((local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] > $00) And (local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] > $00)) <> 0) Then
                                    If (((local105 = $FFFFFFFF) Lor (local107 = $FFFFFFFF)) <> 0) Then
                                        If (((((local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] < $03) And (local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] < $03)) And (local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)] < $03)) And (local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] < $03)) <> 0) Then
                                            If (((((local3\Field1\Field18\Field0[((local97 - $01) + ((local98 - $01) * $13))] < $01) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $01)) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $01)) And (local3\Field1\Field18\Field0[((local97 - $01) + ((local98 + $01) * $13))] < $01)) <> 0) Then
                                                local105 = local97
                                                local107 = local98
                                            EndIf
                                        EndIf
                                    EndIf
                                    If (((((local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] < $03) And (local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] < $03)) And (local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)] < $03)) And (local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] < $03)) <> 0) Then
                                        If (((((local3\Field1\Field18\Field0[((local97 - $01) + ((local98 - $01) * $13))] < $01) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $01)) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $01)) And (local3\Field1\Field18\Field0[((local97 - $01) + ((local98 + $01) * $13))] < $01)) <> 0) Then
                                            local106 = local97
                                            local108 = local98
                                        EndIf
                                    EndIf
                                ElseIf (((local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] > $00) And (local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)] > $00)) <> 0) Then
                                    If (((local105 = $FFFFFFFF) Lor (local107 = $FFFFFFFF)) <> 0) Then
                                        If (((((local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] < $03) And (local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] < $03)) And (local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)] < $03)) And (local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] < $03)) <> 0) Then
                                            If (((((local3\Field1\Field18\Field0[((local97 - $01) + ((local98 - $01) * $13))] < $01) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $01)) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $01)) And (local3\Field1\Field18\Field0[((local97 - $01) + ((local98 + $01) * $13))] < $01)) <> 0) Then
                                                local105 = local97
                                                local107 = local98
                                            EndIf
                                        EndIf
                                    EndIf
                                    If (((((local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] < $03) And (local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] < $03)) And (local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)] < $03)) And (local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] < $03)) <> 0) Then
                                        If (((((local3\Field1\Field18\Field0[((local97 - $01) + ((local98 - $01) * $13))] < $01) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $01)) And (local3\Field1\Field18\Field0[((local97 + $01) + ((local98 - $01) * $13))] < $01)) And (local3\Field1\Field18\Field0[((local97 - $01) + ((local98 + $01) * $13))] < $01)) <> 0) Then
                                            local106 = local97
                                            local108 = local98
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    Next
                    If (((local106 = local105) And (local108 = local107)) <> 0) Then
                        runtimeerrorex(getlocalstring("runerr", "mt"))
                    EndIf
                    For local20 = $00 To $06 Step $01
                        local90[local20] = copyentity(misc_i\Field0[local20], $00)
                        hideentity(local90[local20])
                    Next
                    local95 = $00
                    For local98 = $00 To $12 Step $01
                        For local97 = $00 To $12 Step $01
                            If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] > $00) Then
                                Select local3\Field1\Field18\Field0[((local98 * $13) + local97)]
                                    Case $01,$07
                                        local95 = copyentity(local90[(local3\Field1\Field18\Field0[((local98 * $13) + local97)] - $01)], $00)
                                        If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $01) Then
                                            addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.597656), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                        EndIf
                                        If (local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] > $00) Then
                                            rotateentity(local95, 0.0, 90.0, 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $01
                                        ElseIf (local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] > $00) Then
                                            rotateentity(local95, 0.0, 270.0, 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $03
                                        ElseIf (local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] > $00) Then
                                            rotateentity(local95, 0.0, 180.0, 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $02
                                        Else
                                            rotateentity(local95, 0.0, 0.0, 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $00
                                        EndIf
                                    Case $02
                                        If ((((local97 = local105) And (local98 = local107)) Lor ((local97 = local106) And (local98 = local108))) <> 0) Then
                                            local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $06
                                        EndIf
                                        If (((local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] > $00) And (local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] > $00)) <> 0) Then
                                            local95 = copyentity(local90[(local3\Field1\Field18\Field0[((local98 * $13) + local97)] - $01)], $00)
                                            addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.597656), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                            local96 = rand($00, $01)
                                            rotateentity(local95, 0.0, (((Float local96) * 180.0) + 90.0), 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = ((local96 Shl $01) + $01)
                                        ElseIf (((local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] > $00) And (local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)] > $00)) <> 0) Then
                                            local95 = copyentity(local90[(local3\Field1\Field18\Field0[((local98 * $13) + local97)] - $01)], $00)
                                            addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.597656), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                            local96 = rand($00, $01)
                                            rotateentity(local95, 0.0, ((Float local96) * 180.0), 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = (local96 Shl $01)
                                        Else
                                            local95 = copyentity(local90[local3\Field1\Field18\Field0[((local98 * $13) + local97)]], $00)
                                            addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.65625), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                            local91 = local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)]
                                            local92 = local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)]
                                            local93 = local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))]
                                            local94 = local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))]
                                            If (((local91 > $00) And (local93 > $00)) <> 0) Then
                                                rotateentity(local95, 0.0, 0.0, 0.0, $00)
                                                local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $00
                                            ElseIf (((local91 > $00) And (local94 > $00)) <> 0) Then
                                                rotateentity(local95, 0.0, 90.0, 0.0, $00)
                                                local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $01
                                            ElseIf (((local92 > $00) And (local93 > $00)) <> 0) Then
                                                rotateentity(local95, 0.0, 270.0, 0.0, $00)
                                                local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $03
                                            Else
                                                rotateentity(local95, 0.0, 180.0, 0.0, $00)
                                                local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $02
                                            EndIf
                                        EndIf
                                        If (((local97 = local105) And (local98 = local107)) <> 0) Then
                                            local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $05
                                        EndIf
                                    Case $03
                                        local95 = copyentity(local90[local3\Field1\Field18\Field0[((local98 * $13) + local97)]], $00)
                                        addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.65625), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                        local91 = local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)]
                                        local92 = local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)]
                                        local93 = local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))]
                                        local94 = local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))]
                                        If ((((local91 > $00) And (local93 > $00)) And (local94 > $00)) <> 0) Then
                                            rotateentity(local95, 0.0, 90.0, 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $01
                                        ElseIf ((((local92 > $00) And (local93 > $00)) And (local94 > $00)) <> 0) Then
                                            rotateentity(local95, 0.0, 270.0, 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $03
                                        ElseIf ((((local93 > $00) And (local91 > $00)) And (local92 > $00)) <> 0) Then
                                            rotateentity(local95, 0.0, 0.0, 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $00
                                        Else
                                            rotateentity(local95, 0.0, 180.0, 0.0, $00)
                                            local3\Field1\Field18\Field1[((local98 * $13) + local97)] = $02
                                        EndIf
                                    Case $04
                                        local95 = copyentity(local90[local3\Field1\Field18\Field0[((local98 * $13) + local97)]], $00)
                                        addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.65625), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                        local96 = rand($00, $03)
                                        rotateentity(local95, 0.0, ((Float local96) * 90.0), 0.0, $00)
                                        local3\Field1\Field18\Field1[((local98 * $13) + local97)] = local96
                                End Select
                                scaleentity(local95, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                                positionentity(local95, (local3\Field1\Field3 + ((Float local97) * 2.0)), (local3\Field1\Field4 + 8.0), (local3\Field1\Field5 + ((Float local98) * 2.0)), $01)
                                local37 = entityyaw(local95, $01)
                                local45 = sin(local37)
                                local46 = cos(local37)
                                If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $07) Then
                                    addlight(local3\Field1, (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 521.0) * (1.0 / 256.0))) + ((local46 * 16.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + (1.0 / 0.64)), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 521.0) * (1.0 / 256.0))) + ((local45 * 16.0) * (1.0 / 256.0))), $02, 0.425, $FF, $C8, $C8, $01)
                                    createprop(local3\Field1, "GFX\Map\Props\tank2.b3d", (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 369.0) * (1.0 / 256.0))) + ((local46 * 320.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) - 0.5625), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 369.0) * (1.0 / 256.0))) + ((local45 * 320.0) * (1.0 / 256.0))), 0.0, (local37 + 180.0), 0.0, 3.0, 3.0, 3.0, $01, $00, "")
                                    createprop(local3\Field1, "GFX\Map\Props\tank2.b3d", (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 977.0) * (1.0 / 256.0))) + ((local46 * 320.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) - 0.5625), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 977.0) * (1.0 / 256.0))) + ((local45 * 320.0) * (1.0 / 256.0))), 0.0, (local37 + 180.0), 0.0, 3.0, 3.0, 3.0, $01, $00, "")
                                    local11 = createitem("SCP-500-01", $16, (((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local46 * -208.0) * (1.0 / 256.0))) - ((local45 * 1226.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + (1.0 / 2.327273)), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local45 * -208.0) * (1.0 / 256.0))) + ((local46 * 1226.0) * (1.0 / 256.0))), $00, $00, $00, 1.0, $00)
                                    entitytype(local11\Field2, $03, $00)
                                    local11 = createitem("Night Vision Goggles", $40, (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 504.0) * (1.0 / 256.0))) + ((local46 * 16.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + (1.0 / 2.844445)), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 504.0) * (1.0 / 256.0))) + ((local45 * 16.0) * (1.0 / 256.0))), $00, $00, $00, 1.0, $00)
                                    entitytype(local11\Field2, $03, $00)
                                ElseIf (((local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $05) Lor (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $06)) <> 0) Then
                                    addlight(local3\Field1, ((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local46 * 560.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + 1.832031), ((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local45 * 560.0) * (1.0 / 256.0))), $02, 0.25, $FF, $C8, $C8, $01)
                                    createprop(local3\Field1, "GFX\Map\Props\lamp_e.b3d", (((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local45 * 252.0) * (1.0 / 256.0))) + ((local46 * 560.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + 1.6875), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 252.0) * (1.0 / 256.0))) + ((local45 * 560.0) * (1.0 / 256.0))), 0.0, (local37 + 270.0), 90.0, 400.0, 400.0, 400.0, $00, $00, "")
                                    createprop(local3\Field1, "GFX\Map\Props\lamp_e.b3d", (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 252.0) * (1.0 / 256.0))) + ((local46 * 560.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + 1.6875), (((local3\Field1\Field5 + ((Float local98) * 2.0)) - ((local46 * 252.0) * (1.0 / 256.0))) + ((local45 * 560.0) * (1.0 / 256.0))), 0.0, (local37 + 90.0), 90.0, 400.0, 400.0, 400.0, $00, $00, "")
                                    local16 = createdoor(Null, ((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local46 * 256.0) * (1.0 / 256.0))), (local3\Field1\Field4 + 8.0), ((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local45 * 256.0) * (1.0 / 256.0))), (local37 - 90.0), $00, $01, $00, $00, $00)
                                    positionentity(local16\Field24[$01], (entityx(local16\Field24[$01], $01) + (local46 * 0.05)), (entityy(local16\Field24[$01], $01) + 0.1), (entityz(local16\Field24[$01], $01) + (local45 * -0.28)), $01)
                                    rotateentity(local16\Field24[$01], (entitypitch(local16\Field24[$01], $01) + 45.0), entityyaw(local16\Field24[$01], $01), entityroll(local16\Field24[$01], $01), $01)
                                    local96 = createpivot($00)
                                    positionentity(local96, ((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local46 * 552.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + 0.9375), ((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local45 * 552.0) * (1.0 / 256.0))), $00)
                                    If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $06) Then
                                        If (local3\Field1\Field14[$01] <> Null) Then
                                            removedoor(local16)
                                        Else
                                            local16\Field6 = (local3\Field1\Field14[$00]\Field6 = $00)
                                            local3\Field1\Field14[$01] = local16
                                        EndIf
                                        If (local3\Field1\Field11[$03] = $00) Then
                                            local3\Field1\Field11[$03] = local96
                                            rotateentity(local3\Field1\Field11[$03], 0.0, local37, 0.0, $01)
                                            positionentity(local3\Field1\Field11[$01], (local3\Field1\Field3 + ((Float local97) * 2.0)), entityy(local3\Field1\Field11[$01], $01), (local3\Field1\Field5 + ((Float local98) * 2.0)), $01)
                                        Else
                                            freeentity(local96)
                                            local96 = $00
                                        EndIf
                                    Else
                                        If (local3\Field1\Field14[$03] <> Null) Then
                                            removedoor(local16)
                                        Else
                                            local16\Field6 = (local3\Field1\Field14[$02]\Field6 = $00)
                                            local3\Field1\Field14[$03] = local16
                                        EndIf
                                        If (local3\Field1\Field11[$05] = $00) Then
                                            local3\Field1\Field11[$05] = local96
                                            rotateentity(local3\Field1\Field11[$05], 0.0, (local37 + 180.0), 0.0, $01)
                                            positionentity(local3\Field1\Field11[$00], (local3\Field1\Field3 + ((Float local97) * 2.0)), entityy(local3\Field1\Field11[$00], $01), (local3\Field1\Field5 + ((Float local98) * 2.0)), $01)
                                        Else
                                            freeentity(local96)
                                            local96 = $00
                                        EndIf
                                    EndIf
                                EndIf
                                local3\Field1\Field18\Field3[((local98 * $13) + local97)] = local95
                                local15 = createwaypoint(Null, local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 0.2), (local3\Field1\Field5 + ((Float local98) * 2.0)))
                                local3\Field1\Field18\Field4[((local98 * $13) + local97)] = local15
                                If (local98 < $12) Then
                                    If (local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)] <> Null) Then
                                        local38 = entitydistance(local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field0, local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field0)
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]
                                                local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                                If (local98 > $00) Then
                                    If (local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)] <> Null) Then
                                        local38 = entitydistance(local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field0, local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]\Field0)
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]
                                                local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                                If (local97 > $00) Then
                                    If (local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))] <> Null) Then
                                        local38 = entitydistance(local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field0, local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]\Field0)
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]
                                                local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                                If (local97 < $12) Then
                                    If (local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))] <> Null) Then
                                        local38 = entitydistance(local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field0, local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]\Field0)
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]
                                                local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    Next
                    For local20 = $00 To $06 Step $01
                        local3\Field1\Field18\Field2[local20] = local90[local20]
                    Next
                    positionentity(local3\Field1\Field11[$00], (local3\Field1\Field3 + ((Float local105) * 2.0)), entityy(local3\Field1\Field11[$00], $01), (local3\Field1\Field5 + ((Float local107) * 2.0)), $01)
                    positionentity(local3\Field1\Field11[$01], (local3\Field1\Field3 + ((Float local106) * 2.0)), entityy(local3\Field1\Field11[$01], $01), (local3\Field1\Field5 + ((Float local108) * 2.0)), $01)
                ElseIf (local3\Field1\Field18\Field2[$00] = $00) Then
                    For local20 = $00 To $06 Step $01
                        local90[local20] = copyentity(misc_i\Field0[local20], $00)
                        hideentity(local90[local20])
                    Next
                    local95 = $00
                    For local98 = $00 To $12 Step $01
                        For local97 = $00 To $12 Step $01
                            If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] > $00) Then
                                Select local3\Field1\Field18\Field0[((local98 * $13) + local97)]
                                    Case $01,$07
                                        local95 = copyentity(local90[(local3\Field1\Field18\Field0[((local98 * $13) + local97)] - $01)], $00)
                                        If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $01) Then
                                            addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.597656), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                        EndIf
                                    Case $02
                                        If (((local3\Field1\Field18\Field0[((local97 + $01) + (local98 * $13))] > $00) And (local3\Field1\Field18\Field0[((local97 - $01) + (local98 * $13))] > $00)) <> 0) Then
                                            local95 = copyentity(local90[(local3\Field1\Field18\Field0[((local98 * $13) + local97)] - $01)], $00)
                                            addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.597656), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                        ElseIf (((local3\Field1\Field18\Field0[(((local98 + $01) * $13) + local97)] > $00) And (local3\Field1\Field18\Field0[(((local98 - $01) * $13) + local97)] > $00)) <> 0) Then
                                            local95 = copyentity(local90[(local3\Field1\Field18\Field0[((local98 * $13) + local97)] - $01)], $00)
                                            addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.597656), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                        Else
                                            local95 = copyentity(local90[local3\Field1\Field18\Field0[((local98 * $13) + local97)]], $00)
                                            addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.65625), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                        EndIf
                                    Case $03,$04
                                        local95 = copyentity(local90[local3\Field1\Field18\Field0[((local98 * $13) + local97)]], $00)
                                        addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.65625), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                    Case $05,$06
                                        local95 = copyentity(local90[$05], $00)
                                        addlight(local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 1.597656), (local3\Field1\Field5 + ((Float local98) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                                End Select
                                scaleentity(local95, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                                rotateentity(local95, 0.0, ((Float local3\Field1\Field18\Field1[((local98 * $13) + local97)]) * 90.0), 0.0, $00)
                                positionentity(local95, (local3\Field1\Field3 + ((Float local97) * 2.0)), (local3\Field1\Field4 + 8.0), (local3\Field1\Field5 + ((Float local98) * 2.0)), $01)
                                local37 = entityyaw(local95, $01)
                                local45 = sin(local37)
                                local46 = cos(local37)
                                If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $07) Then
                                    addlight(local3\Field1, (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 521.0) * (1.0 / 256.0))) + ((local46 * 16.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + (1.0 / 0.64)), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 521.0) * (1.0 / 256.0))) + ((local45 * 16.0) * (1.0 / 256.0))), $02, 0.425, $FF, $C8, $C8, $01)
                                    createprop(local3\Field1, "GFX\Map\Props\tank2.b3d", (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 369.0) * (1.0 / 256.0))) + ((local46 * 320.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) - 0.5625), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 369.0) * (1.0 / 256.0))) + ((local45 * 320.0) * (1.0 / 256.0))), 0.0, (local37 + 180.0), 0.0, 3.0, 3.0, 3.0, $01, $00, "")
                                    createprop(local3\Field1, "GFX\Map\Props\tank2.b3d", (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 977.0) * (1.0 / 256.0))) + ((local46 * 320.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) - 0.5625), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 977.0) * (1.0 / 256.0))) + ((local45 * 320.0) * (1.0 / 256.0))), 0.0, (local37 + 180.0), 0.0, 3.0, 3.0, 3.0, $01, $00, "")
                                ElseIf (((local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $05) Lor (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $06)) <> 0) Then
                                    addlight(local3\Field1, ((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local46 * 560.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + 1.832031), ((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local45 * 560.0) * (1.0 / 256.0))), $02, 0.25, $FF, $C8, $C8, $01)
                                    createprop(local3\Field1, "GFX\Map\Props\lamp_e.b3d", (((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local45 * 252.0) * (1.0 / 256.0))) + ((local46 * 560.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + 1.6875), (((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local46 * 252.0) * (1.0 / 256.0))) + ((local45 * 560.0) * (1.0 / 256.0))), 0.0, (local37 + 270.0), 90.0, 400.0, 400.0, 400.0, $00, $00, "")
                                    createprop(local3\Field1, "GFX\Map\Props\lamp_e.b3d", (((local3\Field1\Field3 + ((Float local97) * 2.0)) - ((local45 * 252.0) * (1.0 / 256.0))) + ((local46 * 560.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + 1.6875), (((local3\Field1\Field5 + ((Float local98) * 2.0)) - ((local46 * 252.0) * (1.0 / 256.0))) + ((local45 * 560.0) * (1.0 / 256.0))), 0.0, (local37 + 90.0), 90.0, 400.0, 400.0, 400.0, $00, $00, "")
                                    local16 = createdoor(Null, ((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local46 * 256.0) * (1.0 / 256.0))), (local3\Field1\Field4 + 8.0), ((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local45 * 256.0) * (1.0 / 256.0))), (local37 - 90.0), $00, $01, $00, $00, $00)
                                    positionentity(local16\Field24[$01], (entityx(local16\Field24[$01], $01) + (local46 * 0.05)), (entityy(local16\Field24[$01], $01) + 0.1), (entityz(local16\Field24[$01], $01) + (local45 * -0.28)), $01)
                                    rotateentity(local16\Field24[$01], (entitypitch(local16\Field24[$01], $01) + 45.0), entityyaw(local16\Field24[$01], $01), entityroll(local16\Field24[$01], $01), $01)
                                    local96 = createpivot($00)
                                    positionentity(local96, ((local3\Field1\Field3 + ((Float local97) * 2.0)) + ((local46 * 552.0) * (1.0 / 256.0))), ((local3\Field1\Field4 + 8.0) + 0.9375), ((local3\Field1\Field5 + ((Float local98) * 2.0)) + ((local45 * 552.0) * (1.0 / 256.0))), $00)
                                    If (local3\Field1\Field18\Field0[((local98 * $13) + local97)] = $06) Then
                                        If (local3\Field1\Field14[$01] <> Null) Then
                                            removedoor(local16)
                                        Else
                                            local16\Field6 = (local3\Field1\Field14[$00]\Field6 = $00)
                                            local3\Field1\Field14[$01] = local16
                                        EndIf
                                        If (local3\Field1\Field11[$03] = $00) Then
                                            local3\Field1\Field11[$03] = local96
                                            rotateentity(local3\Field1\Field11[$03], 0.0, local37, 0.0, $01)
                                            positionentity(local3\Field1\Field11[$01], (local3\Field1\Field3 + ((Float local97) * 2.0)), entityy(local3\Field1\Field11[$01], $01), (local3\Field1\Field5 + ((Float local98) * 2.0)), $01)
                                        Else
                                            freeentity(local96)
                                            local96 = $00
                                        EndIf
                                    Else
                                        If (local3\Field1\Field14[$03] <> Null) Then
                                            removedoor(local16)
                                        Else
                                            local16\Field6 = (local3\Field1\Field14[$02]\Field6 = $00)
                                            local3\Field1\Field14[$03] = local16
                                        EndIf
                                        If (local3\Field1\Field11[$05] = $00) Then
                                            local3\Field1\Field11[$05] = local96
                                            rotateentity(local3\Field1\Field11[$05], 0.0, (local37 + 180.0), 0.0, $01)
                                            positionentity(local3\Field1\Field11[$00], (local3\Field1\Field3 + ((Float local97) * 2.0)), entityy(local3\Field1\Field11[$00], $01), (local3\Field1\Field5 + ((Float local98) * 2.0)), $01)
                                        Else
                                            freeentity(local96)
                                            local96 = $00
                                        EndIf
                                    EndIf
                                EndIf
                                local3\Field1\Field18\Field3[((local98 * $13) + local97)] = local95
                                local15 = createwaypoint(Null, local3\Field1, (local3\Field1\Field3 + ((Float local97) * 2.0)), ((local3\Field1\Field4 + 8.0) + 0.2), (local3\Field1\Field5 + ((Float local98) * 2.0)))
                                local3\Field1\Field18\Field4[((local98 * $13) + local97)] = local15
                                If (local98 < $12) Then
                                    If (local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)] <> Null) Then
                                        local38 = entitydistance(local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field0, local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field0)
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]
                                                local3\Field1\Field18\Field4[(((local98 + $01) * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                                If (local98 > $00) Then
                                    If (local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)] <> Null) Then
                                        local38 = entitydistance(local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field0, local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]\Field0)
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]
                                                local3\Field1\Field18\Field4[(((local98 - $01) * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                                If (local97 > $00) Then
                                    If (local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))] <> Null) Then
                                        local38 = entitydistance(local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field0, local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]\Field0)
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]
                                                local3\Field1\Field18\Field4[((local97 - $01) + (local98 * $13))]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                                If (local97 < $12) Then
                                    If (local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))] <> Null) Then
                                        local38 = entitydistance(local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field0, local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]\Field0)
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]
                                                local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                        For local20 = $00 To $03 Step $01
                                            If (local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]) Then
                                                Exit
                                            ElseIf (local3\Field1\Field18\Field4[((local98 * $13) + local97)]\Field4[local20] = Null) Then
                                                local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]\Field4[local20] = local3\Field1\Field18\Field4[((local98 * $13) + local97)]
                                                local3\Field1\Field18\Field4[((local97 + $01) + (local98 * $13))]\Field5[local20] = local38
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    Next
                    For local20 = $00 To $06 Step $01
                        local3\Field1\Field18\Field2[local20] = local90[local20]
                    Next
                    seedrnd(local99)
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    updatemt(local3\Field1\Field18, getrealcollider())
                    If (infacility = $01) Then
                        If (event_ismeinroom(local3) <> 0) Then
                            shouldplay = $1C
                            me\Field59 = $01
                        EndIf
                    EndIf
                    If (isinfacility(entityy(event_getsomebodypivot(local3), $00)) = $01) Then
                        If (0.0 = local3\Field2) Then
                            local23 = ($01 - (entitydistancesquared(me\Field60, local3\Field1\Field11[$01]) > entitydistancesquared(me\Field60, local3\Field1\Field11[$00])))
                            If ((((n_i\Field3\Field65 = $00) And (2.0 > n_i\Field3\Field10)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                n_i\Field3\Field36 = entityx(local3\Field1\Field11[local23], $01)
                                n_i\Field3\Field37 = entityy(me\Field60, $00)
                                n_i\Field3\Field38 = entityz(local3\Field1\Field11[local23], $01)
                                n_i\Field3\Field10 = 2.0
                            EndIf
                            For local20 = $00 To $01 Step $01
                                local111 = Null
                                For local34 = ((Float local20) * 72.2) To 360.0 Step 1.0
                                    If (((rand($02, $01) = $01) And (local3\Field1\Field18\Field4[(Int local34)] <> Null)) <> 0) Then
                                        local111 = local3\Field1\Field18\Field4[(Int local34)]
                                        local34 = 361.0
                                    EndIf
                                Next
                                If (local111 <> Null) Then
                                    createnpc($0C, entityx(local111\Field0, $01), entityy(local111\Field0, $01), entityz(local111\Field0, $01))
                                EndIf
                            Next
                            local3\Field2 = 1.0
                        EndIf
                    EndIf
                    local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$00], local3\Field1\Field14[$01], local3\Field1\Field11[$02], local3\Field1\Field11[$03], local3, $00, ((1.0 = local3\Field2) And (1.0 < n_i\Field3\Field10)), $00)
                    local3\Field26 = mp_updateelevators(local3\Field26, local3\Field1\Field14[$02], local3\Field1\Field14[$03], local3\Field1\Field11[$04], local3\Field1\Field11[$05], local3, $00, ((1.0 = local3\Field2) And (1.0 < n_i\Field3\Field10)), $00)
                ElseIf (((local3\Field1\Field18 <> Null) And (local3\Field1\Field18\Field2[$00] <> $00)) <> 0) Then
                    For local98 = $00 To $12 Step $01
                        For local97 = $00 To $12 Step $01
                            If (local3\Field1\Field18\Field3[((local98 * $13) + local97)] <> $00) Then
                                If (entityhidden(local3\Field1\Field18\Field3[((local98 * $13) + local97)]) = $00) Then
                                    hideentity(local3\Field1\Field18\Field3[((local98 * $13) + local97)])
                                EndIf
                            EndIf
                        Next
                    Next
                EndIf
            Case $19
                If (n_i\Field3\Field65 = $00) Then
                    If (0.0 = local3\Field2) Then
                        If ((event_isplayerinroom(local3) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                            local3\Field2 = 1.0
                        EndIf
                    Else
                        local48 = (fps\Field7[$00] * 0.7)
                        local3\Field2 = (local3\Field2 + local48)
                        If (((0.3 < (local3\Field2 / 250.0)) And (0.3 >= ((local3\Field2 - local48) / 250.0))) <> 0) Then
                            local3\Field6 = playsound_strict(snd_i\Field47[$06], $00)
                            me\Field49 = 800.0
                            local5 = createdecal($00, entityx(local3\Field1\Field11[$02], $01), entityy(local3\Field1\Field11[$02], $01), entityz(local3\Field1\Field11[$02], $01), 0.0, ((Float local3\Field1\Field6) - 90.0), rnd(360.0, 0.0), 0.1, 0.01, $00, $01, $00, $00, $00)
                            local5\Field4 = 0.003
                            local5\Field7 = 0.005
                            local5\Field13 = 90000.0
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                        EndIf
                        If (((0.65 < (local3\Field2 / 250.0)) And (0.65 >= ((local3\Field2 - local48) / 250.0))) <> 0) Then
                            local5 = createdecal($00, entityx(local3\Field1\Field11[$03], $01), entityy(local3\Field1\Field11[$03], $01), entityz(local3\Field1\Field11[$03], $01), 0.0, ((Float local3\Field1\Field6) + 90.0), rnd(360.0, 0.0), 0.1, 0.01, $00, $01, $00, $00, $00)
                            local5\Field4 = 0.003
                            local5\Field7 = 0.005
                            local5\Field13 = 90000.0
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                        EndIf
                        If (50.0 > local3\Field2) Then
                            n_i\Field3\Field26 = 1.0
                            positionentity(n_i\Field3\Field3, entityx(local3\Field1\Field11[$00], $01), 0.0, entityz(local3\Field1\Field11[$00], $01), $00)
                            pointentity(n_i\Field3\Field3, local3\Field1\Field11[$01], 0.0)
                            moveentity(n_i\Field3\Field3, 0.0, 0.0, ((entitydistance(local3\Field1\Field11[$00], local3\Field1\Field11[$01]) * 0.5) * (local3\Field2 / 50.0)))
                            animatenpc(n_i\Field3, 284.0, 333.0, 0.7, $01)
                        ElseIf (200.0 > local3\Field2) Then
                            n_i\Field3\Field26 = 1.0
                            animatenpc(n_i\Field3, 334.0, 494.0, 0.2, $01)
                            positionentity(n_i\Field3\Field3, ((entityx(local3\Field1\Field11[$00], $01) + entityx(local3\Field1\Field11[$01], $01)) / 2.0), 0.0, ((entityz(local3\Field1\Field11[$00], $01) + entityz(local3\Field1\Field11[$01], $01)) / 2.0), $00)
                            rotateentity(n_i\Field3\Field3, 0.0, curvevalue(local3\Field2, entityyaw(n_i\Field3\Field3, $00), 30.0), 0.0, $01)
                            If (16.0 > entitydistancesquared(n_i\Field3\Field3, me\Field60)) Then
                                local25 = createpivot($00)
                                positionentity(local25, entityx(n_i\Field3\Field3, $00), entityy(n_i\Field3\Field3, $00), entityz(n_i\Field3\Field3, $00), $00)
                                pointentity(local25, me\Field60, 0.0)
                                If (((80.0 > wrapangle((entityyaw(local25, $00) - entityyaw(n_i\Field3\Field3, $00)), 360.0)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                    n_i\Field3\Field26 = 0.0
                                    n_i\Field3\Field10 = 3.0
                                    n_i\Field3\Field11 = 0.0
                                    n_i\Field3\Field12 = rnd(3000.0, 3500.0)
                                    playsound_strict(snd_i\Field47[$0A], $00)
                                    freeentity(local25)
                                    local25 = $00
                                    removeevent(local3)
                                Else
                                    freeentity(local25)
                                    local25 = $00
                                EndIf
                            EndIf
                        ElseIf (250.0 > local3\Field2) Then
                            n_i\Field3\Field26 = 1.0
                            positionentity(n_i\Field3\Field3, entityx(local3\Field1\Field11[$00], $01), 0.0, entityz(local3\Field1\Field11[$00], $01), $00)
                            pointentity(n_i\Field3\Field3, local3\Field1\Field11[$01], 0.0)
                            moveentity(n_i\Field3\Field3, 0.0, 0.0, (entitydistance(local3\Field1\Field11[$00], local3\Field1\Field11[$01]) * ((local3\Field2 - 150.0) / 100.0)))
                            animatenpc(n_i\Field3, 284.0, 333.0, 0.7, $01)
                        EndIf
                        resetentity(n_i\Field3\Field3)
                        n_i\Field3\Field18 = loopsoundex(snd_i\Field45[$04], n_i\Field3\Field18, camera, n_i\Field3\Field3, 8.0, 0.8, $01)
                        positionentity(n_i\Field3\Field0, entityx(n_i\Field3\Field3, $00), entityy(n_i\Field3\Field3, $00), entityz(n_i\Field3\Field3, $00), $00)
                        rotateentity(n_i\Field3\Field0, 0.0, entityyaw(n_i\Field3\Field3, $00), 0.0, $00)
                        If (250.0 < local3\Field2) Then
                            n_i\Field3\Field26 = 0.0
                            n_i\Field3\Field10 = 0.0
                            n_i\Field3\Field11 = rnd(22000.0, 27000.0)
                            stopchannel(n_i\Field3\Field18)
                            n_i\Field3\Field18 = $00
                            removeevent(local3)
                        EndIf
                    EndIf
                Else
                    removeevent(local3)
                EndIf
            Case $1A
                If (n_i\Field3\Field65 = $00) Then
                    If (0.0 < n_i\Field3\Field10) Then
                        If (0.0 = local3\Field2) Then
                            If ((event_isplayerinroom(local3) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                                local3\Field2 = 1.0
                            EndIf
                        ElseIf (1.0 = local3\Field2) Then
                            If (2.0 > n_i\Field3\Field10) Then
                                tformpoint(-864.0, -447.0, -632.0, local3\Field1\Field2, $00)
                                n_i\Field3\Field36 = tformedx()
                                n_i\Field3\Field37 = tformedy()
                                n_i\Field3\Field38 = tformedz()
                                n_i\Field3\Field10 = 2.0
                            EndIf
                            removeevent(local3)
                        EndIf
                    EndIf
                Else
                    removeevent(local3)
                EndIf
            Case $26
                If (event_isplayerinroom(local3) <> 0) Then
                    If (local3\Field1\Field11[$00] = $00) Then
                        tformpoint(704.0, 112.0, -416.0, local3\Field1\Field2, $00)
                        local3\Field1\Field11[$00] = copyentity(n_i\Field0[$1C], $00)
                        scaleentity(local3\Field1\Field11[$00], 0.07, 0.07, 0.07, $00)
                        positionentity(local3\Field1\Field11[$00], tformedx(), tformedy(), tformedz(), $00)
                        rotateentity(local3\Field1\Field11[$00], 0.0, rnd(360.0, 0.0), 0.0, $00)
                        local28 = loadtexture_strict("GFX\NPCs\duck(3).png", $01, $00, $01)
                        entitytexture(local3\Field1\Field11[$00], local28, $00, $00)
                        deletesingletextureentryfromcache(local28, $00)
                        local28 = $00
                        entityparent(local3\Field1\Field11[$00], local3\Field1\Field2, $01)
                    ElseIf (entityinview(local3\Field1\Field11[$00], camera) = $00) Then
                        local3\Field2 = (local3\Field2 + fps\Field7[$00])
                        If (((rand($C8, $01) = $01) And (300.0 < local3\Field2)) <> 0) Then
                            local3\Field6 = playsoundex(loadtempsound("SFX\SCP\Joke\Saxophone.ogg"), camera, local3\Field1\Field11[$00], 6.0, 1.0, $00, $00)
                            local3\Field2 = 0.0
                        EndIf
                    ElseIf (channelplaying(local3\Field6) <> 0) Then
                        stopchannel(local3\Field6)
                        local3\Field6 = $00
                    EndIf
                EndIf
            Case $27
                If (5.0 > local3\Field18) Then
                    If (local3\Field1\Field15[$00] = Null) Then
                        tformpoint(704.0, 132.0, -416.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($0E, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$00]\Field10 = 3.0
                        pointentity(local3\Field1\Field15[$00]\Field3, local3\Field1\Field2, 0.0)
                        setnpcframe(local3\Field1\Field15[$00], 326.0, $01)
                        local112 = (("drawing_1048(" + (Str rand($19, $01))) + ").png")
                        For local19 = Each itemtemplates
                            If (local19\Field1 = "Drawing") Then
                                If (local19\Field11 <> $00) Then
                                    freeimage(local19\Field11)
                                    local19\Field11 = $00
                                EndIf
                                local19\Field10 = ("GFX\Items\HUD Textures\" + local112)
                                local19\Field20 = local19\Field10
                                local28 = getrescaledtexture(local19\Field20, $01, $100, $100, $00)
                                entitytexture(local19\Field5, local28, $00, $00)
                                deletesingletextureentryfromcache(local28, $00)
                                local28 = $00
                                Exit
                            EndIf
                        Next
                        local113 = getrescaledtexture(("GFX\Items\HUD Textures\" + local112), $01, $100, $100, $01)
                        local43 = countsurfaces(local3\Field1\Field15[$00]\Field0)
                        For local20 = $01 To local43 Step $01
                            local41 = getsurface(local3\Field1\Field15[$00]\Field0, local20)
                            local39 = getsurfacebrush(local41)
                            local40 = getbrushtexture(local39, $00)
                            local42 = strippath(texturename(local40))
                            If (lower(local42) <> "scp_1048.png") Then
                                paintsurface(local41, local113)
                            EndIf
                            freebrush(local39)
                            local39 = $00
                            freetexture(local40)
                            local40 = $00
                        Next
                        freebrush(local113)
                        local113 = $00
                        local3\Field2 = 1.0
                    Else
                        event_resetprev()
                        If (474.0 < local3\Field1\Field15[$00]\Field14) Then
                            If (mp_interactobject(local3\Field1, $00, 1.5, $00, $01) <> 0) Then
                                If (getitemamount() < maxitemamount) Then
                                    selecteditem = createitem("Drawing", $00, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                    entitytype(selecteditem\Field2, $03, $00)
                                    pickitem(selecteditem, $01)
                                    removenpc(local3\Field1\Field15[$00])
                                    removeevent(local3)
                                Else
                                    createmsg(getlocalstring("msg", "cantcarry"), 6.0)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $38
                If (event_isplayerinroom(local3) <> 0) Then
                    If (0.0 = local3\Field2) Then
                        If (local3\Field1\Field14[$00]\Field6 <> 0) Then
                            If (180.0 = local3\Field1\Field14[$00]\Field8) Then
                                If (local3\Field23 <> 0) Then
                                    playsound_strict(snd_i\Field47[$05], $00)
                                EndIf
                                local3\Field2 = 1.0
                            EndIf
                        ElseIf (((2.25 > entitydistancesquared(me\Field60, local3\Field1\Field14[$00]\Field0)) And remotedooron) <> 0) Then
                            playsoundex(snd_i\Field4, camera, local3\Field1\Field14[$00]\Field2, 7.0, 1.0, $00, $00)
                            openclosedoor(local3\Field1\Field14[$00], $01, $00)
                        EndIf
                    ElseIf (local3\Field1\Field11[$00] = $00) Then
                        tformpoint(-808.0, 150.0, -72.0, local3\Field1\Field2, $00)
                        local3\Field1\Field11[$00] = createpivot($00)
                        positionentity(local3\Field1\Field11[$00], tformedx(), tformedy(), tformedz(), $00)
                        entityparent(local3\Field1\Field11[$00], local3\Field1\Field2, $01)
                    ElseIf (4.0 > entitydistancesquared(local3\Field1\Field11[$00], me\Field60)) Then
                        If (event_ismeinroom(local3) <> 0) Then
                            me\Field30 = curvevalue(0.5, me\Field30, 5.0)
                            me\Field28 = curvevalue(120.0, me\Field28, 150.0)
                            me\Field31 = (me\Field31 + (fps\Field7[$00] * 0.00005))
                        EndIf
                        local3\Field6 = loopsoundex(snd_i\Field45[$04], local3\Field6, camera, local3\Field1\Field2, 5.0, 0.3, $01)
                        If (n_i\Field3\Field65 = $00) Then
                            If (0.0 < n_i\Field3\Field11) Then
                                n_i\Field3\Field11 = (n_i\Field3\Field11 - (fps\Field7[$00] * 3.0))
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $20
                If (local3\Field8 = $00) Then
                    If (event_isplayerinroom(local3) <> 0) Then
                        For local20 = $00 To $01 Step $01
                            openclosedoor(local3\Field1\Field14[local20], $01, $00)
                            local3\Field1\Field14[local20]\Field4 = $01
                        Next
                        tformpoint(-352.0, 150.0, 0.0, local3\Field1\Field2, $00)
                        If (n_i\Field4 <> Null) Then
                            positionentity(n_i\Field4\Field3, tformedx(), tformedy(), tformedz(), $00)
                            resetentity(n_i\Field4\Field3)
                        Else
                            n_i\Field4 = createnpc($05, tformedx(), tformedy(), tformedz())
                        EndIf
                        n_i\Field4\Field10 = 6.0
                        n_i\Field4\Field11 = 700.0
                        rotateentity(n_i\Field4\Field3, 0.0, ((Float local3\Field1\Field6) + 270.0), 0.0, $01)
                        mp_loadeventsound(local3, "SFX\Character\Guard\096ServerRoom0.ogg", $00)
                        local3\Field6 = playsoundex(local3\Field8, camera, n_i\Field4\Field0, 10.0, 1.0, $01, $00)
                        tformpoint(-1328.0, 150.0, 528.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($14, tformedx(), tformedy(), tformedz())
                        giveachievement("096", $01)
                        local3\Field2 = 1.0
                    EndIf
                ElseIf (3150.0 > local3\Field2) Then
                    If (((rand($32, $01) = $01) And event_ismeinroom(local3)) <> 0) Then
                        me\Field50 = rnd(1.0, 2.0)
                        If (rand($05, $01) = $01) Then
                            playsoundex(snd_i\Field33[rand($00, $02)], camera, local3\Field1\Field2, 8.0, rnd(0.1, 0.3), $00, $00)
                        EndIf
                    EndIf
                    If (n_i\Field4 <> Null) Then
                        local3\Field2 = min((local3\Field2 + fps\Field7[$00]), 2800.0)
                        If (local3\Field1\Field15[$00] <> Null) Then
                            n_i\Field4\Field34 = local3\Field1\Field15[$00]
                            If (560.0 > local3\Field2) Then
                                animatenpc(n_i\Field4, 472.0, 520.0, 0.25, $01)
                                pointentity(local3\Field1\Field15[$00]\Field3, n_i\Field4\Field3, 0.0)
                            ElseIf (((560.0 <= local3\Field2) And (700.0 > local3\Field2)) <> 0) Then
                                If (entitydistancesquared(me\Field60, local3\Field1\Field14[$01]\Field2) > entitydistancesquared(me\Field60, local3\Field1\Field14[$00]\Field2)) Then
                                    animatenpc(n_i\Field4, 521.0, 555.0, 0.25, $00)
                                    If (554.5 <= n_i\Field4\Field14) Then
                                        setnpcframe(n_i\Field4, 677.0, $01)
                                        n_i\Field4\Field10 = 2.0
                                        turnentity(n_i\Field4\Field3, 0.0, 180.0, 0.0, $00)
                                        moveentity(n_i\Field4\Field3, 0.0, 0.0, 0.3)
                                        local3\Field2 = 700.0
                                    EndIf
                                Else
                                    animatenpc(n_i\Field4, 556.0, 590.0, 0.25, $00)
                                    If (589.5 <= n_i\Field4\Field14) Then
                                        setnpcframe(n_i\Field4, 677.0, $01)
                                        n_i\Field4\Field10 = 2.0
                                        turnentity(n_i\Field4\Field3, 0.0, 180.0, 0.0, $00)
                                        moveentity(n_i\Field4\Field3, 0.0, 0.0, 0.3)
                                        local3\Field2 = 700.0
                                    EndIf
                                EndIf
                                pointentity(local3\Field1\Field15[$00]\Field3, n_i\Field4\Field3, 0.0)
                            ElseIf (((700.0 <= local3\Field2) And (1400.0 > local3\Field2)) <> 0) Then
                                n_i\Field4\Field10 = clamp(n_i\Field4\Field10, 2.0, 4.0)
                                n_i\Field4\Field11 = max(n_i\Field4\Field11, 840.0)
                                If (1050.0 >= (local3\Field2 - fps\Field7[$00])) Then
                                    If (1050.0 < local3\Field2) Then
                                        local3\Field1\Field15[$00]\Field10 = 14.0
                                        local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], entityx(n_i\Field4\Field3, $01), 0.4, entityz(n_i\Field4\Field3, $01))
                                        local3\Field1\Field15[$00]\Field41 = 300.0
                                    Else
                                        pointentity(local3\Field1\Field15[$00]\Field3, n_i\Field4\Field3, 0.0)
                                    EndIf
                                EndIf
                                If (entityvisible(local3\Field1\Field15[$00]\Field3, n_i\Field4\Field3) <> 0) Then
                                    local3\Field1\Field15[$00]\Field10 = 13.0
                                    pointentity(local3\Field1\Field15[$00]\Field0, n_i\Field4\Field3, 0.0)
                                    rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 30.0), 0.0, $00)
                                EndIf
                            ElseIf (5.0 = n_i\Field4\Field10) Then
                                n_i\Field4\Field29 = $01
                                local3\Field1\Field15[$00]\Field10 = 2.0
                                pointentity(local3\Field1\Field15[$00]\Field0, n_i\Field4\Field3, 0.0)
                                rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 30.0), 0.0, $00)
                                If (event_ismeinroom(local3) <> 0) Then
                                    me\Field50 = (local3\Field1\Field15[$00]\Field28 + rnd(0.5, 2.0))
                                EndIf
                                n_i\Field4\Field34 = local3\Field1\Field15[$00]
                            Else
                                If (1540.0 < local3\Field2) Then
                                    n_i\Field4\Field10 = 5.0
                                EndIf
                                If (13.0 = local3\Field1\Field15[$00]\Field10) Then
                                    local3\Field1\Field15[$00]\Field10 = 14.0
                                    local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], entityx(local3\Field1\Field2, $01), 0.4, entityz(local3\Field1\Field2, $01))
                                    local3\Field1\Field15[$00]\Field41 = 300.0
                                    local3\Field1\Field15[$00]\Field23 = (local3\Field1\Field15[$00]\Field23 * 1.5)
                                EndIf
                            EndIf
                            If (((25.0 < n_i\Field4\Field14) And (150.0 > n_i\Field4\Field14)) <> 0) Then
                                mp_loadeventsound(local3, "SFX\Character\Guard\096ServerRoom1.ogg", $00)
                                local3\Field6 = playsoundex(local3\Field8, camera, n_i\Field4\Field0, 10.0, 1.0, $01, $00)
                                changenpctextureid(n_i\Field4, $12)
                                n_i\Field4\Field24 = 0.0
                                For local20 = $00 To $06 Step $01
                                    If (((0.0 = (Float local3\Field1\Field6)) Lor (180.0 = (Float local3\Field1\Field6))) <> 0) Then
                                        local46 = ((rnd(197.0, 199.0) * cos((Float local3\Field1\Field6))) * (1.0 / 256.0))
                                        local5 = createdecal(rand($02, $03), (local3\Field1\Field3 - local46), (local3\Field1\Field4 + 1.0), (local3\Field1\Field5 + ((140.0 * (Float (local20 - $03))) * (1.0 / 256.0))), 0.0, ((Float local3\Field1\Field6) + 90.0), rnd(360.0, 0.0), rnd(0.8, 0.85), 1.0, $00, $01, $00, $00, $00)
                                        local5\Field4 = 0.001
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                        local5 = createdecal(rand($02, $03), (local3\Field1\Field3 - local46), (local3\Field1\Field4 + 1.0), (local3\Field1\Field5 + ((140.0 * (Float (local20 - $03))) * (1.0 / 256.0))), 0.0, ((Float local3\Field1\Field6) - 90.0), rnd(360.0, 0.0), rnd(0.8, 0.85), 1.0, $00, $01, $00, $00, $00)
                                        local5\Field4 = 0.001
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                    Else
                                        local45 = (((rnd(197.0, 199.0) * sin((Float local3\Field1\Field6))) * (1.0 / 256.0)) - rnd(0.001, 0.003))
                                        local5 = createdecal(rand($02, $03), (local3\Field1\Field3 + ((140.0 * (Float (local20 - $03))) * (1.0 / 256.0))), (local3\Field1\Field4 + 1.0), (local3\Field1\Field5 - local45), 0.0, ((Float local3\Field1\Field6) + 90.0), rnd(360.0, 0.0), rnd(0.8, 0.85), 1.0, $00, $01, $00, $00, $00)
                                        local5\Field4 = 0.001
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                        local5 = createdecal(rand($02, $03), (local3\Field1\Field3 + ((140.0 * (Float (local20 - $03))) * (1.0 / 256.0))), (local3\Field1\Field4 + 1.0), (local3\Field1\Field5 - local45), 0.0, ((Float local3\Field1\Field6) - 90.0), rnd(360.0, 0.0), rnd(0.8, 0.85), 1.0, $00, $01, $00, $00, $00)
                                        local5\Field4 = 0.001
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                    EndIf
                                    local5 = createdecal(rand($02, $03), (entityx(local3\Field1\Field15[$00]\Field3, $00) + rnd(-2.0, 2.0)), (local3\Field1\Field4 + 0.005), (entityz(local3\Field1\Field15[$00]\Field3, $00) + rnd(-2.0, 2.0)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
                                    entityparent(local5\Field0, local3\Field1\Field2, $01)
                                Next
                                local5 = createdecal(rand($02, $03), entityx(local3\Field1\Field15[$00]\Field3, $00), (local3\Field1\Field4 + 0.005), entityz(local3\Field1\Field15[$00]\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
                                entityparent(local5\Field0, local3\Field1\Field2, $01)
                                stopstream_strict(n_i\Field4\Field18)
                                n_i\Field4\Field18 = $00
                                n_i\Field4\Field21 = $00
                                showentity(local3\Field1\Field11[$00])
                                local11 = createitem("Bloody Level 3 Key Card", $5C, entityx(local3\Field1\Field15[$00]\Field3, $00), (entityy(local3\Field1\Field15[$00]\Field3, $00) + 0.1), entityz(local3\Field1\Field15[$00]\Field3, $00), $00, $00, $00, 1.0, $00)
                                entitytype(local11\Field2, $03, $00)
                                removenpc(local3\Field1\Field15[$00])
                                local3\Field1\Field15[$00] = Null
                                n_i\Field4\Field10 = 1.0
                            EndIf
                        Else
                            If (((2450.0 <= local3\Field2) And (2450.0 > (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                For local20 = $00 To $01 Step $01
                                    openclosedoor(local3\Field1\Field14[local20], $01, $00)
                                Next
                            EndIf
                            If (event_isplayerinroom(local3) <> 0) Then
                                If (channelplaying(local3\Field6) <> 0) Then
                                    If (event_ismeinroom(local3) <> 0) Then
                                        me\Field50 = rnd(0.5, 6.0)
                                        If (rand($32, $01) = $01) Then
                                            playsoundex(snd_i\Field33[rand($00, $02)], camera, local3\Field1\Field2, 8.0, rnd(0.1, 0.3), $00, $00)
                                        EndIf
                                    EndIf
                                EndIf
                                If (((0.0 = (Float local3\Field1\Field6)) Lor (180.0 = (Float local3\Field1\Field6))) <> 0) Then
                                    If (1.12 < (Abs (entityx(me\Field60, $00) - entityx(local3\Field1\Field2, $01)))) Then
                                        If (((2.0 < entitydistancesquared(me\Field60, local3\Field1\Field14[$00]\Field2)) And (2.0 < entitydistancesquared(me\Field60, local3\Field1\Field14[$01]\Field2))) <> 0) Then
                                            local3\Field2 = 3150.0
                                        EndIf
                                    EndIf
                                ElseIf (1.12 < (Abs (entityz(me\Field60, $00) - entityz(local3\Field1\Field2, $01)))) Then
                                    If (((2.0 < entitydistancesquared(me\Field60, local3\Field1\Field14[$00]\Field2)) And (2.0 < entitydistancesquared(me\Field60, local3\Field1\Field14[$01]\Field2))) <> 0) Then
                                        local3\Field2 = 3150.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        updatesoundorigin(local3\Field6, camera, n_i\Field4\Field0, 10.0, 1.0, $01, $01)
                    EndIf
                ElseIf (event_isplayerinroom(local3) <> 0) Then
                    local23 = updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                    local31 = (Float updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0))
                    local33 = (Float updatelever(local3\Field1\Field13[$02]\Field0, $00, $50, -80.0))
                    If ((Int local31) <> 0) Then
                        local3\Field3 = min(1.0, (local3\Field3 + (fps\Field7[$00] / 350.0)))
                        If ((Int local33) <> 0) Then
                            mp_loadeventsound(local3, "SFX\Room\GeneratorOn.ogg", $01)
                            local3\Field4 = min(1.0, (local3\Field4 + (fps\Field7[$00] / 450.0)))
                        Else
                            local3\Field4 = min(0.0, (local3\Field4 - (fps\Field7[$00] / 450.0)))
                        EndIf
                    Else
                        local3\Field3 = max(0.0, (local3\Field3 - (fps\Field7[$00] / 350.0)))
                        local3\Field4 = max(0.0, (local3\Field4 - (fps\Field7[$00] / 450.0)))
                    EndIf
                    If (0.0 < local3\Field3) Then
                        local3\Field6 = loopsoundex(roomambience[$07], local3\Field6, camera, local3\Field1\Field13[$01]\Field1, 5.0, (local3\Field3 * 0.8), $00)
                    EndIf
                    If (0.0 < local3\Field4) Then
                        local3\Field7 = loopsoundex(local3\Field9, local3\Field7, camera, local3\Field1\Field13[$01]\Field1, 6.0, local3\Field4, $00)
                    EndIf
                    If (((local23 And (Int local31)) And (Int local33)) <> 0) Then
                        For local20 = $00 To $01 Step $01
                            local3\Field1\Field14[local20]\Field4 = $00
                        Next
                    Else
                        If (((rand($32, $01) = $01) And event_ismeinroom(local3)) <> 0) Then
                            me\Field50 = rnd(0.5, 1.0)
                        EndIf
                        For local20 = $00 To $01 Step $01
                            If (local3\Field1\Field14[local20]\Field6 <> 0) Then
                                openclosedoor(local3\Field1\Field14[local20], $01, $00)
                                local3\Field1\Field14[local20]\Field4 = $01
                            EndIf
                        Next
                    EndIf
                EndIf
            Case $0B
                If (event_issomebodyinroom(local3) <> 0) Then
                    If (0.0 >= local3\Field3) Then
                        local3\Field1\Field14[$01]\Field4 = $00
                        local3\Field1\Field14[$04]\Field4 = $00
                        If (((64.0 > entitydistancesquared(local3\Field1\Field2, n_i\Field2\Field3)) Lor (64.0 > entitydistancesquared(local3\Field1\Field2, n_i\Field3\Field3))) <> 0) Then
                            local3\Field1\Field14[$01]\Field4 = $01
                            local3\Field1\Field14[$01]\Field6 = $00
                            local3\Field1\Field14[$04]\Field4 = $01
                            local3\Field1\Field14[$04]\Field6 = $00
                        EndIf
                        For local1 = Each npcs
                            If (local1\Field4 = $15) Then
                                If (36.0 > entitydistancesquared(local1\Field3, local3\Field1\Field2)) Then
                                    local3\Field1\Field14[$01]\Field4 = $01
                                    local3\Field1\Field14[$01]\Field6 = $00
                                    local3\Field1\Field14[$04]\Field4 = $01
                                    local3\Field1\Field14[$04]\Field6 = $00
                                    Exit
                                EndIf
                            EndIf
                        Next
                        local3\Field3 = 175.0
                    Else
                        local3\Field3 = (local3\Field3 - fps\Field7[$00])
                    EndIf
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local3\Field1\Field2)
                    If (0.0 = local3\Field1\Field14[$01]\Field8) Then
                        If (entityhidden(local3\Field1\Field11[$00]) = $00) Then
                            hideentity(local3\Field1\Field11[$00])
                        EndIf
                        hideentity(local3\Field1\Field14[$00]\Field0)
                        hideentity(local3\Field1\Field14[$00]\Field3[$01])
                        hideentity(local3\Field1\Field14[$00]\Field2)
                    Else
                        If (entityhidden(local3\Field1\Field11[$00]) <> 0) Then
                            showentity(local3\Field1\Field11[$00])
                        EndIf
                        showentity(local3\Field1\Field14[$00]\Field0)
                        showentity(local3\Field1\Field14[$00]\Field3[$01])
                        showentity(local3\Field1\Field14[$00]\Field2)
                    EndIf
                    If (0.0 = local3\Field1\Field14[$04]\Field8) Then
                        If (entityhidden(local3\Field1\Field11[$01]) = $00) Then
                            hideentity(local3\Field1\Field11[$01])
                        EndIf
                        hideentity(local3\Field1\Field14[$05]\Field0)
                        hideentity(local3\Field1\Field14[$05]\Field3[$01])
                        hideentity(local3\Field1\Field14[$05]\Field2)
                    Else
                        If (entityhidden(local3\Field1\Field11[$01]) <> 0) Then
                            showentity(local3\Field1\Field11[$01])
                        EndIf
                        showentity(local3\Field1\Field14[$05]\Field0)
                        showentity(local3\Field1\Field14[$05]\Field3[$01])
                        showentity(local3\Field1\Field14[$05]\Field2)
                    EndIf
                    If (8.0 > local3\Field2) Then
                        If (entityhidden(local3\Field1\Field11[$02]) = $00) Then
                            hideentity(local3\Field1\Field11[$02])
                        EndIf
                    ElseIf (entityhidden(local3\Field1\Field11[$02]) <> 0) Then
                        showentity(local3\Field1\Field11[$02])
                    EndIf
                    local23 = $00
                    If (730.0 < tformedx()) Then
                        giveachievement("970", $01)
                        me\Field10 = -10.0
                        updateworld(1.0)
                        tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local3\Field1\Field2)
                        For local20 = $01 To $02 Step $01
                            local114 = local3\Field1\Field14[(local20 + $02)]
                            local115 = local3\Field1\Field14[local20]
                            local115\Field6 = local114\Field6
                            local115\Field8 = local114\Field8
                            entityparent(local115\Field0, local115\Field2, $01)
                            entityparent(local114\Field0, local114\Field2, $01)
                            entityparent(local115\Field1, local115\Field2, $01)
                            entityparent(local114\Field1, local114\Field2, $01)
                            positionentity(local115\Field0, entityx(local114\Field0, $00), entityy(local114\Field0, $00), entityz(local114\Field0, $00), $00)
                            positionentity(local115\Field1, entityx(local114\Field1, $00), entityy(local114\Field1, $00), entityz(local114\Field1, $00), $00)
                            entityparent(local115\Field0, $00, $01)
                            entityparent(local114\Field0, $00, $01)
                            entityparent(local115\Field1, $00, $01)
                            entityparent(local114\Field1, $00, $01)
                            local114\Field6 = $00
                            local114\Field8 = 0.0
                        Next
                        tformpoint((tformedx() - 1024.0), tformedy(), tformedz(), local3\Field1\Field2, $00)
                        positionentity(me\Field60, tformedx(), entityy(me\Field60, $00), tformedz(), $01)
                        resetentity(me\Field60)
                        resetrender()
                        local23 = $01
                    ElseIf (-730.0 > tformedx()) Then
                        giveachievement("970", $01)
                        me\Field10 = -10.0
                        updateworld(1.0)
                        tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local3\Field1\Field2)
                        For local20 = $01 To $02 Step $01
                            local114 = local3\Field1\Field14[local20]
                            local115 = local3\Field1\Field14[(local20 + $02)]
                            local115\Field6 = local114\Field6
                            local115\Field8 = local114\Field8
                            entityparent(local115\Field0, local115\Field2, $01)
                            entityparent(local114\Field0, local114\Field2, $01)
                            entityparent(local115\Field1, local115\Field2, $01)
                            entityparent(local114\Field1, local114\Field2, $01)
                            positionentity(local115\Field0, entityx(local114\Field0, $00), entityy(local114\Field0, $00), entityz(local114\Field0, $00), $00)
                            positionentity(local115\Field1, entityx(local114\Field1, $00), entityy(local114\Field1, $00), entityz(local114\Field1, $00), $00)
                            entityparent(local115\Field0, $00, $01)
                            entityparent(local114\Field0, $00, $01)
                            entityparent(local115\Field1, $00, $01)
                            entityparent(local114\Field1, $00, $01)
                            local114\Field6 = $00
                            local114\Field8 = 0.0
                        Next
                        tformpoint((tformedx() + 1024.0), tformedy(), tformedz(), local3\Field1\Field2, $00)
                        positionentity(me\Field60, tformedx(), entityy(me\Field60, $00), tformedz(), $01)
                        resetentity(me\Field60)
                        resetrender()
                        local23 = $01
                    EndIf
                    If (local23 <> 0) Then
                        local3\Field2 = (local3\Field2 + 1.0)
                        For local11 = Each items
                            If (25.0 > entitydistancesquared(local11\Field2, me\Field60)) Then
                                tformpoint(entityx(local11\Field2, $00), entityy(local11\Field2, $00), entityz(local11\Field2, $00), $00, local3\Field1\Field2)
                                local31 = tformedx()
                                local32 = tformedy()
                                local33 = tformedz()
                                If (((-290.0 <= local33) And (560.0 >= local33)) <> 0) Then
                                    If (((264.0 <= local31) And (760.0 >= local31)) <> 0) Then
                                        tformpoint((local31 - 1024.0), local32, local33, local3\Field1\Field2, $00)
                                        positionentity(local11\Field2, tformedx(), tformedy(), tformedz(), $01)
                                        resetentity(local11\Field2)
                                    ElseIf (((-264.0 >= local31) And (-760.0 <= local31)) <> 0) Then
                                        tformpoint((local31 + 1024.0), local32, local33, local3\Field1\Field2, $00)
                                        positionentity(local11\Field2, tformedx(), tformedy(), tformedz(), $01)
                                        resetentity(local11\Field2)
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        Select local3\Field2
                            Case 1.0
                                If (key2_spawnrate = $05) Then
                                    tformpoint(-354.0, 220.0, 516.0, local3\Field1\Field2, $00)
                                    local11 = createitem("White Key", $68, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                                    entitytype(local11\Field2, $03, $00)
                                EndIf
                            Case 2.0
                                local20 = rand($00, (maxitemamount - $01))
                                If (inventory(local20) <> Null) Then
                                    removewearableitems(inventory(local20))
                                    removeitem(inventory(local20))
                                EndIf
                            Case 5.0
                                me\Field31 = (me\Field31 + 0.3)
                            Case 10.0
                                local5 = createdecal($03, (local3\Field1\Field3 + ((cos(((Float local3\Field1\Field6) - 90.0)) * 760.0) * (1.0 / 256.0))), (local3\Field1\Field4 + 0.005), (local3\Field1\Field5 + ((sin(((Float local3\Field1\Field6) - 90.0)) * 760.0) * (1.0 / 256.0))), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
                                entityparent(local5\Field0, local3\Field1\Field2, $01)
                            Case 14.0
                                local22 = $00
                                For local20 = $00 To (maxitemamount - $01) Step $01
                                    If (inventory(local20) <> Null) Then
                                        If (inventory(local20)\Field4\Field2 = $00) Then
                                            removeitem(inventory(local20))
                                            local22 = $01
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                                If (local22 <> 0) Then
                                    local11 = createitem(("Document SCP-" + getranddocument()), $00, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                    entitytype(local11\Field2, $03, $00)
                                    pickitem(local11, $00)
                                EndIf
                            Case 18.0
                                tformpoint(-344.0, 176.0, 272.0, local3\Field1\Field2, $00)
                                local11 = createitem("Strange Note", $00, tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                                entitytype(local11\Field2, $03, $00)
                            Case 25.0
                                local3\Field1\Field15[$00] = createnpc($13, (local3\Field1\Field3 + ((cos(((Float local3\Field1\Field6) - 90.0)) * 760.0) * (1.0 / 256.0))), 0.32, (local3\Field1\Field5 + ((sin(((Float local3\Field1\Field6) - 90.0)) * 760.0) * (1.0 / 256.0))))
                                local3\Field1\Field15[$00]\Field12 = -1.0
                                local3\Field1\Field15[$00]\Field50 = $01
                                rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) - 200.0), 0.0, $01)
                                changenpctextureid(local3\Field1\Field15[$00], $01)
                                setnpcframe(local3\Field1\Field15[$00], 80.0, $01)
                                local3\Field1\Field15[$00]\Field97 = $01
                            Case 30.0
                                local20 = rand($00, (maxitemamount - $01))
                                If (inventory(local20) <> Null) Then
                                    removewearableitems(inventory(local20))
                                    removeitem(inventory(local20))
                                EndIf
                                local11 = createitem("Strange Note", $00, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                entitytype(local11\Field2, $03, $00)
                                pickitem(local11, $00)
                            Case 33.0,34.0,35.0
                                local5 = createdecal($07, (local3\Field1\Field3 + rnd(-2.0, 2.0)), (local3\Field1\Field4 + 2.734375), (local3\Field1\Field5 + rnd(-2.0, 2.0)), 270.0, rnd(360.0, 0.0), 0.0, 0.05, 1.0, $00, $01, $00, $00, $00)
                                local5\Field4 = 0.0005
                                entityparent(local5\Field0, local3\Field1\Field2, $01)
                            Case 40.0
                                local3\Field7 = playsound_strict(loadtempsound("SFX\Radio\Franklin3.ogg"), $01)
                            Case 50.0
                                local3\Field1\Field15[$01] = createnpc($14, (local3\Field1\Field3 + ((cos(((Float local3\Field1\Field6) + 90.0)) * 600.0) * (1.0 / 256.0))), 0.35, (local3\Field1\Field5 + ((sin(((Float local3\Field1\Field6) + 90.0)) * 600.0) * (1.0 / 256.0))))
                                local3\Field1\Field15[$01]\Field10 = 7.0
                                local3\Field1\Field15[$01]\Field97 = $01
                            Case 52.0
                                removenpc(local3\Field1\Field15[$01])
                            Case 60.0
                                If (n_i\Field10 = $00) Then
                                    local28 = loadtexture_strict("GFX\NPCs\scp_173_H.png", $01, $00, $01)
                                    entitytexture(n_i\Field2\Field0, local28, $00, $00)
                                    entitytexture(n_i\Field2\Field1, local28, $00, $00)
                                    deletesingletextureentryfromcache(local28, $00)
                                    local28 = $00
                                EndIf
                        End Select
                        If (rand($0A, $01) = $01) Then
                            local20 = rand($00, $02)
                            playsound_strict(ambientsfx(local20, rand($00, (ambientsfxamount[local20] - $01))), $00)
                        EndIf
                    Else
                        If (local3\Field1\Field15[$00] <> Null) Then
                            If (9.0 > entitydistancesquared(me\Field60, local3\Field1\Field15[$00]\Field3)) Then
                                If (entityinview(local3\Field1\Field15[$00]\Field0, camera) <> 0) Then
                                    me\Field52 = ((sin(((Float millisec) / 20.0)) + 1.0) * 15.0)
                                    me\Field30 = max(curvevalue(0.3, me\Field30, 2.0), me\Field30)
                                    me\Field28 = max(me\Field28, 120.0)
                                EndIf
                            EndIf
                        EndIf
                        If (local3\Field1\Field15[$01] <> Null) Then
                            pointentity(local3\Field1\Field15[$01]\Field0, me\Field60, 0.0)
                            rotateentity(local3\Field1\Field15[$01]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$01]\Field0, $00), entityyaw(local3\Field1\Field15[$01]\Field3, $00), 35.0), 0.0, $00)
                        EndIf
                    EndIf
                Else
                    If (entityhidden(local3\Field1\Field11[$00]) = $00) Then
                        hideentity(local3\Field1\Field11[$00])
                    EndIf
                    If (entityhidden(local3\Field1\Field11[$01]) = $00) Then
                        hideentity(local3\Field1\Field11[$01])
                    EndIf
                    If (entityhidden(local3\Field1\Field11[$02]) = $00) Then
                        hideentity(local3\Field1\Field11[$02])
                    EndIf
                EndIf
                If (25.0 < local3\Field2) Then
                    If (8.0 > local3\Field1\Field8) Then
                        If (local3\Field8 = $00) Then
                            local3\Field8 = loadsound_strict("SFX\SCP\970\Corpse.ogg")
                        EndIf
                        local3\Field6 = loopsoundex(local3\Field8, local3\Field6, camera, local3\Field1\Field15[$00]\Field0, 10.0, 1.0, $00)
                        If (60.0 < local3\Field2) Then
                            animatenpc(local3\Field1\Field15[$00], 80.0, 61.0, -0.02, $00)
                            local3\Field1\Field15[$00]\Field7 = 0.0
                            local32 = curvevalue(((sin(((Float millisec) / 20.0)) * 0.1) + 1.5), entityy(local3\Field1\Field15[$00]\Field3, $00), 50.0)
                            positionentity(local3\Field1\Field15[$00]\Field3, entityx(local3\Field1\Field15[$00]\Field3, $00), local32, entityz(local3\Field1\Field15[$00]\Field3, $00), $00)
                            turnentity(local3\Field1\Field15[$00]\Field3, 0.0, (fps\Field7[$00] * 0.1), 0.0, $00)
                        EndIf
                    EndIf
                EndIf
            Case $43
                If (event_isplayerinroom(local3) <> 0) Then
                    If (6.25 > entitydistancesquared(local3\Field1\Field2, me\Field60)) Then
                        For local16 = Each doors
                            If (4.0 > distancesquared(entityx(local16\Field2, $01), entityx(me\Field60, $00), entityz(local16\Field2, $01), entityz(me\Field60, $00), 0.0, 0.0)) Then
                                If (entityinview(local16\Field2, camera) = $00) Then
                                    If (local16\Field6 <> 0) Then
                                        local16\Field6 = $00
                                        local16\Field8 = 0.0
                                        me\Field49 = 100.0
                                        me\Field24 = 3.0
                                    EndIf
                                EndIf
                                Exit
                            EndIf
                        Next
                        removeevent(local3)
                    EndIf
                EndIf
            Case $3B
                If (event_isplayerinroom(local3) <> 0) Then
                    If (local3\Field1\Field11[$03] = $00) Then
                        tformpoint(928.0, -640.0, 704.0, local3\Field1\Field2, $00)
                        local3\Field1\Field11[$03] = copyentity(n_i\Field0[$1C], $00)
                        scaleentity(local3\Field1\Field11[$03], 0.07, 0.07, 0.07, $00)
                        positionentity(local3\Field1\Field11[$03], tformedx(), tformedy(), tformedz(), $00)
                        local28 = loadtexture_strict("GFX\NPCs\duck(2).png", $01, $00, $01)
                        entitytexture(local3\Field1\Field11[$03], local28, $00, $00)
                        deletesingletextureentryfromcache(local28, $00)
                        local28 = $00
                        entityparent(local3\Field1\Field11[$03], local3\Field1\Field2, $01)
                    Else
                        If ((((-12.0 < me\Field10) And (-8.0 > me\Field10)) Lor wi\Field7) <> 0) Then
                            pointentity(local3\Field1\Field11[$03], me\Field60, 0.0)
                            rotateentity(local3\Field1\Field11[$03], 0.0, entityyaw(local3\Field1\Field11[$03], $01), 0.0, $01)
                        EndIf
                        If (0.0 = local3\Field3) Then
                            local3\Field2 = curvevalue(0.0, local3\Field2, 15.0)
                            If (rand($320, $01) = $01) Then
                                local3\Field3 = 1.0
                            EndIf
                        Else
                            local3\Field2 = (local3\Field2 + (fps\Field7[$00] * 0.5))
                            If (360.0 < local3\Field2) Then
                                local3\Field2 = 0.0
                            EndIf
                            If (rand($4B0, $01) = $01) Then
                                local3\Field3 = 0.0
                            EndIf
                        EndIf
                        positionentity(local3\Field1\Field11[$03], entityx(local3\Field1\Field11[$03], $01), ((sin((local3\Field2 + 270.0)) * 0.05) + -2.325), entityz(local3\Field1\Field11[$03], $01), $01)
                    EndIf
                EndIf
            Case $12
                If (event_isplayerinroom(local3) <> 0) Then
                    local3\Field25 = mp_updateelevators(local3\Field25, local3\Field1\Field14[$00], local3\Field1\Field14[$01], local3\Field1\Field11[$00], local3\Field1\Field11[$01], local3, $01, $00, $00)
                    local3\Field26 = mp_updateelevators(local3\Field26, local3\Field1\Field14[$02], local3\Field1\Field14[$03], local3\Field1\Field11[$02], local3\Field1\Field11[$03], local3, $01, $00, $00)
                    If (local3\Field1\Field15[$00] = Null) Then
                        For local20 = $00 To $03 Step $01
                            local3\Field1\Field15[local20] = createnpc($0B, 0.0, 0.0, 0.0)
                        Next
                        tformpoint(3372.0, -5580.8, 6294.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$04] = createnpc($13, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$04]\Field12 = -1.0
                        local3\Field1\Field15[$04]\Field50 = $01
                        changenpctextureid(local3\Field1\Field15[$04], $0E)
                        setnpcframe(local3\Field1\Field15[$04], 40.0, $01)
                        rotateentity(local3\Field1\Field15[$04]\Field3, 0.0, ((Float local3\Field1\Field6) + 90.0), 0.0, $01)
                        tformpoint(1083.0, -5580.8, 989.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$05] = createnpc($13, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$05]\Field12 = -1.0
                        local3\Field1\Field15[$05]\Field50 = $01
                        changenpctextureid(local3\Field1\Field15[$05], $0F)
                        setnpcframe(local3\Field1\Field15[$05], 19.0, $01)
                        rotateentity(local3\Field1\Field15[$05]\Field3, 0.0, (Float local3\Field1\Field6), 0.0, $01)
                    EndIf
                    If (0.0 >= local3\Field20) Then
                        If (0.0 = local3\Field2) Then
                            If (-17.96875 > mp_findlowestplayery(local3\Field1)) Then
                                positionentity(local3\Field1\Field15[$00]\Field3, entityx(local3\Field1\Field11[$04], $01), (entityy(local3\Field1\Field11[$04], $01) + 0.2), entityz(local3\Field1\Field11[$04], $01), $00)
                                resetentity(local3\Field1\Field15[$00]\Field3)
                                local3\Field1\Field15[$00]\Field10 = 2.0
                                local3\Field1\Field15[$00]\Field11 = 5.0
                                local3\Field1\Field15[$00]\Field13 = $07
                                positionentity(local3\Field1\Field15[$01]\Field3, entityx(local3\Field1\Field11[$08], $01), (entityy(local3\Field1\Field11[$08], $01) + 0.2), entityz(local3\Field1\Field11[$08], $01), $00)
                                resetentity(local3\Field1\Field15[$01]\Field3)
                                local3\Field1\Field15[$01]\Field10 = 2.0
                                local3\Field1\Field15[$01]\Field11 = 9.0
                                local3\Field1\Field15[$01]\Field13 = $0B
                                positionentity(local3\Field1\Field15[$02]\Field3, entityx(local3\Field1\Field11[$0C], $01), (entityy(local3\Field1\Field11[$0C], $01) + 0.2), entityz(local3\Field1\Field11[$0C], $01), $00)
                                resetentity(local3\Field1\Field15[$02]\Field3)
                                local3\Field1\Field15[$02]\Field10 = 2.0
                                local3\Field1\Field15[$02]\Field11 = 13.0
                                local3\Field1\Field15[$02]\Field13 = $0F
                                positionentity(local3\Field1\Field15[$03]\Field3, entityx(local3\Field1\Field11[$06], $01), (entityy(local3\Field1\Field11[$06], $01) + 0.2), entityz(local3\Field1\Field11[$06], $01), $00)
                                resetentity(local3\Field1\Field15[$03]\Field3)
                                local3\Field1\Field15[$03]\Field10 = 2.0
                                local3\Field1\Field15[$03]\Field11 = 7.0
                                local3\Field1\Field15[$03]\Field13 = $07
                                local3\Field2 = 1.0
                            EndIf
                        ElseIf (-17.96875 <= mp_findlowestplayery(local3\Field1)) Then
                            local3\Field2 = 0.0
                        EndIf
                        local3\Field20 = 70.0
                    EndIf
                    local3\Field20 = (local3\Field20 - fps\Field7[$00])
                    event_resetprev()
                    If ((event_ismeinroom(local3) And (-17.96875 > entityy(me\Field60, $00))) <> 0) Then
                        me\Field59 = $00
                        If (((wi\Field0 = $00) And (wi\Field2 = $00)) <> 0) Then
                            me\Field49 = min((me\Field49 + (fps\Field7[$00] * 1.05)), 1500.0)
                            If (500.0 <= me\Field49) Then
                                updatecough($3E8)
                            EndIf
                            If ((((1500.0 <= me\Field49) And (0.0 = me\Field3)) And (0.0 = me\Field0)) <> 0) Then
                                msg\Field2 = format(getlocalstring("death", "939.gas"), subjectname, "%s")
                                kill($00, $01, $00, $01)
                            EndIf
                        EndIf
                        shouldplay = $07
                        If (local3\Field1\Field14[$04]\Field6 = $00) Then
                            For local20 = $00 To $01 Step $01
                                If (updatelever(local3\Field1\Field13[local20]\Field0, $00, $50, -80.0) <> 0) Then
                                    local3\Field1\Field14[$04]\Field6 = $01
                                    mp_loadeventsound(local3, "SFX\Door\Door2OpenDistanced.ogg", $01)
                                    local3\Field7 = playsoundex(local3\Field9, camera, local3\Field1\Field14[$04]\Field0, 400.0, 1.0, $00, $00)
                                    Exit
                                EndIf
                            Next
                        Else
                            For local20 = $00 To $01 Step $01
                                updatelever(local3\Field1\Field13[local20]\Field0, $01, $50, -80.0)
                                If (0.0 <= entitypitch(local3\Field1\Field13[local20]\Field0, $01)) Then
                                    rotateentity(local3\Field1\Field13[local20]\Field0, -80.0, entityyaw(local3\Field1\Field13[local20]\Field0, $00), 0.0, $00)
                                EndIf
                            Next
                        EndIf
                        updatesoundorigin(local3\Field7, camera, local3\Field1\Field14[$04]\Field0, 400.0, 1.0, $00, $01)
                        playerfallingpickdistance = 0.0
                        If (-25.0 > entityy(me\Field60, $00)) Then
                            If ((((chs\Field0 = $00) And (0.0 = me\Field0)) And (0.0 <= me\Field3)) <> 0) Then
                                msg\Field2 = format(getlocalstring("death", "939.shaft"), subjectname, "%s")
                                playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"), $00)
                                me\Field49 = 3000.0
                                kill($00, $01, $00, $01)
                            EndIf
                        EndIf
                    EndIf
                Else
                    local3\Field2 = 0.0
                EndIf
            Case $28
                If (8.0 > local3\Field18) Then
                    tformpoint(-190.0, 60.0, 190.0, local3\Field1\Field2, $00)
                    local1 = createnpc($14, tformedx(), tformedy(), tformedz())
                    local1\Field10 = 8.0
                    local1\Field50 = $01
                    setnpcframe(local1, 288.0, $01)
                    rotateentity(local1\Field3, 0.0, ((Float local3\Field1\Field6) + rnd(160.0, 180.0)), 0.0, $01)
                    removeevent(local3)
                EndIf
            Case $15
                If (event_isplayerinroom(local3) <> 0) Then
                    If (local3\Field1\Field15[$00] = Null) Then
                        local3\Field1\Field15[$00] = createnpc($13, entityx(local3\Field1\Field11[$01], $01), 0.5, entityz(local3\Field1\Field11[$01], $01))
                        local3\Field1\Field15[$00]\Field10 = 6.0
                        createnpcasset(local3\Field1\Field15[$00])
                        changenpctextureid(local3\Field1\Field15[$00], $0C)
                        setnpcframe(local3\Field1\Field15[$00], 501.0, $01)
                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 270.0), 0.0, $01)
                        local3\Field2 = 1.0
                    ElseIf (0.0 < local3\Field2) Then
                        shouldplay = $1A
                        If (channelplaying(local3\Field1\Field15[$00]\Field18) <> 0) Then
                            local3\Field1\Field15[$00]\Field18 = loopsoundex(local3\Field1\Field15[$00]\Field17, local3\Field1\Field15[$00]\Field18, camera, local3\Field1\Field2, 6.0, 1.0, $00)
                        EndIf
                        If (1.0 = local3\Field2) Then
                            If (1.44 > entitydistancesquared(me\Field60, local3\Field1\Field11[$00])) Then
                                If (entityinview(local3\Field1\Field15[$00]\Field0, event_getsomebodycamera(local3)) <> 0) Then
                                    giveachievement("035", $01)
                                    playsound_strict(loadtempsound("SFX\SCP\035\GetUp.ogg"), $00)
                                    local3\Field2 = 1.5
                                EndIf
                            EndIf
                        Else
                            If (local3\Field1\Field14[$03]\Field6 <> 0) Then
                                local3\Field3 = max(local3\Field3, 1.0)
                            EndIf
                            If (updatelever(local3\Field1\Field13[$00]\Field0, (20.0 = local3\Field3), $50, -80.0) = $00) Then
                                local23 = updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0)
                                If ((local23 Lor ((1750.0 < local3\Field4) And (3500.0 > local3\Field4))) <> 0) Then
                                    If (local23 <> 0) Then
                                        For local20 = $00 To $01 Step $01
                                            If (local3\Field1\Field17[local20] = Null) Then
                                                tformpoint(-269.0, 400.0, (((Float local20) * 489.0) + 135.0), local3\Field1\Field2, $00)
                                                local3\Field1\Field17[local20] = setemitter(local3\Field1, tformedx(), tformedy(), tformedz(), $00)
                                                local3\Field1\Field17[local20]\Field11 = $01
                                            EndIf
                                        Next
                                    Else
                                        For local20 = $00 To $01 Step $01
                                            If (local3\Field1\Field17[local20] <> Null) Then
                                                freeemitter(local3\Field1\Field17[local20], $00)
                                            EndIf
                                        Next
                                    EndIf
                                    If (-2100.0 < local3\Field4) Then
                                        local3\Field4 = ((Abs local3\Field4) + fps\Field7[$00])
                                        If (((1.0 < local3\Field4) And (1.0 >= (local3\Field4 - fps\Field7[$00]))) <> 0) Then
                                            local3\Field1\Field15[$00]\Field10 = 0.0
                                            mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Gased0.ogg", $00)
                                            local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                        ElseIf (((1050.0 < local3\Field4) And (1750.0 > local3\Field4)) <> 0) Then
                                            If (1050.0 >= (local3\Field4 - fps\Field7[$00])) Then
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Gased1.ogg", $00)
                                                local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                                setnpcframe(local3\Field1\Field15[$00], 553.0, $01)
                                            EndIf
                                            local3\Field1\Field15[$00]\Field10 = 6.0
                                            animatenpc(local3\Field1\Field15[$00], 553.0, 529.0, -0.12, $00)
                                        ElseIf (((1750.0 < local3\Field4) And (2450.0 > local3\Field4)) <> 0) Then
                                            local3\Field1\Field15[$00]\Field10 = 6.0
                                            animatenpc(local3\Field1\Field15[$00], 529.0, 524.0, -0.08, $00)
                                        ElseIf (2450.0 < local3\Field4) Then
                                            pointentity(local3\Field1\Field15[$00]\Field0, me\Field60, 0.0)
                                            rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 15.0), 0.0, $00)
                                            If (6.0 = local3\Field1\Field15[$00]\Field10) Then
                                                me\Field5 = ((sin((animtime(local3\Field1\Field15[$00]\Field0) - 524.0)) * -150.0) * 9.0)
                                                animatenpc(local3\Field1\Field15[$00], 524.0, 553.0, 0.08, $00)
                                                If (552.9 < local3\Field1\Field15[$00]\Field14) Then
                                                    local3\Field1\Field15[$00]\Field10 = 0.0
                                                EndIf
                                            EndIf
                                            If (2450.0 >= (local3\Field4 - fps\Field7[$00])) Then
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\GasedKilled0.ogg", $00)
                                                local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                                playsound_strict(loadtempsound("SFX\SCP\035\KilledGetUp.ogg"), $00)
                                                i_035\Field0 = $01
                                                update035label(local3\Field1\Field11[$04])
                                                createnpcasset(local3\Field1\Field15[$00])
                                                local3\Field2 = 4200.0
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    If (6.0 = local3\Field1\Field15[$00]\Field10) Then
                                        If (((501.0 <= local3\Field1\Field15[$00]\Field14) And (523.0 >= local3\Field1\Field15[$00]\Field14)) <> 0) Then
                                            animatenpc(local3\Field1\Field15[$00], 501.0, 523.0, 0.08, $00)
                                            If (522.9 < local3\Field1\Field15[$00]\Field14) Then
                                                local3\Field1\Field15[$00]\Field10 = 0.0
                                            EndIf
                                        ElseIf (((524.0 <= local3\Field1\Field15[$00]\Field14) And (553.0 >= local3\Field1\Field15[$00]\Field14)) <> 0) Then
                                            animatenpc(local3\Field1\Field15[$00], 524.0, 553.0, 0.08, $00)
                                            If (552.9 < local3\Field1\Field15[$00]\Field14) Then
                                                local3\Field1\Field15[$00]\Field10 = 0.0
                                            EndIf
                                        EndIf
                                    EndIf
                                    For local20 = $00 To $01 Step $01
                                        If (local3\Field1\Field17[local20] <> Null) Then
                                            freeemitter(local3\Field1\Field17[local20], $00)
                                        EndIf
                                    Next
                                    If (0.0 = local3\Field1\Field15[$00]\Field10) Then
                                        pointentity(local3\Field1\Field15[$00]\Field0, me\Field60, 0.0)
                                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 15.0), 0.0, $00)
                                        If (rand($1F4, $01) = $01) Then
                                            local3\Field1\Field15[$00]\Field11 = (Float (4.0 < entitydistancesquared(local3\Field1\Field15[$00]\Field3, local3\Field1\Field11[$01])))
                                            local3\Field1\Field15[$00]\Field10 = 1.0
                                        EndIf
                                    ElseIf (1.0 = local3\Field1\Field15[$00]\Field10) Then
                                        If (1.0 = local3\Field1\Field15[$00]\Field11) Then
                                            pointentity(local3\Field1\Field15[$00]\Field0, local3\Field1\Field11[$01], 0.0)
                                            If (0.09 > entitydistancesquared(local3\Field1\Field15[$00]\Field3, local3\Field1\Field11[$01])) Then
                                                local3\Field1\Field15[$00]\Field10 = 0.0
                                            EndIf
                                        Else
                                            rotateentity(local3\Field1\Field15[$00]\Field0, 0.0, ((Float local3\Field1\Field6) - 180.0), 0.0, $01)
                                            If (4.0 < entitydistancesquared(local3\Field1\Field15[$00]\Field3, local3\Field1\Field11[$01])) Then
                                                local3\Field1\Field15[$00]\Field10 = 0.0
                                            EndIf
                                        EndIf
                                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 15.0), 0.0, $00)
                                    EndIf
                                    If (0.0 < local3\Field4) Then
                                        local3\Field4 = (- local3\Field4)
                                        If (-2450.0 > local3\Field4) Then
                                            mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\GasedKilled1.ogg", $00)
                                            local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            local3\Field2 = 4200.0
                                        Else
                                            If (-1400.0 > local3\Field4) Then
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\GasedStop1.ogg", $00)
                                            Else
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\GasedStop0.ogg", $00)
                                                local3\Field4 = -1470.0
                                            EndIf
                                            local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            local3\Field2 = 4270.0
                                        EndIf
                                    Else
                                        local3\Field2 = (local3\Field2 + fps\Field7[$00])
                                        If (((280.0 < local3\Field2) And (280.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                            mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Help0.ogg", $00)
                                            local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            local3\Field2 = 700.0
                                        ElseIf (((1400.0 < local3\Field2) And (1400.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                            mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Help1.ogg", $00)
                                            local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                        ElseIf (((2800.0 < local3\Field2) And (2800.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                            mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Idle0.ogg", $00)
                                            local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                        ElseIf (((3500.0 < local3\Field2) And (3500.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                            mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Idle1.ogg", $00)
                                            local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                        ElseIf (((5600.0 < local3\Field2) And (5600.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                            If ((Int local3\Field3) <> 0) Then
                                                local3\Field2 = 9100.0
                                            ElseIf (-2100.0 > local3\Field4) Then
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\GasedCloset.ogg", $00)
                                                local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            ElseIf (0.0 = local3\Field4) Then
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Closet0.ogg", $00)
                                                local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            Else
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\GasedCloset.ogg", $00)
                                                local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            EndIf
                                        ElseIf (5600.0 < local3\Field2) Then
                                            If ((Int local3\Field3) <> 0) Then
                                                local3\Field2 = max(local3\Field2, 7000.0)
                                            EndIf
                                            If (((7700.0 < local3\Field2) And (7700.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                                If ((Int local3\Field3) <> 0) Then
                                                    mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Closet1.ogg", $00)
                                                    local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                                    local3\Field2 = 9100.0
                                                Else
                                                    mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Idle2.ogg", $00)
                                                    local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                                EndIf
                                            ElseIf (((8750.0 < local3\Field2) And (8750.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                                If ((Int local3\Field3) <> 0) Then
                                                    mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Closet0.ogg", $00)
                                                    local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                                Else
                                                    mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Idle3.ogg", $00)
                                                    local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                                EndIf
                                            ElseIf (((10500.0 < local3\Field2) And (10500.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Idle4.ogg", $00)
                                                local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            ElseIf (((14000.0 < local3\Field2) And (14000.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Idle5.ogg", $00)
                                                local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            ElseIf (((17500.0 < local3\Field2) And (17500.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                                                mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Idle6.ogg", $00)
                                                local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Else
                                If (10.0 > local3\Field3) Then
                                    local3\Field1\Field14[$02]\Field6 = $00
                                    local3\Field1\Field14[$02]\Field4 = $01
                                    For local20 = $00 To $01 Step $01
                                        If (local3\Field1\Field14[local20]\Field6 = $00) Then
                                            openclosedoor(local3\Field1\Field14[local20], $01, $00)
                                        EndIf
                                    Next
                                    If (0.0 = local3\Field4) Then
                                        mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\Escape.ogg", $00)
                                        local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                    ElseIf (2450.0 < (Abs local3\Field4)) Then
                                        mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\KilledEscape.ogg", $00)
                                        local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                    Else
                                        mp_loadnpcsound(local3\Field1\Field15[$00], "SFX\SCP\035\GasedEscape.ogg", $00)
                                        local3\Field1\Field15[$00]\Field18 = playsound_strict(local3\Field1\Field15[$00]\Field17, $01)
                                    EndIf
                                    local3\Field3 = 20.0
                                EndIf
                                If (20.0 = local3\Field3) Then
                                    local38 = distancesquared(entityx(local3\Field1\Field14[$00]\Field2, $01), entityx(local3\Field1\Field15[$00]\Field3, $01), entityz(local3\Field1\Field14[$00]\Field2, $01), entityz(local3\Field1\Field15[$00]\Field3, $01), 0.0, 0.0)
                                    local3\Field1\Field15[$00]\Field10 = 1.0
                                    If (6.25 < local38) Then
                                        pointentity(local3\Field1\Field15[$00]\Field0, local3\Field1\Field14[$01]\Field2, 0.0)
                                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 15.0), 0.0, $00)
                                    ElseIf (0.49 < local38) Then
                                        If (channelplaying(local3\Field1\Field15[$00]\Field18) <> 0) Then
                                            local3\Field1\Field15[$00]\Field10 = 0.0
                                            pointentity(local3\Field1\Field15[$00]\Field0, me\Field60, 0.0)
                                            rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 15.0), 0.0, $00)
                                        Else
                                            pointentity(local3\Field1\Field15[$00]\Field0, local3\Field1\Field14[$00]\Field2, 0.0)
                                            rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, curveangle(entityyaw(local3\Field1\Field15[$00]\Field0, $00), entityyaw(local3\Field1\Field15[$00]\Field3, $00), 15.0), 0.0, $00)
                                        EndIf
                                    Else
                                        local3\Field1\Field15[$00]\Field50 = $01
                                        translateentity(local3\Field1\Field15[$00]\Field3, -10000.0, 0.0, 0.0, $00)
                                        For local20 = $00 To $02 Step $01
                                            local3\Field1\Field14[local20]\Field4 = $00
                                        Next
                                        openclosedoor(local3\Field1\Field14[$01], $01, $00)
                                        For local16 = Each doors
                                            If (local16\Field10 = $02) Then
                                                If (20.25 > distancesquared(entityx(local3\Field1\Field2, $00), entityx(local16\Field2, $01), entityz(local3\Field1\Field2, $00), entityz(local16\Field2, $01), 0.0, 0.0)) Then
                                                    openclosedoor(local16, $01, $00)
                                                    Exit
                                                EndIf
                                            EndIf
                                        Next
                                        local3\Field3 = 0.0
                                        local3\Field4 = 0.0
                                        local3\Field2 = -1.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Else
                        If (updatelever(local3\Field1\Field13[$01]\Field0, $00, $50, -80.0) <> 0) Then
                            For local20 = $00 To $01 Step $01
                                If (local3\Field1\Field17[local20] = Null) Then
                                    tformpoint(-269.0, 400.0, (((Float local20) * 489.0) + 135.0), local3\Field1\Field2, $00)
                                    local3\Field1\Field17[local20] = setemitter(local3\Field1, tformedx(), tformedy(), tformedz(), $00)
                                    local3\Field1\Field17[local20]\Field11 = $01
                                EndIf
                            Next
                        Else
                            For local20 = $00 To $01 Step $01
                                If (local3\Field1\Field17[local20] <> Null) Then
                                    freeemitter(local3\Field1\Field17[local20], $00)
                                EndIf
                            Next
                        EndIf
                        shouldplay = $01
                        local23 = $00
                        If (entityx(me\Field60, $00) > min(entityx(local3\Field1\Field11[$02], $01), entityx(local3\Field1\Field11[$03], $01))) Then
                            If (entityx(me\Field60, $00) < max(entityx(local3\Field1\Field11[$02], $01), entityx(local3\Field1\Field11[$03], $01))) Then
                                If (entityz(me\Field60, $00) > min(entityz(local3\Field1\Field11[$02], $01), entityz(local3\Field1\Field11[$03], $01))) Then
                                    If (entityz(me\Field60, $00) < max(entityz(local3\Field1\Field11[$02], $01), entityz(local3\Field1\Field11[$03], $01))) Then
                                        If (local3\Field1\Field15[$00] = Null) Then
                                            local3\Field1\Field15[$00] = createnpc($01, 0.0, 0.0, 0.0)
                                        EndIf
                                        positionentity(local3\Field1\Field15[$00]\Field3, entityx(local3\Field1\Field11[$01], $01), 0.13, entityz(local3\Field1\Field11[$01], $01), $00)
                                        If (0.0 < local3\Field1\Field15[$00]\Field10) Then
                                            If (local3\Field1\Field15[$01] = Null) Then
                                                local3\Field1\Field15[$01] = createnpc($01, 0.0, 0.0, 0.0)
                                            EndIf
                                        EndIf
                                        me\Field17 = curvevalue(min(60.0, me\Field17), me\Field17, 20.0)
                                        local23 = $01
                                        mp_loadeventsound(local3, "SFX\Room\035Chamber\Whispers0.ogg", $00)
                                        mp_loadeventsound(local3, "SFX\Room\035Chamber\Whispers1.ogg", $01)
                                        local3\Field3 = min((local3\Field3 + (fps\Field7[$00] / 6000.0)), 1.0)
                                        local3\Field4 = curvevalue(local3\Field3, local3\Field4, 50.0)
                                        If ((((i_714\Field0 <> $02) And (wi\Field2 <> $04)) And (wi\Field0 <> $04)) <> 0) Then
                                            me\Field5 = (me\Field5 - (fps\Field7[$00] * 1.1))
                                            me\Field49 = (sin(((Float millisec) / 10.0)) * (Abs me\Field5))
                                        EndIf
                                        me\Field31 = ((fps\Field7[$00] / (((Float (wi\Field2 > $00)) + 1.0) * 5000.0)) + me\Field31)
                                        If (((Int me\Field0) And (100.0 <= me\Field32)) <> 0) Then
                                            msg\Field2 = format(getlocalstring("death", "035"), subjectname, "%s")
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (local3\Field1\Field15[$01] <> Null) Then
                            positionentity(local3\Field1\Field15[$01]\Field3, entityx(local3\Field1\Field2, $01), 0.13, entityz(local3\Field1\Field2, $01), $00)
                            local37 = wrapangle((entityyaw(local3\Field1\Field15[$01]\Field3, $00) - (Float local3\Field1\Field6)), 360.0)
                            If (90.0 < local37) Then
                                If (225.0 > local37) Then
                                    rotateentity(local3\Field1\Field15[$01]\Field3, 0.0, ((Float local3\Field1\Field6) - 269.0), 0.0, $00)
                                Else
                                    rotateentity(local3\Field1\Field15[$01]\Field3, 0.0, ((Float local3\Field1\Field6) - 1.0), 0.0, $00)
                                EndIf
                            EndIf
                        EndIf
                        If (local23 = $00) Then
                            local3\Field3 = max((local3\Field3 - (fps\Field7[$00] / 2000.0)), 0.0)
                            local3\Field4 = max((local3\Field4 - (fps\Field7[$00] / 100.0)), 0.0)
                        EndIf
                        If (((((0.0 < local3\Field4) And (i_714\Field0 <> $02)) And (wi\Field2 <> $04)) And (wi\Field0 <> $04)) <> 0) Then
                            local3\Field6 = loopsoundex(local3\Field8, local3\Field6, camera, local3\Field1\Field2, 10.0, local3\Field4, $00)
                            local3\Field7 = loopsoundex(local3\Field9, local3\Field7, camera, local3\Field1\Field2, 10.0, ((local3\Field4 - 0.5) * 2.0), $00)
                        EndIf
                    EndIf
                    If (local3\Field1\Field15[$00] <> Null) Then
                        updatesoundorigin(local3\Field1\Field15[$00]\Field18, camera, local3\Field1\Field2, 6.0, 0.8, $01, $01)
                    EndIf
                ElseIf (0.0 = local3\Field2) Then
                    If (((local3\Field8 = $00) And (infacility = $00)) <> 0) Then
                        If (event_prevplayerroom <> Null) Then
                            For local20 = $00 To $03 Step $01
                                If (isroomadjacent(event_prevplayerroom\Field19[local20], local3\Field1) <> 0) Then
                                    mp_loadeventsound(local3, "SFX\Room\035Chamber\InProximity.ogg", $00)
                                    playsound_strict(local3\Field8, $01)
                                EndIf
                            Next
                        EndIf
                    EndIf
                ElseIf (0.0 > local3\Field2) Then
                    For local20 = $00 To $01 Step $01
                        removenpc(local3\Field1\Field15[local20])
                    Next
                ElseIf (local3\Field1\Field15[$00] <> Null) Then
                    updatesoundorigin(local3\Field1\Field15[$00]\Field18, camera, local3\Field1\Field2, 6.0, 0.8, $01, $01)
                EndIf
            Case $22
                If (0.0 = local3\Field2) Then
                    If (event_isplayerinroom(local3) <> 0) Then
                        tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local3\Field1\Field2)
                        If (0.0 = tformedz()) Then
                            local23 = $FFFFFFFF
                        Else
                            local23 = (Int (- (Sgn tformedz())))
                        EndIf
                        tformpoint(-720.0, 25.0, (816.0 * (Float local23)), local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($0E, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$00]\Field10 = 1.0
                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) - 90.0), 0.0, $00)
                        local3\Field2 = 1.0
                    EndIf
                ElseIf (1.0 = local3\Field2) Then
                    local3\Field3 = (local3\Field3 + fps\Field7[$00])
                    If (((735.0 < local3\Field3) Lor local3\Field1\Field14[$00]\Field6) <> 0) Then
                        removenpc(local3\Field1\Field15[$00])
                        local3\Field2 = 2.0
                    EndIf
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    If (2.0 = local3\Field2) Then
                        If (((6.25 > entitydistancesquared(me\Field60, local3\Field1\Field11[$06])) And (0.0 < local3\Field2)) <> 0) Then
                            If (event_ismeinroom(local3) <> 0) Then
                                playsound_strict(loadtempsound("SFX\SCP\079\TestroomWarning.ogg"), $01)
                            EndIf
                            For local20 = $00 To $05 Step $01
                                local18 = setemitter(local3\Field1, entityx(local3\Field1\Field11[local20], $01), entityy(local3\Field1\Field11[local20], $01), entityz(local3\Field1\Field11[local20], $01), $04)
                                local18\Field11 = $01
                            Next
                            removeevent(local3)
                        EndIf
                    EndIf
                EndIf
            Case $1C
                If (event_isplayerinroom(local3) <> 0) Then
                    playsoundex(snd_i\Field25, camera, local3\Field1\Field2, 10.0, 1.0, $00, $00)
                    tformpoint(0.0, 460.0, 512.0, local3\Field1\Field2, $00)
                    local18 = setemitter(local3\Field1, tformedx(), tformedy(), tformedz(), $00)
                    local18\Field11 = $01
                    tformpoint(0.0, 460.0, -512.0, local3\Field1\Field2, $00)
                    local18 = setemitter(local3\Field1, tformedx(), tformedy(), tformedz(), $00)
                    local18\Field11 = $01
                    removeevent(local3)
                EndIf
            Case $1D
                If (event_isplayerinroom(local3) <> 0) Then
                    If (1.0 < n_i\Field2\Field26) Then
                        removeevent(local3)
                    ElseIf (0.0 = local3\Field2) Then
                        playsound_strict(snd_i\Field34, $00)
                        me\Field50 = 5.0
                        local3\Field2 = 1.0
                    EndIf
                EndIf
                If (((0.0 < local3\Field2) And (200.0 > local3\Field2)) <> 0) Then
                    If (((30.0 < local3\Field2) And (30.0 >= (local3\Field2 - fps\Field7[$00]))) <> 0) Then
                        playsound_strict(loadtempsound("SFX\Ambient\General\Ambient2.ogg"), $00)
                    EndIf
                    If (((100.0 >= (local3\Field2 - fps\Field7[$00])) And (100.0 < local3\Field2)) <> 0) Then
                        playsound_strict(loadtempsound("SFX\Ambient\General\Ambient5.ogg"), $00)
                        positionentity(n_i\Field2\Field3, entityx(local3\Field1\Field2, $00), 0.6, entityz(local3\Field1\Field2, $00), $00)
                        resetentity(n_i\Field2\Field3)
                        n_i\Field2\Field26 = 1.0
                        If (wi\Field5 > $00) Then
                            me\Field10 = -10.0
                        EndIf
                    EndIf
                    local3\Field2 = (local3\Field2 + fps\Field7[$00])
                ElseIf (((0.0 < local3\Field2) And (0.25 > me\Field50)) <> 0) Then
                    n_i\Field2\Field26 = 0.0
                    removeevent(local3)
                EndIf
            Case $1B
                If (((n_i\Field3\Field65 = $00) And mp_ishoster()) <> 0) Then
                    If (0.0 = local3\Field2) Then
                        If ((chs\Field2 Lor i_268\Field2) = $00) Then
                            If (((3.0 > local3\Field1\Field8) And (0.0 < local3\Field1\Field8)) <> 0) Then
                                If (2.0 > n_i\Field3\Field10) Then
                                    local3\Field2 = 1.0
                                ElseIf ((((3.0 = n_i\Field3\Field10) And (25.0 < entitydistancesquared(n_i\Field3\Field3, me\Field60))) And (entityinview(n_i\Field3\Field0, camera) = $00)) <> 0) Then
                                    local3\Field3 = 1.0
                                    local3\Field2 = 1.0
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (1.0 = local3\Field2) Then
                        local5 = createdecal($00, entityx(local3\Field1\Field2, $00), (local3\Field1\Field4 + 1.738281), entityz(local3\Field1\Field2, $00), -90.0, rnd(360.0, 0.0), 0.0, rnd(0.5, 0.7), rnd(0.7, 0.85), $00, $01, $00, $00, $00)
                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                        playsound_strict(snd_i\Field47[$0A], $00)
                        local3\Field2 = 2.0
                    Else
                        If (1.0 = local3\Field3) Then
                            shouldplay = $0A
                        EndIf
                        local3\Field2 = (local3\Field2 + fps\Field7[$00])
                        If (180.0 >= local3\Field2) Then
                            n_i\Field3\Field26 = 1.0
                            n_i\Field3\Field7 = 0.0
                            positionentity(n_i\Field3\Field3, entityx(local3\Field1\Field2, $01), ((entityy(me\Field60, $00) + 1.0) - min((sin(local3\Field2) * 1.5), 1.1)), entityz(local3\Field1\Field2, $01), $01)
                            pointentity(n_i\Field3\Field3, camera, 0.0)
                            animatenpc(n_i\Field3, 55.0, 104.0, 0.1, $01)
                            resetentity(n_i\Field3\Field3)
                            positionentity(n_i\Field3\Field0, entityx(n_i\Field3\Field3, $00), entityy(n_i\Field3\Field3, $00), entityz(n_i\Field3\Field3, $00), $00)
                            rotateentity(n_i\Field3\Field0, 0.0, entityyaw(n_i\Field3\Field3, $00), 0.0, $00)
                        ElseIf (((180.0 < local3\Field2) And (300.0 > local3\Field2)) <> 0) Then
                            n_i\Field3\Field10 = 3.0
                            n_i\Field3\Field26 = 0.0
                            n_i\Field3\Field41 = 700.0
                            n_i\Field3\Field40 = $00
                            n_i\Field3\Field42 = $00
                            positionentity(n_i\Field3\Field3, entityx(local3\Field1\Field2, $01), -3.0, entityz(local3\Field1\Field2, $01), $01)
                            resetentity(n_i\Field3\Field3)
                            local5 = createdecal($00, local3\Field1\Field3, (local3\Field1\Field4 + 0.005), local3\Field1\Field5, 90.0, rnd(360.0, 0.0), 0.0, 0.05, 0.8, $00, $01, $00, $00, $00)
                            local5\Field4 = 0.01
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                            local3\Field2 = 300.0
                        ElseIf (800.0 > local3\Field2) Then
                            If ((((entityy(me\Field60, $00) - 0.05) <= entityy(n_i\Field3\Field3, $00)) Lor (chs\Field2 Lor i_268\Field2)) <> 0) Then
                                removeevent(local3)
                            Else
                                translateentity(n_i\Field3\Field3, 0.0, (((entityy(me\Field60, $01) - 0.3) - entityy(n_i\Field3\Field3, $00)) / 50.0), 0.0, $00)
                                If (-0.1 > entityy(n_i\Field3\Field3, $00)) Then
                                    n_i\Field3\Field24 = 0.0
                                EndIf
                            EndIf
                        Else
                            removeevent(local3)
                        EndIf
                    EndIf
                Else
                    removeevent(local3)
                EndIf
            Case $0D
                If (event_isplayerinroom(local3) <> 0) Then
                    If (0.0 = n_i\Field2\Field26) Then
                        If (0.0 = local3\Field2) Then
                            If (local3\Field1\Field14[$00]\Field6 <> 0) Then
                                positionentity(n_i\Field2\Field3, entityx(local3\Field1\Field11[$00], $01), 0.5, entityz(local3\Field1\Field11[$00], $01), $00)
                                resetentity(n_i\Field2\Field3)
                                local3\Field2 = 1.0
                            EndIf
                        Else
                            If (entityhidden(local3\Field1\Field11[$02]) <> 0) Then
                                showentity(local3\Field1\Field11[$02])
                            EndIf
                            local3\Field2 = (local3\Field2 + 1.0)
                            local38 = entitydistancesquared(me\Field60, local3\Field1\Field11[$01])
                            If (1.0 > local38) Then
                                local3\Field2 = max(local3\Field2, 840.0)
                            ElseIf (1.96 < local38) Then
                                If (((840.0 < local3\Field2) And (mp_somebodysees173(n_i\Field2) = $00)) <> 0) Then
                                    If (25.0 < entitydistancesquared(n_i\Field2\Field3, local3\Field1\Field11[$00])) Then
                                        removeevent(local3)
                                    Else
                                        tformpoint(-801.0, 240.0, -206.95, local3\Field1\Field2, $00)
                                        local5 = createdecal($18, tformedx(), tformedy(), tformedz(), 0.0, ((Float local3\Field1\Field6) + 180.0), 0.0, 0.2, 0.5, $00, $01, $00, $00, $00)
                                        entityparent(local5\Field0, local3\Field1\Field2, $01)
                                        playsoundex(loadtempsound("SFX\Room\GlassBreak.ogg"), camera, n_i\Field2\Field0, 10.0, 1.0, $00, $00)
                                        hideentity(local3\Field1\Field11[$02])
                                        positionentity(n_i\Field2\Field3, entityx(local3\Field1\Field11[$01], $01), 0.5, entityz(local3\Field1\Field11[$01], $01), $00)
                                        resetentity(n_i\Field2\Field3)
                                        removeevent(local3)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $3D
                If (n_i\Field3\Field65 = $00) Then
                    If (event_isplayerinroom(local3) <> 0) Then
                        If (0.0 = local3\Field2) Then
                            local5 = createdecal($00, local3\Field1\Field3, (local3\Field1\Field4 + 3.117188), local3\Field1\Field5, -90.0, rnd(360.0, 0.0), 0.0, 0.5, 0.8, $00, $01, $00, $00, $00)
                            local5\Field4 = 0.0015
                            entityparent(local5\Field0, local3\Field1\Field2, $01)
                            If (event_ismeinroom(local3) <> 0) Then
                                playsound_strict(snd_i\Field24[$03], $00)
                            EndIf
                            local3\Field2 = 1.0
                        EndIf
                    EndIf
                    If (0.0 < local3\Field2) Then
                        local3\Field2 = (local3\Field2 + fps\Field7[$00])
                        If (200.0 < local3\Field2) Then
                            If (local3\Field1\Field15[$00] = Null) Then
                                local3\Field1\Field15[$00] = createnpc($13, local3\Field1\Field3, (local3\Field1\Field4 + 3.515625), local3\Field1\Field5)
                                local3\Field1\Field15[$00]\Field10 = -1.0
                                local3\Field1\Field15[$00]\Field12 = -1.0
                                changenpctextureid(local3\Field1\Field15[$00], $04)
                                rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                setnpcframe(local3\Field1\Field15[$00], 1.0, $01)
                                If (event_ismeinroom(local3) <> 0) Then
                                    playsound_strict(snd_i\Field47[$00], $00)
                                    playsound_strict(snd_i\Field24[$02], $00)
                                EndIf
                            EndIf
                            updatesoundorigin(local3\Field6, camera, local3\Field1\Field2, 10.0, 1.0, $00, $01)
                            local3\Field1\Field15[$00]\Field9 = 0.0
                            If (0.35 < entityy(local3\Field1\Field15[$00]\Field3, $00)) Then
                                entitytype(local3\Field1\Field15[$00]\Field3, $02, $00)
                                animatenpc(local3\Field1\Field15[$00], 1.0, 10.0, 0.12, $00)
                                local38 = entitydistancesquared(me\Field60, local3\Field1\Field15[$00]\Field3)
                                If (0.64 > local38) Then
                                    local47 = ((sqr(local38) - 0.8) * (sqr(local38) - 0.8))
                                    local26 = pointdirection(entityx(me\Field60, $01), entityz(me\Field60, $01), entityx(local3\Field1\Field15[$00]\Field3, $01), entityz(local3\Field1\Field15[$00]\Field3, $01))
                                    translateentity(me\Field60, (cos(((- local26) + 90.0)) * local47), 0.0, (sin(((- local26) + 90.0)) * local47), $00)
                                EndIf
                                If (0.6 < entityy(local3\Field1\Field15[$00]\Field3, $00)) Then
                                    entitytype(local3\Field1\Field15[$00]\Field3, $00, $00)
                                EndIf
                            Else
                                animatenpc(local3\Field1\Field15[$00], 11.0, 19.0, 0.25, $00)
                                If (local3\Field8 = $00) Then
                                    mp_loadeventsound(local3, "SFX\Character\BodyFall.ogg", $00)
                                    playsoundex(local3\Field8, camera, local3\Field1\Field15[$00]\Field3, 10.0, 1.0, $00, $00)
                                    local5 = createdecal($00, local3\Field1\Field3, (local3\Field1\Field4 + 0.005), local3\Field1\Field5, 90.0, rnd(360.0, 0.0), 0.0, 0.4, 0.8, $00, $01, $00, $00, $00)
                                    entityparent(local5\Field0, local3\Field1\Field2, $01)
                                EndIf
                                If (18.9 <= local3\Field1\Field15[$00]\Field14) Then
                                    local3\Field1\Field15[$00]\Field50 = $01
                                    removeevent(local3)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    removeevent(local3)
                EndIf
            Case $3E
                If (0.0 = local3\Field2) Then
                    local5 = createdecal($00, (local3\Field1\Field3 + rnd(-0.5, 0.5)), (local3\Field1\Field4 + 0.005), (local3\Field1\Field5 + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0, 2.5, 1.0, $00, $01, $00, $00, $00)
                    entityparent(local5\Field0, local3\Field1\Field2, $01)
                    local3\Field2 = 1.0
                ElseIf (event_ismeinroom(local3) <> 0) Then
                    If (snd_i\Field63 = $00) Then
                        snd_i\Field63 = loadsound_strict("SFX\Room\Sinkhole.ogg")
                    EndIf
                    local3\Field6 = loopsoundex(snd_i\Field63, local3\Field6, camera, local3\Field1\Field2, 4.5, 1.5, $00)
                    If (((0.5 > local3\Field1\Field8) And (chs\Field2 = $00)) <> 0) Then
                        If (0.0 = local3\Field3) Then
                            playsound_strict(loadtempsound("SFX\Room\SinkholeFall.ogg"), $00)
                        EndIf
                        makemeunplayable()
                        local31 = curvevalue(entityx(local3\Field1\Field2, $00), entityx(me\Field60, $00), 10.0)
                        local32 = curvevalue((entityy(local3\Field1\Field2, $00) - local3\Field3), entityy(me\Field60, $00), 25.0)
                        local33 = curvevalue(entityz(local3\Field1\Field2, $00), entityz(me\Field60, $00), 10.0)
                        positionentity(me\Field60, local31, local32, local33, $01)
                        me\Field36 = 0.0
                        resetentity(me\Field60)
                        local3\Field3 = min((local3\Field3 + (fps\Field7[$00] / 200.0)), 2.0)
                        me\Field50 = min((local3\Field3 * 5.0), 10.0)
                        me\Field49 = (local3\Field3 * 500.0)
                        If (0.2 <= local3\Field3) Then
                            me\Field10 = -10.0
                            If (3.0 = n_i\Field3\Field10) Then
                                n_i\Field3\Field24 = 0.0
                            EndIf
                        EndIf
                        If (2.0 = local3\Field3) Then
                            mp_movetopocketdimension()
                        EndIf
                    ElseIf (chs\Field3 <> 0) Then
                        me\Field9 = $01
                    EndIf
                Else
                    local3\Field3 = 0.0
                EndIf
            Case $40
                If (0.0 = local3\Field2) Then
                    If (event_isplayerinroom(local3) <> 0) Then
                        local3\Field2 = (rnd(50.0, 100.0) * 70.0)
                    EndIf
                Else
                    event_resetprev()
                    local3\Field2 = (local3\Field2 - fps\Field7[$00])
                    If (((1190.0 > local3\Field2) And playerinreachableroom($01, $00)) <> 0) Then
                        If (1190.0 <= (local3\Field2 + fps\Field7[$00])) Then
                            local3\Field6 = playsound_strict(loadtempsound("SFX\SCP\682\Roar.ogg"), $00)
                        EndIf
                        If (980.0 < local3\Field2) Then
                            me\Field24 = 0.5
                        EndIf
                        If (((420.0 < local3\Field2) And (665.0 > local3\Field2)) <> 0) Then
                            me\Field24 = 2.0
                        EndIf
                        If (70.0 > local3\Field2) Then
                            removeevent(local3)
                        EndIf
                    EndIf
                EndIf
            Case $41
                If (8.0 > local3\Field18) Then
                    createnpc($0F, local3\Field1\Field3, (local3\Field1\Field4 + (1.0 / 5.12)), local3\Field1\Field5)
                    removeevent(local3)
                EndIf
            Case $2A
                If (8.0 > local3\Field18) Then
                    tformpoint(256.0, 55.2, 256.0, local3\Field1\Field2, $00)
                    local1 = createnpc($13, tformedx(), tformedy(), tformedz())
                    local1\Field12 = -1.0
                    local1\Field50 = $01
                    changenpctextureid(local1, $08)
                    setnpcframe(local1, 19.0, $01)
                    rotateentity(local1\Field3, 0.0, ((Float local3\Field1\Field6) - 30.0), 0.0, $01)
                    removeevent(local3)
                EndIf
            Case $0A
                If (6.0 > local3\Field18) Then
                    If (local3\Field1\Field15[$00] = Null) Then
                        tformpoint(-156.0, 55.0, 121.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($14, tformedx(), tformedy(), tformedz())
                        local3\Field1\Field15[$00]\Field10 = 8.0
                        local3\Field1\Field15[$00]\Field50 = $01
                        setnpcframe(local3\Field1\Field15[$00], 288.0, $01)
                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 225.0), 0.0, $01)
                    EndIf
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    local3\Field6 = loopsoundex(snd_i\Field50[$02], local3\Field6, camera, local3\Field1\Field2, 5.0, 1.0, $00)
                    If (25.0 > entitydistancesquared(me\Field60, local3\Field1\Field11[$00])) Then
                        If (rand($32, $01) = $01) Then
                            settemplatevelocity(particleeffect[$13], -0.007, -0.008, -0.001, 0.0012, -0.007, 0.008)
                            setemitter(local3\Field1, entityx(local3\Field1\Field11[$00], $01), entityy(local3\Field1\Field11[$00], $01), entityz(local3\Field1\Field11[$00], $01), $13)
                            playsoundex(snd_i\Field62, camera, local3\Field1\Field11[$00], 3.0, 0.4, $00, $00)
                        EndIf
                    EndIf
                EndIf
            Case $44
                local117 = (local3\Field1\Field11[$01] <> $00)
                If (event_isplayerinroom(local3) <> 0) Then
                    local3\Field4 = (Float updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0))
                    If (local3\Field8 = $00) Then
                        If (0.0 >= local3\Field20) Then
                            local118 = mp_nearestdisttoentity(local3\Field1\Field11[$00])
                            If ((((0.64 > local118) And (0.0 = local3\Field3)) And (1.0 = local3\Field4)) <> 0) Then
                                If (local117 <> 0) Then
                                    mp_loadeventsound(local3, "SFX\Room\SparkLong.ogg", $01)
                                    local3\Field7 = playsoundex(local3\Field9, camera, local3\Field1\Field11[$01], 5.0, 1.0, $00, $00)
                                EndIf
                                stopchannel(local3\Field6)
                                local3\Field6 = $00
                                mp_loadeventsound(local3, "SFX\Room\Airlock.ogg", $00)
                                For local20 = $00 To $01 Step $01
                                    local3\Field1\Field14[local20]\Field9 = $01
                                    openclosedoor(local3\Field1\Field14[local20], $01, $00)
                                Next
                                If (event_ismeinroom(local3) <> 0) Then
                                    playsound_strict(snd_i\Field50[$03], $00)
                                EndIf
                                local3\Field2 = 0.01
                            ElseIf (5.29 < local118) Then
                                local3\Field3 = 0.0
                            EndIf
                            local3\Field20 = 17.5
                        EndIf
                        local3\Field20 = (local3\Field20 - fps\Field7[$00])
                    ElseIf (630.0 > local3\Field2) Then
                        local3\Field2 = (local3\Field2 + fps\Field7[$00])
                        If (local3\Field1\Field14[$00]\Field4 = $00) Then
                            local3\Field1\Field14[$00]\Field6 = $00
                        EndIf
                        If (local3\Field1\Field14[$01]\Field4 = $00) Then
                            local3\Field1\Field14[$01]\Field6 = $00
                        EndIf
                        If (70.0 > local3\Field2) Then
                            If (local117 <> 0) Then
                                If (local3\Field1\Field17[$02] = Null) Then
                                    local3\Field1\Field17[$02] = setemitter(local3\Field1, entityx(local3\Field1\Field11[$01], $01), entityy(local3\Field1\Field11[$01], $01), entityz(local3\Field1\Field11[$01], $01), $10)
                                EndIf
                            EndIf
                        ElseIf (((210.0 < local3\Field2) And (490.0 > local3\Field2)) <> 0) Then
                            event_resetprev()
                            If (4.0 > entitydistancesquared(local3\Field1\Field11[$00], me\Field60)) Then
                                If (((wi\Field0 = $00) And (wi\Field2 = $00)) <> 0) Then
                                    me\Field14 = max(70.0, me\Field14)
                                EndIf
                            EndIf
                            If (local3\Field1\Field17[$02] <> Null) Then
                                freeemitter(local3\Field1\Field17[$02], $00)
                            EndIf
                            For local20 = $00 To $01 Step $01
                                If (local3\Field1\Field17[local20] = Null) Then
                                    local23 = (local3\Field1\Field7\Field6 = $61)
                                    tformpoint(((((220.0 * (Float local20)) - 110.0) * (Float local23)) + ((Float (local23 = $00)) * 320.0)), 360.0, (((Float local23) * 320.0) + (((220.0 * (Float local20)) - 110.0) * (Float (local23 = $00)))), local3\Field1\Field2, $00)
                                    local3\Field1\Field17[local20] = setemitter(local3\Field1, tformedx(), tformedy(), tformedz(), $02)
                                EndIf
                            Next
                            If (channelplaying(local3\Field6) = $00) Then
                                local3\Field6 = playsoundex(local3\Field8, camera, local3\Field1\Field11[$00], 5.0, 1.0, $00, $00)
                            EndIf
                        EndIf
                    Else
                        For local20 = $00 To $01 Step $01
                            If (local3\Field1\Field17[local20] <> Null) Then
                                freeemitter(local3\Field1\Field17[local20], $00)
                            EndIf
                            If (local3\Field1\Field14[local20]\Field6 = $00) Then
                                openclosedoor(local3\Field1\Field14[local20], $01, $00)
                            EndIf
                            local3\Field1\Field14[local20]\Field9 = $00
                        Next
                        freesound_strict(local3\Field8)
                        local3\Field8 = $00
                        local3\Field2 = 0.0
                        local3\Field3 = 1.0
                    EndIf
                    If (local117 <> 0) Then
                        updatesoundorigin(local3\Field7, camera, local3\Field1\Field11[$01], 5.0, 1.0, $00, $01)
                    EndIf
                    updatesoundorigin(local3\Field6, camera, local3\Field1\Field11[$00], 5.0, 1.0, $00, $01)
                Else
                    local3\Field3 = 0.0
                EndIf
            Case $0C
                If (event_isplayerinroom(local3) <> 0) Then
                    If (0.0 = local3\Field2) Then
                        If (0.0 = local3\Field3) Then
                            local3\Field3 = -350.0
                        EndIf
                        local3\Field2 = 1.0
                    EndIf
                EndIf
                If (1.0 = local3\Field2) Then
                    If (0.0 > local3\Field3) Then
                        If (-350.0 = local3\Field3) Then
                            If (1.0 < (Abs (entityy(local3\Field1\Field14[$00]\Field2, $00) - entityy(me\Field60, $00)))) Then
                                For local13 = Each securitycams
                                    If (local13\Field16 = local3\Field1) Then
                                        If (((15.0 > entitydistancesquared(me\Field60, local13\Field4)) And entityinview(local13\Field2, event_getsomebodycamera(local3))) <> 0) Then
                                            local3\Field3 = min((local3\Field3 + fps\Field7[$00]), 0.0)
                                        EndIf
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Else
                            local3\Field3 = min((local3\Field3 + fps\Field7[$00]), 0.0)
                        EndIf
                    ElseIf (0.0 = local3\Field3) Then
                        local119 = 0.0
                        local120 = 0.0
                        local121 = $FFFFFFFF
                        local122 = $FFFFFFFF
                        For local20 = $00 To $03 Step $01
                            If (local3\Field1\Field20[local20] <> Null) Then
                                If (local121 = $FFFFFFFF) Then
                                    local119 = entitydistancesquared(local3\Field1\Field11[$07], local3\Field1\Field20[local20]\Field2)
                                    local121 = local20
                                Else
                                    local120 = entitydistancesquared(local3\Field1\Field11[$07], local3\Field1\Field20[local20]\Field2)
                                    local122 = local20
                                EndIf
                            EndIf
                        Next
                        If (n_i\Field6 = Null) Then
                            If (local120 < local119) Then
                                n_i\Field6 = createnpc($02, entityx(local3\Field1\Field20[local121]\Field2, $00), entityy(local3\Field1\Field11[$07], $01), entityz(local3\Field1\Field20[local121]\Field2, $00))
                            Else
                                n_i\Field6 = createnpc($02, entityx(local3\Field1\Field20[local122]\Field2, $00), entityy(local3\Field1\Field11[$07], $01), entityz(local3\Field1\Field20[local122]\Field2, $00))
                            EndIf
                            giveachievement("049", $01)
                        Else
                            If (local120 < local119) Then
                                positionentity(n_i\Field6\Field3, entityx(local3\Field1\Field20[local121]\Field2, $00), entityy(local3\Field1\Field11[$07], $01), entityz(local3\Field1\Field20[local121]\Field2, $00), $01)
                            Else
                                positionentity(n_i\Field6\Field3, entityx(local3\Field1\Field20[local122]\Field2, $00), entityy(local3\Field1\Field11[$07], $01), entityz(local3\Field1\Field20[local122]\Field2, $00), $01)
                            EndIf
                            resetentity(n_i\Field6\Field3)
                        EndIf
                        pointentity(n_i\Field6\Field3, local3\Field1\Field2, 0.0)
                        moveentity(n_i\Field6\Field3, 0.0, 0.0, -1.0)
                        local3\Field1\Field15[$00] = n_i\Field6
                        local3\Field1\Field15[$00]\Field43 = $00
                        local3\Field1\Field15[$00]\Field36 = entityx(me\Field60, $00)
                        local3\Field1\Field15[$00]\Field38 = entityz(me\Field60, $00)
                        local3\Field1\Field15[$00]\Field10 = 4.0
                        local3\Field1\Field15[$00]\Field13 = $02
                        local3\Field3 = 1.0
                    ElseIf (1.0 = local3\Field3) Then
                        If (local3\Field1\Field15[$00]\Field40 <> $01) Then
                            local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], entityx(local3\Field1\Field11[$0F], $01), entityy(local3\Field1\Field11[$0F], $01), entityz(local3\Field1\Field11[$0F], $01))
                        Else
                            local3\Field3 = 2.0
                        EndIf
                    ElseIf (2.0 = local3\Field3) Then
                        If (local3\Field1\Field15[$00]\Field40 <> $01) Then
                            local3\Field1\Field15[$00]\Field12 = 1.0
                            local3\Field1\Field15[$00]\Field41 = 0.0
                            local3\Field3 = 3.0
                        ElseIf (25.0 > entitydistancesquared(local3\Field1\Field15[$00]\Field3, local3\Field1\Field14[$00]\Field2)) Then
                            If (mp_ishoster() <> 0) Then
                                For local20 = $00 To $01 Step $01
                                    local3\Field1\Field14[local20]\Field4 = $01
                                    If (local3\Field1\Field14[local20]\Field6 = $00) Then
                                        openclosedoor(local3\Field1\Field14[local20], $01, $00)
                                    EndIf
                                Next
                            EndIf
                            If (0.0 = local3\Field1\Field15[$00]\Field28) Then
                                If (channelplaying(local3\Field1\Field14[$01]\Field17) = $00) Then
                                    local3\Field1\Field14[$01]\Field17 = playsoundex(snd_i\Field4, camera, local3\Field1\Field14[$01]\Field2, 7.0, 1.0, $00, $00)
                                EndIf
                                local3\Field1\Field15[$00]\Field7 = 0.0
                                local3\Field1\Field15[$00]\Field28 = 1.0
                            EndIf
                        EndIf
                        If (4.0 <> local3\Field1\Field15[$00]\Field10) Then
                            local3\Field3 = 7.0
                        EndIf
                    ElseIf (3.0 = local3\Field3) Then
                        If (4.0 <> local3\Field1\Field15[$00]\Field10) Then
                            local3\Field3 = 7.0
                        EndIf
                        If (npcseesplayer(local3\Field1\Field15[$00], ((8.0 - me\Field40) + me\Field42), 60.0, $01) = $02) Then
                            local3\Field3 = 4.0
                        EndIf
                        If (local3\Field1\Field15[$00]\Field40 <> $01) Then
                            If (0.0 = local3\Field1\Field15[$00]\Field41) Then
                                If (local3\Field1\Field15[$00]\Field13 = $01) Then
                                    If (local3\Field1\Field15[$00]\Field20 = $00) Then
                                        local3\Field1\Field15[$00]\Field19 = loadsound_strict("SFX\SCP\049\Room2SL0.ogg")
                                        local3\Field1\Field15[$00]\Field20 = playsoundex(local3\Field1\Field15[$00]\Field19, camera, local3\Field1\Field15[$00]\Field3, 10.0, 1.0, $01, $01)
                                    ElseIf (channelplaying(local3\Field1\Field15[$00]\Field20) = $00) Then
                                        local3\Field1\Field15[$00]\Field41 = 1.0
                                        local3\Field1\Field15[$00]\Field20 = $00
                                    EndIf
                                ElseIf (local3\Field1\Field15[$00]\Field13 = $02) Then
                                    If (3.0 = local3\Field1\Field15[$00]\Field12) Then
                                        If (local3\Field1\Field15[$00]\Field20 = $00) Then
                                            local3\Field1\Field15[$00]\Field19 = loadsound_strict("SFX\SCP\049\Room2SL1.ogg")
                                            local3\Field1\Field15[$00]\Field20 = playsoundex(local3\Field1\Field15[$00]\Field19, camera, local3\Field1\Field15[$00]\Field3, 10.0, 1.0, $01, $01)
                                        ElseIf (channelplaying(local3\Field1\Field15[$00]\Field20) = $00) Then
                                            local3\Field1\Field15[$00]\Field41 = 1.0
                                            local3\Field1\Field15[$00]\Field20 = $00
                                        EndIf
                                    ElseIf (1118.0 <= local3\Field1\Field15[$00]\Field14) Then
                                        local3\Field1\Field15[$00]\Field41 = 1.0
                                    EndIf
                                EndIf
                            Else
                                Select local3\Field1\Field15[$00]\Field12
                                    Case 1.0
                                        local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], entityx(local3\Field1\Field11[$10], $01), entityy(local3\Field1\Field11[$10], $01), entityz(local3\Field1\Field11[$10], $01))
                                        local3\Field1\Field15[$00]\Field13 = $01
                                    Case 2.0
                                        local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], entityx(local3\Field1\Field11[$0F], $01), entityy(local3\Field1\Field11[$0F], $01), entityz(local3\Field1\Field11[$0F], $01))
                                        local3\Field1\Field15[$00]\Field13 = $02
                                    Case 3.0
                                        local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], entityx(local3\Field1\Field11[$11], $01), entityy(local3\Field1\Field11[$11], $01), entityz(local3\Field1\Field11[$11], $01))
                                        local3\Field1\Field15[$00]\Field13 = $02
                                    Case 4.0
                                        local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], local3\Field1\Field15[$00]\Field36, 0.1, local3\Field1\Field15[$00]\Field38)
                                        local3\Field1\Field15[$00]\Field13 = $02
                                    Case 5.0
                                        local3\Field3 = 5.0
                                End Select
                                local3\Field1\Field15[$00]\Field41 = 0.0
                                local3\Field1\Field15[$00]\Field12 = (local3\Field1\Field15[$00]\Field12 + 1.0)
                            EndIf
                        EndIf
                    ElseIf (4.0 = local3\Field3) Then
                        If (4.0 <> local3\Field1\Field15[$00]\Field10) Then
                            local3\Field3 = 7.0
                            local3\Field1\Field15[$00]\Field12 = 6.0
                        EndIf
                    ElseIf (5.0 = local3\Field3) Then
                        local3\Field1\Field15[$00]\Field10 = 2.0
                        For local2 = Each rooms
                            If (local2 <> playerroom) Then
                                If (((((hidedistance * 2.0) * (hidedistance * 2.0)) > entitydistancesquared(local2\Field2, local3\Field1\Field15[$00]\Field3)) And ((hidedistance * hidedistance) < entitydistancesquared(local2\Field2, local3\Field1\Field15[$00]\Field3))) <> 0) Then
                                    local3\Field1\Field15[$00]\Field40 = findpath(local3\Field1\Field15[$00], entityx(local2\Field2, $00), entityy(local2\Field2, $00), entityz(local2\Field2, $00))
                                    local3\Field1\Field15[$00]\Field41 = 0.0
                                    If (local3\Field1\Field15[$00]\Field40 = $01) Then
                                        local3\Field3 = 6.0
                                    EndIf
                                    Exit
                                EndIf
                            EndIf
                        Next
                    ElseIf (6.0 = local3\Field3) Then
                        If ((((npcseesplayer(local3\Field1\Field15[$00], ((8.0 - me\Field40) + me\Field42), 60.0, $01) = $01) Lor (0.0 < local3\Field1\Field15[$00]\Field11)) Lor (local3\Field1\Field15[$00]\Field29 > $00)) <> 0) Then
                            local3\Field3 = 7.0
                        Else
                            If (event_ismeinroom(local3) <> 0) Then
                                shouldplay = $13
                            EndIf
                            If (local3\Field1\Field15[$00]\Field40 <> $01) Then
                                local3\Field1\Field15[$00]\Field26 = 4200.0
                                positionentity(local3\Field1\Field15[$00]\Field3, 0.0, -500.0, 0.0, $00)
                                resetentity(local3\Field1\Field15[$00]\Field3)
                                local3\Field3 = 7.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    If (1.0 = local3\Field4) Then
                        local3\Field4 = (Float updatelever(local3\Field1\Field13[$00]\Field0, $00, $50, -80.0))
                    Else
                        updatelever(local3\Field1\Field13[$00]\Field0, $01, $50, -80.0)
                    EndIf
                    If (0.0 = local3\Field4) Then
                        turncheckpointmonitorsoff($01)
                        entitytexture(local3\Field1\Field11[$12], local3\Field1\Field21[$00], $00, $00)
                    Else
                        updatecheckpointmonitors($01)
                        entitytexture(local3\Field1\Field11[$12], local3\Field1\Field21[$00], ((50.0 > mon_i\Field2[$00]) + $01), $00)
                    EndIf
                    event_resetprev()
                    If (1.0 < (Abs (entityy(local3\Field1\Field14[$00]\Field2, $00) - entityy(me\Field60, $00)))) Then
                        For local20 = $00 To $0E Step $01
                            If (((local3\Field1\Field11[local20] <> $00) And (local20 <> $07)) <> 0) Then
                                If (entityhidden(local3\Field1\Field11[local20]) <> 0) Then
                                    showentity(local3\Field1\Field11[local20])
                                EndIf
                            EndIf
                        Next
                        For local13 = Each securitycams
                            If (local13\Field16 = local3\Field1) Then
                                If (entityhidden(local13\Field2) <> 0) Then
                                    showentity(local13\Field2)
                                EndIf
                                Exit
                            EndIf
                        Next
                        updateredlight(local3\Field1\Field11[$14], 1500.0, 800.0)
                    Else
                        For local20 = $00 To $0E Step $01
                            If (((local3\Field1\Field11[local20] <> $00) And (local20 <> $07)) <> 0) Then
                                If (entityhidden(local3\Field1\Field11[local20]) = $00) Then
                                    hideentity(local3\Field1\Field11[local20])
                                EndIf
                            EndIf
                        Next
                        For local13 = Each securitycams
                            If (local13\Field16 = local3\Field1) Then
                                If (entityhidden(local13\Field2) = $00) Then
                                    hideentity(local13\Field2)
                                EndIf
                                Exit
                            EndIf
                        Next
                    EndIf
                    For local4 = Each events
                        If (local4\Field0 = $23) Then
                            If (2.0 = local4\Field2) Then
                                mon_i\Field3[$01] = $00
                                entitytexture(local3\Field1\Field11[$13], local3\Field1\Field21[$00], $03, $00)
                            Else
                                mon_i\Field3[$01] = $01
                                entitytexture(local3\Field1\Field11[$13], local3\Field1\Field21[$01], ((50.0 > mon_i\Field2[$01]) + $06), $00)
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
            Case $3C
                If (hidedistance > local3\Field18) Then
                    If (2.0 <> local3\Field2) Then
                        If (event_isplayerinroom(local3) <> 0) Then
                            local3\Field2 = 2.0
                        EndIf
                        If (n_i\Field4 <> Null) Then
                            If ((((1.0 <> n_i\Field4\Field10) Lor (1600.0 > entitydistancesquared(n_i\Field4\Field3, me\Field60))) Lor (entitydistancesquared(n_i\Field4\Field3, me\Field60) < entitydistancesquared(n_i\Field4\Field3, local3\Field1\Field2))) <> 0) Then
                                local3\Field2 = 2.0
                            EndIf
                            For local4 = Each events
                                If (local4\Field0 = $20) Then
                                    If (((0.0 < local4\Field2) And (local4\Field1\Field15[$00] <> Null)) <> 0) Then
                                        local3\Field2 = 2.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            For local2 = Each rooms
                                If (local2\Field7\Field6 = $27) Then
                                    If (10.0 > local2\Field8) Then
                                        local3\Field2 = 2.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                        For local4 = Each events
                            If (local4\Field0 = $20) Then
                                If (0.0 = local4\Field2) Then
                                    local3\Field2 = 2.0
                                    Exit
                                EndIf
                            EndIf
                        Next
                    EndIf
                    If (0.0 = local3\Field2) Then
                        local125 = local3\Field1\Field7\Field6
                        Select local125
                            Case $3E,$3F,$40,$43,$44
                                If (((local125 = $43) Lor (local125 = $44)) <> 0) Then
                                    local124 = rand($00, $03)
                                Else
                                    local124 = rand($00, $02)
                                EndIf
                                Select local124
                                    Case $00
                                        local31 = -608.0
                                        local33 = 0.0
                                    Case $01
                                        local31 = 0.0
                                        local33 = -608.0
                                    Case $02
                                        local31 = 608.0
                                        local33 = 0.0
                                    Case $03
                                        local31 = 0.0
                                        local33 = 608.0
                                End Select
                            Default
                                local31 = rnd(-50.0, 50.0)
                                local33 = rnd(-50.0, 50.0)
                        End Select
                        local25 = createpivot(local3\Field1\Field2)
                        positionentity(local25, local31, 0.0, local33, $00)
                        If (n_i\Field4 <> Null) Then
                            positionentity(n_i\Field4\Field3, entityx(local25, $01), (local3\Field1\Field4 + 0.5), entityz(local25, $01), $00)
                            resetentity(n_i\Field4\Field3)
                        Else
                            n_i\Field4 = createnpc($05, entityx(local25, $01), (local3\Field1\Field4 + 0.5), entityz(local25, $01))
                        EndIf
                        n_i\Field4\Field10 = 1.0
                        pointentity(n_i\Field4\Field3, me\Field60, 0.0)
                        rotateentity(n_i\Field4\Field3, 0.0, (entityyaw(n_i\Field4\Field3, $00) + 180.0), 0.0, $00)
                        freeentity(local25)
                        local25 = $00
                        local3\Field2 = 1.0
                    ElseIf (1.0 = local3\Field2) Then
                        pointentity(n_i\Field4\Field3, me\Field60, 0.0)
                        rotateentity(n_i\Field4\Field3, 0.0, (entityyaw(n_i\Field4\Field3, $00) + 180.0), 0.0, $00)
                        If (((hidedistance * 0.5) * (hidedistance * 0.5)) > entitydistancesquared(n_i\Field4\Field3, me\Field60)) Then
                            If (entityvisible(n_i\Field4\Field3, camera) <> 0) Then
                                pointentity(n_i\Field4\Field3, me\Field60, 0.0)
                                rotateentity(n_i\Field4\Field3, 0.0, (entityyaw(n_i\Field4\Field3, $00) + rnd(170.0, 190.0)), 0.0, $00)
                                local3\Field2 = 2.0
                            EndIf
                        EndIf
                    ElseIf (3.0 = local3\Field2) Then
                        local3\Field2 = 2.0
                    EndIf
                ElseIf (2.0 = local3\Field2) Then
                    local3\Field2 = (3.0 - ((Float (rand($FFFFFFFF, ((selecteddifficulty\Field2 Shl $01) + $01)) > $00)) * 3.0))
                EndIf
            Case $37
                If (event_isplayerinroom(local3) <> 0) Then
                    If (0.0 = local3\Field2) Then
                        tformpoint(-820.0, 200.0, -464.0, local3\Field1\Field2, $00)
                        local3\Field1\Field15[$00] = createnpc($00, tformedx(), tformedy(), tformedz())
                        rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 270.0), 0.0, $01)
                        local3\Field2 = 1.0
                    ElseIf (1.0 = local3\Field2) Then
                        If (1.96 > entitydistancesquared(local3\Field1\Field15[$00]\Field3, me\Field60)) Then
                            me\Field50 = 10.0
                            playsound_strict(snd_i\Field34, $00)
                            local3\Field1\Field15[$00]\Field10 = 1.0
                            local3\Field2 = 2.0
                        EndIf
                    EndIf
                    If (local3\Field1\Field11[$01] = $00) Then
                        tformpoint(-910.0, 144.0, -778.0, local3\Field1\Field2, $00)
                        local3\Field1\Field11[$01] = copyentity(n_i\Field0[$1C], $00)
                        scaleentity(local3\Field1\Field11[$01], 0.07, 0.07, 0.07, $00)
                        positionentity(local3\Field1\Field11[$01], tformedx(), tformedy(), tformedz(), $00)
                        rotateentity(local3\Field1\Field11[$01], 6.0, ((Float local3\Field1\Field6) + 180.0), 0.0, $00)
                        entitypickmode(local3\Field1\Field11[$01], $01, $01)
                        entityradius(local3\Field1\Field11[$01], 0.3, 0.0)
                        local28 = loadtexture_strict("GFX\NPCs\duck(4).png", $01, $00, $01)
                        entitytexture(local3\Field1\Field11[$01], local28, $00, $00)
                        deletesingletextureentryfromcache(local28, $00)
                        local28 = $00
                        entityparent(local3\Field1\Field11[$01], local3\Field1\Field2, $01)
                    ElseIf (mp_interactobject(local3\Field1, $01, 0.8, $00, $00) <> 0) Then
                        createmsg(getlocalstring("msg", "breeze"), 6.0)
                    EndIf
                EndIf
            Case $34
                If (6.0 > local3\Field18) Then
                    tformpoint(820.0, -256.0, 0.0, local3\Field1\Field2, $00)
                    createnpc($0D, tformedx(), tformedy(), tformedz())
                    removeevent(local3)
                EndIf
            Case $21
                If (local3\Field1\Field15[$00] = Null) Then
                    tformpoint(1344.0, -743.0, -384.0, local3\Field1\Field2, $00)
                    local3\Field1\Field15[$00] = createnpc($14, tformedx(), tformedy(), tformedz())
                    local3\Field1\Field15[$00]\Field10 = 8.0
                    local3\Field1\Field15[$00]\Field50 = $01
                    setnpcframe(local3\Field1\Field15[$00], 286.0, $01)
                    rotateentity(local3\Field1\Field15[$00]\Field3, 0.0, ((Float local3\Field1\Field6) + 180.0), 0.0, $01)
                EndIf
                If (event_isplayerinroom(local3) <> 0) Then
                    updatebutton(local3\Field1\Field11[$01])
                    If (((d_i\Field9 = local3\Field1\Field11[$01]) And mo\Field0) <> 0) Then
                        createmsg(getlocalstring("msg", "elev.broken"), 6.0)
                        playsoundex(buttonsfx[$01], camera, local3\Field1\Field11[$01], 10.0, 1.0, $00, $00)
                        mo\Field0 = $00
                    EndIf
                EndIf
            Case $14
                If (12.0 > local3\Field1\Field8) Then
                    For local4 = Each events
                        If (local4\Field0 = $0C) Then
                            If (0.0 = local4\Field4) Then
                                turncheckpointmonitorsoff($01)
                            Else
                                updatecheckpointmonitors($01)
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
            Case $01
                If (event_isplayerinroom(local3) <> 0) Then
                    local3\Field2 = (local3\Field2 + fps\Field7[$00])
                    If (70.0 > local3\Field2) Then
                        If (entityhidden(local3\Field1\Field11[$00]) <> 0) Then
                            showentity(local3\Field1\Field11[$00])
                        EndIf
                    ElseIf (140.0 > local3\Field2) Then
                        If (entityhidden(local3\Field1\Field11[$00]) = $00) Then
                            hideentity(local3\Field1\Field11[$00])
                        EndIf
                    Else
                        local3\Field2 = 0.0
                    EndIf
                    If (mp_interactobject(local3\Field1, $01, 0.8, $00, $00) <> 0) Then
                        If ((((i_714\Field0 <> $02) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
                            createmsg(getlocalstring("msg", "duck"), 6.0)
                        Else
                            createmsg(getlocalstring("msg", "flamingo"), 6.0)
                        EndIf
                    EndIf
                    If (0.0 = local3\Field3) Then
                        If (mp_interactobject(local3\Field1, $02, 0.8, $00, $00) <> 0) Then
                            createmsg(getlocalstring("msg", "coinflip_1"), 6.0)
                            local3\Field3 = (Float rand($01, $02))
                        EndIf
                    Else
                        local27 = ((local3\Field3 - 1.0) * 40.0)
                        animateex(local3\Field1\Field11[$02], animtime(local3\Field1\Field11[$02]), (Int (1.0 + local27)), (Int (40.0 + local27)), 0.8, $00)
                        If ((40.0 + local27) <= animtime(local3\Field1\Field11[$02])) Then
                            setanimtime(local3\Field1\Field11[$02], 1.0, $00)
                            If (1.0 > entitydistancesquared(event_getmypivot(), local3\Field1\Field11[$02])) Then
                                createmsg(getlocalstring("msg", "coinflip_2"), 6.0)
                            EndIf
                            local3\Field3 = 0.0
                        EndIf
                    EndIf
                EndIf
            Case $2C
                If (event_isplayerinroom(local3) <> 0) Then
                    If (local3\Field1\Field15[$00] = Null) Then
                        renderloading($00, getlocalstring("loading", "ending"))
                        local3\Field1\Field15[$00] = createnpc($11, local3\Field1\Field3, 100.0, local3\Field1\Field5)
                        local3\Field1\Field15[$00]\Field10 = 1.0
                        local3\Field1\Field15[$01] = createnpc($14, entityx(local3\Field1\Field11[$02], $01), entityy(local3\Field1\Field11[$02], $01), entityz(local3\Field1\Field11[$02], $01))
                        local3\Field1\Field15[$01]\Field10 = 0.0
                        local3\Field1\Field15[$01]\Field11 = 10.0
                        local3\Field1\Field11[$00] = loadmesh_strict("GFX\Map\exit1terrain.b3d", local3\Field1\Field2)
                        scaleentity(local3\Field1\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                        rotateentity(local3\Field1\Field11[$00], 0.0, (Float local3\Field1\Field6), 0.0, $01)
                        positionentity(local3\Field1\Field11[$00], (local3\Field1\Field3 + 17.01562), (local3\Field1\Field4 - 3.972656), (local3\Field1\Field5 + 10.10938), $01)
                        renderloading($3C, getlocalstring("loading", "ending"))
                        sky = createsky("GFX\Map\Textures\sky", $00)
                        rotateentity(sky, 0.0, ((Float local3\Field1\Field6) - 90.0), 0.0, $00)
                        resetentity(me\Field60)
                        rotateentity(me\Field60, 0.0, (entityyaw(me\Field60, $00) + ((Float local3\Field1\Field6) + 180.0)), 0.0, $00)
                        renderloading($5A, getlocalstring("loading", "ending"))
                        isblackout = $00
                        hidedistance = 68.0
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg(getlocalstring("misc", "warning2"), $FF, $00, $00, $00)
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        local3\Field2 = 1.0
                        renderloading($64, "")
                    Else
                        updatesky(sky)
                        showroomsnocoll(local3\Field1)
                        cansave = $01
                        If (((2.0 > local3\Field2) And (me\Field43 = $FFFFFFFF)) <> 0) Then
                            If (2.0 = local3\Field1\Field15[$00]\Field10) Then
                                shouldplay = $06
                            Else
                                local3\Field3 = ((local3\Field3 + fps\Field7[$00]) Mod 3600.0)
                                positionentity(local3\Field1\Field15[$00]\Field3, (entityx(local3\Field1\Field2, $01) + ((cos((local3\Field3 / 10.0)) * 6000.0) * (1.0 / 256.0))), (local3\Field1\Field4 + 12.5625), (entityz(local3\Field1\Field2, $01) + ((sin((local3\Field3 / 10.0)) * 6000.0) * (1.0 / 256.0))), $00)
                                rotateentity(local3\Field1\Field15[$00]\Field3, 7.0, (local3\Field3 / 10.0), 20.0, $00)
                                shouldplay = $05
                            EndIf
                            If ((1.0 / 0.64) > entitydistancesquared(me\Field60, local3\Field1\Field11[$05])) Then
                                For local20 = $02 To $03 Step $01
                                    local3\Field1\Field14[local20]\Field6 = $00
                                    local3\Field1\Field14[local20]\Field4 = $01
                                Next
                                local3\Field1\Field15[$02] = createnpc($11, entityx(local3\Field1\Field11[$0B], $01), (entityy(local3\Field1\Field11[$0B], $01) + 0.5), entityz(local3\Field1\Field11[$0B], $01))
                                local3\Field1\Field15[$02]\Field10 = 3.0
                                local3\Field1\Field15[$03] = createnpc($11, entityx(local3\Field1\Field11[$04], $01), (entityy(local3\Field1\Field11[$04], $01) - 2.0), entityz(local3\Field1\Field11[$04], $01))
                                local3\Field1\Field15[$03]\Field10 = 3.0
                                local3\Field1\Field15[$00]\Field10 = 3.0
                                removenpc(local3\Field1\Field15[$01])
                                local3\Field6 = streamsound_strict("SFX\Ending\GateB\682Battle.ogg", (opt\Field21 * opt\Field16), $00)
                                local3\Field11 = $01
                                local3\Field2 = 2.0
                            EndIf
                        Else
                            shouldplay = $06
                            local3\Field2 = (local3\Field2 + fps\Field7[$00])
                            If (2800.0 > local3\Field2) Then
                                local3\Field1\Field15[$00]\Field36 = (entityx(local3\Field1\Field11[$06], $01) + (sin(((Float millisec) / 25.0)) * 3.0))
                                local3\Field1\Field15[$00]\Field37 = ((entityy(local3\Field1\Field11[$06], $01) + cos(((Float millisec) / 85.0))) + 9.0)
                                local3\Field1\Field15[$00]\Field38 = (entityz(local3\Field1\Field11[$06], $01) + (cos(((Float millisec) / 25.0)) * 3.0))
                                local3\Field1\Field15[$02]\Field36 = (entityx(local3\Field1\Field11[$06], $01) + (sin(((Float millisec) / 23.0)) * 3.0))
                                local3\Field1\Field15[$02]\Field37 = ((entityy(local3\Field1\Field11[$06], $01) + cos(((Float millisec) / 83.0))) + 5.0)
                                local3\Field1\Field15[$02]\Field38 = (entityz(local3\Field1\Field11[$06], $01) + (cos(((Float millisec) / 23.0)) * 3.0))
                                If (3.0 = local3\Field1\Field15[$03]\Field10) Then
                                    local3\Field1\Field15[$03]\Field36 = (entityx(local3\Field1\Field11[$06], $01) + (sin(((Float millisec) / 20.0)) * 3.0))
                                    local3\Field1\Field15[$03]\Field37 = ((entityy(local3\Field1\Field11[$06], $01) + cos(((Float millisec) / 80.0))) + 3.5)
                                    local3\Field1\Field15[$03]\Field38 = (entityz(local3\Field1\Field11[$06], $01) + (cos(((Float millisec) / 20.0)) * 3.0))
                                EndIf
                            EndIf
                        EndIf
                        If (((42.0 < local3\Field2) And (2954.0 > local3\Field2)) <> 0) Then
                            If (49.0 > local3\Field2) Then
                                me\Field23 = 0.5
                            ElseIf (((224.0 < local3\Field2) And (231.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 0.5
                            ElseIf (((427.0 < local3\Field2) And (434.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 0.5
                            ElseIf (((756.0 > local3\Field2) And (763.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 0.5
                            ElseIf (((847.0 < local3\Field2) And (861.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 1.0
                            ElseIf (((931.0 < local3\Field2) And (945.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 1.5
                            ElseIf (((1155.0 < local3\Field2) And (1295.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 3.0
                            ElseIf (((1505.0 < local3\Field2) And (1680.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 2.0
                            ElseIf (((1785.0 < local3\Field2) And (1890.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 2.0
                            ElseIf (((2170.0 < local3\Field2) And (2205.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 0.5
                            ElseIf (((2450.0 < local3\Field2) And (2555.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 1.5
                                If (2450.0 >= (local3\Field2 - fps\Field7[$00])) Then
                                    local3\Field6 = streamsound_strict("SFX\Ending\GateB\DetonatingAlphaWarheads.ogg", (opt\Field21 * opt\Field16), $00)
                                    local3\Field11 = $01
                                EndIf
                            ElseIf (((2765.0 < local3\Field2) And (2786.0 > local3\Field2)) <> 0) Then
                                me\Field23 = 1.0
                            ElseIf (2940.0 < local3\Field2) Then
                                me\Field23 = 0.5
                                local3\Field1\Field15[$00]\Field36 = (entityx(local3\Field1\Field11[$09], $01) + 4.0)
                                local3\Field1\Field15[$00]\Field37 = (entityy(local3\Field1\Field11[$09], $01) + 4.0)
                                local3\Field1\Field15[$00]\Field38 = (entityz(local3\Field1\Field11[$09], $01) + 4.0)
                                local3\Field1\Field15[$02]\Field36 = entityx(local3\Field1\Field11[$09], $01)
                                local3\Field1\Field15[$02]\Field37 = entityy(local3\Field1\Field11[$09], $01)
                                local3\Field1\Field15[$02]\Field38 = entityz(local3\Field1\Field11[$09], $01)
                            EndIf
                        EndIf
                        If (3150.0 <= local3\Field2) Then
                            local3\Field22 = $01
                            If (5250.0 > local3\Field2) Then
                                If (local3\Field7 = $00) Then
                                    local3\Field7 = streamsound_strict("SFX\Ending\GateB\Siren.ogg", (opt\Field20 * opt\Field16), $02)
                                    local3\Field12 = $01
                                EndIf
                            ElseIf (me\Field43 = $FFFFFFFF) Then
                                If (local3\Field6 <> $00) Then
                                    stopstream_strict(local3\Field6)
                                    local3\Field6 = $00
                                    local3\Field11 = $00
                                EndIf
                                If (local3\Field7 <> $00) Then
                                    stopstream_strict(local3\Field7)
                                    local3\Field7 = $00
                                    local3\Field12 = $00
                                EndIf
                                local23 = $01
                                For local4 = Each events
                                    If (local4\Field0 = $1F) Then
                                        local23 = (Int local4\Field2)
                                        Exit
                                    EndIf
                                Next
                                If (1.0 = (Float local23)) Then
                                    shouldplay = $42
                                    me\Field58 = max(me\Field58, 0.1)
                                    me\Field43 = $03
                                Else
                                    selecteditem = Null
                                    local3\Field7 = streamsound_strict("SFX\Ending\GateB\AlphaWarheadsFail.ogg", (opt\Field21 * opt\Field16), $00)
                                    local3\Field12 = $01
                                    local1 = createnpc($15, entityx(local3\Field1\Field11[$08], $01), (entityy(local3\Field1\Field11[$08], $01) + 0.29), entityz(local3\Field1\Field11[$08], $01))
                                    local3\Field1\Field15[$04] = local1
                                    local1 = createnpc($15, entityx(local3\Field1\Field14[$02]\Field0, $01), (entityy(local3\Field1\Field14[$02]\Field0, $01) + 0.29), ((entityz(local3\Field1\Field14[$02]\Field0, $01) + entityz(local3\Field1\Field14[$03]\Field0, $01)) / 2.0))
                                    local3\Field1\Field15[$05] = local1
                                    For local20 = $04 To $05 Step $01
                                        local3\Field1\Field15[local20]\Field36 = entityx(me\Field60, $00)
                                        local3\Field1\Field15[local20]\Field37 = entityy(me\Field60, $00)
                                        local3\Field1\Field15[local20]\Field38 = entityz(me\Field60, $00)
                                        local3\Field1\Field15[local20]\Field10 = 3.0
                                    Next
                                    me\Field43 = $02
                                    local3\Field2 = 5950.0
                                EndIf
                            ElseIf (me\Field43 = $02) Then
                                local3\Field1\Field14[$04]\Field6 = $01
                                local3\Field1\Field14[$04]\Field4 = $00
                                local3\Field1\Field15[$00]\Field36 = (entityx(local3\Field1\Field11[$06], $01) + (sin(((Float millisec) / 25.0)) * 3.0))
                                local3\Field1\Field15[$00]\Field37 = ((entityy(local3\Field1\Field11[$06], $01) + cos(((Float millisec) / 85.0))) + 9.0)
                                local3\Field1\Field15[$00]\Field38 = (entityz(local3\Field1\Field11[$06], $01) + (cos(((Float millisec) / 25.0)) * 3.0))
                                local3\Field1\Field15[$02]\Field36 = (entityx(local3\Field1\Field11[$06], $01) + (sin(((Float millisec) / 23.0)) * 3.0))
                                local3\Field1\Field15[$02]\Field37 = ((entityy(local3\Field1\Field11[$06], $01) + cos(((Float millisec) / 83.0))) + 5.0)
                                local3\Field1\Field15[$02]\Field38 = (entityz(local3\Field1\Field11[$06], $01) + (cos(((Float millisec) / 23.0)) * 3.0))
                                For local20 = $04 To $05 Step $01
                                    local3\Field1\Field15[local20]\Field36 = entityx(me\Field60, $00)
                                    local3\Field1\Field15[local20]\Field37 = entityy(me\Field60, $00)
                                    local3\Field1\Field15[local20]\Field38 = entityz(me\Field60, $00)
                                Next
                                If ((((5.0 <> local3\Field1\Field15[$04]\Field10) And (npcseesplayer(local3\Field1\Field15[$04], ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01)) Lor ((5.0 <> local3\Field1\Field15[$05]\Field10) And (npcseesplayer(local3\Field1\Field15[$05], ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01))) <> 0) Then
                                    For local20 = $04 To $05 Step $01
                                        local3\Field1\Field15[local20]\Field10 = 5.0
                                    Next
                                    shouldplay = $00
                                    makemeunplayable()
                                    local3\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateB\THEREHEIS.ogg"), $01)
                                EndIf
                                If (((5.0 = local3\Field1\Field15[$04]\Field10) And (channelplaying(local3\Field6) = $00)) <> 0) Then
                                    clearcheats()
                                    playsound_strict(loadtempsound("SFX\Ending\GateB\Gunshot.ogg"), $00)
                                    me\Field51 = 1.0
                                    me\Field0 = 1.0
                                    msg\Field2 = ""
                                    me\Field10 = -10.0
                                    removeevent(local3)
                                    Exit
                                EndIf
                            EndIf
                        EndIf
                        If (1855.0 < local3\Field2) Then
                            If (local3\Field1\Field11[$07] = $00) Then
                                local3\Field1\Field11[$07] = loadmesh_strict("GFX\NPCs\scp_682_arm.b3d", $00)
                                scaleentity(local3\Field1\Field11[$07], 0.15, 0.15, 0.15, $00)
                                local23 = (Int ((min((((entitydistance(local3\Field1\Field15[$03]\Field3, me\Field60) / (1.0 / 256.0)) - 3000.0) / 4.0), 1000.0) + 1408.0) * (1.0 / 256.0)))
                                positionentity(local3\Field1\Field11[$07], entityx(local3\Field1\Field15[$03]\Field3, $00), (local3\Field1\Field4 + 5.5), entityz(local3\Field1\Field15[$03]\Field3, $00), $00)
                                rotateentity(local3\Field1\Field11[$07], 0.0, ((Float local3\Field1\Field6) + rnd(-10.0, 10.0)), 0.0, $01)
                                turnentity(local3\Field1\Field11[$07], 0.0, 0.0, 180.0, $00)
                            EndIf
                            If (340.0 > wrapangle(entityroll(local3\Field1\Field11[$07], $00), 360.0)) Then
                                local37 = wrapangle(entityroll(local3\Field1\Field11[$07], $00), 360.0)
                                turnentity(local3\Field1\Field11[$07], 0.0, 0.0, ((((Abs sin(local37)) * 2.0) + 5.0) * fps\Field7[$00]), $00)
                                If (((270.0 > local37) And (270.0 <= wrapangle(entityroll(local3\Field1\Field11[$07], $00), 360.0))) <> 0) Then
                                    playsound_strict(loadtempsound("SFX\Character\Apache\Crash0.ogg"), $00)
                                    local3\Field1\Field15[$03]\Field10 = 4.0
                                    local3\Field1\Field15[$03]\Field11 = 1.0
                                    local3\Field1\Field15[$03]\Field36 = entityx(local3\Field1\Field11[$04], $01)
                                    local3\Field1\Field15[$03]\Field37 = (entityy(local3\Field1\Field11[$04], $01) - 2.5)
                                    local3\Field1\Field15[$03]\Field38 = entityz(local3\Field1\Field11[$04], $01)
                                    local18 = setemitter(Null, entityx(local3\Field1\Field15[$03]\Field3, $00), entityy(local3\Field1\Field15[$03]\Field3, $00), entityz(local3\Field1\Field15[$03]\Field3, $00), $08)
                                    entityparent(local18\Field6, local3\Field1\Field15[$03]\Field3, $01)
                                EndIf
                            Else
                                hideentity(local3\Field1\Field11[$07])
                            EndIf
                        EndIf
                    EndIf
                    local37 = max(sin(entityyaw(me\Field60, $00)), 0.0)
                    If (local3\Field1\Field15[$01] <> Null) Then
                        If (((225.0 > entitydistancesquared(local3\Field1\Field15[$01]\Field3, me\Field60)) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                            local3\Field1\Field15[$01]\Field10 = 1.0
                            local3\Field1\Field15[$01]\Field12 = 1.0
                        Else
                            local3\Field1\Field15[$01]\Field10 = 0.0
                            local3\Field1\Field15[$01]\Field12 = 0.0
                        EndIf
                        If (((((79.21 > entitydistancesquared(local3\Field1\Field15[$01]\Field3, me\Field60)) Lor (285.61 > entitydistancesquared(local3\Field1\Field11[$03], me\Field60))) Lor chs\Field2) Lor i_268\Field2) <> 0) Then
                            local3\Field1\Field15[$01]\Field12 = 0.0
                        Else
                            local3\Field1\Field15[$01]\Field12 = 1.0
                        EndIf
                    EndIf
                Else
                    hideroomsnocoll(local3\Field1)
                EndIf
            Case $2E
                If (event_isplayerinroom(local3) <> 0) Then
                    If (local3\Field1\Field15[$02] = Null) Then
                        renderloading($00, getlocalstring("loading", "ending"))
                        For local20 = $02 To $04 Step $01
                            local3\Field1\Field15[local20] = createnpc($11, local3\Field1\Field3, (local3\Field1\Field4 + 11.0), local3\Field1\Field5)
                            local3\Field1\Field15[local20]\Field10 = (Float (n_i\Field3\Field65 = $00))
                        Next
                        For local20 = $00 To $01 Step $01
                            local3\Field1\Field15[local20] = createnpc($14, entityx(local3\Field1\Field11[(local20 + $05)], $01), entityy(local3\Field1\Field11[(local20 + $05)], $01), entityz(local3\Field1\Field11[(local20 + $05)], $01))
                            local3\Field1\Field15[local20]\Field10 = 0.0
                            pointentity(local3\Field1\Field15[local20]\Field3, local3\Field1\Field11[$03], 0.0)
                        Next
                        For local20 = $05 To $08 Step $01
                            local3\Field1\Field15[local20] = createnpc($15, (entityx(local3\Field1\Field11[(((local20 < $07) Shl $01) + local20)], $01) + ((Float (local20 > $06)) * 0.8)), entityy(local3\Field1\Field11[(((local20 < $07) Shl $01) + local20)], $01), (entityz(local3\Field1\Field11[(((local20 < $07) Shl $01) + local20)], $01) + ((Float (local20 > $06)) * 0.8)))
                            local3\Field1\Field15[local20]\Field36 = entityx(local3\Field1\Field2, $01)
                            local3\Field1\Field15[local20]\Field37 = entityy(local3\Field1\Field2, $01)
                            local3\Field1\Field15[local20]\Field38 = entityz(local3\Field1\Field2, $01)
                            local3\Field1\Field15[local20]\Field10 = 5.0
                        Next
                        If (n_i\Field3\Field65 <> 0) Then
                            local3\Field1\Field14[$00]\Field4 = $01
                            positionentity(local3\Field1\Field15[$05]\Field3, entityx(local3\Field1\Field11[$0F], $01), entityy(local3\Field1\Field11[$0F], $01), entityz(local3\Field1\Field11[$0F], $01), $01)
                            resetentity(local3\Field1\Field15[$05]\Field3)
                        EndIf
                        renderloading($1E, getlocalstring("loading", "ending"))
                        sky = createsky("GFX\Map\Textures\sky", $00)
                        rotateentity(sky, 0.0, (Float local3\Field1\Field6), 0.0, $00)
                        renderloading($3C, getlocalstring("loading", "ending"))
                        local3\Field1\Field11[$00] = loadrmesh("GFX\Map\gate_a_tunnel.rmesh", Null, $01)
                        positionentity(local3\Field1\Field11[$00], entityx(local3\Field1\Field2, $01), entityy(local3\Field1\Field2, $01), entityz(local3\Field1\Field2, $01), $00)
                        scaleentity(local3\Field1\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        entitytype(local3\Field1\Field11[$00], $01, $00)
                        entitypickmode(local3\Field1\Field11[$00], $02, $01)
                        entityparent(local3\Field1\Field11[$00], local3\Field1\Field2, $01)
                        local3\Field1\Field11[$09] = loadmesh_strict("GFX\Map\Props\lightgunbase.b3d", $00)
                        positionentity(local3\Field1\Field11[$09], (local3\Field1\Field3 + 11.13281), (local3\Field1\Field4 + 3.9375), (local3\Field1\Field5 + 24.05078), $00)
                        scaleentity(local3\Field1\Field11[$09], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        local3\Field1\Field11[$0A] = loadmesh_strict("GFX\Map\Props\lightgun.b3d", $00)
                        positionentity(local3\Field1\Field11[$0A], (local3\Field1\Field3 + 11.13281), (local3\Field1\Field4 + 5.0625), (local3\Field1\Field5 + 23.36328), $01)
                        scaleentity(local3\Field1\Field11[$0A], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        entityparent(local3\Field1\Field11[$0A], local3\Field1\Field11[$09], $01)
                        rotateentity(local3\Field1\Field11[$09], 0.0, 48.0, 0.0, $00)
                        rotateentity(local3\Field1\Field11[$0A], 40.0, 0.0, 0.0, $00)
                        renderloading($5A, getlocalstring("loading", "ending"))
                        resetentity(me\Field60)
                        rotateentity(me\Field60, 0.0, (entityyaw(me\Field60, $00) + ((Float local3\Field1\Field6) + 180.0)), 0.0, $00)
                        If (n_i\Field3\Field65 = $00) Then
                            playsound_strict(loadtempsound("SFX\Ending\GateA\106Escape.ogg"), $00)
                        EndIf
                        isblackout = $00
                        hidedistance = 68.0
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg(getlocalstring("misc", "warning2"), $FF, $00, $00, $00)
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        local3\Field2 = 1.0
                        renderloading($64, "")
                    Else
                        updatesky(sky)
                        showroomsnocoll(local3\Field1)
                        cansave = $01
                        shouldplay = $10
                        local3\Field2 = (local3\Field2 + fps\Field7[$00])
                        local37 = max(sin((entityyaw(me\Field60, $00) + 90.0)), 0.0)
                        For local20 = $02 To $04 Step $01
                            If (local3\Field1\Field15[local20] <> Null) Then
                                If (2.0 > local3\Field1\Field15[local20]\Field10) Then
                                    positionentity(local3\Field1\Field15[local20]\Field3, (((cos(((local3\Field2 / 10.0) + (120.0 * (Float local20)))) * 6000.0) * (1.0 / 256.0)) + entityx(local3\Field1\Field11[$03], $01)), (local3\Field1\Field4 + 11.0), (((sin(((local3\Field2 / 10.0) + (120.0 * (Float local20)))) * 6000.0) * (1.0 / 256.0)) + entityz(local3\Field1\Field11[$03], $01)), $00)
                                    rotateentity(local3\Field1\Field15[local20]\Field3, 7.0, ((local3\Field2 / 10.0) + (120.0 * (Float local20))), 20.0, $00)
                                EndIf
                            EndIf
                        Next
                        If (350.0 <= local3\Field2) Then
                            If (n_i\Field3\Field65 = $00) Then
                                If (350.0 > (local3\Field2 - fps\Field7[$00])) Then
                                    n_i\Field3\Field36 = entityx(local3\Field1\Field11[$03], $01)
                                    n_i\Field3\Field37 = entityy(local3\Field1\Field11[$03], $01)
                                    n_i\Field3\Field38 = entityz(local3\Field1\Field11[$03], $01)
                                    n_i\Field3\Field10 = 2.0
                                    rotateentity(n_i\Field3\Field3, 0.0, ((Float local3\Field1\Field6) + 90.0), 0.0, $00)
                                    playsound_strict(snd_i\Field47[$05], $00)
                                ElseIf (2.0 < n_i\Field3\Field10) Then
                                    If (3.0 = n_i\Field3\Field10) Then
                                        If (entityhidden(n_i\Field3\Field1) = $00) Then
                                            hideentity(n_i\Field3\Field1)
                                        EndIf
                                        n_i\Field3\Field41 = 7000.0
                                        If (n_i\Field3\Field40 <> $01) Then
                                            n_i\Field3\Field40 = findpath(n_i\Field3, entityx(local3\Field1\Field15[$05]\Field3, $01), entityy(local3\Field1\Field15[$05]\Field3, $01), entityz(local3\Field1\Field15[$05]\Field3, $01))
                                            n_i\Field3\Field42 = $01
                                        EndIf
                                        For local20 = $02 To $04 Step $01
                                            local3\Field1\Field15[local20]\Field36 = entityx(n_i\Field3\Field0, $01)
                                            local3\Field1\Field15[local20]\Field37 = (entityy(n_i\Field3\Field0, $01) + 5.0)
                                            local3\Field1\Field15[local20]\Field38 = entityz(n_i\Field3\Field0, $01)
                                            local3\Field1\Field15[local20]\Field10 = 3.0
                                        Next
                                        For local20 = $05 To $08 Step $01
                                            If (npcseesplayer(local3\Field1\Field15[local20], ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                                local3\Field1\Field15[local20]\Field10 = 6.0
                                            Else
                                                local3\Field1\Field15[local20]\Field36 = entityx(n_i\Field3\Field0, $01)
                                                local3\Field1\Field15[local20]\Field37 = (entityy(n_i\Field3\Field0, $01) + 0.4)
                                                local3\Field1\Field15[local20]\Field38 = entityz(n_i\Field3\Field0, $01)
                                                local3\Field1\Field15[local20]\Field10 = 5.0
                                            EndIf
                                        Next
                                        local25 = createpivot($00)
                                        positionentity(local25, entityx(local3\Field1\Field11[$0A], $01), entityy(local3\Field1\Field11[$0A], $01), entityz(local3\Field1\Field11[$0A], $01), $00)
                                        pointentity(local25, n_i\Field3\Field3, 0.0)
                                        rotateentity(local3\Field1\Field11[$09], 0.0, curveangle(entityyaw(local25, $00), entityyaw(local3\Field1\Field11[$09], $01), 150.0), 0.0, $01)
                                        rotateentity(local3\Field1\Field11[$0A], curveangle(entitypitch(local25, $00), entitypitch(local3\Field1\Field11[$0A], $01), 200.0), entityyaw(local3\Field1\Field11[$09], $01), 0.0, $01)
                                        freeentity(local25)
                                        local25 = $00
                                    EndIf
                                    local38 = distancesquared(entityx(n_i\Field3\Field3, $00), entityx(local3\Field1\Field11[$04], $01), entityz(n_i\Field3\Field3, $00), entityz(local3\Field1\Field11[$04], $01), 0.0, 0.0)
                                    n_i\Field3\Field24 = curvevalue(0.0, n_i\Field3\Field24, max((5.0 * sqr(local38)), 2.0))
                                    If (225.0 > local38) Then
                                        If (local3\Field7 = $00) Then
                                            local3\Field7 = playsound_strict(loadtempsound("SFX\Ending\GateA\Franklin.ogg"), $01)
                                        EndIf
                                        If (0.16 > local38) Then
                                            n_i\Field3\Field10 = 4.0
                                            If (151.0 >= n_i\Field3\Field14) Then
                                                local3\Field3 = 0.0
                                                For local20 = $02 To $04 Step $01
                                                    local3\Field1\Field15[local20]\Field10 = 2.0
                                                Next
                                                For local20 = $05 To $08 Step $01
                                                    local3\Field1\Field15[local20]\Field23 = (local3\Field1\Field15[local20]\Field23 * rnd(1.0, 1.3))
                                                    local3\Field1\Field15[local20]\Field10 = 1.0
                                                    local3\Field1\Field15[local20]\Field11 = 252000.0
                                                Next
                                            EndIf
                                        ElseIf (72.25 > local38) Then
                                            If (0.0 = local3\Field3) Then
                                                local3\Field7 = playsound_strict(loadtempsound("SFX\Ending\GateA\HIDTurret.ogg"), $00)
                                                local3\Field3 = 1.0
                                            ElseIf (0.0 < local3\Field3) Then
                                                local3\Field3 = (local3\Field3 + fps\Field7[$00])
                                                If (525.0 <= local3\Field3) Then
                                                    If (525.0 > (local3\Field3 - fps\Field7[$00])) Then
                                                        local0 = createparticle($05, entityx(n_i\Field3\Field0, $01), (entityy(n_i\Field3\Field0, $01) + 0.4), entityz(n_i\Field3\Field0, $01), 7.0, 0.0, 470.0)
                                                        local0\Field4 = 0.0
                                                        local0\Field2 = 1.0
                                                        entityparent(local0\Field1, n_i\Field3\Field3, $01)
                                                        local0 = createparticle($05, entityx(local3\Field1\Field11[$0A], $01), entityy(local3\Field1\Field11[$0A], $01), entityz(local3\Field1\Field11[$0A], $01), 2.0, 0.0, 470.0)
                                                        local0\Field4 = 0.0
                                                        local0\Field2 = 1.0
                                                        rotateentity(local0\Field1, entitypitch(local3\Field1\Field11[$0A], $01), entityyaw(local3\Field1\Field11[$0A], $01), 0.0, $01)
                                                        moveentity(local0\Field1, 0.0, 0.359375, 2.0)
                                                        entityparent(local0\Field1, local3\Field1\Field11[$0A], $01)
                                                    ElseIf (1036.0 > local3\Field3) Then
                                                        me\Field23 = 0.5
                                                        me\Field51 = (((Float entityinview(local3\Field1\Field11[$0A], camera)) * 0.5) + 0.3)
                                                        lightvolume = (rnd(1.0, 2.0) * templightvolume)
                                                        If (((Int me\Field0) Lor chs\Field0) = $00) Then
                                                            If (1.44 > entitydistancesquared(event_getmypivot(), n_i\Field3\Field3)) Then
                                                                playsound_strict(loadtempsound("SFX\SCP\294\Burn.ogg"), $00)
                                                                kill($01, $01, $00, $01)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (opt\Field0 > $00) Then
                                                For local20 = $00 To (rand($02, (((opt\Field0 - $01) * $06) + $02)) - (Int sqr(local38))) Step $01
                                                    local0 = createparticle($00, entityx(n_i\Field3\Field0, $01), (entityy(n_i\Field3\Field0, $01) + rnd(0.4, 0.9)), entityz(n_i\Field3\Field0, $00), 0.006, -0.002, 40.0)
                                                    local0\Field4 = 0.005
                                                    local0\Field2 = 0.8
                                                    local0\Field10 = -0.01
                                                    rotateentity(local0\Field1, (- rnd(70.0, 110.0)), rnd(360.0, 0.0), 0.0, $00)
                                                Next
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                                If (local3\Field1\Field15[$05]\Field17 = $00) Then
                                    If (1.0 > (Abs (entityy(me\Field60, $00) - entityy(local3\Field1\Field11[$0B], $01)))) Then
                                        If (144.0 > distancesquared(entityx(me\Field60, $00), entityx(local3\Field1\Field11[$0B], $01), entityz(me\Field60, $00), entityz(local3\Field1\Field11[$0B], $01), 0.0, 0.0)) Then
                                            n_i\Field3\Field10 = 0.0
                                            n_i\Field3\Field11 = rnd(22000.0, 27000.0)
                                            If (entityhidden(n_i\Field3\Field0) = $00) Then
                                                hideentity(n_i\Field3\Field0)
                                            EndIf
                                            For local20 = $05 To $08 Step $01
                                                positionentity(local3\Field1\Field15[local20]\Field3, (entityx(local3\Field1\Field11[$0F], $01) + ((Float (local20 - $06)) * 0.3)), entityy(local3\Field1\Field11[$0F], $01), (entityz(local3\Field1\Field11[$0F], $01) + ((Float (local20 - $06)) * 0.3)), $01)
                                                resetentity(local3\Field1\Field15[local20]\Field3)
                                                local3\Field1\Field15[local20]\Field36 = entityx(me\Field60, $00)
                                                local3\Field1\Field15[local20]\Field37 = entityy(me\Field60, $00)
                                                local3\Field1\Field15[local20]\Field38 = entityz(me\Field60, $00)
                                                local3\Field1\Field15[local20]\Field41 = 0.0
                                                local3\Field1\Field15[local20]\Field10 = 3.0
                                            Next
                                            local3\Field1\Field15[$05]\Field17 = loadsound_strict("SFX\Character\MTF\ThereHeIs0.ogg")
                                            playsoundex(local3\Field1\Field15[$05]\Field17, camera, local3\Field1\Field15[$05]\Field3, 25.0, 1.0, $01, $00)
                                            local3\Field1\Field14[$00]\Field6 = $01
                                            For local20 = $02 To $04 Step $01
                                                local3\Field1\Field15[local20]\Field10 = 0.0
                                            Next
                                        EndIf
                                    EndIf
                                ElseIf (local3\Field1\Field11[$0C] = $00) Then
                                    For local20 = $05 To $08 Step $01
                                        If (16.0 < entitydistancesquared(local3\Field1\Field15[local20]\Field3, me\Field60)) Then
                                            local3\Field1\Field15[local20]\Field10 = 3.0
                                        Else
                                            local3\Field1\Field15[local20]\Field10 = 6.0
                                        EndIf
                                    Next
                                    If (1.0 > (Abs (entityy(me\Field60, $00) - entityy(local3\Field1\Field11[$0B], $01)))) Then
                                        If (49.0 > distancesquared(entityx(me\Field60, $00), entityx(local3\Field1\Field11[$0B], $01), entityz(me\Field60, $00), entityz(local3\Field1\Field11[$0B], $01), 0.0, 0.0)) Then
                                            For local20 = $05 To $08 Step $01
                                                local3\Field1\Field15[local20]\Field10 = 5.0
                                            Next
                                            local3\Field1\Field11[$0C] = loadanimmesh_strict("GFX\NPCs\CI.b3d", $00)
                                            local128 = (0.55 / meshwidth(local3\Field1\Field11[$0C]))
                                            scaleentity(local3\Field1\Field11[$0C], local128, local128, local128, $00)
                                            positionentity(local3\Field1\Field11[$0C], entityx(local3\Field1\Field11[$0B], $01), entityy(local3\Field1\Field11[$0B], $01), entityz(local3\Field1\Field11[$0B], $01), $00)
                                            local3\Field1\Field11[$11] = copyentity(local3\Field1\Field11[$0C], $00)
                                            positionentity(local3\Field1\Field11[$11], (entityx(local3\Field1\Field2, $01) - 15.5), entityy(local3\Field1\Field11[$0B], $01), (entityz(local3\Field1\Field2, $01) - 7.5), $00)
                                            local129 = copyentity(local3\Field1\Field11[$0C], $00)
                                            positionentity(local129, (entityx(local3\Field1\Field2, $01) - 16.25), entityy(local3\Field1\Field11[$0B], $01), (entityz(local3\Field1\Field2, $01) - 7.5), $00)
                                            entityparent(local129, local3\Field1\Field11[$11], $01)
                                            local129 = copyentity(local3\Field1\Field11[$0C], $00)
                                            positionentity(local129, (entityx(local3\Field1\Field2, $01) - 15.875), entityy(local3\Field1\Field11[$0B], $01), (entityz(local3\Field1\Field2, $01) - 8.25), $00)
                                            entityparent(local129, local3\Field1\Field11[$11], $01)
                                            local3\Field6 = playsoundex(loadtempsound("SFX\Ending\GateA\Bell0.ogg"), camera, local3\Field1\Field11[$0C], 10.0, 1.0, $00, $00)
                                            local0 = createparticle($05, entityx(local3\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local3\Field1\Field11[$0B], $01), 8.0, 0.0, 50.0)
                                            local0\Field4 = 0.15
                                            local0\Field2 = 0.5
                                            local0 = createparticle($05, entityx(local3\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local3\Field1\Field11[$0B], $01), 8.0, 0.0, 50.0)
                                            local0\Field4 = 0.25
                                            local0\Field2 = 0.5
                                            pointentity(local0\Field1, me\Field60, 0.0)
                                            me\Field23 = 1.0
                                            me\Field51 = 1.0
                                            local3\Field4 = 2.0
                                        EndIf
                                    EndIf
                                Else
                                    local3\Field4 = (local3\Field4 + fps\Field7[$00])
                                    pointentity(local3\Field1\Field11[$0C], me\Field60, 0.0)
                                    rotateentity(local3\Field1\Field11[$0C], 0.0, entityyaw(local3\Field1\Field11[$0C], $00), 0.0, $00)
                                    me\Field17 = -5.0
                                    me\Field49 = (sin((local3\Field4 * 0.7)) * 1000.0)
                                    If (0.0 = me\Field0) Then
                                        camerazoom(camera, ((sin((local3\Field4 * 0.8)) * 0.2) + 1.0))
                                        local38 = entitydistancesquared(me\Field60, local3\Field1\Field11[$0B])
                                        If (42.25 > local38) Then
                                            local47 = (sqr(local38) * 80.0)
                                            positionentity(me\Field60, curvevalue(entityx(local3\Field1\Field11[$0B], $01), entityx(me\Field60, $00), local38), entityy(me\Field60, $00), curvevalue(entityz(local3\Field1\Field11[$00], $01), entityz(me\Field60, $00), local38), $00)
                                        EndIf
                                    EndIf
                                    If (((50.0 < local3\Field4) And (230.0 > local3\Field4)) <> 0) Then
                                        local45 = sin((local3\Field4 - 50.0))
                                        me\Field23 = (local45 * 3.0)
                                        turnentity(local3\Field1\Field11[$0D], 0.0, ((local45 * -0.85) * fps\Field7[$00]), 0.0, $01)
                                        turnentity(local3\Field1\Field11[$0E], 0.0, ((local45 * 0.85) * fps\Field7[$00]), 0.0, $01)
                                    EndIf
                                    If (230.0 <= local3\Field4) Then
                                        local3\Field22 = $01
                                        If (230.0 > (local3\Field4 - fps\Field7[$00])) Then
                                            local3\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateA\CI.ogg"), $01)
                                            me\Field43 = $00
                                        EndIf
                                        If (480.0 <= local3\Field4) Then
                                            animateex(local3\Field1\Field11[$0C], animtime(local3\Field1\Field11[$0C]), $B0, $D2, 0.2, $01)
                                            moveentity(local3\Field1\Field11[$0C], 0.0, 0.0, (fps\Field7[$00] * 0.01))
                                        EndIf
                                        If (channelplaying(local3\Field6) = $00) Then
                                            clearcheats()
                                            playsound_strict(loadtempsound("SFX\Ending\GateA\Bell1.ogg"), $00)
                                            local0 = createparticle($05, entityx(local3\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local3\Field1\Field11[$0B], $01), 8.0, 0.0, 50.0)
                                            local0\Field4 = 0.15
                                            local0\Field2 = 0.5
                                            local0 = createparticle($05, entityx(local3\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local3\Field1\Field11[$0B], $01), 8.0, 0.0, 50.0)
                                            local0\Field4 = 0.25
                                            local0\Field2 = 0.5
                                            me\Field23 = curvevalue(2.0, me\Field23, 10.0)
                                            me\Field51 = curvevalue(2.0, me\Field51, 8.0)
                                            me\Field0 = 1.0
                                            msg\Field2 = ""
                                            removeevent(local3)
                                            Return $00
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (0.0 = local3\Field3) Then
                                For local20 = $02 To $04 Step $01
                                    local3\Field1\Field15[local20]\Field10 = 0.0
                                Next
                                For local20 = $05 To $08 Step $01
                                    local3\Field1\Field15[local20]\Field36 = entityx(me\Field60, $00)
                                    local3\Field1\Field15[local20]\Field37 = entityy(me\Field60, $00)
                                    local3\Field1\Field15[local20]\Field38 = entityz(me\Field60, $00)
                                    local3\Field1\Field15[local20]\Field10 = 3.0
                                Next
                                local3\Field3 = 1.0
                            Else
                                For local20 = $05 To $08 Step $01
                                    local3\Field1\Field15[local20]\Field36 = entityx(me\Field60, $00)
                                    local3\Field1\Field15[local20]\Field37 = entityy(me\Field60, $00)
                                    local3\Field1\Field15[local20]\Field38 = entityz(me\Field60, $00)
                                Next
                                If (1.0 = local3\Field3) Then
                                    For local20 = $05 To $08 Step $01
                                        If (npcseesplayer(local3\Field1\Field15[local20], ((4.0 - me\Field40) + me\Field42), 60.0, $00) = $01) Then
                                            local23 = $01
                                            Exit
                                        EndIf
                                    Next
                                    If (local23 <> 0) Then
                                        local3\Field22 = $01
                                        For local20 = $05 To $08 Step $01
                                            local3\Field1\Field15[local20]\Field10 = 5.0
                                        Next
                                        local3\Field3 = 2.0
                                    EndIf
                                ElseIf (2.0 = local3\Field3) Then
                                    makemeunplayable()
                                    me\Field43 = $01
                                    local3\Field6 = playsound_strict(loadtempsound("SFX\Ending\GateA\STOPRIGHTTHERE.ogg"), $01)
                                    local3\Field3 = 3.0
                                ElseIf (3.0 = local3\Field3) Then
                                    shouldplay = $00
                                    me\Field38 = 0.0
                                    If (channelplaying(local3\Field6) = $00) Then
                                        clearcheats()
                                        playsound_strict(loadtempsound("SFX\Room\Intro\Bang2.ogg"), $00)
                                        me\Field51 = 1.0
                                        me\Field0 = 1.0
                                        msg\Field2 = ""
                                        me\Field10 = -10.0
                                        removeevent(local3)
                                        Return $00
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideroomsnocoll(local3\Field1)
                EndIf
        End Select
        If (local3 <> Null) Then
            mp_prepareeventnpcs(local3)
            catcherrors((("Uncaught: MP_UpdateEvents(Event ID: " + (Str local3\Field0)) + ")"))
        Else
            catcherrors("Uncaught: MP_UpdateEvents(Event doesn't exist anymore!)")
        EndIf
    Next
    me\Field60 = getrealcollider()
    playerroom = event_prevplayerroom
    i_268\Field2 = local49
    updateexplosion()
    Return $00
End Function
