Function multiplayer_updateplayermicrohid%(arg0.players)
    Local local0%
    Local local1.particles
    If (arg0\Field82 <> $00) Then
        If (arg0\Field15 <> $00) Then
            entitypickmode(arg0\Field19, $00, $00)
            If (arg0 = myplayer) Then
                entitypickmode(arg0\Field13, $00, $01)
            EndIf
            local0 = createpivot($00)
            positionentity(local0, entityx(arg0\Field15, $01), entityy(arg0\Field15, $01), entityz(arg0\Field15, $01), $00)
            rotateentity(local0, arg0\Field5, arg0\Field4, 0.0, $00)
            If (entitypick(local0, 30.0) <> $00) Then
                local1 = createparticle(pickedx(), pickedy(), pickedz(), $04, 0.5, 0.0, $0A)
                If (((multiplayer_isafriend(arg0\Field51, myplayer\Field51) = $00) And (myplayer\Field51 <> $00)) <> 0) Then
                    If (0.2 > entitydistance(local1\Field1, collider)) Then
                        If (multiplayer_isfullsync() = $00) Then
                            If ((multiplayer_isascp(myplayer\Field51) Or networkserver\Field15) <> 0) Then
                                myplayer\Field70 = (myplayer\Field70 - (70.0 * fpsfactor))
                                If (0.0 > myplayer\Field70) Then
                                    kill("was killed by Micro-HID", $01)
                                EndIf
                            Else
                                kill("was killed by Micro-HID", $01)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (entityvisible(camera, local0) <> 0) Then
                    lightflash = ((Float (entityinview(local0, camera) / $32)) + 0.05)
                EndIf
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
