Function updatemouselook%()
    Local local0%
    Local local1%
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13%
    Local local14%
    catcherrors("UpdateMouseLook()")
    local2 = (fps\Field7[$00] / 10.0)
    me\Field23 = max((me\Field23 - local2), 0.0)
    me\Field24 = max((me\Field24 - local2), 0.0)
    camerazoom(camera, (min(((me\Field52 / 400.0) + 1.0), 1.1) / camerazoomvalue))
    me\Field52 = max((me\Field52 - fps\Field7[$00]), 0.0)
    If (((0.0 = me\Field0) And (0.0 <= me\Field3)) <> 0) Then
        me\Field37 = 0.0
        If (isnan(entityx(me\Field60, $00)) <> 0) Then
            positionentity(me\Field60, entityx(camera, $01), (entityy(camera, $01) - 0.5), entityz(camera, $01), $01)
            createconsolemsg(format(getlocalstring("console", "xyz.reset"), (Str entityx(me\Field60, $00)), "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        EndIf
        local3 = ((sin(me\Field22) / ((me\Field40 * 20.0) + 20.0)) * 0.6)
        local4 = (clamp((min(((me\Field31 * (1.0 - ((Float (0.0 < i_1025\Field1[$03])) * 0.75))) + 0.25), 3.0) * (sin((me\Field22 / 2.0)) * 2.5)), -8.0, 8.0) + me\Field41)
        rotateentity(camera, entitypitch(me\Field60, $00), entityyaw(me\Field60, $00), (local4 / 2.0), $00)
        local5 = entityyaw(camera, $00)
        positionentity(camera, (entityx(me\Field60, $00) - ((me\Field41 * cos(local5)) * 0.0055)), (((entityy(me\Field60, $00) + local3) + 0.6) + (me\Field40 * -0.3)), (entityz(me\Field60, $00) - ((me\Field41 * sin(local5)) * 0.0055)), $00)
        local6 = (opt\Field45 + 0.5)
        local7 = ((5.0 / (opt\Field45 + 1.0)) * opt\Field42)
        If (0.0 < opt\Field42) Then
            mo\Field7 = curvevalue(((Float (($01 - (opt\Field43 Shl $01)) * mousexspeed())) * local6), mo\Field7, local7)
            If (isnan(mo\Field7) <> 0) Then
                mo\Field7 = 0.0
            EndIf
            mo\Field8 = curvevalue(((Float (($01 - (opt\Field44 Shl $01)) * mouseyspeed())) * local6), mo\Field8, local7)
            If (isnan(mo\Field8) <> 0) Then
                mo\Field8 = 0.0
            EndIf
        Else
            mo\Field7 = ((Float (($01 - (opt\Field43 Shl $01)) * mousexspeed())) * local6)
            If (isnan(mo\Field7) <> 0) Then
                mo\Field7 = 0.0
            EndIf
            mo\Field8 = ((Float (($01 - (opt\Field44 Shl $01)) * mouseyspeed())) * local6)
            If (isnan(mo\Field8) <> 0) Then
                mo\Field8 = 0.0
            EndIf
        EndIf
        If ((((((invopen Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor ((((menuopen Lor consoleopen) Lor (0.0 > me\Field45)) Lor ismultiplayerhudenabled) And (mp_getsocket() <> $00))) <> 0) Then
            stopmousemovement()
        EndIf
        local8 = (0.3 / ((Float wi\Field3) + 1.0))
        local9 = (mo\Field7 * local8)
        local10 = (mo\Field8 * local8)
        turnentity(me\Field60, 0.0, (- local9), 0.0, $00)
        camerapitch = (camerapitch + local10)
        camerapitch = clamp(camerapitch, -70.0, 70.0)
        local11 = (me\Field23 + me\Field24)
        rotateentity(camera, wrapangle((rnd((- local11), local11) + camerapitch), 360.0), wrapangle((entityyaw(me\Field60, $00) + rnd((- local11), local11)), 360.0), local4, $00)
        If (playerroom\Field7\Field6 = $69) Then
            local12 = entityy(me\Field60, $00)
            If ((((1.0 / 0.128) > local12) Lor (10.1875 < local12)) <> 0) Then
                rotateentity(camera, wrapangle(entitypitch(camera, $00), 360.0), wrapangle(entityyaw(camera, $00), 360.0), (wrapangle((sin(((Float millisec) / 150.0)) * 30.0), 360.0) + local4), $00)
            EndIf
        EndIf
        If (((((((menuopen Lor invopen) Lor consoleopen) Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor ismultiplayerhudenabled) = $00) Then
            movemouse(mo\Field9, mo\Field10)
        EndIf
    ElseIf (((((mp_terminated\Field0 And (0.0 >= mp_terminated\Field6)) = $00) Lor (mp_getsocket() = $00)) Lor ((0.0 > me\Field3) And (0.0 = me\Field0))) <> 0) Then
        If (entityhidden(me\Field60) = $00) Then
            hideentity(me\Field60)
        EndIf
        translateentity(me\Field60, 0.0, (fps\Field7[$00] * -0.002), 0.0, $00)
        resetentity(me\Field60)
        positionentity(camera, entityx(me\Field61, $00), entityy(me\Field61, $00), entityz(me\Field61, $00), $00)
        local13 = $00
        local14 = countcollisions(me\Field61)
        For local1 = $01 To local14 Step $01
            If ((entityy(me\Field61, $00) - 0.01) > collisiony(me\Field61, local1)) Then
                local13 = $01
                Exit
            EndIf
        Next
        If (local13 <> 0) Then
            me\Field37 = 0.0
        Else
            If (me\Field1 = $00) Then
                moveentity(me\Field61, 0.0, 0.0, me\Field37)
                rotateentity(me\Field61, curveangle(-89.9, entitypitch(me\Field61, $00), 20.0), entityyaw(me\Field61, $00), entityroll(me\Field61, $00), $00)
                rotateentity(camera, curveangle((entitypitch(me\Field61, $00) - 40.0), entitypitch(camera, $00), 40.0), entityyaw(camera, $00), entityroll(camera, $00), $00)
            Else
                moveentity(me\Field61, 0.0, 0.0, (- me\Field37))
                rotateentity(me\Field61, curveangle(89.9, entitypitch(me\Field61, $00), 20.0), entityyaw(me\Field61, $00), entityroll(me\Field61, $00), $00)
                rotateentity(camera, curveangle((entitypitch(me\Field61, $00) + 40.0), entitypitch(camera, $00), 40.0), entityyaw(camera, $00), entityroll(camera, $00), $00)
            EndIf
            me\Field37 = (me\Field37 - (fps\Field7[$00] * 0.002))
        EndIf
    EndIf
    updatedust()
    If ((((wi\Field0 > $00) Lor (wi\Field2 > $00)) Lor (i_1499\Field0 > $00)) <> 0) Then
        If (entityhidden(t\Field3[((wi\Field2 > $00) + $01)]) <> 0) Then
            showentity(t\Field3[((wi\Field2 > $00) + $01)])
        EndIf
        If (0.0 = me\Field0) Then
            If (channelplaying(breathchn) <> 0) Then
                If (channelplaying(breathgasrelaxedchn) <> 0) Then
                    stopchannel(breathgasrelaxedchn)
                    breathgasrelaxedchn = $00
                EndIf
            ElseIf (channelplaying(breathgasrelaxedchn) = $00) Then
                breathgasrelaxedchn = playsound_strict(snd_i\Field55, $01)
                channelvolume(breathgasrelaxedchn, (opt\Field21 * opt\Field16))
            EndIf
        EndIf
        If (((((wi\Field0 <> $02) And (wi\Field0 <> $04)) And (wi\Field2 <> $02)) And (wi\Field2 <> $04)) <> 0) Then
            If (channelplaying(breathchn) <> 0) Then
                wi\Field1 = min(((fps\Field7[$00] * rnd(0.5, 1.6)) + wi\Field1), 100.0)
            Else
                wi\Field1 = max(0.0, (wi\Field1 - (fps\Field7[$00] * 0.3)))
            EndIf
            If (((0.0 < wi\Field1) And ((-6.0 < me\Field10) Lor (-11.0 > me\Field10))) <> 0) Then
                entityalpha(t\Field3[$09], min((((wi\Field1 * 0.2) * (wi\Field1 * 0.2)) / 1000.0), 0.45))
                If (entityhidden(t\Field3[$09]) <> 0) Then
                    showentity(t\Field3[$09])
                EndIf
            ElseIf (entityhidden(t\Field3[$09]) = $00) Then
                hideentity(t\Field3[$09])
            EndIf
        EndIf
    Else
        If (channelplaying(breathgasrelaxedchn) <> 0) Then
            stopchannel(breathgasrelaxedchn)
            breathgasrelaxedchn = $00
        EndIf
        wi\Field1 = max(0.0, (wi\Field1 - (fps\Field7[$00] * 0.3)))
        If (entityhidden(t\Field3[$01]) = $00) Then
            hideentity(t\Field3[$01])
        EndIf
        If (entityhidden(t\Field3[$02]) = $00) Then
            hideentity(t\Field3[$02])
        EndIf
        If (entityhidden(t\Field3[$09]) = $00) Then
            hideentity(t\Field3[$09])
        EndIf
    EndIf
    If (((wi\Field5 > $00) Lor (wi\Field9 > $00)) <> 0) Then
        If (entityhidden(t\Field3[$04]) <> 0) Then
            showentity(t\Field3[$04])
        EndIf
        If (entityhidden(t\Field3[$00]) = $00) Then
            hideentity(t\Field3[$00])
        EndIf
        Select wi\Field5
            Case $00
                entitycolor(t\Field3[$04], 200.0, 200.0, 200.0)
            Case $01
                entitycolor(t\Field3[$04], 0.0, 200.0, 0.0)
            Case $02
                entitycolor(t\Field3[$04], 0.0, 100.0, 200.0)
            Case $03
                entitycolor(t\Field3[$04], 200.0, 0.0, 0.0)
        End Select
    Else
        If (entityhidden(t\Field3[$04]) = $00) Then
            hideentity(t\Field3[$04])
        EndIf
        If ((entityhidden(t\Field3[$00]) And opt\Field39) <> 0) Then
            showentity(t\Field3[$00])
        EndIf
    EndIf
    catcherrors("Uncaught: UpdateMouseLook()")
    Return $00
End Function
