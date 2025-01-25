Function mp_updatenpctype096%(arg0.npcs)
    Local local0#
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    Local local6#
    Local local7%
    Local local8.decals
    Local local9#
    Local local10.emitter
    Local local11.events
    If (1.0 = arg0\Field26) Then
        If (((arg0\Field18 <> $00) And arg0\Field21) <> 0) Then
            stopstream_strict(arg0\Field18)
            arg0\Field18 = $00
            arg0\Field21 = $00
        EndIf
        arg0\Field7 = 0.0
    Else
        local0 = entitydistancesquared(me\Field60, arg0\Field3)
        local1 = wrapangle(deltayaw(arg0\Field3, me\Field60), 360.0)
        local3 = ((((local0 < ((fog\Field0 * lightvolume) * (fog\Field0 * lightvolume))) And ((135.0 > local1) Lor (225.0 < local1))) And entityvisible(mp_getnpctargetcamera(arg0), arg0\Field1)) And entityinview(arg0\Field1, mp_getnpctargetcamera(arg0)))
        If (((wi\Field9 > $00) And local3) <> 0) Then
            local4 = $00
            For local2 = $00 To (maxitemamount - $01) Step $01
                If (inventory(local2) <> Null) Then
                    If ((((wi\Field9 = $01) And (inventory(local2)\Field4\Field2 = $43)) Lor ((wi\Field9 = $02) And (inventory(local2)\Field4\Field2 = $44))) <> 0) Then
                        If (0.0 < inventory(local2)\Field12) Then
                            inventory(local2)\Field12 = max(0.0, (inventory(local2)\Field12 - (fps\Field7[$00] * (0.08 / (Float wi\Field9)))))
                            local4 = $01
                            Exit
                        EndIf
                    EndIf
                EndIf
            Next
            If (local4 <> 0) Then
                If (channelplaying(scramblechn) = $00) Then
                    scramblechn = playsound_strict(snd_i\Field39, $00)
                EndIf
                If (entityhidden(arg0\Field1) <> 0) Then
                    showentity(arg0\Field1)
                EndIf
                scalesprite(arg0\Field1, rnd(0.06, 0.08), rnd(0.07, 0.09))
                positionentity(arg0\Field1, (rnd(0.1, 0.0) - 0.05), (rnd(0.1, 0.0) - 0.05), (rnd(0.1, 0.0) - 0.05), $00)
            Else
                If (entityhidden(arg0\Field1) = $00) Then
                    hideentity(arg0\Field1)
                EndIf
                If (channelplaying(scramblechn) <> 0) Then
                    stopchannel(scramblechn)
                    scramblechn = $00
                EndIf
            EndIf
        Else
            If (entityhidden(arg0\Field1) = $00) Then
                hideentity(arg0\Field1)
            EndIf
            If (channelplaying(scramblechn) <> 0) Then
                stopchannel(scramblechn)
                scramblechn = $00
            EndIf
        EndIf
        Select arg0\Field10
            Case 0.0
                If (64.0 > local0) Then
                    If (arg0\Field18 = $00) Then
                        arg0\Field18 = streamsound_strict("SFX\Music\096.ogg", 0.0, $02)
                        arg0\Field21 = $01
                    EndIf
                    If (-1.0 = arg0\Field12) Then
                        animatenpc(arg0, 936.0, 1263.0, 0.1, $00)
                        If (1262.9 <= arg0\Field14) Then
                            setnpcframe(arg0, 312.0, $01)
                            arg0\Field12 = 0.0
                            arg0\Field10 = 1.0
                        EndIf
                    Else
                        animatenpc(arg0, 936.0, 1263.0, 0.1, $01)
                        If (420.0 > arg0\Field12) Then
                            arg0\Field12 = (arg0\Field12 + fps\Field7[$00])
                        ElseIf (rand($05, $01) = $01) Then
                            arg0\Field12 = -1.0
                        Else
                            arg0\Field12 = ((Float rand($00, $03)) * 70.0)
                        EndIf
                    EndIf
                    If (chs\Field2 = $00) Then
                        If (((((mp_getnpctargetattach(arg0, $00) = $0B) Lor (mp_getnpctargetattach(arg0, $00) = $0C)) = $00) And local3) <> 0) Then
                            If (mp_getnpctargetblinking(arg0) = $00) Then
                                If (arg0\Field83 <> 0) Then
                                    playsound_strict(loadtempsound("SFX\SCP\096\Triggered.ogg"), $01)
                                EndIf
                                s2imaperase(unlockedachievements, "096")
                                me\Field52 = 10.0
                                setnpcframe(arg0, 194.0, $01)
                                stopstream_strict(arg0\Field18)
                                arg0\Field18 = $00
                                arg0\Field21 = $00
                                arg0\Field17 = $00
                                arg0\Field12 = 0.0
                                arg0\Field10 = 2.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
                updatestreamsoundorigin(arg0\Field18, camera, arg0\Field3, 8.0, 1.0, $01)
            Case 1.0
                If (256.0 > local0) Then
                    If (arg0\Field18 = $00) Then
                        arg0\Field18 = streamsound_strict("SFX\Music\096.ogg", 0.0, $02)
                        arg0\Field21 = $01
                    EndIf
                    local6 = arg0\Field14
                    If (422.0 <= arg0\Field14) Then
                        arg0\Field11 = (arg0\Field11 + fps\Field7[$00])
                        If (1000.0 < arg0\Field11) Then
                            If (1600.0 < arg0\Field11) Then
                                arg0\Field11 = rnd(0.0, 500.0)
                            EndIf
                            If (1382.0 > arg0\Field14) Then
                                arg0\Field24 = curvevalue((arg0\Field23 * 0.1), arg0\Field24, 5.0)
                                animatenpc(arg0, 1369.0, 1382.0, (arg0\Field24 * 45.0), $00)
                            Else
                                arg0\Field24 = curvevalue((arg0\Field23 * 0.1), arg0\Field24, 5.0)
                                animatenpc(arg0, 1383.0, 1456.0, (arg0\Field24 * 45.0), $01)
                            EndIf
                            If ((Float millisecs()) > arg0\Field12) Then
                                arg0\Field29 = $00
                                If (entityvisible(me\Field60, arg0\Field3) <> 0) Then
                                    arg0\Field29 = $01
                                Else
                                    hideentity(arg0\Field3)
                                    entitypick(arg0\Field3, 1.5)
                                    If (pickedentity() <> $00) Then
                                        arg0\Field15 = (entityyaw(arg0\Field3, $00) + rnd(80.0, 110.0))
                                    EndIf
                                    showentity(arg0\Field3)
                                EndIf
                                arg0\Field12 = (Float (millisecs() + $7D0))
                            EndIf
                            If (arg0\Field29 <> 0) Then
                                pointentity(arg0\Field0, me\Field60, 0.0)
                                rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 130.0), 0.0, $00)
                                If (2.25 > local0) Then
                                    arg0\Field11 = 0.0
                                EndIf
                            Else
                                rotateentity(arg0\Field3, 0.0, curveangle(arg0\Field15, entityyaw(arg0\Field3, $00), 50.0), 0.0, $00)
                            EndIf
                        ElseIf (472.0 < arg0\Field14) Then
                            arg0\Field24 = curvevalue((arg0\Field23 * 0.05), arg0\Field24, 8.0)
                            animatenpc(arg0, 1383.0, 1469.0, (arg0\Field24 * 45.0), $00)
                            If (1468.9 <= arg0\Field14) Then
                                setnpcframe(arg0, 423.0, $01)
                            EndIf
                        Else
                            arg0\Field24 = curvevalue(0.0, arg0\Field24, 4.0)
                            animatenpc(arg0, 423.0, 471.0, 0.2, $01)
                        EndIf
                        moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    Else
                        animatenpc(arg0, 312.0, 422.0, 0.3, $00)
                    EndIf
                    If (chs\Field2 = $00) Then
                        If (((((mp_getnpctargetattach(arg0, $00) = $0B) Lor (mp_getnpctargetattach(arg0, $00) = $0C)) = $00) And local3) <> 0) Then
                            If (mp_getnpctargetblinking(arg0) = $00) Then
                                If (arg0\Field83 <> 0) Then
                                    playsound_strict(loadtempsound("SFX\SCP\096\Triggered.ogg"), $01)
                                EndIf
                                s2imaperase(unlockedachievements, "096")
                                me\Field52 = 10.0
                                If (422.0 <= arg0\Field14) Then
                                    setnpcframe(arg0, 677.0, $01)
                                EndIf
                                stopstream_strict(arg0\Field18)
                                arg0\Field18 = $00
                                arg0\Field21 = $00
                                arg0\Field17 = $00
                                arg0\Field10 = 3.0
                            EndIf
                        EndIf
                    EndIf
                    If (0.001 < arg0\Field24) Then
                        If (((((1383.0 > local6) And (1383.0 <= arg0\Field14)) Lor ((1420.0 > local6) And (1420.0 <= arg0\Field14))) Lor ((1466.0 > local6) And (1466.0 <= arg0\Field14))) <> 0) Then
                            playsoundex(snd_i\Field56[rand($0A, $0C)], camera, arg0\Field3, 8.0, rnd(0.8, 1.0), $00, $00)
                        EndIf
                    EndIf
                EndIf
                updatestreamsoundorigin(arg0\Field18, camera, arg0\Field3, 14.0, 1.0, $01)
            Case 2.0,3.0,4.0
                If (arg0\Field18 = $00) Then
                    arg0\Field18 = streamsound_strict("SFX\Music\096Angered.ogg", 0.0, $02)
                    arg0\Field21 = $01
                EndIf
                updatestreamsoundorigin(arg0\Field18, camera, arg0\Field3, 10.0, 1.0, $01)
                If (2.0 = arg0\Field10) Then
                    If (312.0 > arg0\Field14) Then
                        animatenpc(arg0, 193.0, 311.0, 0.3, $00)
                        If (310.9 < arg0\Field14) Then
                            setnpcframe(arg0, 737.0, $01)
                            arg0\Field10 = 3.0
                        EndIf
                    ElseIf (((312.0 <= arg0\Field14) And (422.0 >= arg0\Field14)) <> 0) Then
                        animatenpc(arg0, 312.0, 422.0, 0.3, $00)
                        If (421.9 < arg0\Field14) Then
                            setnpcframe(arg0, 677.0, $01)
                        EndIf
                    Else
                        animatenpc(arg0, 677.0, 736.0, 0.3, $00)
                        If (735.9 < arg0\Field14) Then
                            setnpcframe(arg0, 737.0, $01)
                            arg0\Field10 = 3.0
                        EndIf
                    EndIf
                ElseIf (3.0 = arg0\Field10) Then
                    animatenpc(arg0, 677.0, 737.0, 0.3, $00)
                    If (737.0 <= arg0\Field14) Then
                        arg0\Field11 = 0.0
                        arg0\Field10 = 4.0
                    EndIf
                ElseIf (4.0 = arg0\Field10) Then
                    arg0\Field11 = (arg0\Field11 + fps\Field7[$00])
                    If (1820.0 < arg0\Field11) Then
                        animatenpc(arg0, 823.0, 847.0, (arg0\Field23 * 8.0), $00)
                        If (846.9 < arg0\Field14) Then
                            stopstream_strict(arg0\Field18)
                            arg0\Field18 = $00
                            arg0\Field21 = $00
                            arg0\Field10 = 5.0
                        EndIf
                    Else
                        animatenpc(arg0, 1471.0, 1556.0, 0.4, $01)
                    EndIf
                EndIf
            Case 5.0
                me\Field52 = curvevalue(max(me\Field52, ((sin(((Float millisec) / 20.0)) + 1.0) * 10.0)), me\Field52, 8.0)
                If (arg0\Field34 = Null) Then
                    If (arg0\Field18 = $00) Then
                        arg0\Field18 = streamsound_strict("SFX\SCP\096\Scream.ogg", 0.0, $02)
                        arg0\Field21 = $01
                    EndIf
                    updatestreamsoundorigin(arg0\Field18, camera, arg0\Field3, 7.5, 1.0, $01)
                    If (arg0\Field20 = $00) Then
                        arg0\Field20 = streamsound_strict("SFX\Music\096Chase.ogg", 0.0, $02)
                        arg0\Field22 = $01
                    Else
                        setstreamvolume_strict(arg0\Field20, ((clamp((8.0 - sqr(local0)), 0.6, 1.0) * opt\Field21) * opt\Field16))
                    EndIf
                EndIf
                If (arg0\Field34 <> Null) Then
                    local0 = entitydistancesquared(arg0\Field34\Field3, arg0\Field3)
                EndIf
                If ((Float millisecs()) > arg0\Field12) Then
                    arg0\Field29 = $00
                    If (arg0\Field34 = Null) Then
                        If (((64.0 > local0) And entityvisible(me\Field60, arg0\Field3)) <> 0) Then
                            arg0\Field29 = $01
                        EndIf
                    ElseIf (((64.0 > local0) And entityvisible(arg0\Field34\Field3, arg0\Field3)) <> 0) Then
                        arg0\Field29 = $01
                    EndIf
                    arg0\Field12 = (Float (millisecs() + $7D0))
                EndIf
                If ((chs\Field2 And (arg0\Field34 = Null)) <> 0) Then
                    arg0\Field29 = $00
                EndIf
                If (arg0\Field29 = $01) Then
                    arg0\Field41 = max(210.0, arg0\Field41)
                    arg0\Field40 = $00
                    If (((7.84 > local0) Lor (150.0 > arg0\Field14)) <> 0) Then
                        If (193.0 < arg0\Field14) Then
                            setnpcframe(arg0, 2.0, $01)
                        EndIf
                        animatenpc(arg0, 2.0, 193.0, 0.7, $01)
                        If (1.0 < local0) Then
                            arg0\Field24 = curvevalue((arg0\Field23 * 2.0), arg0\Field24, 15.0)
                        Else
                            arg0\Field24 = 0.0
                            If (arg0\Field34 = Null) Then
                                playsoundex(snd_i\Field51[$04], camera, arg0\Field3, 10.0, 1.0, $00, $00)
                                If (arg0\Field83 <> 0) Then
                                    me\Field23 = 30.0
                                    me\Field49 = 2000.0
                                    msg\Field2 = format(getlocalstring("death", "096"), subjectname, "%s")
                                EndIf
                                For local2 = $00 To $09 Step $01
                                    local7 = createpivot($00)
                                    positionentity(local7, (entityx(me\Field60, $00) + rnd(-0.8, 0.8)), (entityy(me\Field60, $00) - 0.05), (entityz(me\Field60, $00) + rnd(-0.8, 0.8)), $00)
                                    turnentity(local7, 90.0, 0.0, 0.0, $00)
                                    entitypick(local7, 0.3)
                                    local8 = createdecal(rand($10, $11), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.1, 0.3), 1.0, $00, $01, $00, $00, $00)
                                    entityparent(local8\Field0, playerroom\Field2, $01)
                                    freeentity(local7)
                                    local7 = $00
                                Next
                                kill($01, $01, $00, $01)
                                me\Field1 = $01
                                changenpctextureid(arg0, $12)
                                arg0\Field10 = 6.0
                                arg0\Field27 = 70.0
                                If (arg0\Field18 <> $00) Then
                                    stopstream_strict(arg0\Field18)
                                    arg0\Field18 = $00
                                    arg0\Field21 = $00
                                EndIf
                            EndIf
                        EndIf
                        If (arg0\Field34 = Null) Then
                            pointentity(arg0\Field3, me\Field60, 0.0)
                        Else
                            pointentity(arg0\Field3, arg0\Field34\Field3, 0.0)
                        EndIf
                    Else
                        If (arg0\Field34 = Null) Then
                            pointentity(arg0\Field0, me\Field60, 0.0)
                        Else
                            pointentity(arg0\Field0, arg0\Field34\Field3, 0.0)
                        EndIf
                        rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 5.0), 0.0, $00)
                        If (847.0 < arg0\Field14) Then
                            arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 20.0)
                        EndIf
                        If (906.0 > arg0\Field14) Then
                            animatenpc(arg0, 737.0, 906.0, (arg0\Field23 * 8.0), $00)
                        Else
                            animatenpc(arg0, 907.0, 935.0, (arg0\Field24 * 8.0), $01)
                        EndIf
                    EndIf
                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $01)
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                ElseIf (0.0 >= arg0\Field41) Then
                    If (arg0\Field34 <> Null) Then
                        arg0\Field40 = findpath(arg0, entityx(arg0\Field34\Field3, $00), (entityy(arg0\Field34\Field3, $00) + 0.2), entityz(arg0\Field34\Field3, $00))
                    Else
                        arg0\Field40 = findpath(arg0, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
                    EndIf
                    arg0\Field41 = 350.0
                ElseIf (((arg0\Field40 = $01) And (chs\Field2 = $00)) <> 0) Then
                    If (arg0\Field39[arg0\Field42] = Null) Then
                        If (arg0\Field42 > $14) Then
                            arg0\Field42 = $00
                            arg0\Field40 = $00
                        Else
                            arg0\Field42 = (arg0\Field42 + $01)
                        EndIf
                    Else
                        pointentity(arg0\Field0, arg0\Field39[arg0\Field42]\Field0, 0.0)
                        rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 5.0), 0.0, $00)
                        If (847.0 < arg0\Field14) Then
                            arg0\Field24 = curvevalue((arg0\Field23 * 1.5), arg0\Field24, 15.0)
                        EndIf
                        moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                        If (906.0 > arg0\Field14) Then
                            animatenpc(arg0, 737.0, 906.0, (arg0\Field23 * 8.0), $00)
                        Else
                            animatenpc(arg0, 907.0, 935.0, (arg0\Field24 * 8.0), $01)
                        EndIf
                        local9 = entitydistancesquared(arg0\Field3, arg0\Field39[arg0\Field42]\Field0)
                        If (0.64 > local9) Then
                            If (arg0\Field39[arg0\Field42]\Field1 <> Null) Then
                                If (arg0\Field39[arg0\Field42]\Field1\Field6 = $00) Then
                                    arg0\Field39[arg0\Field42]\Field1\Field6 = $01
                                    arg0\Field39[arg0\Field42]\Field1\Field9 = $01
                                    arg0\Field39[arg0\Field42]\Field1\Field4 = $01
                                    If (36.0 > local0) Then
                                        me\Field24 = 3.0
                                    EndIf
                                    local10 = setemitter(Null, entityx(arg0\Field39[arg0\Field42]\Field1\Field0, $01), entityy(arg0\Field39[arg0\Field42]\Field1\Field0, $01), entityz(arg0\Field39[arg0\Field42]\Field1\Field0, $01), $10)
                                    entityparent(local10\Field6, arg0\Field39[arg0\Field42]\Field1\Field0, $01)
                                    playsoundex(snd_i\Field9, camera, arg0\Field39[arg0\Field42]\Field1\Field2, 10.0, 1.0, $00, $00)
                                EndIf
                            EndIf
                            If (0.04 > local9) Then
                                arg0\Field42 = (arg0\Field42 + $01)
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field41 = max(0.0, (arg0\Field41 - fps\Field7[$00]))
                Else
                    arg0\Field24 = 0.0
                    animatenpc(arg0, 1471.0, 1556.0, 0.1, $01)
                    arg0\Field41 = max(0.0, (arg0\Field41 - (fps\Field7[$00] * 2.0)))
                EndIf
                If (rand($32, $01) = $01) Then
                    If (400.0 < local0) Then
                        teleportcloser(arg0)
                    EndIf
                EndIf
            Case 6.0
                If (193.0 < arg0\Field14) Then
                    setnpcframe(arg0, 2.0, $01)
                EndIf
                animatenpc(arg0, 2.0, 193.0, 0.7, $01)
                arg0\Field27 = (arg0\Field27 - fps\Field7[$00])
                If (0.0 >= arg0\Field27) Then
                    arg0\Field10 = 0.0
                EndIf
                If (arg0\Field18 <> $00) Then
                    stopstream_strict(arg0\Field18)
                    arg0\Field18 = $00
                    arg0\Field21 = $00
                EndIf
                If (arg0\Field20 <> $00) Then
                    stopstream_strict(arg0\Field20)
                    arg0\Field20 = $00
                    arg0\Field22 = $00
                EndIf
        End Select
        If (1.0 < arg0\Field10) Then
            For local11 = Each events
                If (local11\Field0 = $20) Then
                    If (0.0 = local11\Field2) Then
                        For local2 = $00 To $01 Step $01
                            local11\Field1\Field14[local2]\Field4 = $00
                        Next
                        local11\Field2 = 3150.0
                        removeevent(local11)
                    EndIf
                    Exit
                EndIf
            Next
            If (arg0\Field34 = Null) Then
                cansave = $02
            EndIf
        EndIf
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
    rotateentity(arg0\Field0, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), 0.0, $00)
    Return $00
End Function
