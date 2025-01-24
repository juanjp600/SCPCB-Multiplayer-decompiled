Function mp_updatenpctype999%(arg0.npcs)
    Local local0#
    Local local1.decals
    Local local2%
    Local local3%
    Local local5%
    Local local6.items
    Local local7.items
    Local local8.rooms
    Local local9#
    Local local10#
    Local local11#
    local0 = entitydistancesquared(me\Field60, arg0\Field3)
    If ((hidedistance * hidedistance) > local0) Then
        arg0\Field29 = $00
        If (3.0 > arg0\Field10) Then
            If (((((me\Field59 < $02) Lor (playerroom\Field7\Field6 = $46)) Lor (playerroom\Field7\Field6 = $48)) Lor (1.0 < n_i\Field3\Field10)) <> 0) Then
                arg0\Field10 = 3.0
                Return $00
            EndIf
            arg0\Field13 = $00
            local3 = (entityvisible(me\Field60, arg0\Field3) And ((chs\Field2 Lor i_268\Field2) = $00))
        EndIf
        Select arg0\Field10
            Case 0.0
                If (local3 <> 0) Then
                    arg0\Field10 = 2.0
                    Return $00
                EndIf
                arg0\Field24 = 0.0
                animatenpc(arg0, clamp(animtime(arg0\Field0), 1.0, 11.0), 74.0, 0.3, $00)
                If (73.9 <= arg0\Field14) Then
                    setnpcframe(arg0, 1.0)
                EndIf
                If (rand($32, $01) = $01) Then
                    rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                EndIf
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                If (rand($64, $01) = $01) Then
                    arg0\Field10 = 1.0
                EndIf
            Case 1.0
                If (local3 <> 0) Then
                    arg0\Field10 = 2.0
                    Return $00
                EndIf
                local5 = $00
                If ((Float millisecs()) > arg0\Field12) Then
                    hideentity(arg0\Field3)
                    entitypick(arg0\Field3, 1.5)
                    If (pickedentity() <> $00) Then
                        local5 = $01
                    EndIf
                    showentity(arg0\Field3)
                    If (rand($05, $01) = $01) Then
                        arg0\Field10 = 0.0
                    EndIf
                    arg0\Field12 = (Float (millisecs() + $3E8))
                EndIf
                rotateentity(arg0\Field3, 0.0, (entityyaw(arg0\Field3, $01) + (rnd(80.0, 110.0) * (Float local5))), 0.0, $01)
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 10.0)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                If (10.0 > arg0\Field14) Then
                    animatenpc(arg0, 1.0, 10.0, 0.3, $00)
                EndIf
            Case 2.0
                local7 = Null
                For local6 = Each items
                    If (((local6\Field4\Field2 = $6C) And (local6\Field15 = $00)) <> 0) Then
                        If (1.0 > entitydistancesquared(arg0\Field3, local6\Field2)) Then
                            local7 = local6
                            Exit
                        EndIf
                    EndIf
                Next
                If (local7 = Null) Then
                    If (local3 <> 0) Then
                        giveachievement("999", $01)
                        pointentity(arg0\Field3, me\Field60, 0.0)
                        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                        arg0\Field12 = 105.0
                        arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 25.0)
                    EndIf
                Else
                    pointentity(arg0\Field3, local7\Field2, 0.0)
                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $01), 0.0, $01)
                    arg0\Field12 = 105.0
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 25.0)
                    If (0.09 > entitydistancesquared(arg0\Field3, local7\Field2)) Then
                        playsoundex(loadtempsound("SFX\SCP\458\Eating.ogg"), camera, arg0\Field3, 3.0, 0.5, $00)
                        removeitem(local7)
                    EndIf
                EndIf
                arg0\Field12 = max((arg0\Field12 - fps\Field7[$00]), 0.0)
                If (0.0 < arg0\Field12) Then
                    arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 40.0)
                    If (0.64 > local0) Then
                        moveentity(arg0\Field3, 0.0, 0.0, ((- arg0\Field24) * fps\Field7[$00]))
                    ElseIf (1.0 < local0) Then
                        If (10.0 > arg0\Field14) Then
                            animatenpc(arg0, 1.0, 10.0, 0.3, $00)
                        EndIf
                        moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    Else
                        arg0\Field24 = 0.0
                        If (0.5 < me\Field31) Then
                            me\Field35 = 1.0
                        EndIf
                    EndIf
                    If (0.001 >= arg0\Field24) Then
                        animatenpc(arg0, clamp(animtime(arg0\Field0), 1.0, 11.0), 74.0, 0.3, $00)
                    ElseIf (73.9 <= arg0\Field14) Then
                        setnpcframe(arg0, 1.0)
                    EndIf
                Else
                    arg0\Field10 = 0.0
                EndIf
            Case 3.0
                If (arg0\Field13 = $00) Then
                    createhintmsg(getlocalstring("msg", "999_follow"), 6.0, $00)
                    arg0\Field13 = $01
                EndIf
                If (0.0 >= arg0\Field41) Then
                    local9 = 0.0
                    local10 = 0.0
                    local11 = 0.0
                    For local8 = Each rooms
                        If (local8\Field7\Field6 = $56) Then
                            local9 = entityx(local8\Field2, $00)
                            local10 = 0.2
                            local11 = entityz(local8\Field2, $00)
                            Exit
                        EndIf
                    Next
                    arg0\Field40 = findpath(arg0, local9, local10, local11)
                    arg0\Field41 = 700.0
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
                            arg0\Field24 = curvevalue((arg0\Field23 * 1.5), arg0\Field24, 40.0)
                            translateentity(arg0\Field3, ((cos((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), 0.0, ((sin((entityyaw(arg0\Field3, $01) + 90.0)) * arg0\Field24) * fps\Field7[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field24 * 26.0), $01)
                            usedoornpc(arg0, $01, $01)
                        EndIf
                        arg0\Field41 = (arg0\Field41 - fps\Field7[$00])
                    Else
                        arg0\Field24 = 0.0
                        animatenpc(arg0, clamp(animtime(arg0\Field0), 1.0, 11.0), 74.0, 0.3, $00)
                        If (73.9 <= arg0\Field14) Then
                            setnpcframe(arg0, 1.0)
                        EndIf
                        If (rand($32, $01) = $01) Then
                            rotateentity(arg0\Field3, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        arg0\Field41 = (arg0\Field41 - (fps\Field7[$00] * 2.0))
                    EndIf
                    arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                EndIf
        End Select
        If (rand($A0, $01) = $01) Then
            If (channelplaying(arg0\Field18) = $00) Then
                arg0\Field18 = playsoundex(loadtempsound((("SFX\SCP\999\Gurgling" + (Str rand($00, $03))) + ".ogg")), camera, arg0\Field3, 5.0, 0.3, $00)
            EndIf
        EndIf
        If (0.0 < arg0\Field24) Then
            If ((Float millisecs()) > arg0\Field11) Then
                local2 = createpivot($00)
                positionentity(local2, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.3), entityz(arg0\Field3, $00), $00)
                turnentity(local2, 90.0, 0.0, 0.0, $00)
                If (entitypick(local2, 0.6) <> 0) Then
                    local1 = createdecal($14, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.3, 0.36), 0.4, $00, $01, $00, $00, $00)
                    local1\Field7 = -0.0003
                    entityparent(local1\Field0, playerroom\Field2, $01)
                EndIf
                freeentity(local2)
                local2 = $00
                arg0\Field11 = (Float (millisecs() + $3E8))
            EndIf
        EndIf
    ElseIf (arg0\Field29 = $00) Then
        For local8 = Each rooms
            If (local8\Field7\Field6 = $56) Then
                tformpoint(820.0, -256.0, 0.0, local8\Field2, $00)
                Exit
            EndIf
        Next
        teleportentity(arg0\Field3, tformedx(), tformedy(), tformedz(), 0.3, $00, 2.0, $00)
        arg0\Field29 = $01
        arg0\Field10 = 0.0
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.15), entityz(arg0\Field3, $00), $00)
    rotateentity(arg0\Field0, 0.0, (arg0\Field15 + 90.0), 0.0, $00)
    Return $00
End Function
