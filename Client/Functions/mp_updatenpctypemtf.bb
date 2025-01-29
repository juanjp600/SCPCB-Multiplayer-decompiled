Function mp_updatenpctypemtf%(arg0.npcs)
    Local local0.rooms
    Local local1%
    Local local2.npcs
    Local local3.waypoints
    Local local4%
    Local local5%
    Local local6.emitter
    Local local7%
    Local local8#
    Local local9%
    Local local10%
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16%
    Local local17#
    Local local18.npcs
    Local local21%
    Local local23.waypoints
    Local local24#
    Local local25#
    Local local26%
    If (arg0\Field50 <> 0) Then
        animatenpc(arg0, 1050.0, 1174.0, 0.7, $00)
    Else
        updatenpcblinking(arg0)
        arg0\Field28 = max((arg0\Field28 - fps\Field7[$00]), 0.0)
        If (((1.0 <> arg0\Field10) And (11.0 <> arg0\Field10)) <> 0) Then
            arg0\Field13 = $00
        EndIf
        arg0\Field20 = loopsoundex(npcsound[$01], arg0\Field20, camera, arg0\Field3, 10.0, 1.0, $01)
        local11 = arg0\Field14
        local12 = 0.0
        local13 = 0.0
        local14 = 0.0
        local17 = (fps\Field7[$00] * 2.0)
        local18 = Null
        If (arg0 <> n_i\Field8) Then
            If (arg0 = n_i\Field9) Then
                local18 = n_i\Field8
            Else
                local18 = n_i\Field9
            EndIf
        EndIf
        Select arg0\Field10
            Case 0.0
                arg0\Field23 = 0.015
                If (local18 <> Null) Then
                    local8 = entitydistancesquared(arg0\Field3, local18\Field3)
                    If (0.64 > local8) Then
                        arg0\Field12 = 70.0
                    EndIf
                    If (0.0 < arg0\Field12) Then
                        arg0\Field40 = $00
                        arg0\Field42 = $00
                        arg0\Field41 = 1.0
                        arg0\Field12 = max((arg0\Field12 - fps\Field7[$00]), 0.0)
                    EndIf
                EndIf
                If (0.0 >= arg0\Field41) Then
                    If (local18 <> Null) Then
                        arg0\Field40 = findpath(arg0, entityx(local18\Field3, $01), (entityy(local18\Field3, $01) + 0.1), entityz(local18\Field3, $01))
                    Else
                        If (2.0 = n_i\Field2\Field26) Then
                            For local0 = Each rooms
                                If (local0\Field7\Field6 = $03) Then
                                    local9 = $00
                                    local10 = createpivot($00)
                                    positionentity(local10, (local0\Field3 + 18.5), (local0\Field4 + 1.640625), (local0\Field5 + 14.74219), $01)
                                    If (12.25 > distancesquared(entityx(local10, $00), entityx(arg0\Field3, $00), entityz(local10, $00), entityz(arg0\Field3, $00), 0.0, 0.0)) Then
                                        local9 = $01
                                    EndIf
                                    freeentity(local10)
                                    local10 = $00
                                    If (((2.56 < distancesquared(entityx(arg0\Field3, $00), (local0\Field3 + 18.5), entityz(arg0\Field3, $00), (local0\Field5 + 14.74219), 0.0, 0.0)) And (local9 = $00)) <> 0) Then
                                        local12 = (local0\Field3 + 18.5)
                                        local13 = (local0\Field4 + 1.640625)
                                        local14 = (local0\Field5 + 14.74219)
                                        Exit
                                    ElseIf (((2.56 < distancesquared(entityx(arg0\Field3, $00), (local0\Field3 + 18.5), entityz(arg0\Field3, $00), (local0\Field5 + 14.74219), 0.0, 0.0)) And local9) <> 0) Then
                                        arg0\Field36 = (local0\Field3 + 18.5)
                                        arg0\Field37 = (local0\Field4 + 1.640625)
                                        arg0\Field38 = (local0\Field5 + 14.74219)
                                        Exit
                                    Else
                                        mp_loadnpcsound(arg0, (("SFX\Character\MTF\173\Cont" + (Str rand($00, $03))) + ".ogg"), $00)
                                        playmtfsound(arg0\Field17, arg0)
                                        playannouncement("SFX\Character\MTF\Announc173Contain.ogg", $01)
                                        If (local0\Field14[$00]\Field6 <> 0) Then
                                            openclosedoor(local0\Field14[$00], $01, $00)
                                        EndIf
                                        n_i\Field2\Field26 = 3.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        Else
                            For local0 = Each rooms
                                If ((((12.0 < (Abs (local0\Field3 - entityx(arg0\Field3, $01)))) Lor (12.0 < (Abs (local0\Field5 - entityz(arg0\Field3, $01))))) And (rand((Int max((Float ($04 - (Int (Abs (local0\Field5 - (entityz(arg0\Field3, $01) / 8.0)))))), 2.0)), $01) = $01)) <> 0) Then
                                    local12 = local0\Field3
                                    local13 = 0.1
                                    local14 = local0\Field5
                                    Exit
                                EndIf
                            Next
                        EndIf
                        If (((0.0 = arg0\Field36) And (0.0 = arg0\Field38)) <> 0) Then
                            arg0\Field40 = findpath(arg0, local12, local13, local14)
                        Else
                            arg0\Field10 = 3.0
                        EndIf
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
                        If (arg0\Field42 < $14) Then
                            If (((arg0\Field39[arg0\Field42] <> Null) And (arg0\Field39[(arg0\Field42 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field39[arg0\Field42]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field3, arg0\Field39[(arg0\Field42 + $01)]\Field0)) < (Abs deltayaw(arg0\Field3, arg0\Field39[arg0\Field42]\Field0))) Then
                                        arg0\Field42 = (arg0\Field42 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        usedoornpc(arg0, $01, $00)
                    EndIf
                    arg0\Field41 = (rnd(6.0, 10.0) * 70.0)
                ElseIf (((175.0 >= arg0\Field41) And (local18 = Null)) <> 0) Then
                    arg0\Field24 = 0.0
                    If (rand($23, $01) = $01) Then
                        rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                    EndIf
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                Else
                    If (arg0\Field40 = $02) Then
                        arg0\Field24 = 0.0
                        If (rand($23, $01) = $01) Then
                            rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                        arg0\Field41 = (arg0\Field41 - local17)
                    ElseIf (arg0\Field40 = $01) Then
                        If (arg0\Field39[arg0\Field42] = Null) Then
                            If (arg0\Field42 > $14) Then
                                arg0\Field42 = $00
                                arg0\Field40 = $00
                            Else
                                arg0\Field42 = (arg0\Field42 + $01)
                            EndIf
                        Else
                            pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                            usedoornpc(arg0, $01, $01)
                        EndIf
                        arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                    Else
                        If (local18 = Null) Then
                            arg0\Field24 = 0.0
                            If (rand($23, $01) = $01) Then
                                rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                        ElseIf (((1.0 <= local8) And (0.0 >= arg0\Field12)) <> 0) Then
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                            pointentity(arg0\Field3, local18\Field3, 0.0)
                            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                        ElseIf (0.0 >= arg0\Field12) Then
                            arg0\Field24 = 0.0
                            If (rand($23, $01) = $01) Then
                                rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                        Else
                            arg0\Field24 = curvevalue((- arg0\Field23), arg0\Field24, 20.0)
                            pointentity(arg0\Field3, local18\Field3, 0.0)
                            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 522.0, 488.0, (arg0\Field24 * 26.0), $01)
                        EndIf
                        arg0\Field41 = (arg0\Field41 - local17)
                    EndIf
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                EndIf
                If (0.0 >= arg0\Field66) Then
                    If (arg0\Field34 = Null) Then
                        local16 = npcseesplayer(arg0, ((4.0 - me\Field40) + me\Field42), 60.0, $00)
                        If (local16 > $00) Then
                            If (((arg0\Field29 > $00) And (1050.0 > (Float arg0\Field29))) <> 0) Then
                                If (local16 < $02) Then
                                    mp_loadnpcsound(arg0, (("SFX\Character\MTF\ThereHeIs" + (Str rand($00, $05))) + ".ogg"), $00)
                                    playmtfsound(arg0\Field17, arg0)
                                EndIf
                            ElseIf (local16 = $01) Then
                                mp_loadnpcsound(arg0, (("SFX\Character\MTF\Stop" + (Str rand($00, $05))) + ".ogg"), $00)
                                playmtfsound(arg0\Field17, arg0)
                            ElseIf (local16 = $02) Then
                                mp_loadnpcsound(arg0, (("SFX\Character\MTF\ClassD" + (Str rand($00, $03))) + ".ogg"), $00)
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            arg0\Field36 = entityx(me\Field60, $01)
                            arg0\Field37 = entityy(me\Field60, $01)
                            arg0\Field38 = entityz(me\Field60, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field29 = (Int (rnd(30.0, 40.0) * 70.0))
                            arg0\Field28 = ((3.0 - (Float selecteddifficulty\Field2)) * 70.0)
                            arg0\Field66 = 0.0
                            arg0\Field11 = ((15.0 * (Float local16)) * 70.0)
                            arg0\Field10 = 1.0
                            Return $00
                        EndIf
                    EndIf
                    If (2.0 > n_i\Field2\Field26) Then
                        If (npcseesnpc(n_i\Field2, arg0, 36.0) > $00) Then
                            If (local18 = Null) Then
                                If (0.0 < arg0\Field11) Then
                                    mp_loadnpcsound(arg0, "SFX\Character\MTF\173\Spotted3.ogg", $00)
                                Else
                                    mp_loadnpcsound(arg0, (("SFX\Character\MTF\173\Spotted" + (Str rand($00, $01))) + ".ogg"), $00)
                                EndIf
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            For local2 = Each npcs
                                If (local2\Field4 = $15) Then
                                    local2\Field36 = entityx(n_i\Field2\Field3, $01)
                                    local2\Field37 = entityy(n_i\Field2\Field3, $01)
                                    local2\Field38 = entityz(n_i\Field2\Field3, $01)
                                    local2\Field41 = 0.0
                                    local2\Field40 = $00
                                    local2\Field34 = n_i\Field2
                                    local2\Field66 = 0.0
                                    local2\Field11 = 2100.0
                                    local2\Field12 = 0.0
                                    local2\Field10 = 2.0
                                EndIf
                            Next
                            Return $00
                        EndIf
                    EndIf
                    If (1.0 < n_i\Field3\Field10) Then
                        If (npcseesnpc(n_i\Field3, arg0, 36.0) = $01) Then
                            If (local18 = Null) Then
                                mp_loadnpcsound(arg0, (("SFX\Character\MTF\106\Spotted" + (Str rand($00, $02))) + ".ogg"), $00)
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            arg0\Field36 = entityx(n_i\Field3\Field3, $01)
                            arg0\Field37 = entityy(n_i\Field3\Field3, $01)
                            arg0\Field38 = entityz(n_i\Field3\Field3, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field34 = n_i\Field3
                            arg0\Field66 = 0.0
                            arg0\Field11 = 1050.0
                            arg0\Field12 = 0.0
                            arg0\Field10 = 4.0
                            Return $00
                        EndIf
                    EndIf
                    If (n_i\Field4 <> Null) Then
                        If (npcseesnpc(n_i\Field4, arg0, 36.0) = $01) Then
                            If (local18 = Null) Then
                                mp_loadnpcsound(arg0, (("SFX\Character\MTF\096\Spotted" + (Str rand($00, $01))) + ".ogg"), $00)
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            playsoundex(snd_i\Field40[$00], camera, arg0\Field3, 5.0, 1.0, $00, $00)
                            arg0\Field36 = entityx(n_i\Field4\Field3, $01)
                            arg0\Field37 = entityy(n_i\Field4\Field3, $01)
                            arg0\Field38 = entityz(n_i\Field4\Field3, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field34 = n_i\Field4
                            arg0\Field66 = 0.0
                            arg0\Field11 = 700.0
                            arg0\Field12 = 0.0
                            arg0\Field10 = 8.0
                            Return $00
                        EndIf
                    EndIf
                    If (n_i\Field6 <> Null) Then
                        If (npcseesnpc(n_i\Field6, arg0, 36.0) = $01) Then
                            If (local18 = Null) Then
                                mp_loadnpcsound(arg0, (("SFX\Character\MTF\049\Spotted" + (Str rand($00, $04))) + ".ogg"), $00)
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            arg0\Field36 = entityx(n_i\Field6\Field3, $01)
                            arg0\Field37 = entityy(n_i\Field6\Field3, $01)
                            arg0\Field38 = entityz(n_i\Field6\Field3, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field34 = n_i\Field6
                            arg0\Field66 = 0.0
                            arg0\Field11 = 1050.0
                            arg0\Field12 = 0.0
                            arg0\Field10 = 4.0
                            Return $00
                        EndIf
                    EndIf
                    If (n_i\Field7 <> Null) Then
                        If (npcseesnpc(n_i\Field7, arg0, 36.0) = $01) Then
                            arg0\Field36 = entityx(n_i\Field7\Field3, $01)
                            arg0\Field37 = entityy(n_i\Field7\Field3, $01)
                            arg0\Field38 = entityz(n_i\Field7\Field3, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field34 = n_i\Field7
                            arg0\Field66 = 0.0
                            arg0\Field11 = 700.0
                            arg0\Field12 = 0.0
                            arg0\Field10 = 4.0
                            Return $00
                        EndIf
                    EndIf
                    For local2 = Each npcs
                        If (local2\Field50 = $00) Then
                            Select local2\Field4
                                Case $03
                                    If (npcseesnpc(local2, arg0, 36.0) = $01) Then
                                        If (local18 = Null) Then
                                            mp_loadnpcsound(arg0, "SFX\Character\MTF\049_2\Spotted.ogg", $00)
                                            playmtfsound(arg0\Field17, arg0)
                                        EndIf
                                        arg0\Field36 = entityx(local2\Field3, $01)
                                        arg0\Field37 = entityy(local2\Field3, $01)
                                        arg0\Field38 = entityz(local2\Field3, $01)
                                        arg0\Field41 = 0.0
                                        arg0\Field40 = $00
                                        arg0\Field34 = local2
                                        arg0\Field28 = 280.0
                                        arg0\Field66 = 0.0
                                        arg0\Field11 = 1050.0
                                        arg0\Field12 = 0.0
                                        arg0\Field10 = 9.0
                                        Return $00
                                        Exit
                                    EndIf
                                Case $00
                                    If (npcseesnpc(local2, arg0, 36.0) = $01) Then
                                        arg0\Field36 = entityx(local2\Field3, $01)
                                        arg0\Field37 = entityy(local2\Field3, $01)
                                        arg0\Field38 = entityz(local2\Field3, $01)
                                        arg0\Field41 = 0.0
                                        arg0\Field40 = $00
                                        arg0\Field34 = local2
                                        arg0\Field66 = 0.0
                                        arg0\Field28 = 210.0
                                        arg0\Field11 = 1050.0
                                        arg0\Field12 = 0.0
                                        arg0\Field10 = 9.0
                                        Return $00
                                        Exit
                                    EndIf
                                Case $01
                                    If (npcseesnpc(local2, arg0, 36.0) = $01) Then
                                        arg0\Field36 = entityx(local2\Field3, $01)
                                        arg0\Field37 = entityy(local2\Field3, $01)
                                        arg0\Field38 = entityz(local2\Field3, $01)
                                        arg0\Field41 = 0.0
                                        arg0\Field40 = $00
                                        arg0\Field34 = local2
                                        arg0\Field66 = 0.0
                                        arg0\Field28 = 210.0
                                        arg0\Field11 = 1050.0
                                        arg0\Field12 = 0.0
                                        arg0\Field10 = 9.0
                                        Return $00
                                        Exit
                                    EndIf
                                Case $0F
                                    If (npcseesnpc(local2, arg0, 36.0) = $01) Then
                                        arg0\Field36 = entityx(local2\Field3, $01)
                                        arg0\Field37 = entityy(local2\Field3, $01)
                                        arg0\Field38 = entityz(local2\Field3, $01)
                                        arg0\Field41 = 0.0
                                        arg0\Field40 = $00
                                        arg0\Field34 = local2
                                        arg0\Field66 = 0.0
                                        arg0\Field28 = 210.0
                                        arg0\Field11 = 1050.0
                                        arg0\Field12 = 0.0
                                        arg0\Field10 = 9.0
                                        Return $00
                                        Exit
                                    EndIf
                            End Select
                        EndIf
                    Next
                    arg0\Field66 = (fps\Field7[$00] * 45.0)
                Else
                    arg0\Field66 = (arg0\Field66 - fps\Field7[$00])
                EndIf
            Case 1.0
                arg0\Field23 = 0.015
                arg0\Field11 = max((arg0\Field11 - fps\Field7[$00]), 0.0)
                If (0.0 < arg0\Field11) Then
                    local16 = npcseesplayer(arg0, ((4.0 - me\Field40) + me\Field42), 60.0, $00)
                    If (local16 > $00) Then
                        arg0\Field11 = 1050.0
                    EndIf
                    If (local16 = $01) Then
                        arg0\Field36 = entityx(me\Field60, $01)
                        arg0\Field37 = entityy(me\Field60, $01)
                        arg0\Field38 = entityz(me\Field60, $01)
                        pointentity(arg0\Field3, me\Field60, 0.0)
                        If (0.0 >= arg0\Field28) Then
                            local21 = mp_getnpctargetdead(arg0)
                            playsoundex(snd_i\Field13[$00], camera, arg0\Field3, 15.0, 1.0, $00, $00)
                            local10 = createpivot($00)
                            rotateentity(local10, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), 0.0, $01)
                            positionentity(local10, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                            moveentity(local10, 0.0622, 0.83925, 0.5351)
                            local15 = sqr(local8)
                            shoot(arg0, entityx(local10, $00), entityy(local10, $00), entityz(local10, $00), arg0\Field3, ((25.0 / local15) * (1.0 / local15)), $01, $00)
                            freeentity(local10)
                            local10 = $00
                            msg\Field2 = format(getlocalstring("death", "ntf.blood"), subjectname, "%s")
                            If (((local21 = $00) And mp_getnpctargetdead(arg0)) <> 0) Then
                                msg\Field2 = format(getlocalstring("death", "ntf.terminated"), subjectname, "%s")
                                playmtfsound(loadtempsound((("SFX\Character\MTF\TargetTerminated" + (Str rand($00, $03))) + ".ogg")), arg0)
                            EndIf
                            arg0\Field28 = 8.0
                        EndIf
                        local8 = entitydistancesquared(me\Field60, arg0\Field3)
                        If (local8 < (((Float (playerroom\Field7\Field6 = $47)) * 16.0) + 9.0)) Then
                            For local2 = Each npcs
                                If (((local2\Field4 = $15) And (local2 <> arg0)) <> 0) Then
                                    If (0.0 = local2\Field10) Then
                                        If (36.0 > entitydistancesquared(arg0\Field3, local2\Field3)) Then
                                            arg0\Field13 = $01
                                            local2\Field29 = (Int (rnd(30.0, 40.0) * 70.0))
                                            local2\Field36 = entityx(me\Field60, $01)
                                            local2\Field37 = entityy(me\Field60, $01)
                                            local2\Field38 = entityz(me\Field60, $01)
                                            local2\Field11 = arg0\Field11
                                            local2\Field41 = 0.0
                                            local2\Field40 = $00
                                            local2\Field28 = ((4.0 - (Float selecteddifficulty\Field2)) * 70.0)
                                            local2\Field13 = $00
                                            local2\Field10 = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (arg0\Field13 = $01) Then
                                setnpcframe(arg0, 423.0, $01)
                                arg0\Field13 = $02
                            ElseIf (arg0\Field13 = $02) Then
                                arg0\Field24 = 0.0
                                If (200.0 < arg0\Field14) Then
                                    animatenpc(arg0, 424.0, 463.0, 0.5, $00)
                                    If (462.9 < arg0\Field14) Then
                                        setnpcframe(arg0, 78.0, $01)
                                    EndIf
                                Else
                                    animatenpc(arg0, 78.0, 193.0, 0.2, $00)
                                EndIf
                            EndIf
                        Else
                            positionentity(arg0\Field0, arg0\Field36, arg0\Field37, arg0\Field38, $01)
                            pointentity(arg0\Field3, arg0\Field0, 0.0)
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                        EndIf
                        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 10.0)
                    Else
                        arg0\Field29 = (Int ((Float arg0\Field29) - fps\Field7[$00]))
                        If (8.0 >= arg0\Field28) Then
                            arg0\Field28 = 8.0
                        EndIf
                        If (0.0 >= arg0\Field41) Then
                            arg0\Field40 = findpath(arg0, arg0\Field36, (arg0\Field37 + 0.1), arg0\Field38)
                            arg0\Field41 = (rnd(6.0, 10.0) * 70.0)
                            If (local18 = Null) Then
                                If (rand($0A, $01) = $01) Then
                                    For local2 = Each npcs
                                        If (((local2\Field4 = $15) And (local2 <> arg0)) <> 0) Then
                                            If (36.0 > entitydistancesquared(arg0\Field3, local2\Field3)) Then
                                                arg0\Field13 = $03
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        ElseIf (175.0 >= arg0\Field41) Then
                            arg0\Field24 = 0.0
                            If (arg0\Field13 = $00) Then
                                If (rand($23, $01) = $01) Then
                                    rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                EndIf
                                finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                            ElseIf (arg0\Field13 = $03) Then
                                setnpcframe(arg0, 350.0, $01)
                                arg0\Field13 = $04
                            ElseIf (arg0\Field13 = $04) Then
                                animatenpc(arg0, 350.0, 423.0, 0.5, $00)
                                If (422.9 < arg0\Field14) Then
                                    arg0\Field13 = $00
                                EndIf
                            EndIf
                            arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                        Else
                            If (arg0\Field40 = $02) Then
                                arg0\Field24 = 0.0
                                If (rand($23, $01) = $01) Then
                                    rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                EndIf
                                finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                                arg0\Field41 = (arg0\Field41 - local17)
                            ElseIf (arg0\Field40 = $01) Then
                                If (arg0\Field39[arg0\Field42] = Null) Then
                                    If (arg0\Field42 > $14) Then
                                        arg0\Field42 = $00
                                        arg0\Field40 = $00
                                    Else
                                        arg0\Field42 = (arg0\Field42 + $01)
                                    EndIf
                                Else
                                    pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                    translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                    animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                                    usedoornpc(arg0, $01, $01)
                                EndIf
                                arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                            Else
                                positionentity(arg0\Field0, arg0\Field36, arg0\Field37, arg0\Field38, $01)
                                If (((0.04 > distancesquared(entityx(arg0\Field3, $01), arg0\Field36, entityz(arg0\Field3, $01), arg0\Field38, 0.0, 0.0)) Lor (entityvisible(arg0\Field0, arg0\Field3) = $00)) <> 0) Then
                                    If (rand($23, $01) = $01) Then
                                        rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                        For local3 = Each waypoints
                                            If (rand($03, $01) = $01) Then
                                                If (36.0 > entitydistancesquared(local3\Field0, arg0\Field3)) Then
                                                    arg0\Field36 = entityx(local3\Field0, $01)
                                                    arg0\Field37 = entityy(local3\Field0, $01)
                                                    arg0\Field38 = entityz(local3\Field0, $01)
                                                    arg0\Field41 = 0.0
                                                    Exit
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                    finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                                    arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                                Else
                                    pointentity(arg0\Field3, arg0\Field0, 0.0)
                                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                    translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                    animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                                EndIf
                            EndIf
                            arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                        EndIf
                        If ((((local18 = Null) And (2100.0 > (Float arg0\Field29))) And (2100.0 <= ((Float arg0\Field29) + fps\Field7[$00]))) <> 0) Then
                            If (rand($02, $01) = $01) Then
                                playmtfsound(loadtempsound((("SFX\Character\MTF\Searching" + (Str rand($00, $05))) + ".ogg")), arg0)
                            EndIf
                        EndIf
                    EndIf
                Else
                    If (local18 = Null) Then
                        playmtfsound(loadtempsound((("SFX\Character\MTF\TargetLost" + (Str rand($00, $02))) + ".ogg")), arg0)
                        If (0.0 = mtfcamerachecktimer) Then
                            If (rand(($0F - (selecteddifficulty\Field2 * $07)), $01) = $01) Then
                                playannouncement("SFX\Character\MTF\AnnouncCameraCheck.ogg", $01)
                                mtfcamerachecktimer = fps\Field7[$00]
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field36 = 0.0
                    arg0\Field37 = 0.0
                    arg0\Field38 = 0.0
                    arg0\Field10 = 0.0
                    Return $00
                EndIf
                If (0.0 >= arg0\Field66) Then
                    If (2.0 > n_i\Field2\Field26) Then
                        If (npcseesnpc(n_i\Field2, arg0, 36.0) > $00) Then
                            If (local18 = Null) Then
                                If (0.0 < arg0\Field11) Then
                                    mp_loadnpcsound(arg0, "SFX\Character\MTF\173\Spotted3.ogg", $00)
                                Else
                                    mp_loadnpcsound(arg0, (("SFX\Character\MTF\173\Spotted" + (Str rand($00, $01))) + ".ogg"), $00)
                                EndIf
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            For local2 = Each npcs
                                If (local2\Field4 = $15) Then
                                    local2\Field36 = entityx(n_i\Field2\Field3, $01)
                                    local2\Field37 = entityy(n_i\Field2\Field3, $01)
                                    local2\Field38 = entityz(n_i\Field2\Field3, $01)
                                    local2\Field41 = 0.0
                                    local2\Field40 = $00
                                    local2\Field34 = n_i\Field2
                                    local2\Field66 = 0.0
                                    local2\Field11 = 2100.0
                                    local2\Field12 = 0.0
                                    local2\Field10 = 2.0
                                EndIf
                            Next
                            Return $00
                        EndIf
                    EndIf
                    If (1.0 < n_i\Field3\Field10) Then
                        If (npcseesnpc(n_i\Field3, arg0, 36.0) = $01) Then
                            If (local18 = Null) Then
                                mp_loadnpcsound(arg0, (("SFX\Character\MTF\106\Spotted" + (Str rand($00, $02))) + ".ogg"), $00)
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            arg0\Field36 = entityx(n_i\Field3\Field3, $01)
                            arg0\Field37 = entityy(n_i\Field3\Field3, $01)
                            arg0\Field38 = entityz(n_i\Field3\Field3, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field34 = n_i\Field3
                            arg0\Field66 = 0.0
                            arg0\Field11 = 1050.0
                            arg0\Field12 = 0.0
                            arg0\Field10 = 4.0
                            Return $00
                        EndIf
                    EndIf
                    If (n_i\Field4 <> Null) Then
                        If (npcseesnpc(n_i\Field4, arg0, 36.0) = $01) Then
                            If (local18 = Null) Then
                                mp_loadnpcsound(arg0, (("SFX\Character\MTF\096\Spotted" + (Str rand($00, $01))) + ".ogg"), $00)
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            playsoundex(snd_i\Field40[$00], camera, arg0\Field3, 5.0, 1.0, $00, $00)
                            arg0\Field36 = entityx(n_i\Field4\Field3, $01)
                            arg0\Field37 = entityy(n_i\Field4\Field3, $01)
                            arg0\Field38 = entityz(n_i\Field4\Field3, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field34 = n_i\Field4
                            arg0\Field66 = 0.0
                            arg0\Field11 = 700.0
                            arg0\Field12 = 0.0
                            arg0\Field10 = 8.0
                            Return $00
                        EndIf
                    EndIf
                    If (n_i\Field6 <> Null) Then
                        If (npcseesnpc(n_i\Field6, arg0, 36.0) = $01) Then
                            If (local18 = Null) Then
                                mp_loadnpcsound(arg0, (("SFX\Character\MTF\049\Spotted" + (Str rand($00, $04))) + ".ogg"), $00)
                                playmtfsound(arg0\Field17, arg0)
                            EndIf
                            arg0\Field36 = entityx(n_i\Field6\Field3, $01)
                            arg0\Field37 = entityy(n_i\Field6\Field3, $01)
                            arg0\Field38 = entityz(n_i\Field6\Field3, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field34 = n_i\Field6
                            arg0\Field66 = 0.0
                            arg0\Field11 = 1050.0
                            arg0\Field12 = 0.0
                            arg0\Field10 = 4.0
                            Return $00
                        EndIf
                    EndIf
                    If (n_i\Field7 <> Null) Then
                        If (npcseesnpc(n_i\Field7, arg0, 36.0) = $01) Then
                            arg0\Field36 = entityx(n_i\Field7\Field3, $01)
                            arg0\Field37 = entityy(n_i\Field7\Field3, $01)
                            arg0\Field38 = entityz(n_i\Field7\Field3, $01)
                            arg0\Field41 = 0.0
                            arg0\Field40 = $00
                            arg0\Field34 = n_i\Field7
                            arg0\Field66 = 0.0
                            arg0\Field11 = 700.0
                            arg0\Field12 = 0.0
                            arg0\Field10 = 4.0
                            Return $00
                        EndIf
                    EndIf
                    For local2 = Each npcs
                        If (local2\Field50 = $00) Then
                            Select local2\Field4
                                Case $03
                                    If (npcseesnpc(local2, arg0, 36.0) = $01) Then
                                        If (local18 = Null) Then
                                            mp_loadnpcsound(arg0, "SFX\Character\MTF\049_2\Spotted.ogg", $00)
                                            playmtfsound(arg0\Field17, arg0)
                                        EndIf
                                        arg0\Field36 = entityx(local2\Field3, $01)
                                        arg0\Field37 = entityy(local2\Field3, $01)
                                        arg0\Field38 = entityz(local2\Field3, $01)
                                        arg0\Field41 = 0.0
                                        arg0\Field40 = $00
                                        arg0\Field34 = local2
                                        arg0\Field28 = 280.0
                                        arg0\Field66 = 0.0
                                        arg0\Field11 = 1050.0
                                        arg0\Field12 = 0.0
                                        arg0\Field10 = 9.0
                                        Return $00
                                        Exit
                                    EndIf
                                Case $00
                                    If (npcseesnpc(local2, arg0, 36.0) = $01) Then
                                        arg0\Field36 = entityx(local2\Field3, $01)
                                        arg0\Field37 = entityy(local2\Field3, $01)
                                        arg0\Field38 = entityz(local2\Field3, $01)
                                        arg0\Field41 = 0.0
                                        arg0\Field40 = $00
                                        arg0\Field34 = local2
                                        arg0\Field28 = 210.0
                                        arg0\Field66 = 0.0
                                        arg0\Field11 = 1050.0
                                        arg0\Field12 = 0.0
                                        arg0\Field10 = 9.0
                                        Return $00
                                        Exit
                                    EndIf
                                Case $01
                                    If (npcseesnpc(local2, arg0, 36.0) = $01) Then
                                        arg0\Field36 = entityx(local2\Field3, $01)
                                        arg0\Field37 = entityy(local2\Field3, $01)
                                        arg0\Field38 = entityz(local2\Field3, $01)
                                        arg0\Field41 = 0.0
                                        arg0\Field40 = $00
                                        arg0\Field34 = local2
                                        arg0\Field28 = 210.0
                                        arg0\Field66 = 0.0
                                        arg0\Field11 = 1050.0
                                        arg0\Field12 = 0.0
                                        arg0\Field10 = 9.0
                                        Return $00
                                        Exit
                                    EndIf
                                Case $0F
                                    If (npcseesnpc(local2, arg0, 36.0) = $01) Then
                                        arg0\Field36 = entityx(local2\Field3, $01)
                                        arg0\Field37 = entityy(local2\Field3, $01)
                                        arg0\Field38 = entityz(local2\Field3, $01)
                                        arg0\Field41 = 0.0
                                        arg0\Field40 = $00
                                        arg0\Field34 = local2
                                        arg0\Field28 = 210.0
                                        arg0\Field66 = 0.0
                                        arg0\Field11 = 1050.0
                                        arg0\Field12 = 0.0
                                        arg0\Field10 = 9.0
                                        Return $00
                                        Exit
                                    EndIf
                            End Select
                        EndIf
                    Next
                    arg0\Field66 = (fps\Field7[$00] * 45.0)
                Else
                    arg0\Field66 = (arg0\Field66 - fps\Field7[$00])
                EndIf
            Case 3.0
                local10 = createpivot($00)
                positionentity(local10, arg0\Field36, arg0\Field37, arg0\Field38, $01)
                If (0.25 > distancesquared(entityx(arg0\Field3, $00), entityx(local10, $00), entityx(arg0\Field3, $00), entityx(local10, $00), 0.0, 0.0)) Then
                    arg0\Field36 = 0.0
                    arg0\Field37 = 0.0
                    arg0\Field38 = 0.0
                    freeentity(local10)
                    local10 = $00
                    arg0\Field10 = 0.0
                    Return $00
                EndIf
                freeentity(local10)
                local10 = $00
                If (arg0\Field40 = $01) Then
                    If (arg0\Field39[arg0\Field42] = Null) Then
                        If (arg0\Field42 > $14) Then
                            arg0\Field42 = $00
                            arg0\Field40 = $00
                        Else
                            arg0\Field42 = (arg0\Field42 + $01)
                        EndIf
                    Else
                        pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                        arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                        translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                        usedoornpc(arg0, $01, $01)
                    EndIf
                Else
                    If (0.0 = arg0\Field41) Then
                        arg0\Field40 = findpath(arg0, arg0\Field36, (arg0\Field37 + 0.2), arg0\Field38)
                    EndIf
                    local23 = Null
                    local10 = createpivot($00)
                    positionentity(local10, arg0\Field36, arg0\Field37, arg0\Field38, $00)
                    For local3 = Each waypoints
                        If (4.0 > entitydistancesquared(local3\Field0, local10)) Then
                            local23 = local3
                            Exit
                        EndIf
                    Next
                    freeentity(local10)
                    local10 = $00
                    If (local23 <> Null) Then
                        arg0\Field41 = 1.0
                        If (entityvisible(local23\Field0, arg0\Field3) <> 0) Then
                            If (0.0 < (Abs deltayaw(arg0\Field3, local23\Field0))) Then
                                pointentity(arg0\Field0, local23\Field0, 0.0)
                                rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
                            EndIf
                        EndIf
                    Else
                        arg0\Field41 = 0.0
                    EndIf
                    If (1.0 = arg0\Field41) Then
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                        arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                        translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                    EndIf
                EndIf
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
            Case 5.0
                local10 = createpivot($00)
                positionentity(local10, arg0\Field36, arg0\Field37, arg0\Field38, $01)
                pointentity(arg0\Field3, local10, 0.0)
                freeentity(local10)
                local10 = $00
                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                arg0\Field24 = 0.0
                animatenpc(arg0, 78.0, 194.0, 0.2, $01)
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
            Case 6.0
                pointentity(arg0\Field3, me\Field60, 0.0)
                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                arg0\Field24 = 0.0
                animatenpc(arg0, 346.0, 351.0, 0.2, $01)
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 10.0)
                local8 = entitydistancesquared(me\Field60, arg0\Field3)
                If (0.0 >= arg0\Field28) Then
                    local21 = mp_getnpctargetdead(arg0)
                    playsoundex(snd_i\Field13[$00], camera, arg0\Field3, 15.0, 1.0, $00, $00)
                    local10 = createpivot($00)
                    rotateentity(local10, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), 0.0, $01)
                    positionentity(local10, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                    moveentity(local10, 0.0622, 0.83925, 0.5351)
                    local15 = sqr(local8)
                    shoot(arg0, entityx(local10, $00), entityy(local10, $00), entityz(local10, $00), arg0\Field3, ((25.0 / local15) * (1.0 / local15)), $01, $00)
                    freeentity(local10)
                    local10 = $00
                    msg\Field2 = format(getlocalstring("death", "ntf.blood"), subjectname, "%s")
                    If (((local21 = $00) And mp_getnpctargetdead(arg0)) <> 0) Then
                        If (playerroom\Field7\Field6 = $3A) Then
                            msg\Field2 = getlocalstring("death", "0492")
                            playmtfsound(loadtempsound("SFX\Character\MTF\049_2\TargetTerminated.ogg"), arg0)
                        Else
                            msg\Field2 = format(getlocalstring("death", "ntf.gatea"), subjectname, "%s")
                            playmtfsound(loadtempsound((("SFX\Character\MTF\Targetterminated" + (Str rand($00, $03))) + ".ogg")), arg0)
                        EndIf
                    EndIf
                    arg0\Field28 = 8.0
                EndIf
            Case 11.0
                For local2 = Each npcs
                    If (((local2\Field4 = $15) And (local2 <> arg0)) <> 0) Then
                        If (((4.0 > entitydistancesquared(arg0\Field3, local2\Field3)) And (5.0 <> local2\Field10)) <> 0) Then
                            local2\Field13 = $00
                            local2\Field41 = 0.0
                            local2\Field42 = $00
                            local2\Field40 = $00
                            local2\Field36 = entityx(arg0\Field3, $00)
                            local2\Field37 = entityy(arg0\Field3, $00)
                            local2\Field38 = entityz(arg0\Field3, $00)
                            local2\Field10 = 5.0
                        EndIf
                    EndIf
                Next
                If (arg0\Field13 = $01) Then
                    setnpcframe(arg0, 423.0, $01)
                    arg0\Field13 = $02
                ElseIf (arg0\Field13 = $02) Then
                    arg0\Field24 = 0.0
                    If (1175.0 > arg0\Field14) Then
                        animatenpc(arg0, 423.0, 463.0, 0.5, $00)
                        If (462.9 < arg0\Field14) Then
                            mp_loadnpcsound(arg0, "SFX\Character\MTF\TeslaRequest.ogg", $00)
                            playmtfsound(arg0\Field17, arg0)
                            setnpcframe(arg0, 1175.0, $01)
                        EndIf
                    Else
                        animatenpc(arg0, 1175.0, 1290.0, 0.18, $00)
                    EndIf
                EndIf
                arg0\Field12 = max((arg0\Field12 - fps\Field7[$00]), 0.0)
                If (0.0 >= arg0\Field12) Then
                    For local2 = Each npcs
                        If (((local2\Field4 = $15) And (local2 <> arg0)) <> 0) Then
                            If (6.0 > entitydistancesquared(arg0\Field3, local2\Field3)) Then
                                local2\Field36 = 0.0
                                local2\Field37 = 0.0
                                local2\Field38 = 0.0
                                local2\Field10 = 0.0
                            EndIf
                        EndIf
                    Next
                    arg0\Field36 = 0.0
                    arg0\Field37 = 0.0
                    arg0\Field38 = 0.0
                    arg0\Field10 = 0.0
                    Return $00
                EndIf
            Case 2.0
                arg0\Field11 = max((arg0\Field11 - fps\Field7[$00]), 0.0)
                If (0.0 >= arg0\Field51) Then
                    If (npcsound[$02] = $00) Then
                        npcsound[$02] = loadsound_strict("SFX\Character\MTF\173\BLINKING.ogg")
                    EndIf
                    playmtfsound(npcsound[$02], arg0)
                EndIf
                If (npcseesnpc(arg0\Field34, arg0, 36.0) = $01) Then
                    arg0\Field36 = entityx(arg0\Field34\Field3, $01)
                    arg0\Field37 = entityy(arg0\Field34\Field3, $01)
                    arg0\Field38 = entityz(arg0\Field34\Field3, $01)
                    arg0\Field11 = 2100.0
                    arg0\Field42 = $00
                    arg0\Field41 = 0.0
                    arg0\Field40 = $00
                    If (2.0 <> arg0\Field34\Field26) Then
                        arg0\Field34\Field26 = 1.0
                    EndIf
                    local24 = distancesquared(entityx(arg0\Field3, $01), entityx(arg0\Field34\Field3, $01), entityz(arg0\Field3, $01), entityz(arg0\Field34\Field3, $01), 0.0, 0.0)
                    If (25.0 > local24) Then
                        local25 = 1.0
                        If (local18 <> Null) Then
                            local25 = (((Float (local18 = n_i\Field9)) * 3.0) + 3.0)
                        EndIf
                        pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                        If (local25 > local24) Then
                            arg0\Field12 = (arg0\Field12 + fps\Field7[$00])
                            If (1050.0 <= arg0\Field12) Then
                                mp_loadnpcsound(n_i\Field8, (("SFX\Character\MTF\173\Box" + (Str rand($00, $02))) + ".ogg"), $00)
                                playmtfsound(n_i\Field8\Field17, n_i\Field8)
                                arg0\Field34\Field26 = 2.0
                            EndIf
                            arg0\Field24 = 0.0
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                        Else
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                        EndIf
                    Else
                        positionentity(arg0\Field0, arg0\Field36, arg0\Field37, arg0\Field38, $01)
                        pointentity(arg0\Field3, arg0\Field0, 0.0)
                        arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                        translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                    EndIf
                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                ElseIf (0.0 >= arg0\Field41) Then
                    arg0\Field40 = findpath(arg0, arg0\Field36, (arg0\Field37 + 0.1), arg0\Field38)
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
                        If (arg0\Field42 < $14) Then
                            If (((arg0\Field39[arg0\Field42] <> Null) And (arg0\Field39[(arg0\Field42 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field39[arg0\Field42]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field3, arg0\Field39[(arg0\Field42 + $01)]\Field0)) < (Abs deltayaw(arg0\Field3, arg0\Field39[arg0\Field42]\Field0))) Then
                                        arg0\Field42 = (arg0\Field42 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        usedoornpc(arg0, $01, $00)
                    EndIf
                    arg0\Field41 = (rnd(6.0, 10.0) * 70.0)
                ElseIf (175.0 >= arg0\Field41) Then
                    arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                    arg0\Field24 = 0.0
                    If (rand($23, $01) = $01) Then
                        rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                    EndIf
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                Else
                    If (arg0\Field40 = $01) Then
                        If (arg0\Field39[arg0\Field42] = Null) Then
                            If (arg0\Field42 > $14) Then
                                arg0\Field42 = $00
                                arg0\Field40 = $00
                            Else
                                arg0\Field42 = (arg0\Field42 + $01)
                            EndIf
                        Else
                            pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                            usedoornpc(arg0, $01, $01)
                        EndIf
                        arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                    Else
                        positionentity(arg0\Field0, arg0\Field36, arg0\Field37, arg0\Field38, $01)
                        If (((0.25 > distancesquared(entityx(arg0\Field3, $01), arg0\Field36, entityz(arg0\Field3, $01), arg0\Field38, 0.0, 0.0)) Lor (entityvisible(arg0\Field0, arg0\Field3) = $00)) <> 0) Then
                            If (rand($23, $01) = $01) Then
                                rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                For local3 = Each waypoints
                                    If (rand($03, $01) = $01) Then
                                        If (36.0 > entitydistancesquared(local3\Field0, arg0\Field3)) Then
                                            arg0\Field36 = entityx(local3\Field0, $01)
                                            arg0\Field37 = entityy(local3\Field0, $01)
                                            arg0\Field38 = entityz(local3\Field0, $01)
                                            arg0\Field41 = 0.0
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                            arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                        Else
                            pointentity(arg0\Field3, arg0\Field0, 0.0)
                            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                        EndIf
                    EndIf
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                EndIf
                If (((0.0 >= arg0\Field11) Lor (2.0 = arg0\Field34\Field26)) <> 0) Then
                    arg0\Field34 = Null
                    arg0\Field36 = 0.0
                    arg0\Field37 = 0.0
                    arg0\Field38 = 0.0
                    arg0\Field11 = 0.0
                    arg0\Field12 = 0.0
                    arg0\Field10 = 0.0
                    Return $00
                EndIf
            Case 4.0
                arg0\Field23 = 0.03
                arg0\Field11 = max((arg0\Field11 - fps\Field7[$00]), 0.0)
                If (0.0 < arg0\Field11) Then
                    local8 = entitydistancesquared(arg0\Field3, arg0\Field34\Field3)
                    If (npcseesnpc(arg0\Field34, arg0, 36.0) = $01) Then
                        arg0\Field11 = ((15.0 - ((Float (arg0\Field34 = n_i\Field7)) * 5.0)) * 70.0)
                    EndIf
                    If (((70.0 < arg0\Field11) And ((hidedistance * hidedistance) < local8)) <> 0) Then
                        arg0\Field11 = 70.0
                    EndIf
                    If (((9.0 > local8) And (arg0\Field34 <> n_i\Field7)) <> 0) Then
                        arg0\Field12 = 210.0
                    EndIf
                    If (0.0 < arg0\Field12) Then
                        arg0\Field23 = 0.02
                        arg0\Field40 = $00
                        arg0\Field42 = $00
                        arg0\Field41 = 1.0
                        arg0\Field12 = max((arg0\Field12 - fps\Field7[$00]), 0.0)
                    EndIf
                    If (0.0 >= arg0\Field41) Then
                        If (local18 <> Null) Then
                            arg0\Field40 = findpath(arg0, entityx(local18\Field3, $01), (entityy(local18\Field3, $01) + 0.1), entityz(local18\Field3, $01))
                        Else
                            For local0 = Each rooms
                                If ((((12.0 < (Abs (local0\Field3 - entityx(arg0\Field3, $01)))) Lor (12.0 < (Abs (local0\Field5 - entityz(arg0\Field3, $01))))) And (rand((Int max((Float ($04 - (Int (Abs (local0\Field5 - (entityz(arg0\Field3, $01) / 8.0)))))), 2.0)), $01) = $01)) <> 0) Then
                                    If (36.0 < entitydistancesquared(local0\Field2, arg0\Field34\Field3)) Then
                                        local12 = local0\Field3
                                        local13 = 0.1
                                        local14 = local0\Field5
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            arg0\Field40 = findpath(arg0, local12, local13, local14)
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
                            If (arg0\Field42 < $14) Then
                                If (((arg0\Field39[arg0\Field42] <> Null) And (arg0\Field39[(arg0\Field42 + $01)] <> Null)) <> 0) Then
                                    If (arg0\Field39[arg0\Field42]\Field1 = Null) Then
                                        If ((Abs deltayaw(arg0\Field3, arg0\Field39[(arg0\Field42 + $01)]\Field0)) < (Abs deltayaw(arg0\Field3, arg0\Field39[arg0\Field42]\Field0))) Then
                                            arg0\Field42 = (arg0\Field42 + $01)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            usedoornpc(arg0, $01, $00)
                        EndIf
                        arg0\Field41 = (rnd(6.0, 10.0) * 70.0)
                    Else
                        If (arg0\Field40 = $02) Then
                            arg0\Field24 = 0.0
                            If (rand($23, $01) = $01) Then
                                rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                            arg0\Field41 = (arg0\Field41 - local17)
                        ElseIf (arg0\Field40 = $01) Then
                            If (arg0\Field39[arg0\Field42] = Null) Then
                                If (arg0\Field42 > $14) Then
                                    arg0\Field42 = $00
                                    arg0\Field40 = $00
                                Else
                                    arg0\Field42 = (arg0\Field42 + $01)
                                EndIf
                            Else
                                pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                                usedoornpc(arg0, $01, $01)
                            EndIf
                            arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                        Else
                            If (((1.0 <= local8) And (0.0 >= arg0\Field12)) <> 0) Then
                                pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                            ElseIf (0.0 >= arg0\Field12) Then
                                arg0\Field24 = 0.0
                                If (rand($23, $01) = $01) Then
                                    rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                EndIf
                                finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                            Else
                                pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                arg0\Field24 = curvevalue((- arg0\Field23), arg0\Field24, 20.0)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 522.0, 488.0, (arg0\Field24 * 26.0), $01)
                            EndIf
                            arg0\Field41 = (arg0\Field41 - local17)
                        EndIf
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    EndIf
                Else
                    arg0\Field34 = Null
                    arg0\Field36 = 0.0
                    arg0\Field37 = 0.0
                    arg0\Field38 = 0.0
                    arg0\Field11 = 0.0
                    arg0\Field12 = 0.0
                    arg0\Field10 = 0.0
                    Return $00
                EndIf
            Case 8.0
                arg0\Field23 = 0.0175
                arg0\Field11 = max((arg0\Field11 - fps\Field7[$00]), 0.0)
                arg0\Field18 = loopsoundex(snd_i\Field39, arg0\Field18, camera, arg0\Field3, 5.0, 1.0, $00)
                If (0.0 < arg0\Field11) Then
                    If (npcseesnpc(arg0\Field34, arg0, 36.0) = $01) Then
                        arg0\Field11 = 700.0
                    EndIf
                    If (local18 <> Null) Then
                        local8 = entitydistancesquared(arg0\Field3, local18\Field3)
                        If (0.64 > local8) Then
                            arg0\Field12 = 70.0
                        EndIf
                        If (0.0 < arg0\Field12) Then
                            arg0\Field40 = $00
                            arg0\Field42 = $00
                            arg0\Field41 = 1.0
                            arg0\Field12 = max((arg0\Field12 - fps\Field7[$00]), 0.0)
                        EndIf
                    EndIf
                    If (0.0 >= arg0\Field41) Then
                        If (local18 <> Null) Then
                            arg0\Field40 = findpath(arg0, entityx(local18\Field3, $01), (entityy(local18\Field3, $01) + 0.1), entityz(local18\Field3, $01))
                        Else
                            For local0 = Each rooms
                                If ((((12.0 < (Abs (local0\Field3 - entityx(arg0\Field3, $01)))) Lor (12.0 < (Abs (local0\Field5 - entityz(arg0\Field3, $01))))) And (rand((Int max((Float ($04 - (Int (Abs (local0\Field5 - (entityz(arg0\Field3, $01) / 8.0)))))), 2.0)), $01) = $01)) <> 0) Then
                                    local12 = local0\Field3
                                    local13 = 0.1
                                    local14 = local0\Field5
                                    Exit
                                EndIf
                            Next
                            arg0\Field40 = findpath(arg0, local12, local13, local14)
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
                            If (arg0\Field42 < $14) Then
                                If (((arg0\Field39[arg0\Field42] <> Null) And (arg0\Field39[(arg0\Field42 + $01)] <> Null)) <> 0) Then
                                    If (arg0\Field39[arg0\Field42]\Field1 = Null) Then
                                        If ((Abs deltayaw(arg0\Field3, arg0\Field39[(arg0\Field42 + $01)]\Field0)) < (Abs deltayaw(arg0\Field3, arg0\Field39[arg0\Field42]\Field0))) Then
                                            arg0\Field42 = (arg0\Field42 + $01)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            usedoornpc(arg0, $01, $00)
                        EndIf
                        arg0\Field41 = (rnd(6.0, 10.0) * 70.0)
                    ElseIf (((175.0 >= arg0\Field41) And (local18 = Null)) <> 0) Then
                        arg0\Field24 = 0.0
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                        arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                    Else
                        If (arg0\Field40 = $02) Then
                            arg0\Field24 = 0.0
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                            arg0\Field41 = (arg0\Field41 - local17)
                        ElseIf (arg0\Field40 = $01) Then
                            If (arg0\Field39[arg0\Field42] = Null) Then
                                If (arg0\Field42 > $14) Then
                                    arg0\Field42 = $00
                                    arg0\Field40 = $00
                                Else
                                    arg0\Field42 = (arg0\Field42 + $01)
                                EndIf
                            Else
                                pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                                usedoornpc(arg0, $01, $01)
                            EndIf
                            arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                        Else
                            If (local18 = Null) Then
                                arg0\Field24 = 0.0
                                If (rand($23, $01) = $01) Then
                                    rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                EndIf
                                finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                            ElseIf (((1.0 <= local8) And (0.0 >= arg0\Field12)) <> 0) Then
                                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                pointentity(arg0\Field3, local18\Field3, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                            ElseIf (0.0 >= arg0\Field12) Then
                                arg0\Field24 = 0.0
                                If (rand($23, $01) = $01) Then
                                    rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                EndIf
                                finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                            Else
                                arg0\Field24 = curvevalue((- arg0\Field23), arg0\Field24, 20.0)
                                pointentity(arg0\Field3, local18\Field3, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 522.0, 488.0, (arg0\Field24 * 26.0), $01)
                            EndIf
                            arg0\Field41 = (arg0\Field41 - local17)
                        EndIf
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    EndIf
                Else
                    stopchannel(arg0\Field18)
                    arg0\Field18 = $00
                    playsoundex(snd_i\Field40[$01], camera, arg0\Field3, 5.0, 1.0, $00, $00)
                    arg0\Field34 = Null
                    arg0\Field36 = 0.0
                    arg0\Field37 = 0.0
                    arg0\Field38 = 0.0
                    arg0\Field11 = 0.0
                    arg0\Field12 = 0.0
                    arg0\Field10 = 0.0
                    Return $00
                EndIf
            Case 9.0
                arg0\Field11 = max((arg0\Field11 - fps\Field7[$00]), 0.0)
                If (((0.0 < arg0\Field11) And (arg0\Field34\Field50 = $00)) <> 0) Then
                    local8 = entitydistancesquared(arg0\Field3, arg0\Field34\Field3)
                    If (npcseesnpc(arg0\Field34, arg0, 36.0) = $01) Then
                        arg0\Field11 = 1050.0
                        pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                        If (4.0 > local8) Then
                            arg0\Field12 = 140.0
                        EndIf
                        If (0.0 < arg0\Field12) Then
                            arg0\Field23 = 0.02
                            arg0\Field40 = $00
                            arg0\Field42 = $00
                            arg0\Field41 = 1.0
                            arg0\Field24 = curvevalue((- arg0\Field23), arg0\Field24, 20.0)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 522.0, 488.0, (arg0\Field24 * 26.0), $01)
                            arg0\Field12 = max((arg0\Field12 - fps\Field7[$00]), 0.0)
                        EndIf
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 10.0)
                        If (0.0 >= arg0\Field28) Then
                            playsoundex(snd_i\Field13[$00], camera, arg0\Field3, 15.0, 1.0, $00, $00)
                            local10 = createpivot($00)
                            rotateentity(local10, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), 0.0, $01)
                            positionentity(local10, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                            moveentity(local10, 0.0622, 0.83925, 0.5351)
                            If ((fog\Field0 * fog\Field0) > entitydistancesquared(me\Field60, arg0\Field3)) Then
                                lightvolume = (templightvolume * 1.2)
                            EndIf
                            local6 = setemitter(Null, entityx(local10, $00), entityy(local10, $00), entityz(local10, $00), $0D)
                            entityparent(local6\Field6, arg0\Field3, $01)
                            setemitter(Null, entityx(arg0\Field34\Field3, $00), entityy(arg0\Field34\Field3, $00), entityz(arg0\Field34\Field3, $00), $0F)
                            freeentity(local10)
                            local10 = $00
                            playsoundex(snd_i\Field15, camera, arg0\Field34\Field3, 5.0, 1.0, $00, $00)
                            If (arg0\Field34\Field60 > $00) Then
                                arg0\Field34\Field60 = (Int max((Float (arg0\Field34\Field60 - rand($05, $0A))), 0.0))
                            Else
                                If (arg0\Field34\Field50 = $00) Then
                                    local26 = arg0\Field34\Field4
                                    If (local26 = $03) Then
                                        If (local18 = Null) Then
                                            mp_loadnpcsound(arg0, "SFX\Character\MTF\049_2\TargetTerminated.ogg", $00)
                                            playmtfsound(arg0\Field17, arg0)
                                        EndIf
                                    EndIf
                                EndIf
                                arg0\Field34 = Null
                                arg0\Field36 = 0.0
                                arg0\Field37 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field11 = 0.0
                                arg0\Field12 = 0.0
                                arg0\Field10 = 0.0
                                Return $00
                            EndIf
                            arg0\Field28 = 8.0
                        EndIf
                        arg0\Field40 = $00
                    ElseIf (0.0 >= arg0\Field41) Then
                        arg0\Field40 = findpath(arg0, entityx(arg0\Field34\Field3, $00), entityy(arg0\Field34\Field3, $00), entityz(arg0\Field34\Field3, $00))
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
                            If (arg0\Field42 < $14) Then
                                If (((arg0\Field39[arg0\Field42] <> Null) And (arg0\Field39[(arg0\Field42 + $01)] <> Null)) <> 0) Then
                                    If (arg0\Field39[arg0\Field42]\Field1 = Null) Then
                                        If ((Abs deltayaw(arg0\Field3, arg0\Field39[(arg0\Field42 + $01)]\Field0)) < (Abs deltayaw(arg0\Field3, arg0\Field39[arg0\Field42]\Field0))) Then
                                            arg0\Field42 = (arg0\Field42 + $01)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            usedoornpc(arg0, $01, $00)
                        EndIf
                        arg0\Field41 = (rnd(6.0, 10.0) * 70.0)
                    Else
                        If (arg0\Field40 = $02) Then
                            arg0\Field24 = 0.0
                            If (rand($23, $01) = $01) Then
                                rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                            arg0\Field41 = (arg0\Field41 - local17)
                        ElseIf (arg0\Field40 = $01) Then
                            If (arg0\Field39[arg0\Field42] = Null) Then
                                If (arg0\Field42 > $14) Then
                                    arg0\Field42 = $00
                                    arg0\Field40 = $00
                                Else
                                    arg0\Field42 = (arg0\Field42 + $01)
                                EndIf
                            Else
                                pointentity(arg0\Field3, arg0\Field39[arg0\Field42]\Field0, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                                usedoornpc(arg0, $01, $01)
                            EndIf
                            arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                        Else
                            If (((1.0 <= local8) And (0.0 >= arg0\Field12)) <> 0) Then
                                pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                            ElseIf (0.0 >= arg0\Field12) Then
                                arg0\Field24 = 0.0
                                If (rand($23, $01) = $01) Then
                                    rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                EndIf
                                finishwalking(arg0, 488.0, 522.0, (arg0\Field23 * 26.0))
                            Else
                                pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                                arg0\Field24 = curvevalue((- arg0\Field23), arg0\Field24, 20.0)
                                translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                                animatenpc(arg0, 522.0, 488.0, (arg0\Field24 * 26.0), $01)
                            EndIf
                            arg0\Field41 = (arg0\Field41 - local17)
                        EndIf
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                    EndIf
                Else
                    arg0\Field34 = Null
                    arg0\Field36 = 0.0
                    arg0\Field37 = 0.0
                    arg0\Field38 = 0.0
                    arg0\Field11 = 0.0
                    arg0\Field12 = 0.0
                    arg0\Field10 = 0.0
                    Return $00
                EndIf
        End Select
        If (0.01 < arg0\Field24) Then
            If ((((505.0 > local11) And (505.0 <= arg0\Field14)) Lor ((521.0 > local11) And (521.0 <= arg0\Field14))) <> 0) Then
                playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
            EndIf
        ElseIf (-0.01 > arg0\Field24) Then
            If ((((521.0 <= local11) And (521.0 > arg0\Field14)) Lor ((505.0 <= local11) And (505.0 > arg0\Field14))) <> 0) Then
                playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
            EndIf
        EndIf
        If (playerroom\Field7\Field6 <> $47) Then
            If (rand($64, $01) = $01) Then
                If (local18 <> Null) Then
                    If (((0.0 = arg0\Field10) Lor (8.0 = arg0\Field10)) <> 0) Then
                        If (256.0 < entitydistancesquared(arg0\Field3, local18\Field3)) Then
                            If (((entityinview(arg0\Field3, mp_getnpctargetcamera(arg0)) = $00) And (entityinview(local18\Field3, mp_getnpctargetcamera(arg0)) = $00)) <> 0) Then
                                teleportentity(arg0\Field3, entityx(local18\Field3, $01), (entityy(local18\Field3, $01) + 0.28), entityz(local18\Field3, $01), arg0\Field6, $01, 2.0, $00)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (((playerroom\Field7\Field6 <> $3A) And (arg0\Field59 = $FFFFFFFF)) <> 0) Then
            teleportcloser(arg0)
        EndIf
        If (arg0\Field60 <= $00) Then
            arg0\Field50 = $01
            n_i\Field8 = Null
            n_i\Field9 = Null
        EndIf
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $01), (entityy(arg0\Field3, $01) - 0.2), entityz(arg0\Field3, $01), $01)
    rotateentity(arg0\Field0, -89.9, arg0\Field15, 0.0, $01)
    Return $00
End Function
