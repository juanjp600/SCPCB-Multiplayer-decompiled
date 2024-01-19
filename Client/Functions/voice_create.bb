Function voice_create%(arg0%)
    If (voice\Field0 = $00) Then
        opus_set_sample_rate(arg0)
        opus_set_channels($01)
        opus_set_default_frame_size($3C0)
        opus_get_new_encoder()
        voice\Field0 = snd_format_create($01, arg0, $10, $01)
        voice\Field5 = arg0
        If (((voice_start() = $00) Or (voice\Field0 = $00)) <> 0) Then
            If (voice\Field0 <> 0) Then
                snd_format_free(voice\Field0)
                voice\Field0 = $00
            EndIf
            voice\Field3 = $00
        EndIf
    EndIf
    Return $00
End Function
