Function createmap%(arg0$, arg1%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%[3]
    Local local13%[3]
    Local local14%[3]
    Local local15%[3]
    Local local16%[3]
    Local local18%
    Local local21%
    Local local24%
    Local local25%
    Local local26%
    Local local27.rooms
    Local local28#
    Local local30.doors
    Local local31%
    Local local34.rooms
    arg1 = (Int max(min((Float arg1), 3.0), 0.0))
    addlog((("Generating a map using the seed " + arg0) + "..."), $00, $00, $00)
    Dim maptemp%((mapwidth + $01), (mapheight + $01))
    Dim mapfound%((mapwidth + $01), (mapheight + $01))
    i_zone\Field0[$00] = $0D
    i_zone\Field0[$01] = $07
    i_zone\Field1 = $00
    i_zone\Field2 = $00
    seedrnd(generateseednumber(arg0))
    Dim mapname$(mapwidth, mapheight)
    Dim maproomid%($06)
    local0 = (Int floor((Float (mapwidth Sar $01))))
    local1 = (mapheight - $02)
    For local3 = local1 To (mapheight - $01) Step $01
        maptemp(local0, local3) = $01
    Next
    Repeat
        local6 = rand(($0A / (arg1 + $01)), ($0F / (arg1 + $01)))
        If ((Float local0) > ((Float mapwidth) * 0.6)) Then
            local6 = (- local6)
        ElseIf ((Float local0) > ((Float mapwidth) * 0.4)) Then
            local0 = (local0 - (local6 Sar $01))
        EndIf
        If ((local0 + local6) > (mapwidth - $03)) Then
            local6 = ((mapwidth - $03) - local0)
        ElseIf ((local0 + local6) < $02) Then
            local6 = ((- local0) + $02)
        EndIf
        local0 = (Int min((Float local0), (Float (local0 + local6))))
        local6 = (Abs local6)
        For local3 = local0 To (local0 + local6) Step $01
            maptemp((Int min((Float local3), (Float mapwidth))), local1) = $01
        Next
        local7 = rand((Int max(2.0, (Float ($03 - arg1)))), ($04 - (arg1 Sar $01)))
        If ((local1 - local7) < $01) Then
            local7 = (local1 - $01)
        EndIf
        local9 = rand($04, $05)
        If (getzone((local1 - local7)) <> getzone(((local1 - local7) + $01))) Then
            local7 = (local7 - $01)
        EndIf
        For local3 = $01 To local9 Step $01
            local4 = (Int max(min((Float rand(local0, ((local0 + local6) - $01))), (Float (mapwidth - $02))), 2.0))
            While (((maptemp(local4, (local1 - $01)) Or maptemp((local4 - $01), (local1 - $01))) Or maptemp((local4 + $01), (local1 - $01))) <> 0)
                local4 = (local4 + $01)
            Wend
            If (local4 < (local0 + local6)) Then
                If (local3 = $01) Then
                    local10 = local7
                    If (rand($02, $01) = $01) Then
                        local4 = local0
                    Else
                        local4 = (local0 + local6)
                    EndIf
                Else
                    local10 = rand($01, local7)
                EndIf
                For local5 = (local1 - local10) To local1 Step $01
                    If (getzone(local5) <> getzone((local5 + $01))) Then
                        maptemp(local4, local5) = $FF
                    Else
                        maptemp(local4, local5) = $01
                    EndIf
                Next
                If (local10 = local7) Then
                    local2 = local4
                EndIf
            EndIf
        Next
        local0 = local2
        local1 = (local1 - local7)
    Until (local1 < $02)
    local11 = $03
    For local1 = $01 To (mapheight - $01) Step $01
        local8 = getzone(local1)
        For local0 = $01 To (mapwidth - $01) Step $01
            If (maptemp(local0, local1) > $00) Then
                local2 = (Int (min((Float maptemp((local0 + $01), local1)), 1.0) + min((Float maptemp((local0 - $01), local1)), 1.0)))
                local2 = (Int ((min((Float maptemp(local0, (local1 + $01))), 1.0) + (Float local2)) + min((Float maptemp(local0, (local1 - $01))), 1.0)))
                If (maptemp(local0, local1) < $FF) Then
                    maptemp(local0, local1) = local2
                EndIf
                Select maptemp(local0, local1)
                    Case $01
                        local12[local8] = (local12[local8] + $01)
                    Case $02
                        If (2.0 = (min((Float maptemp((local0 + $01), local1)), 1.0) + min((Float maptemp((local0 - $01), local1)), 1.0))) Then
                            local13[local8] = (local13[local8] + $01)
                        ElseIf (2.0 = (min((Float maptemp(local0, (local1 + $01))), 1.0) + min((Float maptemp(local0, (local1 - $01))), 1.0))) Then
                            local13[local8] = (local13[local8] + $01)
                        Else
                            local14[local8] = (local14[local8] + $01)
                        EndIf
                    Case $03
                        local15[local8] = (local15[local8] + $01)
                    Case $04
                        local16[local8] = (local16[local8] + $01)
                End Select
            EndIf
        Next
    Next
    For local3 = $00 To $02 Step $01
        local2 = (Int (max(1.0, (Float ($05 - (arg1 Shl $01)))) + (Float (- local12[local3]))))
        If (local2 > $00) Then
            For local1 = (((mapheight / local11) * ($02 - local3)) + $01) To (Int (((Float (mapheight / local11)) * ((Float ($02 - local3)) + 1.0)) - 2.0)) Step $01
                For local0 = $02 To (mapwidth - $02) Step $01
                    If (maptemp(local0, local1) = $00) Then
                        If (1.0 = (((min((Float maptemp((local0 + $01), local1)), 1.0) + min((Float maptemp((local0 - $01), local1)), 1.0)) + min((Float maptemp(local0, (local1 + $01))), 1.0)) + min((Float maptemp(local0, (local1 - $01))), 1.0))) Then
                            If (maptemp((local0 + $01), local1) <> 0) Then
                                local4 = (local0 + $01)
                                local5 = local1
                            ElseIf (maptemp((local0 - $01), local1) <> 0) Then
                                local4 = (local0 - $01)
                                local5 = local1
                            ElseIf (maptemp(local0, (local1 + $01)) <> 0) Then
                                local4 = local0
                                local5 = (local1 + $01)
                            ElseIf (maptemp(local0, (local1 - $01)) <> 0) Then
                                local4 = local0
                                local5 = (local1 - $01)
                            EndIf
                            local18 = $00
                            If (((maptemp(local4, local5) > $01) And (maptemp(local4, local5) < $04)) <> 0) Then
                                Select maptemp(local4, local5)
                                    Case $02
                                        If (2.0 = (min((Float maptemp((local4 + $01), local5)), 1.0) + min((Float maptemp((local4 - $01), local5)), 1.0))) Then
                                            local13[local3] = (local13[local3] - $01)
                                            local15[local3] = (local15[local3] + $01)
                                            local18 = $01
                                        ElseIf (2.0 = (min((Float maptemp(local4, (local5 + $01))), 1.0) + min((Float maptemp(local4, (local5 - $01))), 1.0))) Then
                                            local13[local3] = (local13[local3] - $01)
                                            local15[local3] = (local15[local3] + $01)
                                            local18 = $01
                                        EndIf
                                    Case $03
                                        local15[local3] = (local15[local3] - $01)
                                        local16[local3] = (local16[local3] + $01)
                                        local18 = $01
                                End Select
                                If (local18 <> 0) Then
                                    maptemp(local4, local5) = (maptemp(local4, local5) + $01)
                                    maptemp(local0, local1) = $01
                                    local12[local3] = (local12[local3] + $01)
                                    local2 = (local2 - $01)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local2 = $00) Then
                        Exit
                    EndIf
                Next
                If (local2 = $00) Then
                    Exit
                EndIf
            Next
        EndIf
    Next
    For local3 = $00 To $02 Step $01
        Select local3
            Case $02
                local8 = $02
                local21 = (mapheight / $03)
            Case $01
                local8 = ((mapheight / $03) + $01)
                local21 = (Int (((Float mapheight) * (1.0 / 1.5)) - 1.0))
            Case $00
                local8 = (Int (((Float mapheight) * (1.0 / 1.5)) + 1.0))
                local21 = (mapheight - $02)
        End Select
        If (local16[local3] < $01) Then
            debuglog(("forcing a ROOM4 into zone " + (Str local3)))
            local2 = $00
            For local1 = local8 To local21 Step $01
                For local0 = $02 To (mapwidth - $02) Step $01
                    If (maptemp(local0, local1) = $03) Then
                        Select $00
                            Case (((maptemp((local0 + $01), local1) Or maptemp((local0 + $01), (local1 + $01))) Or maptemp((local0 + $01), (local1 - $01))) Or maptemp((local0 + $02), local1))
                                maptemp((local0 + $01), local1) = $01
                                local2 = $01
                            Case (((maptemp((local0 - $01), local1) Or maptemp((local0 - $01), (local1 + $01))) Or maptemp((local0 - $01), (local1 - $01))) Or maptemp((local0 - $02), local1))
                                maptemp((local0 - $01), local1) = $01
                                local2 = $01
                            Case (((maptemp(local0, (local1 + $01)) Or maptemp((local0 + $01), (local1 + $01))) Or maptemp((local0 - $01), (local1 + $01))) Or maptemp(local0, (local1 + $02)))
                                maptemp(local0, (local1 + $01)) = $01
                                local2 = $01
                            Case (((maptemp(local0, (local1 - $01)) Or maptemp((local0 + $01), (local1 - $01))) Or maptemp((local0 - $01), (local1 - $01))) Or maptemp(local0, (local1 - $02)))
                                maptemp(local0, (local1 - $01)) = $01
                                local2 = $01
                        End Select
                        If (local2 = $01) Then
                            maptemp(local0, local1) = $04
                            debuglog((((("ROOM4 forced into slot (" + (Str local0)) + ", ") + (Str local1)) + ")"))
                            local16[local3] = (local16[local3] + $01)
                            local15[local3] = (local15[local3] - $01)
                            local12[local3] = (local12[local3] + $01)
                        EndIf
                    EndIf
                    If (local2 = $01) Then
                        Exit
                    EndIf
                Next
                If (local2 = $01) Then
                    Exit
                EndIf
            Next
            If (local2 = $00) Then
                debuglog(("Couldn't place ROOM4 in zone " + (Str local3)))
            EndIf
        EndIf
        If (local14[local3] < $01) Then
            debuglog(("forcing a ROOM2C into zone " + (Str local3)))
            local2 = $00
            local8 = (local8 + $01)
            local21 = (local21 - $01)
            For local1 = local8 To local21 Step $01
                For local0 = $03 To (mapwidth - $03) Step $01
                    If (maptemp(local0, local1) = $01) Then
                        Select $01
                            Case (maptemp((local0 - $01), local1) > $00)
                                If (((maptemp(local0, (local1 - $01)) + maptemp(local0, (local1 + $01))) + maptemp((local0 + $02), local1)) = $00) Then
                                    If (((maptemp((local0 + $01), (local1 - $02)) + maptemp((local0 + $02), (local1 - $01))) + maptemp((local0 + $01), (local1 - $01))) = $00) Then
                                        maptemp(local0, local1) = $02
                                        maptemp((local0 + $01), local1) = $02
                                        debuglog((((("ROOM2C forced into slot (" + (Str (local0 + $01))) + ", ") + (Str local1)) + ")"))
                                        maptemp((local0 + $01), (local1 - $01)) = $01
                                        local2 = $01
                                    ElseIf (((maptemp((local0 + $01), (local1 + $02)) + maptemp((local0 + $02), (local1 + $01))) + maptemp((local0 + $01), (local1 + $01))) = $00) Then
                                        maptemp(local0, local1) = $02
                                        maptemp((local0 + $01), local1) = $02
                                        debuglog((((("ROOM2C forced into slot (" + (Str (local0 + $01))) + ", ") + (Str local1)) + ")"))
                                        maptemp((local0 + $01), (local1 + $01)) = $01
                                        local2 = $01
                                    EndIf
                                EndIf
                            Case (maptemp((local0 + $01), local1) > $00)
                                If (((maptemp(local0, (local1 - $01)) + maptemp(local0, (local1 + $01))) + maptemp((local0 - $02), local1)) = $00) Then
                                    If (((maptemp((local0 - $01), (local1 - $02)) + maptemp((local0 - $02), (local1 - $01))) + maptemp((local0 - $01), (local1 - $01))) = $00) Then
                                        maptemp(local0, local1) = $02
                                        maptemp((local0 - $01), local1) = $02
                                        debuglog((((("ROOM2C forced into slot (" + (Str (local0 - $01))) + ", ") + (Str local1)) + ")"))
                                        maptemp((local0 - $01), (local1 - $01)) = $01
                                        local2 = $01
                                    ElseIf (((maptemp((local0 - $01), (local1 + $02)) + maptemp((local0 - $02), (local1 + $01))) + maptemp((local0 - $01), (local1 + $01))) = $00) Then
                                        maptemp(local0, local1) = $02
                                        maptemp((local0 - $01), local1) = $02
                                        debuglog((((("ROOM2C forced into slot (" + (Str (local0 - $01))) + ", ") + (Str local1)) + ")"))
                                        maptemp((local0 - $01), (local1 + $01)) = $01
                                        local2 = $01
                                    EndIf
                                EndIf
                            Case (maptemp(local0, (local1 - $01)) > $00)
                                If (((maptemp((local0 - $01), local1) + maptemp((local0 + $01), local1)) + maptemp(local0, (local1 + $02))) = $00) Then
                                    If (((maptemp((local0 - $02), (local1 + $01)) + maptemp((local0 - $01), (local1 + $02))) + maptemp((local0 - $01), (local1 + $01))) = $00) Then
                                        maptemp(local0, local1) = $02
                                        maptemp(local0, (local1 + $01)) = $02
                                        debuglog((((("ROOM2C forced into slot (" + (Str local0)) + ", ") + (Str (local1 + $01))) + ")"))
                                        maptemp((local0 - $01), (local1 + $01)) = $01
                                        local2 = $01
                                    ElseIf (((maptemp((local0 + $02), (local1 + $01)) + maptemp((local0 + $01), (local1 + $02))) + maptemp((local0 + $01), (local1 + $01))) = $00) Then
                                        maptemp(local0, local1) = $02
                                        maptemp(local0, (local1 + $01)) = $02
                                        debuglog((((("ROOM2C forced into slot (" + (Str local0)) + ", ") + (Str (local1 + $01))) + ")"))
                                        maptemp((local0 + $01), (local1 + $01)) = $01
                                        local2 = $01
                                    EndIf
                                EndIf
                            Case (maptemp(local0, (local1 + $01)) > $00)
                                If (((maptemp((local0 - $01), local1) + maptemp((local0 + $01), local1)) + maptemp(local0, (local1 - $02))) = $00) Then
                                    If (((maptemp((local0 - $02), (local1 - $01)) + maptemp((local0 - $01), (local1 - $02))) + maptemp((local0 - $01), (local1 - $01))) = $00) Then
                                        maptemp(local0, local1) = $02
                                        maptemp(local0, (local1 - $01)) = $02
                                        debuglog((((("ROOM2C forced into slot (" + (Str local0)) + ", ") + (Str (local1 - $01))) + ")"))
                                        maptemp((local0 - $01), (local1 - $01)) = $01
                                        local2 = $01
                                    ElseIf (((maptemp((local0 + $02), (local1 - $01)) + maptemp((local0 + $01), (local1 - $02))) + maptemp((local0 + $01), (local1 - $01))) = $00) Then
                                        maptemp(local0, local1) = $02
                                        maptemp(local0, (local1 - $01)) = $02
                                        debuglog((((("ROOM2C forced into slot (" + (Str local0)) + ", ") + (Str (local1 - $01))) + ")"))
                                        maptemp((local0 + $01), (local1 - $01)) = $01
                                        local2 = $01
                                    EndIf
                                EndIf
                        End Select
                        If (local2 = $01) Then
                            local14[local3] = (local14[local3] + $01)
                            local13[local3] = (local13[local3] + $01)
                        EndIf
                    EndIf
                    If (local2 = $01) Then
                        Exit
                    EndIf
                Next
                If (local2 = $01) Then
                    Exit
                EndIf
            Next
            If (local2 = $00) Then
                debuglog(("Couldn't place ROOM2C in zone " + (Str local3)))
            EndIf
        EndIf
    Next
    local24 = (($37 * mapwidth) / $14)
    local24 = (Int max((Float local24), (Float (((local12[$00] + local12[$01]) + local12[$02]) + $01))))
    local24 = (Int max((Float local24), (Float (((local13[$00] + local13[$01]) + local13[$02]) + $01))))
    local24 = (Int max((Float local24), (Float (((local14[$00] + local14[$01]) + local14[$02]) + $01))))
    local24 = (Int max((Float local24), (Float (((local15[$00] + local15[$01]) + local15[$02]) + $01))))
    local24 = (Int max((Float local24), (Float (((local16[$00] + local16[$01]) + local16[$02]) + $01))))
    Dim maproom$($06, local24)
    local25 = $01
    local26 = (local12[$00] - $01)
    maproom($01, $00) = "start"
    setroom("roompj", $01, (Int floor((0.1 * (Float local12[$00])))), local25, local26)
    setroom("914", $01, (Int floor((0.3 * (Float local12[$00])))), local25, local26)
    setroom("room1archive", $01, (Int floor((0.5 * (Float local12[$00])))), local25, local26)
    setroom("room205", $01, (Int floor((0.6 * (Float local12[$00])))), local25, local26)
    maproom($03, $00) = "lockroom"
    local25 = $01
    local26 = (local13[$00] - $01)
    maproom($02, $00) = "room2closets"
    setroom("room2testroom2", $02, (Int floor((0.1 * (Float local13[$00])))), local25, local26)
    setroom("room2scps", $02, (Int floor((0.2 * (Float local13[$00])))), local25, local26)
    setroom("room2storage", $02, (Int floor((0.3 * (Float local13[$00])))), local25, local26)
    setroom("room2gw_b", $02, (Int floor((0.4 * (Float local13[$00])))), local25, local26)
    setroom("room2sl", $02, (Int floor((0.5 * (Float local13[$00])))), local25, local26)
    setroom("room012", $02, (Int floor((0.55 * (Float local13[$00])))), local25, local26)
    setroom("room2scps2", $02, (Int floor((0.6 * (Float local13[$00])))), local25, local26)
    setroom("room1123", $02, (Int floor((0.7 * (Float local13[$00])))), local25, local26)
    setroom("room2elevator", $02, (Int floor((0.85 * (Float local13[$00])))), local25, local26)
    maproom($04, (Int floor((rnd(0.2, 0.8) * (Float local15[$00]))))) = "room3storage"
    maproom($03, (Int floor((0.5 * (Float local14[$00]))))) = "room1162"
    maproom($05, (Int floor((0.3 * (Float local16[$00]))))) = "room4info"
    local25 = local12[$00]
    local26 = ((local12[$00] + local12[$01]) - $01)
    setroom("room079", $01, (Int (floor((0.15 * (Float local12[$01]))) + (Float local12[$00]))), local25, local26)
    setroom("room106", $01, (Int (floor((0.3 * (Float local12[$01]))) + (Float local12[$00]))), local25, local26)
    setroom("008", $01, (Int (floor((0.4 * (Float local12[$01]))) + (Float local12[$00]))), local25, local26)
    setroom("room035", $01, (Int (floor((0.5 * (Float local12[$01]))) + (Float local12[$00]))), local25, local26)
    setroom("coffin", $01, (Int (floor((0.7 * (Float local12[$01]))) + (Float local12[$00]))), local25, local26)
    local25 = local13[$00]
    local26 = ((local13[$00] + local13[$01]) - $01)
    maproom($02, (Int (floor((0.1 * (Float local13[$01]))) + (Float local13[$00])))) = "room2nuke"
    setroom("room2tunnel", $02, (Int (floor((0.25 * (Float local13[$01]))) + (Float local13[$00]))), local25, local26)
    setroom("room049", $02, (Int (floor((0.4 * (Float local13[$01]))) + (Float local13[$00]))), local25, local26)
    setroom("room2shaft", $02, (Int (floor((0.6 * (Float local13[$01]))) + (Float local13[$00]))), local25, local26)
    setroom("testroom", $02, (Int (floor((0.7 * (Float local13[$01]))) + (Float local13[$00]))), local25, local26)
    setroom("room2servers", $02, (Int (floor((0.9 * (Float local13[$01]))) + (Float local13[$00]))), local25, local26)
    maproom($04, (Int (floor((0.3 * (Float local15[$01]))) + (Float local15[$00])))) = "room513"
    maproom($04, (Int (floor((0.6 * (Float local15[$01]))) + (Float local15[$00])))) = "room966"
    maproom($03, (Int (floor((0.5 * (Float local14[$01]))) + (Float local14[$00])))) = "room2cpit"
    maproom($01, (((local12[$00] + local12[$01]) + local12[$02]) - $02)) = "exit1"
    maproom($01, (((local12[$00] + local12[$01]) + local12[$02]) - $01)) = "gateaentrance"
    maproom($01, (local12[$00] + local12[$01])) = "room1lifts"
    local25 = (local13[$00] + local13[$01])
    local26 = (((local13[$00] + local13[$01]) + local13[$02]) - $01)
    maproom($02, (Int (floor((0.1 * (Float local13[$02]))) + (Float local25)))) = "room2poffices"
    setroom("room2cafeteria", $02, (Int (floor((0.2 * (Float local13[$02]))) + (Float local25))), local25, local26)
    setroom("room2sroom", $02, (Int (floor((0.3 * (Float local13[$02]))) + (Float local25))), local25, local26)
    setroom("room2servers2", $02, (Int (floor((0.4 * (Float local13[$02]))) + (Float local25))), local25, local26)
    setroom("room2offices", $02, (Int (floor((0.45 * (Float local13[$02]))) + (Float local25))), local25, local26)
    setroom("room2offices4", $02, (Int (floor((0.5 * (Float local13[$02]))) + (Float local25))), local25, local26)
    setroom("room860", $02, (Int (floor((0.6 * (Float local13[$02]))) + (Float local25))), local25, local26)
    setroom("medibay", $02, (Int (floor((0.7 * (Float local13[$02]))) + (Float local25))), local25, local26)
    setroom("room2poffices2", $02, (Int (floor((0.8 * (Float local13[$02]))) + (Float local25))), local25, local26)
    setroom("room2offices2", $02, (Int (floor((0.9 * (Float local13[$02]))) + (Float local25))), local25, local26)
    maproom($03, (local14[$00] + local14[$01])) = "room2ccont"
    maproom($03, ((local14[$00] + local14[$01]) + $01)) = "lockroom2"
    maproom($04, (Int ((Float (local15[$00] + local15[$01])) + floor((0.3 * (Float local15[$02])))))) = "room3servers"
    maproom($04, (Int ((Float (local15[$00] + local15[$01])) + floor((0.7 * (Float local15[$02])))))) = "room3servers2"
    maproom($04, (Int ((Float (local15[$00] + local15[$01])) + floor((0.5 * (Float local15[$02])))))) = "room3offices"
    local2 = $00
    local28 = 8.0
    local1 = (mapheight - $01)
    While (local1 >= $01)
        If (local1 < ((mapheight / $03) + $01)) Then
            local8 = $03
        ElseIf ((Float local1) < ((Float mapheight) * (1.0 / 1.5))) Then
            local8 = $02
        Else
            local8 = $01
        EndIf
        For local0 = $01 To (mapwidth - $02) Step $01
            If (maptemp(local0, local1) = $FF) Then
                If (local1 > (mapheight Sar $01)) Then
                    local27 = createroom(local8, $02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), "checkpoint1")
                Else
                    local27 = createroom(local8, $02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), "checkpoint2")
                EndIf
            ElseIf (maptemp(local0, local1) > $00) Then
                local2 = (Int (((min((Float maptemp((local0 + $01), local1)), 1.0) + min((Float maptemp((local0 - $01), local1)), 1.0)) + min((Float maptemp(local0, (local1 + $01))), 1.0)) + min((Float maptemp(local0, (local1 - $01))), 1.0)))
                Select local2
                    Case $01
                        If (((maproomid($01) < local24) And (mapname(local0, local1) = "")) <> 0) Then
                            If (maproom($01, maproomid($01)) <> "") Then
                                mapname(local0, local1) = maproom($01, maproomid($01))
                            EndIf
                        EndIf
                        local27 = createroom(local8, $01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                        If (maptemp(local0, (local1 + $01)) <> 0) Then
                            local27\Field6 = $B4
                            turnentity(local27\Field2, 0.0, (Float local27\Field6), 0.0, $00)
                        ElseIf (maptemp((local0 - $01), local1) <> 0) Then
                            local27\Field6 = $10E
                            turnentity(local27\Field2, 0.0, (Float local27\Field6), 0.0, $00)
                        ElseIf (maptemp((local0 + $01), local1) <> 0) Then
                            local27\Field6 = $5A
                            turnentity(local27\Field2, 0.0, (Float local27\Field6), 0.0, $00)
                        Else
                            local27\Field6 = $00
                        EndIf
                        maproomid($01) = (maproomid($01) + $01)
                    Case $02
                        If (((maptemp((local0 - $01), local1) > $00) And (maptemp((local0 + $01), local1) > $00)) <> 0) Then
                            If (((maproomid($02) < local24) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($02, maproomid($02)) <> "") Then
                                    mapname(local0, local1) = maproom($02, maproomid($02))
                                EndIf
                            EndIf
                            local27 = createroom(local8, $02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            If (rand($02, $01) = $01) Then
                                local27\Field6 = $5A
                            Else
                                local27\Field6 = $10E
                            EndIf
                            turnentity(local27\Field2, 0.0, (Float local27\Field6), 0.0, $00)
                            maproomid($02) = (maproomid($02) + $01)
                        ElseIf (((maptemp(local0, (local1 - $01)) > $00) And (maptemp(local0, (local1 + $01)) > $00)) <> 0) Then
                            If (((maproomid($02) < local24) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($02, maproomid($02)) <> "") Then
                                    mapname(local0, local1) = maproom($02, maproomid($02))
                                EndIf
                            EndIf
                            local27 = createroom(local8, $02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            If (rand($02, $01) = $01) Then
                                local27\Field6 = $B4
                            Else
                                local27\Field6 = $00
                            EndIf
                            turnentity(local27\Field2, 0.0, (Float local27\Field6), 0.0, $00)
                            maproomid($02) = (maproomid($02) + $01)
                        Else
                            If (((maproomid($03) < local24) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($03, maproomid($03)) <> "") Then
                                    mapname(local0, local1) = maproom($03, maproomid($03))
                                EndIf
                            EndIf
                            If (((maptemp((local0 - $01), local1) > $00) And (maptemp(local0, (local1 + $01)) > $00)) <> 0) Then
                                local27 = createroom(local8, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                local27\Field6 = $B4
                                turnentity(local27\Field2, 0.0, (Float local27\Field6), 0.0, $00)
                            ElseIf (((maptemp((local0 + $01), local1) > $00) And (maptemp(local0, (local1 + $01)) > $00)) <> 0) Then
                                local27 = createroom(local8, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                local27\Field6 = $5A
                                turnentity(local27\Field2, 0.0, (Float local27\Field6), 0.0, $00)
                            ElseIf (((maptemp((local0 - $01), local1) > $00) And (maptemp(local0, (local1 - $01)) > $00)) <> 0) Then
                                local27 = createroom(local8, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                turnentity(local27\Field2, 0.0, 270.0, 0.0, $00)
                                local27\Field6 = $10E
                            Else
                                local27 = createroom(local8, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            EndIf
                            maproomid($03) = (maproomid($03) + $01)
                        EndIf
                    Case $03
                        If (((maproomid($04) < local24) And (mapname(local0, local1) = "")) <> 0) Then
                            If (maproom($04, maproomid($04)) <> "") Then
                                mapname(local0, local1) = maproom($04, maproomid($04))
                            EndIf
                        EndIf
                        local27 = createroom(local8, $04, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                        If (maptemp(local0, (local1 - $01)) = $00) Then
                            turnentity(local27\Field2, 0.0, 180.0, 0.0, $00)
                            local27\Field6 = $B4
                        ElseIf (maptemp((local0 - $01), local1) = $00) Then
                            turnentity(local27\Field2, 0.0, 90.0, 0.0, $00)
                            local27\Field6 = $5A
                        ElseIf (maptemp((local0 + $01), local1) = $00) Then
                            turnentity(local27\Field2, 0.0, -90.0, 0.0, $00)
                            local27\Field6 = $10E
                        EndIf
                        maproomid($04) = (maproomid($04) + $01)
                    Case $04
                        If (((maproomid($05) < local24) And (mapname(local0, local1) = "")) <> 0) Then
                            If (maproom($05, maproomid($05)) <> "") Then
                                mapname(local0, local1) = maproom($05, maproomid($05))
                            EndIf
                        EndIf
                        local27 = createroom(local8, $05, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                        maproomid($05) = (maproomid($05) + $01)
                End Select
            EndIf
        Next
        local1 = (local1 + $FFFFFFFF)
    Wend
    local27 = createroom($00, $01, (Float ((mapwidth - $01) Shl $03)), 500.0, 8.0, "gatea")
    maproomid($01) = (maproomid($01) + $01)
    local27 = createroom($00, $01, (Float ((mapwidth - $01) Shl $03)), 0.0, (Float ((mapheight - $01) Shl $03)), "pocketdimension")
    maproomid($01) = (maproomid($01) + $01)
    local27 = createroom($00, $01, 8.0, 0.0, (Float ((mapheight - $01) Shl $03)), "173")
    maproomid($01) = (maproomid($01) + $01)
    local27 = createroom($00, $01, 8.0, 800.0, 0.0, "dimension1499")
    maproomid($01) = (maproomid($01) + $01)
    For local27 = Each rooms
        preventroomoverlap(local27)
    Next
    For local1 = $00 To mapheight Step $01
        For local0 = $00 To mapwidth Step $01
            maptemp(local0, local1) = (Int min((Float maptemp(local0, local1)), 1.0))
        Next
    Next
    local1 = mapheight
    While (local1 >= $00)
        If (local1 < (i_zone\Field0[$01] - $01)) Then
            local8 = $03
        ElseIf (((local1 >= (i_zone\Field0[$01] - $01)) And (local1 < (i_zone\Field0[$00] - $01))) <> 0) Then
            local8 = $02
        Else
            local8 = $01
        EndIf
        local0 = mapwidth
        While (local0 >= $00)
            If (maptemp(local0, local1) > $00) Then
                If (local8 = $02) Then
                    local2 = $02
                Else
                    local2 = $00
                EndIf
                For local27 = Each rooms
                    local27\Field6 = (Int wrapangle((Float local27\Field6)))
                    If ((((Int (local27\Field3 / 8.0)) = local0) And ((Int (local27\Field5 / 8.0)) = local1)) <> 0) Then
                        local31 = $00
                        Select local27\Field7\Field9
                            Case $01
                                If (local27\Field6 = $5A) Then
                                    local31 = $01
                                EndIf
                            Case $02
                                If (((local27\Field6 = $5A) Or (local27\Field6 = $10E)) <> 0) Then
                                    local31 = $01
                                EndIf
                            Case $03
                                If (((local27\Field6 = $00) Or (local27\Field6 = $5A)) <> 0) Then
                                    local31 = $01
                                EndIf
                            Case $04
                                If ((((local27\Field6 = $00) Or (local27\Field6 = $B4)) Or (local27\Field6 = $5A)) <> 0) Then
                                    local31 = $01
                                EndIf
                            Default
                                local31 = $01
                        End Select
                        If (local31 <> 0) Then
                            If ((local0 + $01) < (mapwidth + $01)) Then
                                If (maptemp((local0 + $01), local1) > $00) Then
                                    local30 = createdoor(local27\Field0, (((Float local0) * local28) + (local28 / 2.0)), 0.0, ((Float local1) * local28), 90.0, local27, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), local2, $00, "", $00)
                                    local27\Field33[$00] = local30
                                EndIf
                            EndIf
                        EndIf
                        local31 = $00
                        Select local27\Field7\Field9
                            Case $01
                                If (local27\Field6 = $B4) Then
                                    local31 = $01
                                EndIf
                            Case $02
                                If (((local27\Field6 = $00) Or (local27\Field6 = $B4)) <> 0) Then
                                    local31 = $01
                                EndIf
                            Case $03
                                If (((local27\Field6 = $B4) Or (local27\Field6 = $5A)) <> 0) Then
                                    local31 = $01
                                EndIf
                            Case $04
                                If ((((local27\Field6 = $B4) Or (local27\Field6 = $5A)) Or (local27\Field6 = $10E)) <> 0) Then
                                    local31 = $01
                                EndIf
                            Default
                                local31 = $01
                        End Select
                        If (local31 <> 0) Then
                            If ((local1 + $01) < (mapheight + $01)) Then
                                If (maptemp(local0, (local1 + $01)) > $00) Then
                                    local30 = createdoor(local27\Field0, ((Float local0) * local28), 0.0, (((Float local1) * local28) + (local28 / 2.0)), 0.0, local27, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), local2, $00, "", $00)
                                    local27\Field33[$03] = local30
                                EndIf
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local0 = (local0 + $FFFFFFFF)
        Wend
        local1 = (local1 + $FFFFFFFF)
    Wend
    For local27 = Each rooms
        local27\Field6 = (Int wrapangle((Float local27\Field6)))
        local27\Field32[$00] = Null
        local27\Field32[$01] = Null
        local27\Field32[$02] = Null
        local27\Field32[$03] = Null
        For local34 = Each rooms
            If (local27 <> local34) Then
                If (local27\Field5 = local34\Field5) Then
                    If ((local27\Field3 + 8.0) = local34\Field3) Then
                        local27\Field32[$00] = local34
                        If (local27\Field33[$00] = Null) Then
                            local27\Field33[$00] = local34\Field33[$02]
                        EndIf
                    ElseIf ((local27\Field3 - 8.0) = local34\Field3) Then
                        local27\Field32[$02] = local34
                        If (local27\Field33[$02] = Null) Then
                            local27\Field33[$02] = local34\Field33[$00]
                        EndIf
                    EndIf
                ElseIf (local27\Field3 = local34\Field3) Then
                    If ((local27\Field5 - 8.0) = local34\Field5) Then
                        local27\Field32[$01] = local34
                        If (local27\Field33[$01] = Null) Then
                            local27\Field33[$01] = local34\Field33[$03]
                        EndIf
                    ElseIf ((local27\Field5 + 8.0) = local34\Field5) Then
                        local27\Field32[$03] = local34
                        If (local27\Field33[$03] = Null) Then
                            local27\Field33[$03] = local34\Field33[$01]
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (((((local27\Field32[$00] <> Null) And (local27\Field32[$01] <> Null)) And (local27\Field32[$02] <> Null)) And (local27\Field32[$03] <> Null)) <> 0) Then
                Exit
            EndIf
        Next
    Next
    Return $00
End Function
