Function updategame%()
    updateparticles_time = min(1.0, (updateparticles_time + fpsfactor))
    If (1.0 = updateparticles_time) Then
        updatedevilemitters()
        updateparticles_devil()
        updateparticles_time = 0.0
    EndIf
    If (infinitestamina <> 0) Then
        stamina = min(100.0, ((((100.0 - stamina) * 0.01) * fpsfactor) + stamina))
    EndIf
    updateworld((1.0 * fpsfactor))
    blurvolume = min(curvevalue(0.0, blurvolume, 20.0), 0.95)
    If (0.0 < blurtimer) Then
        blurvolume = max(min(0.95, (blurtimer / 1000.0)), blurvolume)
        blurtimer = max((blurtimer - fpsfactor), 0.0)
    EndIf
    darka = 0.0
    If (0.0 > sanity) Then
        If (restoresanity <> 0) Then
            sanity = min((sanity + fpsfactor), 0.0)
        EndIf
        If (-200.0 > sanity) Then
            darka = max(min((((- sanity) - 200.0) / 700.0), 0.6), darka)
            If (0.0 <= killtimer) Then
                heartbeatvolume = min(((Abs (sanity + 200.0)) / 500.0), 1.0)
                heartbeatrate = max((((Abs (sanity + 200.0)) / 6.0) + 70.0), heartbeatrate)
            EndIf
        EndIf
    EndIf
    If (0.0 < eyestuck) Then
        blinktimer = blinkfreq
        eyestuck = max((eyestuck - fpsfactor), 0.0)
        If (9000.0 > eyestuck) Then
            blurtimer = max(blurtimer, ((9000.0 - eyestuck) * 0.5))
        EndIf
        If (6000.0 > eyestuck) Then
            darka = min(max(darka, ((6000.0 - eyestuck) / 5000.0)), 1.0)
        EndIf
        If (((9000.0 > eyestuck) And (9000.0 <= (eyestuck + fpsfactor))) <> 0) Then
            msg = "The eyedrops are causing your eyes to tear up."
            msgtimer = 420.0
        EndIf
    EndIf
    If (0.0 > blinktimer) Then
        If (-5.0 < blinktimer) Then
            darka = max(darka, sin((Abs (blinktimer * 18.0))))
        ElseIf (-15.0 < blinktimer) Then
            darka = 1.0
        Else
            darka = max(darka, (Abs sin((blinktimer * 18.0))))
        EndIf
        If (-20.0 >= blinktimer) Then
            Select selecteddifficulty\Field5
                Case $00
                    blinkfreq = rnd(490.0, 700.0)
                Case $01
                    blinkfreq = rnd(455.0, 665.0)
                Case $02
                    blinkfreq = rnd(420.0, 630.0)
            End Select
            blinktimer = blinkfreq
        EndIf
        blinktimer = (blinktimer - fpsfactor)
    Else
        blinktimer = (blinktimer - ((fpsfactor * 0.6) * blinkeffect))
        If (0.0 < eyeirritation) Then
            blinktimer = (blinktimer - (min(((eyeirritation / 100.0) + 1.0), 4.0) * fpsfactor))
        EndIf
        darka = max(darka, 0.0)
    EndIf
    If (0.0 < lightflash) Then
        blinktimer = 0.0
    EndIf
    eyeirritation = max(0.0, (eyeirritation - fpsfactor))
    If (0.0 < blinkeffecttimer) Then
        blinkeffecttimer = (blinkeffecttimer - (fpsfactor / 70.0))
    ElseIf (1.0 <> blinkeffect) Then
        blinkeffect = 1.0
    EndIf
    lightblink = max((lightblink - (fpsfactor / 35.0)), 0.0)
    If (0.0 < lightblink) Then
        darka = min(max(darka, (rnd(0.3, 0.8) * lightblink)), 1.0)
    EndIf
    If (using294 <> 0) Then
        darka = 1.0
    EndIf
    If (wearingnightvision = $00) Then
        darka = max(((1.0 - secondarylighton) * 0.9), darka)
    EndIf
    If (0.0 > killtimer) Then
        invopen = $00
        selecteditem = Null
        selectedscreen = Null
        selectedmonitor = Null
        blurtimer = (Abs (killtimer * 5.0))
        killtimer = (killtimer - (fpsfactor * 0.8))
        If (((-360.0 > killtimer) And (networkserver\Field15 = $00)) <> 0) Then
            menu_open_type = $01
            menuopen = $01
            If (selectedending <> "") Then
                endingtimer = min(killtimer, -0.1)
            EndIf
        EndIf
        darka = max(darka, min((Abs (killtimer / 400.0)), 1.0))
    EndIf
    If (0.0 > falltimer) Then
        If (selecteditem <> Null) Then
            If ((instr(selecteditem\Field3\Field2, "hazmatsuit", $01) Or instr(selecteditem\Field3\Field2, "vest", $01)) <> 0) Then
                If (((wearinghazmat = $00) And (wearingvest = $00)) <> 0) Then
                    dropitem(selecteditem, $01)
                EndIf
            EndIf
        EndIf
        invopen = $00
        selecteditem = Null
        selectedscreen = Null
        selectedmonitor = Null
        blurtimer = (Abs (falltimer * 10.0))
        falltimer = (falltimer - fpsfactor)
        darka = max(darka, min((Abs (falltimer / 400.0)), 1.0))
    EndIf
    If (selecteditem <> Null) Then
        If (((selecteditem\Field3\Field2 = "navigator") Or (selecteditem\Field3\Field2 = "nav")) <> 0) Then
            darka = max(darka, 0.5)
        EndIf
    EndIf
    If (selectedscreen <> Null) Then
        darka = max(darka, 0.5)
    EndIf
    If (((0.0 <> darka) And ((0.0 < lightflash) = $00)) <> 0) Then
        showentity(dark)
        entityalpha(dark, darka)
    Else
        hideentity(dark)
    EndIf
    If (0.0 < lightflash) Then
        showentity(light)
        entityalpha(light, max(min((rnd(-0.2, 0.2) + lightflash), 1.0), 0.0))
        lightflash = max((lightflash - (fpsfactor / 70.0)), 0.0)
    Else
        hideentity(light)
    EndIf
    entitycolor(light, 255.0, 255.0, 255.0)
    Return $00
End Function
