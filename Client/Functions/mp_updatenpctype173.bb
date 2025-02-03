Function mp_updatenpctype173%(arg0.npcs)
    Local local0#
    Local local1%
    Local local2%
    Local local3#
    Local local4.mp_player
    Local local5#
    Local local7.doors
    Local local8%
    Local local9%
    Local local11%
    Local local12#
    If (((3.0 <> arg0\Field26) And (isplayeroutsidefacility() = $00)) <> 0) Then
        local0 = entitydistancesquared(arg0\Field3, me\Field60)
        arg0\Field12 = 1.0
        positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.32), entityz(arg0\Field3, $00), $00)
        rotateentity(arg0\Field0, 0.0, (entityyaw(arg0\Field3, $00) - 180.0), 0.0, $00)
        positionentity(arg0\Field1, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.32), entityz(arg0\Field3, $00), $00)
        rotateentity(arg0\Field1, 0.0, ((entityyaw(arg0\Field3, $00) - 180.0) + arg0\Field15), 0.0, $00)
        If (2.0 > arg0\Field26) Then
            If (0.1 < arg0\Field27) Then
                arg0\Field26 = 1.0
                arg0\Field27 = max((arg0\Field27 - fps\Field7[$00]), 0.1)
            ElseIf (0.1 = arg0\Field27) Then
                arg0\Field26 = 0.0
                arg0\Field27 = 0.0
            EndIf
            If (0.0 = arg0\Field26) Then
                local1 = $00
                local2 = $01
                If (225.0 > local0) Then
                    If (100.0 > local0) Then
                        If (entityvisible(arg0\Field3, me\Field60) <> 0) Then
                            local1 = $01
                            arg0\Field36 = entityx(me\Field60, $01)
                            arg0\Field37 = entityy(me\Field60, $01)
                            arg0\Field38 = entityz(me\Field60, $01)
                        EndIf
                    EndIf
                    local3 = clamp((distance(entityx(arg0\Field3, $00), arg0\Field31, entityz(arg0\Field3, $00), arg0\Field33, 0.0, 0.0) * 2.5), 0.0, 1.0)
                    arg0\Field18 = loopsoundex(snd_i\Field12, arg0\Field18, camera, arg0\Field3, 10.0, arg0\Field10, $00)
                    arg0\Field31 = entityx(arg0\Field3, $00)
                    arg0\Field33 = entityz(arg0\Field3, $00)
                    If (chs\Field2 = $00) Then
                        For local4 = Each mp_player
                            If (entityhidden(local4\Field18) = $00) Then
                                If (((2500.0 > entitydistancesquared(local4\Field18, arg0\Field3)) And (local4\Field29 = $00)) <> 0) Then
                                    If ((entityinview(arg0\Field0, local4\Field19) Lor entityinview(arg0\Field1, local4\Field19)) <> 0) Then
                                        local2 = $00
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    EndIf
                EndIf
                If (chs\Field2 <> 0) Then
                    local2 = $01
                EndIf
                If (local2 = $00) Then
                    local5 = sqr(local0)
                    If (arg0\Field85 <> 0) Then
                        me\Field48 = max(clamp(((4.0 - local5) / 6.0), 0.1, 0.9), me\Field48)
                        me\Field52 = max(me\Field52, (((sin(((Float millisec) / 20.0)) + 1.0) * 15.0) * max(((3.5 - local5) / 3.5), 0.0)))
                    EndIf
                    If ((((12.25 > local0) And ((millisecs() - arg0\Field29) > $EA60)) And local1) <> 0) Then
                        If (arg0\Field85 <> 0) Then
                            playsound_strict(snd_i\Field47[rand($03, $04)], $00, $01)
                        EndIf
                        arg0\Field29 = millisecs()
                    EndIf
                    If (2.25 > local0) Then
                        If (arg0\Field85 <> 0) Then
                            If (rand($2BC, $01) = $01) Then
                                playsoundex(snd_i\Field46[rand($00, $02)], camera, arg0\Field0, 10.0, 1.0, $00, $00)
                            EndIf
                            If (((2.0 < arg0\Field30) And local1) <> 0) Then
                                me\Field52 = 40.0
                                me\Field28 = max(me\Field28, 140.0)
                                me\Field30 = 0.5
                                Select rand($05, $01)
                                    Case $01
                                        playsound_strict(snd_i\Field47[$01], $00, $01)
                                    Case $02
                                        playsound_strict(snd_i\Field47[$02], $00, $01)
                                    Case $03
                                        playsound_strict(snd_i\Field47[$09], $00, $01)
                                    Case $04
                                        playsound_strict(snd_i\Field47[$0A], $00, $01)
                                    Case $05
                                        playsound_strict(snd_i\Field47[$0C], $00, $01)
                                End Select
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field30 = sqr(local0)
                    arg0\Field10 = max(0.0, (arg0\Field10 - (fps\Field7[$00] / 20.0)))
                ElseIf (local0 > ((hidedistance * 0.8) * (hidedistance * 0.8))) Then
                    If (rand($46, $01) = $01) Then
                        teleportcloser(arg0)
                    EndIf
                Else
                    arg0\Field10 = curvevalue(local3, arg0\Field10, 3.0)
                    If (rand(($14 - (selecteddifficulty\Field2 * $0A)), $01) = $01) Then
                        For local7 = Each doors
                            If (((((((local7\Field4 = $00) And (local7\Field6 = $00)) And (local7\Field19 = $00)) And (local7\Field14 = $00)) And (local7\Field10 <> $05)) And (local7\Field10 <> $04)) <> 0) Then
                                For local9 = $00 To $01 Step $01
                                    If (local7\Field3[local9] <> $00) Then
                                        If (0.5 > (Abs (entityx(arg0\Field3, $00) - entityx(local7\Field3[local9], $00)))) Then
                                            If (0.5 > (Abs (entityz(arg0\Field3, $00) - entityz(local7\Field3[local9], $00)))) Then
                                                If (((180.0 <= local7\Field8) Lor (0.0 >= local7\Field8)) <> 0) Then
                                                    local8 = createpivot($00)
                                                    positionentity(local8, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.5), entityz(arg0\Field3, $00), $00)
                                                    pointentity(local8, local7\Field3[local9], 0.0)
                                                    moveentity(local8, 0.0, 0.0, (arg0\Field23 * 0.6))
                                                    If (entitypick(local8, 0.5) = local7\Field3[local9]) Then
                                                        playsound_strict(loadtempsound("SFX\Door\DoorOpen173.ogg"), $00, $01)
                                                        openclosedoor(local7, $01, $00)
                                                        freeentity(local8)
                                                        local8 = $00
                                                        Exit
                                                    EndIf
                                                    freeentity(local8)
                                                    local8 = $00
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        Next
                    EndIf
                    If (chs\Field2 <> 0) Then
                        local1 = $00
                        arg0\Field36 = 0.0
                        arg0\Field37 = 0.0
                        arg0\Field38 = 0.0
                    EndIf
                    If (local1 <> 0) Then
                        If (i_268\Field2 = $00) Then
                            arg0\Field15 = deltayaw(arg0\Field3, arg0\Field96\Field19)
                        EndIf
                        If (0.4225 > local0) Then
                            Select playerroom\Field7\Field6
                                Case $1C,$0D,$2C
                                    msg\Field2 = format(getlocalstring("death", "173.gw"), subjectname, "%s")
                                Case $04
                                    msg\Field2 = format(getlocalstring("death", "173.intro"), subjectname, "%s")
                                Case $0C
                                    msg\Field2 = getlocalstring("death", "173.6")
                                Default
                                    msg\Field2 = format(getlocalstring("death", "173.default"), subjectname, "%s")
                            End Select
                            If (arg0\Field85 <> 0) Then
                                If (chs\Field0 = $00) Then
                                    playsoundex(snd_i\Field53[rand($00, $02)], camera, arg0\Field0, 8.0, 1.0, $00, $00)
                                    If (rand($02, $01) = $01) Then
                                        turnentity(camera, 0.0, rnd(80.0, 100.0), 0.0, $00)
                                    Else
                                        turnentity(camera, 0.0, rnd(-100.0, -80.0), 0.0, $00)
                                    EndIf
                                EndIf
                            Else
                                playsoundex(snd_i\Field53[rand($00, $02)], camera, arg0\Field0, 8.0, 1.0, $00, $00)
                            EndIf
                            kill($00, $01, $00, $01)
                            arg0\Field27 = 35.0
                        ElseIf (i_268\Field2 = $00) Then
                            pointentity(arg0\Field3, me\Field60, 0.0)
                            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), entityroll(arg0\Field3, $00), $00)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $00) + 90.0)) * arg0\Field23) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $00) + 90.0)) * arg0\Field23) * fps\Field7[$00]), $00)
                        EndIf
                    ElseIf (0.0 <> arg0\Field36) Then
                        arg0\Field15 = deltayaw(arg0\Field3, arg0\Field96\Field19)
                        If (((0.25 < distancesquared(entityx(arg0\Field3, $00), arg0\Field36, entityz(arg0\Field3, $00), arg0\Field38, 0.0, 0.0)) And (i_268\Field2 = $00)) <> 0) Then
                            aligntovector(arg0\Field3, (arg0\Field36 - entityx(arg0\Field3, $00)), 0.0, (arg0\Field38 - entityz(arg0\Field3, $00)), $03, 1.0)
                            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field23 * fps\Field7[$00]))
                            If (rand($1F4, $01) = $01) Then
                                arg0\Field36 = 0.0
                                arg0\Field37 = 0.0
                                arg0\Field38 = 0.0
                            EndIf
                        Else
                            arg0\Field36 = 0.0
                            arg0\Field37 = 0.0
                            arg0\Field38 = 0.0
                        EndIf
                    Else
                        If (rand($190, $01) = $01) Then
                            rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 10.0, $00)
                        EndIf
                        translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $00) + 90.0)) * arg0\Field23) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $00) + 90.0)) * arg0\Field23) * fps\Field7[$00]), $00)
                        If (chs\Field2 <> 0) Then
                            arg0\Field15 = 0.0
                        Else
                            arg0\Field15 = rnd(-120.0, 120.0)
                        EndIf
                    EndIf
                EndIf
            EndIf
            positionentity(arg0\Field3, entityx(arg0\Field3, $00), min(entityy(arg0\Field3, $00), 0.35), entityz(arg0\Field3, $00), $00)
        Else
            If (n_i\Field8 <> Null) Then
                local11 = $00
                local0 = entitydistancesquared(arg0\Field3, n_i\Field8\Field3)
                If (local0 > ((hidedistance / 2.0) * (hidedistance / 2.0))) Then
                    If (entityinview(arg0\Field0, mp_getnpctargetcamera(arg0)) = $00) Then
                        local11 = $01
                    EndIf
                EndIf
                If (local11 = $00) Then
                    pointentity(arg0\Field0, n_i\Field8\Field3, 0.0)
                    rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 10.0), 0.0, $01)
                    moveentity(arg0\Field3, 0.0, 0.0, (clamp((((sqr(local0) * 2.0) - 1.0) * 0.5), -0.5, 1.0) * (fps\Field7[$00] * 0.016)))
                    arg0\Field48 = 1.0
                Else
                    positionentity(arg0\Field3, entityx(n_i\Field8\Field3, $00), (entityy(n_i\Field8\Field3, $00) + 0.3), entityz(n_i\Field8\Field3, $00), $00)
                    resetentity(arg0\Field3)
                    arg0\Field7 = 0.0
                    arg0\Field48 = 0.0
                EndIf
            EndIf
            local12 = ((sin(((Float millisec) * 0.08)) * 0.02) + 0.05)
            positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + local12), entityz(arg0\Field3, $00), $00)
            rotateentity(arg0\Field0, 0.0, (entityyaw(arg0\Field3, $00) - 180.0), 0.0, $00)
            positionentity(arg0\Field1, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + local12), entityz(arg0\Field3, $00), $00)
            rotateentity(arg0\Field1, 0.0, ((entityyaw(arg0\Field3, $00) - 180.0) + arg0\Field15), 0.0, $00)
            If (entityhidden(arg0\Field2) <> 0) Then
                showentity(arg0\Field2)
            EndIf
            positionentity(arg0\Field2, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - local12), entityz(arg0\Field3, $00), $00)
            rotateentity(arg0\Field2, 0.0, (entityyaw(arg0\Field3, $00) - 180.0), 0.0, $00)
        EndIf
    EndIf
    Return $00
End Function
