Function mp_updatenpctype049%(arg0.npcs)
    Local local0#
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    Local local6#
    Local local7.rooms
    Local local8#
    If (0.1 < arg0\Field26) Then
        If (playerroom\Field7\Field6 <> $3A) Then
            arg0\Field26 = max((arg0\Field26 - ((Float (selecteddifficulty\Field2 + $01)) * fps\Field7[$00])), 0.1)
        EndIf
        arg0\Field7 = 0.0
        If (channelplaying(arg0\Field18) <> 0) Then
            stopchannel(arg0\Field18)
            arg0\Field18 = $00
        EndIf
        If (channelplaying(arg0\Field20) <> 0) Then
            stopchannel(arg0\Field20)
            arg0\Field20 = $00
        EndIf
        positionentity(arg0\Field3, 0.0, -500.0, 0.0, $00)
        resetentity(arg0\Field3)
    Else
        local0 = arg0\Field14
        local1 = entitydistancesquared(me\Field60, arg0\Field3)
        updatenpcblinking(arg0)
        If (0.25 <= local1) Then
            remove714timer = min((fps\Field7[$00] + remove714timer), 500.0)
            removehazmattimer = min((fps\Field7[$00] + removehazmattimer), 500.0)
        ElseIf (chs\Field2 = $00) Then
            If (entityvisible(me\Field60, arg0\Field3) <> 0) Then
                If (((1.0 < arg0\Field10) And (3.0 <> arg0\Field10)) <> 0) Then
                    If (mp_getnpctargetmodel(arg0) = $02) Then
                        If (arg0\Field85 <> 0) Then
                            removehazmattimer = (removehazmattimer - (fps\Field7[$00] * 1.5))
                            If ((((350.0 > removehazmattimer) And (350.0 <= ((fps\Field7[$00] * 1.5) + removehazmattimer))) And (channelplaying(arg0\Field20) = $00)) <> 0) Then
                                arg0\Field20 = playsoundex(loadtempsound("SFX\SCP\049\TakeOffHazmat.ogg"), camera, arg0\Field3, 10.0, 1.0, $01, $00)
                            ElseIf (0.0 >= removehazmattimer) Then
                                For local2 = $00 To $02 Step $01
                                    If (((removehazmattimer < (- (((Float (wi\Field2 = $04)) * 250.0) * (Float local2)))) And ((- (((Float (wi\Field2 = $04)) * 250.0) * (Float local2))) <= ((fps\Field7[$00] * 1.5) + removehazmattimer))) <> 0) Then
                                        me\Field23 = 2.0
                                        If (local2 = $02) Then
                                            For local2 = $00 To (maxitemamount - $01) Step $01
                                                If (inventory(local2) <> Null) Then
                                                    If (((inventory(local2)\Field4\Field2 >= $3C) And (inventory(local2)\Field4\Field2 <= $3F)) <> 0) Then
                                                        createmsg(getlocalstring("msg", "suit.destroyed"), 6.0)
                                                        wi\Field2 = $00
                                                        removeitem(inventory(local2))
                                                        Exit
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        EndIf
                    ElseIf (mp_getnpctargetattach(arg0, $03) = $0D) Then
                        If (arg0\Field85 <> 0) Then
                            me\Field49 = (me\Field49 + (fps\Field7[$00] * 2.5))
                            If (i_268\Field2 <> 0) Then
                                remove714timer = min(remove714timer, 499.0)
                            Else
                                remove714timer = (remove714timer - (fps\Field7[$00] * (3.0 / (Float i_714\Field0))))
                                If ((((350.0 > remove714timer) And (350.0 <= ((fps\Field7[$00] * 1.5) + remove714timer))) And (channelplaying(arg0\Field20) = $00)) <> 0) Then
                                    If (i_714\Field0 = $02) Then
                                        arg0\Field20 = playsoundex(loadtempsound("SFX\SCP\049\714Equipped.ogg"), camera, arg0\Field3, 10.0, 1.0, $01, $00)
                                    EndIf
                                ElseIf (0.0 >= remove714timer) Then
                                    For local2 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local2) <> Null) Then
                                            If (((inventory(local2)\Field4\Field2 = $1B) Lor (inventory(local2)\Field4\Field2 = $1A)) <> 0) Then
                                                createmsg(getlocalstring("msg", "714.forceremoved"), 6.0)
                                                i_714\Field0 = $00
                                                dropitem(inventory(local2), $01)
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        EndIf
                    Else
                        If (arg0\Field85 <> 0) Then
                            me\Field52 = 20.0
                            me\Field49 = 500.0
                        EndIf
                        kill($00, $01, $00, $01)
                        me\Field1 = $00
                        If (arg0\Field85 <> 0) Then
                            msg\Field2 = getlocalstring("death", "049")
                            playsound_strict(loadtempsound("SFX\SCP\049\Horror.ogg"), $00)
                        EndIf
                        mp_loadnpcsound(arg0, (("SFX\SCP\049\Kidnap" + (Str rand($00, $01))) + ".ogg"), $01)
                        arg0\Field20 = playsoundex(arg0\Field19, camera, arg0\Field0, 10.0, 1.0, $01, $00)
                        arg0\Field10 = 3.0
                    EndIf
                EndIf
            EndIf
        EndIf
        arg0\Field18 = loopsoundex(npcsound[$05], arg0\Field18, camera, arg0\Field3, 10.0, 1.0, $01)
        If (0.1 = arg0\Field26) Then
            If (playerinreachableroom($00, $00) <> 0) Then
                For local2 = $00 To $03 Step $01
                    If (playerroom\Field19[local2] <> Null) Then
                        For local3 = $00 To $03 Step $01
                            If (playerroom\Field19[local2]\Field19[local3] <> Null) Then
                                If (playerroom\Field19[local2]\Field19[local3] <> playerroom) Then
                                    If (playerroom\Field19[local2]\Field19[local3]\Field30 <> $00) Then
                                        teleportentity(arg0\Field3, entityx(playerroom\Field19[local2]\Field19[local3]\Field30, $01), 0.5, entityz(playerroom\Field19[local2]\Field19[local3]\Field30, $01), arg0\Field6, $01, 2.0, $00)
                                    Else
                                        teleportentity(arg0\Field3, playerroom\Field19[local2]\Field19[local3]\Field3, 0.5, playerroom\Field19[local2]\Field19[local3]\Field5, arg0\Field6, $01, 2.0, $00)
                                    EndIf
                                    Exit
                                EndIf
                            EndIf
                        Next
                        Exit
                    EndIf
                Next
                arg0\Field26 = 0.0
            EndIf
        EndIf
        Select arg0\Field10
            Case 0.0
            Case 1.0
                If (538.0 <= arg0\Field14) Then
                    setnpcframe(arg0, 37.0, $01)
                Else
                    animatenpc(arg0, 37.0, 269.0, 0.7, $00)
                    If (268.9 < arg0\Field14) Then
                        arg0\Field10 = 2.0
                    EndIf
                EndIf
            Case 2.0
                If ((((local1 < ((hidedistance * 2.0) * (hidedistance * 2.0))) And (0.0 = arg0\Field26)) And playerinreachableroom($01, $00)) <> 0) Then
                    arg0\Field11 = max((arg0\Field11 - fps\Field7[$00]), 0.0)
                    local4 = npcseesplayer(arg0, ((8.0 - me\Field40) + me\Field42), 60.0, $00)
                    If (0.0 < arg0\Field11) Then
                        If (local4 = $01) Then
                            arg0\Field11 = 140.0
                        EndIf
                        If (((arg0\Field13 <= $01) And (channelplaying(arg0\Field20) = $00)) <> 0) Then
                            mp_loadnpcsound(arg0, (("SFX\SCP\049\Spotted" + (Str rand($00, $06))) + ".ogg"), $01)
                            arg0\Field20 = playsoundex(arg0\Field19, camera, arg0\Field0, 10.0, 1.0, $01, $00)
                            arg0\Field13 = $02
                        EndIf
                        arg0\Field40 = $00
                        arg0\Field41 = 0.0
                        arg0\Field42 = $00
                        If (entityvisible(arg0\Field3, me\Field60) <> 0) Then
                            pointentity(arg0\Field3, me\Field60, 0.0)
                        EndIf
                        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                        If (0.2375 < local1) Then
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                            If (9.0 > local1) Then
                                animatenpc(arg0, clamp(arg0\Field14, 387.0, 428.0), 463.0, (arg0\Field24 * 38.0), $01)
                            ElseIf (428.0 < arg0\Field14) Then
                                animatenpc(arg0, min(arg0\Field14, 463.0), 498.0, (arg0\Field24 * 38.0), $00)
                                If (497.9 < arg0\Field14) Then
                                    setnpcframe(arg0, 358.0, $01)
                                EndIf
                            Else
                                animatenpc(arg0, clamp(arg0\Field14, 346.0, 358.0), 393.0, (arg0\Field24 * 38.0), $01)
                            EndIf
                        EndIf
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, (15.0 - ((Float selecteddifficulty\Field4) * 1.5)))
                    Else
                        If (local4 = $01) Then
                            arg0\Field11 = 140.0
                        EndIf
                        If (arg0\Field40 = $01) Then
                            While (arg0\Field39[arg0\Field42] = Null)
                                If (arg0\Field42 > $14) Then
                                    arg0\Field42 = $00
                                    arg0\Field40 = $00
                                    Exit
                                Else
                                    arg0\Field42 = (arg0\Field42 + $01)
                                EndIf
                            Wend
                            If (arg0\Field39[arg0\Field42] <> Null) Then
                                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                                animatenpc(arg0, clamp(arg0\Field14, 346.0, 358.0), 393.0, (arg0\Field24 * 38.0), $01)
                                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, (15.0 - ((Float selecteddifficulty\Field4) * 1.5)))
                                If (((arg0\Field13 = $00) And (channelplaying(arg0\Field20) = $00)) <> 0) Then
                                    If (rand($1E, $01) = $01) Then
                                        mp_loadnpcsound(arg0, "SFX\SCP\049\Searching6.ogg", $01)
                                    Else
                                        mp_loadnpcsound(arg0, (("SFX\SCP\049\Searching" + (Str rand($00, $05))) + ".ogg"), $01)
                                    EndIf
                                    arg0\Field20 = playsoundex(arg0\Field19, camera, arg0\Field3, 10.0, 1.0, $01, $00)
                                    arg0\Field13 = $01
                                EndIf
                                usedoornpc(arg0, $01, $00)
                                If (((rand($258, $01) = $01) And (channelplaying(arg0\Field20) = $00)) <> 0) Then
                                    arg0\Field13 = $00
                                EndIf
                                If (arg0\Field13 > $01) Then
                                    arg0\Field13 = $01
                                EndIf
                            EndIf
                        Else
                            arg0\Field41 = (arg0\Field41 + fps\Field7[$00])
                            arg0\Field24 = 0.0
                            If (((4.0 - ((Float selecteddifficulty\Field2) * 2.0)) * 70.0) < arg0\Field41) Then
                                arg0\Field40 = findpath(arg0, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
                                arg0\Field41 = 0.0
                                arg0\Field12 = 0.0
                                If (arg0\Field40 <> $01) Then
                                    local6 = entitydistancesquared(playerroom\Field2, arg0\Field3)
                                    local7 = playerroom
                                    local8 = 0.0
                                    For local2 = $00 To $03 Step $01
                                        If (playerroom\Field19[local2] <> Null) Then
                                            local8 = entitydistancesquared(playerroom\Field19[local2]\Field2, arg0\Field3)
                                            If (local6 > local8) Then
                                                local6 = local8
                                                local7 = playerroom\Field19[local2]
                                            EndIf
                                        EndIf
                                    Next
                                    arg0\Field40 = findpath(arg0, entityx(local7\Field2, $00), 0.5, entityz(local7\Field2, $00))
                                EndIf
                                While (3.0 > (Float (Int arg0\Field12)))
                                    If (arg0\Field40 = $01) Then
                                        If (arg0\Field39[$01] <> Null) Then
                                            If (((arg0\Field39[$02] = Null) And (0.16 > entitydistancesquared(arg0\Field39[$01]\Field0, arg0\Field3))) <> 0) Then
                                                arg0\Field42 = $00
                                                arg0\Field40 = $00
                                            EndIf
                                        EndIf
                                        If (((arg0\Field39[$00] <> Null) And (arg0\Field39[$01] = Null)) <> 0) Then
                                            arg0\Field42 = $00
                                            arg0\Field40 = $00
                                        EndIf
                                    EndIf
                                    If (arg0\Field40 <> $01) Then
                                        local6 = 10000.0
                                        local7 = playerroom
                                        local8 = 0.0
                                        For local2 = $00 To $03 Step $01
                                            If (playerroom\Field19[local2] <> Null) Then
                                                local8 = entitydistancesquared(playerroom\Field19[local2]\Field2, arg0\Field3)
                                                If (local6 > local8) Then
                                                    local6 = local8
                                                    For local3 = $00 To $03 Step $01
                                                        If (playerroom\Field19[local2]\Field19[local3] <> Null) Then
                                                            If (playerroom\Field19[local2]\Field19[local3] <> playerroom) Then
                                                                local7 = playerroom\Field19[local2]\Field19[local3]
                                                                Exit
                                                            EndIf
                                                        EndIf
                                                    Next
                                                EndIf
                                            EndIf
                                        Next
                                        arg0\Field40 = findpath(arg0, entityx(local7\Field2, $00), 0.5, entityz(local7\Field2, $00))
                                    EndIf
                                    If (arg0\Field40 = $01) Then
                                        If (arg0\Field39[$01] <> Null) Then
                                            If (arg0\Field39[$01]\Field1 <> Null) Then
                                                If (((((arg0\Field39[$01]\Field1\Field4 > $00) Lor (arg0\Field39[$01]\Field1\Field14 <> $00)) Lor (arg0\Field39[$01]\Field1\Field19 <> $00)) And (arg0\Field39[$01]\Field1\Field6 = $00)) <> 0) Then
                                                    Repeat
                                                        If (arg0\Field42 > $14) Then
                                                            arg0\Field42 = $00
                                                            arg0\Field40 = $00
                                                            Exit
                                                        Else
                                                            arg0\Field42 = (arg0\Field42 + $01)
                                                        EndIf
                                                        If (arg0\Field39[arg0\Field42] <> Null) Then
                                                            If ((45.0 - (Abs deltayaw(arg0\Field3, arg0\Field39[$01]\Field0))) < (Abs deltayaw(arg0\Field3, arg0\Field39[arg0\Field42]\Field0))) Then
                                                                arg0\Field12 = 3.0
                                                                Exit
                                                            EndIf
                                                        EndIf
                                                    Forever
                                                Else
                                                    arg0\Field12 = 3.0
                                                EndIf
                                            Else
                                                arg0\Field12 = 3.0
                                            EndIf
                                        EndIf
                                    EndIf
                                    arg0\Field12 = (arg0\Field12 + 1.0)
                                Wend
                            EndIf
                            animatenpc(arg0, 269.0, 345.0, 0.2, $01)
                        EndIf
                    EndIf
                    If (0.005 < arg0\Field24) Then
                        If ((((((361.0 > local0) And (361.0 <= arg0\Field14)) Lor ((377.0 > local0) And (377.0 <= arg0\Field14))) Lor ((431.0 > local0) And (431.0 <= arg0\Field14))) Lor ((447.0 > local0) And (447.0 <= arg0\Field14))) <> 0) Then
                            playsoundex(snd_i\Field56[rand($07, $09)], camera, arg0\Field3, 8.0, rnd(0.8, 1.0), $00, $00)
                        EndIf
                    EndIf
                    updatesoundorigin(arg0\Field20, camera, arg0\Field0, 10.0, 1.0, $01, $01)
                ElseIf (0.0 = arg0\Field26) Then
                    If (channelplaying(arg0\Field18) <> 0) Then
                        stopchannel(arg0\Field18)
                        arg0\Field18 = $00
                    EndIf
                    If (channelplaying(arg0\Field20) <> 0) Then
                        stopchannel(arg0\Field20)
                        arg0\Field20 = $00
                    EndIf
                    If ((playerinreachableroom($01, $00) And (infacility = $00)) <> 0) Then
                        If (rand(($04 - (selecteddifficulty\Field2 Shl $01)), $01) = $01) Then
                            teleportcloser(arg0)
                        Else
                            arg0\Field26 = 4200.0
                        EndIf
                    EndIf
                EndIf
            Case 3.0
                animatenpc(arg0, 537.0, 660.0, 0.7, $00)
                If (659.0 <= arg0\Field14) Then
                    arg0\Field10 = 1.0
                EndIf
            Case 4.0
                local4 = npcseesplayer(arg0, ((8.0 - me\Field40) + me\Field42), 60.0, $01)
                If (local4 = $01) Then
                    If (0.0 = arg0\Field90) Then
                        playsound_strict(loadtempsound("SFX\SCP\049\Room2SLSpawn.ogg"), $00)
                        arg0\Field90 = 1.0
                    EndIf
                    arg0\Field40 = $00
                    arg0\Field42 = $00
                    arg0\Field41 = 0.0
                    arg0\Field13 = $00
                    arg0\Field12 = 0.0
                    arg0\Field11 = 140.0
                    arg0\Field10 = 2.0
                ElseIf (((local4 = $02) And (0.0 < arg0\Field12)) <> 0) Then
                    arg0\Field40 = findpath(arg0, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
                Else
                    If (6.0 = arg0\Field12) Then
                        If ((hidedistance * hidedistance) < entitydistancesquared(arg0\Field3, me\Field60)) Then
                            arg0\Field40 = $00
                            arg0\Field42 = $00
                            arg0\Field41 = 0.0
                            arg0\Field13 = $00
                            arg0\Field12 = 0.0
                            arg0\Field10 = 2.0
                        ElseIf (arg0\Field40 <> $01) Then
                            arg0\Field40 = findpath(arg0, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
                        EndIf
                    EndIf
                    If (arg0\Field40 = $01) Then
                        If (arg0\Field39[arg0\Field42] = Null) Then
                            If (arg0\Field42 > $14) Then
                                arg0\Field42 = $00
                                arg0\Field40 = $00
                            Else
                                arg0\Field42 = (arg0\Field42 + $01)
                            EndIf
                        Else
                            pointentity(arg0\Field0, arg0\Field39[arg0\Field42]\Field0, 0.0)
                            rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 10.0), 0.0, $00)
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                            arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, (10.0 - (Float selecteddifficulty\Field4)))
                            usedoornpc(arg0, $01, $00)
                            animatenpc(arg0, clamp(arg0\Field14, 346.0, 358.0), 393.0, (arg0\Field24 * 38.0), $01)
                        EndIf
                    Else
                        Select arg0\Field13
                            Case $00
                                animatenpc(arg0, 269.0, 345.0, 0.2, $01)
                            Case $01
                                animatenpc(arg0, 661.0, 891.0, 0.4, $00)
                            Case $02
                                animatenpc(arg0, 892.0, 1119.0, 0.4, $00)
                        End Select
                    EndIf
                EndIf
                If (playerroom\Field7\Field6 = $12) Then
                    shouldplay = $13
                EndIf
                If (0.005 < arg0\Field24) Then
                    If ((((((361.0 > local0) And (361.0 <= arg0\Field14)) Lor ((377.0 > local0) And (377.0 <= arg0\Field14))) Lor ((431.0 > local0) And (431.0 <= arg0\Field14))) Lor ((447.0 > local0) And (447.0 <= arg0\Field14))) <> 0) Then
                        playsoundex(snd_i\Field56[rand($07, $09)], camera, arg0\Field3, 8.0, rnd(0.8, 1.0), $00, $00)
                    EndIf
                EndIf
                updatesoundorigin(arg0\Field20, camera, arg0\Field0, 10.0, 1.0, $01, $01)
            Case 5.0
                If (1120.0 > arg0\Field14) Then
                    setnpcframe(arg0, 1121.0, $01)
                    moveentity(arg0\Field3, 0.0, 0.0, 0.5)
                Else
                    animatenpc(arg0, 1121.0, 1224.0, 0.3, $00)
                    If (1223.9 < arg0\Field14) Then
                        arg0\Field10 = 2.0
                    EndIf
                EndIf
        End Select
        arg0\Field29 = (Int max(((Float arg0\Field29) - fps\Field7[$00]), 0.0))
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $01), (entityy(arg0\Field3, $01) - 0.22), entityz(arg0\Field3, $01), $01)
    rotateentity(arg0\Field0, 0.0, arg0\Field15, 0.0, $01)
    Return $00
End Function
