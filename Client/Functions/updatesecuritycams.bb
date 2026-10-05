Function updatesecuritycams%(arg0%)
    Local local0%
    Local local1.securitycams
    Local local2%
    Local local3#
    Local local4%
    restoresanity = $01
    local0 = (Int playerroom\Field8\Field11)
    If (((((0.0 < fpsfactor) And ((Str local0) <> "dimension1499")) And ((Str local0) <> "gatea")) And ((Str local0) <> "exit1")) = $00) Then
        Return $00
    EndIf
    For local1 = Each securitycams
        local2 = $00
        If (local1\Field20 = Null) Then
            hideentity(local1\Field8)
        Else
            If (local1\Field20\Field69 = $00) Then
                If (local1\Field8 <> $00) Then
                    hideentity(local1\Field8)
                EndIf
            Else
                local2 = $01
                If (local1\Field20\Field8\Field11 = "room2sl") Then
                    local1\Field22 = $00
                EndIf
            EndIf
            If ((local2 Or (local1 = coffincam)) <> 0) Then
                If (local1\Field21 <> 0) Then
                    If (local1 <> coffincam) Then
                        If (entityvisible(local1\Field3, camera) <> 0) Then
                            If (0.0 < mtf_camerachecktimer) Then
                                mtf_cameracheckdetected = $01
                            EndIf
                        EndIf
                    EndIf
                    pointentity(local1\Field3, camera, 0.0)
                    local3 = entitypitch(local1\Field3, $00)
                    rotateentity(local1\Field0, 0.0, curveangle(entityyaw(local1\Field3, $00), entityyaw(local1\Field0, $00), 75.0), 0.0, $00)
                    If (40.0 > local3) Then
                        local3 = 40.0
                    EndIf
                    If (70.0 < local3) Then
                        local3 = 70.0
                    EndIf
                    rotateentity(local1\Field3, curveangle(local3, entitypitch(local1\Field3, $00), 75.0), entityyaw(local1\Field0, $00), 0.0, $00)
                    positionentity(local1\Field3, entityx(local1\Field0, $01), (entityy(local1\Field0, $01) - 0.083), entityz(local1\Field0, $01), $00)
                    rotateentity(local1\Field3, entitypitch(local1\Field3, $00), entityyaw(local1\Field0, $00), 0.0, $00)
                Else
                    If (0.0 < local1\Field12) Then
                        If (local1\Field26 = $00) Then
                            local1\Field13 = (local1\Field13 + (0.2 * fpsfactor))
                            If ((local1\Field12 * 1.3) < local1\Field13) Then
                                local1\Field26 = $01
                            EndIf
                        Else
                            local1\Field13 = (local1\Field13 - (0.2 * fpsfactor))
                            If (((- local1\Field12) * 1.3) > local1\Field13) Then
                                local1\Field26 = $00
                            EndIf
                        EndIf
                    EndIf
                    rotateentity(local1\Field0, 0.0, (((Float local1\Field20\Field7) + local1\Field11) + max(min(local1\Field13, local1\Field12), (- local1\Field12))), 0.0, $00)
                    positionentity(local1\Field3, entityx(local1\Field0, $01), (entityy(local1\Field0, $01) - 0.083), entityz(local1\Field0, $01), $00)
                    rotateentity(local1\Field3, entitypitch(local1\Field3, $00), entityyaw(local1\Field0, $00), 0.0, $00)
                    If (local1\Field8 <> $00) Then
                        positionentity(local1\Field8, entityx(local1\Field3, $01), entityy(local1\Field3, $01), entityz(local1\Field3, $01), $00)
                        rotateentity(local1\Field8, entitypitch(local1\Field3, $00), entityyaw(local1\Field3, $00), 0.0, $00)
                        moveentity(local1\Field8, 0.0, 0.0, 0.1)
                    EndIf
                    If (local1 <> coffincam) Then
                        If (60.0 > (Abs deltayaw(local1\Field3, camera))) Then
                            If (entityvisible(local1\Field3, camera) <> 0) Then
                                If (0.0 < mtf_camerachecktimer) Then
                                    mtf_cameracheckdetected = $01
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (local2 = $01) Then
                If (local1\Field7 <> 0) Then
                    If (-5.0 < blinktimer) Then
                        If (entityinview(local1\Field4, camera) <> 0) Then
                            local1\Field17 = entityvisible(camera, local1\Field4)
                            local1\Field18 = (local1\Field17 And (3.0 > entitydistance(camera, local1\Field4)))
                        Else
                            local1\Field17 = $00
                            local1\Field18 = $00
                        EndIf
                    Else
                        local1\Field17 = $00
                        local1\Field18 = $00
                    EndIf
                    local1\Field14 = (local1\Field14 + fpsfactor)
                    If (local1\Field17 <> 0) Then
                        If ((((((local1\Field22 = $01) Or (local1\Field22 = $03)) And (wearing714 = $00)) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                            sanity = (sanity - fpsfactor)
                            restoresanity = $00
                        EndIf
                    EndIf
                    If (-1000.0 > sanity) Then
                        If (-10.0 > vomittimer) Then
                            deathmsg = (chr($22) + "What we know is that he died of cardiac arrest. My guess is that it was caused by SCP-895, although it has never been observed affecting video equipment from this far before. ")
                            deathmsg = ((((((deathmsg + "Further testing is needed to determine whether SCP-895's ") + chr($22)) + "Red Zone") + chr($22)) + " is increasing.") + chr($22))
                            kill("was killed", $00)
                        EndIf
                    EndIf
                    If (((0.0 > vomittimer) And (-800.0 > sanity)) <> 0) Then
                        restoresanity = $00
                        sanity = -1010.0
                    EndIf
                    If (arg0 = $00) Then
                        If (local1\Field19 <= local1\Field14) Then
                            If (local1\Field18 <> 0) Then
                                If ((((coffincam = Null) Or (rand($05, $01) = $05)) Or (local1\Field22 <> $03)) <> 0) Then
                                    hideentity(camera)
                                    showentity(local1\Field8)
                                    removecameralights()
                                    setbuffer(backbuffer())
                                    renderworld(1.0)
                                    copyrect($00, $00, getcameraquality(camquality), getcameraquality(camquality), $00, $00, backbuffer(), texturebuffer(screentexs[local1\Field9], $00))
                                    hideentity(local1\Field8)
                                    showentity(camera)
                                Else
                                    hideentity(camera)
                                    showentity(coffincam\Field20\Field3)
                                    entityalpha(getchild(coffincam\Field20\Field3, $02), 1.0)
                                    showentity(coffincam\Field8)
                                    removecameralights()
                                    setbuffer(backbuffer())
                                    renderworld(1.0)
                                    copyrect($00, $00, getcameraquality(camquality), getcameraquality(camquality), $00, $00, backbuffer(), texturebuffer(screentexs[local1\Field9], $00))
                                    hideentity(coffincam\Field20\Field3)
                                    hideentity(coffincam\Field8)
                                    showentity(camera)
                                EndIf
                            EndIf
                            local1\Field14 = 0.0
                        EndIf
                    EndIf
                    If ((((((local1\Field22 = $01) Or (local1\Field22 = $03)) And (wearing714 = $00)) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                        If (local1\Field17 <> 0) Then
                            local4 = createpivot($00)
                            positionentity(local4, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                            pointentity(local4, local1\Field4, 0.0)
                            rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local4, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 20.0), 200.0)), 0.0, $00)
                            turnentity(local4, 90.0, 0.0, 0.0, $00)
                            user_camera_pitch = curveangle(entitypitch(local4, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 20.0), 200.0))
                            user_camera_pitch = (user_camera_pitch - 90.0)
                            freeentity(local4)
                            If ((((local1\Field22 = $01) Or (local1\Field22 = $03)) And (wearing714 = $00)) <> 0) Then
                                If (-800.0 > sanity) Then
                                    If (rand($03, $01) = $01) Then
                                        entitytexture(local1\Field10, monitortexture, $00, $00)
                                    EndIf
                                    If (rand($06, $01) < $05) Then
                                        entitytexture(local1\Field10, gorepics(rand($00, $05)), $00, $00)
                                        If (local1\Field15 = $01) Then
                                            playsound_strict(horrorsfx($01))
                                        EndIf
                                        local1\Field15 = $02
                                        If (local1\Field16 = $00) Then
                                            local1\Field16 = playsound_strict(horrorsfx($04))
                                        ElseIf (channelplaying(local1\Field16) = $00) Then
                                            local1\Field16 = playsound_strict(horrorsfx($04))
                                        EndIf
                                        If (((local1\Field22 = $03) And (rand($C8, $01) = $01)) <> 0) Then
                                            local1\Field22 = $02
                                            local1\Field15 = rand($2710, $4E20)
                                        EndIf
                                    EndIf
                                    blurtimer = 1000.0
                                    If (0.0 = vomittimer) Then
                                        vomittimer = 1.0
                                    EndIf
                                ElseIf (-500.0 > sanity) Then
                                    If (rand($07, $01) = $01) Then
                                        entitytexture(local1\Field10, monitortexture, $00, $00)
                                    EndIf
                                    If (rand($32, $01) = $01) Then
                                        entitytexture(local1\Field10, gorepics(rand($00, $05)), $00, $00)
                                        If (local1\Field15 = $00) Then
                                            playsound_strict(horrorsfx($00))
                                        EndIf
                                        local1\Field15 = (Int max((Float local1\Field15), 1.0))
                                        If (((local1\Field22 = $03) And (rand($64, $01) = $01)) <> 0) Then
                                            local1\Field22 = $02
                                            local1\Field15 = rand($2710, $4E20)
                                        EndIf
                                    EndIf
                                Else
                                    entitytexture(local1\Field10, monitortexture, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (local1\Field17 <> 0) Then
                        If (((wearing714 Or (wearinghazmat = $03)) Or (wearinggasmask = $03)) <> 0) Then
                            entitytexture(local1\Field10, monitortexture, $00, $00)
                        EndIf
                    EndIf
                    If (((local1\Field17 And (local1\Field22 = $00)) Or (local1\Field22 = $02)) <> 0) Then
                        If (local1\Field15 = $00) Then
                            local1\Field15 = rand($EA60, $FDE8)
                        EndIf
                        If (rand($1F4, $01) = $01) Then
                            entitytexture(local1\Field10, oldaipics($00), $00, $00)
                        EndIf
                        If ((millisecs() Mod local1\Field15) >= rand($258, $01)) Then
                            entitytexture(local1\Field10, monitortexture, $00, $00)
                        Else
                            If (local1\Field16 = $00) Then
                                local1\Field16 = playsound_strict(loadtempsound((("SFX\SCP\079\Broadcast" + (Str rand($01, $03))) + ".ogg")))
                                If (local1\Field22 = $02) Then
                                    local1\Field22 = $03
                                    local1\Field15 = $00
                                EndIf
                            ElseIf (channelplaying(local1\Field16) = $00) Then
                                local1\Field16 = playsound_strict(loadtempsound((("SFX\SCP\079\Broadcast" + (Str rand($01, $03))) + ".ogg")))
                                If (local1\Field22 = $02) Then
                                    local1\Field22 = $03
                                    local1\Field15 = $00
                                EndIf
                            EndIf
                            entitytexture(local1\Field10, oldaipics($00), $00, $00)
                        EndIf
                    EndIf
                EndIf
                If (local1\Field17 = $00) Then
                    local1\Field16 = loopsound2(camerasfx, local1\Field16, camera, local1\Field3, 4.0, 1.0)
                EndIf
            EndIf
            If (local1 <> Null) Then
                If (local1\Field20 <> Null) Then
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
