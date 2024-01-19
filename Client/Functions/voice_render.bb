Function voice_render%(arg0%, arg1%, arg2%)
    If (((snd_in_readavail(voice\Field2) >= arg0) Or (arg2 <> $00)) <> 0) Then
        If (arg1 = $00) Then
            If (((snd_in_readavail(voice\Field2) >= (arg0 Shl $03)) Or (arg2 <> $00)) <> 0) Then
                If (arg2 = $00) Then
                    arg0 = (Int min((Float snd_in_readavail(voice\Field2)), (Float (arg0 Shl $04))))
                    arg2 = createbank(arg0)
                    snd_in_read(voice\Field2, arg2, banksize(arg2))
                EndIf
                voice_countoffset(arg2)
                voice_wave_create($00, arg2, voice\Field6, $00)
                freebank(arg2)
            EndIf
        ElseIf (udp_network\Field0 <> $00) Then
            If (0.0 = ((Float snd_in_readavail(voice\Field2)) Mod (Float (opus_get_default_frame_size() Shl $01)))) Then
                arg0 = (Int min((Float snd_in_readavail(voice\Field2)), (Float (arg0 Shl $02))))
            EndIf
            If (arg2 = $00) Then
                arg2 = createbank(arg0)
                snd_in_read(voice\Field2, arg2, banksize(arg2))
                voice_countoffset(arg2)
            EndIf
            voice_send(arg2, $00)
            freebank(arg2)
            playersoundvolume = max(4.0, playersoundvolume)
        EndIf
        If (snd_in_readavail(voice\Field2) >= (arg0 Shl $04)) Then
            voice_clear(snd_in_readavail(voice\Field2))
        EndIf
        Return $01
    EndIf
    Return $00
    Return $00
End Function
