Function mp_updatenpctype860_2%(arg0.npcs)
    Local local0.forest
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10#
    Local local11#
    Local local14%
    Local local15%
    Local local16%
    Local local17$
    Local local18%
    If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) = $00) Then
        Return $00
    EndIf
    local0 = playerroom\Field10
    local1 = entitydistancesquared(me\Field60, arg0\Field3)
    If (1.0 = forestnpcdata[$02]) Then
        If (entityhidden(forestnpc) <> 0) Then
            showentity(forestnpc)
        EndIf
        If (0.0 = forestnpcdata[$01]) Then
            If (rand($C8, $01) = $01) Then
                forestnpcdata[$01] = fps\Field7[$00]
                entitytexture(forestnpc, forestnpctex, (Int (forestnpcdata[$00] + 1.0)), $00)
            EndIf
        ElseIf (((0.0 < forestnpcdata[$01]) And (5.0 > forestnpcdata[$01])) <> 0) Then
            forestnpcdata[$01] = min((fps\Field7[$00] + forestnpcdata[$01]), 5.0)
        Else
            forestnpcdata[$01] = 0.0
            entitytexture(forestnpc, forestnpctex, (Int forestnpcdata[$00]), $00)
        EndIf
        If (1.0 <> arg0\Field10) Then
            If ((((-8.0 > me\Field10) And (-12.0 < me\Field10)) Lor (entityinview(forestnpc, camera) = $00)) <> 0) Then
                forestnpcdata[$02] = 0.0
                If (entityhidden(forestnpc) = $00) Then
                    hideentity(forestnpc)
                EndIf
            EndIf
        EndIf
    ElseIf (entityhidden(forestnpc) = $00) Then
        hideentity(forestnpc)
    EndIf
    Select arg0\Field10
        Case 0.0
            If (entityhidden(arg0\Field3) = $00) Then
                hideentity(arg0\Field3)
                hideentity(arg0\Field0)
                hideentity(arg0\Field1)
                positionentity(arg0\Field3, 0.0, -100.0, 0.0, $00)
                arg0\Field11 = 0.0
            EndIf
        Case 1.0
            arg0\Field7 = 0.0
            If (-100.0 >= entityy(arg0\Field3, $00)) Then
                tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local0\Field4)
                local2 = (Int floor(((tformedx() + 6.0) / 12.0)))
                local3 = (Int floor(((tformedz() + 6.0) / 12.0)))
                local6 = (Int max((Float (local2 - $01)), 1.0))
                local7 = (Int min((Float (local2 + $01)), 10.0))
                local8 = (Int max((Float (local3 - $01)), 1.0))
                local9 = (Int min((Float (local3 + $01)), 10.0))
                For local4 = local6 To local7 Step $02
                    For local5 = local8 To local9 Step $02
                        If (local0\Field2[((local5 * $0A) + local4)] = $00) Then
                            tformpoint((((Float (local4 + local2)) / 2.0) * 12.0), 0.0, (((Float (local5 + local3)) / 2.0) * 12.0), local0\Field4, $00)
                            positionentity(arg0\Field3, tformedx(), (entityy(local0\Field4, $01) + 2.3), tformedz(), $00)
                            If (entityinview(arg0\Field3, mp_getnpctargetcamera(arg0)) <> 0) Then
                                positionentity(arg0\Field3, 0.0, -110.0, 0.0, $00)
                            Else
                                local4 = $0A
                                Exit
                            EndIf
                        EndIf
                    Next
                Next
                If (-100.0 < entityy(arg0\Field3, $00)) Then
                    playsoundex(stepsfx($04, $00, rand($00, $02)), camera, arg0\Field3, 15.0, 0.5, $00, $00)
                    If (1.0 <> forestnpcdata[$02]) Then
                        forestnpcdata[$02] = 0.0
                    EndIf
                    Select rand($03, $01)
                        Case $01
                            pointentity(arg0\Field3, me\Field60, 0.0)
                            setnpcframe(arg0, 2.0, $01)
                        Case $02
                            pointentity(arg0\Field3, me\Field60, 0.0)
                            setnpcframe(arg0, 201.0, $01)
                        Case $03
                            pointentity(arg0\Field3, me\Field60, 0.0)
                            turnentity(arg0\Field3, 0.0, 90.0, 0.0, $00)
                            setnpcframe(arg0, 299.0, $01)
                    End Select
                    arg0\Field11 = 0.0
                EndIf
            Else
                If (entityhidden(arg0\Field0) <> 0) Then
                    showentity(arg0\Field0)
                    showentity(arg0\Field3)
                EndIf
                positionentity(arg0\Field3, entityx(arg0\Field3, $00), (entityy(local0\Field4, $01) + 2.3), entityz(arg0\Field3, $00), $00)
                If (0.0 = forestnpcdata[$02]) Then
                    local14 = $00
                    local15 = $00
                    For local16 = $00 To (maxitemamount - $01) Step $01
                        If (inventory(local16) <> Null) Then
                            local17 = inventory(local16)\Field4\Field1
                            If ((((local17 = "Log #1") Lor (local17 = "Log #2")) Lor (local17 = "Log #3")) <> 0) Then
                                local15 = (local15 + $01)
                                local14 = (local14 + ($0A * local15))
                            EndIf
                        EndIf
                    Next
                    If (rand(($35C - local14), $01) = $01) Then
                        If (entityhidden(forestnpc) <> 0) Then
                            showentity(forestnpc)
                        EndIf
                        forestnpcdata[$02] = 1.0
                        If (rand($02, $01) = $01) Then
                            forestnpcdata[$00] = 0.0
                        Else
                            forestnpcdata[$00] = 2.0
                        EndIf
                        forestnpcdata[$01] = 0.0
                        positionentity(forestnpc, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.5), entityz(arg0\Field3, $00), $00)
                        rotateentity(forestnpc, 0.0, entityyaw(arg0\Field3, $00), 0.0, $00)
                        moveentity(forestnpc, 0.75, 0.0, 0.0)
                        rotateentity(forestnpc, 0.0, 0.0, 0.0, $00)
                        entitytexture(forestnpc, forestnpctex, (Int forestnpcdata[$00]), $00)
                    Else
                        forestnpcdata[$02] = 2.0
                    EndIf
                EndIf
                If (0.0 = arg0\Field11) Then
                    If (entityinview(arg0\Field3, mp_getnpctargetcamera(arg0)) <> 0) Then
                        If (rand($08, $01) = $01) Then
                            playsoundex(loadtempsound((("SFX\SCP\860_2\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, arg0\Field3, 20.0, 1.0, $01, $00)
                        EndIf
                        arg0\Field11 = 1.0
                    EndIf
                ElseIf (199.0 >= arg0\Field14) Then
                    animatenpc(arg0, 2.0, 199.0, 0.5, $00)
                    If (199.0 = arg0\Field14) Then
                        playsoundex(stepsfx($04, $00, rand($00, $02)), camera, arg0\Field3, 15.0, 1.0, $00, $00)
                        setnpcframe(arg0, 298.0, $01)
                    EndIf
                ElseIf (297.0 >= arg0\Field14) Then
                    pointentity(arg0\Field3, me\Field60, 0.0)
                    animatenpc(arg0, 200.0, 297.0, 0.5, $00)
                    If (297.0 = arg0\Field14) Then
                        playsoundex(stepsfx($04, $00, rand($00, $02)), camera, arg0\Field3, 15.0, 1.0, $00, $00)
                        setnpcframe(arg0, 298.0, $01)
                    EndIf
                Else
                    local10 = curveangle(pointdirection(entityx(arg0\Field3, $00), entityz(arg0\Field3, $00), entityx(me\Field60, $00), entityz(me\Field60, $00)), (entityyaw(arg0\Field3, $00) + 90.0), 20.0)
                    rotateentity(arg0\Field3, 0.0, (local10 - 90.0), 0.0, $01)
                    animatenpc(arg0, 298.0, 316.0, (arg0\Field24 * 10.0), $01)
                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    If (225.0 < local1) Then
                        arg0\Field10 = 0.0
                    EndIf
                EndIf
            EndIf
            resetentity(arg0\Field3)
        Case 2.0
            If (entityhidden(arg0\Field0) <> 0) Then
                showentity(arg0\Field0)
                showentity(arg0\Field3)
            EndIf
            local11 = arg0\Field14
            If (-100.0 >= entityy(arg0\Field3, $00)) Then
                tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, local0\Field4)
                local2 = (Int floor(((tformedx() + 6.0) / 12.0)))
                local3 = (Int floor(((tformedz() + 6.0) / 12.0)))
                local6 = (Int max((Float (local2 - $01)), 1.0))
                local7 = (Int min((Float (local2 + $01)), 10.0))
                local8 = (Int max((Float (local3 - $01)), 1.0))
                local9 = (Int min((Float (local3 + $01)), 10.0))
                For local4 = local6 To local7 Step $01
                    For local5 = local8 To local9 Step $01
                        If ((((local0\Field2[((local5 * $0A) + local4)] > $00) And ((local4 <> local2) Lor (local5 <> local3))) And ((local4 = local2) Lor (local5 = local3))) <> 0) Then
                            tformpoint(((Float local4) * 12.0), 0.0, ((Float local5) * 12.0), local0\Field4, $00)
                            positionentity(arg0\Field3, tformedx(), (entityy(local0\Field4, $01) + 1.0), tformedz(), $00)
                            If (entityinview(arg0\Field3, camera) <> 0) Then
                                me\Field10 = -10.0
                            Else
                                local4 = $0A
                                Exit
                            EndIf
                        EndIf
                    Next
                Next
            Else
                local10 = curveangle(find860angle(arg0, local0), (entityyaw(arg0\Field3, $00) + 90.0), 80.0)
                rotateentity(arg0\Field3, 0.0, (local10 - 90.0), 0.0, $01)
                arg0\Field24 = curvevalue((arg0\Field23 * 0.3), arg0\Field24, 50.0)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                animatenpc(arg0, 494.0, 569.0, (arg0\Field24 * 25.0), $01)
                If (0.0 = arg0\Field11) Then
                    If (64.0 > local1) Then
                        If (entityinview(arg0\Field3, mp_getnpctargetcamera(arg0)) <> 0) Then
                            If (rand($08, $01) = $01) Then
                                If (arg0\Field85 <> 0) Then
                                    playsound_strict(loadtempsound((("SFX\SCP\860_2\Chase" + (Str rand($00, $02))) + ".ogg")), $00)
                                EndIf
                                playsoundex(loadtempsound((("SFX\SCP\860_2\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, arg0\Field3, 10.0, 1.0, $01, $00)
                            EndIf
                            arg0\Field11 = 1.0
                        EndIf
                    EndIf
                EndIf
                If (0.03 < me\Field38) Then
                    arg0\Field12 = (arg0\Field12 + fps\Field7[$00])
                    If (arg0\Field12 > rnd(5000.0, 0.0)) Then
                        If (channelplaying(arg0\Field18) = $00) Then
                            arg0\Field18 = playsoundex(loadtempsound((("SFX\SCP\860_2\Cancer" + (Str rand($00, $02))) + ".ogg")), camera, arg0\Field3, 10.0, 1.0, $01, $00)
                        EndIf
                    EndIf
                Else
                    arg0\Field12 = max((arg0\Field12 - fps\Field7[$00]), 0.0)
                EndIf
                If (((20.25 > local1) Lor (rnd(200.0, 250.0) < arg0\Field12)) <> 0) Then
                    If ((chs\Field2 Lor i_268\Field2) = $00) Then
                        arg0\Field18 = playsoundex(loadtempsound((("SFX\SCP\860_2\Cancer" + (Str rand($03, $05))) + ".ogg")), camera, arg0\Field3, 10.0, 1.0, $01, $00)
                        arg0\Field10 = 3.0
                    ElseIf ((((492.0 > local11) And (492.0 <= arg0\Field14)) Lor ((568.0 > local11) And (568.0 <= arg0\Field14))) <> 0) Then
                        setnpcframe(arg0, 2.0, $01)
                        arg0\Field10 = 4.0
                    EndIf
                EndIf
                If (400.0 < local1) Then
                    arg0\Field10 = 0.0
                EndIf
            EndIf
            If ((((533.0 > local11) And (533.0 <= arg0\Field14)) Lor ((568.0 > local11) And (568.0 <= arg0\Field14))) <> 0) Then
                playsoundex(stepsfx($04, $00, rand($00, $02)), camera, arg0\Field3, 15.0, 0.6, $00, $00)
            EndIf
        Case 3.0
            If (entityhidden(arg0\Field0) <> 0) Then
                showentity(arg0\Field0)
                showentity(arg0\Field3)
            EndIf
            local11 = arg0\Field14
            local10 = curveangle(find860angle(arg0, local0), (entityyaw(arg0\Field3, $00) + 90.0), 40.0)
            rotateentity(arg0\Field3, 0.0, (local10 - 90.0), 0.0, $01)
            If (((1.0 > local1) Lor ((451.0 < arg0\Field14) And (493.0 > arg0\Field14))) <> 0) Then
                msg\Field2 = format(getlocalstring("death", "860"), subjectname, "%s")
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                animatenpc(arg0, 451.0, 493.0, 0.5, $00)
                If (((461.0 > local11) And (461.0 <= arg0\Field14)) <> 0) Then
                    playsoundex(snd_i\Field51[$0B], camera, arg0\Field3, 10.0, 1.0, $00, $00)
                    kill($01, $01, $00, $01)
                    If (arg0\Field85 <> 0) Then
                        me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.0)
                    EndIf
                EndIf
                If ((((476.0 > local11) And (476.0 <= arg0\Field14)) Lor ((486.0 > local11) And (486.0 <= arg0\Field14))) <> 0) Then
                    If (arg0\Field85 <> 0) Then
                        playsound_strict(snd_i\Field51[$0C], $00)
                    Else
                        playsoundex(snd_i\Field51[$0B], camera, arg0\Field3, 10.0, 1.0, $00, $00)
                    EndIf
                EndIf
            Else
                arg0\Field24 = curvevalue((arg0\Field23 * 0.8), arg0\Field24, 10.0)
                animatenpc(arg0, 298.0, 316.0, (arg0\Field24 * 10.0), $01)
                If (((307.0 > local11) And (307.0 <= arg0\Field14)) <> 0) Then
                    playsoundex(stepsfx($04, $00, rand($00, $02)), camera, arg0\Field3, 10.0, 1.0, $00, $00)
                EndIf
            EndIf
            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
            If ((chs\Field2 Lor i_268\Field2) <> 0) Then
                If ((((315.0 > local11) And (315.0 <= arg0\Field14)) Lor ((492.0 > local11) And (492.0 <= arg0\Field14))) <> 0) Then
                    setnpcframe(arg0, 2.0, $01)
                    arg0\Field10 = 4.0
                EndIf
            EndIf
        Case 4.0
            arg0\Field24 = 0.0
            animatenpc(arg0, 2.0, 199.0, 0.5, $01)
            If ((chs\Field2 Lor i_268\Field2) = $00) Then
                arg0\Field10 = 3.0
            EndIf
    End Select
    If (0.0 <> arg0\Field10) Then
        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $01)
        positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.23), entityz(arg0\Field3, $00), $00)
        rotateentity(arg0\Field0, (entitypitch(arg0\Field3, $00) - 89.9), entityyaw(arg0\Field3, $00), entityroll(arg0\Field3, $00), $01)
        If (64.0 < local1) Then
            If (entityhidden(arg0\Field1) <> 0) Then
                showentity(arg0\Field1)
            EndIf
            entityalpha(arg0\Field1, min((sqr(local1) - 8.0), 1.0))
            positionentity(arg0\Field1, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
            rotateentity(arg0\Field1, 0.0, (entityyaw(arg0\Field3, $00) - 180.0), 0.0, $00)
            moveentity(arg0\Field1, 0.0, 0.75, -0.825)
            local18 = createpivot($00)
            positionentity(local18, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
            pointentity(local18, arg0\Field1, 0.0)
            moveentity(local18, 0.0, 0.0, 8.0)
            positionentity(arg0\Field1, entityx(local18, $00), entityy(local18, $00), entityz(local18, $00), $00)
            freeentity(local18)
            local18 = $00
        ElseIf (entityhidden(arg0\Field1) = $00) Then
            hideentity(arg0\Field1)
        EndIf
    EndIf
    Return $00
End Function
