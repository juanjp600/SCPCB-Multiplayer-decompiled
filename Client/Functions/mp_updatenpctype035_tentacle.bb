Function mp_updatenpctype035_tentacle%(arg0.npcs)
    Local local0#
    Local local1#
    Local local3%
    Local local4.decals
    If (arg0\Field50 = $00) Then
        local0 = entitydistancesquared(arg0\Field3, me\Field60)
        If ((hidedistance * hidedistance) > local0) Then
            local1 = arg0\Field14
            Select arg0\Field10
                Case 0.0
                    If (282.0 = arg0\Field14) Then
                        local3 = createpivot($00)
                        positionentity(local3, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
                        turnentity(local3, 90.0, 0.0, 0.0, $00)
                        If (entitypick(local3, 0.5) <> 0) Then
                            local4 = createdecal($01, entityx(arg0\Field3, $00), (pickedy() + 0.005), entityz(arg0\Field3, $00), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 1.0, $00, $01, $00, $00, $00)
                            local4\Field4 = 0.0005
                            local4\Field5 = 0.2
                            entityparent(local4\Field0, playerroom\Field2, $01)
                        EndIf
                        freeentity(local3)
                        local3 = $00
                        playsoundex(loadtempsound("SFX\SCP\035_Tentacle\TentacleSpawn.ogg"), camera, arg0\Field3, 5.0, 1.0, $00, $00)
                        setnpcframe(arg0, 283.0, $01)
                    Else
                        me\Field30 = max(curvevalue(1.0, me\Field30, 50.0), me\Field30)
                        me\Field28 = max(curvevalue(130.0, me\Field28, 100.0), me\Field28)
                        pointentity(arg0\Field0, me\Field60, 0.0)
                        rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 25.0), 0.0, $00)
                        animatenpc(arg0, 283.0, 389.0, 0.3, $00)
                        If (388.9 < arg0\Field14) Then
                            arg0\Field10 = 1.0
                        EndIf
                    EndIf
                Case 1.0
                    animatenpc(arg0, 33.0, 174.0, 0.3, $01)
                    If (((3.24 > local0) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                        arg0\Field10 = 2.0
                    Else
                        If (rand($190, $01) = $01) Then
                            arg0\Field15 = rnd(360.0, 0.0)
                        EndIf
                        rotateentity(arg0\Field3, 0.0, curveangle((arg0\Field15 + (sin((Float (millisec / $32))) * 2.0)), entityyaw(arg0\Field3, $00), 150.0), 0.0, $01)
                    EndIf
                Case 2.0
                    If (((32.0 < arg0\Field14) And (174.0 > arg0\Field14)) <> 0) Then
                        animatenpc(arg0, 33.0, 174.0, 2.0, $00)
                        If (173.9 < arg0\Field14) Then
                            setnpcframe(arg0, 2.0, $01)
                        EndIf
                    Else
                        pointentity(arg0\Field0, me\Field60, 0.0)
                        rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 10.0), 0.0, $00)
                        animatenpc(arg0, 2.0, 32.0, 0.3, $00)
                        If (((5.0 < arg0\Field14) And (5.0 >= local1)) <> 0) Then
                            If (3.24 > local0) Then
                                If (20.0 > (Abs deltayaw(arg0\Field3, me\Field60))) Then
                                    If (mp_getnpctargetmodel(arg0) = $02) Then
                                        If (arg0\Field85 <> 0) Then
                                            playsound_strict(loadtempsound("SFX\Character\BodyFall.ogg"), $00, $01)
                                        EndIf
                                        injureplayer(rnd(0.5, 0.0), 0.0, 0.0, 0.0, 0.0)
                                    Else
                                        injureplayer((rnd(0.75, 1.15) * difficultydmgmult), 0.0, 100.0, (0.4 * difficultydmgmult), (0.175 * difficultydmgmult))
                                        playsoundex(snd_i\Field51[rand($09, $0A)], camera, arg0\Field3, 8.0, 1.0, $00, $00)
                                        If (3.0 < mp_getnpctargetinjuries(arg0)) Then
                                            If (playerroom\Field7\Field6 = $4D) Then
                                                msg\Field2 = getlocalstring("death", "035.offices")
                                            Else
                                                msg\Field2 = getlocalstring("death", "035.default")
                                            EndIf
                                            kill($01, $01, $00, $01)
                                        EndIf
                                    EndIf
                                    If (arg0\Field85 <> 0) Then
                                        me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.0)
                                    EndIf
                                Else
                                    playsoundex(snd_i\Field48, camera, arg0\Field3, 10.0, 1.0, $00, $00)
                                EndIf
                            Else
                                playsoundex(snd_i\Field48, camera, arg0\Field3, 3.0, 1.0, $00, $00)
                            EndIf
                        ElseIf (31.9 < arg0\Field14) Then
                            setnpcframe(arg0, 173.0, $01)
                            arg0\Field10 = 1.0
                        EndIf
                    EndIf
            End Select
            If (0.0 <> arg0\Field10) Then
                arg0\Field18 = loopsoundex(npcsound[$04], arg0\Field18, camera, arg0\Field3, 10.0, 1.0, $00)
            EndIf
        EndIf
        If (arg0\Field60 <= $00) Then
            arg0\Field50 = $01
        EndIf
    Else
        animatenpc(arg0, 515.0, 551.0, 0.15, $00)
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
    rotateentity(arg0\Field0, (entitypitch(arg0\Field3, $00) - 89.9), (entityyaw(arg0\Field3, $00) - 180.0), entityroll(arg0\Field3, $00), $01)
    Return $00
End Function
