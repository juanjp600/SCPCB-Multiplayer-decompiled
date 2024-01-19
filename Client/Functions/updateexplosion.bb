Function updateexplosion%()
    Local local0%
    Local local1.particles
    If (0.0 < explosiontimer) Then
        explosiontimer = (explosiontimer + fpsfactor)
        If (140.0 > explosiontimer) Then
            If (5.0 > (explosiontimer - fpsfactor)) Then
                explosionsfx = loadsound_strict("SFX\Ending\GateB\Nuke1.ogg")
                playsound_strict(explosionsfx)
                camerashake = 10.0
                explosiontimer = 5.0
            EndIf
            camerashake = curvevalue((explosiontimer / 60.0), camerashake, 50.0)
        Else
            camerashake = min((explosiontimer / 20.0), 20.0)
            If (140.0 > (explosiontimer - fpsfactor)) Then
                blinktimer = 1.0
                explosionsfx = loadsound_strict("SFX\Ending\GateB\Nuke2.ogg")
                playsound_strict(explosionsfx)
                For local0 = $00 To (((particleamount + $01) * $0A) + $0A) Step $01
                    local1 = createparticle((entityx(collider, $00) + rnd(-0.5, 0.5)), (entityy(collider, $00) - rnd(0.2, 1.5)), (entityz(collider, $00) + rnd(-0.5, 0.5)), $00, rnd(0.2, 0.6), 0.0, $15E)
                    rotateentity(local1\Field1, -90.0, 0.0, 0.0, $01)
                    local1\Field9 = rnd(0.05, 0.07)
                Next
            EndIf
            lightflash = min(((explosiontimer - 140.0) / 10.0), 5.0)
            If (((160.0 < explosiontimer) And (player_isdead() = $00)) <> 0) Then
                kill("was killed by explosion", $01)
            EndIf
            If (500.0 < explosiontimer) Then
                explosiontimer = 0.0
            EndIf
            positionentity(collider, entityx(collider, $00), 200.0, entityz(collider, $00), $00)
            resetentity(collider)
        EndIf
    EndIf
    Return $00
End Function
