Function updatemenu%()
    Local local0.rooms
    Local local1.securitycams
    Local local2.achievementmsg
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local19%
    Local local20%
    Local local21$
    Local local22%
    Local local23%
    Local local25%
    catcherrors("UpdateMenu()")
    If (menuopen <> 0) Then
        If (((isplayeroutsidefacility() Lor (Int me\Field0)) Lor me\Field56) = $00) Then
            If (0.0 = me\Field63) Then
                If (((((0.64 > entitydistancesquared(n_i\Field2\Field3, me\Field60)) And (2.0 > n_i\Field2\Field26)) Lor (0.64 > entitydistancesquared(n_i\Field3\Field3, me\Field60))) Lor ((((n_i\Field6 <> Null) And (0.64 > entitydistancesquared(n_i\Field6\Field3, me\Field60))) And ((n_i\Field7 <> Null) And (0.64 > entitydistancesquared(n_i\Field7\Field3, me\Field60)))) And ((n_i\Field4 <> Null) And (0.64 > entitydistancesquared(n_i\Field4\Field3, me\Field60))))) <> 0) Then
                    me\Field63 = 1.0
                EndIf
            ElseIf (rnd(120.0, 240.0) <= me\Field63) Then
                me\Field63 = 0.0
                menuopen = $00
                Return $00
            EndIf
        EndIf
        onpalette = $00
        invopen = $00
        local5 = imagewidth(t\Field1[$00])
        local6 = imageheight(t\Field1[$00])
        local7 = (mo\Field9 - (local5 Sar $01))
        local8 = (mo\Field10 - (local6 Sar $01))
        local7 = (Int ((132.0 * menuscale) + (Float local7)))
        local8 = (Int ((122.0 * menuscale) + (Float local8)))
        If (mo\Field2 = $00) Then
            onsliderid = $00
        EndIf
        If ((((igm\Field0 <= $00) And (igm\Field2 > $00)) And (igm\Field1 <= $00)) <> 0) Then
            If (igm\Field2 = $01) Then
                If (updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("options", "grap"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    changeoptiontab($02, $00)
                EndIf
                If (updatemenubutton(local7, (Int ((75.0 * menuscale) + (Float local8))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("options", "audio"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    changeoptiontab($03, $00)
                EndIf
                If (updatemenubutton(local7, (Int ((150.0 * menuscale) + (Float local8))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("options", "ctrl"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    changeoptiontab($04, $00)
                EndIf
                If (updatemenubutton(local7, (Int ((225.0 * menuscale) + (Float local8))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("options", "avc"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    changeoptiontab($05, $00)
                EndIf
                If (updatemenubutton(local7, (Int ((300.0 * menuscale) + (Float local8))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("mpmenu", "opt"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    changeoptiontab($06, $00)
                EndIf
                If (updatemenubutton((Int ((101.0 * menuscale) + (Float local7))), (Int ((455.0 * menuscale) + (Float local8))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "back"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    igm\Field0 = $00
                    igm\Field2 = $00
                    igm\Field1 = $00
                    resetinput()
                    shoulddeletegadgets = $01
                EndIf
            Else
                If (updatemenubutton((Int ((101.0 * menuscale) + (Float local7))), (Int ((455.0 * menuscale) + (Float local8))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "back"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    igm\Field0 = $00
                    igm\Field2 = $01
                    igm\Field1 = $00
                    resetinput()
                    saveoptionsini($00)
                    shoulddeletegadgets = $01
                EndIf
                local7 = (Int ((270.0 * menuscale) + (Float local7)))
                Select igm\Field2
                    Case $02
                        opt\Field2 = updatemenutick(local7, local8, opt\Field2, $01)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field5 = updatemenutick(local7, local8, opt\Field5, $00)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field1 = updatemenutick(local7, local8, opt\Field1, (opt\Field51 <> $00))
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field4 = updatemenutick(local7, local8, opt\Field4, $00)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field6 = (updatemenuslidebar(local7, local8, (Int (100.0 * menuscale)), (opt\Field6 * 50.0), $01) / 50.0)
                        local8 = (Int ((45.0 * menuscale) + (Float local8)))
                        opt\Field0 = updatemenuslider3(local7, local8, (Int (100.0 * menuscale)), opt\Field0, $02, getlocalstring("options", "min"), getlocalstring("options", "red"), getlocalstring("options", "full"))
                        local8 = (Int ((45.0 * menuscale) + (Float local8)))
                        opt\Field8 = updatemenuslider5(local7, local8, (Int (100.0 * menuscale)), opt\Field8, $03, "0.8", "0.4", "0.0", "-0.4", "-0.8")
                        Select opt\Field8
                            Case $00
                                opt\Field9 = 0.8
                            Case $01
                                opt\Field9 = 0.4
                            Case $02
                                opt\Field9 = 0.0
                            Case $03
                                opt\Field9 = -0.4
                            Case $04
                                opt\Field9 = -0.8
                        End Select
                        texturelodbias(opt\Field9)
                        local8 = (Int ((35.0 * menuscale) + (Float local8)))
                        opt\Field3 = updatemenutick(local7, local8, opt\Field3, $01)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field11 = (updatemenuslidebar(local7, local8, (Int (100.0 * menuscale)), (opt\Field11 * 2.0), $04) / 2.0)
                        opt\Field10 = (opt\Field11 + 40.0)
                        camerazoomvalue = tan(((atan((tan((opt\Field10 / 2.0)) * (graphicwidthfloat / graphicheightfloat))) * 2.0) / 2.0))
                        camerazoom(camera, (min(((me\Field52 / 400.0) + 1.0), 1.1) / camerazoomvalue))
                        local8 = (Int ((45.0 * menuscale) + (Float local8)))
                        opt\Field12 = updatemenuslider5(local7, local8, (Int (100.0 * menuscale)), opt\Field12, $05, "Trilinear", "2x", "4x", "8x", "16x")
                        Select opt\Field12
                            Case $00
                                opt\Field13 = $00
                            Case $01
                                opt\Field13 = $02
                            Case $02
                                opt\Field13 = $04
                            Case $03
                                opt\Field13 = $08
                            Case $04
                                opt\Field13 = $10
                        End Select
                        textureanisotropic(opt\Field13)
                        local8 = (Int ((45.0 * menuscale) + (Float local8)))
                        opt\Field14 = updatemenuslider5(local7, local8, (Int (100.0 * menuscale)), opt\Field14, $11, "24.0", "18.0", "12.0", "6.0", "0.0")
                        Select opt\Field14
                            Case $00
                                opt\Field15 = 24.0
                            Case $01
                                opt\Field15 = 18.0
                            Case $02
                                opt\Field15 = 12.0
                            Case $03
                                opt\Field15 = 6.0
                            Case $04
                                opt\Field15 = 0.0
                        End Select
                        For local1 = Each securitycams
                            If (local1\Field5 <> 0) Then
                                local1\Field15 = opt\Field15
                            EndIf
                        Next
                    Case $03
                        opt\Field17 = (updatemenuslidebar(local7, local8, (Int (100.0 * menuscale)), (opt\Field16 * 100.0), $01) / 100.0)
                        If (me\Field54 = $00) Then
                            opt\Field16 = opt\Field17
                        EndIf
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field18 = (updatemenuslidebar(local7, local8, (Int (100.0 * menuscale)), (opt\Field18 * 100.0), $02) / 100.0)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field20 = (updatemenuslidebar(local7, local8, (Int (100.0 * menuscale)), (opt\Field20 * 100.0), $03) / 100.0)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field21 = (updatemenuslidebar(local7, local8, (Int (100.0 * menuscale)), (opt\Field21 * 100.0), $12) / 100.0)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field22 = updatemenutick(local7, local8, opt\Field22, $01)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        local14 = opt\Field24
                        If (updatemenubutton(local7, local8, (Int (20.0 * menuscale)), (Int (20.0 * menuscale)), ">", $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            If (opt\Field24 < $02) Then
                                opt\Field24 = (opt\Field24 + $01)
                            Else
                                opt\Field24 = $00
                            EndIf
                        EndIf
                        If (opt\Field24 > $00) Then
                            updatemenubutton((Int ((Float local7) - (270.0 * menuscale))), (Int ((30.0 * menuscale) + (Float local8))), (Int (210.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("options", "scantracks"), $00, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                            local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        EndIf
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        local15 = opt\Field25
                        local16 = opt\Field26
                        opt\Field25 = updatemenutick(local7, local8, opt\Field25, $00)
                        If (local15 <> opt\Field25) Then
                            If (opt\Field25 <> 0) Then
                                clearsubtitles()
                            EndIf
                        EndIf
                        If (opt\Field25 <> 0) Then
                            local8 = (Int ((30.0 * menuscale) + (Float local8)))
                            opt\Field26 = updatemenutick(local7, local8, opt\Field26, $00)
                        EndIf
                        If ((opt\Field25 And opt\Field26) <> 0) Then
                            local8 = (Int ((35.0 * menuscale) + (Float local8)))
                            updatemenupalette((Int ((Float local7) - (43.0 * menuscale))), (Int ((5.0 * menuscale) + (Float local8))))
                            local8 = (Int ((30.0 * menuscale) + (Float local8)))
                            opt\Field27 = (Int min((Float updatemenuinputbox((Int ((Float local7) - (115.0 * menuscale))), local8, (Int (40.0 * menuscale)), (Int (20.0 * menuscale)), (Str opt\Field27), $00, $10, $03, 1.0)), 255.0))
                            local8 = (Int ((30.0 * menuscale) + (Float local8)))
                            opt\Field28 = (Int min((Float updatemenuinputbox((Int ((Float local7) - (115.0 * menuscale))), local8, (Int (40.0 * menuscale)), (Int (20.0 * menuscale)), (Str opt\Field28), $00, $11, $03, 1.0)), 255.0))
                            local8 = (Int ((30.0 * menuscale) + (Float local8)))
                            opt\Field29 = (Int min((Float updatemenuinputbox((Int ((Float local7) - (115.0 * menuscale))), local8, (Int (40.0 * menuscale)), (Int (20.0 * menuscale)), (Str opt\Field29), $00, $12, $03, 1.0)), 255.0))
                        EndIf
                        If (((local15 Lor local16) Lor (local14 <> $01)) <> 0) Then
                            shoulddeletegadgets = (((local15 <> opt\Field25) Lor (local16 <> opt\Field26)) Lor (local14 <> opt\Field24))
                        EndIf
                    Case $04
                        opt\Field45 = ((updatemenuslidebar(local7, local8, (Int (100.0 * menuscale)), ((opt\Field45 + 0.5) * 100.0), $01) / 100.0) - 0.5)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field42 = (updatemenuslidebar(local7, local8, (Int (100.0 * menuscale)), (opt\Field42 * 50.0), $02) / 50.0)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field43 = updatemenutick(local7, local8, opt\Field43, $00)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        opt\Field44 = updatemenutick(local7, local8, opt\Field44, $00)
                        local8 = (Int ((60.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field3), 210.0))], $00, $03, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field1), 210.0))], $00, $04, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field4), 210.0))], $00, $05, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field2), 210.0))], $00, $06, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field7), 210.0))], $00, $07, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field10), 210.0))], $00, $08, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field8), 210.0))], $00, $09, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field6), 210.0))], $00, $0A, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field9), 210.0))], $00, $0B, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field11), 210.0))], $00, $0D, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field12), 210.0))], $00, $0E, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field13), 210.0))], $00, $0F, $00, 1.0)
                        If (opt\Field31 <> 0) Then
                            local8 = (Int ((20.0 * menuscale) + (Float local8)))
                            updatemenuinputbox(local7, local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field5), 210.0))], $00, $0C, $00, 1.0)
                        EndIf
                        For local4 = $00 To $E3 Step $01
                            If (keyhit(local4) <> 0) Then
                                local17 = local4
                                Exit
                            EndIf
                        Next
                        If (local17 <> $00) Then
                            Select selectedinputbox
                                Case $03
                                    key\Field3 = local17
                                Case $04
                                    key\Field1 = local17
                                Case $05
                                    key\Field4 = local17
                                Case $06
                                    key\Field2 = local17
                                Case $07
                                    key\Field7 = local17
                                Case $08
                                    key\Field10 = local17
                                Case $09
                                    key\Field8 = local17
                                Case $0A
                                    key\Field6 = local17
                                Case $0B
                                    key\Field9 = local17
                                Case $0C
                                    key\Field5 = local17
                                Case $0D
                                    key\Field11 = local17
                                Case $0E
                                    key\Field12 = local17
                                Case $0F
                                    key\Field13 = local17
                            End Select
                            selectedinputbox = $00
                        EndIf
                    Case $05
                        opt\Field32 = updatemenutick(local7, local8, opt\Field32, $00)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        local19 = opt\Field31
                        opt\Field31 = updatemenutick(local7, local8, opt\Field31, $00)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        If (opt\Field31 <> 0) Then
                            opt\Field34 = updatemenutick(local7, local8, opt\Field34, $00)
                        EndIf
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field30 = updatemenutick(local7, local8, opt\Field30, $00)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field37 = updatemenutick(local7, local8, opt\Field37, (selecteddifficulty\Field3 <> $00))
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field33 = updatemenutick(local7, local8, opt\Field33, $00)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        local20 = (0.0 < opt\Field36)
                        If (updatemenutick(local7, local8, (0.0 < opt\Field36), $00) <> 0) Then
                            opt\Field36 = (updatemenuslidebar((Int ((Float local7) - (120.0 * menuscale))), (Int ((40.0 * menuscale) + (Float local8))), (Int (100.0 * menuscale)), (opt\Field36 * 99.0), $01) / 99.0)
                            opt\Field36 = max(opt\Field36, 0.01)
                            opt\Field35 = (Int ((opt\Field36 * 100.0) + 19.0))
                            local8 = (Int ((80.0 * menuscale) + (Float local8)))
                        Else
                            opt\Field36 = 0.0
                            opt\Field35 = $00
                            local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        EndIf
                        If ((local20 Lor local19) <> 0) Then
                            shoulddeletegadgets = (((Float local20) <> opt\Field36) Lor (local19 <> opt\Field31))
                        EndIf
                        opt\Field38 = updatemenutick(local7, local8, opt\Field38, $00)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field39 = updatemenutick(local7, local8, opt\Field39, $00)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field40 = updatemenutick(local7, local8, opt\Field40, $00)
                        local8 = (Int ((30.0 * menuscale) + (Float local8)))
                        opt\Field41 = updatemenutick(local7, local8, opt\Field41, $00)
                        local8 = (Int ((40.0 * menuscale) + (Float local8)))
                        updatemenubutton((Int ((Float local7) - (270.0 * menuscale))), local8, (Int (195.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("options", "reset"), $00, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                    Case $06
                        opt\Field47 = (updatemenuslidebar((Int ((Float local7) - (70.0 * menuscale))), local8, (Int (150.0 * menuscale)), (opt\Field47 * 100.0), $01) / 100.0)
                        local8 = (Int ((35.0 * menuscale) + (Float local8)))
                        If (((opt\Field48 = "") And (bass_getrecorddevicecount() > $00)) <> 0) Then
                            opt\Field48 = bass_getrecorddevicename($00)
                        EndIf
                        If (opt\Field48 = "") Then
                            updatemenubutton((Int ((Float local7) - (130.0 * menuscale))), local8, (Int (300.0 * menuscale)), (Int (30.0 * menuscale)), getlocalstring("mpoptions", "nullvoice"), $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00)
                        Else
                            local21 = opt\Field48
                            If (len(local21) > $1C) Then
                                local21 = left(opt\Field48, $1C)
                                local21 = (local21 + "...")
                            EndIf
                            If (updatemenubutton((Int ((Float local7) - (130.0 * menuscale))), local8, (Int (300.0 * menuscale)), (Int (30.0 * menuscale)), local21, $00, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                                local22 = bass_getrecorddevicecount()
                                If (local22 > $00) Then
                                    local23 = $00
                                    For local4 = $00 To (local22 - $01) Step $01
                                        If (bass_getrecorddevicename(local4) = opt\Field48) Then
                                            local23 = local4
                                            Exit
                                        EndIf
                                    Next
                                    local23 = (local23 + $01)
                                    If (local23 >= local22) Then
                                        local23 = $00
                                    EndIf
                                    opt\Field48 = bass_getrecorddevicename(local23)
                                    mp_reloadvoicedevice()
                                EndIf
                            EndIf
                        EndIf
                        local8 = (Int ((100.0 * menuscale) + (Float local8)))
                        updatemenuinputbox((Int ((Float local7) - (50.0 * menuscale))), local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field14), 210.0))], $00, $425, $00, 1.0)
                        local8 = (Int ((20.0 * menuscale) + (Float local8)))
                        updatemenuinputbox((Int ((Float local7) - (50.0 * menuscale))), local8, (Int (110.0 * menuscale)), (Int (20.0 * menuscale)), key\Field0[(Int min((Float key\Field15), 210.0))], $00, $426, $00, 1.0)
                        local17 = $00
                        For local4 = $00 To $E3 Step $01
                            If (keyhit(local4) <> 0) Then
                                local17 = local4
                                Exit
                            EndIf
                        Next
                        If (local17 <> $00) Then
                            Select selectedinputbox
                                Case $425
                                    key\Field14 = local17
                                Case $426
                                    key\Field15 = local17
                            End Select
                            selectedinputbox = $00
                        EndIf
                End Select
            EndIf
        ElseIf ((((igm\Field0 <= $00) And (igm\Field2 <= $00)) And (igm\Field1 > $00)) <> 0) Then
            local25 = $55
            If ((((selecteddifficulty\Field3 = $02) Lor (selecteddifficulty\Field3 = $00)) And (mp_getsocket() = $00)) <> 0) Then
                If (cansave = $03) Then
                    local25 = $A0
                    If (updatemenubutton(local7, (Int ((85.0 * menuscale) + (Float local8))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "savequit"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                        me\Field36 = 0.0
                        savegame(currsave\Field0)
                        nullgame($00)
                        currsave = Null
                        resetinput()
                        Return $00
                    EndIf
                EndIf
            EndIf
            If (updatemenubutton(local7, (Int (((Float local25) * menuscale) + (Float local8))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "quit"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                mp_client_disconnect()
                nullgame($00)
                currsave = Null
                resetinput()
                Return $00
            EndIf
            If (updatemenubutton((Int ((101.0 * menuscale) + (Float local7))), (Int ((385.0 * menuscale) + (Float local8))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "back"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                igm\Field0 = $00
                igm\Field2 = $00
                igm\Field1 = $00
                resetinput()
                shoulddeletegadgets = $01
            EndIf
        ElseIf ((((igm\Field0 > $00) And (igm\Field2 <= $00)) And (igm\Field1 <= $00)) <> 0) Then
            If (updatemenubutton((Int ((101.0 * menuscale) + (Float local7))), (Int ((345.0 * menuscale) + (Float local8))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "back"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                igm\Field0 = $00
                igm\Field2 = $00
                igm\Field1 = $00
                resetinput()
                shoulddeletegadgets = $01
            EndIf
            If (igm\Field0 > $00) Then
                If (floor(((Float (s2imapsize(achievementsindex) - $01)) / 12.0)) >= (Float igm\Field0)) Then
                    If (updatemenubutton((Int ((341.0 * menuscale) + (Float local7))), (Int ((345.0 * menuscale) + (Float local8))), (Int (60.0 * menuscale)), (Int (60.0 * menuscale)), ">", $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                        igm\Field0 = (igm\Field0 + $01)
                        shoulddeletegadgets = $01
                    EndIf
                Else
                    updatemenubutton((Int ((341.0 * menuscale) + (Float local7))), (Int ((345.0 * menuscale) + (Float local8))), (Int (60.0 * menuscale)), (Int (60.0 * menuscale)), ">", $01, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                EndIf
                If (igm\Field0 > $01) Then
                    If (updatemenubutton((Int ((31.0 * menuscale) + (Float local7))), (Int ((345.0 * menuscale) + (Float local8))), (Int (60.0 * menuscale)), (Int (60.0 * menuscale)), "<", $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                        igm\Field0 = (igm\Field0 - $01)
                        shoulddeletegadgets = $01
                    EndIf
                Else
                    updatemenubutton((Int ((31.0 * menuscale) + (Float local7))), (Int ((345.0 * menuscale) + (Float local8))), (Int (60.0 * menuscale)), (Int (60.0 * menuscale)), "<", $01, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                EndIf
            EndIf
        Else
            local8 = (Int ((10.0 * menuscale) + (Float local8)))
            If ((((((Int me\Field0) Lor me\Field56) = $00) Lor (me\Field43 <> $FFFFFFFF)) Lor ((Int me\Field0) And mp_terminated\Field0)) <> 0) Then
                local8 = (Int ((75.0 * menuscale) + (Float local8)))
                If (updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "resume"), $01, $01, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    resumesounds()
                    stopmousemovement()
                    deletemenugadgets()
                    menuopen = $00
                    Return $00
                EndIf
                local8 = (Int ((75.0 * menuscale) + (Float local8)))
                If ((((selecteddifficulty\Field3 < $02) And (currsave <> Null)) And (len(currsave\Field0) > $00)) <> 0) Then
                    If (gamesaved <> 0) Then
                        If (updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "load"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            renderloading($00, getlocalstring("loading", "files"))
                            If (t\Field3[$0A] <> $00) Then
                                freeentity(t\Field3[$0A])
                                t\Field3[$0A] = $00
                            EndIf
                            killsounds($01)
                            loadgamequick(currsave\Field0)
                            movemouse(mo\Field9, mo\Field10)
                            hidepointer()
                            resetrender()
                            For local0 = Each rooms
                                local7 = (Int (Abs (entityx(me\Field60, $00) - entityx(local0\Field2, $00))))
                                local3 = (Int (Abs (entityz(me\Field60, $00) - entityz(local0\Field2, $00))))
                                If (((12.0 >= (Float local7)) And (12.0 >= (Float local3))) <> 0) Then
                                    local9 = (Int (floor((entityx(local0\Field2, $00) / 8.0)) + (floor((entityz(local0\Field2, $00) / 8.0)) * 21.0)))
                                    currmapgrid\Field2[local9] = (Int max((Float currmapgrid\Field2[local9]), 1.0))
                                    If (((4.0 >= (Float local7)) And (4.0 >= (Float local3))) <> 0) Then
                                        If (isequal(entityy(me\Field60, $00), entityy(local0\Field2, $00), 1.5) <> 0) Then
                                            playerroom = local0
                                        EndIf
                                        currmapgrid\Field2[local9] = $01
                                    EndIf
                                EndIf
                            Next
                            For local2 = Each achievementmsg
                                Delete local2
                            Next
                            renderloading($64, "")
                            me\Field36 = 0.0
                            updateworld(0.0)
                            fps\Field7[$00] = 0.0
                            fps\Field1 = millisecs()
                            resetinput()
                            menuopen = $00
                            deletetextureentriesfromcache($00)
                            Return $00
                        EndIf
                    Else
                        updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "load"), $01, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                    EndIf
                    local8 = (Int ((75.0 * menuscale) + (Float local8)))
                EndIf
                If (updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "achievements"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    igm\Field0 = $01
                    shoulddeletegadgets = $01
                EndIf
                local8 = (Int ((75.0 * menuscale) + (Float local8)))
                If (updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "options"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    igm\Field2 = $01
                    shoulddeletegadgets = $01
                EndIf
                local8 = (Int ((75.0 * menuscale) + (Float local8)))
                If (updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "quit"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    igm\Field1 = $01
                    shoulddeletegadgets = $01
                EndIf
            Else
                local8 = (Int ((75.0 * menuscale) + (Float local8)))
                If (selecteddifficulty\Field3 < $02) Then
                    If (gamesaved <> 0) Then
                        If (updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "load"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                            renderloading($00, getlocalstring("loading", "files"))
                            If (t\Field3[$0A] <> $00) Then
                                freeentity(t\Field3[$0A])
                                t\Field3[$0A] = $00
                            EndIf
                            killsounds($01)
                            loadgamequick(currsave\Field0)
                            movemouse(mo\Field9, mo\Field10)
                            hidepointer()
                            resetrender()
                            For local0 = Each rooms
                                local7 = (Int (Abs (entityx(me\Field60, $00) - entityx(local0\Field2, $00))))
                                local3 = (Int (Abs (entityz(me\Field60, $00) - entityz(local0\Field2, $00))))
                                If (((12.0 >= (Float local7)) And (12.0 >= (Float local3))) <> 0) Then
                                    local9 = (Int (floor((entityx(local0\Field2, $00) / 8.0)) + (floor((entityz(local0\Field2, $00) / 8.0)) * 21.0)))
                                    currmapgrid\Field2[local9] = (Int max((Float currmapgrid\Field2[local9]), 1.0))
                                    If (((4.0 >= (Float local7)) And (4.0 >= (Float local3))) <> 0) Then
                                        If (isequal(entityy(me\Field60, $00), entityy(local0\Field2, $00), 1.5) <> 0) Then
                                            playerroom = local0
                                        EndIf
                                        currmapgrid\Field2[local9] = $01
                                    EndIf
                                EndIf
                            Next
                            For local2 = Each achievementmsg
                                Delete local2
                            Next
                            renderloading($64, "")
                            me\Field36 = 0.0
                            updateworld(0.0)
                            fps\Field7[$00] = 0.0
                            fps\Field1 = millisecs()
                            resetinput()
                            menuopen = $00
                            deletetextureentriesfromcache($00)
                            Return $00
                        EndIf
                    Else
                        updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "load"), $01, $00, $01, $FF, $FF, $FF, $01, 1.0, $00, $00)
                    EndIf
                    local8 = (Int ((75.0 * menuscale) + (Float local8)))
                EndIf
                If (updatemenubutton(local7, local8, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), getlocalstring("menu", "quitmenu"), $01, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                    mp_client_disconnect()
                    nullgame($00)
                    currsave = Null
                    resetinput()
                    Return $00
                EndIf
            EndIf
        EndIf
    EndIf
    catcherrors("Uncaught: UpdateMenu()")
    Return $00
End Function
