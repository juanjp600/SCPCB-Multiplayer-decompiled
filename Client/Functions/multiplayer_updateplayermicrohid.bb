Function multiplayer_updateplayermicrohid%(arg0.players)
    Local local0%
    Local local1.particles
    Local local2%
    If (arg0\Field80 <> $00) Then
        If (arg0\Field15 <> $00) Then
            entitypickmode(arg0\Field19, $00, $00)
            If (arg0 = myplayer) Then
                entitypickmode(arg0\Field13, $00, $01)
            EndIf
            local0 = createpivot($00)
            positionentity(local0, entityx(arg0\Field15, $01), entityy(arg0\Field15, $01), entityz(arg0\Field15, $01), $00)
            rotateentity(local0, arg0\Field5, arg0\Field4, 0.0, $00)
            If (entitypick(local0, 30.0) <> $00) Then
                If (removeparticles = $00) Then
                    If (rand($01, $02) = $01) Then
                        local1 = createparticle(pickedx(), pickedy(), pickedz(), $04, 0.25, rnd(-1.0, 1.0), $14, 1.0, $01)
                        aligntovector(local1\Field1, (- pickednx()), (- pickedny()), (- pickednz()), $02, 1.0)
                        turnentity(local1\Field1, rnd(-25.0, 25.0), rnd(-25.0, 25.0), rnd(-25.0, 25.0), $00)
                    EndIf
                EndIf
                local2 = createpivot($00)
                positionentity(local2, pickedx(), pickedy(), pickedz(), $00)
                If (((multiplayer_isafriend(arg0\Field49, myplayer\Field49) = $00) And (myplayer\Field49 <> $00)) <> 0) Then
                    If (0.2 > entitydistance(local2, collider)) Then
                        If (multiplayer_isfullsync() = $00) Then
                            If ((multiplayer_isascp(myplayer\Field49) Or networkserver\Field12) <> 0) Then
                                myplayer\Field68 = (myplayer\Field68 - (70.0 * fpsfactor))
                                If (0.0 > myplayer\Field68) Then
                                    kill("was killed by Micro-HID", $01)
                                EndIf
                            Else
                                kill("was killed by Micro-HID", $01)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (entityvisible(camera, local0) <> 0) Then
                    lightflash = (((Float entityinview(local0, camera)) * 0.02) + 0.05)
                EndIf
                freeentity(local2)
            EndIf
            entitypickmode(arg0\Field19, $02, $00)
            If (arg0 = myplayer) Then
                entitypickmode(arg0\Field13, $01, $01)
            EndIf
            freeentity(local0)
        EndIf
    EndIf
    Return $00
End Function
