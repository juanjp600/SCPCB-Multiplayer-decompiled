Function updatesecuritycams%()
    Local local0.securitycams
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    catcherrors("UpdateSecurityCams()")
    particlecam = camera
    For local0 = Each securitycams
        local1 = ((6.0 > local0\Field16\Field8) Lor (playerroom = local0\Field16))
        If ((local1 Lor (local0 = sc_i\Field4)) <> 0) Then
            If (local0\Field17 <> 0) Then
                If (local0\Field3 = $00) Then
                    local0\Field3 = createpivot(local0\Field0)
                    entityparent(local0\Field3, $00, $01)
                EndIf
                If (entityvisible(local0\Field1, camera) <> 0) Then
                    If (local0 <> sc_i\Field4) Then
                        mtfcameracheckdetected = (0.0 < mtfcamerachecktimer)
                    EndIf
                    pointentity(local0\Field3, camera, 0.0)
                    rotateentity(local0\Field1, curveangle(entitypitch(local0\Field3, $00), entitypitch(local0\Field1, $00), 75.0), curveangle(entityyaw(local0\Field3, $00), entityyaw(local0\Field1, $00), 75.0), 0.0, $00)
                EndIf
                positionentity(local0\Field1, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) - 0.083), entityz(local0\Field0, $01), $00)
            Else
                If (0.0 < local0\Field9) Then
                    If (local0\Field20 = $00) Then
                        local0\Field10 = (local0\Field10 + (fps\Field7[$00] * 0.2))
                        If ((local0\Field9 * 1.3) < local0\Field10) Then
                            local0\Field20 = $01
                        EndIf
                    Else
                        local0\Field10 = (local0\Field10 - (fps\Field7[$00] * 0.2))
                        If (((- local0\Field9) * 1.3) > local0\Field10) Then
                            local0\Field20 = $00
                        EndIf
                    EndIf
                EndIf
                positionentity(local0\Field1, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) - 0.083), entityz(local0\Field0, $01), $00)
                rotateentity(local0\Field1, entitypitch(local0\Field1, $00), (((Float local0\Field16\Field6) + local0\Field8) + clamp(local0\Field10, (- local0\Field9), local0\Field9)), 0.0, $00)
                If (local0\Field6 <> $00) Then
                    positionentity(local0\Field6, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $00)
                    rotateentity(local0\Field6, entitypitch(local0\Field1, $00), entityyaw(local0\Field1, $00), 0.0, $00)
                    moveentity(local0\Field6, 0.0, 0.0, 0.1)
                EndIf
                If (local0 <> sc_i\Field4) Then
                    If (((60.0 > (Abs deltayaw(local0\Field1, camera))) And entityvisible(local0\Field1, camera)) <> 0) Then
                        mtfcameracheckdetected = (0.0 < mtfcamerachecktimer)
                    EndIf
                EndIf
            EndIf
            If ((millisec Mod $546) < $320) Then
                entitytexture(local0\Field1, sc_i\Field1[$00], $00, $00)
            Else
                entitytexture(local0\Field1, sc_i\Field1[$01], $00, $00)
            EndIf
        EndIf
        If (local1 <> 0) Then
            If (local0\Field5 <> 0) Then
                If (-800.0 > me\Field5) Then
                    me\Field6 = $00
                    me\Field5 = -1010.0
                    msg\Field2 = getlocalstring("death", "895")
                    If (-10.0 > me\Field26) Then
                        kill($00, $01, $00, $01)
                    EndIf
                EndIf
                local0\Field14 = $00
                If ((((((fog\Field0 * lightvolume) * 1.2) * ((fog\Field0 * lightvolume) * 1.2)) > entitydistancesquared(me\Field60, local0\Field4)) And (0.3 < secondarylighton)) <> 0) Then
                    local0\Field14 = (entityinview(local0\Field2, camera) And entityvisible(camera, local0\Field4))
                    If ((((-6.0 < me\Field10) Lor (-11.0 > me\Field10)) And local0\Field14) <> 0) Then
                        particlecam = local0\Field6
                        local2 = $00
                        local3 = local0\Field16\Field7\Field6
                        If ((((local3 = $05) Lor (local3 = $04)) Lor (local3 = $12)) <> 0) Then
                            local0\Field18 = $00
                            local2 = $01
                        Else
                            camerafogcolor(local0\Field6, fog\Field3, fog\Field4, fog\Field5)
                            cameraclscolor(local0\Field6, fog\Field3, fog\Field4, fog\Field5)
                        EndIf
                        If (local0\Field15 > local0\Field11) Then
                            local0\Field11 = (local0\Field11 + fps\Field7[$00])
                        Else
                            If ((((sc_i\Field4 = Null) Lor (rand($05, $01) = $05)) Lor (local0\Field18 <> $03)) <> 0) Then
                                updatelights(local0\Field6)
                            Else
                                updatelights(sc_i\Field4\Field6)
                            EndIf
                            local0\Field11 = 0.0
                        EndIf
                        If (((local0\Field18 = $01) Lor (local0\Field18 = $03)) <> 0) Then
                            If (((((i_714\Field0 <> $02) And (wi\Field2 <> $04)) And (wi\Field0 <> $04)) And (chs\Field2 = $00)) <> 0) Then
                                me\Field5 = (me\Field5 - ((fps\Field7[$00] * (((Float selecteddifficulty\Field4) * 0.2) + 1.0)) / ((Float i_714\Field0) + 1.0)))
                                me\Field6 = $00
                                If (selecteddifficulty\Field3 = $01) Then
                                    cansave = $00
                                EndIf
                                local4 = createpivot($00)
                                local5 = clamp((15000.0 / (- me\Field5)), 20.0, 200.0)
                                positionentity(local4, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local4, local0\Field4, 0.0)
                                rotateentity(me\Field60, entitypitch(me\Field60, $00), curveangle(entityyaw(local4, $00), entityyaw(me\Field60, $00), local5), 0.0, $00)
                                turnentity(local4, 90.0, 0.0, 0.0, $00)
                                camerapitch = curveangle(entitypitch(local4, $00), (camerapitch + 90.0), local5)
                                camerapitch = (camerapitch - 90.0)
                                freeentity(local4)
                                local4 = $00
                                If (-800.0 > me\Field5) Then
                                    If (rand($03, $01) = $01) Then
                                        entitytexture(local0\Field7, mon_i\Field1[$00], $00, $00)
                                    EndIf
                                    If (rand($06, $01) < $05) Then
                                        entitytexture(local0\Field7, mon_i\Field1[rand($0C, $10)], $00, $00)
                                        If (local0\Field12 = $01) Then
                                            playsound_strict(snd_i\Field47[$01], $00, $01)
                                        EndIf
                                        local0\Field12 = $02
                                        If (channelplaying(local0\Field13) = $00) Then
                                            local0\Field13 = playsound_strict(snd_i\Field47[$04], $00, $01)
                                        EndIf
                                        If (((local0\Field18 = $03) And (rand($C8, $01) = $01)) <> 0) Then
                                            local0\Field18 = $02
                                            local0\Field12 = rand($2710, $4E20)
                                        EndIf
                                    EndIf
                                    me\Field49 = 1000.0
                                    If (0.0 = me\Field26) Then
                                        me\Field26 = 1.0
                                    EndIf
                                ElseIf (-500.0 > me\Field5) Then
                                    If (rand($07, $01) = $01) Then
                                        entitytexture(local0\Field7, mon_i\Field1[$00], $00, $00)
                                    EndIf
                                    If (rand($32, $01) = $01) Then
                                        entitytexture(local0\Field7, mon_i\Field1[rand($0C, $10)], $00, $00)
                                        If (local0\Field12 = $00) Then
                                            playsound_strict(snd_i\Field47[$00], $00, $01)
                                        EndIf
                                        local0\Field12 = (Int max((Float local0\Field12), 1.0))
                                        If (((local0\Field18 = $03) And (rand($64, $01) = $01)) <> 0) Then
                                            local0\Field18 = $02
                                            local0\Field12 = rand($2710, $4E20)
                                        EndIf
                                    EndIf
                                Else
                                    entitytexture(local0\Field7, mon_i\Field1[$00], $00, $00)
                                EndIf
                            Else
                                entitytexture(local0\Field7, mon_i\Field1[$00], $00, $00)
                            EndIf
                        ElseIf (local2 = $00) Then
                            If (local0\Field12 = $00) Then
                                local0\Field12 = (rand($D6D8, $EA60) - (selecteddifficulty\Field2 * $4E20))
                            EndIf
                            If (rand($1F4, $01) = $01) Then
                                entitytexture(local0\Field7, mon_i\Field1[rand($06, $0B)], $00, $00)
                            EndIf
                            If ((millisec Mod local0\Field12) >= rand($2BC, $01)) Then
                                entitytexture(local0\Field7, mon_i\Field1[$00], $00, $00)
                            Else
                                If (channelplaying(local0\Field13) = $00) Then
                                    local0\Field13 = playsound_strict(loadtempsound((("SFX\SCP\079\Broadcast" + (Str rand($00, $02))) + ".ogg")), $00, $01)
                                    If (local0\Field18 = $02) Then
                                        local0\Field18 = $03
                                        local0\Field12 = $00
                                    EndIf
                                EndIf
                                entitytexture(local0\Field7, mon_i\Field1[rand($06, $0B)], $00, $00)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (((local0\Field14 = $00) And (local0\Field22 = $00)) <> 0) Then
                local0\Field13 = loopsoundex(snd_i\Field11, local0\Field13, camera, local0\Field1, 4.0, 1.0, $00)
            EndIf
        EndIf
        If (local0 <> Null) Then
            catcherrors((("Uncaught: UpdateSecurityCameras(Room ID: " + (Str local3)) + ")"))
        Else
            catcherrors("Uncaught: UpdateSecurityCameras(Screen doesn't exist anymore!)")
        EndIf
    Next
    Return $00
End Function
