Function updategame%()
    Local local0%
    Local local1.events
    Local local2%
    Local local3%
    Local local4$
    Local local6#
    seterrormsg($09, ("Room ID: " + (Str playerroom\Field7\Field6)))
    For local1 = Each events
        If (local1\Field1 = playerroom) Then
            seterrormsg($0A, ((((((((("Event ID: " + (Str local1\Field0)) + "; State: ") + (Str local1\Field2)) + ", ") + (Str local1\Field3)) + ", ") + (Str local1\Field4)) + ", ") + (Str local1\Field5)))
            Exit
        EndIf
    Next
    catcherrors("UpdateGame()")
    While (0.0 < fps\Field0)
        fps\Field0 = (fps\Field0 - 1.166667)
        If (0.0 >= fps\Field0) Then
            captureworld()
        EndIf
        If (((menuopen Lor consoleopen) And (mp_getsocket() = $00)) <> 0) Then
            fps\Field7[$00] = 0.0
        EndIf
        updatemouseinput()
        handentity = $00
        If (((mo\Field2 = $00) And (mo\Field0 = $00)) <> 0) Then
            grabbedentity = $00
        EndIf
        If (shoulddeletegadgets <> 0) Then
            deletemenugadgets()
        EndIf
        shoulddeletegadgets = $00
        If (((((menuopen Lor consoleopen) Lor (0.0 > me\Field45)) = $00) Lor ((mp_getsocket() <> $00) And (0.0 <= me\Field45))) <> 0) Then
            updatemusic()
            If (opt\Field22 <> 0) Then
                autoreleasesounds()
            EndIf
            updatestreamsounds()
            For local3 = $00 To $03 Step $01
                drawarrowicon[local3] = $00
            Next
            me\Field6 = $01
            shouldentitiesfall = $01
            If ((((playerroom\Field7\Field6 <> $69) And (playerroom\Field7\Field6 <> $6A)) And (isplayeroutsidefacility() = $00)) <> 0) Then
                If (rand($5DC, $01) = $01) Then
                    For local3 = $00 To $05 Step $01
                        If (ambientsfx(local3, currambientsfx) <> $00) Then
                            If (channelplaying(ambientsfxchn) = $00) Then
                                freesound_strict(ambientsfx(local3, currambientsfx))
                                ambientsfx(local3, currambientsfx) = $00
                            EndIf
                        EndIf
                    Next
                    positionentity(soundemitter, (entityx(camera, $00) + rnd(-1.0, 1.0)), 0.0, (entityz(camera, $00) + rnd(-1.0, 1.0)), $00)
                    If (rand($03, $01) = $01) Then
                        me\Field59 = $03
                    EndIf
                    If (playerroom\Field7\Field6 = $04) Then
                        me\Field59 = $04
                    ElseIf (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
                        If (20.0 < entityy(me\Field60, $00)) Then
                            me\Field59 = $05
                            positionentity(soundemitter, entityx(soundemitter, $00), 30.0, entityz(soundemitter, $00), $00)
                        EndIf
                    EndIf
                    currambientsfx = rand($00, (ambientsfxamount[me\Field59] - $01))
                    Select me\Field59
                        Case $00,$01,$02
                            If (ambientsfx(me\Field59, currambientsfx) = $00) Then
                                ambientsfx(me\Field59, currambientsfx) = loadsound_strict((((("SFX\Ambient\Zone" + (Str (me\Field59 + $01))) + "\Ambient") + (Str currambientsfx)) + ".ogg"))
                            EndIf
                        Case $03
                            If (ambientsfx(me\Field59, currambientsfx) = $00) Then
                                ambientsfx(me\Field59, currambientsfx) = loadsound_strict((("SFX\Ambient\General\Ambient" + (Str currambientsfx)) + ".ogg"))
                            EndIf
                        Case $04
                            If (ambientsfx(me\Field59, currambientsfx) = $00) Then
                                ambientsfx(me\Field59, currambientsfx) = loadsound_strict((("SFX\Ambient\Pre-breach\Ambient" + (Str currambientsfx)) + ".ogg"))
                            EndIf
                        Case $05
                            If (ambientsfx(me\Field59, currambientsfx) = $00) Then
                                ambientsfx(me\Field59, currambientsfx) = loadsound_strict((("SFX\Ambient\Forest\Ambient" + (Str currambientsfx)) + ".ogg"))
                            EndIf
                    End Select
                    ambientsfxchn = playsoundex(ambientsfx(me\Field59, currambientsfx), camera, soundemitter, 10.0, 1.0, $00, $00)
                EndIf
                updatesoundorigin(ambientsfxchn, camera, soundemitter, 10.0, 1.0, $00, $01)
                If (playerinreachableroom($01, $00) <> 0) Then
                    shouldplay = (Int min((Float me\Field59), 2.0))
                    If (rand($C350, $01) = $03) Then
                        me\Field50 = rnd(1.0, 2.0)
                        playsound_strict(loadtempsound((("SFX\SCP\079\Broadcast" + (Str rand($00, $07))) + ".ogg")), $01)
                    EndIf
                EndIf
            EndIf
            me\Field42 = curvevalue(0.0, me\Field42, 50.0)
            infacility = isinfacility(entityy(me\Field60, $00))
            If (isplayeroutsidefacility() = $00) Then
                hidedistance = 17.0
            EndIf
            If (mp_getsocket() <> $00) Then
                updateplayerspivot()
                mp_clearmyplayerdata()
                mp_updateroomobjects()
            EndIf
            updatedeaf()
            updatedecals()
            updatesavestate()
            updatemouselook()
            updatemoving()
            updatevomit()
            updateescapetimer()
            decalstep = $00
            updatedevilparticlestimer = min(1.0, (fps\Field7[$00] + updatedevilparticlestimer))
            If (1.0 = updatedevilparticlestimer) Then
                updateparticles_devil()
                updatedevilparticlestimer = 0.0
            EndIf
            If (playerroom\Field7\Field6 = $6A) Then
                If (((quickloadpercent > $00) And (quickloadpercent < $64)) <> 0) Then
                    shouldentitiesfall = $00
                EndIf
                If (((quickloadpercent = $FFFFFFFF) Lor (quickloadpercent = $64)) <> 0) Then
                    updatedimension1499()
                EndIf
                updateleave1499()
            ElseIf (playerroom\Field7\Field6 = $69) Then
                updatesoundemitters()
                If (((quickloadpercent = $FFFFFFFF) Lor (quickloadpercent = $64)) <> 0) Then
                    updatedimension106()
                EndIf
            Else
                updatelightvolume()
                updatelights(camera)
                updatesecuritycams()
                updatescreens()
                updatesoundemitters()
            EndIf
            updatedoors()
            If (mp_getsocket() = $00) Then
                If (playerroom\Field7\Field6 = $04) Then
                    updateintro()
                ElseIf (isplayeroutsidefacility() <> 0) Then
                    lightrenderdistance = 100.0
                    If (((quickloadpercent = $FFFFFFFF) Lor (quickloadpercent = $64)) <> 0) Then
                        updateendings()
                    EndIf
                Else
                    lightrenderdistance = 49.0
                    If (((playerroom\Field7\Field6 <> $6A) And (playerroom\Field7\Field6 <> $69)) <> 0) Then
                        updaterooms()
                    EndIf
                    If (((quickloadpercent = $FFFFFFFF) Lor (quickloadpercent = $64)) <> 0) Then
                        updateevents()
                    EndIf
                EndIf
            Else
                lightrenderdistance = (100.0 - (Float ((isplayeroutsidefacility() = $00) * $33)))
                If (((playerroom\Field7\Field6 <> $6A) And (playerroom\Field7\Field6 <> $69)) <> 0) Then
                    updaterooms()
                Else
                    mp_updateplayerrooms()
                EndIf
                mp_updateevents()
            EndIf
            timecheckpointmonitors()
            updatemonitorsaving()
            updatezonecolor()
            updatemtf()
            updatenpcs()
            updateitems()
            updateparticles()
            update268()
            update427()
            update1025()
            refillcup()
            me\Field48 = min(curvevalue(0.0, me\Field48, 20.0), 0.95)
            If (0.0 < me\Field49) Then
                me\Field48 = clamp((me\Field49 / 1000.0), me\Field48, 0.95)
                me\Field49 = max((me\Field49 - fps\Field7[$00]), 0.0)
            EndIf
            local6 = 0.0
            If (0.0 > me\Field5) Then
                If (me\Field6 <> 0) Then
                    me\Field5 = min((me\Field5 + fps\Field7[$00]), 0.0)
                EndIf
                If (-200.0 > me\Field5) Then
                    local6 = clamp((((- me\Field5) - 200.0) / 700.0), local6, 0.6)
                    If (0.0 = me\Field0) Then
                        me\Field30 = min(((Abs (me\Field5 + 20.0)) / 500.0), 1.0)
                        me\Field28 = max((((Abs (me\Field5 + 200.0)) / 6.0) + 70.0), me\Field28)
                    EndIf
                EndIf
            EndIf
            If (0.0 > me\Field10) Then
                If (-5.0 < me\Field10) Then
                    local6 = max(local6, sin((Abs (me\Field10 * 18.0))))
                ElseIf (-15.0 < me\Field10) Then
                    local6 = 1.0
                Else
                    local6 = max(local6, (Abs sin((me\Field10 * 18.0))))
                EndIf
                If (-20.0 >= me\Field10) Then
                    me\Field16 = 35.0
                    Select selecteddifficulty\Field4
                        Case $00
                            me\Field11 = rnd(840.0, 980.0)
                        Case $01
                            me\Field11 = rnd(700.0, 840.0)
                        Case $02
                            me\Field11 = rnd(560.0, 700.0)
                        Case $03
                            me\Field11 = rnd(420.0, 560.0)
                    End Select
                    me\Field10 = me\Field11
                    If (((playerroom\Field7\Field6 = $1F) And (infacility = $FFFFFFFF)) = $00) Then
                        me\Field49 = max((me\Field49 - rnd(50.0, 150.0)), 0.0)
                    EndIf
                EndIf
                me\Field10 = (me\Field10 - fps\Field7[$00])
            Else
                me\Field10 = (me\Field10 - ((fps\Field7[$00] * ((i_966\Field1 * 0.5) + 1.0)) * me\Field12))
                If (0.0 < me\Field14) Then
                    If (((wi\Field5 = $00) And (wi\Field9 = $00)) <> 0) Then
                        me\Field10 = (me\Field10 - (min(((me\Field14 / 70.0) + 1.0), 5.0) * fps\Field7[$00]))
                    EndIf
                EndIf
            EndIf
            me\Field16 = max((me\Field16 - fps\Field7[$00]), 0.0)
            me\Field14 = max(0.0, (me\Field14 - fps\Field7[$00]))
            If (0.0 < me\Field13) Then
                me\Field13 = (me\Field13 - (fps\Field7[$00] / 70.0))
            Else
                me\Field12 = 1.0
            EndIf
            me\Field50 = max((me\Field50 - (fps\Field7[$00] / 35.0)), 0.0)
            If ((isblackout Lor (0.0 < me\Field50)) <> 0) Then
                secondarylighton = curvevalue(0.0, (secondarylighton * lightvolume), 10.0)
            Else
                secondarylighton = curvevalue(1.0, (secondarylighton * lightvolume), 10.0)
            EndIf
            If (i_294\Field0 <> 0) Then
                local6 = 1.0
            EndIf
            If (wi\Field5 = $00) Then
                local6 = max(((1.0 - secondarylighton) * 0.9), local6)
            EndIf
            If ((Int me\Field0) <> 0) Then
                me\Field41 = curvevalue(0.0, me\Field41, 6.0)
                resetselectedstuff()
                me\Field49 = (me\Field2 * 5.0)
                If (me\Field43 <> $FFFFFFFF) Then
                    menuopen = $01
                    me\Field45 = ((- me\Field0) * 0.1)
                Else
                    me\Field2 = (me\Field2 + fps\Field7[$00])
                    If (((400.0 <= me\Field2) And (mp_terminated\Field0 = $00)) <> 0) Then
                        menuopen = $01
                    EndIf
                EndIf
                local6 = max(local6, min((Abs (me\Field0 / 400.0)), 1.0))
            Else
                If (me\Field9 <> 0) Then
                    If (keyhit(key\Field8) <> 0) Then
                        me\Field10 = 0.0
                        me\Field16 = 35.0
                    EndIf
                    If ((keydown(key\Field8) And (-10.0 > me\Field10)) <> 0) Then
                        me\Field10 = -10.0
                        me\Field16 = 35.0
                    EndIf
                EndIf
                me\Field2 = 0.0
            EndIf
            If (0.0 < me\Field15) Then
                me\Field10 = me\Field11
                me\Field15 = max((me\Field15 - fps\Field7[$00]), 0.0)
                If (3000.0 > me\Field15) Then
                    local6 = clamp(local6, ((3000.0 - me\Field15) / 2500.0), 1.0)
                EndIf
                If (4200.0 > me\Field15) Then
                    me\Field49 = max(me\Field49, ((4200.0 - me\Field15) / 2.0))
                    If (4200.0 <= (me\Field15 + fps\Field7[$00])) Then
                        createmsg(getlocalstring("msg", "eyedrop.tear"), 6.0)
                    EndIf
                EndIf
            EndIf
            If (chs\Field5 <> 0) Then
                me\Field17 = 100.0
            EndIf
            If (chs\Field1 <> 0) Then
                me\Field10 = me\Field11
            EndIf
            If (0.0 > me\Field3) Then
                resetselectedstuff()
                me\Field49 = (Abs (me\Field3 * 10.0))
                me\Field3 = (me\Field3 - fps\Field7[$00])
                local6 = max(local6, min((Abs (me\Field3 / 400.0)), 1.0))
            EndIf
            If (0.0 < me\Field51) Then
                If (entityhidden(t\Field3[$06]) <> 0) Then
                    showentity(t\Field3[$06])
                EndIf
                entityalpha(t\Field3[$06], clamp((me\Field51 + rnd(-0.2, 0.2)), 0.0, 1.0))
                me\Field51 = max((me\Field51 - (fps\Field7[$00] / 70.0)), 0.0)
            ElseIf (entityhidden(t\Field3[$06]) = $00) Then
                hideentity(t\Field3[$06])
            EndIf
            If ((((selecteditem = Null) Lor invopen) Lor (otheropen <> Null)) = $00) Then
                If (isiteminfocus() <> 0) Then
                    local6 = max(local6, 0.5)
                EndIf
            EndIf
            If (((selectedscreen <> Null) Lor (d_i\Field6 <> Null)) <> 0) Then
                local6 = max(local6, 0.5)
            EndIf
            If (0.0 <> local6) Then
                If (entityhidden(t\Field3[$05]) <> 0) Then
                    showentity(t\Field3[$05])
                EndIf
                entityalpha(t\Field3[$05], local6)
            ElseIf (entityhidden(t\Field3[$05]) = $00) Then
                hideentity(t\Field3[$05])
            EndIf
        EndIf
        If (0.0 = fps\Field7[$00]) Then
            updateworld(0.0)
        Else
            updateworld(1.0)
            manipulatenpcbones()
        EndIf
        updatenvg()
        updategui()
        If (((menuopen = $00) And (ismultiplayerhudenabled = $00)) <> 0) Then
            If (keyhit(key\Field6) <> 0) Then
                If ((((((((((d_i\Field6 = Null) And (selectedscreen = Null)) And (i_294\Field0 = $00)) And me\Field9) And (me\Field56 = $00)) And (0.0 <= me\Field26)) And (0.0 <= me\Field3)) And (0.0 = me\Field0)) And (me\Field43 = $FFFFFFFF)) <> 0) Then
                    If (invopen <> 0) Then
                        stopmousemovement()
                    Else
                        mo\Field4 = $FFFFFFFF
                    EndIf
                    invopen = (invopen = $00)
                    otheropen = Null
                    selecteditem = Null
                EndIf
            EndIf
            If (keyhit(key\Field9) <> 0) Then
                If (mp_getsocket() <> $00) Then
                    createhintmsg(getlocalstring("save", "cantsave"), 6.0, $00)
                ElseIf (selecteddifficulty\Field3 < $02) Then
                    Select cansave
                        Case $00
                            createhintmsg(getlocalstring("save", "failed.now"), 6.0, $00)
                        Case $01
                            createhintmsg(getlocalstring("save", "failed.location"), 6.0, $00)
                            If (quickloadpercent > $FFFFFFFF) Then
                                createhintmsg((msg\Field6 + getlocalstring("save", "failed.loading")), 6.0, $00)
                            EndIf
                        Case $02
                            createhintmsg(getlocalstring("save", "failed.096"), 6.0, $00)
                        Case $03
                            If (selecteddifficulty\Field3 = $01) Then
                                If (((selectedscreen = Null) And (sc_i\Field3 = Null)) <> 0) Then
                                    createhintmsg(getlocalstring("save", "failed.screen"), 6.0, $00)
                                Else
                                    savegame(currsave\Field0)
                                EndIf
                            ElseIf (350.0 >= as\Field1) Then
                                cancelautosave()
                            Else
                                savegame(currsave\Field0)
                            EndIf
                    End Select
                Else
                    createhintmsg(getlocalstring("save", "disable"), 6.0, $00)
                EndIf
            ElseIf (((selecteddifficulty\Field3 = $01) And ((selectedscreen <> Null) Lor (sc_i\Field3 <> Null))) <> 0) Then
                If (((msg\Field6 = "") Lor (0.0 >= msg\Field7)) <> 0) Then
                    createhintmsg(format(getlocalstring("save", "save"), key\Field0[key\Field9], "%s"), 6.0, $01)
                EndIf
                If (mo\Field1 <> 0) Then
                    sc_i\Field3 = Null
                EndIf
            EndIf
        EndIf
        updateautosave()
        If ((((keyhit(key\Field5) And opt\Field31) And (ue_server\Field11 Lor mp_ishoster())) And (ismultiplayerhudenabled = $00)) <> 0) Then
            If (consoleopen <> 0) Then
                usedconsole = $01
                resumesounds()
                stopmousemovement()
                shoulddeletegadgets = $01
            ElseIf (mp_getsocket() = $00) Then
                pausesounds()
            EndIf
            consoleopen = (consoleopen = $00)
            flushkeys()
        EndIf
        updatemessages()
        updatehintmessages()
        updatesubtitles()
        updateconsole()
        updatequickloading()
        updateachievementmsg()
        If (0.0 > me\Field45) Then
            If (me\Field43 <> $FFFFFFFF) Then
                updateending()
            EndIf
        ElseIf (me\Field43 = $FFFFFFFF) Then
            updatemenu()
        EndIf
        If (mp_getsocket() <> $00) Then
            updateplayersmodel()
            mp_updateterminated()
            mp_updategui($08)
            mp_updatecorpses()
            mp_updaterooms()
        EndIf
    Wend
    If (mainmenuopen <> 0) Then
        Return $00
    EndIf
    rendergame()
    catcherrors("Uncaught: UpdateGame()")
    Return $00
End Function
