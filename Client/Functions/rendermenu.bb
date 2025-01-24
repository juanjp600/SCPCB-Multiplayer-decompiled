Function rendermenu%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10%
    Local local11%
    Local local13%
    Local local14%
    Local local15%
    catcherrors("RenderMenu()")
    If (((infocus() = $00) And (ismultiplayerhudenabled = $00)) <> 0) Then
        menuopen = $01
        If (mp_getsocket() = $00) Then
            pausesounds()
        EndIf
        delay($0A)
    EndIf
    If (menuopen <> 0) Then
        local0 = imagewidth(t\Field1[$00])
        local1 = imageheight(t\Field1[$00])
        local2 = (mo\Field9 - (local0 Sar $01))
        local3 = (mo\Field10 - (local1 Sar $01))
        If (onpalette <> 0) Then
            hidepointer()
        Else
            showpointer()
        EndIf
        drawblock(t\Field1[$00], local2, local3, $00)
        color($FF, $FF, $FF)
        If (igm\Field0 > $00) Then
            local4 = getlocalstring("menu", "achievements")
        ElseIf (igm\Field2 > $00) Then
            If (igm\Field2 = $01) Then
                local4 = getlocalstring("menu", "options")
            ElseIf (igm\Field2 = $02) Then
                local4 = getlocalstring("options", "grap")
            ElseIf (igm\Field2 = $03) Then
                local4 = getlocalstring("options", "audio")
            ElseIf (igm\Field2 = $04) Then
                local4 = getlocalstring("options", "ctrl")
            ElseIf (igm\Field2 = $05) Then
                local4 = getlocalstring("options", "avc")
            ElseIf (igm\Field2 = $06) Then
                local4 = getlocalstring("mpmenu", "opt")
            EndIf
        ElseIf (igm\Field1 > $00) Then
            local4 = getlocalstring("menu", "quit?")
        ElseIf ((((((Int me\Field0) Lor me\Field56) = $00) Lor (me\Field43 <> $FFFFFFFF)) Lor ((Int me\Field0) And mp_terminated\Field0)) <> 0) Then
            local4 = getlocalstring("menu", "paused")
        Else
            local4 = getlocalstring("menu", "died")
        EndIf
        setfontex(fo\Field0[$01])
        textex((Int ((47.0 * menuscale) + (Float ((local0 Sar $01) + local2)))), (Int ((48.0 * menuscale) + (Float local3))), local4, $01, $01)
        setfontex(fo\Field0[$00])
        local2 = (Int ((132.0 * menuscale) + (Float local2)))
        local3 = (Int ((122.0 * menuscale) + (Float local3)))
        If ((((igm\Field0 <= $00) And (igm\Field2 > $00)) And (igm\Field1 <= $00)) <> 0) Then
            If (igm\Field2 > $01) Then
                local6 = (Float (mo\Field9 + (local0 Sar $01)))
                local7 = (Float local3)
                local8 = (400.0 * menuscale)
                local9 = (150.0 * menuscale)
                local10 = (Int (20.0 * menuscale))
                color($FF, $FF, $FF)
                Select igm\Field2
                    Case $02
                        color($64, $64, $64)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "bump"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $00, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "vsync"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $01, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        local11 = ($FF - ((opt\Field48 <> $00) * $9B))
                        color(local11, local11, local11)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "antialias"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $02, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "lights"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $03, 0.0)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "gamma"), $00, $00)
                        If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $01)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $04, opt\Field6)
                        EndIf
                        local3 = (Int ((45.0 * menuscale) + (Float local3)))
                        textex(local2, local3, getlocalstring("options", "particle"), $00, $00)
                        If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (8.0 * menuscale))), (Int ((Float local10) * 5.7)), (Int (18.0 * menuscale))) And (onsliderid = $00)) Lor (onsliderid = $02)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $06, (Float opt\Field0))
                        EndIf
                        local3 = (Int ((45.0 * menuscale) + (Float local3)))
                        textex(local2, local3, getlocalstring("options", "lod"), $00, $00)
                        If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (8.0 * menuscale))), (Int ((Float local10) * 5.7)), (Int (18.0 * menuscale))) And (onsliderid = $00)) Lor (onsliderid = $03)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int ((100.0 * menuscale) + local9)), $05, 0.0)
                        EndIf
                        local3 = (Int ((35.0 * menuscale) + (Float local3)))
                        color($64, $64, $64)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "vram"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $07, 0.0)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "fov"), $00, $00)
                        color($FF, $FF, $00)
                        If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $04)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $08, 0.0)
                        EndIf
                        local3 = (Int ((45.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, local3, getlocalstring("options", "filter"), $00, $00)
                        If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (8.0 * menuscale))), (Int ((Float local10) * 5.7)), (Int (18.0 * menuscale))) And (onsliderid = $00)) Lor (onsliderid = $05)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $09, 0.0)
                        EndIf
                        local3 = (Int ((45.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, local3, getlocalstring("options", "screnderinterval"), $00, $00)
                        If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (8.0 * menuscale))), (Int ((Float local10) * 5.7)), (Int (18.0 * menuscale))) And (onsliderid = $00)) Lor (onsliderid = $11)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0A, 0.0)
                        EndIf
                        rendermenubuttons()
                        rendermenuticks()
                        rendermenuslidebars()
                        rendermenusliders()
                    Case $03
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "mastervolume"), $00, $00)
                        If (((mouseon((Int ((250.0 * menuscale) + (Float local2))), local3, (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $01)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0C, opt\Field17)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "musicvolume"), $00, $00)
                        If (((mouseon((Int ((250.0 * menuscale) + (Float local2))), local3, (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $02)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0D, opt\Field18)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "soundvolume"), $00, $00)
                        If (((mouseon((Int ((250.0 * menuscale) + (Float local2))), local3, (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $03)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0E, opt\Field20)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "voicevolume"), $00, $00)
                        If (((mouseon((Int ((250.0 * menuscale) + (Float local2))), local3, (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $12)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0F, opt\Field21)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        color($64, $64, $64)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "autorelease"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int ((220.0 * menuscale) + local9)), $10, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "trackmode"), $00, $00)
                        If (opt\Field24 = $00) Then
                            local4 = getlocalstring("options", "track.disabled")
                        ElseIf (opt\Field24 = $01) Then
                            local4 = getlocalstring("options", "track.repeat")
                        ElseIf (opt\Field24 = $02) Then
                            local4 = getlocalstring("options", "track.random")
                        EndIf
                        textex((Int ((310.0 * menuscale) + (Float local2))), (Int ((5.0 * menuscale) + (Float local3))), local4, $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $11, 0.0)
                        EndIf
                        If (opt\Field24 > $00) Then
                            If ((mouseon(local2, (Int ((30.0 * menuscale) + (Float local3))), (Int (210.0 * menuscale)), (Int (30.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                                renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $12, 0.0)
                            EndIf
                            local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "subtitles"), $00, $00)
                        If (mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $13, 0.0)
                        EndIf
                        If (opt\Field25 <> 0) Then
                            local3 = (Int ((30.0 * menuscale) + (Float local3)))
                            textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "subtitles.color"), $00, $00)
                            local3 = (Int ((5.0 * menuscale) + (Float local3)))
                            If (mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) <> 0) Then
                                renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                            EndIf
                            If (opt\Field26 <> 0) Then
                                local3 = (Int ((30.0 * menuscale) + (Float local3)))
                                If (mouseon((Int ((227.0 * menuscale) + (Float local2))), local3, (Int (147.0 * menuscale)), (Int (147.0 * menuscale))) <> 0) Then
                                    renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                                EndIf
                                local3 = (Int ((30.0 * menuscale) + (Float local3)))
                                textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "subtitles.color.red"), $00, $00)
                                If (mouseon((Int ((155.0 * menuscale) + (Float local2))), local3, (local10 Shl $01), local10) <> 0) Then
                                    renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                                EndIf
                                local3 = (Int ((30.0 * menuscale) + (Float local3)))
                                textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "subtitles.color.green"), $00, $00)
                                If (mouseon((Int ((155.0 * menuscale) + (Float local2))), local3, (local10 Shl $01), local10) <> 0) Then
                                    renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                                EndIf
                                local3 = (Int ((30.0 * menuscale) + (Float local3)))
                                textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "subtitles.color.blue"), $00, $00)
                                If (mouseon((Int ((155.0 * menuscale) + (Float local2))), local3, (local10 Shl $01), local10) <> 0) Then
                                    renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                                EndIf
                            EndIf
                        EndIf
                        rendermenubuttons()
                        rendermenuticks()
                        rendermenuslidebars()
                        rendermenuinputboxes()
                        rendermenupalettes()
                    Case $04
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "mousesensitive"), $00, $00)
                        If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $01)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $15, opt\Field45)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "mousesmooth"), $00, $00)
                        If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $02)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $16, opt\Field42)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "invertx"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $17, 0.0)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "inverty"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $18, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("menu", "controlconfig"), $00, $00)
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.forward"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.left"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.backward"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.right"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.sprint"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.crouch"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.blink"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.inv"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.save"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.screenshot"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.lean.left"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.lean.right"), $00, $00)
                        If (opt\Field31 <> 0) Then
                            local3 = (Int ((20.0 * menuscale) + (Float local3)))
                            textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "key.console"), $00, $00)
                        EndIf
                        If (mouseon(local2, (Int ((Float local3) - ((Float ((opt\Field31 * $14) + $8C)) * menuscale))), (Int (380.0 * menuscale)), (Int ((Float ((opt\Field31 * $14) + $F0)) * menuscale))) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $19, 0.0)
                        EndIf
                        rendermenubuttons()
                        rendermenuticks()
                        rendermenuinputboxes()
                        rendermenuslidebars()
                    Case $05
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "hud"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1A, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "console"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1B, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        If (opt\Field31 <> 0) Then
                            textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "error"), $00, $00)
                            If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                                renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1C, 0.0)
                            EndIf
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "achipop"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1D, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        local11 = ($FF - ((selecteddifficulty\Field3 <> $00) * $9B))
                        color(local11, local11, local11)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "save"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $20, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "fps"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1E, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "frame"), $00, $00)
                        If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1F, (Float opt\Field35))
                        EndIf
                        If (0.0 < opt\Field36) Then
                            color($FF, $FF, $00)
                            textex(local2, (Int ((45.0 * menuscale) + (Float local3))), ((Str opt\Field35) + " FPS"), $00, $00)
                            If (((mouseon((Int ((150.0 * menuscale) + (Float local2))), (Int ((40.0 * menuscale) + (Float local3))), (Int ((Float local10) * 5.7)), local10) And (onsliderid = $00)) Lor (onsliderid = $01)) <> 0) Then
                                renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1F, (Float opt\Field35))
                            EndIf
                            rendermenusliders()
                            local3 = (Int ((50.0 * menuscale) + (Float local3)))
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "bar"), $00, $00)
                        If (mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $21, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "vignette"), $00, $00)
                        If (mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $22, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "startvideo"), $00, $00)
                        If (mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $23, 0.0)
                        EndIf
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("options", "launcher"), $00, $00)
                        If (mouseon((Int ((270.0 * menuscale) + (Float local2))), local3, local10, local10) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $24, 0.0)
                        EndIf
                        local3 = (Int ((40.0 * menuscale) + (Float local3)))
                        If (mouseon(local2, local3, (Int (195.0 * menuscale)), (Int (30.0 * menuscale))) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $25, 0.0)
                        EndIf
                        rendermenubuttons()
                        rendermenuticks()
                        rendermenuslidebars()
                        rendermenuinputboxes()
                    Case $06
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("menu", "controlconfig"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("mpoptions", "voice"), $00, $00)
                        local3 = (Int ((20.0 * menuscale) + (Float local3)))
                        textex(local2, (Int ((5.0 * menuscale) + (Float local3))), getlocalstring("mpoptions", "chat"), $00, $00)
                        rendermenubuttons()
                        rendermenuticks()
                        rendermenuinputboxes()
                        rendermenuslidebars()
                End Select
            Else
                rendermenubuttons()
            EndIf
        ElseIf ((((igm\Field0 <= $00) And (igm\Field2 <= $00)) And (igm\Field1 > $00)) <> 0) Then
            rendermenubuttons()
        ElseIf ((((igm\Field0 > $00) And (igm\Field2 <= $00)) And (igm\Field1 <= $00)) <> 0) Then
            rendermenubuttons()
            If (igm\Field0 > $00) Then
                local13 = jsongetarray(jsongetvalue(achievementsarray, "achievements"))
                local14 = (Int ((22.0 * menuscale) + (Float local2)))
                local15 = (Int (101.0 * menuscale))
                For local5 = $00 To $0B Step $01
                    If ((((igm\Field0 - $01) * $0C) + local5) < s2imapsize(achievementsindex)) Then
                        renderachvimg(local14, (Int (((Float ((local5 Sar $02) * $78)) * menuscale) + (Float local3))), local5, jsongetstring(jsongetvalue(jsongetarrayvalue(local13, (((igm\Field0 - $01) * $0C) + local5)), "id")))
                    Else
                        Exit
                    EndIf
                Next
                For local5 = $00 To $0B Step $01
                    If ((((igm\Field0 - $01) * $0C) + local5) < s2imapsize(achievementsindex)) Then
                        If (mouseon((((local5 Mod $04) * local15) + local14), (Int (((Float ((local5 Sar $02) * $78)) * menuscale) + (Float local3))), (Int (85.0 * menuscale)), (Int (85.0 * menuscale))) <> 0) Then
                            achievementtooltip(jsongetstring(jsongetvalue(jsongetarrayvalue(local13, (((igm\Field0 - $01) * $0C) + local5)), "id")))
                            Exit
                        EndIf
                    Else
                        Exit
                    EndIf
                Next
            EndIf
        Else
            rendermenubuttons()
            setfontex(fo\Field0[$00])
            textex(local2, local3, (getlocalstring("menu", "new.diff") + selecteddifficulty\Field0), $00, $00)
            If (((currsave = Null) Lor (currsave\Field0 = "")) <> 0) Then
                local4 = getlocalstring("menu", "dataredacted")
            Else
                local4 = converttoutf8(currsave\Field0)
            EndIf
            textex(local2, (Int ((20.0 * menuscale) + (Float local3))), format(getlocalstring("menu", "save"), local4, "%s"), $00, $00)
            If (selectedcustommap = Null) Then
                local4 = format(getlocalstring("menu", "new.seed2"), randomseed, "%s")
            ElseIf (len(converttoutf8(selectedcustommap\Field0)) > $0F) Then
                local4 = format(getlocalstring("menu", "new.map"), (left(converttoutf8(selectedcustommap\Field0), $0E) + ".."), "%s")
            Else
                local4 = format(getlocalstring("menu", "new.map"), converttoutf8(selectedcustommap\Field0), "%s")
            EndIf
            textex(local2, (Int ((40.0 * menuscale) + (Float local3))), local4, $00, $00)
            If (((((Int me\Field0) Lor me\Field56) And (me\Field43 = $FFFFFFFF)) And (((Int me\Field0) And mp_terminated\Field0) = $00)) <> 0) Then
                local3 = (Int ((175.0 * menuscale) + (Float local3)))
                If (selecteddifficulty\Field3 < $02) Then
                    local3 = (Int ((75.0 * menuscale) + (Float local3)))
                EndIf
                setfontex(fo\Field0[$00])
                rowtext(msg\Field2, local2, local3, (Int (430.0 * menuscale)), (Int (600.0 * menuscale)), $00, 1.0)
            EndIf
        EndIf
        rendercursor()
    EndIf
    setfontex(fo\Field0[$00])
    catcherrors("Uncaught: RenderMenu()")
    Return $00
End Function
