Function updatebreachevents%()
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    Local local7.particles
    Local local8%
    Local local9%
    Local local10.events
    Local local11.events
    Local local12.items
    Local local13%
    Local local14%
    Local local15.securitycams
    Local local16%
    Local local17$
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local24#
    Local local25#
    Local local26#
    Local local27#
    Local local29%
    Local local30.decals
    Local local31%[7]
    Local local32$
    Local local33%
    Local local34%
    Local local35%
    Local local36%
    Local local37.doors
    Local local38%
    Local local39%
    Local local40%
    Local local41%
    Local local42%
    Local local43%
    Local local44%
    Local local45%
    Local local46%
    Local local48%
    Local local49%
    Local local50%
    Local local51%
    Local local52%
    Local local53%
    Local local56.waypoints
    Local local59%
    Local local60%
    Local local61.forest
    Local local62#
    Local local63%
    Local local65%
    Local local66%
    Local local67%
    Local local68%
    Local local69%
    Local local70.dummy1499
    Local local71%
    Local local72#
    Local local73#
    Local local74#
    Local local75$
    Local local78%
    Local local79#
    Local local80#
    Local local81#
    Local local82#
    Local local83#
    Local local84#
    Local local85%
    Local local86%
    Local local87%
    Local local88%
    Local local89#
    Local local90%
    Local local91#
    Local local92#
    Local local93#
    Local local94#
    Local local95%
    Local local96%
    Local local97%
    Local local98%
    Local local99$
    Local local101%
    Local local102%
    Local local103.itemtemplates
    local17 = ""
    local18 = entityx(camera, $01)
    local19 = entityx(camera, $01)
    local20 = entityx(camera, $01)
    currstepsfx = $00
    myplayer\Field44 = playerroom\Field8\Field11
    myplayer\Field45 = playerroom\Field65
    For local10 = Each events
        If (local10\Field22 <> $4A) Then
            local10\Field13 = findeventobject(local10)
            local10\Field20 = calculatedist(local10\Field13, local10\Field1)
            local25 = entityx(local10\Field13, $01)
            local26 = entityy(local10\Field13, $01)
            local27 = entityz(local10\Field13, $01)
        EndIf
        Select local10\Field22
            Case $28
                If (playerinroom(local10) <> 0) Then
                    If (player[local10\Field14]\Field31 = $00) Then
                        If (0.0 = local10\Field2) Then
                            If (((6.25 > entitydistancesquared(local10\Field13, local10\Field1\Field29[$00]\Field0)) And remotedooron) <> 0) Then
                                giveachievement($01, $01)
                                playsound_strict(horrorsfx($07))
                                playsound2(leversfx, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                                local10\Field2 = 1.0
                                local10\Field1\Field29[$00]\Field4 = $00
                                usedoor(local10\Field1\Field29[$00], $00, $01, $00, "", $00)
                                local10\Field1\Field29[$00]\Field4 = $01
                            EndIf
                        Else
                            local10\Field13 = collider
                            local10\Field20 = calculatedist(local10\Field13, local10\Field1)
                            If (local10\Field7 = $00) Then
                                loadeventsound(local10, "SFX\Music\012Golgotha.ogg", $00)
                            EndIf
                            local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field25[$03], 5.0, 1.0)
                            If (local10\Field8 = $00) Then
                                loadeventsound(local10, "SFX\Music\012.ogg", $01)
                            EndIf
                            If (90.0 > local10\Field2) Then
                                local10\Field2 = curvevalue(90.0, local10\Field2, 500.0)
                            EndIf
                            positionentity(local10\Field1\Field25[$02], entityx(local10\Field1\Field25[$02], $01), ((-130.0 - (sin(local10\Field2) * 448.0)) * (1.0 / 256.0)), entityz(local10\Field1\Field25[$02], $01), $01)
                            If (((0.0 < local10\Field3) And (200.0 > local10\Field3)) <> 0) Then
                                local10\Field3 = (local10\Field3 + fpsfactor)
                                rotateentity(local10\Field1\Field25[$01], curvevalue(85.0, entitypitch(local10\Field1\Field25[$01], $00), 5.0), entityyaw(local10\Field1\Field25[$01], $00), 0.0, $00)
                            Else
                                local10\Field3 = (local10\Field3 + fpsfactor)
                                If (250.0 > local10\Field3) Then
                                    showentity(local10\Field1\Field25[$03])
                                Else
                                    hideentity(local10\Field1\Field25[$03])
                                    If (300.0 < local10\Field3) Then
                                        local10\Field3 = 200.0
                                    EndIf
                                EndIf
                            EndIf
                            If ((((wearing714 = $00) And (wearinggasmask < $03)) And (wearinghazmat < $03)) <> 0) Then
                                local10\Field13 = collider
                                local10\Field20 = calculatedist(local10\Field13, local10\Field1)
                                If (entityvisible(local10\Field1\Field25[$02], camera) <> 0) Then
                                    local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local10\Field1\Field25[$03], 10.0, (local10\Field4 / 6020.0))
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(camera, $00), (entityy(local10\Field1\Field25[$02], $01) - 0.05), entityz(camera, $00), $00)
                                    pointentity(local3, local10\Field1\Field25[$02], 0.0)
                                    rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), (80.0 - (local10\Field4 / 200.0))), 0.0, $00)
                                    turnentity(local3, 90.0, 0.0, 0.0, $00)
                                    user_camera_pitch = curveangle((entitypitch(local3, $00) + 25.0), (user_camera_pitch + 90.0), (80.0 - (local10\Field4 / 200.0)))
                                    user_camera_pitch = (user_camera_pitch - 90.0)
                                    local0 = distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))
                                    heartbeatrate = 150.0
                                    heartbeatvolume = (max((3.0 - local0), 0.0) / 3.0)
                                    blurvolume = max((((2.0 - local0) * (local10\Field4 / 800.0)) * sin((((Float millisecs()) / 20.0) + 1.0))), blurvolume)
                                    currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs()) / 20.0)) + 1.0) * 8.0) * max((3.0 - local0), 0.0)))
                                    If (breathchn <> $00) Then
                                        If (channelplaying(breathchn) <> 0) Then
                                            stopchannel(breathchn)
                                        EndIf
                                    EndIf
                                    If (0.6 > local0) Then
                                        local10\Field4 = min((local10\Field4 + fpsfactor), 6020.0)
                                        If (((70.0 < local10\Field4) And (70.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                            playsound_strict(loadtempsound("SFX\SCP\012\Speech1.ogg"))
                                            multiplayer_writetempsound("SFX\SCP\012\Speech1.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                        ElseIf (((910.0 < local10\Field4) And (910.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                            msg = "You start pushing your nails into your wrist, drawing blood."
                                            msgtimer = 490.0
                                            injuries = (injuries + 0.5)
                                            playsound_strict(loadtempsound("SFX\SCP\012\Speech2.ogg"))
                                            multiplayer_writetempsound("SFX\SCP\012\Speech2.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                        ElseIf (((2170.0 < local10\Field4) And (2170.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                            local29 = loadtexture_strict("GFX\map\scp-012_1.jpg", $01)
                                            entitytexture(local10\Field1\Field25[$04], local29, $00, $01)
                                            freetexture(local29)
                                            msg = "You tear open your left wrist and start writing on the composition with your blood."
                                            msgtimer = 490.0
                                            injuries = max(injuries, 1.5)
                                            playsound_strict(loadtempsound((("SFX\SCP\012\Speech" + (Str rand($03, $04))) + ".ogg")))
                                            multiplayer_writetempsound((("SFX\SCP\012\Speech" + (Str rand($03, $04))) + ".ogg"), 0.0, 0.0, 0.0, 10.0, 1.0)
                                        ElseIf (((3430.0 < local10\Field4) And (3430.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                            msg = "You push your fingers deeper into the wound."
                                            msgtimer = 560.0
                                            injuries = (injuries + 0.3)
                                            playsound_strict(loadtempsound("SFX\SCP\012\Speech5.ogg"))
                                            multiplayer_writetempsound("SFX\SCP\012\Speech5.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                        ElseIf (((4410.0 < local10\Field4) And (4410.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                            local29 = loadtexture_strict("GFX\map\scp-012_2.jpg", $01)
                                            entitytexture(local10\Field1\Field25[$04], local29, $00, $01)
                                            freetexture(local29)
                                            injuries = (injuries + 0.5)
                                            playsound_strict(loadtempsound("SFX\SCP\012\Speech6.ogg"))
                                            multiplayer_writetempsound("SFX\SCP\012\Speech6.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                        ElseIf (((5180.0 < local10\Field4) And (5180.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                            local29 = loadtexture_strict("GFX\map\scp-012_3.jpg", $01)
                                            entitytexture(local10\Field1\Field25[$04], local29, $00, $01)
                                            freetexture(local29)
                                            msg = "You rip the wound wide open. Grabbing scoops of blood pouring out."
                                            msgtimer = 490.0
                                            injuries = (injuries + 0.8)
                                            playsound_strict(loadtempsound("SFX\SCP\012\Speech7.ogg"))
                                            crouch = $01
                                            multiplayer_writetempsound("SFX\SCP\012\Speech7.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                            local30 = createdecal($11, entityx(local10\Field13, $00), -2.99, entityz(local10\Field13, $00), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                                            local30\Field2 = 0.1
                                            local30\Field3 = 0.45
                                            local30\Field1 = 0.0002
                                            updatedecals()
                                            multiplayer_writedecal(local30, $01, $01)
                                        ElseIf (((5950.0 < local10\Field4) And (5950.0 >= (local10\Field4 - fpsfactor))) <> 0) Then
                                            deathmsg = "Subject D-9341 found in a pool of blood next to SCP-012. Subject seems to have ripped open his wrists and written three extra "
                                            deathmsg = (deathmsg + "lines to the composition before dying of blood loss.")
                                            kill("was killed by SCP-012", $00)
                                        EndIf
                                        rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(((sin((local10\Field4 * (local10\Field4 / 2000.0))) * (local10\Field4 / 300.0)) + entityyaw(local10\Field13, $00)), entityyaw(local10\Field13, $00), 80.0), 0.0, $00)
                                    Else
                                        local24 = wrapangle((entityyaw(local3, $00) - entityyaw(local10\Field13, $00)))
                                        If (40.0 > local24) Then
                                            forcemove = ((40.0 - local24) * 0.02)
                                        ElseIf (310.0 < local24) Then
                                            forcemove = ((40.0 - (Abs (360.0 - local24))) * 0.02)
                                        EndIf
                                    EndIf
                                    freeentity(local3)
                                ElseIf (((4.5 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field29[$00]\Field2, $00), entityz(local10\Field1\Field29[$00]\Field2, $00))) And (-2.5 > entityy(local10\Field13, $00))) <> 0) Then
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(camera, $00), entityy(local10\Field13, $00), entityz(camera, $00), $00)
                                    pointentity(local3, local10\Field1\Field29[$00]\Field2, 0.0)
                                    user_camera_pitch = curveangle(90.0, (user_camera_pitch + 90.0), 100.0)
                                    user_camera_pitch = (user_camera_pitch - 90.0)
                                    rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), 150.0), 0.0, $00)
                                    local24 = wrapangle((entityyaw(local3, $00) - entityyaw(local10\Field13, $00)))
                                    If (40.0 > local24) Then
                                        forcemove = ((40.0 - local24) * 0.008)
                                    ElseIf (310.0 < local24) Then
                                        forcemove = ((40.0 - (Abs (360.0 - local24))) * 0.008)
                                    EndIf
                                    freeentity(local3)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $2B
            Case $33
                If (((8.0 <= entityy(collider, $01)) And (12.0 >= entityy(collider, $01))) <> 0) Then
                    If ((((local10\Field1\Field4 - 6.0) <= entityx(collider, $01)) And (((local10\Field1\Field4 + 38.0) + 6.0) >= entityx(collider, $01))) <> 0) Then
                        If ((((local10\Field1\Field6 - 6.0) <= entityz(collider, $01)) And (((local10\Field1\Field6 + 38.0) + 6.0) >= entityz(collider, $01))) <> 0) Then
                            playerroom = local10\Field1
                        EndIf
                    EndIf
                EndIf
                If (((playerinroom(local10) And networkserver\Field15) Or (playerroom = local10\Field1)) <> 0) Then
                    If (i_zone\Field2 <> 0) Then
                        If (local10\Field1\Field33\Field2[$00] = $00) Then
                            placegrid_mapcreator(local10\Field1)
                        EndIf
                    EndIf
                    If (local10\Field1\Field33 = Null) Then
                        local10\Field1\Field33 = (New grids)
                        local44 = rndseed()
                        seedrnd(generateseednumber(randomseed))
                        local45 = (rand($00, $01) Shl $01)
                        local40 = (rand($FFFFFFFE, $02) + $09)
                        local41 = (rand($FFFFFFFE, $02) + $09)
                        local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $01
                        If (local45 = $02) Then
                            local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] = $01
                        Else
                            local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] = $01
                        EndIf
                        local46 = $02
                        While (local46 < $64)
                            local38 = (rand($01, $05) Shl rand($01, $02))
                            For local1 = $01 To local38 Step $01
                                local39 = $01
                                Select local45
                                    Case $00
                                        If (local40 < ($11 - (local1 Mod $02))) Then
                                            local40 = (local40 + $01)
                                        Else
                                            local39 = $00
                                        EndIf
                                    Case $01
                                        If (local41 < ($11 - (local1 Mod $02))) Then
                                            local41 = (local41 + $01)
                                        Else
                                            local39 = $00
                                        EndIf
                                    Case $02
                                        If (local40 > ((local1 Mod $02) + $01)) Then
                                            local40 = (local40 - $01)
                                        Else
                                            local39 = $00
                                        EndIf
                                    Case $03
                                        If (local41 > ((local1 Mod $02) + $01)) Then
                                            local41 = (local41 - $01)
                                        Else
                                            local39 = $00
                                        EndIf
                                End Select
                                If (local39 <> 0) Then
                                    If (local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $00) Then
                                        local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $01
                                        local46 = (local46 + $01)
                                    EndIf
                                Else
                                    Exit
                                EndIf
                            Next
                            local45 = (local45 + ((rand($00, $01) Shl $01) - $01))
                            While (local45 < $00)
                                local45 = (local45 + $04)
                            Wend
                            While (local45 > $03)
                                local45 = (local45 - $04)
                            Wend
                        Wend
                        For local41 = $00 To $12 Step $01
                            For local40 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local41 * $13) + local40)] > $00) Then
                                    local10\Field1\Field33\Field0[((local41 * $13) + local40)] = ((((local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] > $00) + (local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)] > $00)) + (local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] > $00)) + (local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] > $00))
                                EndIf
                            Next
                        Next
                        local48 = $12
                        local49 = $00
                        For local40 = $00 To local48 Step $01
                            For local41 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] > $00) Then
                                    local48 = local40
                                    If (((local10\Field1\Field33\Field0[((local40 + $01) + ((local41 + $01) * $13))] < $03) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $03)) <> 0) Then
                                        local49 = $01
                                        If (rand($00, $01) = $01) Then
                                            local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] = (local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] + $01)
                                            local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $07
                                            local49 = $00
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local49 <> 0) Then
                                local40 = (local40 - $01)
                            EndIf
                        Next
                        local50 = $FFFFFFFF
                        local53 = $FFFFFFFF
                        local50 = $FFFFFFFF
                        local53 = $FFFFFFFF
                        For local41 = $00 To $12 Step $01
                            For local40 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $02) Then
                                    If (((local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] > $00) And (local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] > $00)) <> 0) Then
                                        If (((local50 = $FFFFFFFF) Or (local52 = $FFFFFFFF)) <> 0) Then
                                            If (((((local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] < $03) And (local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] < $03)) And (local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)] < $03)) And (local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] < $03)) <> 0) Then
                                                If (((((local10\Field1\Field33\Field0[((local40 - $01) + ((local41 - $01) * $13))] < $01) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local40 - $01) + ((local41 + $01) * $13))] < $01)) <> 0) Then
                                                    local50 = local40
                                                    local52 = local41
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (((((local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] < $03) And (local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] < $03)) And (local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)] < $03)) And (local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] < $03)) <> 0) Then
                                            If (((((local10\Field1\Field33\Field0[((local40 - $01) + ((local41 - $01) * $13))] < $01) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local40 - $01) + ((local41 + $01) * $13))] < $01)) <> 0) Then
                                                local51 = local40
                                                local53 = local41
                                            EndIf
                                        EndIf
                                    ElseIf (((local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] > $00) And (local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)] > $00)) <> 0) Then
                                        If (((local50 = $FFFFFFFF) Or (local52 = $FFFFFFFF)) <> 0) Then
                                            If (((((local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] < $03) And (local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] < $03)) And (local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)] < $03)) And (local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] < $03)) <> 0) Then
                                                If (((((local10\Field1\Field33\Field0[((local40 - $01) + ((local41 - $01) * $13))] < $01) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local40 - $01) + ((local41 + $01) * $13))] < $01)) <> 0) Then
                                                    local50 = local40
                                                    local52 = local41
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (((((local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] < $03) And (local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] < $03)) And (local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)] < $03)) And (local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] < $03)) <> 0) Then
                                            If (((((local10\Field1\Field33\Field0[((local40 - $01) + ((local41 - $01) * $13))] < $01) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local40 + $01) + ((local41 - $01) * $13))] < $01)) And (local10\Field1\Field33\Field0[((local40 - $01) + ((local41 + $01) * $13))] < $01)) <> 0) Then
                                                local51 = local40
                                                local53 = local41
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        If (((local51 = local50) And (local53 = local52)) <> 0) Then
                            runtimeerror("The maintenance tunnels could not be generated properly!")
                        EndIf
                        For local1 = $00 To $06 Step $01
                            local31[local1] = copyentity(objtunnel(local1), $00)
                            hideentity(local31[local1])
                        Next
                        freetexturecache()
                        local38 = $00
                        For local41 = $00 To $12 Step $01
                            For local40 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local41 * $13) + local40)] > $00) Then
                                    local42 = rand($50, $FF)
                                    local43 = (Int (rnd(100.0, 200.0) * (1.0 / 256.0)))
                                    Select local10\Field1\Field33\Field0[((local41 * $13) + local40)]
                                        Case $01,$07
                                            local38 = copyentity(local31[(local10\Field1\Field33\Field0[((local41 * $13) + local40)] - $01)], $00)
                                            If (local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] > $00) Then
                                                rotateentity(local38, 0.0, 90.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $01
                                            ElseIf (local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] > $00) Then
                                                rotateentity(local38, 0.0, 270.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $03
                                            ElseIf (local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] > $00) Then
                                                rotateentity(local38, 0.0, 180.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $02
                                            Else
                                                rotateentity(local38, 0.0, 0.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $00
                                            EndIf
                                        Case $02
                                            If ((((local40 = local50) And (local41 = local52)) Or ((local40 = local51) And (local41 = local53))) <> 0) Then
                                                local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $06
                                            EndIf
                                            If (((local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] > $00) And (local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] > $00)) <> 0) Then
                                                local38 = copyentity(local31[(local10\Field1\Field33\Field0[((local41 * $13) + local40)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.4375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                                local39 = rand($00, $01)
                                                rotateentity(local38, 0.0, (((Float local39) * 180.0) + 90.0), 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = ((local39 Shl $01) + $01)
                                            ElseIf (((local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] > $00) And (local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)] > $00)) <> 0) Then
                                                local38 = copyentity(local31[(local10\Field1\Field33\Field0[((local41 * $13) + local40)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.4375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                                local39 = rand($00, $01)
                                                rotateentity(local38, 0.0, ((Float local39) * 180.0), 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = (local39 Shl $01)
                                            Else
                                                local38 = copyentity(local31[local10\Field1\Field33\Field0[((local41 * $13) + local40)]], $00)
                                                addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.609375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                                local33 = local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)]
                                                local34 = local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)]
                                                local35 = local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))]
                                                local36 = local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))]
                                                If (((local33 > $00) And (local35 > $00)) <> 0) Then
                                                    rotateentity(local38, 0.0, 0.0, 0.0, $00)
                                                    local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $00
                                                ElseIf (((local33 > $00) And (local36 > $00)) <> 0) Then
                                                    rotateentity(local38, 0.0, 90.0, 0.0, $00)
                                                    local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $01
                                                ElseIf (((local34 > $00) And (local35 > $00)) <> 0) Then
                                                    rotateentity(local38, 0.0, 270.0, 0.0, $00)
                                                    local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $03
                                                Else
                                                    rotateentity(local38, 0.0, 180.0, 0.0, $00)
                                                    local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $02
                                                EndIf
                                            EndIf
                                            If (((local40 = local50) And (local41 = local52)) <> 0) Then
                                                local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $05
                                            EndIf
                                        Case $03
                                            local38 = copyentity(local31[local10\Field1\Field33\Field0[((local41 * $13) + local40)]], $00)
                                            local33 = local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)]
                                            local34 = local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)]
                                            local35 = local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))]
                                            local36 = local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))]
                                            If ((((local33 > $00) And (local35 > $00)) And (local36 > $00)) <> 0) Then
                                                rotateentity(local38, 0.0, 90.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $01
                                            ElseIf ((((local34 > $00) And (local35 > $00)) And (local36 > $00)) <> 0) Then
                                                rotateentity(local38, 0.0, 270.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $03
                                            ElseIf ((((local35 > $00) And (local33 > $00)) And (local34 > $00)) <> 0) Then
                                                rotateentity(local38, 0.0, 0.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $00
                                            Else
                                                rotateentity(local38, 0.0, 180.0, 0.0, $00)
                                                local10\Field1\Field33\Field1[((local41 * $13) + local40)] = $02
                                            EndIf
                                        Case $04
                                            local38 = copyentity(local31[local10\Field1\Field33\Field0[((local41 * $13) + local40)]], $00)
                                            local39 = rand($00, $03)
                                            rotateentity(local38, 0.0, ((Float local39) * 90.0), 0.0, $00)
                                            local10\Field1\Field33\Field1[((local41 * $13) + local40)] = local39
                                    End Select
                                    scaleentity(local38, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                                    positionentity(local38, (local10\Field1\Field4 + ((Float local40) * 2.0)), 8.0, (local10\Field1\Field6 + ((Float local41) * 2.0)), $01)
                                    local42 = rand($50, $FF)
                                    local43 = (Int (rnd(100.0, 200.0) * (1.0 / 256.0)))
                                    Select local10\Field1\Field33\Field0[((local41 * $13) + local40)]
                                        Case $01
                                            addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.4375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                        Case $03,$04
                                            addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.609375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                        Case $07
                                            addlight(Null, (((local10\Field1\Field4 + ((Float local40) * 2.0)) - ((sin(entityyaw(local38, $01)) * 504.0) * (1.0 / 256.0))) + ((cos(entityyaw(local38, $01)) * 16.0) * (1.0 / 256.0))), 9.546875, (((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((cos(entityyaw(local38, $01)) * 504.0) * (1.0 / 256.0))) + ((sin(entityyaw(local38, $01)) * 16.0) * (1.0 / 256.0))), $02, (Float local43), local42, local42, local42, $00)
                                            local12 = createitem("SCP-500-01", "scp500", (((local10\Field1\Field4 + ((Float local40) * 2.0)) + ((cos(entityyaw(local38, $01)) * -208.0) * (1.0 / 256.0))) - ((sin(entityyaw(local38, $01)) * 1226.0) * (1.0 / 256.0))), 8.3125, (((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((sin(entityyaw(local38, $01)) * -208.0) * (1.0 / 256.0))) + ((cos(entityyaw(local38, $01)) * 1226.0) * (1.0 / 256.0))), $00, $00, $00, 1.0, $00, $01)
                                            entitytype(local12\Field2, $03, $00)
                                            local12 = createitem("Night Vision Goggles", "nvgoggles", (((local10\Field1\Field4 + ((Float local40) * 2.0)) - ((sin(entityyaw(local38, $01)) * 504.0) * (1.0 / 256.0))) + ((cos(entityyaw(local38, $01)) * 16.0) * (1.0 / 256.0))), 8.3125, (((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((cos(entityyaw(local38, $01)) * 504.0) * (1.0 / 256.0))) + ((sin(entityyaw(local38, $01)) * 16.0) * (1.0 / 256.0))), $00, $00, $00, 1.0, $00, $01)
                                            entitytype(local12\Field2, $03, $00)
                                    End Select
                                    local42 = rand($50, $FF)
                                    local43 = (Int (rnd(100.0, 200.0) * (1.0 / 256.0)))
                                    If (((local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $06) Or (local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $05)) <> 0) Then
                                        local37 = createdoor(local10\Field1\Field0, ((local10\Field1\Field4 + ((Float local40) * 2.0)) + ((cos(entityyaw(local38, $01)) * 240.0) * (1.0 / 256.0))), 8.0, ((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((sin(entityyaw(local38, $01)) * 240.0) * (1.0 / 256.0))), (entityyaw(local38, $01) + 90.0), Null, $00, $03, $00, "")
                                        positionentity(local37\Field3[$00], (entityx(local37\Field3[$00], $01) + (cos(entityyaw(local38, $01)) * 0.05)), (entityy(local37\Field3[$00], $01) + 0.0), (entityz(local37\Field3[$00], $01) + (sin(entityyaw(local38, $01)) * 0.05)), $01)
                                        addlight(Null, ((local10\Field1\Field4 + ((Float local40) * 2.0)) + ((cos(entityyaw(local38, $01)) * 555.0) * (1.0 / 256.0))), 9.832031, ((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((sin(entityyaw(local38, $01)) * 555.0) * (1.0 / 256.0))), $02, (Float local43), local42, local42, local42, $00)
                                        local39 = createpivot($00)
                                        rotateentity(local39, 0.0, (entityyaw(local38, $01) + 180.0), 0.0, $01)
                                        positionentity(local39, ((local10\Field1\Field4 + ((Float local40) * 2.0)) + ((cos(entityyaw(local38, $01)) * 552.0) * (1.0 / 256.0))), 8.9375, ((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((sin(entityyaw(local38, $01)) * 552.0) * (1.0 / 256.0))), $00)
                                        If (local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $06) Then
                                            If (local10\Field1\Field29[$01] = Null) Then
                                                local37\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                                local10\Field1\Field29[$01] = local37
                                                adddoortooptsystem(local10\Field1, local37)
                                            Else
                                                removedoor(local37)
                                            EndIf
                                            If (local10\Field1\Field25[$03] = $00) Then
                                                local10\Field1\Field25[$03] = local39
                                                positionentity(local10\Field1\Field25[$01], (local10\Field1\Field4 + ((Float local40) * 2.0)), 8.0, (local10\Field1\Field6 + ((Float local41) * 2.0)), $01)
                                            Else
                                                freeentity(local39)
                                            EndIf
                                        Else
                                            If (local10\Field1\Field29[$03] = Null) Then
                                                local37\Field5 = (local10\Field1\Field29[$02]\Field5 = $00)
                                                local10\Field1\Field29[$03] = local37
                                                adddoortooptsystem(local10\Field1, local37)
                                            Else
                                                removedoor(local37)
                                            EndIf
                                            If (local10\Field1\Field25[$05] = $00) Then
                                                local10\Field1\Field25[$05] = local39
                                                positionentity(local10\Field1\Field25[$00], (local10\Field1\Field4 + ((Float local40) * 2.0)), 8.0, (local10\Field1\Field6 + ((Float local41) * 2.0)), $01)
                                            Else
                                                freeentity(local39)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local10\Field1\Field33\Field3[((local41 * $13) + local40)] = local38
                                    local56 = createwaypoint((local10\Field1\Field4 + ((Float local40) * 2.0)), 8.2, (local10\Field1\Field6 + ((Float local41) * 2.0)), Null, local10\Field1)
                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)] = local56
                                    If (local41 < $12) Then
                                        If (local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field0, local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]
                                                    local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local41 > $00) Then
                                        If (local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field0, local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]
                                                    local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local40 > $00) Then
                                        If (local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field0, local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]
                                                    local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local40 < $12) Then
                                        If (local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field0, local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]
                                                    local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        For local1 = $00 To $06 Step $01
                            local10\Field1\Field33\Field2[local1] = local31[local1]
                        Next
                        positionentity(local10\Field1\Field25[$00], (local10\Field1\Field4 + ((Float local50) * 2.0)), 8.0, (local10\Field1\Field6 + ((Float local52) * 2.0)), $01)
                        positionentity(local10\Field1\Field25[$01], (local10\Field1\Field4 + ((Float local51) * 2.0)), 8.0, (local10\Field1\Field6 + ((Float local53) * 2.0)), $01)
                        seedrnd(local44)
                    ElseIf (local10\Field1\Field33\Field2[$00] = $00) Then
                        local44 = rndseed()
                        seedrnd(generateseednumber(randomseed))
                        For local1 = $00 To $06 Step $01
                            local31[local1] = copyentity(objtunnel(local1), $00)
                            hideentity(local31[local1])
                        Next
                        freetexturecache()
                        local38 = $00
                        For local41 = $00 To $12 Step $01
                            For local40 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field0[((local41 * $13) + local40)] > $00) Then
                                    local42 = rand($50, $FF)
                                    local43 = (Int (rnd(100.0, 200.0) * (1.0 / 256.0)))
                                    Select local10\Field1\Field33\Field0[((local41 * $13) + local40)]
                                        Case $01,$07
                                            local38 = copyentity(local31[(local10\Field1\Field33\Field0[((local41 * $13) + local40)] - $01)], $00)
                                        Case $02
                                            If (((local10\Field1\Field33\Field0[((local40 + $01) + (local41 * $13))] > $00) And (local10\Field1\Field33\Field0[((local40 - $01) + (local41 * $13))] > $00)) <> 0) Then
                                                local38 = copyentity(local31[(local10\Field1\Field33\Field0[((local41 * $13) + local40)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.4375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                            ElseIf (((local10\Field1\Field33\Field0[(((local41 + $01) * $13) + local40)] > $00) And (local10\Field1\Field33\Field0[(((local41 - $01) * $13) + local40)] > $00)) <> 0) Then
                                                local38 = copyentity(local31[(local10\Field1\Field33\Field0[((local41 * $13) + local40)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.4375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                            Else
                                                local38 = copyentity(local31[local10\Field1\Field33\Field0[((local41 * $13) + local40)]], $00)
                                                addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.609375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                            EndIf
                                        Case $03,$04
                                            local38 = copyentity(local31[local10\Field1\Field33\Field0[((local41 * $13) + local40)]], $00)
                                        Case $05,$06
                                            local38 = copyentity(local31[$05], $00)
                                    End Select
                                    scaleentity(local38, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                                    rotateentity(local38, 0.0, ((Float local10\Field1\Field33\Field1[((local41 * $13) + local40)]) * 90.0), 0.0, $00)
                                    positionentity(local38, (local10\Field1\Field4 + ((Float local40) * 2.0)), 8.0, (local10\Field1\Field6 + ((Float local41) * 2.0)), $01)
                                    local42 = rand($50, $FF)
                                    local43 = (Int (rnd(100.0, 200.0) * (1.0 / 256.0)))
                                    Select local10\Field1\Field33\Field0[((local41 * $13) + local40)]
                                        Case $01,$05,$06
                                            addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.4375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                        Case $03,$04
                                            addlight(Null, (local10\Field1\Field4 + ((Float local40) * 2.0)), 9.609375, (local10\Field1\Field6 + ((Float local41) * 2.0)), $02, (Float local43), local42, local42, local42, $00)
                                        Case $07
                                            addlight(Null, (((local10\Field1\Field4 + ((Float local40) * 2.0)) - ((sin(entityyaw(local38, $01)) * 504.0) * (1.0 / 256.0))) + ((cos(entityyaw(local38, $01)) * 16.0) * (1.0 / 256.0))), 9.546875, (((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((cos(entityyaw(local38, $01)) * 504.0) * (1.0 / 256.0))) + ((sin(entityyaw(local38, $01)) * 16.0) * (1.0 / 256.0))), $02, (Float local43), local42, local42, local42, $00)
                                    End Select
                                    If (((local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $06) Or (local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $05)) <> 0) Then
                                        local37 = createdoor(local10\Field1\Field0, ((local10\Field1\Field4 + ((Float local40) * 2.0)) + ((cos(entityyaw(local38, $01)) * 240.0) * (1.0 / 256.0))), 8.0, ((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((sin(entityyaw(local38, $01)) * 240.0) * (1.0 / 256.0))), (entityyaw(local38, $01) + 90.0), Null, $00, $03, $00, "")
                                        addlight(Null, ((local10\Field1\Field4 + ((Float local40) * 2.0)) + ((cos(entityyaw(local38, $01)) * 555.0) * (1.0 / 256.0))), 9.832031, ((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((sin(entityyaw(local38, $01)) * 555.0) * (1.0 / 256.0))), $02, (Float local43), local42, local42, local42, $00)
                                        positionentity(local37\Field3[$00], (entityx(local37\Field3[$00], $01) + (cos(entityyaw(local38, $01)) * 0.05)), (entityy(local37\Field3[$00], $01) + 0.0), (entityz(local37\Field3[$00], $01) + (sin(entityyaw(local38, $01)) * 0.05)), $01)
                                        local39 = createpivot($00)
                                        rotateentity(local39, 0.0, (entityyaw(local38, $01) + 180.0), 0.0, $01)
                                        positionentity(local39, ((local10\Field1\Field4 + ((Float local40) * 2.0)) + ((cos(entityyaw(local38, $01)) * 552.0) * (1.0 / 256.0))), 8.9375, ((local10\Field1\Field6 + ((Float local41) * 2.0)) + ((sin(entityyaw(local38, $01)) * 552.0) * (1.0 / 256.0))), $00)
                                        If (local10\Field1\Field33\Field0[((local41 * $13) + local40)] = $06) Then
                                            If (local10\Field1\Field29[$01] = Null) Then
                                                local37\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                                local10\Field1\Field29[$01] = local37
                                                adddoortooptsystem(local10\Field1, local37)
                                            Else
                                                removedoor(local37)
                                            EndIf
                                            If (local10\Field1\Field25[$03] = $00) Then
                                                local10\Field1\Field25[$03] = local39
                                                positionentity(local10\Field1\Field25[$01], (local10\Field1\Field4 + ((Float local40) * 2.0)), 8.0, (local10\Field1\Field6 + ((Float local41) * 2.0)), $01)
                                            Else
                                                freeentity(local39)
                                            EndIf
                                        Else
                                            If (local10\Field1\Field29[$03] = Null) Then
                                                local37\Field5 = (local10\Field1\Field29[$02]\Field5 = $00)
                                                local10\Field1\Field29[$03] = local37
                                                adddoortooptsystem(local10\Field1, local37)
                                            Else
                                                removedoor(local37)
                                            EndIf
                                            If (local10\Field1\Field25[$05] = $00) Then
                                                local10\Field1\Field25[$05] = local39
                                                positionentity(local10\Field1\Field25[$00], (local10\Field1\Field4 + ((Float local40) * 2.0)), 8.0, (local10\Field1\Field6 + ((Float local41) * 2.0)), $01)
                                            Else
                                                freeentity(local39)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local10\Field1\Field33\Field3[((local41 * $13) + local40)] = local38
                                    local56 = createwaypoint((local10\Field1\Field4 + ((Float local40) * 2.0)), 8.2, (local10\Field1\Field6 + ((Float local41) * 2.0)), Null, local10\Field1)
                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)] = local56
                                    If (local41 < $12) Then
                                        If (local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field0, local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]
                                                    local10\Field1\Field33\Field4[(((local41 + $01) * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local41 > $00) Then
                                        If (local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field0, local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]
                                                    local10\Field1\Field33\Field4[(((local41 - $01) * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local40 > $00) Then
                                        If (local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field0, local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]
                                                    local10\Field1\Field33\Field4[((local40 - $01) + (local41 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local40 < $12) Then
                                        If (local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field0, local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]
                                                    local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field33\Field4[((local41 * $13) + local40)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]\Field4[local1] = local10\Field1\Field33\Field4[((local41 * $13) + local40)]
                                                    local10\Field1\Field33\Field4[((local40 + $01) + (local41 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        For local1 = $00 To $06 Step $01
                            local10\Field1\Field33\Field2[local1] = local31[local1]
                        Next
                        seedrnd(local44)
                        For local12 = Each items
                            If (((8.0 <= entityy(local12\Field2, $01)) And (12.0 >= entityy(local12\Field2, $01))) <> 0) Then
                                If ((((local10\Field1\Field4 - 6.0) <= entityx(local12\Field2, $01)) And (((local10\Field1\Field4 + 38.0) + 6.0) >= entityx(local12\Field2, $01))) <> 0) Then
                                EndIf
                                If ((((local10\Field1\Field6 - 6.0) <= entityz(local12\Field2, $01)) And (((local10\Field1\Field6 + 38.0) + 6.0) >= entityz(local12\Field2, $01))) <> 0) Then
                                EndIf
                            EndIf
                            If (((((((8.0 <= entityy(local12\Field2, $01)) And (12.0 >= entityy(local12\Field2, $01))) And ((local10\Field1\Field4 - 6.0) <= entityx(local12\Field2, $01))) And (((local10\Field1\Field4 + 38.0) + 6.0) >= entityx(local12\Field2, $01))) And ((local10\Field1\Field6 - 6.0) <= entityz(local12\Field2, $01))) And (((local10\Field1\Field6 + 38.0) + 6.0) >= entityz(local12\Field2, $01))) <> 0) Then
                                translateentity(local12\Field2, 0.0, 0.3, 0.0, $01)
                                resetentity(local12\Field2)
                            EndIf
                        Next
                    EndIf
                    For local41 = $00 To $12 Step $01
                        For local40 = $00 To $12 Step $01
                            If (local10\Field1\Field33\Field3[((local41 * $13) + local40)] <> $00) Then
                                showentity(local10\Field1\Field33\Field3[((local41 * $13) + local40)])
                            EndIf
                        Next
                    Next
                    If (4.0 < entityy(local10\Field13, $01)) Then
                        If (4.0 < entityy(collider, $01)) Then
                            If (playerroom = local10\Field1) Then
                                shouldplay = $07
                            EndIf
                        EndIf
                        If (0.0 = local10\Field2) Then
                            If (entitydistancesquared(local10\Field13, local10\Field1\Field25[$01]) > entitydistancesquared(local10\Field13, local10\Field1\Field25[$00])) Then
                                local2 = $00
                            Else
                                local2 = $01
                            EndIf
                            local10\Field2 = 2.0
                        EndIf
                    EndIf
                    local10\Field1\Field29[$00]\Field27 = updateelevators(local10\Field1\Field29[$00]\Field27, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $00)
                    local10\Field1\Field29[$02]\Field27 = updateelevators(local10\Field1\Field29[$02]\Field27, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$04], local10\Field1\Field25[$05], $00)
                    showroomdoororiginal(local10\Field1\Field29[$00])
                    showroomdoororiginal(local10\Field1\Field29[$01])
                    showroomdoororiginal(local10\Field1\Field29[$02])
                    showroomdoororiginal(local10\Field1\Field29[$03])
                ElseIf (local10\Field1\Field33 <> Null) Then
                    If (local10\Field1\Field33\Field2[$00] <> $00) Then
                        For local41 = $00 To $12 Step $01
                            For local40 = $00 To $12 Step $01
                                If (local10\Field1\Field33\Field3[((local41 * $13) + local40)] <> $00) Then
                                    hideentity(local10\Field1\Field33\Field3[((local41 * $13) + local40)])
                                EndIf
                            Next
                        Next
                    EndIf
                EndIf
            Case $1869F
            Case $22
                If (local10\Field1\Field29[$00]\Field4 <> 0) Then
                    turncheckpointmonitorsoff($01)
                EndIf
                local10\Field1\Field29[$00]\Field11 = 500.0
                local10\Field1\Field29[$01]\Field11 = 500.0
                If (local10\Field2 <> (Float local10\Field1\Field29[$00]\Field5)) Then
                    If (local10\Field7 = $00) Then
                        loadeventsound(local10, "SFX\Door\DoorCheckpoint.ogg", $00)
                    EndIf
                    If (channelplaying(local10\Field5) = $00) Then
                        local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                    EndIf
                    If (channelplaying(local10\Field6) = $00) Then
                        local10\Field6 = playsound2(local10\Field7, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                    EndIf
                EndIf
                local10\Field2 = (Float local10\Field1\Field29[$00]\Field5)
                If (channelplaying(local10\Field5) <> 0) Then
                    updatesoundorigin(local10\Field5, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                EndIf
                If (channelplaying(local10\Field6) <> 0) Then
                    updatesoundorigin(local10\Field6, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                EndIf
            Case $27
                If (playerinroom(local10) <> 0) Then
                    If (-11.125 >= entityy(local10\Field13, $00)) Then
                        If (0.0 < entitypitch(local10\Field1\Field25[$09], $01)) Then
                            local59 = $01
                        Else
                            local59 = $00
                        EndIf
                        local2 = (updatelever(local10\Field1\Field25[$07], $00) = $00)
                        local21 = (Float updatelever(local10\Field1\Field25[$09], $00))
                        If (local21 <> (Float local59)) Then
                            If (0.0 = local21) Then
                                playsound_strict(lightsfx)
                            Else
                                playsound_strict(teslapowerupsfx)
                            EndIf
                        EndIf
                        If ((Int local21) <> 0) Then
                            If (playerroom = local10\Field1) Then
                                shouldplay = $08
                            EndIf
                            local10\Field2 = max(local10\Field2, 12600.0)
                            If (local10\Field8 = $00) Then
                                loadeventsound(local10, "SFX\Ambient\Room ambience\fuelpump.ogg", $01)
                            EndIf
                            local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local10\Field1\Field25[$0A], 6.0, 1.0)
                        ElseIf (channelplaying(local10\Field6) <> 0) Then
                            stopchannel(local10\Field6)
                        EndIf
                    EndIf
                EndIf
                local10\Field1\Field29[$00]\Field27 = updateelevators(local10\Field1\Field29[$00]\Field27, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
                local10\Field1\Field29[$02]\Field27 = updateelevators(local10\Field1\Field29[$02]\Field27, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $01)
            Case $4A
            Case $39
                local60 = $00
                local61 = local10\Field1\Field11
                If (local61 <> Null) Then
                    hideentity(local61\Field4)
                    If (networkserver\Field15 <> 0) Then
                        updateforest(local61, local10\Field13, $01)
                    EndIf
                    local60 = updateforest(local61, collider, $00)
                EndIf
                If (local60 <> 0) Then
                    If (((playerroom\Field8\Field11 <> "dimension1499") And (playerroom\Field8\Field11 <> "pocketdimension")) <> 0) Then
                        If (1.0 <> local10\Field2) Then
                            showentity(local61\Field4)
                            local10\Field2 = 1.0
                            local10\Field4 = 0.0
                            prevsecondarylighton = secondarylighton
                            secondarylighton = 1.0
                        EndIf
                    EndIf
                EndIf
                If (((playerroom = local10\Field1) And (local61 <> Null)) <> 0) Then
                    If (1.0 = local10\Field2) Then
                        currstepsfx = $02
                        If (((local10\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field11 = "load0"
                        EndIf
                        shouldplay = $09
                        If (noclip = $00) Then
                            If (local26 > (entityy(local61\Field4, $01) + 0.5)) Then
                                moveentity(collider, 0.0, (((entityy(local61\Field4, $01) + 0.5) - local26) * fpsfactor), 0.0)
                            EndIf
                        EndIf
                        For local1 = $00 To $01 Step $01
                            If (0.25 > entitydistancesquared(local61\Field5[local1], collider)) Then
                                If (entityinview(local61\Field5[local1], camera) <> 0) Then
                                    drawhandicon = $01
                                    If (mousehit1 <> 0) Then
                                        If ((Float local1) = local10\Field3) Then
                                            blinktimer = -10.0
                                            playsound_strict(loadtempsound("SFX\Door\WoodenDoorOpen.ogg"))
                                            rotateentity(local10\Field1\Field25[$03], 0.0, 0.0, 0.0, $00)
                                            rotateentity(local10\Field1\Field25[$04], 0.0, 180.0, 0.0, $00)
                                            positionentity(collider, entityx(local10\Field1\Field25[$02], $01), 0.5, entityz(local10\Field1\Field25[$02], $01), $00)
                                            rotateentity(collider, 0.0, (entityyaw(local10\Field1\Field3, $01) + (local10\Field3 * 180.0)), 0.0, $00)
                                            moveentity(collider, 0.0, 0.0, 1.5)
                                            resetentity(collider)
                                            updatedoorstimer = 0.0
                                            updatedoors()
                                            secondarylighton = prevsecondarylighton
                                            local10\Field2 = 0.0
                                            local10\Field4 = 0.0
                                        Else
                                            playsound_strict(loadtempsound("SFX\Door\WoodenDoorBudge.ogg"))
                                            multiplayer_writetempsound("SFX\Door\WoodenDoorBudge.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                            setmsg("The door will not budge.")
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        local21 = 2.0
                        If (debughud = $00) Then
                            cameraclscolor(camera, min(98.0, 255.0), min(133.0, 255.0), min(162.0, 255.0), 1.0)
                            camerarange(camera, 0.1, 8.5)
                            camerafogrange(camera, -2.0, 8.0)
                            camerafogcolor(camera, min(98.0, 255.0), min(133.0, 255.0), min(162.0, 255.0))
                        EndIf
                        If (28.5 >= local26) Then
                            rotateentity(local10\Field1\Field25[$03], 0.0, 0.0, 0.0, $00)
                            rotateentity(local10\Field1\Field25[$04], 0.0, 180.0, 0.0, $00)
                            local10\Field2 = 0.0
                            local10\Field4 = 0.0
                        EndIf
                    ElseIf (0.0 = entityyaw(local10\Field1\Field25[$03], $00)) Then
                        hideentity(local61\Field4)
                        If (1.0 > (Abs distance(entityx(local10\Field1\Field25[$03], $01), entityz(local10\Field1\Field25[$03], $01), entityx(collider, $01), entityz(collider, $01)))) Then
                            drawhandicon = $01
                            If (mousehit1 <> 0) Then
                                playsound_strict(loadtempsound("SFX\Door\WoodenDoorOpen.ogg"))
                                multiplayer_writetempsound("SFX\Door\WoodenDoorOpen.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                showentity(local61\Field4)
                                selecteditem = Null
                                blinktimer = -10.0
                                local10\Field2 = 1.0
                                local10\Field4 = 0.0
                                prevsecondarylighton = secondarylighton
                                secondarylighton = 1.0
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local3, local10\Field1\Field3, 0.0)
                                local62 = wrapangle((entityyaw(local3, $00) - entityyaw(local10\Field1\Field3, $01)))
                                If (((90.0 < local62) And (270.0 > local62)) <> 0) Then
                                    positionentity(collider, entityx(local61\Field5[$00], $01), ((entityy(local61\Field5[$00], $01) + entityy(collider, $01)) + 0.5), entityz(local61\Field5[$00], $01), $01)
                                    rotateentity(collider, 0.0, (entityyaw(local61\Field5[$00], $01) - 180.0), 0.0, $01)
                                    moveentity(collider, -0.5, 0.0, 0.5)
                                    local10\Field3 = 1.0
                                Else
                                    positionentity(collider, entityx(local61\Field5[$01], $01), ((entityy(local61\Field5[$01], $01) + entityy(collider, $01)) + 0.5), entityz(local61\Field5[$01], $01), $01)
                                    rotateentity(collider, 0.0, (entityyaw(local61\Field5[$01], $01) - 180.0), 0.0, $01)
                                    moveentity(collider, -0.5, 0.0, 0.5)
                                    local10\Field3 = 0.0
                                EndIf
                                freeentity(local3)
                                resetentity(collider)
                            EndIf
                        EndIf
                    EndIf
                ElseIf (local61 <> Null) Then
                    If (((local61\Field4 <> $00) And (playerinroom(local10) = $00)) <> 0) Then
                        hideentity(local61\Field4)
                    EndIf
                    If (((playerroom\Field8\Field11 <> "dimension1499") And (playerroom\Field8\Field11 <> "pocketdimension")) <> 0) Then
                        If (1.0 = local10\Field2) Then
                            rotateentity(local10\Field1\Field25[$03], 0.0, 0.0, 0.0, $00)
                            rotateentity(local10\Field1\Field25[$04], 0.0, 180.0, 0.0, $00)
                            local10\Field2 = 0.0
                            local10\Field4 = 0.0
                        EndIf
                    EndIf
                EndIf
            Case $02
                If (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    showentity(local10\Field1\Field3)
                    stamina = -30.0
                    playerfallingpickdistance = 0.0
                    injuries = ((fpsfactor * 0.00005) + injuries)
                    prevsecondarylighton = secondarylighton
                    secondarylighton = 1.0
                    If ((((1.0 / 0.128) > entityy(local10\Field13, $00)) Or (10.1875 < entityy(local10\Field13, $00))) <> 0) Then
                        currstepsfx = $01
                    EndIf
                    If (local10\Field7 = $00) Then
                        loadeventsound(local10, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                    EndIf
                    If (local10\Field8 = $00) Then
                        local10\Field8 = loadeventsound(local10, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                    EndIf
                    If (0.0 = local10\Field2) Then
                        camerafogcolor(camera, 0.0, 0.0, 0.0)
                        cameraclscolor(camera, 0.0, 0.0, 0.0, 1.0)
                        local10\Field2 = 0.1
                    EndIf
                    If (((((1.0 / 0.128) > entityy(local10\Field13, $00)) Or (0.0 = local10\Field4)) Or (10.1875 < entityy(local10\Field13, $00))) <> 0) Then
                        shouldplay = $03
                    Else
                        shouldplay = $00
                    EndIf
                    scaleentity(local10\Field1\Field3, (1.0 / 256.0), (((sin((local10\Field2 / 14.0)) * 0.2) + 1.0) * (1.0 / 256.0)), (1.0 / 256.0), $00)
                    For local1 = $00 To $07 Step $01
                        scaleentity(local10\Field1\Field25[local1], (((Abs (sin(((local10\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.0) * (1.0 / 256.0)), (((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * (1.0 / 256.0)), (1.0 / 256.0), $01)
                    Next
                    scaleentity(local10\Field1\Field25[$09], (((Abs (sin(((local10\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.5) * (1.0 / 256.0)), (((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * (1.0 / 256.0)), (1.0 / 256.0), $01)
                    local10\Field2 = (local10\Field2 + fpsfactor)
                    If (0.0 = local10\Field3) Then
                        local10\Field1\Field29[$00]\Field5 = $00
                        local10\Field1\Field29[$01]\Field5 = $00
                        local10\Field2 = 601.0
                    EndIf
                    If (1.0 = local10\Field3) Then
                        If (local10\Field1\Field26[$09] = $01) Then
                            positionentity(local10\Field1\Field25[$09], (entityx(local10\Field1\Field25[$08], $01) + 13.21875), 0.0, entityz(local10\Field1\Field25[$08], $01), $00)
                            translateentity(local10\Field1\Field25[$09], (cos((local10\Field2 * 0.8)) * 5.0), 0.0, (sin((local10\Field2 * 1.6)) * 4.0), $01)
                            rotateentity(local10\Field1\Field25[$09], 0.0, (local10\Field2 * 2.0), 0.0, $00)
                            positionentity(local10\Field1\Field25[$0A], entityx(local10\Field1\Field25[$08], $01), 0.0, (entityz(local10\Field1\Field25[$08], $01) + 13.21875), $00)
                            translateentity(local10\Field1\Field25[$0A], (sin((local10\Field2 * 1.6)) * 4.0), 0.0, (cos((local10\Field2 * 0.8)) * 5.0), $01)
                            rotateentity(local10\Field1\Field25[$0A], 0.0, (local10\Field2 * 2.0), 0.0, $00)
                        EndIf
                        If (((1.0 = local10\Field4) Or (2.0 = local10\Field4)) <> 0) Then
                            If (((1.0 = local10\Field4) And ((150.0 < local10\Field1\Field29[$00]\Field7) Or (150.0 < local10\Field1\Field29[$01]\Field7))) <> 0) Then
                                playsound_strict(loadtempsound("SFX\Horror\Horror16.ogg"))
                                blurtimer = 800.0
                                local10\Field4 = 2.0
                            EndIf
                            If (5.0 > entityy(local10\Field13, $00)) Then
                                local10\Field4 = 0.0
                            EndIf
                        ElseIf (6.0 < entityy(local10\Field13, $00)) Then
                            shouldplay = $0F
                            camerafogcolor(camera, 38.0, 55.0, 47.0)
                            cameraclscolor(camera, 38.0, 55.0, 47.0, 1.0)
                            If ((entityx(local10\Field1\Field25[$08], $01) - 15.625) > entityx(local10\Field1\Field25[$14], $01)) Then
                                local10\Field6 = playsound_strict(local10\Field8)
                                positionentity(local10\Field1\Field25[$14], (entityx(local10\Field13, $01) + 15.625), 12.0, entityz(local10\Field13, $01), $00)
                            EndIf
                            moveentity(local10\Field13, 0.0, (min((12.0 - entityy(local10\Field13, $00)), 0.0) * fpsfactor), 0.0)
                            local21 = (((- fpsfactor) * (1.0 / 256.0)) * 4.0)
                            local22 = ((17.0 - ((Abs (entityx(local10\Field13, $00) - entityx(local10\Field1\Field25[$14], $00))) * 0.5)) - entityy(local10\Field1\Field25[$14], $00))
                            local23 = (entityz(local10\Field13, $01) - entityz(local10\Field1\Field25[$14], $00))
                            translateentity(local10\Field1\Field25[$14], local21, local22, local23, $01)
                            rotateentity(local10\Field1\Field25[$14], (-90.0 - ((entityx(local10\Field13, $00) - entityx(local10\Field1\Field25[$14], $00)) * 1.5)), -90.0, 0.0, $01)
                            local63 = $00
                            For local1 = $00 To $02 Step $01
                                Select local1
                                    Case $00
                                        local21 = -5.671875
                                        local23 = (1.0 / -6.918919)
                                    Case $01
                                        local21 = (1.0 / -2.115702)
                                        local23 = 0.734375
                                    Case $02
                                        local21 = 4.777344
                                        local23 = -0.765625
                                End Select
                                local21 = (entityx(local10\Field1\Field25[$08], $01) + local21)
                                local23 = (entityz(local10\Field1\Field25[$08], $01) + local23)
                                If ((1.0 / 1.28) > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), local21, local23)) Then
                                    local63 = $01
                                    Exit
                                EndIf
                            Next
                            local0 = entitydistance(local10\Field13, local10\Field1\Field25[$14])
                            If (((local10\Field6 <> $00) And channelplaying(local10\Field6)) <> 0) Then
                                local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, camera, 10.0, (((Float (local63 = $00)) * 0.6) + 0.3))
                            EndIf
                            If (local63 <> 0) Then
                                entitytexture(local10\Field1\Field25[$14], local10\Field1\Field27[$12], $00, $00)
                            ElseIf (8.0 > local0) Then
                                local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field25[$14], 8.0, 1.0)
                                entitytexture(local10\Field1\Field25[$14], local10\Field1\Field27[$13], $00, $00)
                                injuries = ((((8.0 - local0) * fpsfactor) * 0.0003) + injuries)
                                If (7.0 > local0) Then
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local3, local10\Field1\Field25[$14], 0.0)
                                    turnentity(local3, 90.0, 0.0, 0.0, $00)
                                    user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), 10.0)
                                    user_camera_pitch = (user_camera_pitch - 90.0)
                                    rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), 10.0), 0.0, $00)
                                    freeentity(local3)
                                EndIf
                            EndIf
                            camerashake = max(((((Float (local63 = $00)) * 4.0) + 4.0) - local0), 0.0)
                            If (((8.5 > entityy(local10\Field13, $00)) And $00) <> 0) Then
                                loadeventsound(local10, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                                loadeventsound(local10, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                                blurtimer = 1500.0
                                local10\Field3 = 1.0
                                blinktimer = -10.0
                                positionentity(local10\Field13, (entityx(local10\Field1\Field25[$08], $01) - (1.0 / 0.64)), -1.1875, entityz(local10\Field1\Field25[$08], $01), $00)
                                resetentity(local10\Field13)
                                camerafogcolor(camera, 0.0, 0.0, 0.0)
                                cameraclscolor(camera, 0.0, 0.0, 0.0, 1.0)
                            EndIf
                        Else
                            local10\Field4 = 0.0
                            If (player_isdead() = $00) Then
                                For local1 = $09 To $0A Step $01
                                    local0 = distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))
                                    If (6.0 > local0) Then
                                        If ((1.0 / 2.56) > local0) Then
                                            local3 = createpivot($00)
                                            positionentity(local3, entityx(local10\Field1\Field25[local1], $01), entityy(local10\Field13, $00), entityz(local10\Field1\Field25[local1], $01), $00)
                                            pointentity(local3, local10\Field13, 0.0)
                                            rotateentity(local3, 0.0, (Float ((Int (entityyaw(local3, $00) / 90.0)) * $5A)), 0.0, $01)
                                            moveentity(local3, 0.0, 0.0, (1.0 / 2.56))
                                            positionentity(local10\Field13, entityx(local3, $00), entityy(local10\Field13, $00), entityz(local3, $00), $00)
                                            freeentity(local3)
                                            If (((0.0 = killtimer) And (player_isdead() = $00)) <> 0) Then
                                                deathmsg = "In addition to the decomposed appearance typical of SCP-106's victims, the body exhibits injuries that have not been observed before: "
                                                deathmsg = (deathmsg + "massive skull fracture, three broken ribs, fractured shoulder and multiple heavy lacerations.")
                                                playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"))
                                                kill("was killed in pocket dimension", $01)
                                                multiplayer_writetempsound("SFX\Room\PocketDimension\Impact.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                            EndIf
                                        EndIf
                                        If (1000.0 > (Float local10\Field11)) Then
                                            local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field25[local1], 6.0, 1.0)
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            local3 = createpivot($00)
                            positionentity(local3, (entityx(local10\Field1\Field25[$08], $01) - 6.0), (1.0 / 0.512), (entityz(local10\Field1\Field25[$08], $01) + 2.375), $00)
                            If (25.0 > entitydistancesquared(local3, local10\Field13)) Then
                                local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local3, 3.0, 1.0)
                            EndIf
                            freeentity(local3)
                            showentity(local10\Field1\Field25[$11])
                            positionentity(local10\Field1\Field25[$11], entityx(local10\Field1\Field25[$08], $01), 5.375, (entityz(local10\Field1\Field25[$08], $01) - 11.125), $00)
                            pointentity(local10\Field1\Field25[$11], local10\Field13, 0.0)
                            turnentity(local10\Field1\Field25[$11], 0.0, 180.0, 0.0, $00)
                            local2 = (Int entitydistance(local10\Field13, local10\Field1\Field25[$11]))
                            If ((1.0 / 0.128) > (Float local2)) Then
                                injuries = ((fpsfactor / 4000.0) + injuries)
                                local10\Field11 = (Str ((Float local10\Field11) + (fpsfactor / 1000.0)))
                                If (((1.0 < (Float local10\Field11)) And (1000.0 > (Float local10\Field11))) <> 0) Then
                                    playsound_strict(loadtempsound("SFX\Room\PocketDimension\Kneel.ogg"))
                                    loadeventsound(local10, "SFX\Room\PocketDimension\Screech.ogg", $00)
                                    local10\Field11 = "1000.0"
                                EndIf
                                sanity = max((sanity - ((fpsfactor / (Float local2)) / 8.0)), -1000.0)
                                currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs()) / 20.0)) + 1.0) * 15.0) * max(((6.0 - (Float local2)) / 6.0), 0.0)))
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local3, local10\Field1\Field25[$11], 0.0)
                                turnentity(local3, 90.0, 0.0, 0.0, $00)
                                user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 15.0), 500.0))
                                user_camera_pitch = (user_camera_pitch - 90.0)
                                rotateentity(local10\Field13, entitypitch(local10\Field13, $00), curveangle(entityyaw(local3, $00), entityyaw(local10\Field13, $00), min(max((15000.0 / (- sanity)), 15.0), 500.0)), 0.0, $00)
                                freeentity(local3)
                                If ((crouch And $00) <> 0) Then
                                    blinktimer = -10.0
                                    positionentity(local10\Field13, (entityx(local10\Field1\Field25[$08], $01) - 5.25), 11.5, (entityz(local10\Field1\Field25[$08], $01) - 4.625), $00)
                                    resetentity(local10\Field13)
                                    crouch = $00
                                    loadeventsound(local10, "SFX\Room\PocketDimension\Explosion.ogg", $00)
                                    loadeventsound(local10, "SFX\Room\PocketDimension\TrenchPlane.ogg", $01)
                                    positionentity(local10\Field1\Field25[$14], (entityx(local10\Field1\Field25[$08], $01) - 1000.0), 0.0, 0.0, $01)
                                    local10\Field11 = "0.0"
                                EndIf
                            ElseIf (-0.703125 > entityy(local10\Field13, $00)) Then
                                local2 = (Int distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), (entityx(local10\Field1\Field25[$08], $01) + 4.0), entityz(local10\Field1\Field25[$08], $01)))
                                If (2.5 > (Float local2)) Then
                                    blurtimer = ((2.5 - (Float local2)) * 3000.0)
                                    local10\Field6 = loopsound2(decaysfx(rand($01, $03)), local10\Field6, camera, local10\Field13, 2.0, (((2.5 - (Float local2)) * (Abs currspeed)) * 100.0))
                                    currspeed = curvevalue(0.0, currspeed, (Float (local2 * $0A)))
                                    If ((1.0 / 1.969231) > (Float local2)) Then
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (-6.25 > entityy(local10\Field13, $00)) Then
                            If (18.55469 >= entitydistance(local10\Field13, local10\Field1\Field25[$08])) Then
                                If (0.0 <= killtimer) Then
                                    playsound_strict(horrorsfx($08))
                                    deathmsg = "In addition to the decomposed appearance typical of the victims of SCP-106, the subject seems to have suffered multiple heavy fractures to both of his legs."
                                EndIf
                                kill("was killed in pocket dimension", $01)
                                blurtimer = 3000.0
                            EndIf
                        EndIf
                        updatedoorstimer = 0.0
                        updatedoors()
                        updaterooms()
                    ElseIf (0.0 = local10\Field3) Then
                        local0 = entitydistance(local10\Field13, local10\Field1\Field3)
                        If (6.640625 < local0) Then
                        EndIf
                    Else
                        camerafogcolor(camera, 19.0, 27.5, 23.5)
                        cameraclscolor(camera, 19.0, 27.5, 23.5, 1.0)
                        If (particleamount > $00) Then
                            If (rand($320, $01) = $01) Then
                                local24 = (entityyaw(camera, $01) + rnd(150.0, 210.0))
                                local7 = createparticle((entityx(local10\Field13, $00) + (cos(local24) * 7.5)), 0.0, (entityz(local10\Field13, $00) + (sin(local24) * 7.5)), $03, 4.0, 0.0, $9C4, 1.0, $01)
                                entityblend(local7\Field0, $02)
                                local7\Field6 = 0.01
                                local7\Field13 = 0.0
                                pointentity(local7\Field1, camera, 0.0)
                                turnentity(local7\Field1, 0.0, 145.0, 0.0, $01)
                                turnentity(local7\Field1, (Float rand($0A, $14)), 0.0, 0.0, $01)
                            EndIf
                        EndIf
                        If (-6.25 > entityy(local10\Field13, $00)) Then
                            If (0.5625 <= distance(entityx(local10\Field1\Field25[$10], $01), entityz(local10\Field1\Field25[$10], $01), entityx(local10\Field13, $00), entityz(local10\Field13, $00))) Then
                                If (0.0 <= killtimer) Then
                                    playsound_strict(horrorsfx($08))
                                EndIf
                                blurtimer = 3000.0
                                kill("was killed in pocket dimension", $01)
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideentity(local10\Field1\Field3)
                    local10\Field2 = 0.0
                    local10\Field3 = 0.0
                    local10\Field4 = 0.0
                    local10\Field11 = "0.0"
                EndIf
            Case $14
                If (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    If (using294 = $00) Then
                        If (2.25 > entitydistancesquared(local10\Field1\Field25[$00], collider)) Then
                            If (entityinview(local10\Field1\Field25[$00], camera) <> 0) Then
                                drawhandicon = $01
                                If (mousehit1 <> 0) Then
                                    local2 = $01
                                    For local12 = Each items
                                        If (local12\Field16 = $00) Then
                                            If (0.0 = (entityx(local12\Field2, $00) - entityx(local10\Field1\Field25[$01], $01))) Then
                                                If (0.0 = (entityz(local12\Field2, $00) - entityz(local10\Field1\Field25[$01], $01))) Then
                                                    local2 = $00
                                                    Exit
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                    local66 = $00
                                    If (2.0 > local10\Field3) Then
                                        If (selecteditem <> Null) Then
                                            If (((selecteditem\Field1\Field2 = "25ct") Or (selecteditem\Field1\Field2 = "coin")) <> 0) Then
                                                removeitem(selecteditem, $01)
                                                selecteditem = Null
                                                local10\Field3 = (local10\Field3 + 1.0)
                                                playsound_strict(loadtempsound("SFX\SCP\294\coin_drop.ogg"))
                                                multiplayer_writetempsound("SFX\SCP\294\coin_drop.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                                local66 = $01
                                            EndIf
                                        EndIf
                                    EndIf
                                    If (2.0 = local10\Field3) Then
                                        using294 = local2
                                        If (using294 <> 0) Then
                                            mousehit1 = $00
                                        EndIf
                                    ElseIf (((1.0 = local10\Field3) And (local66 = $00)) <> 0) Then
                                        using294 = $00
                                        msg = "You need to insert another Quarter in order to use this machine."
                                        msgtimer = 350.0
                                    ElseIf (local66 = $00) Then
                                        using294 = $00
                                        msg = "You need to insert two Quarters in order to use this machine."
                                        msgtimer = 350.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (0.0 = local10\Field2) Then
                    local10\Field2 = 1.0
                EndIf
            Case $3D
                local10\Field1\Field29[$00]\Field4 = $01
                local10\Field1\Field29[$01]\Field4 = $01
                local67 = $00
                If (local10\Field1\Field25[$01] <> $00) Then
                    local67 = $01
                EndIf
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (((1.96 > entitydistancesquared(local10\Field1\Field25[$00], local10\Field13)) And (0.0 = local10\Field4)) <> 0) Then
                            local10\Field2 = 1.0
                            If (local67 <> 0) Then
                                If (local10\Field8 <> $00) Then
                                    freesound_strict(local10\Field8)
                                    local10\Field8 = $00
                                EndIf
                                local10\Field8 = loadsound_strict("SFX\Door\DoorSparks.ogg")
                                local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field25[$01], 5.0, 1.0)
                            EndIf
                            stopchannel(local10\Field5)
                            local10\Field5 = $00
                            If (local10\Field7 <> $00) Then
                                freesound_strict(local10\Field7)
                                local10\Field7 = $00
                            EndIf
                            local10\Field7 = loadsound_strict("SFX\Door\Airlock.ogg")
                            local10\Field1\Field29[$00]\Field4 = $00
                            local10\Field1\Field29[$01]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $01, $01, $00, "", $00)
                            usedoor(local10\Field1\Field29[$01], $01, $01, $00, "", $00)
                            If (playerroom = local10\Field1) Then
                                playsound_strict(alarmsfx($04))
                            EndIf
                        ElseIf (5.76 < entitydistancesquared(local10\Field1\Field25[$00], local10\Field13)) Then
                            local10\Field4 = 0.0
                        EndIf
                    ElseIf (490.0 > local10\Field3) Then
                        local10\Field3 = (local10\Field3 + fpsfactor)
                        local10\Field1\Field29[$00]\Field5 = $00
                        local10\Field1\Field29[$01]\Field5 = $00
                        If (70.0 > local10\Field3) Then
                            If (local67 <> 0) Then
                                local3 = createpivot($00)
                                local68 = local10\Field1\Field25[$01]
                                positionentity(local3, entityx(local68, $01), (entityy(local68, $01) + rnd(0.0, 0.05)), entityz(local68, $01), $00)
                                rotateentity(local3, 0.0, (entityyaw(local68, $01) + 90.0), 0.0, $00)
                                moveentity(local3, 0.0, 0.0, 0.2)
                                If (particleamount > $00) Then
                                    For local1 = $00 To (((particleamount - $01) Shl $01) + $01) Step $01
                                        local7 = createparticle(entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $07, 0.002, 0.0, $19, 1.0, $01)
                                        local7\Field6 = rnd(0.01, 0.05)
                                        rotateentity(local7\Field1, rnd(-45.0, 0.0), (entityyaw(local3, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                                        local7\Field4 = 0.0075
                                        scalesprite(local7\Field0, local7\Field4, local7\Field4)
                                        local7\Field12 = -0.05
                                    Next
                                EndIf
                                freeentity(local3)
                            EndIf
                        ElseIf (((210.0 < local10\Field3) And (385.0 > local10\Field2)) <> 0) Then
                            local3 = createpivot(local10\Field1\Field3)
                            For local1 = $00 To $01 Step $01
                                If (local10\Field1\Field8\Field11 = "room3gw") Then
                                    If (local1 = $00) Then
                                        positionentity(local3, -288.0, 416.0, 320.0, $00)
                                    Else
                                        positionentity(local3, 192.0, 416.0, 320.0, $00)
                                    EndIf
                                ElseIf (local1 = $00) Then
                                    positionentity(local3, 312.0, 416.0, -128.0, $00)
                                Else
                                    positionentity(local3, 312.0, 416.0, 224.0, $00)
                                EndIf
                                local7 = createparticle(entityx(local3, $01), entityy(local3, $01), entityz(local3, $01), $06, 0.8, 0.0, $32, 1.0, $01)
                                local7\Field6 = 0.025
                                rotateentity(local7\Field1, 90.0, 0.0, 0.0, $00)
                                local7\Field12 = -0.02
                            Next
                            freeentity(local3)
                            If (local10\Field5 = $00) Then
                                local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field25[$00], 5.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        local10\Field2 = 0.0
                        local10\Field3 = 0.0
                        local10\Field4 = 1.0
                        If (local10\Field1\Field29[$00]\Field5 = $00) Then
                            local10\Field1\Field29[$00]\Field4 = $00
                            local10\Field1\Field29[$01]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $01, $01, $00, "", $00)
                            usedoor(local10\Field1\Field29[$01], $01, $01, $00, "", $00)
                        EndIf
                        removeevent(local10)
                    EndIf
                    If (local10 <> Null) Then
                        If (local67 <> 0) Then
                            If (channelplaying(local10\Field6) <> 0) Then
                                updatesoundorigin(local10\Field6, camera, local10\Field1\Field25[$01], 5.0, 1.0)
                            EndIf
                        EndIf
                        If (channelplaying(local10\Field5) <> 0) Then
                            updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$00], 5.0, 1.0)
                        EndIf
                    EndIf
                Else
                    local10\Field4 = 0.0
                EndIf
            Case $34
                If (playerinroom(local10) <> 0) Then
                    If (1.0 > entitydistancesquared(local10\Field1\Field25[$03], collider)) Then
                        If (0.0 = local10\Field2) Then
                            local10\Field2 = max(local10\Field2, 1.0)
                        EndIf
                    EndIf
                    updatelever(local10\Field1\Field25[$01], $00)
                    local69 = (Int local10\Field3)
                    local10\Field3 = (Float updatelever(local10\Field1\Field25[$03], $00))
                    If ((((Float local69) <> local10\Field3) And (0.0 < local10\Field2)) <> 0) Then
                        playsound2(lightsfx, camera, local10\Field1\Field25[$03], 10.0, 1.0)
                    EndIf
                    remotedooron = updatelever(local10\Field1\Field25[$05], $00)
                    If (((0.0 < local10\Field2) And (200.0 > local10\Field2)) <> 0) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        rotateentity(local10\Field1\Field25[$03], curvevalue(-85.0, entitypitch(local10\Field1\Field25[$03], $00), 5.0), entityyaw(local10\Field1\Field25[$03], $00), 0.0, $00)
                    EndIf
                EndIf
            Case $49
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    local10\Field2 = (Float rand($01, $03))
                Else
                    local10\Field1\Field29[$00]\Field12 = (Int local10\Field2)
                EndIf
            Case $3E
                If (playerroom <> local10\Field1) Then
                    If (local10\Field1\Field25[$00] <> $00) Then
                        For local1 = $01 To $0F Step $01
                            hideentity(local10\Field1\Field25[local1])
                        Next
                    EndIf
                    If (local26 > (entityy(local10\Field1\Field3, $00) - 0.5)) Then
                        playerroom = local10\Field1
                    EndIf
                EndIf
                If (2.0 = local10\Field2) Then
                    If (local10\Field5 <> $00) Then
                        stopstream_strict(local10\Field5)
                        stopchannel(local10\Field6)
                        local10\Field5 = $00
                        local10\Field6 = $00
                    EndIf
                    hideentity(sky[$02])
                    For local70 = Each dummy1499
                        freeentity(local70\Field1)
                        Delete local70
                    Next
                    If (2100.0 > local10\Field4) Then
                        local10\Field4 = 0.0
                    EndIf
                    local10\Field2 = 1.0
                    If (local10\Field8 <> $00) Then
                        freesound_strict(local10\Field8)
                        local10\Field8 = $00
                    EndIf
                EndIf
            Case $42
                If (playerroom <> local10\Field1) Then
                    hideentity(local10\Field1\Field25[$00])
                Else
                    showentity(local10\Field1\Field25[$00])
                EndIf
            Case $43
                If (playerroom = local10\Field1) Then
                    updatebutton(local10\Field1\Field25[$02])
                    If (((closestbutton = local10\Field1\Field25[$02]) And mousehit1) <> 0) Then
                        setmsg("The elevator appears to be broken.")
                        playsound2(buttonsfx2, camera, local10\Field1\Field25[$02], 10.0, 1.0)
                        multiplayer_writesound(buttonsfx2, 0.0, 0.0, 0.0, 10.0, 1.0)
                        mousehit1 = $00
                    EndIf
                    If (((-2.0 > local26) And (0.0 <= falltimer)) <> 0) Then
                        If (kill("was killed", $00) <> 0) Then
                            deathmsg = ""
                            If (local10\Field5 = $00) Then
                                local10\Field5 = playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"))
                            ElseIf (channelplaying(local10\Field5) = $00) Then
                                local10\Field5 = playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"))
                                multiplayer_writetempsound("SFX\Room\PocketDimension\Impact.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $44
                If (playerroom = local10\Field1) Then
                    For local1 = $00 To $01 Step $01
                        updatebutton(local10\Field1\Field25[local1])
                        If (((closestbutton = local10\Field1\Field25[local1]) And mousehit1) <> 0) Then
                            setmsg("The elevator appears to be broken.")
                            playsound2(buttonsfx2, camera, local10\Field1\Field25[local1], 10.0, 1.0)
                            multiplayer_writesound(buttonsfx2, 0.0, 0.0, 0.0, 10.0, 1.0)
                            mousehit1 = $00
                        EndIf
                    Next
                EndIf
            Case $1F
                If (playerinroom(local10) <> 0) Then
                    local10\Field1\Field29[$00]\Field27 = updateelevators(local10\Field1\Field29[$00]\Field27, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$04], local10\Field1\Field25[$05], $01)
                    local10\Field2 = (Float updatelever(local10\Field1\Field25[$01], $00))
                    updatelever(local10\Field1\Field25[$03], $00)
                EndIf
            Case $07
                If (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    If (0.0 >= local10\Field3) Then
                        local10\Field1\Field29[$01]\Field4 = $00
                        local10\Field1\Field29[$04]\Field4 = $00
                        local10\Field3 = 350.0
                    Else
                        local10\Field3 = (local10\Field3 - fpsfactor)
                    EndIf
                    lightvolume = (templightvolume * 0.5)
                    tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field3)
                    local2 = $00
                    If (730.0 < tformedx()) Then
                        updateworld(1.0)
                        tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field3)
                        For local1 = $01 To $02 Step $01
                            local10\Field1\Field29[local1]\Field5 = local10\Field1\Field29[(local1 + $02)]\Field5
                            local10\Field1\Field29[local1]\Field7 = local10\Field1\Field29[(local1 + $02)]\Field7
                            positionentity(local10\Field1\Field29[local1]\Field0, entityx(local10\Field1\Field29[(local1 + $02)]\Field0, $00), entityy(local10\Field1\Field29[(local1 + $02)]\Field0, $00), entityz(local10\Field1\Field29[(local1 + $02)]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[local1]\Field1, entityx(local10\Field1\Field29[(local1 + $02)]\Field1, $00), entityy(local10\Field1\Field29[(local1 + $02)]\Field1, $00), entityz(local10\Field1\Field29[(local1 + $02)]\Field1, $00), $00)
                            local10\Field1\Field29[(local1 + $02)]\Field5 = $00
                            local10\Field1\Field29[(local1 + $02)]\Field7 = 0.0
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field0, entityx(local10\Field1\Field29[$00]\Field0, $00), entityy(local10\Field1\Field29[$00]\Field0, $00), entityz(local10\Field1\Field29[$00]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field1, entityx(local10\Field1\Field29[$00]\Field1, $00), entityy(local10\Field1\Field29[$00]\Field1, $00), entityz(local10\Field1\Field29[$00]\Field1, $00), $00)
                        Next
                        tformpoint((tformedx() - 1024.0), tformedy(), tformedz(), local10\Field1\Field3, $00)
                        hideentity(local10\Field13)
                        positionentity(local10\Field13, tformedx(), entityy(local10\Field13, $00), tformedz(), $01)
                        showentity(local10\Field13)
                        local2 = $01
                    ElseIf (-730.0 > tformedx()) Then
                        updateworld(1.0)
                        tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field3)
                        For local1 = $01 To $02 Step $01
                            local10\Field1\Field29[(local1 + $02)]\Field5 = local10\Field1\Field29[local1]\Field5
                            local10\Field1\Field29[(local1 + $02)]\Field7 = local10\Field1\Field29[local1]\Field7
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field0, entityx(local10\Field1\Field29[local1]\Field0, $00), entityy(local10\Field1\Field29[local1]\Field0, $00), entityz(local10\Field1\Field29[local1]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field1, entityx(local10\Field1\Field29[local1]\Field1, $00), entityy(local10\Field1\Field29[local1]\Field1, $00), entityz(local10\Field1\Field29[local1]\Field1, $00), $00)
                            local10\Field1\Field29[local1]\Field5 = $00
                            local10\Field1\Field29[local1]\Field7 = 0.0
                            positionentity(local10\Field1\Field29[local1]\Field0, entityx(local10\Field1\Field29[$00]\Field0, $00), entityy(local10\Field1\Field29[$00]\Field0, $00), entityz(local10\Field1\Field29[$00]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[local1]\Field1, entityx(local10\Field1\Field29[$00]\Field1, $00), entityy(local10\Field1\Field29[$00]\Field1, $00), entityz(local10\Field1\Field29[$00]\Field1, $00), $00)
                        Next
                        tformpoint((tformedx() + 1024.0), tformedy(), tformedz(), local10\Field1\Field3, $00)
                        hideentity(local10\Field13)
                        positionentity(local10\Field13, tformedx(), entityy(local10\Field13, $00), tformedz(), $01)
                        showentity(local10\Field13)
                        local2 = $01
                    EndIf
                    If (local2 = $01) Then
                        local10\Field2 = (local10\Field2 + 1.0)
                        For local12 = Each items
                            If (25.0 > entitydistancesquared(local12\Field2, local10\Field13)) Then
                                tformpoint(entityx(local12\Field2, $00), entityy(local12\Field2, $00), entityz(local12\Field2, $00), $00, local10\Field1\Field3)
                                local21 = tformedx()
                                local22 = tformedy()
                                local23 = tformedz()
                                If (264.0 < tformedx()) Then
                                    tformpoint((local21 - 1024.0), local22, local23, local10\Field1\Field3, $00)
                                    positionentity(local12\Field2, tformedx(), tformedy(), tformedz(), $00)
                                    resetentity(local12\Field2)
                                ElseIf (-264.0 > tformedx()) Then
                                    tformpoint((local21 + 1024.0), local22, local23, local10\Field1\Field3, $00)
                                    positionentity(local12\Field2, tformedx(), tformedy(), tformedz(), $00)
                                    resetentity(local12\Field2)
                                EndIf
                            EndIf
                        Next
                        If (rand($0A, $01) = $01) Then
                            local2 = rand($00, $02)
                            playsound_strict(ambientsfx(local2, rand($00, (ambientsfxamount(local2) - $01))))
                        EndIf
                    ElseIf (local10\Field1\Field32[$00] <> Null) Then
                        If (9.0 > entitydistancesquared(local10\Field13, local10\Field1\Field32[$00]\Field4)) Then
                            If (entityinview(local10\Field1\Field32[$00]\Field0, camera) <> 0) Then
                                currcamerazoom = ((sin(((Float millisecs()) / 20.0)) + 1.0) * 15.0)
                                heartbeatvolume = max(curvevalue(0.3, heartbeatvolume, 2.0), heartbeatvolume)
                                heartbeatrate = max(heartbeatrate, 120.0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $21,$20
                If ((Float millisecs()) > local10\Field2) Then
                    If (playerzone > $00) Then
                        If (0.0 < entitypitch(local10\Field1\Field28[$00], $01)) Then
                            For local15 = Each securitycams
                                If ((((local15\Field22 = $00) And (local15\Field20\Field8\Field11 <> "room106")) And (local15\Field20\Field8\Field11 <> "room205")) <> 0) Then
                                    local15\Field22 = $02
                                EndIf
                                If (local15\Field20 = local10\Field1) Then
                                    local15\Field7 = $01
                                EndIf
                            Next
                        Else
                            For local15 = Each securitycams
                                If (local15\Field22 <> $01) Then
                                    local15\Field22 = $00
                                EndIf
                                If (local15\Field20 = local10\Field1) Then
                                    local15\Field7 = $00
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local10\Field2 = (Float (millisecs() + $BB8))
                EndIf
                If (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    coffindistance = entitydistance(local10\Field13, local10\Field1\Field25[$01])
                    If (1.5 > coffindistance) Then
                        If ((((contained106 = $00) And (local10\Field0 = "coffin106")) And (0.0 = local10\Field3)) <> 0) Then
                            local30 = createdecal($00, entityx(local10\Field1\Field25[$01], $01), -5.980469, entityz(local10\Field1\Field25[$01], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local30\Field2 = 0.05
                            local30\Field1 = 0.001
                            entityalpha(local30\Field0, 0.8)
                            updatedecals()
                            local10\Field3 = 1.0
                        EndIf
                    EndIf
                    If (wearingnightvision > $00) Then
                        local71 = $00
                        For local1 = $00 To $09 Step $01
                            If (inventory(local1) <> Null) Then
                                If (((((wearingnightvision = $01) And (inventory(local1)\Field1\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field1\Field2 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field1\Field2 = "finenvgoggles"))) <> 0) Then
                                    If (((0.0 < inventory(local1)\Field13) Or (wearingnightvision = $03)) <> 0) Then
                                        local71 = $01
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If ((((4.0 > coffindistance) And local71) And (wearing714 = $00)) <> 0) Then
                            local72 = point_direction(entityx(local10\Field13, $01), entityz(local10\Field13, $01), entityx(local10\Field1\Field25[$01], $01), entityz(local10\Field1\Field25[$01], $01))
                            local73 = entityyaw(local10\Field13, $00)
                            local74 = angledist(((local72 + 90.0) + sin(wrapangle((local10\Field4 / 10.0)))), local73)
                            turnentity(local10\Field13, 0.0, (local74 / 4.0), 0.0, $01)
                            local72 = (Abs point_distance(entityx(local10\Field13, $01), entityz(local10\Field13, $01), entityx(local10\Field1\Field25[$01], $01), entityz(local10\Field1\Field25[$01], $01)))
                            local73 = (min(max(((2.0 - local72) / 2.0), 0.0), 1.0) * -60.0)
                            user_camera_pitch = ((user_camera_pitch * 0.8) + (local73 * 0.2))
                            sanity = (sanity - ((fpsfactor * 1.1) / (Float wearingnightvision)))
                            restoresanity = $00
                            blurtimer = (sin((Float (millisecs() / $0A))) * (Abs sanity))
                            If (0.0 > vomittimer) Then
                                restoresanity = $00
                                sanity = -1010.0
                            EndIf
                            If (-1000.0 > sanity) Then
                                If (wearingnightvision > $01) Then
                                    deathmsg = (chr($22) + "Class D viewed SCP-895 through a pair of digital night vision goggles, presumably enhanced by SCP-914. It might be possible that the subject ")
                                    deathmsg = ((deathmsg + "was able to resist the memetic effects partially through these goggles. The goggles have been stored for further study.") + chr($22))
                                Else
                                    deathmsg = ((chr($22) + "Class D viewed SCP-895 through a pair of digital night vision goggles, killing him.") + chr($22))
                                EndIf
                                entitytexture(nvoverlay, nvtexture, $00, $00)
                                If (-10.0 > vomittimer) Then
                                    kill("was killed by SCP-895", $00)
                                EndIf
                            ElseIf (-800.0 > sanity) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(nvoverlay, nvtexture, $00, $00)
                                EndIf
                                If (rand($06, $01) < $05) Then
                                    entitytexture(nvoverlay, gorepics(rand($00, $05)), $00, $00)
                                    For local1 = $00 To $09 Step $01
                                        If (inventory(local1) <> Null) Then
                                            If (((((wearingnightvision = $01) And (inventory(local1)\Field1\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field1\Field2 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field1\Field2 = "finenvgoggles"))) <> 0) Then
                                                If (1.0 = inventory(local1)\Field14) Then
                                                    playsound_strict(horrorsfx($01))
                                                EndIf
                                                inventory(local1)\Field14 = 2.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                blurtimer = 1000.0
                                If (0.0 = vomittimer) Then
                                    vomittimer = 1.0
                                EndIf
                            ElseIf (-500.0 > sanity) Then
                                If (rand($07, $01) = $01) Then
                                    entitytexture(nvoverlay, nvtexture, $00, $00)
                                EndIf
                                If (rand($32, $01) = $01) Then
                                    entitytexture(nvoverlay, gorepics(rand($00, $05)), $00, $00)
                                    For local1 = $00 To $09 Step $01
                                        If (inventory(local1) <> Null) Then
                                            If (((((wearingnightvision = $01) And (inventory(local1)\Field1\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field1\Field2 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field1\Field2 = "finenvgoggles"))) <> 0) Then
                                                If (0.0 = inventory(local1)\Field14) Then
                                                    playsound_strict(horrorsfx($00))
                                                EndIf
                                                inventory(local1)\Field14 = 1.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            Else
                                entitytexture(nvoverlay, nvtexture, $00, $00)
                                For local1 = $00 To $09 Step $01
                                    If (inventory(local1) <> Null) Then
                                        If (((((wearingnightvision = $01) And (inventory(local1)\Field1\Field2 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field1\Field2 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field1\Field2 = "finenvgoggles"))) <> 0) Then
                                            inventory(local1)\Field14 = 0.0
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        EndIf
                    EndIf
                    If (0.0 < local10\Field4) Then
                        local10\Field4 = max((local10\Field4 - fpsfactor), 0.0)
                    EndIf
                    If (0.0 = local10\Field4) Then
                        local10\Field4 = -1.0
                        entitytexture(nvoverlay, nvtexture, $00, $00)
                        If (wearingnightvision = $01) Then
                            entitycolor(nvoverlay, 0.0, 255.0, 0.0)
                        ElseIf (wearingnightvision = $02) Then
                            entitycolor(nvoverlay, 0.0, 100.0, 255.0)
                        EndIf
                    EndIf
                    shouldplay = $42
                    If (updatelever(local10\Field1\Field28[$00], $00) <> 0) Then
                        For local15 = Each securitycams
                            If (((local15\Field22 = $00) And (local15\Field20\Field8\Field11 <> "room106")) <> 0) Then
                                local15\Field22 = $02
                            EndIf
                            If (local15\Field22 = $01) Then
                                entityblend(local15\Field10, $03)
                            EndIf
                            If (local15\Field20 = local10\Field1) Then
                                local15\Field7 = $01
                            EndIf
                        Next
                    Else
                        For local15 = Each securitycams
                            If (local15\Field22 <> $01) Then
                                local15\Field22 = $00
                            EndIf
                            If (local15\Field22 = $01) Then
                                entityblend(local15\Field10, $00)
                            EndIf
                            If (local15\Field20 = local10\Field1) Then
                                local15\Field7 = $00
                            EndIf
                        Next
                    EndIf
                Else
                    coffindistance = local10\Field20
                EndIf
            Case $41
                If (playerinroom(local10) <> 0) Then
                    local10\Field4 = (Float updatelever(local10\Field1\Field28[$00], $00))
                    If (1.0 = local10\Field4) Then
                        updatecheckpointmonitors($00)
                        If (50.0 > monitortimer) Then
                            entitytexture(local10\Field1\Field25[$14], local10\Field1\Field37[$00], $01, $00)
                        Else
                            entitytexture(local10\Field1\Field25[$14], local10\Field1\Field37[$00], $02, $00)
                        EndIf
                    Else
                        turncheckpointmonitorsoff($00)
                        entitytexture(local10\Field1\Field25[$14], local10\Field1\Field37[$00], $00, $00)
                    EndIf
                    If (((1.0 < (Abs (entityy(local10\Field1\Field29[$00]\Field2, $00) - local26))) And (playerroom = local10\Field1)) <> 0) Then
                        For local1 = $00 To $0E Step $01
                            If (((local10\Field1\Field25[local1] <> $00) And (local1 <> $07)) <> 0) Then
                                showentity(local10\Field1\Field25[local1])
                            EndIf
                        Next
                        For local15 = Each securitycams
                            If (local15\Field20 = local10\Field1) Then
                                If (local15\Field4 <> $00) Then
                                    showentity(local15\Field4)
                                EndIf
                                If (local15\Field10 <> $00) Then
                                    showentity(local15\Field10)
                                EndIf
                                Exit
                            EndIf
                        Next
                    Else
                        For local1 = $00 To $0E Step $01
                            If (((local10\Field1\Field25[local1] <> $00) And (local1 <> $07)) <> 0) Then
                                hideentity(local10\Field1\Field25[local1])
                            EndIf
                        Next
                        For local15 = Each securitycams
                            If (local15\Field20 = local10\Field1) Then
                                If (local15\Field4 <> $00) Then
                                    hideentity(local15\Field4)
                                EndIf
                                If (local15\Field10 <> $00) Then
                                    hideentity(local15\Field10)
                                EndIf
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                For local11 = Each events
                    If (local11\Field22 = $2A) Then
                        If (2.0 = local11\Field2) Then
                            entitytexture(local10\Field1\Field25[$15], local10\Field1\Field37[$00], $03, $00)
                        Else
                            entitytexture(local10\Field1\Field25[$15], local10\Field1\Field37[$01], $06, $00)
                        EndIf
                        Exit
                    EndIf
                Next
            Case $1C
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    If (playerinroom(local10) <> 0) Then
                        local10\Field2 = (Float (rand($12C, $3E8) * $46))
                    EndIf
                ElseIf (((((playerroom\Field8\Field11 <> "pocketdimension") And (playerroom\Field8\Field11 <> "room860")) And (playerroom\Field8\Field11 <> "room1123")) And (playerroom\Field8\Field11 <> "dimension1499")) <> 0) Then
                    local10\Field2 = (local10\Field2 - fpsfactor)
                    If (1190.0 > local10\Field2) Then
                        If (1190.0 <= (local10\Field2 + fpsfactor)) Then
                            loadeventsound(local10, "SFX\SCP\682\Roar.ogg", $00)
                            local10\Field5 = playsound_strict(local10\Field7)
                        EndIf
                        If (980.0 < local10\Field2) Then
                            camerashake = 0.5
                        EndIf
                        If (((665.0 > local10\Field2) And (420.0 < local10\Field2)) <> 0) Then
                            camerashake = 2.0
                        EndIf
                        If (70.0 > local10\Field2) Then
                            If (local10\Field7 <> $00) Then
                                freesound_strict(local10\Field7)
                            EndIf
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $2D
                If (playerinroom(local10) <> 0) Then
                    If (local10\Field1\Field29[$02]\Field5 <> 0) Then
                        local10\Field3 = 1.0
                    EndIf
                    If (((1.0 = local10\Field3) And (playerroom = local10\Field1)) <> 0) Then
                        shouldplay = $16
                    EndIf
                    entitypick(camera, 1.0)
                    If (pickedentity() = local10\Field1\Field25[$00]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field25[$00]
                        EndIf
                    ElseIf (pickedentity() = local10\Field1\Field25[$01]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field25[$01]
                        EndIf
                    EndIf
                    If (0.0 = local10\Field2) Then
                        If ((mousedown1 Or mousehit1) <> 0) Then
                            If (grabbedentity <> $00) Then
                                If (grabbedentity = local10\Field1\Field25[$00]) Then
                                    If (0.0 = local10\Field2) Then
                                        drawhandicon = $01
                                        turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                        local24 = wrapangle(entityroll(local10\Field1\Field25[$00], $00))
                                        If (181.0 < local24) Then
                                            drawarrowicon($03) = $01
                                        EndIf
                                        drawarrowicon($01) = $01
                                        If (90.0 > local24) Then
                                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 361.0, $00)
                                        ElseIf (180.0 > local24) Then
                                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 180.0, $00)
                                        EndIf
                                    EndIf
                                ElseIf (grabbedentity = local10\Field1\Field25[$01]) Then
                                    If (0.0 = local10\Field2) Then
                                        drawhandicon = $01
                                        turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                        local24 = wrapangle(entityroll(local10\Field1\Field25[$01], $00))
                                        drawarrowicon($03) = $01
                                        drawarrowicon($01) = $01
                                        If (90.0 < local24) Then
                                            If (180.0 > local24) Then
                                                rotateentity(local10\Field1\Field25[$01], 0.0, 0.0, 90.0, $00)
                                            ElseIf (270.0 > local24) Then
                                                rotateentity(local10\Field1\Field25[$01], 0.0, 0.0, 270.0, $00)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Else
                            grabbedentity = $00
                        EndIf
                        local24 = wrapangle(entityroll(local10\Field1\Field25[$00], $00))
                        If (90.0 > local24) Then
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 361.0, $00)
                        ElseIf (180.0 > local24) Then
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 180.0, $00)
                        EndIf
                        If (((181.0 > local24) And (90.0 < local24)) <> 0) Then
                            For local12 = Each items
                                If (((local12\Field2 <> $00) And (local12\Field16 = $00)) <> 0) Then
                                    If (200.0 > (Abs (entityx(local12\Field2, $00) - (local10\Field1\Field4 - 2.78125)))) Then
                                        If (104.0 > (Abs (entityy(local12\Field2, $00) - (local10\Field1\Field5 + 2.53125)))) Then
                                            local10\Field2 = 1.0
                                            local10\Field5 = playsound2(machinesfx, camera, local10\Field1\Field25[$01], 10.0, 1.0)
                                            local10\Field1\Field29[$01]\Field16 = playsound2(loadtempsound("SFX\SCP\914\DoorClose.ogg"), camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local75 = ""
                    local24 = wrapangle(entityroll(local10\Field1\Field25[$01], $00))
                    If (22.5 > local24) Then
                        local24 = 0.0
                        local75 = "1:1"
                    ElseIf (67.5 > local24) Then
                        local24 = 40.0
                        local75 = "coarse"
                    ElseIf (180.0 > local24) Then
                        local24 = 90.0
                        local75 = "rough"
                    ElseIf (337.5 < local24) Then
                        local24 = -1.0
                        local75 = "1:1"
                    ElseIf (292.5 < local24) Then
                        local24 = -40.0
                        local75 = "fine"
                    Else
                        local24 = -90.0
                        local75 = "very fine"
                    EndIf
                    rotateentity(local10\Field1\Field25[$01], 0.0, 0.0, curvevalue(local24, entityroll(local10\Field1\Field25[$01], $00), 20.0), $00)
                    For local1 = $00 To $01 Step $01
                        If (grabbedentity = local10\Field1\Field25[local1]) Then
                            If (entityinview(local10\Field1\Field25[local1], camera) = $00) Then
                                grabbedentity = $00
                            ElseIf (1.0 < entitydistancesquared(local10\Field1\Field25[local1], camera)) Then
                                grabbedentity = $00
                            EndIf
                        EndIf
                    Next
                    If (0.0 < local10\Field2) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        local10\Field1\Field29[$01]\Field5 = $00
                        If (140.0 < local10\Field2) Then
                            If (local10\Field1\Field29[$00]\Field5 = $01) Then
                                local10\Field1\Field29[$00]\Field16 = playsound2(loadtempsound("SFX\SCP\914\DoorClose.ogg"), camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                            EndIf
                            local10\Field1\Field29[$00]\Field5 = $00
                        EndIf
                        If ((1.0 / 1.505882) > distance(local25, local27, entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))) Then
                            If (((local75 = "rough") Or (local75 = "coarse")) <> 0) Then
                                If (((182.0 < local10\Field2) And (182.0 > (local10\Field2 - fpsfactor2))) <> 0) Then
                                    playsound_strict(death914sfx)
                                    multiplayer_writesound(death914sfx, local25, local26, local27, 3.0, 1.0)
                                EndIf
                            EndIf
                            If (210.0 < local10\Field2) Then
                                Select local75
                                    Case "rough"
                                        blinktimer = -10.0
                                        If (local10\Field5 <> $00) Then
                                            stopchannel(local10\Field5)
                                        EndIf
                                        deathmsg = (chr($22) + "A heavily mutilated corpse found inside the output booth of SCP-914. DNA testing identified the corpse as Class D Subject D-9341. ")
                                        deathmsg = (((((((((deathmsg + "The subject had obviously been ") + chr($22)) + "refined") + chr($22)) + " by SCP-914 on the ") + chr($22)) + "Rough") + chr($22)) + " setting, but we are still confused as to how he ")
                                        deathmsg = ((deathmsg + "ended up inside the intake booth and who or what wound the key.") + chr($22))
                                    Case "coarse"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - fpsfactor2)) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                    Case "1:1"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - fpsfactor2)) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                    Case "fine","very fine"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - fpsfactor2)) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                End Select
                            EndIf
                        EndIf
                        If (420.0 < local10\Field2) Then
                            rotateentity(local10\Field1\Field25[$00], entitypitch(local10\Field1\Field25[$00], $00), entityyaw(local10\Field1\Field25[$00], $00), curveangle(0.0, entityroll(local10\Field1\Field25[$00], $00), 10.0), $00)
                        Else
                            rotateentity(local10\Field1\Field25[$00], entitypitch(local10\Field1\Field25[$00], $00), entityyaw(local10\Field1\Field25[$00], $00), 180.0, $00)
                        EndIf
                        If (840.0 < local10\Field2) Then
                            For local12 = Each items
                                If (((local12\Field2 <> $00) And (local12\Field16 = $00)) <> 0) Then
                                    If (0.703125 > distance(entityx(local12\Field2, $00), entityz(local12\Field2, $00), entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))) Then
                                        use914(local12, local75, entityx(local10\Field1\Field25[$03], $01), entityy(local10\Field1\Field25[$03], $01), entityz(local10\Field1\Field25[$03], $01))
                                    EndIf
                                EndIf
                            Next
                            If ((((1.0 / 1.505882) > distance(local25, local27, entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))) And (multiplayer_isascp(myplayer\Field49) = $00)) <> 0) Then
                                blurtimer = 1000.0
                                positionentity(collider, entityx(local10\Field1\Field25[$03], $01), (entityy(local10\Field1\Field25[$03], $01) + 1.0), entityz(local10\Field1\Field25[$03], $01), $00)
                                resetentity(collider)
                                multiplayer_send($01, $FFFFFFFF, $FFFFFFFF)
                                dropspeed = 0.0
                                Select local75
                                    Case "rough"
                                        kill("was killed in SCP-914", $00)
                                    Case "coarse"
                                        injuries = 4.0
                                        msg = "You notice countless small incisions all around your body. They are bleeding heavily."
                                        msgtimer = 560.0
                                    Case "1:1"
                                        invertmouse = (invertmouse = $00)
                                    Case "fine","very fine"
                                        If (multiplayer_breach_isa035(myplayer\Field49) <> 0) Then
                                            superman = $00
                                            kill("was killed in SCP-914", $00)
                                        Else
                                            superman = $01
                                        EndIf
                                End Select
                            EndIf
                            local10\Field1\Field29[$00]\Field5 = $01
                            local10\Field1\Field29[$01]\Field5 = $01
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 0.0, $00)
                            local10\Field2 = 0.0
                            local78 = loadtempsound("SFX\SCP\914\DoorOpen.ogg")
                            local10\Field1\Field29[$00]\Field16 = playsound2(local78, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                            local10\Field1\Field29[$01]\Field16 = playsound2(local78, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                        EndIf
                    EndIf
                EndIf
                updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$01], 10.0, 1.0)
            Case $36
                If (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    showentity(local10\Field1\Field3)
                    If (local10\Field1\Field25[$00] = $00) Then
                        local10\Field1\Field25[$00] = loadmesh_strict("GFX\MAP\gateatunnel.b3d", $00)
                        positionentity(local10\Field1\Field25[$00], entityx(local10\Field1\Field3, $01), entityy(local10\Field1\Field3, $01), entityz(local10\Field1\Field3, $01), $00)
                        scaleentity(local10\Field1\Field25[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        entitytype(local10\Field1\Field25[$00], $01, $00)
                        entitypickmode(local10\Field1\Field25[$00], $02, $01)
                        entityparent(local10\Field1\Field25[$00], local10\Field1\Field3, $01)
                        For local1 = $00 To local10\Field1\Field18 Step $01
                            If (local10\Field1\Field24[local1] <> $00) Then
                                entityfx(local10\Field1\Field24[local1], $09)
                            EndIf
                        Next
                        secondarylighton = 1.0
                        hidedistance = 60.0
                        rotateentity(sky[$00], 0.0, (Float local10\Field1\Field7), 0.0, $00)
                        local79 = entityx(local10\Field1\Field25[$09], $01)
                        local80 = entityz(local10\Field1\Field25[$09], $01)
                        freeentity(local10\Field1\Field25[$09])
                        local10\Field1\Field25[$09] = loadmesh_strict("GFX\map\lightgunbase.b3d", $00)
                        scaleentity(local10\Field1\Field25[$09], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        entityfx(local10\Field1\Field25[$09], $00)
                        positionentity(local10\Field1\Field25[$09], local79, (local10\Field1\Field5 + 3.875), local80, $00)
                        local10\Field1\Field25[$0A] = loadmesh_strict("GFX\map\lightgun.b3d", $00)
                        entityfx(local10\Field1\Field25[$0A], $00)
                        scaleentity(local10\Field1\Field25[$0A], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        positionentity(local10\Field1\Field25[$0A], local79, (local10\Field1\Field5 + 5.0), (local80 - 0.6875), $01)
                        entityparent(local10\Field1\Field25[$0A], local10\Field1\Field25[$09], $01)
                        rotateentity(local10\Field1\Field25[$09], 0.0, 48.0, 0.0, $00)
                        rotateentity(local10\Field1\Field25[$0A], 40.0, 0.0, 0.0, $00)
                        resetentity(local10\Field13)
                        local10\Field2 = 1.0
                        rotateentity(local10\Field13, 0.0, (entityyaw(local10\Field13, $00) + (Float (local10\Field1\Field7 + $B4))), 0.0, $00)
                    EndIf
                    shouldplay = $11
                    hideentity(fog)
                    camerarange(camera, 0.02, 50.0)
                    camerafogmode(camera, $01)
                    camerafogrange(camera, 1.0, sky_fogdist[$00])
                    tformvector(0.0, 0.0, 1.0, collider, $00)
                    local81 = ((tformedz() + 1.0) * 0.5)
                    local82 = ((local81 * 70.0) + 175.0)
                    local83 = ((local81 * 55.0) + 195.0)
                    local84 = ((local81 * 35.0) + 220.0)
                    camerafogcolor(landscapecamera, local82, local83, local84)
                    camerafogcolor(camera, local82, local83, local84)
                    ambientlight(160.0, 160.0, 160.0)
                    tformpoint(entityx(collider, $01), entityy(collider, $01), entityz(collider, $01), $00, local10\Field1\Field3)
                    local85 = $00
                    If (3877.0 > tformedz()) Then
                        If (600.0 > entitydistancesquared(collider, local10\Field1\Field25[$04])) Then
                            local86 = (Int entityx(local10\Field1\Field25[$04], $01))
                            local87 = (Int entityy(local10\Field1\Field25[$04], $01))
                            local88 = (Int entityz(local10\Field1\Field25[$04], $01))
                            local85 = $01
                        EndIf
                        If (130.0 > entitydistancesquared(collider, local10\Field1\Field25[$1B])) Then
                            local86 = (Int entityx(local10\Field1\Field25[$1B], $01))
                            local87 = (Int entityy(local10\Field1\Field25[$1B], $01))
                            local88 = (Int entityz(local10\Field1\Field25[$1B], $01))
                            local85 = $01
                        EndIf
                    Else
                        local85 = $01
                        local86 = (Int entityx(camera, $01))
                        local87 = (Int entityy(camera, $01))
                        local88 = (Int entityz(camera, $01))
                    EndIf
                    If (local85 <> 0) Then
                        If (particleamount > $00) Then
                            local89 = ((Float local10\Field1\Field7) + 90.0)
                            For local1 = $01 To $03 Step $01
                                local7 = createparticle((rnd(-8.0, 8.0) + (Float local86)), (rnd(-0.5, 2.5) + (Float local87)), (rnd(-8.0, 8.0) + (Float local88)), $09, rnd(0.004, 0.012), 0.0, $78, 1.0, $01)
                                local7\Field6 = rnd(0.04, 0.08)
                                local7\Field13 = -0.00005
                                local90 = (Int rnd(-25.0, 25.0))
                                If (rand($00, $0A) = $0A) Then
                                    local90 = (rand($FFFFFFFF, $01) * local90)
                                Else
                                    local90 = $00
                                EndIf
                                rotateentity(local7\Field1, rnd(5.0, 15.0), (local89 + (Float local90)), 0.0, $00)
                            Next
                        EndIf
                    EndIf
                    hidedistance = 65.0
                    secondarylighton = 1.0
                    For local11 = Each events
                        If (local11\Field22 = $35) Then
                            local10\Field1\Field29[$01]\Field27 = updateelevators(local10\Field1\Field29[$01]\Field27, local10\Field1\Field29[$01], local11\Field1\Field29[$00], local11\Field1\Field25[$01], local11\Field1\Field25[$00], $00)
                            Exit
                        EndIf
                    Next
                ElseIf (exit1event <> Null) Then
                    If (((playerroom <> exit1event\Field1) And (0.0 <> local10\Field2)) <> 0) Then
                        If (overlaysenabled <> 0) Then
                            showentity(fog)
                        EndIf
                        ambientlight(120.0, 120.0, 120.0)
                        camerafogrange(camera, camerafognear, camerafogfar)
                        camerafogmode(camera, $01)
                        If (sky[$00] <> $00) Then
                            hideentity(sky[$00])
                        EndIf
                    EndIf
                EndIf
            Case $1E
                local2 = $01
                If (((245.0 < local10\Field3) And (6300.0 > local10\Field3)) <> 0) Then
                    local2 = $00
                EndIf
                If (((local2 And (((entityy(local10\Field1\Field3, $01) < entityy(local10\Field13, $01)) And (player[local10\Field14]\Field31 = $00)) Or ((entityy(local10\Field1\Field3, $01) < entityy(collider, $01)) And (player_isdead() = $00)))) And (((4.0 > entityy(local10\Field13, $01)) And (player[local10\Field14]\Field31 = $00)) Or ((4.0 > entityy(collider, $01)) And (player_isdead() = $00)))) <> 0) Then
                    If (local10\Field7 = $00) Then
                        local10\Field7 = loadsound_strict("SFX\Room\Tesla\Shock.ogg")
                    EndIf
                    If (0.0 = local10\Field2) Then
                        hideentity(local10\Field1\Field25[$03])
                        If ((millisecs() Mod $5DC) < $320) Then
                            showentity(local10\Field1\Field25[$04])
                        Else
                            hideentity(local10\Field1\Field25[$04])
                        EndIf
                        If (10.0 > local10\Field20) Then
                            If (local10\Field5 = $00) Then
                                local10\Field5 = playsound2(teslaidlesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                            ElseIf (channelplaying(local10\Field5) = $00) Then
                                local10\Field5 = playsound2(teslaidlesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                            EndIf
                            For local1 = $00 To $02 Step $01
                                If (1.171875 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) Then
                                    If (0.0 <= killtimer) Then
                                        playersoundvolume = max(8.0, playersoundvolume)
                                        stopchannel(local10\Field5)
                                        local10\Field5 = playsound2(teslaactivatesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                                        local10\Field2 = 1.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        Else
                            hideentity(local10\Field1\Field25[$04])
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        If (40.0 >= local10\Field2) Then
                            hideentity(local10\Field1\Field25[$03])
                            If ((millisecs() Mod $64) < $32) Then
                                showentity(local10\Field1\Field25[$04])
                            Else
                                hideentity(local10\Field1\Field25[$04])
                            EndIf
                        Else
                            If (40.0 >= (local10\Field2 - fpsfactor)) Then
                                playsound2(local10\Field7, camera, local10\Field1\Field25[$02], 10.0, 1.0)
                            EndIf
                            If (70.0 > local10\Field2) Then
                                If (0.0 <= killtimer) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((((1.0 / 1.024) > distance3(local25, local26, local27, entityx(local10\Field1\Field25[local1], $01), entityy(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) And (player_isdead() = $00)) <> 0) Then
                                            showentity(light)
                                            lightflash = 0.4
                                            camerashake = 5.0
                                            blurtimer = 200.0
                                            myplayer\Field68 = (myplayer\Field68 - (5.0 * fpsfactor))
                                            multiplayer_requesthealthreduce((Int (5.0 * fpsfactor)), "was killed by tesla")
                                        EndIf
                                    Next
                                EndIf
                                hideentity(local10\Field1\Field25[$03])
                                hideentity(local10\Field1\Field25[$04])
                                If (rand($05, $01) < $05) Then
                                    positiontexture(teslatexture, 0.0, rnd(0.0, 1.0))
                                    showentity(local10\Field1\Field25[$03])
                                EndIf
                            Else
                                If (70.0 > (local10\Field2 - fpsfactor)) Then
                                    stopchannel(local10\Field5)
                                    local10\Field5 = playsound2(teslapowerupsfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                                EndIf
                                hideentity(local10\Field1\Field25[$03])
                                If (150.0 < local10\Field2) Then
                                    local10\Field2 = 0.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideentity(local10\Field1\Field25[$04])
                EndIf
            Case $35
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    local10\Field1\Field29[$01]\Field4 = $00
                    If (16.0 > entitydistancesquared(collider, local10\Field1\Field25[$01])) Then
                        If (networkserver\Field15 <> 0) Then
                            gateaevent\Field1\Field29[$01]\Field4 = $01
                        EndIf
                        playerroom = gateaevent\Field1
                    EndIf
                EndIf
                local10\Field1\Field29[$00]\Field27 = updateelevators(local10\Field1\Field29[$00]\Field27, local10\Field1\Field29[$00], gateaevent\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
            Case $37
                local10\Field24 = $00
                If (((playerroom = local10\Field1) And (4.0625 < local26)) <> 0) Then
                    If (local10\Field1\Field25[$17] = $00) Then
                        local3 = createpivot($00)
                        positionentity(local3, entityx(local10\Field1\Field25[$00], $01), entityy(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01), $00)
                        local10\Field1\Field25[$17] = loadmesh_strict("GFX\map\exit1terrain.b3d", local10\Field1\Field3)
                        entityfx(local10\Field1\Field25[$17], $02)
                        scaleentity(local10\Field1\Field25[$17], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                        rotateentity(local10\Field1\Field25[$17], 0.0, (Float local10\Field1\Field7), 0.0, $01)
                        positionentity(local10\Field1\Field25[$17], entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $01)
                        freeentity(local3)
                        rotateentity(sky[$00], 0.0, (Float (local10\Field1\Field7 - $5A)), 0.0, $00)
                    EndIf
                    hideentity(fog)
                    camerarange(camera, 0.02, 60.0)
                    camerafogrange(camera, 1.0, sky_fogdist[$00])
                    camerafogmode(camera, $01)
                    tformvector(0.0, 0.0, 1.0, collider, $00)
                    local91 = ((tformedz() + 1.0) * 0.5)
                    local92 = ((local91 * 70.0) + 175.0)
                    local93 = ((local91 * 55.0) + 195.0)
                    local94 = ((local91 * 35.0) + 220.0)
                    camerafogcolor(landscapecamera, local92, local93, local94)
                    camerafogcolor(camera, local92, local93, local94)
                    ambientlight(160.0, 160.0, 160.0)
                    If (550.0 >= entitydistancesquared(collider, local10\Field1\Field29[$01]\Field0)) Then
                        local86 = (Int entityx(local10\Field1\Field25[$1C], $01))
                        local87 = (Int entityy(local10\Field1\Field25[$1C], $01))
                        local88 = (Int entityz(local10\Field1\Field25[$1C], $01))
                    ElseIf (21.0 >= entitydistancesquared(collider, local10\Field1\Field29[$05]\Field0)) Then
                        local86 = (Int entityx(local10\Field1\Field25[$1D], $01))
                        local87 = (Int entityy(local10\Field1\Field25[$1D], $01))
                        local88 = (Int entityz(local10\Field1\Field25[$1D], $01))
                    Else
                        local86 = (Int entityx(camera, $01))
                        local87 = (Int entityy(camera, $01))
                        local88 = (Int entityz(camera, $01))
                    EndIf
                    If (particleamount > $00) Then
                        local89 = ((Float local10\Field1\Field7) + 90.0)
                        For local1 = $01 To $03 Step $01
                            local7 = createparticle((rnd(-8.0, 8.0) + (Float local86)), (rnd(-0.5, 2.5) + (Float local87)), (rnd(-8.0, 8.0) + (Float local88)), $09, rnd(0.004, 0.012), 0.0, $78, 1.0, $01)
                            local7\Field6 = rnd(0.04, 0.08)
                            local7\Field13 = -0.00005
                            local90 = (Int rnd(-25.0, 25.0))
                            If (rand($00, $0A) = $0A) Then
                                local90 = (rand($FFFFFFFF, $01) * local90)
                            Else
                                local90 = $00
                            EndIf
                            rotateentity(local7\Field1, rnd(5.0, 15.0), (local89 + (Float local90)), 0.0, $00)
                        Next
                    EndIf
                    secondarylighton = 1.0
                    hidedistance = 60.0
                    shouldplay = $11
                    updatebutton(local10\Field1\Field25[$16])
                    If (((closestbutton = local10\Field1\Field25[$16]) And mousehit1) <> 0) Then
                        udp_bytestreamwritechar(local95)
                        If (iscoopmode() <> 0) Then
                            udp_writebyte(networkserver\Field20)
                            udp_sendmessage($00)
                        EndIf
                    EndIf
                ElseIf (((playerroom <> gateaevent\Field1) And (0.0 <> local10\Field2)) <> 0) Then
                    If (networkserver\Field14 = $00) Then
                        If (overlaysenabled <> 0) Then
                            showentity(fog)
                        EndIf
                        ambientlight(120.0, 120.0, 120.0)
                        camerafogrange(camera, camerafognear, camerafogfar)
                        camerafogmode(camera, $01)
                    EndIf
                    If (sky[$00] <> $00) Then
                        hideentity(sky[$00])
                    EndIf
                EndIf
                local10\Field1\Field29[$04]\Field4 = $00
                local10\Field1\Field29[$00]\Field27 = updateelevators(local10\Field1\Field29[$00]\Field27, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$08], local10\Field1\Field25[$09], $01)
            Case $3F
                If (playerroom = local10\Field1) Then
                    grabbedentity = $00
                    local10\Field2 = 0.0
                    local96 = $01
                    local97 = createpivot(local10\Field1\Field3)
                    positionentity(local97, 976.0, 128.0, -640.0, $00)
                    For local12 = Each items
                        If (local12\Field16 = $00) Then
                            If (0.56 > entitydistancesquared(local12\Field2, local10\Field1\Field25[$00])) Then
                                local96 = $00
                            EndIf
                        EndIf
                    Next
                    If ((((0.56 > entitydistancesquared(local10\Field1\Field25[$00], collider)) And local96) And (multiplayer_isascp(myplayer\Field49) = $00)) <> 0) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field25[$00]
                        EndIf
                    EndIf
                    If (grabbedentity <> $00) Then
                        local10\Field3 = (Float rand($00, $09))
                        If (inventory((Int local10\Field3)) <> Null) Then
                            local10\Field4 = 1.0
                        Else
                            For local1 = $00 To $09 Step $01
                                local98 = (inventory((Int ((local10\Field3 + (Float local1)) Mod 10.0))) = Null)
                                If (local98 = $00) Then
                                    local10\Field3 = ((local10\Field3 + (Float local1)) Mod 10.0)
                                EndIf
                                If (rand($08, $01) = $01) Then
                                    If (local98 <> 0) Then
                                        local10\Field4 = 3.1
                                    Else
                                        local10\Field4 = 3.0
                                    EndIf
                                    local10\Field2 = (Float rand($01, $05))
                                    local99 = ""
                                    Select local10\Field2
                                        Case 1.0
                                            local99 = "Lost Key"
                                        Case 2.0
                                            local99 = "Disciplinary Hearing DH-S-4137-17092"
                                        Case 3.0
                                            local99 = "Coin"
                                        Case 4.0
                                            local99 = "Movie Ticket"
                                        Case 5.0
                                            local99 = "Old Badge"
                                    End Select
                                    local101 = $00
                                    For local12 = Each items
                                        If (local12\Field0 = local99) Then
                                            local101 = $01
                                            local10\Field4 = 1.0
                                            local10\Field2 = 0.0
                                            Exit
                                        EndIf
                                    Next
                                    If (((local101 = $00) And (local98 = $00)) <> 0) Then
                                        Exit
                                    EndIf
                                ElseIf (local98 <> 0) Then
                                    local10\Field4 = 2.0
                                Else
                                    local10\Field4 = 1.0
                                    Exit
                                EndIf
                            Next
                        EndIf
                        If (1.0 = local10\Field4) Then
                            local102 = $00
                            For local103 = Each itemtemplates
                                If (isitemgoodfor1162(local103) <> 0) Then
                                    Select inventory((Int local10\Field3))\Field1\Field2
                                        Case "key"
                                            If (((local103\Field2 = "key1") Or ((local103\Field2 = "key2") And (rand($02, $01) = $01))) <> 0) Then
                                                local102 = $01
                                            EndIf
                                        Case "paper","oldpaper"
                                            If (((local103\Field2 = "paper") And (rand($0C, $01) = $01)) <> 0) Then
                                                local102 = $01
                                            EndIf
                                        Case "gasmask","gasmask3","supergasmask","hazmatsuit","hazmatsuit2","hazmatsuit3"
                                            If (((((((local103\Field2 = "gasmask") Or (local103\Field2 = "gasmask3")) Or (local103\Field2 = "supergasmask")) Or (local103\Field2 = "hazmatsuit")) Or (local103\Field2 = "hazmatsuit2")) Or ((local103\Field2 = "hazmatsuit3") And (rand($02, $01) = $01))) <> 0) Then
                                                local102 = $01
                                            EndIf
                                        Case "key1","key2","key3"
                                            If (((((local103\Field2 = "key1") Or (local103\Field2 = "key2")) Or (local103\Field2 = "key3")) Or ((local103\Field2 = "misc") And (rand($06, $01) = $01))) <> 0) Then
                                                local102 = $01
                                            EndIf
                                        Case "vest","finevest"
                                            If (((local103\Field2 = "vest") Or ((local103\Field2 = "finevest") And (rand($01, $01) = $01))) <> 0) Then
                                                local102 = $01
                                            EndIf
                                        Default
                                            If (((local103\Field2 = "misc") And (rand($06, $01) = $01)) <> 0) Then
                                                local102 = $01
                                            EndIf
                                    End Select
                                EndIf
                                If (local102 <> 0) Then
                                    removeitem(inventory((Int local10\Field3)), $01)
                                    local12 = createitem(local103\Field1, local103\Field2, entityx(local97, $01), entityy(local97, $01), entityz(local97, $01), $00, $00, $00, 1.0, $00, $01)
                                    entitytype(local12\Field2, $03, $00)
                                    playsound_strict(loadtempsound((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg")))
                                    local10\Field4 = 0.0
                                    multiplayer_writetempsound((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg"), local25, local26, local27, 10.0, 1.0)
                                    mousehit1 = $00
                                    synchronizeitem(local12)
                                    Exit
                                EndIf
                            Next
                        ElseIf (2.0 = local10\Field4) Then
                            injuries = (injuries + 5.0)
                            local3 = createpivot($00)
                            positionentity(local3, entityx(local10\Field13, $00), (entityy(local10\Field13, $00) - 0.05), entityz(local10\Field13, $00), $00)
                            turnentity(local3, 90.0, 0.0, 0.0, $00)
                            entitypick(local3, 0.3)
                            local30 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local30\Field2 = 0.75
                            scalesprite(local30\Field0, local30\Field2, local30\Field2)
                            multiplayer_writedecal(local30, $01, $01)
                            freeentity(local3)
                            For local103 = Each itemtemplates
                                If ((isitemgoodfor1162(local103) And (rand($06, $01) = $01)) <> 0) Then
                                    local12 = createitem(local103\Field1, local103\Field2, entityx(local97, $01), entityy(local97, $01), entityz(local97, $01), $00, $00, $00, 1.0, $00, $01)
                                    entitytype(local12\Field2, $03, $00)
                                    mousehit1 = $00
                                    local10\Field4 = 0.0
                                    If (15.0 < injuries) Then
                                        deathmsg = "A dead Class D subject was discovered within the containment chamber of SCP-1162."
                                        deathmsg = (deathmsg + " An autopsy revealed that his right lung was missing, which suggests")
                                        deathmsg = (deathmsg + " interaction with SCP-1162.")
                                        playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                        lightflash = 5.0
                                        kill("was killed by SCP-1162", $00)
                                    Else
                                        playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                        multiplayer_writetempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"), local25, local26, local27, 10.0, 1.0)
                                        lightflash = 5.0
                                        setmsg("You feel a sudden overwhelming pain in your chest.")
                                        msgtimer = 350.0
                                    EndIf
                                    Exit
                                EndIf
                            Next
                        ElseIf (3.0 <= local10\Field4) Then
                            If (3.1 > local10\Field4) Then
                                playsound_strict(loadtempsound((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg")))
                                multiplayer_writetempsound((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg"), local25, local26, local27, 10.0, 1.0)
                                removeitem(inventory((Int local10\Field3)), $01)
                            Else
                                injuries = (injuries + 5.0)
                                local3 = createpivot($00)
                                positionentity(local3, local25, (local26 - 0.05), local27, $00)
                                turnentity(local3, 90.0, 0.0, 0.0, $00)
                                entitypick(local3, 0.3)
                                local30 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                                local30\Field2 = 0.75
                                scalesprite(local30\Field0, local30\Field2, local30\Field2)
                                multiplayer_writedecal(local30, $01, $01)
                                freeentity(local3)
                                If (15.0 < injuries) Then
                                    deathmsg = "A dead Class D subject was discovered within the containment chamber of SCP-1162."
                                    deathmsg = (deathmsg + " An autopsy revealed that his right lung was missing, which suggests")
                                    deathmsg = (deathmsg + " interaction with SCP-1162.")
                                    playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                    multiplayer_writetempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"), local25, local26, local27, 3.0, 1.0)
                                    lightflash = 5.0
                                    kill("was killed by SCP-1162", $00)
                                Else
                                    playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                    multiplayer_writetempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"), local25, local26, local27, 3.0, 1.0)
                                    lightflash = 5.0
                                    msg = "You notice something moving in your pockets and a sudden pain in your chest."
                                    msgtimer = 350.0
                                EndIf
                                local10\Field3 = 0.0
                            EndIf
                            Select local10\Field2
                                Case 1.0
                                    local12 = createitem("Lost Key", "key", entityx(local97, $01), entityy(local97, $01), entityz(local97, $01), $00, $00, $00, 1.0, $00, $01)
                                Case 2.0
                                    local12 = createitem("Disciplinary Hearing DH-S-4137-17092", "oldpaper", entityx(local97, $01), entityy(local97, $01), entityz(local97, $01), $00, $00, $00, 1.0, $00, $01)
                                Case 3.0
                                    local12 = createitem("Coin", "coin", entityx(local97, $01), entityy(local97, $01), entityz(local97, $01), $00, $00, $00, 1.0, $00, $01)
                                Case 4.0
                                    local12 = createitem("Movie Ticket", "ticket", entityx(local97, $01), entityy(local97, $01), entityz(local97, $01), $00, $00, $00, 1.0, $00, $01)
                                Case 5.0
                                    local12 = createitem("Old Badge", "badge", entityx(local97, $01), entityy(local97, $01), entityz(local97, $01), $00, $00, $00, 1.0, $00, $01)
                            End Select
                            entitytype(local12\Field2, $03, $00)
                            mousehit1 = $00
                            local10\Field4 = 0.0
                            synchronizeitem(local12)
                        EndIf
                    EndIf
                    freeentity(local97)
                EndIf
            Case $40
                If (15.0 > local10\Field20) Then
                    local10\Field2 = 2.0
                    If (2.0 > local10\Field2) Then
                        If (0.0 = local10\Field2) Then
                            loadeventsound(local10, "SFX\Character\Scientist\EmilyScream.ogg", $00)
                            local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field25[$00], 100.0, 1.0)
                            local30 = createdecal($00, entityx(local10\Field1\Field25[$00], $01), (local10\Field1\Field5 + (1.0 / 128.0)), entityz(local10\Field1\Field25[$00], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local30\Field2 = 0.5
                            entityalpha(local30\Field0, 0.8)
                            entityfx(local30\Field0, $01)
                            local10\Field2 = 1.0
                        ElseIf (1.0 = local10\Field2) Then
                            If (channelplaying(local10\Field5) = $00) Then
                                local10\Field2 = 2.0
                                local10\Field1\Field29[$00]\Field4 = $00
                            Else
                                updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$00], 100.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        local10\Field1\Field29[$00]\Field4 = $00
                        local30 = createdecal($00, entityx(local10\Field1\Field25[$00], $01), (local10\Field1\Field5 + (1.0 / 128.0)), entityz(local10\Field1\Field25[$00], $01), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                        local30\Field2 = 0.5
                        entityalpha(local30\Field0, 0.8)
                        entityfx(local30\Field0, $01)
                        removeevent(local10)
                    EndIf
                EndIf
            Case $25
                If (((0.0 = local10\Field2) Or ((local10\Field25 = Null) And (removedecals = $00))) <> 0) Then
                    local30 = createdecal($00, (entityx(local10\Field1\Field3, $00) + rnd(-0.5, 0.5)), 0.01, (entityz(local10\Field1\Field3, $00) + rnd(-0.5, 0.5)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                    local30\Field2 = 2.5
                    local30\Field5 = 1.0
                    entityalpha(local30\Field0, 1.0)
                    scalesprite(local30\Field0, local30\Field2, local30\Field2)
                    entityfx(local30\Field0, $00)
                    local10\Field25 = local30
                    local10\Field2 = 1.0
                ElseIf (playerroom = local10\Field1) Then
                    local10\Field13 = collider
                    If (local10\Field7 = $00) Then
                        local10\Field7 = loadsound_strict("SFX\Room\Sinkhole.ogg")
                    Else
                        local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field3, 4.5, 1.5)
                    EndIf
                    local0 = distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field3, $00), entityz(local10\Field1\Field3, $00))
                    If (2.0 > local0) Then
                        currstepsfx = $01
                        currspeed = curvevalue(0.0, currspeed, max((local0 * 50.0), 1.0))
                        crouchstate = ((2.0 - local0) / 2.0)
                        If (((multiplayer_isascp(myplayer\Field49) = $00) And (player_isdead() = $00)) <> 0) Then
                            If (0.5 > local0) Then
                                If (0.0 = local10\Field3) Then
                                    playsound_strict(loadtempsound("SFX\Room\SinkholeFall.ogg"))
                                    multiplayer_writetempsound("SFX\Room\SinkholeFall.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                EndIf
                                currspeed = curvevalue(0.0, currspeed, max((local0 * 50.0), 1.0))
                                local21 = curvevalue(entityx(local10\Field1\Field3, $00), entityx(local10\Field13, $00), 5.0)
                                local22 = curvevalue((entityy(local10\Field1\Field3, $00) - local10\Field3), entityy(local10\Field13, $00), 25.0)
                                local23 = curvevalue(entityz(local10\Field1\Field3, $00), entityz(local10\Field13, $00), 5.0)
                                positionentity(local10\Field13, local21, local22, local23, $01)
                                dropspeed = 0.0
                                resetentity(local10\Field13)
                                local10\Field3 = min((local10\Field3 + (fpsfactor / 200.0)), 2.0)
                                lightblink = min((local10\Field3 * 5.0), 10.0)
                                blurtimer = (local10\Field3 * 500.0)
                                If (2.0 = local10\Field3) Then
                                    movetopocketdimension()
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    local10\Field3 = 0.0
                EndIf
            Case $38
                If (playerinroom(local10) <> 0) Then
                    If (((0.0 = local10\Field2) Or (local10\Field11 <> "loaddone")) <> 0) Then
                        If (((local10\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field11 = "load0"
                        EndIf
                        If (local10\Field1\Field25[$03] <> $00) Then
                            hideentity(local10\Field1\Field25[$03])
                            hideentity(local10\Field1\Field25[$04])
                            hideentity(local10\Field1\Field25[$05])
                            hideentity(local10\Field1\Field25[$06])
                        EndIf
                        If (local10\Field1\Field29[$01]\Field5 = $01) Then
                            local10\Field2 = 1.0
                        EndIf
                    Else
                        If (playerroom = local10\Field1) Then
                            shouldplay = $10
                        EndIf
                        If (65.0 > local10\Field2) Then
                            If (2.0 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01))) Then
                                playsound_strict(loadtempsound("SFX\SCP\205\Enter.ogg"))
                                local10\Field2 = max(local10\Field2, 65.0)
                                showentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$06])
                                setanimtime(local10\Field1\Field25[$03], 492.0, $00)
                                setanimtime(local10\Field1\Field25[$04], 434.0, $00)
                                setanimtime(local10\Field1\Field25[$05], 434.0, $00)
                                local10\Field1\Field29[$00]\Field5 = $00
                            EndIf
                            If (7.0 < local10\Field2) Then
                                If (rand($00, $12C) = $01) Then
                                    local10\Field1\Field29[$00]\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                EndIf
                            EndIf
                            local10\Field3 = (local10\Field3 + fpsfactor)
                        EndIf
                        Select local10\Field2
                            Case 1.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $20E, $212, 0.2, $01)
                                If (1400.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 3.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $179, $20D, 0.2, $01)
                                If (2100.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 5.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $E4, $178, 0.2, $01)
                                If (2800.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound2(loadtempsound("SFX\SCP\205\Horror.ogg"), camera, local10\Field1\Field25[$06], 10.0, 0.3)
                                EndIf
                            Case 7.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$05])
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $1F4, $288, 0.2, $01)
                                If (4200.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound2(loadtempsound("SFX\SCP\205\Horror.ogg"), camera, local10\Field1\Field25[$06], 10.0, 0.5)
                                EndIf
                            Case 9.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$04])
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $02, $C8, 0.2, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $04, $7D, 0.2, $01)
                                If (5600.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound_strict(loadtempsound("SFX\SCP\205\Horror.ogg"))
                                EndIf
                            Case 11.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$03])
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $02, $E2, 0.2, $01)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $02, $C8, 0.2, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $04, $7D, 0.2, $01)
                                If (5950.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 13.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$03])
                                If (227.0 <> animtime(local10\Field1\Field25[$06])) Then
                                    setanimtime(local10\Field1\Field25[$06], 227.0, $00)
                                EndIf
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $02, $1EB, 0.05, $01)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $C5, $1B1, 0.05, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $02, $1B1, 0.05, $01)
                            Case 66.0
                                showentity(local10\Field1\Field25[$01])
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $1EC, $216, 0.1, $00)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $1B2, $1D2, 0.1, $00)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $1B2, $1EE, 0.1, $00)
                                If (515.0 < animtime(local10\Field1\Field25[$03])) Then
                                    If (533.0 < animtime(local10\Field1\Field25[$03])) Then
                                        local10\Field2 = 67.0
                                        local10\Field3 = 0.0
                                        local10\Field4 = 0.0
                                        hideentity(local10\Field1\Field25[$01])
                                    EndIf
                                EndIf
                            Case 67.0
                                If (((rand($96, $01) = $01) And ((2.0 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01))) And (local10\Field13 = collider))) <> 0) Then
                                    deathmsg = "The SCP-205 cycle seems to have resumed its normal course after the anomalies observed during "
                                    deathmsg = (deathmsg + "[REDACTED]. The body of subject D-9341 was discovered inside the chamber. ")
                                    deathmsg = (deathmsg + "The subject exhibits signs of blunt force trauma typical for personnel who have ")
                                    deathmsg = (deathmsg + "entered the chamber when the lights are off.")
                                    injuries = (rnd(0.4, 0.8) + injuries)
                                    playsound_strict(damagesfx(rand($02, $03)))
                                    camerashake = 0.5
                                    local10\Field3 = rnd(-0.1, 0.1)
                                    local10\Field4 = rnd(-0.1, 0.1)
                                    If (5.0 < injuries) Then
                                        kill("was killed by SCP-205", $00)
                                    EndIf
                                EndIf
                                translateentity(local10\Field13, local10\Field3, 0.0, local10\Field4, $00)
                                local10\Field3 = curvevalue(local10\Field3, 0.0, 10.0)
                                local10\Field4 = curvevalue(local10\Field4, 0.0, 10.0)
                            Default
                                If (rand($03, $01) = $01) Then
                                    hideentity(local10\Field1\Field25[$01])
                                Else
                                    showentity(local10\Field1\Field25[$01])
                                EndIf
                                local10\Field4 = (local10\Field4 + fpsfactor)
                                If (50.0 < local10\Field4) Then
                                    showentity(local10\Field1\Field25[$01])
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    local10\Field4 = 0.0
                                EndIf
                        End Select
                    EndIf
                ElseIf (local10\Field1\Field25[$03] <> $00) Then
                    hideentity(local10\Field1\Field25[$03])
                    hideentity(local10\Field1\Field25[$04])
                    hideentity(local10\Field1\Field25[$05])
                    hideentity(local10\Field1\Field25[$06])
                Else
                    local10\Field2 = 0.0
                    local10\Field11 = ""
                EndIf
            Case $26
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        local10\Field2 = 1.0
                    EndIf
                    If (playerroom = local10\Field1) Then
                        shouldplay = $04
                    EndIf
                    If (remotedooron <> 0) Then
                        If (local10\Field1\Field29[$00]\Field5 <> 0) Then
                            If (((50.0 < local10\Field1\Field29[$00]\Field7) Or (0.25 > entitydistancesquared(local10\Field13, local10\Field1\Field29[$00]\Field2))) <> 0) Then
                                local10\Field1\Field29[$00]\Field7 = min(local10\Field1\Field29[$00]\Field7, 50.0)
                                local10\Field1\Field29[$00]\Field5 = $00
                                If (playerroom = local10\Field1) Then
                                    playsound_strict(loadtempsound("SFX\Door\DoorError.ogg"))
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (10000.0 > local10\Field2) Then
                        If (1.0 = local10\Field2) Then
                            local10\Field2 = 2.0
                        ElseIf (2.0 = local10\Field2) Then
                            If (9.0 > entitydistancesquared(local10\Field1\Field25[$00], local10\Field13)) Then
                                local10\Field2 = 3.0
                                local10\Field3 = 1.0
                                local10\Field5 = streamsound_strict("SFX\SCP\079\Speech.ogg", sfxvolume, $00)
                                local10\Field9 = $01
                            EndIf
                        ElseIf (2000.0 > local10\Field2) Then
                            If (isstreamplaying_strict(local10\Field5) <> 0) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(local10\Field1\Field25[$01], oldaipics($00), $00, $00)
                                    showentity(local10\Field1\Field25[$01])
                                ElseIf (rand($0A, $01) = $01) Then
                                    hideentity(local10\Field1\Field25[$01])
                                EndIf
                            Else
                                If (local10\Field5 <> $00) Then
                                    stopstream_strict(local10\Field5)
                                    local10\Field5 = $00
                                EndIf
                                entitytexture(local10\Field1\Field25[$01], oldaipics($01), $00, $00)
                                showentity(local10\Field1\Field25[$01])
                                local10\Field2 = (local10\Field2 + fpsfactor)
                            EndIf
                        ElseIf (6.25 > entitydistancesquared(local10\Field1\Field25[$00], local10\Field13)) Then
                            local10\Field2 = 10001.0
                            If (local10\Field5 <> $00) Then
                                stopstream_strict(local10\Field5)
                                local10\Field5 = $00
                            EndIf
                            local10\Field5 = streamsound_strict("SFX\SCP\079\Refuse.ogg", sfxvolume, $00)
                        EndIf
                    ElseIf (local10\Field5 <> $00) Then
                        If (isstreamplaying_strict(local10\Field5) = $00) Then
                            local10\Field5 = $00
                            entitytexture(local10\Field1\Field25[$01], oldaipics($01), $00, $00)
                            showentity(local10\Field1\Field25[$01])
                        ElseIf (rand($03, $01) = $01) Then
                            entitytexture(local10\Field1\Field25[$01], oldaipics($00), $00, $00)
                            showentity(local10\Field1\Field25[$01])
                        ElseIf (rand($0A, $01) = $01) Then
                            hideentity(local10\Field1\Field25[$01])
                        EndIf
                    EndIf
                EndIf
                If (1.0 = local10\Field3) Then
                    If (remotedooron <> 0) Then
                        If (local10\Field6 <> $00) Then
                            stopstream_strict(local10\Field6)
                            local10\Field6 = $00
                        EndIf
                        local10\Field6 = streamsound_strict("SFX\SCP\079\GateB.ogg", sfxvolume, $00)
                        local10\Field3 = 2.0
                        For local11 = Each events
                            If (((local11\Field0 = "exit1") Or (local11\Field0 = "gateaentrance")) <> 0) Then
                                local11\Field4 = 1.0
                            EndIf
                        Next
                    EndIf
                EndIf
            Case $0E
                If (playerinroom(local10) <> 0) Then
                    local10\Field1\Field29[$00]\Field27 = updateelevators(local10\Field1\Field29[$00]\Field27, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
                    local10\Field1\Field29[$02]\Field27 = updateelevators(local10\Field1\Field29[$02]\Field27, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $01)
                    If (-17.96875 > entityy(local10\Field13, $00)) Then
                        shouldplay = $07
                        If (0.0 = local10\Field2) Then
                            local10\Field2 = 1.0
                        EndIf
                        If (local10\Field1\Field29[$04]\Field5 = $00) Then
                            If (updatelever(local10\Field1\Field28[$00], $00) <> 0) Then
                                local10\Field1\Field29[$04]\Field5 = $01
                                If (((playerroom = local10\Field1) And (-17.96875 > local26)) <> 0) Then
                                    If (local10\Field8 <> $00) Then
                                        freesound_strict(local10\Field8)
                                        local10\Field8 = $00
                                    EndIf
                                    local10\Field8 = loadsound_strict("SFX\Door\Door2Open1_dist.ogg")
                                    local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                                EndIf
                            EndIf
                            If (updatelever(local10\Field1\Field28[$01], $00) <> 0) Then
                                local10\Field1\Field29[$04]\Field5 = $01
                                If (((playerroom = local10\Field1) And (-17.96875 > local26)) <> 0) Then
                                    If (local10\Field8 <> $00) Then
                                        freesound_strict(local10\Field8)
                                        local10\Field8 = $00
                                    EndIf
                                    local10\Field8 = loadsound_strict("SFX\Door\Door2Open1_dist.ogg")
                                    local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                                EndIf
                            EndIf
                        EndIf
                        If (channelplaying(local10\Field6) <> 0) Then
                            updatesoundorigin(local10\Field6, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                        EndIf
                        playerfallingpickdistance = 0.0
                        If (playerroom = local10\Field1) Then
                            If (godmode = $00) Then
                                If (((((-25.0 > local26) And (0.0 <= killtimer)) And (0.0 <= falltimer)) And (player_isdead() = $00)) <> 0) Then
                                    deathmsg = ""
                                    playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"))
                                    multiplayer_writetempsound("SFX\Room\PocketDimension\Impact.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                    kill("was killed", $00)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
                updatelever(local10\Field1\Field28[$00], local10\Field1\Field29[$04]\Field5)
                updatelever(local10\Field1\Field28[$01], local10\Field1\Field29[$04]\Field5)
            Case $18
                local10\Field1\Field29[$00]\Field4 = $00
                local10\Field1\Field29[$01]\Field4 = $00
            Case $0B
                If (playerinroom(local10) <> 0) Then
                    turnentity(local10\Field1\Field25[$00], (local10\Field4 * fpsfactor), 0.0, 0.0, $00)
                    If (0.01 < local10\Field4) Then
                        local10\Field1\Field10 = loopsound2(roomambience[$09], local10\Field1\Field10, camera, local10\Field1\Field25[$00], 5.0, (local10\Field4 / 4.0))
                    EndIf
                    local10\Field4 = curvevalue((local10\Field3 * 5.0), local10\Field4, 150.0)
                EndIf
                If (16.0 > local10\Field20) Then
                    If (0.0 > local10\Field2) Then
                        local10\Field2 = (Float (rand($0F, $1E) * $46))
                        local2 = (Int local10\Field3)
                        local10\Field3 = (Float rand($00, $01))
                        If (playerinroom(local10) = $00) Then
                            local10\Field4 = (local10\Field3 * 5.0)
                        ElseIf (((local2 = $00) And (1.0 = local10\Field3)) <> 0) Then
                            playsound2(loadtempsound("SFX\ambient\Room ambience\FanOn.ogg"), camera, local10\Field1\Field25[$00], 8.0, 1.0)
                        ElseIf (((local2 = $01) And (0.0 = local10\Field3)) <> 0) Then
                            playsound2(loadtempsound("SFX\ambient\Room ambience\FanOff.ogg"), camera, local10\Field1\Field25[$00], 8.0, 1.0)
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 - fpsfactor)
                    EndIf
                EndIf
            Case $01
                local10\Field1\Field26[$00] = $00
                local10\Field1\Field26[$01] = $00
                If (local10\Field1\Field29[$05] = Null) Then
                    For local1 = $00 To $03 Step $01
                        If (local10\Field1\Field35[local1] <> Null) Then
                            local10\Field1\Field29[$05] = local10\Field1\Field35[local1]
                            local10\Field1\Field29[$05]\Field5 = $01
                            Exit
                        EndIf
                    Next
                EndIf
                If (0.0 = local10\Field2) Then
                    local10\Field1\Field29[$02]\Field5 = $01
                    If (overlaysenabled <> 0) Then
                        showentity(fog)
                    EndIf
                    ambientlight(120.0, 120.0, 120.0)
                    camerafogrange(camera, camerafognear, camerafogfar)
                    camerafogmode(camera, $01)
                    If (selecteddifficulty\Field4 = $00) Then
                        msg = (("Press " + keyname(key_save)) + " to save.")
                        msgtimer = 280.0
                    ElseIf (selecteddifficulty\Field4 = $02) Then
                        msg = "Saving is only permitted on clickable monitors scattered throughout the facility."
                        msgtimer = 560.0
                    EndIf
                    While (180.0 > local10\Field1\Field29[$01]\Field7)
                        local10\Field1\Field29[$01]\Field7 = min(180.0, (local10\Field1\Field29[$01]\Field7 + 0.8))
                        moveentity(local10\Field1\Field29[$01]\Field0, (sin(local10\Field1\Field29[$01]\Field7) / 180.0), 0.0, 0.0)
                        moveentity(local10\Field1\Field29[$01]\Field1, ((- sin(local10\Field1\Field29[$01]\Field7)) / 180.0), 0.0, 0.0)
                    Wend
                    local10\Field2 = 1.0
                    local10\Field3 = 1.0
                    If (networkserver\Field15 <> 0) Then
                        If (rand($0A, $01) = $03) Then
                            For local1 = $02 To rand($02, $03) Step $01
                                local12 = createitem("Uranium Candy", "urancandy", local25, (local26 + 0.32), local27, $00, $00, $00, 1.0, $00, $01)
                                local12 = createitem("Cooked Chicken", "chicken", local25, (local26 + 0.32), local27, $00, $00, $00, 1.0, $00, $01)
                            Next
                        EndIf
                    EndIf
                Else
                    If (500.0 <= local10\Field2) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        positionentity(local10\Field1\Field25[$00], entityx(local10\Field1\Field25[$00], $01), ((- max((local10\Field2 - 1300.0), 0.0)) / 4500.0), entityz(local10\Field1\Field25[$00], $01), $01)
                        rotateentity(local10\Field1\Field25[$00], ((- max((local10\Field2 - 1320.0), 0.0)) / 130.0), 0.0, ((- max((local10\Field2 - 1300.0), 0.0)) / 40.0), $01)
                        positionentity(local10\Field1\Field25[$01], entityx(local10\Field1\Field25[$01], $01), ((- max((local10\Field2 - 1800.0), 0.0)) / 5000.0), entityz(local10\Field1\Field25[$01], $01), $01)
                        rotateentity(local10\Field1\Field25[$01], ((- max((local10\Field2 - 2040.0), 0.0)) / 135.0), 0.0, ((- max((local10\Field2 - 2040.0), 0.0)) / 43.0), $01)
                        If (6.25 > entitydistancesquared(local10\Field1\Field25[$00], local10\Field13)) Then
                            If (rand($12C, $01) = $02) Then
                                playsound2(decaysfx(rand($01, $03)), camera, local10\Field1\Field25[$00], 3.0, 1.0)
                            EndIf
                        EndIf
                    EndIf
                    If (11.0 > local10\Field4) Then
                        If (channelplaying(local10\Field6) = $00) Then
                            local10\Field4 = (local10\Field4 + 1.0)
                            If (local10\Field8 <> $00) Then
                                freesound_strict(local10\Field8)
                                local10\Field8 = $00
                            EndIf
                            local10\Field8 = loadsound_strict((("SFX\Alarm\Alarm2_" + (Str (Int local10\Field4))) + ".ogg"))
                            local10\Field6 = playsound_strict(local10\Field8)
                        ElseIf ((Int local10\Field4) = $08) Then
                            camerashake = 1.0
                        EndIf
                    EndIf
                    If (((300.0 < (local10\Field2 Mod 600.0)) And (300.0 > ((local10\Field2 + fpsfactor) Mod 600.0))) <> 0) Then
                        local1 = (Int (floor(((local10\Field2 - 5000.0) / 600.0)) + 1.0))
                        If (local1 = $00) Then
                            playsound_strict(loadtempsound("SFX\Room\Intro\PA\scripted\scripted6.ogg"))
                        EndIf
                        If (((local1 > $00) And (local1 < $1A)) <> 0) Then
                            If (commotionstate(local1) = $00) Then
                                playsound_strict(loadtempsound((("SFX\Room\Intro\Commotion\Commotion" + (Str local1)) + ".ogg")))
                                commotionstate(local1) = $01
                            EndIf
                        EndIf
                        If (local1 > $1A) Then
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
        End Select
    Next
    Return $00
End Function
