Function drawending%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.itemtemplates
    Local local6.rooms
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    showpointer()
    fpsfactor = 0.0
    If (-2000.0 < endingtimer) Then
        endingtimer = max((endingtimer - fpsfactor2), -1111.0)
    Else
        endingtimer = (endingtimer - fpsfactor2)
    EndIf
    giveachievement($04, $01)
    If (usedconsole = $00) Then
        giveachievement($1F, $01)
    EndIf
    If (selecteddifficulty\Field0 = "Keter") Then
        giveachievement($24, $01)
    EndIf
    Select lower(selectedending)
        Case "b2","a1"
            clscolor((Int max(((endingtimer * 2.8) + 255.0), 0.0)), (Int max(((endingtimer * 2.8) + 255.0), 0.0)), (Int max(((endingtimer * 2.8) + 255.0), 0.0)))
        Default
            clscolor($00, $00, $00)
    End Select
    shouldplay = $42
    cls()
    If (-200.0 > endingtimer) Then
        If (breathchn <> $00) Then
            If (channelplaying(breathchn) <> 0) Then
                stopchannel(breathchn)
                stamina = 100.0
            EndIf
        EndIf
        If (endingscreen = $00) Then
            endingscreen = loadimage_strict("GFX\endingscreen.pt")
            shouldplay = $17
            currmusicvolume = musicvolume
            currmusicvolume = musicvolume
            stopstream_strict(musicchn)
            musicchn = streamsound_strict((("SFX\Music\" + music($17)) + ".ogg"), currmusicvolume, $00)
            nowplaying = shouldplay
            playsound_strict(lightsfx)
        EndIf
        If (-700.0 < endingtimer) Then
            If (min(((Abs endingtimer) - 200.0), 155.0) > (Float rand($01, $96))) Then
                drawimage(endingscreen, ((graphicwidth Sar $01) - $190), ((graphicheight Sar $01) - $190), $00)
            Else
                color($00, $00, $00)
                rect($64, $64, (graphicwidth - $C8), (graphicheight - $C8), $01)
                color($FF, $FF, $FF)
            EndIf
            If (((-450.0 < (endingtimer + fpsfactor2)) And (-450.0 >= endingtimer)) <> 0) Then
                Select lower(selectedending)
                    Case "a1","a2"
                        playsound_strict(loadtempsound((("SFX\Ending\GateA\Ending" + selectedending) + ".ogg")))
                    Case "b1","b2","b3"
                        playsound_strict(loadtempsound((("SFX\Ending\GateB\Ending" + selectedending) + ".ogg")))
                End Select
            EndIf
        Else
            drawimage(endingscreen, ((graphicwidth Sar $01) - $190), ((graphicheight Sar $01) - $190), $00)
            If (((-1000.0 > endingtimer) And (-2000.0 < endingtimer)) <> 0) Then
                local2 = imagewidth(pausemenuimg)
                local3 = imageheight(pausemenuimg)
                local0 = ((graphicwidth Sar $01) - (local2 Sar $01))
                local1 = ((graphicheight Sar $01) - (local3 Sar $01))
                drawimage(pausemenuimg, local0, local1, $00)
                color($FF, $FF, $FF)
                aasetfont(font2)
                aatext((Int ((40.0 * menuscale) + (Float ((local2 Sar $01) + local0)))), (Int ((20.0 * menuscale) + (Float local1))), "THE END", $01, $00, 1.0)
                aasetfont(font1)
                If (achievementsmenu = $00) Then
                    local0 = (Int ((132.0 * menuscale) + (Float local0)))
                    local1 = (Int ((122.0 * menuscale) + (Float local1)))
                    local9 = $00
                    local10 = $00
                    For local6 = Each rooms
                        If ((((local6\Field7\Field11 <> "dimension1499") And (local6\Field7\Field11 <> "gatea")) And (local6\Field7\Field11 <> "pocketdimension")) <> 0) Then
                            local9 = (local9 + $01)
                            local10 = (local10 + local6\Field1)
                        EndIf
                    Next
                    local11 = $00
                    local12 = $00
                    For local5 = Each itemtemplates
                        If (local5\Field2 = "paper") Then
                            local11 = (local11 + $01)
                            local12 = (local12 + local5\Field4)
                        EndIf
                    Next
                    local13 = $01
                    For local14 = $00 To $18 Step $01
                        local13 = (local13 + achievements(local14))
                    Next
                    local15 = $00
                    For local14 = $00 To $24 Step $01
                        local15 = (local15 + achievements(local14))
                    Next
                    aatext(local0, local1, ("SCPs encountered: " + (Str local13)), $00, $00, 1.0)
                    aatext(local0, (Int ((20.0 * menuscale) + (Float local1))), ((("Achievements unlocked: " + (Str local15)) + "/") + "37"), $00, $00, 1.0)
                    aatext(local0, (Int ((40.0 * menuscale) + (Float local1))), ((("Rooms found: " + (Str local10)) + "/") + (Str local9)), $00, $00, 1.0)
                    aatext(local0, (Int ((60.0 * menuscale) + (Float local1))), ((("Documents discovered: " + (Str local12)) + "/") + (Str local11)), $00, $00, 1.0)
                    aatext(local0, (Int ((80.0 * menuscale) + (Float local1))), ("Items refined in SCP-914: " + (Str refineditems)), $00, $00, 1.0)
                    local0 = ((graphicwidth Sar $01) - (local2 Sar $01))
                    local1 = ((graphicheight Sar $01) - (local3 Sar $01))
                    local0 = (local0 + (local2 Sar $01))
                    local1 = (Int ((Float (local1 + local3)) - (100.0 * menuscale)))
                    If (drawbutton((Int ((Float local0) - (145.0 * menuscale))), (Int ((Float local1) - (200.0 * menuscale))), (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "ACHIEVEMENTS", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        achievementsmenu = $01
                    EndIf
                    If (drawbutton((Int ((Float local0) - (145.0 * menuscale))), (Int ((Float local1) - (100.0 * menuscale))), (Int (390.0 * menuscale)), (Int (60.0 * menuscale)), "MAIN MENU", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        shouldplay = $18
                        nowplaying = shouldplay
                        For local14 = $00 To $09 Step $01
                            If (tempsounds[local14] <> $00) Then
                                freesound_strict(tempsounds[local14])
                                tempsounds[local14] = $00
                            EndIf
                        Next
                        stopstream_strict(musicchn)
                        musicchn = streamsound_strict((("SFX\Music\" + music(nowplaying)) + ".ogg"), 0.0, $02)
                        setstreamvolume_strict(musicchn, (1.0 * musicvolume))
                        flushkeys()
                        endingtimer = -2000.0
                        initcredits()
                    EndIf
                Else
                    shouldplay = $17
                    drawmenu()
                EndIf
            ElseIf (-2000.0 >= endingtimer) Then
                shouldplay = $18
                drawcredits()
            EndIf
        EndIf
    EndIf
    If (fullscreen <> 0) Then
        drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
    EndIf
    aasetfont(font1)
    Return $00
End Function
