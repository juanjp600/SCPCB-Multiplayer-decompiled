Function shoot%(arg0.npcs, arg1#, arg2#, arg3#, arg4#, arg5%, arg6%)
    Local local0.particles
    Local local1$
    Local local4%
    Local local5%
    Local local6.decals
    local0 = createparticle(arg1, arg2, arg3, $01, rnd(0.08, 0.1), 0.0, $05)
    turnentity(local0\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
    local0\Field15 = -0.15
    lightvolume = (templightvolume * 1.2)
    If (arg6 <> 0) Then
        If (arg0\Field74 = networkserver\Field28) Then
            If (godmode = $00) Then
                kill("was killed by shoot", $00)
                playsound_strict(bullethitsfx)
                multiplayer_writesound(bullethitsfx, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
            EndIf
        Else
            givedamage(arg0\Field74, -1.0)
        EndIf
        Return $00
    EndIf
    If (arg4 >= rnd(1.0, 0.0)) Then
        If (((arg0\Field74 = networkserver\Field28) And (godmode = $00)) <> 0) Then
            turnentity(camera, rnd(-3.0, 3.0), rnd(-3.0, 3.0), 0.0, $00)
            If (wearingvest > $00) Then
                If (wearingvest = $01) Then
                    Select rand($08, $01)
                        Case $01,$02,$03,$04,$05
                            blurtimer = 500.0
                            stamina = 0.0
                            local1 = "A bullet penetrated your vest, making you gasp."
                            injuries = (rnd(0.1, 0.5) + injuries)
                        Case $06
                            blurtimer = 500.0
                            local1 = "A bullet hit your left leg."
                            injuries = (rnd(0.8, 1.2) + injuries)
                        Case $07
                            blurtimer = 500.0
                            local1 = "A bullet hit your right leg."
                            injuries = (rnd(0.8, 1.2) + injuries)
                        Case $08
                            blurtimer = 500.0
                            stamina = 0.0
                            local1 = "A bullet struck your neck, making you gasp."
                            injuries = (rnd(1.2, 1.6) + injuries)
                    End Select
                ElseIf (rand($0A, $01) = $01) Then
                    blurtimer = 500.0
                    stamina = (stamina - 1.0)
                    local1 = "A bullet hit your chest. The vest absorbed some of the damage."
                    injuries = (rnd(0.8, 1.1) + injuries)
                Else
                    local1 = "A bullet hit your chest. The vest absorbed most of the damage."
                    injuries = (rnd(0.1, 0.5) + injuries)
                EndIf
                If (5.0 <= injuries) Then
                    If (rand($03, $01) = $01) Then
                        kill("was killed by shoot", $00)
                    EndIf
                EndIf
            Else
                Select rand($06, $01)
                    Case $01
                        kill("was killed by shoot", $00)
                    Case $02
                        blurtimer = 500.0
                        local1 = "A bullet hit your left leg."
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $03
                        blurtimer = 500.0
                        local1 = "A bullet hit your right leg."
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $04
                        blurtimer = 500.0
                        local1 = "A bullet hit your right shoulder."
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $05
                        blurtimer = 500.0
                        local1 = "A bullet hit your left shoulder."
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $06
                        blurtimer = 500.0
                        local1 = "A bullet hit your right shoulder."
                        injuries = (rnd(2.5, 4.0) + injuries)
                End Select
            EndIf
            If (256.0 > msgtimer) Then
                msg = local1
                msgtimer = 420.0
            EndIf
            injuries = min(injuries, 4.0)
            playsound_strict(bullethitsfx)
            multiplayer_writesound(bullethitsfx, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
        Else
            givedamage(arg0\Field74, rnd(2.0, 4.0))
        EndIf
    ElseIf ((arg5 And (particleamount > $00)) <> 0) Then
        local4 = createpivot($00)
        positionentity(local4, entityx(arg0\Field73, $00), ((entityy(arg0\Field73, $00) + entityy(camera, $00)) / 2.0), entityz(arg0\Field73, $00), $00)
        pointentity(local4, local0\Field0, 0.0)
        turnentity(local4, 0.0, 180.0, 0.0, $00)
        entitypick(local4, 2.5)
        If (pickedentity() <> $00) Then
            playsound2(gunshot3sfx, camera, local4, 0.4, rnd(0.8, 1.0))
            If (arg5 <> 0) Then
                local0 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.03, 0.0, $50)
                local0\Field9 = 0.001
                local0\Field16 = 0.003
                local0\Field6 = 0.8
                local0\Field15 = -0.01
                rotateentity(local0\Field1, (entitypitch(local4, $00) - 180.0), entityyaw(local4, $00), 0.0, $00)
                For local5 = $00 To rand($02, $03) Step $01
                    local0 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.006, 0.003, $50)
                    local0\Field9 = 0.02
                    local0\Field6 = 0.8
                    local0\Field15 = -0.01
                    rotateentity(local0\Field1, (entitypitch(local4, $00) + rnd(170.0, 190.0)), (entityyaw(local4, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                Next
                local6 = createdecal(rand($0D, $0E), pickedx(), pickedy(), pickedz(), 0.0, 0.0, 0.0, 1.0, 1.0)
                aligntovector(local6\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                moveentity(local6\Field0, 0.0, 0.0, -0.001)
                entityfx(local6\Field0, $01)
                local6\Field10 = 1400.0
                entityblend(local6\Field0, $02)
                local6\Field2 = rnd(0.028, 0.034)
                scalesprite(local6\Field0, local6\Field2, local6\Field2)
            EndIf
        EndIf
        freeentity(local4)
    EndIf
    Return $00
End Function
