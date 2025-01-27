Function renderloading%(arg0%, arg1$)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9$
    Local local10%
    Local local13%
    catcherrors((((("RenderLoading(" + (Str arg0)) + ", ") + arg1) + ")"))
    local3 = jsongetarraysize(loadingscreens)
    hidepointer()
    If (arg0 = $00) Then
        If (loadingimage = $00) Then
            descriptionindex = $00
            selectedloadingscreens = jsongetarrayvalue(loadingscreens, rand($00, (local3 - $01)))
            loadingscreentitle = jsongetstring(jsongetvalue(selectedloadingscreens, "title"))
            If (jsonisnull(jsongetvalue(selectedloadingscreens, "descriptions")) <> 0) Then
                descriptions = jsongetarray(jsonparsefromstring(((("[" + chr($22)) + chr($22)) + "]")))
            Else
                descriptions = jsongetarray(jsongetvalue(selectedloadingscreens, "descriptions"))
            EndIf
            imagealignx = jsongetstring(jsongetvalue(selectedloadingscreens, "align_x"))
            imagealigny = jsongetstring(jsongetvalue(selectedloadingscreens, "align_y"))
            loadingimage = scaleimageex(loadimage_strict(("GFX\LoadingScreens\" + jsongetstring(jsongetvalue(selectedloadingscreens, "image")))), menuscale, menuscale, $01)
            If (jsongetbool(jsongetvalue(selectedloadingscreens, "background")) <> 0) Then
                If (loadingback = $00) Then
                    loadingback = scaleimageex(loadimage_strict("GFX\LoadingScreens\loading_back.png"), menuscale, menuscale, $01)
                    loadingbackwidth = (imagewidth(loadingback) Sar $01)
                    loadingbackheight = (imageheight(loadingback) Sar $01)
                EndIf
            EndIf
        EndIf
    EndIf
    local2 = $01
    local4 = jsongetarraysize(descriptions)
    local5 = (loadingscreentitle = "CWM")
    Repeat
        clscolor($00, $00, $00)
        cls()
        If (arg0 > $14) Then
            updatemusic()
        EndIf
        If ((Float arg0) > ((100.0 / (Float local4)) * (Float (descriptionindex + $01)))) Then
            descriptionindex = (descriptionindex + $01)
        EndIf
        If (loadingback <> $00) Then
            drawblock(loadingback, (mo\Field9 - loadingbackwidth), (mo\Field10 - loadingbackheight), $00)
        EndIf
        If (imagealignx = "center") Then
            local0 = (mo\Field9 - (imagewidth(loadingimage) Sar $01))
        ElseIf (imagealignx = "right") Then
            local0 = (opt\Field49 - imagewidth(loadingimage))
        Else
            local0 = $00
        EndIf
        If (imagealigny = "center") Then
            local1 = (mo\Field10 - (imageheight(loadingimage) Sar $01))
        ElseIf (imagealigny = "bottom") Then
            local1 = (opt\Field50 - imageheight(loadingimage))
        Else
            local1 = $00
        EndIf
        drawimage(loadingimage, local0, local1, $00)
        local6 = (Int (300.0 * menuscale))
        local7 = (Int (20.0 * menuscale))
        local0 = (mo\Field9 - (local6 Sar $01))
        local1 = (Int ((Float opt\Field50) - (80.0 * menuscale)))
        renderbar(blinkmeterimg, local0, local1, local6, local7, (Float arg0), 100.0, $64, $64, $64)
        color($FF, $FF, $FF)
        setfontex(fo\Field0[$00])
        textex(((local6 Sar $01) + local0), (Int ((Float opt\Field50) - (70.0 * menuscale))), ((Str arg0) + "%"), $01, $01)
        If (local5 <> 0) Then
            If (local2 <> 0) Then
                If (arg0 = $00) Then
                    playsound_strict(loadtempsound("SFX\SCP\990\cwm0.cwm"), $00)
                ElseIf (((arg0 = $64) And (initializeintromovie = $00)) <> 0) Then
                    playsound_strict(loadtempsound("SFX\SCP\990\cwm1.cwm"), $00)
                EndIf
            EndIf
            local9 = ""
            local10 = rand($02, $09)
            For local8 = $00 To local10 Step $01
                local9 = (local9 + chr(rand($30, $7A)))
            Next
            setfontex(fo\Field0[$01])
            textex(mo\Field9, (Int ((Float mo\Field10) - (450.0 * menuscale))), local9, $01, $01)
            If (arg0 = $00) Then
                If (rand($05, $01) = $01) Then
                    Select rand($02, $01)
                        Case $01
                            cwmtext = format(getlocalstring("menu", "happend"), currenttime(), "%s")
                        Case $02
                            cwmtext = currenttime()
                    End Select
                Else
                    Select rand($0D, $01)
                        Case $01
                            cwmtext = getlocalstring("menu", "990_1")
                        Case $02
                            cwmtext = getlocalstring("menu", "990_2")
                        Case $03
                            cwmtext = getlocalstring("menu", "990_3")
                        Case $04
                            cwmtext = "eof9nsd3jue4iwe1fgj"
                        Case $05
                            cwmtext = getlocalstring("menu", "990_4")
                        Case $06
                            cwmtext = getlocalstring("menu", "990_5")
                        Case $07
                            cwmtext = "???____??_???__????n?"
                        Case $08,$09
                            cwmtext = getlocalstring("menu", "990_6")
                        Case $0A
                            cwmtext = "???????????"
                        Case $0B
                            cwmtext = getlocalstring("menu", "990_7")
                        Case $0C
                            cwmtext = getlocalstring("menu", "990_8")
                        Case $0D
                            cwmtext = getlocalstring("menu", "990_9")
                    End Select
                EndIf
            EndIf
            local9 = cwmtext
            local10 = (len(cwmtext) - rand($05, $01))
            For local8 = $00 To rand($0A, $0F) Step $01
                local9 = replace(cwmtext, mid(cwmtext, rand((len(local9) - $01), $01), $01), chr(rand($82, $FA)))
            Next
            setfontex(fo\Field0[$00])
            rowtext(local9, (Int ((Float mo\Field9) - (200.0 * menuscale))), (Int ((Float mo\Field10) + (250.0 * menuscale))), (Int (400.0 * menuscale)), (Int (300.0 * menuscale)), $01, 1.0)
        Else
            color($FF, $FF, $FF)
            setfontex(fo\Field0[$01])
            textex(mo\Field9, (Int ((Float mo\Field10) - (450.0 * menuscale))), loadingscreentitle, $01, $01)
            setfontex(fo\Field0[$00])
            rowtext(jsongetstring(jsongetarrayvalue(descriptions, descriptionindex)), (Int ((Float mo\Field9) - (200.0 * menuscale))), (Int ((Float mo\Field10) + (250.0 * menuscale))), (Int (400.0 * menuscale)), (Int (300.0 * menuscale)), $01, 1.0)
        EndIf
        If (arg0 <> $64) Then
            color($FF, $FF, $FF)
            textex(mo\Field9, (Int ((Float opt\Field50) - (35.0 * menuscale))), format(getlocalstring("loading", "assets"), arg1, "%s"), $01, $01)
            resetinput()
        Else
            If (local5 <> 0) Then
                local9 = getlocalstring("menu", "wakeup")
            Else
                If (local2 <> 0) Then
                    playsound_strict(loadtempsound("SFX\Horror\Horror8.ogg"), $00)
                EndIf
                local9 = getlocalstring("menu", "anykey")
            EndIf
            renderloadingtext(mo\Field9, (Int ((Float opt\Field50) - (35.0 * menuscale))), local9, $01, $01)
        EndIf
        rendergamma()
        flip($01)
        local2 = $00
        If (arg0 <> $64) Then
            Exit
        EndIf
        local13 = $00
        If ((((initializeintromovie And local5) Lor (getkey() <> $00)) Lor mousehit($01)) <> 0) Then
            resetloadingtextcolor()
            resetinput()
            resettimingaccumulator()
            setfontex(fo\Field0[$00])
            local13 = $01
            deletemenugadgets()
            freeimage(loadingimage)
            loadingimage = $00
            freeimage(loadingback)
            loadingback = $00
            loadingbackwidth = $00
            loadingbackheight = $00
            selectedloadingscreens = $00
            descriptions = $00
            descriptionindex = $00
            imagealignx = ""
            imagealigny = ""
        EndIf
    Until (local13 <> 0)
    If ((((initializeintromovie And local5) And opt\Field53) And (arg0 = $64)) <> 0) Then
        stopstream_strict(musicchn)
        musicchn = $00
        playmovie("startup_Intro")
    EndIf
    catcherrors((((("Uncaught: RenderLoading(" + (Str arg0)) + ", ") + arg1) + ")"))
    Return $00
End Function
