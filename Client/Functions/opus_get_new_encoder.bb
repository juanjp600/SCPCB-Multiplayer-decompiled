Function opus_get_new_encoder%()
    If (opusencoder <> $00) Then
        opus_remove_encoder()
    EndIf
    opusencoder = opus_encoder_create(opus_get_sample_rate(), opus_get_channels(), opus_get_type(), $00)
    Return opusencoder
    Return $00
End Function
