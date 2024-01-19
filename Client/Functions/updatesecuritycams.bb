Function updatesecuritycams%(arg0%)
    Local local0.securitycams
    Local local1%
    Local local2#
    Local local3%
    restoresanity = $01
    If (((0.0 < fpsfactor) And (playerroom\Field7\Field11 <> "dimension1499")) = $00) Then
        Return $00
    EndIf
    local1 = $00
    For local0 = Each securitycams
        local1 = $00
        If (local0\Field20 = Null) Then
            hideentity(local0\Field8)
        Else
            If (local0\Field20\Field69 <> 0) Then
                local1 = $01
            ElseIf (local0\Field8 <> $00) Then
                hideentity(local0\Field8)
            EndIf
            If (local0\Field20 <> Null) Then
                If (local0\Field20\Field7\Field11 = "room2sl") Then
                    local0\Field22 = $00
                EndIf
            EndIf
            If ((local1 Or (local0 = coffincam)) <> 0) Then
                If (local0\Field21 <> 0) Then
                    If (local0 <> coffincam) Then
                        If (entityvisible(local0\Field3, camera) <> 0) Then
                            If (0.0 < mtf_camerachecktimer) Then
                                mtf_cameracheckdetected = $01
                            EndIf
                        EndIf
                    EndIf
                    pointentity(local0\Field3, camera, 0.0)
                    local2 = entitypitch(local0\Field3, $00)
                    rotateentity(local0\Field0, 0.0, curveangle(entityyaw(local0\Field3, $00), entityyaw(local0\Field0, $00), 75.0), 0.0, $00)
                    If (40.0 > local2) Then
                        local2 = 40.0
                    EndIf
                    If (70.0 < local2) Then
                        local2 = 70.0
                    EndIf
                    rotateentity(local0\Field3, curveangle(local2, entitypitch(local0\Field3, $00), 75.0), entityyaw(local0\Field0, $00), 0.0, $00)
                    positionentity(local0\Field3, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) - 0.083), entityz(local0\Field0, $01), $00)
                    rotateentity(local0\Field3, entitypitch(local0\Field3, $00), entityyaw(local0\Field0, $00), 0.0, $00)
                Else
                    If (0.0 < local0\Field12) Then
                        If (local0\Field26 = $00) Then
                            local0\Field13 = (local0\Field13 + (0.2 * fpsfactor))
                            If ((local0\Field12 * 1.3) < local0\Field13) Then
                                local0\Field26 = $01
                            EndIf
                        Else
                            local0\Field13 = (local0\Field13 - (0.2 * fpsfactor))
                            If (((- local0\Field12) * 1.3) > local0\Field13) Then
                                local0\Field26 = $00
                            EndIf
                        EndIf
                    EndIf
                    rotateentity(local0\Field0, 0.0, (((Float local0\Field20\Field6) + local0\Field11) + max(min(local0\Field13, local0\Field12), (- local0\Field12))), 0.0, $00)
                    positionentity(local0\Field3, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) - 0.083), entityz(local0\Field0, $01), $00)
                    rotateentity(local0\Field3, entitypitch(local0\Field3, $00), entityyaw(local0\Field0, $00), 0.0, $00)
                    If (local0\Field8 <> $00) Then
                        positionentity(local0\Field8, entityx(local0\Field3, $01), entityy(local0\Field3, $01), entityz(local0\Field3, $01), $00)
                        rotateentity(local0\Field8, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), 0.0, $00)
                        moveentity(local0\Field8, 0.0, 0.0, 0.1)
                    EndIf
                    If (local0 <> coffincam) Then
                        If (60.0 > (Abs deltayaw(local0\Field3, camera))) Then
                            If (entityvisible(local0\Field3, camera) <> 0) Then
                                If (0.0 < mtf_camerachecktimer) Then
                                    mtf_cameracheckdetected = $01
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (local1 = $01) Then
                If (local0\Field7 <> 0) Then
                    If (-5.0 < blinktimer) Then
                        If (entityinview(local0\Field4, camera) <> 0) Then
                            local0\Field17 = entityvisible(camera, local0\Field4)
                            local0\Field18 = local0\Field17
                        Else
                            local0\Field17 = $00
                            local0\Field18 = $00
                        EndIf
                    Else
                        local0\Field17 = $00
                        local0\Field18 = $00
                    EndIf
                    local0\Field14 = (local0\Field14 + fpsfactor)
                    If (local0\Field17 <> 0) Then
                        If ((((((local0\Field22 = $01) Or (local0\Field22 = $03)) And (wearing714 = $00)) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                            sanity = (sanity - fpsfactor)
                            debuglog((Str sanity))
                            restoresanity = $00
                        EndIf
                    EndIf
                    If (-1000.0 > sanity) Then
                        deathmsg = (chr($22) + "What we know is that he died of cardiac arrest. My guess is that it was caused by SCP-895, although it has never been observed affecting video equipment from this far before. ")
                        deathmsg = ((((((deathmsg + "Further testing is needed to determine whether SCP-895's ") + chr($22)) + "Red Zone") + chr($22)) + " is increasing.") + chr($22))
                        If (-10.0 > vomittimer) Then
                            kill("was killed", $00)
                        EndIf
                    EndIf
                    If (((0.0 > vomittimer) And (-800.0 > sanity)) <> 0) Then
                        restoresanity = $00
                        sanity = -1010.0
                    EndIf
                    If (arg0 = $00) Then
                        If (local0\Field19 <= local0\Field14) Then
                            If (local0\Field18 <> 0) Then
                                If ((((coffincam = Null) Or (rand($05, $01) = $05)) Or (local0\Field22 <> $03)) <> 0) Then
                                    hideentity(camera)
                                    showentity(local0\Field8)
                                    cls()
                                    removecameralights()
                                    setbuffer(backbuffer())
                                    renderworld(1.0)
                                    copyrect($00, $00, getcameraquality(camquality), getcameraquality(camquality), $00, $00, backbuffer(), texturebuffer(screentexs[local0\Field9], $00))
                                    hideentity(local0\Field8)
                                    showentity(camera)
                                Else
                                    hideentity(camera)
                                    showentity(coffincam\Field20\Field2)
                                    entityalpha(getchild(coffincam\Field20\Field2, $02), 1.0)
                                    showentity(coffincam\Field8)
                                    cls()
                                    removecameralights()
                                    setbuffer(backbuffer())
                                    renderworld(1.0)
                                    copyrect($00, $00, getcameraquality(camquality), getcameraquality(camquality), $00, $00, backbuffer(), texturebuffer(screentexs[local0\Field9], $00))
                                    hideentity(coffincam\Field20\Field2)
                                    hideentity(coffincam\Field8)
                                    showentity(camera)
                                EndIf
                            EndIf
                            local0\Field14 = 0.0
                        EndIf
                    EndIf
                    If ((((((local0\Field22 = $01) Or (local0\Field22 = $03)) And (wearing714 = $00)) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                        If (local0\Field17 <> 0) Then
                            local3 = createpivot($00)
                            positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                            pointentity(local3, local0\Field4, 0.0)
                            rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local3, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 20.0), 200.0)), 0.0, $00)
                            turnentity(local3, 90.0, 0.0, 0.0, $00)
                            user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 20.0), 200.0))
                            user_camera_pitch = (user_camera_pitch - 90.0)
                            freeentity(local3)
                            If ((((local0\Field22 = $01) Or (local0\Field22 = $03)) And (wearing714 = $00)) <> 0) Then
                                If (-800.0 > sanity) Then
                                    If (rand($03, $01) = $01) Then
                                        entitytexture(local0\Field10, monitortexture, $00, $00)
                                    EndIf
                                    If (rand($06, $01) < $05) Then
                                        entitytexture(local0\Field10, gorepics(rand($00, $05)), $00, $00)
                                        If (local0\Field15 = $01) Then
                                            playsound_strict(horrorsfx($01))
                                        EndIf
                                        local0\Field15 = $02
                                        If (local0\Field16 = $00) Then
                                            local0\Field16 = playsound_strict(horrorsfx($04))
                                        ElseIf (channelplaying(local0\Field16) = $00) Then
                                            local0\Field16 = playsound_strict(horrorsfx($04))
                                        EndIf
                                        If (((local0\Field22 = $03) And (rand($C8, $01) = $01)) <> 0) Then
                                            local0\Field22 = $02
                                            local0\Field15 = rand($2710, $4E20)
                                        EndIf
                                    EndIf
                                    blurtimer = 1000.0
                                    If (0.0 = vomittimer) Then
                                        vomittimer = 1.0
                                    EndIf
                                ElseIf (-500.0 > sanity) Then
                                    If (rand($07, $01) = $01) Then
                                        entitytexture(local0\Field10, monitortexture, $00, $00)
                                    EndIf
                                    If (rand($32, $01) = $01) Then
                                        entitytexture(local0\Field10, gorepics(rand($00, $05)), $00, $00)
                                        If (local0\Field15 = $00) Then
                                            playsound_strict(horrorsfx($00))
                                        EndIf
                                        local0\Field15 = (Int max((Float local0\Field15), 1.0))
                                        If (((local0\Field22 = $03) And (rand($64, $01) = $01)) <> 0) Then
                                            local0\Field22 = $02
                                            local0\Field15 = rand($2710, $4E20)
                                        EndIf
                                    EndIf
                                Else
                                    entitytexture(local0\Field10, monitortexture, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (local0\Field17 <> 0) Then
                        If (((wearing714 Or (wearinghazmat = $03)) Or (wearinggasmask = $03)) <> 0) Then
                            entitytexture(local0\Field10, monitortexture, $00, $00)
                        EndIf
                    EndIf
                    If (((local0\Field17 And (local0\Field22 = $00)) Or (local0\Field22 = $02)) <> 0) Then
                        If (local0\Field15 = $00) Then
                            local0\Field15 = rand($EA60, $FDE8)
                        EndIf
                        If (rand($1F4, $01) = $01) Then
                            entitytexture(local0\Field10, oldaipics($00), $00, $00)
                        EndIf
                        If ((millisecs2() Mod local0\Field15) >= rand($258, $01)) Then
                            entitytexture(local0\Field10, monitortexture, $00, $00)
                        Else
                            If (local0\Field16 = $00) Then
                                local0\Field16 = playsound_strict(loadtempsound((("SFX\SCP\079\Broadcast" + (Str rand($01, $03))) + ".ogg")))
                                If (local0\Field22 = $02) Then
                                    local0\Field22 = $03
                                    local0\Field15 = $00
                                EndIf
                            ElseIf (channelplaying(local0\Field16) = $00) Then
                                local0\Field16 = playsound_strict(loadtempsound((("SFX\SCP\079\Broadcast" + (Str rand($01, $03))) + ".ogg")))
                                If (local0\Field22 = $02) Then
                                    local0\Field22 = $03
                                    local0\Field15 = $00
                                EndIf
                            EndIf
                            entitytexture(local0\Field10, oldaipics($00), $00, $00)
                        EndIf
                    EndIf
                EndIf
                If (local0\Field17 = $00) Then
                    local0\Field16 = loopsound2(camerasfx, local0\Field16, camera, local0\Field3, 4.0, 1.0)
                EndIf
            EndIf
            If (local0 <> Null) Then
                If (local0\Field20 <> Null) Then
                EndIf
            EndIf
        EndIf
    Next
    cls()
    Return $00
End Function
