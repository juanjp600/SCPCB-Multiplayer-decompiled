Function updateending%()
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    fps\Field7[$00] = 0.0
    If (-2000.0 < me\Field45) Then
        me\Field45 = max((me\Field45 - fps\Field7[$01]), -1111.0)
    Else
        me\Field45 = (me\Field45 - fps\Field7[$01])
    EndIf
    giveachievement("055", $01)
    If ((((usedconsole = $00) And (selectedcustommap = Null)) Lor opt\Field51) <> 0) Then
        giveachievement("console", $01)
        Select selecteddifficulty\Field0
            Case difficulties[$02]\Field0
                giveachievement("keter", $01)
            Case difficulties[$03]\Field0
                giveachievement("keter", $01)
                giveachievement("apollyon", $01)
        End Select
        saveachievementsfile()
    EndIf
    shouldplay = $42
    If (-200.0 > me\Field45) Then
        stopbreathsound()
        me\Field17 = 100.0
        If (me\Field44 = $00) Then
            me\Field44 = scaleimageex(loadimage_strict("GFX\Menu\ending_screen.png"), menuscale, menuscale, $01)
            shouldplay = $16
            opt\Field19 = opt\Field18
            stopstream_strict(musicchn)
            musicchn = $00
            musicchn = streamsound_strict((("SFX\Music\" + music[$16]) + ".ogg"), (opt\Field19 * opt\Field16), $00)
            nowplaying = shouldplay
            playsound_strict(snd_i\Field34, $00)
        EndIf
        If (-700.0 < me\Field45) Then
            If (((-450.0 < (me\Field45 + fps\Field7[$01])) And (-450.0 >= me\Field45)) <> 0) Then
                playsound_strict(loadtempsound((("SFX\Ending\Ending" + (Str me\Field43)) + ".ogg")), $01)
            EndIf
        ElseIf (((-1000.0 > me\Field45) And (-2000.0 < me\Field45)) <> 0) Then
            If (igm\Field0 <= $00) Then
                local1 = imagewidth(t\Field1[$00])
                local2 = imageheight(t\Field1[$00])
                local3 = (mo\Field9 - (local1 Sar $01))
                local4 = (mo\Field10 - (local2 Sar $01))
                local3 = (Int ((132.0 * menuscale) + (Float local3)))
                local4 = (Int ((432.0 * menuscale) + (Float local4)))
                If (updatemenubutton(local3, local4, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "achievements"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    igm\Field0 = $01
                    shoulddeletegadgets = $01
                EndIf
                local4 = (Int ((75.0 * menuscale) + (Float local4)))
                If (updatemenubutton(local3, local4, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "mainmenu"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    shouldplay = $17
                    nowplaying = shouldplay
                    For local5 = $00 To $09 Step $01
                        If (tempsounds[local5] <> $00) Then
                            freesound_strict(tempsounds[local5])
                            tempsounds[local5] = $00
                        EndIf
                    Next
                    stopstream_strict(musicchn)
                    musicchn = $00
                    musicchn = streamsound_strict((("SFX\Music\" + music[nowplaying]) + ".ogg"), 0.0, $02)
                    setstreamvolume_strict(musicchn, (opt\Field18 * opt\Field16))
                    me\Field45 = -2000.0
                    shoulddeletegadgets = $01
                    resetinput()
                    initcredits()
                EndIf
            Else
                shouldplay = $16
                updatemenu()
            EndIf
        ElseIf (-2000.0 >= me\Field45) Then
            shouldplay = $17
            updatecredits()
        EndIf
    EndIf
    Return $00
End Function
