Function updaterockets%()
    Local local0%
    Local local1.rockets
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8$
    Local local9.decals
    Local local10%
    Local local11%
    Local local12#
    Local local13.players
    Local local14%
    For local1 = Each rockets
        local2 = entityx(local1\Field1, $00)
        local3 = entityy(local1\Field1, $00)
        local4 = entityz(local1\Field1, $00)
        local5 = entityx(local1\Field2, $00)
        local6 = entityy(local1\Field2, $00)
        local7 = entityz(local1\Field2, $00)
        local1\Field3 = curvevalue(15.0, local1\Field3, 3000.0)
        moveentity(local1\Field1, 0.0, 0.0, (local1\Field3 * fpsfactor))
        positionentity(local1\Field9\Field0, local5, local6, local7, $01)
        positionentity(local1\Field2, local2, local3, local4, $00)
        rotateentity(local1\Field1, wrapangle(entitypitch(local1\Field1, $00)), entityyaw(local1\Field1, $00), entityroll(local1\Field1, $00), $00)
        rotateentity(local1\Field2, entitypitch(local1\Field1, $00), entityyaw(local1\Field2, $00), entityroll(local1\Field1, $00), $00)
        local1\Field10 = (local1\Field10 + fpsfactor)
        local0 = local1\Field11
        If (local0 <> myplayer\Field0) Then
            If (local0 > $00) Then
                entitypickmode(player[local0]\Field19, $00, $00)
            EndIf
        EndIf
        If ((entitypick(local1\Field1, 0.5) Or (200.0 < local1\Field10)) <> 0) Then
            local8 = "SFX\Guns\Bazooka\Explosion.ogg"
            If (removedecals = $00) Then
                local9 = createdecal($01, pickedx(), pickedy(), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                local9\Field2 = rnd(0.5, 0.7)
                entityalpha(local9\Field0, 1.0)
                scalesprite(local9\Field0, local9\Field2, local9\Field2)
                aligntovector(local9\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                moveentity(local9\Field0, 0.0, 0.0, (1.0 / -400.0))
            EndIf
            local10 = linepick(local2, local3, local4, 0.0, 10.0, 0.0, 0.0)
            If (local10 = $00) Then
                local8 = "SFX\Guns\Bazooka\ExplosionOutside.ogg"
            Else
                local11 = linepick(entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), 0.0, 10.0, 0.0, 0.0)
                If (local11 = $00) Then
                    local8 = "SFX\Guns\Bazooka\ExplosionOutside.ogg"
                EndIf
            EndIf
            For local13 = Each players
                If (local13\Field0 <> networkserver\Field20) Then
                    local12 = entitydistance(local13\Field12, local1\Field1)
                    If (3.0 > local12) Then
                        givedamage(local13\Field0, (56.0 - (local12 * 2.0)))
                    EndIf
                EndIf
            Next
            If (player_isdead() = $00) Then
                If (entityvisible(collider, local1\Field2) <> 0) Then
                    local12 = entitydistance(collider, local1\Field1)
                    If (3.0 > local12) Then
                        If ((multiplayer_isascp(myplayer\Field49) Or networkserver\Field12) <> 0) Then
                            If (multiplayer_isfullsync() = $00) Then
                                myplayer\Field68 = (myplayer\Field68 - max(0.0, (56.0 - (local12 * 20.0))))
                            EndIf
                            If (multiplayer_isascp(myplayer\Field49) = $00) Then
                                injuries = 1.01
                            EndIf
                            If (0.0 > myplayer\Field68) Then
                                godmode = $00
                                If (local0 > $00) Then
                                    kill(("was killed by explosion by " + player[local0]\Field24), $00)
                                Else
                                    kill("was killed by explosion", $00)
                                EndIf
                            EndIf
                        Else
                            injuries = ((5.0 - local12) + injuries)
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
            setemitter(local1\Field1, particleeffect[$04], $01, $00)
            camerashake = max(0.0, (10.0 - local12))
            local1\Field5 = $00
            local14 = createpivot($00)
            positionentity(local14, local2, local3, local4, $00)
            channelpitch(play3dsound($00, camera, local14, 60.0, 0.5, local8), (Int max(40000.0, (44100.0 - (entitydistance(camera, local14) * 500.0)))))
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
