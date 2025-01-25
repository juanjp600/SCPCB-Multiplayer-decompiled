Function mp_updatenpctypeguard%(arg0.npcs)
    Local local0.waypoints
    Local local1.waypoints
    Local local2#
    Local local3#
    Local local4%
    Local local6#
    Local local7#
    Local local8%
    Local local9%
    Local local10#
    local2 = arg0\Field14
    arg0\Field54 = ""
    arg0\Field52 = $00
    arg0\Field53 = $00
    arg0\Field58 = "Guard"
    Select arg0\Field10
        Case 1.0
            If (((((39.0 > arg0\Field14) Lor ((76.0 < arg0\Field14) And (245.0 > arg0\Field14))) Lor ((248.0 < arg0\Field14) And (302.0 > arg0\Field14))) Lor (344.0 < arg0\Field14)) <> 0) Then
                animatenpc(arg0, 345.0, 357.0, 0.2, $00)
                If (356.0 <= arg0\Field14) Then
                    setnpcframe(arg0, 302.0, $01)
                EndIf
            EndIf
            local3 = entitydistancesquared(arg0\Field3, me\Field60)
            local6 = (((Float selecteddifficulty\Field2) * 0.5) + 0.4)
            local7 = 121.0
            If (playerroom\Field7\Field6 = $49) Then
                local7 = 484.0
                local6 = (0.5 - (me\Field38 * 12.0))
            EndIf
            If (((chs\Field2 = $00) And (local7 > local3)) <> 0) Then
                local4 = createpivot($00)
                positionentity(local4, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
                pointentity(local4, me\Field60, 0.0)
                rotateentity(local4, min(entitypitch(local4, $00), 20.0), entityyaw(local4, $00), 0.0, $00)
                rotateentity(arg0\Field3, curveangle(entitypitch(local4, $00), entitypitch(arg0\Field3, $00), 10.0), curveangle(entityyaw(local4, $00), entityyaw(arg0\Field3, $00), 10.0), 0.0, $01)
                positionentity(local4, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.8), entityz(arg0\Field3, $00), $00)
                pointentity(local4, me\Field60, 0.0)
                rotateentity(local4, min(entitypitch(local4, $00), 40.0), entityyaw(arg0\Field3, $00), 0.0, $00)
                If (0.0 = arg0\Field28) Then
                    If (1.0 = arg0\Field12) Then
                        local8 = $00
                        msg\Field2 = format(getlocalstring("death", "guard.default"), subjectname, "%s")
                        If (playerroom\Field7\Field6 = $03) Then
                            msg\Field2 = format(getlocalstring("death", "guard.173"), subjectname, "%s")
                            local8 = $01
                        ElseIf (playerroom\Field7\Field6 = $49) Then
                            msg\Field2 = getlocalstring("death", "guard.gateb")
                        EndIf
                        playsoundex(snd_i\Field13[$00], camera, arg0\Field3, 35.0, 1.0, $00, $00)
                        rotateentity(local4, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), 0.0, $01)
                        positionentity(local4, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                        moveentity(local4, 0.0622, 0.83925, 0.5351)
                        pointentity(local4, me\Field60, 0.0)
                        shoot(arg0, entityx(local4, $00), entityy(local4, $00), entityz(local4, $00), arg0\Field3, local6, $01, local8)
                        arg0\Field28 = 8.0
                    Else
                        arg0\Field24 = arg0\Field23
                    EndIf
                EndIf
                If (((0.0 < arg0\Field28) And (8.0 >= arg0\Field28)) <> 0) Then
                    animatenpc(arg0, 245.0, 248.0, 0.35, $01)
                ElseIf (302.0 > arg0\Field14) Then
                    animatenpc(arg0, 302.0, 344.0, 0.35, $01)
                EndIf
                freeentity(local4)
                local4 = $00
            Else
                animatenpc(arg0, 302.0, 344.0, 0.35, $01)
            EndIf
            arg0\Field52 = $01
            arg0\Field54 = "Chest"
            If (10.0 = arg0\Field11) Then
                arg0\Field53 = $03
            Else
                arg0\Field53 = $00
            EndIf
        Case 2.0
            animatenpc(arg0, 245.0, 248.0, 0.35, $01)
            If (0.0 = arg0\Field28) Then
                playsoundex(snd_i\Field13[$00], camera, arg0\Field3, 15.0, 1.0, $00, $00)
                local4 = createpivot($00)
                rotateentity(local4, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), 0.0, $01)
                positionentity(local4, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                moveentity(local4, 0.0622, 0.83925, 0.5351)
                setemitter(Null, entityx(local4, $00), entityy(local4, $00), entityz(local4, $00), $0D)
                arg0\Field28 = 8.0
            EndIf
        Case 3.0
            If (arg0\Field40 = $01) Then
                If (arg0\Field39[arg0\Field42] = Null) Then
                    If (arg0\Field42 > $14) Then
                        arg0\Field42 = $00
                        arg0\Field40 = $00
                    Else
                        arg0\Field42 = (arg0\Field42 + $01)
                    EndIf
                Else
                    animatenpc(arg0, 1.0, 38.0, (arg0\Field24 * 40.0), $01)
                    arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 20.0)
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    pointentity(arg0\Field0, arg0\Field39[arg0\Field42]\Field0, 0.0)
                    rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
                    If (0.04 > entitydistancesquared(arg0\Field3, arg0\Field39[arg0\Field42]\Field0)) Then
                        arg0\Field42 = (arg0\Field42 + $01)
                    EndIf
                EndIf
            Else
                If (0.0 = arg0\Field41) Then
                    arg0\Field40 = findpath(arg0, arg0\Field36, (arg0\Field37 + 0.5), arg0\Field38)
                EndIf
                local0 = Null
                local4 = createpivot($00)
                positionentity(local4, arg0\Field36, arg0\Field37, arg0\Field38, $00)
                For local1 = Each waypoints
                    If (4.0 > entitydistancesquared(local1\Field0, local4)) Then
                        local0 = local1
                        Exit
                    EndIf
                Next
                freeentity(local4)
                local4 = $00
                If (local0 <> Null) Then
                    arg0\Field41 = 1.0
                    If (entityvisible(local0\Field0, arg0\Field3) <> 0) Then
                        If (0.0 < (Abs deltayaw(arg0\Field3, local0\Field0))) Then
                            pointentity(arg0\Field0, local0\Field0, 0.0)
                            rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
                        EndIf
                    EndIf
                Else
                    arg0\Field41 = 0.0
                EndIf
                If (1.0 = arg0\Field41) Then
                    animatenpc(arg0, 1.0, 38.0, (arg0\Field24 * 40.0), $01)
                    arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 20.0)
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                EndIf
            EndIf
        Case 4.0
            animatenpc(arg0, 77.0, 201.0, 0.2, $01)
            If (rand($190, $01) = $01) Then
                arg0\Field15 = rnd(-180.0, 180.0)
            EndIf
            rotateentity(arg0\Field3, 0.0, curveangle((arg0\Field15 + (sin((Float (millisec / $32))) * 2.0)), entityyaw(arg0\Field3, $00), 150.0), 0.0, $01)
            If (225.0 > entitydistancesquared(arg0\Field3, me\Field60)) Then
                If (((90.0 > wrapangle((entityyaw(arg0\Field3, $00) - deltayaw(arg0\Field3, me\Field60)), 360.0)) And entityvisible(me\Field60, arg0\Field3)) <> 0) Then
                    arg0\Field10 = 1.0
                EndIf
            EndIf
        Case 5.0
            rotateentity(arg0\Field3, 0.0, curveangle((vectoryaw((arg0\Field36 - entityx(arg0\Field3, $00)), 0.0, (arg0\Field38 - entityz(arg0\Field3, $00))) + arg0\Field15), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
            local3 = distancesquared(entityx(arg0\Field3, $00), arg0\Field36, entityz(arg0\Field3, $00), arg0\Field38, 0.0, 0.0)
            animatenpc(arg0, 1.0, 38.0, (arg0\Field24 * 40.0), $01)
            If (((4.0 < local3) Lor (1.0 > local3)) <> 0) Then
                arg0\Field24 = curvevalue(((arg0\Field23 * (Sgn (sqr(local3) - 1.5))) * 0.75), arg0\Field24, 10.0)
            Else
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 10.0)
            EndIf
            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
        Case 7.0
            animatenpc(arg0, 77.0, 201.0, 0.2, $01)
        Case 8.0
        Case 9.0
            animatenpc(arg0, 77.0, 201.0, 0.2, $01)
            arg0\Field54 = "head"
            arg0\Field52 = $01
            arg0\Field53 = $00
            arg0\Field15 = entityyaw(arg0\Field3, $00)
        Case 10.0
            animatenpc(arg0, 1.0, 38.0, (arg0\Field24 * 40.0), $01)
            arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 20.0)
            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
        Case 11.0
            If (((((39.0 > arg0\Field14) Lor ((76.0 < arg0\Field14) And (245.0 > arg0\Field14))) Lor ((248.0 < arg0\Field14) And (302.0 > arg0\Field14))) Lor (344.0 < arg0\Field14)) <> 0) Then
                animatenpc(arg0, 345.0, 357.0, 0.2, $00)
                If (356.0 <= arg0\Field14) Then
                    setnpcframe(arg0, 302.0, $01)
                EndIf
            EndIf
            local3 = entitydistancesquared(arg0\Field3, me\Field60)
            local9 = ((((chs\Field2 Lor i_268\Field2) = $00) And (121.0 > local3)) And entityvisible(arg0\Field3, me\Field60))
            If (local9 <> 0) Then
                local4 = createpivot($00)
                positionentity(local4, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
                pointentity(local4, me\Field60, 0.0)
                rotateentity(local4, min(entitypitch(local4, $00), 20.0), entityyaw(local4, $00), 0.0, $00)
                rotateentity(arg0\Field3, curveangle(entitypitch(local4, $00), entitypitch(arg0\Field3, $00), 10.0), curveangle(entityyaw(local4, $00), entityyaw(arg0\Field3, $00), 10.0), 0.0, $01)
                positionentity(local4, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.8), entityz(arg0\Field3, $00), $00)
                pointentity(local4, me\Field60, 0.0)
                rotateentity(local4, min(entitypitch(local4, $00), 40.0), entityyaw(arg0\Field3, $00), 0.0, $00)
                If (0.0 = arg0\Field28) Then
                    If (1.0 = arg0\Field12) Then
                        local8 = $00
                        msg\Field2 = ""
                        playsoundex(snd_i\Field13[$00], camera, arg0\Field3, 15.0, 1.0, $00, $00)
                        rotateentity(local4, entitypitch(arg0\Field3, $00), entityyaw(arg0\Field3, $00), 0.0, $01)
                        positionentity(local4, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                        moveentity(local4, 0.0622, 0.83925, 0.5351)
                        pointentity(local4, me\Field60, 0.0)
                        local10 = sqr(local3)
                        shoot(arg0, entityx(local4, $00), entityy(local4, $00), entityz(local4, $00), arg0\Field3, ((25.0 / local10) * (1.0 / local10)), $01, local8)
                        arg0\Field28 = 8.0
                    Else
                        arg0\Field24 = arg0\Field23
                    EndIf
                EndIf
                If (((0.0 < arg0\Field28) And (8.0 >= arg0\Field28)) <> 0) Then
                    animatenpc(arg0, 245.0, 248.0, 0.35, $01)
                ElseIf (302.0 > arg0\Field14) Then
                    animatenpc(arg0, 302.0, 344.0, 0.35, $01)
                EndIf
                freeentity(local4)
                local4 = $00
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
                        animatenpc(arg0, 39.0, 76.0, (arg0\Field24 * 40.0), $01)
                        arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 20.0)
                        moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                        pointentity(arg0\Field0, arg0\Field39[arg0\Field42]\Field0, 0.0)
                        rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
                        If (0.04 > entitydistancesquared(arg0\Field3, arg0\Field39[arg0\Field42]\Field0)) Then
                            arg0\Field42 = (arg0\Field42 + $01)
                        EndIf
                    EndIf
                Else
                    If (0.0 = arg0\Field41) Then
                        arg0\Field40 = findpath(arg0, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.5), entityz(me\Field60, $00))
                    EndIf
                    local0 = Null
                    For local1 = Each waypoints
                        If (4.0 > entitydistancesquared(local1\Field0, me\Field60)) Then
                            local0 = local1
                            Exit
                        EndIf
                    Next
                    If (local0 <> Null) Then
                        arg0\Field41 = 1.0
                        If (entityvisible(local0\Field0, arg0\Field3) <> 0) Then
                            If (0.0 < (Abs deltayaw(arg0\Field3, local0\Field0))) Then
                                pointentity(arg0\Field0, local0\Field0, 0.0)
                                rotateentity(arg0\Field3, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 20.0), 0.0, $00)
                            EndIf
                        EndIf
                    Else
                        arg0\Field41 = 0.0
                    EndIf
                    If (1.0 = arg0\Field41) Then
                        animatenpc(arg0, 39.0, 76.0, (arg0\Field24 * 40.0), $01)
                        arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 20.0)
                        moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    EndIf
                EndIf
                If ((((43.0 > local2) And (43.0 <= arg0\Field14)) Lor ((61.0 > local2) And (61.0 <= arg0\Field14))) <> 0) Then
                    playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
                EndIf
            EndIf
        Case 12.0
            If (((((39.0 > arg0\Field14) Lor ((76.0 < arg0\Field14) And (245.0 > arg0\Field14))) Lor ((248.0 < arg0\Field14) And (302.0 > arg0\Field14))) Lor (344.0 < arg0\Field14)) <> 0) Then
                animatenpc(arg0, 345.0, 357.0, 0.2, $00)
                If (356.0 <= arg0\Field14) Then
                    setnpcframe(arg0, 302.0, $01)
                EndIf
            EndIf
            If (345.0 > arg0\Field14) Then
                animatenpc(arg0, 302.0, 344.0, 0.35, $01)
            EndIf
            local4 = createpivot($00)
            positionentity(local4, entityx(arg0\Field3, $00), entityy(arg0\Field3, $00), entityz(arg0\Field3, $00), $00)
            If (1.0 = arg0\Field11) Then
                pointentity(local4, me\Field60, 0.0)
            Else
                rotateentity(local4, 0.0, arg0\Field15, 0.0, $00)
            EndIf
            rotateentity(local4, min(entitypitch(local4, $00), 20.0), entityyaw(local4, $00), 0.0, $00)
            rotateentity(arg0\Field3, curveangle(entitypitch(local4, $00), entitypitch(arg0\Field3, $00), 10.0), curveangle(entityyaw(local4, $00), entityyaw(arg0\Field3, $00), 10.0), 0.0, $01)
            positionentity(local4, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) + 0.8), entityz(arg0\Field3, $00), $00)
            If (1.0 = arg0\Field11) Then
                pointentity(local4, me\Field60, 0.0)
                arg0\Field52 = $01
                arg0\Field54 = "Chest"
                arg0\Field53 = $00
            Else
                rotateentity(local4, 0.0, arg0\Field15, 0.0, $00)
            EndIf
            rotateentity(local4, min(entitypitch(local4, $00), 40.0), entityyaw(arg0\Field3, $00), 0.0, $00)
            freeentity(local4)
            local4 = $00
        Case 13.0
            animatenpc(arg0, 202.0, 244.0, 0.35, $01)
        Case 14.0
            If (arg0\Field40 = $02) Then
                arg0\Field10 = 13.0
                arg0\Field24 = 0.0
            ElseIf (arg0\Field40 = $01) Then
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
                    animatenpc(arg0, 39.0, 76.0, (arg0\Field24 * 40.0), $01)
                    arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 20.0)
                    moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                    If (0.04 > entitydistancesquared(arg0\Field3, arg0\Field39[arg0\Field42]\Field0)) Then
                        arg0\Field42 = (arg0\Field42 + $01)
                    EndIf
                EndIf
            Else
                arg0\Field24 = 0.0
                arg0\Field10 = 13.0
            EndIf
            If ((((43.0 > local2) And (43.0 <= arg0\Field14)) Lor ((61.0 > local2) And (61.0 <= arg0\Field14))) <> 0) Then
                playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
            EndIf
        Case 15.0
            If (arg0\Field1 <> $00) Then
                If (entityhidden(arg0\Field1) <> 0) Then
                    showentity(arg0\Field1)
                EndIf
                animatenpc(arg0, 623.0, 642.0, 0.3, $01)
                If (channelplaying(arg0\Field20) <> 0) Then
                    stopchannel(arg0\Field20)
                    arg0\Field20 = $00
                EndIf
                arg0\Field18 = loopsoundex(snd_i\Field57[$00], arg0\Field18, camera, arg0\Field1, 10.0, 1.0, $00)
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
            Else
                openconsoleonerror(format(getlocalstring("runerr", "guard.state"), "15.0", "%s"))
            EndIf
        Case 16.0
            If (arg0\Field1 <> $00) Then
                If (entityhidden(arg0\Field1) <> 0) Then
                    showentity(arg0\Field1)
                EndIf
                animatenpc(arg0, 623.0, 642.0, 0.3, $01)
                If (channelplaying(arg0\Field18) <> 0) Then
                    stopchannel(arg0\Field18)
                    arg0\Field18 = $00
                EndIf
                arg0\Field20 = loopsoundex(snd_i\Field57[$01], arg0\Field20, camera, arg0\Field1, 12.0, 1.0, $00)
                arg0\Field24 = curvevalue((arg0\Field23 * 0.9), arg0\Field24, 20.0)
                animateex(arg0\Field1, animtime(arg0\Field1), $01, $14, (arg0\Field24 * 5.0), $01)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
            Else
                openconsoleonerror(format(getlocalstring("runerr", "guard.state"), "16.0", "%s"))
            EndIf
        Default
            If (rand($190, $01) = $01) Then
                arg0\Field13 = rand($FFFFFFE2, $1E)
            EndIf
            arg0\Field40 = $00
            animatenpc(arg0, 77.0, 201.0, 0.2, $01)
            rotateentity(arg0\Field3, 0.0, curveangle(((arg0\Field15 + (Float arg0\Field13)) + (sin((Float (millisec / $32))) * 2.0)), entityyaw(arg0\Field3, $00), 50.0), 0.0, $01)
    End Select
    If (0.01 < arg0\Field24) Then
        If ((((5.0 > local2) And (5.0 <= arg0\Field14)) Lor ((23.0 > local2) And (23.0 <= arg0\Field14))) <> 0) Then
            playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
        EndIf
    ElseIf (-0.01 > arg0\Field24) Then
        If ((((23.0 <= local2) And (23.0 > arg0\Field14)) Lor ((5.0 <= local2) And (5.0 > arg0\Field14))) <> 0) Then
            playsoundex(snd_i\Field56[rand($00, $02)], camera, arg0\Field3, 8.0, rnd(0.5, 0.7), $00, $00)
        EndIf
    EndIf
    arg0\Field28 = max(0.0, (arg0\Field28 - fps\Field7[$00]))
    If (arg0\Field1 <> $00) Then
        positionentity(arg0\Field1, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.2), entityz(arg0\Field3, $00), $00)
        rotateentity(arg0\Field1, 0.0, entityyaw(arg0\Field3, $00), 0.0, $00)
        positionentity(arg0\Field0, (entityx(arg0\Field1, $00) + 1.75), (entityy(arg0\Field1, $00) + 0.33), (entityz(arg0\Field1, $00) + 0.42), $00)
        rotateentity(arg0\Field0, 0.0, (entityyaw(arg0\Field1, $00) + 180.0), 0.0, $00)
    Else
        positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.2), entityz(arg0\Field3, $00), $00)
        rotateentity(arg0\Field0, 0.0, (entityyaw(arg0\Field3, $00) + 180.0), 0.0, $00)
    EndIf
    Return $00
End Function
