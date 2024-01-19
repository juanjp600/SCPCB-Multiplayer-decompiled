Function animateguns%()
    Local local0%
    If (eqquipedgun <> Null) Then
        positionentity(gunpivot, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        local0 = $00
        If (5.0 <= getanglemax(entitypitch(camera, $00), entitypitch(gunpivot, $00))) Then
            rotateentity(gunpivot, wrapangle((entitypitch(camera, $00) - 5.0)), entityyaw(gunpivot, $00), entityroll(gunpivot, $00), $00)
            local0 = $01
        EndIf
        If (-5.0 >= getanglemax(entitypitch(camera, $00), entitypitch(gunpivot, $00))) Then
            rotateentity(gunpivot, wrapangle((entitypitch(camera, $00) + 5.0)), entityyaw(gunpivot, $00), entityroll(gunpivot, $00), $00)
            local0 = $01
        EndIf
        If (5.0 <= getanglemax(entityyaw(camera, $00), entityyaw(gunpivot, $00))) Then
            rotateentity(gunpivot, entitypitch(gunpivot, $00), wrapangle((entityyaw(camera, $00) - 5.0)), entityroll(gunpivot, $00), $00)
            local0 = $01
        EndIf
        If (-5.0 >= getanglemax(entityyaw(camera, $00), entityyaw(gunpivot, $00))) Then
            rotateentity(gunpivot, entitypitch(gunpivot, $00), wrapangle((entityyaw(camera, $00) + 5.0)), entityroll(gunpivot, $00), $00)
            local0 = $01
        EndIf
        If (eqquipedgun\Field0 < $0B) Then
            moveentity(gunpivot, eqquipedgun\Field30[$00], eqquipedgun\Field30[$01], 0.0)
            If (((eqquipedgun\Field29 = $01) And (0.0 = eqquipedgun\Field5)) <> 0) Then
                eqquipedgun\Field30[$00] = curvevalue(eqquipedgun\Field28, eqquipedgun\Field30[$00], 10.0)
                currentfov = curvevalue((mainfov - 10.0), currentfov, 5.0)
            Else
                eqquipedgun\Field30[$00] = curvevalue(0.0, eqquipedgun\Field30[$00], 10.0)
                currentfov = curvevalue(mainfov, currentfov, 5.0)
            EndIf
            eqquipedgun\Field29 = (mousedown($02) * caninteract())
            If (spectate\Field1 <> $FFFFFFFF) Then
                If (player[spectate\Field1] <> Null) Then
                    If (player[spectate\Field1]\Field102 <> 0) Then
                        eqquipedgun\Field29 = $01
                    EndIf
                EndIf
            EndIf
        EndIf
        If (((eqquipedgun\Field29 = $01) And (0.0 = eqquipedgun\Field5)) <> 0) Then
            weaponshake = curvevalue(0.0, weaponshake, 10.0)
        Else
            weaponshake = curvevalue((((- sin((shake / 2.0))) * 2.5) * 0.0012), weaponshake, 10.0)
        EndIf
        moveentity(gunpivot, weaponshake, (cos(((Float millisecs()) * 0.05)) * 0.003), 0.0)
        Select eqquipedgun\Field0
            Case $0D,$0E,$0F
                moveentity(gunpivot, 0.3, -0.05, 0.0)
                rotateentity(gunpivot, entitypitch(gunpivot, $00), entityyaw(gunpivot, $00), -90.0, $00)
                If (mousedown($02) <> 0) Then
                    eqquipedgun\Field7 = $00
                    animate2(eqquipedgun\Field10, animtime(eqquipedgun\Field10), (Int getshootanim(eqquipedgun, $00)), (Int getshootanim(eqquipedgun, $00)), 0.5, $00)
                    eqquipedgun\Field8 = getshootanim(eqquipedgun, $00)
                    eqquipedgun\Field3 = 1.0
                    eqquipedgun\Field35 = $01
                EndIf
        End Select
    EndIf
    Return $00
End Function
