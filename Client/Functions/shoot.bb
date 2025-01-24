Function shoot%(arg0.npcs, arg1#, arg2#, arg3#, arg4%, arg5#, arg6%, arg7%)
    Local local0.particles
    Local local1.decals
    Local local2.emitter
    Local local3%
    Local local4$
    Local local5%
    Local local6#
    Local local7%
    Local local9#
    Local local10#
    Local local11#
    local2 = setemitter(Null, arg1, arg2, arg3, $0D)
    entityparent(local2\Field6, arg4, $01)
    lightvolume = (templightvolume * 1.2)
    If (arg7 <> 0) Then
        playsoundex(snd_i\Field15, camera, me\Field60, 0.4, rnd(0.8, 1.0), $00)
        kill($01, $01, $00, $01)
        Return $00
    EndIf
    If (arg5 >= rnd(1.0, 0.0)) Then
        local7 = rand($11, $01)
        If (arg0\Field79 <> 0) Then
            turnentity(camera, rnd(-3.0, 3.0), rnd(-3.0, 3.0), 0.0, $00)
        EndIf
        Select local7
            Case $01,$02,$03,$04,$05,$06,$07,$08,$09,$0A
                If (wi\Field3 <> $02) Then
                    me\Field17 = (me\Field17 - (rnd(5.0, 0.0) * (Float (0.0 = i_1025\Field1[$03]))))
                EndIf
                injureplayer((rnd(0.61, 0.72) * local6), 0.0, rnd(200.0, 300.0), (0.43 * local6), 0.0)
                If (wi\Field3 > $00) Then
                    local4 = getlocalstring("msg", "bullet.vest")
                Else
                    local4 = getlocalstring("msg", "bullet.body")
                EndIf
            Case $0B
                me\Field17 = (me\Field17 - (rnd(10.0, 0.0) * (Float (0.0 = i_1025\Field1[$03]))))
                injureplayer((rnd(0.44, 0.54) * local6), 0.0, rnd(400.0, 500.0), 0.0, 0.0)
                local4 = getlocalstring("msg", "bullet.leg.left")
            Case $0C
                me\Field17 = (me\Field17 - (rnd(10.0, 0.0) * (Float (0.0 = i_1025\Field1[$03]))))
                injureplayer((rnd(0.44, 0.54) * local6), 0.0, rnd(400.0, 500.0), 0.0, 0.0)
                local4 = getlocalstring("msg", "bullet.leg.right")
            Case $0D
                injureplayer((rnd(0.44, 0.54) * local6), 0.0, rnd(400.0, 500.0), 0.0, 0.0)
                local4 = getlocalstring("msg", "bullet.arm.left")
            Case $0E
                injureplayer((rnd(0.44, 0.54) * local6), 0.0, rnd(400.0, 500.0), 0.0, 0.0)
                local4 = getlocalstring("msg", "bullet.arm.right")
            Case $0F
                injureplayer((rnd(0.75, 0.9) * local6), 0.0, 700.0, 0.0, 0.0)
                local4 = getlocalstring("msg", "bullet.neck")
            Case $10,$11
                If (wi\Field4 <> 0) Then
                    injureplayer(0.1, 0.0, 0.0, 0.0, 0.0)
                ElseIf ((((arg0\Field4 = $15) Lor (arg0\Field4 = $11)) Lor (arg0\Field4 = $14)) <> 0) Then
                    If (entityinview(arg0\Field0, camera) <> 0) Then
                        local4 = getlocalstring("msg", "bullet.face")
                    Else
                        local4 = getlocalstring("msg", "bullet.head")
                    EndIf
                    kill($01, $01, $00, $01)
                EndIf
        End Select
        If ((arg0\Field79 And (350.0 > msg\Field1)) <> 0) Then
            createmsg(local4, 6.0)
        EndIf
        If (6.0 < mp_getnpctargetinjuries(arg0)) Then
            kill($01, $01, $00, $01)
        EndIf
        If (((local7 > $0A) And (local7 < $10)) <> 0) Then
            local2 = setemitter(Null, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $0F)
        EndIf
        playsoundex(snd_i\Field15, camera, me\Field60, 0.4, rnd(0.8, 1.0), $00)
    ElseIf ((arg6 And (opt\Field0 > $00)) <> 0) Then
        local3 = createpivot($00)
        positionentity(local3, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.5), entityz(me\Field60, $00), $00)
        If (local2 <> Null) Then
            pointentity(local3, local2\Field6, 0.0)
        EndIf
        turnentity(local3, 0.0, 180.0, 0.0, $00)
        entitypick(local3, 2.5)
        If (pickedentity() <> $00) Then
            playsoundex(snd_i\Field14, camera, local3, 0.4, rnd(0.8, 1.0), $00)
            If (arg6 <> 0) Then
                local9 = pickedx()
                local10 = pickedy()
                local11 = pickedz()
                local0 = createparticle($00, local9, local10, local11, 0.03, 0.0, 80.0)
                local0\Field4 = 0.001
                local0\Field11 = 0.003
                local0\Field2 = 0.8
                local0\Field10 = -0.01
                rotateentity(local0\Field1, (entitypitch(local3, $00) - 180.0), entityyaw(local3, $00), 0.0, $00)
                For local5 = $00 To rand($02, $03) Step $01
                    local0 = createparticle($00, local9, local10, local11, 0.006, 0.003, 80.0)
                    local0\Field4 = 0.02
                    local0\Field2 = 0.8
                    local0\Field10 = -0.01
                    rotateentity(local0\Field1, (entitypitch(local3, $00) + rnd(170.0, 190.0)), (entityyaw(local3, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                Next
                local1 = createdecal(rand($0E, $0F), local9, (rnd(-0.05, 0.05) + local10), local11, rnd(-4.0, 4.0), rnd(-4.0, 4.0), rnd(-4.0, 4.0), rnd(0.028, 0.034), 1.0, $01, $02, $00, $00, $00)
                local1\Field14 = 1400.0
                aligntovector(local1\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                moveentity(local1\Field0, 0.0, 0.0, -0.001)
            EndIf
        EndIf
        freeentity(local3)
        local3 = $00
    EndIf
    Return $00
End Function
