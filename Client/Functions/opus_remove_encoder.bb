Function opus_remove_encoder%()
    opus_encoder_destroy(opusencoder)
    opusencoder = $00
    Return $00
End Function
