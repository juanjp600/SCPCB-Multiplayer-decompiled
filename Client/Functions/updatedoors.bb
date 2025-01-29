Function updatedoors%()
    Local local0.doors
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7#
    Local local8%
    Local local9%
    Local local10%
    Local local11#
    Local local12#
    Local local14#
    Local local15#
    Local local16#
    Local local19%
    buttondirection = ((me\Field66 = $00) Lor (me\Field66 And ((infacility = $FFFFFFFF) Lor ((infacility <> $01) And (toelevatorfloor = $01)))))
    d_i\Field11 = $00
    d_i\Field9 = $00
    d_i\Field7 = Null
    local8 = $00
    If (mp_ishoster() <> 0) Then
        For local0 = Each doors
            local0\Field37 = (local0\Field37 - fps\Field7[$00])
            If (0.0 >= local0\Field37) Then
                local0\Field36 = mp_anyplayernearentity(local0\Field2, 200.0)
                local0\Field37 = 35.0
            EndIf
        Next
    EndIf
    For local0 = Each doors
        local8 = (((hidedistance * 1.75) * (hidedistance * 1.75)) >= entitydistancesquared(local0\Field2, me\Field60))
        If (((local8 Lor (local0\Field22 > $00)) Lor local0\Field36) <> 0) Then
            local9 = ((local0\Field10 = $04) Lor (local0\Field10 = $05))
            local10 = ($01 - (local0\Field6 And local9))
            local11 = (fps\Field7[$00] * 2.0)
            local12 = ((Float (local0\Field9 + $01)) - ((Float local0\Field27) * 0.375))
            If (local0\Field6 <> 0) Then
                If (180.0 > local0\Field8) Then
                    Select local0\Field10
                        Case $00
                            local0\Field8 = min(180.0, (local0\Field8 + (local11 * local12)))
                            local7 = (((sin(local0\Field8) * local12) * fps\Field7[$00]) / 80.0)
                            moveentity(local0\Field0, local7, 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, local7, 0.0, 0.0)
                            EndIf
                        Case $01
                            local0\Field8 = min(180.0, (local0\Field8 + (local11 * local12)))
                            local7 = (((sin(local0\Field8) * local12) * fps\Field7[$00]) / 162.0)
                            moveentity(local0\Field0, local7, 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, local7, 0.0, 0.0)
                            EndIf
                        Case $02
                            local0\Field8 = min(180.0, (local0\Field8 + (local11 * local12)))
                            local6 = sin(local0\Field8)
                            moveentity(local0\Field0, (((local6 * local12) * fps\Field7[$00]) / 85.0), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, ((((Float (local0\Field9 + $01)) * local6) * fps\Field7[$00]) / 120.0), 0.0, 0.0)
                            EndIf
                        Case $03
                            local0\Field8 = min(180.0, (local0\Field8 + (fps\Field7[$00] * 0.8)))
                            local6 = sin(local0\Field8)
                            local7 = (fps\Field7[$00] / 180.0)
                            moveentity(local0\Field0, (local6 * local7), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, ((- local6) * local7), 0.0, 0.0)
                            EndIf
                        Case $04,$05
                            If (local0\Field15 <> Null) Then
                                local0\Field8 = (curvevalue(180.0, local0\Field8, 40.0) + (fps\Field7[$00] * 0.01))
                                rotateentity(local0\Field0, 0.0, ((Float (local0\Field15\Field6 + local0\Field7)) + (local0\Field8 / 2.5)), 0.0, $00)
                            EndIf
                        Case $06
                            local0\Field8 = min(180.0, (local0\Field8 + (local11 * local12)))
                            local6 = sin(local0\Field8)
                            local7 = (fps\Field7[$00] / 80.0)
                            moveentity(local0\Field0, ((local6 * local12) * local7), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (((Float (local0\Field9 + $01)) * local6) * (- local7)), 0.0, 0.0)
                            EndIf
                        Case $07
                            local0\Field8 = min(180.0, (local0\Field8 + (fps\Field7[$00] * 1.4)))
                            local6 = sin(local0\Field8)
                            local7 = (fps\Field7[$00] / 114.0)
                            moveentity(local0\Field0, (local6 * local7), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (local6 * (- local7)), 0.0, 0.0)
                            EndIf
                    End Select
                Else
                    local0\Field9 = $00
                    resetentity(local0\Field0)
                    If (local0\Field1 <> $00) Then
                        resetentity(local0\Field1)
                    EndIf
                    If (0.0 < local0\Field13) Then
                        local0\Field13 = max(0.0, (local0\Field13 - fps\Field7[$00]))
                        If ((local0\Field25 And ((110.0 < (local0\Field13 + fps\Field7[$00])) And (110.0 >= local0\Field13))) <> 0) Then
                            local0\Field17 = playsoundex(snd_i\Field10, camera, local0\Field0, 10.0, 1.0, $00, $00)
                        EndIf
                        If (0.0 = local0\Field13) Then
                            local0\Field17 = $00
                            openclosedoor(local0, $01, $00)
                        EndIf
                    EndIf
                EndIf
            Else
                local14 = entityx(local0\Field2, $01)
                local15 = entityy(local0\Field2, $01)
                local16 = entityz(local0\Field2, $01)
                If (0.0 < local0\Field8) Then
                    Select local0\Field10
                        Case $00
                            local0\Field8 = max(0.0, (local0\Field8 - (local11 * local12)))
                            local7 = (((sin(local0\Field8) * local12) * (- fps\Field7[$00])) / 80.0)
                            moveentity(local0\Field0, local7, 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, local7, 0.0, 0.0)
                            EndIf
                        Case $01
                            local0\Field8 = max(0.0, (local0\Field8 - (local11 * local12)))
                            local7 = (((sin(local0\Field8) * local12) * (- fps\Field7[$00])) / 162.0)
                            moveentity(local0\Field0, local7, 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, local7, 0.0, 0.0)
                            EndIf
                        Case $02
                            local0\Field8 = max(0.0, (local0\Field8 - (local11 * local12)))
                            local6 = sin(local0\Field8)
                            moveentity(local0\Field0, (((local6 * local12) * (- fps\Field7[$00])) / 85.0), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, ((((Float (local0\Field9 + $01)) * local6) * (- fps\Field7[$00])) / 120.0), 0.0, 0.0)
                            EndIf
                        Case $03
                            local0\Field8 = max(0.0, (local0\Field8 - (fps\Field7[$00] * 0.8)))
                            local6 = sin(local0\Field8)
                            local7 = (fps\Field7[$00] / 180.0)
                            moveentity(local0\Field0, (local6 * (- local7)), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (local6 * local7), 0.0, 0.0)
                            EndIf
                            If (((15.0 > local0\Field8) And (15.0 <= (local0\Field8 + fps\Field7[$00]))) <> 0) Then
                                setemitter(Null, local14, local15, local16, $0B)
                            EndIf
                        Case $04,$05
                            local0\Field8 = 0.0
                            rotateentity(local0\Field0, 0.0, entityyaw(local0\Field2, $00), 0.0, $00)
                        Case $06
                            local0\Field8 = max(0.0, (local0\Field8 - (local11 * local12)))
                            local6 = sin(local0\Field8)
                            local7 = (fps\Field7[$00] / 80.0)
                            moveentity(local0\Field0, ((local6 * local12) * (- local7)), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (((Float (local0\Field9 + $01)) * local6) * local7), 0.0, 0.0)
                            EndIf
                        Case $07
                            local0\Field8 = min(180.0, (local0\Field8 - (fps\Field7[$00] * 1.4)))
                            local6 = sin(local0\Field8)
                            local7 = (fps\Field7[$00] / 114.0)
                            moveentity(local0\Field0, (local6 * (- local7)), 0.0, 0.0)
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, (local6 * local7), 0.0, 0.0)
                            EndIf
                    End Select
                Else
                    local0\Field9 = $00
                    positionentity(local0\Field0, local14, local15, local16, $00)
                    If (local0\Field1 <> $00) Then
                        positionentity(local0\Field1, local14, local15, local16, $00)
                    EndIf
                    Select local0\Field10
                        Case $00,$06,$07
                            moveentity(local0\Field0, 0.0, 0.0, (1.0 / 32.0))
                            If (local0\Field1 <> $00) Then
                                moveentity(local0\Field1, 0.0, 0.0, (1.0 / 32.0))
                            EndIf
                        Case $04
                            moveentity(local0\Field0, 0.359375, 0.0, 0.0)
                        Case $05
                            moveentity(local0\Field0, 0.265625, 0.0, 0.0)
                    End Select
                EndIf
            EndIf
            If (local8 <> 0) Then
                updatesoundorigin(local0\Field17, camera, local0\Field2, 10.0, 1.0, $00, $01)
                If (((((180.0 <= local0\Field8) Lor (0.0 >= local0\Field8)) And local10) And (grabbedentity = $00)) <> 0) Then
                    For local4 = $00 To $01 Step $01
                        If (local0\Field3[local4] <> $00) Then
                            If (((1.0 > (Abs (entityx(me\Field60, $00) - entityx(local0\Field3[local4], $01)))) And (1.0 > (Abs (entityz(me\Field60, $00) - entityz(local0\Field3[local4], $01))))) <> 0) Then
                                If (updatebutton(local0\Field3[local4]) <> 0) Then
                                    d_i\Field7 = local0
                                    d_i\Field11 = (local4 + $01)
                                    Exit
                                EndIf
                            EndIf
                        EndIf
                    Next
                EndIf
                If (local0\Field10 = $03) Then
                    If (local0\Field4 = $02) Then
                        If (48.0 < local0\Field8) Then
                            local0\Field6 = $00
                            local0\Field8 = min(local0\Field8, 48.0)
                        EndIf
                    EndIf
                    If (0.1225 > entitydistancesquared(me\Field60, local0\Field2)) Then
                        If ((((6.0 < local0\Field8) And (48.0 > local0\Field8)) And (local0\Field6 = $00)) <> 0) Then
                            If (((0.0 = me\Field0) And (chs\Field0 = $00)) <> 0) Then
                                playsound_strict(snd_i\Field29, $00)
                                msg\Field2 = format(getlocalstring("death", "door"), subjectname, "%s")
                                kill($01, $01, $00, $01)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (local9 = $00) Then
                    If (0.0 >= local0\Field26) Then
                        If ((local0\Field20 And (local0\Field4 > $00)) <> 0) Then
                            local0\Field20 = $00
                        EndIf
                        If (local0\Field14 = $09) Then
                            local19 = $03
                        ElseIf (((0.0 < local0\Field8) And (180.0 > local0\Field8)) <> 0) Then
                            local19 = $01
                        ElseIf (((local0\Field4 = $01) Lor local0\Field31) <> 0) Then
                            local19 = $02
                        Else
                            local19 = $00
                        EndIf
                        For local4 = $00 To $01 Step $01
                            If (local0\Field3[local4] <> $00) Then
                                entitytexture(local0\Field3[local4], d_i\Field3[local19], $00, $00)
                            EndIf
                        Next
                        local0\Field26 = (fps\Field7[$00] * 4.0)
                    Else
                        local0\Field26 = (local0\Field26 - fps\Field7[$00])
                    EndIf
                EndIf
                If (local0\Field34 <> $00) Then
                    local5 = local0\Field3[(local0\Field34 - $01)]
                    If (local0\Field35 <> 0) Then
                        If (0.99 < animtime(local5)) Then
                            animateex(local5, animtime(local5), $01, $14, 2.0, $00)
                            If (19.9 <= animtime(local5)) Then
                                local0\Field34 = $00
                            EndIf
                        Else
                            local0\Field34 = $00
                        EndIf
                    ElseIf (20.99 < animtime(local5)) Then
                        animateex(local5, animtime(local5), $15, $28, 2.0, $00)
                        If (39.9 <= animtime(local5)) Then
                            local0\Field34 = $00
                        EndIf
                    Else
                        local0\Field34 = $00
                    EndIf
                ElseIf (local0\Field33 <> 0) Then
                    If (0.99 < animtime(local0\Field0)) Then
                        animateex(local0\Field0, animtime(local0\Field0), $01, $29, 1.2, $00)
                        If (40.9 <= animtime(local0\Field0)) Then
                            local0\Field33 = $00
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        mp_updatedoor(local0)
    Next
    If (d_i\Field7 <> Null) Then
        If ((d_i\Field7\Field20 And remotedooron) <> 0) Then
            If ((d_i\Field7\Field6 And (180.0 = d_i\Field7\Field8)) <> 0) Then
                If ((((i_714\Field0 = $00) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
                    playsound_strict(snd_i\Field47[$07], $00)
                EndIf
                openclosedoor(d_i\Field7, $01, $00)
                d_i\Field7\Field20 = $00
            EndIf
        EndIf
    EndIf
    Return $00
End Function
