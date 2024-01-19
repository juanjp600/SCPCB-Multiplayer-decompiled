Function multiplayer_updatescps%()
    Local local0.breachtypes
    Local local2%
    Local local3.players
    Local local4%
    Local local5$
    multiplayer_updateselfscps()
    local0 = getbreachtype(myplayer\Field51)
    If (local0\Field46 = $00) Then
        Return $01
    EndIf
    Select myplayer\Field51
        Case model_096
            crouch = $00
            injuries = 0.0
            godmode = $01
            shake = 0.0
            injuries = 0.0
            blinktimer = 0.0
            local2 = $01
            For local3 = Each players
                If (((local3\Field0 <> networkserver\Field28) And (multiplayer_isafriend(myplayer\Field51, local3\Field51) = $00)) <> 0) Then
                    If (((-16.0 > local3\Field31) Or (-6.0 < local3\Field31)) <> 0) Then
                        If (local3\Field78 <> 0) Then
                            If ((entityinview(camera, getplayercamera(local3\Field0)) And entityinview(local3\Field15, camera)) <> 0) Then
                                If (entityvisible(myhitbox, local3\Field19) <> 0) Then
                                    scp\Field5[local3\Field0] = $01
                                    scp\Field4 = (millisecs() + $3A98)
                                    If ((((channelplaying(scp\Field6) = $00) And (0.0 = scp\Field7)) And (scp\Field3 = $00)) <> 0) Then
                                        scp\Field6 = playsound_strict(loadtempsound("SFX\Music\096Angered.ogg"))
                                        multiplayer_writetempsound("SFX\Music\096Angered.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                        scp\Field7 = 1890.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Next
            scp\Field7 = max(0.0, (scp\Field7 - fpsfactor))
            If (0.0 = scp\Field7) Then
                scp\Field3 = $01
                If (scp\Field4 < millisecs()) Then
                    scp\Field3 = $00
                    For local4 = $01 To networkserver\Field14 Step $01
                        scp\Field5[local4] = $00
                    Next
                EndIf
            Else
                scp\Field3 = $00
                scp\Field4 = (millisecs() + $3A98)
            EndIf
            If (((mousehit1 And scp\Field3) And (scp\Field1 < millisecs())) <> 0) Then
                If (caninteract() <> 0) Then
                    entitypick(camera, local0\Field48)
                    For local3 = Each players
                        If (scp\Field5[local3\Field0] = $01) Then
                            If ((((((local3\Field13 = pickedentity()) Or (local3\Field12 = pickedentity())) Or (local3\Field19 = pickedentity())) And (local3\Field33 = $00)) And (multiplayer_isafriend(myplayer\Field51, local3\Field51) = $00)) <> 0) Then
                                udp_bytestreamwritechar($35)
                                udp_bytestreamwritechar(local3\Field0)
                                udp_setmicrobyte($35)
                                playsound2(loadtempsound("SFX\Character\D9341\Damage5.ogg"), camera, collider, 10.0, 1.0)
                                multiplayer_writetempsound("SFX\Character\D9341\Damage5.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
                                scp\Field8 = local0\Field41
                                scp\Field1 = (millisecs() + scp\Field8)
                                jumpstate = 0.05
                                If (keydown(key_up) <> 0) Then
                                    lastzspeed = currspeed
                                EndIf
                                If (keydown(key_down) <> 0) Then
                                    lastzspeed = (- currspeed)
                                EndIf
                                If (keydown(key_left) <> 0) Then
                                    lastxspeed = (- currspeed)
                                EndIf
                                If (keydown(key_right) <> 0) Then
                                    lastxspeed = currspeed
                                EndIf
                                scp\Field5[local4] = $00
                                Exit
                            EndIf
                        EndIf
                    Next
                EndIf
            EndIf
            Return $01
        Case model_173
            crouch = $00
            injuries = 0.0
            godmode = $01
            shake = 0.0
            superman = $01
            injuries = 0.0
            blinktimer = 0.0
            local2 = $01
            For local3 = Each players
                If (((local3\Field0 <> networkserver\Field28) And (multiplayer_isafriend(myplayer\Field51, local3\Field51) = $00)) <> 0) Then
                    If (((-16.0 > local3\Field31) Or (-6.0 < local3\Field31)) <> 0) Then
                        If (local3\Field78 <> 0) Then
                            If (entityinview(myhitbox, getplayercamera(local3\Field0)) <> 0) Then
                                If (entityvisible(myhitbox, local3\Field19) <> 0) Then
                                    local2 = $00
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local2 = $00) Then
                        Exit
                    EndIf
                EndIf
            Next
            If (((mousehit1 And (local2 = $01)) And (scp\Field1 < millisecs())) <> 0) Then
                If (caninteract() <> 0) Then
                    entitypick(camera, local0\Field48)
                    For local3 = Each players
                        If ((((((local3\Field13 = pickedentity()) Or (local3\Field12 = pickedentity())) Or (local3\Field19 = pickedentity())) And (local3\Field33 = $00)) And (multiplayer_isafriend(myplayer\Field51, local3\Field51) = $00)) <> 0) Then
                            udp_bytestreamwritechar($35)
                            udp_bytestreamwritechar(local3\Field0)
                            udp_setmicrobyte($35)
                            playsound2(loadtempsound((("SFX\SCP\173\NeckSnap" + (Str rand($01, $02))) + ".ogg")), camera, collider, 10.0, 1.0)
                            multiplayer_writetempsound((("SFX\SCP\173\NeckSnap" + (Str rand($01, $02))) + ".ogg"), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                            scp\Field8 = local0\Field41
                            scp\Field1 = (millisecs() + scp\Field8)
                            Exit
                        EndIf
                    Next
                EndIf
            EndIf
            If (local2 = $00) Then
                If (-361.0 = savedangle) Then
                    savedangle = entityyaw(collider, $00)
                EndIf
            Else
                savedangle = -361.0
            EndIf
            Return local2
        Default
            godmode = (local0\Field34 = $00)
            If (local0\Field33 <> 0) Then
                crouch = $00
            EndIf
            If (local0\Field35 <> 0) Then
                injuries = 0.0
            EndIf
            If (caninteract() <> 0) Then
                If (local0\Field39 <> "") Then
                    If ((mousehit2 And (millisecs() > scp\Field0)) <> 0) Then
                        scp\Field0 = (millisecs() + local0\Field40)
                        If (local0\Field57 > $00) Then
                            local5 = replace(local0\Field39, ".", "0.")
                            If (filesize(local5) = $00) Then
                                local5 = replace(local0\Field39, ".", ((Str rand($01, local0\Field57)) + "."))
                            Else
                                local5 = replace(local0\Field39, ".", ((Str rand($00, local0\Field57)) + "."))
                            EndIf
                            playsound_strict(loadtempsound(local5))
                            multiplayer_writetempsound(local5, 0.0, 0.0, 0.0, 10.0, 1.0)
                        Else
                            playsound_strict(loadtempsound(local0\Field39))
                            multiplayer_writetempsound(local0\Field39, 0.0, 0.0, 0.0, 10.0, 1.0)
                        EndIf
                    EndIf
                EndIf
                If (local0\Field47 > $00) Then
                    If ((mousehit1 And (scp\Field1 < millisecs())) <> 0) Then
                        entitypick(camera, local0\Field48)
                        For local3 = Each players
                            If ((((((local3\Field13 = pickedentity()) Or (local3\Field12 = pickedentity())) Or (local3\Field19 = pickedentity())) And (local3\Field33 = $00)) And (multiplayer_isafriend(myplayer\Field51, local3\Field51) = $00)) <> 0) Then
                                If (local0\Field49 <> 0) Then
                                    playsound_strict(loadtempsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg")))
                                    multiplayer_writetempsound((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"), 0.0, 0.0, 0.0, 10.0, 1.0)
                                EndIf
                                If (local0\Field47 = $01) Then
                                    udp_bytestreamwritechar($2E)
                                Else
                                    udp_bytestreamwritechar($35)
                                EndIf
                                udp_bytestreamwritechar(local3\Field0)
                                udp_setmicrobyte($2E)
                                udp_setmicrobyte($35)
                                scp\Field8 = local0\Field41
                                scp\Field1 = (millisecs() + scp\Field8)
                                player_move_timed = $0F
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
            EndIf
            Return $01
    End Select
    Return $00
End Function
