Function multiplayer_updateplayersounds%(arg0.players)
    Local local1#
    Local local2.breachtypes
    Local local3.sound
    Select arg0\Field49
        Case model_173
            If ((arg0\Field76 Or (arg0\Field0 = myplayer\Field0)) <> 0) Then
                If (((entityx(arg0\Field13, $00) <> arg0\Field6) And (entityz(arg0\Field13, $00) <> arg0\Field8)) <> 0) Then
                    If (arg0\Field0 = myplayer\Field0) Then
                        arg0\Field51 = loopsound2(stonedragsfx, arg0\Field51, camera, arg0\Field13, 13.0, 0.8)
                        channelpan(arg0\Field51, 0.5)
                        channelvolume(arg0\Field51, (0.8 * sfxvolume))
                    Else
                        arg0\Field51 = loopsound2(stonedragsfx, arg0\Field51, camera, arg0\Field13, 13.0, 0.8)
                    EndIf
                Else
                    stopchannel(arg0\Field51)
                    arg0\Field51 = $00
                EndIf
                arg0\Field6 = entityx(arg0\Field13, $00)
                arg0\Field8 = entityz(arg0\Field13, $00)
            EndIf
        Case model_096
            If (arg0\Field52 < millisecs()) Then
                If (((arg0\Field53 = $0E) And (arg0\Field56 <> $0E)) <> 0) Then
                    If (multiplayer_isafriend(myplayer\Field49, arg0\Field49) = $00) Then
                        If (((-16.0 > blinktimer) Or (-6.0 < blinktimer)) <> 0) Then
                            If (arg0\Field76 <> 0) Then
                                If ((entityinview(camera, getplayercamera(arg0\Field0)) And entityinview(getplayercamera(arg0\Field0), camera)) <> 0) Then
                                    If (entityvisible(myhitbox, arg0\Field19) <> 0) Then
                                        playsound_strict(triggered096sfx)
                                        arg0\Field52 = (millisecs() + $7530)
                                        arg0\Field56 = $0E
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                ElseIf (((arg0\Field53 <> $0E) And (arg0\Field56 = $0E)) <> 0) Then
                    arg0\Field56 = $00
                EndIf
            EndIf
        Case model_106
            local1 = entitydistance(collider, arg0\Field13)
            If ((arg0\Field76 Or (arg0\Field0 = myplayer\Field0)) <> 0) Then
                If (multiplayer_isafriend(myplayer\Field49, arg0\Field49) = $00) Then
                    If (8.0 > entitydistance(collider, arg0\Field13)) Then
                        If (arg0\Field0 = myplayer\Field0) Then
                            arg0\Field51 = loopsound2(chase106sfx, arg0\Field51, camera, arg0\Field13, 13.0, 0.8)
                            channelpan(arg0\Field51, 0.5)
                            channelvolume(arg0\Field51, (0.1 * sfxvolume))
                        Else
                            arg0\Field51 = loopsound2(chase106sfx, arg0\Field51, camera, arg0\Field13, 13.0, 0.8)
                            channelvolume(arg0\Field51, min(sfxvolume, (sfxvolume / max(local1, 0.0))))
                        EndIf
                    Else
                        stopchannel(arg0\Field51)
                        arg0\Field51 = $00
                    EndIf
                Else
                    stopchannel(arg0\Field51)
                    arg0\Field51 = $00
                EndIf
                arg0\Field6 = entityx(arg0\Field13, $00)
                arg0\Field8 = entityz(arg0\Field13, $00)
            EndIf
    End Select
    If (arg0\Field53 < $1E) Then
        local2 = getbreachtype(arg0\Field49)
        If (local2\Field15[$00] <> "") Then
            If (rand($01, $28) > $27) Then
                If ((arg0\Field76 Or (arg0\Field0 = myplayer\Field0)) <> 0) Then
                    If (channelplaying(arg0\Field51) = $00) Then
                        arg0\Field51 = $00
                        For local3 = Each sound
                            If (local3\Field1 = local2\Field15[$00]) Then
                                If (arg0\Field0 = myplayer\Field0) Then
                                    arg0\Field51 = playsound_strict((Handle local3))
                                    channelvolume(arg0\Field51, (0.2 * sfxvolume))
                                Else
                                    arg0\Field51 = play3dsound((Handle local3), camera, arg0\Field13, 13.0, 0.8, "")
                                EndIf
                                Exit
                            EndIf
                        Next
                        If (arg0\Field51 = $00) Then
                            If (arg0\Field0 = myplayer\Field0) Then
                                arg0\Field51 = playsound_strict(loadtempsound(local2\Field15[arg0\Field53]))
                                channelvolume(arg0\Field51, (0.2 * sfxvolume))
                            Else
                                arg0\Field51 = play3dsound($00, camera, arg0\Field13, 13.0, 0.8, local2\Field15[arg0\Field53])
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (local2\Field15[arg0\Field53] <> "") Then
            If ((arg0\Field76 Or (arg0\Field0 = myplayer\Field0)) <> 0) Then
                If (channelplaying(arg0\Field51) = $00) Then
                    arg0\Field51 = $00
                    For local3 = Each sound
                        If (local3\Field1 = local2\Field15[arg0\Field53]) Then
                            If (arg0\Field0 = myplayer\Field0) Then
                                arg0\Field51 = playsound_strict((Handle local3))
                                channelvolume(arg0\Field51, (0.2 * sfxvolume))
                            Else
                                arg0\Field51 = play3dsound((Handle local3), camera, arg0\Field13, 13.0, 0.8, "")
                            EndIf
                            Exit
                        EndIf
                    Next
                    If (arg0\Field51 = $00) Then
                        If (arg0\Field0 = myplayer\Field0) Then
                            arg0\Field51 = playsound_strict(loadtempsound(local2\Field15[arg0\Field53]))
                            channelvolume(arg0\Field51, (0.2 * sfxvolume))
                        Else
                            arg0\Field51 = play3dsound($00, camera, arg0\Field13, 13.0, 0.8, local2\Field15[arg0\Field53])
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    Return $00
End Function
