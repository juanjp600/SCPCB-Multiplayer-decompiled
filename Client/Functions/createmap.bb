Function createmap%()
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
    Local local12%
    Local local13%[3]
    Local local14%[3]
    Local local15%[3]
    Local local16%[3]
    Local local17%[3]
    Local local19%
    Local local22%
    Local local25%
    Local local26%
    Local local27%
    Local local28.rooms
    Local local29#
    Local local31.doors
    Local local32%
    Local local35.rooms
    local0 = $00
    Dim maptemp%((mapwidth + $01), (mapheight + $01))
    Dim mapfound%((mapwidth + $01), (mapheight + $01))
    i_zone\Field0[$00] = $0D
    i_zone\Field0[$01] = $07
    i_zone\Field1 = $00
    i_zone\Field2 = $00
    seedrnd(generateseednumber(randomseed))
    Dim mapname$(mapwidth, mapheight)
    Dim maproomid%($06)
    local1 = (Int floor((Float (mapwidth Sar $01))))
    local2 = (mapheight - $02)
    For local4 = local2 To (mapheight - $01) Step $01
        maptemp(local1, local4) = $01
    Next
    Repeat
        multiplayer_send($01, $00, $00)
        local7 = rand(($0A / (local0 + $01)), ($0F / (local0 + $01)))
        If ((Float local1) > ((Float mapwidth) * 0.6)) Then
            local7 = (- local7)
        ElseIf ((Float local1) > ((Float mapwidth) * 0.4)) Then
            local1 = (local1 - (local7 Sar $01))
        EndIf
        If ((local1 + local7) > (mapwidth - $03)) Then
            local7 = ((mapwidth - $03) - local1)
        ElseIf ((local1 + local7) < $02) Then
            local7 = ((- local1) + $02)
        EndIf
        local1 = (Int min((Float local1), (Float (local1 + local7))))
        local7 = ((local7 Xor (- (local7 < 0))) - (- (local7 < 0)))
        For local4 = local1 To (local1 + local7) Step $01
            maptemp((Int min((Float local4), (Float mapwidth))), local2) = $01
        Next
        local8 = rand((Int max(2.0, (Float ($03 - local0)))), ($04 - (local0 Sar $01)))
        If ((local2 - local8) < $01) Then
            local8 = (local2 - $01)
        EndIf
        local10 = rand($04, $05)
        If (getzone((local2 - local8)) <> getzone(((local2 - local8) + $01))) Then
            local8 = (local8 - $01)
        EndIf
        For local4 = $01 To local10 Step $01
            local5 = (Int max(min((Float rand(local1, ((local1 + local7) - $01))), (Float (mapwidth - $02))), 2.0))
            While (((maptemp(local5, (local2 - $01)) Or maptemp((local5 - $01), (local2 - $01))) Or maptemp((local5 + $01), (local2 - $01))) <> 0)
                local5 = (local5 + $01)
            Wend
            If (local5 < (local1 + local7)) Then
                If (local4 = $01) Then
                    local11 = local8
                    If (rand($02, $01) = $01) Then
                        local5 = local1
                    Else
                        local5 = (local1 + local7)
                    EndIf
                Else
                    local11 = rand($01, local8)
                EndIf
                For local6 = (local2 - local11) To local2 Step $01
                    If (getzone(local6) <> getzone((local6 + $01))) Then
                        maptemp(local5, local6) = $FF
                    Else
                        maptemp(local5, local6) = $01
                    EndIf
                Next
                If (local11 = local8) Then
                    local3 = local5
                EndIf
            EndIf
        Next
        local1 = local3
        local2 = (local2 - local8)
    Until (local2 < $02)
    local12 = $03
    For local2 = $01 To (mapheight - $01) Step $01
        multiplayer_send($01, $00, $00)
        local9 = getzone(local2)
        For local1 = $01 To (mapwidth - $01) Step $01
            If (maptemp(local1, local2) > $00) Then
                local3 = (Int (min((Float maptemp((local1 + $01), local2)), 1.0) + min((Float maptemp((local1 - $01), local2)), 1.0)))
                local3 = (Int ((min((Float maptemp(local1, (local2 + $01))), 1.0) + (Float local3)) + min((Float maptemp(local1, (local2 - $01))), 1.0)))
                If (maptemp(local1, local2) < $FF) Then
                    maptemp(local1, local2) = local3
                EndIf
                Select maptemp(local1, local2)
                    Case $01
                        local13[local9] = (local13[local9] + $01)
                    Case $02
                        If (2.0 = (min((Float maptemp((local1 + $01), local2)), 1.0) + min((Float maptemp((local1 - $01), local2)), 1.0))) Then
                            local14[local9] = (local14[local9] + $01)
                        ElseIf (2.0 = (min((Float maptemp(local1, (local2 + $01))), 1.0) + min((Float maptemp(local1, (local2 - $01))), 1.0))) Then
                            local14[local9] = (local14[local9] + $01)
                        Else
                            local15[local9] = (local15[local9] + $01)
                        EndIf
                    Case $03
                        local16[local9] = (local16[local9] + $01)
                    Case $04
                        local17[local9] = (local17[local9] + $01)
                End Select
            EndIf
        Next
    Next
    For local4 = $00 To $02 Step $01
        local3 = (Int (max(1.0, (Float ($05 - (local0 Shl $01)))) + (Float (- local13[local4]))))
        If (local3 > $00) Then
            For local2 = (((mapheight / local12) * ($02 - local4)) + $01) To (Int (((Float (mapheight / local12)) * ((Float ($02 - local4)) + 1.0)) - 2.0)) Step $01
                For local1 = $02 To (mapwidth - $02) Step $01
                    If (maptemp(local1, local2) = $00) Then
                        If (1.0 = (((min((Float maptemp((local1 + $01), local2)), 1.0) + min((Float maptemp((local1 - $01), local2)), 1.0)) + min((Float maptemp(local1, (local2 + $01))), 1.0)) + min((Float maptemp(local1, (local2 - $01))), 1.0))) Then
                            If (maptemp((local1 + $01), local2) <> 0) Then
                                local5 = (local1 + $01)
                                local6 = local2
                            ElseIf (maptemp((local1 - $01), local2) <> 0) Then
                                local5 = (local1 - $01)
                                local6 = local2
                            ElseIf (maptemp(local1, (local2 + $01)) <> 0) Then
                                local5 = local1
                                local6 = (local2 + $01)
                            ElseIf (maptemp(local1, (local2 - $01)) <> 0) Then
                                local5 = local1
                                local6 = (local2 - $01)
                            EndIf
                            local19 = $00
                            If (((maptemp(local5, local6) > $01) And (maptemp(local5, local6) < $04)) <> 0) Then
                                Select maptemp(local5, local6)
                                    Case $02
                                        If (2.0 = (min((Float maptemp((local5 + $01), local6)), 1.0) + min((Float maptemp((local5 - $01), local6)), 1.0))) Then
                                            local14[local4] = (local14[local4] - $01)
                                            local16[local4] = (local16[local4] + $01)
                                            local19 = $01
                                        ElseIf (2.0 = (min((Float maptemp(local5, (local6 + $01))), 1.0) + min((Float maptemp(local5, (local6 - $01))), 1.0))) Then
                                            local14[local4] = (local14[local4] - $01)
                                            local16[local4] = (local16[local4] + $01)
                                            local19 = $01
                                        EndIf
                                    Case $03
                                        local16[local4] = (local16[local4] - $01)
                                        local17[local4] = (local17[local4] + $01)
                                        local19 = $01
                                End Select
                                If (local19 <> 0) Then
                                    maptemp(local5, local6) = (maptemp(local5, local6) + $01)
                                    maptemp(local1, local2) = $01
                                    local13[local4] = (local13[local4] + $01)
                                    local3 = (local3 - $01)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local3 = $00) Then
                        Exit
                    EndIf
                Next
                If (local3 = $00) Then
                    Exit
                EndIf
            Next
        EndIf
    Next
    For local4 = $00 To $02 Step $01
        Select local4
            Case $02
                local9 = $02
                local22 = (mapheight / $03)
            Case $01
                local9 = ((mapheight / $03) + $01)
                local22 = (Int (((Float mapheight) * (1.0 / 1.5)) - 1.0))
            Case $00
                local9 = (Int (((Float mapheight) * (1.0 / 1.5)) + 1.0))
                local22 = (mapheight - $02)
        End Select
        If (local17[local4] < $01) Then
            local3 = $00
            For local2 = local9 To local22 Step $01
                For local1 = $02 To (mapwidth - $02) Step $01
                    multiplayer_send($01, $00, $00)
                    If (maptemp(local1, local2) = $03) Then
                        Select $00
                            Case (((maptemp((local1 + $01), local2) Or maptemp((local1 + $01), (local2 + $01))) Or maptemp((local1 + $01), (local2 - $01))) Or maptemp((local1 + $02), local2))
                                maptemp((local1 + $01), local2) = $01
                                local3 = $01
                            Case (((maptemp((local1 - $01), local2) Or maptemp((local1 - $01), (local2 + $01))) Or maptemp((local1 - $01), (local2 - $01))) Or maptemp((local1 - $02), local2))
                                maptemp((local1 - $01), local2) = $01
                                local3 = $01
                            Case (((maptemp(local1, (local2 + $01)) Or maptemp((local1 + $01), (local2 + $01))) Or maptemp((local1 - $01), (local2 + $01))) Or maptemp(local1, (local2 + $02)))
                                maptemp(local1, (local2 + $01)) = $01
                                local3 = $01
                            Case (((maptemp(local1, (local2 - $01)) Or maptemp((local1 + $01), (local2 - $01))) Or maptemp((local1 - $01), (local2 - $01))) Or maptemp(local1, (local2 - $02)))
                                maptemp(local1, (local2 - $01)) = $01
                                local3 = $01
                        End Select
                        If (local3 = $01) Then
                            maptemp(local1, local2) = $04
                            local17[local4] = (local17[local4] + $01)
                            local16[local4] = (local16[local4] - $01)
                            local13[local4] = (local13[local4] + $01)
                        EndIf
                    EndIf
                    If (local3 = $01) Then
                        Exit
                    EndIf
                Next
                If (local3 = $01) Then
                    Exit
                EndIf
            Next
            If (local3 = $00) Then
            EndIf
        EndIf
        If (local15[local4] < $01) Then
            local3 = $00
            local9 = (local9 + $01)
            local22 = (local22 - $01)
            For local2 = local9 To local22 Step $01
                For local1 = $03 To (mapwidth - $03) Step $01
                    multiplayer_send($01, $00, $00)
                    If (maptemp(local1, local2) = $01) Then
                        Select $01
                            Case (maptemp((local1 - $01), local2) > $00)
                                If (((maptemp(local1, (local2 - $01)) + maptemp(local1, (local2 + $01))) + maptemp((local1 + $02), local2)) = $00) Then
                                    If (((maptemp((local1 + $01), (local2 - $02)) + maptemp((local1 + $02), (local2 - $01))) + maptemp((local1 + $01), (local2 - $01))) = $00) Then
                                        maptemp(local1, local2) = $02
                                        maptemp((local1 + $01), local2) = $02
                                        maptemp((local1 + $01), (local2 - $01)) = $01
                                        local3 = $01
                                    ElseIf (((maptemp((local1 + $01), (local2 + $02)) + maptemp((local1 + $02), (local2 + $01))) + maptemp((local1 + $01), (local2 + $01))) = $00) Then
                                        maptemp(local1, local2) = $02
                                        maptemp((local1 + $01), local2) = $02
                                        maptemp((local1 + $01), (local2 + $01)) = $01
                                        local3 = $01
                                    EndIf
                                EndIf
                            Case (maptemp((local1 + $01), local2) > $00)
                                If (((maptemp(local1, (local2 - $01)) + maptemp(local1, (local2 + $01))) + maptemp((local1 - $02), local2)) = $00) Then
                                    If (((maptemp((local1 - $01), (local2 - $02)) + maptemp((local1 - $02), (local2 - $01))) + maptemp((local1 - $01), (local2 - $01))) = $00) Then
                                        maptemp(local1, local2) = $02
                                        maptemp((local1 - $01), local2) = $02
                                        maptemp((local1 - $01), (local2 - $01)) = $01
                                        local3 = $01
                                    ElseIf (((maptemp((local1 - $01), (local2 + $02)) + maptemp((local1 - $02), (local2 + $01))) + maptemp((local1 - $01), (local2 + $01))) = $00) Then
                                        maptemp(local1, local2) = $02
                                        maptemp((local1 - $01), local2) = $02
                                        maptemp((local1 - $01), (local2 + $01)) = $01
                                        local3 = $01
                                    EndIf
                                EndIf
                            Case (maptemp(local1, (local2 - $01)) > $00)
                                If (((maptemp((local1 - $01), local2) + maptemp((local1 + $01), local2)) + maptemp(local1, (local2 + $02))) = $00) Then
                                    If (((maptemp((local1 - $02), (local2 + $01)) + maptemp((local1 - $01), (local2 + $02))) + maptemp((local1 - $01), (local2 + $01))) = $00) Then
                                        maptemp(local1, local2) = $02
                                        maptemp(local1, (local2 + $01)) = $02
                                        maptemp((local1 - $01), (local2 + $01)) = $01
                                        local3 = $01
                                    ElseIf (((maptemp((local1 + $02), (local2 + $01)) + maptemp((local1 + $01), (local2 + $02))) + maptemp((local1 + $01), (local2 + $01))) = $00) Then
                                        maptemp(local1, local2) = $02
                                        maptemp(local1, (local2 + $01)) = $02
                                        maptemp((local1 + $01), (local2 + $01)) = $01
                                        local3 = $01
                                    EndIf
                                EndIf
                            Case (maptemp(local1, (local2 + $01)) > $00)
                                If (((maptemp((local1 - $01), local2) + maptemp((local1 + $01), local2)) + maptemp(local1, (local2 - $02))) = $00) Then
                                    If (((maptemp((local1 - $02), (local2 - $01)) + maptemp((local1 - $01), (local2 - $02))) + maptemp((local1 - $01), (local2 - $01))) = $00) Then
                                        maptemp(local1, local2) = $02
                                        maptemp(local1, (local2 - $01)) = $02
                                        maptemp((local1 - $01), (local2 - $01)) = $01
                                        local3 = $01
                                    ElseIf (((maptemp((local1 + $02), (local2 - $01)) + maptemp((local1 + $01), (local2 - $02))) + maptemp((local1 + $01), (local2 - $01))) = $00) Then
                                        maptemp(local1, local2) = $02
                                        maptemp(local1, (local2 - $01)) = $02
                                        maptemp((local1 + $01), (local2 - $01)) = $01
                                        local3 = $01
                                    EndIf
                                EndIf
                        End Select
                        If (local3 = $01) Then
                            local15[local4] = (local15[local4] + $01)
                            local14[local4] = (local14[local4] + $01)
                        EndIf
                    EndIf
                    If (local3 = $01) Then
                        Exit
                    EndIf
                Next
                If (local3 = $01) Then
                    Exit
                EndIf
            Next
            If (local3 = $00) Then
            EndIf
        EndIf
    Next
    local25 = (($37 * mapwidth) / $14)
    local25 = (Int max((Float local25), (Float (((local13[$00] + local13[$01]) + local13[$02]) + $01))))
    local25 = (Int max((Float local25), (Float (((local14[$00] + local14[$01]) + local14[$02]) + $01))))
    local25 = (Int max((Float local25), (Float (((local15[$00] + local15[$01]) + local15[$02]) + $01))))
    local25 = (Int max((Float local25), (Float (((local16[$00] + local16[$01]) + local16[$02]) + $01))))
    local25 = (Int max((Float local25), (Float (((local17[$00] + local17[$01]) + local17[$02]) + $01))))
    Dim maproom$($06, local25)
    local26 = $01
    local27 = (local13[$00] - $01)
    maproom($01, $00) = "start"
    setroom("roompj", $01, (Int floor((0.1 * (Float local13[$00])))), local26, local27)
    setroom("914", $01, (Int floor((0.3 * (Float local13[$00])))), local26, local27)
    setroom("room1archive", $01, (Int floor((0.5 * (Float local13[$00])))), local26, local27)
    setroom("room205", $01, (Int floor((0.6 * (Float local13[$00])))), local26, local27)
    maproom($03, $00) = "lockroom"
    local26 = $01
    local27 = (local14[$00] - $01)
    maproom($02, $00) = "room2closets"
    setroom("room2testroom2", $02, (Int floor((0.1 * (Float local14[$00])))), local26, local27)
    setroom("room2scps", $02, (Int floor((0.2 * (Float local14[$00])))), local26, local27)
    setroom("room2storage", $02, (Int floor((0.3 * (Float local14[$00])))), local26, local27)
    setroom("room2gw_b", $02, (Int floor((0.4 * (Float local14[$00])))), local26, local27)
    setroom("room2sl", $02, (Int floor((0.5 * (Float local14[$00])))), local26, local27)
    setroom("room012", $02, (Int floor((0.55 * (Float local14[$00])))), local26, local27)
    setroom("room2scps2", $02, (Int floor((0.6 * (Float local14[$00])))), local26, local27)
    setroom("room1123", $02, (Int floor((0.7 * (Float local14[$00])))), local26, local27)
    setroom("room2elevator", $02, (Int floor((0.85 * (Float local14[$00])))), local26, local27)
    maproom($04, (Int floor((rnd(0.2, 0.8) * (Float local16[$00]))))) = "room3storage"
    maproom($03, (Int floor((0.5 * (Float local15[$00]))))) = "room1162"
    maproom($05, (Int floor((0.3 * (Float local17[$00]))))) = "room4info"
    local26 = local13[$00]
    local27 = ((local13[$00] + local13[$01]) - $01)
    setroom("room079", $01, (Int (floor((0.15 * (Float local13[$01]))) + (Float local13[$00]))), local26, local27)
    setroom("room106", $01, (Int (floor((0.3 * (Float local13[$01]))) + (Float local13[$00]))), local26, local27)
    setroom("008", $01, (Int (floor((0.4 * (Float local13[$01]))) + (Float local13[$00]))), local26, local27)
    setroom("room035", $01, (Int (floor((0.5 * (Float local13[$01]))) + (Float local13[$00]))), local26, local27)
    setroom("coffin", $01, (Int (floor((0.7 * (Float local13[$01]))) + (Float local13[$00]))), local26, local27)
    local26 = local14[$00]
    local27 = ((local14[$00] + local14[$01]) - $01)
    maproom($02, (Int (floor((0.1 * (Float local14[$01]))) + (Float local14[$00])))) = "room2nuke"
    setroom("room2tunnel", $02, (Int (floor((0.25 * (Float local14[$01]))) + (Float local14[$00]))), local26, local27)
    setroom("room049", $02, (Int (floor((0.4 * (Float local14[$01]))) + (Float local14[$00]))), local26, local27)
    setroom("room2shaft", $02, (Int (floor((0.6 * (Float local14[$01]))) + (Float local14[$00]))), local26, local27)
    setroom("testroom", $02, (Int (floor((0.7 * (Float local14[$01]))) + (Float local14[$00]))), local26, local27)
    setroom("room2servers", $02, (Int (floor((0.9 * (Float local14[$01]))) + (Float local14[$00]))), local26, local27)
    maproom($04, (Int (floor((0.3 * (Float local16[$01]))) + (Float local16[$00])))) = "room513"
    maproom($04, (Int (floor((0.6 * (Float local16[$01]))) + (Float local16[$00])))) = "room966"
    maproom($03, (Int (floor((0.5 * (Float local15[$01]))) + (Float local15[$00])))) = "room2cpit"
    maproom($01, (((local13[$00] + local13[$01]) + local13[$02]) - $02)) = "exit1"
    maproom($01, (((local13[$00] + local13[$01]) + local13[$02]) - $01)) = "gateaentrance"
    maproom($01, (local13[$00] + local13[$01])) = "room1lifts"
    local26 = (local14[$00] + local14[$01])
    local27 = (((local14[$00] + local14[$01]) + local14[$02]) - $01)
    maproom($02, (Int (floor((0.1 * (Float local14[$02]))) + (Float local26)))) = "room2poffices"
    setroom("room2cafeteria", $02, (Int (floor((0.2 * (Float local14[$02]))) + (Float local26))), local26, local27)
    setroom("room2sroom", $02, (Int (floor((0.3 * (Float local14[$02]))) + (Float local26))), local26, local27)
    setroom("room2servers2", $02, (Int (floor((0.4 * (Float local14[$02]))) + (Float local26))), local26, local27)
    setroom("room2offices", $02, (Int (floor((0.45 * (Float local14[$02]))) + (Float local26))), local26, local27)
    setroom("room2offices4", $02, (Int (floor((0.5 * (Float local14[$02]))) + (Float local26))), local26, local27)
    setroom("room860", $02, (Int (floor((0.6 * (Float local14[$02]))) + (Float local26))), local26, local27)
    setroom("medibay", $02, (Int (floor((0.7 * (Float local14[$02]))) + (Float local26))), local26, local27)
    setroom("room2poffices2", $02, (Int (floor((0.8 * (Float local14[$02]))) + (Float local26))), local26, local27)
    setroom("room2offices2", $02, (Int (floor((0.9 * (Float local14[$02]))) + (Float local26))), local26, local27)
    maproom($03, (local15[$00] + local15[$01])) = "room2ccont"
    maproom($03, ((local15[$00] + local15[$01]) + $01)) = "lockroom2"
    maproom($04, (Int ((Float (local16[$00] + local16[$01])) + floor((0.3 * (Float local16[$02])))))) = "room3servers"
    maproom($04, (Int ((Float (local16[$00] + local16[$01])) + floor((0.7 * (Float local16[$02])))))) = "room3servers2"
    maproom($04, (Int ((Float (local16[$00] + local16[$01])) + floor((0.5 * (Float local16[$02])))))) = "room3offices"
    local3 = $00
    local29 = 8.0
    local2 = (mapheight - $01)
    While (local2 >= $01)
        multiplayer_send($01, $00, $00)
        If (local2 < ((mapheight / $03) + $01)) Then
            local9 = $03
        ElseIf ((Float local2) < ((Float mapheight) * (1.0 / 1.5))) Then
            local9 = $02
        Else
            local9 = $01
        EndIf
        For local1 = $01 To (mapwidth - $02) Step $01
            If (maptemp(local1, local2) = $FF) Then
                If ((Float local2) > ((Float mapheight) * 0.5)) Then
                    local28 = createroom(local9, $02, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), "checkpoint1", $00)
                Else
                    local28 = createroom(local9, $02, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), "checkpoint2", $00)
                EndIf
            ElseIf (maptemp(local1, local2) > $00) Then
                local3 = (Int (((min((Float maptemp((local1 + $01), local2)), 1.0) + min((Float maptemp((local1 - $01), local2)), 1.0)) + min((Float maptemp(local1, (local2 + $01))), 1.0)) + min((Float maptemp(local1, (local2 - $01))), 1.0)))
                Select local3
                    Case $01
                        If (((maproomid($01) < local25) And (mapname(local1, local2) = "")) <> 0) Then
                            If (maproom($01, maproomid($01)) <> "") Then
                                mapname(local1, local2) = maproom($01, maproomid($01))
                            EndIf
                        EndIf
                        local28 = createroom(local9, $01, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                        If (maptemp(local1, (local2 + $01)) <> 0) Then
                            local28\Field7 = $B4
                            turnentity(local28\Field3, 0.0, (Float local28\Field7), 0.0, $00)
                        ElseIf (maptemp((local1 - $01), local2) <> 0) Then
                            local28\Field7 = $10E
                            turnentity(local28\Field3, 0.0, (Float local28\Field7), 0.0, $00)
                        ElseIf (maptemp((local1 + $01), local2) <> 0) Then
                            local28\Field7 = $5A
                            turnentity(local28\Field3, 0.0, (Float local28\Field7), 0.0, $00)
                        Else
                            local28\Field7 = $00
                        EndIf
                        maproomid($01) = (maproomid($01) + $01)
                    Case $02
                        If (((maptemp((local1 - $01), local2) > $00) And (maptemp((local1 + $01), local2) > $00)) <> 0) Then
                            If (((maproomid($02) < local25) And (mapname(local1, local2) = "")) <> 0) Then
                                If (maproom($02, maproomid($02)) <> "") Then
                                    mapname(local1, local2) = maproom($02, maproomid($02))
                                EndIf
                            EndIf
                            local28 = createroom(local9, $02, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                            If (rand($02, $01) = $01) Then
                                local28\Field7 = $5A
                            Else
                                local28\Field7 = $10E
                            EndIf
                            turnentity(local28\Field3, 0.0, (Float local28\Field7), 0.0, $00)
                            maproomid($02) = (maproomid($02) + $01)
                        ElseIf (((maptemp(local1, (local2 - $01)) > $00) And (maptemp(local1, (local2 + $01)) > $00)) <> 0) Then
                            If (((maproomid($02) < local25) And (mapname(local1, local2) = "")) <> 0) Then
                                If (maproom($02, maproomid($02)) <> "") Then
                                    mapname(local1, local2) = maproom($02, maproomid($02))
                                EndIf
                            EndIf
                            local28 = createroom(local9, $02, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                            If (rand($02, $01) = $01) Then
                                local28\Field7 = $B4
                            Else
                                local28\Field7 = $00
                            EndIf
                            turnentity(local28\Field3, 0.0, (Float local28\Field7), 0.0, $00)
                            maproomid($02) = (maproomid($02) + $01)
                        Else
                            If (((maproomid($03) < local25) And (mapname(local1, local2) = "")) <> 0) Then
                                If (maproom($03, maproomid($03)) <> "") Then
                                    mapname(local1, local2) = maproom($03, maproomid($03))
                                EndIf
                            EndIf
                            If (((maptemp((local1 - $01), local2) > $00) And (maptemp(local1, (local2 + $01)) > $00)) <> 0) Then
                                local28 = createroom(local9, $03, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                                local28\Field7 = $B4
                                turnentity(local28\Field3, 0.0, (Float local28\Field7), 0.0, $00)
                            ElseIf (((maptemp((local1 + $01), local2) > $00) And (maptemp(local1, (local2 + $01)) > $00)) <> 0) Then
                                local28 = createroom(local9, $03, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                                local28\Field7 = $5A
                                turnentity(local28\Field3, 0.0, (Float local28\Field7), 0.0, $00)
                            ElseIf (((maptemp((local1 - $01), local2) > $00) And (maptemp(local1, (local2 - $01)) > $00)) <> 0) Then
                                local28 = createroom(local9, $03, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                                turnentity(local28\Field3, 0.0, 270.0, 0.0, $00)
                                local28\Field7 = $10E
                            Else
                                local28 = createroom(local9, $03, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                            EndIf
                            maproomid($03) = (maproomid($03) + $01)
                        EndIf
                    Case $03
                        If (((maproomid($04) < local25) And (mapname(local1, local2) = "")) <> 0) Then
                            If (maproom($04, maproomid($04)) <> "") Then
                                mapname(local1, local2) = maproom($04, maproomid($04))
                            EndIf
                        EndIf
                        local28 = createroom(local9, $04, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                        If (maptemp(local1, (local2 - $01)) = $00) Then
                            turnentity(local28\Field3, 0.0, 180.0, 0.0, $00)
                            local28\Field7 = $B4
                        ElseIf (maptemp((local1 - $01), local2) = $00) Then
                            turnentity(local28\Field3, 0.0, 90.0, 0.0, $00)
                            local28\Field7 = $5A
                        ElseIf (maptemp((local1 + $01), local2) = $00) Then
                            turnentity(local28\Field3, 0.0, -90.0, 0.0, $00)
                            local28\Field7 = $10E
                        EndIf
                        maproomid($04) = (maproomid($04) + $01)
                    Case $04
                        If (((maproomid($05) < local25) And (mapname(local1, local2) = "")) <> 0) Then
                            If (maproom($05, maproomid($05)) <> "") Then
                                mapname(local1, local2) = maproom($05, maproomid($05))
                            EndIf
                        EndIf
                        local28 = createroom(local9, $05, (Float (local1 Shl $03)), 0.0, (Float (local2 Shl $03)), mapname(local1, local2), $00)
                        maproomid($05) = (maproomid($05) + $01)
                End Select
            EndIf
        Next
        local2 = (local2 + $FFFFFFFF)
    Wend
    local28 = createroom($00, $01, (Float ((mapwidth - $01) Shl $03)), 40.5, 8.0, "gatea", $00)
    maproomid($01) = (maproomid($01) + $01)
    local28 = createroom($00, $01, (Float ((mapwidth - $01) Shl $03)), 0.0, (Float ((mapheight - $01) Shl $03)), "pocketdimension", $00)
    maproomid($01) = (maproomid($01) + $01)
    local28 = createroom($00, $01, 8.0, 0.0, (Float ((mapheight - $01) Shl $03)), "173", $00)
    maproomid($01) = (maproomid($01) + $01)
    local28 = createroom($00, $01, 8.0, 800.0, 0.0, "dimension1499", $00)
    maproomid($01) = (maproomid($01) + $01)
    For local2 = $00 To mapheight Step $01
        For local1 = $00 To mapwidth Step $01
            multiplayer_send($01, $00, $00)
            maptemp(local1, local2) = (Int min((Float maptemp(local1, local2)), 1.0))
        Next
    Next
    local2 = mapheight
    While (local2 >= $00)
        multiplayer_send($01, $00, $00)
        If (local2 < (i_zone\Field0[$01] - $01)) Then
            local9 = $03
        ElseIf (((local2 >= (i_zone\Field0[$01] - $01)) And (local2 < (i_zone\Field0[$00] - $01))) <> 0) Then
            local9 = $02
        Else
            local9 = $01
        EndIf
        local1 = mapwidth
        While (local1 >= $00)
            If (maptemp(local1, local2) > $00) Then
                If (local9 = $02) Then
                    local3 = $02
                Else
                    local3 = $00
                EndIf
                For local28 = Each rooms
                    local28\Field7 = (Int wrapangle((Float local28\Field7)))
                    If ((((Int (local28\Field4 / 8.0)) = local1) And ((Int (local28\Field6 / 8.0)) = local2)) <> 0) Then
                        local32 = $00
                        Select local28\Field8\Field10
                            Case $01
                                If (local28\Field7 = $5A) Then
                                    local32 = $01
                                EndIf
                            Case $02
                                If (((local28\Field7 = $5A) Or (local28\Field7 = $10E)) <> 0) Then
                                    local32 = $01
                                EndIf
                            Case $03
                                If (((local28\Field7 = $00) Or (local28\Field7 = $5A)) <> 0) Then
                                    local32 = $01
                                EndIf
                            Case $04
                                If ((((local28\Field7 = $00) Or (local28\Field7 = $B4)) Or (local28\Field7 = $5A)) <> 0) Then
                                    local32 = $01
                                EndIf
                            Default
                                local32 = $01
                        End Select
                        If (local32 <> 0) Then
                            If ((local1 + $01) < (mapwidth + $01)) Then
                                If (maptemp((local1 + $01), local2) > $00) Then
                                    local31 = createdoor(local28\Field0, (((Float local1) * local29) + (local29 / 2.0)), 0.0, ((Float local2) * local29), 90.0, local28, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), local3, $00, "")
                                    local28\Field35[$00] = local31
                                EndIf
                            EndIf
                        EndIf
                        local32 = $00
                        Select local28\Field8\Field10
                            Case $01
                                If (local28\Field7 = $B4) Then
                                    local32 = $01
                                EndIf
                            Case $02
                                If (((local28\Field7 = $00) Or (local28\Field7 = $B4)) <> 0) Then
                                    local32 = $01
                                EndIf
                            Case $03
                                If (((local28\Field7 = $B4) Or (local28\Field7 = $5A)) <> 0) Then
                                    local32 = $01
                                EndIf
                            Case $04
                                If ((((local28\Field7 = $B4) Or (local28\Field7 = $5A)) Or (local28\Field7 = $10E)) <> 0) Then
                                    local32 = $01
                                EndIf
                            Default
                                local32 = $01
                        End Select
                        If (local32 <> 0) Then
                            If ((local2 + $01) < (mapheight + $01)) Then
                                If (maptemp(local1, (local2 + $01)) > $00) Then
                                    local31 = createdoor(local28\Field0, ((Float local1) * local29), 0.0, (((Float local2) * local29) + (local29 / 2.0)), 0.0, local28, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), local3, $00, "")
                                    local28\Field35[$03] = local31
                                EndIf
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local1 = (local1 + $FFFFFFFF)
        Wend
        local2 = (local2 + $FFFFFFFF)
    Wend
    For local28 = Each rooms
        local28\Field7 = (Int wrapangle((Float local28\Field7)))
        local28\Field34[$00] = Null
        local28\Field34[$01] = Null
        local28\Field34[$02] = Null
        local28\Field34[$03] = Null
        For local35 = Each rooms
            If (local28 <> local35) Then
                If (local28\Field6 = local35\Field6) Then
                    If ((local28\Field4 + 8.0) = local35\Field4) Then
                        local28\Field34[$00] = local35
                        If (local28\Field35[$00] = Null) Then
                            local28\Field35[$00] = local35\Field35[$02]
                        EndIf
                    ElseIf ((local28\Field4 - 8.0) = local35\Field4) Then
                        local28\Field34[$02] = local35
                        If (local28\Field35[$02] = Null) Then
                            local28\Field35[$02] = local35\Field35[$00]
                        EndIf
                    EndIf
                ElseIf (local28\Field4 = local35\Field4) Then
                    If ((local28\Field6 - 8.0) = local35\Field6) Then
                        local28\Field34[$01] = local35
                        If (local28\Field35[$01] = Null) Then
                            local28\Field35[$01] = local35\Field35[$03]
                        EndIf
                    ElseIf ((local28\Field6 + 8.0) = local35\Field6) Then
                        local28\Field34[$03] = local35
                        If (local28\Field35[$03] = Null) Then
                            local28\Field35[$03] = local35\Field35[$01]
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (((((local28\Field34[$00] <> Null) And (local28\Field34[$01] <> Null)) And (local28\Field34[$02] <> Null)) And (local28\Field34[$03] <> Null)) <> 0) Then
                Exit
            EndIf
        Next
    Next
    multiplayer_send($01, $00, $00)
    Return $00
End Function
