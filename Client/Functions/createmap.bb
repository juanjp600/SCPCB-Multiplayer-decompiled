Function createmap%()
    Local local0.rooms
    Local local1.rooms
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
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local26%
    Local local28%
    i_zone\Field0[$00] = (Int (floor(14.0) + 1.0))
    i_zone\Field0[$01] = (Int (floor(7.0) + 1.0))
    i_zone\Field1 = $00
    i_zone\Field2 = $00
    seedrnd(generateseednumber(randomseed))
    Delete currmapgrid
    currmapgrid = (New mapgrid)
    local3 = $0A
    local4 = $13
    For local7 = local4 To $14 Step $01
        currmapgrid\Field0[((local7 * $15) + local3)] = $01
    Next
    Repeat
        local8 = (Int floor(12.6))
        local10 = rand(local8, (Int floor(17.85)))
        If (local3 > local8) Then
            local10 = (- local10)
        ElseIf (floor(8.400001) < (Float local3)) Then
            local3 = (local3 - (local10 Sar $01))
        EndIf
        If ((local3 + local10) > $12) Then
            local10 = ($12 - local3)
        ElseIf ((local3 + local10) < $02) Then
            local10 = ((- local3) + $02)
        EndIf
        local3 = (Int min((Float local3), (Float (local3 + local10))))
        local10 = ((local10 Xor (- (local10 < 0))) - (- (local10 < 0)))
        For local7 = local3 To (local3 + local10) Step $01
            currmapgrid\Field0[(Int (min((Float local7), 21.0) + (Float (local4 * $15))))] = $01
        Next
        local11 = rand($03, $04)
        If ((local4 - local11) < $01) Then
            local11 = (local4 - $01)
        EndIf
        local13 = rand($04, $05)
        If (getzone((local4 - local11)) <> getzone(((local4 - local11) + $01))) Then
            local11 = (local11 - $01)
        EndIf
        For local7 = $01 To local13 Step $01
            local8 = (Int clamp((Float rand(local3, ((local3 + local10) - $01))), 2.0, 19.0))
            While (((currmapgrid\Field0[(((local4 - $01) * $15) + local8)] Lor currmapgrid\Field0[((local8 - $01) + ((local4 - $01) * $15))]) Lor currmapgrid\Field0[((local8 + $01) + ((local4 - $01) * $15))]) <> 0)
                local8 = (local8 + $01)
            Wend
            If (local8 < (local3 + local10)) Then
                If (local7 = $01) Then
                    local12 = local11
                    If (rand($02, $01) = $01) Then
                        local8 = local3
                    Else
                        local8 = (local3 + local10)
                    EndIf
                Else
                    local12 = rand(local11, $01)
                EndIf
                For local9 = (local4 - local12) To local4 Step $01
                    If (getzone(local9) <> getzone((local9 + $01))) Then
                        currmapgrid\Field0[((local9 * $15) + local8)] = $FF
                    Else
                        currmapgrid\Field0[((local9 * $15) + local8)] = $01
                    EndIf
                Next
                If (local12 = local11) Then
                    local5 = local8
                EndIf
            EndIf
        Next
        local3 = local5
        local4 = (local4 - local11)
    Until (local4 < $02)
    Dim roomamount%($05, $03)
    For local4 = $01 To $14 Step $01
        local15 = getzone(local4)
        For local3 = $01 To $14 Step $01
            If (currmapgrid\Field0[((local4 * $15) + local3)] > $00) Then
                local5 = $00
                local5 = (Int (((min((Float currmapgrid\Field0[((local3 + $01) + (local4 * $15))]), 1.0) + min((Float currmapgrid\Field0[((local3 - $01) + (local4 * $15))]), 1.0)) + min((Float currmapgrid\Field0[(((local4 + $01) * $15) + local3)]), 1.0)) + min((Float currmapgrid\Field0[(((local4 - $01) * $15) + local3)]), 1.0)))
                If (currmapgrid\Field0[((local4 * $15) + local3)] <> $FF) Then
                    currmapgrid\Field0[((local4 * $15) + local3)] = local5
                EndIf
                Select currmapgrid\Field0[((local4 * $15) + local3)]
                    Case $01
                        roomamount($00, local15) = (roomamount($00, local15) + $01)
                    Case $02
                        If (2.0 = (min((Float currmapgrid\Field0[((local3 + $01) + (local4 * $15))]), 1.0) + min((Float currmapgrid\Field0[((local3 - $01) + (local4 * $15))]), 1.0))) Then
                            roomamount($01, local15) = (roomamount($01, local15) + $01)
                        ElseIf (2.0 = (min((Float currmapgrid\Field0[(((local4 + $01) * $15) + local3)]), 1.0) + min((Float currmapgrid\Field0[(((local4 - $01) * $15) + local3)]), 1.0))) Then
                            roomamount($01, local15) = (roomamount($01, local15) + $01)
                        Else
                            roomamount($02, local15) = (roomamount($02, local15) + $01)
                        EndIf
                    Case $03
                        roomamount($03, local15) = (roomamount($03, local15) + $01)
                    Case $04
                        roomamount($04, local15) = (roomamount($04, local15) + $01)
                End Select
            EndIf
        Next
    Next
    For local7 = $00 To $02 Step $01
        local5 = ((- roomamount($00, local7)) + $05)
        If (local5 > $00) Then
            If (local7 = $02) Then
                local19 = $01
            Else
                local19 = i_zone\Field0[local7]
            EndIf
            If (local7 = $00) Then
                local20 = $13
            Else
                local20 = (i_zone\Field0[(local7 - $01)] - $01)
            EndIf
            local21 = $01
            local22 = $13
            For local4 = local19 To local20 Step $01
                For local3 = local21 To local22 Step $01
                    If (currmapgrid\Field0[((local4 * $15) + local3)] = $00) Then
                        If (1.0 = (((min((Float currmapgrid\Field0[((local3 + $01) + (local4 * $15))]), 1.0) + min((Float currmapgrid\Field0[((local3 - $01) + (local4 * $15))]), 1.0)) + min((Float currmapgrid\Field0[(((local4 + $01) * $15) + local3)]), 1.0)) + min((Float currmapgrid\Field0[(((local4 - $01) * $15) + local3)]), 1.0))) Then
                            If (currmapgrid\Field0[((local3 + $01) + (local4 * $15))] <> 0) Then
                                local8 = (local3 + $01)
                                local9 = local4
                            ElseIf (currmapgrid\Field0[((local3 - $01) + (local4 * $15))] <> 0) Then
                                local8 = (local3 - $01)
                                local9 = local4
                            ElseIf (currmapgrid\Field0[(((local4 + $01) * $15) + local3)] <> 0) Then
                                local8 = local3
                                local9 = (local4 + $01)
                            ElseIf (currmapgrid\Field0[(((local4 - $01) * $15) + local3)] <> 0) Then
                                local8 = local3
                                local9 = (local4 - $01)
                            EndIf
                            local18 = $00
                            If ((((currmapgrid\Field0[((local9 * $15) + local8)] > $01) And (currmapgrid\Field0[((local9 * $15) + local8)] < $04)) And (((local4 < local20) Lor (local9 < local4)) Lor (local7 = $00))) <> 0) Then
                                Select currmapgrid\Field0[((local9 * $15) + local8)]
                                    Case $02
                                        If (2.0 = (min((Float currmapgrid\Field0[((local8 + $01) + (local9 * $15))]), 1.0) + min((Float currmapgrid\Field0[((local8 - $01) + (local9 * $15))]), 1.0))) Then
                                            roomamount($01, local7) = (roomamount($01, local7) - $01)
                                            roomamount($03, local7) = (roomamount($03, local7) + $01)
                                            local18 = $01
                                        ElseIf (2.0 = (min((Float currmapgrid\Field0[(((local9 + $01) * $15) + local8)]), 1.0) + min((Float currmapgrid\Field0[(((local9 - $01) * $15) + local8)]), 1.0))) Then
                                            roomamount($01, local7) = (roomamount($01, local7) - $01)
                                            roomamount($03, local7) = (roomamount($03, local7) + $01)
                                            local18 = $01
                                        EndIf
                                    Case $03
                                        roomamount($03, local7) = (roomamount($03, local7) - $01)
                                        roomamount($04, local7) = (roomamount($04, local7) + $01)
                                        local18 = $01
                                End Select
                                If (local18 <> 0) Then
                                    currmapgrid\Field0[((local9 * $15) + local8)] = (currmapgrid\Field0[((local9 * $15) + local8)] + $01)
                                    currmapgrid\Field0[((local4 * $15) + local3)] = $01
                                    roomamount($00, local7) = (roomamount($00, local7) + $01)
                                    local5 = (local5 - $01)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local5 = $00) Then
                        Exit
                    EndIf
                Next
                If (local5 = $00) Then
                    Exit
                EndIf
            Next
        EndIf
    Next
    For local7 = $00 To $02 Step $01
        If (local7 = $02) Then
            local19 = $02
        Else
            local19 = i_zone\Field0[local7]
        EndIf
        If (local7 = $00) Then
            local20 = $13
        Else
            local20 = (i_zone\Field0[(local7 - $01)] - $02)
        EndIf
        local21 = $01
        local22 = $13
        If (roomamount($04, local7) < $01) Then
            local5 = $00
            For local4 = local19 To local20 Step $01
                For local3 = local21 To local22 Step $01
                    If (currmapgrid\Field0[((local4 * $15) + local3)] = $03) Then
                        Select $00
                            Case ((((currmapgrid\Field0[((local3 + $01) + (local4 * $15))] Lor currmapgrid\Field0[((local3 + $01) + ((local4 + $01) * $15))]) Lor currmapgrid\Field0[((local3 + $01) + ((local4 - $01) * $15))]) Lor currmapgrid\Field0[((local3 + $02) + (local4 * $15))]) Lor (local3 = local22))
                                currmapgrid\Field0[((local3 + $01) + (local4 * $15))] = $01
                                local5 = $01
                            Case ((((currmapgrid\Field0[((local3 - $01) + (local4 * $15))] Lor currmapgrid\Field0[((local3 - $01) + ((local4 + $01) * $15))]) Lor currmapgrid\Field0[((local3 - $01) + ((local4 - $01) * $15))]) Lor currmapgrid\Field0[((local3 - $02) + (local4 * $15))]) Lor (local3 = local21))
                                currmapgrid\Field0[((local3 - $01) + (local4 * $15))] = $01
                                local5 = $01
                            Case ((((currmapgrid\Field0[(((local4 + $01) * $15) + local3)] Lor currmapgrid\Field0[((local3 + $01) + ((local4 + $01) * $15))]) Lor currmapgrid\Field0[((local3 - $01) + ((local4 + $01) * $15))]) Lor currmapgrid\Field0[(((local4 + $02) * $15) + local3)]) Lor ((local7 = $00) And (local4 = local20)))
                                currmapgrid\Field0[(((local4 + $01) * $15) + local3)] = $01
                                local5 = $01
                            Case ((((currmapgrid\Field0[(((local4 - $01) * $15) + local3)] Lor currmapgrid\Field0[((local3 + $01) + ((local4 - $01) * $15))]) Lor currmapgrid\Field0[((local3 - $01) + ((local4 - $01) * $15))]) Lor currmapgrid\Field0[(((local4 - $02) * $15) + local3)]) Lor ((local7 < $02) And (local4 = local19)))
                                currmapgrid\Field0[(((local4 - $01) * $15) + local3)] = $01
                                local5 = $01
                        End Select
                        If (local5 = $01) Then
                            currmapgrid\Field0[((local4 * $15) + local3)] = $04
                            roomamount($04, local7) = (roomamount($04, local7) + $01)
                            roomamount($03, local7) = (roomamount($03, local7) - $01)
                            roomamount($00, local7) = (roomamount($00, local7) + $01)
                        EndIf
                    EndIf
                    If (local5 = $01) Then
                        Exit
                    EndIf
                Next
                If (local5 = $01) Then
                    Exit
                EndIf
            Next
        EndIf
        If (roomamount($02, local7) < $02) Then
            local5 = $00
            local4 = local20
            While (local4 >= local19)
                For local3 = local21 To local22 Step $01
                    If (currmapgrid\Field0[((local4 * $15) + local3)] = $01) Then
                        Select $01
                            Case (currmapgrid\Field0[((local3 - $01) + (local4 * $15))] > $00)
                                If (((((currmapgrid\Field0[((local3 + $01) + ((local4 - $01) * $15))] + currmapgrid\Field0[((local3 + $01) + ((local4 + $01) * $15))]) + currmapgrid\Field0[((local3 + $02) + (local4 * $15))]) = $00) And (local3 < local22)) <> 0) Then
                                    If ((((currmapgrid\Field0[((local3 + $01) + ((local4 - $02) * $15))] + currmapgrid\Field0[((local3 + $02) + ((local4 - $01) * $15))]) = $00) And ((local4 > local19) Lor (local7 = $02))) <> 0) Then
                                        currmapgrid\Field0[((local4 * $15) + local3)] = $02
                                        currmapgrid\Field0[((local3 + $01) + (local4 * $15))] = $02
                                        currmapgrid\Field0[((local3 + $01) + ((local4 - $01) * $15))] = $01
                                        local5 = $01
                                    ElseIf ((((currmapgrid\Field0[((local3 + $01) + ((local4 + $02) * $15))] + currmapgrid\Field0[((local3 + $02) + ((local4 + $01) * $15))]) = $00) And ((local4 < local20) Lor (local7 > $00))) <> 0) Then
                                        currmapgrid\Field0[((local4 * $15) + local3)] = $02
                                        currmapgrid\Field0[((local3 + $01) + (local4 * $15))] = $02
                                        currmapgrid\Field0[((local3 + $01) + ((local4 + $01) * $15))] = $01
                                        local5 = $01
                                    EndIf
                                EndIf
                            Case (currmapgrid\Field0[((local3 + $01) + (local4 * $15))] > $00)
                                If (((((currmapgrid\Field0[((local3 - $01) + ((local4 - $01) * $15))] + currmapgrid\Field0[((local3 - $01) + ((local4 + $01) * $15))]) + currmapgrid\Field0[((local3 - $02) + (local4 * $15))]) = $00) And (local3 > local21)) <> 0) Then
                                    If ((((currmapgrid\Field0[((local3 - $01) + ((local4 - $02) * $15))] + currmapgrid\Field0[((local3 - $02) + ((local4 - $01) * $15))]) = $00) And ((local4 > local19) Lor (local7 = $02))) <> 0) Then
                                        currmapgrid\Field0[((local4 * $15) + local3)] = $02
                                        currmapgrid\Field0[((local3 - $01) + (local4 * $15))] = $02
                                        currmapgrid\Field0[((local3 - $01) + ((local4 - $01) * $15))] = $01
                                        local5 = $01
                                    ElseIf ((((currmapgrid\Field0[((local3 - $01) + ((local4 + $02) * $15))] + currmapgrid\Field0[((local3 - $02) + ((local4 + $01) * $15))]) = $00) And ((local4 < local20) Lor (local7 > $00))) <> 0) Then
                                        currmapgrid\Field0[((local4 * $15) + local3)] = $02
                                        currmapgrid\Field0[((local3 - $01) + (local4 * $15))] = $02
                                        currmapgrid\Field0[((local3 - $01) + ((local4 + $01) * $15))] = $01
                                        local5 = $01
                                    EndIf
                                EndIf
                            Case (currmapgrid\Field0[(((local4 - $01) * $15) + local3)] > $00)
                                If (((((currmapgrid\Field0[((local3 - $01) + ((local4 + $01) * $15))] + currmapgrid\Field0[((local3 + $01) + ((local4 + $01) * $15))]) + currmapgrid\Field0[(((local4 + $02) * $15) + local3)]) = $00) And ((local4 < local20) Lor (local7 > $00))) <> 0) Then
                                    If ((((currmapgrid\Field0[((local3 - $02) + ((local4 + $01) * $15))] + currmapgrid\Field0[((local3 - $01) + ((local4 + $02) * $15))]) = $00) And (local3 > local21)) <> 0) Then
                                        currmapgrid\Field0[((local4 * $15) + local3)] = $02
                                        currmapgrid\Field0[(((local4 + $01) * $15) + local3)] = $02
                                        currmapgrid\Field0[((local3 - $01) + ((local4 + $01) * $15))] = $01
                                        local5 = $01
                                    ElseIf ((((currmapgrid\Field0[((local3 + $02) + ((local4 + $01) * $15))] + currmapgrid\Field0[((local3 + $01) + ((local4 + $02) * $15))]) = $00) And (local3 < local22)) <> 0) Then
                                        currmapgrid\Field0[((local4 * $15) + local3)] = $02
                                        currmapgrid\Field0[(((local4 + $01) * $15) + local3)] = $02
                                        currmapgrid\Field0[((local3 + $01) + ((local4 + $01) * $15))] = $01
                                        local5 = $01
                                    EndIf
                                EndIf
                            Case (currmapgrid\Field0[(((local4 + $01) * $15) + local3)] > $00)
                                If (((((currmapgrid\Field0[((local3 - $01) + ((local4 - $01) * $15))] + currmapgrid\Field0[((local3 + $01) + ((local4 - $01) * $15))]) + currmapgrid\Field0[(((local4 - $02) * $15) + local3)]) = $00) And ((local4 > local19) Lor (local7 = $02))) <> 0) Then
                                    If ((((currmapgrid\Field0[((local3 - $02) + ((local4 - $01) * $15))] + currmapgrid\Field0[((local3 - $01) + ((local4 - $02) * $15))]) = $00) And (local3 > local21)) <> 0) Then
                                        currmapgrid\Field0[((local4 * $15) + local3)] = $02
                                        currmapgrid\Field0[(((local4 - $01) * $15) + local3)] = $02
                                        currmapgrid\Field0[((local3 - $01) + ((local4 - $01) * $15))] = $01
                                        local5 = $01
                                    ElseIf ((((currmapgrid\Field0[((local3 + $02) + ((local4 - $01) * $15))] + currmapgrid\Field0[((local3 + $01) + ((local4 - $02) * $15))]) = $00) And (local3 < local22)) <> 0) Then
                                        currmapgrid\Field0[((local4 * $15) + local3)] = $02
                                        currmapgrid\Field0[(((local4 - $01) * $15) + local3)] = $02
                                        currmapgrid\Field0[((local3 + $01) + ((local4 - $01) * $15))] = $01
                                        local5 = $01
                                    EndIf
                                EndIf
                        End Select
                        If (local5 = $01) Then
                            roomamount($02, local7) = (roomamount($02, local7) + $01)
                            roomamount($01, local7) = (roomamount($01, local7) + $01)
                        EndIf
                    EndIf
                    If (local5 = $01) Then
                        Exit
                    EndIf
                Next
                If (local5 = $01) Then
                    Exit
                EndIf
                local4 = (local4 + $FFFFFFFF)
            Wend
        EndIf
    Next
    local26 = ((roomamount($00, $00) + roomamount($00, $01)) + roomamount($00, $02))
    local26 = (Int max((Float local26), (Float ((roomamount($01, $00) + roomamount($01, $01)) + roomamount($01, $02)))))
    local26 = (Int max((Float local26), (Float ((roomamount($02, $00) + roomamount($02, $01)) + roomamount($02, $02)))))
    local26 = (Int max((Float local26), (Float ((roomamount($03, $00) + roomamount($03, $01)) + roomamount($03, $02)))))
    local26 = (Int max((Float local26), (Float ((roomamount($04, $00) + roomamount($04, $01)) + roomamount($04, $02)))))
    Dim maproom$($05, local26)
    setroom($00, $00, "cont1_173", 0.0)
    setroom($00, $00, "cont1_005", 0.15)
    setroom($00, $00, "room1_storage", 0.35)
    setroom($00, $00, "cont1_914", 0.5)
    setroom($00, $00, "cont1_205", 0.65)
    setroom($00, $01, "room2_closets", 0.0)
    setroom($00, $01, "room2_test_lcz", 0.1)
    setroom($00, $01, "cont2_427_714_860_1025", 0.2)
    setroom($00, $01, "room2_storage", 0.3)
    setroom($00, $01, "room2_gw_2", 0.4)
    setroom($00, $01, "cont2_012", 0.5)
    setroom($00, $01, "room2_sl", 0.55)
    setroom($00, $01, "cont2_500_1499", 0.6)
    setroom($00, $01, "cont2_1123", 0.75)
    setroom($00, $01, "room2_js", 0.85)
    setroom($00, $01, "room2_elevator", 0.9)
    setroom($00, $02, "cont2c_066_1162_arc", 0.0)
    setroom($00, $02, "room2c_gw_lcz", 0.5)
    setroom($00, $03, "room3_storage", rnd(0.2, 0.6))
    setroom($00, $03, "cont3_372", 0.8)
    setroom($00, $04, "room4_ic", 0.3)
    setroom($01, $00, "cont1_079", 0.15)
    setroom($01, $00, "cont1_106", 0.3)
    setroom($01, $00, "cont1_035", 0.45)
    setroom($01, $00, "cont1_895", 0.7)
    setroom($01, $01, "room2_nuke", 0.1)
    setroom($01, $01, "cont2_409", 0.15)
    setroom($01, $01, "room2_mt", 0.25)
    setroom($01, $01, "cont2_008", 0.4)
    setroom($01, $01, "room2_shaft", 0.5)
    setroom($01, $01, "cont2_049", 0.6)
    setroom($01, $01, "room2_test_hcz", 0.7)
    setroom($01, $01, "room2_servers_hcz", 0.9)
    setroom($01, $02, "cont2c_096", 0.5)
    setroom($01, $03, "cont3_513", 0.5)
    setroom($01, $03, "cont3_966", 0.8)
    setroom($02, $00, "gate_b_entrance", 1.0)
    setroom($02, $00, "gate_a_entrance", 1.0)
    setroom($02, $00, "room1_o5", 1.0)
    setroom($02, $00, "room1_lifts", 0.0)
    setroom($02, $01, "room2_scientists", 0.1)
    setroom($02, $01, "room2_cafeteria", 0.2)
    setroom($02, $01, "room2_6_ez", 0.25)
    setroom($02, $01, "room2_office_3", 0.3)
    setroom($02, $01, "room2_servers_ez", 0.4)
    setroom($02, $01, "room2_office", 0.5)
    setroom($02, $01, "room2_office_2", 0.55)
    setroom($02, $01, "cont2_860_1", 0.6)
    setroom($02, $01, "room2_medibay", 0.7)
    setroom($02, $01, "room2_scientists_2", 0.8)
    setroom($02, $01, "room2_ic", 0.9)
    setroom($02, $02, "room2c_ec", 0.0)
    setroom($02, $02, "room2c_2_ez", 0.0)
    setroom($02, $03, "room3_2_ez", 0.3)
    setroom($02, $03, "room3_office", 0.5)
    setroom($02, $03, "room3_3_ez", 0.7)
    local5 = $00
    local4 = $14
    While (local4 >= $01)
        If (local4 < $08) Then
            local15 = $03
        ElseIf (14.0 > (Float local4)) Then
            local15 = $02
        Else
            local15 = $01
        EndIf
        For local3 = $01 To $13 Step $01
            If (currmapgrid\Field0[((local4 * $15) + local3)] = $FF) Then
                If (local4 > $0A) Then
                    local16 = $27
                Else
                    local16 = $45
                EndIf
                local0 = createroom(local15, $01, ((Float local3) * 8.0), 0.0, ((Float local4) * 8.0), local16, 0.0)
                currmapgrid\Field3[((local4 * $15) + local3)] = local0\Field7\Field5
                calculateroomextents(local0)
            ElseIf (currmapgrid\Field0[((local4 * $15) + local3)] > $00) Then
                local16 = $FFFFFFFF
                local5 = (Int (((min((Float currmapgrid\Field0[((local3 + $01) + (local4 * $15))]), 1.0) + min((Float currmapgrid\Field0[((local3 - $01) + (local4 * $15))]), 1.0)) + min((Float currmapgrid\Field0[(((local4 + $01) * $15) + local3)]), 1.0)) + min((Float currmapgrid\Field0[(((local4 - $01) * $15) + local3)]), 1.0)))
                Select local5
                    Case $01
                        If (currmapgrid\Field4[$00] < local26) Then
                            If (maproom($00, currmapgrid\Field4[$00]) <> "") Then
                                local16 = findroomid(maproom($00, currmapgrid\Field4[$00]))
                            EndIf
                        EndIf
                        If (currmapgrid\Field0[(((local4 + $01) * $15) + local3)] <> 0) Then
                            currmapgrid\Field1[((local4 * $15) + local3)] = $02
                        ElseIf (currmapgrid\Field0[((local3 - $01) + (local4 * $15))] <> 0) Then
                            currmapgrid\Field1[((local4 * $15) + local3)] = $03
                        ElseIf (currmapgrid\Field0[((local3 + $01) + (local4 * $15))] <> 0) Then
                            currmapgrid\Field1[((local4 * $15) + local3)] = $01
                        Else
                            currmapgrid\Field1[((local4 * $15) + local3)] = $00
                        EndIf
                        local0 = createroom(local15, $00, ((Float local3) * 8.0), 0.0, ((Float local4) * 8.0), local16, ((Float currmapgrid\Field1[((local4 * $15) + local3)]) * 90.0))
                        currmapgrid\Field3[((local4 * $15) + local3)] = local0\Field7\Field5
                        currmapgrid\Field4[$00] = (currmapgrid\Field4[$00] + $01)
                    Case $02
                        If (((currmapgrid\Field0[((local3 - $01) + (local4 * $15))] > $00) And (currmapgrid\Field0[((local3 + $01) + (local4 * $15))] > $00)) <> 0) Then
                            If (currmapgrid\Field4[$01] < local26) Then
                                If (maproom($01, currmapgrid\Field4[$01]) <> "") Then
                                    local16 = findroomid(maproom($01, currmapgrid\Field4[$01]))
                                EndIf
                            EndIf
                            If (rand($02, $01) = $01) Then
                                currmapgrid\Field1[((local4 * $15) + local3)] = $01
                            Else
                                currmapgrid\Field1[((local4 * $15) + local3)] = $03
                            EndIf
                            local0 = createroom(local15, $01, ((Float local3) * 8.0), 0.0, ((Float local4) * 8.0), local16, ((Float currmapgrid\Field1[((local4 * $15) + local3)]) * 90.0))
                            currmapgrid\Field3[((local4 * $15) + local3)] = local0\Field7\Field5
                            currmapgrid\Field4[$01] = (currmapgrid\Field4[$01] + $01)
                        ElseIf (((currmapgrid\Field0[(((local4 - $01) * $15) + local3)] > $00) And (currmapgrid\Field0[(((local4 + $01) * $15) + local3)] > $00)) <> 0) Then
                            If (currmapgrid\Field4[$01] < local26) Then
                                If (maproom($01, currmapgrid\Field4[$01]) <> "") Then
                                    local16 = findroomid(maproom($01, currmapgrid\Field4[$01]))
                                EndIf
                            EndIf
                            If (rand($02, $01) = $01) Then
                                currmapgrid\Field1[((local4 * $15) + local3)] = $02
                            Else
                                currmapgrid\Field1[((local4 * $15) + local3)] = $00
                            EndIf
                            local0 = createroom(local15, $01, ((Float local3) * 8.0), 0.0, ((Float local4) * 8.0), local16, ((Float currmapgrid\Field1[((local4 * $15) + local3)]) * 90.0))
                            currmapgrid\Field3[((local4 * $15) + local3)] = local0\Field7\Field5
                            currmapgrid\Field4[$01] = (currmapgrid\Field4[$01] + $01)
                        Else
                            If (currmapgrid\Field4[$02] < local26) Then
                                If (maproom($02, currmapgrid\Field4[$02]) <> "") Then
                                    local16 = findroomid(maproom($02, currmapgrid\Field4[$02]))
                                EndIf
                            EndIf
                            If (((currmapgrid\Field0[((local3 - $01) + (local4 * $15))] > $00) And (currmapgrid\Field0[(((local4 + $01) * $15) + local3)] > $00)) <> 0) Then
                                currmapgrid\Field1[((local4 * $15) + local3)] = $02
                            ElseIf (((currmapgrid\Field0[((local3 + $01) + (local4 * $15))] > $00) And (currmapgrid\Field0[(((local4 + $01) * $15) + local3)] > $00)) <> 0) Then
                                currmapgrid\Field1[((local4 * $15) + local3)] = $01
                            ElseIf (((currmapgrid\Field0[((local3 - $01) + (local4 * $15))] > $00) And (currmapgrid\Field0[(((local4 - $01) * $15) + local3)] > $00)) <> 0) Then
                                currmapgrid\Field1[((local4 * $15) + local3)] = $03
                            Else
                                currmapgrid\Field1[((local4 * $15) + local3)] = $00
                            EndIf
                            local0 = createroom(local15, $02, ((Float local3) * 8.0), 0.0, ((Float local4) * 8.0), local16, ((Float currmapgrid\Field1[((local4 * $15) + local3)]) * 90.0))
                            currmapgrid\Field3[((local4 * $15) + local3)] = local0\Field7\Field5
                            currmapgrid\Field4[$02] = (currmapgrid\Field4[$02] + $01)
                        EndIf
                    Case $03
                        If (currmapgrid\Field4[$03] < local26) Then
                            If (maproom($03, currmapgrid\Field4[$03]) <> "") Then
                                local16 = findroomid(maproom($03, currmapgrid\Field4[$03]))
                            EndIf
                        EndIf
                        If (currmapgrid\Field0[(((local4 - $01) * $15) + local3)] = $00) Then
                            currmapgrid\Field1[((local4 * $15) + local3)] = $02
                        ElseIf (currmapgrid\Field0[((local3 - $01) + (local4 * $15))] = $00) Then
                            currmapgrid\Field1[((local4 * $15) + local3)] = $01
                        ElseIf (currmapgrid\Field0[((local3 + $01) + (local4 * $15))] = $00) Then
                            currmapgrid\Field1[((local4 * $15) + local3)] = $03
                        Else
                            currmapgrid\Field1[((local4 * $15) + local3)] = $00
                        EndIf
                        local0 = createroom(local15, $03, ((Float local3) * 8.0), 0.0, ((Float local4) * 8.0), local16, ((Float currmapgrid\Field1[((local4 * $15) + local3)]) * 90.0))
                        currmapgrid\Field3[((local4 * $15) + local3)] = local0\Field7\Field5
                        currmapgrid\Field4[$03] = (currmapgrid\Field4[$03] + $01)
                    Case $04
                        If (currmapgrid\Field4[$04] < local26) Then
                            If (maproom($04, currmapgrid\Field4[$04]) <> "") Then
                                local16 = findroomid(maproom($04, currmapgrid\Field4[$04]))
                            EndIf
                        EndIf
                        currmapgrid\Field1[((local4 * $15) + local3)] = rand($04, $01)
                        local0 = createroom(local15, $04, ((Float local3) * 8.0), 0.0, ((Float local4) * 8.0), local16, ((Float currmapgrid\Field1[((local4 * $15) + local3)]) * 90.0))
                        currmapgrid\Field3[((local4 * $15) + local3)] = local0\Field7\Field5
                        currmapgrid\Field4[$04] = (currmapgrid\Field4[$04] + $01)
                End Select
                calculateroomextents(local0)
            EndIf
        Next
        local4 = (local4 + $FFFFFFFF)
    Wend
    local0 = createroom($00, $00, 160.0, 500.0, 128.0, $49, 0.0)
    calculateroomextents(local0)
    local0 = createroom($00, $00, 160.0, 500.0, 64.0, $47, 0.0)
    calculateroomextents(local0)
    local0 = createroom($00, $00, 160.0, 0.0, 160.0, $69, 0.0)
    calculateroomextents(local0)
    If (opt\Field53 <> 0) Then
        local0 = createroom($00, $00, 8.0, 250.0, 160.0, $04, 0.0)
        calculateroomextents(local0)
    EndIf
    local0 = createroom($00, $00, 8.0, 800.0, 0.0, $6A, 0.0)
    calculateroomextents(local0)
    For local0 = Each rooms
        preventroomoverlap(local0)
    Next
    If (opt\Field54 <> 0) Then
        Repeat
            showpointer()
            cls()
            mouseposx = (Float mousex())
            mouseposy = (Float mousey())
            local7 = $14
            For local3 = $00 To $14 Step $01
                For local4 = $00 To $14 Step $01
                    If (currmapgrid\Field0[((local4 * $15) + local3)] = $00) Then
                        local15 = getzone(local4)
                        local28 = (($32 * local15) + $32)
                        color(local28, local28, local28)
                        rect((Int ((Float (local7 Shl $05)) * menuscale)), (Int ((Float (local4 Shl $05)) * menuscale)), (Int (30.0 * menuscale)), (Int (30.0 * menuscale)), $01)
                    Else
                        Select currmapgrid\Field0[((local4 * $15) + local3)]
                            Case $FF
                                color($00, $C8, $00)
                            Case $04
                                color($32, $32, $FF)
                            Case $03
                                color($32, $FF, $FF)
                            Case $02
                                color($FF, $FF, $32)
                            Case $01
                                color($FF, $FF, $FF)
                        End Select
                        rect((Int ((Float (local7 Shl $05)) * menuscale)), (Int ((Float (local4 Shl $05)) * menuscale)), (Int (30.0 * menuscale)), (Int (30.0 * menuscale)), $01)
                        If (mouseon((Int ((Float (local7 Shl $05)) * menuscale)), (Int ((Float (local4 Shl $05)) * menuscale)), (Int (32.0 * menuscale)), (Int (32.0 * menuscale))) <> 0) Then
                            color($FF, $00, $00)
                            textex((Int ((Float ((local7 Shl $05) + $02)) * menuscale)), (Int ((Float ((local4 Shl $05) + $02)) * menuscale)), (((Str currmapgrid\Field0[((local4 * $15) + local3)]) + " ") + currmapgrid\Field3[((local4 * $15) + local3)]), $00, $00)
                        EndIf
                    EndIf
                Next
                local7 = (local7 - $01)
            Next
            color($FF, $FF, $FF)
            textex((Int (6.0 * menuscale)), (Int (12.0 * menuscale)), (Str currmapgrid\Field4[$00]), $00, $00)
            color($FF, $FF, $32)
            textex((Int (6.0 * menuscale)), (Int (44.0 * menuscale)), (Str currmapgrid\Field4[$01]), $00, $00)
            color($FF, $32, $32)
            textex((Int (6.0 * menuscale)), (Int (76.0 * menuscale)), (Str currmapgrid\Field4[$02]), $00, $00)
            color($32, $FF, $FF)
            textex((Int (6.0 * menuscale)), (Int (108.0 * menuscale)), (Str currmapgrid\Field4[$03]), $00, $00)
            color($32, $32, $FF)
            textex((Int (6.0 * menuscale)), (Int (140.0 * menuscale)), (Str currmapgrid\Field4[$04]), $00, $00)
            color($FF, $FF, $FF)
            textex(mo\Field9, (Int ((Float opt\Field50) - (15.0 * menuscale))), format(getlocalstring("menu", "new.seed2"), randomseed, "%s"), $01, $01)
            renderloadingtext(mo\Field9, (Int ((Float opt\Field50) - (35.0 * menuscale))), getlocalstring("menu", "anykey"), $01, $01)
            flip($01)
            rendercursor()
        Until (((getkey() <> $00) Lor mousehit($01)) <> 0)
    EndIf
    For local4 = $00 To $15 Step $01
        For local3 = $00 To $15 Step $01
            currmapgrid\Field0[((local4 * $15) + local3)] = (Int min((Float currmapgrid\Field0[((local4 * $15) + local3)]), 1.0))
        Next
    Next
    local4 = $15
    While (local4 >= $00)
        If (local4 < (i_zone\Field0[$01] - $01)) Then
            local15 = $03
        ElseIf (((local4 >= (i_zone\Field0[$01] - $01)) And (local4 < (i_zone\Field0[$00] - $01))) <> 0) Then
            local15 = $02
        Else
            local15 = $01
        EndIf
        local3 = $15
        While (local3 >= $00)
            If (currmapgrid\Field0[((local4 * $15) + local3)] > $00) Then
                For local0 = Each rooms
                    local0\Field6 = (Int wrapangle((Float local0\Field6), 360.0))
                    If ((((Int (local0\Field3 / 8.0)) = local3) And ((Int (local0\Field5 / 8.0)) = local4)) <> 0) Then
                        Select local0\Field7\Field4
                            Case $00
                                local14 = (90.0 = (Float local0\Field6))
                            Case $01
                                local14 = ((90.0 = (Float local0\Field6)) Lor (270.0 = (Float local0\Field6)))
                            Case $02
                                local14 = ((0.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6)))
                            Case $03
                                local14 = (((0.0 = (Float local0\Field6)) Lor (180.0 = (Float local0\Field6))) Lor (90.0 = (Float local0\Field6)))
                            Default
                                local14 = $01
                        End Select
                        If (local14 <> 0) Then
                            If ((local3 + $01) < $16) Then
                                If (currmapgrid\Field0[((local3 + $01) + (local4 * $15))] > $00) Then
                                    local0\Field20[$00] = createdoor(local0, (((Float local3) * 8.0) + 4.0), 0.0, ((Float local4) * 8.0), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), (((local15 - $01) Mod $02) Shl $01), $00, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        Select local0\Field7\Field4
                            Case $00
                                local14 = (180.0 = (Float local0\Field6))
                            Case $01
                                local14 = ((0.0 = (Float local0\Field6)) Lor (180.0 = (Float local0\Field6)))
                            Case $02
                                local14 = ((180.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6)))
                            Case $03
                                local14 = (((180.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6))) Lor (270.0 = (Float local0\Field6)))
                            Default
                                local14 = $01
                        End Select
                        If (local14 <> 0) Then
                            If ((local4 + $01) < $16) Then
                                If (currmapgrid\Field0[(((local4 + $01) * $15) + local3)] > $00) Then
                                    local0\Field20[$03] = createdoor(local0, ((Float local3) * 8.0), 0.0, (((Float local4) * 8.0) + 4.0), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), (((local15 - $01) Mod $02) Shl $01), $00, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local3 = (local3 + $FFFFFFFF)
        Wend
        local4 = (local4 + $FFFFFFFF)
    Wend
    For local0 = Each rooms
        local0\Field6 = (Int wrapangle((Float local0\Field6), 360.0))
        For local7 = $00 To $03 Step $01
            local0\Field19[local7] = Null
        Next
        For local1 = Each rooms
            If (local0 <> local1) Then
                If (local0\Field5 = local1\Field5) Then
                    If ((local0\Field3 + 8.0) = local1\Field3) Then
                        local0\Field19[$00] = local1
                        If (local0\Field20[$00] = Null) Then
                            local0\Field20[$00] = local1\Field20[$02]
                        EndIf
                    ElseIf ((local0\Field3 - 8.0) = local1\Field3) Then
                        local0\Field19[$02] = local1
                        If (local0\Field20[$02] = Null) Then
                            local0\Field20[$02] = local1\Field20[$00]
                        EndIf
                    EndIf
                ElseIf (local0\Field3 = local1\Field3) Then
                    If ((local0\Field5 - 8.0) = local1\Field5) Then
                        local0\Field19[$01] = local1
                        If (local0\Field20[$01] = Null) Then
                            local0\Field20[$01] = local1\Field20[$03]
                        EndIf
                    ElseIf ((local0\Field5 + 8.0) = local1\Field5) Then
                        local0\Field19[$03] = local1
                        If (local0\Field20[$03] = Null) Then
                            local0\Field20[$03] = local1\Field20[$01]
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (((((local0\Field19[$00] <> Null) And (local0\Field19[$01] <> Null)) And (local0\Field19[$02] <> Null)) And (local0\Field19[$03] <> Null)) <> 0) Then
                Exit
            EndIf
        Next
    Next
    Return $00
End Function
