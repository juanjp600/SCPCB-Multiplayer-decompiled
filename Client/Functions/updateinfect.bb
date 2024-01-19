Function updateinfect%()
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4.decals
    Local local5.particles
    local3 = $00
    If (playerroom\Field7\Field11 = "room860") Then
        If (1.0 = room860event\Field2) Then
            local3 = $00
        EndIf
    ElseIf ((((playerroom\Field7\Field11 = "dimension1499") Or (playerroom\Field7\Field11 = "pocketdimension")) Or (playerroom\Field7\Field11 = "gatea")) <> 0) Then
        local3 = $00
    ElseIf (((playerroom\Field7\Field11 = "exit1") And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
        local3 = $00
    EndIf
    If (0.0 < infect) Then
        showentity(infectoverlay)
        If (93.0 > infect) Then
            local0 = infect
            If ((i_427\Field0 And (25200.0 > i_427\Field1)) = $00) Then
                infect = min(((fpsfactor * 0.002) + infect), 100.0)
            EndIf
            blurtimer = max(((infect * 3.0) * (2.0 - crouchstate)), blurtimer)
            heartbeatrate = max(heartbeatrate, 100.0)
            heartbeatvolume = max(heartbeatvolume, (infect / 120.0))
            entityalpha(infectoverlay, (min((((infect * 0.2) ^ 2.0) / 1000.0), 0.5) * (sin(((Float millisecs2()) / 8.0)) + 2.0)))
            For local1 = $00 To $06 Step $01
                If ((((Float ((local1 * $0F) + $0A)) < infect) And ((Float ((local1 * $0F) + $0A)) >= local0)) <> 0) Then
                    playsound_strict(loadtempsound((("SFX\SCP\008\Voices" + (Str local1)) + ".ogg")))
                EndIf
            Next
            If (((20.0 < infect) And (20.0 >= local0)) <> 0) Then
                msg = "You feel kinda feverish."
                msgtimer = 420.0
            ElseIf (((40.0 < infect) And (40.0 >= local0)) <> 0) Then
                msg = "You feel nauseated."
                msgtimer = 420.0
            ElseIf (((60.0 < infect) And (60.0 >= local0)) <> 0) Then
                msg = "The nausea's getting worse."
                msgtimer = 420.0
            ElseIf (((80.0 < infect) And (80.0 >= local0)) <> 0) Then
                msg = "You feel very faint."
                msgtimer = 420.0
            ElseIf (91.5 <= infect) Then
                blinktimer = max(min(((infect - 91.5) * -10.0), blinktimer), -10.0)
                kill("was killed by SCP-008", $00)
                infect = 0.0
                hideentity(infectoverlay)
            EndIf
        Else
            local0 = infect
            infect = min(((fpsfactor * 0.004) + infect), 100.0)
            If (local3 <> 0) Then
                If (94.7 > infect) Then
                    entityalpha(infectoverlay, ((sin(((Float millisecs2()) / 8.0)) + 2.0) * 0.5))
                    blurtimer = 900.0
                    If (94.5 < infect) Then
                        blinktimer = max(min(((infect - 94.5) * -50.0), blinktimer), -10.0)
                    EndIf
                    pointentity(collider, playerroom\Field32[$00]\Field4, 0.0)
                    pointentity(playerroom\Field32[$00]\Field4, collider, 0.0)
                    pointentity(camera, playerroom\Field32[$00]\Field4, entityroll(camera, $00))
                    forcemove = 0.75
                    injuries = 2.5
                    bloodloss = 0.0
                    unabletomove = $00
                    animate2(playerroom\Field32[$00]\Field0, animtime(playerroom\Field32[$00]\Field0), $165, $17D, 0.3, $01)
                ElseIf (98.5 > infect) Then
                    entityalpha(infectoverlay, ((sin(((Float millisecs2()) / 5.0)) + 2.0) * 0.5))
                    blurtimer = 950.0
                    forcemove = 0.0
                    unabletomove = $01
                    pointentity(camera, playerroom\Field32[$00]\Field4, 0.0)
                    If (94.7 > local0) Then
                        playerroom\Field32[$00]\Field16 = loadsound_strict("SFX\SCP\008\KillScientist2.ogg")
                        playerroom\Field32[$00]\Field17 = playsound_strict(playerroom\Field32[$00]\Field16)
                        deathmsg = "Subject D-9341 found ingesting Dr. [REDACTED] at Sector [REDACTED]. Subject was immediately terminated by Nine-Tailed Fox and sent for autopsy. "
                        deathmsg = (deathmsg + "SCP-008 infection was confirmed, after which the body was incinerated.")
                        kill("was killed", $00)
                        local4 = createdecal($03, entityx(playerroom\Field32[$00]\Field4, $00), ((544.0 * roomscale) + 0.01), entityz(playerroom\Field32[$00]\Field4, $00), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                        local4\Field2 = 0.8
                        scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    ElseIf (96.0 < infect) Then
                        blinktimer = max(min(((infect - 96.0) * -10.0), blinktimer), -10.0)
                    Else
                        killtimer = max(-350.0, killtimer)
                    EndIf
                    If (0.0 = playerroom\Field32[$00]\Field10) Then
                        animate2(playerroom\Field32[$00]\Field0, animtime(playerroom\Field32[$00]\Field0), $0D, $13, 0.3, $00)
                        If (19.0 <= animtime(playerroom\Field32[$00]\Field0)) Then
                            playerroom\Field32[$00]\Field10 = 1.0
                        EndIf
                    Else
                        animate2(playerroom\Field32[$00]\Field0, animtime(playerroom\Field32[$00]\Field0), $13, $0D, -0.3, $01)
                        If (13.0 >= animtime(playerroom\Field32[$00]\Field0)) Then
                            playerroom\Field32[$00]\Field10 = 0.0
                        EndIf
                    EndIf
                    If (particleamount > $00) Then
                        If (rand($32, $01) = $01) Then
                            local5 = createparticle(entityx(playerroom\Field32[$00]\Field4, $00), entityy(playerroom\Field32[$00]\Field4, $00), entityz(playerroom\Field32[$00]\Field4, $00), $05, rnd(0.05, 0.1), 0.15, $C8)
                            local5\Field9 = 0.01
                            local5\Field16 = 0.01
                            local5\Field6 = 0.5
                            local5\Field15 = -0.01
                            rotateentity(local5\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                        EndIf
                    EndIf
                    positionentity(head, entityx(playerroom\Field32[$00]\Field4, $01), (entityy(playerroom\Field32[$00]\Field4, $01) + 0.65), entityz(playerroom\Field32[$00]\Field4, $01), $01)
                    rotateentity(head, ((sin(((Float millisecs2()) / 5.0)) + 1.0) * 15.0), (Float (playerroom\Field6 - $B4)), 0.0, $01)
                    moveentity(head, 0.0, 0.0, -0.4)
                    turnentity(head, ((sin(((Float millisecs2()) / 5.0)) * 30.0) + 80.0), (sin(((Float millisecs2()) / 5.0)) * 40.0), 0.0, $00)
                EndIf
            Else
                kill("was killed by SCP-008", $00)
                blinktimer = max(min(((infect - 96.0) * -10.0), blinktimer), -10.0)
                If (playerroom\Field7\Field11 = "dimension1499") Then
                    deathmsg = "The whereabouts of SCP-1499 are still unknown, but a recon team has been dispatched to investigate reports of a violent attack to a church in the Russian town of [REDACTED]."
                ElseIf (((playerroom\Field7\Field11 = "gatea") Or (playerroom\Field7\Field11 = "exit1")) <> 0) Then
                    deathmsg = "Subject D-9341 found wandering around Gate "
                    If (playerroom\Field7\Field11 = "gatea") Then
                        deathmsg = (deathmsg + "A")
                    Else
                        deathmsg = (deathmsg + "B")
                    EndIf
                    deathmsg = (deathmsg + ". Subject was immediately terminated by Nine-Tailed Fox and sent for autopsy. ")
                    deathmsg = (deathmsg + "SCP-008 infection was confirmed, after which the body was incinerated.")
                Else
                    deathmsg = ""
                EndIf
            EndIf
        EndIf
    Else
        hideentity(infectoverlay)
    EndIf
    Return $00
End Function
