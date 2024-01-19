Function updategrenades%()
    Local local0$
    Local local1#
    Local local2.grenades
    Local local4%
    Local local5%
    Local local6.players
    Local local7.npcs
    Local local8%
    Local local9.decals
    Local local10%
    Local local11%
    Local local12#
    local0 = ""
    local1 = 0.0
    For local2 = Each grenades
        local2\Field11 = (local2\Field11 + fpsfactor)
        If (259.0 < local2\Field11) Then
            If (local2\Field21 = $00) Then
                local1 = 0.0
                Select local2\Field19
                    Case $0D
                        local0 = "SFX\Guns\Bazooka\Explosion.ogg"
                        local4 = linepick(entityx(local2\Field2, $00), entityy(local2\Field2, $00), entityz(local2\Field2, $00), 0.0, 10.0, 0.0, 0.0)
                        local5 = linepick(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 0.0, 10.0, 0.0, 0.0)
                        If (((local4 = $00) And local5) <> 0) Then
                            local0 = "SFX\Guns\Bazooka\ExplosionOutside.ogg"
                        EndIf
                        If (((local4 = $00) And (local5 = $00)) <> 0) Then
                            local0 = "SFX\Guns\Bazooka\ExplosionOutside.ogg"
                        EndIf
                        For local6 = Each players
                            If (local6\Field0 <> networkserver\Field28) Then
                                If (3.0 > entitydistance(local6\Field13, local2\Field2)) Then
                                    givedamage(local6\Field0, (70.0 - (entitydistance(local6\Field13, local2\Field2) * 5.0)))
                                EndIf
                            EndIf
                        Next
                        If (entityvisible(collider, local2\Field2) <> 0) Then
                            If (3.0 > entitydistance(collider, local2\Field2)) Then
                                If (player_isdead() = $00) Then
                                    If ((multiplayer_isascp(myplayer\Field51) Or networkserver\Field15) <> 0) Then
                                        If (multiplayer_isfullsync() = $00) Then
                                            myplayer\Field70 = (myplayer\Field70 - max(0.0, (119.0 - (entitydistance(collider, local2\Field2) * 20.0))))
                                        EndIf
                                        If (multiplayer_isascp(myplayer\Field51) = $00) Then
                                            injuries = 1.01
                                        EndIf
                                        If (0.0 > myplayer\Field70) Then
                                            godmode = $00
                                            kill(("was killed by explosion by " + player[local2\Field18]\Field24), $00)
                                        EndIf
                                    Else
                                        injuries = ((5.0 - entitydistance(collider, local2\Field2)) + injuries)
                                        If (5.0 < injuries) Then
                                            kill(("was killed by explosion by " + player[local2\Field18]\Field24), $00)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (networkserver\Field18 <> 0) Then
                            For local7 = Each npcs
                                If (local7\Field48 = $00) Then
                                    If (((local7\Field5 = $0B) Or (local7\Field5 = $15)) <> 0) Then
                                        If (5.0 > entitydistance(local7\Field4, local2\Field2)) Then
                                            local7\Field59 = (Int ((Float (local7\Field59 - $23)) - (entitydistance(local7\Field4, local2\Field2) * 5.0)))
                                            If (local7\Field59 < $01) Then
                                                local7\Field48 = $01
                                            EndIf
                                        EndIf
                                    EndIf
                                    If (local7\Field5 = $02) Then
                                        If (3.0 > entitydistance(local7\Field4, local2\Field2)) Then
                                            local7\Field9 = (Float rand($55F0, $6978))
                                            positionentity(local7\Field4, 0.0, 500.0, 0.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                        local8 = createpivot($00)
                        positionentity(local8, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) - 0.05), entityz(local2\Field2, $00), $00)
                        turnentity(local8, 90.0, 0.0, 0.0, $00)
                        If (entitypick(local8, 10.0) <> $00) Then
                            local9 = createdecal($01, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local9\Field2 = rnd(0.5, 1.0)
                            entityalpha(local9\Field0, 1.0)
                            scalesprite(local9\Field0, local9\Field2, local9\Field2)
                        EndIf
                        freeentity(local8)
                        setemitter(local2\Field2, particleeffect[$03], $01, $01)
                        setemitter(local2\Field2, particleeffect[$04], $01, $01)
                        camerashake = max(0.0, (10.0 - entitydistance(local2\Field2, collider)))
                    Case $0E
                        local0 = "SFX\Guns\Bazooka\Explosion.ogg"
                        local4 = linepick(entityx(local2\Field2, $00), entityy(local2\Field2, $00), entityz(local2\Field2, $00), 0.0, 10.0, 0.0, 0.0)
                        local5 = linepick(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 0.0, 10.0, 0.0, 0.0)
                        If (((local4 = $00) And local5) <> 0) Then
                            local0 = "SFX\Guns\Bazooka\ExplosionOutside.ogg"
                        EndIf
                        If (((local4 = $00) And (local5 = $00)) <> 0) Then
                            local0 = "SFX\Guns\Bazooka\ExplosionOutside.ogg"
                        EndIf
                        If ((entityvisible(local2\Field2, camera) And (10.0 > entitydistance(local2\Field2, collider))) <> 0) Then
                            lightflash = ((((Float entityinview(local2\Field2, camera)) * 180.0) / 70.0) + 2.571429)
                            lightflash = (lightflash / max((entitydistance(local2\Field2, collider) / 5.0), 1.0))
                            deaftimer = ((lightflash * 70.0) - 20.0)
                            deafplayer = $01
                            local2\Field21 = local2\Field19
                        EndIf
                        local8 = createpivot($00)
                        positionentity(local8, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) - 0.05), entityz(local2\Field2, $00), $00)
                        turnentity(local8, 90.0, 0.0, 0.0, $00)
                        If (entitypick(local8, 10.0) <> $00) Then
                            local9 = createdecal($01, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                            local9\Field2 = rnd(0.5, 1.0)
                            entityalpha(local9\Field0, 1.0)
                            scalesprite(local9\Field0, local9\Field2, local9\Field2)
                        EndIf
                        freeentity(local8)
                        setemitter(local2\Field2, particleeffect[$06], $01, $01)
                    Case $0F
                        local1 = 30.0
                        local0 = "SFX\Guns\Grenade\SmokeExplosion.ogg"
                        setemitter(local2\Field2, particleeffect[$05], $01, $01)
                End Select
                If (local2\Field21 = $00) Then
                    If (local0 <> "") Then
                        local10 = createpivot($00)
                        positionentity(local10, entityx(local2\Field2, $00), entityy(local2\Field2, $00), entityz(local2\Field2, $00), $00)
                        channelpitch(play3dsound($00, camera, local10, (60.0 - local1), 0.5, local0), (Int max(40000.0, (44100.0 - (entitydistance(camera, local10) * 500.0)))))
                    EndIf
                    freeentity(local2\Field2)
                    Delete local2
                EndIf
            Else
                local11 = local2\Field21
                If (local11 = $0E) Then
                    If (local2\Field2 <> $00) Then
                        freeentity(local2\Field2)
                        local2\Field2 = $00
                    EndIf
                    If (1.0 > lightflash) Then
                        Delete local2
                    Else
                        shouldplay = $1A
                    EndIf
                EndIf
            EndIf
        ElseIf (local2\Field2 <> $00) Then
            If (0.01 < local2\Field3) Then
                If (countcollisions(local2\Field2) <> $00) Then
                    local10 = createpivot($00)
                    positionentity(local10, entityx(local2\Field2, $00), entityy(local2\Field2, $00), entityz(local2\Field2, $00), $00)
                    play3dsound($00, camera, local10, 10.0, 0.5, "SFX\Guns\Grenade\fall.ogg")
                    If (1.0 = (Abs collisionny(local2\Field2, $01))) Then
                        rotateentity(local2\Field2, flipangle(entitypitch(local2\Field2, $00)), entityyaw(local2\Field2, $00), entityroll(local2\Field2, $00), $00)
                        local2\Field20 = 0.0
                    Else
                        rotateentity(local2\Field2, entitypitch(local2\Field2, $00), bouncewall(vectoryaw(collisionnx(local2\Field2, $01), 0.0, (- collisionnz(local2\Field2, $01))), entityyaw(local2\Field2, $00)), entityroll(local2\Field2, $00), $00)
                    EndIf
                    local2\Field3 = (local2\Field3 * 0.65)
                Else
                    moveentity(local2\Field2, 0.0, 0.0, (local2\Field3 * fpsfactor))
                    translateentity(local2\Field2, 0.0, (local2\Field20 * fpsfactor), 0.0, $00)
                    local2\Field20 = max((local2\Field20 - (0.001 * fpsfactor)), -0.2)
                    If (90.0 > entitypitch(local2\Field2, $00)) Then
                        rotateentity(local2\Field2, wrapangle((entitypitch(local2\Field2, $00) + (0.8 * fpsfactor))), entityyaw(local2\Field2, $00), wrapangle((entityroll(local2\Field2, $00) + ((local2\Field3 * 24.0) * fpsfactor))), $00)
                    Else
                        rotateentity(local2\Field2, entitypitch(local2\Field2, $00), entityyaw(local2\Field2, $00), wrapangle((entityroll(local2\Field2, $00) + ((local2\Field3 * 24.0) * fpsfactor))), $00)
                    EndIf
                EndIf
            Else
                local2\Field3 = max((local2\Field3 - (0.0001 * fpsfactor)), 0.0)
                local12 = entitypitch(local2\Field2, $00)
                rotateentity(local2\Field2, 0.0, entityyaw(local2\Field2, $00), curvevalue(90.0, entityroll(local2\Field2, $00), 15.0), $00)
                moveentity(local2\Field2, 0.0, 0.0, (local2\Field3 * fpsfactor))
                rotateentity(local2\Field2, wrapangle((((local2\Field3 * 24.0) * fpsfactor) + local12)), entityyaw(local2\Field2, $00), curvevalue(90.0, entityroll(local2\Field2, $00), 15.0), $00)
                translateentity(local2\Field2, 0.0, (local2\Field20 * fpsfactor), 0.0, $00)
                local2\Field20 = max((local2\Field20 - (0.001 * fpsfactor)), -0.2)
            EndIf
        EndIf
    Next
    Return $00
End Function
