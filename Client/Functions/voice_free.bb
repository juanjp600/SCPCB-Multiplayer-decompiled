Function voice_free%()
    If (voice\Field0 <> $00) Then
        opus_remove_encoder()
        voice_stop()
        snd_format_free(voice\Field0)
        voice\Field0 = $00
    EndIf
    Return $00
End Function
