Function voice_recording%(arg0%, arg1%)
    Local local0%
    Local local1%
    If (voice\Field3 <> $00) Then
        local0 = $00
        local1 = voice_getbytes()
        If (voice\Field14 <> 0) Then
            If (arg1 = $00) Then
                If (snd_in_readavail(voice\Field2) >= local1) Then
                    If (0.0 = ((Float snd_in_readavail(voice\Field2)) Mod (Float (opus_get_default_frame_size() Shl $01)))) Then
                        local1 = (Int min((Float snd_in_readavail(voice\Field2)), (Float (local1 Shl $02))))
                    EndIf
                    local0 = createbank(local1)
                    snd_in_read(voice\Field2, local0, banksize(local0))
                    voice_countoffset(local0)
                    arg0 = (0.8 < voice_get_offset())
                EndIf
            EndIf
        EndIf
        voice\Field7 = max(0.0, (voice\Field7 - fpsfactor))
        If (((arg0 = $00) And (voice\Field8 = $01)) <> 0) Then
            voice\Field7 = (Float ((arg1 = $00) * $0A))
        EndIf
        If (((arg0 = $01) And (voice\Field8 = $00)) <> 0) Then
            voice\Field7 = 0.0
        EndIf
        If (arg0 <> 0) Then
            voice_render(voice_getbytes(), (arg1 = $00), local0)
            voice\Field4 = $01
        ElseIf (0.0 < voice\Field7) Then
            voice_render(voice_getbytes(), (arg1 = $00), local0)
        ElseIf (voice\Field14 = $00) Then
            If ((voice\Field4 And (udp_getstream() <> $00)) <> 0) Then
                voice_send($00, $01)
            EndIf
            voice\Field4 = $00
            voice_clear(snd_in_readavail(voice\Field2))
        ElseIf (arg0 = $00) Then
            voice\Field4 = $00
        EndIf
        voice\Field8 = ((arg1 = $00) * arg0)
    Else
        voice\Field4 = $00
    EndIf
    If (arg1 <> 0) Then
        voice\Field4 = $00
    EndIf
    Return $00
End Function
