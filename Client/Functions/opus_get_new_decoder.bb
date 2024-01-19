Function opus_get_new_decoder%()
    Return opus_decoder_create(opus_get_sample_rate(), opus_get_channels(), $00)
    Return $00
End Function
