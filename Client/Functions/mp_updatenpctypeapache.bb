Function mp_updatenpctypeapache%(arg0.npcs)
    Local local0#
    Local local1%
    Local local3#
    Local local4%
    Local local5%
    Local local6#
    If (3600.0 > entitydistancesquared(me\Field60, arg0\Field3)) Then
        If (playerroom\Field7\Field6 = $49) Then
            local0 = clamp((entitydistance(arg0\Field3, playerroom\Field11[$0A]) / 31.25), 0.0, 1.0)
        Else
            local0 = 1.0
        EndIf
        arg0\Field18 = loopsoundex(snd_i\Field60, arg0\Field18, camera, arg0\Field3, 25.0, local0, $00)
    EndIf
    arg0\Field7 = 0.0
    Select arg0\Field10
        Case 0.0,1.0
            turnentity(arg0\Field1, 0.0, (fps\Field7[$00] * 20.0), 0.0, $00)
            turnentity(arg0\Field2, (fps\Field7[$00] * 20.0), 0.0, 0.0, $00)
            If (((1.0 = arg0\Field10) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                If (rand($14, $01) = $01) Then
                    If (900.0 > distancesquared(entityx(me\Field60, $00), entityx(arg0\Field3, $00), entityz(me\Field60, $00), entityz(arg0\Field3, $00), 0.0, 0.0)) Then
                        If (20.0 > (Abs (entityy(me\Field60, $00) - entityy(arg0\Field3, $00)))) Then
                            If (entityvisible(me\Field60, arg0\Field3) <> 0) Then
                                playsoundex(snd_i\Field50[$01], camera, arg0\Field3, 50.0, 1.0, $00, $00)
                                arg0\Field10 = 2.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        Case 2.0,3.0
            If (2.0 = arg0\Field10) Then
                local1 = me\Field60
            ElseIf (3.0 = arg0\Field10) Then
                local1 = createpivot($00)
                positionentity(local1, arg0\Field36, arg0\Field37, arg0\Field38, $01)
            EndIf
            turnentity(arg0\Field1, 0.0, (fps\Field7[$00] * 20.0), 0.0, $00)
            turnentity(arg0\Field2, (fps\Field7[$00] * 20.0), 0.0, 0.0, $00)
            If (3025.0 > distancesquared(entityx(local1, $00), entityx(arg0\Field3, $00), entityz(local1, $00), entityz(arg0\Field3, $00), 0.0, 0.0)) Then
                If (20.0 > (Abs (entityy(local1, $00) - entityy(arg0\Field3, $00)))) Then
                    pointentity(arg0\Field0, local1, 0.0)
                    rotateentity(arg0\Field3, curveangle(min(wrapangle(entitypitch(arg0\Field0, $00), 360.0), 40.0), entitypitch(arg0\Field3, $00), 40.0), curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 89.9), entityroll(arg0\Field3, $00), $01)
                    positionentity(arg0\Field3, entityx(arg0\Field3, $00), curvevalue((entityy(local1, $00) + 8.0), entityy(arg0\Field3, $00), 70.0), entityz(arg0\Field3, $00), $00)
                    local3 = distancesquared(entityx(local1, $00), entityx(arg0\Field3, $00), entityz(local1, $00), entityz(arg0\Field3, $00), 0.0, 0.0)
                    arg0\Field24 = curvevalue((min((sqr(local3) - 6.5), 6.5) * 0.008), arg0\Field24, 50.0)
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    local4 = $00
                    If (0.0 = arg0\Field41) Then
                        local4 = entityvisible(arg0\Field3, local1)
                        arg0\Field41 = rnd(100.0, 200.0)
                    Else
                        arg0\Field41 = min((arg0\Field41 - fps\Field7[$00]), 0.0)
                    EndIf
                    If (((chs\Field2 Lor i_268\Field2) And (2.0 = arg0\Field10)) <> 0) Then
                        local4 = $00
                    EndIf
                    If (local4 <> 0) Then
                        rotateentity(arg0\Field3, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), curveangle(0.0, entityroll(arg0\Field3, $00), 40.0), $01)
                        If (0.0 >= arg0\Field28) Then
                            If (400.0 > local3) Then
                                local5 = createpivot($00)
                                positionentity(local5, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
                                rotateentity(local5, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), entityroll(arg0\Field3, $00), $00)
                                moveentity(local5, 0.0, 0.023, 0.188)
                                pointentity(local5, local1, 0.0)
                                If (10.0 > wrapangle((entityyaw(local5, $00) - entityyaw(arg0\Field3, $00)), 360.0)) Then
                                    playsoundex(snd_i\Field13[$01], camera, arg0\Field3, 20.0, 1.0, $00, $00)
                                    local6 = sqr(local3)
                                    shoot(arg0, entityx(local5, $00), entityy(local5, $00), entityz(local5, $00), arg0\Field3, (((10.0 / local6) * (1.0 / local6)) * (Float (2.0 = arg0\Field10))), (2.0 = arg0\Field10), $00)
                                    If (((Int me\Field0) And (3.0 <> arg0\Field10)) <> 0) Then
                                        If (playerroom\Field7\Field6 = $49) Then
                                            msg\Field2 = getlocalstring("death", "apache.gateb")
                                        Else
                                            msg\Field2 = getlocalstring("death", "apache.gatea")
                                        EndIf
                                    EndIf
                                EndIf
                                freeentity(local5)
                                local5 = $00
                            EndIf
                            arg0\Field28 = 5.0
                        EndIf
                    Else
                        rotateentity(arg0\Field3, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), curveangle(-20.0, entityroll(arg0\Field3, $00), 40.0), $01)
                    EndIf
                    moveentity(arg0\Field3, ((- entityroll(arg0\Field3, $00)) * 0.002), 0.0, 0.0)
                    arg0\Field28 = (arg0\Field28 - fps\Field7[$00])
                EndIf
            EndIf
            If (3.0 = arg0\Field10) Then
                freeentity(local1)
                local1 = $00
            EndIf
        Case 4.0
            If (300.0 > arg0\Field11) Then
                turnentity(arg0\Field1, 0.0, (fps\Field7[$00] * 20.0), 0.0, $00)
                turnentity(arg0\Field2, (fps\Field7[$00] * 20.0), 0.0, 0.0, $00)
                turnentity(arg0\Field3, 0.0, ((- fps\Field7[$00]) * 7.0), 0.0, $00)
                arg0\Field11 = (arg0\Field11 + (fps\Field7[$00] * 0.3))
                local1 = createpivot($00)
                positionentity(local1, arg0\Field36, arg0\Field37, arg0\Field38, $01)
                pointentity(arg0\Field0, local1, 0.0)
                moveentity(arg0\Field0, 0.0, 0.0, ((fps\Field7[$00] * 0.001) * arg0\Field11))
                positionentity(arg0\Field3, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                If (0.09 > entitydistancesquared(arg0\Field0, local1)) Then
                    me\Field23 = max(me\Field23, 3.0)
                    playsound_strict(loadtempsound((("SFX\Character\Apache\Crash" + (Str rand($00, $01))) + ".ogg")), $00, $01)
                    arg0\Field10 = 5.0
                EndIf
                freeentity(local1)
                local1 = $00
            EndIf
    End Select
    positionentity(arg0\Field0, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
    rotateentity(arg0\Field0, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), entityroll(arg0\Field3, $00), $01)
    Return $00
End Function
