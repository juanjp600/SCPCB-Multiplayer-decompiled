Function mp_updateterminated%()
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5.mp_player
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    mp_terminated\Field6 = (mp_terminated\Field6 - fps\Field7[$00])
    If (((Int me\Field0) And (0.0 >= mp_terminated\Field6)) <> 0) Then
        If (mp_terminated\Field0 <> 0) Then
            grabbedentity = $00
            handentity = $00
            d_i\Field9 = $00
            d_i\Field7 = Null
            closestitem = Null
            wi\Field0 = $00
            wi\Field2 = $00
            wi\Field3 = $00
            wi\Field4 = $00
            wi\Field5 = $00
            wi\Field9 = $00
            hideentity(me\Field60)
            me\Field49 = 0.0
            me\Field31 = 0.0
            me\Field32 = 0.0
            me\Field49 = 0.0
            me\Field26 = 0.0
            me\Field30 = 0.0
            me\Field10 = 10.0
            me\Field36 = 0.0
            If (1.0 < me\Field12) Then
                me\Field12 = 1.0
                me\Field13 = 0.0
            EndIf
            me\Field15 = 0.0
            chs\Field6 = $00
            chs\Field7 = 0.0
            If ((((((invopen Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor ((((menuopen Lor consoleopen) Lor (0.0 > me\Field45)) Lor ismultiplayerhudenabled) And (mp_getsocket() <> $00))) <> 0) Then
                stopmousemovement()
            ElseIf (keyhit($1C) <> 0) Then
                mp_terminated\Field1 = (mp_terminated\Field1 = $00)
            EndIf
            local0 = (opt\Field45 + 0.5)
            local1 = ((5.0 / (opt\Field45 + 1.0)) * opt\Field42)
            If (0.0 < opt\Field42) Then
                mo\Field7 = curvevalue(((Float (($01 - (opt\Field43 Shl $01)) * mousexspeed())) * local0), mo\Field7, local1)
                If (isnan(mo\Field7) <> 0) Then
                    mo\Field7 = 0.0
                EndIf
                mo\Field8 = curvevalue(((Float (($01 - (opt\Field44 Shl $01)) * mouseyspeed())) * local0), mo\Field8, local1)
                If (isnan(mo\Field8) <> 0) Then
                    mo\Field8 = 0.0
                EndIf
            Else
                mo\Field7 = ((Float (($01 - (opt\Field43 Shl $01)) * mousexspeed())) * local0)
                If (isnan(mo\Field7) <> 0) Then
                    mo\Field7 = 0.0
                EndIf
                mo\Field8 = ((Float (($01 - (opt\Field44 Shl $01)) * mouseyspeed())) * local0)
                If (isnan(mo\Field8) <> 0) Then
                    mo\Field8 = 0.0
                EndIf
            EndIf
            local2 = 0.3
            local3 = (mo\Field7 * local2)
            local4 = (mo\Field8 * local2)
            turnentity(camera, 0.0, (- local3), 0.0, $00)
            camerapitch = (camerapitch + local4)
            camerapitch = clamp(camerapitch, -70.0, 70.0)
            rotateentity(camera, camerapitch, entityyaw(camera, $00), 0.0, $00)
            If (((mp_terminated\Field2 = Null) Lor entityhidden(mp_terminated\Field2\Field18)) <> 0) Then
                mp_terminated\Field2 = Null
                For local5 = Each mp_player
                    If (entityhidden(local5\Field18) = $00) Then
                        mp_terminated\Field2 = local5
                        Exit
                    EndIf
                Next
            EndIf
            Select mp_terminated\Field1
                Case $00
                    If (mp_terminated\Field2 <> Null) Then
                        local7 = (entityx(mp_terminated\Field2\Field18, $00) + (sin((- entityyaw(camera, $00))) * -1.0))
                        local8 = ((entityy(mp_terminated\Field2\Field18, $00) + 0.4) + (tan((- entitypitch(camera, $00))) * -1.0))
                        local9 = (entityz(mp_terminated\Field2\Field18, $00) + (cos((- entityyaw(camera, $00))) * -1.0))
                        positionentity(camera, local7, local8, local9, $00)
                        If (mp_rooms[mp_terminated\Field2\Field22] <> Null) Then
                            playerroom = mp_rooms[mp_terminated\Field2\Field22]
                        EndIf
                    Else
                        local10 = max(((Float keydown(key\Field7)) * 2.5), 1.0)
                        local11 = 0.018
                        local1 = (local11 * local10)
                        local1 = (chs\Field4 * local1)
                        If (keydown(key\Field4) <> 0) Then
                            moveentity(camera, 0.0, 0.0, (fps\Field7[$00] * (- local1)))
                        EndIf
                        If (keydown(key\Field3) <> 0) Then
                            moveentity(camera, 0.0, 0.0, (fps\Field7[$00] * local1))
                        EndIf
                        If (keydown(key\Field1) <> 0) Then
                            moveentity(camera, (fps\Field7[$00] * (- local1)), 0.0, 0.0)
                        EndIf
                        If (keydown(key\Field2) <> 0) Then
                            moveentity(camera, (fps\Field7[$00] * local1), 0.0, 0.0)
                        EndIf
                    EndIf
                Case $01
                    If (mp_terminated\Field2 <> Null) Then
                        positionentity(camera, entityx(mp_terminated\Field2\Field19, $01), entityy(mp_terminated\Field2\Field19, $01), entityz(mp_terminated\Field2\Field19, $01), $00)
                        rotateentity(camera, entitypitch(mp_terminated\Field2\Field19, $01), entityyaw(mp_terminated\Field2\Field19, $01), 0.0, $00)
                        If (mp_rooms[mp_terminated\Field2\Field22] <> Null) Then
                            playerroom = mp_rooms[mp_terminated\Field2\Field22]
                        EndIf
                        If (mp_terminated\Field2\Field35\Field0 <> $00) Then
                            hideentity(mp_terminated\Field2\Field35\Field0)
                        EndIf
                    Else
                        mp_terminated\Field1 = $00
                    EndIf
            End Select
            positionentity(me\Field60, entityx(camera, $00), (entityy(camera, $00) - 0.6), entityz(camera, $00), $00)
            resetentity(me\Field60)
            If (((((((menuopen Lor invopen) Lor consoleopen) Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor ismultiplayerhudenabled) = $00) Then
                movemouse(mo\Field9, mo\Field10)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
