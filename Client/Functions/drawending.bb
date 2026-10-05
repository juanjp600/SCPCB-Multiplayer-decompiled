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
            clscolor((Int max(((endingtimer * 2.8) + 255.0), 0.0)), (Int max(((endingtimer * 2.8) + 255.0), 0.0)), (Int max(((endingtimer * 2.8) + 255.0), 0.0)), $FF)
        Default
            clscolor($00, $00, $00, $FF)
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
                drawimage(endingscreen, (viewport_center_x - $190), (viewport_center_y - $190), $00)
            Else
                setcolorex($00, $00, $00)
                rect($64, $64, (graphicwidth - $C8), (graphicheight - $C8), $01)
                setcolorex($FF, $FF, $FF)
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
            drawimage(endingscreen, (viewport_center_x - $190), (viewport_center_y - $190), $00)
            If (((-1000.0 > endingtimer) And (-2000.0 < endingtimer)) <> 0) Then
                local2 = imagewidth(pausemenuimg)
                local3 = imageheight(pausemenuimg)
                local0 = ((graphicwidth Shr $01) - (local2 Shr $01))
                local1 = ((graphicheight Shr $01) - (local3 Shr $01))
                drawimage(pausemenuimg, local0, local1, $00)
                setcolorraw($FFFFFF)
                setfontex(fonts[$01]\Field0)
                text((((local2 Shr $01) + local0) + imenuscale[$28]), (imenuscale[$14] + local1), "THE END", $01, $00)
                setfontex(fonts[$00]\Field0)
                If (achievementsmenu = $00) Then
                    local0 = (local0 + imenuscale[$84])
                    local1 = (local1 + imenuscale[$7A])
                    local9 = $00
                    local10 = $00
                    For local6 = Each rooms
                        If ((((local6\Field8\Field11 <> "dimension1499") And (local6\Field8\Field11 <> "gatea")) And (local6\Field8\Field11 <> "pocketdimension")) <> 0) Then
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
                    text(local0, local1, ("SCPs encountered: " + (Str local13)), $00, $00)
                    text(local0, (imenuscale[$14] + local1), ((("Achievements unlocked: " + (Str local15)) + "/") + "37"), $00, $00)
                    text(local0, (imenuscale[$28] + local1), ((("Rooms found: " + (Str local10)) + "/") + (Str local9)), $00, $00)
                    text(local0, (imenuscale[$3C] + local1), ((("Documents discovered: " + (Str local12)) + "/") + (Str local11)), $00, $00)
                    text(local0, (imenuscale[$50] + local1), ("Items refined in SCP-914: " + (Str refineditems)), $00, $00)
                    local0 = ((graphicwidth Shr $01) - (local2 Shr $01))
                    local1 = ((graphicheight Shr $01) - (local3 Shr $01))
                    local0 = (local0 + (local2 Shr $01))
                    local1 = ((local1 + local3) - imenuscale[$64])
                    If (drawbutton((local0 - imenuscale[$91]), (local1 - imenuscale[$C8]), imenuscale[$186], imenuscale[$3C], "ACHIEVEMENTS", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                        achievementsmenu = $01
                    EndIf
                    If (drawbutton((local0 - imenuscale[$91]), (local1 - imenuscale[$64]), imenuscale[$186], imenuscale[$3C], "MAIN MENU", $01, $00, $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
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
    ui_showpointer()
    setfontex(fonts[$00]\Field0)
    Return $00
End Function
