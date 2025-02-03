Function mp_updatenpctype939%(arg0.npcs)
    Local local0#
    Local local1#
    Local local2%
    If (((playerroom\Field7\Field6 = $1F) And (isinfacility(entityy(me\Field60, $00)) = $FFFFFFFF)) = $00) Then
        arg0\Field7 = 0.0
        Return $00
    EndIf
    Select arg0\Field10
        Case 0.0
            animatenpc(arg0, 290.0, 405.0, 0.1, $01)
        Case 1.0
            If (((644.0 <= arg0\Field14) And (683.0 > arg0\Field14)) <> 0) Then
                arg0\Field24 = curvevalue((arg0\Field23 * 0.05), arg0\Field24, 10.0)
                animatenpc(arg0, 644.0, 683.0, ((arg0\Field24 * 28.0) * 4.0), $00)
                If (682.0 <= arg0\Field14) Then
                    setnpcframe(arg0, 175.0, $01)
                EndIf
            Else
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                animatenpc(arg0, 175.0, 297.0, 0.22, $00)
                If (296.0 <= arg0\Field14) Then
                    arg0\Field10 = 2.0
                EndIf
            EndIf
            arg0\Field29 = $00
            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
        Case 2.0
            arg0\Field11 = max(arg0\Field11, (Float (arg0\Field13 - $03)))
            local0 = entitydistancesquared(arg0\Field3, playerroom\Field11[(Int arg0\Field11)])
            arg0\Field24 = curvevalue(((arg0\Field23 * 0.3) * min(sqr(local0), 1.0)), arg0\Field24, 10.0)
            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
            local1 = arg0\Field14
            animatenpc(arg0, 644.0, 683.0, (arg0\Field24 * 28.0), $01)
            If ((((664.0 > local1) And (664.0 <= arg0\Field14)) Lor ((673.0 < local1) And (654.0 > arg0\Field14))) <> 0) Then
                playsoundex(snd_i\Field56[rand($03, $06)], camera, arg0\Field3, 12.0, 1.0, $00, $00)
                If (rand($0A, $01) = $01) Then
                    local2 = ((arg0\Field18 = $00) Lor (channelplaying(arg0\Field18) = $00))
                    If (local2 <> 0) Then
                        mp_loadnpcsound(arg0, (((("SFX\SCP\939\" + (Str (arg0\Field5 Mod $03))) + "Lure") + (Str rand($00, $09))) + ".ogg"), $00)
                        arg0\Field18 = playsoundex(arg0\Field17, camera, arg0\Field3, 10.0, 1.0, $01, $00)
                    EndIf
                EndIf
            EndIf
            pointentity(arg0\Field0, playerroom\Field11[(Int arg0\Field11)], 0.0)
            rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
            If (0.16 > local0) Then
                arg0\Field11 = (arg0\Field11 + 1.0)
                If ((Float arg0\Field13) < arg0\Field11) Then
                    arg0\Field11 = (Float (arg0\Field13 - $03))
                EndIf
                arg0\Field10 = 1.0
            EndIf
        Case 3.0
            If (entityvisible(me\Field60, arg0\Field3) <> 0) Then
                arg0\Field36 = entityx(me\Field60, $00)
                arg0\Field38 = entityz(me\Field60, $00)
                arg0\Field29 = $46
            EndIf
            If (((arg0\Field29 > $00) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                local1 = arg0\Field14
                If (((18.0 <= arg0\Field14) And (68.0 > arg0\Field14)) <> 0) Then
                    arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                    animatenpc(arg0, 18.0, 68.0, 0.5, $01)
                    local2 = (((24.0 > local1) And (24.0 <= arg0\Field14)) Lor ((57.0 > local1) And (57.0 <= arg0\Field14)))
                    If (local2 <> 0) Then
                        If (2.25 > entitydistancesquared(me\Field60, arg0\Field3)) Then
                            playsoundex(snd_i\Field51[$0B], camera, arg0\Field3, 8.0, 1.0, $00, $00)
                            injureplayer(rnd(1.5, 2.5), 0.0, 500.0, rnd(0.2, 0.75), 0.0)
                            If (arg0\Field85 <> 0) Then
                                me\Field23 = ((Float (0.0 = i_1025\Field1[$03])) * 2.0)
                            EndIf
                            If (4.0 < mp_getnpctargetinjuries(arg0)) Then
                                kill($01, $01, $00, $01)
                                arg0\Field10 = 1.0
                            EndIf
                        Else
                            setnpcframe(arg0, 449.0, $01)
                        EndIf
                    EndIf
                ElseIf (0.0 < (Float arg0\Field29)) Then
                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 15.0)
                    animatenpc(arg0, 449.0, 464.0, (arg0\Field24 * 6.0), $01)
                    If ((((452.0 > local1) And (452.0 <= arg0\Field14)) Lor ((459.0 > local1) And (459.0 <= arg0\Field14))) <> 0) Then
                        playsoundex(stepsfx($01, $01, rand($00, $07)), camera, arg0\Field3, 12.0, 1.0, $00, $00)
                    EndIf
                    If (((1.0 > distancesquared(arg0\Field36, entityx(arg0\Field3, $00), arg0\Field38, entityz(arg0\Field3, $00), 0.0, 0.0)) And entityvisible(me\Field60, arg0\Field3)) <> 0) Then
                        setnpcframe(arg0, 18.0, $01)
                    EndIf
                Else
                    arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                    animatenpc(arg0, 175.0, 297.0, (arg0\Field24 * 5.0), $01)
                EndIf
                rotateentity(arg0\Field3, 0.0, curveangle(vectoryaw((arg0\Field36 - entityx(arg0\Field3, $00)), 0.0, (arg0\Field38 - entityz(arg0\Field3, $00))), entityyaw(arg0\Field3, $00), (10.0 - (Float selecteddifficulty\Field4))), 0.0, $00)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                arg0\Field29 = (Int ((Float arg0\Field29) - fps\Field7[$00]))
            Else
                arg0\Field10 = 2.0
            EndIf
        Case 5.0
            If (68.0 > arg0\Field14) Then
                animatenpc(arg0, 18.0, 68.0, 0.5, $00)
            Else
                animatenpc(arg0, 464.0, 473.0, 0.5, $00)
            EndIf
    End Select
    If ((((49.0 > entitydistancesquared(arg0\Field3, me\Field60)) And entityinview(arg0\Field3, camera)) And entityvisible(me\Field60, arg0\Field3)) <> 0) Then
        giveachievement("939", $01)
    EndIf
    If (((3.0 > arg0\Field10) And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
        local0 = (entitydistancesquared(arg0\Field3, me\Field60) + ((Float (entityvisible(me\Field60, arg0\Field3) = $00)) * 2.5))
        If (((local0 < ((me\Field42 * 1.6) * (me\Field42 * 1.6))) Lor (2.5 > local0)) <> 0) Then
            If (0.0 = arg0\Field12) Then
                If (((arg0\Field18 = $00) Lor (channelplaying(arg0\Field18) = $00)) <> 0) Then
                    mp_loadnpcsound(arg0, (((("SFX\SCP\939\" + (Str (arg0\Field5 Mod $03))) + "Attack") + (Str rand($00, $02))) + ".ogg"), $00)
                    arg0\Field18 = playsoundex(arg0\Field17, camera, arg0\Field3, 10.0, 1.0, $01, $00)
                    If (arg0\Field85 <> 0) Then
                        playsound_strict(loadtempsound("SFX\SCP\939\Horror.ogg"), $00, $01)
                    EndIf
                EndIf
                giveachievement("939", $01)
                arg0\Field12 = 1.0
            EndIf
            arg0\Field10 = 3.0
        ElseIf (local0 < ((me\Field42 * 1.9) * (me\Field42 * 1.9))) Then
            If (((1.0 <> arg0\Field10) And (0.0 >= arg0\Field28)) <> 0) Then
                If (((arg0\Field18 = $00) Lor (channelplaying(arg0\Field18) = $00)) <> 0) Then
                    mp_loadnpcsound(arg0, (((("SFX\SCP\939\" + (Str (arg0\Field5 Mod $03))) + "Alert") + (Str rand($00, $02))) + ".ogg"), $00)
                    arg0\Field18 = playsoundex(arg0\Field17, camera, arg0\Field3, 10.0, 1.0, $01, $00)
                EndIf
                giveachievement("939", $01)
                setnpcframe(arg0, 175.0, $01)
                arg0\Field28 = 210.0
            EndIf
            arg0\Field10 = 1.0
        EndIf
        arg0\Field28 = (arg0\Field28 - fps\Field7[$00])
    EndIf
    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $01)
    positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.28), entityz(arg0\Field3, $00), $00)
    rotateentity(arg0\Field0, (entitypitch(arg0\Field3, $00) - 89.9), entityyaw(arg0\Field3, $00), entityroll(arg0\Field3, $00), $01)
    Return $00
End Function
