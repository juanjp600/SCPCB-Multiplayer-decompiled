Function drawloading%(arg0#, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4.loadingscreens
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12$
    Local local13%
    Local local16%
    Local local17%
    Local local18.players
    local2 = $01
    If (0.0 = arg0) Then
        currentpercent = 0.0
        loadingscreentext = $00
        local3 = rand($01, loadingscreenamount)
        For local4 = Each loadingscreens
            If (local4\Field2 = local3) Then
                If (local4\Field1 = $00) Then
                    local4\Field1 = loadimage_strict(("Loadingscreens\" + local4\Field0))
                    resizeimage(local4\Field1, ((Float imagewidth(local4\Field1)) * menuscale), ((Float imageheight(local4\Field1)) * menuscale))
                EndIf
                selectedloadingscreen = local4
                Exit
            EndIf
        Next
    EndIf
    If (info_image = $00) Then
        initinfoclues("Data\clues.ini")
    EndIf
    If (mainmenuopen <> 0) Then
        gameload = $01
    EndIf
    Repeat
        updateframe()
        currentpercent = arg0
        steamupdate()
        discord_api_update()
        multiplayer_send($01, $00, $00)
        clscolor($00, $00, $00, $FF)
        cls()
        If (20.0 < currentpercent) Then
            updatemusic()
        EndIf
        If (arg1 = $00) Then
            If (currentpercent > ((100.0 / (Float selectedloadingscreen\Field8)) * (Float (loadingscreentext + $01)))) Then
                loadingscreentext = (loadingscreentext + $01)
            EndIf
        EndIf
        If (selectedloadingscreen\Field6 = $00) Then
            drawimage(loadingback, (viewport_center_x - (imagewidth(loadingback) Shr $01)), (viewport_center_y - (imageheight(loadingback) Shr $01)), $00)
        EndIf
        If (selectedloadingscreen\Field4 = $00) Then
            local0 = (viewport_center_x - (imagewidth(selectedloadingscreen\Field1) Shr $01))
        ElseIf (selectedloadingscreen\Field4 = $01) Then
            local0 = (graphicwidth - imagewidth(selectedloadingscreen\Field1))
        Else
            local0 = $00
        EndIf
        If (selectedloadingscreen\Field5 = $00) Then
            local1 = (viewport_center_y - (imageheight(selectedloadingscreen\Field1) Shr $01))
        ElseIf (selectedloadingscreen\Field5 = $01) Then
            local1 = (graphicheight - imageheight(selectedloadingscreen\Field1))
        Else
            local1 = $00
        EndIf
        maskimage(selectedloadingscreen\Field1, $00, $00, $00)
        drawimage(selectedloadingscreen\Field1, local0, local1, $00)
        local6 = imenuscale[$130]
        local7 = imenuscale[$12]
        local0 = (viewport_center_x - (local6 Shr $01))
        local1 = (viewport_center_y - imenuscale[$46])
        setcolorex($FF, $FF, $FF)
        If (blinkbar <> $00) Then
            local8 = (local6 - imenuscale[$01])
            local9 = (Int (((Float local8) * currentpercent) * 0.01))
            If (local9 > local8) Then
                local9 = local8
            EndIf
            local10 = (imenuscale[$02] + local0)
            local11 = (imenuscale[$02] + local1)
            drawblockrect(blinkbar, local10, local11, $00, $00, local9, imenuscale[$0E], $00)
        EndIf
        rect(local0, local1, (imenuscale[$04] + local6), local7, $00)
        If (selectedloadingscreen\Field3 = "CWM") Then
            If (arg1 = $00) Then
                If (local2 <> 0) Then
                    If (0.0 = currentpercent) Then
                        playsound_strict(loadtempsound("SFX\SCP\990\cwm1.cwm"))
                    ElseIf (99.99 <= currentpercent) Then
                        playsound_strict(loadtempsound("SFX\SCP\990\cwm2.cwm"))
                    EndIf
                EndIf
            EndIf
            setfontex(fonts[$01]\Field0)
            local12 = ""
            local3 = rand($02, $09)
            For local13 = $00 To local3 Step $01
                local12 = (local12 + chr(rand($30, $7A)))
            Next
            text(viewport_center_x, (imenuscale[$50] + viewport_center_y), local12, $01, $01)
            If (0.0 = arg0) Then
                If (rand($05, $01) = $01) Then
                    Select rand($02, $01)
                        Case $01
                            selectedloadingscreen\Field7[$00] = (("It will happen on " + currentdate()) + ".")
                        Case $02
                            selectedloadingscreen\Field7[$00] = currenttime()
                    End Select
                Else
                    Select rand($0D, $01)
                        Case $01
                            selectedloadingscreen\Field7[$00] = "A very fine radio might prove to be useful."
                        Case $02
                            selectedloadingscreen\Field7[$00] = "ThIS PLaCE WiLL BUrN"
                        Case $03
                            selectedloadingscreen\Field7[$00] = "You cannot control it."
                        Case $04
                            selectedloadingscreen\Field7[$00] = "eof9nsd3jue4iwe1fgj"
                        Case $05
                            selectedloadingscreen\Field7[$00] = "YOU NEED TO TRUST IT"
                        Case $06
                            selectedloadingscreen\Field7[$00] = "Look my friend in the eye when you address him, isn't that the way of the gentleman?"
                        Case $07
                            selectedloadingscreen\Field7[$00] = "???____??_???__????n?"
                        Case $08,$09
                            selectedloadingscreen\Field7[$00] = "Jorge has been expecting you."
                        Case $0A
                            selectedloadingscreen\Field7[$00] = "???????????"
                        Case $0B
                            selectedloadingscreen\Field7[$00] = "Make her a member of the midnight crew."
                        Case $0C
                            selectedloadingscreen\Field7[$00] = "oncluded that coming here was a mistake. We have to turn back."
                        Case $0D
                            selectedloadingscreen\Field7[$00] = "This alloy contains the essence of my life."
                    End Select
                EndIf
            EndIf
            local12 = selectedloadingscreen\Field7[$00]
            local3 = (len(selectedloadingscreen\Field7[$00]) - rand($05, $01))
            For local13 = $00 To rand($0A, $0F) Step $01
                local12 = replace(selectedloadingscreen\Field7[$00], mid(selectedloadingscreen\Field7[$00], rand($01, (len(local12) - $01)), $01), chr(rand($82, $FA)))
            Next
            setfontex(fonts[$00]\Field0)
            rowtext(local12, (Float (viewport_center_x - imenuscale[$C8])), (Float (imenuscale[$78] + viewport_center_y)), (Float imenuscale[$190]), (Float imenuscale[$12C]), $01, 1.0, $00)
        Else
            setfontex(fonts[$01]\Field0)
            setcolorex($00, $00, $00)
            text((imenuscale[$01] + viewport_center_x), (imenuscale[$51] + viewport_center_y), selectedloadingscreen\Field3, $01, $01)
            setcolorex($FF, $FF, $FF)
            text(viewport_center_x, (imenuscale[$50] + viewport_center_y), selectedloadingscreen\Field3, $01, $01)
            setfontex(fonts[$00]\Field0)
            rowtext(selectedloadingscreen\Field7[loadingscreentext], (Float (viewport_center_x - imenuscale[$C8])), (Float (imenuscale[$78] + viewport_center_y)), (Float imenuscale[$190]), (Float imenuscale[$12C]), $01, 1.0, $01)
        EndIf
        setcolorex($00, $00, $00)
        text((imenuscale[$01] + viewport_center_x), (viewport_center_y - imenuscale[$65]), (("LOADING - " + (Str (Int currentpercent))) + " %"), $01, $01)
        setcolorex($FF, $FF, $FF)
        text(viewport_center_x, (viewport_center_y - imenuscale[$64]), (("LOADING - " + (Str (Int currentpercent))) + " %"), $01, $01)
        If ((((99.0 <= arg0) And gameload) And udp_getstream()) <> 0) Then
            local16 = imenuscale[$C8]
            If (99.0 = arg0) Then
                For local18 = Each players
                    If (local18\Field41 <> 0) Then
                        local17 = (local17 + $01)
                    EndIf
                Next
                setcolorex($FF, $FF, $FF)
                text(viewport_center_x, (viewport_center_y - local16), (((("WAITING FOR OTHER PLAYERS ( " + (Str local17)) + " / ") + (Str networkserver\Field21)) + " )"), $01, $01)
                setcolorex($FF, $FF, $FF)
                setfontex(fonts[$00]\Field0)
                text(imenuscale[$14], imenuscale[$14], "Press ESC To exit", $00, $00)
                If (keyhit($01) <> 0) Then
                    disconnectserver("", $01)
                    Exit
                EndIf
            ElseIf (((99.0 <= arg0) And (99.4 >= arg0)) <> 0) Then
                If (99.1 = arg0) Then
                    text(viewport_center_x, (viewport_center_y - local16), "RECEIVING DATA.", $01, $01)
                ElseIf (99.2 = arg0) Then
                    text(viewport_center_x, (viewport_center_y - local16), "RECEIVING DATA..", $01, $01)
                ElseIf (99.3 = arg0) Then
                    text(viewport_center_x, (viewport_center_y - local16), "RECEIVING DATA...", $01, $01)
                EndIf
            EndIf
        EndIf
        If (99.99 <= currentpercent) Then
            If ((local2 And (selectedloadingscreen\Field3 <> "CWM")) <> 0) Then
                playsound_strict(loadtempsound("SFX\Horror\Horror8.ogg"))
            EndIf
            text(viewport_center_x, (graphicheight - imenuscale[$32]), "PRESS ANY KEY TO CONTINUE", $01, $01)
        Else
            flushkeys()
            flushmouse()
        EndIf
        If (arg2 <> 0) Then
            multiplayer_updategui($00)
        EndIf
        If (((mainmenuopen = $01) And ((getkey() <> $00) Or mousehit($01))) <> 0) Then
            gameload = $00
        EndIf
        setcolorex($FF, $FF, $FF)
        drawquickclues()
        updateresolution($00)
        updatevsync($01)
        local2 = $00
        If (((99.99 > currentpercent) And (currentpercent >= (arg0 - 0.01))) <> 0) Then
            gameload = $00
            Exit
        EndIf
    Until (((gameload = $00) And (currentpercent > (arg0 - 0.05))) <> 0)
    Return $00
End Function
