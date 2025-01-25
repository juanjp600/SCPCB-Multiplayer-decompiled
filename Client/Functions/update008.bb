Function update008%()
    Local local0.rooms
    Local local1%
    Local local2.decals
    Local local3#
    Local local4%
    Local local5%
    Local local6#
    local5 = (playerinreachableroom($00, $00) * (mp_getsocket() = $00))
    If (0.0 < i_008\Field0) Then
        If (entityhidden(t\Field3[$03]) <> 0) Then
            showentity(t\Field3[$03])
        EndIf
        local6 = (sin(((Float millisec) / 8.0)) + 2.0)
        If (93.0 > i_008\Field0) Then
            local3 = i_008\Field0
            If (25200.0 > i_427\Field1) Then
                If (i_008\Field1 <> 0) Then
                    i_008\Field0 = max((i_008\Field0 - (fps\Field7[$00] * 0.02)), 0.0)
                ElseIf (i_427\Field0 = $00) Then
                    i_008\Field0 = min((i_008\Field0 + (fps\Field7[$00] * 0.002)), 100.0)
                    me\Field49 = max(((i_008\Field0 * 3.0) * (2.0 - me\Field40)), me\Field49)
                    me\Field28 = max(me\Field28, 100.0)
                    me\Field30 = max(me\Field30, (i_008\Field0 / 120.0))
                EndIf
            EndIf
            entityalpha(t\Field3[$03], (min((((i_008\Field0 * 0.2) * (i_008\Field0 * 0.2)) / 1000.0), 0.5) * local6))
            For local4 = $00 To $06 Step $01
                If ((((((Float local4) * 15.0) + 10.0) < i_008\Field0) And (local3 <= (((Float local4) * 15.0) + 10.0))) <> 0) Then
                    If (i_008\Field1 = $00) Then
                        playsound_strict(loadtempsound((("SFX\SCP\008\Voices" + (Str local4)) + ".ogg")), $01)
                    EndIf
                EndIf
            Next
            If (i_008\Field1 <> 0) Then
                If (((20.0 >= i_008\Field0) And (20.0 < local3)) <> 0) Then
                    createmsg(getlocalstring("msg", "better_2"), 6.0)
                ElseIf (((40.0 >= i_008\Field0) And (40.0 < local3)) <> 0) Then
                    createmsg(getlocalstring("msg", "nauseafading"), 6.0)
                ElseIf (((60.0 >= i_008\Field0) And (60.0 < local3)) <> 0) Then
                    createmsg(getlocalstring("msg", "headachefading"), 6.0)
                ElseIf (((80.0 >= i_008\Field0) And (80.0 < local3)) <> 0) Then
                    createmsg(getlocalstring("msg", "moreener"), 6.0)
                EndIf
            ElseIf (((20.0 < i_008\Field0) And (20.0 >= local3)) <> 0) Then
                createmsg(getlocalstring("msg", "feverish"), 6.0)
            ElseIf (((40.0 < i_008\Field0) And (40.0 >= local3)) <> 0) Then
                createmsg(getlocalstring("msg", "nausea"), 6.0)
            ElseIf (((60.0 < i_008\Field0) And (60.0 >= local3)) <> 0) Then
                createmsg(getlocalstring("msg", "nauseaworse"), 6.0)
            ElseIf (((80.0 < i_008\Field0) And (80.0 >= local3)) <> 0) Then
                createmsg(getlocalstring("msg", "faint"), 6.0)
            ElseIf (91.5 <= i_008\Field0) Then
                If (91.5 > local3) Then
                    playsound_strict(loadtempsound("SFX\Character\D9341\Infected.ogg"), $01)
                EndIf
                me\Field10 = clamp(((i_008\Field0 - 91.5) * -10.0), me\Field10, -10.0)
                makemeunplayable()
                If (((92.7 <= i_008\Field0) And (92.7 > local3)) <> 0) Then
                    If (local5 <> 0) Then
                        If (mp_getsocket() <> $00) Then
                            me\Field9 = $01
                            kill($00, $01, $00, $01)
                            i_008\Field0 = 0.0
                        Else
                            me\Field56 = $01
                            msg\Field2 = format(getlocalstring("death", "0081"), subjectname, "%s")
                            If (selecteddifficulty\Field3 >= $02) Then
                                deletegame(currsave)
                                gamesaved = $00
                                loadsavedgames()
                            EndIf
                            For local0 = Each rooms
                                If (local0\Field7\Field6 = $39) Then
                                    positionentity(me\Field60, entityx(local0\Field11[$07], $01), entityy(local0\Field11[$07], $01), entityz(local0\Field11[$07], $01), $01)
                                    resetentity(me\Field60)
                                    local0\Field15[$00] = createnpc($13, entityx(local0\Field11[$06], $01), (entityy(local0\Field11[$06], $01) + 0.2), entityz(local0\Field11[$06], $01))
                                    local0\Field15[$00]\Field10 = -1.0
                                    setnpcframe(local0\Field15[$00], 357.0, $01)
                                    changenpctextureid(local0\Field15[$00], $0B)
                                    playsound_strict(loadtempsound("SFX\SCP\008\KillScientist0.ogg"), $01)
                                    teleporttoroom(local0)
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                EndIf
            EndIf
        Else
            local3 = i_008\Field0
            i_008\Field0 = min((i_008\Field0 + (fps\Field7[$00] * 0.004)), 100.0)
            If ((local5 And (playerroom\Field15[$00] <> Null)) <> 0) Then
                If (94.7 > i_008\Field0) Then
                    entityalpha(t\Field3[$03], (0.5 * local6))
                    me\Field49 = 900.0
                    If (94.5 < i_008\Field0) Then
                        me\Field10 = clamp(((i_008\Field0 - 94.5) * -50.0), me\Field10, -10.0)
                    EndIf
                    pointentity(me\Field60, playerroom\Field15[$00]\Field3, 0.0)
                    pointentity(playerroom\Field15[$00]\Field3, me\Field60, 0.0)
                    pointentity(camera, playerroom\Field15[$00]\Field3, entityroll(camera, $00))
                    me\Field7 = 0.75
                    me\Field31 = 2.5
                    me\Field32 = 0.0
                    me\Field9 = $01
                    animatenpc(playerroom\Field15[$00], 357.0, 381.0, 0.3, $01)
                ElseIf (98.5 > i_008\Field0) Then
                    entityalpha(t\Field3[$03], (0.5 * local6))
                    me\Field49 = 950.0
                    me\Field7 = 0.0
                    pointentity(camera, playerroom\Field15[$00]\Field3, 0.0)
                    If (94.7 > local3) Then
                        playerroom\Field15[$00]\Field12 = -1.0
                        playerroom\Field15[$00]\Field50 = $01
                        setnpcframe(playerroom\Field15[$00], 19.0, $01)
                        playsound_strict(loadtempsound("SFX\SCP\008\KillScientist1.ogg"), $01)
                        msg\Field2 = format(getlocalstring("death", "0081"), subjectname, "%s")
                        local2 = createdecal($03, entityx(playerroom\Field15[$00]\Field3, $00), ((playerroom\Field4 + 2.125) + 0.01), entityz(playerroom\Field15[$00]\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, 0.8, 1.0, $00, $01, $00, $00, $00)
                        entityparent(local2\Field0, playerroom\Field2, $01)
                        kill($00, $01, $00, $01)
                    ElseIf (96.0 < i_008\Field0) Then
                        me\Field10 = clamp(((i_008\Field0 - 96.0) * -10.0), me\Field10, -10.0)
                    Else
                        me\Field0 = 1.0
                    EndIf
                    If (opt\Field0 > $00) Then
                        If (rand($19, $01) = $01) Then
                            setemitter(Null, entityx(playerroom\Field15[$00]\Field3, $00), entityy(playerroom\Field15[$00]\Field3, $00), entityz(playerroom\Field15[$00]\Field3, $00), $0F)
                        EndIf
                    EndIf
                    positionentity(me\Field61, entityx(playerroom\Field15[$00]\Field3, $01), (entityy(playerroom\Field15[$00]\Field3, $01) + 0.65), entityz(playerroom\Field15[$00]\Field3, $01), $01)
                    local6 = sin(((Float millisec) / 5.0))
                    rotateentity(me\Field61, ((1.0 + local6) * 15.0), ((Float playerroom\Field6) - 180.0), 0.0, $01)
                    moveentity(me\Field61, 0.0, 0.0, -0.4)
                    turnentity(me\Field61, ((local6 * 30.0) + 80.0), (local6 * 40.0), 0.0, $00)
                EndIf
            Else
                me\Field10 = clamp(((i_008\Field0 - 96.0) * -10.0), me\Field10, -10.0)
                If (playerroom\Field7\Field6 = $6A) Then
                    msg\Field2 = getlocalstring("death", "14991")
                ElseIf (isplayeroutsidefacility() <> 0) Then
                    msg\Field2 = format(getlocalstring("death", "008gate"), subjectname, "{0}")
                    If (playerroom\Field7\Field6 = $47) Then
                        msg\Field2 = format(msg\Field2, "A", "{1}")
                    Else
                        msg\Field2 = format(msg\Field2, "B", "{1}")
                    EndIf
                Else
                    msg\Field2 = ""
                EndIf
                kill($00, $01, $00, $01)
            EndIf
        EndIf
    Else
        i_008\Field1 = $00
        If (entityhidden(t\Field3[$03]) = $00) Then
            hideentity(t\Field3[$03])
        EndIf
    EndIf
    Return $00
End Function
