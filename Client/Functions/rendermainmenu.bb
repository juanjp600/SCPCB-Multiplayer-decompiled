Function rendermainmenu%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10$
    Local local11$
    Local local12$
    Local local13%
    Local local17.mp_listserver
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    Local local33%
    catcherrors("RenderMainMenu()")
    If (onpalette = $00) Then
        showpointer()
    Else
        hidepointer()
    EndIf
    drawblock(mma\Field0, $00, $00, $00)
    If ((Float rand((Int mm\Field1[$00]), $01)) <= ((Float millisec) Mod mm\Field0[$00])) Then
        drawblock(mma\Field2, (opt\Field46 - imagewidth(mma\Field2)), (opt\Field47 - imageheight(mma\Field2)), $00)
    EndIf
    setfontex(fo\Field0[$00])
    If (mm\Field1[$01] > mm\Field0[$01]) Then
        color($32, $32, $32)
        textex((mm\Field3 + rand($FFFFFFFB, $05)), (mm\Field4 + rand($FFFFFFFB, $05)), mm\Field2, $01, $00)
        If (0.0 > mm\Field0[$01]) Then
            mm\Field0[$01] = rnd(700.0, 800.0)
            mm\Field1[$01] = rnd(10.0, 35.0)
            mm\Field3 = (Int ((Float rand($2BC, $3E8)) * menuscale))
            mm\Field4 = (Int ((Float rand($64, $258)) * menuscale))
            Select rand($00, $17)
                Case $00,$02,$03
                    mm\Field2 = getlocalstring("menu", "dontblink")
                Case $04,$05
                    mm\Field2 = getlocalstring("menu", "scp")
                Case $06,$07,$08
                    mm\Field2 = getlocalstring("menu", "happyending")
                Case $09,$0A,$0B
                    mm\Field2 = getlocalstring("menu", "scream")
                Case $0C,$13
                    mm\Field2 = getlocalstring("menu", "nil")
                Case $0D
                    mm\Field2 = getlocalstring("menu", "menuno")
                Case $0E
                    mm\Field2 = getlocalstring("menu", "bwg")
                Case $0F
                    mm\Field2 = getlocalstring("menu", "173care")
                Case $10
                    mm\Field2 = getlocalstring("menu", "9341")
                Case $11
                    mm\Field2 = getlocalstring("menu", "079doors")
                Case $12
                    mm\Field2 = getlocalstring("menu", "???")
                Case $14
                    mm\Field2 = getlocalstring("menu", "079king")
                Case $15
                    mm\Field2 = getlocalstring("menu", "spiral")
                Case $16
                    mm\Field2 = getlocalstring("menu", "damage")
                Case $17
                    mm\Field2 = getlocalstring("menu", "howl")
            End Select
        EndIf
    EndIf
    setfontex(fo\Field0[$01])
    drawblock(mma\Field1, (mo\Field9 - (imagewidth(mma\Field1) Sar $01)), (Int (((Float opt\Field47) - (20.0 * menuscale)) - (Float imageheight(mma\Field1)))), $00)
    If (opt\Field46 > $4D8) Then
        rendertiledimagerect(menuwhite, $00, (Int (5.0 * menuscale)), (Int (512.0 * menuscale)), (Int (5.0 * menuscale)), (Int (985.0 * menuscale)), (Int (407.0 * menuscale)), (Int ((Float opt\Field46) - (940.0 * menuscale))), (Int (5.0 * menuscale)))
    EndIf
    If (mm\Field5 <> $00) Then
        local0 = (Int (159.0 * menuscale))
        local1 = (Int (286.0 * menuscale))
        local2 = (Int (400.0 * menuscale))
        local3 = (Int (70.0 * menuscale))
        Select mm\Field5
            Case $01
                local2 = (Int (900.0 * menuscale))
                local10 = getlocalstring("mpmenu", "serverlist")
            Case $03
                local10 = getlocalstring("menu", "new")
            Case $02
                local10 = getlocalstring("mpmenu", "hostserver")
            Case $04
                local10 = getlocalstring("menu", "load")
            Case $05
                local10 = getlocalstring("menu", "loadmap")
            Case $06
                local10 = getlocalstring("menu", "options")
            Case $07
                local10 = getlocalstring("options", "grap")
            Case $08
                local10 = getlocalstring("options", "audio")
            Case $09
                local10 = getlocalstring("options", "ctrl")
            Case $0A
                local10 = getlocalstring("options", "avc")
            Case $0B
                local10 = getlocalstring("mpmenu", "opt")
        End Select
        renderframe(local0, local1, local2, local3, $00, $00, $00)
        color($FF, $FF, $FF)
        setfontex(fo\Field0[$01])
        textex(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), local10, $01, $01)
        local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
        local2 = (Int (580.0 * menuscale))
        If (mm\Field5 < $07) Then
            Select mm\Field5
                Case $01
                    local3 = (Int (415.0 * menuscale))
                    local2 = (Int (1080.0 * menuscale))
                    renderframe(local0, local1, local2, local3, $00, $00, $00)
                    local1 = (Int ((Float local1) - (4.0 * menuscale)))
                    For local17 = Each mp_listserver
                        If (local17\Field10 = serverlist\Field4) Then
                            If (local17\Field13 <> Null) Then
                                rendermenubutton(local17\Field13)
                            EndIf
                        EndIf
                    Next
                    local18 = (Float local0)
                    local18 = (((Float local2) * 0.0215) + local18)
                    local18 = (((Float local2) * 0.5457) + local18)
                    local18 = (((Float local2) * 0.18) + local18)
                    local18 = (((Float local2) * 0.13) + local18)
                    local18 = (((Float local2) * 0.1013) + local18)
                    renderframe((Int (local18 - (8.0 * menuscale))), (Int (((25.0 * menuscale) + (Float local1)) - (4.0 * menuscale))), (Int (((Float local2) * 0.0215) + (8.0 * menuscale))), local3, $00, $00, $00)
                    color($32, $32, $32)
                    local19 = ((30.0 * menuscale) - (4.0 * menuscale))
                    local21 = ((Float local3) - (73.0 * menuscale))
                    local22 = 1.0
                    For local5 = $00 To $3E7 Step $01
                        local20 = (local20 + local19)
                        If (listservers[local5] = Null) Then
                            Exit
                        EndIf
                    Next
                    local22 = min((local21 / local20), 1.0)
                    rect((Int ((Float (Int (local18 - (8.0 * menuscale)))) + (3.0 * menuscale))), (Int ((((50.0 * menuscale) + (Float local1)) + (serverlist\Field8 * local22)) - (6.0 * menuscale))), (Int ((Float (Int (((Float local2) * 0.0215) + (8.0 * menuscale)))) - (6.0 * menuscale))), (Int (local21 * local22)), $01)
                    setfontex(fo\Field0[$00])
                Case $02
                    local3 = (Int (405.0 * menuscale))
                    renderframe(local0, local1, local2, local3, $00, $00, $00)
                    setfontex(fo\Field0[$00])
                    color($FF, $FF, $FF)
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((25.0 * menuscale) + (Float local1))), format(getlocalstring("mpmenu", "new.hostname"), "", "%s"), $00, $00)
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((65.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.seed2"), "", "%s"), $00, $00)
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((105.0 * menuscale) + (Float local1))), getlocalstring("mpmenu", "new.serverport"), $00, $00)
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), getlocalstring("mpmenu", "new.console"), $00, $00)
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((185.0 * menuscale) + (Float local1))), getlocalstring("menu", "new.diff"), $00, $00)
                    For local5 = $00 To $04 Step $01
                        color(difficulties[local5]\Field6, difficulties[local5]\Field7, difficulties[local5]\Field8)
                        textex((Int ((50.0 * menuscale) + (Float local0))), (Int (((Float (($1E * local5) + $E1)) * menuscale) + (Float local1))), difficulties[local5]\Field0, $00, $00)
                    Next
                    color($FF, $FF, $FF)
                    renderframe((Int ((150.0 * menuscale) + (Float local0))), (Int ((210.0 * menuscale) + (Float local1))), (Int (410.0 * menuscale)), (Int (160.0 * menuscale)), $00, $00, $00)
                    If (selecteddifficulty\Field5 <> 0) Then
                        Select selecteddifficulty\Field3
                            Case $00
                                local10 = getlocalstring("menu", "new.saveany")
                            Case $01
                                local10 = getlocalstring("menu", "new.savescreen")
                            Case $02
                                local10 = getlocalstring("menu", "new.savequit")
                            Case $03
                                local10 = getlocalstring("menu", "new.saveno")
                        End Select
                        textex((Int ((200.0 * menuscale) + (Float local0))), (Int ((226.0 * menuscale) + (Float local1))), (getlocalstring("menu", "new.savetype") + local10), $00, $00)
                        textex((Int ((200.0 * menuscale) + (Float local0))), (Int ((255.0 * menuscale) + (Float local1))), getlocalstring("menu", "new.dangernpc"), $00, $00)
                        textex((Int ((200.0 * menuscale) + (Float local0))), (Int ((286.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.invslots"), (Str selecteddifficulty\Field9), "%s"), $00, $00)
                        Select selecteddifficulty\Field4
                            Case $00
                                local10 = getlocalstring("menu", "new.easy")
                            Case $01
                                local10 = getlocalstring("menu", "new.normal")
                            Case $02
                                local10 = getlocalstring("menu", "new.hard")
                            Case $03
                                local10 = getlocalstring("menu", "new.extreme")
                        End Select
                        textex((Int ((200.0 * menuscale) + (Float local0))), (Int ((336.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.factors"), local10, "%s"), $00, $00)
                    Else
                        rowtext(selecteddifficulty\Field1, (Int ((160.0 * menuscale) + (Float local0))), (Int ((220.0 * menuscale) + (Float local1))), (Int (390.0 * menuscale)), (Int (140.0 * menuscale)), $00, 1.0)
                        renderframe((Int ((590.0 * menuscale) + (Float local0))), (Int ((90.0 * menuscale) + (Float local1))), (Int (350.0 * menuscale)), (Int (90.0 * menuscale)), $00, $00, $00)
                        Select selecteddifficulty\Field3
                            Case $00
                                local10 = getlocalstring("menu", "new.saveany")
                            Case $01
                                local10 = getlocalstring("menu", "new.savescreen")
                            Case $02
                                local10 = getlocalstring("menu", "new.savequit")
                            Case $03
                                local10 = getlocalstring("menu", "new.saveno")
                        End Select
                        textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((98.0 * menuscale) + (Float local1))), (getlocalstring("menu", "new.savetype") + local10), $00, $00)
                        Select selecteddifficulty\Field2
                            Case $00
                                local10 = getlocalstring("menu", "no")
                            Case $01
                                local10 = getlocalstring("menu", "yes")
                        End Select
                        textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((114.0 * menuscale) + (Float local1))), ((getlocalstring("menu", "new.dangernpc") + ": ") + local10), $00, $00)
                        textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((130.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.invslots"), (Str selecteddifficulty\Field9), "%s"), $00, $00)
                        Select selecteddifficulty\Field4
                            Case $00
                                local10 = getlocalstring("menu", "new.easy")
                            Case $01
                                local10 = getlocalstring("menu", "new.normal")
                            Case $02
                                local10 = getlocalstring("menu", "new.hard")
                            Case $03
                                local10 = getlocalstring("menu", "new.extreme")
                        End Select
                        textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((146.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.factors"), local10, "%s"), $00, $00)
                        If (selecteddifficulty\Field0 = difficulties[$03]\Field0) Then
                            textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((162.0 * menuscale) + (Float local1))), getlocalstring("menu", "nohud"), $00, $00)
                        EndIf
                    EndIf
                    setfontex(fo\Field0[$01])
                Case $03
                    local3 = (Int (345.0 * menuscale))
                    renderframe(local0, local1, local2, local3, $00, $00, $00)
                    setfontex(fo\Field0[$00])
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((25.0 * menuscale) + (Float local1))), getlocalstring("menu", "new.name"), $00, $00)
                    If (selectedcustommap = Null) Then
                        local10 = format(getlocalstring("menu", "new.seed2"), "", "%s")
                    Else
                        local10 = format(getlocalstring("menu", "new.map"), "", "%s")
                        renderframe((Int ((150.0 * menuscale) + (Float local0))), (Int ((55.0 * menuscale) + (Float local1))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), (local0 Mod $100), (local1 Mod $100), $01)
                        color($FF, $00, $00)
                        local12 = converttoutf8(selectedcustommap\Field0)
                        If (len(local12) > $0F) Then
                            local11 = (left(local12, $0E) + "..")
                        Else
                            local11 = local12
                        EndIf
                        textex((Int ((250.0 * menuscale) + (Float local0))), (Int ((70.0 * menuscale) + (Float local1))), local11, $01, $01)
                    EndIf
                    color($FF, $FF, $FF)
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((65.0 * menuscale) + (Float local1))), local10, $00, $00)
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((115.0 * menuscale) + (Float local1))), getlocalstring("menu", "new.intro"), $00, $00)
                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((155.0 * menuscale) + (Float local1))), getlocalstring("menu", "new.diff"), $00, $00)
                    For local5 = $00 To $04 Step $01
                        color(difficulties[local5]\Field6, difficulties[local5]\Field7, difficulties[local5]\Field8)
                        textex((Int ((50.0 * menuscale) + (Float local0))), (Int (((Float (($1E * local5) + $B9)) * menuscale) + (Float local1))), difficulties[local5]\Field0, $00, $00)
                    Next
                    color($FF, $FF, $FF)
                    renderframe((Int ((150.0 * menuscale) + (Float local0))), (Int ((170.0 * menuscale) + (Float local1))), (Int (410.0 * menuscale)), (Int (160.0 * menuscale)), $00, $00, $00)
                    If (selecteddifficulty\Field5 <> 0) Then
                        Select selecteddifficulty\Field3
                            Case $00
                                local10 = getlocalstring("menu", "new.saveany")
                            Case $01
                                local10 = getlocalstring("menu", "new.savescreen")
                            Case $02
                                local10 = getlocalstring("menu", "new.savequit")
                            Case $03
                                local10 = getlocalstring("menu", "new.saveno")
                        End Select
                        textex((Int ((200.0 * menuscale) + (Float local0))), (Int ((186.0 * menuscale) + (Float local1))), (getlocalstring("menu", "new.savetype") + local10), $00, $00)
                        textex((Int ((200.0 * menuscale) + (Float local0))), (Int ((215.0 * menuscale) + (Float local1))), getlocalstring("menu", "new.dangernpc"), $00, $00)
                        textex((Int ((200.0 * menuscale) + (Float local0))), (Int ((246.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.invslots"), (Str selecteddifficulty\Field9), "%s"), $00, $00)
                        Select selecteddifficulty\Field4
                            Case $00
                                local10 = getlocalstring("menu", "new.easy")
                            Case $01
                                local10 = getlocalstring("menu", "new.normal")
                            Case $02
                                local10 = getlocalstring("menu", "new.hard")
                            Case $03
                                local10 = getlocalstring("menu", "new.extreme")
                        End Select
                        textex((Int ((200.0 * menuscale) + (Float local0))), (Int ((276.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.factors"), local10, "%s"), $00, $00)
                    Else
                        rowtext(selecteddifficulty\Field1, (Int ((160.0 * menuscale) + (Float local0))), (Int ((180.0 * menuscale) + (Float local1))), (Int (390.0 * menuscale)), (Int (140.0 * menuscale)), $00, 1.0)
                        renderframe((Int ((590.0 * menuscale) + (Float local0))), (Int ((50.0 * menuscale) + (Float local1))), (Int (350.0 * menuscale)), (Int (90.0 * menuscale)), $00, $00, $00)
                        Select selecteddifficulty\Field3
                            Case $00
                                local10 = getlocalstring("menu", "new.saveany")
                            Case $01
                                local10 = getlocalstring("menu", "new.savescreen")
                            Case $02
                                local10 = getlocalstring("menu", "new.savequit")
                            Case $03
                                local10 = getlocalstring("menu", "new.saveno")
                        End Select
                        textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((58.0 * menuscale) + (Float local1))), (getlocalstring("menu", "new.savetype") + local10), $00, $00)
                        Select selecteddifficulty\Field2
                            Case $00
                                local10 = getlocalstring("menu", "no")
                            Case $01
                                local10 = getlocalstring("menu", "yes")
                        End Select
                        textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((74.0 * menuscale) + (Float local1))), ((getlocalstring("menu", "new.dangernpc") + ": ") + local10), $00, $00)
                        textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((90.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.invslots"), (Str selecteddifficulty\Field9), "%s"), $00, $00)
                        Select selecteddifficulty\Field4
                            Case $00
                                local10 = getlocalstring("menu", "new.easy")
                            Case $01
                                local10 = getlocalstring("menu", "new.normal")
                            Case $02
                                local10 = getlocalstring("menu", "new.hard")
                            Case $03
                                local10 = getlocalstring("menu", "new.extreme")
                        End Select
                        textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((106.0 * menuscale) + (Float local1))), format(getlocalstring("menu", "new.factors"), local10, "%s"), $00, $00)
                        If (selecteddifficulty\Field0 = difficulties[$03]\Field0) Then
                            textex((Int ((600.0 * menuscale) + (Float local0))), (Int ((122.0 * menuscale) + (Float local1))), getlocalstring("menu", "nohud"), $00, $00)
                        EndIf
                    EndIf
                    setfontex(fo\Field0[$01])
                Case $04
                    local3 = (Int (430.0 * menuscale))
                    renderframe(local0, local1, local2, local3, $00, $00, $00)
                    local1 = (Int (376.0 * menuscale))
                    local3 = (Int (296.0 * menuscale))
                    setfontex(fo\Field0[$01])
                    renderframe((Int ((60.0 * menuscale) + (Float local0))), (Int ((440.0 * menuscale) + (Float local1))), (Int ((Float local2) - (120.0 * menuscale))), (Int (50.0 * menuscale)), $00, $00, $00)
                    textex(((local2 Sar $01) + local0), (Int ((465.0 * menuscale) + (Float local1))), format(format(getlocalstring("menu", "page"), (Str (Int max((Float (mm\Field7 + $01)), 1.0))), "{0}"), (Str (Int max((Float (Int ceil(((Float savedgamesamount) / 5.0)))), 1.0))), "{1}"), $01, $01)
                    setfontex(fo\Field0[$00])
                    If (savedgamesamount = $00) Then
                        rowtext(getlocalstring("menu", "save.nosaves"), (Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (540.0 * menuscale)), (Int (390.0 * menuscale)), $00, 1.0)
                    Else
                        local0 = (Int ((20.0 * menuscale) + (Float local0)))
                        local1 = (Int ((20.0 * menuscale) + (Float local1)))
                        currsave = (First save)
                        For local5 = $00 To ((mm\Field7 * $05) + $04) Step $01
                            If (local5 > $00) Then
                                currsave = (After currsave)
                            EndIf
                            If (currsave = Null) Then
                                Exit
                            EndIf
                            If (local5 >= (mm\Field7 * $05)) Then
                                renderframe(local0, local1, (Int (540.0 * menuscale)), (Int (70.0 * menuscale)), $00, $00, $00)
                                local13 = ($FF - ((currsave\Field3 <> "1.5") * $FF))
                                color($FF, local13, local13)
                                local12 = converttoutf8(currsave\Field0)
                                If (len(local12) > $0A) Then
                                    local11 = (left(local12, $09) + "..")
                                Else
                                    local11 = local12
                                EndIf
                                textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), local11, $00, $00)
                                If (len(currsave\Field4) > $10) Then
                                    local11 = (left(currsave\Field4, $0F) + "..")
                                Else
                                    local11 = currsave\Field4
                                EndIf
                                textex((Int ((150.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), local11, $00, $00)
                                textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), currsave\Field1, $00, $00)
                                textex((Int ((150.0 * menuscale) + (Float local0))), (Int ((30.0 * menuscale) + (Float local1))), currsave\Field2, $00, $00)
                                textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((50.0 * menuscale) + (Float local1))), ("v" + currsave\Field3), $00, $00)
                                If (currsave\Field3 <> "1.5") Then
                                    color($FF, $00, $00)
                                Else
                                    For local4 = $00 To $04 Step $01
                                        If (currsave\Field5 = difficulties[local4]\Field0) Then
                                            color(difficulties[local4]\Field6, difficulties[local4]\Field7, difficulties[local4]\Field8)
                                            Exit
                                        EndIf
                                    Next
                                EndIf
                                textex((Int ((150.0 * menuscale) + (Float local0))), (Int ((50.0 * menuscale) + (Float local1))), currsave\Field5, $00, $00)
                                If (currsave = (Last save)) Then
                                    Exit
                                EndIf
                                local1 = (Int ((80.0 * menuscale) + (Float local1)))
                            EndIf
                        Next
                        color($FF, $FF, $FF)
                        If (delsave <> Null) Then
                            local0 = (Int (739.0 * menuscale))
                            local1 = (Int (376.0 * menuscale))
                            renderframe(local0, local1, (Int (420.0 * menuscale)), (Int (200.0 * menuscale)), $00, $00, $00)
                            rowtext(getlocalstring("menu", "save.delete?"), (Int ((20.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), $00, 1.0)
                        EndIf
                    EndIf
                Case $05
                    local3 = (Int (430.0 * menuscale))
                    renderframe(local0, local1, local2, local3, $00, $00, $00)
                    local1 = (Int (376.0 * menuscale))
                    local3 = (Int (350.0 * menuscale))
                    setfontex(fo\Field0[$01])
                    local6 = (Float (local0 + local2))
                    local7 = (Float local1)
                    local8 = (400.0 * menuscale)
                    local9 = (150.0 * menuscale)
                    renderframe((Int ((60.0 * menuscale) + (Float local0))), (Int ((440.0 * menuscale) + (Float local1))), (Int ((Float local2) - (120.0 * menuscale))), (Int (50.0 * menuscale)), $00, $00, $00)
                    textex(((local2 Sar $01) + local0), (Int ((465.0 * menuscale) + (Float local1))), format(format(getlocalstring("menu", "page"), (Str (Int max((Float (mm\Field7 + $01)), 1.0))), "{0}"), (Str (Int max((Float (Int ceil(((Float custommapsamount) / 5.0)))), 1.0))), "{1}"), $01, $01)
                    setfontex(fo\Field0[$00])
                    If (custommapsamount = $00) Then
                        rowtext(getlocalstring("menu", "nomap"), (Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (540.0 * menuscale)), (Int (390.0 * menuscale)), $00, 1.0)
                    Else
                        local0 = (Int ((20.0 * menuscale) + (Float local0)))
                        local1 = (Int ((20.0 * menuscale) + (Float local1)))
                        currcustommap = (First custommaps)
                        For local5 = $00 To ((mm\Field7 * $05) + $04) Step $01
                            If (local5 > $00) Then
                                currcustommap = (After currcustommap)
                            EndIf
                            If (currcustommap = Null) Then
                                Exit
                            EndIf
                            If (local5 >= (mm\Field7 * $05)) Then
                                renderframe(local0, local1, (Int (540.0 * menuscale)), (Int (70.0 * menuscale)), $00, $00, $00)
                                local12 = converttoutf8(currcustommap\Field0)
                                If (len(local12) > $14) Then
                                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (left(local12, $13) + ".."), $00, $00)
                                Else
                                    textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), local12, $00, $00)
                                EndIf
                                textex((Int ((20.0 * menuscale) + (Float local0))), (Int ((45.0 * menuscale) + (Float local1))), converttoutf8(currcustommap\Field1), $00, $00)
                                If ((mouseon((Int ((280.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale))) Lor mouseon((Int ((400.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)))) <> 0) Then
                                    rendermapcreatortooltip((Int local6), (Int local7), (Int local8), (Int local9), currcustommap\Field0)
                                EndIf
                                If (currcustommap = (Last custommaps)) Then
                                    Exit
                                EndIf
                                local1 = (Int ((80.0 * menuscale) + (Float local1)))
                            EndIf
                        Next
                        If (delcustommap <> Null) Then
                            local0 = (Int (739.0 * menuscale))
                            local1 = (Int (376.0 * menuscale))
                            renderframe(local0, local1, (Int (420.0 * menuscale)), (Int (200.0 * menuscale)), $00, $00, $00)
                            rowtext(getlocalstring("menu", "map.delete?"), (Int ((20.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), $00, 1.0)
                        EndIf
                    EndIf
                Case $06
                    local3 = (Int (380.0 * menuscale))
                    renderframe(local0, local1, local2, local3, $00, $00, $00)
            End Select
        Else
            local0 = (Int ((20.0 * menuscale) + (Float local0)))
            local6 = (((Float local0) - (20.0 * menuscale)) + (Float local2))
            local7 = (Float local1)
            local8 = (400.0 * menuscale)
            local9 = (150.0 * menuscale)
            local33 = (Int (20.0 * menuscale))
            Select mm\Field5
                Case $07
                    local3 = (Int (455.0 * menuscale))
                    renderframe((Int ((Float local0) - (20.0 * menuscale))), local1, local2, local3, $00, $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    setfontex(fo\Field0[$00])
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "bump"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $00, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "vsync"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $01, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    local13 = ($FF - ((opt\Field48 <> $00) * $9B))
                    color(local13, local13, local13)
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "antialias"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $02, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "lights"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $03, 0.0)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "gamma"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $01)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $04, opt\Field6)
                    EndIf
                    local1 = (Int ((45.0 * menuscale) + (Float local1)))
                    textex(local0, local1, getlocalstring("options", "particle"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), (Int ((Float local1) - (8.0 * menuscale))), (Int ((Float local33) * 8.2)), (Int (18.0 * menuscale))) And (onsliderid = $00)) Lor (onsliderid = $02)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $06, (Float opt\Field0))
                    EndIf
                    local1 = (Int ((45.0 * menuscale) + (Float local1)))
                    textex(local0, local1, getlocalstring("options", "lod"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), (Int ((Float local1) - (8.0 * menuscale))), (Int ((Float local33) * 8.2)), (Int (18.0 * menuscale))) And (onsliderid = $00)) Lor (onsliderid = $03)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int ((100.0 * menuscale) + local9)), $05, 0.0)
                    EndIf
                    local1 = (Int ((35.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "vram"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $07, 0.0)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "fov"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $04)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $08, 0.0)
                    EndIf
                    local1 = (Int ((45.0 * menuscale) + (Float local1)))
                    textex(local0, local1, getlocalstring("options", "filter"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), (Int ((Float local1) - (8.0 * menuscale))), (Int ((Float local33) * 8.2)), (Int (18.0 * menuscale))) And (onsliderid = $00)) Lor (onsliderid = $05)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $09, 0.0)
                    EndIf
                    local1 = (Int ((45.0 * menuscale) + (Float local1)))
                    textex(local0, local1, getlocalstring("options", "screnderinterval"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), (Int ((Float local1) - (8.0 * menuscale))), (Int ((Float local33) * 8.2)), (Int (18.0 * menuscale))) And (onsliderid = $00)) Lor (onsliderid = $11)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0A, 0.0)
                    EndIf
                Case $08
                    local3 = (Int ((Float (((((opt\Field24 > $00) * $28) + $118) + (opt\Field25 * $1E)) + ((opt\Field25 And opt\Field26) * $9B))) * menuscale))
                    renderframe((Int ((Float local0) - (20.0 * menuscale))), local1, local2, local3, $00, $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    setfontex(fo\Field0[$00])
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "mastervolume"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $01)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0C, opt\Field17)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "musicvolume"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $02)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0D, opt\Field18)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "soundvolume"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $03)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0E, opt\Field20)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "voicevolume"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $12)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $0F, opt\Field21)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "autorelease"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int ((220.0 * menuscale) + local9)), $10, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "trackmode"), $00, $00)
                    If (opt\Field24 = $00) Then
                        local10 = getlocalstring("options", "track.disabled")
                    ElseIf (opt\Field24 = $01) Then
                        local10 = getlocalstring("options", "track.repeat")
                    ElseIf (opt\Field24 = $02) Then
                        local10 = getlocalstring("options", "track.random")
                    EndIf
                    textex((Int ((330.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), local10, $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $11, 0.0)
                    EndIf
                    If (opt\Field24 > $00) Then
                        If ((mouseon(local0, (Int ((30.0 * menuscale) + (Float local1))), (Int (210.0 * menuscale)), (Int (30.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $12, 0.0)
                        EndIf
                        If (usertrackcheck > $00) Then
                            textex((Int ((240.0 * menuscale) + (Float local0))), (Int ((40.0 * menuscale) + (Float local1))), format(format(getlocalstring("options", "track.found"), (Str usertrackcheck2), "{0}"), (Str usertrackcheck), "{1}"), $00, $00)
                        EndIf
                        local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "subtitles"), $00, $00)
                    If (mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $13, 0.0)
                    EndIf
                    If (opt\Field25 <> 0) Then
                        local1 = (Int ((30.0 * menuscale) + (Float local1)))
                        textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "subtitles.color"), $00, $00)
                        local1 = (Int ((5.0 * menuscale) + (Float local1)))
                        If (mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                        EndIf
                        If (opt\Field26 <> 0) Then
                            local1 = (Int ((30.0 * menuscale) + (Float local1)))
                            If (mouseon((Int ((227.0 * menuscale) + (Float local0))), local1, (Int (147.0 * menuscale)), (Int (147.0 * menuscale))) <> 0) Then
                                renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                            EndIf
                            local1 = (Int ((30.0 * menuscale) + (Float local1)))
                            textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "subtitles.color.red"), $00, $00)
                            If (mouseon((Int ((155.0 * menuscale) + (Float local0))), local1, (local33 Shl $01), local33) <> 0) Then
                                renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                            EndIf
                            local1 = (Int ((30.0 * menuscale) + (Float local1)))
                            textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "subtitles.color.green"), $00, $00)
                            If (mouseon((Int ((155.0 * menuscale) + (Float local0))), local1, (local33 Shl $01), local33) <> 0) Then
                                renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                            EndIf
                            local1 = (Int ((30.0 * menuscale) + (Float local1)))
                            textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "subtitles.color.blue"), $00, $00)
                            If (mouseon((Int ((155.0 * menuscale) + (Float local0))), local1, (local33 Shl $01), local33) <> 0) Then
                                renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $14, 0.0)
                            EndIf
                            color($14, $14, $14)
                            rect((Int ((Float local0) - (20.0 * menuscale))), (Int ((390.0 * menuscale) + (Float local3))), local2, (Int (20.0 * menuscale)), $01)
                            color((Int ((Float (opt\Field27 + $82)) / 2.0)), (Int ((Float (opt\Field28 + $82)) / 2.0)), (Int ((Float (opt\Field29 + $82)) / 2.0)))
                            textex(local0, (Int ((396.0 * menuscale) + (Float local3))), getlocalstring("options", "subtitles.example"), $00, $00)
                        EndIf
                    EndIf
                Case $09
                    local3 = (Int ((Float ((opt\Field31 * $14) + $154)) * menuscale))
                    renderframe((Int ((Float local0) - (20.0 * menuscale))), local1, local2, local3, $00, $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    setfontex(fo\Field0[$00])
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "mousesensitive"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $01)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $15, opt\Field45)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "mousesmooth"), $00, $00)
                    If (((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $02)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $16, opt\Field42)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "invertx"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $17, 0.0)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "inverty"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $18, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("menu", "controlconfig"), $00, $00)
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.forward"), $00, $00)
                    textex((Int ((260.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.crouch"), $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.left"), $00, $00)
                    textex((Int ((260.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.blink"), $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.backward"), $00, $00)
                    textex((Int ((260.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.inv"), $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.right"), $00, $00)
                    textex((Int ((260.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.save"), $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.sprint"), $00, $00)
                    textex((Int ((260.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.screenshot"), $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.lean.left"), $00, $00)
                    textex((Int ((260.0 * menuscale) + (Float local0))), (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.lean.right"), $00, $00)
                    If (opt\Field31 <> 0) Then
                        local1 = (Int ((20.0 * menuscale) + (Float local1)))
                        textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "key.console"), $00, $00)
                    EndIf
                    If (mouseon(local0, (Int ((Float local1) - ((Float ((opt\Field31 * $14) + $3C)) * menuscale))), (local2 - (local33 Shl $01)), (Int ((Float ((opt\Field31 * $14) + $78)) * menuscale))) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $19, 0.0)
                    EndIf
                Case $0A
                    local3 = (Int (460.0 * menuscale))
                    renderframe((Int ((Float local0) - (20.0 * menuscale))), local1, local2, local3, $00, $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    setfontex(fo\Field0[$00])
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "hud"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1A, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "console"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1B, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    If (opt\Field31 <> 0) Then
                        textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "error"), $00, $00)
                        If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1C, 0.0)
                        EndIf
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "achipop"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1D, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "save"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $20, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "fps"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1E, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "frame"), $00, $00)
                    If ((mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) And (onsliderid = $00)) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1F, (Float opt\Field35))
                    EndIf
                    If (0.0 < opt\Field36) Then
                        color($FF, $FF, $00)
                        textex(local0, (Int ((45.0 * menuscale) + (Float local1))), ((Str opt\Field35) + " FPS"), $00, $00)
                        If (((mouseon((Int ((130.0 * menuscale) + (Float local0))), ((local33 Shl $01) + local1), (Int ((Float local33) * 8.2)), local33) And (onsliderid = $00)) Lor (onsliderid = $01)) <> 0) Then
                            renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $1F, (Float opt\Field35))
                        EndIf
                        local1 = (Int ((50.0 * menuscale) + (Float local1)))
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "bar"), $00, $00)
                    If (mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $21, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    color($FF, $FF, $FF)
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "vignette"), $00, $00)
                    If (mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $22, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "startvideo"), $00, $00)
                    If (mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $23, 0.0)
                    EndIf
                    local1 = (Int ((30.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("options", "launcher"), $00, $00)
                    If (mouseon((Int ((290.0 * menuscale) + (Float local0))), local1, local33, local33) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $24, 0.0)
                    EndIf
                    local1 = (Int ((40.0 * menuscale) + (Float local1)))
                    If (mouseon(local0, local1, (Int (195.0 * menuscale)), (Int (30.0 * menuscale))) <> 0) Then
                        renderoptionstooltip((Int local6), (Int local7), (Int local8), (Int local9), $25, 0.0)
                    EndIf
                Case $0B
                    local3 = (Int (455.0 * menuscale))
                    renderframe((Int ((Float local0) - (20.0 * menuscale))), local1, local2, local3, $00, $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    setfontex(fo\Field0[$00])
                    color($FF, $FF, $FF)
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("mpoptions", "playername"), $00, $00)
                    local1 = (Int ((35.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("menu", "controlconfig"), $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("mpoptions", "voice"), $00, $00)
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    textex(local0, (Int ((5.0 * menuscale) + (Float local1))), getlocalstring("mpoptions", "chat"), $00, $00)
            End Select
        EndIf
    EndIf
    rendermenutextboxes()
    rendermenubuttons()
    rendermenupalettes()
    rendermenuticks()
    rendermenuinputboxes()
    rendermenuslidebars()
    rendermenusliders()
    mp_rendergui($0A, $00)
    If (opt\Field32 <> 0) Then
        color($FF, $FF, $FF)
        setfontex(fo\Field0[$05])
        textex((Int (20.0 * menuscale)), (Int ((Float opt\Field47) - (50.0 * menuscale))), ((("Multiplayer beta v" + multiplayer_version) + " based on UER ") + "1.5"), $00, $00)
        If (opt\Field33 <> 0) Then
            setfontex(fo\Field0[$05])
            textex((Int (20.0 * menuscale)), (Int ((Float opt\Field47) - (30.0 * menuscale))), ("FPS: " + (Str fps\Field3)), $00, $00)
        EndIf
    EndIf
    rendercursor()
    setfontex(fo\Field0[$00])
    catcherrors("Uncaught: RenderMainMenu()")
    Return $00
End Function
