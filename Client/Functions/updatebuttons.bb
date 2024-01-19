Function updatebuttons%()
    Local local0$
    Local local1#
    Local local2%
    If (spectate\Field1 = $FFFFFFFF) Then
        If ((keyhit(key_inv) And (0.0 <= vomittimer)) <> 0) Then
            If ((((unabletomove = $00) And (iszombie = $00)) And (using294 = $00)) <> 0) Then
                local0 = ""
                local1 = 0.0
                If (selecteditem <> Null) Then
                    local0 = selecteditem\Field3\Field2
                    local1 = selecteditem\Field13
                EndIf
                If ((((((((local0 <> "vest") And (local0 <> "finevest")) And (local0 <> "hazmatsuit")) And (local0 <> "hazmatsuit2")) And (local0 <> "hazmatsuit3")) Or (0.0 = local1)) Or (100.0 = local1)) <> 0) Then
                    If (invopen <> 0) Then
                        resetmouse()
                    EndIf
                    invopen = (invopen = $00)
                    If (otheropen <> Null) Then
                        otheropen = Null
                    EndIf
                    selecteditem = Null
                EndIf
            EndIf
        EndIf
    EndIf
    If (currsave = "") Then
        currsave = "untitled"
    EndIf
    If (((networkserver\Field15 = $00) And (myplayer\Field33 = $00)) <> 0) Then
        If ((keyhit(key_save) And (-1.0 = jumpstate)) <> 0) Then
            If (selecteddifficulty\Field4 = $00) Then
                local2 = $01
                Select playerroom\Field7\Field11
                    Case "173"
                        If ((1040.0 * roomscale) < entityy(collider, $00)) Then
                            local2 = $00
                            msg = "You cannot save in this location."
                            msgtimer = 280.0
                        EndIf
                    Case "exit1","gatea","pocketdimension","dimension1499"
                        local2 = $00
                        msg = "You cannot save in this location."
                        msgtimer = 280.0
                    Default
                        If (((cansave = $00) Or (quickloadpercent > $FFFFFFFF)) <> 0) Then
                            msg = "You cannot save at this moment."
                            msgtimer = 280.0
                            If (quickloadpercent > $FFFFFFFF) Then
                                msg = (msg + " (game is loading)")
                            EndIf
                        ElseIf (networkserver\Field18 <> 0) Then
                            savegame(((savepath + currsave) + "\"))
                        Else
                            msg = "Game progress saved."
                            If (selecteddifficulty\Field4 = $02) Then
                                playsound_strict(loadtempsound("SFX\General\Save2.ogg"))
                            Else
                                playsound_strict(loadtempsound("SFX\General\Save1.ogg"))
                            EndIf
                            msgtimer = 560.0
                        EndIf
                End Select
            ElseIf (selecteddifficulty\Field4 = $02) Then
                If (((selectedscreen = Null) And (selectedmonitor = Null)) <> 0) Then
                    msg = "Saving is only permitted on clickable monitors scattered throughout the facility."
                    msgtimer = 280.0
                Else
                    local2 = $01
                    Select playerroom\Field7\Field11
                        Case "173"
                            If ((1040.0 * roomscale) < entityy(collider, $00)) Then
                                local2 = $00
                                msg = "You cannot save in this location."
                                msgtimer = 280.0
                            EndIf
                        Case "exit1","gatea","pocketdimension","dimension1499"
                            local2 = $00
                            msg = "You cannot save in this location."
                            msgtimer = 280.0
                        Default
                            If (((cansave = $00) Or (quickloadpercent > $FFFFFFFF)) <> 0) Then
                                msg = "You cannot save at this moment."
                                msgtimer = 280.0
                                If (quickloadpercent > $FFFFFFFF) Then
                                    msg = (msg + " (game is loading)")
                                EndIf
                            Else
                                If (selectedscreen <> Null) Then
                                    gamesaved = $00
                                    playable = $01
                                    dropspeed = 0.0
                                EndIf
                                If (networkserver\Field18 <> 0) Then
                                    savegame(((savepath + currsave) + "\"))
                                Else
                                    msg = "Game progress saved."
                                    If (selecteddifficulty\Field4 = $02) Then
                                        playsound_strict(loadtempsound("SFX\General\Save2.ogg"))
                                    Else
                                        playsound_strict(loadtempsound("SFX\General\Save1.ogg"))
                                    EndIf
                                    msgtimer = 560.0
                                EndIf
                            EndIf
                    End Select
                EndIf
            EndIf
            If (msg = "Game progress saved.") Then
                setsavingposition(playerroom\Field7\Field11, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), entityyaw(collider, $00))
            EndIf
        ElseIf (((selecteddifficulty\Field4 = $02) And ((selectedscreen <> Null) Or (selectedmonitor <> Null))) <> 0) Then
            If (((((msg <> "Game progress saved.") And (msg <> "You cannot save in this location.")) And (msg <> "You cannot save at this moment.")) Or (0.0 >= msgtimer)) <> 0) Then
                msg = (("Press " + keyname(key_save)) + " to save.")
                msgtimer = 280.0
            EndIf
            If (mousehit2 <> 0) Then
                selectedmonitor = Null
            EndIf
        EndIf
    EndIf
    If (keyhit(key_console) <> 0) Then
        If (((rcon\Field0 Or (nocheat = $00)) Or $00) <> 0) Then
            If (canopenconsole <> 0) Then
                If (consoleopen <> 0) Then
                    resetmouse()
                EndIf
                consoleopen = (consoleopen = $00)
                flushkeys()
            EndIf
        EndIf
    EndIf
    If (((rcon\Field0 Or (nocheat = $00)) Or $00) = $00) Then
        consoleopen = $00
    EndIf
    If (((keydown($31) And (mainmenuopen = $00)) And (((((((((((menuopen = $00) And (invopen = $00)) And (otheropen = Null)) And (selecteddoor = Null)) And (consoleopen = $00)) And (using294 = $00)) And (selectedscreen = Null)) And (lockmouse = $00)) And (0.0 <= endingtimer)) And (networkserver\Field27 = $00)) Or mainmenuopen)) <> 0) Then
        If (tab_menu_state < $02) Then
            tab_menu_state = $01
        EndIf
    ElseIf (tab_menu_state < $02) Then
        tab_menu_state = $00
        currplayer = Null
    ElseIf (((mainmenuopen = $00) And (((((((((((menuopen = $00) And (invopen = $00)) And (otheropen = Null)) And (selecteddoor = Null)) And (consoleopen = $00)) And (using294 = $00)) And (selectedscreen = Null)) And (lockmouse = $00)) And (0.0 <= endingtimer)) And (networkserver\Field27 = $00)) Or mainmenuopen)) = $00) Then
        tab_menu_state = $00
    EndIf
    Return $00
End Function
