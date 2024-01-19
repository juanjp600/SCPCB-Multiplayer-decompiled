Function multiplayer_updateplayersounds%(arg0.players)
    Local local1.breachtypes
    Local local2.sound
    Select arg0\Field51
        Case model_173
            If ((arg0\Field78 Or (arg0\Field0 = myplayer\Field0)) <> 0) Then
                If (0.03 <= distance(arg0\Field6, arg0\Field8, entityx(arg0\Field13, $00), entityz(arg0\Field13, $00))) Then
                    If (arg0\Field0 = myplayer\Field0) Then
                        arg0\Field53 = loopsound2(stonedragsfx, arg0\Field53, camera, arg0\Field13, 13.0, 0.8)
                        channelpan(arg0\Field53, 0.5)
                        channelvolume(arg0\Field53, (0.8 * sfxvolume))
                    Else
                        arg0\Field53 = loopsound2(stonedragsfx, arg0\Field53, camera, arg0\Field13, 13.0, 0.8)
                    EndIf
                Else
                    stopchannel(arg0\Field53)
                    arg0\Field53 = $00
                EndIf
                arg0\Field6 = entityx(arg0\Field13, $00)
                arg0\Field8 = entityz(arg0\Field13, $00)
            EndIf
        Case model_096
            If (arg0\Field54 < millisecs()) Then
                If (((arg0\Field55 = $0E) And (arg0\Field58 <> $0E)) <> 0) Then
                    If (multiplayer_isafriend(myplayer\Field51, arg0\Field51) = $00) Then
                        If (((-16.0 > blinktimer) Or (-6.0 < blinktimer)) <> 0) Then
                            If (arg0\Field78 <> 0) Then
                                If ((entityinview(camera, getplayercamera(arg0\Field0)) And entityinview(getplayercamera(arg0\Field0), camera)) <> 0) Then
                                    If (entityvisible(myhitbox, arg0\Field19) <> 0) Then
                                        playsound_strict(triggered096sfx)
                                        arg0\Field54 = (millisecs() + $7530)
                                        arg0\Field58 = $0E
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                ElseIf (((arg0\Field55 <> $0E) And (arg0\Field58 = $0E)) <> 0) Then
                    arg0\Field58 = $00
                EndIf
            EndIf
    End Select
    If (arg0\Field55 < $1E) Then
        local1 = getbreachtype(arg0\Field51)
        If (local1\Field15[$00] <> "") Then
            If ((arg0\Field78 Or (arg0\Field0 = myplayer\Field0)) <> 0) Then
                If (channelplaying(arg0\Field53) = $00) Then
                    arg0\Field53 = $00
                    For local2 = Each sound
                        If (local2\Field1 = local1\Field15[$00]) Then
                            If (arg0\Field0 = myplayer\Field0) Then
                                arg0\Field53 = playsound_strict((Handle local2))
                                channelvolume(arg0\Field53, (0.5 * sfxvolume))
                            Else
                                arg0\Field53 = play3dsound((Handle local2), camera, arg0\Field13, 13.0, 0.8, "")
                            EndIf
                            Exit
                        EndIf
                    Next
                    If (arg0\Field53 = $00) Then
                        If (arg0\Field0 = myplayer\Field0) Then
                            arg0\Field53 = playsound_strict(loadtempsound(local1\Field15[arg0\Field55]))
                            channelvolume(arg0\Field53, (0.5 * sfxvolume))
                        Else
                            arg0\Field53 = play3dsound($00, camera, arg0\Field13, 13.0, 0.8, local1\Field15[arg0\Field55])
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (local1\Field15[arg0\Field55] <> "") Then
            If ((arg0\Field78 Or (arg0\Field0 = myplayer\Field0)) <> 0) Then
                If (channelplaying(arg0\Field53) = $00) Then
                    arg0\Field53 = $00
                    For local2 = Each sound
                        If (local2\Field1 = local1\Field15[arg0\Field55]) Then
                            If (arg0\Field0 = myplayer\Field0) Then
                                arg0\Field53 = playsound_strict((Handle local2))
                                channelvolume(arg0\Field53, (0.5 * sfxvolume))
                            Else
                                arg0\Field53 = play3dsound((Handle local2), camera, arg0\Field13, 13.0, 0.8, "")
                            EndIf
                            Exit
                        EndIf
                    Next
                    If (arg0\Field53 = $00) Then
                        If (arg0\Field0 = myplayer\Field0) Then
                            arg0\Field53 = playsound_strict(loadtempsound(local1\Field15[arg0\Field55]))
                            channelvolume(arg0\Field53, (0.5 * sfxvolume))
                        Else
                            arg0\Field53 = play3dsound($00, camera, arg0\Field13, 13.0, 0.8, local1\Field15[arg0\Field55])
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    Return $00
End Function
