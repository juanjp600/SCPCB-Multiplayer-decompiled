Function voice_stop%()
    If (voice\Field2 <> $00) Then
        voice_clear(snd_in_readavail(voice\Field2))
        snd_in_flush(voice\Field2)
        snd_in_stop(voice\Field2)
        voice\Field2 = $00
    EndIf
    Return $00
End Function
