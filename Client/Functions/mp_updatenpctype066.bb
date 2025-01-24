Function mp_updatenpctype066%(arg0.npcs)
    Local local0#
    Local local1#
    Local local3.waypoints
    Local local5.doors
    Local local6.decals
    If (1.0 = arg0\Field26) Then
        If (channelplaying(arg0\Field18) <> 0) Then
            stopchannel(arg0\Field18)
            arg0\Field18 = $00
        EndIf
        If (channelplaying(arg0\Field20) <> 0) Then
            stopchannel(arg0\Field20)
            arg0\Field20 = $00
        EndIf
        arg0\Field7 = 0.0
    Else
        local0 = entitydistancesquared(arg0\Field3, me\Field60)
        Select arg0\Field10
            Case 0.0
                If (400.0 < local0) Then
                    animatenpc(arg0, 451.0, 612.0, 0.2, $01)
                    If ((Float millisecs()) > arg0\Field11) Then
                        For local3 = Each waypoints
                            If (local3\Field1 = Null) Then
                                If (16.0 > distancesquared(entityx(local3\Field0, $01), entityx(arg0\Field3, $00), entityz(local3\Field0, $01), entityz(arg0\Field3, $00), 0.0, 0.0)) Then
                                    positionentity(arg0\Field3, entityx(local3\Field0, $01), (entityy(local3\Field0, $01) + (1.0 / 1.28)), entityz(local3\Field0, $01), $00)
                                    resetentity(arg0\Field3)
                                    Exit
                                EndIf
                            EndIf
                        Next
                        arg0\Field11 = (Float (millisecs() + $1388))
                    EndIf
                ElseIf (64.0 > local0) Then
                    arg0\Field30 = rnd(1.0, 2.5)
                    arg0\Field10 = 1.0
                EndIf
            Case 1.0
                If (451.0 > arg0\Field14) Then
                    local1 = wrapangle(curveangle((deltayaw(arg0\Field3, me\Field60) - 180.0), ((animtime(arg0\Field0) - 2.0) / 1.2445), 15.0), 360.0)
                    setnpcframe(arg0, ((local1 * 1.2445) + 2.0))
                Else
                    animatenpc(arg0, 636.0, 646.0, 0.4, $00)
                    If (646.0 = arg0\Field14) Then
                        setnpcframe(arg0, 2.0)
                    EndIf
                EndIf
                If (rand($2BC, $01) = $01) Then
                    playsoundex(loadtempsound((("SFX\SCP\066\Eric" + (Str rand($00, $02))) + ".ogg")), camera, arg0\Field3, 8.0, 1.0, $01)
                EndIf
                If (local0 < ((arg0\Field30 * arg0\Field30) + 1.0)) Then
                    If (entityvisible(me\Field60, arg0\Field3) <> 0) Then
                        giveachievement("066", $01)
                        arg0\Field10 = (Float rand($02, $03))
                    EndIf
                EndIf
            Case 2.0
                If (647.0 > arg0\Field14) Then
                    local1 = curveangle(0.0, ((animtime(arg0\Field0) - 2.0) / 1.2445), 5.0)
                    If (((5.0 > local1) Lor (355.0 < local1)) <> 0) Then
                        setnpcframe(arg0, 647.0)
                    Else
                        setnpcframe(arg0, ((local1 * 1.2445) + 2.0))
                    EndIf
                ElseIf (683.0 = arg0\Field14) Then
                    If (0.0 = arg0\Field11) Then
                        If (rand($02, $01) = $01) Then
                            playsoundex(loadtempsound((("SFX\SCP\066\Eric" + (Str rand($00, $02))) + ".ogg")), camera, arg0\Field3, 8.0, 1.0, $01)
                        Else
                            playsoundex(loadtempsound((("SFX\SCP\066\Notes" + (Str rand($00, $05))) + ".ogg")), camera, arg0\Field3, 8.0, 1.0, $00)
                        EndIf
                        If ((chs\Field2 Lor i_268\Field2) = $00) Then
                            Select rand($06, $01)
                                Case $01
                                    playsoundex(loadtempsound("SFX\SCP\066\Beethoven.ogg"), camera, arg0\Field3, 20.0, 1.0, $00)
                                    mp_synchronize3dsound(Null, "SFX\SCP\066\Beethoven.ogg", arg0\Field3, 20.0, 1.0)
                                    If (arg0\Field79 <> 0) Then
                                        me\Field55 = ((((Float selecteddifficulty\Field4) * 15.0) + 45.0) * 70.0)
                                        me\Field54 = $01
                                        me\Field24 = 10.0
                                    EndIf
                                Case $02
                                    arg0\Field12 = (Float rand($2BC, $578))
                                Case $03
                                    For local5 = Each doors
                                        If (256.0 > entitydistancesquared(local5\Field2, arg0\Field3)) Then
                                            If ((((((local5\Field4 = $00) And (local5\Field14 = $00)) And (local5\Field19 = $00)) And (local5\Field10 <> $05)) And (local5\Field10 <> $04)) <> 0) Then
                                                openclosedoor(local5, $01, $00)
                                            EndIf
                                        EndIf
                                    Next
                                Case $04
                                    If (playerroom\Field7\Field8 < $02) Then
                                        local6 = createdecal($01, entityx(arg0\Field3, $00), 0.005, entityz(arg0\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, 0.3, 1.0, $00, $01, $00, $00, $00)
                                        entityparent(local6\Field0, playerroom\Field2, $01)
                                    EndIf
                                    If (arg0\Field79 <> 0) Then
                                        me\Field24 = 5.0
                                    EndIf
                                    If (0.64 > distancesquared(entityx(me\Field60, $00), entityx(arg0\Field3, $00), entityz(me\Field60, $00), entityz(arg0\Field3, $00), 0.0, 0.0)) Then
                                        injureplayer(rnd(0.1, 0.3), 0.0, 200.0, 0.0, 0.0)
                                    EndIf
                                Case $05,$06
                            End Select
                        EndIf
                    EndIf
                    arg0\Field11 = (arg0\Field11 + fps\Field7[$00])
                    If (70.0 < arg0\Field11) Then
                        arg0\Field11 = 0.0
                        arg0\Field10 = 3.0
                    EndIf
                Else
                    arg0\Field24 = curvevalue((arg0\Field23 * 1.5), arg0\Field24, 10.0)
                    pointentity(arg0\Field0, me\Field60, 0.0)
                    rotateentity(arg0\Field3, 0.0, curveangle((entityyaw(arg0\Field0, $00) - 180.0), entityyaw(arg0\Field3, $00), 10.0), 0.0, $00)
                    animatenpc(arg0, 647.0, 683.0, (arg0\Field24 * 25.0), $00)
                    moveentity(arg0\Field3, 0.0, 0.0, ((- arg0\Field24) * fps\Field7[$00]))
                EndIf
            Case 3.0
                pointentity(arg0\Field0, me\Field60, 0.0)
                local1 = curveangle(((entityyaw(arg0\Field0, $00) + arg0\Field15) - 180.0), entityyaw(arg0\Field3, $00), 10.0)
                rotateentity(arg0\Field3, 0.0, local1, 0.0, $00)
                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                If (rand($64, $01) = $01) Then
                    arg0\Field15 = rnd(-20.0, 20.0)
                EndIf
                arg0\Field11 = (arg0\Field11 + fps\Field7[$00])
                If (250.0 < arg0\Field11) Then
                    animatenpc(arg0, 684.0, 647.0, ((- arg0\Field24) * 25.0), $00)
                    If (647.0 = arg0\Field14) Then
                        arg0\Field11 = 0.0
                        arg0\Field10 = 0.0
                    EndIf
                Else
                    animatenpc(arg0, 684.0, 647.0, ((- arg0\Field24) * 25.0), $01)
                EndIf
        End Select
        If (1.0 < arg0\Field10) Then
            If (arg0\Field17 = $00) Then
                arg0\Field17 = loadsound_strict("SFX\SCP\066\Rolling.ogg")
            EndIf
            If (channelplaying(arg0\Field18) = $00) Then
                arg0\Field18 = playsoundex(arg0\Field17, camera, arg0\Field3, 20.0, 1.0, $00)
            EndIf
        EndIf
        If (0.0 < arg0\Field12) Then
            arg0\Field12 = (arg0\Field12 - fps\Field7[$00])
            If (arg0\Field79 <> 0) Then
                lightvolume = (templightvolume - (clamp((arg0\Field12 / 500.0), 0.01, 0.6) * templightvolume))
                me\Field28 = max(me\Field28, 130.0)
                me\Field30 = max(me\Field30, min((arg0\Field12 / 1000.0), 1.0))
            EndIf
        EndIf
        updatesoundorigin(arg0\Field20, camera, arg0\Field3, 20.0, 1.0, $00, $01)
        If (channelplaying(arg0\Field20) <> 0) Then
            me\Field49 = max((5.0 - (sqr(local0) * 300.0)), 0.0)
        EndIf
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.2), entityz(arg0\Field3, $00), $00)
    rotateentity(arg0\Field0, (entitypitch(arg0\Field3, $00) - 89.9), entityyaw(arg0\Field3, $00), 0.0, $00)
    Return $00
End Function
