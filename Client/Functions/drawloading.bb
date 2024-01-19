Function drawloading%(arg0#, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3.loadingscreens
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9$
    Local local12%
    Local local13.players
    If (0.0 = arg0) Then
        currentpercent = 0.0
        loadingscreentext = $00
        local2 = rand($01, loadingscreenamount)
        For local3 = Each loadingscreens
            If (local3\Field2 = local2) Then
                If (local3\Field1 = $00) Then
                    local3\Field1 = loadimage_strict(("Loadingscreens\" + local3\Field0))
                    resizeimage(local3\Field1, ((Float imagewidth(local3\Field1)) * menuscale), ((Float imageheight(local3\Field1)) * menuscale))
                EndIf
                selectedloadingscreen = local3
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
    local4 = $01
    If ((((networkserver\Field67 <> "") And (api_steamhtml = $01)) And (menubrowser = Null)) <> 0) Then
        menubrowser = steambrowser_create(graphicwidth, graphicheight, networkserver\Field67, "SteamBrowser", "")
    EndIf
    Repeat
        updateframe($00)
        currentpercent = tovalue(arg0, currentpercent, 0.5)
        If (arg3 <> 0) Then
            currentpercent = arg0
        EndIf
        steam_update()
        discord_api_update()
        If (menubrowser <> Null) Then
            bs_isteamhtmlsurface_mousemove(bs_steamhtmlsurface(), menubrowser\Field0, mousex(), mousey())
            If (mousedown($01) <> 0) Then
                bs_isteamhtmlsurface_mousedown(bs_steamhtmlsurface(), menubrowser\Field0, $00)
            Else
                bs_isteamhtmlsurface_mouseup(bs_steamhtmlsurface(), menubrowser\Field0, $00)
            EndIf
        EndIf
        clscolor($00, $00, $00)
        cls()
        multiplayer_send($01, $00, $00)
        If (20.0 < currentpercent) Then
            updatemusic()
        EndIf
        If (arg1 = $00) Then
            If (currentpercent > ((100.0 / (Float selectedloadingscreen\Field8)) * (Float (loadingscreentext + $01)))) Then
                loadingscreentext = (loadingscreentext + $01)
            EndIf
        EndIf
        If (menubrowser = Null) Then
            If (selectedloadingscreen\Field6 = $00) Then
                drawimage(loadingback, ((graphicwidth Sar $01) - (imagewidth(loadingback) Sar $01)), ((graphicheight Sar $01) - (imageheight(loadingback) Sar $01)), $00)
            EndIf
            If (selectedloadingscreen\Field4 = $00) Then
                local0 = ((graphicwidth Sar $01) - (imagewidth(selectedloadingscreen\Field1) Sar $01))
            ElseIf (selectedloadingscreen\Field4 = $01) Then
                local0 = (graphicwidth - imagewidth(selectedloadingscreen\Field1))
            Else
                local0 = $00
            EndIf
            If (selectedloadingscreen\Field5 = $00) Then
                local1 = ((graphicheight Sar $01) - (imageheight(selectedloadingscreen\Field1) Sar $01))
            ElseIf (selectedloadingscreen\Field5 = $01) Then
                local1 = (graphicheight - imageheight(selectedloadingscreen\Field1))
            Else
                local1 = $00
            EndIf
            drawimage(selectedloadingscreen\Field1, local0, local1, $00)
            maskimage(selectedloadingscreen\Field1, $00, $00, $00)
        Else
            drawblock(steambrowser_getimagehandle(menubrowser), $00, $00, $00)
        EndIf
        local6 = $12C
        local7 = $14
        local0 = ((graphicwidth Sar $01) - (local6 Sar $01))
        local1 = (((graphicheight Sar $01) + $1E) - $64)
        color($FF, $FF, $FF)
        rect(local0, local1, (local6 + $04), local7, $00)
        For local8 = $01 To (Int (((currentpercent / 100.0) * (Float (local6 - $02))) / 10.0)) Step $01
            drawimage(blinkmeterimg, ((local0 + $03) + ((local8 - $01) * $0A)), (local1 + $03), $00)
        Next
        If (selectedloadingscreen\Field3 = "CWM") Then
            If (arg1 = $00) Then
                If (local4 <> 0) Then
                    If (0.0 = currentpercent) Then
                        playsound_strict(loadtempsound("SFX\SCP\990\cwm1.cwm"))
                    ElseIf (99.99 <= currentpercent) Then
                        playsound_strict(loadtempsound("SFX\SCP\990\cwm2.cwm"))
                    EndIf
                EndIf
            EndIf
            aasetfont(font2)
            local9 = ""
            local2 = rand($02, $09)
            For local8 = $00 To local2 Step $01
                local9 = (local9 + chr(rand($30, $7A)))
            Next
            aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), local9, $01, $01, 1.0)
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
            local9 = selectedloadingscreen\Field7[$00]
            local2 = (len(selectedloadingscreen\Field7[$00]) - rand($05, $01))
            For local8 = $00 To rand($0A, $0F) Step $01
                local9 = replace(selectedloadingscreen\Field7[$00], mid(selectedloadingscreen\Field7[$00], rand($01, (len(local9) - $01)), $01), chr(rand($82, $FA)))
            Next
            aasetfont(font1)
            rowtext(local9, (Float ((graphicwidth Sar $01) - $C8)), (Float ((graphicheight Sar $01) + $78)), 400.0, 300.0, $01, 1.0, $00)
        Else
            aasetfont(font2)
            color($00, $00, $00)
            aatext(((graphicwidth Sar $01) + $01), (((graphicheight Sar $01) + $50) + $01), selectedloadingscreen\Field3, $01, $01, 1.0)
            color($FF, $FF, $FF)
            aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), selectedloadingscreen\Field3, $01, $01, 1.0)
            aasetfont(font1)
            rowtext(selectedloadingscreen\Field7[loadingscreentext], (Float ((graphicwidth Sar $01) - $C8)), (Float ((graphicheight Sar $01) + $78)), 400.0, 300.0, $01, 1.0, $01)
        EndIf
        color($00, $00, $00)
        aatext(((graphicwidth Sar $01) + $01), (((graphicheight Sar $01) - $64) + $01), (("LOADING - " + (Str (Int currentpercent))) + " %"), $01, $01, 1.0)
        color($FF, $FF, $FF)
        aatext((graphicwidth Sar $01), ((graphicheight Sar $01) - $64), (("LOADING - " + (Str (Int currentpercent))) + " %"), $01, $01, 1.0)
        If ((((99.0 <= arg0) And gameload) And udp_getstream()) <> 0) Then
            If (99.0 = arg0) Then
                For local13 = Each players
                    If (local13\Field43 <> 0) Then
                        local12 = (local12 + $01)
                    EndIf
                Next
                color($FF, $FF, $FF)
                aatext((graphicwidth Sar $01), ((graphicheight Sar $01) - $C8), (((("WAITING FOR OTHER PLAYERS ( " + (Str local12)) + " / ") + (Str networkserver\Field29)) + " )"), $01, $01, 1.0)
                color($FF, $FF, $FF)
                aasetfont(font1)
                aatext((Int (20.0 * menuscale)), (Int (20.0 * menuscale)), "Press ESC To exit", $00, $00, 1.0)
                If (keyhit($01) <> 0) Then
                    disconnectserver("", $01)
                    Exit
                EndIf
            ElseIf (((99.0 <= arg0) And (99.4 >= arg0)) <> 0) Then
                If (99.1 = arg0) Then
                    aatext((graphicwidth Sar $01), ((graphicheight Sar $01) - $C8), "RECEIVING DATA.", $01, $01, 1.0)
                ElseIf (99.2 = arg0) Then
                    aatext((graphicwidth Sar $01), ((graphicheight Sar $01) - $C8), "RECEIVING DATA..", $01, $01, 1.0)
                ElseIf (99.3 = arg0) Then
                    aatext((graphicwidth Sar $01), ((graphicheight Sar $01) - $C8), "RECEIVING DATA...", $01, $01, 1.0)
                EndIf
            EndIf
        EndIf
        If (99.99 <= currentpercent) Then
            If ((local4 And (selectedloadingscreen\Field3 <> "CWM")) <> 0) Then
                playsound_strict(loadtempsound("SFX\Horror\Horror8.ogg"))
            EndIf
            aatext((graphicwidth Sar $01), (graphicheight - $32), "PRESS ANY KEY TO CONTINUE", $01, $01, 1.0)
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
        drawquickclues()
        updateresolution($01, $00)
        local4 = $00
        If (((99.99 > currentpercent) And (currentpercent >= (arg0 - 0.01))) <> 0) Then
            gameload = $00
            Exit
        EndIf
    Until (((gameload = $00) And (currentpercent >= (arg0 - 0.05))) <> 0)
    Return $00
End Function
