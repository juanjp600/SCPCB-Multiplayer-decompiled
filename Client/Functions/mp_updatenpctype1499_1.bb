Function mp_updatenpctype1499_1%(arg0.npcs)
    Local local0.npcs
    Local local1#
    Local local2#
    Local local3%
    Local local5%
    local1 = arg0\Field14
    local2 = entitydistancesquared(arg0\Field3, me\Field60)
    If (((0.0 = arg0\Field26) And (local2 < ((hidedistance * 3.0) * (hidedistance * 3.0)))) <> 0) Then
        If (arg0\Field13 = $00) Then
            If (((0.0 = arg0\Field10) Lor (2.0 = arg0\Field10)) <> 0) Then
                For local0 = Each npcs
                    If (((local0\Field4 = arg0\Field4) And (local0 <> arg0)) <> 0) Then
                        If (((0.0 <> local0\Field10) And (2.0 <> local0\Field10)) <> 0) Then
                            If (local0\Field13 = $00) Then
                                arg0\Field10 = 1.0
                                arg0\Field11 = 0.0
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        EndIf
        Select arg0\Field10
            Case 0.0
                If (arg0\Field13 = $00) Then
                    If (0.0 = arg0\Field24) Then
                        If (0.0 = arg0\Field28) Then
                            If ((rnd(1.0, 3.0) * 500.0) > arg0\Field11) Then
                                arg0\Field24 = 0.0
                                arg0\Field11 = (arg0\Field11 + fps\Field7[$00])
                            ElseIf (0.0 = arg0\Field24) Then
                                arg0\Field24 = (arg0\Field24 + 0.0001)
                            EndIf
                        ElseIf (1500.0 > arg0\Field11) Then
                            arg0\Field24 = 0.0
                            arg0\Field11 = (arg0\Field11 + fps\Field7[$00])
                        Else
                            If (arg0\Field34 <> Null) Then
                                If (arg0\Field34\Field34 <> Null) Then
                                    arg0\Field34\Field34 = Null
                                EndIf
                                arg0\Field34\Field28 = 0.0
                                arg0\Field34\Field15 = (arg0\Field34\Field15 + rnd(-45.0, 45.0))
                                arg0\Field34 = Null
                                arg0\Field28 = 0.0
                                arg0\Field15 = (arg0\Field15 + rnd(-45.0, 45.0))
                            EndIf
                            If (0.0 = arg0\Field24) Then
                                arg0\Field24 = (arg0\Field24 + 0.0001)
                            EndIf
                        EndIf
                    Else
                        If (arg0\Field34 <> Null) Then
                            arg0\Field11 = 0.0
                        EndIf
                        If ((rnd(1.0, 3.0) * 10000.0) > arg0\Field11) Then
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                            arg0\Field11 = (arg0\Field11 + fps\Field7[$00])
                        Else
                            arg0\Field24 = curvevalue(0.0, arg0\Field24, 50.0)
                        EndIf
                        rotateentity(arg0\Field3, 0.0, curveangle(arg0\Field15, entityyaw(arg0\Field3, $00), 10.0), 0.0, $00)
                        If (arg0\Field34 = Null) Then
                            If (rand($C8, $01) = $01) Then
                                arg0\Field15 = (arg0\Field15 + rnd(-45.0, 45.0))
                            EndIf
                            If (entityhidden(arg0\Field3) = $00) Then
                                hideentity(arg0\Field3)
                            EndIf
                            entitypick(arg0\Field3, 1.5)
                            If (pickedentity() <> $00) Then
                                arg0\Field15 = (entityyaw(arg0\Field3, $00) + rnd(80.0, 110.0))
                            EndIf
                            If (entityhidden(arg0\Field3) <> 0) Then
                                showentity(arg0\Field3)
                            EndIf
                        Else
                            arg0\Field15 = (deltayaw(arg0\Field3, arg0\Field34\Field3) + entityyaw(arg0\Field3, $00))
                            If (2.25 > entitydistancesquared(arg0\Field3, arg0\Field34\Field3)) Then
                                arg0\Field24 = 0.0
                                arg0\Field34\Field24 = 0.0
                                arg0\Field28 = 1.0
                                arg0\Field34\Field28 = 1.0
                                local3 = rand($00, $02)
                                If (local3 = $00) Then
                                    setnpcframe(arg0, 296.0, $01)
                                ElseIf (local3 = $01) Then
                                    setnpcframe(arg0, 856.0, $01)
                                Else
                                    setnpcframe(arg0, 905.0, $01)
                                EndIf
                                local3 = rand($00, $02)
                                If (local3 = $00) Then
                                    setnpcframe(arg0\Field34, 296.0, $01)
                                ElseIf (local3 = $01) Then
                                    setnpcframe(arg0\Field34, 856.0, $01)
                                Else
                                    setnpcframe(arg0\Field34, 905.0, $01)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    rotateentity(arg0\Field3, 0.0, curveangle(arg0\Field15, entityyaw(arg0\Field3, $00), 10.0), 0.0, $00)
                EndIf
                If (0.0 = arg0\Field24) Then
                    If (((0.0 = arg0\Field28) And (arg0\Field13 <> $02)) <> 0) Then
                        animatenpc(arg0, 296.0, 320.0, 0.2, $01)
                    ElseIf (((0.0 = arg0\Field28) And (arg0\Field13 = $02)) <> 0) Then
                        If (532.5 >= arg0\Field14) Then
                            animatenpc(arg0, 509.0, 533.0, 0.2, $00)
                        ElseIf (((533.5 < arg0\Field14) And (600.5 >= arg0\Field14)) <> 0) Then
                            animatenpc(arg0, 534.0, 601.0, 0.2, $00)
                        Else
                            local3 = rand($00, $01)
                            If (local3 = $00) Then
                                setnpcframe(arg0, 509.0, $01)
                            Else
                                setnpcframe(arg0, 534.0, $01)
                            EndIf
                        EndIf
                    ElseIf (arg0\Field13 = $02) Then
                        animatenpc(arg0, 713.0, 855.0, 0.2, $00)
                        If (833.5 < arg0\Field14) Then
                            pointentity(arg0\Field0, me\Field60, 0.0)
                            rotateentity(arg0\Field3, 0.0, curveangle(arg0\Field15, entityyaw(arg0\Field3, $00), 10.0), 0.0, $00)
                        EndIf
                    ElseIf (arg0\Field13 = $01) Then
                        animatenpc(arg0, 602.0, 712.0, 0.2, $00)
                        If (711.5 < arg0\Field14) Then
                            arg0\Field28 = 0.0
                        EndIf
                    ElseIf (319.5 >= arg0\Field14) Then
                        animatenpc(arg0, 296.0, 320.0, 0.2, $00)
                    ElseIf (((320.5 < arg0\Field14) And (903.5 > arg0\Field14)) <> 0) Then
                        animatenpc(arg0, 856.0, 904.0, 0.2, $00)
                    ElseIf (((904.5 < arg0\Field14) And (952.5 > arg0\Field14)) <> 0) Then
                        animatenpc(arg0, 905.0, 953.0, 0.2, $00)
                    Else
                        local3 = rand($00, $02)
                        If (local3 = $00) Then
                            setnpcframe(arg0, 296.0, $01)
                        ElseIf (local3 = $01) Then
                            setnpcframe(arg0, 856.0, $01)
                        Else
                            setnpcframe(arg0, 905.0, $01)
                        EndIf
                    EndIf
                Else
                    If ((arg0\Field5 Mod $02) = $00) Then
                        animatenpc(arg0, 1.0, 62.0, (arg0\Field24 * 28.0), $01)
                    Else
                        animatenpc(arg0, 100.0, 167.0, (arg0\Field24 * 28.0), $01)
                    EndIf
                    If (arg0\Field13 = $00) Then
                        If (arg0\Field34 = Null) Then
                            If (rand($4B0, $01) = $01) Then
                                For local0 = Each npcs
                                    If (local0 <> arg0) Then
                                        If (local0\Field4 = arg0\Field4) Then
                                            If (local0\Field34 = Null) Then
                                                If (local0\Field13 = $00) Then
                                                    If (400.0 > entitydistancesquared(arg0\Field3, local0\Field3)) Then
                                                        arg0\Field34 = local0
                                                        local0\Field34 = arg0
                                                        arg0\Field34\Field24 = (arg0\Field34\Field24 + 0.0001)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (((arg0\Field34 = Null) And (arg0\Field13 = $00)) <> 0) Then
                    If (rand($1388, $01) = $01) Then
                        If (channelplaying(arg0\Field18) = $00) Then
                            If (400.0 > local2) Then
                                mp_loadnpcsound(arg0, (("SFX\SCP\1499\Idle" + (Str rand($00, $03))) + ".ogg"), $00)
                                arg0\Field18 = playsoundex(arg0\Field17, camera, arg0\Field3, 20.0, 1.0, $01, $00)
                            EndIf
                        EndIf
                        arg0\Field11 = 0.0
                        arg0\Field10 = 2.0
                    EndIf
                    If ((((arg0\Field5 Mod $02) = $00) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                        If (100.0 > local2) Then
                            If (entityvisible(arg0\Field3, me\Field60) <> 0) Then
                                If (25.0 > local2) Then
                                    mp_loadnpcsound(arg0, "SFX\SCP\1499\Triggered.ogg", $00)
                                    arg0\Field18 = playsoundex(arg0\Field17, camera, arg0\Field3, 20.0, 1.0, $01, $00)
                                    arg0\Field11 = 1.0
                                    For local0 = Each npcs
                                        If (((local0\Field4 = arg0\Field4) And (local0 <> arg0)) <> 0) Then
                                            If (local0\Field13 = $00) Then
                                                local0\Field10 = 1.0
                                                local0\Field11 = 0.0
                                            EndIf
                                        EndIf
                                    Next
                                Else
                                    arg0\Field11 = 0.0
                                EndIf
                                setnpcframe(arg0, 203.0, $01)
                                arg0\Field10 = 2.0
                            EndIf
                        EndIf
                    EndIf
                ElseIf (arg0\Field13 = $01) Then
                    If ((chs\Field2 Lor i_268\Field2) = $00) Then
                        If (16.0 > local2) Then
                            If (entityvisible(arg0\Field3, me\Field60) <> 0) Then
                                mp_loadnpcsound(arg0, "SFX\SCP\1499\Triggered.ogg", $00)
                                arg0\Field18 = playsoundex(arg0\Field17, camera, arg0\Field3, 20.0, 1.0, $01, $00)
                                setnpcframe(arg0, 203.0, $01)
                                arg0\Field10 = 1.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case 1.0
                If ((chs\Field2 Lor i_268\Field2) <> 0) Then
                    arg0\Field10 = 0.0
                EndIf
                If (((playerroom\Field7\Field6 = $6A) And (arg0\Field13 = $00)) <> 0) Then
                    shouldplay = $12
                EndIf
                pointentity(arg0\Field0, me\Field60, 0.0)
                rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
                If (0.0 = arg0\Field11) Then
                    If (arg0\Field13 = $01) Then
                        arg0\Field24 = curvevalue((arg0\Field23 * 2.0), arg0\Field24, 10.0)
                        If (arg0\Field34 <> Null) Then
                            arg0\Field34\Field10 = 1.0
                        EndIf
                    Else
                        arg0\Field24 = curvevalue((arg0\Field23 * 1.75), arg0\Field24, 10.0)
                    EndIf
                    If ((arg0\Field5 Mod $02) = $00) Then
                        animatenpc(arg0, 1.0, 62.0, (arg0\Field24 * 28.0), $01)
                    Else
                        animatenpc(arg0, 100.0, 167.0, (arg0\Field24 * 28.0), $01)
                    EndIf
                EndIf
                If (0.5625 > local2) Then
                    If (((((((arg0\Field5 Mod $02) = $00) Lor (1.0 = arg0\Field12)) Lor (arg0\Field13 = $01)) Lor (arg0\Field13 = $03)) Lor (arg0\Field13 = $04)) <> 0) Then
                        If (1.0 = arg0\Field11) Then
                            setnpcframe(arg0, 63.0, $01)
                        Else
                            setnpcframe(arg0, 168.0, $01)
                        EndIf
                        arg0\Field11 = (Float rand($01, $02))
                        arg0\Field10 = 3.0
                    Else
                        arg0\Field10 = 4.0
                    EndIf
                EndIf
            Case 2.0
                arg0\Field24 = 0.0
                animatenpc(arg0, 203.0, 295.0, 0.1, $00)
                If (294.0 < arg0\Field14) Then
                    arg0\Field10 = arg0\Field11
                EndIf
            Case 3.0
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                local5 = $00
                If (1.0 = arg0\Field11) Then
                    animatenpc(arg0, 63.0, 100.0, 0.6, $00)
                    local5 = ((89.0 > local1) And (89.0 <= arg0\Field14))
                    If (99.0 <= arg0\Field14) Then
                        arg0\Field11 = 0.0
                        arg0\Field10 = 1.0
                    EndIf
                Else
                    animatenpc(arg0, 168.0, 202.0, 0.6, $00)
                    local5 = ((189.0 > local1) And (189.0 <= arg0\Field14))
                    If (201.0 <= arg0\Field14) Then
                        arg0\Field11 = 0.0
                        arg0\Field10 = 1.0
                    EndIf
                EndIf
                If (local5 <> 0) Then
                    If (((0.64 < local2) Lor (60.0 < (Abs deltayaw(arg0\Field3, me\Field60)))) <> 0) Then
                        playsoundex(snd_i\Field48, camera, arg0\Field3, 2.5, 1.0, $00, $00)
                    ElseIf (arg0\Field85 <> 0) Then
                        playsound_strict(snd_i\Field51[rand($0B, $0C)], $00, $01)
                        injureplayer((rnd(0.65, 1.1) * difficultydmgmult), 0.0, 500.0, (0.35 * difficultydmgmult), (0.15 * difficultydmgmult))
                        me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.5)
                        If (10.0 < mp_getnpctargetinjuries(arg0)) Then
                            If (playerroom\Field7\Field6 = $6A) Then
                                msg\Field2 = getlocalstring("death", "1499.dimension")
                            Else
                                msg\Field2 = getlocalstring("death", "1499")
                            EndIf
                            kill($01, $01, $00, $01)
                        EndIf
                    Else
                        playsoundex(snd_i\Field51[rand($0B, $0C)], camera, arg0\Field3, 8.0, 1.0, $00, $00)
                    EndIf
                EndIf
            Case 4.0
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                animatenpc(arg0, 296.0, 320.0, 0.2, $01)
                pointentity(arg0\Field0, me\Field60, 0.0)
                rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
                If (0.64 < local2) Then
                    arg0\Field10 = 1.0
                EndIf
        End Select
        updatesoundorigin(arg0\Field18, camera, arg0\Field3, 20.0, 1.0, $01, $01)
        moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
        rotateentity(arg0\Field0, 0.0, (entityyaw(arg0\Field3, $00) - 180.0), 0.0, $00)
        positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.2), entityz(arg0\Field3, $00), $00)
        If (entityhidden(arg0\Field0) <> 0) Then
            showentity(arg0\Field0)
        EndIf
    ElseIf (entityhidden(arg0\Field0) = $00) Then
        hideentity(arg0\Field0)
    EndIf
    Return $00
End Function
