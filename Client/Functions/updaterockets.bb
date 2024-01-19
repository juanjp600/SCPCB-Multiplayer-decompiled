Function updaterockets%()
    Local local0%
    Local local1.rockets
    Local local2$
    Local local3%
    Local local4%
    Local local5.players
    Local local6.npcs
    Local local7%
    Local local8.decals
    Local local9.snd3d
    Local local10%
    For local1 = Each rockets
        local1\Field3 = curvevalue(15.0, local1\Field3, 3000.0)
        moveentity(local1\Field1, 0.0, 0.0, (local1\Field3 * fpsfactor))
        positionentity(local1\Field9\Field0, entityx(local1\Field2, $00), entityy(local1\Field2, $00), entityz(local1\Field2, $00), $01)
        positionentity(local1\Field2, entityx(local1\Field1, $00), entityy(local1\Field1, $00), entityz(local1\Field1, $00), $00)
        rotateentity(local1\Field1, wrapangle(entitypitch(local1\Field1, $00)), entityyaw(local1\Field1, $00), entityroll(local1\Field1, $00), $00)
        rotateentity(local1\Field2, entitypitch(local1\Field1, $00), entityyaw(local1\Field2, $00), entityroll(local1\Field1, $00), $00)
        local1\Field10 = (local1\Field10 + fpsfactor)
        local0 = local1\Field11
        If (local0 <> myplayer\Field0) Then
            If (local0 > $00) Then
                entitypickmode(player[local0]\Field19, $00, $00)
            EndIf
        EndIf
        If ((entitypick(local1\Field1, 1.0) Or (400.0 < local1\Field10)) <> 0) Then
            local2 = "SFX\Guns\Bazooka\Explosion.ogg"
            local3 = linepick(entityx(local1\Field1, $00), entityy(local1\Field1, $00), entityz(local1\Field1, $00), 0.0, 10.0, 0.0, 0.0)
            local4 = linepick(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 0.0, 10.0, 0.0, 0.0)
            If (((local3 = $00) And local4) <> 0) Then
                local2 = "SFX\Guns\Bazooka\ExplosionOutside.ogg"
            EndIf
            If (((local3 = $00) And (local4 = $00)) <> 0) Then
                local2 = "SFX\Guns\Bazooka\ExplosionOutside.ogg"
            EndIf
            For local5 = Each players
                If (local5\Field0 <> networkserver\Field28) Then
                    If (3.0 > entitydistance(local5\Field13, local1\Field1)) Then
                        givedamage(local5\Field0, (70.0 - (entitydistance(local5\Field13, local1\Field1) * 5.0)))
                    EndIf
                EndIf
            Next
            If (entityvisible(collider, local1\Field2) <> 0) Then
                If (3.0 > entitydistance(collider, local1\Field1)) Then
                    If (player_isdead() = $00) Then
                        If ((multiplayer_isascp(myplayer\Field51) Or networkserver\Field15) <> 0) Then
                            If (multiplayer_isfullsync() = $00) Then
                                myplayer\Field70 = (myplayer\Field70 - max(0.0, (119.0 - (entitydistance(collider, local1\Field1) * 20.0))))
                            EndIf
                            If (multiplayer_isascp(myplayer\Field51) = $00) Then
                                injuries = 1.01
                            EndIf
                            If (0.0 > myplayer\Field70) Then
                                godmode = $00
                                If (local0 > $00) Then
                                    kill(("was killed by explosion by " + player[local0]\Field24), $00)
                                Else
                                    kill("was killed by explosion", $00)
                                EndIf
                            EndIf
                        Else
                            injuries = ((5.0 - entitydistance(collider, local1\Field1)) + injuries)
                            If (5.0 < injuries) Then
                                If (local0 > $00) Then
                                    kill(("was killed by explosion by " + player[local0]\Field24), $00)
                                Else
                                    kill("was killed by explosion", $00)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (networkserver\Field18 <> 0) Then
                For local6 = Each npcs
                    If (local6\Field48 = $00) Then
                        If (((local6\Field5 = $0B) Or (local6\Field5 = $15)) <> 0) Then
                            If (5.0 > entitydistance(local6\Field4, local1\Field1)) Then
                                local6\Field59 = (Int ((Float (local6\Field59 - $23)) - (entitydistance(local6\Field4, local1\Field1) * 5.0)))
                                If (local6\Field59 < $01) Then
                                    local6\Field48 = $01
                                EndIf
                            EndIf
                        EndIf
                        If (local6\Field5 = $02) Then
                            If (3.0 > entitydistance(local6\Field4, local1\Field1)) Then
                                local6\Field9 = (Float rand($55F0, $6978))
                                positionentity(local6\Field4, 0.0, 500.0, 0.0, $00)
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
            local7 = createpivot($00)
            positionentity(local7, entityx(local1\Field1, $00), (entityy(local1\Field1, $00) - 0.05), entityz(local1\Field1, $00), $00)
            turnentity(local7, 90.0, 0.0, 0.0, $00)
            If (entitypick(local7, 10.0) <> $00) Then
                local8 = createdecal($01, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                local8\Field2 = rnd(0.5, 1.0)
                entityalpha(local8\Field0, 1.0)
                scalesprite(local8\Field0, local8\Field2, local8\Field2)
            EndIf
            freeentity(local7)
            setemitter(local1\Field1, particleeffect[$03], $01, $00)
            setemitter(local1\Field1, particleeffect[$04], $01, $00)
            camerashake = max(0.0, (10.0 - entitydistance(local1\Field1, collider)))
            For local9 = Each snd3d
                If (local9\Field2 = local1\Field5) Then
                    stopchannel(local9\Field2)
                    Delete local9
                    Exit
                EndIf
            Next
            local1\Field5 = $00
            local10 = createpivot($00)
            positionentity(local10, entityx(local1\Field1, $00), entityy(local1\Field1, $00), entityz(local1\Field1, $00), $00)
            channelpitch(play3dsound($00, camera, local10, 60.0, 0.5, local2), (Int max(40000.0, (44100.0 - (entitydistance(camera, local10) * 500.0)))))
            removeemitter(local1\Field9)
            freeentity(local1\Field2)
            freeentity(local1\Field1)
            Delete local1
        EndIf
        If (local0 <> myplayer\Field0) Then
            If (local0 > $00) Then
                entitypickmode(player[local0]\Field19, $02, $00)
            EndIf
        EndIf
    Next
    updatebullets()
    updategrenades()
    Return $00
End Function
