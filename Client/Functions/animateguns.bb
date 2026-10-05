Function animateguns%()
    Local local0#
    Local local1#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17#
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
    Local local28#
    Local local29#
    Local local30#
    If (eqquipedgun <> Null) Then
        positionentity(gunpivot, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        moveentity(gunpivot, 0.0, 0.0, 0.01)
        local0 = 6.0
        local1 = 1.5
        Select eqquipedgun\Field0
            Case $01,$07
                local0 = 9.0
                local1 = 0.8
            Case $02,$03
                local0 = 7.5
                local1 = 1.2
            Case $09,$0A,$08
                local0 = 5.5
                local1 = 1.8
            Case $04,$05,$06
                local0 = 3.0
                local1 = 3.0
            Default
                local0 = 6.0
                local1 = 1.0
        End Select
        If (eqquipedgun\Field31 = $01) Then
            local0 = (local0 * 1.8)
            local1 = (local1 * 0.3)
        EndIf
        local3 = (entitypitch(camera, $00) - entitypitch(gunpivot, $00))
        local4 = (entityyaw(camera, $00) - entityyaw(gunpivot, $00))
        While (180.0 < local4)
            local4 = (local4 - 360.0)
        Wend
        While (-180.0 > local4)
            local4 = (local4 + 360.0)
        Wend
        local5 = f_clamp((5.0 * fpsfactor), 0.0, 1.0)
        local6 = lerp(entitypitch(gunpivot, $00), entitypitch(camera, $00), local5)
        local7 = lerp(entityyaw(gunpivot, $00), entityyaw(camera, $00), local5)
        local8 = 25.0
        local9 = ((local1 * 0.15) * (- local4))
        local9 = f_clamp(local9, (- local8), local8)
        local10 = (entityroll(camera, $00) + local9)
        rotateentity(gunpivot, local6, local7, local10, $00)
        If (0.0 < eqquipedgun\Field5) Then
            local11 = $00
            local12 = $00
            local13 = $00
            local14 = $0A
            local15 = $FFFFFFF1
            local16 = $FFFFFFE7
        EndIf
        If (eqquipedgun\Field0 < $0B) Then
            moveentity(gunpivot, eqquipedgun\Field32[$00], eqquipedgun\Field32[$01], eqquipedgun\Field32[$02])
            If (((eqquipedgun\Field31 = $01) And (0.0 = eqquipedgun\Field5)) <> 0) Then
                eqquipedgun\Field32[$00] = curvevalue(eqquipedgun\Field27, eqquipedgun\Field32[$00], 2.5)
                eqquipedgun\Field32[$01] = curvevalue(eqquipedgun\Field28, eqquipedgun\Field32[$01], 5.0)
                eqquipedgun\Field32[$02] = curvevalue(-0.05, eqquipedgun\Field32[$02], 4.0)
                currentfov = curvevalue((Abs max((mainfov - eqquipedgun\Field19), (Float ((Int mainfov) Shr $01)))), currentfov, 3.5)
            Else
                eqquipedgun\Field32[$00] = curvevalue((0.0 + (Float local11)), eqquipedgun\Field32[$00], 6.0)
                eqquipedgun\Field32[$01] = curvevalue((0.0 + (Float local12)), eqquipedgun\Field32[$01], 10.0)
                eqquipedgun\Field32[$02] = curvevalue((0.0 + (Float local13)), eqquipedgun\Field32[$02], 8.0)
                currentfov = curvevalue(mainfov, currentfov, 5.0)
            EndIf
            eqquipedgun\Field31 = (mousedown($02) * caninteract())
            If (spectate\Field1 <> $FFFFFFFF) Then
                If (player[spectate\Field1] <> Null) Then
                    If (player[spectate\Field1]\Field102 <> 0) Then
                        eqquipedgun\Field31 = $01
                    EndIf
                EndIf
            EndIf
        EndIf
        local17 = (shake + currspeed)
        If (((eqquipedgun\Field31 = $01) And (0.0 = eqquipedgun\Field5)) <> 0) Then
            local18 = (((sin((local17 * 0.5)) * 0.0002) * 1.0) * 5.0)
            local19 = (((cos(local17) * 0.0001) * 1.0) * 5.0)
            weaponshake = 0.0
        Else
            local20 = ((sin((local17 * 0.1)) * 0.003) * 1.0)
            local21 = ((cos((local17 * 0.2)) * 0.0015) * 1.0)
            weaponshake = curvevalue(local20, weaponshake, 20.0)
            local22 = (((sin((local17 * 0.5)) * 0.0012) * 1.0) * 5.0)
            local23 = (((cos(local17) * 0.0009) * 1.0) * 5.0)
            local24 = (- (crouchstate * 0.01))
            local18 = (weaponshake + local22)
            local19 = ((local24 + local23) + local21)
        EndIf
        moveentity(gunpivot, local18, local19, 0.0)
        eqquipedgun\Field39 = curvevalue((((- local4) * 0.005) * 1.0), eqquipedgun\Field39, 5.0)
        local25 = eqquipedgun\Field39
        local26 = curvevalue(((local3 * 0.004) * 1.0), entityy(eqquipedgun\Field38, $00), 5.0)
        local27 = 0.05
        local25 = f_clamp(local25, (- local27), local27)
        local26 = f_clamp(local26, (- local27), local27)
        positionentity(eqquipedgun\Field38, local25, local26, 0.0, $00)
        local28 = curvevalue(((local3 * 0.4) + (Float local14)), entitypitch(eqquipedgun\Field38, $00), 6.0)
        local29 = curvevalue(((local4 * 0.4) + (Float local15)), entityyaw(eqquipedgun\Field38, $00), 6.0)
        local30 = curvevalue((Float local16), entityroll(eqquipedgun\Field38, $00), 6.0)
        rotateentity(eqquipedgun\Field38, local28, local29, local30, $00)
        Select eqquipedgun\Field0
            Case $0D,$0E,$0F
                moveentity(gunpivot, 0.3, 0.0, -0.05)
                rotateentity(gunpivot, entitypitch(gunpivot, $00), entityyaw(gunpivot, $00), -10.0, $00)
                If (mousedown($02) <> 0) Then
                    eqquipedgun\Field7 = $00
                    animate2(eqquipedgun\Field10, animtime(eqquipedgun\Field10), (Int getshootanim(eqquipedgun, $00)), (Int getshootanim(eqquipedgun, $00)), 0.5, $00)
                    eqquipedgun\Field8 = getshootanim(eqquipedgun, $00)
                    eqquipedgun\Field3 = 1.0
                    eqquipedgun\Field37 = $01
                EndIf
        End Select
    EndIf
    Return $00
End Function
